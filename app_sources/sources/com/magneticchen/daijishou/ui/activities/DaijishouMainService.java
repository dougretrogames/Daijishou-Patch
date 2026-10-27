package com.magneticchen.daijishou.ui.activities;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.logger.Logger;
import com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouService;
import java.io.File;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DaijishouMainService.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\"\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0016J\u0012\u0010\"\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u001fH\u0016J\u0012\u0010&\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0006\u0010'\u001a\u00020\u001cJ\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015¨\u0006+"}, d2 = {"Lcom/magneticchen/daijishou/ui/activities/DaijishouMainService;", "Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouService;", "()V", "binder", "Lcom/magneticchen/daijishou/ui/activities/DaijishouMainService$LocalBinder;", "isServiceInForeground", "", "logger", "Lcom/magneticchen/daijishou/logger/Logger;", "getLogger", "()Lcom/magneticchen/daijishou/logger/Logger;", "logger$delegate", "Lkotlin/Lazy;", "notificationChannel", "Landroid/app/NotificationChannel;", "getNotificationChannel", "()Landroid/app/NotificationChannel;", "notificationChannel$delegate", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "()Landroid/app/NotificationManager;", "notificationManager$delegate", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "", "flags", "startId", "onTaskRemoved", "rootIntent", "onTrimMemory", "level", "onUnbind", "saveLogsToFile", "startForeground", "stopForeground", "LocalBinder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouMainService extends DaijishouService {
    private boolean isServiceInForeground;
    private final LocalBinder binder = new LocalBinder();
    private final Lazy notificationChannel$delegate = LazyKt.lazy(new Function0<NotificationChannel>() { // from class: com.magneticchen.daijishou.ui.activities.DaijishouMainService$notificationChannel$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NotificationChannel invoke() {
            return new NotificationChannel("daijishou", DaijishouMainService.this.getString(R.string.app_name), 1);
        }
    });
    private final Lazy notificationManager$delegate = LazyKt.lazy(new Function0<NotificationManager>() { // from class: com.magneticchen.daijishou.ui.activities.DaijishouMainService$notificationManager$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NotificationManager invoke() {
            return (NotificationManager) DaijishouMainService.this.getSystemService(NotificationManager.class);
        }
    });
    private final Lazy logger$delegate = LazyKt.lazy(new Function0<Logger>() { // from class: com.magneticchen.daijishou.ui.activities.DaijishouMainService$logger$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Logger invoke() {
            return new Logger(DaijishouMainService.this);
        }
    });

    private final NotificationChannel getNotificationChannel() {
        return (NotificationChannel) this.notificationChannel$delegate.getValue();
    }

    private final NotificationManager getNotificationManager() {
        Object value = this.notificationManager$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (NotificationManager) value;
    }

    public final Logger getLogger() {
        return (Logger) this.logger$delegate.getValue();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (!new File(getApplication().getFilesDir(), Constants.loggerFilename).exists()) {
            Logger.saveLogsToFile$default(getLogger(), Constants.loggerFilename, 0, 2, null);
        }
        getLogger().appendLogsFromFile(Constants.loggerFilename);
        getLogger().info(this, "Logger has been configured.");
        getLogger().info(this, "Daijishou main service created (" + Process.myPid() + ":" + Process.myTid() + ").");
        getNotificationManager().createNotificationChannel(getNotificationChannel());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        getLogger().info(this, "Daijishou main service onDestroy.");
        Logger.saveLogsToFile$default(getLogger(), Constants.loggerFilename, 0, 2, null);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        getLogger().info(this, "Daijishou main service onUnbind.");
        Logger.saveLogsToFile$default(getLogger(), Constants.loggerFilename, 0, 2, null);
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Bundle extras;
        boolean z = (intent == null || (extras = intent.getExtras()) == null) ? false : extras.getBoolean("startForeground");
        if (z && !this.isServiceInForeground) {
            startForeground();
        } else if (!z && this.isServiceInForeground) {
            stopForeground();
        }
        getLogger().info(this, "Daijishou main service onStartCommand.");
        return 2;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (i >= 5) {
            getLogger().warn(this, "Daijishou main service onTrimMemory.");
            Logger.saveLogsToFile$default(getLogger(), Constants.loggerFilename, 0, 2, null);
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        getLogger().info(this, "Daijishou main service detects task removed.");
        Logger.saveLogsToFile$default(getLogger(), Constants.loggerFilename, 0, 2, null);
    }

    private final void startForeground() {
        try {
            Notification notificationBuild = new Notification.Builder(this, "daijishou").setContentTitle(getString(R.string.daijishou_service_notification_content_title)).setContentText(getString(R.string.daijishou_service_notification_content_text)).setSmallIcon(R.drawable.ic_daijishou_notification).setVisibility(-1).build();
            Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
            startForeground(1, notificationBuild);
            this.isServiceInForeground = true;
        } catch (Exception e) {
            getLogger().error(this, ExceptionsKt.stackTraceToString(e));
        }
    }

    private final void stopForeground() {
        getLogger().info(this, "Daijishou main service stopForeground.");
        stopForeground(2);
        getNotificationManager().cancel(1);
        this.isServiceInForeground = false;
    }

    public final void saveLogsToFile() {
        Logger.saveLogsToFile$default(getLogger(), Constants.loggerFilename, 0, 2, null);
    }

    /* JADX INFO: compiled from: DaijishouMainService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/ui/activities/DaijishouMainService$LocalBinder;", "Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouService$LocalBinder;", "Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouService;", "(Lcom/magneticchen/daijishou/ui/activities/DaijishouMainService;)V", "getService", "Lcom/magneticchen/daijishou/ui/activities/DaijishouMainService;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class LocalBinder extends DaijishouService.LocalBinder {
        public LocalBinder() {
            super();
        }

        @Override // com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouService.LocalBinder
        public DaijishouMainService getService() {
            return DaijishouMainService.this;
        }
    }
}
