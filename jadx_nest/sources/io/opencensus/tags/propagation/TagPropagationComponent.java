package io.opencensus.tags.propagation;

/* INFO: loaded from: classes4.dex */
public abstract class TagPropagationComponent {
    public abstract TagContextBinarySerializer getBinarySerializer();

    public abstract TagContextTextFormat getCorrelationContextFormat();
}
