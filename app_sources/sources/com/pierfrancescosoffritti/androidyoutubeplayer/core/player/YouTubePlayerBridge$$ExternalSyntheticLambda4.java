package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class YouTubePlayerBridge$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ YouTubePlayerBridge f$0;
    public final /* synthetic */ PlayerConstants.PlaybackRate f$1;

    public /* synthetic */ YouTubePlayerBridge$$ExternalSyntheticLambda4(YouTubePlayerBridge youTubePlayerBridge, PlayerConstants.PlaybackRate playbackRate) {
        this.f$0 = youTubePlayerBridge;
        this.f$1 = playbackRate;
    }

    @Override // java.lang.Runnable
    public final void run() {
        YouTubePlayerBridge.sendPlaybackRateChange$lambda$8(this.f$0, this.f$1);
    }
}
