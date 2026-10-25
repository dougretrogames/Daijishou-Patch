package org.eclipse.jgit.fnmatch;

/* JADX INFO: loaded from: classes5.dex */
final class RestrictedWildCardHead extends AbstractHead {
    private final char excludedCharacter;

    RestrictedWildCardHead(char c, boolean z) {
        super(z);
        this.excludedCharacter = c;
    }

    @Override // org.eclipse.jgit.fnmatch.AbstractHead
    protected final boolean matches(char c) {
        return c != this.excludedCharacter;
    }

    public String toString() {
        return isStar() ? "*" : "?";
    }
}
