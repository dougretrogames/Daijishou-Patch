package org.eclipse.jgit.errors;

import org.eclipse.jgit.annotations.Nullable;

/* INFO: loaded from: classes5.dex */
public class CorruptPackIndexException extends Exception {
    private static final long serialVersionUID = 1;
    private ErrorType errorType;

    public enum ErrorType {
        MISMATCH_OFFSET,
        MISMATCH_CRC,
        MISSING_CRC,
        MISSING_OBJ,
        UNKNOWN_OBJ;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static ErrorType[] valuesCustom() {
            ErrorType[] errorTypeArrValuesCustom = values();
            int length = errorTypeArrValuesCustom.length;
            ErrorType[] errorTypeArr = new ErrorType[length];
            System.arraycopy(errorTypeArrValuesCustom, 0, errorTypeArr, 0, length);
            return errorTypeArr;
        }
    }

    public CorruptPackIndexException(String str, ErrorType errorType) {
        super(str);
        this.errorType = errorType;
    }

    @Nullable
    public ErrorType getErrorType() {
        return this.errorType;
    }
}
