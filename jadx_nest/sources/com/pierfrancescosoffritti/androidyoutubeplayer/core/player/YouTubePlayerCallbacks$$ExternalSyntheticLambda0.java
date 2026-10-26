package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class YouTubePlayerCallbacks$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ YouTubePlayerCallbacks f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ YouTubePlayerCallbacks$$ExternalSyntheticLambda0(YouTubePlayerCallbacks youTubePlayerCallbacks, long j, boolean z) {
        this.f$0 = youTubePlayerCallbacks;
        this.f$1 = j;
        this.f$2 = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        YouTubePlayerCallbacks.sendBooleanValue$lambda$0(this.f$0, this.f$1, this.f$2);
    }
}
