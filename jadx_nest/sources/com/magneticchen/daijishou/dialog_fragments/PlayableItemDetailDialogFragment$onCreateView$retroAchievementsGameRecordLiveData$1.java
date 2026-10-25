package com.magneticchen.daijishou.dialog_fragments;

import android.widget.TextView;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataScope;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.repositories.RetroAchievementsRepository;
import com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
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

            public final Object invokeSuspendImpl(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                LiveDataScope<Long> liveDataScope;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    liveDataScope = (LiveDataScope) this.L$0;
                    if (this.$surjection != null) {
                        this.L$0 = liveDataScope;
                        this.label = 1;
                        if (liveDataScope.emit(Boxing.boxLong(this.$surjection.getGameId()), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else if (i == 1) {
                    liveDataScope = (LiveDataScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (Intrinsics.areEqual(this.$enableRA, Boxing.boxBoolean(true))) {
                    CoroutineContext io = (CoroutineContext) Dispatchers.getIO();
                    C00601 c00601 = new C00601(this.this$0, this.$surjection, liveDataScope, null);
                    this.L$0 = null;
                    this.label = 2;
                    if (BuildersKt.withContext(io, c00601, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
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

                public final Object invokeSuspendImpl(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        RetroAchievementsManager retroAchievementsManager = this.this$0.getRetroAchievementsManager();
                        PlayableItemEntity playableItemEntity = this.this$0.playableItemEntity;
                        if (playableItemEntity == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("playableItemEntity");
                            playableItemEntity = null;
                        }
                        this.label = 1;
                        obj = retroAchievementsManager.refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntityIfExpired(playableItemEntity, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (this.$surjection == null && !booleanValue) {
                        this.label = 2;
                        if (this.$$this$liveData.emit(null, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
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

                public final Object invokeSuspendImpl(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    LiveDataScope<RetroAchievementsGameRecordEntity> liveDataScope;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        liveDataScope = (LiveDataScope) this.L$0;
                        if (Intrinsics.areEqual(this.$enableRA, Boxing.boxBoolean(true))) {
                            long nullGameId = RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.INSTANCE.getNULL_GAME_ID();
                            if (this.$gameId == null || this.$gameId.longValue() != nullGameId) {
                                if (this.$gameRecord != null) {
                                    this.label = 1;
                                    if (liveDataScope.emit(this.$gameRecord, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                CoroutineContext io = (CoroutineContext) Dispatchers.getIO();
                                C00621 c00621 = new C00621(this.this$0, this.$gameId, null);
                                this.label = 2;
                                if (BuildersKt.withContext(io, c00621, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                            this.label = 3;
                            if (liveDataScope.emit(null, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        this.label = 4;
                        if (liveDataScope.emit(null, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    } else if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineContext io2 = (CoroutineContext) Dispatchers.getIO();
                        C00621 c006212 = new C00621(this.this$0, this.$gameId, null);
                        this.label = 2;
                        if (BuildersKt.withContext(io2, c006212, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    } else if (i == 2 || i == 3 || i == 4) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
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
