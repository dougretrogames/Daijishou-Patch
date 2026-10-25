package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.MessageFormat;
import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.api.PackRefsCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.dircache.DirCacheIterator;
import org.eclipse.jgit.errors.CancelledException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.commitgraph.CommitGraphWriter;
import org.eclipse.jgit.internal.storage.commitgraph.GraphCommits;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.internal.storage.pack.PackWriter;
import org.eclipse.jgit.internal.util.ShutdownHook;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.CommitConfig$$ExternalSyntheticBackport0;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.CoreConfig;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdSet;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefDatabase;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.lib.internal.WorkQueue;
import org.eclipse.jgit.revwalk.ObjectWalk;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.pack.PackConfig;
import org.eclipse.jgit.transport.WalkEncryption;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.TreeFilter;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.FileUtils;
import org.eclipse.jgit.util.GitDateParser;
import org.eclipse.jgit.util.StringUtils;
import org.eclipse.jgit.util.SystemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class GC {
    private static final int DEFAULT_AUTOLIMIT = 6700;
    private static final int DEFAULT_AUTOPACKLIMIT = 50;
    private static final boolean DEFAULT_WRITE_BLOOM_FILTER = false;
    private static final boolean DEFAULT_WRITE_COMMIT_GRAPH = false;
    private static final String PRUNE_EXPIRE_DEFAULT = "2.weeks.ago";
    private static final String PRUNE_PACK_EXPIRE_DEFAULT = "1.hour.ago";
    private static volatile ExecutorService executor;
    private boolean automatic;
    private boolean background;
    private Date expire;
    private Collection<Ref> lastPackedRefs;
    private long lastRepackTime;
    private Date packExpire;
    private Boolean packKeptObjects;
    private PackConfig pconfig;
    private final FileRepository repo;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) GC.class);
    private static final Pattern PATTERN_LOOSE_OBJECT = Pattern.compile("[0-9a-fA-F]{38}");
    private static final Set<PackExt> PARENT_EXTS = CommitConfig$$ExternalSyntheticBackport0.m5773m(new Object[]{PackExt.PACK, PackExt.KEEP});
    private static final Set<PackExt> CHILD_EXTS = CommitConfig$$ExternalSyntheticBackport0.m5773m(new Object[]{PackExt.BITMAP_INDEX, PackExt.INDEX, PackExt.REVERSE_INDEX});
    private long expireAgeMillis = -1;
    private long packExpireAgeMillis = -1;
    private ProgressMonitor pm = NullProgressMonitor.INSTANCE;

    private void addRepackAllOption() {
    }

    public static void setExecutor(ExecutorService executorService) {
        executor = executorService;
    }

    public GC(FileRepository fileRepository) {
        this.repo = fileRepository;
        this.pconfig = new PackConfig(fileRepository);
    }

    public CompletableFuture<Collection<Pack>> gc() throws GitAPIException, IOException, ParseException {
        if (!this.background) {
            return CompletableFuture.completedFuture(doGc());
        }
        GcLog gcLog = new GcLog(this.repo);
        if (!gcLog.lock()) {
            return CompletableFuture.completedFuture(Collections.emptyList());
        }
        return CompletableFuture.supplyAsync(new GC$$ExternalSyntheticLambda11(this, gcLog), executor());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: lambda$0$org-eclipse-jgit-internal-storage-file-GC, reason: not valid java name */
    /* synthetic */ Collection m5696lambda$0$orgeclipsejgitinternalstoragefileGC(GcLog gcLog) {
        try {
            try {
                Collection<Pack> collectionDoGc = doGc();
                if (this.automatic && tooManyLooseObjects()) {
                    gcLog.write(JGitText.get().gcTooManyUnpruned);
                    gcLog.commit();
                }
                return collectionDoGc;
            } catch (IOException e) {
                e.addSuppressed(e);
                LOG.error(e.getMessage(), (Throwable) e);
            } finally {
                gcLog.unlock();
            }
        } catch (IOException | ParseException | GitAPIException e2) {
            gcLog.write(e2.getMessage());
            StringWriter stringWriter = new StringWriter();
            e2.printStackTrace(new PrintWriter(stringWriter));
            gcLog.write(stringWriter.toString());
            gcLog.commit();
            return Collections.emptyList();
        }
    }

    private ExecutorService executor() {
        return executor != null ? executor : WorkQueue.getExecutor();
    }

    private Collection<Pack> doGc() throws GitAPIException, IOException, ParseException {
        Collection<Pack> collectionRepack;
        if (this.automatic && !needGc()) {
            return Collections.emptyList();
        }
        Throwable th = null;
        try {
            PidLock pidLock = new PidLock();
            try {
                if (!pidLock.lock()) {
                    collectionRepack = Collections.emptyList();
                } else {
                    this.pm.start(6);
                    new PackRefsCommand(this.repo).setProgressMonitor(this.pm).setAll(true).call();
                    collectionRepack = repack();
                    prune(Collections.emptySet());
                    if (shouldWriteCommitGraphWhenGc()) {
                        writeCommitGraph(refsToObjectIds(getAllRefs()));
                    }
                }
                return collectionRepack;
            } finally {
                pidLock.close();
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

    private void loosen(ObjectDirectoryInserter objectDirectoryInserter, ObjectReader objectReader, Pack pack, HashSet<ObjectId> hashSet) throws IOException {
        Iterator<PackIndex.MutableEntry> it = pack.iterator();
        while (it.hasNext()) {
            ObjectId objectId = it.next().toObjectId();
            if (!hashSet.contains(objectId)) {
                hashSet.add(objectId);
                ObjectLoader objectLoaderOpen = objectReader.open(objectId);
                objectDirectoryInserter.insert(objectLoaderOpen.getType(), objectLoaderOpen.getSize(), (InputStream) objectLoaderOpen.openStream(), true);
            }
        }
    }

    private void deleteOldPacks(Collection<Pack> collection, Collection<Pack> collection2) throws IOException, ParseException {
        HashSet<ObjectId> hashSet = new HashSet<>();
        Iterator<Pack> it = collection2.iterator();
        while (it.hasNext()) {
            Iterator<PackIndex.MutableEntry> it2 = it.next().iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next().toObjectId());
            }
        }
        ObjectReader objectReaderNewObjectReader = this.repo.newObjectReader();
        ObjectDirectoryInserter objectDirectoryInserterNewInserter = this.repo.getObjectDatabase().newInserter();
        boolean z = !"now".equals(getPruneExpireStr()) && getExpireDate() < Long.MAX_VALUE;
        prunePreserved();
        long packExpireDate = getPackExpireDate();
        ArrayList arrayList = new ArrayList();
        for (Pack pack : collection) {
            checkCancelled();
            String packName = pack.getPackName();
            Iterator<Pack> it3 = collection2.iterator();
            do {
                if (!it3.hasNext()) {
                    if (!pack.shouldBeKept() && this.repo.getFS().lastModifiedInstant(pack.getPackFile()).toEpochMilli() < packExpireDate) {
                        if (z) {
                            loosen(objectDirectoryInserterNewInserter, objectReaderNewObjectReader, pack, hashSet);
                        }
                        pack.close();
                        arrayList.add(pack.getPackFile());
                        break;
                    }
                    break;
                }
            } while (!packName.equals(it3.next().getPackName()));
        }
        arrayList.forEach(new GC$$ExternalSyntheticLambda3(this));
        this.repo.getObjectDatabase().close();
    }

    private void removeOldPack(PackFile packFile, int i) throws IOException {
        if (this.pconfig.isPreserveOldPacks()) {
            File preservedDirectory = this.repo.getObjectDatabase().getPreservedDirectory();
            FileUtils.mkdir(preservedDirectory, true);
            FileUtils.rename(packFile, packFile.createPreservedForDirectory(preservedDirectory));
            return;
        }
        FileUtils.delete(packFile, i);
    }

    private void prunePreserved() {
        if (this.pconfig.isPrunePreserved()) {
            try {
                FileUtils.delete(this.repo.getObjectDatabase().getPreservedDirectory(), 7);
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prunePack(PackFile packFile) {
        try {
            removeOldPack(packFile.create(PackExt.PACK), 6);
            for (PackExt packExt : PackExt.valuesCustom()) {
                if (!PackExt.PACK.equals(packExt)) {
                    removeOldPack(packFile.create(packExt), 14);
                }
            }
        } catch (IOException unused) {
        }
    }

    public void prunePacked() throws IOException {
        String[] list;
        ObjectDirectory objectDatabase = this.repo.getObjectDatabase();
        Collection<Pack> packs = objectDatabase.getPacks();
        File objectsDirectory = this.repo.getObjectsDirectory();
        String[] list2 = objectsDirectory.list();
        if (list2 == null || list2.length <= 0) {
            return;
        }
        this.pm.beginTask(JGitText.get().pruneLoosePackedObjects, list2.length);
        try {
            for (String str : list2) {
                checkCancelled();
                this.pm.update(1);
                if (str.length() == 2 && (list = new File(objectsDirectory, str).list()) != null) {
                    for (String str2 : list) {
                        checkCancelled();
                        if (str2.length() == 38) {
                            try {
                                ObjectId objectIdFromString = ObjectId.fromString(str + str2);
                                for (Pack pack : packs) {
                                    checkCancelled();
                                    if (pack.hasObject(objectIdFromString)) {
                                        FileUtils.delete(objectDatabase.fileFor(objectIdFromString), 14);
                                        break;
                                    }
                                }
                            } catch (IllegalArgumentException unused) {
                            }
                        }
                    }
                }
            }
        } finally {
            this.pm.endTask();
        }
    }

    public void prune(Set<ObjectId> set) throws IOException, ParseException {
        Collection<Ref> allRefs;
        long j;
        long expireDate = getExpireDate();
        HashMap map = new HashMap();
        File objectsDirectory = this.repo.getObjectsDirectory();
        String[] list = objectsDirectory.list();
        if (list == null || list.length == 0) {
            return;
        }
        this.pm.beginTask(JGitText.get().pruneLooseUnreferencedObjects, list.length);
        try {
            int length = list.length;
            Set<ObjectId> setListNonHEADIndexObjects = null;
            int i = 0;
            while (i < length) {
                String str = list[i];
                checkCancelled();
                this.pm.update(1);
                if (str.length() == 2) {
                    File file = new File(objectsDirectory, str);
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                        j = expireDate;
                        FileUtils.delete(file, 8);
                    } else {
                        int length2 = fileArrListFiles.length;
                        int i2 = 0;
                        while (i2 < length2) {
                            File file2 = fileArrListFiles[i2];
                            checkCancelled();
                            String name = file2.getName();
                            long j2 = expireDate;
                            if (name.length() == 38 && this.repo.getFS().lastModifiedInstant(file2).toEpochMilli() < j2) {
                                try {
                                    ObjectId objectIdFromString = ObjectId.fromString(str + name);
                                    try {
                                        if (!set.contains(objectIdFromString)) {
                                            if (setListNonHEADIndexObjects == null) {
                                                setListNonHEADIndexObjects = listNonHEADIndexObjects();
                                            }
                                            if (!setListNonHEADIndexObjects.contains(objectIdFromString)) {
                                                map.put(objectIdFromString, file2);
                                            }
                                        }
                                    } catch (IllegalArgumentException unused) {
                                    }
                                } catch (IllegalArgumentException unused2) {
                                }
                            }
                            i2++;
                            expireDate = j2;
                        }
                    }
                    i++;
                    expireDate = j;
                }
                j = expireDate;
                i++;
                expireDate = j;
            }
            this.pm.endTask();
            if (map.isEmpty()) {
                return;
            }
            checkCancelled();
            Collection<Ref> collection = this.lastPackedRefs;
            if (collection == null || collection.isEmpty()) {
                allRefs = getAllRefs();
            } else {
                HashMap map2 = new HashMap();
                for (Ref ref : this.lastPackedRefs) {
                    map2.put(ref.getName(), ref);
                }
                allRefs = new ArrayList<>();
                for (Ref ref2 : getAllRefs()) {
                    if (!equals(ref2, (Ref) map2.get(ref2.getName()))) {
                        allRefs.add(ref2);
                    }
                }
            }
            if (!allRefs.isEmpty()) {
                ObjectWalk objectWalk = new ObjectWalk(this.repo);
                try {
                    for (Ref ref3 : allRefs) {
                        checkCancelled();
                        objectWalk.markStart(objectWalk.parseAny(ref3.getObjectId()));
                    }
                    Collection<Ref> collection2 = this.lastPackedRefs;
                    if (collection2 != null) {
                        Iterator<Ref> it = collection2.iterator();
                        while (it.hasNext()) {
                            objectWalk.markUninteresting(objectWalk.parseAny(it.next().getObjectId()));
                        }
                    }
                    removeReferenced(map, objectWalk);
                    objectWalk.dispose();
                } catch (Throwable th) {
                    objectWalk.dispose();
                    throw th;
                }
            }
            if (map.isEmpty()) {
                return;
            }
            ObjectWalk objectWalk2 = new ObjectWalk(this.repo);
            try {
                Iterator<Ref> it2 = getAllRefs().iterator();
                while (it2.hasNext()) {
                    for (ObjectId objectId : listRefLogObjects(it2.next(), this.lastRepackTime)) {
                        checkCancelled();
                        objectWalk2.markStart(objectWalk2.parseAny(objectId));
                    }
                }
                Collection<Ref> collection3 = this.lastPackedRefs;
                if (collection3 != null) {
                    for (Ref ref4 : collection3) {
                        checkCancelled();
                        objectWalk2.markUninteresting(objectWalk2.parseAny(ref4.getObjectId()));
                    }
                }
                removeReferenced(map, objectWalk2);
                objectWalk2.dispose();
                if (map.isEmpty()) {
                    return;
                }
                checkCancelled();
                HashSet hashSet = new HashSet();
                for (File file3 : map.values()) {
                    if (file3.lastModified() < expireDate) {
                        file3.delete();
                        hashSet.add(file3.getParentFile());
                    }
                }
                Iterator it3 = hashSet.iterator();
                while (it3.hasNext()) {
                    FileUtils.delete((File) it3.next(), 24);
                }
                this.repo.getObjectDatabase().close();
            } catch (Throwable th2) {
                objectWalk2.dispose();
                throw th2;
            }
        } catch (Throwable th3) {
            this.pm.endTask();
            throw th3;
        }
    }

    private long getExpireDate() throws ParseException {
        if (this.expire == null && this.expireAgeMillis == -1) {
            String pruneExpireStr = getPruneExpireStr();
            if (pruneExpireStr == null) {
                pruneExpireStr = PRUNE_EXPIRE_DEFAULT;
            }
            this.expire = GitDateParser.parse(pruneExpireStr, null, SystemReader.getInstance().getLocale());
            this.expireAgeMillis = -1L;
        }
        Date date = this.expire;
        return this.expireAgeMillis != -1 ? System.currentTimeMillis() - this.expireAgeMillis : date != null ? date.getTime() : Long.MAX_VALUE;
    }

    private String getPruneExpireStr() {
        return this.repo.getConfig().getString(ConfigConstants.CONFIG_GC_SECTION, null, ConfigConstants.CONFIG_KEY_PRUNEEXPIRE);
    }

    private long getPackExpireDate() throws ParseException {
        if (this.packExpire == null && this.packExpireAgeMillis == -1) {
            String string = this.repo.getConfig().getString(ConfigConstants.CONFIG_GC_SECTION, null, ConfigConstants.CONFIG_KEY_PRUNEPACKEXPIRE);
            if (string == null) {
                string = PRUNE_PACK_EXPIRE_DEFAULT;
            }
            this.packExpire = GitDateParser.parse(string, null, SystemReader.getInstance().getLocale());
            this.packExpireAgeMillis = -1L;
        }
        Date date = this.packExpire;
        return this.packExpireAgeMillis != -1 ? System.currentTimeMillis() - this.packExpireAgeMillis : date != null ? date.getTime() : Long.MAX_VALUE;
    }

    private void removeReferenced(Map<ObjectId, File> map, ObjectWalk objectWalk) throws IOException {
        RevCommit next = objectWalk.next();
        while (next != null) {
            checkCancelled();
            if (map.remove(next.getId()) != null && map.isEmpty()) {
                return;
            } else {
                next = objectWalk.next();
            }
        }
        RevObject revObjectNextObject = objectWalk.nextObject();
        while (revObjectNextObject != null) {
            checkCancelled();
            if (map.remove(revObjectNextObject.getId()) != null && map.isEmpty()) {
                return;
            } else {
                revObjectNextObject = objectWalk.nextObject();
            }
        }
    }

    private static boolean equals(Ref ref, Ref ref2) {
        if (ref != null && ref2 != null) {
            if (ref.isSymbolic()) {
                return ref2.isSymbolic() && ref.getTarget().getName().equals(ref2.getTarget().getName());
            }
            if (!ref2.isSymbolic() && Objects.equals(ref.getObjectId(), ref2.getObjectId())) {
                return true;
            }
        }
        return false;
    }

    public Collection<Pack> repack() throws Throwable {
        GC gc;
        Pack packWritePack;
        Collection<Pack> packs = this.repo.getObjectDatabase().getPacks();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Collection<Ref> allRefs = getAllRefs();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        Set<ObjectId> setListNonHEADIndexObjects = listNonHEADIndexObjects();
        Set<ObjectId> set = (Set) this.repo.getRefDatabase().getRefsByPrefix(this.pconfig.getBitmapExcludedRefsPrefixes()).stream().map(new GC$$ExternalSyntheticLambda13()).collect(Collectors.toSet());
        for (Ref ref : allRefs) {
            Set<ObjectId> set2 = set;
            HashSet hashSet6 = hashSet5;
            HashSet hashSet7 = hashSet4;
            checkCancelled();
            hashSet7.addAll(listRefLogObjects(ref, 0L));
            if (!ref.isSymbolic() && ref.getObjectId() != null) {
                if (isHead(ref)) {
                    hashSet2.add(ref.getObjectId());
                } else if (isTag(ref)) {
                    hashSet3.add(ref.getObjectId());
                } else {
                    hashSet7.add(ref.getObjectId());
                }
                if (ref.getPeeledObjectId() != null) {
                    hashSet6.add(ref.getPeeledObjectId());
                }
            }
            hashSet4 = hashSet7;
            hashSet5 = hashSet6;
            set = set2;
        }
        Set<ObjectId> set3 = set;
        ArrayList arrayList = new ArrayList();
        for (Pack pack : this.repo.getObjectDatabase().getPacks()) {
            ArrayList arrayList2 = arrayList;
            HashSet hashSet8 = hashSet5;
            HashSet hashSet9 = hashSet4;
            checkCancelled();
            if (!shouldPackKeptObjects() && pack.shouldBeKept()) {
                arrayList2.add(pack.m5707lambda$1$orgeclipsejgitinternalstoragefilePack());
            }
            hashSet4 = hashSet9;
            hashSet5 = hashSet8;
            arrayList = arrayList2;
        }
        hashSet3.removeAll(hashSet2);
        hashSet.addAll(hashSet2);
        hashSet.addAll(hashSet3);
        hashSet5.addAll(hashSet);
        hashSet4.addAll(setListNonHEADIndexObjects);
        if (this.pconfig.getSinglePack()) {
            hashSet.addAll(hashSet4);
            hashSet4.clear();
        }
        ArrayList arrayList3 = new ArrayList(2);
        if (!hashSet.isEmpty() && (packWritePack = writePack(hashSet, PackWriter.NONE, hashSet3, set3, hashSet5, arrayList, true)) != null) {
            arrayList3.add(packWritePack);
            arrayList.add(0, packWritePack.m5707lambda$1$orgeclipsejgitinternalstoragefilePack());
        }
        if (hashSet4.isEmpty()) {
            gc = this;
        } else {
            gc = this;
            Pack packWritePack2 = gc.writePack(hashSet4, hashSet, PackWriter.NONE, PackWriter.NONE, hashSet5, arrayList, false);
            if (packWritePack2 != null) {
                arrayList3.add(packWritePack2);
            }
        }
        try {
            gc.deleteOldPacks(packs, arrayList3);
            gc.prunePacked();
            if (gc.repo.getRefDatabase() instanceof RefDirectory) {
                gc.deleteEmptyRefsFolders();
            }
            gc.deleteOrphans();
            gc.deleteTempPacksIdx();
            gc.lastPackedRefs = allRefs;
            gc.lastRepackTime = jCurrentTimeMillis;
            return arrayList3;
        } catch (ParseException e) {
            throw new IOException(e);
        }
    }

    private Set<ObjectId> refsToObjectIds(Collection<Ref> collection) throws IOException {
        HashSet hashSet = new HashSet();
        for (Ref ref : collection) {
            checkCancelled();
            if (ref.getPeeledObjectId() != null) {
                hashSet.add(ref.getPeeledObjectId());
            } else if (ref.getObjectId() != null) {
                hashSet.add(ref.getObjectId());
            }
        }
        return hashSet;
    }

    /* JADX WARN: Code duplicated, block: B:67:0x00e9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.Set, java.util.Set<? extends org.eclipse.jgit.lib.ObjectId>] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.io.File] */
    void writeCommitGraph(Set<? extends ObjectId> set) throws IOException {
        Throwable th;
        if (!((CoreConfig) this.repo.getConfig().get(CoreConfig.KEY)).enableCommitGraph() || this.repo.getObjectDatabase().getShallowCommits().size() > 0) {
            return;
        }
        checkCancelled();
        if (set.isEmpty()) {
            return;
        }
        Throwable th2 = null;
        try {
            try {
                RevWalk revWalk = new RevWalk(this.repo);
                try {
                    CommitGraphWriter commitGraphWriter = new CommitGraphWriter(GraphCommits.fromWalk(this.pm, set, revWalk), shouldWriteBloomFilter());
                    File fileCreateTempFile = File.createTempFile("commit_", PackExt.COMMIT_GRAPH.getTmpExtension(), this.repo.getObjectDatabase().getInfoDirectory());
                    try {
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                            try {
                                FileChannel channel = fileOutputStream.getChannel();
                                try {
                                    OutputStream outputStreamNewOutputStream = Channels.newOutputStream(channel);
                                    try {
                                        commitGraphWriter.write(this.pm, outputStreamNewOutputStream);
                                        channel.force(true);
                                        if (outputStreamNewOutputStream != null) {
                                            outputStreamNewOutputStream.close();
                                        }
                                        if (channel != null) {
                                            channel.close();
                                        }
                                        fileOutputStream.close();
                                        FileUtils.rename(fileCreateTempFile, new File(this.repo.getObjectsDirectory(), Constants.INFO_COMMIT_GRAPH), StandardCopyOption.ATOMIC_MOVE);
                                        revWalk.close();
                                        if (fileCreateTempFile != null && fileCreateTempFile.exists()) {
                                            fileCreateTempFile.delete();
                                        }
                                        deleteTempCommitGraph();
                                    } catch (Throwable th3) {
                                        if (outputStreamNewOutputStream != null) {
                                            outputStreamNewOutputStream.close();
                                        }
                                        throw th3;
                                    }
                                } catch (Throwable th4) {
                                    if (0 == 0) {
                                        th2 = th4;
                                    } else if (null != th4) {
                                        th2.addSuppressed(th4);
                                    }
                                    if (channel == null) {
                                        throw th2;
                                    }
                                    channel.close();
                                    throw th2;
                                }
                            } catch (Throwable th5) {
                                if (0 == 0) {
                                    th2 = th5;
                                } else if (null != th5) {
                                    th2.addSuppressed(th5);
                                }
                                fileOutputStream.close();
                                throw th2;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            revWalk.close();
                            throw th;
                        }
                    } catch (Throwable th7) {
                        if (0 == 0) {
                            throw th7;
                        }
                        if (null == th7) {
                            throw null;
                        }
                        th2.addSuppressed(th7);
                    }
                } catch (Throwable th8) {
                    th = th8;
                }
            } catch (Throwable th9) {
                th = th9;
                if (0 != 0) {
                    throw th;
                }
                if (null != th) {
                    throw null;
                }
                try {
                    th2.addSuppressed(th);
                    throw null;
                } catch (Throwable th10) {
                    if (set != 0 && set.exists()) {
                        set.delete();
                    }
                    throw th10;
                }
                if (set != 0) {
                    set.delete();
                }
                throw th10;
            }
        } catch (Throwable th11) {
            th = th11;
            set = 0;
            if (0 != 0) {
                throw th;
            }
            if (null != th) {
                throw null;
            }
            th2.addSuppressed(th);
            throw null;
            if (set != 0) {
                set.delete();
            }
            throw th10;
        }
    }

    private void deleteTempCommitGraph() {
        Path path = this.repo.getObjectDatabase().getInfoDirectory().toPath();
        Instant instantMinus = Instant.now().minus(1L, (TemporalUnit) ChronoUnit.DAYS);
        if (Files.exists(path, new LinkOption[0])) {
            Throwable th = null;
            try {
                DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, "commit_*_tmp");
                try {
                    directoryStreamNewDirectoryStream.forEach(new GC$$ExternalSyntheticLambda18(instantMinus));
                } finally {
                    if (directoryStreamNewDirectoryStream != null) {
                        directoryStreamNewDirectoryStream.close();
                    }
                }
            } catch (Throwable th2) {
                if (0 == 0) {
                    throw th2;
                }
                if (null != th2) {
                    try {
                        th.addSuppressed(th2);
                    } catch (IOException e) {
                        LOG.error(e.getMessage(), (Throwable) e);
                        return;
                    }
                }
                throw null;
            }
        }
    }

    static /* synthetic */ void lambda$3(Instant instant, Path path) {
        try {
            if (Files.getLastModifiedTime(path, new LinkOption[0]).toInstant().isBefore(instant)) {
                Files.deleteIfExists(path);
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), (Throwable) e);
        }
    }

    boolean shouldWriteCommitGraphWhenGc() {
        return this.repo.getConfig().getBoolean(ConfigConstants.CONFIG_GC_SECTION, ConfigConstants.CONFIG_KEY_WRITE_COMMIT_GRAPH, false);
    }

    boolean shouldWriteBloomFilter() {
        return this.repo.getConfig().getBoolean(ConfigConstants.CONFIG_GC_SECTION, ConfigConstants.CONFIG_KEY_WRITE_CHANGED_PATHS, false);
    }

    private static boolean isHead(Ref ref) {
        return ref.getName().startsWith(Constants.R_HEADS);
    }

    private static boolean isTag(Ref ref) {
        return ref.getName().startsWith(Constants.R_TAGS);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0071 A[Catch: all -> 0x0075, TRY_ENTER, TryCatch #1 {all -> 0x0075, blocks: (B:3:0x001d, B:8:0x0036, B:28:0x0071, B:29:0x0074, B:4:0x002a, B:5:0x002e, B:22:0x0068, B:24:0x006c), top: B:38:0x001d, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:51:? A[Catch: all -> 0x0075, SYNTHETIC, TRY_LEAVE, TryCatch #1 {all -> 0x0075, blocks: (B:3:0x001d, B:8:0x0036, B:28:0x0071, B:29:0x0074, B:4:0x002a, B:5:0x002e, B:22:0x0068, B:24:0x006c), top: B:38:0x001d, inners: #3 }] */
    private void deleteEmptyRefsFolders() throws Throwable {
        Path pathResolve = this.repo.getCommonDirectory().toPath().resolve(Constants.R_REFS);
        Instant instantMinus = Instant.now().minus(30L, (TemporalUnit) ChronoUnit.SECONDS);
        Throwable th = null;
        try {
            Stream<Path> streamFilter = Files.list(pathResolve).filter(new GC$$ExternalSyntheticLambda8());
            try {
                Iterator<Path> it = streamFilter.iterator();
                while (it.hasNext()) {
                    try {
                        Stream<Path> list = Files.list(it.next());
                        try {
                            list.filter(new GC$$ExternalSyntheticLambda9(this, instantMinus)).forEach(new GC$$ExternalSyntheticLambda10(this));
                            if (list != null) {
                                list.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (list == null) {
                                throw th;
                            }
                            list.close();
                            throw th;
                            if (streamFilter != null) {
                                throw th;
                            }
                            streamFilter.close();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        if (th == null) {
                            throw th3;
                        }
                        if (th != th3) {
                            th.addSuppressed(th3);
                        }
                        throw th;
                    }
                }
                if (streamFilter != null) {
                    streamFilter.close();
                }
            } catch (Throwable th4) {
                if (streamFilter != null) {
                    throw th4;
                }
                streamFilter.close();
                throw th4;
            }
        } catch (Throwable th5) {
            if (th == null) {
                throw th5;
            }
            if (th != th5) {
                th.addSuppressed(th5);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: canBeSafelyDeleted, reason: merged with bridge method [inline-methods] */
    public boolean m5697lambda$5$orgeclipsejgitinternalstoragefileGC(Path path, Instant instant) {
        try {
            return Files.getLastModifiedTime(path, new LinkOption[0]).toInstant().isBefore(instant);
        } catch (IOException e) {
            LOG.warn(MessageFormat.format(JGitText.get().cannotAccessLastModifiedForSafeDeletion, path), (Throwable) e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteDir(Path path) {
        Throwable th = null;
        try {
            Stream<Path> streamWalk = Files.walk(path, new FileVisitOption[0]);
            try {
                streamWalk.filter(new GC$$ExternalSyntheticLambda14(this)).sorted(Comparator.reverseOrder()).forEach(new GC$$ExternalSyntheticLambda15(this));
            } finally {
                if (streamWalk != null) {
                    streamWalk.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                try {
                    th.addSuppressed(th2);
                } catch (IOException e) {
                    LOG.error(e.getMessage(), (Throwable) e);
                    return;
                }
            }
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDirectory(Path path) {
        return path.toFile().isDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete(Path path) {
        try {
            Files.delete(path);
        } catch (DirectoryNotEmptyException unused) {
        } catch (IOException e) {
            LOG.error(MessageFormat.format(JGitText.get().cannotDeleteFile, path), (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Optional<PackFile> toPackFileWithValidExt(Path path) {
        try {
            PackFile packFile = new PackFile(path.toFile());
            if (packFile.getPackExt() == null) {
                return Optional.empty();
            }
            return Optional.of(packFile);
        } catch (IllegalArgumentException unused) {
            return Optional.empty();
        }
    }

    private void deleteOrphans() {
        Path path = this.repo.getObjectDatabase().getPackDirectory().toPath();
        HashSet hashSet = new HashSet();
        Throwable th = null;
        try {
            Stream<Path> list = Files.list(path);
            try {
                List<PackFile> list2 = (List) list.map(new GC$$ExternalSyntheticLambda4()).filter(new GC$$ExternalSyntheticLambda5()).map(new GC$$ExternalSyntheticLambda6()).filter(new GC$$ExternalSyntheticLambda7(hashSet)).collect(Collectors.toList());
                if (list != null) {
                    list.close();
                }
                for (PackFile packFile : list2) {
                    if (!hashSet.contains(packFile.getId())) {
                        try {
                            FileUtils.delete(packFile, 6);
                            LOG.warn(JGitText.get().deletedOrphanInPackDir, packFile);
                        } catch (IOException e) {
                            LOG.error(e.getMessage(), (Throwable) e);
                        }
                    }
                }
            } catch (Throwable th2) {
                if (list == null) {
                    throw th2;
                }
                list.close();
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                try {
                    th.addSuppressed(th3);
                } catch (IOException e2) {
                    LOG.error(e2.getMessage(), (Throwable) e2);
                    return;
                }
            }
            throw null;
        }
    }

    static /* synthetic */ boolean lambda$12(Set set, PackFile packFile) {
        PackExt packExt = packFile.getPackExt();
        if (PARENT_EXTS.contains(packExt)) {
            set.add(packFile.getId());
            return false;
        }
        return CHILD_EXTS.contains(packExt);
    }

    private void deleteTempPacksIdx() {
        Path path = this.repo.getObjectDatabase().getPackDirectory().toPath();
        Instant instantMinus = Instant.now().minus(1L, (TemporalUnit) ChronoUnit.DAYS);
        if (Files.exists(path, new LinkOption[0])) {
            Throwable th = null;
            try {
                DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, "gc_*_tmp");
                try {
                    directoryStreamNewDirectoryStream.forEach(new GC$$ExternalSyntheticLambda12(instantMinus));
                } finally {
                    if (directoryStreamNewDirectoryStream != null) {
                        directoryStreamNewDirectoryStream.close();
                    }
                }
            } catch (Throwable th2) {
                if (0 == 0) {
                    throw th2;
                }
                if (null != th2) {
                    try {
                        th.addSuppressed(th2);
                    } catch (IOException e) {
                        LOG.error(e.getMessage(), (Throwable) e);
                        return;
                    }
                }
                throw null;
            }
        }
    }

    static /* synthetic */ void lambda$13(Instant instant, Path path) {
        try {
            if (Files.getLastModifiedTime(path, new LinkOption[0]).toInstant().isBefore(instant)) {
                Files.deleteIfExists(path);
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), (Throwable) e);
        }
    }

    private Set<ObjectId> listRefLogObjects(Ref ref, long j) throws IOException {
        List<ReflogEntry> reverseEntries = this.repo.getReflogReader(ref).getReverseEntries();
        if (reverseEntries == null || reverseEntries.isEmpty()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (ReflogEntry reflogEntry : reverseEntries) {
            if (reflogEntry.getWho().getWhen().getTime() < j) {
                break;
            }
            ObjectId newId = reflogEntry.getNewId();
            if (newId != null && !ObjectId.zeroId().equals((AnyObjectId) newId)) {
                hashSet.add(newId);
            }
            ObjectId oldId = reflogEntry.getOldId();
            if (oldId != null && !ObjectId.zeroId().equals((AnyObjectId) oldId)) {
                hashSet.add(oldId);
            }
        }
        return hashSet;
    }

    private Collection<Ref> getAllRefs() throws IOException {
        RefDatabase refDatabase = this.repo.getRefDatabase();
        List<Ref> refs = refDatabase.getRefs();
        List<Ref> additionalRefs = refDatabase.getAdditionalRefs();
        if (additionalRefs.isEmpty()) {
            return refs;
        }
        ArrayList arrayList = new ArrayList(refs.size() + additionalRefs.size());
        arrayList.addAll(refs);
        for (Ref ref : additionalRefs) {
            checkCancelled();
            if (ref.getName().startsWith(Constants.R_REFS)) {
                arrayList.add(ref);
            }
        }
        return arrayList;
    }

    private Set<ObjectId> listNonHEADIndexObjects() throws IOException {
        if (this.repo.isBare()) {
            return Collections.emptySet();
        }
        Throwable th = null;
        try {
            TreeWalk treeWalk = new TreeWalk(this.repo);
            try {
                treeWalk.addTree(new DirCacheIterator(this.repo.readDirCache()));
                ObjectId objectIdResolve = this.repo.resolve("HEAD");
                if (objectIdResolve != null) {
                    try {
                        RevWalk revWalk = new RevWalk(this.repo);
                        try {
                            treeWalk.addTree(revWalk.parseTree(objectIdResolve));
                            revWalk.close();
                        } catch (Throwable th2) {
                            revWalk.close();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        if (0 == 0) {
                            throw th3;
                        }
                        if (null == th3) {
                            throw null;
                        }
                        th.addSuppressed(th3);
                        throw null;
                    }
                }
                treeWalk.setFilter(TreeFilter.ANY_DIFF);
                treeWalk.setRecursive(true);
                HashSet hashSet = new HashSet();
                while (treeWalk.next()) {
                    checkCancelled();
                    ObjectId objectId = treeWalk.getObjectId(0);
                    int rawMode = treeWalk.getRawMode(0) & FileMode.TYPE_MASK;
                    if (rawMode != 0) {
                        if (rawMode == 16384 || rawMode == 32768 || rawMode == 40960) {
                            hashSet.add(objectId);
                        } else if (rawMode != 57344) {
                            throw new IOException(MessageFormat.format(JGitText.get().corruptObjectInvalidMode3, String.format("%o", Integer.valueOf(treeWalk.getRawMode(0))), objectId == null ? AbstractJsonLexerKt.NULL : objectId.name(), treeWalk.getPathString(), this.repo.getIndexFile()));
                        }
                    }
                }
                treeWalk.close();
                return hashSet;
            } catch (Throwable th4) {
                treeWalk.close();
                throw th4;
            }
        } catch (Throwable th5) {
            if (0 == 0) {
                throw th5;
            }
            if (null == th5) {
                throw null;
            }
            th.addSuppressed(th5);
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.io.File] */
    private Pack writePack(Set<? extends ObjectId> set, Set<? extends ObjectId> set2, Set<ObjectId> set3, Set<ObjectId> set4, Set<ObjectId> set5, List<ObjectIdSet> list, boolean z) throws Throwable {
        Throwable th;
        ?? r11;
        Throwable th2;
        checkCancelled();
        TreeMap treeMap = new TreeMap(new GC$$ExternalSyntheticLambda17());
        Throwable th3 = null;
        try {
            PackWriter packWriter = new PackWriter(this.pconfig, this.repo.newObjectReader());
            boolean z2 = true;
            try {
                try {
                    packWriter.setDeltaBaseAsOffset(true);
                    packWriter.setReuseDeltaCommits(false);
                    if (set5 != null) {
                        packWriter.setTagTargets(set5);
                    }
                    if (list != null) {
                        Iterator<ObjectIdSet> it = list.iterator();
                        while (it.hasNext()) {
                            packWriter.excludeObjects(it.next());
                        }
                    }
                    packWriter.setCreateBitmaps(z);
                    packWriter.preparePack(this.pm, set, set2, PackWriter.NONE, union(set3, set4));
                    if (packWriter.getObjectCount() != 0) {
                        checkCancelled();
                        ObjectId objectIdComputeName = packWriter.computeName();
                        File packDirectory = this.repo.getObjectDatabase().getPackDirectory();
                        packDirectory.mkdirs();
                        File fileCreateTempFile = File.createTempFile("gc_", PackExt.PACK.getTmpExtension(), packDirectory);
                        try {
                            String strSubstring = fileCreateTempFile.getName().substring(0, fileCreateTempFile.getName().lastIndexOf(46));
                            File file = new File(packDirectory, strSubstring + PackExt.INDEX.getTmpExtension());
                            treeMap.put(PackExt.INDEX, file);
                            if (!file.createNewFile()) {
                                throw new IOException(MessageFormat.format(JGitText.get().cannotCreateIndexfile, file.getPath()));
                            }
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                                try {
                                    FileChannel channel = fileOutputStream.getChannel();
                                    try {
                                        OutputStream outputStreamNewOutputStream = Channels.newOutputStream(channel);
                                        try {
                                            ProgressMonitor progressMonitor = this.pm;
                                            packWriter.writePack(progressMonitor, progressMonitor, outputStreamNewOutputStream);
                                            channel.force(true);
                                            if (outputStreamNewOutputStream != null) {
                                                outputStreamNewOutputStream.close();
                                            }
                                            if (channel != null) {
                                                channel.close();
                                            }
                                            fileOutputStream.close();
                                            try {
                                                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                                try {
                                                    FileChannel channel2 = fileOutputStream2.getChannel();
                                                    try {
                                                        OutputStream outputStreamNewOutputStream2 = Channels.newOutputStream(channel2);
                                                        try {
                                                            packWriter.writeIndex(outputStreamNewOutputStream2);
                                                            channel2.force(true);
                                                            if (outputStreamNewOutputStream2 != null) {
                                                                outputStreamNewOutputStream2.close();
                                                            }
                                                            if (channel2 != null) {
                                                                channel2.close();
                                                            }
                                                            fileOutputStream2.close();
                                                            if (packWriter.isReverseIndexEnabled()) {
                                                                File file2 = new File(packDirectory, strSubstring + PackExt.REVERSE_INDEX.getTmpExtension());
                                                                treeMap.put(PackExt.REVERSE_INDEX, file2);
                                                                if (!file2.createNewFile()) {
                                                                    throw new IOException(MessageFormat.format(JGitText.get().cannotCreateIndexfile, file2.getPath()));
                                                                }
                                                                try {
                                                                    FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
                                                                    try {
                                                                        FileChannel channel3 = fileOutputStream3.getChannel();
                                                                        try {
                                                                            OutputStream outputStreamNewOutputStream3 = Channels.newOutputStream(channel3);
                                                                            try {
                                                                                packWriter.writeReverseIndex(outputStreamNewOutputStream3);
                                                                                channel3.force(true);
                                                                                if (outputStreamNewOutputStream3 != null) {
                                                                                    outputStreamNewOutputStream3.close();
                                                                                }
                                                                                if (channel3 != null) {
                                                                                    channel3.close();
                                                                                }
                                                                                fileOutputStream3.close();
                                                                            } catch (Throwable th4) {
                                                                                if (outputStreamNewOutputStream3 == null) {
                                                                                    throw th4;
                                                                                }
                                                                                outputStreamNewOutputStream3.close();
                                                                                throw th4;
                                                                            }
                                                                        } catch (Throwable th5) {
                                                                            if (0 == 0) {
                                                                                th3 = th5;
                                                                            } else if (null != th5) {
                                                                                th3.addSuppressed(th5);
                                                                            }
                                                                            if (channel3 == null) {
                                                                                throw th3;
                                                                            }
                                                                            channel3.close();
                                                                            throw th3;
                                                                        }
                                                                    } catch (Throwable th6) {
                                                                        if (0 == 0) {
                                                                            th3 = th6;
                                                                        } else if (null != th6) {
                                                                            th3.addSuppressed(th6);
                                                                        }
                                                                        fileOutputStream3.close();
                                                                        throw th3;
                                                                    }
                                                                } catch (Throwable th7) {
                                                                    if (0 == 0) {
                                                                        throw th7;
                                                                    }
                                                                    if (null != th7) {
                                                                        th3.addSuppressed(th7);
                                                                    }
                                                                    throw null;
                                                                }
                                                            }
                                                            if (packWriter.prepareBitmapIndex(this.pm)) {
                                                                File file3 = new File(packDirectory, strSubstring + PackExt.BITMAP_INDEX.getTmpExtension());
                                                                treeMap.put(PackExt.BITMAP_INDEX, file3);
                                                                if (!file3.createNewFile()) {
                                                                    throw new IOException(MessageFormat.format(JGitText.get().cannotCreateIndexfile, file3.getPath()));
                                                                }
                                                                try {
                                                                    FileOutputStream fileOutputStream4 = new FileOutputStream(file3);
                                                                    try {
                                                                        FileChannel channel4 = fileOutputStream4.getChannel();
                                                                        try {
                                                                            OutputStream outputStreamNewOutputStream4 = Channels.newOutputStream(channel4);
                                                                            try {
                                                                                packWriter.writeBitmapIndex(new PackBitmapIndexWriterV1(outputStreamNewOutputStream4));
                                                                                channel4.force(true);
                                                                                if (outputStreamNewOutputStream4 != null) {
                                                                                    outputStreamNewOutputStream4.close();
                                                                                }
                                                                                if (channel4 != null) {
                                                                                    channel4.close();
                                                                                }
                                                                                fileOutputStream4.close();
                                                                            } catch (Throwable th8) {
                                                                                if (outputStreamNewOutputStream4 == null) {
                                                                                    throw th8;
                                                                                }
                                                                                outputStreamNewOutputStream4.close();
                                                                                throw th8;
                                                                            }
                                                                        } catch (Throwable th9) {
                                                                            if (0 == 0) {
                                                                                th3 = th9;
                                                                            } else if (null != th9) {
                                                                                th3.addSuppressed(th9);
                                                                            }
                                                                            if (channel4 == null) {
                                                                                throw th3;
                                                                            }
                                                                            channel4.close();
                                                                            throw th3;
                                                                        }
                                                                    } catch (Throwable th10) {
                                                                        if (0 == 0) {
                                                                            th3 = th10;
                                                                        } else if (null != th10) {
                                                                            th3.addSuppressed(th10);
                                                                        }
                                                                        fileOutputStream4.close();
                                                                        throw th3;
                                                                    }
                                                                } catch (Throwable th11) {
                                                                    if (0 == 0) {
                                                                        throw th11;
                                                                    }
                                                                    if (null != th11) {
                                                                        th3.addSuppressed(th11);
                                                                    }
                                                                    throw null;
                                                                }
                                                            }
                                                            File packDirectory2 = this.repo.getObjectDatabase().getPackDirectory();
                                                            PackFile packFile = new PackFile(packDirectory2, objectIdComputeName, PackExt.PACK);
                                                            this.repo.getObjectDatabase().closeAllPackHandles(packFile);
                                                            fileCreateTempFile.setReadOnly();
                                                            FileUtils.rename(fileCreateTempFile, packFile, StandardCopyOption.ATOMIC_MOVE);
                                                            for (Map.Entry entry : treeMap.entrySet()) {
                                                                File file4 = (File) entry.getValue();
                                                                file4.setReadOnly();
                                                                PackFile packFile2 = new PackFile(packDirectory2, objectIdComputeName, (PackExt) entry.getKey());
                                                                try {
                                                                    FileUtils.rename(file4, packFile2, StandardCopyOption.ATOMIC_MOVE);
                                                                } catch (IOException e) {
                                                                    IOException iOException = e;
                                                                    File file5 = new File(packFile2.getParentFile(), packFile2.getName() + ".new");
                                                                    try {
                                                                        FileUtils.rename(file4, file5, StandardCopyOption.ATOMIC_MOVE);
                                                                        file4 = file5;
                                                                    } catch (IOException e2) {
                                                                        iOException = e2;
                                                                    }
                                                                    throw new IOException(MessageFormat.format(JGitText.get().panicCantRenameIndexFile, file4, packFile2), iOException);
                                                                }
                                                            }
                                                            try {
                                                                FileSnapshot fileSnapshotSave = FileSnapshot.save(packFile);
                                                                if (this.pconfig.doWaitPreventRacyPack(fileSnapshotSave.size())) {
                                                                    fileSnapshotSave.waitUntilNotRacy();
                                                                }
                                                                z2 = false;
                                                            } catch (InterruptedException unused) {
                                                            }
                                                            try {
                                                                Pack packOpenPack = this.repo.getObjectDatabase().openPack(packFile);
                                                                if (z2) {
                                                                    Thread.currentThread().interrupt();
                                                                }
                                                                packWriter.close();
                                                                if (fileCreateTempFile != null && fileCreateTempFile.exists()) {
                                                                    fileCreateTempFile.delete();
                                                                }
                                                                for (File file6 : treeMap.values()) {
                                                                    if (file6.exists()) {
                                                                        file6.delete();
                                                                    }
                                                                }
                                                                return packOpenPack;
                                                            } catch (Throwable th12) {
                                                                if (z2) {
                                                                    Thread.currentThread().interrupt();
                                                                    throw th12;
                                                                }
                                                                throw th12;
                                                            }
                                                        } catch (Throwable th13) {
                                                            if (outputStreamNewOutputStream2 == null) {
                                                                throw th13;
                                                            }
                                                            outputStreamNewOutputStream2.close();
                                                            throw th13;
                                                        }
                                                    } catch (Throwable th14) {
                                                        if (0 == 0) {
                                                            th3 = th14;
                                                        } else if (null != th14) {
                                                            th3.addSuppressed(th14);
                                                        }
                                                        if (channel2 == null) {
                                                            throw th3;
                                                        }
                                                        channel2.close();
                                                        throw th3;
                                                    }
                                                } catch (Throwable th15) {
                                                    if (0 == 0) {
                                                        th3 = th15;
                                                    } else if (null != th15) {
                                                        th3.addSuppressed(th15);
                                                    }
                                                    fileOutputStream2.close();
                                                    throw th3;
                                                }
                                            } catch (Throwable th16) {
                                                if (0 == 0) {
                                                    throw th16;
                                                }
                                                if (null != th16) {
                                                    th3.addSuppressed(th16);
                                                }
                                                throw null;
                                            }
                                        } catch (Throwable th17) {
                                            if (outputStreamNewOutputStream == null) {
                                                throw th17;
                                            }
                                            outputStreamNewOutputStream.close();
                                            throw th17;
                                        }
                                    } catch (Throwable th18) {
                                        if (0 == 0) {
                                            th3 = th18;
                                        } else if (null != th18) {
                                            th3.addSuppressed(th18);
                                        }
                                        if (channel == null) {
                                            throw th3;
                                        }
                                        channel.close();
                                        throw th3;
                                    }
                                } catch (Throwable th19) {
                                    if (0 == 0) {
                                        th3 = th19;
                                    } else if (null != th19) {
                                        th3.addSuppressed(th19);
                                    }
                                    fileOutputStream.close();
                                    throw th3;
                                }
                            } catch (Throwable th20) {
                                if (0 == 0) {
                                    throw th20;
                                }
                                if (null != th20) {
                                    th3.addSuppressed(th20);
                                }
                                throw null;
                            }
                        } catch (Throwable th21) {
                            th2 = th21;
                            Throwable th22 = th2;
                            packWriter.close();
                            throw th22;
                        }
                    }
                    packWriter.close();
                    for (File file7 : treeMap.values()) {
                        if (file7.exists()) {
                            file7.delete();
                        }
                    }
                    return null;
                } catch (Throwable th23) {
                    th2 = th23;
                }
            } catch (Throwable th24) {
                th = th24;
                r11 = set4;
                if (0 == 0) {
                    throw th;
                }
                if (null != th) {
                    try {
                        th3.addSuppressed(th);
                    } catch (Throwable th25) {
                        if (r11 != 0 && r11.exists()) {
                            r11.delete();
                        }
                        for (File file8 : treeMap.values()) {
                            if (file8.exists()) {
                                file8.delete();
                            }
                        }
                        throw th25;
                    }
                }
                throw null;
            }
        } catch (Throwable th26) {
            th = th26;
            r11 = 0;
        }
    }

    static /* synthetic */ int lambda$14(PackExt packExt, PackExt packExt2) {
        if (packExt == packExt2) {
            return 0;
        }
        if (packExt == PackExt.INDEX) {
            return 1;
        }
        if (packExt2 == PackExt.INDEX) {
            return -1;
        }
        return Integer.signum(packExt.hashCode() - packExt2.hashCode());
    }

    private Set<? extends ObjectId> union(Set<ObjectId> set, Set<ObjectId> set2) {
        HashSet hashSet = new HashSet(set.size() + set2.size());
        hashSet.addAll(set);
        hashSet.addAll(set2);
        return hashSet;
    }

    private void checkCancelled() throws CancelledException {
        if (this.pm.isCancelled() || Thread.currentThread().isInterrupted()) {
            throw new CancelledException(JGitText.get().operationCanceled);
        }
    }

    public void setPackKeptObjects(boolean z) {
        this.packKeptObjects = Boolean.valueOf(z);
    }

    private boolean shouldPackKeptObjects() {
        return ((Boolean) Optional.ofNullable(this.packKeptObjects).orElse(Boolean.valueOf(this.pconfig.isPackKeptObjects()))).booleanValue();
    }

    public static class RepoStatistics {
        public long numberOfBitmaps;
        public long numberOfLooseObjects;
        public long numberOfLooseRefs;
        public long numberOfObjectsSinceBitmap;
        public long numberOfPackFiles;
        public long numberOfPackFilesSinceBitmap;
        public long numberOfPackedObjects;
        public long numberOfPackedRefs;
        public long sizeOfLooseObjects;
        public long sizeOfPackedObjects;

        public String toString() {
            StringBuilder sb = new StringBuilder("numberOfPackedObjects=");
            sb.append(this.numberOfPackedObjects);
            sb.append(", numberOfPackFiles=").append(this.numberOfPackFiles);
            sb.append(", numberOfPackFilesSinceBitmap=").append(this.numberOfPackFilesSinceBitmap);
            sb.append(", numberOfObjectsSinceBitmap=").append(this.numberOfObjectsSinceBitmap);
            sb.append(", numberOfLooseObjects=").append(this.numberOfLooseObjects);
            sb.append(", numberOfLooseRefs=").append(this.numberOfLooseRefs);
            sb.append(", numberOfPackedRefs=").append(this.numberOfPackedRefs);
            sb.append(", sizeOfLooseObjects=").append(this.sizeOfLooseObjects);
            sb.append(", sizeOfPackedObjects=").append(this.sizeOfPackedObjects);
            sb.append(", numberOfBitmaps=").append(this.numberOfBitmaps);
            return sb.toString();
        }
    }

    public RepoStatistics getStatistics() throws IOException {
        File[] fileArrListFiles;
        RepoStatistics repoStatistics = new RepoStatistics();
        long epochMilli = Long.MIN_VALUE;
        for (Pack pack : this.repo.getObjectDatabase().getPacks()) {
            long objectCount = pack.m5707lambda$1$orgeclipsejgitinternalstoragefilePack().getObjectCount();
            repoStatistics.numberOfPackedObjects += objectCount;
            repoStatistics.numberOfPackFiles++;
            repoStatistics.sizeOfPackedObjects += pack.getPackFile().length();
            if (pack.getBitmapIndex() != null) {
                repoStatistics.numberOfBitmaps += (long) pack.getBitmapIndex().getBitmapCount();
                epochMilli = pack.getFileSnapshot().lastModifiedInstant().toEpochMilli();
            } else {
                repoStatistics.numberOfPackFilesSinceBitmap++;
                repoStatistics.numberOfObjectsSinceBitmap += objectCount;
            }
        }
        File objectsDirectory = this.repo.getObjectsDirectory();
        String[] list = objectsDirectory.list();
        if (list != null && list.length > 0) {
            for (String str : list) {
                if (str.length() == 2 && (fileArrListFiles = new File(objectsDirectory, str).listFiles()) != null) {
                    for (File file : fileArrListFiles) {
                        if (file.getName().length() == 38) {
                            repoStatistics.numberOfLooseObjects++;
                            repoStatistics.sizeOfLooseObjects += file.length();
                            if (file.lastModified() > epochMilli) {
                                repoStatistics.numberOfObjectsSinceBitmap++;
                            }
                        }
                    }
                }
            }
        }
        Iterator<Ref> it = this.repo.getRefDatabase().getRefs().iterator();
        while (it.hasNext()) {
            Ref.Storage storage = it.next().getStorage();
            if (storage == Ref.Storage.LOOSE || storage == Ref.Storage.LOOSE_PACKED) {
                repoStatistics.numberOfLooseRefs++;
            }
            if (storage == Ref.Storage.PACKED || storage == Ref.Storage.LOOSE_PACKED) {
                repoStatistics.numberOfPackedRefs++;
            }
        }
        return repoStatistics;
    }

    public GC setProgressMonitor(ProgressMonitor progressMonitor) {
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        this.pm = progressMonitor;
        return this;
    }

    public void setExpireAgeMillis(long j) {
        this.expireAgeMillis = j;
        this.expire = null;
    }

    public void setPackExpireAgeMillis(long j) {
        this.packExpireAgeMillis = j;
        this.expire = null;
    }

    public void setPackConfig(PackConfig packConfig) {
        this.pconfig = packConfig;
    }

    public void setExpire(Date date) {
        this.expire = date;
        this.expireAgeMillis = -1L;
    }

    public void setPackExpire(Date date) {
        this.packExpire = date;
        this.packExpireAgeMillis = -1L;
    }

    public void setAuto(boolean z) {
        this.automatic = z;
    }

    void setBackground(boolean z) {
        this.background = z;
    }

    private boolean needGc() {
        if (tooManyPacks()) {
            addRepackAllOption();
            return true;
        }
        return tooManyLooseObjects();
    }

    boolean tooManyPacks() {
        int i = this.repo.getConfig().getInt(ConfigConstants.CONFIG_GC_SECTION, ConfigConstants.CONFIG_KEY_AUTOPACKLIMIT, 50);
        return i > 0 && this.repo.getObjectDatabase().getPacks().size() > i + 1;
    }

    boolean tooManyLooseObjects() {
        int looseObjectLimit = getLooseObjectLimit();
        if (looseObjectLimit <= 0) {
            return false;
        }
        int i = (looseObjectLimit + 255) / 256;
        Path pathResolve = this.repo.getObjectsDirectory().toPath().resolve("17");
        if (!pathResolve.toFile().exists()) {
            return false;
        }
        Throwable th = null;
        try {
            DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(pathResolve, new GC$$ExternalSyntheticLambda16());
            try {
                Iterator<Path> it = directoryStreamNewDirectoryStream.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    i2++;
                    if (i2 > i) {
                        if (directoryStreamNewDirectoryStream != null) {
                            directoryStreamNewDirectoryStream.close();
                        }
                        return true;
                    }
                    it.next();
                }
                if (directoryStreamNewDirectoryStream != null) {
                    directoryStreamNewDirectoryStream.close();
                }
                return false;
            } catch (Throwable th2) {
                if (directoryStreamNewDirectoryStream == null) {
                    throw th2;
                }
                directoryStreamNewDirectoryStream.close();
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                try {
                    th.addSuppressed(th3);
                } catch (IOException e) {
                    LOG.error(e.getMessage(), (Throwable) e);
                }
            }
            throw null;
        }
    }

    static /* synthetic */ boolean lambda$15(Path path) throws IOException {
        Path fileName = path.getFileName();
        return path.toFile().isFile() && fileName != null && PATTERN_LOOSE_OBJECT.matcher(fileName.toString()).matches();
    }

    private int getLooseObjectLimit() {
        return this.repo.getConfig().getInt(ConfigConstants.CONFIG_GC_SECTION, "auto", DEFAULT_AUTOLIMIT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class PidLock implements AutoCloseable {
        private static final String GC_PID = "gc.pid";
        private FileChannel channel;
        private RandomAccessFile f;
        private FileLock lock;
        private final Path pidFile;
        private ShutdownHook.Listener shutdownListener = new GC$PidLock$$ExternalSyntheticLambda0(this);
        private FS.LockToken token;

        PidLock() {
            this.pidFile = GC.this.repo.getDirectory().toPath().resolve(GC_PID);
        }

        boolean lock() throws IOException {
            if (Files.exists(this.pidFile, new LinkOption[0])) {
                Instant instantLastModifiedInstant = FS.DETECTED.lastModifiedInstant(this.pidFile.toFile());
                if (instantLastModifiedInstant.compareTo(Instant.now().minus(12L, (TemporalUnit) ChronoUnit.HOURS)) > 0) {
                    gcAlreadyRunning();
                    return false;
                }
                GC.LOG.warn(MessageFormat.format(JGitText.get().stalePidLock, this.pidFile, instantLastModifiedInstant));
            }
            try {
                this.token = FS.DETECTED.createNewFileAtomic(this.pidFile.toFile());
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.pidFile.toFile(), "rw");
                this.f = randomAccessFile;
                FileChannel channel = randomAccessFile.getChannel();
                this.channel = channel;
                FileLock fileLockTryLock = channel.tryLock();
                this.lock = fileLockTryLock;
                if (fileLockTryLock != null && fileLockTryLock.isValid()) {
                    this.channel.write(ByteBuffer.wrap(getProcDesc().getBytes(StandardCharsets.UTF_8)));
                    ShutdownHook.INSTANCE.register(this.shutdownListener);
                    return true;
                }
                gcAlreadyRunning();
                return false;
            } catch (IOException | OverlappingFileLockException e) {
                try {
                    failedToLock();
                } catch (Exception e2) {
                    GC.LOG.error(MessageFormat.format(JGitText.get().closePidLockFailed, this.pidFile), (Throwable) e2);
                }
                throw e;
            }
        }

        private void failedToLock() {
            close();
            GC.LOG.error(MessageFormat.format(JGitText.get().failedPidLock, this.pidFile));
        }

        private void gcAlreadyRunning() {
            String str;
            String str2;
            close();
            Throwable th = null;
            try {
                Stream<String> streamLines = Files.lines(this.pidFile);
                try {
                    Optional<String> optionalFindFirst = streamLines.findFirst();
                    if (optionalFindFirst.isPresent()) {
                        String[] strArrSplit = optionalFindFirst.get().split(WalkEncryption.Vals.REGEX_WS);
                        str2 = strArrSplit[0];
                        str = strArrSplit[1];
                    } else {
                        str = null;
                        str2 = null;
                    }
                    if (!StringUtils.isEmptyOrNull(str) && !StringUtils.isEmptyOrNull(str2)) {
                        GC.LOG.error(MessageFormat.format(JGitText.get().gcAlreadyRunning, str, str2));
                        if (streamLines != null) {
                            streamLines.close();
                            return;
                        }
                        return;
                    }
                    if (streamLines != null) {
                        streamLines.close();
                    }
                    GC.LOG.error(MessageFormat.format(JGitText.get().failedPidLock, this.pidFile));
                } catch (Throwable th2) {
                    if (streamLines != null) {
                        streamLines.close();
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    throw th3;
                }
                if (null == th3) {
                    throw null;
                }
                try {
                    th.addSuppressed(th3);
                } catch (IOException unused) {
                }
            }
        }

        private String getProcDesc() {
            return Long.toString(getPID()) + TokenParser.SP + getHostName();
        }

        private long getPID() {
            return ProcessHandle.current().pid();
        }

        private String getHostName() {
            try {
                return InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException unused) {
                return "";
            }
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            boolean z;
            try {
                ShutdownHook.INSTANCE.unregister(this.shutdownListener);
                FileLock fileLock = this.lock;
                if (fileLock == null || !fileLock.isValid()) {
                    z = false;
                } else {
                    this.lock.release();
                    z = true;
                }
                FileChannel fileChannel = this.channel;
                if (fileChannel != null) {
                    fileChannel.close();
                }
                RandomAccessFile randomAccessFile = this.f;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                FS.LockToken lockToken = this.token;
                if (lockToken != null) {
                    lockToken.close();
                }
                if (z) {
                    FileUtils.delete(this.pidFile.toFile(), 6);
                }
            } catch (IOException e) {
                GC.LOG.error(MessageFormat.format(JGitText.get().closePidLockFailed, this.pidFile), (Throwable) e);
            }
        }
    }
}
