package com.magneticchen.daijishou.ui.fragments.pager;

import android.app.Activity;
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
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouGridLayoutManager;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.ui.fragments.dialog.ListSelectDialogFragment;
import com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerFragment;
import com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerType;
import com.magneticchen.daijishou.ui.model.AppsViewModel;
import com.magneticchen.daijishou.ui.model.DaijishouViewModel;
import com.magneticchen.daijishou.utils.Utils;
import com.skydoves.balloon.internals.DefinitionKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: AppsViewPagerFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 S2\u00020\u0001:\u0003RSTB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010@\u001a\u000202H\u0016J\u0012\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J&\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010C\u001a\u0004\u0018\u00010DH\u0017J \u0010K\u001a\u0002022\u0006\u0010L\u001a\u00020\r2\u0006\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020B2\u0006\u0010Q\u001a\u000200H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000fR\u000e\u0010)\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u00060-R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\r0!X\u0082.¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u000202X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/pager/AppsViewPagerFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/ViewPagerFragment;", "()V", "activitiesFormatString", "", "applicationInfoString", "appsViewModel", "Lcom/magneticchen/daijishou/ui/model/AppsViewModel;", "getAppsViewModel", "()Lcom/magneticchen/daijishou/ui/model/AppsViewModel;", "appsViewModel$delegate", "Lkotlin/Lazy;", "backButtonDescriptionStringId", "", "getBackButtonDescriptionStringId", "()I", "copiedString", "displayNameStringId", "getDisplayNameStringId", "setDisplayNameStringId", "(I)V", "flagAsGameFormatString", "flagAsNotGameFormatString", "gridLayoutManager", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouGridLayoutManager;", "id", "getId", "()Ljava/lang/String;", "isGameFormatString", "isNotGameFormatString", "modeButton", "Lcom/google/android/material/button/MaterialButton;", "modeNameStringList", "", "model", "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "getModel", "()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;", "model$delegate", "nextFocusDown", "getNextFocusDown", "optionsString", "recyclerView", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView;", "recyclerViewAdapter", "Lcom/magneticchen/daijishou/ui/fragments/pager/AppsViewPagerFragment$AppsRecyclerViewAdapter;", "resolveInfoCollectionInRecyclerView", "", "Landroid/content/pm/ResolveInfo;", "scrollingOnBackPressed", "", "sortButton", "sortingTypeIconList", "sortingTypeStringList", "titleLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "uninstallConfirmFormatString", "uninstallFormatString", "useDefaultWallpaper", "getUseDefaultWallpaper", "()Z", "setUseDefaultWallpaper", "(Z)V", "viewActivitiesString", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHotKeyPressed", "hotkeyCode", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "showResolveInfoOptions", "resolveInfo", "AppsRecyclerViewAdapter", "Companion", "ResolveInfoDiffUtilCallback", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppsViewPagerFragment extends ViewPagerFragment {
    public static final Companion Companion = new Companion(null);
    private String activitiesFormatString;
    private String applicationInfoString;
    private final Lazy appsViewModel$delegate;
    private String copiedString;
    private String flagAsGameFormatString;
    private String flagAsNotGameFormatString;
    private DaijishouGridLayoutManager gridLayoutManager;
    private String isGameFormatString;
    private String isNotGameFormatString;
    private MaterialButton modeButton;
    private List<String> modeNameStringList;
    private final Lazy model$delegate;
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

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f49id = ViewPagerType.APPS.getId();
    private final int nextFocusDown = R.id.apps_title_layout;
    private int displayNameStringId = R.string.apps_page;
    private final int backButtonDescriptionStringId = R.string.go_top;
    private final List<ResolveInfo> resolveInfoCollectionInRecyclerView = new ArrayList();

    public AppsViewPagerFragment() {
        final AppsViewPagerFragment appsViewPagerFragment = this;
        final Function0 function0 = null;
        this.model$delegate = FragmentViewModelLazyKt.createViewModelLazy(appsViewPagerFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return appsViewPagerFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? appsViewPagerFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return appsViewPagerFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        this.appsViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(appsViewPagerFragment, Reflection.getOrCreateKotlinClass(AppsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment$special$$inlined$activityViewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return appsViewPagerFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? appsViewPagerFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment$special$$inlined$activityViewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return appsViewPagerFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: compiled from: AppsViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/pager/AppsViewPagerFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/pager/AppsViewPagerFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerFragment
    public String getId() {
        return this.f49id;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerFragment
    public int getNextFocusDown() {
        return this.nextFocusDown;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerFragment
    public int getDisplayNameStringId() {
        return this.displayNameStringId;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerFragment
    public void setDisplayNameStringId(int i) {
        this.displayNameStringId = i;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerFragment
    public int getBackButtonDescriptionStringId() {
        return this.backButtonDescriptionStringId;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerFragment
    public boolean getUseDefaultWallpaper() {
        return this.useDefaultWallpaper;
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.ViewPagerFragment
    public void setUseDefaultWallpaper(boolean z) {
        this.useDefaultWallpaper = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DaijishouViewModel getModel() {
        return (DaijishouViewModel) this.model$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppsViewModel getAppsViewModel() {
        return (AppsViewModel) this.appsViewModel$delegate.getValue();
    }

    /* JADX INFO: compiled from: AppsViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/pager/AppsViewPagerFragment$ResolveInfoDiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Landroid/content/pm/ResolveInfo;", "newList", "(Lcom/magneticchen/daijishou/ui/fragments/pager/AppsViewPagerFragment;Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_release", "appsViewModel", "Lcom/magneticchen/daijishou/ui/model/AppsViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ResolveInfoDiffUtilCallback extends DiffUtil.Callback {
        private final List<ResolveInfo> newList;
        private final List<ResolveInfo> oldList;
        final /* synthetic */ AppsViewPagerFragment this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public ResolveInfoDiffUtilCallback(AppsViewPagerFragment appsViewPagerFragment, List<? extends ResolveInfo> oldList, List<? extends ResolveInfo> newList) {
            Intrinsics.checkNotNullParameter(oldList, "oldList");
            Intrinsics.checkNotNullParameter(newList, "newList");
            this.this$0 = appsViewPagerFragment;
            this.oldList = oldList;
            this.newList = newList;
        }

        public int getOldListSize() {
            return this.oldList.size();
        }

        public int getNewListSize() {
            return this.newList.size();
        }

        private static final AppsViewModel areItemsTheSame$lambda$0(Lazy<AppsViewModel> lazy) {
            return lazy.getValue();
        }

        public boolean areItemsTheSame(int i, int i2) {
            ComponentActivity componentActivityRequireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(componentActivityRequireActivity, "requireActivity(...)");
            final ComponentActivity componentActivity = componentActivityRequireActivity;
            final Function0 function0 = null;
            Lazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AppsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment$ResolveInfoDiffUtilCallback$areItemsTheSame$$inlined$viewModels$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ViewModelStore invoke() {
                    return componentActivity.getViewModelStore();
                }
            }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment$ResolveInfoDiffUtilCallback$areItemsTheSame$$inlined$viewModels$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ViewModelProvider.Factory invoke() {
                    return componentActivity.getDefaultViewModelProviderFactory();
                }
            }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment$ResolveInfoDiffUtilCallback$areItemsTheSame$$inlined$viewModels$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final CreationExtras invoke() {
                    CreationExtras creationExtras;
                    Function0 function1 = function0;
                    return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
                }
            });
            return Intrinsics.areEqual(areItemsTheSame$lambda$0(viewModelLazy).resolveInfoToResolveInfoStringId(this.newList.get(i2)), areItemsTheSame$lambda$0(viewModelLazy).resolveInfoToResolveInfoStringId(this.oldList.get(i)));
        }

        public boolean areContentsTheSame(int i, int i2) {
            return Intrinsics.areEqual(this.newList.get(i2), this.oldList.get(i));
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public boolean onHotKeyPressed(int i, int i2, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(i, i2, keyEvent);
        AppsRecyclerViewAdapter appsRecyclerViewAdapter = null;
        if (i == 1) {
            DaijishouRecyclerView daijishouRecyclerView = this.recyclerView;
            if (daijishouRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView = null;
            }
            daijishouRecyclerView.scrollToPosition(0);
            MaterialButton materialButton = this.modeButton;
            if (materialButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("modeButton");
                materialButton = null;
            }
            materialButton.requestFocus();
            AppsRecyclerViewAdapter appsRecyclerViewAdapter2 = this.modeButton;
            if (appsRecyclerViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("modeButton");
            } else {
                appsRecyclerViewAdapter = appsRecyclerViewAdapter2;
            }
            appsRecyclerViewAdapter.performClick();
            return true;
        }
        if (i == 2) {
            onBackPressed();
            return true;
        }
        if (i == 3) {
            DaijishouRecyclerView daijishouRecyclerView2 = this.recyclerView;
            if (daijishouRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView2 = null;
            }
            daijishouRecyclerView2.scrollToPosition(0);
            MaterialButton materialButton2 = this.sortButton;
            if (materialButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sortButton");
                materialButton2 = null;
            }
            materialButton2.requestFocus();
            AppsRecyclerViewAdapter appsRecyclerViewAdapter3 = this.sortButton;
            if (appsRecyclerViewAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sortButton");
            } else {
                appsRecyclerViewAdapter = appsRecyclerViewAdapter3;
            }
            appsRecyclerViewAdapter.performClick();
            return true;
        }
        if (i != 4) {
            return false;
        }
        List list = (List) getAppsViewModel().getPackageResolveInfoListLiveData().getValue();
        if (list != null) {
            AppsRecyclerViewAdapter appsRecyclerViewAdapter4 = this.recyclerViewAdapter;
            if (appsRecyclerViewAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                appsRecyclerViewAdapter4 = null;
            }
            if (appsRecyclerViewAdapter4.getSelectedPosition() >= 0) {
                AppsRecyclerViewAdapter appsRecyclerViewAdapter5 = this.recyclerViewAdapter;
                if (appsRecyclerViewAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                    appsRecyclerViewAdapter5 = null;
                }
                if (appsRecyclerViewAdapter5.getSelectedPosition() < list.size()) {
                    AppsRecyclerViewAdapter appsRecyclerViewAdapter6 = this.recyclerViewAdapter;
                    if (appsRecyclerViewAdapter6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                    } else {
                        appsRecyclerViewAdapter = appsRecyclerViewAdapter6;
                    }
                    showResolveInfoOptions((ResolveInfo) list.get(appsRecyclerViewAdapter.getSelectedPosition()));
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    /* JADX WARN: Code duplicated, block: B:32:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0071  */
    /* JADX WARN: Code duplicated, block: B:9:0x001a  */
    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void showResolveInfoOptions(ResolveInfo resolveInfo) {
        String str;
        String str2;
        String str3;
        final PackageManager packageManager = requireActivity().getPackageManager();
        final String str4 = resolveInfo.activityInfo.packageName;
        final String strResolveInfoToResolveInfoStringId = getAppsViewModel().resolveInfoToResolveInfoStringId(resolveInfo);
        final CharSequence charSequenceLoadLabel = resolveInfo.loadLabel(packageManager);
        Intrinsics.checkNotNullExpressionValue(charSequenceLoadLabel, "loadLabel(...)");
        boolean zIsResolveInfoStringIdFlagAsGame = getAppsViewModel().isResolveInfoStringIdFlagAsGame(strResolveInfoToResolveInfoStringId);
        ListSelectDialogFragment.Companion companion = ListSelectDialogFragment.Companion;
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
        final ListSelectDialogFragment listSelectDialogFragmentNewInstance$default = ListSelectDialogFragment.Companion.newInstance$default(companion, str, CollectionsKt.arrayListOf(strArr), null, false, 12, null);
        listSelectDialogFragmentNewInstance$default.setOnSelectListener(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment.showResolveInfoOptions.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) throws PackageManager.NameNotFoundException {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) throws PackageManager.NameNotFoundException {
                if (i == 0) {
                    Intent intent = new Intent("android.intent.action.DELETE");
                    intent.setData(Uri.parse("package:" + str4));
                    this.startActivity(intent);
                } else if (i == 1) {
                    this.getAppsViewModel().toggleResolveInfoStringIdFlagAsGame(strResolveInfoToResolveInfoStringId);
                } else if (i == 2) {
                    PackageInfo packageInfo = packageManager.getPackageInfo(str4, 1);
                    final ArrayList arrayList = new ArrayList();
                    ActivityInfo[] activityInfoArr = packageInfo.activities;
                    if (activityInfoArr != null) {
                        String str12 = str4;
                        for (ActivityInfo activityInfo : activityInfoArr) {
                            arrayList.add(str12 + "/" + activityInfo.name);
                        }
                    }
                    ListSelectDialogFragment.Companion companion2 = ListSelectDialogFragment.Companion;
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    String str13 = this.activitiesFormatString;
                    if (str13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("activitiesFormatString");
                        str13 = null;
                    }
                    String str14 = String.format(str13, Arrays.copyOf(new Object[]{charSequenceLoadLabel}, 1));
                    Intrinsics.checkNotNullExpressionValue(str14, "format(...)");
                    final ListSelectDialogFragment listSelectDialogFragmentNewInstance$default2 = ListSelectDialogFragment.Companion.newInstance$default(companion2, str14, arrayList, null, false, 12, null);
                    final AppsViewPagerFragment appsViewPagerFragment = this;
                    listSelectDialogFragmentNewInstance$default2.setOnSelectListener(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment.showResolveInfoOptions.1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i2) {
                            Object systemService = appsViewPagerFragment.requireActivity().getSystemService("clipboard");
                            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("activity", arrayList.get(i2)));
                            listSelectDialogFragmentNewInstance$default2.dismiss();
                            Context context = appsViewPagerFragment.getContext();
                            String str15 = appsViewPagerFragment.copiedString;
                            if (str15 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("copiedString");
                                str15 = null;
                            }
                            Toast.makeText(context, str15, 0).show();
                        }
                    }).show(this.getChildFragmentManager(), ListSelectDialogFragment.class.getName());
                } else if (i == 3) {
                    Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent2.addCategory("android.intent.category.DEFAULT");
                    intent2.setData(Uri.parse("package:" + str4));
                    this.startActivity(intent2);
                }
                listSelectDialogFragmentNewInstance$default.dismiss();
            }
        });
        listSelectDialogFragmentNewInstance$default.show(getChildFragmentManager(), ListSelectDialogFragment.class.getName());
    }

    /* JADX INFO: compiled from: AppsViewPagerFragment.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\"\u0010\u001b\u001a\f0\u001cR\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R-\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0013j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/pager/AppsViewPagerFragment$AppsRecyclerViewAdapter;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Landroid/content/pm/ResolveInfo;", "packageResolveInfoList", "", "(Lcom/magneticchen/daijishou/ui/fragments/pager/AppsViewPagerFragment;Ljava/util/List;)V", "appsViewModel", "Lcom/magneticchen/daijishou/ui/model/AppsViewModel;", "getAppsViewModel", "()Lcom/magneticchen/daijishou/ui/model/AppsViewModel;", "appsViewModel$delegate", "Lkotlin/Lazy;", "resolveInfoStringIdToBitmapCache", "Lcom/magneticchen/daijishou/utils/Utils$MaxSizeHashMap;", "", "Landroid/graphics/Bitmap;", "getResolveInfoStringIdToBitmapCache", "()Lcom/magneticchen/daijishou/utils/Utils$MaxSizeHashMap;", "resolveInfoStringIdToLabelCache", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getResolveInfoStringIdToLabelCache", "()Ljava/util/HashMap;", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class AppsRecyclerViewAdapter extends DaijishouRecyclerView.Adapter<ResolveInfo> {
        private final Lazy appsViewModel$delegate;
        private final List<ResolveInfo> packageResolveInfoList;
        private final Utils.MaxSizeHashMap<String, Bitmap> resolveInfoStringIdToBitmapCache;
        private final HashMap<String, String> resolveInfoStringIdToLabelCache;
        final /* synthetic */ AppsViewPagerFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppsRecyclerViewAdapter(AppsViewPagerFragment appsViewPagerFragment, List<ResolveInfo> packageResolveInfoList) {
            super(packageResolveInfoList, false, false, 6, null);
            Intrinsics.checkNotNullParameter(packageResolveInfoList, "packageResolveInfoList");
            this.this$0 = appsViewPagerFragment;
            this.packageResolveInfoList = packageResolveInfoList;
            final AppsViewPagerFragment appsViewPagerFragment2 = appsViewPagerFragment;
            final Function0 function0 = null;
            this.appsViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(appsViewPagerFragment2, Reflection.getOrCreateKotlinClass(AppsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment$AppsRecyclerViewAdapter$special$$inlined$activityViewModels$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ViewModelStore invoke() {
                    return appsViewPagerFragment2.requireActivity().getViewModelStore();
                }
            }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment$AppsRecyclerViewAdapter$special$$inlined$activityViewModels$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final CreationExtras invoke() {
                    CreationExtras creationExtras;
                    Function0 function1 = function0;
                    return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? appsViewPagerFragment2.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
                }
            }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment$AppsRecyclerViewAdapter$special$$inlined$activityViewModels$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ViewModelProvider.Factory invoke() {
                    return appsViewPagerFragment2.requireActivity().getDefaultViewModelProviderFactory();
                }
            });
            this.resolveInfoStringIdToBitmapCache = getAppsViewModel().getResolveInfoStringIdToBitmapCache();
            this.resolveInfoStringIdToLabelCache = getAppsViewModel().getResolveInfoStringIdToLabelCache();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AppsViewModel getAppsViewModel() {
            return (AppsViewModel) this.appsViewModel$delegate.getValue();
        }

        public final Utils.MaxSizeHashMap<String, Bitmap> getResolveInfoStringIdToBitmapCache() {
            return this.resolveInfoStringIdToBitmapCache;
        }

        public final HashMap<String, String> getResolveInfoStringIdToLabelCache() {
            return this.resolveInfoStringIdToLabelCache;
        }

        public DaijishouRecyclerView.Adapter<ResolveInfo>.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_app, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }

        public long getItemId(int i) {
            return this.packageResolveInfoList.get(i).activityInfo.hashCode();
        }

        /* JADX INFO: compiled from: AppsViewPagerFragment.kt */
        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/pager/AppsViewPagerFragment$AppsRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Landroid/content/pm/ResolveInfo;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/fragments/pager/AppsViewPagerFragment$AppsRecyclerViewAdapter;Landroid/view/View;)V", "appIconImageView", "Landroid/widget/ImageView;", "getAppIconImageView", "()Landroid/widget/ImageView;", "appLabel", "", "getAppLabel", "()Ljava/lang/String;", "setAppLabel", "(Ljava/lang/String;)V", "appLabelView", "Landroid/widget/TextView;", "getAppLabelView", "()Landroid/widget/TextView;", "isGame", "", "()Z", "setGame", "(Z)V", "onBind", "", "position", "", "item", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<ResolveInfo>.ViewHolder {
            private final ImageView appIconImageView;
            private String appLabel;
            private final TextView appLabelView;
            private boolean isGame;
            final /* synthetic */ AppsRecyclerViewAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                this.appLabel = "App";
            }

            public final ImageView getAppIconImageView() {
                return this.appIconImageView;
            }

            public final TextView getAppLabelView() {
                return this.appLabelView;
            }

            public final String getAppLabel() {
                return this.appLabel;
            }

            public final void setAppLabel(String str) {
                this.appLabel = str;
            }

            public final boolean isGame() {
                return this.isGame;
            }

            public final void setGame(boolean z) {
                this.isGame = z;
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
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

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocusClear(boolean z) {
                super.onFocusClear(z);
                ViewCompat.setElevation(this.itemView, DefinitionKt.NO_Float_VALUE);
                if (z) {
                    Utils utils = Utils.INSTANCE;
                    View itemView = this.itemView;
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    Utils.scaleView$default(utils, itemView, 1.03f, 1.0f, 0L, false, 24, null);
                }
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int i, ResolveInfo item) {
                Intrinsics.checkNotNullParameter(item, "item");
                String strResolveInfoToResolveInfoStringId = this.this$0.getAppsViewModel().resolveInfoToResolveInfoStringId(item);
                this.appLabel = this.this$0.getResolveInfoStringIdToLabelCache().get(strResolveInfoToResolveInfoStringId);
                this.isGame = this.this$0.getAppsViewModel().isResolveInfoStringIdFlagAsGame(strResolveInfoToResolveInfoStringId);
                this.appIconImageView.setImageBitmap(this.this$0.getResolveInfoStringIdToBitmapCache().get(strResolveInfoToResolveInfoStringId));
                this.appLabelView.setText(this.appLabel);
            }
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.string.all_apps);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.only_games);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.modeNameStringList = CollectionsKt.listOf((Object[]) new String[]{string, string2});
        String string3 = getString(R.string.ordered_by_alphabetic);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(R.string.ordered_by_reverse);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = getString(R.string.ordered_by_recent);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        this.sortingTypeStringList = CollectionsKt.listOf((Object[]) new String[]{string3, string4, string5});
        Integer numValueOf = Integer.valueOf(R.drawable.round_sort_by_alpha_24);
        this.sortingTypeIconList = CollectionsKt.listOf((Object[]) new Integer[]{numValueOf, numValueOf, Integer.valueOf(R.drawable.ic_round_sort_24)});
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

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        View viewInflate = inflater.inflate(R.layout.view_pager_fragment_apps, viewGroup, false);
        ConstraintLayout constraintLayoutFindViewById = viewInflate.findViewById(R.id.apps_title_layout);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
        this.titleLayout = constraintLayoutFindViewById;
        Object objFindViewById = viewInflate.findViewById(R.id.apps_grid);
        Intrinsics.checkNotNullExpressionValue(objFindViewById, "findViewById(...)");
        DaijishouRecyclerView daijishouRecyclerView = (DaijishouRecyclerView) objFindViewById;
        this.recyclerView = daijishouRecyclerView;
        DaijishouRecyclerView daijishouRecyclerView2 = null;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView = null;
        }
        daijishouRecyclerView.setItemAnimator(null);
        this.recyclerViewAdapter = new AppsRecyclerViewAdapter(this, this.resolveInfoCollectionInRecyclerView);
        this.gridLayoutManager = new DaijishouGridLayoutManager(contextRequireContext, 96.0f, 6, 28.0f, false, 16, null);
        MaterialButton materialButtonFindViewById = viewInflate.findViewById(R.id.apps_mode_button);
        Intrinsics.checkNotNullExpressionValue(materialButtonFindViewById, "findViewById(...)");
        this.modeButton = materialButtonFindViewById;
        MaterialButton materialButtonFindViewById2 = viewInflate.findViewById(R.id.apps_sort_button);
        Intrinsics.checkNotNullExpressionValue(materialButtonFindViewById2, "findViewById(...)");
        this.sortButton = materialButtonFindViewById2;
        ConstraintLayout constraintLayout = this.titleLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleLayout");
            constraintLayout = null;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppsViewPagerFragment.onCreateView$lambda$1(this.f$0, view);
            }
        });
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
        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppsViewPagerFragment.onCreateView$lambda$2(this.f$0, view);
            }
        });
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
        materialButton5.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppsViewPagerFragment.onCreateView$lambda$3(this.f$0, view);
            }
        });
        AppsRecyclerViewAdapter appsRecyclerViewAdapter = this.recyclerViewAdapter;
        if (appsRecyclerViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            appsRecyclerViewAdapter = null;
        }
        appsRecyclerViewAdapter.setOnItemClickListener(new Function4<View, Integer, Long, ResolveInfo, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment.onCreateView.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, ResolveInfo resolveInfo) {
                invoke(view, num.intValue(), l.longValue(), resolveInfo);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i, long j, ResolveInfo resolveInfo) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(resolveInfo, "resolveInfo");
                AppsViewPagerFragment.this.getAppsViewModel().launchAppByResolveInfo((Activity) fragmentActivityRequireActivity, resolveInfo);
            }
        });
        AppsRecyclerViewAdapter appsRecyclerViewAdapter2 = this.recyclerViewAdapter;
        if (appsRecyclerViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            appsRecyclerViewAdapter2 = null;
        }
        appsRecyclerViewAdapter2.setOnItemLongClickListener(new Function4<View, Integer, Long, ResolveInfo, Boolean>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment.onCreateView.5
            

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
        });
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
        daijishouRecyclerView3.setLayoutManager((RecyclerView.LayoutManager) daijishouGridLayoutManager);
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
        daijishouRecyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment.onCreateView.6
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (i == 0) {
                    AppsViewPagerFragment.this.scrollingOnBackPressed = false;
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        });
        getAppsViewModel().getPackageResolveInfoListLiveData().observe(getViewLifecycleOwner(), new AppsViewPagerFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<ResolveInfo>, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment.onCreateView.7
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<ResolveInfo> list4) {
                invoke2(list4);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ResolveInfo> list4) {
                DaijishouRecyclerView daijishouRecyclerView7 = null;
                AppsRecyclerViewAdapter appsRecyclerViewAdapter4 = null;
                if (list4.isEmpty()) {
                    AppsViewPagerFragment.this.resolveInfoCollectionInRecyclerView.clear();
                    AppsRecyclerViewAdapter appsRecyclerViewAdapter5 = AppsViewPagerFragment.this.recyclerViewAdapter;
                    if (appsRecyclerViewAdapter5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                    } else {
                        appsRecyclerViewAdapter4 = appsRecyclerViewAdapter5;
                    }
                    appsRecyclerViewAdapter4.notifyDataSetChanged();
                    return;
                }
                AppsViewPagerFragment appsViewPagerFragment = AppsViewPagerFragment.this;
                List list5 = appsViewPagerFragment.resolveInfoCollectionInRecyclerView;
                Intrinsics.checkNotNull(list4);
                DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new ResolveInfoDiffUtilCallback(appsViewPagerFragment, list5, list4));
                Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
                AppsViewPagerFragment.this.resolveInfoCollectionInRecyclerView.clear();
                AppsViewPagerFragment.this.resolveInfoCollectionInRecyclerView.addAll(list4);
                AppsRecyclerViewAdapter appsRecyclerViewAdapter6 = AppsViewPagerFragment.this.recyclerViewAdapter;
                if (appsRecyclerViewAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                    appsRecyclerViewAdapter6 = null;
                }
                diffResultCalculateDiff.dispatchUpdatesTo(appsRecyclerViewAdapter6);
                DaijishouRecyclerView daijishouRecyclerView8 = AppsViewPagerFragment.this.recyclerView;
                if (daijishouRecyclerView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    daijishouRecyclerView7 = daijishouRecyclerView8;
                }
                daijishouRecyclerView7.scrollToPosition(0);
            }
        }));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(AppsViewPagerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DaijishouRecyclerView daijishouRecyclerView = this$0.recyclerView;
        if (daijishouRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            daijishouRecyclerView = null;
        }
        daijishouRecyclerView.smoothScrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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
}
