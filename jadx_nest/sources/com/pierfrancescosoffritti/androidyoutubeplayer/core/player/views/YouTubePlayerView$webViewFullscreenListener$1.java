package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import android.view.View;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YouTubePlayerView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView$webViewFullscreenListener$1", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/FullscreenListener;", "onEnterFullscreen", "", "fullscreenView", "Landroid/view/View;", "exitFullscreen", "Lkotlin/Function0;", "onExitFullscreen", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class YouTubePlayerView$webViewFullscreenListener$1 implements FullscreenListener {
    final /* synthetic */ YouTubePlayerView this$0;

    YouTubePlayerView$webViewFullscreenListener$1(YouTubePlayerView youTubePlayerView) {
        this.this$0 = youTubePlayerView;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
    public void onEnterFullscreen(View fullscreenView, Function0<Unit> exitFullscreen) {
        Intrinsics.checkNotNullParameter(fullscreenView, "fullscreenView");
        Intrinsics.checkNotNullParameter(exitFullscreen, "exitFullscreen");
        if (this.this$0.fullscreenListeners.isEmpty()) {
            throw new IllegalStateException("To enter fullscreen you need to first register a FullscreenListener.");
        }
        Iterator it = this.this$0.fullscreenListeners.iterator();
        while (it.hasNext()) {
            ((FullscreenListener) it.next()).onEnterFullscreen(fullscreenView, exitFullscreen);
        }
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
    public void onExitFullscreen() {
        if (this.this$0.fullscreenListeners.isEmpty()) {
            throw new IllegalStateException("To enter fullscreen you need to first register a FullscreenListener.");
        }
        Iterator it = this.this$0.fullscreenListeners.iterator();
        while (it.hasNext()) {
            ((FullscreenListener) it.next()).onExitFullscreen();
        }
    }
}
