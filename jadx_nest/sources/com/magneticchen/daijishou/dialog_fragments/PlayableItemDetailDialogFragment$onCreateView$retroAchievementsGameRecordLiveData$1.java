package com.magneticchen.daijishou.dialog_fragments;

import android.widget.TextView;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataScope;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.repositories.RetroAchievementsRepository;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u00032H\u0010\u0004\u001aD\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007 \b*!\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005¢\u0006\u0002\b\u00030\u0005¢\u0006\u0002\b\u0003H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lkotlin/jvm/JvmSuppressWildcards;", "it", "Lkotlin/Triple;", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1 extends Lambda<LiveData<RetroAchievementsGameRecordEntity>> implements Function1<Triple<Boolean, String, String>, LiveData<RetroAchievementsGameRecordEntity>> {
    final /* synthetic */ Ref.ObjectRef<String> $webApiKey;
    final /* synthetic */ PlayableItemDetailDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1(Ref.ObjectRef<String> objectRef, PlayableItemDetailDialogFragment playableItemDetailDialogFragment) {
        super(1);
        this.$webApiKey = objectRef;
        this.this$0 = playableItemDetailDialogFragment;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final LiveData<RetroAchievementsGameRecordEntity> invoke(Triple<Boolean, String, String> triple) {
        Boolean first = triple.getFirst();
        this.$webApiKey.element = triple.getSecond();
        String third = triple.getThird();
        PlayableItemEntity playableItemEntity = null;
        if (this.$webApiKey.element == null || third == null) {
            TextView textView = this.this$0.retroAchievementsTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsTextView");
                textView = null;
            }
            String str = this.this$0.retroAchievementsLoginRequiredWitEmojiString;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsLoginRequiredWitEmojiString");
                str = null;
            }
            textView.setText(str);
            return new MutableLiveData(null);
        }
        RetroAchievementsRepository retroAchievementsRepository = this.this$0.getRetroAchievementsManager().getRetroAchievementsRepository();
        TextView textView2 = this.this$0.retroAchievementsTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsTextView");
            textView2 = null;
        }
        String str2 = this.this$0.retroAchievementsRefreshingString;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsRefreshingString");
            str2 = null;
        }
        textView2.setText("🏆 " + str2);
        RetroAchievementsRepository retroAchievementsRepository2 = this.this$0.getRetroAchievementsManager().getRetroAchievementsRepository();
        PlayableItemEntity playableItemEntity2 = this.this$0.playableItemEntity;
        if (playableItemEntity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
        } else {
            playableItemEntity = playableItemEntity2;
        }
        return Transformations.switchMap(Transformations.switchMap(retroAchievementsRepository2.getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemId(playableItemEntity.getId()), new AnonymousClass1(first, this.this$0)), new AnonymousClass2(retroAchievementsRepository, this.$webApiKey, first, this.this$0));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u00032\r\u0010\u0004\u001a\t\u0018\u00010\u0005¢\u0006\u0002\b\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "", "Lkotlin/jvm/JvmSuppressWildcards;", "surjection", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda<LiveData<Long>> implements Function1<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity, LiveData<Long>> {
        final /* synthetic */ Boolean $enableRA;
        final /* synthetic */ PlayableItemDetailDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Boolean bool, PlayableItemDetailDialogFragment playableItemDetailDialogFragment) {
            super(1);
            this.$enableRA = bool;
            this.this$0 = playableItemDetailDialogFragment;
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$1$1", f = "PlayableItemDetailDialogFragment.kt", i = {0}, l = {1042, 1043}, m = "invokeSuspendImpl", n = {"$this$liveData"}, s = {"L$0"})
        static final class C00591 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<LiveDataScope<Long>, Continuation<?>, Object> {
            final /* synthetic */ Boolean $enableRA;
            final /* synthetic */ RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity $surjection;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ PlayableItemDetailDialogFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00591(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity, Boolean bool, PlayableItemDetailDialogFragment playableItemDetailDialogFragment, Continuation<?> continuation) {
                super(2, continuation);
                this.$surjection = retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
                this.$enableRA = bool;
                this.this$0 = playableItemDetailDialogFragment;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                C00591 c00591 = new C00591(this.$surjection, this.$enableRA, this.this$0, continuation);
                c00591.L$0 = obj;
                return c00591;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(LiveDataScope<Long> liveDataScope, Continuation<?> continuation) {
                try {
                    return ((C00591) create(liveDataScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x006d, code lost:
            
                if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getIO(), new com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1.AnonymousClass1.C00591.C00601(r7.this$0, r7.$surjection, r1, null), r7) == r0) goto L19;
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
                    if (r1 == 0) goto L22
                    if (r1 == r3) goto L1a
                    if (r1 != r2) goto L12
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L70
                L12:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L1a:
                    java.lang.Object r1 = r7.L$0
                    androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L44
                L22:
                    kotlin.ResultKt.throwOnFailure(r8)
                    java.lang.Object r8 = r7.L$0
                    r1 = r8
                    androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
                    com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity r8 = r7.$surjection
                    if (r8 == 0) goto L44
                    long r4 = r8.getGameId()
                    java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
                    r4 = r7
                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                    r7.L$0 = r1
                    r7.label = r3
                    java.lang.Object r8 = r1.emit(r8, r4)
                    if (r8 != r0) goto L44
                    goto L6f
                L44:
                    java.lang.Boolean r8 = r7.$enableRA
                    java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
                    boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r3)
                    if (r8 == 0) goto L70
                    kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()
                    kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
                    com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$1$1$1 r3 = new com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$1$1$1
                    com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment r4 = r7.this$0
                    com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity r5 = r7.$surjection
                    r6 = 0
                    r3.<init>(r4, r5, r1, r6)
                    kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                    r1 = r7
                    kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                    r7.L$0 = r6
                    r7.label = r2
                    java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r3, r1)
                    if (r8 != r0) goto L70
                L6f:
                    return r0
                L70:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1.AnonymousClass1.C00591.invokeSuspendImpl(java.lang.Object):java.lang.Object");
            }

            /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$1$1$1", f = "PlayableItemDetailDialogFragment.kt", i = {}, l = {1044, 1047}, m = "invokeSuspendImpl", n = {}, s = {})
            static final class C00601 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
                final /* synthetic */ LiveDataScope<Long> $$this$liveData;
                final /* synthetic */ RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity $surjection;
                int label;
                final /* synthetic */ PlayableItemDetailDialogFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00601(PlayableItemDetailDialogFragment playableItemDetailDialogFragment, RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity, LiveDataScope<Long> liveDataScope, Continuation<?> continuation) {
                    super(2, continuation);
                    this.this$0 = playableItemDetailDialogFragment;
                    this.$surjection = retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
                    this.$$this$liveData = liveDataScope;
                }


                public final Continuation create(Object obj, Continuation<?> continuation) {
                    return new C00601(this.this$0, this.$surjection, this.$$this$liveData, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                    try {
                        try {
                            return ((C00601) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                        } catch (Throwable th) {
                            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                        }
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
                
                    if (r6.$$this$liveData.emit(null, r6) == r0) goto L21;
                 */

                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspendImpl(java.lang.Object r7) throws java.lang.Throwable {
                    /*
                        r6 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r6.label
                        r2 = 0
                        r3 = 2
                        r4 = 1
                        if (r1 == 0) goto L1f
                        if (r1 == r4) goto L1b
                        if (r1 != r3) goto L13
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L5c
                    L13:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r0)
                        throw r7
                    L1b:
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L42
                    L1f:
                        kotlin.ResultKt.throwOnFailure(r7)
                        com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment r7 = r6.this$0
                        com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager r7 = com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment.access$getRetroAchievementsManager(r7)
                        com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment r1 = r6.this$0
                        com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity r1 = com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment.access$getPlayableItemEntity$p(r1)
                        if (r1 != 0) goto L36
                        java.lang.String r1 = "playableItemEntity"
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                        r1 = r2
                    L36:
                        r5 = r6
                        kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                        r6.label = r4
                        java.lang.Object r7 = r7.refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntityIfExpired(r1, r5)
                        if (r7 != r0) goto L42
                        goto L5b
                    L42:
                        java.lang.Boolean r7 = (java.lang.Boolean) r7
                        boolean r7 = r7.booleanValue()
                        com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity r1 = r6.$surjection
                        if (r1 != 0) goto L5c
                        if (r7 != 0) goto L5c
                        androidx.lifecycle.LiveDataScope<java.lang.Long> r7 = r6.$$this$liveData
                        r1 = r6
                        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                        r6.label = r3
                        java.lang.Object r7 = r7.emit(r2, r1)
                        if (r7 != r0) goto L5c
                    L5b:
                        return r0
                    L5c:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1.AnonymousClass1.C00591.C00601.invokeSuspendImpl(java.lang.Object):java.lang.Object");
                }
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final LiveData<Long> invoke(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity) {
            return CoroutineLiveDataKt.liveData$default(Dispatchers.getMain(), 0L, new C00591(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity, this.$enableRA, this.this$0, null), 2, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0017\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u00042\r\u0010\u0005\u001a\t\u0018\u00010\u0006¢\u0006\u0002\b\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "kotlin.jvm.PlatformType", "Lkotlin/jvm/JvmSuppressWildcards;", "gameId", "", "invoke", "(Ljava/lang/Long;)Landroidx/lifecycle/LiveData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda<LiveData<RetroAchievementsGameRecordEntity>> implements Function1<Long, LiveData<RetroAchievementsGameRecordEntity>> {
        final /* synthetic */ Boolean $enableRA;
        final /* synthetic */ RetroAchievementsRepository $retroAchievementsRepository;
        final /* synthetic */ Ref.ObjectRef<String> $webApiKey;
        final /* synthetic */ PlayableItemDetailDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(RetroAchievementsRepository retroAchievementsRepository, Ref.ObjectRef<String> objectRef, Boolean bool, PlayableItemDetailDialogFragment playableItemDetailDialogFragment) {
            super(1);
            this.$retroAchievementsRepository = retroAchievementsRepository;
            this.$webApiKey = objectRef;
            this.$enableRA = bool;
            this.this$0 = playableItemDetailDialogFragment;
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0017\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u00042\r\u0010\u0005\u001a\t\u0018\u00010\u0002¢\u0006\u0002\b\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "kotlin.jvm.PlatformType", "Lkotlin/jvm/JvmSuppressWildcards;", "gameRecord", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass1 extends Lambda<LiveData<RetroAchievementsGameRecordEntity>> implements Function1<RetroAchievementsGameRecordEntity, LiveData<RetroAchievementsGameRecordEntity>> {
            final /* synthetic */ Boolean $enableRA;
            final /* synthetic */ Long $gameId;
            final /* synthetic */ PlayableItemDetailDialogFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Boolean bool, Long l, PlayableItemDetailDialogFragment playableItemDetailDialogFragment) {
                super(1);
                this.$enableRA = bool;
                this.$gameId = l;
                this.this$0 = playableItemDetailDialogFragment;
            }

            /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$2$1$1", f = "PlayableItemDetailDialogFragment.kt", i = {}, l = {1056, 1057, 1063, 1065}, m = "invokeSuspendImpl", n = {}, s = {})
            static final class C00611 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<LiveDataScope<RetroAchievementsGameRecordEntity>, Continuation<?>, Object> {
                final /* synthetic */ Boolean $enableRA;
                final /* synthetic */ Long $gameId;
                final /* synthetic */ RetroAchievementsGameRecordEntity $gameRecord;
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ PlayableItemDetailDialogFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00611(Boolean bool, Long l, RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity, PlayableItemDetailDialogFragment playableItemDetailDialogFragment, Continuation<?> continuation) {
                    super(2, continuation);
                    this.$enableRA = bool;
                    this.$gameId = l;
                    this.$gameRecord = retroAchievementsGameRecordEntity;
                    this.this$0 = playableItemDetailDialogFragment;
                }


                public final Continuation create(Object obj, Continuation<?> continuation) {
                    C00611 c00611 = new C00611(this.$enableRA, this.$gameId, this.$gameRecord, this.this$0, continuation);
                    c00611.L$0 = obj;
                    return c00611;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(LiveDataScope<RetroAchievementsGameRecordEntity> liveDataScope, Continuation<?> continuation) {
                    try {
                        return ((C00611) create(liveDataScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
                }

                /* JADX WARN: Code duplicated, block: B:25:0x005d  */
                /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
                
                    if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getIO(), new com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1.AnonymousClass2.AnonymousClass1.C00611.C00621(r9.this$0, r9.$gameId, null), r9) == r0) goto L33;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:29:0x0083, code lost:
                
                    if (r10.emit(null, r9) == r0) goto L33;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:32:0x008f, code lost:
                
                    if (r10.emit(null, r9) == r0) goto L33;
                 */

                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspendImpl(java.lang.Object r10) throws java.lang.Throwable {
                    /*
                        r9 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r9.label
                        r2 = 4
                        r3 = 3
                        r4 = 2
                        r5 = 0
                        r6 = 1
                        if (r1 == 0) goto L27
                        if (r1 == r6) goto L23
                        if (r1 == r4) goto L1e
                        if (r1 == r3) goto L1e
                        if (r1 != r2) goto L16
                        goto L1e
                    L16:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r0)
                        throw r10
                    L1e:
                        kotlin.ResultKt.throwOnFailure(r10)
                        goto L92
                    L23:
                        kotlin.ResultKt.throwOnFailure(r10)
                        goto L5d
                    L27:
                        kotlin.ResultKt.throwOnFailure(r10)
                        java.lang.Object r10 = r9.L$0
                        androidx.lifecycle.LiveDataScope r10 = (androidx.lifecycle.LiveDataScope) r10
                        java.lang.Boolean r1 = r9.$enableRA
                        java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
                        boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r7)
                        if (r1 == 0) goto L86
                        java.lang.Long r1 = r9.$gameId
                        com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity$Companion r2 = com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.INSTANCE
                        long r7 = r2.getNULL_GAME_ID()
                        if (r1 != 0) goto L45
                        goto L4d
                    L45:
                        long r1 = r1.longValue()
                        int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
                        if (r1 == 0) goto L7a
                    L4d:
                        com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity r1 = r9.$gameRecord
                        if (r1 == 0) goto L5d
                        r2 = r9
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        r9.label = r6
                        java.lang.Object r10 = r10.emit(r1, r2)
                        if (r10 != r0) goto L5d
                        goto L91
                    L5d:
                        kotlinx.coroutines.CoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getIO()
                        kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
                        com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$2$1$1$1 r1 = new com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$2$1$1$1
                        com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment r2 = r9.this$0
                        java.lang.Long r3 = r9.$gameId
                        r1.<init>(r2, r3, r5)
                        kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                        r2 = r9
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        r9.label = r4
                        java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r1, r2)
                        if (r10 != r0) goto L92
                        goto L91
                    L7a:
                        r1 = r9
                        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                        r9.label = r3
                        java.lang.Object r10 = r10.emit(r5, r1)
                        if (r10 != r0) goto L92
                        goto L91
                    L86:
                        r1 = r9
                        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                        r9.label = r2
                        java.lang.Object r10 = r10.emit(r5, r1)
                        if (r10 != r0) goto L92
                    L91:
                        return r0
                    L92:
                        kotlin.Unit r10 = kotlin.Unit.INSTANCE
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1.AnonymousClass2.AnonymousClass1.C00611.invokeSuspendImpl(java.lang.Object):java.lang.Object");
                }

                /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$2$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: PlayableItemDetailDialogFragment.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$2$1$1$1", f = "PlayableItemDetailDialogFragment.kt", i = {}, l = {1058}, m = "invokeSuspendImpl", n = {}, s = {})
                static final class C00621 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
                    final /* synthetic */ Long $gameId;
                    int label;
                    final /* synthetic */ PlayableItemDetailDialogFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00621(PlayableItemDetailDialogFragment playableItemDetailDialogFragment, Long l, Continuation<?> continuation) {
                        super(2, continuation);
                        this.this$0 = playableItemDetailDialogFragment;
                        this.$gameId = l;
                    }


                    public final Continuation create(Object obj, Continuation<?> continuation) {
                        return new C00621(this.this$0, this.$gameId, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                        try {
                            try {
                                return ((C00621) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
                        if (i != 0) {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        Object objRefreshMyRetroAchievementsGameRecordByGameIdIfExpired = this.this$0.getRetroAchievementsManager().refreshMyRetroAchievementsGameRecordByGameIdIfExpired(this.$gameId.longValue(), this);
                        return objRefreshMyRetroAchievementsGameRecordByGameIdIfExpired == coroutine_suspended ? coroutine_suspended : objRefreshMyRetroAchievementsGameRecordByGameIdIfExpired;
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final LiveData<RetroAchievementsGameRecordEntity> invoke(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
                return CoroutineLiveDataKt.liveData$default(Dispatchers.getMain(), 0L, new C00611(this.$enableRA, this.$gameId, retroAchievementsGameRecordEntity, this.this$0, null), 2, (Object) null);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final LiveData<RetroAchievementsGameRecordEntity> invoke(Long l) {
            if (l == null) {
                return new MutableLiveData(null);
            }
            RetroAchievementsRepository retroAchievementsRepository = this.$retroAchievementsRepository;
            String str = this.$webApiKey.element;
            Intrinsics.checkNotNull(str);
            return Transformations.switchMap(retroAchievementsRepository.getRetroAchievementsGameRecordByUserIdAndGameId(str, l.longValue()), new AnonymousClass1(this.$enableRA, l, this.this$0));
        }
    }
}
