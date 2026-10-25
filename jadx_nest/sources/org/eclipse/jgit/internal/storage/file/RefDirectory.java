package org.eclipse.jgit.internal.storage.file;

import androidx.compose.runtime.CompositionImpl$$ExternalSyntheticBackportWithForwarding0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.api.PackRefsCommand;
import org.eclipse.jgit.errors.InvalidObjectIdException;
import org.eclipse.jgit.errors.LockFailedException;
import org.eclipse.jgit.errors.ObjectWritingException;
import org.eclipse.jgit.events.RefsChangedEvent;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.CoreConfig;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdRef;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefComparator;
import org.eclipse.jgit.lib.RefDatabase;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.RefWriter;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.SymbolicRef;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevTag;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.FileUtils;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.RawParseUtils;
import org.eclipse.jgit.util.RefList;
import org.eclipse.jgit.util.RefMap;
import org.eclipse.jgit.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class RefDirectory extends RefDatabase {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$TrustPackedRefsStat = null;
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String PACKED_REFS_HEADER = "# pack-refs with:";
    public static final String PACKED_REFS_PEELED = " peeled";
    public static final String SYMREF = "ref: ";
    private final File gitCommonDir;
    private final File gitDir;
    final ReentrantLock inProcessPackedRefsLock;
    private final AtomicInteger lastNotifiedModCnt;
    final File logsDir;
    final File logsRefsDir;
    private final AtomicReference<RefList<LooseRef>> looseRefs;
    private final AtomicInteger modCnt;
    final AtomicReference<PackedRefList> packedRefs;
    final File packedRefsFile;
    private final FileRepository parent;
    final File refsDir;
    private List<Integer> retrySleepMs;
    private final boolean trustFolderStat;
    private final CoreConfig.TrustLooseRefStat trustLooseRefStat;
    private final CoreConfig.TrustPackedRefsStat trustPackedRefsStat;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) RefDirectory.class);
    private static final List<Integer> RETRY_SLEEP_MS = Collections.unmodifiableList(Arrays.asList(0, 100, 200, 400, 800, 1600));
    private static final PackedRefList NO_PACKED_REFS = new PackedRefList(RefList.emptyList(), FileSnapshot.MISSING_FILE, ObjectId.zeroId(), null);

    private interface LooseRef extends Ref {
        FileSnapshot getSnapShot();

        LooseRef peel(ObjectIdRef objectIdRef);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RefList<Ref> upcast(RefList<? extends Ref> refList) {
        return refList;
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public boolean performsAtomicTransactions() {
        return true;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$TrustPackedRefsStat() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$TrustPackedRefsStat;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[CoreConfig.TrustPackedRefsStat.valuesCustom().length];
        try {
            iArr2[CoreConfig.TrustPackedRefsStat.AFTER_OPEN.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[CoreConfig.TrustPackedRefsStat.ALWAYS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[CoreConfig.TrustPackedRefsStat.NEVER.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[CoreConfig.TrustPackedRefsStat.UNSET.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$TrustPackedRefsStat = iArr2;
        return iArr2;
    }

    RefDirectory(RefDirectory refDirectory) {
        AtomicReference<RefList<LooseRef>> atomicReference = new AtomicReference<>();
        this.looseRefs = atomicReference;
        AtomicReference<PackedRefList> atomicReference2 = new AtomicReference<>();
        this.packedRefs = atomicReference2;
        this.modCnt = new AtomicInteger();
        this.lastNotifiedModCnt = new AtomicInteger();
        this.retrySleepMs = RETRY_SLEEP_MS;
        this.parent = refDirectory.parent;
        this.gitDir = refDirectory.gitDir;
        this.gitCommonDir = refDirectory.gitCommonDir;
        this.refsDir = refDirectory.refsDir;
        this.logsDir = refDirectory.logsDir;
        this.logsRefsDir = refDirectory.logsRefsDir;
        this.packedRefsFile = refDirectory.packedRefsFile;
        atomicReference.set(refDirectory.looseRefs.get());
        atomicReference2.set(refDirectory.packedRefs.get());
        this.trustFolderStat = refDirectory.trustFolderStat;
        this.trustPackedRefsStat = refDirectory.trustPackedRefsStat;
        this.trustLooseRefStat = refDirectory.trustLooseRefStat;
        this.inProcessPackedRefsLock = refDirectory.inProcessPackedRefsLock;
    }

    RefDirectory(FileRepository fileRepository) {
        AtomicReference<RefList<LooseRef>> atomicReference = new AtomicReference<>();
        this.looseRefs = atomicReference;
        AtomicReference<PackedRefList> atomicReference2 = new AtomicReference<>();
        this.packedRefs = atomicReference2;
        this.modCnt = new AtomicInteger();
        this.lastNotifiedModCnt = new AtomicInteger();
        this.retrySleepMs = RETRY_SLEEP_MS;
        FS fs = fileRepository.getFS();
        this.parent = fileRepository;
        this.gitDir = fileRepository.getDirectory();
        File commonDirectory = fileRepository.getCommonDirectory();
        this.gitCommonDir = commonDirectory;
        this.refsDir = fs.resolve(commonDirectory, Constants.R_REFS);
        this.logsDir = fs.resolve(commonDirectory, Constants.LOGS);
        this.logsRefsDir = fs.resolve(commonDirectory, "logs/refs/");
        this.packedRefsFile = fs.resolve(commonDirectory, Constants.PACKED_REFS);
        atomicReference.set(RefList.emptyList());
        atomicReference2.set(NO_PACKED_REFS);
        this.trustFolderStat = fileRepository.getConfig().getBoolean(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_KEY_TRUSTFOLDERSTAT, true);
        this.trustPackedRefsStat = (CoreConfig.TrustPackedRefsStat) fileRepository.getConfig().getEnum(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_TRUST_PACKED_REFS_STAT, CoreConfig.TrustPackedRefsStat.UNSET);
        this.trustLooseRefStat = (CoreConfig.TrustLooseRefStat) fileRepository.getConfig().getEnum(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_TRUST_LOOSE_REF_STAT, CoreConfig.TrustLooseRefStat.ALWAYS);
        this.inProcessPackedRefsLock = new ReentrantLock(true);
    }

    Repository getRepository() {
        return this.parent;
    }

    ReflogWriter newLogWriter(boolean z) {
        return new ReflogWriter(this, z);
    }

    public File logFor(String str) {
        if (str.startsWith(Constants.R_REFS)) {
            return new File(this.logsRefsDir, str.substring(Constants.R_REFS.length()));
        }
        return new File(this.logsDir, str);
    }

    public SnapshottingRefDirectory createSnapshottingRefDirectory() {
        return new SnapshottingRefDirectory(this);
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public void create() throws IOException {
        FileUtils.mkdir(this.refsDir);
        FileUtils.mkdir(new File(this.refsDir, Constants.R_HEADS.substring(Constants.R_REFS.length())));
        FileUtils.mkdir(new File(this.refsDir, Constants.R_TAGS.substring(Constants.R_REFS.length())));
        newLogWriter(false).create();
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public void close() {
        clearReferences();
    }

    private void clearReferences() {
        this.looseRefs.set(RefList.emptyList());
        this.packedRefs.set(NO_PACKED_REFS);
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public void refresh() {
        super.refresh();
        clearReferences();
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public void packRefs(ProgressMonitor progressMonitor, PackRefsCommand packRefsCommand) throws IOException {
        List<Ref> refsByPrefix = getRefsByPrefix(packRefsCommand.isAll() ? Constants.R_REFS : Constants.R_TAGS);
        ArrayList arrayList = new ArrayList(refsByPrefix.size());
        progressMonitor.beginTask(JGitText.get().packRefs, refsByPrefix.size());
        try {
            for (Ref ref : refsByPrefix) {
                if (!ref.isSymbolic() && ref.getStorage().isLoose()) {
                    arrayList.add(ref.getName());
                }
                progressMonitor.update(1);
            }
            pack(arrayList);
        } finally {
            progressMonitor.endTask();
        }
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public boolean isNameConflicting(String str) throws IOException {
        int iLastIndexOf = str.lastIndexOf(47);
        while (iLastIndexOf > 0) {
            if (exactRef(str.substring(0, iLastIndexOf)) != null) {
                return true;
            }
            iLastIndexOf = str.lastIndexOf(47, iLastIndexOf - 1);
        }
        return !getRefsByPrefix(str + InternalZipConstants.ZIP_FILE_SEPARATOR).isEmpty();
    }

    @Nullable
    private Ref readAndResolve(String str, RefList<Ref> refList) throws IOException {
        try {
            Ref ref = readRef(str, refList);
            return ref != null ? resolve(ref, 0, null, null, refList) : ref;
        } catch (IOException e) {
            if (str.contains(InternalZipConstants.ZIP_FILE_SEPARATOR) || !(e.getCause() instanceof InvalidObjectIdException)) {
                throw e;
            }
            return null;
        }
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public Ref exactRef(String str) throws IOException {
        try {
            return readAndResolve(str, getPackedRefs());
        } finally {
            fireRefsChanged();
        }
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public Map<String, Ref> exactRef(String... strArr) throws IOException {
        try {
            PackedRefList packedRefs = getPackedRefs();
            HashMap map = new HashMap(strArr.length);
            for (String str : strArr) {
                Ref andResolve = readAndResolve(str, packedRefs);
                if (andResolve != null) {
                    map.put(str, andResolve);
                }
            }
            fireRefsChanged();
            return map;
        } catch (Throwable th) {
            fireRefsChanged();
            throw th;
        }
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    @Nullable
    public Ref firstExactRef(String... strArr) throws IOException {
        try {
            PackedRefList packedRefs = getPackedRefs();
            for (String str : strArr) {
                Ref andResolve = readAndResolve(str, packedRefs);
                if (andResolve != null) {
                    return andResolve;
                }
            }
            return null;
        } finally {
            fireRefsChanged();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.eclipse.jgit.lib.RefDatabase
    public Map<String, Ref> getRefs(String str) throws IOException {
        RefList<LooseRef> refList = this.looseRefs.get();
        LooseScanner looseScanner = new LooseScanner(refList);
        looseScanner.scan(str);
        PackedRefList packedRefs = getPackedRefs();
        if (looseScanner.newLoose != null) {
            looseScanner.newLoose.sort();
            RefList<LooseRef> refList2 = looseScanner.newLoose.toRefList();
            if (CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.looseRefs, refList, refList2)) {
                this.modCnt.incrementAndGet();
            }
            refList = refList2;
        }
        fireRefsChanged();
        RefList.Builder<Ref> builder = looseScanner.symbolic;
        RefList refListRemove = refList;
        int i = 0;
        while (i < builder.size()) {
            Ref ref = builder.get(i);
            String str2 = str;
            Ref refResolve = resolve(ref, 0, str2, refListRemove, packedRefs);
            if (refResolve != null && refResolve.getObjectId() != null) {
                builder.set(i, refResolve);
                i++;
            } else {
                builder.remove(i);
                int iFind = refListRemove.find(ref.getName());
                if (iFind >= 0) {
                    refListRemove = refListRemove.remove(iFind);
                }
            }
            str = str2;
        }
        builder.sort();
        return new RefMap(str, packedRefs, upcast(refListRemove), builder.toRefList());
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public List<Ref> getRefsByPrefix(String... strArr) throws IOException {
        return (List) getRefsByPrefix(StringUtils.commonPrefix(strArr)).parallelStream().filter(new RefDirectory$$ExternalSyntheticLambda1(strArr)).collect(Collectors.toUnmodifiableList());
    }

    static /* synthetic */ boolean lambda$0(String[] strArr, Ref ref) {
        Stream streamOf = Stream.of((Object[]) strArr);
        String name = ref.getName();
        name.getClass();
        return streamOf.anyMatch(new RefDirectory$$ExternalSyntheticLambda3(name));
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public List<Ref> getAdditionalRefs() throws IOException {
        ArrayList arrayList = new ArrayList();
        for (String str : additionalRefsNames) {
            Ref refExactRef = exactRef(str);
            if (refExactRef != null) {
                arrayList.add(refExactRef);
            }
        }
        return arrayList;
    }

    private class LooseScanner {
        private int curIdx;
        private final RefList<LooseRef> curLoose;
        RefList.Builder<LooseRef> newLoose;
        final RefList.Builder<Ref> symbolic = new RefList.Builder<>(4);

        LooseScanner(RefList<LooseRef> refList) {
            this.curLoose = refList;
        }

        void scan(String str) {
            if ("".equals(str)) {
                scanOne("HEAD");
                scanTree(Constants.R_REFS, RefDirectory.this.refsDir);
                if (this.newLoose != null || this.curIdx >= this.curLoose.size()) {
                    return;
                }
                this.newLoose = this.curLoose.copy(this.curIdx);
                return;
            }
            if (str.startsWith(Constants.R_REFS) && str.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                this.curIdx = -(this.curLoose.find(str) + 1);
                scanTree(str, new File(RefDirectory.this.refsDir, str.substring(Constants.R_REFS.length())));
                while (this.curIdx < this.curLoose.size() && ((LooseRef) this.curLoose.get(this.curIdx)).getName().startsWith(str)) {
                    if (this.newLoose == null) {
                        this.newLoose = this.curLoose.copy(this.curIdx);
                    }
                    this.curIdx++;
                }
                if (this.newLoose != null) {
                    while (this.curIdx < this.curLoose.size()) {
                        RefList.Builder<LooseRef> builder = this.newLoose;
                        RefList<LooseRef> refList = this.curLoose;
                        int i = this.curIdx;
                        this.curIdx = i + 1;
                        builder.add((LooseRef) refList.get(i));
                    }
                }
            }
        }

        private boolean scanTree(String str, File file) {
            String[] list = file.list(LockFile.FILTER);
            if (list == null) {
                return false;
            }
            if (list.length > 0) {
                for (int i = 0; i < list.length; i++) {
                    if (new File(file, list[i]).isDirectory()) {
                        list[i] = String.valueOf(list[i]) + InternalZipConstants.ZIP_FILE_SEPARATOR;
                    }
                }
                Arrays.sort(list);
                for (String str2 : list) {
                    if (str2.charAt(str2.length() - 1) == '/') {
                        scanTree(str + str2, new File(file, str2));
                    } else {
                        scanOne(str + str2);
                    }
                }
            }
            return true;
        }

        private void scanOne(String str) {
            LooseRef looseRef;
            LooseRef looseRefScanRef = null;
            if (this.curIdx >= this.curLoose.size()) {
                looseRef = null;
                break;
            }
            while (true) {
                looseRef = (LooseRef) this.curLoose.get(this.curIdx);
                int iCompareTo = RefComparator.compareTo(looseRef, str);
                if (iCompareTo >= 0) {
                    if (iCompareTo <= 0) {
                        break;
                    } else {
                        break;
                    }
                } else {
                    if (this.newLoose == null) {
                        this.newLoose = this.curLoose.copy(this.curIdx);
                    }
                    int i = this.curIdx + 1;
                    this.curIdx = i;
                    if (i >= this.curLoose.size()) {
                    }
                }
                looseRef = null;
                break;
            }
            try {
                looseRefScanRef = RefDirectory.this.scanRef(looseRef, str);
            } catch (IOException unused) {
            }
            if (looseRefScanRef != null) {
                if (looseRef != looseRefScanRef && this.newLoose == null) {
                    this.newLoose = this.curLoose.copy(this.curIdx);
                }
                RefList.Builder<LooseRef> builder = this.newLoose;
                if (builder != null) {
                    builder.add(looseRefScanRef);
                }
                if (looseRefScanRef.isSymbolic()) {
                    this.symbolic.add(looseRefScanRef);
                }
            } else if (looseRef != null && this.newLoose == null) {
                this.newLoose = this.curLoose.copy(this.curIdx);
            }
            if (looseRef != null) {
                this.curIdx++;
            }
        }
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public Ref peel(Ref ref) throws IOException {
        RefList<LooseRef> refList;
        int iFind;
        Ref leaf = ref.getLeaf();
        if (leaf.isPeeled() || leaf.getObjectId() == null) {
            return ref;
        }
        ObjectIdRef objectIdRefDoPeel = doPeel(leaf);
        if (leaf.getStorage().isLoose() && (iFind = (refList = this.looseRefs.get()).find(leaf.getName())) >= 0 && refList.get(iFind) == leaf) {
            CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.looseRefs, refList, refList.set(iFind, ((LooseRef) leaf).peel(objectIdRefDoPeel)));
        }
        return recreate(ref, objectIdRefDoPeel);
    }

    private ObjectIdRef doPeel(Ref ref) throws IOException {
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(getRepository());
            try {
                RevObject any = revWalk.parseAny(ref.getObjectId());
                if (any instanceof RevTag) {
                    return new ObjectIdRef.PeeledTag(ref.getStorage(), ref.getName(), ref.getObjectId(), revWalk.peel(any).copy());
                }
                return new ObjectIdRef.PeeledNonTag(ref.getStorage(), ref.getName(), ref.getObjectId());
            } finally {
                revWalk.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    private static Ref recreate(Ref ref, ObjectIdRef objectIdRef) {
        if (!ref.isSymbolic()) {
            return objectIdRef;
        }
        return new SymbolicRef(ref.getName(), recreate(ref.getTarget(), objectIdRef));
    }

    void storedSymbolicRef(RefDirectoryUpdate refDirectoryUpdate, FileSnapshot fileSnapshot, String str) {
        putLooseRef(newSymbolicRef(fileSnapshot, refDirectoryUpdate.getRef().getName(), str));
        fireRefsChanged();
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public RefDirectoryUpdate newUpdate(String str, boolean z) throws IOException {
        PackedRefList packedRefs = getPackedRefs();
        Ref ref = readRef(str, packedRefs);
        if (ref != null) {
            ref = resolve(ref, 0, null, null, packedRefs);
        }
        boolean z2 = false;
        if (ref == null) {
            ref = new ObjectIdRef.Unpeeled(Ref.Storage.NEW, str, null);
        } else if (z && ref.isSymbolic()) {
            z2 = true;
        }
        RefDirectoryUpdate refDirectoryUpdateCreateRefDirectoryUpdate = createRefDirectoryUpdate(ref);
        if (z2) {
            refDirectoryUpdateCreateRefDirectoryUpdate.setDetachingSymbolicRef();
        }
        return refDirectoryUpdateCreateRefDirectoryUpdate;
    }

    RefDirectoryUpdate createRefDirectoryUpdate(Ref ref) {
        return new RefDirectoryUpdate(this, ref);
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public RefDirectoryRename newRename(String str, String str2) throws IOException {
        return createRefDirectoryRename(newUpdate(str, false), newUpdate(str2, false));
    }

    RefDirectoryRename createRefDirectoryRename(RefDirectoryUpdate refDirectoryUpdate, RefDirectoryUpdate refDirectoryUpdate2) {
        return new RefDirectoryRename(refDirectoryUpdate, refDirectoryUpdate2);
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public PackedBatchRefUpdate newBatchUpdate() {
        return new PackedBatchRefUpdate(this);
    }

    public PackedBatchRefUpdate newBatchUpdate(boolean z) {
        return new PackedBatchRefUpdate(this, z);
    }

    void stored(RefDirectoryUpdate refDirectoryUpdate, FileSnapshot fileSnapshot) {
        putLooseRef(new LooseUnpeeled(fileSnapshot, refDirectoryUpdate.getRef().getLeaf().getName(), refDirectoryUpdate.getNewObjectId().copy()));
    }

    private void putLooseRef(LooseRef looseRef) {
        RefList<LooseRef> refList;
        do {
            refList = this.looseRefs.get();
        } while (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.looseRefs, refList, refList.put(looseRef)));
        this.modCnt.incrementAndGet();
        fireRefsChanged();
    }

    void delete(RefDirectoryUpdate refDirectoryUpdate) throws IOException {
        RefList<LooseRef> refList;
        int iFind;
        Ref ref = refDirectoryUpdate.getRef();
        if (!refDirectoryUpdate.isDetachingSymbolicRef()) {
            ref = ref.getLeaf();
        }
        String name = ref.getName();
        if (getPackedRefs().contains(name)) {
            this.inProcessPackedRefsLock.lock();
            try {
                LockFile lockFileLockPackedRefsOrThrow = lockPackedRefsOrThrow();
                try {
                    PackedRefList packedRefListRefreshPackedRefs = refreshPackedRefs();
                    int iFind2 = packedRefListRefreshPackedRefs.find(name);
                    if (iFind2 >= 0) {
                        commitPackedRefs(lockFileLockPackedRefsOrThrow, packedRefListRefreshPackedRefs.remove(iFind2), packedRefListRefreshPackedRefs, true);
                    }
                    lockFileLockPackedRefsOrThrow.unlock();
                    this.inProcessPackedRefsLock.unlock();
                } catch (Throwable th) {
                    lockFileLockPackedRefsOrThrow.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                this.inProcessPackedRefsLock.unlock();
                throw th2;
            }
        }
        do {
            refList = this.looseRefs.get();
            iFind = refList.find(name);
            if (iFind < 0) {
                break;
            }
        } while (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.looseRefs, refList, refList.remove(iFind)));
        int iLevelsIn = levelsIn(name) - 2;
        delete(logFor(name), iLevelsIn);
        if (ref.getStorage().isLoose()) {
            deleteAndUnlock(fileFor(name), iLevelsIn, refDirectoryUpdate);
        }
        this.modCnt.incrementAndGet();
        fireRefsChanged();
    }

    public void pack(List<String> list) throws IOException {
        pack(list, Collections.emptyMap());
    }

    void pack(Map<String, LockFile> map) throws IOException {
        pack(map.keySet(), map);
    }

    private void pack(Collection<String> collection, Map<String, LockFile> map) throws IOException {
        boolean z;
        RefList<LooseRef> refList;
        int iFind;
        Ref refPeeledPackedRef;
        Iterator<LockFile> it = map.values().iterator();
        while (it.hasNext()) {
            it.next().requireLock();
        }
        if (collection.isEmpty()) {
            return;
        }
        FS fs = this.parent.getFS();
        this.inProcessPackedRefsLock.lock();
        try {
            LockFile lockFileLockPackedRefsOrThrow = lockPackedRefsOrThrow();
            try {
                PackedRefList packedRefListRefreshPackedRefs = refreshPackedRefs();
                RefList<Ref> refListAdd = packedRefListRefreshPackedRefs;
                boolean z2 = false;
                for (String str : collection) {
                    Ref ref = readRef(str, refListAdd);
                    if (ref != null && !ref.isSymbolic() && (refPeeledPackedRef = peeledPackedRef(ref)) != ref) {
                        int iFind2 = refListAdd.find(str);
                        if (iFind2 >= 0) {
                            refListAdd = refListAdd.set(iFind2, refPeeledPackedRef);
                        } else {
                            refListAdd = refListAdd.add(iFind2, refPeeledPackedRef);
                        }
                        z2 = true;
                    }
                }
                if (z2) {
                    commitPackedRefs(lockFileLockPackedRefsOrThrow, refListAdd, packedRefListRefreshPackedRefs, false);
                    for (String str2 : collection) {
                        File fileFileFor = fileFor(str2);
                        if (fs.exists(fileFileFor)) {
                            LockFile lockFile = map.get(str2);
                            if (lockFile == null) {
                                lockFile = new LockFile(fileFileFor);
                                if (lockFile.lock()) {
                                    z = true;
                                } else {
                                    continue;
                                }
                            } else {
                                z = false;
                            }
                            try {
                                LooseRef looseRefScanRef = scanRef(null, str2);
                                if (looseRefScanRef != null && !looseRefScanRef.isSymbolic()) {
                                    Ref ref2 = refListAdd.get(str2);
                                    ObjectId objectId = looseRefScanRef.getObjectId();
                                    if (objectId != null && ref2 != null && objectId.equals((AnyObjectId) ref2.getObjectId())) {
                                        do {
                                            refList = this.looseRefs.get();
                                            iFind = refList.find(str2);
                                            if (iFind < 0) {
                                                break;
                                            }
                                        } while (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.looseRefs, refList, refList.remove(iFind)));
                                        deleteAndUnlock(fileFileFor, levelsIn(str2) - 2, lockFile);
                                    }
                                    if (z) {
                                        lockFile.unlock();
                                    }
                                } else if (z) {
                                    lockFile.unlock();
                                }
                            } catch (Throwable th) {
                                if (z) {
                                    lockFile.unlock();
                                }
                                throw th;
                            }
                        }
                    }
                }
                lockFileLockPackedRefsOrThrow.unlock();
                this.inProcessPackedRefsLock.unlock();
            } catch (Throwable th2) {
                lockFileLockPackedRefsOrThrow.unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            this.inProcessPackedRefsLock.unlock();
            throw th3;
        }
    }

    @Nullable
    LockFile lockPackedRefs() throws IOException {
        LockFile lockFile = new LockFile(this.packedRefsFile);
        Iterator<Integer> it = getRetrySleepMs().iterator();
        while (it.hasNext()) {
            sleep(it.next().intValue());
            if (lockFile.lock()) {
                return lockFile;
            }
        }
        return null;
    }

    LockFile lockPackedRefsOrThrow() throws IOException {
        LockFile lockFileLockPackedRefs = lockPackedRefs();
        if (lockFileLockPackedRefs != null) {
            return lockFileLockPackedRefs;
        }
        throw new LockFailedException(this.packedRefsFile);
    }

    private Ref peeledPackedRef(Ref ref) throws IOException {
        if (ref.getStorage().isPacked() && ref.isPeeled()) {
            return ref;
        }
        if (!ref.isPeeled()) {
            ref = peel(ref);
        }
        ObjectId peeledObjectId = ref.getPeeledObjectId();
        if (peeledObjectId != null) {
            return new ObjectIdRef.PeeledTag(Ref.Storage.PACKED, ref.getName(), ref.getObjectId(), peeledObjectId);
        }
        return new ObjectIdRef.PeeledNonTag(Ref.Storage.PACKED, ref.getName(), ref.getObjectId());
    }

    void log(boolean z, RefUpdate refUpdate, String str, boolean z2) throws IOException {
        newLogWriter(z).log(refUpdate, str, z2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        if (r0 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.eclipse.jgit.lib.Ref resolve(org.eclipse.jgit.lib.Ref r10, int r11, java.lang.String r12, org.eclipse.jgit.util.RefList<org.eclipse.jgit.internal.storage.file.RefDirectory.LooseRef> r13, org.eclipse.jgit.util.RefList<org.eclipse.jgit.lib.Ref> r14) throws java.io.IOException {
        /*
            r9 = this;
            boolean r0 = r10.isSymbolic()
            if (r0 == 0) goto L5c
            org.eclipse.jgit.lib.Ref r0 = r10.getTarget()
            r1 = 5
            r2 = 0
            if (r1 > r11) goto Lf
            return r2
        Lf:
            if (r13 == 0) goto L39
            java.lang.String r1 = r0.getName()
            boolean r1 = r1.startsWith(r12)
            if (r1 == 0) goto L39
            java.lang.String r1 = r0.getName()
            int r1 = r13.find(r1)
            if (r1 < 0) goto L2a
            org.eclipse.jgit.lib.Ref r0 = r13.get(r1)
            goto L44
        L2a:
            java.lang.String r0 = r0.getName()
            int r0 = r14.find(r0)
            if (r0 < 0) goto L5c
            org.eclipse.jgit.lib.Ref r0 = r14.get(r0)
            goto L44
        L39:
            java.lang.String r0 = r0.getName()
            org.eclipse.jgit.lib.Ref r0 = r9.readRef(r0, r14)
            if (r0 != 0) goto L44
            goto L5c
        L44:
            r4 = r0
            int r5 = r11 + 1
            r3 = r9
            r6 = r12
            r7 = r13
            r8 = r14
            org.eclipse.jgit.lib.Ref r11 = r3.resolve(r4, r5, r6, r7, r8)
            if (r11 != 0) goto L52
            return r2
        L52:
            org.eclipse.jgit.lib.SymbolicRef r12 = new org.eclipse.jgit.lib.SymbolicRef
            java.lang.String r10 = r10.getName()
            r12.<init>(r10, r11)
            return r12
        L5c:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jgit.internal.storage.file.RefDirectory.resolve(org.eclipse.jgit.lib.Ref, int, java.lang.String, org.eclipse.jgit.util.RefList, org.eclipse.jgit.util.RefList):org.eclipse.jgit.lib.Ref");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
    
        if (r0.snapshot.isModified(r3.packedRefsFile) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
    
        if (r0.snapshot.isModified(r3.packedRefsFile) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    org.eclipse.jgit.internal.storage.file.RefDirectory.PackedRefList getPackedRefs() throws java.io.IOException {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicReference<org.eclipse.jgit.internal.storage.file.RefDirectory$PackedRefList> r0 = r3.packedRefs
            java.lang.Object r0 = r0.get()
            org.eclipse.jgit.internal.storage.file.RefDirectory$PackedRefList r0 = (org.eclipse.jgit.internal.storage.file.RefDirectory.PackedRefList) r0
            int[] r1 = $SWITCH_TABLE$org$eclipse$jgit$lib$CoreConfig$TrustPackedRefsStat()
            org.eclipse.jgit.lib.CoreConfig$TrustPackedRefsStat r2 = r3.trustPackedRefsStat
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 2
            if (r1 == r2) goto L44
            r2 = 3
            if (r1 == r2) goto L2f
            r2 = 4
            if (r1 == r2) goto L1e
            goto L51
        L1e:
            boolean r1 = r3.trustFolderStat
            if (r1 == 0) goto L51
            org.eclipse.jgit.internal.storage.file.FileSnapshot r1 = org.eclipse.jgit.internal.storage.file.RefDirectory.PackedRefList.m5727$$Nest$fgetsnapshot(r0)
            java.io.File r2 = r3.packedRefsFile
            boolean r1 = r1.isModified(r2)
            if (r1 != 0) goto L51
            goto L50
        L2f:
            java.io.File r1 = r3.packedRefsFile     // Catch: java.lang.Throwable -> L42
            java.nio.file.Path r1 = r1.toPath()     // Catch: java.lang.Throwable -> L42
            r2 = 0
            java.nio.file.OpenOption[] r2 = new java.nio.file.OpenOption[r2]     // Catch: java.lang.Throwable -> L42
            java.io.InputStream r1 = java.nio.file.Files.newInputStream(r1, r2)     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L44
            r1.close()     // Catch: java.lang.Throwable -> L42
            goto L44
        L42:
            r1 = move-exception
            throw r1     // Catch: java.lang.Throwable -> L44
        L44:
            org.eclipse.jgit.internal.storage.file.FileSnapshot r1 = org.eclipse.jgit.internal.storage.file.RefDirectory.PackedRefList.m5727$$Nest$fgetsnapshot(r0)
            java.io.File r2 = r3.packedRefsFile
            boolean r1 = r1.isModified(r2)
            if (r1 != 0) goto L51
        L50:
            return r0
        L51:
            org.eclipse.jgit.internal.storage.file.RefDirectory$PackedRefList r0 = r3.refreshPackedRefs(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jgit.internal.storage.file.RefDirectory.getPackedRefs():org.eclipse.jgit.internal.storage.file.RefDirectory$PackedRefList");
    }

    PackedRefList refreshPackedRefs() throws IOException {
        return refreshPackedRefs(this.packedRefs.get());
    }

    private PackedRefList refreshPackedRefs(PackedRefList packedRefList) throws IOException {
        PackedRefList packedRefs = readPackedRefs();
        if (CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.packedRefs, packedRefList, packedRefs) && !packedRefList.f122id.equals((AnyObjectId) packedRefs.f122id)) {
            this.modCnt.incrementAndGet();
        }
        return packedRefs;
    }

    private PackedRefList readPackedRefs() throws IOException {
        try {
            PackedRefList packedRefList = (PackedRefList) FileUtils.readWithRetries(this.packedRefsFile, new RefDirectory$$ExternalSyntheticLambda0(this));
            return packedRefList != null ? packedRefList : NO_PACKED_REFS;
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            throw new IOException(MessageFormat.format(JGitText.get().cannotReadFile, this.packedRefsFile), e2);
        }
    }

    /* JADX INFO: renamed from: lambda$2$org-eclipse-jgit-internal-storage-file-RefDirectory, reason: not valid java name */
    /* synthetic */ PackedRefList m5724lambda$2$orgeclipsejgitinternalstoragefileRefDirectory(File file) throws Exception {
        FileSnapshot fileSnapshotSave = FileSnapshot.save(file);
        MessageDigest messageDigestNewMessageDigest = Constants.newMessageDigest();
        Throwable th = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new DigestInputStream(new FileInputStream(file), messageDigestNewMessageDigest), StandardCharsets.UTF_8));
            try {
                return new PackedRefList(parsePackedRefs(bufferedReader), fileSnapshotSave, ObjectId.fromRaw(messageDigestNewMessageDigest.digest()), null);
            } finally {
                bufferedReader.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    void compareAndSetPackedRefs(PackedRefList packedRefList, PackedRefList packedRefList2) {
        if (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.packedRefs, packedRefList, packedRefList2) || packedRefList.f122id.equals((AnyObjectId) packedRefList2.f122id)) {
            return;
        }
        this.modCnt.incrementAndGet();
    }

    private RefList<Ref> parsePackedRefs(BufferedReader bufferedReader) throws IOException {
        Ref unpeeled;
        RefList.Builder builder = new RefList.Builder();
        Ref ref = null;
        boolean z = false;
        boolean zContains = false;
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                if (line.charAt(0) == '#') {
                    if (line.startsWith(PACKED_REFS_HEADER)) {
                        zContains = line.substring(PACKED_REFS_HEADER.length()).contains(PACKED_REFS_PEELED);
                    }
                } else {
                    if (line.charAt(0) != '^') {
                        int iIndexOf = line.indexOf(32);
                        if (iIndexOf < 0) {
                            throw new IOException(MessageFormat.format(JGitText.get().packedRefsCorruptionDetected, this.packedRefsFile.getAbsolutePath()));
                        }
                        ObjectId objectIdFromString = ObjectId.fromString(line.substring(0, iIndexOf));
                        String strCopy = copy(line, iIndexOf + 1, line.length());
                        if (zContains) {
                            unpeeled = new ObjectIdRef.PeeledNonTag(Ref.Storage.PACKED, strCopy, objectIdFromString);
                        } else {
                            unpeeled = new ObjectIdRef.Unpeeled(Ref.Storage.PACKED, strCopy, objectIdFromString);
                        }
                        if (ref != null && RefComparator.compareTo(ref, unpeeled) > 0) {
                            z = true;
                        }
                        builder.add(unpeeled);
                    } else {
                        if (ref == null) {
                            throw new IOException(JGitText.get().peeledLineBeforeRef);
                        }
                        unpeeled = new ObjectIdRef.PeeledTag(Ref.Storage.PACKED, ref.getName(), ref.getObjectId(), ObjectId.fromString(line.substring(1)));
                        builder.set(builder.size() - 1, unpeeled);
                    }
                    ref = unpeeled;
                }
            } else {
                if (z) {
                    builder.sort();
                }
                return builder.toRefList();
            }
        }
    }

    private static String copy(String str, int i, int i2) {
        return new StringBuilder(i2 - i).append((CharSequence) str, i, i2).toString();
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.internal.storage.file.RefDirectory$1, reason: invalid class name */
    class AnonymousClass1 extends RefWriter {
        private final /* synthetic */ boolean val$changed;
        private final /* synthetic */ LockFile val$lck;
        private final /* synthetic */ PackedRefList val$oldPackedList;
        private final /* synthetic */ RefList val$refs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RefList refList, LockFile lockFile, RefList refList2, PackedRefList packedRefList, boolean z) {
            super((RefList<Ref>) refList);
            this.val$lck = lockFile;
            this.val$refs = refList2;
            this.val$oldPackedList = packedRefList;
            this.val$changed = z;
        }

        @Override // org.eclipse.jgit.lib.RefWriter
        protected void writeFile(String str, byte[] bArr) throws IOException {
            this.val$lck.setFSync(true);
            this.val$lck.setNeedSnapshot(true);
            try {
                this.val$lck.write(bArr);
                try {
                    this.val$lck.waitForStatChange();
                    if (!this.val$lck.commit()) {
                        throw new ObjectWritingException(MessageFormat.format(JGitText.get().unableToWrite, str));
                    }
                    CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(RefDirectory.this.packedRefs, this.val$oldPackedList, new PackedRefList(this.val$refs, this.val$lck.getCommitSnapshot(), ObjectId.fromRaw(Constants.newMessageDigest().digest(bArr)), null));
                    if (this.val$changed) {
                        RefDirectory.this.modCnt.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    this.val$lck.unlock();
                    throw new ObjectWritingException(MessageFormat.format(JGitText.get().interruptedWriting, str), e);
                }
            } catch (IOException e2) {
                throw new ObjectWritingException(MessageFormat.format(JGitText.get().unableToWrite, str), e2);
            }
        }
    }

    void commitPackedRefs(LockFile lockFile, RefList<Ref> refList, PackedRefList packedRefList, boolean z) throws IOException {
        new AnonymousClass1(refList, lockFile, refList, packedRefList, z).writePackedRefs();
    }

    private Ref readRef(String str, RefList<Ref> refList) throws IOException {
        RefList<LooseRef> refList2 = this.looseRefs.get();
        int iFind = refList2.find(str);
        if (iFind >= 0) {
            LooseRef looseRef = (LooseRef) refList2.get(iFind);
            LooseRef looseRefScanRef = scanRef(looseRef, str);
            if (looseRefScanRef == null) {
                if (CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.looseRefs, refList2, refList2.remove(iFind))) {
                    this.modCnt.incrementAndGet();
                }
                return refList.get(str);
            }
            if (looseRef != looseRefScanRef && CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.looseRefs, refList2, refList2.set(iFind, looseRefScanRef))) {
                this.modCnt.incrementAndGet();
            }
            return looseRefScanRef;
        }
        LooseRef looseRefScanRef2 = scanRef(null, str);
        if (looseRefScanRef2 == null) {
            return refList.get(str);
        }
        for (String str2 : additionalRefsNames) {
            if (str.equals(str2)) {
                return looseRefScanRef2;
            }
        }
        if (CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.looseRefs, refList2, refList2.add(iFind, looseRefScanRef2))) {
            this.modCnt.incrementAndGet();
            return looseRefScanRef2;
        }
        return looseRefScanRef2;
    }

    LooseRef scanRef(LooseRef looseRef, String str) throws IOException {
        FileSnapshot fileSnapshot;
        int length;
        File fileFileFor = fileFor(str);
        if (this.trustLooseRefStat.equals(CoreConfig.TrustLooseRefStat.AFTER_OPEN)) {
            refreshPathToLooseRef(Paths.get(str, new String[0]));
        }
        if (looseRef != null) {
            FileSnapshot snapShot = looseRef.getSnapShot();
            if (!snapShot.isModified(fileFileFor)) {
                return looseRef;
            }
            fileSnapshot = snapShot;
            str = looseRef.getName();
        } else {
            fileSnapshot = null;
        }
        try {
            C1LooseItems c1LooseItems = (C1LooseItems) FileUtils.readWithRetries(fileFileFor, new RefDirectory$$ExternalSyntheticLambda2(this));
            if (c1LooseItems == null || (length = c1LooseItems.buf.length) == 0) {
                return null;
            }
            if (isSymRef(c1LooseItems.buf, length)) {
                if (length == 4096) {
                    return null;
                }
                while (length > 0 && Character.isWhitespace(c1LooseItems.buf[length - 1])) {
                    length--;
                }
                if (length < 6) {
                    throw new IOException(MessageFormat.format(JGitText.get().notARef, str, RawParseUtils.decode(c1LooseItems.buf, 0, length)));
                }
                String strDecode = RawParseUtils.decode(c1LooseItems.buf, 5, length);
                if (looseRef != null && looseRef.isSymbolic() && looseRef.getTarget().getName().equals(strDecode)) {
                    fileSnapshot.setClean(c1LooseItems.snapshot);
                    return looseRef;
                }
                return newSymbolicRef(c1LooseItems.snapshot, str, strDecode);
            }
            if (length < 40) {
                return null;
            }
            try {
                ObjectId objectIdFromString = ObjectId.fromString(c1LooseItems.buf, 0);
                if (looseRef != null && !looseRef.isSymbolic() && objectIdFromString.equals((AnyObjectId) looseRef.getTarget().getObjectId())) {
                    fileSnapshot.setClean(c1LooseItems.snapshot);
                    return looseRef;
                }
                return new LooseUnpeeled(c1LooseItems.snapshot, str, objectIdFromString);
            } catch (IllegalArgumentException e) {
                while (length > 0 && Character.isWhitespace(c1LooseItems.buf[length - 1])) {
                    length--;
                }
                throw new IOException(MessageFormat.format(JGitText.get().notARef, str, RawParseUtils.decode(c1LooseItems.buf, 0, length)), e);
            }
        } catch (IOException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new IOException(MessageFormat.format(JGitText.get().cannotReadFile, fileFileFor), e3);
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.internal.storage.file.RefDirectory$1LooseItems, reason: invalid class name */
    class C1LooseItems {
        final byte[] buf;
        final FileSnapshot snapshot;

        C1LooseItems(FileSnapshot fileSnapshot, byte[] bArr) {
            this.snapshot = fileSnapshot;
            this.buf = bArr;
        }
    }

    /* JADX INFO: renamed from: lambda$3$org-eclipse-jgit-internal-storage-file-RefDirectory, reason: not valid java name */
    /* synthetic */ C1LooseItems m5725lambda$3$orgeclipsejgitinternalstoragefileRefDirectory(File file) throws Exception {
        return new C1LooseItems(FileSnapshot.save(file), IO.readSome(file, 4096));
    }

    void refreshPathToLooseRef(Path path) {
        for (int i = 1; i < path.getNameCount(); i++) {
            try {
                InputStream inputStreamNewInputStream = Files.newInputStream(fileFor(path.subpath(0, i).toString()).toPath(), new OpenOption[0]);
                if (inputStreamNewInputStream != null) {
                    inputStreamNewInputStream.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (IOException unused) {
                    return;
                }
            }
        }
    }

    private static boolean isSymRef(byte[] bArr, int i) {
        return i >= 6 && bArr[0] == 114 && bArr[1] == 101 && bArr[2] == 102 && bArr[3] == 58 && bArr[4] == 32;
    }

    boolean isInClone() throws IOException {
        return (!hasDanglingHead() || this.packedRefsFile.exists() || hasLooseRef()) ? false : true;
    }

    private boolean hasDanglingHead() throws IOException {
        Ref refExactRef = exactRef("HEAD");
        if (refExactRef == null) {
            return false;
        }
        ObjectId objectId = refExactRef.getObjectId();
        return objectId == null || objectId.equals((AnyObjectId) ObjectId.zeroId());
    }

    private boolean hasLooseRef() throws IOException {
        Throwable th = null;
        try {
            Stream<Path> streamWalk = Files.walk(this.refsDir.toPath(), new FileVisitOption[0]);
            try {
                return streamWalk.anyMatch(new RefDirectory$$ExternalSyntheticLambda4());
            } finally {
                if (streamWalk != null) {
                    streamWalk.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null == th2) {
                throw null;
            }
            th.addSuppressed(th2);
            throw null;
        }
    }

    void fireRefsChanged() {
        int i = this.lastNotifiedModCnt.get();
        int i2 = this.modCnt.get();
        if (i == i2 || !this.lastNotifiedModCnt.compareAndSet(i, i2) || i == 0) {
            return;
        }
        this.parent.fireEvent(new RefsChangedEvent());
    }

    RefDirectoryUpdate newTemporaryUpdate() throws IOException {
        return createRefDirectoryUpdate(new ObjectIdRef.Unpeeled(Ref.Storage.NEW, Constants.R_REFS + File.createTempFile("renamed_", "_ref", this.refsDir).getName(), null));
    }

    File fileFor(String str) {
        if (str.startsWith(Constants.R_REFS)) {
            return new File(this.refsDir, str.substring(Constants.R_REFS.length()));
        }
        if (str.equals("HEAD")) {
            return new File(this.gitDir, str);
        }
        return new File(this.gitCommonDir, str);
    }

    static int levelsIn(String str) {
        int iIndexOf = str.indexOf(47);
        int i = 0;
        while (iIndexOf >= 0) {
            i++;
            iIndexOf = str.indexOf(47, iIndexOf + 1);
        }
        return i;
    }

    static void delete(File file, int i) throws IOException {
        delete(file);
        deleteEmptyParentDirs(file, i);
    }

    private static void delete(File file) throws IOException {
        if (!file.delete() && file.isFile()) {
            throw new IOException(MessageFormat.format(JGitText.get().fileCannotBeDeleted, file));
        }
    }

    private static void deleteAndUnlock(File file, int i, RefDirectoryUpdate refDirectoryUpdate) throws IOException {
        delete(file);
        if (refDirectoryUpdate != null) {
            refDirectoryUpdate.unlock();
        }
        deleteEmptyParentDirs(file, i);
    }

    private static void deleteAndUnlock(File file, int i, LockFile lockFile) throws IOException {
        delete(file);
        if (lockFile != null) {
            lockFile.unlock();
        }
        deleteEmptyParentDirs(file, i);
    }

    private static void deleteEmptyParentDirs(File file, int i) {
        File parentFile = file.getParentFile();
        for (int i2 = 0; i2 < i; i2++) {
            try {
                Files.deleteIfExists(parentFile.toPath());
                parentFile = parentFile.getParentFile();
            } catch (DirectoryNotEmptyException unused) {
                return;
            } catch (IOException e) {
                LOG.warn(MessageFormat.format(JGitText.get().unableToRemovePath, parentFile), (Throwable) e);
                return;
            }
        }
    }

    Iterable<Integer> getRetrySleepMs() {
        return this.retrySleepMs;
    }

    void setRetrySleepMs(List<Integer> list) {
        if (list == null || list.isEmpty() || list.get(0).intValue() != 0) {
            throw new IllegalArgumentException();
        }
        this.retrySleepMs = list;
    }

    static void sleep(long j) throws InterruptedIOException {
        if (j <= 0) {
            return;
        }
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            InterruptedIOException interruptedIOException = new InterruptedIOException();
            interruptedIOException.initCause(e);
            throw interruptedIOException;
        }
    }

    static class PackedRefList extends RefList<Ref> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final ObjectId f122id;
        private final FileSnapshot snapshot;

        /* synthetic */ PackedRefList(RefList refList, FileSnapshot fileSnapshot, ObjectId objectId, RefDirectoryIA refDirectoryIA) {
            this(refList, fileSnapshot, objectId);
        }

        private PackedRefList(RefList<Ref> refList, FileSnapshot fileSnapshot, ObjectId objectId) {
            super(refList);
            this.snapshot = fileSnapshot;
            this.f122id = objectId;
        }
    }

    private static LooseSymbolicRef newSymbolicRef(FileSnapshot fileSnapshot, String str, String str2) {
        return new LooseSymbolicRef(fileSnapshot, str, new ObjectIdRef.Unpeeled(Ref.Storage.NEW, str2, null));
    }

    private static final class LoosePeeledTag extends ObjectIdRef.PeeledTag implements LooseRef {
        private final FileSnapshot snapShot;

        @Override // org.eclipse.jgit.internal.storage.file.RefDirectory.LooseRef
        public LooseRef peel(ObjectIdRef objectIdRef) {
            return this;
        }

        LoosePeeledTag(FileSnapshot fileSnapshot, String str, ObjectId objectId, ObjectId objectId2) {
            super(Ref.Storage.LOOSE, str, objectId, objectId2);
            this.snapShot = fileSnapshot;
        }

        @Override // org.eclipse.jgit.internal.storage.file.RefDirectory.LooseRef
        public FileSnapshot getSnapShot() {
            return this.snapShot;
        }
    }

    private static final class LooseNonTag extends ObjectIdRef.PeeledNonTag implements LooseRef {
        private final FileSnapshot snapShot;

        @Override // org.eclipse.jgit.internal.storage.file.RefDirectory.LooseRef
        public LooseRef peel(ObjectIdRef objectIdRef) {
            return this;
        }

        LooseNonTag(FileSnapshot fileSnapshot, String str, ObjectId objectId) {
            super(Ref.Storage.LOOSE, str, objectId);
            this.snapShot = fileSnapshot;
        }

        @Override // org.eclipse.jgit.internal.storage.file.RefDirectory.LooseRef
        public FileSnapshot getSnapShot() {
            return this.snapShot;
        }
    }

    private static final class LooseUnpeeled extends ObjectIdRef.Unpeeled implements LooseRef {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private FileSnapshot snapShot;

        LooseUnpeeled(FileSnapshot fileSnapshot, String str, ObjectId objectId) {
            super(Ref.Storage.LOOSE, str, objectId);
            this.snapShot = fileSnapshot;
        }

        @Override // org.eclipse.jgit.internal.storage.file.RefDirectory.LooseRef
        public FileSnapshot getSnapShot() {
            return this.snapShot;
        }

        @Override // org.eclipse.jgit.lib.ObjectIdRef, org.eclipse.jgit.lib.Ref
        public ObjectId getObjectId() {
            return super.getObjectId();
        }

        @Override // org.eclipse.jgit.internal.storage.file.RefDirectory.LooseRef
        public LooseRef peel(ObjectIdRef objectIdRef) {
            ObjectId peeledObjectId = objectIdRef.getPeeledObjectId();
            ObjectId objectId = getObjectId();
            if (peeledObjectId != null) {
                return new LoosePeeledTag(this.snapShot, getName(), objectId, peeledObjectId);
            }
            return new LooseNonTag(this.snapShot, getName(), objectId);
        }
    }

    private static final class LooseSymbolicRef extends SymbolicRef implements LooseRef {
        private final FileSnapshot snapShot;

        LooseSymbolicRef(FileSnapshot fileSnapshot, String str, Ref ref) {
            super(str, ref);
            this.snapShot = fileSnapshot;
        }

        @Override // org.eclipse.jgit.internal.storage.file.RefDirectory.LooseRef
        public FileSnapshot getSnapShot() {
            return this.snapShot;
        }

        @Override // org.eclipse.jgit.internal.storage.file.RefDirectory.LooseRef
        public LooseRef peel(ObjectIdRef objectIdRef) {
            throw new UnsupportedOperationException();
        }
    }
}
