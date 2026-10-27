package com.magneticchen.daijishou.data.live;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.lifecycle.LiveData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatteryLiveData.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/magneticchen/daijishou/data/live/BatteryLiveData;", "Landroidx/lifecycle/LiveData;", "Lcom/magneticchen/daijishou/data/live/BatteryInfo;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "batteryReceiver", "Landroid/content/BroadcastReceiver;", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "onActive", "", "onInactive", "registerBatteryReceiver", "setBatteryInfo", "intent", "Landroid/content/Intent;", "BatteryReceiver", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BatteryLiveData extends LiveData<BatteryInfo> {
    public static final Companion Companion = new Companion(null);
    public static final int UNKNOWN = -1;
    private BroadcastReceiver batteryReceiver;
    private final Lazy context$delegate;

    public BatteryLiveData(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context$delegate = LazyKt.lazy(new Function0<Context>() { // from class: com.magneticchen.daijishou.data.live.BatteryLiveData$context$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Context invoke() {
                return context.getApplicationContext();
            }
        });
    }

    private final Context getContext() {
        Object value = this.context$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Context) value;
    }

    protected void onActive() {
        super.onActive();
        registerBatteryReceiver();
    }

    protected void onInactive() {
        super.onInactive();
        getContext().unregisterReceiver(this.batteryReceiver);
    }

    private final void registerBatteryReceiver() {
        if (this.batteryReceiver == null) {
            this.batteryReceiver = new BatteryReceiver();
        }
        getContext().registerReceiver(this.batteryReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBatteryInfo(Intent intent) {
        BatteryInfo batteryInfo = new BatteryInfo();
        batteryInfo.setStatus(intent.getIntExtra("status", -1));
        batteryInfo.setHealth(intent.getIntExtra("health", -1));
        batteryInfo.setLevel(intent.getIntExtra("level", -1));
        batteryInfo.setPlugged(intent.getIntExtra("plugged", -1) > 0);
        batteryInfo.setTemperature(intent.getIntExtra("temperature", -1));
        batteryInfo.setScale(intent.getIntExtra("scale", -1));
        batteryInfo.setVoltage(intent.getIntExtra("voltage", -1));
        setValue(batteryInfo);
    }

    /* JADX INFO: compiled from: BatteryLiveData.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/magneticchen/daijishou/data/live/BatteryLiveData$BatteryReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/magneticchen/daijishou/data/live/BatteryLiveData;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* JADX INFO: compiled from: BatteryLiveData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/data/live/BatteryLiveData$Companion;", "", "()V", "UNKNOWN", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
