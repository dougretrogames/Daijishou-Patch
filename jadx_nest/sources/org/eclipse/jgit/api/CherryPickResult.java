package org.eclipse.jgit.api;

import java.util.List;
import java.util.Map;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.merge.ResolveMerger;
import org.eclipse.jgit.revwalk.RevCommit;

/* JADX INFO: loaded from: classes5.dex */
public class CherryPickResult {
    public static final CherryPickResult CONFLICT = new CherryPickResult(CherryPickStatus.CONFLICTING);
    private final List<Ref> cherryPickedRefs;
    private final Map<String, ResolveMerger.MergeFailureReason> failingPaths;
    private final RevCommit newHead;
    private final CherryPickStatus status;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static class CherryPickStatus {
        public static final CherryPickStatus CONFLICTING;
        private static final /* synthetic */ CherryPickStatus[] ENUM$VALUES;
        public static final CherryPickStatus FAILED;
        public static final CherryPickStatus OK;

        /* synthetic */ CherryPickStatus(String str, int i, CherryPickResultIA cherryPickResultIA) {
            this(str, i);
        }

        public static CherryPickStatus valueOf(String str) {
            return (CherryPickStatus) Enum.valueOf(CherryPickStatus.class, str);
        }

        public static CherryPickStatus[] values() {
            CherryPickStatus[] cherryPickStatusArr = ENUM$VALUES;
            int length = cherryPickStatusArr.length;
            CherryPickStatus[] cherryPickStatusArr2 = new CherryPickStatus[length];
            System.arraycopy(cherryPickStatusArr, 0, cherryPickStatusArr2, 0, length);
            return cherryPickStatusArr2;
        }

        private CherryPickStatus(String str, int i) {
            super(str, i);
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.api.CherryPickResult$CherryPickStatus$1, reason: invalid class name */
        final enum AnonymousClass1 extends CherryPickStatus {
            AnonymousClass1(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Ok";
            }
        }

        static {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1("OK", 0);
            OK = anonymousClass1;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2("FAILED", 1);
            FAILED = anonymousClass2;
            AnonymousClass3 anonymousClass3 = new AnonymousClass3("CONFLICTING", 2);
            CONFLICTING = anonymousClass3;
            ENUM$VALUES = new CherryPickStatus[]{anonymousClass1, anonymousClass2, anonymousClass3};
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.api.CherryPickResult$CherryPickStatus$2, reason: invalid class name */
        final enum AnonymousClass2 extends CherryPickStatus {
            AnonymousClass2(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Failed";
            }
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.api.CherryPickResult$CherryPickStatus$3, reason: invalid class name */
        final enum AnonymousClass3 extends CherryPickStatus {
            AnonymousClass3(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Conflicting";
            }
        }
    }

    public CherryPickResult(RevCommit revCommit, List<Ref> list) {
        this.status = CherryPickStatus.OK;
        this.newHead = revCommit;
        this.cherryPickedRefs = list;
        this.failingPaths = null;
    }

    public CherryPickResult(Map<String, ResolveMerger.MergeFailureReason> map) {
        this.status = CherryPickStatus.FAILED;
        this.newHead = null;
        this.cherryPickedRefs = null;
        this.failingPaths = map;
    }

    private CherryPickResult(CherryPickStatus cherryPickStatus) {
        this.status = cherryPickStatus;
        this.newHead = null;
        this.cherryPickedRefs = null;
        this.failingPaths = null;
    }

    public CherryPickStatus getStatus() {
        return this.status;
    }

    public RevCommit getNewHead() {
        return this.newHead;
    }

    public List<Ref> getCherryPickedRefs() {
        return this.cherryPickedRefs;
    }

    public Map<String, ResolveMerger.MergeFailureReason> getFailingPaths() {
        return this.failingPaths;
    }
}
