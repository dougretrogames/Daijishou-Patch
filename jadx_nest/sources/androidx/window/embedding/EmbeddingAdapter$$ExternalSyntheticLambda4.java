package androidx.window.embedding;

import android.app.Activity;
import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class EmbeddingAdapter$$ExternalSyntheticLambda4 implements Predicate {
    public final /* synthetic */ Set f$0;

    public /* synthetic */ EmbeddingAdapter$$ExternalSyntheticLambda4(Set set) {
        this.f$0 = set;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return EmbeddingAdapter.m3243translateActivityPredicates$lambda6(this.f$0, (Activity) obj);
    }
}
