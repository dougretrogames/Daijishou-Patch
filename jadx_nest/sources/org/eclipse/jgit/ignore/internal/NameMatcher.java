package org.eclipse.jgit.ignore.internal;

/* INFO: loaded from: classes5.dex */
public class NameMatcher extends AbstractMatcher {
    final boolean beginning;
    final char slash;
    final String subPattern;

    NameMatcher(String str, Character ch, boolean z, boolean z2) {
        super(str, z);
        char pathSeparator = Strings.getPathSeparator(ch);
        this.slash = pathSeparator;
        str = z2 ? Strings.deleteBackslash(str) : str;
        boolean z3 = false;
        if (str.length() != 0 && str.charAt(0) == pathSeparator) {
            z3 = true;
        }
        this.beginning = z3;
        if (!z3) {
            this.subPattern = str;
        } else {
            this.subPattern = str.substring(1);
        }
    }

    @Override // org.eclipse.jgit.ignore.IMatcher
    public boolean matches(String str, boolean z, boolean z2) {
        boolean zMatches;
        int length = str.length();
        int i = (length <= 0 || str.charAt(0) != this.slash) ? 0 : 1;
        if (z2) {
            int i2 = length - 1;
            int iLastIndexOf = str.lastIndexOf(this.slash, i2);
            if (iLastIndexOf == i2) {
                iLastIndexOf = str.lastIndexOf(this.slash, iLastIndexOf - 1);
                length--;
            }
            if (iLastIndexOf < i) {
                zMatches = matches(str, i, length);
            } else {
                zMatches = !this.beginning && matches(str, iLastIndexOf + 1, length);
            }
            return (zMatches && this.dirOnly) ? z : zMatches;
        }
        while (i < length) {
            int iIndexOf = str.indexOf(this.slash, i);
            if (iIndexOf < 0) {
                iIndexOf = length;
            }
            if (iIndexOf > i && matches(str, i, iIndexOf)) {
                return !this.dirOnly || z || iIndexOf < length;
            }
            if (this.beginning) {
                break;
            }
            i = iIndexOf + 1;
        }
        return false;
    }

    @Override // org.eclipse.jgit.ignore.IMatcher
    public boolean matches(String str, int i, int i2) {
        String str2 = this.subPattern;
        int length = str2.length();
        if (length != i2 - i) {
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
