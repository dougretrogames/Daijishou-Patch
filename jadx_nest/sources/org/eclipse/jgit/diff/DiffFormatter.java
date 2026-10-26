package org.eclipse.jgit.diff;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.Soundex;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.attributes.Attribute;
import org.eclipse.jgit.dircache.DirCacheIterator;
import org.eclipse.jgit.errors.AmbiguousObjectException;
import org.eclipse.jgit.errors.BinaryBlobException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.patch.FileHeader;
import org.eclipse.jgit.revwalk.FollowFilter;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.treewalk.EmptyTreeIterator;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.WorkingTreeIterator;
import org.eclipse.jgit.treewalk.filter.AndTreeFilter;
import org.eclipse.jgit.treewalk.filter.IndexDiffFilter;
import org.eclipse.jgit.treewalk.filter.NotIgnoredFilter;
import org.eclipse.jgit.treewalk.filter.PathFilter;
import org.eclipse.jgit.treewalk.filter.TreeFilter;
import org.eclipse.jgit.util.LfsFactory;
import org.eclipse.jgit.util.QuotedString;

/* INFO: loaded from: classes5.dex */
public class DiffFormatter implements AutoCloseable {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType = null;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$Side = null;
    private static final int DEFAULT_BINARY_FILE_THRESHOLD = 52428800;
    private boolean closeReader;
    private DiffAlgorithm diffAlgorithm;
    private DiffConfig diffCfg;
    private final OutputStream out;
    private ProgressMonitor progressMonitor;
    private Boolean quotePaths;
    private ObjectReader reader;
    private RenameDetector renameDetector;
    private Repository repository;
    private ContentSource.Pair source;
    private static final byte[] noNewLine = Constants.encodeASCII("\\ No newline at end of file\n");
    private static final byte[] EMPTY = new byte[0];
    private int context = 3;
    private int abbreviationLength = 7;
    private RawTextComparator comparator = RawTextComparator.DEFAULT;
    private int binaryFileThreshold = 52428800;
    private String oldPrefix = "a/";
    private String newPrefix = "b/";
    private TreeFilter pathFilter = TreeFilter.ALL;

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

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$Side() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$Side;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[DiffEntry.Side.valuesCustom().length];
        try {
            iArr2[DiffEntry.Side.NEW.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[DiffEntry.Side.OLD.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$Side = iArr2;
        return iArr2;
    }

    public DiffFormatter(OutputStream outputStream) {
        this.out = outputStream;
    }

    protected OutputStream getOutputStream() {
        return this.out;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
        setReader(repository.newObjectReader(), repository.getConfig(), true);
    }

    public void setReader(ObjectReader objectReader, Config config) {
        setReader(objectReader, config, false);
    }

    private void setReader(ObjectReader objectReader, Config config, boolean z) {
        close();
        this.closeReader = z;
        this.reader = objectReader;
        this.diffCfg = (DiffConfig) config.get(DiffConfig.KEY);
        if (this.quotePaths == null) {
            this.quotePaths = Boolean.valueOf(config.getBoolean(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_KEY_QUOTE_PATH, true));
        }
        ContentSource contentSourceCreate = ContentSource.create(objectReader);
        this.source = new ContentSource.Pair(contentSourceCreate, contentSourceCreate);
        if (this.diffCfg.isNoPrefix()) {
            setOldPrefix("");
            setNewPrefix("");
        }
        setDetectRenames(this.diffCfg.isRenameDetectionEnabled());
        this.diffAlgorithm = DiffAlgorithm.getAlgorithm((DiffAlgorithm.SupportedAlgorithm) config.getEnum("diff", null, ConfigConstants.CONFIG_KEY_ALGORITHM, DiffAlgorithm.SupportedAlgorithm.HISTOGRAM));
    }

    public void setContext(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(JGitText.get().contextMustBeNonNegative);
        }
        this.context = i;
    }

    public void setAbbreviationLength(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(JGitText.get().abbreviationLengthMustBeNonNegative);
        }
        this.abbreviationLength = i;
    }

    public void setDiffAlgorithm(DiffAlgorithm diffAlgorithm) {
        this.diffAlgorithm = diffAlgorithm;
    }

    public void setDiffComparator(RawTextComparator rawTextComparator) {
        this.comparator = rawTextComparator;
    }

    public void setBinaryFileThreshold(int i) {
        this.binaryFileThreshold = i;
    }

    public void setOldPrefix(String str) {
        this.oldPrefix = str;
    }

    public String getOldPrefix() {
        return this.oldPrefix;
    }

    public void setNewPrefix(String str) {
        this.newPrefix = str;
    }

    public String getNewPrefix() {
        return this.newPrefix;
    }

    public boolean isDetectRenames() {
        return this.renameDetector != null;
    }

    public void setDetectRenames(boolean z) {
        if (z && this.renameDetector == null) {
            assertHaveReader();
            this.renameDetector = new RenameDetector(this.reader, this.diffCfg);
        } else {
            if (z) {
                return;
            }
            this.renameDetector = null;
        }
    }

    public RenameDetector getRenameDetector() {
        return this.renameDetector;
    }

    public void setProgressMonitor(ProgressMonitor progressMonitor) {
        this.progressMonitor = progressMonitor;
    }

    public void setQuotePaths(boolean z) {
        this.quotePaths = Boolean.valueOf(z);
    }

    public void setPathFilter(TreeFilter treeFilter) {
        if (treeFilter == null) {
            treeFilter = TreeFilter.ALL;
        }
        this.pathFilter = treeFilter;
    }

    public TreeFilter getPathFilter() {
        return this.pathFilter;
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        ObjectReader objectReader = this.reader;
        if (objectReader == null || !this.closeReader) {
            return;
        }
        objectReader.close();
    }

    public List<DiffEntry> scan(AnyObjectId anyObjectId, AnyObjectId anyObjectId2) throws IOException {
        RevTree tree;
        assertHaveReader();
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.reader);
            if (anyObjectId != null) {
                try {
                    tree = revWalk.parseTree(anyObjectId);
                } finally {
                    revWalk.close();
                }
            } else {
                tree = null;
            }
            return scan(tree, anyObjectId2 != null ? revWalk.parseTree(anyObjectId2) : null);
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

    public List<DiffEntry> scan(RevTree revTree, RevTree revTree2) throws IOException {
        assertHaveReader();
        return scan(makeIteratorFromTreeOrNull(revTree), makeIteratorFromTreeOrNull(revTree2));
    }

    private AbstractTreeIterator makeIteratorFromTreeOrNull(RevTree revTree) throws IOException {
        if (revTree != null) {
            CanonicalTreeParser canonicalTreeParser = new CanonicalTreeParser();
            canonicalTreeParser.reset(this.reader, revTree);
            return canonicalTreeParser;
        }
        return new EmptyTreeIterator();
    }

    public List<DiffEntry> scan(AbstractTreeIterator abstractTreeIterator, AbstractTreeIterator abstractTreeIterator2) throws IOException {
        assertHaveReader();
        TreeWalk treeWalk = new TreeWalk(this.repository, this.reader);
        int iAddTree = treeWalk.addTree(abstractTreeIterator);
        int iAddTree2 = treeWalk.addTree(abstractTreeIterator2);
        if (this.repository != null) {
            if ((abstractTreeIterator instanceof WorkingTreeIterator) && (abstractTreeIterator2 instanceof DirCacheIterator)) {
                ((WorkingTreeIterator) abstractTreeIterator).setDirCacheIterator(treeWalk, iAddTree2);
            } else if ((abstractTreeIterator2 instanceof WorkingTreeIterator) && (abstractTreeIterator instanceof DirCacheIterator)) {
                ((WorkingTreeIterator) abstractTreeIterator2).setDirCacheIterator(treeWalk, iAddTree);
            }
        }
        treeWalk.setRecursive(true);
        TreeFilter diffTreeFilterFor = getDiffTreeFilterFor(abstractTreeIterator, abstractTreeIterator2);
        TreeFilter treeFilter = this.pathFilter;
        if (treeFilter instanceof FollowFilter) {
            treeWalk.setFilter(AndTreeFilter.create(PathFilter.create(((FollowFilter) treeFilter).getPath()), diffTreeFilterFor));
        } else {
            treeWalk.setFilter(AndTreeFilter.create(treeFilter, diffTreeFilterFor));
        }
        this.source = new ContentSource.Pair(source(abstractTreeIterator), source(abstractTreeIterator2));
        List<DiffEntry> listScan = DiffEntry.scan(treeWalk);
        if (!(this.pathFilter instanceof FollowFilter) || !isAdd(listScan)) {
            return this.renameDetector != null ? detectRenames(listScan) : listScan;
        }
        abstractTreeIterator.reset();
        abstractTreeIterator2.reset();
        treeWalk.reset();
        treeWalk.addTree(abstractTreeIterator);
        treeWalk.addTree(abstractTreeIterator2);
        treeWalk.setFilter(diffTreeFilterFor);
        if (this.renameDetector == null) {
            setDetectRenames(true);
        }
        return updateFollowFilter(detectRenames(DiffEntry.scan(treeWalk)));
    }

    private static TreeFilter getDiffTreeFilterFor(AbstractTreeIterator abstractTreeIterator, AbstractTreeIterator abstractTreeIterator2) {
        if ((abstractTreeIterator instanceof DirCacheIterator) && (abstractTreeIterator2 instanceof WorkingTreeIterator)) {
            return new IndexDiffFilter(0, 1);
        }
        boolean z = abstractTreeIterator instanceof WorkingTreeIterator;
        if (z && (abstractTreeIterator2 instanceof DirCacheIterator)) {
            return new IndexDiffFilter(1, 0);
        }
        TreeFilter treeFilterCreate = TreeFilter.ANY_DIFF;
        if (z) {
            treeFilterCreate = AndTreeFilter.create(new NotIgnoredFilter(0), treeFilterCreate);
        }
        return abstractTreeIterator2 instanceof WorkingTreeIterator ? AndTreeFilter.create(new NotIgnoredFilter(1), treeFilterCreate) : treeFilterCreate;
    }

    private ContentSource source(AbstractTreeIterator abstractTreeIterator) {
        if (abstractTreeIterator instanceof WorkingTreeIterator) {
            return ContentSource.create((WorkingTreeIterator) abstractTreeIterator);
        }
        return ContentSource.create(this.reader);
    }

    private List<DiffEntry> detectRenames(List<DiffEntry> list) throws IOException {
        this.renameDetector.reset();
        this.renameDetector.addAll(list);
        try {
            return this.renameDetector.compute(this.reader, this.progressMonitor);
        } catch (CanceledException unused) {
            return Collections.emptyList();
        }
    }

    private boolean isAdd(List<DiffEntry> list) {
        String path = ((FollowFilter) this.pathFilter).getPath();
        for (DiffEntry diffEntry : list) {
            if (diffEntry.getChangeType() == DiffEntry.ChangeType.ADD && diffEntry.getNewPath().equals(path)) {
                return true;
            }
        }
        return false;
    }

    private List<DiffEntry> updateFollowFilter(List<DiffEntry> list) {
        String path = ((FollowFilter) this.pathFilter).getPath();
        for (DiffEntry diffEntry : list) {
            if (isRename(diffEntry) && diffEntry.getNewPath().equals(path)) {
                this.pathFilter = FollowFilter.create(diffEntry.getOldPath(), this.diffCfg);
                return Collections.singletonList(diffEntry);
            }
        }
        return Collections.emptyList();
    }

    private static boolean isRename(DiffEntry diffEntry) {
        return diffEntry.getChangeType() == DiffEntry.ChangeType.RENAME || diffEntry.getChangeType() == DiffEntry.ChangeType.COPY;
    }

    public void format(AnyObjectId anyObjectId, AnyObjectId anyObjectId2) throws IOException {
        format(scan(anyObjectId, anyObjectId2));
    }

    public void format(RevTree revTree, RevTree revTree2) throws IOException {
        format(scan(revTree, revTree2));
    }

    public void format(AbstractTreeIterator abstractTreeIterator, AbstractTreeIterator abstractTreeIterator2) throws IOException {
        format(scan(abstractTreeIterator, abstractTreeIterator2));
    }

    public void format(List<? extends DiffEntry> list) throws IOException {
        Iterator<? extends DiffEntry> it = list.iterator();
        while (it.hasNext()) {
            format(it.next());
        }
    }

    public void format(DiffEntry diffEntry) throws IOException {
        FormatResult formatResultCreateFormatResult = createFormatResult(diffEntry);
        format(formatResultCreateFormatResult.header, formatResultCreateFormatResult.a, formatResultCreateFormatResult.b, getDiffDriver(diffEntry));
    }

    private static byte[] writeGitLinkText(AbbreviatedObjectId abbreviatedObjectId) {
        if (ObjectId.zeroId().equals((AnyObjectId) abbreviatedObjectId.toObjectId())) {
            return EMPTY;
        }
        return Constants.encodeASCII("Subproject commit " + abbreviatedObjectId.name() + "\n");
    }

    private String format(AbbreviatedObjectId abbreviatedObjectId) {
        ObjectReader objectReader;
        if (abbreviatedObjectId.isComplete() && (objectReader = this.reader) != null) {
            try {
                abbreviatedObjectId = objectReader.abbreviate(abbreviatedObjectId.toObjectId(), this.abbreviationLength);
            } catch (IOException unused) {
            }
        }
        return abbreviatedObjectId.name();
    }

    private String quotePath(String str) {
        Boolean bool = this.quotePaths;
        if (bool == null || bool.booleanValue()) {
            return QuotedString.GIT_PATH.quote(str);
        }
        return QuotedString.GIT_PATH_MINIMAL.quote(str);
    }

    public void format(FileHeader fileHeader, RawText rawText, RawText rawText2, DiffDriver diffDriver) throws IOException {
        int startOffset = fileHeader.getStartOffset();
        int endOffset = fileHeader.getEndOffset();
        if (!fileHeader.getHunks().isEmpty()) {
            endOffset = fileHeader.getHunks().get(0).getStartOffset();
        }
        this.out.write(fileHeader.getBuffer(), startOffset, endOffset - startOffset);
        if (fileHeader.getPatchType() == FileHeader.PatchType.UNIFIED) {
            format(fileHeader.toEditList(), rawText, rawText2, diffDriver);
        }
    }

    public void format(FileHeader fileHeader, RawText rawText, RawText rawText2) throws IOException {
        format(fileHeader, rawText, rawText2, (DiffDriver) null);
    }

    public void format(EditList editList, RawText rawText, RawText rawText2) throws IOException {
        format(editList, rawText, rawText2, (DiffDriver) null);
    }

    public void format(EditList editList, RawText rawText, RawText rawText2, DiffDriver diffDriver) throws IOException {
        int i = 0;
        while (i < editList.size()) {
            Edit edit = editList.get(i);
            int iFindCombinedEnd = findCombinedEnd(editList, i);
            Edit edit2 = editList.get(iFindCombinedEnd);
            int iMax = (int) Math.max(0L, ((long) edit.getBeginA()) - ((long) this.context));
            int iMax2 = (int) Math.max(0L, ((long) edit.getBeginB()) - ((long) this.context));
            int iMin = (int) Math.min(rawText.size(), ((long) edit2.getEndA()) + ((long) this.context));
            int iMin2 = (int) Math.min(rawText2.size(), ((long) edit2.getEndB()) + ((long) this.context));
            int i2 = iMax;
            writeHunkHeader(i2, iMin, iMax2, iMin2, getFuncName(rawText, iMax - 1, diffDriver));
            while (true) {
                if (i2 < iMin || iMax2 < iMin2) {
                    if (i2 < edit.getBeginA() || iFindCombinedEnd + 1 < i) {
                        writeContextLine(rawText, i2);
                        if (isEndOfLineMissing(rawText, i2)) {
                            this.out.write(noNewLine);
                        }
                        i2++;
                    } else {
                        if (i2 < edit.getEndA()) {
                            writeRemovedLine(rawText, i2);
                            if (isEndOfLineMissing(rawText, i2)) {
                                this.out.write(noNewLine);
                            }
                            i2++;
                        } else if (iMax2 < edit.getEndB()) {
                            writeAddedLine(rawText2, iMax2);
                            if (isEndOfLineMissing(rawText2, iMax2)) {
                                this.out.write(noNewLine);
                            }
                        }
                        if (!end(edit, i2, iMax2) && (i = i + 1) < editList.size()) {
                            edit = editList.get(i);
                        }
                    }
                    iMax2++;
                    if (!end(edit, i2, iMax2)) {
                    }
                }
            }
        }
    }

    protected void writeContextLine(RawText rawText, int i) throws IOException {
        writeLine(TokenParser.SP, rawText, i);
    }

    private static boolean isEndOfLineMissing(RawText rawText, int i) {
        return i + 1 == rawText.size() && rawText.isMissingNewlineAtEnd();
    }

    protected void writeAddedLine(RawText rawText, int i) throws IOException {
        writeLine('+', rawText, i);
    }

    protected void writeRemovedLine(RawText rawText, int i) throws IOException {
        writeLine(Soundex.SILENT_MARKER, rawText, i);
    }

    protected void writeHunkHeader(int i, int i2, int i3, int i4) throws IOException {
        writeHunkHeader(i, i2, i3, i4, null);
    }

    protected void writeHunkHeader(int i, int i2, int i3, int i4, String str) throws IOException {
        this.out.write(64);
        this.out.write(64);
        writeRange(Soundex.SILENT_MARKER, i + 1, i2 - i);
        writeRange('+', i3 + 1, i4 - i3);
        this.out.write(32);
        this.out.write(64);
        this.out.write(64);
        if (str != null) {
            this.out.write(32);
            this.out.write(str.getBytes());
        }
        this.out.write(10);
    }

    private void writeRange(char c, int i, int i2) throws IOException {
        this.out.write(32);
        this.out.write(c);
        if (i2 == 0) {
            this.out.write(Constants.encodeASCII(i - 1));
            this.out.write(44);
            this.out.write(48);
        } else {
            if (i2 == 1) {
                this.out.write(Constants.encodeASCII(i));
                return;
            }
            this.out.write(Constants.encodeASCII(i));
            this.out.write(44);
            this.out.write(Constants.encodeASCII(i2));
        }
    }

    protected void writeLine(char c, RawText rawText, int i) throws IOException {
        this.out.write(c);
        rawText.writeLine(this.out, i);
        this.out.write(10);
    }

    public FileHeader toFileHeader(DiffEntry diffEntry) throws IOException {
        return createFormatResult(diffEntry).header;
    }

    private static class FormatResult {
        RawText a;
        RawText b;
        FileHeader header;

        /* synthetic */ FormatResult(DiffFormatterIA diffFormatterIA) {
            this();
        }

        private FormatResult() {
        }
    }

    private FormatResult createFormatResult(DiffEntry diffEntry) throws IOException {
        RawText rawText;
        RawText rawText2;
        FormatResult formatResult = new FormatResult(null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        formatHeader(byteArrayOutputStream, diffEntry);
        if (diffEntry.getOldId() == null || diffEntry.getNewId() == null) {
            formatResult.header = new FileHeader(byteArrayOutputStream.toByteArray(), new EditList(), FileHeader.PatchType.UNIFIED);
            return formatResult;
        }
        assertHaveReader();
        if (diffEntry.getOldMode() == FileMode.GITLINK || diffEntry.getNewMode() == FileMode.GITLINK) {
            rawText = new RawText(writeGitLinkText(diffEntry.getOldId()));
            rawText2 = new RawText(writeGitLinkText(diffEntry.getNewId()));
        } else {
            try {
                rawText = open(DiffEntry.Side.OLD, diffEntry);
                rawText2 = open(DiffEntry.Side.NEW, diffEntry);
            } catch (BinaryBlobException unused) {
                formatOldNewPaths(byteArrayOutputStream, diffEntry);
                byteArrayOutputStream.write(Constants.encodeASCII("Binary files differ\n"));
                formatResult.header = new FileHeader(byteArrayOutputStream.toByteArray(), new EditList(), FileHeader.PatchType.BINARY);
                return formatResult;
            }
        }
        formatResult.a = rawText;
        formatResult.b = rawText2;
        EditList editListDiff = diff(formatResult.a, formatResult.b);
        FileHeader.PatchType patchType = FileHeader.PatchType.UNIFIED;
        int i = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType()[diffEntry.getChangeType().ordinal()];
        if ((i != 4 && i != 5) || !editListDiff.isEmpty()) {
            formatOldNewPaths(byteArrayOutputStream, diffEntry);
        }
        formatResult.header = new FileHeader(byteArrayOutputStream.toByteArray(), editListDiff, patchType);
        return formatResult;
    }

    private EditList diff(RawText rawText, RawText rawText2) {
        return this.diffAlgorithm.diff(this.comparator, rawText, rawText2);
    }

    private void assertHaveReader() {
        if (this.reader == null) {
            throw new IllegalStateException(JGitText.get().readerIsRequired);
        }
    }

    private RawText open(DiffEntry.Side side, DiffEntry diffEntry) throws IOException, BinaryBlobException {
        if (diffEntry.getMode(side) == FileMode.MISSING) {
            return RawText.EMPTY_TEXT;
        }
        if (diffEntry.getMode(side).getObjectType() != 3) {
            return RawText.EMPTY_TEXT;
        }
        AbbreviatedObjectId id2 = diffEntry.getId(side);
        if (!id2.isComplete()) {
            Collection<ObjectId> collectionResolve = this.reader.resolve(id2);
            if (collectionResolve.size() == 1) {
                AbbreviatedObjectId abbreviatedObjectIdFromObjectId = AbbreviatedObjectId.fromObjectId(collectionResolve.iterator().next());
                int i = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$Side()[side.ordinal()];
                if (i == 1) {
                    diffEntry.oldId = abbreviatedObjectIdFromObjectId;
                } else if (i == 2) {
                    diffEntry.newId = abbreviatedObjectIdFromObjectId;
                }
            } else {
                if (collectionResolve.isEmpty()) {
                    throw new MissingObjectException(id2, 3);
                }
                throw new AmbiguousObjectException(id2, collectionResolve);
            }
        }
        return RawText.load(LfsFactory.getInstance().applySmudgeFilter(this.repository, this.source.open(side, diffEntry), diffEntry.getDiffAttribute()), this.binaryFileThreshold);
    }

    protected void formatGitDiffFirstHeaderLine(ByteArrayOutputStream byteArrayOutputStream, DiffEntry.ChangeType changeType, String str, String str2) throws IOException {
        byteArrayOutputStream.write(Constants.encodeASCII("diff --git "));
        byteArrayOutputStream.write(Constants.encode(quotePath(this.oldPrefix + (changeType == DiffEntry.ChangeType.ADD ? str2 : str))));
        byteArrayOutputStream.write(32);
        String str3 = this.newPrefix;
        if (changeType != DiffEntry.ChangeType.DELETE) {
            str = str2;
        }
        byteArrayOutputStream.write(Constants.encode(quotePath(str3 + str)));
        byteArrayOutputStream.write(10);
    }

    private void formatHeader(ByteArrayOutputStream byteArrayOutputStream, DiffEntry diffEntry) throws IOException {
        DiffEntry.ChangeType changeType = diffEntry.getChangeType();
        String oldPath = diffEntry.getOldPath();
        String newPath = diffEntry.getNewPath();
        FileMode oldMode = diffEntry.getOldMode();
        FileMode newMode = diffEntry.getNewMode();
        formatGitDiffFirstHeaderLine(byteArrayOutputStream, changeType, oldPath, newPath);
        if ((changeType == DiffEntry.ChangeType.MODIFY || changeType == DiffEntry.ChangeType.COPY || changeType == DiffEntry.ChangeType.RENAME) && !oldMode.equals(newMode)) {
            byteArrayOutputStream.write(Constants.encodeASCII("old mode "));
            oldMode.copyTo(byteArrayOutputStream);
            byteArrayOutputStream.write(10);
            byteArrayOutputStream.write(Constants.encodeASCII("new mode "));
            newMode.copyTo(byteArrayOutputStream);
            byteArrayOutputStream.write(10);
        }
        int i = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType()[changeType.ordinal()];
        if (i == 1) {
            byteArrayOutputStream.write(Constants.encodeASCII("new file mode "));
            newMode.copyTo(byteArrayOutputStream);
            byteArrayOutputStream.write(10);
        } else if (i != 2) {
            if (i == 3) {
                byteArrayOutputStream.write(Constants.encodeASCII("deleted file mode "));
                oldMode.copyTo(byteArrayOutputStream);
                byteArrayOutputStream.write(10);
            } else if (i == 4) {
                byteArrayOutputStream.write(Constants.encodeASCII("similarity index " + diffEntry.getScore() + "%"));
                byteArrayOutputStream.write(10);
                byteArrayOutputStream.write(Constants.encode("rename from " + quotePath(oldPath)));
                byteArrayOutputStream.write(10);
                byteArrayOutputStream.write(Constants.encode("rename to " + quotePath(newPath)));
                byteArrayOutputStream.write(10);
            } else if (i == 5) {
                byteArrayOutputStream.write(Constants.encodeASCII("similarity index " + diffEntry.getScore() + "%"));
                byteArrayOutputStream.write(10);
                byteArrayOutputStream.write(Constants.encode("copy from " + quotePath(oldPath)));
                byteArrayOutputStream.write(10);
                byteArrayOutputStream.write(Constants.encode("copy to " + quotePath(newPath)));
                byteArrayOutputStream.write(10);
            }
        } else if (diffEntry.getScore() > 0) {
            byteArrayOutputStream.write(Constants.encodeASCII("dissimilarity index " + (100 - diffEntry.getScore()) + "%"));
            byteArrayOutputStream.write(10);
        }
        if (diffEntry.getOldId() == null || diffEntry.getOldId().equals(diffEntry.getNewId())) {
            return;
        }
        formatIndexLine(byteArrayOutputStream, diffEntry);
    }

    protected void formatIndexLine(OutputStream outputStream, DiffEntry diffEntry) throws IOException {
        outputStream.write(Constants.encodeASCII("index " + format(diffEntry.getOldId()) + ".." + format(diffEntry.getNewId())));
        if (diffEntry.getOldMode().equals(diffEntry.getNewMode())) {
            outputStream.write(32);
            diffEntry.getNewMode().copyTo(outputStream);
        }
        outputStream.write(10);
    }

    private void formatOldNewPaths(ByteArrayOutputStream byteArrayOutputStream, DiffEntry diffEntry) throws IOException {
        String strQuotePath;
        if (diffEntry.oldId.equals(diffEntry.newId)) {
            return;
        }
        int i = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType()[diffEntry.getChangeType().ordinal()];
        String strQuotePath2 = DiffEntry.DEV_NULL;
        if (i == 1) {
            strQuotePath = quotePath(this.newPrefix + diffEntry.getNewPath());
        } else if (i == 3) {
            strQuotePath2 = quotePath(this.oldPrefix + diffEntry.getOldPath());
            strQuotePath = DiffEntry.DEV_NULL;
        } else {
            strQuotePath2 = quotePath(this.oldPrefix + diffEntry.getOldPath());
            strQuotePath = quotePath(this.newPrefix + diffEntry.getNewPath());
        }
        byteArrayOutputStream.write(Constants.encode("--- " + strQuotePath2 + "\n"));
        byteArrayOutputStream.write(Constants.encode("+++ " + strQuotePath + "\n"));
    }

    private int findCombinedEnd(List<Edit> list, int i) {
        while (true) {
            i++;
            if (i >= list.size() || (!combineA(list, i) && !combineB(list, i))) {
                break;
            }
        }
        return i - 1;
    }

    private boolean combineA(List<Edit> list, int i) {
        return list.get(i).getBeginA() - list.get(i - 1).getEndA() <= this.context * 2;
    }

    private boolean combineB(List<Edit> list, int i) {
        return list.get(i).getBeginB() - list.get(i - 1).getEndB() <= this.context * 2;
    }

    private static boolean end(Edit edit, int i, int i2) {
        return edit.getEndA() <= i && edit.getEndB() <= i2;
    }

    private String getFuncName(RawText rawText, int i, DiffDriver diffDriver) {
        if (diffDriver == null) {
            return null;
        }
        while (i > 0) {
            String string = rawText.getString(i);
            i--;
            if (!matchesAny(diffDriver.getNegatePatterns(), string) && matchesAny(diffDriver.getMatchPatterns(), string)) {
                String strReplaceAll = string.replaceAll("^[ \\t]+", "");
                return strReplaceAll.substring(0, Math.min(strReplaceAll.length(), 80)).trim();
            }
        }
        return null;
    }

    private boolean matchesAny(List<Pattern> list, String str) {
        if (list == null) {
            return false;
        }
        Iterator<Pattern> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    private DiffDriver getDiffDriver(DiffEntry diffEntry) {
        Attribute diffAttribute = diffEntry.getDiffAttribute();
        if (diffAttribute != null) {
            try {
                return DiffDriver.valueOf(diffAttribute.getValue());
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }
}
