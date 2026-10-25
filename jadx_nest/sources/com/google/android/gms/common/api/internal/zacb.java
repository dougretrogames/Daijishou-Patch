package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zacb implements Runnable {
    public final /* synthetic */ ListenerHolder zaa;
    public final /* synthetic */ ListenerHolder.Notifier zab;

    public /* synthetic */ zacb(ListenerHolder listenerHolder, ListenerHolder.Notifier notifier) {
        this.zaa = listenerHolder;
        this.zab = notifier;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zaa.zaa(this.zab);
    }
}
