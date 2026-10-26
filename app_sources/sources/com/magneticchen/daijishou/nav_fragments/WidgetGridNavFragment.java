package com.magneticchen.daijishou.nav_fragments;

import android.content.Context;
import android.content.IntentFilter;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment;
import com.magneticchen.daijishou.activities.MainActivity;
import com.magneticchen.daijishou.application_data.IntPreference;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouGridLayoutManager;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.daijishou_widget.WidgetsManager;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetInstance;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetNavFragment;
import com.magneticchen.daijishou.daijishou_widget.widget_db.RSSWidgetInstanceEntity;
import com.magneticchen.daijishou.daijishou_widget.widget_recycler_view.WidgetFaceRecyclerViewAdapter;
import com.magneticchen.daijishou.daijishou_widget.widgets.app_shortcut.AppShortcutWidgetBuilder;
import com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play.PinAndPlayWidgetBuilder;
import com.magneticchen.daijishou.daijishou_widget.widgets.rss.RSSWidgetBuilder;
import com.magneticchen.daijishou.daijishou_widget.widgets.rss.RSSWidgetEditDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.ChoosePlayableItemFromLibraryDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.StaticResolveInfoCollectionDialogFragment;
import com.magneticchen.daijishou.live_data.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.view_models.AppsViewModel;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* INFO: compiled from: WidgetGridNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000µ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002*\u0001&\u0018\u0000 V2\u00020\u0001:\u0001VB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010>\u001a\u00020\u001bH\u0016J\u0012\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J&\u0010C\u001a\u0004\u0018\u00010\u00192\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010H\u001a\u00020@H\u0016J \u0010I\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020@H\u0016J\b\u0010P\u001a\u00020@H\u0016J\b\u0010Q\u001a\u00020@H\u0002J\u0014\u0010R\u001a\u00020@2\n\u0010S\u001a\u00060TR\u00020/H\u0002J\b\u0010U\u001a\u00020@H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u000e\u0010\u0017\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\"\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u000e\u0010(\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020403X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010!\u001a\u0004\b;\u0010<¨\u0006W²\u0006\n\u0010X\u001a\u00020YX\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/WidgetGridNavFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouFragment;", "()V", "addWidgetChip", "Lcom/google/android/material/chip/Chip;", "addWidgetChipPopupMenu", "Landroidx/appcompat/widget/PopupMenu;", "chipIconTint", "Landroid/content/res/ColorStateList;", "clockConstraintLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "clockFirstTextView", "Landroid/widget/TextView;", "clockSecondTextView", "descriptionFirstString", "", "getDescriptionFirstString", "()Ljava/lang/String;", "setDescriptionFirstString", "(Ljava/lang/String;)V", "descriptionSecondString", "getDescriptionSecondString", "setDescriptionSecondString", "descriptionTextView", "divider", "Landroid/view/View;", "hasRegisteredTimeTickBroadcastReceiver", "", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "model$delegate", "Lkotlin/Lazy;", "moveString", "removeString", "scrollingOnBackPressed", "timeTickBroadcastReceiver", "com/magneticchen/daijishou/nav_fragments/WidgetGridNavFragment$timeTickBroadcastReceiver$1", "Lcom/magneticchen/daijishou/nav_fragments/WidgetGridNavFragment$timeTickBroadcastReceiver$1;", "totalPlayableItemCountFormatString", "use24HourClockPreferenceLiveData", "Lcom/magneticchen/daijishou/live_data/SharedPreferenceBooleanLiveData;", "viewCreatedBefore", "widgetCreateCanceledString", "widgetCreatedSuccessfullyString", "widgetFaceRecyclerViewAdapter", "Lcom/magneticchen/daijishou/daijishou_widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter;", "widgetGridLayoutManager", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouGridLayoutManager;", "widgetInstances", "", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetInstance;", "widgetRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "widgetRemoveCanceledString", "widgetRemovedSuccessfullyString", "widgetsManager", "Lcom/magneticchen/daijishou/daijishou_widget/WidgetsManager;", "getWidgetsManager", "()Lcom/magneticchen/daijishou/daijishou_widget/WidgetsManager;", "widgetsManager$delegate", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onHotKeyPressed", "hotkeyCode", "", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onKioskMode", "onNoneKioskMode", "registerTimeTickBroadcast", "showOptionsForViewHolder", "viewHolder", "Lcom/magneticchen/daijishou/daijishou_widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter$WidgetViewHolder;", "unregisterTimeTickBroadcast", "Companion", "app_release", "appsViewModel", "Lcom/magneticchen/daijishou/view_models/AppsViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetGridNavFragment extends DaijishouFragment {
    private static final IntentFilter timeTickIntentFilter;
    private Chip addWidgetChip;
    private PopupMenu addWidgetChipPopupMenu;
    private ColorStateList chipIconTint;
    private ConstraintLayout clockConstraintLayout;
    public TextView clockFirstTextView;
    public TextView clockSecondTextView;
    public TextView descriptionTextView;
    private View divider;
    private boolean hasRegisteredTimeTickBroadcastReceiver;

    /* INFO: renamed from: model$delegate, reason: from kotlin metadata */
    private final Lazy model;
    private String moveString;
    private String removeString;
    private boolean scrollingOnBackPressed;
    private String totalPlayableItemCountFormatString;
    public SharedPreferenceBooleanLiveData use24HourClockPreferenceLiveData;
    private boolean viewCreatedBefore;
    public String widgetCreateCanceledString;
    public String widgetCreatedSuccessfullyString;
    public WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter;
    private DaijishouGridLayoutManager widgetGridLayoutManager;
    private RecyclerView widgetRecyclerView;
    public String widgetRemoveCanceledString;
    public String widgetRemovedSuccessfullyString;

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final SimpleDateFormat clockTimeFormat = new SimpleDateFormat("hh:mm", Locale.getDefault());
    public static final SimpleDateFormat clockTime24HourFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
    public static final SimpleDateFormat clockTimeAMPMFormat = new SimpleDateFormat("aa", Locale.getDefault());
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy • ", Locale.getDefault());
    private String descriptionFirstString = "1, Jan, 1980. ";
    private String descriptionSecondString = "Daijishō Launcher.";
    private final WidgetGridNavFragment$timeTickBroadcastReceiver$1 timeTickBroadcastReceiver = new WidgetGridNavFragment$timeTickBroadcastReceiver$1(this);
    public final List<WidgetInstance> widgetInstances = new ArrayList();

    /* INFO: renamed from: widgetsManager$delegate, reason: from kotlin metadata */
    private final Lazy widgetsManager = LazyKt.lazy(new WidgetGridNavFragment$widgetsManager$2(this));

    public WidgetGridNavFragment() {
        WidgetGridNavFragment widgetGridNavFragment = this;
        this.model = FragmentViewModelLazyKt.createViewModelLazy(widgetGridNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new WidgetGridNavFragment$special$$inlined$activityViewModels$default$1(widgetGridNavFragment), new WidgetGridNavFragment$special$$inlined$activityViewModels$default$2(null, widgetGridNavFragment), new WidgetGridNavFragment$special$$inlined$activityViewModels$default$3(widgetGridNavFragment));
    }

    /* INFO: compiled from: WidgetGridNavFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/WidgetGridNavFragment$Companion;", "", "()V", "clockTime24HourFormat", "Ljava/text/SimpleDateFormat;", "clockTimeAMPMFormat", "clockTimeFormat", "dateFormat", "timeTickIntentFilter", "Landroid/content/IntentFilter;", "newInstance", "Lcom/magneticchen/daijishou/nav_fragments/WidgetGridNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* INFO: Access modifiers changed from: private */
    public final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model.getValue();
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

    /* INFO: Access modifiers changed from: private */
    public final WidgetsManager getWidgetsManager() {
        return (WidgetsManager) this.widgetsManager.getValue();
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public void onKioskMode() {
        super.onKioskMode();
        Chip chip = this.addWidgetChip;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addWidgetChip");
            chip = null;
        }
        chip.setVisibility(8);
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public void onNoneKioskMode() {
        super.onNoneKioskMode();
        Chip chip = this.addWidgetChip;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addWidgetChip");
            chip = null;
        }
        chip.setVisibility(0);
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onHotKeyPressed(int hotkeyCode, int keyCode, KeyEvent keyEvent) {
        View view;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(hotkeyCode, keyCode, keyEvent);
        Chip chip = null;
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter = null;
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter2 = null;
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter3 = null;
        ConstraintLayout constraintLayout = null;
        if (hotkeyCode == 1) {
            if (getIsKioskMode()) {
                return false;
            }
            Chip chip2 = this.addWidgetChip;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addWidgetChip");
                chip2 = null;
            }
            chip2.requestFocus();
            Chip chip3 = this.addWidgetChip;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addWidgetChip");
            } else {
                chip = chip3;
            }
            chip.performClick();
            return true;
        }
        if (hotkeyCode == 2) {
            ConstraintLayout constraintLayout2 = this.clockConstraintLayout;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clockConstraintLayout");
                constraintLayout2 = null;
            }
            constraintLayout2.requestFocus();
            ConstraintLayout constraintLayout3 = this.clockConstraintLayout;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clockConstraintLayout");
            } else {
                constraintLayout = constraintLayout3;
            }
            constraintLayout.performClick();
            return true;
        }
        if (hotkeyCode != 3) {
            if (hotkeyCode != 4) {
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
        if (getIsKioskMode()) {
            return false;
        }
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter5 = this.widgetFaceRecyclerViewAdapter;
        if (widgetFaceRecyclerViewAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
            widgetFaceRecyclerViewAdapter5 = null;
        }
        if (widgetFaceRecyclerViewAdapter5.get_requestMovingViewHolderPositionMode()) {
            WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter6 = this.widgetFaceRecyclerViewAdapter;
            if (widgetFaceRecyclerViewAdapter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
            } else {
                widgetFaceRecyclerViewAdapter2 = widgetFaceRecyclerViewAdapter6;
            }
            DaijishouRecyclerView.Adapter<WidgetInstance>.ViewHolder selectedViewHolder2 = widgetFaceRecyclerViewAdapter2.getSelectedViewHolder();
            if (selectedViewHolder2 != null && (view = selectedViewHolder2.itemView) != null) {
                view.performClick();
            }
            return false;
        }
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter7 = this.widgetFaceRecyclerViewAdapter;
        if (widgetFaceRecyclerViewAdapter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
        } else {
            widgetFaceRecyclerViewAdapter3 = widgetFaceRecyclerViewAdapter7;
        }
        DaijishouRecyclerView.Adapter<WidgetInstance>.ViewHolder selectedViewHolder3 = widgetFaceRecyclerViewAdapter3.getSelectedViewHolder();
        if (selectedViewHolder3 != null && selectedViewHolder3.itemView.isFocused() && selectedViewHolder3.getAbsoluteAdapterPosition() >= 0) {
            ((WidgetFaceRecyclerViewAdapter.WidgetViewHolder) selectedViewHolder3).requestMovingPosition(new WidgetGridNavFragment$onHotKeyPressed$1$1(this));
        }
        return true;
    }

    /* WARN: Code duplicated, block: B:18:0x0033  */
    /* WARN: Code duplicated, block: B:20:0x0037  */
    /* WARN: Code duplicated, block: B:32:0x0059  */
    /* WARN: Code duplicated, block: B:34:0x005f  */
    /* WARN: Code duplicated, block: B:37:0x006a  */
    /* WARN: Code duplicated, block: B:38:0x006e  */
    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onBackPressed() {
        RecyclerView recyclerView;
        ConstraintLayout constraintLayout;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3 = this.widgetRecyclerView;
        RecyclerView recyclerView4 = null;
        ConstraintLayout constraintLayout2 = null;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
            recyclerView3 = null;
        }
        RecyclerView.Adapter adapter = recyclerView3.getAdapter();
        if (adapter != null) {
            WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter = (WidgetFaceRecyclerViewAdapter) adapter;
            if (widgetFaceRecyclerViewAdapter.get_requestMovingViewHolderPositionMode()) {
                widgetFaceRecyclerViewAdapter.cancelMovingPosition();
                return false;
            }
        }
        if (this.scrollingOnBackPressed) {
            RecyclerView recyclerView5 = this.widgetRecyclerView;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
                recyclerView5 = null;
            }
            if (recyclerView5.getScrollState() != 1) {
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
                    recyclerView2 = this.widgetRecyclerView;
                    if (recyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
                    } else {
                        recyclerView4 = recyclerView2;
                    }
                    recyclerView4.smoothScrollToPosition(0);
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
                recyclerView2 = this.widgetRecyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
                } else {
                    recyclerView4 = recyclerView2;
                }
                recyclerView4.smoothScrollToPosition(0);
                return false;
            }
        }
        RecyclerView recyclerView6 = this.widgetRecyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
            recyclerView6 = null;
        }
        recyclerView6.scrollToPosition(0);
        ConstraintLayout constraintLayout3 = this.clockConstraintLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clockConstraintLayout");
        } else {
            constraintLayout2 = constraintLayout3;
        }
        constraintLayout2.requestFocus();
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

    /* INFO: Access modifiers changed from: private */
    public final void showOptionsForViewHolder(WidgetFaceRecyclerViewAdapter.WidgetViewHolder viewHolder) {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.magneticchen.daijishou.activities.MainActivity");
        WidgetsManager widgetsManager = ((MainActivity) activity).getWidgetsManager();
        WidgetInstance widgetInstance = widgetsManager.getWidgetInstanceList().get(viewHolder.getAbsoluteAdapterPosition());
        PopupMenu popupMenu = new PopupMenu(requireContext(), viewHolder.itemView);
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
        if (!getIsKioskMode()) {
            Menu menu = popupMenu.getMenu();
            int size = widgetInstance.getActions().size();
            String str2 = this.moveString;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("moveString");
                str2 = null;
            }
            menu.add(1, 0, size, "📦 " + str2);
        }
        if (!getIsKioskMode()) {
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
        if (!getIsKioskMode() && Build.VERSION.SDK_INT >= 28) {
            popupMenu.getMenu().setGroupDividerEnabled(true);
        }
        popupMenu.setOnMenuItemClickListener(new WidgetGridNavFragment$$ExternalSyntheticLambda3(widgetInstance, this, viewHolder, widgetsManager));
        popupMenu.show();
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean showOptionsForViewHolder$lambda$3(WidgetInstance widgetInstance, WidgetGridNavFragment this$0, WidgetFaceRecyclerViewAdapter.WidgetViewHolder viewHolder, WidgetsManager widgetsManager, MenuItem menuItem) {
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
            if (widgetFaceRecyclerViewAdapter.get_requestMovingViewHolderPositionMode()) {
                return false;
            }
            viewHolder.requestMovingPosition(new WidgetGridNavFragment$showOptionsForViewHolder$2$1(this$0, widgetsManager));
            return false;
        }
        if (menuItem.getGroupId() != 1 || menuItem.getItemId() != 1) {
            return false;
        }
        FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        widgetsManager.requestWidgetInstanceRemoval((AppCompatActivity) fragmentActivityRequireActivity, widgetInstance, new WidgetGridNavFragment$showOptionsForViewHolder$2$2(this$0));
        return false;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        View viewInflate = inflater.inflate(R.layout.fragment_widget_gird, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_widget_grid_clock_first_textview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.clockFirstTextView = (TextView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.fragment_widget_grid_clock_second_textview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.clockSecondTextView = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.fragment_widget_grid_clock);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.clockConstraintLayout = (ConstraintLayout) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.fragment_widget_grid_description_textview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.descriptionTextView = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.fragment_widget_grid_create_widget_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.addWidgetChip = (Chip) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.fragment_widget_grid_divider);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.divider = viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.fragment_widget_grid_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.widgetRecyclerView = (RecyclerView) viewFindViewById7;
        this.widgetFaceRecyclerViewAdapter = new WidgetFaceRecyclerViewAdapter(this, this.widgetInstances);
        this.widgetGridLayoutManager = new DaijishouGridLayoutManager(contextRequireContext, 117.0f, 8, 0.0f, false, 24, null);
        Chip chip = this.addWidgetChip;
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addWidgetChip");
            chip = null;
        }
        this.addWidgetChipPopupMenu = new PopupMenu(contextRequireContext, chip);
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
        chip3.setVisibility(getIsKioskMode() ? 8 : 0);
        ConstraintLayout constraintLayout = this.clockConstraintLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clockConstraintLayout");
            constraintLayout = null;
        }
        constraintLayout.setOnClickListener(new WidgetGridNavFragment$$ExternalSyntheticLambda0(this));
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
        widgetFaceRecyclerViewAdapter3.setOnItemSelectListener(new AnonymousClass2());
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter4 = this.widgetFaceRecyclerViewAdapter;
        if (widgetFaceRecyclerViewAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
            widgetFaceRecyclerViewAdapter4 = null;
        }
        widgetFaceRecyclerViewAdapter4.setOnWidgetClickListener(new AnonymousClass3());
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter5 = this.widgetFaceRecyclerViewAdapter;
        if (widgetFaceRecyclerViewAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
            widgetFaceRecyclerViewAdapter5 = null;
        }
        widgetFaceRecyclerViewAdapter5.setOnWidgetLongClickListener(new AnonymousClass4());
        RecyclerView recyclerView = this.widgetRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
            recyclerView = null;
        }
        recyclerView.addOnScrollListener(new AnonymousClass5());
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
        recyclerView2.setLayoutManager(daijishouGridLayoutManager);
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
        recyclerView4.addOnScrollListener(new AnonymousClass6());
        HashMap map = new HashMap();
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
        popupMenu2.setOnMenuItemClickListener(new WidgetGridNavFragment$$ExternalSyntheticLambda1(map, this, fragmentActivityRequireActivity, contextRequireContext));
        Chip chip4 = this.addWidgetChip;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addWidgetChip");
            chip4 = null;
        }
        chip4.setOnClickListener(new WidgetGridNavFragment$$ExternalSyntheticLambda2(this));
        getDaijishouLibrary().getAllPlayableItemCount().observe(getViewLifecycleOwner(), new WidgetGridNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass10()));
        getWidgetsManager().getWidgetInstancesLiveData().observe(getViewLifecycleOwner(), new WidgetGridNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass11()));
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData2 = this.use24HourClockPreferenceLiveData;
        if (sharedPreferenceBooleanLiveData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("use24HourClockPreferenceLiveData");
        } else {
            sharedPreferenceBooleanLiveData = sharedPreferenceBooleanLiveData2;
        }
        sharedPreferenceBooleanLiveData.observe(getViewLifecycleOwner(), new WidgetGridNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass12()));
        registerTimeTickBroadcast();
        return viewInflate;
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$4(WidgetGridNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.widgetRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
            recyclerView = null;
        }
        recyclerView.smoothScrollToPosition(0);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.WidgetGridNavFragment$onCreateView$2, reason: invalid class name */
    /* INFO: compiled from: WidgetGridNavFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "position", "", "<anonymous parameter 2>", "", "widgetInstance", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetInstance;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda<Unit> implements Function4<View, Integer, Long, WidgetInstance, Unit> {
        AnonymousClass2() {
            super(4);
        }

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
    }

    /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.WidgetGridNavFragment$onCreateView$3, reason: invalid class name */
    /* INFO: compiled from: WidgetGridNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/magneticchen/daijishou/daijishou_widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter$WidgetViewHolder;", "Lcom/magneticchen/daijishou/daijishou_widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter;", "position", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass3 extends Lambda<Unit> implements Function2<WidgetFaceRecyclerViewAdapter.WidgetViewHolder, Integer, Unit> {
        AnonymousClass3() {
            super(2);
        }

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
    }

    /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.WidgetGridNavFragment$onCreateView$4, reason: invalid class name */
    /* INFO: compiled from: WidgetGridNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "viewHolder", "Lcom/magneticchen/daijishou/daijishou_widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter$WidgetViewHolder;", "Lcom/magneticchen/daijishou/daijishou_widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass4 extends Lambda<Unit> implements Function2<WidgetFaceRecyclerViewAdapter.WidgetViewHolder, Integer, Unit> {
        AnonymousClass4() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(WidgetFaceRecyclerViewAdapter.WidgetViewHolder widgetViewHolder, Integer num) {
            invoke(widgetViewHolder, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(WidgetFaceRecyclerViewAdapter.WidgetViewHolder viewHolder, int i) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            WidgetGridNavFragment.this.showOptionsForViewHolder(viewHolder);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.WidgetGridNavFragment$onCreateView$5, reason: invalid class name */
    /* INFO: compiled from: WidgetGridNavFragment.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/magneticchen/daijishou/nav_fragments/WidgetGridNavFragment$onCreateView$5", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass5 extends RecyclerView.OnScrollListener {
        AnonymousClass5() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            RecyclerView recyclerView2 = WidgetGridNavFragment.this.widgetRecyclerView;
            View view = null;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("widgetRecyclerView");
                recyclerView2 = null;
            }
            boolean z = recyclerView2.computeVerticalScrollOffset() > WidgetGridNavFragment.this.getDpToPxConverter().convert(8.0f);
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
    }

    /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.WidgetGridNavFragment$onCreateView$6, reason: invalid class name */
    /* INFO: compiled from: WidgetGridNavFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/nav_fragments/WidgetGridNavFragment$onCreateView$6", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass6 extends RecyclerView.OnScrollListener {
        AnonymousClass6() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                WidgetGridNavFragment.this.scrollingOnBackPressed = false;
            }
            super.onScrollStateChanged(recyclerView, newState);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$7(HashMap indexToWidgetBuilder, WidgetGridNavFragment this$0, FragmentActivity activity, Context context, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(indexToWidgetBuilder, "$indexToWidgetBuilder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(context, "$context");
        Object obj = indexToWidgetBuilder.get(Integer.valueOf(menuItem.getItemId()));
        Intrinsics.checkNotNull(obj);
        Class<? extends WidgetBuilder> cls = (Class) obj;
        if (Intrinsics.areEqual(cls, PinAndPlayWidgetBuilder.class)) {
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragmentNewInstance$default = ChoosePlayableItemFromLibraryDialogFragment.Companion.newInstance$default(ChoosePlayableItemFromLibraryDialogFragment.INSTANCE, null, false, false, false, false, false, 63, null);
            choosePlayableItemFromLibraryDialogFragmentNewInstance$default.setOnClickListener(new WidgetGridNavFragment$onCreateView$8$1(context, this$0, cls, choosePlayableItemFromLibraryDialogFragmentNewInstance$default, booleanRef)).setOnDialogDismissedListener(new WidgetGridNavFragment$onCreateView$8$2(booleanRef, context, this$0)).show(this$0.getParentFragmentManager(), ChoosePlayableItemFromLibraryDialogFragment.class.getName());
            return false;
        }
        if (Intrinsics.areEqual(cls, AppShortcutWidgetBuilder.class)) {
            WidgetGridNavFragment widgetGridNavFragment = this$0;
            Lazy lazyCreateViewModelLazy = FragmentViewModelLazyKt.createViewModelLazy(widgetGridNavFragment, Reflection.getOrCreateKotlinClass(AppsViewModel.class), new WidgetGridNavFragment$onCreateView$lambda$7$$inlined$activityViewModels$default$1(widgetGridNavFragment), new WidgetGridNavFragment$onCreateView$lambda$7$$inlined$activityViewModels$default$2(null, widgetGridNavFragment), new WidgetGridNavFragment$onCreateView$lambda$7$$inlined$activityViewModels$default$3(widgetGridNavFragment));
            StaticResolveInfoCollectionDialogFragment staticResolveInfoCollectionDialogFragmentNewInstance$default = StaticResolveInfoCollectionDialogFragment.Companion.newInstance$default(StaticResolveInfoCollectionDialogFragment.INSTANCE, onCreateView$lambda$7$lambda$6(lazyCreateViewModelLazy).getLauncherIntentResolveInfoList(), null, 2, null);
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            staticResolveInfoCollectionDialogFragmentNewInstance$default.setOnClickListener(new WidgetGridNavFragment$onCreateView$8$3(activity, this$0, cls, context, staticResolveInfoCollectionDialogFragmentNewInstance$default, lazyCreateViewModelLazy, booleanRef2)).setOnDialogDismissedListener(new WidgetGridNavFragment$onCreateView$8$4(booleanRef2, context, this$0)).show(this$0.getParentFragmentManager(), ChoosePlayableItemFromLibraryDialogFragment.class.getName());
            return false;
        }
        if (Intrinsics.areEqual(cls, RSSWidgetBuilder.class)) {
            RSSWidgetEditDialogFragment.INSTANCE.newInstance(new RSSWidgetInstanceEntity(0L, null, null, 7, null)).setOnCanceledListener(new WidgetGridNavFragment$onCreateView$8$5(activity)).setOnEditedListener(new WidgetGridNavFragment$onCreateView$8$6(this$0, cls, context)).show(activity.getSupportFragmentManager(), RSSWidgetEditDialogFragment.class.getName());
            return false;
        }
        WidgetsManager widgetsManager = this$0.getWidgetsManager();
        FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        widgetsManager.requestWidgetInstanceCreation((AppCompatActivity) fragmentActivityRequireActivity, cls, null, new WidgetGridNavFragment$onCreateView$8$7(context, this$0));
        return false;
    }

    /* INFO: Access modifiers changed from: private */
    public static final AppsViewModel onCreateView$lambda$7$lambda$6(Lazy<AppsViewModel> lazy) {
        return lazy.getValue();
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$8(WidgetGridNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupMenu popupMenu = this$0.addWidgetChipPopupMenu;
        if (popupMenu == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addWidgetChipPopupMenu");
            popupMenu = null;
        }
        popupMenu.show();
    }

    /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.WidgetGridNavFragment$onCreateView$10, reason: invalid class name */
    /* INFO: compiled from: WidgetGridNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass10 extends Lambda<Unit> implements Function1<Integer, Unit> {
        AnonymousClass10() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            WidgetGridNavFragment widgetGridNavFragment = WidgetGridNavFragment.this;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = WidgetGridNavFragment.this.totalPlayableItemCountFormatString;
            TextView textView = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("totalPlayableItemCountFormatString");
                str = null;
            }
            String str2 = String.format(str, Arrays.copyOf(new Object[]{num}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            widgetGridNavFragment.setDescriptionSecondString(str2);
            TextView textView2 = WidgetGridNavFragment.this.descriptionTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
            } else {
                textView = textView2;
            }
            textView.setText(WidgetGridNavFragment.this.getDescriptionFirstString() + WidgetGridNavFragment.this.getDescriptionSecondString());
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.WidgetGridNavFragment$onCreateView$11, reason: invalid class name */
    /* INFO: compiled from: WidgetGridNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetInstance;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass11 extends Lambda<Unit> implements Function1<List<? extends WidgetInstance>, Unit> {
        AnonymousClass11() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends WidgetInstance> list) {
            invoke2(list);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends WidgetInstance> list) {
            WidgetGridNavFragment.this.widgetInstances.clear();
            List list2 = WidgetGridNavFragment.this.widgetInstances;
            Intrinsics.checkNotNull(list);
            list2.addAll(list);
            WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter = WidgetGridNavFragment.this.widgetFaceRecyclerViewAdapter;
            if (widgetFaceRecyclerViewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
                widgetFaceRecyclerViewAdapter = null;
            }
            widgetFaceRecyclerViewAdapter.notifyDataSetChanged();
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.nav_fragments.WidgetGridNavFragment$onCreateView$12, reason: invalid class name */
    /* INFO: compiled from: WidgetGridNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "use24HourClock", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass12 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        AnonymousClass12() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            SimpleDateFormat simpleDateFormat;
            Date date;
            TextView textView = WidgetGridNavFragment.this.clockFirstTextView;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clockFirstTextView");
                textView = null;
            }
            Intrinsics.checkNotNull(bool);
            if (bool.booleanValue()) {
                simpleDateFormat = WidgetGridNavFragment.clockTime24HourFormat;
                date = new Date();
            } else {
                simpleDateFormat = WidgetGridNavFragment.clockTimeFormat;
                date = new Date();
            }
            textView.setText(simpleDateFormat.format(date));
            TextView textView3 = WidgetGridNavFragment.this.clockSecondTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clockSecondTextView");
                textView3 = null;
            }
            textView3.setText(WidgetGridNavFragment.clockTimeAMPMFormat.format(new Date()));
            TextView textView4 = WidgetGridNavFragment.this.clockSecondTextView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clockSecondTextView");
            } else {
                textView2 = textView4;
            }
            textView2.setVisibility(bool.booleanValue() ? 8 : 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        unregisterTimeTickBroadcast();
    }
}
