package com.magneticchen.daijishou.ui.fragments.nav;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.IntPreference;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.db.entity.RSSWidgetInstanceEntity;
import com.magneticchen.daijishou.data.live.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.ui.activities.MainActivity;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouGridLayoutManager;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.ui.fragments.dialog.ChoosePlayableItemFromLibraryDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.StaticResolveInfoCollectionDialogFragment;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment;
import com.magneticchen.daijishou.ui.model.AppsViewModel;
import com.magneticchen.daijishou.ui.model.DaijishouViewModel;
import com.magneticchen.daijishou.ui.widget.WidgetsManager;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetNavFragment;
import com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetFaceRecyclerViewAdapter;
import com.magneticchen.daijishou.ui.widget.widgets.app_shortcut.AppShortcutWidgetBuilder;
import com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetBuilder;
import com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetBuilder;
import com.magneticchen.daijishou.ui.widget.widgets.rss.RSSWidgetEditDialogFragment;
import com.skydoves.balloon.internals.DefinitionKt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: WidgetGridNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000µ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002*\u0001&\u0018\u0000 V2\u00020\u0001:\u0001VB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010>\u001a\u00020\u001bH\u0016J\u0012\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J&\u0010C\u001a\u0004\u0018\u00010\u00192\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010H\u001a\u00020@H\u0016J \u0010I\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020@H\u0016J\b\u0010P\u001a\u00020@H\u0016J\b\u0010Q\u001a\u00020@H\u0002J\u0014\u0010R\u001a\u00020@2\n\u0010S\u001a\u00060TR\u00020/H\u0002J\b\u0010U\u001a\u00020@H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u000e\u0010\u0017\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\"\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u000e\u0010(\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020403X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010!\u001a\u0004\b;\u0010<¨\u0006W²\u0006\n\u0010X\u001a\u00020YX\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/nav/WidgetGridNavFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouFragment;", "()V", "addWidgetChip", "Lcom/google/android/material/chip/Chip;", "addWidgetChipPopupMenu", "Landroidx/appcompat/widget/PopupMenu;", "chipIconTint", "Landroid/content/res/ColorStateList;", "clockConstraintLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "clockFirstTextView", "Landroid/widget/TextView;", "clockSecondTextView", "descriptionFirstString", "", "getDescriptionFirstString", "()Ljava/lang/String;", "setDescriptionFirstString", "(Ljava/lang/String;)V", "descriptionSecondString", "getDescriptionSecondString", "setDescriptionSecondString", "descriptionTextView", "divider", "Landroid/view/View;", "hasRegisteredTimeTickBroadcastReceiver", "", "model", "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "model$delegate", "Lkotlin/Lazy;", "moveString", "removeString", "scrollingOnBackPressed", "timeTickBroadcastReceiver", "com/magneticchen/daijishou/ui/fragments/nav/WidgetGridNavFragment$timeTickBroadcastReceiver$1", "Lcom/magneticchen/daijishou/ui/fragments/nav/WidgetGridNavFragment$timeTickBroadcastReceiver$1;", "totalPlayableItemCountFormatString", "use24HourClockPreferenceLiveData", "Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;", "viewCreatedBefore", "widgetCreateCanceledString", "widgetCreatedSuccessfullyString", "widgetFaceRecyclerViewAdapter", "Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter;", "widgetGridLayoutManager", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouGridLayoutManager;", "widgetInstances", "", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetInstance;", "widgetRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "widgetRemoveCanceledString", "widgetRemovedSuccessfullyString", "widgetsManager", "Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;", "getWidgetsManager", "()Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;", "widgetsManager$delegate", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onHotKeyPressed", "hotkeyCode", "", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onKioskMode", "onNoneKioskMode", "registerTimeTickBroadcast", "showOptionsForViewHolder", "viewHolder", "Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter$WidgetViewHolder;", "unregisterTimeTickBroadcast", "Companion", "app_release", "appsViewModel", "Lcom/magneticchen/daijishou/ui/model/AppsViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetGridNavFragment extends DaijishouFragment {
    private static final IntentFilter timeTickIntentFilter;
    private Chip addWidgetChip;
    private PopupMenu addWidgetChipPopupMenu;
    private ColorStateList chipIconTint;
    private ConstraintLayout clockConstraintLayout;
    private TextView clockFirstTextView;
    private TextView clockSecondTextView;
    private TextView descriptionTextView;
    private View divider;
    private boolean hasRegisteredTimeTickBroadcastReceiver;
    private final Lazy model$delegate;
    private String moveString;
    private String removeString;
    private boolean scrollingOnBackPressed;
    private String totalPlayableItemCountFormatString;
    private SharedPreferenceBooleanLiveData use24HourClockPreferenceLiveData;
    private boolean viewCreatedBefore;
    private String widgetCreateCanceledString;
    private String widgetCreatedSuccessfullyString;
    private WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter;
    private DaijishouGridLayoutManager widgetGridLayoutManager;
    private RecyclerView widgetRecyclerView;
    private String widgetRemoveCanceledString;
    private String widgetRemovedSuccessfullyString;
    public static final Companion Companion = new Companion(null);
    private static final SimpleDateFormat clockTimeFormat = new SimpleDateFormat("hh:mm", Locale.getDefault());
    private static final SimpleDateFormat clockTime24HourFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
    private static final SimpleDateFormat clockTimeAMPMFormat = new SimpleDateFormat("aa", Locale.getDefault());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy • ", Locale.getDefault());
    private String descriptionFirstString = "1, Jan, 1980. ";
    private String descriptionSecondString = "Daijishō Launcher.";
    private final android.content.BroadcastReceiver timeTickBroadcastReceiver = new BroadcastReceiver() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$timeTickBroadcastReceiver$1
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
    };
    private final List<WidgetInstance> widgetInstances = new ArrayList();
    private final Lazy widgetsManager$delegate = LazyKt.lazy(new Function0<WidgetsManager>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$widgetsManager$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WidgetsManager invoke() {
            MainActivity mainActivityRequireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNull(mainActivityRequireActivity, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.activities.MainActivity");
            return mainActivityRequireActivity.getWidgetsManager();
        }
    });

    /* JADX WARN: Type inference failed for: r0v5, types: [com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$timeTickBroadcastReceiver$1] */
    public WidgetGridNavFragment() {
        final WidgetGridNavFragment widgetGridNavFragment = this;
        final Function0 function0 = null;
        this.model$delegate = FragmentViewModelLazyKt.createViewModelLazy(widgetGridNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return widgetGridNavFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? widgetGridNavFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return widgetGridNavFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: compiled from: WidgetGridNavFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/nav/WidgetGridNavFragment$Companion;", "", "()V", "clockTime24HourFormat", "Ljava/text/SimpleDateFormat;", "clockTimeAMPMFormat", "clockTimeFormat", "dateFormat", "timeTickIntentFilter", "Landroid/content/IntentFilter;", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/nav/WidgetGridNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WidgetGridNavFragment newInstance() {
            return new WidgetGridNavFragment();
        }
    }

    static {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        timeTickIntentFilter = intentFilter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model$delegate.getValue();
    }

    public final String getDescriptionFirstString() {
        return this.descriptionFirstString;
    }

    public final void setDescriptionFirstString(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.descriptionFirstString = str;
    }

    public final String getDescriptionSecondString() {
        return this.descriptionSecondString;
    }

    public final void setDescriptionSecondString(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.descriptionSecondString = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WidgetsManager getWidgetsManager() {
        return (WidgetsManager) this.widgetsManager$delegate.getValue();
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onKioskMode() {
        super.onKioskMode();
        Chip chip = this.addWidgetChip;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addWidgetChip");
            chip = null;
        }
        chip.setVisibility(8);
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onNoneKioskMode() {
        super.onNoneKioskMode();
        Chip chip = this.addWidgetChip;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addWidgetChip");
            chip = null;
        }
        chip.setVisibility(0);
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public boolean onHotKeyPressed(int i, int i2, KeyEvent keyEvent) {
        View view;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(i, i2, keyEvent);
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter = null;
        if (i == 1) {
            if (isKioskMode()) {
                return false;
            }
            Chip chip = this.addWidgetChip;
            if (chip == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addWidgetChip");
                chip = null;
            }
            chip.requestFocus();
            WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter2 = this.addWidgetChip;
            if (widgetFaceRecyclerViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addWidgetChip");
            } else {
                widgetFaceRecyclerViewAdapter = widgetFaceRecyclerViewAdapter2;
            }
            widgetFaceRecyclerViewAdapter.performClick();
            return true;
        }
        if (i == 2) {
            ConstraintLayout constraintLayout = this.clockConstraintLayout;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clockConstraintLayout");
                constraintLayout = null;
            }
            constraintLayout.requestFocus();
            WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter3 = this.clockConstraintLayout;
            if (widgetFaceRecyclerViewAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clockConstraintLayout");
            } else {
                widgetFaceRecyclerViewAdapter = widgetFaceRecyclerViewAdapter3;
            }
            widgetFaceRecyclerViewAdapter.performClick();
            return true;
        }
        if (i != 3) {
            if (i != 4) {
                return false;
            }
            WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter4 = this.widgetFaceRecyclerViewAdapter;
            if (widgetFaceRecyclerViewAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
            } else {
                widgetFaceRecyclerViewAdapter = widgetFaceRecyclerViewAdapter4;
            }
            DaijishouRecyclerView.Adapter<WidgetInstance>.ViewHolder selectedViewHolder = widgetFaceRecyclerViewAdapter.getSelectedViewHolder();
            if (selectedViewHolder != null && selectedViewHolder.itemView.isFocused() && selectedViewHolder.getAbsoluteAdapterPosition() >= 0) {
                selectedViewHolder.itemView.performLongClick();
            }
            return true;
        }
        if (isKioskMode()) {
            return false;
        }
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter5 = this.widgetFaceRecyclerViewAdapter;
        if (widgetFaceRecyclerViewAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
            widgetFaceRecyclerViewAdapter5 = null;
        }
        if (widgetFaceRecyclerViewAdapter5.getRequestMovingViewHolderPositionMode()) {
            WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter6 = this.widgetFaceRecyclerViewAdapter;
            if (widgetFaceRecyclerViewAdapter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
            } else {
                widgetFaceRecyclerViewAdapter = widgetFaceRecyclerViewAdapter6;
            }
            DaijishouRecyclerView.Adapter<WidgetInstance>.ViewHolder selectedViewHolder2 = widgetFaceRecyclerViewAdapter.getSelectedViewHolder();
            if (selectedViewHolder2 != null && (view = selectedViewHolder2.itemView) != null) {
                view.performClick();
            }
            return false;
        }
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter7 = this.widgetFaceRecyclerViewAdapter;
        if (widgetFaceRecyclerViewAdapter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
        } else {
            widgetFaceRecyclerViewAdapter = widgetFaceRecyclerViewAdapter7;
        }
        DaijishouRecyclerView.Adapter<WidgetInstance>.ViewHolder selectedViewHolder3 = widgetFaceRecyclerViewAdapter.getSelectedViewHolder();
        if (selectedViewHolder3 != null && selectedViewHolder3.itemView.isFocused() && selectedViewHolder3.getAbsoluteAdapterPosition() >= 0) {
            ((WidgetFaceRecyclerViewAdapter.WidgetViewHolder) selectedViewHolder3).requestMovingPosition(new Function2<Integer, Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$onHotKeyPressed$1$1
                

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                    invoke(num.intValue(), num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, int i4) {
                    if (i3 == i4) {
                        return;
                    }
                    MainActivity activity = this.this$0.getActivity();
                    Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.activities.MainActivity");
                    WidgetsManager widgetsManager = activity.getWidgetsManager();
                    WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter8 = this.this$0.widgetFaceRecyclerViewAdapter;
                    if (widgetFaceRecyclerViewAdapter8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
                        widgetFaceRecyclerViewAdapter8 = null;
                    }
                    widgetFaceRecyclerViewAdapter8.selectPosition(i4);
                    widgetsManager.moveWidgetInstancePosition(i3, i4);
                }
            });
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0033  */
    /* JADX WARN: Code duplicated, block: B:20:0x0037  */
    /* JADX WARN: Code duplicated, block: B:32:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x006e  */
    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public boolean onBackPressed() {
        RecyclerView recyclerView;
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        RecyclerView recyclerView2 = this.widgetRecyclerView;
        ConstraintLayout constraintLayout3 = null;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
            recyclerView2 = null;
        }
        RecyclerView.Adapter adapter = recyclerView2.getAdapter();
        if (adapter != null) {
            WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter = (WidgetFaceRecyclerViewAdapter) adapter;
            if (widgetFaceRecyclerViewAdapter.getRequestMovingViewHolderPositionMode()) {
                widgetFaceRecyclerViewAdapter.cancelMovingPosition();
                return false;
            }
        }
        if (this.scrollingOnBackPressed) {
            RecyclerView recyclerView3 = this.widgetRecyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
                recyclerView3 = null;
            }
            if (recyclerView3.getScrollState() != 1) {
                recyclerView = this.widgetRecyclerView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
                    recyclerView = null;
                }
                if (recyclerView.computeVerticalScrollOffset() != 0) {
                    this.scrollingOnBackPressed = true;
                    constraintLayout = this.clockConstraintLayout;
                    if (constraintLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clockConstraintLayout");
                        constraintLayout = null;
                    }
                    constraintLayout.requestFocus();
                    constraintLayout2 = this.widgetRecyclerView;
                    if (constraintLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
                    } else {
                        constraintLayout3 = constraintLayout2;
                    }
                    constraintLayout3.smoothScrollToPosition(0);
                    return false;
                }
            }
        } else {
            recyclerView = this.widgetRecyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
                recyclerView = null;
            }
            if (recyclerView.computeVerticalScrollOffset() != 0) {
                this.scrollingOnBackPressed = true;
                constraintLayout = this.clockConstraintLayout;
                if (constraintLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clockConstraintLayout");
                    constraintLayout = null;
                }
                constraintLayout.requestFocus();
                constraintLayout2 = this.widgetRecyclerView;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
                } else {
                    constraintLayout3 = constraintLayout2;
                }
                constraintLayout3.smoothScrollToPosition(0);
                return false;
            }
        }
        RecyclerView recyclerView4 = this.widgetRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
            recyclerView4 = null;
        }
        recyclerView4.scrollToPosition(0);
        ConstraintLayout constraintLayout4 = this.clockConstraintLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clockConstraintLayout");
        } else {
            constraintLayout3 = constraintLayout4;
        }
        constraintLayout3.requestFocus();
        return true;
    }

    private final void registerTimeTickBroadcast() {
        requireActivity().registerReceiver(this.timeTickBroadcastReceiver, timeTickIntentFilter);
        this.hasRegisteredTimeTickBroadcastReceiver = true;
    }

    private final void unregisterTimeTickBroadcast() {
        if (this.hasRegisteredTimeTickBroadcastReceiver) {
            requireActivity().unregisterReceiver(this.timeTickBroadcastReceiver);
            this.hasRegisteredTimeTickBroadcastReceiver = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showOptionsForViewHolder(final WidgetFaceRecyclerViewAdapter.WidgetViewHolder widgetViewHolder) {
        MainActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.activities.MainActivity");
        final WidgetsManager widgetsManager = activity.getWidgetsManager();
        final WidgetInstance widgetInstance = widgetsManager.getWidgetInstanceList().get(widgetViewHolder.getAbsoluteAdapterPosition());
        PopupMenu popupMenu = new PopupMenu(requireContext(), widgetViewHolder.itemView);
        int i = 0;
        for (Object obj : widgetInstance.getActions()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            popupMenu.getMenu().add(0, i, i, ((Number) ((Pair) obj).getFirst()).intValue());
            i = i2;
        }
        String str = null;
        if (!isKioskMode()) {
            Menu menu = popupMenu.getMenu();
            int size = widgetInstance.getActions().size();
            String str2 = this.moveString;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("moveString");
                str2 = null;
            }
            menu.add(1, 0, size, "📦 " + str2);
        }
        if (!isKioskMode()) {
            Menu menu2 = popupMenu.getMenu();
            int size2 = widgetInstance.getActions().size() + 1;
            String str3 = this.removeString;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("removeString");
            } else {
                str = str3;
            }
            menu2.add(1, 1, size2, "🗑️ " + str);
        }
        if (!isKioskMode() && Build.VERSION.SDK_INT >= 28) {
            popupMenu.getMenu().setGroupDividerEnabled(true);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$$ExternalSyntheticLambda0
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return WidgetGridNavFragment.showOptionsForViewHolder$lambda$3(widgetInstance, this, widgetViewHolder, widgetsManager, menuItem);
            }
        });
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showOptionsForViewHolder$lambda$3(WidgetInstance widgetInstance, final WidgetGridNavFragment this$0, WidgetFaceRecyclerViewAdapter.WidgetViewHolder viewHolder, final WidgetsManager widgetsManager, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(widgetInstance, "$widgetInstance");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(widgetsManager, "$widgetsManager");
        if (menuItem.getGroupId() == 0) {
            Function1<AppCompatActivity, Unit> second = widgetInstance.getActions().get(menuItem.getItemId()).getSecond();
            FragmentActivity activity = this$0.getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            second.invoke((AppCompatActivity) activity);
            return false;
        }
        if (menuItem.getGroupId() == 1 && menuItem.getItemId() == 0) {
            WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter = this$0.widgetFaceRecyclerViewAdapter;
            if (widgetFaceRecyclerViewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
                widgetFaceRecyclerViewAdapter = null;
            }
            if (widgetFaceRecyclerViewAdapter.getRequestMovingViewHolderPositionMode()) {
                return false;
            }
            viewHolder.requestMovingPosition(new Function2<Integer, Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$showOptionsForViewHolder$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                    invoke(num.intValue(), num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i, int i2) {
                    WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter2 = this.this$0.widgetFaceRecyclerViewAdapter;
                    if (widgetFaceRecyclerViewAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
                        widgetFaceRecyclerViewAdapter2 = null;
                    }
                    widgetFaceRecyclerViewAdapter2.selectPosition(i2);
                    widgetsManager.moveWidgetInstancePosition(i, i2);
                }
            });
            return false;
        }
        if (menuItem.getGroupId() != 1 || menuItem.getItemId() != 1) {
            return false;
        }
        FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        widgetsManager.requestWidgetInstanceRemoval((AppCompatActivity) fragmentActivityRequireActivity, widgetInstance, new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$showOptionsForViewHolder$2$2
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter2 = null;
                if (z) {
                    Context context = this.this$0.getContext();
                    String str = this.this$0.widgetRemovedSuccessfullyString;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("widgetRemovedSuccessfullyString");
                        str = null;
                    }
                    Toast.makeText(context, str, 0).show();
                } else {
                    Context context2 = this.this$0.getContext();
                    String str2 = this.this$0.widgetRemoveCanceledString;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("widgetRemoveCanceledString");
                        str2 = null;
                    }
                    Toast.makeText(context2, str2, 0).show();
                }
                WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter3 = this.this$0.widgetFaceRecyclerViewAdapter;
                if (widgetFaceRecyclerViewAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
                } else {
                    widgetFaceRecyclerViewAdapter2 = widgetFaceRecyclerViewAdapter3;
                }
                widgetFaceRecyclerViewAdapter2.selectPosition(RangesKt.coerceAtMost(this.this$0.widgetInstances.size() - 1, this.this$0.getDefaultSharedPreferences().getInt(IntPreference.WIDGET_GRID_LAST_FOCUSED_POSITION.getKey(), IntPreference.WIDGET_GRID_LAST_FOCUSED_POSITION.getDefaultValue())));
            }
        });
        return false;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.string.move);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.moveString = string;
        String string2 = getString(R.string.remove);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.removeString = string2;
        String string3 = getString(R.string.widget_removed_successfully);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.widgetRemovedSuccessfullyString = string3;
        String string4 = getString(R.string.widget_remove_canceled);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        this.widgetRemoveCanceledString = string4;
        String string5 = getString(R.string.widget_created_successfully);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        this.widgetCreatedSuccessfullyString = string5;
        String string6 = getString(R.string.widget_create_canceled);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        this.widgetCreateCanceledString = string6;
        String string7 = getString(R.string.total_playable_items_count_format);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        this.totalPlayableItemCountFormatString = string7;
        this.use24HourClockPreferenceLiveData = new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "use_24_hour_clock", false);
        String str = dateFormat.format(new Date());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        this.descriptionFirstString = str;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        View viewInflate = inflater.inflate(R.layout.fragment_widget_gird, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_widget_grid_clock_first_textview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.clockFirstTextView = (TextView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.fragment_widget_grid_clock_second_textview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.clockSecondTextView = (TextView) viewFindViewById2;
        ConstraintLayout constraintLayoutFindViewById = viewInflate.findViewById(R.id.fragment_widget_grid_clock);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
        this.clockConstraintLayout = constraintLayoutFindViewById;
        View viewFindViewById3 = viewInflate.findViewById(R.id.fragment_widget_grid_description_textview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.descriptionTextView = (TextView) viewFindViewById3;
        Chip chipFindViewById = viewInflate.findViewById(R.id.fragment_widget_grid_create_widget_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById, "findViewById(...)");
        this.addWidgetChip = chipFindViewById;
        View viewFindViewById4 = viewInflate.findViewById(R.id.fragment_widget_grid_divider);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.divider = viewFindViewById4;
        RecyclerView recyclerViewFindViewById = viewInflate.findViewById(R.id.fragment_widget_grid_recycler_view);
        Intrinsics.checkNotNullExpressionValue(recyclerViewFindViewById, "findViewById(...)");
        this.widgetRecyclerView = recyclerViewFindViewById;
        this.widgetFaceRecyclerViewAdapter = new WidgetFaceRecyclerViewAdapter(this, this.widgetInstances);
        this.widgetGridLayoutManager = new DaijishouGridLayoutManager(contextRequireContext, 117.0f, 8, DefinitionKt.NO_Float_VALUE, false, 24, null);
        Chip chip = this.addWidgetChip;
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addWidgetChip");
            chip = null;
        }
        this.addWidgetChipPopupMenu = new PopupMenu(contextRequireContext, (View) chip);
        Chip chip2 = this.addWidgetChip;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addWidgetChip");
            chip2 = null;
        }
        this.chipIconTint = chip2.getChipIconTint();
        Chip chip3 = this.addWidgetChip;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addWidgetChip");
            chip3 = null;
        }
        chip3.setVisibility(isKioskMode() ? 8 : 0);
        ConstraintLayout constraintLayout = this.clockConstraintLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clockConstraintLayout");
            constraintLayout = null;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGridNavFragment.onCreateView$lambda$4(this.f$0, view);
            }
        });
        TextView textView = this.descriptionTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
            textView = null;
        }
        textView.setText(this.descriptionFirstString + this.descriptionSecondString);
        if (this.viewCreatedBefore) {
            WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter = this.widgetFaceRecyclerViewAdapter;
            if (widgetFaceRecyclerViewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
                widgetFaceRecyclerViewAdapter = null;
            }
            widgetFaceRecyclerViewAdapter.selectPosition(getDefaultSharedPreferences().getInt(IntPreference.WIDGET_GRID_LAST_FOCUSED_POSITION.getKey(), IntPreference.WIDGET_GRID_LAST_FOCUSED_POSITION.getDefaultValue()));
        } else {
            this.viewCreatedBefore = true;
            WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter2 = this.widgetFaceRecyclerViewAdapter;
            if (widgetFaceRecyclerViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
                widgetFaceRecyclerViewAdapter2 = null;
            }
            widgetFaceRecyclerViewAdapter2.selectPosition(-1);
            TextView textView2 = this.clockSecondTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clockSecondTextView");
                textView2 = null;
            }
            textView2.requestFocus();
        }
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter3 = this.widgetFaceRecyclerViewAdapter;
        if (widgetFaceRecyclerViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
            widgetFaceRecyclerViewAdapter3 = null;
        }
        widgetFaceRecyclerViewAdapter3.setOnItemSelectListener(new Function4<View, Integer, Long, WidgetInstance, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment.onCreateView.2
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, WidgetInstance widgetInstance) {
                invoke(view, num.intValue(), l.longValue(), widgetInstance);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i, long j, WidgetInstance widgetInstance) {
                Intrinsics.checkNotNullParameter(widgetInstance, "widgetInstance");
                String string = WidgetGridNavFragment.this.getString(widgetInstance.getTipsStringId());
                DaijishouViewModel model = WidgetGridNavFragment.this.getModel();
                Intrinsics.checkNotNull(string);
                DaijishouViewModel.setTips$default(model, string, false, 2, null);
                WidgetGridNavFragment.this.getDefaultSharedPreferences().edit().putInt(IntPreference.WIDGET_GRID_LAST_FOCUSED_POSITION.getKey(), i).apply();
            }
        });
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter4 = this.widgetFaceRecyclerViewAdapter;
        if (widgetFaceRecyclerViewAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
            widgetFaceRecyclerViewAdapter4 = null;
        }
        widgetFaceRecyclerViewAdapter4.setOnWidgetClickListener((Function2) new Function2<WidgetFaceRecyclerViewAdapter.WidgetViewHolder, Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment.onCreateView.3
            

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(WidgetFaceRecyclerViewAdapter.WidgetViewHolder widgetViewHolder, Integer num) {
                invoke(widgetViewHolder, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(WidgetFaceRecyclerViewAdapter.WidgetViewHolder widgetViewHolder, int i) {
                Intrinsics.checkNotNullParameter(widgetViewHolder, "<anonymous parameter 0>");
                WidgetInstance widgetInstance = WidgetGridNavFragment.this.getWidgetsManager().getWidgetInstanceList().get(i);
                widgetInstance.getWidgetFaceFragment().onClick();
                WidgetNavFragment widgetNavFragment = widgetInstance.getWidgetNavFragment();
                if (widgetNavFragment != null) {
                    WidgetGridNavFragment widgetGridNavFragment = WidgetGridNavFragment.this;
                    FragmentTransaction customAnimations = widgetGridNavFragment.getParentFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in_faster, 0);
                    ViewParent parent = widgetGridNavFragment.requireView().getParent();
                    Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    customAnimations.replace(((ViewGroup) parent).getId(), widgetNavFragment, widgetNavFragment.getClass().getName()).addToBackStack(widgetNavFragment.getClass().getName()).commit();
                }
            }
        });
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter5 = this.widgetFaceRecyclerViewAdapter;
        if (widgetFaceRecyclerViewAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
            widgetFaceRecyclerViewAdapter5 = null;
        }
        widgetFaceRecyclerViewAdapter5.setOnWidgetLongClickListener((Function2) new Function2<WidgetFaceRecyclerViewAdapter.WidgetViewHolder, Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment.onCreateView.4
            

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(WidgetFaceRecyclerViewAdapter.WidgetViewHolder widgetViewHolder, Integer num) {
                invoke(widgetViewHolder, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(WidgetFaceRecyclerViewAdapter.WidgetViewHolder viewHolder, int i) {
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
                WidgetGridNavFragment.this.showOptionsForViewHolder(viewHolder);
            }
        });
        RecyclerView recyclerView = this.widgetRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
            recyclerView = null;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment.onCreateView.5
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                RecyclerView recyclerView3 = WidgetGridNavFragment.this.widgetRecyclerView;
                View view = null;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
                    recyclerView3 = null;
                }
                boolean z = recyclerView3.computeVerticalScrollOffset() > WidgetGridNavFragment.this.getDpToPxConverter().convert(8.0f);
                if (z) {
                    View view2 = WidgetGridNavFragment.this.divider;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("divider");
                        view2 = null;
                    }
                    if (view2.getVisibility() != 0) {
                        View view3 = WidgetGridNavFragment.this.divider;
                        if (view3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("divider");
                        } else {
                            view = view3;
                        }
                        view.setVisibility(0);
                        return;
                    }
                }
                if (z) {
                    return;
                }
                View view4 = WidgetGridNavFragment.this.divider;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("divider");
                    view4 = null;
                }
                if (view4.getVisibility() != 4) {
                    View view5 = WidgetGridNavFragment.this.divider;
                    if (view5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("divider");
                    } else {
                        view = view5;
                    }
                    view.setVisibility(4);
                }
            }
        });
        RecyclerView recyclerView2 = this.widgetRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
            recyclerView2 = null;
        }
        DaijishouGridLayoutManager daijishouGridLayoutManager = this.widgetGridLayoutManager;
        if (daijishouGridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetGridLayoutManager");
            daijishouGridLayoutManager = null;
        }
        recyclerView2.setLayoutManager((RecyclerView.LayoutManager) daijishouGridLayoutManager);
        RecyclerView recyclerView3 = this.widgetRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
            recyclerView3 = null;
        }
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter6 = this.widgetFaceRecyclerViewAdapter;
        if (widgetFaceRecyclerViewAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
            widgetFaceRecyclerViewAdapter6 = null;
        }
        recyclerView3.setAdapter(widgetFaceRecyclerViewAdapter6);
        RecyclerView recyclerView4 = this.widgetRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
            recyclerView4 = null;
        }
        recyclerView4.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment.onCreateView.6
            public void onScrollStateChanged(RecyclerView recyclerView5, int i) {
                Intrinsics.checkNotNullParameter(recyclerView5, "recyclerView");
                if (i == 0) {
                    WidgetGridNavFragment.this.scrollingOnBackPressed = false;
                }
                super.onScrollStateChanged(recyclerView5, i);
            }
        });
        final HashMap map = new HashMap();
        int i = 0;
        for (Object obj : MapsKt.toList(getWidgetsManager().getWidgetBuilders())) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            map.put(Integer.valueOf(i), pair.getFirst());
            PopupMenu popupMenu = this.addWidgetChipPopupMenu;
            if (popupMenu == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addWidgetChipPopupMenu");
                popupMenu = null;
            }
            popupMenu.getMenu().add(0, i, i, getString(((WidgetBuilder) pair.getSecond()).getWidgetNameStringId()));
            i = i2;
        }
        PopupMenu popupMenu2 = this.addWidgetChipPopupMenu;
        if (popupMenu2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addWidgetChipPopupMenu");
            popupMenu2 = null;
        }
        popupMenu2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$$ExternalSyntheticLambda2
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return WidgetGridNavFragment.onCreateView$lambda$7(map, this, fragmentActivityRequireActivity, contextRequireContext, menuItem);
            }
        });
        Chip chip4 = this.addWidgetChip;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addWidgetChip");
            chip4 = null;
        }
        chip4.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGridNavFragment.onCreateView$lambda$8(this.f$0, view);
            }
        });
        getDaijishouLibrary().getAllPlayableItemCount().observe(getViewLifecycleOwner(), new WidgetGridNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment.onCreateView.10
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                WidgetGridNavFragment widgetGridNavFragment = WidgetGridNavFragment.this;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = WidgetGridNavFragment.this.totalPlayableItemCountFormatString;
                TextView textView3 = null;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("totalPlayableItemCountFormatString");
                    str = null;
                }
                String str2 = String.format(str, Arrays.copyOf(new Object[]{num}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                widgetGridNavFragment.setDescriptionSecondString(str2);
                TextView textView4 = WidgetGridNavFragment.this.descriptionTextView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
                } else {
                    textView3 = textView4;
                }
                textView3.setText(WidgetGridNavFragment.this.getDescriptionFirstString() + WidgetGridNavFragment.this.getDescriptionSecondString());
            }
        }));
        getWidgetsManager().getWidgetInstancesLiveData().observe(getViewLifecycleOwner(), new WidgetGridNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends WidgetInstance>, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment.onCreateView.11
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends WidgetInstance> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends WidgetInstance> list) {
                WidgetGridNavFragment.this.widgetInstances.clear();
                List list2 = WidgetGridNavFragment.this.widgetInstances;
                Intrinsics.checkNotNull(list);
                list2.addAll(list);
                WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter7 = WidgetGridNavFragment.this.widgetFaceRecyclerViewAdapter;
                if (widgetFaceRecyclerViewAdapter7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
                    widgetFaceRecyclerViewAdapter7 = null;
                }
                widgetFaceRecyclerViewAdapter7.notifyDataSetChanged();
            }
        }));
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData2 = this.use24HourClockPreferenceLiveData;
        if (sharedPreferenceBooleanLiveData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("use24HourClockPreferenceLiveData");
        } else {
            sharedPreferenceBooleanLiveData = sharedPreferenceBooleanLiveData2;
        }
        sharedPreferenceBooleanLiveData.observe(getViewLifecycleOwner(), new WidgetGridNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment.onCreateView.12
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                SimpleDateFormat simpleDateFormat;
                Date date;
                TextView textView3 = WidgetGridNavFragment.this.clockFirstTextView;
                TextView textView4 = null;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clockFirstTextView");
                    textView3 = null;
                }
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
                    simpleDateFormat = WidgetGridNavFragment.clockTime24HourFormat;
                    date = new Date();
                } else {
                    simpleDateFormat = WidgetGridNavFragment.clockTimeFormat;
                    date = new Date();
                }
                textView3.setText(simpleDateFormat.format(date));
                TextView textView5 = WidgetGridNavFragment.this.clockSecondTextView;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clockSecondTextView");
                    textView5 = null;
                }
                textView5.setText(WidgetGridNavFragment.clockTimeAMPMFormat.format(new Date()));
                TextView textView6 = WidgetGridNavFragment.this.clockSecondTextView;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clockSecondTextView");
                } else {
                    textView4 = textView6;
                }
                textView4.setVisibility(bool.booleanValue() ? 8 : 0);
            }
        }));
        registerTimeTickBroadcast();
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$4(WidgetGridNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.widgetRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
            recyclerView = null;
        }
        recyclerView.smoothScrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$7(HashMap indexToWidgetBuilder, final WidgetGridNavFragment this$0, final FragmentActivity activity, final Context context, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(indexToWidgetBuilder, "$indexToWidgetBuilder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(context, "$context");
        Object obj = indexToWidgetBuilder.get(Integer.valueOf(menuItem.getItemId()));
        Intrinsics.checkNotNull(obj);
        final Class<? extends WidgetBuilder> cls = (Class) obj;
        if (Intrinsics.areEqual(cls, PinAndPlayWidgetBuilder.class)) {
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            final ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragmentNewInstance$default = ChoosePlayableItemFromLibraryDialogFragment.Companion.newInstance$default(ChoosePlayableItemFromLibraryDialogFragment.Companion, null, false, false, false, false, false, 63, null);
            choosePlayableItemFromLibraryDialogFragmentNewInstance$default.setOnClickListener(new Function1<PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$onCreateView$8$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
                    invoke2(playableItemEntity);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PlayableItemEntity playableItemEntity) {
                    Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
                    Toast.makeText(context, playableItemEntity.getName(), 0).show();
                    try {
                        WidgetsManager widgetsManager = this$0.getWidgetsManager();
                        FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
                        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                        Class<? extends WidgetBuilder> cls2 = cls;
                        Long lValueOf = Long.valueOf(playableItemEntity.getId());
                        final Ref.BooleanRef booleanRef2 = booleanRef;
                        final Context context2 = context;
                        final WidgetGridNavFragment widgetGridNavFragment = this$0;
                        widgetsManager.requestWidgetInstanceCreation((AppCompatActivity) fragmentActivityRequireActivity, cls2, lValueOf, new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$onCreateView$8$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z) {
                                booleanRef2.element = !z;
                                String str = null;
                                if (z) {
                                    Context context3 = context2;
                                    String str2 = widgetGridNavFragment.widgetCreatedSuccessfullyString;
                                    if (str2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("widgetCreatedSuccessfullyString");
                                    } else {
                                        str = str2;
                                    }
                                    Toast.makeText(context3, str, 0).show();
                                    return;
                                }
                                Context context4 = context2;
                                String str3 = widgetGridNavFragment.widgetCreateCanceledString;
                                if (str3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("widgetCreateCanceledString");
                                } else {
                                    str = str3;
                                }
                                Toast.makeText(context4, str, 0).show();
                            }
                        });
                    } catch (Exception e) {
                        this$0.getLogger().warn(this$0, ExceptionsKt.stackTraceToString(e));
                        Context context3 = context;
                        String str = this$0.widgetCreateCanceledString;
                        if (str == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("widgetCreateCanceledString");
                            str = null;
                        }
                        Toast.makeText(context3, str, 0).show();
                    }
                    choosePlayableItemFromLibraryDialogFragmentNewInstance$default.dismiss();
                }
            }).setOnDialogDismissedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$onCreateView$8$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (booleanRef.element) {
                        Context context2 = context;
                        String str = this$0.widgetCreateCanceledString;
                        if (str == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("widgetCreateCanceledString");
                            str = null;
                        }
                        Toast.makeText(context2, str, 0).show();
                    }
                }
            }).show(this$0.getParentFragmentManager(), ChoosePlayableItemFromLibraryDialogFragment.class.getName());
            return false;
        }
        final Function0 function0 = null;
        if (Intrinsics.areEqual(cls, AppShortcutWidgetBuilder.class)) {
            final WidgetGridNavFragment widgetGridNavFragment = this$0;
            final Lazy lazyCreateViewModelLazy = FragmentViewModelLazyKt.createViewModelLazy(widgetGridNavFragment, Reflection.getOrCreateKotlinClass(AppsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$onCreateView$lambda$7$$inlined$activityViewModels$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ViewModelStore invoke() {
                    return widgetGridNavFragment.requireActivity().getViewModelStore();
                }
            }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$onCreateView$lambda$7$$inlined$activityViewModels$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final CreationExtras invoke() {
                    CreationExtras creationExtras;
                    Function0 function1 = function0;
                    return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? widgetGridNavFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
                }
            }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$onCreateView$lambda$7$$inlined$activityViewModels$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ViewModelProvider.Factory invoke() {
                    return widgetGridNavFragment.requireActivity().getDefaultViewModelProviderFactory();
                }
            });
            final StaticResolveInfoCollectionDialogFragment staticResolveInfoCollectionDialogFragmentNewInstance$default = StaticResolveInfoCollectionDialogFragment.Companion.newInstance$default(StaticResolveInfoCollectionDialogFragment.Companion, onCreateView$lambda$7$lambda$6(lazyCreateViewModelLazy).getLauncherIntentResolveInfoList(), null, 2, null);
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            staticResolveInfoCollectionDialogFragmentNewInstance$default.setOnClickListener(new Function1<ResolveInfo, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$onCreateView$8$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ResolveInfo resolveInfo) {
                    invoke2(resolveInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ResolveInfo resolveInfo) {
                    Intrinsics.checkNotNullParameter(resolveInfo, "resolveInfo");
                    String strResolveInfoToResolveInfoStringId = WidgetGridNavFragment.onCreateView$lambda$7$lambda$6(lazyCreateViewModelLazy).resolveInfoToResolveInfoStringId(resolveInfo);
                    Toast.makeText(activity.getApplicationContext(), WidgetGridNavFragment.onCreateView$lambda$7$lambda$6(lazyCreateViewModelLazy).getResolveInfoStringIdToLabelCache().get(strResolveInfoToResolveInfoStringId), 0).show();
                    try {
                        WidgetsManager widgetsManager = this$0.getWidgetsManager();
                        FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
                        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                        Class<? extends WidgetBuilder> cls2 = cls;
                        final Ref.BooleanRef booleanRef3 = booleanRef2;
                        final Context context2 = context;
                        final WidgetGridNavFragment widgetGridNavFragment2 = this$0;
                        widgetsManager.requestWidgetInstanceCreation((AppCompatActivity) fragmentActivityRequireActivity, cls2, strResolveInfoToResolveInfoStringId, new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$onCreateView$8$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z) {
                                booleanRef3.element = !z;
                                String str = null;
                                if (z) {
                                    Context context3 = context2;
                                    String str2 = widgetGridNavFragment2.widgetCreatedSuccessfullyString;
                                    if (str2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("widgetCreatedSuccessfullyString");
                                    } else {
                                        str = str2;
                                    }
                                    Toast.makeText(context3, str, 0).show();
                                    return;
                                }
                                Context context4 = context2;
                                String str3 = widgetGridNavFragment2.widgetCreateCanceledString;
                                if (str3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("widgetCreateCanceledString");
                                } else {
                                    str = str3;
                                }
                                Toast.makeText(context4, str, 0).show();
                            }
                        });
                    } catch (Exception e) {
                        this$0.getLogger().warn(this$0, ExceptionsKt.stackTraceToString(e));
                        Context context3 = context;
                        String str = this$0.widgetCreateCanceledString;
                        if (str == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("widgetCreateCanceledString");
                            str = null;
                        }
                        Toast.makeText(context3, str, 0).show();
                    }
                    staticResolveInfoCollectionDialogFragmentNewInstance$default.dismiss();
                }
            }).setOnDialogDismissedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$onCreateView$8$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (booleanRef2.element) {
                        Toast.makeText(context, this$0.getString(R.string.canceled_period), 0).show();
                    }
                }
            }).show(this$0.getParentFragmentManager(), ChoosePlayableItemFromLibraryDialogFragment.class.getName());
            return false;
        }
        if (Intrinsics.areEqual(cls, RSSWidgetBuilder.class)) {
            RSSWidgetEditDialogFragment.Companion.newInstance(new RSSWidgetInstanceEntity(0L, null, null, 7, null)).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$onCreateView$8$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Toast.makeText(activity.getApplicationContext(), activity.getString(R.string.canceled_period), 0).show();
                }
            }).setOnEditedListener(new Function1<RSSWidgetInstanceEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$onCreateView$8$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RSSWidgetInstanceEntity rSSWidgetInstanceEntity) {
                    invoke2(rSSWidgetInstanceEntity);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(RSSWidgetInstanceEntity it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    WidgetsManager widgetsManager = this.this$0.getWidgetsManager();
                    FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
                    Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                    Class<? extends WidgetBuilder> cls2 = cls;
                    final Context context2 = context;
                    final WidgetGridNavFragment widgetGridNavFragment2 = this.this$0;
                    widgetsManager.requestWidgetInstanceCreation((AppCompatActivity) fragmentActivityRequireActivity, cls2, it, new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$onCreateView$8$6.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z) {
                            String str = null;
                            if (z) {
                                Context context3 = context2;
                                String str2 = widgetGridNavFragment2.widgetCreatedSuccessfullyString;
                                if (str2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("widgetCreatedSuccessfullyString");
                                } else {
                                    str = str2;
                                }
                                Toast.makeText(context3, str, 0).show();
                                return;
                            }
                            Context context4 = context2;
                            String str3 = widgetGridNavFragment2.widgetCreateCanceledString;
                            if (str3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("widgetCreateCanceledString");
                            } else {
                                str = str3;
                            }
                            Toast.makeText(context4, str, 0).show();
                        }
                    });
                }
            }).show(activity.getSupportFragmentManager(), RSSWidgetEditDialogFragment.class.getName());
            return false;
        }
        WidgetsManager widgetsManager = this$0.getWidgetsManager();
        FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        widgetsManager.requestWidgetInstanceCreation((AppCompatActivity) fragmentActivityRequireActivity, cls, null, new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.WidgetGridNavFragment$onCreateView$8$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                String str = null;
                if (z) {
                    Context context2 = context;
                    String str2 = this$0.widgetCreatedSuccessfullyString;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("widgetCreatedSuccessfullyString");
                    } else {
                        str = str2;
                    }
                    Toast.makeText(context2, str, 0).show();
                    return;
                }
                Context context3 = context;
                String str3 = this$0.widgetCreateCanceledString;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("widgetCreateCanceledString");
                } else {
                    str = str3;
                }
                Toast.makeText(context3, str, 0).show();
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppsViewModel onCreateView$lambda$7$lambda$6(Lazy<AppsViewModel> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$8(WidgetGridNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupMenu popupMenu = this$0.addWidgetChipPopupMenu;
        if (popupMenu == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addWidgetChipPopupMenu");
            popupMenu = null;
        }
        popupMenu.show();
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterTimeTickBroadcast();
    }
}
