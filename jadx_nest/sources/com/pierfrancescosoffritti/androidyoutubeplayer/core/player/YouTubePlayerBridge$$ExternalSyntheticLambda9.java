package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class YouTubePlayerBridge$$ExternalSyntheticLambda9 implements Runnable {
    public final /* synthetic */ YouTubePlayerBridge f$0;
    public final /* synthetic */ PlayerConstants.PlayerError f$1;

    public /* synthetic */ YouTubePlayerBridge$$ExternalSyntheticLambda9(YouTubePlayerBridge youTubePlayerBridge, PlayerConstants.PlayerError playerError) {
        this.f$0 = youTubePlayerBridge;
        this.f$1 = playerError;
    }

    @Override // java.lang.Runnable
    public final void run() {
        YouTubePlayerBridge.sendError$lambda$10(this.f$0, this.f$1);
    }
}
