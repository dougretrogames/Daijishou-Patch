package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* INFO: compiled from: YouTubePlayerExt.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isMuted", "", "accept"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class YouTubePlayerExtKt$isMuted$2$1 implements BooleanProvider {
    final /* synthetic */ Continuation<Boolean> $continuation;

    /* WARN: Multi-variable type inference failed */
    YouTubePlayerExtKt$isMuted$2$1(Continuation<? super Boolean> continuation) {
        this.$continuation = continuation;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.BooleanProvider
    public final void accept(boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        Continuation<Boolean> continuation = this.$continuation;
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m3752constructorimpl(boolValueOf));
    }
}
