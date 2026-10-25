package org.eclipse.jgit.submodule;

/* JADX INFO: loaded from: classes5.dex */
public enum SubmoduleStatusType {
    MISSING,
    UNINITIALIZED,
    INITIALIZED,
    REV_CHECKED_OUT;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static SubmoduleStatusType[] valuesCustom() {
        SubmoduleStatusType[] submoduleStatusTypeArrValuesCustom = values();
        int length = submoduleStatusTypeArrValuesCustom.length;
        SubmoduleStatusType[] submoduleStatusTypeArr = new SubmoduleStatusType[length];
        System.arraycopy(submoduleStatusTypeArrValuesCustom, 0, submoduleStatusTypeArr, 0, length);
        return submoduleStatusTypeArr;
    }
}
