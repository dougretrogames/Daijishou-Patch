package com.magneticchen.daijishou.features.retroachievements;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* INFO: compiled from: RetroAchievementsManager.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsCredentials$4$1", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
final class RetroAchievementsManager$refreshRetroAchievementsCredentials$4$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    int label;
    final /* synthetic */ RetroAchievementsManager this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    RetroAchievementsManager$refreshRetroAchievementsCredentials$4$1(RetroAchievementsManager retroAchievementsManager, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = retroAchievementsManager;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new RetroAchievementsManager$refreshRetroAchievementsCredentials$4$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((RetroAchievementsManager$refreshRetroAchievementsCredentials$4$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.getMyUsernameLiveData().setValue(null);
        return Unit.INSTANCE;
    }
}
