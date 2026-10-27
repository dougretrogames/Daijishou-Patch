package com.magneticchen.daijishou.ui.fragments.dialog;

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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
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
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsAchievementRecordEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsGameRecordEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserAwardEntity;
import com.magneticchen.daijishou.data.db.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository;
import com.magneticchen.daijishou.data.live.PairLiveData;
import com.magneticchen.daijishou.data.live.SharedPreferenceIntLiveData;
import com.magneticchen.daijishou.ui.activities.MainActivity;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouGridLayoutManager;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import com.magneticchen.daijishou.utils.DpToPxConverter;
import com.magneticchen.daijishou.utils.Utils;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.skydoves.balloon.BalloonExtensionKt;
import com.skydoves.balloon.internals.DefinitionKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 a2\u00020\u0001:\u0003_`aB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020JH\u0002J\b\u0010K\u001a\u000205H\u0016J\u0012\u0010L\u001a\u00020G2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J&\u0010O\u001a\u0004\u0018\u00010\u000b2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J \u0010T\u001a\u00020G2\u0006\u0010U\u001a\u00020\r2\u0006\u0010V\u001a\u00020\r2\u0006\u0010W\u001a\u00020XH\u0016J\b\u0010Y\u001a\u00020GH\u0016J\b\u0010Z\u001a\u00020GH\u0016J\u001a\u0010[\u001a\u00020G2\u0006\u0010H\u001a\u00020\u000b2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u0018\u0010\\\u001a\u00020G2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010^H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u000e\u0010#\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\"\u001a\u0004\b.\u0010+R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u00108\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\"\u001a\u0004\b:\u0010;R\u000e\u0010=\u001a\u00020>X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/RetroAchievementsGameDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "achievements", "", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsAchievementRecordEntity;", "associateItemButton", "Lcom/google/android/material/chip/Chip;", "awardIcon", "Landroid/widget/ImageView;", "bottomDivider", "Landroid/view/View;", "colorHardcore", "", "colorIconThemeTintList", "Landroid/content/res/ColorStateList;", "colorOnThemeTintList", "colorSoftcore", "colorThemeTintList", "consoleIcon", "description", "Landroid/widget/TextView;", "descriptionSuffix", "forumButton", "greyscaleColorMatrix", "Landroid/graphics/ColorMatrix;", "greyscaleFilter", "Landroid/graphics/ColorMatrixColorFilter;", "guideButton", "highlightStrokeWidth", "", "getHighlightStrokeWidth", "()F", "highlightStrokeWidth$delegate", "Lkotlin/Lazy;", "placeHolder", "playableItemButton", "playableItemEntityToBeRestoredInDialog", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "playerCountButton", "playerCountDetailsFormatString", "", "getPlayerCountDetailsFormatString", "()Ljava/lang/String;", "playerCountDetailsFormatString$delegate", "playerCountFormatString", "getPlayerCountFormatString", "playerCountFormatString$delegate", "progressBar", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "recyclerView", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView;", "refocusOnScrolledToTop", "", "refreshButton", "retroAchievementsButton", "retroAchievementsRepository", "Lcom/magneticchen/daijishou/data/db/repositories/RetroAchievementsRepository;", "getRetroAchievementsRepository", "()Lcom/magneticchen/daijishou/data/db/repositories/RetroAchievementsRepository;", "retroAchievementsRepository$delegate", "scrollView", "Landroid/widget/HorizontalScrollView;", "scrollingOnBackPressed", "thumbnail", "Lcom/google/android/material/imageview/ShapeableImageView;", "title", "toggleViewButton", "viewMode", "viewToBeRefocus", "fillInRetroAchievementsMetaDataView", "", "view", "retroAchievementsGameRecord", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHotKeyPressed", "hotkeyCode", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onResume", "onStart", "onViewCreated", "refreshViewType", "retroAchievementsAchievementRecords", "", "AchievementGridAdapter", "AchievementListAdapter", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsGameDialogFragment extends DaijishouDialogFragment {
    public static final Companion Companion = new Companion(null);
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
    private final Lazy playerCountFormatString$delegate = LazyKt.lazy(new Function0<String>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$playerCountFormatString$2
        

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.this$0.getString(R.string.achievement_player_count_format);
        }
    });
    private final Lazy playerCountDetailsFormatString$delegate = LazyKt.lazy(new Function0<String>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$playerCountDetailsFormatString$2
        

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return this.this$0.getString(R.string.achievement_player_count_details_format);
        }
    });
    private final Lazy retroAchievementsRepository$delegate = LazyKt.lazy(new Function0<RetroAchievementsRepository>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$retroAchievementsRepository$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RetroAchievementsRepository invoke() {
            return this.this$0.getRetroAchievementsManager().getRetroAchievementsRepository();
        }
    });
    private final Lazy highlightStrokeWidth$delegate = LazyKt.lazy(new Function0<Float>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$highlightStrokeWidth$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Float invoke() {
            return Float.valueOf(this.this$0.getDpToPxConverter().convertToFloat(3.0f));
        }
    });

    /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/RetroAchievementsGameDialogFragment$Companion;", "", "()V", "typeface", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/RetroAchievementsGameDialogFragment;", "retroAchievementsGameRecordId", "", "playableItemEntityToBeRestoredInDialog", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "colorThemeTintList", "Landroid/content/res/ColorStateList;", "colorOnThemeTintList", "colorIconThemeTintList", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        public final RetroAchievementsGameDialogFragment newInstance(long j, PlayableItemEntity playableItemEntity, ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3) {
            RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment = new RetroAchievementsGameDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("retroAchievementsGameRecordId", j);
            bundle.putParcelable("playableItemEntityToBeRestoredInDialog", playableItemEntity);
            if (colorStateList != null) {
                bundle.putParcelable("colorThemeTintList", colorStateList);
            }
            if (colorStateList3 != null) {
                bundle.putParcelable("colorIconThemeTintList", colorStateList3);
            }
            if (colorStateList2 != null) {
                bundle.putParcelable("colorOnThemeTintList", colorStateList2);
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
        colorMatrix.setSaturation(DefinitionKt.NO_Float_VALUE);
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
        return (String) this.playerCountFormatString$delegate.getValue();
    }

    private final String getPlayerCountDetailsFormatString() {
        return (String) this.playerCountDetailsFormatString$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RetroAchievementsRepository getRetroAchievementsRepository() {
        return (RetroAchievementsRepository) this.retroAchievementsRepository$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getHighlightStrokeWidth() {
        return ((Number) this.highlightStrokeWidth$delegate.getValue()).floatValue();
    }

    /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u0010\u001a\u001a\n0\u001bR\u00060\u0000R\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/RetroAchievementsGameDialogFragment$AchievementListAdapter;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsAchievementRecordEntity;", "context", "Landroid/content/Context;", "retroAchievementsAchievementDataList", "", "(Lcom/magneticchen/daijishou/ui/fragments/dialog/RetroAchievementsGameDialogFragment;Landroid/content/Context;Ljava/util/List;)V", "achievementCompletedString", "", "achievementDetailFormatString", "achievementHardcoreCompletedString", "achievementIncompleteString", "achievementPointsFormatString", "getGlidePreloadRequestBuilder", "Lkotlin/Function1;", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "glideViewPreloadSizeProvider", "Lcom/bumptech/glide/util/ViewPreloadSizeProvider;", "noDescriptionForThisAchievementString", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/ui/fragments/dialog/RetroAchievementsGameDialogFragment$AchievementListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/fragments/dialog/RetroAchievementsGameDialogFragment;", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
        public AchievementListAdapter(final RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment, Context context, List<RetroAchievementsAchievementRecordEntity> retroAchievementsAchievementDataList) {
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
            Function1<RetroAchievementsAchievementRecordEntity, RequestBuilder<Drawable>> function1 = new Function1<RetroAchievementsAchievementRecordEntity, RequestBuilder<Drawable>>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$AchievementListAdapter$getGlidePreloadRequestBuilder$1
                

                @Override // kotlin.jvm.functions.Function1
                public final RequestBuilder<Drawable> invoke(RetroAchievementsAchievementRecordEntity item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    if (item.getImageUrl() == null) {
                        return null;
                    }
                    return Glide.with(retroAchievementsGameDialogFragment).load(item.getImageUrl()).transition(DrawableTransitionOptions.withCrossFade());
                }
            };
            this.getGlidePreloadRequestBuilder = function1;
            this.glideViewPreloadSizeProvider = DaijishouRecyclerView.Adapter.addGlidePreloaderBuilderCreator$default(this, function1, 0, 2, null);
        }

        /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/RetroAchievementsGameDialogFragment$AchievementListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsAchievementRecordEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/fragments/dialog/RetroAchievementsGameDialogFragment$AchievementListAdapter;Landroid/view/View;)V", "colorHardcoreColorStateList", "Landroid/content/res/ColorStateList;", "completedIcon", "Landroid/widget/ImageView;", "completedIconImageTintList", "defaultBorderColor", "defaultStrokeWidth", "", "description", "Landroid/widget/TextView;", "imageView", "Lcom/google/android/material/imageview/ShapeableImageView;", "pointsSubtitle", "progressDescription", "title", "onBind", "", "position", "", "item", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
                View view = (ShapeableImageView) viewFindViewById;
                this.imageView = view;
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
                this.defaultBorderColor = view.getStrokeColor();
                this.defaultStrokeWidth = view.getStrokeWidth();
                this.completedIconImageTintList = imageView.getImageTintList();
                this.colorHardcoreColorStateList = new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}}, new int[]{achievementListAdapter.this$0.colorHardcore});
                achievementListAdapter.glideViewPreloadSizeProvider.setView(view);
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int i, RetroAchievementsAchievementRecordEntity item) {
                String str;
                String description;
                Intrinsics.checkNotNullParameter(item, "item");
                TypedValue typedValue = new TypedValue();
                this.this$0.this$0.requireActivity().getTheme().resolveAttribute(2130968869, typedValue, true);
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
                Integer numValueOf = Integer.valueOf(i + 1);
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
                    Glide.with(this.this$0.this$0).load(item.getImageUrl()).transition(DrawableTransitionOptions.withCrossFade()).into(this.imageView);
                }
            }
        }

        public long getItemId(int i) {
            return this.retroAchievementsAchievementDataList.get(i).hashCode();
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_retro_achievements_achievement, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\n0\u0018R\u00060\u0000R\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/RetroAchievementsGameDialogFragment$AchievementGridAdapter;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsAchievementRecordEntity;", "retroAchievementsAchievementDataList", "", "(Lcom/magneticchen/daijishou/ui/fragments/dialog/RetroAchievementsGameDialogFragment;Ljava/util/List;)V", "achievementPointsFormatString", "", "getGlidePreloadRequestBuilder", "Lkotlin/Function1;", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getGetGlidePreloadRequestBuilder", "()Lkotlin/jvm/functions/Function1;", "glideViewPreloadSizeProvider", "Lcom/bumptech/glide/util/ViewPreloadSizeProvider;", "getGlideViewPreloadSizeProvider", "()Lcom/bumptech/glide/util/ViewPreloadSizeProvider;", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/ui/fragments/dialog/RetroAchievementsGameDialogFragment$AchievementGridAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/fragments/dialog/RetroAchievementsGameDialogFragment;", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AchievementGridAdapter extends DaijishouRecyclerView.Adapter<RetroAchievementsAchievementRecordEntity> {
        private final String achievementPointsFormatString;
        private final Function1<RetroAchievementsAchievementRecordEntity, RequestBuilder<Drawable>> getGlidePreloadRequestBuilder;
        private final ViewPreloadSizeProvider<RetroAchievementsAchievementRecordEntity> glideViewPreloadSizeProvider;
        private final List<RetroAchievementsAchievementRecordEntity> retroAchievementsAchievementDataList;
        final /* synthetic */ RetroAchievementsGameDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AchievementGridAdapter(final RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment, List<RetroAchievementsAchievementRecordEntity> retroAchievementsAchievementDataList) {
            super(retroAchievementsAchievementDataList, true, false, 4, null);
            Intrinsics.checkNotNullParameter(retroAchievementsAchievementDataList, "retroAchievementsAchievementDataList");
            this.this$0 = retroAchievementsGameDialogFragment;
            this.retroAchievementsAchievementDataList = retroAchievementsAchievementDataList;
            setEnforceSelectionInSelectableMode(false);
            String string = retroAchievementsGameDialogFragment.getString(R.string.achievement_points_format);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.achievementPointsFormatString = string;
            Function1<RetroAchievementsAchievementRecordEntity, RequestBuilder<Drawable>> function1 = new Function1<RetroAchievementsAchievementRecordEntity, RequestBuilder<Drawable>>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$AchievementGridAdapter$getGlidePreloadRequestBuilder$1
                

                @Override // kotlin.jvm.functions.Function1
                public final RequestBuilder<Drawable> invoke(RetroAchievementsAchievementRecordEntity item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    if (item.getImageUrl() == null) {
                        return null;
                    }
                    return Glide.with(retroAchievementsGameDialogFragment).load(item.getImageUrl()).transition(DrawableTransitionOptions.withCrossFade());
                }
            };
            this.getGlidePreloadRequestBuilder = function1;
            this.glideViewPreloadSizeProvider = DaijishouRecyclerView.Adapter.addGlidePreloaderBuilderCreator$default(this, function1, 0, 2, null);
        }

        public final Function1<RetroAchievementsAchievementRecordEntity, RequestBuilder<Drawable>> getGetGlidePreloadRequestBuilder() {
            return this.getGlidePreloadRequestBuilder;
        }

        public final ViewPreloadSizeProvider<RetroAchievementsAchievementRecordEntity> getGlideViewPreloadSizeProvider() {
            return this.glideViewPreloadSizeProvider;
        }

        /* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
        @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/RetroAchievementsGameDialogFragment$AchievementGridAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsAchievementRecordEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/fragments/dialog/RetroAchievementsGameDialogFragment$AchievementGridAdapter;Landroid/view/View;)V", "balloon", "Lcom/skydoves/balloon/Balloon;", "defaultBorderColor", "Landroid/content/res/ColorStateList;", "defaultPointsBackgroundTintList", "defaultStrokeWidth", "", "focused", "", "imageView", "Lcom/google/android/material/imageview/ShapeableImageView;", "isBalloonShown", "item", "pointsSubtitle", "Landroid/widget/TextView;", "onBind", "", "position", "", "onClick", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "refreshBorderStyle", "showToolTips", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<RetroAchievementsAchievementRecordEntity>.ViewHolder {
            private Balloon balloon;
            private final ColorStateList defaultBorderColor;
            private final ColorStateList defaultPointsBackgroundTintList;
            private final float defaultStrokeWidth;
            private boolean focused;
            private final ShapeableImageView imageView;
            private boolean isBalloonShown;
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
                View view = (ShapeableImageView) viewFindViewById;
                this.imageView = view;
                View viewFindViewById2 = itemView.findViewById(R.id.retro_achievements_item_points_subtitle);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.pointsSubtitle = (TextView) viewFindViewById2;
                this.defaultBorderColor = view.getStrokeColor();
                this.defaultStrokeWidth = view.getStrokeWidth();
                this.defaultPointsBackgroundTintList = view.getBackgroundTintList();
                achievementGridAdapter.getGlideViewPreloadSizeProvider().setView(view);
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

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int i, RetroAchievementsAchievementRecordEntity item) {
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
                this.pointsSubtitle.setTypeface(RetroAchievementsGameDialogFragment.Companion.getTypeface());
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
                    Glide.with(this.this$0.this$0).load(item.getImageUrl()).transition(DrawableTransitionOptions.withCrossFade()).into(this.imageView);
                }
            }

            private final void showToolTips() {
                RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity = (RetroAchievementsAchievementRecordEntity) this.this$0.retroAchievementsAchievementDataList.get(getAbsoluteAdapterPosition());
                Context contextRequireContext = this.this$0.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                Balloon.Builder lifecycleOwner = new Balloon.Builder(contextRequireContext).setDismissWhenTouchOutside(false).setFocusable(false).setText((CharSequence) ("🏁 " + retroAchievementsAchievementRecordEntity.getName() + "\n" + (retroAchievementsAchievementRecordEntity.isUnlocked() ? "✔ ️" : "❌ ") + retroAchievementsAchievementRecordEntity.getDescription())).setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR).setCornerRadius(8.0f).setPadding(8).setTextSize(15.0f).setMaxWidth(300).setMargin(12).setTextTypeface(RetroAchievementsGameDialogFragment.Companion.getTypeface()).setBackgroundColorResource(R.color.chip_normal_background_color).setTextColorResource(R.color.chip_normal_text_color).setBalloonAnimation(BalloonAnimation.NONE).setLifecycleOwner(this.this$0.this$0.getViewLifecycleOwner());
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
                    balloon2.setOnBalloonDismissListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$AchievementGridAdapter$ViewHolder$showToolTips$1
                        

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            this.this$0.isBalloonShown = false;
                        }
                    });
                }
                Balloon balloon3 = this.balloon;
                if (balloon3 != null) {
                    balloon3.dismissWithDelay(8000L);
                }
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public boolean onClick() {
                super.onClick();
                if (this.isBalloonShown) {
                    return true;
                }
                this.isBalloonShown = true;
                showToolTips();
                return false;
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
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

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocusClear(boolean z) {
                super.onFocusClear(z);
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
                if (z) {
                    Utils utils = Utils.INSTANCE;
                    View itemView = this.itemView;
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    Utils.scaleView$default(utils, itemView, 1.1f, 1.0f, 0L, false, 24, null);
                }
                this.itemView.setElevation(DefinitionKt.NO_Float_VALUE);
            }
        }

        public long getItemId(int i) {
            return this.retroAchievementsAchievementDataList.get(i).hashCode();
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item_retro_achievements_achievement, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public void onCreate(Bundle bundle) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        super.onCreate(bundle);
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
    public final void refreshViewType(List<RetroAchievementsAchievementRecordEntity> list) {
        List listSortedWith = CollectionsKt.sortedWith(list == null ? CollectionsKt.emptyList() : list, new Comparator() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$refreshViewType$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity = (RetroAchievementsAchievementRecordEntity) t;
                RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity2 = (RetroAchievementsAchievementRecordEntity) t2;
                return ComparisonsKt.compareValues(Boolean.valueOf((retroAchievementsAchievementRecordEntity.isUnlocked() || retroAchievementsAchievementRecordEntity.isHardcoreUnlocked()) ? false : true), Boolean.valueOf((retroAchievementsAchievementRecordEntity2.isUnlocked() || retroAchievementsAchievementRecordEntity2.isHardcoreUnlocked()) ? false : true));
            }
        });
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
                    daijishouRecyclerView3.setLayoutManager((RecyclerView.LayoutManager) new DaijishouGridLayoutManager(contextRequireContext, 76.0f, 16, DefinitionKt.NO_Float_VALUE, false, 24, null));
                }
                AchievementGridAdapter achievementGridAdapter = new AchievementGridAdapter(this, this.achievements);
                achievementGridAdapter.setOnItemClickListener(new Function4<View, Integer, Long, RetroAchievementsAchievementRecordEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment.refreshViewType.2
                    

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity) {
                        invoke(view, num.intValue(), l.longValue(), retroAchievementsAchievementRecordEntity);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(View view, int i2, long j, RetroAchievementsAchievementRecordEntity it) {
                        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(it, "it");
                        String url = it.getUrl();
                        if (url != null) {
                            RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment = RetroAchievementsGameDialogFragment.this;
                            retroAchievementsGameDialogFragment.requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                        }
                    }
                });
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
            daijishouRecyclerView6.setLayoutManager((RecyclerView.LayoutManager) new DaijishouLinearLayoutManager(contextRequireContext2, 1, false));
        }
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        AchievementListAdapter achievementListAdapter = new AchievementListAdapter(this, contextRequireContext3, this.achievements);
        achievementListAdapter.setOnItemClickListener(new Function4<View, Integer, Long, RetroAchievementsAchievementRecordEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment.refreshViewType.1
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity) {
                invoke(view, num.intValue(), l.longValue(), retroAchievementsAchievementRecordEntity);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i2, long j, RetroAchievementsAchievementRecordEntity it) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(it, "it");
                String url = it.getUrl();
                if (url != null) {
                    RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment = RetroAchievementsGameDialogFragment.this;
                    retroAchievementsGameDialogFragment.requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                }
            }
        });
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

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public void onHotKeyPressed(int i, int i2, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(i, i2, keyEvent);
        getLogger().debug(this, "onHotKeyPressed");
        if (i != 3) {
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
    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onBackPressed() {
        /*
            r5 = this;
            boolean r0 = r5.scrollingOnBackPressed
            java.lang.String r1 = "recyclerView"
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L17
            com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView r0 = r5.recyclerView
            if (r0 != 0) goto L10
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r3
        L10:
            int r0 = r0.getScrollState()
            r4 = 2
            if (r0 == r4) goto L35
        L17:
            com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView r0 = r5.recyclerView
            if (r0 != 0) goto L1f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r3
        L1f:
            int r0 = r0.computeVerticalScrollOffset()
            java.lang.String r4 = "scrollView"
            if (r0 != 0) goto La3
            android.widget.HorizontalScrollView r0 = r5.scrollView
            if (r0 != 0) goto L2f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r3
        L2f:
            int r0 = r0.getScrollX()
            if (r0 != 0) goto La3
        L35:
            com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView r0 = r5.recyclerView
            if (r0 != 0) goto L3d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r3
        L3d:
            r0.scrollToPosition(r2)
            com.google.android.material.chip.Chip r0 = r5.refreshButton
            java.lang.String r1 = "refreshButton"
            if (r0 != 0) goto L4a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r3
        L4a:
            boolean r0 = r0.isFocused()
            if (r0 == 0) goto L6c
            com.magneticchen.daijishou.data.db.entity.PlayableItemEntity r0 = r5.playableItemEntityToBeRestoredInDialog
            if (r0 == 0) goto L67
            com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$Companion r1 = com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.Companion
            com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment r0 = r1.newInstance(r0)
            androidx.fragment.app.FragmentManager r1 = r5.getParentFragmentManager()
            java.lang.Class<com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment> r2 = com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.class
            java.lang.String r2 = r2.getName()
            r0.show(r1, r2)
        L67:
            boolean r0 = super.onBackPressed()
            return r0
        L6c:
            com.google.android.material.chip.Chip r0 = r5.refreshButton
            if (r0 != 0) goto L74
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r3
        L74:
            r0.requestFocus()
            com.google.android.material.chip.Chip r0 = r5.refreshButton
            if (r0 != 0) goto L7f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L80
        L7f:
            r3 = r0
        L80:
            boolean r0 = r3.isFocused()
            if (r0 != 0) goto La2
            com.magneticchen.daijishou.data.db.entity.PlayableItemEntity r0 = r5.playableItemEntityToBeRestoredInDialog
            if (r0 == 0) goto L9d
            com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment$Companion r1 = com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.Companion
            com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment r0 = r1.newInstance(r0)
            androidx.fragment.app.FragmentManager r1 = r5.getParentFragmentManager()
            java.lang.Class<com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment> r2 = com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment.class
            java.lang.String r2 = r2.getName()
            r0.show(r1, r2)
        L9d:
            boolean r0 = super.onBackPressed()
            return r0
        La2:
            return r2
        La3:
            r0 = 1
            r5.scrollingOnBackPressed = r0
            r5.refocusOnScrolledToTop = r0
            com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView r0 = r5.recyclerView
            if (r0 != 0) goto Lb0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r3
        Lb0:
            r0.smoothScrollToPosition(r2)
            android.widget.HorizontalScrollView r0 = r5.scrollView
            if (r0 != 0) goto Lbb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto Lbc
        Lbb:
            r3 = r0
        Lbc:
            r3.smoothScrollTo(r2, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment.onBackPressed():boolean");
    }

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
            window2.setFlags(CategoryWidgetViewModel.LIMIT, CategoryWidgetViewModel.LIMIT);
        }
        View view = this.viewToBeRefocus;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewToBeRefocus");
            view = null;
        }
        view.requestFocus();
    }

    private final void fillInRetroAchievementsMetaDataView(View view, RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
        String consoleImageUrl = getRetroAchievementsManager().getConsoleImageUrl(retroAchievementsGameRecordEntity.getConsoleId());
        TextView textView = null;
        if (consoleImageUrl == null) {
            RequestManager requestManagerWith = Glide.with((Fragment) this);
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
            RequestBuilder requestBuilderTransition = Glide.with((Fragment) this).load(consoleImageUrl).listener(new RequestListener<Drawable>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment.fillInRetroAchievementsMetaDataView.1
                public /* bridge */ /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, DataSource dataSource, boolean z) {
                    return onResourceReady((Drawable) obj, obj2, (Target<Drawable>) target, dataSource, z);
                }

                public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                    Intrinsics.checkNotNullParameter(target, "target");
                    ImageView imageView3 = RetroAchievementsGameDialogFragment.this.consoleIcon;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("consoleIcon");
                        imageView3 = null;
                    }
                    imageView3.setVisibility(8);
                    return false;
                }

                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean z) {
                    Intrinsics.checkNotNullParameter(resource, "resource");
                    Intrinsics.checkNotNullParameter(model, "model");
                    Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                    ImageView imageView3 = RetroAchievementsGameDialogFragment.this.consoleIcon;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("consoleIcon");
                        imageView3 = null;
                    }
                    imageView3.setVisibility(0);
                    return false;
                }
            }).transition(DrawableTransitionOptions.withCrossFade());
            ImageView imageView3 = this.consoleIcon;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("consoleIcon");
                imageView3 = null;
            }
            requestBuilderTransition.into(imageView3);
        }
        if (retroAchievementsGameRecordEntity.getImageUrl() == null) {
            RequestManager requestManagerWith2 = Glide.with((Fragment) this);
            ShapeableImageView shapeableImageView = this.thumbnail;
            if (shapeableImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
                shapeableImageView = null;
            }
            requestManagerWith2.clear((View) shapeableImageView);
            ImageView imageView4 = this.placeHolder;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
                imageView4 = null;
            }
            imageView4.setVisibility(0);
        } else {
            RequestBuilder requestBuilderTransition2 = Glide.with((Fragment) this).load(retroAchievementsGameRecordEntity.getImageUrl()).listener(new RequestListener<Drawable>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment.fillInRetroAchievementsMetaDataView.2
                public /* bridge */ /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, DataSource dataSource, boolean z) {
                    return onResourceReady((Drawable) obj, obj2, (Target<Drawable>) target, dataSource, z);
                }

                public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                    Intrinsics.checkNotNullParameter(target, "target");
                    ImageView imageView5 = RetroAchievementsGameDialogFragment.this.placeHolder;
                    if (imageView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
                        imageView5 = null;
                    }
                    imageView5.setVisibility(0);
                    return false;
                }

                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean z) {
                    Intrinsics.checkNotNullParameter(resource, "resource");
                    Intrinsics.checkNotNullParameter(model, "model");
                    Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                    ImageView imageView5 = RetroAchievementsGameDialogFragment.this.placeHolder;
                    if (imageView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
                        imageView5 = null;
                    }
                    imageView5.setVisibility(8);
                    return false;
                }
            }).transition(DrawableTransitionOptions.withCrossFade());
            ShapeableImageView shapeableImageView2 = this.thumbnail;
            if (shapeableImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
                shapeableImageView2 = null;
            }
            requestBuilderTransition2.into((ImageView) shapeableImageView2);
        }
        TextView textView2 = this.title;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView2 = null;
        }
        textView2.setText(retroAchievementsGameRecordEntity.getName());
        String string = getString(R.string.achievement_completion_format, new Object[]{Integer.valueOf(retroAchievementsGameRecordEntity.getUnlockedAchievementsCount()), Integer.valueOf(retroAchievementsGameRecordEntity.getAchievementsCount())});
        TextView textView3 = this.description;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("description");
            textView3 = null;
        }
        textView3.setText(string);
        float achievementsCount = retroAchievementsGameRecordEntity.getAchievementsCount();
        float unlockedAchievementsCount = DefinitionKt.NO_Float_VALUE;
        if (achievementsCount != DefinitionKt.NO_Float_VALUE) {
            unlockedAchievementsCount = (retroAchievementsGameRecordEntity.getUnlockedAchievementsCount() * 100.0f) / retroAchievementsGameRecordEntity.getAchievementsCount();
        }
        LinearProgressIndicator linearProgressIndicator = this.progressBar;
        if (linearProgressIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            linearProgressIndicator = null;
        }
        linearProgressIndicator.setProgress(Math.max(3, (int) unlockedAchievementsCount));
        String consoleName = retroAchievementsGameRecordEntity.getConsoleName();
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

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("retroAchievementsGameRecordId")) : null;
        Intrinsics.checkNotNull(lValueOf);
        long jLongValue = lValueOf.longValue();
        final RetroAchievementsGameRecordEntity retroAchievementsGameRecordByIdStatically = getRetroAchievementsRepository().getRetroAchievementsGameRecordByIdStatically(jLongValue);
        Intrinsics.checkNotNull(retroAchievementsGameRecordByIdStatically);
        Bundle arguments2 = getArguments();
        this.playableItemEntityToBeRestoredInDialog = arguments2 != null ? (PlayableItemEntity) arguments2.getParcelable("playableItemEntityToBeRestoredInDialog") : null;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Typeface typefaceCreate = Build.VERSION.SDK_INT >= 28 ? Typeface.create(null, Constants.semiBolderWeight, false) : Typeface.defaultFromStyle(1);
        final View viewInflate = inflater.inflate(R.layout.fragment_retro_achievements_game, viewGroup, false);
        Dialog dialog = getDialog();
        Intrinsics.checkNotNull(dialog);
        Window window = dialog.getWindow();
        Intrinsics.checkNotNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        ConstraintLayout constraintLayoutFindViewById = viewInflate.findViewById(R.id.rounded_full_screen_dialog_container);
        DisplayMetrics displayMetrics = requireContext().getResources().getDisplayMetrics();
        float f = displayMetrics.heightPixels / displayMetrics.widthPixels;
        if (f < 1.0f) {
            f = 1.0f / f;
        }
        if (f > 2.1111112f) {
            ConstraintLayout.LayoutParams layoutParams = constraintLayoutFindViewById.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            layoutParams.dimensionRatio = Constants.layoutDimensionRatio;
            constraintLayoutFindViewById.requestLayout();
        }
        ShapeableImageView shapeableImageViewFindViewById = viewInflate.findViewById(R.id.fragment_retro_achievements_game_thumbnail);
        Intrinsics.checkNotNullExpressionValue(shapeableImageViewFindViewById, "findViewById(...)");
        this.thumbnail = shapeableImageViewFindViewById;
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_retro_achievements_game_console_icon_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.consoleIcon = (ImageView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_award_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.awardIcon = (ImageView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_placeholder);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.placeHolder = (ImageView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_title_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.title = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_description_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.description = (TextView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_description_suffix_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.descriptionSuffix = (TextView) viewFindViewById6;
        LinearProgressIndicator linearProgressIndicatorFindViewById = viewInflate.findViewById(R.id.list_item_retro_achievements_game_linear_progress_indicator);
        Intrinsics.checkNotNullExpressionValue(linearProgressIndicatorFindViewById, "findViewById(...)");
        this.progressBar = linearProgressIndicatorFindViewById;
        View viewFindViewById7 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_bottom_divider);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.bottomDivider = viewFindViewById7;
        Chip chipFindViewById = viewInflate.findViewById(R.id.fragment_retro_achievements_game_refresh_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById, "findViewById(...)");
        this.refreshButton = chipFindViewById;
        Chip chipFindViewById2 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_toggle_view_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById2, "findViewById(...)");
        this.toggleViewButton = chipFindViewById2;
        Chip chipFindViewById3 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_associate_item_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById3, "findViewById(...)");
        this.associateItemButton = chipFindViewById3;
        Chip chipFindViewById4 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_player_count_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById4, "findViewById(...)");
        this.playerCountButton = chipFindViewById4;
        Chip chipFindViewById5 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_guide_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById5, "findViewById(...)");
        this.guideButton = chipFindViewById5;
        Chip chipFindViewById6 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_forum_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById6, "findViewById(...)");
        this.forumButton = chipFindViewById6;
        Chip chipFindViewById7 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_playable_item_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById7, "findViewById(...)");
        this.playableItemButton = chipFindViewById7;
        Chip chipFindViewById8 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_retro_achievements_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById8, "findViewById(...)");
        this.retroAchievementsButton = chipFindViewById8;
        View viewFindViewById8 = viewInflate.findViewById(R.id.fragment_retro_achievements_game_horizontal_scroll_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.scrollView = (HorizontalScrollView) viewFindViewById8;
        Object objFindViewById = viewInflate.findViewById(R.id.fragment_retro_achievements_game_recycler_view);
        Intrinsics.checkNotNullExpressionValue(objFindViewById, "findViewById(...)");
        this.recyclerView = (DaijishouRecyclerView) objFindViewById;
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
        horizontalScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                RetroAchievementsGameDialogFragment.onCreateView$lambda$11(this.f$0, view, i, i2, i3, i4);
            }
        });
        DaijishouRecyclerView daijishouRecyclerView = this.recyclerView;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView = null;
        }
        daijishouRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment.onCreateView.5
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && RetroAchievementsGameDialogFragment.this.refocusOnScrolledToTop) {
                    HorizontalScrollView horizontalScrollView2 = RetroAchievementsGameDialogFragment.this.scrollView;
                    Chip chip16 = null;
                    if (horizontalScrollView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
                        horizontalScrollView2 = null;
                    }
                    if (horizontalScrollView2.getScrollX() == 0) {
                        RetroAchievementsGameDialogFragment.this.refocusOnScrolledToTop = false;
                        Chip chip17 = RetroAchievementsGameDialogFragment.this.refreshButton;
                        if (chip17 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
                        } else {
                            chip16 = chip17;
                        }
                        chip16.requestFocus();
                    }
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i, i2);
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
        });
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
        this.viewToBeRefocus = (View) chip17;
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
        chip24.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RetroAchievementsGameDialogFragment.onCreateView$lambda$12(this.f$0, retroAchievementsGameRecordByIdStatically, view);
            }
        });
        Chip chip25 = this.toggleViewButton;
        if (chip25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toggleViewButton");
            chip25 = null;
        }
        chip25.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RetroAchievementsGameDialogFragment.onCreateView$lambda$13(this.f$0, view);
            }
        });
        Context contextRequireContext = requireContext();
        Chip chip26 = this.associateItemButton;
        if (chip26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("associateItemButton");
            chip26 = null;
        }
        final PopupMenu popupMenu = new PopupMenu(contextRequireContext, (View) chip26);
        popupMenu.getMenu().add(0, 0, 0, getString(R.string.retro_achievements_associate_playable_item));
        popupMenu.getMenu().add(0, 1, 1, getString(R.string.retro_achievements_view_associated_playable_item));
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda6
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return RetroAchievementsGameDialogFragment.onCreateView$lambda$16(retroAchievementsGameRecordByIdStatically, this, menuItem);
            }
        });
        Chip chip27 = this.associateItemButton;
        if (chip27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("associateItemButton");
            chip27 = null;
        }
        chip27.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RetroAchievementsGameDialogFragment.onCreateView$lambda$17(popupMenu, view);
            }
        });
        Chip chip28 = this.playerCountButton;
        if (chip28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerCountButton");
            chip28 = null;
        }
        chip28.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RetroAchievementsGameDialogFragment.onCreateView$lambda$18(this.f$0, retroAchievementsGameRecordByIdStatically, view);
            }
        });
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
        chip31.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RetroAchievementsGameDialogFragment.onCreateView$lambda$20(retroAchievementsGameRecordByIdStatically, this, view);
            }
        });
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
        chip33.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RetroAchievementsGameDialogFragment.onCreateView$lambda$22(retroAchievementsGameRecordByIdStatically, this, view);
            }
        });
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
        chip35.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RetroAchievementsGameDialogFragment.onCreateView$lambda$24(objectRef, this, view);
            }
        });
        Chip chip36 = this.refreshButton;
        if (chip36 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
            chip36 = null;
        }
        chip36.requestFocus();
        getRetroAchievementsRepository().getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionsByGameId(retroAchievementsGameRecordByIdStatically.getGameId()).observe((LifecycleOwner) this, new RetroAchievementsGameDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity>, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment.onCreateView.14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> list) {
                invoke2((List<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity>) list);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [T, com.magneticchen.daijishou.data.db.entity.PlayableItemEntity] */
            /* JADX WARN: Type inference failed for: r9v6, types: [T, com.magneticchen.daijishou.data.db.entity.PlayableItemEntity] */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> list) {
                Chip chip37 = null;
                if (RetroAchievementsGameDialogFragment.this.playableItemEntityToBeRestoredInDialog != null) {
                    objectRef.element = RetroAchievementsGameDialogFragment.this.playableItemEntityToBeRestoredInDialog;
                    Chip chip38 = RetroAchievementsGameDialogFragment.this.playableItemButton;
                    if (chip38 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("playableItemButton");
                    } else {
                        chip37 = chip38;
                    }
                    chip37.setVisibility(0);
                    return;
                }
                Intrinsics.checkNotNull(list);
                RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity = (RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity) CollectionsKt.getOrNull(list, 0);
                if (retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity != null) {
                    Ref.ObjectRef<PlayableItemEntity> objectRef2 = objectRef;
                    RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment = RetroAchievementsGameDialogFragment.this;
                    objectRef2.element = retroAchievementsGameDialogFragment.getDaijishouLibrary().getPlayableItemByIdStatically(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.getPlayableItemId());
                    Chip chip39 = retroAchievementsGameDialogFragment.playableItemButton;
                    if (chip39 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("playableItemButton");
                    } else {
                        chip37 = chip39;
                    }
                    chip37.setVisibility(objectRef2.element == null ? 8 : 0);
                }
            }
        }));
        this.viewMode = getDefaultSharedPreferences().getInt("retro_achievements_game_view_mode", 0);
        refreshViewType(getRetroAchievementsRepository().getRetroAchievementsAchievementRecordsByGameRecordIdStatically(jLongValue));
        RetroAchievementsGameRecordEntity retroAchievementsGameRecordByIdStatically2 = getRetroAchievementsRepository().getRetroAchievementsGameRecordByIdStatically(jLongValue);
        if (retroAchievementsGameRecordByIdStatically2 != null) {
            onCreateView$updateRetroAchievementsGameRecord(this, viewInflate, retroAchievementsGameRecordByIdStatically2);
            Unit unit7 = Unit.INSTANCE;
            Unit unit8 = Unit.INSTANCE;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        getRetroAchievementsRepository().getRetroAchievementsGameRecordById(jLongValue).observe(getViewLifecycleOwner(), new RetroAchievementsGameDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<RetroAchievementsGameRecordEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment.onCreateView.16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
                invoke2(retroAchievementsGameRecordEntity);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
                if (!booleanRef.element && retroAchievementsGameRecordEntity != null) {
                    RetroAchievementsGameDialogFragment.onCreateView$updateRetroAchievementsGameRecord(this, viewInflate, retroAchievementsGameRecordEntity);
                } else {
                    booleanRef.element = false;
                }
            }
        }));
        List<RetroAchievementsUserAwardEntity> retroAchievementsUserAwardsByUserIdAndAwardDataStatically = getRetroAchievementsRepository().getRetroAchievementsUserAwardsByUserIdAndAwardDataStatically(retroAchievementsGameRecordByIdStatically.getUserId(), retroAchievementsGameRecordByIdStatically.getGameId());
        ImageView imageView = this.awardIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("awardIcon");
            imageView = null;
        }
        imageView.setVisibility(retroAchievementsUserAwardsByUserIdAndAwardDataStatically.isEmpty() ? 8 : 0);
        Unit unit9 = Unit.INSTANCE;
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        booleanRef2.element = true;
        getRetroAchievementsRepository().getRetroAchievementsUserAwardsByUserIdAndAwardData(retroAchievementsGameRecordByIdStatically.getUserId(), retroAchievementsGameRecordByIdStatically.getGameId()).observe(getViewLifecycleOwner(), new RetroAchievementsGameDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends RetroAchievementsUserAwardEntity>, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment.onCreateView.18
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends RetroAchievementsUserAwardEntity> list) {
                invoke2((List<RetroAchievementsUserAwardEntity>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<RetroAchievementsUserAwardEntity> list) {
                if (!booleanRef2.element && list != null) {
                    ImageView imageView2 = this.awardIcon;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("awardIcon");
                        imageView2 = null;
                    }
                    imageView2.setVisibility(list.isEmpty() ? 8 : 0);
                    return;
                }
                booleanRef2.element = false;
            }
        }));
        getRetroAchievementsManager().getRefreshingGameIdsLiveData().observe(getViewLifecycleOwner(), new RetroAchievementsGameDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends Long>, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment.onCreateView.19
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

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
                linearProgressIndicator.setIndeterminate(list.contains(Long.valueOf(retroAchievementsGameRecordByIdStatically.getGameId())));
            }
        }));
        final Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
        booleanRef3.element = true;
        new PairLiveData(new SharedPreferenceIntLiveData(getDefaultSharedPreferences(), "retro_achievements_game_view_mode", 0), getRetroAchievementsRepository().getRetroAchievementsAchievementRecordsByGameRecordId(jLongValue)).observe(getViewLifecycleOwner(), new RetroAchievementsGameDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<Pair<? extends Integer, ? extends List<? extends RetroAchievementsAchievementRecordEntity>>, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment.onCreateView.20
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Integer, ? extends List<? extends RetroAchievementsAchievementRecordEntity>> pair) {
                invoke2((Pair<Integer, ? extends List<RetroAchievementsAchievementRecordEntity>>) pair);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Integer, ? extends List<RetroAchievementsAchievementRecordEntity>> pair) {
                if (booleanRef3.element) {
                    booleanRef3.element = false;
                    return;
                }
                RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment = this;
                Integer first = pair.getFirst();
                Intrinsics.checkNotNull(first);
                retroAchievementsGameDialogFragment.viewMode = first.intValue();
                this.refreshViewType(pair.getSecond());
            }
        }));
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$12(RetroAchievementsGameDialogFragment this$0, RetroAchievementsGameRecordEntity retroAchievementsGameRecord, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecord, "$retroAchievementsGameRecord");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this$0), Dispatchers.getIO(), (CoroutineStart) null, new RetroAchievementsGameDialogFragment$onCreateView$6$1(this$0, retroAchievementsGameRecord, null), 2, (Object) null);
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
    public static final boolean onCreateView$lambda$16(final RetroAchievementsGameRecordEntity retroAchievementsGameRecord, final RetroAchievementsGameDialogFragment this$0, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecord, "$retroAchievementsGameRecord");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (menuItem.getItemId() == 0) {
            final ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragmentNewInstance$default = ChoosePlayableItemFromLibraryDialogFragment.Companion.newInstance$default(ChoosePlayableItemFromLibraryDialogFragment.Companion, null, false, false, false, false, false, 63, null);
            choosePlayableItemFromLibraryDialogFragmentNewInstance$default.setOnClickListener(new Function1<PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$onCreateView$8$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
                    invoke2(playableItemEntity);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PlayableItemEntity it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this$0.getRetroAchievementsRepository().addRetroAchievementsCachedPlayableItemIdToGameIdSurjection(new RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity(0L, true, it.getId(), retroAchievementsGameRecord.getGameId(), null, 17, null));
                    choosePlayableItemFromLibraryDialogFragmentNewInstance$default.dismiss();
                    Toast.makeText(this$0.requireContext(), this$0.getString(R.string.associated), 0).show();
                }
            });
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
        Iterator<T> it = retroAchievementsCachedPlayableItemIdToGameIdSurjectionsByGameIdStatically.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity) it.next()).getPlayableItemId()));
        }
        Application application = this$0.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        DaijishouLibraryRepository daijishouLibraryRepository = ((DaijishouApplication) application).getDaijishouLibraryRepository();
        long[] longArray = CollectionsKt.toLongArray(arrayList);
        final StaticPlayableItemCollectionDialogFragment staticPlayableItemCollectionDialogFragmentNewInstance$default = StaticPlayableItemCollectionDialogFragment.Companion.newInstance$default(StaticPlayableItemCollectionDialogFragment.Companion, daijishouLibraryRepository.getPlayableItemsByIdsStatically(Arrays.copyOf(longArray, longArray.length)), this$0.getString(R.string.retro_achievements_view_associated_playable_item_title), false, 4, null);
        staticPlayableItemCollectionDialogFragmentNewInstance$default.setOnClickListener(new Function1<PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$onCreateView$8$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
                invoke2(playableItemEntity);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayableItemEntity it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                this.this$0.getRetroAchievementsRepository().deleteRetroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemId(it2.getId());
                staticPlayableItemCollectionDialogFragmentNewInstance$default.dismiss();
                Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.removed), 0).show();
            }
        }).show(this$0.getParentFragmentManager(), StaticPlayableItemCollectionDialogFragment.class.getName());
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
            PlayableItemDetailDialogFragment.Companion.newInstance(playableItemEntity).show(this$0.getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$updateRetroAchievementsGameRecord(final RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment, View view, final RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
        Chip chip = retroAchievementsGameDialogFragment.retroAchievementsButton;
        Chip chip2 = null;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsButton");
            chip = null;
        }
        chip.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RetroAchievementsGameDialogFragment.onCreateView$updateRetroAchievementsGameRecord$lambda$26(retroAchievementsGameRecordEntity, retroAchievementsGameDialogFragment, view2);
            }
        });
        Chip chip3 = retroAchievementsGameDialogFragment.playerCountButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerCountButton");
            chip3 = null;
        }
        chip3.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RetroAchievementsGameDialogFragment.onCreateView$updateRetroAchievementsGameRecord$lambda$27(this.f$0, retroAchievementsGameRecordEntity, view2);
            }
        });
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
        chip6.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RetroAchievementsGameDialogFragment.onCreateView$updateRetroAchievementsGameRecord$lambda$29(retroAchievementsGameRecordEntity, retroAchievementsGameDialogFragment, view2);
            }
        });
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
        chip8.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RetroAchievementsGameDialogFragment.onCreateView$updateRetroAchievementsGameRecord$lambda$31(retroAchievementsGameRecordEntity, retroAchievementsGameDialogFragment, view2);
            }
        });
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

    public void onResume() {
        super.onResume();
        Window window = requireDialog().getWindow();
        Intrinsics.checkNotNull(window);
        window.getWindowManager().updateViewLayout(window.getDecorView(), window.getAttributes());
        MainActivity mainActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(mainActivityRequireActivity, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.activities.MainActivity");
        mainActivityRequireActivity.setAndroidPDialogFixStopKeyDispatching(false);
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View view2 = this.viewToBeRefocus;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewToBeRefocus");
            view2 = null;
        }
        view2.requestFocus();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        DpToPxConverter dpToPxConverter = new DpToPxConverter(contextRequireContext);
        ConstraintLayout constraintLayoutFindViewById = view.findViewById(R.id.rounded_full_screen_dialog_root);
        ViewGroup.LayoutParams layoutParams = constraintLayoutFindViewById.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).setMargins(dpToPxConverter.convert(12.0f), dpToPxConverter.convert(12.0f), dpToPxConverter.convert(12.0f), dpToPxConverter.convert(12.0f));
        constraintLayoutFindViewById.setBackground(AppCompatResources.getDrawable(requireContext(), R.drawable.rounded_full_screen_dialog));
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.FullScreenDialogAnimation);
        }
    }
}
