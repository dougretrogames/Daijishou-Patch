package org.apache.commons.io.input;

import org.apache.commons.io.function.IOSupplier;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class SequenceReader$$ExternalSyntheticLambda0 implements IOSupplier {
    public final /* synthetic */ SequenceReader f$0;

    public /* synthetic */ SequenceReader$$ExternalSyntheticLambda0(SequenceReader sequenceReader) {
        this.f$0 = sequenceReader;
    }

    @Override // org.apache.commons.io.function.IOSupplier
    public final Object get() {
        return this.f$0.nextReader();
    }
}
