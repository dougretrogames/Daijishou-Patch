package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class YouTubePlayerBridge$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ YouTubePlayerBridge f$0;

    public /* synthetic */ YouTubePlayerBridge$$ExternalSyntheticLambda1(YouTubePlayerBridge youTubePlayerBridge) {
        this.f$0 = youTubePlayerBridge;
    }

    @Override // java.lang.Runnable
    public final void run() {
        YouTubePlayerBridge.sendYouTubeIFrameAPIReady$lambda$0(this.f$0);
    }
}
