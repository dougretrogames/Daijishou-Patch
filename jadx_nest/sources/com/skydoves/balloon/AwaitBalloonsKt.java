package com.skydoves.balloon;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AwaitBalloons.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0086@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"awaitBalloons", "", "block", "Lkotlin/Function1;", "Lcom/skydoves/balloon/AwaitBalloonsDsl;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "balloon_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AwaitBalloonsKt {
    public static final Object awaitBalloons(Function1<? super AwaitBalloonsDsl, Unit> function1, Continuation<? super Unit> continuation) {
        AwaitBalloonsDslImpl awaitBalloonsDslImpl = new AwaitBalloonsDslImpl();
        function1.invoke(awaitBalloonsDslImpl);
        DeferredBalloonGroup deferredBalloonGroupBuild = awaitBalloonsDslImpl.build();
        Balloon.INSTANCE.initConsumerIfNeeded();
        Object objSend = Balloon.INSTANCE.getChannel().send(deferredBalloonGroupBuild, continuation);
        return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
    }
}
