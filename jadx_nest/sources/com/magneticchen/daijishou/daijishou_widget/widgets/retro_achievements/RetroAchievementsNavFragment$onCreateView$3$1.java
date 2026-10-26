package com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* INFO: compiled from: RetroAchievementsNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$3$1", f = "RetroAchievementsNavFragment.kt", i = {}, l = {614, 615}, m = "invokeSuspendImpl", n = {}, s = {})
final class RetroAchievementsNavFragment$onCreateView$3$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    int label;
    final /* synthetic */ RetroAchievementsNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    RetroAchievementsNavFragment$onCreateView$3$1(RetroAchievementsNavFragment retroAchievementsNavFragment, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = retroAchievementsNavFragment;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new RetroAchievementsNavFragment$onCreateView$3$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((RetroAchievementsNavFragment$onCreateView$3$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.this$0.getRetroAchievementsManager().resetCredentialsRetriedCount();
            this.label = 1;
            obj = this.this$0.getRetroAchievementsManager().getMyRetroAchievementsUsername(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        String str = (String) obj;
        if (str != null) {
            this.label = 2;
            if (this.this$0.getRetroAchievementsManager().refreshRetroAchievementsUserProfileData(str, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
