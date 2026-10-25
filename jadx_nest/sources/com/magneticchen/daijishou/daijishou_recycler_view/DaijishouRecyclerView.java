package com.magneticchen.daijishou.daijishou_recycler_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader;
import com.bumptech.glide.util.ViewPreloadSizeProvider;
import com.magneticchen.daijishou.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DaijishouRecyclerView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ0\u0010\u0010\u001a\u00020\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u0014\u0010\u0018\u001a\u00020\u00112\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0002J\u0006\u0010\u001a\u001a\u00020\fJ\u001a\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001c\u0010\u001e\u001a\u00020\u00112\u0012\u0010\r\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0018\u00010\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "forceFocusFirstCompletelyVisibleItem", "", "preloaderList", "", "Lcom/bumptech/glide/integration/recyclerview/RecyclerViewPreloader;", "addFocusables", "", "views", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "direction", "focusableMode", "addPreloader", "preloader", "focusFirstCompletelyVisibleView", "requestFocus", "previouslyFocusedRect", "Landroid/graphics/Rect;", "setPreloaderList", "Adapter", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class DaijishouRecyclerView extends RecyclerView {
    private final Context context;
    private boolean forceFocusFirstCompletelyVisibleItem;
    private List<? extends RecyclerViewPreloader<?>> preloaderList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DaijishouRecyclerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DaijishouRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DaijishouRecyclerView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.forceFocusFirstCompletelyVisibleItem = typedArrayObtainStyledAttributes.getBoolean(0, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DaijishouRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DaijishouRecyclerView, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.forceFocusFirstCompletelyVisibleItem = typedArrayObtainStyledAttributes.getBoolean(0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPreloaderList(List<? extends RecyclerViewPreloader<?>> preloaderList) {
        List<? extends RecyclerViewPreloader<?>> list = this.preloaderList;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                removeOnScrollListener((RecyclerViewPreloader) it.next());
            }
        }
        this.preloaderList = preloaderList;
        if (preloaderList != null) {
            Iterator it2 = preloaderList.iterator();
            while (it2.hasNext()) {
                addOnScrollListener((RecyclerViewPreloader) it2.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addPreloader(RecyclerViewPreloader<?> preloader) {
        addOnScrollListener(preloader);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        Intrinsics.checkNotNullParameter(views, "views");
        if (getAdapter() instanceof Adapter) {
            RecyclerView.Adapter adapter = getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter<*>");
            Adapter adapter2 = (Adapter) adapter;
            if (getFocusedChild() == null && this.forceFocusFirstCompletelyVisibleItem) {
                views.add(this);
                return;
            } else if (getFocusedChild() == null && adapter2.getEnforceSelectionInSelectableMode() && adapter2.getSelectableMode()) {
                views.add(this);
                return;
            } else {
                super.addFocusables(views, direction, focusableMode);
                return;
            }
        }
        super.addFocusables(views, direction, focusableMode);
    }

    public final boolean focusFirstCompletelyVisibleView() {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof DaijishouLinearLayoutManager) {
            DaijishouLinearLayoutManager daijishouLinearLayoutManager = (DaijishouLinearLayoutManager) layoutManager;
            View viewFindViewByPosition = daijishouLinearLayoutManager.findViewByPosition(daijishouLinearLayoutManager.findFirstCompletelyVisibleItemPosition());
            if (viewFindViewByPosition != null) {
                return viewFindViewByPosition.requestFocus();
            }
            return false;
        }
        if (layoutManager instanceof DaijishouCycleLinearLayoutManager) {
            DaijishouCycleLinearLayoutManager daijishouCycleLinearLayoutManager = (DaijishouCycleLinearLayoutManager) layoutManager;
            View viewFindViewByPosition2 = daijishouCycleLinearLayoutManager.findViewByPosition(daijishouCycleLinearLayoutManager.findFirstCompletelyVisibleItemPosition());
            if (viewFindViewByPosition2 != null) {
                return viewFindViewByPosition2.requestFocus();
            }
            return false;
        }
        if (layoutManager instanceof DaijishouGridLayoutManager) {
            DaijishouGridLayoutManager daijishouGridLayoutManager = (DaijishouGridLayoutManager) layoutManager;
            View viewFindViewByPosition3 = daijishouGridLayoutManager.findViewByPosition(daijishouGridLayoutManager.findFirstCompletelyVisibleItemPosition());
            if (viewFindViewByPosition3 != null) {
                return viewFindViewByPosition3.requestFocus();
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        if (getAdapter() instanceof Adapter) {
            RecyclerView.Adapter adapter = getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter<*>");
            Adapter adapter2 = (Adapter) adapter;
            if (adapter2.getSelectableMode()) {
                if (isComputingLayout()) {
                    adapter2.selectPosition(adapter2.get_selectedPosition());
                    return true;
                }
                Adapter.ViewHolder selectedViewHolder = adapter2.getSelectedViewHolder();
                if (selectedViewHolder != null && selectedViewHolder.getAbsoluteAdapterPosition() == adapter2.get_selectedPosition()) {
                    View itemView = selectedViewHolder.itemView;
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    return itemView.requestFocus();
                }
                if (getChildCount() != 0) {
                    return super.requestFocus(direction, previouslyFocusedRect);
                }
                if (focusFirstCompletelyVisibleView()) {
                    return true;
                }
                return super.requestFocus(direction, previouslyFocusedRect);
            }
            if (focusFirstCompletelyVisibleView()) {
                return true;
            }
            return super.requestFocus(direction, previouslyFocusedRect);
        }
        return super.requestFocus(direction, previouslyFocusedRect);
    }

    /* JADX INFO: compiled from: DaijishouRecyclerView.kt */
    @Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u000e\u0012\f0\u0003R\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0002:\u0001QB'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJF\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192)\u0010;\u001a%\u0012\u0015\u0012\u0013\b\u00028\u0000¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010@0<2\b\b\u0002\u0010A\u001a\u00020\u000bH\u0004ø\u0001\u0000J&\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000C0\u00052\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010A\u001a\u00020\u000bH\u0016J\u0006\u0010F\u001a\u00020\u000bJ\b\u0010G\u001a\u00020\u0007H\u0002J\u0010\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020JH\u0016J\"\u0010K\u001a\u00020%2\u0010\u0010L\u001a\f0\u0003R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010M\u001a\u00020\u000bH\u0016J\u0010\u0010N\u001a\u00020%2\u0006\u0010I\u001a\u00020JH\u0016J\u000e\u0010O\u001a\u00020%2\u0006\u0010M\u001a\u00020\u000bJ\u001c\u0010P\u001a\u00020%2\u0012\u0010L\u001a\u000e\u0018\u00010\u0003R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0018\u00010\u0003R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R2\u0010\u0016\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a0\u00180\u0017X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R:\u0010!\u001a\"\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020%\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R:\u0010*\u001a\"\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R<\u0010-\u001a$\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020%\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u001a\u00100\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0013\"\u0004\b2\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0013R\u0011\u00104\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b5\u00106R\u001d\u00107\u001a\u000e\u0018\u00010\u0003R\b\u0012\u0004\u0012\u00028\u00000\u00008F¢\u0006\u0006\u001a\u0004\b8\u00109\u0082\u0002\u0004\n\u0002\b9¨\u0006R"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "itemList", "", "selectableMode", "", "notifyItemChange", "(Ljava/util/List;ZZ)V", "_selectedPosition", "", "_selectedViewHolder", "daijishouLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "daijishouRecyclerView", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView;", "enforceSelectionInSelectableMode", "getEnforceSelectionInSelectableMode", "()Z", "setEnforceSelectionInSelectableMode", "(Z)V", "glideViewPreloadSizeAndModelProviders", "", "Lkotlin/Pair;", "Lcom/bumptech/glide/util/ViewPreloadSizeProvider;", "Lcom/bumptech/glide/ListPreloader$PreloadModelProvider;", "getGlideViewPreloadSizeAndModelProviders", "()Ljava/util/List;", "getItemList", "keepSelectedItemFocusedInSelectableMode", "getKeepSelectedItemFocusedInSelectableMode", "setKeepSelectedItemFocusedInSelectableMode", "onItemClickListener", "Lkotlin/Function4;", "Landroid/view/View;", "", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function4;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function4;)V", "onItemLongClickListener", "getOnItemLongClickListener", "setOnItemLongClickListener", "onItemSelectListener", "getOnItemSelectListener", "setOnItemSelectListener", "selectNoneAfterLosingFocus", "getSelectNoneAfterLosingFocus", "setSelectNoneAfterLosingFocus", "getSelectableMode", "selectedPosition", "getSelectedPosition", "()I", "selectedViewHolder", "getSelectedViewHolder", "()Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "addGlidePreloaderBuilderCreator", "builderCreator", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "item", "Lcom/bumptech/glide/RequestBuilder;", "maxPreload", "createGlideRecyclerViewPreloaderList", "Lcom/bumptech/glide/integration/recyclerview/RecyclerViewPreloader;", "context", "Landroid/content/Context;", "getItemCount", "isRecyclerViewVisibleOnScreen", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "viewHolder", "position", "onDetachedFromRecyclerView", "selectPosition", "selectViewHolder", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Adapter<T> extends RecyclerView.Adapter<Adapter<T>.ViewHolder> {
        private int _selectedPosition;
        private Adapter<T>.ViewHolder _selectedViewHolder;
        private RecyclerView.LayoutManager daijishouLayoutManager;
        private DaijishouRecyclerView daijishouRecyclerView;
        private boolean enforceSelectionInSelectableMode;
        private final List<Pair<ViewPreloadSizeProvider<T>, ListPreloader.PreloadModelProvider<T>>> glideViewPreloadSizeAndModelProviders;
        private final List<T> itemList;
        private boolean keepSelectedItemFocusedInSelectableMode;
        private final boolean notifyItemChange;
        private Function4<? super View, ? super Integer, ? super Long, ? super T, Unit> onItemClickListener;
        private Function4<? super View, ? super Integer, ? super Long, ? super T, Boolean> onItemLongClickListener;
        private Function4<? super View, ? super Integer, ? super Long, ? super T, Unit> onItemSelectListener;
        private boolean selectNoneAfterLosingFocus;
        private final boolean selectableMode;

        /* JADX WARN: Multi-variable type inference failed */
        public Adapter(List<? extends T> itemList, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(itemList, "itemList");
            this.itemList = (List<T>) (List) itemList;
            this.selectableMode = z;
            this.notifyItemChange = z2;
            this.glideViewPreloadSizeAndModelProviders = new ArrayList();
            this.enforceSelectionInSelectableMode = true;
            this.keepSelectedItemFocusedInSelectableMode = true;
            this._selectedPosition = -1;
        }

        public /* synthetic */ Adapter(List list, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? false : z, (i & 4) != 0 ? true : z2);
        }

        protected final List<T> getItemList() {
            return this.itemList;
        }

        public final boolean getSelectableMode() {
            return this.selectableMode;
        }

        protected List<Pair<ViewPreloadSizeProvider<T>, ListPreloader.PreloadModelProvider<T>>> getGlideViewPreloadSizeAndModelProviders() {
            return this.glideViewPreloadSizeAndModelProviders;
        }

        public static /* synthetic */ List createGlideRecyclerViewPreloaderList$default(Adapter adapter, Context context, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createGlideRecyclerViewPreloaderList");
            }
            if ((i2 & 2) != 0) {
                i = 10;
            }
            return adapter.createGlideRecyclerViewPreloaderList(context, i);
        }

        public List<RecyclerViewPreloader<T>> createGlideRecyclerViewPreloaderList(Context context, int maxPreload) {
            Intrinsics.checkNotNullParameter(context, "context");
            List<Pair<ViewPreloadSizeProvider<T>, ListPreloader.PreloadModelProvider<T>>> glideViewPreloadSizeAndModelProviders = getGlideViewPreloadSizeAndModelProviders();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(glideViewPreloadSizeAndModelProviders, 10));
            Iterator it = glideViewPreloadSizeAndModelProviders.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                arrayList.add(new RecyclerViewPreloader(Glide.with(context), (ListPreloader.PreloadModelProvider) pair.getSecond(), (ListPreloader.PreloadSizeProvider) pair.getFirst(), maxPreload));
            }
            return arrayList;
        }

        public static /* synthetic */ ViewPreloadSizeProvider addGlidePreloaderBuilderCreator$default(Adapter adapter, Function1 function1, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addGlidePreloaderBuilderCreator");
            }
            if ((i2 & 2) != 0) {
                i = 10;
            }
            return adapter.addGlidePreloaderBuilderCreator(function1, i);
        }

        protected final ViewPreloadSizeProvider<T> addGlidePreloaderBuilderCreator(Function1<? super T, ? extends RequestBuilder<?>> builderCreator, int maxPreload) {
            Intrinsics.checkNotNullParameter(builderCreator, "builderCreator");
            ViewPreloadSizeProvider<T> viewPreloadSizeProvider = new ViewPreloadSizeProvider<>();
            DaijishouRecyclerView$Adapter$addGlidePreloaderBuilderCreator$preloadModelProvider$1 daijishouRecyclerView$Adapter$addGlidePreloaderBuilderCreator$preloadModelProvider$1 = new DaijishouRecyclerView$Adapter$addGlidePreloaderBuilderCreator$preloadModelProvider$1(this, builderCreator);
            DaijishouRecyclerView daijishouRecyclerView = this.daijishouRecyclerView;
            if (daijishouRecyclerView != null) {
                Intrinsics.checkNotNull(daijishouRecyclerView);
                DaijishouRecyclerView daijishouRecyclerView2 = this.daijishouRecyclerView;
                Intrinsics.checkNotNull(daijishouRecyclerView2);
                daijishouRecyclerView.addPreloader(new RecyclerViewPreloader(Glide.with(daijishouRecyclerView2.context), daijishouRecyclerView$Adapter$addGlidePreloaderBuilderCreator$preloadModelProvider$1, viewPreloadSizeProvider, maxPreload));
            }
            getGlideViewPreloadSizeAndModelProviders().add(new Pair<>(viewPreloadSizeProvider, daijishouRecyclerView$Adapter$addGlidePreloaderBuilderCreator$preloadModelProvider$1));
            return viewPreloadSizeProvider;
        }

        public boolean getEnforceSelectionInSelectableMode() {
            return this.enforceSelectionInSelectableMode;
        }

        public void setEnforceSelectionInSelectableMode(boolean z) {
            this.enforceSelectionInSelectableMode = z;
        }

        public boolean getKeepSelectedItemFocusedInSelectableMode() {
            return this.keepSelectedItemFocusedInSelectableMode;
        }

        public void setKeepSelectedItemFocusedInSelectableMode(boolean z) {
            this.keepSelectedItemFocusedInSelectableMode = z;
        }

        public boolean getSelectNoneAfterLosingFocus() {
            return this.selectNoneAfterLosingFocus;
        }

        public void setSelectNoneAfterLosingFocus(boolean z) {
            this.selectNoneAfterLosingFocus = z;
        }

        public final Function4<View, Integer, Long, T, Unit> getOnItemClickListener() {
            return (Function4<View, Integer, Long, T, Unit>) (Function4) this.onItemClickListener;
        }

        public final void setOnItemClickListener(Function4<? super View, ? super Integer, ? super Long, ? super T, Unit> function4) {
            this.onItemClickListener = function4;
        }

        public final Function4<View, Integer, Long, T, Boolean> getOnItemLongClickListener() {
            return (Function4<View, Integer, Long, T, Boolean>) (Function4) this.onItemLongClickListener;
        }

        public final void setOnItemLongClickListener(Function4<? super View, ? super Integer, ? super Long, ? super T, Boolean> function4) {
            this.onItemLongClickListener = function4;
        }

        public final Function4<View, Integer, Long, T, Unit> getOnItemSelectListener() {
            return (Function4<View, Integer, Long, T, Unit>) (Function4) this.onItemSelectListener;
        }

        public final void setOnItemSelectListener(Function4<? super View, ? super Integer, ? super Long, ? super T, Unit> function4) {
            this.onItemSelectListener = function4;
        }

        public final Adapter<T>.ViewHolder getSelectedViewHolder() {
            return this._selectedViewHolder;
        }

        /* JADX INFO: renamed from: getSelectedPosition, reason: from getter */
        public final int get_selectedPosition() {
            return this._selectedPosition;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.itemList.size();
        }

        private final boolean isRecyclerViewVisibleOnScreen() {
            DaijishouRecyclerView daijishouRecyclerView = this.daijishouRecyclerView;
            if (daijishouRecyclerView == null) {
                return false;
            }
            Intrinsics.checkNotNull(daijishouRecyclerView);
            return daijishouRecyclerView.getGlobalVisibleRect(new Rect());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onAttachedToRecyclerView(recyclerView);
            DaijishouRecyclerView daijishouRecyclerView = (DaijishouRecyclerView) recyclerView;
            this.daijishouRecyclerView = daijishouRecyclerView;
            Intrinsics.checkNotNull(daijishouRecyclerView);
            List listCreateGlideRecyclerViewPreloaderList$default = createGlideRecyclerViewPreloaderList$default(this, daijishouRecyclerView.context, 0, 2, null);
            DaijishouRecyclerView daijishouRecyclerView2 = this.daijishouRecyclerView;
            Intrinsics.checkNotNull(daijishouRecyclerView2);
            daijishouRecyclerView2.setPreloaderList(listCreateGlideRecyclerViewPreloaderList$default);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onDetachedFromRecyclerView(recyclerView);
            this.daijishouRecyclerView = null;
            this._selectedViewHolder = null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(Adapter<T>.ViewHolder viewHolder, int position) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            if (this.selectableMode) {
                if (position == this._selectedPosition && !viewHolder.getSelected()) {
                    selectViewHolder(viewHolder);
                    if (getKeepSelectedItemFocusedInSelectableMode()) {
                        viewHolder.itemView.setFocusableInTouchMode(true);
                        viewHolder.itemView.requestFocus();
                    }
                } else if (position == this._selectedPosition && viewHolder.getSelected()) {
                    if (getKeepSelectedItemFocusedInSelectableMode()) {
                        viewHolder.itemView.setFocusableInTouchMode(true);
                        viewHolder.itemView.requestFocus();
                    }
                    Function4<? super View, ? super Integer, ? super Long, ? super T, Unit> function4 = this.onItemSelectListener;
                    if (function4 != null) {
                        function4.invoke(viewHolder.itemView, Integer.valueOf(viewHolder.getAbsoluteAdapterPosition()), Long.valueOf(getItemId(viewHolder.getAbsoluteAdapterPosition())), this.itemList.get(viewHolder.getAbsoluteAdapterPosition()));
                    }
                } else if (position == this._selectedPosition && getKeepSelectedItemFocusedInSelectableMode()) {
                    viewHolder.itemView.setFocusableInTouchMode(true);
                    viewHolder.itemView.requestFocus();
                } else if (Intrinsics.areEqual(viewHolder, this._selectedViewHolder) && position != this._selectedPosition) {
                    selectViewHolder(null);
                }
            }
            viewHolder.onBind(position, this.itemList.get(position));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void selectViewHolder(Adapter<T>.ViewHolder viewHolder) {
            Function4<? super View, ? super Integer, ? super Long, ? super T, Unit> function4;
            View view;
            if (Intrinsics.areEqual(this._selectedViewHolder, viewHolder)) {
                return;
            }
            Adapter<T>.ViewHolder viewHolder2 = this._selectedViewHolder;
            if (viewHolder2 != null && (view = viewHolder2.itemView) != null && view.isFocused()) {
                view.clearFocus();
            }
            Adapter<T>.ViewHolder viewHolder3 = this._selectedViewHolder;
            if (viewHolder3 != null && viewHolder3.getSelected()) {
                Adapter<T>.ViewHolder viewHolder4 = this._selectedViewHolder;
                if (viewHolder4 != null) {
                    viewHolder4.setSelected(false);
                }
                Adapter<T>.ViewHolder viewHolder5 = this._selectedViewHolder;
                if (viewHolder5 != null) {
                    viewHolder5.onUnselect();
                }
            }
            this._selectedViewHolder = viewHolder;
            if (viewHolder == null || viewHolder.getSelected()) {
                return;
            }
            viewHolder.setSelected(true);
            viewHolder.onSelect();
            if (viewHolder.getAbsoluteAdapterPosition() < 0 || (function4 = this.onItemSelectListener) == null) {
                return;
            }
            function4.invoke(viewHolder.itemView, Integer.valueOf(viewHolder.getAbsoluteAdapterPosition()), Long.valueOf(getItemId(viewHolder.getAbsoluteAdapterPosition())), this.itemList.get(viewHolder.getAbsoluteAdapterPosition()));
        }

        public final void selectPosition(int position) {
            Adapter<T>.ViewHolder viewHolder;
            if (this._selectedPosition == position && (viewHolder = this._selectedViewHolder) != null && viewHolder.getAbsoluteAdapterPosition() == position) {
                return;
            }
            this._selectedPosition = position;
            if (this.selectableMode) {
                DaijishouRecyclerView daijishouRecyclerView = this.daijishouRecyclerView;
                Adapter<T>.ViewHolder viewHolder2 = (ViewHolder) (daijishouRecyclerView != null ? daijishouRecyclerView.findViewHolderForAdapterPosition(position) : null);
                if (viewHolder2 != null) {
                    selectViewHolder(viewHolder2);
                    if (getKeepSelectedItemFocusedInSelectableMode() && isRecyclerViewVisibleOnScreen()) {
                        viewHolder2.itemView.requestFocus();
                        return;
                    }
                    return;
                }
                if (this.notifyItemChange) {
                    DaijishouRecyclerView daijishouRecyclerView2 = this.daijishouRecyclerView;
                    if (daijishouRecyclerView2 != null) {
                        if (daijishouRecyclerView2 == null) {
                            return;
                        }
                        Intrinsics.checkNotNull(daijishouRecyclerView2);
                        if (daijishouRecyclerView2.isComputingLayout()) {
                            return;
                        }
                        DaijishouRecyclerView daijishouRecyclerView3 = this.daijishouRecyclerView;
                        Intrinsics.checkNotNull(daijishouRecyclerView3);
                        if (daijishouRecyclerView3.getScrollState() != 0) {
                            return;
                        }
                    }
                    notifyItemChanged(position);
                }
            }
        }

        /* JADX INFO: compiled from: DaijishouRecyclerView.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;Landroid/view/View;)V", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "onBind", "", "position", "", "item", "(ILjava/lang/Object;)V", "onClick", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "onLongClick", "onSelect", "onUnselect", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public abstract class ViewHolder extends RecyclerView.ViewHolder {
            private boolean selected;
            final /* synthetic */ Adapter<T> this$0;

            public abstract void onBind(int position, T item);

            public boolean onClick() {
                return true;
            }

            public void onFocus() {
            }

            public void onFocusClear(boolean isAbsoluteAdapterPositionValid) {
            }

            public boolean onLongClick() {
                return true;
            }

            public void onSelect() {
            }

            public void onUnselect() {
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(Adapter adapter, View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = adapter;
                itemView.setOnClickListener(new DaijishouRecyclerView$Adapter$ViewHolder$$ExternalSyntheticLambda0(adapter, itemView, this));
                itemView.setOnLongClickListener(new DaijishouRecyclerView$Adapter$ViewHolder$$ExternalSyntheticLambda1(this, adapter, itemView));
                itemView.setOnFocusChangeListener(new DaijishouRecyclerView$Adapter$ViewHolder$$ExternalSyntheticLambda2(this, adapter, itemView));
            }

            public final boolean getSelected() {
                return this.selected;
            }

            public final void setSelected(boolean z) {
                this.selected = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void _init_$lambda$0(Adapter adapter, View itemView, View view) {
                Function4 onItemClickListener;
                Function4 onItemClickListener2;
                Intrinsics.checkNotNullParameter(adapter, "this$0");
                Intrinsics.checkNotNullParameter(itemView, "$itemView");
                if (adapter.getSelectableMode()) {
                    if (adapter.getKeepSelectedItemFocusedInSelectableMode()) {
                        itemView.setFocusableInTouchMode(true);
                    }
                    if (this.getAbsoluteAdapterPosition() != adapter._selectedPosition) {
                        adapter._selectedPosition = this.getAbsoluteAdapterPosition();
                        adapter.selectViewHolder(this);
                        itemView.requestFocus();
                    } else if (this.onClick() && (onItemClickListener2 = adapter.getOnItemClickListener()) != null) {
                        onItemClickListener2.invoke(itemView, Integer.valueOf(this.getAbsoluteAdapterPosition()), Long.valueOf(this.getItemId()), adapter.getItemList().get(this.getAbsoluteAdapterPosition()));
                    }
                    if (adapter.getKeepSelectedItemFocusedInSelectableMode()) {
                        itemView.requestFocus();
                        return;
                    }
                    return;
                }
                if (!this.onClick() || this.getAbsoluteAdapterPosition() < 0 || (onItemClickListener = adapter.getOnItemClickListener()) == null) {
                    return;
                }
                onItemClickListener.invoke(itemView, Integer.valueOf(this.getAbsoluteAdapterPosition()), Long.valueOf(this.getItemId()), adapter.getItemList().get(this.getAbsoluteAdapterPosition()));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final boolean _init_$lambda$1(Adapter adapter, View itemView, View view) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(adapter, "this$1");
                Intrinsics.checkNotNullParameter(itemView, "$itemView");
                if (!this.onLongClick()) {
                    return false;
                }
                if (adapter.getSelectableMode() && this.getAbsoluteAdapterPosition() != adapter._selectedPosition) {
                    if (adapter.getKeepSelectedItemFocusedInSelectableMode()) {
                        itemView.setFocusableInTouchMode(true);
                    }
                    adapter._selectedPosition = this.getAbsoluteAdapterPosition();
                    adapter.selectViewHolder(this);
                    itemView.requestFocus();
                }
                if (this.getAbsoluteAdapterPosition() >= 0) {
                    Function4 onItemLongClickListener = adapter.getOnItemLongClickListener();
                    bool = onItemLongClickListener != null ? (Boolean) onItemLongClickListener.invoke(itemView, Integer.valueOf(this.getAbsoluteAdapterPosition()), Long.valueOf(this.getItemId()), adapter.getItemList().get(this.getAbsoluteAdapterPosition())) : null;
                } else {
                    bool = true;
                }
                if (bool != null) {
                    return bool.booleanValue();
                }
                return true;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void _init_$lambda$2(Adapter adapter, View itemView, View view, boolean z) {
                Intrinsics.checkNotNullParameter(adapter, "this$1");
                Intrinsics.checkNotNullParameter(itemView, "$itemView");
                if (z) {
                    this.onFocus();
                    if (adapter.getSelectableMode() && this.getAbsoluteAdapterPosition() >= 0) {
                        adapter.selectViewHolder(this);
                        adapter._selectedPosition = this.getAbsoluteAdapterPosition();
                        return;
                    } else {
                        if (this.getAbsoluteAdapterPosition() >= 0) {
                            adapter._selectedPosition = this.getAbsoluteAdapterPosition();
                            return;
                        }
                        return;
                    }
                }
                if (itemView.isFocusableInTouchMode()) {
                    itemView.setFocusableInTouchMode(false);
                }
                this.onFocusClear(this.getAbsoluteAdapterPosition() >= 0);
                if (!adapter.getEnforceSelectionInSelectableMode() && adapter.getSelectableMode()) {
                    if (adapter._selectedPosition == this.getAbsoluteAdapterPosition()) {
                        this.selected = false;
                        this.onUnselect();
                    }
                    if (adapter.getSelectNoneAfterLosingFocus()) {
                        adapter._selectedPosition = -1;
                        return;
                    }
                    return;
                }
                if (adapter.getSelectableMode()) {
                    return;
                }
                adapter._selectedPosition = -1;
            }
        }
    }
}
