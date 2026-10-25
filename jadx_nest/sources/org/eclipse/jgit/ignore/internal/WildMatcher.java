package org.eclipse.jgit.ignore.internal;

/* JADX INFO: loaded from: classes5.dex */
public final class WildMatcher extends AbstractMatcher {
    static final String WILDMATCH = "**";
    static final String WILDMATCH2 = "/**";

    @Override // org.eclipse.jgit.ignore.IMatcher
    public final boolean matches(String str, int i, int i2) {
        return true;
    }

    WildMatcher(boolean z) {
        super(WILDMATCH, z);
    }

    @Override // org.eclipse.jgit.ignore.IMatcher
    public final boolean matches(String str, boolean z, boolean z2) {
        if (!this.dirOnly || z) {
            return true;
        }
        return !z2 && isSubdirectory(str);
    }

    private static boolean isSubdirectory(String str) {
        int iIndexOf = str.indexOf(47);
        return iIndexOf >= 0 && iIndexOf < str.length() - 1;
    }
}
