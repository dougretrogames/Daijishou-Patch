package org.eclipse.jgit.revwalk;

/* JADX INFO: loaded from: classes5.dex */
public enum RevSort {
    NONE,
    COMMIT_TIME_DESC,
    TOPO,
    TOPO_KEEP_BRANCH_TOGETHER,
    REVERSE,
    BOUNDARY;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static RevSort[] valuesCustom() {
        RevSort[] revSortArrValuesCustom = values();
        int length = revSortArrValuesCustom.length;
        RevSort[] revSortArr = new RevSort[length];
        System.arraycopy(revSortArrValuesCustom, 0, revSortArr, 0, length);
        return revSortArr;
    }
}
