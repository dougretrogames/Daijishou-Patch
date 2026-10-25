package org.eclipse.jgit.fnmatch;

/* JADX INFO: loaded from: classes5.dex */
final class CharacterHead extends AbstractHead {
    private final char expectedCharacter;

    CharacterHead(char c) {
        super(false);
        this.expectedCharacter = c;
    }

    @Override // org.eclipse.jgit.fnmatch.AbstractHead
    protected final boolean matches(char c) {
        return c == this.expectedCharacter;
    }

    public String toString() {
        return String.valueOf(this.expectedCharacter);
    }
}
