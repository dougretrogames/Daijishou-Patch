package com.magneticchen.daijishou.dialog_fragments;

import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.RetroAchievementsGameDialogFragment$onCreateView$6$1", f = "RetroAchievementsGameDialogFragment.kt", i = {}, l = {815}, m = "invokeSuspendImpl", n = {}, s = {})
final class RetroAchievementsGameDialogFragment$onCreateView$6$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ RetroAchievementsGameRecordEntity $retroAchievementsGameRecord;
    int label;
    final /* synthetic */ RetroAchievementsGameDialogFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    RetroAchievementsGameDialogFragment$onCreateView$6$1(RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment, RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = retroAchievementsGameDialogFragment;
        this.$retroAchievementsGameRecord = retroAchievementsGameRecordEntity;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new RetroAchievementsGameDialogFragment$onCreateView$6$1(this.this$0, this.$retroAchievementsGameRecord, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((RetroAchievementsGameDialogFragment$onCreateView$6$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.getRetroAchievementsManager().refreshMyRetroAchievementsGameRecordByGameId(this.$retroAchievementsGameRecord.getGameId(), this) == coroutine_suspended) {
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
