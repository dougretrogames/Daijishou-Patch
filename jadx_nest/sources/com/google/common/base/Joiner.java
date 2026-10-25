package com.google.common.base;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public class Joiner {
    private final String separator;

    /* synthetic */ Joiner(Joiner joiner, AnonymousClass1 anonymousClass1) {
        this(joiner);
    }

    public static Joiner on(String separator) {
        return new Joiner(separator);
    }

    public static Joiner on(char separator) {
        return new Joiner(String.valueOf(separator));
    }

    private Joiner(String separator) {
        this.separator = (String) Preconditions.checkNotNull(separator);
    }

    private Joiner(Joiner prototype) {
        this.separator = prototype.separator;
    }

    public <A extends Appendable> A appendTo(A a, Iterable<? extends Object> iterable) throws IOException {
        return (A) appendTo(a, iterable.iterator());
    }

    public <A extends Appendable> A appendTo(A appendable, Iterator<? extends Object> parts) throws IOException {
        Preconditions.checkNotNull(appendable);
        if (parts.hasNext()) {
            appendable.append(toString(parts.next()));
            while (parts.hasNext()) {
                appendable.append(this.separator);
                appendable.append(toString(parts.next()));
            }
        }
        return appendable;
    }

    public final <A extends Appendable> A appendTo(A a, Object[] objArr) throws IOException {
        return (A) appendTo(a, Arrays.asList(objArr));
    }

    public final <A extends Appendable> A appendTo(A a, @CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) throws IOException {
        return (A) appendTo(a, iterable(obj, obj2, objArr));
    }

    public final StringBuilder appendTo(StringBuilder builder, Iterable<? extends Object> parts) {
        return appendTo(builder, parts.iterator());
    }

    public final StringBuilder appendTo(StringBuilder builder, Iterator<? extends Object> parts) {
        try {
            appendTo(builder, parts);
            return builder;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final StringBuilder appendTo(StringBuilder builder, Object[] parts) {
        return appendTo(builder, (Iterable<? extends Object>) Arrays.asList(parts));
    }

    public final StringBuilder appendTo(StringBuilder builder, @CheckForNull Object first, @CheckForNull Object second, Object... rest) {
        return appendTo(builder, iterable(first, second, rest));
    }

    public final String join(Iterable<? extends Object> parts) {
        return join(parts.iterator());
    }

    public final String join(Iterator<? extends Object> parts) {
        return appendTo(new StringBuilder(), parts).toString();
    }

    public final String join(Object[] parts) {
        return join(Arrays.asList(parts));
    }

    public final String join(@CheckForNull Object first, @CheckForNull Object second, Object... rest) {
        return join(iterable(first, second, rest));
    }

    /* JADX INFO: renamed from: com.google.common.base.Joiner$1, reason: invalid class name */
    class AnonymousClass1 extends Joiner {
        final /* synthetic */ String val$nullText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Joiner prototype, final String val$nullText) {
            super(prototype, null);
            this.val$nullText = val$nullText;
        }

        @Override // com.google.common.base.Joiner
        CharSequence toString(@CheckForNull Object part) {
            return part == null ? this.val$nullText : Joiner.this.toString(part);
        }

        @Override // com.google.common.base.Joiner
        public Joiner useForNull(String nullText) {
            throw new UnsupportedOperationException("already specified useForNull");
        }

        @Override // com.google.common.base.Joiner
        public Joiner skipNulls() {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    public Joiner useForNull(String nullText) {
        Preconditions.checkNotNull(nullText);
        return new AnonymousClass1(this, nullText);
    }

    /* JADX INFO: renamed from: com.google.common.base.Joiner$2, reason: invalid class name */
    class AnonymousClass2 extends Joiner {
        AnonymousClass2(Joiner prototype) {
            super(prototype, null);
        }

        @Override // com.google.common.base.Joiner
        public <A extends Appendable> A appendTo(A appendable, Iterator<? extends Object> parts) throws IOException {
            Preconditions.checkNotNull(appendable, "appendable");
            Preconditions.checkNotNull(parts, "parts");
            while (parts.hasNext()) {
                Object next = parts.next();
                if (next != null) {
                    appendable.append(Joiner.this.toString(next));
                    break;
                }
            }
            while (parts.hasNext()) {
                Object next2 = parts.next();
                if (next2 != null) {
                    appendable.append(Joiner.this.separator);
                    appendable.append(Joiner.this.toString(next2));
                }
            }
            return appendable;
        }

        @Override // com.google.common.base.Joiner
        public Joiner useForNull(String nullText) {
            throw new UnsupportedOperationException("already specified skipNulls");
        }

        @Override // com.google.common.base.Joiner
        public MapJoiner withKeyValueSeparator(String kvs) {
            throw new UnsupportedOperationException("can't use .skipNulls() with maps");
        }
    }

    public Joiner skipNulls() {
        return new AnonymousClass2(this);
    }

    public MapJoiner withKeyValueSeparator(char keyValueSeparator) {
        return withKeyValueSeparator(String.valueOf(keyValueSeparator));
    }

    public MapJoiner withKeyValueSeparator(String keyValueSeparator) {
        return new MapJoiner(this, keyValueSeparator, null);
    }

    public static final class MapJoiner {
        private final Joiner joiner;
        private final String keyValueSeparator;

        /* synthetic */ MapJoiner(Joiner joiner, String str, AnonymousClass1 anonymousClass1) {
            this(joiner, str);
        }

        private MapJoiner(Joiner joiner, String keyValueSeparator) {
            this.joiner = joiner;
            this.keyValueSeparator = (String) Preconditions.checkNotNull(keyValueSeparator);
        }

        public <A extends Appendable> A appendTo(A a, Map<?, ?> map) throws IOException {
            return (A) appendTo(a, map.entrySet());
        }

        public StringBuilder appendTo(StringBuilder builder, Map<?, ?> map) {
            return appendTo(builder, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        public <A extends Appendable> A appendTo(A a, Iterable<? extends Map.Entry<?, ?>> iterable) throws IOException {
            return (A) appendTo(a, iterable.iterator());
        }

        public <A extends Appendable> A appendTo(A appendable, Iterator<? extends Map.Entry<?, ?>> parts) throws IOException {
            Preconditions.checkNotNull(appendable);
            if (parts.hasNext()) {
                Map.Entry<?, ?> next = parts.next();
                appendable.append(this.joiner.toString(next.getKey()));
                appendable.append(this.keyValueSeparator);
                appendable.append(this.joiner.toString(next.getValue()));
                while (parts.hasNext()) {
                    appendable.append(this.joiner.separator);
                    Map.Entry<?, ?> next2 = parts.next();
                    appendable.append(this.joiner.toString(next2.getKey()));
                    appendable.append(this.keyValueSeparator);
                    appendable.append(this.joiner.toString(next2.getValue()));
                }
            }
            return appendable;
        }

        public StringBuilder appendTo(StringBuilder builder, Iterable<? extends Map.Entry<?, ?>> entries) {
            return appendTo(builder, entries.iterator());
        }

        public StringBuilder appendTo(StringBuilder builder, Iterator<? extends Map.Entry<?, ?>> entries) {
            try {
                appendTo(builder, entries);
                return builder;
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public String join(Map<?, ?> map) {
            return join(map.entrySet());
        }

        public String join(Iterable<? extends Map.Entry<?, ?>> entries) {
            return join(entries.iterator());
        }

        public String join(Iterator<? extends Map.Entry<?, ?>> entries) {
            return appendTo(new StringBuilder(), entries).toString();
        }

        public MapJoiner useForNull(String nullText) {
            return new MapJoiner(this.joiner.useForNull(nullText), this.keyValueSeparator);
        }
    }

    CharSequence toString(@CheckForNull Object part) {
        java.util.Objects.requireNonNull(part);
        return part instanceof CharSequence ? (CharSequence) part : part.toString();
    }

    /* JADX INFO: renamed from: com.google.common.base.Joiner$3, reason: invalid class name */
    class AnonymousClass3 extends AbstractList<Object> {
        final /* synthetic */ Object val$first;
        final /* synthetic */ Object[] val$rest;
        final /* synthetic */ Object val$second;

        AnonymousClass3(final Object[] val$rest, final Object val$first, final Object val$second) {
            this.val$rest = val$rest;
            this.val$first = val$first;
            this.val$second = val$second;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.val$rest.length + 2;
        }

        @Override // java.util.AbstractList, java.util.List
        @CheckForNull
        public Object get(int index) {
            if (index == 0) {
                return this.val$first;
            }
            if (index == 1) {
                return this.val$second;
            }
            return this.val$rest[index - 2];
        }
    }

    private static Iterable<Object> iterable(@CheckForNull Object first, @CheckForNull Object second, Object[] rest) {
        Preconditions.checkNotNull(rest);
        return new AnonymousClass3(rest, first, second);
    }
}
