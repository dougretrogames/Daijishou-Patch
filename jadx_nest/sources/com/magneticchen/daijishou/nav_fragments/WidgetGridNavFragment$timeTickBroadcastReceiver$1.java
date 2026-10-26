package com.magneticchen.daijishou.nav_fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.magneticchen.daijishou.live_data.SharedPreferenceBooleanLiveData;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: WidgetGridNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/nav_fragments/WidgetGridNavFragment$timeTickBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "ctx", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetGridNavFragment$timeTickBroadcastReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ WidgetGridNavFragment this$0;

    WidgetGridNavFragment$timeTickBroadcastReceiver$1(WidgetGridNavFragment widgetGridNavFragment) {
        this.this$0 = widgetGridNavFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context ctx, Intent intent) {
        SimpleDateFormat simpleDateFormat;
        Date date;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        Intrinsics.checkNotNull(action);
        if (action.compareTo("android.intent.action.TIME_TICK") == 0) {
            TextView textView = this.this$0.clockFirstTextView;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clockFirstTextView");
                textView = null;
            }
            SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = this.this$0.use24HourClockPreferenceLiveData;
            if (sharedPreferenceBooleanLiveData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("use24HourClockPreferenceLiveData");
                sharedPreferenceBooleanLiveData = null;
            }
            if (Intrinsics.areEqual((Object) sharedPreferenceBooleanLiveData.getValue(), (Object) true)) {
                simpleDateFormat = WidgetGridNavFragment.clockTime24HourFormat;
                date = new Date();
            } else {
                simpleDateFormat = WidgetGridNavFragment.clockTimeFormat;
                date = new Date();
            }
            textView.setText(simpleDateFormat.format(date));
            TextView textView3 = this.this$0.clockSecondTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clockSecondTextView");
                textView3 = null;
            }
            textView3.setText(WidgetGridNavFragment.clockTimeAMPMFormat.format(new Date()));
            WidgetGridNavFragment widgetGridNavFragment = this.this$0;
            String str = WidgetGridNavFragment.dateFormat.format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            widgetGridNavFragment.setDescriptionFirstString(str);
            TextView textView4 = this.this$0.descriptionTextView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
            } else {
                textView2 = textView4;
            }
            textView2.setText(this.this$0.getDescriptionFirstString() + this.this$0.getDescriptionSecondString());
        }
    }
}
