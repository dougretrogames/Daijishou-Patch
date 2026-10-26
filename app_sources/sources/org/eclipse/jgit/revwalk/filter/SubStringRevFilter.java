package org.eclipse.jgit.revwalk.filter;

import java.io.IOException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.util.RawCharSequence;
import org.eclipse.jgit.util.RawSubStringPattern;

/* INFO: loaded from: classes5.dex */
public abstract class SubStringRevFilter extends RevFilter {
    private final RawSubStringPattern pattern;

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public RevFilter clone() {
        return this;
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public boolean requiresCommitBody() {
        return true;
    }

    protected abstract RawCharSequence text(RevCommit revCommit);

    public static boolean safe(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '.' && cCharAt != '?' && cCharAt != '{' && cCharAt != '}') {
                switch (cCharAt) {
                    case '(':
                    case ')':
                    case '*':
                    case '+':
                        break;
                    default:
                        switch (cCharAt) {
                            case '[':
                            case '\\':
                            case ']':
                                break;
                            default:
                                break;
                        }
                        break;
                }
            }
            return false;
        }
        return true;
    }

    protected SubStringRevFilter(String str) {
        this.pattern = new RawSubStringPattern(str);
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public boolean include(RevWalk revWalk, RevCommit revCommit) throws IOException {
        return this.pattern.match(text(revCommit)) >= 0;
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public String toString() {
        return super.toString() + "(\"" + this.pattern.pattern() + "\")";
    }
}
