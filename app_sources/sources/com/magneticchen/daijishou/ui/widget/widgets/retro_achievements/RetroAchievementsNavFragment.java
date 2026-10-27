package com.magneticchen.daijishou.ui.widget.widgets.retro_achievements;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
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
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.IntPreference;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsGameRecordEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserProfileEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserRankingEntity;
import com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository;
import com.magneticchen.daijishou.data.live.SharedPreferenceIntLiveData;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.ui.fragments.dialog.RetroAchievementsGameDialogFragment;
import com.magneticchen.daijishou.ui.model.DaijishouViewModel;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetNavFragment;
import com.skydoves.balloon.internals.DefinitionKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RetroAchievementsNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 G2\u00020\u0001:\u0003GHIB\u0005¢\u0006\u0002\u0010\u0002J\b\u00109\u001a\u00020*H\u0016J\u0012\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J&\u0010>\u001a\u0004\u0018\u00010\u00102\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010C\u001a\u00020;H\u0016J\u0010\u0010D\u001a\u00020;2\u0006\u0010E\u001a\u00020FH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00060&R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u00060(R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetNavFragment;", "()V", "achievementCompletedFormatString", "", "achievementPointsFormatString", "allTimeString", "awardsButton", "Lcom/google/android/material/chip/Chip;", "chipStrokeWidth", "", "completionButton", "dailyString", "description", "Landroid/widget/TextView;", "divider", "Landroid/view/View;", "loadingDataString", "loadingString", "loadingUsernameString", "model", "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "model$delegate", "Lkotlin/Lazy;", "motto", "nOfMCompletedAbbreviationFormatString", "nOfMFormatString", "noMottoString", "placeHolder", "Landroid/widget/ImageView;", "pleaseLoginString", "rankingButton", "recentButton", "recyclerView", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView;", "recyclerViewGameListAdapter", "Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment$GameListAdapter;", "recyclerViewRankingUserProfileListAdapter", "Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment$RankingUserProfileListAdapter;", "refocusOnScrolledToTop", "", "refreshButton", "retroAchievementsButton", "retroAchievementsGameRecordList", "", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;", "retroAchievementsUserRankingList", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserRankingEntity;", "scrollView", "Landroid/widget/HorizontalScrollView;", "scrollingOnBackPressed", "thumbnail", "title", "userAchievementDescriptionFormatString", "weeklyString", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "renderUserProfile", "userProfile", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserProfileEntity;", "Companion", "GameListAdapter", "RankingUserProfileListAdapter", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsNavFragment extends WidgetNavFragment {
    public static final int BEATEN_VIEW_MODE = 2;
    public static final int COMPLETION_VIEW_MODE = 1;
    public static final Companion Companion = new Companion(null);
    public static final int RANKING_ALL_TIME_VIEW_MODE = 5;
    public static final int RANKING_DAILY_VIEW_MODE = 3;
    public static final int RANKING_WEEKLY_VIEW_MODE = 4;
    public static final int RECENT_VIEW_MODE = 0;
    private static final Typeface typeface;
    private String achievementCompletedFormatString;
    private String achievementPointsFormatString;
    private String allTimeString;
    private Chip awardsButton;
    private float chipStrokeWidth;
    private Chip completionButton;
    private String dailyString;
    private TextView description;
    private View divider;
    private String loadingDataString;
    private String loadingString;
    private String loadingUsernameString;
    private final Lazy model$delegate;
    private TextView motto;
    private String nOfMCompletedAbbreviationFormatString;
    private String nOfMFormatString;
    private String noMottoString;
    private ImageView placeHolder;
    private String pleaseLoginString;
    private Chip rankingButton;
    private Chip recentButton;
    private DaijishouRecyclerView recyclerView;
    private GameListAdapter recyclerViewGameListAdapter;
    private RankingUserProfileListAdapter recyclerViewRankingUserProfileListAdapter;
    private boolean refocusOnScrolledToTop;
    private Chip refreshButton;
    private Chip retroAchievementsButton;
    private final List<RetroAchievementsGameRecordEntity> retroAchievementsGameRecordList = new ArrayList();
    private final List<RetroAchievementsUserRankingEntity> retroAchievementsUserRankingList = new ArrayList();
    private HorizontalScrollView scrollView;
    private boolean scrollingOnBackPressed;
    private ImageView thumbnail;
    private TextView title;
    private String userAchievementDescriptionFormatString;
    private String weeklyString;

    public RetroAchievementsNavFragment() {
        final RetroAchievementsNavFragment retroAchievementsNavFragment = this;
        final Function0 function0 = null;
        this.model$delegate = FragmentViewModelLazyKt.createViewModelLazy(retroAchievementsNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return retroAchievementsNavFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? retroAchievementsNavFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return retroAchievementsNavFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: compiled from: RetroAchievementsNavFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment$Companion;", "", "()V", "BEATEN_VIEW_MODE", "", "COMPLETION_VIEW_MODE", "RANKING_ALL_TIME_VIEW_MODE", "RANKING_DAILY_VIEW_MODE", "RANKING_WEEKLY_VIEW_MODE", "RECENT_VIEW_MODE", "typeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "newInstance", "Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RetroAchievementsNavFragment newInstance() {
            RetroAchievementsNavFragment retroAchievementsNavFragment = new RetroAchievementsNavFragment();
            retroAchievementsNavFragment.setArguments(new Bundle());
            return retroAchievementsNavFragment;
        }
    }

    static {
        typeface = Build.VERSION.SDK_INT >= 28 ? Typeface.create(null, Constants.semiBolderWeight, false) : Typeface.defaultFromStyle(1);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0020  */
    /* JADX WARN: Code duplicated, block: B:14:0x002a  */
    /* JADX WARN: Code duplicated, block: B:16:0x002e  */
    /* JADX WARN: Code duplicated, block: B:42:0x007f  */
    /* JADX WARN: Code duplicated, block: B:45:0x008a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0095  */
    /* JADX WARN: Code duplicated, block: B:49:0x0099  */
    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
    
        if (r0.getScrollX() == 0) goto L19;
     */
    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onBackPressed() {
        /*
            r8 = this;
            boolean r0 = r8.scrollingOnBackPressed
            java.lang.String r1 = "scrollView"
            java.lang.String r2 = "refreshButton"
            r3 = 1
            java.lang.String r4 = "recyclerView"
            r5 = 0
            r6 = 0
            if (r0 == 0) goto L1c
            com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView r0 = r8.recyclerView
            if (r0 != 0) goto L15
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r6
        L15:
            int r0 = r0.getScrollState()
            r7 = 2
            if (r0 == r7) goto L38
        L1c:
            com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView r0 = r8.recyclerView
            if (r0 != 0) goto L24
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r6
        L24:
            int r0 = r0.computeVerticalScrollOffset()
            if (r0 != 0) goto L77
            android.widget.HorizontalScrollView r0 = r8.scrollView
            if (r0 != 0) goto L32
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r6
        L32:
            int r0 = r0.getScrollX()
            if (r0 != 0) goto L77
        L38:
            com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView r0 = r8.recyclerView
            if (r0 != 0) goto L40
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r6
        L40:
            r0.scrollToPosition(r5)
            android.widget.HorizontalScrollView r0 = r8.scrollView
            if (r0 != 0) goto L4b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r6
        L4b:
            r0.scrollTo(r5, r5)
            com.google.android.material.chip.Chip r0 = r8.refreshButton
            if (r0 != 0) goto L56
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r6
        L56:
            boolean r0 = r0.isFocused()
            if (r0 == 0) goto L5d
            return r3
        L5d:
            com.google.android.material.chip.Chip r0 = r8.refreshButton
            if (r0 != 0) goto L65
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r6
        L65:
            r0.requestFocus()
            com.google.android.material.chip.Chip r0 = r8.refreshButton
            if (r0 != 0) goto L70
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L71
        L70:
            r6 = r0
        L71:
            boolean r0 = r6.isFocused()
            r0 = r0 ^ r3
            return r0
        L77:
            r8.scrollingOnBackPressed = r3
            r8.refocusOnScrolledToTop = r3
            com.google.android.material.chip.Chip r0 = r8.refreshButton
            if (r0 != 0) goto L83
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r6
        L83:
            r0.requestFocus()
            com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView r0 = r8.recyclerView
            if (r0 != 0) goto L8e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r6
        L8e:
            r0.smoothScrollToPosition(r5)
            android.widget.HorizontalScrollView r0 = r8.scrollView
            if (r0 != 0) goto L99
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L9a
        L99:
            r6 = r0
        L9a:
            r6.smoothScrollTo(r5, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.onBackPressed():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUserProfile(final RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
        String str;
        TextView textView = this.title;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        textView.setText(retroAchievementsUserProfileEntity.getId());
        TextView textView2 = this.motto;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("motto");
            textView2 = null;
        }
        if (retroAchievementsUserProfileEntity.getMotto() != null) {
            str = "“ " + retroAchievementsUserProfileEntity.getMotto() + " ”";
        } else {
            str = this.noMottoString;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noMottoString");
                str = null;
            }
        }
        textView2.setText(str);
        TextView textView3 = this.description;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("description");
            textView3 = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = this.userAchievementDescriptionFormatString;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAchievementDescriptionFormatString");
            str2 = null;
        }
        String str3 = String.format(str2, Arrays.copyOf(new Object[]{Integer.valueOf(retroAchievementsUserProfileEntity.getHardcorePoints() + retroAchievementsUserProfileEntity.getSoftcorePoints()), Integer.valueOf(retroAchievementsUserProfileEntity.getHardcorePoints()), Integer.valueOf(retroAchievementsUserProfileEntity.getSoftcorePoints()), Float.valueOf(100 * retroAchievementsUserProfileEntity.getAverageCompletionPercentage())}, 4));
        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
        textView3.setText(str3);
        Chip chip = this.retroAchievementsButton;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsButton");
            chip = null;
        }
        chip.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RetroAchievementsNavFragment.renderUserProfile$lambda$1(retroAchievementsUserProfileEntity, this, view);
            }
        });
        if (retroAchievementsUserProfileEntity.getImageUrl() == null) {
            RequestManager requestManagerWith = Glide.with(this);
            ImageView imageView2 = this.thumbnail;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
                imageView2 = null;
            }
            requestManagerWith.clear(imageView2);
            ImageView imageView3 = this.placeHolder;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
            } else {
                imageView = imageView3;
            }
            imageView.setVisibility(0);
            return;
        }
        RequestBuilder requestBuilderListener = Glide.with(this).load(retroAchievementsUserProfileEntity.getImageUrl()).dontAnimate().listener(new RequestListener<Drawable>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.renderUserProfile.2
            public /* bridge */ /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, DataSource dataSource, boolean z) {
                return onResourceReady((Drawable) obj, obj2, (Target<Drawable>) target, dataSource, z);
            }

            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                Intrinsics.checkNotNullParameter(target, "target");
                ImageView imageView4 = RetroAchievementsNavFragment.this.placeHolder;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
                    imageView4 = null;
                }
                imageView4.setVisibility(0);
                return false;
            }

            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean z) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                Intrinsics.checkNotNullParameter(model, "model");
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                ImageView imageView4 = RetroAchievementsNavFragment.this.placeHolder;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
                    imageView4 = null;
                }
                imageView4.setVisibility(8);
                return false;
            }
        });
        ImageView imageView4 = this.thumbnail;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
        } else {
            imageView = imageView4;
        }
        requestBuilderListener.into(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderUserProfile$lambda$1(RetroAchievementsUserProfileEntity userProfile, RetroAchievementsNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(userProfile, "$userProfile");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String url = userProfile.getUrl();
        if (url != null) {
            this$0.requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        }
    }

    /* JADX INFO: compiled from: RetroAchievementsNavFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\n0\u000bR\u00060\u0000R\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment$RankingUserProfileListAdapter;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserRankingEntity;", "retroAchievementsUserRankingList", "", "(Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment;Ljava/util/List;)V", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment$RankingUserProfileListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment;", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class RankingUserProfileListAdapter extends DaijishouRecyclerView.Adapter<RetroAchievementsUserRankingEntity> {
        private final List<RetroAchievementsUserRankingEntity> retroAchievementsUserRankingList;
        final /* synthetic */ RetroAchievementsNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RankingUserProfileListAdapter(RetroAchievementsNavFragment retroAchievementsNavFragment, List<RetroAchievementsUserRankingEntity> retroAchievementsUserRankingList) {
            super(retroAchievementsUserRankingList, true, false, 4, null);
            Intrinsics.checkNotNullParameter(retroAchievementsUserRankingList, "retroAchievementsUserRankingList");
            this.this$0 = retroAchievementsNavFragment;
            this.retroAchievementsUserRankingList = retroAchievementsUserRankingList;
            setEnforceSelectionInSelectableMode(false);
        }

        /* JADX INFO: compiled from: RetroAchievementsNavFragment.kt */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment$RankingUserProfileListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserRankingEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment$RankingUserProfileListAdapter;Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "pointsSubtitle", "Landroid/widget/TextView;", "title", "onBind", "", "position", "", "RetroAchievementsUserRanking", "onClick", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<RetroAchievementsUserRankingEntity>.ViewHolder {
            private final ImageView imageView;
            private final TextView pointsSubtitle;
            final /* synthetic */ RankingUserProfileListAdapter this$0;
            private final TextView title;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(RankingUserProfileListAdapter rankingUserProfileListAdapter, View itemView) {
                super(rankingUserProfileListAdapter, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = rankingUserProfileListAdapter;
                View viewFindViewById = itemView.findViewById(R.id.list_item_retro_achievements_ranking_user_profile_image_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                this.imageView = (ImageView) viewFindViewById;
                View viewFindViewById2 = itemView.findViewById(R.id.list_item_retro_achievements_ranking_user_profile_title);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.title = (TextView) viewFindViewById2;
                View viewFindViewById3 = itemView.findViewById(R.id.list_item_retro_achievements_ranking_user_profile_points_subtitle);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                this.pointsSubtitle = (TextView) viewFindViewById3;
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public boolean onClick() {
                String url = ((RetroAchievementsUserRankingEntity) this.this$0.retroAchievementsUserRankingList.get(getAbsoluteAdapterPosition())).getUrl();
                if (url != null) {
                    RetroAchievementsNavFragment retroAchievementsNavFragment = this.this$0.this$0;
                    retroAchievementsNavFragment.requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                }
                return super.onClick();
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int i, RetroAchievementsUserRankingEntity RetroAchievementsUserRanking) {
                Intrinsics.checkNotNullParameter(RetroAchievementsUserRanking, "RetroAchievementsUserRanking");
                this.title.setText(RetroAchievementsUserRanking.getUserId());
                TextView textView = this.pointsSubtitle;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = this.this$0.this$0.achievementPointsFormatString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("achievementPointsFormatString");
                    str = null;
                }
                String str2 = String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(RetroAchievementsUserRanking.getEarnedPoints())}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                textView.setText(str2);
                if (RetroAchievementsUserRanking.getImageUrl() == null) {
                    Glide.with(this.this$0.this$0).clear(this.imageView);
                } else {
                    Glide.with(this.this$0.this$0).load(RetroAchievementsUserRanking.getImageUrl()).transition(DrawableTransitionOptions.withCrossFade()).into(this.imageView);
                }
            }
        }

        public long getItemId(int i) {
            return this.retroAchievementsUserRankingList.get(i).getId();
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_retro_achievements_ranking_user_profile, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    /* JADX INFO: compiled from: RetroAchievementsNavFragment.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\n0\u001aR\u00060\u0000R\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment$GameListAdapter;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;", "retroAchievementsGameRecordList", "", "(Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment;Ljava/util/List;)V", "enforceSelectionInSelectableMode", "", "getEnforceSelectionInSelectableMode", "()Z", "setEnforceSelectionInSelectableMode", "(Z)V", "getGlidePreloadRequestBuilderOfImageView", "Lkotlin/Function1;", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getGlidePreloadRequestBuilderOfSystemIcon", "imageViewGlideViewPreloadSizeProvider", "Lcom/bumptech/glide/util/ViewPreloadSizeProvider;", "systemIconGlideViewPreloadSizeProvider", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment$GameListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment;", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class GameListAdapter extends DaijishouRecyclerView.Adapter<RetroAchievementsGameRecordEntity> {
        private boolean enforceSelectionInSelectableMode;
        private final Function1<RetroAchievementsGameRecordEntity, RequestBuilder<Drawable>> getGlidePreloadRequestBuilderOfImageView;
        private final Function1<RetroAchievementsGameRecordEntity, RequestBuilder<Drawable>> getGlidePreloadRequestBuilderOfSystemIcon;
        private final ViewPreloadSizeProvider<RetroAchievementsGameRecordEntity> imageViewGlideViewPreloadSizeProvider;
        private final List<RetroAchievementsGameRecordEntity> retroAchievementsGameRecordList;
        private final ViewPreloadSizeProvider<RetroAchievementsGameRecordEntity> systemIconGlideViewPreloadSizeProvider;
        final /* synthetic */ RetroAchievementsNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GameListAdapter(final RetroAchievementsNavFragment retroAchievementsNavFragment, List<RetroAchievementsGameRecordEntity> retroAchievementsGameRecordList) {
            super(retroAchievementsGameRecordList, true, false, 4, null);
            Intrinsics.checkNotNullParameter(retroAchievementsGameRecordList, "retroAchievementsGameRecordList");
            this.this$0 = retroAchievementsNavFragment;
            this.retroAchievementsGameRecordList = retroAchievementsGameRecordList;
            Function1<RetroAchievementsGameRecordEntity, RequestBuilder<Drawable>> function1 = new Function1<RetroAchievementsGameRecordEntity, RequestBuilder<Drawable>>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$GameListAdapter$getGlidePreloadRequestBuilderOfImageView$1
                

                @Override // kotlin.jvm.functions.Function1
                public final RequestBuilder<Drawable> invoke(RetroAchievementsGameRecordEntity retroAchievementsGameRecord) {
                    Intrinsics.checkNotNullParameter(retroAchievementsGameRecord, "retroAchievementsGameRecord");
                    if (retroAchievementsGameRecord.getImageUrl() == null) {
                        return null;
                    }
                    return Glide.with(retroAchievementsNavFragment).load(retroAchievementsGameRecord.getImageUrl()).transition(DrawableTransitionOptions.withCrossFade());
                }
            };
            this.getGlidePreloadRequestBuilderOfImageView = function1;
            Function1<RetroAchievementsGameRecordEntity, RequestBuilder<Drawable>> function2 = new Function1<RetroAchievementsGameRecordEntity, RequestBuilder<Drawable>>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$GameListAdapter$getGlidePreloadRequestBuilderOfSystemIcon$1
                

                @Override // kotlin.jvm.functions.Function1
                public final RequestBuilder<Drawable> invoke(RetroAchievementsGameRecordEntity retroAchievementsGameRecord) {
                    Intrinsics.checkNotNullParameter(retroAchievementsGameRecord, "retroAchievementsGameRecord");
                    String consoleImageUrl = retroAchievementsNavFragment.getRetroAchievementsManager().getConsoleImageUrl(retroAchievementsGameRecord.getConsoleId());
                    if (consoleImageUrl == null) {
                        return null;
                    }
                    return Glide.with(retroAchievementsNavFragment).load(consoleImageUrl).transition(DrawableTransitionOptions.withCrossFade());
                }
            };
            this.getGlidePreloadRequestBuilderOfSystemIcon = function2;
            GameListAdapter gameListAdapter = this;
            this.imageViewGlideViewPreloadSizeProvider = DaijishouRecyclerView.Adapter.addGlidePreloaderBuilderCreator$default(gameListAdapter, function1, 0, 2, null);
            this.systemIconGlideViewPreloadSizeProvider = DaijishouRecyclerView.Adapter.addGlidePreloaderBuilderCreator$default(gameListAdapter, function2, 0, 2, null);
        }

        @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter
        public boolean getEnforceSelectionInSelectableMode() {
            return this.enforceSelectionInSelectableMode;
        }

        @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter
        public void setEnforceSelectionInSelectableMode(boolean z) {
            this.enforceSelectionInSelectableMode = z;
        }

        public long getItemId(int i) {
            return this.retroAchievementsGameRecordList.get(i).getId();
        }

        /* JADX INFO: compiled from: RetroAchievementsNavFragment.kt */
        @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0018\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment$GameListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/widget/widgets/retro_achievements/RetroAchievementsNavFragment$GameListAdapter;Landroid/view/View;)V", "description", "Landroid/widget/TextView;", "gameId", "", "imageView", "Landroid/widget/ImageView;", "linearProgressIndicator", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "pointsSubtitle", "progress", "", "systemIcon", "title", "loadGameData", "", "retroAchievementsGameRecord", "onBind", "position", "", "item", "onClick", "", "onFocus", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<RetroAchievementsGameRecordEntity>.ViewHolder {
            private final TextView description;
            private long gameId;
            private final ImageView imageView;
            private final LinearProgressIndicator linearProgressIndicator;
            private final TextView pointsSubtitle;
            private float progress;
            private final ImageView systemIcon;
            final /* synthetic */ GameListAdapter this$0;
            private final TextView title;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(GameListAdapter gameListAdapter, View itemView) {
                super(gameListAdapter, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = gameListAdapter;
                this.gameId = -1L;
                View viewFindViewById = itemView.findViewById(R.id.list_item_retro_achievements_game_image_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                ImageView imageView = (ImageView) viewFindViewById;
                this.imageView = imageView;
                View viewFindViewById2 = itemView.findViewById(R.id.list_item_retro_achievements_game_title);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.title = (TextView) viewFindViewById2;
                LinearProgressIndicator linearProgressIndicatorFindViewById = itemView.findViewById(R.id.list_item_retro_achievements_game_linear_progress_indicator);
                Intrinsics.checkNotNullExpressionValue(linearProgressIndicatorFindViewById, "findViewById(...)");
                this.linearProgressIndicator = linearProgressIndicatorFindViewById;
                View viewFindViewById3 = itemView.findViewById(R.id.list_item_retro_achievements_game_system_icon);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                ImageView imageView2 = (ImageView) viewFindViewById3;
                this.systemIcon = imageView2;
                View viewFindViewById4 = itemView.findViewById(R.id.list_item_retro_achievements_game_points_subtitle);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
                this.pointsSubtitle = (TextView) viewFindViewById4;
                View viewFindViewById5 = itemView.findViewById(R.id.list_item_retro_achievements_game_progress_description);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
                this.description = (TextView) viewFindViewById5;
                gameListAdapter.setEnforceSelectionInSelectableMode(false);
                gameListAdapter.imageViewGlideViewPreloadSizeProvider.setView(imageView);
                gameListAdapter.systemIconGlideViewPreloadSizeProvider.setView(imageView2);
                gameListAdapter.setKeepSelectedItemFocusedInSelectableMode(false);
            }

            private final void loadGameData(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
                this.title.setText(this.this$0.this$0.getDaijishouLibrary().prettifyTitleWithPreferences(String.valueOf(retroAchievementsGameRecordEntity.getName())));
                TextView textView = this.pointsSubtitle;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = this.this$0.this$0.nOfMCompletedAbbreviationFormatString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nOfMCompletedAbbreviationFormatString");
                    str = null;
                }
                String str2 = String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(retroAchievementsGameRecordEntity.getUnlockedAchievementsCount()), Integer.valueOf(retroAchievementsGameRecordEntity.getAchievementsCount())}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                textView.setText(str2);
                float achievementsCount = retroAchievementsGameRecordEntity.getAchievementsCount();
                float unlockedAchievementsCount = DefinitionKt.NO_Float_VALUE;
                if (achievementsCount != DefinitionKt.NO_Float_VALUE) {
                    unlockedAchievementsCount = (retroAchievementsGameRecordEntity.getUnlockedAchievementsCount() * 100.0f) / retroAchievementsGameRecordEntity.getAchievementsCount();
                }
                this.progress = unlockedAchievementsCount;
                this.linearProgressIndicator.setProgress((int) unlockedAchievementsCount);
                this.description.setText(retroAchievementsGameRecordEntity.getConsoleName());
                if (retroAchievementsGameRecordEntity.getImageUrl() == null) {
                    Glide.with(this.this$0.this$0).clear(this.imageView);
                } else {
                    Glide.with(this.this$0.this$0).load(retroAchievementsGameRecordEntity.getImageUrl()).transition(DrawableTransitionOptions.withCrossFade()).into(this.imageView);
                }
                String consoleImageUrl = this.this$0.this$0.getRetroAchievementsManager().getConsoleImageUrl(retroAchievementsGameRecordEntity.getConsoleId());
                if (consoleImageUrl == null) {
                    Glide.with(this.this$0.this$0).clear(this.systemIcon);
                } else {
                    Glide.with(this.this$0.this$0).load(consoleImageUrl).transition(DrawableTransitionOptions.withCrossFade()).into(this.systemIcon);
                }
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public boolean onClick() {
                RetroAchievementsGameDialogFragment.Companion.newInstance$default(RetroAchievementsGameDialogFragment.Companion, ((RetroAchievementsGameRecordEntity) this.this$0.retroAchievementsGameRecordList.get(getAbsoluteAdapterPosition())).getId(), null, null, null, null, 30, null).show(this.this$0.this$0.getParentFragmentManager(), RetroAchievementsGameDialogFragment.class.getName());
                return super.onClick();
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocus() {
                super.onFocus();
                DaijishouViewModel model = this.this$0.this$0.getModel();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = this.this$0.this$0.achievementCompletedFormatString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("achievementCompletedFormatString");
                    str = null;
                }
                String str2 = String.format(str, Arrays.copyOf(new Object[]{Float.valueOf(this.progress)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                DaijishouViewModel.setTips$default(model, str2, false, 2, null);
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int i, RetroAchievementsGameRecordEntity item) {
                Intrinsics.checkNotNullParameter(item, "item");
                loadGameData(item);
                this.gameId = item.getGameId();
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0.this$0), Dispatchers.getIO(), (CoroutineStart) null, new RetroAchievementsNavFragment$GameListAdapter$ViewHolder$onBind$1(this, item, this.this$0.this$0, null), 2, (Object) null);
            }
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_retro_achievements_game, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.string.loading);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.loadingString = string;
        String string2 = getString(R.string.achievement_no_motto);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.noMottoString = string2;
        String string3 = getString(R.string.please_login);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.pleaseLoginString = string3;
        String string4 = getString(R.string.loading_username);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        this.loadingUsernameString = string4;
        String string5 = getString(R.string.loading_data);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        this.loadingDataString = string5;
        String string6 = getString(R.string.n_of_m_format);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        this.nOfMFormatString = string6;
        String string7 = getString(R.string.n_of_m_completed_abbreviation_format);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        this.nOfMCompletedAbbreviationFormatString = string7;
        String string8 = getString(R.string.achievement_points_format);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        this.achievementPointsFormatString = string8;
        String string9 = getString(R.string.achievement_completed_format);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        this.achievementCompletedFormatString = string9;
        String string10 = getString(R.string.user_achievement_description_format);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        this.userAchievementDescriptionFormatString = string10;
        String string11 = getString(R.string.daily);
        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
        this.dailyString = string11;
        String string12 = getString(R.string.weekly);
        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
        this.weeklyString = string12;
        String string13 = getString(R.string.all_time);
        Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
        this.allTimeString = string13;
        this.chipStrokeWidth = getDpToPxConverter().convert(2.0f);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.widget_nav_retro_achievements_user_profile, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_title_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.title = (TextView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.fragment_retro_achievements_user_motto_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.motto = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_description_text_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.description = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_placeholder);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.placeHolder = (ImageView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_thumbnail);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.thumbnail = (ImageView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.player_associated_platforms_horizontal_scroll_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.scrollView = (HorizontalScrollView) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_divider);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.divider = viewFindViewById7;
        Object objFindViewById = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_recycler_view);
        Intrinsics.checkNotNullExpressionValue(objFindViewById, "findViewById(...)");
        this.recyclerView = (DaijishouRecyclerView) objFindViewById;
        this.recyclerViewGameListAdapter = new GameListAdapter(this, this.retroAchievementsGameRecordList);
        this.recyclerViewRankingUserProfileListAdapter = new RankingUserProfileListAdapter(this, this.retroAchievementsUserRankingList);
        DaijishouRecyclerView daijishouRecyclerView = this.recyclerView;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView = null;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        daijishouRecyclerView.setLayoutManager((RecyclerView.LayoutManager) new DaijishouLinearLayoutManager(contextRequireContext));
        DaijishouRecyclerView daijishouRecyclerView2 = this.recyclerView;
        if (daijishouRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView2 = null;
        }
        daijishouRecyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.onCreateView.1
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (i == 0) {
                    RetroAchievementsNavFragment.this.scrollingOnBackPressed = false;
                }
                super.onScrollStateChanged(recyclerView, i);
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                boolean z = recyclerView.computeVerticalScrollOffset() > RetroAchievementsNavFragment.this.getDpToPxConverter().convert(8.0f);
                View view = null;
                if (z) {
                    View view2 = RetroAchievementsNavFragment.this.divider;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("divider");
                        view2 = null;
                    }
                    if (view2.getVisibility() != 0) {
                        View view3 = RetroAchievementsNavFragment.this.divider;
                        if (view3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("divider");
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
                View view4 = RetroAchievementsNavFragment.this.divider;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("divider");
                    view4 = null;
                }
                if (view4.getVisibility() != 4) {
                    View view5 = RetroAchievementsNavFragment.this.divider;
                    if (view5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("divider");
                    } else {
                        view = view5;
                    }
                    view.setVisibility(4);
                }
            }
        });
        Chip chipFindViewById = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_refresh_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById, "findViewById(...)");
        this.refreshButton = chipFindViewById;
        Chip chipFindViewById2 = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_recent_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById2, "findViewById(...)");
        this.recentButton = chipFindViewById2;
        Chip chipFindViewById3 = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_completion_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById3, "findViewById(...)");
        this.completionButton = chipFindViewById3;
        Chip chipFindViewById4 = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_awards_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById4, "findViewById(...)");
        this.awardsButton = chipFindViewById4;
        Chip chipFindViewById5 = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_friends_ranking_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById5, "findViewById(...)");
        this.rankingButton = chipFindViewById5;
        Chip chipFindViewById6 = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_retro_achievements_button);
        Intrinsics.checkNotNullExpressionValue(chipFindViewById6, "findViewById(...)");
        this.retroAchievementsButton = chipFindViewById6;
        HorizontalScrollView horizontalScrollView = this.scrollView;
        if (horizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            horizontalScrollView = null;
        }
        horizontalScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                RetroAchievementsNavFragment.onCreateView$lambda$2(this.f$0, view, i, i2, i3, i4);
            }
        });
        Chip chip = this.refreshButton;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
            chip = null;
        }
        Typeface typeface2 = typeface;
        chip.setTypeface(typeface2);
        Chip chip2 = this.refreshButton;
        if (chip2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
            chip2 = null;
        }
        chip2.requestFocus();
        Chip chip3 = this.recentButton;
        if (chip3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip3 = null;
        }
        chip3.setTypeface(typeface2);
        Chip chip4 = this.completionButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completionButton");
            chip4 = null;
        }
        chip4.setTypeface(typeface2);
        Chip chip5 = this.awardsButton;
        if (chip5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
            chip5 = null;
        }
        chip5.setTypeface(typeface2);
        Chip chip6 = this.rankingButton;
        if (chip6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
            chip6 = null;
        }
        chip6.setTypeface(typeface2);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Chip chip7 = this.refreshButton;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
            chip7 = null;
        }
        chip7.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RetroAchievementsNavFragment.onCreateView$lambda$3(booleanRef, this, view);
            }
        });
        Chip chip8 = this.recentButton;
        if (chip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip8 = null;
        }
        chip8.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RetroAchievementsNavFragment.onCreateView$lambda$4(this.f$0, view);
            }
        });
        Chip chip9 = this.completionButton;
        if (chip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completionButton");
            chip9 = null;
        }
        chip9.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RetroAchievementsNavFragment.onCreateView$lambda$5(this.f$0, view);
            }
        });
        Chip chip10 = this.awardsButton;
        if (chip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
            chip10 = null;
        }
        chip10.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RetroAchievementsNavFragment.onCreateView$lambda$6(this.f$0, view);
            }
        });
        Context contextRequireContext2 = requireContext();
        Chip chip11 = this.rankingButton;
        if (chip11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
            chip11 = null;
        }
        final PopupMenu popupMenu = new PopupMenu(contextRequireContext2, (View) chip11);
        Menu menu = popupMenu.getMenu();
        String str = this.dailyString;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyString");
            str = null;
        }
        menu.add(0, 3, 0, str);
        Menu menu2 = popupMenu.getMenu();
        String str2 = this.weeklyString;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weeklyString");
            str2 = null;
        }
        menu2.add(0, 4, 1, str2);
        Menu menu3 = popupMenu.getMenu();
        String str3 = this.allTimeString;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allTimeString");
            str3 = null;
        }
        menu3.add(0, 5, 2, str3);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$$ExternalSyntheticLambda6
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return RetroAchievementsNavFragment.onCreateView$lambda$7(this.f$0, menuItem);
            }
        });
        Chip chip12 = this.rankingButton;
        if (chip12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
            chip12 = null;
        }
        chip12.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RetroAchievementsNavFragment.onCreateView$lambda$8(popupMenu, view);
            }
        });
        final LiveData liveDataSwitchMap = Transformations.switchMap(getRetroAchievementsManager().getMyUsernameLiveData(), new Function1<String, LiveData<RetroAchievementsUserProfileEntity>>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$userProfileLiveData$1
            

            @Override // kotlin.jvm.functions.Function1
            public final LiveData<RetroAchievementsUserProfileEntity> invoke(String str4) {
                if (str4 != null) {
                    return this.this$0.getRetroAchievementsManager().getRetroAchievementsRepository().getRetroAchievementsUserProfileById(str4);
                }
                return new MutableLiveData<>((Object) null);
            }
        });
        LiveData liveDataSwitchMap2 = Transformations.switchMap(new SharedPreferenceIntLiveData(getDefaultSharedPreferences(), IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getKey(), IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getDefaultValue()), new Function1<Integer, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(final int i) {
                LiveData myUsernameLiveData = this.this$0.getRetroAchievementsManager().getMyUsernameLiveData();
                final LiveData<RetroAchievementsUserProfileEntity> liveData = liveDataSwitchMap;
                final RetroAchievementsNavFragment retroAchievementsNavFragment = this.this$0;
                return Transformations.switchMap(myUsernameLiveData, new Function1<String, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    

                    @Override // kotlin.jvm.functions.Function1
                    public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(final String str4) {
                        if (str4 == null) {
                            return new MutableLiveData<>(new Triple(Integer.valueOf(i), CollectionsKt.emptyList(), CollectionsKt.emptyList()));
                        }
                        int i2 = i;
                        if (i2 <= 1) {
                            if (i2 == 0) {
                                LiveData<RetroAchievementsUserProfileEntity> liveData2 = liveData;
                                final int i3 = i;
                                final RetroAchievementsNavFragment retroAchievementsNavFragment2 = retroAchievementsNavFragment;
                                return Transformations.switchMap(liveData2, new Function1<RetroAchievementsUserProfileEntity, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.onCreateView.viewModeAndDataLiveData.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    

                                    @Override // kotlin.jvm.functions.Function1
                                    public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
                                        if (retroAchievementsUserProfileEntity == null) {
                                            return new MutableLiveData<>(new Triple(Integer.valueOf(i3), CollectionsKt.emptyList(), CollectionsKt.emptyList()));
                                        }
                                        final List<Long> recentPlayedGameIds = retroAchievementsUserProfileEntity.getRecentPlayedGameIds();
                                        RetroAchievementsRepository retroAchievementsRepository = retroAchievementsNavFragment2.getRetroAchievementsManager().getRetroAchievementsRepository();
                                        String str5 = str4;
                                        long[] longArray = CollectionsKt.toLongArray(recentPlayedGameIds);
                                        LiveData<List<RetroAchievementsGameRecordEntity>> retroAchievementsGameRecordsByUserIdAndGameIds = retroAchievementsRepository.getRetroAchievementsGameRecordsByUserIdAndGameIds(str5, Arrays.copyOf(longArray, longArray.length));
                                        final int i4 = i3;
                                        return Transformations.switchMap(retroAchievementsGameRecordsByUserIdAndGameIds, new Function1<List<RetroAchievementsGameRecordEntity>, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.onCreateView.viewModeAndDataLiveData.1.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            

                                            @Override // kotlin.jvm.functions.Function1
                                            public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(List<RetroAchievementsGameRecordEntity> it) {
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                Integer numValueOf = Integer.valueOf(i4);
                                                final List<Long> list = recentPlayedGameIds;
                                                return new MutableLiveData<>(new Triple(numValueOf, CollectionsKt.sortedWith(it, new Comparator() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1$1$1$1$invoke$$inlined$sortedBy$1
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    @Override // java.util.Comparator
                                                    public final int compare(T t, T t2) {
                                                        return ComparisonsKt.compareValues(Integer.valueOf(list.indexOf(Long.valueOf(((RetroAchievementsGameRecordEntity) t).getGameId()))), Integer.valueOf(list.indexOf(Long.valueOf(((RetroAchievementsGameRecordEntity) t2).getGameId()))));
                                                    }
                                                }), CollectionsKt.emptyList()));
                                            }
                                        });
                                    }
                                });
                            }
                            if (i2 == 1) {
                                LiveData<RetroAchievementsUserProfileEntity> liveData3 = liveData;
                                final int i4 = i;
                                final RetroAchievementsNavFragment retroAchievementsNavFragment3 = retroAchievementsNavFragment;
                                return Transformations.switchMap(liveData3, new Function1<RetroAchievementsUserProfileEntity, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.onCreateView.viewModeAndDataLiveData.1.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    

                                    @Override // kotlin.jvm.functions.Function1
                                    public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
                                        if (retroAchievementsUserProfileEntity == null) {
                                            return new MutableLiveData<>(new Triple(Integer.valueOf(i4), CollectionsKt.emptyList(), CollectionsKt.emptyList()));
                                        }
                                        final List<Long> completionProgressGameIds = retroAchievementsUserProfileEntity.getCompletionProgressGameIds();
                                        RetroAchievementsRepository retroAchievementsRepository = retroAchievementsNavFragment3.getRetroAchievementsManager().getRetroAchievementsRepository();
                                        String str5 = str4;
                                        long[] longArray = CollectionsKt.toLongArray(completionProgressGameIds);
                                        LiveData<List<RetroAchievementsGameRecordEntity>> retroAchievementsGameRecordsByUserIdAndGameIds = retroAchievementsRepository.getRetroAchievementsGameRecordsByUserIdAndGameIds(str5, Arrays.copyOf(longArray, longArray.length));
                                        final int i5 = i4;
                                        return Transformations.switchMap(retroAchievementsGameRecordsByUserIdAndGameIds, new Function1<List<RetroAchievementsGameRecordEntity>, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.onCreateView.viewModeAndDataLiveData.1.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            

                                            @Override // kotlin.jvm.functions.Function1
                                            public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(List<RetroAchievementsGameRecordEntity> it) {
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                Integer numValueOf = Integer.valueOf(i5);
                                                final List<Long> list = completionProgressGameIds;
                                                return new MutableLiveData<>(new Triple(numValueOf, CollectionsKt.sortedWith(it, new Comparator() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1$1$2$1$invoke$$inlined$sortedBy$1
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    @Override // java.util.Comparator
                                                    public final int compare(T t, T t2) {
                                                        return ComparisonsKt.compareValues(Integer.valueOf(list.indexOf(Long.valueOf(((RetroAchievementsGameRecordEntity) t).getGameId()))), Integer.valueOf(list.indexOf(Long.valueOf(((RetroAchievementsGameRecordEntity) t2).getGameId()))));
                                                    }
                                                }), CollectionsKt.emptyList()));
                                            }
                                        });
                                    }
                                });
                            }
                        } else {
                            if (i2 == 3) {
                                LiveData<List<RetroAchievementsUserRankingEntity>> retroAchievementsUserRankingsByPerspectiveAndGranularity = retroAchievementsNavFragment.getRetroAchievementsManager().getRetroAchievementsRepository().getRetroAchievementsUserRankingsByPerspectiveAndGranularity(str4, 0);
                                final int i5 = i;
                                return Transformations.switchMap(retroAchievementsUserRankingsByPerspectiveAndGranularity, new Function1<List<RetroAchievementsUserRankingEntity>, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.onCreateView.viewModeAndDataLiveData.1.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    

                                    @Override // kotlin.jvm.functions.Function1
                                    public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(List<RetroAchievementsUserRankingEntity> it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return new MutableLiveData<>(new Triple(Integer.valueOf(i5), CollectionsKt.emptyList(), it));
                                    }
                                });
                            }
                            if (i2 == 4) {
                                LiveData<List<RetroAchievementsUserRankingEntity>> retroAchievementsUserRankingsByPerspectiveAndGranularity2 = retroAchievementsNavFragment.getRetroAchievementsManager().getRetroAchievementsRepository().getRetroAchievementsUserRankingsByPerspectiveAndGranularity(str4, 1);
                                final int i6 = i;
                                return Transformations.switchMap(retroAchievementsUserRankingsByPerspectiveAndGranularity2, new Function1<List<RetroAchievementsUserRankingEntity>, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.onCreateView.viewModeAndDataLiveData.1.1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    

                                    @Override // kotlin.jvm.functions.Function1
                                    public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(List<RetroAchievementsUserRankingEntity> it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return new MutableLiveData<>(new Triple(Integer.valueOf(i6), CollectionsKt.emptyList(), it));
                                    }
                                });
                            }
                            if (i2 == 5) {
                                LiveData<List<RetroAchievementsUserRankingEntity>> retroAchievementsUserRankingsByPerspectiveAndGranularity3 = retroAchievementsNavFragment.getRetroAchievementsManager().getRetroAchievementsRepository().getRetroAchievementsUserRankingsByPerspectiveAndGranularity(str4, 99);
                                final int i7 = i;
                                return Transformations.switchMap(retroAchievementsUserRankingsByPerspectiveAndGranularity3, new Function1<List<RetroAchievementsUserRankingEntity>, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.onCreateView.viewModeAndDataLiveData.1.1.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    

                                    @Override // kotlin.jvm.functions.Function1
                                    public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(List<RetroAchievementsUserRankingEntity> it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return new MutableLiveData<>(new Triple(Integer.valueOf(i7), CollectionsKt.emptyList(), it));
                                    }
                                });
                            }
                        }
                        return new MutableLiveData<>(new Triple(Integer.valueOf(i), CollectionsKt.emptyList(), CollectionsKt.emptyList()));
                    }
                });
            }
        });
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        booleanRef2.element = true;
        liveDataSwitchMap2.observe(getViewLifecycleOwner(), new RetroAchievementsNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Triple<? extends Integer, ? extends List<? extends RetroAchievementsGameRecordEntity>, ? extends List<? extends RetroAchievementsUserRankingEntity>>, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.onCreateView.9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Triple<? extends Integer, ? extends List<? extends RetroAchievementsGameRecordEntity>, ? extends List<? extends RetroAchievementsUserRankingEntity>> triple) {
                invoke2((Triple<Integer, ? extends List<RetroAchievementsGameRecordEntity>, ? extends List<RetroAchievementsUserRankingEntity>>) triple);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Triple<Integer, ? extends List<RetroAchievementsGameRecordEntity>, ? extends List<RetroAchievementsUserRankingEntity>> triple) {
                int iIntValue = triple.getFirst().intValue();
                List<RetroAchievementsGameRecordEntity> second = triple.getSecond();
                List<RetroAchievementsUserRankingEntity> third = triple.getThird();
                DaijishouRecyclerView daijishouRecyclerView3 = null;
                if (iIntValue <= 2) {
                    DaijishouRecyclerView daijishouRecyclerView4 = RetroAchievementsNavFragment.this.recyclerView;
                    if (daijishouRecyclerView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        daijishouRecyclerView4 = null;
                    }
                    if (!(daijishouRecyclerView4.getAdapter() instanceof GameListAdapter)) {
                        DaijishouRecyclerView daijishouRecyclerView5 = RetroAchievementsNavFragment.this.recyclerView;
                        if (daijishouRecyclerView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            daijishouRecyclerView5 = null;
                        }
                        GameListAdapter gameListAdapter = RetroAchievementsNavFragment.this.recyclerViewGameListAdapter;
                        if (gameListAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewGameListAdapter");
                            gameListAdapter = null;
                        }
                        daijishouRecyclerView5.setAdapter(gameListAdapter);
                    }
                    if (iIntValue == 0) {
                        Chip chip13 = RetroAchievementsNavFragment.this.recentButton;
                        if (chip13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                            chip13 = null;
                        }
                        chip13.setChipStrokeWidth(RetroAchievementsNavFragment.this.chipStrokeWidth);
                        Chip chip14 = RetroAchievementsNavFragment.this.completionButton;
                        if (chip14 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("completionButton");
                            chip14 = null;
                        }
                        chip14.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                        Chip chip15 = RetroAchievementsNavFragment.this.awardsButton;
                        if (chip15 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
                            chip15 = null;
                        }
                        chip15.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                        Chip chip16 = RetroAchievementsNavFragment.this.rankingButton;
                        if (chip16 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                            chip16 = null;
                        }
                        chip16.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                        DaijishouRecyclerView daijishouRecyclerView6 = RetroAchievementsNavFragment.this.recyclerView;
                        if (daijishouRecyclerView6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            daijishouRecyclerView6 = null;
                        }
                        Chip chip17 = RetroAchievementsNavFragment.this.recentButton;
                        if (chip17 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                            chip17 = null;
                        }
                        daijishouRecyclerView6.setNextFocusUpId(chip17.getId());
                    } else if (iIntValue == 1) {
                        Chip chip18 = RetroAchievementsNavFragment.this.recentButton;
                        if (chip18 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                            chip18 = null;
                        }
                        chip18.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                        Chip chip19 = RetroAchievementsNavFragment.this.completionButton;
                        if (chip19 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("completionButton");
                            chip19 = null;
                        }
                        chip19.setChipStrokeWidth(RetroAchievementsNavFragment.this.chipStrokeWidth);
                        Chip chip20 = RetroAchievementsNavFragment.this.awardsButton;
                        if (chip20 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
                            chip20 = null;
                        }
                        chip20.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                        Chip chip21 = RetroAchievementsNavFragment.this.rankingButton;
                        if (chip21 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                            chip21 = null;
                        }
                        chip21.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                        DaijishouRecyclerView daijishouRecyclerView7 = RetroAchievementsNavFragment.this.recyclerView;
                        if (daijishouRecyclerView7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            daijishouRecyclerView7 = null;
                        }
                        Chip chip22 = RetroAchievementsNavFragment.this.completionButton;
                        if (chip22 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("completionButton");
                            chip22 = null;
                        }
                        daijishouRecyclerView7.setNextFocusUpId(chip22.getId());
                    } else if (iIntValue == 2) {
                        Chip chip23 = RetroAchievementsNavFragment.this.recentButton;
                        if (chip23 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                            chip23 = null;
                        }
                        chip23.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                        Chip chip24 = RetroAchievementsNavFragment.this.completionButton;
                        if (chip24 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("completionButton");
                            chip24 = null;
                        }
                        chip24.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                        Chip chip25 = RetroAchievementsNavFragment.this.awardsButton;
                        if (chip25 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
                            chip25 = null;
                        }
                        chip25.setChipStrokeWidth(RetroAchievementsNavFragment.this.chipStrokeWidth);
                        Chip chip26 = RetroAchievementsNavFragment.this.rankingButton;
                        if (chip26 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                            chip26 = null;
                        }
                        chip26.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                        DaijishouRecyclerView daijishouRecyclerView8 = RetroAchievementsNavFragment.this.recyclerView;
                        if (daijishouRecyclerView8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            daijishouRecyclerView8 = null;
                        }
                        Chip chip27 = RetroAchievementsNavFragment.this.awardsButton;
                        if (chip27 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
                            chip27 = null;
                        }
                        daijishouRecyclerView8.setNextFocusUpId(chip27.getId());
                    }
                    DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new RetroAchievementsGameRecordDiffUtilCallback(RetroAchievementsNavFragment.this.retroAchievementsGameRecordList, second));
                    Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
                    RetroAchievementsNavFragment.this.retroAchievementsGameRecordList.clear();
                    RetroAchievementsNavFragment.this.retroAchievementsGameRecordList.addAll(second);
                    GameListAdapter gameListAdapter2 = RetroAchievementsNavFragment.this.recyclerViewGameListAdapter;
                    if (gameListAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewGameListAdapter");
                        gameListAdapter2 = null;
                    }
                    diffResultCalculateDiff.dispatchUpdatesTo(gameListAdapter2);
                    if (booleanRef2.element || booleanRef.element || intRef.element != iIntValue) {
                        intRef.element = iIntValue;
                        GameListAdapter gameListAdapter3 = RetroAchievementsNavFragment.this.recyclerViewGameListAdapter;
                        if (gameListAdapter3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewGameListAdapter");
                            gameListAdapter3 = null;
                        }
                        gameListAdapter3.selectPosition(-1);
                        DaijishouRecyclerView daijishouRecyclerView9 = RetroAchievementsNavFragment.this.recyclerView;
                        if (daijishouRecyclerView9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            daijishouRecyclerView9 = null;
                        }
                        daijishouRecyclerView9.clearFocus();
                        DaijishouRecyclerView daijishouRecyclerView10 = RetroAchievementsNavFragment.this.recyclerView;
                        if (daijishouRecyclerView10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        } else {
                            daijishouRecyclerView3 = daijishouRecyclerView10;
                        }
                        daijishouRecyclerView3.scrollToPosition(0);
                        booleanRef.element = false;
                        booleanRef2.element = false;
                        return;
                    }
                    return;
                }
                DaijishouRecyclerView daijishouRecyclerView11 = RetroAchievementsNavFragment.this.recyclerView;
                if (daijishouRecyclerView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    daijishouRecyclerView11 = null;
                }
                if (!(daijishouRecyclerView11.getAdapter() instanceof RankingUserProfileListAdapter)) {
                    DaijishouRecyclerView daijishouRecyclerView12 = RetroAchievementsNavFragment.this.recyclerView;
                    if (daijishouRecyclerView12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        daijishouRecyclerView12 = null;
                    }
                    RankingUserProfileListAdapter rankingUserProfileListAdapter = RetroAchievementsNavFragment.this.recyclerViewRankingUserProfileListAdapter;
                    if (rankingUserProfileListAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewRankingUserProfileListAdapter");
                        rankingUserProfileListAdapter = null;
                    }
                    daijishouRecyclerView12.setAdapter(rankingUserProfileListAdapter);
                }
                RetroAchievementsNavFragment.this.retroAchievementsUserRankingList.clear();
                if (iIntValue == 3) {
                    RetroAchievementsNavFragment.this.retroAchievementsUserRankingList.addAll(third);
                    Chip chip28 = RetroAchievementsNavFragment.this.recentButton;
                    if (chip28 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                        chip28 = null;
                    }
                    chip28.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                    Chip chip29 = RetroAchievementsNavFragment.this.completionButton;
                    if (chip29 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("completionButton");
                        chip29 = null;
                    }
                    chip29.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                    Chip chip30 = RetroAchievementsNavFragment.this.awardsButton;
                    if (chip30 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
                        chip30 = null;
                    }
                    chip30.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                    Chip chip31 = RetroAchievementsNavFragment.this.rankingButton;
                    if (chip31 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                        chip31 = null;
                    }
                    chip31.setChipStrokeWidth(RetroAchievementsNavFragment.this.chipStrokeWidth);
                    DaijishouRecyclerView daijishouRecyclerView13 = RetroAchievementsNavFragment.this.recyclerView;
                    if (daijishouRecyclerView13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        daijishouRecyclerView13 = null;
                    }
                    Chip chip32 = RetroAchievementsNavFragment.this.rankingButton;
                    if (chip32 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                        chip32 = null;
                    }
                    daijishouRecyclerView13.setNextFocusUpId(chip32.getId());
                } else if (iIntValue == 4) {
                    RetroAchievementsNavFragment.this.retroAchievementsUserRankingList.addAll(third);
                    Chip chip33 = RetroAchievementsNavFragment.this.recentButton;
                    if (chip33 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                        chip33 = null;
                    }
                    chip33.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                    Chip chip34 = RetroAchievementsNavFragment.this.completionButton;
                    if (chip34 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("completionButton");
                        chip34 = null;
                    }
                    chip34.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                    Chip chip35 = RetroAchievementsNavFragment.this.awardsButton;
                    if (chip35 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
                        chip35 = null;
                    }
                    chip35.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                    Chip chip36 = RetroAchievementsNavFragment.this.rankingButton;
                    if (chip36 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                        chip36 = null;
                    }
                    chip36.setChipStrokeWidth(RetroAchievementsNavFragment.this.chipStrokeWidth);
                    DaijishouRecyclerView daijishouRecyclerView14 = RetroAchievementsNavFragment.this.recyclerView;
                    if (daijishouRecyclerView14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        daijishouRecyclerView14 = null;
                    }
                    Chip chip37 = RetroAchievementsNavFragment.this.rankingButton;
                    if (chip37 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                        chip37 = null;
                    }
                    daijishouRecyclerView14.setNextFocusUpId(chip37.getId());
                } else if (iIntValue == 5) {
                    RetroAchievementsNavFragment.this.retroAchievementsUserRankingList.addAll(third);
                    Chip chip38 = RetroAchievementsNavFragment.this.recentButton;
                    if (chip38 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                        chip38 = null;
                    }
                    chip38.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                    Chip chip39 = RetroAchievementsNavFragment.this.completionButton;
                    if (chip39 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("completionButton");
                        chip39 = null;
                    }
                    chip39.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                    Chip chip40 = RetroAchievementsNavFragment.this.awardsButton;
                    if (chip40 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
                        chip40 = null;
                    }
                    chip40.setChipStrokeWidth(DefinitionKt.NO_Float_VALUE);
                    Chip chip41 = RetroAchievementsNavFragment.this.rankingButton;
                    if (chip41 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                        chip41 = null;
                    }
                    chip41.setChipStrokeWidth(RetroAchievementsNavFragment.this.chipStrokeWidth);
                    DaijishouRecyclerView daijishouRecyclerView15 = RetroAchievementsNavFragment.this.recyclerView;
                    if (daijishouRecyclerView15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        daijishouRecyclerView15 = null;
                    }
                    Chip chip42 = RetroAchievementsNavFragment.this.rankingButton;
                    if (chip42 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                        chip42 = null;
                    }
                    daijishouRecyclerView15.setNextFocusUpId(chip42.getId());
                }
                DaijishouRecyclerView daijishouRecyclerView16 = RetroAchievementsNavFragment.this.recyclerView;
                if (daijishouRecyclerView16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    daijishouRecyclerView3 = daijishouRecyclerView16;
                }
                RecyclerView.Adapter adapter = daijishouRecyclerView3.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
            }
        }));
        getRetroAchievementsManager().getRefreshingUsernamesLiveData().observe(getViewLifecycleOwner(), new RetroAchievementsNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends String>, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.onCreateView.10
            

            /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$10$1, reason: invalid class name */
            /* JADX INFO: compiled from: RetroAchievementsNavFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$10$1", f = "RetroAchievementsNavFragment.kt", i = {}, l = {651, 653}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ List<String> $it;
                int label;
                final /* synthetic */ RetroAchievementsNavFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(RetroAchievementsNavFragment retroAchievementsNavFragment, List<String> list, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = retroAchievementsNavFragment;
                    this.$it = list;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$it, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
                
                    if (kotlinx.coroutines.BuildersKt.withContext(r6, r1, r5) == r0) goto L19;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                    /*
                        r5 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r5.label
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L1e
                        if (r1 == r3) goto L1a
                        if (r1 != r2) goto L12
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L58
                    L12:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r0)
                        throw r6
                    L1a:
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L33
                    L1e:
                        kotlin.ResultKt.throwOnFailure(r6)
                        com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment r6 = r5.this$0
                        com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager r6 = com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.access$getRetroAchievementsManager(r6)
                        r1 = r5
                        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                        r5.label = r3
                        java.lang.Object r6 = r6.getMyRetroAchievementsUsername(r1)
                        if (r6 != r0) goto L33
                        goto L57
                    L33:
                        java.lang.String r6 = (java.lang.String) r6
                        if (r6 == 0) goto L58
                        java.util.List<java.lang.String> r1 = r5.$it
                        com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment r3 = r5.this$0
                        boolean r6 = r1.contains(r6)
                        if (r6 == 0) goto L58
                        kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getMain()
                        kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
                        com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$10$1$1$1 r1 = new com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$10$1$1$1
                        r4 = 0
                        r1.<init>(r3, r4)
                        kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                        r5.label = r2
                        java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r1, r5)
                        if (r6 != r0) goto L58
                    L57:
                        return r0
                    L58:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.AnonymousClass10.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(RetroAchievementsNavFragment.this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(RetroAchievementsNavFragment.this, list, null), 2, (Object) null);
            }
        }));
        liveDataSwitchMap.observe(getViewLifecycleOwner(), new RetroAchievementsNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<RetroAchievementsUserProfileEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.onCreateView.11
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
                invoke2(retroAchievementsUserProfileEntity);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
                if (retroAchievementsUserProfileEntity == null) {
                    TextView textView = RetroAchievementsNavFragment.this.title;
                    String str4 = null;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("title");
                        textView = null;
                    }
                    String str5 = RetroAchievementsNavFragment.this.pleaseLoginString;
                    if (str5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pleaseLoginString");
                        str5 = null;
                    }
                    textView.setText(str5);
                    TextView textView2 = RetroAchievementsNavFragment.this.description;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("description");
                        textView2 = null;
                    }
                    textView2.setText("RetroAchievements.org");
                    TextView textView3 = RetroAchievementsNavFragment.this.motto;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("motto");
                        textView3 = null;
                    }
                    String str6 = RetroAchievementsNavFragment.this.noMottoString;
                    if (str6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noMottoString");
                    } else {
                        str4 = str6;
                    }
                    textView3.setText(str4);
                    return;
                }
                RetroAchievementsNavFragment.this.renderUserProfile(retroAchievementsUserProfileEntity);
            }
        }));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass12(null), 2, (Object) null);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2(RetroAchievementsNavFragment this$0, View view, int i, int i2, int i3, int i4) {
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
    public static final void onCreateView$lambda$3(Ref.BooleanRef refreshButtonClicked, RetroAchievementsNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(refreshButtonClicked, "$refreshButtonClicked");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        refreshButtonClicked.element = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this$0), Dispatchers.getIO(), (CoroutineStart) null, new RetroAchievementsNavFragment$onCreateView$3$1(this$0, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$4(RetroAchievementsNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DaijishouRecyclerView daijishouRecyclerView = null;
        if (this$0.getDefaultSharedPreferences().getInt(IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getKey(), IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getDefaultValue()) == 0) {
            DaijishouRecyclerView daijishouRecyclerView2 = this$0.recyclerView;
            if (daijishouRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                daijishouRecyclerView = daijishouRecyclerView2;
            }
            daijishouRecyclerView.smoothScrollToPosition(0);
            return;
        }
        DaijishouRecyclerView daijishouRecyclerView3 = this$0.recyclerView;
        if (daijishouRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            daijishouRecyclerView = daijishouRecyclerView3;
        }
        daijishouRecyclerView.scrollToPosition(0);
        this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getKey(), IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getDefaultValue()).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5(RetroAchievementsNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DaijishouRecyclerView daijishouRecyclerView = null;
        if (this$0.getDefaultSharedPreferences().getInt(IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getKey(), IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getDefaultValue()) == 1) {
            DaijishouRecyclerView daijishouRecyclerView2 = this$0.recyclerView;
            if (daijishouRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                daijishouRecyclerView = daijishouRecyclerView2;
            }
            daijishouRecyclerView.smoothScrollToPosition(0);
            return;
        }
        DaijishouRecyclerView daijishouRecyclerView3 = this$0.recyclerView;
        if (daijishouRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            daijishouRecyclerView = daijishouRecyclerView3;
        }
        daijishouRecyclerView.scrollToPosition(0);
        this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getKey(), 1).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6(RetroAchievementsNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DaijishouRecyclerView daijishouRecyclerView = null;
        if (this$0.getDefaultSharedPreferences().getInt(IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getKey(), IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getDefaultValue()) == 2) {
            DaijishouRecyclerView daijishouRecyclerView2 = this$0.recyclerView;
            if (daijishouRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                daijishouRecyclerView = daijishouRecyclerView2;
            }
            daijishouRecyclerView.smoothScrollToPosition(0);
            return;
        }
        DaijishouRecyclerView daijishouRecyclerView3 = this$0.recyclerView;
        if (daijishouRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            daijishouRecyclerView = daijishouRecyclerView3;
        }
        daijishouRecyclerView.scrollToPosition(0);
        this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getKey(), 2).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$7(RetroAchievementsNavFragment this$0, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DaijishouRecyclerView daijishouRecyclerView = null;
        if (this$0.getDefaultSharedPreferences().getInt(IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getKey(), IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getDefaultValue()) == menuItem.getItemId()) {
            DaijishouRecyclerView daijishouRecyclerView2 = this$0.recyclerView;
            if (daijishouRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                daijishouRecyclerView = daijishouRecyclerView2;
            }
            daijishouRecyclerView.smoothScrollToPosition(0);
        } else {
            DaijishouRecyclerView daijishouRecyclerView3 = this$0.recyclerView;
            if (daijishouRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                daijishouRecyclerView = daijishouRecyclerView3;
            }
            daijishouRecyclerView.scrollToPosition(0);
            this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getKey(), menuItem.getItemId()).apply();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$8(PopupMenu popupMenu, View view) {
        Intrinsics.checkNotNullParameter(popupMenu, "$popupMenu");
        popupMenu.show();
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$12, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$12", f = "RetroAchievementsNavFragment.kt", i = {}, l = {673, 674}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass12 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass12(Continuation<? super AnonymousClass12> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsNavFragment.this.new AnonymousClass12(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass12) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
        
            if (r1.refreshRetroAchievementsUserProfileDataIfExpired(r5, r4) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r5)
                goto L46
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L33
            L1e:
                kotlin.ResultKt.throwOnFailure(r5)
                com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment r5 = com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.this
                com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager r5 = com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.access$getRetroAchievementsManager(r5)
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r3
                java.lang.Object r5 = r5.getMyRetroAchievementsUsername(r1)
                if (r5 != r0) goto L33
                goto L45
            L33:
                java.lang.String r5 = (java.lang.String) r5
                if (r5 == 0) goto L46
                com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment r1 = com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.this
                com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager r1 = com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.access$getRetroAchievementsManager(r1)
                r4.label = r2
                java.lang.Object r5 = r1.refreshRetroAchievementsUserProfileDataIfExpired(r5, r4)
                if (r5 != r0) goto L46
            L45:
                return r0
            L46:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.AnonymousClass12.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public void onStart() {
        super.onStart();
        Chip chip = this.refreshButton;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
            chip = null;
        }
        chip.requestFocus();
    }
}
