package io.grpc;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* INFO: loaded from: classes4.dex */
public interface MetricSink {

    public interface Registration extends MetricRecorder.Registration {
    }

    static /* synthetic */ void lambda$registerBatchCallback$0() {
    }

    default void addDoubleCounter(DoubleCounterMetricInstrument doubleCounterMetricInstrument, double d, List<String> list, List<String> list2) {
    }

    default void addLongCounter(LongCounterMetricInstrument longCounterMetricInstrument, long j, List<String> list, List<String> list2) {
    }

    Map<String, Boolean> getEnabledMetrics();

    int getMeasuresSize();

    Set<String> getOptionalLabels();

    default void recordDoubleHistogram(DoubleHistogramMetricInstrument doubleHistogramMetricInstrument, double d, List<String> list, List<String> list2) {
    }

    default void recordLongGauge(LongGaugeMetricInstrument longGaugeMetricInstrument, long j, List<String> list, List<String> list2) {
    }

    default void recordLongHistogram(LongHistogramMetricInstrument longHistogramMetricInstrument, long j, List<String> list, List<String> list2) {
    }

    void updateMeasures(List<MetricInstrument> list);

    default Registration registerBatchCallback(Runnable runnable, CallbackMetricInstrument... callbackMetricInstrumentArr) {
        return new MetricSink$$ExternalSyntheticLambda0();
    }
}
