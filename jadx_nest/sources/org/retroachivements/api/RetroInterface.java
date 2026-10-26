package org.retroachivements.api;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import co.infinum.retromock.meta.Mock;
import co.infinum.retromock.meta.MockResponse;
import com.haroldadmin.cnradapter.NetworkResponse;
import java.util.Date;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import org.retroachivements.api.core.DateFormat;
import org.retroachivements.api.data.pojo.ErrorResponse;
import org.retroachivements.api.data.pojo.achievement.GetAchievementUnlocks;
import org.retroachivements.api.data.pojo.comments.GetComments;
import org.retroachivements.api.data.pojo.event.GetAchievementOfTheWeek;
import org.retroachivements.api.data.pojo.feed.GetClaims;
import org.retroachivements.api.data.pojo.feed.GetRecentGameAwards;
import org.retroachivements.api.data.pojo.feed.GetTopTenUsers;
import org.retroachivements.api.data.pojo.game.GetAchievementCount;
import org.retroachivements.api.data.pojo.game.GetAchievementDistribution;
import org.retroachivements.api.data.pojo.game.GetGame;
import org.retroachivements.api.data.pojo.game.GetGameExtended;
import org.retroachivements.api.data.pojo.game.GetGameHashes;
import org.retroachivements.api.data.pojo.game.GetGameInfoAndUserProgress;
import org.retroachivements.api.data.pojo.game.GetGameLeaderboards;
import org.retroachivements.api.data.pojo.game.GetGameProgression;
import org.retroachivements.api.data.pojo.game.GetGameRankAndScore;
import org.retroachivements.api.data.pojo.game.GetLeaderboardEntries;
import org.retroachivements.api.data.pojo.game.GetUserGameLeaderboard;
import org.retroachivements.api.data.pojo.system.GetConsoleID;
import org.retroachivements.api.data.pojo.system.GetGameList;
import org.retroachivements.api.data.pojo.ticket.GetAchievementTicketStats;
import org.retroachivements.api.data.pojo.ticket.GetDeveloperTicketStats;
import org.retroachivements.api.data.pojo.ticket.GetGameTicketStats;
import org.retroachivements.api.data.pojo.ticket.GetMostRecentTickets;
import org.retroachivements.api.data.pojo.ticket.GetMostTicketedGames;
import org.retroachivements.api.data.pojo.ticket.GetTicketData;
import org.retroachivements.api.data.pojo.user.GetUserAwards;
import org.retroachivements.api.data.pojo.user.GetUserClaims;
import org.retroachivements.api.data.pojo.user.GetUserCompletedGames;
import org.retroachivements.api.data.pojo.user.GetUserCompletionProgress;
import org.retroachivements.api.data.pojo.user.GetUserGameRankAndScore;
import org.retroachivements.api.data.pojo.user.GetUserPoints;
import org.retroachivements.api.data.pojo.user.GetUserProfile;
import org.retroachivements.api.data.pojo.user.GetUserProgress;
import org.retroachivements.api.data.pojo.user.GetUserRecentAchievements;
import org.retroachivements.api.data.pojo.user.GetUserRecentlyPlayedGames;
import org.retroachivements.api.data.pojo.user.GetUserSetRequests;
import org.retroachivements.api.data.pojo.user.GetUserSummary;
import org.retroachivements.api.data.pojo.user.GetUserWantToPlayList;
import org.retroachivements.api.data.pojo.user.GetUsersFollowingMe;
import org.retroachivements.api.data.pojo.user.GetUsersIFollow;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* INFO: compiled from: RetroInterface.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000È\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\fH§@¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u0003H§@¢\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ8\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00072\b\b\u0003\u0010\u0017\u001a\u00020\f2\b\b\u0003\u0010\u0018\u001a\u00020\fH§@¢\u0006\u0002\u0010\u000eJ8\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0001\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\u001eH§@¢\u0006\u0002\u0010 J.\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0001\u0010\"\u001a\u00020\u001eH§@¢\u0006\u0002\u0010#J\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00050\u0003H§@¢\u0006\u0002\u0010\u0011J$\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010'\u001a\u00020\fH§@¢\u0006\u0002\u0010(JL\u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00072\b\b\u0003\u0010\u0018\u001a\u00020\f2\b\b\u0003\u0010\u0017\u001a\u00020\f2\b\b\u0003\u0010+\u001a\u00020\f2\b\b\u0003\u0010,\u001a\u00020\u001cH§@¢\u0006\u0002\u0010-JL\u0010.\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\u0018\u001a\u00020\f2\b\b\u0003\u0010\u0017\u001a\u00020\f2\b\b\u0003\u0010+\u001a\u00020\f2\b\b\u0003\u0010,\u001a\u00020\u001cH§@¢\u0006\u0002\u0010-JL\u0010/\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0003\u0010\u0018\u001a\u00020\f2\b\b\u0003\u0010\u0017\u001a\u00020\f2\b\b\u0003\u0010+\u001a\u00020\f2\b\b\u0003\u0010,\u001a\u00020\u001cH§@¢\u0006\u0002\u00100J.\u00101\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0003\u00103\u001a\u00020\f2\b\b\u0003\u00104\u001a\u00020\fH§@¢\u0006\u0002\u00105J$\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001cH§@¢\u0006\u0002\u00108J$\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ.\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010=\u001a\u00020\fH§@¢\u0006\u0002\u0010>J$\u0010?\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ8\u0010A\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010C\u001a\u00020\fH§@¢\u0006\u0002\u0010DJ8\u0010E\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\u0017\u001a\u00020\f2\b\b\u0003\u0010\u0018\u001a\u00020\fH§@¢\u0006\u0002\u0010\u000eJL\u0010G\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010I\u001a\u00020\u00072\b\b\u0003\u0010J\u001a\u00020\f2\b\b\u0003\u0010K\u001a\u00020\f2\b\b\u0003\u0010\u0017\u001a\u00020\f2\b\b\u0003\u0010\u0018\u001a\u00020\fH§@¢\u0006\u0002\u0010LJ.\u0010M\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\u000b\u001a\u00020\fH§@¢\u0006\u0002\u0010>J.\u0010O\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010Q\u001a\u00020\fH§@¢\u0006\u0002\u0010>JP\u0010R\u001a\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010T\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010U\u001a\u0004\u0018\u00010\f2\b\b\u0003\u0010\u0018\u001a\u00020\f2\b\b\u0003\u0010\u0017\u001a\u00020\fH§@¢\u0006\u0002\u0010VJ8\u0010W\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\u0017\u001a\u00020\f2\b\b\u0003\u0010\u0018\u001a\u00020\fH§@¢\u0006\u0002\u0010\u000eJ.\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0003\u0010\u0018\u001a\u00020\f2\b\b\u0003\u0010\u0017\u001a\u00020\fH§@¢\u0006\u0002\u00105J8\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0003\u0010\u0018\u001a\u00020\f2\b\b\u0003\u0010\u0017\u001a\u00020\f2\b\b\u0003\u0010+\u001a\u00020\fH§@¢\u0006\u0002\u0010]JB\u0010^\u001a\u000e\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0003\u0010`\u001a\u00020\u001e2\b\b\u0003\u0010\u0018\u001a\u00020\f2\b\b\u0003\u0010\u0017\u001a\u00020\f2\b\b\u0003\u0010a\u001a\u00020\u001cH§@¢\u0006\u0002\u0010bJ$\u0010c\u001a\u000e\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010e\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u001a\u0010f\u001a\u000e\u0012\u0004\u0012\u00020g\u0012\u0004\u0012\u00020\u00050\u0003H§@¢\u0006\u0002\u0010\u0011J$\u0010h\u001a\u000e\u0012\u0004\u0012\u00020i\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001cH§@¢\u0006\u0002\u00108J$\u0010j\u001a\u000e\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001cH§@¢\u0006\u0002\u00108J$\u0010l\u001a\u000e\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001cH§@¢\u0006\u0002\u00108J8\u0010n\u001a\u000e\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0003\u0010p\u001a\u00020\f2\b\b\u0003\u0010q\u001a\u00020\fH§@¢\u0006\u0002\u0010rJD\u0010s\u001a\u000e\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010u\u001a\u0004\u0018\u00010\u001c2\b\b\u0003\u0010\u0017\u001a\u00020\f2\b\b\u0003\u0010\u0018\u001a\u00020\fH§@¢\u0006\u0002\u0010vJ.\u0010w\u001a\u000e\u0012\u0004\u0012\u00020x\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010yJ$\u0010z\u001a\u000e\u0012\u0004\u0012\u00020{\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001cH§@¢\u0006\u0002\u00108J$\u0010|\u001a\u000e\u0012\u0004\u0012\u00020}\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001cH§@¢\u0006\u0002\u00108J/\u0010~\u001a\u000e\u0012\u0004\u0012\u00020\u007f\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0001\u0010\u0006\u001a\u00020\u001cH§@¢\u0006\u0003\u0010\u0080\u0001J0\u0010\u0081\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\t\b\u0003\u0010\u0082\u0001\u001a\u00020\u0007H§@¢\u0006\u0002\u0010yJ:\u0010\u0083\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0084\u0001\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0003\u0010\u0018\u001a\u00020\f2\b\b\u0003\u0010\u0017\u001a\u00020\fH§@¢\u0006\u0002\u0010rJ2\u0010\u0085\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0086\u0001\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010u\u001a\u00020\u001c2\t\b\u0003\u0010\u0087\u0001\u001a\u00020\fH§@¢\u0006\u0003\u0010\u0088\u0001J&\u0010\u0089\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u008a\u0001\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001cH§@¢\u0006\u0002\u00108J:\u0010\u008b\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u008c\u0001\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0003\u0010p\u001a\u00020\f2\b\b\u0003\u0010q\u001a\u00020\fH§@¢\u0006\u0002\u0010rJ0\u0010\u008d\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u008e\u0001\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0003\u0010\u0017\u001a\u00020\f2\b\b\u0003\u0010\u0018\u001a\u00020\fH§@¢\u0006\u0002\u00105J0\u0010\u008f\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0090\u0001\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0003\u0010\u0017\u001a\u00020\f2\b\b\u0003\u0010\u0018\u001a\u00020\fH§@¢\u0006\u0002\u00105¨\u0006\u0091\u0001"}, d2 = {"Lorg/retroachivements/api/RetroInterface;", "", "getAchievementCount", "Lcom/haroldadmin/cnradapter/NetworkResponse;", "Lorg/retroachivements/api/data/pojo/game/GetAchievementCount$Response;", "Lorg/retroachivements/api/data/pojo/ErrorResponse;", "gameId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAchievementDistribution", "Lorg/retroachivements/api/data/pojo/game/GetAchievementDistribution$Response;", "hardcore", "", "official", "(JIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAchievementOfTheWeek", "Lorg/retroachivements/api/data/pojo/event/GetAchievementOfTheWeek$Response;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAchievementTicketStats", "Lorg/retroachivements/api/data/pojo/ticket/GetAchievementTicketStats$Response;", "achievementId", "getAchievementUnlocks", "Lorg/retroachivements/api/data/pojo/achievement/GetAchievementUnlocks$Response;", TypedValues.CycleType.S_WAVE_OFFSET, "count", "getAchievementsEarnedBetween", "Lorg/retroachivements/api/data/pojo/user/GetUserRecentAchievements$Response;", "username", "", "fromDate", "Ljava/util/Date;", "toDate", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAchievementsEarnedOnDay", "date", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveClaims", "Lorg/retroachivements/api/data/pojo/feed/GetClaims$Response;", "getClaims", "claimKind", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCommentsOnAchievementWall", "Lorg/retroachivements/api/data/pojo/comments/GetComments$Response;", "type", "sort", "(JIIILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCommentsOnGameWall", "getCommentsOnUserWall", "(Ljava/lang/String;IIILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConsoleIds", "Lorg/retroachivements/api/data/pojo/system/GetConsoleID$Response;", "activeSystemsOnly", "gameSystemsOnly", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeveloperTicketStats", "Lorg/retroachivements/api/data/pojo/ticket/GetDeveloperTicketStats$Response;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGame", "Lorg/retroachivements/api/data/pojo/game/GetGame$Response;", "getGameExtended", "Lorg/retroachivements/api/data/pojo/game/GetGameExtended$Response;", "unofficial", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGameHashes", "Lorg/retroachivements/api/data/pojo/game/GetGameHashes$Response;", "getGameInfoAndUserProgress", "Lorg/retroachivements/api/data/pojo/game/GetGameInfoAndUserProgress$Response;", "includeUserAward", "(Ljava/lang/String;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGameLeaderboards", "Lorg/retroachivements/api/data/pojo/game/GetGameLeaderboards$Response;", "getGameList", "Lorg/retroachivements/api/data/pojo/system/GetGameList$Response;", "consoleId", "shouldOnlyRetrieveGamesWithAchievements", "shouldRetrieveGameHashes", "(JIIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGameProgression", "Lorg/retroachivements/api/data/pojo/game/GetGameProgression$Response;", "getGameRankAndScore", "Lorg/retroachivements/api/data/pojo/game/GetGameRankAndScore$Response;", "masters", "getGameTicketStats", "Lorg/retroachivements/api/data/pojo/ticket/GetGameTicketStats$Response;", "shouldReturnTicketsList", "isGettingTicketsForUnofficialAchievements", "(JLjava/lang/Integer;Ljava/lang/Integer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLeaderboardEntries", "Lorg/retroachivements/api/data/pojo/game/GetLeaderboardEntries$Response;", "getMostRecentTickets", "Lorg/retroachivements/api/data/pojo/ticket/GetMostRecentTickets$Response;", "getMostTicketedGames", "Lorg/retroachivements/api/data/pojo/ticket/GetMostTicketedGames$Response;", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentGameAwards", "Lorg/retroachivements/api/data/pojo/feed/GetRecentGameAwards$Response;", "startingDate", "kinds", "(Ljava/util/Date;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTicket", "Lorg/retroachivements/api/data/pojo/ticket/GetTicketData$Response;", "ticketId", "getTopTenUsers", "Lorg/retroachivements/api/data/pojo/feed/GetTopTenUsers$Response;", "getUserAwards", "Lorg/retroachivements/api/data/pojo/user/GetUserAwards$Response;", "getUserClaims", "Lorg/retroachivements/api/data/pojo/user/GetUserClaims$Response;", "getUserCompletedGames", "Lorg/retroachivements/api/data/pojo/user/GetUserCompletedGames$Response;", "getUserCompletionProgress", "Lorg/retroachivements/api/data/pojo/user/GetUserCompletionProgress$Response;", "maxRecords", "skipRecords", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserGameLeaderboards", "Lorg/retroachivements/api/data/pojo/game/GetUserGameLeaderboard$Response;", "userId", "(JLjava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserGameRankAndScore", "Lorg/retroachivements/api/data/pojo/user/GetUserGameRankAndScore$Response;", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserPoints", "Lorg/retroachivements/api/data/pojo/user/GetUserPoints$Response;", "getUserProfile", "Lorg/retroachivements/api/data/pojo/user/GetUserProfile$Response;", "getUserProgress", "Lorg/retroachivements/api/data/pojo/user/GetUserProgress$Response;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserRecentAchievements", "minutes", "getUserRecentlyPlayedGames", "Lorg/retroachivements/api/data/pojo/user/GetUserRecentlyPlayedGames$Response;", "getUserSetRequests", "Lorg/retroachivements/api/data/pojo/user/GetUserSetRequests$Response;", "all", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserSummary", "Lorg/retroachivements/api/data/pojo/user/GetUserSummary$Response;", "getUserWantToPlayList", "Lorg/retroachivements/api/data/pojo/user/GetUserWantToPlayList$Response;", "getUsersFollowingMe", "Lorg/retroachivements/api/data/pojo/user/GetUsersFollowingMe$Response;", "getUsersIFollow", "Lorg/retroachivements/api/data/pojo/user/GetUsersIFollow$Response;", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface RetroInterface {
    @Mock
    @POST("/API/API_GetAchievementCount.php")
    @MockResponse(body = "/v1/game/GetAchievementCount.json")
    Object getAchievementCount(@Query("i") long j, Continuation<? super NetworkResponse<GetAchievementCount.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetAchievementDistribution.php")
    @MockResponse(body = "/v1/game/GetAchievementDistribution.json")
    Object getAchievementDistribution(@Query("i") long j, @Query("h") int i, @Query("f") int i2, Continuation<? super NetworkResponse<GetAchievementDistribution.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetAchievementOfTheWeek.php")
    @MockResponse(body = "/v1/event/GetAchievementOfTheWeek.json")
    Object getAchievementOfTheWeek(Continuation<? super NetworkResponse<GetAchievementOfTheWeek.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetTicketData.php")
    @MockResponse(body = "/v1/ticket/GetAchievementTicketStats.json")
    Object getAchievementTicketStats(@Query("a") long j, Continuation<? super NetworkResponse<GetAchievementTicketStats.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetAchievementUnlocks.php")
    @MockResponse(body = "/v1/achievement/GetAchievementUnlocks.json")
    Object getAchievementUnlocks(@Query("a") long j, @Query("o") int i, @Query("c") int i2, Continuation<? super NetworkResponse<GetAchievementUnlocks.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetAchievementsEarnedBetween.php")
    @MockResponse(body = "/v1/user/GetAchievementsEarnedBetween.json")
    Object getAchievementsEarnedBetween(@Query("u") String str, @DateFormat("yyyy-MM-dd") @Query("f") Date date, @DateFormat("yyyy-MM-dd") @Query("t") Date date2, Continuation<? super NetworkResponse<GetUserRecentAchievements.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetAchievementsEarnedOnDay.php")
    @MockResponse(body = "/v1/user/GetAchievementsEarnedOnDay.json")
    Object getAchievementsEarnedOnDay(@Query("u") String str, @DateFormat("yyyy-MM-dd") @Query("d") Date date, Continuation<? super NetworkResponse<GetUserRecentAchievements.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetActiveClaims.php")
    @MockResponse(body = "/v1/feed/GetActiveClaims.json")
    Object getActiveClaims(Continuation<? super NetworkResponse<GetClaims.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetClaims.php")
    @MockResponse(body = "/v1/feed/GetClaims.json")
    Object getClaims(@Query("k") int i, Continuation<? super NetworkResponse<GetClaims.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetComments.php")
    @MockResponse(body = "/v1/comments/GetCommentsOnAchievementWall.json")
    Object getCommentsOnAchievementWall(@Query("i") long j, @Query("c") int i, @Query("o") int i2, @Query("t") int i3, @Query("sort") String str, Continuation<? super NetworkResponse<GetComments.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetComments.php")
    @MockResponse(body = "/v1/comments/GetCommentsOnGameWall.json")
    Object getCommentsOnGameWall(@Query("i") long j, @Query("c") int i, @Query("o") int i2, @Query("t") int i3, @Query("sort") String str, Continuation<? super NetworkResponse<GetComments.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetComments.php")
    @MockResponse(body = "/v1/comments/GetCommentsOnUserWall.json")
    Object getCommentsOnUserWall(@Query("i") String str, @Query("c") int i, @Query("o") int i2, @Query("t") int i3, @Query("sort") String str2, Continuation<? super NetworkResponse<GetComments.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetConsoleIDs.php")
    @MockResponse(body = "/v1/system/GetConsoleIDs.json")
    Object getConsoleIds(@Query("a") int i, @Query("g") int i2, Continuation<? super NetworkResponse<GetConsoleID.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetTicketData.php")
    @MockResponse(body = "/v1/ticket/GetDeveloperTicketStats.json")
    Object getDeveloperTicketStats(@Query("u") String str, Continuation<? super NetworkResponse<GetDeveloperTicketStats.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetGame.php")
    @MockResponse(body = "/v1/game/GetGame.json")
    Object getGame(@Query("i") long j, Continuation<? super NetworkResponse<GetGame.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetGameExtended.php")
    @MockResponse(body = "/v1/game/GetGameExtended.json")
    Object getGameExtended(@Query("i") long j, @Query("f") int i, Continuation<? super NetworkResponse<GetGameExtended.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetGameHashes.php")
    @MockResponse(body = "/v1/game/GetGameHashes.json")
    Object getGameHashes(@Query("i") long j, Continuation<? super NetworkResponse<GetGameHashes.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetGameInfoAndUserProgress.php")
    @MockResponse(body = "/v1/game/GetGameInfoAndUserProgress.json")
    Object getGameInfoAndUserProgress(@Query("u") String str, @Query("g") long j, @Query("a") int i, Continuation<? super NetworkResponse<GetGameInfoAndUserProgress.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetGameLeaderboards.php")
    @MockResponse(body = "/v1/game/GetGameLeaderboards.json")
    Object getGameLeaderboards(@Query("i") long j, @Query("o") int i, @Query("c") int i2, Continuation<? super NetworkResponse<GetGameLeaderboards.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetGameList.php")
    @MockResponse(body = "/v1/system/GetGameList.json")
    Object getGameList(@Query("i") long j, @Query("f") int i, @Query("h") int i2, @Query("o") int i3, @Query("c") int i4, Continuation<? super NetworkResponse<GetGameList.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetGameProgression.php")
    @MockResponse(body = "/v1/game/GetGameProgression.json")
    Object getGameProgression(@Query("i") long j, @Query("h") int i, Continuation<? super NetworkResponse<GetGameProgression.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetGameRankAndScore.php")
    @MockResponse(body = "/v1/game/GetGameRankAndScore.json")
    Object getGameRankAndScore(@Query("g") long j, @Query("t") int i, Continuation<? super NetworkResponse<GetGameRankAndScore.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetTicketData.php")
    @MockResponse(body = "/v1/ticket/GetGameTicketStats.json")
    Object getGameTicketStats(@Query("g") long j, @Query("d") Integer num, @Query("f") Integer num2, @Query("c") int i, @Query("o") int i2, Continuation<? super NetworkResponse<GetGameTicketStats.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetLeaderboardEntries.php")
    @MockResponse(body = "/v1/game/GetLeaderboardEntries.json")
    Object getLeaderboardEntries(@Query("i") long j, @Query("o") int i, @Query("c") int i2, Continuation<? super NetworkResponse<GetLeaderboardEntries.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetTicketData.php")
    @MockResponse(body = "/v1/ticket/GetMostRecentTickets.json")
    Object getMostRecentTickets(@Query("c") int i, @Query("o") int i2, Continuation<? super NetworkResponse<GetMostRecentTickets.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetTicketData.php")
    @MockResponse(body = "/v1/ticket/GetMostTicketedGames.json")
    Object getMostTicketedGames(@Query("c") int i, @Query("o") int i2, @Query("f") int i3, Continuation<? super NetworkResponse<GetMostTicketedGames.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetRecentGameAwards.php")
    @MockResponse(body = "/v1/feed/GetRecentGameAwards.json")
    Object getRecentGameAwards(@DateFormat("yyyy-MM-dd") @Query("d") Date date, @Query("c") int i, @Query("o") int i2, @Query("k") String str, Continuation<? super NetworkResponse<GetRecentGameAwards.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetTicketData.php")
    @MockResponse(body = "/v1/ticket/GetTicket.json")
    Object getTicket(@Query("i") long j, Continuation<? super NetworkResponse<GetTicketData.Response, ErrorResponse>> continuation);

    @Mock
    @GET("/API/API_GetTopTenUsers.php")
    @MockResponse(body = "/v1/feed/GetTopTenUsers.json")
    Object getTopTenUsers(Continuation<? super NetworkResponse<GetTopTenUsers.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetUserAwards.php")
    @MockResponse(body = "/v1/user/GetUserAwards.json")
    Object getUserAwards(@Query("u") String str, Continuation<? super NetworkResponse<GetUserAwards.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetUserClaims.php")
    @MockResponse(body = "/v1/user/GetUserClaims.json")
    Object getUserClaims(@Query("u") String str, Continuation<? super NetworkResponse<GetUserClaims.Response, ErrorResponse>> continuation);

    @MockResponse(body = "/v1/user/GetUserCompletedGames.json")
    @Deprecated(message = "This endpoint is considered legacy. The `getUserCompletionProgress` endpoint will almost always be a better fit for your use case.")
    @Mock
    @POST("/API/API_GetUserCompletedGames.php")
    Object getUserCompletedGames(@Query("u") String str, Continuation<? super NetworkResponse<GetUserCompletedGames.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetUserCompletionProgress.php")
    @MockResponse(body = "/v1/user/GetUserCompletionProgress.json")
    Object getUserCompletionProgress(@Query("u") String str, @Query("c") int i, @Query("o") int i2, Continuation<? super NetworkResponse<GetUserCompletionProgress.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetUserGameLeaderboards.php")
    @MockResponse(body = "/v1/game/GetUserGameLeaderboards.json")
    Object getUserGameLeaderboards(@Query("i") long j, @Query("u") String str, @Query("o") int i, @Query("c") int i2, Continuation<? super NetworkResponse<GetUserGameLeaderboard.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetUserGameRankAndScore.php")
    @MockResponse(body = "/v1/user/GetUserGameRankAndScore.json")
    Object getUserGameRankAndScore(@Query("u") String str, @Query("g") long j, Continuation<? super NetworkResponse<GetUserGameRankAndScore.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetUserPoints.php")
    @MockResponse(body = "/v1/user/GetUserPoints.json")
    Object getUserPoints(@Query("u") String str, Continuation<? super NetworkResponse<GetUserPoints.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetUserProfile.php")
    @MockResponse(body = "/v1/user/GetUserProfile.json")
    Object getUserProfile(@Query("u") String str, Continuation<? super NetworkResponse<GetUserProfile.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetUserProgress.php")
    @MockResponse(body = "/v1/user/GetUserProgress.json")
    Object getUserProgress(@Query("u") String str, @Query("i") String str2, Continuation<? super NetworkResponse<GetUserProgress.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetUserRecentAchievements.php")
    @MockResponse(body = "/v1/user/GetUserRecentAchievements.json")
    Object getUserRecentAchievements(@Query("u") String str, @Query("m") long j, Continuation<? super NetworkResponse<GetUserRecentAchievements.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetUserRecentlyPlayedGames.php")
    @MockResponse(body = "/v1/user/GetUserRecentlyPlayedGames.json")
    Object getUserRecentlyPlayedGames(@Query("u") String str, @Query("c") int i, @Query("o") int i2, Continuation<? super NetworkResponse<GetUserRecentlyPlayedGames.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetUserSetRequests.php")
    @MockResponse(body = "/v1/user/GetUserSetRequests.json")
    Object getUserSetRequests(@Query("u") String str, @Query("t") int i, Continuation<? super NetworkResponse<GetUserSetRequests.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetUserSummary.php")
    @MockResponse(body = "/v1/user/GetUserSummary.json")
    Object getUserSummary(@Query("u") String str, Continuation<? super NetworkResponse<GetUserSummary.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetUserWantToPlayList.php")
    @MockResponse(body = "/v1/user/GetUserWantToPlayList.json")
    Object getUserWantToPlayList(@Query("u") String str, @Query("c") int i, @Query("o") int i2, Continuation<? super NetworkResponse<GetUserWantToPlayList.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetUsersFollowingMe.php")
    @MockResponse(body = "/v1/user/GetUsersFollowingMe.json")
    Object getUsersFollowingMe(@Query("o") int i, @Query("c") int i2, Continuation<? super NetworkResponse<GetUsersFollowingMe.Response, ErrorResponse>> continuation);

    @Mock
    @POST("/API/API_GetUsersIFollow.php")
    @MockResponse(body = "/v1/user/GetUsersIFollow.json")
    Object getUsersIFollow(@Query("o") int i, @Query("c") int i2, Continuation<? super NetworkResponse<GetUsersIFollow.Response, ErrorResponse>> continuation);

    /* INFO: compiled from: RetroInterface.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getUserRecentAchievements$default(RetroInterface retroInterface, String str, long j, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserRecentAchievements");
            }
            if ((i & 2) != 0) {
                j = 60;
            }
            return retroInterface.getUserRecentAchievements(str, j, continuation);
        }

        public static /* synthetic */ Object getGameInfoAndUserProgress$default(RetroInterface retroInterface, String str, long j, int i, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGameInfoAndUserProgress");
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return retroInterface.getGameInfoAndUserProgress(str, j, i, continuation);
        }

        public static /* synthetic */ Object getGameProgression$default(RetroInterface retroInterface, long j, int i, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGameProgression");
            }
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return retroInterface.getGameProgression(j, i, continuation);
        }

        public static /* synthetic */ Object getUserCompletionProgress$default(RetroInterface retroInterface, String str, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserCompletionProgress");
            }
            if ((i3 & 2) != 0) {
                i = 100;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            return retroInterface.getUserCompletionProgress(str, i, i2, continuation);
        }

        public static /* synthetic */ Object getUserRecentlyPlayedGames$default(RetroInterface retroInterface, String str, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserRecentlyPlayedGames");
            }
            if ((i3 & 2) != 0) {
                i = 10;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            return retroInterface.getUserRecentlyPlayedGames(str, i, i2, continuation);
        }

        public static /* synthetic */ Object getUserWantToPlayList$default(RetroInterface retroInterface, String str, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserWantToPlayList");
            }
            if ((i3 & 2) != 0) {
                i = 100;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            return retroInterface.getUserWantToPlayList(str, i, i2, continuation);
        }

        public static /* synthetic */ Object getUsersIFollow$default(RetroInterface retroInterface, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUsersIFollow");
            }
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = 100;
            }
            return retroInterface.getUsersIFollow(i, i2, continuation);
        }

        public static /* synthetic */ Object getUsersFollowingMe$default(RetroInterface retroInterface, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUsersFollowingMe");
            }
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = 100;
            }
            return retroInterface.getUsersFollowingMe(i, i2, continuation);
        }

        public static /* synthetic */ Object getUserSetRequests$default(RetroInterface retroInterface, String str, int i, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserSetRequests");
            }
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return retroInterface.getUserSetRequests(str, i, continuation);
        }

        public static /* synthetic */ Object getGameExtended$default(RetroInterface retroInterface, long j, int i, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGameExtended");
            }
            if ((i2 & 2) != 0) {
                i = 3;
            }
            return retroInterface.getGameExtended(j, i, continuation);
        }

        public static /* synthetic */ Object getAchievementDistribution$default(RetroInterface retroInterface, long j, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAchievementDistribution");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                i2 = 3;
            }
            return retroInterface.getAchievementDistribution(j, i4, i2, continuation);
        }

        public static /* synthetic */ Object getGameRankAndScore$default(RetroInterface retroInterface, long j, int i, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGameRankAndScore");
            }
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return retroInterface.getGameRankAndScore(j, i, continuation);
        }

        public static /* synthetic */ Object getGameLeaderboards$default(RetroInterface retroInterface, long j, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGameLeaderboards");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                i2 = 100;
            }
            return retroInterface.getGameLeaderboards(j, i4, i2, continuation);
        }

        public static /* synthetic */ Object getLeaderboardEntries$default(RetroInterface retroInterface, long j, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLeaderboardEntries");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                i2 = 100;
            }
            return retroInterface.getLeaderboardEntries(j, i4, i2, continuation);
        }

        public static /* synthetic */ Object getUserGameLeaderboards$default(RetroInterface retroInterface, long j, String str, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserGameLeaderboards");
            }
            if ((i3 & 2) != 0) {
                str = null;
            }
            String str2 = str;
            if ((i3 & 4) != 0) {
                i = 0;
            }
            int i4 = i;
            if ((i3 & 8) != 0) {
                i2 = 100;
            }
            return retroInterface.getUserGameLeaderboards(j, str2, i4, i2, continuation);
        }

        public static /* synthetic */ Object getConsoleIds$default(RetroInterface retroInterface, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConsoleIds");
            }
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            return retroInterface.getConsoleIds(i, i2, continuation);
        }

        public static /* synthetic */ Object getGameList$default(RetroInterface retroInterface, long j, int i, int i2, int i3, int i4, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGameList");
            }
            if ((i5 & 2) != 0) {
                i = 0;
            }
            if ((i5 & 4) != 0) {
                i2 = 0;
            }
            if ((i5 & 8) != 0) {
                i3 = 0;
            }
            if ((i5 & 16) != 0) {
                i4 = 0;
            }
            return retroInterface.getGameList(j, i, i2, i3, i4, continuation);
        }

        public static /* synthetic */ Object getAchievementUnlocks$default(RetroInterface retroInterface, long j, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAchievementUnlocks");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                i2 = 50;
            }
            return retroInterface.getAchievementUnlocks(j, i4, i2, continuation);
        }

        public static /* synthetic */ Object getRecentGameAwards$default(RetroInterface retroInterface, Date date, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRecentGameAwards");
            }
            if ((i3 & 1) != 0) {
                date = new Date();
            }
            return retroInterface.getRecentGameAwards(date, (i3 & 2) != 0 ? 25 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{"beaten-softcore", "beaten-hardcore", "completed", "mastered"}), null, null, null, 0, null, null, 63, null) : str, continuation);
        }

        public static /* synthetic */ Object getMostTicketedGames$default(RetroInterface retroInterface, int i, int i2, int i3, Continuation continuation, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMostTicketedGames");
            }
            if ((i4 & 1) != 0) {
                i = 10;
            }
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = 1;
            }
            return retroInterface.getMostTicketedGames(i, i2, i3, continuation);
        }

        public static /* synthetic */ Object getMostRecentTickets$default(RetroInterface retroInterface, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMostRecentTickets");
            }
            if ((i3 & 1) != 0) {
                i = 10;
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            return retroInterface.getMostRecentTickets(i, i2, continuation);
        }

        public static /* synthetic */ Object getGameTicketStats$default(RetroInterface retroInterface, long j, Integer num, Integer num2, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGameTicketStats");
            }
            if ((i3 & 2) != 0) {
                num = null;
            }
            if ((i3 & 4) != 0) {
                num2 = null;
            }
            if ((i3 & 8) != 0) {
                i = 10;
            }
            if ((i3 & 16) != 0) {
                i2 = 0;
            }
            return retroInterface.getGameTicketStats(j, num, num2, i, i2, continuation);
        }

        public static /* synthetic */ Object getCommentsOnUserWall$default(RetroInterface retroInterface, String str, int i, int i2, int i3, String str2, Continuation continuation, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCommentsOnUserWall");
            }
            if ((i4 & 2) != 0) {
                i = 10;
            }
            int i5 = i;
            if ((i4 & 4) != 0) {
                i2 = 0;
            }
            int i6 = i2;
            if ((i4 & 8) != 0) {
                i3 = 3;
            }
            int i7 = i3;
            if ((i4 & 16) != 0) {
                str2 = "submitted";
            }
            return retroInterface.getCommentsOnUserWall(str, i5, i6, i7, str2, continuation);
        }

        public static /* synthetic */ Object getCommentsOnGameWall$default(RetroInterface retroInterface, long j, int i, int i2, int i3, String str, Continuation continuation, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCommentsOnGameWall");
            }
            if ((i4 & 2) != 0) {
                i = 10;
            }
            int i5 = i;
            if ((i4 & 4) != 0) {
                i2 = 0;
            }
            int i6 = i2;
            if ((i4 & 8) != 0) {
                i3 = 1;
            }
            int i7 = i3;
            if ((i4 & 16) != 0) {
                str = "submitted";
            }
            return retroInterface.getCommentsOnGameWall(j, i5, i6, i7, str, continuation);
        }

        public static /* synthetic */ Object getCommentsOnAchievementWall$default(RetroInterface retroInterface, long j, int i, int i2, int i3, String str, Continuation continuation, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCommentsOnAchievementWall");
            }
            if ((i4 & 2) != 0) {
                i = 10;
            }
            int i5 = i;
            if ((i4 & 4) != 0) {
                i2 = 0;
            }
            int i6 = i2;
            if ((i4 & 8) != 0) {
                i3 = 2;
            }
            int i7 = i3;
            if ((i4 & 16) != 0) {
                str = "submitted";
            }
            return retroInterface.getCommentsOnAchievementWall(j, i5, i6, i7, str, continuation);
        }
    }
}
