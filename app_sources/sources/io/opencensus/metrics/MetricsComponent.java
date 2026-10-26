package io.opencensus.metrics;

import io.opencensus.metrics.export.ExportComponent;

/* INFO: loaded from: classes4.dex */
public abstract class MetricsComponent {
    public abstract ExportComponent getExportComponent();

    public abstract MetricRegistry getMetricRegistry();

    static MetricsComponent newNoopMetricsComponent() {
        return new NoopMetricsComponent(null);
    }

    private static final class NoopMetricsComponent extends MetricsComponent {
        private static final ExportComponent EXPORT_COMPONENT = ExportComponent.newNoopExportComponent();
        private static final MetricRegistry METRIC_REGISTRY = MetricRegistry.newNoopMetricRegistry();

        private NoopMetricsComponent() {
        }

        /* synthetic */ NoopMetricsComponent(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.opencensus.metrics.MetricsComponent
        public ExportComponent getExportComponent() {
            return EXPORT_COMPONENT;
        }

        @Override // io.opencensus.metrics.MetricsComponent
        public MetricRegistry getMetricRegistry() {
            return METRIC_REGISTRY;
        }
    }
}
