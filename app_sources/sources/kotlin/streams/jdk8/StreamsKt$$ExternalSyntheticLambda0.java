package kotlin.streams.jdk8;

import java.util.function.Supplier;
import kotlin.sequences.Sequence;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class StreamsKt$$ExternalSyntheticLambda0 implements Supplier {
    public final /* synthetic */ Sequence f$0;

    public /* synthetic */ StreamsKt$$ExternalSyntheticLambda0(Sequence sequence) {
        this.f$0 = sequence;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return StreamsKt.asStream$lambda$4(this.f$0);
    }
}
