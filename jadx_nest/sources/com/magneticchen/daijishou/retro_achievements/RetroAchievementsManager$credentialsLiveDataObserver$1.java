package com.magneticchen.daijishou.retro_achievements;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RetroAchievementsManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "credentials", "Lkotlin/Pair;", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RetroAchievementsManager$credentialsLiveDataObserver$1 extends Lambda<Unit> implements Function1<Pair<? extends String, ? extends String>, Unit> {
    final /* synthetic */ RetroAchievementsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RetroAchievementsManager$credentialsLiveDataObserver$1(RetroAchievementsManager retroAchievementsManager) {
        super(1);
        this.this$0 = retroAchievementsManager;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$credentialsLiveDataObserver$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$credentialsLiveDataObserver$1$1", f = "RetroAchievementsManager.kt", i = {}, l = {147}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RetroAchievementsManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RetroAchievementsManager retroAchievementsManager, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = retroAchievementsManager;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.logger.info((CoroutineScope) this.L$0, "Refreshing RetroAchievements Credentials. Because credentials has changed.");
                    this.this$0.credentialsRetriedCount = 0;
                    RetroAchievementsManager retroAchievementsManager = this.this$0;
                    this.label = 1;
                    if (retroAchievementsManager.refreshRetroAchievementsCredentials(!retroAchievementsManager.firstLogin, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0.firstLogin = false;
            } catch (Exception e) {
                this.this$0.logger.warn(this.this$0, ExceptionsKt.stackTraceToString(e));
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends String> pair) {
        invoke2((Pair<String, String>) pair);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<String, String> credentials) {
        Intrinsics.checkNotNullParameter(credentials, "credentials");
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new AnonymousClass1(this.this$0, null), 2, null);
    }
}
