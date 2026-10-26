package io.opencensus.trace.export;

/* INFO: loaded from: classes4.dex */
public abstract class ExportComponent {
    public abstract RunningSpanStore getRunningSpanStore();

    public abstract SampledSpanStore getSampledSpanStore();

    public abstract SpanExporter getSpanExporter();

    public void shutdown() {
    }

    public static ExportComponent newNoopExportComponent() {
        return new NoopExportComponent(null);
    }

    private static final class NoopExportComponent extends ExportComponent {
        private final SampledSpanStore noopSampledSpanStore;

        private NoopExportComponent() {
            this.noopSampledSpanStore = SampledSpanStore.newNoopSampledSpanStore();
        }

        /* synthetic */ NoopExportComponent(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.opencensus.trace.export.ExportComponent
        public SpanExporter getSpanExporter() {
            return SpanExporter.getNoopSpanExporter();
        }

        @Override // io.opencensus.trace.export.ExportComponent
        public RunningSpanStore getRunningSpanStore() {
            return RunningSpanStore.getNoopRunningSpanStore();
        }

        @Override // io.opencensus.trace.export.ExportComponent
        public SampledSpanStore getSampledSpanStore() {
            return this.noopSampledSpanStore;
        }
    }
}
