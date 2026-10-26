package com.google.common.collect;

import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;

/* INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ComparisonChain {
    private static final ComparisonChain ACTIVE = new AnonymousClass1();
    private static final ComparisonChain LESS = new InactiveComparisonChain(-1);
    private static final ComparisonChain GREATER = new InactiveComparisonChain(1);

    public abstract ComparisonChain compare(double left, double right);

    public abstract ComparisonChain compare(float left, float right);

    public abstract ComparisonChain compare(int left, int right);

    public abstract ComparisonChain compare(long left, long right);

    public abstract ComparisonChain compare(Comparable<?> left, Comparable<?> right);

    public abstract <T> ComparisonChain compare(@ParametricNullness T left, @ParametricNullness T right, Comparator<T> comparator);

    public abstract ComparisonChain compareFalseFirst(boolean left, boolean right);

    public abstract ComparisonChain compareTrueFirst(boolean left, boolean right);

    public abstract int result();

    /* synthetic */ ComparisonChain(AnonymousClass1 anonymousClass1) {
        this();
    }

    private ComparisonChain() {
    }

    public static ComparisonChain start() {
        return ACTIVE;
    }

    /* INFO: renamed from: com.google.common.collect.ComparisonChain$1, reason: invalid class name */
    class AnonymousClass1 extends ComparisonChain {
        @Override // com.google.common.collect.ComparisonChain
        public int result() {
            return 0;
        }

        AnonymousClass1() {
            super(null);
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(Comparable<?> left, Comparable<?> right) {
            return classify(left.compareTo(right));
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> ComparisonChain compare(@ParametricNullness T left, @ParametricNullness T right, Comparator<T> comparator) {
            return classify(comparator.compare(left, right));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(int left, int right) {
            return classify(Ints.compare(left, right));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(long left, long right) {
            return classify(Longs.compare(left, right));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(float left, float right) {
            return classify(Float.compare(left, right));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(double left, double right) {
            return classify(Double.compare(left, right));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareTrueFirst(boolean left, boolean right) {
            return classify(Booleans.compare(right, left));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareFalseFirst(boolean left, boolean right) {
            return classify(Booleans.compare(left, right));
        }

        ComparisonChain classify(int result) {
            if (result < 0) {
                return ComparisonChain.LESS;
            }
            return result > 0 ? ComparisonChain.GREATER : ComparisonChain.ACTIVE;
        }
    }

    private static final class InactiveComparisonChain extends ComparisonChain {
        final int result;

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(double left, double right) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(float left, float right) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(int left, int right) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(long left, long right) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(Comparable<?> left, Comparable<?> right) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> ComparisonChain compare(@ParametricNullness T left, @ParametricNullness T right, Comparator<T> comparator) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareFalseFirst(boolean left, boolean right) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareTrueFirst(boolean left, boolean right) {
            return this;
        }

        InactiveComparisonChain(int result) {
            super(null);
            this.result = result;
        }

        @Override // com.google.common.collect.ComparisonChain
        public int result() {
            return this.result;
        }
    }

    @Deprecated
    public final ComparisonChain compare(Boolean left, Boolean right) {
        return compareFalseFirst(left.booleanValue(), right.booleanValue());
    }
}
