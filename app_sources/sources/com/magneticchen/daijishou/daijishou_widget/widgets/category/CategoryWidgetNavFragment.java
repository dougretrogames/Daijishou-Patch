package com.magneticchen.daijishou.daijishou_widget.widgets.category;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewGroupKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.activities.MainActivity;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.application_data.StringPreference;
import com.magneticchen.daijishou.cache.CachedBitmapLoader;
import com.magneticchen.daijishou.daijishou_library_db.Genre;
import com.magneticchen.daijishou.daijishou_library_db.Genres;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouGridLayoutManager;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetNavFragment;
import com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment;
import com.magneticchen.daijishou.live_data.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.live_data.SharedPreferenceStringLiveData;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* INFO: compiled from: CategoryWidgetNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 k2\u00020\u0001:\u0002jkB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010N\u001a\u00020AH\u0016J\u0012\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J&\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010X2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0017J \u0010Y\u001a\u00020A2\u0006\u0010Z\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020]H\u0016J\u001a\u0010^\u001a\u00020P2\u0006\u0010_\u001a\u00020%2\b\b\u0002\u0010`\u001a\u00020AH\u0002J\u0010\u0010a\u001a\u00020P2\u0006\u0010b\u001a\u00020\u0013H\u0002J\u0016\u0010c\u001a\u00020P2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00130eH\u0004J&\u0010f\u001a\u00020P\"\u0004\b\u0000\u0010g*\b\u0012\u0004\u0012\u0002Hg0#2\u0006\u0010h\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u000eR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R*\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001e`\u001fX\u0082.¢\u0006\u0002\n\u0000R*\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u001dj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n`\u001fX\u0082.¢\u0006\u0002\n\u0000R*\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\u001dj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0013`\u001fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130#X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%0\u001dj\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u001dj\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\b\u001a\u0004\b1\u00102R\u000e\u00104\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R*\u00109\u001a\u001e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00130\u001dj\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0013`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020;0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010>\u001a\u00060?R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\u00020AX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006l"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/category/CategoryWidgetNavFragment;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetNavFragment;", "()V", "categoryWidgetViewModel", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/category/CategoryWidgetViewModel;", "getCategoryWidgetViewModel", "()Lcom/magneticchen/daijishou/daijishou_widget/widgets/category/CategoryWidgetViewModel;", "categoryWidgetViewModel$delegate", "Lkotlin/Lazy;", "chipColorStateList", "Landroid/content/res/ColorStateList;", "chipGroup", "Lcom/google/android/material/chip/ChipGroup;", "colorHighlight", "", "colorOnHighlight", "colorOnPrimary", "colorPrimary", "currentGenreId", "", "getCurrentGenreId", "()Ljava/lang/String;", "setCurrentGenreId", "(Ljava/lang/String;)V", "emptyLayout", "Landroid/widget/LinearLayout;", "emptyTextView", "Landroid/widget/TextView;", "filterModeIconHashMap", "Ljava/util/HashMap;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/HashMap;", "filterModeIconTintHashMap", "filterModeTitleStringHashMap", "genreIdList", "", "genreIdToChipHashMap", "Lcom/google/android/material/chip/Chip;", "genreIdToNameHashMap", "gridLayoutManager", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouGridLayoutManager;", "horizontalScrollView", "Landroid/widget/HorizontalScrollView;", "iconImageView", "Landroid/widget/ImageView;", "lastToggleGenreTimeMillis", "", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "model$delegate", "noItemsFormatString", "noItemsString", "overviewChip", "overviewColorStateList", "overviewString", "platformIdToShortnameHashMap", "playableItemEntityList", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewAdapter", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/category/CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter;", "scrollingOnBackPressed", "", "selectedChip", "setToFilterModeFormatString", "strokeWidth", "", "titleLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "titleTextView", "useDefaultWallpaper", "getUseDefaultWallpaper", "()Z", "setUseDefaultWallpaper", "(Z)V", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHotKeyPressed", "hotkeyCode", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "selectChip", "chip", "smoothScroll", "updateDimensionRatio", "dimensionRatio", "updateGenres", "genreIds", "", "move", ExifInterface.GPS_DIRECTION_TRUE, TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "CategoryWidgetRecyclerViewAdapter", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CategoryWidgetNavFragment extends WidgetNavFragment {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* INFO: renamed from: categoryWidgetViewModel$delegate, reason: from kotlin metadata */
    private final Lazy categoryWidgetViewModel;
    private ColorStateList chipColorStateList;
    private ChipGroup chipGroup;
    private String currentGenreId;
    public LinearLayout emptyLayout;
    public TextView emptyTextView;
    private HashMap<Integer, Drawable> filterModeIconHashMap;
    private HashMap<Integer, ColorStateList> filterModeIconTintHashMap;
    public HashMap<Integer, String> filterModeTitleStringHashMap;
    public DaijishouGridLayoutManager gridLayoutManager;
    private HorizontalScrollView horizontalScrollView;
    private ImageView iconImageView;

    /* INFO: renamed from: model$delegate, reason: from kotlin metadata */
    private final Lazy model;
    public String noItemsFormatString;
    public String noItemsString;
    private Chip overviewChip;
    private ColorStateList overviewColorStateList;
    private String overviewString;
    public RecyclerView recyclerView;
    public CategoryWidgetRecyclerViewAdapter recyclerViewAdapter;
    private boolean scrollingOnBackPressed;
    private Chip selectedChip;
    private String setToFilterModeFormatString;
    private float strokeWidth;
    private ConstraintLayout titleLayout;
    private TextView titleTextView;
    private boolean useDefaultWallpaper;
    public final List<PlayableItemEntity> playableItemEntityList = new ArrayList();
    private final List<String> genreIdList = new ArrayList();
    private final HashMap<String, String> genreIdToNameHashMap = new HashMap<>();
    private final HashMap<String, Chip> genreIdToChipHashMap = new HashMap<>();
    private final HashMap<Long, String> platformIdToShortnameHashMap = new HashMap<>();
    private int colorPrimary = -1;
    private int colorOnPrimary = -1;
    private int colorHighlight = -1;
    private int colorOnHighlight = -1;
    private long lastToggleGenreTimeMillis = System.currentTimeMillis();

    /* INFO: compiled from: CategoryWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/category/CategoryWidgetNavFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/category/CategoryWidgetNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CategoryWidgetNavFragment newInstance() {
            return new CategoryWidgetNavFragment();
        }
    }

    public CategoryWidgetNavFragment() {
        CategoryWidgetNavFragment categoryWidgetNavFragment = this;
        this.model = FragmentViewModelLazyKt.createViewModelLazy(categoryWidgetNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new CategoryWidgetNavFragment$special$$inlined$activityViewModels$default$1(categoryWidgetNavFragment), new CategoryWidgetNavFragment$special$$inlined$activityViewModels$default$2(null, categoryWidgetNavFragment), new CategoryWidgetNavFragment$special$$inlined$activityViewModels$default$3(categoryWidgetNavFragment));
        this.categoryWidgetViewModel = FragmentViewModelLazyKt.createViewModelLazy(categoryWidgetNavFragment, Reflection.getOrCreateKotlinClass(CategoryWidgetViewModel.class), new CategoryWidgetNavFragment$special$$inlined$activityViewModels$default$4(categoryWidgetNavFragment), new CategoryWidgetNavFragment$special$$inlined$activityViewModels$default$5(null, categoryWidgetNavFragment), new CategoryWidgetNavFragment$special$$inlined$activityViewModels$default$6(categoryWidgetNavFragment));
    }

    public final <T> void move(List<T> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        T t = list.get(i);
        list.remove(t);
        list.add(i2, t);
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetNavFragment
    public boolean getUseDefaultWallpaper() {
        return this.useDefaultWallpaper;
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetNavFragment
    public void setUseDefaultWallpaper(boolean z) {
        this.useDefaultWallpaper = z;
    }

    /* INFO: Access modifiers changed from: private */
    public final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model.getValue();
    }

    /* INFO: Access modifiers changed from: private */
    public final CategoryWidgetViewModel getCategoryWidgetViewModel() {
        return (CategoryWidgetViewModel) this.categoryWidgetViewModel.getValue();
    }

    public final String getCurrentGenreId() {
        return this.currentGenreId;
    }

    public final void setCurrentGenreId(String str) {
        this.currentGenreId = str;
    }

    /* WARN: Code duplicated, block: B:11:0x0021  */
    /* WARN: Code duplicated, block: B:32:0x005f  */
    /* WARN: Code duplicated, block: B:34:0x0065  */
    /* WARN: Code duplicated, block: B:37:0x0070  */
    /* WARN: Code duplicated, block: B:40:0x007e  */
    /* WARN: Code duplicated, block: B:42:0x0082  */
    /* WARN: Code duplicated, block: B:45:0x008f  */
    /* WARN: Code duplicated, block: B:46:0x0093  */
    /* WARN: Code duplicated, block: B:48:0x0098  */
    /* WARN: Code duplicated, block: B:50:0x009c  */
    /* WARN: Code duplicated, block: B:51:0x00a0  */
    /* WARN: Code duplicated, block: B:9:0x001d  */
    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onBackPressed() {
        RecyclerView recyclerView;
        ConstraintLayout constraintLayout;
        DaijishouGridLayoutManager daijishouGridLayoutManager;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        super.onBackPressed();
        RecyclerView recyclerView5 = null;
        ConstraintLayout constraintLayout2 = null;
        RecyclerView recyclerView6 = null;
        if (this.scrollingOnBackPressed) {
            RecyclerView recyclerView7 = this.recyclerView;
            if (recyclerView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView7 = null;
            }
            if (recyclerView7.getScrollState() != 2) {
                recyclerView = this.recyclerView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView = null;
                }
                if (recyclerView.computeVerticalScrollOffset() != 0) {
                    this.scrollingOnBackPressed = true;
                    constraintLayout = this.titleLayout;
                    if (constraintLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
                        constraintLayout = null;
                    }
                    constraintLayout.requestFocus();
                    daijishouGridLayoutManager = this.gridLayoutManager;
                    if (daijishouGridLayoutManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
                        daijishouGridLayoutManager = null;
                    }
                    if (daijishouGridLayoutManager.findFirstVisibleItemPosition() > 256) {
                        recyclerView3 = this.recyclerView;
                        if (recyclerView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            recyclerView3 = null;
                        }
                        recyclerView3.scrollToPosition(128);
                        recyclerView4 = this.recyclerView;
                        if (recyclerView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        } else {
                            recyclerView6 = recyclerView4;
                        }
                        recyclerView6.smoothScrollToPosition(0);
                    } else {
                        recyclerView2 = this.recyclerView;
                        if (recyclerView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        } else {
                            recyclerView5 = recyclerView2;
                        }
                        recyclerView5.smoothScrollToPosition(0);
                    }
                    return false;
                }
            }
        } else {
            recyclerView = this.recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            if (recyclerView.computeVerticalScrollOffset() != 0) {
                this.scrollingOnBackPressed = true;
                constraintLayout = this.titleLayout;
                if (constraintLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
                    constraintLayout = null;
                }
                constraintLayout.requestFocus();
                daijishouGridLayoutManager = this.gridLayoutManager;
                if (daijishouGridLayoutManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
                    daijishouGridLayoutManager = null;
                }
                if (daijishouGridLayoutManager.findFirstVisibleItemPosition() > 256) {
                    recyclerView3 = this.recyclerView;
                    if (recyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        recyclerView3 = null;
                    }
                    recyclerView3.scrollToPosition(128);
                    recyclerView4 = this.recyclerView;
                    if (recyclerView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    } else {
                        recyclerView6 = recyclerView4;
                    }
                    recyclerView6.smoothScrollToPosition(0);
                } else {
                    recyclerView2 = this.recyclerView;
                    if (recyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    } else {
                        recyclerView5 = recyclerView2;
                    }
                    recyclerView5.smoothScrollToPosition(0);
                }
                return false;
            }
        }
        RecyclerView recyclerView8 = this.recyclerView;
        if (recyclerView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView8 = null;
        }
        recyclerView8.scrollToPosition(0);
        ConstraintLayout constraintLayout3 = this.titleLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout3 = null;
        }
        if (constraintLayout3.isFocused()) {
            return true;
        }
        ConstraintLayout constraintLayout4 = this.titleLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout4 = null;
        }
        constraintLayout4.requestFocus();
        ConstraintLayout constraintLayout5 = this.titleLayout;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
        } else {
            constraintLayout2 = constraintLayout5;
        }
        return !constraintLayout2.isFocused();
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onHotKeyPressed(int hotkeyCode, int keyCode, KeyEvent keyEvent) {
        int childCount;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(hotkeyCode, keyCode, keyEvent);
        ChipGroup chipGroup = null;
        CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter = null;
        ChipGroup chipGroup2 = null;
        ChipGroup chipGroup3 = null;
        ChipGroup chipGroup4 = null;
        if (hotkeyCode == 1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastToggleGenreTimeMillis < 45) {
                return false;
            }
            this.lastToggleGenreTimeMillis = jCurrentTimeMillis;
            if (this.selectedChip == null) {
                ChipGroup chipGroup5 = this.chipGroup;
                if (chipGroup5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup5 = null;
                }
                if (chipGroup5.getChildCount() > 0) {
                    ChipGroup chipGroup6 = this.chipGroup;
                    if (chipGroup6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    } else {
                        chipGroup4 = chipGroup6;
                    }
                    ((View) SequencesKt.elementAt(ViewGroupKt.getChildren(chipGroup4), 0)).performClick();
                }
            } else {
                ChipGroup chipGroup7 = this.chipGroup;
                if (chipGroup7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup7 = null;
                }
                int iIndexOfChild = chipGroup7.indexOfChild(this.selectedChip) + 1;
                ChipGroup chipGroup8 = this.chipGroup;
                if (chipGroup8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup8 = null;
                }
                int childCount2 = iIndexOfChild % chipGroup8.getChildCount();
                ChipGroup chipGroup9 = this.chipGroup;
                if (chipGroup9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                } else {
                    chipGroup = chipGroup9;
                }
                ((View) SequencesKt.elementAt(ViewGroupKt.getChildren(chipGroup), childCount2)).performClick();
            }
            return true;
        }
        if (hotkeyCode != 2) {
            if (hotkeyCode == 3) {
                getCategoryWidgetViewModel().toggleFilterMode();
                return true;
            }
            if (hotkeyCode != 4) {
                return false;
            }
            CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter2 = this.recyclerViewAdapter;
            if (categoryWidgetRecyclerViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            } else {
                categoryWidgetRecyclerViewAdapter = categoryWidgetRecyclerViewAdapter2;
            }
            DaijishouRecyclerView.Adapter<PlayableItemEntity>.ViewHolder selectedViewHolder = categoryWidgetRecyclerViewAdapter.getSelectedViewHolder();
            if (selectedViewHolder != null && selectedViewHolder.itemView.isFocused() && selectedViewHolder.getAbsoluteAdapterPosition() >= 0) {
                selectedViewHolder.itemView.performLongClick();
            }
            return true;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (jCurrentTimeMillis2 - this.lastToggleGenreTimeMillis < 45) {
            return false;
        }
        this.lastToggleGenreTimeMillis = jCurrentTimeMillis2;
        if (this.selectedChip == null) {
            ChipGroup chipGroup10 = this.chipGroup;
            if (chipGroup10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                chipGroup10 = null;
            }
            if (chipGroup10.getChildCount() > 0) {
                ChipGroup chipGroup11 = this.chipGroup;
                if (chipGroup11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                } else {
                    chipGroup2 = chipGroup11;
                }
                ((View) SequencesKt.elementAt(ViewGroupKt.getChildren(chipGroup2), 0)).performClick();
            }
        } else {
            ChipGroup chipGroup12 = this.chipGroup;
            if (chipGroup12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                chipGroup12 = null;
            }
            int iIndexOfChild2 = chipGroup12.indexOfChild(this.selectedChip);
            if (iIndexOfChild2 == 0) {
                ChipGroup chipGroup13 = this.chipGroup;
                if (chipGroup13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup13 = null;
                }
                childCount = chipGroup13.getChildCount() - 1;
            } else {
                int i = iIndexOfChild2 - 1;
                ChipGroup chipGroup14 = this.chipGroup;
                if (chipGroup14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup14 = null;
                }
                childCount = i % chipGroup14.getChildCount();
            }
            ChipGroup chipGroup15 = this.chipGroup;
            if (chipGroup15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
            } else {
                chipGroup3 = chipGroup15;
            }
            ((View) SequencesKt.elementAt(ViewGroupKt.getChildren(chipGroup3), childCount)).performClick();
        }
        return true;
    }

    /* INFO: Access modifiers changed from: private */
    public final void updateDimensionRatio(String dimensionRatio) {
        CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter = this.recyclerViewAdapter;
        RecyclerView recyclerView = null;
        if (categoryWidgetRecyclerViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            categoryWidgetRecyclerViewAdapter = null;
        }
        categoryWidgetRecyclerViewAdapter.setDimensionRatio(dimensionRatio);
        CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter2 = this.recyclerViewAdapter;
        if (categoryWidgetRecyclerViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            categoryWidgetRecyclerViewAdapter2 = null;
        }
        categoryWidgetRecyclerViewAdapter2.notifyDataSetChanged();
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.invalidate();
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView3;
        }
        recyclerView.requestLayout();
    }

    /* INFO: compiled from: CategoryWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J \u0010#\u001a\n0$R\u00060\u0000R\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\"H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/category/CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "playableItemEntityList", "", "(Lcom/magneticchen/daijishou/daijishou_widget/widgets/category/CategoryWidgetNavFragment;Ljava/util/List;)V", "cachedBitmapLoader", "Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;", "getCachedBitmapLoader", "()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;", "value", "", "dimensionRatio", "getDimensionRatio", "()Ljava/lang/String;", "setDimensionRatio", "(Ljava/lang/String;)V", "dimensionRatioHasChanged", "", "getDimensionRatioHasChanged", "()Z", "setDimensionRatioHasChanged", "(Z)V", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "model$delegate", "Lkotlin/Lazy;", "textColorsBackup", "Landroid/content/res/ColorStateList;", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/category/CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/category/CategoryWidgetNavFragment;", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class CategoryWidgetRecyclerViewAdapter extends DaijishouRecyclerView.Adapter<PlayableItemEntity> {
        private final CachedBitmapLoader cachedBitmapLoader;
        private String dimensionRatio;
        private boolean dimensionRatioHasChanged;

        /* INFO: renamed from: model$delegate, reason: from kotlin metadata */
        private final Lazy model;
        private final List<PlayableItemEntity> playableItemEntityList;
        private ColorStateList textColorsBackup;
        final /* synthetic */ CategoryWidgetNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CategoryWidgetRecyclerViewAdapter(CategoryWidgetNavFragment categoryWidgetNavFragment, List<PlayableItemEntity> playableItemEntityList) {
            super(playableItemEntityList, true, false, 4, null);
            Intrinsics.checkNotNullParameter(playableItemEntityList, "playableItemEntityList");
            this.this$0 = categoryWidgetNavFragment;
            this.playableItemEntityList = playableItemEntityList;
            setEnforceSelectionInSelectableMode(false);
            CategoryWidgetNavFragment categoryWidgetNavFragment2 = categoryWidgetNavFragment;
            this.model = FragmentViewModelLazyKt.createViewModelLazy(categoryWidgetNavFragment2, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter$special$$inlined$activityViewModels$default$1(categoryWidgetNavFragment2), new CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter$special$$inlined$activityViewModels$default$2(null, categoryWidgetNavFragment2), new CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter$special$$inlined$activityViewModels$default$3(categoryWidgetNavFragment2));
            this.dimensionRatio = Constants.defaultThumbnailDimensionRatio;
            this.cachedBitmapLoader = categoryWidgetNavFragment.getDaijishouLibrary().getCachedBoxArtBitmapLoader();
        }

        public final boolean getDimensionRatioHasChanged() {
            return this.dimensionRatioHasChanged;
        }

        public final void setDimensionRatioHasChanged(boolean z) {
            this.dimensionRatioHasChanged = z;
        }

        public final DaijishouViewModel getModel() {
            return (DaijishouViewModel) this.model.getValue();
        }

        public final String getDimensionRatio() {
            return this.dimensionRatio;
        }

        public final void setDimensionRatio(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.dimensionRatio = value;
            this.dimensionRatioHasChanged = Intrinsics.areEqual(value, value);
        }

        public final CachedBitmapLoader getCachedBitmapLoader() {
            return this.cachedBitmapLoader;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            return this.playableItemEntityList.get(position).getId();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_playable_item_thumbnail, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }

        /* INFO: compiled from: CategoryWidgetNavFragment.kt */
        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0015H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/category/CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/daijishou_widget/widgets/category/CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter;Landroid/view/View;)V", "backgroundSet", "Landroidx/constraintlayout/widget/ConstraintLayout;", "imageView", "Landroid/widget/ImageView;", "placeholder", "platformTextView", "Landroid/widget/TextView;", "textView", "onBind", "", "position", "", "item", "onClick", "", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<PlayableItemEntity>.ViewHolder {
            private ConstraintLayout backgroundSet;
            public ImageView imageView;
            public ImageView placeholder;
            public TextView platformTextView;
            private TextView textView;
            final /* synthetic */ CategoryWidgetRecyclerViewAdapter this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter, View itemView) {
                super(categoryWidgetRecyclerViewAdapter, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = categoryWidgetRecyclerViewAdapter;
                View viewFindViewById = itemView.findViewById(R.id.playable_item_thumbnail_text_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                this.textView = (TextView) viewFindViewById;
                View viewFindViewById2 = itemView.findViewById(R.id.playable_item_platform_text_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.platformTextView = (TextView) viewFindViewById2;
                View viewFindViewById3 = itemView.findViewById(R.id.playable_item_thumbnail_wallpaper);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                this.imageView = (ImageView) viewFindViewById3;
                View viewFindViewById4 = itemView.findViewById(R.id.playable_item_thumbnail_placeholder);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
                this.placeholder = (ImageView) viewFindViewById4;
                View viewFindViewById5 = itemView.findViewById(R.id.playable_item_thumbnail_background_set);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
                this.backgroundSet = (ConstraintLayout) viewFindViewById5;
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public boolean onClick() {
                Utils utils = Utils.INSTANCE;
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Utils.scaleView$default(utils, itemView, 1.0f, 1.03f, 0L, false, 24, null);
                return true;
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocus() {
                super.onFocus();
                Utils utils = Utils.INSTANCE;
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Utils.scaleView$default(utils, itemView, 1.0f, 1.03f, 0L, false, 24, null);
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocusClear(boolean isAbsoluteAdapterPositionValid) {
                super.onFocusClear(isAbsoluteAdapterPositionValid);
                if (isAbsoluteAdapterPositionValid) {
                    Utils utils = Utils.INSTANCE;
                    View itemView = this.itemView;
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    Utils.scaleView$default(utils, itemView, 1.03f, 1.0f, 0L, false, 24, null);
                }
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int position, PlayableItemEntity item) {
                Intrinsics.checkNotNullParameter(item, "item");
                this.imageView.setImageBitmap(null);
                if (this.placeholder.getVisibility() != 0) {
                    this.placeholder.setVisibility(0);
                }
                if (this.platformTextView.getVisibility() != 0) {
                    this.platformTextView.setVisibility(0);
                }
                if (this.this$0.textColorsBackup == null) {
                    this.this$0.textColorsBackup = this.textView.getTextColors();
                }
                this.textView.setText(this.this$0.this$0.getDaijishouLibrary().prettifyTitleWithPreferences(item.getName()));
                TextView textView = this.platformTextView;
                Object obj = (String) this.this$0.this$0.platformIdToShortnameHashMap.get(item.getAttachedPlatformId());
                if (obj == null) {
                    obj = this.this$0.this$0.genreIdToNameHashMap.get(this.this$0.this$0.getCurrentGenreId());
                }
                textView.setText((CharSequence) obj);
                ViewGroup.LayoutParams layoutParams = this.backgroundSet.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                if (!Intrinsics.areEqual(layoutParams2.dimensionRatio, this.this$0.getDimensionRatio())) {
                    layoutParams2.dimensionRatio = this.this$0.getDimensionRatio();
                    this.backgroundSet.requestLayout();
                }
                String boxArtPath = Utils.INSTANCE.getBoxArtPath(item);
                if (boxArtPath != null) {
                    this.this$0.getCachedBitmapLoader().with(this.this$0.this$0).load(boxArtPath).setOnFailedListener(new CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter$ViewHolder$onBind$1(this)).setOnSucceedListener(new CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter$ViewHolder$onBind$2(this)).into(this.imageView);
                }
            }
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = contextRequireContext.getTheme();
        Intrinsics.checkNotNullExpressionValue(theme, "getTheme(...)");
        this.filterModeTitleStringHashMap = MapsKt.hashMapOf(TuplesKt.to(0, getString(R.string.all_items)), TuplesKt.to(1, getString(R.string.favorite)), TuplesKt.to(2, getString(R.string.recent)), TuplesKt.to(3, getString(R.string.newly)));
        String string = getString(R.string.overview);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.overviewString = string;
        String string2 = getString(R.string.set_to_mode_format);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.setToFilterModeFormatString = string2;
        String string3 = getString(R.string.no_items_format);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.noItemsFormatString = string3;
        String string4 = getString(R.string.no_items);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        this.noItemsString = string4;
        theme.resolveAttribute(R.attr.colorPrimary, typedValue, true);
        this.colorPrimary = typedValue.data;
        theme.resolveAttribute(R.attr.colorOnPrimary, typedValue, true);
        this.colorOnPrimary = typedValue.data;
        theme.resolveAttribute(R.attr.colorHighlight, typedValue, true);
        this.colorHighlight = typedValue.data;
        theme.resolveAttribute(R.attr.colorOnHighlight, typedValue, true);
        this.colorOnHighlight = typedValue.data;
        this.strokeWidth = getDpToPxConverter().convert(1.5f);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.round_category_24, contextRequireContext.getTheme());
        Intrinsics.checkNotNull(drawable);
        Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_round_favorite_24, contextRequireContext.getTheme());
        Intrinsics.checkNotNull(drawable2);
        Drawable drawable3 = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_twotone_brightness_1_24, contextRequireContext.getTheme());
        Intrinsics.checkNotNull(drawable3);
        Drawable drawable4 = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_baseline_auto_awesome_24, contextRequireContext.getTheme());
        Intrinsics.checkNotNull(drawable4);
        this.filterModeIconHashMap = MapsKt.hashMapOf(TuplesKt.to(0, drawable), TuplesKt.to(1, drawable2), TuplesKt.to(2, drawable3), TuplesKt.to(3, drawable4));
        this.filterModeIconTintHashMap = MapsKt.hashMapOf(TuplesKt.to(0, new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{this.colorPrimary})), TuplesKt.to(1, new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{getResources().getColor(R.color.favorite, contextRequireContext.getTheme())})), TuplesKt.to(2, new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{getResources().getColor(R.color.activity, contextRequireContext.getTheme())})), TuplesKt.to(3, new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{getResources().getColor(R.color.newly, contextRequireContext.getTheme())})));
        this.overviewColorStateList = new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{this.colorHighlight});
        this.chipColorStateList = new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{this.colorPrimary});
    }

    static /* synthetic */ void selectChip$default(CategoryWidgetNavFragment categoryWidgetNavFragment, Chip chip, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        categoryWidgetNavFragment.selectChip(chip, z);
    }

    private final void selectChip(Chip chip, boolean smoothScroll) {
        if (Intrinsics.areEqual(this.selectedChip, chip)) {
            return;
        }
        Chip chip2 = this.selectedChip;
        if (chip2 != null) {
            chip2.setChipBackgroundColor(chip.getChipBackgroundColor());
            chip2.setTextColor(chip.getTextColors());
        }
        Chip chip3 = this.overviewChip;
        HorizontalScrollView horizontalScrollView = null;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overviewChip");
            chip3 = null;
        }
        if (Intrinsics.areEqual(chip, chip3)) {
            Chip chip4 = this.overviewChip;
            if (chip4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("overviewChip");
                chip4 = null;
            }
            ColorStateList colorStateList = this.overviewColorStateList;
            if (colorStateList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("overviewColorStateList");
                colorStateList = null;
            }
            chip4.setChipBackgroundColor(colorStateList);
            Chip chip5 = this.overviewChip;
            if (chip5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("overviewChip");
                chip5 = null;
            }
            chip5.setTextColor(this.colorOnHighlight);
        } else {
            ColorStateList colorStateList2 = this.chipColorStateList;
            if (colorStateList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipColorStateList");
                colorStateList2 = null;
            }
            chip.setChipBackgroundColor(colorStateList2);
            chip.setTextColor(this.colorOnPrimary);
        }
        this.selectedChip = chip;
        String str = null;
        for (Map.Entry<String, Chip> entry : this.genreIdToChipHashMap.entrySet()) {
            String key = entry.getKey();
            if (Intrinsics.areEqual(entry.getValue(), chip)) {
                str = key;
            }
        }
        this.currentGenreId = str;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.requestLayout();
        getCategoryWidgetViewModel().setSelectedGenreId(str);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.scrollToPosition(0);
        if (str == null) {
            DaijishouViewModel model = getModel();
            String str2 = this.overviewString;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("overviewString");
                str2 = null;
            }
            DaijishouViewModel.setTips$default(model, str2, false, 2, null);
        } else {
            DaijishouViewModel model2 = getModel();
            String str3 = this.genreIdToNameHashMap.get(str);
            Intrinsics.checkNotNull(str3);
            DaijishouViewModel.setTips$default(model2, str3, false, 2, null);
        }
        HorizontalScrollView horizontalScrollView2 = this.horizontalScrollView;
        if (horizontalScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
        } else {
            horizontalScrollView = horizontalScrollView2;
        }
        horizontalScrollView.post(new CategoryWidgetNavFragment$$ExternalSyntheticLambda2(smoothScroll, this, chip));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void selectChip$lambda$3(boolean z, CategoryWidgetNavFragment this$0, Chip chip) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(chip, "$chip");
        HorizontalScrollView horizontalScrollView = null;
        if (z) {
            HorizontalScrollView horizontalScrollView2 = this$0.horizontalScrollView;
            if (horizontalScrollView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
            } else {
                horizontalScrollView = horizontalScrollView2;
            }
            horizontalScrollView.smoothScrollTo(Math.max(0, chip.getLeft() - this$0.getDpToPxConverter().convert(32.0f)), 0);
            return;
        }
        HorizontalScrollView horizontalScrollView3 = this$0.horizontalScrollView;
        if (horizontalScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
        } else {
            horizontalScrollView = horizontalScrollView3;
        }
        horizontalScrollView.setScrollX(Math.max(0, chip.getLeft() - this$0.getDpToPxConverter().convert(32.0f)));
    }

    protected final void updateGenres(List<String> genreIds) {
        Chip chip;
        Intrinsics.checkNotNullParameter(genreIds, "genreIds");
        if (!Intrinsics.areEqual(genreIds, this.genreIdList) || this.selectedChip == null) {
            ChipGroup chipGroup = this.chipGroup;
            ChipGroup chipGroup2 = null;
            if (chipGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                chipGroup = null;
            }
            chipGroup.removeAllViews();
            this.genreIdList.clear();
            this.genreIdList.addAll(genreIds);
            ChipGroup chipGroup3 = this.chipGroup;
            if (chipGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                chipGroup3 = null;
            }
            Chip chip2 = this.overviewChip;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("overviewChip");
                chip2 = null;
            }
            chipGroup3.addView(chip2);
            Chip chip3 = null;
            for (String str : genreIds) {
                if (this.genreIdToChipHashMap.get(str) != null) {
                    chip = this.genreIdToChipHashMap.get(str);
                } else {
                    Chip chip4 = new Chip(getContext());
                    Genre genre = Genres.INSTANCE.getGenres().get(str);
                    String string = getString(genre != null ? genre.getNameStringId() : R.string.unknown_genre_name);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    this.genreIdToNameHashMap.put(str, string);
                    chip4.setEnsureMinTouchTargetSize(false);
                    chip4.setAllCaps(true);
                    chip4.setChipStrokeColorResource(R.color.material_on_surface_stroke);
                    chip4.setText(string);
                    chip4.setTypeface(null, 3);
                    chip4.setOnClickListener(new CategoryWidgetNavFragment$$ExternalSyntheticLambda3(this, chip4));
                    this.genreIdToChipHashMap.put(str, chip4);
                    chip = chip4;
                }
                if (chip != null) {
                    if (chip.getParent() != null) {
                        ViewParent parent = chip.getParent();
                        Intrinsics.checkNotNull(parent);
                        ((ViewGroup) parent).removeView(chip);
                    }
                    if (chip3 != null) {
                        chip3.setNextFocusRightId(chip.getId());
                        chip.setNextFocusLeftId(chip3.getId());
                    }
                    ChipGroup chipGroup4 = this.chipGroup;
                    if (chipGroup4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                        chipGroup4 = null;
                    }
                    chipGroup4.addView(chip);
                    chip3 = chip;
                }
            }
            if (chip3 != null) {
                chip3.setNextFocusRightId(chip3 != null ? chip3.getId() : -1);
            }
            String selectedGenreId = getCategoryWidgetViewModel().getSelectedGenreId();
            int iIndexOf = CollectionsKt.indexOf((List<? extends String>) this.genreIdList, selectedGenreId);
            if (selectedGenreId != null) {
                Chip chip5 = this.selectedChip;
                ChipGroup chipGroup5 = this.chipGroup;
                if (chipGroup5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup5 = null;
                }
                int i = iIndexOf + 1;
                if (Intrinsics.areEqual(chip5, SequencesKt.elementAt(ViewGroupKt.getChildren(chipGroup5), i))) {
                    return;
                }
                ChipGroup chipGroup6 = this.chipGroup;
                if (chipGroup6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                } else {
                    chipGroup2 = chipGroup6;
                }
                Object objElementAt = SequencesKt.elementAt(ViewGroupKt.getChildren(chipGroup2), i);
                Intrinsics.checkNotNull(objElementAt, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
                selectChip((Chip) objElementAt, false);
                return;
            }
            Chip chip6 = this.selectedChip;
            ChipGroup chipGroup7 = this.chipGroup;
            if (chipGroup7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                chipGroup7 = null;
            }
            if (Intrinsics.areEqual(chip6, SequencesKt.elementAt(ViewGroupKt.getChildren(chipGroup7), 0))) {
                return;
            }
            ChipGroup chipGroup8 = this.chipGroup;
            if (chipGroup8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
            } else {
                chipGroup2 = chipGroup8;
            }
            Object objElementAt2 = SequencesKt.elementAt(ViewGroupKt.getChildren(chipGroup2), 0);
            Intrinsics.checkNotNull(objElementAt2, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
            selectChip((Chip) objElementAt2, false);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void updateGenres$lambda$6$lambda$4(CategoryWidgetNavFragment this$0, Chip chip, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(chip, "$chip");
        selectChip$default(this$0, chip, false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        View viewInflate = inflater.inflate(R.layout.widget_nav_fragment_genres, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.highlight_title_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.titleLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.highlight_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.recyclerView = (RecyclerView) viewFindViewById2;
        this.recyclerViewAdapter = new CategoryWidgetRecyclerViewAdapter(this, this.playableItemEntityList);
        this.gridLayoutManager = new DaijishouGridLayoutManager(contextRequireContext, 120.0f, 8, 16.0f, false, 16, null);
        View viewFindViewById3 = viewInflate.findViewById(R.id.highlight_chip_group);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.chipGroup = (ChipGroup) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.highlight_icon_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.iconImageView = (ImageView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.highlight_title_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.titleTextView = (TextView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.highlight_empty_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.emptyLayout = (LinearLayout) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.highlight_empty_textview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.emptyTextView = (TextView) viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(R.id.highlight_horizontal_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.horizontalScrollView = (HorizontalScrollView) viewFindViewById8;
        CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter = null;
        this.selectedChip = null;
        this.overviewChip = new Chip(contextRequireContext);
        this.genreIdToChipHashMap.clear();
        ConstraintLayout constraintLayout = this.titleLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout = null;
        }
        constraintLayout.setOnClickListener(new CategoryWidgetNavFragment$$ExternalSyntheticLambda0(this));
        CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter2 = this.recyclerViewAdapter;
        if (categoryWidgetRecyclerViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            categoryWidgetRecyclerViewAdapter2 = null;
        }
        categoryWidgetRecyclerViewAdapter2.setOnItemClickListener(new AnonymousClass2(fragmentActivityRequireActivity));
        CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter3 = this.recyclerViewAdapter;
        if (categoryWidgetRecyclerViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            categoryWidgetRecyclerViewAdapter3 = null;
        }
        categoryWidgetRecyclerViewAdapter3.setOnItemLongClickListener(new AnonymousClass3(fragmentActivityRequireActivity, this));
        CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter4 = this.recyclerViewAdapter;
        if (categoryWidgetRecyclerViewAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            categoryWidgetRecyclerViewAdapter4 = null;
        }
        categoryWidgetRecyclerViewAdapter4.setOnItemSelectListener(new AnonymousClass4());
        DaijishouGridLayoutManager daijishouGridLayoutManager = this.gridLayoutManager;
        if (daijishouGridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
            daijishouGridLayoutManager = null;
        }
        daijishouGridLayoutManager.setItemPrefetchEnabled(true);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        DaijishouGridLayoutManager daijishouGridLayoutManager2 = this.gridLayoutManager;
        if (daijishouGridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
            daijishouGridLayoutManager2 = null;
        }
        recyclerView.setLayoutManager(daijishouGridLayoutManager2);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter5 = this.recyclerViewAdapter;
        if (categoryWidgetRecyclerViewAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            categoryWidgetRecyclerViewAdapter5 = null;
        }
        recyclerView2.setAdapter(categoryWidgetRecyclerViewAdapter5);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setHasFixedSize(true);
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        recyclerView4.addOnScrollListener(new AnonymousClass5());
        for (PlatformEntity platformEntity : getDaijishouLibrary().getAllPlatformsStatically()) {
            this.platformIdToShortnameHashMap.put(Long.valueOf(platformEntity.getId()), platformEntity.getShortname());
        }
        getDaijishouLibrary().getAllPlatforms().observe(getViewLifecycleOwner(), new CategoryWidgetNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass7()));
        Chip chip = this.overviewChip;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overviewChip");
            chip = null;
        }
        chip.setEnsureMinTouchTargetSize(false);
        Chip chip2 = this.overviewChip;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overviewChip");
            chip2 = null;
        }
        chip2.setAllCaps(true);
        Chip chip3 = this.overviewChip;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overviewChip");
            chip3 = null;
        }
        chip3.setChipStrokeColorResource(R.color.material_on_surface_stroke);
        Chip chip4 = this.overviewChip;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overviewChip");
            chip4 = null;
        }
        chip4.setChipStrokeWidth(this.strokeWidth);
        Chip chip5 = this.overviewChip;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overviewChip");
            chip5 = null;
        }
        String str = this.overviewString;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overviewString");
            str = null;
        }
        chip5.setText(str);
        Chip chip6 = this.overviewChip;
        if (chip6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overviewChip");
            chip6 = null;
        }
        chip6.setTypeface(null, 1);
        Chip chip7 = this.overviewChip;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overviewChip");
            chip7 = null;
        }
        chip7.setOnClickListener(new CategoryWidgetNavFragment$$ExternalSyntheticLambda1(this));
        updateGenres(getDaijishouLibrary().getAllGenreIdsStatically());
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        getDaijishouLibrary().getAllGenreIds().observe(getViewLifecycleOwner(), new CategoryWidgetNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass9(booleanRef, this)));
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        booleanRef2.element = getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue());
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue()).observe(getViewLifecycleOwner(), new CategoryWidgetNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass10(booleanRef2, this)));
        String string = getDefaultSharedPreferences().getString(StringPreference.CATEGORY_WIDGET_NAV_ASPECT_RATIO.getKey(), StringPreference.CATEGORY_WIDGET_NAV_ASPECT_RATIO.getDefaultValue());
        if (string != null) {
            CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter6 = this.recyclerViewAdapter;
            if (categoryWidgetRecyclerViewAdapter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                categoryWidgetRecyclerViewAdapter6 = null;
            }
            if (!Intrinsics.areEqual(categoryWidgetRecyclerViewAdapter6.getDimensionRatio(), string) && Constants.INSTANCE.getAspectRatioRegex().matches(string)) {
                CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter7 = this.recyclerViewAdapter;
                if (categoryWidgetRecyclerViewAdapter7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                } else {
                    categoryWidgetRecyclerViewAdapter = categoryWidgetRecyclerViewAdapter7;
                }
                categoryWidgetRecyclerViewAdapter.setDimensionRatio(string);
            }
        }
        new SharedPreferenceStringLiveData(getDefaultSharedPreferences(), StringPreference.CATEGORY_WIDGET_NAV_ASPECT_RATIO.getKey(), StringPreference.CATEGORY_WIDGET_NAV_ASPECT_RATIO.getDefaultValue()).observe(getViewLifecycleOwner(), new CategoryWidgetNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass12()));
        getCategoryWidgetViewModel().getGenresWidgetPlayableItemsLiveData().observe(getViewLifecycleOwner(), new CategoryWidgetNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass13()));
        getCategoryWidgetViewModel().getFilterModeLiveData().observe(getViewLifecycleOwner(), new CategoryWidgetNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass14()));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.PRETTIFY_TITLES.getKey(), BooleanPreference.PRETTIFY_TITLES.getDefaultValue()).observe(getViewLifecycleOwner(), new CategoryWidgetNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass15()));
        return viewInflate;
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7(CategoryWidgetNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCategoryWidgetViewModel().toggleFilterMode();
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.category.CategoryWidgetNavFragment$onCreateView$2, reason: invalid class name */
    /* INFO: compiled from: CategoryWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda<Unit> implements Function4<View, Integer, Long, PlayableItemEntity, Unit> {
        final /* synthetic */ FragmentActivity $activity;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(FragmentActivity fragmentActivity) {
            super(4);
            this.$activity = fragmentActivity;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity) {
            invoke(view, num.intValue(), l.longValue(), playableItemEntity);
            return Unit.INSTANCE;
        }

        public final void invoke(View view, int i, long j, PlayableItemEntity playableItemEntity) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
            DaijishouLibraryModel.play$default(CategoryWidgetNavFragment.this.getDaijishouLibrary(), this.$activity, playableItemEntity, null, 4, null);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.category.CategoryWidgetNavFragment$onCreateView$3, reason: invalid class name */
    /* INFO: compiled from: CategoryWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke", "(Landroid/view/View;IJLcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass3 extends Lambda<Boolean> implements Function4<View, Integer, Long, PlayableItemEntity, Boolean> {
        final /* synthetic */ FragmentActivity $activity;
        final /* synthetic */ CategoryWidgetNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(FragmentActivity fragmentActivity, CategoryWidgetNavFragment categoryWidgetNavFragment) {
            super(4);
            this.$activity = fragmentActivity;
            this.this$0 = categoryWidgetNavFragment;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Boolean invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity) {
            return invoke(view, num.intValue(), l.longValue(), playableItemEntity);
        }

        public final Boolean invoke(View view, int i, long j, PlayableItemEntity playableItemEntity) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
            FragmentActivity fragmentActivity = this.$activity;
            Intrinsics.checkNotNull(fragmentActivity, "null cannot be cast to non-null type com.magneticchen.daijishou.activities.MainActivity");
            ((MainActivity) fragmentActivity).setAndroidPDialogFixStopKeyDispatching(true);
            PlayableItemDetailDialogFragment.INSTANCE.newInstance(playableItemEntity).show(this.this$0.getChildFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
            return true;
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.category.CategoryWidgetNavFragment$onCreateView$4, reason: invalid class name */
    /* INFO: compiled from: CategoryWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass4 extends Lambda<Unit> implements Function4<View, Integer, Long, PlayableItemEntity, Unit> {
        AnonymousClass4() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity) {
            invoke(view, num.intValue(), l.longValue(), playableItemEntity);
            return Unit.INSTANCE;
        }

        public final void invoke(View view, int i, long j, PlayableItemEntity playableItemEntity) {
            Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
            CategoryWidgetNavFragment.this.getModel().setTipsForPlayableItem(playableItemEntity);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.category.CategoryWidgetNavFragment$onCreateView$5, reason: invalid class name */
    /* INFO: compiled from: CategoryWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/daijishou_widget/widgets/category/CategoryWidgetNavFragment$onCreateView$5", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass5 extends RecyclerView.OnScrollListener {
        AnonymousClass5() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                CategoryWidgetNavFragment.this.scrollingOnBackPressed = false;
            }
            super.onScrollStateChanged(recyclerView, newState);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.category.CategoryWidgetNavFragment$onCreateView$7, reason: invalid class name */
    /* INFO: compiled from: CategoryWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass7 extends Lambda<Unit> implements Function1<List<? extends PlatformEntity>, Unit> {
        AnonymousClass7() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlatformEntity> list) {
            invoke2((List<PlatformEntity>) list);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<PlatformEntity> list) {
            Intrinsics.checkNotNull(list);
            CategoryWidgetNavFragment categoryWidgetNavFragment = CategoryWidgetNavFragment.this;
            for (PlatformEntity platformEntity : list) {
                categoryWidgetNavFragment.platformIdToShortnameHashMap.put(Long.valueOf(platformEntity.getId()), platformEntity.getShortname());
            }
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$9(CategoryWidgetNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Chip chip = this$0.overviewChip;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overviewChip");
            chip = null;
        }
        selectChip$default(this$0, chip, false, 2, null);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.category.CategoryWidgetNavFragment$onCreateView$9, reason: invalid class name */
    /* INFO: compiled from: CategoryWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "genreIds", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass9 extends Lambda<Unit> implements Function1<List<? extends String>, Unit> {
        final /* synthetic */ Ref.BooleanRef $firstTime;
        final /* synthetic */ CategoryWidgetNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(Ref.BooleanRef booleanRef, CategoryWidgetNavFragment categoryWidgetNavFragment) {
            super(1);
            this.$firstTime = booleanRef;
            this.this$0 = categoryWidgetNavFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<String> list) {
            if (this.$firstTime.element) {
                this.$firstTime.element = false;
                return;
            }
            CategoryWidgetNavFragment categoryWidgetNavFragment = this.this$0;
            Intrinsics.checkNotNull(list);
            categoryWidgetNavFragment.updateGenres(list);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateView$refreshPlayableItems(CategoryWidgetNavFragment categoryWidgetNavFragment, List<PlayableItemEntity> list) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(categoryWidgetNavFragment), Dispatchers.getIO(), null, new CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1(categoryWidgetNavFragment, list, null), 2, null);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.category.CategoryWidgetNavFragment$onCreateView$10, reason: invalid class name */
    /* INFO: compiled from: CategoryWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass10 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ Ref.BooleanRef $oldPref;
        final /* synthetic */ CategoryWidgetNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass10(Ref.BooleanRef booleanRef, CategoryWidgetNavFragment categoryWidgetNavFragment) {
            super(1);
            this.$oldPref = booleanRef;
            this.this$0 = categoryWidgetNavFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            if (Intrinsics.areEqual(Boolean.valueOf(this.$oldPref.element), bool)) {
                return;
            }
            Ref.BooleanRef booleanRef = this.$oldPref;
            Intrinsics.checkNotNull(bool);
            booleanRef.element = bool.booleanValue();
            List<PlayableItemEntity> value = this.this$0.getCategoryWidgetViewModel().getGenresWidgetPlayableItemsLiveData().getValue();
            if (value != null) {
                CategoryWidgetNavFragment.onCreateView$refreshPlayableItems(this.this$0, value);
            }
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.category.CategoryWidgetNavFragment$onCreateView$12, reason: invalid class name */
    /* INFO: compiled from: CategoryWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass12 extends Lambda<Unit> implements Function1<String, Unit> {
        AnonymousClass12() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter = CategoryWidgetNavFragment.this.recyclerViewAdapter;
            if (categoryWidgetRecyclerViewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                categoryWidgetRecyclerViewAdapter = null;
            }
            if (Intrinsics.areEqual(categoryWidgetRecyclerViewAdapter.getDimensionRatio(), str)) {
                return;
            }
            Regex aspectRatioRegex = Constants.INSTANCE.getAspectRatioRegex();
            Intrinsics.checkNotNull(str);
            if (aspectRatioRegex.matches(str)) {
                CategoryWidgetNavFragment.this.updateDimensionRatio(str);
            }
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.category.CategoryWidgetNavFragment$onCreateView$13, reason: invalid class name */
    /* INFO: compiled from: CategoryWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "playableItems", "", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass13 extends Lambda<Unit> implements Function1<List<? extends PlayableItemEntity>, Unit> {
        AnonymousClass13() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlayableItemEntity> list) {
            invoke2((List<PlayableItemEntity>) list);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<PlayableItemEntity> list) {
            CategoryWidgetNavFragment categoryWidgetNavFragment = CategoryWidgetNavFragment.this;
            Intrinsics.checkNotNull(list);
            CategoryWidgetNavFragment.onCreateView$refreshPlayableItems(categoryWidgetNavFragment, list);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.category.CategoryWidgetNavFragment$onCreateView$14, reason: invalid class name */
    /* INFO: compiled from: CategoryWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass14 extends Lambda<Unit> implements Function1<Integer, Unit> {
        AnonymousClass14() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            ImageView imageView = CategoryWidgetNavFragment.this.iconImageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iconImageView");
                imageView = null;
            }
            HashMap map = CategoryWidgetNavFragment.this.filterModeIconHashMap;
            if (map == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterModeIconHashMap");
                map = null;
            }
            imageView.setImageDrawable((Drawable) map.get(num));
            ConstraintLayout constraintLayout = CategoryWidgetNavFragment.this.titleLayout;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
                constraintLayout = null;
            }
            constraintLayout.requestFocus();
            HashMap map2 = CategoryWidgetNavFragment.this.filterModeIconTintHashMap;
            if (map2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterModeIconTintHashMap");
                map2 = null;
            }
            ColorStateList colorStateList = (ColorStateList) map2.get(num);
            ImageView imageView2 = CategoryWidgetNavFragment.this.iconImageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iconImageView");
                imageView2 = null;
            }
            imageView2.setImageTintList(colorStateList);
            HashMap map3 = CategoryWidgetNavFragment.this.filterModeTitleStringHashMap;
            if (map3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterModeTitleStringHashMap");
                map3 = null;
            }
            String str = (String) map3.get(Integer.valueOf(CategoryWidgetNavFragment.this.getCategoryWidgetViewModel().getFilterMode()));
            TextView textView = CategoryWidgetNavFragment.this.titleTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                textView = null;
            }
            textView.setText(str);
            DaijishouViewModel model = CategoryWidgetNavFragment.this.getModel();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = CategoryWidgetNavFragment.this.setToFilterModeFormatString;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setToFilterModeFormatString");
                str2 = null;
            }
            String str3 = String.format(str2, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            DaijishouViewModel.setTips$default(model, str3, false, 2, null);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.category.CategoryWidgetNavFragment$onCreateView$15, reason: invalid class name */
    /* INFO: compiled from: CategoryWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass15 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        AnonymousClass15() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter = CategoryWidgetNavFragment.this.recyclerViewAdapter;
            if (categoryWidgetRecyclerViewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                categoryWidgetRecyclerViewAdapter = null;
            }
            categoryWidgetRecyclerViewAdapter.notifyDataSetChanged();
        }
    }
}
