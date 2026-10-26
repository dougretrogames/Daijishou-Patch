package com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.magneticchen.daijishou.repositories.RetroAchievementsRepository;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserProfileEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserRankingEntity;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: RetroAchievementsNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a-\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00040\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u00072\u000b\u0010\b\u001a\u00070\u0003¢\u0006\u0002\b\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Lkotlin/Triple;", "", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserRankingEntity;", "Lkotlin/jvm/JvmSuppressWildcards;", "viewMode", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1 extends Lambda<LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> implements Function1<Integer, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> {
    final /* synthetic */ LiveData<RetroAchievementsUserProfileEntity> $userProfileLiveData;
    final /* synthetic */ RetroAchievementsNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1(RetroAchievementsNavFragment retroAchievementsNavFragment, LiveData<RetroAchievementsUserProfileEntity> liveData) {
        super(1);
        this.this$0 = retroAchievementsNavFragment;
        this.$userProfileLiveData = liveData;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(Integer num) {
        return invoke(num.intValue());
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1$1, reason: invalid class name */
    /* INFO: compiled from: RetroAchievementsNavFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a-\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00040\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u00072\r\u0010\b\u001a\t\u0018\u00010\t¢\u0006\u0002\b\u0007H\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Lkotlin/Triple;", "", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserRankingEntity;", "Lkotlin/jvm/JvmSuppressWildcards;", "userId", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda<LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> implements Function1<String, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> {
        final /* synthetic */ LiveData<RetroAchievementsUserProfileEntity> $userProfileLiveData;
        final /* synthetic */ int $viewMode;
        final /* synthetic */ RetroAchievementsNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, LiveData<RetroAchievementsUserProfileEntity> liveData, RetroAchievementsNavFragment retroAchievementsNavFragment) {
            super(1);
            this.$viewMode = i;
            this.$userProfileLiveData = liveData;
            this.this$0 = retroAchievementsNavFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(String str) {
            if (str == null) {
                return new MutableLiveData(new Triple(Integer.valueOf(this.$viewMode), CollectionsKt.emptyList(), CollectionsKt.emptyList()));
            }
            int i = this.$viewMode;
            if (i <= 1) {
                if (i == 0) {
                    return Transformations.switchMap(this.$userProfileLiveData, new C00561(this.$viewMode, this.this$0, str));
                }
                if (i == 1) {
                    return Transformations.switchMap(this.$userProfileLiveData, new AnonymousClass2(this.$viewMode, this.this$0, str));
                }
            } else {
                if (i == 3) {
                    return Transformations.switchMap(this.this$0.getRetroAchievementsManager().getRetroAchievementsRepository().getRetroAchievementsUserRankingsByPerspectiveAndGranularity(str, 0), new AnonymousClass3(this.$viewMode));
                }
                if (i == 4) {
                    return Transformations.switchMap(this.this$0.getRetroAchievementsManager().getRetroAchievementsRepository().getRetroAchievementsUserRankingsByPerspectiveAndGranularity(str, 1), new AnonymousClass4(this.$viewMode));
                }
                if (i == 5) {
                    return Transformations.switchMap(this.this$0.getRetroAchievementsManager().getRetroAchievementsRepository().getRetroAchievementsUserRankingsByPerspectiveAndGranularity(str, 99), new AnonymousClass5(this.$viewMode));
                }
            }
            return new MutableLiveData(new Triple(Integer.valueOf(this.$viewMode), CollectionsKt.emptyList(), CollectionsKt.emptyList()));
        }

        /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1$1$1, reason: invalid class name and collision with other inner class name */
        /* INFO: compiled from: RetroAchievementsNavFragment.kt */
        @Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a-\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00040\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u00072\r\u0010\b\u001a\t\u0018\u00010\t¢\u0006\u0002\b\u0007H\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Lkotlin/Triple;", "", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserRankingEntity;", "Lkotlin/jvm/JvmSuppressWildcards;", "it", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class C00561 extends Lambda<LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> implements Function1<RetroAchievementsUserProfileEntity, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> {
            final /* synthetic */ String $userId;
            final /* synthetic */ int $viewMode;
            final /* synthetic */ RetroAchievementsNavFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00561(int i, RetroAchievementsNavFragment retroAchievementsNavFragment, String str) {
                super(1);
                this.$viewMode = i;
                this.this$0 = retroAchievementsNavFragment;
                this.$userId = str;
            }

            @Override // kotlin.jvm.functions.Function1
            public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
                if (retroAchievementsUserProfileEntity == null) {
                    return new MutableLiveData(new Triple(Integer.valueOf(this.$viewMode), CollectionsKt.emptyList(), CollectionsKt.emptyList()));
                }
                List<Long> recentPlayedGameIds = retroAchievementsUserProfileEntity.getRecentPlayedGameIds();
                RetroAchievementsRepository retroAchievementsRepository = this.this$0.getRetroAchievementsManager().getRetroAchievementsRepository();
                String str = this.$userId;
                long[] longArray = CollectionsKt.toLongArray(recentPlayedGameIds);
                return Transformations.switchMap(retroAchievementsRepository.getRetroAchievementsGameRecordsByUserIdAndGameIds(str, Arrays.copyOf(longArray, longArray.length)), new C00571(this.$viewMode, recentPlayedGameIds));
            }

            /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1$1$1$1, reason: invalid class name and collision with other inner class name */
            /* INFO: compiled from: RetroAchievementsNavFragment.kt */
            @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a-\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00040\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Lkotlin/Triple;", "", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserRankingEntity;", "Lkotlin/jvm/JvmSuppressWildcards;", "it", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
            static final class C00571 extends Lambda<LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> implements Function1<List<RetroAchievementsGameRecordEntity>, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> {
                final /* synthetic */ List<Long> $recentPlayedGameIds;
                final /* synthetic */ int $viewMode;

                /* WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00571(int i, List<Long> list) {
                    super(1);
                    this.$viewMode = i;
                    this.$recentPlayedGameIds = list;
                }

                @Override // kotlin.jvm.functions.Function1
                public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(List<RetroAchievementsGameRecordEntity> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new MutableLiveData(new Triple(Integer.valueOf(this.$viewMode), CollectionsKt.sortedWith(it, new RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1$1$1$1$invoke$$inlined$sortedBy$1(this.$recentPlayedGameIds)), CollectionsKt.emptyList()));
                }
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1$1$2, reason: invalid class name */
        /* INFO: compiled from: RetroAchievementsNavFragment.kt */
        @Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a-\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00040\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u00072\r\u0010\b\u001a\t\u0018\u00010\t¢\u0006\u0002\b\u0007H\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Lkotlin/Triple;", "", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserRankingEntity;", "Lkotlin/jvm/JvmSuppressWildcards;", "it", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass2 extends Lambda<LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> implements Function1<RetroAchievementsUserProfileEntity, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> {
            final /* synthetic */ String $userId;
            final /* synthetic */ int $viewMode;
            final /* synthetic */ RetroAchievementsNavFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(int i, RetroAchievementsNavFragment retroAchievementsNavFragment, String str) {
                super(1);
                this.$viewMode = i;
                this.this$0 = retroAchievementsNavFragment;
                this.$userId = str;
            }

            @Override // kotlin.jvm.functions.Function1
            public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
                if (retroAchievementsUserProfileEntity == null) {
                    return new MutableLiveData(new Triple(Integer.valueOf(this.$viewMode), CollectionsKt.emptyList(), CollectionsKt.emptyList()));
                }
                List<Long> completionProgressGameIds = retroAchievementsUserProfileEntity.getCompletionProgressGameIds();
                RetroAchievementsRepository retroAchievementsRepository = this.this$0.getRetroAchievementsManager().getRetroAchievementsRepository();
                String str = this.$userId;
                long[] longArray = CollectionsKt.toLongArray(completionProgressGameIds);
                return Transformations.switchMap(retroAchievementsRepository.getRetroAchievementsGameRecordsByUserIdAndGameIds(str, Arrays.copyOf(longArray, longArray.length)), new C00581(this.$viewMode, completionProgressGameIds));
            }

            /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1$1$2$1, reason: invalid class name and collision with other inner class name */
            /* INFO: compiled from: RetroAchievementsNavFragment.kt */
            @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a-\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00040\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Lkotlin/Triple;", "", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserRankingEntity;", "Lkotlin/jvm/JvmSuppressWildcards;", "it", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
            static final class C00581 extends Lambda<LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> implements Function1<List<RetroAchievementsGameRecordEntity>, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> {
                final /* synthetic */ List<Long> $completionProgressGameIds;
                final /* synthetic */ int $viewMode;

                /* WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00581(int i, List<Long> list) {
                    super(1);
                    this.$viewMode = i;
                    this.$completionProgressGameIds = list;
                }

                @Override // kotlin.jvm.functions.Function1
                public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(List<RetroAchievementsGameRecordEntity> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new MutableLiveData(new Triple(Integer.valueOf(this.$viewMode), CollectionsKt.sortedWith(it, new RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1$1$2$1$invoke$$inlined$sortedBy$1(this.$completionProgressGameIds)), CollectionsKt.emptyList()));
                }
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1$1$3, reason: invalid class name */
        /* INFO: compiled from: RetroAchievementsNavFragment.kt */
        @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a-\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00040\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Lkotlin/Triple;", "", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserRankingEntity;", "Lkotlin/jvm/JvmSuppressWildcards;", "it", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass3 extends Lambda<LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> implements Function1<List<RetroAchievementsUserRankingEntity>, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> {
            final /* synthetic */ int $viewMode;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(int i) {
                super(1);
                this.$viewMode = i;
            }

            @Override // kotlin.jvm.functions.Function1
            public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(List<RetroAchievementsUserRankingEntity> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new MutableLiveData(new Triple(Integer.valueOf(this.$viewMode), CollectionsKt.emptyList(), it));
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1$1$4, reason: invalid class name */
        /* INFO: compiled from: RetroAchievementsNavFragment.kt */
        @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a-\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00040\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Lkotlin/Triple;", "", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserRankingEntity;", "Lkotlin/jvm/JvmSuppressWildcards;", "it", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass4 extends Lambda<LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> implements Function1<List<RetroAchievementsUserRankingEntity>, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> {
            final /* synthetic */ int $viewMode;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(int i) {
                super(1);
                this.$viewMode = i;
            }

            @Override // kotlin.jvm.functions.Function1
            public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(List<RetroAchievementsUserRankingEntity> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new MutableLiveData(new Triple(Integer.valueOf(this.$viewMode), CollectionsKt.emptyList(), it));
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$viewModeAndDataLiveData$1$1$5, reason: invalid class name */
        /* INFO: compiled from: RetroAchievementsNavFragment.kt */
        @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a-\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00040\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Lkotlin/Triple;", "", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserRankingEntity;", "Lkotlin/jvm/JvmSuppressWildcards;", "it", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass5 extends Lambda<LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> implements Function1<List<RetroAchievementsUserRankingEntity>, LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>>> {
            final /* synthetic */ int $viewMode;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(int i) {
                super(1);
                this.$viewMode = i;
            }

            @Override // kotlin.jvm.functions.Function1
            public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(List<RetroAchievementsUserRankingEntity> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new MutableLiveData(new Triple(Integer.valueOf(this.$viewMode), CollectionsKt.emptyList(), it));
            }
        }
    }

    public final LiveData<Triple<Integer, List<RetroAchievementsGameRecordEntity>, List<RetroAchievementsUserRankingEntity>>> invoke(int i) {
        return Transformations.switchMap(this.this$0.getRetroAchievementsManager().getMyUsernameLiveData(), new AnonymousClass1(i, this.$userProfileLiveData, this.this$0));
    }
}
