package org.eclipse.jgit.revwalk.filter;

import kotlin.text.Typography;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.util.RawCharSequence;
import org.eclipse.jgit.util.RawParseUtils;

/* INFO: loaded from: classes5.dex */
public class CommitterRevFilter {
    public static RevFilter create(String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException(JGitText.get().cannotMatchOnEmptyString);
        }
        if (SubStringRevFilter.safe(str)) {
            return new SubStringSearch(str);
        }
        return new PatternSearch(str);
    }

    private CommitterRevFilter() {
    }

    static RawCharSequence textFor(RevCommit revCommit) {
        byte[] rawBuffer = revCommit.getRawBuffer();
        int iCommitter = RawParseUtils.committer(rawBuffer, 0);
        if (iCommitter < 0) {
            return RawCharSequence.EMPTY;
        }
        return new RawCharSequence(rawBuffer, iCommitter, RawParseUtils.nextLF(rawBuffer, iCommitter, Typography.greater));
    }

    private static class PatternSearch extends PatternMatchRevFilter {
        PatternSearch(String str) {
            super(str, true, true, 2);
        }

        @Override // org.eclipse.jgit.revwalk.filter.PatternMatchRevFilter
        protected CharSequence text(RevCommit revCommit) {
            return CommitterRevFilter.textFor(revCommit);
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public RevFilter clone() {
            return new PatternSearch(pattern());
        }
    }

    private static class SubStringSearch extends SubStringRevFilter {
        SubStringSearch(String str) {
            super(str);
        }

        @Override // org.eclipse.jgit.revwalk.filter.SubStringRevFilter
        protected RawCharSequence text(RevCommit revCommit) {
            return CommitterRevFilter.textFor(revCommit);
        }
    }
}
