package com.magneticchen.daijishou.daijishou_widget.widgets.app_shortcut;

import android.content.pm.ResolveInfo;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelLazy;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.daijishou_widget.widget_db.AppShortcutWidgetInstanceEntity;
import com.magneticchen.daijishou.dialog_fragments.StaticResolveInfoCollectionDialogFragment;
import com.magneticchen.daijishou.view_models.AppsViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* INFO: compiled from: AppShortcutWidgetInstance.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class AppShortcutWidgetInstance$actions$1 extends Lambda<Unit> implements Function1<AppCompatActivity, Unit> {
    final /* synthetic */ WidgetBuilder $widgetBuilder;
    final /* synthetic */ long $widgetInstanceId;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppShortcutWidgetInstance$actions$1(WidgetBuilder widgetBuilder, long j) {
        super(1);
        this.$widgetBuilder = widgetBuilder;
        this.$widgetInstanceId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppCompatActivity appCompatActivity) {
        invoke2(appCompatActivity);
        return Unit.INSTANCE;
    }

    /* INFO: Access modifiers changed from: private */
    public static final AppsViewModel invoke$lambda$0(Lazy<AppsViewModel> lazy) {
        return lazy.getValue();
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AppCompatActivity appCompatActivity = activity;
        ViewModelLazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AppsViewModel.class), new AppShortcutWidgetInstance$actions$1$invoke$$inlined$viewModels$default$2(appCompatActivity), new AppShortcutWidgetInstance$actions$1$invoke$$inlined$viewModels$default$1(appCompatActivity), new AppShortcutWidgetInstance$actions$1$invoke$$inlined$viewModels$default$3(null, appCompatActivity));
        StaticResolveInfoCollectionDialogFragment staticResolveInfoCollectionDialogFragmentNewInstance$default = StaticResolveInfoCollectionDialogFragment.Companion.newInstance$default(StaticResolveInfoCollectionDialogFragment.INSTANCE, invoke$lambda$0(viewModelLazy).getLauncherIntentResolveInfoList(), null, 2, null);
        staticResolveInfoCollectionDialogFragmentNewInstance$default.setOnClickListener(new AnonymousClass1(activity, this.$widgetBuilder, this.$widgetInstanceId, staticResolveInfoCollectionDialogFragmentNewInstance$default, viewModelLazy)).show(activity.getSupportFragmentManager(), StaticResolveInfoCollectionDialogFragment.class.getName());
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.app_shortcut.AppShortcutWidgetInstance$actions$1$1, reason: invalid class name */
    /* INFO: compiled from: AppShortcutWidgetInstance.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/content/pm/ResolveInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda<Unit> implements Function1<ResolveInfo, Unit> {
        final /* synthetic */ AppCompatActivity $activity;
        final /* synthetic */ Lazy<AppsViewModel> $appsViewModel$delegate;
        final /* synthetic */ StaticResolveInfoCollectionDialogFragment $dialog;
        final /* synthetic */ WidgetBuilder $widgetBuilder;
        final /* synthetic */ long $widgetInstanceId;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AppCompatActivity appCompatActivity, WidgetBuilder widgetBuilder, long j, StaticResolveInfoCollectionDialogFragment staticResolveInfoCollectionDialogFragment, Lazy<AppsViewModel> lazy) {
            super(1);
            this.$activity = appCompatActivity;
            this.$widgetBuilder = widgetBuilder;
            this.$widgetInstanceId = j;
            this.$dialog = staticResolveInfoCollectionDialogFragment;
            this.$appsViewModel$delegate = lazy;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ResolveInfo resolveInfo) {
            invoke2(resolveInfo);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ResolveInfo it) {
            Intrinsics.checkNotNullParameter(it, "it");
            String strResolveInfoToResolveInfoStringId = AppShortcutWidgetInstance$actions$1.invoke$lambda$0(this.$appsViewModel$delegate).resolveInfoToResolveInfoStringId(it);
            Toast.makeText(this.$activity.getApplicationContext(), AppShortcutWidgetInstance$actions$1.invoke$lambda$0(this.$appsViewModel$delegate).getResolveInfoStringIdToLabelCache().get(strResolveInfoToResolveInfoStringId), 0).show();
            AppShortcutWidgetInstanceEntity appShortcutWidgetInstanceByIdStatically = this.$widgetBuilder.getDaijishouWidgetRepository().getAppShortcutWidgetInstanceByIdStatically(this.$widgetInstanceId);
            Intrinsics.checkNotNull(appShortcutWidgetInstanceByIdStatically);
            appShortcutWidgetInstanceByIdStatically.setResolveInfoStringId(strResolveInfoToResolveInfoStringId);
            this.$widgetBuilder.getDaijishouWidgetRepository().deleteAppShortcutWidgetInstanceEntityImage(appShortcutWidgetInstanceByIdStatically);
            appShortcutWidgetInstanceByIdStatically.setAlternativeImagePath(null);
            this.$widgetBuilder.getDaijishouWidgetRepository().updateAppShortcutWidgetInstance(appShortcutWidgetInstanceByIdStatically);
            this.$dialog.dismiss();
        }
    }
}
