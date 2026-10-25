package org.eclipse.jgit.diff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.attributes.Attribute;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.TreeFilter;
import org.eclipse.jgit.treewalk.filter.TreeFilterMarker;

/* JADX INFO: loaded from: classes5.dex */
public class DiffEntry {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType = null;
    static final AbbreviatedObjectId A_ZERO = AbbreviatedObjectId.fromObjectId(ObjectId.zeroId());
    public static final String DEV_NULL = "/dev/null";
    protected ChangeType changeType;
    protected Attribute diffAttribute;
    protected AbbreviatedObjectId newId;
    protected FileMode newMode;
    protected String newPath;
    protected AbbreviatedObjectId oldId;
    protected FileMode oldMode;
    protected String oldPath;
    protected int score;
    private int treeFilterMarks = 0;

    public enum ChangeType {
        ADD,
        MODIFY,
        DELETE,
        RENAME,
        COPY;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static ChangeType[] valuesCustom() {
            ChangeType[] changeTypeArrValuesCustom = values();
            int length = changeTypeArrValuesCustom.length;
            ChangeType[] changeTypeArr = new ChangeType[length];
            System.arraycopy(changeTypeArrValuesCustom, 0, changeTypeArr, 0, length);
            return changeTypeArr;
        }
    }

    public enum Side {
        OLD,
        NEW;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Side[] valuesCustom() {
            Side[] sideArrValuesCustom = values();
            int length = sideArrValuesCustom.length;
            Side[] sideArr = new Side[length];
            System.arraycopy(sideArrValuesCustom, 0, sideArr, 0, length);
            return sideArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[ChangeType.valuesCustom().length];
        try {
            iArr2[ChangeType.ADD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[ChangeType.COPY.ordinal()] = 5;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[ChangeType.DELETE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[ChangeType.MODIFY.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[ChangeType.RENAME.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType = iArr2;
        return iArr2;
    }

    protected DiffEntry() {
    }

    public static List<DiffEntry> scan(TreeWalk treeWalk) throws IOException {
        return scan(treeWalk, false);
    }

    public static List<DiffEntry> scan(TreeWalk treeWalk, boolean z) throws IOException {
        return scan(treeWalk, z, null);
    }

    public static List<DiffEntry> scan(TreeWalk treeWalk, boolean z, TreeFilter[] treeFilterArr) throws IOException {
        if (treeWalk.getTreeCount() != 2) {
            throw new IllegalArgumentException(JGitText.get().treeWalkMustHaveExactlyTwoTrees);
        }
        if (z && treeWalk.isRecursive()) {
            throw new IllegalArgumentException(JGitText.get().cannotBeRecursiveWhenTreesAreIncluded);
        }
        TreeFilterMarker treeFilterMarker = (treeFilterArr == null || treeFilterArr.length <= 0) ? null : new TreeFilterMarker(treeFilterArr);
        ArrayList arrayList = new ArrayList();
        MutableObjectId mutableObjectId = new MutableObjectId();
        while (treeWalk.next()) {
            DiffEntry diffEntry = new DiffEntry();
            treeWalk.getObjectId(mutableObjectId, 0);
            diffEntry.oldId = AbbreviatedObjectId.fromObjectId(mutableObjectId);
            treeWalk.getObjectId(mutableObjectId, 1);
            diffEntry.newId = AbbreviatedObjectId.fromObjectId(mutableObjectId);
            diffEntry.oldMode = treeWalk.getFileMode(0);
            diffEntry.newMode = treeWalk.getFileMode(1);
            String pathString = treeWalk.getPathString();
            diffEntry.oldPath = pathString;
            diffEntry.newPath = pathString;
            if (treeWalk.getAttributesNodeProvider() != null) {
                diffEntry.diffAttribute = treeWalk.getAttributes().get("diff");
            }
            if (treeFilterMarker != null) {
                diffEntry.treeFilterMarks = treeFilterMarker.getMarks(treeWalk);
            }
            if (diffEntry.oldMode == FileMode.MISSING) {
                diffEntry.oldPath = DEV_NULL;
                diffEntry.changeType = ChangeType.ADD;
                arrayList.add(diffEntry);
            } else if (diffEntry.newMode == FileMode.MISSING) {
                diffEntry.newPath = DEV_NULL;
                diffEntry.changeType = ChangeType.DELETE;
                arrayList.add(diffEntry);
            } else if (!diffEntry.oldId.equals(diffEntry.newId)) {
                diffEntry.changeType = ChangeType.MODIFY;
                if (RenameDetector.sameType(diffEntry.oldMode, diffEntry.newMode)) {
                    arrayList.add(diffEntry);
                } else {
                    arrayList.addAll(breakModify(diffEntry));
                }
            } else if (diffEntry.oldMode != diffEntry.newMode) {
                diffEntry.changeType = ChangeType.MODIFY;
                arrayList.add(diffEntry);
            }
            if (z && treeWalk.isSubtree()) {
                treeWalk.enterSubtree();
            }
        }
        return arrayList;
    }

    static DiffEntry add(String str, AnyObjectId anyObjectId) {
        DiffEntry diffEntry = new DiffEntry();
        diffEntry.oldId = A_ZERO;
        diffEntry.oldMode = FileMode.MISSING;
        diffEntry.oldPath = DEV_NULL;
        diffEntry.newId = AbbreviatedObjectId.fromObjectId(anyObjectId);
        diffEntry.newMode = FileMode.REGULAR_FILE;
        diffEntry.newPath = str;
        diffEntry.changeType = ChangeType.ADD;
        return diffEntry;
    }

    static DiffEntry delete(String str, AnyObjectId anyObjectId) {
        DiffEntry diffEntry = new DiffEntry();
        diffEntry.oldId = AbbreviatedObjectId.fromObjectId(anyObjectId);
        diffEntry.oldMode = FileMode.REGULAR_FILE;
        diffEntry.oldPath = str;
        diffEntry.newId = A_ZERO;
        diffEntry.newMode = FileMode.MISSING;
        diffEntry.newPath = DEV_NULL;
        diffEntry.changeType = ChangeType.DELETE;
        return diffEntry;
    }

    static DiffEntry modify(String str) {
        DiffEntry diffEntry = new DiffEntry();
        diffEntry.oldMode = FileMode.REGULAR_FILE;
        diffEntry.oldPath = str;
        diffEntry.newMode = FileMode.REGULAR_FILE;
        diffEntry.newPath = str;
        diffEntry.changeType = ChangeType.MODIFY;
        return diffEntry;
    }

    static List<DiffEntry> breakModify(DiffEntry diffEntry) {
        DiffEntry diffEntry2 = new DiffEntry();
        diffEntry2.oldId = diffEntry.getOldId();
        diffEntry2.oldMode = diffEntry.getOldMode();
        diffEntry2.oldPath = diffEntry.getOldPath();
        AbbreviatedObjectId abbreviatedObjectId = A_ZERO;
        diffEntry2.newId = abbreviatedObjectId;
        diffEntry2.newMode = FileMode.MISSING;
        diffEntry2.newPath = DEV_NULL;
        diffEntry2.changeType = ChangeType.DELETE;
        diffEntry2.diffAttribute = diffEntry.diffAttribute;
        DiffEntry diffEntry3 = new DiffEntry();
        diffEntry3.oldId = abbreviatedObjectId;
        diffEntry3.oldMode = FileMode.MISSING;
        diffEntry3.oldPath = DEV_NULL;
        diffEntry3.newId = diffEntry.getNewId();
        diffEntry3.newMode = diffEntry.getNewMode();
        diffEntry3.newPath = diffEntry.getNewPath();
        diffEntry3.changeType = ChangeType.ADD;
        diffEntry3.diffAttribute = diffEntry.diffAttribute;
        return Arrays.asList(diffEntry2, diffEntry3);
    }

    static DiffEntry pair(ChangeType changeType, DiffEntry diffEntry, DiffEntry diffEntry2, int i) {
        DiffEntry diffEntry3 = new DiffEntry();
        diffEntry3.oldId = diffEntry.oldId;
        diffEntry3.oldMode = diffEntry.oldMode;
        diffEntry3.oldPath = diffEntry.oldPath;
        diffEntry3.newId = diffEntry2.newId;
        diffEntry3.newMode = diffEntry2.newMode;
        diffEntry3.newPath = diffEntry2.newPath;
        diffEntry3.diffAttribute = diffEntry2.diffAttribute;
        diffEntry3.changeType = changeType;
        diffEntry3.score = i;
        diffEntry3.treeFilterMarks = diffEntry.treeFilterMarks | diffEntry2.treeFilterMarks;
        return diffEntry3;
    }

    public String getOldPath() {
        return this.oldPath;
    }

    public String getNewPath() {
        return this.newPath;
    }

    public String getPath(Side side) {
        return side == Side.OLD ? getOldPath() : getNewPath();
    }

    public Attribute getDiffAttribute() {
        return this.diffAttribute;
    }

    public FileMode getOldMode() {
        return this.oldMode;
    }

    public FileMode getNewMode() {
        return this.newMode;
    }

    public FileMode getMode(Side side) {
        return side == Side.OLD ? getOldMode() : getNewMode();
    }

    public ChangeType getChangeType() {
        return this.changeType;
    }

    public int getScore() {
        return this.score;
    }

    public AbbreviatedObjectId getOldId() {
        return this.oldId;
    }

    public AbbreviatedObjectId getNewId() {
        return this.newId;
    }

    public boolean isMarked(int i) {
        return (((long) this.treeFilterMarks) & (1 << i)) != 0;
    }

    public int getTreeFilterMarks() {
        return this.treeFilterMarks;
    }

    public AbbreviatedObjectId getId(Side side) {
        return side == Side.OLD ? getOldId() : getNewId();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DiffEntry[");
        sb.append(this.changeType);
        sb.append(" ");
        int i = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$ChangeType()[this.changeType.ordinal()];
        if (i == 1) {
            sb.append(this.newPath);
        } else if (i == 2 || i == 3) {
            sb.append(this.oldPath);
        } else if (i == 4) {
            sb.append(this.oldPath + "->" + this.newPath);
        } else if (i == 5) {
            sb.append(this.oldPath + "->" + this.newPath);
        }
        sb.append(CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
        return sb.toString();
    }
}
