package org.eclipse.jgit.ignore;

import java.text.MessageFormat;
import org.eclipse.jgit.errors.InvalidPatternException;
import org.eclipse.jgit.ignore.internal.PathMatcher;
import org.eclipse.jgit.ignore.internal.Strings;
import org.eclipse.jgit.internal.JGitText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public class FastIgnoreRule {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) FastIgnoreRule.class);
    public static final char PATH_SEPARATOR = '/';
    private boolean dirOnly;
    private boolean inverse;
    private IMatcher matcher;

    public FastIgnoreRule(String str) {
        this();
        try {
            parse(str);
        } catch (InvalidPatternException e) {
            LOG.error(MessageFormat.format(JGitText.get().badIgnorePattern, e.getPattern()), (Throwable) e);
        }
    }

    FastIgnoreRule() {
        this.matcher = IMatcher.NO_MATCH;
    }

    void parse(String str) throws InvalidPatternException {
        char cCharAt;
        if (str == null) {
            throw new IllegalArgumentException("Pattern must not be null!");
        }
        if (str.length() == 0) {
            this.dirOnly = false;
            this.inverse = false;
            this.matcher = IMatcher.NO_MATCH;
            return;
        }
        boolean z = str.charAt(0) == '!';
        this.inverse = z;
        if (z) {
            str = str.substring(1);
            if (str.length() == 0) {
                this.dirOnly = false;
                this.matcher = IMatcher.NO_MATCH;
                return;
            }
        }
        if (str.charAt(0) == '#') {
            this.matcher = IMatcher.NO_MATCH;
            this.dirOnly = false;
            return;
        }
        if (str.charAt(0) == '\\' && str.length() > 1 && ((cCharAt = str.charAt(1)) == '!' || cCharAt == '#')) {
            str = str.substring(1);
        }
        boolean zIsDirectoryPattern = Strings.isDirectoryPattern(str);
        this.dirOnly = zIsDirectoryPattern;
        if (zIsDirectoryPattern) {
            str = Strings.stripTrailing(Strings.stripTrailingWhitespace(str), '/');
            if (str.length() == 0) {
                this.matcher = IMatcher.NO_MATCH;
                return;
            }
        }
        this.matcher = PathMatcher.createPathMatcher(str, '/', this.dirOnly);
    }

    public boolean isMatch(String str, boolean z) {
        return isMatch(str, z, false);
    }

    public boolean isMatch(String str, boolean z, boolean z2) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return this.matcher.matches(str, z, z2);
    }

    public boolean getNameOnly() {
        return !(this.matcher instanceof PathMatcher);
    }

    public boolean dirOnly() {
        return this.dirOnly;
    }

    public boolean getNegation() {
        return this.inverse;
    }

    public boolean getResult() {
        return !this.inverse;
    }

    public boolean isEmpty() {
        return this.matcher == IMatcher.NO_MATCH;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.inverse) {
            sb.append('!');
        }
        sb.append(this.matcher);
        if (this.dirOnly) {
            sb.append('/');
        }
        return sb.toString();
    }

    public int hashCode() {
        int i = ((((this.inverse ? 1231 : 1237) + 31) * 31) + (this.dirOnly ? 1231 : 1237)) * 31;
        IMatcher iMatcher = this.matcher;
        return i + (iMatcher == null ? 0 : iMatcher.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastIgnoreRule)) {
            return false;
        }
        FastIgnoreRule fastIgnoreRule = (FastIgnoreRule) obj;
        if (this.inverse == fastIgnoreRule.inverse && this.dirOnly == fastIgnoreRule.dirOnly) {
            return this.matcher.equals(fastIgnoreRule.matcher);
        }
        return false;
    }
}
