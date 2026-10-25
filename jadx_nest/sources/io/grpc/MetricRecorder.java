package io.grpc;

import com.google.common.base.Preconditions;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface MetricRecorder {

    public interface BatchCallback {
        void accept(BatchRecorder batchRecorder);
    }

    public interface Registration extends AutoCloseable {
        @Override // java.lang.AutoCloseable
        void close();
    }

    static /* synthetic */ void lambda$registerBatchCallback$0() {
    }

    default void addDoubleCounter(DoubleCounterMetricInstrument doubleCounterMetricInstrument, double d, List<String> list, List<String> list2) {
        Preconditions.checkArgument(list != null && list.size() == doubleCounterMetricInstrument.getRequiredLabelKeys().size(), "Incorrect number of required labels provided. Expected: %s", doubleCounterMetricInstrument.getRequiredLabelKeys().size());
        Preconditions.checkArgument(list2 != null && list2.size() == doubleCounterMetricInstrument.getOptionalLabelKeys().size(), "Incorrect number of optional labels provided. Expected: %s", doubleCounterMetricInstrument.getOptionalLabelKeys().size());
    }

    default void addLongCounter(LongCounterMetricInstrument longCounterMetricInstrument, long j, List<String> list, List<String> list2) {
        Preconditions.checkArgument(list != null && list.size() == longCounterMetricInstrument.getRequiredLabelKeys().size(), "Incorrect number of required labels provided. Expected: %s", longCounterMetricInstrument.getRequiredLabelKeys().size());
        Preconditions.checkArgument(list2 != null && list2.size() == longCounterMetricInstrument.getOptionalLabelKeys().size(), "Incorrect number of optional labels provided. Expected: %s", longCounterMetricInstrument.getOptionalLabelKeys().size());
    }

    default void recordDoubleHistogram(DoubleHistogramMetricInstrument doubleHistogramMetricInstrument, double d, List<String> list, List<String> list2) {
        Preconditions.checkArgument(list != null && list.size() == doubleHistogramMetricInstrument.getRequiredLabelKeys().size(), "Incorrect number of required labels provided. Expected: %s", doubleHistogramMetricInstrument.getRequiredLabelKeys().size());
        Preconditions.checkArgument(list2 != null && list2.size() == doubleHistogramMetricInstrument.getOptionalLabelKeys().size(), "Incorrect number of optional labels provided. Expected: %s", doubleHistogramMetricInstrument.getOptionalLabelKeys().size());
    }

    default void recordLongHistogram(LongHistogramMetricInstrument longHistogramMetricInstrument, long j, List<String> list, List<String> list2) {
        Preconditions.checkArgument(list != null && list.size() == longHistogramMetricInstrument.getRequiredLabelKeys().size(), "Incorrect number of required labels provided. Expected: %s", longHistogramMetricInstrument.getRequiredLabelKeys().size());
        Preconditions.checkArgument(list2 != null && list2.size() == longHistogramMetricInstrument.getOptionalLabelKeys().size(), "Incorrect number of optional labels provided. Expected: %s", longHistogramMetricInstrument.getOptionalLabelKeys().size());
    }

    default Registration registerBatchCallback(BatchCallback batchCallback, CallbackMetricInstrument... callbackMetricInstrumentArr) {
        return new MetricRecorder$$ExternalSyntheticLambda0();
    }

    public interface BatchRecorder {
        default void recordLongGauge(LongGaugeMetricInstrument longGaugeMetricInstrument, long j, List<String> list, List<String> list2) {
            Preconditions.checkArgument(list != null && list.size() == longGaugeMetricInstrument.getRequiredLabelKeys().size(), "Incorrect number of required labels provided. Expected: %s", longGaugeMetricInstrument.getRequiredLabelKeys().size());
            Preconditions.checkArgument(list2 != null && list2.size() == longGaugeMetricInstrument.getOptionalLabelKeys().size(), "Incorrect number of optional labels provided. Expected: %s", longGaugeMetricInstrument.getOptionalLabelKeys().size());
        }
    }
}
