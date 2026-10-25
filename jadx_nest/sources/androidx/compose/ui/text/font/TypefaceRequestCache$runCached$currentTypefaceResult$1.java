package androidx.compose.ui.text.font;

import androidx.compose.ui.text.platform.SynchronizedObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: FontFamilyResolver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "finalResult", "Landroidx/compose/ui/text/font/TypefaceResult;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class TypefaceRequestCache$runCached$currentTypefaceResult$1 extends Lambda implements Function1<TypefaceResult, Unit> {
    final /* synthetic */ TypefaceRequest $typefaceRequest;
    final /* synthetic */ TypefaceRequestCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TypefaceRequestCache$runCached$currentTypefaceResult$1(TypefaceRequestCache typefaceRequestCache, TypefaceRequest typefaceRequest) {
        super(1);
        this.this$0 = typefaceRequestCache;
        this.$typefaceRequest = typefaceRequest;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TypefaceResult typefaceResult) {
        invoke2(typefaceResult);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TypefaceResult typefaceResult) {
        SynchronizedObject lock = this.this$0.getLock();
        TypefaceRequestCache typefaceRequestCache = this.this$0;
        TypefaceRequest typefaceRequest = this.$typefaceRequest;
        synchronized (lock) {
            if (typefaceResult.getCacheable()) {
                typefaceRequestCache.resultCache.put(typefaceRequest, typefaceResult);
            } else {
                typefaceRequestCache.resultCache.remove(typefaceRequest);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
