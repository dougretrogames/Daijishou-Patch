package com.magneticchen.daijishou.retro_achievements;

import android.content.SharedPreferences;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.MutableLiveData;
import com.haroldadmin.cnradapter.NetworkResponse;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.live_data.ConnectionLiveData;
import com.magneticchen.daijishou.live_data.PairLiveData;
import com.magneticchen.daijishou.live_data.SharedPreferenceStringLiveData;
import com.magneticchen.daijishou.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.repositories.RetroAchievementsRepository;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsAchievementRecordEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserAwardEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserIndependentGameRecordEntity;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.utils.UtilsKt;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.retroachivements.api.RetroInterface;
import org.retroachivements.api.data.RetroCredentials;
import org.retroachivements.api.data.pojo.ErrorResponse;
import org.retroachivements.api.data.pojo.game.GetGameInfoAndUserProgress;
import org.retroachivements.api.data.pojo.user.GetUserAwards;

/* JADX INFO: compiled from: RetroAchievementsManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 t2\u00020\u0001:\u0001tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010N\u001a\u0004\u0018\u00010\u00182\b\u0010O\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010PJ\u000e\u0010Q\u001a\u00020\u00182\u0006\u0010R\u001a\u00020\u000bJ\u0010\u0010S\u001a\u0004\u0018\u00010\u0018H\u0086@¢\u0006\u0002\u0010TJ\u0010\u0010U\u001a\u0004\u0018\u00010MH\u0086@¢\u0006\u0002\u0010TJ\u0006\u0010V\u001a\u00020\fJ\u0006\u0010W\u001a\u00020\fJ\u000e\u0010X\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010TJ\u0016\u0010Y\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010[J\u0016\u0010\\\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010[J\u0016\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0086@¢\u0006\u0002\u0010`J\u0016\u0010a\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0086@¢\u0006\u0002\u0010`J\u0016\u0010b\u001a\u00020\u001f2\u0006\u0010c\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010dJ\u0018\u0010e\u001a\u00020\f2\b\b\u0002\u0010f\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010gJ\u0016\u0010h\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010[J\u0016\u0010i\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010[J\u0016\u0010j\u001a\u00020\f2\u0006\u0010k\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010dJ\u0016\u0010l\u001a\u00020\f2\u0006\u0010k\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010dJ\u0006\u0010m\u001a\u00020\fJ\u0014\u0010n\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0/J\u0012\u0010o\u001a\u0004\u0018\u00010\u00182\u0006\u0010p\u001a\u00020\u0018H\u0002J\u0012\u0010q\u001a\u0004\u0018\u00010\u00182\u0006\u0010p\u001a\u00020\u0018H\u0002J\f\u0010r\u001a\u0004\u0018\u00010s*\u00020\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0012`\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0017X\u0082.¢\u0006\u0002\n\u0000R*\u0010\u0019\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001a\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00060&R\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0/0)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010+\"\u0004\b1\u00102R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R&\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0/0)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010+\"\u0004\b6\u00102R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R&\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180/0)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010+\"\u0004\b:\u00102R\u001a\u0010;\u001a\u00020<X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020BX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020HX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020HX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/magneticchen/daijishou/retro_achievements/RetroAchievementsManager;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "connectionLiveData", "Lcom/magneticchen/daijishou/live_data/ConnectionLiveData;", "connectionLiveDataObserver", "Lkotlin/Function1;", "", "", "consoleWatchlist", "", "", "consoles", "Ljava/util/HashMap;", "Lcom/magneticchen/daijishou/retro_achievements/RetroAchievementsConsole;", "Lkotlin/collections/HashMap;", "getConsoles", "()Ljava/util/HashMap;", "credentialsLiveData", "Lcom/magneticchen/daijishou/live_data/PairLiveData;", "", "credentialsLiveDataObserver", "Lkotlin/Pair;", "credentialsRefreshMutex", "Lkotlinx/coroutines/sync/Mutex;", "credentialsRetriedCount", "firstLogin", "", "isCreated", "()Z", "setCreated", "(Z)V", "lastCredentialsFailedTimestamp", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "myUsername", "myUsernameLiveData", "Landroidx/lifecycle/MutableLiveData;", "getMyUsernameLiveData", "()Landroidx/lifecycle/MutableLiveData;", "refreshMyRetroAchievementsAwardsUserId", "refreshingConsoleIds", "refreshingConsoleIdsLiveData", "", "getRefreshingConsoleIdsLiveData", "setRefreshingConsoleIdsLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "refreshingGameIds", "refreshingGameIdsLiveData", "getRefreshingGameIdsLiveData", "setRefreshingGameIdsLiveData", "refreshingUsernames", "refreshingUsernamesLiveData", "getRefreshingUsernamesLiveData", "setRefreshingUsernamesLiveData", "retroAchievementsRepository", "Lcom/magneticchen/daijishou/repositories/RetroAchievementsRepository;", "getRetroAchievementsRepository", "()Lcom/magneticchen/daijishou/repositories/RetroAchievementsRepository;", "setRetroAchievementsRepository", "(Lcom/magneticchen/daijishou/repositories/RetroAchievementsRepository;)V", "retroAchievementsSharedPreferences", "Landroid/content/SharedPreferences;", "getRetroAchievementsSharedPreferences", "()Landroid/content/SharedPreferences;", "setRetroAchievementsSharedPreferences", "(Landroid/content/SharedPreferences;)V", "retroAchievementsUsernamePreferenceLiveData", "Lcom/magneticchen/daijishou/live_data/SharedPreferenceStringLiveData;", "retroAchievementsWebApiKeyPreferenceLiveData", "retroCredentials", "Lorg/retroachivements/api/data/RetroCredentials;", "retroInterface", "Lorg/retroachivements/api/RetroInterface;", "getConsoleImageUrl", "consoleId", "(Ljava/lang/Long;)Ljava/lang/String;", "getForumUrlString", "forumTopicId", "getMyRetroAchievementsUsername", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRetroInterface", "onCreate", "onTerminate", "refreshMyRetroAchievementsAwardsIfExpired", "refreshMyRetroAchievementsGameRecordByGameId", "gameId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshMyRetroAchievementsGameRecordByGameIdIfExpired", "refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "(Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntityIfExpired", "refreshRetroAchievementsAwardsByUserId", "userId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshRetroAchievementsCredentials", "toastOnSuccess", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshRetroAchievementsGameListByConsoleId", "refreshRetroAchievementsGameListByConsoleIdIfExpired", "refreshRetroAchievementsUserProfileData", "username", "refreshRetroAchievementsUserProfileDataIfExpired", "resetCredentialsRetriedCount", "setConsoleWatchlist", "toGenericName", TypedValues.Custom.S_STRING, "toGenericNameExtreme", "toRetroAchievementsDate", "Ljava/util/Date;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsManager {
    private static final int AWARD_EXPIRE_DURATION_MS = 480000;
    private static final int GAME_RECORD_EXPIRE_DURATION_MS = 480000;
    private static final int PLAYABLE_ITEM_ID_TO_GAME_ID_SURJECTION_EXPIRE_DURATION_MS = 604800000;
    public static final String USERNAME_PREFERENCE_STRING = "username";
    public static final String USER_ID_TRANSLATION_PREFERENCE_PREFIX = "user_id_translation_";
    private static final int USER_INDEPENDENT_GAME_RECORD_EXPIRE_DURATION_MS = 691200000;
    private static final int USER_PROFILE_EXPIRE_DURATION_MS = 480000;
    public static final String WEB_API_KEY_PREFERENCE_STRING = "web_api_key";
    private static final String baseUrl = "https://retroachievements.org";
    private static final int credentialsRetriesCoolDown = 240000;
    private static final boolean enforceCredentials = true;
    private static final int maxCredentialsRetryCount = 3;
    private final DaijishouApplication application;
    private ConnectionLiveData connectionLiveData;
    private final Function1<Integer, Unit> connectionLiveDataObserver;
    private final List<Long> consoleWatchlist;
    private final HashMap<Long, RetroAchievementsConsole> consoles;
    private PairLiveData<String, String> credentialsLiveData;
    private final Function1<Pair<String, String>, Unit> credentialsLiveDataObserver;
    private Mutex credentialsRefreshMutex;
    public int credentialsRetriedCount;
    public boolean firstLogin;
    private boolean isCreated;
    private long lastCredentialsFailedTimestamp;
    public final DaijishouApplication.WrappedLogger logger;
    public String myUsername;
    private final MutableLiveData<String> myUsernameLiveData;
    private List<String> refreshMyRetroAchievementsAwardsUserId;
    private List<Long> refreshingConsoleIds;
    private MutableLiveData<List<Long>> refreshingConsoleIdsLiveData;
    private List<Long> refreshingGameIds;
    private MutableLiveData<List<Long>> refreshingGameIdsLiveData;
    private List<String> refreshingUsernames;
    private MutableLiveData<List<String>> refreshingUsernamesLiveData;
    public RetroAchievementsRepository retroAchievementsRepository;
    public SharedPreferences retroAchievementsSharedPreferences;
    private SharedPreferenceStringLiveData retroAchievementsUsernamePreferenceLiveData;
    private SharedPreferenceStringLiveData retroAchievementsWebApiKeyPreferenceLiveData;
    private RetroCredentials retroCredentials;
    public RetroInterface retroInterface;
    private static final DateTimeFormatter achievementEarnedTimestampFormatter = DateTimeFormatter.ofPattern("yyyy[-MM-dd[' 'HH:mm:ss]]");
    private static final Regex genericNameRegex = Constants.INSTANCE.getToGenericNameRegex();

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$getMyRetroAchievementsUsername$1, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 1}, l = {848, 849}, m = "getMyRetroAchievementsUsername", n = {"this", "this"}, s = {"L$0", "L$0"})
    final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.getMyRetroAchievementsUsername(this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$getRetroInterface$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0}, l = {880}, m = "getRetroInterface", n = {"this"}, s = {"L$0"})
    final class C02491 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02491(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.getRetroInterface(this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshMyRetroAchievementsAwardsIfExpired$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 1}, l = {668, 672, 673}, m = "refreshMyRetroAchievementsAwardsIfExpired", n = {"this", "this"}, s = {"L$0", "L$0"})
    final class C02501 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02501(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshMyRetroAchievementsAwardsIfExpired(this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshMyRetroAchievementsGameRecordByGameId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 4}, l = {538, 542, 545, 659, 659, 659}, m = "refreshMyRetroAchievementsGameRecordByGameId", n = {"this", "gameId", "this", "gameId", "succeed", "this", "gameId", "succeed", "succeed", "succeed"}, s = {"L$0", "J$0", "L$0", "J$0", "I$0", "L$0", "J$0", "I$0", "I$0", "I$0"})
    final class C02511 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02511(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshMyRetroAchievementsGameRecordByGameId(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshMyRetroAchievementsGameRecordByGameIdIfExpired$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 0}, l = {528, 532}, m = "refreshMyRetroAchievementsGameRecordByGameIdIfExpired", n = {"this", "gameId"}, s = {"L$0", "J$0"})
    final class C02531 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02531(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshMyRetroAchievementsGameRecordByGameIdIfExpired(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 0, 0}, l = {368}, m = "refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity", n = {"this", "playableItemEntity", "retroAchievementsConsoleIdList"}, s = {"L$0", "L$1", "L$2"})
    final class C02541 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C02541(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity(null, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsAwardsByUserId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 0, 1, 1, 1}, l = {678, 682}, m = "refreshRetroAchievementsAwardsByUserId", n = {"this", "userId", "this", "userId", "succeed"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
    final class C02551 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02551(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshRetroAchievementsAwardsByUserId(null, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsCredentials$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 8, 9, 9, 11, 13}, l = {232, 240, 259, 894, 272, 277, 292, 319, 323, 313, 319, 323, 319, 323}, m = "refreshRetroAchievementsCredentials", n = {"this", "username", "webApiKey", "toastOnSuccess", "this", "this", "username", "webApiKey", "$this$withLock_u24default$iv", "toastOnSuccess", "this", "username", "webApiKey", "$this$withLock_u24default$iv", "toastOnSuccess", "this", "username", "$this$withLock_u24default$iv", "toastOnSuccess", "this", "$this$withLock_u24default$iv", "this", "this", "e", "this", "this"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$0", "L$0", "L$1", "L$0", "L$0"})
    final class C02561 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C02561(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshRetroAchievementsCredentials(false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsGameListByConsoleId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 4}, l = {474, 479, 482, 519, 519, 519}, m = "refreshRetroAchievementsGameListByConsoleId", n = {"this", "consoleId", "this", "consoleId", "succeed", "this", "consoleId", "succeed", "succeed", "succeed"}, s = {"L$0", "J$0", "L$0", "J$0", "I$0", "L$0", "J$0", "I$0", "I$0", "I$0"})
    final class C02591 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02591(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshRetroAchievementsGameListByConsoleId(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsGameListByConsoleIdIfExpired$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 0}, l = {461, 469}, m = "refreshRetroAchievementsGameListByConsoleIdIfExpired", n = {"this", "consoleId"}, s = {"L$0", "J$0"})
    final class C02611 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02611(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshRetroAchievementsGameListByConsoleIdIfExpired(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsUserProfileData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5}, l = {737, 740, 743, 772, 799, 830, 836, 836, 836}, m = "refreshRetroAchievementsUserProfileData", n = {"this", "username", "this", "username", "this", "username", "this", "username", "retroAchievementsUserProfileEntity", "gameRecordsToBeUpdated", "this", "username", "retroAchievementsUserProfileEntity", "gameRecordsToBeUpdated", "recentPlayedResponse", "this", "username"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"})
    final class C02621 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C02621(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshRetroAchievementsUserProfileData(null, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsUserProfileDataIfExpired$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 0}, l = {727, 731}, m = "refreshRetroAchievementsUserProfileDataIfExpired", n = {"this", "username"}, s = {"L$0", "L$1"})
    final class C02641 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02641(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshRetroAchievementsUserProfileDataIfExpired(null, this);
        }
    }

    public RetroAchievementsManager(DaijishouApplication application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this.logger = application.getLogger();
        this.consoleWatchlist = new ArrayList();
        this.refreshingConsoleIds = new ArrayList();
        this.refreshingConsoleIdsLiveData = new MutableLiveData<>();
        this.refreshingGameIds = new ArrayList();
        this.refreshingGameIdsLiveData = new MutableLiveData<>();
        this.refreshingUsernames = new ArrayList();
        this.refreshingUsernamesLiveData = new MutableLiveData<>();
        this.credentialsRefreshMutex = MutexKt.Mutex$default(false, 1, null);
        this.consoles = new HashMap<>();
        this.myUsernameLiveData = new MutableLiveData<>(null);
        this.firstLogin = true;
        this.credentialsLiveDataObserver = (Function1<Pair<String, String>, Unit>) (Function1) new RetroAchievementsManager$credentialsLiveDataObserver$1(this);
        this.connectionLiveDataObserver = new RetroAchievementsManager$connectionLiveDataObserver$1(this);
        this.refreshMyRetroAchievementsAwardsUserId = new ArrayList();
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: isCreated, reason: from getter */
    public final boolean getIsCreated() {
        return this.isCreated;
    }

    public final void setCreated(boolean z) {
        this.isCreated = z;
    }

    public final MutableLiveData<List<Long>> getRefreshingConsoleIdsLiveData() {
        return this.refreshingConsoleIdsLiveData;
    }

    public final void setRefreshingConsoleIdsLiveData(MutableLiveData<List<Long>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.refreshingConsoleIdsLiveData = mutableLiveData;
    }

    public final MutableLiveData<List<Long>> getRefreshingGameIdsLiveData() {
        return this.refreshingGameIdsLiveData;
    }

    public final void setRefreshingGameIdsLiveData(MutableLiveData<List<Long>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.refreshingGameIdsLiveData = mutableLiveData;
    }

    public final MutableLiveData<List<String>> getRefreshingUsernamesLiveData() {
        return this.refreshingUsernamesLiveData;
    }

    public final void setRefreshingUsernamesLiveData(MutableLiveData<List<String>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.refreshingUsernamesLiveData = mutableLiveData;
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

    public final HashMap<Long, RetroAchievementsConsole> getConsoles() {
        return this.consoles;
    }

    public final MutableLiveData<String> getMyUsernameLiveData() {
        return this.myUsernameLiveData;
    }

    private final String toGenericName(String string) {
        List<String> groupValues;
        String str;
        MatchResult matchResultFind$default = Regex.find$default(genericNameRegex, string, 0, 2, null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null && (str = groupValues.get(1)) != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                return new Regex("(\\s+|_+)").replace(lowerCase, " ");
            }
        }
        return null;
    }

    private final String toGenericNameExtreme(String string) {
        List<String> groupValues;
        String str;
        MatchResult matchResultFind$default = Regex.find$default(genericNameRegex, string, 0, 2, null);
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

    public final void setConsoleWatchlist(List<Long> consoleWatchlist) {
        Intrinsics.checkNotNullParameter(consoleWatchlist, "consoleWatchlist");
        this.logger.debug(this, "setConsoleWatchlist, consoleWatchlist: " + consoleWatchlist);
        this.consoleWatchlist.clear();
        this.consoleWatchlist.addAll(consoleWatchlist);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new C02651(consoleWatchlist, null), 2, null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$setConsoleWatchlist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$setConsoleWatchlist$1", f = "RetroAchievementsManager.kt", i = {}, l = {176}, m = "invokeSuspendImpl", n = {}, s = {})
    final class C02651 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ List<Long> $consoleWatchlist;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02651(List<Long> list, Continuation<?> continuation) {
            super(2, continuation);
            this.$consoleWatchlist = list;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            C02651 c02651 = RetroAchievementsManager.this.new C02651(this.$consoleWatchlist, continuation);
            c02651.L$0 = obj;
            return c02651;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    try {
                        return ((C02651) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
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
                RetroAchievementsManager.this.logger.debug((CoroutineScope) this.L$0, "consoleWatchlist.forEach");
                List<Long> list = this.$consoleWatchlist;
                retroAchievementsManager = RetroAchievementsManager.this;
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
                long jLongValue = ((Number) it.next()).longValue();
                this.L$0 = retroAchievementsManager;
                this.L$1 = it;
                this.label = 1;
                if (retroAchievementsManager.refreshRetroAchievementsGameListByConsoleIdIfExpired(jLongValue, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final String getConsoleImageUrl(Long consoleId) {
        RetroAchievementsConsole retroAchievementsConsole;
        if (consoleId == null || (retroAchievementsConsole = this.consoles.get(consoleId)) == null) {
            return null;
        }
        return retroAchievementsConsole.getIconUrl();
    }

    public final void resetCredentialsRetriedCount() {
        this.credentialsRetriedCount = 0;
    }

    public final String getForumUrlString(int forumTopicId) {
        return "https://retroachievements.org/viewtopic.php?t=" + forumTopicId;
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [java.time.ZonedDateTime] */
    public final Date toRetroAchievementsDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            TemporalAccessor best = achievementEarnedTimestampFormatter.parseBest(str, new RetroAchievementsManager$$ExternalSyntheticLambda0(), new RetroAchievementsManager$$ExternalSyntheticLambda1());
            Intrinsics.checkNotNullExpressionValue(best, "parseBest(...)");
            if (best instanceof LocalDateTime) {
                return Date.from(((LocalDateTime) best).atZone(ZoneId.systemDefault()).toInstant());
            }
            if (best instanceof LocalDate) {
                return Date.from(((LocalDate) best).atStartOfDay(ZoneId.systemDefault()).toInstant());
            }
            return null;
        } catch (DateTimeParseException e) {
            System.out.println((Object) ("Failed to parse date: " + str + ", Error: " + e.getMessage()));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:104:0x0282  */
    /* JADX WARN: Code duplicated, block: B:108:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:112:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:115:0x02f1 A[Catch: all -> 0x03f1, TryCatch #3 {all -> 0x03f1, blocks: (B:113:0x02eb, B:115:0x02f1, B:117:0x02f7, B:118:0x0303, B:120:0x0309, B:121:0x033a, B:129:0x0367, B:131:0x036b, B:135:0x037f, B:136:0x0380, B:137:0x0389, B:138:0x038a, B:156:0x03e9, B:157:0x03f0), top: B:208:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:131:0x036b A[Catch: all -> 0x03f1, TryCatch #3 {all -> 0x03f1, blocks: (B:113:0x02eb, B:115:0x02f1, B:117:0x02f7, B:118:0x0303, B:120:0x0309, B:121:0x033a, B:129:0x0367, B:131:0x036b, B:135:0x037f, B:136:0x0380, B:137:0x0389, B:138:0x038a, B:156:0x03e9, B:157:0x03f0), top: B:208:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:133:0x037c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:134:0x037e  */
    /* JADX WARN: Code duplicated, block: B:135:0x037f A[Catch: all -> 0x03f1, TryCatch #3 {all -> 0x03f1, blocks: (B:113:0x02eb, B:115:0x02f1, B:117:0x02f7, B:118:0x0303, B:120:0x0309, B:121:0x033a, B:129:0x0367, B:131:0x036b, B:135:0x037f, B:136:0x0380, B:137:0x0389, B:138:0x038a, B:156:0x03e9, B:157:0x03f0), top: B:208:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0380 A[Catch: all -> 0x03f1, TryCatch #3 {all -> 0x03f1, blocks: (B:113:0x02eb, B:115:0x02f1, B:117:0x02f7, B:118:0x0303, B:120:0x0309, B:121:0x033a, B:129:0x0367, B:131:0x036b, B:135:0x037f, B:136:0x0380, B:137:0x0389, B:138:0x038a, B:156:0x03e9, B:157:0x03f0), top: B:208:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:138:0x038a A[Catch: all -> 0x03f1, TRY_LEAVE, TryCatch #3 {all -> 0x03f1, blocks: (B:113:0x02eb, B:115:0x02f1, B:117:0x02f7, B:118:0x0303, B:120:0x0309, B:121:0x033a, B:129:0x0367, B:131:0x036b, B:135:0x037f, B:136:0x0380, B:137:0x0389, B:138:0x038a, B:156:0x03e9, B:157:0x03f0), top: B:208:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:146:0x039b  */
    /* JADX WARN: Code duplicated, block: B:149:0x03b0 A[Catch: Exception -> 0x0080, TRY_ENTER, TryCatch #2 {Exception -> 0x0080, blocks: (B:19:0x005c, B:184:0x046a, B:186:0x0470, B:183:0x0461, B:27:0x007b, B:150:0x03b9, B:152:0x03bf, B:149:0x03b0), top: B:207:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:152:0x03bf A[Catch: Exception -> 0x0080, TRY_LEAVE, TryCatch #2 {Exception -> 0x0080, blocks: (B:19:0x005c, B:184:0x046a, B:186:0x0470, B:183:0x0461, B:27:0x007b, B:150:0x03b9, B:152:0x03bf, B:149:0x03b0), top: B:207:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:156:0x03e9 A[Catch: all -> 0x03f1, TRY_ENTER, TryCatch #3 {all -> 0x03f1, blocks: (B:113:0x02eb, B:115:0x02f1, B:117:0x02f7, B:118:0x0303, B:120:0x0309, B:121:0x033a, B:129:0x0367, B:131:0x036b, B:135:0x037f, B:136:0x0380, B:137:0x0389, B:138:0x038a, B:156:0x03e9, B:157:0x03f0), top: B:208:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:176:0x042b  */
    /* JADX WARN: Code duplicated, block: B:180:0x044e  */
    /* JADX WARN: Code duplicated, block: B:183:0x0461 A[Catch: Exception -> 0x0080, TRY_ENTER, TryCatch #2 {Exception -> 0x0080, blocks: (B:19:0x005c, B:184:0x046a, B:186:0x0470, B:183:0x0461, B:27:0x007b, B:150:0x03b9, B:152:0x03bf, B:149:0x03b0), top: B:207:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:186:0x0470 A[Catch: Exception -> 0x0080, TRY_LEAVE, TryCatch #2 {Exception -> 0x0080, blocks: (B:19:0x005c, B:184:0x046a, B:186:0x0470, B:183:0x0461, B:27:0x007b, B:150:0x03b9, B:152:0x03bf, B:149:0x03b0), top: B:207:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:193:0x0490  */
    /* JADX WARN: Code duplicated, block: B:196:0x04a6 A[Catch: Exception -> 0x0048, TRY_ENTER, TryCatch #11 {Exception -> 0x0048, blocks: (B:13:0x0042, B:197:0x04af, B:199:0x04b5, B:196:0x04a6), top: B:207:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:222:0x026b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:229:0x04d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:231:? A[LOOP:1: B:184:0x046a->B:231:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:233:0x04d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:235:? A[LOOP:2: B:150:0x03b9->B:235:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:87:0x020e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x0210  */
    /* JADX WARN: Code duplicated, block: B:91:0x0222  */
    /* JADX WARN: Code duplicated, block: B:92:0x0226  */
    /* JADX WARN: Code duplicated, block: B:94:0x022a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0248  */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x03ac, code lost:
    
        if (refreshRetroAchievementsCredentials$default(r4, false, r6, r16, null) == r2) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x045d, code lost:
    
        if (refreshRetroAchievementsCredentials$default(r4, false, r6, 1, null) == r2) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x04a3, code lost:
    
        if (refreshRetroAchievementsCredentials$default(r5, false, r6, 1, null) == r2) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0167, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r0, r3, r6) == r2) goto L201;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x00f9: MOVE (r5 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]), block:B:53:0x00f8 */
    /* JADX WARN: Type inference failed for: r0v20, types: [com.magneticchen.daijishou.DaijishouApplication$WrappedLogger] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v3, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.magneticchen.daijishou.DaijishouApplication$WrappedLogger] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r4v52 */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v9, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v11, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v23, types: [java.lang.String, kotlin.coroutines.Continuation, org.retroachivements.api.RetroInterface] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v49 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v50 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object, java.lang.String, kotlin.coroutines.Continuation, org.retroachivements.api.RetroInterface] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refreshRetroAchievementsCredentials(boolean r28, kotlin.coroutines.Continuation<?> r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager.refreshRetroAchievementsCredentials(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object refreshRetroAchievementsCredentials$default(RetroAchievementsManager retroAchievementsManager, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 1) != 0) {
            z = false;
        }
        return retroAchievementsManager.refreshRetroAchievementsCredentials(z, continuation);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsCredentials$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsCredentials$2", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    final class C02572 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;

        C02572(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new C02572(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    try {
                        return ((C02572) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
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
                RetroAchievementsManager.this.getMyUsernameLiveData().setValue(RetroAchievementsManager.this.myUsername);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsCredentials$3, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsCredentials$3", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    final class AnonymousClass3 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;

        AnonymousClass3(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    try {
                        return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Toast.makeText(RetroAchievementsManager.this.getApplication().getApplicationContext(), RetroAchievementsManager.this.getApplication().getString(R.string.retro_achievements_login_failed_message), 0).show();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsCredentials$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsCredentials$5", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    final class C02585 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;

        C02585(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new C02585(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    try {
                        return ((C02585) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
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
                RetroAchievementsManager.this.getMyUsernameLiveData().setValue(RetroAchievementsManager.this.myUsername);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntityIfExpired(PlayableItemEntity playableItemEntity, Continuation<?> continuation) throws Throwable {
        this.logger.debug(this, "refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntityIfExpired");
        RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemIdStatically = getRetroAchievementsRepository().getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemIdStatically(playableItemEntity.getId());
        if (retroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemIdStatically != null) {
            if (retroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemIdStatically.isPermanent()) {
                return Boxing.boxBoolean(true);
            }
            Date lastUpdatedTimestamp = retroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemIdStatically.getLastUpdatedTimestamp();
            if (lastUpdatedTimestamp != null && lastUpdatedTimestamp.getTime() + ((long) 604800000) > System.currentTimeMillis()) {
                return Boxing.boxBoolean(false);
            }
        }
        return refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity(playableItemEntity, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:78:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:83:0x0316 A[Catch: Exception -> 0x0040, all -> 0x0375, TryCatch #0 {Exception -> 0x0040, blocks: (B:12:0x003b, B:27:0x008b, B:29:0x0091, B:32:0x00ac, B:33:0x00c6, B:35:0x00cd, B:37:0x00e2, B:38:0x00f1, B:40:0x00fe, B:41:0x010d, B:42:0x011f, B:44:0x0125, B:46:0x012d, B:47:0x0130, B:48:0x016a, B:50:0x0170, B:52:0x01b5, B:54:0x01bb, B:56:0x01c7, B:58:0x01cf, B:59:0x0214, B:61:0x021a, B:64:0x0234, B:66:0x024a, B:67:0x0251, B:69:0x0257, B:71:0x0265, B:76:0x028d, B:79:0x02b6, B:81:0x0310, B:83:0x0316, B:87:0x0342, B:89:0x0354, B:91:0x035f, B:90:0x0359), top: B:100:0x003b }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [T, java.lang.Long] */
    public final Object refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity(PlayableItemEntity playableItemEntity, Continuation<?> continuation) throws Throwable {
        C02541 c02541;
        RetroAchievementsManager retroAchievementsManager;
        Iterator it;
        List<Long> list;
        PlayableItemEntity playableItemEntity2 = null;
        boolean z;
        ArrayList arrayList;
        float f;
        float fMax = 0.0f;
        float ranking;
        if (continuation instanceof C02541) {
            c02541 = (C02541) continuation;
            if ((c02541.label & Integer.MIN_VALUE) != 0) {
                c02541.label -= Integer.MIN_VALUE;
            } else {
                c02541 = new C02541(continuation);
            }
        } else {
            c02541 = new C02541(continuation);
        }
        Object obj = c02541.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02541.label;
        int i2 = 0;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.logger.debug(this, "refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity");
                try {
                    DaijishouLibraryRepository daijishouLibraryRepository = this.application.getDaijishouLibraryRepository();
                    Long attachedPlatformId = playableItemEntity.getAttachedPlatformId();
                    Intrinsics.checkNotNull(attachedPlatformId);
                    PlatformEntity platformByIdStatically = daijishouLibraryRepository.getPlatformByIdStatically(attachedPlatformId.longValue());
                    Intrinsics.checkNotNull(platformByIdStatically);
                    List<Long> retroAchievementsConsoleIdList = platformByIdStatically.getRetroAchievementsConsoleIdList();
                    if (retroAchievementsConsoleIdList.isEmpty()) {
                        try {
                            return Boxing.boxBoolean(false);
                        } catch (Exception e) {
                            e = e;
                            retroAchievementsManager = this;
                        }
                    } else {
                        it = retroAchievementsConsoleIdList.iterator();
                        list = retroAchievementsConsoleIdList;
                        retroAchievementsManager = this;
                        playableItemEntity2 = playableItemEntity;
                    }
                } catch (Exception e2) {
                    retroAchievementsManager = this;
                    retroAchievementsManager.logger.error(retroAchievementsManager, ExceptionsKt.stackTraceToString(e2));
                    z = false;
                    return Boxing.boxBoolean(z);
                }
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) c02541.L$3;
            list = (List) c02541.L$2;
            PlayableItemEntity playableItemEntity3 = (PlayableItemEntity) c02541.L$1;
            retroAchievementsManager = (RetroAchievementsManager) c02541.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                playableItemEntity2 = playableItemEntity3;
            } catch (Exception e3) {
                Exception e = null;
                e = e3;
                retroAchievementsManager.logger.error(retroAchievementsManager, ExceptionsKt.stackTraceToString(e));
                z = false;
            }
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                c02541.L$0 = retroAchievementsManager;
                c02541.L$1 = playableItemEntity2;
                c02541.L$2 = list;
                c02541.L$3 = it;
                c02541.label = 1;
                if (retroAchievementsManager.refreshRetroAchievementsGameListByConsoleIdIfExpired(jLongValue, c02541) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(playableItemEntity2.getScraperKeywordList());
            for (String str : playableItemEntity2.getScraperKeywordList()) {
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) " - ", false, 2, (Object) null)) {
                    arrayList2.add(StringsKt.replace$default(str, " - ", " ", false, 4, (Object) null));
                } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) ": ", false, 2, (Object) null)) {
                    arrayList2.add(StringsKt.replace$default(str, ": ", " ", false, 4, (Object) null));
                }
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Ref.FloatRef floatRef = new Ref.FloatRef();
            Iterator it2 = list.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                Object next = it2.next();
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                long jLongValue2 = ((Number) next).longValue();
                int i5 = i2;
                retroAchievementsManager.logger.debug(retroAchievementsManager, "retroAchievementsConsoleIdList.forEachIndexed: " + i3 + ", " + jLongValue2);
                float size = (list.size() - i3) - 1.0f;
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    String str2 = (String) it3.next();
                    PlayableItemEntity playableItemEntity4 = playableItemEntity2;
                    retroAchievementsManager.logger.debug(retroAchievementsManager, "scraperKeywordList keywordRaw: " + str2);
                    String[] strArr = new String[1];
                    strArr[i5] = "&";
                    int length = i5;
                    String str3 = "";
                    for (String str4 : (java.util.List<String>) StringsKt.split$default((CharSequence) str2, strArr, false, 0, 6, (Object) null)) {
                        if (str4.length() > length) {
                            length = str4.length();
                            str3 = str4;
                        }
                    }
                    String strReplace$default = StringsKt.replace$default(str3, " - ", ": ", false, 4, (Object) null);
                    String genericNameExtreme = retroAchievementsManager.toGenericNameExtreme(strReplace$default);
                    long j = jLongValue2;
                    List listSearchRetroAchievementsUserIndependentGameRecordByKeywordAndConsoleId$default = RetroAchievementsRepository.searchRetroAchievementsUserIndependentGameRecordByKeywordAndConsoleId$default(retroAchievementsManager.getRetroAchievementsRepository(), strReplace$default, j, 0, null, false, 28, null);
                    retroAchievementsManager.logger.debug(retroAchievementsManager, "candidates: " + listSearchRetroAchievementsUserIndependentGameRecordByKeywordAndConsoleId$default);
                    Iterator it4 = listSearchRetroAchievementsUserIndependentGameRecordByKeywordAndConsoleId$default.iterator();
                    while (it4.hasNext()) {
                        RetroAchievementsRepository.RetroAchievementsUserIndependentGameRecordSearchItem retroAchievementsUserIndependentGameRecordSearchItem = (RetroAchievementsRepository.RetroAchievementsUserIndependentGameRecordSearchItem) it4.next();
                        RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity = retroAchievementsUserIndependentGameRecordSearchItem.getRetroAchievementsUserIndependentGameRecordEntity();
                        String name = retroAchievementsUserIndependentGameRecordEntity.getName();
                        Iterator it5 = it4;
                        long id2 = retroAchievementsUserIndependentGameRecordEntity.getId();
                        if (genericNameExtreme == null || name == null) {
                            arrayList = arrayList2;
                            f = size;
                        } else {
                            arrayList = arrayList2;
                            f = size;
                            List<String> listSplit = new Regex("\\s*\\|\\s*").split(name, i5);
                            if (listSplit != null) {
                                fMax = 0.0f;
                                for (Iterator it6 = listSplit.iterator(); it6.hasNext(); it6 = it6) {
                                    String genericNameExtreme2 = retroAchievementsManager.toGenericNameExtreme((String) it6.next());
                                    if (genericNameExtreme2 != null) {
                                        fMax = Math.max(fMax, UtilsKt.getLCS(genericNameExtreme, genericNameExtreme2) / Math.max(genericNameExtreme.length(), genericNameExtreme2.length()));
                                    }
                                }
                            }
                            ranking = f + (2 * fMax) + (retroAchievementsUserIndependentGameRecordSearchItem.getRanking() / retroAchievementsUserIndependentGameRecordSearchItem.getMaxRanking()) + (retroAchievementsUserIndependentGameRecordSearchItem.getMatchCount() / retroAchievementsUserIndependentGameRecordSearchItem.getMaxMatchCount());
                            DaijishouApplication.WrappedLogger wrappedLogger = retroAchievementsManager.logger;
                            String str5 = genericNameExtreme;
                            float f2 = floatRef.element;
                            if (name == null) {
                                name = "";
                            }
                            List<Long> list2 = list;
                            Iterator it7 = it3;
                            Iterator it8 = it2;
                            wrappedLogger.debug(retroAchievementsManager, "SearchResultRanking -> gameId: " + id2 + ", bestResultScore: " + f2 + ", newResultScore: " + ranking + ", lcsScore: " + fMax + "\n\nGameName -> Search result: " + retroAchievementsManager.toGenericNameExtreme(name) + ", Original: " + retroAchievementsManager.toGenericNameExtreme(strReplace$default));
                            if (objectRef.element != null || ranking > floatRef.element) {
                                objectRef.element = Boxing.boxLong(id2);
                                floatRef.element = ranking;
                            }
                            it4 = it5;
                            genericNameExtreme = str5;
                            list = list2;
                            arrayList2 = arrayList;
                            size = f;
                            it3 = it7;
                            it2 = it8;
                            i5 = 0;
                        }
                        fMax = 0.0f;
                        ranking = f + (2 * fMax) + (retroAchievementsUserIndependentGameRecordSearchItem.getRanking() / retroAchievementsUserIndependentGameRecordSearchItem.getMaxRanking()) + (retroAchievementsUserIndependentGameRecordSearchItem.getMatchCount() / retroAchievementsUserIndependentGameRecordSearchItem.getMaxMatchCount());
                        DaijishouApplication.WrappedLogger wrappedLogger2 = retroAchievementsManager.logger;
                        String str6 = genericNameExtreme;
                        float f3 = floatRef.element;
                        if (name == null) {
                            name = "";
                        }
                        List<Long> list3 = list;
                        Iterator it9 = it3;
                        Iterator it10 = it2;
                        wrappedLogger2.debug(retroAchievementsManager, "SearchResultRanking -> gameId: " + id2 + ", bestResultScore: " + f3 + ", newResultScore: " + ranking + ", lcsScore: " + fMax + "\n\nGameName -> Search result: " + retroAchievementsManager.toGenericNameExtreme(name) + ", Original: " + retroAchievementsManager.toGenericNameExtreme(strReplace$default));
                        if (objectRef.element != null) {
                            objectRef.element = Boxing.boxLong(id2);
                            floatRef.element = ranking;
                        } else {
                            objectRef.element = Boxing.boxLong(id2);
                            floatRef.element = ranking;
                        }
                        it4 = it5;
                        genericNameExtreme = str6;
                        list = list3;
                        arrayList2 = arrayList;
                        size = f;
                        it3 = it9;
                        it2 = it10;
                        i5 = 0;
                    }
                    jLongValue2 = j;
                    playableItemEntity2 = playableItemEntity4;
                    i5 = 0;
                }
                i3 = i4;
                i2 = 0;
            }
            PlayableItemEntity playableItemEntity5 = playableItemEntity2;
            RetroAchievementsRepository retroAchievementsRepository = retroAchievementsManager.getRetroAchievementsRepository();
            long id3 = playableItemEntity5.getId();
            Long l = (Long) objectRef.element;
            retroAchievementsRepository.addRetroAchievementsCachedPlayableItemIdToGameIdSurjection(new RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity(0L, false, id3, l != null ? l.longValue() : RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.INSTANCE.getNULL_GAME_ID(), new Date(), 3, null));
            z = true;
            return Boxing.boxBoolean(z);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object refreshRetroAchievementsGameListByConsoleIdIfExpired(long j, Continuation<?> continuation) throws Throwable {
        C02611 c02611;
        RetroAchievementsManager retroAchievementsManager;
        Date lastUpdatedTimestamp;
        if (continuation instanceof C02611) {
            c02611 = (C02611) continuation;
            if ((c02611.label & Integer.MIN_VALUE) != 0) {
                c02611.label -= Integer.MIN_VALUE;
            } else {
                c02611 = new C02611(continuation);
            }
        } else {
            c02611 = new C02611(continuation);
        }
        Object retroInterface = c02611.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02611.label;
        if (i == 0) {
            ResultKt.throwOnFailure(retroInterface);
            this.logger.debug(this, "refreshRetroAchievementsGameListByConsoleIdIfExpired, consoleId: " + j);
            c02611.L$0 = this;
            c02611.J$0 = j;
            c02611.label = 1;
            retroInterface = getRetroInterface(c02611);
            if (retroInterface != coroutine_suspended) {
                retroAchievementsManager = this;
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(retroInterface);
            return retroInterface;
        }
        j = c02611.J$0;
        retroAchievementsManager = (RetroAchievementsManager) c02611.L$0;
        ResultKt.throwOnFailure(retroInterface);
        if (((RetroInterface) retroInterface) == null) {
            return Boxing.boxBoolean(false);
        }
        RetroAchievementsUserIndependentGameRecordEntity firstRetroAchievementsUserIndependentGameRecordByConsoleIdStatically = retroAchievementsManager.getRetroAchievementsRepository().getFirstRetroAchievementsUserIndependentGameRecordByConsoleIdStatically(j);
        if (firstRetroAchievementsUserIndependentGameRecordByConsoleIdStatically != null && (lastUpdatedTimestamp = firstRetroAchievementsUserIndependentGameRecordByConsoleIdStatically.getLastUpdatedTimestamp()) != null && lastUpdatedTimestamp.getTime() + ((long) 691200000) > System.currentTimeMillis()) {
            return Boxing.boxBoolean(false);
        }
        c02611.L$0 = null;
        c02611.label = 2;
        Object objRefreshRetroAchievementsGameListByConsoleId = retroAchievementsManager.refreshRetroAchievementsGameListByConsoleId(j, c02611);
        return objRefreshRetroAchievementsGameListByConsoleId == coroutine_suspended ? coroutine_suspended : objRefreshRetroAchievementsGameListByConsoleId;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x02c6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:47:0x0113  */
    /* JADX WARN: Code duplicated, block: B:50:0x011a A[Catch: all -> 0x01f4, Exception -> 0x0249, TRY_ENTER, TryCatch #2 {all -> 0x01f4, blocks: (B:50:0x011a, B:51:0x0134, B:53:0x013a, B:55:0x01c1, B:57:0x01c7, B:58:0x01d3, B:64:0x01fd, B:68:0x0211, B:69:0x0212, B:70:0x021b), top: B:110:0x0118 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x013a A[Catch: all -> 0x01f4, Exception -> 0x0249, TryCatch #2 {all -> 0x01f4, blocks: (B:50:0x011a, B:51:0x0134, B:53:0x013a, B:55:0x01c1, B:57:0x01c7, B:58:0x01d3, B:64:0x01fd, B:68:0x0211, B:69:0x0212, B:70:0x021b), top: B:110:0x0118 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01c1 A[Catch: all -> 0x01f4, Exception -> 0x0249, TryCatch #2 {all -> 0x01f4, blocks: (B:50:0x011a, B:51:0x0134, B:53:0x013a, B:55:0x01c1, B:57:0x01c7, B:58:0x01d3, B:64:0x01fd, B:68:0x0211, B:69:0x0212, B:70:0x021b), top: B:110:0x0118 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:62:0x01f9 A[Catch: all -> 0x0245, Exception -> 0x0249, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0245, blocks: (B:48:0x0114, B:62:0x01f9), top: B:111:0x0114 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x01fd A[Catch: all -> 0x01f4, Exception -> 0x0249, TRY_ENTER, TryCatch #2 {all -> 0x01f4, blocks: (B:50:0x011a, B:51:0x0134, B:53:0x013a, B:55:0x01c1, B:57:0x01c7, B:58:0x01d3, B:64:0x01fd, B:68:0x0211, B:69:0x0212, B:70:0x021b), top: B:110:0x0118 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x020e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x0210  */
    /* JADX WARN: Code duplicated, block: B:68:0x0211 A[Catch: all -> 0x01f4, Exception -> 0x0249, TryCatch #2 {all -> 0x01f4, blocks: (B:50:0x011a, B:51:0x0134, B:53:0x013a, B:55:0x01c1, B:57:0x01c7, B:58:0x01d3, B:64:0x01fd, B:68:0x0211, B:69:0x0212, B:70:0x021b), top: B:110:0x0118 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0212 A[Catch: all -> 0x01f4, Exception -> 0x0249, TryCatch #2 {all -> 0x01f4, blocks: (B:50:0x011a, B:51:0x0134, B:53:0x013a, B:55:0x01c1, B:57:0x01c7, B:58:0x01d3, B:64:0x01fd, B:68:0x0211, B:69:0x0212, B:70:0x021b), top: B:110:0x0118 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:95:0x0297  */
    /* JADX WARN: Code duplicated, block: B:98:0x029b  */
    /* JADX WARN: Code duplicated, block: B:99:0x029d  */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x023e, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r0, r5, r12) == r4) goto L106;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refreshRetroAchievementsGameListByConsoleId(long r37, kotlin.coroutines.Continuation<?> r39) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 730
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager.refreshRetroAchievementsGameListByConsoleId(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsGameListByConsoleId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsGameListByConsoleId$2", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    final class C02602 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;

        C02602(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new C02602(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    try {
                        return ((C02602) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
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
                RetroAchievementsManager.this.getRefreshingConsoleIdsLiveData().setValue(RetroAchievementsManager.this.refreshingConsoleIds);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsGameListByConsoleId$4, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsGameListByConsoleId$4", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    final class AnonymousClass4 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;

        AnonymousClass4(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    try {
                        return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
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
                RetroAchievementsManager.this.getRefreshingGameIdsLiveData().setValue(RetroAchievementsManager.this.refreshingGameIds);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object refreshMyRetroAchievementsGameRecordByGameIdIfExpired(long j, Continuation<?> continuation) throws Throwable {
        C02531 c02531;
        RetroAchievementsManager retroAchievementsManager;
        long j2;
        Date lastUpdatedTimestamp;
        if (continuation instanceof C02531) {
            c02531 = (C02531) continuation;
            if ((c02531.label & Integer.MIN_VALUE) != 0) {
                c02531.label -= Integer.MIN_VALUE;
            } else {
                c02531 = new C02531(continuation);
            }
        } else {
            c02531 = new C02531(continuation);
        }
        Object retroInterface = c02531.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02531.label;
        if (i == 0) {
            ResultKt.throwOnFailure(retroInterface);
            c02531.L$0 = this;
            c02531.J$0 = j;
            c02531.label = 1;
            retroInterface = getRetroInterface(c02531);
            if (retroInterface != coroutine_suspended) {
                retroAchievementsManager = this;
                j2 = j;
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(retroInterface);
            return retroInterface;
        }
        j2 = c02531.J$0;
        retroAchievementsManager = (RetroAchievementsManager) c02531.L$0;
        ResultKt.throwOnFailure(retroInterface);
        if (((RetroInterface) retroInterface) == null) {
            return Boxing.boxBoolean(false);
        }
        RetroAchievementsRepository retroAchievementsRepository = retroAchievementsManager.getRetroAchievementsRepository();
        String str = retroAchievementsManager.myUsername;
        Intrinsics.checkNotNull(str);
        RetroAchievementsGameRecordEntity retroAchievementsGameRecordByUserIdAndGameIdStatically = retroAchievementsRepository.getRetroAchievementsGameRecordByUserIdAndGameIdStatically(str, j2);
        Long lBoxLong = (retroAchievementsGameRecordByUserIdAndGameIdStatically == null || (lastUpdatedTimestamp = retroAchievementsGameRecordByUserIdAndGameIdStatically.getLastUpdatedTimestamp()) == null) ? null : Boxing.boxLong(lastUpdatedTimestamp.getTime());
        if (lBoxLong != null && lBoxLong.longValue() + ((long) 480000) > System.currentTimeMillis()) {
            return Boxing.boxBoolean(false);
        }
        retroAchievementsManager.logger.debug(retroAchievementsManager, "refreshMyRetroAchievementsUserProfileDataIfExpired (Expired). Current: " + System.currentTimeMillis() + ", Last Updated: " + lBoxLong + ", Expire: " + (lBoxLong != null ? Boxing.boxLong(lBoxLong.longValue() + ((long) 480000)) : "None"));
        c02531.L$0 = null;
        c02531.label = 2;
        Object objRefreshMyRetroAchievementsGameRecordByGameId = retroAchievementsManager.refreshMyRetroAchievementsGameRecordByGameId(j2, c02531);
        return objRefreshMyRetroAchievementsGameRecordByGameId == coroutine_suspended ? coroutine_suspended : objRefreshMyRetroAchievementsGameRecordByGameId;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0386  */
    /* JADX WARN: Code duplicated, block: B:101:0x0387 A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:102:0x0388 A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:134:0x0415  */
    /* JADX WARN: Code duplicated, block: B:137:0x0419  */
    /* JADX WARN: Code duplicated, block: B:142:0x0440 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:145:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:0x033f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:46:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:49:0x0109 A[Catch: all -> 0x03c4, Exception -> 0x03c9, TryCatch #8 {Exception -> 0x03c9, all -> 0x03c4, blocks: (B:47:0x0103, B:49:0x0109, B:51:0x0118), top: B:152:0x0103 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0118 A[Catch: all -> 0x03c4, Exception -> 0x03c9, TRY_LEAVE, TryCatch #8 {Exception -> 0x03c9, all -> 0x03c4, blocks: (B:47:0x0103, B:49:0x0109, B:51:0x0118), top: B:152:0x0103 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0154  */
    /* JADX WARN: Code duplicated, block: B:57:0x0187 A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0194 A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0199  */
    /* JADX WARN: Code duplicated, block: B:63:0x01dd A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:67:0x0216 A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x021f A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0252 A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x02fc A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0302 A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0307  */
    /* JADX WARN: Code duplicated, block: B:79:0x030f A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:82:0x0318 A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x031e A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0323  */
    /* JADX WARN: Code duplicated, block: B:87:0x032e A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0337 A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0354 A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x036d A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0373 A[Catch: all -> 0x03ba, Exception -> 0x03c0, TryCatch #11 {Exception -> 0x03c0, all -> 0x03ba, blocks: (B:53:0x014e, B:55:0x0156, B:57:0x0187, B:59:0x0194, B:61:0x019a, B:63:0x01dd, B:65:0x01e3, B:67:0x0216, B:69:0x0223, B:70:0x024c, B:72:0x0252, B:74:0x02fc, B:76:0x0302, B:78:0x0308, B:80:0x0312, B:82:0x0318, B:84:0x031e, B:86:0x0324, B:88:0x0331, B:90:0x0337, B:91:0x033f, B:87:0x032e, B:79:0x030f, B:92:0x0344, B:94:0x0354, B:68:0x021f, B:95:0x036d, B:97:0x0373, B:101:0x0387, B:102:0x0388, B:103:0x0391), top: B:147:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0384 A[DONT_INVERT] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x03bc: MOVE (r6 I:??[long, double]) = (r20 I:??[long, double]), block:B:109:0x03bb */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x03c1: MOVE (r6 I:??[long, double]) = (r20 I:??[long, double]), block:B:111:0x03c1 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v10 */
    /* JADX WARN: Type inference failed for: r20v11 */
    /* JADX WARN: Type inference failed for: r20v12 */
    /* JADX WARN: Type inference failed for: r20v13 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5, types: [long] */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r20v7, types: [long] */
    /* JADX WARN: Type inference failed for: r20v8, types: [long] */
    /* JADX WARN: Type inference failed for: r20v9 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v14, types: [long] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [long] */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v4, types: [long] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r9v4, types: [com.magneticchen.daijishou.repositories.RetroAchievementsRepository] */
    public final Object refreshMyRetroAchievementsGameRecordByGameId(long j, Continuation<?> continuation) throws Throwable {
        C02511 c02511;
        long r6;
        Throwable th;
        RetroAchievementsManager retroAchievementsManager;
        long r7;
        MainCoroutineDispatcher main;
        AnonymousClass5 anonymousClass5;
        MainCoroutineDispatcher main2;
        AnonymousClass5 anonymousClass6;
        int i;
        long j2;
        MainCoroutineDispatcher main3;
        C02522 c02522;
        RetroAchievementsManager retroAchievementsManager2;
        long j3;
        int i2;
        RetroAchievementsManager retroAchievementsManager3;
        Object gameInfoAndUserProgress$default;
        int i3;
        NetworkResponse networkResponse;
        long j4 = 0L;
        long j5 = 0L;
        long r20 = 0L;
        ErrorResponse errorResponse;
        Throwable error;
        long r21;
        MainCoroutineDispatcher main4;
        AnonymousClass5 anonymousClass7;
        RetroAchievementsGameRecordEntity retroAchievementsGameRecordByUserIdAndGameIdStatically;
        long r22;
        GetGameInfoAndUserProgress.Response response;
        String guideUrl;
        String released;
        Date retroAchievementsDate;
        long id2;
        long j6;
        ArrayList arrayList;
        RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity;
        String dateEarnedHardcore;
        Date retroAchievementsDate2;
        String dateEarned;
        Date retroAchievementsDate3;
        String guideUrl2;
        if (continuation instanceof C02511) {
            c02511 = (C02511) continuation;
            r6 = -2147483648;
            r6 = -2147483648;
            if ((c02511.label & Integer.MIN_VALUE) != 0) {
                c02511.label -= Integer.MIN_VALUE;
            } else {
                c02511 = new C02511(continuation);
            }
        } else {
            c02511 = new C02511(continuation);
        }
        C02511 c02512 = c02511;
        Object retroInterface = c02512.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                switch (c02512.label) {
                    case 0:
                        ResultKt.throwOnFailure(retroInterface);
                        this.logger.debug(this, "refreshMyRetroAchievementsGameRecordByGameId");
                        if (this.refreshingGameIds.contains(Boxing.boxLong(j))) {
                            return Boxing.boxBoolean(false);
                        }
                        c02512.L$0 = this;
                        j2 = j;
                        c02512.J$0 = j2;
                        c02512.label = 1;
                        retroInterface = getRetroInterface(c02512);
                        if (retroInterface != coroutine_suspended) {
                            retroAchievementsManager = this;
                            if (((RetroInterface) retroInterface) == null) {
                                return Boxing.boxBoolean(false);
                            }
                            try {
                                retroAchievementsManager.refreshingGameIds.add(Boxing.boxLong(j2));
                                main3 = Dispatchers.getMain();
                                c02522 = retroAchievementsManager.new C02522(null);
                                c02512.L$0 = retroAchievementsManager;
                                c02512.J$0 = j2;
                                c02512.I$0 = 1;
                                c02512.label = 2;
                                if (BuildersKt.withContext(main3, c02522, c02512) != coroutine_suspended) {
                                    long j7 = j2;
                                    retroAchievementsManager2 = retroAchievementsManager;
                                    j3 = j7;
                                    i2 = 1;
                                    try {
                                        RetroInterface retroInterface2 = retroAchievementsManager2.retroInterface;
                                        Intrinsics.checkNotNull(retroInterface2);
                                        String str = retroAchievementsManager2.myUsername;
                                        Intrinsics.checkNotNull(str);
                                        c02512.L$0 = retroAchievementsManager2;
                                        c02512.J$0 = j3;
                                        c02512.I$0 = i2;
                                        c02512.label = 3;
                                        retroAchievementsManager3 = retroAchievementsManager2;
                                        try {
                                            gameInfoAndUserProgress$default = RetroInterface.DefaultImpls.getGameInfoAndUserProgress$default(retroInterface2, str, j3, 0, c02512, 4, null);
                                            if (gameInfoAndUserProgress$default != coroutine_suspended) {
                                                i3 = i2;
                                                retroInterface = gameInfoAndUserProgress$default;
                                                r6 = j3;
                                                retroAchievementsManager = retroAchievementsManager3;
                                                try {
                                                    networkResponse = (NetworkResponse) retroInterface;
                                                    try {
                                                        if (networkResponse instanceof NetworkResponse.Success) {
                                                            RetroAchievementsRepository retroAchievementsRepository = retroAchievementsManager.getRetroAchievementsRepository();
                                                            String str2 = retroAchievementsManager.myUsername;
                                                            Intrinsics.checkNotNull(str2);
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically = retroAchievementsRepository.getRetroAchievementsGameRecordByUserIdAndGameIdStatically(str2, r6);
                                                            if (retroAchievementsGameRecordByUserIdAndGameIdStatically == null) {
                                                                String str3 = retroAchievementsManager.myUsername;
                                                                Intrinsics.checkNotNull(str3);
                                                                long r23 = r6;
                                                                retroAchievementsGameRecordByUserIdAndGameIdStatically = new RetroAchievementsGameRecordEntity(0L, str3, r23, null, null, null, null, null, null, null, null, 0, 0, 0L, 0L, 0L, null, null, 0, 0, null, 2097145, null);
                                                                r22 = r23;
                                                            } else {
                                                                r22 = r6;
                                                            }
                                                            response = (GetGameInfoAndUserProgress.Response) ((NetworkResponse.Success) networkResponse).getBody();
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setName(response.getTitle());
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setGameId(response.getId());
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setImageUrl("https://retroachievements.org" + response.getImageIcon());
                                                            if (response.getGuideUrl() != null) {
                                                                guideUrl2 = response.getGuideUrl();
                                                                Intrinsics.checkNotNull(guideUrl2);
                                                                if (guideUrl2.length() > 0) {
                                                                    guideUrl = response.getGuideUrl();
                                                                } else {
                                                                    guideUrl = null;
                                                                }
                                                            } else {
                                                                guideUrl = null;
                                                            }
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setGuideUrl(guideUrl);
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setForumTopicId(Boxing.boxInt(response.getForumTopicId()));
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setConsoleId(Boxing.boxLong(response.getConsoleId()));
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setConsoleName(response.getConsoleName());
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setTotalPlayerCount(response.getPlayersTotal());
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setDistinctPlayerCount(response.getNumDistinctPlayers());
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setDistinctCasualPlayerCount(response.getNumDistinctPlayersCasual());
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setDistinctHardcorePlayerCount(response.getNumDistinctPlayersHardcore());
                                                            released = response.getReleased();
                                                            if (released != null) {
                                                                retroAchievementsDate = retroAchievementsManager.toRetroAchievementsDate(released);
                                                            } else {
                                                                retroAchievementsDate = null;
                                                            }
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setReleasedDate(retroAchievementsDate);
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setAchievementsCount(response.getNumAchievements());
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setUnlockedAchievementsCount(0);
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setUrl("https://retroachievements.org/game/" + response.getId());
                                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setLastUpdatedTimestamp(new Date());
                                                            if (retroAchievementsGameRecordByUserIdAndGameIdStatically.getId() == 0) {
                                                                id2 = retroAchievementsManager.getRetroAchievementsRepository().addRetroAchievementsGameRecord(retroAchievementsGameRecordByUserIdAndGameIdStatically);
                                                            } else {
                                                                id2 = retroAchievementsGameRecordByUserIdAndGameIdStatically.getId();
                                                            }
                                                            j6 = id2;
                                                            arrayList = new ArrayList();
                                                            Collection<GetGameInfoAndUserProgress.Response.Achievement> collectionValues = response.getAchievements().values();
                                                            Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
                                                            for (GetGameInfoAndUserProgress.Response.Achievement achievement : (List<GetGameInfoAndUserProgress.Response.Achievement>) (List) CollectionsKt.<GetGameInfoAndUserProgress.Response.Achievement>sortedWith(collectionValues, new RetroAchievementsManager$refreshMyRetroAchievementsGameRecordByGameId$$inlined$sortedBy$1())) {
                                                                retroAchievementsAchievementRecordEntity = new RetroAchievementsAchievementRecordEntity(0L, j6, Long.parseLong(achievement.getId()), null, retroAchievementsManager.myUsername, 0, null, null, null, null, 0.0f, 0, 0L, 0L, false, false, null, 131049, null);
                                                                retroAchievementsAchievementRecordEntity.setGameId(Boxing.boxLong(r22));
                                                                retroAchievementsAchievementRecordEntity.setName(achievement.getTitle());
                                                                retroAchievementsAchievementRecordEntity.setImageUrl("https://media.retroachievements.org/Badge/" + achievement.getBadgeName() + ".png");
                                                                retroAchievementsAchievementRecordEntity.setPoints((int) achievement.getPoints());
                                                                retroAchievementsAchievementRecordEntity.setUserId(retroAchievementsManager.myUsername);
                                                                retroAchievementsAchievementRecordEntity.setUrl("https://retroachievements.org/achievement/" + achievement.getId());
                                                                retroAchievementsAchievementRecordEntity.setDescription(achievement.getDescription());
                                                                retroAchievementsAchievementRecordEntity.setUnlockedPlayerCount(achievement.getNumAwarded());
                                                                retroAchievementsAchievementRecordEntity.setUnlockedHardcorePlayerCount(achievement.getNumAwardedHardcore());
                                                                if (achievement.getDateEarned() != null) {
                                                                    dateEarned = achievement.getDateEarned();
                                                                    if (dateEarned != null) {
                                                                        retroAchievementsDate3 = retroAchievementsManager.toRetroAchievementsDate(dateEarned);
                                                                    } else {
                                                                        retroAchievementsDate3 = null;
                                                                    }
                                                                    retroAchievementsAchievementRecordEntity.setUnlocked(true);
                                                                    retroAchievementsAchievementRecordEntity.setUnlockedTimestamp(retroAchievementsDate3);
                                                                } else {
                                                                    retroAchievementsAchievementRecordEntity.setUnlocked(false);
                                                                }
                                                                if (achievement.getDateEarnedHardcore() != null) {
                                                                    dateEarnedHardcore = achievement.getDateEarnedHardcore();
                                                                    if (dateEarnedHardcore != null) {
                                                                        retroAchievementsDate2 = retroAchievementsManager.toRetroAchievementsDate(dateEarnedHardcore);
                                                                    } else {
                                                                        retroAchievementsDate2 = null;
                                                                    }
                                                                    retroAchievementsAchievementRecordEntity.setHardcoreUnlocked(true);
                                                                    retroAchievementsAchievementRecordEntity.setUnlocked(true);
                                                                    retroAchievementsAchievementRecordEntity.setUnlockedTimestamp(retroAchievementsDate2);
                                                                } else {
                                                                    retroAchievementsAchievementRecordEntity.setHardcoreUnlocked(false);
                                                                }
                                                                if (retroAchievementsAchievementRecordEntity.isUnlocked()) {
                                                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setUnlockedAchievementsCount(retroAchievementsGameRecordByUserIdAndGameIdStatically.getUnlockedAchievementsCount() + 1);
                                                                }
                                                                arrayList.add(retroAchievementsAchievementRecordEntity);
                                                            }
                                                            retroAchievementsManager.getRetroAchievementsRepository().updateRetroAchievementsGameRecord(retroAchievementsGameRecordByUserIdAndGameIdStatically);
                                                            r21 = r22;
                                                            if (!arrayList.isEmpty()) {
                                                                RetroAchievementsRepository retroAchievementsRepository2 = retroAchievementsManager.getRetroAchievementsRepository();
                                                                RetroAchievementsAchievementRecordEntity[] retroAchievementsAchievementRecordEntityArr = (RetroAchievementsAchievementRecordEntity[]) arrayList.toArray(new RetroAchievementsAchievementRecordEntity[0]);
                                                                retroAchievementsRepository2.addRetroAchievementsAchievementRecords((RetroAchievementsAchievementRecordEntity[]) Arrays.copyOf(retroAchievementsAchievementRecordEntityArr, retroAchievementsAchievementRecordEntityArr.length));
                                                                r21 = r22;
                                                            }
                                                        } else {
                                                            r20 = r6;
                                                            if (networkResponse instanceof NetworkResponse.Error) {
                                                                errorResponse = (ErrorResponse) ((NetworkResponse.Error) networkResponse).getBody();
                                                                error = ((NetworkResponse.Error) networkResponse).getError();
                                                                if (errorResponse == null) {
                                                                    r21 = r20;
                                                                    throw new Exception(errorResponse.getMessage());
                                                                }
                                                                if (error == null) {
                                                                    throw error;
                                                                }
                                                                r21 = r20;
                                                            }
                                                        }
                                                        r21 = r20;
                                                        retroAchievementsManager.refreshingGameIds.remove(Boxing.boxLong(r21));
                                                        main4 = Dispatchers.getMain();
                                                        anonymousClass7 = retroAchievementsManager.new AnonymousClass5(null);
                                                        c02512.L$0 = null;
                                                        c02512.I$0 = i3;
                                                        c02512.label = 4;
                                                        if (BuildersKt.withContext(main4, anonymousClass7, c02512) != coroutine_suspended) {
                                                            i = i3;
                                                            return Boxing.boxBoolean(i != 0);
                                                        }
                                                    } catch (Exception e) {
                                                        e = e;
                                                        r6 = j5;
                                                        retroAchievementsManager.logger.warn(retroAchievementsManager, ExceptionsKt.stackTraceToString(e));
                                                        retroAchievementsManager.refreshingGameIds.remove(Boxing.boxLong(r6));
                                                        main2 = Dispatchers.getMain();
                                                        anonymousClass6 = retroAchievementsManager.new AnonymousClass5(null);
                                                        c02512.L$0 = null;
                                                        c02512.I$0 = 0;
                                                        c02512.label = 5;
                                                        if (BuildersKt.withContext(main2, anonymousClass6, c02512) != coroutine_suspended) {
                                                            i = 0;
                                                        }
                                                        return coroutine_suspended;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        r7 = j4;
                                                        retroAchievementsManager.refreshingGameIds.remove(Boxing.boxLong(r7));
                                                        main = Dispatchers.getMain();
                                                        anonymousClass5 = retroAchievementsManager.new AnonymousClass5(null);
                                                        c02512.L$0 = th;
                                                        c02512.label = 6;
                                                        if (BuildersKt.withContext(main, anonymousClass5, c02512) != coroutine_suspended) {
                                                            throw th;
                                                        }
                                                    }
                                                } catch (Exception e2) {
                                                    Exception e = null;
                                                    e = e2;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    th = th;
                                                    r7 = r6;
                                                    retroAchievementsManager.refreshingGameIds.remove(Boxing.boxLong(r7));
                                                    main = Dispatchers.getMain();
                                                    anonymousClass5 = retroAchievementsManager.new AnonymousClass5(null);
                                                    c02512.L$0 = th;
                                                    c02512.label = 6;
                                                    if (BuildersKt.withContext(main, anonymousClass5, c02512) != coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    throw th;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            Exception e = null;
                                            e = e3;
                                            r6 = j3;
                                            retroAchievementsManager = retroAchievementsManager3;
                                            retroAchievementsManager.logger.warn(retroAchievementsManager, ExceptionsKt.stackTraceToString(e));
                                            retroAchievementsManager.refreshingGameIds.remove(Boxing.boxLong(r6));
                                            main2 = Dispatchers.getMain();
                                            anonymousClass6 = retroAchievementsManager.new AnonymousClass5(null);
                                            c02512.L$0 = null;
                                            c02512.I$0 = 0;
                                            c02512.label = 5;
                                            if (BuildersKt.withContext(main2, anonymousClass6, c02512) != coroutine_suspended) {
                                                i = 0;
                                                return Boxing.boxBoolean(i != 0);
                                            }
                                            return coroutine_suspended;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            th = th;
                                            r7 = j3;
                                            retroAchievementsManager = retroAchievementsManager3;
                                            retroAchievementsManager.refreshingGameIds.remove(Boxing.boxLong(r7));
                                            main = Dispatchers.getMain();
                                            anonymousClass5 = retroAchievementsManager.new AnonymousClass5(null);
                                            c02512.L$0 = th;
                                            c02512.label = 6;
                                            if (BuildersKt.withContext(main, anonymousClass5, c02512) != coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e4) {
                                        Exception e = null;
                                        e = e4;
                                        retroAchievementsManager3 = retroAchievementsManager2;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        retroAchievementsManager3 = retroAchievementsManager2;
                                    }
                                }
                            } catch (Exception e5) {
                                Exception e = null;
                                e = e5;
                                r6 = j2;
                                retroAchievementsManager.logger.warn(retroAchievementsManager, ExceptionsKt.stackTraceToString(e));
                                retroAchievementsManager.refreshingGameIds.remove(Boxing.boxLong(r6));
                                main2 = Dispatchers.getMain();
                                anonymousClass6 = retroAchievementsManager.new AnonymousClass5(null);
                                c02512.L$0 = null;
                                c02512.I$0 = 0;
                                c02512.label = 5;
                                if (BuildersKt.withContext(main2, anonymousClass6, c02512) != coroutine_suspended) {
                                    i = 0;
                                    return Boxing.boxBoolean(i != 0);
                                }
                                return coroutine_suspended;
                            } catch (Throwable th6) {
                                th = th6;
                                r7 = j2;
                                retroAchievementsManager.refreshingGameIds.remove(Boxing.boxLong(r7));
                                main = Dispatchers.getMain();
                                anonymousClass5 = retroAchievementsManager.new AnonymousClass5(null);
                                c02512.L$0 = th;
                                c02512.label = 6;
                                if (BuildersKt.withContext(main, anonymousClass5, c02512) != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                throw th;
                            }
                        }
                        return coroutine_suspended;
                    case 1:
                        j2 = c02512.J$0;
                        RetroAchievementsManager retroAchievementsManager4 = (RetroAchievementsManager) c02512.L$0;
                        ResultKt.throwOnFailure(retroInterface);
                        retroAchievementsManager = retroAchievementsManager4;
                        if (((RetroInterface) retroInterface) == null) {
                            return Boxing.boxBoolean(false);
                        }
                        retroAchievementsManager.refreshingGameIds.add(Boxing.boxLong(j2));
                        main3 = Dispatchers.getMain();
                        c02522 = retroAchievementsManager.new C02522(null);
                        c02512.L$0 = retroAchievementsManager;
                        c02512.J$0 = j2;
                        c02512.I$0 = 1;
                        c02512.label = 2;
                        if (BuildersKt.withContext(main3, c02522, c02512) != coroutine_suspended) {
                            long j8 = j2;
                            retroAchievementsManager2 = retroAchievementsManager;
                            j3 = j8;
                            i2 = 1;
                            RetroInterface retroInterface3 = retroAchievementsManager2.retroInterface;
                            Intrinsics.checkNotNull(retroInterface3);
                            String str4 = retroAchievementsManager2.myUsername;
                            Intrinsics.checkNotNull(str4);
                            c02512.L$0 = retroAchievementsManager2;
                            c02512.J$0 = j3;
                            c02512.I$0 = i2;
                            c02512.label = 3;
                            retroAchievementsManager3 = retroAchievementsManager2;
                            gameInfoAndUserProgress$default = RetroInterface.DefaultImpls.getGameInfoAndUserProgress$default(retroInterface3, str4, j3, 0, c02512, 4, null);
                            if (gameInfoAndUserProgress$default != coroutine_suspended) {
                                i3 = i2;
                                retroInterface = gameInfoAndUserProgress$default;
                                r6 = j3;
                                retroAchievementsManager = retroAchievementsManager3;
                                networkResponse = (NetworkResponse) retroInterface;
                                if (networkResponse instanceof NetworkResponse.Success) {
                                    RetroAchievementsRepository retroAchievementsRepository3 = retroAchievementsManager.getRetroAchievementsRepository();
                                    String str5 = retroAchievementsManager.myUsername;
                                    Intrinsics.checkNotNull(str5);
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically = retroAchievementsRepository3.getRetroAchievementsGameRecordByUserIdAndGameIdStatically(str5, r6);
                                    if (retroAchievementsGameRecordByUserIdAndGameIdStatically == null) {
                                        String str6 = retroAchievementsManager.myUsername;
                                        Intrinsics.checkNotNull(str6);
                                        long r24 = r6;
                                        retroAchievementsGameRecordByUserIdAndGameIdStatically = new RetroAchievementsGameRecordEntity(0L, str6, r24, null, null, null, null, null, null, null, null, 0, 0, 0L, 0L, 0L, null, null, 0, 0, null, 2097145, null);
                                        r22 = r24;
                                    } else {
                                        r22 = r6;
                                    }
                                    response = (GetGameInfoAndUserProgress.Response) ((NetworkResponse.Success) networkResponse).getBody();
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setName(response.getTitle());
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setGameId(response.getId());
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setImageUrl("https://retroachievements.org" + response.getImageIcon());
                                    if (response.getGuideUrl() != null) {
                                        guideUrl2 = response.getGuideUrl();
                                        Intrinsics.checkNotNull(guideUrl2);
                                        if (guideUrl2.length() > 0) {
                                            guideUrl = response.getGuideUrl();
                                        } else {
                                            guideUrl = null;
                                        }
                                    } else {
                                        guideUrl = null;
                                    }
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setGuideUrl(guideUrl);
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setForumTopicId(Boxing.boxInt(response.getForumTopicId()));
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setConsoleId(Boxing.boxLong(response.getConsoleId()));
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setConsoleName(response.getConsoleName());
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setTotalPlayerCount(response.getPlayersTotal());
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setDistinctPlayerCount(response.getNumDistinctPlayers());
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setDistinctCasualPlayerCount(response.getNumDistinctPlayersCasual());
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setDistinctHardcorePlayerCount(response.getNumDistinctPlayersHardcore());
                                    released = response.getReleased();
                                    if (released != null) {
                                        retroAchievementsDate = retroAchievementsManager.toRetroAchievementsDate(released);
                                    } else {
                                        retroAchievementsDate = null;
                                    }
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setReleasedDate(retroAchievementsDate);
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setAchievementsCount(response.getNumAchievements());
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setUnlockedAchievementsCount(0);
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setUrl("https://retroachievements.org/game/" + response.getId());
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setLastUpdatedTimestamp(new Date());
                                    if (retroAchievementsGameRecordByUserIdAndGameIdStatically.getId() == 0) {
                                        id2 = retroAchievementsManager.getRetroAchievementsRepository().addRetroAchievementsGameRecord(retroAchievementsGameRecordByUserIdAndGameIdStatically);
                                    } else {
                                        id2 = retroAchievementsGameRecordByUserIdAndGameIdStatically.getId();
                                    }
                                    j6 = id2;
                                    arrayList = new ArrayList();
                                    Collection<GetGameInfoAndUserProgress.Response.Achievement> collectionValues2 = response.getAchievements().values();
                                    Intrinsics.checkNotNullExpressionValue(collectionValues2, "<get-values>(...)");
                                    Iterator achIter2 = collectionValues2.iterator();
                                    while (achIter2.hasNext()) {
                                        GetGameInfoAndUserProgress.Response.Achievement achievement2 = (GetGameInfoAndUserProgress.Response.Achievement) achIter2.next();
                                        retroAchievementsAchievementRecordEntity = new RetroAchievementsAchievementRecordEntity(0L, j6, Long.parseLong(achievement2.getId()), null, retroAchievementsManager.myUsername, 0, null, null, null, null, 0.0f, 0, 0L, 0L, false, false, null, 131049, null);
                                        retroAchievementsAchievementRecordEntity.setGameId(Boxing.boxLong(r22));
                                        retroAchievementsAchievementRecordEntity.setName(achievement2.getTitle());
                                        retroAchievementsAchievementRecordEntity.setImageUrl("https://media.retroachievements.org/Badge/" + achievement2.getBadgeName() + ".png");
                                        retroAchievementsAchievementRecordEntity.setPoints((int) achievement2.getPoints());
                                        retroAchievementsAchievementRecordEntity.setUserId(retroAchievementsManager.myUsername);
                                        retroAchievementsAchievementRecordEntity.setUrl("https://retroachievements.org/achievement/" + achievement2.getId());
                                        retroAchievementsAchievementRecordEntity.setDescription(achievement2.getDescription());
                                        retroAchievementsAchievementRecordEntity.setUnlockedPlayerCount(achievement2.getNumAwarded());
                                        retroAchievementsAchievementRecordEntity.setUnlockedHardcorePlayerCount(achievement2.getNumAwardedHardcore());
                                        if (achievement2.getDateEarned() != null) {
                                            dateEarned = achievement2.getDateEarned();
                                            if (dateEarned != null) {
                                                retroAchievementsDate3 = retroAchievementsManager.toRetroAchievementsDate(dateEarned);
                                            } else {
                                                retroAchievementsDate3 = null;
                                            }
                                            retroAchievementsAchievementRecordEntity.setUnlocked(true);
                                            retroAchievementsAchievementRecordEntity.setUnlockedTimestamp(retroAchievementsDate3);
                                        } else {
                                            retroAchievementsAchievementRecordEntity.setUnlocked(false);
                                        }
                                        if (achievement2.getDateEarnedHardcore() != null) {
                                            dateEarnedHardcore = achievement2.getDateEarnedHardcore();
                                            if (dateEarnedHardcore != null) {
                                                retroAchievementsDate2 = retroAchievementsManager.toRetroAchievementsDate(dateEarnedHardcore);
                                            } else {
                                                retroAchievementsDate2 = null;
                                            }
                                            retroAchievementsAchievementRecordEntity.setHardcoreUnlocked(true);
                                            retroAchievementsAchievementRecordEntity.setUnlocked(true);
                                            retroAchievementsAchievementRecordEntity.setUnlockedTimestamp(retroAchievementsDate2);
                                        } else {
                                            retroAchievementsAchievementRecordEntity.setHardcoreUnlocked(false);
                                        }
                                        if (retroAchievementsAchievementRecordEntity.isUnlocked()) {
                                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setUnlockedAchievementsCount(retroAchievementsGameRecordByUserIdAndGameIdStatically.getUnlockedAchievementsCount() + 1);
                                        }
                                        arrayList.add(retroAchievementsAchievementRecordEntity);
                                    }
                                    retroAchievementsManager.getRetroAchievementsRepository().updateRetroAchievementsGameRecord(retroAchievementsGameRecordByUserIdAndGameIdStatically);
                                    r21 = r22;
                                    if (!arrayList.isEmpty()) {
                                        RetroAchievementsRepository retroAchievementsRepository4 = retroAchievementsManager.getRetroAchievementsRepository();
                                        RetroAchievementsAchievementRecordEntity[] retroAchievementsAchievementRecordEntityArr2 = (RetroAchievementsAchievementRecordEntity[]) arrayList.toArray(new RetroAchievementsAchievementRecordEntity[0]);
                                        retroAchievementsRepository4.addRetroAchievementsAchievementRecords((RetroAchievementsAchievementRecordEntity[]) Arrays.copyOf(retroAchievementsAchievementRecordEntityArr2, retroAchievementsAchievementRecordEntityArr2.length));
                                        r21 = r22;
                                    }
                                } else {
                                    r20 = r6;
                                    if (networkResponse instanceof NetworkResponse.Error) {
                                        errorResponse = (ErrorResponse) ((NetworkResponse.Error) networkResponse).getBody();
                                        error = ((NetworkResponse.Error) networkResponse).getError();
                                        if (errorResponse == null) {
                                            r21 = r20;
                                            throw new Exception(errorResponse.getMessage());
                                        }
                                        if (error == null) {
                                            throw error;
                                        }
                                        r21 = r20;
                                    }
                                }
                                r21 = r20;
                                retroAchievementsManager.refreshingGameIds.remove(Boxing.boxLong(r21));
                                main4 = Dispatchers.getMain();
                                anonymousClass7 = retroAchievementsManager.new AnonymousClass5(null);
                                c02512.L$0 = null;
                                c02512.I$0 = i3;
                                c02512.label = 4;
                                if (BuildersKt.withContext(main4, anonymousClass7, c02512) != coroutine_suspended) {
                                    i = i3;
                                    return Boxing.boxBoolean(i != 0);
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 2:
                        int i4 = c02512.I$0;
                        long j9 = c02512.J$0;
                        RetroAchievementsManager retroAchievementsManager5 = (RetroAchievementsManager) c02512.L$0;
                        ResultKt.throwOnFailure(retroInterface);
                        i2 = i4;
                        retroAchievementsManager2 = retroAchievementsManager5;
                        j3 = j9;
                        RetroInterface retroInterface4 = retroAchievementsManager2.retroInterface;
                        Intrinsics.checkNotNull(retroInterface4);
                        String str7 = retroAchievementsManager2.myUsername;
                        Intrinsics.checkNotNull(str7);
                        c02512.L$0 = retroAchievementsManager2;
                        c02512.J$0 = j3;
                        c02512.I$0 = i2;
                        c02512.label = 3;
                        retroAchievementsManager3 = retroAchievementsManager2;
                        gameInfoAndUserProgress$default = RetroInterface.DefaultImpls.getGameInfoAndUserProgress$default(retroInterface4, str7, j3, 0, c02512, 4, null);
                        if (gameInfoAndUserProgress$default != coroutine_suspended) {
                            i3 = i2;
                            retroInterface = gameInfoAndUserProgress$default;
                            r6 = j3;
                            retroAchievementsManager = retroAchievementsManager3;
                            networkResponse = (NetworkResponse) retroInterface;
                            if (networkResponse instanceof NetworkResponse.Success) {
                                RetroAchievementsRepository retroAchievementsRepository5 = retroAchievementsManager.getRetroAchievementsRepository();
                                String str8 = retroAchievementsManager.myUsername;
                                Intrinsics.checkNotNull(str8);
                                retroAchievementsGameRecordByUserIdAndGameIdStatically = retroAchievementsRepository5.getRetroAchievementsGameRecordByUserIdAndGameIdStatically(str8, r6);
                                if (retroAchievementsGameRecordByUserIdAndGameIdStatically == null) {
                                    String str9 = retroAchievementsManager.myUsername;
                                    Intrinsics.checkNotNull(str9);
                                    long r25 = r6;
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically = new RetroAchievementsGameRecordEntity(0L, str9, r25, null, null, null, null, null, null, null, null, 0, 0, 0L, 0L, 0L, null, null, 0, 0, null, 2097145, null);
                                    r22 = r25;
                                } else {
                                    r22 = r6;
                                }
                                response = (GetGameInfoAndUserProgress.Response) ((NetworkResponse.Success) networkResponse).getBody();
                                retroAchievementsGameRecordByUserIdAndGameIdStatically.setName(response.getTitle());
                                retroAchievementsGameRecordByUserIdAndGameIdStatically.setGameId(response.getId());
                                retroAchievementsGameRecordByUserIdAndGameIdStatically.setImageUrl("https://retroachievements.org" + response.getImageIcon());
                                if (response.getGuideUrl() != null) {
                                    guideUrl2 = response.getGuideUrl();
                                    Intrinsics.checkNotNull(guideUrl2);
                                    if (guideUrl2.length() > 0) {
                                        guideUrl = response.getGuideUrl();
                                    } else {
                                        guideUrl = null;
                                    }
                                } else {
                                    guideUrl = null;
                                }
                                retroAchievementsGameRecordByUserIdAndGameIdStatically.setGuideUrl(guideUrl);
                                retroAchievementsGameRecordByUserIdAndGameIdStatically.setForumTopicId(Boxing.boxInt(response.getForumTopicId()));
                                retroAchievementsGameRecordByUserIdAndGameIdStatically.setConsoleId(Boxing.boxLong(response.getConsoleId()));
                                retroAchievementsGameRecordByUserIdAndGameIdStatically.setConsoleName(response.getConsoleName());
                                retroAchievementsGameRecordByUserIdAndGameIdStatically.setTotalPlayerCount(response.getPlayersTotal());
                                retroAchievementsGameRecordByUserIdAndGameIdStatically.setDistinctPlayerCount(response.getNumDistinctPlayers());
                                retroAchievementsGameRecordByUserIdAndGameIdStatically.setDistinctCasualPlayerCount(response.getNumDistinctPlayersCasual());
                                retroAchievementsGameRecordByUserIdAndGameIdStatically.setDistinctHardcorePlayerCount(response.getNumDistinctPlayersHardcore());
                                released = response.getReleased();
                                if (released != null) {
                                    retroAchievementsDate = retroAchievementsManager.toRetroAchievementsDate(released);
                                } else {
                                    retroAchievementsDate = null;
                                }
                                retroAchievementsGameRecordByUserIdAndGameIdStatically.setReleasedDate(retroAchievementsDate);
                                retroAchievementsGameRecordByUserIdAndGameIdStatically.setAchievementsCount(response.getNumAchievements());
                                retroAchievementsGameRecordByUserIdAndGameIdStatically.setUnlockedAchievementsCount(0);
                                retroAchievementsGameRecordByUserIdAndGameIdStatically.setUrl("https://retroachievements.org/game/" + response.getId());
                                retroAchievementsGameRecordByUserIdAndGameIdStatically.setLastUpdatedTimestamp(new Date());
                                if (retroAchievementsGameRecordByUserIdAndGameIdStatically.getId() == 0) {
                                    id2 = retroAchievementsManager.getRetroAchievementsRepository().addRetroAchievementsGameRecord(retroAchievementsGameRecordByUserIdAndGameIdStatically);
                                } else {
                                    id2 = retroAchievementsGameRecordByUserIdAndGameIdStatically.getId();
                                }
                                j6 = id2;
                                arrayList = new ArrayList();
                                Collection<GetGameInfoAndUserProgress.Response.Achievement> collectionValues3 = response.getAchievements().values();
                                Intrinsics.checkNotNullExpressionValue(collectionValues3, "<get-values>(...)");
                                Iterator achIter2 = collectionValues3.iterator();
                                while (achIter2.hasNext()) {
                                    GetGameInfoAndUserProgress.Response.Achievement achievement2 = (GetGameInfoAndUserProgress.Response.Achievement) achIter2.next();
                                    retroAchievementsAchievementRecordEntity = new RetroAchievementsAchievementRecordEntity(0L, j6, Long.parseLong(achievement2.getId()), null, retroAchievementsManager.myUsername, 0, null, null, null, null, 0.0f, 0, 0L, 0L, false, false, null, 131049, null);
                                    retroAchievementsAchievementRecordEntity.setGameId(Boxing.boxLong(r22));
                                    retroAchievementsAchievementRecordEntity.setName(achievement2.getTitle());
                                    retroAchievementsAchievementRecordEntity.setImageUrl("https://media.retroachievements.org/Badge/" + achievement2.getBadgeName() + ".png");
                                    retroAchievementsAchievementRecordEntity.setPoints((int) achievement2.getPoints());
                                    retroAchievementsAchievementRecordEntity.setUserId(retroAchievementsManager.myUsername);
                                    retroAchievementsAchievementRecordEntity.setUrl("https://retroachievements.org/achievement/" + achievement2.getId());
                                    retroAchievementsAchievementRecordEntity.setDescription(achievement2.getDescription());
                                    retroAchievementsAchievementRecordEntity.setUnlockedPlayerCount(achievement2.getNumAwarded());
                                    retroAchievementsAchievementRecordEntity.setUnlockedHardcorePlayerCount(achievement2.getNumAwardedHardcore());
                                    if (achievement2.getDateEarned() != null) {
                                        dateEarned = achievement2.getDateEarned();
                                        if (dateEarned != null) {
                                            retroAchievementsDate3 = retroAchievementsManager.toRetroAchievementsDate(dateEarned);
                                        } else {
                                            retroAchievementsDate3 = null;
                                        }
                                        retroAchievementsAchievementRecordEntity.setUnlocked(true);
                                        retroAchievementsAchievementRecordEntity.setUnlockedTimestamp(retroAchievementsDate3);
                                    } else {
                                        retroAchievementsAchievementRecordEntity.setUnlocked(false);
                                    }
                                    if (achievement2.getDateEarnedHardcore() != null) {
                                        dateEarnedHardcore = achievement2.getDateEarnedHardcore();
                                        if (dateEarnedHardcore != null) {
                                            retroAchievementsDate2 = retroAchievementsManager.toRetroAchievementsDate(dateEarnedHardcore);
                                        } else {
                                            retroAchievementsDate2 = null;
                                        }
                                        retroAchievementsAchievementRecordEntity.setHardcoreUnlocked(true);
                                        retroAchievementsAchievementRecordEntity.setUnlocked(true);
                                        retroAchievementsAchievementRecordEntity.setUnlockedTimestamp(retroAchievementsDate2);
                                    } else {
                                        retroAchievementsAchievementRecordEntity.setHardcoreUnlocked(false);
                                    }
                                    if (retroAchievementsAchievementRecordEntity.isUnlocked()) {
                                        retroAchievementsGameRecordByUserIdAndGameIdStatically.setUnlockedAchievementsCount(retroAchievementsGameRecordByUserIdAndGameIdStatically.getUnlockedAchievementsCount() + 1);
                                    }
                                    arrayList.add(retroAchievementsAchievementRecordEntity);
                                }
                                retroAchievementsManager.getRetroAchievementsRepository().updateRetroAchievementsGameRecord(retroAchievementsGameRecordByUserIdAndGameIdStatically);
                                r21 = r22;
                                if (!arrayList.isEmpty()) {
                                    RetroAchievementsRepository retroAchievementsRepository6 = retroAchievementsManager.getRetroAchievementsRepository();
                                    RetroAchievementsAchievementRecordEntity[] retroAchievementsAchievementRecordEntityArr3 = (RetroAchievementsAchievementRecordEntity[]) arrayList.toArray(new RetroAchievementsAchievementRecordEntity[0]);
                                    retroAchievementsRepository6.addRetroAchievementsAchievementRecords((RetroAchievementsAchievementRecordEntity[]) Arrays.copyOf(retroAchievementsAchievementRecordEntityArr3, retroAchievementsAchievementRecordEntityArr3.length));
                                    r21 = r22;
                                }
                            } else {
                                r20 = r6;
                                if (networkResponse instanceof NetworkResponse.Error) {
                                    errorResponse = (ErrorResponse) ((NetworkResponse.Error) networkResponse).getBody();
                                    error = ((NetworkResponse.Error) networkResponse).getError();
                                    if (errorResponse == null) {
                                        r21 = r20;
                                        throw new Exception(errorResponse.getMessage());
                                    }
                                    if (error == null) {
                                        throw error;
                                    }
                                    r21 = r20;
                                }
                            }
                            r21 = r20;
                            retroAchievementsManager.refreshingGameIds.remove(Boxing.boxLong(r21));
                            main4 = Dispatchers.getMain();
                            anonymousClass7 = retroAchievementsManager.new AnonymousClass5(null);
                            c02512.L$0 = null;
                            c02512.I$0 = i3;
                            c02512.label = 4;
                            if (BuildersKt.withContext(main4, anonymousClass7, c02512) != coroutine_suspended) {
                                i = i3;
                                return Boxing.boxBoolean(i != 0);
                            }
                        }
                        return coroutine_suspended;
                    case 3:
                        i3 = c02512.I$0;
                        long j10 = c02512.J$0;
                        retroAchievementsManager = (RetroAchievementsManager) c02512.L$0;
                        ResultKt.throwOnFailure(retroInterface);
                        r6 = j10;
                        networkResponse = (NetworkResponse) retroInterface;
                        if (networkResponse instanceof NetworkResponse.Success) {
                            RetroAchievementsRepository retroAchievementsRepository7 = retroAchievementsManager.getRetroAchievementsRepository();
                            String str10 = retroAchievementsManager.myUsername;
                            Intrinsics.checkNotNull(str10);
                            retroAchievementsGameRecordByUserIdAndGameIdStatically = retroAchievementsRepository7.getRetroAchievementsGameRecordByUserIdAndGameIdStatically(str10, r6);
                            if (retroAchievementsGameRecordByUserIdAndGameIdStatically == null) {
                                String str11 = retroAchievementsManager.myUsername;
                                Intrinsics.checkNotNull(str11);
                                long r26 = r6;
                                retroAchievementsGameRecordByUserIdAndGameIdStatically = new RetroAchievementsGameRecordEntity(0L, str11, r26, null, null, null, null, null, null, null, null, 0, 0, 0L, 0L, 0L, null, null, 0, 0, null, 2097145, null);
                                r22 = r26;
                            } else {
                                r22 = r6;
                            }
                            response = (GetGameInfoAndUserProgress.Response) ((NetworkResponse.Success) networkResponse).getBody();
                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setName(response.getTitle());
                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setGameId(response.getId());
                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setImageUrl("https://retroachievements.org" + response.getImageIcon());
                            if (response.getGuideUrl() != null) {
                                guideUrl2 = response.getGuideUrl();
                                Intrinsics.checkNotNull(guideUrl2);
                                if (guideUrl2.length() > 0) {
                                    guideUrl = response.getGuideUrl();
                                } else {
                                    guideUrl = null;
                                }
                            } else {
                                guideUrl = null;
                            }
                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setGuideUrl(guideUrl);
                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setForumTopicId(Boxing.boxInt(response.getForumTopicId()));
                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setConsoleId(Boxing.boxLong(response.getConsoleId()));
                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setConsoleName(response.getConsoleName());
                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setTotalPlayerCount(response.getPlayersTotal());
                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setDistinctPlayerCount(response.getNumDistinctPlayers());
                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setDistinctCasualPlayerCount(response.getNumDistinctPlayersCasual());
                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setDistinctHardcorePlayerCount(response.getNumDistinctPlayersHardcore());
                            released = response.getReleased();
                            if (released != null) {
                                retroAchievementsDate = retroAchievementsManager.toRetroAchievementsDate(released);
                            } else {
                                retroAchievementsDate = null;
                            }
                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setReleasedDate(retroAchievementsDate);
                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setAchievementsCount(response.getNumAchievements());
                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setUnlockedAchievementsCount(0);
                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setUrl("https://retroachievements.org/game/" + response.getId());
                            retroAchievementsGameRecordByUserIdAndGameIdStatically.setLastUpdatedTimestamp(new Date());
                            if (retroAchievementsGameRecordByUserIdAndGameIdStatically.getId() == 0) {
                                id2 = retroAchievementsManager.getRetroAchievementsRepository().addRetroAchievementsGameRecord(retroAchievementsGameRecordByUserIdAndGameIdStatically);
                            } else {
                                id2 = retroAchievementsGameRecordByUserIdAndGameIdStatically.getId();
                            }
                            j6 = id2;
                            arrayList = new ArrayList();
                            Collection<GetGameInfoAndUserProgress.Response.Achievement> collectionValues4 = response.getAchievements().values();
                            Intrinsics.checkNotNullExpressionValue(collectionValues4, "<get-values>(...)");
                            Iterator achIter2 = collectionValues4.iterator();
                            while (achIter2.hasNext()) {
                                GetGameInfoAndUserProgress.Response.Achievement achievement2 = (GetGameInfoAndUserProgress.Response.Achievement) achIter2.next();
                                retroAchievementsAchievementRecordEntity = new RetroAchievementsAchievementRecordEntity(0L, j6, Long.parseLong(achievement2.getId()), null, retroAchievementsManager.myUsername, 0, null, null, null, null, 0.0f, 0, 0L, 0L, false, false, null, 131049, null);
                                retroAchievementsAchievementRecordEntity.setGameId(Boxing.boxLong(r22));
                                retroAchievementsAchievementRecordEntity.setName(achievement2.getTitle());
                                retroAchievementsAchievementRecordEntity.setImageUrl("https://media.retroachievements.org/Badge/" + achievement2.getBadgeName() + ".png");
                                retroAchievementsAchievementRecordEntity.setPoints((int) achievement2.getPoints());
                                retroAchievementsAchievementRecordEntity.setUserId(retroAchievementsManager.myUsername);
                                retroAchievementsAchievementRecordEntity.setUrl("https://retroachievements.org/achievement/" + achievement2.getId());
                                retroAchievementsAchievementRecordEntity.setDescription(achievement2.getDescription());
                                retroAchievementsAchievementRecordEntity.setUnlockedPlayerCount(achievement2.getNumAwarded());
                                retroAchievementsAchievementRecordEntity.setUnlockedHardcorePlayerCount(achievement2.getNumAwardedHardcore());
                                if (achievement2.getDateEarned() != null) {
                                    dateEarned = achievement2.getDateEarned();
                                    if (dateEarned != null) {
                                        retroAchievementsDate3 = retroAchievementsManager.toRetroAchievementsDate(dateEarned);
                                    } else {
                                        retroAchievementsDate3 = null;
                                    }
                                    retroAchievementsAchievementRecordEntity.setUnlocked(true);
                                    retroAchievementsAchievementRecordEntity.setUnlockedTimestamp(retroAchievementsDate3);
                                } else {
                                    retroAchievementsAchievementRecordEntity.setUnlocked(false);
                                }
                                if (achievement2.getDateEarnedHardcore() != null) {
                                    dateEarnedHardcore = achievement2.getDateEarnedHardcore();
                                    if (dateEarnedHardcore != null) {
                                        retroAchievementsDate2 = retroAchievementsManager.toRetroAchievementsDate(dateEarnedHardcore);
                                    } else {
                                        retroAchievementsDate2 = null;
                                    }
                                    retroAchievementsAchievementRecordEntity.setHardcoreUnlocked(true);
                                    retroAchievementsAchievementRecordEntity.setUnlocked(true);
                                    retroAchievementsAchievementRecordEntity.setUnlockedTimestamp(retroAchievementsDate2);
                                } else {
                                    retroAchievementsAchievementRecordEntity.setHardcoreUnlocked(false);
                                }
                                if (retroAchievementsAchievementRecordEntity.isUnlocked()) {
                                    retroAchievementsGameRecordByUserIdAndGameIdStatically.setUnlockedAchievementsCount(retroAchievementsGameRecordByUserIdAndGameIdStatically.getUnlockedAchievementsCount() + 1);
                                }
                                arrayList.add(retroAchievementsAchievementRecordEntity);
                            }
                            retroAchievementsManager.getRetroAchievementsRepository().updateRetroAchievementsGameRecord(retroAchievementsGameRecordByUserIdAndGameIdStatically);
                            r21 = r22;
                            if (!arrayList.isEmpty()) {
                                RetroAchievementsRepository retroAchievementsRepository8 = retroAchievementsManager.getRetroAchievementsRepository();
                                RetroAchievementsAchievementRecordEntity[] retroAchievementsAchievementRecordEntityArr4 = (RetroAchievementsAchievementRecordEntity[]) arrayList.toArray(new RetroAchievementsAchievementRecordEntity[0]);
                                retroAchievementsRepository8.addRetroAchievementsAchievementRecords((RetroAchievementsAchievementRecordEntity[]) Arrays.copyOf(retroAchievementsAchievementRecordEntityArr4, retroAchievementsAchievementRecordEntityArr4.length));
                                r21 = r22;
                            }
                        } else {
                            r20 = r6;
                            if (networkResponse instanceof NetworkResponse.Error) {
                                errorResponse = (ErrorResponse) ((NetworkResponse.Error) networkResponse).getBody();
                                error = ((NetworkResponse.Error) networkResponse).getError();
                                if (errorResponse == null) {
                                    r21 = r20;
                                    throw new Exception(errorResponse.getMessage());
                                }
                                if (error == null) {
                                    throw error;
                                }
                                r21 = r20;
                            }
                        }
                        r21 = r20;
                        retroAchievementsManager.refreshingGameIds.remove(Boxing.boxLong(r21));
                        main4 = Dispatchers.getMain();
                        anonymousClass7 = retroAchievementsManager.new AnonymousClass5(null);
                        c02512.L$0 = null;
                        c02512.I$0 = i3;
                        c02512.label = 4;
                        if (BuildersKt.withContext(main4, anonymousClass7, c02512) != coroutine_suspended) {
                            i = i3;
                            return Boxing.boxBoolean(i != 0);
                        }
                        return coroutine_suspended;
                    case 4:
                    case 5:
                        i = c02512.I$0;
                        ResultKt.throwOnFailure(retroInterface);
                        return Boxing.boxBoolean(i != 0);
                    case 6:
                        Throwable th7 = (Throwable) c02512.L$0;
                        ResultKt.throwOnFailure(retroInterface);
                        throw th7;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (Exception e6) {
            Exception e = null;
            e = e6;
        }
        return null;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshMyRetroAchievementsGameRecordByGameId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshMyRetroAchievementsGameRecordByGameId$2", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    final class C02522 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;

        C02522(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new C02522(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    try {
                        return ((C02522) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
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
                RetroAchievementsManager.this.getRefreshingGameIdsLiveData().setValue(RetroAchievementsManager.this.refreshingGameIds);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshMyRetroAchievementsGameRecordByGameId$5, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshMyRetroAchievementsGameRecordByGameId$5", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    final class AnonymousClass5 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;

        AnonymousClass5(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    try {
                        return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
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
                RetroAchievementsManager.this.getRefreshingGameIdsLiveData().setValue(RetroAchievementsManager.this.refreshingGameIds);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:53:0x0100 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object refreshMyRetroAchievementsAwardsIfExpired(Continuation<?> continuation) throws Throwable {
        C02501 c02501;
        RetroAchievementsManager retroAchievementsManager;
        Date lastUpdatedTimestamp;
        String str;
        Object objRefreshRetroAchievementsAwardsByUserId;
        if (continuation instanceof C02501) {
            c02501 = (C02501) continuation;
            if ((c02501.label & Integer.MIN_VALUE) != 0) {
                c02501.label -= Integer.MIN_VALUE;
            } else {
                c02501 = new C02501(continuation);
            }
        } else {
            c02501 = new C02501(continuation);
        }
        Object retroInterface = c02501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02501.label;
        if (i == 0) {
            ResultKt.throwOnFailure(retroInterface);
            c02501.L$0 = this;
            c02501.label = 1;
            retroInterface = getRetroInterface(c02501);
            if (retroInterface == coroutine_suspended) {
                return coroutine_suspended;
            }
            retroAchievementsManager = this;
        } else if (i == 1) {
            retroAchievementsManager = (RetroAchievementsManager) c02501.L$0;
            ResultKt.throwOnFailure(retroInterface);
        } else if (i == 2) {
            retroAchievementsManager = (RetroAchievementsManager) c02501.L$0;
            ResultKt.throwOnFailure(retroInterface);
            str = (String) retroInterface;
            if (str == null) {
                return Boxing.boxBoolean(false);
            }
            c02501.L$0 = null;
            c02501.label = 3;
            objRefreshRetroAchievementsAwardsByUserId = retroAchievementsManager.refreshRetroAchievementsAwardsByUserId(str, c02501);
            if (objRefreshRetroAchievementsAwardsByUserId == coroutine_suspended) {
                return coroutine_suspended;
            }
            return objRefreshRetroAchievementsAwardsByUserId;
        } else {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(retroInterface);
            return retroInterface;
        }
        if (retroInterface == null) {
            return Boxing.boxBoolean(false);
        }
        RetroAchievementsRepository retroAchievementsRepository = retroAchievementsManager.getRetroAchievementsRepository();
        String str2 = retroAchievementsManager.myUsername;
        Intrinsics.checkNotNull(str2);
        RetroAchievementsUserAwardEntity retroAchievementsUserAwardEntity = (RetroAchievementsUserAwardEntity) CollectionsKt.getOrNull(retroAchievementsRepository.getRetroAchievementsUserAwardsByUserIdStatically(str2), 0);
        Long lBoxLong = (retroAchievementsUserAwardEntity == null || (lastUpdatedTimestamp = retroAchievementsUserAwardEntity.getLastUpdatedTimestamp()) == null) ? null : Boxing.boxLong(lastUpdatedTimestamp.getTime());
        if (lBoxLong != null && lBoxLong.longValue() + ((long) 480000) > System.currentTimeMillis()) {
            return Boxing.boxBoolean(false);
        }
        retroAchievementsManager.logger.debug(retroAchievementsManager, "refreshMyRetroAchievementsAwardsExpired (Expired). Current: " + System.currentTimeMillis() + ", Last Updated: " + lBoxLong + ", Expire: " + (lBoxLong != null ? Boxing.boxLong(lBoxLong.longValue() + ((long) 480000)) : "None"));
        c02501.L$0 = retroAchievementsManager;
        c02501.label = 2;
        retroInterface = retroAchievementsManager.getMyRetroAchievementsUsername(c02501);
        if (retroInterface == coroutine_suspended) {
            return coroutine_suspended;
        }
        str = (String) retroInterface;
        if (str == null) {
            return Boxing.boxBoolean(false);
        }
        c02501.L$0 = null;
        c02501.label = 3;
        objRefreshRetroAchievementsAwardsByUserId = retroAchievementsManager.refreshRetroAchievementsAwardsByUserId(str, c02501);
        if (objRefreshRetroAchievementsAwardsByUserId == coroutine_suspended) {
            return coroutine_suspended;
        }
        return objRefreshRetroAchievementsAwardsByUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x00ac A[Catch: all -> 0x01a7, Exception -> 0x01aa, TryCatch #6 {Exception -> 0x01aa, all -> 0x01a7, blocks: (B:38:0x00a6, B:40:0x00ac, B:41:0x00ca, B:43:0x00d0, B:44:0x015e, B:45:0x017e, B:47:0x0182, B:51:0x0196, B:52:0x0197, B:53:0x01a0), top: B:75:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00d0 A[Catch: all -> 0x01a7, Exception -> 0x01aa, LOOP:0: B:41:0x00ca->B:43:0x00d0, LOOP_END, TryCatch #6 {Exception -> 0x01aa, all -> 0x01a7, blocks: (B:38:0x00a6, B:40:0x00ac, B:41:0x00ca, B:43:0x00d0, B:44:0x015e, B:45:0x017e, B:47:0x0182, B:51:0x0196, B:52:0x0197, B:53:0x01a0), top: B:75:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x017e A[Catch: all -> 0x01a7, Exception -> 0x01aa, TryCatch #6 {Exception -> 0x01aa, all -> 0x01a7, blocks: (B:38:0x00a6, B:40:0x00ac, B:41:0x00ca, B:43:0x00d0, B:44:0x015e, B:45:0x017e, B:47:0x0182, B:51:0x0196, B:52:0x0197, B:53:0x01a0), top: B:75:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0182 A[Catch: all -> 0x01a7, Exception -> 0x01aa, TryCatch #6 {Exception -> 0x01aa, all -> 0x01a7, blocks: (B:38:0x00a6, B:40:0x00ac, B:41:0x00ca, B:43:0x00d0, B:44:0x015e, B:45:0x017e, B:47:0x0182, B:51:0x0196, B:52:0x0197, B:53:0x01a0), top: B:75:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0193 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x0195  */
    /* JADX WARN: Code duplicated, block: B:51:0x0196 A[Catch: all -> 0x01a7, Exception -> 0x01aa, TryCatch #6 {Exception -> 0x01aa, all -> 0x01a7, blocks: (B:38:0x00a6, B:40:0x00ac, B:41:0x00ca, B:43:0x00d0, B:44:0x015e, B:45:0x017e, B:47:0x0182, B:51:0x0196, B:52:0x0197, B:53:0x01a0), top: B:75:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0197 A[Catch: all -> 0x01a7, Exception -> 0x01aa, TryCatch #6 {Exception -> 0x01aa, all -> 0x01a7, blocks: (B:38:0x00a6, B:40:0x00ac, B:41:0x00ca, B:43:0x00d0, B:44:0x015e, B:45:0x017e, B:47:0x0182, B:51:0x0196, B:52:0x0197, B:53:0x01a0), top: B:75:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsAwardsByUserId$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object refreshRetroAchievementsAwardsByUserId(String str, Continuation<?> continuation) throws Throwable {
        C02551 c02551;
        String str2;
        Object obj;
        RetroAchievementsManager retroAchievementsManager;
        String str3;
        String str4;
        int i;
        NetworkResponse networkResponse;
        ErrorResponse errorResponse;
        Throwable error;
        Date date;
        ArrayList arrayList;
        if (continuation instanceof C02551) {
            C02551 c02552 = (C02551) continuation;
            if ((c02552.label & Integer.MIN_VALUE) != 0) {
                c02552.label -= Integer.MIN_VALUE;
                c02551 = c02552;
            } else {
                c02551 = new C02551(continuation);
            }
        } else {
            c02551 = new C02551(continuation);
        }
        Object obj2 = c02551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02551.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj2);
                if (this.refreshMyRetroAchievementsAwardsUserId.contains(str)) {
                    return Boxing.boxBoolean(false);
                }
                c02551.L$0 = this;
                c02551.L$1 = str;
                c02551.label = 1;
                Object retroInterface = getRetroInterface(c02551);
                if (retroInterface != coroutine_suspended) {
                    str2 = str;
                    obj = retroInterface;
                    retroAchievementsManager = this;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = c02551.I$0;
                str3 = (String) c02551.L$1;
                retroAchievementsManager = (RetroAchievementsManager) c02551.L$0;
                try {
                    ResultKt.throwOnFailure(obj2);
                    str4 = str3;
                    ;
                    try {
                        networkResponse = (NetworkResponse) obj2;
                        if (networkResponse instanceof NetworkResponse.Success) {
                            GetUserAwards.Response response = (GetUserAwards.Response) ((NetworkResponse.Success) networkResponse).getBody();
                            date = new Date();
                            arrayList = new ArrayList();
                            for (GetUserAwards.Response.Award award : response.getVisibleUserAwards()) {
                                RetroAchievementsUserAwardEntity retroAchievementsUserAwardEntity = new RetroAchievementsUserAwardEntity(0L, str4, award.getAwardType(), award.getAwardData(), null, null, 0, null, null, null, null, null, null, 8177, null);
                                retroAchievementsUserAwardEntity.setAwardDataExtra(Boxing.boxInt(award.getAwardDataExtra()));
                                retroAchievementsUserAwardEntity.setAwardedAt(retroAchievementsManager.toRetroAchievementsDate(award.getAwardedAt()));
                                retroAchievementsUserAwardEntity.setDisplayOrder(award.getDisplayOrder());
                                retroAchievementsUserAwardEntity.setTitle(award.getTitle());
                                retroAchievementsUserAwardEntity.setConsoleId(Boxing.boxLong(award.getConsoleId()));
                                retroAchievementsUserAwardEntity.setConsoleName(award.getConsoleName());
                                retroAchievementsUserAwardEntity.setFlags(Boxing.boxInt(award.getFlags()));
                                retroAchievementsUserAwardEntity.setImageUrl("https://retroachievements.org" + award.getImageIcon());
                                retroAchievementsUserAwardEntity.setLastUpdatedTimestamp(date);
                                arrayList.add(retroAchievementsUserAwardEntity);
                            }
                            retroAchievementsManager.getRetroAchievementsRepository().deleteRetroAchievementsUserAwardByUserId(str4);
                            RetroAchievementsRepository retroAchievementsRepository = retroAchievementsManager.getRetroAchievementsRepository();
                            RetroAchievementsUserAwardEntity[] retroAchievementsUserAwardEntityArr = (RetroAchievementsUserAwardEntity[]) arrayList.toArray(new RetroAchievementsUserAwardEntity[0]);
                            retroAchievementsRepository.addRetroAchievementsUserAwards((RetroAchievementsUserAwardEntity[]) Arrays.copyOf(retroAchievementsUserAwardEntityArr, retroAchievementsUserAwardEntityArr.length));
                        } else if (networkResponse instanceof NetworkResponse.Error) {
                            errorResponse = (ErrorResponse) ((NetworkResponse.Error) networkResponse).getBody();
                            error = ((NetworkResponse.Error) networkResponse).getError();
                            if (errorResponse == null) {
                                throw new Exception(errorResponse.getMessage());
                            }
                            if (error == null) {
                                throw error;
                            }
                        }
                        retroAchievementsManager.refreshMyRetroAchievementsAwardsUserId.remove(str4);
                    } catch (Exception e) {
                        e = e;
                        str3 = str4;
                        retroAchievementsManager.logger.warn(retroAchievementsManager, ExceptionsKt.stackTraceToString(e));
                        retroAchievementsManager.refreshMyRetroAchievementsAwardsUserId.remove(str3);
                        i = 0;
                    } catch (Throwable th) {
                        th = th;
                        coroutine_suspended = str4;
                        retroAchievementsManager.refreshMyRetroAchievementsAwardsUserId.remove(coroutine_suspended);
                        throw th;
                    }
                } catch (Exception e2) {
                    Exception e = null;
                    e = e2;
                    retroAchievementsManager.logger.warn(retroAchievementsManager, ExceptionsKt.stackTraceToString(e));
                    retroAchievementsManager.refreshMyRetroAchievementsAwardsUserId.remove(str3);
                    i = 0;
                    return Boxing.boxBoolean(i != 0);
                }
                return Boxing.boxBoolean(i != 0);
            }
            String str5 = (String) c02551.L$1;
            RetroAchievementsManager retroAchievementsManager2 = (RetroAchievementsManager) c02551.L$0;
            ResultKt.throwOnFailure(obj2);
            str2 = str5;
            obj = obj2;
            retroAchievementsManager = retroAchievementsManager2;
            if (((RetroInterface) obj) == null) {
                return Boxing.boxBoolean(false);
            }
            try {
                retroAchievementsManager.refreshMyRetroAchievementsAwardsUserId.add(str2);
                RetroInterface retroInterface2 = retroAchievementsManager.retroInterface;
                Intrinsics.checkNotNull(retroInterface2);
                c02551.L$0 = retroAchievementsManager2;
                c02551.L$1 = str2;
                c02551.I$0 = 1;
                c02551.label = 2;
                Object userAwards = retroInterface2.getUserAwards(str2, c02551);
                if (userAwards != coroutine_suspended) {
                    str4 = str2;
                    retroAchievementsManager = retroAchievementsManager2;
                    obj2 = userAwards;
                    i = 1;
                    networkResponse = (NetworkResponse) obj2;
                    if (networkResponse instanceof NetworkResponse.Success) {
                        GetUserAwards.Response response2 = (GetUserAwards.Response) ((NetworkResponse.Success) networkResponse).getBody();
                        date = new Date();
                        arrayList = new ArrayList();
                        Iterator awardIter2 = response2.getVisibleUserAwards().iterator();
                        while (awardIter2.hasNext()) {
                            org.retroachivements.api.data.pojo.user.GetUserAwards.Response.Award award2 = (org.retroachivements.api.data.pojo.user.GetUserAwards.Response.Award) awardIter2.next();
                            RetroAchievementsUserAwardEntity retroAchievementsUserAwardEntity2 = new RetroAchievementsUserAwardEntity(0L, str4, award2.getAwardType(), award2.getAwardData(), null, null, 0, null, null, null, null, null, null, 8177, null);
                            retroAchievementsUserAwardEntity2.setAwardDataExtra(Boxing.boxInt(award2.getAwardDataExtra()));
                            retroAchievementsUserAwardEntity2.setAwardedAt(retroAchievementsManager.toRetroAchievementsDate(award2.getAwardedAt()));
                            retroAchievementsUserAwardEntity2.setDisplayOrder(award2.getDisplayOrder());
                            retroAchievementsUserAwardEntity2.setTitle(award2.getTitle());
                            retroAchievementsUserAwardEntity2.setConsoleId(Boxing.boxLong(award2.getConsoleId()));
                            retroAchievementsUserAwardEntity2.setConsoleName(award2.getConsoleName());
                            retroAchievementsUserAwardEntity2.setFlags(Boxing.boxInt(award2.getFlags()));
                            retroAchievementsUserAwardEntity2.setImageUrl("https://retroachievements.org" + award2.getImageIcon());
                            retroAchievementsUserAwardEntity2.setLastUpdatedTimestamp(date);
                            arrayList.add(retroAchievementsUserAwardEntity2);
                        }
                        retroAchievementsManager.getRetroAchievementsRepository().deleteRetroAchievementsUserAwardByUserId(str4);
                        RetroAchievementsRepository retroAchievementsRepository2 = retroAchievementsManager.getRetroAchievementsRepository();
                        RetroAchievementsUserAwardEntity[] retroAchievementsUserAwardEntityArr2 = (RetroAchievementsUserAwardEntity[]) arrayList.toArray(new RetroAchievementsUserAwardEntity[0]);
                        retroAchievementsRepository2.addRetroAchievementsUserAwards((RetroAchievementsUserAwardEntity[]) Arrays.copyOf(retroAchievementsUserAwardEntityArr2, retroAchievementsUserAwardEntityArr2.length));
                    } else if (networkResponse instanceof NetworkResponse.Error) {
                        errorResponse = (ErrorResponse) ((NetworkResponse.Error) networkResponse).getBody();
                        error = ((NetworkResponse.Error) networkResponse).getError();
                        if (errorResponse == null) {
                            throw new Exception(errorResponse.getMessage());
                        }
                        if (error == null) {
                            throw error;
                        }
                    }
                    retroAchievementsManager.refreshMyRetroAchievementsAwardsUserId.remove(str4);
                    return Boxing.boxBoolean(i != 0);
                }
                return coroutine_suspended;
            } catch (Exception e3) {
                Exception e = null;
                e = e3;
                str3 = str2;
                retroAchievementsManager.logger.warn(retroAchievementsManager, ExceptionsKt.stackTraceToString(e));
                retroAchievementsManager.refreshMyRetroAchievementsAwardsUserId.remove(str3);
                i = 0;
                return Boxing.boxBoolean(i != 0);
            } catch (Throwable th2) {
                Throwable th = null;
                th = th2;
                coroutine_suspended = str2;
                retroAchievementsManager.refreshMyRetroAchievementsAwardsUserId.remove(coroutine_suspended);
                throw th;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d8, code lost:
    
        if (r2.refreshRetroAchievementsUserProfileData(r14, r0) == r1) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refreshRetroAchievementsUserProfileDataIfExpired(java.lang.String r14, kotlin.coroutines.Continuation<?> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager.refreshRetroAchievementsUserProfileDataIfExpired(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0303 A[Catch: all -> 0x04b0, Exception -> 0x04b4, TryCatch #10 {Exception -> 0x04b4, all -> 0x04b0, blocks: (B:89:0x0232, B:91:0x0238, B:92:0x0247, B:94:0x024d, B:96:0x0267, B:97:0x02a4, B:108:0x0323, B:99:0x02fe, B:101:0x0303, B:105:0x0318, B:106:0x0319, B:107:0x0322, B:63:0x0148, B:65:0x0154, B:73:0x018c, B:75:0x0190, B:85:0x01ec, B:76:0x01c9, B:78:0x01cd, B:82:0x01e1, B:83:0x01e2, B:84:0x01eb), top: B:169:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x0315 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:104:0x0317  */
    /* JADX WARN: Code duplicated, block: B:105:0x0318 A[Catch: all -> 0x04b0, Exception -> 0x04b4, TryCatch #10 {Exception -> 0x04b4, all -> 0x04b0, blocks: (B:89:0x0232, B:91:0x0238, B:92:0x0247, B:94:0x024d, B:96:0x0267, B:97:0x02a4, B:108:0x0323, B:99:0x02fe, B:101:0x0303, B:105:0x0318, B:106:0x0319, B:107:0x0322, B:63:0x0148, B:65:0x0154, B:73:0x018c, B:75:0x0190, B:85:0x01ec, B:76:0x01c9, B:78:0x01cd, B:82:0x01e1, B:83:0x01e2, B:84:0x01eb), top: B:169:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x0319 A[Catch: all -> 0x04b0, Exception -> 0x04b4, TryCatch #10 {Exception -> 0x04b4, all -> 0x04b0, blocks: (B:89:0x0232, B:91:0x0238, B:92:0x0247, B:94:0x024d, B:96:0x0267, B:97:0x02a4, B:108:0x0323, B:99:0x02fe, B:101:0x0303, B:105:0x0318, B:106:0x0319, B:107:0x0322, B:63:0x0148, B:65:0x0154, B:73:0x018c, B:75:0x0190, B:85:0x01ec, B:76:0x01c9, B:78:0x01cd, B:82:0x01e1, B:83:0x01e2, B:84:0x01eb), top: B:169:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0342  */
    /* JADX WARN: Code duplicated, block: B:114:0x034c A[Catch: all -> 0x04aa, Exception -> 0x04ad, TryCatch #12 {Exception -> 0x04ad, all -> 0x04aa, blocks: (B:112:0x0346, B:114:0x034c, B:115:0x0371, B:117:0x0377, B:119:0x0390, B:120:0x03cd, B:130:0x0446, B:121:0x0423, B:123:0x0427, B:127:0x043b, B:128:0x043c, B:129:0x0445), top: B:167:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0377 A[Catch: all -> 0x04aa, Exception -> 0x04ad, TryCatch #12 {Exception -> 0x04ad, all -> 0x04aa, blocks: (B:112:0x0346, B:114:0x034c, B:115:0x0371, B:117:0x0377, B:119:0x0390, B:120:0x03cd, B:130:0x0446, B:121:0x0423, B:123:0x0427, B:127:0x043b, B:128:0x043c, B:129:0x0445), top: B:167:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0390 A[Catch: all -> 0x04aa, Exception -> 0x04ad, TryCatch #12 {Exception -> 0x04ad, all -> 0x04aa, blocks: (B:112:0x0346, B:114:0x034c, B:115:0x0371, B:117:0x0377, B:119:0x0390, B:120:0x03cd, B:130:0x0446, B:121:0x0423, B:123:0x0427, B:127:0x043b, B:128:0x043c, B:129:0x0445), top: B:167:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0423 A[Catch: all -> 0x04aa, Exception -> 0x04ad, TryCatch #12 {Exception -> 0x04ad, all -> 0x04aa, blocks: (B:112:0x0346, B:114:0x034c, B:115:0x0371, B:117:0x0377, B:119:0x0390, B:120:0x03cd, B:130:0x0446, B:121:0x0423, B:123:0x0427, B:127:0x043b, B:128:0x043c, B:129:0x0445), top: B:167:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0427 A[Catch: all -> 0x04aa, Exception -> 0x04ad, TryCatch #12 {Exception -> 0x04ad, all -> 0x04aa, blocks: (B:112:0x0346, B:114:0x034c, B:115:0x0371, B:117:0x0377, B:119:0x0390, B:120:0x03cd, B:130:0x0446, B:121:0x0423, B:123:0x0427, B:127:0x043b, B:128:0x043c, B:129:0x0445), top: B:167:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x0438 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:126:0x043a  */
    /* JADX WARN: Code duplicated, block: B:127:0x043b A[Catch: all -> 0x04aa, Exception -> 0x04ad, TryCatch #12 {Exception -> 0x04ad, all -> 0x04aa, blocks: (B:112:0x0346, B:114:0x034c, B:115:0x0371, B:117:0x0377, B:119:0x0390, B:120:0x03cd, B:130:0x0446, B:121:0x0423, B:123:0x0427, B:127:0x043b, B:128:0x043c, B:129:0x0445), top: B:167:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x043c A[Catch: all -> 0x04aa, Exception -> 0x04ad, TryCatch #12 {Exception -> 0x04ad, all -> 0x04aa, blocks: (B:112:0x0346, B:114:0x034c, B:115:0x0371, B:117:0x0377, B:119:0x0390, B:120:0x03cd, B:130:0x0446, B:121:0x0423, B:123:0x0427, B:127:0x043b, B:128:0x043c, B:129:0x0445), top: B:167:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0484  */
    /* JADX WARN: Code duplicated, block: B:155:0x04f2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:158:0x051a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:170:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x03cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x02a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x010d  */
    /* JADX WARN: Code duplicated, block: B:58:0x012f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0131 A[Catch: all -> 0x04b8, Exception -> 0x04bb, PHI: r2 r5
  0x0131: PHI (r2v21 java.lang.String) = (r2v17 java.lang.String), (r2v23 java.lang.String) binds: [B:57:0x012d, B:38:0x00c2] A[DONT_GENERATE, DONT_INLINE]
  0x0131: PHI (r5v16 ??) = (r5v56 ??), (r5v19 ??) binds: [B:57:0x012d, B:38:0x00c2] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #9 {Exception -> 0x04bb, all -> 0x04b8, blocks: (B:59:0x0131, B:56:0x0110), top: B:170:0x0110 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0145  */
    /* JADX WARN: Code duplicated, block: B:65:0x0154 A[Catch: all -> 0x04b0, Exception -> 0x04b4, TRY_LEAVE, TryCatch #10 {Exception -> 0x04b4, all -> 0x04b0, blocks: (B:89:0x0232, B:91:0x0238, B:92:0x0247, B:94:0x024d, B:96:0x0267, B:97:0x02a4, B:108:0x0323, B:99:0x02fe, B:101:0x0303, B:105:0x0318, B:106:0x0319, B:107:0x0322, B:63:0x0148, B:65:0x0154, B:73:0x018c, B:75:0x0190, B:85:0x01ec, B:76:0x01c9, B:78:0x01cd, B:82:0x01e1, B:83:0x01e2, B:84:0x01eb), top: B:169:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0190 A[Catch: all -> 0x04b0, Exception -> 0x04b4, TryCatch #10 {Exception -> 0x04b4, all -> 0x04b0, blocks: (B:89:0x0232, B:91:0x0238, B:92:0x0247, B:94:0x024d, B:96:0x0267, B:97:0x02a4, B:108:0x0323, B:99:0x02fe, B:101:0x0303, B:105:0x0318, B:106:0x0319, B:107:0x0322, B:63:0x0148, B:65:0x0154, B:73:0x018c, B:75:0x0190, B:85:0x01ec, B:76:0x01c9, B:78:0x01cd, B:82:0x01e1, B:83:0x01e2, B:84:0x01eb), top: B:169:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x01c9 A[Catch: all -> 0x04b0, Exception -> 0x04b4, TryCatch #10 {Exception -> 0x04b4, all -> 0x04b0, blocks: (B:89:0x0232, B:91:0x0238, B:92:0x0247, B:94:0x024d, B:96:0x0267, B:97:0x02a4, B:108:0x0323, B:99:0x02fe, B:101:0x0303, B:105:0x0318, B:106:0x0319, B:107:0x0322, B:63:0x0148, B:65:0x0154, B:73:0x018c, B:75:0x0190, B:85:0x01ec, B:76:0x01c9, B:78:0x01cd, B:82:0x01e1, B:83:0x01e2, B:84:0x01eb), top: B:169:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x01cd A[Catch: all -> 0x04b0, Exception -> 0x04b4, TryCatch #10 {Exception -> 0x04b4, all -> 0x04b0, blocks: (B:89:0x0232, B:91:0x0238, B:92:0x0247, B:94:0x024d, B:96:0x0267, B:97:0x02a4, B:108:0x0323, B:99:0x02fe, B:101:0x0303, B:105:0x0318, B:106:0x0319, B:107:0x0322, B:63:0x0148, B:65:0x0154, B:73:0x018c, B:75:0x0190, B:85:0x01ec, B:76:0x01c9, B:78:0x01cd, B:82:0x01e1, B:83:0x01e2, B:84:0x01eb), top: B:169:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:80:0x01de A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:82:0x01e1 A[Catch: all -> 0x04b0, Exception -> 0x04b4, TryCatch #10 {Exception -> 0x04b4, all -> 0x04b0, blocks: (B:89:0x0232, B:91:0x0238, B:92:0x0247, B:94:0x024d, B:96:0x0267, B:97:0x02a4, B:108:0x0323, B:99:0x02fe, B:101:0x0303, B:105:0x0318, B:106:0x0319, B:107:0x0322, B:63:0x0148, B:65:0x0154, B:73:0x018c, B:75:0x0190, B:85:0x01ec, B:76:0x01c9, B:78:0x01cd, B:82:0x01e1, B:83:0x01e2, B:84:0x01eb), top: B:169:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x01e2 A[Catch: all -> 0x04b0, Exception -> 0x04b4, TryCatch #10 {Exception -> 0x04b4, all -> 0x04b0, blocks: (B:89:0x0232, B:91:0x0238, B:92:0x0247, B:94:0x024d, B:96:0x0267, B:97:0x02a4, B:108:0x0323, B:99:0x02fe, B:101:0x0303, B:105:0x0318, B:106:0x0319, B:107:0x0322, B:63:0x0148, B:65:0x0154, B:73:0x018c, B:75:0x0190, B:85:0x01ec, B:76:0x01c9, B:78:0x01cd, B:82:0x01e1, B:83:0x01e2, B:84:0x01eb), top: B:169:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x022b  */
    /* JADX WARN: Code duplicated, block: B:88:0x022d  */
    /* JADX WARN: Code duplicated, block: B:91:0x0238 A[Catch: all -> 0x04b0, Exception -> 0x04b4, TryCatch #10 {Exception -> 0x04b4, all -> 0x04b0, blocks: (B:89:0x0232, B:91:0x0238, B:92:0x0247, B:94:0x024d, B:96:0x0267, B:97:0x02a4, B:108:0x0323, B:99:0x02fe, B:101:0x0303, B:105:0x0318, B:106:0x0319, B:107:0x0322, B:63:0x0148, B:65:0x0154, B:73:0x018c, B:75:0x0190, B:85:0x01ec, B:76:0x01c9, B:78:0x01cd, B:82:0x01e1, B:83:0x01e2, B:84:0x01eb), top: B:169:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x024d A[Catch: all -> 0x04b0, Exception -> 0x04b4, TryCatch #10 {Exception -> 0x04b4, all -> 0x04b0, blocks: (B:89:0x0232, B:91:0x0238, B:92:0x0247, B:94:0x024d, B:96:0x0267, B:97:0x02a4, B:108:0x0323, B:99:0x02fe, B:101:0x0303, B:105:0x0318, B:106:0x0319, B:107:0x0322, B:63:0x0148, B:65:0x0154, B:73:0x018c, B:75:0x0190, B:85:0x01ec, B:76:0x01c9, B:78:0x01cd, B:82:0x01e1, B:83:0x01e2, B:84:0x01eb), top: B:169:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0267 A[Catch: all -> 0x04b0, Exception -> 0x04b4, TryCatch #10 {Exception -> 0x04b4, all -> 0x04b0, blocks: (B:89:0x0232, B:91:0x0238, B:92:0x0247, B:94:0x024d, B:96:0x0267, B:97:0x02a4, B:108:0x0323, B:99:0x02fe, B:101:0x0303, B:105:0x0318, B:106:0x0319, B:107:0x0322, B:63:0x0148, B:65:0x0154, B:73:0x018c, B:75:0x0190, B:85:0x01ec, B:76:0x01c9, B:78:0x01cd, B:82:0x01e1, B:83:0x01e2, B:84:0x01eb), top: B:169:0x0148 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x02fe A[Catch: all -> 0x04b0, Exception -> 0x04b4, TryCatch #10 {Exception -> 0x04b4, all -> 0x04b0, blocks: (B:89:0x0232, B:91:0x0238, B:92:0x0247, B:94:0x024d, B:96:0x0267, B:97:0x02a4, B:108:0x0323, B:99:0x02fe, B:101:0x0303, B:105:0x0318, B:106:0x0319, B:107:0x0322, B:63:0x0148, B:65:0x0154, B:73:0x018c, B:75:0x0190, B:85:0x01ec, B:76:0x01c9, B:78:0x01cd, B:82:0x01e1, B:83:0x01e2, B:84:0x01eb), top: B:169:0x0148 }] */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x04a3, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r0, r2, r9) == r4) goto L158;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.magneticchen.daijishou.DaijishouApplication$WrappedLogger] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v43, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v47, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r46v0, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager] */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v43, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v49, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v51, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager] */
    /* JADX WARN: Type inference failed for: r5v54 */
    /* JADX WARN: Type inference failed for: r5v55 */
    /* JADX WARN: Type inference failed for: r5v56 */
    /* JADX WARN: Type inference failed for: r5v57 */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refreshRetroAchievementsUserProfileData(java.lang.String r47, kotlin.coroutines.Continuation<?> r48) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager.refreshRetroAchievementsUserProfileData(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsUserProfileData$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsUserProfileData$2", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    final class C02632 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;

        C02632(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new C02632(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    try {
                        return ((C02632) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
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
                RetroAchievementsManager.this.getRefreshingUsernamesLiveData().setValue(RetroAchievementsManager.this.refreshingUsernames);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsUserProfileData$6, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$refreshRetroAchievementsUserProfileData$6", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    final class AnonymousClass6 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;

        AnonymousClass6(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new AnonymousClass6(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    try {
                        return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
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
                RetroAchievementsManager.this.getRefreshingUsernamesLiveData().setValue(RetroAchievementsManager.this.refreshingUsernames);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getMyRetroAchievementsUsername(Continuation<?> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        RetroAchievementsManager retroAchievementsManager;
        RetroAchievementsManager retroAchievementsManager2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.logger.debug(this, "getMyRetroAchievementsUsername");
            String str = this.myUsername;
            if (str != null) {
                return str;
            }
            this.logger.debug(this, "myUsername: " + str);
            try {
                anonymousClass1.L$0 = this;
                anonymousClass1.label = 1;
                if (refreshRetroAchievementsCredentials$default(this, false, anonymousClass1, 1, null) != coroutine_suspended) {
                    retroAchievementsManager2 = this;
                }
                return coroutine_suspended;
            } catch (Exception e) {
                e = e;
                retroAchievementsManager = this;
                retroAchievementsManager.logger.warn(retroAchievementsManager, ExceptionsKt.stackTraceToString(e));
                return null;
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            retroAchievementsManager = (RetroAchievementsManager) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                return retroAchievementsManager.myUsername;
            } catch (Exception e2) {
                Exception e = null;
                e = e2;
                retroAchievementsManager.logger.warn(retroAchievementsManager, ExceptionsKt.stackTraceToString(e));
                return null;
            }
        }
        retroAchievementsManager2 = (RetroAchievementsManager) anonymousClass1.L$0;
        try {
            ResultKt.throwOnFailure(obj);
        } catch (Exception e3) {
            Exception e = null;
            e = e3;
            retroAchievementsManager = retroAchievementsManager2;
            retroAchievementsManager.logger.warn(retroAchievementsManager, ExceptionsKt.stackTraceToString(e));
            return null;
        }
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass2 anonymousClass2 = retroAchievementsManager2.new AnonymousClass2(null);
        anonymousClass1.L$0 = retroAchievementsManager2;
        anonymousClass1.label = 2;
        if (BuildersKt.withContext(main, anonymousClass2, anonymousClass1) != coroutine_suspended) {
            retroAchievementsManager = retroAchievementsManager2;
            return retroAchievementsManager.myUsername;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$getMyRetroAchievementsUsername$2, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager$getMyRetroAchievementsUsername$2", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;

        AnonymousClass2(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    try {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
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
                RetroAchievementsManager.this.getMyUsernameLiveData().setValue(RetroAchievementsManager.this.myUsername);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void onCreate() {
        setRetroAchievementsRepository(this.application.getRetroAchievementsRepository());
        SharedPreferences sharedPreferences = this.application.getSharedPreferences("retro_achievements", 0);
        Intrinsics.checkNotNull(sharedPreferences);
        setRetroAchievementsSharedPreferences(sharedPreferences);
        ConnectionLiveData connectionLiveData = null;
        this.retroAchievementsUsernamePreferenceLiveData = new SharedPreferenceStringLiveData(getRetroAchievementsSharedPreferences(), "username", null);
        this.retroAchievementsWebApiKeyPreferenceLiveData = new SharedPreferenceStringLiveData(getRetroAchievementsSharedPreferences(), "web_api_key", null);
        SharedPreferenceStringLiveData sharedPreferenceStringLiveData = this.retroAchievementsUsernamePreferenceLiveData;
        if (sharedPreferenceStringLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsUsernamePreferenceLiveData");
            sharedPreferenceStringLiveData = null;
        }
        SharedPreferenceStringLiveData sharedPreferenceStringLiveData2 = sharedPreferenceStringLiveData;
        SharedPreferenceStringLiveData sharedPreferenceStringLiveData3 = this.retroAchievementsWebApiKeyPreferenceLiveData;
        if (sharedPreferenceStringLiveData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retroAchievementsWebApiKeyPreferenceLiveData");
            sharedPreferenceStringLiveData3 = null;
        }
        this.credentialsLiveData = new PairLiveData<>(sharedPreferenceStringLiveData2, sharedPreferenceStringLiveData3);
        this.connectionLiveData = new ConnectionLiveData(this.application);
        PairLiveData<String, String> pairLiveData = this.credentialsLiveData;
        if (pairLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("credentialsLiveData");
            pairLiveData = null;
        }
        pairLiveData.observeForever(new RetroAchievementsManagerKt$sam$androidx_lifecycle_Observer$0(this.credentialsLiveDataObserver));
        PairLiveData<String, String> pairLiveData2 = this.credentialsLiveData;
        if (pairLiveData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("credentialsLiveData");
            pairLiveData2 = null;
        }
        pairLiveData2.getValue();
        ConnectionLiveData connectionLiveData2 = this.connectionLiveData;
        if (connectionLiveData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionLiveData");
            connectionLiveData2 = null;
        }
        connectionLiveData2.observeForever(new RetroAchievementsManagerKt$sam$androidx_lifecycle_Observer$0(this.connectionLiveDataObserver));
        ConnectionLiveData connectionLiveData3 = this.connectionLiveData;
        if (connectionLiveData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionLiveData");
        } else {
            connectionLiveData = connectionLiveData3;
        }
        connectionLiveData.getValue();
        this.isCreated = true;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getRetroInterface(Continuation<?> continuation) throws Throwable {
        C02491 c02491;
        RetroAchievementsManager retroAchievementsManager;
        if (continuation instanceof C02491) {
            c02491 = (C02491) continuation;
            if ((c02491.label & Integer.MIN_VALUE) != 0) {
                c02491.label -= Integer.MIN_VALUE;
            } else {
                c02491 = new C02491(continuation);
            }
        } else {
            c02491 = new C02491(continuation);
        }
        Object obj = c02491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02491.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.retroInterface != null && Utils.INSTANCE.isNetworkAvailable(this.application)) {
                return this.retroInterface;
            }
            c02491.L$0 = this;
            c02491.label = 1;
            if (refreshRetroAchievementsCredentials$default(this, false, c02491, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            retroAchievementsManager = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            retroAchievementsManager = (RetroAchievementsManager) c02491.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return retroAchievementsManager.retroInterface;
    }

    public final void onTerminate() {
        this.isCreated = false;
        PairLiveData<String, String> pairLiveData = this.credentialsLiveData;
        ConnectionLiveData connectionLiveData = null;
        if (pairLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("credentialsLiveData");
            pairLiveData = null;
        }
        pairLiveData.removeObserver(new RetroAchievementsManagerKt$sam$androidx_lifecycle_Observer$0(this.credentialsLiveDataObserver));
        ConnectionLiveData connectionLiveData2 = this.connectionLiveData;
        if (connectionLiveData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionLiveData");
        } else {
            connectionLiveData = connectionLiveData2;
        }
        connectionLiveData.removeObserver(new RetroAchievementsManagerKt$sam$androidx_lifecycle_Observer$0(this.connectionLiveDataObserver));
    }
}
