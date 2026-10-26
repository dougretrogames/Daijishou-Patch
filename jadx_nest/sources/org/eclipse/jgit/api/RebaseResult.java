package org.eclipse.jgit.api;

import java.util.List;
import java.util.Map;
import org.eclipse.jgit.merge.ResolveMerger;
import org.eclipse.jgit.revwalk.RevCommit;

/* INFO: loaded from: classes5.dex */
public class RebaseResult {
    private List<String> conflicts;
    private final RevCommit currentCommit;
    private Map<String, ResolveMerger.MergeFailureReason> failingPaths;
    private final Status status;
    private List<String> uncommittedChanges;
    static final RebaseResult OK_RESULT = new RebaseResult(Status.OK);
    static final RebaseResult ABORTED_RESULT = new RebaseResult(Status.ABORTED);
    static final RebaseResult UP_TO_DATE_RESULT = new RebaseResult(Status.UP_TO_DATE);
    static final RebaseResult FAST_FORWARD_RESULT = new RebaseResult(Status.FAST_FORWARD);
    static final RebaseResult NOTHING_TO_COMMIT_RESULT = new RebaseResult(Status.NOTHING_TO_COMMIT);
    static final RebaseResult INTERACTIVE_PREPARED_RESULT = new RebaseResult(Status.INTERACTIVE_PREPARED);
    static final RebaseResult STASH_APPLY_CONFLICTS_RESULT = new RebaseResult(Status.STASH_APPLY_CONFLICTS);

    /* WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class Status {
        public static final Status ABORTED;
        public static final Status CONFLICTS;
        public static final Status EDIT;
        private static final /* synthetic */ Status[] ENUM$VALUES;
        public static final Status FAILED;
        public static final Status FAST_FORWARD;
        public static final Status INTERACTIVE_PREPARED;
        public static final Status NOTHING_TO_COMMIT;
        public static final Status OK;
        public static final Status STASH_APPLY_CONFLICTS;
        public static final Status STOPPED;
        public static final Status UNCOMMITTED_CHANGES;
        public static final Status UP_TO_DATE;

        /* synthetic */ Status(String str, int i, RebaseResultIA rebaseResultIA) {
            this(str, i);
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            Status[] statusArr = ENUM$VALUES;
            int length = statusArr.length;
            Status[] statusArr2 = new Status[length];
            System.arraycopy(statusArr, 0, statusArr2, 0, length);
            return statusArr2;
        }

        public abstract boolean isSuccessful();

        private Status(String str, int i) {
            super(str, i);
        }

        static {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1("OK", 0);
            OK = anonymousClass1;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2("ABORTED", 1);
            ABORTED = anonymousClass2;
            AnonymousClass3 anonymousClass3 = new AnonymousClass3("STOPPED", 2);
            STOPPED = anonymousClass3;
            AnonymousClass4 anonymousClass4 = new AnonymousClass4("EDIT", 3);
            EDIT = anonymousClass4;
            AnonymousClass5 anonymousClass5 = new AnonymousClass5("FAILED", 4);
            FAILED = anonymousClass5;
            AnonymousClass6 anonymousClass6 = new AnonymousClass6("UNCOMMITTED_CHANGES", 5);
            UNCOMMITTED_CHANGES = anonymousClass6;
            AnonymousClass7 anonymousClass7 = new AnonymousClass7("CONFLICTS", 6);
            CONFLICTS = anonymousClass7;
            AnonymousClass8 anonymousClass8 = new AnonymousClass8("UP_TO_DATE", 7);
            UP_TO_DATE = anonymousClass8;
            AnonymousClass9 anonymousClass9 = new AnonymousClass9("FAST_FORWARD", 8);
            FAST_FORWARD = anonymousClass9;
            AnonymousClass10 anonymousClass10 = new AnonymousClass10("NOTHING_TO_COMMIT", 9);
            NOTHING_TO_COMMIT = anonymousClass10;
            AnonymousClass11 anonymousClass11 = new AnonymousClass11("INTERACTIVE_PREPARED", 10);
            INTERACTIVE_PREPARED = anonymousClass11;
            AnonymousClass12 anonymousClass12 = new AnonymousClass12("STASH_APPLY_CONFLICTS", 11);
            STASH_APPLY_CONFLICTS = anonymousClass12;
            ENUM$VALUES = new Status[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5, anonymousClass6, anonymousClass7, anonymousClass8, anonymousClass9, anonymousClass10, anonymousClass11, anonymousClass12};
        }

        /* INFO: renamed from: org.eclipse.jgit.api.RebaseResult$Status$1, reason: invalid class name */
        final enum AnonymousClass1 extends Status {
            @Override // org.eclipse.jgit.api.RebaseResult.Status
            public boolean isSuccessful() {
                return true;
            }

            AnonymousClass1(String str, int i) {
                super(str, i, null);
            }
        }

        /* INFO: renamed from: org.eclipse.jgit.api.RebaseResult$Status$2, reason: invalid class name */
        final enum AnonymousClass2 extends Status {
            @Override // org.eclipse.jgit.api.RebaseResult.Status
            public boolean isSuccessful() {
                return false;
            }

            AnonymousClass2(String str, int i) {
                super(str, i, null);
            }
        }

        /* INFO: renamed from: org.eclipse.jgit.api.RebaseResult$Status$3, reason: invalid class name */
        final enum AnonymousClass3 extends Status {
            @Override // org.eclipse.jgit.api.RebaseResult.Status
            public boolean isSuccessful() {
                return false;
            }

            AnonymousClass3(String str, int i) {
                super(str, i, null);
            }
        }

        /* INFO: renamed from: org.eclipse.jgit.api.RebaseResult$Status$4, reason: invalid class name */
        final enum AnonymousClass4 extends Status {
            @Override // org.eclipse.jgit.api.RebaseResult.Status
            public boolean isSuccessful() {
                return false;
            }

            AnonymousClass4(String str, int i) {
                super(str, i, null);
            }
        }

        /* INFO: renamed from: org.eclipse.jgit.api.RebaseResult$Status$5, reason: invalid class name */
        final enum AnonymousClass5 extends Status {
            @Override // org.eclipse.jgit.api.RebaseResult.Status
            public boolean isSuccessful() {
                return false;
            }

            AnonymousClass5(String str, int i) {
                super(str, i, null);
            }
        }

        /* INFO: renamed from: org.eclipse.jgit.api.RebaseResult$Status$6, reason: invalid class name */
        final enum AnonymousClass6 extends Status {
            @Override // org.eclipse.jgit.api.RebaseResult.Status
            public boolean isSuccessful() {
                return false;
            }

            AnonymousClass6(String str, int i) {
                super(str, i, null);
            }
        }

        /* INFO: renamed from: org.eclipse.jgit.api.RebaseResult$Status$7, reason: invalid class name */
        final enum AnonymousClass7 extends Status {
            @Override // org.eclipse.jgit.api.RebaseResult.Status
            public boolean isSuccessful() {
                return false;
            }

            AnonymousClass7(String str, int i) {
                super(str, i, null);
            }
        }

        /* INFO: renamed from: org.eclipse.jgit.api.RebaseResult$Status$8, reason: invalid class name */
        final enum AnonymousClass8 extends Status {
            @Override // org.eclipse.jgit.api.RebaseResult.Status
            public boolean isSuccessful() {
                return true;
            }

            AnonymousClass8(String str, int i) {
                super(str, i, null);
            }
        }

        /* INFO: renamed from: org.eclipse.jgit.api.RebaseResult$Status$9, reason: invalid class name */
        final enum AnonymousClass9 extends Status {
            @Override // org.eclipse.jgit.api.RebaseResult.Status
            public boolean isSuccessful() {
                return true;
            }

            AnonymousClass9(String str, int i) {
                super(str, i, null);
            }
        }

        /* INFO: renamed from: org.eclipse.jgit.api.RebaseResult$Status$10, reason: invalid class name */
        final enum AnonymousClass10 extends Status {
            @Override // org.eclipse.jgit.api.RebaseResult.Status
            public boolean isSuccessful() {
                return false;
            }

            AnonymousClass10(String str, int i) {
                super(str, i, null);
            }
        }

        /* INFO: renamed from: org.eclipse.jgit.api.RebaseResult$Status$11, reason: invalid class name */
        final enum AnonymousClass11 extends Status {
            @Override // org.eclipse.jgit.api.RebaseResult.Status
            public boolean isSuccessful() {
                return false;
            }

            AnonymousClass11(String str, int i) {
                super(str, i, null);
            }
        }

        /* INFO: renamed from: org.eclipse.jgit.api.RebaseResult$Status$12, reason: invalid class name */
        final enum AnonymousClass12 extends Status {
            @Override // org.eclipse.jgit.api.RebaseResult.Status
            public boolean isSuccessful() {
                return true;
            }

            AnonymousClass12(String str, int i) {
                super(str, i, null);
            }
        }
    }

    private RebaseResult(Status status) {
        this.status = status;
        this.currentCommit = null;
    }

    private RebaseResult(Status status, RevCommit revCommit) {
        this.status = status;
        this.currentCommit = revCommit;
    }

    static RebaseResult result(Status status, RevCommit revCommit) {
        return new RebaseResult(status, revCommit);
    }

    static RebaseResult failed(Map<String, ResolveMerger.MergeFailureReason> map) {
        RebaseResult rebaseResult = new RebaseResult(Status.FAILED);
        rebaseResult.failingPaths = map;
        return rebaseResult;
    }

    static RebaseResult conflicts(List<String> list) {
        RebaseResult rebaseResult = new RebaseResult(Status.CONFLICTS);
        rebaseResult.conflicts = list;
        return rebaseResult;
    }

    static RebaseResult uncommittedChanges(List<String> list) {
        RebaseResult rebaseResult = new RebaseResult(Status.UNCOMMITTED_CHANGES);
        rebaseResult.uncommittedChanges = list;
        return rebaseResult;
    }

    public Status getStatus() {
        return this.status;
    }

    public RevCommit getCurrentCommit() {
        return this.currentCommit;
    }

    public Map<String, ResolveMerger.MergeFailureReason> getFailingPaths() {
        return this.failingPaths;
    }

    public List<String> getConflicts() {
        return this.conflicts;
    }

    public List<String> getUncommittedChanges() {
        return this.uncommittedChanges;
    }
}
