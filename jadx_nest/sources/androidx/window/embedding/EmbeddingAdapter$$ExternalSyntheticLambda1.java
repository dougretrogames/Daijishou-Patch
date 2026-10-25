package androidx.window.embedding;

import android.view.WindowMetrics;
import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class EmbeddingAdapter$$ExternalSyntheticLambda1 implements Predicate {
    public final /* synthetic */ SplitRule f$0;

    public /* synthetic */ EmbeddingAdapter$$ExternalSyntheticLambda1(SplitRule splitRule) {
        this.f$0 = splitRule;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return EmbeddingAdapter.m3245translateParentMetricsPredicate$lambda4(this.f$0, (WindowMetrics) obj);
    }
}
