package com.magneticchen.daijishou.ui.fragments.nav;

import android.app.Activity;
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
import android.util.Log;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.Genre;
import com.magneticchen.daijishou.data.Genres;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntityMergedInfo;
import com.magneticchen.daijishou.data.live.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouCycleLinearLayoutManager;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment;
import com.magneticchen.daijishou.ui.fragments.p000abstract.PlatformNavFragment;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.magneticchen.daijishou.ui.model.DaijishouViewModel;
import com.magneticchen.daijishou.ui.model.LibraryViewModel;
import com.magneticchen.daijishou.ui.observer.OrientationObserver;
import com.magneticchen.daijishou.ui.widget.WidgetsManager;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetBuilder;
import com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetBuilder;
import com.magneticchen.daijishou.utils.PlaidColorUtils;
import com.magneticchen.daijishou.utils.Utils;
import com.skydoves.balloon.internals.DefinitionKt;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0089\u00012\u00020\u0001:\u0004\u0089\u0001\u008a\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010Y\u001a\u00020\u001cH\u0002J\u0010\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020JH\u0002J\b\u0010]\u001a\u00020[H\u0002J\b\u0010^\u001a\u00020[H\u0002J\b\u0010_\u001a\u00020[H\u0002J\b\u0010`\u001a\u00020[H\u0002J\b\u0010a\u001a\u00020[H\u0002J\u0012\u0010b\u001a\u00020[2\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J&\u0010e\u001a\u0004\u0018\u00010f2\u0006\u0010g\u001a\u00020h2\b\u0010i\u001a\u0004\u0018\u00010j2\b\u0010c\u001a\u0004\u0018\u00010dH\u0017J \u0010k\u001a\u00020\u001c2\u0006\u0010l\u001a\u00020J2\u0006\u0010m\u001a\u00020J2\u0006\u0010n\u001a\u00020oH\u0016J\b\u0010p\u001a\u00020[H\u0016J\b\u0010q\u001a\u00020[H\u0016J\b\u0010r\u001a\u00020[H\u0002J\b\u0010s\u001a\u00020[H\u0016J\u0010\u0010t\u001a\u00020[2\u0006\u0010u\u001a\u00020MH\u0002J\u0010\u0010t\u001a\u00020[2\u0006\u0010v\u001a\u00020wH\u0002J,\u0010x\u001a\u00020[2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010u\u001a\u00020MH\u0002J,\u0010x\u001a\u00020[2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010v\u001a\u00020wH\u0002J\u0010\u0010{\u001a\u00020[2\u0006\u0010u\u001a\u00020MH\u0002J\u0010\u0010{\u001a\u00020[2\u0006\u0010v\u001a\u00020wH\u0002J\u0018\u0010|\u001a\u00020[2\u0006\u0010}\u001a\u00020M2\u0006\u0010~\u001a\u00020JH\u0002J\u0010\u0010\u007f\u001a\u00020[2\u0006\u0010u\u001a\u00020MH\u0002J\u0010\u0010\u007f\u001a\u00020[2\u0006\u0010v\u001a\u00020wH\u0002J\u0011\u0010\u0080\u0001\u001a\u00020[2\u0006\u0010u\u001a\u00020MH\u0002J\u0019\u0010\u0080\u0001\u001a\u00020[2\u0006\u0010u\u001a\u00020M2\u0006\u0010v\u001a\u00020wH\u0002J\t\u0010\u0081\u0001\u001a\u00020[H\u0002J\t\u0010\u0082\u0001\u001a\u00020[H\u0002J\u0015\u0010\u0083\u0001\u001a\u00020[2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0002J\u0015\u0010\u0086\u0001\u001a\u00020[2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0002J\t\u0010\u0088\u0001\u001a\u00020[H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u000e\u0010+\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010*\u001a\u0004\b.\u0010/R\u000e\u00101\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082.¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010*\u001a\u0004\b7\u00108R\u000e\u0010:\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010B\u001a\u00060CR\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020J0HX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020M0LX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u008b\u0001"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/PlatformNavFragment;", "()V", "backgroundGradientImageView", "Landroid/widget/ImageView;", "backgroundImageView", "backgroundSetLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "boxArtAspectRatio", "", "boxArtAspectRatioList", "", "chipGroup", "Lcom/google/android/material/chip/ChipGroup;", "completeButton", "Lcom/google/android/material/chip/Chip;", "descriptionFormatString", "descriptionTextView", "Landroid/widget/TextView;", "descriptionWithGenresFormatString", "detailButton", "dimensionRatio", "editButton", "favoriteButton", "focusListener", "Landroid/view/View$OnFocusChangeListener;", "gridViewButton", "hopToNextItemLock", "", "isCompletedDrawable", "Landroid/graphics/drawable/Drawable;", "isFavoriteDrawable", "isNotCompletedDrawable", "isNotFavoriteDrawable", "lastHopToNextItemTimeMillis", "", "lastToggleViewModeTimeMillis", "libraryViewModel", "Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;", "getLibraryViewModel", "()Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;", "libraryViewModel$delegate", "Lkotlin/Lazy;", "lockToggleViewMode", "model", "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "model$delegate", "newlyButton", "noneString", "packageManager", "Landroid/content/pm/PackageManager;", "pinAndPlayWidget", "Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;", "getPinAndPlayWidget", "()Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;", "pinAndPlayWidget$delegate", "pinButton", "placeholderImageView", "platformEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "platformFormatString", "platformId", "platformLibraryListRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "platformLibraryListRecyclerViewAdapter", "Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;", "platformString", "platformTextView", "playButton", "playableItemCharacterIndexingHashmap", "Ljava/util/SortedMap;", "", "", "playableItemList", "", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "recentButton", "screenAspectRatio", "screenAspectRatioList", "selectedLetterFormatString", "selectedPlayableItemEntity", "setPreviewToBoxArtString", "setPreviewToSnapshotString", "setPreviewToTitleString", "thumbnailImageView", "tipsFormatString", "titleTextView", "getMergePlayableItemsPreference", "hopToNextItemByFirstCharacter", "", "offset", "initChipFocusListener", "initCompletedClickListener", "initFavoriteClickListener", "initOrientationObserver", "initTypeface", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHotKeyPressed", "hotkeyCode", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onKioskMode", "onNoneKioskMode", "onOrientationChanged", "onResume", "onUpdateCompletedButton", "item", "mergedInfo", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;", "onUpdateDescription", "genres", "genresNames", "onUpdateFavoriteButton", "onUpdatePlayableItemEntity", "playableItemEntity", "position", "onUpdateRecentButton", "onUpdateTitle", "refreshPinButton", "refreshPreview", "setBackground", "bitmap", "Landroid/graphics/Bitmap;", "setThumbnail", "it", "toggleViewMode", "Companion", "PlatformLibraryListAdapter", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlatformLibraryListViewNavFragment extends PlatformNavFragment {
    public static final Companion Companion = new Companion(null);
    private static final Typeface typeface;
    private ImageView backgroundGradientImageView;
    private ImageView backgroundImageView;
    private ConstraintLayout backgroundSetLayout;
    private String boxArtAspectRatio;
    private List<String> boxArtAspectRatioList;
    private ChipGroup chipGroup;
    private Chip completeButton;
    private String descriptionFormatString;
    private TextView descriptionTextView;
    private String descriptionWithGenresFormatString;
    private Chip detailButton;
    private String dimensionRatio;
    private Chip editButton;
    private Chip favoriteButton;
    private Chip gridViewButton;
    private boolean hopToNextItemLock;
    private Drawable isCompletedDrawable;
    private Drawable isFavoriteDrawable;
    private Drawable isNotCompletedDrawable;
    private Drawable isNotFavoriteDrawable;
    private final Lazy libraryViewModel$delegate;
    private final Lazy model$delegate;
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
    private PlayableItemEntity selectedPlayableItemEntity;
    private String setPreviewToBoxArtString;
    private String setPreviewToSnapshotString;
    private String setPreviewToTitleString;
    private ImageView thumbnailImageView;
    private String tipsFormatString;
    private TextView titleTextView;
    private final View.OnFocusChangeListener focusListener = new View.OnFocusChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda1
        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            PlatformLibraryListViewNavFragment.focusListener$lambda$0(view, z);
        }
    };
    private long platformId = -1;
    private final List<PlayableItemEntity> playableItemList = new ArrayList();
    private long lastHopToNextItemTimeMillis = System.currentTimeMillis();
    private long lastToggleViewModeTimeMillis = System.currentTimeMillis();
    private boolean lockToggleViewMode = true;
    private final SortedMap<Character, Integer> playableItemCharacterIndexingHashmap = MapsKt.sortedMapOf(new Pair[0]);
    private final Lazy pinAndPlayWidget$delegate = LazyKt.lazy(new Function0<PinAndPlayWidgetBuilder>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$pinAndPlayWidget$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PinAndPlayWidgetBuilder invoke() {
            WidgetBuilder widgetBuilder = this.this$0.getWidgetManager().getWidgetBuilders().get(PinAndPlayWidgetBuilder.class);
            Intrinsics.checkNotNull(widgetBuilder, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.widget.widgets.pin_and_play.PinAndPlayWidgetBuilder");
            return (PinAndPlayWidgetBuilder) widgetBuilder;
        }
    });

    public PlatformLibraryListViewNavFragment() {
        final PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment = this;
        final Function0 function0 = null;
        this.model$delegate = FragmentViewModelLazyKt.createViewModelLazy(platformLibraryListViewNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return platformLibraryListViewNavFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? platformLibraryListViewNavFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return platformLibraryListViewNavFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        this.libraryViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(platformLibraryListViewNavFragment, Reflection.getOrCreateKotlinClass(LibraryViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return platformLibraryListViewNavFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? platformLibraryListViewNavFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return platformLibraryListViewNavFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$Companion;", "", "()V", "typeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    public static final void focusListener$lambda$0(View view, boolean z) {
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
    public final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LibraryViewModel getLibraryViewModel() {
        return (LibraryViewModel) this.libraryViewModel$delegate.getValue();
    }

    private final PinAndPlayWidgetBuilder getPinAndPlayWidget() {
        return (PinAndPlayWidgetBuilder) this.pinAndPlayWidget$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getMergePlayableItemsPreference() {
        return getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue());
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
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
        View view = (View) chip4;
        ChipGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.chip.ChipGroup.LayoutParams");
        }
        ChipGroup.LayoutParams layoutParams2 = (ViewGroup.LayoutParams) layoutParams;
        ChipGroup.LayoutParams layoutParams3 = layoutParams2;
        ChipGroup chipGroup = this.chipGroup;
        if (chipGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
            chipGroup = null;
        }
        for (View view2 : ViewGroupKt.getChildren((ViewGroup) chipGroup)) {
            Chip chip5 = this.editButton;
            if (chip5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editButton");
                chip5 = null;
            }
            if (Intrinsics.areEqual(view2, chip5)) {
                ChipGroup chipGroup2 = this.chipGroup;
                if (chipGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                    chipGroup2 = null;
                }
                chipGroup2.removeView(view2);
            }
        }
        layoutParams3.setMarginEnd(getDpToPxConverter().convert(8.0f));
        view.setLayoutParams(layoutParams2);
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onNoneKioskMode() {
        super.onNoneKioskMode();
        Chip chip = this.editButton;
        View view = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip = null;
        }
        chip.setVisibility(0);
        Chip chip2 = this.gridViewButton;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
            chip2 = null;
        }
        Chip chip3 = this.editButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip3 = null;
        }
        chip2.setNextFocusRightId(chip3.getId());
        Chip chip4 = this.gridViewButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
            chip4 = null;
        }
        View view2 = (View) chip4;
        ChipGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.chip.ChipGroup.LayoutParams");
        }
        ChipGroup.LayoutParams layoutParams2 = (ViewGroup.LayoutParams) layoutParams;
        ChipGroup.LayoutParams layoutParams3 = layoutParams2;
        ChipGroup chipGroup = this.chipGroup;
        if (chipGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
            chipGroup = null;
        }
        View view3 = this.editButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
        } else {
            view = view3;
        }
        chipGroup.addView(view);
        layoutParams3.setMarginEnd(getDpToPxConverter().convert(DefinitionKt.NO_Float_VALUE));
        view2.setLayoutParams(layoutParams2);
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public boolean onHotKeyPressed(int i, int i2, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(i, i2, keyEvent);
        if (i == 1) {
            hopToNextItemByFirstCharacter(1);
            return true;
        }
        if (i == 2) {
            hopToNextItemByFirstCharacter(-1);
            return true;
        }
        if (i == 3) {
            toggleViewMode();
            return true;
        }
        if (i != 4) {
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

    private final void hopToNextItemByFirstCharacter(int i) {
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
        String upperCase = list.get(platformLibraryListAdapter.getSelectedPosition()).getName().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        char cCharAt = upperCase.charAt(0);
        Set<Character> setKeySet = this.playableItemCharacterIndexingHashmap.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        List list2 = CollectionsKt.toList(setKeySet);
        int iIndexOf = list2.indexOf(Character.valueOf(cCharAt)) + i;
        int size = list2.size();
        int i2 = iIndexOf % size;
        Integer num = this.playableItemCharacterIndexingHashmap.get((Character) list2.get(i2 + (size & (((i2 ^ size) & ((-i2) | i2)) >> 31))));
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
        if (currentDestination == null || currentDestination.getId() != 2131362621) {
            return;
        }
        navControllerFindNavController.navigate(R.id.platformLibraryListToPlatformLibraryGridAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setThumbnail(Bitmap bitmap) {
        String shortname;
        ImageView imageView = this.thumbnailImageView;
        ConstraintLayout constraintLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thumbnailImageView");
            imageView = null;
        }
        imageView.setImageBitmap(bitmap);
        ImageView imageView2 = this.placeholderImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("placeholderImageView");
            imageView2 = null;
        }
        imageView2.setVisibility(bitmap == null ? 0 : 8);
        TextView textView = this.platformTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformTextView");
            textView = null;
        }
        textView.setVisibility(bitmap != null ? 8 : 0);
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
        int previewAspectRatioMode = getLibraryViewModel().getPreviewAspectRatioMode();
        if (previewAspectRatioMode == 0) {
            this.dimensionRatio = this.boxArtAspectRatio;
            ConstraintLayout constraintLayout2 = this.backgroundSetLayout;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
                constraintLayout2 = null;
            }
            ConstraintLayout.LayoutParams layoutParams = constraintLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            layoutParams.dimensionRatio = this.boxArtAspectRatio;
        } else if (previewAspectRatioMode == 1) {
            this.dimensionRatio = this.screenAspectRatio;
            ConstraintLayout constraintLayout3 = this.backgroundSetLayout;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
                constraintLayout3 = null;
            }
            ConstraintLayout.LayoutParams layoutParams2 = constraintLayout3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            layoutParams2.dimensionRatio = this.screenAspectRatio;
        } else if (previewAspectRatioMode == 2) {
            this.dimensionRatio = this.screenAspectRatio;
            ConstraintLayout constraintLayout4 = this.backgroundSetLayout;
            if (constraintLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
                constraintLayout4 = null;
            }
            ConstraintLayout.LayoutParams layoutParams3 = constraintLayout4.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            layoutParams3.dimensionRatio = this.screenAspectRatio;
        }
        String str = this.dimensionRatio;
        if (str != null) {
            ConstraintLayout constraintLayout5 = this.backgroundSetLayout;
            if (constraintLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
                constraintLayout5 = null;
            }
            ConstraintLayout.LayoutParams layoutParams4 = constraintLayout5.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams5 = layoutParams4;
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
        int previewAspectRatioMode = getLibraryViewModel().getPreviewAspectRatioMode();
        PlayableItemEntity playableItemEntity = this.selectedPlayableItemEntity;
        if (playableItemEntity != null) {
            if (playableItemEntity.getPreviewMediaPath() == null) {
                setThumbnail(null);
                setBackground(null);
            } else {
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), Dispatchers.getIO(), (CoroutineStart) null, new PlatformLibraryListViewNavFragment$refreshPreview$1$1(playableItemEntity, playableItemEntity, this, previewAspectRatioMode, null), 2, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onUpdatePlayableItemEntity(PlayableItemEntity playableItemEntity, int i) {
        String upperCase;
        String shortname;
        this.selectedPlayableItemEntity = playableItemEntity;
        TextView textView = this.titleTextView;
        Chip chip = null;
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
        DaijishouViewModel model = getModel();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = this.tipsFormatString;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsFormatString");
            str = null;
        }
        PlatformEntity platformEntity = this.platformEntity;
        if (platformEntity == null || (shortname = platformEntity.getShortname()) == null) {
            upperCase = null;
        } else {
            upperCase = shortname.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        }
        Integer numValueOf = Integer.valueOf(i + 1);
        PlatformLibraryListAdapter platformLibraryListAdapter = this.platformLibraryListRecyclerViewAdapter;
        if (platformLibraryListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            platformLibraryListAdapter = null;
        }
        String str2 = String.format(str, Arrays.copyOf(new Object[]{upperCase, numValueOf, Integer.valueOf(platformLibraryListAdapter.getItemCount())}, 3));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        DaijishouViewModel.setTips$default(model, str2, false, 2, null);
        List<String> genreIdsByPlayableItemIdStatically = getDaijishouLibrary().getGenreIdsByPlayableItemIdStatically(playableItemEntity.getId());
        int size = genreIdsByPlayableItemIdStatically.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            Genre genre = Genres.INSTANCE.getGenres().get(genreIdsByPlayableItemIdStatically.get(i2));
            arrayList.add(getString(genre != null ? genre.getNameStringId() : R.string.unknown_genre_name));
        }
        ArrayList arrayList2 = arrayList;
        if (getMergePlayableItemsPreference()) {
            onUpdateTitle(playableItemEntity, playableItemEntity.getMergedInfo());
            onUpdateDescription(genreIdsByPlayableItemIdStatically, arrayList2, playableItemEntity.getMergedInfo());
            onUpdateFavoriteButton(playableItemEntity.getMergedInfo());
            onUpdateCompletedButton(playableItemEntity.getMergedInfo());
            onUpdateRecentButton(playableItemEntity.getMergedInfo());
        } else {
            onUpdateTitle(playableItemEntity);
            onUpdateDescription(genreIdsByPlayableItemIdStatically, arrayList2, playableItemEntity);
            onUpdateFavoriteButton(playableItemEntity);
            onUpdateCompletedButton(playableItemEntity);
            onUpdateRecentButton(playableItemEntity);
        }
        refreshPinButton();
        refreshPreview();
        Chip chip2 = this.recentButton;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip2 = null;
        }
        chip2.requestLayout();
        Chip chip3 = this.newlyButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
        } else {
            chip = chip3;
        }
        chip.requestLayout();
    }

    private final void onUpdateTitle(PlayableItemEntity playableItemEntity, PlayableItemEntityMergedInfo playableItemEntityMergedInfo) {
        TextView textView = null;
        if (getDefaultSharedPreferences().getBoolean("do_not_prettify_titles_in_details_view", false)) {
            TextView textView2 = this.titleTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            } else {
                textView = textView2;
            }
            textView.setText(playableItemEntityMergedInfo.getMergedName());
            return;
        }
        if (playableItemEntity.getDoNotPrettify()) {
            TextView textView3 = this.titleTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            } else {
                textView = textView3;
            }
            textView.setText(playableItemEntityMergedInfo.getMergedName());
            return;
        }
        TextView textView4 = this.titleTextView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        } else {
            textView = textView4;
        }
        textView.setText(getDaijishouLibrary().prettifyTitleWithPreferences(playableItemEntityMergedInfo.getMergedName()));
    }

    private final void onUpdateTitle(PlayableItemEntity playableItemEntity) {
        TextView textView = null;
        if (getDefaultSharedPreferences().getBoolean("do_not_prettify_titles_in_details_view", false)) {
            TextView textView2 = this.titleTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            } else {
                textView = textView2;
            }
            textView.setText(playableItemEntity.getMergedInfo().getMergedName());
            return;
        }
        if (playableItemEntity.getDoNotPrettify()) {
            TextView textView3 = this.titleTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            } else {
                textView = textView3;
            }
            textView.setText(playableItemEntity.getName());
            return;
        }
        TextView textView4 = this.titleTextView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        } else {
            textView = textView4;
        }
        textView.setText(getDaijishouLibrary().prettifyTitleWithPreferences(playableItemEntity.getName()));
    }

    private final void onUpdateDescription(List<String> list, List<String> list2, PlayableItemEntityMergedInfo playableItemEntityMergedInfo) {
        String strDecapitalize;
        String str = null;
        if (playableItemEntityMergedInfo.getMergedLastPlayedTimestamp() != null) {
            Utils utils = Utils.INSTANCE;
            Date mergedLastPlayedTimestamp = playableItemEntityMergedInfo.getMergedLastPlayedTimestamp();
            Intrinsics.checkNotNull(mergedLastPlayedTimestamp);
            String relativeTimeString = utils.getRelativeTimeString(mergedLastPlayedTimestamp.getTime());
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            strDecapitalize = StringsKt.decapitalize(relativeTimeString, locale);
        } else {
            strDecapitalize = this.noneString;
            if (strDecapitalize == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noneString");
                strDecapitalize = null;
            }
        }
        if (list.isEmpty()) {
            TextView textView = this.descriptionTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
                textView = null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = this.descriptionFormatString;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descriptionFormatString");
            } else {
                str = str2;
            }
            String str3 = String.format(str, Arrays.copyOf(new Object[]{strDecapitalize, Integer.valueOf(playableItemEntityMergedInfo.getMergedPlayedCount())}, 2));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            textView.setText(str3);
            return;
        }
        TextView textView2 = this.descriptionTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
            textView2 = null;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str4 = this.descriptionWithGenresFormatString;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionWithGenresFormatString");
        } else {
            str = str4;
        }
        String str5 = String.format(str, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(list2, ", ", null, null, 0, null, null, 62, null), strDecapitalize, Integer.valueOf(playableItemEntityMergedInfo.getMergedPlayedCount())}, 3));
        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
        textView2.setText(str5);
    }

    private final void onUpdateDescription(List<String> list, List<String> list2, PlayableItemEntity playableItemEntity) {
        String strDecapitalize;
        String str = null;
        if (playableItemEntity.getLastPlayedTimestamp() != null) {
            Utils utils = Utils.INSTANCE;
            Date lastPlayedTimestamp = playableItemEntity.getLastPlayedTimestamp();
            Intrinsics.checkNotNull(lastPlayedTimestamp);
            String relativeTimeString = utils.getRelativeTimeString(lastPlayedTimestamp.getTime());
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            strDecapitalize = StringsKt.decapitalize(relativeTimeString, locale);
        } else {
            strDecapitalize = this.noneString;
            if (strDecapitalize == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noneString");
                strDecapitalize = null;
            }
        }
        if (list.isEmpty()) {
            TextView textView = this.descriptionTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
                textView = null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = this.descriptionFormatString;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descriptionFormatString");
            } else {
                str = str2;
            }
            String str3 = String.format(str, Arrays.copyOf(new Object[]{strDecapitalize, Integer.valueOf(playableItemEntity.getPlayCount())}, 2));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            textView.setText(str3);
            return;
        }
        TextView textView2 = this.descriptionTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionTextView");
            textView2 = null;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str4 = this.descriptionWithGenresFormatString;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionWithGenresFormatString");
        } else {
            str = str4;
        }
        String str5 = String.format(str, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(list2, ", ", null, null, 0, null, null, 62, null), strDecapitalize, Integer.valueOf(playableItemEntity.getPlayCount())}, 3));
        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
        textView2.setText(str5);
    }

    private final void onUpdateRecentButton(PlayableItemEntityMergedInfo playableItemEntityMergedInfo) {
        Date date = new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc()));
        Date mergedLastPlayedTimestamp = playableItemEntityMergedInfo.getMergedLastPlayedTimestamp();
        Chip chip = null;
        if (mergedLastPlayedTimestamp != null && mergedLastPlayedTimestamp.after(date)) {
            Chip chip2 = this.recentButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            } else {
                chip = chip2;
            }
            chip.setVisibility(0);
            return;
        }
        Chip chip3 = this.recentButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
        } else {
            chip = chip3;
        }
        chip.setVisibility(8);
    }

    private final void onUpdateRecentButton(PlayableItemEntity playableItemEntity) {
        Date date = new Date(System.currentTimeMillis() - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc()));
        Date lastPlayedTimestamp = playableItemEntity.getLastPlayedTimestamp();
        Chip chip = null;
        if (lastPlayedTimestamp != null && lastPlayedTimestamp.after(date)) {
            Chip chip2 = this.recentButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            } else {
                chip = chip2;
            }
            chip.setVisibility(0);
            return;
        }
        Chip chip3 = this.recentButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
        } else {
            chip = chip3;
        }
        chip.setVisibility(8);
    }

    private final void onUpdateFavoriteButton(PlayableItemEntity playableItemEntity) {
        Chip chip = null;
        if (playableItemEntity.isFavorite()) {
            Chip chip2 = this.favoriteButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip2 = null;
            }
            Drawable drawable = this.isFavoriteDrawable;
            if (drawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("isFavoriteDrawable");
                drawable = null;
            }
            chip2.setChipIcon(drawable);
            Chip chip3 = this.favoriteButton;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            } else {
                chip = chip3;
            }
            chip.setText(getString(R.string.is_favorite));
            return;
        }
        Chip chip4 = this.favoriteButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip4 = null;
        }
        Drawable drawable2 = this.isNotFavoriteDrawable;
        if (drawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("isNotFavoriteDrawable");
            drawable2 = null;
        }
        chip4.setChipIcon(drawable2);
        Chip chip5 = this.favoriteButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
        } else {
            chip = chip5;
        }
        chip.setText(getString(R.string.add_favorite));
    }

    private final void onUpdateFavoriteButton(PlayableItemEntityMergedInfo playableItemEntityMergedInfo) {
        Chip chip = null;
        if (playableItemEntityMergedInfo.getMergedIsFavorite()) {
            Chip chip2 = this.favoriteButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
                chip2 = null;
            }
            Drawable drawable = this.isFavoriteDrawable;
            if (drawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("isFavoriteDrawable");
                drawable = null;
            }
            chip2.setChipIcon(drawable);
            Chip chip3 = this.favoriteButton;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            } else {
                chip = chip3;
            }
            chip.setText(getString(R.string.is_favorite));
            return;
        }
        Chip chip4 = this.favoriteButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip4 = null;
        }
        Drawable drawable2 = this.isNotFavoriteDrawable;
        if (drawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("isNotFavoriteDrawable");
            drawable2 = null;
        }
        chip4.setChipIcon(drawable2);
        Chip chip5 = this.favoriteButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
        } else {
            chip = chip5;
        }
        chip.setText(getString(R.string.add_favorite));
    }

    private final void onUpdateCompletedButton(PlayableItemEntity playableItemEntity) {
        Log.d("daijishouLibrary", "update is completed button: " + playableItemEntity.isCompleted());
        Chip chip = null;
        if (playableItemEntity.isCompleted()) {
            Chip chip2 = this.completeButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("completeButton");
                chip2 = null;
            }
            Drawable drawable = this.isCompletedDrawable;
            if (drawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("isCompletedDrawable");
                drawable = null;
            }
            chip2.setChipIcon(drawable);
            Chip chip3 = this.completeButton;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("completeButton");
            } else {
                chip = chip3;
            }
            chip.setText(getString(R.string.is_completed));
            return;
        }
        Chip chip4 = this.completeButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeButton");
            chip4 = null;
        }
        Drawable drawable2 = this.isNotCompletedDrawable;
        if (drawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("isNotCompletedDrawable");
            drawable2 = null;
        }
        chip4.setChipIcon(drawable2);
        Chip chip5 = this.completeButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeButton");
        } else {
            chip = chip5;
        }
        chip.setText(getString(R.string.mark_completed));
    }

    private final void onUpdateCompletedButton(PlayableItemEntityMergedInfo playableItemEntityMergedInfo) {
        Log.d("daijishouLibrary", "update is completed button: " + playableItemEntityMergedInfo.getMergedIsCompleted());
        Chip chip = null;
        if (playableItemEntityMergedInfo.getMergedIsCompleted()) {
            Chip chip2 = this.completeButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("completeButton");
                chip2 = null;
            }
            Drawable drawable = this.isCompletedDrawable;
            if (drawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("isCompletedDrawable");
                drawable = null;
            }
            chip2.setChipIcon(drawable);
            Chip chip3 = this.completeButton;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("completeButton");
            } else {
                chip = chip3;
            }
            chip.setText(getString(R.string.is_completed));
            return;
        }
        Chip chip4 = this.completeButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeButton");
            chip4 = null;
        }
        Drawable drawable2 = this.isNotCompletedDrawable;
        if (drawable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("isNotCompletedDrawable");
            drawable2 = null;
        }
        chip4.setChipIcon(drawable2);
        Chip chip5 = this.completeButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeButton");
        } else {
            chip = chip5;
        }
        chip.setText(getString(R.string.mark_completed));
    }

    private final void initTypeface() {
        Chip chip = this.playButton;
        Chip chip2 = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip = null;
        }
        chip.setTypeface((Typeface) null, 3);
        Chip chip3 = this.favoriteButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip3 = null;
        }
        chip3.setTypeface((Typeface) null, 1);
        Chip chip4 = this.pinButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip4 = null;
        }
        chip4.setTypeface((Typeface) null, 1);
        Chip chip5 = this.completeButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeButton");
            chip5 = null;
        }
        chip5.setTypeface((Typeface) null, 1);
        Chip chip6 = this.completeButton;
        if (chip6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeButton");
            chip6 = null;
        }
        Typeface typeface2 = typeface;
        chip6.setTypeface(typeface2);
        Chip chip7 = this.recentButton;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip7 = null;
        }
        chip7.setTypeface(typeface2);
        Chip chip8 = this.newlyButton;
        if (chip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
            chip8 = null;
        }
        chip8.setTypeface(typeface2);
        Chip chip9 = this.detailButton;
        if (chip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailButton");
            chip9 = null;
        }
        chip9.setTypeface(typeface2);
        Chip chip10 = this.gridViewButton;
        if (chip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
            chip10 = null;
        }
        chip10.setTypeface(typeface2);
        Chip chip11 = this.editButton;
        if (chip11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
        } else {
            chip2 = chip11;
        }
        chip2.setTypeface(typeface2);
    }

    private final void initCompletedClickListener() {
        Chip chip = this.completeButton;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeButton");
            chip = null;
        }
        chip.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlatformLibraryListViewNavFragment.initCompletedClickListener$lambda$9(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initCompletedClickListener$lambda$9(PlatformLibraryListViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = this$0.selectedPlayableItemEntity;
        if (playableItemEntity != null) {
            Log.d("daijishouLibrary", "update is completed");
            this$0.getDaijishouLibrary().toggleIsPlayableItemCompleted(playableItemEntity);
        }
    }

    private final void initFavoriteClickListener() {
        Chip chip = this.favoriteButton;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip = null;
        }
        chip.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlatformLibraryListViewNavFragment.initFavoriteClickListener$lambda$11(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initFavoriteClickListener$lambda$11(PlatformLibraryListViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = this$0.selectedPlayableItemEntity;
        if (playableItemEntity != null) {
            this$0.getDaijishouLibrary().toggleIsPlayableItemFavorite(playableItemEntity);
        }
    }

    private final void initChipFocusListener() {
        ConstraintLayout constraintLayout = this.backgroundSetLayout;
        Chip chip = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout = null;
        }
        constraintLayout.setOnFocusChangeListener(this.focusListener);
        Chip chip2 = this.playButton;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip2 = null;
        }
        chip2.setOnFocusChangeListener(this.focusListener);
        Chip chip3 = this.favoriteButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip3 = null;
        }
        chip3.setOnFocusChangeListener(this.focusListener);
        Chip chip4 = this.completeButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completeButton");
            chip4 = null;
        }
        chip4.setOnFocusChangeListener(this.focusListener);
        Chip chip5 = this.pinButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip5 = null;
        }
        chip5.setOnFocusChangeListener(this.focusListener);
        Chip chip6 = this.recentButton;
        if (chip6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip6 = null;
        }
        chip6.setOnFocusChangeListener(this.focusListener);
        Chip chip7 = this.newlyButton;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
            chip7 = null;
        }
        chip7.setOnFocusChangeListener(this.focusListener);
        Chip chip8 = this.detailButton;
        if (chip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailButton");
            chip8 = null;
        }
        chip8.setOnFocusChangeListener(this.focusListener);
        Chip chip9 = this.gridViewButton;
        if (chip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
            chip9 = null;
        }
        chip9.setOnFocusChangeListener(this.focusListener);
        Chip chip10 = this.editButton;
        if (chip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
        } else {
            chip = chip10;
        }
        chip.setOnFocusChangeListener(this.focusListener);
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
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\u0011\u001a\n0\u0012R\u00060\u0000R\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rR\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "playableItemEntityList", "", "RIGHT_FOCUS_ID", "", "(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Ljava/util/List;I)V", "colorOnPrimary", "colorPrimary", "shape", "Landroid/graphics/drawable/GradientDrawable;", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "typedValue", "Landroid/util/TypedValue;", "onCreateViewHolder", "Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
            theme.resolveAttribute(2130968898, typedValue, true);
            int i2 = typedValue.data;
            this.colorPrimary = i2;
            theme.resolveAttribute(R.attr.colorOnPrimary, typedValue, true);
            this.colorOnPrimary = typedValue.data;
            gradientDrawable.setCornerRadius(platformLibraryListViewNavFragment.getDpToPxConverter().convert(6.0f));
            gradientDrawable.setColor(i2);
        }

        /* JADX INFO: compiled from: PlatformLibraryListViewNavFragment.kt */
        @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;Landroid/view/View;)V", "completedImageTintBackup", "Landroid/content/res/ColorStateList;", "completedImageView", "Landroid/widget/ImageView;", "favoriteImageTintBackup", "favoriteImageView", "layout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "newlyImageTintBackup", "newlyImageView", "recentImageTintBackup", "recentImageView", "textColorsBackup", "textView", "Landroid/widget/TextView;", "onBind", "", "position", "", "item", "onClick", "", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "onSelect", "onUnselect", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<PlayableItemEntity>.ViewHolder {
            private ColorStateList completedImageTintBackup;
            private final ImageView completedImageView;
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
                View viewFindViewById4 = itemView.findViewById(R.id.platform_library_list_item_completed_image_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
                ImageView imageView3 = (ImageView) viewFindViewById4;
                this.completedImageView = imageView3;
                View viewFindViewById5 = itemView.findViewById(R.id.platform_library_list_item_newly_image_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
                ImageView imageView4 = (ImageView) viewFindViewById5;
                this.newlyImageView = imageView4;
                ConstraintLayout constraintLayoutFindViewById = itemView.findViewById(R.id.platform_library_list_item_constraint_layout);
                Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
                this.layout = constraintLayoutFindViewById;
                ColorStateList textColors = textView.getTextColors();
                Intrinsics.checkNotNullExpressionValue(textColors, "getTextColors(...)");
                this.textColorsBackup = textColors;
                ColorStateList imageTintList = imageView3.getImageTintList();
                Intrinsics.checkNotNull(imageTintList);
                this.completedImageTintBackup = imageTintList;
                ColorStateList imageTintList2 = imageView2.getImageTintList();
                Intrinsics.checkNotNull(imageTintList2);
                this.favoriteImageTintBackup = imageTintList2;
                ColorStateList imageTintList3 = imageView4.getImageTintList();
                Intrinsics.checkNotNull(imageTintList3);
                this.newlyImageTintBackup = imageTintList3;
                ColorStateList imageTintList4 = imageView.getImageTintList();
                Intrinsics.checkNotNull(imageTintList4);
                this.recentImageTintBackup = imageTintList4;
            }

            /* JADX WARN: Code duplicated, block: B:19:0x00ad  */
            /* JADX WARN: Code duplicated, block: B:45:0x0141  */
            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int i, PlayableItemEntity item) {
                int i2;
                int i3;
                Intrinsics.checkNotNullParameter(item, "item");
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jM1822getInWholeMillisecondsimpl = jCurrentTimeMillis - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m143getRecentDurationDefinitionUwyO8pc());
                long jM1822getInWholeMillisecondsimpl2 = jCurrentTimeMillis - Duration.m1822getInWholeMillisecondsimpl(Constants.INSTANCE.m142getNewlyDurationDefinitionUwyO8pc());
                if (this.this$0.this$0.getMergePlayableItemsPreference()) {
                    this.textView.setText(this.this$0.this$0.getDaijishouLibrary().prettifyTitleWithPreferences(item.getMergedInfo().getMergedName()));
                    this.favoriteImageView.setVisibility(item.getMergedInfo().getMergedIsFavorite() ? 0 : 8);
                    this.newlyImageView.setVisibility(item.getMergedInfo().getMergedAddedDateTimestamp().getTime() >= jM1822getInWholeMillisecondsimpl2 ? 0 : 8);
                    if (this.this$0.this$0.getDefaultSharedPreferences().getBoolean(BooleanPreference.SHOW_RECENT_INDICATORS.getKey(), BooleanPreference.SHOW_RECENT_INDICATORS.getDefaultValue())) {
                        ImageView imageView = this.recentImageView;
                        if (item.getMergedInfo().getMergedLastPlayedTimestamp() != null) {
                            Date mergedLastPlayedTimestamp = item.getMergedInfo().getMergedLastPlayedTimestamp();
                            Intrinsics.checkNotNull(mergedLastPlayedTimestamp);
                            if (mergedLastPlayedTimestamp.getTime() >= jM1822getInWholeMillisecondsimpl) {
                                i3 = 0;
                            } else {
                                i3 = 8;
                            }
                        } else {
                            i3 = 8;
                        }
                        imageView.setVisibility(i3);
                    } else if (this.recentImageView.getVisibility() != 8) {
                        this.recentImageView.setVisibility(8);
                    }
                    if (item.getMergedInfo().getMergedIsCompleted()) {
                        this.completedImageView.setVisibility(0);
                        return;
                    } else {
                        this.completedImageView.setVisibility(8);
                        return;
                    }
                }
                this.textView.setText(this.this$0.this$0.getDaijishouLibrary().prettifyTitleWithPreferences(item.getName()));
                this.favoriteImageView.setVisibility(item.isFavorite() ? 0 : 8);
                this.newlyImageView.setVisibility(item.getAddedDateTimestamp().getTime() >= jM1822getInWholeMillisecondsimpl2 ? 0 : 8);
                if (this.this$0.this$0.getDefaultSharedPreferences().getBoolean(BooleanPreference.SHOW_RECENT_INDICATORS.getKey(), BooleanPreference.SHOW_RECENT_INDICATORS.getDefaultValue())) {
                    ImageView imageView2 = this.recentImageView;
                    if (item.getLastPlayedTimestamp() != null) {
                        Date lastPlayedTimestamp = item.getLastPlayedTimestamp();
                        Intrinsics.checkNotNull(lastPlayedTimestamp);
                        if (lastPlayedTimestamp.getTime() >= jM1822getInWholeMillisecondsimpl) {
                            i2 = 0;
                        } else {
                            i2 = 8;
                        }
                    } else {
                        i2 = 8;
                    }
                    imageView2.setVisibility(i2);
                } else if (this.recentImageView.getVisibility() != 8) {
                    this.recentImageView.setVisibility(8);
                }
                if (item.isCompleted()) {
                    this.completedImageView.setVisibility(0);
                } else {
                    this.completedImageView.setVisibility(8);
                }
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onSelect() {
                super.onSelect();
                this.layout.setBackground(this.this$0.shape);
                this.textView.setTextColor(this.this$0.colorOnPrimary);
                this.textView.setAlpha(1.0f);
                this.completedImageView.setImageTintList(new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{this.this$0.colorOnPrimary}));
                this.favoriteImageView.setImageTintList(new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{this.this$0.colorOnPrimary}));
                this.newlyImageView.setImageTintList(new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{this.this$0.colorOnPrimary}));
                this.recentImageView.setImageTintList(new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{this.this$0.colorOnPrimary}));
                this.textView.setTypeface(null, 1);
                this.textView.setSelected(true);
                this.itemView.setNextFocusRightId(this.this$0.RIGHT_FOCUS_ID);
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onUnselect() {
                super.onUnselect();
                this.layout.setBackground((Drawable) null);
                this.textView.setTextColor(this.textColorsBackup);
                this.textView.setAlpha(0.6f);
                this.favoriteImageView.setImageTintList(this.favoriteImageTintBackup);
                this.completedImageView.setImageTintList(this.completedImageTintBackup);
                this.newlyImageView.setImageTintList(this.newlyImageTintBackup);
                this.recentImageView.setImageTintList(this.recentImageTintBackup);
                this.textView.setTypeface(null, 0);
                this.textView.setSelected(false);
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
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_platform_library_playable_item, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
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
        String string6 = getString(R.string.selected_letter_formant);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        this.selectedLetterFormatString = string6;
        this.platformId = getLibraryViewModel().getSelectedPlatformId();
        String string7 = getString(R.string.platform_format);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        this.platformFormatString = string7;
        String string8 = getString(R.string.platform_library_list_tips_format);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        this.tipsFormatString = string8;
        String string9 = getString(R.string.playable_item_subtitle_format);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        this.descriptionFormatString = string9;
        String string10 = getString(R.string.playable_item_subtitle_with_genres_format);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        this.descriptionWithGenresFormatString = string10;
        PackageManager packageManager = fragmentActivityRequireActivity.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        this.packageManager = packageManager;
        Drawable drawable = AppCompatResources.getDrawable(contextRequireContext, R.drawable.ic_round_favorite_24);
        Intrinsics.checkNotNull(drawable);
        this.isFavoriteDrawable = drawable;
        Drawable drawable2 = AppCompatResources.getDrawable(contextRequireContext, R.drawable.ic_baseline_check_circle_24);
        Intrinsics.checkNotNull(drawable2);
        this.isCompletedDrawable = drawable2;
        Drawable drawable3 = AppCompatResources.getDrawable(contextRequireContext, R.drawable.ic_round_check_circle_outline_24);
        Intrinsics.checkNotNull(drawable3);
        this.isNotCompletedDrawable = drawable3;
        Drawable drawable4 = AppCompatResources.getDrawable(contextRequireContext, R.drawable.ic_round_favorite_border_24);
        Intrinsics.checkNotNull(drawable4);
        this.isNotFavoriteDrawable = drawable4;
        String[] stringArray = getResources().getStringArray(R.array.box_art_aspect_ratio_array);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        this.boxArtAspectRatioList = ArraysKt.toList(stringArray);
        String[] stringArray2 = getResources().getStringArray(R.array.screen_aspect_ratio_array);
        Intrinsics.checkNotNullExpressionValue(stringArray2, "getStringArray(...)");
        this.screenAspectRatioList = ArraysKt.toList(stringArray2);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Chip chip;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final SharedPreferences preferences = getLibraryViewModel().getPreferences();
        View viewInflate = inflater.inflate(R.layout.fragment_platform_library_list_view, viewGroup, false);
        ChipGroup chipGroupFindViewById = viewInflate.findViewById(R.id.player_associated_platforms_chip_group);
        Intrinsics.checkNotNullExpressionValue(chipGroupFindViewById, "findViewById(...)");
        this.chipGroup = chipGroupFindViewById;
        Chip chipFindViewById = viewInflate.findViewById(R.id.platform_library_play_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById, "findViewById(...)");
        this.playButton = chipFindViewById;
        RecyclerView recyclerViewFindViewById = viewInflate.findViewById(R.id.platform_library_list_recycler_view);
        Intrinsics.checkNotNullExpressionValue(recyclerViewFindViewById, "findViewById(...)");
        this.platformLibraryListRecyclerView = recyclerViewFindViewById;
        List<PlayableItemEntity> list = this.playableItemList;
        Chip chip2 = this.playButton;
        ImageView imageView = null;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip2 = null;
        }
        this.platformLibraryListRecyclerViewAdapter = new PlatformLibraryListAdapter(this, list, chip2.getId());
        View viewFindViewById = viewInflate.findViewById(R.id.platform_library_title_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById;
        this.titleTextView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlatformLibraryListViewNavFragment.onCreateView$lambda$12(this.f$0, view);
            }
        });
        View viewFindViewById2 = viewInflate.findViewById(R.id.platform_library_description_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.descriptionTextView = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.platform_library_platform_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.platformTextView = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.platform_library_thumbnail);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.thumbnailImageView = (ImageView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.platform_library_background);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.backgroundImageView = (ImageView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.platform_library_background_gradient);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.backgroundGradientImageView = (ImageView) viewFindViewById6;
        ConstraintLayout constraintLayoutFindViewById = viewInflate.findViewById(R.id.platform_library_background_set);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
        this.backgroundSetLayout = constraintLayoutFindViewById;
        View viewFindViewById7 = viewInflate.findViewById(R.id.platform_library_placeholder);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.placeholderImageView = (ImageView) viewFindViewById7;
        Chip chipFindViewById2 = viewInflate.findViewById(R.id.platform_library_favorite_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById2, "findViewById(...)");
        this.favoriteButton = chipFindViewById2;
        Chip chipFindViewById3 = viewInflate.findViewById(R.id.platform_library_completed_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById3, "findViewById(...)");
        this.completeButton = chipFindViewById3;
        Chip chipFindViewById4 = viewInflate.findViewById(R.id.platform_library_pin_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById4, "findViewById(...)");
        this.pinButton = chipFindViewById4;
        Chip chipFindViewById5 = viewInflate.findViewById(R.id.platform_library_recent_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById5, "findViewById(...)");
        this.recentButton = chipFindViewById5;
        Chip chipFindViewById6 = viewInflate.findViewById(R.id.platform_library_newly_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById6, "findViewById(...)");
        this.newlyButton = chipFindViewById6;
        Chip chipFindViewById7 = viewInflate.findViewById(R.id.platform_library_detail_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById7, "findViewById(...)");
        this.detailButton = chipFindViewById7;
        Chip chipFindViewById8 = viewInflate.findViewById(R.id.platform_library_grid_view_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById8, "findViewById(...)");
        this.gridViewButton = chipFindViewById8;
        Chip chipFindViewById9 = viewInflate.findViewById(R.id.platform_library_edit_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById9, "findViewById(...)");
        this.editButton = chipFindViewById9;
        initOrientationObserver();
        this.playableItemList.clear();
        Chip chip3 = this.editButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip3 = null;
        }
        chip3.setVisibility(isKioskMode() ? 8 : 0);
        Chip chip4 = this.gridViewButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
            chip4 = null;
        }
        if (isKioskMode()) {
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
        if (isKioskMode()) {
            Chip chip5 = this.gridViewButton;
            if (chip5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
                chip5 = null;
            }
            View view = (View) chip5;
            ChipGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.chip.ChipGroup.LayoutParams");
            }
            ChipGroup.LayoutParams layoutParams2 = (ViewGroup.LayoutParams) layoutParams;
            ChipGroup.LayoutParams layoutParams3 = layoutParams2;
            ChipGroup chipGroup = this.chipGroup;
            if (chipGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                chipGroup = null;
            }
            for (View view2 : ViewGroupKt.getChildren((ViewGroup) chipGroup)) {
                Chip chip6 = this.editButton;
                if (chip6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editButton");
                    chip6 = null;
                }
                if (Intrinsics.areEqual(view2, chip6)) {
                    ChipGroup chipGroup2 = this.chipGroup;
                    if (chipGroup2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chipGroup");
                        chipGroup2 = null;
                    }
                    chipGroup2.removeView(view2);
                }
            }
            layoutParams3.setMarginEnd(getDpToPxConverter().convert(8.0f));
            view.setLayoutParams(layoutParams2);
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
        recyclerView3.setItemAnimator((RecyclerView.ItemAnimator) null);
        Chip chip7 = this.playButton;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip7 = null;
        }
        ConstraintLayout constraintLayout = this.backgroundSetLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout = null;
        }
        chip7.setNextFocusUpId(constraintLayout.getId());
        Chip chip8 = this.favoriteButton;
        if (chip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("favoriteButton");
            chip8 = null;
        }
        ConstraintLayout constraintLayout2 = this.backgroundSetLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout2 = null;
        }
        chip8.setNextFocusUpId(constraintLayout2.getId());
        Chip chip9 = this.pinButton;
        if (chip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip9 = null;
        }
        ConstraintLayout constraintLayout3 = this.backgroundSetLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout3 = null;
        }
        chip9.setNextFocusUpId(constraintLayout3.getId());
        Chip chip10 = this.recentButton;
        if (chip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip10 = null;
        }
        ConstraintLayout constraintLayout4 = this.backgroundSetLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout4 = null;
        }
        chip10.setNextFocusUpId(constraintLayout4.getId());
        Chip chip11 = this.newlyButton;
        if (chip11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newlyButton");
            chip11 = null;
        }
        ConstraintLayout constraintLayout5 = this.backgroundSetLayout;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout5 = null;
        }
        chip11.setNextFocusUpId(constraintLayout5.getId());
        Chip chip12 = this.detailButton;
        if (chip12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailButton");
            chip12 = null;
        }
        ConstraintLayout constraintLayout6 = this.backgroundSetLayout;
        if (constraintLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout6 = null;
        }
        chip12.setNextFocusUpId(constraintLayout6.getId());
        Chip chip13 = this.gridViewButton;
        if (chip13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
            chip13 = null;
        }
        ConstraintLayout constraintLayout7 = this.backgroundSetLayout;
        if (constraintLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout7 = null;
        }
        chip13.setNextFocusUpId(constraintLayout7.getId());
        Chip chip14 = this.editButton;
        if (chip14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip14 = null;
        }
        ConstraintLayout constraintLayout8 = this.backgroundSetLayout;
        if (constraintLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout8 = null;
        }
        chip14.setNextFocusUpId(constraintLayout8.getId());
        ConstraintLayout constraintLayout9 = this.backgroundSetLayout;
        if (constraintLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout9 = null;
        }
        constraintLayout9.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PlatformLibraryListViewNavFragment.onCreateView$lambda$15(this.f$0, contextRequireContext, view3);
            }
        });
        ConstraintLayout constraintLayout10 = this.backgroundSetLayout;
        if (constraintLayout10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundSetLayout");
            constraintLayout10 = null;
        }
        constraintLayout10.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view3) {
                return PlatformLibraryListViewNavFragment.onCreateView$lambda$17(this.f$0, view3);
            }
        });
        Chip chip15 = this.playButton;
        if (chip15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            chip15 = null;
        }
        chip15.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PlatformLibraryListViewNavFragment.onCreateView$lambda$19(this.f$0, view3);
            }
        });
        initTypeface();
        initCompletedClickListener();
        initFavoriteClickListener();
        initChipFocusListener();
        Chip chip16 = this.pinButton;
        if (chip16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinButton");
            chip16 = null;
        }
        chip16.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PlatformLibraryListViewNavFragment.onCreateView$lambda$20(this.f$0, view3);
            }
        });
        Chip chip17 = this.detailButton;
        if (chip17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailButton");
            chip17 = null;
        }
        chip17.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PlatformLibraryListViewNavFragment.onCreateView$lambda$22(this.f$0, view3);
            }
        });
        Chip chip18 = this.gridViewButton;
        if (chip18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridViewButton");
            chip18 = null;
        }
        chip18.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PlatformLibraryListViewNavFragment.onCreateView$lambda$23(this.f$0, view3);
            }
        });
        Chip chip19 = this.editButton;
        if (chip19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButton");
            chip19 = null;
        }
        chip19.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PlatformLibraryListViewNavFragment.onCreateView$lambda$25(this.f$0, view3);
            }
        });
        PlatformLibraryListAdapter platformLibraryListAdapter2 = this.platformLibraryListRecyclerViewAdapter;
        if (platformLibraryListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            platformLibraryListAdapter2 = null;
        }
        platformLibraryListAdapter2.setOnItemSelectListener(new Function4<View, Integer, Long, PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.onCreateView.10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view3, Integer num, Long l, PlayableItemEntity playableItemEntity) {
                invoke(view3, num.intValue(), l.longValue(), playableItemEntity);
                return Unit.INSTANCE;
            }

            public final void invoke(View view3, int i, long j, PlayableItemEntity playableItemEntity) {
                Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
                preferences.edit().putInt(this.platformId + "_selected_position", i).apply();
                this.onUpdatePlayableItemEntity(playableItemEntity, i);
            }
        });
        PlatformLibraryListAdapter platformLibraryListAdapter3 = this.platformLibraryListRecyclerViewAdapter;
        if (platformLibraryListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            platformLibraryListAdapter3 = null;
        }
        platformLibraryListAdapter3.setOnItemClickListener(new Function4<View, Integer, Long, PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.onCreateView.11
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view3, Integer num, Long l, PlayableItemEntity playableItemEntity) {
                invoke(view3, num.intValue(), l.longValue(), playableItemEntity);
                return Unit.INSTANCE;
            }

            public final void invoke(View view3, int i, long j, PlayableItemEntity playableItemEntity) {
                Intrinsics.checkNotNullParameter(view3, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
                DaijishouLibraryModel daijishouLibrary = PlatformLibraryListViewNavFragment.this.getDaijishouLibrary();
                Activity activityRequireActivity = PlatformLibraryListViewNavFragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(activityRequireActivity, "requireActivity(...)");
                DaijishouLibraryModel.play$default(daijishouLibrary, activityRequireActivity, playableItemEntity, null, 4, null);
            }
        });
        PlatformLibraryListAdapter platformLibraryListAdapter4 = this.platformLibraryListRecyclerViewAdapter;
        if (platformLibraryListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
            platformLibraryListAdapter4 = null;
        }
        platformLibraryListAdapter4.setOnItemLongClickListener(new Function4<View, Integer, Long, PlayableItemEntity, Boolean>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.onCreateView.12
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Boolean invoke(View view3, Integer num, Long l, PlayableItemEntity playableItemEntity) {
                return invoke(view3, num.intValue(), l.longValue(), playableItemEntity);
            }

            public final Boolean invoke(View view3, int i, long j, PlayableItemEntity playableItemEntity) {
                Intrinsics.checkNotNullParameter(view3, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
                PlayableItemDetailDialogFragment.Companion.newInstance(playableItemEntity).show(PlatformLibraryListViewNavFragment.this.getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
                return true;
            }
        });
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.PRETTIFY_TITLES.getKey(), BooleanPreference.PRETTIFY_TITLES.getDefaultValue()).observe(getViewLifecycleOwner(), new PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.onCreateView.13
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                PlayableItemEntity playableItemEntity = PlatformLibraryListViewNavFragment.this.selectedPlayableItemEntity;
                PlatformLibraryListAdapter platformLibraryListAdapter5 = null;
                if (playableItemEntity != null) {
                    PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment = PlatformLibraryListViewNavFragment.this;
                    String name = playableItemEntity.getDisjointSetPrimaryPlayableItemId() == null ? playableItemEntity.getName() : playableItemEntity.getMergedInfo().getMergedName();
                    if (platformLibraryListViewNavFragment.getDefaultSharedPreferences().getBoolean("do_not_prettify_titles_in_details_view", false)) {
                        TextView textView2 = platformLibraryListViewNavFragment.titleTextView;
                        if (textView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                            textView2 = null;
                        }
                        textView2.setText(name);
                    } else {
                        TextView textView3 = platformLibraryListViewNavFragment.titleTextView;
                        if (textView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                            textView3 = null;
                        }
                        textView3.setText(platformLibraryListViewNavFragment.getDaijishouLibrary().prettifyTitleWithPreferences(name));
                    }
                }
                PlatformLibraryListAdapter platformLibraryListAdapter6 = PlatformLibraryListViewNavFragment.this.platformLibraryListRecyclerViewAdapter;
                if (platformLibraryListAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
                } else {
                    platformLibraryListAdapter5 = platformLibraryListAdapter6;
                }
                platformLibraryListAdapter5.notifyDataSetChanged();
            }
        }));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "do_not_prettify_titles_in_details_view", false).observe(getViewLifecycleOwner(), new PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.onCreateView.14
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                PlayableItemEntity playableItemEntity = PlatformLibraryListViewNavFragment.this.selectedPlayableItemEntity;
                PlatformLibraryListAdapter platformLibraryListAdapter5 = null;
                if (playableItemEntity != null) {
                    PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment = PlatformLibraryListViewNavFragment.this;
                    String name = playableItemEntity.getDisjointSetPrimaryPlayableItemId() == null ? playableItemEntity.getName() : playableItemEntity.getMergedInfo().getMergedName();
                    if (platformLibraryListViewNavFragment.getDefaultSharedPreferences().getBoolean("do_not_prettify_titles_in_details_view", false)) {
                        TextView textView2 = platformLibraryListViewNavFragment.titleTextView;
                        if (textView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                            textView2 = null;
                        }
                        textView2.setText(name);
                    } else {
                        TextView textView3 = platformLibraryListViewNavFragment.titleTextView;
                        if (textView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                            textView3 = null;
                        }
                        textView3.setText(platformLibraryListViewNavFragment.getDaijishouLibrary().prettifyTitleWithPreferences(name));
                    }
                }
                PlatformLibraryListAdapter platformLibraryListAdapter6 = PlatformLibraryListViewNavFragment.this.platformLibraryListRecyclerViewAdapter;
                if (platformLibraryListAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
                } else {
                    platformLibraryListAdapter5 = platformLibraryListAdapter6;
                }
                platformLibraryListAdapter5.notifyDataSetChanged();
            }
        }));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.SHOW_RECENT_INDICATORS.getKey(), BooleanPreference.SHOW_RECENT_INDICATORS.getDefaultValue()).observe(getViewLifecycleOwner(), new PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.onCreateView.15
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                PlatformLibraryListAdapter platformLibraryListAdapter5 = PlatformLibraryListViewNavFragment.this.platformLibraryListRecyclerViewAdapter;
                if (platformLibraryListAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("platformLibraryListRecyclerViewAdapter");
                    platformLibraryListAdapter5 = null;
                }
                platformLibraryListAdapter5.notifyDataSetChanged();
            }
        }));
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.FORCE_SET_WALLPAPER_FOR_ALL.getKey(), BooleanPreference.FORCE_SET_WALLPAPER_FOR_ALL.getDefaultValue()).observe(getViewLifecycleOwner(), new PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.onCreateView.16
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                ImageView imageView2 = PlatformLibraryListViewNavFragment.this.backgroundImageView;
                ImageView imageView3 = null;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backgroundImageView");
                    imageView2 = null;
                }
                Intrinsics.checkNotNull(bool);
                imageView2.setVisibility(bool.booleanValue() ? 8 : 0);
                ImageView imageView4 = PlatformLibraryListViewNavFragment.this.backgroundGradientImageView;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backgroundGradientImageView");
                } else {
                    imageView3 = imageView4;
                }
                imageView3.setVisibility(bool.booleanValue() ? 8 : 0);
            }
        }));
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = getMergePlayableItemsPreference();
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue()).observe(getViewLifecycleOwner(), new PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.onCreateView.17
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                if (Intrinsics.areEqual(Boolean.valueOf(booleanRef.element), bool)) {
                    return;
                }
                Ref.BooleanRef booleanRef2 = booleanRef;
                Intrinsics.checkNotNull(bool);
                booleanRef2.element = bool.booleanValue();
                PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment = this;
                PlatformLibraryListViewNavFragment.onCreateView$refreshPlayableItems(platformLibraryListViewNavFragment, preferences, platformLibraryListViewNavFragment.getLibraryViewModel().getAllPlayableItemsStatically());
            }
        }));
        ImageView imageView2 = this.backgroundImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backgroundImageView");
        } else {
            imageView = imageView2;
        }
        final float alpha = imageView.getAlpha();
        new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "use_pure_dark_theme", false).observe(getViewLifecycleOwner(), new PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.onCreateView.18
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                PlaidColorUtils plaidColorUtils = PlaidColorUtils.INSTANCE;
                Context contextRequireContext3 = PlatformLibraryListViewNavFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                if (plaidColorUtils.isDarkTheme(contextRequireContext3)) {
                    Intrinsics.checkNotNull(bool);
                    ImageView imageView3 = null;
                    if (bool.booleanValue()) {
                        ImageView imageView4 = PlatformLibraryListViewNavFragment.this.backgroundImageView;
                        if (imageView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("backgroundImageView");
                        } else {
                            imageView3 = imageView4;
                        }
                        imageView3.setAlpha(0.225f);
                        return;
                    }
                    ImageView imageView5 = PlatformLibraryListViewNavFragment.this.backgroundImageView;
                    if (imageView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("backgroundImageView");
                    } else {
                        imageView3 = imageView5;
                    }
                    imageView3.setAlpha(alpha);
                }
            }
        }));
        getLibraryViewModel().getAllPlayableItems().observe(getViewLifecycleOwner(), new PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends PlayableItemEntity>, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.onCreateView.19
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlayableItemEntity> list2) {
                invoke2((List<PlayableItemEntity>) list2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<PlayableItemEntity> list2) {
                PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment = PlatformLibraryListViewNavFragment.this;
                SharedPreferences sharedPreferences = preferences;
                Intrinsics.checkNotNull(list2);
                PlatformLibraryListViewNavFragment.onCreateView$refreshPlayableItems(platformLibraryListViewNavFragment, sharedPreferences, list2);
            }
        }));
        getDaijishouLibrary().getPlatformById(this.platformId).observe(getViewLifecycleOwner(), new PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<PlatformEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.onCreateView.20
            

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
                        List list2 = platformLibraryListViewNavFragment.screenAspectRatioList;
                        if (list2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("screenAspectRatioList");
                            list2 = null;
                        }
                        customScreenAspectRatio = (String) list2.get(platformEntity.getScreenAspectRatioId());
                    }
                    platformLibraryListViewNavFragment.screenAspectRatio = customScreenAspectRatio;
                    if (platformEntity.getUseCustomBoxArtAspectRatio()) {
                        customBoxArtAspectRatio = platformEntity.getCustomBoxArtAspectRatio();
                    } else {
                        List list3 = platformLibraryListViewNavFragment.boxArtAspectRatioList;
                        if (list3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("boxArtAspectRatioList");
                            list3 = null;
                        }
                        customBoxArtAspectRatio = (String) list3.get(platformEntity.getBoxArtAspectRatioId());
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
        }));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$12(PlatformLibraryListViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = this$0.selectedPlayableItemEntity;
        String name = playableItemEntity != null ? playableItemEntity.getName() : null;
        if (name != null) {
            TextView textView = this$0.titleTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                textView = null;
            }
            TextView textView2 = this$0.titleTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                textView2 = null;
            }
            textView.setText(Intrinsics.areEqual(textView2.getText(), name) ? DaijishouLibraryModel.prettifyTitle$default(this$0.getDaijishouLibrary(), name, false, 2, null) : name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$15(PlatformLibraryListViewNavFragment this$0, Context context, View view) {
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
    public static final boolean onCreateView$lambda$17(PlatformLibraryListViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = this$0.selectedPlayableItemEntity;
        if (playableItemEntity == null) {
            return true;
        }
        PlayableItemDetailDialogFragment.Companion.newInstance(playableItemEntity).show(this$0.getParentFragmentManager(), "playable_item_detail");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$19(PlatformLibraryListViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = this$0.selectedPlayableItemEntity;
        if (playableItemEntity != null) {
            DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
            Activity activityRequireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(activityRequireActivity, "requireActivity(...)");
            DaijishouLibraryModel.play$default(daijishouLibrary, activityRequireActivity, playableItemEntity, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$20(final PlatformLibraryListViewNavFragment this$0, View view) {
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
                widgetManager.requestWidgetInstanceRemoval((AppCompatActivity) fragmentActivityRequireActivity, PinAndPlayWidgetBuilder.class, playableItemEntity.getMergedInfo().getMergedDisjointSetPrimaryPlayableItemIds(), new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$onCreateView$6$2
                    

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment;
                        int i;
                        Context contextRequireContext = this.this$0.requireContext();
                        if (z) {
                            platformLibraryListViewNavFragment = this.this$0;
                            i = R.string.remove_pin_succeed_message;
                        } else {
                            platformLibraryListViewNavFragment = this.this$0;
                            i = R.string.remove_pin_failed_message;
                        }
                        Toast.makeText(contextRequireContext, platformLibraryListViewNavFragment.getString(i), 0).show();
                    }
                });
            } else {
                WidgetsManager widgetManager2 = this$0.getWidgetManager();
                FragmentActivity fragmentActivityRequireActivity2 = this$0.requireActivity();
                Intrinsics.checkNotNull(fragmentActivityRequireActivity2, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                widgetManager2.requestWidgetInstanceCreation((AppCompatActivity) fragmentActivityRequireActivity2, PinAndPlayWidgetBuilder.class, Long.valueOf(playableItemEntity.getId()), new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$onCreateView$6$1
                    

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment;
                        int i;
                        Context contextRequireContext = this.this$0.requireContext();
                        if (z) {
                            platformLibraryListViewNavFragment = this.this$0;
                            i = R.string.pin_succeed_message;
                        } else {
                            platformLibraryListViewNavFragment = this.this$0;
                            i = R.string.pin_failed_message;
                        }
                        Toast.makeText(contextRequireContext, platformLibraryListViewNavFragment.getString(i), 0).show();
                    }
                });
            }
        } else if (this$0.getPinAndPlayWidget().isPlayableItemIdInAPinAndPlayWidget(playableItemEntity.getId())) {
            WidgetsManager widgetManager3 = this$0.getWidgetManager();
            FragmentActivity fragmentActivityRequireActivity3 = this$0.requireActivity();
            Intrinsics.checkNotNull(fragmentActivityRequireActivity3, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            widgetManager3.requestWidgetInstanceRemoval((AppCompatActivity) fragmentActivityRequireActivity3, PinAndPlayWidgetBuilder.class, Long.valueOf(playableItemEntity.getId()), new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$onCreateView$6$4
                

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment;
                    int i;
                    Context contextRequireContext = this.this$0.requireContext();
                    if (z) {
                        platformLibraryListViewNavFragment = this.this$0;
                        i = R.string.remove_pin_succeed_message;
                    } else {
                        platformLibraryListViewNavFragment = this.this$0;
                        i = R.string.remove_pin_failed_message;
                    }
                    Toast.makeText(contextRequireContext, platformLibraryListViewNavFragment.getString(i), 0).show();
                }
            });
        } else {
            WidgetsManager widgetManager4 = this$0.getWidgetManager();
            FragmentActivity fragmentActivityRequireActivity4 = this$0.requireActivity();
            Intrinsics.checkNotNull(fragmentActivityRequireActivity4, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            widgetManager4.requestWidgetInstanceCreation((AppCompatActivity) fragmentActivityRequireActivity4, PinAndPlayWidgetBuilder.class, Long.valueOf(playableItemEntity.getId()), new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment$onCreateView$6$3
                

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    PlatformLibraryListViewNavFragment platformLibraryListViewNavFragment;
                    int i;
                    Context contextRequireContext = this.this$0.requireContext();
                    if (z) {
                        platformLibraryListViewNavFragment = this.this$0;
                        i = R.string.pin_succeed_message;
                    } else {
                        platformLibraryListViewNavFragment = this.this$0;
                        i = R.string.pin_failed_message;
                    }
                    Toast.makeText(contextRequireContext, platformLibraryListViewNavFragment.getString(i), 0).show();
                }
            });
        }
        this$0.refreshPinButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$22(PlatformLibraryListViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = this$0.selectedPlayableItemEntity;
        if (playableItemEntity != null) {
            PlayableItemDetailDialogFragment.Companion.newInstance(playableItemEntity).show(this$0.getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$23(PlatformLibraryListViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.toggleViewMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$25(PlatformLibraryListViewNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = this$0.selectedPlayableItemEntity;
        if (playableItemEntity != null) {
            DaijishouLibraryModel daijishouLibrary = this$0.getDaijishouLibrary();
            FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            daijishouLibrary.editPlayableItem((Activity) fragmentActivityRequireActivity, playableItemEntity);
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
                            if (i == platformLibraryListAdapter2.getSelectedPosition()) {
                                platformLibraryListViewNavFragment.onUpdatePlayableItemEntity(playableItemEntity, i);
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

    private final void initOrientationObserver() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new OrientationObserver(contextRequireContext, new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.nav.PlatformLibraryListViewNavFragment.initOrientationObserver.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                PlatformLibraryListViewNavFragment.this.onOrientationChanged();
            }
        });
        onOrientationChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onOrientationChanged() {
        boolean z = getResources().getConfiguration().orientation == 1;
        NavController navControllerFindNavController = FragmentKt.findNavController(this);
        if (z) {
            navControllerFindNavController.navigate(R.id.platformLibraryListToPlatformLibraryGridAction);
        }
    }
}
