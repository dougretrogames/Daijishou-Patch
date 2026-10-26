package io.opencensus.stats;

import io.opencensus.common.Function;
import io.opencensus.internal.Utils;

/* INFO: loaded from: classes4.dex */
public abstract class Aggregation {
    public abstract <T> T match(Function<? super Sum, T> function, Function<? super Count, T> function2, Function<? super Distribution, T> function3, Function<? super LastValue, T> function4, Function<? super Aggregation, T> function5);

    /* synthetic */ Aggregation(AnonymousClass1 anonymousClass1) {
        this();
    }

    private Aggregation() {
    }

    public static abstract class Sum extends Aggregation {
        private static final Sum INSTANCE = new AutoValue_Aggregation_Sum();

        Sum() {
            super(null);
        }

        public static Sum create() {
            return INSTANCE;
        }

        @Override // io.opencensus.stats.Aggregation
        public final <T> T match(Function<? super Sum, T> function, Function<? super Count, T> function2, Function<? super Distribution, T> function3, Function<? super LastValue, T> function4, Function<? super Aggregation, T> function5) {
            return function.apply(this);
        }
    }

    public static abstract class Count extends Aggregation {
        private static final Count INSTANCE = new AutoValue_Aggregation_Count();

        Count() {
            super(null);
        }

        public static Count create() {
            return INSTANCE;
        }

        @Override // io.opencensus.stats.Aggregation
        public final <T> T match(Function<? super Sum, T> function, Function<? super Count, T> function2, Function<? super Distribution, T> function3, Function<? super LastValue, T> function4, Function<? super Aggregation, T> function5) {
            return function2.apply(this);
        }
    }

    @Deprecated
    public static abstract class Mean extends Aggregation {
        private static final Mean INSTANCE = new AutoValue_Aggregation_Mean();

        Mean() {
            super(null);
        }

        public static Mean create() {
            return INSTANCE;
        }

        @Override // io.opencensus.stats.Aggregation
        public final <T> T match(Function<? super Sum, T> function, Function<? super Count, T> function2, Function<? super Distribution, T> function3, Function<? super LastValue, T> function4, Function<? super Aggregation, T> function5) {
            return function5.apply(this);
        }
    }

    public static abstract class Distribution extends Aggregation {
        public abstract BucketBoundaries getBucketBoundaries();

        Distribution() {
            super(null);
        }

        public static Distribution create(BucketBoundaries bucketBoundaries) {
            Utils.checkNotNull(bucketBoundaries, "bucketBoundaries");
            return new AutoValue_Aggregation_Distribution(bucketBoundaries);
        }

        @Override // io.opencensus.stats.Aggregation
        public final <T> T match(Function<? super Sum, T> function, Function<? super Count, T> function2, Function<? super Distribution, T> function3, Function<? super LastValue, T> function4, Function<? super Aggregation, T> function5) {
            return function3.apply(this);
        }
    }

    public static abstract class LastValue extends Aggregation {
        private static final LastValue INSTANCE = new AutoValue_Aggregation_LastValue();

        LastValue() {
            super(null);
        }

        public static LastValue create() {
            return INSTANCE;
        }

        @Override // io.opencensus.stats.Aggregation
        public final <T> T match(Function<? super Sum, T> function, Function<? super Count, T> function2, Function<? super Distribution, T> function3, Function<? super LastValue, T> function4, Function<? super Aggregation, T> function5) {
            return function4.apply(this);
        }
    }
}
