package org.eclipse.jgit.revwalk.filter;

import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.util.RawCharSequence;
import org.eclipse.jgit.util.RawParseUtils;

/* INFO: loaded from: classes5.dex */
public class MessageRevFilter {
    public static RevFilter create(String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException(JGitText.get().cannotMatchOnEmptyString);
        }
        if (SubStringRevFilter.safe(str)) {
            return new SubStringSearch(str);
        }
        return new PatternSearch(str);
    }

    private MessageRevFilter() {
    }

    static RawCharSequence textFor(RevCommit revCommit) {
        byte[] rawBuffer = revCommit.getRawBuffer();
        int iCommitMessage = RawParseUtils.commitMessage(rawBuffer, 0);
        if (iCommitMessage < 0) {
            return RawCharSequence.EMPTY;
        }
        return new RawCharSequence(rawBuffer, iCommitMessage, rawBuffer.length);
    }

    private static class PatternSearch extends PatternMatchRevFilter {
        PatternSearch(String str) {
            super(str, true, true, 34);
        }

        @Override // org.eclipse.jgit.revwalk.filter.PatternMatchRevFilter
        protected CharSequence text(RevCommit revCommit) {
            return MessageRevFilter.textFor(revCommit);
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
            return MessageRevFilter.textFor(revCommit);
        }
    }
}
