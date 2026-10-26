package com.magneticchen.daijishou.retro_achievements.v2;

import android.content.SharedPreferences;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.common.Scopes;
import com.haroldadmin.cnradapter.NetworkResponse;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.live_data.SharedPreferenceStringLiveData;
import com.magneticchen.daijishou.repositories.RetroAchievementsRepository;
import com.magneticchen.daijishou.retro_achievements.RetroAchievementsConsole;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserAwardEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserIndependentGameRecordEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserProfileEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt;
import org.eclipse.jgit.lib.ReflogEntry;
import org.retroachivements.api.RetroClient;
import org.retroachivements.api.RetroInterface;
import org.retroachivements.api.data.pojo.ErrorResponse;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsAchievementRecordEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
import com.magneticchen.daijishou.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import java.util.Date;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.ranges.RangesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import com.magneticchen.daijishou.utils.UtilsKt;
import org.retroachivements.api.data.RetroCredentials;
import org.retroachivements.api.data.pojo.ErrorResponse;
import org.retroachivements.api.data.pojo.user.GetUserCompletionProgress;

/* INFO: compiled from: RetroAchievementsManager.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010.\u001a\u0004\u0018\u00010\u00182\b\u0010/\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u00100J\u000e\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\tJ\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u0001042\u0006\u00105\u001a\u000206J\u001c\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020908042\u0006\u0010-\u001a\u00020\u0018H\u0002J\u001a\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0;04H\u0002J\n\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u001a\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?08042\u0006\u0010/\u001a\u00020\rJ\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020A042\u0006\u0010-\u001a\u00020\u00182\u0006\u0010B\u001a\u00020\rJ\n\u0010C\u001a\u0004\u0018\u00010DH\u0002J\u001e\u0010E\u001a\b\u0012\u0004\u0012\u00020F042\u0006\u0010G\u001a\u00020D2\u0006\u0010-\u001a\u00020\u0018H\u0002J.\u0010H\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020A0\bj\b\u0012\u0004\u0012\u00020A`\n042\u0006\u0010G\u001a\u00020D2\u0006\u0010-\u001a\u00020\u0018H\u0002J.\u0010I\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020A0\bj\b\u0012\u0004\u0012\u00020A`\n042\u0006\u0010G\u001a\u00020D2\u0006\u0010-\u001a\u00020\u0018H\u0002J\n\u0010J\u001a\u0004\u0018\u00010\u0018H\u0002J\u0006\u0010K\u001a\u00020LJ\u0016\u0010M\u001a\u00020L2\u0006\u0010-\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010NJ\u0014\u0010O\u001a\u00020L2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\r08J\u0012\u0010Q\u001a\u0004\u0018\u00010\u00182\u0006\u0010R\u001a\u00020\u0018H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00060\u0016R\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00180\bj\b\u0012\u0004\u0012\u00020\u0018`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\r0\bj\b\u0012\u0004\u0012\u00020\r`\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\bj\b\u0012\u0004\u0012\u00020\r`\n0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\r0\bj\b\u0012\u0004\u0012\u00020\r`\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\bj\b\u0012\u0004\u0012\u00020\r`\n0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/magneticchen/daijishou/retro_achievements/v2/RetroAchievementsManager;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "consoleWatchlist", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "consoles", "Ljava/util/HashMap;", "", "Lcom/magneticchen/daijishou/retro_achievements/RetroAchievementsConsole;", "Lkotlin/collections/HashMap;", "<set-?>", "", ReflogEntry.PREFIX_CREATED, "getCreated", "()Z", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "refreshingAwards", "", "refreshingConsoleIds", "refreshingConsoleIdsLiveData", "Landroidx/lifecycle/MutableLiveData;", "refreshingGameIds", "refreshingGameIdsLiveData", "retroAchievementsRepository", "Lcom/magneticchen/daijishou/repositories/RetroAchievementsRepository;", "getRetroAchievementsRepository", "()Lcom/magneticchen/daijishou/repositories/RetroAchievementsRepository;", "setRetroAchievementsRepository", "(Lcom/magneticchen/daijishou/repositories/RetroAchievementsRepository;)V", "retroAchievementsSharedPreferences", "Landroid/content/SharedPreferences;", "getRetroAchievementsSharedPreferences", "()Landroid/content/SharedPreferences;", "setRetroAchievementsSharedPreferences", "(Landroid/content/SharedPreferences;)V", "retroAchievementsUsernamePreferenceLiveData", "Lcom/magneticchen/daijishou/live_data/SharedPreferenceStringLiveData;", "retroAchievementsWebApiKeyPreferenceLiveData", "username", "getConsoleImageUrl", "consoleId", "(Ljava/lang/Long;)Ljava/lang/String;", "getForumUrlString", "forumTopicId", "getPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity", "Lkotlinx/coroutines/flow/Flow;", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "getRetroAchievementsAwardsByUserId", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserAwardEntity;", "getRetroAchievementsConsoleIds", "", "getRetroAchievementsCredentials", "Lorg/retroachivements/api/data/RetroCredentials;", "getRetroAchievementsGameListByConsoleId", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserIndependentGameRecordEntity;", "getRetroAchievementsGameRecordByGameId", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "gameId", "getRetroAchievementsInterface", "Lorg/retroachivements/api/RetroInterface;", "getRetroAchievementsUserProfile", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileEntity;", "retroInterface", "getRetroAchievementsUserProgressGames", "getRetroAchievementsUserRecentGames", "getUsername", "initialize", "", "refreshUserProfile", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setConsoleWatchlist", "consoleWatchList", "toGenericNameExtreme", TypedValues.Custom.S_STRING, "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
        this.retroAchievementsUsernamePreferenceLiveData = new SharedPreferenceStringLiveData(getRetroAchievementsSharedPreferences(), "username", null);
        this.retroAchievementsWebApiKeyPreferenceLiveData = new SharedPreferenceStringLiveData(getRetroAchievementsSharedPreferences(), "web_api_key", null);
        this.created = true;
    }

    /* INFO: Access modifiers changed from: private */
    public final Object refreshUserProfile(String str, Continuation<?> continuation) {
        Object objCollect;
        RetroInterface retroAchievementsInterface = getRetroAchievementsInterface();
        return (retroAchievementsInterface != null && (objCollect = FlowKt.retryWhen(getRetroAchievementsUserProfile(retroAchievementsInterface, str), new AnonymousClass2(null)).collect(new AnonymousClass3(this, retroAchievementsInterface, str), (kotlin.coroutines.Continuation<? super kotlin.Unit>) continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objCollect : Unit.INSTANCE;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$refreshUserProfile$2, reason: invalid class name */
    /* INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileEntity;", "<anonymous parameter 0>", "", "attempt", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$refreshUserProfile$2", f = "RetroAchievementsManager.kt", i = {}, l = {93}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function4<FlowCollector<? super RetroAchievementsUserProfileEntity>, Throwable, Long, Continuation<?>, Object> {
        /* synthetic */ long J$0;
        int label;

        AnonymousClass2(Continuation<?> continuation) {
            super(4, continuation);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super RetroAchievementsUserProfileEntity> flowCollector, Throwable th, Long l, Continuation<?> continuation) {
            return invoke(flowCollector, th, l.longValue(), continuation);
        }

        public final Object invoke(FlowCollector<? super RetroAchievementsUserProfileEntity> flowCollector, Throwable th, long j, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.J$0 = j;
            try {
                return anonymousClass2.invokeSuspendImpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th2);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
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

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$refreshUserProfile$3, reason: invalid class name */
    /* INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", Scopes.PROFILE, "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileEntity;", "emit", "(Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass3<T> implements FlowCollector {
        final /* synthetic */ RetroInterface $retroAchievements;
        final /* synthetic */ String $username;
        final /* synthetic */ RetroAchievementsManager this$0;

        AnonymousClass3(RetroAchievementsManager retroAchievementsManager, RetroInterface retroInterface, String str) {
            this.this$0 = retroAchievementsManager;
            this.$retroAchievements = retroInterface;
            this.$username = str;
        }

        /* WARN: Code duplicated, block: B:7:0x0014  */
        /* WARN: Code restructure failed: missing block: B:26:0x00ca, code lost:
        
            if (r9.collect(r10, r0) == r1) goto L27;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final Object emit(RetroAchievementsUserProfileEntity profile, Continuation<?> continuation) throws Throwable {
            RetroAchievementsManager$refreshUserProfile$3$emit$1 c;
            if (continuation instanceof RetroAchievementsManager$refreshUserProfile$3$emit$1) {
                c = (RetroAchievementsManager$refreshUserProfile$3$emit$1) continuation;
                if ((c.label & Integer.MIN_VALUE) != 0) {
                    c.label -= Integer.MIN_VALUE;
                } else {
                    c = new RetroAchievementsManager$refreshUserProfile$3$emit$1(this, continuation);
                }
            } else {
                c = new RetroAchievementsManager$refreshUserProfile$3$emit$1(this, continuation);
            }
            Object obj = c.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = c.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RetroAchievementsUserProfileEntity profileEntity = profile;
                Flow retryWhen = FlowKt.retryWhen(this.this$0.getRetroAchievementsUserProgressGames(this.$retroAchievements, this.$username), new AnonymousClass1(null));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, profileEntity);
                c.L$0 = this;
                c.L$1 = profileEntity;
                c.label = 1;
                if (retryWhen.collect(anonymousClass2, c) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                RetroAchievementsUserProfileEntity profileEntity = (RetroAchievementsUserProfileEntity) c.L$1;
                AnonymousClass3 anonymousClass3 = (AnonymousClass3) c.L$0;
                ResultKt.throwOnFailure(obj);
                Flow retryWhen2 = FlowKt.retryWhen(anonymousClass3.this$0.getRetroAchievementsAwardsByUserId(anonymousClass3.$username), new AnonymousClass5(null));
                AnonymousClass6 anonymousClass6 = AnonymousClass6.INSTANCE;
                c.L$0 = null;
                c.L$1 = null;
                c.label = 3;
                if (retryWhen2.collect(anonymousClass6, c) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            } else if (i == 2) {
                AnonymousClass3 anonymousClass3 = (AnonymousClass3) c.L$0;
                ResultKt.throwOnFailure(obj);
                Flow retryWhen2 = FlowKt.retryWhen(anonymousClass3.this$0.getRetroAchievementsAwardsByUserId(anonymousClass3.$username), new AnonymousClass5(null));
                AnonymousClass6 anonymousClass6 = AnonymousClass6.INSTANCE;
                c.L$0 = null;
                c.label = 3;
                if (retryWhen2.collect(anonymousClass6, c) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            } else if (i == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            try {
                return emit((RetroAchievementsUserProfileEntity) obj, (Continuation<?>) continuation);
            } catch (Throwable th2) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th2);
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$refreshUserProfile$3$1, reason: invalid class name */
        /* INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00050\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Ljava/util/HashSet;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lkotlin/collections/HashSet;", "<anonymous parameter 0>", "", "attempts", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$refreshUserProfile$3$1", f = "RetroAchievementsManager.kt", i = {}, l = {103}, m = "invokeSuspendImpl", n = {}, s = {})
        static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function4<FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>>, Throwable, Long, Continuation<?>, Object> {
            /* synthetic */ long J$0;
            int label;

            AnonymousClass1(Continuation<?> continuation) {
                super(4, continuation);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>> flowCollector, Throwable th, Long l, Continuation<?> continuation) {
                return invoke(flowCollector, th, l.longValue(), continuation);
            }

            public final Object invoke(FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>> flowCollector, Throwable th, long j, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.J$0 = j;
                try {
                    return anonymousClass1.invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th2);
                }
            }

            public final Object invokeSuspendImpl(Object obj) throws Throwable {
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

        /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$refreshUserProfile$3$2, reason: invalid class name */
        /* INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "progressSet", "Ljava/util/HashSet;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lkotlin/collections/HashSet;", "emit", "(Ljava/util/HashSet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass2<T> implements FlowCollector {
            final /* synthetic */ RetroAchievementsUserProfileEntity $profile;
            final /* synthetic */ RetroAchievementsManager this$0;

            AnonymousClass2(RetroAchievementsManager retroAchievementsManager, RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
                this.this$0 = retroAchievementsManager;
                this.$profile = retroAchievementsUserProfileEntity;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((HashSet<RetroAchievementsGameRecordEntity>) obj, (Continuation<?>) continuation);
            }

            public final Object emit(HashSet<RetroAchievementsGameRecordEntity> hashSet, Continuation<?> continuation) {
                RetroAchievementsRepository retroAchievementsRepository = this.this$0.getRetroAchievementsRepository();
                RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity = this.$profile;
                HashSet<RetroAchievementsGameRecordEntity> hashSet2 = hashSet;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(hashSet2, 10));
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    arrayList.add(Boxing.boxLong(((RetroAchievementsGameRecordEntity) it.next()).getGameId()));
                }
                retroAchievementsUserProfileEntity.setCompletionProgressGameIds(CollectionsKt.toMutableList((Collection) arrayList));
                retroAchievementsRepository.addRetroAchievementsUserProfile(retroAchievementsUserProfileEntity);
                return Unit.INSTANCE;
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$refreshUserProfile$3$3, reason: invalid class name and collision with other inner class name */
        /* INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00050\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Ljava/util/HashSet;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lkotlin/collections/HashSet;", "<anonymous parameter 0>", "", "attempts", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$refreshUserProfile$3$3", f = "RetroAchievementsManager.kt", i = {}, l = {119}, m = "invokeSuspendImpl", n = {}, s = {})
        static final class C00663 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function4<FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>>, Throwable, Long, Continuation<?>, Object> {
            /* synthetic */ long J$0;
            int label;

            C00663(Continuation<?> continuation) {
                super(4, continuation);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>> flowCollector, Throwable th, Long l, Continuation<?> continuation) {
                return invoke(flowCollector, th, l.longValue(), continuation);
            }

            public final Object invoke(FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>> flowCollector, Throwable th, long j, Continuation<?> continuation) {
                C00663 c00663 = new C00663(continuation);
                c00663.J$0 = j;
                try {
                    return c00663.invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th2);
                }
            }

            public final Object invokeSuspendImpl(Object obj) throws Throwable {
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

        /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$refreshUserProfile$3$4, reason: invalid class name */
        /* INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "recentGames", "Ljava/util/HashSet;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lkotlin/collections/HashSet;", "emit", "(Ljava/util/HashSet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass4<T> implements FlowCollector {
            final /* synthetic */ RetroAchievementsUserProfileEntity $profile;
            final /* synthetic */ RetroAchievementsManager this$0;

            AnonymousClass4(RetroAchievementsManager retroAchievementsManager, RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
                this.this$0 = retroAchievementsManager;
                this.$profile = retroAchievementsUserProfileEntity;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((HashSet<RetroAchievementsGameRecordEntity>) obj, (Continuation<?>) continuation);
            }

            public final Object emit(HashSet<RetroAchievementsGameRecordEntity> hashSet, Continuation<?> continuation) {
                RetroAchievementsRepository retroAchievementsRepository = this.this$0.getRetroAchievementsRepository();
                RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity = this.$profile;
                HashSet<RetroAchievementsGameRecordEntity> hashSet2 = hashSet;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(hashSet2, 10));
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    arrayList.add(Boxing.boxLong(((RetroAchievementsGameRecordEntity) it.next()).getGameId()));
                }
                retroAchievementsUserProfileEntity.setRecentPlayedGameIds(CollectionsKt.toMutableList((Collection) arrayList));
                retroAchievementsRepository.addRetroAchievementsUserProfile(retroAchievementsUserProfileEntity);
                return Unit.INSTANCE;
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$refreshUserProfile$3$5, reason: invalid class name */
        /* INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserAwardEntity;", "<anonymous parameter 0>", "", "attempts", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$refreshUserProfile$3$5", f = "RetroAchievementsManager.kt", i = {}, l = {134}, m = "invokeSuspendImpl", n = {}, s = {})
        static final class AnonymousClass5 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function4<FlowCollector<? super List<? extends RetroAchievementsUserAwardEntity>>, Throwable, Long, Continuation<?>, Object> {
            /* synthetic */ long J$0;
            int label;

            AnonymousClass5(Continuation<?> continuation) {
                super(4, continuation);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends RetroAchievementsUserAwardEntity>> flowCollector, Throwable th, Long l, Continuation<?> continuation) {
                return invoke((FlowCollector<? super List<RetroAchievementsUserAwardEntity>>) flowCollector, th, l.longValue(), continuation);
            }

            public final Object invoke(FlowCollector<? super List<RetroAchievementsUserAwardEntity>> flowCollector, Throwable th, long j, Continuation<?> continuation) {
                AnonymousClass5 anonymousClass5 = new AnonymousClass5(continuation);
                anonymousClass5.J$0 = j;
                try {
                    return anonymousClass5.invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th2);
                }
            }

            public final Object invokeSuspendImpl(Object obj) throws Throwable {
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

        /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$refreshUserProfile$3$6, reason: invalid class name */
        /* INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "awards", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserAwardEntity;", "emit", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass6<T> implements FlowCollector {
            public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

            AnonymousClass6() {
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((List<RetroAchievementsUserAwardEntity>) obj, (Continuation<?>) continuation);
            }

            public final Object emit(List<RetroAchievementsUserAwardEntity> list, Continuation<?> continuation) {
                return Unit.INSTANCE;
            }
        }
    }

    public final String getForumUrlString(int forumTopicId) {
        return "https://retroachievements.org/viewtopic.php?t=" + forumTopicId;
    }

    public final String getConsoleImageUrl(Long consoleId) {
        if (consoleId != null) {
            RetroAchievementsConsole retroAchievementsConsole = this.consoles.get(Long.valueOf(consoleId.longValue()));
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
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new C02731(consoleWatchList, this, null), 2, null);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$setConsoleWatchlist$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$setConsoleWatchlist$1", f = "RetroAchievementsManager.kt", i = {}, l = {160}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class C02731 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ List<Long> $consoleWatchList;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ RetroAchievementsManager this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02731(List<Long> list, RetroAchievementsManager retroAchievementsManager, Continuation<?> continuation) {
            super(2, continuation);
            this.$consoleWatchList = list;
            this.this$0 = retroAchievementsManager;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new C02731(this.$consoleWatchList, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((C02731) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
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
                Flow flowRetry$default = FlowKt.retry$default(retroAchievementsManager.getRetroAchievementsGameListByConsoleId(((Number) it.next()).longValue()), 3L, null, 2, null);
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

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity$1, reason: invalid class name */
    /* INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity$1", f = "RetroAchievementsManager.kt", i = {3, 3}, l = {172, 179, 189, 196, 263}, m = "invokeSuspendImpl", n = {"$this$flow", "retroAchievementsConsoleIdList"}, s = {"L$0", "L$1"})
    final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<FlowCollector<? super Object>, Continuation<?>, Object> {
        final /* synthetic */ PlayableItemEntity $playableItemEntity;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PlayableItemEntity playableItemEntity, Continuation<?> continuation) {
            super(2, continuation);
            this.$playableItemEntity = playableItemEntity;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = RetroAchievementsManager.this.new AnonymousClass1(this.$playableItemEntity, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Object> flowCollector, Continuation<?> continuation) {
            return invoke2((FlowCollector<Object>) flowCollector, continuation);
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<Object> flowCollector, Continuation<?> continuation) {
            try {
                return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspendImpl(Unit.INSTANCE);
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        /* WARN: Code duplicated, block: B:104:0x02f1  */
        /* WARN: Code duplicated, block: B:107:0x02ed A[SYNTHETIC] */
        /* WARN: Code duplicated, block: B:109:? A[LOOP:0: B:47:0x00f6->B:109:?, LOOP_END, SYNTHETIC] */
        /* WARN: Code duplicated, block: B:111:0x016b A[SYNTHETIC] */
        /* WARN: Code duplicated, block: B:112:0x015a A[SYNTHETIC] */
        /* WARN: Code duplicated, block: B:113:0x0175 A[SYNTHETIC] */
        /* WARN: Code duplicated, block: B:115:0x0140 A[SYNTHETIC] */
        /* WARN: Code duplicated, block: B:122:0x020b A[SYNTHETIC] */
        /* WARN: Code duplicated, block: B:37:0x00ac  */
        /* WARN: Code duplicated, block: B:39:0x00c9  */
        /* WARN: Code duplicated, block: B:41:0x00d3  */
        /* WARN: Code duplicated, block: B:46:0x00e7  */
        /* WARN: Code duplicated, block: B:49:0x00fc  */
        /* WARN: Code duplicated, block: B:55:0x0146  */
        /* WARN: Code duplicated, block: B:64:0x01a0  */
        /* WARN: Code duplicated, block: B:66:0x01a8  */
        /* WARN: Code duplicated, block: B:70:0x01c7  */
        /* WARN: Code duplicated, block: B:73:0x01f9  */
        /* WARN: Code duplicated, block: B:75:0x0205  */
        /* WARN: Code duplicated, block: B:80:0x023b  */
        /* WARN: Code duplicated, block: B:82:0x024f  */
        /* WARN: Code duplicated, block: B:84:0x025f  */
        /* WARN: Code duplicated, block: B:85:0x0263  */
        /* WARN: Code duplicated, block: B:89:0x0281  */
        /* WARN: Code duplicated, block: B:91:0x0287  */
        /* WARN: Code duplicated, block: B:97:0x02b0  */
        /* WARN: Code duplicated, block: B:98:0x02b5  */
        /* WARN: Code restructure failed: missing block: B:100:0x02eb, code lost:
        
            if (r11.emit(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true), r39) == r1) goto L101;
         */
        /* WARN: Code restructure failed: missing block: B:21:0x0072, code lost:
        
            if (r2.emit(r10, r39) == r1) goto L101;
         */
        /* WARN: Code restructure failed: missing block: B:33:0x00a5, code lost:
        
            if (r2.emit(r10, r39) == r1) goto L101;
         */
        /* WARN: Code restructure failed: missing block: B:42:0x00e0, code lost:
        
            if (r2.emit(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false), r39) == r1) goto L101;
         */
        /* WARN: Multi-variable type inference failed */
        /* WARN: Type inference failed for: r2v30, types: [T, java.lang.Long] */

        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            PlatformEntity platformByIdStatically;
            List<Long> retroAchievementsConsoleIdList;
            FlowCollector flowCollector;
            Iterator it;
            RetroAchievementsManager retroAchievementsManager;
            List<String> mutableList;
            Ref.ObjectRef objectRef;
            Ref.FloatRef floatRef;
            RetroAchievementsManager retroAchievementsManager2;
            int i;
            Long l;
            long null_game_id;
            long jLongValue;
            float size;
            String str;
            int length;
            String strReplace$default;
            String name;
            long id2;
            float f;
            float ranking;
            Flow flowRetry$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2 || i2 == 3) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i2 == 4) {
                    it = (Iterator) this.L$3;
                    retroAchievementsManager = (RetroAchievementsManager) this.L$2;
                    retroAchievementsConsoleIdList = (List) this.L$1;
                    flowCollector = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    while (it.hasNext()) {
                        flowRetry$default = FlowKt.retry$default(retroAchievementsManager.getRetroAchievementsGameListByConsoleId(((Number) it.next()).longValue()), 3L, null, 2, null);
                        this.L$0 = flowCollector;
                        this.L$1 = retroAchievementsConsoleIdList;
                        this.L$2 = retroAchievementsManager;
                        this.L$3 = it;
                        this.label = 4;
                        if (FlowKt.collect(flowRetry$default, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else if (i2 == 5) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity surjection = RetroAchievementsManager.this.getRetroAchievementsRepository().getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemIdStatically(this.$playableItemEntity.getId());
                if (surjection != null) {
                    if (surjection.isPermanent()) {
                        this.label = 1;
                        if (flowCollector2.emit(surjection, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    Date lastUpdatedTimestamp = surjection.getLastUpdatedTimestamp();
                    Long lBoxLong = lastUpdatedTimestamp != null ? Boxing.boxLong(lastUpdatedTimestamp.getTime()) : null;
                    if (lBoxLong != null && lBoxLong.longValue() + ((long) RetroAchievementsConfiguration.PLAYABLE_ITEM_ID_TO_GAME_ID_SURJECTION_EXPIRE_DURATION_MS) > System.currentTimeMillis()) {
                        this.label = 2;
                        if (flowCollector2.emit(surjection, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                }
                DaijishouLibraryRepository daijishouLibraryRepository = RetroAchievementsManager.this.getApplication().getDaijishouLibraryRepository();
                Long attachedPlatformId = this.$playableItemEntity.getAttachedPlatformId();
                Intrinsics.checkNotNull(attachedPlatformId);
                platformByIdStatically = daijishouLibraryRepository.getPlatformByIdStatically(attachedPlatformId.longValue());
                if (platformByIdStatically == null) {
                    throw new NullPointerException("Couldn't retrieve platform entity for the platform ID `" + this.$playableItemEntity.getAttachedPlatformId() + "`");
                }
                retroAchievementsConsoleIdList = platformByIdStatically.getRetroAchievementsConsoleIdList();
                if (retroAchievementsConsoleIdList.isEmpty()) {
                    this.label = 3;
                    if (flowCollector2.emit(Boxing.boxBoolean(false), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                retroAchievementsManager = RetroAchievementsManager.this;
                flowCollector = flowCollector2;
                it = retroAchievementsConsoleIdList.iterator();
                while (it.hasNext()) {
                    flowRetry$default = FlowKt.retry$default(retroAchievementsManager.getRetroAchievementsGameListByConsoleId(((Number) it.next()).longValue()), 3L, null, 2, null);
                    this.L$0 = flowCollector;
                    this.L$1 = retroAchievementsConsoleIdList;
                    this.L$2 = retroAchievementsManager;
                    this.L$3 = it;
                    this.label = 4;
                    if (FlowKt.collect(flowRetry$default, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            mutableList = CollectionsKt.toMutableList((Collection) this.$playableItemEntity.getScraperKeywordList());
            for (String str3 : this.$playableItemEntity.getScraperKeywordList()) {
                if (StringsKt.contains$default((CharSequence) str3, (CharSequence) " - ", false, 2, (Object) null)) {
                    mutableList.add(StringsKt.replace$default(str3, " - ", "", false, 4, (Object) null));
                } else if (StringsKt.contains$default((CharSequence) str3, (CharSequence) ": ", false, 2, (Object) null)) {
                    mutableList.add(StringsKt.replace$default(str3, ": ", " ", false, 4, (Object) null));
                }
            }
            objectRef = new Ref.ObjectRef();
            floatRef = new Ref.FloatRef();
            retroAchievementsManager2 = RetroAchievementsManager.this;
            i = 0;
            for (Object obj2 : retroAchievementsConsoleIdList) {
                int i5 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                jLongValue = ((Number) obj2).longValue();
                size = (retroAchievementsConsoleIdList.size() - i) - 1.0f;
                for (String str4 : mutableList) {
                    String[] strArr = new String[] { "&" };
                    str = "";
                    length = 0;
                    for (Object str5Obj : (Iterable) StringsKt.split$default((CharSequence) str4, strArr, false, 0, 6, (Object) null)) {
                        String str5 = (String) str5Obj;
                        if (str5.length() > length) {
                            length = str5.length();
                            str = str5;
                        }
                    }
                    strReplace$default = StringsKt.replace$default(str, " - ", ": ", false, 4, (Object) null);
                    for (Object itemObj : (Iterable) RetroAchievementsRepository.searchRetroAchievementsUserIndependentGameRecordByKeywordAndConsoleId$default(retroAchievementsManager2.getRetroAchievementsRepository(), strReplace$default, jLongValue, 0, null, false, 28, null)) {
                        RetroAchievementsRepository.RetroAchievementsUserIndependentGameRecordSearchItem item = (RetroAchievementsRepository.RetroAchievementsUserIndependentGameRecordSearchItem) itemObj;
                        RetroAchievementsUserIndependentGameRecordEntity entity = item.getRetroAchievementsUserIndependentGameRecordEntity();
                        name = entity.getName();
                        id2 = entity.getId();
                        f = size;
                        if (name != null) {
                            if (Intrinsics.areEqual(retroAchievementsManager2.toGenericNameExtreme(name), retroAchievementsManager2.toGenericNameExtreme(strReplace$default))) {
                                f = 1.0f + size;
                            }
                        }
                        ranking = f + (item.getRanking() / item.getMaxRanking()) + (item.getMatchCount() / item.getMaxMatchCount());
                        if (objectRef.element == null || ranking > floatRef.element) {
                            floatRef.element = ranking;
                            objectRef.element = Boxing.boxLong(id2);
                        }
                    }
                }
                i = i5;
            }
            RetroAchievementsRepository retroAchievementsRepository = RetroAchievementsManager.this.getRetroAchievementsRepository();
            long id3 = this.$playableItemEntity.getId();
            l = (Long) objectRef.element;
            if (l != null) {
                null_game_id = l.longValue();
            } else {
                null_game_id = RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.INSTANCE.getNULL_GAME_ID();
            }
            retroAchievementsRepository.addRetroAchievementsCachedPlayableItemIdToGameIdSurjection(new RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity(0L, false, id3, null_game_id, new Date(), 3, null));
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 5;
            if (flowCollector.emit(Boxing.boxBoolean(true), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    public final Flow<Object> getPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity(PlayableItemEntity playableItemEntity) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        return FlowKt.flow(new AnonymousClass1(playableItemEntity, null));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsGameListByConsoleId$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserIndependentGameRecordEntity;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsGameListByConsoleId$1", f = "RetroAchievementsManager.kt", i = {1, 1, 2}, l = {279, 290, 294, 322, 340, 340}, m = "invokeSuspendImpl", n = {"$this$flow", "retroInterface", "$this$flow"}, s = {"L$0", "L$1", "L$0"})
    final class C02681 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<FlowCollector<? super List<? extends RetroAchievementsUserIndependentGameRecordEntity>>, Continuation<?>, Object> {
        final /* synthetic */ long $consoleId;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02681(long j, Continuation<?> continuation) {
            super(2, continuation);
            this.$consoleId = j;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            C02681 c02681 = RetroAchievementsManager.this.new C02681(this.$consoleId, continuation);
            c02681.L$0 = obj;
            return c02681;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends RetroAchievementsUserIndependentGameRecordEntity>> flowCollector, Continuation<?> continuation) {
            return invoke2((FlowCollector<? super List<RetroAchievementsUserIndependentGameRecordEntity>>) flowCollector, continuation);
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super List<RetroAchievementsUserIndependentGameRecordEntity>> flowCollector, Continuation<?> continuation) {
            try {
                return ((C02681) create(flowCollector, continuation)).invokeSuspendImpl(Unit.INSTANCE);
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        /* WARN: Code duplicated, block: B:44:0x00f6  */
        /* WARN: Code duplicated, block: B:45:0x00f8 A[Catch: all -> 0x002c, PHI: r3 r5
  0x00f8: PHI (r3v10 kotlinx.coroutines.flow.FlowCollector) = (r3v6 kotlinx.coroutines.flow.FlowCollector), (r3v21 kotlinx.coroutines.flow.FlowCollector) binds: [B:43:0x00f4, B:15:0x0036] A[DONT_GENERATE, DONT_INLINE]
  0x00f8: PHI (r5v13 java.lang.Object) = (r5v10 java.lang.Object), (r5v26 java.lang.Object) binds: [B:43:0x00f4, B:15:0x0036] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x002c, blocks: (B:9:0x0027, B:58:0x01ee, B:14:0x0033, B:45:0x00f8, B:47:0x00fe, B:48:0x011e, B:50:0x0124, B:52:0x0164, B:54:0x016a, B:55:0x01b5, B:63:0x0211, B:65:0x022a, B:66:0x0233, B:67:0x0234, B:68:0x0252, B:17:0x0042, B:42:0x00dc, B:38:0x00ba), top: B:75:0x000b }] */
        /* WARN: Code duplicated, block: B:47:0x00fe A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:9:0x0027, B:58:0x01ee, B:14:0x0033, B:45:0x00f8, B:47:0x00fe, B:48:0x011e, B:50:0x0124, B:52:0x0164, B:54:0x016a, B:55:0x01b5, B:63:0x0211, B:65:0x022a, B:66:0x0233, B:67:0x0234, B:68:0x0252, B:17:0x0042, B:42:0x00dc, B:38:0x00ba), top: B:75:0x000b }] */
        /* WARN: Code duplicated, block: B:50:0x0124 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:9:0x0027, B:58:0x01ee, B:14:0x0033, B:45:0x00f8, B:47:0x00fe, B:48:0x011e, B:50:0x0124, B:52:0x0164, B:54:0x016a, B:55:0x01b5, B:63:0x0211, B:65:0x022a, B:66:0x0233, B:67:0x0234, B:68:0x0252, B:17:0x0042, B:42:0x00dc, B:38:0x00ba), top: B:75:0x000b }] */
        /* WARN: Code duplicated, block: B:52:0x0164 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:9:0x0027, B:58:0x01ee, B:14:0x0033, B:45:0x00f8, B:47:0x00fe, B:48:0x011e, B:50:0x0124, B:52:0x0164, B:54:0x016a, B:55:0x01b5, B:63:0x0211, B:65:0x022a, B:66:0x0233, B:67:0x0234, B:68:0x0252, B:17:0x0042, B:42:0x00dc, B:38:0x00ba), top: B:75:0x000b }] */
        /* WARN: Code duplicated, block: B:53:0x0169  */
        /* WARN: Code duplicated, block: B:57:0x01ec  */
        /* WARN: Code duplicated, block: B:58:0x01ee A[Catch: all -> 0x002c, TRY_LEAVE, TryCatch #0 {all -> 0x002c, blocks: (B:9:0x0027, B:58:0x01ee, B:14:0x0033, B:45:0x00f8, B:47:0x00fe, B:48:0x011e, B:50:0x0124, B:52:0x0164, B:54:0x016a, B:55:0x01b5, B:63:0x0211, B:65:0x022a, B:66:0x0233, B:67:0x0234, B:68:0x0252, B:17:0x0042, B:42:0x00dc, B:38:0x00ba), top: B:75:0x000b }] */
        /* WARN: Code duplicated, block: B:62:0x0210 A[RETURN] */
        /* WARN: Code duplicated, block: B:63:0x0211 A[Catch: all -> 0x002c, TRY_ENTER, TryCatch #0 {all -> 0x002c, blocks: (B:9:0x0027, B:58:0x01ee, B:14:0x0033, B:45:0x00f8, B:47:0x00fe, B:48:0x011e, B:50:0x0124, B:52:0x0164, B:54:0x016a, B:55:0x01b5, B:63:0x0211, B:65:0x022a, B:66:0x0233, B:67:0x0234, B:68:0x0252, B:17:0x0042, B:42:0x00dc, B:38:0x00ba), top: B:75:0x000b }] */
        /* WARN: Code duplicated, block: B:65:0x022a A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:9:0x0027, B:58:0x01ee, B:14:0x0033, B:45:0x00f8, B:47:0x00fe, B:48:0x011e, B:50:0x0124, B:52:0x0164, B:54:0x016a, B:55:0x01b5, B:63:0x0211, B:65:0x022a, B:66:0x0233, B:67:0x0234, B:68:0x0252, B:17:0x0042, B:42:0x00dc, B:38:0x00ba), top: B:75:0x000b }] */
        /* WARN: Code duplicated, block: B:67:0x0234 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:9:0x0027, B:58:0x01ee, B:14:0x0033, B:45:0x00f8, B:47:0x00fe, B:48:0x011e, B:50:0x0124, B:52:0x0164, B:54:0x016a, B:55:0x01b5, B:63:0x0211, B:65:0x022a, B:66:0x0233, B:67:0x0234, B:68:0x0252, B:17:0x0042, B:42:0x00dc, B:38:0x00ba), top: B:75:0x000b }] */
        /* WARN: Code restructure failed: missing block: B:30:0x0099, code lost:
        
            if (r3.emit(r5, r24) == r2) goto L71;
         */

        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                List<RetroAchievementsUserIndependentGameRecordEntity> existing = (List) RetroAchievementsManager.this.getRetroAchievementsRepository().getRetroAchievementsUserIndependentGameRecordsByConsoleId(this.$consoleId).getValue();
                if (existing != null && !existing.isEmpty()) {
                    RetroAchievementsUserIndependentGameRecordEntity first = (RetroAchievementsUserIndependentGameRecordEntity) CollectionsKt.first(existing);
                    Date lastUpdated = first.getLastUpdatedTimestamp();
                    if (lastUpdated != null && lastUpdated.getTime() + 691200000L > System.currentTimeMillis()) {
                        this.label = 1;
                        if (flowCollector.emit(existing, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                }
                RetroInterface retro = RetroAchievementsManager.this.getRetroAchievementsInterface();
                if (retro == null || !RetroAchievementsManager.this.refreshingConsoleIds.add(Boxing.boxLong(this.$consoleId))) {
                    return Unit.INSTANCE;
                }
                try {
                    this.L$0 = flowCollector;
                    this.L$1 = retro;
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C00641(RetroAchievementsManager.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.L$0 = flowCollector;
                    this.L$1 = null;
                    this.label = 3;
                    obj = RetroInterface.DefaultImpls.getGameList$default(retro, this.$consoleId, 0, 0, 0, 0, this, 30, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Throwable th) {
                    BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(RetroAchievementsManager.this, this.$consoleId, null), this);
                    throw th;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else if (i == 2) {
                RetroInterface retro = (RetroInterface) this.L$1;
                flowCollector = (FlowCollector) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = flowCollector;
                    this.L$1 = null;
                    this.label = 3;
                    obj = RetroInterface.DefaultImpls.getGameList$default(retro, this.$consoleId, 0, 0, 0, 0, this, 30, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Throwable th) {
                    BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(RetroAchievementsManager.this, this.$consoleId, null), this);
                    throw th;
                }
            } else if (i == 3) {
                flowCollector = (FlowCollector) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th) {
                    BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(RetroAchievementsManager.this, this.$consoleId, null), this);
                    throw th;
                }
            } else if (i == 4) {
                try {
                    ResultKt.throwOnFailure(obj);
                    BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(RetroAchievementsManager.this, this.$consoleId, null), this);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(RetroAchievementsManager.this, this.$consoleId, null), this);
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                Object responseResult = obj;
                NetworkResponse networkResponse = (NetworkResponse) responseResult;
                if (networkResponse instanceof NetworkResponse.Success) {
                    org.retroachivements.api.data.pojo.system.GetGameList.Response response = (org.retroachivements.api.data.pojo.system.GetGameList.Response) ((NetworkResponse.Success) networkResponse).getBody();
                    Date now = new Date();
                    List<RetroAchievementsUserIndependentGameRecordEntity> list = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(response, 10));
                    for (org.retroachivements.api.data.pojo.system.GetGameList.Response.Game game : response) {
                        RetroAchievementsUserIndependentGameRecordEntity entity = new RetroAchievementsUserIndependentGameRecordEntity(0L, null, null, null, null, null, null, 0, 0L, null, null, 2047, null);
                        entity.setUrl("https://retroachievements.org/game/" + game.getId());
                        String dateMod = game.getDateModified();
                        entity.setDateModified(dateMod != null ? UtilsKt.toRetroAchievementsDate(dateMod) : null);
                        entity.setAchievementsCount(game.getNumAchievements());
                        entity.setForumTopicId(Boxing.boxLong(game.getForumTopicId()));
                        entity.setConsoleName(game.getConsoleName());
                        entity.setConsoleId(Boxing.boxLong(game.getConsoleId()));
                        entity.setImageUrl(game.getImageIcon());
                        entity.setPoints(game.getPoints());
                        entity.setName(game.getTitle());
                        entity.setId(game.getId());
                        entity.setLastUpdatedTimestamp(now);
                        list.add(entity);
                    }
                    RetroAchievementsManager.this.getRetroAchievementsRepository().deleteRetroAchievementsUserIndependentGameRecordsByConsoleId(this.$consoleId);
                    RetroAchievementsManager.this.getRetroAchievementsRepository().addRetroAchievementsUserIndependentGameRecords(list.toArray(new RetroAchievementsUserIndependentGameRecordEntity[0]));
                    this.L$0 = null;
                    this.label = 4;
                    if (flowCollector.emit(list, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (networkResponse instanceof NetworkResponse.Error) {
                    NetworkResponse.Error error = (NetworkResponse.Error) networkResponse;
                    ErrorResponse errorResponse = (ErrorResponse) error.getBody();
                    Throwable error2 = error.getError();
                    if (errorResponse != null) {
                        throw new IOException(errorResponse.getMessage());
                    }
                    throw new IOException("There was an internal error fetching `getRetroAchievementsGameListByConsoleId` for `" + this.$consoleId + "`", error2);
                }
                BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(RetroAchievementsManager.this, this.$consoleId, null), this);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(RetroAchievementsManager.this, this.$consoleId, null), this);
                throw th;
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsGameListByConsoleId$1$1, reason: invalid class name and collision with other inner class name */
        /* INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsGameListByConsoleId$1$1", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
        final class C00641 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            int label;
            final /* synthetic */ RetroAchievementsManager this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00641(RetroAchievementsManager retroAchievementsManager, Continuation<?> continuation) {
                super(2, continuation);
                this.this$0 = retroAchievementsManager;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new C00641(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((C00641) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            }

            public final Object invokeSuspendImpl(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.refreshingConsoleIdsLiveData.setValue(this.this$0.refreshingConsoleIds);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsGameListByConsoleId$1$2, reason: invalid class name */
        /* INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsGameListByConsoleId$1$2", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
        final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            final /* synthetic */ long $consoleId;
            int label;
            final /* synthetic */ RetroAchievementsManager this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(RetroAchievementsManager retroAchievementsManager, long j, Continuation<?> continuation) {
                super(2, continuation);
                this.this$0 = retroAchievementsManager;
                this.$consoleId = j;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$consoleId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            }

            public final Object invokeSuspendImpl(Object obj) throws Throwable {
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

    public final Flow<List<RetroAchievementsUserIndependentGameRecordEntity>> getRetroAchievementsGameListByConsoleId(long consoleId) {
        return FlowKt.flow((kotlin.jvm.functions.Function2) new C02681(consoleId, null));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1", f = "RetroAchievementsManager.kt", i = {1, 1, 2}, l = {359, 372, 377, 457, 475, 475}, m = "invokeSuspendImpl", n = {"$this$flow", "retroInterface", "$this$flow"}, s = {"L$0", "L$1", "L$0"})
    final class C02691 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<FlowCollector<? super RetroAchievementsGameRecordEntity>, Continuation<?>, Object> {
        final /* synthetic */ long $gameId;
        final /* synthetic */ String $username;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02691(String str, long j, Continuation<?> continuation) {
            super(2, continuation);
            this.$username = str;
            this.$gameId = j;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            C02691 c02691 = RetroAchievementsManager.this.new C02691(this.$username, this.$gameId, continuation);
            c02691.L$0 = obj;
            return c02691;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super RetroAchievementsGameRecordEntity> flowCollector, Continuation<?> continuation) {
            try {
                return ((C02691) create(flowCollector, continuation)).invokeSuspendImpl(Unit.INSTANCE);
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        /* WARN: Code duplicated, block: B:101:0x03fb A[RETURN] */
        /* WARN: Code duplicated, block: B:106:0x0223 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* WARN: Code duplicated, block: B:110:0x0329 A[SYNTHETIC] */
        /* WARN: Code duplicated, block: B:41:0x00e5  */
        /* WARN: Code duplicated, block: B:42:0x00e7 A[Catch: all -> 0x0031, PHI: r5 r8
  0x00e7: PHI (r5v10 kotlinx.coroutines.flow.FlowCollector) = (r5v6 kotlinx.coroutines.flow.FlowCollector), (r5v14 kotlinx.coroutines.flow.FlowCollector) binds: [B:40:0x00e3, B:15:0x003b] A[DONT_GENERATE, DONT_INLINE]
  0x00e7: PHI (r8v10 java.lang.Object) = (r8v7 java.lang.Object), (r8v19 java.lang.Object) binds: [B:40:0x00e3, B:15:0x003b] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* WARN: Code duplicated, block: B:44:0x00ed A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* WARN: Code duplicated, block: B:46:0x0105 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* WARN: Code duplicated, block: B:49:0x0167 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* WARN: Code duplicated, block: B:50:0x016c  */
        /* WARN: Code duplicated, block: B:53:0x01e3 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* WARN: Code duplicated, block: B:54:0x01ec A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* WARN: Code duplicated, block: B:60:0x02e4 A[Catch: all -> 0x0397, TryCatch #1 {all -> 0x0397, blocks: (B:58:0x0223, B:60:0x02e4, B:62:0x02ea, B:64:0x02f0, B:66:0x02fb, B:68:0x0301, B:70:0x0307, B:72:0x030d, B:74:0x031b, B:76:0x0321, B:77:0x0329, B:73:0x0317, B:65:0x02f7, B:78:0x0334, B:80:0x033f, B:81:0x0358), top: B:106:0x0223 }] */
        /* WARN: Code duplicated, block: B:62:0x02ea A[Catch: all -> 0x0397, TryCatch #1 {all -> 0x0397, blocks: (B:58:0x0223, B:60:0x02e4, B:62:0x02ea, B:64:0x02f0, B:66:0x02fb, B:68:0x0301, B:70:0x0307, B:72:0x030d, B:74:0x031b, B:76:0x0321, B:77:0x0329, B:73:0x0317, B:65:0x02f7, B:78:0x0334, B:80:0x033f, B:81:0x0358), top: B:106:0x0223 }] */
        /* WARN: Code duplicated, block: B:63:0x02ef  */
        /* WARN: Code duplicated, block: B:65:0x02f7 A[Catch: all -> 0x0397, TryCatch #1 {all -> 0x0397, blocks: (B:58:0x0223, B:60:0x02e4, B:62:0x02ea, B:64:0x02f0, B:66:0x02fb, B:68:0x0301, B:70:0x0307, B:72:0x030d, B:74:0x031b, B:76:0x0321, B:77:0x0329, B:73:0x0317, B:65:0x02f7, B:78:0x0334, B:80:0x033f, B:81:0x0358), top: B:106:0x0223 }] */
        /* WARN: Code duplicated, block: B:68:0x0301 A[Catch: all -> 0x0397, TryCatch #1 {all -> 0x0397, blocks: (B:58:0x0223, B:60:0x02e4, B:62:0x02ea, B:64:0x02f0, B:66:0x02fb, B:68:0x0301, B:70:0x0307, B:72:0x030d, B:74:0x031b, B:76:0x0321, B:77:0x0329, B:73:0x0317, B:65:0x02f7, B:78:0x0334, B:80:0x033f, B:81:0x0358), top: B:106:0x0223 }] */
        /* WARN: Code duplicated, block: B:70:0x0307 A[Catch: all -> 0x0397, TryCatch #1 {all -> 0x0397, blocks: (B:58:0x0223, B:60:0x02e4, B:62:0x02ea, B:64:0x02f0, B:66:0x02fb, B:68:0x0301, B:70:0x0307, B:72:0x030d, B:74:0x031b, B:76:0x0321, B:77:0x0329, B:73:0x0317, B:65:0x02f7, B:78:0x0334, B:80:0x033f, B:81:0x0358), top: B:106:0x0223 }] */
        /* WARN: Code duplicated, block: B:71:0x030c  */
        /* WARN: Code duplicated, block: B:73:0x0317 A[Catch: all -> 0x0397, TryCatch #1 {all -> 0x0397, blocks: (B:58:0x0223, B:60:0x02e4, B:62:0x02ea, B:64:0x02f0, B:66:0x02fb, B:68:0x0301, B:70:0x0307, B:72:0x030d, B:74:0x031b, B:76:0x0321, B:77:0x0329, B:73:0x0317, B:65:0x02f7, B:78:0x0334, B:80:0x033f, B:81:0x0358), top: B:106:0x0223 }] */
        /* WARN: Code duplicated, block: B:76:0x0321 A[Catch: all -> 0x0397, TryCatch #1 {all -> 0x0397, blocks: (B:58:0x0223, B:60:0x02e4, B:62:0x02ea, B:64:0x02f0, B:66:0x02fb, B:68:0x0301, B:70:0x0307, B:72:0x030d, B:74:0x031b, B:76:0x0321, B:77:0x0329, B:73:0x0317, B:65:0x02f7, B:78:0x0334, B:80:0x033f, B:81:0x0358), top: B:106:0x0223 }] */
        /* WARN: Code duplicated, block: B:80:0x033f A[Catch: all -> 0x0397, TryCatch #1 {all -> 0x0397, blocks: (B:58:0x0223, B:60:0x02e4, B:62:0x02ea, B:64:0x02f0, B:66:0x02fb, B:68:0x0301, B:70:0x0307, B:72:0x030d, B:74:0x031b, B:76:0x0321, B:77:0x0329, B:73:0x0317, B:65:0x02f7, B:78:0x0334, B:80:0x033f, B:81:0x0358), top: B:106:0x0223 }] */
        /* WARN: Code duplicated, block: B:85:0x0371  */
        /* WARN: Code duplicated, block: B:86:0x0373 A[Catch: all -> 0x0031, PHI: r1
  0x0373: PHI (r1v11 com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1) = 
  (r1v2 com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1)
  (r1v0 com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1)
 binds: [B:84:0x036f, B:9:0x002c] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* WARN: Code duplicated, block: B:90:0x0396 A[RETURN] */
        /* WARN: Code duplicated, block: B:93:0x039b A[Catch: all -> 0x0031, TRY_ENTER, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* WARN: Code duplicated, block: B:95:0x03b4 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* WARN: Code duplicated, block: B:97:0x03be A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:86:0x0373, B:14:0x0038, B:42:0x00e7, B:44:0x00ed, B:46:0x0105, B:47:0x0139, B:49:0x0167, B:51:0x016d, B:53:0x01e3, B:55:0x01f0, B:56:0x021d, B:83:0x0366, B:54:0x01ec, B:93:0x039b, B:95:0x03b4, B:96:0x03bd, B:97:0x03be, B:98:0x03d8, B:17:0x0047, B:39:0x00cc, B:35:0x00aa), top: B:105:0x0010 }] */
        /* WARN: Code restructure failed: missing block: B:27:0x0089, code lost:
        
            if (r5.emit(r8, r1) == r4) goto L101;
         */

        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                RetroAchievementsGameRecordEntity record = RetroAchievementsManager.this.getRetroAchievementsRepository().getRetroAchievementsGameRecordByUserIdAndGameIdStatically(this.$username, this.$gameId);
                if (record != null) {
                    Date lastUpdated = record.getLastUpdatedTimestamp();
                    Long lastUpdatedTime = lastUpdated != null ? Boxing.boxLong(lastUpdated.getTime()) : null;
                    if (lastUpdatedTime != null && lastUpdatedTime.longValue() + 480000L > System.currentTimeMillis()) {
                        this.label = 1;
                        if (flowCollector.emit(record, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                }
                RetroInterface retro = RetroAchievementsManager.this.getRetroAchievementsInterface();
                if (retro == null || !RetroAchievementsManager.this.refreshingGameIds.add(Boxing.boxLong(this.$gameId))) {
                    return Unit.INSTANCE;
                }
                try {
                    this.L$0 = flowCollector;
                    this.L$1 = retro;
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C00651(RetroAchievementsManager.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.L$0 = flowCollector;
                    this.L$1 = null;
                    this.label = 3;
                    obj = retro.getGameInfoAndUserProgress(this.$username, this.$gameId, 0, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Throwable th) {
                    BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(RetroAchievementsManager.this, this.$gameId, null), this);
                    throw th;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else if (i == 2) {
                RetroInterface retro = (RetroInterface) this.L$1;
                flowCollector = (FlowCollector) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = flowCollector;
                    this.L$1 = null;
                    this.label = 3;
                    obj = retro.getGameInfoAndUserProgress(this.$username, this.$gameId, 0, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Throwable th) {
                    BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(RetroAchievementsManager.this, this.$gameId, null), this);
                    throw th;
                }
            } else if (i == 3) {
                flowCollector = (FlowCollector) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th) {
                    BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(RetroAchievementsManager.this, this.$gameId, null), this);
                    throw th;
                }
            } else if (i == 4) {
                try {
                    ResultKt.throwOnFailure(obj);
                    BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(RetroAchievementsManager.this, this.$gameId, null), this);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(RetroAchievementsManager.this, this.$gameId, null), this);
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                Object responseResult = obj;
                NetworkResponse networkResponse = (NetworkResponse) responseResult;
                RetroAchievementsGameRecordEntity record = RetroAchievementsManager.this.getRetroAchievementsRepository().getRetroAchievementsGameRecordByUserIdAndGameIdStatically(this.$username, this.$gameId);
                if (record == null) {
                    record = new RetroAchievementsGameRecordEntity(0L, this.$username, this.$gameId, null, null, null, null, null, null, null, null, 0, 0, 0L, 0L, 0L, null, null, 0, 0, null, 2097145, null);
                }
                if (networkResponse instanceof NetworkResponse.Success) {
                    org.retroachivements.api.data.pojo.game.GetGameInfoAndUserProgress.Response response = (org.retroachivements.api.data.pojo.game.GetGameInfoAndUserProgress.Response) ((NetworkResponse.Success) networkResponse).getBody();
                    record.setImageUrl("https://retroachievements.org" + response.getImageIcon());
                    record.setUrl("https://retroachievements.org/game/" + response.getId());
                    record.setDistinctPlayerCount(response.getNumDistinctPlayers());
                    record.setAchievementsCount(response.getNumAchievements());
                    record.setTotalPlayerCount(response.getPlayersTotal());
                    record.setConsoleId(Boxing.boxLong(response.getConsoleId()));
                    record.setForumTopicId(Boxing.boxInt(response.getForumTopicId()));
                    record.setConsoleName(response.getConsoleName());
                    record.setGameId(response.getId());
                    record.setGuideUrl(response.getGuideUrl());
                    record.setName(response.getTitle());
                    record.setUnlockedAchievementsCount(0);
                    record.setLastUpdatedTimestamp(new Date());

                    if (record.getId() == 0) {
                        long id = RetroAchievementsManager.this.getRetroAchievementsRepository().addRetroAchievementsGameRecord(record);
                        record.setId(id);
                    }

                    Map<String, org.retroachivements.api.data.pojo.game.GetGameInfoAndUserProgress.Response.Achievement> achievementsMap = response.getAchievements();
                    if (achievementsMap != null) {
                        List<org.retroachivements.api.data.pojo.game.GetGameInfoAndUserProgress.Response.Achievement> sortedAchievements = CollectionsKt.sortedWith(achievementsMap.values(), new RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1$invokeSuspend$lambda$3$$inlined$sortedBy$1());
                        List<RetroAchievementsAchievementRecordEntity> achievementEntities = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(sortedAchievements, 10));
                        for (org.retroachivements.api.data.pojo.game.GetGameInfoAndUserProgress.Response.Achievement ach : sortedAchievements) {
                            long achId = Long.parseLong(ach.getId());
                            RetroAchievementsAchievementRecordEntity entity = new RetroAchievementsAchievementRecordEntity(0L, achId, 0L, null, null, 0, null, null, null, null, 0.0f, 0, 0L, 0L, false, false, null, 131049, null);
                            entity.setImageUrl("https://media.retroachievements.org/Badge/" + ach.getBadgeName() + ".png");
                            entity.setUrl("https://retroachievements.org/achievement/" + ach.getId());
                            entity.setUnlockedHardcorePlayerCount(ach.getNumAwardedHardcore());
                            entity.setUnlockedPlayerCount(ach.getNumAwarded());
                            entity.setDescription(ach.getDescription());
                            entity.setPoints((int) ach.getPoints());
                            entity.setName(ach.getTitle());
                            entity.setUserId(this.$username);
                            entity.setGameId(Boxing.boxLong(this.$gameId));
                            if (ach.getDateEarned() != null) {
                                entity.setUnlockedTimestamp(UtilsKt.toRetroAchievementsDate(ach.getDateEarned()));
                                entity.setUnlocked(true);
                            } else {
                                entity.setUnlocked(false);
                            }
                            if (ach.getDateEarnedHardcore() != null) {
                                entity.setUnlockedTimestamp(UtilsKt.toRetroAchievementsDate(ach.getDateEarnedHardcore()));
                                entity.setHardcoreUnlocked(true);
                                entity.setUnlocked(true);
                            } else {
                                entity.setHardcoreUnlocked(false);
                            }
                            if (entity.isUnlocked()) {
                                record.setUnlockedAchievementsCount(record.getUnlockedAchievementsCount() + 1);
                            }
                            achievementEntities.add(entity);
                        }
                        if (!achievementEntities.isEmpty()) {
                            RetroAchievementsManager.this.getRetroAchievementsRepository().addRetroAchievementsAchievementRecords(achievementEntities.toArray(new RetroAchievementsAchievementRecordEntity[0]));
                        }
                    }
                    RetroAchievementsManager.this.getRetroAchievementsRepository().updateRetroAchievementsGameRecord(record);
                } else if (networkResponse instanceof NetworkResponse.Error) {
                    NetworkResponse.Error error = (NetworkResponse.Error) networkResponse;
                    ErrorResponse errorResponse = (ErrorResponse) error.getBody();
                    Throwable error2 = error.getError();
                    if (errorResponse != null) {
                        throw new IOException(errorResponse.getMessage());
                    }
                    throw new IOException("There was an internal error fetching `getRetroAchievementsGameRecordByGameId` for `" + this.$gameId + "`", error2);
                }
                this.L$0 = null;
                this.label = 4;
                if (flowCollector.emit(record, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(RetroAchievementsManager.this, this.$gameId, null), this);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(RetroAchievementsManager.this, this.$gameId, null), this);
                throw th;
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1$1, reason: invalid class name and collision with other inner class name */
        /* INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1$1", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
        final class C00651 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            int label;
            final /* synthetic */ RetroAchievementsManager this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00651(RetroAchievementsManager retroAchievementsManager, Continuation<?> continuation) {
                super(2, continuation);
                this.this$0 = retroAchievementsManager;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new C00651(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((C00651) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            }

            public final Object invokeSuspendImpl(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.refreshingGameIdsLiveData.setValue(this.this$0.refreshingGameIds);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1$3, reason: invalid class name */
        /* INFO: compiled from: RetroAchievementsManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1$3", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
        final class AnonymousClass3 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            final /* synthetic */ long $gameId;
            int label;
            final /* synthetic */ RetroAchievementsManager this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(RetroAchievementsManager retroAchievementsManager, long j, Continuation<?> continuation) {
                super(2, continuation);
                this.this$0 = retroAchievementsManager;
                this.$gameId = j;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, this.$gameId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            }

            public final Object invokeSuspendImpl(Object obj) throws Throwable {
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

    public final Flow<RetroAchievementsGameRecordEntity> getRetroAchievementsGameRecordByGameId(String username, long gameId) {
        Intrinsics.checkNotNullParameter(username, "username");
        return FlowKt.flow(new C02691(username, gameId, null));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsUserProgressGames$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00050\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Ljava/util/HashSet;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lkotlin/collections/HashSet;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsUserProgressGames$1", f = "RetroAchievementsManager.kt", i = {0}, l = {492}, m = "invokeSuspendImpl", n = {"gameRecordsToBeUpdated"}, s = {"L$0"})
    static final class C02711 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>>, Continuation<?>, Object> {
        final /* synthetic */ RetroInterface $retroInterface;
        final /* synthetic */ String $username;
        Object L$0;
        int label;
        final /* synthetic */ RetroAchievementsManager this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02711(RetroInterface retroInterface, String str, RetroAchievementsManager retroAchievementsManager, Continuation<?> continuation) {
            super(2, continuation);
            this.$retroInterface = retroInterface;
            this.$username = str;
            this.this$0 = retroAchievementsManager;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new C02711(this.$retroInterface, this.$username, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>> flowCollector, Continuation<?> continuation) {
            try {
                return ((C02711) create(flowCollector, continuation)).invokeSuspendImpl(Unit.INSTANCE);
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            Object userCompletionProgress$default;
            HashSet hashSet;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashSet hashSet2 = new HashSet();
                this.L$0 = hashSet2;
                this.label = 1;
                userCompletionProgress$default = RetroInterface.DefaultImpls.getUserCompletionProgress$default(this.$retroInterface, this.$username, 128, 0, this, 4, null);
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
                List<GetUserCompletionProgress.Progress> listSortedWith = CollectionsKt.sortedWith(((GetUserCompletionProgress.Response) ((NetworkResponse.Success) networkResponse).getBody()).getResults(), new RetroAchievementsManager$getRetroAchievementsUserProgressGames$1$invokeSuspendImpl$$inlined$sortedByDescending$1());
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

    /* INFO: Access modifiers changed from: private */
    public final Flow<HashSet<RetroAchievementsGameRecordEntity>> getRetroAchievementsUserProgressGames(RetroInterface retroInterface, String username) {
        return FlowKt.flow(new C02711(retroInterface, username, this, null));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsUserRecentGames$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00050\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Ljava/util/HashSet;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsGameRecordEntity;", "Lkotlin/collections/HashSet;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsUserRecentGames$1", f = "RetroAchievementsManager.kt", i = {0, 0}, l = {555, 595}, m = "invokeSuspendImpl", n = {"$this$flow", "gameRecordsToBeUpdated"}, s = {"L$0", "L$1"})
    static final class C02721 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>>, Continuation<?>, Object> {
        final /* synthetic */ RetroInterface $retroInterface;
        final /* synthetic */ String $username;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ RetroAchievementsManager this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02721(RetroInterface retroInterface, String str, RetroAchievementsManager retroAchievementsManager, Continuation<?> continuation) {
            super(2, continuation);
            this.$retroInterface = retroInterface;
            this.$username = str;
            this.this$0 = retroAchievementsManager;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            C02721 c02721 = new C02721(this.$retroInterface, this.$username, this.this$0, continuation);
            c02721.L$0 = obj;
            return c02721;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super HashSet<RetroAchievementsGameRecordEntity>> flowCollector, Continuation<?> continuation) {
            try {
                return ((C02721) create(flowCollector, continuation)).invokeSuspendImpl(Unit.INSTANCE);
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        /* WARN: Code restructure failed: missing block: B:32:0x014a, code lost:
        
            if (r5.emit(r2, r39) == r1) goto L33;
         */

        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            FlowCollector flowCollector;
            HashSet<RetroAchievementsGameRecordEntity> hashSet;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                hashSet = new HashSet<>();
                this.L$0 = flowCollector;
                this.L$1 = hashSet;
                this.label = 1;
                obj = RetroInterface.DefaultImpls.getUserRecentlyPlayedGames$default(this.$retroInterface, this.$username, 20, 0, this, 4, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                hashSet = (HashSet) this.L$1;
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            NetworkResponse networkResponse = (NetworkResponse) obj;
            if (networkResponse instanceof NetworkResponse.Success) {
                org.retroachivements.api.data.pojo.user.GetUserRecentlyPlayedGames.Response response = (org.retroachivements.api.data.pojo.user.GetUserRecentlyPlayedGames.Response) ((NetworkResponse.Success) networkResponse).getBody();
                RetroAchievementsManager retroAchievementsManager = this.this$0;
                String str = this.$username;
                for (org.retroachivements.api.data.pojo.user.GetUserRecentlyPlayedGames.Response.Game game : response) {
                    RetroAchievementsGameRecordEntity record = retroAchievementsManager.getRetroAchievementsRepository().getRetroAchievementsGameRecordByUserIdAndGameIdStatically(str, game.getGameId());
                    if (record == null) {
                        record = new RetroAchievementsGameRecordEntity(0L, str, game.getGameId(), null, null, null, null, null, null, null, null, 0, 0, 0L, 0L, 0L, null, null, 0, 0, null, 2097145, null);
                    }
                    record.setName(game.getTitle());
                    record.setImageUrl(RetroAchievementsConfiguration.BASE_URL + game.getImageIcon());
                    record.setConsoleId(Boxing.boxLong(game.getConsoleId()));
                    record.setConsoleName(game.getConsoleName());
                    record.setAchievementsCount((int) game.getAchievementsTotal());
                    record.setUnlockedAchievementsCount((int) game.getNumAchievedHardcore());
                    hashSet.add(record);
                }
            } else if (networkResponse instanceof NetworkResponse.Error) {
                NetworkResponse.Error error = (NetworkResponse.Error) networkResponse;
                ErrorResponse errorResponse = (ErrorResponse) error.getBody();
                Throwable error2 = error.getError();
                if (errorResponse != null) {
                    throw new IOException(errorResponse.getMessage());
                }
                throw new IOException("There was an internal error fetching the user's recent games for `" + this.$username + "`", error2);
            }
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (flowCollector.emit(hashSet, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* INFO: Access modifiers changed from: private */
    public final Flow<HashSet<RetroAchievementsGameRecordEntity>> getRetroAchievementsUserRecentGames(RetroInterface retroInterface, String username) {
        return FlowKt.flow(new C02721(retroInterface, username, this, null));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsUserProfile$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileEntity;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsUserProfile$1", f = "RetroAchievementsManager.kt", i = {1}, l = {TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 615, 656}, m = "invokeSuspendImpl", n = {"$this$flow"}, s = {"L$0"})
    final class C02701 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<FlowCollector<? super RetroAchievementsUserProfileEntity>, Continuation<?>, Object> {
        final /* synthetic */ RetroInterface $retroInterface;
        final /* synthetic */ String $username;
        private /* synthetic */ Object L$0;
        int label;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02701(String str, RetroInterface retroInterface, Continuation<?> continuation) {
            super(2, continuation);
            this.$username = str;
            this.$retroInterface = retroInterface;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            C02701 c02701 = RetroAchievementsManager.this.new C02701(this.$username, this.$retroInterface, continuation);
            c02701.L$0 = obj;
            return c02701;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super RetroAchievementsUserProfileEntity> flowCollector, Continuation<?> continuation) {
            try {
                return ((C02701) create(flowCollector, continuation)).invokeSuspendImpl(Unit.INSTANCE);
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        /* WARN: Code duplicated, block: B:26:0x0077  */
        /* WARN: Code duplicated, block: B:29:0x008a A[PHI: r2 r5
  0x008a: PHI (r2v4 kotlinx.coroutines.flow.FlowCollector) = (r2v2 kotlinx.coroutines.flow.FlowCollector), (r2v9 kotlinx.coroutines.flow.FlowCollector) binds: [B:27:0x0086, B:10:0x0021] A[DONT_GENERATE, DONT_INLINE]
  0x008a: PHI (r5v2 java.lang.Object) = (r5v1 java.lang.Object), (r5v10 java.lang.Object) binds: [B:27:0x0086, B:10:0x0021] A[DONT_GENERATE, DONT_INLINE]] */
        /* WARN: Code duplicated, block: B:31:0x009a  */
        /* WARN: Code duplicated, block: B:34:0x00c7  */
        /* WARN: Code duplicated, block: B:37:0x0106  */
        /* WARN: Code duplicated, block: B:39:0x0114  */
        /* WARN: Code duplicated, block: B:41:0x011e  */
        /* WARN: Code duplicated, block: B:43:0x013b  */
        /* WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
        
            if (r2.emit(r7, r22) == r1) goto L45;
         */
        /* WARN: Code restructure failed: missing block: B:44:0x0157, code lost:
        
            if (r2.emit(r6, r22) == r1) goto L45;
         */

        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                RetroAchievementsUserProfileEntity profile = RetroAchievementsManager.this.getRetroAchievementsRepository().getRetroAchievementsUserProfileByIdStatically(this.$username);
                if (profile != null) {
                    Date lastUpdatedTimestamp = profile.getLastUpdatedTimestamp();
                    Long lastUpdated = lastUpdatedTimestamp != null ? Boxing.boxLong(lastUpdatedTimestamp.getTime()) : null;
                    if (lastUpdated != null && lastUpdated.longValue() + 480000L > System.currentTimeMillis()) {
                        this.label = 1;
                        if (flowCollector.emit(profile, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                }
                this.L$0 = flowCollector;
                this.label = 2;
                obj = this.$retroInterface.getUserProfile(this.$username, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else if (i == 2) {
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else if (i == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            NetworkResponse networkResponse = (NetworkResponse) obj;
            RetroAchievementsUserProfileEntity profile = RetroAchievementsManager.this.getRetroAchievementsRepository().getRetroAchievementsUserProfileByIdStatically(this.$username);
            if (profile == null) {
                profile = new RetroAchievementsUserProfileEntity(this.$username, "https://retroachievements.org/user/" + this.$username, null, 0, 0, null, null, null, 0.0f, null, null, null, 4092, null);
            }
            if (networkResponse instanceof NetworkResponse.Success) {
                org.retroachivements.api.data.pojo.user.GetUserProfile.Response response = (org.retroachivements.api.data.pojo.user.GetUserProfile.Response) ((NetworkResponse.Success) networkResponse).getBody();
                profile.setImageUrl("https://retroachievements.org" + response.getUserPic());
                profile.setRichPresenceMsg(response.getRichPresenceMsg());
                profile.setMotto(response.getMotto());
                profile.setHardcorePoints(response.getTotalPoints());
                profile.setSoftcorePoints(response.getTotalSoftcorePoints());
            } else if (networkResponse instanceof NetworkResponse.Error) {
                NetworkResponse.Error error = (NetworkResponse.Error) networkResponse;
                ErrorResponse errorResponse = (ErrorResponse) error.getBody();
                Throwable error2 = error.getError();
                if (errorResponse != null) {
                    throw new IOException(errorResponse.getMessage());
                }
                throw new IOException("There was an internal error fetching the user's profile for `" + this.$username + "`", error2);
            }
            profile.setLastUpdatedTimestamp(new Date());
            RetroAchievementsManager.this.getRetroAchievementsRepository().addRetroAchievementsUserProfile(profile);
            this.L$0 = null;
            this.label = 3;
            if (flowCollector.emit(profile, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    private final Flow<RetroAchievementsUserProfileEntity> getRetroAchievementsUserProfile(RetroInterface retroInterface, String username) {
        return FlowKt.flow(new C02701(username, retroInterface, null));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsAwardsByUserId$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserAwardEntity;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsAwardsByUserId$1", f = "RetroAchievementsManager.kt", i = {2}, l = {669, 677, 684, 721}, m = "invokeSuspendImpl", n = {"$this$flow"}, s = {"L$0"})
    final class C02661 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<FlowCollector<? super List<? extends RetroAchievementsUserAwardEntity>>, Continuation<?>, Object> {
        final /* synthetic */ String $username;
        private /* synthetic */ Object L$0;
        int label;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02661(String str, Continuation<?> continuation) {
            super(2, continuation);
            this.$username = str;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            C02661 c02661 = RetroAchievementsManager.this.new C02661(this.$username, continuation);
            c02661.L$0 = obj;
            return c02661;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends RetroAchievementsUserAwardEntity>> flowCollector, Continuation<?> continuation) {
            return invoke2((FlowCollector<? super List<RetroAchievementsUserAwardEntity>>) flowCollector, continuation);
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super List<RetroAchievementsUserAwardEntity>> flowCollector, Continuation<?> continuation) {
            try {
                return ((C02661) create(flowCollector, continuation)).invokeSuspendImpl(Unit.INSTANCE);
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        /* WARN: Code duplicated, block: B:35:0x0093  */
        /* WARN: Code duplicated, block: B:45:0x00c2 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:8:0x0018, B:52:0x01ce, B:15:0x002c, B:43:0x00bc, B:45:0x00c2, B:46:0x00e8, B:48:0x00ee, B:49:0x0195, B:55:0x01dc, B:57:0x01ef, B:58:0x01f8, B:59:0x01f9, B:60:0x0204, B:40:0x00ab), top: B:68:0x000e }] */
        /* WARN: Code duplicated, block: B:48:0x00ee A[Catch: all -> 0x001d, LOOP:0: B:46:0x00e8->B:48:0x00ee, LOOP_END, TryCatch #0 {all -> 0x001d, blocks: (B:8:0x0018, B:52:0x01ce, B:15:0x002c, B:43:0x00bc, B:45:0x00c2, B:46:0x00e8, B:48:0x00ee, B:49:0x0195, B:55:0x01dc, B:57:0x01ef, B:58:0x01f8, B:59:0x01f9, B:60:0x0204, B:40:0x00ab), top: B:68:0x000e }] */
        /* WARN: Code duplicated, block: B:51:0x01cd  */
        /* WARN: Code duplicated, block: B:55:0x01dc A[Catch: all -> 0x001d, TRY_ENTER, TryCatch #0 {all -> 0x001d, blocks: (B:8:0x0018, B:52:0x01ce, B:15:0x002c, B:43:0x00bc, B:45:0x00c2, B:46:0x00e8, B:48:0x00ee, B:49:0x0195, B:55:0x01dc, B:57:0x01ef, B:58:0x01f8, B:59:0x01f9, B:60:0x0204, B:40:0x00ab), top: B:68:0x000e }] */
        /* WARN: Code duplicated, block: B:57:0x01ef A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:8:0x0018, B:52:0x01ce, B:15:0x002c, B:43:0x00bc, B:45:0x00c2, B:46:0x00e8, B:48:0x00ee, B:49:0x0195, B:55:0x01dc, B:57:0x01ef, B:58:0x01f8, B:59:0x01f9, B:60:0x0204, B:40:0x00ab), top: B:68:0x000e }] */
        /* WARN: Code duplicated, block: B:59:0x01f9 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:8:0x0018, B:52:0x01ce, B:15:0x002c, B:43:0x00bc, B:45:0x00c2, B:46:0x00e8, B:48:0x00ee, B:49:0x0195, B:55:0x01dc, B:57:0x01ef, B:58:0x01f8, B:59:0x01f9, B:60:0x0204, B:40:0x00ab), top: B:68:0x000e }] */
        /* WARN: Code duplicated, block: B:63:0x0211  */
        /* WARN: Code restructure failed: missing block: B:31:0x008c, code lost:
        
            if (r2.emit(r9, r28) == r0) goto L65;
         */
        /* WARN: Code restructure failed: missing block: B:64:0x021e, code lost:
        
            if (r2.emit(kotlin.collections.CollectionsKt.emptyList(), r28) == r0) goto L65;
         */

        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                List<RetroAchievementsUserAwardEntity> existingAwards = RetroAchievementsManager.this.getRetroAchievementsRepository().getRetroAchievementsUserAwardsByUserIdStatically(this.$username);
                if (existingAwards != null && !existingAwards.isEmpty()) {
                    RetroAchievementsUserAwardEntity first = (RetroAchievementsUserAwardEntity) CollectionsKt.getOrNull(existingAwards, 0);
                    Date lastUpdated = first != null ? first.getLastUpdatedTimestamp() : null;
                    Long lastUpdatedTime = lastUpdated != null ? Boxing.boxLong(lastUpdated.getTime()) : null;
                    if (lastUpdatedTime != null && lastUpdatedTime.longValue() + 480000L > System.currentTimeMillis()) {
                        this.label = 1;
                        if (flowCollector.emit(existingAwards, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                }
                RetroInterface retro = RetroAchievementsManager.this.getRetroAchievementsInterface();
                if (retro == null || !RetroAchievementsManager.this.refreshingAwards.add(this.$username)) {
                    return Unit.INSTANCE;
                }
                try {
                    this.L$0 = flowCollector;
                    this.label = 3;
                    obj = retro.getUserAwards(this.$username, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Throwable th) {
                    RetroAchievementsManager.this.refreshingAwards.remove(this.$username);
                    throw th;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else if (i == 3) {
                flowCollector = (FlowCollector) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th) {
                    RetroAchievementsManager.this.refreshingAwards.remove(this.$username);
                    throw th;
                }
            } else if (i == 4) {
                try {
                    ResultKt.throwOnFailure(obj);
                    RetroAchievementsManager.this.refreshingAwards.remove(this.$username);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    RetroAchievementsManager.this.refreshingAwards.remove(this.$username);
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                Object responseResult = obj;
                NetworkResponse networkResponse = (NetworkResponse) responseResult;
                if (networkResponse instanceof NetworkResponse.Success) {
                    org.retroachivements.api.data.pojo.user.GetUserAwards.Response response = (org.retroachivements.api.data.pojo.user.GetUserAwards.Response) ((NetworkResponse.Success) networkResponse).getBody();
                    Date now = new Date();
                    ArrayList<org.retroachivements.api.data.pojo.user.GetUserAwards.Response.Award> awards = response.getVisibleUserAwards();
                    List<RetroAchievementsUserAwardEntity> entityList = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(awards, 10));
                    for (org.retroachivements.api.data.pojo.user.GetUserAwards.Response.Award award : awards) {
                        RetroAchievementsUserAwardEntity entity = new RetroAchievementsUserAwardEntity(0L, this.$username, award.getAwardType(), award.getAwardData(), null, null, 0, null, null, null, null, null, null, 8177, null);
                        entity.setImageUrl("https://retroachievements.org" + award.getImageIcon());
                        entity.setAwardedAt(UtilsKt.toRetroAchievementsDate(award.getAwardedAt()));
                        entity.setAwardDataExtra(Boxing.boxInt(award.getAwardDataExtra()));
                        entity.setDisplayOrder(award.getDisplayOrder());
                        entity.setConsoleName(award.getConsoleName());
                        entity.setConsoleId(Boxing.boxLong(award.getConsoleId()));
                        entity.setTitle(award.getTitle());
                        entity.setFlags(Boxing.boxInt(award.getFlags()));
                        entity.setLastUpdatedTimestamp(now);
                        entityList.add(entity);
                    }
                    RetroAchievementsManager.this.getRetroAchievementsRepository().deleteRetroAchievementsUserAwardByUserId(this.$username);
                    RetroAchievementsManager.this.getRetroAchievementsRepository().addRetroAchievementsUserAwards(entityList.toArray(new RetroAchievementsUserAwardEntity[0]));
                    this.L$0 = null;
                    this.label = 4;
                    if (flowCollector.emit(entityList, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (networkResponse instanceof NetworkResponse.Error) {
                    NetworkResponse.Error error = (NetworkResponse.Error) networkResponse;
                    ErrorResponse errorResponse = (ErrorResponse) error.getBody();
                    Throwable error2 = error.getError();
                    if (errorResponse != null) {
                        throw new IOException(errorResponse.getMessage());
                    }
                    throw new IOException(error2);
                }
                RetroAchievementsManager.this.refreshingAwards.remove(this.$username);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                RetroAchievementsManager.this.refreshingAwards.remove(this.$username);
                throw th;
            }
        }
    }

    /* INFO: Access modifiers changed from: private */
    public final Flow<List<RetroAchievementsUserAwardEntity>> getRetroAchievementsAwardsByUserId(String username) {
        return FlowKt.flow((kotlin.jvm.functions.Function2) new C02661(username, null));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsConsoleIds$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "", "Lcom/magneticchen/daijishou/retro_achievements/RetroAchievementsConsole;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.v2.RetroAchievementsManager$getRetroAchievementsConsoleIds$1", f = "RetroAchievementsManager.kt", i = {1}, l = {Constants.semiBolderWeight, 759, 769}, m = "invokeSuspendImpl", n = {"$this$flow"}, s = {"L$0"})
    final class C02671 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<FlowCollector<? super Map<Long, ? extends RetroAchievementsConsole>>, Continuation<?>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C02671(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            C02671 c02671 = RetroAchievementsManager.this.new C02671(continuation);
            c02671.L$0 = obj;
            return c02671;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Map<Long, ? extends RetroAchievementsConsole>> flowCollector, Continuation<?> continuation) {
            return invoke2((FlowCollector<? super Map<Long, RetroAchievementsConsole>>) flowCollector, continuation);
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Map<Long, RetroAchievementsConsole>> flowCollector, Continuation<?> continuation) {
            try {
                return ((C02671) create(flowCollector, continuation)).invokeSuspendImpl(Unit.INSTANCE);
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        /* WARN: Code duplicated, block: B:26:0x007a  */
        /* WARN: Code duplicated, block: B:29:0x00a9 A[LOOP:0: B:27:0x00a3->B:29:0x00a9, LOOP_END] */
        /* WARN: Code duplicated, block: B:35:0x00f9  */
        /* WARN: Code duplicated, block: B:37:0x0108  */
        /* WARN: Code duplicated, block: B:39:0x0112  */
        /* WARN: Code restructure failed: missing block: B:15:0x0052, code lost:
        
            if (r2.emit(r18.this$0.consoles, r18) == r1) goto L32;
         */
        /* WARN: Code restructure failed: missing block: B:31:0x00f3, code lost:
        
            if (r2.emit(r18.this$0.consoles, r18) == r1) goto L32;
         */

        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                if (!RetroAchievementsManager.this.consoles.isEmpty()) {
                    this.label = 1;
                    if (flowCollector.emit(RetroAchievementsManager.this.consoles, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                RetroInterface retro = RetroAchievementsManager.this.getRetroAchievementsInterface();
                if (retro == null) {
                    throw new IOException("Failed to retrieve the Retro Achievements interface.");
                }
                this.L$0 = flowCollector;
                this.label = 2;
                obj = RetroInterface.DefaultImpls.getConsoleIds$default(retro, 0, 0, this, 3, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else if (i == 2) {
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else if (i == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            NetworkResponse networkResponse = (NetworkResponse) obj;
            if (networkResponse instanceof NetworkResponse.Success) {
                Iterable<org.retroachivements.api.data.pojo.system.GetConsoleID.Response.Console> consolesIterable = (Iterable<org.retroachivements.api.data.pojo.system.GetConsoleID.Response.Console>) ((NetworkResponse.Success) networkResponse).getBody();
                Map<Long, RetroAchievementsConsole> map = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(consolesIterable, 10)), 16));
                for (org.retroachivements.api.data.pojo.system.GetConsoleID.Response.Console c : consolesIterable) {
                    map.put(Boxing.boxLong(c.getId()), new RetroAchievementsConsole(c.getId(), c.getName(), c.getIconUrl(), false, false));
                }
                RetroAchievementsManager.this.consoles.putAll(map);
                this.L$0 = null;
                this.label = 3;
                if (flowCollector.emit(RetroAchievementsManager.this.consoles, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            NetworkResponse.Error error = (NetworkResponse.Error) networkResponse;
            ErrorResponse errorResponse = (ErrorResponse) error.getBody();
            if (errorResponse != null) {
                throw new IOException(errorResponse.getMessage());
            }
            throw new IOException(error.getError());
        }
    }

    private final Flow<Map<Long, RetroAchievementsConsole>> getRetroAchievementsConsoleIds() {
        return FlowKt.flow((kotlin.jvm.functions.Function2) new C02671(null));
    }

    private final RetroCredentials getRetroAchievementsCredentials() {
        String string;
        String string2 = getRetroAchievementsSharedPreferences().getString("username", null);
        if (string2 == null || (string = getRetroAchievementsSharedPreferences().getString("web_api_key", null)) == null) {
            return null;
        }
        return new RetroCredentials(string2, string);
    }

    private final String getUsername() {
        return getRetroAchievementsSharedPreferences().getString("username", null);
    }

    /* INFO: Access modifiers changed from: private */
    public final RetroInterface getRetroAchievementsInterface() {
        RetroCredentials retroAchievementsCredentials = getRetroAchievementsCredentials();
        if (retroAchievementsCredentials != null) {
            return new RetroClient(retroAchievementsCredentials, false, 2, null).getApi();
        }
        return null;
    }

    /* INFO: Access modifiers changed from: private */
    public final String toGenericNameExtreme(String string) {
        List<String> groupValues;
        String str;
        MatchResult matchResultFind$default = Regex.find$default(RetroAchievementsConfiguration.INSTANCE.getGenericNameRegex(), string, 0, 2, null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null && (str = groupValues.get(1)) != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
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
