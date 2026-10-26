package io.opencensus.stats;

import io.opencensus.common.Duration;
import io.opencensus.common.Function;
import io.opencensus.common.Functions;
import io.opencensus.common.Timestamp;
import io.opencensus.tags.TagValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* INFO: loaded from: classes4.dex */
public abstract class ViewData {
    public abstract Map<List<TagValue>, AggregationData> getAggregationMap();

    public abstract Timestamp getEnd();

    public abstract Timestamp getStart();

    public abstract View getView();

    @Deprecated
    public abstract AggregationWindowData getWindowData();

    ViewData() {
    }

    @Deprecated
    public static ViewData create(View view, Map<? extends List<TagValue>, ? extends AggregationData> map, AggregationWindowData aggregationWindowData) {
        checkWindow(view.getWindow(), aggregationWindowData);
        HashMap map2 = new HashMap();
        for (Map.Entry<? extends List<TagValue>, ? extends AggregationData> entry : map.entrySet()) {
            checkAggregation(view.getAggregation(), entry.getValue(), view.getMeasure());
            map2.put(Collections.unmodifiableList(new ArrayList(entry.getKey())), entry.getValue());
        }
        return (ViewData) aggregationWindowData.match(new AnonymousClass1(view, map2), new AnonymousClass2(view, map2), Functions.throwAssertionError());
    }

    /* INFO: renamed from: io.opencensus.stats.ViewData$1, reason: invalid class name */
    class AnonymousClass1 implements Function<AggregationWindowData.CumulativeData, ViewData> {
        final /* synthetic */ Map val$deepCopy;
        final /* synthetic */ View val$view;

        AnonymousClass1(View view, Map map) {
            this.val$view = view;
            this.val$deepCopy = map;
        }

        @Override // io.opencensus.common.Function
        public ViewData apply(AggregationWindowData.CumulativeData cumulativeData) {
            return ViewData.createInternal(this.val$view, Collections.unmodifiableMap(this.val$deepCopy), cumulativeData, cumulativeData.getStart(), cumulativeData.getEnd());
        }
    }

    /* INFO: renamed from: io.opencensus.stats.ViewData$2, reason: invalid class name */
    class AnonymousClass2 implements Function<AggregationWindowData.IntervalData, ViewData> {
        final /* synthetic */ Map val$deepCopy;
        final /* synthetic */ View val$view;

        AnonymousClass2(View view, Map map) {
            this.val$view = view;
            this.val$deepCopy = map;
        }

        @Override // io.opencensus.common.Function
        public ViewData apply(AggregationWindowData.IntervalData intervalData) {
            Duration duration = ((View.AggregationWindow.Interval) this.val$view.getWindow()).getDuration();
            return ViewData.createInternal(this.val$view, Collections.unmodifiableMap(this.val$deepCopy), intervalData, intervalData.getEnd().addDuration(Duration.create(-duration.getSeconds(), -duration.getNanos())), intervalData.getEnd());
        }
    }

    public static ViewData create(View view, Map<? extends List<TagValue>, ? extends AggregationData> map, Timestamp timestamp, Timestamp timestamp2) {
        HashMap map2 = new HashMap();
        for (Map.Entry<? extends List<TagValue>, ? extends AggregationData> entry : map.entrySet()) {
            checkAggregation(view.getAggregation(), entry.getValue(), view.getMeasure());
            map2.put(Collections.unmodifiableList(new ArrayList(entry.getKey())), entry.getValue());
        }
        return createInternal(view, Collections.unmodifiableMap(map2), AggregationWindowData.CumulativeData.create(timestamp, timestamp2), timestamp, timestamp2);
    }

    /* INFO: Access modifiers changed from: private */
    public static ViewData createInternal(View view, Map<List<TagValue>, AggregationData> map, AggregationWindowData aggregationWindowData, Timestamp timestamp, Timestamp timestamp2) {
        return new AutoValue_ViewData(view, map, aggregationWindowData, timestamp, timestamp2);
    }

    /* INFO: renamed from: io.opencensus.stats.ViewData$3, reason: invalid class name */
    class AnonymousClass3 implements Function<View.AggregationWindow.Cumulative, Void> {
        final /* synthetic */ AggregationWindowData val$windowData;

        AnonymousClass3(AggregationWindowData aggregationWindowData) {
            this.val$windowData = aggregationWindowData;
        }

        @Override // io.opencensus.common.Function
        public Void apply(View.AggregationWindow.Cumulative cumulative) {
            AggregationWindowData aggregationWindowData = this.val$windowData;
            ViewData.throwIfWindowMismatch(aggregationWindowData instanceof AggregationWindowData.CumulativeData, cumulative, aggregationWindowData);
            return null;
        }
    }

    private static void checkWindow(View.AggregationWindow aggregationWindow, AggregationWindowData aggregationWindowData) {
        aggregationWindow.match(new AnonymousClass3(aggregationWindowData), new AnonymousClass4(aggregationWindowData), Functions.throwAssertionError());
    }

    /* INFO: renamed from: io.opencensus.stats.ViewData$4, reason: invalid class name */
    class AnonymousClass4 implements Function<View.AggregationWindow.Interval, Void> {
        final /* synthetic */ AggregationWindowData val$windowData;

        AnonymousClass4(AggregationWindowData aggregationWindowData) {
            this.val$windowData = aggregationWindowData;
        }

        @Override // io.opencensus.common.Function
        public Void apply(View.AggregationWindow.Interval interval) {
            AggregationWindowData aggregationWindowData = this.val$windowData;
            ViewData.throwIfWindowMismatch(aggregationWindowData instanceof AggregationWindowData.IntervalData, interval, aggregationWindowData);
            return null;
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static void throwIfWindowMismatch(boolean z, View.AggregationWindow aggregationWindow, AggregationWindowData aggregationWindowData) {
        if (!z) {
            throw new IllegalArgumentException(createErrorMessageForWindow(aggregationWindow, aggregationWindowData));
        }
    }

    private static String createErrorMessageForWindow(View.AggregationWindow aggregationWindow, AggregationWindowData aggregationWindowData) {
        return "AggregationWindow and AggregationWindowData types mismatch. AggregationWindow: " + aggregationWindow.getClass().getSimpleName() + " AggregationWindowData: " + aggregationWindowData.getClass().getSimpleName();
    }

    /* INFO: renamed from: io.opencensus.stats.ViewData$5, reason: invalid class name */
    class AnonymousClass5 implements Function<Aggregation.Sum, Void> {
        final /* synthetic */ Aggregation val$aggregation;
        final /* synthetic */ AggregationData val$aggregationData;
        final /* synthetic */ Measure val$measure;

        AnonymousClass5(Measure measure, AggregationData aggregationData, Aggregation aggregation) {
            this.val$measure = measure;
            this.val$aggregationData = aggregationData;
            this.val$aggregation = aggregation;
        }

        /* INFO: renamed from: io.opencensus.stats.ViewData$5$1, reason: invalid class name */
        class AnonymousClass1 implements Function<Measure.MeasureDouble, Void> {
            AnonymousClass1() {
            }

            @Override // io.opencensus.common.Function
            public Void apply(Measure.MeasureDouble measureDouble) {
                ViewData.throwIfAggregationMismatch(AnonymousClass5.this.val$aggregationData instanceof AggregationData.SumDataDouble, AnonymousClass5.this.val$aggregation, AnonymousClass5.this.val$aggregationData);
                return null;
            }
        }

        @Override // io.opencensus.common.Function
        public Void apply(Aggregation.Sum sum) {
            this.val$measure.match(new AnonymousClass1(), new AnonymousClass2(), Functions.throwAssertionError());
            return null;
        }

        /* INFO: renamed from: io.opencensus.stats.ViewData$5$2, reason: invalid class name */
        class AnonymousClass2 implements Function<Measure.MeasureLong, Void> {
            AnonymousClass2() {
            }

            @Override // io.opencensus.common.Function
            public Void apply(Measure.MeasureLong measureLong) {
                ViewData.throwIfAggregationMismatch(AnonymousClass5.this.val$aggregationData instanceof AggregationData.SumDataLong, AnonymousClass5.this.val$aggregation, AnonymousClass5.this.val$aggregationData);
                return null;
            }
        }
    }

    private static void checkAggregation(Aggregation aggregation, AggregationData aggregationData, Measure measure) {
        aggregation.match(new AnonymousClass5(measure, aggregationData, aggregation), new AnonymousClass6(aggregationData, aggregation), new AnonymousClass7(aggregationData, aggregation), new AnonymousClass8(measure, aggregationData, aggregation), new AnonymousClass9(aggregationData, aggregation));
    }

    /* INFO: renamed from: io.opencensus.stats.ViewData$6, reason: invalid class name */
    class AnonymousClass6 implements Function<Aggregation.Count, Void> {
        final /* synthetic */ Aggregation val$aggregation;
        final /* synthetic */ AggregationData val$aggregationData;

        AnonymousClass6(AggregationData aggregationData, Aggregation aggregation) {
            this.val$aggregationData = aggregationData;
            this.val$aggregation = aggregation;
        }

        @Override // io.opencensus.common.Function
        public Void apply(Aggregation.Count count) {
            AggregationData aggregationData = this.val$aggregationData;
            ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.CountData, this.val$aggregation, aggregationData);
            return null;
        }
    }

    /* INFO: renamed from: io.opencensus.stats.ViewData$7, reason: invalid class name */
    class AnonymousClass7 implements Function<Aggregation.Distribution, Void> {
        final /* synthetic */ Aggregation val$aggregation;
        final /* synthetic */ AggregationData val$aggregationData;

        AnonymousClass7(AggregationData aggregationData, Aggregation aggregation) {
            this.val$aggregationData = aggregationData;
            this.val$aggregation = aggregation;
        }

        @Override // io.opencensus.common.Function
        public Void apply(Aggregation.Distribution distribution) {
            AggregationData aggregationData = this.val$aggregationData;
            ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.DistributionData, this.val$aggregation, aggregationData);
            return null;
        }
    }

    /* INFO: renamed from: io.opencensus.stats.ViewData$8, reason: invalid class name */
    class AnonymousClass8 implements Function<Aggregation.LastValue, Void> {
        final /* synthetic */ Aggregation val$aggregation;
        final /* synthetic */ AggregationData val$aggregationData;
        final /* synthetic */ Measure val$measure;

        AnonymousClass8(Measure measure, AggregationData aggregationData, Aggregation aggregation) {
            this.val$measure = measure;
            this.val$aggregationData = aggregationData;
            this.val$aggregation = aggregation;
        }

        /* INFO: renamed from: io.opencensus.stats.ViewData$8$1, reason: invalid class name */
        class AnonymousClass1 implements Function<Measure.MeasureDouble, Void> {
            AnonymousClass1() {
            }

            @Override // io.opencensus.common.Function
            public Void apply(Measure.MeasureDouble measureDouble) {
                ViewData.throwIfAggregationMismatch(AnonymousClass8.this.val$aggregationData instanceof AggregationData.LastValueDataDouble, AnonymousClass8.this.val$aggregation, AnonymousClass8.this.val$aggregationData);
                return null;
            }
        }

        @Override // io.opencensus.common.Function
        public Void apply(Aggregation.LastValue lastValue) {
            this.val$measure.match(new AnonymousClass1(), new AnonymousClass2(), Functions.throwAssertionError());
            return null;
        }

        /* INFO: renamed from: io.opencensus.stats.ViewData$8$2, reason: invalid class name */
        class AnonymousClass2 implements Function<Measure.MeasureLong, Void> {
            AnonymousClass2() {
            }

            @Override // io.opencensus.common.Function
            public Void apply(Measure.MeasureLong measureLong) {
                ViewData.throwIfAggregationMismatch(AnonymousClass8.this.val$aggregationData instanceof AggregationData.LastValueDataLong, AnonymousClass8.this.val$aggregation, AnonymousClass8.this.val$aggregationData);
                return null;
            }
        }
    }

    /* INFO: renamed from: io.opencensus.stats.ViewData$9, reason: invalid class name */
    class AnonymousClass9 implements Function<Aggregation, Void> {
        final /* synthetic */ Aggregation val$aggregation;
        final /* synthetic */ AggregationData val$aggregationData;

        AnonymousClass9(AggregationData aggregationData, Aggregation aggregation) {
            this.val$aggregationData = aggregationData;
            this.val$aggregation = aggregation;
        }

        @Override // io.opencensus.common.Function
        public Void apply(Aggregation aggregation) {
            if (aggregation instanceof Aggregation.Mean) {
                AggregationData aggregationData = this.val$aggregationData;
                ViewData.throwIfAggregationMismatch(aggregationData instanceof AggregationData.MeanData, this.val$aggregation, aggregationData);
                return null;
            }
            throw new AssertionError();
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static void throwIfAggregationMismatch(boolean z, Aggregation aggregation, AggregationData aggregationData) {
        if (!z) {
            throw new IllegalArgumentException(createErrorMessageForAggregation(aggregation, aggregationData));
        }
    }

    private static String createErrorMessageForAggregation(Aggregation aggregation, AggregationData aggregationData) {
        return "Aggregation and AggregationData types mismatch. Aggregation: " + aggregation.getClass().getSimpleName() + " AggregationData: " + aggregationData.getClass().getSimpleName();
    }

    @Deprecated
    public static abstract class AggregationWindowData {
        public abstract <T> T match(Function<? super CumulativeData, T> function, Function<? super IntervalData, T> function2, Function<? super AggregationWindowData, T> function3);

        /* synthetic */ AggregationWindowData(AnonymousClass1 anonymousClass1) {
            this();
        }

        private AggregationWindowData() {
        }

        @Deprecated
        public static abstract class CumulativeData extends AggregationWindowData {
            public abstract Timestamp getEnd();

            public abstract Timestamp getStart();

            CumulativeData() {
                super(null);
            }

            @Override // io.opencensus.stats.ViewData.AggregationWindowData
            public final <T> T match(Function<? super CumulativeData, T> function, Function<? super IntervalData, T> function2, Function<? super AggregationWindowData, T> function3) {
                return function.apply(this);
            }

            public static CumulativeData create(Timestamp timestamp, Timestamp timestamp2) {
                if (timestamp.compareTo(timestamp2) > 0) {
                    throw new IllegalArgumentException("Start time is later than end time.");
                }
                return new AutoValue_ViewData_AggregationWindowData_CumulativeData(timestamp, timestamp2);
            }
        }

        @Deprecated
        public static abstract class IntervalData extends AggregationWindowData {
            public abstract Timestamp getEnd();

            IntervalData() {
                super(null);
            }

            @Override // io.opencensus.stats.ViewData.AggregationWindowData
            public final <T> T match(Function<? super CumulativeData, T> function, Function<? super IntervalData, T> function2, Function<? super AggregationWindowData, T> function3) {
                return function2.apply(this);
            }

            public static IntervalData create(Timestamp timestamp) {
                return new AutoValue_ViewData_AggregationWindowData_IntervalData(timestamp);
            }
        }
    }
}
