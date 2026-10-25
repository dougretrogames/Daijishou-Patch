package com.magneticchen.daijishou.dialog_fragments;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.ViewPreloadSizeProvider;
import com.google.android.material.chip.Chip;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment;
import com.magneticchen.daijishou.activities.MainActivity;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouGridLayoutManager;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.live_data.PairLiveData;
import com.magneticchen.daijishou.live_data.SharedPreferenceIntLiveData;
import com.magneticchen.daijishou.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.repositories.RetroAchievementsRepository;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsAchievementRecordEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserAwardEntity;
import com.magneticchen.daijishou.utils.DpToPxConverter;
import com.magneticchen.daijishou.utils.Utils;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.skydoves.balloon.BalloonExtensionKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 a2\u00020\u0001:\u0003_`aB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020JH\u0002J\b\u0010K\u001a\u000205H\u0016J\u0012\u0010L\u001a\u00020G2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J&\u0010O\u001a\u0004\u0018\u00010\u000b2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J \u0010T\u001a\u00020G2\u0006\u0010U\u001a\u00020\r2\u0006\u0010V\u001a\u00020\r2\u0006\u0010W\u001a\u00020XH\u0016J\b\u0010Y\u001a\u00020GH\u0016J\b\u0010Z\u001a\u00020GH\u0016J\u001a\u0010[\u001a\u00020G2\u0006\u0010H\u001a\u00020\u000b2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u0018\u0010\\\u001a\u00020G2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010^H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u000e\u0010#\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\"\u001a\u0004\b.\u0010+R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u00108\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\"\u001a\u0004\b:\u0010;R\u000e\u0010=\u001a\u00020>X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "achievements", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsAchievementRecordEntity;", "associateItemButton", "Lcom/google/android/material/chip/Chip;", "awardIcon", "Landroid/widget/ImageView;", "bottomDivider", "Landroid/view/View;", "colorHardcore", "", "colorIconThemeTintList", "Landroid/content/res/ColorStateList;", "colorOnThemeTintList", "colorSoftcore", "colorThemeTintList", "consoleIcon", "description", "Landroid/widget/TextView;", "descriptionSuffix", "forumButton", "greyscaleColorMatrix", "Landroid/graphics/ColorMatrix;", "greyscaleFilter", "Landroid/graphics/ColorMatrixColorFilter;", "guideButton", "highlightStrokeWidth", "", "getHighlightStrokeWidth", "()F", "highlightStrokeWidth$delegate", "Lkotlin/Lazy;", "placeHolder", "playableItemButton", "playableItemEntityToBeRestoredInDialog", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "playerCountButton", "playerCountDetailsFormatString", "", "getPlayerCountDetailsFormatString", "()Ljava/lang/String;", "playerCountDetailsFormatString$delegate", "playerCountFormatString", "getPlayerCountFormatString", "playerCountFormatString$delegate", "progressBar", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "recyclerView", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView;", "refocusOnScrolledToTop", "", "refreshButton", "retroAchievementsButton", "retroAchievementsRepository", "Lcom/magneticchen/daijishou/repositories/RetroAchievementsRepository;", "getRetroAchievementsRepository", "()Lcom/magneticchen/daijishou/repositories/RetroAchievementsRepository;", "retroAchievementsRepository$delegate", "scrollView", "Landroid/widget/HorizontalScrollView;", "scrollingOnBackPressed", "thumbnail", "Lcom/google/android/material/imageview/ShapeableImageView;", "title", "toggleViewButton", "viewMode", "viewToBeRefocus", "fillInRetroAchievementsMetaDataView", "", "view", "retroAchievementsGameRecord", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHotKeyPressed", "hotkeyCode", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onResume", "onStart", "onViewCreated", "refreshViewType", "retroAchievementsAchievementRecords", "", "AchievementGridAdapter", "AchievementListAdapter", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsGameDialogFragment extends DaijishouDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Typeface typeface;
    private Chip associateItemButton;
    private ImageView awardIcon;
    private View bottomDivider;
    private int colorHardcore;
    private ColorStateList colorIconThemeTintList;
    private ColorStateList colorOnThemeTintList;
    private int colorSoftcore;
    private ColorStateList colorThemeTintList;
    private ImageView consoleIcon;
    private TextView description;
    private TextView descriptionSuffix;
    private Chip forumButton;
    private final ColorMatrix greyscaleColorMatrix;
    private final ColorMatrixColorFilter greyscaleFilter;
    private Chip guideButton;
    private ImageView placeHolder;
    private Chip playableItemButton;
    private PlayableItemEntity playableItemEntityToBeRestoredInDialog;
    private Chip playerCountButton;
    private LinearProgressIndicator progressBar;
    private DaijishouRecyclerView recyclerView;
    private boolean refocusOnScrolledToTop;
    private Chip refreshButton;
    private Chip retroAchievementsButton;
    private HorizontalScrollView scrollView;
    private boolean scrollingOnBackPressed;
    private ShapeableImageView thumbnail;
    private TextView title;
    private Chip toggleViewButton;
    private int viewMode;
    private View viewToBeRefocus;
    private final List<RetroAchievementsAchievementRecordEntity> achievements = new ArrayList();

    /* JADX INFO: renamed from: playerCountFormatString$delegate, reason: from kotlin metadata */
    private final Lazy playerCountFormatString = LazyKt.lazy(new RetroAchievementsGameDialogFragment$playerCountFormatString$2(this));

    /* JADX INFO: renamed from: playerCountDetailsFormatString$delegate, reason: from kotlin metadata */
    private final Lazy playerCountDetailsFormatString = LazyKt.lazy(new RetroAchievementsGameDialogFragment$playerCountDetailsFormatString$2(this));

    /* JADX INFO: renamed from: retroAchievementsRepository$delegate, reason: from kotlin metadata */
    private final Lazy retroAchievementsRepository = LazyKt.lazy(new RetroAchievementsGameDialogFragment$retroAchievementsRepository$2(this));

    /* JADX INFO: renamed from: highlightStrokeWidth$delegate, reason: from kotlin metadata */
    private final Lazy highlightStrokeWidth = LazyKt.lazy(new RetroAchievementsGameDialogFragment$highlightStrokeWidth$2(this));

    /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment$Companion;", "", "()V", "typeface", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "newInstance", "Lcom/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment;", "retroAchievementsGameRecordId", "", "playableItemEntityToBeRestoredInDialog", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "colorThemeTintList", "Landroid/content/res/ColorStateList;", "colorOnThemeTintList", "colorIconThemeTintList", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ RetroAchievementsGameDialogFragment newInstance$default(Companion companion, long j, PlayableItemEntity playableItemEntity, ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, Object obj) {
            if ((i & 2) != 0) {
                playableItemEntity = null;
            }
            if ((i & 4) != 0) {
                colorStateList = null;
            }
            if ((i & 8) != 0) {
                colorStateList2 = null;
            }
            if ((i & 16) != 0) {
                colorStateList3 = null;
            }
            return companion.newInstance(j, playableItemEntity, colorStateList, colorStateList2, colorStateList3);
        }

        public final RetroAchievementsGameDialogFragment newInstance(long retroAchievementsGameRecordId, PlayableItemEntity playableItemEntityToBeRestoredInDialog, ColorStateList colorThemeTintList, ColorStateList colorOnThemeTintList, ColorStateList colorIconThemeTintList) {
            RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment = new RetroAchievementsGameDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("retroAchievementsGameRecordId", retroAchievementsGameRecordId);
            bundle.putParcelable("playableItemEntityToBeRestoredInDialog", playableItemEntityToBeRestoredInDialog);
            if (colorThemeTintList != null) {
                bundle.putParcelable("colorThemeTintList", colorThemeTintList);
            }
            if (colorIconThemeTintList != null) {
                bundle.putParcelable("colorIconThemeTintList", colorIconThemeTintList);
            }
            if (colorOnThemeTintList != null) {
                bundle.putParcelable("colorOnThemeTintList", colorOnThemeTintList);
            }
            retroAchievementsGameDialogFragment.setArguments(bundle);
            return retroAchievementsGameDialogFragment;
        }

        public final Typeface getTypeface() {
            return RetroAchievementsGameDialogFragment.typeface;
        }
    }

    public RetroAchievementsGameDialogFragment() {
        ColorMatrix colorMatrix = new ColorMatrix();
        this.greyscaleColorMatrix = colorMatrix;
        colorMatrix.setSaturation(0.0f);
        this.greyscaleFilter = new ColorMatrixColorFilter(colorMatrix);
    }

    static {
        Typeface typefaceDefaultFromStyle;
        String str;
        if (Build.VERSION.SDK_INT >= 28) {
            typefaceDefaultFromStyle = Typeface.create(null, Constants.semiBolderWeight, false);
            str = "create(...)";
        } else {
            typefaceDefaultFromStyle = Typeface.defaultFromStyle(1);
            str = "defaultFromStyle(...)";
        }
        Intrinsics.checkNotNullExpressionValue(typefaceDefaultFromStyle, str);
        typeface = typefaceDefaultFromStyle;
    }

    private final String getPlayerCountFormatString() {
        return (String) this.playerCountFormatString.getValue();
    }

    private final String getPlayerCountDetailsFormatString() {
        return (String) this.playerCountDetailsFormatString.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RetroAchievementsRepository getRetroAchievementsRepository() {
        return (RetroAchievementsRepository) this.retroAchievementsRepository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getHighlightStrokeWidth() {
        return ((Number) this.highlightStrokeWidth.getValue()).floatValue();
    }

    /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u0010\u001a\u001a\n0\u001bR\u00060\u0000R\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment$AchievementListAdapter;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsAchievementRecordEntity;", "context", "Landroid/content/Context;", "retroAchievementsAchievementDataList", "", "(Lcom/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment;Landroid/content/Context;Ljava/util/List;)V", "achievementCompletedString", "", "achievementDetailFormatString", "achievementHardcoreCompletedString", "achievementIncompleteString", "achievementPointsFormatString", "getGlidePreloadRequestBuilder", "Lkotlin/Function1;", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "glideViewPreloadSizeProvider", "Lcom/bumptech/glide/util/ViewPreloadSizeProvider;", "noDescriptionForThisAchievementString", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment$AchievementListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment;", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AchievementListAdapter extends DaijishouRecyclerView.Adapter<RetroAchievementsAchievementRecordEntity> {
        private final String achievementCompletedString;
        private final String achievementDetailFormatString;
        private final String achievementHardcoreCompletedString;
        private final String achievementIncompleteString;
        private final String achievementPointsFormatString;
        private final Context context;
        private final Function1<RetroAchievementsAchievementRecordEntity, RequestBuilder<Drawable>> getGlidePreloadRequestBuilder;
        private final ViewPreloadSizeProvider<RetroAchievementsAchievementRecordEntity> glideViewPreloadSizeProvider;
        private final String noDescriptionForThisAchievementString;
        private final List<RetroAchievementsAchievementRecordEntity> retroAchievementsAchievementDataList;
        final /* synthetic */ RetroAchievementsGameDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AchievementListAdapter(RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment, Context context, List<RetroAchievementsAchievementRecordEntity> retroAchievementsAchievementDataList) {
            super(retroAchievementsAchievementDataList, true, false, 4, null);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(retroAchievementsAchievementDataList, "retroAchievementsAchievementDataList");
            this.this$0 = retroAchievementsGameDialogFragment;
            this.context = context;
            this.retroAchievementsAchievementDataList = retroAchievementsAchievementDataList;
            setEnforceSelectionInSelectableMode(false);
            String string = retroAchievementsGameDialogFragment.getString(R.string.achievement_points_format);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.achievementPointsFormatString = string;
            String string2 = retroAchievementsGameDialogFragment.getString(R.string.achievement_softcore);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            this.achievementCompletedString = string2;
            String string3 = retroAchievementsGameDialogFragment.getString(R.string.achievement_hardcore);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            this.achievementHardcoreCompletedString = string3;
            String string4 = retroAchievementsGameDialogFragment.getString(R.string.achievement_incomplete);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            this.achievementIncompleteString = string4;
            String string5 = retroAchievementsGameDialogFragment.getString(R.string.achievement_detail_format);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            this.achievementDetailFormatString = string5;
            String string6 = retroAchievementsGameDialogFragment.getString(R.string.no_description_for_this_achievement);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            this.noDescriptionForThisAchievementString = string6;
            RetroAchievementsGameDialogFragment$AchievementListAdapter$getGlidePreloadRequestBuilder$1 retroAchievementsGameDialogFragment$AchievementListAdapter$getGlidePreloadRequestBuilder$1 = new RetroAchievementsGameDialogFragment$AchievementListAdapter$getGlidePreloadRequestBuilder$1(retroAchievementsGameDialogFragment);
            this.getGlidePreloadRequestBuilder = retroAchievementsGameDialogFragment$AchievementListAdapter$getGlidePreloadRequestBuilder$1;
            this.glideViewPreloadSizeProvider = DaijishouRecyclerView.Adapter.addGlidePreloaderBuilderCreator$default(this, retroAchievementsGameDialogFragment$AchievementListAdapter$getGlidePreloadRequestBuilder$1, 0, 2, null);
        }

        /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment$AchievementListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsAchievementRecordEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment$AchievementListAdapter;Landroid/view/View;)V", "colorHardcoreColorStateList", "Landroid/content/res/ColorStateList;", "completedIcon", "Landroid/widget/ImageView;", "completedIconImageTintList", "defaultBorderColor", "defaultStrokeWidth", "", "description", "Landroid/widget/TextView;", "imageView", "Lcom/google/android/material/imageview/ShapeableImageView;", "pointsSubtitle", "progressDescription", "title", "onBind", "", "position", "", "item", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<RetroAchievementsAchievementRecordEntity>.ViewHolder {
            private final ColorStateList colorHardcoreColorStateList;
            private final ImageView completedIcon;
            private final ColorStateList completedIconImageTintList;
            private final ColorStateList defaultBorderColor;
            private final float defaultStrokeWidth;
            private final TextView description;
            private final ShapeableImageView imageView;
            private final TextView pointsSubtitle;
            private final TextView progressDescription;
            final /* synthetic */ AchievementListAdapter this$0;
            private final TextView title;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(AchievementListAdapter achievementListAdapter, View itemView) {
                super(achievementListAdapter, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = achievementListAdapter;
                View viewFindViewById = itemView.findViewById(R.id.retro_achievements_item_image_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                ShapeableImageView shapeableImageView = (ShapeableImageView) viewFindViewById;
                this.imageView = shapeableImageView;
                View viewFindViewById2 = itemView.findViewById(R.id.retro_achievements_item_title);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.title = (TextView) viewFindViewById2;
                View viewFindViewById3 = itemView.findViewById(R.id.retro_achievements_item_points_subtitle);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                this.pointsSubtitle = (TextView) viewFindViewById3;
                View viewFindViewById4 = itemView.findViewById(R.id.retro_achievements_item_progress_description);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
                this.progressDescription = (TextView) viewFindViewById4;
                View viewFindViewById5 = itemView.findViewById(R.id.retro_achievements_item_completed_icon);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
                ImageView imageView = (ImageView) viewFindViewById5;
                this.completedIcon = imageView;
                View viewFindViewById6 = itemView.findViewById(R.id.retro_achievements_item_description);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
                this.description = (TextView) viewFindViewById6;
                this.defaultBorderColor = shapeableImageView.getStrokeColor();
                this.defaultStrokeWidth = shapeableImageView.getStrokeWidth();
                this.completedIconImageTintList = imageView.getImageTintList();
                this.colorHardcoreColorStateList = new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{achievementListAdapter.this$0.colorHardcore});
                achievementListAdapter.glideViewPreloadSizeProvider.setView(shapeableImageView);
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int position, RetroAchievementsAchievementRecordEntity item) {
                String str;
                String description;
                Intrinsics.checkNotNullParameter(item, "item");
                TypedValue typedValue = new TypedValue();
                this.this$0.this$0.requireActivity().getTheme().resolveAttribute(R.attr.colorControlNormal, typedValue, true);
                int color = ContextCompat.getColor(this.this$0.this$0.requireContext(), typedValue.resourceId);
                this.title.setText(item.getName());
                TextView textView = this.pointsSubtitle;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str2 = String.format(this.this$0.achievementPointsFormatString, Arrays.copyOf(new Object[]{Integer.valueOf(item.getPoints())}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                textView.setText(str2);
                TextView textView2 = this.progressDescription;
                if (item.isHardcoreUnlocked()) {
                    str = this.this$0.achievementHardcoreCompletedString;
                } else {
                    str = item.isUnlocked() ? this.this$0.achievementCompletedString : this.this$0.achievementIncompleteString;
                }
                textView2.setText(str);
                this.completedIcon.setVisibility((item.isUnlocked() || item.isHardcoreUnlocked()) ? 0 : 8);
                this.completedIcon.setImageTintList(item.isHardcoreUnlocked() ? this.colorHardcoreColorStateList : this.completedIconImageTintList);
                if (item.isHardcoreUnlocked()) {
                    this.imageView.setColorFilter((ColorFilter) null);
                    this.progressDescription.setTextColor(color);
                    this.imageView.setStrokeWidth(this.this$0.this$0.getHighlightStrokeWidth());
                    this.imageView.setStrokeColor(this.colorHardcoreColorStateList);
                } else if (!item.isUnlocked()) {
                    this.imageView.setColorFilter(this.this$0.this$0.greyscaleFilter);
                    this.imageView.setStrokeWidth(this.defaultStrokeWidth);
                    this.imageView.setStrokeColor(this.defaultBorderColor);
                } else {
                    this.imageView.setColorFilter((ColorFilter) null);
                    this.progressDescription.setTextColor(color);
                    this.imageView.setStrokeWidth(this.this$0.this$0.getHighlightStrokeWidth());
                    if (this.this$0.this$0.colorThemeTintList != null) {
                        this.imageView.setStrokeColor(this.this$0.this$0.colorThemeTintList);
                    } else {
                        this.imageView.setStrokeColorResource(R.color.chip_normal_background_color);
                    }
                }
                TextView textView3 = this.description;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str3 = this.this$0.achievementDetailFormatString;
                Integer numValueOf = Integer.valueOf(position + 1);
                Integer numValueOf2 = Integer.valueOf(this.this$0.retroAchievementsAchievementDataList.size());
                if (item.getDescription() == null) {
                    description = this.this$0.noDescriptionForThisAchievementString;
                } else {
                    description = item.getDescription();
                }
                String str4 = String.format(str3, Arrays.copyOf(new Object[]{numValueOf, numValueOf2, description}, 3));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                textView3.setText(str4);
                if (item.getImageUrl() == null) {
                    Glide.with(this.this$0.this$0).clear(this.imageView);
                } else {
                    Glide.with(this.this$0.this$0).load((Object) item.getImageUrl()).transition(DrawableTransitionOptions.withCrossFade()).into(this.imageView);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            return this.retroAchievementsAchievementDataList.get(position).hashCode();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_retro_achievements_achievement, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\n0\u0018R\u00060\u0000R\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment$AchievementGridAdapter;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsAchievementRecordEntity;", "retroAchievementsAchievementDataList", "", "(Lcom/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment;Ljava/util/List;)V", "achievementPointsFormatString", "", "getGlidePreloadRequestBuilder", "Lkotlin/Function1;", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getGetGlidePreloadRequestBuilder", "()Lkotlin/jvm/functions/Function1;", "glideViewPreloadSizeProvider", "Lcom/bumptech/glide/util/ViewPreloadSizeProvider;", "getGlideViewPreloadSizeProvider", "()Lcom/bumptech/glide/util/ViewPreloadSizeProvider;", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment$AchievementGridAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment;", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AchievementGridAdapter extends DaijishouRecyclerView.Adapter<RetroAchievementsAchievementRecordEntity> {
        private final String achievementPointsFormatString;
        private final Function1<RetroAchievementsAchievementRecordEntity, RequestBuilder<Drawable>> getGlidePreloadRequestBuilder;
        private final ViewPreloadSizeProvider<RetroAchievementsAchievementRecordEntity> glideViewPreloadSizeProvider;
        private final List<RetroAchievementsAchievementRecordEntity> retroAchievementsAchievementDataList;
        final /* synthetic */ RetroAchievementsGameDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AchievementGridAdapter(RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment, List<RetroAchievementsAchievementRecordEntity> retroAchievementsAchievementDataList) {
            super(retroAchievementsAchievementDataList, true, false, 4, null);
            Intrinsics.checkNotNullParameter(retroAchievementsAchievementDataList, "retroAchievementsAchievementDataList");
            this.this$0 = retroAchievementsGameDialogFragment;
            this.retroAchievementsAchievementDataList = retroAchievementsAchievementDataList;
            setEnforceSelectionInSelectableMode(false);
            String string = retroAchievementsGameDialogFragment.getString(R.string.achievement_points_format);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.achievementPointsFormatString = string;
            RetroAchievementsGameDialogFragment$AchievementGridAdapter$getGlidePreloadRequestBuilder$1 retroAchievementsGameDialogFragment$AchievementGridAdapter$getGlidePreloadRequestBuilder$1 = new RetroAchievementsGameDialogFragment$AchievementGridAdapter$getGlidePreloadRequestBuilder$1(retroAchievementsGameDialogFragment);
            this.getGlidePreloadRequestBuilder = retroAchievementsGameDialogFragment$AchievementGridAdapter$getGlidePreloadRequestBuilder$1;
            this.glideViewPreloadSizeProvider = DaijishouRecyclerView.Adapter.addGlidePreloaderBuilderCreator$default(this, retroAchievementsGameDialogFragment$AchievementGridAdapter$getGlidePreloadRequestBuilder$1, 0, 2, null);
        }

        public final Function1<RetroAchievementsAchievementRecordEntity, RequestBuilder<Drawable>> getGetGlidePreloadRequestBuilder() {
            return this.getGlidePreloadRequestBuilder;
        }

        public final ViewPreloadSizeProvider<RetroAchievementsAchievementRecordEntity> getGlideViewPreloadSizeProvider() {
            return this.glideViewPreloadSizeProvider;
        }

        /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
        @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment$AchievementGridAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsAchievementRecordEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment$AchievementGridAdapter;Landroid/view/View;)V", "balloon", "Lcom/skydoves/balloon/Balloon;", "defaultBorderColor", "Landroid/content/res/ColorStateList;", "defaultPointsBackgroundTintList", "defaultStrokeWidth", "", "focused", "", "imageView", "Lcom/google/android/material/imageview/ShapeableImageView;", "isBalloonShown", "item", "pointsSubtitle", "Landroid/widget/TextView;", "onBind", "", "position", "", "onClick", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "refreshBorderStyle", "showToolTips", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<RetroAchievementsAchievementRecordEntity>.ViewHolder {
            private Balloon balloon;
            private final ColorStateList defaultBorderColor;
            private final ColorStateList defaultPointsBackgroundTintList;
            private final float defaultStrokeWidth;
            private boolean focused;
            private final ShapeableImageView imageView;
            public boolean isBalloonShown;
            private RetroAchievementsAchievementRecordEntity item;
            private final TextView pointsSubtitle;
            final /* synthetic */ AchievementGridAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(AchievementGridAdapter achievementGridAdapter, View itemView) {
                super(achievementGridAdapter, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = achievementGridAdapter;
                View viewFindViewById = itemView.findViewById(R.id.retro_achievements_item_image_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                ShapeableImageView shapeableImageView = (ShapeableImageView) viewFindViewById;
                this.imageView = shapeableImageView;
                View viewFindViewById2 = itemView.findViewById(R.id.retro_achievements_item_points_subtitle);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.pointsSubtitle = (TextView) viewFindViewById2;
                this.defaultBorderColor = shapeableImageView.getStrokeColor();
                this.defaultStrokeWidth = shapeableImageView.getStrokeWidth();
                this.defaultPointsBackgroundTintList = shapeableImageView.getBackgroundTintList();
                achievementGridAdapter.getGlideViewPreloadSizeProvider().setView(shapeableImageView);
            }

            private final void refreshBorderStyle() {
                RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity = this.item;
                if (retroAchievementsAchievementRecordEntity != null) {
                    Intrinsics.checkNotNull(retroAchievementsAchievementRecordEntity);
                    if (retroAchievementsAchievementRecordEntity.isHardcoreUnlocked()) {
                        this.imageView.setColorFilter((ColorFilter) null);
                        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{this.this$0.this$0.colorHardcore});
                        this.imageView.setStrokeWidth(this.this$0.this$0.getHighlightStrokeWidth());
                        this.imageView.setStrokeColor(colorStateList);
                        return;
                    }
                }
                RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity2 = this.item;
                if (retroAchievementsAchievementRecordEntity2 != null) {
                    Intrinsics.checkNotNull(retroAchievementsAchievementRecordEntity2);
                    if (retroAchievementsAchievementRecordEntity2.isUnlocked()) {
                        this.imageView.setColorFilter((ColorFilter) null);
                        this.imageView.setStrokeWidth(this.this$0.this$0.getHighlightStrokeWidth());
                        if (this.this$0.this$0.colorThemeTintList != null) {
                            this.imageView.setStrokeColor(this.this$0.this$0.colorThemeTintList);
                            return;
                        } else {
                            this.imageView.setStrokeColorResource(R.color.chip_normal_background_color);
                            return;
                        }
                    }
                }
                this.imageView.setColorFilter(this.this$0.this$0.greyscaleFilter);
                this.imageView.setStrokeWidth(this.defaultStrokeWidth);
                this.imageView.setStrokeColor(this.defaultBorderColor);
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int position, RetroAchievementsAchievementRecordEntity item) {
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
                this.pointsSubtitle.setTypeface(RetroAchievementsGameDialogFragment.INSTANCE.getTypeface());
                TextView textView = this.pointsSubtitle;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format(this.this$0.achievementPointsFormatString, Arrays.copyOf(new Object[]{Integer.valueOf(item.getPoints())}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                textView.setText(str);
                if (this.focused) {
                    this.imageView.setStrokeWidth(this.this$0.this$0.getHighlightStrokeWidth());
                }
                refreshBorderStyle();
                if (item.getImageUrl() == null) {
                    Glide.with(this.this$0.this$0).clear(this.imageView);
                } else {
                    Glide.with(this.this$0.this$0).load((Object) item.getImageUrl()).transition(DrawableTransitionOptions.withCrossFade()).into(this.imageView);
                }
            }

            private final void showToolTips() {
                RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity = (RetroAchievementsAchievementRecordEntity) this.this$0.retroAchievementsAchievementDataList.get(getAbsoluteAdapterPosition());
                Context contextRequireContext = this.this$0.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                Balloon.Builder lifecycleOwner = new Balloon.Builder(contextRequireContext).setDismissWhenTouchOutside(false).setFocusable(false).setText((CharSequence) ("🏁 " + retroAchievementsAchievementRecordEntity.getName() + "\n" + (retroAchievementsAchievementRecordEntity.isUnlocked() ? "✔ ️" : "❌ ") + retroAchievementsAchievementRecordEntity.getDescription())).setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR).setCornerRadius(8.0f).setPadding(8).setTextSize(15.0f).setMaxWidth(300).setMargin(12).setTextTypeface(RetroAchievementsGameDialogFragment.INSTANCE.getTypeface()).setBackgroundColorResource(R.color.chip_normal_background_color).setTextColorResource(R.color.chip_normal_text_color).setBalloonAnimation(BalloonAnimation.NONE).setLifecycleOwner(this.this$0.this$0.getViewLifecycleOwner());
                if (this.this$0.this$0.colorThemeTintList != null) {
                    ColorStateList colorStateList = this.this$0.this$0.colorThemeTintList;
                    Intrinsics.checkNotNull(colorStateList);
                    lifecycleOwner.setBackgroundColor(colorStateList.getColorForState(new int[]{android.R.attr.state_enabled}, 0));
                }
                if (this.this$0.this$0.colorOnThemeTintList != null) {
                    ColorStateList colorStateList2 = this.this$0.this$0.colorOnThemeTintList;
                    Intrinsics.checkNotNull(colorStateList2);
                    lifecycleOwner.setTextColor(colorStateList2.getColorForState(new int[]{android.R.attr.state_enabled}, 0));
                }
                this.balloon = lifecycleOwner.build();
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Balloon balloon = this.balloon;
                Intrinsics.checkNotNull(balloon);
                BalloonExtensionKt.showAlignBottom$default(itemView, balloon, 0, 0, 6, null);
                Balloon balloon2 = this.balloon;
                if (balloon2 != null) {
                    balloon2.setOnBalloonDismissListener(new RetroAchievementsGameDialogFragment$AchievementGridAdapter$ViewHolder$showToolTips$1(this));
                }
                Balloon balloon3 = this.balloon;
                if (balloon3 != null) {
                    balloon3.dismissWithDelay(8000L);
                }
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public boolean onClick() {
                super.onClick();
                if (this.isBalloonShown) {
                    return true;
                }
                this.isBalloonShown = true;
                showToolTips();
                return false;
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocus() {
                super.onFocus();
                this.focused = true;
                this.pointsSubtitle.setVisibility(0);
                this.itemView.setElevation(8.0f);
                refreshBorderStyle();
                Utils utils = Utils.INSTANCE;
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Utils.scaleView$default(utils, itemView, 1.0f, 1.1f, 0L, false, 24, null);
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocusClear(boolean isAbsoluteAdapterPositionValid) {
                super.onFocusClear(isAbsoluteAdapterPositionValid);
                this.focused = false;
                this.isBalloonShown = false;
                this.pointsSubtitle.setVisibility(4);
                Balloon balloon = this.balloon;
                if (balloon != null) {
                    balloon.dismiss();
                }
                this.balloon = null;
                this.itemView.setElevation(4.0f);
                refreshBorderStyle();
                if (isAbsoluteAdapterPositionValid) {
                    Utils utils = Utils.INSTANCE;
                    View itemView = this.itemView;
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    Utils.scaleView$default(utils, itemView, 1.1f, 1.0f, 0L, false, 24, null);
                }
                this.itemView.setElevation(0.0f);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            return this.retroAchievementsAchievementDataList.get(position).hashCode();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item_retro_achievements_achievement, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null && (colorStateList3 = (ColorStateList) arguments.getParcelable("colorThemeTintList")) != null) {
            this.colorThemeTintList = colorStateList3;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (colorStateList2 = (ColorStateList) arguments2.getParcelable("colorIconThemeTintList")) != null) {
            this.colorIconThemeTintList = colorStateList2;
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null && (colorStateList = (ColorStateList) arguments3.getParcelable("colorOnThemeTintList")) != null) {
            this.colorOnThemeTintList = colorStateList;
        }
        this.colorSoftcore = ContextCompat.getColor(requireContext(), R.color.retroachievements_softcore);
        this.colorHardcore = ContextCompat.getColor(requireContext(), R.color.retroachievements_hardcore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshViewType(List<RetroAchievementsAchievementRecordEntity> retroAchievementsAchievementRecords) {
        List listSortedWith = CollectionsKt.sortedWith(retroAchievementsAchievementRecords == null ? CollectionsKt.emptyList() : retroAchievementsAchievementRecords, new RetroAchievementsGameDialogFragment$refreshViewType$$inlined$sortedBy$1());
        int i = this.viewMode;
        DaijishouRecyclerView daijishouRecyclerView = null;
        if (i != 0) {
            if (i == 1) {
                Chip chip = this.toggleViewButton;
                if (chip == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("toggleViewButton");
                    chip = null;
                }
                chip.setChipIconResource(R.drawable.ic_round_view_list_24);
                Chip chip2 = this.toggleViewButton;
                if (chip2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("toggleViewButton");
                    chip2 = null;
                }
                chip2.setText(getString(R.string.list_view));
                DaijishouRecyclerView daijishouRecyclerView2 = this.recyclerView;
                if (daijishouRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    daijishouRecyclerView2 = null;
                }
                if (!(daijishouRecyclerView2.getLayoutManager() instanceof DaijishouGridLayoutManager)) {
                    DaijishouRecyclerView daijishouRecyclerView3 = this.recyclerView;
                    if (daijishouRecyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        daijishouRecyclerView3 = null;
                    }
                    Context contextRequireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    daijishouRecyclerView3.setLayoutManager(new DaijishouGridLayoutManager(contextRequireContext, 76.0f, 16, 0.0f, false, 24, null));
                }
                AchievementGridAdapter achievementGridAdapter = new AchievementGridAdapter(this, this.achievements);
                achievementGridAdapter.setOnItemClickListener(new C02282());
                DaijishouRecyclerView daijishouRecyclerView4 = this.recyclerView;
                if (daijishouRecyclerView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    daijishouRecyclerView = daijishouRecyclerView4;
                }
                AchievementGridAdapter achievementGridAdapter2 = achievementGridAdapter;
                daijishouRecyclerView.setAdapter(achievementGridAdapter2);
                DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new RetroAchievementsAchievementRecordDiffUtilCallback(this.achievements, listSortedWith));
                Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
                this.achievements.clear();
                this.achievements.addAll(listSortedWith);
                diffResultCalculateDiff.dispatchUpdatesTo(achievementGridAdapter2);
                return;
            }
            return;
        }
        Chip chip3 = this.toggleViewButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toggleViewButton");
            chip3 = null;
        }
        chip3.setChipIconResource(R.drawable.ic_round_grid_view_24);
        Chip chip4 = this.toggleViewButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toggleViewButton");
            chip4 = null;
        }
        chip4.setText(getString(R.string.grid_view));
        DaijishouRecyclerView daijishouRecyclerView5 = this.recyclerView;
        if (daijishouRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView5 = null;
        }
        if (!(daijishouRecyclerView5.getLayoutManager() instanceof DaijishouLinearLayoutManager)) {
            DaijishouRecyclerView daijishouRecyclerView6 = this.recyclerView;
            if (daijishouRecyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView6 = null;
            }
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            daijishouRecyclerView6.setLayoutManager(new DaijishouLinearLayoutManager(contextRequireContext2, 1, false));
        }
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        AchievementListAdapter achievementListAdapter = new AchievementListAdapter(this, contextRequireContext3, this.achievements);
        achievementListAdapter.setOnItemClickListener(new C02271());
        DaijishouRecyclerView daijishouRecyclerView7 = this.recyclerView;
        if (daijishouRecyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView7 = null;
        }
        AchievementListAdapter achievementListAdapter2 = achievementListAdapter;
        daijishouRecyclerView7.setAdapter(achievementListAdapter2);
        while (true) {
            DaijishouRecyclerView daijishouRecyclerView8 = this.recyclerView;
            if (daijishouRecyclerView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView8 = null;
            }
            if (daijishouRecyclerView8.getItemDecorationCount() > 0) {
                DaijishouRecyclerView daijishouRecyclerView9 = this.recyclerView;
                if (daijishouRecyclerView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    daijishouRecyclerView9 = null;
                }
                daijishouRecyclerView9.removeItemDecorationAt(0);
            } else {
                DiffUtil.DiffResult diffResultCalculateDiff2 = DiffUtil.calculateDiff(new RetroAchievementsAchievementRecordDiffUtilCallback(this.achievements, listSortedWith));
                Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff2, "calculateDiff(...)");
                this.achievements.clear();
                this.achievements.addAll(listSortedWith);
                diffResultCalculateDiff2.dispatchUpdatesTo(achievementListAdapter2);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.RetroAchievementsGameDialogFragment$refreshViewType$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "it", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsAchievementRecordEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class C02271 extends Lambda<Unit> implements Function4<View, Integer, Long, RetroAchievementsAchievementRecordEntity, Unit> {
        C02271() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity) {
            invoke(view, num.intValue(), l.longValue(), retroAchievementsAchievementRecordEntity);
            return Unit.INSTANCE;
        }

        public final void invoke(View view, int i, long j, RetroAchievementsAchievementRecordEntity it) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(it, "it");
            String url = it.getUrl();
            if (url != null) {
                RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment = RetroAchievementsGameDialogFragment.this;
                retroAchievementsGameDialogFragment.requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.RetroAchievementsGameDialogFragment$refreshViewType$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "it", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsAchievementRecordEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class C02282 extends Lambda<Unit> implements Function4<View, Integer, Long, RetroAchievementsAchievementRecordEntity, Unit> {
        C02282() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity) {
            invoke(view, num.intValue(), l.longValue(), retroAchievementsAchievementRecordEntity);
            return Unit.INSTANCE;
        }

        public final void invoke(View view, int i, long j, RetroAchievementsAchievementRecordEntity it) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(it, "it");
            String url = it.getUrl();
            if (url != null) {
                RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment = RetroAchievementsGameDialogFragment.this;
                retroAchievementsGameDialogFragment.requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
            }
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment
    public void onHotKeyPressed(int hotkeyCode, int keyCode, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(hotkeyCode, keyCode, keyEvent);
        getLogger().debug(this, "onHotKeyPressed");
        if (hotkeyCode != 3) {
            return;
        }
        Chip chip = this.refreshButton;
        Chip chip2 = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
            chip = null;
        }
        chip.requestFocus();
        Chip chip3 = this.toggleViewButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toggleViewButton");
        } else {
            chip2 = chip3;
        }
        chip2.performClick();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001b  */
    /* JADX WARN: Code duplicated, block: B:14:0x0027  */
    /* JADX WARN: Code duplicated, block: B:16:0x002b  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:9:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        if (r0.getScrollX() == 0) goto L19;
     */
    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment
    public boolean onBackPressed() {
        DaijishouRecyclerView daijishouRecyclerView = this.recyclerView;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView = null;
        }
        int scrollState = daijishouRecyclerView.getScrollState();
        if ((this.scrollingOnBackPressed && scrollState == 2) || (daijishouRecyclerView.computeVerticalScrollOffset() == 0 && (this.scrollView != null ? this.scrollView : null) != null && this.scrollView.getScrollX() == 0)) {
            DaijishouRecyclerView daijishouRecyclerView2 = this.recyclerView;
            if (daijishouRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView2 = null;
            }
            daijishouRecyclerView2.scrollToPosition(0);
            Chip chip = this.refreshButton;
            if (chip == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
                chip = null;
            }
            if (chip.isFocused()) {
                if (this.playableItemEntityToBeRestoredInDialog != null) {
                    PlayableItemDetailDialogFragment.INSTANCE.newInstance(this.playableItemEntityToBeRestoredInDialog).show(getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
                }
                return super.onBackPressed();
            }
            Chip chip2 = this.refreshButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
                chip2 = null;
            }
            chip2.requestFocus();
            Chip chip3 = this.refreshButton;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
                chip3 = null;
            }
            if (!chip3.isFocused()) {
                if (this.playableItemEntityToBeRestoredInDialog != null) {
                    PlayableItemDetailDialogFragment.INSTANCE.newInstance(this.playableItemEntityToBeRestoredInDialog).show(getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
                }
                return super.onBackPressed();
            }
            return false;
        }
        this.scrollingOnBackPressed = true;
        this.refocusOnScrolledToTop = true;
        DaijishouRecyclerView daijishouRecyclerView3 = this.recyclerView;
        if (daijishouRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView3 = null;
        }
        daijishouRecyclerView3.smoothScrollToPosition(0);
        android.widget.HorizontalScrollView horizontalScrollView = this.scrollView;
        if (horizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            horizontalScrollView = null;
        }
        horizontalScrollView.smoothScrollTo(0, 0);
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        Intrinsics.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog(...)");
        Window window = dialogRequireDialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        Window window2 = dialogRequireDialog.getWindow();
        if (window2 != null) {
            window2.setFlags(1024, 1024);
        }
        View view = this.viewToBeRefocus;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewToBeRefocus");
            view = null;
        }
        view.requestFocus();
    }

    private final void fillInRetroAchievementsMetaDataView(View view, RetroAchievementsGameRecordEntity retroAchievementsGameRecord) {
        String consoleImageUrl = getRetroAchievementsManager().getConsoleImageUrl(retroAchievementsGameRecord.getConsoleId());
        TextView textView = null;
        if (consoleImageUrl == null) {
            RequestManager requestManagerWith = Glide.with(this);
            ImageView imageView = this.consoleIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("consoleIcon");
                imageView = null;
            }
            requestManagerWith.clear(imageView);
            ImageView imageView2 = this.consoleIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("consoleIcon");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
        } else {
            RequestBuilder<Drawable> requestBuilderTransition = Glide.with(this).load((Object) consoleImageUrl).listener(new AnonymousClass1()).transition(DrawableTransitionOptions.withCrossFade());
            ImageView imageView3 = this.consoleIcon;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("consoleIcon");
                imageView3 = null;
            }
            requestBuilderTransition.into(imageView3);
        }
        if (retroAchievementsGameRecord.getImageUrl() == null) {
            RequestManager requestManagerWith2 = Glide.with(this);
            ShapeableImageView shapeableImageView = this.thumbnail;
            if (shapeableImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
                shapeableImageView = null;
            }
            requestManagerWith2.clear(shapeableImageView);
            ImageView imageView4 = this.placeHolder;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
                imageView4 = null;
            }
            imageView4.setVisibility(0);
        } else {
            RequestBuilder<Drawable> requestBuilderTransition2 = Glide.with(this).load((Object) retroAchievementsGameRecord.getImageUrl()).listener(new AnonymousClass2()).transition(DrawableTransitionOptions.withCrossFade());
            ShapeableImageView shapeableImageView2 = this.thumbnail;
            if (shapeableImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
                shapeableImageView2 = null;
            }
            requestBuilderTransition2.into(shapeableImageView2);
        }
        TextView textView2 = this.title;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView2 = null;
        }
        textView2.setText(retroAchievementsGameRecord.getName());
        String string = getString(R.string.achievement_completion_format, Integer.valueOf(retroAchievementsGameRecord.getUnlockedAchievementsCount()), Integer.valueOf(retroAchievementsGameRecord.getAchievementsCount()));
        TextView textView3 = this.description;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("description");
            textView3 = null;
        }
        textView3.setText(string);
        float unlockedAchievementsCount = ((float) retroAchievementsGameRecord.getAchievementsCount()) != 0.0f ? (retroAchievementsGameRecord.getUnlockedAchievementsCount() * 100.0f) / retroAchievementsGameRecord.getAchievementsCount() : 0.0f;
        LinearProgressIndicator linearProgressIndicator = this.progressBar;
        if (linearProgressIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            linearProgressIndicator = null;
        }
        linearProgressIndicator.setProgress(Math.max(3, (int) unlockedAchievementsCount));
        String consoleName = retroAchievementsGameRecord.getConsoleName();
        if (consoleName != null) {
            TextView textView4 = this.descriptionSuffix;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("descriptionSuffix");
            } else {
                textView = textView4;
            }
            textView.setText(consoleName);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.RetroAchievementsGameDialogFragment$fillInRetroAchievementsMetaDataView$1, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J2\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J8\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment$fillInRetroAchievementsMetaDataView$1", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", TypedValues.AttributesType.S_TARGET, "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass1 implements RequestListener<Drawable> {
        AnonymousClass1() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
            Intrinsics.checkNotNullParameter(target, "target");
            ImageView imageView = RetroAchievementsGameDialogFragment.this.consoleIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("consoleIcon");
                imageView = null;
            }
            imageView.setVisibility(8);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            Intrinsics.checkNotNullParameter(model, "model");
            Intrinsics.checkNotNullParameter(dataSource, "dataSource");
            ImageView imageView = RetroAchievementsGameDialogFragment.this.consoleIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("consoleIcon");
                imageView = null;
            }
            imageView.setVisibility(0);
            return false;
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.RetroAchievementsGameDialogFragment$fillInRetroAchievementsMetaDataView$2, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J2\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J8\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment$fillInRetroAchievementsMetaDataView$2", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", TypedValues.AttributesType.S_TARGET, "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass2 implements RequestListener<Drawable> {
        AnonymousClass2() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
            Intrinsics.checkNotNullParameter(target, "target");
            ImageView imageView = RetroAchievementsGameDialogFragment.this.placeHolder;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
                imageView = null;
            }
            imageView.setVisibility(0);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            Intrinsics.checkNotNullParameter(model, "model");
            Intrinsics.checkNotNullParameter(dataSource, "dataSource");
            ImageView imageView = RetroAchievementsGameDialogFragment.this.placeHolder;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
                imageView = null;
            }
            imageView.setVisibility(8);
            return false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("retroAchievementsGameRecordId")) : null;
        Intrinsics.checkNotNull(lValueOf);
        long jLongValue = lValueOf.longValue();
        RetroAchievementsGameRecordEntity retroAchievementsGameRecordByIdStatically = getRetroAchievementsRepository().getRetroAchievementsGameRecordByIdStatically(jLongValue);
        Intrinsics.checkNotNull(retroAchievementsGameRecordByIdStatically);
        Bundle arguments2 = getArguments();
        this.playableItemEntityToBeRestoredInDialog = arguments2 != null ? (PlayableItemEntity) arguments2.getParcelable("playableItemEntityToBeRestoredInDialog") : null;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Typeface typefaceCreate = Build.VERSION.SDK_INT >= 28 ? Typeface.create(null, Constants.semiBolderWeight, false) : Typeface.defaultFromStyle(1);
        View viewInflate = inflater.inflate(R.layout.fragment_retro_achievements_game, container, false);
        getDpToPxConverter().convert(2.0f);
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog);
        Window window = dialog.getWindow();
        Intrinsics.checkNotNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.rounded_full_screen_dialog_container);
        DisplayMetrics displayMetrics = requireContext().getResources().getDisplayMetrics();
        float f = displayMetrics.heightPixels / displayMetrics.widthPixels;
        if (f < 1.0f) {
            f = 1.0f / f;
        }
        if (f > 2.1111112f) {
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams).dimensionRatio = Constants.layoutDimensionRatio;
            constraintLayout.requestLayout();
        }
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_retro_achievements_game_thumbnail);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.thumbnail = (ShapeableImageView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_console_icon_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.consoleIcon = (ImageView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_award_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.awardIcon = (ImageView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_placeholder);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.placeHolder = (ImageView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_title_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.title = (TextView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_description_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.description = (TextView) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_description_suffix_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.descriptionSuffix = (TextView) viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(R.id.list_item_retro_achievements_game_linear_progress_indicator);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.progressBar = (LinearProgressIndicator) viewFindViewById8;
        View viewFindViewById9 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_bottom_divider);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.bottomDivider = viewFindViewById9;
        View viewFindViewById10 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_refresh_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.refreshButton = (Chip) viewFindViewById10;
        View viewFindViewById11 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_toggle_view_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.toggleViewButton = (Chip) viewFindViewById11;
        View viewFindViewById12 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_associate_item_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.associateItemButton = (Chip) viewFindViewById12;
        View viewFindViewById13 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_player_count_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.playerCountButton = (Chip) viewFindViewById13;
        View viewFindViewById14 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_guide_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.guideButton = (Chip) viewFindViewById14;
        View viewFindViewById15 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_forum_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.forumButton = (Chip) viewFindViewById15;
        View viewFindViewById16 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_playable_item_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        this.playableItemButton = (Chip) viewFindViewById16;
        View viewFindViewById17 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_retro_achievements_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        this.retroAchievementsButton = (Chip) viewFindViewById17;
        View viewFindViewById18 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_horizontal_scroll_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        this.scrollView = (HorizontalScrollView) viewFindViewById18;
        View viewFindViewById19 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
        this.recyclerView = (DaijishouRecyclerView) viewFindViewById19;
        if (this.colorThemeTintList != null) {
            TextView textView = this.description;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("description");
                textView = null;
            }
            textView.setBackgroundTintList(this.colorThemeTintList);
            Chip chip = this.toggleViewButton;
            if (chip == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toggleViewButton");
                chip = null;
            }
            chip.setChipBackgroundColor(this.colorThemeTintList);
            Chip chip2 = this.associateItemButton;
            if (chip2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("associateItemButton");
                chip2 = null;
            }
            chip2.setChipBackgroundColor(this.colorThemeTintList);
            Chip chip3 = this.playerCountButton;
            if (chip3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerCountButton");
                chip3 = null;
            }
            chip3.setChipBackgroundColor(this.colorThemeTintList);
            Chip chip4 = this.guideButton;
            if (chip4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideButton");
                chip4 = null;
            }
            chip4.setChipBackgroundColor(this.colorThemeTintList);
            Chip chip5 = this.forumButton;
            if (chip5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumButton");
                chip5 = null;
            }
            chip5.setChipBackgroundColor(this.colorThemeTintList);
            Chip chip6 = this.playableItemButton;
            if (chip6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playableItemButton");
                chip6 = null;
            }
            chip6.setChipBackgroundColor(this.colorThemeTintList);
            Chip chip7 = this.retroAchievementsButton;
            if (chip7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsButton");
                chip7 = null;
            }
            chip7.setChipStrokeColor(this.colorThemeTintList);
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        if (this.colorIconThemeTintList != null) {
            Chip chip8 = this.refreshButton;
            if (chip8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
                chip8 = null;
            }
            chip8.setChipIconTint(this.colorIconThemeTintList);
            Chip chip9 = this.retroAchievementsButton;
            if (chip9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsButton");
                chip9 = null;
            }
            chip9.setChipIconTint(this.colorIconThemeTintList);
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        if (this.colorOnThemeTintList != null) {
            Chip chip10 = this.toggleViewButton;
            if (chip10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toggleViewButton");
                chip10 = null;
            }
            chip10.setTextColor(this.colorOnThemeTintList);
            Chip chip11 = this.associateItemButton;
            if (chip11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("associateItemButton");
                chip11 = null;
            }
            chip11.setTextColor(this.colorOnThemeTintList);
            Chip chip12 = this.playerCountButton;
            if (chip12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerCountButton");
                chip12 = null;
            }
            chip12.setTextColor(this.colorOnThemeTintList);
            Chip chip13 = this.guideButton;
            if (chip13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideButton");
                chip13 = null;
            }
            chip13.setTextColor(this.colorOnThemeTintList);
            Chip chip14 = this.forumButton;
            if (chip14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forumButton");
                chip14 = null;
            }
            chip14.setTextColor(this.colorOnThemeTintList);
            Chip chip15 = this.playableItemButton;
            if (chip15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playableItemButton");
                chip15 = null;
            }
            chip15.setTextColor(this.colorOnThemeTintList);
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        HorizontalScrollView horizontalScrollView = this.scrollView;
        if (horizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            horizontalScrollView = null;
        }
        horizontalScrollView.setOnScrollChangeListener(new RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda0(this));
        DaijishouRecyclerView daijishouRecyclerView = this.recyclerView;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView = null;
        }
        daijishouRecyclerView.addOnScrollListener(new AnonymousClass5());
        Chip chip16 = this.refreshButton;
        if (chip16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
            chip16 = null;
        }
        chip16.setTypeface(typefaceCreate);
        Chip chip17 = this.refreshButton;
        if (chip17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
            chip17 = null;
        }
        this.viewToBeRefocus = chip17;
        Chip chip18 = this.toggleViewButton;
        if (chip18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toggleViewButton");
            chip18 = null;
        }
        chip18.setTypeface(typefaceCreate);
        Chip chip19 = this.associateItemButton;
        if (chip19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("associateItemButton");
            chip19 = null;
        }
        chip19.setTypeface(typefaceCreate);
        Chip chip20 = this.playerCountButton;
        if (chip20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerCountButton");
            chip20 = null;
        }
        chip20.setTypeface(typefaceCreate);
        Chip chip21 = this.guideButton;
        if (chip21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideButton");
            chip21 = null;
        }
        chip21.setTypeface(typefaceCreate);
        Chip chip22 = this.forumButton;
        if (chip22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forumButton");
            chip22 = null;
        }
        chip22.setTypeface(typefaceCreate);
        Chip chip23 = this.playableItemButton;
        if (chip23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemButton");
            chip23 = null;
        }
        chip23.setTypeface(typefaceCreate);
        Chip chip24 = this.refreshButton;
        if (chip24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
            chip24 = null;
        }
        chip24.setOnClickListener(new RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda4(this, retroAchievementsGameRecordByIdStatically));
        Chip chip25 = this.toggleViewButton;
        if (chip25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toggleViewButton");
            chip25 = null;
        }
        chip25.setOnClickListener(new RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda5(this));
        Context contextRequireContext = requireContext();
        Chip chip26 = this.associateItemButton;
        if (chip26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("associateItemButton");
            chip26 = null;
        }
        PopupMenu popupMenu = new PopupMenu(contextRequireContext, chip26);
        popupMenu.getMenu().add(0, 0, 0, getString(R.string.retro_achievements_associate_playable_item));
        popupMenu.getMenu().add(0, 1, 1, getString(R.string.retro_achievements_view_associated_playable_item));
        popupMenu.setOnMenuItemClickListener(new RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda6(retroAchievementsGameRecordByIdStatically, this));
        Chip chip27 = this.associateItemButton;
        if (chip27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("associateItemButton");
            chip27 = null;
        }
        chip27.setOnClickListener(new RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda7(popupMenu));
        Chip chip28 = this.playerCountButton;
        if (chip28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerCountButton");
            chip28 = null;
        }
        chip28.setOnClickListener(new RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda8(this, retroAchievementsGameRecordByIdStatically));
        Chip chip29 = this.playerCountButton;
        if (chip29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerCountButton");
            chip29 = null;
        }
        chip29.setVisibility(retroAchievementsGameRecordByIdStatically.getDistinctPlayerCount() <= 0 ? 8 : 0);
        Chip chip30 = this.playerCountButton;
        if (chip30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerCountButton");
            chip30 = null;
        }
        String playerCountFormatString = getPlayerCountFormatString();
        Intrinsics.checkNotNullExpressionValue(playerCountFormatString, "<get-playerCountFormatString>(...)");
        String str = String.format(playerCountFormatString, Arrays.copyOf(new Object[]{Long.valueOf(retroAchievementsGameRecordByIdStatically.getDistinctPlayerCount())}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        chip30.setText(str);
        Chip chip31 = this.guideButton;
        if (chip31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideButton");
            chip31 = null;
        }
        chip31.setOnClickListener(new RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda9(retroAchievementsGameRecordByIdStatically, this));
        Chip chip32 = this.guideButton;
        if (chip32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideButton");
            chip32 = null;
        }
        chip32.setVisibility(retroAchievementsGameRecordByIdStatically.getGuideUrl() == null ? 8 : 0);
        Chip chip33 = this.forumButton;
        if (chip33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forumButton");
            chip33 = null;
        }
        chip33.setOnClickListener(new RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda10(retroAchievementsGameRecordByIdStatically, this));
        Chip chip34 = this.forumButton;
        if (chip34 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forumButton");
            chip34 = null;
        }
        chip34.setVisibility(retroAchievementsGameRecordByIdStatically.getForumTopicId() == null ? 8 : 0);
        Chip chip35 = this.playableItemButton;
        if (chip35 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemButton");
            chip35 = null;
        }
        chip35.setOnClickListener(new RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda11(objectRef, this));
        Chip chip36 = this.refreshButton;
        if (chip36 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
            chip36 = null;
        }
        chip36.requestFocus();
        getRetroAchievementsRepository().getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionsByGameId(retroAchievementsGameRecordByIdStatically.getGameId()).observe(this, new RetroAchievementsGameDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass14(objectRef)));
        this.viewMode = getDefaultSharedPreferences().getInt("retro_achievements_game_view_mode", 0);
        refreshViewType(getRetroAchievementsRepository().getRetroAchievementsAchievementRecordsByGameRecordIdStatically(jLongValue));
        RetroAchievementsGameRecordEntity retroAchievementsGameRecordByIdStatically2 = getRetroAchievementsRepository().getRetroAchievementsGameRecordByIdStatically(jLongValue);
        if (retroAchievementsGameRecordByIdStatically2 != null) {
            onCreateView$updateRetroAchievementsGameRecord(this, viewInflate, retroAchievementsGameRecordByIdStatically2);
            Unit unit7 = Unit.INSTANCE;
            Unit unit8 = Unit.INSTANCE;
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        getRetroAchievementsRepository().getRetroAchievementsGameRecordById(jLongValue).observe(getViewLifecycleOwner(), new RetroAchievementsGameDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass16(booleanRef, this, viewInflate)));
        List<RetroAchievementsUserAwardEntity> retroAchievementsUserAwardsByUserIdAndAwardDataStatically = getRetroAchievementsRepository().getRetroAchievementsUserAwardsByUserIdAndAwardDataStatically(retroAchievementsGameRecordByIdStatically.getUserId(), retroAchievementsGameRecordByIdStatically.getGameId());
        ImageView imageView = this.awardIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("awardIcon");
            imageView = null;
        }
        imageView.setVisibility(retroAchievementsUserAwardsByUserIdAndAwardDataStatically.isEmpty() ? 8 : 0);
        Unit unit9 = Unit.INSTANCE;
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        booleanRef2.element = true;
        getRetroAchievementsRepository().getRetroAchievementsUserAwardsByUserIdAndAwardData(retroAchievementsGameRecordByIdStatically.getUserId(), retroAchievementsGameRecordByIdStatically.getGameId()).observe(getViewLifecycleOwner(), new RetroAchievementsGameDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass18(booleanRef2, this)));
        getRetroAchievementsManager().getRefreshingGameIdsLiveData().observe(getViewLifecycleOwner(), new RetroAchievementsGameDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass19(retroAchievementsGameRecordByIdStatically)));
        Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
        booleanRef3.element = true;
        new PairLiveData(new SharedPreferenceIntLiveData(getDefaultSharedPreferences(), "retro_achievements_game_view_mode", 0), getRetroAchievementsRepository().getRetroAchievementsAchievementRecordsByGameRecordId(jLongValue)).observe(getViewLifecycleOwner(), new RetroAchievementsGameDialogFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass20(booleanRef3, this)));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$11(RetroAchievementsGameDialogFragment this$0, View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.refocusOnScrolledToTop) {
            HorizontalScrollView horizontalScrollView = this$0.scrollView;
            Chip chip = null;
            if (horizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollView");
                horizontalScrollView = null;
            }
            if (horizontalScrollView.getScrollX() == 0) {
                this$0.refocusOnScrolledToTop = false;
                Chip chip2 = this$0.refreshButton;
                if (chip2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
                } else {
                    chip = chip2;
                }
                chip.requestFocus();
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.RetroAchievementsGameDialogFragment$onCreateView$5, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment$onCreateView$5", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass5 extends RecyclerView.OnScrollListener {
        AnonymousClass5() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0 && RetroAchievementsGameDialogFragment.this.refocusOnScrolledToTop) {
                HorizontalScrollView horizontalScrollView = RetroAchievementsGameDialogFragment.this.scrollView;
                Chip chip = null;
                if (horizontalScrollView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scrollView");
                    horizontalScrollView = null;
                }
                if (horizontalScrollView.getScrollX() == 0) {
                    RetroAchievementsGameDialogFragment.this.refocusOnScrolledToTop = false;
                    Chip chip2 = RetroAchievementsGameDialogFragment.this.refreshButton;
                    if (chip2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
                    } else {
                        chip = chip2;
                    }
                    chip.requestFocus();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx, dy);
            boolean z = recyclerView.computeVerticalScrollOffset() > RetroAchievementsGameDialogFragment.this.getDpToPxConverter().convert(8.0f);
            View view = null;
            if (z) {
                View view2 = RetroAchievementsGameDialogFragment.this.bottomDivider;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomDivider");
                    view2 = null;
                }
                if (view2.getVisibility() != 0) {
                    View view3 = RetroAchievementsGameDialogFragment.this.bottomDivider;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomDivider");
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
            View view4 = RetroAchievementsGameDialogFragment.this.bottomDivider;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomDivider");
                view4 = null;
            }
            if (view4.getVisibility() != 4) {
                View view5 = RetroAchievementsGameDialogFragment.this.bottomDivider;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomDivider");
                } else {
                    view = view5;
                }
                view.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$12(RetroAchievementsGameDialogFragment this$0, RetroAchievementsGameRecordEntity retroAchievementsGameRecord, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecord, "$retroAchievementsGameRecord");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getIO(), null, new RetroAchievementsGameDialogFragment$onCreateView$6$1(this$0, retroAchievementsGameRecord, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$13(RetroAchievementsGameDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getDefaultSharedPreferences().getInt("retro_achievements_game_view_mode", 0) == 1) {
            this$0.getDefaultSharedPreferences().edit().putInt("retro_achievements_game_view_mode", 0).apply();
        } else {
            this$0.getDefaultSharedPreferences().edit().putInt("retro_achievements_game_view_mode", 1).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$16(RetroAchievementsGameRecordEntity retroAchievementsGameRecord, RetroAchievementsGameDialogFragment this$0, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecord, "$retroAchievementsGameRecord");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (menuItem.getItemId() == 0) {
            ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragmentNewInstance$default = ChoosePlayableItemFromLibraryDialogFragment.Companion.newInstance$default(ChoosePlayableItemFromLibraryDialogFragment.INSTANCE, null, false, false, false, false, false, 63, null);
            choosePlayableItemFromLibraryDialogFragmentNewInstance$default.setOnClickListener(new RetroAchievementsGameDialogFragment$onCreateView$8$1(retroAchievementsGameRecord, this$0, choosePlayableItemFromLibraryDialogFragmentNewInstance$default));
            String name = retroAchievementsGameRecord.getName();
            if (name != null) {
                choosePlayableItemFromLibraryDialogFragmentNewInstance$default.setSearchText(name);
            }
            choosePlayableItemFromLibraryDialogFragmentNewInstance$default.show(this$0.getParentFragmentManager(), ChoosePlayableItemFromLibraryDialogFragment.class.getName());
            return false;
        }
        if (menuItem.getItemId() != 1) {
            return false;
        }
        List<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> retroAchievementsCachedPlayableItemIdToGameIdSurjectionsByGameIdStatically = this$0.getRetroAchievementsRepository().getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionsByGameIdStatically(retroAchievementsGameRecord.getGameId());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(retroAchievementsCachedPlayableItemIdToGameIdSurjectionsByGameIdStatically, 10));
        Iterator it = retroAchievementsCachedPlayableItemIdToGameIdSurjectionsByGameIdStatically.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity) it.next()).getPlayableItemId()));
        }
        Application application = this$0.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        DaijishouLibraryRepository daijishouLibraryRepository = ((DaijishouApplication) application).getDaijishouLibraryRepository();
        long[] longArray = CollectionsKt.toLongArray(arrayList);
        StaticPlayableItemCollectionDialogFragment staticPlayableItemCollectionDialogFragmentNewInstance$default = StaticPlayableItemCollectionDialogFragment.Companion.newInstance$default(StaticPlayableItemCollectionDialogFragment.INSTANCE, daijishouLibraryRepository.getPlayableItemsByIdsStatically(Arrays.copyOf(longArray, longArray.length)), this$0.getString(R.string.retro_achievements_view_associated_playable_item_title), false, 4, null);
        staticPlayableItemCollectionDialogFragmentNewInstance$default.setOnClickListener(new RetroAchievementsGameDialogFragment$onCreateView$8$3(this$0, staticPlayableItemCollectionDialogFragmentNewInstance$default)).show(this$0.getParentFragmentManager(), StaticPlayableItemCollectionDialogFragment.class.getName());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$17(PopupMenu popupMenu, View view) {
        Intrinsics.checkNotNullParameter(popupMenu, "$popupMenu");
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$18(RetroAchievementsGameDialogFragment this$0, RetroAchievementsGameRecordEntity retroAchievementsGameRecord, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecord, "$retroAchievementsGameRecord");
        Context contextRequireContext = this$0.requireContext();
        String playerCountDetailsFormatString = this$0.getPlayerCountDetailsFormatString();
        Intrinsics.checkNotNullExpressionValue(playerCountDetailsFormatString, "<get-playerCountDetailsFormatString>(...)");
        String str = String.format(playerCountDetailsFormatString, Arrays.copyOf(new Object[]{Long.valueOf(retroAchievementsGameRecord.getDistinctPlayerCount()), Long.valueOf(retroAchievementsGameRecord.getDistinctCasualPlayerCount()), Long.valueOf(retroAchievementsGameRecord.getDistinctHardcorePlayerCount())}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Toast.makeText(contextRequireContext, str, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$20(RetroAchievementsGameRecordEntity retroAchievementsGameRecord, RetroAchievementsGameDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecord, "$retroAchievementsGameRecord");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String guideUrl = retroAchievementsGameRecord.getGuideUrl();
        if (guideUrl != null) {
            this$0.requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(guideUrl)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$22(RetroAchievementsGameRecordEntity retroAchievementsGameRecord, RetroAchievementsGameDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecord, "$retroAchievementsGameRecord");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer forumTopicId = retroAchievementsGameRecord.getForumTopicId();
        if (forumTopicId != null) {
            this$0.requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this$0.getRetroAchievementsManager().getForumUrlString(forumTopicId.intValue()))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onCreateView$lambda$24(Ref.ObjectRef relatedPlayableItem, RetroAchievementsGameDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(relatedPlayableItem, "$relatedPlayableItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayableItemEntity playableItemEntity = (PlayableItemEntity) relatedPlayableItem.element;
        if (playableItemEntity != null) {
            this$0.dismiss();
            PlayableItemDetailDialogFragment.INSTANCE.newInstance(playableItemEntity).show(this$0.getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.RetroAchievementsGameDialogFragment$onCreateView$14, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "playableItemId", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass14 extends Lambda<Unit> implements Function1<List<? extends RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity>, Unit> {
        final /* synthetic */ Ref.ObjectRef<PlayableItemEntity> $relatedPlayableItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass14(Ref.ObjectRef<PlayableItemEntity> objectRef) {
            super(1);
            this.$relatedPlayableItem = objectRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> list) {
            invoke2((List<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity>) list);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity] */
        /* JADX WARN: Type inference failed for: r9v6, types: [T, com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity] */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> list) {
            Chip chip = null;
            if (RetroAchievementsGameDialogFragment.this.playableItemEntityToBeRestoredInDialog != null) {
                this.$relatedPlayableItem.element = RetroAchievementsGameDialogFragment.this.playableItemEntityToBeRestoredInDialog;
                Chip chip2 = RetroAchievementsGameDialogFragment.this.playableItemButton;
                if (chip2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playableItemButton");
                } else {
                    chip = chip2;
                }
                chip.setVisibility(0);
                return;
            }
            Intrinsics.checkNotNull(list);
            RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity = (RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity) CollectionsKt.getOrNull(list, 0);
            if (retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity != null) {
                Ref.ObjectRef<PlayableItemEntity> objectRef = this.$relatedPlayableItem;
                RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment = RetroAchievementsGameDialogFragment.this;
                objectRef.element = retroAchievementsGameDialogFragment.getDaijishouLibrary().getPlayableItemByIdStatically(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.getPlayableItemId());
                Chip chip3 = retroAchievementsGameDialogFragment.playableItemButton;
                if (chip3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playableItemButton");
                } else {
                    chip = chip3;
                }
                chip.setVisibility(objectRef.element == null ? 8 : 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$updateRetroAchievementsGameRecord(RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment, View view, RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
        Chip chip = retroAchievementsGameDialogFragment.retroAchievementsButton;
        Chip chip2 = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsButton");
            chip = null;
        }
        chip.setOnClickListener(new RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda12(retroAchievementsGameRecordEntity, retroAchievementsGameDialogFragment));
        Chip chip3 = retroAchievementsGameDialogFragment.playerCountButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerCountButton");
            chip3 = null;
        }
        chip3.setOnClickListener(new RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda1(retroAchievementsGameDialogFragment, retroAchievementsGameRecordEntity));
        Chip chip4 = retroAchievementsGameDialogFragment.playerCountButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerCountButton");
            chip4 = null;
        }
        chip4.setVisibility(retroAchievementsGameRecordEntity.getDistinctPlayerCount() <= 0 ? 8 : 0);
        Chip chip5 = retroAchievementsGameDialogFragment.playerCountButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerCountButton");
            chip5 = null;
        }
        String playerCountFormatString = retroAchievementsGameDialogFragment.getPlayerCountFormatString();
        Intrinsics.checkNotNullExpressionValue(playerCountFormatString, "<get-playerCountFormatString>(...)");
        String str = String.format(playerCountFormatString, Arrays.copyOf(new Object[]{Long.valueOf(retroAchievementsGameRecordEntity.getDistinctPlayerCount())}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        chip5.setText(str);
        Chip chip6 = retroAchievementsGameDialogFragment.guideButton;
        if (chip6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideButton");
            chip6 = null;
        }
        chip6.setOnClickListener(new RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda2(retroAchievementsGameRecordEntity, retroAchievementsGameDialogFragment));
        Chip chip7 = retroAchievementsGameDialogFragment.guideButton;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideButton");
            chip7 = null;
        }
        chip7.setVisibility(retroAchievementsGameRecordEntity.getGuideUrl() == null ? 8 : 0);
        Chip chip8 = retroAchievementsGameDialogFragment.forumButton;
        if (chip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forumButton");
            chip8 = null;
        }
        chip8.setOnClickListener(new RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda3(retroAchievementsGameRecordEntity, retroAchievementsGameDialogFragment));
        Chip chip9 = retroAchievementsGameDialogFragment.forumButton;
        if (chip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forumButton");
        } else {
            chip2 = chip9;
        }
        chip2.setVisibility(retroAchievementsGameRecordEntity.getForumTopicId() != null ? 0 : 8);
        Intrinsics.checkNotNull(view);
        retroAchievementsGameDialogFragment.fillInRetroAchievementsMetaDataView(view, retroAchievementsGameRecordEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$updateRetroAchievementsGameRecord$lambda$26(RetroAchievementsGameRecordEntity retroAchievementsGameRecord, RetroAchievementsGameDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecord, "$retroAchievementsGameRecord");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String url = retroAchievementsGameRecord.getUrl();
        if (url != null) {
            this$0.requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$updateRetroAchievementsGameRecord$lambda$27(RetroAchievementsGameDialogFragment this$0, RetroAchievementsGameRecordEntity retroAchievementsGameRecord, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecord, "$retroAchievementsGameRecord");
        Context contextRequireContext = this$0.requireContext();
        String playerCountDetailsFormatString = this$0.getPlayerCountDetailsFormatString();
        Intrinsics.checkNotNullExpressionValue(playerCountDetailsFormatString, "<get-playerCountDetailsFormatString>(...)");
        String str = String.format(playerCountDetailsFormatString, Arrays.copyOf(new Object[]{Long.valueOf(retroAchievementsGameRecord.getDistinctPlayerCount()), Long.valueOf(retroAchievementsGameRecord.getDistinctCasualPlayerCount()), Long.valueOf(retroAchievementsGameRecord.getDistinctHardcorePlayerCount())}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Toast.makeText(contextRequireContext, str, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$updateRetroAchievementsGameRecord$lambda$29(RetroAchievementsGameRecordEntity retroAchievementsGameRecord, RetroAchievementsGameDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecord, "$retroAchievementsGameRecord");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String guideUrl = retroAchievementsGameRecord.getGuideUrl();
        if (guideUrl != null) {
            this$0.getLogger().debug(this$0, "guideUrl: \"" + guideUrl + "\"");
            this$0.requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(guideUrl)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$updateRetroAchievementsGameRecord$lambda$31(RetroAchievementsGameRecordEntity retroAchievementsGameRecord, RetroAchievementsGameDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecord, "$retroAchievementsGameRecord");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer forumTopicId = retroAchievementsGameRecord.getForumTopicId();
        if (forumTopicId != null) {
            this$0.requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this$0.getRetroAchievementsManager().getForumUrlString(forumTopicId.intValue()))));
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.RetroAchievementsGameDialogFragment$onCreateView$16, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass16 extends Lambda<Unit> implements Function1<RetroAchievementsGameRecordEntity, Unit> {
        final /* synthetic */ Ref.BooleanRef $firstTimeGameRecord;
        final /* synthetic */ View $view;
        final /* synthetic */ RetroAchievementsGameDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass16(Ref.BooleanRef booleanRef, RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment, View view) {
            super(1);
            this.$firstTimeGameRecord = booleanRef;
            this.this$0 = retroAchievementsGameDialogFragment;
            this.$view = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
            invoke2(retroAchievementsGameRecordEntity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
            if (!this.$firstTimeGameRecord.element && retroAchievementsGameRecordEntity != null) {
                RetroAchievementsGameDialogFragment.onCreateView$updateRetroAchievementsGameRecord(this.this$0, this.$view, retroAchievementsGameRecordEntity);
            } else {
                this.$firstTimeGameRecord.element = false;
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.RetroAchievementsGameDialogFragment$onCreateView$18, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserAwardEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass18 extends Lambda<Unit> implements Function1<List<? extends RetroAchievementsUserAwardEntity>, Unit> {
        final /* synthetic */ Ref.BooleanRef $firstTimeAward;
        final /* synthetic */ RetroAchievementsGameDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass18(Ref.BooleanRef booleanRef, RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment) {
            super(1);
            this.$firstTimeAward = booleanRef;
            this.this$0 = retroAchievementsGameDialogFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends RetroAchievementsUserAwardEntity> list) {
            invoke2((List<RetroAchievementsUserAwardEntity>) list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<RetroAchievementsUserAwardEntity> list) {
            if (!this.$firstTimeAward.element && list != null) {
                ImageView imageView = this.this$0.awardIcon;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("awardIcon");
                    imageView = null;
                }
                imageView.setVisibility(list.isEmpty() ? 8 : 0);
                return;
            }
            this.$firstTimeAward.element = false;
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.RetroAchievementsGameDialogFragment$onCreateView$19, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass19 extends Lambda<Unit> implements Function1<List<? extends Long>, Unit> {
        final /* synthetic */ RetroAchievementsGameRecordEntity $retroAchievementsGameRecord;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass19(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
            super(1);
            this.$retroAchievementsGameRecord = retroAchievementsGameRecordEntity;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Long> list) {
            invoke2((List<Long>) list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Long> list) {
            LinearProgressIndicator linearProgressIndicator = RetroAchievementsGameDialogFragment.this.progressBar;
            if (linearProgressIndicator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                linearProgressIndicator = null;
            }
            linearProgressIndicator.setIndeterminate(list.contains(Long.valueOf(this.$retroAchievementsGameRecord.getGameId())));
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.RetroAchievementsGameDialogFragment$onCreateView$20, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012:\u0010\u0002\u001a6\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005 \u0007*\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsAchievementRecordEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass20 extends Lambda<Unit> implements Function1<Pair<? extends Integer, ? extends List<? extends RetroAchievementsAchievementRecordEntity>>, Unit> {
        final /* synthetic */ Ref.BooleanRef $firstTime;
        final /* synthetic */ RetroAchievementsGameDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass20(Ref.BooleanRef booleanRef, RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment) {
            super(1);
            this.$firstTime = booleanRef;
            this.this$0 = retroAchievementsGameDialogFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Integer, ? extends List<? extends RetroAchievementsAchievementRecordEntity>> pair) {
            invoke2((Pair<Integer, ? extends List<RetroAchievementsAchievementRecordEntity>>) pair);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<Integer, ? extends List<RetroAchievementsAchievementRecordEntity>> pair) {
            if (this.$firstTime.element) {
                this.$firstTime.element = false;
                return;
            }
            RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment = this.this$0;
            Integer first = pair.getFirst();
            Intrinsics.checkNotNull(first);
            retroAchievementsGameDialogFragment.viewMode = first.intValue();
            this.this$0.refreshViewType(pair.getSecond());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Window window = requireDialog().getWindow();
        Intrinsics.checkNotNull(window);
        window.getWindowManager().updateViewLayout(window.getDecorView(), window.getAttributes());
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.magneticchen.daijishou.activities.MainActivity");
        ((MainActivity) fragmentActivityRequireActivity).setAndroidPDialogFixStopKeyDispatching(false);
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View view2 = this.viewToBeRefocus;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewToBeRefocus");
            view2 = null;
        }
        view2.requestFocus();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        DpToPxConverter dpToPxConverter = new DpToPxConverter(contextRequireContext);
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.rounded_full_screen_dialog_root);
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).setMargins(dpToPxConverter.convert(12.0f), dpToPxConverter.convert(12.0f), dpToPxConverter.convert(12.0f), dpToPxConverter.convert(12.0f));
        constraintLayout.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.rounded_full_screen_dialog));
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.FullScreenDialogAnimation);
        }
    }
}
