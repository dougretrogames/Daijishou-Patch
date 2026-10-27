package com.magneticchen.daijishou.ui.widget.widgets.app_shortcut;

import android.content.pm.ResolveInfo;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.db.entity.AppShortcutWidgetInstanceEntity;
import com.magneticchen.daijishou.ui.fragments.dialog.StaticResolveInfoCollectionDialogFragment;
import com.magneticchen.daijishou.ui.model.AppsViewModel;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: AppShortcutWidgetInstance.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R2\u0010\u0007\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/app_shortcut/AppShortcutWidgetInstance;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetInstance;", "widgetBuilder", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetBuilder;", "widgetInstanceId", "", "(Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetBuilder;J)V", "actions", "", "Lkotlin/Pair;", "", "Lkotlin/Function1;", "Landroidx/appcompat/app/AppCompatActivity;", "", "getActions", "()Ljava/util/List;", "widgetFaceFragment", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "getWidgetFaceFragment", "()Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "getWidgetInstanceId", "()J", "app_release", "appsViewModel", "Lcom/magneticchen/daijishou/ui/model/AppsViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppShortcutWidgetInstance extends WidgetInstance {
    private final List<Pair<Integer, Function1<AppCompatActivity, Unit>>> actions;
    private final WidgetFaceFragment widgetFaceFragment;
    private final long widgetInstanceId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppShortcutWidgetInstance(final WidgetBuilder widgetBuilder, final long j) {
        super(widgetBuilder);
        Intrinsics.checkNotNullParameter(widgetBuilder, "widgetBuilder");
        this.widgetInstanceId = j;
        this.widgetFaceFragment = AppShortcutWidgetFaceFragment.Companion.newInstance(j);
        this.actions = CollectionsKt.listOf(new Pair(Integer.valueOf(R.string.app_shortcut_widget_pick_an_item_action), new Function1<AppCompatActivity, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.app_shortcut.AppShortcutWidgetInstance$actions$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AppCompatActivity appCompatActivity) {
                invoke2(appCompatActivity);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final AppsViewModel invoke$lambda$0(Lazy<AppsViewModel> lazy) {
                return lazy.getValue();
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final AppCompatActivity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                final ComponentActivity componentActivity = (ComponentActivity) activity;
                final Function0 function0 = null;
                final Lazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AppsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.app_shortcut.AppShortcutWidgetInstance$actions$1$invoke$$inlined$viewModels$default$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ViewModelStore invoke() {
                        return componentActivity.getViewModelStore();
                    }
                }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.app_shortcut.AppShortcutWidgetInstance$actions$1$invoke$$inlined$viewModels$default$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final ViewModelProvider.Factory invoke() {
                        return componentActivity.getDefaultViewModelProviderFactory();
                    }
                }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.app_shortcut.AppShortcutWidgetInstance$actions$1$invoke$$inlined$viewModels$default$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final CreationExtras invoke() {
                        CreationExtras creationExtras;
                        Function0 function1 = function0;
                        return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
                    }
                });
                final StaticResolveInfoCollectionDialogFragment staticResolveInfoCollectionDialogFragmentNewInstance$default = StaticResolveInfoCollectionDialogFragment.Companion.newInstance$default(StaticResolveInfoCollectionDialogFragment.Companion, invoke$lambda$0(viewModelLazy).getLauncherIntentResolveInfoList(), null, 2, null);
                final WidgetBuilder widgetBuilder2 = widgetBuilder;
                final long j2 = j;
                staticResolveInfoCollectionDialogFragmentNewInstance$default.setOnClickListener(new Function1<ResolveInfo, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.app_shortcut.AppShortcutWidgetInstance$actions$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ResolveInfo resolveInfo) {
                        invoke2(resolveInfo);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ResolveInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        String strResolveInfoToResolveInfoStringId = AppShortcutWidgetInstance$actions$1.invoke$lambda$0(viewModelLazy).resolveInfoToResolveInfoStringId(it);
                        Toast.makeText(activity.getApplicationContext(), AppShortcutWidgetInstance$actions$1.invoke$lambda$0(viewModelLazy).getResolveInfoStringIdToLabelCache().get(strResolveInfoToResolveInfoStringId), 0).show();
                        AppShortcutWidgetInstanceEntity appShortcutWidgetInstanceByIdStatically = widgetBuilder2.getDaijishouWidgetRepository().getAppShortcutWidgetInstanceByIdStatically(j2);
                        Intrinsics.checkNotNull(appShortcutWidgetInstanceByIdStatically);
                        appShortcutWidgetInstanceByIdStatically.setResolveInfoStringId(strResolveInfoToResolveInfoStringId);
                        widgetBuilder2.getDaijishouWidgetRepository().deleteAppShortcutWidgetInstanceEntityImage(appShortcutWidgetInstanceByIdStatically);
                        appShortcutWidgetInstanceByIdStatically.setAlternativeImagePath(null);
                        widgetBuilder2.getDaijishouWidgetRepository().updateAppShortcutWidgetInstance(appShortcutWidgetInstanceByIdStatically);
                        staticResolveInfoCollectionDialogFragmentNewInstance$default.dismiss();
                    }
                }).show(activity.getSupportFragmentManager(), StaticResolveInfoCollectionDialogFragment.class.getName());
            }
        }));
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance
    public long getWidgetInstanceId() {
        return this.widgetInstanceId;
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance
    public WidgetFaceFragment getWidgetFaceFragment() {
        return this.widgetFaceFragment;
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance
    public List<Pair<Integer, Function1<AppCompatActivity, Unit>>> getActions() {
        return this.actions;
    }
}
