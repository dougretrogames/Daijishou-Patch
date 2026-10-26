package com.magneticchen.daijishou.daijishou_widget.widgets.activity;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelLazy;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* INFO: compiled from: ActivityWidgetInstance.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ActivityWidgetInstance$actions$1 extends Lambda<Unit> implements Function1<AppCompatActivity, Unit> {
    public static final ActivityWidgetInstance$actions$1 INSTANCE = new ActivityWidgetInstance$actions$1();

    ActivityWidgetInstance$actions$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppCompatActivity appCompatActivity) {
        invoke2(appCompatActivity);
        return Unit.INSTANCE;
    }

    private static final DaijishouLibraryModel invoke$lambda$0(Lazy<DaijishouLibraryModel> lazy) {
        return lazy.getValue();
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AppCompatActivity appCompatActivity = activity;
        Toast.makeText(activity.getApplicationContext(), invoke$lambda$0(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouLibraryModel.class), new ActivityWidgetInstance$actions$1$invoke$$inlined$viewModels$default$2(appCompatActivity), new ActivityWidgetInstance$actions$1$invoke$$inlined$viewModels$default$1(appCompatActivity), new ActivityWidgetInstance$actions$1$invoke$$inlined$viewModels$default$3(null, appCompatActivity))).getAllEventsCountStatically() + " events in total.", 0).show();
    }
}
