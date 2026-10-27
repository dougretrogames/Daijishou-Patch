package com.magneticchen.daijishou.ui.widget.widget_recycler_view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetInstance;
import com.magneticchen.daijishou.utils.DpToPxConverter;
import com.magneticchen.daijishou.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WidgetFaceRecyclerViewAdapter.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 h2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004hijkB\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u00107\u001a\u00020&2\n\u00108\u001a\u00060%R\u00020\u00002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020&J\u0010\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020&2\u0006\u0010B\u001a\u00020 H\u0002J\b\u0010C\u001a\u00020&H\u0002J\u0010\u0010D\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020 H\u0002J\u0010\u0010E\u001a\u00020@2\u0006\u0010B\u001a\u00020 H\u0016J\u0010\u0010F\u001a\u00020\n2\u0006\u0010?\u001a\u00020@H\u0002J\u0017\u0010G\u001a\u0004\u0018\u00010@2\u0006\u0010H\u001a\u00020 H\u0002¢\u0006\u0002\u0010IJ\u0010\u0010J\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0017J\u001c\u0010K\u001a\u00060%R\u00020\u00002\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020 H\u0016J\u0010\u0010O\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0017J\u001a\u0010P\u001a\u00020\n2\u0010\u00108\u001a\f0QR\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016J\u001a\u0010R\u001a\u00020&2\u0010\u00108\u001a\f0QR\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016J\u001a\u0010S\u001a\u00020&2\u0010\u00108\u001a\f0QR\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016J\u0012\u0010T\u001a\u00020&2\n\u00108\u001a\u00060%R\u00020\u0000J\u0010\u0010U\u001a\u00020&2\u0006\u0010?\u001a\u00020@H\u0002J.\u0010V\u001a\u00020&2\n\u0010W\u001a\u00060%R\u00020\u00002\u0018\u0010/\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020&0$H\u0002J\u0010\u0010X\u001a\u00020&2\u0006\u0010Y\u001a\u00020ZH\u0016J\b\u0010[\u001a\u00020ZH\u0016J\b\u0010\\\u001a\u00020&H\u0002J$\u0010]\u001a\u00020&2\n\u00108\u001a\u00060%R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010^\u001a\u00020&2\u0006\u0010_\u001a\u00020\nH\u0016J\u0010\u0010`\u001a\u00020&2\u0006\u0010a\u001a\u00020\nH\u0002J$\u0010b\u001a\u00020&2\u001c\u0010#\u001a\u0018\u0012\b\u0012\u00060%R\u00020\u0000\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020&0$J*\u0010c\u001a\u00020&2\"\u0010'\u001a\u001e\u0012\b\u0012\u00060%R\u00020\u0000\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020&0(J$\u0010d\u001a\u00020&2\u001c\u0010)\u001a\u0018\u0012\b\u0012\u00060%R\u00020\u0000\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020&0$J$\u0010e\u001a\u00020&2\u001c\u0010*\u001a\u0018\u0012\b\u0012\u00060%R\u00020\u0000\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020&0$J\u0010\u0010f\u001a\u00020&2\b\u00104\u001a\u0004\u0018\u000105J\u0006\u0010g\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0018\u00010\u0017R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010#\u001a\u001a\u0012\b\u0012\u00060%R\u00020\u0000\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020&\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010'\u001a \u0012\b\u0012\u00060%R\u00020\u0000\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020&\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010)\u001a\u001a\u0012\b\u0012\u00060%R\u00020\u0000\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020&\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010*\u001a\u001a\u0012\b\u0012\u00060%R\u00020\u0000\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020&\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0018\u00010%R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010/\u001a\u0016\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020&\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00100\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b1\u0010\u000fR\u0016\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001030\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetInstance;", "Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/StatefulAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "widgetInstances", "", "(Landroidx/fragment/app/Fragment;Ljava/util/List;)V", "_requestMovingViewHolderPositionMode", "", "dpToPxConverter", "Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "enforceSelectionInSelectableMode", "getEnforceSelectionInSelectableMode", "()Z", "setEnforceSelectionInSelectableMode", "(Z)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "fragmentMaxLifecycleEnforcer", "Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter$FragmentMaxLifecycleEnforcer;", "fragments", "Landroidx/collection/LongSparseArray;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "getFragments", "()Landroidx/collection/LongSparseArray;", "hasStaleFragments", "isInGracePeriod", "itemIdToViewHolder", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "onWidgetClickListener", "Lkotlin/Function2;", "Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter$WidgetViewHolder;", "", "onWidgetFocusChangeListener", "Lkotlin/Function3;", "onWidgetLongClickListener", "onWidgetSelectListener", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "requestMovingViewHolderFromPosition", "requestMovingViewHolderFromPositionViewHolder", "requestMovingViewHolderPositionCallback", "requestMovingViewHolderPositionMode", "getRequestMovingViewHolderPositionMode", "savedStates", "Landroidx/fragment/app/Fragment$SavedState;", "strokeColorTheme", "Landroid/content/res/ColorStateList;", "textColor", "addViewToContainer", "holder", "v", "Landroid/view/View;", "container", "Landroidx/fragment/app/FragmentContainerView;", "cancelMovingPosition", "containsItem", "itemId", "", "ensureFragment", "position", "gcFragments", "getFragmentAtPosition", "getItemId", "isFragmentViewBound", "itemForViewHolder", "viewHolderId", "(I)Ljava/lang/Long;", "onAttachedToRecyclerView", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "onFailedToRecycleView", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "onViewAttachedToWindow", "onViewRecycled", "placeFragmentInViewHolder", "removeFragment", "requestMovingViewHolderPosition", "viewHolder", "restoreState", "savedState", "Landroid/os/Parcelable;", "saveState", "scheduleGracePeriodEnd", "scheduleViewAttach", "setHasStableIds", "hasStableIds", "setItemViewsFocusableInTouchMode", "focusable", "setOnWidgetClickListener", "setOnWidgetFocusChangeListener", "setOnWidgetLongClickListener", "setOnWidgetSelectListener", "setStrokeColorTheme", "shouldDelayFragmentTransactions", "Companion", "DataSetChangeObserver", "FragmentMaxLifecycleEnforcer", "WidgetViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetFaceRecyclerViewAdapter extends DaijishouRecyclerView.Adapter<WidgetInstance> implements StatefulAdapter {
    public static final Companion Companion = new Companion(null);
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    private boolean _requestMovingViewHolderPositionMode;
    private DpToPxConverter dpToPxConverter;
    private boolean enforceSelectionInSelectableMode;
    private final Fragment fragment;
    private final FragmentManager fragmentManager;
    private FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer;
    private final LongSparseArray<WidgetFaceFragment> fragments;
    private boolean hasStaleFragments;
    private boolean isInGracePeriod;
    private final LongSparseArray<Integer> itemIdToViewHolder;
    private final Lifecycle lifecycle;
    private Function2<? super WidgetViewHolder, ? super Integer, Unit> onWidgetClickListener;
    private Function3<? super WidgetViewHolder, ? super Integer, ? super Boolean, Unit> onWidgetFocusChangeListener;
    private Function2<? super WidgetViewHolder, ? super Integer, Unit> onWidgetLongClickListener;
    private Function2<? super WidgetViewHolder, ? super Integer, Unit> onWidgetSelectListener;
    private RecyclerView recyclerView;
    private int requestMovingViewHolderFromPosition;
    private WidgetViewHolder requestMovingViewHolderFromPositionViewHolder;
    private Function2<? super Integer, ? super Integer, Unit> requestMovingViewHolderPositionCallback;
    private final LongSparseArray<Fragment.SavedState> savedStates;
    private ColorStateList strokeColorTheme;
    private ColorStateList textColor;
    private final List<WidgetInstance> widgetInstances;

    public boolean onFailedToRecycleView(DaijishouRecyclerView.Adapter<WidgetInstance>.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return true;
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFaceRecyclerViewAdapter(Fragment fragment, List<WidgetInstance> widgetInstances) {
        super(widgetInstances, true, false);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(widgetInstances, "widgetInstances");
        this.fragment = fragment;
        this.widgetInstances = widgetInstances;
        this.fragments = new LongSparseArray<>(0, 1, (DefaultConstructorMarker) null);
        this.savedStates = new LongSparseArray<>(0, 1, (DefaultConstructorMarker) null);
        this.itemIdToViewHolder = new LongSparseArray<>(0, 1, (DefaultConstructorMarker) null);
        this.requestMovingViewHolderFromPosition = -1;
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        this.fragmentManager = childFragmentManager;
        Lifecycle lifecycle = fragment.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
        this.lifecycle = lifecycle;
        super.setHasStableIds(true);
        setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.ALLOW);
    }

    public final LongSparseArray<WidgetFaceFragment> getFragments() {
        return this.fragments;
    }

    @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter
    public boolean getEnforceSelectionInSelectableMode() {
        return this.enforceSelectionInSelectableMode;
    }

    @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter
    public void setEnforceSelectionInSelectableMode(boolean z) {
        this.enforceSelectionInSelectableMode = z;
    }

    public final boolean getRequestMovingViewHolderPositionMode() {
        return this._requestMovingViewHolderPositionMode;
    }

    public final void setStrokeColorTheme(ColorStateList colorStateList) {
        if (Intrinsics.areEqual(colorStateList, this.strokeColorTheme)) {
            return;
        }
        this.strokeColorTheme = colorStateList;
        notifyDataSetChanged();
    }

    public final void setOnWidgetSelectListener(Function2<? super WidgetViewHolder, ? super Integer, Unit> onWidgetSelectListener) {
        Intrinsics.checkNotNullParameter(onWidgetSelectListener, "onWidgetSelectListener");
        this.onWidgetSelectListener = onWidgetSelectListener;
    }

    public final void setOnWidgetClickListener(Function2<? super WidgetViewHolder, ? super Integer, Unit> onWidgetClickListener) {
        Intrinsics.checkNotNullParameter(onWidgetClickListener, "onWidgetClickListener");
        this.onWidgetClickListener = onWidgetClickListener;
    }

    public final void setOnWidgetLongClickListener(Function2<? super WidgetViewHolder, ? super Integer, Unit> onWidgetLongClickListener) {
        Intrinsics.checkNotNullParameter(onWidgetLongClickListener, "onWidgetLongClickListener");
        this.onWidgetLongClickListener = onWidgetLongClickListener;
    }

    public final void setOnWidgetFocusChangeListener(Function3<? super WidgetViewHolder, ? super Integer, ? super Boolean, Unit> onWidgetFocusChangeListener) {
        Intrinsics.checkNotNullParameter(onWidgetFocusChangeListener, "onWidgetFocusChangeListener");
        this.onWidgetFocusChangeListener = onWidgetFocusChangeListener;
    }

    /* JADX INFO: compiled from: WidgetFaceRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020&H\u0002J\u0018\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u0003H\u0016J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020&H\u0016J\u0010\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020,H\u0016J\b\u00100\u001a\u00020,H\u0016J \u00101\u001a\u00020&2\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020&03J\b\u00104\u001a\u00020&H\u0002J&\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020,2\n\b\u0002\u00107\u001a\u0004\u0018\u0001082\n\b\u0002\u00109\u001a\u0004\u0018\u000108J\b\u0010:\u001a\u00020&H\u0002J\b\u0010;\u001a\u00020&H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0017*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter$WidgetViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetInstance;", "adapter", "Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter;Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter;Landroid/view/View;)V", "getAdapter", "()Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter;", "background", "Lcom/google/android/material/card/MaterialCardView;", "baseElevation", "", "baseStrokeColor", "Landroid/content/res/ColorStateList;", "baseStrokeWidth", "", "container", "Landroidx/constraintlayout/widget/ConstraintLayout;", "defaultStrokeColorTheme", "defaultTextColor", "kotlin.jvm.PlatformType", "descriptionTextView", "Landroid/widget/TextView;", "fragmentContainer", "Landroidx/fragment/app/FragmentContainerView;", "getFragmentContainer", "()Landroidx/fragment/app/FragmentContainerView;", "highlightElevation", "highlightStrokeWidth", "nameTextView", "placeholderImageView", "Landroid/widget/ImageView;", "selectedImageView", "strokeColorTheme", "hideFragment", "", "highlight", "onBind", "position", "item", "onClick", "", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "onLongClick", "requestMovingPosition", "requestMovingViewHolderPositionCallback", "Lkotlin/Function2;", "semiHighlight", "setDescriptionMode", "moveMode", "title", "", "description", "showFragment", "unHighlight", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class WidgetViewHolder extends DaijishouRecyclerView.Adapter<WidgetInstance>.ViewHolder {
        private final WidgetFaceRecyclerViewAdapter adapter;
        private final MaterialCardView background;
        private final float baseElevation;
        private final ColorStateList baseStrokeColor;
        private final int baseStrokeWidth;
        private final ConstraintLayout container;
        private final ColorStateList defaultStrokeColorTheme;
        private final ColorStateList defaultTextColor;
        private final TextView descriptionTextView;
        private final FragmentContainerView fragmentContainer;
        private final float highlightElevation;
        private final int highlightStrokeWidth;
        private final TextView nameTextView;
        private final ImageView placeholderImageView;
        private final ImageView selectedImageView;
        private final int strokeColorTheme;
        final /* synthetic */ WidgetFaceRecyclerViewAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WidgetViewHolder(WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter, WidgetFaceRecyclerViewAdapter adapter, View itemView) {
            super(widgetFaceRecyclerViewAdapter, itemView);
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = widgetFaceRecyclerViewAdapter;
            this.adapter = adapter;
            FragmentContainerView fragmentContainerViewFindViewById = itemView.findViewById(R.id.grid_item_widget_fragment_container);
            Intrinsics.checkNotNullExpressionValue(fragmentContainerViewFindViewById, "findViewById(...)");
            FragmentContainerView fragmentContainerView = fragmentContainerViewFindViewById;
            this.fragmentContainer = fragmentContainerView;
            ConstraintLayout constraintLayoutFindViewById = itemView.findViewById(R.id.grid_item_widget_container);
            Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
            this.container = constraintLayoutFindViewById;
            View viewFindViewById = itemView.findViewById(R.id.grid_item_widget_placeholder);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ImageView imageView = (ImageView) viewFindViewById;
            this.placeholderImageView = imageView;
            View viewFindViewById2 = itemView.findViewById(R.id.grid_item_widget_selected_image_view);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.selectedImageView = (ImageView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.grid_item_widget_name);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            TextView textView = (TextView) viewFindViewById3;
            this.nameTextView = textView;
            View viewFindViewById4 = itemView.findViewById(R.id.grid_item_widget_description);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.descriptionTextView = (TextView) viewFindViewById4;
            MaterialCardView materialCardViewFindViewById = itemView.findViewById(R.id.grid_item_widget_card);
            Intrinsics.checkNotNullExpressionValue(materialCardViewFindViewById, "findViewById(...)");
            MaterialCardView materialCardView = materialCardViewFindViewById;
            this.background = materialCardView;
            int strokeWidth = materialCardView.getStrokeWidth();
            this.baseStrokeWidth = strokeWidth;
            this.highlightStrokeWidth = (int) (strokeWidth * 2.0f);
            float elevation = materialCardView.getElevation();
            this.baseElevation = elevation;
            this.highlightElevation = elevation * 2.0f;
            this.baseStrokeColor = materialCardView.getStrokeColorStateList();
            ColorStateList imageTintList = imageView.getImageTintList();
            Intrinsics.checkNotNull(imageTintList);
            this.defaultStrokeColorTheme = imageTintList;
            ColorStateList textColors = textView.getTextColors();
            this.defaultTextColor = textColors;
            this.strokeColorTheme = ColorUtils.blendARGB(textColors.getDefaultColor(), imageTintList.getDefaultColor(), 1.0f);
            fragmentContainerView.setId(ViewCompat.generateViewId());
            fragmentContainerView.setSaveEnabled(false);
            showFragment();
        }

        public final WidgetFaceRecyclerViewAdapter getAdapter() {
            return this.adapter;
        }

        public final FragmentContainerView getFragmentContainer() {
            return this.fragmentContainer;
        }

        @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
        public void onFocus() {
            super.onFocus();
            if (!this.this$0._requestMovingViewHolderPositionMode) {
                Function3 function3 = this.this$0.onWidgetFocusChangeListener;
                if (function3 != null) {
                    function3.invoke(this, Integer.valueOf(getAbsoluteAdapterPosition()), true);
                }
                semiHighlight();
                Utils.scaleView$default(Utils.INSTANCE, this.container, 1.0f, 1.04f, 0L, false, 24, null);
                return;
            }
            semiHighlight();
        }

        @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
        public void onFocusClear(boolean z) {
            super.onFocus();
            if (!this.this$0._requestMovingViewHolderPositionMode) {
                Function3 function3 = this.this$0.onWidgetFocusChangeListener;
                if (function3 != null) {
                    function3.invoke(this, Integer.valueOf(getAbsoluteAdapterPosition()), false);
                }
                unHighlight();
                if (z) {
                    Utils.scaleView$default(Utils.INSTANCE, this.container, 1.04f, 1.0f, 0L, false, 24, null);
                    return;
                }
                return;
            }
            if (getAbsoluteAdapterPosition() == this.this$0.requestMovingViewHolderFromPosition) {
                highlight();
            } else {
                unHighlight();
            }
        }

        @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
        public boolean onLongClick() {
            if (!this.this$0._requestMovingViewHolderPositionMode) {
                Utils.scaleView$default(Utils.INSTANCE, this.container, 1.0f, 1.04f, 0L, false, 24, null);
                Function2 function2 = this.this$0.onWidgetLongClickListener;
                if (function2 != null) {
                    function2.invoke(this, Integer.valueOf(getAbsoluteAdapterPosition()));
                }
            }
            return super.onLongClick();
        }

        @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
        public boolean onClick() {
            View view;
            View view2;
            if (this.this$0._requestMovingViewHolderPositionMode) {
                this.this$0.setItemViewsFocusableInTouchMode(true);
                this.this$0._requestMovingViewHolderPositionMode = false;
                WidgetViewHolder widgetViewHolder = this.this$0.requestMovingViewHolderFromPositionViewHolder;
                if (widgetViewHolder != null) {
                    setDescriptionMode$default(widgetViewHolder, false, null, null, 6, null);
                }
                WidgetViewHolder widgetViewHolder2 = this.this$0.requestMovingViewHolderFromPositionViewHolder;
                if (widgetViewHolder2 != null && widgetViewHolder2.getAbsoluteAdapterPosition() == this.this$0.requestMovingViewHolderFromPosition) {
                    WidgetViewHolder widgetViewHolder3 = this.this$0.requestMovingViewHolderFromPositionViewHolder;
                    if (widgetViewHolder3 != null && (view2 = widgetViewHolder3.itemView) != null) {
                        view2.clearFocus();
                    }
                    WidgetViewHolder widgetViewHolder4 = this.this$0.requestMovingViewHolderFromPositionViewHolder;
                    if (widgetViewHolder4 != null && (view = widgetViewHolder4.itemView) != null) {
                        view.requestFocus();
                    }
                }
                Function2 function2 = this.this$0.requestMovingViewHolderPositionCallback;
                if (function2 != null) {
                    function2.invoke(Integer.valueOf(this.this$0.requestMovingViewHolderFromPosition), Integer.valueOf(getAbsoluteAdapterPosition()));
                }
                this.this$0.requestMovingViewHolderFromPositionViewHolder = null;
                this.this$0.requestMovingViewHolderFromPosition = -1;
            } else {
                Function2 function3 = this.this$0.onWidgetClickListener;
                if (function3 != null) {
                    function3.invoke(this, Integer.valueOf(getAbsoluteAdapterPosition()));
                }
            }
            return super.onClick();
        }

        private final void showFragment() {
            this.fragmentContainer.setVisibility(0);
            this.placeholderImageView.setVisibility(8);
            this.nameTextView.setVisibility(8);
            this.descriptionTextView.setVisibility(8);
        }

        private final void hideFragment() {
            this.fragmentContainer.setVisibility(4);
            this.placeholderImageView.setVisibility(0);
            this.nameTextView.setVisibility(0);
            this.descriptionTextView.setVisibility(0);
        }

        private final void highlight() {
            this.background.setStrokeColor(this.strokeColorTheme);
            this.background.setStrokeWidth(this.highlightStrokeWidth);
            this.background.setElevation(this.highlightElevation);
        }

        private final void semiHighlight() {
            this.background.setStrokeColor(this.strokeColorTheme);
            this.background.setStrokeWidth(this.highlightStrokeWidth);
            this.background.setElevation(this.highlightElevation);
        }

        private final void unHighlight() {
            this.background.setStrokeColor(this.baseStrokeColor);
            this.background.setStrokeWidth(this.baseStrokeWidth);
            this.background.setElevation(this.baseElevation);
        }

        public static /* synthetic */ void setDescriptionMode$default(WidgetViewHolder widgetViewHolder, boolean z, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            widgetViewHolder.setDescriptionMode(z, str, str2);
        }

        public final void setDescriptionMode(boolean z, String str, String str2) {
            if (z) {
                this.nameTextView.setText(str);
                this.descriptionTextView.setText(str2);
                highlight();
                hideFragment();
                return;
            }
            unHighlight();
            showFragment();
        }

        public final void requestMovingPosition(Function2<? super Integer, ? super Integer, Unit> requestMovingViewHolderPositionCallback) {
            Intrinsics.checkNotNullParameter(requestMovingViewHolderPositionCallback, "requestMovingViewHolderPositionCallback");
            this.this$0.requestMovingViewHolderPosition(this, requestMovingViewHolderPositionCallback);
        }

        @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
        public void onBind(int i, WidgetInstance item) {
            WidgetViewHolder widgetViewHolder;
            Intrinsics.checkNotNullParameter(item, "item");
            if (!this.this$0._requestMovingViewHolderPositionMode) {
                widgetViewHolder = this;
            } else if (this.this$0.requestMovingViewHolderFromPosition == getAbsoluteAdapterPosition()) {
                this.this$0.requestMovingViewHolderFromPositionViewHolder = this;
                setDescriptionMode(true, this.this$0.getFragment().getString(R.string.move_widget_title), this.this$0.getFragment().getString(R.string.move_widget_description));
                widgetViewHolder = this;
            } else {
                widgetViewHolder = this;
                setDescriptionMode$default(widgetViewHolder, false, null, null, 6, null);
            }
            int id2 = widgetViewHolder.fragmentContainer.getId();
            Long lItemForViewHolder = widgetViewHolder.this$0.itemForViewHolder(id2);
            if (lItemForViewHolder != null) {
                if (lItemForViewHolder.longValue() != getItemId()) {
                    widgetViewHolder.this$0.itemIdToViewHolder.remove(lItemForViewHolder.longValue());
                }
            }
            widgetViewHolder.this$0.itemIdToViewHolder.put(getItemId(), Integer.valueOf(id2));
            widgetViewHolder.this$0.ensureFragment(i);
            if (ViewCompat.isAttachedToWindow(widgetViewHolder.fragmentContainer)) {
                widgetViewHolder.this$0.placeFragmentInViewHolder(this);
            }
            widgetViewHolder.this$0.gcFragments();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gcFragments() {
        if (!this.hasStaleFragments || shouldDelayFragmentTransactions()) {
            return;
        }
        Set arraySet = new ArraySet(0, 1, (DefaultConstructorMarker) null);
        int size = this.fragments.size();
        for (int i = 0; i < size; i++) {
            long jKeyAt = this.fragments.keyAt(i);
            if (!containsItem(jKeyAt)) {
                arraySet.add(Long.valueOf(jKeyAt));
                this.itemIdToViewHolder.remove(jKeyAt);
            }
        }
        if (!this.isInGracePeriod) {
            this.hasStaleFragments = false;
            int size2 = this.fragments.size();
            for (int i2 = 0; i2 < size2; i2++) {
                long jKeyAt2 = this.fragments.keyAt(i2);
                if (!isFragmentViewBound(jKeyAt2)) {
                    arraySet.add(Long.valueOf(jKeyAt2));
                }
            }
        }
        Iterator it = arraySet.iterator();
        while (it.hasNext()) {
            removeFragment(((Number) it.next()).longValue());
        }
    }

    private final void removeFragment(long j) {
        ViewParent parent;
        WidgetFaceFragment widgetFaceFragment = (WidgetFaceFragment) this.fragments.get(j);
        if (widgetFaceFragment == null) {
            return;
        }
        if (widgetFaceFragment.getView() != null && (parent = widgetFaceFragment.requireView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!containsItem(j)) {
            this.savedStates.remove(j);
        }
        if (!widgetFaceFragment.isAdded()) {
            this.fragments.remove(j);
            return;
        }
        if (shouldDelayFragmentTransactions()) {
            this.hasStaleFragments = true;
            return;
        }
        if (widgetFaceFragment.isAdded() && containsItem(j)) {
            this.savedStates.put(j, this.fragmentManager.saveFragmentInstanceState(widgetFaceFragment));
        }
        this.fragmentManager.beginTransaction().remove(widgetFaceFragment).commitNow();
        this.fragments.remove(j);
    }

    private final boolean isFragmentViewBound(long j) {
        View view;
        if (this.itemIdToViewHolder.containsKey(j)) {
            return true;
        }
        WidgetFaceFragment widgetFaceFragment = (WidgetFaceFragment) this.fragments.get(j);
        return (widgetFaceFragment == null || (view = widgetFaceFragment.getView()) == null || view.getParent() == null) ? false : true;
    }

    public final boolean shouldDelayFragmentTransactions() {
        return this.fragmentManager.isStateSaved();
    }

    private final void scheduleGracePeriodEnd() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetFaceRecyclerViewAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WidgetFaceRecyclerViewAdapter.scheduleGracePeriodEnd$lambda$0(this.f$0);
            }
        };
        this.lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetFaceRecyclerViewAdapter.scheduleGracePeriodEnd.1
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(runnable);
                    source.getLifecycle().removeObserver((LifecycleObserver) this);
                }
            }
        });
        handler.postDelayed(runnable, GRACE_WINDOW_TIME_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleGracePeriodEnd$lambda$0(WidgetFaceRecyclerViewAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isInGracePeriod = false;
        this$0.gcFragments();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Long itemForViewHolder(int i) {
        int size = this.itemIdToViewHolder.size();
        Long lValueOf = null;
        for (int i2 = 0; i2 < size; i2++) {
            if (((Number) this.itemIdToViewHolder.valueAt(i2)).intValue() == i) {
                if (lValueOf != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.".toString());
                }
                lValueOf = Long.valueOf(this.itemIdToViewHolder.keyAt(i2));
            }
        }
        return lValueOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureFragment(int i) {
        long itemId = getItemId(i);
        if (this.fragments.containsKey(itemId)) {
            return;
        }
        WidgetFaceFragment fragmentAtPosition = getFragmentAtPosition(i);
        fragmentAtPosition.setInitialSavedState((Fragment.SavedState) this.savedStates.get(itemId));
        this.fragments.put(itemId, fragmentAtPosition);
    }

    private final void scheduleViewAttach(final WidgetViewHolder widgetViewHolder, final Fragment fragment, final FragmentContainerView fragmentContainerView) {
        this.fragmentManager.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() { // from class: com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetFaceRecyclerViewAdapter.scheduleViewAttach.1
            public void onFragmentViewCreated(FragmentManager fm, Fragment f, View v, Bundle bundle) {
                Intrinsics.checkNotNullParameter(fm, "fm");
                Intrinsics.checkNotNullParameter(f, "f");
                Intrinsics.checkNotNullParameter(v, "v");
                if (f == fragment) {
                    fm.unregisterFragmentLifecycleCallbacks(this);
                    this.addViewToContainer(widgetViewHolder, v, fragmentContainerView);
                }
            }
        }, false);
    }

    public final void addViewToContainer(WidgetViewHolder holder, View v, FragmentContainerView container) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(container, "container");
        if (container.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.".toString());
        }
        if (v.getParent() == container) {
            return;
        }
        if (container.getChildCount() > 0) {
            container.removeAllViews();
        }
        if (v.getParent() != null) {
            ViewParent parent = v.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(v);
        }
        container.addView(v);
    }

    /* JADX INFO: compiled from: WidgetFaceRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter$FragmentMaxLifecycleEnforcer;", "", "(Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter;)V", "dataObserver", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "gridLayoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "onScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "visibleItemIdList", "", "", "inferGridLayoutManager", "register", "", "unregister", "updateFragmentMaxLifecycle", "dataSetChanged", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class FragmentMaxLifecycleEnforcer {
        private RecyclerView.AdapterDataObserver dataObserver;
        private GridLayoutManager gridLayoutManager;
        private LifecycleEventObserver lifecycleObserver;
        private RecyclerView.OnScrollListener onScrollListener;
        private RecyclerView recyclerView;
        private List<Long> visibleItemIdList = CollectionsKt.emptyList();

        public FragmentMaxLifecycleEnforcer() {
        }

        public final void register(RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            this.recyclerView = recyclerView;
            this.gridLayoutManager = inferGridLayoutManager(recyclerView);
            RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetFaceRecyclerViewAdapter$FragmentMaxLifecycleEnforcer$register$1
                public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                    Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                    super.onScrollStateChanged(recyclerView2, i);
                    if (i == 0) {
                        this.this$0.updateFragmentMaxLifecycle(false);
                    }
                }
            };
            this.onScrollListener = onScrollListener;
            Intrinsics.checkNotNull(onScrollListener, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.OnScrollListener");
            recyclerView.addOnScrollListener(onScrollListener);
            DataSetChangeObserver dataSetChangeObserver = new DataSetChangeObserver() { // from class: com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetFaceRecyclerViewAdapter$FragmentMaxLifecycleEnforcer$register$2
                @Override // com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetFaceRecyclerViewAdapter.DataSetChangeObserver
                public void onChanged() {
                    this.this$0.updateFragmentMaxLifecycle(true);
                }
            };
            this.dataObserver = dataSetChangeObserver;
            WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter = WidgetFaceRecyclerViewAdapter.this;
            Intrinsics.checkNotNull(dataSetChangeObserver, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetFaceRecyclerViewAdapter.DataSetChangeObserver");
            widgetFaceRecyclerViewAdapter.registerAdapterDataObserver(dataSetChangeObserver);
            this.lifecycleObserver = new LifecycleEventObserver() { // from class: com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetFaceRecyclerViewAdapter$FragmentMaxLifecycleEnforcer$$ExternalSyntheticLambda0
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    WidgetFaceRecyclerViewAdapter.FragmentMaxLifecycleEnforcer.register$lambda$0(this.f$0, lifecycleOwner, event);
                }
            };
            Lifecycle lifecycle = WidgetFaceRecyclerViewAdapter.this.lifecycle;
            LifecycleObserver lifecycleObserver = this.lifecycleObserver;
            Intrinsics.checkNotNull(lifecycleObserver);
            lifecycle.addObserver(lifecycleObserver);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void register$lambda$0(FragmentMaxLifecycleEnforcer this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(event, "<anonymous parameter 1>");
            this$0.updateFragmentMaxLifecycle(false);
        }

        public final void unregister(RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            RecyclerView.OnScrollListener onScrollListener = this.onScrollListener;
            Intrinsics.checkNotNull(onScrollListener);
            recyclerView.removeOnScrollListener(onScrollListener);
            WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter = WidgetFaceRecyclerViewAdapter.this;
            RecyclerView.AdapterDataObserver adapterDataObserver = this.dataObserver;
            Intrinsics.checkNotNull(adapterDataObserver);
            widgetFaceRecyclerViewAdapter.unregisterAdapterDataObserver(adapterDataObserver);
            Lifecycle lifecycle = WidgetFaceRecyclerViewAdapter.this.lifecycle;
            LifecycleObserver lifecycleObserver = this.lifecycleObserver;
            Intrinsics.checkNotNull(lifecycleObserver);
            lifecycle.removeObserver(lifecycleObserver);
            this.recyclerView = null;
            this.gridLayoutManager = null;
        }

        public final void updateFragmentMaxLifecycle(boolean z) {
            if (WidgetFaceRecyclerViewAdapter.this.shouldDelayFragmentTransactions()) {
                return;
            }
            RecyclerView recyclerView = this.recyclerView;
            Intrinsics.checkNotNull(recyclerView);
            if (recyclerView.getScrollState() != 0 || WidgetFaceRecyclerViewAdapter.this.getFragments().isEmpty() || WidgetFaceRecyclerViewAdapter.this.getItemCount() == 0) {
                return;
            }
            GridLayoutManager gridLayoutManager = this.gridLayoutManager;
            Intrinsics.checkNotNull(gridLayoutManager);
            int iFindFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
            GridLayoutManager gridLayoutManager2 = this.gridLayoutManager;
            Intrinsics.checkNotNull(gridLayoutManager2);
            int iFindLastVisibleItemPosition = gridLayoutManager2.findLastVisibleItemPosition();
            if (iFindFirstVisibleItemPosition >= WidgetFaceRecyclerViewAdapter.this.getItemCount() || iFindLastVisibleItemPosition >= WidgetFaceRecyclerViewAdapter.this.getItemCount() || iFindFirstVisibleItemPosition == -1) {
                return;
            }
            int i = (iFindLastVisibleItemPosition - iFindFirstVisibleItemPosition) + 1;
            WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter = WidgetFaceRecyclerViewAdapter.this;
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(Long.valueOf(widgetFaceRecyclerViewAdapter.getItemId(iFindFirstVisibleItemPosition + i2)));
            }
            ArrayList arrayList2 = arrayList;
            if ((!Intrinsics.areEqual(arrayList2, this.visibleItemIdList) || z) && !arrayList2.isEmpty()) {
                this.visibleItemIdList = arrayList2;
                FragmentTransaction fragmentTransactionBeginTransaction = WidgetFaceRecyclerViewAdapter.this.fragmentManager.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
                ArrayList arrayList3 = new ArrayList();
                int size = WidgetFaceRecyclerViewAdapter.this.getFragments().size();
                for (int i3 = 0; i3 < size; i3++) {
                    long jKeyAt = WidgetFaceRecyclerViewAdapter.this.getFragments().keyAt(i3);
                    WidgetFaceFragment widgetFaceFragment = (WidgetFaceFragment) WidgetFaceRecyclerViewAdapter.this.getFragments().valueAt(i3);
                    Intrinsics.checkNotNull(widgetFaceFragment);
                    if (widgetFaceFragment.isAdded()) {
                        if (this.visibleItemIdList.contains(Long.valueOf(jKeyAt))) {
                            arrayList3.add(widgetFaceFragment);
                        } else {
                            fragmentTransactionBeginTransaction.setMaxLifecycle(widgetFaceFragment, Lifecycle.State.STARTED);
                        }
                        widgetFaceFragment.setMenuVisibility(this.visibleItemIdList.contains(Long.valueOf(jKeyAt)));
                    }
                }
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    fragmentTransactionBeginTransaction.setMaxLifecycle((Fragment) it.next(), Lifecycle.State.RESUMED);
                }
                if (fragmentTransactionBeginTransaction.isEmpty()) {
                    return;
                }
                fragmentTransactionBeginTransaction.commitNow();
            }
        }

        private final GridLayoutManager inferGridLayoutManager(RecyclerView recyclerView) {
            GridLayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                return layoutManager;
            }
            throw new IllegalStateException("Expected GridLayoutManager instance. Got: " + layoutManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: WidgetFaceRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\"\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter$DataSetChangeObserver;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "()V", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        public abstract void onChanged();

        public void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }

        public void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        public void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }
    }

    @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (this.fragmentMaxLifecycleEnforcer != null) {
            throw new IllegalStateException("Design assumption violated.".toString());
        }
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.fragmentMaxLifecycleEnforcer = fragmentMaxLifecycleEnforcer;
        Intrinsics.checkNotNull(fragmentMaxLifecycleEnforcer);
        fragmentMaxLifecycleEnforcer.register(recyclerView);
        this.recyclerView = recyclerView;
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.dpToPxConverter = new DpToPxConverter(context);
    }

    @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = this.fragmentMaxLifecycleEnforcer;
        Intrinsics.checkNotNull(fragmentMaxLifecycleEnforcer);
        fragmentMaxLifecycleEnforcer.unregister(recyclerView);
        this.fragmentMaxLifecycleEnforcer = null;
        this.recyclerView = null;
        this.dpToPxConverter = null;
    }

    public WidgetViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_widget, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new WidgetViewHolder(this, this, viewInflate);
    }

    public void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    @Override // com.magneticchen.daijishou.ui.widget.widget_recycler_view.StatefulAdapter
    public Parcelable saveState() {
        Bundle bundle = new Bundle(this.fragments.size() + this.savedStates.size());
        int size = this.fragments.size();
        for (int i = 0; i < size; i++) {
            long jKeyAt = this.fragments.keyAt(i);
            WidgetFaceFragment widgetFaceFragment = (WidgetFaceFragment) this.fragments.get(jKeyAt);
            if (widgetFaceFragment != null && widgetFaceFragment.isAdded()) {
                this.fragmentManager.putFragment(bundle, Companion.createKey(KEY_PREFIX_FRAGMENT, jKeyAt), widgetFaceFragment);
            }
        }
        int size2 = this.savedStates.size();
        for (int i2 = 0; i2 < size2; i2++) {
            long jKeyAt2 = this.savedStates.keyAt(i2);
            if (containsItem(jKeyAt2)) {
                bundle.putParcelable(Companion.createKey(KEY_PREFIX_STATE, jKeyAt2), (Parcelable) this.savedStates.get(jKeyAt2));
            }
        }
        return bundle;
    }

    @Override // com.magneticchen.daijishou.ui.widget.widget_recycler_view.StatefulAdapter
    public void restoreState(Parcelable savedState) {
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        if (!this.savedStates.isEmpty() || !this.fragments.isEmpty()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.".toString());
        }
        Bundle bundle = (Bundle) savedState;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            Companion companion = Companion;
            Intrinsics.checkNotNull(str);
            if (companion.isValidKey(str, KEY_PREFIX_FRAGMENT)) {
                long idFromKey = companion.parseIdFromKey(str, KEY_PREFIX_FRAGMENT);
                Fragment fragment = this.fragmentManager.getFragment(bundle, str);
                Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment");
                this.fragments.put(idFromKey, (WidgetFaceFragment) fragment);
            } else {
                if (!companion.isValidKey(str, KEY_PREFIX_STATE)) {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
                this.savedStates.put(companion.parseIdFromKey(str, KEY_PREFIX_STATE), bundle.getParcelable(str));
            }
        }
        if (this.fragments.isEmpty()) {
            return;
        }
        this.hasStaleFragments = true;
        this.isInGracePeriod = true;
        gcFragments();
        scheduleGracePeriodEnd();
    }

    public void onViewAttachedToWindow(DaijishouRecyclerView.Adapter<WidgetInstance>.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow((RecyclerView.ViewHolder) holder);
        placeFragmentInViewHolder((WidgetViewHolder) holder);
        gcFragments();
    }

    public void onViewRecycled(DaijishouRecyclerView.Adapter<WidgetInstance>.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Long lItemForViewHolder = itemForViewHolder(((WidgetViewHolder) holder).getFragmentContainer().getId());
        if (lItemForViewHolder != null) {
            this.itemIdToViewHolder.remove(lItemForViewHolder.longValue());
        }
    }

    public final void placeFragmentInViewHolder(final WidgetViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        WidgetFaceFragment widgetFaceFragment = (WidgetFaceFragment) this.fragments.get(holder.getItemId());
        if (widgetFaceFragment == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        ViewParent fragmentContainer = holder.getFragmentContainer();
        View view = widgetFaceFragment.getView();
        if (!widgetFaceFragment.isAdded() && view != null) {
            throw new IllegalStateException("Design assumption violated.".toString());
        }
        if (widgetFaceFragment.isAdded() && view == null) {
            scheduleViewAttach(holder, widgetFaceFragment, fragmentContainer);
            return;
        }
        if (widgetFaceFragment.isAdded()) {
            Intrinsics.checkNotNull(view);
            if (view.getParent() != null) {
                if (view.getParent() != fragmentContainer) {
                    addViewToContainer(holder, view, fragmentContainer);
                    return;
                }
                return;
            }
        }
        if (widgetFaceFragment.isAdded()) {
            Intrinsics.checkNotNull(view);
            addViewToContainer(holder, view, fragmentContainer);
            return;
        }
        if (!shouldDelayFragmentTransactions()) {
            WidgetFaceFragment widgetFaceFragment2 = widgetFaceFragment;
            scheduleViewAttach(holder, widgetFaceFragment2, fragmentContainer);
            this.fragmentManager.beginTransaction().add(widgetFaceFragment2, "f" + holder.getItemId()).setMaxLifecycle(widgetFaceFragment2, Lifecycle.State.RESUMED).commitNow();
            FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = this.fragmentMaxLifecycleEnforcer;
            Intrinsics.checkNotNull(fragmentMaxLifecycleEnforcer);
            fragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
            return;
        }
        if (this.fragmentManager.isDestroyed()) {
            return;
        }
        this.lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetFaceRecyclerViewAdapter.placeFragmentInViewHolder.2
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (WidgetFaceRecyclerViewAdapter.this.shouldDelayFragmentTransactions()) {
                    return;
                }
                source.getLifecycle().removeObserver((LifecycleObserver) this);
                if (ViewCompat.isAttachedToWindow(holder.getFragmentContainer())) {
                    WidgetFaceRecyclerViewAdapter.this.placeFragmentInViewHolder(holder);
                }
            }
        });
    }

    private final WidgetFaceFragment getFragmentAtPosition(int i) {
        return this.widgetInstances.get(i).getWidgetFaceFragment();
    }

    public long getItemId(int i) {
        return this.widgetInstances.get(i).getWidgetInstanceDatabaseId();
    }

    private final boolean containsItem(long j) {
        Iterator<T> it = this.widgetInstances.iterator();
        while (it.hasNext()) {
            if (((WidgetInstance) it.next()).getWidgetInstanceDatabaseId() == j) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setItemViewsFocusableInTouchMode(boolean z) {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            if (z) {
                int childCount = recyclerView.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    recyclerView.getChildViewHolder(recyclerView.getChildAt(i)).itemView.setFocusableInTouchMode(true);
                }
                return;
            }
            recyclerView.clearFocus();
            int childCount2 = recyclerView.getChildCount();
            for (int i2 = 0; i2 < childCount2; i2++) {
                recyclerView.getChildViewHolder(recyclerView.getChildAt(i2)).itemView.setFocusableInTouchMode(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestMovingViewHolderPosition(WidgetViewHolder widgetViewHolder, Function2<? super Integer, ? super Integer, Unit> function2) {
        if (this._requestMovingViewHolderPositionMode) {
            throw new IllegalStateException("Moving view holder position has already requested.".toString());
        }
        setItemViewsFocusableInTouchMode(false);
        this._requestMovingViewHolderPositionMode = true;
        widgetViewHolder.setDescriptionMode(true, this.fragment.getString(R.string.move_widget_title), this.fragment.getString(R.string.move_widget_description));
        widgetViewHolder.itemView.requestFocus();
        this.requestMovingViewHolderFromPosition = widgetViewHolder.getAbsoluteAdapterPosition();
        this.requestMovingViewHolderFromPositionViewHolder = widgetViewHolder;
        this.requestMovingViewHolderPositionCallback = function2;
    }

    public final void cancelMovingPosition() {
        View view;
        if (this._requestMovingViewHolderPositionMode) {
            setItemViewsFocusableInTouchMode(true);
            this._requestMovingViewHolderPositionMode = false;
            WidgetViewHolder widgetViewHolder = this.requestMovingViewHolderFromPositionViewHolder;
            if (widgetViewHolder != null) {
                WidgetViewHolder.setDescriptionMode$default(widgetViewHolder, false, null, null, 6, null);
            }
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.smoothScrollToPosition(this.requestMovingViewHolderFromPosition);
            }
            WidgetViewHolder widgetViewHolder2 = this.requestMovingViewHolderFromPositionViewHolder;
            if (widgetViewHolder2 != null && (view = widgetViewHolder2.itemView) != null) {
                view.requestFocus();
            }
            Function2<? super Integer, ? super Integer, Unit> function2 = this.requestMovingViewHolderPositionCallback;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(this.requestMovingViewHolderFromPosition), Integer.valueOf(this.requestMovingViewHolderFromPosition));
            }
            this.requestMovingViewHolderFromPositionViewHolder = null;
            this.requestMovingViewHolderFromPosition = -1;
        }
    }

    /* JADX INFO: compiled from: WidgetFaceRecyclerViewAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetFaceRecyclerViewAdapter$Companion;", "", "()V", "GRACE_WINDOW_TIME_MS", "", "KEY_PREFIX_FRAGMENT", "", "KEY_PREFIX_STATE", "createKey", "prefix", "id", "isValidKey", "", "key", "parseIdFromKey", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String createKey(String str, long j) {
            return str + j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isValidKey(String str, String str2) {
            return StringsKt.startsWith$default(str, str2, false, 2, (Object) null) && str.length() > str2.length();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long parseIdFromKey(String str, String str2) {
            String strSubstring = str.substring(str2.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return Long.parseLong(strSubstring);
        }
    }
}
