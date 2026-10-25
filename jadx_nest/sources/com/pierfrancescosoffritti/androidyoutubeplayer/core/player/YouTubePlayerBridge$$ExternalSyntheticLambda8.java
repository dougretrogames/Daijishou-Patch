package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class YouTubePlayerBridge$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ YouTubePlayerBridge f$0;
    public final /* synthetic */ float f$1;

    public /* synthetic */ YouTubePlayerBridge$$ExternalSyntheticLambda8(YouTubePlayerBridge youTubePlayerBridge, float f) {
        this.f$0 = youTubePlayerBridge;
        this.f$1 = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        YouTubePlayerBridge.sendVideoLoadedFraction$lambda$18(this.f$0, this.f$1);
    }
}
