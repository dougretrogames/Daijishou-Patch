package com.magneticchen.daijishou.ui.daijishou_recycler_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.features.Soundboard;
import com.magneticchen.daijishou.utils.DpToPxConverter;
import com.skydoves.balloon.internals.DefinitionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DaijishouLinearLayoutManager.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ;2\u00020\u0001:\u0001;B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0002\u0010\u000eJ\b\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001fH\u0016J.\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u00062\n\u00100\u001a\u000601R\u00020\u001f2\u0006\u00102\u001a\u000203H\u0016J\u001a\u00104\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020-2\u0006\u00105\u001a\u00020\u0006H\u0016J\b\u00106\u001a\u00020)H\u0002J\b\u00107\u001a\u00020)H\u0002J\b\u00108\u001a\u00020)H\u0002J\b\u00109\u001a\u00020)H\u0002J\b\u0010:\u001a\u00020)H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R\u000e\u0010&\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "dpToPxConverter", "Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "focusBoundEdge", "getFocusBoundEdge", "()Z", "setFocusBoundEdge", "(Z)V", "focusBoundEnd", "getFocusBoundEnd", "setFocusBoundEnd", "focusBoundStart", "getFocusBoundStart", "setFocusBoundStart", "lastTimeMillis", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "shakeDownAnimation", "Landroid/view/animation/Animation;", "shakeLeftAnimation", "shakeOnFocusBound", "getShakeOnFocusBound", "setShakeOnFocusBound", "shakeRightAnimation", "shakeUpAnimation", "cancelAnimations", "", "onAttachedToWindow", "view", "onFocusSearchFailed", "Landroid/view/View;", "focused", "focusDirection", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onInterceptFocusSearch", "direction", "setupAnimation", "startShakeDownAnimation", "startShakeLeftAnimation", "startShakeRightAnimation", "startShakeUpAnimation", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouLinearLayoutManager extends LinearLayoutManager {
    public static final Companion Companion = new Companion(null);
    private static final int coolDownMs = 45;
    private final Context context;
    private final DpToPxConverter dpToPxConverter;
    private boolean focusBoundEdge;
    private boolean focusBoundEnd;
    private boolean focusBoundStart;
    private long lastTimeMillis;
    private RecyclerView recyclerView;
    private Animation shakeDownAnimation;
    private Animation shakeLeftAnimation;
    private boolean shakeOnFocusBound;
    private Animation shakeRightAnimation;
    private Animation shakeUpAnimation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DaijishouLinearLayoutManager(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.lastTimeMillis = System.currentTimeMillis();
        this.shakeOnFocusBound = true;
        this.focusBoundEnd = true;
        this.focusBoundEdge = true;
        this.dpToPxConverter = new DpToPxConverter(context);
        this.context = context;
        setupAnimation();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DaijishouLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        Intrinsics.checkNotNullParameter(context, "context");
        this.lastTimeMillis = System.currentTimeMillis();
        this.shakeOnFocusBound = true;
        this.focusBoundEnd = true;
        this.focusBoundEdge = true;
        this.dpToPxConverter = new DpToPxConverter(context);
        this.context = context;
        setupAnimation();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DaijishouLinearLayoutManager(Context context, AttributeSet attrs, int i, int i2) {
        super(context, attrs, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.lastTimeMillis = System.currentTimeMillis();
        this.shakeOnFocusBound = true;
        this.focusBoundEnd = true;
        this.focusBoundEdge = true;
        this.dpToPxConverter = new DpToPxConverter(context);
        this.context = context;
        setupAnimation();
    }

    public final boolean getShakeOnFocusBound() {
        return this.shakeOnFocusBound;
    }

    public final void setShakeOnFocusBound(boolean z) {
        this.shakeOnFocusBound = z;
    }

    public final boolean getFocusBoundStart() {
        return this.focusBoundStart;
    }

    public final void setFocusBoundStart(boolean z) {
        this.focusBoundStart = z;
    }

    public final boolean getFocusBoundEnd() {
        return this.focusBoundEnd;
    }

    public final void setFocusBoundEnd(boolean z) {
        this.focusBoundEnd = z;
    }

    public final boolean getFocusBoundEdge() {
        return this.focusBoundEdge;
    }

    public final void setFocusBoundEdge(boolean z) {
        this.focusBoundEdge = z;
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

    private final void setupAnimation() {
        if (this.shakeOnFocusBound) {
            TranslateAnimation translateAnimation = new TranslateAnimation(DefinitionKt.NO_Float_VALUE, -this.dpToPxConverter.convert(12.0f), DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE);
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
            TranslateAnimation translateAnimation2 = new TranslateAnimation(DefinitionKt.NO_Float_VALUE, this.dpToPxConverter.convert(12.0f), DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE);
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
            TranslateAnimation translateAnimation3 = new TranslateAnimation(DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE, -this.dpToPxConverter.convert(12.0f));
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
            TranslateAnimation translateAnimation4 = new TranslateAnimation(DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE, DefinitionKt.NO_Float_VALUE, this.dpToPxConverter.convert(12.0f));
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

    private final void startShakeUpAnimation() {
        Animation animation = this.shakeUpAnimation;
        Animation animation2 = null;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shakeUpAnimation");
            animation = null;
        }
        if (animation.hasStarted()) {
            Animation animation3 = this.shakeUpAnimation;
            if (animation3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeUpAnimation");
                animation3 = null;
            }
            if (!animation3.hasEnded()) {
                return;
            }
        }
        Context applicationContext = this.context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        Soundboard.play$default(((DaijishouApplication) applicationContext).getSoundboard(), Soundboard.Sound.REACH_BOUND, false, 2, null);
        cancelAnimations();
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            Animation animation4 = this.shakeUpAnimation;
            if (animation4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeUpAnimation");
            } else {
                animation2 = animation4;
            }
            recyclerView.startAnimation(animation2);
        }
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
        Soundboard.play$default(((DaijishouApplication) applicationContext).getSoundboard(), Soundboard.Sound.REACH_BOUND, false, 2, null);
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

    private final void startShakeDownAnimation() {
        Animation animation = this.shakeDownAnimation;
        Animation animation2 = null;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shakeDownAnimation");
            animation = null;
        }
        if (animation.hasStarted()) {
            Animation animation3 = this.shakeDownAnimation;
            if (animation3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeDownAnimation");
                animation3 = null;
            }
            if (!animation3.hasEnded()) {
                return;
            }
        }
        Context applicationContext = this.context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        Soundboard.play$default(((DaijishouApplication) applicationContext).getSoundboard(), Soundboard.Sound.REACH_BOUND, false, 2, null);
        cancelAnimations();
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            Animation animation4 = this.shakeDownAnimation;
            if (animation4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeDownAnimation");
            } else {
                animation2 = animation4;
            }
            recyclerView.startAnimation(animation2);
        }
    }

    private final void startShakeLeftAnimation() {
        Animation animation = this.shakeLeftAnimation;
        Animation animation2 = null;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shakeLeftAnimation");
            animation = null;
        }
        if (animation.hasStarted()) {
            Animation animation3 = this.shakeLeftAnimation;
            if (animation3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeLeftAnimation");
                animation3 = null;
            }
            if (!animation3.hasEnded()) {
                return;
            }
        }
        Context applicationContext = this.context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        Soundboard.play$default(((DaijishouApplication) applicationContext).getSoundboard(), Soundboard.Sound.REACH_BOUND, false, 2, null);
        cancelAnimations();
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            Animation animation4 = this.shakeLeftAnimation;
            if (animation4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shakeLeftAnimation");
            } else {
                animation2 = animation4;
            }
            recyclerView.startAnimation(animation2);
        }
    }

    public void onAttachedToWindow(RecyclerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAttachedToWindow(view);
        this.recyclerView = view;
    }

    public View onInterceptFocusSearch(View focused, int i) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        RecyclerView recyclerView5;
        RecyclerView recyclerView6;
        RecyclerView recyclerView7;
        RecyclerView recyclerView8;
        Intrinsics.checkNotNullParameter(focused, "focused");
        View rootView = focused.getRootView();
        int position = getPosition(focused);
        long jCurrentTimeMillis = System.currentTimeMillis();
        View viewOnInterceptFocusSearch = super.onInterceptFocusSearch(focused, i);
        if (getOrientation() == 1 && !getReverseLayout()) {
            if (i == 33 && jCurrentTimeMillis - this.lastTimeMillis > 45) {
                this.lastTimeMillis = jCurrentTimeMillis;
                if (this.focusBoundStart && position == 0) {
                    startShakeDownAnimation();
                    return focused;
                }
                if (position == 0 && (recyclerView8 = this.recyclerView) != null) {
                    Intrinsics.checkNotNull(recyclerView8);
                    View viewFindViewById = rootView.findViewById(recyclerView8.getNextFocusUpId());
                    if (viewFindViewById != null) {
                        return viewFindViewById;
                    }
                }
            } else {
                if (i != 130 || jCurrentTimeMillis - this.lastTimeMillis <= 45) {
                    if (jCurrentTimeMillis - this.lastTimeMillis > 45) {
                        this.lastTimeMillis = jCurrentTimeMillis;
                        if (this.focusBoundEdge) {
                            if (i == 66) {
                                startShakeLeftAnimation();
                                return focused;
                            }
                            startShakeRightAnimation();
                            return focused;
                        }
                        RecyclerView recyclerView9 = this.recyclerView;
                        if (recyclerView9 != null) {
                            Intrinsics.checkNotNull(recyclerView9);
                            View viewFindViewById2 = rootView.findViewById(i == 66 ? recyclerView9.getNextFocusRightId() : recyclerView9.getNextFocusLeftId());
                            if (viewFindViewById2 != null) {
                                return viewFindViewById2;
                            }
                        }
                    }
                    return focused;
                }
                this.lastTimeMillis = jCurrentTimeMillis;
                if (this.focusBoundEnd && position == getItemCount() - 1) {
                    startShakeUpAnimation();
                    return focused;
                }
                if (position == getItemCount() - 1 && (recyclerView7 = this.recyclerView) != null) {
                    Intrinsics.checkNotNull(recyclerView7);
                    View viewFindViewById3 = rootView.findViewById(recyclerView7.getNextFocusDownId());
                    if (viewFindViewById3 != null) {
                        return viewFindViewById3;
                    }
                }
            }
            return viewOnInterceptFocusSearch;
        }
        if (getOrientation() == 1 && getReverseLayout()) {
            if (i == 130 && jCurrentTimeMillis - this.lastTimeMillis > 45) {
                this.lastTimeMillis = jCurrentTimeMillis;
                if (this.focusBoundStart && position == 0) {
                    startShakeUpAnimation();
                    return focused;
                }
                if (position == 0 && (recyclerView6 = this.recyclerView) != null) {
                    Intrinsics.checkNotNull(recyclerView6);
                    View viewFindViewById4 = rootView.findViewById(recyclerView6.getNextFocusDownId());
                    if (viewFindViewById4 != null) {
                        return viewFindViewById4;
                    }
                }
            } else {
                if (i != 33 || jCurrentTimeMillis - this.lastTimeMillis <= 45) {
                    if (jCurrentTimeMillis - this.lastTimeMillis > 45) {
                        this.lastTimeMillis = jCurrentTimeMillis;
                        if (this.focusBoundEdge) {
                            if (i == 66) {
                                startShakeLeftAnimation();
                                return focused;
                            }
                            startShakeRightAnimation();
                            return focused;
                        }
                        RecyclerView recyclerView10 = this.recyclerView;
                        if (recyclerView10 != null) {
                            Intrinsics.checkNotNull(recyclerView10);
                            View viewFindViewById5 = rootView.findViewById(i == 66 ? recyclerView10.getNextFocusRightId() : recyclerView10.getNextFocusLeftId());
                            if (viewFindViewById5 != null) {
                                return viewFindViewById5;
                            }
                        }
                    }
                    return focused;
                }
                this.lastTimeMillis = jCurrentTimeMillis;
                if (this.focusBoundEnd && position == getItemCount() - 1) {
                    startShakeDownAnimation();
                    return focused;
                }
                if (position == getItemCount() - 1 && (recyclerView5 = this.recyclerView) != null) {
                    Intrinsics.checkNotNull(recyclerView5);
                    View viewFindViewById6 = rootView.findViewById(recyclerView5.getNextFocusUpId());
                    if (viewFindViewById6 != null) {
                        return viewFindViewById6;
                    }
                }
            }
            return viewOnInterceptFocusSearch;
        }
        if (getOrientation() == 0 && !getReverseLayout()) {
            if (i == 17 && jCurrentTimeMillis - this.lastTimeMillis > 45) {
                this.lastTimeMillis = jCurrentTimeMillis;
                if (this.focusBoundStart && position == 0) {
                    startShakeRightAnimation();
                    return focused;
                }
                if (position == 0 && (recyclerView4 = this.recyclerView) != null) {
                    Intrinsics.checkNotNull(recyclerView4);
                    View viewFindViewById7 = rootView.findViewById(recyclerView4.getNextFocusLeftId());
                    if (viewFindViewById7 != null) {
                        return viewFindViewById7;
                    }
                }
            } else {
                if (i != 66 || jCurrentTimeMillis - this.lastTimeMillis <= 45) {
                    if (jCurrentTimeMillis - this.lastTimeMillis > 45) {
                        this.lastTimeMillis = jCurrentTimeMillis;
                        if (this.focusBoundEdge) {
                            if (i == 33) {
                                startShakeDownAnimation();
                                return focused;
                            }
                            startShakeUpAnimation();
                            return focused;
                        }
                        RecyclerView recyclerView11 = this.recyclerView;
                        if (recyclerView11 != null) {
                            Intrinsics.checkNotNull(recyclerView11);
                            View viewFindViewById8 = rootView.findViewById(i == 33 ? recyclerView11.getNextFocusUpId() : recyclerView11.getNextFocusDownId());
                            if (viewFindViewById8 != null) {
                                return viewFindViewById8;
                            }
                        }
                    }
                    return focused;
                }
                this.lastTimeMillis = jCurrentTimeMillis;
                if (this.focusBoundEnd && position == getItemCount() - 1) {
                    startShakeLeftAnimation();
                    return focused;
                }
                if (position == getItemCount() - 1 && (recyclerView3 = this.recyclerView) != null) {
                    Intrinsics.checkNotNull(recyclerView3);
                    View viewFindViewById9 = rootView.findViewById(recyclerView3.getNextFocusRightId());
                    if (viewFindViewById9 != null) {
                        return viewFindViewById9;
                    }
                }
            }
            return viewOnInterceptFocusSearch;
        }
        if (getOrientation() != 0 || !getReverseLayout()) {
            return super.onInterceptFocusSearch(focused, i);
        }
        if (i == 66 && jCurrentTimeMillis - this.lastTimeMillis > 45) {
            this.lastTimeMillis = jCurrentTimeMillis;
            if (this.focusBoundStart && position == 0) {
                startShakeLeftAnimation();
                return focused;
            }
            if (position == 0 && (recyclerView2 = this.recyclerView) != null) {
                Intrinsics.checkNotNull(recyclerView2);
                View viewFindViewById10 = rootView.findViewById(recyclerView2.getNextFocusRightId());
                if (viewFindViewById10 != null) {
                    return viewFindViewById10;
                }
            }
        } else {
            if (i != 17 || jCurrentTimeMillis - this.lastTimeMillis <= 45) {
                if (jCurrentTimeMillis - this.lastTimeMillis > 45) {
                    this.lastTimeMillis = jCurrentTimeMillis;
                    if (this.focusBoundEdge) {
                        if (i == 33) {
                            startShakeDownAnimation();
                            return focused;
                        }
                        startShakeUpAnimation();
                        return focused;
                    }
                    RecyclerView recyclerView12 = this.recyclerView;
                    if (recyclerView12 != null) {
                        Intrinsics.checkNotNull(recyclerView12);
                        View viewFindViewById11 = rootView.findViewById(i == 33 ? recyclerView12.getNextFocusUpId() : recyclerView12.getNextFocusDownId());
                        if (viewFindViewById11 != null) {
                            return viewFindViewById11;
                        }
                    }
                }
                return focused;
            }
            this.lastTimeMillis = jCurrentTimeMillis;
            if (this.focusBoundEnd && position == getItemCount() - 1) {
                startShakeRightAnimation();
                return focused;
            }
            if (position == getItemCount() - 1 && (recyclerView = this.recyclerView) != null) {
                Intrinsics.checkNotNull(recyclerView);
                View viewFindViewById12 = rootView.findViewById(recyclerView.getNextFocusLeftId());
                if (viewFindViewById12 != null) {
                    return viewFindViewById12;
                }
            }
        }
        return viewOnInterceptFocusSearch;
    }

    public View onFocusSearchFailed(View focused, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(focused, "focused");
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        return (getOrientation() != 1 || getReverseLayout() ? !(getOrientation() == 1 && getReverseLayout()) ? !(getOrientation() != 0 || getReverseLayout() ? !(getOrientation() == 0 && getReverseLayout() && i == 17) : i != 66) : i == 33 : i != 130) ? super.onFocusSearchFailed(focused, i, recycler, state) : focused;
    }

    /* JADX INFO: compiled from: DaijishouLinearLayoutManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouLinearLayoutManager$Companion;", "", "()V", "coolDownMs", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
