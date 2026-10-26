package io.grpc;

import java.util.List;

/* INFO: loaded from: classes4.dex */
public final class LongHistogramMetricInstrument extends PartialMetricInstrument {
    private final List<Long> bucketBoundaries;

    @Override // io.grpc.PartialMetricInstrument, io.grpc.MetricInstrument
    public /* bridge */ /* synthetic */ String getDescription() {
        return super.getDescription();
    }

    @Override // io.grpc.PartialMetricInstrument, io.grpc.MetricInstrument
    public /* bridge */ /* synthetic */ int getIndex() {
        return super.getIndex();
    }

    @Override // io.grpc.PartialMetricInstrument, io.grpc.MetricInstrument
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // io.grpc.PartialMetricInstrument, io.grpc.MetricInstrument
    public /* bridge */ /* synthetic */ List getOptionalLabelKeys() {
        return super.getOptionalLabelKeys();
    }

    @Override // io.grpc.PartialMetricInstrument, io.grpc.MetricInstrument
    public /* bridge */ /* synthetic */ List getRequiredLabelKeys() {
        return super.getRequiredLabelKeys();
    }

    @Override // io.grpc.PartialMetricInstrument, io.grpc.MetricInstrument
    public /* bridge */ /* synthetic */ String getUnit() {
        return super.getUnit();
    }

    @Override // io.grpc.PartialMetricInstrument, io.grpc.MetricInstrument
    public /* bridge */ /* synthetic */ boolean isEnableByDefault() {
        return super.isEnableByDefault();
    }

    @Override // io.grpc.PartialMetricInstrument
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public LongHistogramMetricInstrument(int i, String str, String str2, String str3, List<Long> list, List<String> list2, List<String> list3, boolean z) {
        super(i, str, str2, str3, list2, list3, z);
        this.bucketBoundaries = list;
    }

    public List<Long> getBucketBoundaries() {
        return this.bucketBoundaries;
    }
}
