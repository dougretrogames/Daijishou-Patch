package com.magneticchen.daijishou.ui.fragments.p000abstract;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.PreferenceFragmentCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel;
import com.magneticchen.daijishou.utils.DpToPxConverter;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: DaijishouPreferenceFragmentCompat.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00101\u001a\u000200H\u0016J\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u000203H\u0016J\u001a\u00107\u001a\u0002032\u0006\u00108\u001a\u0002092\b\u00104\u001a\u0004\u0018\u000105H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00060$R\u00020\u0004X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouPreferenceFragmentCompat;", "Landroidx/preference/PreferenceFragmentCompat;", "()V", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "setApplication", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "daijishouLibrary", "Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;", "getDaijishouLibrary", "()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;", "setDaijishouLibrary", "(Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;)V", "daijishouSynchronization", "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;", "getDaijishouSynchronization", "()Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;", "setDaijishouSynchronization", "(Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;)V", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "getDefaultSharedPreferences", "()Landroid/content/SharedPreferences;", "setDefaultSharedPreferences", "(Landroid/content/SharedPreferences;)V", "dpToPxConverter", "Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "getDpToPxConverter", "()Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "setDpToPxConverter", "(Lcom/magneticchen/daijishou/utils/DpToPxConverter;)V", "lastFocusedPosition", "", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "setLogger", "(Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;)V", "retroAchievementsManager", "Lcom/magneticchen/daijishou/features/retroachievements/RetroAchievementsManager;", "getRetroAchievementsManager", "()Lcom/magneticchen/daijishou/features/retroachievements/RetroAchievementsManager;", "setRetroAchievementsManager", "(Lcom/magneticchen/daijishou/features/retroachievements/RetroAchievementsManager;)V", "scrollingOnBackPressed", "", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "onViewCreated", "view", "Landroid/view/View;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* JADX INFO: Access modifiers changed from: protected */
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

    protected final DaijishouLibraryModel getDaijishouLibrary() {
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

    protected final SharedPreferences getDefaultSharedPreferences() {
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
        getListView().addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouPreferenceFragmentCompat.onBackPressed.1
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    LinearLayoutManager layoutManager = DaijishouPreferenceFragmentCompat.this.getListView().getLayoutManager();
                    Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    int iFindFirstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                    LinearLayoutManager layoutManager2 = DaijishouPreferenceFragmentCompat.this.getListView().getLayoutManager();
                    Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    int iFindLastVisibleItemPosition = layoutManager2.findLastVisibleItemPosition();
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
        });
        getListView().clearFocus();
        getListView().smoothScrollToPosition(0);
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final Fragment fragment = (Fragment) this;
        final Function0 function0 = null;
        Lazy lazyCreateViewModelLazy = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DaijishouLibraryModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouPreferenceFragmentCompat$onCreate$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouPreferenceFragmentCompat$onCreate$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouPreferenceFragmentCompat$onCreate$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        Lazy lazyCreateViewModelLazy2 = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouPreferenceFragmentCompat$onCreate$$inlined$activityViewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouPreferenceFragmentCompat$onCreate$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouPreferenceFragmentCompat$onCreate$$inlined$activityViewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
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

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getListView().addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouPreferenceFragmentCompat.onViewCreated.1
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (i == 0) {
                    DaijishouPreferenceFragmentCompat.this.scrollingOnBackPressed = false;
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        });
        getListView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.DaijishouPreferenceFragmentCompat$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                DaijishouPreferenceFragmentCompat.onViewCreated$lambda$2(this.f$0, view2, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
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
        LinearLayoutManager layoutManager = this$0.getListView().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int iFindFirstCompletelyVisibleItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
        LinearLayoutManager layoutManager2 = this$0.getListView().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int iFindLastCompletelyVisibleItemPosition = layoutManager2.findLastCompletelyVisibleItemPosition();
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

    public void onStop() {
        LinearLayoutManager layoutManager = getListView().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = layoutManager;
        View focusedChild = linearLayoutManager.getFocusedChild();
        if (focusedChild != null) {
            this.lastFocusedPosition = linearLayoutManager.getPosition(focusedChild);
        } else {
            this.lastFocusedPosition = -1;
        }
        super.onStop();
    }
}
