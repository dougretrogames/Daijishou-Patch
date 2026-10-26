package androidx.compose.ui.text.font;

import androidx.core.content.res.ResourcesCompat;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

/* INFO: compiled from: AndroidFontLoader.android.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"androidx/compose/ui/text/font/AndroidFontLoader_androidKt$loadAsync$2$1", "Landroidx/core/content/res/ResourcesCompat$FontCallback;", "onFontRetrievalFailed", "", "reason", "", "onFontRetrieved", "typeface", "Landroid/graphics/Typeface;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidFontLoader_androidKt$loadAsync$2$1 extends ResourcesCompat.FontCallback {
    final /* synthetic */ CancellableContinuation<android.graphics.Typeface> $continuation;
    final /* synthetic */ ResourceFont $this_loadAsync;

    /* WARN: Multi-variable type inference failed */
    AndroidFontLoader_androidKt$loadAsync$2$1(CancellableContinuation<? super android.graphics.Typeface> cancellableContinuation, ResourceFont resourceFont) {
        this.$continuation = cancellableContinuation;
        this.$this_loadAsync = resourceFont;
    }

    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
    /* INFO: renamed from: onFontRetrieved */
    public void m3151x46c88379(android.graphics.Typeface typeface) {
        CancellableContinuation<android.graphics.Typeface> cancellableContinuation = this.$continuation;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m3752constructorimpl(typeface));
    }

    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
    /* INFO: renamed from: onFontRetrievalFailed */
    public void m3150xb24343b7(int reason) {
        this.$continuation.cancel(new IllegalStateException("Unable to load font " + this.$this_loadAsync + " (reason=" + reason + ')'));
    }
}
