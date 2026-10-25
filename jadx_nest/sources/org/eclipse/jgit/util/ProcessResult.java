package org.eclipse.jgit.util;

/* JADX INFO: loaded from: classes5.dex */
public class ProcessResult {
    private final int exitCode;
    private final Status status;

    public enum Status {
        OK,
        NOT_PRESENT,
        NOT_SUPPORTED;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Status[] valuesCustom() {
            Status[] statusArrValuesCustom = values();
            int length = statusArrValuesCustom.length;
            Status[] statusArr = new Status[length];
            System.arraycopy(statusArrValuesCustom, 0, statusArr, 0, length);
            return statusArr;
        }
    }

    public ProcessResult(Status status) {
        this(-1, status);
    }

    public ProcessResult(int i, Status status) {
        this.exitCode = i;
        this.status = status;
    }

    public int getExitCode() {
        return this.exitCode;
    }

    public Status getStatus() {
        return this.status;
    }

    public boolean isExecutedWithError() {
        return getStatus() == Status.OK && getExitCode() != 0;
    }
}
