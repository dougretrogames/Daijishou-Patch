package com.magneticchen.daijishou.retro_achievements.v2;

import com.google.android.gms.common.Scopes;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserProfileEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* INFO: compiled from: RetroAchievementsManager.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$refreshUserProfile$3", f = "RetroAchievementsManager.kt", i = {0, 0, 1}, l = {108, 124, 139}, m = "emit", n = {"this", Scopes.PROFILE, "this"}, s = {"L$0", "L$1", "L$0"})
final class RetroAchievementsManager$refreshUserProfile$3$emit$1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RetroAchievementsManager.AnonymousClass3 this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* WARN: Multi-variable type inference failed */
    RetroAchievementsManager$refreshUserProfile$3$emit$1(RetroAchievementsManager.AnonymousClass3 anonymousClass3, Continuation<?> continuation) {
        super(continuation);
        this.this$0 = anonymousClass3;
    }

    /* WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspendImpl(Object obj)throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((RetroAchievementsUserProfileEntity) null, (Continuation<?>) this);
    }
}
