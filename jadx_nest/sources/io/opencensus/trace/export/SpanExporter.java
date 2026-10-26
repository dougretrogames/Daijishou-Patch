package io.opencensus.trace.export;

import java.util.Collection;

/* INFO: loaded from: classes4.dex */
public abstract class SpanExporter {
    private static final SpanExporter NOOP_SPAN_EXPORTER = new NoopSpanExporter(null);

    public static abstract class Handler {
        public abstract void export(Collection<SpanData> collection);
    }

    public abstract void registerHandler(String str, Handler handler);

    public abstract void unregisterHandler(String str);

    public static SpanExporter getNoopSpanExporter() {
        return NOOP_SPAN_EXPORTER;
    }

    private static final class NoopSpanExporter extends SpanExporter {
        @Override // io.opencensus.trace.export.SpanExporter
        public void registerHandler(String str, Handler handler) {
        }

        @Override // io.opencensus.trace.export.SpanExporter
        public void unregisterHandler(String str) {
        }

        private NoopSpanExporter() {
        }

        /* synthetic */ NoopSpanExporter(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
