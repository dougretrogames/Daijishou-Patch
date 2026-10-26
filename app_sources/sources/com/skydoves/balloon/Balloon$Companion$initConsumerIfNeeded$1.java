package com.skydoves.balloon;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* INFO: compiled from: Balloon.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.skydoves.balloon.Balloon$Companion$initConsumerIfNeeded$1", f = "Balloon.kt", i = {0, 1}, l = {3330, 3355}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
final class Balloon$Companion$initConsumerIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    Balloon$Companion$initConsumerIfNeeded$1(Continuation<? super Balloon$Companion$initConsumerIfNeeded$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Balloon$Companion$initConsumerIfNeeded$1 balloon$Companion$initConsumerIfNeeded$1 = new Balloon$Companion$initConsumerIfNeeded$1(continuation);
        balloon$Companion$initConsumerIfNeeded$1.L$0 = obj;
        return balloon$Companion$initConsumerIfNeeded$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Balloon$Companion$initConsumerIfNeeded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* WARN: Code duplicated, block: B:11:0x0040 A[PHI: r1 r4
  0x0040: PHI (r1v5 kotlinx.coroutines.channels.ChannelIterator<com.skydoves.balloon.DeferredBalloonGroup>) = 
  (r1v3 kotlinx.coroutines.channels.ChannelIterator<com.skydoves.balloon.DeferredBalloonGroup>)
  (r1v4 kotlinx.coroutines.channels.ChannelIterator<com.skydoves.balloon.DeferredBalloonGroup>)
  (r1v4 kotlinx.coroutines.channels.ChannelIterator<com.skydoves.balloon.DeferredBalloonGroup>)
  (r1v9 kotlinx.coroutines.channels.ChannelIterator<com.skydoves.balloon.DeferredBalloonGroup>)
 binds: [B:10:0x002e, B:17:0x0067, B:30:0x00d1, B:6:0x000e] A[DONT_GENERATE, DONT_INLINE]
  0x0040: PHI (r4v2 kotlinx.coroutines.CoroutineScope) = 
  (r4v0 kotlinx.coroutines.CoroutineScope)
  (r4v1 kotlinx.coroutines.CoroutineScope)
  (r4v1 kotlinx.coroutines.CoroutineScope)
  (r4v6 kotlinx.coroutines.CoroutineScope)
 binds: [B:10:0x002e, B:17:0x0067, B:30:0x00d1, B:6:0x000e] A[DONT_GENERATE, DONT_INLINE]] */
    /* WARN: Code duplicated, block: B:14:0x0051 A[PHI: r1 r4 r14
  0x0051: PHI (r1v4 kotlinx.coroutines.channels.ChannelIterator<com.skydoves.balloon.DeferredBalloonGroup>) = 
  (r1v5 kotlinx.coroutines.channels.ChannelIterator<com.skydoves.balloon.DeferredBalloonGroup>)
  (r1v7 kotlinx.coroutines.channels.ChannelIterator<com.skydoves.balloon.DeferredBalloonGroup>)
 binds: [B:12:0x004d, B:9:0x0022] A[DONT_GENERATE, DONT_INLINE]
  0x0051: PHI (r4v1 kotlinx.coroutines.CoroutineScope) = (r4v2 kotlinx.coroutines.CoroutineScope), (r4v4 kotlinx.coroutines.CoroutineScope) binds: [B:12:0x004d, B:9:0x0022] A[DONT_GENERATE, DONT_INLINE]
  0x0051: PHI (r14v3 java.lang.Object) = (r14v14 java.lang.Object), (r14v0 java.lang.Object) binds: [B:12:0x004d, B:9:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    /* WARN: Code duplicated, block: B:16:0x0059  */
    /* WARN: Code duplicated, block: B:18:0x0069  */
    /* WARN: Code duplicated, block: B:21:0x007f  */
    /* WARN: Code duplicated, block: B:35:0x0097 A[SYNTHETIC] */
    /* WARN: Code duplicated, block: B:36:0x00ab A[SYNTHETIC] */
    /* WARN: Code duplicated, block: B:37:0x00a7 A[SYNTHETIC] */
    /* WARN: Code duplicated, block: B:38:0x009d A[SYNTHETIC] */
    /* WARN: Code duplicated, block: B:40:0x0079 A[SYNTHETIC] */
    /* WARN: Code duplicated, block: B:42:0x0079 A[SYNTHETIC] */
    /* WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0067 -> B:11:0x0040). Please report as a decompilation issue!!! */
    /* WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00d1 -> B:11:0x0040). Please report as a decompilation issue!!! */
    /* ERROR: decompilerOverflowException in pass: RegionMakerVisitor
        decompiler.core.utils.exceptions.decompilerOverflowException: Regions stack size limit reached
        	at decompiler.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at decompiler.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at decompiler.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.skydoves.balloon.Balloon$Companion$initConsumerIfNeeded$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* INFO: renamed from: com.skydoves.balloon.Balloon$Companion$initConsumerIfNeeded$1$1, reason: invalid class name */
    /* INFO: compiled from: Balloon.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.skydoves.balloon.Balloon$Companion$initConsumerIfNeeded$1$1", f = "Balloon.kt", i = {}, l = {3362}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Balloon $balloon;
        final /* synthetic */ DeferredBalloonGroup $group;
        final /* synthetic */ BalloonPlacement $placement;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Balloon balloon, BalloonPlacement balloonPlacement, DeferredBalloonGroup deferredBalloonGroup, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$balloon = balloon;
            this.$placement = balloonPlacement;
            this.$group = deferredBalloonGroup;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$balloon, this.$placement, this.$group, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Balloon balloon = this.$balloon;
                BalloonPlacement balloonPlacement = this.$placement;
                DeferredBalloonGroup deferredBalloonGroup = this.$group;
                this.L$0 = balloon;
                this.L$1 = balloonPlacement;
                this.L$2 = deferredBalloonGroup;
                this.label = 1;
                AnonymousClass1 anonymousClass1 = this;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(anonymousClass1), 1);
                cancellableContinuationImpl.initCancellability();
                balloon.show(balloonPlacement);
                balloon.setOnBalloonDismissListener(new Balloon$Companion$initConsumerIfNeeded$1$1$1$1(cancellableContinuationImpl, balloon.builder.getOnBalloonDismissListener(), deferredBalloonGroup));
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(anonymousClass1);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
