package com.magneticchen.daijishou.nav_fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.core.view.ViewGroupKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.FragmentKt;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.PlatformNavFragment;
import com.magneticchen.daijishou.activities.MainActivity;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.application_data.StringPreference;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.dialog_fragments.PickPlatformSyncTreeUrDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment;
import com.magneticchen.daijishou.live_data.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.live_data.SharedPreferenceStringLiveData;
import com.magneticchen.daijishou.utils.PlaidColorUtils;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import com.magneticchen.daijishou.view_models.LibraryViewModel;
import com.magneticchen.daijishou.view_models.SynchronizationOfPlatform;
import com.magneticchen.daijishou.view_pager_selected_parameters.LibraryPageSelectedParameters;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: LibraryCollectionThumbnailsViewNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u009f\u00012\u00020\u0001:\u0004\u009f\u0001 \u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010}\u001a\u00020%H\u0016J\u0014\u0010~\u001a\u00020\u007f2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016J.\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00012\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016J%\u0010\u0088\u0001\u001a\u00020%2\u0007\u0010\u0089\u0001\u001a\u00020\b2\u0007\u0010\u008a\u0001\u001a\u00020\b2\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0016J\t\u0010\u008d\u0001\u001a\u00020\u007fH\u0016J\t\u0010\u008e\u0001\u001a\u00020\u007fH\u0016J\t\u0010\u008f\u0001\u001a\u00020\u007fH\u0016J\u001f\u0010\u0090\u0001\u001a\u00020\u007f2\b\u0010\u0091\u0001\u001a\u00030\u0083\u00012\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016J\t\u0010\u0092\u0001\u001a\u00020\u007fH\u0002J\t\u0010\u0093\u0001\u001a\u00020\u007fH\u0003J-\u0010\u0094\u0001\u001a\u00020\u007f2\u0007\u0010\u0095\u0001\u001a\u00020Q2\u0007\u0010\u0096\u0001\u001a\u00020Q2\u0007\u0010\u0097\u0001\u001a\u00020Q2\u0007\u0010\u0098\u0001\u001a\u00020QH\u0003J\t\u0010\u0099\u0001\u001a\u00020\u007fH\u0002J\t\u0010\u009a\u0001\u001a\u00020\u007fH\u0002J\t\u0010\u009b\u0001\u001a\u00020\u007fH\u0002J\u0015\u0010\u009c\u0001\u001a\u00020\u007f2\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\u001eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010;\u001a\u00060<R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010=\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\b?\u0010@R\u001b\u0010C\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010B\u001a\u0004\bE\u0010FR\u000e\u0010H\u001a\u00020IX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020N0MX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0SX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010T\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010UR\u000e\u0010V\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010]\u001a\u0010\u0012\f\u0012\n `*\u0004\u0018\u00010_0_0^X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020QX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020jX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010l\u001a\b\u0012\u0004\u0012\u00020m0MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010p\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010U\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001e\u0010u\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010U\u001a\u0004\bv\u0010r\"\u0004\bw\u0010tR\u000e\u0010x\u001a\u00020yX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020{X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020{X\u0082.¢\u0006\u0002\n\u0000¨\u0006¡\u0001"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionThumbnailsViewNavFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/PlatformNavFragment;", "()V", "addSyncTreesButton", "Lcom/google/android/material/chip/Chip;", "chipGroup", "Lcom/google/android/material/chip/ChipGroup;", "colorOnPrimary", "", "getColorOnPrimary", "()I", "setColorOnPrimary", "(I)V", "colorPrimary", "getColorPrimary", "setColorPrimary", "defaultChipBackgroundColors", "Landroid/content/res/ColorStateList;", "defaultChipTextColors", "defaultDownloadIconColors", "defaultMonoChipIconColors", "defaultThumbnailDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "descriptionFirstString", "", "descriptionItemCountFormatString", "descriptionPlatformIndexFormatString", "descriptionSecondString", "descriptionThirdString", "fadeInAnimation", "Landroid/view/animation/Animation;", "fadeOutAnimation", "favoriteButton", "favoriteFormatString", "firstContainerLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "hasRefreshedBefore", "", "getHasRefreshedBefore", "()Z", "setHasRefreshedBefore", "(Z)V", "horizontalScrollView", "Landroid/widget/HorizontalScrollView;", "imageViewAnimationIn", "getImageViewAnimationIn", "()Landroid/view/animation/Animation;", "setImageViewAnimationIn", "(Landroid/view/animation/Animation;)V", "imageViewAnimationOut", "isRefreshingAndUpdateThumbnail", "isRefreshingCurrentPlatform", "isRefreshingCurrentPlatformStatistic", "isRefreshingSyncStatus", "libraryChip", "libraryCollectionThumbnailsViewLayoutManager", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouLinearLayoutManager;", "libraryCollectionThumbnailsViewRecyclerView", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView;", "libraryCollectionThumbnailsViewRecyclerViewAdapter", "Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionThumbnailsViewNavFragment$LibraryCollectionThumbnailsViewRecyclerViewAdapter;", "libraryViewModel", "Lcom/magneticchen/daijishou/view_models/LibraryViewModel;", "getLibraryViewModel", "()Lcom/magneticchen/daijishou/view_models/LibraryViewModel;", "libraryViewModel$delegate", "Lkotlin/Lazy;", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "model$delegate", "navController", "Landroidx/navigation/NavController;", "newFormatString", "newlyAddedButton", "platformEntityList", "", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "platformFormatString", "platformId", "", "platformIdList", "", "previousSelectedPlatformIndex", "Ljava/lang/Integer;", "randomButton", "recentFormatString", "recentPlayedButton", "refocusOnScrolledToTop", "secondContainerLayout", "selectedPlatformEntity", "selectedPlatformIndex", "shareFileActivity", "Landroidx/activity/result/ActivityResultLauncher;", "Ljava/io/File;", "kotlin.jvm.PlatformType", "sharePlatformConfigString", "sharePlatformFavoriteItemsString", "shareString", "shortAnimationDuration", "slideInLeftAnimation", "slideInRightAnimation", "slideOutLeftAnimation", "slideOutRightAnimation", "smoothScroller", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "syncString", "synchronizationOfPlatformList", "Lcom/magneticchen/daijishou/view_models/SynchronizationOfPlatform;", "syncingFormatString", "syncingString", "themeBackgroundColor", "getThemeBackgroundColor", "()Ljava/lang/Integer;", "setThemeBackgroundColor", "(Ljava/lang/Integer;)V", "themeTextColor", "getThemeTextColor", "setThemeTextColor", "title", "Landroid/widget/TextSwitcher;", "titleFirst", "Landroid/widget/TextView;", "titleSecond", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHotKeyPressed", "hotkeyCode", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onKioskMode", "onNoneKioskMode", "onStart", "onViewCreated", "view", "refreshChipGroupNavigation", "refreshCurrentPlatform", "refreshCurrentPlatformStatistic", "platformItemCount", "recentPlayedCount", "favoriteCount", "newlyAddedCount", "refreshSyncStatus", "switchNext", "switchPrevious", "updateLightDarkDecorations", "bitmap", "Landroid/graphics/Bitmap;", "Companion", "LibraryCollectionThumbnailsViewRecyclerViewAdapter", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LibraryCollectionThumbnailsViewNavFragment extends PlatformNavFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int PLATFORM_LIBRARY_GRID_VIEW_MODE = 1;
    public static final int PLATFORM_LIBRARY_LIST_VIEW_MODE = 0;
    public static final float RECYCLER_VIEW_SCROLL_OFFSET = 32.0f;
    private static final Typeface typeface;
    private Chip addSyncTreesButton;
    private ChipGroup chipGroup;
    private ColorStateList defaultChipBackgroundColors;
    private ColorStateList defaultChipTextColors;
    private ColorStateList defaultDownloadIconColors;
    private ColorStateList defaultMonoChipIconColors;
    private BitmapDrawable defaultThumbnailDrawable;
    private String descriptionItemCountFormatString;
    private String descriptionPlatformIndexFormatString;
    private Animation fadeInAnimation;
    private Animation fadeOutAnimation;
    private Chip favoriteButton;
    private String favoriteFormatString;
    private ConstraintLayout firstContainerLayout;
    private boolean hasRefreshedBefore;
    private HorizontalScrollView horizontalScrollView;
    public Animation imageViewAnimationIn;
    private Animation imageViewAnimationOut;
    private boolean isRefreshingAndUpdateThumbnail;
    private boolean isRefreshingCurrentPlatform;
    private boolean isRefreshingCurrentPlatformStatistic;
    private boolean isRefreshingSyncStatus;
    private Chip libraryChip;
    private DaijishouLinearLayoutManager libraryCollectionThumbnailsViewLayoutManager;
    private DaijishouRecyclerView libraryCollectionThumbnailsViewRecyclerView;
    private LibraryCollectionThumbnailsViewRecyclerViewAdapter libraryCollectionThumbnailsViewRecyclerViewAdapter;

    /* JADX INFO: renamed from: libraryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy libraryViewModel;

    /* JADX INFO: renamed from: model$delegate, reason: from kotlin metadata */
    private final Lazy model;
    private NavController navController;
    private String newFormatString;
    private Chip newlyAddedButton;
    private final List<PlatformEntity> platformEntityList;
    private String platformFormatString;
    private Integer previousSelectedPlatformIndex;
    private Chip randomButton;
    private String recentFormatString;
    private Chip recentPlayedButton;
    private boolean refocusOnScrolledToTop;
    private ConstraintLayout secondContainerLayout;
    private PlatformEntity selectedPlatformEntity;
    private final ActivityResultLauncher<File> shareFileActivity;
    private String sharePlatformConfigString;
    private String sharePlatformFavoriteItemsString;
    private String shareString;
    private Animation slideInLeftAnimation;
    private Animation slideInRightAnimation;
    private Animation slideOutLeftAnimation;
    private Animation slideOutRightAnimation;
    private RecyclerView.SmoothScroller smoothScroller;
    private String syncString;
    private List<SynchronizationOfPlatform> synchronizationOfPlatformList;
    private String syncingFormatString;
    private String syncingString;
    private Integer themeBackgroundColor;
    private Integer themeTextColor;
    private TextSwitcher title;
    private TextView titleFirst;
    private TextView titleSecond;
    private String descriptionFirstString = "🕹 ️platform • ";
    private String descriptionSecondString = "0 items • ";
    private String descriptionThirdString = "platform 0 of 0";
    private long shortAnimationDuration = -1;
    private int colorPrimary = -1;
    private int colorOnPrimary = -1;
    private List<Long> platformIdList = CollectionsKt.emptyList();
    private long platformId = -1;
    private int selectedPlatformIndex = -1;

    private final void switchNext() {
    }

    private final void switchPrevious() {
    }

    public LibraryCollectionThumbnailsViewNavFragment() {
        LibraryCollectionThumbnailsViewNavFragment libraryCollectionThumbnailsViewNavFragment = this;
        this.libraryViewModel = FragmentViewModelLazyKt.createViewModelLazy(libraryCollectionThumbnailsViewNavFragment, Reflection.getOrCreateKotlinClass(LibraryViewModel.class), new LibraryCollectionThumbnailsViewNavFragment$special$$inlined$activityViewModels$default$1(libraryCollectionThumbnailsViewNavFragment), new LibraryCollectionThumbnailsViewNavFragment$special$$inlined$activityViewModels$default$2(null, libraryCollectionThumbnailsViewNavFragment), new LibraryCollectionThumbnailsViewNavFragment$special$$inlined$activityViewModels$default$3(libraryCollectionThumbnailsViewNavFragment));
        this.model = FragmentViewModelLazyKt.createViewModelLazy(libraryCollectionThumbnailsViewNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new LibraryCollectionThumbnailsViewNavFragment$special$$inlined$activityViewModels$default$4(libraryCollectionThumbnailsViewNavFragment), new LibraryCollectionThumbnailsViewNavFragment$special$$inlined$activityViewModels$default$5(null, libraryCollectionThumbnailsViewNavFragment), new LibraryCollectionThumbnailsViewNavFragment$special$$inlined$activityViewModels$default$6(libraryCollectionThumbnailsViewNavFragment));
        ActivityResultLauncher<File> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ShareFileContract(), new LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda0());
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.shareFileActivity = activityResultLauncherRegisterForActivityResult;
        this.platformEntityList = new ArrayList();
        this.synchronizationOfPlatformList = new ArrayList();
    }

    /* JADX INFO: compiled from: LibraryCollectionThumbnailsViewNavFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionThumbnailsViewNavFragment$Companion;", "", "()V", "PLATFORM_LIBRARY_GRID_VIEW_MODE", "", "PLATFORM_LIBRARY_LIST_VIEW_MODE", "RECYCLER_VIEW_SCROLL_OFFSET", "", "typeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "newInstance", "Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionThumbnailsViewNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LibraryCollectionThumbnailsViewNavFragment newInstance() {
            return new LibraryCollectionThumbnailsViewNavFragment();
        }
    }

    static {
        typeface = Build.VERSION.SDK_INT >= 28 ? Typeface.create(null, Constants.semiBolderWeight, false) : Typeface.defaultFromStyle(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LibraryViewModel getLibraryViewModel() {
        return (LibraryViewModel) this.libraryViewModel.getValue();
    }

    private final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model.getValue();
    }

    public final Animation getImageViewAnimationIn() {
        Animation animation = this.imageViewAnimationIn;
        if (animation != null) {
            return animation;
        }
        Intrinsics.throwUninitializedPropertyAccessException("imageViewAnimationIn");
        return null;
    }

    public final void setImageViewAnimationIn(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "<set-?>");
        this.imageViewAnimationIn = animation;
    }

    public final Integer getThemeTextColor() {
        return this.themeTextColor;
    }

    public final void setThemeTextColor(Integer num) {
        this.themeTextColor = num;
    }

    public final Integer getThemeBackgroundColor() {
        return this.themeBackgroundColor;
    }

    public final void setThemeBackgroundColor(Integer num) {
        this.themeBackgroundColor = num;
    }

    public final int getColorPrimary() {
        return this.colorPrimary;
    }

    public final void setColorPrimary(int i) {
        this.colorPrimary = i;
    }

    public final int getColorOnPrimary() {
        return this.colorOnPrimary;
    }

    public final void setColorOnPrimary(int i) {
        this.colorOnPrimary = i;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public void onKioskMode() {
        super.onKioskMode();
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public void onNoneKioskMode() {
        super.onNoneKioskMode();
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onHotKeyPressed(int hotkeyCode, int keyCode, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(hotkeyCode, keyCode, keyEvent);
        if (hotkeyCode == 1) {
            switchNext();
            return true;
        }
        if (hotkeyCode == 2) {
            switchPrevious();
            return true;
        }
        if (hotkeyCode == 3) {
            PlayableItemEntity playableItemRandomlyByAttachedPlatformIdAndVisibilityStatically$default = DaijishouLibraryModel.getPlayableItemRandomlyByAttachedPlatformIdAndVisibilityStatically$default(getDaijishouLibrary(), getLibraryViewModel().getSelectedPlatformId(), false, 2, null);
            if (playableItemRandomlyByAttachedPlatformIdAndVisibilityStatically$default == null) {
                return false;
            }
            PlayableItemDetailDialogFragment.INSTANCE.newInstance(playableItemRandomlyByAttachedPlatformIdAndVisibilityStatically$default).show(getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
            return true;
        }
        if (hotkeyCode != 4) {
            return false;
        }
        int i = getLibraryViewModel().getPreferences().getInt("view_mode", 0);
        NavController navController = null;
        if (i == 0) {
            NavController navController2 = this.navController;
            if (navController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
            } else {
                navController = navController2;
            }
            navController.navigate(R.id.libraryCollectionThumbnailsViewToPlatformLibraryListViewAction);
        } else if (i == 1) {
            NavController navController3 = this.navController;
            if (navController3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
            } else {
                navController = navController3;
            }
            navController.navigate(R.id.libraryCollectionThumbnailsViewToPlatformLibraryGridViewAction);
        }
        return true;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onBackPressed() {
        HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
        HorizontalScrollView horizontalScrollView2 = null;
        if (horizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
            horizontalScrollView = null;
        }
        if (horizontalScrollView.getScrollX() == 0) {
            return super.onBackPressed();
        }
        this.refocusOnScrolledToTop = true;
        HorizontalScrollView horizontalScrollView3 = this.horizontalScrollView;
        if (horizontalScrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
        } else {
            horizontalScrollView2 = horizontalScrollView3;
        }
        horizontalScrollView2.smoothScrollTo(0, 0);
        return false;
    }

    public final boolean getHasRefreshedBefore() {
        return this.hasRefreshedBefore;
    }

    public final void setHasRefreshedBefore(boolean z) {
        this.hasRefreshedBefore = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:74:0x014e  */
    /* JADX WARN: Code duplicated, block: B:76:0x0152  */
    /* JADX WARN: Code duplicated, block: B:79:0x015d  */
    public final void refreshCurrentPlatform() {
        TextSwitcher textSwitcher;
        TextSwitcher textSwitcher2;
        if (this.isRefreshingCurrentPlatform) {
            return;
        }
        this.isRefreshingCurrentPlatform = true;
        int iIndexOf = this.platformIdList.indexOf(Long.valueOf(this.platformId));
        this.selectedPlatformIndex = iIndexOf;
        if (iIndexOf != -1) {
            PlatformEntity platformEntity = this.platformEntityList.get(iIndexOf);
            this.selectedPlatformEntity = platformEntity;
            if (platformEntity != null) {
                FragmentActivity fragmentActivityRequireActivity = requireActivity();
                Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.magneticchen.daijishou.activities.MainActivity");
                String str = null;
                ((MainActivity) fragmentActivityRequireActivity).useDefaultWallpaper(null, false);
                LibraryCollectionThumbnailsViewRecyclerViewAdapter libraryCollectionThumbnailsViewRecyclerViewAdapter = this.libraryCollectionThumbnailsViewRecyclerViewAdapter;
                if (libraryCollectionThumbnailsViewRecyclerViewAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionThumbnailsViewRecyclerViewAdapter");
                    libraryCollectionThumbnailsViewRecyclerViewAdapter = null;
                }
                libraryCollectionThumbnailsViewRecyclerViewAdapter.selectPosition(this.selectedPlatformIndex);
                if (this.hasRefreshedBefore) {
                    RecyclerView.SmoothScroller smoothScroller = this.smoothScroller;
                    if (smoothScroller == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("smoothScroller");
                        smoothScroller = null;
                    }
                    smoothScroller.setTargetPosition(Math.max(0, this.selectedPlatformIndex));
                    DaijishouLinearLayoutManager daijishouLinearLayoutManager = this.libraryCollectionThumbnailsViewLayoutManager;
                    if (daijishouLinearLayoutManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionThumbnailsViewLayoutManager");
                        daijishouLinearLayoutManager = null;
                    }
                    if (!daijishouLinearLayoutManager.isSmoothScrolling()) {
                        DaijishouLinearLayoutManager daijishouLinearLayoutManager2 = this.libraryCollectionThumbnailsViewLayoutManager;
                        if (daijishouLinearLayoutManager2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionThumbnailsViewLayoutManager");
                            daijishouLinearLayoutManager2 = null;
                        }
                        RecyclerView.SmoothScroller smoothScroller2 = this.smoothScroller;
                        if (smoothScroller2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("smoothScroller");
                            smoothScroller2 = null;
                        }
                        daijishouLinearLayoutManager2.startSmoothScroll(smoothScroller2);
                    }
                } else {
                    DaijishouLinearLayoutManager daijishouLinearLayoutManager3 = this.libraryCollectionThumbnailsViewLayoutManager;
                    if (daijishouLinearLayoutManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionThumbnailsViewLayoutManager");
                        daijishouLinearLayoutManager3 = null;
                    }
                    daijishouLinearLayoutManager3.scrollToPosition(Math.max(0, this.selectedPlatformIndex));
                }
                this.hasRefreshedBefore = true;
                DaijishouViewModel model = getModel();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str2 = this.platformFormatString;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformFormatString");
                    str2 = null;
                }
                String shortname = platformEntity.getShortname();
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String upperCase = shortname.toUpperCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                String str3 = String.format(str2, Arrays.copyOf(new Object[]{upperCase}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                DaijishouViewModel.setTips$default(model, str3, false, 2, null);
                Integer num = this.previousSelectedPlatformIndex;
                if (num != null) {
                    int i = this.selectedPlatformIndex;
                    if (num != null && num.intValue() == i) {
                        textSwitcher = this.title;
                        if (textSwitcher == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("title");
                            textSwitcher = null;
                        }
                        textSwitcher.setInAnimation(null);
                        textSwitcher2 = this.title;
                        if (textSwitcher2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("title");
                            textSwitcher2 = null;
                        }
                        textSwitcher2.setOutAnimation(null);
                    } else {
                        Integer num2 = this.previousSelectedPlatformIndex;
                        Intrinsics.checkNotNull(num2);
                        if (num2.intValue() < this.selectedPlatformIndex) {
                            TextSwitcher textSwitcher3 = this.title;
                            if (textSwitcher3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("title");
                                textSwitcher3 = null;
                            }
                            Animation animation = this.slideInRightAnimation;
                            if (animation == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("slideInRightAnimation");
                                animation = null;
                            }
                            textSwitcher3.setInAnimation(animation);
                            TextSwitcher textSwitcher4 = this.title;
                            if (textSwitcher4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("title");
                                textSwitcher4 = null;
                            }
                            Animation animation2 = this.slideOutLeftAnimation;
                            if (animation2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("slideOutLeftAnimation");
                                animation2 = null;
                            }
                            textSwitcher4.setOutAnimation(animation2);
                        } else {
                            Integer num3 = this.previousSelectedPlatformIndex;
                            Intrinsics.checkNotNull(num3);
                            if (num3.intValue() > this.selectedPlatformIndex) {
                                TextSwitcher textSwitcher5 = this.title;
                                if (textSwitcher5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("title");
                                    textSwitcher5 = null;
                                }
                                Animation animation3 = this.slideInLeftAnimation;
                                if (animation3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("slideInLeftAnimation");
                                    animation3 = null;
                                }
                                textSwitcher5.setInAnimation(animation3);
                                TextSwitcher textSwitcher6 = this.title;
                                if (textSwitcher6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("title");
                                    textSwitcher6 = null;
                                }
                                Animation animation4 = this.slideOutRightAnimation;
                                if (animation4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("slideOutRightAnimation");
                                    animation4 = null;
                                }
                                textSwitcher6.setOutAnimation(animation4);
                            }
                        }
                    }
                } else {
                    textSwitcher = this.title;
                    if (textSwitcher == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("title");
                        textSwitcher = null;
                    }
                    textSwitcher.setInAnimation(null);
                    textSwitcher2 = this.title;
                    if (textSwitcher2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("title");
                        textSwitcher2 = null;
                    }
                    textSwitcher2.setOutAnimation(null);
                }
                TextSwitcher textSwitcher7 = this.title;
                if (textSwitcher7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                    textSwitcher7 = null;
                }
                textSwitcher7.setText(platformEntity.getName());
                TextSwitcher textSwitcher8 = this.title;
                if (textSwitcher8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                    textSwitcher8 = null;
                }
                textSwitcher8.requestLayout();
                this.previousSelectedPlatformIndex = Integer.valueOf(this.selectedPlatformIndex);
                String shortname2 = platformEntity.getShortname();
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                String upperCase2 = shortname2.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                this.descriptionFirstString = "🕹 ️" + upperCase2 + " • ";
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str4 = this.descriptionPlatformIndexFormatString;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("descriptionPlatformIndexFormatString");
                } else {
                    str = str4;
                }
                String str5 = String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(this.selectedPlatformIndex + 1), Integer.valueOf(this.platformEntityList.size())}, 2));
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                this.descriptionThirdString = str5;
            }
        }
        this.isRefreshingCurrentPlatform = false;
    }

    private final void refreshChipGroupNavigation() {
        ArrayList arrayList = new ArrayList();
        ChipGroup chipGroup = this.chipGroup;
        ChipGroup chipGroup2 = null;
        if (chipGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
            chipGroup = null;
        }
        for (View view : com.magneticchen.daijishou.support.DaijishouSupport.iterable(ViewGroupKt.getChildren(chipGroup))) {
            if (view.getVisibility() == 0) {
                arrayList.add(view);
            }
        }
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view2 = (View) obj;
            if (i == 0) {
                if (getIsKioskMode()) {
                    ArrayList arrayList2 = arrayList;
                    if (arrayList2.size() > 1) {
                        view2.setNextFocusLeftId(((View) arrayList.get(arrayList2.size() - 2)).getId());
                    }
                }
            } else {
                Chip chip = this.libraryChip;
                if (chip == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("libraryChip");
                    chip = null;
                }
                if (!Intrinsics.areEqual(view2, chip)) {
                    Chip chip2 = this.randomButton;
                    if (chip2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("randomButton");
                        chip2 = null;
                    }
                    if (!Intrinsics.areEqual(view2, chip2)) {
                        if (i != arrayList.size() - 2) {
                            view2.setNextFocusRightId(-1);
                        } else if (getIsKioskMode()) {
                            Chip chip3 = this.libraryChip;
                            if (chip3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("libraryChip");
                                chip3 = null;
                            }
                            view2.setNextFocusRightId(chip3.getId());
                        }
                    }
                }
            }
            i = i2;
        }
        ChipGroup chipGroup3 = this.chipGroup;
        if (chipGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
            chipGroup3 = null;
        }
        Iterator<View> it = com.magneticchen.daijishou.support.DaijishouSupport.iterable(ViewGroupKt.getChildren(chipGroup3)).iterator();
        while (it.hasNext()) {
            it.next().requestLayout();
        }
        ChipGroup chipGroup4 = this.chipGroup;
        if (chipGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
        } else {
            chipGroup2 = chipGroup4;
        }
        chipGroup2.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshCurrentPlatformStatistic(long platformItemCount, long recentPlayedCount, long favoriteCount, long newlyAddedCount) {
        if (this.isRefreshingCurrentPlatformStatistic) {
            return;
        }
        this.isRefreshingCurrentPlatformStatistic = true;
        Chip chip = this.recentPlayedButton;
        String str = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = this.recentFormatString;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentFormatString");
            str2 = null;
        }
        String str3 = String.format(str2, Arrays.copyOf(new Object[]{Long.valueOf(recentPlayedCount)}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
        chip.setText(str3);
        Chip chip2 = this.recentPlayedButton;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip2 = null;
        }
        chip2.setFocusable(0);
        Chip chip3 = this.recentPlayedButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip3 = null;
        }
        chip3.setVisibility(recentPlayedCount > 0 ? 0 : 8);
        Chip chip4 = this.recentPlayedButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip4 = null;
        }
        chip4.setFocusable(1);
        Chip chip5 = this.favoriteButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip5 = null;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str4 = this.favoriteFormatString;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteFormatString");
            str4 = null;
        }
        String str5 = String.format(str4, Arrays.copyOf(new Object[]{Long.valueOf(favoriteCount)}, 1));
        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
        chip5.setText(str5);
        Chip chip6 = this.favoriteButton;
        if (chip6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip6 = null;
        }
        chip6.setFocusable(0);
        Chip chip7 = this.favoriteButton;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip7 = null;
        }
        chip7.setVisibility(favoriteCount > 0 ? 0 : 8);
        Chip chip8 = this.favoriteButton;
        if (chip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip8 = null;
        }
        chip8.setFocusable(1);
        Chip chip9 = this.newlyAddedButton;
        if (chip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip9 = null;
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String str6 = this.newFormatString;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newFormatString");
            str6 = null;
        }
        String str7 = String.format(str6, Arrays.copyOf(new Object[]{Long.valueOf(newlyAddedCount)}, 1));
        Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
        chip9.setText(str7);
        Chip chip10 = this.newlyAddedButton;
        if (chip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip10 = null;
        }
        chip10.setFocusable(0);
        Chip chip11 = this.newlyAddedButton;
        if (chip11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip11 = null;
        }
        chip11.setVisibility(newlyAddedCount > 0 ? 0 : 8);
        Chip chip12 = this.newlyAddedButton;
        if (chip12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip12 = null;
        }
        chip12.setFocusable(1);
        refreshChipGroupNavigation();
        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
        String str8 = this.descriptionItemCountFormatString;
        if (str8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionItemCountFormatString");
        } else {
            str = str8;
        }
        String str9 = String.format(str, Arrays.copyOf(new Object[]{Long.valueOf(platformItemCount)}, 1));
        Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
        this.descriptionSecondString = str9;
        this.isRefreshingCurrentPlatformStatistic = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshSyncStatus() {
        if (this.isRefreshingSyncStatus) {
            return;
        }
        this.isRefreshingSyncStatus = true;
        List<SynchronizationOfPlatform> list = this.synchronizationOfPlatformList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((SynchronizationOfPlatform) obj).getPlatformId() == this.platformId) {
                arrayList.add(obj);
            }
        }
        this.isRefreshingSyncStatus = false;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        String string = getString(R.string.sync);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.syncString = string;
        String string2 = getString(R.string.syncing);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.syncingString = string2;
        String string3 = getString(R.string.syncing_format);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.syncingFormatString = string3;
        String string4 = getString(R.string.description_items_count_format);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        this.descriptionItemCountFormatString = string4;
        String string5 = getString(R.string.description_platform_index_format);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        this.descriptionPlatformIndexFormatString = string5;
        String string6 = getString(R.string.share);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        this.shareString = string6;
        String string7 = getString(R.string.share_platform_config_string);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        this.sharePlatformConfigString = string7;
        String string8 = getString(R.string.share_platform_favorite_items_string);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        this.sharePlatformFavoriteItemsString = string8;
        String string9 = getString(R.string.platform_format);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        this.platformFormatString = string9;
        String string10 = getString(R.string.favorite_format);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        this.favoriteFormatString = string10;
        String string11 = getString(R.string.recent_format);
        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
        this.recentFormatString = string11;
        String string12 = getString(R.string.new_format);
        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
        this.newFormatString = string12;
        this.shortAnimationDuration = getResources().getInteger(android.R.integer.config_shortAnimTime);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(contextRequireContext, android.R.anim.fade_in);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation, "loadAnimation(...)");
        this.fadeInAnimation = animationLoadAnimation;
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(contextRequireContext, android.R.anim.fade_out);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation2, "loadAnimation(...)");
        this.fadeOutAnimation = animationLoadAnimation2;
        Animation animation = this.fadeInAnimation;
        Animation animation2 = null;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fadeInAnimation");
            animation = null;
        }
        animation.setDuration(this.shortAnimationDuration);
        Animation animation3 = this.fadeOutAnimation;
        if (animation3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fadeOutAnimation");
            animation3 = null;
        }
        animation3.setDuration(this.shortAnimationDuration);
        Animation animationLoadAnimation3 = AnimationUtils.loadAnimation(contextRequireContext, R.anim.slide_in_right);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation3, "loadAnimation(...)");
        this.slideInRightAnimation = animationLoadAnimation3;
        Animation animationLoadAnimation4 = AnimationUtils.loadAnimation(contextRequireContext, R.anim.slide_out_left);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation4, "loadAnimation(...)");
        this.slideOutLeftAnimation = animationLoadAnimation4;
        Animation animation4 = this.slideInRightAnimation;
        if (animation4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slideInRightAnimation");
            animation4 = null;
        }
        animation4.setDuration(this.shortAnimationDuration);
        Animation animation5 = this.slideOutLeftAnimation;
        if (animation5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slideOutLeftAnimation");
            animation5 = null;
        }
        animation5.setDuration(this.shortAnimationDuration);
        Animation animationLoadAnimation5 = AnimationUtils.loadAnimation(contextRequireContext, android.R.anim.slide_in_left);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation5, "loadAnimation(...)");
        this.slideInLeftAnimation = animationLoadAnimation5;
        Animation animationLoadAnimation6 = AnimationUtils.loadAnimation(contextRequireContext, android.R.anim.slide_out_right);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation6, "loadAnimation(...)");
        this.slideOutRightAnimation = animationLoadAnimation6;
        Animation animation6 = this.slideInLeftAnimation;
        if (animation6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slideInLeftAnimation");
            animation6 = null;
        }
        animation6.setDuration(this.shortAnimationDuration);
        Animation animation7 = this.slideOutRightAnimation;
        if (animation7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slideOutRightAnimation");
            animation7 = null;
        }
        animation7.setDuration(this.shortAnimationDuration);
        Drawable drawable = ContextCompat.getDrawable(fragmentActivityRequireActivity, R.drawable.ic_polka_dots);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), drawable != null ? DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null) : null);
        this.defaultThumbnailDrawable = bitmapDrawable;
        bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
        BitmapDrawable bitmapDrawable2 = this.defaultThumbnailDrawable;
        if (bitmapDrawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultThumbnailDrawable");
            bitmapDrawable2 = null;
        }
        bitmapDrawable2.setTileModeY(Shader.TileMode.REPEAT);
        ColorStateList colorStateList = ContextCompat.getColorStateList(contextRequireContext, R.color.chip_normal_text_color);
        Intrinsics.checkNotNull(colorStateList);
        this.defaultChipTextColors = colorStateList;
        ColorStateList colorStateList2 = ContextCompat.getColorStateList(contextRequireContext, R.color.chip_normal_background_color);
        Intrinsics.checkNotNull(colorStateList2);
        this.defaultChipBackgroundColors = colorStateList2;
        ColorStateList colorStateList3 = ContextCompat.getColorStateList(contextRequireContext, R.color.chip_mono_icon_color);
        Intrinsics.checkNotNull(colorStateList3);
        this.defaultMonoChipIconColors = colorStateList3;
        ColorStateList colorStateList4 = ContextCompat.getColorStateList(contextRequireContext, R.color.download_icon_color);
        Intrinsics.checkNotNull(colorStateList4);
        this.defaultDownloadIconColors = colorStateList4;
        this.smoothScroller = new AnonymousClass1(contextRequireContext);
        Animation animationLoadAnimation7 = AnimationUtils.loadAnimation(contextRequireContext, android.R.anim.fade_out);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation7, "loadAnimation(...)");
        this.imageViewAnimationOut = animationLoadAnimation7;
        if (animationLoadAnimation7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageViewAnimationOut");
        } else {
            animation2 = animationLoadAnimation7;
        }
        animation2.setDuration(60L);
        Animation animationLoadAnimation8 = AnimationUtils.loadAnimation(contextRequireContext, android.R.anim.fade_in);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation8, "loadAnimation(...)");
        setImageViewAnimationIn(animationLoadAnimation8);
        getImageViewAnimationIn().setDuration(60L);
        this.hasRefreshedBefore = false;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.LibraryCollectionThumbnailsViewNavFragment$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryCollectionThumbnailsViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, d2 = {"com/magneticchen/daijishou/nav_fragments/LibraryCollectionThumbnailsViewNavFragment$onCreate$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "getHorizontalSnapPreference", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass1 extends LinearSmoothScroller {
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int getHorizontalSnapPreference() {
            return -1;
        }

        AnonymousClass1(Context context) {
            super(context);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity appCompatActivity = (AppCompatActivity) fragmentActivityRequireActivity;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f = displayMetrics.heightPixels / displayMetrics.widthPixels;
        if (f < 1.0f) {
            f = 1.0f / f;
        }
        SharedPreferences preferences = getLibraryViewModel().getPreferences();
        LiveData<List<PlatformEntity>> allVisiblePlatformsOrderedByShortName = getDaijishouLibrary().getAllVisiblePlatformsOrderedByShortName();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = getDefaultSharedPreferences().getBoolean(BooleanPreference.ENFORCE_PLATFORM_CARD_ASPECT_RATIO.getKey(), BooleanPreference.ENFORCE_PLATFORM_CARD_ASPECT_RATIO.getDefaultValue());
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        booleanRef2.element = getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_AUTO_THEME_COLOR.getKey(), BooleanPreference.USE_AUTO_THEME_COLOR.getDefaultValue());
        View viewInflate = inflater.inflate(R.layout.fragment_library_collection_thumbnails_view, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.library_collection_thumbnails_view_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.libraryCollectionThumbnailsViewRecyclerView = (DaijishouRecyclerView) viewFindViewById;
        this.libraryCollectionThumbnailsViewRecyclerViewAdapter = new LibraryCollectionThumbnailsViewRecyclerViewAdapter(this, contextRequireContext, this.platformEntityList);
        this.libraryCollectionThumbnailsViewLayoutManager = new DaijishouLinearLayoutManager(contextRequireContext, 0, false);
        View viewFindViewById2 = viewInflate.findViewById(R.id.library_collection_thumbnails_view_first_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.firstContainerLayout = (ConstraintLayout) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.library_collection_thumbnails_view_second_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.secondContainerLayout = (ConstraintLayout) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.library_collection_thumbnails_view_platform_title_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.title = (TextSwitcher) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.library_collection_thumbnails_view_platform_title_first_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.titleFirst = (TextView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.library_collection_thumbnails_view_platform_title_second_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.titleSecond = (TextView) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.library_collection_thumbnails_view_horizontal_scroll_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.horizontalScrollView = (HorizontalScrollView) viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(R.id.fragment_library_collection_thumbnails_view_chip_group);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.chipGroup = (ChipGroup) viewFindViewById8;
        View viewFindViewById9 = viewInflate.findViewById(R.id.library_collection_thumbnails_view_platform_lib_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.libraryChip = (Chip) viewFindViewById9;
        View viewFindViewById10 = viewInflate.findViewById(R.id.library_collection_thumbnails_view_platform_random_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.randomButton = (Chip) viewFindViewById10;
        View viewFindViewById11 = viewInflate.findViewById(R.id.library_collection_thumbnails_view_platform_add_sync_trees_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.addSyncTreesButton = (Chip) viewFindViewById11;
        View viewFindViewById12 = viewInflate.findViewById(R.id.library_collection_thumbnails_view_platform_recent_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.recentPlayedButton = (Chip) viewFindViewById12;
        View viewFindViewById13 = viewInflate.findViewById(R.id.library_collection_thumbnails_view_platform_favorite_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.favoriteButton = (Chip) viewFindViewById13;
        View viewFindViewById14 = viewInflate.findViewById(R.id.library_collection_thumbnails_view_platform_newly_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.newlyAddedButton = (Chip) viewFindViewById14;
        this.navController = FragmentKt.findNavController(this);
        this.platformIdList = CollectionsKt.emptyList();
        this.platformEntityList.clear();
        DaijishouLinearLayoutManager daijishouLinearLayoutManager = this.libraryCollectionThumbnailsViewLayoutManager;
        NavController navController = null;
        if (daijishouLinearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionThumbnailsViewLayoutManager");
            daijishouLinearLayoutManager = null;
        }
        daijishouLinearLayoutManager.setShakeOnFocusBound(true);
        DaijishouLinearLayoutManager daijishouLinearLayoutManager2 = this.libraryCollectionThumbnailsViewLayoutManager;
        if (daijishouLinearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionThumbnailsViewLayoutManager");
            daijishouLinearLayoutManager2 = null;
        }
        daijishouLinearLayoutManager2.setFocusBoundStart(true);
        DaijishouLinearLayoutManager daijishouLinearLayoutManager3 = this.libraryCollectionThumbnailsViewLayoutManager;
        if (daijishouLinearLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionThumbnailsViewLayoutManager");
            daijishouLinearLayoutManager3 = null;
        }
        daijishouLinearLayoutManager3.setFocusBoundEnd(true);
        DaijishouLinearLayoutManager daijishouLinearLayoutManager4 = this.libraryCollectionThumbnailsViewLayoutManager;
        if (daijishouLinearLayoutManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionThumbnailsViewLayoutManager");
            daijishouLinearLayoutManager4 = null;
        }
        daijishouLinearLayoutManager4.setFocusBoundEdge(false);
        DaijishouRecyclerView daijishouRecyclerView = this.libraryCollectionThumbnailsViewRecyclerView;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionThumbnailsViewRecyclerView");
            daijishouRecyclerView = null;
        }
        DaijishouLinearLayoutManager daijishouLinearLayoutManager5 = this.libraryCollectionThumbnailsViewLayoutManager;
        if (daijishouLinearLayoutManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionThumbnailsViewLayoutManager");
            daijishouLinearLayoutManager5 = null;
        }
        daijishouRecyclerView.setLayoutManager(daijishouLinearLayoutManager5);
        DaijishouRecyclerView daijishouRecyclerView2 = this.libraryCollectionThumbnailsViewRecyclerView;
        if (daijishouRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionThumbnailsViewRecyclerView");
            daijishouRecyclerView2 = null;
        }
        LibraryCollectionThumbnailsViewRecyclerViewAdapter libraryCollectionThumbnailsViewRecyclerViewAdapter = this.libraryCollectionThumbnailsViewRecyclerViewAdapter;
        if (libraryCollectionThumbnailsViewRecyclerViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionThumbnailsViewRecyclerViewAdapter");
            libraryCollectionThumbnailsViewRecyclerViewAdapter = null;
        }
        daijishouRecyclerView2.setAdapter(libraryCollectionThumbnailsViewRecyclerViewAdapter);
        if (f > 2.1111112f) {
            ConstraintLayout constraintLayout = this.firstContainerLayout;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firstContainerLayout");
                constraintLayout = null;
            }
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams).dimensionRatio = Constants.layoutDimensionRatio;
            ConstraintLayout constraintLayout2 = this.firstContainerLayout;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firstContainerLayout");
                constraintLayout2 = null;
            }
            constraintLayout2.requestLayout();
        }
        HorizontalScrollView horizontalScrollView = this.horizontalScrollView;
        if (horizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
            horizontalScrollView = null;
        }
        horizontalScrollView.setOnScrollChangeListener(new LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda5(this));
        Chip chip = this.libraryChip;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryChip");
            chip = null;
        }
        chip.setTypeface(null, 3);
        Chip chip2 = this.randomButton;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("randomButton");
            chip2 = null;
        }
        chip2.setTypeface(null, 1);
        Chip chip3 = this.addSyncTreesButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addSyncTreesButton");
            chip3 = null;
        }
        chip3.setTypeface(null, 1);
        Chip chip4 = this.recentPlayedButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip4 = null;
        }
        Typeface typeface2 = typeface;
        chip4.setTypeface(typeface2);
        Chip chip5 = this.favoriteButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip5 = null;
        }
        chip5.setTypeface(typeface2);
        Chip chip6 = this.newlyAddedButton;
        if (chip6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip6 = null;
        }
        chip6.setTypeface(typeface2);
        Chip chip7 = this.libraryChip;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryChip");
            chip7 = null;
        }
        chip7.setOnFocusChangeListener(new LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda9());
        Chip chip8 = this.randomButton;
        if (chip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("randomButton");
            chip8 = null;
        }
        chip8.setOnFocusChangeListener(new LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda10());
        Chip chip9 = this.addSyncTreesButton;
        if (chip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addSyncTreesButton");
            chip9 = null;
        }
        chip9.setOnFocusChangeListener(new LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda11());
        Chip chip10 = this.recentPlayedButton;
        if (chip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip10 = null;
        }
        chip10.setOnFocusChangeListener(new LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda12());
        Chip chip11 = this.favoriteButton;
        if (chip11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip11 = null;
        }
        chip11.setOnFocusChangeListener(new LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda13());
        Chip chip12 = this.newlyAddedButton;
        if (chip12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip12 = null;
        }
        chip12.setOnFocusChangeListener(new LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda1());
        Chip chip13 = this.libraryChip;
        if (chip13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryChip");
            chip13 = null;
        }
        chip13.setOnClickListener(new LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda2(preferences, this));
        Chip chip14 = this.randomButton;
        if (chip14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("randomButton");
            chip14 = null;
        }
        chip14.setOnClickListener(new LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda3(this));
        Chip chip15 = this.addSyncTreesButton;
        if (chip15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addSyncTreesButton");
            chip15 = null;
        }
        chip15.setOnClickListener(new LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda4(this));
        Chip chip16 = this.recentPlayedButton;
        if (chip16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentPlayedButton");
            chip16 = null;
        }
        chip16.setOnClickListener(new LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda6(appCompatActivity, this));
        Chip chip17 = this.favoriteButton;
        if (chip17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip17 = null;
        }
        chip17.setOnClickListener(new LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda7(appCompatActivity, this));
        Chip chip18 = this.newlyAddedButton;
        if (chip18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyAddedButton");
            chip18 = null;
        }
        chip18.setOnClickListener(new LibraryCollectionThumbnailsViewNavFragment$$ExternalSyntheticLambda8(appCompatActivity, this));
        LibraryCollectionThumbnailsViewRecyclerViewAdapter libraryCollectionThumbnailsViewRecyclerViewAdapter2 = this.libraryCollectionThumbnailsViewRecyclerViewAdapter;
        if (libraryCollectionThumbnailsViewRecyclerViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionThumbnailsViewRecyclerViewAdapter");
            libraryCollectionThumbnailsViewRecyclerViewAdapter2 = null;
        }
        libraryCollectionThumbnailsViewRecyclerViewAdapter2.setOnItemSelectListener(new AnonymousClass14());
        LibraryCollectionThumbnailsViewRecyclerViewAdapter libraryCollectionThumbnailsViewRecyclerViewAdapter3 = this.libraryCollectionThumbnailsViewRecyclerViewAdapter;
        if (libraryCollectionThumbnailsViewRecyclerViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionThumbnailsViewRecyclerViewAdapter");
            libraryCollectionThumbnailsViewRecyclerViewAdapter3 = null;
        }
        libraryCollectionThumbnailsViewRecyclerViewAdapter3.setOnItemClickListener(new AnonymousClass15(preferences, this));
        NavController navController2 = this.navController;
        if (navController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
        } else {
            navController = navController2;
        }
        navController.getGraph().setStartDestination(R.id.libraryCollectionThumbnailsViewNavFragment);
        getLibraryViewModel().getSelectedPlatformIdLiveData().observe(getViewLifecycleOwner(), new LibraryCollectionThumbnailsViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass16()));
        getLibraryViewModel().getSelectedPlatformStatistics().observe(getViewLifecycleOwner(), new LibraryCollectionThumbnailsViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass17()));
        allVisiblePlatformsOrderedByShortName.observe(getViewLifecycleOwner(), new LibraryCollectionThumbnailsViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass18()));
        new SharedPreferenceStringLiveData(getDefaultSharedPreferences(), StringPreference.LIBRARY_COLLECTION_VIEW_MODE.getKey(), StringPreference.LIBRARY_COLLECTION_VIEW_MODE.getDefaultValue()).observe(getViewLifecycleOwner(), new LibraryCollectionThumbnailsViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass19()));
        getDaijishouSynchronization().getSynchronizationOfPlatformListLiveData().observe(getViewLifecycleOwner(), new LibraryCollectionThumbnailsViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass20()));
        getDaijishouSynchronization().getOnSynchronizationFinishedLiveData().observe(getViewLifecycleOwner(), new LibraryCollectionThumbnailsViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass21()));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.USE_AUTO_THEME_COLOR.getKey(), BooleanPreference.USE_AUTO_THEME_COLOR.getDefaultValue()).observe(getViewLifecycleOwner(), new LibraryCollectionThumbnailsViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass22(booleanRef2)));
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(contextRequireContext);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        new SharedPreferenceBooleanLiveData(defaultSharedPreferences, BooleanPreference.ENFORCE_PLATFORM_CARD_ASPECT_RATIO.getKey(), BooleanPreference.ENFORCE_PLATFORM_CARD_ASPECT_RATIO.getDefaultValue()).observe(getViewLifecycleOwner(), new LibraryCollectionThumbnailsViewNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass23(booleanRef, this)));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7(LibraryCollectionThumbnailsViewNavFragment this$0, View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.refocusOnScrolledToTop) {
            HorizontalScrollView horizontalScrollView = this$0.horizontalScrollView;
            if (horizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("horizontalScrollView");
                horizontalScrollView = null;
            }
            if (horizontalScrollView.getScrollY() == 0) {
                this$0.refocusOnScrolledToTop = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$8(View view, boolean z) {
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
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, true, 8, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, true, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$12(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, true, 8, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, true, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$13(View view, boolean z) {
        if (z) {
            Utils utils = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils, view, 1.0f, 1.03f, 0L, true, 8, null);
        } else {
            Utils utils2 = Utils.INSTANCE;
            Intrinsics.checkNotNull(view);
            Utils.scaleView$default(utils2, view, 1.03f, 1.0f, 0L, true, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$15(SharedPreferences platformLibrarySharedPreferences, LibraryCollectionThumbnailsViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(platformLibrarySharedPreferences, "$platformLibrarySharedPreferences");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = platformLibrarySharedPreferences.getInt("view_mode", 0);
        NavController navController = null;
        if (i == 0) {
            NavController navController2 = this$0.navController;
            if (navController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                navController2 = null;
            }
            NavDestination currentDestination = navController2.getCurrentDestination();
            if (currentDestination == null || currentDestination.getId() != R.id.libraryCollectionThumbnailsViewNavFragment) {
                return;
            }
            NavController navController3 = this$0.navController;
            if (navController3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
            } else {
                navController = navController3;
            }
            navController.navigate(R.id.libraryCollectionThumbnailsViewToPlatformLibraryListViewAction);
            return;
        }
        if (i != 1) {
            return;
        }
        NavController navController4 = this$0.navController;
        if (navController4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController4 = null;
        }
        NavDestination currentDestination2 = navController4.getCurrentDestination();
        if (currentDestination2 == null || currentDestination2.getId() != R.id.libraryCollectionThumbnailsViewNavFragment) {
            return;
        }
        NavController navController5 = this$0.navController;
        if (navController5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
        } else {
            navController = navController5;
        }
        navController.navigate(R.id.libraryCollectionThumbnailsViewToPlatformLibraryGridViewAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$16(LibraryCollectionThumbnailsViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemRandomlyByAttachedPlatformIdStatically = this$0.getDaijishouLibrary().getPlayableItemRandomlyByAttachedPlatformIdStatically(this$0.getLibraryViewModel().getSelectedPlatformId());
        if (playableItemRandomlyByAttachedPlatformIdStatically == null) {
            return;
        }
        PlayableItemDetailDialogFragment.INSTANCE.newInstance(playableItemRandomlyByAttachedPlatformIdStatically).show(this$0.getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$17(LibraryCollectionThumbnailsViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PickPlatformSyncTreeUrDialogFragment.Companion companion = PickPlatformSyncTreeUrDialogFragment.INSTANCE;
        PlatformEntity platformEntity = this$0.selectedPlatformEntity;
        Intrinsics.checkNotNull(platformEntity);
        companion.newInstance(platformEntity).show(this$0.getChildFragmentManager(), PickPlatformSyncTreeUrDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$18(AppCompatActivity activity, LibraryCollectionThumbnailsViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((MainActivity) activity).navigatePage("library", new LibraryPageSelectedParameters(2, this$0.platformId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$19(AppCompatActivity activity, LibraryCollectionThumbnailsViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((MainActivity) activity).navigatePage("library", new LibraryPageSelectedParameters(1, this$0.platformId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$20(AppCompatActivity activity, LibraryCollectionThumbnailsViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((MainActivity) activity).navigatePage("library", new LibraryPageSelectedParameters(3, this$0.platformId));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.LibraryCollectionThumbnailsViewNavFragment$onCreateView$14, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryCollectionThumbnailsViewNavFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass14 extends Lambda<Unit> implements Function4<View, Integer, Long, PlatformEntity, Unit> {
        AnonymousClass14() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlatformEntity platformEntity) {
            invoke(view, num.intValue(), l.longValue(), platformEntity);
            return Unit.INSTANCE;
        }

        public final void invoke(View view, int i, long j, PlatformEntity it) {
            Intrinsics.checkNotNullParameter(it, "it");
            if (it.getId() != LibraryCollectionThumbnailsViewNavFragment.this.getLibraryViewModel().getSelectedPlatformId()) {
                LibraryCollectionThumbnailsViewNavFragment.this.getLibraryViewModel().setSelectedPlatformId(it.getId());
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.LibraryCollectionThumbnailsViewNavFragment$onCreateView$15, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryCollectionThumbnailsViewNavFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass15 extends Lambda<Unit> implements Function4<View, Integer, Long, PlatformEntity, Unit> {
        final /* synthetic */ SharedPreferences $platformLibrarySharedPreferences;
        final /* synthetic */ LibraryCollectionThumbnailsViewNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass15(SharedPreferences sharedPreferences, LibraryCollectionThumbnailsViewNavFragment libraryCollectionThumbnailsViewNavFragment) {
            super(4);
            this.$platformLibrarySharedPreferences = sharedPreferences;
            this.this$0 = libraryCollectionThumbnailsViewNavFragment;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlatformEntity platformEntity) {
            invoke(view, num.intValue(), l.longValue(), platformEntity);
            return Unit.INSTANCE;
        }

        public final void invoke(View view, int i, long j, PlatformEntity platformEntity) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(platformEntity, "<anonymous parameter 3>");
            int i2 = this.$platformLibrarySharedPreferences.getInt("view_mode", 0);
            LibraryCollectionThumbnailsViewNavFragment libraryCollectionThumbnailsViewNavFragment = this.this$0;
            NavController navController = null;
            if (i2 == 0) {
                NavController navController2 = libraryCollectionThumbnailsViewNavFragment.navController;
                if (navController2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                } else {
                    navController = navController2;
                }
                navController.navigate(R.id.libraryCollectionThumbnailsViewToPlatformLibraryListViewAction);
                return;
            }
            if (i2 != 1) {
                return;
            }
            NavController navController3 = libraryCollectionThumbnailsViewNavFragment.navController;
            if (navController3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
            } else {
                navController = navController3;
            }
            navController.navigate(R.id.libraryCollectionThumbnailsViewToPlatformLibraryGridViewAction);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.LibraryCollectionThumbnailsViewNavFragment$onCreateView$16, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryCollectionThumbnailsViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "newPlatformId", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass16 extends Lambda<Unit> implements Function1<Long, Unit> {
        AnonymousClass16() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            LibraryCollectionThumbnailsViewNavFragment libraryCollectionThumbnailsViewNavFragment = LibraryCollectionThumbnailsViewNavFragment.this;
            Intrinsics.checkNotNull(l);
            libraryCollectionThumbnailsViewNavFragment.platformId = l.longValue();
            LibraryCollectionThumbnailsViewNavFragment libraryCollectionThumbnailsViewNavFragment2 = LibraryCollectionThumbnailsViewNavFragment.this;
            libraryCollectionThumbnailsViewNavFragment2.selectedPlatformEntity = libraryCollectionThumbnailsViewNavFragment2.getDaijishouLibrary().getPlatformByIdStatically(l.longValue());
            LibraryCollectionThumbnailsViewNavFragment.this.refreshCurrentPlatform();
            LibraryCollectionThumbnailsViewNavFragment.this.refreshSyncStatus();
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.LibraryCollectionThumbnailsViewNavFragment$onCreateView$17, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryCollectionThumbnailsViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass17 extends Lambda<Unit> implements Function1<List<? extends Long>, Unit> {
        AnonymousClass17() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Long> list) {
            invoke2((List<Long>) list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Long> list) {
            Intrinsics.checkNotNull(list);
            if (list.isEmpty()) {
                return;
            }
            LibraryCollectionThumbnailsViewNavFragment.this.refreshCurrentPlatformStatistic(list.get(0).longValue(), list.get(1).longValue(), list.get(2).longValue(), list.get(3).longValue());
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.LibraryCollectionThumbnailsViewNavFragment$onCreateView$18, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryCollectionThumbnailsViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "newPlatformEntityList", "", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass18 extends Lambda<Unit> implements Function1<List<? extends PlatformEntity>, Unit> {
        AnonymousClass18() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlatformEntity> list) {
            invoke2((List<PlatformEntity>) list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<PlatformEntity> list) {
            LibraryCollectionThumbnailsViewNavFragment.this.platformEntityList.clear();
            List list2 = LibraryCollectionThumbnailsViewNavFragment.this.platformEntityList;
            Intrinsics.checkNotNull(list);
            list2.addAll(list);
            LibraryCollectionThumbnailsViewNavFragment libraryCollectionThumbnailsViewNavFragment = LibraryCollectionThumbnailsViewNavFragment.this;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(Long.valueOf(list.get(i).getId()));
            }
            libraryCollectionThumbnailsViewNavFragment.platformIdList = arrayList;
            LibraryCollectionThumbnailsViewRecyclerViewAdapter libraryCollectionThumbnailsViewRecyclerViewAdapter = null;
            NavController navController = null;
            if (list.isEmpty()) {
                NavController navController2 = LibraryCollectionThumbnailsViewNavFragment.this.navController;
                if (navController2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                    navController2 = null;
                }
                navController2.getGraph().setStartDestination(R.id.platformEmptyNavFragment);
                NavController navController3 = LibraryCollectionThumbnailsViewNavFragment.this.navController;
                if (navController3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                } else {
                    navController = navController3;
                }
                navController.navigate(R.id.libraryCollectionThumbnailsViewToPlatformEmptyAction);
                LibraryCollectionThumbnailsViewNavFragment.this.getLibraryViewModel().setSelectedPlatformId(-1L);
                return;
            }
            if (LibraryCollectionThumbnailsViewNavFragment.this.getLibraryViewModel().getSelectedPlatformId() == -1 || LibraryCollectionThumbnailsViewNavFragment.this.platformIdList.indexOf(Long.valueOf(LibraryCollectionThumbnailsViewNavFragment.this.platformId)) == -1) {
                LibraryCollectionThumbnailsViewNavFragment.this.getLibraryViewModel().setSelectedPlatformId(list.get(0).getId());
            }
            LibraryCollectionThumbnailsViewRecyclerViewAdapter libraryCollectionThumbnailsViewRecyclerViewAdapter2 = LibraryCollectionThumbnailsViewNavFragment.this.libraryCollectionThumbnailsViewRecyclerViewAdapter;
            if (libraryCollectionThumbnailsViewRecyclerViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("libraryCollectionThumbnailsViewRecyclerViewAdapter");
            } else {
                libraryCollectionThumbnailsViewRecyclerViewAdapter = libraryCollectionThumbnailsViewRecyclerViewAdapter2;
            }
            libraryCollectionThumbnailsViewRecyclerViewAdapter.notifyDataSetChanged();
            LibraryCollectionThumbnailsViewNavFragment.this.refreshCurrentPlatform();
            LibraryCollectionThumbnailsViewNavFragment.this.refreshSyncStatus();
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.LibraryCollectionThumbnailsViewNavFragment$onCreateView$19, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryCollectionThumbnailsViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass19 extends Lambda<Unit> implements Function1<String, Unit> {
        AnonymousClass19() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            NavController navController = null;
            if (Intrinsics.areEqual(str, "0")) {
                NavOptions navOptionsBuild = NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), R.id.libraryCollectionThumbnailsViewNavFragment, true, false, 4, (Object) null).build();
                NavController navController2 = LibraryCollectionThumbnailsViewNavFragment.this.navController;
                if (navController2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                    navController2 = null;
                }
                navController2.getGraph().setStartDestination(R.id.libraryCollectionWallpaperViewNavFragment);
                NavController navController3 = LibraryCollectionThumbnailsViewNavFragment.this.navController;
                if (navController3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                    navController3 = null;
                }
                NavDestination currentDestination = navController3.getCurrentDestination();
                if (currentDestination == null || currentDestination.getId() != R.id.libraryCollectionThumbnailsViewNavFragment) {
                    return;
                }
                NavController navController4 = LibraryCollectionThumbnailsViewNavFragment.this.navController;
                if (navController4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                } else {
                    navController = navController4;
                }
                navController.navigate(LibraryCollectionThumbnailsViewNavFragmentDirections.INSTANCE.libraryCollectionThumbnailsViewToLibraryCollectionWallpaperViewAction(), navOptionsBuild);
                return;
            }
            if (Intrinsics.areEqual(str, ExifInterface.GPS_MEASUREMENT_2D)) {
                NavOptions navOptionsBuild2 = NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), R.id.libraryCollectionThumbnailsViewNavFragment, true, false, 4, (Object) null).build();
                NavController navController5 = LibraryCollectionThumbnailsViewNavFragment.this.navController;
                if (navController5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                    navController5 = null;
                }
                navController5.getGraph().setStartDestination(R.id.libraryCollectionWebViewViewNavFragment);
                NavController navController6 = LibraryCollectionThumbnailsViewNavFragment.this.navController;
                if (navController6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                    navController6 = null;
                }
                NavDestination currentDestination2 = navController6.getCurrentDestination();
                if (currentDestination2 == null || currentDestination2.getId() != R.id.libraryCollectionThumbnailsViewNavFragment) {
                    return;
                }
                NavController navController7 = LibraryCollectionThumbnailsViewNavFragment.this.navController;
                if (navController7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                } else {
                    navController = navController7;
                }
                navController.navigate(LibraryCollectionThumbnailsViewNavFragmentDirections.INSTANCE.libraryCollectionThumbnailsViewToLibraryCollectionWebViewViewAction(), navOptionsBuild2);
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.LibraryCollectionThumbnailsViewNavFragment$onCreateView$20, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryCollectionThumbnailsViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/magneticchen/daijishou/view_models/SynchronizationOfPlatform;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass20 extends Lambda<Unit> implements Function1<List<SynchronizationOfPlatform>, Unit> {
        AnonymousClass20() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<SynchronizationOfPlatform> list) {
            invoke2(list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<SynchronizationOfPlatform> list) {
            LibraryCollectionThumbnailsViewNavFragment libraryCollectionThumbnailsViewNavFragment = LibraryCollectionThumbnailsViewNavFragment.this;
            Intrinsics.checkNotNull(list);
            libraryCollectionThumbnailsViewNavFragment.synchronizationOfPlatformList = list;
            LibraryCollectionThumbnailsViewNavFragment.this.refreshSyncStatus();
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.LibraryCollectionThumbnailsViewNavFragment$onCreateView$21, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryCollectionThumbnailsViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "id", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass21 extends Lambda<Unit> implements Function1<Long, Unit> {
        AnonymousClass21() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            long j = LibraryCollectionThumbnailsViewNavFragment.this.platformId;
            if (l != null && l.longValue() == j) {
                LibraryCollectionThumbnailsViewNavFragment.this.refreshSyncStatus();
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.LibraryCollectionThumbnailsViewNavFragment$onCreateView$22, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryCollectionThumbnailsViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass22 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ Ref.BooleanRef $useAutoPlatformThemeColor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass22(Ref.BooleanRef booleanRef) {
            super(1);
            this.$useAutoPlatformThemeColor = booleanRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            if (Intrinsics.areEqual(bool, Boolean.valueOf(this.$useAutoPlatformThemeColor.element))) {
                return;
            }
            Ref.BooleanRef booleanRef = this.$useAutoPlatformThemeColor;
            Intrinsics.checkNotNull(bool);
            booleanRef.element = bool.booleanValue();
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.nav_fragments.LibraryCollectionThumbnailsViewNavFragment$onCreateView$23, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryCollectionThumbnailsViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass23 extends Lambda<Unit> implements Function1<Boolean, Unit> {
        final /* synthetic */ Ref.BooleanRef $previousEnforcePlatformCardAspectRatio;
        final /* synthetic */ LibraryCollectionThumbnailsViewNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass23(Ref.BooleanRef booleanRef, LibraryCollectionThumbnailsViewNavFragment libraryCollectionThumbnailsViewNavFragment) {
            super(1);
            this.$previousEnforcePlatformCardAspectRatio = booleanRef;
            this.this$0 = libraryCollectionThumbnailsViewNavFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            if (!Intrinsics.areEqual(Boolean.valueOf(this.$previousEnforcePlatformCardAspectRatio.element), bool)) {
                this.this$0.requireView().invalidate();
            }
            Ref.BooleanRef booleanRef = this.$previousEnforcePlatformCardAspectRatio;
            Intrinsics.checkNotNull(bool);
            booleanRef.element = bool.booleanValue();
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }

    private final void updateLightDarkDecorations(Bitmap bitmap) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ColorStateList colorStateList = ContextCompat.getColorStateList(contextRequireContext, R.color.black);
        Intrinsics.checkNotNull(colorStateList);
        ColorStateList colorStateList2 = ContextCompat.getColorStateList(contextRequireContext, R.color.white);
        Intrinsics.checkNotNull(colorStateList2);
        ColorStateList colorStateList3 = ContextCompat.getColorStateList(contextRequireContext, R.color.dark_grey);
        Intrinsics.checkNotNull(colorStateList3);
        if (bitmap == null) {
            if (PlaidColorUtils.INSTANCE.isDarkTheme(contextRequireContext)) {
                updateLightDarkDecorations$setDark(this, colorStateList2, colorStateList3);
                return;
            } else {
                updateLightDarkDecorations$setLight(this, colorStateList, colorStateList2);
                return;
            }
        }
        if (Utils.INSTANCE.isBitmapDark(bitmap, 0, Integer.valueOf((bitmap.getHeight() * 2) / 4), Integer.valueOf(bitmap.getWidth() / 2), Integer.valueOf(bitmap.getHeight()))) {
            updateLightDarkDecorations$setDark(this, colorStateList2, colorStateList3);
        } else {
            updateLightDarkDecorations$setLight(this, colorStateList, colorStateList2);
        }
    }

    private static final void updateLightDarkDecorations$setLight(LibraryCollectionThumbnailsViewNavFragment libraryCollectionThumbnailsViewNavFragment, ColorStateList colorStateList, ColorStateList colorStateList2) {
        TextView textView = libraryCollectionThumbnailsViewNavFragment.titleFirst;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleFirst");
            textView = null;
        }
        textView.setTextColor(colorStateList);
        TextView textView3 = libraryCollectionThumbnailsViewNavFragment.titleSecond;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleSecond");
            textView3 = null;
        }
        textView3.setTextColor(colorStateList);
        TextView textView4 = libraryCollectionThumbnailsViewNavFragment.titleFirst;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleFirst");
            textView4 = null;
        }
        textView4.setShadowLayer(0.0f, 0.0f, 0.0f, colorStateList2.getDefaultColor());
        TextView textView5 = libraryCollectionThumbnailsViewNavFragment.titleSecond;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleSecond");
        } else {
            textView2 = textView5;
        }
        textView2.setShadowLayer(0.0f, 0.0f, 0.0f, colorStateList2.getDefaultColor());
    }

    private static final void updateLightDarkDecorations$setDark(LibraryCollectionThumbnailsViewNavFragment libraryCollectionThumbnailsViewNavFragment, ColorStateList colorStateList, ColorStateList colorStateList2) {
        TextView textView = libraryCollectionThumbnailsViewNavFragment.titleFirst;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleFirst");
            textView = null;
        }
        textView.setTextColor(colorStateList);
        TextView textView3 = libraryCollectionThumbnailsViewNavFragment.titleSecond;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleSecond");
            textView3 = null;
        }
        textView3.setTextColor(colorStateList);
        TextView textView4 = libraryCollectionThumbnailsViewNavFragment.titleFirst;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleFirst");
            textView4 = null;
        }
        textView4.setShadowLayer(libraryCollectionThumbnailsViewNavFragment.getDpToPxConverter().convert(3.0f), 0.0f, libraryCollectionThumbnailsViewNavFragment.getDpToPxConverter().convert(1.0f), colorStateList2.getDefaultColor());
        TextView textView5 = libraryCollectionThumbnailsViewNavFragment.titleSecond;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleSecond");
        } else {
            textView2 = textView5;
        }
        textView2.setShadowLayer(libraryCollectionThumbnailsViewNavFragment.getDpToPxConverter().convert(3.0f), 0.0f, libraryCollectionThumbnailsViewNavFragment.getDpToPxConverter().convert(1.0f), colorStateList2.getDefaultColor());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.hasRefreshedBefore = false;
    }

    /* JADX INFO: compiled from: LibraryCollectionThumbnailsViewNavFragment.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J \u0010\u0018\u001a\n0\u0019R\u00060\u0000R\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u00060\u000bR\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionThumbnailsViewNavFragment$LibraryCollectionThumbnailsViewRecyclerViewAdapter;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "context", "Landroid/content/Context;", "itemList", "", "(Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionThumbnailsViewNavFragment;Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "getTheme", "()Landroid/content/res/Resources$Theme;", "themeTextColor", "", "getThemeTextColor", "()I", "typedValue", "Landroid/util/TypedValue;", "getItemId", "", "position", "onCreateViewHolder", "Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionThumbnailsViewNavFragment$LibraryCollectionThumbnailsViewRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionThumbnailsViewNavFragment;", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class LibraryCollectionThumbnailsViewRecyclerViewAdapter extends DaijishouRecyclerView.Adapter<PlatformEntity> {
        private final Context context;
        private final Resources.Theme theme;
        private final int themeTextColor;
        final /* synthetic */ LibraryCollectionThumbnailsViewNavFragment this$0;
        private final TypedValue typedValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LibraryCollectionThumbnailsViewRecyclerViewAdapter(LibraryCollectionThumbnailsViewNavFragment libraryCollectionThumbnailsViewNavFragment, Context context, List<PlatformEntity> itemList) {
            super(itemList, true, false, 4, null);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(itemList, "itemList");
            this.this$0 = libraryCollectionThumbnailsViewNavFragment;
            this.context = context;
            setKeepSelectedItemFocusedInSelectableMode(false);
            TypedValue typedValue = new TypedValue();
            this.typedValue = typedValue;
            Resources.Theme theme = context.getTheme();
            Intrinsics.checkNotNullExpressionValue(theme, "getTheme(...)");
            this.theme = theme;
            theme.resolveAttribute(R.attr.themeTextColor, typedValue, true);
            this.themeTextColor = typedValue.data;
        }

        public final Context getContext() {
            return this.context;
        }

        public final Resources.Theme getTheme() {
            return this.theme;
        }

        public final int getThemeTextColor() {
            return this.themeTextColor;
        }

        /* JADX INFO: compiled from: LibraryCollectionThumbnailsViewNavFragment.kt */
        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionThumbnailsViewNavFragment$LibraryCollectionThumbnailsViewRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/nav_fragments/LibraryCollectionThumbnailsViewNavFragment$LibraryCollectionThumbnailsViewRecyclerViewAdapter;Landroid/view/View;)V", "background", "Lcom/google/android/material/card/MaterialCardView;", "baseStrokeColor", "Landroid/content/res/ColorStateList;", "baseStrokeWidth", "", "colorPrimary", "colorPrimaryColorStateList", "iconImageView", "Landroid/widget/ImageView;", "imageView", "highlight", "", "onBind", "position", "item", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "", "onSelect", "onUnselect", "unHighlight", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<PlatformEntity>.ViewHolder {
            private final MaterialCardView background;
            private final ColorStateList baseStrokeColor;
            private final int baseStrokeWidth;
            private final int colorPrimary;
            private final ColorStateList colorPrimaryColorStateList;
            public final ImageView iconImageView;
            public final ImageView imageView;
            final /* synthetic */ LibraryCollectionThumbnailsViewRecyclerViewAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(LibraryCollectionThumbnailsViewRecyclerViewAdapter libraryCollectionThumbnailsViewRecyclerViewAdapter, View itemView) {
                super(libraryCollectionThumbnailsViewRecyclerViewAdapter, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = libraryCollectionThumbnailsViewRecyclerViewAdapter;
                View viewFindViewById = itemView.findViewById(R.id.grid_item_library_collection_thumbnails_view_card);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                MaterialCardView materialCardView = (MaterialCardView) viewFindViewById;
                this.background = materialCardView;
                View viewFindViewById2 = itemView.findViewById(R.id.grid_item_library_collection_thumbnails_image_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.imageView = (ImageView) viewFindViewById2;
                View viewFindViewById3 = itemView.findViewById(R.id.grid_item_library_collection_thumbnails_icon_image_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                this.iconImageView = (ImageView) viewFindViewById3;
                this.baseStrokeWidth = materialCardView.getStrokeWidth();
                this.baseStrokeColor = materialCardView.getStrokeColorStateList();
                libraryCollectionThumbnailsViewRecyclerViewAdapter.getTheme().resolveAttribute(R.attr.colorPrimary, libraryCollectionThumbnailsViewRecyclerViewAdapter.typedValue, true);
                int i = libraryCollectionThumbnailsViewRecyclerViewAdapter.typedValue.data;
                this.colorPrimary = i;
                this.colorPrimaryColorStateList = new ColorStateList(new int[][]{new int[]{android.R.attr.state_focused}, new int[]{-16842908}, new int[]{android.R.attr.state_enabled}}, new int[]{i, i, i});
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int position, PlatformEntity item) {
                Intrinsics.checkNotNullParameter(item, "item");
                String thumbnailPath = item.getThumbnailPath();
                if (thumbnailPath != null) {
                    this.this$0.this$0.getDaijishouLibrary().getCachedPlatformThumbnailBitmapLoader().with(this.this$0.this$0).setOnSucceedListener(new LibraryCollectionThumbnailsViewNavFragment$LibraryCollectionThumbnailsViewRecyclerViewAdapter$ViewHolder$onBind$1(this)).setOnFailedListener(new LibraryCollectionThumbnailsViewNavFragment$LibraryCollectionThumbnailsViewRecyclerViewAdapter$ViewHolder$onBind$2(this.this$0.this$0, this)).load(thumbnailPath).into(this.imageView);
                }
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocus() {
                super.onFocus();
                Utils.scaleView$default(Utils.INSTANCE, this.background, 1.0f, 1.03f, 0L, false, 24, null);
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocusClear(boolean isAbsoluteAdapterPositionValid) {
                super.onFocusClear(isAbsoluteAdapterPositionValid);
                if (isAbsoluteAdapterPositionValid) {
                    Utils.scaleView$default(Utils.INSTANCE, this.background, 1.03f, 1.0f, 0L, false, 24, null);
                }
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onSelect() {
                super.onSelect();
                this.itemView.requestFocus();
                highlight();
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onUnselect() {
                super.onUnselect();
                unHighlight();
            }

            private final void highlight() {
                this.background.setStrokeColor(this.colorPrimaryColorStateList);
                this.background.setStrokeWidth((int) (this.baseStrokeWidth * 1.5f));
            }

            private final void unHighlight() {
                this.background.setStrokeColor(this.baseStrokeColor);
                this.background.setStrokeWidth(this.baseStrokeWidth);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item_library_collection_thumbnails_view_platform, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            return getItemList().get(position).getId();
        }
    }
}
