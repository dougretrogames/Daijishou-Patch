package org.eclipse.jgit.lib.internal;

/* INFO: loaded from: classes5.dex */
public enum BooleanTriState {
    TRUE,
    FALSE,
    UNSET;

    /* INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static BooleanTriState[] valuesCustom() {
        BooleanTriState[] booleanTriStateArrValuesCustom = values();
        int length = booleanTriStateArrValuesCustom.length;
        BooleanTriState[] booleanTriStateArr = new BooleanTriState[length];
        System.arraycopy(booleanTriStateArrValuesCustom, 0, booleanTriStateArr, 0, length);
        return booleanTriStateArr;
    }
}
