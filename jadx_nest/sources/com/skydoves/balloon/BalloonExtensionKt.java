package com.skydoves.balloon;

import android.view.View;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BalloonExtension.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a8\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u000b\u001a(\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007\u001a.\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u000e\u001a(\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007\u001a.\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u000e\u001a(\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007\u001a.\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u000e\u001a(\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007\u001a(\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007\u001a.\u0010\u0015\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u000e\u001a(\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007\u001a(\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007\u001a.\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u000e\u001a@\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007\u001aF\u0010\u001e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001a \u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0004\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010!H\u0081\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"showAtCenter", "", "Landroid/view/View;", "balloon", "Lcom/skydoves/balloon/Balloon;", "xOff", "", "yOff", "centerAlign", "Lcom/skydoves/balloon/BalloonCenterAlign;", "awaitAtCenter", "(Landroid/view/View;Lcom/skydoves/balloon/Balloon;IILcom/skydoves/balloon/BalloonCenterAlign;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showAsDropDown", "awaitAsDropDown", "(Landroid/view/View;Lcom/skydoves/balloon/Balloon;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showAlignTop", "awaitAlignTop", "showAlignBottom", "awaitAlignBottom", "showAlignRight", "showAlignEnd", "awaitAlignEnd", "showAlignLeft", "showAlignStart", "awaitAlignStart", "showAlign", "align", "Lcom/skydoves/balloon/BalloonAlign;", "subAnchorList", "", "awaitAlign", "(Landroid/view/View;Lcom/skydoves/balloon/Balloon;Lcom/skydoves/balloon/BalloonAlign;Ljava/util/List;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "block", "Lkotlin/Function0;", "balloon_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BalloonExtensionKt {
    public static final /* synthetic */ void showAlign(View view, Balloon balloon, BalloonAlign align) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(align, "align");
        showAlign$default(view, balloon, align, null, 0, 0, 28, null);
    }

    public static final /* synthetic */ void showAlign(View view, Balloon balloon, BalloonAlign align, List subAnchorList) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(subAnchorList, "subAnchorList");
        showAlign$default(view, balloon, align, subAnchorList, 0, 0, 24, null);
    }

    public static final /* synthetic */ void showAlign(View view, Balloon balloon, BalloonAlign align, List subAnchorList, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(subAnchorList, "subAnchorList");
        showAlign$default(view, balloon, align, subAnchorList, i, 0, 16, null);
    }

    public static final /* synthetic */ void showAlignBottom(View view, Balloon balloon) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAlignBottom$default(view, balloon, 0, 0, 6, null);
    }

    public static final /* synthetic */ void showAlignBottom(View view, Balloon balloon, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAlignBottom$default(view, balloon, i, 0, 4, null);
    }

    public static final /* synthetic */ void showAlignEnd(View view, Balloon balloon) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAlignEnd$default(view, balloon, 0, 0, 6, null);
    }

    public static final /* synthetic */ void showAlignEnd(View view, Balloon balloon, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAlignEnd$default(view, balloon, i, 0, 4, null);
    }

    @Deprecated(message = "Use showAlignStart instead.", replaceWith = @ReplaceWith(expression = "showAlignStart(balloon, xOff, yOff)", imports = {}))
    public static final /* synthetic */ void showAlignLeft(View view, Balloon balloon) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAlignLeft$default(view, balloon, 0, 0, 6, null);
    }

    @Deprecated(message = "Use showAlignStart instead.", replaceWith = @ReplaceWith(expression = "showAlignStart(balloon, xOff, yOff)", imports = {}))
    public static final /* synthetic */ void showAlignLeft(View view, Balloon balloon, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAlignLeft$default(view, balloon, i, 0, 4, null);
    }

    @Deprecated(message = "Use showAlignEnd instead.", replaceWith = @ReplaceWith(expression = "showAlignEnd(balloon, xOff, yOff)", imports = {}))
    public static final /* synthetic */ void showAlignRight(View view, Balloon balloon) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAlignRight$default(view, balloon, 0, 0, 6, null);
    }

    @Deprecated(message = "Use showAlignEnd instead.", replaceWith = @ReplaceWith(expression = "showAlignEnd(balloon, xOff, yOff)", imports = {}))
    public static final /* synthetic */ void showAlignRight(View view, Balloon balloon, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAlignRight$default(view, balloon, i, 0, 4, null);
    }

    public static final /* synthetic */ void showAlignStart(View view, Balloon balloon) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAlignStart$default(view, balloon, 0, 0, 6, null);
    }

    public static final /* synthetic */ void showAlignStart(View view, Balloon balloon, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAlignStart$default(view, balloon, i, 0, 4, null);
    }

    public static final /* synthetic */ void showAlignTop(View view, Balloon balloon) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAlignTop$default(view, balloon, 0, 0, 6, null);
    }

    public static final /* synthetic */ void showAlignTop(View view, Balloon balloon, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAlignTop$default(view, balloon, i, 0, 4, null);
    }

    public static final /* synthetic */ void showAsDropDown(View view, Balloon balloon) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAsDropDown$default(view, balloon, 0, 0, 6, null);
    }

    public static final /* synthetic */ void showAsDropDown(View view, Balloon balloon, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAsDropDown$default(view, balloon, i, 0, 4, null);
    }

    public static final /* synthetic */ void showAtCenter(View view, Balloon balloon) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAtCenter$default(view, balloon, 0, 0, null, 14, null);
    }

    public static final /* synthetic */ void showAtCenter(View view, Balloon balloon, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAtCenter$default(view, balloon, i, 0, null, 12, null);
    }

    public static final /* synthetic */ void showAtCenter(View view, Balloon balloon, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        showAtCenter$default(view, balloon, i, i2, null, 8, null);
    }

    public static /* synthetic */ void showAtCenter$default(View view, Balloon balloon, int i, int i2, BalloonCenterAlign balloonCenterAlign, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        if ((i3 & 8) != 0) {
            balloonCenterAlign = BalloonCenterAlign.TOP;
        }
        showAtCenter(view, balloon, i, i2, balloonCenterAlign);
    }

    public static /* synthetic */ Object awaitAtCenter$default(View view, Balloon balloon, int i, int i2, BalloonCenterAlign balloonCenterAlign, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        if ((i3 & 8) != 0) {
            balloonCenterAlign = BalloonCenterAlign.TOP;
        }
        return awaitAtCenter(view, balloon, i, i2, balloonCenterAlign, continuation);
    }

    public static final Object awaitAtCenter(View view, Balloon balloon, int i, int i2, BalloonCenterAlign balloonCenterAlign, Continuation<? super Unit> continuation) {
        Object objAwaitAtCenter = balloon.awaitAtCenter(view, i, i2, balloonCenterAlign, continuation);
        return objAwaitAtCenter == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitAtCenter : Unit.INSTANCE;
    }

    public static /* synthetic */ void showAsDropDown$default(View view, Balloon balloon, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        showAsDropDown(view, balloon, i, i2);
    }

    public static /* synthetic */ Object awaitAsDropDown$default(View view, Balloon balloon, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return awaitAsDropDown(view, balloon, i, i2, continuation);
    }

    public static final Object awaitAsDropDown(View view, Balloon balloon, int i, int i2, Continuation<? super Unit> continuation) {
        Object objAwaitAsDropDown = balloon.awaitAsDropDown(view, i, i2, continuation);
        return objAwaitAsDropDown == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitAsDropDown : Unit.INSTANCE;
    }

    public static /* synthetic */ void showAlignTop$default(View view, Balloon balloon, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        showAlignTop(view, balloon, i, i2);
    }

    public static /* synthetic */ Object awaitAlignTop$default(View view, Balloon balloon, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return awaitAlignTop(view, balloon, i, i2, continuation);
    }

    public static final Object awaitAlignTop(View view, Balloon balloon, int i, int i2, Continuation<? super Unit> continuation) {
        Object objAwaitAlignTop = balloon.awaitAlignTop(view, i, i2, continuation);
        return objAwaitAlignTop == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitAlignTop : Unit.INSTANCE;
    }

    public static /* synthetic */ void showAlignBottom$default(View view, Balloon balloon, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        showAlignBottom(view, balloon, i, i2);
    }

    public static /* synthetic */ Object awaitAlignBottom$default(View view, Balloon balloon, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return awaitAlignBottom(view, balloon, i, i2, continuation);
    }

    public static final Object awaitAlignBottom(View view, Balloon balloon, int i, int i2, Continuation<? super Unit> continuation) {
        Object objAwaitAlignBottom = balloon.awaitAlignBottom(view, i, i2, continuation);
        return objAwaitAlignBottom == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitAlignBottom : Unit.INSTANCE;
    }

    public static /* synthetic */ void showAlignRight$default(View view, Balloon balloon, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        showAlignRight(view, balloon, i, i2);
    }

    public static /* synthetic */ void showAlignEnd$default(View view, Balloon balloon, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        showAlignEnd(view, balloon, i, i2);
    }

    public static /* synthetic */ Object awaitAlignEnd$default(View view, Balloon balloon, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return awaitAlignEnd(view, balloon, i, i2, continuation);
    }

    public static final Object awaitAlignEnd(View view, Balloon balloon, int i, int i2, Continuation<? super Unit> continuation) {
        Object objAwaitAlignEnd = balloon.awaitAlignEnd(view, i, i2, continuation);
        return objAwaitAlignEnd == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitAlignEnd : Unit.INSTANCE;
    }

    public static /* synthetic */ void showAlignLeft$default(View view, Balloon balloon, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        showAlignLeft(view, balloon, i, i2);
    }

    public static /* synthetic */ void showAlignStart$default(View view, Balloon balloon, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        showAlignStart(view, balloon, i, i2);
    }

    public static /* synthetic */ Object awaitAlignStart$default(View view, Balloon balloon, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return awaitAlignStart(view, balloon, i, i2, continuation);
    }

    public static final Object awaitAlignStart(View view, Balloon balloon, int i, int i2, Continuation<? super Unit> continuation) {
        Object objAwaitAlignStart = balloon.awaitAlignStart(view, i, i2, continuation);
        return objAwaitAlignStart == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitAlignStart : Unit.INSTANCE;
    }

    public static /* synthetic */ void showAlign$default(View view, Balloon balloon, BalloonAlign balloonAlign, List list, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        showAlign(view, balloon, balloonAlign, list, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2);
    }

    public static /* synthetic */ Object awaitAlign$default(View view, Balloon balloon, BalloonAlign balloonAlign, List list, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        return awaitAlign(view, balloon, balloonAlign, list, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2, continuation);
    }

    public static final Object awaitAlign(View view, Balloon balloon, BalloonAlign balloonAlign, List<? extends View> list, int i, int i2, Continuation<? super Unit> continuation) {
        Object objAwaitAlign = balloon.awaitAlign(balloonAlign, view, list, i, i2, continuation);
        return objAwaitAlign == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitAlign : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.skydoves.balloon.BalloonExtensionKt$balloon$1, reason: invalid class name */
    /* JADX INFO: compiled from: BalloonExtension.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Function0<Unit> $block;

        public AnonymousClass1(Function0<Unit> function0) {
            this.$block = function0;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.$block.invoke();
        }
    }

    public static final /* synthetic */ void balloon(View view, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        view.post(new AnonymousClass1(block));
    }

    public static final /* synthetic */ void showAtCenter(View view, Balloon balloon, int i, int i2, BalloonCenterAlign centerAlign) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(centerAlign, "centerAlign");
        view.post(new BalloonExtensionKt$showAtCenter$$inlined$balloon$1(balloon, view, i, i2, centerAlign));
    }

    public static final /* synthetic */ void showAsDropDown(View view, Balloon balloon, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new BalloonExtensionKt$showAsDropDown$$inlined$balloon$1(balloon, view, i, i2));
    }

    public static final /* synthetic */ void showAlignTop(View view, Balloon balloon, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new BalloonExtensionKt$showAlignTop$$inlined$balloon$1(balloon, view, i, i2));
    }

    public static final /* synthetic */ void showAlignBottom(View view, Balloon balloon, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new BalloonExtensionKt$showAlignBottom$$inlined$balloon$1(balloon, view, i, i2));
    }

    @Deprecated(message = "Use showAlignEnd instead.", replaceWith = @ReplaceWith(expression = "showAlignEnd(balloon, xOff, yOff)", imports = {}))
    public static final /* synthetic */ void showAlignRight(View view, Balloon balloon, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new BalloonExtensionKt$showAlignRight$$inlined$balloon$1(balloon, view, i, i2));
    }

    public static final /* synthetic */ void showAlignEnd(View view, Balloon balloon, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new BalloonExtensionKt$showAlignEnd$$inlined$balloon$1(balloon, view, i, i2));
    }

    @Deprecated(message = "Use showAlignStart instead.", replaceWith = @ReplaceWith(expression = "showAlignStart(balloon, xOff, yOff)", imports = {}))
    public static final /* synthetic */ void showAlignLeft(View view, Balloon balloon, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new BalloonExtensionKt$showAlignLeft$$inlined$balloon$1(balloon, view, i, i2));
    }

    public static final /* synthetic */ void showAlignStart(View view, Balloon balloon, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new BalloonExtensionKt$showAlignStart$$inlined$balloon$1(balloon, view, i, i2));
    }

    public static final /* synthetic */ void showAlign(View view, Balloon balloon, BalloonAlign align, List subAnchorList, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(subAnchorList, "subAnchorList");
        view.post(new BalloonExtensionKt$showAlign$$inlined$balloon$1(balloon, align, view, subAnchorList, i, i2));
    }
}
