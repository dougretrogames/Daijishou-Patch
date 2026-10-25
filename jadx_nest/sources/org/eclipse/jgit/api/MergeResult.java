package org.eclipse.jgit.api;

import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.merge.MergeChunk;
import org.eclipse.jgit.merge.MergeStrategy;
import org.eclipse.jgit.merge.ResolveMerger;

/* JADX INFO: loaded from: classes5.dex */
public class MergeResult {
    private ObjectId base;
    private List<String> checkoutConflicts;
    private Map<String, int[][]> conflicts;
    private String description;
    private Map<String, ResolveMerger.MergeFailureReason> failingPaths;
    private MergeStatus mergeStatus;
    private MergeStrategy mergeStrategy;
    private ObjectId[] mergedCommits;
    private ObjectId newHead;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class MergeStatus {
        public static final MergeStatus ABORTED;
        public static final MergeStatus ALREADY_UP_TO_DATE;
        public static final MergeStatus CHECKOUT_CONFLICT;
        public static final MergeStatus CONFLICTING;
        private static final /* synthetic */ MergeStatus[] ENUM$VALUES;
        public static final MergeStatus FAILED;
        public static final MergeStatus FAST_FORWARD;
        public static final MergeStatus FAST_FORWARD_SQUASHED;
        public static final MergeStatus MERGED;
        public static final MergeStatus MERGED_NOT_COMMITTED;
        public static final MergeStatus MERGED_SQUASHED;
        public static final MergeStatus MERGED_SQUASHED_NOT_COMMITTED;
        public static final MergeStatus NOT_SUPPORTED;

        /* synthetic */ MergeStatus(String str, int i, MergeResultIA mergeResultIA) {
            this(str, i);
        }

        public static MergeStatus valueOf(String str) {
            return (MergeStatus) Enum.valueOf(MergeStatus.class, str);
        }

        public static MergeStatus[] values() {
            MergeStatus[] mergeStatusArr = ENUM$VALUES;
            int length = mergeStatusArr.length;
            MergeStatus[] mergeStatusArr2 = new MergeStatus[length];
            System.arraycopy(mergeStatusArr, 0, mergeStatusArr2, 0, length);
            return mergeStatusArr2;
        }

        public abstract boolean isSuccessful();

        private MergeStatus(String str, int i) {
            super(str, i);
        }

        static {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1("FAST_FORWARD", 0);
            FAST_FORWARD = anonymousClass1;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2("FAST_FORWARD_SQUASHED", 1);
            FAST_FORWARD_SQUASHED = anonymousClass2;
            AnonymousClass3 anonymousClass3 = new AnonymousClass3("ALREADY_UP_TO_DATE", 2);
            ALREADY_UP_TO_DATE = anonymousClass3;
            AnonymousClass4 anonymousClass4 = new AnonymousClass4("FAILED", 3);
            FAILED = anonymousClass4;
            AnonymousClass5 anonymousClass5 = new AnonymousClass5("MERGED", 4);
            MERGED = anonymousClass5;
            AnonymousClass6 anonymousClass6 = new AnonymousClass6("MERGED_SQUASHED", 5);
            MERGED_SQUASHED = anonymousClass6;
            AnonymousClass7 anonymousClass7 = new AnonymousClass7("MERGED_SQUASHED_NOT_COMMITTED", 6);
            MERGED_SQUASHED_NOT_COMMITTED = anonymousClass7;
            AnonymousClass8 anonymousClass8 = new AnonymousClass8("CONFLICTING", 7);
            CONFLICTING = anonymousClass8;
            AnonymousClass9 anonymousClass9 = new AnonymousClass9("ABORTED", 8);
            ABORTED = anonymousClass9;
            AnonymousClass10 anonymousClass10 = new AnonymousClass10("MERGED_NOT_COMMITTED", 9);
            MERGED_NOT_COMMITTED = anonymousClass10;
            AnonymousClass11 anonymousClass11 = new AnonymousClass11("NOT_SUPPORTED", 10);
            NOT_SUPPORTED = anonymousClass11;
            AnonymousClass12 anonymousClass12 = new AnonymousClass12("CHECKOUT_CONFLICT", 11);
            CHECKOUT_CONFLICT = anonymousClass12;
            ENUM$VALUES = new MergeStatus[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5, anonymousClass6, anonymousClass7, anonymousClass8, anonymousClass9, anonymousClass10, anonymousClass11, anonymousClass12};
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.api.MergeResult$MergeStatus$1, reason: invalid class name */
        final enum AnonymousClass1 extends MergeStatus {
            @Override // org.eclipse.jgit.api.MergeResult.MergeStatus
            public boolean isSuccessful() {
                return true;
            }

            AnonymousClass1(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Fast-forward";
            }
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.api.MergeResult$MergeStatus$2, reason: invalid class name */
        final enum AnonymousClass2 extends MergeStatus {
            @Override // org.eclipse.jgit.api.MergeResult.MergeStatus
            public boolean isSuccessful() {
                return true;
            }

            AnonymousClass2(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Fast-forward-squashed";
            }
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.api.MergeResult$MergeStatus$3, reason: invalid class name */
        final enum AnonymousClass3 extends MergeStatus {
            @Override // org.eclipse.jgit.api.MergeResult.MergeStatus
            public boolean isSuccessful() {
                return true;
            }

            AnonymousClass3(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Already-up-to-date";
            }
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.api.MergeResult$MergeStatus$4, reason: invalid class name */
        final enum AnonymousClass4 extends MergeStatus {
            @Override // org.eclipse.jgit.api.MergeResult.MergeStatus
            public boolean isSuccessful() {
                return false;
            }

            AnonymousClass4(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Failed";
            }
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.api.MergeResult$MergeStatus$5, reason: invalid class name */
        final enum AnonymousClass5 extends MergeStatus {
            @Override // org.eclipse.jgit.api.MergeResult.MergeStatus
            public boolean isSuccessful() {
                return true;
            }

            AnonymousClass5(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Merged";
            }
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.api.MergeResult$MergeStatus$6, reason: invalid class name */
        final enum AnonymousClass6 extends MergeStatus {
            @Override // org.eclipse.jgit.api.MergeResult.MergeStatus
            public boolean isSuccessful() {
                return true;
            }

            AnonymousClass6(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Merged-squashed";
            }
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.api.MergeResult$MergeStatus$7, reason: invalid class name */
        final enum AnonymousClass7 extends MergeStatus {
            @Override // org.eclipse.jgit.api.MergeResult.MergeStatus
            public boolean isSuccessful() {
                return true;
            }

            AnonymousClass7(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Merged-squashed-not-committed";
            }
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.api.MergeResult$MergeStatus$8, reason: invalid class name */
        final enum AnonymousClass8 extends MergeStatus {
            @Override // org.eclipse.jgit.api.MergeResult.MergeStatus
            public boolean isSuccessful() {
                return false;
            }

            AnonymousClass8(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Conflicting";
            }
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.api.MergeResult$MergeStatus$9, reason: invalid class name */
        final enum AnonymousClass9 extends MergeStatus {
            @Override // org.eclipse.jgit.api.MergeResult.MergeStatus
            public boolean isSuccessful() {
                return false;
            }

            AnonymousClass9(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Aborted";
            }
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.api.MergeResult$MergeStatus$10, reason: invalid class name */
        final enum AnonymousClass10 extends MergeStatus {
            @Override // org.eclipse.jgit.api.MergeResult.MergeStatus
            public boolean isSuccessful() {
                return true;
            }

            AnonymousClass10(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Merged-not-committed";
            }
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.api.MergeResult$MergeStatus$11, reason: invalid class name */
        final enum AnonymousClass11 extends MergeStatus {
            @Override // org.eclipse.jgit.api.MergeResult.MergeStatus
            public boolean isSuccessful() {
                return false;
            }

            AnonymousClass11(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Not-yet-supported";
            }
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.api.MergeResult$MergeStatus$12, reason: invalid class name */
        final enum AnonymousClass12 extends MergeStatus {
            @Override // org.eclipse.jgit.api.MergeResult.MergeStatus
            public boolean isSuccessful() {
                return false;
            }

            AnonymousClass12(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Checkout Conflict";
            }
        }
    }

    public MergeResult(ObjectId objectId, ObjectId objectId2, ObjectId[] objectIdArr, MergeStatus mergeStatus, MergeStrategy mergeStrategy, Map<String, org.eclipse.jgit.merge.MergeResult<?>> map) {
        this(objectId, objectId2, objectIdArr, mergeStatus, mergeStrategy, map, null);
    }

    public MergeResult(ObjectId objectId, ObjectId objectId2, ObjectId[] objectIdArr, MergeStatus mergeStatus, MergeStrategy mergeStrategy, Map<String, org.eclipse.jgit.merge.MergeResult<?>> map, String str) {
        this(objectId, objectId2, objectIdArr, mergeStatus, mergeStrategy, map, null, str);
    }

    public MergeResult(ObjectId objectId, ObjectId objectId2, ObjectId[] objectIdArr, MergeStatus mergeStatus, MergeStrategy mergeStrategy, Map<String, org.eclipse.jgit.merge.MergeResult<?>> map, Map<String, ResolveMerger.MergeFailureReason> map2, String str) {
        this.newHead = objectId;
        this.mergedCommits = objectIdArr;
        this.base = objectId2;
        this.mergeStatus = mergeStatus;
        this.mergeStrategy = mergeStrategy;
        this.description = str;
        this.failingPaths = map2;
        if (map != null) {
            for (Map.Entry<String, org.eclipse.jgit.merge.MergeResult<?>> entry : map.entrySet()) {
                addConflict(entry.getKey(), entry.getValue());
            }
        }
    }

    public MergeResult(List<String> list) {
        this.checkoutConflicts = list;
        this.mergeStatus = MergeStatus.CHECKOUT_CONFLICT;
    }

    public ObjectId getNewHead() {
        return this.newHead;
    }

    public MergeStatus getMergeStatus() {
        return this.mergeStatus;
    }

    public ObjectId[] getMergedCommits() {
        return this.mergedCommits;
    }

    public ObjectId getBase() {
        return this.base;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (ObjectId objectId : this.mergedCommits) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(ObjectId.toString(objectId));
        }
        String str = JGitText.get().mergeUsingStrategyResultedInDescription;
        String string = ObjectId.toString(this.base);
        String name = this.mergeStrategy.getName();
        MergeStatus mergeStatus = this.mergeStatus;
        String str2 = this.description;
        return MessageFormat.format(str, sb, string, name, mergeStatus, str2 == null ? "" : ", " + str2);
    }

    public void setConflicts(Map<String, int[][]> map) {
        this.conflicts = map;
    }

    public void addConflict(String str, int[][] iArr) {
        if (this.conflicts == null) {
            this.conflicts = new HashMap();
        }
        this.conflicts.put(str, iArr);
    }

    public void addConflict(String str, org.eclipse.jgit.merge.MergeResult<?> mergeResult) {
        int end;
        if (mergeResult.containsConflicts()) {
            if (this.conflicts == null) {
                this.conflicts = new HashMap();
            }
            Iterator<MergeChunk> it = mergeResult.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().getConflictState().equals(MergeChunk.ConflictState.FIRST_CONFLICTING_RANGE)) {
                    i++;
                }
            }
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i, this.mergedCommits.length + 1);
            int i2 = -1;
            for (MergeChunk mergeChunk : mergeResult) {
                if (mergeChunk.getConflictState().equals(MergeChunk.ConflictState.FIRST_CONFLICTING_RANGE)) {
                    if (i2 > -1) {
                        iArr[i2][this.mergedCommits.length] = 0;
                    }
                    i2++;
                    end = mergeChunk.getEnd();
                    iArr[i2][mergeChunk.getSequenceIndex()] = mergeChunk.getBegin();
                } else {
                    end = 0;
                }
                if (mergeChunk.getConflictState().equals(MergeChunk.ConflictState.NEXT_CONFLICTING_RANGE)) {
                    if (mergeChunk.getEnd() > end) {
                        mergeChunk.getEnd();
                    }
                    iArr[i2][mergeChunk.getSequenceIndex()] = mergeChunk.getBegin();
                }
            }
            this.conflicts.put(str, iArr);
        }
    }

    public Map<String, int[][]> getConflicts() {
        return this.conflicts;
    }

    public Map<String, ResolveMerger.MergeFailureReason> getFailingPaths() {
        return this.failingPaths;
    }

    public List<String> getCheckoutConflicts() {
        return this.checkoutConflicts;
    }
}
