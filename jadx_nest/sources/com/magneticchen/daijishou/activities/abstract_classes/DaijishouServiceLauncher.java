package com.magneticchen.daijishou.activities.abstract_classes;

import android.content.Intent;
import android.content.ServiceConnection;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.activities.DaijishouMainService;
import com.magneticchen.daijishou.activities.abstract_classes.DaijishouService;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: DaijishouServiceLauncher.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\f2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\fH\u0002J\u000e\u00103\u001a\u00020,2\u0006\u0010\u0017\u001a\u00020\fJ\u0006\u00104\u001a\u00020,R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u00060\u0012R\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\u00020\"¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000e\"\u0004\b)\u0010\u0010R\u000e\u0010*\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouServiceLauncher;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouService;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "serviceClass", "Ljava/lang/Class;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/Class;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "hasSetup", "", "getHasSetup", "()Z", "setHasSetup", "(Z)V", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "maxRetriedCount", "", "preferredInForeground", "retriedCount", NotificationCompat.CATEGORY_SERVICE, "getService", "()Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouService;", "setService", "(Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouService;)V", "Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouService;", "getServiceClass", "()Ljava/lang/Class;", "serviceConnection", "Landroid/content/ServiceConnection;", "getServiceConnection$annotations", "()V", "getServiceConnection", "()Landroid/content/ServiceConnection;", "startedInForeground", "getStartedInForeground", "setStartedInForeground", "stoppedByLauncher", "notifyUpgradeChance", "", "startInBackground", "intent", "Landroid/content/Intent;", "startInForeground", "startOrUpgradeService", "isAStart", "startService", "stopService", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouServiceLauncher<T extends DaijishouService> {
    private final DaijishouApplication application;
    private boolean hasSetup;
    private final DaijishouApplication.WrappedLogger logger;
    private final int maxRetriedCount;
    private boolean preferredInForeground;
    private int retriedCount;
    private T service;
    private final Class<? extends T> serviceClass;
    private final ServiceConnection serviceConnection;
    private boolean startedInForeground;
    private boolean stoppedByLauncher;

    public static /* synthetic */ void getServiceConnection$annotations() {
    }

    public DaijishouServiceLauncher(DaijishouApplication application, Class<? extends T> serviceClass) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(serviceClass, "serviceClass");
        this.application = application;
        this.serviceClass = serviceClass;
        this.logger = application.getLogger();
        this.maxRetriedCount = 3;
        this.serviceConnection = new DaijishouServiceLauncher$serviceConnection$1(this);
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    public final Class<? extends T> getServiceClass() {
        return this.serviceClass;
    }

    public final DaijishouApplication.WrappedLogger getLogger() {
        return this.logger;
    }

    public final boolean getStartedInForeground() {
        return this.startedInForeground;
    }

    public final void setStartedInForeground(boolean z) {
        this.startedInForeground = z;
    }

    public final boolean getHasSetup() {
        return this.hasSetup;
    }

    public final void setHasSetup(boolean z) {
        this.hasSetup = z;
    }

    public final ServiceConnection getServiceConnection() {
        return this.serviceConnection;
    }

    public final T getService() {
        return this.service;
    }

    public final void setService(T t) {
        this.service = t;
    }

    private final boolean startInBackground(Intent intent) {
        try {
            this.logger.info(this, "Trying to start Daijishou service(" + this.serviceClass + ") in background.");
            this.startedInForeground = false;
            intent.putExtra("startForeground", false);
            this.application.startService(intent);
            return true;
        } catch (Exception e) {
            this.logger.warn(this, ExceptionsKt.stackTraceToString(e));
            this.logger.warn(this, "Daijishou service(" + this.serviceClass + ") setup failed in background.");
            return false;
        }
    }

    private final boolean startInForeground(Intent intent) {
        try {
            this.logger.info(this, "Trying to start Daijishou service(" + this.serviceClass + ") in foreground.");
            this.startedInForeground = true;
            intent.putExtra("startForeground", true);
            this.application.startForegroundService(intent);
            return true;
        } catch (Exception e) {
            this.logger.warn(this, ExceptionsKt.stackTraceToString(e));
            this.logger.warn(this, "Daijishou service(" + this.serviceClass + ") setup failed in foreground.");
            return false;
        }
    }

    public final void startService(boolean preferredInForeground) {
        this.preferredInForeground = preferredInForeground;
        this.stoppedByLauncher = false;
        startOrUpgradeService(true);
    }

    public final void notifyUpgradeChance() {
        this.logger.info(this, "Notified Daijishou service(" + this.serviceClass + ") it has an upgrade chance.");
        startOrUpgradeService(false);
    }

    private final void startOrUpgradeService(boolean isAStart) {
        int i;
        if (isAStart || !this.stoppedByLauncher) {
            if (!(this.hasSetup && this.startedInForeground == this.preferredInForeground) && (i = this.retriedCount) < this.maxRetriedCount) {
                this.retriedCount = i + 1;
                Intent intent = new Intent(this.application.getBaseContext(), this.serviceClass);
                this.application.bindService(intent, this.serviceConnection, 1);
                if (this.preferredInForeground) {
                    boolean zStartInForeground = startInForeground(intent);
                    this.hasSetup = zStartInForeground;
                    if (zStartInForeground) {
                        this.retriedCount = 0;
                        return;
                    } else {
                        this.hasSetup = startInBackground(intent);
                        return;
                    }
                }
                boolean zStartInBackground = startInBackground(intent);
                this.hasSetup = zStartInBackground;
                if (zStartInBackground) {
                    this.retriedCount = 0;
                } else {
                    this.hasSetup = startInForeground(intent);
                }
            }
        }
    }

    public final void stopService() {
        if (this.hasSetup) {
            this.logger.info(this, "Trying to stop Daijishou service(" + this.serviceClass + ").");
            T t = this.service;
            if (t instanceof DaijishouMainService) {
                ((DaijishouMainService) t).saveLogsToFile();
            }
            this.application.unbindService(this.serviceConnection);
            this.application.stopService(new Intent(this.application.getBaseContext(), this.serviceClass));
            this.service = null;
            this.hasSetup = false;
            this.stoppedByLauncher = true;
        }
    }
}
