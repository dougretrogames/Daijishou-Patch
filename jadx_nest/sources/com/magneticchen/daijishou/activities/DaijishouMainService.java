package com.magneticchen.daijishou.activities;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.activities.abstract_classes.DaijishouService;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.logger.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.collections4.CollectionUtils;

/* INFO: compiled from: DaijishouMainService.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\"\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u001cH\u0016J\u0012\u0010#\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0006\u0010$\u001a\u00020\u0014J\b\u0010%\u001a\u00020\u0014H\u0002J\b\u0010&\u001a\u00020\u0014H\u0002J\b\u0010'\u001a\u00020\u0014H\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/magneticchen/daijishou/activities/DaijishouMainService;", "Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouService;", "()V", "binder", "Lcom/magneticchen/daijishou/activities/DaijishouMainService$LocalBinder;", "isServiceInForeground", "", "logger", "Lcom/magneticchen/daijishou/logger/Logger;", "getLogger", "()Lcom/magneticchen/daijishou/logger/Logger;", "setLogger", "(Lcom/magneticchen/daijishou/logger/Logger;)V", "notificationChannel", "Landroid/app/NotificationChannel;", "notificationManager", "Landroid/app/NotificationManager;", "onTaskRemovedTaskList", "", "Lkotlin/Function0;", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "", "flags", "startId", "onTaskRemoved", "rootIntent", "onTrimMemory", "level", "onUnbind", "saveLogsToFile", "setupLogger", "startForeground", "stopForeground", "LocalBinder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouMainService extends DaijishouService {
    private boolean isServiceInForeground;
    private Logger logger;
    private NotificationChannel notificationChannel;
    private NotificationManager notificationManager;
    private final List<Function0<Unit>> onTaskRemovedTaskList = new ArrayList();
    private final LocalBinder binder = new LocalBinder();

    public final Logger getLogger() {
        return this.logger;
    }

    public final void setLogger(Logger logger) {
        this.logger = logger;
    }

    /* INFO: compiled from: DaijishouMainService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/activities/DaijishouMainService$LocalBinder;", "Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouService$LocalBinder;", "Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouService;", "(Lcom/magneticchen/daijishou/activities/DaijishouMainService;)V", "getService", "Lcom/magneticchen/daijishou/activities/DaijishouMainService;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class LocalBinder extends DaijishouService.LocalBinder {
        public LocalBinder() {
            super();
        }


        @Override // com.magneticchen.daijishou.activities.abstract_classes.DaijishouService.LocalBinder
        public DaijishouMainService getService() {
            return DaijishouMainService.this;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Logger logger = this.logger;
        if (logger != null) {
            logger.info(this, "Daijishou main service onUnbind.");
        }
        Logger logger2 = this.logger;
        if (logger2 != null) {
            Logger.saveLogsToFile$default(logger2, Constants.loggerFilename, 0, 2, null);
        }
        return super.onUnbind(intent);
    }

    public final void saveLogsToFile() {
        Logger logger = this.logger;
        if (logger != null) {
            Logger.saveLogsToFile$default(logger, Constants.loggerFilename, 0, 2, null);
        }
    }

    private final void setupLogger() {
        this.logger = new Logger(this);
        if (!new File(getApplication().getFilesDir(), Constants.loggerFilename).exists()) {
            Logger logger = this.logger;
            Intrinsics.checkNotNull(logger);
            Logger.saveLogsToFile$default(logger, Constants.loggerFilename, 0, 2, null);
        }
        Logger logger2 = this.logger;
        Intrinsics.checkNotNull(logger2);
        logger2.appendLogsFromFile(Constants.loggerFilename);
        Logger logger3 = this.logger;
        Intrinsics.checkNotNull(logger3);
        logger3.info(this, "Logger has set up.");
    }

    @Override // com.magneticchen.daijishou.activities.abstract_classes.DaijishouService, android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle extras;
        boolean z = (intent == null || (extras = intent.getExtras()) == null) ? false : extras.getBoolean("startForeground");
        if (z && !this.isServiceInForeground) {
            startForeground();
        } else if (!z && this.isServiceInForeground) {
            stopForeground();
        }
        Logger logger = this.logger;
        if (logger == null) {
            return 2;
        }
        logger.info(this, "Daijishou main service onStartCommand.");
        return 2;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        setupLogger();
        Logger logger = this.logger;
        if (logger != null) {
            logger.info(this, "Daijishou main service created (" + Process.myPid() + CollectionUtils.COLON + Process.myTid() + ").");
        }
        this.notificationChannel = new NotificationChannel("daijishou", getString(R.string.app_name), 1);
        Object systemService = getSystemService(NotificationManager.class);
        Intrinsics.checkNotNullExpressionValue(systemService, "getSystemService(...)");
        NotificationManager notificationManager = (NotificationManager) systemService;
        this.notificationManager = notificationManager;
        NotificationChannel notificationChannel = null;
        if (notificationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
            notificationManager = null;
        }
        NotificationChannel notificationChannel2 = this.notificationChannel;
        if (notificationChannel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationChannel");
        } else {
            notificationChannel = notificationChannel2;
        }
        notificationManager.createNotificationChannel(notificationChannel);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Logger logger = this.logger;
        if (logger != null) {
            logger.info(this, "Daijishou main service onDestroy.");
        }
        Logger logger2 = this.logger;
        if (logger2 != null) {
            Logger.saveLogsToFile$default(logger2, Constants.loggerFilename, 0, 2, null);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level >= 5) {
            Logger logger = this.logger;
            if (logger != null) {
                logger.warn(this, "Daijishou main service onTrimMemory.");
            }
            Logger logger2 = this.logger;
            if (logger2 != null) {
                Logger.saveLogsToFile$default(logger2, Constants.loggerFilename, 0, 2, null);
            }
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        Logger logger = this.logger;
        if (logger != null) {
            logger.info(this, "Daijishou main service detects task removed.");
        }
        Logger logger2 = this.logger;
        if (logger2 != null) {
            Logger.saveLogsToFile$default(logger2, Constants.loggerFilename, 0, 2, null);
        }
    }

    private final void startForeground() {
        try {
            Notification notificationBuild = new Notification.Builder(this, "daijishou").setContentTitle(getString(R.string.daijishou_service_notification_content_title)).setContentText(getString(R.string.daijishou_service_notification_content_text)).setSmallIcon(R.drawable.ic_daijishou_notification).build();
            Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
            startForeground(1, notificationBuild);
            this.isServiceInForeground = true;
        } catch (Exception e) {
            Logger logger = this.logger;
            if (logger != null) {
                logger.error(this, ExceptionsKt.stackTraceToString(e));
            }
        }
    }

    private final void stopForeground() {
        Logger logger = this.logger;
        if (logger != null) {
            logger.info(this, "Daijishou main service stopForeground.");
        }
        stopForeground(2);
        NotificationManager notificationManager = this.notificationManager;
        if (notificationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
            notificationManager = null;
        }
        notificationManager.cancel(1);
        this.isServiceInForeground = false;
    }
}
