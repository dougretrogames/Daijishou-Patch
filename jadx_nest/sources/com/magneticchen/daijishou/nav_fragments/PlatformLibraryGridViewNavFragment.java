package com.magneticchen.daijishou.nav_fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
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
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.imageview.ShapeableImageView;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.PlatformNavFragment;
import com.magneticchen.daijishou.activities.MainActivity;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.cache.CachedBitmapLoader;
import com.magneticchen.daijishou.daijishou_library_db.Genre;
import com.magneticchen.daijishou.daijishou_library_db.Genres;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouGridLayoutManager;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment;
import com.magneticchen.daijishou.live_data.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import com.magneticchen.daijishou.view_models.LibraryViewModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.SortedMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.commons.collections4.CollectionUtils;

/* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 l2\u00020\u0001:\u0002lmB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010V\u001a\u00020\u001dH\u0002J\u0010\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u000eH\u0002J\b\u0010Z\u001a\u00020\u001dH\u0016J\u0012\u0010[\u001a\u00020X2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J&\u0010^\u001a\u0004\u0018\u00010\u00162\u0006\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010b2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J \u0010c\u001a\u00020\u001d2\u0006\u0010d\u001a\u00020\u000e2\u0006\u0010e\u001a\u00020\u000e2\u0006\u0010f\u001a\u00020gH\u0016J\b\u0010h\u001a\u00020XH\u0016J\u001a\u0010i\u001a\u00020X2\u0006\u0010j\u001a\u00020\u00162\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\b\u0010k\u001a\u00020XH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u001fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004` X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b1\u00102R\u000e\u00105\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00107\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u00104\u001a\u0004\b9\u0010:R\u000e\u0010<\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010D\u001a\u00060ER\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u000e0HX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020L0KX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020SX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020UX\u0082.¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryGridViewNavFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/PlatformNavFragment;", "()V", "backupChip", "Lcom/google/android/material/chip/Chip;", "boxArtAspectRatio", "", "boxArtAspectRatioList", "", "chipColorStateList", "Landroid/content/res/ColorStateList;", "chipGroup", "Lcom/google/android/material/chip/ChipGroup;", "colorOnPrimary", "", "colorPrimary", "currentGenreId", "getCurrentGenreId", "()Ljava/lang/String;", "setCurrentGenreId", "(Ljava/lang/String;)V", "dividerView", "Landroid/view/View;", "emptyLayout", "Landroid/widget/LinearLayout;", "favoriteButton", "favoriteFormatString", "filterMode", "filterModeRequestFromOnPageSelected", "", "genreIdToChipHashMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "genreIds", "genresChipGroup", "gridLayoutManager", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouGridLayoutManager;", "hopToNextItemLock", "horizontalScrollView", "Landroid/widget/HorizontalScrollView;", "itemCountButton", "itemCountFormatString", "lastHopToNextItemTimeMillis", "", "lastToggleGenreTimeMillis", "lastToggleViewModeTimeMillis", "lastVisibleChipIndex", "libraryViewModel", "Lcom/magneticchen/daijishou/view_models/LibraryViewModel;", "getLibraryViewModel", "()Lcom/magneticchen/daijishou/view_models/LibraryViewModel;", "libraryViewModel$delegate", "Lkotlin/Lazy;", "listViewButton", "lockToggleViewMode", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "model$delegate", "newFormatString", "newlyAddedButton", "platformEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "platformFormatString", "platformId", "platformLibraryGridRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "platformLibraryGridRecyclerViewAdapter", "Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryGridViewNavFragment$PlatformLibraryGridAdapter;", "platformString", "playableItemCharacterIndexingHashmap", "Ljava/util/SortedMap;", "", "playableItemEntityList", "", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "recentFormatString", "recentPlayedButton", "scrollingOnBackPressed", "selectedChip", "selectedLetterFormatString", "titleLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "titleTextView", "Landroid/widget/TextView;", "getMergePlayableItemsPreference", "hopToNextItemByFirstCharacter", "", TypedValues.CycleType.S_WAVE_OFFSET, "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHotKeyPressed", "hotkeyCode", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onResume", "onViewCreated", "view", "toggleViewMode", "Companion", "PlatformLibraryGridAdapter", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlatformLibraryGridViewNavFragment extends PlatformNavFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Typeface typeface;
    private Chip backupChip;
    private List<String> boxArtAspectRatioList;
    private ColorStateList chipColorStateList;
    public ChipGroup chipGroup;
    private String currentGenreId;
    private View dividerView;
    public LinearLayout emptyLayout;
    public Chip favoriteButton;
    public String favoriteFormatString;
    int filterMode;
    private boolean filterModeRequestFromOnPageSelected;
    private ChipGroup genresChipGroup;
    private DaijishouGridLayoutManager gridLayoutManager;
    private boolean hopToNextItemLock;
    public HorizontalScrollView horizontalScrollView;
    public Chip itemCountButton;
    public String itemCountFormatString;

    /* JADX INFO: renamed from: libraryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy libraryViewModel;
    public Chip listViewButton;

    /* JADX INFO: renamed from: model$delegate, reason: from kotlin metadata */
    private final Lazy model;
    public String newFormatString;
    public Chip newlyAddedButton;
    private PlatformEntity platformEntity;
    private String platformFormatString;
    public RecyclerView platformLibraryGridRecyclerView;
    public PlatformLibraryGridAdapter platformLibraryGridRecyclerViewAdapter;
    private String platformString;
    public String recentFormatString;
    public Chip recentPlayedButton;
    private boolean scrollingOnBackPressed;
    public Chip selectedChip;
    private String selectedLetterFormatString;
    private ConstraintLayout titleLayout;
    private TextView titleTextView;
    public long platformId = -1;
    public final List<PlayableItemEntity> playableItemEntityList = new ArrayList();
    private final SortedMap<Character, Integer> playableItemCharacterIndexingHashmap = MapsKt.sortedMapOf(new Pair[0]);
    public int lastVisibleChipIndex = -1;
    private final HashMap<String, Chip> genreIdToChipHashMap = new HashMap<>();
    private int colorPrimary = -1;
    private int colorOnPrimary = -1;
    public List<String> genreIds = CollectionsKt.emptyList();
    private long lastHopToNextItemTimeMillis = System.currentTimeMillis();
    private long lastToggleViewModeTimeMillis = System.currentTimeMillis();
    private long lastToggleGenreTimeMillis = System.currentTimeMillis();
    public boolean lockToggleViewMode = true;
    public String boxArtAspectRatio = Constants.defaultThumbnailDimensionRatio;

    public PlatformLibraryGridViewNavFragment() {
        PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment = this;
        this.libraryViewModel = FragmentViewModelLazyKt.createViewModelLazy(platformLibraryGridViewNavFragment, Reflection.getOrCreateKotlinClass(LibraryViewModel.class), new PlatformLibraryGridViewNavFragment$special$$inlined$activityViewModels$default$1(platformLibraryGridViewNavFragment), new PlatformLibraryGridViewNavFragment$special$$inlined$activityViewModels$default$2(null, platformLibraryGridViewNavFragment), new PlatformLibraryGridViewNavFragment$special$$inlined$activityViewModels$default$3(platformLibraryGridViewNavFragment));
        this.model = FragmentViewModelLazyKt.createViewModelLazy(platformLibraryGridViewNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new PlatformLibraryGridViewNavFragment$special$$inlined$activityViewModels$default$4(platformLibraryGridViewNavFragment), new PlatformLibraryGridViewNavFragment$special$$inlined$activityViewModels$default$5(null, platformLibraryGridViewNavFragment), new PlatformLibraryGridViewNavFragment$special$$inlined$activityViewModels$default$6(platformLibraryGridViewNavFragment));
    }

    /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryGridViewNavFragment$Companion;", "", "()V", "typeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "newInstance", "Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryGridViewNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlatformLibraryGridViewNavFragment newInstance() {
            return new PlatformLibraryGridViewNavFragment();
        }
    }

    static {
        typeface = Build.VERSION.SDK_INT >= 28 ? Typeface.create(null, Constants.semiBolderWeight, false) : Typeface.defaultFromStyle(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LibraryViewModel getLibraryViewModel() {
        return (LibraryViewModel) this.libraryViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model.getValue();
    }

    public final String getCurrentGenreId() {
        return this.currentGenreId;
    }

    public final void setCurrentGenreId(String str) {
        this.currentGenreId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getMergePlayableItemsPreference() {
        return getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue());
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onHotKeyPressed(int hotkeyCode, int keyCode, KeyEvent keyEvent) {
        int childCount;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(hotkeyCode, keyCode, keyEvent);
        ChipGroup chipGroup = null;
        PlatformLibraryGridAdapter platformLibraryGridAdapter = null;
        ChipGroup chipGroup2 = null;
        ChipGroup chipGroup3 = null;
        ChipGroup chipGroup4 = null;
        if (hotkeyCode == 1) {
            int i = this.filterMode;
            if (i == 0) {
                hopToNextItemByFirstCharacter(1);
            } else if (i == 4) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.lastToggleGenreTimeMillis < 45) {
                    return false;
                }
                this.lastToggleGenreTimeMillis = jCurrentTimeMillis;
                if (this.selectedChip == null) {
                    ChipGroup chipGroup5 = this.genresChipGroup;
                    if (chipGroup5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("genresChipGroup");
                        chipGroup5 = null;
                    }
                    if (chipGroup5.getChildCount() > 0) {
                        ChipGroup chipGroup6 = this.genresChipGroup;
                        if (chipGroup6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("genresChipGroup");
                        } else {
                            chipGroup4 = chipGroup6;
                        }
                        ((View) SequencesKt.elementAt(ViewGroupKt.getChildren(chipGroup4), 0)).performClick();
                    }
                } else {
                    ChipGroup chipGroup7 = this.genresChipGroup;
                    if (chipGroup7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("genresChipGroup");
                        chipGroup7 = null;
                    }
                    int iIndexOfChild = chipGroup7.indexOfChild(this.selectedChip) + 1;
                    ChipGroup chipGroup8 = this.genresChipGroup;
                    if (chipGroup8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("genresChipGroup");
                        chipGroup8 = null;
                    }
                    int childCount2 = iIndexOfChild % chipGroup8.getChildCount();
                    ChipGroup chipGroup9 = this.genresChipGroup;
                    if (chipGroup9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("genresChipGroup");
                    } else {
                        chipGroup = chipGroup9;
                    }
                    ((View) SequencesKt.elementAt(ViewGroupKt.getChildren(chipGroup), childCount2)).performClick();
                }
            }
            return true;
        }
        if (hotkeyCode != 2) {
            if (hotkeyCode == 3) {
                toggleViewMode();
                return true;
            }
            if (hotkeyCode != 4) {
                return false;
            }
            PlatformLibraryGridAdapter platformLibraryGridAdapter2 = this.platformLibraryGridRecyclerViewAdapter;
            if (platformLibraryGridAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerViewAdapter");
            } else {
                platformLibraryGridAdapter = platformLibraryGridAdapter2;
            }
            DaijishouRecyclerView.Adapter<PlayableItemEntity>.ViewHolder selectedViewHolder = platformLibraryGridAdapter.getSelectedViewHolder();
            if (selectedViewHolder != null && selectedViewHolder.itemView.isFocused() && selectedViewHolder.getAbsoluteAdapterPosition() >= 0) {
                selectedViewHolder.itemView.performLongClick();
            }
            return true;
        }
        int i2 = this.filterMode;
        if (i2 == 0) {
            hopToNextItemByFirstCharacter(-1);
        } else if (i2 == 4) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (jCurrentTimeMillis2 - this.lastToggleGenreTimeMillis < 45) {
                return false;
            }
            this.lastToggleGenreTimeMillis = jCurrentTimeMillis2;
            if (this.selectedChip == null) {
                ChipGroup chipGroup10 = this.genresChipGroup;
                if (chipGroup10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("genresChipGroup");
                    chipGroup10 = null;
                }
                if (chipGroup10.getChildCount() > 0) {
                    ChipGroup chipGroup11 = this.genresChipGroup;
                    if (chipGroup11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("genresChipGroup");
                    } else {
                        chipGroup2 = chipGroup11;
                    }
                    ((View) SequencesKt.elementAt(ViewGroupKt.getChildren(chipGroup2), 0)).performClick();
                }
            } else {
                ChipGroup chipGroup12 = this.genresChipGroup;
                if (chipGroup12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("genresChipGroup");
                    chipGroup12 = null;
                }
                int iIndexOfChild2 = chipGroup12.indexOfChild(this.selectedChip);
                if (iIndexOfChild2 == 0) {
                    ChipGroup chipGroup13 = this.genresChipGroup;
                    if (chipGroup13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("genresChipGroup");
                        chipGroup13 = null;
                    }
                    childCount = chipGroup13.getChildCount() - 1;
                } else {
                    int i3 = iIndexOfChild2 - 1;
                    ChipGroup chipGroup14 = this.genresChipGroup;
                    if (chipGroup14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("genresChipGroup");
                        chipGroup14 = null;
                    }
                    childCount = i3 % chipGroup14.getChildCount();
                }
                ChipGroup chipGroup15 = this.genresChipGroup;
                if (chipGroup15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("genresChipGroup");
                } else {
                    chipGroup3 = chipGroup15;
                }
                ((View) SequencesKt.elementAt(ViewGroupKt.getChildren(chipGroup3), childCount)).performClick();
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001f  */
    /* JADX WARN: Code duplicated, block: B:13:0x0023  */
    /* JADX WARN: Code duplicated, block: B:30:0x0067  */
    /* JADX WARN: Code duplicated, block: B:32:0x006b  */
    /* JADX WARN: Code duplicated, block: B:33:0x006f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0074  */
    /* JADX WARN: Code duplicated, block: B:38:0x007a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0081  */
    /* JADX WARN: Code duplicated, block: B:44:0x008f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0093  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b1  */
    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onBackPressed() {
        RecyclerView recyclerView;
        Chip chip;
        DaijishouGridLayoutManager daijishouGridLayoutManager;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        Chip chip2;
        super.onBackPressed();
        HorizontalScrollView horizontalScrollView = null;
        Chip chip3 = null;
        Chip chip4 = null;
        RecyclerView recyclerView5 = null;
        RecyclerView recyclerView6 = null;
        if (this.filterMode != 0) {
            if (this.scrollingOnBackPressed) {
                RecyclerView recyclerView7 = this.platformLibraryGridRecyclerView;
                if (recyclerView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
                    recyclerView7 = null;
                }
                if (recyclerView7.getScrollState() != 2) {
                    recyclerView = this.platformLibraryGridRecyclerView;
                    if (recyclerView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
                        recyclerView = null;
                    }
                    if (recyclerView.computeVerticalScrollOffset() != 0) {
                        this.scrollingOnBackPressed = true;
                        chip = this.selectedChip;
                        if (chip != null) {
                            chip.requestFocus();
                        }
                        daijishouGridLayoutManager = this.gridLayoutManager;
                        if (daijishouGridLayoutManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
                            daijishouGridLayoutManager = null;
                        }
                        if (daijishouGridLayoutManager.findFirstVisibleItemPosition() > 256) {
                            recyclerView3 = this.platformLibraryGridRecyclerView;
                            if (recyclerView3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
                                recyclerView3 = null;
                            }
                            recyclerView3.scrollToPosition(128);
                            recyclerView4 = this.platformLibraryGridRecyclerView;
                            if (recyclerView4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
                            } else {
                                recyclerView5 = recyclerView4;
                            }
                            recyclerView5.smoothScrollToPosition(0);
                        } else {
                            recyclerView2 = this.platformLibraryGridRecyclerView;
                            if (recyclerView2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
                            } else {
                                recyclerView6 = recyclerView2;
                            }
                            recyclerView6.smoothScrollToPosition(0);
                        }
                        return false;
                    }
                }
            } else {
                recyclerView = this.platformLibraryGridRecyclerView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
                    recyclerView = null;
                }
                if (recyclerView.computeVerticalScrollOffset() != 0) {
                    this.scrollingOnBackPressed = true;
                    chip = this.selectedChip;
                    if (chip != null) {
                        chip.requestFocus();
                    }
                    daijishouGridLayoutManager = this.gridLayoutManager;
                    if (daijishouGridLayoutManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
                        daijishouGridLayoutManager = null;
                    }
                    if (daijishouGridLayoutManager.findFirstVisibleItemPosition() > 256) {
                        recyclerView3 = this.platformLibraryGridRecyclerView;
                        if (recyclerView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
                            recyclerView3 = null;
                        }
                        recyclerView3.scrollToPosition(128);
                        recyclerView4 = this.platformLibraryGridRecyclerView;
                        if (recyclerView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
                        } else {
                            recyclerView5 = recyclerView4;
                        }
                        recyclerView5.smoothScrollToPosition(0);
                    } else {
                        recyclerView2 = this.platformLibraryGridRecyclerView;
                        if (recyclerView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
                        } else {
                            recyclerView6 = recyclerView2;
                        }
                        recyclerView6.smoothScrollToPosition(0);
                    }
                    return false;
                }
            }
            RecyclerView recyclerView8 = this.platformLibraryGridRecyclerView;
            if (recyclerView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
                recyclerView8 = null;
            }
            recyclerView8.scrollToPosition(0);
            Chip chip5 = this.selectedChip;
            if (chip5 != null) {
                Intrinsics.checkNotNull(chip5);
                if (!chip5.isFocused()) {
                    Chip chip6 = this.selectedChip;
                    Intrinsics.checkNotNull(chip6);
                    chip6.requestFocus();
                    Chip chip7 = this.selectedChip;
                    Intrinsics.checkNotNull(chip7);
                    if (!chip7.isFocused()) {
                        Chip chip8 = this.itemCountButton;
                        if (chip8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("itemCountButton");
                        } else {
                            chip3 = chip8;
                        }
                        chip3.performClick();
                    }
                } else {
                    chip2 = this.itemCountButton;
                    if (chip2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("itemCountButton");
                    } else {
                        chip4 = chip2;
                    }
                    chip4.performClick();
                }
            } else {
                chip2 = this.itemCountButton;
                if (chip2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemCountButton");
                } else {
                    chip4 = chip2;
                }
                chip4.performClick();
            }
            return false;
        }
        ConstraintLayout constraintLayout = this.titleLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout = null;
        }
        if (constraintLayout.isFocused()) {
            return true;
        }
        HorizontalScrollView horizontalScrollView2 = this.horizontalScrollView;
        if (horizontalScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
        } else {
            horizontalScrollView = horizontalScrollView2;
        }
        horizontalScrollView.smoothScrollTo(0, 0);
        constraintLayout.requestFocus();
        return !constraintLayout.isFocused();
    }

    private final void hopToNextItemByFirstCharacter(int offset) {
        if (this.playableItemEntityList.isEmpty() || this.playableItemCharacterIndexingHashmap.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.hopToNextItemLock || jCurrentTimeMillis - this.lastHopToNextItemTimeMillis < 45) {
            return;
        }
        this.lastHopToNextItemTimeMillis = jCurrentTimeMillis;
        this.hopToNextItemLock = true;
        List<PlayableItemEntity> list = this.playableItemEntityList;
        PlatformLibraryGridAdapter platformLibraryGridAdapter = this.platformLibraryGridRecyclerViewAdapter;
        RecyclerView recyclerView = null;
        if (platformLibraryGridAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerViewAdapter");
            platformLibraryGridAdapter = null;
        }
        String upperCase = list.get(platformLibraryGridAdapter.get_selectedPosition()).getName().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        char cCharAt = upperCase.charAt(0);
        Set<Character> setKeySet = this.playableItemCharacterIndexingHashmap.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        List list2 = CollectionsKt.toList(setKeySet);
        int iIndexOf = list2.indexOf(Character.valueOf(cCharAt)) + offset;
        int size = list2.size();
        int i = iIndexOf % size;
        Integer num = this.playableItemCharacterIndexingHashmap.get((Character) list2.get(i + (size & (((i ^ size) & ((-i) | i)) >> 31))));
        int iIntValue = num != null ? num.intValue() : 0;
        PlatformLibraryGridAdapter platformLibraryGridAdapter2 = this.platformLibraryGridRecyclerViewAdapter;
        if (platformLibraryGridAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerViewAdapter");
            platformLibraryGridAdapter2 = null;
        }
        platformLibraryGridAdapter2.selectPosition(iIntValue);
        PlatformLibraryGridAdapter platformLibraryGridAdapter3 = this.platformLibraryGridRecyclerViewAdapter;
        if (platformLibraryGridAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerViewAdapter");
            platformLibraryGridAdapter3 = null;
        }
        platformLibraryGridAdapter3.notifyItemChanged(iIntValue);
        RecyclerView recyclerView2 = this.platformLibraryGridRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.scrollToPosition(Math.max(0, iIntValue));
        this.hopToNextItemLock = false;
    }

    private final void toggleViewMode() {
        if (this.lockToggleViewMode) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastToggleViewModeTimeMillis < 360) {
            return;
        }
        this.lastToggleViewModeTimeMillis = jCurrentTimeMillis;
        getLibraryViewModel().getPreferences().edit().putInt("view_mode", 0).apply();
        NavController navControllerFindNavController = FragmentKt.findNavController(this);
        NavDestination currentDestination = navControllerFindNavController.getCurrentDestination();
        if (currentDestination == null || currentDestination.getId() != R.id.platformLibraryGridViewNavFragment) {
            return;
        }
        navControllerFindNavController.navigate(R.id.platformLibraryGridToPlatformLibraryListAction);
    }

    /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0012\u001a\n0\u0013R\u00060\u0000R\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryGridViewNavFragment$PlatformLibraryGridAdapter;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "playableItemEntityList", "", "(Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryGridViewNavFragment;Ljava/util/List;)V", "cachedBitmapLoader", "Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;", "getCachedBitmapLoader", "()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;", "dimensionRatio", "", "getDimensionRatio", "()Ljava/lang/String;", "setDimensionRatio", "(Ljava/lang/String;)V", "textColorsBackup", "Landroid/content/res/ColorStateList;", "onCreateViewHolder", "Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryGridViewNavFragment$PlatformLibraryGridAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryGridViewNavFragment;", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class PlatformLibraryGridAdapter extends DaijishouRecyclerView.Adapter<PlayableItemEntity> {
        private final CachedBitmapLoader cachedBitmapLoader;
        private String dimensionRatio;
        private ColorStateList textColorsBackup;
        final /* synthetic */ PlatformLibraryGridViewNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlatformLibraryGridAdapter(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, List<PlayableItemEntity> playableItemEntityList) {
            super(playableItemEntityList, true, false, 4, null);
            Intrinsics.checkNotNullParameter(playableItemEntityList, "playableItemEntityList");
            this.this$0 = platformLibraryGridViewNavFragment;
            setEnforceSelectionInSelectableMode(false);
            this.dimensionRatio = Constants.defaultThumbnailDimensionRatio;
            this.cachedBitmapLoader = platformLibraryGridViewNavFragment.getDaijishouLibrary().getCachedBoxArtBitmapLoader();
        }

        public final String getDimensionRatio() {
            return this.dimensionRatio;
        }

        public final void setDimensionRatio(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.dimensionRatio = str;
        }

        public final CachedBitmapLoader getCachedBitmapLoader() {
            return this.cachedBitmapLoader;
        }

        /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0016H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryGridViewNavFragment$PlatformLibraryGridAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryGridViewNavFragment$PlatformLibraryGridAdapter;Landroid/view/View;)V", "backgroundSet", "Landroidx/constraintlayout/widget/ConstraintLayout;", "currentItem", "imageView", "Landroid/widget/ImageView;", "placeholder", "platformTextView", "Landroid/widget/TextView;", "textView", "onBind", "", "position", "", "item", "onClick", "", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<PlayableItemEntity>.ViewHolder {
            private ConstraintLayout backgroundSet;
            public PlayableItemEntity currentItem;
            public ImageView imageView;
            public ImageView placeholder;
            public TextView platformTextView;
            private TextView textView;
            final /* synthetic */ PlatformLibraryGridAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(PlatformLibraryGridAdapter platformLibraryGridAdapter, View itemView) {
                super(platformLibraryGridAdapter, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = platformLibraryGridAdapter;
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
                String strPrettifyTitleWithPreferences;
                Intrinsics.checkNotNullParameter(item, "item");
                this.currentItem = item;
                String shortname = null;
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
                if (!this.this$0.this$0.getDefaultSharedPreferences().getBoolean(BooleanPreference.HIDE_GAME_TITLES.getKey(), BooleanPreference.HIDE_GAME_TITLES.getDefaultValue())) {
                    TextView textView = this.textView;
                    if (!this.this$0.this$0.getMergePlayableItemsPreference()) {
                        strPrettifyTitleWithPreferences = this.this$0.this$0.getDaijishouLibrary().prettifyTitleWithPreferences(item.getName());
                    } else {
                        strPrettifyTitleWithPreferences = this.this$0.this$0.getDaijishouLibrary().prettifyTitleWithPreferences(item.getMergedInfo().getMergedName());
                    }
                    textView.setText(strPrettifyTitleWithPreferences);
                } else {
                    this.textView.setVisibility(8);
                }
                if (this.this$0.this$0.getDefaultSharedPreferences().getBoolean(BooleanPreference.SQUARE_PLAYABLE_ITEM_ART.getKey(), BooleanPreference.SQUARE_PLAYABLE_ITEM_ART.getDefaultValue())) {
                    ImageView imageView = this.imageView;
                    Intrinsics.checkNotNull(imageView, "null cannot be cast to non-null type com.google.android.material.imageview.ShapeableImageView");
                    ShapeableImageView shapeableImageView = (ShapeableImageView) imageView;
                    shapeableImageView.setShapeAppearanceModel(shapeableImageView.getShapeAppearanceModel().toBuilder().setAllCornerSizes(0.0f).build());
                }
                TextView textView2 = this.platformTextView;
                if (this.this$0.this$0.platformEntity == null) {
                    String str = this.this$0.this$0.platformString;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("platformString");
                    } else {
                        shortname = str;
                    }
                } else {
                    PlatformEntity platformEntity = this.this$0.this$0.platformEntity;
                    Intrinsics.checkNotNull(platformEntity);
                    shortname = platformEntity.getShortname();
                }
                textView2.setText(shortname);
                ViewGroup.LayoutParams layoutParams = this.backgroundSet.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                if (!Intrinsics.areEqual(layoutParams2.dimensionRatio, this.this$0.getDimensionRatio())) {
                    layoutParams2.dimensionRatio = this.this$0.getDimensionRatio();
                    this.backgroundSet.requestLayout();
                }
                String boxArtPath = Utils.INSTANCE.getBoxArtPath(item);
                if (boxArtPath != null) {
                    this.this$0.getCachedBitmapLoader().with(this.this$0.this$0).load(boxArtPath).setOnFailedListener(new PlatformLibraryGridViewNavFragment$PlatformLibraryGridAdapter$ViewHolder$onBind$1(this, item)).setOnSucceedListener(new PlatformLibraryGridViewNavFragment$PlatformLibraryGridAdapter$ViewHolder$onBind$2(this)).into(this.imageView);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item_playable_item_thumbnail, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        TypedValue typedValue = new TypedValue();
        String string = getString(R.string.platform);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.platformString = string;
        String string2 = getString(R.string.platform_format);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.platformFormatString = string2;
        String string3 = getString(R.string.items_count_format);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.itemCountFormatString = string3;
        String string4 = getString(R.string.favorite_format);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        this.favoriteFormatString = string4;
        String string5 = getString(R.string.recent_format);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        this.recentFormatString = string5;
        String string6 = getString(R.string.new_format);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        this.newFormatString = string6;
        String string7 = getString(R.string.selected_letter_formant);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        this.selectedLetterFormatString = string7;
        this.platformId = getLibraryViewModel().getSelectedPlatformId();
        String[] stringArray = getResources().getStringArray(R.array.box_art_aspect_ratio_array);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        this.boxArtAspectRatioList = ArraysKt.toList(stringArray);
        Resources.Theme theme = contextRequireContext.getTheme();
        Intrinsics.checkNotNullExpressionValue(theme, "getTheme(...)");
        theme.resolveAttribute(R.attr.colorPrimary, typedValue, true);
        this.colorPrimary = typedValue.data;
        theme.resolveAttribute(R.attr.colorOnPrimary, typedValue, true);
        this.colorOnPrimary = typedValue.data;
        this.chipColorStateList = new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{this.colorPrimary});
        this.backupChip = new Chip(contextRequireContext);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String name;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        SharedPreferences preferences = getLibraryViewModel().getPreferences();
        View viewInflate = inflater.inflate(R.layout.fragment_platform_library_grid_view, container, false);
        Bundle arguments = getArguments();
        TextView textView = null;
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt("filterMode")) : null;
        Bundle arguments2 = getArguments();
        this.filterModeRequestFromOnPageSelected = arguments2 != null ? arguments2.getBoolean("fromOnPageSelected") : false;
        if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{0, 2, 1, 3}), numValueOf)) {
            Intrinsics.checkNotNull(numValueOf);
            this.filterMode = numValueOf.intValue();
        }
        View viewFindViewById = viewInflate.findViewById(R.id.platform_library_grid_title_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.titleLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.platform_library_grid_title_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.titleTextView = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.platform_library_grid_horizontal_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.horizontalScrollView = (HorizontalScrollView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.platform_library_grid_empty_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.emptyLayout = (LinearLayout) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.platform_library_grid_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.platformLibraryGridRecyclerView = (RecyclerView) viewFindViewById5;
        this.platformLibraryGridRecyclerViewAdapter = new PlatformLibraryGridAdapter(this, this.playableItemEntityList);
        this.gridLayoutManager = new DaijishouGridLayoutManager(contextRequireContext, 120.0f, 8, 16.0f, false, 16, null);
        View viewFindViewById6 = viewInflate.findViewById(R.id.platform_library_grid_chip_group);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.chipGroup = (ChipGroup) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.platform_library_grid_divider);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.dividerView = viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(R.id.platform_library_grid_genres_chip_group);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.genresChipGroup = (ChipGroup) viewFindViewById8;
        View viewFindViewById9 = viewInflate.findViewById(R.id.platform_library_list_view_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.listViewButton = (Chip) viewFindViewById9;
        View viewFindViewById10 = viewInflate.findViewById(R.id.platform_library_grid_items_count_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.itemCountButton = (Chip) viewFindViewById10;
        View viewFindViewById11 = viewInflate.findViewById(R.id.platform_library_grid_recent_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.recentPlayedButton = (Chip) viewFindViewById11;
        View viewFindViewById12 = viewInflate.findViewById(R.id.platform_library_grid_favorite_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.favoriteButton = (Chip) viewFindViewById12;
        View viewFindViewById13 = viewInflate.findViewById(R.id.platform_library_grid_newly_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.newlyAddedButton = (Chip) viewFindViewById13;
        this.playableItemEntityList.clear();
        RecyclerView recyclerView = this.platformLibraryGridRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
            recyclerView = null;
        }
        DaijishouGridLayoutManager daijishouGridLayoutManager = this.gridLayoutManager;
        if (daijishouGridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
            daijishouGridLayoutManager = null;
        }
        recyclerView.setLayoutManager(daijishouGridLayoutManager);
        RecyclerView recyclerView2 = this.platformLibraryGridRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
            recyclerView2 = null;
        }
        PlatformLibraryGridAdapter platformLibraryGridAdapter = this.platformLibraryGridRecyclerViewAdapter;
        if (platformLibraryGridAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerViewAdapter");
            platformLibraryGridAdapter = null;
        }
        recyclerView2.setAdapter(platformLibraryGridAdapter);
        RecyclerView recyclerView3 = this.platformLibraryGridRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setItemAnimator(null);
        Chip chip = this.listViewButton;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listViewButton");
            chip = null;
        }
        chip.setTypeface(typeface);
        Chip chip2 = this.itemCountButton;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemCountButton");
            chip2 = null;
        }
        chip2.setTypeface(null, 1);
        Chip chip3 = this.recentPlayedButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip3 = null;
        }
        chip3.setTypeface(null, 1);
        Chip chip4 = this.favoriteButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip4 = null;
        }
        chip4.setTypeface(null, 1);
        Chip chip5 = this.newlyAddedButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip5 = null;
        }
        chip5.setTypeface(null, 1);
        ConstraintLayout constraintLayout = this.titleLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout = null;
        }
        constraintLayout.setOnClickListener(new PlatformLibraryGridViewNavFragment$$ExternalSyntheticLambda0(this, fragmentActivityRequireActivity));
        Chip chip6 = this.listViewButton;
        if (chip6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listViewButton");
            chip6 = null;
        }
        chip6.setOnClickListener(new PlatformLibraryGridViewNavFragment$$ExternalSyntheticLambda1(this));
        PlatformLibraryGridAdapter platformLibraryGridAdapter2 = this.platformLibraryGridRecyclerViewAdapter;
        if (platformLibraryGridAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerViewAdapter");
            platformLibraryGridAdapter2 = null;
        }
        platformLibraryGridAdapter2.setOnItemSelectListener(new AnonymousClass3(preferences));
        PlatformLibraryGridAdapter platformLibraryGridAdapter3 = this.platformLibraryGridRecyclerViewAdapter;
        if (platformLibraryGridAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerViewAdapter");
            platformLibraryGridAdapter3 = null;
        }
        platformLibraryGridAdapter3.setOnItemClickListener(new AnonymousClass4(fragmentActivityRequireActivity));
        PlatformLibraryGridAdapter platformLibraryGridAdapter4 = this.platformLibraryGridRecyclerViewAdapter;
        if (platformLibraryGridAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerViewAdapter");
            platformLibraryGridAdapter4 = null;
        }
        platformLibraryGridAdapter4.setOnItemLongClickListener(new AnonymousClass5());
        RecyclerView recyclerView4 = this.platformLibraryGridRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
            recyclerView4 = null;
        }
        recyclerView4.addOnScrollListener(new AnonymousClass6());
        onCreateView$refreshCountingButtons(this);
        getLibraryViewModel().getPreferences();
        Chip chip7 = this.itemCountButton;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemCountButton");
            chip7 = null;
        }
        chip7.setOnClickListener(new PlatformLibraryGridViewNavFragment$$ExternalSyntheticLambda2(this, preferences));
        Chip chip8 = this.recentPlayedButton;
        if (chip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip8 = null;
        }
        chip8.setOnClickListener(new PlatformLibraryGridViewNavFragment$$ExternalSyntheticLambda3(this, preferences));
        Chip chip9 = this.favoriteButton;
        if (chip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip9 = null;
        }
        chip9.setOnClickListener(new PlatformLibraryGridViewNavFragment$$ExternalSyntheticLambda4(this, preferences));
        Chip chip10 = this.newlyAddedButton;
        if (chip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip10 = null;
        }
        chip10.setOnClickListener(new PlatformLibraryGridViewNavFragment$$ExternalSyntheticLambda5(this, preferences));
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = getMergePlayableItemsPreference();
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue()).observe(getViewLifecycleOwner(), new PlatformLibraryGridViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass11(booleanRef, this, preferences)));
        getLibraryViewModel().getAllPlayableItems().observe(getViewLifecycleOwner(), new PlatformLibraryGridViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass12(preferences)));
        PlatformEntity platformByIdStatically = getDaijishouLibrary().getPlatformByIdStatically(this.platformId);
        if (platformByIdStatically != null) {
            this.platformEntity = platformByIdStatically;
            TextView textView2 = this.titleTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            } else {
                textView = textView2;
            }
            if (platformByIdStatically.getName().length() > 20) {
                String shortname = platformByIdStatically.getShortname();
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                name = shortname.toUpperCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(name, "toUpperCase(...)");
            } else {
                name = platformByIdStatically.getName();
            }
            textView.setText(name);
        }
        getDaijishouLibrary().getPlatformById(this.platformId).observe(getViewLifecycleOwner(), new PlatformLibraryGridViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass14()));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.SHOW_GENRES_IN_PLATFORM_GRID_VIEW.getKey(), BooleanPreference.SHOW_GENRES_IN_PLATFORM_GRID_VIEW.getDefaultValue()).observe(getViewLifecycleOwner(), new PlatformLibraryGridViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass15()));
        DaijishouLibraryModel.getGenreIdsByPlatformIdAndVisibility$default(getDaijishouLibrary(), this.platformId, false, 2, null).observe(getViewLifecycleOwner(), new PlatformLibraryGridViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass16(contextRequireContext, preferences)));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2(PlatformLibraryGridViewNavFragment this$0, FragmentActivity activity, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        RecyclerView recyclerView = this$0.platformLibraryGridRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
            recyclerView = null;
        }
        if (recyclerView.computeVerticalScrollOffset() == 0) {
            ((MainActivity) activity).onBackPressedCallback();
            return;
        }
        if (this$0.filterMode != 4) {
            HorizontalScrollView horizontalScrollView = this$0.horizontalScrollView;
            if (horizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
                horizontalScrollView = null;
            }
            horizontalScrollView.smoothScrollTo(0, 0);
        }
        ConstraintLayout constraintLayout = this$0.titleLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout = null;
        }
        constraintLayout.requestFocus();
        DaijishouGridLayoutManager daijishouGridLayoutManager = this$0.gridLayoutManager;
        if (daijishouGridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
            daijishouGridLayoutManager = null;
        }
        if (daijishouGridLayoutManager.findFirstVisibleItemPosition() > 256) {
            RecyclerView recyclerView3 = this$0.platformLibraryGridRecyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
                recyclerView3 = null;
            }
            recyclerView3.scrollToPosition(128);
            RecyclerView recyclerView4 = this$0.platformLibraryGridRecyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
            } else {
                recyclerView2 = recyclerView4;
            }
            recyclerView2.smoothScrollToPosition(0);
            return;
        }
        RecyclerView recyclerView5 = this$0.platformLibraryGridRecyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
        } else {
            recyclerView2 = recyclerView5;
        }
        recyclerView2.smoothScrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3(PlatformLibraryGridViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.toggleViewMode();
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$3, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "position", "", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass3 extends Lambda<Unit> implements Function4<View, Integer, Long, PlayableItemEntity, Unit> {
        final /* synthetic */ SharedPreferences $platformLibrarySharedPreferences;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(SharedPreferences sharedPreferences) {
            super(4);
            this.$platformLibrarySharedPreferences = sharedPreferences;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity) {
            invoke(view, num.intValue(), l.longValue(), playableItemEntity);
            return Unit.INSTANCE;
        }

        public final void invoke(View view, int i, long j, PlayableItemEntity playableItemEntity) {
            Intrinsics.checkNotNullParameter(playableItemEntity, "<anonymous parameter 3>");
            if (PlatformLibraryGridViewNavFragment.this.filterMode == 0) {
                this.$platformLibrarySharedPreferences.edit().putInt(PlatformLibraryGridViewNavFragment.this.platformId + "_selected_position", i).apply();
            }
            PlatformLibraryGridViewNavFragment.this.getModel().setTipsForPlayableItem((PlayableItemEntity) PlatformLibraryGridViewNavFragment.this.playableItemEntityList.get(i));
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$4, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass4 extends Lambda<Unit> implements Function4<View, Integer, Long, PlayableItemEntity, Unit> {
        final /* synthetic */ FragmentActivity $activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(FragmentActivity fragmentActivity) {
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
            DaijishouLibraryModel.play$default(PlatformLibraryGridViewNavFragment.this.getDaijishouLibrary(), this.$activity, playableItemEntity, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$5, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke", "(Landroid/view/View;IJLcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass5 extends Lambda<Boolean> implements Function4<View, Integer, Long, PlayableItemEntity, Boolean> {
        AnonymousClass5() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Boolean invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity) {
            return invoke(view, num.intValue(), l.longValue(), playableItemEntity);
        }

        public final Boolean invoke(View view, int i, long j, PlayableItemEntity playableItemEntity) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
            PlayableItemDetailDialogFragment.INSTANCE.newInstance(playableItemEntity).show(PlatformLibraryGridViewNavFragment.this.getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
            return true;
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$6, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/nav_fragments/PlatformLibraryGridViewNavFragment$onCreateView$6", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass6 extends RecyclerView.OnScrollListener {
        AnonymousClass6() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                PlatformLibraryGridViewNavFragment.this.scrollingOnBackPressed = false;
            }
            super.onScrollStateChanged(recyclerView, newState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$refreshCountingButtons(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(platformLibraryGridViewNavFragment), Dispatchers.getIO(), null, new PlatformLibraryGridViewNavFragment$onCreateView$refreshCountingButtons$1(platformLibraryGridViewNavFragment, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$updateEntireList(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, SharedPreferences sharedPreferences, List<PlayableItemEntity> list) {
        platformLibraryGridViewNavFragment.playableItemEntityList.clear();
        platformLibraryGridViewNavFragment.playableItemEntityList.addAll(list);
        int iMin = platformLibraryGridViewNavFragment.filterMode == 0 ? Math.min(list.size() - 1, sharedPreferences.getInt(platformLibraryGridViewNavFragment.platformId + "_selected_position", 0)) : 0;
        RecyclerView recyclerView = platformLibraryGridViewNavFragment.platformLibraryGridRecyclerView;
        DaijishouGridLayoutManager daijishouGridLayoutManager = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
            recyclerView = null;
        }
        recyclerView.clearFocus();
        PlatformLibraryGridAdapter platformLibraryGridAdapter = platformLibraryGridViewNavFragment.platformLibraryGridRecyclerViewAdapter;
        if (platformLibraryGridAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerViewAdapter");
            platformLibraryGridAdapter = null;
        }
        platformLibraryGridAdapter.notifyDataSetChanged();
        if (platformLibraryGridViewNavFragment.filterMode != 0) {
            if (platformLibraryGridViewNavFragment.filterModeRequestFromOnPageSelected) {
                platformLibraryGridViewNavFragment.filterModeRequestFromOnPageSelected = false;
                Chip chip = platformLibraryGridViewNavFragment.selectedChip;
                if (chip != null) {
                    chip.requestFocus();
                }
            } else {
                PlatformLibraryGridAdapter platformLibraryGridAdapter2 = platformLibraryGridViewNavFragment.platformLibraryGridRecyclerViewAdapter;
                if (platformLibraryGridAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerViewAdapter");
                    platformLibraryGridAdapter2 = null;
                }
                platformLibraryGridAdapter2.selectPosition(-1);
            }
        } else {
            int i = 0;
            Character chValueOf = null;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                PlayableItemEntity playableItemEntity = (PlayableItemEntity) obj;
                String name = (playableItemEntity.getDisjointSetPrimaryPlayableItemId() == null || !platformLibraryGridViewNavFragment.getMergePlayableItemsPreference()) ? playableItemEntity.getName() : playableItemEntity.getMergedInfo().getMergedName();
                if (name.length() != 0) {
                    String upperCase = name.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    char cCharAt = upperCase.charAt(0);
                    if (chValueOf == null || chValueOf.charValue() != cCharAt) {
                        chValueOf = Character.valueOf(cCharAt);
                        platformLibraryGridViewNavFragment.playableItemCharacterIndexingHashmap.put(Character.valueOf(cCharAt), Integer.valueOf(i));
                    }
                }
                i = i2;
            }
            PlatformLibraryGridAdapter platformLibraryGridAdapter3 = platformLibraryGridViewNavFragment.platformLibraryGridRecyclerViewAdapter;
            if (platformLibraryGridAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerViewAdapter");
                platformLibraryGridAdapter3 = null;
            }
            platformLibraryGridAdapter3.selectPosition(iMin);
            PlatformLibraryGridAdapter platformLibraryGridAdapter4 = platformLibraryGridViewNavFragment.platformLibraryGridRecyclerViewAdapter;
            if (platformLibraryGridAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerViewAdapter");
                platformLibraryGridAdapter4 = null;
            }
            platformLibraryGridAdapter4.notifyItemChanged(iMin);
        }
        DaijishouGridLayoutManager daijishouGridLayoutManager2 = platformLibraryGridViewNavFragment.gridLayoutManager;
        if (daijishouGridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        } else {
            daijishouGridLayoutManager = daijishouGridLayoutManager2;
        }
        daijishouGridLayoutManager.scrollToPositionWithOffset(Math.max(0, iMin), platformLibraryGridViewNavFragment.getDpToPxConverter().convert(2.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$refreshPlayableItems(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, SharedPreferences sharedPreferences, List<PlayableItemEntity> list) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(platformLibraryGridViewNavFragment), Dispatchers.getIO(), null, new PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1(platformLibraryGridViewNavFragment, list, sharedPreferences, null), 2, null);
    }

    private static final void onCreateView$clearSelectedChip(PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment) {
        Chip chip = platformLibraryGridViewNavFragment.selectedChip;
        if (chip != null) {
            Chip chip2 = platformLibraryGridViewNavFragment.backupChip;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backupChip");
                chip2 = null;
            }
            chip.setChipBackgroundColor(chip2.getChipBackgroundColor());
            Chip chip3 = platformLibraryGridViewNavFragment.backupChip;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backupChip");
                chip3 = null;
            }
            chip.setTextColor(chip3.getTextColors());
        }
        RecyclerView recyclerView = platformLibraryGridViewNavFragment.platformLibraryGridRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
            recyclerView = null;
        }
        ConstraintLayout constraintLayout = platformLibraryGridViewNavFragment.titleLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout = null;
        }
        recyclerView.setNextFocusUpId(constraintLayout.getId());
        platformLibraryGridViewNavFragment.selectedChip = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6(PlatformLibraryGridViewNavFragment this$0, SharedPreferences platformLibrarySharedPreferences, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(platformLibrarySharedPreferences, "$platformLibrarySharedPreferences");
        if (this$0.filterMode == 0) {
            return;
        }
        onCreateView$clearSelectedChip(this$0);
        Chip chip = this$0.itemCountButton;
        HorizontalScrollView horizontalScrollView = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemCountButton");
            chip = null;
        }
        this$0.selectedChip = chip;
        this$0.getLibraryViewModel().getPreferences().edit().putInt("view_mode", 1).apply();
        this$0.filterMode = 0;
        onCreateView$refreshPlayableItems(this$0, platformLibrarySharedPreferences, this$0.getLibraryViewModel().getAllPlayableItemsStatically());
        HorizontalScrollView horizontalScrollView2 = this$0.horizontalScrollView;
        if (horizontalScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
        } else {
            horizontalScrollView = horizontalScrollView2;
        }
        horizontalScrollView.smoothScrollTo(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7(PlatformLibraryGridViewNavFragment this$0, SharedPreferences platformLibrarySharedPreferences, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(platformLibrarySharedPreferences, "$platformLibrarySharedPreferences");
        if (this$0.filterMode == 2) {
            return;
        }
        onCreateView$clearSelectedChip(this$0);
        Chip chip = this$0.recentPlayedButton;
        Chip chip2 = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip = null;
        }
        this$0.selectedChip = chip;
        RecyclerView recyclerView = this$0.platformLibraryGridRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
            recyclerView = null;
        }
        Chip chip3 = this$0.recentPlayedButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
        } else {
            chip2 = chip3;
        }
        recyclerView.setNextFocusUpId(chip2.getId());
        this$0.filterMode = 2;
        onCreateView$refreshPlayableItems(this$0, platformLibrarySharedPreferences, this$0.getLibraryViewModel().getAllPlayableItemsStatically());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$8(PlatformLibraryGridViewNavFragment this$0, SharedPreferences platformLibrarySharedPreferences, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(platformLibrarySharedPreferences, "$platformLibrarySharedPreferences");
        if (this$0.filterMode == 1) {
            return;
        }
        onCreateView$clearSelectedChip(this$0);
        Chip chip = this$0.favoriteButton;
        Chip chip2 = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip = null;
        }
        this$0.selectedChip = chip;
        RecyclerView recyclerView = this$0.platformLibraryGridRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
            recyclerView = null;
        }
        Chip chip3 = this$0.favoriteButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
        } else {
            chip2 = chip3;
        }
        recyclerView.setNextFocusUpId(chip2.getId());
        this$0.filterMode = 1;
        onCreateView$refreshPlayableItems(this$0, platformLibrarySharedPreferences, this$0.getLibraryViewModel().getAllPlayableItemsStatically());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$9(PlatformLibraryGridViewNavFragment this$0, SharedPreferences platformLibrarySharedPreferences, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(platformLibrarySharedPreferences, "$platformLibrarySharedPreferences");
        if (this$0.filterMode == 3) {
            return;
        }
        onCreateView$clearSelectedChip(this$0);
        Chip chip = this$0.newlyAddedButton;
        Chip chip2 = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip = null;
        }
        this$0.selectedChip = chip;
        RecyclerView recyclerView = this$0.platformLibraryGridRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
            recyclerView = null;
        }
        Chip chip3 = this$0.newlyAddedButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
        } else {
            chip2 = chip3;
        }
        recyclerView.setNextFocusUpId(chip2.getId());
        this$0.filterMode = 3;
        onCreateView$refreshPlayableItems(this$0, platformLibrarySharedPreferences, this$0.getLibraryViewModel().getAllPlayableItemsStatically());
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$11, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass11 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ Ref.BooleanRef $oldPref;
        final /* synthetic */ SharedPreferences $platformLibrarySharedPreferences;
        final /* synthetic */ PlatformLibraryGridViewNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass11(Ref.BooleanRef booleanRef, PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment, SharedPreferences sharedPreferences) {
            super(1);
            this.$oldPref = booleanRef;
            this.this$0 = platformLibraryGridViewNavFragment;
            this.$platformLibrarySharedPreferences = sharedPreferences;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            if (Intrinsics.areEqual(Boolean.valueOf(this.$oldPref.element), bool)) {
                return;
            }
            Ref.BooleanRef booleanRef = this.$oldPref;
            Intrinsics.checkNotNull(bool);
            booleanRef.element = bool.booleanValue();
            if (this.this$0.filterMode != 4) {
                PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment = this.this$0;
                PlatformLibraryGridViewNavFragment.onCreateView$refreshPlayableItems(platformLibraryGridViewNavFragment, this.$platformLibrarySharedPreferences, platformLibraryGridViewNavFragment.getLibraryViewModel().getAllPlayableItemsStatically());
                return;
            }
            PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment2 = this.this$0;
            SharedPreferences sharedPreferences = this.$platformLibrarySharedPreferences;
            DaijishouLibraryModel daijishouLibrary = platformLibraryGridViewNavFragment2.getDaijishouLibrary();
            long j = this.this$0.platformId;
            String currentGenreId = this.this$0.getCurrentGenreId();
            Intrinsics.checkNotNull(currentGenreId);
            PlatformLibraryGridViewNavFragment.onCreateView$refreshPlayableItems(platformLibraryGridViewNavFragment2, sharedPreferences, DaijishouLibraryModel.getPlayableItemIdsByPlatformIdGenreIdAndVisibilityStatically$default(daijishouLibrary, j, currentGenreId, false, 4, null));
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$12, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "playableItems", "", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass12 extends Lambda<Unit> implements Function1<List<? extends PlayableItemEntity>, Unit> {
        final /* synthetic */ SharedPreferences $platformLibrarySharedPreferences;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass12(SharedPreferences sharedPreferences) {
            super(1);
            this.$platformLibrarySharedPreferences = sharedPreferences;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlayableItemEntity> list) {
            invoke2((List<PlayableItemEntity>) list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<PlayableItemEntity> list) {
            if (PlatformLibraryGridViewNavFragment.this.filterMode != 4) {
                PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment = PlatformLibraryGridViewNavFragment.this;
                PlatformLibraryGridViewNavFragment.onCreateView$refreshPlayableItems(platformLibraryGridViewNavFragment, this.$platformLibrarySharedPreferences, platformLibraryGridViewNavFragment.getLibraryViewModel().getAllPlayableItemsStatically());
                return;
            }
            PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment2 = PlatformLibraryGridViewNavFragment.this;
            SharedPreferences sharedPreferences = this.$platformLibrarySharedPreferences;
            DaijishouLibraryModel daijishouLibrary = platformLibraryGridViewNavFragment2.getDaijishouLibrary();
            long j = PlatformLibraryGridViewNavFragment.this.platformId;
            String currentGenreId = PlatformLibraryGridViewNavFragment.this.getCurrentGenreId();
            Intrinsics.checkNotNull(currentGenreId);
            PlatformLibraryGridViewNavFragment.onCreateView$refreshPlayableItems(platformLibraryGridViewNavFragment2, sharedPreferences, DaijishouLibraryModel.getPlayableItemIdsByPlatformIdGenreIdAndVisibilityStatically$default(daijishouLibrary, j, currentGenreId, false, 4, null));
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$14, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass14 extends Lambda<Unit> implements Function1<PlatformEntity, Unit> {
        AnonymousClass14() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlatformEntity platformEntity) {
            invoke2(platformEntity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PlatformEntity platformEntity) {
            String customBoxArtAspectRatio;
            String name;
            if (platformEntity != null) {
                PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment = PlatformLibraryGridViewNavFragment.this;
                platformLibraryGridViewNavFragment.platformEntity = platformEntity;
                if (platformEntity.getUseCustomBoxArtAspectRatio()) {
                    customBoxArtAspectRatio = platformEntity.getCustomBoxArtAspectRatio();
                    if (customBoxArtAspectRatio == null) {
                        customBoxArtAspectRatio = Constants.defaultThumbnailDimensionRatio;
                    }
                } else {
                    List list = platformLibraryGridViewNavFragment.boxArtAspectRatioList;
                    if (list == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("boxArtAspectRatioList");
                        list = null;
                    }
                    customBoxArtAspectRatio = (String) list.get(platformEntity.getBoxArtAspectRatioId());
                }
                platformLibraryGridViewNavFragment.boxArtAspectRatio = customBoxArtAspectRatio;
                PlatformLibraryGridAdapter platformLibraryGridAdapter = platformLibraryGridViewNavFragment.platformLibraryGridRecyclerViewAdapter;
                if (platformLibraryGridAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerViewAdapter");
                    platformLibraryGridAdapter = null;
                }
                platformLibraryGridAdapter.setDimensionRatio(platformLibraryGridViewNavFragment.boxArtAspectRatio);
                List listSplit$default = StringsKt.split$default((CharSequence) platformLibraryGridViewNavFragment.boxArtAspectRatio, new String[]{CollectionUtils.COLON}, false, 0, 6, (Object) null);
                float fMax = Math.max((Float.parseFloat((String) listSplit$default.get(0)) * 120.0f) / Float.parseFloat((String) listSplit$default.get(1)), 120.0f);
                RecyclerView recyclerView = platformLibraryGridViewNavFragment.platformLibraryGridRecyclerView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
                    recyclerView = null;
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager);
                ((DaijishouGridLayoutManager) layoutManager).updateTargetWidthDp(fMax);
                RecyclerView recyclerView2 = platformLibraryGridViewNavFragment.platformLibraryGridRecyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
                    recyclerView2 = null;
                }
                recyclerView2.requestLayout();
                TextView textView = platformLibraryGridViewNavFragment.titleTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                    textView = null;
                }
                if (platformEntity.getName().length() > 20) {
                    String shortname = platformEntity.getShortname();
                    Locale ROOT = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                    name = shortname.toUpperCase(ROOT);
                    Intrinsics.checkNotNullExpressionValue(name, "toUpperCase(...)");
                } else {
                    name = platformEntity.getName();
                }
                textView.setText(name);
                DaijishouViewModel model = platformLibraryGridViewNavFragment.getModel();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = platformLibraryGridViewNavFragment.platformFormatString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformFormatString");
                    str = null;
                }
                String shortname2 = platformEntity.getShortname();
                Locale ROOT2 = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
                String upperCase = shortname2.toUpperCase(ROOT2);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                String str2 = String.format(str, Arrays.copyOf(new Object[]{upperCase}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                DaijishouViewModel.setTips$default(model, str2, false, 2, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$15, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
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

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            View view = PlatformLibraryGridViewNavFragment.this.dividerView;
            ChipGroup chipGroup = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dividerView");
                view = null;
            }
            view.setVisibility((PlatformLibraryGridViewNavFragment.this.genreIds.isEmpty() || !bool.booleanValue()) ? 8 : 0);
            ChipGroup chipGroup2 = PlatformLibraryGridViewNavFragment.this.genresChipGroup;
            if (chipGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("genresChipGroup");
            } else {
                chipGroup = chipGroup2;
            }
            chipGroup.setVisibility((PlatformLibraryGridViewNavFragment.this.genreIds.isEmpty() || !bool.booleanValue()) ? 8 : 0);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryGridViewNavFragment$onCreateView$16, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryGridViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "genreIds", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass16 extends Lambda<Unit> implements Function1<List<? extends String>, Unit> {
        final /* synthetic */ Context $context;
        final /* synthetic */ SharedPreferences $platformLibrarySharedPreferences;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass16(Context context, SharedPreferences sharedPreferences) {
            super(1);
            this.$context = context;
            this.$platformLibrarySharedPreferences = sharedPreferences;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<String> list) {
            Chip chip;
            int id2;
            Chip chip2;
            ChipGroup chipGroup;
            SharedPreferences sharedPreferences;
            int i;
            PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment = PlatformLibraryGridViewNavFragment.this;
            Intrinsics.checkNotNull(list);
            platformLibraryGridViewNavFragment.genreIds = list;
            boolean z = PlatformLibraryGridViewNavFragment.this.getDefaultSharedPreferences().getBoolean(BooleanPreference.SHOW_GENRES_IN_PLATFORM_GRID_VIEW.getKey(), BooleanPreference.SHOW_GENRES_IN_PLATFORM_GRID_VIEW.getDefaultValue());
            if ((list.isEmpty() || !z) && PlatformLibraryGridViewNavFragment.this.lastVisibleChipIndex >= 0) {
                ChipGroup chipGroup2 = PlatformLibraryGridViewNavFragment.this.chipGroup;
                if (chipGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup2 = null;
                }
                View childAt = chipGroup2.getChildAt(PlatformLibraryGridViewNavFragment.this.lastVisibleChipIndex);
                Chip chip3 = PlatformLibraryGridViewNavFragment.this.listViewButton;
                if (chip3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listViewButton");
                    chip3 = null;
                }
                childAt.setNextFocusRightId(chip3.getId());
            }
            ChipGroup chipGroup3 = PlatformLibraryGridViewNavFragment.this.genresChipGroup;
            if (chipGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("genresChipGroup");
                chipGroup3 = null;
            }
            chipGroup3.removeAllViews();
            View view = PlatformLibraryGridViewNavFragment.this.dividerView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dividerView");
                view = null;
            }
            boolean z2 = false;
            view.setVisibility((list.isEmpty() || !z) ? 8 : 0);
            PlatformLibraryGridViewNavFragment platformLibraryGridViewNavFragment2 = PlatformLibraryGridViewNavFragment.this;
            Context context = this.$context;
            SharedPreferences sharedPreferences2 = this.$platformLibrarySharedPreferences;
            Chip chip4 = null;
            Chip chip5 = null;
            for (String str : list) {
                if (platformLibraryGridViewNavFragment2.genreIdToChipHashMap.get(str) != null) {
                    Chip chip6 = chip4;
                    chip4 = (Chip) platformLibraryGridViewNavFragment2.genreIdToChipHashMap.get(str);
                    chip2 = chip6;
                    sharedPreferences = sharedPreferences2;
                    i = -1;
                    chipGroup = null;
                } else {
                    chip2 = chip4;
                    chip4 = new Chip(context);
                    Genre genre = Genres.INSTANCE.getGenres().get(str);
                    String string = platformLibraryGridViewNavFragment2.getString(genre != null ? genre.getNameStringId() : R.string.unknown_genre_name);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    chip4.setFocusable(true);
                    chip4.setTag(1);
                    chip4.setEnsureMinTouchTargetSize(z2);
                    chip4.setAllCaps(true);
                    chip4.setChipStrokeColorResource(R.color.material_on_surface_stroke);
                    chip4.setText(string);
                    chipGroup = null;
                    chip4.setTypeface(null, 3);
                    sharedPreferences = sharedPreferences2;
                    i = -1;
                    chip4.setOnClickListener(new PlatformLibraryGridViewNavFragment$onCreateView$16$$ExternalSyntheticLambda0(platformLibraryGridViewNavFragment2, chip4, str, string, sharedPreferences));
                    platformLibraryGridViewNavFragment2.genreIdToChipHashMap.put(str, chip4);
                }
                if (chip4 != null) {
                    if (chip4.getParent() != null) {
                        ViewParent parent = chip4.getParent();
                        Intrinsics.checkNotNull(parent);
                        ((ViewGroup) parent).removeView(chip4);
                    }
                    chip4.setNextFocusUpId(R.id.tab_layout);
                    chip4.setNextFocusRightId(i);
                    ChipGroup chipGroup4 = platformLibraryGridViewNavFragment2.genresChipGroup;
                    if (chipGroup4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("genresChipGroup");
                        chipGroup4 = chipGroup;
                    }
                    chipGroup4.addView(chip4);
                    if (chip5 == null) {
                        chip5 = chip4;
                    }
                } else {
                    chip4 = chip2;
                }
                sharedPreferences2 = sharedPreferences;
                z2 = false;
            }
            Chip chip7 = chip4;
            ChipGroup chipGroup5 = PlatformLibraryGridViewNavFragment.this.genresChipGroup;
            if (chipGroup5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("genresChipGroup");
                chipGroup5 = null;
            }
            chipGroup5.setVisibility((list.isEmpty() || !z) ? 8 : 0);
            if (chip7 != null) {
                chip7.setNextFocusRightId(chip5 != null ? chip5.getId() : -1);
            }
            if (PlatformLibraryGridViewNavFragment.this.lastVisibleChipIndex >= 0) {
                ChipGroup chipGroup6 = PlatformLibraryGridViewNavFragment.this.chipGroup;
                if (chipGroup6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup6 = null;
                }
                View childAt2 = chipGroup6.getChildAt(PlatformLibraryGridViewNavFragment.this.lastVisibleChipIndex);
                if (chip5 != null) {
                    id2 = chip5.getId();
                } else {
                    Chip chip8 = PlatformLibraryGridViewNavFragment.this.listViewButton;
                    if (chip8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("listViewButton");
                        chip = null;
                    } else {
                        chip = chip8;
                    }
                    id2 = chip.getId();
                }
                childAt2.setNextFocusRightId(id2);
            }
        }

    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        String upperCase;
        String shortname;
        super.onResume();
        DaijishouViewModel model = getModel();
        PlatformEntity value = getLibraryViewModel().getSelectedPlatformEntityLiveData().getValue();
        if (value == null || (shortname = value.getShortname()) == null) {
            upperCase = null;
        } else {
            upperCase = shortname.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        }
        DaijishouViewModel.setTips$default(model, upperCase + " platform", false, 2, null);
    }

    public static final void invoke$lambda$2$lambda$1(PlatformLibraryGridViewNavFragment this$0, Chip chip, String genreId, String genreName, SharedPreferences platformLibrarySharedPreferences, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(chip, "$chip");
        Intrinsics.checkNotNullParameter(genreId, "$genreId");
        Intrinsics.checkNotNullParameter(genreName, "$genreName");
        Intrinsics.checkNotNullParameter(platformLibrarySharedPreferences, "$platformLibrarySharedPreferences");
        if (Intrinsics.areEqual(this$0.selectedChip, chip)) {
            return;
        }
        Chip chip2 = this$0.selectedChip;
        if (chip2 != null) {
            Chip chip3 = this$0.backupChip;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backupChip");
                chip3 = null;
            }
            chip2.setChipBackgroundColor(chip3.getChipBackgroundColor());
            Chip chip4 = this$0.backupChip;
            if (chip4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backupChip");
                chip4 = null;
            }
            chip2.setTextColor(chip4.getTextColors());
        }
        this$0.selectedChip = chip;
        ColorStateList colorStateList = this$0.chipColorStateList;
        if (colorStateList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipColorStateList");
            colorStateList = null;
        }
        chip.setChipBackgroundColor(colorStateList);
        chip.setTextColor(this$0.colorOnPrimary);
        this$0.filterMode = 4;
        this$0.setCurrentGenreId(genreId);
        RecyclerView recyclerView = this$0.platformLibraryGridRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryGridRecyclerView");
            recyclerView = null;
        }
        recyclerView.setNextFocusUpId(chip.getId());
        PlatformLibraryGridViewNavFragment.onCreateView$refreshPlayableItems(this$0, platformLibrarySharedPreferences, DaijishouLibraryModel.getPlayableItemIdsByPlatformIdGenreIdAndVisibilityStatically$default(this$0.getDaijishouLibrary(), this$0.platformId, genreId, false, 4, null));
        chip.requestFocus();
        DaijishouViewModel.setTips$default(this$0.getModel(), genreName, false, 2, null);
        HorizontalScrollView horizontalScrollView = this$0.horizontalScrollView;
        if (horizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
            horizontalScrollView = null;
        }
        ChipGroup chipGroup = this$0.chipGroup;
        if (chipGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
            chipGroup = null;
        }
        int width = chipGroup.getWidth() + chip.getLeft();
        View view2 = this$0.dividerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dividerView");
            view2 = null;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        int i = width + (marginLayoutParams != null ? marginLayoutParams.leftMargin : 0);
        View view3 = this$0.dividerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dividerView");
            view3 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = view3.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        horizontalScrollView.smoothScrollTo(Math.max(0, (i + (marginLayoutParams2 != null ? marginLayoutParams2.rightMargin : 0)) - this$0.getDpToPxConverter().convert(32.0f)), 0);
    }

    public static final int access$getFilterMode$p(PlatformLibraryGridViewNavFragment fragment) {
        return fragment.filterMode;
    }

    public static final boolean access$getMergePlayableItemsPreference(PlatformLibraryGridViewNavFragment fragment) {
        return fragment.getMergePlayableItemsPreference();
    }

    public static final com.magneticchen.daijishou.view_models.DaijishouLibraryModel access$getDaijishouLibrary(PlatformLibraryGridViewNavFragment fragment) {
        return fragment.getDaijishouLibrary();
    }
}
