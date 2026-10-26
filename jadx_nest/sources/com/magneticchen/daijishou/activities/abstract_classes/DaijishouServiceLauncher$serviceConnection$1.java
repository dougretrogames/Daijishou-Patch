package com.magneticchen.daijishou.activities.abstract_classes;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: DaijishouServiceLauncher.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/magneticchen/daijishou/activities/abstract_classes/DaijishouServiceLauncher$serviceConnection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "className", "Landroid/content/ComponentName;", "iBinder", "Landroid/os/IBinder;", "onServiceDisconnected", "arg0", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouServiceLauncher$serviceConnection$1 implements ServiceConnection {
    final /* synthetic */ DaijishouServiceLauncher this$0;

    DaijishouServiceLauncher$serviceConnection$1(DaijishouServiceLauncher daijishouServiceLauncher) {
        this.this$0 = daijishouServiceLauncher;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName className, IBinder iBinder) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(iBinder, "iBinder");
        DaijishouServiceLauncher daijishouServiceLauncher = this.this$0;
        DaijishouService this$0 = ((DaijishouService.LocalBinder) iBinder).getService();
        Intrinsics.checkNotNull(this$0, "null cannot be cast to non-null type T of com.magneticchen.daijishou.activities.abstract_classes.DaijishouServiceLauncher");
        daijishouServiceLauncher.setService(this$0);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName arg0) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        this.this$0.setService(null);
    }
}
