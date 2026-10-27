package com.magneticchen.daijishou.features.retroachievements.v2;

import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserProfileEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: RetroAchievementsManager.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$refreshUserProfile$3", f = "RetroAchievementsManager.kt", i = {0, 0, 1}, l = {108, 124, 139}, m = "emit", n = {"this", "profile", "this"}, s = {"L$0", "L$1", "L$0"})
final class RetroAchievementsManager$refreshUserProfile$3$emit$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RetroAchievementsManager.AnonymousClass3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RetroAchievementsManager$refreshUserProfile$3$emit$1(RetroAchievementsManager.AnonymousClass3 anonymousClass3, Continuation continuation) {
        super(continuation);
        this.this$0 = anonymousClass3;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((RetroAchievementsUserProfileEntity) null, (Continuation<? super Unit>) this);
    }
}
