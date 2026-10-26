package org.eclipse.jgit.revwalk.filter;

import java.io.IOException;
import kotlin.text.Typography;
import org.apache.commons.codec.language.bm.Rule;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.jgit.errors.StopWalkException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
public abstract class RevFilter {
    public static final RevFilter ALL = new AllFilter(null);
    public static final RevFilter NONE = new NoneFilter(null);
    public static final RevFilter ONLY_MERGES = new OnlyMergesFilter(null);
    public static final RevFilter NO_MERGES = new NoMergesFilter(null);
    public static final RevFilter MERGE_BASE = new MergeBaseFilter(null);

    @Override // 
    public abstract RevFilter clone();

    public abstract boolean include(RevWalk revWalk, RevCommit revCommit) throws IOException, StopWalkException;

    public boolean requiresCommitBody() {
        return true;
    }

    private static final class AllFilter extends RevFilter {
        /* synthetic */ AllFilter(RevFilterIA revFilterIA) {
            this();
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public RevFilter clone() {
            return this;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean include(RevWalk revWalk, RevCommit revCommit) {
            return true;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean requiresCommitBody() {
            return false;
        }

        private AllFilter() {
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public String toString() {
            return Rule.ALL;
        }
    }

    private static final class NoneFilter extends RevFilter {
        /* synthetic */ NoneFilter(RevFilterIA revFilterIA) {
            this();
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public RevFilter clone() {
            return this;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean include(RevWalk revWalk, RevCommit revCommit) {
            return false;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean requiresCommitBody() {
            return false;
        }

        private NoneFilter() {
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public String toString() {
            return "NONE";
        }
    }

    private static final class OnlyMergesFilter extends RevFilter {
        /* synthetic */ OnlyMergesFilter(RevFilterIA revFilterIA) {
            this();
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public RevFilter clone() {
            return this;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean requiresCommitBody() {
            return false;
        }

        private OnlyMergesFilter() {
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean include(RevWalk revWalk, RevCommit revCommit) {
            return revCommit.getParentCount() >= 2;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public String toString() {
            return "ONLY_MERGES";
        }
    }

    private static final class NoMergesFilter extends RevFilter {
        /* synthetic */ NoMergesFilter(RevFilterIA revFilterIA) {
            this();
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public RevFilter clone() {
            return this;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean requiresCommitBody() {
            return false;
        }

        private NoMergesFilter() {
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean include(RevWalk revWalk, RevCommit revCommit) {
            return revCommit.getParentCount() < 2;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public String toString() {
            return "NO_MERGES";
        }
    }

    private static final class MergeBaseFilter extends RevFilter {
        /* synthetic */ MergeBaseFilter(RevFilterIA revFilterIA) {
            this();
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public RevFilter clone() {
            return this;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean requiresCommitBody() {
            return false;
        }

        private MergeBaseFilter() {
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean include(RevWalk revWalk, RevCommit revCommit) {
            throw new UnsupportedOperationException(JGitText.get().cannotBeCombined);
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public String toString() {
            return "MERGE_BASE";
        }
    }

    public RevFilter negate() {
        return NotRevFilter.create(this);
    }

    public String toString() {
        String name = getClass().getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            name = name.substring(iLastIndexOf + 1);
        }
        return name.replace(Typography.dollar, FilenameUtils.EXTENSION_SEPARATOR);
    }
}
