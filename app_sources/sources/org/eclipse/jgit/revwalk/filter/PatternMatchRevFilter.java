package org.eclipse.jgit.revwalk.filter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
public abstract class PatternMatchRevFilter extends RevFilter {
    private final Matcher compiledPattern;
    private final String patternText;

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public boolean requiresCommitBody() {
        return true;
    }

    protected abstract CharSequence text(RevCommit revCommit);

    protected static final String forceToRaw(String str) {
        byte[] bArrEncode = Constants.encode(str);
        StringBuilder sb = new StringBuilder(bArrEncode.length);
        for (byte b : bArrEncode) {
            sb.append((char) (b & 255));
        }
        return sb.toString();
    }

    protected PatternMatchRevFilter(String str, boolean z, boolean z2, int i) {
        if (str.length() == 0) {
            throw new IllegalArgumentException(JGitText.get().cannotMatchOnEmptyString);
        }
        this.patternText = str;
        if (z) {
            if (!str.startsWith("^") && !str.startsWith(".*")) {
                str = ".*" + str;
            }
            if (!str.endsWith("$") && !str.endsWith(".*")) {
                str = str + ".*";
            }
        }
        this.compiledPattern = Pattern.compile(z2 ? forceToRaw(str) : str, i).matcher("");
    }

    public String pattern() {
        return this.patternText;
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public boolean include(RevWalk revWalk, RevCommit revCommit) throws IOException {
        return this.compiledPattern.reset(text(revCommit)).matches();
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public String toString() {
        return super.toString() + "(\"" + this.patternText + "\")";
    }
}
