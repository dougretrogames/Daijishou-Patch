package org.eclipse.jgit.errors;

import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class NoMergeBaseException extends IOException {
    private static final long serialVersionUID = 1;
    private MergeBaseFailureReason reason;

    public enum MergeBaseFailureReason {
        MULTIPLE_MERGE_BASES_NOT_SUPPORTED,
        TOO_MANY_MERGE_BASES,
        CONFLICTS_DURING_MERGE_BASE_CALCULATION;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static MergeBaseFailureReason[] valuesCustom() {
            MergeBaseFailureReason[] mergeBaseFailureReasonArrValuesCustom = values();
            int length = mergeBaseFailureReasonArrValuesCustom.length;
            MergeBaseFailureReason[] mergeBaseFailureReasonArr = new MergeBaseFailureReason[length];
            System.arraycopy(mergeBaseFailureReasonArrValuesCustom, 0, mergeBaseFailureReasonArr, 0, length);
            return mergeBaseFailureReasonArr;
        }
    }

    public NoMergeBaseException(MergeBaseFailureReason mergeBaseFailureReason, String str) {
        super(MessageFormat.format(JGitText.get().noMergeBase, mergeBaseFailureReason.toString(), str));
        this.reason = mergeBaseFailureReason;
    }

    public NoMergeBaseException(MergeBaseFailureReason mergeBaseFailureReason, String str, Throwable th) {
        super(MessageFormat.format(JGitText.get().noMergeBase, mergeBaseFailureReason.toString(), str));
        this.reason = mergeBaseFailureReason;
        initCause(th);
    }

    public MergeBaseFailureReason getReason() {
        return this.reason;
    }
}
