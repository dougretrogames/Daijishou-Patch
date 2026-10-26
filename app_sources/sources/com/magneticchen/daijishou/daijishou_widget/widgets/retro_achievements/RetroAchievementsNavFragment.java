package com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements;

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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
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
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.application_data.IntPreference;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouLinearLayoutManager;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetNavFragment;
import com.magneticchen.daijishou.dialog_fragments.RetroAchievementsGameDialogFragment;
import com.magneticchen.daijishou.live_data.SharedPreferenceIntLiveData;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserProfileEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingEntity;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* INFO: compiled from: RetroAchievementsNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 I2\u00020\u0001:\u0003IJKB\u0005¢\u0006\u0002\u0010\u0002J\b\u00109\u001a\u00020*H\u0016J\u0012\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J&\u0010>\u001a\u0004\u0018\u00010\u00102\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010C\u001a\u00020;H\u0016J\u0012\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020*H\u0002J\u0010\u0010F\u001a\u00020;2\u0006\u0010G\u001a\u00020HH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00060&R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u00060(R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetNavFragment;", "()V", "achievementCompletedFormatString", "", "achievementPointsFormatString", "allTimeString", "awardsButton", "Lcom/google/android/material/chip/Chip;", "chipStrokeWidth", "", "completionButton", "dailyString", "description", "Landroid/widget/TextView;", "divider", "Landroid/view/View;", "loadingDataString", "loadingString", "loadingUsernameString", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "model$delegate", "Lkotlin/Lazy;", "motto", "nOfMCompletedAbbreviationFormatString", "nOfMFormatString", "noMottoString", "placeHolder", "Landroid/widget/ImageView;", "pleaseLoginString", "rankingButton", "recentButton", "recyclerView", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView;", "recyclerViewGameListAdapter", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$GameListAdapter;", "recyclerViewRankingUserProfileListAdapter", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$RankingUserProfileListAdapter;", "refocusOnScrolledToTop", "", "refreshButton", "retroAchievementsButton", "retroAchievementsGameRecordList", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "retroAchievementsUserRankingList", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserRankingEntity;", "scrollView", "Landroid/widget/HorizontalScrollView;", "scrollingOnBackPressed", "thumbnail", "title", "userAchievementDescriptionFormatString", "weeklyString", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "refreshData", "useCached", "renderUserProfile", "userProfile", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileEntity;", "Companion", "GameListAdapter", "RankingUserProfileListAdapter", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsNavFragment extends WidgetNavFragment {
    public static final int BEATEN_VIEW_MODE = 2;
    public static final int COMPLETION_VIEW_MODE = 1;

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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
    public TextView description;
    private View divider;
    public String loadingDataString;
    private String loadingString;
    private String loadingUsernameString;

    /* INFO: renamed from: model$delegate, reason: from kotlin metadata */
    private final Lazy model;
    public TextView motto;
    private String nOfMCompletedAbbreviationFormatString;
    private String nOfMFormatString;
    public String noMottoString;
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

    private final void refreshData(boolean useCached) {
    }

    public RetroAchievementsNavFragment() {
        RetroAchievementsNavFragment retroAchievementsNavFragment = this;
        this.model = FragmentViewModelLazyKt.createViewModelLazy(retroAchievementsNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new RetroAchievementsNavFragment$special$$inlined$activityViewModels$default$1(retroAchievementsNavFragment), new RetroAchievementsNavFragment$special$$inlined$activityViewModels$default$2(null, retroAchievementsNavFragment), new RetroAchievementsNavFragment$special$$inlined$activityViewModels$default$3(retroAchievementsNavFragment));
    }

    /* INFO: compiled from: RetroAchievementsNavFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$Companion;", "", "()V", "BEATEN_VIEW_MODE", "", "COMPLETION_VIEW_MODE", "RANKING_ALL_TIME_VIEW_MODE", "RANKING_DAILY_VIEW_MODE", "RANKING_WEEKLY_VIEW_MODE", "RECENT_VIEW_MODE", "typeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "newInstance", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* WARN: Code duplicated, block: B:11:0x0020  */
    /* WARN: Code duplicated, block: B:14:0x002a  */
    /* WARN: Code duplicated, block: B:16:0x002e  */
    /* WARN: Code duplicated, block: B:42:0x007f  */
    /* WARN: Code duplicated, block: B:45:0x008a  */
    /* WARN: Code duplicated, block: B:48:0x0095  */
    /* WARN: Code duplicated, block: B:49:0x0099  */
    /* WARN: Code duplicated, block: B:9:0x001c  */
    /* WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
    
        if (r0.getScrollX() == 0) goto L19;
     */
    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onBackPressed() {
        DaijishouRecyclerView daijishouRecyclerView = this.recyclerView;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView = null;
        }
        int scrollState = daijishouRecyclerView.getScrollState();
        if ((this.scrollingOnBackPressed && scrollState == 2) || (daijishouRecyclerView.computeVerticalScrollOffset() == 0 && (this.scrollView != null ? this.scrollView : null) != null && (this.scrollView.getScrollX() == 0))) {
            DaijishouRecyclerView daijishouRecyclerView2 = this.recyclerView;
            if (daijishouRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView2 = null;
            }
            daijishouRecyclerView2.scrollToPosition(0);
            android.widget.HorizontalScrollView horizontalScrollView = this.scrollView;
            if (horizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollView");
                horizontalScrollView = null;
            }
            horizontalScrollView.scrollTo(0, 0);
            Chip chip = this.refreshButton;
            if (chip == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
                chip = null;
            }
            if (chip.isFocused()) {
                return true;
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
            return !chip3.isFocused();
        }
        this.scrollingOnBackPressed = true;
        this.refocusOnScrolledToTop = true;
        Chip chip4 = this.refreshButton;
        if (chip4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
            chip4 = null;
        }
        chip4.requestFocus();
        DaijishouRecyclerView daijishouRecyclerView3 = this.recyclerView;
        if (daijishouRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView3 = null;
        }
        daijishouRecyclerView3.smoothScrollToPosition(0);
        android.widget.HorizontalScrollView horizontalScrollView2 = this.scrollView;
        if (horizontalScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            horizontalScrollView2 = null;
        }
        horizontalScrollView2.smoothScrollTo(0, 0);
        return false;
    }

    /* INFO: Access modifiers changed from: private */
    public final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model.getValue();
    }

    static /* synthetic */ void refreshData$default(RetroAchievementsNavFragment retroAchievementsNavFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        retroAchievementsNavFragment.refreshData(z);
    }

    /* INFO: Access modifiers changed from: private */
    public final void renderUserProfile(RetroAchievementsUserProfileEntity userProfile) {
        String str;
        TextView textView = this.title;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        textView.setText(userProfile.getId());
        TextView textView2 = this.motto;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("motto");
            textView2 = null;
        }
        if (userProfile.getMotto() != null) {
            str = "“ " + userProfile.getMotto() + " ”";
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
        String str3 = String.format(str2, Arrays.copyOf(new Object[]{Integer.valueOf(userProfile.getHardcorePoints() + userProfile.getSoftcorePoints()), Integer.valueOf(userProfile.getHardcorePoints()), Integer.valueOf(userProfile.getSoftcorePoints()), Float.valueOf(100 * userProfile.getAverageCompletionPercentage())}, 4));
        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
        textView3.setText(str3);
        Chip chip = this.retroAchievementsButton;
        if (chip == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsButton");
            chip = null;
        }
        chip.setOnClickListener(new RetroAchievementsNavFragment$$ExternalSyntheticLambda7(userProfile, this));
        if (userProfile.getImageUrl() == null) {
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
        RequestBuilder requestBuilderListener = Glide.with(this).load((Object) userProfile.getImageUrl()).dontAnimate().listener(new AnonymousClass2());
        ImageView imageView4 = this.thumbnail;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
        } else {
            imageView = imageView4;
        }
        requestBuilderListener.into(imageView);
    }

    /* INFO: Access modifiers changed from: private */
    public static final void renderUserProfile$lambda$1(RetroAchievementsUserProfileEntity userProfile, RetroAchievementsNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(userProfile, "$userProfile");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String url = userProfile.getUrl();
        if (url != null) {
            this$0.requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$renderUserProfile$2, reason: invalid class name */
    /* INFO: compiled from: RetroAchievementsNavFragment.kt */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J2\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J8\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"com/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$renderUserProfile$2", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", TypedValues.AttributesType.S_TARGET, "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass2 implements RequestListener<Drawable> {
        AnonymousClass2() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
            Intrinsics.checkNotNullParameter(target, "target");
            ImageView imageView = RetroAchievementsNavFragment.this.placeHolder;
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
            ImageView imageView = RetroAchievementsNavFragment.this.placeHolder;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
                imageView = null;
            }
            imageView.setVisibility(8);
            return false;
        }
    }

    /* INFO: compiled from: RetroAchievementsNavFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\n0\u000bR\u00060\u0000R\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$RankingUserProfileListAdapter;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserRankingEntity;", "retroAchievementsUserRankingList", "", "(Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment;Ljava/util/List;)V", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$RankingUserProfileListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment;", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class RankingUserProfileListAdapter extends DaijishouRecyclerView.Adapter<RetroAchievementsUserRankingEntity> {
        private final List<RetroAchievementsUserRankingEntity> retroAchievementsUserRankingList;
        final /* synthetic */ RetroAchievementsNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RankingUserProfileListAdapter(RetroAchievementsNavFragment retroAchievementsNavFragment, List<RetroAchievementsUserRankingEntity> retroAchievementsUserRankingList) {
            super(retroAchievementsUserRankingList, true, false, 4, null);
            Intrinsics.checkNotNullParameter(retroAchievementsUserRankingList, "retroAchievementsUserRankingList");
            this.this$0 = retroAchievementsNavFragment;
            this.retroAchievementsUserRankingList = retroAchievementsUserRankingList;
            setEnforceSelectionInSelectableMode(false);
        }

        /* INFO: compiled from: RetroAchievementsNavFragment.kt */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$RankingUserProfileListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserRankingEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$RankingUserProfileListAdapter;Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "pointsSubtitle", "Landroid/widget/TextView;", "title", "onBind", "", "position", "", "RetroAchievementsUserRanking", "onClick", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<RetroAchievementsUserRankingEntity>.ViewHolder {
            private final ImageView imageView;
            private final TextView pointsSubtitle;
            final /* synthetic */ RankingUserProfileListAdapter this$0;
            private final TextView title;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
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

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public boolean onClick() {
                String url = ((RetroAchievementsUserRankingEntity) this.this$0.retroAchievementsUserRankingList.get(getAbsoluteAdapterPosition())).getUrl();
                if (url != null) {
                    RetroAchievementsNavFragment retroAchievementsNavFragment = this.this$0.this$0;
                    retroAchievementsNavFragment.requireActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                }
                return super.onClick();
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int position, RetroAchievementsUserRankingEntity RetroAchievementsUserRanking) {
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
                    Glide.with(this.this$0.this$0).load((Object) RetroAchievementsUserRanking.getImageUrl()).transition(DrawableTransitionOptions.withCrossFade()).into(this.imageView);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            return this.retroAchievementsUserRankingList.get(position).getId();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_retro_achievements_ranking_user_profile, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    /* INFO: compiled from: RetroAchievementsNavFragment.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\n0\u001aR\u00060\u0000R\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$GameListAdapter;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "retroAchievementsGameRecordList", "", "(Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment;Ljava/util/List;)V", "enforceSelectionInSelectableMode", "", "getEnforceSelectionInSelectableMode", "()Z", "setEnforceSelectionInSelectableMode", "(Z)V", "getGlidePreloadRequestBuilderOfImageView", "Lkotlin/Function1;", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getGlidePreloadRequestBuilderOfSystemIcon", "imageViewGlideViewPreloadSizeProvider", "Lcom/bumptech/glide/util/ViewPreloadSizeProvider;", "systemIconGlideViewPreloadSizeProvider", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$GameListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment;", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class GameListAdapter extends DaijishouRecyclerView.Adapter<RetroAchievementsGameRecordEntity> {
        private boolean enforceSelectionInSelectableMode;
        private final Function1<RetroAchievementsGameRecordEntity, RequestBuilder<Drawable>> getGlidePreloadRequestBuilderOfImageView;
        private final Function1<RetroAchievementsGameRecordEntity, RequestBuilder<Drawable>> getGlidePreloadRequestBuilderOfSystemIcon;
        private final ViewPreloadSizeProvider<RetroAchievementsGameRecordEntity> imageViewGlideViewPreloadSizeProvider;
        private final List<RetroAchievementsGameRecordEntity> retroAchievementsGameRecordList;
        private final ViewPreloadSizeProvider<RetroAchievementsGameRecordEntity> systemIconGlideViewPreloadSizeProvider;
        final /* synthetic */ RetroAchievementsNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GameListAdapter(RetroAchievementsNavFragment retroAchievementsNavFragment, List<RetroAchievementsGameRecordEntity> retroAchievementsGameRecordList) {
            super(retroAchievementsGameRecordList, true, false, 4, null);
            Intrinsics.checkNotNullParameter(retroAchievementsGameRecordList, "retroAchievementsGameRecordList");
            this.this$0 = retroAchievementsNavFragment;
            this.retroAchievementsGameRecordList = retroAchievementsGameRecordList;
            RetroAchievementsNavFragment$GameListAdapter$getGlidePreloadRequestBuilderOfImageView$1 retroAchievementsNavFragment$GameListAdapter$getGlidePreloadRequestBuilderOfImageView$1 = new RetroAchievementsNavFragment$GameListAdapter$getGlidePreloadRequestBuilderOfImageView$1(retroAchievementsNavFragment);
            this.getGlidePreloadRequestBuilderOfImageView = retroAchievementsNavFragment$GameListAdapter$getGlidePreloadRequestBuilderOfImageView$1;
            RetroAchievementsNavFragment$GameListAdapter$getGlidePreloadRequestBuilderOfSystemIcon$1 retroAchievementsNavFragment$GameListAdapter$getGlidePreloadRequestBuilderOfSystemIcon$1 = new RetroAchievementsNavFragment$GameListAdapter$getGlidePreloadRequestBuilderOfSystemIcon$1(retroAchievementsNavFragment);
            this.getGlidePreloadRequestBuilderOfSystemIcon = retroAchievementsNavFragment$GameListAdapter$getGlidePreloadRequestBuilderOfSystemIcon$1;
            GameListAdapter gameListAdapter = this;
            this.imageViewGlideViewPreloadSizeProvider = DaijishouRecyclerView.Adapter.addGlidePreloaderBuilderCreator$default(gameListAdapter, retroAchievementsNavFragment$GameListAdapter$getGlidePreloadRequestBuilderOfImageView$1, 0, 2, null);
            this.systemIconGlideViewPreloadSizeProvider = DaijishouRecyclerView.Adapter.addGlidePreloaderBuilderCreator$default(gameListAdapter, retroAchievementsNavFragment$GameListAdapter$getGlidePreloadRequestBuilderOfSystemIcon$1, 0, 2, null);
        }

        @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter
        public boolean getEnforceSelectionInSelectableMode() {
            return this.enforceSelectionInSelectableMode;
        }

        @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter
        public void setEnforceSelectionInSelectableMode(boolean z) {
            this.enforceSelectionInSelectableMode = z;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            return this.retroAchievementsGameRecordList.get(position).getId();
        }

        /* INFO: compiled from: RetroAchievementsNavFragment.kt */
        @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0018\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$GameListAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$GameListAdapter;Landroid/view/View;)V", "description", "Landroid/widget/TextView;", "gameId", "", "imageView", "Landroid/widget/ImageView;", "linearProgressIndicator", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "pointsSubtitle", "progress", "", "systemIcon", "title", "loadGameData", "", "retroAchievementsGameRecord", "onBind", "position", "", "item", "onClick", "", "onFocus", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<RetroAchievementsGameRecordEntity>.ViewHolder {
            private final TextView description;
            long gameId;
            private final ImageView imageView;
            private final LinearProgressIndicator linearProgressIndicator;
            private final TextView pointsSubtitle;
            private float progress;
            private final ImageView systemIcon;
            final /* synthetic */ GameListAdapter this$0;
            private final TextView title;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                View viewFindViewById3 = itemView.findViewById(R.id.list_item_retro_achievements_game_linear_progress_indicator);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                this.linearProgressIndicator = (LinearProgressIndicator) viewFindViewById3;
                View viewFindViewById4 = itemView.findViewById(R.id.list_item_retro_achievements_game_system_icon);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
                ImageView imageView2 = (ImageView) viewFindViewById4;
                this.systemIcon = imageView2;
                View viewFindViewById5 = itemView.findViewById(R.id.list_item_retro_achievements_game_points_subtitle);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
                this.pointsSubtitle = (TextView) viewFindViewById5;
                View viewFindViewById6 = itemView.findViewById(R.id.list_item_retro_achievements_game_progress_description);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
                this.description = (TextView) viewFindViewById6;
                gameListAdapter.setEnforceSelectionInSelectableMode(false);
                gameListAdapter.imageViewGlideViewPreloadSizeProvider.setView(imageView);
                gameListAdapter.systemIconGlideViewPreloadSizeProvider.setView(imageView2);
                gameListAdapter.setKeepSelectedItemFocusedInSelectableMode(false);
            }

            private final void loadGameData(RetroAchievementsGameRecordEntity retroAchievementsGameRecord) {
                this.title.setText(this.this$0.this$0.getDaijishouLibrary().prettifyTitleWithPreferences(String.valueOf(retroAchievementsGameRecord.getName())));
                TextView textView = this.pointsSubtitle;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = this.this$0.this$0.nOfMCompletedAbbreviationFormatString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nOfMCompletedAbbreviationFormatString");
                    str = null;
                }
                String str2 = String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(retroAchievementsGameRecord.getUnlockedAchievementsCount()), Integer.valueOf(retroAchievementsGameRecord.getAchievementsCount())}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                textView.setText(str2);
                float unlockedAchievementsCount = ((float) retroAchievementsGameRecord.getAchievementsCount()) != 0.0f ? (retroAchievementsGameRecord.getUnlockedAchievementsCount() * 100.0f) / retroAchievementsGameRecord.getAchievementsCount() : 0.0f;
                this.progress = unlockedAchievementsCount;
                this.linearProgressIndicator.setProgress((int) unlockedAchievementsCount);
                this.description.setText(retroAchievementsGameRecord.getConsoleName());
                if (retroAchievementsGameRecord.getImageUrl() == null) {
                    Glide.with(this.this$0.this$0).clear(this.imageView);
                } else {
                    Glide.with(this.this$0.this$0).load((Object) retroAchievementsGameRecord.getImageUrl()).transition(DrawableTransitionOptions.withCrossFade()).into(this.imageView);
                }
                String consoleImageUrl = this.this$0.this$0.getRetroAchievementsManager().getConsoleImageUrl(retroAchievementsGameRecord.getConsoleId());
                if (consoleImageUrl == null) {
                    Glide.with(this.this$0.this$0).clear(this.systemIcon);
                } else {
                    Glide.with(this.this$0.this$0).load((Object) consoleImageUrl).transition(DrawableTransitionOptions.withCrossFade()).into(this.systemIcon);
                }
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public boolean onClick() {
                RetroAchievementsGameDialogFragment.Companion.newInstance$default(RetroAchievementsGameDialogFragment.INSTANCE, ((RetroAchievementsGameRecordEntity) this.this$0.retroAchievementsGameRecordList.get(getAbsoluteAdapterPosition())).getId(), null, null, null, null, 30, null).show(this.this$0.this$0.getParentFragmentManager(), RetroAchievementsGameDialogFragment.class.getName());
                return super.onClick();
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
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

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int position, RetroAchievementsGameRecordEntity item) {
                Intrinsics.checkNotNullParameter(item, "item");
                loadGameData(item);
                this.gameId = item.getGameId();
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0.this$0), Dispatchers.getIO(), null, new RetroAchievementsNavFragment$GameListAdapter$ViewHolder$onBind$1(this, item, this.this$0.this$0, null), 2, null);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_retro_achievements_game, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.widget_nav_retro_achievements_user_profile, container, false);
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
        View viewFindViewById8 = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.recyclerView = (DaijishouRecyclerView) viewFindViewById8;
        this.recyclerViewGameListAdapter = new GameListAdapter(this, this.retroAchievementsGameRecordList);
        this.recyclerViewRankingUserProfileListAdapter = new RankingUserProfileListAdapter(this, this.retroAchievementsUserRankingList);
        DaijishouRecyclerView daijishouRecyclerView = this.recyclerView;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView = null;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        daijishouRecyclerView.setLayoutManager(new DaijishouLinearLayoutManager(contextRequireContext));
        DaijishouRecyclerView daijishouRecyclerView2 = this.recyclerView;
        if (daijishouRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView2 = null;
        }
        daijishouRecyclerView2.addOnScrollListener(new AnonymousClass1());
        View viewFindViewById9 = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_refresh_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.refreshButton = (Chip) viewFindViewById9;
        View viewFindViewById10 = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_recent_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.recentButton = (Chip) viewFindViewById10;
        View viewFindViewById11 = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_completion_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.completionButton = (Chip) viewFindViewById11;
        View viewFindViewById12 = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_awards_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.awardsButton = (Chip) viewFindViewById12;
        View viewFindViewById13 = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_friends_ranking_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.rankingButton = (Chip) viewFindViewById13;
        View viewFindViewById14 = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_retro_achievements_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.retroAchievementsButton = (Chip) viewFindViewById14;
        HorizontalScrollView horizontalScrollView = this.scrollView;
        if (horizontalScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            horizontalScrollView = null;
        }
        horizontalScrollView.setOnScrollChangeListener(new RetroAchievementsNavFragment$$ExternalSyntheticLambda0(this));
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
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Chip chip7 = this.refreshButton;
        if (chip7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshButton");
            chip7 = null;
        }
        chip7.setOnClickListener(new RetroAchievementsNavFragment$$ExternalSyntheticLambda1(booleanRef, this));
        Chip chip8 = this.recentButton;
        if (chip8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentButton");
            chip8 = null;
        }
        chip8.setOnClickListener(new RetroAchievementsNavFragment$$ExternalSyntheticLambda2(this));
        Chip chip9 = this.completionButton;
        if (chip9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("completionButton");
            chip9 = null;
        }
        chip9.setOnClickListener(new RetroAchievementsNavFragment$$ExternalSyntheticLambda3(this));
        Chip chip10 = this.awardsButton;
        if (chip10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
            chip10 = null;
        }
        chip10.setOnClickListener(new RetroAchievementsNavFragment$$ExternalSyntheticLambda4(this));
        Context contextRequireContext2 = requireContext();
        Chip chip11 = this.rankingButton;
        if (chip11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
            chip11 = null;
        }
        PopupMenu popupMenu = new PopupMenu(contextRequireContext2, chip11);
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
        popupMenu.setOnMenuItemClickListener(new RetroAchievementsNavFragment$$ExternalSyntheticLambda5(this));
        Chip chip12 = this.rankingButton;
        if (chip12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
            chip12 = null;
        }
        chip12.setOnClickListener(new RetroAchievementsNavFragment$$ExternalSyntheticLambda6(popupMenu));
        LiveData liveDataSwitchMap = Transformations.switchMap(getRetroAchievementsManager().getMyUsernameLiveData(), new RetroAchievementsNavFragment$onCreateView$userProfileLiveData$1(this));
        LiveData liveDataSwitchMap2 = Transformations.switchMap(new SharedPreferenceIntLiveData(getDefaultSharedPreferences(), IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getKey(), IntPreference.RETRO_ACHIEVEMENTS_USER_PROFILE_VIEW_MODE.getDefaultValue()), new RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1(this, liveDataSwitchMap));
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        booleanRef2.element = true;
        liveDataSwitchMap2.observe(getViewLifecycleOwner(), new RetroAchievementsNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass9(booleanRef2, booleanRef, intRef)));
        getRetroAchievementsManager().getRefreshingUsernamesLiveData().observe(getViewLifecycleOwner(), new RetroAchievementsNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass10()));
        liveDataSwitchMap.observe(getViewLifecycleOwner(), new RetroAchievementsNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass11()));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass12(null), 2, null);
        return viewInflate;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$1, reason: invalid class name */
    /* INFO: compiled from: RetroAchievementsNavFragment.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$onCreateView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass1 extends RecyclerView.OnScrollListener {
        AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                RetroAchievementsNavFragment.this.scrollingOnBackPressed = false;
            }
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
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
    }

    /* INFO: Access modifiers changed from: private */
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

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3(Ref.BooleanRef refreshButtonClicked, RetroAchievementsNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(refreshButtonClicked, "$refreshButtonClicked");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        refreshButtonClicked.element = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getIO(), null, new RetroAchievementsNavFragment$onCreateView$3$1(this$0, null), 2, null);
    }

    /* INFO: Access modifiers changed from: private */
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

    /* INFO: Access modifiers changed from: private */
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

    /* INFO: Access modifiers changed from: private */
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

    /* INFO: Access modifiers changed from: private */
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

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$8(PopupMenu popupMenu, View view) {
        Intrinsics.checkNotNullParameter(popupMenu, "$popupMenu");
        popupMenu.show();
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$9, reason: invalid class name */
    /* INFO: compiled from: RetroAchievementsNavFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012J\u0010\u0002\u001aF\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0005 \b*\"\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Triple;", "", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserRankingEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass9 extends Lambda<Unit> implements Function1<Triple<? extends Integer, ? extends List<? extends RetroAchievementsGameRecordEntity>, ? extends List<? extends RetroAchievementsUserRankingEntity>>, Unit> {
        final /* synthetic */ Ref.BooleanRef $firstTime;
        final /* synthetic */ Ref.IntRef $oldViewMode;
        final /* synthetic */ Ref.BooleanRef $refreshButtonClicked;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Ref.IntRef intRef) {
            super(1);
            this.$firstTime = booleanRef;
            this.$refreshButtonClicked = booleanRef2;
            this.$oldViewMode = intRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Triple<? extends Integer, ? extends List<? extends RetroAchievementsGameRecordEntity>, ? extends List<? extends RetroAchievementsUserRankingEntity>> triple) {
            invoke2((Triple<Integer, ? extends List<RetroAchievementsGameRecordEntity>, ? extends List<RetroAchievementsUserRankingEntity>>) triple);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Triple<Integer, ? extends List<RetroAchievementsGameRecordEntity>, ? extends List<RetroAchievementsUserRankingEntity>> triple) {
            int iIntValue = triple.getFirst().intValue();
            List<RetroAchievementsGameRecordEntity> second = triple.getSecond();
            List<RetroAchievementsUserRankingEntity> third = triple.getThird();
            DaijishouRecyclerView daijishouRecyclerView = null;
            if (iIntValue <= 2) {
                DaijishouRecyclerView daijishouRecyclerView2 = RetroAchievementsNavFragment.this.recyclerView;
                if (daijishouRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    daijishouRecyclerView2 = null;
                }
                if (!(daijishouRecyclerView2.getAdapter() instanceof GameListAdapter)) {
                    DaijishouRecyclerView daijishouRecyclerView3 = RetroAchievementsNavFragment.this.recyclerView;
                    if (daijishouRecyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        daijishouRecyclerView3 = null;
                    }
                    GameListAdapter gameListAdapter = RetroAchievementsNavFragment.this.recyclerViewGameListAdapter;
                    if (gameListAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewGameListAdapter");
                        gameListAdapter = null;
                    }
                    daijishouRecyclerView3.setAdapter(gameListAdapter);
                }
                if (iIntValue == 0) {
                    Chip chip = RetroAchievementsNavFragment.this.recentButton;
                    if (chip == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                        chip = null;
                    }
                    chip.setChipStrokeWidth(RetroAchievementsNavFragment.this.chipStrokeWidth);
                    Chip chip2 = RetroAchievementsNavFragment.this.completionButton;
                    if (chip2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("completionButton");
                        chip2 = null;
                    }
                    chip2.setChipStrokeWidth(0.0f);
                    Chip chip3 = RetroAchievementsNavFragment.this.awardsButton;
                    if (chip3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
                        chip3 = null;
                    }
                    chip3.setChipStrokeWidth(0.0f);
                    Chip chip4 = RetroAchievementsNavFragment.this.rankingButton;
                    if (chip4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                        chip4 = null;
                    }
                    chip4.setChipStrokeWidth(0.0f);
                    DaijishouRecyclerView daijishouRecyclerView4 = RetroAchievementsNavFragment.this.recyclerView;
                    if (daijishouRecyclerView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        daijishouRecyclerView4 = null;
                    }
                    Chip chip5 = RetroAchievementsNavFragment.this.recentButton;
                    if (chip5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                        chip5 = null;
                    }
                    daijishouRecyclerView4.setNextFocusUpId(chip5.getId());
                } else if (iIntValue == 1) {
                    Chip chip6 = RetroAchievementsNavFragment.this.recentButton;
                    if (chip6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                        chip6 = null;
                    }
                    chip6.setChipStrokeWidth(0.0f);
                    Chip chip7 = RetroAchievementsNavFragment.this.completionButton;
                    if (chip7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("completionButton");
                        chip7 = null;
                    }
                    chip7.setChipStrokeWidth(RetroAchievementsNavFragment.this.chipStrokeWidth);
                    Chip chip8 = RetroAchievementsNavFragment.this.awardsButton;
                    if (chip8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
                        chip8 = null;
                    }
                    chip8.setChipStrokeWidth(0.0f);
                    Chip chip9 = RetroAchievementsNavFragment.this.rankingButton;
                    if (chip9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                        chip9 = null;
                    }
                    chip9.setChipStrokeWidth(0.0f);
                    DaijishouRecyclerView daijishouRecyclerView5 = RetroAchievementsNavFragment.this.recyclerView;
                    if (daijishouRecyclerView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        daijishouRecyclerView5 = null;
                    }
                    Chip chip10 = RetroAchievementsNavFragment.this.completionButton;
                    if (chip10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("completionButton");
                        chip10 = null;
                    }
                    daijishouRecyclerView5.setNextFocusUpId(chip10.getId());
                } else if (iIntValue == 2) {
                    Chip chip11 = RetroAchievementsNavFragment.this.recentButton;
                    if (chip11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                        chip11 = null;
                    }
                    chip11.setChipStrokeWidth(0.0f);
                    Chip chip12 = RetroAchievementsNavFragment.this.completionButton;
                    if (chip12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("completionButton");
                        chip12 = null;
                    }
                    chip12.setChipStrokeWidth(0.0f);
                    Chip chip13 = RetroAchievementsNavFragment.this.awardsButton;
                    if (chip13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
                        chip13 = null;
                    }
                    chip13.setChipStrokeWidth(RetroAchievementsNavFragment.this.chipStrokeWidth);
                    Chip chip14 = RetroAchievementsNavFragment.this.rankingButton;
                    if (chip14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                        chip14 = null;
                    }
                    chip14.setChipStrokeWidth(0.0f);
                    DaijishouRecyclerView daijishouRecyclerView6 = RetroAchievementsNavFragment.this.recyclerView;
                    if (daijishouRecyclerView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        daijishouRecyclerView6 = null;
                    }
                    Chip chip15 = RetroAchievementsNavFragment.this.awardsButton;
                    if (chip15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
                        chip15 = null;
                    }
                    daijishouRecyclerView6.setNextFocusUpId(chip15.getId());
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
                if (this.$firstTime.element || this.$refreshButtonClicked.element || this.$oldViewMode.element != iIntValue) {
                    this.$oldViewMode.element = iIntValue;
                    GameListAdapter gameListAdapter3 = RetroAchievementsNavFragment.this.recyclerViewGameListAdapter;
                    if (gameListAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewGameListAdapter");
                        gameListAdapter3 = null;
                    }
                    gameListAdapter3.selectPosition(-1);
                    DaijishouRecyclerView daijishouRecyclerView7 = RetroAchievementsNavFragment.this.recyclerView;
                    if (daijishouRecyclerView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        daijishouRecyclerView7 = null;
                    }
                    daijishouRecyclerView7.clearFocus();
                    DaijishouRecyclerView daijishouRecyclerView8 = RetroAchievementsNavFragment.this.recyclerView;
                    if (daijishouRecyclerView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    } else {
                        daijishouRecyclerView = daijishouRecyclerView8;
                    }
                    daijishouRecyclerView.scrollToPosition(0);
                    this.$refreshButtonClicked.element = false;
                    this.$firstTime.element = false;
                    return;
                }
                return;
            }
            DaijishouRecyclerView daijishouRecyclerView9 = RetroAchievementsNavFragment.this.recyclerView;
            if (daijishouRecyclerView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView9 = null;
            }
            if (!(daijishouRecyclerView9.getAdapter() instanceof RankingUserProfileListAdapter)) {
                DaijishouRecyclerView daijishouRecyclerView10 = RetroAchievementsNavFragment.this.recyclerView;
                if (daijishouRecyclerView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    daijishouRecyclerView10 = null;
                }
                RankingUserProfileListAdapter rankingUserProfileListAdapter = RetroAchievementsNavFragment.this.recyclerViewRankingUserProfileListAdapter;
                if (rankingUserProfileListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerViewRankingUserProfileListAdapter");
                    rankingUserProfileListAdapter = null;
                }
                daijishouRecyclerView10.setAdapter(rankingUserProfileListAdapter);
            }
            RetroAchievementsNavFragment.this.retroAchievementsUserRankingList.clear();
            if (iIntValue == 3) {
                RetroAchievementsNavFragment.this.retroAchievementsUserRankingList.addAll(third);
                Chip chip16 = RetroAchievementsNavFragment.this.recentButton;
                if (chip16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                    chip16 = null;
                }
                chip16.setChipStrokeWidth(0.0f);
                Chip chip17 = RetroAchievementsNavFragment.this.completionButton;
                if (chip17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("completionButton");
                    chip17 = null;
                }
                chip17.setChipStrokeWidth(0.0f);
                Chip chip18 = RetroAchievementsNavFragment.this.awardsButton;
                if (chip18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
                    chip18 = null;
                }
                chip18.setChipStrokeWidth(0.0f);
                Chip chip19 = RetroAchievementsNavFragment.this.rankingButton;
                if (chip19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                    chip19 = null;
                }
                chip19.setChipStrokeWidth(RetroAchievementsNavFragment.this.chipStrokeWidth);
                DaijishouRecyclerView daijishouRecyclerView11 = RetroAchievementsNavFragment.this.recyclerView;
                if (daijishouRecyclerView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    daijishouRecyclerView11 = null;
                }
                Chip chip20 = RetroAchievementsNavFragment.this.rankingButton;
                if (chip20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                    chip20 = null;
                }
                daijishouRecyclerView11.setNextFocusUpId(chip20.getId());
            } else if (iIntValue == 4) {
                RetroAchievementsNavFragment.this.retroAchievementsUserRankingList.addAll(third);
                Chip chip21 = RetroAchievementsNavFragment.this.recentButton;
                if (chip21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                    chip21 = null;
                }
                chip21.setChipStrokeWidth(0.0f);
                Chip chip22 = RetroAchievementsNavFragment.this.completionButton;
                if (chip22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("completionButton");
                    chip22 = null;
                }
                chip22.setChipStrokeWidth(0.0f);
                Chip chip23 = RetroAchievementsNavFragment.this.awardsButton;
                if (chip23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
                    chip23 = null;
                }
                chip23.setChipStrokeWidth(0.0f);
                Chip chip24 = RetroAchievementsNavFragment.this.rankingButton;
                if (chip24 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                    chip24 = null;
                }
                chip24.setChipStrokeWidth(RetroAchievementsNavFragment.this.chipStrokeWidth);
                DaijishouRecyclerView daijishouRecyclerView12 = RetroAchievementsNavFragment.this.recyclerView;
                if (daijishouRecyclerView12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    daijishouRecyclerView12 = null;
                }
                Chip chip25 = RetroAchievementsNavFragment.this.rankingButton;
                if (chip25 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                    chip25 = null;
                }
                daijishouRecyclerView12.setNextFocusUpId(chip25.getId());
            } else if (iIntValue == 5) {
                RetroAchievementsNavFragment.this.retroAchievementsUserRankingList.addAll(third);
                Chip chip26 = RetroAchievementsNavFragment.this.recentButton;
                if (chip26 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recentButton");
                    chip26 = null;
                }
                chip26.setChipStrokeWidth(0.0f);
                Chip chip27 = RetroAchievementsNavFragment.this.completionButton;
                if (chip27 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("completionButton");
                    chip27 = null;
                }
                chip27.setChipStrokeWidth(0.0f);
                Chip chip28 = RetroAchievementsNavFragment.this.awardsButton;
                if (chip28 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("awardsButton");
                    chip28 = null;
                }
                chip28.setChipStrokeWidth(0.0f);
                Chip chip29 = RetroAchievementsNavFragment.this.rankingButton;
                if (chip29 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                    chip29 = null;
                }
                chip29.setChipStrokeWidth(RetroAchievementsNavFragment.this.chipStrokeWidth);
                DaijishouRecyclerView daijishouRecyclerView13 = RetroAchievementsNavFragment.this.recyclerView;
                if (daijishouRecyclerView13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    daijishouRecyclerView13 = null;
                }
                Chip chip30 = RetroAchievementsNavFragment.this.rankingButton;
                if (chip30 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rankingButton");
                    chip30 = null;
                }
                daijishouRecyclerView13.setNextFocusUpId(chip30.getId());
            }
            DaijishouRecyclerView daijishouRecyclerView14 = RetroAchievementsNavFragment.this.recyclerView;
            if (daijishouRecyclerView14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                daijishouRecyclerView = daijishouRecyclerView14;
            }
            RecyclerView.Adapter adapter = daijishouRecyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$10, reason: invalid class name */
    /* INFO: compiled from: RetroAchievementsNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass10 extends Lambda<Unit> implements Function1<List<? extends String>, Unit> {
        AnonymousClass10() {
            super(1);
        }

        /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$10$1, reason: invalid class name */
        /* INFO: compiled from: RetroAchievementsNavFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$10$1", f = "RetroAchievementsNavFragment.kt", i = {}, l = {809, 811}, m = "invokeSuspendImpl", n = {}, s = {})
        final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            final /* synthetic */ List<String> $it;
            int label;
            final /* synthetic */ RetroAchievementsNavFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(RetroAchievementsNavFragment retroAchievementsNavFragment, List<String> list, Continuation<?> continuation) {
                super(2, continuation);
                this.this$0 = retroAchievementsNavFragment;
                this.$it = list;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$it, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            }

            /* WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
            
                if (kotlinx.coroutines.BuildersKt.withContext(r6, r1, r5) == r0) goto L19;
             */

            public final Object invokeSuspendImpl(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i != 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = this.this$0.getRetroAchievementsManager().getMyRetroAchievementsUsername(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                String str = (String) obj;
                if (str != null && this.$it.contains(str)) {
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new RetroAchievementsNavFragment$onCreateView$10$1$1$1(this.this$0, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<String> list) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(RetroAchievementsNavFragment.this), Dispatchers.getIO(), null, new AnonymousClass1(RetroAchievementsNavFragment.this, list, null), 2, null);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$11, reason: invalid class name */
    /* INFO: compiled from: RetroAchievementsNavFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "userProfile", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass11 extends Lambda<Unit> implements Function1<RetroAchievementsUserProfileEntity, Unit> {
        AnonymousClass11() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
            invoke2(retroAchievementsUserProfileEntity);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
            if (retroAchievementsUserProfileEntity == null) {
                TextView textView = RetroAchievementsNavFragment.this.title;
                String str = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                    textView = null;
                }
                String str2 = RetroAchievementsNavFragment.this.pleaseLoginString;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pleaseLoginString");
                    str2 = null;
                }
                textView.setText(str2);
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
                String str3 = RetroAchievementsNavFragment.this.noMottoString;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("noMottoString");
                } else {
                    str = str3;
                }
                textView3.setText(str);
                return;
            }
            RetroAchievementsNavFragment.this.renderUserProfile(retroAchievementsUserProfileEntity);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$12, reason: invalid class name */
    /* INFO: compiled from: RetroAchievementsNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$12", f = "RetroAchievementsNavFragment.kt", i = {}, l = {831, 832}, m = "invokeSuspendImpl", n = {}, s = {})
    final class AnonymousClass12 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;

        AnonymousClass12(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsNavFragment.this.new AnonymousClass12(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass12) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        /* WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
        
            if (r1.refreshRetroAchievementsUserProfileDataIfExpired(r5, r4) == r0) goto L17;
         */

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
            } else {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = RetroAchievementsNavFragment.this.getRetroAchievementsManager().getMyRetroAchievementsUsername(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            String str = (String) obj;
            if (str != null) {
                this.label = 2;
                if (RetroAchievementsNavFragment.this.getRetroAchievementsManager().refreshRetroAchievementsUserProfileDataIfExpired(str, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.fragment.app.Fragment
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
