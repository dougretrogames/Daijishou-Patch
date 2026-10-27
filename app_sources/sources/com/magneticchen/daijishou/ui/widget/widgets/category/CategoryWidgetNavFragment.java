package com.magneticchen.daijishou.ui.widget.widgets.category;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.cache.CachedBitmapLoader;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.Genre;
import com.magneticchen.daijishou.data.Genres;
import com.magneticchen.daijishou.data.StringPreference;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.live.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.data.live.SharedPreferenceStringLiveData;
import com.magneticchen.daijishou.ui.activities.MainActivity;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouGridLayoutManager;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.magneticchen.daijishou.ui.model.DaijishouViewModel;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetNavFragment;
import com.magneticchen.daijishou.utils.Utils;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CategoryWidgetNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 k2\u00020\u0001:\u0002jkB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010N\u001a\u00020AH\u0016J\u0012\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J&\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010X2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0017J \u0010Y\u001a\u00020A2\u0006\u0010Z\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020]H\u0016J\u001a\u0010^\u001a\u00020P2\u0006\u0010_\u001a\u00020%2\b\b\u0002\u0010`\u001a\u00020AH\u0002J\u0010\u0010a\u001a\u00020P2\u0006\u0010b\u001a\u00020\u0013H\u0002J\u0016\u0010c\u001a\u00020P2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00130eH\u0004J&\u0010f\u001a\u00020P\"\u0004\b\u0000\u0010g*\b\u0012\u0004\u0012\u0002Hg0#2\u0006\u0010h\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u000eR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R*\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001e`\u001fX\u0082.¢\u0006\u0002\n\u0000R*\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u001dj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n`\u001fX\u0082.¢\u0006\u0002\n\u0000R*\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\u001dj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0013`\u001fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130#X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%0\u001dj\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020%`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u001dj\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\b\u001a\u0004\b1\u00102R\u000e\u00104\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R*\u00109\u001a\u001e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00130\u001dj\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0013`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020;0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010>\u001a\u00060?R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\u00020AX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006l"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/category/CategoryWidgetNavFragment;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetNavFragment;", "()V", "categoryWidgetViewModel", "Lcom/magneticchen/daijishou/ui/widget/widgets/category/CategoryWidgetViewModel;", "getCategoryWidgetViewModel", "()Lcom/magneticchen/daijishou/ui/widget/widgets/category/CategoryWidgetViewModel;", "categoryWidgetViewModel$delegate", "Lkotlin/Lazy;", "chipColorStateList", "Landroid/content/res/ColorStateList;", "chipGroup", "Lcom/google/android/material/chip/ChipGroup;", "colorHighlight", "", "colorOnHighlight", "colorOnPrimary", "colorPrimary", "currentGenreId", "", "getCurrentGenreId", "()Ljava/lang/String;", "setCurrentGenreId", "(Ljava/lang/String;)V", "emptyLayout", "Landroid/widget/LinearLayout;", "emptyTextView", "Landroid/widget/TextView;", "filterModeIconHashMap", "Ljava/util/HashMap;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/HashMap;", "filterModeIconTintHashMap", "filterModeTitleStringHashMap", "genreIdList", "", "genreIdToChipHashMap", "Lcom/google/android/material/chip/Chip;", "genreIdToNameHashMap", "gridLayoutManager", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouGridLayoutManager;", "horizontalScrollView", "Landroid/widget/HorizontalScrollView;", "iconImageView", "Landroid/widget/ImageView;", "lastToggleGenreTimeMillis", "", "model", "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "model$delegate", "noItemsFormatString", "noItemsString", "overviewChip", "overviewColorStateList", "overviewString", "platformIdToShortnameHashMap", "playableItemEntityList", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewAdapter", "Lcom/magneticchen/daijishou/ui/widget/widgets/category/CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter;", "scrollingOnBackPressed", "", "selectedChip", "setToFilterModeFormatString", "strokeWidth", "", "titleLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "titleTextView", "useDefaultWallpaper", "getUseDefaultWallpaper", "()Z", "setUseDefaultWallpaper", "(Z)V", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHotKeyPressed", "hotkeyCode", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "selectChip", "chip", "smoothScroll", "updateDimensionRatio", "dimensionRatio", "updateGenres", "genreIds", "", "move", "T", "from", "to", "CategoryWidgetRecyclerViewAdapter", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CategoryWidgetNavFragment extends WidgetNavFragment {
    public static final Companion Companion = new Companion(null);
    private final Lazy categoryWidgetViewModel$delegate;
    private ColorStateList chipColorStateList;
    private ChipGroup chipGroup;
    private String currentGenreId;
    private LinearLayout emptyLayout;
    private TextView emptyTextView;
    private HashMap<Integer, Drawable> filterModeIconHashMap;
    private HashMap<Integer, ColorStateList> filterModeIconTintHashMap;
    private HashMap<Integer, String> filterModeTitleStringHashMap;
    private DaijishouGridLayoutManager gridLayoutManager;
    private HorizontalScrollView horizontalScrollView;
    private ImageView iconImageView;
    private final Lazy model$delegate;
    private String noItemsFormatString;
    private String noItemsString;
    private Chip overviewChip;
    private ColorStateList overviewColorStateList;
    private String overviewString;
    private RecyclerView recyclerView;
    private CategoryWidgetRecyclerViewAdapter recyclerViewAdapter;
    private boolean scrollingOnBackPressed;
    private Chip selectedChip;
    private String setToFilterModeFormatString;
    private float strokeWidth;
    private ConstraintLayout titleLayout;
    private TextView titleTextView;
    private boolean useDefaultWallpaper;
    private final List<PlayableItemEntity> playableItemEntityList = new ArrayList();
    private final List<String> genreIdList = new ArrayList();
    private final HashMap<String, String> genreIdToNameHashMap = new HashMap<>();
    private final HashMap<String, Chip> genreIdToChipHashMap = new HashMap<>();
    private final HashMap<Long, String> platformIdToShortnameHashMap = new HashMap<>();
    private int colorPrimary = -1;
    private int colorOnPrimary = -1;
    private int colorHighlight = -1;
    private int colorOnHighlight = -1;
    private long lastToggleGenreTimeMillis = System.currentTimeMillis();

    /* JADX INFO: compiled from: CategoryWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/category/CategoryWidgetNavFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/widget/widgets/category/CategoryWidgetNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
        final CategoryWidgetNavFragment categoryWidgetNavFragment = this;
        final Function0 function0 = null;
        this.model$delegate = FragmentViewModelLazyKt.createViewModelLazy(categoryWidgetNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return categoryWidgetNavFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? categoryWidgetNavFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return categoryWidgetNavFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        this.categoryWidgetViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(categoryWidgetNavFragment, Reflection.getOrCreateKotlinClass(CategoryWidgetViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment$special$$inlined$activityViewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return categoryWidgetNavFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? categoryWidgetNavFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment$special$$inlined$activityViewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return categoryWidgetNavFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    public final <T> void move(List<T> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        T t = list.get(i);
        list.remove(t);
        list.add(i2, t);
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetNavFragment
    public boolean getUseDefaultWallpaper() {
        return this.useDefaultWallpaper;
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetNavFragment
    public void setUseDefaultWallpaper(boolean z) {
        this.useDefaultWallpaper = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CategoryWidgetViewModel getCategoryWidgetViewModel() {
        return (CategoryWidgetViewModel) this.categoryWidgetViewModel$delegate.getValue();
    }

    public final String getCurrentGenreId() {
        return this.currentGenreId;
    }

    public final void setCurrentGenreId(String str) {
        this.currentGenreId = str;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0021  */
    /* JADX WARN: Code duplicated, block: B:32:0x005f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x0070  */
    /* JADX WARN: Code duplicated, block: B:40:0x007e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0082  */
    /* JADX WARN: Code duplicated, block: B:45:0x008f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0093  */
    /* JADX WARN: Code duplicated, block: B:48:0x0098  */
    /* JADX WARN: Code duplicated, block: B:50:0x009c  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:9:0x001d  */
    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public boolean onBackPressed() {
        RecyclerView recyclerView;
        ConstraintLayout constraintLayout;
        DaijishouGridLayoutManager daijishouGridLayoutManager;
        ConstraintLayout constraintLayout2;
        RecyclerView recyclerView2;
        ConstraintLayout constraintLayout3;
        super.onBackPressed();
        ConstraintLayout constraintLayout4 = null;
        if (this.scrollingOnBackPressed) {
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView3 = null;
            }
            if (recyclerView3.getScrollState() != 2) {
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
                        recyclerView2 = this.recyclerView;
                        if (recyclerView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            recyclerView2 = null;
                        }
                        recyclerView2.scrollToPosition(128);
                        constraintLayout3 = this.recyclerView;
                        if (constraintLayout3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        } else {
                            constraintLayout4 = constraintLayout3;
                        }
                        constraintLayout4.smoothScrollToPosition(0);
                    } else {
                        constraintLayout2 = this.recyclerView;
                        if (constraintLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        } else {
                            constraintLayout4 = constraintLayout2;
                        }
                        constraintLayout4.smoothScrollToPosition(0);
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
                    recyclerView2 = this.recyclerView;
                    if (recyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        recyclerView2 = null;
                    }
                    recyclerView2.scrollToPosition(128);
                    constraintLayout3 = this.recyclerView;
                    if (constraintLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    } else {
                        constraintLayout4 = constraintLayout3;
                    }
                    constraintLayout4.smoothScrollToPosition(0);
                } else {
                    constraintLayout2 = this.recyclerView;
                    if (constraintLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    } else {
                        constraintLayout4 = constraintLayout2;
                    }
                    constraintLayout4.smoothScrollToPosition(0);
                }
                return false;
            }
        }
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        recyclerView4.scrollToPosition(0);
        ConstraintLayout constraintLayout5 = this.titleLayout;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout5 = null;
        }
        if (constraintLayout5.isFocused()) {
            return true;
        }
        ConstraintLayout constraintLayout6 = this.titleLayout;
        if (constraintLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout6 = null;
        }
        constraintLayout6.requestFocus();
        ConstraintLayout constraintLayout7 = this.titleLayout;
        if (constraintLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
        } else {
            constraintLayout4 = constraintLayout7;
        }
        return !constraintLayout4.isFocused();
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public boolean onHotKeyPressed(int i, int i2, KeyEvent keyEvent) {
        int childCount;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(i, i2, keyEvent);
        ChipGroup chipGroup = null;
        if (i == 1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastToggleGenreTimeMillis < 45) {
                return false;
            }
            this.lastToggleGenreTimeMillis = jCurrentTimeMillis;
            if (this.selectedChip == null) {
                ChipGroup chipGroup2 = this.chipGroup;
                if (chipGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup2 = null;
                }
                if (chipGroup2.getChildCount() > 0) {
                    ChipGroup chipGroup3 = this.chipGroup;
                    if (chipGroup3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    } else {
                        chipGroup = chipGroup3;
                    }
                    ((View) SequencesKt.elementAt(ViewGroupKt.getChildren((ViewGroup) chipGroup), 0)).performClick();
                }
            } else {
                ChipGroup chipGroup4 = this.chipGroup;
                if (chipGroup4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup4 = null;
                }
                int iIndexOfChild = chipGroup4.indexOfChild(this.selectedChip) + 1;
                ChipGroup chipGroup5 = this.chipGroup;
                if (chipGroup5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup5 = null;
                }
                int childCount2 = iIndexOfChild % chipGroup5.getChildCount();
                ChipGroup chipGroup6 = this.chipGroup;
                if (chipGroup6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                } else {
                    chipGroup = chipGroup6;
                }
                ((View) SequencesKt.elementAt(ViewGroupKt.getChildren((ViewGroup) chipGroup), childCount2)).performClick();
            }
            return true;
        }
        if (i != 2) {
            if (i == 3) {
                getCategoryWidgetViewModel().toggleFilterMode();
                return true;
            }
            if (i != 4) {
                return false;
            }
            ChipGroup chipGroup7 = this.recyclerViewAdapter;
            if (chipGroup7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            } else {
                chipGroup = chipGroup7;
            }
            DaijishouRecyclerView.Adapter.ViewHolder selectedViewHolder = chipGroup.getSelectedViewHolder();
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
            ChipGroup chipGroup8 = this.chipGroup;
            if (chipGroup8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                chipGroup8 = null;
            }
            if (chipGroup8.getChildCount() > 0) {
                ChipGroup chipGroup9 = this.chipGroup;
                if (chipGroup9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                } else {
                    chipGroup = chipGroup9;
                }
                ((View) SequencesKt.elementAt(ViewGroupKt.getChildren((ViewGroup) chipGroup), 0)).performClick();
            }
        } else {
            ChipGroup chipGroup10 = this.chipGroup;
            if (chipGroup10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                chipGroup10 = null;
            }
            int iIndexOfChild2 = chipGroup10.indexOfChild(this.selectedChip);
            if (iIndexOfChild2 == 0) {
                ChipGroup chipGroup11 = this.chipGroup;
                if (chipGroup11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup11 = null;
                }
                childCount = chipGroup11.getChildCount() - 1;
            } else {
                int i3 = iIndexOfChild2 - 1;
                ChipGroup chipGroup12 = this.chipGroup;
                if (chipGroup12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup12 = null;
                }
                childCount = i3 % chipGroup12.getChildCount();
            }
            ChipGroup chipGroup13 = this.chipGroup;
            if (chipGroup13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
            } else {
                chipGroup = chipGroup13;
            }
            ((View) SequencesKt.elementAt(ViewGroupKt.getChildren((ViewGroup) chipGroup), childCount)).performClick();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDimensionRatio(String str) {
        CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter = this.recyclerViewAdapter;
        RecyclerView recyclerView = null;
        if (categoryWidgetRecyclerViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            categoryWidgetRecyclerViewAdapter = null;
        }
        categoryWidgetRecyclerViewAdapter.setDimensionRatio(str);
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

    /* JADX INFO: compiled from: CategoryWidgetNavFragment.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J \u0010#\u001a\n0$R\u00060\u0000R\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\"H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/category/CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "playableItemEntityList", "", "(Lcom/magneticchen/daijishou/ui/widget/widgets/category/CategoryWidgetNavFragment;Ljava/util/List;)V", "cachedBitmapLoader", "Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;", "getCachedBitmapLoader", "()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;", "value", "", "dimensionRatio", "getDimensionRatio", "()Ljava/lang/String;", "setDimensionRatio", "(Ljava/lang/String;)V", "dimensionRatioHasChanged", "", "getDimensionRatioHasChanged", "()Z", "setDimensionRatioHasChanged", "(Z)V", "model", "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "model$delegate", "Lkotlin/Lazy;", "textColorsBackup", "Landroid/content/res/ColorStateList;", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/ui/widget/widgets/category/CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/widget/widgets/category/CategoryWidgetNavFragment;", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class CategoryWidgetRecyclerViewAdapter extends DaijishouRecyclerView.Adapter<PlayableItemEntity> {
        private final CachedBitmapLoader cachedBitmapLoader;
        private String dimensionRatio;
        private boolean dimensionRatioHasChanged;
        private final Lazy model$delegate;
        private final List<PlayableItemEntity> playableItemEntityList;
        private ColorStateList textColorsBackup;
        final /* synthetic */ CategoryWidgetNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CategoryWidgetRecyclerViewAdapter(CategoryWidgetNavFragment categoryWidgetNavFragment, List<PlayableItemEntity> playableItemEntityList) {
            super(playableItemEntityList, true, false, 4, null);
            Intrinsics.checkNotNullParameter(playableItemEntityList, "playableItemEntityList");
            this.this$0 = categoryWidgetNavFragment;
            this.playableItemEntityList = playableItemEntityList;
            setEnforceSelectionInSelectableMode(false);
            final CategoryWidgetNavFragment categoryWidgetNavFragment2 = categoryWidgetNavFragment;
            final Function0 function0 = null;
            this.model$delegate = FragmentViewModelLazyKt.createViewModelLazy(categoryWidgetNavFragment2, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter$special$$inlined$activityViewModels$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ViewModelStore invoke() {
                    return categoryWidgetNavFragment2.requireActivity().getViewModelStore();
                }
            }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter$special$$inlined$activityViewModels$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final CreationExtras invoke() {
                    CreationExtras creationExtras;
                    Function0 function1 = function0;
                    return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? categoryWidgetNavFragment2.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
                }
            }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter$special$$inlined$activityViewModels$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ViewModelProvider.Factory invoke() {
                    return categoryWidgetNavFragment2.requireActivity().getDefaultViewModelProviderFactory();
                }
            });
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
            return (DaijishouViewModel) this.model$delegate.getValue();
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

        public long getItemId(int i) {
            return this.playableItemEntityList.get(i).getId();
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_playable_item_thumbnail, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }

        /* JADX INFO: compiled from: CategoryWidgetNavFragment.kt */
        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0015H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/category/CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/widget/widgets/category/CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter;Landroid/view/View;)V", "backgroundSet", "Landroidx/constraintlayout/widget/ConstraintLayout;", "imageView", "Landroid/widget/ImageView;", "placeholder", "platformTextView", "Landroid/widget/TextView;", "textView", "onBind", "", "position", "", "item", "onClick", "", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<PlayableItemEntity>.ViewHolder {
            private ConstraintLayout backgroundSet;
            private ImageView imageView;
            private ImageView placeholder;
            private TextView platformTextView;
            private TextView textView;
            final /* synthetic */ CategoryWidgetRecyclerViewAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ConstraintLayout constraintLayoutFindViewById = itemView.findViewById(R.id.playable_item_thumbnail_background_set);
                Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
                this.backgroundSet = constraintLayoutFindViewById;
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public boolean onClick() {
                Utils utils = Utils.INSTANCE;
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Utils.scaleView$default(utils, itemView, 1.0f, 1.03f, 0L, false, 24, null);
                return true;
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocus() {
                super.onFocus();
                Utils utils = Utils.INSTANCE;
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Utils.scaleView$default(utils, itemView, 1.0f, 1.03f, 0L, false, 24, null);
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocusClear(boolean z) {
                super.onFocusClear(z);
                if (z) {
                    Utils utils = Utils.INSTANCE;
                    View itemView = this.itemView;
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    Utils.scaleView$default(utils, itemView, 1.03f, 1.0f, 0L, false, 24, null);
                }
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int i, PlayableItemEntity item) {
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
                ConstraintLayout.LayoutParams layoutParams = this.backgroundSet.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
                if (!Intrinsics.areEqual(layoutParams2.dimensionRatio, this.this$0.getDimensionRatio())) {
                    layoutParams2.dimensionRatio = this.this$0.getDimensionRatio();
                    this.backgroundSet.requestLayout();
                }
                String boxArtPath = Utils.INSTANCE.getBoxArtPath(item);
                if (boxArtPath != null) {
                    CachedBitmapLoader.CachedBitmapLoaderTask.load$default(this.this$0.getCachedBitmapLoader().with(this.this$0.this$0), boxArtPath, false, 2, null).setOnFailedListener(new Function1<Exception, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter$ViewHolder$onBind$1
                        

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                            invoke2(exc);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Exception it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            this.this$0.placeholder.setVisibility(0);
                            this.this$0.platformTextView.setVisibility(0);
                        }
                    }).setOnSucceedListener(new Function2<Bitmap, Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter$ViewHolder$onBind$2
                        

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                            invoke(bitmap, bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Bitmap bitmap, boolean z) {
                            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                            this.this$0.placeholder.setVisibility(8);
                            this.this$0.platformTextView.setVisibility(8);
                            this.this$0.imageView.setImageBitmap(bitmap);
                        }
                    }).into(this.imageView);
                }
            }
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
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
        theme.resolveAttribute(2130968898, typedValue, true);
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

    private final void selectChip(final Chip chip, final boolean z) {
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
        horizontalScrollView.post(new Runnable() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CategoryWidgetNavFragment.selectChip$lambda$3(z, this, chip);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
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
            ViewGroup viewGroup = null;
            if (chipGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                chipGroup = null;
            }
            chipGroup.removeAllViews();
            this.genreIdList.clear();
            this.genreIdList.addAll(genreIds);
            ChipGroup chipGroup2 = this.chipGroup;
            if (chipGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                chipGroup2 = null;
            }
            Chip chip2 = this.overviewChip;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("overviewChip");
                chip2 = null;
            }
            chipGroup2.addView((View) chip2);
            Chip chip3 = null;
            for (String str : genreIds) {
                if (this.genreIdToChipHashMap.get(str) != null) {
                    chip = this.genreIdToChipHashMap.get(str);
                } else {
                    final Chip chip4 = new Chip(getContext());
                    Genre genre = Genres.INSTANCE.getGenres().get(str);
                    String string = getString(genre != null ? genre.getNameStringId() : R.string.unknown_genre_name);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    this.genreIdToNameHashMap.put(str, string);
                    chip4.setEnsureMinTouchTargetSize(false);
                    chip4.setAllCaps(true);
                    chip4.setChipStrokeColorResource(R.color.material_on_surface_stroke);
                    chip4.setText(string);
                    chip4.setTypeface((Typeface) null, 3);
                    chip4.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CategoryWidgetNavFragment.updateGenres$lambda$6$lambda$4(this.f$0, chip4, view);
                        }
                    });
                    this.genreIdToChipHashMap.put(str, chip4);
                    chip = chip4;
                }
                if (chip != null) {
                    if (chip.getParent() != null) {
                        ViewParent parent = chip.getParent();
                        Intrinsics.checkNotNull(parent);
                        ((ViewGroup) parent).removeView((View) chip);
                    }
                    if (chip3 != null) {
                        chip3.setNextFocusRightId(chip.getId());
                        chip.setNextFocusLeftId(chip3.getId());
                    }
                    ChipGroup chipGroup3 = this.chipGroup;
                    if (chipGroup3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                        chipGroup3 = null;
                    }
                    chipGroup3.addView((View) chip);
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
                ChipGroup chipGroup4 = this.chipGroup;
                if (chipGroup4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup4 = null;
                }
                int i = iIndexOf + 1;
                if (Intrinsics.areEqual(chip5, SequencesKt.elementAt(ViewGroupKt.getChildren((ViewGroup) chipGroup4), i))) {
                    return;
                }
                ViewGroup viewGroup2 = this.chipGroup;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                } else {
                    viewGroup = viewGroup2;
                }
                Object objElementAt = SequencesKt.elementAt(ViewGroupKt.getChildren(viewGroup), i);
                Intrinsics.checkNotNull(objElementAt, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
                selectChip((Chip) objElementAt, false);
                return;
            }
            Chip chip6 = this.selectedChip;
            ChipGroup chipGroup5 = this.chipGroup;
            if (chipGroup5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                chipGroup5 = null;
            }
            if (Intrinsics.areEqual(chip6, SequencesKt.elementAt(ViewGroupKt.getChildren((ViewGroup) chipGroup5), 0))) {
                return;
            }
            ViewGroup viewGroup3 = this.chipGroup;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
            } else {
                viewGroup = viewGroup3;
            }
            Object objElementAt2 = SequencesKt.elementAt(ViewGroupKt.getChildren(viewGroup), 0);
            Intrinsics.checkNotNull(objElementAt2, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
            selectChip((Chip) objElementAt2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateGenres$lambda$6$lambda$4(CategoryWidgetNavFragment this$0, Chip chip, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(chip, "$chip");
        selectChip$default(this$0, chip, false, 2, null);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        View viewInflate = inflater.inflate(R.layout.widget_nav_fragment_genres, viewGroup, false);
        ConstraintLayout constraintLayoutFindViewById = viewInflate.findViewById(R.id.highlight_title_layout);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
        this.titleLayout = constraintLayoutFindViewById;
        RecyclerView recyclerViewFindViewById = viewInflate.findViewById(R.id.highlight_recycler_view);
        Intrinsics.checkNotNullExpressionValue(recyclerViewFindViewById, "findViewById(...)");
        this.recyclerView = recyclerViewFindViewById;
        this.recyclerViewAdapter = new CategoryWidgetRecyclerViewAdapter(this, this.playableItemEntityList);
        this.gridLayoutManager = new DaijishouGridLayoutManager(contextRequireContext, 120.0f, 8, 16.0f, false, 16, null);
        ChipGroup chipGroupFindViewById = viewInflate.findViewById(R.id.highlight_chip_group);
        Intrinsics.checkNotNullExpressionValue(chipGroupFindViewById, "findViewById(...)");
        this.chipGroup = chipGroupFindViewById;
        View viewFindViewById = viewInflate.findViewById(R.id.highlight_icon_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.iconImageView = (ImageView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.highlight_title_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.titleTextView = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.highlight_empty_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.emptyLayout = (LinearLayout) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.highlight_empty_textview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.emptyTextView = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.highlight_horizontal_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.horizontalScrollView = (HorizontalScrollView) viewFindViewById5;
        CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter = null;
        this.selectedChip = null;
        this.overviewChip = new Chip(contextRequireContext);
        this.genreIdToChipHashMap.clear();
        ConstraintLayout constraintLayout = this.titleLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout = null;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryWidgetNavFragment.onCreateView$lambda$7(this.f$0, view);
            }
        });
        CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter2 = this.recyclerViewAdapter;
        if (categoryWidgetRecyclerViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            categoryWidgetRecyclerViewAdapter2 = null;
        }
        categoryWidgetRecyclerViewAdapter2.setOnItemClickListener(new Function4<View, Integer, Long, PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment.onCreateView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity) {
                invoke(view, num.intValue(), l.longValue(), playableItemEntity);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i, long j, PlayableItemEntity playableItemEntity) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
                DaijishouLibraryModel.play$default(CategoryWidgetNavFragment.this.getDaijishouLibrary(), fragmentActivityRequireActivity, playableItemEntity, null, 4, null);
            }
        });
        CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter3 = this.recyclerViewAdapter;
        if (categoryWidgetRecyclerViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            categoryWidgetRecyclerViewAdapter3 = null;
        }
        categoryWidgetRecyclerViewAdapter3.setOnItemLongClickListener(new Function4<View, Integer, Long, PlayableItemEntity, Boolean>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment.onCreateView.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Boolean invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity) {
                return invoke(view, num.intValue(), l.longValue(), playableItemEntity);
            }

            public final Boolean invoke(View view, int i, long j, PlayableItemEntity playableItemEntity) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
                MainActivity mainActivity = fragmentActivityRequireActivity;
                Intrinsics.checkNotNull(mainActivity, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.activities.MainActivity");
                mainActivity.setAndroidPDialogFixStopKeyDispatching(true);
                PlayableItemDetailDialogFragment.Companion.newInstance(playableItemEntity).show(this.getChildFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
                return true;
            }
        });
        CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter4 = this.recyclerViewAdapter;
        if (categoryWidgetRecyclerViewAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            categoryWidgetRecyclerViewAdapter4 = null;
        }
        categoryWidgetRecyclerViewAdapter4.setOnItemSelectListener(new Function4<View, Integer, Long, PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment.onCreateView.4
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity) {
                invoke(view, num.intValue(), l.longValue(), playableItemEntity);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i, long j, PlayableItemEntity playableItemEntity) {
                Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
                CategoryWidgetNavFragment.this.getModel().setTipsForPlayableItem(playableItemEntity);
            }
        });
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
        recyclerView.setLayoutManager((RecyclerView.LayoutManager) daijishouGridLayoutManager2);
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
        recyclerView4.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment.onCreateView.5
            public void onScrollStateChanged(RecyclerView recyclerView5, int i) {
                Intrinsics.checkNotNullParameter(recyclerView5, "recyclerView");
                if (i == 0) {
                    CategoryWidgetNavFragment.this.scrollingOnBackPressed = false;
                }
                super.onScrollStateChanged(recyclerView5, i);
            }
        });
        for (PlatformEntity platformEntity : getDaijishouLibrary().getAllPlatformsStatically()) {
            this.platformIdToShortnameHashMap.put(Long.valueOf(platformEntity.getId()), platformEntity.getShortname());
        }
        getDaijishouLibrary().getAllPlatforms().observe(getViewLifecycleOwner(), new CategoryWidgetNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends PlatformEntity>, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment.onCreateView.7
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlatformEntity> list) {
                invoke2((List<PlatformEntity>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<PlatformEntity> list) {
                Intrinsics.checkNotNull(list);
                CategoryWidgetNavFragment categoryWidgetNavFragment = CategoryWidgetNavFragment.this;
                for (PlatformEntity platformEntity2 : list) {
                    categoryWidgetNavFragment.platformIdToShortnameHashMap.put(Long.valueOf(platformEntity2.getId()), platformEntity2.getShortname());
                }
            }
        }));
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
        chip6.setTypeface((Typeface) null, 1);
        Chip chip7 = this.overviewChip;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overviewChip");
            chip7 = null;
        }
        chip7.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryWidgetNavFragment.onCreateView$lambda$9(this.f$0, view);
            }
        });
        updateGenres(getDaijishouLibrary().getAllGenreIdsStatically());
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        getDaijishouLibrary().getAllGenreIds().observe(getViewLifecycleOwner(), new CategoryWidgetNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends String>, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment.onCreateView.9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                if (booleanRef.element) {
                    booleanRef.element = false;
                    return;
                }
                CategoryWidgetNavFragment categoryWidgetNavFragment = this;
                Intrinsics.checkNotNull(list);
                categoryWidgetNavFragment.updateGenres(list);
            }
        }));
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        booleanRef2.element = getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue());
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue()).observe(getViewLifecycleOwner(), new CategoryWidgetNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment.onCreateView.10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                if (Intrinsics.areEqual(Boolean.valueOf(booleanRef2.element), bool)) {
                    return;
                }
                Ref.BooleanRef booleanRef3 = booleanRef2;
                Intrinsics.checkNotNull(bool);
                booleanRef3.element = bool.booleanValue();
                List list = (List) this.getCategoryWidgetViewModel().getGenresWidgetPlayableItemsLiveData().getValue();
                if (list != null) {
                    CategoryWidgetNavFragment.onCreateView$refreshPlayableItems(this, list);
                }
            }
        }));
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
        new SharedPreferenceStringLiveData(getDefaultSharedPreferences(), StringPreference.CATEGORY_WIDGET_NAV_ASPECT_RATIO.getKey(), StringPreference.CATEGORY_WIDGET_NAV_ASPECT_RATIO.getDefaultValue()).observe(getViewLifecycleOwner(), new CategoryWidgetNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment.onCreateView.12
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter8 = CategoryWidgetNavFragment.this.recyclerViewAdapter;
                if (categoryWidgetRecyclerViewAdapter8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                    categoryWidgetRecyclerViewAdapter8 = null;
                }
                if (Intrinsics.areEqual(categoryWidgetRecyclerViewAdapter8.getDimensionRatio(), str2)) {
                    return;
                }
                Regex aspectRatioRegex = Constants.INSTANCE.getAspectRatioRegex();
                Intrinsics.checkNotNull(str2);
                if (aspectRatioRegex.matches(str2)) {
                    CategoryWidgetNavFragment.this.updateDimensionRatio(str2);
                }
            }
        }));
        getCategoryWidgetViewModel().getGenresWidgetPlayableItemsLiveData().observe(getViewLifecycleOwner(), new CategoryWidgetNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends PlayableItemEntity>, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment.onCreateView.13
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlayableItemEntity> list) {
                invoke2((List<PlayableItemEntity>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<PlayableItemEntity> list) {
                CategoryWidgetNavFragment categoryWidgetNavFragment = CategoryWidgetNavFragment.this;
                Intrinsics.checkNotNull(list);
                CategoryWidgetNavFragment.onCreateView$refreshPlayableItems(categoryWidgetNavFragment, list);
            }
        }));
        getCategoryWidgetViewModel().getFilterModeLiveData().observe(getViewLifecycleOwner(), new CategoryWidgetNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment.onCreateView.14
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
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
                ConstraintLayout constraintLayout2 = CategoryWidgetNavFragment.this.titleLayout;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
                    constraintLayout2 = null;
                }
                constraintLayout2.requestFocus();
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
                String str2 = (String) map3.get(Integer.valueOf(CategoryWidgetNavFragment.this.getCategoryWidgetViewModel().getFilterMode()));
                TextView textView = CategoryWidgetNavFragment.this.titleTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                    textView = null;
                }
                textView.setText(str2);
                DaijishouViewModel model = CategoryWidgetNavFragment.this.getModel();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str3 = CategoryWidgetNavFragment.this.setToFilterModeFormatString;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("setToFilterModeFormatString");
                    str3 = null;
                }
                String str4 = String.format(str3, Arrays.copyOf(new Object[]{str2}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                DaijishouViewModel.setTips$default(model, str4, false, 2, null);
            }
        }));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.PRETTIFY_TITLES.getKey(), BooleanPreference.PRETTIFY_TITLES.getDefaultValue()).observe(getViewLifecycleOwner(), new CategoryWidgetNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetNavFragment.onCreateView.15
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                CategoryWidgetRecyclerViewAdapter categoryWidgetRecyclerViewAdapter8 = CategoryWidgetNavFragment.this.recyclerViewAdapter;
                if (categoryWidgetRecyclerViewAdapter8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                    categoryWidgetRecyclerViewAdapter8 = null;
                }
                categoryWidgetRecyclerViewAdapter8.notifyDataSetChanged();
            }
        }));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7(CategoryWidgetNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getCategoryWidgetViewModel().toggleFilterMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$9(CategoryWidgetNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Chip chip = this$0.overviewChip;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overviewChip");
            chip = null;
        }
        selectChip$default(this$0, chip, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$refreshPlayableItems(CategoryWidgetNavFragment categoryWidgetNavFragment, List<PlayableItemEntity> list) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) categoryWidgetNavFragment), Dispatchers.getIO(), (CoroutineStart) null, new CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1(categoryWidgetNavFragment, list, null), 2, (Object) null);
    }
}
