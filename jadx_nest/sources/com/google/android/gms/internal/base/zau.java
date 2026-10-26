package com.google.android.gms.internal.base;

import android.os.Handler;
import android.os.Looper;

/* INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* INFO: loaded from: classes3.dex */
public class zau extends Handler {
    private final Looper zaa;

    public zau() {
        this.zaa = Looper.getMainLooper();
    }

    public zau(Looper looper) {
        super(looper);
        this.zaa = Looper.getMainLooper();
    }

    public zau(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.zaa = Looper.getMainLooper();
    }
}
