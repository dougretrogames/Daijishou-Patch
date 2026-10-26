package io.grpc;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;

/* INFO: loaded from: classes4.dex */
abstract class PartialMetricInstrument implements MetricInstrument {
    protected final String description;
    protected final boolean enableByDefault;
    protected final int index;
    protected final String name;
    protected final List<String> optionalLabelKeys;
    protected final List<String> requiredLabelKeys;
    protected final String unit;

    protected PartialMetricInstrument(int i, String str, String str2, String str3, List<String> list, List<String> list2, boolean z) {
        this.index = i;
        this.name = str;
        this.description = str2;
        this.unit = str3;
        this.requiredLabelKeys = ImmutableList.copyOf((Collection) list);
        this.optionalLabelKeys = ImmutableList.copyOf((Collection) list2);
        this.enableByDefault = z;
    }

    @Override // io.grpc.MetricInstrument
    public int getIndex() {
        return this.index;
    }

    @Override // io.grpc.MetricInstrument
    public String getName() {
        return this.name;
    }

    @Override // io.grpc.MetricInstrument
    public String getDescription() {
        return this.description;
    }

    @Override // io.grpc.MetricInstrument
    public String getUnit() {
        return this.unit;
    }

    @Override // io.grpc.MetricInstrument
    public List<String> getRequiredLabelKeys() {
        return this.requiredLabelKeys;
    }

    @Override // io.grpc.MetricInstrument
    public List<String> getOptionalLabelKeys() {
        return this.optionalLabelKeys;
    }

    @Override // io.grpc.MetricInstrument
    public boolean isEnableByDefault() {
        return this.enableByDefault;
    }

    public String toString() {
        return getClass().getName() + "(" + getName() + ")";
    }
}
