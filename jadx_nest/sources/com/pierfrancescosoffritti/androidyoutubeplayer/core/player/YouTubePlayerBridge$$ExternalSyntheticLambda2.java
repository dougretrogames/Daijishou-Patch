package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class YouTubePlayerBridge$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ YouTubePlayerBridge f$0;
    public final /* synthetic */ PlayerConstants.PlaybackQuality f$1;

    public /* synthetic */ YouTubePlayerBridge$$ExternalSyntheticLambda2(YouTubePlayerBridge youTubePlayerBridge, PlayerConstants.PlaybackQuality playbackQuality) {
        this.f$0 = youTubePlayerBridge;
        this.f$1 = playbackQuality;
    }

    @Override // java.lang.Runnable
    public final void run() {
        YouTubePlayerBridge.sendPlaybackQualityChange$lambda$6(this.f$0, this.f$1);
    }
}
