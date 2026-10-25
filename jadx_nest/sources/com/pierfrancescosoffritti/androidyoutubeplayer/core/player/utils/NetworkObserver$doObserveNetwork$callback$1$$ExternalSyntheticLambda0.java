package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class NetworkObserver$doObserveNetwork$callback$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ NetworkObserver f$0;

    public /* synthetic */ NetworkObserver$doObserveNetwork$callback$1$$ExternalSyntheticLambda0(NetworkObserver networkObserver) {
        this.f$0 = networkObserver;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NetworkObserver$doObserveNetwork$callback$1.onAvailable$lambda$1(this.f$0);
    }
}
