package org.eclipse.jgit.fnmatch;

/* JADX INFO: loaded from: classes5.dex */
final class WildCardHead extends AbstractHead {
    @Override // org.eclipse.jgit.fnmatch.AbstractHead
    protected final boolean matches(char c) {
        return true;
    }

    WildCardHead(boolean z) {
        super(z);
    }
}
