package io.grpc;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* INFO: loaded from: classes4.dex */
public final class MetricInstrumentRegistry {
    static final int INITIAL_INSTRUMENT_CAPACITY = 5;
    private static MetricInstrumentRegistry instance;
    private int nextAvailableMetricIndex;
    private final Object lock = new Object();
    private final Set<String> registeredMetricNames = new HashSet();
    private MetricInstrument[] metricInstruments = new MetricInstrument[5];

    MetricInstrumentRegistry() {
    }

    public static synchronized MetricInstrumentRegistry getDefaultRegistry() {
        if (instance == null) {
            instance = new MetricInstrumentRegistry();
        }
        return instance;
    }

    public List<MetricInstrument> getMetricInstruments() {
        List<MetricInstrument> listUnmodifiableList;
        synchronized (this.lock) {
            listUnmodifiableList = Collections.unmodifiableList(Arrays.asList((MetricInstrument[]) Arrays.copyOfRange(this.metricInstruments, 0, this.nextAvailableMetricIndex)));
        }
        return listUnmodifiableList;
    }

    public DoubleCounterMetricInstrument registerDoubleCounter(String str, String str2, String str3, List<String> list, List<String> list2, boolean z) {
        DoubleCounterMetricInstrument doubleCounterMetricInstrument;
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str), "missing metric name");
        Preconditions.checkNotNull(str2, "description");
        Preconditions.checkNotNull(str3, "unit");
        Preconditions.checkNotNull(list, "requiredLabelKeys");
        Preconditions.checkNotNull(list2, "optionalLabelKeys");
        synchronized (this.lock) {
            if (this.registeredMetricNames.contains(str)) {
                throw new IllegalStateException("Metric with name " + str + " already exists");
            }
            int i = this.nextAvailableMetricIndex;
            if (i + 1 == this.metricInstruments.length) {
                resizeMetricInstruments();
            }
            doubleCounterMetricInstrument = new DoubleCounterMetricInstrument(i, str, str2, str3, list, list2, z);
            this.metricInstruments[i] = doubleCounterMetricInstrument;
            this.registeredMetricNames.add(str);
            this.nextAvailableMetricIndex++;
        }
        return doubleCounterMetricInstrument;
    }

    public LongCounterMetricInstrument registerLongCounter(String str, String str2, String str3, List<String> list, List<String> list2, boolean z) {
        LongCounterMetricInstrument longCounterMetricInstrument;
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str), "missing metric name");
        Preconditions.checkNotNull(str2, "description");
        Preconditions.checkNotNull(str3, "unit");
        Preconditions.checkNotNull(list, "requiredLabelKeys");
        Preconditions.checkNotNull(list2, "optionalLabelKeys");
        synchronized (this.lock) {
            if (this.registeredMetricNames.contains(str)) {
                throw new IllegalStateException("Metric with name " + str + " already exists");
            }
            int i = this.nextAvailableMetricIndex;
            if (i + 1 == this.metricInstruments.length) {
                resizeMetricInstruments();
            }
            longCounterMetricInstrument = new LongCounterMetricInstrument(i, str, str2, str3, list, list2, z);
            this.metricInstruments[i] = longCounterMetricInstrument;
            this.registeredMetricNames.add(str);
            this.nextAvailableMetricIndex++;
        }
        return longCounterMetricInstrument;
    }

    public DoubleHistogramMetricInstrument registerDoubleHistogram(String str, String str2, String str3, List<Double> list, List<String> list2, List<String> list3, boolean z) {
        DoubleHistogramMetricInstrument doubleHistogramMetricInstrument;
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str), "missing metric name");
        Preconditions.checkNotNull(str2, "description");
        Preconditions.checkNotNull(str3, "unit");
        Preconditions.checkNotNull(list, "bucketBoundaries");
        Preconditions.checkNotNull(list2, "requiredLabelKeys");
        Preconditions.checkNotNull(list3, "optionalLabelKeys");
        synchronized (this.lock) {
            if (this.registeredMetricNames.contains(str)) {
                throw new IllegalStateException("Metric with name " + str + " already exists");
            }
            int i = this.nextAvailableMetricIndex;
            if (i + 1 == this.metricInstruments.length) {
                resizeMetricInstruments();
            }
            doubleHistogramMetricInstrument = new DoubleHistogramMetricInstrument(i, str, str2, str3, list, list2, list3, z);
            this.metricInstruments[i] = doubleHistogramMetricInstrument;
            this.registeredMetricNames.add(str);
            this.nextAvailableMetricIndex++;
        }
        return doubleHistogramMetricInstrument;
    }

    public LongHistogramMetricInstrument registerLongHistogram(String str, String str2, String str3, List<Long> list, List<String> list2, List<String> list3, boolean z) {
        LongHistogramMetricInstrument longHistogramMetricInstrument;
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str), "missing metric name");
        Preconditions.checkNotNull(str2, "description");
        Preconditions.checkNotNull(str3, "unit");
        Preconditions.checkNotNull(list, "bucketBoundaries");
        Preconditions.checkNotNull(list2, "requiredLabelKeys");
        Preconditions.checkNotNull(list3, "optionalLabelKeys");
        synchronized (this.lock) {
            if (this.registeredMetricNames.contains(str)) {
                throw new IllegalStateException("Metric with name " + str + " already exists");
            }
            int i = this.nextAvailableMetricIndex;
            if (i + 1 == this.metricInstruments.length) {
                resizeMetricInstruments();
            }
            longHistogramMetricInstrument = new LongHistogramMetricInstrument(i, str, str2, str3, list, list2, list3, z);
            this.metricInstruments[i] = longHistogramMetricInstrument;
            this.registeredMetricNames.add(str);
            this.nextAvailableMetricIndex++;
        }
        return longHistogramMetricInstrument;
    }

    public LongGaugeMetricInstrument registerLongGauge(String str, String str2, String str3, List<String> list, List<String> list2, boolean z) {
        LongGaugeMetricInstrument longGaugeMetricInstrument;
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str), "missing metric name");
        Preconditions.checkNotNull(str2, "description");
        Preconditions.checkNotNull(str3, "unit");
        Preconditions.checkNotNull(list, "requiredLabelKeys");
        Preconditions.checkNotNull(list2, "optionalLabelKeys");
        synchronized (this.lock) {
            if (this.registeredMetricNames.contains(str)) {
                throw new IllegalStateException("Metric with name " + str + " already exists");
            }
            int i = this.nextAvailableMetricIndex;
            if (i + 1 == this.metricInstruments.length) {
                resizeMetricInstruments();
            }
            longGaugeMetricInstrument = new LongGaugeMetricInstrument(i, str, str2, str3, list, list2, z);
            this.metricInstruments[i] = longGaugeMetricInstrument;
            this.registeredMetricNames.add(str);
            this.nextAvailableMetricIndex++;
        }
        return longGaugeMetricInstrument;
    }

    private void resizeMetricInstruments() {
        MetricInstrument[] metricInstrumentArr = this.metricInstruments;
        this.metricInstruments = (MetricInstrument[]) Arrays.copyOf(metricInstrumentArr, metricInstrumentArr.length + 5);
    }
}
