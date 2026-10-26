package org.eclipse.jgit.merge;

import com.google.api.client.googleapis.media.MediaHttpUploader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.attributes.Attribute;
import org.eclipse.jgit.attributes.Attributes;
import org.eclipse.jgit.attributes.AttributesNodeProvider;
import org.eclipse.jgit.diff.DiffAlgorithm;
import org.eclipse.jgit.diff.RawText;
import org.eclipse.jgit.diff.RawTextComparator;
import org.eclipse.jgit.diff.Sequence;
import org.eclipse.jgit.dircache.Checkout;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.dircache.DirCacheBuildIterator;
import org.eclipse.jgit.dircache.DirCacheBuilder;
import org.eclipse.jgit.dircache.DirCacheCheckout;
import org.eclipse.jgit.dircache.DirCacheEntry;
import org.eclipse.jgit.errors.BinaryBlobException;
import org.eclipse.jgit.errors.IndexWriteException;
import org.eclipse.jgit.errors.NoWorkTreeException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.CoreConfig;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.storage.pack.PackConfig;
import org.eclipse.jgit.submodule.SubmoduleConflict;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.treewalk.NameConflictTreeWalk;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.WorkingTreeIterator;
import org.eclipse.jgit.treewalk.WorkingTreeOptions;
import org.eclipse.jgit.treewalk.filter.TreeFilter;
import org.eclipse.jgit.util.LfsFactory;
import org.eclipse.jgit.util.TemporaryBuffer;
import org.eclipse.jgit.util.io.EolStreamTypeUtil;

/* INFO: loaded from: classes5.dex */
public class ResolveMerger extends ThreeWayMerger {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$merge$ContentMergeStrategy = null;
    private static final Attributes NO_ATTRIBUTES = new Attributes(new Attribute[0]);
    protected static final int T_BASE = 0;
    protected static final int T_FILE = 4;
    protected static final int T_INDEX = 3;
    protected static final int T_OURS = 1;
    protected static final int T_THEIRS = 2;
    protected AttributesNodeProvider attributesNodeProvider;
    protected String[] commitNames;
    private ContentMergeStrategy contentStrategy;
    protected DirCache dircache;
    protected boolean enterSubtree;
    protected Map<String, MergeFailureReason> failingPaths;
    protected boolean inCore;
    protected MergeAlgorithm mergeAlgorithm;
    protected Map<String, MergeResult<? extends Sequence>> mergeResults;
    protected List<String> modifiedFiles;
    protected ObjectId resultTree;
    protected NameConflictTreeWalk tw;
    protected List<String> unmergedPaths;
    protected WorkTreeUpdater workTreeUpdater;
    protected WorkingTreeIterator workingTreeIterator;

    public enum MergeFailureReason {
        DIRTY_INDEX,
        DIRTY_WORKTREE,
        COULD_NOT_DELETE;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static MergeFailureReason[] valuesCustom() {
            MergeFailureReason[] mergeFailureReasonArrValuesCustom = values();
            int length = mergeFailureReasonArrValuesCustom.length;
            MergeFailureReason[] mergeFailureReasonArr = new MergeFailureReason[length];
            System.arraycopy(mergeFailureReasonArrValuesCustom, 0, mergeFailureReasonArr, 0, length);
            return mergeFailureReasonArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$merge$ContentMergeStrategy() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$merge$ContentMergeStrategy;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[ContentMergeStrategy.valuesCustom().length];
        try {
            iArr2[ContentMergeStrategy.CONFLICT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[ContentMergeStrategy.OURS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[ContentMergeStrategy.THEIRS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[ContentMergeStrategy.UNION.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$merge$ContentMergeStrategy = iArr2;
        return iArr2;
    }

    protected static class WorkTreeUpdater implements Closeable {
        private DirCacheBuilder builder;
        private Checkout checkout;
        private Map<String, DirCacheCheckout.CheckoutMetadata> checkoutMetadataByPath;
        private Map<String, DirCacheCheckout.CheckoutMetadata> cleanupMetadataByPath;
        private DirCache dirCache;
        private int inCoreFileSizeLimit;
        private boolean indexChangesWritten;
        private final ObjectInserter inserter;
        private final ObjectReader reader;

        @Nullable
        private final Repository repo;
        private WorkingTreeOptions workingTreeOptions;
        Result result = new Result();
        private boolean implicitDirCache = false;
        private final Map<String, DirCacheEntry> toBeCheckedOut = new HashMap();
        private final TreeMap<String, File> toBeDeleted = new TreeMap<>();
        private final boolean inCore = false;

        public static class Result {
            private final List<String> modifiedFiles = new ArrayList();
            private final List<String> failedToDelete = new ArrayList();
            private ObjectId treeId = null;

            public ObjectId getTreeId() {
                return this.treeId;
            }

            public List<String> getFailedToDelete() {
                return this.failedToDelete;
            }

            public List<String> getModifiedFiles() {
                return this.modifiedFiles;
            }
        }

        private WorkTreeUpdater(Repository repository, DirCache dirCache) {
            this.repo = repository;
            this.dirCache = dirCache;
            ObjectInserter objectInserterNewObjectInserter = repository.newObjectInserter();
            this.inserter = objectInserterNewObjectInserter;
            this.reader = objectInserterNewObjectInserter.newReader();
            StoredConfig config = repository.getConfig();
            this.workingTreeOptions = (WorkingTreeOptions) config.get(WorkingTreeOptions.KEY);
            this.inCoreFileSizeLimit = getInCoreFileSizeLimit(config);
            this.checkoutMetadataByPath = new HashMap();
            this.cleanupMetadataByPath = new HashMap();
            this.checkout = new Checkout(nonNullRepo(), this.workingTreeOptions);
        }

        public static WorkTreeUpdater createWorkTreeUpdater(Repository repository, DirCache dirCache) {
            return new WorkTreeUpdater(repository, dirCache);
        }

        private WorkTreeUpdater(Repository repository, DirCache dirCache, ObjectInserter objectInserter) {
            this.repo = repository;
            this.dirCache = dirCache;
            this.inserter = objectInserter;
            this.reader = objectInserter.newReader();
            if (repository != null) {
                this.inCoreFileSizeLimit = getInCoreFileSizeLimit(repository.getConfig());
            }
        }

        public static WorkTreeUpdater createInCoreWorkTreeUpdater(Repository repository, DirCache dirCache, ObjectInserter objectInserter) {
            return new WorkTreeUpdater(repository, dirCache, objectInserter);
        }

        private static int getInCoreFileSizeLimit(Config config) {
            return config.getInt("merge", ConfigConstants.CONFIG_KEY_IN_CORE_LIMIT, MediaHttpUploader.DEFAULT_CHUNK_SIZE);
        }

        public int getInCoreFileSizeLimit() {
            return this.inCoreFileSizeLimit;
        }

        public DirCache getLockedDirCache() throws IOException {
            if (this.dirCache == null) {
                this.implicitDirCache = true;
                if (this.inCore) {
                    this.dirCache = DirCache.newInCore();
                } else {
                    this.dirCache = nonNullRepo().lockDirCache();
                }
            }
            if (this.builder == null) {
                this.builder = this.dirCache.builder();
            }
            return this.dirCache;
        }

        public DirCacheBuildIterator createDirCacheBuildIterator() {
            return new DirCacheBuildIterator(this.builder);
        }

        public void writeWorkTreeChanges(boolean z) throws IOException {
            handleDeletedFiles();
            if (this.inCore) {
                this.builder.finish();
                return;
            }
            if (z) {
                checkout();
            }
            if (this.builder.commit()) {
                return;
            }
            revertModifiedFiles();
            throw new IndexWriteException();
        }

        public Result writeIndexChanges() throws IOException {
            this.result.treeId = getLockedDirCache().writeTree(this.inserter);
            this.indexChangesWritten = true;
            return this.result;
        }

        public void addToCheckout(String str, DirCacheEntry dirCacheEntry, CoreConfig.EolStreamType eolStreamType, String str2, CoreConfig.EolStreamType eolStreamType2, String str3) {
            if (dirCacheEntry != null) {
                this.toBeCheckedOut.put(str, dirCacheEntry);
            }
            addCheckoutMetadata(this.cleanupMetadataByPath, str, eolStreamType, str2);
            addCheckoutMetadata(this.checkoutMetadataByPath, str, eolStreamType2, str3);
        }

        public Map<String, DirCacheEntry> getToBeCheckedOut() {
            return this.toBeCheckedOut;
        }

        public void deleteFile(String str, File file, CoreConfig.EolStreamType eolStreamType, String str2) {
            this.toBeDeleted.put(str, file);
            if (file == null || !file.isFile()) {
                return;
            }
            addCheckoutMetadata(this.cleanupMetadataByPath, str, eolStreamType, str2);
        }

        private void addCheckoutMetadata(Map<String, DirCacheCheckout.CheckoutMetadata> map, String str, CoreConfig.EolStreamType eolStreamType, String str2) {
            if (this.inCore || map == null) {
                return;
            }
            map.put(str, new DirCacheCheckout.CheckoutMetadata(eolStreamType, str2));
        }

        public CoreConfig.EolStreamType detectCheckoutStreamType(Attributes attributes) {
            if (this.inCore) {
                return null;
            }
            return EolStreamTypeUtil.detectStreamType(TreeWalk.OperationType.CHECKOUT_OP, this.workingTreeOptions, attributes);
        }

        private void handleDeletedFiles() {
            for (String str : this.toBeDeleted.descendingKeySet()) {
                File file = this.inCore ? null : this.toBeDeleted.get(str);
                if (file != null && !file.delete() && !file.isDirectory()) {
                    this.result.failedToDelete.add(str);
                }
            }
        }

        public void markAsModified(String str) {
            this.result.modifiedFiles.add(str);
        }

        public List<String> getModifiedFiles() {
            return this.result.modifiedFiles;
        }

        private void checkout() throws NoWorkTreeException, IOException {
            for (Map.Entry<String, DirCacheEntry> entry : this.toBeCheckedOut.entrySet()) {
                DirCacheEntry value = entry.getValue();
                String key = entry.getKey();
                if (value.getFileMode() == FileMode.GITLINK) {
                    this.checkout.checkoutGitlink(value, key);
                } else {
                    this.checkout.checkout(value, this.checkoutMetadataByPath.get(key), this.reader, key);
                    this.result.modifiedFiles.add(key);
                }
            }
        }

        public void revertModifiedFiles() throws IOException {
            if (this.inCore) {
                this.result.modifiedFiles.clear();
                return;
            }
            if (this.indexChangesWritten) {
                return;
            }
            for (String str : this.result.modifiedFiles) {
                DirCacheEntry entry = this.dirCache.getEntry(str);
                if (entry != null) {
                    this.checkout.checkout(entry, this.cleanupMetadataByPath.get(str), this.reader, str);
                }
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.implicitDirCache) {
                this.dirCache.unlock();
            }
        }

        public void updateFileWithContent(DirCacheCheckout.StreamSupplier streamSupplier, CoreConfig.EolStreamType eolStreamType, String str, String str2, File file) throws IOException {
            if (this.inCore) {
                return;
            }
            this.checkout.safeCreateParentDirectory(str2, file.getParentFile(), false);
            DirCacheCheckout.CheckoutMetadata checkoutMetadata = new DirCacheCheckout.CheckoutMetadata(eolStreamType, str);
            Throwable th = null;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    DirCacheCheckout.getContent(this.repo, str2, checkoutMetadata, streamSupplier, this.workingTreeOptions, fileOutputStream);
                } finally {
                    fileOutputStream.close();
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

        public DirCacheEntry insertToIndex(InputStream inputStream, byte[] bArr, FileMode fileMode, int i, Instant instant, int i2, Attribute attribute) throws IOException {
            return addExistingToIndex(insertResult(inputStream, attribute, i2), bArr, fileMode, i, instant, i2);
        }

        public DirCacheEntry addExistingToIndex(ObjectId objectId, byte[] bArr, FileMode fileMode, int i, Instant instant, int i2) {
            DirCacheEntry dirCacheEntry = new DirCacheEntry(bArr, i);
            dirCacheEntry.setFileMode(fileMode);
            if (instant != null) {
                dirCacheEntry.setLastModified(instant);
            }
            if (this.inCore) {
                i2 = 0;
            }
            dirCacheEntry.setLength(i2);
            dirCacheEntry.setObjectId(objectId);
            this.builder.add(dirCacheEntry);
            return dirCacheEntry;
        }

        private ObjectId insertResult(InputStream inputStream, Attribute attribute, long j) throws IOException {
            Throwable th = null;
            try {
                LfsFactory.LfsInputStream lfsInputStreamApplyCleanFilter = LfsFactory.getInstance().applyCleanFilter(this.repo, inputStream, j, attribute);
                try {
                    return this.inserter.insert(3, lfsInputStreamApplyCleanFilter.getLength(), lfsInputStreamApplyCleanFilter);
                } finally {
                    if (lfsInputStreamApplyCleanFilter != null) {
                        lfsInputStreamApplyCleanFilter.close();
                    }
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

        private Repository nonNullRepo() throws NullPointerException {
            return (Repository) Objects.requireNonNull(this.repo, new ResolveMerger$WorkTreeUpdater$$ExternalSyntheticLambda0());
        }
    }

    private static MergeAlgorithm getMergeAlgorithm(Config config) {
        return new MergeAlgorithm(DiffAlgorithm.getAlgorithm((DiffAlgorithm.SupportedAlgorithm) config.getEnum("diff", null, ConfigConstants.CONFIG_KEY_ALGORITHM, DiffAlgorithm.SupportedAlgorithm.HISTOGRAM)));
    }

    private static String[] defaultCommitNames() {
        return new String[]{"BASE", "OURS", "THEIRS"};
    }

    protected ResolveMerger(Repository repository, boolean z) {
        super(repository);
        this.modifiedFiles = new ArrayList();
        this.unmergedPaths = new ArrayList();
        this.mergeResults = new HashMap();
        this.failingPaths = new HashMap();
        this.contentStrategy = ContentMergeStrategy.CONFLICT;
        this.mergeAlgorithm = getMergeAlgorithm(repository.getConfig());
        this.commitNames = defaultCommitNames();
        this.inCore = z;
    }

    protected ResolveMerger(Repository repository) {
        this(repository, false);
    }

    protected ResolveMerger(ObjectInserter objectInserter, Config config) {
        super(objectInserter);
        this.modifiedFiles = new ArrayList();
        this.unmergedPaths = new ArrayList();
        this.mergeResults = new HashMap();
        this.failingPaths = new HashMap();
        this.contentStrategy = ContentMergeStrategy.CONFLICT;
        this.mergeAlgorithm = getMergeAlgorithm(config);
        this.commitNames = defaultCommitNames();
        this.inCore = true;
    }

    public ContentMergeStrategy getContentMergeStrategy() {
        return this.contentStrategy;
    }

    public void setContentMergeStrategy(ContentMergeStrategy contentMergeStrategy) {
        if (contentMergeStrategy == null) {
            contentMergeStrategy = ContentMergeStrategy.CONFLICT;
        }
        this.contentStrategy = contentMergeStrategy;
    }

    @Override // org.eclipse.jgit.merge.Merger
    protected boolean mergeImpl() throws IOException {
        return mergeTrees(mergeBase(), this.sourceTrees[0], this.sourceTrees[1], false);
    }

    private DirCacheEntry add(byte[] bArr, CanonicalTreeParser canonicalTreeParser, int i, Instant instant, long j) {
        if (canonicalTreeParser == null || canonicalTreeParser.getEntryFileMode().equals(FileMode.TREE)) {
            return null;
        }
        return this.workTreeUpdater.addExistingToIndex(canonicalTreeParser.getEntryObjectId(), bArr, canonicalTreeParser.getEntryFileMode(), i, instant, (int) j);
    }

    private DirCacheEntry addConflict(CanonicalTreeParser canonicalTreeParser, CanonicalTreeParser canonicalTreeParser2, CanonicalTreeParser canonicalTreeParser3) {
        add(this.tw.getRawPath(), canonicalTreeParser, 1, Instant.EPOCH, 0L);
        add(this.tw.getRawPath(), canonicalTreeParser2, 2, Instant.EPOCH, 0L);
        return add(this.tw.getRawPath(), canonicalTreeParser3, 3, Instant.EPOCH, 0L);
    }

    private DirCacheEntry keep(DirCacheEntry dirCacheEntry) {
        return this.workTreeUpdater.addExistingToIndex(dirCacheEntry.getObjectId(), dirCacheEntry.getRawPath(), dirCacheEntry.getFileMode(), dirCacheEntry.getStage(), dirCacheEntry.getLastModifiedInstant(), dirCacheEntry.getLength());
    }

    protected void addToCheckout(String str, DirCacheEntry dirCacheEntry, Attributes[] attributesArr) throws IOException {
        this.workTreeUpdater.addToCheckout(str, dirCacheEntry, this.workTreeUpdater.detectCheckoutStreamType(attributesArr[1]), this.tw.getSmudgeCommand(attributesArr[1]), this.workTreeUpdater.detectCheckoutStreamType(attributesArr[2]), this.tw.getSmudgeCommand(attributesArr[2]));
    }

    protected void addDeletion(String str, boolean z, Attributes attributes) throws IOException {
        if (this.db == null || nonNullRepo().isBare() || !z) {
            return;
        }
        this.workTreeUpdater.deleteFile(str, new File(nonNullRepo().getWorkTree(), str), this.workTreeUpdater.detectCheckoutStreamType(attributes), this.tw.getSmudgeCommand(attributes));
    }

    /* WARN: Code duplicated, block: B:155:0x02e1  */
    /* WARN: Code duplicated, block: B:160:0x02fa A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:161:0x02fc  */
    /* WARN: Code duplicated, block: B:163:0x030a  */
    /* WARN: Code duplicated, block: B:165:0x030f  */
    /* WARN: Code duplicated, block: B:167:0x0316  */
    /* WARN: Code duplicated, block: B:168:0x032b  */
    /* WARN: Code duplicated, block: B:169:0x032f  */
    /* WARN: Code duplicated, block: B:171:0x0341 A[ADDED_TO_REGION] */
    /* WARN: Code duplicated, block: B:173:0x0347  */
    /* WARN: Code duplicated, block: B:175:0x0358  */
    /* WARN: Code duplicated, block: B:177:0x036b  */
    /* WARN: Code duplicated, block: B:179:0x036f  */
    /* WARN: Code duplicated, block: B:192:0x03a3 A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:193:0x03a5  */
    /* WARN: Code duplicated, block: B:194:0x03c7  */
    /* WARN: Code duplicated, block: B:196:0x03d0  */
    /* WARN: Code duplicated, block: B:197:0x03d2  */
    /* WARN: Code duplicated, block: B:199:0x03d5  */
    /* WARN: Code duplicated, block: B:208:0x0403  */
    /* WARN: Code duplicated, block: B:210:0x0408 A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:211:0x040a  */
    /* WARN: Code duplicated, block: B:212:0x040e  */
    /* WARN: Code duplicated, block: B:214:0x0414 A[RETURN] */
    /* WARN: Code duplicated, block: B:215:0x0415  */
    /* WARN: Code duplicated, block: B:217:0x0428  */
    /* WARN: Code duplicated, block: B:218:0x0432  */
    /* WARN: Code duplicated, block: B:219:0x043e  */
    /* WARN: Code duplicated, block: B:221:0x0444  */
    /* WARN: Code duplicated, block: B:223:0x044a A[RETURN] */
    /* WARN: Code duplicated, block: B:224:0x044b  */
    /* WARN: Code duplicated, block: B:226:0x0451 A[ADDED_TO_REGION] */
    /* WARN: Code duplicated, block: B:242:0x03e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* WARN: Code duplicated, block: B:79:0x015b  */
    /* WARN: Code duplicated, block: B:81:0x0165 A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:82:0x0167  */
    /* WARN: Code duplicated, block: B:84:0x016a  */
    /* WARN: Code duplicated, block: B:86:0x0170  */
    /* WARN: Code duplicated, block: B:89:0x0186  */
    /* WARN: Code duplicated, block: B:92:0x019c  */
    /* WARN: Code duplicated, block: B:95:0x01ba  */
    /* WARN: Code duplicated, block: B:97:0x01c0 A[RETURN] */
    protected boolean processEntry(CanonicalTreeParser canonicalTreeParser, CanonicalTreeParser canonicalTreeParser2, CanonicalTreeParser canonicalTreeParser3, DirCacheBuildIterator dirCacheBuildIterator, WorkingTreeIterator workingTreeIterator, boolean z, Attributes[] attributesArr) throws Throwable {
        DirCacheEntry dirCacheEntry;
        DirCacheEntry dirCacheEntry2;
        Attributes[] attributesArr2;
        boolean z2;
        MergeResult<RawText> mergeResult;
        MergeResult<RawText> mergeResult2;
        DirCacheEntry dirCacheEntryAddConflict;
        DirCacheEntry dirCacheEntryAdd;
        Attributes[] attributesArr3;
        int i;
        String str;
        int i2;
        DirCacheEntry dirCacheEntryAdd2;
        MergeResult<? extends Sequence> mergeResult3;
        DirCacheEntry dirCacheEntryAddConflict2;
        this.enterSubtree = true;
        int rawMode = this.tw.getRawMode(1);
        int rawMode2 = this.tw.getRawMode(2);
        int rawMode3 = this.tw.getRawMode(0);
        boolean z3 = isGitLink(rawMode) || isGitLink(rawMode2) || isGitLink(rawMode3);
        if (rawMode == 0 && rawMode2 == 0 && rawMode3 == 0) {
            return true;
        }
        if (isIndexDirty()) {
            return false;
        }
        if (dirCacheBuildIterator == null || dirCacheBuildIterator.getDirCacheEntry() == null) {
            if (nonTree(rawMode)) {
                dirCacheEntry2 = new DirCacheEntry(this.tw.getRawPath());
                dirCacheEntry2.setObjectId(this.tw.getObjectId(1));
                dirCacheEntry2.setFileMode(this.tw.getFileMode(1));
            } else {
                dirCacheEntry = null;
            }
            if (!nonTree(rawMode) && nonTree(rawMode2) && this.tw.idEqual(1, 2)) {
                if (rawMode == rawMode2) {
                    keep(dirCacheEntry);
                    return true;
                }
                int iMergeFileModes = mergeFileModes(rawMode3, rawMode, rawMode2);
                if (iMergeFileModes == FileMode.MISSING.getBits()) {
                    if (!z) {
                        addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                        this.unmergedPaths.add(this.tw.getPathString());
                        this.mergeResults.put(this.tw.getPathString(), new MergeResult<>(Collections.emptyList()));
                    }
                    return true;
                }
                if (iMergeFileModes == rawMode) {
                    keep(dirCacheEntry);
                } else {
                    if (isWorktreeDirty(workingTreeIterator, dirCacheEntry)) {
                        return false;
                    }
                    addToCheckout(this.tw.getPathString(), add(this.tw.getRawPath(), canonicalTreeParser3, 0, Instant.EPOCH, 0L), attributesArr);
                }
                return true;
            }
            if (rawMode3 != rawMode2 && this.tw.idEqual(0, 2)) {
                if (dirCacheEntry != null) {
                    keep(dirCacheEntry);
                }
                return true;
            }
            if (rawMode3 != rawMode && this.tw.idEqual(0, 1)) {
                if (isWorktreeDirty(workingTreeIterator, dirCacheEntry)) {
                    return false;
                }
                if (nonTree(rawMode2)) {
                    DirCacheEntry dirCacheEntryAdd3 = add(this.tw.getRawPath(), canonicalTreeParser3, 0, Instant.EPOCH, 0L);
                    if (dirCacheEntryAdd3 != null) {
                        addToCheckout(this.tw.getPathString(), dirCacheEntryAdd3, attributesArr);
                    }
                    return true;
                }
                if (this.tw.getTreeCount() > 4 && this.tw.getRawMode(4) == 0) {
                    return true;
                }
                if (rawMode2 != 0 && rawMode2 == rawMode3) {
                    return true;
                }
                addDeletion(this.tw.getPathString(), nonTree(rawMode), attributesArr[1]);
                return true;
            }
            if (this.tw.isSubtree()) {
                if (nonTree(rawMode) != nonTree(rawMode2)) {
                    if (z) {
                        this.enterSubtree = false;
                        return true;
                    }
                    if (nonTree(rawMode3)) {
                        add(this.tw.getRawPath(), canonicalTreeParser, 1, Instant.EPOCH, 0L);
                    }
                    if (nonTree(rawMode)) {
                        add(this.tw.getRawPath(), canonicalTreeParser2, 2, Instant.EPOCH, 0L);
                    }
                    if (nonTree(rawMode2)) {
                        add(this.tw.getRawPath(), canonicalTreeParser3, 3, Instant.EPOCH, 0L);
                    }
                    this.unmergedPaths.add(this.tw.getPathString());
                    this.enterSubtree = false;
                    return true;
                }
                if (!nonTree(rawMode)) {
                    return true;
                }
            }
            if (!nonTree(rawMode) && nonTree(rawMode2)) {
                boolean zIsWorktreeDirty = isWorktreeDirty(workingTreeIterator, dirCacheEntry);
                if (!attributesArr[1].canBeContentMerged() && zIsWorktreeDirty) {
                    return false;
                }
                if (z3 && z) {
                    add(this.tw.getRawPath(), canonicalTreeParser2, 0, Instant.EPOCH, 0L);
                    return true;
                }
                if (z3) {
                    addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                    MergeResult<SubmoduleConflict> mergeResultCreateGitLinksMergeResult = createGitLinksMergeResult(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                    mergeResultCreateGitLinksMergeResult.setContainsConflicts(true);
                    this.mergeResults.put(this.tw.getPathString(), mergeResultCreateGitLinksMergeResult);
                    this.unmergedPaths.add(this.tw.getPathString());
                    return true;
                }
                if (!attributesArr[1].canBeContentMerged()) {
                    int i3 = $SWITCH_TABLE$org$eclipse$jgit$merge$ContentMergeStrategy()[getContentMergeStrategy().ordinal()];
                    if (i3 == 2) {
                        keep(dirCacheEntry);
                        return true;
                    }
                    if (i3 == 3) {
                        addToCheckout(this.tw.getPathString(), add(this.tw.getRawPath(), canonicalTreeParser3, 0, Instant.EPOCH, 0L), attributesArr);
                        return true;
                    }
                    if (z) {
                        keep(dirCacheEntry);
                        return true;
                    }
                    String pathString = this.tw.getPathString();
                    MergeResult<? extends Sequence> mergeResult4 = new MergeResult<>(Collections.emptyList());
                    mergeResult4.setContainsConflicts(true);
                    this.mergeResults.put(pathString, mergeResult4);
                    addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                    this.unmergedPaths.add(pathString);
                    return true;
                }
                if (zIsWorktreeDirty) {
                    return false;
                }
                boolean z4 = FileMode.SYMLINK.equals(rawMode) || FileMode.SYMLINK.equals(rawMode2);
                String pathString2 = this.tw.getPathString();
                if (z4) {
                    attributesArr3 = attributesArr;
                    i = FileMode.TYPE_MASK;
                    str = pathString2;
                } else {
                    try {
                        str = pathString2;
                        try {
                            MergeResult<RawText> mergeResultContentMerge = contentMerge(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3, attributesArr, getContentMergeStrategy());
                            try {
                                if (mergeResultContentMerge.containsConflicts() && !z) {
                                    mergeResultContentMerge.setContainsConflicts(true);
                                    this.unmergedPaths.add(str);
                                } else if (z) {
                                    mergeResultContentMerge.setContainsConflicts(false);
                                }
                                Attributes attributes = attributesArr[1];
                                attributesArr3 = attributesArr;
                                i = FileMode.TYPE_MASK;
                                try {
                                    updateIndex(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3, mergeResultContentMerge, attributes);
                                    this.workTreeUpdater.markAsModified(str);
                                    addToCheckout(str, null, attributesArr3);
                                    return true;
                                } catch (BinaryBlobException unused) {
                                    if (z) {
                                        keep(dirCacheEntry);
                                        return true;
                                    }
                                    i2 = $SWITCH_TABLE$org$eclipse$jgit$merge$ContentMergeStrategy()[getContentMergeStrategy().ordinal()];
                                    if (i2 == 2) {
                                        keep(dirCacheEntry);
                                        return true;
                                    }
                                    if (i2 == 3) {
                                        dirCacheEntryAdd2 = add(this.tw.getRawPath(), canonicalTreeParser3, 0, Instant.EPOCH, 0L);
                                        if (dirCacheEntryAdd2 != null) {
                                            addToCheckout(str, dirCacheEntryAdd2, attributesArr3);
                                        }
                                        return true;
                                    }
                                    mergeResult3 = new MergeResult<>(Collections.emptyList());
                                    mergeResult3.setContainsConflicts(true);
                                    if (!z4) {
                                        mergeResult3.setContainsConflicts(true);
                                        addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                                        this.unmergedPaths.add(str);
                                        this.mergeResults.put(str, mergeResult3);
                                    } else if (z) {
                                        mergeResult3.setContainsConflicts(false);
                                        if ((rawMode2 & i) == 32768) {
                                            addToCheckout(str, add(this.tw.getRawPath(), canonicalTreeParser3, 0, Instant.EPOCH, 0L), attributesArr3);
                                        } else {
                                            keep(dirCacheEntry);
                                        }
                                    } else {
                                        dirCacheEntryAddConflict2 = addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                                        this.mergeResults.put(str, mergeResult3);
                                        this.unmergedPaths.add(str);
                                        if ((rawMode2 & i) == 32768) {
                                            addToCheckout(str, dirCacheEntryAddConflict2, attributesArr3);
                                        }
                                    }
                                    return true;
                                }
                            } catch (BinaryBlobException unused2) {
                                attributesArr3 = attributesArr;
                                i = FileMode.TYPE_MASK;
                                if (z) {
                                    keep(dirCacheEntry);
                                    return true;
                                }
                                i2 = $SWITCH_TABLE$org$eclipse$jgit$merge$ContentMergeStrategy()[getContentMergeStrategy().ordinal()];
                                if (i2 == 2) {
                                    keep(dirCacheEntry);
                                    return true;
                                }
                                if (i2 == 3) {
                                    dirCacheEntryAdd2 = add(this.tw.getRawPath(), canonicalTreeParser3, 0, Instant.EPOCH, 0L);
                                    if (dirCacheEntryAdd2 != null) {
                                        addToCheckout(str, dirCacheEntryAdd2, attributesArr3);
                                    }
                                    return true;
                                }
                                mergeResult3 = new MergeResult<>(Collections.emptyList());
                                mergeResult3.setContainsConflicts(true);
                                if (!z4) {
                                    mergeResult3.setContainsConflicts(true);
                                    addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                                    this.unmergedPaths.add(str);
                                    this.mergeResults.put(str, mergeResult3);
                                } else if (z) {
                                    mergeResult3.setContainsConflicts(false);
                                    if ((rawMode2 & i) == 32768) {
                                        addToCheckout(str, add(this.tw.getRawPath(), canonicalTreeParser3, 0, Instant.EPOCH, 0L), attributesArr3);
                                    } else {
                                        keep(dirCacheEntry);
                                    }
                                } else {
                                    dirCacheEntryAddConflict2 = addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                                    this.mergeResults.put(str, mergeResult3);
                                    this.unmergedPaths.add(str);
                                    if ((rawMode2 & i) == 32768) {
                                        addToCheckout(str, dirCacheEntryAddConflict2, attributesArr3);
                                    }
                                }
                                return true;
                            }
                        } catch (BinaryBlobException unused3) {
                            attributesArr3 = attributesArr;
                        }
                    } catch (BinaryBlobException unused4) {
                        attributesArr3 = attributesArr;
                        i = FileMode.TYPE_MASK;
                        str = pathString2;
                    }
                }
                i2 = $SWITCH_TABLE$org$eclipse$jgit$merge$ContentMergeStrategy()[getContentMergeStrategy().ordinal()];
                if (i2 == 2) {
                    keep(dirCacheEntry);
                    return true;
                }
                if (i2 == 3) {
                    dirCacheEntryAdd2 = add(this.tw.getRawPath(), canonicalTreeParser3, 0, Instant.EPOCH, 0L);
                    if (dirCacheEntryAdd2 != null) {
                        addToCheckout(str, dirCacheEntryAdd2, attributesArr3);
                    }
                    return true;
                }
                mergeResult3 = new MergeResult<>(Collections.emptyList());
                mergeResult3.setContainsConflicts(true);
                if (!z4) {
                    mergeResult3.setContainsConflicts(true);
                    addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                    this.unmergedPaths.add(str);
                    this.mergeResults.put(str, mergeResult3);
                } else if (z) {
                    mergeResult3.setContainsConflicts(false);
                    if ((rawMode2 & i) == 32768) {
                        addToCheckout(str, add(this.tw.getRawPath(), canonicalTreeParser3, 0, Instant.EPOCH, 0L), attributesArr3);
                    } else {
                        keep(dirCacheEntry);
                    }
                } else {
                    dirCacheEntryAddConflict2 = addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                    this.mergeResults.put(str, mergeResult3);
                    this.unmergedPaths.add(str);
                    if ((rawMode2 & i) == 32768 && dirCacheEntryAddConflict2 != null) {
                        addToCheckout(str, dirCacheEntryAddConflict2, attributesArr3);
                    }
                }
                return true;
            }
            attributesArr2 = attributesArr;
            if (rawMode != rawMode2 && ((rawMode != 0 && !this.tw.idEqual(0, 1)) || (rawMode2 != 0 && !this.tw.idEqual(0, 2)))) {
                if (!z3 && z) {
                    add(this.tw.getRawPath(), canonicalTreeParser2, 0, Instant.EPOCH, 0L);
                } else if (z3) {
                    addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                    MergeResult<SubmoduleConflict> mergeResultCreateGitLinksMergeResult2 = createGitLinksMergeResult(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                    mergeResultCreateGitLinksMergeResult2.setContainsConflicts(true);
                    this.mergeResults.put(this.tw.getPathString(), mergeResultCreateGitLinksMergeResult2);
                    this.unmergedPaths.add(this.tw.getPathString());
                } else {
                    if (((rawMode | rawMode2) & FileMode.TYPE_MASK) == 40960) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        mergeResult = new MergeResult<>(Collections.emptyList());
                        mergeResult.setContainsConflicts(true);
                    } else {
                        try {
                            try {
                                MergeResult<RawText> mergeResultContentMerge2 = contentMerge(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3, attributesArr2, ContentMergeStrategy.CONFLICT);
                                attributesArr2 = attributesArr2;
                                mergeResult2 = mergeResultContentMerge2;
                            } catch (BinaryBlobException unused5) {
                                attributesArr2 = attributesArr2;
                                mergeResult = new MergeResult<>(Collections.emptyList());
                                mergeResult.setContainsConflicts(true);
                                mergeResult2 = mergeResult;
                            }
                        } catch (BinaryBlobException unused6) {
                        }
                        if (z) {
                            mergeResult2.setContainsConflicts(false);
                            if (z2) {
                                updateIndex(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3, mergeResult2, attributesArr2[1]);
                            } else if (rawMode != 0) {
                                keep(dirCacheEntry);
                            } else {
                                if (isWorktreeDirty(workingTreeIterator, dirCacheEntry)) {
                                    return false;
                                }
                                dirCacheEntryAdd = add(this.tw.getRawPath(), canonicalTreeParser3, 0, Instant.EPOCH, 0L);
                                if (dirCacheEntryAdd != null) {
                                    addToCheckout(this.tw.getPathString(), dirCacheEntryAdd, attributesArr2);
                                }
                            }
                        } else {
                            dirCacheEntryAddConflict = addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                            if (rawMode == 0) {
                                if (isWorktreeDirty(workingTreeIterator, dirCacheEntry)) {
                                    return false;
                                }
                                if (nonTree(rawMode2) && dirCacheEntryAddConflict != null) {
                                    addToCheckout(this.tw.getPathString(), dirCacheEntryAddConflict, attributesArr2);
                                }
                            }
                            this.unmergedPaths.add(this.tw.getPathString());
                            this.mergeResults.put(this.tw.getPathString(), mergeResult2);
                        }
                    }
                    mergeResult2 = mergeResult;
                    if (z) {
                        mergeResult2.setContainsConflicts(false);
                        if (z2) {
                            updateIndex(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3, mergeResult2, attributesArr2[1]);
                        } else if (rawMode != 0) {
                            keep(dirCacheEntry);
                        } else {
                            if (isWorktreeDirty(workingTreeIterator, dirCacheEntry)) {
                                return false;
                            }
                            dirCacheEntryAdd = add(this.tw.getRawPath(), canonicalTreeParser3, 0, Instant.EPOCH, 0L);
                            if (dirCacheEntryAdd != null) {
                                addToCheckout(this.tw.getPathString(), dirCacheEntryAdd, attributesArr2);
                            }
                        }
                    } else {
                        dirCacheEntryAddConflict = addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                        if (rawMode == 0) {
                            if (isWorktreeDirty(workingTreeIterator, dirCacheEntry)) {
                                return false;
                            }
                            if (nonTree(rawMode2)) {
                                addToCheckout(this.tw.getPathString(), dirCacheEntryAddConflict, attributesArr2);
                            }
                        }
                        this.unmergedPaths.add(this.tw.getPathString());
                        this.mergeResults.put(this.tw.getPathString(), mergeResult2);
                    }
                }
            }
            return true;
        }
        dirCacheEntry2 = dirCacheBuildIterator.getDirCacheEntry();
        dirCacheEntry = dirCacheEntry2;
        if (!nonTree(rawMode)) {
        }
        if (rawMode3 != rawMode2) {
        }
        if (rawMode3 != rawMode) {
        }
        if (this.tw.isSubtree()) {
            if (nonTree(rawMode) != nonTree(rawMode2)) {
                if (z) {
                    this.enterSubtree = false;
                    return true;
                }
                if (nonTree(rawMode3)) {
                    add(this.tw.getRawPath(), canonicalTreeParser, 1, Instant.EPOCH, 0L);
                }
                if (nonTree(rawMode)) {
                    add(this.tw.getRawPath(), canonicalTreeParser2, 2, Instant.EPOCH, 0L);
                }
                if (nonTree(rawMode2)) {
                    add(this.tw.getRawPath(), canonicalTreeParser3, 3, Instant.EPOCH, 0L);
                }
                this.unmergedPaths.add(this.tw.getPathString());
                this.enterSubtree = false;
                return true;
            }
            if (!nonTree(rawMode)) {
                return true;
            }
        }
        if (!nonTree(rawMode)) {
        }
        attributesArr2 = attributesArr;
        if (rawMode != rawMode2) {
            if (!z3) {
                if (z3) {
                    addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                    MergeResult<SubmoduleConflict> mergeResultCreateGitLinksMergeResult3 = createGitLinksMergeResult(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                    mergeResultCreateGitLinksMergeResult3.setContainsConflicts(true);
                    this.mergeResults.put(this.tw.getPathString(), mergeResultCreateGitLinksMergeResult3);
                    this.unmergedPaths.add(this.tw.getPathString());
                } else {
                    if (((rawMode | rawMode2) & FileMode.TYPE_MASK) == 40960) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        mergeResult = new MergeResult<>(Collections.emptyList());
                        mergeResult.setContainsConflicts(true);
                    } else {
                        MergeResult<RawText> mergeResultContentMerge3 = contentMerge(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3, attributesArr2, ContentMergeStrategy.CONFLICT);
                        attributesArr2 = attributesArr2;
                        mergeResult2 = mergeResultContentMerge3;
                        if (z) {
                            mergeResult2.setContainsConflicts(false);
                            if (z2) {
                                updateIndex(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3, mergeResult2, attributesArr2[1]);
                            } else if (rawMode != 0) {
                                keep(dirCacheEntry);
                            } else {
                                if (isWorktreeDirty(workingTreeIterator, dirCacheEntry)) {
                                    return false;
                                }
                                dirCacheEntryAdd = add(this.tw.getRawPath(), canonicalTreeParser3, 0, Instant.EPOCH, 0L);
                                if (dirCacheEntryAdd != null) {
                                    addToCheckout(this.tw.getPathString(), dirCacheEntryAdd, attributesArr2);
                                }
                            }
                        } else {
                            dirCacheEntryAddConflict = addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                            if (rawMode == 0) {
                                if (isWorktreeDirty(workingTreeIterator, dirCacheEntry)) {
                                    return false;
                                }
                                if (nonTree(rawMode2)) {
                                    addToCheckout(this.tw.getPathString(), dirCacheEntryAddConflict, attributesArr2);
                                }
                            }
                            this.unmergedPaths.add(this.tw.getPathString());
                            this.mergeResults.put(this.tw.getPathString(), mergeResult2);
                        }
                    }
                    mergeResult2 = mergeResult;
                    if (z) {
                        mergeResult2.setContainsConflicts(false);
                        if (z2) {
                            updateIndex(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3, mergeResult2, attributesArr2[1]);
                        } else if (rawMode != 0) {
                            keep(dirCacheEntry);
                        } else {
                            if (isWorktreeDirty(workingTreeIterator, dirCacheEntry)) {
                                return false;
                            }
                            dirCacheEntryAdd = add(this.tw.getRawPath(), canonicalTreeParser3, 0, Instant.EPOCH, 0L);
                            if (dirCacheEntryAdd != null) {
                                addToCheckout(this.tw.getPathString(), dirCacheEntryAdd, attributesArr2);
                            }
                        }
                    } else {
                        dirCacheEntryAddConflict = addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                        if (rawMode == 0) {
                            if (isWorktreeDirty(workingTreeIterator, dirCacheEntry)) {
                                return false;
                            }
                            if (nonTree(rawMode2)) {
                                addToCheckout(this.tw.getPathString(), dirCacheEntryAddConflict, attributesArr2);
                            }
                        }
                        this.unmergedPaths.add(this.tw.getPathString());
                        this.mergeResults.put(this.tw.getPathString(), mergeResult2);
                    }
                }
            } else if (z3) {
                addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                MergeResult<SubmoduleConflict> mergeResultCreateGitLinksMergeResult4 = createGitLinksMergeResult(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                mergeResultCreateGitLinksMergeResult4.setContainsConflicts(true);
                this.mergeResults.put(this.tw.getPathString(), mergeResultCreateGitLinksMergeResult4);
                this.unmergedPaths.add(this.tw.getPathString());
            } else {
                if (((rawMode | rawMode2) & FileMode.TYPE_MASK) == 40960) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    mergeResult = new MergeResult<>(Collections.emptyList());
                    mergeResult.setContainsConflicts(true);
                } else {
                    MergeResult<RawText> mergeResultContentMerge4 = contentMerge(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3, attributesArr2, ContentMergeStrategy.CONFLICT);
                    attributesArr2 = attributesArr2;
                    mergeResult2 = mergeResultContentMerge4;
                    if (z) {
                        mergeResult2.setContainsConflicts(false);
                        if (z2) {
                            updateIndex(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3, mergeResult2, attributesArr2[1]);
                        } else if (rawMode != 0) {
                            keep(dirCacheEntry);
                        } else {
                            if (isWorktreeDirty(workingTreeIterator, dirCacheEntry)) {
                                return false;
                            }
                            dirCacheEntryAdd = add(this.tw.getRawPath(), canonicalTreeParser3, 0, Instant.EPOCH, 0L);
                            if (dirCacheEntryAdd != null) {
                                addToCheckout(this.tw.getPathString(), dirCacheEntryAdd, attributesArr2);
                            }
                        }
                    } else {
                        dirCacheEntryAddConflict = addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                        if (rawMode == 0) {
                            if (isWorktreeDirty(workingTreeIterator, dirCacheEntry)) {
                                return false;
                            }
                            if (nonTree(rawMode2)) {
                                addToCheckout(this.tw.getPathString(), dirCacheEntryAddConflict, attributesArr2);
                            }
                        }
                        this.unmergedPaths.add(this.tw.getPathString());
                        this.mergeResults.put(this.tw.getPathString(), mergeResult2);
                    }
                }
                mergeResult2 = mergeResult;
                if (z) {
                    mergeResult2.setContainsConflicts(false);
                    if (z2) {
                        updateIndex(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3, mergeResult2, attributesArr2[1]);
                    } else if (rawMode != 0) {
                        keep(dirCacheEntry);
                    } else {
                        if (isWorktreeDirty(workingTreeIterator, dirCacheEntry)) {
                            return false;
                        }
                        dirCacheEntryAdd = add(this.tw.getRawPath(), canonicalTreeParser3, 0, Instant.EPOCH, 0L);
                        if (dirCacheEntryAdd != null) {
                            addToCheckout(this.tw.getPathString(), dirCacheEntryAdd, attributesArr2);
                        }
                    }
                } else {
                    dirCacheEntryAddConflict = addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                    if (rawMode == 0) {
                        if (isWorktreeDirty(workingTreeIterator, dirCacheEntry)) {
                            return false;
                        }
                        if (nonTree(rawMode2)) {
                            addToCheckout(this.tw.getPathString(), dirCacheEntryAddConflict, attributesArr2);
                        }
                    }
                    this.unmergedPaths.add(this.tw.getPathString());
                    this.mergeResults.put(this.tw.getPathString(), mergeResult2);
                }
            }
        }
        return true;
    }

    private static MergeResult<SubmoduleConflict> createGitLinksMergeResult(CanonicalTreeParser canonicalTreeParser, CanonicalTreeParser canonicalTreeParser2, CanonicalTreeParser canonicalTreeParser3) {
        SubmoduleConflict[] submoduleConflictArr = new SubmoduleConflict[3];
        submoduleConflictArr[0] = new SubmoduleConflict(canonicalTreeParser == null ? null : canonicalTreeParser.getEntryObjectId());
        submoduleConflictArr[1] = new SubmoduleConflict(canonicalTreeParser2 == null ? null : canonicalTreeParser2.getEntryObjectId());
        submoduleConflictArr[2] = new SubmoduleConflict(canonicalTreeParser3 != null ? canonicalTreeParser3.getEntryObjectId() : null);
        return new MergeResult<>(Arrays.asList(submoduleConflictArr));
    }

    private MergeResult<RawText> contentMerge(CanonicalTreeParser canonicalTreeParser, CanonicalTreeParser canonicalTreeParser2, CanonicalTreeParser canonicalTreeParser3, Attributes[] attributesArr, ContentMergeStrategy contentMergeStrategy) throws IOException, BinaryBlobException {
        RawText rawText;
        RawText rawText2;
        RawText rawText3;
        if (canonicalTreeParser == null) {
            rawText = RawText.EMPTY_TEXT;
        } else {
            rawText = getRawText(canonicalTreeParser.getEntryObjectId(), attributesArr[0]);
        }
        if (canonicalTreeParser2 == null) {
            rawText2 = RawText.EMPTY_TEXT;
        } else {
            rawText2 = getRawText(canonicalTreeParser2.getEntryObjectId(), attributesArr[1]);
        }
        if (canonicalTreeParser3 == null) {
            rawText3 = RawText.EMPTY_TEXT;
        } else {
            rawText3 = getRawText(canonicalTreeParser3.getEntryObjectId(), attributesArr[2]);
        }
        this.mergeAlgorithm.setContentMergeStrategy(getAttributesContentMergeStrategy(attributesArr[1], contentMergeStrategy));
        return this.mergeAlgorithm.merge(RawTextComparator.DEFAULT, rawText, rawText2, rawText3);
    }

    private ContentMergeStrategy getAttributesContentMergeStrategy(Attributes attributes, ContentMergeStrategy contentMergeStrategy) {
        Attribute attribute = attributes.get("merge");
        return (attribute == null || !attribute.getValue().equals(Constants.ATTR_BUILTIN_UNION_MERGE_DRIVER)) ? contentMergeStrategy : ContentMergeStrategy.UNION;
    }

    private boolean isIndexDirty() {
        boolean z = false;
        if (this.inCore) {
            return false;
        }
        int rawMode = this.tw.getRawMode(3);
        int rawMode2 = this.tw.getRawMode(1);
        if (nonTree(rawMode) && (rawMode2 != rawMode || !this.tw.idEqual(3, 1))) {
            z = true;
        }
        if (z) {
            this.failingPaths.put(this.tw.getPathString(), MergeFailureReason.DIRTY_INDEX);
        }
        return z;
    }

    private boolean isWorktreeDirty(WorkingTreeIterator workingTreeIterator, DirCacheEntry dirCacheEntry) throws IOException {
        boolean zIsModeDifferent;
        if (workingTreeIterator == null) {
            return false;
        }
        int rawMode = this.tw.getRawMode(4);
        int rawMode2 = this.tw.getRawMode(1);
        if (dirCacheEntry != null) {
            zIsModeDifferent = workingTreeIterator.isModified(dirCacheEntry, true, this.reader);
        } else {
            zIsModeDifferent = workingTreeIterator.isModeDifferent(rawMode2);
            if (!zIsModeDifferent && nonTree(rawMode)) {
                zIsModeDifferent = !this.tw.idEqual(4, 1);
            }
        }
        boolean z = (zIsModeDifferent && rawMode == 16384 && rawMode2 == 0) ? false : zIsModeDifferent;
        if (z) {
            this.failingPaths.put(this.tw.getPathString(), MergeFailureReason.DIRTY_WORKTREE);
        }
        return z;
    }

    /* WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class decompiler.core.dex.instructions.args.ArgType$ArrayArg
    	at decompiler.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at decompiler.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at decompiler.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void updateIndex(CanonicalTreeParser canonicalTreeParser, CanonicalTreeParser canonicalTreeParser2, CanonicalTreeParser canonicalTreeParser3, MergeResult<RawText> mergeResult, Attributes attributes) throws Throwable {
        Throwable th;
        TemporaryBuffer temporaryBuffer = null;
        try {
            TemporaryBuffer temporaryBufferDoMerge = doMerge(mergeResult);
            try {
                File fileWriteMergedFile = this.inCore ? null : writeMergedFile(temporaryBufferDoMerge, attributes);
                if (mergeResult.containsConflicts()) {
                    addConflict(canonicalTreeParser, canonicalTreeParser2, canonicalTreeParser3);
                    this.mergeResults.put(this.tw.getPathString(), mergeResult);
                    if (temporaryBufferDoMerge != null) {
                        temporaryBufferDoMerge.destroy();
                        return;
                    }
                    return;
                }
                Instant instantLastModifiedInstant = fileWriteMergedFile != null ? nonNullRepo().getFS().lastModifiedInstant(fileWriteMergedFile) : null;
                int iMergeFileModes = mergeFileModes(this.tw.getRawMode(0), this.tw.getRawMode(1), this.tw.getRawMode(2));
                this.workTreeUpdater.insertToIndex(temporaryBufferDoMerge.openInputStream(), this.tw.getPathString().getBytes(StandardCharsets.UTF_8), iMergeFileModes == FileMode.MISSING.getBits() ? FileMode.REGULAR_FILE : FileMode.fromBits(iMergeFileModes), 0, instantLastModifiedInstant, (int) temporaryBufferDoMerge.length(), attributes.get("merge"));
                if (temporaryBufferDoMerge != null) {
                    temporaryBufferDoMerge.destroy();
                }
            } catch (Throwable th2) {
                th = th2;
                temporaryBuffer = temporaryBufferDoMerge;
                if (temporaryBuffer != null) {
                    temporaryBuffer.destroy();
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private File writeMergedFile(TemporaryBuffer temporaryBuffer, Attributes attributes) throws IOException {
        File workTree = nonNullRepo().getWorkTree();
        String pathString = this.tw.getPathString();
        File file = new File(workTree, pathString);
        CoreConfig.EolStreamType eolStreamTypeDetectCheckoutStreamType = this.workTreeUpdater.detectCheckoutStreamType(attributes);
        WorkTreeUpdater workTreeUpdater = this.workTreeUpdater;
        temporaryBuffer.getClass();
        workTreeUpdater.updateFileWithContent(new ResolveMerger$$ExternalSyntheticLambda0(temporaryBuffer), eolStreamTypeDetectCheckoutStreamType, this.tw.getSmudgeCommand(attributes), pathString, file);
        return file;
    }

    private TemporaryBuffer doMerge(MergeResult<RawText> mergeResult) throws IOException {
        TemporaryBuffer.LocalFile localFile = new TemporaryBuffer.LocalFile(this.db != null ? nonNullRepo().getDirectory() : null, this.workTreeUpdater.getInCoreFileSizeLimit());
        try {
            new MergeFormatter().formatMerge(localFile, mergeResult, Arrays.asList(this.commitNames), StandardCharsets.UTF_8);
            localFile.close();
            return localFile;
        } catch (Throwable th) {
            localFile.destroy();
            throw th;
        }
    }

    /* WARN: Code duplicated, block: B:11:0x0018 A[RETURN] */
    private int mergeFileModes(int i, int i2, int i3) {
        if (i2 != i3) {
            if (i == i2) {
                if (i3 != FileMode.MISSING.getBits()) {
                    return i3;
                }
            } else if (i == i3) {
                if (i2 == FileMode.MISSING.getBits()) {
                    return i3;
                }
            } else {
                return FileMode.MISSING.getBits();
            }
        }
        return i2;
    }

    private RawText getRawText(ObjectId objectId, Attributes attributes) throws IOException, BinaryBlobException {
        if (objectId.equals((AnyObjectId) ObjectId.zeroId())) {
            return new RawText(new byte[0]);
        }
        return RawText.load(LfsFactory.getInstance().applySmudgeFilter(getRepository(), this.reader.open(objectId, 3), attributes.get("merge")), PackConfig.DEFAULT_BIG_FILE_THRESHOLD);
    }

    private static boolean nonTree(int i) {
        return (i == 0 || FileMode.TREE.equals(i)) ? false : true;
    }

    private static boolean isGitLink(int i) {
        return FileMode.GITLINK.equals(i);
    }

    @Override // org.eclipse.jgit.merge.Merger
    public ObjectId getResultTreeId() {
        ObjectId objectId = this.resultTree;
        if (objectId == null) {
            return null;
        }
        return objectId.toObjectId();
    }

    public void setCommitNames(String[] strArr) {
        this.commitNames = strArr;
    }

    public String[] getCommitNames() {
        return this.commitNames;
    }

    public List<String> getUnmergedPaths() {
        return this.unmergedPaths;
    }

    public List<String> getModifiedFiles() {
        WorkTreeUpdater workTreeUpdater = this.workTreeUpdater;
        return workTreeUpdater != null ? workTreeUpdater.getModifiedFiles() : this.modifiedFiles;
    }

    public Map<String, DirCacheEntry> getToBeCheckedOut() {
        return this.workTreeUpdater.getToBeCheckedOut();
    }

    public Map<String, MergeResult<? extends Sequence>> getMergeResults() {
        return this.mergeResults;
    }

    public Map<String, MergeFailureReason> getFailingPaths() {
        if (this.failingPaths.isEmpty()) {
            return null;
        }
        return this.failingPaths;
    }

    public boolean failed() {
        return !this.failingPaths.isEmpty();
    }

    public void setDirCache(DirCache dirCache) {
        this.dircache = dirCache;
    }

    public void setWorkingTreeIterator(WorkingTreeIterator workingTreeIterator) {
        this.workingTreeIterator = workingTreeIterator;
    }

    public void setAttributesNodeProvider(AttributesNodeProvider attributesNodeProvider) {
        this.attributesNodeProvider = attributesNodeProvider;
    }

    /* WARN: Code duplicated, block: B:19:0x007c A[DONT_GENERATE] */
    protected boolean mergeTrees(AbstractTreeIterator abstractTreeIterator, RevTree revTree, RevTree revTree2, boolean z) throws IOException {
        WorkTreeUpdater workTreeUpdaterCreateWorkTreeUpdater;
        try {
            if (this.inCore) {
                workTreeUpdaterCreateWorkTreeUpdater = WorkTreeUpdater.createInCoreWorkTreeUpdater(this.db, this.dircache, getObjectInserter());
            } else {
                workTreeUpdaterCreateWorkTreeUpdater = WorkTreeUpdater.createWorkTreeUpdater(this.db, this.dircache);
            }
            this.workTreeUpdater = workTreeUpdaterCreateWorkTreeUpdater;
            this.dircache = workTreeUpdaterCreateWorkTreeUpdater.getLockedDirCache();
            NameConflictTreeWalk nameConflictTreeWalk = new NameConflictTreeWalk(this.db, this.reader);
            this.tw = nameConflictTreeWalk;
            AttributesNodeProvider attributesNodeProvider = this.attributesNodeProvider;
            if (attributesNodeProvider != null) {
                nameConflictTreeWalk.setAttributesNodeProvider(attributesNodeProvider);
            }
            this.tw.addTree(abstractTreeIterator);
            NameConflictTreeWalk nameConflictTreeWalk2 = this.tw;
            nameConflictTreeWalk2.setHead(nameConflictTreeWalk2.addTree(revTree));
            this.tw.addTree(revTree2);
            int iAddTree = this.tw.addTree(this.workTreeUpdater.createDirCacheBuildIterator());
            WorkingTreeIterator workingTreeIterator = this.workingTreeIterator;
            if (workingTreeIterator != null) {
                this.tw.addTree(workingTreeIterator);
                this.workingTreeIterator.setDirCacheIterator(this.tw, iAddTree);
            } else {
                this.tw.setFilter(TreeFilter.ANY_DIFF);
            }
            if (mergeTreeWalk(this.tw, z)) {
                this.workTreeUpdater.writeWorkTreeChanges(true);
                if (getUnmergedPaths().isEmpty() && !failed()) {
                    WorkTreeUpdater.Result resultWriteIndexChanges = this.workTreeUpdater.writeIndexChanges();
                    this.resultTree = resultWriteIndexChanges.getTreeId();
                    this.modifiedFiles = resultWriteIndexChanges.getModifiedFiles();
                    Iterator<String> it = resultWriteIndexChanges.getFailedToDelete().iterator();
                    while (it.hasNext()) {
                        this.failingPaths.put(it.next(), MergeFailureReason.COULD_NOT_DELETE);
                    }
                    return resultWriteIndexChanges.getFailedToDelete().isEmpty();
                }
                this.resultTree = null;
            }
            return false;
        } finally {
            if (this.modifiedFiles.isEmpty()) {
                this.modifiedFiles = this.workTreeUpdater.getModifiedFiles();
            }
            this.workTreeUpdater.close();
            this.workTreeUpdater = null;
        }
    }

    protected boolean mergeTreeWalk(TreeWalk treeWalk, boolean z) throws IOException {
        boolean z2 = this.tw.getTreeCount() > 4;
        boolean z3 = treeWalk.getAttributesNodeProvider() != null;
        while (treeWalk.next()) {
            Attributes attributes = NO_ATTRIBUTES;
            Attributes[] attributesArr = {attributes, attributes, attributes};
            if (z3) {
                attributesArr[0] = treeWalk.getAttributes(0);
                attributesArr[1] = treeWalk.getAttributes(1);
                attributesArr[2] = treeWalk.getAttributes(2);
            }
            if (!processEntry((CanonicalTreeParser) treeWalk.getTree(0, CanonicalTreeParser.class), (CanonicalTreeParser) treeWalk.getTree(1, CanonicalTreeParser.class), (CanonicalTreeParser) treeWalk.getTree(2, CanonicalTreeParser.class), (DirCacheBuildIterator) treeWalk.getTree(3, DirCacheBuildIterator.class), z2 ? (WorkingTreeIterator) treeWalk.getTree(4, WorkingTreeIterator.class) : null, z, attributesArr)) {
                this.workTreeUpdater.revertModifiedFiles();
                return false;
            }
            if (treeWalk.isSubtree() && this.enterSubtree) {
                treeWalk.enterSubtree();
            }
        }
        return true;
    }
}
