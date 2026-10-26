package org.eclipse.jgit.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefComparator;

/* INFO: loaded from: classes5.dex */
public class RefList<T extends Ref> implements Iterable<Ref> {
    private static final RefList<Ref> EMPTY = new RefList<>(new Ref[0], 0);
    final int cnt;
    final Ref[] list;

    public static <T extends Ref> RefList<T> emptyList() {
        return (RefList<T>) EMPTY;
    }

    RefList(Ref[] refArr, int i) {
        this.list = refArr;
        this.cnt = i;
    }

    protected RefList(RefList<T> refList) {
        this.list = refList.list;
        this.cnt = refList.cnt;
    }

    /* INFO: renamed from: org.eclipse.jgit.util.RefList$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<Ref> {
        private int idx;

        AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.idx < RefList.this.cnt;
        }

        @Override // java.util.Iterator
        public Ref next() {
            if (this.idx < RefList.this.cnt) {
                Ref[] refArr = RefList.this.list;
                int i = this.idx;
                this.idx = i + 1;
                return refArr[i];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Ref> iterator() {
        return new AnonymousClass1();
    }

    public final List<Ref> asList() {
        return Collections.unmodifiableList(Arrays.asList(this.list).subList(0, this.cnt));
    }

    public final int size() {
        return this.cnt;
    }

    public final boolean isEmpty() {
        return this.cnt == 0;
    }

    public final int find(String str) {
        int i = this.cnt;
        if (i == 0) {
            return -1;
        }
        int i2 = 0;
        do {
            int i3 = (i2 + i) >>> 1;
            int iCompareTo = RefComparator.compareTo(this.list[i3], str);
            if (iCompareTo < 0) {
                i2 = i3 + 1;
            } else {
                if (iCompareTo == 0) {
                    return i3;
                }
                i = i3;
            }
        } while (i2 < i);
        return -(i2 + 1);
    }

    public final boolean contains(String str) {
        return find(str) >= 0;
    }

    public final T get(String str) {
        int iFind = find(str);
        if (iFind >= 0) {
            return (T) get(iFind);
        }
        return null;
    }

    public final T get(int i) {
        return (T) this.list[i];
    }

    public final Builder<T> copy(int i) {
        Builder<T> builder = new Builder<>(Math.max(16, i));
        builder.addAll(this.list, 0, i);
        return builder;
    }

    public final RefList<T> set(int i, T t) {
        int i2 = this.cnt;
        Ref[] refArr = new Ref[i2];
        System.arraycopy(this.list, 0, refArr, 0, i2);
        refArr[i] = t;
        return new RefList<>(refArr, this.cnt);
    }

    public final RefList<T> add(int i, T t) {
        if (i < 0) {
            i = -(i + 1);
        }
        Ref[] refArr = new Ref[this.cnt + 1];
        if (i > 0) {
            System.arraycopy(this.list, 0, refArr, 0, i);
        }
        refArr[i] = t;
        int i2 = this.cnt;
        if (i < i2) {
            System.arraycopy(this.list, i, refArr, i + 1, i2 - i);
        }
        return new RefList<>(refArr, this.cnt + 1);
    }

    public final RefList<T> remove(int i) {
        int i2 = this.cnt;
        if (i2 == 1) {
            return emptyList();
        }
        Ref[] refArr = new Ref[i2 - 1];
        if (i > 0) {
            System.arraycopy(this.list, 0, refArr, 0, i);
        }
        int i3 = i + 1;
        int i4 = this.cnt;
        if (i3 < i4) {
            System.arraycopy(this.list, i3, refArr, i, i4 - i3);
        }
        return new RefList<>(refArr, this.cnt - 1);
    }

    public final RefList<T> put(T t) {
        int iFind = find(t.getName());
        if (iFind >= 0) {
            return set(iFind, t);
        }
        return add(iFind, t);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(CollectionUtils.DEFAULT_TOSTRING_PREFIX);
        if (this.cnt > 0) {
            sb.append(this.list[0]);
            for (int i = 1; i < this.cnt; i++) {
                sb.append(", ");
                sb.append(this.list[i]);
            }
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    static /* synthetic */ Builder lambda$0() {
        return new Builder();
    }

    public static <T extends Ref> Collector<T, ?, RefList<T>> toRefList(@Nullable BinaryOperator<T> binaryOperator) {
        return Collector.of(new RefList$$ExternalSyntheticLambda0(), new RefList$$ExternalSyntheticLambda1(), new RefList$$ExternalSyntheticLambda2(), new RefList$$ExternalSyntheticLambda3(binaryOperator), new Collector.Characteristics[0]);
    }

    static /* synthetic */ Builder lambda$2(Builder builder, Builder builder2) {
        Builder builder3 = new Builder();
        builder3.addAll(builder);
        builder3.addAll(builder2);
        return builder3;
    }

    static /* synthetic */ RefList lambda$3(BinaryOperator binaryOperator, Builder builder) {
        if (binaryOperator != null) {
            builder.sort();
            builder.dedupe(binaryOperator);
        }
        return builder.toRefList();
    }

    public static class Builder<T extends Ref> {
        private Ref[] list;
        private int size;

        public Builder() {
            this(16);
        }

        public Builder(int i) {
            this.list = new Ref[Math.max(i, 16)];
        }

        public int size() {
            return this.size;
        }

        public T get(int i) {
            return (T) this.list[i];
        }

        public void remove(int i) {
            Ref[] refArr = this.list;
            int i2 = i + 1;
            System.arraycopy(refArr, i2, refArr, i, this.size - i2);
            this.size--;
        }

        public void add(T t) {
            Ref[] refArr = this.list;
            int length = refArr.length;
            int i = this.size;
            if (length == i) {
                Ref[] refArr2 = new Ref[i * 2];
                System.arraycopy(refArr, 0, refArr2, 0, i);
                this.list = refArr2;
            }
            Ref[] refArr3 = this.list;
            int i2 = this.size;
            this.size = i2 + 1;
            refArr3[i2] = t;
        }

        public void addAll(Builder builder) {
            addAll(builder.list, 0, builder.size);
        }

        public void addAll(Ref[] refArr, int i, int i2) {
            int length = this.list.length;
            int i3 = this.size;
            if (length < i3 + i2) {
                Ref[] refArr2 = new Ref[Math.max(i3 * 2, i3 + i2)];
                System.arraycopy(this.list, 0, refArr2, 0, this.size);
                this.list = refArr2;
            }
            System.arraycopy(refArr, i, this.list, this.size, i2);
            this.size += i2;
        }

        public void set(int i, T t) {
            this.list[i] = t;
        }

        public void sort() {
            Arrays.sort(this.list, 0, this.size, RefComparator.INSTANCE);
        }

        /* WARN: Multi-variable type inference failed */
        void dedupe(BinaryOperator<T> binaryOperator) {
            if (this.size == 0) {
                return;
            }
            int i = 0;
            for (int i2 = 1; i2 < this.size; i2++) {
                RefComparator refComparator = RefComparator.INSTANCE;
                Ref[] refArr = this.list;
                if (refComparator.compare(refArr[i], refArr[i2]) == 0) {
                    Ref[] refArr2 = this.list;
                    refArr2[i] = (Ref) binaryOperator.apply(refArr2[i], refArr2[i2]);
                } else {
                    Ref[] refArr3 = this.list;
                    i++;
                    refArr3[i] = refArr3[i2];
                }
            }
            int i3 = i + 1;
            this.size = i3;
            Ref[] refArr4 = this.list;
            Arrays.fill(refArr4, i3, refArr4.length, (Object) null);
        }

        public RefList<T> toRefList() {
            return new RefList<>(this.list, this.size);
        }

        public String toString() {
            return toRefList().toString();
        }
    }
}
