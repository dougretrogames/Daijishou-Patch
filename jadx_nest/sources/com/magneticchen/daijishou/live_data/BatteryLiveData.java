package com.magneticchen.daijishou.live_data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatteryLiveData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/live_data/BatteryLiveData;", "Landroidx/lifecycle/LiveData;", "Lcom/magneticchen/daijishou/live_data/BatteryInfo;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "batteryReceiver", "Landroid/content/BroadcastReceiver;", "onActive", "", "onInactive", "registerBatteryReceiver", "setBatteryInfo", "intent", "Landroid/content/Intent;", "BatteryReceiver", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BatteryLiveData extends LiveData<BatteryInfo> {
    public static final int UNKNOWN = -1;
    private BroadcastReceiver batteryReceiver;
    private final Context context;

    public BatteryLiveData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.context = applicationContext;
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        registerBatteryReceiver();
    }

    private final void registerBatteryReceiver() {
        if (this.batteryReceiver == null) {
            this.batteryReceiver = new BatteryReceiver();
        }
        this.context.registerReceiver(this.batteryReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        this.context.unregisterReceiver(this.batteryReceiver);
    }

    /* JADX INFO: compiled from: BatteryLiveData.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/magneticchen/daijishou/live_data/BatteryLiveData$BatteryReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/magneticchen/daijishou/live_data/BatteryLiveData;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class BatteryReceiver extends BroadcastReceiver {
        public BatteryReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                BatteryLiveData.this.setBatteryInfo(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBatteryInfo(Intent intent) {
        int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        boolean z = intent.getIntExtra("plugged", -1) > 0;
        int intExtra2 = intent.getIntExtra("health", -1);
        int intExtra3 = intent.getIntExtra("level", -1);
        int intExtra4 = intent.getIntExtra("temperature", -1);
        int intExtra5 = intent.getIntExtra("scale", -1);
        int intExtra6 = intent.getIntExtra("voltage", -1);
        BatteryInfo batteryInfo = new BatteryInfo();
        batteryInfo.setStatus(intExtra);
        batteryInfo.setHealth(intExtra2);
        batteryInfo.setLevel(intExtra3);
        batteryInfo.setPlugged(z);
        batteryInfo.setTemperature(intExtra4);
        batteryInfo.setScale(intExtra5);
        batteryInfo.setVoltage(intExtra6);
        setValue(batteryInfo);
    }
}
