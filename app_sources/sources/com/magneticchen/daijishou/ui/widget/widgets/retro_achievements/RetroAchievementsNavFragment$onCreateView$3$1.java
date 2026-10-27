package com.magneticchen.daijishou.ui.widget.widgets.retro_achievements;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RetroAchievementsNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$3$1", f = "RetroAchievementsNavFragment.kt", i = {}, l = {457, 458}, m = "invokeSuspend", n = {}, s = {})
final class RetroAchievementsNavFragment$onCreateView$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RetroAchievementsNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RetroAchievementsNavFragment$onCreateView$3$1(RetroAchievementsNavFragment retroAchievementsNavFragment, Continuation<? super RetroAchievementsNavFragment$onCreateView$3$1> continuation) {
        super(2, continuation);
        this.this$0 = retroAchievementsNavFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RetroAchievementsNavFragment$onCreateView$3$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RetroAchievementsNavFragment$onCreateView$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        if (r1.refreshRetroAchievementsUserProfileData(r5, r4) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4f
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3c
        L1e:
            kotlin.ResultKt.throwOnFailure(r5)
            com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment r5 = r4.this$0
            com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager r5 = com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.access$getRetroAchievementsManager(r5)
            r5.resetCredentialsRetriedCount()
            com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment r5 = r4.this$0
            com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager r5 = com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.access$getRetroAchievementsManager(r5)
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4.label = r3
            java.lang.Object r5 = r5.getMyRetroAchievementsUsername(r1)
            if (r5 != r0) goto L3c
            goto L4e
        L3c:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L4f
            com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment r1 = r4.this$0
            com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager r1 = com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment.access$getRetroAchievementsManager(r1)
            r4.label = r2
            java.lang.Object r5 = r1.refreshRetroAchievementsUserProfileData(r5, r4)
            if (r5 != r0) goto L4f
        L4e:
            return r0
        L4f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
