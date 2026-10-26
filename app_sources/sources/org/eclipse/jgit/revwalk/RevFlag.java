package org.eclipse.jgit.revwalk;

import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class RevFlag {
    final int mask;
    final String name;
    final RevWalk walker;
    public static final RevFlag UNINTERESTING = new StaticRevFlag("UNINTERESTING", 4);
    public static final RevFlag SEEN = new StaticRevFlag("SEEN", 2);

    RevFlag(RevWalk revWalk, String str, int i) {
        this.walker = revWalk;
        this.name = str;
        this.mask = i;
    }

    public RevWalk getRevWalk() {
        return this.walker;
    }

    public String toString() {
        return this.name;
    }

    static class StaticRevFlag extends RevFlag {
        StaticRevFlag(String str, int i) {
            super(null, str, i);
        }

        @Override // org.eclipse.jgit.revwalk.RevFlag
        public RevWalk getRevWalk() {
            throw new UnsupportedOperationException(MessageFormat.format(JGitText.get().isAStaticFlagAndHasNorevWalkInstance, toString()));
        }
    }
}
