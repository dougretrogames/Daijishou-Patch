package com.magneticchen.daijishou.daijishou_recycler_view;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.utils.DpToPxConverter;
import com.magneticchen.daijishou.utils.Utils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DaijishouGridLayoutManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010 \u001a\u00020\u0017H\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001aH\u0016J.\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00072\n\u0010'\u001a\u00060(R\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0016J\u001a\u0010+\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0007H\u0016J \u0010-\u001a\u00020\u00172\f\u0010'\u001a\b\u0018\u00010(R\u00020\u001a2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010.\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J,\u0010/\u001a\u00020\u00172\n\u0010'\u001a\u00060(R\u00020\u001a2\u0006\u0010)\u001a\u00020*2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0016J\u0014\u00102\u001a\u00020\u00172\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\b\u00103\u001a\u00020\u0017H\u0002J\u000e\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u0005R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_recycler_view/DaijishouGridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "targetItemWidthDp", "", "maxSpanCount", "", "paddingDp", "shakeOnFocusBound", "", "(Landroid/content/Context;FIFZ)V", "autoSpanCountMode", "focusBoundBottom", "focusBoundLeft", "focusBoundRight", "focusBoundTop", "lastFocusBoundReachedDirection", "lastFocusBoundReachedPosition", "lastTimeMillis", "", "onFocusBoundReachedListener", "Lkotlin/Function0;", "", "previousWidth", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "shakeDownAnimation", "Landroid/view/animation/Animation;", "shakeLeftAnimation", "shakeRightAnimation", "shakeUpAnimation", "cancelAnimations", "onAttachedToWindow", "view", "onFocusSearchFailed", "Landroid/view/View;", "focused", "focusDirection", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onInterceptFocusSearch", "direction", "onLayoutChildren", "onLayoutCompleted", "onMeasure", "widthSpec", "heightSpec", "setOnFocusBoundReachedListener", "setupAnimation", "updateTargetWidthDp", "targetWidthDp", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouGridLayoutManager extends GridLayoutManager {
    private boolean autoSpanCountMode;
    private Context context;
    private boolean focusBoundBottom;
    private boolean focusBoundLeft;
    private boolean focusBoundRight;
    private boolean focusBoundTop;
    private int lastFocusBoundReachedDirection;
    private int lastFocusBoundReachedPosition;
    private long lastTimeMillis;
    private int maxSpanCount;
    private Function0<Unit> onFocusBoundReachedListener;
    private float paddingDp;
    private int previousWidth;
    private RecyclerView recyclerView;
    private Animation shakeDownAnimation;
    private Animation shakeLeftAnimation;
    private boolean shakeOnFocusBound;
    private Animation shakeRightAnimation;
    private Animation shakeUpAnimation;
    private float targetItemWidthDp;

    public /* synthetic */ DaijishouGridLayoutManager(Context context, float f, int i, float f2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, f, i, (i2 & 8) != 0 ? 0.0f : f2, (i2 & 16) != 0 ? true : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DaijishouGridLayoutManager(Context context, float f, int i, float f2, boolean z) {
        super(context, 8);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.targetItemWidthDp = f;
        this.maxSpanCount = i;
        this.paddingDp = f2;
        this.shakeOnFocusBound = z;
        this.lastTimeMillis = System.currentTimeMillis();
        this.previousWidth = -1;
        this.focusBoundLeft = true;
        this.focusBoundRight = true;
        this.focusBoundBottom = true;
        this.lastFocusBoundReachedPosition = -1;
        this.lastFocusBoundReachedDirection = -1;
        this.autoSpanCountMode = true;
        setupAnimation();
    }

    public final void setOnFocusBoundReachedListener(Function0<Unit> onFocusBoundReachedListener) {
        Intrinsics.checkNotNullParameter(onFocusBoundReachedListener, "onFocusBoundReachedListener");
        this.onFocusBoundReachedListener = onFocusBoundReachedListener;
    }

    private final void setupAnimation() {
        if (this.shakeOnFocusBound) {
            DpToPxConverter dpToPxConverter = new DpToPxConverter(this.context);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -dpToPxConverter.convert(12.0f), 0.0f, 0.0f);
            this.shakeLeftAnimation = translateAnimation;
            translateAnimation.setDuration(120L);
            Animation animation = this.shakeLeftAnimation;
            Animation animation2 = null;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeLeftAnimation");
                animation = null;
            }
            animation.setRepeatCount(1);
            Animation animation3 = this.shakeLeftAnimation;
            if (animation3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeLeftAnimation");
                animation3 = null;
            }
            animation3.setRepeatMode(2);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, dpToPxConverter.convert(12.0f), 0.0f, 0.0f);
            this.shakeRightAnimation = translateAnimation2;
            translateAnimation2.setDuration(120L);
            Animation animation4 = this.shakeRightAnimation;
            if (animation4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeRightAnimation");
                animation4 = null;
            }
            animation4.setRepeatCount(1);
            Animation animation5 = this.shakeRightAnimation;
            if (animation5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeRightAnimation");
                animation5 = null;
            }
            animation5.setRepeatMode(2);
            TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -dpToPxConverter.convert(12.0f));
            this.shakeUpAnimation = translateAnimation3;
            translateAnimation3.setDuration(120L);
            Animation animation6 = this.shakeUpAnimation;
            if (animation6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeUpAnimation");
                animation6 = null;
            }
            animation6.setRepeatCount(1);
            Animation animation7 = this.shakeUpAnimation;
            if (animation7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeUpAnimation");
                animation7 = null;
            }
            animation7.setRepeatMode(2);
            TranslateAnimation translateAnimation4 = new TranslateAnimation(0.0f, 0.0f, 0.0f, dpToPxConverter.convert(12.0f));
            this.shakeDownAnimation = translateAnimation4;
            translateAnimation4.setDuration(120L);
            Animation animation8 = this.shakeDownAnimation;
            if (animation8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeDownAnimation");
                animation8 = null;
            }
            animation8.setRepeatCount(1);
            Animation animation9 = this.shakeDownAnimation;
            if (animation9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeDownAnimation");
            } else {
                animation2 = animation9;
            }
            animation2.setRepeatMode(2);
        }
    }

    private final void cancelAnimations() {
        Animation animation = this.shakeUpAnimation;
        Animation animation2 = null;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shakeUpAnimation");
            animation = null;
        }
        animation.cancel();
        Animation animation3 = this.shakeRightAnimation;
        if (animation3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shakeRightAnimation");
            animation3 = null;
        }
        animation3.cancel();
        Animation animation4 = this.shakeDownAnimation;
        if (animation4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shakeDownAnimation");
            animation4 = null;
        }
        animation4.cancel();
        Animation animation5 = this.shakeLeftAnimation;
        if (animation5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shakeLeftAnimation");
        } else {
            animation2 = animation5;
        }
        animation2.cancel();
    }

    public final void updateTargetWidthDp(float targetWidthDp) {
        this.targetItemWidthDp = targetWidthDp;
        int i = this.previousWidth;
        if (i >= 0) {
            float f = this.context.getResources().getDisplayMetrics().density;
            float f2 = (i / this.context.getResources().getDisplayMetrics().density) - (2 * this.paddingDp);
            int i2 = (int) (f2 / targetWidthDp);
            Math.abs((f2 / i2) - targetWidthDp);
            Math.abs((f2 / (i2 + 1)) - targetWidthDp);
            int iMin = Math.min(i2, this.maxSpanCount);
            setSpanCount(iMin);
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                while (recyclerView.getItemDecorationCount() > 0) {
                    recyclerView.removeItemDecorationAt(0);
                }
                if (this.paddingDp == 0.0f) {
                    return;
                }
                recyclerView.addItemDecoration(new Utils.GridSpacingItemDecoration(iMin, (int) (this.paddingDp * f), true, true, false));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onMeasure(recycler, state, widthSpec, heightSpec);
        int size = View.MeasureSpec.getSize(widthSpec);
        if (!this.autoSpanCountMode || size <= 0 || this.previousWidth == size) {
            return;
        }
        this.previousWidth = size;
        updateTargetWidthDp(this.targetItemWidthDp);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAttachedToWindow(view);
        this.recyclerView = view;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onInterceptFocusSearch(View focused, int direction) {
        Intrinsics.checkNotNullParameter(focused, "focused");
        View rootView = focused.getRootView();
        long jCurrentTimeMillis = System.currentTimeMillis();
        View viewOnInterceptFocusSearch = super.onInterceptFocusSearch(focused, direction);
        int position = getPosition(focused);
        Animation animation = null;
        if (this.focusBoundRight && direction == 66 && (position % getSpanCount() == getSpanCount() - 1 || position == getItemCount() - 1)) {
            Animation animation2 = this.shakeLeftAnimation;
            if (animation2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeLeftAnimation");
            } else {
                animation = animation2;
            }
            if ((!isSmoothScrolling() && !animation.hasStarted()) || animation.hasEnded()) {
                Context applicationContext = this.context.getApplicationContext();
                Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                ((DaijishouApplication) applicationContext).playReachBoundSfx(true);
                cancelAnimations();
                RecyclerView recyclerView = this.recyclerView;
                if (recyclerView != null) {
                    recyclerView.startAnimation(animation);
                }
            }
            if (this.lastFocusBoundReachedPosition != position || this.lastFocusBoundReachedDirection != 66) {
                this.lastFocusBoundReachedDirection = 66;
                this.lastFocusBoundReachedPosition = position;
                Function0<Unit> function0 = this.onFocusBoundReachedListener;
                if (function0 != null) {
                    function0.invoke();
                    return focused;
                }
            }
        } else if (this.focusBoundLeft && direction == 17 && position % getSpanCount() == 0) {
            Animation animation3 = this.shakeRightAnimation;
            if (animation3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeRightAnimation");
            } else {
                animation = animation3;
            }
            if ((!isSmoothScrolling() && !animation.hasStarted()) || animation.hasEnded()) {
                Context applicationContext2 = this.context.getApplicationContext();
                Intrinsics.checkNotNull(applicationContext2, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                ((DaijishouApplication) applicationContext2).playReachBoundSfx(true);
                cancelAnimations();
                RecyclerView recyclerView2 = this.recyclerView;
                if (recyclerView2 != null) {
                    recyclerView2.startAnimation(animation);
                }
            }
            if (this.lastFocusBoundReachedPosition != position || this.lastFocusBoundReachedDirection != 17) {
                this.lastFocusBoundReachedDirection = 17;
                this.lastFocusBoundReachedPosition = position;
                Function0<Unit> function1 = this.onFocusBoundReachedListener;
                if (function1 != null) {
                    function1.invoke();
                    return focused;
                }
            }
        } else if (this.focusBoundTop && direction == 33 && position < getSpanCount()) {
            Animation animation4 = this.shakeDownAnimation;
            if (animation4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeDownAnimation");
            } else {
                animation = animation4;
            }
            if ((!isSmoothScrolling() && !animation.hasStarted()) || animation.hasEnded()) {
                Context applicationContext3 = this.context.getApplicationContext();
                Intrinsics.checkNotNull(applicationContext3, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                ((DaijishouApplication) applicationContext3).playReachBoundSfx(true);
                cancelAnimations();
                RecyclerView recyclerView3 = this.recyclerView;
                if (recyclerView3 != null) {
                    recyclerView3.startAnimation(animation);
                }
            }
            if (this.lastFocusBoundReachedPosition != position || this.lastFocusBoundReachedDirection != 33) {
                this.lastFocusBoundReachedDirection = 33;
                this.lastFocusBoundReachedPosition = position;
                Function0<Unit> function2 = this.onFocusBoundReachedListener;
                if (function2 != null) {
                    function2.invoke();
                    return focused;
                }
            }
        } else if (this.focusBoundBottom && direction == 130 && position >= ((getItemCount() - 1) / getSpanCount()) * getSpanCount()) {
            Animation animation5 = this.shakeUpAnimation;
            if (animation5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeUpAnimation");
            } else {
                animation = animation5;
            }
            if ((!isSmoothScrolling() && !animation.hasStarted()) || animation.hasEnded()) {
                Context applicationContext4 = this.context.getApplicationContext();
                Intrinsics.checkNotNull(applicationContext4, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                ((DaijishouApplication) applicationContext4).playReachBoundSfx(true);
                cancelAnimations();
                RecyclerView recyclerView4 = this.recyclerView;
                if (recyclerView4 != null) {
                    recyclerView4.startAnimation(animation);
                }
            }
            if (this.lastFocusBoundReachedPosition != position || this.lastFocusBoundReachedDirection != 130) {
                this.lastFocusBoundReachedDirection = 130;
                this.lastFocusBoundReachedPosition = position;
                Function0<Unit> function3 = this.onFocusBoundReachedListener;
                if (function3 != null) {
                    function3.invoke();
                }
            }
        } else {
            if (!this.focusBoundRight && direction == 66 && position % getSpanCount() == getSpanCount() - 1) {
                RecyclerView recyclerView5 = this.recyclerView;
                if (recyclerView5 != null) {
                    Intrinsics.checkNotNull(recyclerView5);
                    View viewFindViewById = rootView.findViewById(recyclerView5.getNextFocusRightId());
                    if (viewFindViewById != null) {
                        return viewFindViewById;
                    }
                }
            } else if (!this.focusBoundLeft && direction == 17 && position % getSpanCount() == 0) {
                RecyclerView recyclerView6 = this.recyclerView;
                if (recyclerView6 != null) {
                    Intrinsics.checkNotNull(recyclerView6);
                    View viewFindViewById2 = rootView.findViewById(recyclerView6.getNextFocusLeftId());
                    if (viewFindViewById2 != null) {
                        return viewFindViewById2;
                    }
                }
            } else if (!this.focusBoundTop && direction == 33 && position < getSpanCount()) {
                RecyclerView recyclerView7 = this.recyclerView;
                if (recyclerView7 != null) {
                    Intrinsics.checkNotNull(recyclerView7);
                    View viewFindViewById3 = rootView.findViewById(recyclerView7.getNextFocusUpId());
                    if (viewFindViewById3 != null) {
                        return viewFindViewById3;
                    }
                }
            } else {
                if (this.focusBoundBottom || direction != 130 || position < ((getItemCount() - 1) / getSpanCount()) * getSpanCount()) {
                    if (direction != 130 && jCurrentTimeMillis - this.lastTimeMillis > 90) {
                        this.lastFocusBoundReachedPosition = -1;
                        this.lastTimeMillis = jCurrentTimeMillis;
                        return viewOnInterceptFocusSearch;
                    }
                    if (jCurrentTimeMillis - this.lastTimeMillis > 95) {
                        this.lastFocusBoundReachedPosition = -1;
                        this.lastTimeMillis = jCurrentTimeMillis;
                        return viewOnInterceptFocusSearch;
                    }
                    this.lastFocusBoundReachedPosition = -1;
                    return focused;
                }
                RecyclerView recyclerView8 = this.recyclerView;
                if (recyclerView8 != null) {
                    Intrinsics.checkNotNull(recyclerView8);
                    View viewFindViewById4 = rootView.findViewById(recyclerView8.getNextFocusDownId());
                    if (viewFindViewById4 != null) {
                        return viewFindViewById4;
                    }
                }
            }
            return viewOnInterceptFocusSearch;
        }
        return focused;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View focused, int focusDirection, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(focused, "focused");
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        return (focusDirection == 17 ? !this.focusBoundLeft : focusDirection == 33 ? !this.focusBoundTop : focusDirection == 66 ? !this.focusBoundRight : !(focusDirection == 130 && this.focusBoundBottom)) ? super.onFocusSearchFailed(focused, focusDirection, recycler, state) : focused;
    }
}
