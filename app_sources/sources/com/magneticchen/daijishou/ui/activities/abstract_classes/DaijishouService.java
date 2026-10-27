package com.magneticchen.daijishou.ui.activities.abstract_classes;

import android.app.Service;
import android.os.Binder;
import kotlin.Metadata;

/* JADX INFO: compiled from: DaijishouService.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouService;", "Landroid/app/Service;", "()V", "LocalBinder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class DaijishouService extends Service {

    /* JADX INFO: compiled from: DaijishouService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouService$LocalBinder;", "Landroid/os/Binder;", "(Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouService;)V", "getService", "Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouService;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public abstract class LocalBinder extends Binder {
        public abstract DaijishouService getService();

        public LocalBinder() {
        }
    }
}
