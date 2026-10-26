package org.eclipse.jgit.ignore;

import org.eclipse.jgit.errors.InvalidPatternException;
import org.eclipse.jgit.ignore.internal.PathMatcher;

/* INFO: loaded from: classes5.dex */
public interface IMatcher {
    public static final IMatcher NO_MATCH = new AnonymousClass1();

    boolean matches(String str, int i, int i2);

    boolean matches(String str, boolean z, boolean z2);

    /* INFO: renamed from: org.eclipse.jgit.ignore.IMatcher$1, reason: invalid class name */
    class AnonymousClass1 implements IMatcher {
        @Override // org.eclipse.jgit.ignore.IMatcher
        public boolean matches(String str, int i, int i2) {
            return false;
        }

        @Override // org.eclipse.jgit.ignore.IMatcher
        public boolean matches(String str, boolean z, boolean z2) {
            return false;
        }

        AnonymousClass1() {
        }
    }

    static IMatcher createPathMatcher(String str, boolean z) throws InvalidPatternException {
        return PathMatcher.createPathMatcher(str, '/', z);
    }
}
