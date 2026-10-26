package com.magneticchen.daijishou.abstract_fragment_classes;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.preference.PreferenceFragmentCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager;
import com.magneticchen.daijishou.utils.DpToPxConverter;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* INFO: compiled from: DaijishouPreferenceFragmentCompat.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00101\u001a\u000200H\u0016J\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u000203H\u0016J\u001a\u00107\u001a\u0002032\u0006\u00108\u001a\u0002092\b\u00104\u001a\u0004\u0018\u000105H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00060$R\u00020\u0004X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouPreferenceFragmentCompat;", "Landroidx/preference/PreferenceFragmentCompat;", "()V", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "setApplication", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "daijishouLibrary", "Lcom/magneticchen/daijishou/view_models/DaijishouLibraryModel;", "getDaijishouLibrary", "()Lcom/magneticchen/daijishou/view_models/DaijishouLibraryModel;", "setDaijishouLibrary", "(Lcom/magneticchen/daijishou/view_models/DaijishouLibraryModel;)V", "daijishouSynchronization", "Lcom/magneticchen/daijishou/view_models/DaijishouSynchronizationModel;", "getDaijishouSynchronization", "()Lcom/magneticchen/daijishou/view_models/DaijishouSynchronizationModel;", "setDaijishouSynchronization", "(Lcom/magneticchen/daijishou/view_models/DaijishouSynchronizationModel;)V", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "getDefaultSharedPreferences", "()Landroid/content/SharedPreferences;", "setDefaultSharedPreferences", "(Landroid/content/SharedPreferences;)V", "dpToPxConverter", "Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "getDpToPxConverter", "()Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "setDpToPxConverter", "(Lcom/magneticchen/daijishou/utils/DpToPxConverter;)V", "lastFocusedPosition", "", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "setLogger", "(Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;)V", "retroAchievementsManager", "Lcom/magneticchen/daijishou/retro_achievements/RetroAchievementsManager;", "getRetroAchievementsManager", "()Lcom/magneticchen/daijishou/retro_achievements/RetroAchievementsManager;", "setRetroAchievementsManager", "(Lcom/magneticchen/daijishou/retro_achievements/RetroAchievementsManager;)V", "scrollingOnBackPressed", "", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "onViewCreated", "view", "Landroid/view/View;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class DaijishouPreferenceFragmentCompat extends PreferenceFragmentCompat {
    protected DaijishouApplication application;
    protected DaijishouLibraryModel daijishouLibrary;
    protected DaijishouSynchronizationModel daijishouSynchronization;
    protected SharedPreferences defaultSharedPreferences;
    protected DpToPxConverter dpToPxConverter;
    private int lastFocusedPosition = -1;
    protected DaijishouApplication.WrappedLogger logger;
    protected RetroAchievementsManager retroAchievementsManager;
    private boolean scrollingOnBackPressed;

    public final DaijishouApplication getApplication() {
        DaijishouApplication daijishouApplication = this.application;
        if (daijishouApplication != null) {
            return daijishouApplication;
        }
        Intrinsics.throwUninitializedPropertyAccessException("application");
        return null;
    }

    protected final void setApplication(DaijishouApplication daijishouApplication) {
        Intrinsics.checkNotNullParameter(daijishouApplication, "<set-?>");
        this.application = daijishouApplication;
    }

    protected final DaijishouApplication.WrappedLogger getLogger() {
        DaijishouApplication.WrappedLogger wrappedLogger = this.logger;
        if (wrappedLogger != null) {
            return wrappedLogger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    protected final void setLogger(DaijishouApplication.WrappedLogger wrappedLogger) {
        Intrinsics.checkNotNullParameter(wrappedLogger, "<set-?>");
        this.logger = wrappedLogger;
    }

    public final DaijishouLibraryModel getDaijishouLibrary() {
        DaijishouLibraryModel daijishouLibraryModel = this.daijishouLibrary;
        if (daijishouLibraryModel != null) {
            return daijishouLibraryModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("daijishouLibrary");
        return null;
    }

    protected final void setDaijishouLibrary(DaijishouLibraryModel daijishouLibraryModel) {
        Intrinsics.checkNotNullParameter(daijishouLibraryModel, "<set-?>");
        this.daijishouLibrary = daijishouLibraryModel;
    }

    protected final RetroAchievementsManager getRetroAchievementsManager() {
        RetroAchievementsManager retroAchievementsManager = this.retroAchievementsManager;
        if (retroAchievementsManager != null) {
            return retroAchievementsManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsManager");
        return null;
    }

    protected final void setRetroAchievementsManager(RetroAchievementsManager retroAchievementsManager) {
        Intrinsics.checkNotNullParameter(retroAchievementsManager, "<set-?>");
        this.retroAchievementsManager = retroAchievementsManager;
    }

    protected final DaijishouSynchronizationModel getDaijishouSynchronization() {
        DaijishouSynchronizationModel daijishouSynchronizationModel = this.daijishouSynchronization;
        if (daijishouSynchronizationModel != null) {
            return daijishouSynchronizationModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("daijishouSynchronization");
        return null;
    }

    protected final void setDaijishouSynchronization(DaijishouSynchronizationModel daijishouSynchronizationModel) {
        Intrinsics.checkNotNullParameter(daijishouSynchronizationModel, "<set-?>");
        this.daijishouSynchronization = daijishouSynchronizationModel;
    }

    public final SharedPreferences getDefaultSharedPreferences() {
        SharedPreferences sharedPreferences = this.defaultSharedPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        Intrinsics.throwUninitializedPropertyAccessException("defaultSharedPreferences");
        return null;
    }

    protected final void setDefaultSharedPreferences(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<set-?>");
        this.defaultSharedPreferences = sharedPreferences;
    }

    protected final DpToPxConverter getDpToPxConverter() {
        DpToPxConverter dpToPxConverter = this.dpToPxConverter;
        if (dpToPxConverter != null) {
            return dpToPxConverter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dpToPxConverter");
        return null;
    }

    protected final void setDpToPxConverter(DpToPxConverter dpToPxConverter) {
        Intrinsics.checkNotNullParameter(dpToPxConverter, "<set-?>");
        this.dpToPxConverter = dpToPxConverter;
    }

    public boolean onBackPressed() {
        if ((this.scrollingOnBackPressed && getListView().getScrollState() == 2) || getListView().computeVerticalScrollOffset() == 0) {
            getListView().scrollToPosition(0);
            return true;
        }
        this.scrollingOnBackPressed = true;
        getListView().addOnScrollListener(new AnonymousClass1());
        getListView().clearFocus();
        getListView().smoothScrollToPosition(0);
        return false;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragmentCompat$onBackPressed$1, reason: invalid class name */
    /* INFO: compiled from: DaijishouPreferenceFragmentCompat.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/abstract_fragment_classes/DaijishouPreferenceFragmentCompat$onBackPressed$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass1 extends RecyclerView.OnScrollListener {
        AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                RecyclerView.LayoutManager layoutManager = DaijishouPreferenceFragmentCompat.this.getListView().getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                int iFindFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                RecyclerView.LayoutManager layoutManager2 = DaijishouPreferenceFragmentCompat.this.getListView().getLayoutManager();
                Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                int iFindLastVisibleItemPosition = ((LinearLayoutManager) layoutManager2).findLastVisibleItemPosition();
                if (iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition) {
                    while (true) {
                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = DaijishouPreferenceFragmentCompat.this.getListView().findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
                        View view = viewHolderFindViewHolderForAdapterPosition != null ? viewHolderFindViewHolderForAdapterPosition.itemView : null;
                        if (view != null && view.isFocusable()) {
                            view.requestFocus();
                            break;
                        } else if (iFindFirstVisibleItemPosition == iFindLastVisibleItemPosition) {
                            break;
                        } else {
                            iFindFirstVisibleItemPosition++;
                        }
                    }
                }
                DaijishouPreferenceFragmentCompat.this.getListView().removeOnScrollListener(this);
            }
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaijishouPreferenceFragmentCompat daijishouPreferenceFragmentCompat = this;
        Lazy lazyCreateViewModelLazy = FragmentViewModelLazyKt.createViewModelLazy(daijishouPreferenceFragmentCompat, Reflection.getOrCreateKotlinClass(DaijishouLibraryModel.class), new DaijishouPreferenceFragmentCompat$onCreate$$inlined$activityViewModels$default$1(daijishouPreferenceFragmentCompat), new DaijishouPreferenceFragmentCompat$onCreate$$inlined$activityViewModels$default$2(null, daijishouPreferenceFragmentCompat), new DaijishouPreferenceFragmentCompat$onCreate$$inlined$activityViewModels$default$3(daijishouPreferenceFragmentCompat));
        Lazy lazyCreateViewModelLazy2 = FragmentViewModelLazyKt.createViewModelLazy(daijishouPreferenceFragmentCompat, Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new DaijishouPreferenceFragmentCompat$onCreate$$inlined$activityViewModels$default$4(daijishouPreferenceFragmentCompat), new DaijishouPreferenceFragmentCompat$onCreate$$inlined$activityViewModels$default$5(null, daijishouPreferenceFragmentCompat), new DaijishouPreferenceFragmentCompat$onCreate$$inlined$activityViewModels$default$6(daijishouPreferenceFragmentCompat));
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setApplication((DaijishouApplication) application);
        Application application2 = requireActivity().getApplication();
        Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setLogger(((DaijishouApplication) application2).getLogger());
        Application application3 = requireActivity().getApplication();
        Intrinsics.checkNotNull(application3, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setDefaultSharedPreferences(((DaijishouApplication) application3).getDefaultSharedPreferences());
        setDaijishouLibrary(onCreate$lambda$0(lazyCreateViewModelLazy));
        setDaijishouSynchronization(onCreate$lambda$1(lazyCreateViewModelLazy2));
        Application application4 = requireActivity().getApplication();
        Intrinsics.checkNotNull(application4, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setRetroAchievementsManager(((DaijishouApplication) application4).getRetroAchievementsManager());
        Application application5 = requireActivity().getApplication();
        Intrinsics.checkNotNull(application5, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setDpToPxConverter(((DaijishouApplication) application5).getDpToPxConverter());
    }

    private static final DaijishouLibraryModel onCreate$lambda$0(Lazy<DaijishouLibraryModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouSynchronizationModel onCreate$lambda$1(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    /* INFO: renamed from: com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragmentCompat$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: DaijishouPreferenceFragmentCompat.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/abstract_fragment_classes/DaijishouPreferenceFragmentCompat$onViewCreated$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class C01991 extends RecyclerView.OnScrollListener {
        C01991() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                DaijishouPreferenceFragmentCompat.this.scrollingOnBackPressed = false;
            }
            super.onScrollStateChanged(recyclerView, newState);
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getListView().addOnScrollListener(new C01991());
        getListView().addOnLayoutChangeListener(new DaijishouPreferenceFragmentCompat$$ExternalSyntheticLambda0(this));
    }

    /* INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(DaijishouPreferenceFragmentCompat this$0, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.getListView().isFocused()) {
            return;
        }
        if (this$0.lastFocusedPosition >= 0) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this$0.getListView().findViewHolderForAdapterPosition(this$0.lastFocusedPosition);
            View view2 = viewHolderFindViewHolderForAdapterPosition != null ? viewHolderFindViewHolderForAdapterPosition.itemView : null;
            if (view2 != null && view2.isFocusable()) {
                view2.requestFocus();
                return;
            }
        }
        RecyclerView.LayoutManager layoutManager = this$0.getListView().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int iFindFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        RecyclerView.LayoutManager layoutManager2 = this$0.getListView().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int iFindLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager2).findLastCompletelyVisibleItemPosition();
        if (iFindFirstCompletelyVisibleItemPosition > iFindLastCompletelyVisibleItemPosition) {
            return;
        }
        while (true) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2 = this$0.getListView().findViewHolderForAdapterPosition(iFindFirstCompletelyVisibleItemPosition);
            View view3 = viewHolderFindViewHolderForAdapterPosition2 != null ? viewHolderFindViewHolderForAdapterPosition2.itemView : null;
            if (view3 != null && view3.isFocusable()) {
                view3.requestFocus();
                return;
            } else if (iFindFirstCompletelyVisibleItemPosition == iFindLastCompletelyVisibleItemPosition) {
                return;
            } else {
                iFindFirstCompletelyVisibleItemPosition++;
            }
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStop() {
        RecyclerView.LayoutManager layoutManager = getListView().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        View focusedChild = linearLayoutManager.getFocusedChild();
        if (focusedChild != null) {
            this.lastFocusedPosition = linearLayoutManager.getPosition(focusedChild);
        } else {
            this.lastFocusedPosition = -1;
        }
        super.onStop();
    }
}
