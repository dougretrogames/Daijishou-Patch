package com.magneticchen.daijishou.daijishou_recycler_view;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.utils.DpToPxConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DaijishouCycleLinearLayoutManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0012H\u0002J$\u0010\u0018\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a2\f\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u000eH\u0016J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020\u0012H\u0002R\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouCycleLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "dpToPxConverter", "Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "extraSpace", "", "lastTimeMillis", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "shakeRightAnimation", "Landroid/view/animation/Animation;", "calculateExtraLayoutSpace", "", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "extraLayoutSpace", "", "cancelAnimations", "onAdapterChanged", "oldAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "newAdapter", "onAttachedToWindow", "view", "onInterceptFocusSearch", "Landroid/view/View;", "focused", "direction", "setupAnimation", "startShakeRightAnimation", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouCycleLinearLayoutManager extends LinearLayoutManager {
    private static final int coolDownMs = 45;
    private DaijishouRecyclerView.Adapter<?> adapter;
    private final Context context;
    private final DpToPxConverter dpToPxConverter;
    private final int extraSpace;
    private long lastTimeMillis;
    private RecyclerView recyclerView;
    private Animation shakeRightAnimation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DaijishouCycleLinearLayoutManager(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.lastTimeMillis = System.currentTimeMillis();
        this.extraSpace = new DpToPxConverter(context).convert(96.0f);
        this.dpToPxConverter = new DpToPxConverter(context);
        setupAnimation();
    }

    private final void cancelAnimations() {
        Animation animation = this.shakeRightAnimation;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shakeRightAnimation");
            animation = null;
        }
        animation.cancel();
    }

    private final void setupAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, this.dpToPxConverter.convert(12.0f), 0.0f, 0.0f);
        this.shakeRightAnimation = translateAnimation;
        translateAnimation.setDuration(120L);
        Animation animation = this.shakeRightAnimation;
        Animation animation2 = null;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shakeRightAnimation");
            animation = null;
        }
        animation.setRepeatCount(1);
        Animation animation3 = this.shakeRightAnimation;
        if (animation3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shakeRightAnimation");
        } else {
            animation2 = animation3;
        }
        animation2.setRepeatMode(2);
    }

    private final void startShakeRightAnimation() {
        Animation animation = this.shakeRightAnimation;
        Animation animation2 = null;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shakeRightAnimation");
            animation = null;
        }
        if (animation.hasStarted()) {
            Animation animation3 = this.shakeRightAnimation;
            if (animation3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeRightAnimation");
                animation3 = null;
            }
            if (!animation3.hasEnded()) {
                return;
            }
        }
        Context applicationContext = this.context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) applicationContext).playReachBoundSfx(true);
        cancelAnimations();
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            Animation animation4 = this.shakeRightAnimation;
            if (animation4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeRightAnimation");
            } else {
                animation2 = animation4;
            }
            recyclerView.startAnimation(animation2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAttachedToWindow(view);
        this.recyclerView = view;
    }


    public void onAdapterChanged(RecyclerView.Adapter oldAdapter, RecyclerView.Adapter newAdapter) {
        Intrinsics.checkNotNull(newAdapter, "null cannot be cast to non-null type com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView.Adapter<*>");
        this.adapter = (DaijishouRecyclerView.Adapter) newAdapter;
        super.onAdapterChanged(oldAdapter, newAdapter);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void calculateExtraLayoutSpace(RecyclerView.State state, int[] extraLayoutSpace) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(extraLayoutSpace, "extraLayoutSpace");
        extraLayoutSpace[1] = this.extraSpace;
        super.calculateExtraLayoutSpace(state, extraLayoutSpace);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onInterceptFocusSearch(View focused, int direction) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2;
        Intrinsics.checkNotNullParameter(focused, "focused");
        int position = getPosition(focused);
        long jCurrentTimeMillis = System.currentTimeMillis();
        View viewOnInterceptFocusSearch = super.onInterceptFocusSearch(focused, direction);
        if (getOrientation() != 1 || getReverseLayout()) {
            return viewOnInterceptFocusSearch;
        }
        if (position == 0 && direction == 33) {
            this.lastTimeMillis = jCurrentTimeMillis;
            DaijishouRecyclerView.Adapter<?> adapter = this.adapter;
            if (adapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                adapter = null;
            }
            adapter.notifyItemChanged(getItemCount() - 1);
            DaijishouRecyclerView.Adapter<?> adapter2 = this.adapter;
            if (adapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                adapter2 = null;
            }
            adapter2.selectPosition(getItemCount() - 1);
            scrollToPosition(getItemCount() - 1);
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView == null || (viewHolderFindViewHolderForAdapterPosition2 = recyclerView.findViewHolderForAdapterPosition(getItemCount() - 1)) == null) {
                return null;
            }
            return viewHolderFindViewHolderForAdapterPosition2.itemView;
        }
        if (position != getItemCount() - 1 || direction != 130) {
            if (direction == 17 && jCurrentTimeMillis - this.lastTimeMillis > 45) {
                this.lastTimeMillis = jCurrentTimeMillis;
                startShakeRightAnimation();
                return focused;
            }
            if (jCurrentTimeMillis - this.lastTimeMillis <= 45) {
                return focused;
            }
            this.lastTimeMillis = jCurrentTimeMillis;
            return viewOnInterceptFocusSearch;
        }
        this.lastTimeMillis = jCurrentTimeMillis;
        DaijishouRecyclerView.Adapter<?> adapter3 = this.adapter;
        if (adapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            adapter3 = null;
        }
        adapter3.notifyItemChanged(0);
        DaijishouRecyclerView.Adapter<?> adapter4 = this.adapter;
        if (adapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            adapter4 = null;
        }
        adapter4.selectPosition(0);
        scrollToPosition(0);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null || (viewHolderFindViewHolderForAdapterPosition = recyclerView2.findViewHolderForAdapterPosition(0)) == null) {
            return null;
        }
        return viewHolderFindViewHolderForAdapterPosition.itemView;
    }
}
