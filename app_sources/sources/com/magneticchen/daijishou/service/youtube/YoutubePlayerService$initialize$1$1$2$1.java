package com.magneticchen.daijishou.service.youtube;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: YoutubePlayerService.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.service.youtube.YoutubePlayerService$initialize$1$1$2$1", f = "YoutubePlayerService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class YoutubePlayerService$initialize$1$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $it;
    final /* synthetic */ YoutubePlayerService $this_apply;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    YoutubePlayerService$initialize$1$1$2$1(YoutubePlayerService youtubePlayerService, String str, Continuation<? super YoutubePlayerService$initialize$1$1$2$1> continuation) {
        super(2, continuation);
        this.$this_apply = youtubePlayerService;
        this.$it = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new YoutubePlayerService$initialize$1$1$2$1(this.$this_apply, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((YoutubePlayerService$initialize$1$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$this_apply.getManager().loadVideo(this.$it);
        return Unit.INSTANCE;
    }
}
