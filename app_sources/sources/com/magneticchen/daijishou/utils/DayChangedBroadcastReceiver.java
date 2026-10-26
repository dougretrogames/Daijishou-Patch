package com.magneticchen.daijishou.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: DayChangedBroadcastReceiver.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/magneticchen/daijishou/utils/DayChangedBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "date", "Ljava/util/Date;", "dateFormat", "Ljava/text/SimpleDateFormat;", "getDateFormat", "()Ljava/text/SimpleDateFormat;", "dateFormat$delegate", "Lkotlin/Lazy;", "isSameDay", "", "currentDate", "onDayChanged", "", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class DayChangedBroadcastReceiver extends BroadcastReceiver {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Date date = new Date();

    /* INFO: renamed from: dateFormat$delegate, reason: from kotlin metadata */
    private final Lazy dateFormat = LazyKt.lazy(DayChangedBroadcastReceiver$dateFormat$2.INSTANCE);

    public abstract void onDayChanged();

    private final SimpleDateFormat getDateFormat() {
        return (SimpleDateFormat) this.dateFormat.getValue();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        Date date = new Date();
        if ((Intrinsics.areEqual(action, "android.intent.action.TIME_SET") || Intrinsics.areEqual(action, "android.intent.action.TIMEZONE_CHANGED") || Intrinsics.areEqual(action, "android.intent.action.DATE_CHANGED")) && !isSameDay(date)) {
            this.date = date;
            onDayChanged();
        }
    }

    private final boolean isSameDay(Date currentDate) {
        return Intrinsics.areEqual(getDateFormat().format(currentDate), getDateFormat().format(this.date));
    }

    /* INFO: compiled from: DayChangedBroadcastReceiver.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/utils/DayChangedBroadcastReceiver$Companion;", "", "()V", "getIntentFilter", "Landroid/content/IntentFilter;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IntentFilter getIntentFilter() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.DATE_CHANGED");
            return intentFilter;
        }
    }
}
