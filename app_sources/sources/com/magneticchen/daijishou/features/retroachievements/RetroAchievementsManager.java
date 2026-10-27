package com.magneticchen.daijishou.features.retroachievements;

import android.content.SharedPreferences;
import android.widget.Toast;
import androidx.lifecycle.MutableLiveData;
import com.haroldadmin.cnradapter.NetworkResponse;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.RetroAchievementsConsole;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsAchievementRecordEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsGameRecordEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserAwardEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserIndependentGameRecordEntity;
import com.magneticchen.daijishou.data.db.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository;
import com.magneticchen.daijishou.data.live.ConnectionLiveData;
import com.magneticchen.daijishou.data.live.PairLiveData;
import com.magneticchen.daijishou.data.live.SharedPreferenceStringLiveData;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.utils.UtilsKt;
import com.skydoves.balloon.internals.DefinitionKt;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
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
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.retroachivements.api.RetroInterface;
import org.retroachivements.api.data.RetroCredentials;
import org.retroachivements.api.data.pojo.ErrorResponse;
import org.retroachivements.api.data.pojo.game.GetGameInfoAndUserProgress;
import org.retroachivements.api.data.pojo.user.GetUserAwards;

/* JADX INFO: compiled from: RetroAchievementsManager.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 s2\u00020\u0001:\u0001sB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010N\u001a\u0004\u0018\u00010\u00182\b\u0010O\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010PJ\u000e\u0010Q\u001a\u00020\u00182\u0006\u0010R\u001a\u00020\u000bJ\u0010\u0010S\u001a\u0004\u0018\u00010\u0018H\u0086@¢\u0006\u0002\u0010TJ\u0010\u0010U\u001a\u0004\u0018\u00010MH\u0086@¢\u0006\u0002\u0010TJ\u0006\u0010V\u001a\u00020\fJ\u0006\u0010W\u001a\u00020\fJ\u000e\u0010X\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010TJ\u0016\u0010Y\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010[J\u0016\u0010\\\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010[J\u0016\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0086@¢\u0006\u0002\u0010`J\u0016\u0010a\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0086@¢\u0006\u0002\u0010`J\u0016\u0010b\u001a\u00020\u001f2\u0006\u0010c\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010dJ\u0018\u0010e\u001a\u00020\f2\b\b\u0002\u0010f\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010gJ\u0016\u0010h\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010[J\u0016\u0010i\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010[J\u0016\u0010j\u001a\u00020\f2\u0006\u0010k\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010dJ\u0016\u0010l\u001a\u00020\f2\u0006\u0010k\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010dJ\u0006\u0010m\u001a\u00020\fJ\u0014\u0010n\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0/J\u0012\u0010o\u001a\u0004\u0018\u00010\u00182\u0006\u0010p\u001a\u00020\u0018H\u0002J\f\u0010q\u001a\u0004\u0018\u00010r*\u00020\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0012`\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0017X\u0082.¢\u0006\u0002\n\u0000R*\u0010\u0019\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001a\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00060&R\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0/0)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010+\"\u0004\b1\u00102R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R&\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0/0)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010+\"\u0004\b6\u00102R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R&\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180/0)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010+\"\u0004\b:\u00102R\u001a\u0010;\u001a\u00020<X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020BX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020HX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020HX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006t"}, d2 = {"Lcom/magneticchen/daijishou/features/retroachievements/RetroAchievementsManager;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "connectionLiveData", "Lcom/magneticchen/daijishou/data/live/ConnectionLiveData;", "connectionLiveDataObserver", "Lkotlin/Function1;", "", "", "consoleWatchlist", "", "", "consoles", "Ljava/util/HashMap;", "Lcom/magneticchen/daijishou/data/RetroAchievementsConsole;", "Lkotlin/collections/HashMap;", "getConsoles", "()Ljava/util/HashMap;", "credentialsLiveData", "Lcom/magneticchen/daijishou/data/live/PairLiveData;", "", "credentialsLiveDataObserver", "Lkotlin/Pair;", "credentialsRefreshMutex", "Lkotlinx/coroutines/sync/Mutex;", "credentialsRetriedCount", "firstLogin", "", "isCreated", "()Z", "setCreated", "(Z)V", "lastCredentialsFailedTimestamp", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "myUsername", "myUsernameLiveData", "Landroidx/lifecycle/MutableLiveData;", "getMyUsernameLiveData", "()Landroidx/lifecycle/MutableLiveData;", "refreshMyRetroAchievementsAwardsUserId", "refreshingConsoleIds", "refreshingConsoleIdsLiveData", "", "getRefreshingConsoleIdsLiveData", "setRefreshingConsoleIdsLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "refreshingGameIds", "refreshingGameIdsLiveData", "getRefreshingGameIdsLiveData", "setRefreshingGameIdsLiveData", "refreshingUsernames", "refreshingUsernamesLiveData", "getRefreshingUsernamesLiveData", "setRefreshingUsernamesLiveData", "retroAchievementsRepository", "Lcom/magneticchen/daijishou/data/db/repositories/RetroAchievementsRepository;", "getRetroAchievementsRepository", "()Lcom/magneticchen/daijishou/data/db/repositories/RetroAchievementsRepository;", "setRetroAchievementsRepository", "(Lcom/magneticchen/daijishou/data/db/repositories/RetroAchievementsRepository;)V", "retroAchievementsSharedPreferences", "Landroid/content/SharedPreferences;", "getRetroAchievementsSharedPreferences", "()Landroid/content/SharedPreferences;", "setRetroAchievementsSharedPreferences", "(Landroid/content/SharedPreferences;)V", "retroAchievementsUsernamePreferenceLiveData", "Lcom/magneticchen/daijishou/data/live/SharedPreferenceStringLiveData;", "retroAchievementsWebApiKeyPreferenceLiveData", "retroCredentials", "Lorg/retroachivements/api/data/RetroCredentials;", "retroInterface", "Lorg/retroachivements/api/RetroInterface;", "getConsoleImageUrl", "consoleId", "(Ljava/lang/Long;)Ljava/lang/String;", "getForumUrlString", "forumTopicId", "getMyRetroAchievementsUsername", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRetroInterface", "onCreate", "onTerminate", "refreshMyRetroAchievementsAwardsIfExpired", "refreshMyRetroAchievementsGameRecordByGameId", "gameId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshMyRetroAchievementsGameRecordByGameIdIfExpired", "refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity", "playableItemEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntityIfExpired", "refreshRetroAchievementsAwardsByUserId", "userId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshRetroAchievementsCredentials", "toastOnSuccess", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshRetroAchievementsGameListByConsoleId", "refreshRetroAchievementsGameListByConsoleIdIfExpired", "refreshRetroAchievementsUserProfileData", RetroAchievementsManager.USERNAME_PREFERENCE_STRING, "refreshRetroAchievementsUserProfileDataIfExpired", "resetCredentialsRetriedCount", "setConsoleWatchlist", "toGenericNameExtreme", "string", "toRetroAchievementsDate", "Ljava/util/Date;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    private int credentialsRetriedCount;
    private boolean firstLogin;
    private boolean isCreated;
    private long lastCredentialsFailedTimestamp;
    private final DaijishouApplication.WrappedLogger logger;
    private String myUsername;
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
    private RetroInterface retroInterface;
    public static final Companion Companion = new Companion(null);
    private static final DateTimeFormatter achievementEarnedTimestampFormatter = DateTimeFormatter.ofPattern("yyyy[-MM-dd[' 'HH:mm:ss]]");
    private static final Regex genericNameRegex = Constants.INSTANCE.getToGenericNameRegex();

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$getMyRetroAchievementsUsername$1, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 1}, l = {809, 810}, m = "getMyRetroAchievementsUsername", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.getMyRetroAchievementsUsername(this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$getRetroInterface$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0}, l = {839}, m = "getRetroInterface", n = {"this"}, s = {"L$0"})
    static final class C00591 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00591(Continuation<? super C00591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.getRetroInterface(this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshMyRetroAchievementsAwardsIfExpired$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 1}, l = {633, 637, 638}, m = "refreshMyRetroAchievementsAwardsIfExpired", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class C00601 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00601(Continuation<? super C00601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshMyRetroAchievementsAwardsIfExpired(this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshMyRetroAchievementsGameRecordByGameId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 4}, l = {507, 511, 514, 624, 624, 624}, m = "refreshMyRetroAchievementsGameRecordByGameId", n = {"this", "gameId", "this", "gameId", "succeed", "this", "gameId", "succeed", "succeed", "succeed"}, s = {"L$0", "J$0", "L$0", "J$0", "I$0", "L$0", "J$0", "I$0", "I$0", "I$0"})
    static final class C00611 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00611(Continuation<? super C00611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshMyRetroAchievementsGameRecordByGameId(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshMyRetroAchievementsGameRecordByGameIdIfExpired$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 0}, l = {497, 501}, m = "refreshMyRetroAchievementsGameRecordByGameIdIfExpired", n = {"this", "gameId"}, s = {"L$0", "J$0"})
    static final class C00631 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00631(Continuation<? super C00631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshMyRetroAchievementsGameRecordByGameIdIfExpired(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 0, 0}, l = {337}, m = "refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity", n = {"this", "playableItemEntity", "retroAchievementsConsoleIdList"}, s = {"L$0", "L$1", "L$2"})
    static final class C00641 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00641(Continuation<? super C00641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity(null, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsAwardsByUserId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 0, 1, 1, 1}, l = {643, 647}, m = "refreshRetroAchievementsAwardsByUserId", n = {"this", "userId", "this", "userId", "succeed"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
    static final class C00651 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00651(Continuation<? super C00651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshRetroAchievementsAwardsByUserId(null, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsCredentials$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 8, 9, 9, 11, 13}, l = {225, 233, 246, 853, 259, 264, 275, 302, 306, 296, 302, 306, 302, 306}, m = "refreshRetroAchievementsCredentials", n = {"this", RetroAchievementsManager.USERNAME_PREFERENCE_STRING, "webApiKey", "toastOnSuccess", "this", "this", RetroAchievementsManager.USERNAME_PREFERENCE_STRING, "webApiKey", "$this$withLock_u24default$iv", "toastOnSuccess", "this", RetroAchievementsManager.USERNAME_PREFERENCE_STRING, "webApiKey", "$this$withLock_u24default$iv", "toastOnSuccess", "this", RetroAchievementsManager.USERNAME_PREFERENCE_STRING, "$this$withLock_u24default$iv", "toastOnSuccess", "this", "$this$withLock_u24default$iv", "this", "this", "e", "this", "this"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$0", "L$0", "L$1", "L$0", "L$0"})
    static final class C00661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00661(Continuation<? super C00661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshRetroAchievementsCredentials(false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsGameListByConsoleId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 4}, l = {443, 448, 451, 488, 488, 488}, m = "refreshRetroAchievementsGameListByConsoleId", n = {"this", "consoleId", "this", "consoleId", "succeed", "this", "consoleId", "succeed", "succeed", "succeed"}, s = {"L$0", "J$0", "L$0", "J$0", "I$0", "L$0", "J$0", "I$0", "I$0", "I$0"})
    static final class C00691 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00691(Continuation<? super C00691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshRetroAchievementsGameListByConsoleId(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsGameListByConsoleIdIfExpired$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 0}, l = {430, 438}, m = "refreshRetroAchievementsGameListByConsoleIdIfExpired", n = {"this", "consoleId"}, s = {"L$0", "J$0"})
    static final class C00711 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00711(Continuation<? super C00711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshRetroAchievementsGameListByConsoleIdIfExpired(0L, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsUserProfileData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5}, l = {702, 705, 708, 737, 761, 791, 797, 797, 797}, m = "refreshRetroAchievementsUserProfileData", n = {"this", RetroAchievementsManager.USERNAME_PREFERENCE_STRING, "this", RetroAchievementsManager.USERNAME_PREFERENCE_STRING, "this", RetroAchievementsManager.USERNAME_PREFERENCE_STRING, "this", RetroAchievementsManager.USERNAME_PREFERENCE_STRING, "retroAchievementsUserProfileEntity", "gameRecordsToBeUpdated", "this", RetroAchievementsManager.USERNAME_PREFERENCE_STRING, "retroAchievementsUserProfileEntity", "gameRecordsToBeUpdated", "recentPlayedResponse", "this", RetroAchievementsManager.USERNAME_PREFERENCE_STRING}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"})
    static final class C00721 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00721(Continuation<? super C00721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetroAchievementsManager.this.refreshRetroAchievementsUserProfileData(null, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsUserProfileDataIfExpired$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager", f = "RetroAchievementsManager.kt", i = {0, 0}, l = {692, 696}, m = "refreshRetroAchievementsUserProfileDataIfExpired", n = {"this", RetroAchievementsManager.USERNAME_PREFERENCE_STRING}, s = {"L$0", "L$1"})
    static final class C00741 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00741(Continuation<? super C00741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
        this.credentialsRefreshMutex = MutexKt.Mutex$default(false, 1, (Object) null);
        this.consoles = new HashMap<>();
        this.myUsernameLiveData = new MutableLiveData<>((Object) null);
        this.firstLogin = true;
        this.credentialsLiveDataObserver = (Function1) new Function1<Pair<? extends String, ? extends String>, Unit>() { // from class: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$credentialsLiveDataObserver$1
            

            /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$credentialsLiveDataObserver$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: RetroAchievementsManager.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$credentialsLiveDataObserver$1$1", f = "RetroAchievementsManager.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ RetroAchievementsManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(RetroAchievementsManager retroAchievementsManager, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = retroAchievementsManager;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
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
                BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(this.this$0, null), 2, (Object) null);
            }
        };
        this.connectionLiveDataObserver = new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$connectionLiveDataObserver$1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$connectionLiveDataObserver$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: RetroAchievementsManager.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$connectionLiveDataObserver$1$1", f = "RetroAchievementsManager.kt", i = {}, l = {184}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ RetroAchievementsManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(RetroAchievementsManager retroAchievementsManager, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = retroAchievementsManager;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.this$0.logger.info((CoroutineScope) this.L$0, "Refreshing RetroAchievements Credentials. Because connection has changed and retroInterface is null.");
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

            public final void invoke(int i) {
                if (i == -1 || this.this$0.retroInterface != null) {
                    return;
                }
                BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(this.this$0, null), 2, (Object) null);
            }
        };
        this.refreshMyRetroAchievementsAwardsUserId = new ArrayList();
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/magneticchen/daijishou/features/retroachievements/RetroAchievementsManager$Companion;", "", "()V", "AWARD_EXPIRE_DURATION_MS", "", "GAME_RECORD_EXPIRE_DURATION_MS", "PLAYABLE_ITEM_ID_TO_GAME_ID_SURJECTION_EXPIRE_DURATION_MS", "USERNAME_PREFERENCE_STRING", "", "USER_ID_TRANSLATION_PREFERENCE_PREFIX", "USER_INDEPENDENT_GAME_RECORD_EXPIRE_DURATION_MS", "USER_PROFILE_EXPIRE_DURATION_MS", "WEB_API_KEY_PREFERENCE_STRING", "achievementEarnedTimestampFormatter", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "baseUrl", "credentialsRetriesCoolDown", "enforceCredentials", "", "genericNameRegex", "Lkotlin/text/Regex;", "maxCredentialsRetryCount", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean isCreated() {
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

    private final String toGenericNameExtreme(String str) {
        List<String> groupValues;
        String str2;
        MatchResult matchResultFind$default = Regex.find$default(genericNameRegex, str, 0, 2, null);
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

    public final void setConsoleWatchlist(List<Long> consoleWatchlist) {
        Intrinsics.checkNotNullParameter(consoleWatchlist, "consoleWatchlist");
        this.logger.debug(this, "setConsoleWatchlist, consoleWatchlist: " + consoleWatchlist);
        this.consoleWatchlist.clear();
        this.consoleWatchlist.addAll(consoleWatchlist);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), (CoroutineStart) null, new C00751(consoleWatchlist, null), 2, (Object) null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$setConsoleWatchlist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$setConsoleWatchlist$1", f = "RetroAchievementsManager.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
    static final class C00751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Long> $consoleWatchlist;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00751(List<Long> list, Continuation<? super C00751> continuation) {
            super(2, continuation);
            this.$consoleWatchlist = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00751 c00751 = RetroAchievementsManager.this.new C00751(this.$consoleWatchlist, continuation);
            c00751.L$0 = obj;
            return c00751;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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

    public final String getConsoleImageUrl(Long l) {
        RetroAchievementsConsole retroAchievementsConsole;
        if (l == null || (retroAchievementsConsole = this.consoles.get(l)) == null) {
            return null;
        }
        return retroAchievementsConsole.getIconUrl();
    }

    public final void resetCredentialsRetriedCount() {
        this.credentialsRetriedCount = 0;
    }

    public final String getForumUrlString(int i) {
        return "https://retroachievements.org/viewtopic.php?t=" + i;
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [java.time.ZonedDateTime] */
    public final Date toRetroAchievementsDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            TemporalAccessor best = achievementEarnedTimestampFormatter.parseBest(str, new TemporalQuery() { // from class: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$$ExternalSyntheticLambda0
                @Override // java.time.temporal.TemporalQuery
                public final Object queryFrom(TemporalAccessor temporalAccessor) {
                    return LocalDateTime.from(temporalAccessor);
                }
            }, new TemporalQuery() { // from class: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$$ExternalSyntheticLambda1
                @Override // java.time.temporal.TemporalQuery
                public final Object queryFrom(TemporalAccessor temporalAccessor) {
                    return LocalDate.from(temporalAccessor);
                }
            });
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
    /* JADX WARN: Code duplicated, block: B:115:0x02f1 A[Catch: all -> 0x03e7, TryCatch #0 {all -> 0x03e7, blocks: (B:113:0x02eb, B:115:0x02f1, B:117:0x02f7, B:118:0x0303, B:120:0x0309, B:121:0x0330, B:129:0x035d, B:131:0x0361, B:135:0x0375, B:136:0x0376, B:137:0x037f, B:138:0x0380, B:156:0x03df, B:157:0x03e6), top: B:205:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:131:0x0361 A[Catch: all -> 0x03e7, TryCatch #0 {all -> 0x03e7, blocks: (B:113:0x02eb, B:115:0x02f1, B:117:0x02f7, B:118:0x0303, B:120:0x0309, B:121:0x0330, B:129:0x035d, B:131:0x0361, B:135:0x0375, B:136:0x0376, B:137:0x037f, B:138:0x0380, B:156:0x03df, B:157:0x03e6), top: B:205:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0372 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:134:0x0374  */
    /* JADX WARN: Code duplicated, block: B:135:0x0375 A[Catch: all -> 0x03e7, TryCatch #0 {all -> 0x03e7, blocks: (B:113:0x02eb, B:115:0x02f1, B:117:0x02f7, B:118:0x0303, B:120:0x0309, B:121:0x0330, B:129:0x035d, B:131:0x0361, B:135:0x0375, B:136:0x0376, B:137:0x037f, B:138:0x0380, B:156:0x03df, B:157:0x03e6), top: B:205:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0376 A[Catch: all -> 0x03e7, TryCatch #0 {all -> 0x03e7, blocks: (B:113:0x02eb, B:115:0x02f1, B:117:0x02f7, B:118:0x0303, B:120:0x0309, B:121:0x0330, B:129:0x035d, B:131:0x0361, B:135:0x0375, B:136:0x0376, B:137:0x037f, B:138:0x0380, B:156:0x03df, B:157:0x03e6), top: B:205:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0380 A[Catch: all -> 0x03e7, TRY_LEAVE, TryCatch #0 {all -> 0x03e7, blocks: (B:113:0x02eb, B:115:0x02f1, B:117:0x02f7, B:118:0x0303, B:120:0x0309, B:121:0x0330, B:129:0x035d, B:131:0x0361, B:135:0x0375, B:136:0x0376, B:137:0x037f, B:138:0x0380, B:156:0x03df, B:157:0x03e6), top: B:205:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:146:0x0391  */
    /* JADX WARN: Code duplicated, block: B:149:0x03a6 A[Catch: Exception -> 0x0080, TRY_ENTER, TryCatch #5 {Exception -> 0x0080, blocks: (B:19:0x005c, B:184:0x0460, B:186:0x0466, B:183:0x0457, B:27:0x007b, B:150:0x03af, B:152:0x03b5, B:149:0x03a6), top: B:208:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:152:0x03b5 A[Catch: Exception -> 0x0080, TRY_LEAVE, TryCatch #5 {Exception -> 0x0080, blocks: (B:19:0x005c, B:184:0x0460, B:186:0x0466, B:183:0x0457, B:27:0x007b, B:150:0x03af, B:152:0x03b5, B:149:0x03a6), top: B:208:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:156:0x03df A[Catch: all -> 0x03e7, TRY_ENTER, TryCatch #0 {all -> 0x03e7, blocks: (B:113:0x02eb, B:115:0x02f1, B:117:0x02f7, B:118:0x0303, B:120:0x0309, B:121:0x0330, B:129:0x035d, B:131:0x0361, B:135:0x0375, B:136:0x0376, B:137:0x037f, B:138:0x0380, B:156:0x03df, B:157:0x03e6), top: B:205:0x02eb }] */
    /* JADX WARN: Code duplicated, block: B:176:0x0421  */
    /* JADX WARN: Code duplicated, block: B:180:0x0444  */
    /* JADX WARN: Code duplicated, block: B:183:0x0457 A[Catch: Exception -> 0x0080, TRY_ENTER, TryCatch #5 {Exception -> 0x0080, blocks: (B:19:0x005c, B:184:0x0460, B:186:0x0466, B:183:0x0457, B:27:0x007b, B:150:0x03af, B:152:0x03b5, B:149:0x03a6), top: B:208:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:186:0x0466 A[Catch: Exception -> 0x0080, TRY_LEAVE, TryCatch #5 {Exception -> 0x0080, blocks: (B:19:0x005c, B:184:0x0460, B:186:0x0466, B:183:0x0457, B:27:0x007b, B:150:0x03af, B:152:0x03b5, B:149:0x03a6), top: B:208:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:193:0x0486  */
    /* JADX WARN: Code duplicated, block: B:196:0x049c A[Catch: Exception -> 0x0048, TRY_ENTER, TryCatch #12 {Exception -> 0x0048, blocks: (B:13:0x0042, B:197:0x04a5, B:199:0x04ab, B:196:0x049c), top: B:208:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:217:0x026b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:230:0x04c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:232:? A[LOOP:1: B:184:0x0460->B:232:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:234:0x04c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:236:? A[LOOP:2: B:150:0x03af->B:236:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:87:0x020e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x0210  */
    /* JADX WARN: Code duplicated, block: B:91:0x0222  */
    /* JADX WARN: Code duplicated, block: B:92:0x0226  */
    /* JADX WARN: Code duplicated, block: B:94:0x022a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0248  */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x03a2, code lost:
    
        if (refreshRetroAchievementsCredentials$default(r4, false, r6, r16, null) == r2) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0453, code lost:
    
        if (refreshRetroAchievementsCredentials$default(r4, false, r6, 1, null) == r2) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0499, code lost:
    
        if (refreshRetroAchievementsCredentials$default(r5, false, r6, 1, null) == r2) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0167, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r0, r3, r6) == r2) goto L201;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [com.magneticchen.daijishou.DaijishouApplication$WrappedLogger] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v3, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v30 */
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
    /* JADX WARN: Type inference failed for: r4v8, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v9, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v11, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v23, types: [java.lang.String, kotlin.coroutines.Continuation, org.retroachivements.api.RetroInterface] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager] */
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
    public final java.lang.Object refreshRetroAchievementsCredentials(boolean r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager.refreshRetroAchievementsCredentials(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object refreshRetroAchievementsCredentials$default(RetroAchievementsManager retroAchievementsManager, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return retroAchievementsManager.refreshRetroAchievementsCredentials(z, continuation);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsCredentials$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsCredentials$2", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00672 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00672(Continuation<? super C00672> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new C00672(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00672) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                RetroAchievementsManager.this.getMyUsernameLiveData().setValue(RetroAchievementsManager.this.myUsername);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsCredentials$3, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsCredentials$3", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Toast.makeText(RetroAchievementsManager.this.getApplication().getApplicationContext(), RetroAchievementsManager.this.getApplication().getString(R.string.retro_achievements_login_failed_message), 0).show();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsCredentials$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsCredentials$5", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00685 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00685(Continuation<? super C00685> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new C00685(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00685) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                RetroAchievementsManager.this.getMyUsernameLiveData().setValue(RetroAchievementsManager.this.myUsername);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntityIfExpired(PlayableItemEntity playableItemEntity, Continuation<? super Boolean> continuation) {
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
    public final Object refreshPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity(PlayableItemEntity playableItemEntity, Continuation<? super Boolean> continuation) {
        C00641 c00641;
        RetroAchievementsManager retroAchievementsManager;
        Iterator it;
        List<Long> list;
        PlayableItemEntity playableItemEntity2;
        boolean z;
        ArrayList arrayList;
        float f;
        float fMax;
        float ranking;
        if (continuation instanceof C00641) {
            c00641 = (C00641) continuation;
            if ((c00641.label & Integer.MIN_VALUE) != 0) {
                c00641.label -= Integer.MIN_VALUE;
            } else {
                c00641 = new C00641(continuation);
            }
        } else {
            c00641 = new C00641(continuation);
        }
        Object obj = c00641.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00641.label;
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
                    e = e2;
                    retroAchievementsManager = this;
                }
                retroAchievementsManager.logger.error(retroAchievementsManager, ExceptionsKt.stackTraceToString(e));
                z = false;
                return Boxing.boxBoolean(z);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) c00641.L$3;
            list = (List) c00641.L$2;
            PlayableItemEntity playableItemEntity3 = (PlayableItemEntity) c00641.L$1;
            retroAchievementsManager = (RetroAchievementsManager) c00641.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                playableItemEntity2 = playableItemEntity3;
            } catch (Exception e3) {
                e = e3;
                retroAchievementsManager.logger.error(retroAchievementsManager, ExceptionsKt.stackTraceToString(e));
                z = false;
            }
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                c00641.L$0 = retroAchievementsManager;
                c00641.L$1 = playableItemEntity2;
                c00641.L$2 = list;
                c00641.L$3 = it;
                c00641.label = 1;
                if (retroAchievementsManager.refreshRetroAchievementsGameListByConsoleIdIfExpired(jLongValue, c00641) == coroutine_suspended) {
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
                    for (String str4 : StringsKt.split$default((CharSequence) str2, strArr, false, 0, 6, (Object) null)) {
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
                                fMax = DefinitionKt.NO_Float_VALUE;
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
                            if (objectRef.element != 0 || ranking > floatRef.element) {
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
                        fMax = DefinitionKt.NO_Float_VALUE;
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
                        if (objectRef.element != 0) {
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
            retroAchievementsRepository.addRetroAchievementsCachedPlayableItemIdToGameIdSurjection(new RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity(0L, false, id3, l != null ? l.longValue() : RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity.Companion.getNULL_GAME_ID(), new Date(), 3, null));
            z = true;
            return Boxing.boxBoolean(z);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object refreshRetroAchievementsGameListByConsoleIdIfExpired(long j, Continuation<? super Boolean> continuation) throws Throwable {
        C00711 c00711;
        RetroAchievementsManager retroAchievementsManager;
        Date lastUpdatedTimestamp;
        if (continuation instanceof C00711) {
            c00711 = (C00711) continuation;
            if ((c00711.label & Integer.MIN_VALUE) != 0) {
                c00711.label -= Integer.MIN_VALUE;
            } else {
                c00711 = new C00711(continuation);
            }
        } else {
            c00711 = new C00711(continuation);
        }
        Object retroInterface = c00711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00711.label;
        if (i == 0) {
            ResultKt.throwOnFailure(retroInterface);
            this.logger.debug(this, "refreshRetroAchievementsGameListByConsoleIdIfExpired, consoleId: " + j);
            c00711.L$0 = this;
            c00711.J$0 = j;
            c00711.label = 1;
            retroInterface = getRetroInterface(c00711);
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
        j = c00711.J$0;
        retroAchievementsManager = (RetroAchievementsManager) c00711.L$0;
        ResultKt.throwOnFailure(retroInterface);
        if (((RetroInterface) retroInterface) == null) {
            return Boxing.boxBoolean(false);
        }
        RetroAchievementsUserIndependentGameRecordEntity firstRetroAchievementsUserIndependentGameRecordByConsoleIdStatically = retroAchievementsManager.getRetroAchievementsRepository().getFirstRetroAchievementsUserIndependentGameRecordByConsoleIdStatically(j);
        if (firstRetroAchievementsUserIndependentGameRecordByConsoleIdStatically != null && (lastUpdatedTimestamp = firstRetroAchievementsUserIndependentGameRecordByConsoleIdStatically.getLastUpdatedTimestamp()) != null && lastUpdatedTimestamp.getTime() + ((long) 691200000) > System.currentTimeMillis()) {
            return Boxing.boxBoolean(false);
        }
        c00711.L$0 = null;
        c00711.label = 2;
        Object objRefreshRetroAchievementsGameListByConsoleId = retroAchievementsManager.refreshRetroAchievementsGameListByConsoleId(j, c00711);
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
    public final java.lang.Object refreshRetroAchievementsGameListByConsoleId(long r37, kotlin.coroutines.Continuation<? super java.lang.Boolean> r39) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 730
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager.refreshRetroAchievementsGameListByConsoleId(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsGameListByConsoleId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsGameListByConsoleId$2", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00702 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00702(Continuation<? super C00702> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new C00702(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00702) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                RetroAchievementsManager.this.getRefreshingConsoleIdsLiveData().setValue(RetroAchievementsManager.this.refreshingConsoleIds);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsGameListByConsoleId$4, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsGameListByConsoleId$4", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
    public final Object refreshMyRetroAchievementsGameRecordByGameIdIfExpired(long j, Continuation<? super Boolean> continuation) throws Throwable {
        C00631 c00631;
        RetroAchievementsManager retroAchievementsManager;
        long j2;
        Date lastUpdatedTimestamp;
        if (continuation instanceof C00631) {
            c00631 = (C00631) continuation;
            if ((c00631.label & Integer.MIN_VALUE) != 0) {
                c00631.label -= Integer.MIN_VALUE;
            } else {
                c00631 = new C00631(continuation);
            }
        } else {
            c00631 = new C00631(continuation);
        }
        Object retroInterface = c00631.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00631.label;
        if (i == 0) {
            ResultKt.throwOnFailure(retroInterface);
            c00631.L$0 = this;
            c00631.J$0 = j;
            c00631.label = 1;
            retroInterface = getRetroInterface(c00631);
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
        j2 = c00631.J$0;
        retroAchievementsManager = (RetroAchievementsManager) c00631.L$0;
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
        c00631.L$0 = null;
        c00631.label = 2;
        Object objRefreshMyRetroAchievementsGameRecordByGameId = retroAchievementsManager.refreshMyRetroAchievementsGameRecordByGameId(j2, c00631);
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
    /* JADX WARN: Type inference failed for: r9v4, types: [com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository] */
    public final Object refreshMyRetroAchievementsGameRecordByGameId(long j, Continuation<? super Boolean> continuation) throws Throwable {
        C00611 c00611;
        long r6 = 0L;
        Throwable th;
        RetroAchievementsManager retroAchievementsManager;
        long r7 = 0L;
        CoroutineContext main;
        AnonymousClass5 anonymousClass5;
        CoroutineContext main2;
        AnonymousClass5 anonymousClass6;
        int i;
        long j2;
        CoroutineContext main3;
        C00622 c00622;
        RetroAchievementsManager retroAchievementsManager2;
        long j3;
        int i2;
        RetroAchievementsManager retroAchievementsManager3;
        Object gameInfoAndUserProgress$default;
        int i3;
        NetworkResponse networkResponse;
        long j4;
        long j5;
        long r20 = 0L;
        ErrorResponse errorResponse;
        Throwable error;
        long r21 = 0L;
        CoroutineContext main4;
        AnonymousClass5 anonymousClass7;
        RetroAchievementsGameRecordEntity retroAchievementsGameRecordByUserIdAndGameIdStatically;
        long r22 = 0L;
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
        if (continuation instanceof C00611) {
            c00611 = (C00611) continuation;
            r6 = -2147483648;
            r6 = -2147483648;
            if ((c00611.label & Integer.MIN_VALUE) != 0) {
                c00611.label -= Integer.MIN_VALUE;
            } else {
                c00611 = new C00611(continuation);
            }
        } else {
            c00611 = new C00611(continuation);
        }
        C00611 c00612 = c00611;
        Object retroInterface = c00612.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                switch (c00612.label) {
                    case 0:
                        ResultKt.throwOnFailure(retroInterface);
                        this.logger.debug(this, "refreshMyRetroAchievementsGameRecordByGameId");
                        if (this.refreshingGameIds.contains(Boxing.boxLong(j))) {
                            return Boxing.boxBoolean(false);
                        }
                        c00612.L$0 = this;
                        j2 = j;
                        c00612.J$0 = j2;
                        c00612.label = 1;
                        retroInterface = getRetroInterface(c00612);
                        if (retroInterface != coroutine_suspended) {
                            retroAchievementsManager = this;
                            if (((RetroInterface) retroInterface) == null) {
                                return Boxing.boxBoolean(false);
                            }
                            try {
                                retroAchievementsManager.refreshingGameIds.add(Boxing.boxLong(j2));
                                main3 = Dispatchers.getMain();
                                c00622 = retroAchievementsManager.new C00622(null);
                                c00612.L$0 = retroAchievementsManager;
                                c00612.J$0 = j2;
                                c00612.I$0 = 1;
                                c00612.label = 2;
                                if (BuildersKt.withContext(main3, c00622, c00612) != coroutine_suspended) {
                                    long j7 = j2;
                                    retroAchievementsManager2 = retroAchievementsManager;
                                    j3 = j7;
                                    i2 = 1;
                                    try {
                                        RetroInterface retroInterface2 = retroAchievementsManager2.retroInterface;
                                        Intrinsics.checkNotNull(retroInterface2);
                                        String str = retroAchievementsManager2.myUsername;
                                        Intrinsics.checkNotNull(str);
                                        c00612.L$0 = retroAchievementsManager2;
                                        c00612.J$0 = j3;
                                        c00612.I$0 = i2;
                                        c00612.label = 3;
                                        retroAchievementsManager3 = retroAchievementsManager2;
                                        try {
                                            gameInfoAndUserProgress$default = RetroInterface.DefaultImpls.getGameInfoAndUserProgress$default(retroInterface2, str, j3, 0, c00612, 4, (Object) null);
                                            if (gameInfoAndUserProgress$default != coroutine_suspended) {
                                                i3 = i2;
                                                retroInterface = gameInfoAndUserProgress$default;
                                                r6 = j3;
                                                retroAchievementsManager = retroAchievementsManager3;
                                                try {
                                                    networkResponse = (NetworkResponse) retroInterface;
                                                    try {
                                                        if (networkResponse instanceof NetworkResponse.Success) {
                                                            com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository retroAchievementsRepository = retroAchievementsManager.getRetroAchievementsRepository();
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
                                                            Collection collectionValues = response.getAchievements().values();
                                                            Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
                                                            for (GetGameInfoAndUserProgress.Response.Achievement achievement : CollectionsKt.sortedWith(collectionValues, new Comparator() { // from class: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshMyRetroAchievementsGameRecordByGameId$$inlined$sortedBy$1
                                                                @Override // java.util.Comparator
                                                                public final int compare(T t, T t2) {
                                                                    return ComparisonsKt.compareValues(Integer.valueOf(((GetGameInfoAndUserProgress.Response.Achievement) t).getDisplayOrder()), Integer.valueOf(((GetGameInfoAndUserProgress.Response.Achievement) t2).getDisplayOrder()));
                                                                }
                                                            })) {
                                                                retroAchievementsAchievementRecordEntity = new RetroAchievementsAchievementRecordEntity(0L, j6, Long.parseLong(achievement.getId()), null, retroAchievementsManager.myUsername, 0, null, null, null, null, DefinitionKt.NO_Float_VALUE, 0, 0L, 0L, false, false, null, 131049, null);
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
                                                        c00612.L$0 = null;
                                                        c00612.I$0 = i3;
                                                        c00612.label = 4;
                                                        if (BuildersKt.withContext(main4, anonymousClass7, c00612) != coroutine_suspended) {
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
                                                        c00612.L$0 = null;
                                                        c00612.I$0 = 0;
                                                        c00612.label = 5;
                                                        if (BuildersKt.withContext(main2, anonymousClass6, c00612) != coroutine_suspended) {
                                                            i = 0;
                                                        }
                                                        return coroutine_suspended;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        r7 = j4;
                                                        retroAchievementsManager.refreshingGameIds.remove(Boxing.boxLong(r7));
                                                        main = Dispatchers.getMain();
                                                        anonymousClass5 = retroAchievementsManager.new AnonymousClass5(null);
                                                        c00612.L$0 = th;
                                                        c00612.label = 6;
                                                        if (BuildersKt.withContext(main, anonymousClass5, c00612) != coroutine_suspended) {
                                                            throw th;
                                                        }
                                                    }
                                                } catch (Exception e2) {
                                                    e = e2;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    th = th;
                                                    r7 = r6;
                                                    retroAchievementsManager.refreshingGameIds.remove(Boxing.boxLong(r7));
                                                    main = Dispatchers.getMain();
                                                    anonymousClass5 = retroAchievementsManager.new AnonymousClass5(null);
                                                    c00612.L$0 = th;
                                                    c00612.label = 6;
                                                    if (BuildersKt.withContext(main, anonymousClass5, c00612) != coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    throw th;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            r6 = j3;
                                            retroAchievementsManager = retroAchievementsManager3;
                                            retroAchievementsManager.logger.warn(retroAchievementsManager, ExceptionsKt.stackTraceToString(e));
                                            retroAchievementsManager.refreshingGameIds.remove(Boxing.boxLong(r6));
                                            main2 = Dispatchers.getMain();
                                            anonymousClass6 = retroAchievementsManager.new AnonymousClass5(null);
                                            c00612.L$0 = null;
                                            c00612.I$0 = 0;
                                            c00612.label = 5;
                                            if (BuildersKt.withContext(main2, anonymousClass6, c00612) != coroutine_suspended) {
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
                                            c00612.L$0 = th;
                                            c00612.label = 6;
                                            if (BuildersKt.withContext(main, anonymousClass5, c00612) != coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        retroAchievementsManager3 = retroAchievementsManager2;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        retroAchievementsManager3 = retroAchievementsManager2;
                                    }
                                }
                            } catch (Exception e5) {
                                e = e5;
                                r6 = j2;
                                retroAchievementsManager.logger.warn(retroAchievementsManager, ExceptionsKt.stackTraceToString(e));
                                retroAchievementsManager.refreshingGameIds.remove(Boxing.boxLong(r6));
                                main2 = Dispatchers.getMain();
                                anonymousClass6 = retroAchievementsManager.new AnonymousClass5(null);
                                c00612.L$0 = null;
                                c00612.I$0 = 0;
                                c00612.label = 5;
                                if (BuildersKt.withContext(main2, anonymousClass6, c00612) != coroutine_suspended) {
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
                                c00612.L$0 = th;
                                c00612.label = 6;
                                if (BuildersKt.withContext(main, anonymousClass5, c00612) != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                throw th;
                            }
                        }
                        return coroutine_suspended;
                    case 1:
                        j2 = c00612.J$0;
                        RetroAchievementsManager retroAchievementsManager4 = (RetroAchievementsManager) c00612.L$0;
                        ResultKt.throwOnFailure(retroInterface);
                        retroAchievementsManager = retroAchievementsManager4;
                        if (((RetroInterface) retroInterface) == null) {
                            return Boxing.boxBoolean(false);
                        }
                        retroAchievementsManager.refreshingGameIds.add(Boxing.boxLong(j2));
                        main3 = Dispatchers.getMain();
                        c00622 = retroAchievementsManager.new C00622(null);
                        c00612.L$0 = retroAchievementsManager;
                        c00612.J$0 = j2;
                        c00612.I$0 = 1;
                        c00612.label = 2;
                        if (BuildersKt.withContext(main3, c00622, c00612) != coroutine_suspended) {
                            long j8 = j2;
                            retroAchievementsManager2 = retroAchievementsManager;
                            j3 = j8;
                            i2 = 1;
                            RetroInterface retroInterface3 = retroAchievementsManager2.retroInterface;
                            Intrinsics.checkNotNull(retroInterface3);
                            String str4 = retroAchievementsManager2.myUsername;
                            Intrinsics.checkNotNull(str4);
                            c00612.L$0 = retroAchievementsManager2;
                            c00612.J$0 = j3;
                            c00612.I$0 = i2;
                            c00612.label = 3;
                            retroAchievementsManager3 = retroAchievementsManager2;
                            gameInfoAndUserProgress$default = RetroInterface.DefaultImpls.getGameInfoAndUserProgress$default(retroInterface3, str4, j3, 0, c00612, 4, (Object) null);
                            if (gameInfoAndUserProgress$default != coroutine_suspended) {
                                i3 = i2;
                                retroInterface = gameInfoAndUserProgress$default;
                                r6 = j3;
                                retroAchievementsManager = retroAchievementsManager3;
                                networkResponse = (NetworkResponse) retroInterface;
                                if (networkResponse instanceof NetworkResponse.Success) {
                                    com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository retroAchievementsRepository3 = retroAchievementsManager.getRetroAchievementsRepository();
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
                                    Collection collectionValues2 = response.getAchievements().values();
                                    Intrinsics.checkNotNullExpressionValue(collectionValues2, "<get-values>(...)");
                                    while (r0.hasNext()) {
                                        retroAchievementsAchievementRecordEntity = new RetroAchievementsAchievementRecordEntity(0L, j6, Long.parseLong(achievement.getId()), null, retroAchievementsManager.myUsername, 0, null, null, null, null, DefinitionKt.NO_Float_VALUE, 0, 0L, 0L, false, false, null, 131049, null);
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
                                c00612.L$0 = null;
                                c00612.I$0 = i3;
                                c00612.label = 4;
                                if (BuildersKt.withContext(main4, anonymousClass7, c00612) != coroutine_suspended) {
                                    i = i3;
                                    return Boxing.boxBoolean(i != 0);
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 2:
                        int i4 = c00612.I$0;
                        long j9 = c00612.J$0;
                        RetroAchievementsManager retroAchievementsManager5 = (RetroAchievementsManager) c00612.L$0;
                        ResultKt.throwOnFailure(retroInterface);
                        i2 = i4;
                        retroAchievementsManager2 = retroAchievementsManager5;
                        j3 = j9;
                        RetroInterface retroInterface4 = retroAchievementsManager2.retroInterface;
                        Intrinsics.checkNotNull(retroInterface4);
                        String str7 = retroAchievementsManager2.myUsername;
                        Intrinsics.checkNotNull(str7);
                        c00612.L$0 = retroAchievementsManager2;
                        c00612.J$0 = j3;
                        c00612.I$0 = i2;
                        c00612.label = 3;
                        retroAchievementsManager3 = retroAchievementsManager2;
                        gameInfoAndUserProgress$default = RetroInterface.DefaultImpls.getGameInfoAndUserProgress$default(retroInterface4, str7, j3, 0, c00612, 4, (Object) null);
                        if (gameInfoAndUserProgress$default != coroutine_suspended) {
                            i3 = i2;
                            retroInterface = gameInfoAndUserProgress$default;
                            r6 = j3;
                            retroAchievementsManager = retroAchievementsManager3;
                            networkResponse = (NetworkResponse) retroInterface;
                            if (networkResponse instanceof NetworkResponse.Success) {
                                com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository retroAchievementsRepository5 = retroAchievementsManager.getRetroAchievementsRepository();
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
                                Collection collectionValues3 = response.getAchievements().values();
                                Intrinsics.checkNotNullExpressionValue(collectionValues3, "<get-values>(...)");
                                while (r0.hasNext()) {
                                    retroAchievementsAchievementRecordEntity = new RetroAchievementsAchievementRecordEntity(0L, j6, Long.parseLong(achievement.getId()), null, retroAchievementsManager.myUsername, 0, null, null, null, null, DefinitionKt.NO_Float_VALUE, 0, 0L, 0L, false, false, null, 131049, null);
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
                            c00612.L$0 = null;
                            c00612.I$0 = i3;
                            c00612.label = 4;
                            if (BuildersKt.withContext(main4, anonymousClass7, c00612) != coroutine_suspended) {
                                i = i3;
                                return Boxing.boxBoolean(i != 0);
                            }
                        }
                        return coroutine_suspended;
                    case 3:
                        i3 = c00612.I$0;
                        long j10 = c00612.J$0;
                        retroAchievementsManager = (RetroAchievementsManager) c00612.L$0;
                        ResultKt.throwOnFailure(retroInterface);
                        r6 = j10;
                        networkResponse = (NetworkResponse) retroInterface;
                        if (networkResponse instanceof NetworkResponse.Success) {
                            com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository retroAchievementsRepository7 = retroAchievementsManager.getRetroAchievementsRepository();
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
                            Collection collectionValues4 = response.getAchievements().values();
                            Intrinsics.checkNotNullExpressionValue(collectionValues4, "<get-values>(...)");
                            while (r0.hasNext()) {
                                retroAchievementsAchievementRecordEntity = new RetroAchievementsAchievementRecordEntity(0L, j6, Long.parseLong(achievement.getId()), null, retroAchievementsManager.myUsername, 0, null, null, null, null, DefinitionKt.NO_Float_VALUE, 0, 0L, 0L, false, false, null, 131049, null);
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
                        c00612.L$0 = null;
                        c00612.I$0 = i3;
                        c00612.label = 4;
                        if (BuildersKt.withContext(main4, anonymousClass7, c00612) != coroutine_suspended) {
                            i = i3;
                            return Boxing.boxBoolean(i != 0);
                        }
                        return coroutine_suspended;
                    case 4:
                    case 5:
                        i = c00612.I$0;
                        ResultKt.throwOnFailure(retroInterface);
                        return Boxing.boxBoolean(i != 0);
                    case 6:
                        Throwable th7 = (Throwable) c00612.L$0;
                        ResultKt.throwOnFailure(retroInterface);
                        throw th7;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshMyRetroAchievementsGameRecordByGameId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshMyRetroAchievementsGameRecordByGameId$2", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00622 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00622(Continuation<? super C00622> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new C00622(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00622) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                RetroAchievementsManager.this.getRefreshingGameIdsLiveData().setValue(RetroAchievementsManager.this.refreshingGameIds);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshMyRetroAchievementsGameRecordByGameId$5, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshMyRetroAchievementsGameRecordByGameId$5", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
    public final Object refreshMyRetroAchievementsAwardsIfExpired(Continuation<? super Boolean> continuation) throws Throwable {
        C00601 c00601;
        RetroAchievementsManager retroAchievementsManager;
        Date lastUpdatedTimestamp;
        String str;
        Object objRefreshRetroAchievementsAwardsByUserId;
        if (continuation instanceof C00601) {
            c00601 = (C00601) continuation;
            if ((c00601.label & Integer.MIN_VALUE) != 0) {
                c00601.label -= Integer.MIN_VALUE;
            } else {
                c00601 = new C00601(continuation);
            }
        } else {
            c00601 = new C00601(continuation);
        }
        Object retroInterface = c00601.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00601.label;
        if (i == 0) {
            ResultKt.throwOnFailure(retroInterface);
            c00601.L$0 = this;
            c00601.label = 1;
            retroInterface = getRetroInterface(c00601);
            if (retroInterface != coroutine_suspended) {
                retroAchievementsManager = this;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            retroAchievementsManager = (RetroAchievementsManager) c00601.L$0;
            ResultKt.throwOnFailure(retroInterface);
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(retroInterface);
                return retroInterface;
            }
            retroAchievementsManager = (RetroAchievementsManager) c00601.L$0;
            ResultKt.throwOnFailure(retroInterface);
        }
        str = (String) retroInterface;
        if (str == null) {
            return Boxing.boxBoolean(false);
        }
        c00601.L$0 = null;
        c00601.label = 3;
        objRefreshRetroAchievementsAwardsByUserId = retroAchievementsManager.refreshRetroAchievementsAwardsByUserId(str, c00601);
        if (objRefreshRetroAchievementsAwardsByUserId != coroutine_suspended) {
            return coroutine_suspended;
        }
        return objRefreshRetroAchievementsAwardsByUserId;
        if (((RetroInterface) retroInterface) == null) {
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
        c00601.L$0 = retroAchievementsManager;
        c00601.label = 2;
        retroInterface = retroAchievementsManager.getMyRetroAchievementsUsername(c00601);
        if (retroInterface != coroutine_suspended) {
            str = (String) retroInterface;
            if (str == null) {
                return Boxing.boxBoolean(false);
            }
            c00601.L$0 = null;
            c00601.label = 3;
            objRefreshRetroAchievementsAwardsByUserId = retroAchievementsManager.refreshRetroAchievementsAwardsByUserId(str, c00601);
            if (objRefreshRetroAchievementsAwardsByUserId != coroutine_suspended) {
                return objRefreshRetroAchievementsAwardsByUserId;
            }
        }
        return coroutine_suspended;
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
    /* JADX WARN: Type inference failed for: r3v10, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsAwardsByUserId$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager] */
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
    public final Object refreshRetroAchievementsAwardsByUserId(String str, Continuation<? super Boolean> continuation) throws Throwable {
        RetroAchievementsManager c00651;
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
        if (continuation instanceof C00651) {
            C00651 c00652 = (C00651) continuation;
            if ((c00652.label & Integer.MIN_VALUE) != 0) {
                c00652.label -= Integer.MIN_VALUE;
                c00651 = c00652;
            } else {
                c00651 = new C00651(continuation);
            }
        } else {
            c00651 = new C00651(continuation);
        }
        Object obj2 = c00651.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c00651.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj2);
                if (this.refreshMyRetroAchievementsAwardsUserId.contains(str)) {
                    return Boxing.boxBoolean(false);
                }
                c00651.L$0 = this;
                c00651.L$1 = str;
                c00651.label = 1;
                Object retroInterface = getRetroInterface(c00651);
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
                i = c00651.I$0;
                str3 = (String) c00651.L$1;
                c00651 = (RetroAchievementsManager) c00651.L$0;
                try {
                    ResultKt.throwOnFailure(obj2);
                    str4 = str3;
                    c00651 = c00651;
                    try {
                        networkResponse = (NetworkResponse) obj2;
                        if (networkResponse instanceof NetworkResponse.Success) {
                            GetUserAwards.Response response = (GetUserAwards.Response) ((NetworkResponse.Success) networkResponse).getBody();
                            date = new Date();
                            arrayList = new ArrayList();
                            for (GetUserAwards.Response.Award award : response.getVisibleUserAwards()) {
                                RetroAchievementsUserAwardEntity retroAchievementsUserAwardEntity = new RetroAchievementsUserAwardEntity(0L, str4, award.getAwardType(), award.getAwardData(), null, null, 0, null, null, null, null, null, null, 8177, null);
                                retroAchievementsUserAwardEntity.setAwardDataExtra(Boxing.boxInt(award.getAwardDataExtra()));
                                retroAchievementsUserAwardEntity.setAwardedAt(c00651.toRetroAchievementsDate(award.getAwardedAt()));
                                retroAchievementsUserAwardEntity.setDisplayOrder(award.getDisplayOrder());
                                retroAchievementsUserAwardEntity.setTitle(award.getTitle());
                                retroAchievementsUserAwardEntity.setConsoleId(Boxing.boxLong(award.getConsoleId()));
                                retroAchievementsUserAwardEntity.setConsoleName(award.getConsoleName());
                                retroAchievementsUserAwardEntity.setFlags(Boxing.boxInt(award.getFlags()));
                                retroAchievementsUserAwardEntity.setImageUrl("https://retroachievements.org" + award.getImageIcon());
                                retroAchievementsUserAwardEntity.setLastUpdatedTimestamp(date);
                                arrayList.add(retroAchievementsUserAwardEntity);
                            }
                            c00651.getRetroAchievementsRepository().deleteRetroAchievementsUserAwardByUserId(str4);
                            RetroAchievementsRepository retroAchievementsRepository = c00651.getRetroAchievementsRepository();
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
                        c00651.refreshMyRetroAchievementsAwardsUserId.remove(str4);
                    } catch (Exception e) {
                        e = e;
                        str3 = str4;
                        c00651.logger.warn(c00651, ExceptionsKt.stackTraceToString(e));
                        c00651.refreshMyRetroAchievementsAwardsUserId.remove(str3);
                        i = 0;
                    } catch (Throwable th) {
                        th = th;
                        coroutine_suspended = str4;
                        c00651.refreshMyRetroAchievementsAwardsUserId.remove(coroutine_suspended);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    c00651.logger.warn(c00651, ExceptionsKt.stackTraceToString(e));
                    c00651.refreshMyRetroAchievementsAwardsUserId.remove(str3);
                    i = 0;
                    return Boxing.boxBoolean(i != 0);
                }
                return Boxing.boxBoolean(i != 0);
            }
            String str5 = (String) c00651.L$1;
            RetroAchievementsManager retroAchievementsManager2 = (RetroAchievementsManager) c00651.L$0;
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
                c00651.L$0 = retroAchievementsManager;
                c00651.L$1 = str2;
                c00651.I$0 = 1;
                c00651.label = 2;
                Object userAwards = retroInterface2.getUserAwards(str2, (Continuation) c00651);
                if (userAwards != coroutine_suspended) {
                    str4 = str2;
                    c00651 = retroAchievementsManager;
                    obj2 = userAwards;
                    i = 1;
                    networkResponse = (NetworkResponse) obj2;
                    if (networkResponse instanceof NetworkResponse.Success) {
                        GetUserAwards.Response response2 = (GetUserAwards.Response) ((NetworkResponse.Success) networkResponse).getBody();
                        date = new Date();
                        arrayList = new ArrayList();
                        while (r2.hasNext()) {
                            RetroAchievementsUserAwardEntity retroAchievementsUserAwardEntity2 = new RetroAchievementsUserAwardEntity(0L, str4, award.getAwardType(), award.getAwardData(), null, null, 0, null, null, null, null, null, null, 8177, null);
                            retroAchievementsUserAwardEntity2.setAwardDataExtra(Boxing.boxInt(award.getAwardDataExtra()));
                            retroAchievementsUserAwardEntity2.setAwardedAt(c00651.toRetroAchievementsDate(award.getAwardedAt()));
                            retroAchievementsUserAwardEntity2.setDisplayOrder(award.getDisplayOrder());
                            retroAchievementsUserAwardEntity2.setTitle(award.getTitle());
                            retroAchievementsUserAwardEntity2.setConsoleId(Boxing.boxLong(award.getConsoleId()));
                            retroAchievementsUserAwardEntity2.setConsoleName(award.getConsoleName());
                            retroAchievementsUserAwardEntity2.setFlags(Boxing.boxInt(award.getFlags()));
                            retroAchievementsUserAwardEntity2.setImageUrl("https://retroachievements.org" + award.getImageIcon());
                            retroAchievementsUserAwardEntity2.setLastUpdatedTimestamp(date);
                            arrayList.add(retroAchievementsUserAwardEntity2);
                        }
                        c00651.getRetroAchievementsRepository().deleteRetroAchievementsUserAwardByUserId(str4);
                        RetroAchievementsRepository retroAchievementsRepository2 = c00651.getRetroAchievementsRepository();
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
                    c00651.refreshMyRetroAchievementsAwardsUserId.remove(str4);
                    return Boxing.boxBoolean(i != 0);
                }
                return coroutine_suspended;
            } catch (Exception e3) {
                e = e3;
                str3 = str2;
                c00651 = retroAchievementsManager;
                c00651.logger.warn(c00651, ExceptionsKt.stackTraceToString(e));
                c00651.refreshMyRetroAchievementsAwardsUserId.remove(str3);
                i = 0;
                return Boxing.boxBoolean(i != 0);
            } catch (Throwable th2) {
                th = th2;
                coroutine_suspended = str2;
                c00651 = retroAchievementsManager;
                c00651.refreshMyRetroAchievementsAwardsUserId.remove(coroutine_suspended);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
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
    public final java.lang.Object refreshRetroAchievementsUserProfileDataIfExpired(java.lang.String r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager.refreshRetroAchievementsUserProfileDataIfExpired(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    /* JADX WARN: Type inference failed for: r14v1, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager, java.lang.Object] */
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
    /* JADX WARN: Type inference failed for: r46v0, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager] */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v43, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v49, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v51, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager] */
    /* JADX WARN: Type inference failed for: r5v54 */
    /* JADX WARN: Type inference failed for: r5v55 */
    /* JADX WARN: Type inference failed for: r5v56 */
    /* JADX WARN: Type inference failed for: r5v57 */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager, java.lang.Object] */
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
    public final java.lang.Object refreshRetroAchievementsUserProfileData(java.lang.String r47, kotlin.coroutines.Continuation<? super kotlin.Unit> r48) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager.refreshRetroAchievementsUserProfileData(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsUserProfileData$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsUserProfileData$2", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00732 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00732(Continuation<? super C00732> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new C00732(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00732) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                RetroAchievementsManager.this.getRefreshingUsernamesLiveData().setValue(RetroAchievementsManager.this.refreshingUsernames);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsUserProfileData$6, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$refreshRetroAchievementsUserProfileData$6", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass6(Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new AnonymousClass6(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
    public final Object getMyRetroAchievementsUsername(Continuation<? super String> continuation) {
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
                e = e2;
                retroAchievementsManager.logger.warn(retroAchievementsManager, ExceptionsKt.stackTraceToString(e));
                return null;
            }
        }
        retroAchievementsManager2 = (RetroAchievementsManager) anonymousClass1.L$0;
        try {
            ResultKt.throwOnFailure(obj);
        } catch (Exception e3) {
            e = e3;
            retroAchievementsManager = retroAchievementsManager2;
            retroAchievementsManager.logger.warn(retroAchievementsManager, ExceptionsKt.stackTraceToString(e));
            return null;
        }
        CoroutineContext main = Dispatchers.getMain();
        AnonymousClass2 anonymousClass2 = retroAchievementsManager2.new AnonymousClass2(null);
        anonymousClass1.L$0 = retroAchievementsManager2;
        anonymousClass1.label = 2;
        if (BuildersKt.withContext(main, anonymousClass2, anonymousClass1) != coroutine_suspended) {
            retroAchievementsManager = retroAchievementsManager2;
            return retroAchievementsManager.myUsername;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$getMyRetroAchievementsUsername$2, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager$getMyRetroAchievementsUsername$2", f = "RetroAchievementsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsManager.this.new AnonymousClass2(continuation);
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
        this.retroAchievementsUsernamePreferenceLiveData = new SharedPreferenceStringLiveData(getRetroAchievementsSharedPreferences(), USERNAME_PREFERENCE_STRING, null);
        this.retroAchievementsWebApiKeyPreferenceLiveData = new SharedPreferenceStringLiveData(getRetroAchievementsSharedPreferences(), WEB_API_KEY_PREFERENCE_STRING, null);
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
        this.isCreated = true;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getRetroInterface(Continuation<? super RetroInterface> continuation) {
        C00591 c00591;
        RetroAchievementsManager retroAchievementsManager;
        if (continuation instanceof C00591) {
            c00591 = (C00591) continuation;
            if ((c00591.label & Integer.MIN_VALUE) != 0) {
                c00591.label -= Integer.MIN_VALUE;
            } else {
                c00591 = new C00591(continuation);
            }
        } else {
            c00591 = new C00591(continuation);
        }
        Object obj = c00591.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00591.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.retroInterface != null && Utils.INSTANCE.isNetworkAvailable(this.application)) {
                return this.retroInterface;
            }
            c00591.L$0 = this;
            c00591.label = 1;
            if (refreshRetroAchievementsCredentials$default(this, false, c00591, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            retroAchievementsManager = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            retroAchievementsManager = (RetroAchievementsManager) c00591.L$0;
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
