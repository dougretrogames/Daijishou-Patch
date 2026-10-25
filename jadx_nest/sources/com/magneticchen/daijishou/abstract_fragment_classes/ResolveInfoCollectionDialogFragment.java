package com.magneticchen.daijishou.abstract_fragment_classes;

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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouGridLayoutManager;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.view_models.AppsViewModel;
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
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ResolveInfoCollectionDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0002?@B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020\u0017H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u000eH\u0016J\u001a\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0006\u00103\u001a\u00020\u000eJ\u001a\u00104\u001a\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ\u0014\u00105\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010J\u001a\u00106\u001a\u00020\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ\u001a\u00107\u001a\u00020\u00002\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ.\u00108\u001a\u00020\u00002&\u0010\u0013\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0014J\u0014\u00109\u001a\u00020\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0:J\u0016\u0010;\u001a\u00020\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0:H\u0002J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u0013\u001a$\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00060\u001bR\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/magneticchen/daijishou/abstract_fragment_classes/ResolveInfoCollectionDialogFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouDialogFragment;", "()V", "appsViewModel", "Lcom/magneticchen/daijishou/view_models/AppsViewModel;", "getAppsViewModel", "()Lcom/magneticchen/daijishou/view_models/AppsViewModel;", "appsViewModel$delegate", "Lkotlin/Lazy;", "backButton", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onClickListener", "Lkotlin/Function1;", "Landroid/content/pm/ResolveInfo;", "", "onDialogDismissedListener", "Lkotlin/Function0;", "onLongClickListener", "onSelectListener", "onTextChangedListener", "Lkotlin/Function4;", "", "", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewAdapter", "Lcom/magneticchen/daijishou/abstract_fragment_classes/ResolveInfoCollectionDialogFragment$GridRecyclerViewAdapter;", "resolveInfoCollection", "", "resolveInfoCollectionInRecyclerView", "scrollingOnBackPressed", "textInputEditText", "Lcom/google/android/material/textfield/TextInputEditText;", "textInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onStart", "onViewCreated", "view", "resetResolveInfoCollectionInRecyclerView", "setOnClickListener", "setOnDialogDismissedListener", "setOnLongClickListener", "setOnSelectListener", "setOnTextChangedListener", "setResolveInfoCollection", "", "setResolveInfoCollectionInRecyclerView", "setTitle", "title", "", "GridRecyclerViewAdapter", "ResolveInfoDiffUtilCallback", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ResolveInfoCollectionDialogFragment extends DaijishouDialogFragment {

    /* JADX INFO: renamed from: appsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy appsViewModel;
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
        ResolveInfoCollectionDialogFragment resolveInfoCollectionDialogFragment = this;
        this.appsViewModel = FragmentViewModelLazyKt.createViewModelLazy(resolveInfoCollectionDialogFragment, Reflection.getOrCreateKotlinClass(AppsViewModel.class), new ResolveInfoCollectionDialogFragment$special$$inlined$activityViewModels$default$1(resolveInfoCollectionDialogFragment), new ResolveInfoCollectionDialogFragment$special$$inlined$activityViewModels$default$2(null, resolveInfoCollectionDialogFragment), new ResolveInfoCollectionDialogFragment$special$$inlined$activityViewModels$default$3(resolveInfoCollectionDialogFragment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppsViewModel getAppsViewModel() {
        return (AppsViewModel) this.appsViewModel.getValue();
    }

    /* JADX INFO: compiled from: ResolveInfoCollectionDialogFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/abstract_fragment_classes/ResolveInfoCollectionDialogFragment$ResolveInfoDiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Landroid/content/pm/ResolveInfo;", "newList", "(Lcom/magneticchen/daijishou/abstract_fragment_classes/ResolveInfoCollectionDialogFragment;Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_release", "appsViewModel", "Lcom/magneticchen/daijishou/view_models/AppsViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ResolveInfoDiffUtilCallback extends DiffUtil.Callback {
        private final List<ResolveInfo> newList;
        private final List<ResolveInfo> oldList;
        final /* synthetic */ ResolveInfoCollectionDialogFragment this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public ResolveInfoDiffUtilCallback(ResolveInfoCollectionDialogFragment resolveInfoCollectionDialogFragment, List<ResolveInfo> oldList, List<ResolveInfo> newList) {
            Intrinsics.checkNotNullParameter(oldList, "oldList");
            Intrinsics.checkNotNullParameter(newList, "newList");
            this.this$0 = resolveInfoCollectionDialogFragment;
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
            ViewModelLazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AppsViewModel.class), new ResolveInfoCollectionDialogFragment$ResolveInfoDiffUtilCallback$areItemsTheSame$$inlined$viewModels$default$2(fragmentActivity), new ResolveInfoCollectionDialogFragment$ResolveInfoDiffUtilCallback$areItemsTheSame$$inlined$viewModels$default$1(fragmentActivity), new ResolveInfoCollectionDialogFragment$ResolveInfoDiffUtilCallback$areItemsTheSame$$inlined$viewModels$default$3(null, fragmentActivity));
            return Intrinsics.areEqual(areItemsTheSame$lambda$0(viewModelLazy).resolveInfoToResolveInfoStringId(this.newList.get(newItemPosition)), areItemsTheSame$lambda$0(viewModelLazy).resolveInfoToResolveInfoStringId(this.oldList.get(oldItemPosition)));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics.areEqual(this.newList.get(newItemPosition), this.oldList.get(oldItemPosition));
        }
    }

    public final ResolveInfoCollectionDialogFragment setOnLongClickListener(Function1<? super ResolveInfo, Unit> onLongClickListener) {
        Intrinsics.checkNotNullParameter(onLongClickListener, "onLongClickListener");
        this.onLongClickListener = onLongClickListener;
        return this;
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

    public final ResolveInfoCollectionDialogFragment setOnTextChangedListener(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Boolean> onTextChangedListener) {
        Intrinsics.checkNotNullParameter(onTextChangedListener, "onTextChangedListener");
        this.onTextChangedListener = onTextChangedListener;
        return this;
    }

    public final ResolveInfoCollectionDialogFragment setOnDialogDismissedListener(Function0<Unit> onDialogDismissedListener) {
        Intrinsics.checkNotNullParameter(onDialogDismissedListener, "onDialogDismissedListener");
        this.onDialogDismissedListener = onDialogDismissedListener;
        return this;
    }

    public final void setResolveInfoCollection(List<? extends ResolveInfo> resolveInfoCollection) {
        Intrinsics.checkNotNullParameter(resolveInfoCollection, "resolveInfoCollection");
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new ResolveInfoDiffUtilCallback(this, this.resolveInfoCollectionInRecyclerView, (List<ResolveInfo>) resolveInfoCollection));
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

    private final void setResolveInfoCollectionInRecyclerView(List<? extends ResolveInfo> resolveInfoCollection) {
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new ResolveInfoDiffUtilCallback(this, this.resolveInfoCollectionInRecyclerView, (List<ResolveInfo>) resolveInfoCollection));
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
        this.resolveInfoCollectionInRecyclerView.clear();
        this.resolveInfoCollectionInRecyclerView.addAll(resolveInfoCollection);
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

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDialogDismissedListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
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
            window3.setFlags(1024, 1024);
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
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
    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouDialogFragment
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_app_collection_dialog, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_app_collection_dialog_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.recyclerView = (RecyclerView) viewFindViewById;
        GridRecyclerViewAdapter gridRecyclerViewAdapter = new GridRecyclerViewAdapter(this, this.resolveInfoCollectionInRecyclerView);
        this.recyclerViewAdapter = gridRecyclerViewAdapter;
        gridRecyclerViewAdapter.setOnItemClickListener(new AnonymousClass1());
        GridRecyclerViewAdapter gridRecyclerViewAdapter2 = this.recyclerViewAdapter;
        TextInputLayout textInputLayout = null;
        if (gridRecyclerViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            gridRecyclerViewAdapter2 = null;
        }
        gridRecyclerViewAdapter2.setOnItemLongClickListener(new AnonymousClass2());
        GridRecyclerViewAdapter gridRecyclerViewAdapter3 = this.recyclerViewAdapter;
        if (gridRecyclerViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            gridRecyclerViewAdapter3 = null;
        }
        gridRecyclerViewAdapter3.setOnItemSelectListener(new AnonymousClass3());
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
        recyclerView3.addOnScrollListener(new AnonymousClass4());
        View viewFindViewById2 = viewInflate.findViewById(R.id.fragment_app_collection_dialog_back_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById2;
        this.backButton = constraintLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            constraintLayout = null;
        }
        constraintLayout.setOnClickListener(new ResolveInfoCollectionDialogFragment$$ExternalSyntheticLambda0(this));
        View viewFindViewById3 = viewInflate.findViewById(R.id.fragment_app_collection_dialog_edit_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        TextInputEditText textInputEditText = (TextInputEditText) viewFindViewById3;
        this.textInputEditText = textInputEditText;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textInputEditText");
            textInputEditText = null;
        }
        textInputEditText.addTextChangedListener(new AnonymousClass6());
        View viewFindViewById4 = viewInflate.findViewById(R.id.fragment_app_collection_dialog_text_input_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        TextInputLayout textInputLayout2 = (TextInputLayout) viewFindViewById4;
        this.textInputLayout = textInputLayout2;
        if (textInputLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textInputLayout");
        } else {
            textInputLayout = textInputLayout2;
        }
        textInputLayout.setEndIconOnClickListener(new ResolveInfoCollectionDialogFragment$$ExternalSyntheticLambda1(this));
        return viewInflate;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.abstract_fragment_classes.ResolveInfoCollectionDialogFragment$onCreateView$1, reason: invalid class name */
    /* JADX INFO: compiled from: ResolveInfoCollectionDialogFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function4<View, Integer, Long, ResolveInfo, Unit> {
        AnonymousClass1() {
            super(4);
        }

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
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.abstract_fragment_classes.ResolveInfoCollectionDialogFragment$onCreateView$2, reason: invalid class name */
    /* JADX INFO: compiled from: ResolveInfoCollectionDialogFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "invoke", "(Landroid/view/View;IJLandroid/content/pm/ResolveInfo;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda<Boolean> implements Function4<View, Integer, Long, ResolveInfo, Boolean> {
        AnonymousClass2() {
            super(4);
        }

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
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.abstract_fragment_classes.ResolveInfoCollectionDialogFragment$onCreateView$3, reason: invalid class name */
    /* JADX INFO: compiled from: ResolveInfoCollectionDialogFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass3 extends Lambda<Unit> implements Function4<View, Integer, Long, ResolveInfo, Unit> {
        AnonymousClass3() {
            super(4);
        }

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
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.abstract_fragment_classes.ResolveInfoCollectionDialogFragment$onCreateView$4, reason: invalid class name */
    /* JADX INFO: compiled from: ResolveInfoCollectionDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/abstract_fragment_classes/ResolveInfoCollectionDialogFragment$onCreateView$4", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass4 extends RecyclerView.OnScrollListener {
        AnonymousClass4() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                ResolveInfoCollectionDialogFragment.this.scrollingOnBackPressed = false;
            }
            super.onScrollStateChanged(recyclerView, newState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(ResolveInfoCollectionDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireDialog().onBackPressed();
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.abstract_fragment_classes.ResolveInfoCollectionDialogFragment$onCreateView$6, reason: invalid class name */
    /* JADX INFO: compiled from: ResolveInfoCollectionDialogFragment.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/magneticchen/daijishou/abstract_fragment_classes/ResolveInfoCollectionDialogFragment$onCreateView$6", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass6 implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        AnonymousClass6() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            GridRecyclerViewAdapter gridRecyclerViewAdapter;
            if (ResolveInfoCollectionDialogFragment.this.onTextChangedListener != null) {
                Function4 function4 = ResolveInfoCollectionDialogFragment.this.onTextChangedListener;
                Intrinsics.checkNotNull(function4);
                if (!((Boolean) function4.invoke(s, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count))).booleanValue()) {
                    return;
                }
            }
            if (s == null || Intrinsics.areEqual(s, "")) {
                ResolveInfoCollectionDialogFragment.this.resetResolveInfoCollectionInRecyclerView();
                return;
            }
            String string = s.toString();
            HashMap<String, String> resolveInfoStringIdToLabelCache = ResolveInfoCollectionDialogFragment.this.getAppsViewModel().getResolveInfoStringIdToLabelCache();
            List list = ResolveInfoCollectionDialogFragment.this.resolveInfoCollection;
            ResolveInfoCollectionDialogFragment resolveInfoCollectionDialogFragment = ResolveInfoCollectionDialogFragment.this;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (true) {
                gridRecyclerViewAdapter = null;
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
            GridRecyclerViewAdapter gridRecyclerViewAdapter2 = ResolveInfoCollectionDialogFragment.this.recyclerViewAdapter;
            if (gridRecyclerViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            } else {
                gridRecyclerViewAdapter = gridRecyclerViewAdapter2;
            }
            diffResultCalculateDiff.dispatchUpdatesTo(gridRecyclerViewAdapter);
        }
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
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\n0\u000bR\u00060\u0000R\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/abstract_fragment_classes/ResolveInfoCollectionDialogFragment$GridRecyclerViewAdapter;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Landroid/content/pm/ResolveInfo;", "resolveInfoList", "", "(Lcom/magneticchen/daijishou/abstract_fragment_classes/ResolveInfoCollectionDialogFragment;Ljava/util/List;)V", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/abstract_fragment_classes/ResolveInfoCollectionDialogFragment$GridRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/ResolveInfoCollectionDialogFragment;", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            return this.resolveInfoList.get(position).hashCode();
        }

        /* JADX INFO: compiled from: ResolveInfoCollectionDialogFragment.kt */
        @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000ej\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/magneticchen/daijishou/abstract_fragment_classes/ResolveInfoCollectionDialogFragment$GridRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Landroid/content/pm/ResolveInfo;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/abstract_fragment_classes/ResolveInfoCollectionDialogFragment$GridRecyclerViewAdapter;Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "resolveInfoStringIdToBitmapCache", "Lcom/magneticchen/daijishou/utils/Utils$MaxSizeHashMap;", "", "Landroid/graphics/Bitmap;", "resolveInfoStringIdToLabelCache", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "textView", "Landroid/widget/TextView;", "onBind", "", "position", "", "item", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocus() {
                super.onFocus();
                this.itemView.setFocusableInTouchMode(true);
                Utils utils = Utils.INSTANCE;
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Utils.scaleView$default(utils, itemView, 1.0f, 1.03f, 0L, false, 24, null);
                this.itemView.requestFocus();
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocusClear(boolean isAbsoluteAdapterPositionValid) {
                super.onFocusClear(isAbsoluteAdapterPositionValid);
                if (isAbsoluteAdapterPositionValid) {
                    Utils utils = Utils.INSTANCE;
                    View itemView = this.itemView;
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    Utils.scaleView$default(utils, itemView, 1.03f, 1.0f, 0L, false, 24, null);
                }
                this.itemView.setFocusableInTouchMode(false);
            }

            @Override // com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int position, ResolveInfo item) {
                Intrinsics.checkNotNullParameter(item, "item");
                String strResolveInfoToResolveInfoStringId = this.this$0.this$0.getAppsViewModel().resolveInfoToResolveInfoStringId(item);
                this.imageView.setImageBitmap(this.resolveInfoStringIdToBitmapCache.get(strResolveInfoToResolveInfoStringId));
                this.textView.setText(this.resolveInfoStringIdToLabelCache.get(strResolveInfoToResolveInfoStringId));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_app, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }
}
