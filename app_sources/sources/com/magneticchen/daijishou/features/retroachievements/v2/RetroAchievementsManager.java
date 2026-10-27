package com.magneticchen.daijishou.features.retroachievements.v2;

import android.content.SharedPreferences;
import androidx.lifecycle.MutableLiveData;
import com.haroldadmin.cnradapter.NetworkResponse;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.RetroAchievementsConsole;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsGameRecordEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserAwardEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserIndependentGameRecordEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserProfileEntity;
import com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository;
import com.magneticchen.daijishou.data.live.SharedPreferenceStringLiveData;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.retroachivements.api.RetroClient;
import org.retroachivements.api.RetroInterface;
import org.retroachivements.api.data.RetroCredentials;
import org.retroachivements.api.data.pojo.ErrorResponse;
import org.retroachivements.api.data.pojo.user.GetUserCompletionProgress;

/* JADX INFO: compiled from: RetroAchievementsManager.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010.\u001a\u0004\u0018\u00010\u00182\b\u0010/\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u00100J\u000e\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\tJ\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u0001042\u0006\u00105\u001a\u000206J\u001c\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020908042\u0006\u0010-\u001a\u00020\u0018H\u0002J\u001a\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0;04H\u0002J\n\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u001a\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?08042\u0006\u0010/\u001a\u00020\rJ\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020A042\u0006\u0010-\u001a\u00020\u00182\u0006\u0010B\u001a\u00020\rJ\n\u0010C\u001a\u0004\u0018\u00010DH\u0002J\u001e\u0010E\u001a\b\u0012\u0004\u0012\u00020F042\u0006\u0010G\u001a\u00020D2\u0006\u0010-\u001a\u00020\u0018H\u0002J.\u0010H\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020A0\bj\b\u0012\u0004\u0012\u00020A`\n042\u0006\u0010G\u001a\u00020D2\u0006\u0010-\u001a\u00020\u0018H\u0002J.\u0010I\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020A0\bj\b\u0012\u0004\u0012\u00020A`\n042\u0006\u0010G\u001a\u00020D2\u0006\u0010-\u001a\u00020\u0018H\u0002J\n\u0010J\u001a\u0004\u0018\u00010\u0018H\u0002J\u0006\u0010K\u001a\u00020LJ\u0016\u0010M\u001a\u00020L2\u0006\u0010-\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010NJ\u0014\u0010O\u001a\u00020L2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\r08J\u0012\u0010Q\u001a\u0004\u0018\u00010\u00182\u0006\u0010R\u001a\u00020\u0018H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00060\u0016R\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00180\bj\b\u0012\u0004\u0012\u00020\u0018`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\r0\bj\b\u0012\u0004\u0012\u00020\r`\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\bj\b\u0012\u0004\u0012\u00020\r`\n0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\r0\bj\b\u0012\u0004\u0012\u00020\r`\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\bj\b\u0012\u0004\u0012\u00020\r`\n0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/magneticchen/daijishou/features/retroachievements/v2/RetroAchievementsManager;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "consoleWatchlist", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "consoles", "Ljava/util/HashMap;", "", "Lcom/magneticchen/daijishou/data/RetroAchievementsConsole;", "Lkotlin/collections/HashMap;", "<set-?>", "", "created", "getCreated", "()Z", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "refreshingAwards", "", "refreshingConsoleIds", "refreshingConsoleIdsLiveData", "Landroidx/lifecycle/MutableLiveData;", "refreshingGameIds", "refreshingGameIdsLiveData", "retroAchievementsRepository", "Lcom/magneticchen/daijishou/data/db/repositories/RetroAchievementsRepository;", "getRetroAchievementsRepository", "()Lcom/magneticchen/daijishou/data/db/repositories/RetroAchievementsRepository;", "setRetroAchievementsRepository", "(Lcom/magneticchen/daijishou/data/db/repositories/RetroAchievementsRepository;)V", "retroAchievementsSharedPreferences", "Landroid/content/SharedPreferences;", "getRetroAchievementsSharedPreferences", "()Landroid/content/SharedPreferences;", "setRetroAchievementsSharedPreferences", "(Landroid/content/SharedPreferences;)V", "retroAchievementsUsernamePreferenceLiveData", "Lcom/magneticchen/daijishou/data/live/SharedPreferenceStringLiveData;", "retroAchievementsWebApiKeyPreferenceLiveData", com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager.USERNAME_PREFERENCE_STRING, "getConsoleImageUrl", "consoleId", "(Ljava/lang/Long;)Ljava/lang/String;", "getForumUrlString", "forumTopicId", "getPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity", "Lkotlinx/coroutines/flow/Flow;", "playableItemEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "getRetroAchievementsAwardsByUserId", "", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserAwardEntity;", "getRetroAchievementsConsoleIds", "", "getRetroAchievementsCredentials", "Lorg/retroachivements/api/data/RetroCredentials;", "getRetroAchievementsGameListByConsoleId", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserIndependentGameRecordEntity;", "getRetroAchievementsGameRecordByGameId", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;", "gameId", "getRetroAchievementsInterface", "Lorg/retroachivements/api/RetroInterface;", "getRetroAchievementsUserProfile", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserProfileEntity;", "retroInterface", "getRetroAchievementsUserProgressGames", "getRetroAchievementsUserRecentGames", "getUsername", "initialize", "", "refreshUserProfile", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setConsoleWatchlist", "consoleWatchList", "toGenericNameExtreme", "string", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsManager {
    private final DaijishouApplication application;
    private final HashSet<Integer> consoleWatchlist;
    private final HashMap<Long, RetroAchievementsConsole> consoles;
    private boolean created;
    private final DaijishouApplication.WrappedLogger logger;
    private final HashSet<String> refreshingAwards;
    private final HashSet<Long> refreshingConsoleIds;
    private final MutableLiveData<HashSet<Long>> refreshingConsoleIdsLiveData;
    private final HashSet<Long> refreshingGameIds;
    private final MutableLiveData<HashSet<Long>> refreshingGameIdsLiveData;
    public RetroAchievementsRepository retroAchievementsRepository;
    public SharedPreferences retroAchievementsSharedPreferences;
    private SharedPreferenceStringLiveData retroAchievementsUsernamePreferenceLiveData;
    private SharedPreferenceStringLiveData retroAchievementsWebApiKeyPreferenceLiveData;
    private String username;

    public RetroAchievementsManager(DaijishouApplication application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.logger = application.getLogger();
        this.consoles = new HashMap<>();
        this.refreshingConsoleIdsLiveData = new MutableLiveData<>();
        this.refreshingGameIdsLiveData = new MutableLiveData<>();
        this.refreshingConsoleIds = new HashSet<>();
        this.refreshingAwards = new HashSet<>();
        this.refreshingGameIds = new HashSet<>();
        this.consoleWatchlist = new HashSet<>();
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    public final RetroAchievementsRepository getRetroAchievementsRepository() {
        RetroAchievementsRepository retroAchievementsRepository = this.retroAchievementsRepository;
        if (retroAchievementsRepository != null) {
            return retroAchievementsRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsRepository");
        return null;
    }

    public final void setRetroAchievementsRepository(RetroAchievementsRepository retroAchievementsRepository) {
        Intrinsics.checkNotNullParameter(retroAchievementsRepository, "<set-?>");
        this.retroAchievementsRepository = retroAchievementsRepository;
    }

    public final SharedPreferences getRetroAchievementsSharedPreferences() {
        SharedPreferences sharedPreferences = this.retroAchievementsSharedPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsSharedPreferences");
        return null;
    }

    public final void setRetroAchievementsSharedPreferences(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<set-?>");
        this.retroAchievementsSharedPreferences = sharedPreferences;
    }

    public final boolean getCreated() {
        return this.created;
    }

    public final void initialize() {
        setRetroAchievementsRepository(this.application.getRetroAchievementsRepository());
        setRetroAchievementsSharedPreferences(this.application.getDefaultSharedPreferences());
        this.retroAchievementsUsernamePreferenceLiveData = new SharedPreferenceStringLiveData(getRetroAchievementsSharedPreferences(), com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager.USERNAME_PREFERENCE_STRING, null);
        this.retroAchievementsWebApiKeyPreferenceLiveData = new SharedPreferenceStringLiveData(getRetroAchievementsSharedPreferences(), com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager.WEB_API_KEY_PREFERENCE_STRING, null);
        this.created = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object refreshUserProfile(String str, Continuation<? super Unit> continuation) {
        Object objCollect;
        RetroInterface retroAchievementsInterface = getRetroAchievementsInterface();
        return (retroAchievementsInterface != null && (objCollect = FlowKt.retryWhen(getRetroAchievementsUserProfile(retroAchievementsInterface, str), new AnonymousClass2(null)).collect(new AnonymousClass3(retroAchievementsInterface, str), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objCollect : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$refreshUserProfile$2, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserProfileEntity;", "<anonymous parameter 0>", "", "attempt", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$refreshUserProfile$2", f = "RetroAchievementsManager.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function4<FlowCollector<? super RetroAchievementsUserProfileEntity>, Throwable, Long, Continuation<? super Boolean>, Object> {
        /* synthetic */ long J$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(4, continuation);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super RetroAchievementsUserProfileEntity> flowCollector, Throwable th, Long l, Continuation<? super Boolean> continuation) {
            return invoke(flowCollector, th, l.longValue(), continuation);
        }

        public final Object invoke(FlowCollector<? super RetroAchievementsUserProfileEntity> flowCollector, Throwable th, long j, Continuation<? super Boolean> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.J$0 = j;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.J$0 < 3) {
                    this.label = 1;
                    if (DelayKt.delay(3000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    return Boxing.boxBoolean(false);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Boxing.boxBoolean(true);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$refreshUserProfile$3, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "profile", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserProfileEntity;", "emit", "(Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserProfileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass3<T> implements FlowCollector {
        final /* synthetic */ RetroInterface $retroAchievements;
        final /* synthetic */ String $username;

        AnonymousClass3(RetroInterface retroInterface, String str) {
            this.$retroAchievements = retroInterface;
            this.$username = str;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00ca, code lost:
        
            if (r9.collect(r10, r0) == r1) goto L27;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(final com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserProfileEntity r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
            /*
                Method dump skipped, instruction units count: 208
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager.AnonymousClass3.emit(com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserProfileEntity, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((RetroAchievementsUserProfileEntity) obj, (Continuation<? super Unit>) continuation);
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$refreshUserProfile$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00050\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Ljava/util/HashSet;", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;", "Lkotlin/collections/HashSet;", "<anonymous parameter 0>", "", "attempts", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$refreshUserProfile$3$1", f = "RetroAchievementsManager.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function4<FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>>, Throwable, Long, Continuation<? super Boolean>, Object> {
            /* synthetic */ long J$0;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(4, continuation);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>> flowCollector, Throwable th, Long l, Continuation<? super Boolean> continuation) {
                return invoke(flowCollector, th, l.longValue(), continuation);
            }

            public final Object invoke(FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>> flowCollector, Throwable th, long j, Continuation<? super Boolean> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.J$0 = j;
                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.J$0 < 3) {
                        this.label = 1;
                        if (DelayKt.delay(3000L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        return Boxing.boxBoolean(false);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxBoolean(true);
            }
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$refreshUserProfile$3$3, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00050\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Ljava/util/HashSet;", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;", "Lkotlin/collections/HashSet;", "<anonymous parameter 0>", "", "attempts", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$refreshUserProfile$3$3", f = "RetroAchievementsManager.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
        static final class C00043 extends SuspendLambda implements Function4<FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>>, Throwable, Long, Continuation<? super Boolean>, Object> {
            /* synthetic */ long J$0;
            int label;

            C00043(Continuation<? super C00043> continuation) {
                super(4, continuation);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>> flowCollector, Throwable th, Long l, Continuation<? super Boolean> continuation) {
                return invoke(flowCollector, th, l.longValue(), continuation);
            }

            public final Object invoke(FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>> flowCollector, Throwable th, long j, Continuation<? super Boolean> continuation) {
                C00043 c00043 = new C00043(continuation);
                c00043.J$0 = j;
                return c00043.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.J$0 < 3) {
                        this.label = 1;
                        if (DelayKt.delay(3000L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        return Boxing.boxBoolean(false);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxBoolean(true);
            }
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$refreshUserProfile$3$5, reason: invalid class name */
        /* JADX INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserAwardEntity;", "<anonymous parameter 0>", "", "attempts", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$refreshUserProfile$3$5", f = "RetroAchievementsManager.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass5 extends SuspendLambda implements Function4<FlowCollector<? super List<? extends RetroAchievementsUserAwardEntity>>, Throwable, Long, Continuation<? super Boolean>, Object> {
            /* synthetic */ long J$0;
            int label;

            AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
                super(4, continuation);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends RetroAchievementsUserAwardEntity>> flowCollector, Throwable th, Long l, Continuation<? super Boolean> continuation) {
                return invoke((FlowCollector<? super List<RetroAchievementsUserAwardEntity>>) flowCollector, th, l.longValue(), continuation);
            }

            public final Object invoke(FlowCollector<? super List<RetroAchievementsUserAwardEntity>> flowCollector, Throwable th, long j, Continuation<? super Boolean> continuation) {
                AnonymousClass5 anonymousClass5 = new AnonymousClass5(continuation);
                anonymousClass5.J$0 = j;
                return anonymousClass5.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.J$0 < 3) {
                        this.label = 1;
                        if (DelayKt.delay(3000L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        return Boxing.boxBoolean(false);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxBoolean(true);
            }
        }
    }

    public final String getForumUrlString(int i) {
        return "https://retroachievements.org/viewtopic.php?t=" + i;
    }

    public final String getConsoleImageUrl(Long l) {
        if (l != null) {
            RetroAchievementsConsole retroAchievementsConsole = this.consoles.get(Long.valueOf(l.longValue()));
            if (retroAchievementsConsole != null) {
                return retroAchievementsConsole.getIconUrl();
            }
        }
        return null;
    }

    public final void setConsoleWatchlist(List<Long> consoleWatchList) {
        Intrinsics.checkNotNullParameter(consoleWatchList, "consoleWatchList");
        this.consoleWatchlist.clear();
        HashSet<Integer> hashSet = this.consoleWatchlist;
        hashSet.addAll(hashSet);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), (CoroutineStart) null, new C00831(consoleWatchList, this, null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$setConsoleWatchlist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$setConsoleWatchlist$1", f = "RetroAchievementsManager.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
    static final class C00831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Long> $consoleWatchList;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ RetroAchievementsManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00831(List<Long> list, RetroAchievementsManager retroAchievementsManager, Continuation<? super C00831> continuation) {
            super(2, continuation);
            this.$consoleWatchList = list;
            this.this$0 = retroAchievementsManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00831(this.$consoleWatchList, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            RetroAchievementsManager retroAchievementsManager;
            Iterator it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<Long> list = this.$consoleWatchList;
                retroAchievementsManager = this.this$0;
                it = list.iterator();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$1;
                retroAchievementsManager = (RetroAchievementsManager) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                Flow flowRetry$default = FlowKt.retry$default(retroAchievementsManager.getRetroAchievementsGameListByConsoleId(((Number) it.next()).longValue()), 3L, (Function2) null, 2, (Object) null);
                this.L$0 = retroAchievementsManager;
                this.L$1 = it;
                this.label = 1;
                if (FlowKt.collect(flowRetry$default, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity$1, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity$1", f = "RetroAchievementsManager.kt", i = {3, 3}, l = {172, 179, 189, 196, 263}, m = "invokeSuspend", n = {"$this$flow", "retroAchievementsConsoleIdList"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Object>, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlayableItemEntity $playableItemEntity;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PlayableItemEntity playableItemEntity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$playableItemEntity = playableItemEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = RetroAchievementsManager.this.new AnonymousClass1(this.$playableItemEntity, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Object> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<Object>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<Object> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:104:0x02f1  */
        /* JADX WARN: Code duplicated, block: B:107:0x02ed A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:109:? A[LOOP:0: B:47:0x00f6->B:109:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:111:0x016b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:112:0x015a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:113:0x0175 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:115:0x0140 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:122:0x020b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:37:0x00ac  */
        /* JADX WARN: Code duplicated, block: B:39:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:41:0x00d3  */
        /* JADX WARN: Code duplicated, block: B:46:0x00e7  */
        /* JADX WARN: Code duplicated, block: B:49:0x00fc  */
        /* JADX WARN: Code duplicated, block: B:55:0x0146  */
        /* JADX WARN: Code duplicated, block: B:64:0x01a0  */
        /* JADX WARN: Code duplicated, block: B:66:0x01a8  */
        /* JADX WARN: Code duplicated, block: B:70:0x01c7  */
        /* JADX WARN: Code duplicated, block: B:73:0x01f9  */
        /* JADX WARN: Code duplicated, block: B:75:0x0205  */
        /* JADX WARN: Code duplicated, block: B:80:0x023b  */
        /* JADX WARN: Code duplicated, block: B:82:0x024f  */
        /* JADX WARN: Code duplicated, block: B:84:0x025f  */
        /* JADX WARN: Code duplicated, block: B:85:0x0263  */
        /* JADX WARN: Code duplicated, block: B:89:0x0281  */
        /* JADX WARN: Code duplicated, block: B:91:0x0287  */
        /* JADX WARN: Code duplicated, block: B:97:0x02b0  */
        /* JADX WARN: Code duplicated, block: B:98:0x02b5  */
        /* JADX WARN: Code restructure failed: missing block: B:100:0x02eb, code lost:
        
            if (r11.emit(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true), r39) == r1) goto L101;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0072, code lost:
        
            if (r2.emit(r10, r39) == r1) goto L101;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a5, code lost:
        
            if (r2.emit(r10, r39) == r1) goto L101;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00e0, code lost:
        
            if (r2.emit(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false), r39) == r1) goto L101;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v30, types: [T, java.lang.Long] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r40) {
            /*
                Method dump skipped, instruction units count: 786
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Flow<Object> getPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity(PlayableItemEntity playableItemEntity) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        return FlowKt.flow(new AnonymousClass1(playableItemEntity, null));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsGameListByConsoleId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserIndependentGameRecordEntity;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsGameListByConsoleId$1", f = "RetroAchievementsManager.kt", i = {1, 1, 2}, l = {279, 290, 294, 322, 340, 340}, m = "invokeSuspend", n = {"$this$flow", "retroInterface", "$this$flow"}, s = {"L$0", "L$1", "L$0"})
    static final class C00781 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends RetroAchievementsUserIndependentGameRecordEntity>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $consoleId;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00781(long j, Continuation<? super C00781> continuation) {
            super(2, continuation);
            this.$consoleId = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00781 c00781 = RetroAchievementsManager.this.new C00781(this.$consoleId, continuation);
            c00781.L$0 = obj;
            return c00781;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends RetroAchievementsUserIndependentGameRecordEntity>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super List<RetroAchievementsUserIndependentGameRecordEntity>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super List<RetroAchievementsUserIndependentGameRecordEntity>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C00781) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:44:0x00f6  */
        /* JADX WARN: Code duplicated, block: B:45:0x00f8 A[Catch: all -> 0x002c, PHI: r3 r5
  0x00f8: PHI (r3v10 kotlinx.coroutines.flow.FlowCollector) = (r3v6 kotlinx.coroutines.flow.FlowCollector), (r3v21 kotlinx.coroutines.flow.FlowCollector) binds: [B:43:0x00f4, B:15:0x0036] A[DONT_GENERATE, DONT_INLINE]
  0x00f8: PHI (r5v13 java.lang.Object) = (r5v10 java.lang.Object), (r5v26 java.lang.Object) binds: [B:43:0x00f4, B:15:0x0036] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x002c, blocks: (B:9:0x0027, B:58:0x01ee, B:14:0x0033, B:45:0x00f8, B:47:0x00fe, B:48:0x011e, B:50:0x0124, B:52:0x0164, B:54:0x016a, B:55:0x01b5, B:63:0x0211, B:65:0x022a, B:66:0x0233, B:67:0x0234, B:68:0x0252, B:17:0x0042, B:42:0x00dc, B:38:0x00ba), top: B:75:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:47:0x00fe A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:9:0x0027, B:58:0x01ee, B:14:0x0033, B:45:0x00f8, B:47:0x00fe, B:48:0x011e, B:50:0x0124, B:52:0x0164, B:54:0x016a, B:55:0x01b5, B:63:0x0211, B:65:0x022a, B:66:0x0233, B:67:0x0234, B:68:0x0252, B:17:0x0042, B:42:0x00dc, B:38:0x00ba), top: B:75:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:50:0x0124 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:9:0x0027, B:58:0x01ee, B:14:0x0033, B:45:0x00f8, B:47:0x00fe, B:48:0x011e, B:50:0x0124, B:52:0x0164, B:54:0x016a, B:55:0x01b5, B:63:0x0211, B:65:0x022a, B:66:0x0233, B:67:0x0234, B:68:0x0252, B:17:0x0042, B:42:0x00dc, B:38:0x00ba), top: B:75:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:52:0x0164 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:9:0x0027, B:58:0x01ee, B:14:0x0033, B:45:0x00f8, B:47:0x00fe, B:48:0x011e, B:50:0x0124, B:52:0x0164, B:54:0x016a, B:55:0x01b5, B:63:0x0211, B:65:0x022a, B:66:0x0233, B:67:0x0234, B:68:0x0252, B:17:0x0042, B:42:0x00dc, B:38:0x00ba), top: B:75:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:53:0x0169  */
        /* JADX WARN: Code duplicated, block: B:57:0x01ec  */
        /* JADX WARN: Code duplicated, block: B:58:0x01ee A[Catch: all -> 0x002c, TRY_LEAVE, TryCatch #0 {all -> 0x002c, blocks: (B:9:0x0027, B:58:0x01ee, B:14:0x0033, B:45:0x00f8, B:47:0x00fe, B:48:0x011e, B:50:0x0124, B:52:0x0164, B:54:0x016a, B:55:0x01b5, B:63:0x0211, B:65:0x022a, B:66:0x0233, B:67:0x0234, B:68:0x0252, B:17:0x0042, B:42:0x00dc, B:38:0x00ba), top: B:75:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:62:0x0210 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:63:0x0211 A[Catch: all -> 0x002c, TRY_ENTER, TryCatch #0 {all -> 0x002c, blocks: (B:9:0x0027, B:58:0x01ee, B:14:0x0033, B:45:0x00f8, B:47:0x00fe, B:48:0x011e, B:50:0x0124, B:52:0x0164, B:54:0x016a, B:55:0x01b5, B:63:0x0211, B:65:0x022a, B:66:0x0233, B:67:0x0234, B:68:0x0252, B:17:0x0042, B:42:0x00dc, B:38:0x00ba), top: B:75:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:65:0x022a A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:9:0x0027, B:58:0x01ee, B:14:0x0033, B:45:0x00f8, B:47:0x00fe, B:48:0x011e, B:50:0x0124, B:52:0x0164, B:54:0x016a, B:55:0x01b5, B:63:0x0211, B:65:0x022a, B:66:0x0233, B:67:0x0234, B:68:0x0252, B:17:0x0042, B:42:0x00dc, B:38:0x00ba), top: B:75:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:67:0x0234 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:9:0x0027, B:58:0x01ee, B:14:0x0033, B:45:0x00f8, B:47:0x00fe, B:48:0x011e, B:50:0x0124, B:52:0x0164, B:54:0x016a, B:55:0x01b5, B:63:0x0211, B:65:0x022a, B:66:0x0233, B:67:0x0234, B:68:0x0252, B:17:0x0042, B:42:0x00dc, B:38:0x00ba), top: B:75:0x000b }] */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0099, code lost:
        
            if (r3.emit(r5, r24) == r2) goto L71;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.lang.Exception {
            /*
                Method dump skipped, instruction units count: 656
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager.C00781.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsGameListByConsoleId$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsGameListByConsoleId$1$1", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ RetroAchievementsManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00021(RetroAchievementsManager retroAchievementsManager, Continuation<? super C00021> continuation) {
                super(2, continuation);
                this.this$0 = retroAchievementsManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00021(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.refreshingConsoleIdsLiveData.setValue(this.this$0.refreshingConsoleIds);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsGameListByConsoleId$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsGameListByConsoleId$1$2", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ long $consoleId;
            int label;
            final /* synthetic */ RetroAchievementsManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(RetroAchievementsManager retroAchievementsManager, long j, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = retroAchievementsManager;
                this.$consoleId = j;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$consoleId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableLiveData mutableLiveData = this.this$0.refreshingConsoleIdsLiveData;
                    HashSet hashSet = this.this$0.refreshingConsoleIds;
                    hashSet.remove(Boxing.boxLong(this.$consoleId));
                    mutableLiveData.setValue(hashSet);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Flow<List<RetroAchievementsUserIndependentGameRecordEntity>> getRetroAchievementsGameListByConsoleId(long j) {
        return FlowKt.flow(new C00781(j, null));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1", f = "RetroAchievementsManager.kt", i = {1, 1, 2}, l = {359, 372, 377, 457, 475, 475}, m = "invokeSuspend", n = {"$this$flow", "retroInterface", "$this$flow"}, s = {"L$0", "L$1", "L$0"})
    static final class C00791 extends SuspendLambda implements Function2<FlowCollector<? super RetroAchievementsGameRecordEntity>, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $gameId;
        final /* synthetic */ String $username;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00791(String str, long j, Continuation<? super C00791> continuation) {
            super(2, continuation);
            this.$username = str;
            this.$gameId = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00791 c00791 = RetroAchievementsManager.this.new C00791(this.$username, this.$gameId, continuation);
            c00791.L$0 = obj;
            return c00791;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super RetroAchievementsGameRecordEntity> flowCollector, Continuation<? super Unit> continuation) {
            return ((C00791) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:101:0x03fb A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:106:0x0223 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:110:0x0329 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:41:0x00e5  */
        /* JADX WARN: Code duplicated, block: B:42:0x00e7 A[Catch: all -> 0x0031, PHI: r5 r8
  0x00e7: PHI (r5v10 kotlinx.coroutines.flow.FlowCollector) = (r5v6 kotlinx.coroutines.flow.FlowCollector), (r5v14 kotlinx.coroutines.flow.FlowCollector) binds: [B:40:0x00e3, B:15:0x003b] A[DONT_GENERATE, DONT_INLINE]
  0x00e7: PHI (r8v10 java.lang.Object) = (r8v7 java.lang.Object), (r8v19 java.lang.Object) binds: [B:40:0x00e3, B:15:0x003b] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* JADX WARN: Code duplicated, block: B:44:0x00ed A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* JADX WARN: Code duplicated, block: B:46:0x0105 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* JADX WARN: Code duplicated, block: B:49:0x0167 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* JADX WARN: Code duplicated, block: B:50:0x016c  */
        /* JADX WARN: Code duplicated, block: B:53:0x01e3 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* JADX WARN: Code duplicated, block: B:54:0x01ec A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* JADX WARN: Code duplicated, block: B:60:0x02e4 A[Catch: all -> 0x0397, TryCatch #1 {all -> 0x0397, blocks: (B:58:0x0223, B:60:0x02e4, B:62:0x02ea, B:64:0x02f0, B:66:0x02fb, B:68:0x0301, B:70:0x0307, B:72:0x030d, B:74:0x031b, B:76:0x0321, B:77:0x0329, B:73:0x0317, B:65:0x02f7, B:78:0x0334, B:80:0x033f, B:81:0x0358), top: B:106:0x0223 }] */
        /* JADX WARN: Code duplicated, block: B:62:0x02ea A[Catch: all -> 0x0397, TryCatch #1 {all -> 0x0397, blocks: (B:58:0x0223, B:60:0x02e4, B:62:0x02ea, B:64:0x02f0, B:66:0x02fb, B:68:0x0301, B:70:0x0307, B:72:0x030d, B:74:0x031b, B:76:0x0321, B:77:0x0329, B:73:0x0317, B:65:0x02f7, B:78:0x0334, B:80:0x033f, B:81:0x0358), top: B:106:0x0223 }] */
        /* JADX WARN: Code duplicated, block: B:63:0x02ef  */
        /* JADX WARN: Code duplicated, block: B:65:0x02f7 A[Catch: all -> 0x0397, TryCatch #1 {all -> 0x0397, blocks: (B:58:0x0223, B:60:0x02e4, B:62:0x02ea, B:64:0x02f0, B:66:0x02fb, B:68:0x0301, B:70:0x0307, B:72:0x030d, B:74:0x031b, B:76:0x0321, B:77:0x0329, B:73:0x0317, B:65:0x02f7, B:78:0x0334, B:80:0x033f, B:81:0x0358), top: B:106:0x0223 }] */
        /* JADX WARN: Code duplicated, block: B:68:0x0301 A[Catch: all -> 0x0397, TryCatch #1 {all -> 0x0397, blocks: (B:58:0x0223, B:60:0x02e4, B:62:0x02ea, B:64:0x02f0, B:66:0x02fb, B:68:0x0301, B:70:0x0307, B:72:0x030d, B:74:0x031b, B:76:0x0321, B:77:0x0329, B:73:0x0317, B:65:0x02f7, B:78:0x0334, B:80:0x033f, B:81:0x0358), top: B:106:0x0223 }] */
        /* JADX WARN: Code duplicated, block: B:70:0x0307 A[Catch: all -> 0x0397, TryCatch #1 {all -> 0x0397, blocks: (B:58:0x0223, B:60:0x02e4, B:62:0x02ea, B:64:0x02f0, B:66:0x02fb, B:68:0x0301, B:70:0x0307, B:72:0x030d, B:74:0x031b, B:76:0x0321, B:77:0x0329, B:73:0x0317, B:65:0x02f7, B:78:0x0334, B:80:0x033f, B:81:0x0358), top: B:106:0x0223 }] */
        /* JADX WARN: Code duplicated, block: B:71:0x030c  */
        /* JADX WARN: Code duplicated, block: B:73:0x0317 A[Catch: all -> 0x0397, TryCatch #1 {all -> 0x0397, blocks: (B:58:0x0223, B:60:0x02e4, B:62:0x02ea, B:64:0x02f0, B:66:0x02fb, B:68:0x0301, B:70:0x0307, B:72:0x030d, B:74:0x031b, B:76:0x0321, B:77:0x0329, B:73:0x0317, B:65:0x02f7, B:78:0x0334, B:80:0x033f, B:81:0x0358), top: B:106:0x0223 }] */
        /* JADX WARN: Code duplicated, block: B:76:0x0321 A[Catch: all -> 0x0397, TryCatch #1 {all -> 0x0397, blocks: (B:58:0x0223, B:60:0x02e4, B:62:0x02ea, B:64:0x02f0, B:66:0x02fb, B:68:0x0301, B:70:0x0307, B:72:0x030d, B:74:0x031b, B:76:0x0321, B:77:0x0329, B:73:0x0317, B:65:0x02f7, B:78:0x0334, B:80:0x033f, B:81:0x0358), top: B:106:0x0223 }] */
        /* JADX WARN: Code duplicated, block: B:80:0x033f A[Catch: all -> 0x0397, TryCatch #1 {all -> 0x0397, blocks: (B:58:0x0223, B:60:0x02e4, B:62:0x02ea, B:64:0x02f0, B:66:0x02fb, B:68:0x0301, B:70:0x0307, B:72:0x030d, B:74:0x031b, B:76:0x0321, B:77:0x0329, B:73:0x0317, B:65:0x02f7, B:78:0x0334, B:80:0x033f, B:81:0x0358), top: B:106:0x0223 }] */
        /* JADX WARN: Code duplicated, block: B:85:0x0371  */
        /* JADX WARN: Code duplicated, block: B:86:0x0373 A[Catch: all -> 0x0031, PHI: r1
  0x0373: PHI (r1v11 com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1) = 
  (r1v2 com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1)
  (r1v0 com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1)
 binds: [B:84:0x036f, B:9:0x002c] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* JADX WARN: Code duplicated, block: B:90:0x0396 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:93:0x039b A[Catch: all -> 0x0031, TRY_ENTER, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* JADX WARN: Code duplicated, block: B:95:0x03b4 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* JADX WARN: Code duplicated, block: B:97:0x03be A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0089, code lost:
        
            if (r5.emit(r8, r1) == r4) goto L101;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r39) throws java.lang.Exception {
            /*
                Method dump skipped, instruction units count: 1048
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager.C00791.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1$1", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ RetroAchievementsManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00031(RetroAchievementsManager retroAchievementsManager, Continuation<? super C00031> continuation) {
                super(2, continuation);
                this.this$0 = retroAchievementsManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00031(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.refreshingGameIdsLiveData.setValue(this.this$0.refreshingGameIds);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1$3", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ long $gameId;
            int label;
            final /* synthetic */ RetroAchievementsManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(RetroAchievementsManager retroAchievementsManager, long j, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = retroAchievementsManager;
                this.$gameId = j;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, this.$gameId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableLiveData mutableLiveData = this.this$0.refreshingGameIdsLiveData;
                    HashSet hashSet = this.this$0.refreshingGameIds;
                    hashSet.remove(Boxing.boxLong(this.$gameId));
                    mutableLiveData.setValue(hashSet);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Flow<RetroAchievementsGameRecordEntity> getRetroAchievementsGameRecordByGameId(String username, long j) {
        Intrinsics.checkNotNullParameter(username, "username");
        return FlowKt.flow(new C00791(username, j, null));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsUserProgressGames$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00050\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Ljava/util/HashSet;", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;", "Lkotlin/collections/HashSet;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsUserProgressGames$1", f = "RetroAchievementsManager.kt", i = {0}, l = {492}, m = "invokeSuspend", n = {"gameRecordsToBeUpdated"}, s = {"L$0"})
    static final class C00811 extends SuspendLambda implements Function2<FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ RetroInterface $retroInterface;
        final /* synthetic */ String $username;
        Object L$0;
        int label;
        final /* synthetic */ RetroAchievementsManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00811(RetroInterface retroInterface, String str, RetroAchievementsManager retroAchievementsManager, Continuation<? super C00811> continuation) {
            super(2, continuation);
            this.$retroInterface = retroInterface;
            this.$username = str;
            this.this$0 = retroAchievementsManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00811(this.$retroInterface, this.$username, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C00811) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            Object userCompletionProgress$default;
            HashSet hashSet;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashSet hashSet2 = new HashSet();
                this.L$0 = hashSet2;
                this.label = 1;
                userCompletionProgress$default = RetroInterface.DefaultImpls.getUserCompletionProgress$default(this.$retroInterface, this.$username, 128, 0, this, 4, (Object) null);
                if (userCompletionProgress$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                hashSet = hashSet2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                hashSet = (HashSet) this.L$0;
                ResultKt.throwOnFailure(obj);
                userCompletionProgress$default = obj;
            }
            NetworkResponse networkResponse = (NetworkResponse) userCompletionProgress$default;
            if (networkResponse instanceof NetworkResponse.Success) {
                List<GetUserCompletionProgress.Progress> listSortedWith = CollectionsKt.sortedWith(((GetUserCompletionProgress.Response) ((NetworkResponse.Success) networkResponse).getBody()).getResults(), new Comparator() { // from class: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsUserProgressGames$1$invokeSuspend$$inlined$sortedByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        GetUserCompletionProgress.Progress progress = (GetUserCompletionProgress.Progress) t2;
                        GetUserCompletionProgress.Progress progress2 = (GetUserCompletionProgress.Progress) t;
                        return ComparisonsKt.compareValues(Double.valueOf(progress.getNumAwarded() / progress.getMaxPossible()), Double.valueOf(progress2.getNumAwarded() / progress2.getMaxPossible()));
                    }
                });
                RetroAchievementsManager retroAchievementsManager = this.this$0;
                String str = this.$username;
                for (GetUserCompletionProgress.Progress progress : listSortedWith) {
                    RetroAchievementsGameRecordEntity retroAchievementsGameRecordByUserIdAndGameIdStatically = retroAchievementsManager.getRetroAchievementsRepository().getRetroAchievementsGameRecordByUserIdAndGameIdStatically(str, progress.getGameId());
                    if (retroAchievementsGameRecordByUserIdAndGameIdStatically == null) {
                        retroAchievementsGameRecordByUserIdAndGameIdStatically = new RetroAchievementsGameRecordEntity(0L, str, progress.getGameId(), null, null, null, null, null, null, null, null, 0, 0, 0L, 0L, 0L, null, null, 0, 0, null, 2097145, null);
                    }
                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setName(progress.getTitle());
                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setConsoleId(Boxing.boxLong(progress.getConsoleId()));
                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setConsoleName(progress.getConsoleName());
                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setImageUrl(RetroAchievementsConfiguration.BASE_URL + progress.getImageIcon());
                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setAchievementsCount((int) progress.getMaxPossible());
                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setUnlockedAchievementsCount((int) progress.getNumAwarded());
                    hashSet.add(retroAchievementsGameRecordByUserIdAndGameIdStatically);
                }
            }
            if (networkResponse instanceof NetworkResponse.Error) {
                NetworkResponse.Error error = (NetworkResponse.Error) networkResponse;
                ErrorResponse errorResponse = (ErrorResponse) error.getBody();
                Throwable error2 = error.getError();
                if (errorResponse != null) {
                    throw new IOException(errorResponse.getMessage());
                }
                throw new IOException("There was an internal error fetching the user's game completion progress for `" + this.$username + "`", error2);
            }
            RetroAchievementsRepository retroAchievementsRepository = this.this$0.getRetroAchievementsRepository();
            RetroAchievementsGameRecordEntity[] retroAchievementsGameRecordEntityArr = (RetroAchievementsGameRecordEntity[]) hashSet.toArray(new RetroAchievementsGameRecordEntity[0]);
            retroAchievementsRepository.addRetroAchievementsGameRecords((RetroAchievementsGameRecordEntity[]) Arrays.copyOf(retroAchievementsGameRecordEntityArr, retroAchievementsGameRecordEntityArr.length));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<HashSet<RetroAchievementsGameRecordEntity>> getRetroAchievementsUserProgressGames(RetroInterface retroInterface, String str) {
        return FlowKt.flow(new C00811(retroInterface, str, this, null));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsUserRecentGames$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00050\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Ljava/util/HashSet;", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;", "Lkotlin/collections/HashSet;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsUserRecentGames$1", f = "RetroAchievementsManager.kt", i = {0, 0}, l = {555, 595}, m = "invokeSuspend", n = {"$this$flow", "gameRecordsToBeUpdated"}, s = {"L$0", "L$1"})
    static final class C00821 extends SuspendLambda implements Function2<FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ RetroInterface $retroInterface;
        final /* synthetic */ String $username;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ RetroAchievementsManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00821(RetroInterface retroInterface, String str, RetroAchievementsManager retroAchievementsManager, Continuation<? super C00821> continuation) {
            super(2, continuation);
            this.$retroInterface = retroInterface;
            this.$username = str;
            this.this$0 = retroAchievementsManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00821 c00821 = new C00821(this.$retroInterface, this.$username, this.this$0, continuation);
            c00821.L$0 = obj;
            return c00821;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C00821) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x014a, code lost:
        
            if (r5.emit(r2, r39) == r1) goto L33;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r40) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 336
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager.C00821.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<HashSet<RetroAchievementsGameRecordEntity>> getRetroAchievementsUserRecentGames(RetroInterface retroInterface, String str) {
        return FlowKt.flow(new C00821(retroInterface, str, this, null));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsUserProfile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserProfileEntity;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsUserProfile$1", f = "RetroAchievementsManager.kt", i = {1}, l = {609, 615, 656}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
    static final class C00801 extends SuspendLambda implements Function2<FlowCollector<? super RetroAchievementsUserProfileEntity>, Continuation<? super Unit>, Object> {
        final /* synthetic */ RetroInterface $retroInterface;
        final /* synthetic */ String $username;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00801(String str, RetroInterface retroInterface, Continuation<? super C00801> continuation) {
            super(2, continuation);
            this.$username = str;
            this.$retroInterface = retroInterface;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00801 c00801 = RetroAchievementsManager.this.new C00801(this.$username, this.$retroInterface, continuation);
            c00801.L$0 = obj;
            return c00801;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super RetroAchievementsUserProfileEntity> flowCollector, Continuation<? super Unit> continuation) {
            return ((C00801) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0077  */
        /* JADX WARN: Code duplicated, block: B:29:0x008a A[PHI: r2 r5
  0x008a: PHI (r2v4 kotlinx.coroutines.flow.FlowCollector) = (r2v2 kotlinx.coroutines.flow.FlowCollector), (r2v9 kotlinx.coroutines.flow.FlowCollector) binds: [B:27:0x0086, B:10:0x0021] A[DONT_GENERATE, DONT_INLINE]
  0x008a: PHI (r5v2 java.lang.Object) = (r5v1 java.lang.Object), (r5v10 java.lang.Object) binds: [B:27:0x0086, B:10:0x0021] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:31:0x009a  */
        /* JADX WARN: Code duplicated, block: B:34:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:37:0x0106  */
        /* JADX WARN: Code duplicated, block: B:39:0x0114  */
        /* JADX WARN: Code duplicated, block: B:41:0x011e  */
        /* JADX WARN: Code duplicated, block: B:43:0x013b  */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
        
            if (r2.emit(r7, r22) == r1) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0157, code lost:
        
            if (r2.emit(r6, r22) == r1) goto L45;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 349
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager.C00801.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Flow<RetroAchievementsUserProfileEntity> getRetroAchievementsUserProfile(RetroInterface retroInterface, String str) {
        return FlowKt.flow(new C00801(str, retroInterface, null));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsAwardsByUserId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserAwardEntity;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsAwardsByUserId$1", f = "RetroAchievementsManager.kt", i = {2}, l = {669, 677, 684, 721}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
    static final class C00761 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends RetroAchievementsUserAwardEntity>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $username;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00761(String str, Continuation<? super C00761> continuation) {
            super(2, continuation);
            this.$username = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00761 c00761 = RetroAchievementsManager.this.new C00761(this.$username, continuation);
            c00761.L$0 = obj;
            return c00761;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends RetroAchievementsUserAwardEntity>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super List<RetroAchievementsUserAwardEntity>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super List<RetroAchievementsUserAwardEntity>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C00761) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x0093  */
        /* JADX WARN: Code duplicated, block: B:45:0x00c2 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:8:0x0018, B:52:0x01ce, B:15:0x002c, B:43:0x00bc, B:45:0x00c2, B:46:0x00e8, B:48:0x00ee, B:49:0x0195, B:55:0x01dc, B:57:0x01ef, B:58:0x01f8, B:59:0x01f9, B:60:0x0204, B:40:0x00ab), top: B:68:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:48:0x00ee A[Catch: all -> 0x001d, LOOP:0: B:46:0x00e8->B:48:0x00ee, LOOP_END, TryCatch #0 {all -> 0x001d, blocks: (B:8:0x0018, B:52:0x01ce, B:15:0x002c, B:43:0x00bc, B:45:0x00c2, B:46:0x00e8, B:48:0x00ee, B:49:0x0195, B:55:0x01dc, B:57:0x01ef, B:58:0x01f8, B:59:0x01f9, B:60:0x0204, B:40:0x00ab), top: B:68:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:51:0x01cd  */
        /* JADX WARN: Code duplicated, block: B:55:0x01dc A[Catch: all -> 0x001d, TRY_ENTER, TryCatch #0 {all -> 0x001d, blocks: (B:8:0x0018, B:52:0x01ce, B:15:0x002c, B:43:0x00bc, B:45:0x00c2, B:46:0x00e8, B:48:0x00ee, B:49:0x0195, B:55:0x01dc, B:57:0x01ef, B:58:0x01f8, B:59:0x01f9, B:60:0x0204, B:40:0x00ab), top: B:68:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:57:0x01ef A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:8:0x0018, B:52:0x01ce, B:15:0x002c, B:43:0x00bc, B:45:0x00c2, B:46:0x00e8, B:48:0x00ee, B:49:0x0195, B:55:0x01dc, B:57:0x01ef, B:58:0x01f8, B:59:0x01f9, B:60:0x0204, B:40:0x00ab), top: B:68:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:59:0x01f9 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:8:0x0018, B:52:0x01ce, B:15:0x002c, B:43:0x00bc, B:45:0x00c2, B:46:0x00e8, B:48:0x00ee, B:49:0x0195, B:55:0x01dc, B:57:0x01ef, B:58:0x01f8, B:59:0x01f9, B:60:0x0204, B:40:0x00ab), top: B:68:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:63:0x0211  */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x008c, code lost:
        
            if (r2.emit(r9, r28) == r0) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x021e, code lost:
        
            if (r2.emit(kotlin.collections.CollectionsKt.emptyList(), r28) == r0) goto L65;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r29) {
            /*
                Method dump skipped, instruction units count: 548
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager.C00761.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<List<RetroAchievementsUserAwardEntity>> getRetroAchievementsAwardsByUserId(String str) {
        return FlowKt.flow(new C00761(str, null));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsConsoleIds$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "", "Lcom/magneticchen/daijishou/data/RetroAchievementsConsole;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager$getRetroAchievementsConsoleIds$1", f = "RetroAchievementsManager.kt", i = {1}, l = {Constants.semiBolderWeight, 759, 769}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
    static final class C00771 extends SuspendLambda implements Function2<FlowCollector<? super Map<Long, ? extends RetroAchievementsConsole>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00771(Continuation<? super C00771> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00771 c00771 = RetroAchievementsManager.this.new C00771(continuation);
            c00771.L$0 = obj;
            return c00771;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Map<Long, ? extends RetroAchievementsConsole>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Map<Long, RetroAchievementsConsole>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Map<Long, RetroAchievementsConsole>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C00771) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0077  */
        /* JADX WARN: Code duplicated, block: B:29:0x00a6 A[LOOP:0: B:27:0x00a0->B:29:0x00a6, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:35:0x00f0  */
        /* JADX WARN: Code duplicated, block: B:37:0x00ff  */
        /* JADX WARN: Code duplicated, block: B:39:0x0109  */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
        
            if (r1.emit(r11.this$0.consoles, r11) == r0) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00ea, code lost:
        
            if (r1.emit(r11.this$0.consoles, r11) == r0) goto L32;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 283
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.retroachievements.v2.RetroAchievementsManager.C00771.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Flow<Map<Long, RetroAchievementsConsole>> getRetroAchievementsConsoleIds() {
        return FlowKt.flow(new C00771(null));
    }

    private final RetroCredentials getRetroAchievementsCredentials() {
        String string;
        String string2 = getRetroAchievementsSharedPreferences().getString(com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager.USERNAME_PREFERENCE_STRING, null);
        if (string2 == null || (string = getRetroAchievementsSharedPreferences().getString(com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager.WEB_API_KEY_PREFERENCE_STRING, null)) == null) {
            return null;
        }
        return new RetroCredentials(string2, string);
    }

    private final String getUsername() {
        return getRetroAchievementsSharedPreferences().getString(com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager.USERNAME_PREFERENCE_STRING, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RetroInterface getRetroAchievementsInterface() {
        RetroCredentials retroAchievementsCredentials = getRetroAchievementsCredentials();
        if (retroAchievementsCredentials != null) {
            return new RetroClient(retroAchievementsCredentials, false, 2, (DefaultConstructorMarker) null).getApi();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toGenericNameExtreme(String str) {
        List<String> groupValues;
        String str2;
        MatchResult matchResultFind$default = Regex.find$default(RetroAchievementsConfiguration.INSTANCE.getGenericNameRegex(), str, 0, 2, null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null && (str2 = groupValues.get(1)) != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                String strReplace = new Regex("(\\s+|_+)").replace(lowerCase, "");
                if (strReplace != null) {
                    return new Regex("[^0-9a-zA-Z]+").replace(strReplace, "");
                }
            }
        }
        return null;
    }
}
