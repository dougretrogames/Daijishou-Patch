package com.skydoves.balloon;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Balloon.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0019\b\u0004\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"createBalloon", "Lcom/skydoves/balloon/Balloon;", "context", "Landroid/content/Context;", "block", "Lkotlin/Function1;", "Lcom/skydoves/balloon/Balloon$Builder;", "", "Lkotlin/ExtensionFunctionType;", "balloon_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BalloonKt {
    @BalloonInlineDsl
    public static final /* synthetic */ Balloon createBalloon(Context context, Function1<? super Balloon.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        Balloon.Builder builder = new Balloon.Builder(context);
        block.invoke(builder);
        return builder.build();
    }
}
