package com.magneticchen.daijishou.nav_fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
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
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.PlatformNavFragment;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.Genre;
import com.magneticchen.daijishou.daijishou_library_db.Genres;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouCycleLinearLayoutManager;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.daijishou_widget.WidgetsManager;
import com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play.PinAndPlayWidgetBuilder;
import com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment;
import com.magneticchen.daijishou.live_data.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.utils.PlaidColorUtils;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.view_models.AppsViewModel;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import com.magneticchen.daijishou.view_models.LibraryViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.SortedMap;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 {2\u00020\u0001:\u0002{|B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010[\u001a\u00020 H\u0002J\u0010\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020LH\u0002J\u0012\u0010_\u001a\u00020]2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J&\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020e2\b\u0010f\u001a\u0004\u0018\u00010g2\b\u0010`\u001a\u0004\u0018\u00010aH\u0017J \u0010h\u001a\u00020 2\u0006\u0010i\u001a\u00020L2\u0006\u0010j\u001a\u00020L2\u0006\u0010k\u001a\u00020lH\u0016J\b\u0010m\u001a\u00020]H\u0016J\b\u0010n\u001a\u00020]H\u0016J\b\u0010o\u001a\u00020]H\u0016J\b\u0010p\u001a\u00020]H\u0002J\u0018\u0010q\u001a\u00020]2\u0006\u0010r\u001a\u00020O2\u0006\u0010s\u001a\u00020LH\u0002J\b\u0010t\u001a\u00020]H\u0002J\u0012\u0010u\u001a\u00020]2\b\u0010v\u001a\u0004\u0018\u00010wH\u0002J\u0012\u0010x\u001a\u00020]2\b\u0010y\u001a\u0004\u0018\u00010wH\u0002J\b\u0010z\u001a\u00020]H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\n\u001a\u0004\b*\u0010+R\u000e\u0010-\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\n\u001a\u0004\b0\u00101R\u000e\u00103\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082.¢\u0006\u0002\n\u0000R\u001b\u00107\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\n\u001a\u0004\b9\u0010:R\u000e\u0010<\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010D\u001a\u00060ER\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020L0JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010M\u001a\b\u0012\u0004\u0012\u00020O0NX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryListViewNavFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/PlatformNavFragment;", "()V", "addFavoriteString", "", "appsViewModel", "Lcom/magneticchen/daijishou/view_models/AppsViewModel;", "getAppsViewModel", "()Lcom/magneticchen/daijishou/view_models/AppsViewModel;", "appsViewModel$delegate", "Lkotlin/Lazy;", "backgroundGradientImageView", "Landroid/widget/ImageView;", "backgroundImageView", "backgroundSetLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "boxArtAspectRatio", "boxArtAspectRatioList", "", "chipGroup", "Lcom/google/android/material/chip/ChipGroup;", "descriptionFormatString", "descriptionTextView", "Landroid/widget/TextView;", "descriptionWithGenresFormatString", "detailButton", "Lcom/google/android/material/chip/Chip;", "dimensionRatio", "editButton", "favoriteButton", "gridViewButton", "hopToNextItemLock", "", "isFavoriteDrawable", "Landroid/graphics/drawable/Drawable;", "isFavoriteString", "isNotFavoriteDrawable", "lastHopToNextItemTimeMillis", "", "lastToggleViewModeTimeMillis", "libraryViewModel", "Lcom/magneticchen/daijishou/view_models/LibraryViewModel;", "getLibraryViewModel", "()Lcom/magneticchen/daijishou/view_models/LibraryViewModel;", "libraryViewModel$delegate", "lockToggleViewMode", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "model$delegate", "newlyButton", "noneString", "packageManager", "Landroid/content/pm/PackageManager;", "pinAndPlayWidget", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;", "getPinAndPlayWidget", "()Lcom/magneticchen/daijishou/daijishou_widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;", "pinAndPlayWidget$delegate", "pinButton", "placeholderImageView", "platformEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "platformFormatString", "platformId", "platformLibraryListRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "platformLibraryListRecyclerViewAdapter", "Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;", "platformString", "platformTextView", "playButton", "playableItemCharacterIndexingHashmap", "Ljava/util/SortedMap;", "", "", "playableItemList", "", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "recentButton", "screenAspectRatio", "screenAspectRatioList", "selectedLetterFormatString", "selectedPlayableItemEntity", "setPreviewToBoxArtString", "setPreviewToSnapshotString", "setPreviewToTitleString", "thumbnailImageView", "tipsFormatString", "titleTextView", "getMergePlayableItemsPreference", "hopToNextItemByFirstCharacter", "", TypedValues.CycleType.S_WAVE_OFFSET, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHotKeyPressed", "hotkeyCode", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onKioskMode", "onNoneKioskMode", "onResume", "refreshPinButton", "refreshPlayableItemEntity", "playableItemEntity", "position", "refreshPreview", "setBackground", "bitmap", "Landroid/graphics/Bitmap;", "setThumbnail", "it", "toggleViewMode", "Companion", "PlatformLibraryListAdapter", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlatformLibraryListViewNavFragment extends PlatformNavFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Typeface typeface;
    private String addFavoriteString;

    /* JADX INFO: renamed from: appsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy appsViewModel;
    public ImageView backgroundGradientImageView;
    public ImageView backgroundImageView;
    private ConstraintLayout backgroundSetLayout;
    private String boxArtAspectRatio;
    private List<String> boxArtAspectRatioList;
    private ChipGroup chipGroup;
    private String descriptionFormatString;
    private TextView descriptionTextView;
    private String descriptionWithGenresFormatString;
    private Chip detailButton;
    private String dimensionRatio;
    private Chip editButton;
    private Chip favoriteButton;
    private Chip gridViewButton;
    private boolean hopToNextItemLock;
    private Drawable isFavoriteDrawable;
    private String isFavoriteString;
    private Drawable isNotFavoriteDrawable;

    /* JADX INFO: renamed from: libraryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy libraryViewModel;

    /* JADX INFO: renamed from: model$delegate, reason: from kotlin metadata */
    private final Lazy model;
    private Chip newlyButton;
    private String noneString;
    private PackageManager packageManager;
    private Chip pinButton;
    private ImageView placeholderImageView;
    private PlatformEntity platformEntity;
    private String platformFormatString;
    private RecyclerView platformLibraryListRecyclerView;
    private PlatformLibraryListAdapter platformLibraryListRecyclerViewAdapter;
    private String platformString;
    private TextView platformTextView;
    private Chip playButton;
    private Chip recentButton;
    private String screenAspectRatio;
    private List<String> screenAspectRatioList;
    private String selectedLetterFormatString;
    PlayableItemEntity selectedPlayableItemEntity;

    public static final PlayableItemEntity access$getSelectedPlayableItemEntity$p(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment) {
        return platformLibraryListViewNavFragment.selectedPlayableItemEntity;
    }
    private String setPreviewToBoxArtString;
    private String setPreviewToSnapshotString;
    private String setPreviewToTitleString;
    public ImageView thumbnailImageView;
    private String tipsFormatString;
    private TextView titleTextView;
    private long platformId = -1;
    private final List<PlayableItemEntity> playableItemList = new ArrayList();
    private long lastHopToNextItemTimeMillis = System.currentTimeMillis();
    private long lastToggleViewModeTimeMillis = System.currentTimeMillis();
    private boolean lockToggleViewMode = true;
    private final SortedMap<Character, Integer> playableItemCharacterIndexingHashmap = MapsKt.sortedMapOf(new Pair[0]);

    /* JADX INFO: renamed from: pinAndPlayWidget$delegate, reason: from kotlin metadata */
    private final Lazy pinAndPlayWidget = LazyKt.lazy(new PlatformLibraryListViewNavFragment$pinAndPlayWidget$2(this));

    public PlatformLibraryListViewNavFragment() {
        PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment = this;
        this.model = FragmentViewModelLazyKt.createViewModelLazy(platformLibraryListViewNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$1(platformLibraryListViewNavFragment), new PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$2(null, platformLibraryListViewNavFragment), new PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$3(platformLibraryListViewNavFragment));
        this.libraryViewModel = FragmentViewModelLazyKt.createViewModelLazy(platformLibraryListViewNavFragment, Reflection.getOrCreateKotlinClass(LibraryViewModel.class), new PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$4(platformLibraryListViewNavFragment), new PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$5(null, platformLibraryListViewNavFragment), new PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$6(platformLibraryListViewNavFragment));
        this.appsViewModel = FragmentViewModelLazyKt.createViewModelLazy(platformLibraryListViewNavFragment, Reflection.getOrCreateKotlinClass(AppsViewModel.class), new PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$7(platformLibraryListViewNavFragment), new PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$8(null, platformLibraryListViewNavFragment), new PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$9(platformLibraryListViewNavFragment));
    }

    /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryListViewNavFragment$Companion;", "", "()V", "typeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "newInstance", "Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryListViewNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlatformLibraryListViewNavFragment newInstance() {
            return new PlatformLibraryListViewNavFragment();
        }
    }

    static {
        typeface = Build.VERSION.SDK_INT >= 28 ? Typeface.create(null, Constants.semiBolderWeight, false) : Typeface.defaultFromStyle(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LibraryViewModel getLibraryViewModel() {
        return (LibraryViewModel) this.libraryViewModel.getValue();
    }

    private final AppsViewModel getAppsViewModel() {
        return (AppsViewModel) this.appsViewModel.getValue();
    }

    private final PinAndPlayWidgetBuilder getPinAndPlayWidget() {
        return (PinAndPlayWidgetBuilder) this.pinAndPlayWidget.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getMergePlayableItemsPreference() {
        return getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue());
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public void onKioskMode() {
        super.onKioskMode();
        Chip chip = this.editButton;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip = null;
        }
        chip.setVisibility(8);
        Chip chip2 = this.gridViewButton;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
            chip2 = null;
        }
        Chip chip3 = this.playButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip3 = null;
        }
        chip2.setNextFocusRightId(chip3.getId());
        Chip chip4 = this.gridViewButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
            chip4 = null;
        }
        Chip chip5 = chip4;
        ViewGroup.LayoutParams layoutParams = chip5.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.chip.ChipGroup.LayoutParams");
        }
        ChipGroup.LayoutParams layoutParams2 = (ChipGroup.LayoutParams) layoutParams;
        ChipGroup.LayoutParams layoutParams3 = layoutParams2;
        ChipGroup chipGroup = this.chipGroup;
        if (chipGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
            chipGroup = null;
        }
        for (View view : com.magneticchen.daijishou.support.DaijishouSupport.iterable(ViewGroupKt.getChildren(chipGroup))) {
            Chip chip6 = this.editButton;
            if (chip6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editButton");
                chip6 = null;
            }
            if (Intrinsics.areEqual(view, chip6)) {
                ChipGroup chipGroup2 = this.chipGroup;
                if (chipGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup2 = null;
                }
                chipGroup2.removeView(view);
            }
        }
        layoutParams3.setMarginEnd(getDpToPxConverter().convert(8.0f));
        chip5.setLayoutParams(layoutParams2);
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public void onNoneKioskMode() {
        super.onNoneKioskMode();
        Chip chip = this.editButton;
        Chip chip2 = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip = null;
        }
        chip.setVisibility(0);
        Chip chip3 = this.gridViewButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
            chip3 = null;
        }
        Chip chip4 = this.editButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip4 = null;
        }
        chip3.setNextFocusRightId(chip4.getId());
        Chip chip5 = this.gridViewButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
            chip5 = null;
        }
        Chip chip6 = chip5;
        ViewGroup.LayoutParams layoutParams = chip6.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.chip.ChipGroup.LayoutParams");
        }
        ChipGroup.LayoutParams layoutParams2 = (ChipGroup.LayoutParams) layoutParams;
        ChipGroup.LayoutParams layoutParams3 = layoutParams2;
        ChipGroup chipGroup = this.chipGroup;
        if (chipGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
            chipGroup = null;
        }
        Chip chip7 = this.editButton;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
        } else {
            chip2 = chip7;
        }
        chipGroup.addView(chip2);
        layoutParams3.setMarginEnd(getDpToPxConverter().convert(0.0f));
        chip6.setLayoutParams(layoutParams2);
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onHotKeyPressed(int hotkeyCode, int keyCode, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(hotkeyCode, keyCode, keyEvent);
        if (hotkeyCode == 1) {
            hopToNextItemByFirstCharacter(1);
            return true;
        }
        if (hotkeyCode == 2) {
            hopToNextItemByFirstCharacter(-1);
            return true;
        }
        if (hotkeyCode == 3) {
            toggleViewMode();
            return true;
        }
        if (hotkeyCode != 4) {
            return false;
        }
        PlatformLibraryListAdapter platformLibraryListAdapter = this.platformLibraryListRecyclerViewAdapter;
        if (platformLibraryListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            platformLibraryListAdapter = null;
        }
        DaijishouRecyclerView.Adapter<PlayableItemEntity>.ViewHolder selectedViewHolder = platformLibraryListAdapter.getSelectedViewHolder();
        if (selectedViewHolder == null) {
            return false;
        }
        if (selectedViewHolder.itemView.isFocused() && selectedViewHolder.getAbsoluteAdapterPosition() >= 0) {
            selectedViewHolder.itemView.performLongClick();
        }
        return true;
    }

    private final void hopToNextItemByFirstCharacter(int offset) {
        if (this.playableItemList.isEmpty() || this.playableItemCharacterIndexingHashmap.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.hopToNextItemLock || jCurrentTimeMillis - this.lastHopToNextItemTimeMillis < 45) {
            return;
        }
        this.lastHopToNextItemTimeMillis = jCurrentTimeMillis;
        this.hopToNextItemLock = true;
        List<PlayableItemEntity> list = this.playableItemList;
        PlatformLibraryListAdapter platformLibraryListAdapter = this.platformLibraryListRecyclerViewAdapter;
        RecyclerView recyclerView = null;
        if (platformLibraryListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            platformLibraryListAdapter = null;
        }
        String upperCase = list.get(platformLibraryListAdapter.get_selectedPosition()).getName().toUpperCase(Locale.ROOT);
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
        PlatformLibraryListAdapter platformLibraryListAdapter2 = this.platformLibraryListRecyclerViewAdapter;
        if (platformLibraryListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            platformLibraryListAdapter2 = null;
        }
        platformLibraryListAdapter2.selectPosition(iIntValue);
        PlatformLibraryListAdapter platformLibraryListAdapter3 = this.platformLibraryListRecyclerViewAdapter;
        if (platformLibraryListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            platformLibraryListAdapter3 = null;
        }
        platformLibraryListAdapter3.notifyItemChanged(iIntValue);
        RecyclerView recyclerView2 = this.platformLibraryListRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerView");
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
        getLibraryViewModel().getPreferences().edit().putInt("view_mode", 1).apply();
        NavController navControllerFindNavController = FragmentKt.findNavController(this);
        NavDestination currentDestination = navControllerFindNavController.getCurrentDestination();
        if (currentDestination == null || currentDestination.getId() != R.id.platformLibraryListViewNavFragment) {
            return;
        }
        navControllerFindNavController.navigate(R.id.platformLibraryListToPlatformLibraryGridAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setThumbnail(Bitmap it) {
        String shortname;
        ImageView imageView = this.thumbnailImageView;
        ConstraintLayout constraintLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thumbnailImageView");
            imageView = null;
        }
        imageView.setImageBitmap(it);
        ImageView imageView2 = this.placeholderImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("placeholderImageView");
            imageView2 = null;
        }
        imageView2.setVisibility(it == null ? 0 : 8);
        TextView textView = this.platformTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformTextView");
            textView = null;
        }
        textView.setVisibility(it != null ? 8 : 0);
        TextView textView2 = this.platformTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformTextView");
            textView2 = null;
        }
        PlatformEntity platformEntity = this.platformEntity;
        if ((platformEntity == null || (shortname = platformEntity.getShortname()) == null) && (shortname = this.platformString) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformString");
            shortname = null;
        }
        textView2.setText(shortname);
        int previewMode = getLibraryViewModel().getPreviewMode();
        if (previewMode == 0) {
            this.dimensionRatio = this.boxArtAspectRatio;
            ConstraintLayout constraintLayout2 = this.backgroundSetLayout;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
                constraintLayout2 = null;
            }
            ViewGroup.LayoutParams layoutParams = constraintLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams).dimensionRatio = this.boxArtAspectRatio;
        } else if (previewMode == 1) {
            this.dimensionRatio = this.screenAspectRatio;
            ConstraintLayout constraintLayout3 = this.backgroundSetLayout;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
                constraintLayout3 = null;
            }
            ViewGroup.LayoutParams layoutParams2 = constraintLayout3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams2).dimensionRatio = this.screenAspectRatio;
        } else if (previewMode == 2) {
            this.dimensionRatio = this.screenAspectRatio;
            ConstraintLayout constraintLayout4 = this.backgroundSetLayout;
            if (constraintLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
                constraintLayout4 = null;
            }
            ViewGroup.LayoutParams layoutParams3 = constraintLayout4.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams3).dimensionRatio = this.screenAspectRatio;
        }
        String str = this.dimensionRatio;
        if (str != null) {
            ConstraintLayout constraintLayout5 = this.backgroundSetLayout;
            if (constraintLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
                constraintLayout5 = null;
            }
            ViewGroup.LayoutParams layoutParams4 = constraintLayout5.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) layoutParams4;
            if (!Intrinsics.areEqual(layoutParams5.dimensionRatio, str)) {
                layoutParams5.dimensionRatio = str;
            }
            ConstraintLayout constraintLayout6 = this.backgroundSetLayout;
            if (constraintLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            } else {
                constraintLayout = constraintLayout6;
            }
            constraintLayout.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBackground(Bitmap bitmap) {
        boolean z = (bitmap == null || getDefaultSharedPreferences().getBoolean(BooleanPreference.FORCE_SET_WALLPAPER_FOR_ALL.getKey(), BooleanPreference.FORCE_SET_WALLPAPER_FOR_ALL.getDefaultValue())) ? false : true;
        ImageView imageView = this.backgroundImageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundImageView");
            imageView = null;
        }
        imageView.setImageBitmap(bitmap);
        ImageView imageView3 = this.backgroundGradientImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundGradientImageView");
            imageView3 = null;
        }
        if ((imageView3.getVisibility() == 0) != z) {
            ImageView imageView4 = this.backgroundGradientImageView;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundGradientImageView");
            } else {
                imageView2 = imageView4;
            }
            imageView2.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshPreview() {
        int previewMode = getLibraryViewModel().getPreviewMode();
        PlayableItemEntity playableItemEntity = this.selectedPlayableItemEntity;
        if (playableItemEntity != null) {
            if (playableItemEntity.getPreviewMediaPath() != null) {
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new PlatformLibraryListViewNavFragment$refreshPreview$1$1(playableItemEntity, playableItemEntity, this, previewMode, null), 2, null);
            } else {
                setThumbnail(null);
                setBackground(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshPlayableItemEntity(PlayableItemEntity playableItemEntity, int position) {
        String upperCase;
        String strDecapitalize;
        Drawable drawable;
        String str;
        String strDecapitalize2;
        Chip chip;
        String strDecapitalize3;
        Drawable drawable2;
        String str2;
        String strDecapitalize4;
        String shortname;
        DaijishouViewModel model = getModel();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str3 = this.tipsFormatString;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsFormatString");
            str3 = null;
        }
        PlatformEntity platformEntity = this.platformEntity;
        if (platformEntity == null || (shortname = platformEntity.getShortname()) == null) {
            upperCase = null;
        } else {
            upperCase = shortname.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        }
        Integer numValueOf = Integer.valueOf(position + 1);
        PlatformLibraryListAdapter platformLibraryListAdapter = this.platformLibraryListRecyclerViewAdapter;
        if (platformLibraryListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            platformLibraryListAdapter = null;
        }
        String str4 = String.format(str3, Arrays.copyOf(new Object[]{upperCase, numValueOf, Integer.valueOf(platformLibraryListAdapter.getItemCount())}, 3));
        Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
        DaijishouViewModel.setTips$default(model, str4, false, 2, null);
        Date date = new Date(System.currentTimeMillis() - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3492getRecentDurationDefinitionUwyO8pc()));
        this.selectedPlayableItemEntity = playableItemEntity;
        TextView textView = this.titleTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView = null;
        }
        textView.setSelected(true);
        TextView textView2 = this.descriptionTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
            textView2 = null;
        }
        textView2.setSelected(true);
        List<String> genreIdsByPlayableItemIdStatically = getDaijishouLibrary().getGenreIdsByPlayableItemIdStatically(playableItemEntity.getId());
        int size = genreIdsByPlayableItemIdStatically.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Genre genre = Genres.INSTANCE.getGenres().get(genreIdsByPlayableItemIdStatically.get(i));
            arrayList.add(getString(genre != null ? genre.getNameStringId() : R.string.unknown_genre_name));
        }
        ArrayList arrayList2 = arrayList;
        if (getMergePlayableItemsPreference()) {
            TextView textView3 = this.titleTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                textView3 = null;
            }
            textView3.setText(getDaijishouLibrary().prettifyTitleWithPreferences(playableItemEntity.getMergedInfo().getMergedName()));
            if (genreIdsByPlayableItemIdStatically.isEmpty()) {
                TextView textView4 = this.descriptionTextView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
                    textView4 = null;
                }
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str5 = this.descriptionFormatString;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("descriptionFormatString");
                    str5 = null;
                }
                if (playableItemEntity.getMergedInfo().getMergedLastPlayedTimestamp() != null) {
                    Utils utils = Utils.INSTANCE;
                    Date mergedLastPlayedTimestamp = playableItemEntity.getMergedInfo().getMergedLastPlayedTimestamp();
                    Intrinsics.checkNotNull(mergedLastPlayedTimestamp);
                    String relativeTimeString = utils.getRelativeTimeString(mergedLastPlayedTimestamp.getTime());
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    strDecapitalize4 = StringsKt.decapitalize(relativeTimeString, locale);
                } else {
                    strDecapitalize4 = this.noneString;
                    if (strDecapitalize4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noneString");
                        strDecapitalize4 = null;
                    }
                }
                String str6 = String.format(str5, Arrays.copyOf(new Object[]{strDecapitalize4, Integer.valueOf(playableItemEntity.getMergedInfo().getMergedPlayedCount())}, 2));
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                textView4.setText(str6);
            } else {
                TextView textView5 = this.descriptionTextView;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
                    textView5 = null;
                }
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String str7 = this.descriptionWithGenresFormatString;
                if (str7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("descriptionWithGenresFormatString");
                    str7 = null;
                }
                String strJoinToString$default = CollectionsKt.joinToString$default(arrayList2, ", ", null, null, 0, null, null, 62, null);
                if (playableItemEntity.getMergedInfo().getMergedLastPlayedTimestamp() != null) {
                    Utils utils2 = Utils.INSTANCE;
                    Date mergedLastPlayedTimestamp2 = playableItemEntity.getMergedInfo().getMergedLastPlayedTimestamp();
                    Intrinsics.checkNotNull(mergedLastPlayedTimestamp2);
                    String relativeTimeString2 = utils2.getRelativeTimeString(mergedLastPlayedTimestamp2.getTime());
                    Locale locale2 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                    strDecapitalize3 = StringsKt.decapitalize(relativeTimeString2, locale2);
                } else {
                    strDecapitalize3 = this.noneString;
                    if (strDecapitalize3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noneString");
                        strDecapitalize3 = null;
                    }
                }
                String str8 = String.format(str7, Arrays.copyOf(new Object[]{strJoinToString$default, strDecapitalize3, Integer.valueOf(playableItemEntity.getMergedInfo().getMergedPlayedCount())}, 3));
                Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                textView5.setText(str8);
            }
            Chip chip2 = this.favoriteButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip2 = null;
            }
            if (playableItemEntity.getMergedInfo().getMergedIsFavorite()) {
                drawable2 = this.isFavoriteDrawable;
                if (drawable2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isFavoriteDrawable");
                    drawable2 = null;
                }
            } else {
                drawable2 = this.isNotFavoriteDrawable;
                if (drawable2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isNotFavoriteDrawable");
                    drawable2 = null;
                }
            }
            chip2.setChipIcon(drawable2);
            Chip chip3 = this.favoriteButton;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip3 = null;
            }
            if (playableItemEntity.getMergedInfo().getMergedIsFavorite()) {
                str2 = this.isFavoriteString;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isFavoriteString");
                    str2 = null;
                }
            } else {
                str2 = this.addFavoriteString;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addFavoriteString");
                    str2 = null;
                }
            }
            chip3.setText(str2);
            Date mergedLastPlayedTimestamp3 = playableItemEntity.getMergedInfo().getMergedLastPlayedTimestamp();
            if (mergedLastPlayedTimestamp3 != null) {
                Chip chip4 = this.recentButton;
                if (chip4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                    chip4 = null;
                }
                chip4.setVisibility(mergedLastPlayedTimestamp3.after(date) ? 0 : 8);
            } else {
                Chip chip5 = this.recentButton;
                if (chip5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                    chip5 = null;
                }
                chip5.setVisibility(8);
            }
        } else {
            TextView textView6 = this.titleTextView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                textView6 = null;
            }
            textView6.setText(getDaijishouLibrary().prettifyTitleWithPreferences(playableItemEntity.getName()));
            if (genreIdsByPlayableItemIdStatically.isEmpty()) {
                TextView textView7 = this.descriptionTextView;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
                    textView7 = null;
                }
                StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                String str9 = this.descriptionFormatString;
                if (str9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("descriptionFormatString");
                    str9 = null;
                }
                if (playableItemEntity.getLastPlayedTimestamp() != null) {
                    Utils utils3 = Utils.INSTANCE;
                    Date lastPlayedTimestamp = playableItemEntity.getLastPlayedTimestamp();
                    Intrinsics.checkNotNull(lastPlayedTimestamp);
                    String relativeTimeString3 = utils3.getRelativeTimeString(lastPlayedTimestamp.getTime());
                    Locale locale3 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
                    strDecapitalize2 = StringsKt.decapitalize(relativeTimeString3, locale3);
                } else {
                    strDecapitalize2 = this.noneString;
                    if (strDecapitalize2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noneString");
                        strDecapitalize2 = null;
                    }
                }
                String str10 = String.format(str9, Arrays.copyOf(new Object[]{strDecapitalize2, Integer.valueOf(playableItemEntity.getPlayCount())}, 2));
                Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                textView7.setText(str10);
            } else {
                TextView textView8 = this.descriptionTextView;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
                    textView8 = null;
                }
                StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                String str11 = this.descriptionWithGenresFormatString;
                if (str11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("descriptionWithGenresFormatString");
                    str11 = null;
                }
                String strJoinToString$default2 = CollectionsKt.joinToString$default(arrayList2, ", ", null, null, 0, null, null, 62, null);
                if (playableItemEntity.getLastPlayedTimestamp() != null) {
                    Utils utils4 = Utils.INSTANCE;
                    Date lastPlayedTimestamp2 = playableItemEntity.getLastPlayedTimestamp();
                    Intrinsics.checkNotNull(lastPlayedTimestamp2);
                    String relativeTimeString4 = utils4.getRelativeTimeString(lastPlayedTimestamp2.getTime());
                    Locale locale4 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale4, "getDefault(...)");
                    strDecapitalize = StringsKt.decapitalize(relativeTimeString4, locale4);
                } else {
                    strDecapitalize = this.noneString;
                    if (strDecapitalize == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noneString");
                        strDecapitalize = null;
                    }
                }
                String str12 = String.format(str11, Arrays.copyOf(new Object[]{strJoinToString$default2, strDecapitalize, Integer.valueOf(playableItemEntity.getPlayCount())}, 3));
                Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                textView8.setText(str12);
            }
            Chip chip6 = this.favoriteButton;
            if (chip6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip6 = null;
            }
            if (playableItemEntity.isFavorite()) {
                drawable = this.isFavoriteDrawable;
                if (drawable == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isFavoriteDrawable");
                    drawable = null;
                }
            } else {
                drawable = this.isNotFavoriteDrawable;
                if (drawable == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isNotFavoriteDrawable");
                    drawable = null;
                }
            }
            chip6.setChipIcon(drawable);
            Chip chip7 = this.favoriteButton;
            if (chip7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip7 = null;
            }
            if (playableItemEntity.isFavorite()) {
                str = this.isFavoriteString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isFavoriteString");
                    str = null;
                }
            } else {
                str = this.addFavoriteString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addFavoriteString");
                    str = null;
                }
            }
            chip7.setText(str);
            Date lastPlayedTimestamp3 = playableItemEntity.getLastPlayedTimestamp();
            if (lastPlayedTimestamp3 != null) {
                Chip chip8 = this.recentButton;
                if (chip8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                    chip8 = null;
                }
                chip8.setVisibility(lastPlayedTimestamp3.after(date) ? 0 : 8);
            } else {
                Chip chip9 = this.recentButton;
                if (chip9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                    chip9 = null;
                }
                chip9.setVisibility(8);
            }
        }
        refreshPinButton();
        refreshPreview();
        Chip chip10 = this.recentButton;
        if (chip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip10 = null;
        }
        chip10.requestLayout();
        Chip chip11 = this.newlyButton;
        if (chip11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
            chip = null;
        } else {
            chip = chip11;
        }
        chip.requestLayout();
    }

    private final void refreshPinButton() {
        PlayableItemEntity playableItemEntity = this.selectedPlayableItemEntity;
        Chip chip = null;
        if (getMergePlayableItemsPreference()) {
            if (playableItemEntity != null && getPinAndPlayWidget().isPlayableItemIdsInAPinAndPlayWidget(playableItemEntity.getMergedInfo().getMergedDisjointSetPrimaryPlayableItemIds())) {
                Chip chip2 = this.pinButton;
                if (chip2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pinButton");
                    chip2 = null;
                }
                if (chip2.isFocused()) {
                    RecyclerView recyclerView = this.platformLibraryListRecyclerView;
                    if (recyclerView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerView");
                        recyclerView = null;
                    }
                    recyclerView.requestFocus();
                }
                Chip chip3 = this.pinButton;
                if (chip3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pinButton");
                } else {
                    chip = chip3;
                }
                chip.setVisibility(8);
                return;
            }
            Chip chip4 = this.pinButton;
            if (chip4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pinButton");
                chip4 = null;
            }
            chip4.setVisibility(0);
            Chip chip5 = this.pinButton;
            if (chip5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pinButton");
                chip5 = null;
            }
            chip5.setChipIconResource(R.drawable.outline_push_pin_24);
            Chip chip6 = this.pinButton;
            if (chip6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            } else {
                chip = chip6;
            }
            chip.setText(getString(R.string.pin_item));
            return;
        }
        if (playableItemEntity != null && getPinAndPlayWidget().isPlayableItemIdInAPinAndPlayWidget(playableItemEntity.getId())) {
            Chip chip7 = this.pinButton;
            if (chip7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pinButton");
                chip7 = null;
            }
            if (chip7.isFocused()) {
                RecyclerView recyclerView2 = this.platformLibraryListRecyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerView");
                    recyclerView2 = null;
                }
                recyclerView2.requestFocus();
            }
            Chip chip8 = this.pinButton;
            if (chip8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            } else {
                chip = chip8;
            }
            chip.setVisibility(8);
            return;
        }
        Chip chip9 = this.pinButton;
        if (chip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip9 = null;
        }
        chip9.setVisibility(0);
        Chip chip10 = this.pinButton;
        if (chip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip10 = null;
        }
        chip10.setChipIconResource(R.drawable.outline_push_pin_24);
        Chip chip11 = this.pinButton;
        if (chip11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
        } else {
            chip = chip11;
        }
        chip.setText(getString(R.string.pin_item));
    }

    /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\u0011\u001a\n0\u0012R\u00060\u0000R\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rR\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "playableItemEntityList", "", "RIGHT_FOCUS_ID", "", "(Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryListViewNavFragment;Ljava/util/List;I)V", "colorOnPrimary", "colorPrimary", "shape", "Landroid/graphics/drawable/GradientDrawable;", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "typedValue", "Landroid/util/TypedValue;", "onCreateViewHolder", "Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryListViewNavFragment;", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class PlatformLibraryListAdapter extends DaijishouRecyclerView.Adapter<PlayableItemEntity> {
        private final int RIGHT_FOCUS_ID;
        private final int colorOnPrimary;
        private final int colorPrimary;
        private final GradientDrawable shape;
        private final Resources.Theme theme;
        final /* synthetic */ PlatformLibraryListViewNavFragment this$0;
        private final TypedValue typedValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlatformLibraryListAdapter(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, List<PlayableItemEntity> playableItemEntityList, int i) {
            super(playableItemEntityList, true, false, 4, null);
            Intrinsics.checkNotNullParameter(playableItemEntityList, "playableItemEntityList");
            this.this$0 = platformLibraryListViewNavFragment;
            this.RIGHT_FOCUS_ID = i;
            TypedValue typedValue = new TypedValue();
            this.typedValue = typedValue;
            Resources.Theme theme = platformLibraryListViewNavFragment.requireContext().getTheme();
            Intrinsics.checkNotNullExpressionValue(theme, "getTheme(...)");
            this.theme = theme;
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.shape = gradientDrawable;
            theme.resolveAttribute(R.attr.colorPrimary, typedValue, true);
            int i2 = typedValue.data;
            this.colorPrimary = i2;
            theme.resolveAttribute(R.attr.colorOnPrimary, typedValue, true);
            this.colorOnPrimary = typedValue.data;
            gradientDrawable.setCornerRadius(platformLibraryListViewNavFragment.getDpToPxConverter().convert(6.0f));
            gradientDrawable.setColor(i2);
        }

        /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/nav_fragments/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;Landroid/view/View;)V", "favoriteImageTintBackup", "Landroid/content/res/ColorStateList;", "favoriteImageView", "Landroid/widget/ImageView;", "layout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "newlyImageTintBackup", "newlyImageView", "recentImageTintBackup", "recentImageView", "textColorsBackup", "textView", "Landroid/widget/TextView;", "onBind", "", "position", "", "item", "onClick", "", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "onSelect", "onUnselect", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<PlayableItemEntity>.ViewHolder {
            private ColorStateList favoriteImageTintBackup;
            private final ImageView favoriteImageView;
            private final ConstraintLayout layout;
            private ColorStateList newlyImageTintBackup;
            private final ImageView newlyImageView;
            private ColorStateList recentImageTintBackup;
            private final ImageView recentImageView;
            private final ColorStateList textColorsBackup;
            private final TextView textView;
            final /* synthetic */ PlatformLibraryListAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(PlatformLibraryListAdapter platformLibraryListAdapter, View itemView) {
                super(platformLibraryListAdapter, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = platformLibraryListAdapter;
                View viewFindViewById = itemView.findViewById(R.id.platform_library_list_item_text_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                TextView textView = (TextView) viewFindViewById;
                this.textView = textView;
                View viewFindViewById2 = itemView.findViewById(R.id.platform_library_list_item_recent_image_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                ImageView imageView = (ImageView) viewFindViewById2;
                this.recentImageView = imageView;
                View viewFindViewById3 = itemView.findViewById(R.id.platform_library_list_item_favorite_image_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                ImageView imageView2 = (ImageView) viewFindViewById3;
                this.favoriteImageView = imageView2;
                View viewFindViewById4 = itemView.findViewById(R.id.platform_library_list_item_newly_image_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
                ImageView imageView3 = (ImageView) viewFindViewById4;
                this.newlyImageView = imageView3;
                View viewFindViewById5 = itemView.findViewById(R.id.platform_library_list_item_constraint_layout);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
                this.layout = (ConstraintLayout) viewFindViewById5;
                ColorStateList textColors = textView.getTextColors();
                Intrinsics.checkNotNullExpressionValue(textColors, "getTextColors(...)");
                this.textColorsBackup = textColors;
                ColorStateList imageTintList = imageView2.getImageTintList();
                Intrinsics.checkNotNull(imageTintList);
                this.favoriteImageTintBackup = imageTintList;
                ColorStateList imageTintList2 = imageView3.getImageTintList();
                Intrinsics.checkNotNull(imageTintList2);
                this.newlyImageTintBackup = imageTintList2;
                ColorStateList imageTintList3 = imageView.getImageTintList();
                Intrinsics.checkNotNull(imageTintList3);
                this.recentImageTintBackup = imageTintList3;
            }

            /* JADX WARN: Code duplicated, block: B:19:0x00ac  */
            /* JADX WARN: Code duplicated, block: B:41:0x012a  */
            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int position, PlayableItemEntity item) {
                int i = 8;
                Intrinsics.checkNotNullParameter(item, "item");
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jM5096getInWholeMillisecondsimpl = jCurrentTimeMillis - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3492getRecentDurationDefinitionUwyO8pc());
                long jM5096getInWholeMillisecondsimpl2 = jCurrentTimeMillis - com.magneticchen.daijishou.support.DaijishouValueSupport.durationInWholeMilliseconds(Constants.INSTANCE.m3491getNewlyDurationDefinitionUwyO8pc());
                if (this.this$0.this$0.getMergePlayableItemsPreference()) {
                    this.textView.setText(this.this$0.this$0.getDaijishouLibrary().prettifyTitleWithPreferences(item.getMergedInfo().getMergedName()));
                    this.favoriteImageView.setVisibility(item.getMergedInfo().getMergedIsFavorite() ? 0 : 8);
                    this.newlyImageView.setVisibility(item.getMergedInfo().getMergedAddedDateTimestamp().getTime() >= jM5096getInWholeMillisecondsimpl2 ? 0 : 8);
                    if (!this.this$0.this$0.getDefaultSharedPreferences().getBoolean(BooleanPreference.SHOW_RECENT_INDICATORS.getKey(), BooleanPreference.SHOW_RECENT_INDICATORS.getDefaultValue())) {
                        if (this.recentImageView.getVisibility() != 8) {
                            this.recentImageView.setVisibility(8);
                            return;
                        }
                        return;
                    } else {
                        ImageView imageView = this.recentImageView;
                        if (item.getMergedInfo().getMergedLastPlayedTimestamp() != null) {
                            Date mergedLastPlayedTimestamp = item.getMergedInfo().getMergedLastPlayedTimestamp();
                            Intrinsics.checkNotNull(mergedLastPlayedTimestamp);
                            i = mergedLastPlayedTimestamp.getTime() < jM5096getInWholeMillisecondsimpl ? 8 : 0;
                        }
                        imageView.setVisibility(i);
                        return;
                    }
                }
                this.textView.setText(this.this$0.this$0.getDaijishouLibrary().prettifyTitleWithPreferences(item.getName()));
                this.favoriteImageView.setVisibility(item.isFavorite() ? 0 : 8);
                this.newlyImageView.setVisibility(item.getAddedDateTimestamp().getTime() >= jM5096getInWholeMillisecondsimpl2 ? 0 : 8);
                if (!this.this$0.this$0.getDefaultSharedPreferences().getBoolean(BooleanPreference.SHOW_RECENT_INDICATORS.getKey(), BooleanPreference.SHOW_RECENT_INDICATORS.getDefaultValue())) {
                    if (this.recentImageView.getVisibility() != 8) {
                        this.recentImageView.setVisibility(8);
                    }
                } else {
                    ImageView imageView2 = this.recentImageView;
                    if (item.getLastPlayedTimestamp() != null) {
                        Date lastPlayedTimestamp = item.getLastPlayedTimestamp();
                        Intrinsics.checkNotNull(lastPlayedTimestamp);
                        i = lastPlayedTimestamp.getTime() < jM5096getInWholeMillisecondsimpl ? 8 : 0;
                    }
                    imageView2.setVisibility(i);
                }
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onSelect() {
                super.onSelect();
                this.layout.setBackground(this.this$0.shape);
                this.textView.setTextColor(this.this$0.colorOnPrimary);
                this.textView.setAlpha(1.0f);
                this.favoriteImageView.setImageTintList(new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{this.this$0.colorOnPrimary}));
                this.newlyImageView.setImageTintList(new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{this.this$0.colorOnPrimary}));
                this.recentImageView.setImageTintList(new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{this.this$0.colorOnPrimary}));
                this.textView.setTypeface(null, 1);
                this.textView.setSelected(true);
                this.itemView.setNextFocusRightId(this.this$0.RIGHT_FOCUS_ID);
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onUnselect() {
                super.onUnselect();
                this.layout.setBackground(null);
                this.textView.setTextColor(this.textColorsBackup);
                this.textView.setAlpha(0.6f);
                this.favoriteImageView.setImageTintList(this.favoriteImageTintBackup);
                this.newlyImageView.setImageTintList(this.newlyImageTintBackup);
                this.recentImageView.setImageTintList(this.recentImageTintBackup);
                this.textView.setTypeface(null, 0);
                this.textView.setSelected(false);
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
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_platform_library_playable_item, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        String string = getString(R.string.platform);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.platformString = string;
        String string2 = getString(R.string.none_lowercase);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.noneString = string2;
        String string3 = getString(R.string.set_preview_to_box_art);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.setPreviewToBoxArtString = string3;
        String string4 = getString(R.string.set_preview_to_snapshot);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        this.setPreviewToSnapshotString = string4;
        String string5 = getString(R.string.set_preview_to_title);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        this.setPreviewToTitleString = string5;
        String string6 = getString(R.string.add_favorite);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        this.addFavoriteString = string6;
        String string7 = getString(R.string.is_favorite);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        this.isFavoriteString = string7;
        String string8 = getString(R.string.selected_letter_formant);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        this.selectedLetterFormatString = string8;
        this.platformId = getLibraryViewModel().getSelectedPlatformId();
        String string9 = getString(R.string.platform_format);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        this.platformFormatString = string9;
        String string10 = getString(R.string.platform_library_list_tips_format);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        this.tipsFormatString = string10;
        String string11 = getString(R.string.playable_item_subtitle_format);
        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
        this.descriptionFormatString = string11;
        String string12 = getString(R.string.playable_item_subtitle_with_genres_format);
        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
        this.descriptionWithGenresFormatString = string12;
        PackageManager packageManager = fragmentActivityRequireActivity.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        this.packageManager = packageManager;
        Drawable drawable = AppCompatResources.getDrawable(contextRequireContext, R.drawable.ic_round_favorite_24);
        Intrinsics.checkNotNull(drawable);
        this.isFavoriteDrawable = drawable;
        Drawable drawable2 = AppCompatResources.getDrawable(contextRequireContext, R.drawable.ic_round_favorite_border_24);
        Intrinsics.checkNotNull(drawable2);
        this.isNotFavoriteDrawable = drawable2;
        String[] stringArray = getResources().getStringArray(R.array.box_art_aspect_ratio_array);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        this.boxArtAspectRatioList = ArraysKt.toList(stringArray);
        String[] stringArray2 = getResources().getStringArray(R.array.screen_aspect_ratio_array);
        Intrinsics.checkNotNullExpressionValue(stringArray2, "getStringArray(...)");
        this.screenAspectRatioList = ArraysKt.toList(stringArray2);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Chip chip;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullExpressionValue(requireActivity(), "requireActivity(...)");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        SharedPreferences preferences = getLibraryViewModel().getPreferences();
        View viewInflate = inflater.inflate(R.layout.fragment_platform_library_list_view, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.player_associated_platforms_chip_group);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.chipGroup = (ChipGroup) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.platform_library_play_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.playButton = (Chip) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.platform_library_list_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.platformLibraryListRecyclerView = (RecyclerView) viewFindViewById3;
        List<PlayableItemEntity> list = this.playableItemList;
        Chip chip2 = this.playButton;
        ImageView imageView = null;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip2 = null;
        }
        this.platformLibraryListRecyclerViewAdapter = new PlatformLibraryListAdapter(this, list, chip2.getId());
        View viewFindViewById4 = viewInflate.findViewById(R.id.platform_library_title_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.titleTextView = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.platform_library_description_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.descriptionTextView = (TextView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.platform_library_platform_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.platformTextView = (TextView) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.platform_library_thumbnail);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.thumbnailImageView = (ImageView) viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(R.id.platform_library_background);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.backgroundImageView = (ImageView) viewFindViewById8;
        View viewFindViewById9 = viewInflate.findViewById(R.id.platform_library_background_gradient);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.backgroundGradientImageView = (ImageView) viewFindViewById9;
        View viewFindViewById10 = viewInflate.findViewById(R.id.platform_library_background_set);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.backgroundSetLayout = (ConstraintLayout) viewFindViewById10;
        View viewFindViewById11 = viewInflate.findViewById(R.id.platform_library_placeholder);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.placeholderImageView = (ImageView) viewFindViewById11;
        View viewFindViewById12 = viewInflate.findViewById(R.id.platform_library_favorite_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.favoriteButton = (Chip) viewFindViewById12;
        View viewFindViewById13 = viewInflate.findViewById(R.id.platform_library_pin_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.pinButton = (Chip) viewFindViewById13;
        View viewFindViewById14 = viewInflate.findViewById(R.id.platform_library_recent_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.recentButton = (Chip) viewFindViewById14;
        View viewFindViewById15 = viewInflate.findViewById(R.id.platform_library_newly_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.newlyButton = (Chip) viewFindViewById15;
        View viewFindViewById16 = viewInflate.findViewById(R.id.platform_library_detail_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        this.detailButton = (Chip) viewFindViewById16;
        View viewFindViewById17 = viewInflate.findViewById(R.id.platform_library_grid_view_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        this.gridViewButton = (Chip) viewFindViewById17;
        View viewFindViewById18 = viewInflate.findViewById(R.id.platform_library_edit_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        this.editButton = (Chip) viewFindViewById18;
        this.playableItemList.clear();
        Chip chip3 = this.editButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip3 = null;
        }
        chip3.setVisibility(getIsKioskMode() ? 8 : 0);
        Chip chip4 = this.gridViewButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
            chip4 = null;
        }
        if (getIsKioskMode()) {
            chip = this.playButton;
            if (chip == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playButton");
                chip = null;
            }
        } else {
            chip = this.editButton;
            if (chip == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editButton");
                chip = null;
            }
        }
        chip4.setNextFocusRightId(chip.getId());
        if (getIsKioskMode()) {
            Chip chip5 = this.gridViewButton;
            if (chip5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
                chip5 = null;
            }
            Chip chip6 = chip5;
            ViewGroup.LayoutParams layoutParams = chip6.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.chip.ChipGroup.LayoutParams");
            }
            ChipGroup.LayoutParams layoutParams2 = (ChipGroup.LayoutParams) layoutParams;
            ChipGroup.LayoutParams layoutParams3 = layoutParams2;
            ChipGroup chipGroup = this.chipGroup;
            if (chipGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                chipGroup = null;
            }
            for (View view : com.magneticchen.daijishou.support.DaijishouSupport.iterable(ViewGroupKt.getChildren(chipGroup))) {
                Chip chip7 = this.editButton;
                if (chip7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editButton");
                    chip7 = null;
                }
                if (Intrinsics.areEqual(view, chip7)) {
                    ChipGroup chipGroup2 = this.chipGroup;
                    if (chipGroup2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                        chipGroup2 = null;
                    }
                    chipGroup2.removeView(view);
                }
            }
            layoutParams3.setMarginEnd(getDpToPxConverter().convert(8.0f));
            chip6.setLayoutParams(layoutParams2);
        }
        RecyclerView recyclerView = this.platformLibraryListRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerView");
            recyclerView = null;
        }
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        recyclerView.setLayoutManager(new DaijishouCycleLinearLayoutManager(contextRequireContext2));
        RecyclerView recyclerView2 = this.platformLibraryListRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerView");
            recyclerView2 = null;
        }
        PlatformLibraryListAdapter platformLibraryListAdapter = this.platformLibraryListRecyclerViewAdapter;
        if (platformLibraryListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            platformLibraryListAdapter = null;
        }
        recyclerView2.setAdapter(platformLibraryListAdapter);
        RecyclerView recyclerView3 = this.platformLibraryListRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setItemAnimator(null);
        Chip chip8 = this.playButton;
        if (chip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip8 = null;
        }
        chip8.setTypeface(null, 3);
        Chip chip9 = this.favoriteButton;
        if (chip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip9 = null;
        }
        chip9.setTypeface(null, 1);
        Chip chip10 = this.pinButton;
        if (chip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip10 = null;
        }
        chip10.setTypeface(null, 1);
        Chip chip11 = this.recentButton;
        if (chip11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip11 = null;
        }
        Typeface typeface2 = typeface;
        chip11.setTypeface(typeface2);
        Chip chip12 = this.newlyButton;
        if (chip12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
            chip12 = null;
        }
        chip12.setTypeface(typeface2);
        Chip chip13 = this.detailButton;
        if (chip13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailButton");
            chip13 = null;
        }
        chip13.setTypeface(typeface2);
        Chip chip14 = this.gridViewButton;
        if (chip14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
            chip14 = null;
        }
        chip14.setTypeface(typeface2);
        Chip chip15 = this.editButton;
        if (chip15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip15 = null;
        }
        chip15.setTypeface(typeface2);
        Chip chip16 = this.playButton;
        if (chip16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip16 = null;
        }
        ConstraintLayout constraintLayout = this.backgroundSetLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout = null;
        }
        chip16.setNextFocusUpId(constraintLayout.getId());
        Chip chip17 = this.favoriteButton;
        if (chip17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip17 = null;
        }
        ConstraintLayout constraintLayout2 = this.backgroundSetLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout2 = null;
        }
        chip17.setNextFocusUpId(constraintLayout2.getId());
        Chip chip18 = this.pinButton;
        if (chip18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip18 = null;
        }
        ConstraintLayout constraintLayout3 = this.backgroundSetLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout3 = null;
        }
        chip18.setNextFocusUpId(constraintLayout3.getId());
        Chip chip19 = this.recentButton;
        if (chip19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip19 = null;
        }
        ConstraintLayout constraintLayout4 = this.backgroundSetLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout4 = null;
        }
        chip19.setNextFocusUpId(constraintLayout4.getId());
        Chip chip20 = this.newlyButton;
        if (chip20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
            chip20 = null;
        }
        ConstraintLayout constraintLayout5 = this.backgroundSetLayout;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout5 = null;
        }
        chip20.setNextFocusUpId(constraintLayout5.getId());
        Chip chip21 = this.detailButton;
        if (chip21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailButton");
            chip21 = null;
        }
        ConstraintLayout constraintLayout6 = this.backgroundSetLayout;
        if (constraintLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout6 = null;
        }
        chip21.setNextFocusUpId(constraintLayout6.getId());
        Chip chip22 = this.gridViewButton;
        if (chip22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
            chip22 = null;
        }
        ConstraintLayout constraintLayout7 = this.backgroundSetLayout;
        if (constraintLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout7 = null;
        }
        chip22.setNextFocusUpId(constraintLayout7.getId());
        Chip chip23 = this.editButton;
        if (chip23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip23 = null;
        }
        ConstraintLayout constraintLayout8 = this.backgroundSetLayout;
        if (constraintLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout8 = null;
        }
        chip23.setNextFocusUpId(constraintLayout8.getId());
        ConstraintLayout constraintLayout9 = this.backgroundSetLayout;
        if (constraintLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout9 = null;
        }
        constraintLayout9.setOnFocusChangeListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda0());
        Chip chip24 = this.playButton;
        if (chip24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip24 = null;
        }
        chip24.setOnFocusChangeListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda15());
        Chip chip25 = this.favoriteButton;
        if (chip25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip25 = null;
        }
        chip25.setOnFocusChangeListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda16());
        Chip chip26 = this.pinButton;
        if (chip26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip26 = null;
        }
        chip26.setOnFocusChangeListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda1());
        Chip chip27 = this.recentButton;
        if (chip27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip27 = null;
        }
        chip27.setOnFocusChangeListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda2());
        Chip chip28 = this.newlyButton;
        if (chip28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
            chip28 = null;
        }
        chip28.setOnFocusChangeListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda3());
        Chip chip29 = this.detailButton;
        if (chip29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailButton");
            chip29 = null;
        }
        chip29.setOnFocusChangeListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda4());
        Chip chip30 = this.gridViewButton;
        if (chip30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
            chip30 = null;
        }
        chip30.setOnFocusChangeListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda5());
        Chip chip31 = this.editButton;
        if (chip31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip31 = null;
        }
        chip31.setOnFocusChangeListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda6());
        ConstraintLayout constraintLayout10 = this.backgroundSetLayout;
        if (constraintLayout10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout10 = null;
        }
        constraintLayout10.setOnClickListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda7(this, contextRequireContext));
        ConstraintLayout constraintLayout11 = this.backgroundSetLayout;
        if (constraintLayout11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout11 = null;
        }
        constraintLayout11.setOnLongClickListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda8(this));
        Chip chip32 = this.playButton;
        if (chip32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip32 = null;
        }
        chip32.setOnClickListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda9(this));
        Chip chip33 = this.favoriteButton;
        if (chip33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip33 = null;
        }
        chip33.setOnClickListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda10(this));
        Chip chip34 = this.pinButton;
        if (chip34 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip34 = null;
        }
        chip34.setOnClickListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda11(this));
        Chip chip35 = this.detailButton;
        if (chip35 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailButton");
            chip35 = null;
        }
        chip35.setOnClickListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda12(this));
        Chip chip36 = this.gridViewButton;
        if (chip36 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
            chip36 = null;
        }
        chip36.setOnClickListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda13(this));
        Chip chip37 = this.editButton;
        if (chip37 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip37 = null;
        }
        chip37.setOnClickListener(new PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda14(this));
        PlatformLibraryListAdapter platformLibraryListAdapter2 = this.platformLibraryListRecyclerViewAdapter;
        if (platformLibraryListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            platformLibraryListAdapter2 = null;
        }
        platformLibraryListAdapter2.setOnItemSelectListener(new AnonymousClass19(preferences, this));
        PlatformLibraryListAdapter platformLibraryListAdapter3 = this.platformLibraryListRecyclerViewAdapter;
        if (platformLibraryListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            platformLibraryListAdapter3 = null;
        }
        platformLibraryListAdapter3.setOnItemClickListener(new AnonymousClass20());
        PlatformLibraryListAdapter platformLibraryListAdapter4 = this.platformLibraryListRecyclerViewAdapter;
        if (platformLibraryListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            platformLibraryListAdapter4 = null;
        }
        platformLibraryListAdapter4.setOnItemLongClickListener(new AnonymousClass21());
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.PRETTIFY_TITLES.getKey(), BooleanPreference.PRETTIFY_TITLES.getDefaultValue()).observe(getViewLifecycleOwner(), new PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass22()));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.SHOW_RECENT_INDICATORS.getKey(), BooleanPreference.SHOW_RECENT_INDICATORS.getDefaultValue()).observe(getViewLifecycleOwner(), new PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass23()));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.FORCE_SET_WALLPAPER_FOR_ALL.getKey(), BooleanPreference.FORCE_SET_WALLPAPER_FOR_ALL.getDefaultValue()).observe(getViewLifecycleOwner(), new PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass24()));
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = getMergePlayableItemsPreference();
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue()).observe(getViewLifecycleOwner(), new PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass25(booleanRef, this, preferences)));
        ImageView imageView2 = this.backgroundImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundImageView");
        } else {
            imageView = imageView2;
        }
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "use_pure_dark_theme", false).observe(getViewLifecycleOwner(), new PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass26(imageView.getAlpha())));
        getLibraryViewModel().getAllPlayableItems().observe(getViewLifecycleOwner(), new PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass27(preferences)));
        getDaijishouLibrary().getPlatformById(this.platformId).observe(getViewLifecycleOwner(), new PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass28()));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$9(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$10(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$11(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$12(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$13(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$14(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$15(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$16(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$17(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, false, 24, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, false, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$18(PlatformLibraryListViewNavFragment this$0, Context context, View view) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        int i = this$0.getLibraryViewModel().togglePreviewAspectRatioMode();
        this$0.refreshPreview();
        if (i == 0) {
            str = this$0.setPreviewToBoxArtString;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setPreviewToBoxArtString");
                str = null;
            }
        } else if (i == 1) {
            str = this$0.setPreviewToSnapshotString;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setPreviewToSnapshotString");
                str = null;
            }
        } else if (i == 2) {
            str = this$0.setPreviewToTitleString;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setPreviewToTitleString");
                str = null;
            }
        } else {
            str = null;
        }
        DaijishouViewModel model = this$0.getModel();
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toastMessage");
            str2 = null;
        } else {
            str2 = str;
        }
        DaijishouViewModel.setTips$default(model, str2, false, 2, null);
        Toast.makeText(context, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$20(PlatformLibraryListViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = this$0.selectedPlayableItemEntity;
        if (playableItemEntity == null) {
            return true;
        }
        PlayableItemDetailDialogFragment.INSTANCE.newInstance(playableItemEntity).show(this$0.getParentFragmentManager(), "playable_item_detail");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$22(PlatformLibraryListViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = this$0.selectedPlayableItemEntity;
        if (playableItemEntity != null) {
            DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
            FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            DaijishouLibraryModel.play$default(daijishouLibrary, fragmentActivityRequireActivity, playableItemEntity, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$24(PlatformLibraryListViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = this$0.selectedPlayableItemEntity;
        if (playableItemEntity != null) {
            this$0.getDaijishouLibrary().toggleIsPlayableItemFavorite(playableItemEntity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$25(PlatformLibraryListViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = this$0.selectedPlayableItemEntity;
        if (playableItemEntity == null) {
            return;
        }
        if (this$0.getMergePlayableItemsPreference()) {
            if (this$0.getPinAndPlayWidget().isPlayableItemIdsInAPinAndPlayWidget(playableItemEntity.getMergedInfo().getMergedDisjointSetPrimaryPlayableItemIds())) {
                WidgetsManager widgetManager = this$0.getWidgetManager();
                FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
                Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                widgetManager.requestWidgetInstanceRemoval((AppCompatActivity) fragmentActivityRequireActivity, PinAndPlayWidgetBuilder.class, playableItemEntity.getMergedInfo().getMergedDisjointSetPrimaryPlayableItemIds(), new PlatformLibraryListViewNavFragment$onCreateView$15$2(this$0));
            } else {
                WidgetsManager widgetManager2 = this$0.getWidgetManager();
                FragmentActivity fragmentActivityRequireActivity2 = this$0.requireActivity();
                Intrinsics.checkNotNull(fragmentActivityRequireActivity2, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                widgetManager2.requestWidgetInstanceCreation((AppCompatActivity) fragmentActivityRequireActivity2, PinAndPlayWidgetBuilder.class, Long.valueOf(playableItemEntity.getId()), new PlatformLibraryListViewNavFragment$onCreateView$15$1(this$0));
            }
        } else if (this$0.getPinAndPlayWidget().isPlayableItemIdInAPinAndPlayWidget(playableItemEntity.getId())) {
            WidgetsManager widgetManager3 = this$0.getWidgetManager();
            FragmentActivity fragmentActivityRequireActivity3 = this$0.requireActivity();
            Intrinsics.checkNotNull(fragmentActivityRequireActivity3, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            widgetManager3.requestWidgetInstanceRemoval((AppCompatActivity) fragmentActivityRequireActivity3, PinAndPlayWidgetBuilder.class, Long.valueOf(playableItemEntity.getId()), new PlatformLibraryListViewNavFragment$onCreateView$15$4(this$0));
        } else {
            WidgetsManager widgetManager4 = this$0.getWidgetManager();
            FragmentActivity fragmentActivityRequireActivity4 = this$0.requireActivity();
            Intrinsics.checkNotNull(fragmentActivityRequireActivity4, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            widgetManager4.requestWidgetInstanceCreation((AppCompatActivity) fragmentActivityRequireActivity4, PinAndPlayWidgetBuilder.class, Long.valueOf(playableItemEntity.getId()), new PlatformLibraryListViewNavFragment$onCreateView$15$3(this$0));
        }
        this$0.refreshPinButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$27(PlatformLibraryListViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = this$0.selectedPlayableItemEntity;
        if (playableItemEntity != null) {
            PlayableItemDetailDialogFragment.INSTANCE.newInstance(playableItemEntity).show(this$0.getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$28(PlatformLibraryListViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.toggleViewMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$30(PlatformLibraryListViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = this$0.selectedPlayableItemEntity;
        if (playableItemEntity != null) {
            DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
            FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            daijishouLibrary.editPlayableItem(fragmentActivityRequireActivity, playableItemEntity);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$onCreateView$19, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "position", "", "<anonymous parameter 2>", "", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass19 extends Lambda<Unit> implements Function4<View, Integer, Long, PlayableItemEntity, Unit> {
        final /* synthetic */ SharedPreferences $platformLibrarySharedPreferences;
        final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass19(SharedPreferences sharedPreferences, PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment) {
            super(4);
            this.$platformLibrarySharedPreferences = sharedPreferences;
            this.this$0 = platformLibraryListViewNavFragment;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity) {
            invoke(view, num.intValue(), l.longValue(), playableItemEntity);
            return Unit.INSTANCE;
        }

        public final void invoke(View view, int i, long j, PlayableItemEntity playableItemEntity) {
            Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
            this.$platformLibrarySharedPreferences.edit().putInt(this.this$0.platformId + "_selected_position", i).apply();
            this.this$0.refreshPlayableItemEntity(playableItemEntity, i);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$onCreateView$20, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass20 extends Lambda<Unit> implements Function4<View, Integer, Long, PlayableItemEntity, Unit> {
        AnonymousClass20() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity) {
            invoke(view, num.intValue(), l.longValue(), playableItemEntity);
            return Unit.INSTANCE;
        }

        public final void invoke(View view, int i, long j, PlayableItemEntity playableItemEntity) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
            DaijishouLibraryModel daijishouLibrary = PlatformLibraryListViewNavFragment.this.getDaijishouLibrary();
            FragmentActivity fragmentActivityRequireActivity = PlatformLibraryListViewNavFragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            DaijishouLibraryModel.play$default(daijishouLibrary, fragmentActivityRequireActivity, playableItemEntity, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$onCreateView$21, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke", "(Landroid/view/View;IJLcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass21 extends Lambda<Boolean> implements Function4<View, Integer, Long, PlayableItemEntity, Boolean> {
        AnonymousClass21() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Boolean invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity) {
            return invoke(view, num.intValue(), l.longValue(), playableItemEntity);
        }

        public final Boolean invoke(View view, int i, long j, PlayableItemEntity playableItemEntity) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
            PlayableItemDetailDialogFragment.INSTANCE.newInstance(playableItemEntity).show(PlatformLibraryListViewNavFragment.this.getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
            return true;
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$onCreateView$22, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass22 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        AnonymousClass22() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            PlayableItemEntity playableItemEntity = PlatformLibraryListViewNavFragment.this.selectedPlayableItemEntity;
            PlatformLibraryListAdapter platformLibraryListAdapter = null;
            if (playableItemEntity != null) {
                PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment = PlatformLibraryListViewNavFragment.this;
                TextView textView = platformLibraryListViewNavFragment.titleTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                    textView = null;
                }
                textView.setText(platformLibraryListViewNavFragment.getDaijishouLibrary().prettifyTitleWithPreferences(playableItemEntity.getDisjointSetPrimaryPlayableItemId() == null ? playableItemEntity.getName() : playableItemEntity.getMergedInfo().getMergedName()));
            }
            PlatformLibraryListAdapter platformLibraryListAdapter2 = PlatformLibraryListViewNavFragment.this.platformLibraryListRecyclerViewAdapter;
            if (platformLibraryListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            } else {
                platformLibraryListAdapter = platformLibraryListAdapter2;
            }
            platformLibraryListAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$onCreateView$23, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass23 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        AnonymousClass23() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            PlatformLibraryListAdapter platformLibraryListAdapter = PlatformLibraryListViewNavFragment.this.platformLibraryListRecyclerViewAdapter;
            if (platformLibraryListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
                platformLibraryListAdapter = null;
            }
            platformLibraryListAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$onCreateView$24, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass24 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        AnonymousClass24() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            ImageView imageView = PlatformLibraryListViewNavFragment.this.backgroundImageView;
            ImageView imageView2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundImageView");
                imageView = null;
            }
            Intrinsics.checkNotNull(bool);
            imageView.setVisibility(bool.booleanValue() ? 8 : 0);
            ImageView imageView3 = PlatformLibraryListViewNavFragment.this.backgroundGradientImageView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundGradientImageView");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setVisibility(bool.booleanValue() ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$refreshPlayableItems(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, SharedPreferences sharedPreferences, List<PlayableItemEntity> list) {
        if (platformLibraryListViewNavFragment.getMergePlayableItemsPreference()) {
            DaijishouLibraryModel daijishouLibrary = platformLibraryListViewNavFragment.getDaijishouLibrary();
            PlayableItemEntity[] playableItemEntityArr = (PlayableItemEntity[]) list.toArray(new PlayableItemEntity[0]);
            list = daijishouLibrary.getMergedPlayableItems((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr, playableItemEntityArr.length));
        }
        if (list.size() == platformLibraryListViewNavFragment.playableItemList.size()) {
            for (PlayableItemEntity playableItemEntity : list) {
                boolean z = true;
                int i = 0;
                for (Object obj : platformLibraryListViewNavFragment.playableItemList) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    PlayableItemEntity playableItemEntity2 = (PlayableItemEntity) obj;
                    if (playableItemEntity.getId() == playableItemEntity2.getId()) {
                        if (!Intrinsics.areEqual(playableItemEntity, playableItemEntity2)) {
                            platformLibraryListViewNavFragment.playableItemList.set(i, playableItemEntity);
                            PlatformLibraryListAdapter platformLibraryListAdapter = platformLibraryListViewNavFragment.platformLibraryListRecyclerViewAdapter;
                            PlatformLibraryListAdapter platformLibraryListAdapter2 = null;
                            if (platformLibraryListAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
                                platformLibraryListAdapter = null;
                            }
                            platformLibraryListAdapter.notifyItemChanged(i);
                            PlatformLibraryListAdapter platformLibraryListAdapter3 = platformLibraryListViewNavFragment.platformLibraryListRecyclerViewAdapter;
                            if (platformLibraryListAdapter3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
                            } else {
                                platformLibraryListAdapter2 = platformLibraryListAdapter3;
                            }
                            if (i == platformLibraryListAdapter2.get_selectedPosition()) {
                                platformLibraryListViewNavFragment.refreshPlayableItemEntity(playableItemEntity, i);
                            }
                        }
                        z = false;
                    }
                    i = i2;
                }
                if (z) {
                    onCreateView$refreshPlayableItems$updateAll(platformLibraryListViewNavFragment, list, sharedPreferences);
                    break;
                }
            }
        } else {
            onCreateView$refreshPlayableItems$updateAll(platformLibraryListViewNavFragment, list, sharedPreferences);
        }
        platformLibraryListViewNavFragment.lockToggleViewMode = false;
    }

    private static final void onCreateView$refreshPlayableItems$updateAll(PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, List<PlayableItemEntity> list, SharedPreferences sharedPreferences) {
        platformLibraryListViewNavFragment.playableItemList.clear();
        platformLibraryListViewNavFragment.playableItemList.addAll(list);
        RecyclerView recyclerView = null;
        Character chValueOf = null;
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            PlayableItemEntity playableItemEntity = (PlayableItemEntity) obj;
            String name = (playableItemEntity.getDisjointSetPrimaryPlayableItemId() == null || !platformLibraryListViewNavFragment.getMergePlayableItemsPreference()) ? playableItemEntity.getName() : playableItemEntity.getMergedInfo().getMergedName();
            if (name.length() != 0) {
                String upperCase = name.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                char cCharAt = upperCase.charAt(0);
                if (chValueOf == null || chValueOf.charValue() != cCharAt) {
                    chValueOf = Character.valueOf(cCharAt);
                    platformLibraryListViewNavFragment.playableItemCharacterIndexingHashmap.put(Character.valueOf(cCharAt), Integer.valueOf(i));
                }
            }
            i = i2;
        }
        PlatformLibraryListAdapter platformLibraryListAdapter = platformLibraryListViewNavFragment.platformLibraryListRecyclerViewAdapter;
        if (platformLibraryListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            platformLibraryListAdapter = null;
        }
        platformLibraryListAdapter.notifyDataSetChanged();
        if (list.isEmpty()) {
            return;
        }
        int iMin = Math.min(list.size() - 1, sharedPreferences.getInt(platformLibraryListViewNavFragment.platformId + "_selected_position", 0));
        PlatformLibraryListAdapter platformLibraryListAdapter2 = platformLibraryListViewNavFragment.platformLibraryListRecyclerViewAdapter;
        if (platformLibraryListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            platformLibraryListAdapter2 = null;
        }
        platformLibraryListAdapter2.selectPosition(iMin);
        PlatformLibraryListAdapter platformLibraryListAdapter3 = platformLibraryListViewNavFragment.platformLibraryListRecyclerViewAdapter;
        if (platformLibraryListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            platformLibraryListAdapter3 = null;
        }
        platformLibraryListAdapter3.notifyItemChanged(iMin);
        RecyclerView recyclerView2 = platformLibraryListViewNavFragment.platformLibraryListRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.scrollToPosition(Math.max(0, iMin - 3));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$onCreateView$25, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass25 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ Ref.BooleanRef $oldPref;
        final /* synthetic */ SharedPreferences $platformLibrarySharedPreferences;
        final /* synthetic */ PlatformLibraryListViewNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass25(Ref.BooleanRef booleanRef, PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment, SharedPreferences sharedPreferences) {
            super(1);
            this.$oldPref = booleanRef;
            this.this$0 = platformLibraryListViewNavFragment;
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
            PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment = this.this$0;
            PlatformLibraryListViewNavFragment.onCreateView$refreshPlayableItems(platformLibraryListViewNavFragment, this.$platformLibrarySharedPreferences, platformLibraryListViewNavFragment.getLibraryViewModel().getAllPlayableItemsStatically());
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$onCreateView$26, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass26 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ float $originalAlpha;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass26(float f) {
            super(1);
            this.$originalAlpha = f;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            PlaidColorUtils plaidColorUtils = PlaidColorUtils.INSTANCE;
            Context contextRequireContext = PlatformLibraryListViewNavFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            if (plaidColorUtils.isDarkTheme(contextRequireContext)) {
                Intrinsics.checkNotNull(bool);
                ImageView imageView = null;
                if (bool.booleanValue()) {
                    ImageView imageView2 = PlatformLibraryListViewNavFragment.this.backgroundImageView;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("backgroundImageView");
                    } else {
                        imageView = imageView2;
                    }
                    imageView.setAlpha(0.225f);
                    return;
                }
                ImageView imageView3 = PlatformLibraryListViewNavFragment.this.backgroundImageView;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backgroundImageView");
                } else {
                    imageView = imageView3;
                }
                imageView.setAlpha(this.$originalAlpha);
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$onCreateView$27, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "playableItems", "", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass27 extends Lambda<Unit> implements Function1<List<? extends PlayableItemEntity>, Unit> {
        final /* synthetic */ SharedPreferences $platformLibrarySharedPreferences;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass27(SharedPreferences sharedPreferences) {
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
            PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment = PlatformLibraryListViewNavFragment.this;
            SharedPreferences sharedPreferences = this.$platformLibrarySharedPreferences;
            Intrinsics.checkNotNull(list);
            PlatformLibraryListViewNavFragment.onCreateView$refreshPlayableItems(platformLibraryListViewNavFragment, sharedPreferences, list);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.PlatformLibraryListViewNavFragment$onCreateView$28, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass28 extends Lambda<Unit> implements Function1<PlatformEntity, Unit> {
        AnonymousClass28() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlatformEntity platformEntity) {
            invoke2(platformEntity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PlatformEntity platformEntity) {
            String customScreenAspectRatio;
            String customBoxArtAspectRatio;
            if (platformEntity != null) {
                PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment = PlatformLibraryListViewNavFragment.this;
                platformLibraryListViewNavFragment.platformEntity = platformEntity;
                if (platformEntity.getUseCustomScreenAspectRatio()) {
                    customScreenAspectRatio = platformEntity.getCustomScreenAspectRatio();
                } else {
                    List list = platformLibraryListViewNavFragment.screenAspectRatioList;
                    if (list == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("screenAspectRatioList");
                        list = null;
                    }
                    customScreenAspectRatio = (String) list.get(platformEntity.getScreenAspectRatioId());
                }
                platformLibraryListViewNavFragment.screenAspectRatio = customScreenAspectRatio;
                if (platformEntity.getUseCustomBoxArtAspectRatio()) {
                    customBoxArtAspectRatio = platformEntity.getCustomBoxArtAspectRatio();
                } else {
                    List list2 = platformLibraryListViewNavFragment.boxArtAspectRatioList;
                    if (list2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("boxArtAspectRatioList");
                        list2 = null;
                    }
                    customBoxArtAspectRatio = (String) list2.get(platformEntity.getBoxArtAspectRatioId());
                }
                platformLibraryListViewNavFragment.boxArtAspectRatio = customBoxArtAspectRatio;
                DaijishouViewModel model = platformLibraryListViewNavFragment.getModel();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = platformLibraryListViewNavFragment.platformFormatString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformFormatString");
                    str = null;
                }
                String shortname = platformEntity.getShortname();
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String upperCase = shortname.toUpperCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                String str2 = String.format(str, Arrays.copyOf(new Object[]{upperCase}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                DaijishouViewModel.setTips$default(model, str2, false, 2, null);
                platformLibraryListViewNavFragment.refreshPreview();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        String upperCase;
        String shortname;
        super.onResume();
        RecyclerView recyclerView = this.platformLibraryListRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerView");
            recyclerView = null;
        }
        recyclerView.requestFocus();
        DaijishouViewModel model = getModel();
        PlatformEntity platformEntity = this.platformEntity;
        if (platformEntity == null || (shortname = platformEntity.getShortname()) == null) {
            upperCase = null;
        } else {
            upperCase = shortname.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        }
        DaijishouViewModel.setTips$default(model, upperCase + " platform", false, 2, null);
    }
}
