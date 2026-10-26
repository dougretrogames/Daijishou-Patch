package org.eclipse.jgit.internal.storage.file;

import androidx.compose.runtime.CompositionImpl$$ExternalSyntheticBackportWithForwarding0;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.errors.PackMismatchException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.commitgraph.CommitGraph;
import org.eclipse.jgit.internal.storage.pack.ObjectToPack;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.internal.storage.pack.PackWriter;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.CoreConfig;
import org.eclipse.jgit.lib.ObjectDatabase;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.RepositoryCache;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.FileUtils;

/* INFO: loaded from: classes5.dex */
public class ObjectDirectory extends FileObjectDatabase {
    private static final int RESOLVE_ABBREV_LIMIT = 256;
    private final AtomicReference<AlternateHandle[]> alternates;
    private final File alternatesFile;
    private final Config config;
    private final FileCommitGraph fileCommitGraph;
    private final FS fs;
    private final File infoDirectory;
    private final LooseObjects loose;
    private final File objects;
    private final PackDirectory packed;
    private final PackDirectory preserved;
    private Set<ObjectId> shallowCommitsIds;
    private final File shallowFile;
    private final AlternateHandle handle = new AlternateHandle(this);
    private FileSnapshot shallowFileSnapshot = FileSnapshot.DIRTY;

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase, org.eclipse.jgit.lib.ObjectDatabase
    public /* bridge */ /* synthetic */ ObjectReader newReader() {
        return super.newReader();
    }

    public ObjectDirectory(Config config, File file, File[] fileArr, FS fs, File file2) throws IOException {
        this.config = config;
        this.objects = file;
        this.infoDirectory = new File(file, "info");
        File file3 = new File(file, ConfigConstants.CONFIG_PACK_SECTION);
        File file4 = new File(file3, "preserved");
        this.alternatesFile = new File(file, Constants.INFO_ALTERNATES);
        this.loose = new LooseObjects(config, file);
        this.packed = new PackDirectory(config, file3);
        this.preserved = new PackDirectory(config, file4);
        this.fileCommitGraph = new FileCommitGraph(file);
        this.fs = fs;
        this.shallowFile = file2;
        this.alternates = new AtomicReference<>();
        if (fileArr != null) {
            AlternateHandle[] alternateHandleArr = new AlternateHandle[fileArr.length];
            for (int i = 0; i < fileArr.length; i++) {
                alternateHandleArr[i] = openAlternate(fileArr[i]);
            }
            this.alternates.set(alternateHandleArr);
        }
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    public final File getDirectory() {
        return this.loose.getDirectory();
    }

    public final File getPackDirectory() {
        return this.packed.getDirectory();
    }

    public final File getPreservedDirectory() {
        return this.preserved.getDirectory();
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase
    public boolean exists() {
        return this.fs.exists(this.objects);
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase
    public void create() throws IOException {
        this.loose.create();
        FileUtils.mkdir(this.infoDirectory);
        this.packed.create();
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase, org.eclipse.jgit.lib.ObjectDatabase
    public ObjectDirectoryInserter newInserter() {
        return new ObjectDirectoryInserter(this, this.config);
    }

    public PackInserter newPackInserter() {
        return new PackInserter(this);
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase, java.lang.AutoCloseable
    public void close() {
        this.loose.close();
        this.packed.close();
        AlternateHandle[] alternateHandleArr = this.alternates.get();
        if (alternateHandleArr == null || !CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.alternates, alternateHandleArr, null)) {
            return;
        }
        for (AlternateHandle alternateHandle : alternateHandleArr) {
            alternateHandle.close();
        }
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    public Collection<Pack> getPacks() {
        return this.packed.getPacks();
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase
    public long getApproximateObjectCount() {
        Iterator<Pack> it = getPacks().iterator();
        long objectCount = 0;
        while (it.hasNext()) {
            try {
                objectCount += it.next().m5707lambda$1$orgeclipsejgitinternalstoragefilePack().getObjectCount();
            } catch (IOException unused) {
                return -1L;
            }
        }
        return objectCount;
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    public Optional<CommitGraph> getCommitGraph() {
        if (((CoreConfig) this.config.get(CoreConfig.KEY)).enableCommitGraph()) {
            return Optional.ofNullable(this.fileCommitGraph.get());
        }
        return Optional.empty();
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    public Pack openPack(File file) throws IOException {
        try {
            PackFile packFile = new PackFile(file);
            String name = packFile.getName();
            if (name.length() != 50 || !name.startsWith("pack-") || !packFile.getPackExt().equals(PackExt.PACK)) {
                throw new IOException(MessageFormat.format(JGitText.get().notAValidPack, file));
            }
            PackFile packFileCreate = packFile.create(PackExt.BITMAP_INDEX);
            Config config = this.config;
            if (!packFileCreate.exists()) {
                packFileCreate = null;
            }
            Pack pack = new Pack(config, file, packFileCreate);
            this.packed.insert(pack);
            return pack;
        } catch (IllegalArgumentException e) {
            throw new IOException(MessageFormat.format(JGitText.get().notAValidPack, file), e);
        }
    }

    public String toString() {
        return "ObjectDirectory[" + String.valueOf(getDirectory()) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase
    public boolean has(AnyObjectId anyObjectId) {
        if (this.loose.hasCached(anyObjectId) || hasPackedOrLooseInSelfOrAlternate(anyObjectId)) {
            return true;
        }
        return restoreFromSelfOrAlternate(anyObjectId, null) && hasPackedOrLooseInSelfOrAlternate(anyObjectId);
    }

    private boolean hasPackedOrLooseInSelfOrAlternate(AnyObjectId anyObjectId) {
        return hasPackedInSelfOrAlternate(anyObjectId, null) || hasLooseInSelfOrAlternate(anyObjectId, null);
    }

    private boolean hasPackedInSelfOrAlternate(AnyObjectId anyObjectId, Set<AlternateHandle.Id> set) {
        if (hasPackedObject(anyObjectId)) {
            return true;
        }
        Set<AlternateHandle.Id> setAddMe = addMe(set);
        for (AlternateHandle alternateHandle : myAlternates()) {
            if (!setAddMe.contains(alternateHandle.getId()) && alternateHandle.db.hasPackedInSelfOrAlternate(anyObjectId, setAddMe)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLooseInSelfOrAlternate(AnyObjectId anyObjectId, Set<AlternateHandle.Id> set) {
        if (this.loose.has(anyObjectId)) {
            return true;
        }
        Set<AlternateHandle.Id> setAddMe = addMe(set);
        for (AlternateHandle alternateHandle : myAlternates()) {
            if (!setAddMe.contains(alternateHandle.getId()) && alternateHandle.db.hasLooseInSelfOrAlternate(anyObjectId, setAddMe)) {
                return true;
            }
        }
        return false;
    }

    boolean hasPackedObject(AnyObjectId anyObjectId) {
        return this.packed.has(anyObjectId);
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    void resolve(Set<ObjectId> set, AbbreviatedObjectId abbreviatedObjectId) throws IOException {
        resolve(set, abbreviatedObjectId, null);
    }

    private void resolve(Set<ObjectId> set, AbbreviatedObjectId abbreviatedObjectId, Set<AlternateHandle.Id> set2) throws IOException {
        if (this.packed.resolve(set, abbreviatedObjectId, 256) && this.loose.resolve(set, abbreviatedObjectId, 256)) {
            Set<AlternateHandle.Id> setAddMe = addMe(set2);
            for (AlternateHandle alternateHandle : myAlternates()) {
                if (!setAddMe.contains(alternateHandle.getId())) {
                    alternateHandle.db.resolve(set, abbreviatedObjectId, setAddMe);
                    if (set.size() > 256) {
                        return;
                    }
                }
            }
        }
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    ObjectLoader openObject(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException {
        ObjectLoader objectLoaderOpenObjectWithoutRestoring = openObjectWithoutRestoring(windowCursor, anyObjectId);
        return (objectLoaderOpenObjectWithoutRestoring == null && restoreFromSelfOrAlternate(anyObjectId, null)) ? openObjectWithoutRestoring(windowCursor, anyObjectId) : objectLoaderOpenObjectWithoutRestoring;
    }

    private ObjectLoader openObjectWithoutRestoring(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException {
        ObjectLoader objectLoaderOpenLooseObject;
        if (this.loose.hasCached(anyObjectId) && (objectLoaderOpenLooseObject = openLooseObject(windowCursor, anyObjectId)) != null) {
            return objectLoaderOpenLooseObject;
        }
        ObjectLoader objectLoaderOpenPackedFromSelfOrAlternate = openPackedFromSelfOrAlternate(windowCursor, anyObjectId, null);
        return objectLoaderOpenPackedFromSelfOrAlternate != null ? objectLoaderOpenPackedFromSelfOrAlternate : openLooseFromSelfOrAlternate(windowCursor, anyObjectId, null);
    }

    private ObjectLoader openPackedFromSelfOrAlternate(WindowCursor windowCursor, AnyObjectId anyObjectId, Set<AlternateHandle.Id> set) throws PackMismatchException {
        ObjectLoader objectLoaderOpenPackedFromSelfOrAlternate;
        ObjectLoader objectLoaderOpenPackedObject = openPackedObject(windowCursor, anyObjectId);
        if (objectLoaderOpenPackedObject != null) {
            return objectLoaderOpenPackedObject;
        }
        Set<AlternateHandle.Id> setAddMe = addMe(set);
        for (AlternateHandle alternateHandle : myAlternates()) {
            if (!setAddMe.contains(alternateHandle.getId()) && (objectLoaderOpenPackedFromSelfOrAlternate = alternateHandle.db.openPackedFromSelfOrAlternate(windowCursor, anyObjectId, setAddMe)) != null) {
                return objectLoaderOpenPackedFromSelfOrAlternate;
            }
        }
        return null;
    }

    private ObjectLoader openLooseFromSelfOrAlternate(WindowCursor windowCursor, AnyObjectId anyObjectId, Set<AlternateHandle.Id> set) throws IOException {
        ObjectLoader objectLoaderOpenLooseFromSelfOrAlternate;
        ObjectLoader objectLoaderOpenLooseObject = openLooseObject(windowCursor, anyObjectId);
        if (objectLoaderOpenLooseObject != null) {
            return objectLoaderOpenLooseObject;
        }
        Set<AlternateHandle.Id> setAddMe = addMe(set);
        for (AlternateHandle alternateHandle : myAlternates()) {
            if (!setAddMe.contains(alternateHandle.getId()) && (objectLoaderOpenLooseFromSelfOrAlternate = alternateHandle.db.openLooseFromSelfOrAlternate(windowCursor, anyObjectId, setAddMe)) != null) {
                return objectLoaderOpenLooseFromSelfOrAlternate;
            }
        }
        return null;
    }

    ObjectLoader openPackedObject(WindowCursor windowCursor, AnyObjectId anyObjectId) throws PackMismatchException {
        return this.packed.open(windowCursor, anyObjectId);
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    ObjectLoader openLooseObject(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException {
        return this.loose.open(windowCursor, anyObjectId);
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    long getObjectSize(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException {
        long objectSizeWithoutRestoring = getObjectSizeWithoutRestoring(windowCursor, anyObjectId);
        return (0 <= objectSizeWithoutRestoring || !restoreFromSelfOrAlternate(anyObjectId, null)) ? objectSizeWithoutRestoring : getObjectSizeWithoutRestoring(windowCursor, anyObjectId);
    }

    private long getObjectSizeWithoutRestoring(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException {
        if (this.loose.hasCached(anyObjectId)) {
            long size = this.loose.getSize(windowCursor, anyObjectId);
            if (0 <= size) {
                return size;
            }
        }
        long packedSizeFromSelfOrAlternate = getPackedSizeFromSelfOrAlternate(windowCursor, anyObjectId, null);
        return 0 <= packedSizeFromSelfOrAlternate ? packedSizeFromSelfOrAlternate : getLooseSizeFromSelfOrAlternate(windowCursor, anyObjectId, null);
    }

    private long getPackedSizeFromSelfOrAlternate(WindowCursor windowCursor, AnyObjectId anyObjectId, Set<AlternateHandle.Id> set) throws PackMismatchException {
        long size = this.packed.getSize(windowCursor, anyObjectId);
        if (0 <= size) {
            return size;
        }
        Set<AlternateHandle.Id> setAddMe = addMe(set);
        for (AlternateHandle alternateHandle : myAlternates()) {
            if (!setAddMe.contains(alternateHandle.getId())) {
                long packedSizeFromSelfOrAlternate = alternateHandle.db.getPackedSizeFromSelfOrAlternate(windowCursor, anyObjectId, setAddMe);
                if (0 <= packedSizeFromSelfOrAlternate) {
                    return packedSizeFromSelfOrAlternate;
                }
            }
        }
        return -1L;
    }

    private long getLooseSizeFromSelfOrAlternate(WindowCursor windowCursor, AnyObjectId anyObjectId, Set<AlternateHandle.Id> set) throws IOException {
        long size = this.loose.getSize(windowCursor, anyObjectId);
        if (0 <= size) {
            return size;
        }
        Set<AlternateHandle.Id> setAddMe = addMe(set);
        for (AlternateHandle alternateHandle : myAlternates()) {
            if (!setAddMe.contains(alternateHandle.getId())) {
                long looseSizeFromSelfOrAlternate = alternateHandle.db.getLooseSizeFromSelfOrAlternate(windowCursor, anyObjectId, setAddMe);
                if (0 <= looseSizeFromSelfOrAlternate) {
                    return looseSizeFromSelfOrAlternate;
                }
            }
        }
        return -1L;
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    void selectObjectRepresentation(PackWriter packWriter, ObjectToPack objectToPack, WindowCursor windowCursor) throws IOException {
        selectObjectRepresentation(packWriter, objectToPack, windowCursor, null);
    }

    private void selectObjectRepresentation(PackWriter packWriter, ObjectToPack objectToPack, WindowCursor windowCursor, Set<AlternateHandle.Id> set) throws IOException {
        this.packed.selectRepresentation(packWriter, objectToPack, windowCursor);
        Set<AlternateHandle.Id> setAddMe = addMe(set);
        for (AlternateHandle alternateHandle : myAlternates()) {
            if (!setAddMe.contains(alternateHandle.getId())) {
                alternateHandle.db.selectObjectRepresentation(packWriter, objectToPack, windowCursor, setAddMe);
            }
        }
    }

    private boolean restoreFromSelfOrAlternate(AnyObjectId anyObjectId, Set<AlternateHandle.Id> set) {
        if (restoreFromSelf(anyObjectId)) {
            return true;
        }
        Set<AlternateHandle.Id> setAddMe = addMe(set);
        for (AlternateHandle alternateHandle : myAlternates()) {
            if (!setAddMe.contains(alternateHandle.getId()) && alternateHandle.db.restoreFromSelfOrAlternate(anyObjectId, setAddMe)) {
                return true;
            }
        }
        return false;
    }

    private boolean restoreFromSelf(AnyObjectId anyObjectId) {
        Pack pack = this.preserved.getPack(anyObjectId);
        if (pack == null) {
            return false;
        }
        PackFile packFile = new PackFile(pack.getPackFile());
        for (PackExt packExt : PackExt.valuesCustom()) {
            if (!PackExt.INDEX.equals(packExt)) {
                restore(packFile.create(packExt));
            }
        }
        restore(packFile.create(PackExt.INDEX));
        return true;
    }

    private boolean restore(PackFile packFile) {
        try {
            Files.createLink(packFile.createForDirectory(this.packed.getDirectory()).toPath(), packFile.toPath());
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    FileObjectDatabase.InsertLooseObjectResult insertUnpackedObject(File file, ObjectId objectId, boolean z) throws IOException {
        if (this.loose.hasCached(objectId)) {
            FileUtils.delete(file, 6);
            return FileObjectDatabase.InsertLooseObjectResult.EXISTS_LOOSE;
        }
        if (!z && has(objectId)) {
            FileUtils.delete(file, 6);
            return FileObjectDatabase.InsertLooseObjectResult.EXISTS_PACKED;
        }
        return this.loose.insert(file, objectId);
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    Config getConfig() {
        return this.config;
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    FS getFS() {
        return this.fs;
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase
    public Set<ObjectId> getShallowCommits() throws IOException {
        File file = this.shallowFile;
        if (file == null || !file.isFile()) {
            return Collections.emptySet();
        }
        FileSnapshot fileSnapshot = this.shallowFileSnapshot;
        if (fileSnapshot == null || fileSnapshot.isModified(this.shallowFile)) {
            try {
                this.shallowCommitsIds = (Set) FileUtils.readWithRetries(this.shallowFile, new ObjectDirectory$$ExternalSyntheticLambda0(this));
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new IOException(MessageFormat.format(JGitText.get().readShallowFailed, this.shallowFile.getAbsolutePath()), e2);
            }
        }
        return this.shallowCommitsIds;
    }

    /* INFO: renamed from: lambda$0$org-eclipse-jgit-internal-storage-file-ObjectDirectory, reason: not valid java name */
    /* synthetic */ HashSet m5706lambda$0$orgeclipsejgitinternalstoragefileObjectDirectory(File file) throws Exception {
        FileSnapshot fileSnapshotSave = FileSnapshot.save(file);
        HashSet hashSet = new HashSet();
        Throwable th = null;
        try {
            BufferedReader bufferedReaderOpen = open(file);
            while (true) {
                try {
                    String line = bufferedReaderOpen.readLine();
                    if (line != null) {
                        if (!ObjectId.isId(line)) {
                            throw new IOException(MessageFormat.format(JGitText.get().badShallowLine, file.getAbsolutePath(), line));
                        }
                        hashSet.add(ObjectId.fromString(line));
                    } else {
                        if (bufferedReaderOpen != null) {
                            bufferedReaderOpen.close();
                        }
                        this.shallowFileSnapshot = fileSnapshotSave;
                        return hashSet;
                    }
                } catch (Throwable th2) {
                    if (bufferedReaderOpen == null) {
                        throw th2;
                    }
                    bufferedReaderOpen.close();
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                th.addSuppressed(th3);
            }
            throw null;
        }
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase
    public void setShallowCommits(Set<ObjectId> set) throws IOException {
        this.shallowCommitsIds = set;
        LockFile lockFile = new LockFile(this.shallowFile);
        if (!lockFile.lock()) {
            throw new IOException(MessageFormat.format(JGitText.get().lockError, this.shallowFile.getAbsolutePath()));
        }
        try {
            if (set.isEmpty()) {
                if (this.shallowFile.isFile()) {
                    this.shallowFile.delete();
                }
            } else {
                Throwable th = null;
                try {
                    OutputStream outputStream = lockFile.getOutputStream();
                    try {
                        Iterator<ObjectId> it = set.iterator();
                        while (it.hasNext()) {
                            byte[] bArr = new byte[41];
                            it.next().copyTo(bArr, 0);
                            bArr[40] = 10;
                            outputStream.write(bArr);
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        lockFile.commit();
                    } catch (Throwable th2) {
                        if (outputStream == null) {
                            throw th2;
                        }
                        outputStream.close();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    if (0 == 0) {
                        throw th3;
                    }
                    if (null != th3) {
                        try {
                            th.addSuppressed(th3);
                        } catch (Throwable th4) {
                            lockFile.commit();
                            throw th4;
                        }
                    }
                    throw null;
                }
            }
            lockFile.unlock();
            if (set.isEmpty()) {
                this.shallowFileSnapshot = FileSnapshot.DIRTY;
            } else {
                this.shallowFileSnapshot = FileSnapshot.save(this.shallowFile);
            }
        } catch (Throwable th5) {
            lockFile.unlock();
            throw th5;
        }
    }

    void closeAllPackHandles(File file) {
        if (file.exists()) {
            for (Pack pack : this.packed.getPacks()) {
                if (file.getPath().equals(pack.getPackFile().getPath())) {
                    pack.close();
                    return;
                }
            }
        }
    }

    AlternateHandle[] myAlternates() {
        AlternateHandle[] alternateHandleArrLoadAlternates;
        AlternateHandle[] alternateHandleArr = this.alternates.get();
        if (alternateHandleArr != null) {
            return alternateHandleArr;
        }
        synchronized (this.alternates) {
            alternateHandleArrLoadAlternates = this.alternates.get();
            if (alternateHandleArrLoadAlternates == null) {
                try {
                    alternateHandleArrLoadAlternates = loadAlternates();
                } catch (IOException unused) {
                    alternateHandleArrLoadAlternates = new AlternateHandle[0];
                }
                this.alternates.set(alternateHandleArrLoadAlternates);
            }
        }
        return alternateHandleArrLoadAlternates;
    }

    Set<AlternateHandle.Id> addMe(Set<AlternateHandle.Id> set) {
        if (set == null) {
            set = new HashSet<>();
        }
        set.add(this.handle.getId());
        return set;
    }

    private AlternateHandle[] loadAlternates() throws IOException {
        ArrayList arrayList = new ArrayList(4);
        Throwable th = null;
        try {
            BufferedReader bufferedReaderOpen = open(this.alternatesFile);
            while (true) {
                try {
                    String line = bufferedReaderOpen.readLine();
                    if (line == null) {
                        break;
                    }
                    arrayList.add(openAlternate(line));
                } catch (Throwable th2) {
                    if (bufferedReaderOpen == null) {
                        throw th2;
                    }
                    bufferedReaderOpen.close();
                    throw th2;
                }
            }
            if (bufferedReaderOpen != null) {
                bufferedReaderOpen.close();
            }
            return (AlternateHandle[]) arrayList.toArray(new AlternateHandle[0]);
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                th.addSuppressed(th3);
            }
            throw null;
        }
    }

    private static BufferedReader open(File file) throws IOException {
        return Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
    }

    private AlternateHandle openAlternate(String str) throws IOException {
        return openAlternate(this.fs.resolve(this.objects, str));
    }

    private AlternateHandle openAlternate(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (RepositoryCache.FileKey.isGitRepository(parentFile, this.fs)) {
            return new AlternateRepository((FileRepository) RepositoryCache.open(RepositoryCache.FileKey.exact(parentFile, this.fs)));
        }
        return new AlternateHandle(new ObjectDirectory(this.config, file, null, this.fs, null));
    }

    @Override // org.eclipse.jgit.internal.storage.file.FileObjectDatabase
    public File fileFor(AnyObjectId anyObjectId) {
        return this.loose.fileFor(anyObjectId);
    }

    static class AlternateHandle {
        final ObjectDirectory db;

        /* INFO: renamed from: id, reason: collision with root package name */
        private Id f120id;

        static class Id {
            private final String alternateId;

            public Id(File file) {
                String string;
                try {
                    string = file.toPath().toRealPath(new LinkOption[0]).normalize().toString();
                } catch (Exception unused) {
                    string = null;
                }
                this.alternateId = string;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj == null || !(obj instanceof Id)) {
                    return false;
                }
                return Objects.equals(this.alternateId, ((Id) obj).alternateId);
            }

            public int hashCode() {
                String str = this.alternateId;
                if (str == null) {
                    return 1;
                }
                return str.hashCode();
            }
        }

        AlternateHandle(ObjectDirectory objectDirectory) {
            this.db = objectDirectory;
        }

        void close() {
            this.db.close();
        }

        public synchronized Id getId() {
            if (this.f120id == null) {
                this.f120id = new Id(this.db.objects);
            }
            return this.f120id;
        }
    }

    static class AlternateRepository extends AlternateHandle {
        final FileRepository repository;

        AlternateRepository(FileRepository fileRepository) {
            super(fileRepository.getObjectDatabase());
            this.repository = fileRepository;
        }

        @Override // org.eclipse.jgit.internal.storage.file.ObjectDirectory.AlternateHandle
        void close() {
            this.repository.close();
        }
    }

    @Override // org.eclipse.jgit.lib.ObjectDatabase
    public ObjectDatabase newCachedDatabase() {
        return newCachedFileObjectDatabase();
    }

    CachedObjectDirectory newCachedFileObjectDatabase() {
        return new CachedObjectDirectory(this);
    }

    AlternateHandle.Id getAlternateId() {
        return this.handle.getId();
    }

    File getInfoDirectory() {
        return this.infoDirectory;
    }
}
