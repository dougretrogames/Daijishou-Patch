package com.magneticchen.daijishou.daijishou_widget.widgets.rss;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: RSSWidgetInstance.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RSSWidgetInstance$actions$1$1$1 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ AppCompatActivity $activity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RSSWidgetInstance$actions$1$1$1(AppCompatActivity appCompatActivity) {
        super(0);
        this.$activity = appCompatActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Toast.makeText(this.$activity.getApplicationContext(), this.$activity.getString(R.string.canceled_period), 0).show();
    }
}
