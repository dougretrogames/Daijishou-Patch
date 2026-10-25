package com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements;

import androidx.core.app.FrameMetricsAggregator;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: RetroAchievementsNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$GameListAdapter$ViewHolder$onBind$1", f = "RetroAchievementsNavFragment.kt", i = {}, l = {FrameMetricsAggregator.EVERY_DURATION, 512}, m = "invokeSuspendImpl", n = {}, s = {})
final class RetroAchievementsNavFragment$GameListAdapter$ViewHolder$onBind$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ RetroAchievementsGameRecordEntity $item;
    int label;
    final /* synthetic */ RetroAchievementsNavFragment.GameListAdapter.ViewHolder this$0;
    final /* synthetic */ RetroAchievementsNavFragment this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RetroAchievementsNavFragment$GameListAdapter$ViewHolder$onBind$1(RetroAchievementsNavFragment.GameListAdapter.ViewHolder viewHolder, RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity, RetroAchievementsNavFragment retroAchievementsNavFragment, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = viewHolder;
        this.$item = retroAchievementsGameRecordEntity;
        this.this$1 = retroAchievementsNavFragment;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new RetroAchievementsNavFragment$GameListAdapter$ViewHolder$onBind$1(this.this$0, this.$item, this.this$1, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((RetroAchievementsNavFragment$GameListAdapter$ViewHolder$onBind$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
            this.label = 1;
            if (DelayKt.delay(1500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (this.this$0.gameId == this.$item.getGameId()) {
            this.label = 2;
            if (this.this$1.getRetroAchievementsManager().refreshMyRetroAchievementsGameRecordByGameIdIfExpired(this.$item.getGameId(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
