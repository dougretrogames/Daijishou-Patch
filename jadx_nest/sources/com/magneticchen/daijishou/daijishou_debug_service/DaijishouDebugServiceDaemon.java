package com.magneticchen.daijishou.daijishou_debug_service;

import android.content.Intent;
import com.magneticchen.daijishou.DaijishouApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DaijishouDebugServiceDaemon.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_debug_service/DaijishouDebugServiceDaemon;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "start", "", "stop", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouDebugServiceDaemon {
    private final DaijishouApplication application;

    public DaijishouDebugServiceDaemon(DaijishouApplication application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    public final void start() {
        this.application.startForegroundService(new Intent(this.application.getBaseContext(), (Class<?>) DaijishouDebugService.class));
    }

    public final void stop() {
        this.application.stopService(new Intent(this.application.getBaseContext(), (Class<?>) DaijishouDebugService.class));
    }
}
