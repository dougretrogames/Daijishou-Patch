package com.google.android.gms.common.api.internal;

/* INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zacf implements Runnable {
    public final /* synthetic */ NonGmsServiceBrokerClient zaa;

    public /* synthetic */ zacf(NonGmsServiceBrokerClient nonGmsServiceBrokerClient) {
        this.zaa = nonGmsServiceBrokerClient;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zaa.zab();
    }
}
