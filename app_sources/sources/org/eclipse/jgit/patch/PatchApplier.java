package org.eclipse.jgit.patch;

import com.google.api.client.googleapis.media.MediaHttpUploader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.zip.InflaterInputStream;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.api.errors.FilterFailedException;
import org.eclipse.jgit.attributes.Attribute;
import org.eclipse.jgit.attributes.Attributes;
import org.eclipse.jgit.attributes.FilterCommandRegistry;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.RawText;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.dircache.DirCacheBuilder;
import org.eclipse.jgit.dircache.DirCacheCheckout;
import org.eclipse.jgit.dircache.DirCacheEntry;
import org.eclipse.jgit.dircache.DirCacheIterator;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.IndexWriteException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.CommitConfig$$ExternalSyntheticBackport0;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.CoreConfig;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.FileModeCache;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.merge.ResolveMerger$$ExternalSyntheticLambda0;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.WorkingTreeOptions;
import org.eclipse.jgit.treewalk.filter.AndTreeFilter;
import org.eclipse.jgit.treewalk.filter.NotIgnoredFilter;
import org.eclipse.jgit.treewalk.filter.PathFilterGroup;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.FileUtils;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.LfsFactory;
import org.eclipse.jgit.util.RawParseUtils;
import org.eclipse.jgit.util.StringUtils;
import org.eclipse.jgit.util.SystemReader;
import org.eclipse.jgit.util.TemporaryBuffer;
import org.eclipse.jgit.util.io.BinaryDeltaInputStream;
import org.eclipse.jgit.util.io.BinaryHunkInputStream;
import org.eclipse.jgit.util.io.CountingOutputStream;
import org.eclipse.jgit.util.io.EolStreamTypeUtil;
import org.eclipse.jgit.util.sha1.SHA1;

/* INFO: loaded from: classes5.dex */
public class PatchApplier {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType = null;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$patch$BinaryHunk$Type = null;
    private static final int FILE_TREE_INDEX = 1;
    private static final byte[] NO_EOL = "\\ No newline at end of file".getBytes(StandardCharsets.US_ASCII);
    private boolean allowConflicts;

    @Nullable
    private final RevTree beforeTree;
    private final Charset charset;
    private int inCoreSizeLimit;
    private final ObjectInserter inserter;
    private final ObjectReader reader;
    private final Repository repo;
    private WorkingTreeOptions workingTreeOptions;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[DiffEntry.ChangeType.valuesCustom().length];
        try {
            iArr2[DiffEntry.ChangeType.ADD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[DiffEntry.ChangeType.COPY.ordinal()] = 5;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[DiffEntry.ChangeType.DELETE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[DiffEntry.ChangeType.MODIFY.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[DiffEntry.ChangeType.RENAME.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$patch$BinaryHunk$Type() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$patch$BinaryHunk$Type;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[BinaryHunk.Type.valuesCustom().length];
        try {
            iArr2[BinaryHunk.Type.DELTA_DEFLATED.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[BinaryHunk.Type.LITERAL_DEFLATED.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$patch$BinaryHunk$Type = iArr2;
        return iArr2;
    }

    public PatchApplier(Repository repository) {
        this.repo = repository;
        ObjectInserter objectInserterNewObjectInserter = repository.newObjectInserter();
        this.inserter = objectInserterNewObjectInserter;
        this.reader = objectInserterNewObjectInserter.newReader();
        this.beforeTree = null;
        this.allowConflicts = false;
        this.charset = StandardCharsets.UTF_8;
        StoredConfig config = repository.getConfig();
        this.workingTreeOptions = (WorkingTreeOptions) config.get(WorkingTreeOptions.KEY);
        this.inCoreSizeLimit = config.getInt("merge", ConfigConstants.CONFIG_KEY_IN_CORE_LIMIT, MediaHttpUploader.DEFAULT_CHUNK_SIZE);
    }

    public PatchApplier(Repository repository, RevTree revTree, ObjectInserter objectInserter) {
        this.repo = repository;
        this.beforeTree = revTree;
        this.inserter = objectInserter;
        this.reader = objectInserter.newReader();
        this.allowConflicts = false;
        this.charset = StandardCharsets.UTF_8;
    }

    public static class Result {
        private List<Error> errors = new ArrayList();
        private List<String> paths;
        private ObjectId treeId;

        public static class Error {

            @Nullable
            final HunkHeader hh;
            final boolean isGitConflict;
            final String msg;
            final String oldFileName;

            Error(String str, String str2, @Nullable HunkHeader hunkHeader, boolean z) {
                this.msg = str;
                this.oldFileName = str2;
                this.hh = hunkHeader;
                this.isGitConflict = z;
            }

            public boolean isGitConflict() {
                return this.isGitConflict;
            }

            public String toString() {
                if (this.hh != null) {
                    return MessageFormat.format(JGitText.get().patchApplyErrorWithHunk, this.oldFileName, this.hh, this.msg);
                }
                return MessageFormat.format(JGitText.get().patchApplyErrorWithoutHunk, this.oldFileName, this.msg);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && (obj instanceof Error)) {
                    Error error = (Error) obj;
                    if (Objects.equals(this.msg, error.msg) && Objects.equals(this.oldFileName, error.oldFileName) && Objects.equals(this.hh, error.hh) && this.isGitConflict == error.isGitConflict) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                return Objects.hash(this.msg, this.oldFileName, this.hh, Boolean.valueOf(this.isGitConflict));
            }
        }

        public List<String> getPaths() {
            return this.paths;
        }

        public ObjectId getTreeId() {
            return this.treeId;
        }

        public List<Error> getErrors() {
            return this.errors;
        }

        /* INFO: Access modifiers changed from: private */
        public void addError(String str, String str2, @Nullable HunkHeader hunkHeader) {
            this.errors.add(new Error(str, str2, hunkHeader, false));
        }

        /* INFO: Access modifiers changed from: private */
        public void addErrorWithGitConflict(String str, String str2, @Nullable HunkHeader hunkHeader) {
            this.errors.add(new Error(str, str2, hunkHeader, true));
        }
    }

    public Result applyPatch(Patch patch) throws Throwable {
        Result result = new Result();
        DirCache dirCacheLockDirCache = inCore() ? DirCache.read(this.reader, this.beforeTree) : this.repo.lockDirCache();
        FileModeCache fileModeCache = new FileModeCache(this.repo);
        DirCacheBuilder dirCacheBuilderBuilder = dirCacheLockDirCache.builder();
        HashSet hashSet = new HashSet();
        Iterator<? extends FileHeader> it = patch.getFiles().iterator();
        while (true) {
            if (it.hasNext()) {
                FileHeader next = it.next();
                DiffEntry.ChangeType changeType = next.getChangeType();
                File file = getFile(next.getOldPath());
                File file2 = getFile(next.getNewPath());
                if (verifyExistence(next, file, file2, result)) {
                    int i = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType()[changeType.ordinal()];
                    if (i == 1) {
                        if (file2 != null) {
                            fileModeCache.safeCreateParentDirectory(next.getNewPath(), file2.getParentFile(), false);
                            FileUtils.createNewFile(file2);
                        }
                        apply(next.getNewPath(), dirCacheLockDirCache, dirCacheBuilderBuilder, file2, next, result);
                    } else if (i == 2) {
                        apply(next.getOldPath(), dirCacheLockDirCache, dirCacheBuilderBuilder, file, next, result);
                    } else if (i != 3) {
                        if (i == 4) {
                            if (!inCore()) {
                                fileModeCache.safeCreateParentDirectory(next.getNewPath(), file2.getParentFile(), false);
                                FileUtils.rename(file, file2, StandardCopyOption.ATOMIC_MOVE);
                            }
                            apply(inCore() ? next.getOldPath() : next.getNewPath(), dirCacheLockDirCache, dirCacheBuilderBuilder, file2, next, result);
                        } else if (i == 5) {
                            if (!inCore()) {
                                fileModeCache.safeCreateParentDirectory(next.getNewPath(), file2.getParentFile(), false);
                                Files.copy(file.toPath(), file2.toPath(), new CopyOption[0]);
                            }
                            apply(next.getOldPath(), dirCacheLockDirCache, dirCacheBuilderBuilder, file2, next, result);
                        }
                    } else if (!inCore() && !file.delete()) {
                        throw new IOException(MessageFormat.format(JGitText.get().cannotDeleteFile, file));
                    }
                    if (next.getChangeType() != DiffEntry.ChangeType.DELETE) {
                        hashSet.add(next.getNewPath());
                    }
                    if (next.getChangeType() != DiffEntry.ChangeType.COPY && next.getChangeType() != DiffEntry.ChangeType.ADD) {
                        hashSet.add(next.getOldPath());
                    }
                }
            } else {
                for (int i2 = 0; i2 < dirCacheLockDirCache.getEntryCount(); i2++) {
                    DirCacheEntry entry = dirCacheLockDirCache.getEntry(i2);
                    if (!hashSet.contains(entry.getPathString()) || entry.getStage() != 0) {
                        dirCacheBuilderBuilder.add(entry);
                    }
                }
                if (inCore()) {
                    dirCacheBuilderBuilder.finish();
                } else if (!dirCacheBuilderBuilder.commit()) {
                    throw new IndexWriteException();
                }
                result.treeId = dirCacheLockDirCache.writeTree(this.inserter);
                result.paths = (List) hashSet.stream().sorted().collect(Collectors.toList());
                return result;
            }
        }
    }

    public PatchApplier allowConflicts() {
        this.allowConflicts = true;
        return this;
    }

    private File getFile(String str) {
        if (inCore()) {
            return null;
        }
        return new File(this.repo.getWorkTree(), str);
    }

    @Nullable
    private TreeWalk getTreeWalkForFile(String str, DirCache dirCache) throws IOException {
        if (inCore()) {
            return TreeWalk.forPath(this.repo, str, this.beforeTree);
        }
        TreeWalk treeWalk = new TreeWalk(this.repo);
        int iAddTree = treeWalk.addTree(new DirCacheIterator(dirCache));
        FileTreeIterator fileTreeIterator = new FileTreeIterator(this.repo);
        if (1 != treeWalk.addTree(fileTreeIterator)) {
            throw new IllegalStateException();
        }
        treeWalk.setFilter(AndTreeFilter.create(PathFilterGroup.createFromStrings(str), new NotIgnoredFilter(1)));
        treeWalk.setOperationType(TreeWalk.OperationType.CHECKIN_OP);
        treeWalk.setRecursive(true);
        fileTreeIterator.setDirCacheIterator(treeWalk, iAddTree);
        return treeWalk;
    }

    private boolean fileExists(String str, @Nullable File file) throws IOException {
        if (file != null) {
            return file.exists();
        }
        return inCore() && TreeWalk.forPath(this.repo, str, this.beforeTree) != null;
    }

    private boolean verifyExistence(FileHeader fileHeader, File file, File file2, Result result) throws IOException {
        boolean z;
        String str;
        boolean zContains = CommitConfig$$ExternalSyntheticBackport0.m(new Object[]{DiffEntry.ChangeType.MODIFY, DiffEntry.ChangeType.DELETE, DiffEntry.ChangeType.RENAME, DiffEntry.ChangeType.COPY}).contains(fileHeader.getChangeType());
        boolean zContains2 = CommitConfig$$ExternalSyntheticBackport0.m(new Object[]{DiffEntry.ChangeType.ADD, DiffEntry.ChangeType.RENAME, DiffEntry.ChangeType.COPY}).contains(fileHeader.getChangeType());
        if (zContains != fileExists(fileHeader.getOldPath(), file)) {
            if (zContains) {
                str = JGitText.get().applyPatchWithSourceOnNonExistentSource;
            } else {
                str = JGitText.get().applyPatchWithoutSourceOnAlreadyExistingSource;
            }
            result.addError(MessageFormat.format(str, fileHeader.getPatchType()), fileHeader.getOldPath(), null);
            z = false;
        } else {
            z = true;
        }
        if (zContains2 && fileExists(fileHeader.getNewPath(), file2)) {
            result.addError(MessageFormat.format(JGitText.get().applyPatchWithCreationOverAlreadyExistingDestination, fileHeader.getPatchType()), fileHeader.getNewPath(), null);
            z = false;
        }
        if (zContains && !validGitPath(fileHeader.getOldPath())) {
            result.addError(JGitText.get().applyPatchSourceInvalid, fileHeader.getOldPath(), null);
            z = false;
        }
        if (!zContains2 || validGitPath(fileHeader.getNewPath())) {
            return z;
        }
        result.addError(JGitText.get().applyPatchDestInvalid, fileHeader.getNewPath(), null);
        return false;
    }

    private boolean validGitPath(String str) {
        try {
            SystemReader.getInstance().checkPath(str);
            return true;
        } catch (CorruptObjectException unused) {
            return false;
        }
    }

    /* WARN: Code duplicated, block: B:33:0x00b7  */
    /* WARN: Multi-variable type inference failed */
    private void apply(String str, DirCache dirCache, DirCacheBuilder dirCacheBuilder, @Nullable File file, FileHeader fileHeader, Result result) throws Throwable {
        CoreConfig.EolStreamType eolStreamType;
        boolean z;
        CoreConfig.EolStreamType eolStreamType2;
        boolean z2;
        DirCacheCheckout.StreamSupplier patchApplier$$ExternalSyntheticLambda4;
        String filterCommand;
        FileHeader fileHeader2;
        Result result2;
        ContentStreamLoader contentStreamLoaderApplyText;
        Attributes attributes;
        TemporaryBuffer.LocalFile localFile;
        CoreConfig.EolStreamType eolStreamType3;
        CoreConfig.EolStreamType eolStreamType4;
        if (FileHeader.PatchType.BINARY.equals(fileHeader.getPatchType())) {
            return;
        }
        TreeWalk treeWalkForFile = getTreeWalkForFile(str, dirCache);
        int i = 0;
        boolean z3 = inCore() || needsCrLfConversion(file, fileHeader);
        if (z3) {
            eolStreamType = CoreConfig.EolStreamType.TEXT_CRLF;
        } else {
            eolStreamType = CoreConfig.EolStreamType.DIRECT;
        }
        ObjectId objectIdZeroId = ObjectId.zeroId();
        Throwable th = null;
        if (treeWalkForFile == null) {
            z = z3;
            eolStreamType2 = eolStreamType;
            z2 = false;
            patchApplier$$ExternalSyntheticLambda4 = null;
            filterCommand = null;
        } else if (inCore()) {
            objectIdZeroId = treeWalkForFile.getObjectId(0);
            byte[] bytes = LfsFactory.getInstance().applySmudgeFilter(this.repo, this.reader.open(objectIdZeroId, 3), null).getBytes();
            boolean zIsCrLfText = RawText.isCrLfText(bytes);
            patchApplier$$ExternalSyntheticLambda4 = new PatchApplier$$ExternalSyntheticLambda2(bytes);
            if (zIsCrLfText) {
                eolStreamType4 = CoreConfig.EolStreamType.TEXT_CRLF;
            } else {
                eolStreamType4 = CoreConfig.EolStreamType.DIRECT;
            }
            eolStreamType2 = eolStreamType4;
            filterCommand = treeWalkForFile.getFilterCommand(Constants.ATTR_FILTER_TYPE_SMUDGE);
            z2 = true;
            z = zIsCrLfText;
        } else if (treeWalkForFile.next()) {
            if (z3) {
                eolStreamType3 = CoreConfig.EolStreamType.TEXT_CRLF;
            } else {
                eolStreamType3 = treeWalkForFile.getEolStreamType(TreeWalk.OperationType.CHECKOUT_OP);
            }
            String filterCommand2 = treeWalkForFile.getFilterCommand(Constants.ATTR_FILTER_TYPE_SMUDGE);
            FileTreeIterator fileTreeIterator = (FileTreeIterator) treeWalkForFile.getTree(1, FileTreeIterator.class);
            if (fileTreeIterator != null) {
                ObjectId entryObjectId = fileTreeIterator.getEntryObjectId();
                fileTreeIterator.getClass();
                PatchApplier$$ExternalSyntheticLambda3 patchApplier$$ExternalSyntheticLambda3 = new PatchApplier$$ExternalSyntheticLambda3(fileTreeIterator);
                objectIdZeroId = entryObjectId;
                filterCommand = filterCommand2;
                z2 = true;
                patchApplier$$ExternalSyntheticLambda4 = patchApplier$$ExternalSyntheticLambda3;
                z = z3;
                eolStreamType2 = eolStreamType3;
            } else {
                throw new IOException(MessageFormat.format(JGitText.get().cannotReadFile, str));
            }
        } else {
            z = z3;
            eolStreamType2 = eolStreamType;
            z2 = false;
            patchApplier$$ExternalSyntheticLambda4 = null;
            filterCommand = null;
        }
        if (patchApplier$$ExternalSyntheticLambda4 == null) {
            patchApplier$$ExternalSyntheticLambda4 = inCore() ? new PatchApplier$$ExternalSyntheticLambda4() : new PatchApplier$$ExternalSyntheticLambda5(file);
        }
        DirCacheCheckout.StreamSupplier streamSupplier = patchApplier$$ExternalSyntheticLambda4;
        FileMode newMode = fileHeader.getNewMode() != null ? fileHeader.getNewMode() : FileMode.REGULAR_FILE;
        if (FileHeader.PatchType.GIT_BINARY.equals(fileHeader.getPatchType())) {
            contentStreamLoaderApplyText = applyBinary(str, file, fileHeader, streamSupplier, objectIdZeroId, result);
            this = this;
            file = file;
            fileHeader2 = fileHeader;
            i = 0;
            result2 = result;
        } else {
            fileHeader2 = fileHeader;
            result2 = result;
            contentStreamLoaderApplyText = applyText(getRawText(file, streamSupplier, objectIdZeroId, str, z2, treeWalkForFile != null ? treeWalkForFile.getFilterCommand(Constants.ATTR_FILTER_TYPE_CLEAN) : null, z), fileHeader2, result2);
        }
        if (contentStreamLoaderApplyText != null) {
            if (result2.getErrors().isEmpty() || !result2.getErrors().stream().anyMatch(new PatchApplier$$ExternalSyntheticLambda6())) {
                if (file != null) {
                    TemporaryBuffer.LocalFile localFile2 = new TemporaryBuffer.LocalFile(null);
                    try {
                        try {
                            try {
                                try {
                                    localFile = localFile2;
                                    try {
                                        DirCacheCheckout.getContent(this.repo, str, new DirCacheCheckout.CheckoutMetadata(eolStreamType2, filterCommand), contentStreamLoaderApplyText.supplier, this.workingTreeOptions, localFile);
                                        localFile.close();
                                        try {
                                            InputStream inputStreamOpenInputStream = localFile.openInputStream();
                                            try {
                                                Path path = file.toPath();
                                                CopyOption[] copyOptionArr = new CopyOption[1];
                                                copyOptionArr[i] = StandardCopyOption.REPLACE_EXISTING;
                                                Files.copy(inputStreamOpenInputStream, path, copyOptionArr);
                                                if (inputStreamOpenInputStream != null) {
                                                    inputStreamOpenInputStream.close();
                                                }
                                                localFile.destroy();
                                                this.repo.getFS().setExecute(file, newMode != FileMode.EXECUTABLE_FILE ? i : 1);
                                            } catch (Throwable th2) {
                                                if (inputStreamOpenInputStream == null) {
                                                    throw th2;
                                                }
                                                inputStreamOpenInputStream.close();
                                                throw th2;
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
                                    } catch (Throwable th4) {
                                        th = th4;
                                        Throwable th5 = th;
                                        localFile.close();
                                        throw th5;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    localFile = localFile2;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                localFile = localFile2;
                                localFile.destroy();
                                throw th;
                            }
                        } catch (Throwable th8) {
                            if (0 == 0) {
                                throw th8;
                            }
                            if (null != th8) {
                                th.addSuppressed(th8);
                            }
                            throw null;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        localFile.destroy();
                        throw th;
                    }
                }
                Instant instantLastModifiedInstant = file == null ? null : this.repo.getFS().lastModifiedInstant(file);
                if (treeWalkForFile != null) {
                    attributes = treeWalkForFile.getAttributes();
                } else {
                    attributes = new Attributes(new Attribute[i]);
                }
                DirCacheEntry dirCacheEntryInsertToIndex = this.insertToIndex(contentStreamLoaderApplyText.supplier.load(), fileHeader2.getNewPath().getBytes(StandardCharsets.UTF_8), newMode, instantLastModifiedInstant, contentStreamLoaderApplyText.length, attributes.get("filter"));
                dirCacheBuilder.add(dirCacheEntryInsertToIndex);
                if (!FileHeader.PatchType.GIT_BINARY.equals(fileHeader2.getPatchType()) || fileHeader2.getNewId() == null || !fileHeader2.getNewId().isComplete() || fileHeader2.getNewId().toObjectId().equals((AnyObjectId) dirCacheEntryInsertToIndex.getObjectId())) {
                    return;
                }
                result2.addError(MessageFormat.format(JGitText.get().applyBinaryResultOidWrong, str), fileHeader2.getOldPath(), null);
            }
        }
    }

    static /* synthetic */ InputStream lambda$0(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }

    static /* synthetic */ InputStream lambda$3(File file) throws IOException {
        return new FileInputStream(file);
    }

    static /* synthetic */ boolean lambda$4(Result.Error error) {
        return !error.msg.equals("cannot apply hunk");
    }

    private DirCacheEntry insertToIndex(InputStream inputStream, byte[] bArr, FileMode fileMode, Instant instant, long j, Attribute attribute) throws IOException {
        DirCacheEntry dirCacheEntry = new DirCacheEntry(bArr, 0);
        dirCacheEntry.setFileMode(fileMode);
        if (instant != null) {
            dirCacheEntry.setLastModified(instant);
        }
        dirCacheEntry.setLength(j);
        Throwable th = null;
        try {
            LfsFactory.LfsInputStream lfsInputStreamApplyCleanFilter = LfsFactory.getInstance().applyCleanFilter(this.repo, inputStream, j, attribute);
            try {
                dirCacheEntry.setObjectId(this.inserter.insert(3, lfsInputStreamApplyCleanFilter.getLength(), lfsInputStreamApplyCleanFilter));
                return dirCacheEntry;
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

    private RawText getRawText(@Nullable File file, DirCacheCheckout.StreamSupplier streamSupplier, ObjectId objectId, String str, boolean z, String str2, boolean z2) throws IOException {
        Throwable th = null;
        if (z) {
            try {
                InputStream inputStreamFilterClean = filterClean(this.repo, str, streamSupplier.load(), z2, str2);
                try {
                    return new RawText(IO.readWholeStream(inputStreamFilterClean, 0).array());
                } finally {
                    if (inputStreamFilterClean != null) {
                        inputStreamFilterClean.close();
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
        if (z2) {
            try {
                InputStream inputStreamWrapInputStream = EolStreamTypeUtil.wrapInputStream(streamSupplier.load(), CoreConfig.EolStreamType.TEXT_LF);
                try {
                    return new RawText(IO.readWholeStream(inputStreamWrapInputStream, 0).array());
                } finally {
                    if (inputStreamWrapInputStream != null) {
                        inputStreamWrapInputStream.close();
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
        if (inCore() && objectId.equals((AnyObjectId) ObjectId.zeroId())) {
            return new RawText(new byte[0]);
        }
        return new RawText(file);
    }

    private InputStream filterClean(Repository repository, String str, InputStream inputStream, boolean z, String str2) throws IOException {
        if (z) {
            inputStream = EolStreamTypeUtil.wrapInputStream(inputStream, CoreConfig.EolStreamType.TEXT_LF);
        }
        if (StringUtils.isEmptyOrNull(str2)) {
            return inputStream;
        }
        if (FilterCommandRegistry.isRegistered(str2)) {
            TemporaryBuffer.LocalFile localFile = new TemporaryBuffer.LocalFile(null, this.inCoreSizeLimit);
            while (FilterCommandRegistry.createFilterCommand(str2, repository, inputStream, localFile).run() != -1) {
            }
            return localFile.openInputStreamWithAutoDestroy();
        }
        FS fs = repository.getFS();
        ProcessBuilder processBuilderRunInShell = fs.runInShell(str2, new String[0]);
        processBuilderRunInShell.directory(repository.getWorkTree());
        processBuilderRunInShell.environment().put(Constants.GIT_DIR_KEY, repository.getDirectory().getAbsolutePath());
        try {
            FS.ExecutionResult executionResultExecute = fs.execute(processBuilderRunInShell, inputStream);
            int rc = executionResultExecute.getRc();
            if (rc != 0) {
                throw new IOException(new FilterFailedException(rc, str2, str, executionResultExecute.getStdout().toByteArray(4096), RawParseUtils.decode(executionResultExecute.getStderr().toByteArray(4096))));
            }
            return executionResultExecute.getStdout().openInputStreamWithAutoDestroy();
        } catch (IOException | InterruptedException e) {
            throw new IOException(new FilterFailedException(e, str2, str));
        }
    }

    private boolean needsCrLfConversion(File file, FileHeader fileHeader) throws IOException {
        if (FileHeader.PatchType.GIT_BINARY.equals(fileHeader.getPatchType()) || hasCrLf(fileHeader)) {
            return false;
        }
        Throwable th = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                return RawText.isCrLfText(fileInputStream);
            } finally {
                fileInputStream.close();
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

    private static boolean hasCrLf(FileHeader fileHeader) {
        char c;
        if (FileHeader.PatchType.GIT_BINARY.equals(fileHeader.getPatchType())) {
            return false;
        }
        for (HunkHeader hunkHeader : fileHeader.getHunks()) {
            byte[] buffer = hunkHeader.getBuffer();
            int endOffset = hunkHeader.getEndOffset();
            int startOffset = hunkHeader.getStartOffset();
            while (startOffset < endOffset) {
                int iNextLF = RawParseUtils.nextLF(buffer, startOffset);
                if (iNextLF > endOffset) {
                    iNextLF = endOffset;
                }
                if (iNextLF <= startOffset) {
                    break;
                }
                if (iNextLF - startOffset > 1 && (((c = (char) (buffer[startOffset] & 255)) == ' ' || c == '-') && buffer[iNextLF - 2] == 13)) {
                    return true;
                }
                startOffset = iNextLF;
            }
        }
        return false;
    }

    private ObjectId hash(File file) throws IOException {
        Throwable th = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                SHA1InputStream sHA1InputStream = new SHA1InputStream(fileInputStream, file.length());
                try {
                    sHA1InputStream.transferTo(OutputStream.nullOutputStream());
                    ObjectId objectId = sHA1InputStream.getHash().toObjectId();
                    sHA1InputStream.close();
                    fileInputStream.close();
                    return objectId;
                } catch (Throwable th2) {
                    sHA1InputStream.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    th = th3;
                } else if (null != th3) {
                    th.addSuppressed(th3);
                }
                fileInputStream.close();
                throw th;
            }
        } catch (Throwable th4) {
            if (0 == 0) {
                throw th4;
            }
            if (null != th4) {
                th.addSuppressed(th4);
            }
            throw null;
        }
    }

    /* WARN: Code duplicated, block: B:21:0x004f  */
    private boolean checkOid(ObjectId objectId, ObjectId objectId2, DiffEntry.ChangeType changeType, File file, String str, Result result) throws IOException {
        boolean zEquals;
        if (objectId2 != null) {
            zEquals = objectId.equals((AnyObjectId) objectId2);
            if (!zEquals && DiffEntry.ChangeType.ADD.equals(changeType) && ObjectId.zeroId().equals((AnyObjectId) objectId)) {
                zEquals = Constants.EMPTY_BLOB_ID.equals((AnyObjectId) objectId2);
            }
        } else if (inCore()) {
            zEquals = false;
        } else if (ObjectId.zeroId().equals((AnyObjectId) objectId)) {
            if (!file.exists() || file.length() == 0) {
                zEquals = true;
            } else {
                zEquals = false;
            }
        } else {
            zEquals = objectId.equals((AnyObjectId) hash(file));
        }
        if (!zEquals) {
            result.addError(MessageFormat.format(JGitText.get().applyBinaryBaseOidWrong, str), str, null);
        }
        return zEquals;
    }

    private boolean inCore() {
        return this.beforeTree != null;
    }

    private static class ContentStreamLoader {
        long length;
        DirCacheCheckout.StreamSupplier supplier;

        ContentStreamLoader(DirCacheCheckout.StreamSupplier streamSupplier, long j) {
            this.supplier = streamSupplier;
            this.length = j;
        }
    }

    @Nullable
    private ContentStreamLoader applyBinary(String str, File file, FileHeader fileHeader, DirCacheCheckout.StreamSupplier streamSupplier, ObjectId objectId, Result result) throws UnsupportedOperationException, IOException {
        Throwable th = null;
        if (!fileHeader.getOldId().isComplete() || !fileHeader.getNewId().isComplete()) {
            result.addError(MessageFormat.format(JGitText.get().applyBinaryOidTooShort, str), str, null);
            return null;
        }
        BinaryHunk forwardBinaryHunk = fileHeader.getForwardBinaryHunk();
        int iNextLF = RawParseUtils.nextLF(forwardBinaryHunk.getBuffer(), forwardBinaryHunk.getStartOffset());
        int endOffset = forwardBinaryHunk.getEndOffset() - iNextLF;
        int i = $SWITCH_TABLE$org$eclipse$jgit$patch$BinaryHunk$Type()[forwardBinaryHunk.getType().ordinal()];
        if (i == 1) {
            if (checkOid(fileHeader.getOldId().toObjectId(), objectId, fileHeader.getChangeType(), file, str, result)) {
                return new ContentStreamLoader(new PatchApplier$$ExternalSyntheticLambda7(forwardBinaryHunk, iNextLF, endOffset), forwardBinaryHunk.getSize());
            }
            return null;
        }
        if (i == 2) {
            try {
                InputStream inputStreamLoad = streamSupplier.load();
                try {
                    PatchApplier$$ExternalSyntheticLambda8 patchApplier$$ExternalSyntheticLambda8 = new PatchApplier$$ExternalSyntheticLambda8(IO.readWholeStream(inputStreamLoad, 0).array(), forwardBinaryHunk, iNextLF, endOffset);
                    return new ContentStreamLoader(patchApplier$$ExternalSyntheticLambda8, ((BinaryDeltaInputStream) patchApplier$$ExternalSyntheticLambda8.load()).getExpectedResultSize());
                } finally {
                    if (inputStreamLoad != null) {
                        inputStreamLoad.close();
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
        throw new UnsupportedOperationException(MessageFormat.format(JGitText.get().applyBinaryPatchTypeNotSupported, forwardBinaryHunk.getType().name()));
    }

    static /* synthetic */ InputStream lambda$5(BinaryHunk binaryHunk, int i, int i2) throws IOException {
        return new InflaterInputStream(new BinaryHunkInputStream(new ByteArrayInputStream(binaryHunk.getBuffer(), i, i2)));
    }

    static /* synthetic */ InputStream lambda$6(byte[] bArr, BinaryHunk binaryHunk, int i, int i2) throws IOException {
        return new BinaryDeltaInputStream(bArr, new InflaterInputStream(new BinaryHunkInputStream(new ByteArrayInputStream(binaryHunk.getBuffer(), i, i2))));
    }

    @Nullable
    private ContentStreamLoader applyText(RawText rawText, FileHeader fileHeader, Result result) throws IOException {
        int i;
        ContentStreamLoader contentStreamLoader;
        boolean z;
        boolean zCanApplyAt;
        byte b;
        boolean z2;
        ArrayList arrayList = new ArrayList(rawText.size());
        int i2 = 0;
        int i3 = 0;
        while (i3 < rawText.size()) {
            arrayList.add(rawText.getRawString(i3));
            i3++;
            i2 = 0;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        Iterator<? extends HunkHeader> it = fileHeader.getHunks().iterator();
        int newStartLine = -1;
        int i4 = i2;
        int i5 = i4;
        int i6 = i5;
        int i7 = i6;
        while (true) {
            ContentStreamLoader contentStreamLoader2 = null;
            if (!it.hasNext()) {
                break;
            }
            HunkHeader next = it.next();
            if (next.getNewStartLine() <= newStartLine) {
                result.addError(JGitText.get().applyTextPatchUnorderedHunks, fileHeader.getOldPath(), next);
                return null;
            }
            newStartLine = next.getNewStartLine();
            int endOffset = next.getEndOffset() - next.getStartOffset();
            byte[] bArr = new byte[endOffset];
            System.arraycopy(next.getBuffer(), next.getStartOffset(), bArr, i2, endOffset);
            RawText rawText2 = new RawText(bArr);
            ArrayList arrayList3 = new ArrayList(rawText2.size());
            int i8 = i2;
            while (i8 < rawText2.size()) {
                arrayList3.add(rawText2.getRawString(i8));
                i8++;
                i2 = 0;
            }
            boolean z3 = true;
            if (next.getNewStartLine() == 0) {
                if (fileHeader.getHunks().size() == 1 && canApplyAt(arrayList3, arrayList2, i2)) {
                    arrayList2.clear();
                    newStartLine = newStartLine;
                    break;
                }
                result.addError(JGitText.get().applyTextPatchSingleClearingHunk, fileHeader.getOldPath(), next);
                return null;
            }
            int newStartLine2 = (next.getNewStartLine() - 1) + i4;
            if (newStartLine2 >= i5 || i4 >= 0) {
                i = i4;
            } else {
                newStartLine2 = next.getNewStartLine() - 1;
                i = i2;
            }
            if (newStartLine2 < i5) {
                result.addError(JGitText.get().applyTextPatchUnorderedHunkApplications, fileHeader.getOldPath(), next);
                return null;
            }
            int linesContext = next.getLinesContext() + next.getOldImage().getLinesDeleted();
            if (linesContext <= 1) {
                zCanApplyAt = canApplyAt(arrayList3, arrayList2, newStartLine2);
                if (!zCanApplyAt && i != 0) {
                    newStartLine2 = next.getNewStartLine() - 1;
                    zCanApplyAt = (newStartLine2 < i5 || !canApplyAt(arrayList3, arrayList2, newStartLine2)) ? i2 : true;
                }
                contentStreamLoader = null;
            } else {
                int i9 = newStartLine2 - i5;
                while (true) {
                    if (i2 > i9) {
                        contentStreamLoader = contentStreamLoader2;
                        z = false;
                        break;
                    }
                    contentStreamLoader = contentStreamLoader2;
                    int i10 = newStartLine2 - i2;
                    if (canApplyAt(arrayList3, arrayList2, i10)) {
                        z = true;
                        newStartLine2 = i10;
                        break;
                    }
                    i2++;
                    contentStreamLoader2 = contentStreamLoader;
                }
                if (z) {
                    zCanApplyAt = z;
                } else {
                    int newStartLine3 = (next.getNewStartLine() - 1) + i;
                    int size = (arrayList2.size() - newStartLine3) - linesContext;
                    int i11 = 1;
                    while (true) {
                        if (i11 > size) {
                            zCanApplyAt = z;
                            newStartLine2 = newStartLine3;
                            break;
                        }
                        int i12 = newStartLine3 + i11;
                        if (canApplyAt(arrayList3, arrayList2, i12)) {
                            zCanApplyAt = true;
                            newStartLine2 = i12;
                            break;
                        }
                        i11++;
                    }
                }
            }
            byte b2 = 43;
            byte b3 = 32;
            if (!zCanApplyAt) {
                if (!this.allowConflicts) {
                    result.addError(JGitText.get().applyTextPatchCannotApplyHunk, fileHeader.getOldPath(), next);
                    return contentStreamLoader;
                }
                result.addErrorWithGitConflict("cannot apply hunk", fileHeader.getOldPath(), next);
                arrayList2.add(Math.min(newStartLine2, arrayList2.size()), asBytes("<<<<<<< HEAD"));
                int i13 = newStartLine2 + 1 + next.getOldImage().lineCount;
                int i14 = i13 + 1;
                arrayList2.add(Math.min(i13, arrayList2.size()), asBytes("======="));
                int size2 = arrayList3.size();
                int i15 = 1;
                while (i15 < size2) {
                    ByteBuffer byteBuffer = arrayList3.get(i15);
                    if (byteBuffer.hasRemaining()) {
                        byte b4 = byteBuffer.array()[byteBuffer.position()];
                        if (b4 == 32 || b4 == b2) {
                            z2 = true;
                            arrayList2.add(Math.min(i14, arrayList2.size()), slice(byteBuffer, 1));
                            i14++;
                        } else {
                            z2 = true;
                        }
                    } else {
                        i14++;
                        z2 = z3;
                        i7 = 0;
                    }
                    i15++;
                    z3 = z2;
                    b2 = 43;
                }
                arrayList2.add(Math.min(i14, arrayList2.size()), asBytes(">>>>>>> PATCH"));
                i4 = i;
            } else {
                int newStartLine4 = (newStartLine2 - next.getNewStartLine()) + 1;
                int size3 = arrayList3.size();
                i5 = newStartLine2;
                int i16 = 1;
                while (i16 < size3) {
                    ByteBuffer byteBuffer2 = arrayList3.get(i16);
                    if (byteBuffer2.hasRemaining() && (b = byteBuffer2.array()[byteBuffer2.position()]) != b3) {
                        if (b == 43) {
                            arrayList2.add(i5, slice(byteBuffer2, 1));
                            i5++;
                        } else if (b == 45) {
                            arrayList2.remove(i5);
                            i7 = 1;
                        } else if (b == 92 && i7 == 0 && isNoNewlineAtEnd(byteBuffer2)) {
                            i6 = 1;
                        }
                        i16++;
                        i7 = i7;
                        b3 = 32;
                    } else {
                        i5++;
                    }
                    i7 = 0;
                    i16++;
                    i7 = i7;
                    b3 = 32;
                }
                i4 = newStartLine4;
            }
            i2 = 0;
        }
        if (newStartLine < 0 || i5 != arrayList2.size()) {
            if (!rawText.isMissingNewlineAtEnd()) {
                arrayList2.add(null);
            }
        } else if (i6 == 0) {
            arrayList2.add(null);
        }
        return toContentStreamLoader(arrayList2);
    }

    private static ContentStreamLoader toContentStreamLoader(List<ByteBuffer> list) throws IOException {
        ByteBuffer next;
        Throwable th = null;
        TemporaryBuffer.LocalFile localFile = new TemporaryBuffer.LocalFile(null);
        try {
            CountingOutputStream countingOutputStream = new CountingOutputStream(localFile);
            try {
                Iterator<ByteBuffer> it = list.iterator();
                while (it.hasNext() && (next = it.next()) != null) {
                    countingOutputStream.write(next.array(), next.position(), next.remaining());
                    if (it.hasNext()) {
                        countingOutputStream.write(10);
                    }
                }
                return new ContentStreamLoader(new ResolveMerger$$ExternalSyntheticLambda0(localFile), countingOutputStream.getCount());
            } finally {
                countingOutputStream.close();
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

    private ByteBuffer asBytes(String str) {
        return ByteBuffer.wrap(str.getBytes(this.charset));
    }

    private boolean canApplyAt(List<ByteBuffer> list, List<ByteBuffer> list2, int i) {
        int size = list.size();
        int size2 = list2.size();
        for (int i2 = 1; i2 < size; i2++) {
            ByteBuffer byteBuffer = list.get(i2);
            if (!byteBuffer.hasRemaining()) {
                if (i >= size2 || list2.get(i).hasRemaining()) {
                    return false;
                }
            } else {
                byte b = byteBuffer.array()[byteBuffer.position()];
                if (b == 32 || b == 45) {
                    if (i >= size2 || !list2.get(i).equals(slice(byteBuffer, 1))) {
                        return false;
                    }
                }
            }
            i++;
        }
        return true;
    }

    private ByteBuffer slice(ByteBuffer byteBuffer, int i) {
        int iPosition = byteBuffer.position() + i;
        return ByteBuffer.wrap(byteBuffer.array(), iPosition, byteBuffer.limit() - iPosition);
    }

    private boolean isNoNewlineAtEnd(ByteBuffer byteBuffer) {
        byte[] bArr = NO_EOL;
        return Arrays.equals(bArr, 0, bArr.length, byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
    }

    private static class SHA1InputStream extends InputStream {
        private final SHA1 hash;
        private final InputStream in;

        SHA1InputStream(InputStream inputStream, long j) {
            SHA1 sha1NewInstance = SHA1.newInstance();
            this.hash = sha1NewInstance;
            sha1NewInstance.update(Constants.encodedTypeString(3));
            sha1NewInstance.update((byte) 32);
            sha1NewInstance.update(Constants.encodeASCII(j));
            sha1NewInstance.update((byte) 0);
            this.in = inputStream;
        }

        public SHA1 getHash() {
            return this.hash;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int i = this.in.read();
            if (i >= 0) {
                this.hash.update((byte) i);
            }
            return i;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.in.read(bArr, i, i2);
            if (i3 > 0) {
                this.hash.update(bArr, i, i3);
            }
            return i3;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.in.close();
        }
    }
}
