package androidx.window.embedding;

import android.util.Pair;
import java.util.Set;
import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class EmbeddingAdapter$$ExternalSyntheticLambda3 implements Predicate {
    public final /* synthetic */ EmbeddingAdapter f$0;
    public final /* synthetic */ Set f$1;

    public /* synthetic */ EmbeddingAdapter$$ExternalSyntheticLambda3(EmbeddingAdapter embeddingAdapter, Set set) {
        this.f$0 = embeddingAdapter;
        this.f$1 = set;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return EmbeddingAdapter.m3241translateActivityIntentPredicates$lambda3(this.f$0, this.f$1, (Pair) obj);
    }
}
