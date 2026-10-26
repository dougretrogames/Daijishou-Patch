package org.eclipse.jgit.ignore.internal;

/* INFO: loaded from: classes5.dex */
public class TrailingAsteriskMatcher extends NameMatcher {
    TrailingAsteriskMatcher(String str, Character ch, boolean z) {
        super(str, ch, z, true);
        if (this.subPattern.charAt(this.subPattern.length() - 1) != '*') {
            throw new IllegalArgumentException("Pattern must have trailing asterisk: " + str);
        }
    }

    @Override // org.eclipse.jgit.ignore.internal.NameMatcher, org.eclipse.jgit.ignore.IMatcher
    public boolean matches(String str, int i, int i2) {
        String str2 = this.subPattern;
        int length = str2.length() - 1;
        if (length == 0) {
            return true;
        }
        if (length > i2 - i) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (str2.charAt(i3) != str.charAt(i3 + i)) {
                return false;
            }
        }
        return true;
    }
}
