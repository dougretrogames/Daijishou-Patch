package com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements;

import androidx.core.app.FrameMetricsAggregator;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0054, code lost:
    
        if (r7.this$1.getRetroAchievementsManager().refreshMyRetroAchievementsGameRecordByGameIdIfExpired(r7.$item.getGameId(), r7) == r0) goto L17;
     */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspendImpl(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r8)
            goto L57
        L12:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1a:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L2f
        L1e:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.label = r3
            r3 = 1500(0x5dc, double:7.41E-321)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r3, r8)
            if (r8 != r0) goto L2f
            goto L56
        L2f:
            com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$GameListAdapter$ViewHolder r8 = r7.this$0
            long r3 = com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment.GameListAdapter.ViewHolder.access$getGameId$p(r8)
            com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity r8 = r7.$item
            long r5 = r8.getGameId()
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L57
            com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment r8 = r7.this$1
            com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager r8 = com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment.access$getRetroAchievementsManager(r8)
            com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity r1 = r7.$item
            long r3 = r1.getGameId()
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r7.label = r2
            java.lang.Object r8 = r8.refreshMyRetroAchievementsGameRecordByGameIdIfExpired(r3, r1)
            if (r8 != r0) goto L57
        L56:
            return r0
        L57:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$GameListAdapter$ViewHolder$onBind$1.invokeSuspendImpl(java.lang.Object):java.lang.Object");
    }
}
