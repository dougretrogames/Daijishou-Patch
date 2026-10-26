package com.magneticchen.daijishou.activities.abstract_classes;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import kotlin.Metadata;

/* INFO: compiled from: DaijishouService.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouService;", "Landroid/app/Service;", "()V", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "LocalBinder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class DaijishouService extends Service {

    /* INFO: compiled from: DaijishouService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouService$LocalBinder;", "Landroid/os/Binder;", "(Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouService;)V", "getService", "Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouService;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public abstract class LocalBinder extends Binder {
        public abstract DaijishouService getService();

        public LocalBinder() {
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
