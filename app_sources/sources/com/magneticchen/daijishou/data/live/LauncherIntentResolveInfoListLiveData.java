package com.magneticchen.daijishou.data.live;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LauncherIntentResolveInfoListLiveData.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002\u0016\u0017B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0015\u001a\u00020\u0013H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/magneticchen/daijishou/data/live/LauncherIntentResolveInfoListLiveData;", "Landroidx/lifecycle/LiveData;", "", "Landroid/content/pm/ResolveInfo;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "packageManager", "Landroid/content/pm/PackageManager;", "getPackageManager", "()Landroid/content/pm/PackageManager;", "packageManager$delegate", "packagesBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "onActive", "", "onInactive", "registerBroadcastReceiver", "Companion", "LauncherIntentResolveInfoBroadcastReceiver", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LauncherIntentResolveInfoListLiveData extends LiveData<List<? extends ResolveInfo>> {
    public static final Companion Companion = new Companion(null);
    private final Lazy context$delegate;
    private final Lazy packageManager$delegate;
    private BroadcastReceiver packagesBroadcastReceiver;

    public LauncherIntentResolveInfoListLiveData(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context$delegate = LazyKt.lazy(new Function0<Context>() { // from class: com.magneticchen.daijishou.data.live.LauncherIntentResolveInfoListLiveData$context$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Context invoke() {
                return context.getApplicationContext();
            }
        });
        this.packageManager$delegate = LazyKt.lazy(new Function0<PackageManager>() { // from class: com.magneticchen.daijishou.data.live.LauncherIntentResolveInfoListLiveData$packageManager$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PackageManager invoke() {
                return context.getPackageManager();
            }
        });
    }

    private final Context getContext() {
        Object value = this.context$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Context) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PackageManager getPackageManager() {
        Object value = this.packageManager$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (PackageManager) value;
    }

    protected void onActive() {
        super.onActive();
        setValue(getPackageManager().queryIntentActivities(Companion.getLauncherIntent(), 0));
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
        getContext().registerReceiver(this.packagesBroadcastReceiver, intentFilter);
    }

    protected void onInactive() {
        super.onInactive();
        getContext().unregisterReceiver(this.packagesBroadcastReceiver);
    }

    /* JADX INFO: compiled from: LauncherIntentResolveInfoListLiveData.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/magneticchen/daijishou/data/live/LauncherIntentResolveInfoListLiveData$LauncherIntentResolveInfoBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/magneticchen/daijishou/data/live/LauncherIntentResolveInfoListLiveData;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class LauncherIntentResolveInfoBroadcastReceiver extends BroadcastReceiver {
        public LauncherIntentResolveInfoBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            LauncherIntentResolveInfoListLiveData launcherIntentResolveInfoListLiveData = LauncherIntentResolveInfoListLiveData.this;
            launcherIntentResolveInfoListLiveData.setValue(launcherIntentResolveInfoListLiveData.getPackageManager().queryIntentActivities(LauncherIntentResolveInfoListLiveData.Companion.getLauncherIntent(), 0));
        }
    }

    /* JADX INFO: compiled from: LauncherIntentResolveInfoListLiveData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/data/live/LauncherIntentResolveInfoListLiveData$Companion;", "", "()V", "launcherIntent", "Landroid/content/Intent;", "getLauncherIntent", "()Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
