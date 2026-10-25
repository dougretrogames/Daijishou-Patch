package io.grpc;

/* JADX INFO: loaded from: classes4.dex */
public final class InternalManagedChannelBuilder {

    public interface InternalInterceptorFactory extends ManagedChannelBuilder.InterceptorFactory {
    }

    private InternalManagedChannelBuilder() {
    }

    public static <T extends ManagedChannelBuilder<T>> T interceptWithTarget(ManagedChannelBuilder<T> managedChannelBuilder, InternalInterceptorFactory internalInterceptorFactory) {
        return (T) managedChannelBuilder.interceptWithTarget(internalInterceptorFactory);
    }

    public static <T extends ManagedChannelBuilder<T>> T addMetricSink(ManagedChannelBuilder<T> managedChannelBuilder, MetricSink metricSink) {
        return (T) managedChannelBuilder.addMetricSink(metricSink);
    }
}
