package com.magneticchen.daijishou.data.db.repositories;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.db.RetroAchievementsDatabase;
import com.magneticchen.daijishou.data.db.dao.RetroAchievementsAchievementRecordDAO;
import com.magneticchen.daijishou.data.db.dao.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO;
import com.magneticchen.daijishou.data.db.dao.RetroAchievementsGameRecordDAO;
import com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserAwardDAO;
import com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserIndependentGameRecordDAO;
import com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserProfileDAO;
import com.magneticchen.daijishou.data.db.dao.RetroAchievementsUserRankingDAO;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsAchievementRecordEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsGameRecordEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserAwardEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserIndependentGameRecordEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserProfileEntity;
import com.magneticchen.daijishou.data.db.entity.RetroAchievementsUserRankingEntity;
import com.skydoves.balloon.internals.DefinitionKt;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: RetroAchievementsRepository.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\bI\n\u0002\u0010\u0016\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0002Ì\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0!\"\u00020\u001d¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%J%\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+J%\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020+0!\"\u00020+¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u000201J%\u00102\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u0002010!\"\u000201¢\u0006\u0002\u00104J\u000e\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u000207J%\u00108\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0012\u00109\u001a\n\u0012\u0006\b\u0001\u0012\u0002070!\"\u000207¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020=J%\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0012\u0010?\u001a\n\u0012\u0006\b\u0001\u0012\u00020=0!\"\u00020=¢\u0006\u0002\u0010@J\u000e\u0010A\u001a\u00020\u001b2\u0006\u00100\u001a\u00020BJ%\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u00020B0!\"\u00020B¢\u0006\u0002\u0010DJ\u0006\u0010E\u001a\u00020FJ\f\u0010G\u001a\b\u0012\u0004\u0012\u00020I0HJ\u0006\u0010J\u001a\u00020IJ\f\u0010K\u001a\b\u0012\u0004\u0012\u00020I0HJ\u0006\u0010L\u001a\u00020IJ\f\u0010M\u001a\b\u0012\u0004\u0012\u00020I0HJ\u0006\u0010N\u001a\u00020IJ\f\u0010O\u001a\b\u0012\u0004\u0012\u00020I0HJ\u0006\u0010P\u001a\u00020IJ\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020I0HJ\u0006\u0010R\u001a\u00020IJ\f\u0010S\u001a\b\u0012\u0004\u0012\u00020I0HJ\u0006\u0010T\u001a\u00020IJ\f\u0010U\u001a\b\u0012\u0004\u0012\u00020I0HJ\u0006\u0010V\u001a\u00020IJ\u000e\u0010W\u001a\u00020F2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001f\u0010X\u001a\u00020F2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0!\"\u00020\u001d¢\u0006\u0002\u0010YJ\u000e\u0010Z\u001a\u00020F2\u0006\u0010$\u001a\u00020%J\u000e\u0010[\u001a\u00020F2\u0006\u0010\\\u001a\u00020\u001bJ\u000e\u0010]\u001a\u00020F2\u0006\u0010\\\u001a\u00020\u001bJ\u001f\u0010^\u001a\u00020F2\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%¢\u0006\u0002\u0010_J\u000e\u0010`\u001a\u00020F2\u0006\u0010*\u001a\u00020+J\u001f\u0010a\u001a\u00020F2\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020+0!\"\u00020+¢\u0006\u0002\u0010bJ\u000e\u0010c\u001a\u00020F2\u0006\u00100\u001a\u000201J\u000e\u0010d\u001a\u00020I2\u0006\u0010e\u001a\u00020\u001bJ\u000e\u0010f\u001a\u00020I2\u0006\u0010g\u001a\u00020\u0005J\u001f\u0010h\u001a\u00020F2\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u0002010!\"\u000201¢\u0006\u0002\u0010iJ\u000e\u0010j\u001a\u00020F2\u0006\u00106\u001a\u000207J\u001f\u0010k\u001a\u00020F2\u0012\u00109\u001a\n\u0012\u0006\b\u0001\u0012\u0002070!\"\u000207¢\u0006\u0002\u0010lJ\u000e\u0010m\u001a\u00020I2\u0006\u0010e\u001a\u00020\u001bJ\u000e\u0010n\u001a\u00020F2\u0006\u0010<\u001a\u00020=J\u001f\u0010o\u001a\u00020F2\u0012\u0010?\u001a\n\u0012\u0006\b\u0001\u0012\u00020=0!\"\u00020=¢\u0006\u0002\u0010pJ\u000e\u0010q\u001a\u00020F2\u0006\u00100\u001a\u00020BJ\u001f\u0010r\u001a\u00020F2\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u00020B0!\"\u00020B¢\u0006\u0002\u0010sJ$\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u001f0H2\u0006\u0010u\u001a\u00020\u00052\b\b\u0002\u0010v\u001a\u00020IJ,\u0010w\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u001f0H2\u0006\u0010u\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u001b2\b\b\u0002\u0010v\u001a\u00020IJ&\u0010x\u001a\b\u0012\u0004\u0012\u0002070\u001f2\u0006\u0010u\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u001b2\b\b\u0002\u0010v\u001a\u00020IJ\u001e\u0010y\u001a\b\u0012\u0004\u0012\u0002070\u001f2\u0006\u0010u\u001a\u00020\u00052\b\b\u0002\u0010v\u001a\u00020IJ\u0012\u0010z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u001f0HJ\f\u0010{\u001a\b\u0012\u0004\u0012\u0002010\u001fJ\u0016\u0010|\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001070H2\u0006\u0010e\u001a\u00020\u001bJ\u0010\u0010}\u001a\u0004\u0018\u0001072\u0006\u0010e\u001a\u00020\u001bJ\u0016\u0010~\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0H2\u0006\u0010\\\u001a\u00020\u001bJ\u0010\u0010\u007f\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\\\u001a\u00020\u001bJ\u001b\u0010\u0080\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001f0H2\u0006\u0010\\\u001a\u00020\u001bJ\u0015\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001f2\u0006\u0010\\\u001a\u00020\u001bJ\u001b\u0010\u0082\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001f0H2\u0006\u0010\\\u001a\u00020\u0005J\u0015\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001f2\u0006\u0010\\\u001a\u00020\u0005J\u0017\u0010\u0084\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0H2\u0006\u0010\\\u001a\u00020\u001bJ\u0011\u0010\u0085\u0001\u001a\u0004\u0018\u00010%2\u0006\u0010\\\u001a\u00020\u001bJ\u0017\u0010\u0086\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0H2\u0006\u0010\\\u001a\u00020\u001bJ\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010%2\u0006\u0010\\\u001a\u00020\u001bJ\u001b\u0010\u0088\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001f0H2\u0006\u0010\\\u001a\u00020\u001bJ\u0015\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020%0\u001f2\u0006\u0010\\\u001a\u00020\u001bJ\u0017\u0010\u008a\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0H2\u0006\u0010\\\u001a\u00020\u001bJ\u0011\u0010\u008b\u0001\u001a\u0004\u0018\u00010+2\u0006\u0010\\\u001a\u00020\u001bJ \u0010\u008c\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0H2\u0006\u0010g\u001a\u00020\u00052\u0007\u0010\u008d\u0001\u001a\u00020\u001bJ\u001a\u0010\u008e\u0001\u001a\u0004\u0018\u00010+2\u0006\u0010g\u001a\u00020\u00052\u0007\u0010\u008d\u0001\u001a\u00020\u001bJ\u001b\u0010\u008f\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u001f0H2\u0006\u0010\\\u001a\u00020\u001bJ\u0015\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020+0\u001f2\u0006\u0010\\\u001a\u00020\u001bJ!\u0010\u0091\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u001f0H2\f\u0010\u0092\u0001\u001a\u00030\u0093\u0001\"\u00020\u001bJ\u001b\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020+0\u001f2\f\u0010\u0092\u0001\u001a\u00030\u0093\u0001\"\u00020\u001bJ\u001b\u0010\u0095\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u001f0H2\u0006\u0010\\\u001a\u00020\u0005J)\u0010\u0096\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u001f0H2\u0006\u0010g\u001a\u00020\u00052\f\u0010\u0097\u0001\u001a\u00030\u0093\u0001\"\u00020\u001bJ#\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020+0\u001f2\u0006\u0010g\u001a\u00020\u00052\f\u0010\u0097\u0001\u001a\u00030\u0093\u0001\"\u00020\u001bJ\u0015\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020+0\u001f2\u0006\u0010\\\u001a\u00020\u0005J\u0017\u0010\u009a\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001010H2\u0006\u0010\\\u001a\u00020\u001bJ\u0011\u0010\u009b\u0001\u001a\u0004\u0018\u0001012\u0006\u0010\\\u001a\u00020\u001bJ\u001b\u0010\u009c\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u001f0H2\u0006\u0010e\u001a\u00020\u001bJ\u0011\u0010\u009d\u0001\u001a\u0004\u0018\u0001012\u0006\u0010e\u001a\u00020\u001bJ!\u0010\u009e\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u001f0H2\f\u0010\u0092\u0001\u001a\u00030\u0093\u0001\"\u00020\u001bJ\u001b\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u0002010\u001f2\f\u0010\u0092\u0001\u001a\u00030\u0093\u0001\"\u00020\u001bJ\u001b\u0010 \u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u001f0H2\u0006\u0010g\u001a\u00020\u0005J$\u0010¡\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u001f0H2\u0006\u0010g\u001a\u00020\u00052\u0007\u0010¢\u0001\u001a\u00020\u001bJ\u001e\u0010£\u0001\u001a\b\u0012\u0004\u0012\u0002010\u001f2\u0006\u0010g\u001a\u00020\u00052\u0007\u0010¢\u0001\u001a\u00020\u001bJ\u0015\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u0002010\u001f2\u0006\u0010g\u001a\u00020\u0005J\u0017\u0010¥\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001070H2\u0006\u0010\\\u001a\u00020\u001bJ\u0011\u0010¦\u0001\u001a\u0004\u0018\u0001072\u0006\u0010\\\u001a\u00020\u001bJ\u001b\u0010§\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u001f0H2\u0006\u0010e\u001a\u00020\u001bJ\u0015\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u0002070\u001f2\u0006\u0010e\u001a\u00020\u001bJ!\u0010©\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u001f0H2\f\u0010\u0092\u0001\u001a\u00030\u0093\u0001\"\u00020\u001bJ\u001b\u0010ª\u0001\u001a\b\u0012\u0004\u0012\u0002070\u001f2\f\u0010\u0092\u0001\u001a\u00030\u0093\u0001\"\u00020\u001bJ\u0017\u0010«\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0H2\u0006\u0010\\\u001a\u00020\u0005J\u0011\u0010¬\u0001\u001a\u0004\u0018\u00010=2\u0006\u0010\\\u001a\u00020\u0005J\u0017\u0010\u00ad\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0H2\u0006\u0010\\\u001a\u00020\u001bJ\u0011\u0010®\u0001\u001a\u0004\u0018\u00010B2\u0006\u0010\\\u001a\u00020\u001bJ\u001c\u0010¯\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0\u001f0H2\u0007\u0010°\u0001\u001a\u00020\u0005J%\u0010±\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0\u001f0H2\u0007\u0010°\u0001\u001a\u00020\u00052\u0007\u0010²\u0001\u001a\u00020IJ\u001f\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020B0\u001f2\u0007\u0010°\u0001\u001a\u00020\u00052\u0007\u0010²\u0001\u001a\u00020IJ\u0016\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020B0\u001f2\u0007\u0010°\u0001\u001a\u00020\u0005J\u001e\u0010µ\u0001\u001a\u00020\u00052\u0007\u0010¶\u0001\u001a\u00020\u00052\n\b\u0002\u0010·\u0001\u001a\u00030¸\u0001H\u0002JH\u0010¹\u0001\u001a\t\u0012\u0005\u0012\u00030º\u00010\u001f2\u0007\u0010»\u0001\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u001b2\b\b\u0002\u0010v\u001a\u00020I2\u0011\b\u0002\u0010¼\u0001\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001f2\n\b\u0002\u0010½\u0001\u001a\u00030¸\u0001J\u000f\u0010¾\u0001\u001a\u00020F2\u0006\u0010\u001c\u001a\u00020\u001dJ \u0010¿\u0001\u001a\u00020F2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0!\"\u00020\u001d¢\u0006\u0002\u0010YJ\u000f\u0010À\u0001\u001a\u00020F2\u0006\u0010$\u001a\u00020%J \u0010Á\u0001\u001a\u00020F2\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0!\"\u00020%¢\u0006\u0002\u0010_J\u000f\u0010Â\u0001\u001a\u00020F2\u0006\u0010*\u001a\u00020+J \u0010Ã\u0001\u001a\u00020F2\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020+0!\"\u00020+¢\u0006\u0002\u0010bJ\u000f\u0010Ä\u0001\u001a\u00020F2\u0006\u00100\u001a\u000201J \u0010Å\u0001\u001a\u00020F2\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u0002010!\"\u000201¢\u0006\u0002\u0010iJ\u000f\u0010Æ\u0001\u001a\u00020F2\u0006\u00106\u001a\u000207J \u0010Ç\u0001\u001a\u00020F2\u0012\u00109\u001a\n\u0012\u0006\b\u0001\u0012\u0002070!\"\u000207¢\u0006\u0002\u0010lJ\u000f\u0010È\u0001\u001a\u00020F2\u0006\u0010<\u001a\u00020=J \u0010É\u0001\u001a\u00020F2\u0012\u0010?\u001a\n\u0012\u0006\b\u0001\u0012\u00020=0!\"\u00020=¢\u0006\u0002\u0010pJ\u000f\u0010Ê\u0001\u001a\u00020F2\u0006\u00100\u001a\u00020BJ \u0010Ë\u0001\u001a\u00020F2\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u00020B0!\"\u00020B¢\u0006\u0002\u0010sR\u000e\u0010\u0002\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Í\u0001"}, d2 = {"Lcom/magneticchen/daijishou/data/db/repositories/RetroAchievementsRepository;", "", "application", "Landroid/app/Application;", "databaseName", "", "(Landroid/app/Application;Ljava/lang/String;)V", "Lcom/magneticchen/daijishou/DaijishouApplication;", "database", "Lcom/magneticchen/daijishou/data/db/RetroAchievementsDatabase;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "retroAchievementsAchievementRecordDAO", "Lcom/magneticchen/daijishou/data/db/dao/RetroAchievementsAchievementRecordDAO;", "retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO", "Lcom/magneticchen/daijishou/data/db/dao/RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO;", "retroAchievementsGameRecordDAO", "Lcom/magneticchen/daijishou/data/db/dao/RetroAchievementsGameRecordDAO;", "retroAchievementsUserAwardDAO", "Lcom/magneticchen/daijishou/data/db/dao/RetroAchievementsUserAwardDAO;", "retroAchievementsUserIndependentGameRecordDAO", "Lcom/magneticchen/daijishou/data/db/dao/RetroAchievementsUserIndependentGameRecordDAO;", "retroAchievementsUserProfileDAO", "Lcom/magneticchen/daijishou/data/db/dao/RetroAchievementsUserProfileDAO;", "retroAchievementsUserRankingDAO", "Lcom/magneticchen/daijishou/data/db/dao/RetroAchievementsUserRankingDAO;", "addRetroAchievementsAchievementRecord", "", "retroAchievementsAchievementRecordEntity", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsAchievementRecordEntity;", "addRetroAchievementsAchievementRecords", "", "retroAchievementsAchievementRecordEntities", "", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsAchievementRecordEntity;)Ljava/util/List;", "addRetroAchievementsCachedPlayableItemIdToGameIdSurjection", "retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;", "addRetroAchievementsCachedPlayableItemIdToGameIdSurjections", "retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;)Ljava/util/List;", "addRetroAchievementsGameRecord", "retroAchievementsGameRecordEntity", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;", "addRetroAchievementsGameRecords", "retroAchievementsGameRecordEntities", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;)Ljava/util/List;", "addRetroAchievementsUserAward", "retroAchievementsUserRankingEntity", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserAwardEntity;", "addRetroAchievementsUserAwards", "retroAchievementsUserRankingEntities", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserAwardEntity;)Ljava/util/List;", "addRetroAchievementsUserIndependentGameRecord", "retroAchievementsUserIndependentGameRecordEntity", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserIndependentGameRecordEntity;", "addRetroAchievementsUserIndependentGameRecords", "retroAchievementsUserIndependentGameRecordEntities", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserIndependentGameRecordEntity;)Ljava/util/List;", "addRetroAchievementsUserProfile", "retroAchievementsUserProfileEntity", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserProfileEntity;", "addRetroAchievementsUserProfiles", "retroAchievementsUserProfileEntities", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserProfileEntity;)Ljava/util/List;", "addRetroAchievementsUserRanking", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserRankingEntity;", "addRetroAchievementsUserRankings", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserRankingEntity;)Ljava/util/List;", "clearAll", "", "countAllRetroAchievementsAchievementRecord", "Landroidx/lifecycle/LiveData;", "", "countAllRetroAchievementsAchievementRecordStatically", "countAllRetroAchievementsCachedPlayableItemIdToGameIdSurjection", "countAllRetroAchievementsCachedPlayableItemIdToGameIdSurjectionStatically", "countAllRetroAchievementsGameRecord", "countAllRetroAchievementsGameRecordStatically", "countAllRetroAchievementsUserAwards", "countAllRetroAchievementsUserAwardsStatically", "countAllRetroAchievementsUserIndependentGameRecord", "countAllRetroAchievementsUserIndependentGameRecordStatically", "countAllRetroAchievementsUserProfile", "countAllRetroAchievementsUserProfileStatically", "countAllRetroAchievementsUserRankings", "countAllRetroAchievementsUserRankingsStatically", "deleteRetroAchievementsAchievementRecord", "deleteRetroAchievementsAchievementRecords", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsAchievementRecordEntity;)V", "deleteRetroAchievementsCachedPlayableItemIdToGameIdSurjection", "deleteRetroAchievementsCachedPlayableItemIdToGameIdSurjectionById", "id", "deleteRetroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemId", "deleteRetroAchievementsCachedPlayableItemIdToGameIdSurjections", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;)V", "deleteRetroAchievementsGameRecord", "deleteRetroAchievementsGameRecords", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsGameRecordEntity;)V", "deleteRetroAchievementsUserAward", "deleteRetroAchievementsUserAwardByConsoleId", "consoleId", "deleteRetroAchievementsUserAwardByUserId", "userId", "deleteRetroAchievementsUserAwards", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserAwardEntity;)V", "deleteRetroAchievementsUserIndependentGameRecord", "deleteRetroAchievementsUserIndependentGameRecords", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserIndependentGameRecordEntity;)V", "deleteRetroAchievementsUserIndependentGameRecordsByConsoleId", "deleteRetroAchievementsUserProfile", "deleteRetroAchievementsUserProfiles", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserProfileEntity;)V", "deleteRetroAchievementsUserRanking", "deleteRetroAchievementsUserRankings", "([Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserRankingEntity;)V", "findRetroAchievementsUserIndependentGameRecordEntityWithName", "search", "limit", "findRetroAchievementsUserIndependentGameRecordEntityWithNameAndConsoleId", "findRetroAchievementsUserIndependentGameRecordEntityWithNameAndConsoleIdStatically", "findRetroAchievementsUserIndependentGameRecordEntityWithNameStatically", "getAllRetroAchievementsUserAwards", "getAllRetroAchievementsUserAwardsStatically", "getFirstRetroAchievementsUserIndependentGameRecordByConsoleId", "getFirstRetroAchievementsUserIndependentGameRecordByConsoleIdStatically", "getRetroAchievementsAchievementRecordById", "getRetroAchievementsAchievementRecordByIdStatically", "getRetroAchievementsAchievementRecordsByGameRecordId", "getRetroAchievementsAchievementRecordsByGameRecordIdStatically", "getRetroAchievementsAchievementRecordsByUserId", "getRetroAchievementsAchievementRecordsByUserIdStatically", "getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionById", "getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionByIdStatically", "getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemId", "getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemIdStatically", "getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionsByGameId", "getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionsByGameIdStatically", "getRetroAchievementsGameRecordById", "getRetroAchievementsGameRecordByIdStatically", "getRetroAchievementsGameRecordByUserIdAndGameId", "gameId", "getRetroAchievementsGameRecordByUserIdAndGameIdStatically", "getRetroAchievementsGameRecordsByGameId", "getRetroAchievementsGameRecordsByGameIdStatically", "getRetroAchievementsGameRecordsByIds", "ids", "", "getRetroAchievementsGameRecordsByIdsStatically", "getRetroAchievementsGameRecordsByUserId", "getRetroAchievementsGameRecordsByUserIdAndGameIds", "gameIds", "getRetroAchievementsGameRecordsByUserIdAndGameIdsStatically", "getRetroAchievementsGameRecordsByUserIdStatically", "getRetroAchievementsUserAwardById", "getRetroAchievementsUserAwardByIdStatically", "getRetroAchievementsUserAwardsByConsoleId", "getRetroAchievementsUserAwardsByConsoleIdStatically", "getRetroAchievementsUserAwardsByIds", "getRetroAchievementsUserAwardsByIdsStatically", "getRetroAchievementsUserAwardsByUserId", "getRetroAchievementsUserAwardsByUserIdAndAwardData", "awardData", "getRetroAchievementsUserAwardsByUserIdAndAwardDataStatically", "getRetroAchievementsUserAwardsByUserIdStatically", "getRetroAchievementsUserIndependentGameRecordById", "getRetroAchievementsUserIndependentGameRecordByIdStatically", "getRetroAchievementsUserIndependentGameRecordsByConsoleId", "getRetroAchievementsUserIndependentGameRecordsByConsoleIdStatically", "getRetroAchievementsUserIndependentGameRecordsByIds", "getRetroAchievementsUserIndependentGameRecordsByIdsStatically", "getRetroAchievementsUserProfileById", "getRetroAchievementsUserProfileByIdStatically", "getRetroAchievementsUserRankingById", "getRetroAchievementsUserRankingByIdStatically", "getRetroAchievementsUserRankingsByPerspective", "whosePerspective", "getRetroAchievementsUserRankingsByPerspectiveAndGranularity", "granularity", "getRetroAchievementsUserRankingsByPerspectiveAndGranularityStatically", "getRetroAchievementsUserRankingsByPerspectiveStatically", "prettifyTitle", "title", "showDiscIndex", "", "searchRetroAchievementsUserIndependentGameRecordByKeywordAndConsoleId", "Lcom/magneticchen/daijishou/data/db/repositories/RetroAchievementsRepository$RetroAchievementsUserIndependentGameRecordSearchItem;", "keyword", "excludedIdList", "ignoreTrivial", "updateRetroAchievementsAchievementRecord", "updateRetroAchievementsAchievementRecords", "updateRetroAchievementsCachedPlayableItemIdToGameIdSurjection", "updateRetroAchievementsCachedPlayableItemIdToGameIdSurjections", "updateRetroAchievementsGameRecord", "updateRetroAchievementsGameRecords", "updateRetroAchievementsUserAward", "updateRetroAchievementsUserAwards", "updateRetroAchievementsUserIndependentGameRecord", "updateRetroAchievementsUserIndependentGameRecords", "updateRetroAchievementsUserProfile", "updateRetroAchievementsUserProfiles", "updateRetroAchievementsUserRanking", "updateRetroAchievementsUserRankings", "RetroAchievementsUserIndependentGameRecordSearchItem", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsRepository {
    private final DaijishouApplication application;
    private final RetroAchievementsDatabase database;
    private final String databaseName;
    private final DaijishouApplication.WrappedLogger logger;
    private final RetroAchievementsAchievementRecordDAO retroAchievementsAchievementRecordDAO;
    private final RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO;
    private final RetroAchievementsGameRecordDAO retroAchievementsGameRecordDAO;
    private final RetroAchievementsUserAwardDAO retroAchievementsUserAwardDAO;
    private final RetroAchievementsUserIndependentGameRecordDAO retroAchievementsUserIndependentGameRecordDAO;
    private final RetroAchievementsUserProfileDAO retroAchievementsUserProfileDAO;
    private final RetroAchievementsUserRankingDAO retroAchievementsUserRankingDAO;

    public RetroAchievementsRepository(Application application, String databaseName) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(databaseName, "databaseName");
        this.databaseName = databaseName;
        DaijishouApplication daijishouApplication = (DaijishouApplication) application;
        this.application = daijishouApplication;
        this.logger = daijishouApplication.getLogger();
        RetroAchievementsDatabase companion = RetroAchievementsDatabase.Companion.getInstance(daijishouApplication, databaseName);
        this.database = companion;
        this.retroAchievementsAchievementRecordDAO = companion.retroAchievementsAchievementRecordDAO();
        this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO = companion.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO();
        this.retroAchievementsGameRecordDAO = companion.retroAchievementsGameRecordDAO();
        this.retroAchievementsUserIndependentGameRecordDAO = companion.retroAchievementsUserIndependentGameRecordDAO();
        this.retroAchievementsUserProfileDAO = companion.retroAchievementsUserProfileDAO();
        this.retroAchievementsUserRankingDAO = companion.retroAchievementsUserRankingDAO();
        this.retroAchievementsUserAwardDAO = companion.retroAchievementsUserAwardDAO();
    }

    public /* synthetic */ RetroAchievementsRepository(Application application, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, (i & 2) != 0 ? RetroAchievementsDatabase.DB_NAME : str);
    }

    private final String prettifyTitle(String str, boolean z) {
        return this.application.prettifyTitle(str, z);
    }

    static /* synthetic */ String prettifyTitle$default(RetroAchievementsRepository retroAchievementsRepository, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return retroAchievementsRepository.prettifyTitle(str, z);
    }

    public final void clearAll() {
        this.database.clearAllTables();
    }

    public final LiveData<Integer> countAllRetroAchievementsAchievementRecord() {
        return this.retroAchievementsAchievementRecordDAO.countAll();
    }

    public final int countAllRetroAchievementsAchievementRecordStatically() {
        return this.retroAchievementsAchievementRecordDAO.countAllStatically();
    }

    public final LiveData<RetroAchievementsAchievementRecordEntity> getRetroAchievementsAchievementRecordById(long j) {
        return this.retroAchievementsAchievementRecordDAO.selectById(j);
    }

    public final RetroAchievementsAchievementRecordEntity getRetroAchievementsAchievementRecordByIdStatically(long j) {
        return this.retroAchievementsAchievementRecordDAO.selectByIdStatically(j);
    }

    public final LiveData<List<RetroAchievementsAchievementRecordEntity>> getRetroAchievementsAchievementRecordsByGameRecordId(long j) {
        return this.retroAchievementsAchievementRecordDAO.selectByGameRecordId(j);
    }

    public final List<RetroAchievementsAchievementRecordEntity> getRetroAchievementsAchievementRecordsByGameRecordIdStatically(long j) {
        return this.retroAchievementsAchievementRecordDAO.selectByGameRecordIdStatically(j);
    }

    public final LiveData<List<RetroAchievementsAchievementRecordEntity>> getRetroAchievementsAchievementRecordsByUserId(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.retroAchievementsAchievementRecordDAO.selectByUserId(id2);
    }

    public final List<RetroAchievementsAchievementRecordEntity> getRetroAchievementsAchievementRecordsByUserIdStatically(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.retroAchievementsAchievementRecordDAO.selectByUserIdStatically(id2);
    }

    public final long addRetroAchievementsAchievementRecord(RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsAchievementRecordEntity, "retroAchievementsAchievementRecordEntity");
        return this.retroAchievementsAchievementRecordDAO.insert(retroAchievementsAchievementRecordEntity);
    }

    public final List<Long> addRetroAchievementsAchievementRecords(RetroAchievementsAchievementRecordEntity... retroAchievementsAchievementRecordEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsAchievementRecordEntities, "retroAchievementsAchievementRecordEntities");
        return this.retroAchievementsAchievementRecordDAO.insertAll((RetroAchievementsAchievementRecordEntity[]) Arrays.copyOf(retroAchievementsAchievementRecordEntities, retroAchievementsAchievementRecordEntities.length));
    }

    public final void updateRetroAchievementsAchievementRecord(RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsAchievementRecordEntity, "retroAchievementsAchievementRecordEntity");
        this.retroAchievementsAchievementRecordDAO.update(retroAchievementsAchievementRecordEntity);
    }

    public final void updateRetroAchievementsAchievementRecords(RetroAchievementsAchievementRecordEntity... retroAchievementsAchievementRecordEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsAchievementRecordEntities, "retroAchievementsAchievementRecordEntities");
        this.retroAchievementsAchievementRecordDAO.updateAll((RetroAchievementsAchievementRecordEntity[]) Arrays.copyOf(retroAchievementsAchievementRecordEntities, retroAchievementsAchievementRecordEntities.length));
    }

    public final void deleteRetroAchievementsAchievementRecord(RetroAchievementsAchievementRecordEntity retroAchievementsAchievementRecordEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsAchievementRecordEntity, "retroAchievementsAchievementRecordEntity");
        this.retroAchievementsAchievementRecordDAO.delete(retroAchievementsAchievementRecordEntity);
    }

    public final void deleteRetroAchievementsAchievementRecords(RetroAchievementsAchievementRecordEntity... retroAchievementsAchievementRecordEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsAchievementRecordEntities, "retroAchievementsAchievementRecordEntities");
        this.retroAchievementsAchievementRecordDAO.deleteAll((RetroAchievementsAchievementRecordEntity[]) Arrays.copyOf(retroAchievementsAchievementRecordEntities, retroAchievementsAchievementRecordEntities.length));
    }

    public final LiveData<Integer> countAllRetroAchievementsCachedPlayableItemIdToGameIdSurjection() {
        return this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.countAll();
    }

    public final int countAllRetroAchievementsCachedPlayableItemIdToGameIdSurjectionStatically() {
        return this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.countAllStatically();
    }

    public final LiveData<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionById(long j) {
        return this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.selectById(j);
    }

    public final RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionByIdStatically(long j) {
        return this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.selectByIdStatically(j);
    }

    public final LiveData<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemId(long j) {
        return this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.selectByPlayableItemId(j);
    }

    public final RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemIdStatically(long j) {
        return this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.selectByPlayableItemIdStatically(j);
    }

    public final LiveData<List<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity>> getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionsByGameId(long j) {
        return this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.selectByGameId(j);
    }

    public final List<RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity> getRetroAchievementsCachedPlayableItemIdToGameIdSurjectionsByGameIdStatically(long j) {
        return this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.selectByGameIdStatically(j);
    }

    public final long addRetroAchievementsCachedPlayableItemIdToGameIdSurjection(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity, "retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity");
        return this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.insert(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity);
    }

    public final List<Long> addRetroAchievementsCachedPlayableItemIdToGameIdSurjections(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity... retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities, "retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities");
        return this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.insertAll((RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity[]) Arrays.copyOf(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities, retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities.length));
    }

    public final void updateRetroAchievementsCachedPlayableItemIdToGameIdSurjection(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity, "retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity");
        this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.update(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity);
    }

    public final void updateRetroAchievementsCachedPlayableItemIdToGameIdSurjections(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity... retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities, "retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities");
        this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.updateAll((RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity[]) Arrays.copyOf(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities, retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities.length));
    }

    public final void deleteRetroAchievementsCachedPlayableItemIdToGameIdSurjection(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity, "retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity");
        this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.delete(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity);
    }

    public final void deleteRetroAchievementsCachedPlayableItemIdToGameIdSurjections(RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity... retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities, "retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities");
        this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.deleteAll((RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity[]) Arrays.copyOf(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities, retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntities.length));
    }

    public final void deleteRetroAchievementsCachedPlayableItemIdToGameIdSurjectionById(long j) {
        this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.deleteById(j);
    }

    public final void deleteRetroAchievementsCachedPlayableItemIdToGameIdSurjectionByPlayableItemId(long j) {
        this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.deleteByPlayableItemId(j);
    }

    public final LiveData<Integer> countAllRetroAchievementsGameRecord() {
        return this.retroAchievementsGameRecordDAO.countAll();
    }

    public final int countAllRetroAchievementsGameRecordStatically() {
        return this.retroAchievementsGameRecordDAO.countAllStatically();
    }

    public final LiveData<RetroAchievementsGameRecordEntity> getRetroAchievementsGameRecordById(long j) {
        return this.retroAchievementsGameRecordDAO.selectById(j);
    }

    public final RetroAchievementsGameRecordEntity getRetroAchievementsGameRecordByIdStatically(long j) {
        return this.retroAchievementsGameRecordDAO.selectByIdStatically(j);
    }

    public final LiveData<List<RetroAchievementsGameRecordEntity>> getRetroAchievementsGameRecordsByIds(long... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.retroAchievementsGameRecordDAO.selectByIds(Arrays.copyOf(ids, ids.length));
    }

    public final List<RetroAchievementsGameRecordEntity> getRetroAchievementsGameRecordsByIdsStatically(long... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.retroAchievementsGameRecordDAO.selectByIdsStatically(Arrays.copyOf(ids, ids.length));
    }

    public final LiveData<RetroAchievementsGameRecordEntity> getRetroAchievementsGameRecordByUserIdAndGameId(String userId, long j) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return this.retroAchievementsGameRecordDAO.selectByUserIdAndGameId(userId, j);
    }

    public final RetroAchievementsGameRecordEntity getRetroAchievementsGameRecordByUserIdAndGameIdStatically(String userId, long j) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return this.retroAchievementsGameRecordDAO.selectByUserIdAndGameIdStatically(userId, j);
    }

    public final LiveData<List<RetroAchievementsGameRecordEntity>> getRetroAchievementsGameRecordsByUserId(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.retroAchievementsGameRecordDAO.selectByUserId(id2);
    }

    public final List<RetroAchievementsGameRecordEntity> getRetroAchievementsGameRecordsByUserIdStatically(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.retroAchievementsGameRecordDAO.selectByUserIdStatically(id2);
    }

    public final LiveData<List<RetroAchievementsGameRecordEntity>> getRetroAchievementsGameRecordsByUserIdAndGameIds(String userId, long... gameIds) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(gameIds, "gameIds");
        return this.retroAchievementsGameRecordDAO.selectByUserIdAndGameIds(userId, Arrays.copyOf(gameIds, gameIds.length));
    }

    public final List<RetroAchievementsGameRecordEntity> getRetroAchievementsGameRecordsByUserIdAndGameIdsStatically(String userId, long... gameIds) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(gameIds, "gameIds");
        return this.retroAchievementsGameRecordDAO.selectByUserIdAndGameIdsStatically(userId, Arrays.copyOf(gameIds, gameIds.length));
    }

    public final LiveData<List<RetroAchievementsGameRecordEntity>> getRetroAchievementsGameRecordsByGameId(long j) {
        return this.retroAchievementsGameRecordDAO.selectByGameId(j);
    }

    public final List<RetroAchievementsGameRecordEntity> getRetroAchievementsGameRecordsByGameIdStatically(long j) {
        return this.retroAchievementsGameRecordDAO.selectByGameIdStatically(j);
    }

    public final long addRetroAchievementsGameRecord(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecordEntity, "retroAchievementsGameRecordEntity");
        return this.retroAchievementsGameRecordDAO.insert(retroAchievementsGameRecordEntity);
    }

    public final List<Long> addRetroAchievementsGameRecords(RetroAchievementsGameRecordEntity... retroAchievementsGameRecordEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecordEntities, "retroAchievementsGameRecordEntities");
        return this.retroAchievementsGameRecordDAO.insertAll((RetroAchievementsGameRecordEntity[]) Arrays.copyOf(retroAchievementsGameRecordEntities, retroAchievementsGameRecordEntities.length));
    }

    public final void updateRetroAchievementsGameRecord(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecordEntity, "retroAchievementsGameRecordEntity");
        this.retroAchievementsGameRecordDAO.update(retroAchievementsGameRecordEntity);
    }

    public final void updateRetroAchievementsGameRecords(RetroAchievementsGameRecordEntity... retroAchievementsGameRecordEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecordEntities, "retroAchievementsGameRecordEntities");
        this.retroAchievementsGameRecordDAO.updateAll((RetroAchievementsGameRecordEntity[]) Arrays.copyOf(retroAchievementsGameRecordEntities, retroAchievementsGameRecordEntities.length));
    }

    public final void deleteRetroAchievementsGameRecord(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecordEntity, "retroAchievementsGameRecordEntity");
        this.retroAchievementsGameRecordDAO.delete(retroAchievementsGameRecordEntity);
    }

    public final void deleteRetroAchievementsGameRecords(RetroAchievementsGameRecordEntity... retroAchievementsGameRecordEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsGameRecordEntities, "retroAchievementsGameRecordEntities");
        this.retroAchievementsGameRecordDAO.deleteAll((RetroAchievementsGameRecordEntity[]) Arrays.copyOf(retroAchievementsGameRecordEntities, retroAchievementsGameRecordEntities.length));
    }

    public final LiveData<Integer> countAllRetroAchievementsUserIndependentGameRecord() {
        return this.retroAchievementsUserIndependentGameRecordDAO.countAll();
    }

    public final int countAllRetroAchievementsUserIndependentGameRecordStatically() {
        return this.retroAchievementsUserIndependentGameRecordDAO.countAllStatically();
    }

    public final LiveData<RetroAchievementsUserIndependentGameRecordEntity> getRetroAchievementsUserIndependentGameRecordById(long j) {
        return this.retroAchievementsUserIndependentGameRecordDAO.selectById(j);
    }

    public final RetroAchievementsUserIndependentGameRecordEntity getRetroAchievementsUserIndependentGameRecordByIdStatically(long j) {
        return this.retroAchievementsUserIndependentGameRecordDAO.selectByIdStatically(j);
    }

    public final LiveData<List<RetroAchievementsUserIndependentGameRecordEntity>> getRetroAchievementsUserIndependentGameRecordsByIds(long... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.retroAchievementsUserIndependentGameRecordDAO.selectByIds(Arrays.copyOf(ids, ids.length));
    }

    public final List<RetroAchievementsUserIndependentGameRecordEntity> getRetroAchievementsUserIndependentGameRecordsByIdsStatically(long... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.retroAchievementsUserIndependentGameRecordDAO.selectByIdsStatically(Arrays.copyOf(ids, ids.length));
    }

    public final LiveData<List<RetroAchievementsUserIndependentGameRecordEntity>> getRetroAchievementsUserIndependentGameRecordsByConsoleId(long j) {
        return this.retroAchievementsUserIndependentGameRecordDAO.selectByConsoleId(j);
    }

    public final List<RetroAchievementsUserIndependentGameRecordEntity> getRetroAchievementsUserIndependentGameRecordsByConsoleIdStatically(long j) {
        return this.retroAchievementsUserIndependentGameRecordDAO.selectByConsoleIdStatically(j);
    }

    public final LiveData<RetroAchievementsUserIndependentGameRecordEntity> getFirstRetroAchievementsUserIndependentGameRecordByConsoleId(long j) {
        return this.retroAchievementsUserIndependentGameRecordDAO.selectFirstByConsoleId(j);
    }

    public final RetroAchievementsUserIndependentGameRecordEntity getFirstRetroAchievementsUserIndependentGameRecordByConsoleIdStatically(long j) {
        return this.retroAchievementsUserIndependentGameRecordDAO.selectFirstByConsoleIdStatically(j);
    }

    /* JADX INFO: compiled from: RetroAchievementsRepository.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/magneticchen/daijishou/data/db/repositories/RetroAchievementsRepository$RetroAchievementsUserIndependentGameRecordSearchItem;", "", "retroAchievementsUserIndependentGameRecordEntity", "Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserIndependentGameRecordEntity;", "matchCount", "", "maxMatchCount", "ranking", "", "maxRanking", "(Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserIndependentGameRecordEntity;IIFF)V", "getMatchCount", "()I", "setMatchCount", "(I)V", "getMaxMatchCount", "setMaxMatchCount", "getMaxRanking", "()F", "setMaxRanking", "(F)V", "getRanking", "setRanking", "getRetroAchievementsUserIndependentGameRecordEntity", "()Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserIndependentGameRecordEntity;", "setRetroAchievementsUserIndependentGameRecordEntity", "(Lcom/magneticchen/daijishou/data/db/entity/RetroAchievementsUserIndependentGameRecordEntity;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RetroAchievementsUserIndependentGameRecordSearchItem {
        private int matchCount;
        private int maxMatchCount;
        private float maxRanking;
        private float ranking;
        private RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity;

        public static /* synthetic */ RetroAchievementsUserIndependentGameRecordSearchItem copy$default(RetroAchievementsUserIndependentGameRecordSearchItem retroAchievementsUserIndependentGameRecordSearchItem, RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity, int i, int i2, float f, float f2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                retroAchievementsUserIndependentGameRecordEntity = retroAchievementsUserIndependentGameRecordSearchItem.retroAchievementsUserIndependentGameRecordEntity;
            }
            if ((i3 & 2) != 0) {
                i = retroAchievementsUserIndependentGameRecordSearchItem.matchCount;
            }
            if ((i3 & 4) != 0) {
                i2 = retroAchievementsUserIndependentGameRecordSearchItem.maxMatchCount;
            }
            if ((i3 & 8) != 0) {
                f = retroAchievementsUserIndependentGameRecordSearchItem.ranking;
            }
            if ((i3 & 16) != 0) {
                f2 = retroAchievementsUserIndependentGameRecordSearchItem.maxRanking;
            }
            float f3 = f2;
            int i4 = i2;
            return retroAchievementsUserIndependentGameRecordSearchItem.copy(retroAchievementsUserIndependentGameRecordEntity, i, i4, f, f3);
        }

        public final RetroAchievementsUserIndependentGameRecordEntity component1() {
            return this.retroAchievementsUserIndependentGameRecordEntity;
        }

        public final int component2() {
            return this.matchCount;
        }

        public final int component3() {
            return this.maxMatchCount;
        }

        public final float component4() {
            return this.ranking;
        }

        public final float component5() {
            return this.maxRanking;
        }

        public final RetroAchievementsUserIndependentGameRecordSearchItem copy(RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity, int i, int i2, float f, float f2) {
            Intrinsics.checkNotNullParameter(retroAchievementsUserIndependentGameRecordEntity, "retroAchievementsUserIndependentGameRecordEntity");
            return new RetroAchievementsUserIndependentGameRecordSearchItem(retroAchievementsUserIndependentGameRecordEntity, i, i2, f, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RetroAchievementsUserIndependentGameRecordSearchItem)) {
                return false;
            }
            RetroAchievementsUserIndependentGameRecordSearchItem retroAchievementsUserIndependentGameRecordSearchItem = (RetroAchievementsUserIndependentGameRecordSearchItem) obj;
            return Intrinsics.areEqual(this.retroAchievementsUserIndependentGameRecordEntity, retroAchievementsUserIndependentGameRecordSearchItem.retroAchievementsUserIndependentGameRecordEntity) && this.matchCount == retroAchievementsUserIndependentGameRecordSearchItem.matchCount && this.maxMatchCount == retroAchievementsUserIndependentGameRecordSearchItem.maxMatchCount && Float.compare(this.ranking, retroAchievementsUserIndependentGameRecordSearchItem.ranking) == 0 && Float.compare(this.maxRanking, retroAchievementsUserIndependentGameRecordSearchItem.maxRanking) == 0;
        }

        public int hashCode() {
            return (((((((this.retroAchievementsUserIndependentGameRecordEntity.hashCode() * 31) + Integer.hashCode(this.matchCount)) * 31) + Integer.hashCode(this.maxMatchCount)) * 31) + Float.hashCode(this.ranking)) * 31) + Float.hashCode(this.maxRanking);
        }

        public String toString() {
            return "RetroAchievementsUserIndependentGameRecordSearchItem(retroAchievementsUserIndependentGameRecordEntity=" + this.retroAchievementsUserIndependentGameRecordEntity + ", matchCount=" + this.matchCount + ", maxMatchCount=" + this.maxMatchCount + ", ranking=" + this.ranking + ", maxRanking=" + this.maxRanking + ")";
        }

        public RetroAchievementsUserIndependentGameRecordSearchItem(RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity, int i, int i2, float f, float f2) {
            Intrinsics.checkNotNullParameter(retroAchievementsUserIndependentGameRecordEntity, "retroAchievementsUserIndependentGameRecordEntity");
            this.retroAchievementsUserIndependentGameRecordEntity = retroAchievementsUserIndependentGameRecordEntity;
            this.matchCount = i;
            this.maxMatchCount = i2;
            this.ranking = f;
            this.maxRanking = f2;
        }

        public /* synthetic */ RetroAchievementsUserIndependentGameRecordSearchItem(RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity, int i, int i2, float f, float f2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(retroAchievementsUserIndependentGameRecordEntity, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? 0.0f : f, (i3 & 16) != 0 ? 0.0f : f2);
        }

        public final RetroAchievementsUserIndependentGameRecordEntity getRetroAchievementsUserIndependentGameRecordEntity() {
            return this.retroAchievementsUserIndependentGameRecordEntity;
        }

        public final void setRetroAchievementsUserIndependentGameRecordEntity(RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity) {
            Intrinsics.checkNotNullParameter(retroAchievementsUserIndependentGameRecordEntity, "<set-?>");
            this.retroAchievementsUserIndependentGameRecordEntity = retroAchievementsUserIndependentGameRecordEntity;
        }

        public final int getMatchCount() {
            return this.matchCount;
        }

        public final void setMatchCount(int i) {
            this.matchCount = i;
        }

        public final int getMaxMatchCount() {
            return this.maxMatchCount;
        }

        public final void setMaxMatchCount(int i) {
            this.maxMatchCount = i;
        }

        public final float getRanking() {
            return this.ranking;
        }

        public final void setRanking(float f) {
            this.ranking = f;
        }

        public final float getMaxRanking() {
            return this.maxRanking;
        }

        public final void setMaxRanking(float f) {
            this.maxRanking = f;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List searchRetroAchievementsUserIndependentGameRecordByKeywordAndConsoleId$default(RetroAchievementsRepository retroAchievementsRepository, String str, long j, int i, List list, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 8;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            list = null;
        }
        List list2 = list;
        if ((i2 & 16) != 0) {
            z = false;
        }
        return retroAchievementsRepository.searchRetroAchievementsUserIndependentGameRecordByKeywordAndConsoleId(str, j, i3, list2, z);
    }

    public final List<RetroAchievementsUserIndependentGameRecordSearchItem> searchRetroAchievementsUserIndependentGameRecordByKeywordAndConsoleId(String keyword, long j, int i, List<Long> list, boolean z) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        HashMap map = new HashMap();
        List<String> listSplit = new Regex("\\s-\\s|[\\s|.]+").split(prettifyTitle$default(this, keyword, false, 2, null), 0);
        float f = DefinitionKt.NO_Float_VALUE;
        for (String str : listSplit) {
            if (!z) {
                List<String> trivialWords = Constants.INSTANCE.getTrivialWords();
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String lowerCase = str.toLowerCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (!trivialWords.contains(lowerCase)) {
                    Regex trivialRegex = Constants.INSTANCE.getTrivialRegex();
                    Locale ROOT2 = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
                    String lowerCase2 = str.toLowerCase(ROOT2);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (trivialRegex.matches(lowerCase2)) {
                    }
                }
            }
            List<RetroAchievementsUserIndependentGameRecordEntity> listFindWithNameAndConsoleIdStatically = this.retroAchievementsUserIndependentGameRecordDAO.findWithNameAndConsoleIdStatically(str, j, i);
            float size = 1.0f / listFindWithNameAndConsoleIdStatically.size();
            f += size;
            for (RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity : listFindWithNameAndConsoleIdStatically) {
                if (list == null || list.indexOf(Long.valueOf(retroAchievementsUserIndependentGameRecordEntity.getId())) < 0) {
                    RetroAchievementsUserIndependentGameRecordSearchItem retroAchievementsUserIndependentGameRecordSearchItem = (RetroAchievementsUserIndependentGameRecordSearchItem) map.get(Long.valueOf(retroAchievementsUserIndependentGameRecordEntity.getId()));
                    if (retroAchievementsUserIndependentGameRecordSearchItem != null) {
                        retroAchievementsUserIndependentGameRecordSearchItem.setMatchCount(retroAchievementsUserIndependentGameRecordSearchItem.getMatchCount() + 1);
                        retroAchievementsUserIndependentGameRecordSearchItem.setRanking(retroAchievementsUserIndependentGameRecordSearchItem.getRanking() + size);
                    } else {
                        map.put(Long.valueOf(retroAchievementsUserIndependentGameRecordEntity.getId()), new RetroAchievementsUserIndependentGameRecordSearchItem(retroAchievementsUserIndependentGameRecordEntity, 1, listSplit.size(), size, DefinitionKt.NO_Float_VALUE, 16, null));
                    }
                }
            }
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            ((RetroAchievementsUserIndependentGameRecordSearchItem) ((Map.Entry) it.next()).getValue()).setMaxRanking(f);
        }
        Collection collectionValues = map.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        List listSortedWith = CollectionsKt.sortedWith(CollectionsKt.sortedWith(CollectionsKt.sortedWith(collectionValues, new Comparator() { // from class: com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository$searchRetroAchievementsUserIndependentGameRecordByKeywordAndConsoleId$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(Object t, Object t2) {
                String name = ((RetroAchievementsRepository.RetroAchievementsUserIndependentGameRecordSearchItem) t).getRetroAchievementsUserIndependentGameRecordEntity().getName();
                Integer numValueOf = name != null ? Integer.valueOf(name.length()) : null;
                String name2 = ((RetroAchievementsRepository.RetroAchievementsUserIndependentGameRecordSearchItem) t2).getRetroAchievementsUserIndependentGameRecordEntity().getName();
                return ComparisonsKt.compareValues(numValueOf, name2 != null ? Integer.valueOf(name2.length()) : null);
            }
        }), new Comparator() { // from class: com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository$searchRetroAchievementsUserIndependentGameRecordByKeywordAndConsoleId$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(Object t, Object t2) {
                return ComparisonsKt.compareValues(Float.valueOf(((RetroAchievementsRepository.RetroAchievementsUserIndependentGameRecordSearchItem) t2).getRanking()), Float.valueOf(((RetroAchievementsRepository.RetroAchievementsUserIndependentGameRecordSearchItem) t).getRanking()));
            }
        }), new Comparator() { // from class: com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository$searchRetroAchievementsUserIndependentGameRecordByKeywordAndConsoleId$$inlined$sortedByDescending$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(Object t, Object t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((RetroAchievementsRepository.RetroAchievementsUserIndependentGameRecordSearchItem) t2).getMatchCount()), Integer.valueOf(((RetroAchievementsRepository.RetroAchievementsUserIndependentGameRecordSearchItem) t).getMatchCount()));
            }
        });
        return listSortedWith.subList(0, Math.min(listSortedWith.size(), i));
    }

    public static /* synthetic */ LiveData findRetroAchievementsUserIndependentGameRecordEntityWithName$default(RetroAchievementsRepository retroAchievementsRepository, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        return retroAchievementsRepository.findRetroAchievementsUserIndependentGameRecordEntityWithName(str, i);
    }

    public final LiveData<List<RetroAchievementsUserIndependentGameRecordEntity>> findRetroAchievementsUserIndependentGameRecordEntityWithName(String search, int i) {
        Intrinsics.checkNotNullParameter(search, "search");
        return this.retroAchievementsUserIndependentGameRecordDAO.findWithName(search, i);
    }

    public static /* synthetic */ List findRetroAchievementsUserIndependentGameRecordEntityWithNameStatically$default(RetroAchievementsRepository retroAchievementsRepository, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        return retroAchievementsRepository.findRetroAchievementsUserIndependentGameRecordEntityWithNameStatically(str, i);
    }

    public final List<RetroAchievementsUserIndependentGameRecordEntity> findRetroAchievementsUserIndependentGameRecordEntityWithNameStatically(String search, int i) {
        Intrinsics.checkNotNullParameter(search, "search");
        return this.retroAchievementsUserIndependentGameRecordDAO.findWithNameStatically(search, i);
    }

    public static /* synthetic */ LiveData findRetroAchievementsUserIndependentGameRecordEntityWithNameAndConsoleId$default(RetroAchievementsRepository retroAchievementsRepository, String str, long j, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        return retroAchievementsRepository.findRetroAchievementsUserIndependentGameRecordEntityWithNameAndConsoleId(str, j, i);
    }

    public final LiveData<List<RetroAchievementsUserIndependentGameRecordEntity>> findRetroAchievementsUserIndependentGameRecordEntityWithNameAndConsoleId(String search, long j, int i) {
        Intrinsics.checkNotNullParameter(search, "search");
        return this.retroAchievementsUserIndependentGameRecordDAO.findWithNameAndConsoleId(search, j, i);
    }

    public static /* synthetic */ List findRetroAchievementsUserIndependentGameRecordEntityWithNameAndConsoleIdStatically$default(RetroAchievementsRepository retroAchievementsRepository, String str, long j, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        return retroAchievementsRepository.findRetroAchievementsUserIndependentGameRecordEntityWithNameAndConsoleIdStatically(str, j, i);
    }

    public final List<RetroAchievementsUserIndependentGameRecordEntity> findRetroAchievementsUserIndependentGameRecordEntityWithNameAndConsoleIdStatically(String search, long j, int i) {
        Intrinsics.checkNotNullParameter(search, "search");
        return this.retroAchievementsUserIndependentGameRecordDAO.findWithNameAndConsoleIdStatically(search, j, i);
    }

    public final long addRetroAchievementsUserIndependentGameRecord(RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserIndependentGameRecordEntity, "retroAchievementsUserIndependentGameRecordEntity");
        return this.retroAchievementsUserIndependentGameRecordDAO.insert(retroAchievementsUserIndependentGameRecordEntity);
    }

    public final List<Long> addRetroAchievementsUserIndependentGameRecords(RetroAchievementsUserIndependentGameRecordEntity... retroAchievementsUserIndependentGameRecordEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserIndependentGameRecordEntities, "retroAchievementsUserIndependentGameRecordEntities");
        return this.retroAchievementsUserIndependentGameRecordDAO.insertAll((RetroAchievementsUserIndependentGameRecordEntity[]) Arrays.copyOf(retroAchievementsUserIndependentGameRecordEntities, retroAchievementsUserIndependentGameRecordEntities.length));
    }

    public final void updateRetroAchievementsUserIndependentGameRecord(RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserIndependentGameRecordEntity, "retroAchievementsUserIndependentGameRecordEntity");
        this.retroAchievementsUserIndependentGameRecordDAO.update(retroAchievementsUserIndependentGameRecordEntity);
    }

    public final void updateRetroAchievementsUserIndependentGameRecords(RetroAchievementsUserIndependentGameRecordEntity... retroAchievementsUserIndependentGameRecordEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserIndependentGameRecordEntities, "retroAchievementsUserIndependentGameRecordEntities");
        this.retroAchievementsUserIndependentGameRecordDAO.updateAll((RetroAchievementsUserIndependentGameRecordEntity[]) Arrays.copyOf(retroAchievementsUserIndependentGameRecordEntities, retroAchievementsUserIndependentGameRecordEntities.length));
    }

    public final void deleteRetroAchievementsUserIndependentGameRecord(RetroAchievementsUserIndependentGameRecordEntity retroAchievementsUserIndependentGameRecordEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserIndependentGameRecordEntity, "retroAchievementsUserIndependentGameRecordEntity");
        this.retroAchievementsUserIndependentGameRecordDAO.delete(retroAchievementsUserIndependentGameRecordEntity);
    }

    public final void deleteRetroAchievementsUserIndependentGameRecords(RetroAchievementsUserIndependentGameRecordEntity... retroAchievementsUserIndependentGameRecordEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserIndependentGameRecordEntities, "retroAchievementsUserIndependentGameRecordEntities");
        this.retroAchievementsUserIndependentGameRecordDAO.deleteAll((RetroAchievementsUserIndependentGameRecordEntity[]) Arrays.copyOf(retroAchievementsUserIndependentGameRecordEntities, retroAchievementsUserIndependentGameRecordEntities.length));
    }

    public final int deleteRetroAchievementsUserIndependentGameRecordsByConsoleId(long j) {
        return this.retroAchievementsUserIndependentGameRecordDAO.deleteByConsoleId(j);
    }

    public final LiveData<Integer> countAllRetroAchievementsUserProfile() {
        return this.retroAchievementsUserProfileDAO.countAll();
    }

    public final int countAllRetroAchievementsUserProfileStatically() {
        return this.retroAchievementsUserProfileDAO.countAllStatically();
    }

    public final LiveData<RetroAchievementsUserProfileEntity> getRetroAchievementsUserProfileById(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.retroAchievementsUserProfileDAO.selectById(id2);
    }

    public final RetroAchievementsUserProfileEntity getRetroAchievementsUserProfileByIdStatically(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.retroAchievementsUserProfileDAO.selectByIdStatically(id2);
    }

    public final long addRetroAchievementsUserProfile(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserProfileEntity, "retroAchievementsUserProfileEntity");
        return this.retroAchievementsUserProfileDAO.insert(retroAchievementsUserProfileEntity);
    }

    public final List<Long> addRetroAchievementsUserProfiles(RetroAchievementsUserProfileEntity... retroAchievementsUserProfileEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserProfileEntities, "retroAchievementsUserProfileEntities");
        return this.retroAchievementsUserProfileDAO.insertAll((RetroAchievementsUserProfileEntity[]) Arrays.copyOf(retroAchievementsUserProfileEntities, retroAchievementsUserProfileEntities.length));
    }

    public final void updateRetroAchievementsUserProfile(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserProfileEntity, "retroAchievementsUserProfileEntity");
        this.retroAchievementsUserProfileDAO.update(retroAchievementsUserProfileEntity);
    }

    public final void updateRetroAchievementsUserProfiles(RetroAchievementsUserProfileEntity... retroAchievementsUserProfileEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserProfileEntities, "retroAchievementsUserProfileEntities");
        this.retroAchievementsUserProfileDAO.updateAll((RetroAchievementsUserProfileEntity[]) Arrays.copyOf(retroAchievementsUserProfileEntities, retroAchievementsUserProfileEntities.length));
    }

    public final void deleteRetroAchievementsUserProfile(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserProfileEntity, "retroAchievementsUserProfileEntity");
        this.retroAchievementsUserProfileDAO.delete(retroAchievementsUserProfileEntity);
    }

    public final void deleteRetroAchievementsUserProfiles(RetroAchievementsUserProfileEntity... retroAchievementsUserProfileEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserProfileEntities, "retroAchievementsUserProfileEntities");
        this.retroAchievementsUserProfileDAO.deleteAll((RetroAchievementsUserProfileEntity[]) Arrays.copyOf(retroAchievementsUserProfileEntities, retroAchievementsUserProfileEntities.length));
    }

    public final LiveData<Integer> countAllRetroAchievementsUserRankings() {
        return this.retroAchievementsUserRankingDAO.countAll();
    }

    public final int countAllRetroAchievementsUserRankingsStatically() {
        return this.retroAchievementsUserRankingDAO.countAllStatically();
    }

    public final LiveData<RetroAchievementsUserRankingEntity> getRetroAchievementsUserRankingById(long j) {
        return this.retroAchievementsUserRankingDAO.selectById(j);
    }

    public final RetroAchievementsUserRankingEntity getRetroAchievementsUserRankingByIdStatically(long j) {
        return this.retroAchievementsUserRankingDAO.selectByIdStatically(j);
    }

    public final LiveData<List<RetroAchievementsUserRankingEntity>> getRetroAchievementsUserRankingsByPerspectiveAndGranularity(String whosePerspective, int i) {
        Intrinsics.checkNotNullParameter(whosePerspective, "whosePerspective");
        return this.retroAchievementsUserRankingDAO.selectByPerspectiveAndGranularity(whosePerspective, i);
    }

    public final List<RetroAchievementsUserRankingEntity> getRetroAchievementsUserRankingsByPerspectiveAndGranularityStatically(String whosePerspective, int i) {
        Intrinsics.checkNotNullParameter(whosePerspective, "whosePerspective");
        return this.retroAchievementsUserRankingDAO.selectByPerspectiveAndGranularityStatically(whosePerspective, i);
    }

    public final LiveData<List<RetroAchievementsUserRankingEntity>> getRetroAchievementsUserRankingsByPerspective(String whosePerspective) {
        Intrinsics.checkNotNullParameter(whosePerspective, "whosePerspective");
        return this.retroAchievementsUserRankingDAO.selectByPerspective(whosePerspective);
    }

    public final List<RetroAchievementsUserRankingEntity> getRetroAchievementsUserRankingsByPerspectiveStatically(String whosePerspective) {
        Intrinsics.checkNotNullParameter(whosePerspective, "whosePerspective");
        return this.retroAchievementsUserRankingDAO.selectByPerspectiveStatically(whosePerspective);
    }

    public final long addRetroAchievementsUserRanking(RetroAchievementsUserRankingEntity retroAchievementsUserRankingEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserRankingEntity, "retroAchievementsUserRankingEntity");
        return this.retroAchievementsUserRankingDAO.insert(retroAchievementsUserRankingEntity);
    }

    public final List<Long> addRetroAchievementsUserRankings(RetroAchievementsUserRankingEntity... retroAchievementsUserRankingEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserRankingEntities, "retroAchievementsUserRankingEntities");
        return this.retroAchievementsUserRankingDAO.insertAll((RetroAchievementsUserRankingEntity[]) Arrays.copyOf(retroAchievementsUserRankingEntities, retroAchievementsUserRankingEntities.length));
    }

    public final void updateRetroAchievementsUserRanking(RetroAchievementsUserRankingEntity retroAchievementsUserRankingEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserRankingEntity, "retroAchievementsUserRankingEntity");
        this.retroAchievementsUserRankingDAO.update(retroAchievementsUserRankingEntity);
    }

    public final void updateRetroAchievementsUserRankings(RetroAchievementsUserRankingEntity... retroAchievementsUserRankingEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserRankingEntities, "retroAchievementsUserRankingEntities");
        this.retroAchievementsUserRankingDAO.updateAll((RetroAchievementsUserRankingEntity[]) Arrays.copyOf(retroAchievementsUserRankingEntities, retroAchievementsUserRankingEntities.length));
    }

    public final void deleteRetroAchievementsUserRanking(RetroAchievementsUserRankingEntity retroAchievementsUserRankingEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserRankingEntity, "retroAchievementsUserRankingEntity");
        this.retroAchievementsUserRankingDAO.delete(retroAchievementsUserRankingEntity);
    }

    public final void deleteRetroAchievementsUserRankings(RetroAchievementsUserRankingEntity... retroAchievementsUserRankingEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserRankingEntities, "retroAchievementsUserRankingEntities");
        this.retroAchievementsUserRankingDAO.deleteAll((RetroAchievementsUserRankingEntity[]) Arrays.copyOf(retroAchievementsUserRankingEntities, retroAchievementsUserRankingEntities.length));
    }

    public final LiveData<Integer> countAllRetroAchievementsUserAwards() {
        return this.retroAchievementsUserAwardDAO.countAll();
    }

    public final int countAllRetroAchievementsUserAwardsStatically() {
        return this.retroAchievementsUserAwardDAO.countAllStatically();
    }

    public final LiveData<List<RetroAchievementsUserAwardEntity>> getAllRetroAchievementsUserAwards() {
        return this.retroAchievementsUserAwardDAO.selectAll();
    }

    public final List<RetroAchievementsUserAwardEntity> getAllRetroAchievementsUserAwardsStatically() {
        return this.retroAchievementsUserAwardDAO.selectAllStatically();
    }

    public final LiveData<RetroAchievementsUserAwardEntity> getRetroAchievementsUserAwardById(long j) {
        return this.retroAchievementsUserAwardDAO.selectById(j);
    }

    public final RetroAchievementsUserAwardEntity getRetroAchievementsUserAwardByIdStatically(long j) {
        return this.retroAchievementsUserAwardDAO.selectByIdStatically(j);
    }

    public final LiveData<List<RetroAchievementsUserAwardEntity>> getRetroAchievementsUserAwardsByIds(long... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.retroAchievementsUserAwardDAO.selectByIds(Arrays.copyOf(ids, ids.length));
    }

    public final List<RetroAchievementsUserAwardEntity> getRetroAchievementsUserAwardsByIdsStatically(long... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.retroAchievementsUserAwardDAO.selectByIdsStatically(Arrays.copyOf(ids, ids.length));
    }

    public final LiveData<List<RetroAchievementsUserAwardEntity>> getRetroAchievementsUserAwardsByUserId(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return this.retroAchievementsUserAwardDAO.selectByUserId(userId);
    }

    public final List<RetroAchievementsUserAwardEntity> getRetroAchievementsUserAwardsByUserIdStatically(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return this.retroAchievementsUserAwardDAO.selectByUserIdStatically(userId);
    }

    public final LiveData<List<RetroAchievementsUserAwardEntity>> getRetroAchievementsUserAwardsByUserIdAndAwardData(String userId, long j) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return this.retroAchievementsUserAwardDAO.selectByUserIdAndAwardData(userId, j);
    }

    public final List<RetroAchievementsUserAwardEntity> getRetroAchievementsUserAwardsByUserIdAndAwardDataStatically(String userId, long j) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return this.retroAchievementsUserAwardDAO.selectByUserIdAndAwardDataStatically(userId, j);
    }

    public final LiveData<List<RetroAchievementsUserAwardEntity>> getRetroAchievementsUserAwardsByConsoleId(long j) {
        return this.retroAchievementsUserAwardDAO.selectByConsoleId(j);
    }

    public final RetroAchievementsUserAwardEntity getRetroAchievementsUserAwardsByConsoleIdStatically(long j) {
        return this.retroAchievementsUserAwardDAO.selectByIdStatically(j);
    }

    public final long addRetroAchievementsUserAward(RetroAchievementsUserAwardEntity retroAchievementsUserRankingEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserRankingEntity, "retroAchievementsUserRankingEntity");
        return this.retroAchievementsUserAwardDAO.insert(retroAchievementsUserRankingEntity);
    }

    public final List<Long> addRetroAchievementsUserAwards(RetroAchievementsUserAwardEntity... retroAchievementsUserRankingEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserRankingEntities, "retroAchievementsUserRankingEntities");
        return this.retroAchievementsUserAwardDAO.insertAll((RetroAchievementsUserAwardEntity[]) Arrays.copyOf(retroAchievementsUserRankingEntities, retroAchievementsUserRankingEntities.length));
    }

    public final void updateRetroAchievementsUserAward(RetroAchievementsUserAwardEntity retroAchievementsUserRankingEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserRankingEntity, "retroAchievementsUserRankingEntity");
        this.retroAchievementsUserAwardDAO.update(retroAchievementsUserRankingEntity);
    }

    public final void updateRetroAchievementsUserAwards(RetroAchievementsUserAwardEntity... retroAchievementsUserRankingEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserRankingEntities, "retroAchievementsUserRankingEntities");
        this.retroAchievementsUserAwardDAO.updateAll((RetroAchievementsUserAwardEntity[]) Arrays.copyOf(retroAchievementsUserRankingEntities, retroAchievementsUserRankingEntities.length));
    }

    public final void deleteRetroAchievementsUserAward(RetroAchievementsUserAwardEntity retroAchievementsUserRankingEntity) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserRankingEntity, "retroAchievementsUserRankingEntity");
        this.retroAchievementsUserAwardDAO.delete(retroAchievementsUserRankingEntity);
    }

    public final void deleteRetroAchievementsUserAwards(RetroAchievementsUserAwardEntity... retroAchievementsUserRankingEntities) {
        Intrinsics.checkNotNullParameter(retroAchievementsUserRankingEntities, "retroAchievementsUserRankingEntities");
        this.retroAchievementsUserAwardDAO.deleteAll((RetroAchievementsUserAwardEntity[]) Arrays.copyOf(retroAchievementsUserRankingEntities, retroAchievementsUserRankingEntities.length));
    }

    public final int deleteRetroAchievementsUserAwardByUserId(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return this.retroAchievementsUserAwardDAO.deleteByUserId(userId);
    }

    public final int deleteRetroAchievementsUserAwardByConsoleId(long j) {
        return this.retroAchievementsUserAwardDAO.deleteByConsoleId(j);
    }
}
