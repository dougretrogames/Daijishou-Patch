package com.google.common.base;

import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@DoNotMock("Use Optional.of(value) or Optional.absent()")
@ElementTypesAreNonnullByDefault
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public abstract Set<T> asSet();

    public abstract boolean equals(@CheckForNull Object object);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> secondChoice);

    public abstract T or(Supplier<? extends T> supplier);

    public abstract T or(T defaultValue);

    @CheckForNull
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> function);

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> of(T reference) {
        return new Present(Preconditions.checkNotNull(reference));
    }

    public static <T> Optional<T> fromNullable(@CheckForNull T nullableReference) {
        return nullableReference == null ? absent() : new Present(nullableReference);
    }

    Optional() {
    }

    /* JADX INFO: renamed from: com.google.common.base.Optional$1, reason: invalid class name */
    class AnonymousClass1 implements Iterable<T> {
        final /* synthetic */ Iterable val$optionals;

        AnonymousClass1(final Iterable val$optionals) {
            this.val$optionals = val$optionals;
        }

        /* JADX INFO: renamed from: com.google.common.base.Optional$1$1, reason: invalid class name and collision with other inner class name */
        class C00351 extends AbstractIterator<T> {
            private final Iterator<? extends Optional<? extends T>> iterator;

            C00351() {
                this.iterator = (Iterator) Preconditions.checkNotNull(AnonymousClass1.this.val$optionals.iterator());
            }

            @Override // com.google.common.base.AbstractIterator
            @CheckForNull
            protected T computeNext() {
                while (this.iterator.hasNext()) {
                    Optional<? extends T> next = this.iterator.next();
                    if (next.isPresent()) {
                        return next.get();
                    }
                }
                return endOfData();
            }
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new C00351();
        }
    }

    public static <T> Iterable<T> presentInstances(final Iterable<? extends Optional<? extends T>> optionals) {
        Preconditions.checkNotNull(optionals);
        return new AnonymousClass1(optionals);
    }
}
