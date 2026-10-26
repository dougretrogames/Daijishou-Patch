package org.eclipse.jgit.internal.util;

import java.lang.ref.SoftReference;
import java.util.Optional;

/* INFO: loaded from: classes5.dex */
public interface Optionally<T> {
    public static final Optionally<?> EMPTY = new Empty();

    void clear();

    Optional<T> getOptional();

    public static class Empty<T> implements Optionally<T> {
        @Override // org.eclipse.jgit.internal.util.Optionally
        public void clear() {
        }

        @Override // org.eclipse.jgit.internal.util.Optionally
        public Optional<T> getOptional() {
            return Optional.empty();
        }
    }

    public static class Hard<T> implements Optionally<T> {
        protected T element;

        public Hard(T t) {
            this.element = t;
        }

        @Override // org.eclipse.jgit.internal.util.Optionally
        public void clear() {
            this.element = null;
        }

        @Override // org.eclipse.jgit.internal.util.Optionally
        public Optional<T> getOptional() {
            return Optional.ofNullable(this.element);
        }
    }

    public static class Soft<T> extends SoftReference<T> implements Optionally<T> {
        public Soft(T t) {
            super(t);
        }

        @Override // org.eclipse.jgit.internal.util.Optionally
        public Optional<T> getOptional() {
            return Optional.ofNullable(get());
        }
    }

    static <T> Optionally<T> empty() {
        return (Optionally<T>) EMPTY;
    }
}
