package org.eclipse.jgit.ignore.internal;

/* INFO: loaded from: classes5.dex */
public class LeadingAsteriskMatcher extends NameMatcher {
    LeadingAsteriskMatcher(String str, Character ch, boolean z) {
        super(str, ch, z, true);
        if (this.subPattern.charAt(0) != '*') {
            throw new IllegalArgumentException("Pattern must have leading asterisk: " + str);
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
        int i3 = i2 - 1;
        while (length > 0) {
            if (str2.charAt(length) != str.charAt(i3)) {
                return false;
            }
            length--;
            i3--;
        }
        return true;
    }
}
