package org.eclipse.jgit.api;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class CheckoutResult {
    public static final CheckoutResult ERROR_RESULT = new CheckoutResult(Status.ERROR, (List<String>) null);
    public static final CheckoutResult NOT_TRIED_RESULT = new CheckoutResult(Status.NOT_TRIED, (List<String>) null);
    private final List<String> conflictList;
    private final List<String> modifiedList;
    private final Status myStatus;
    private final List<String> removedList;
    private final List<String> undeletedList;

    public enum Status {
        NOT_TRIED,
        OK,
        CONFLICTS,
        NONDELETED,
        ERROR;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Status[] valuesCustom() {
            Status[] statusArrValuesCustom = values();
            int length = statusArrValuesCustom.length;
            Status[] statusArr = new Status[length];
            System.arraycopy(statusArrValuesCustom, 0, statusArr, 0, length);
            return statusArr;
        }
    }

    CheckoutResult(Status status, List<String> list) {
        this(status, list, null, null);
    }

    CheckoutResult(Status status, List<String> list, List<String> list2, List<String> list3) {
        this.myStatus = status;
        if (status == Status.CONFLICTS) {
            this.conflictList = list;
        } else {
            this.conflictList = new ArrayList(0);
        }
        if (status == Status.NONDELETED) {
            this.undeletedList = list;
        } else {
            this.undeletedList = new ArrayList(0);
        }
        this.modifiedList = list2;
        this.removedList = list3;
    }

    CheckoutResult(List<String> list, List<String> list2) {
        this.myStatus = Status.OK;
        this.conflictList = new ArrayList(0);
        this.undeletedList = new ArrayList(0);
        this.modifiedList = list;
        this.removedList = list2;
    }

    public Status getStatus() {
        return this.myStatus;
    }

    public List<String> getConflictList() {
        return this.conflictList;
    }

    public List<String> getUndeletedList() {
        return this.undeletedList;
    }

    public List<String> getModifiedList() {
        return this.modifiedList;
    }

    public List<String> getRemovedList() {
        return this.removedList;
    }
}
