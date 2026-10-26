package com.magneticchen.daijishou.view_pager_fragments;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment;
import com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerType;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouGridLayoutManager;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.dialog_fragments.ListSelectDialogFragment;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.view_models.AppsViewModel;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.Job;
import net.lingala.zip4j.util.InternalZipConstants;

/* INFO: compiled from: AppsViewPagerFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 T2\u00020\u0001:\u0003STUB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010@\u001a\u000202H\u0016J\u0012\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J&\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010C\u001a\u0004\u0018\u00010DH\u0017J\b\u0010K\u001a\u00020BH\u0016J \u0010L\u001a\u0002022\u0006\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020\r2\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010Q\u001a\u00020B2\u0006\u0010R\u001a\u000200H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000fR\u000e\u0010)\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u00060-R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\r0!X\u0082.¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u000202X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/magneticchen/daijishou/view_pager_fragments/AppsViewPagerFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/ViewPagerFragment;", "()V", "activitiesFormatString", "", "applicationInfoString", "appsViewModel", "Lcom/magneticchen/daijishou/view_models/AppsViewModel;", "getAppsViewModel", "()Lcom/magneticchen/daijishou/view_models/AppsViewModel;", "appsViewModel$delegate", "Lkotlin/Lazy;", "backButtonDescriptionStringId", "", "getBackButtonDescriptionStringId", "()I", "copiedString", "displayNameStringId", "getDisplayNameStringId", "setDisplayNameStringId", "(I)V", "flagAsGameFormatString", "flagAsNotGameFormatString", "gridLayoutManager", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouGridLayoutManager;", "id", "getId", "()Ljava/lang/String;", "isGameFormatString", "isNotGameFormatString", "modeButton", "Lcom/google/android/material/button/MaterialButton;", "modeNameStringList", "", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;", "model$delegate", "nextFocusDown", "getNextFocusDown", "optionsString", "recyclerView", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView;", "recyclerViewAdapter", "Lcom/magneticchen/daijishou/view_pager_fragments/AppsViewPagerFragment$AppsRecyclerViewAdapter;", "resolveInfoCollectionInRecyclerView", "", "Landroid/content/pm/ResolveInfo;", "scrollingOnBackPressed", "", "sortButton", "sortingTypeIconList", "sortingTypeStringList", "titleLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "uninstallConfirmFormatString", "uninstallFormatString", "useDefaultWallpaper", "getUseDefaultWallpaper", "()Z", "setUseDefaultWallpaper", "(Z)V", "viewActivitiesString", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onHotKeyPressed", "hotkeyCode", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "showResolveInfoOptions", "resolveInfo", "AppsRecyclerViewAdapter", "Companion", "ResolveInfoDiffUtilCallback", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppsViewPagerFragment extends ViewPagerFragment {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int appIconResolutionPx = 128;
    private String activitiesFormatString;
    private String applicationInfoString;

    /* INFO: renamed from: appsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy appsViewModel;
    private String copiedString;
    private String flagAsGameFormatString;
    private String flagAsNotGameFormatString;
    private DaijishouGridLayoutManager gridLayoutManager;
    private String isGameFormatString;
    private String isNotGameFormatString;
    private MaterialButton modeButton;
    private List<String> modeNameStringList;

    /* INFO: renamed from: model$delegate, reason: from kotlin metadata */
    private final Lazy model;
    private String optionsString;
    private DaijishouRecyclerView recyclerView;
    private AppsRecyclerViewAdapter recyclerViewAdapter;
    private boolean scrollingOnBackPressed;
    private MaterialButton sortButton;
    private List<Integer> sortingTypeIconList;
    private List<String> sortingTypeStringList;
    private ConstraintLayout titleLayout;
    private String uninstallConfirmFormatString;
    private String uninstallFormatString;
    private boolean useDefaultWallpaper;
    private String viewActivitiesString;
    private final String id = ViewPagerType.APPS.getId();
    private final int nextFocusDown = R.id.apps_title_layout;
    private int displayNameStringId = R.string.apps_page;
    private final int backButtonDescriptionStringId = R.string.go_top;
    private final List<ResolveInfo> resolveInfoCollectionInRecyclerView = new ArrayList();

    public AppsViewPagerFragment() {
        AppsViewPagerFragment appsViewPagerFragment = this;
        this.model = FragmentViewModelLazyKt.createViewModelLazy(appsViewPagerFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new AppsViewPagerFragment$special$$inlined$activityViewModels$default$1(appsViewPagerFragment), new AppsViewPagerFragment$special$$inlined$activityViewModels$default$2(null, appsViewPagerFragment), new AppsViewPagerFragment$special$$inlined$activityViewModels$default$3(appsViewPagerFragment));
        this.appsViewModel = FragmentViewModelLazyKt.createViewModelLazy(appsViewPagerFragment, Reflection.getOrCreateKotlinClass(AppsViewModel.class), new AppsViewPagerFragment$special$$inlined$activityViewModels$default$4(appsViewPagerFragment), new AppsViewPagerFragment$special$$inlined$activityViewModels$default$5(null, appsViewPagerFragment), new AppsViewPagerFragment$special$$inlined$activityViewModels$default$6(appsViewPagerFragment));
    }

    /* INFO: compiled from: AppsViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/view_pager_fragments/AppsViewPagerFragment$Companion;", "", "()V", "appIconResolutionPx", "", "newInstance", "Lcom/magneticchen/daijishou/view_pager_fragments/AppsViewPagerFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AppsViewPagerFragment newInstance() {
            return new AppsViewPagerFragment();
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public String getStringId() {
        return this.id;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public int getNextFocusDown() {
        return this.nextFocusDown;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public int getDisplayNameStringId() {
        return this.displayNameStringId;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public void setDisplayNameStringId(int i) {
        this.displayNameStringId = i;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public int getBackButtonDescriptionStringId() {
        return this.backButtonDescriptionStringId;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public boolean getUseDefaultWallpaper() {
        return this.useDefaultWallpaper;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.ViewPagerFragment
    public void setUseDefaultWallpaper(boolean z) {
        this.useDefaultWallpaper = z;
    }

    /* INFO: Access modifiers changed from: private */
    public final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model.getValue();
    }

    /* INFO: Access modifiers changed from: private */
    public final AppsViewModel getAppsViewModel() {
        return (AppsViewModel) this.appsViewModel.getValue();
    }

    /* INFO: compiled from: AppsViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/view_pager_fragments/AppsViewPagerFragment$ResolveInfoDiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Landroid/content/pm/ResolveInfo;", "newList", "(Lcom/magneticchen/daijishou/view_pager_fragments/AppsViewPagerFragment;Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_release", "appsViewModel", "Lcom/magneticchen/daijishou/view_models/AppsViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ResolveInfoDiffUtilCallback extends DiffUtil.Callback {
        private final List<ResolveInfo> newList;
        private final List<ResolveInfo> oldList;
        final /* synthetic */ AppsViewPagerFragment this$0;

        /* WARN: Multi-variable type inference failed */
        public ResolveInfoDiffUtilCallback(AppsViewPagerFragment appsViewPagerFragment, List<ResolveInfo> oldList, List<ResolveInfo> newList) {
            Intrinsics.checkNotNullParameter(oldList, "oldList");
            Intrinsics.checkNotNullParameter(newList, "newList");
            this.this$0 = appsViewPagerFragment;
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldList.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.newList.size();
        }

        private final AppsViewModel areItemsTheSame$lambda$0(Lazy<AppsViewModel> lazy) {
            return lazy.getValue();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            FragmentActivity fragmentActivity = fragmentActivityRequireActivity;
            ViewModelLazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AppsViewModel.class), new AppsViewPagerFragment$ResolveInfoDiffUtilCallback$areItemsTheSame$$inlined$viewModels$default$2(fragmentActivity), new AppsViewPagerFragment$ResolveInfoDiffUtilCallback$areItemsTheSame$$inlined$viewModels$default$1(fragmentActivity), new AppsViewPagerFragment$ResolveInfoDiffUtilCallback$areItemsTheSame$$inlined$viewModels$default$3(null, fragmentActivity));
            return Intrinsics.areEqual(areItemsTheSame$lambda$0(viewModelLazy).resolveInfoToResolveInfoStringId(this.newList.get(newItemPosition)), areItemsTheSame$lambda$0(viewModelLazy).resolveInfoToResolveInfoStringId(this.oldList.get(oldItemPosition)));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics.areEqual(this.newList.get(newItemPosition), this.oldList.get(oldItemPosition));
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onHotKeyPressed(int hotkeyCode, int keyCode, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(hotkeyCode, keyCode, keyEvent);
        MaterialButton materialButton = null;
        AppsRecyclerViewAdapter appsRecyclerViewAdapter = null;
        MaterialButton materialButton2 = null;
        if (hotkeyCode == 1) {
            DaijishouRecyclerView daijishouRecyclerView = this.recyclerView;
            if (daijishouRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView = null;
            }
            daijishouRecyclerView.scrollToPosition(0);
            MaterialButton materialButton3 = this.modeButton;
            if (materialButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("modeButton");
                materialButton3 = null;
            }
            materialButton3.requestFocus();
            MaterialButton materialButton4 = this.modeButton;
            if (materialButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("modeButton");
            } else {
                materialButton = materialButton4;
            }
            materialButton.performClick();
            return true;
        }
        if (hotkeyCode == 2) {
            onBackPressed();
            return true;
        }
        if (hotkeyCode == 3) {
            DaijishouRecyclerView daijishouRecyclerView2 = this.recyclerView;
            if (daijishouRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView2 = null;
            }
            daijishouRecyclerView2.scrollToPosition(0);
            MaterialButton materialButton5 = this.sortButton;
            if (materialButton5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sortButton");
                materialButton5 = null;
            }
            materialButton5.requestFocus();
            MaterialButton materialButton6 = this.sortButton;
            if (materialButton6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sortButton");
            } else {
                materialButton2 = materialButton6;
            }
            materialButton2.performClick();
            return true;
        }
        if (hotkeyCode != 4) {
            return false;
        }
        List<ResolveInfo> value = getAppsViewModel().getPackageResolveInfoListLiveData().getValue();
        if (value != null) {
            AppsRecyclerViewAdapter appsRecyclerViewAdapter2 = this.recyclerViewAdapter;
            if (appsRecyclerViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                appsRecyclerViewAdapter2 = null;
            }
            if (appsRecyclerViewAdapter2.get_selectedPosition() >= 0) {
                AppsRecyclerViewAdapter appsRecyclerViewAdapter3 = this.recyclerViewAdapter;
                if (appsRecyclerViewAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                    appsRecyclerViewAdapter3 = null;
                }
                if (appsRecyclerViewAdapter3.get_selectedPosition() < value.size()) {
                    AppsRecyclerViewAdapter appsRecyclerViewAdapter4 = this.recyclerViewAdapter;
                    if (appsRecyclerViewAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                    } else {
                        appsRecyclerViewAdapter = appsRecyclerViewAdapter4;
                    }
                    showResolveInfoOptions(value.get(appsRecyclerViewAdapter.get_selectedPosition()));
                }
            }
        }
        return true;
    }

    /* WARN: Code duplicated, block: B:11:0x001e  */
    /* WARN: Code duplicated, block: B:32:0x005c  */
    /* WARN: Code duplicated, block: B:34:0x0062  */
    /* WARN: Code duplicated, block: B:37:0x006d  */
    /* WARN: Code duplicated, block: B:38:0x0071  */
    /* WARN: Code duplicated, block: B:9:0x001a  */
    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onBackPressed() {
        DaijishouRecyclerView daijishouRecyclerView;
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        ConstraintLayout constraintLayout3 = null;
        if (this.scrollingOnBackPressed) {
            DaijishouRecyclerView daijishouRecyclerView2 = this.recyclerView;
            if (daijishouRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView2 = null;
            }
            if (daijishouRecyclerView2.getScrollState() != 2) {
                daijishouRecyclerView = this.recyclerView;
                if (daijishouRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    daijishouRecyclerView = null;
                }
                if (daijishouRecyclerView.computeVerticalScrollOffset() != 0) {
                    this.scrollingOnBackPressed = true;
                    constraintLayout = this.titleLayout;
                    if (constraintLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
                        constraintLayout = null;
                    }
                    constraintLayout.requestFocus();
                    constraintLayout2 = this.titleLayout;
                    if (constraintLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
                    } else {
                        constraintLayout3 = constraintLayout2;
                    }
                    constraintLayout3.performClick();
                    return false;
                }
            }
        } else {
            daijishouRecyclerView = this.recyclerView;
            if (daijishouRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView = null;
            }
            if (daijishouRecyclerView.computeVerticalScrollOffset() != 0) {
                this.scrollingOnBackPressed = true;
                constraintLayout = this.titleLayout;
                if (constraintLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
                    constraintLayout = null;
                }
                constraintLayout.requestFocus();
                constraintLayout2 = this.titleLayout;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
                } else {
                    constraintLayout3 = constraintLayout2;
                }
                constraintLayout3.performClick();
                return false;
            }
        }
        DaijishouRecyclerView daijishouRecyclerView3 = this.recyclerView;
        if (daijishouRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView3 = null;
        }
        daijishouRecyclerView3.scrollToPosition(0);
        ConstraintLayout constraintLayout4 = this.titleLayout;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout4 = null;
        }
        if (constraintLayout4.isFocused()) {
            return true;
        }
        ConstraintLayout constraintLayout5 = this.titleLayout;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout5 = null;
        }
        constraintLayout5.requestFocus();
        ConstraintLayout constraintLayout6 = this.titleLayout;
        if (constraintLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
        } else {
            constraintLayout3 = constraintLayout6;
        }
        return !constraintLayout3.isFocused();
    }

    /* INFO: Access modifiers changed from: private */
    public final void showResolveInfoOptions(ResolveInfo resolveInfo) {
        String str;
        String str2;
        String str3;
        PackageManager packageManager = requireActivity().getPackageManager();
        String str4 = resolveInfo.activityInfo.packageName;
        String strResolveInfoToResolveInfoStringId = getAppsViewModel().resolveInfoToResolveInfoStringId(resolveInfo);
        CharSequence charSequenceLoadLabel = resolveInfo.loadLabel(packageManager);
        Intrinsics.checkNotNullExpressionValue(charSequenceLoadLabel, "loadLabel(...)");
        boolean zIsResolveInfoStringIdFlagAsGame = getAppsViewModel().isResolveInfoStringIdFlagAsGame(strResolveInfoToResolveInfoStringId);
        ListSelectDialogFragment.Companion companion = ListSelectDialogFragment.INSTANCE;
        String str5 = this.optionsString;
        String str6 = null;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("optionsString");
            str = null;
        } else {
            str = str5;
        }
        String[] strArr = new String[4];
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str7 = this.uninstallFormatString;
        if (str7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uninstallFormatString");
            str7 = null;
        }
        String str8 = String.format(str7, Arrays.copyOf(new Object[]{charSequenceLoadLabel}, 1));
        Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
        strArr[0] = str8;
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        if (zIsResolveInfoStringIdFlagAsGame) {
            str2 = this.flagAsNotGameFormatString;
            if (str2 == null) {
                str3 = "flagAsNotGameFormatString";
                Intrinsics.throwUninitializedPropertyAccessException(str3);
                str2 = null;
            }
        } else {
            str2 = this.flagAsGameFormatString;
            if (str2 == null) {
                str3 = "flagAsGameFormatString";
                Intrinsics.throwUninitializedPropertyAccessException(str3);
                str2 = null;
            }
        }
        String str9 = String.format(str2, Arrays.copyOf(new Object[]{charSequenceLoadLabel}, 1));
        Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
        strArr[1] = str9;
        String str10 = this.viewActivitiesString;
        if (str10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewActivitiesString");
            str10 = null;
        }
        strArr[2] = str10;
        String str11 = this.applicationInfoString;
        if (str11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationInfoString");
        } else {
            str6 = str11;
        }
        strArr[3] = str6;
        ListSelectDialogFragment listSelectDialogFragmentNewInstance$default = ListSelectDialogFragment.Companion.newInstance$default(companion, str, CollectionsKt.arrayListOf(strArr), null, false, 12, null);
        listSelectDialogFragmentNewInstance$default.setOnSelectListener(new AnonymousClass1(str4, this, strResolveInfoToResolveInfoStringId, packageManager, charSequenceLoadLabel, listSelectDialogFragmentNewInstance$default));
        listSelectDialogFragmentNewInstance$default.show(getChildFragmentManager(), ListSelectDialogFragment.class.getName());
    }

    /* INFO: renamed from: com.magneticchen.daijishou.view_pager_fragments.AppsViewPagerFragment$showResolveInfoOptions$1, reason: invalid class name */
    /* INFO: compiled from: AppsViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda<Unit> implements Function1<Integer, Unit> {
        final /* synthetic */ CharSequence $appLabel;
        final /* synthetic */ ListSelectDialogFragment $dialog;
        final /* synthetic */ PackageManager $packageManager;
        final /* synthetic */ String $packageName;
        final /* synthetic */ String $resolveInfoStringId;
        final /* synthetic */ AppsViewPagerFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, AppsViewPagerFragment appsViewPagerFragment, String str2, PackageManager packageManager, CharSequence charSequence, ListSelectDialogFragment listSelectDialogFragment) {
            super(1);
            this.$packageName = str;
            this.this$0 = appsViewPagerFragment;
            this.$resolveInfoStringId = str2;
            this.$packageManager = packageManager;
            this.$appLabel = charSequence;
            this.$dialog = listSelectDialogFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            try {
                invoke(num.intValue());
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
            return Unit.INSTANCE;
        }

        public final void invoke(int i) throws PackageManager.NameNotFoundException {
            if (i == 0) {
                Intent intent = new Intent("android.intent.action.DELETE");
                intent.setData(Uri.parse("package:" + this.$packageName));
                this.this$0.startActivity(intent);
            } else if (i == 1) {
                this.this$0.getAppsViewModel().toggleResolveInfoStringIdFlagAsGame(this.$resolveInfoStringId);
            } else if (i == 2) {
                PackageInfo packageInfo = this.$packageManager.getPackageInfo(this.$packageName, 1);
                ArrayList arrayList = new ArrayList();
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                if (activityInfoArr != null) {
                    String str = this.$packageName;
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        arrayList.add(str + InternalZipConstants.ZIP_FILE_SEPARATOR + activityInfo.name);
                    }
                }
                ListSelectDialogFragment.Companion companion = ListSelectDialogFragment.INSTANCE;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str2 = this.this$0.activitiesFormatString;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("activitiesFormatString");
                    str2 = null;
                }
                String str3 = String.format(str2, Arrays.copyOf(new Object[]{this.$appLabel}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                ListSelectDialogFragment listSelectDialogFragmentNewInstance$default = ListSelectDialogFragment.Companion.newInstance$default(companion, str3, arrayList, null, false, 12, null);
                listSelectDialogFragmentNewInstance$default.setOnSelectListener(new AnonymousClass2(this.this$0, arrayList, listSelectDialogFragmentNewInstance$default)).show(this.this$0.getChildFragmentManager(), ListSelectDialogFragment.class.getName());
            } else if (i == 3) {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.addCategory("android.intent.category.DEFAULT");
                intent2.setData(Uri.parse("package:" + this.$packageName));
                this.this$0.startActivity(intent2);
            }
            this.$dialog.dismiss();
        }

        /* INFO: renamed from: com.magneticchen.daijishou.view_pager_fragments.AppsViewPagerFragment$showResolveInfoOptions$1$2, reason: invalid class name */
        /* INFO: compiled from: AppsViewPagerFragment.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "selectedActivityIndex", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass2 extends Lambda<Unit> implements Function1<Integer, Unit> {
            final /* synthetic */ ListSelectDialogFragment $activitiesDialog;
            final /* synthetic */ ArrayList<String> $activityNames;
            final /* synthetic */ AppsViewPagerFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(AppsViewPagerFragment appsViewPagerFragment, ArrayList<String> arrayList, ListSelectDialogFragment listSelectDialogFragment) {
                super(1);
                this.this$0 = appsViewPagerFragment;
                this.$activityNames = arrayList;
                this.$activitiesDialog = listSelectDialogFragment;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                try {
                invoke(num.intValue());
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                Object systemService = this.this$0.requireActivity().getSystemService("clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("activity", this.$activityNames.get(i)));
                this.$activitiesDialog.dismiss();
                Context context = this.this$0.getContext();
                String str = this.this$0.copiedString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("copiedString");
                    str = null;
                }
                Toast.makeText(context, str, 0).show();
            }
        }
    }

    /* INFO: compiled from: AppsViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\"\u0010\u001b\u001a\f0\u001cR\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R-\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0013j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/magneticchen/daijishou/view_pager_fragments/AppsViewPagerFragment$AppsRecyclerViewAdapter;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Landroid/content/pm/ResolveInfo;", "packageResolveInfoList", "", "(Lcom/magneticchen/daijishou/view_pager_fragments/AppsViewPagerFragment;Ljava/util/List;)V", "appsViewModel", "Lcom/magneticchen/daijishou/view_models/AppsViewModel;", "getAppsViewModel", "()Lcom/magneticchen/daijishou/view_models/AppsViewModel;", "appsViewModel$delegate", "Lkotlin/Lazy;", "resolveInfoStringIdToBitmapCache", "Lcom/magneticchen/daijishou/utils/Utils$MaxSizeHashMap;", "", "Landroid/graphics/Bitmap;", "getResolveInfoStringIdToBitmapCache", "()Lcom/magneticchen/daijishou/utils/Utils$MaxSizeHashMap;", "resolveInfoStringIdToLabelCache", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getResolveInfoStringIdToLabelCache", "()Ljava/util/HashMap;", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class AppsRecyclerViewAdapter extends DaijishouRecyclerView.Adapter<ResolveInfo> {

        /* INFO: renamed from: appsViewModel$delegate, reason: from kotlin metadata */
        private final Lazy appsViewModel;
        private final List<ResolveInfo> packageResolveInfoList;
        private final Utils.MaxSizeHashMap<String, Bitmap> resolveInfoStringIdToBitmapCache;
        private final HashMap<String, String> resolveInfoStringIdToLabelCache;
        final /* synthetic */ AppsViewPagerFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppsRecyclerViewAdapter(AppsViewPagerFragment appsViewPagerFragment, List<ResolveInfo> packageResolveInfoList) {
            super(packageResolveInfoList, false, false, 6, null);
            Intrinsics.checkNotNullParameter(packageResolveInfoList, "packageResolveInfoList");
            this.this$0 = appsViewPagerFragment;
            this.packageResolveInfoList = packageResolveInfoList;
            AppsViewPagerFragment appsViewPagerFragment2 = appsViewPagerFragment;
            this.appsViewModel = FragmentViewModelLazyKt.createViewModelLazy(appsViewPagerFragment2, Reflection.getOrCreateKotlinClass(AppsViewModel.class), new AppsViewPagerFragment$AppsRecyclerViewAdapter$special$$inlined$activityViewModels$default$1(appsViewPagerFragment2), new AppsViewPagerFragment$AppsRecyclerViewAdapter$special$$inlined$activityViewModels$default$2(null, appsViewPagerFragment2), new AppsViewPagerFragment$AppsRecyclerViewAdapter$special$$inlined$activityViewModels$default$3(appsViewPagerFragment2));
            this.resolveInfoStringIdToBitmapCache = getAppsViewModel().getResolveInfoStringIdToBitmapCache();
            this.resolveInfoStringIdToLabelCache = getAppsViewModel().getResolveInfoStringIdToLabelCache();
        }

        /* INFO: Access modifiers changed from: private */
        public final AppsViewModel getAppsViewModel() {
            return (AppsViewModel) this.appsViewModel.getValue();
        }

        public final Utils.MaxSizeHashMap<String, Bitmap> getResolveInfoStringIdToBitmapCache() {
            return this.resolveInfoStringIdToBitmapCache;
        }

        public final HashMap<String, String> getResolveInfoStringIdToLabelCache() {
            return this.resolveInfoStringIdToLabelCache;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public DaijishouRecyclerView.Adapter<ResolveInfo>.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_app, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            return this.packageResolveInfoList.get(position).activityInfo.hashCode();
        }

        /* INFO: compiled from: AppsViewPagerFragment.kt */
        @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0016J\b\u0010'\u001a\u00020#H\u0016J\u0010\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u001eH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!¨\u0006*"}, d2 = {"Lcom/magneticchen/daijishou/view_pager_fragments/AppsViewPagerFragment$AppsRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Landroid/content/pm/ResolveInfo;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/view_pager_fragments/AppsViewPagerFragment$AppsRecyclerViewAdapter;Landroid/view/View;)V", "appGamePadIconTextView", "Landroid/widget/TextView;", "getAppGamePadIconTextView", "()Landroid/widget/TextView;", "appIconImageView", "Landroid/widget/ImageView;", "getAppIconImageView", "()Landroid/widget/ImageView;", "appLabel", "", "getAppLabel", "()Ljava/lang/String;", "setAppLabel", "(Ljava/lang/String;)V", "appLabelView", "getAppLabelView", "drawableJob", "Lkotlinx/coroutines/Job;", "getDrawableJob", "()Lkotlinx/coroutines/Job;", "setDrawableJob", "(Lkotlinx/coroutines/Job;)V", "isGame", "", "()Z", "setGame", "(Z)V", "onBind", "", "position", "", "item", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<ResolveInfo>.ViewHolder {
            private final TextView appGamePadIconTextView;
            private final ImageView appIconImageView;
            private String appLabel;
            private final TextView appLabelView;
            private Job drawableJob;
            private boolean isGame;
            final /* synthetic */ AppsRecyclerViewAdapter this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(AppsRecyclerViewAdapter appsRecyclerViewAdapter, View itemView) {
                super(appsRecyclerViewAdapter, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = appsRecyclerViewAdapter;
                View viewFindViewById = itemView.findViewById(R.id.app_icon);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                this.appIconImageView = (ImageView) viewFindViewById;
                View viewFindViewById2 = itemView.findViewById(R.id.app_label);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.appLabelView = (TextView) viewFindViewById2;
                View viewFindViewById3 = itemView.findViewById(R.id.app_game_pad_icon);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                this.appGamePadIconTextView = (TextView) viewFindViewById3;
                this.appLabel = "App";
            }

            public final ImageView getAppIconImageView() {
                return this.appIconImageView;
            }

            public final TextView getAppLabelView() {
                return this.appLabelView;
            }

            public final TextView getAppGamePadIconTextView() {
                return this.appGamePadIconTextView;
            }

            public final Job getDrawableJob() {
                return this.drawableJob;
            }

            public final void setDrawableJob(Job job) {
                this.drawableJob = job;
            }

            public final String getAppLabel() {
                return this.appLabel;
            }

            public final void setAppLabel(String str) {
                this.appLabel = str;
            }

            /* INFO: renamed from: isGame, reason: from getter */
            public final boolean getIsGame() {
                return this.isGame;
            }

            public final void setGame(boolean z) {
                this.isGame = z;
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocus() {
                String str;
                super.onFocus();
                String str2 = this.appLabel;
                if (str2 != null) {
                    AppsViewPagerFragment appsViewPagerFragment = this.this$0.this$0;
                    DaijishouViewModel model = appsViewPagerFragment.getModel();
                    if (this.isGame) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String str3 = appsViewPagerFragment.isGameFormatString;
                        if (str3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("isGameFormatString");
                            str3 = null;
                        }
                        str = String.format(str3, Arrays.copyOf(new Object[]{str2}, 1));
                    } else {
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        String str4 = appsViewPagerFragment.isNotGameFormatString;
                        if (str4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("isNotGameFormatString");
                            str4 = null;
                        }
                        str = String.format(str4, Arrays.copyOf(new Object[]{str2}, 1));
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    DaijishouViewModel.setTips$default(model, str, false, 2, null);
                }
                ViewCompat.setElevation(this.itemView, 16.0f);
                Utils utils = Utils.INSTANCE;
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Utils.scaleView$default(utils, itemView, 1.0f, 1.03f, 0L, false, 24, null);
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocusClear(boolean isAbsoluteAdapterPositionValid) {
                super.onFocusClear(isAbsoluteAdapterPositionValid);
                ViewCompat.setElevation(this.itemView, 0.0f);
                if (isAbsoluteAdapterPositionValid) {
                    Utils utils = Utils.INSTANCE;
                    View itemView = this.itemView;
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    Utils.scaleView$default(utils, itemView, 1.03f, 1.0f, 0L, false, 24, null);
                }
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int position, ResolveInfo item) {
                Intrinsics.checkNotNullParameter(item, "item");
                String strResolveInfoToResolveInfoStringId = this.this$0.getAppsViewModel().resolveInfoToResolveInfoStringId(item);
                this.appLabel = this.this$0.getResolveInfoStringIdToLabelCache().get(strResolveInfoToResolveInfoStringId);
                this.isGame = this.this$0.getAppsViewModel().isResolveInfoStringIdFlagAsGame(strResolveInfoToResolveInfoStringId);
                this.appIconImageView.setImageBitmap(this.this$0.getResolveInfoStringIdToBitmapCache().get(strResolveInfoToResolveInfoStringId));
                this.appLabelView.setText(this.appLabel);
            }
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(requireActivity(), "requireActivity(...)");
        String string = getString(R.string.all_apps);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.only_games);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.modeNameStringList = CollectionsKt.listOf(new String[]{string, string2});
        String string3 = getString(R.string.ordered_by_alphabetic);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(R.string.ordered_by_reverse);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = getString(R.string.ordered_by_recent);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        this.sortingTypeStringList = CollectionsKt.listOf(new String[]{string3, string4, string5});
        Integer numValueOf = Integer.valueOf(R.drawable.round_sort_by_alpha_24);
        this.sortingTypeIconList = CollectionsKt.listOf(new Integer[]{numValueOf, numValueOf, Integer.valueOf(R.drawable.ic_round_sort_24)});
        String string6 = getString(R.string.options);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        this.optionsString = string6;
        String string7 = getString(R.string.copied);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        this.copiedString = string7;
        String string8 = getString(R.string.uninstall_format);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        this.uninstallFormatString = string8;
        String string9 = getString(R.string.uninstall_confirm_format);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        this.uninstallConfirmFormatString = string9;
        String string10 = getString(R.string.flag_as_not_game_formant);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        this.flagAsNotGameFormatString = string10;
        String string11 = getString(R.string.flag_as_game_formant);
        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
        this.flagAsGameFormatString = string11;
        String string12 = getString(R.string.view_activities);
        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
        this.viewActivitiesString = string12;
        String string13 = getString(R.string.view_application_info);
        Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
        this.applicationInfoString = string13;
        String string14 = getString(R.string.activities_format);
        Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
        this.activitiesFormatString = string14;
        String string15 = getString(R.string.is_game_format);
        Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
        this.isGameFormatString = string15;
        String string16 = getString(R.string.is_not_game_format);
        Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
        this.isNotGameFormatString = string16;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        View viewInflate = inflater.inflate(R.layout.view_pager_fragment_apps, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.apps_title_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.titleLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.apps_grid);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        DaijishouRecyclerView daijishouRecyclerView = (DaijishouRecyclerView) viewFindViewById2;
        this.recyclerView = daijishouRecyclerView;
        DaijishouRecyclerView daijishouRecyclerView2 = null;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView = null;
        }
        daijishouRecyclerView.setItemAnimator(null);
        this.recyclerViewAdapter = new AppsRecyclerViewAdapter(this, this.resolveInfoCollectionInRecyclerView);
        this.gridLayoutManager = new DaijishouGridLayoutManager(contextRequireContext, 96.0f, 6, 28.0f, false, 16, null);
        View viewFindViewById3 = viewInflate.findViewById(R.id.apps_mode_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.modeButton = (MaterialButton) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.apps_sort_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.sortButton = (MaterialButton) viewFindViewById4;
        ConstraintLayout constraintLayout = this.titleLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout = null;
        }
        constraintLayout.setOnClickListener(new AppsViewPagerFragment$$ExternalSyntheticLambda0(this));
        MaterialButton materialButton = this.modeButton;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modeButton");
            materialButton = null;
        }
        List<String> list = this.modeNameStringList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modeNameStringList");
            list = null;
        }
        materialButton.setText(list.get(getAppsViewModel().getItemsMode()));
        MaterialButton materialButton2 = this.modeButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modeButton");
            materialButton2 = null;
        }
        materialButton2.setOnClickListener(new AppsViewPagerFragment$$ExternalSyntheticLambda1(this));
        MaterialButton materialButton3 = this.sortButton;
        if (materialButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortButton");
            materialButton3 = null;
        }
        List<String> list2 = this.sortingTypeStringList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortingTypeStringList");
            list2 = null;
        }
        materialButton3.setText(list2.get(getAppsViewModel().getSortingMode()));
        MaterialButton materialButton4 = this.sortButton;
        if (materialButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortButton");
            materialButton4 = null;
        }
        List<Integer> list3 = this.sortingTypeIconList;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortingTypeIconList");
            list3 = null;
        }
        materialButton4.setIconResource(list3.get(getAppsViewModel().getSortingMode()).intValue());
        MaterialButton materialButton5 = this.sortButton;
        if (materialButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortButton");
            materialButton5 = null;
        }
        materialButton5.setOnClickListener(new AppsViewPagerFragment$$ExternalSyntheticLambda2(this));
        AppsRecyclerViewAdapter appsRecyclerViewAdapter = this.recyclerViewAdapter;
        if (appsRecyclerViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            appsRecyclerViewAdapter = null;
        }
        appsRecyclerViewAdapter.setOnItemClickListener(new AnonymousClass4(fragmentActivityRequireActivity));
        AppsRecyclerViewAdapter appsRecyclerViewAdapter2 = this.recyclerViewAdapter;
        if (appsRecyclerViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            appsRecyclerViewAdapter2 = null;
        }
        appsRecyclerViewAdapter2.setOnItemLongClickListener(new AnonymousClass5());
        DaijishouRecyclerView daijishouRecyclerView3 = this.recyclerView;
        if (daijishouRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView3 = null;
        }
        DaijishouGridLayoutManager daijishouGridLayoutManager = this.gridLayoutManager;
        if (daijishouGridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
            daijishouGridLayoutManager = null;
        }
        daijishouRecyclerView3.setLayoutManager(daijishouGridLayoutManager);
        DaijishouRecyclerView daijishouRecyclerView4 = this.recyclerView;
        if (daijishouRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView4 = null;
        }
        AppsRecyclerViewAdapter appsRecyclerViewAdapter3 = this.recyclerViewAdapter;
        if (appsRecyclerViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            appsRecyclerViewAdapter3 = null;
        }
        daijishouRecyclerView4.setAdapter(appsRecyclerViewAdapter3);
        DaijishouRecyclerView daijishouRecyclerView5 = this.recyclerView;
        if (daijishouRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView5 = null;
        }
        daijishouRecyclerView5.requestLayout();
        DaijishouRecyclerView daijishouRecyclerView6 = this.recyclerView;
        if (daijishouRecyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            daijishouRecyclerView2 = daijishouRecyclerView6;
        }
        daijishouRecyclerView2.addOnScrollListener(new AnonymousClass6());
        getAppsViewModel().getPackageResolveInfoListLiveData().observe(getViewLifecycleOwner(), new AppsViewPagerFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass7()));
        return viewInflate;
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(AppsViewPagerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DaijishouRecyclerView daijishouRecyclerView = this$0.recyclerView;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView = null;
        }
        daijishouRecyclerView.smoothScrollToPosition(0);
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2(AppsViewPagerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAppsViewModel().toggleNextItemsMode();
        MaterialButton materialButton = this$0.modeButton;
        List<String> list = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modeButton");
            materialButton = null;
        }
        List<String> list2 = this$0.modeNameStringList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modeNameStringList");
        } else {
            list = list2;
        }
        materialButton.setText(list.get(this$0.getAppsViewModel().getItemsMode()));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3(AppsViewPagerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAppsViewModel().toggleNextSortingMode();
        MaterialButton materialButton = this$0.sortButton;
        List<Integer> list = null;
        if (materialButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortButton");
            materialButton = null;
        }
        List<String> list2 = this$0.sortingTypeStringList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortingTypeStringList");
            list2 = null;
        }
        materialButton.setText(list2.get(this$0.getAppsViewModel().getSortingMode()));
        MaterialButton materialButton2 = this$0.sortButton;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortButton");
            materialButton2 = null;
        }
        List<Integer> list3 = this$0.sortingTypeIconList;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortingTypeIconList");
        } else {
            list = list3;
        }
        materialButton2.setIconResource(list.get(this$0.getAppsViewModel().getSortingMode()).intValue());
    }

    /* INFO: renamed from: com.magneticchen.daijishou.view_pager_fragments.AppsViewPagerFragment$onCreateView$4, reason: invalid class name */
    /* INFO: compiled from: AppsViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass4 extends Lambda<Unit> implements Function4<View, Integer, Long, ResolveInfo, Unit> {
        final /* synthetic */ FragmentActivity $activity;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(FragmentActivity fragmentActivity) {
            super(4);
            this.$activity = fragmentActivity;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, ResolveInfo resolveInfo) {
            invoke(view, num.intValue(), l.longValue(), resolveInfo);
            return Unit.INSTANCE;
        }

        public final void invoke(View view, int i, long j, ResolveInfo resolveInfo) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(resolveInfo, "resolveInfo");
            AppsViewPagerFragment.this.getAppsViewModel().launchAppByResolveInfo(this.$activity, resolveInfo);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.view_pager_fragments.AppsViewPagerFragment$onCreateView$5, reason: invalid class name */
    /* INFO: compiled from: AppsViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "position", "", "<anonymous parameter 2>", "", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "invoke", "(Landroid/view/View;IJLandroid/content/pm/ResolveInfo;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass5 extends Lambda<Boolean> implements Function4<View, Integer, Long, ResolveInfo, Boolean> {
        AnonymousClass5() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Boolean invoke(View view, Integer num, Long l, ResolveInfo resolveInfo) {
            return invoke(view, num.intValue(), l.longValue(), resolveInfo);
        }

        public final Boolean invoke(View view, int i, long j, ResolveInfo resolveInfo) {
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(resolveInfo, "resolveInfo");
            AppsViewPagerFragment.this.showResolveInfoOptions(resolveInfo);
            return true;
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.view_pager_fragments.AppsViewPagerFragment$onCreateView$6, reason: invalid class name */
    /* INFO: compiled from: AppsViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/view_pager_fragments/AppsViewPagerFragment$onCreateView$6", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass6 extends RecyclerView.OnScrollListener {
        AnonymousClass6() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                AppsViewPagerFragment.this.scrollingOnBackPressed = false;
            }
            super.onScrollStateChanged(recyclerView, newState);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.view_pager_fragments.AppsViewPagerFragment$onCreateView$7, reason: invalid class name */
    /* INFO: compiled from: AppsViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "resolveInfoCollection", "", "Landroid/content/pm/ResolveInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass7 extends Lambda<Unit> implements Function1<List<ResolveInfo>, Unit> {
        AnonymousClass7() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<ResolveInfo> list) {
            invoke2(list);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ResolveInfo> list) {
            DaijishouRecyclerView daijishouRecyclerView = null;
            AppsRecyclerViewAdapter appsRecyclerViewAdapter = null;
            if (list.isEmpty()) {
                AppsViewPagerFragment.this.resolveInfoCollectionInRecyclerView.clear();
                AppsRecyclerViewAdapter appsRecyclerViewAdapter2 = AppsViewPagerFragment.this.recyclerViewAdapter;
                if (appsRecyclerViewAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                } else {
                    appsRecyclerViewAdapter = appsRecyclerViewAdapter2;
                }
                appsRecyclerViewAdapter.notifyDataSetChanged();
                return;
            }
            AppsViewPagerFragment appsViewPagerFragment = AppsViewPagerFragment.this;
            List list2 = appsViewPagerFragment.resolveInfoCollectionInRecyclerView;
            Intrinsics.checkNotNull(list);
            DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new ResolveInfoDiffUtilCallback(appsViewPagerFragment, list2, list));
            Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
            AppsViewPagerFragment.this.resolveInfoCollectionInRecyclerView.clear();
            AppsViewPagerFragment.this.resolveInfoCollectionInRecyclerView.addAll(list);
            AppsRecyclerViewAdapter appsRecyclerViewAdapter3 = AppsViewPagerFragment.this.recyclerViewAdapter;
            if (appsRecyclerViewAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                appsRecyclerViewAdapter3 = null;
            }
            diffResultCalculateDiff.dispatchUpdatesTo(appsRecyclerViewAdapter3);
            DaijishouRecyclerView daijishouRecyclerView2 = AppsViewPagerFragment.this.recyclerView;
            if (daijishouRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                daijishouRecyclerView = daijishouRecyclerView2;
            }
            daijishouRecyclerView.scrollToPosition(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Intrinsics.checkNotNullExpressionValue(requireActivity(), "requireActivity(...)");
    }
}
