package com.magneticchen.daijishou.ui.fragments.p000abstract;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouGridLayoutManager;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.ui.model.AppsViewModel;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import com.magneticchen.daijishou.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ResolveInfoCollectionDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0002=>B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020\u0017H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u000eH\u0016J\u001a\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0006\u00103\u001a\u00020\u000eJ\u001a\u00104\u001a\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ\u0014\u00105\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010J\u001a\u00106\u001a\u00020\u00002\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ\u0014\u00107\u001a\u00020\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r08J\u0016\u00109\u001a\u00020\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r08H\u0002J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u0013\u001a$\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00060\u001bR\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/abstract/ResolveInfoCollectionDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "appsViewModel", "Lcom/magneticchen/daijishou/ui/model/AppsViewModel;", "getAppsViewModel", "()Lcom/magneticchen/daijishou/ui/model/AppsViewModel;", "appsViewModel$delegate", "Lkotlin/Lazy;", "backButton", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onClickListener", "Lkotlin/Function1;", "Landroid/content/pm/ResolveInfo;", "", "onDialogDismissedListener", "Lkotlin/Function0;", "onLongClickListener", "onSelectListener", "onTextChangedListener", "Lkotlin/Function4;", "", "", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewAdapter", "Lcom/magneticchen/daijishou/ui/fragments/abstract/ResolveInfoCollectionDialogFragment$GridRecyclerViewAdapter;", "resolveInfoCollection", "", "resolveInfoCollectionInRecyclerView", "scrollingOnBackPressed", "textInputEditText", "Lcom/google/android/material/textfield/TextInputEditText;", "textInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onStart", "onViewCreated", "view", "resetResolveInfoCollectionInRecyclerView", "setOnClickListener", "setOnDialogDismissedListener", "setOnSelectListener", "setResolveInfoCollection", "", "setResolveInfoCollectionInRecyclerView", "setTitle", "title", "", "GridRecyclerViewAdapter", "ResolveInfoDiffUtilCallback", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ResolveInfoCollectionDialogFragment extends DaijishouDialogFragment {
    private final Lazy appsViewModel$delegate;
    private ConstraintLayout backButton;
    private Function1<? super ResolveInfo, Unit> onClickListener;
    private Function0<Unit> onDialogDismissedListener;
    private Function1<? super ResolveInfo, Unit> onLongClickListener;
    private Function1<? super ResolveInfo, Unit> onSelectListener;
    private Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Boolean> onTextChangedListener;
    private RecyclerView recyclerView;
    private GridRecyclerViewAdapter recyclerViewAdapter;
    private final List<ResolveInfo> resolveInfoCollection = new ArrayList();
    private final List<ResolveInfo> resolveInfoCollectionInRecyclerView = new ArrayList();
    private boolean scrollingOnBackPressed;
    private TextInputEditText textInputEditText;
    private TextInputLayout textInputLayout;

    public ResolveInfoCollectionDialogFragment() {
        final Fragment fragment = (Fragment) this;
        final Function0 function0 = null;
        this.appsViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(AppsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.ResolveInfoCollectionDialogFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.ResolveInfoCollectionDialogFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.ResolveInfoCollectionDialogFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppsViewModel getAppsViewModel() {
        return (AppsViewModel) this.appsViewModel$delegate.getValue();
    }

    /* JADX INFO: compiled from: ResolveInfoCollectionDialogFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/abstract/ResolveInfoCollectionDialogFragment$ResolveInfoDiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Landroid/content/pm/ResolveInfo;", "newList", "(Lcom/magneticchen/daijishou/ui/fragments/abstract/ResolveInfoCollectionDialogFragment;Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_release", "appsViewModel", "Lcom/magneticchen/daijishou/ui/model/AppsViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ResolveInfoDiffUtilCallback extends DiffUtil.Callback {
        private final List<ResolveInfo> newList;
        private final List<ResolveInfo> oldList;
        final /* synthetic */ ResolveInfoCollectionDialogFragment this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public ResolveInfoDiffUtilCallback(ResolveInfoCollectionDialogFragment resolveInfoCollectionDialogFragment, List<? extends ResolveInfo> oldList, List<? extends ResolveInfo> newList) {
            Intrinsics.checkNotNullParameter(oldList, "oldList");
            Intrinsics.checkNotNullParameter(newList, "newList");
            this.this$0 = resolveInfoCollectionDialogFragment;
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
            Lazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AppsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.ResolveInfoCollectionDialogFragment$ResolveInfoDiffUtilCallback$areItemsTheSame$$inlined$viewModels$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ViewModelStore invoke() {
                    return componentActivity.getViewModelStore();
                }
            }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.ResolveInfoCollectionDialogFragment$ResolveInfoDiffUtilCallback$areItemsTheSame$$inlined$viewModels$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ViewModelProvider.Factory invoke() {
                    return componentActivity.getDefaultViewModelProviderFactory();
                }
            }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.ResolveInfoCollectionDialogFragment$ResolveInfoDiffUtilCallback$areItemsTheSame$$inlined$viewModels$default$3
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

    public final ResolveInfoCollectionDialogFragment setOnClickListener(Function1<? super ResolveInfo, Unit> onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.onClickListener = onClickListener;
        return this;
    }

    public final ResolveInfoCollectionDialogFragment setOnSelectListener(Function1<? super ResolveInfo, Unit> onSelectListener) {
        Intrinsics.checkNotNullParameter(onSelectListener, "onSelectListener");
        this.onSelectListener = onSelectListener;
        return this;
    }

    public final ResolveInfoCollectionDialogFragment setOnDialogDismissedListener(Function0<Unit> onDialogDismissedListener) {
        Intrinsics.checkNotNullParameter(onDialogDismissedListener, "onDialogDismissedListener");
        this.onDialogDismissedListener = onDialogDismissedListener;
        return this;
    }

    public final void setResolveInfoCollection(List<? extends ResolveInfo> resolveInfoCollection) {
        Intrinsics.checkNotNullParameter(resolveInfoCollection, "resolveInfoCollection");
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new ResolveInfoDiffUtilCallback(this, this.resolveInfoCollectionInRecyclerView, resolveInfoCollection));
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
        this.resolveInfoCollection.clear();
        List<? extends ResolveInfo> list = resolveInfoCollection;
        this.resolveInfoCollection.addAll(list);
        this.resolveInfoCollectionInRecyclerView.clear();
        this.resolveInfoCollectionInRecyclerView.addAll(list);
        GridRecyclerViewAdapter gridRecyclerViewAdapter = this.recyclerViewAdapter;
        if (gridRecyclerViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            gridRecyclerViewAdapter = null;
        }
        diffResultCalculateDiff.dispatchUpdatesTo(gridRecyclerViewAdapter);
    }

    private final void setResolveInfoCollectionInRecyclerView(List<? extends ResolveInfo> list) {
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new ResolveInfoDiffUtilCallback(this, this.resolveInfoCollectionInRecyclerView, list));
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
        this.resolveInfoCollectionInRecyclerView.clear();
        this.resolveInfoCollectionInRecyclerView.addAll(list);
        GridRecyclerViewAdapter gridRecyclerViewAdapter = this.recyclerViewAdapter;
        if (gridRecyclerViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            gridRecyclerViewAdapter = null;
        }
        diffResultCalculateDiff.dispatchUpdatesTo(gridRecyclerViewAdapter);
    }

    public final void resetResolveInfoCollectionInRecyclerView() {
        setResolveInfoCollectionInRecyclerView(this.resolveInfoCollection);
    }

    public final ResolveInfoCollectionDialogFragment setTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        TextInputLayout textInputLayout = this.textInputLayout;
        if (textInputLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textInputLayout");
            textInputLayout = null;
        }
        textInputLayout.setHint(title);
        return this;
    }

    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDialogDismissedListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        Intrinsics.checkNotNull(decorView);
        decorView.setBackground(null);
        Window window2 = requireDialog().getWindow();
        if (window2 != null) {
            window2.setLayout(-1, -1);
        }
        Window window3 = requireDialog().getWindow();
        if (window3 != null) {
            window3.setFlags(CategoryWidgetViewModel.LIMIT, CategoryWidgetViewModel.LIMIT);
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.FullScreenDialogAnimation);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001b  */
    /* JADX WARN: Code duplicated, block: B:20:0x0036  */
    /* JADX WARN: Code duplicated, block: B:22:0x003d  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:9:0x0017  */
    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public boolean onBackPressed() {
        RecyclerView recyclerView;
        ConstraintLayout constraintLayout;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3 = null;
        if (this.scrollingOnBackPressed) {
            RecyclerView recyclerView4 = this.recyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView4 = null;
            }
            if (recyclerView4.getScrollState() != 2) {
                recyclerView = this.recyclerView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView = null;
                }
                if (recyclerView.computeVerticalScrollOffset() != 0) {
                    this.scrollingOnBackPressed = true;
                    constraintLayout = this.backButton;
                    if (constraintLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("backButton");
                        constraintLayout = null;
                    }
                    constraintLayout.requestFocus();
                    recyclerView2 = this.recyclerView;
                    if (recyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    } else {
                        recyclerView3 = recyclerView2;
                    }
                    recyclerView3.smoothScrollToPosition(0);
                    return false;
                }
            }
        } else {
            recyclerView = this.recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            if (recyclerView.computeVerticalScrollOffset() != 0) {
                this.scrollingOnBackPressed = true;
                constraintLayout = this.backButton;
                if (constraintLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backButton");
                    constraintLayout = null;
                }
                constraintLayout.requestFocus();
                recyclerView2 = this.recyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    recyclerView3 = recyclerView2;
                }
                recyclerView3.smoothScrollToPosition(0);
                return false;
            }
        }
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView3 = recyclerView5;
        }
        recyclerView3.scrollToPosition(0);
        return super.onBackPressed();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_app_collection_dialog, viewGroup, false);
        RecyclerView recyclerViewFindViewById = viewInflate.findViewById(R.id.fragment_app_collection_dialog_recycler_view);
        Intrinsics.checkNotNullExpressionValue(recyclerViewFindViewById, "findViewById(...)");
        this.recyclerView = recyclerViewFindViewById;
        GridRecyclerViewAdapter gridRecyclerViewAdapter = new GridRecyclerViewAdapter(this, this.resolveInfoCollectionInRecyclerView);
        this.recyclerViewAdapter = gridRecyclerViewAdapter;
        gridRecyclerViewAdapter.setOnItemClickListener(new Function4<View, Integer, Long, ResolveInfo, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.ResolveInfoCollectionDialogFragment.onCreateView.1
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, ResolveInfo resolveInfo) {
                invoke(view, num.intValue(), l.longValue(), resolveInfo);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i, long j, ResolveInfo resolveInfo) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(resolveInfo, "resolveInfo");
                Function1 function1 = ResolveInfoCollectionDialogFragment.this.onClickListener;
                if (function1 != null) {
                    function1.invoke(resolveInfo);
                }
            }
        });
        GridRecyclerViewAdapter gridRecyclerViewAdapter2 = this.recyclerViewAdapter;
        TextInputLayout textInputLayout = null;
        if (gridRecyclerViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            gridRecyclerViewAdapter2 = null;
        }
        gridRecyclerViewAdapter2.setOnItemLongClickListener(new Function4<View, Integer, Long, ResolveInfo, Boolean>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.ResolveInfoCollectionDialogFragment.onCreateView.2
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Boolean invoke(View view, Integer num, Long l, ResolveInfo resolveInfo) {
                return invoke(view, num.intValue(), l.longValue(), resolveInfo);
            }

            public final Boolean invoke(View view, int i, long j, ResolveInfo resolveInfo) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(resolveInfo, "resolveInfo");
                Function1 function1 = ResolveInfoCollectionDialogFragment.this.onLongClickListener;
                if (function1 != null) {
                    function1.invoke(resolveInfo);
                }
                return true;
            }
        });
        GridRecyclerViewAdapter gridRecyclerViewAdapter3 = this.recyclerViewAdapter;
        if (gridRecyclerViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            gridRecyclerViewAdapter3 = null;
        }
        gridRecyclerViewAdapter3.setOnItemSelectListener(new Function4<View, Integer, Long, ResolveInfo, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.ResolveInfoCollectionDialogFragment.onCreateView.3
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, ResolveInfo resolveInfo) {
                invoke(view, num.intValue(), l.longValue(), resolveInfo);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i, long j, ResolveInfo resolveInfo) {
                Intrinsics.checkNotNullParameter(resolveInfo, "resolveInfo");
                Function1 function1 = ResolveInfoCollectionDialogFragment.this.onSelectListener;
                if (function1 != null) {
                    function1.invoke(resolveInfo);
                }
            }
        });
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        GridRecyclerViewAdapter gridRecyclerViewAdapter4 = this.recyclerViewAdapter;
        if (gridRecyclerViewAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            gridRecyclerViewAdapter4 = null;
        }
        recyclerView.setAdapter(gridRecyclerViewAdapter4);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        recyclerView2.setLayoutManager(new DaijishouGridLayoutManager(contextRequireContext, 96.0f, 8, 4.0f, false, 16, null));
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.ResolveInfoCollectionDialogFragment.onCreateView.4
            public void onScrollStateChanged(RecyclerView recyclerView4, int i) {
                Intrinsics.checkNotNullParameter(recyclerView4, "recyclerView");
                if (i == 0) {
                    ResolveInfoCollectionDialogFragment.this.scrollingOnBackPressed = false;
                }
                super.onScrollStateChanged(recyclerView4, i);
            }
        });
        ConstraintLayout constraintLayoutFindViewById = viewInflate.findViewById(R.id.fragment_app_collection_dialog_back_button);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
        ConstraintLayout constraintLayout = constraintLayoutFindViewById;
        this.backButton = constraintLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            constraintLayout = null;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.ResolveInfoCollectionDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResolveInfoCollectionDialogFragment.onCreateView$lambda$0(this.f$0, view);
            }
        });
        TextInputEditText textInputEditTextFindViewById = viewInflate.findViewById(R.id.fragment_app_collection_dialog_edit_text);
        Intrinsics.checkNotNullExpressionValue(textInputEditTextFindViewById, "findViewById(...)");
        TextInputEditText textInputEditText = textInputEditTextFindViewById;
        this.textInputEditText = textInputEditText;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textInputEditText");
            textInputEditText = null;
        }
        textInputEditText.addTextChangedListener(new TextWatcher() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.ResolveInfoCollectionDialogFragment.onCreateView.6
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                GridRecyclerViewAdapter gridRecyclerViewAdapter5;
                if (ResolveInfoCollectionDialogFragment.this.onTextChangedListener != null) {
                    Function4 function4 = ResolveInfoCollectionDialogFragment.this.onTextChangedListener;
                    Intrinsics.checkNotNull(function4);
                    if (!((Boolean) function4.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue()) {
                        return;
                    }
                }
                if (charSequence == null || Intrinsics.areEqual(charSequence, "")) {
                    ResolveInfoCollectionDialogFragment.this.resetResolveInfoCollectionInRecyclerView();
                    return;
                }
                String string = charSequence.toString();
                HashMap<String, String> resolveInfoStringIdToLabelCache = ResolveInfoCollectionDialogFragment.this.getAppsViewModel().getResolveInfoStringIdToLabelCache();
                List list = ResolveInfoCollectionDialogFragment.this.resolveInfoCollection;
                ResolveInfoCollectionDialogFragment resolveInfoCollectionDialogFragment = ResolveInfoCollectionDialogFragment.this;
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (true) {
                    gridRecyclerViewAdapter5 = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    String str = resolveInfoStringIdToLabelCache.get(resolveInfoCollectionDialogFragment.getAppsViewModel().resolveInfoToResolveInfoStringId((ResolveInfo) next));
                    if (str != null) {
                        Locale ROOT = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                        String lowerCase = str.toLowerCase(ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        Locale ROOT2 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
                        String lowerCase2 = string.toLowerCase(ROOT2);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                            arrayList.add(next);
                        }
                    }
                }
                ArrayList arrayList2 = arrayList;
                ResolveInfoCollectionDialogFragment resolveInfoCollectionDialogFragment2 = ResolveInfoCollectionDialogFragment.this;
                DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new ResolveInfoDiffUtilCallback(resolveInfoCollectionDialogFragment2, resolveInfoCollectionDialogFragment2.resolveInfoCollectionInRecyclerView, arrayList2));
                Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
                ResolveInfoCollectionDialogFragment.this.resolveInfoCollectionInRecyclerView.clear();
                ResolveInfoCollectionDialogFragment.this.resolveInfoCollectionInRecyclerView.addAll(arrayList2);
                GridRecyclerViewAdapter gridRecyclerViewAdapter6 = ResolveInfoCollectionDialogFragment.this.recyclerViewAdapter;
                if (gridRecyclerViewAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                } else {
                    gridRecyclerViewAdapter5 = gridRecyclerViewAdapter6;
                }
                diffResultCalculateDiff.dispatchUpdatesTo(gridRecyclerViewAdapter5);
            }
        });
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_app_collection_dialog_text_input_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextInputLayout textInputLayout2 = (TextInputLayout) viewFindViewById;
        this.textInputLayout = textInputLayout2;
        if (textInputLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textInputLayout");
        } else {
            textInputLayout = textInputLayout2;
        }
        textInputLayout.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.ResolveInfoCollectionDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResolveInfoCollectionDialogFragment.onCreateView$lambda$1(this.f$0, view);
            }
        });
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(ResolveInfoCollectionDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireDialog().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(ResolveInfoCollectionDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextInputEditText textInputEditText = this$0.textInputEditText;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textInputEditText");
            textInputEditText = null;
        }
        Editable text = textInputEditText.getText();
        if (text != null) {
            text.clear();
        }
    }

    /* JADX INFO: compiled from: ResolveInfoCollectionDialogFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\n0\u000bR\u00060\u0000R\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/abstract/ResolveInfoCollectionDialogFragment$GridRecyclerViewAdapter;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Landroid/content/pm/ResolveInfo;", "resolveInfoList", "", "(Lcom/magneticchen/daijishou/ui/fragments/abstract/ResolveInfoCollectionDialogFragment;Ljava/util/List;)V", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/ui/fragments/abstract/ResolveInfoCollectionDialogFragment$GridRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/ResolveInfoCollectionDialogFragment;", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class GridRecyclerViewAdapter extends DaijishouRecyclerView.Adapter<ResolveInfo> {
        private final List<ResolveInfo> resolveInfoList;
        final /* synthetic */ ResolveInfoCollectionDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GridRecyclerViewAdapter(ResolveInfoCollectionDialogFragment resolveInfoCollectionDialogFragment, List<ResolveInfo> resolveInfoList) {
            super(resolveInfoList, false, false, 6, null);
            Intrinsics.checkNotNullParameter(resolveInfoList, "resolveInfoList");
            this.this$0 = resolveInfoCollectionDialogFragment;
            this.resolveInfoList = resolveInfoList;
        }

        public long getItemId(int i) {
            return this.resolveInfoList.get(i).hashCode();
        }

        /* JADX INFO: compiled from: ResolveInfoCollectionDialogFragment.kt */
        @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000ej\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/abstract/ResolveInfoCollectionDialogFragment$GridRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Landroid/content/pm/ResolveInfo;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/fragments/abstract/ResolveInfoCollectionDialogFragment$GridRecyclerViewAdapter;Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "resolveInfoStringIdToBitmapCache", "Lcom/magneticchen/daijishou/utils/Utils$MaxSizeHashMap;", "", "Landroid/graphics/Bitmap;", "resolveInfoStringIdToLabelCache", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "textView", "Landroid/widget/TextView;", "onBind", "", "position", "", "item", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<ResolveInfo>.ViewHolder {
            private ImageView imageView;
            private final Utils.MaxSizeHashMap<String, Bitmap> resolveInfoStringIdToBitmapCache;
            private final HashMap<String, String> resolveInfoStringIdToLabelCache;
            private TextView textView;
            final /* synthetic */ GridRecyclerViewAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(GridRecyclerViewAdapter gridRecyclerViewAdapter, View itemView) {
                super(gridRecyclerViewAdapter, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = gridRecyclerViewAdapter;
                View viewFindViewById = itemView.findViewById(R.id.app_label);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                this.textView = (TextView) viewFindViewById;
                View viewFindViewById2 = itemView.findViewById(R.id.app_icon);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.imageView = (ImageView) viewFindViewById2;
                this.resolveInfoStringIdToBitmapCache = gridRecyclerViewAdapter.this$0.getAppsViewModel().getResolveInfoStringIdToBitmapCache();
                this.resolveInfoStringIdToLabelCache = gridRecyclerViewAdapter.this$0.getAppsViewModel().getResolveInfoStringIdToLabelCache();
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocus() {
                super.onFocus();
                this.itemView.setFocusableInTouchMode(true);
                Utils utils = Utils.INSTANCE;
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Utils.scaleView$default(utils, itemView, 1.0f, 1.03f, 0L, false, 24, null);
                this.itemView.requestFocus();
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
                this.itemView.setFocusableInTouchMode(false);
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int i, ResolveInfo item) {
                Intrinsics.checkNotNullParameter(item, "item");
                String strResolveInfoToResolveInfoStringId = this.this$0.this$0.getAppsViewModel().resolveInfoToResolveInfoStringId(item);
                this.imageView.setImageBitmap(this.resolveInfoStringIdToBitmapCache.get(strResolveInfoToResolveInfoStringId));
                this.textView.setText(this.resolveInfoStringIdToLabelCache.get(strResolveInfoToResolveInfoStringId));
            }
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_app, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }
}
