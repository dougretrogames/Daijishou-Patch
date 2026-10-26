package com.magneticchen.daijishou.daijishou_debug_service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.magneticchen.daijishou.DaijishouApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: DaijishouDebugService.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_debug_service/DaijishouDebugServiceBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouDebugServiceBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (intent != null) {
            intent.getStringExtra("MESSAGE");
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) applicationContext).getDaijishouDebugServiceLauncher().stopService();
    }
}
