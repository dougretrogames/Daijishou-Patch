package org.eclipse.jgit.ignore.internal;

import org.eclipse.jgit.ignore.IMatcher;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractMatcher implements IMatcher {
    final boolean dirOnly;
    final String pattern;

    AbstractMatcher(String str, boolean z) {
        this.pattern = str;
        this.dirOnly = z;
    }

    public String toString() {
        return this.pattern;
    }

    public int hashCode() {
        return this.pattern.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractMatcher)) {
            return false;
        }
        AbstractMatcher abstractMatcher = (AbstractMatcher) obj;
        return this.dirOnly == abstractMatcher.dirOnly && this.pattern.equals(abstractMatcher.pattern);
    }
}
