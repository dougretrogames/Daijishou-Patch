package com.magneticchen.daijishou.live_data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LauncherIntentResolveInfoListLiveData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002\u000f\u0010B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000e\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/live_data/LauncherIntentResolveInfoListLiveData;", "Landroidx/lifecycle/LiveData;", "", "Landroid/content/pm/ResolveInfo;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "packageManager", "Landroid/content/pm/PackageManager;", "packagesBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "onActive", "", "onInactive", "registerBroadcastReceiver", "Companion", "LauncherIntentResolveInfoBroadcastReceiver", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LauncherIntentResolveInfoListLiveData extends LiveData<List<? extends ResolveInfo>> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;
    private final PackageManager packageManager;
    private BroadcastReceiver packagesBroadcastReceiver;

    public LauncherIntentResolveInfoListLiveData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.context = applicationContext;
        PackageManager packageManager = context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        this.packageManager = packageManager;
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        setValue(this.packageManager.queryIntentActivities(INSTANCE.getLauncherIntent(), 0));
        registerBroadcastReceiver();
    }

    private final void registerBroadcastReceiver() {
        if (this.packagesBroadcastReceiver == null) {
            this.packagesBroadcastReceiver = new LauncherIntentResolveInfoBroadcastReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        this.context.registerReceiver(this.packagesBroadcastReceiver, intentFilter);
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        this.context.unregisterReceiver(this.packagesBroadcastReceiver);
    }

    /* JADX INFO: compiled from: LauncherIntentResolveInfoListLiveData.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/magneticchen/daijishou/live_data/LauncherIntentResolveInfoListLiveData$LauncherIntentResolveInfoBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/magneticchen/daijishou/live_data/LauncherIntentResolveInfoListLiveData;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class LauncherIntentResolveInfoBroadcastReceiver extends BroadcastReceiver {
        public LauncherIntentResolveInfoBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            LauncherIntentResolveInfoListLiveData launcherIntentResolveInfoListLiveData = LauncherIntentResolveInfoListLiveData.this;
            launcherIntentResolveInfoListLiveData.setValue(launcherIntentResolveInfoListLiveData.packageManager.queryIntentActivities(LauncherIntentResolveInfoListLiveData.INSTANCE.getLauncherIntent(), 0));
        }
    }

    /* JADX INFO: compiled from: LauncherIntentResolveInfoListLiveData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/live_data/LauncherIntentResolveInfoListLiveData$Companion;", "", "()V", "launcherIntent", "Landroid/content/Intent;", "getLauncherIntent", "()Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Intent getLauncherIntent() {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }
    }
}
