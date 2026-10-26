package org.eclipse.jgit.lib;

import org.eclipse.jgit.internal.JGitText;

/* WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* WARN: Unknown enum class pattern. Please report as an issue! */
/* INFO: loaded from: classes5.dex */
public abstract class RepositoryState {
    public static final RepositoryState APPLY;
    public static final RepositoryState BARE;
    public static final RepositoryState BISECTING;
    public static final RepositoryState CHERRY_PICKING;
    public static final RepositoryState CHERRY_PICKING_RESOLVED;
    private static final /* synthetic */ RepositoryState[] ENUM$VALUES;
    public static final RepositoryState MERGING;
    public static final RepositoryState MERGING_RESOLVED;
    public static final RepositoryState REBASING;
    public static final RepositoryState REBASING_INTERACTIVE;
    public static final RepositoryState REBASING_MERGE;
    public static final RepositoryState REBASING_REBASING;
    public static final RepositoryState REVERTING;
    public static final RepositoryState REVERTING_RESOLVED;
    public static final RepositoryState SAFE;

    /* synthetic */ RepositoryState(String str, int i, RepositoryStateIA repositoryStateIA) {
        this(str, i);
    }

    public static RepositoryState valueOf(String str) {
        return (RepositoryState) Enum.valueOf(RepositoryState.class, str);
    }

    public static RepositoryState[] values() {
        RepositoryState[] repositoryStateArr = ENUM$VALUES;
        int length = repositoryStateArr.length;
        RepositoryState[] repositoryStateArr2 = new RepositoryState[length];
        System.arraycopy(repositoryStateArr, 0, repositoryStateArr2, 0, length);
        return repositoryStateArr2;
    }

    public abstract boolean canAmend();

    public abstract boolean canCheckout();

    public abstract boolean canCommit();

    public abstract boolean canResetHead();

    public abstract String getDescription();

    public abstract boolean isRebasing();

    private RepositoryState(String str, int i) {
        super(str, i);
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.RepositoryState$1, reason: invalid class name */
    final enum AnonymousClass1 extends RepositoryState {
        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canAmend() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCheckout() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCommit() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canResetHead() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean isRebasing() {
            return false;
        }

        AnonymousClass1(String str, int i) {
            super(str, i, null);
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public String getDescription() {
            return JGitText.get().repositoryState_bare;
        }
    }

    static {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1("BARE", 0);
        BARE = anonymousClass1;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2("SAFE", 1);
        SAFE = anonymousClass2;
        AnonymousClass3 anonymousClass3 = new AnonymousClass3("MERGING", 2);
        MERGING = anonymousClass3;
        AnonymousClass4 anonymousClass4 = new AnonymousClass4("MERGING_RESOLVED", 3);
        MERGING_RESOLVED = anonymousClass4;
        AnonymousClass5 anonymousClass5 = new AnonymousClass5("CHERRY_PICKING", 4);
        CHERRY_PICKING = anonymousClass5;
        AnonymousClass6 anonymousClass6 = new AnonymousClass6("CHERRY_PICKING_RESOLVED", 5);
        CHERRY_PICKING_RESOLVED = anonymousClass6;
        AnonymousClass7 anonymousClass7 = new AnonymousClass7("REVERTING", 6);
        REVERTING = anonymousClass7;
        AnonymousClass8 anonymousClass8 = new AnonymousClass8("REVERTING_RESOLVED", 7);
        REVERTING_RESOLVED = anonymousClass8;
        AnonymousClass9 anonymousClass9 = new AnonymousClass9("REBASING", 8);
        REBASING = anonymousClass9;
        AnonymousClass10 anonymousClass10 = new AnonymousClass10("REBASING_REBASING", 9);
        REBASING_REBASING = anonymousClass10;
        AnonymousClass11 anonymousClass11 = new AnonymousClass11("APPLY", 10);
        APPLY = anonymousClass11;
        AnonymousClass12 anonymousClass12 = new AnonymousClass12("REBASING_MERGE", 11);
        REBASING_MERGE = anonymousClass12;
        AnonymousClass13 anonymousClass13 = new AnonymousClass13("REBASING_INTERACTIVE", 12);
        REBASING_INTERACTIVE = anonymousClass13;
        AnonymousClass14 anonymousClass14 = new AnonymousClass14("BISECTING", 13);
        BISECTING = anonymousClass14;
        ENUM$VALUES = new RepositoryState[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5, anonymousClass6, anonymousClass7, anonymousClass8, anonymousClass9, anonymousClass10, anonymousClass11, anonymousClass12, anonymousClass13, anonymousClass14};
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.RepositoryState$2, reason: invalid class name */
    final enum AnonymousClass2 extends RepositoryState {
        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canAmend() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCheckout() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCommit() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canResetHead() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean isRebasing() {
            return false;
        }

        AnonymousClass2(String str, int i) {
            super(str, i, null);
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public String getDescription() {
            return JGitText.get().repositoryState_normal;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.RepositoryState$3, reason: invalid class name */
    final enum AnonymousClass3 extends RepositoryState {
        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canAmend() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCheckout() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCommit() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canResetHead() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean isRebasing() {
            return false;
        }

        AnonymousClass3(String str, int i) {
            super(str, i, null);
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public String getDescription() {
            return JGitText.get().repositoryState_conflicts;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.RepositoryState$4, reason: invalid class name */
    final enum AnonymousClass4 extends RepositoryState {
        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canAmend() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCheckout() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCommit() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canResetHead() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean isRebasing() {
            return false;
        }

        AnonymousClass4(String str, int i) {
            super(str, i, null);
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public String getDescription() {
            return JGitText.get().repositoryState_merged;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.RepositoryState$5, reason: invalid class name */
    final enum AnonymousClass5 extends RepositoryState {
        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canAmend() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCheckout() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCommit() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canResetHead() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean isRebasing() {
            return false;
        }

        AnonymousClass5(String str, int i) {
            super(str, i, null);
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public String getDescription() {
            return JGitText.get().repositoryState_conflicts;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.RepositoryState$6, reason: invalid class name */
    final enum AnonymousClass6 extends RepositoryState {
        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canAmend() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCheckout() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCommit() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canResetHead() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean isRebasing() {
            return false;
        }

        AnonymousClass6(String str, int i) {
            super(str, i, null);
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public String getDescription() {
            return JGitText.get().repositoryState_merged;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.RepositoryState$7, reason: invalid class name */
    final enum AnonymousClass7 extends RepositoryState {
        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canAmend() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCheckout() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCommit() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canResetHead() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean isRebasing() {
            return false;
        }

        AnonymousClass7(String str, int i) {
            super(str, i, null);
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public String getDescription() {
            return JGitText.get().repositoryState_conflicts;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.RepositoryState$8, reason: invalid class name */
    final enum AnonymousClass8 extends RepositoryState {
        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canAmend() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCheckout() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCommit() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canResetHead() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean isRebasing() {
            return false;
        }

        AnonymousClass8(String str, int i) {
            super(str, i, null);
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public String getDescription() {
            return JGitText.get().repositoryState_merged;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.RepositoryState$9, reason: invalid class name */
    final enum AnonymousClass9 extends RepositoryState {
        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canAmend() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCheckout() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCommit() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canResetHead() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean isRebasing() {
            return true;
        }

        AnonymousClass9(String str, int i) {
            super(str, i, null);
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public String getDescription() {
            return JGitText.get().repositoryState_rebaseOrApplyMailbox;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.RepositoryState$10, reason: invalid class name */
    final enum AnonymousClass10 extends RepositoryState {
        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canAmend() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCheckout() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCommit() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canResetHead() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean isRebasing() {
            return true;
        }

        AnonymousClass10(String str, int i) {
            super(str, i, null);
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public String getDescription() {
            return JGitText.get().repositoryState_rebase;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.RepositoryState$11, reason: invalid class name */
    final enum AnonymousClass11 extends RepositoryState {
        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canAmend() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCheckout() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCommit() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canResetHead() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean isRebasing() {
            return false;
        }

        AnonymousClass11(String str, int i) {
            super(str, i, null);
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public String getDescription() {
            return JGitText.get().repositoryState_applyMailbox;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.RepositoryState$12, reason: invalid class name */
    final enum AnonymousClass12 extends RepositoryState {
        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canAmend() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCheckout() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCommit() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canResetHead() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean isRebasing() {
            return true;
        }

        AnonymousClass12(String str, int i) {
            super(str, i, null);
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public String getDescription() {
            return JGitText.get().repositoryState_rebaseWithMerge;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.RepositoryState$13, reason: invalid class name */
    final enum AnonymousClass13 extends RepositoryState {
        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canAmend() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCheckout() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCommit() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canResetHead() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean isRebasing() {
            return true;
        }

        AnonymousClass13(String str, int i) {
            super(str, i, null);
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public String getDescription() {
            return JGitText.get().repositoryState_rebaseInteractive;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.RepositoryState$14, reason: invalid class name */
    final enum AnonymousClass14 extends RepositoryState {
        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canAmend() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCheckout() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canCommit() {
            return true;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean canResetHead() {
            return false;
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public boolean isRebasing() {
            return false;
        }

        AnonymousClass14(String str, int i) {
            super(str, i, null);
        }

        @Override // org.eclipse.jgit.lib.RepositoryState
        public String getDescription() {
            return JGitText.get().repositoryState_bisecting;
        }
    }
}
