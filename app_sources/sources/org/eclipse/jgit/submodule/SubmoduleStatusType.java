package org.eclipse.jgit.submodule;

/* INFO: loaded from: classes5.dex */
public enum SubmoduleStatusType {
    MISSING,
    UNINITIALIZED,
    INITIALIZED,
    REV_CHECKED_OUT;

    /* INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static SubmoduleStatusType[] valuesCustom() {
        SubmoduleStatusType[] submoduleStatusTypeArrValuesCustom = values();
        int length = submoduleStatusTypeArrValuesCustom.length;
        SubmoduleStatusType[] submoduleStatusTypeArr = new SubmoduleStatusType[length];
        System.arraycopy(submoduleStatusTypeArrValuesCustom, 0, submoduleStatusTypeArr, 0, length);
        return submoduleStatusTypeArr;
    }
}
