package androidx.window.embedding;

import android.content.Intent;
import java.util.Set;
import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class EmbeddingAdapter$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ Set f$0;

    public /* synthetic */ EmbeddingAdapter$$ExternalSyntheticLambda0(Set set) {
        this.f$0 = set;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return EmbeddingAdapter.m3244translateIntentPredicates$lambda8(this.f$0, (Intent) obj);
    }
}
