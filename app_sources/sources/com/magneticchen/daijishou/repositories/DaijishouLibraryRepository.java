package com.magneticchen.daijishou.repositories;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.LiveData;
import androidx.preference.PreferenceManager;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.DaijishouDatabase;
import com.magneticchen.daijishou.daijishou_library_db.EventDAO;
import com.magneticchen.daijishou.daijishou_library_db.EventEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlatformDAO;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemDAO;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntityMergedInfo;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairDAO;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayerDAO;
import com.magneticchen.daijishou.daijishou_library_db.PlayerEntity;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformEntityPortable;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformSharable;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlayerEntityPortable;
import com.magneticchen.daijishou.dialog_fragments.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsDatabase;
import com.magneticchen.daijishou.utils.LazyMd5;
import com.magneticchen.daijishou.utils.PegasusAmStartArgumentsPatchers;
import com.magneticchen.daijishou.view_models.PlatformWithPlayerEntitiesHolder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: DaijishouLibraryRepository.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0016\n\u0002\by\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u0001:\u0002Î\u0002B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ%\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0!2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\"\"\u00020\u001f¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&J%\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0!2\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0\"\"\u00020&¢\u0006\u0002\u0010)J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/J%\u00100\u001a\b\u0012\u0004\u0012\u00020\u001d0!2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0\"\"\u00020/¢\u0006\u0002\u00102J%\u00103\u001a\b\u0012\u0004\u0012\u00020\u001d0!2\u0012\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020,0\"\"\u00020,¢\u0006\u0002\u00105J\u000e\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u000208J%\u00109\u001a\b\u0012\u0004\u0012\u00020\u001d0!2\u0012\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u0002080\"\"\u000208¢\u0006\u0002\u0010;J\u0006\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u00020?J\u000e\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020\u001dJ\u0006\u0010B\u001a\u00020=J\f\u0010C\u001a\b\u0012\u0004\u0012\u00020?0DJ\u0006\u0010E\u001a\u00020?J\f\u0010F\u001a\b\u0012\u0004\u0012\u00020?0DJ\u0006\u0010G\u001a\u00020?J\f\u0010H\u001a\b\u0012\u0004\u0012\u00020?0DJ\u0006\u0010I\u001a\u00020?J\f\u0010J\u001a\b\u0012\u0004\u0012\u00020?0DJ\u0016\u0010K\u001a\b\u0012\u0004\u0012\u00020?0D2\b\b\u0002\u0010L\u001a\u00020MJ\u0010\u0010N\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ\u0006\u0010O\u001a\u00020?J\f\u0010P\u001a\b\u0012\u0004\u0012\u00020?0DJ\u0006\u0010Q\u001a\u00020?J\f\u0010R\u001a\b\u0012\u0004\u0012\u00020?0DJ\u0006\u0010S\u001a\u00020?J\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001d0D2\u0006\u0010A\u001a\u00020\u001dJ\u001e\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001d0D2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u0018\u0010V\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u0018\u0010W\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u0018\u0010X\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u000e\u0010Y\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001dJ\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001d0D2\u0006\u0010A\u001a\u00020\u001dJ\u000e\u0010[\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001dJ\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001d0D2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020^J&\u0010_\u001a\b\u0012\u0004\u0012\u00020\u001d0D2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020^2\b\b\u0002\u0010L\u001a\u00020MJ \u0010`\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020^2\b\b\u0002\u0010L\u001a\u00020MJ&\u0010a\u001a\b\u0012\u0004\u0012\u00020\u001d0D2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020^2\b\b\u0002\u0010L\u001a\u00020MJ \u0010b\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020^2\b\b\u0002\u0010L\u001a\u00020MJ\u0016\u0010c\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020^J\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020\u001d0D2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020^J\u0016\u0010e\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020^J\u0014\u0010f\u001a\b\u0012\u0004\u0012\u00020\u001d0D2\u0006\u0010A\u001a\u00020\u001dJ\u001e\u0010g\u001a\b\u0012\u0004\u0012\u00020\u001d0D2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u0018\u0010h\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u001e\u0010i\u001a\b\u0012\u0004\u0012\u00020\u001d0D2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u0018\u0010j\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u000e\u0010k\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001dJ\u0014\u0010l\u001a\b\u0012\u0004\u0012\u00020\u001d0D2\u0006\u0010A\u001a\u00020\u001dJ\u000e\u0010m\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001dJ\u001c\u0010n\u001a\b\u0012\u0004\u0012\u00020\u001d0D2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020^J&\u0010o\u001a\b\u0012\u0004\u0012\u00020\u001d0D2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020^2\b\b\u0002\u0010L\u001a\u00020MJ \u0010p\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020^2\b\b\u0002\u0010L\u001a\u00020MJ&\u0010q\u001a\b\u0012\u0004\u0012\u00020\u001d0D2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020^2\b\b\u0002\u0010L\u001a\u00020MJ \u0010r\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020^2\b\b\u0002\u0010L\u001a\u00020MJ\u0016\u0010s\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020^J\u001c\u0010t\u001a\b\u0012\u0004\u0012\u00020\u001d0D2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020^J\u0016\u0010u\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020^J\u0006\u0010v\u001a\u00020=J\u0012\u0010w\u001a\u00020=2\n\u0010x\u001a\u00020y\"\u00020\u001dJ\u000e\u0010z\u001a\u00020=2\u0006\u0010A\u001a\u00020\u001dJ\u0006\u0010{\u001a\u00020=J\u0012\u0010|\u001a\u00020=2\n\u0010x\u001a\u00020y\"\u00020\u001dJ\u000e\u0010}\u001a\u00020=2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010~\u001a\u00020=2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010\u007f\u001a\u00020=2\u0006\u0010+\u001a\u00020,H\u0002J\u000f\u0010\u0080\u0001\u001a\u00020=2\u0006\u0010.\u001a\u00020/J!\u0010\u0081\u0001\u001a\u00020=2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0\"\"\u00020/¢\u0006\u0003\u0010\u0082\u0001J\u000f\u0010\u0083\u0001\u001a\u00020=2\u0006\u0010A\u001a\u00020\u0005J\u000f\u0010\u0084\u0001\u001a\u00020=2\u0006\u0010A\u001a\u00020\u001dJ\u000f\u0010\u0085\u0001\u001a\u00020=2\u0006\u00107\u001a\u000208J\u0007\u0010\u0086\u0001\u001a\u00020=J'\u0010\u0087\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0007\u0010\u0088\u0001\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J'\u0010\u008a\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0007\u0010\u0088\u0001\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J!\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0007\u0010\u0088\u0001\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J1\u0010\u008c\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0007\u0010\u0088\u0001\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ+\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0007\u0010\u0088\u0001\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ1\u0010\u008e\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0007\u0010\u0088\u0001\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ+\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0007\u0010\u0088\u0001\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ!\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0007\u0010\u0088\u0001\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0!J\u0013\u0010\u0092\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0!0DJ\u0013\u0010\u0093\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050!0DJ\r\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050!J\r\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0!J\u0013\u0010\u0096\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0!0DJ\u0013\u0010\u0097\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0!0DJ\r\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020&0!J\u0017\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0!2\b\b\u0002\u0010L\u001a\u00020MJ\r\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0!J\u0013\u0010\u009b\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0!0DJ\r\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0!J\u0013\u0010\u009d\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0!0DJ\u001d\u0010\u009e\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0!0D2\b\b\u0002\u0010L\u001a\u00020MJ\u0013\u0010\u009f\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0!0DJ\r\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0!J\u0013\u0010¡\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080!0DJ\r\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u0002080!J\u0013\u0010£\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0!0DJ\u0013\u0010¤\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0!0DJ\r\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020&0!J\u0017\u0010¦\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0D2\u0006\u0010A\u001a\u00020\u001dJ\u0011\u0010§\u0001\u001a\u0004\u0018\u00010\u001f2\u0006\u0010A\u001a\u00020\u001dJ\t\u0010¨\u0001\u001a\u0004\u0018\u00010,J\u0013\u0010©\u0001\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010L\u001a\u00020MJ\u001e\u0010ª\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J&\u0010«\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u001d2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J0\u0010¬\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u001d2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ*\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u001d2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ \u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u001d2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J&\u0010¯\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J0\u0010°\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ*\u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ \u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J(\u0010³\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ\"\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ\u0018\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J0\u0010¶\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0007\u0010·\u0001\u001a\u00020^2\u0007\u0010¸\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J:\u0010¹\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0007\u0010·\u0001\u001a\u00020^2\u0007\u0010¸\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ4\u0010º\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0007\u0010·\u0001\u001a\u00020^2\u0007\u0010¸\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ*\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0007\u0010·\u0001\u001a\u00020^2\u0007\u0010¸\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J\u001b\u0010¼\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050!0D2\u0006\u0010A\u001a\u00020\u001dJ%\u0010½\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050!0D2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u001f\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050!2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u0015\u0010¿\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050!2\u0006\u0010A\u001a\u00020\u001dJ\u001b\u0010À\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050!0D2\u0006\u0010A\u001a\u00020\u001dJ\u0015\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050!2\u0006\u0010A\u001a\u00020\u001dJ\u000f\u0010Â\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0DJ\t\u0010Ã\u0001\u001a\u0004\u0018\u00010\u001fJ&\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0012\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020,0\"\"\u00020,¢\u0006\u0002\u00105J\u000f\u0010Å\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0DJ\t\u0010Æ\u0001\u001a\u0004\u0018\u00010,J\u0012\u0010Ç\u0001\u001a\u0004\u0018\u00010,2\u0007\u0010È\u0001\u001a\u00020^J\u001c\u0010É\u0001\u001a\u0004\u0018\u00010,2\u0007\u0010È\u0001\u001a\u00020^2\b\b\u0002\u0010L\u001a\u00020MJ'\u0010Ê\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J/\u0010Ë\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u001d2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J9\u0010Ì\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u001d2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ3\u0010Í\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u001d2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ)\u0010Î\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u001d2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J/\u0010Ï\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u00052\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J9\u0010Ð\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u00052\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ3\u0010Ñ\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u00052\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ)\u0010Ò\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u00052\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J1\u0010Ó\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ+\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ!\u0010Õ\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J\u0017\u0010Ö\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0D2\u0006\u0010A\u001a\u00020\u001dJ\u0011\u0010×\u0001\u001a\u0004\u0018\u00010&2\u0006\u0010A\u001a\u00020\u001dJ\u0018\u0010Ø\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0D2\u0007\u0010Ù\u0001\u001a\u00020\u0005J\u0012\u0010Ú\u0001\u001a\u0004\u0018\u00010&2\u0007\u0010Ù\u0001\u001a\u00020\u0005J\u0018\u0010Û\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0D2\u0007\u0010Ü\u0001\u001a\u00020\u0005J\u0012\u0010Ý\u0001\u001a\u0004\u0018\u00010&2\u0007\u0010Ü\u0001\u001a\u00020\u0005J\u0017\u0010Þ\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0D2\u0006\u0010A\u001a\u00020\u001dJ!\u0010ß\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0D2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u001b\u0010à\u0001\u001a\u0004\u0018\u00010,2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u0011\u0010á\u0001\u001a\u0004\u0018\u00010,2\u0006\u0010A\u001a\u00020\u001dJ\u001b\u0010â\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0!0D2\u0006\u0010A\u001a\u00020\u001dJ%\u0010ã\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0!0D2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u001f\u0010ä\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0!2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u0015\u0010å\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0!2\u0006\u0010A\u001a\u00020\u001dJ\u001b\u0010æ\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0!0D2\u0006\u0010A\u001a\u00020\u0005J\u0015\u0010ç\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0!2\u0006\u0010A\u001a\u00020\u0005J\t\u0010è\u0001\u001a\u0004\u0018\u00010,J\u0017\u0010é\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0D2\u0006\u0010A\u001a\u00020\u001dJ!\u0010ê\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0D2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u001b\u0010ë\u0001\u001a\u0004\u0018\u00010,2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u0011\u0010ì\u0001\u001a\u0004\u0018\u00010,2\u0006\u0010A\u001a\u00020\u001dJ\u0013\u0010í\u0001\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010L\u001a\u00020MJ\u0015\u0010î\u0001\u001a\b\u0012\u0004\u0012\u00020/0D2\u0006\u0010A\u001a\u00020\u001dJ\u000f\u0010ï\u0001\u001a\u00020/2\u0006\u0010A\u001a\u00020\u001dJ\u001b\u0010ð\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u001dJ%\u0010ñ\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u001d2\b\u0010ò\u0001\u001a\u00030ó\u0001J/\u0010ô\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u001d2\b\u0010ò\u0001\u001a\u00030ó\u00012\b\b\u0002\u0010L\u001a\u00020MJ)\u0010õ\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u001d2\b\u0010ò\u0001\u001a\u00030ó\u00012\b\b\u0002\u0010L\u001a\u00020MJ\u001f\u0010ö\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u001d2\b\u0010ò\u0001\u001a\u00030ó\u0001J%\u0010÷\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u001f\u0010ø\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u0015\u0010ù\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u001dJ\u001b\u0010ú\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u001dJ%\u0010û\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u001f\u0010ü\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u00020MJ\u0015\u0010ý\u0001\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u001dJ&\u0010þ\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J0\u0010ÿ\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ*\u0010\u0080\u0002\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ \u0010\u0081\u0002\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J\u0019\u0010\u0082\u0002\u001a\b\u0012\u0004\u0012\u00020,0!2\n\u0010x\u001a\u00020y\"\u00020\u001dJ.\u0010\u0083\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0013\u0010\u0084\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\"\"\u00020\u0005¢\u0006\u0003\u0010\u0085\u0002J8\u0010\u0086\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0013\u0010\u0084\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\"\"\u00020\u00052\b\b\u0002\u0010L\u001a\u00020M¢\u0006\u0003\u0010\u0087\u0002J2\u0010\u0088\u0002\u001a\b\u0012\u0004\u0012\u00020,0!2\u0013\u0010\u0084\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\"\"\u00020\u00052\b\b\u0002\u0010L\u001a\u00020M¢\u0006\u0003\u0010\u0089\u0002J(\u0010\u008a\u0002\u001a\b\u0012\u0004\u0012\u00020,0!2\u0013\u0010\u0084\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\"\"\u00020\u0005¢\u0006\u0003\u0010\u008b\u0002J%\u0010\u008c\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0007\u0010\u008d\u0002\u001a\u00020\u001d2\u0007\u0010\u008e\u0002\u001a\u00020\u0005J\u001f\u0010\u008f\u0002\u001a\b\u0012\u0004\u0012\u00020,0!2\u0007\u0010\u008d\u0002\u001a\u00020\u001d2\u0007\u0010\u008e\u0002\u001a\u00020\u0005J/\u0010\u0090\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0007\u0010\u008d\u0002\u001a\u00020\u001d2\u0007\u0010\u008e\u0002\u001a\u00020\u00052\b\b\u0002\u0010L\u001a\u00020MJ)\u0010\u0091\u0002\u001a\b\u0012\u0004\u0012\u00020,0!2\u0007\u0010\u008d\u0002\u001a\u00020\u001d2\u0007\u0010\u008e\u0002\u001a\u00020\u00052\b\b\u0002\u0010L\u001a\u00020MJ\u0017\u0010\u0092\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080D2\u0006\u0010A\u001a\u00020\u001dJ\u0011\u0010\u0093\u0002\u001a\u0004\u0018\u0001082\u0006\u0010A\u001a\u00020\u001dJ\u0012\u0010\u0094\u0002\u001a\u0004\u0018\u0001082\u0007\u0010\u0095\u0002\u001a\u00020\u0005J\u0012\u0010\u0096\u0002\u001a\u0004\u0018\u0001082\u0007\u0010\u0095\u0002\u001a\u00020\u0005J#\u0010\u0097\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001080!0D2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020\u001d0!J\u001d\u0010\u0098\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080!2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020\u001d0!J0\u0010\u0099\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0!0D2\u0007\u0010\u009a\u0002\u001a\u00020?2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J*\u0010\u009b\u0002\u001a\b\u0012\u0004\u0012\u00020\u001f0!2\u0007\u0010\u009a\u0002\u001a\u00020?2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J\u0012\u0010\u009c\u0002\u001a\u0004\u0018\u00010,2\u0007\u0010È\u0001\u001a\u00020^J\u001c\u0010\u009d\u0002\u001a\u0004\u0018\u00010,2\u0007\u0010È\u0001\u001a\u00020^2\b\b\u0002\u0010L\u001a\u00020MJ'\u0010\u009e\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J/\u0010\u009f\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u001d2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J9\u0010 \u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u001d2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ3\u0010¡\u0002\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u001d2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ)\u0010¢\u0002\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u001d2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J/\u0010£\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u00052\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J9\u0010¤\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0006\u0010A\u001a\u00020\u00052\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ3\u0010¥\u0002\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u00052\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ)\u0010¦\u0002\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010A\u001a\u00020\u00052\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J1\u0010§\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0D2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ+\u0010¨\u0002\u001a\b\u0012\u0004\u0012\u00020,0!2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\b\b\u0002\u0010L\u001a\u00020MJ!\u0010©\u0002\u001a\b\u0012\u0004\u0012\u00020,0!2\u0007\u0010È\u0001\u001a\u00020^2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?J5\u0010ª\u0002\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010+\u001a\u00020,2\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\t\b\u0002\u0010«\u0002\u001a\u00020M2\b\b\u0002\u0010L\u001a\u00020MJQ\u0010¬\u0002\u001a\u00020=2\b\u0010\u00ad\u0002\u001a\u00030®\u00022\t\b\u0002\u0010¯\u0002\u001a\u00020M2\t\b\u0002\u0010°\u0002\u001a\u00020M2\f\b\u0002\u0010±\u0002\u001a\u0005\u0018\u00010²\u00022\u001a\b\u0002\u0010³\u0002\u001a\u0013\u0012\u0006\u0012\u0004\u0018\u00010&\u0012\u0004\u0012\u00020=\u0018\u00010´\u0002J\u0010\u0010µ\u0002\u001a\u00020=2\u0007\u0010¶\u0002\u001a\u00020\u0005J7\u0010·\u0002\u001a\u00020=2\b\u0010±\u0002\u001a\u00030²\u00022\b\u0010\u00ad\u0002\u001a\u00030®\u00022\u001a\b\u0002\u0010³\u0002\u001a\u0013\u0012\u0006\u0012\u0004\u0018\u00010&\u0012\u0004\u0012\u00020=\u0018\u00010´\u0002J\u0007\u0010¸\u0002\u001a\u00020=J\u001d\u0010¹\u0002\u001a\u00020\u00052\u0007\u0010º\u0002\u001a\u00020\u00052\t\b\u0002\u0010»\u0002\u001a\u00020MH\u0002J\u0007\u0010¼\u0002\u001a\u00020=J\u0007\u0010½\u0002\u001a\u00020=J\u0007\u0010¾\u0002\u001a\u00020?J\u001a\u0010¿\u0002\u001a\u00020=2\u0006\u0010%\u001a\u00020&2\t\b\u0002\u0010À\u0002\u001a\u00020MJ\"\u0010Á\u0002\u001a\u00020=2\u0006\u0010%\u001a\u00020&2\b\u0010ò\u0001\u001a\u00030ó\u00012\u0007\u0010Â\u0002\u001a\u00020MJ\u000f\u0010Ã\u0002\u001a\u00020=2\u0006\u0010+\u001a\u00020,JT\u0010Ä\u0002\u001a\b\u0012\u0004\u0012\u00020,0!2\u0007\u0010\u0088\u0001\u001a\u00020\u00052\t\b\u0002\u0010\u0089\u0001\u001a\u00020?2\u0011\b\u0002\u0010Å\u0002\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010!2\t\b\u0002\u0010Æ\u0002\u001a\u00020M2\t\b\u0002\u0010«\u0002\u001a\u00020M2\b\b\u0002\u0010L\u001a\u00020MJ\u000f\u0010Ç\u0002\u001a\u00020=2\u0006\u0010%\u001a\u00020&J\u000f\u0010È\u0002\u001a\u00020=2\u0006\u0010+\u001a\u00020,J\u000f\u0010É\u0002\u001a\u00020=2\u0006\u0010.\u001a\u00020/J!\u0010Ê\u0002\u001a\u00020=2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0\"\"\u00020/¢\u0006\u0003\u0010\u0082\u0001J\u000f\u0010Ë\u0002\u001a\u00020=2\u0006\u0010+\u001a\u00020,J!\u0010Ì\u0002\u001a\u00020=2\u0012\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020,0\"\"\u00020,¢\u0006\u0003\u0010Í\u0002R\u000e\u0010\u0002\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00060\u0011R\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Ï\u0002"}, d2 = {"Lcom/magneticchen/daijishou/repositories/DaijishouLibraryRepository;", "", "application", "Landroid/app/Application;", "databaseName", "", "retroAchievementsDatabaseName", "(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/magneticchen/daijishou/DaijishouApplication;", "database", "Lcom/magneticchen/daijishou/daijishou_library_db/DaijishouDatabase;", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "eventDAO", "Lcom/magneticchen/daijishou/daijishou_library_db/EventDAO;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "platformDAO", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformDAO;", "playableItemDAO", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemDAO;", "playableItemToGenrePairDAO", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemToGenrePairDAO;", "playerDAO", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayerDAO;", "retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO;", "addEvent", "", "eventEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/EventEntity;", "addEvents", "", "", "([Lcom/magneticchen/daijishou/daijishou_library_db/EventEntity;)Ljava/util/List;", "addPlatform", "platformEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "addPlatforms", "platformEntities", "([Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;)Ljava/util/List;", "addPlayableItem", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "addPlayableItemToGenrePair", "playableItemToGenrePairEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemToGenrePairEntity;", "addPlayableItemToGenrePairs", "playableItemToGenrePairEntities", "([Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemToGenrePairEntity;)Ljava/util/List;", "addPlayableItems", "playableItemEntities", "([Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;)Ljava/util/List;", "addPlayer", "playerEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayerEntity;", "addPlayers", "playerEntities", "([Lcom/magneticchen/daijishou/daijishou_library_db/PlayerEntity;)Ljava/util/List;", "clearAll", "", "clearAllDisjointedPlayableItems", "", "clearAllDisjointedPlayableItemsByAttachedPlatformId", "id", "close", "countAllEvents", "Landroidx/lifecycle/LiveData;", "countAllEventsStatically", "countAllPlatforms", "countAllPlatformsStatically", "countAllPlayableItemToGenrePair", "countAllPlayableItemToGenrePairStatically", "countAllPlayableItems", "countAllPlayableItemsByVisibility", "visibility", "", "countAllPlayableItemsByVisibilityStatically", "countAllPlayableItemsStatically", "countAllPlayableItemsWithDisjointSetPrimaryPlayableItemId", "countAllPlayableItemsWithDisjointSetPrimaryPlayableItemIdStatically", "countAllPlayers", "countAllPlayersStatically", "countFavoritePlayableItemsByAttachedPlatformId", "countFavoritePlayableItemsByAttachedPlatformIdAndVisibility", "countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityStatically", "countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId", "countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically", "countFavoritePlayableItemsByAttachedPlatformIdStatically", "countFavoritePlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId", "countFavoritePlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically", "countNewlyPlayableItemsByAttachedPlatformId", "date", "Ljava/util/Date;", "countNewlyPlayableItemsByAttachedPlatformIdAndVisibility", "countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityStatically", "countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId", "countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically", "countNewlyPlayableItemsByAttachedPlatformIdStatically", "countNewlyPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId", "countNewlyPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically", "countPlayableItemsByAttachedPlatformId", "countPlayableItemsByAttachedPlatformIdAndVisibility", "countPlayableItemsByAttachedPlatformIdAndVisibilityStatically", "countPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId", "countPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically", "countPlayableItemsByAttachedPlatformIdStatically", "countPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId", "countPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically", "countRecentPlayableItemsByAttachedPlatformId", "countRecentPlayableItemsByAttachedPlatformIdAndVisibility", "countRecentPlayableItemsByAttachedPlatformIdAndVisibilityStatically", "countRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId", "countRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically", "countRecentPlayableItemsByAttachedPlatformIdStatically", "countRecentPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId", "countRecentPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically", "deleteAllEvents", "deleteAllEventsByIds", "ids", "", "deleteAllEventsByPlayableItemId", "deleteAllPlayableItemToGenrePairs", "deleteAllPlayersByIds", "deleteEvent", "deletePlatformPreviewMedia", "deletePlayableItemEntityPreviewMediaAndRelations", "deletePlayableItemToGenrePair", "deletePlayableItemToGenrePairs", "([Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemToGenrePairEntity;)V", "deletePlayableItemToGenrePairsByGenreId", "deletePlayableItemToGenrePairsByPlayableItemId", "deletePlayer", "disableAllPlayableItemsCustomPlayer", "findPlayableItemsWithName", "keyword", "limit", "findPlayableItemsWithNameAndDescription", "findPlayableItemsWithNameAndDescriptionStatically", "findPlayableItemsWithNameAndVisibility", "findPlayableItemsWithNameAndVisibilityStatically", "findPlayableItemsWithNameDescriptionAndVisibility", "findPlayableItemsWithNameDescriptionAndVisibilityStatically", "findPlayableItemsWithNameStatically", "getAllEventIdsStatically", "getAllEventItemsIds", "getAllGenreIds", "getAllGenreIdsStatically", "getAllPlatformIdsStatically", "getAllPlatformItemsIds", "getAllPlatforms", "getAllPlatformsStatically", "getAllPlayableItemIdsByVisibilityStatically", "getAllPlayableItemIdsStatically", "getAllPlayableItemToGenrePairIds", "getAllPlayableItemToGenrePairIdsStatically", "getAllPlayableItemsIds", "getAllPlayableItemsIdsByVisibility", "getAllPlayerIds", "getAllPlayerIdsStatically", "getAllPlayers", "getAllPlayersStatically", "getAllVisiblePlatforms", "getAllVisiblePlatformsOrderedByShortName", "getAllVisiblePlatformsOrderedByShortNameStatically", "getEventById", "getEventByIdStatically", "getFavoritePlayableItemRandomly", "getFavoritePlayableItemRandomlyByVisibility", "getFavoritePlayableItems", "getFavoritePlayableItemsByAttachedPlatformId", "getFavoritePlayableItemsByAttachedPlatformIdAndVisibility", "getFavoritePlayableItemsByAttachedPlatformIdAndVisibilityStatically", "getFavoritePlayableItemsByAttachedPlatformIdStatically", "getFavoritePlayableItemsByGenreId", "getFavoritePlayableItemsByGenreIdAndVisibility", "getFavoritePlayableItemsByGenreIdAndVisibilityStatically", "getFavoritePlayableItemsByGenreIdStatically", "getFavoritePlayableItemsByVisibility", "getFavoritePlayableItemsByVisibilityStatically", "getFavoritePlayableItemsStatically", "getFavoriteRecentOrNewlyPlayableItems", "afterDateRecent", "afterDateNewly", "getFavoriteRecentOrNewlyPlayableItemsByVisibility", "getFavoriteRecentOrNewlyPlayableItemsByVisibilityStatically", "getFavoriteRecentOrNewlyPlayableItemsStatically", "getGenreIdsByPlatformId", "getGenreIdsByPlatformIdAndVisibility", "getGenreIdsByPlatformIdAndVisibilityStatically", "getGenreIdsByPlatformIdStatically", "getGenreIdsByPlayableItemId", "getGenreIdsByPlayableItemIdStatically", "getLatestEvent", "getLatestEventStatically", "getMergedPlayableItems", "getMostRecentPlayableItem", "getMostRecentPlayableItemStatically", "getNewlyPlayableItemRandomly", "afterDate", "getNewlyPlayableItemRandomlyByVisibility", "getNewlyPlayableItems", "getNewlyPlayableItemsByAttachedPlatformId", "getNewlyPlayableItemsByAttachedPlatformIdAndVisibility", "getNewlyPlayableItemsByAttachedPlatformIdAndVisibilityStatically", "getNewlyPlayableItemsByAttachedPlatformIdStatically", "getNewlyPlayableItemsByGenreId", "getNewlyPlayableItemsByGenreIdAndVisibility", "getNewlyPlayableItemsByGenreIdAndVisibilityStatically", "getNewlyPlayableItemsByGenreIdStatically", "getNewlyPlayableItemsByVisibility", "getNewlyPlayableItemsByVisibilityStatically", "getNewlyPlayableItemsStatically", "getPlatformById", "getPlatformByIdStatically", "getPlatformByShortname", "shortname", "getPlatformByShortnameStatically", "getPlatformByUniqueId", "uniqueId", "getPlatformByUniqueIdStatically", "getPlayableItemById", "getPlayableItemByIdAndVisibility", "getPlayableItemByIdAndVisibilityStatically", "getPlayableItemByIdStatically", "getPlayableItemIdsByAttachedPlatformId", "getPlayableItemIdsByAttachedPlatformIdAndVisibility", "getPlayableItemIdsByAttachedPlatformIdAndVisibilityStatically", "getPlayableItemIdsByAttachedPlatformIdStatically", "getPlayableItemIdsByGenreId", "getPlayableItemIdsByGenreIdStatically", "getPlayableItemRandomly", "getPlayableItemRandomlyByAttachedPlatformId", "getPlayableItemRandomlyByAttachedPlatformIdAndVisibility", "getPlayableItemRandomlyByAttachedPlatformIdAndVisibilityStatically", "getPlayableItemRandomlyByAttachedPlatformIdStatically", "getPlayableItemRandomlyByVisibility", "getPlayableItemToGenrePairById", "getPlayableItemToGenrePairByIdStatically", "getPlayableItemsByAttachedPlatformId", "getPlayableItemsByAttachedPlatformIdAndSyncTreeUri", "uri", "Landroid/net/Uri;", "getPlayableItemsByAttachedPlatformIdAndSyncTreeUriAndVisibility", "getPlayableItemsByAttachedPlatformIdAndSyncTreeUriAndVisibilityStatically", "getPlayableItemsByAttachedPlatformIdAndSyncTreeUriStatically", "getPlayableItemsByAttachedPlatformIdAndVisibility", "getPlayableItemsByAttachedPlatformIdAndVisibilityStatically", "getPlayableItemsByAttachedPlatformIdStatically", "getPlayableItemsByDisjointSetPrimaryPlayableItemId", "getPlayableItemsByDisjointSetPrimaryPlayableItemIdAndVisibility", "getPlayableItemsByDisjointSetPrimaryPlayableItemIdAndVisibilityStatically", "getPlayableItemsByDisjointSetPrimaryPlayableItemIdStatically", "getPlayableItemsByGenreId", "getPlayableItemsByGenreIdAndVisibility", "getPlayableItemsByGenreIdAndVisibilityStatically", "getPlayableItemsByGenreIdStatically", "getPlayableItemsByIdsStatically", "getPlayableItemsByMd5List", "md5List", "([Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "getPlayableItemsByMd5ListAndVisibility", "([Ljava/lang/String;Z)Landroidx/lifecycle/LiveData;", "getPlayableItemsByMd5ListAndVisibilityStatically", "([Ljava/lang/String;Z)Ljava/util/List;", "getPlayableItemsByMd5ListStatically", "([Ljava/lang/String;)Ljava/util/List;", "getPlayableItemsByPlatformIdAndGenreId", "platformId", "genreId", "getPlayableItemsByPlatformIdAndGenreIdStatically", "getPlayableItemsByPlatformIdGenreIdAndVisibility", "getPlayableItemsByPlatformIdGenreIdAndVisibilityStatically", "getPlayerById", "getPlayerByIdStatically", "getPlayerByName", "name", "getPlayerByNameStatically", "getPlayersByIds", "getPlayersByIdsStatically", "getRecentEventsByEvent", NotificationCompat.CATEGORY_EVENT, "getRecentEventsByEventStatically", "getRecentPlayableItemRandomly", "getRecentPlayableItemRandomlyByVisibility", "getRecentPlayableItems", "getRecentPlayableItemsByAttachedPlatformId", "getRecentPlayableItemsByAttachedPlatformIdAndVisibility", "getRecentPlayableItemsByAttachedPlatformIdAndVisibilityStatically", "getRecentPlayableItemsByAttachedPlatformIdStatically", "getRecentPlayableItemsByGenreId", "getRecentPlayableItemsByGenreIdAndVisibility", "getRecentPlayableItemsByGenreIdAndVisibilityStatically", "getRecentPlayableItemsByGenreIdStatically", "getRecentPlayableItemsByVisibility", "getRecentPlayableItemsByVisibilityStatically", "getRecentPlayableItemsStatically", "getSimilarPlayableItems", "withVisibility", "importPlatform", "platformSharable", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformSharable;", "toast", "justUpdateOldOne", "activity", "Landroid/app/Activity;", "callback", "Lkotlin/Function1;", "importPlatformFromPegasus", TypedValues.Custom.S_STRING, "importPlatformWithDialog", "open", "prettifyTitle", "title", "showDiscIndex", "removeAllPlatformsPreviewMedia", "removeAllPlayableItemsPreviewMediaAndRelations", "removeDisjointedEvents", "removePlatform", "deletePlayers", "removePlatformSyncTreeUri", "keepRecords", "removePlayableItem", "searchPlayableItemsByKeyword", "excludedIdList", "ignoreTrivial", "updatePlatform", "updatePlayableItem", "updatePlayableItemToGenrePair", "updatePlayableItemToGenrePairs", "updatePlayableItemWithMergedInfo", "updatePlayableItems", "([Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;)V", "PlayableItemEntityWithCount", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouLibraryRepository {
    private final DaijishouApplication application;
    private DaijishouDatabase database;
    private final String databaseName;
    private final SharedPreferences defaultSharedPreferences;
    private EventDAO eventDAO;
    private final DaijishouApplication.WrappedLogger logger;
    private PlatformDAO platformDAO;
    private PlayableItemDAO playableItemDAO;
    private PlayableItemToGenrePairDAO playableItemToGenrePairDAO;
    private PlayerDAO playerDAO;
    private RetroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO;
    private final String retroAchievementsDatabaseName;

    public DaijishouLibraryRepository(Application application, String databaseName, String retroAchievementsDatabaseName) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(databaseName, "databaseName");
        Intrinsics.checkNotNullParameter(retroAchievementsDatabaseName, "retroAchievementsDatabaseName");
        this.databaseName = databaseName;
        this.retroAchievementsDatabaseName = retroAchievementsDatabaseName;
        DaijishouApplication daijishouApplication = (DaijishouApplication) application;
        this.application = daijishouApplication;
        this.logger = daijishouApplication.getLogger();
        this.defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(daijishouApplication.getApplicationContext());
        DaijishouDatabase companion = DaijishouDatabase.INSTANCE.getInstance(daijishouApplication, databaseName);
        this.database = companion;
        this.platformDAO = companion.platformDAO();
        this.playerDAO = this.database.playerDAO();
        this.playableItemDAO = this.database.playableItemDAO();
        this.eventDAO = this.database.eventDAO();
        this.playableItemToGenrePairDAO = this.database.playableItemToGenrePairDAO();
        this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO = RetroAchievementsDatabase.INSTANCE.getInstance(daijishouApplication, retroAchievementsDatabaseName).retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO();
    }

    public /* synthetic */ DaijishouLibraryRepository(Application application, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, (i & 2) != 0 ? DaijishouDatabase.DB_NAME : str, (i & 4) != 0 ? RetroAchievementsDatabase.DB_NAME : str2);
    }

    public final void close() {
        DaijishouDatabase.INSTANCE.closeInstance(this.databaseName);
    }

    public final void open() {
        if (this.database.isOpen()) {
            return;
        }
        DaijishouDatabase companion = DaijishouDatabase.INSTANCE.getInstance(this.application, this.databaseName);
        this.database = companion;
        this.platformDAO = companion.platformDAO();
        this.playerDAO = this.database.playerDAO();
        this.playableItemDAO = this.database.playableItemDAO();
        this.eventDAO = this.database.eventDAO();
    }

    private final String prettifyTitle(String title, boolean showDiscIndex) {
        return this.application.prettifyTitle(title, showDiscIndex);
    }

    static /* synthetic */ String prettifyTitle$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return daijishouLibraryRepository.prettifyTitle(str, z);
    }

    private final void deletePlayableItemEntityPreviewMediaAndRelations(PlayableItemEntity playableItemEntity) {
        RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntitySelectByPlayableItemIdStatically = this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.selectByPlayableItemIdStatically(playableItemEntity.getId());
        if (retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntitySelectByPlayableItemIdStatically != null) {
            this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.delete(retroAchievementsCachedPlayableItemIdToGameIdSurjectionEntitySelectByPlayableItemIdStatically);
        }
        String previewMediaPath = playableItemEntity.getPreviewMediaPath();
        if (previewMediaPath == null) {
            return;
        }
        File file = new File(previewMediaPath);
        if (file.exists()) {
            FilesKt.deleteRecursively(file);
        }
    }

    private final void deletePlatformPreviewMedia(PlatformEntity platformEntity) {
        String wallpaperPath = platformEntity.getWallpaperPath();
        if (wallpaperPath != null) {
            File file = new File(wallpaperPath);
            if (file.exists()) {
                FilesKt.deleteRecursively(file);
            }
        }
    }

    public final void clearAll() {
        this.database.clearAllTables();
    }

    public final void deleteAllPlayableItemToGenrePairs() {
        this.playableItemToGenrePairDAO.nukeTable();
    }

    public final long addPlayableItemToGenrePair(PlayableItemToGenrePairEntity playableItemToGenrePairEntity) {
        Intrinsics.checkNotNullParameter(playableItemToGenrePairEntity, "playableItemToGenrePairEntity");
        return this.playableItemToGenrePairDAO.insert(playableItemToGenrePairEntity);
    }

    public final List<Long> addPlayableItemToGenrePairs(PlayableItemToGenrePairEntity... playableItemToGenrePairEntities) {
        Intrinsics.checkNotNullParameter(playableItemToGenrePairEntities, "playableItemToGenrePairEntities");
        return this.playableItemToGenrePairDAO.insertAll((PlayableItemToGenrePairEntity[]) Arrays.copyOf(playableItemToGenrePairEntities, playableItemToGenrePairEntities.length));
    }

    public final void updatePlayableItemToGenrePair(PlayableItemToGenrePairEntity playableItemToGenrePairEntity) {
        Intrinsics.checkNotNullParameter(playableItemToGenrePairEntity, "playableItemToGenrePairEntity");
        this.playableItemToGenrePairDAO.update(playableItemToGenrePairEntity);
    }

    public final void updatePlayableItemToGenrePairs(PlayableItemToGenrePairEntity... playableItemToGenrePairEntities) {
        Intrinsics.checkNotNullParameter(playableItemToGenrePairEntities, "playableItemToGenrePairEntities");
        this.playableItemToGenrePairDAO.updateAll((PlayableItemToGenrePairEntity[]) Arrays.copyOf(playableItemToGenrePairEntities, playableItemToGenrePairEntities.length));
    }

    public final void deletePlayableItemToGenrePair(PlayableItemToGenrePairEntity playableItemToGenrePairEntity) {
        Intrinsics.checkNotNullParameter(playableItemToGenrePairEntity, "playableItemToGenrePairEntity");
        this.playableItemToGenrePairDAO.delete(playableItemToGenrePairEntity);
    }

    public final void deletePlayableItemToGenrePairs(PlayableItemToGenrePairEntity... playableItemToGenrePairEntities) {
        Intrinsics.checkNotNullParameter(playableItemToGenrePairEntities, "playableItemToGenrePairEntities");
        this.playableItemToGenrePairDAO.deleteAll((PlayableItemToGenrePairEntity[]) Arrays.copyOf(playableItemToGenrePairEntities, playableItemToGenrePairEntities.length));
    }

    public final void deletePlayableItemToGenrePairsByGenreId(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        this.playableItemToGenrePairDAO.deleteByGenreId(id2);
    }

    public final void deletePlayableItemToGenrePairsByPlayableItemId(long id2) {
        this.playableItemToGenrePairDAO.deleteByPlayableItemId(id2);
    }

    public final LiveData<Integer> countAllPlayableItemToGenrePair() {
        return this.playableItemToGenrePairDAO.countAll();
    }

    public final int countAllPlayableItemToGenrePairStatically() {
        return this.playableItemToGenrePairDAO.countAllStatically();
    }

    public final LiveData<List<Long>> getPlayableItemIdsByGenreId(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.playableItemToGenrePairDAO.selectPlayableItemIdsByGenreId(id2);
    }

    public final List<Long> getPlayableItemIdsByGenreIdStatically(String id2) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.playableItemToGenrePairDAO.selectPlayableItemIdsByGenreIdStatically(id2);
    }

    public final LiveData<List<String>> getGenreIdsByPlayableItemId(long id2) {
        return this.playableItemToGenrePairDAO.selectGenreIdsByPlayableItemId(id2);
    }

    public final List<String> getGenreIdsByPlayableItemIdStatically(long id2) {
        return this.playableItemToGenrePairDAO.selectGenreIdsByPlayableItemIdStatically(id2);
    }

    public final LiveData<List<String>> getAllGenreIds() {
        return this.playableItemToGenrePairDAO.selectAllGenreIds();
    }

    public final List<String> getAllGenreIdsStatically() {
        return this.playableItemToGenrePairDAO.selectAllGenreIdsStatically();
    }

    public final LiveData<List<String>> getGenreIdsByPlatformId(long id2) {
        return this.playableItemToGenrePairDAO.selectGenreIdsByPlatformId(id2);
    }

    public final List<String> getGenreIdsByPlatformIdStatically(long id2) {
        return this.playableItemToGenrePairDAO.selectGenreIdsByPlatformIdStatically(id2);
    }

    public static /* synthetic */ LiveData getGenreIdsByPlatformIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getGenreIdsByPlatformIdAndVisibility(j, z);
    }

    public final LiveData<List<String>> getGenreIdsByPlatformIdAndVisibility(long id2, boolean visibility) {
        return this.playableItemToGenrePairDAO.selectGenreIdsByPlatformIdAndVisibility(id2, visibility);
    }

    public static /* synthetic */ List getGenreIdsByPlatformIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getGenreIdsByPlatformIdAndVisibilityStatically(j, z);
    }

    public final List<String> getGenreIdsByPlatformIdAndVisibilityStatically(long id2, boolean visibility) {
        return this.playableItemToGenrePairDAO.selectGenreIdsByPlatformIdAndVisibilityStatically(id2, visibility);
    }

    public final LiveData<List<PlayableItemEntity>> getPlayableItemsByPlatformIdAndGenreId(long platformId, String genreId) {
        Intrinsics.checkNotNullParameter(genreId, "genreId");
        return this.playableItemDAO.selectByPlatformIdAndGenreId(platformId, genreId);
    }

    public final List<PlayableItemEntity> getPlayableItemsByPlatformIdAndGenreIdStatically(long platformId, String genreId) {
        Intrinsics.checkNotNullParameter(genreId, "genreId");
        return this.playableItemDAO.selectByPlatformIdAndGenreIdStatically(platformId, genreId);
    }

    public static /* synthetic */ LiveData getPlayableItemsByPlatformIdGenreIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemsByPlatformIdGenreIdAndVisibility(j, str, z);
    }

    public final LiveData<List<PlayableItemEntity>> getPlayableItemsByPlatformIdGenreIdAndVisibility(long platformId, String genreId, boolean visibility) {
        Intrinsics.checkNotNullParameter(genreId, "genreId");
        return this.playableItemDAO.selectByPlatformIdGenreIdAndVisibility(platformId, genreId, visibility);
    }

    public static /* synthetic */ List getPlayableItemsByPlatformIdGenreIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemsByPlatformIdGenreIdAndVisibilityStatically(j, str, z);
    }

    public final List<PlayableItemEntity> getPlayableItemsByPlatformIdGenreIdAndVisibilityStatically(long platformId, String genreId, boolean visibility) {
        Intrinsics.checkNotNullParameter(genreId, "genreId");
        return this.playableItemDAO.selectByPlatformIdGenreIdAndVisibilityStatically(platformId, genreId, visibility);
    }

    public final LiveData<List<Long>> getAllPlayableItemToGenrePairIds() {
        return this.playableItemToGenrePairDAO.selectAllIds();
    }

    public final List<Long> getAllPlayableItemToGenrePairIdsStatically() {
        return this.playableItemToGenrePairDAO.selectAllIdsStatically();
    }

    public final LiveData<PlayableItemToGenrePairEntity> getPlayableItemToGenrePairById(long id2) {
        return this.playableItemToGenrePairDAO.selectById(id2);
    }

    public final PlayableItemToGenrePairEntity getPlayableItemToGenrePairByIdStatically(long id2) {
        return this.playableItemToGenrePairDAO.selectByIdStatically(id2);
    }

    public final void deleteAllEvents() {
        this.eventDAO.nukeTable();
    }

    public final long addEvent(EventEntity eventEntity) {
        Intrinsics.checkNotNullParameter(eventEntity, "eventEntity");
        return this.eventDAO.insert(eventEntity);
    }

    public final List<Long> addEvents(EventEntity... eventEntity) {
        Intrinsics.checkNotNullParameter(eventEntity, "eventEntity");
        return this.eventDAO.insertAll((EventEntity[]) Arrays.copyOf(eventEntity, eventEntity.length));
    }

    public final void deleteEvent(EventEntity eventEntity) {
        Intrinsics.checkNotNullParameter(eventEntity, "eventEntity");
        this.eventDAO.delete(eventEntity);
    }

    public final void deleteAllEventsByIds(long... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        this.eventDAO.deleteAllByIds(Arrays.copyOf(ids, ids.length));
    }

    public final void deleteAllEventsByPlayableItemId(long id2) {
        this.eventDAO.deleteAllByPlayableItemId(id2);
    }

    public final LiveData<EventEntity> getEventById(long id2) {
        return this.eventDAO.selectById(id2);
    }

    public final EventEntity getEventByIdStatically(long id2) {
        return this.eventDAO.selectByIdStatically(id2);
    }

    public final LiveData<List<Long>> getAllEventItemsIds() {
        return this.eventDAO.selectAllIds();
    }

    public final List<Long> getAllEventIdsStatically() {
        return this.eventDAO.selectAllIdsStatically();
    }

    public final LiveData<EventEntity> getLatestEvent() {
        return this.eventDAO.selectLatest();
    }

    public final EventEntity getLatestEventStatically() {
        return this.eventDAO.selectLatestStatically();
    }

    public final LiveData<Integer> countAllEvents() {
        return this.eventDAO.countAll();
    }

    public final int countAllEventsStatically() {
        return this.eventDAO.countAllStatically();
    }

    public static /* synthetic */ LiveData getRecentEventsByEvent$default(DaijishouLibraryRepository daijishouLibraryRepository, int i, Date date, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 512;
        }
        return daijishouLibraryRepository.getRecentEventsByEvent(i, date, i2);
    }

    public final LiveData<List<EventEntity>> getRecentEventsByEvent(int event, Date afterDate, int limit) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.eventDAO.selectRecentByEvent(event, afterDate, limit);
    }

    public static /* synthetic */ List getRecentEventsByEventStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, int i, Date date, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 512;
        }
        return daijishouLibraryRepository.getRecentEventsByEventStatically(i, date, i2);
    }

    public final List<EventEntity> getRecentEventsByEventStatically(int event, Date afterDate, int limit) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.eventDAO.selectRecentByEventStatically(event, afterDate, limit);
    }

    public final long addPlatform(PlatformEntity platformEntity) {
        Intrinsics.checkNotNullParameter(platformEntity, "platformEntity");
        return this.platformDAO.insert(platformEntity);
    }

    public final List<Long> addPlatforms(PlatformEntity... platformEntities) {
        Intrinsics.checkNotNullParameter(platformEntities, "platformEntities");
        return this.platformDAO.insertAll((PlatformEntity[]) Arrays.copyOf(platformEntities, platformEntities.length));
    }

    public final void updatePlatform(PlatformEntity platformEntity) {
        Intrinsics.checkNotNullParameter(platformEntity, "platformEntity");
        this.platformDAO.update(platformEntity);
    }

    public static /* synthetic */ void removePlatform$default(DaijishouLibraryRepository daijishouLibraryRepository, PlatformEntity platformEntity, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        daijishouLibraryRepository.removePlatform(platformEntity, z);
    }

    public final void removePlatform(PlatformEntity platformEntity, boolean deletePlayers) {
        Intrinsics.checkNotNullParameter(platformEntity, "platformEntity");
        long id2 = platformEntity.getId();
        for (PlayableItemEntity playableItemEntity : this.playableItemDAO.selectByAttachedPlatformIdStatically(id2)) {
            deletePlayableItemEntityPreviewMediaAndRelations(playableItemEntity);
            deleteAllEventsByPlayableItemId(playableItemEntity.getId());
        }
        this.playableItemDAO.deleteByAttachedPlatformId(id2);
        this.platformDAO.delete(platformEntity);
        if (deletePlayers) {
            List mutableList = CollectionsKt.toMutableList((Collection) platformEntity.getPlayerIdList());
            Iterator it = this.platformDAO.selectAllStatically().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((PlatformEntity) it.next()).getPlayerIdList().iterator();
                while (it2.hasNext()) {
                    mutableList.remove(Long.valueOf(((Number) it2.next()).longValue()));
                }
            }
            PlayerDAO playerDAO = this.playerDAO;
            List list = mutableList;
            long[] longArray = CollectionsKt.toLongArray(list);
            playerDAO.deleteAllByIds(Arrays.copyOf(longArray, longArray.length));
            PlayerDAO playerDAO2 = this.playerDAO;
            long[] longArray2 = CollectionsKt.toLongArray(list);
            playerDAO2.deleteAllByIds(Arrays.copyOf(longArray2, longArray2.length));
        }
    }

    public final int removeDisjointedEvents() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.eventDAO.selectAllIdsStatically().iterator();
        while (it.hasNext()) {
            EventEntity eventEntitySelectByIdStatically = this.eventDAO.selectByIdStatically(((Number) it.next()).longValue());
            Intrinsics.checkNotNull(eventEntitySelectByIdStatically);
            if (eventEntitySelectByIdStatically.getPlayableItemId() != null) {
                PlayableItemDAO playableItemDAO = this.playableItemDAO;
                Long playableItemId = eventEntitySelectByIdStatically.getPlayableItemId();
                Intrinsics.checkNotNull(playableItemId);
                if (playableItemDAO.selectByIdStatically(playableItemId.longValue()) == null) {
                    arrayList.add(Long.valueOf(eventEntitySelectByIdStatically.getId()));
                }
            }
            if (eventEntitySelectByIdStatically.getPlatformId() != null) {
                PlatformDAO platformDAO = this.platformDAO;
                Long platformId = eventEntitySelectByIdStatically.getPlatformId();
                Intrinsics.checkNotNull(platformId);
                if (platformDAO.selectByIdStatically(platformId.longValue()) == null) {
                    arrayList.add(Long.valueOf(eventEntitySelectByIdStatically.getId()));
                }
            }
        }
        int size = arrayList.size();
        EventDAO eventDAO = this.eventDAO;
        long[] longArray = CollectionsKt.toLongArray(arrayList);
        eventDAO.deleteAllByIds(Arrays.copyOf(longArray, longArray.length));
        return size;
    }

    public final void removePlatformSyncTreeUri(PlatformEntity platformEntity, Uri uri, boolean keepRecords) {
        Intrinsics.checkNotNullParameter(platformEntity, "platformEntity");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (keepRecords) {
            for (PlayableItemEntity playableItemEntity : this.playableItemDAO.selectByAttachedPlatformIdAndSyncTreeUriStatically(platformEntity.getId(), uri)) {
                Uri EMPTY = Uri.EMPTY;
                Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
                playableItemEntity.setSyncTreeUri(EMPTY);
                Uri EMPTY2 = Uri.EMPTY;
                Intrinsics.checkNotNullExpressionValue(EMPTY2, "EMPTY");
                playableItemEntity.setUri(EMPTY2);
                this.playableItemDAO.update(playableItemEntity);
            }
        } else {
            for (PlayableItemEntity playableItemEntity2 : this.playableItemDAO.selectByAttachedPlatformIdAndSyncTreeUriStatically(platformEntity.getId(), uri)) {
                deletePlayableItemEntityPreviewMediaAndRelations(playableItemEntity2);
                deleteAllEventsByPlayableItemId(playableItemEntity2.getId());
            }
            this.playableItemDAO.deleteByAttachedPlatformIdAndSyncTreeUri(platformEntity.getId(), uri);
        }
        platformEntity.getItemsSyncTreeUriList().remove(uri);
        this.platformDAO.update(platformEntity);
    }

    /* WARN: Multi-variable type inference failed */
    /* WARN: Type inference failed for: r11v1, types: [java.lang.String] */
    /* WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* WARN: Type inference failed for: r12v1 */
    /* WARN: Type inference failed for: r12v10 */
    /* WARN: Type inference failed for: r12v4 */
    /* WARN: Type inference failed for: r12v5 */
    /* WARN: Type inference failed for: r12v6 */
    /* WARN: Type inference failed for: r12v7 */
    /* WARN: Type inference failed for: r12v8 */
    /* WARN: Type inference failed for: r12v9 */
    /* WARN: Type inference failed for: r16v1 */
    /* WARN: Type inference failed for: r16v10 */
    /* WARN: Type inference failed for: r16v11 */
    /* WARN: Type inference failed for: r16v12 */
    /* WARN: Type inference failed for: r16v2 */
    /* WARN: Type inference failed for: r16v6 */
    /* WARN: Type inference failed for: r16v7 */
    /* WARN: Type inference failed for: r16v8 */
    /* WARN: Type inference failed for: r16v9 */
    /* WARN: Type inference failed for: r1v44, types: [T, java.lang.String] */
    /* WARN: Type inference failed for: r3v28, types: [T, java.lang.String] */
    /* WARN: Type inference failed for: r3v34 */
    /* WARN: Type inference failed for: r3v35 */
    /* WARN: Type inference failed for: r6v38, types: [java.lang.StringBuilder] */
    public final void importPlatformFromPegasus(String string) {
        String str;
        boolean zBooleanValue;
        String str2;
        String strReplace$default;
        String str3;
        boolean zBooleanValue2;
        List<String> groupValues;
        List<String> groupValues2;
        HashMap map;
        Intrinsics.checkNotNullParameter(string, "string");
        int i = 0;
        List<String> listSplit = new Regex("(?:\\n\\s*){2,}").split(string, 0);
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Regex regex = new Regex("^([^:]+)\\s*:\\s*(.*)$");
        Regex regex2 = new Regex("^[\\s\\n]*$");
        Regex regex3 = new Regex("\\.*-n[\\s]*(.*)/");
        Regex regex4 = new Regex(".*/cores/(.*)_libretro_android\\.so");
        Iterator<String> it = listSplit.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!regex2.matches(next)) {
                String[] strArr = new String[1];
                strArr[i] = "\n";
                List listSplit$default = StringsKt.split$default((CharSequence) next, strArr, false, 0, 6, (Object) null);
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                String r12 = "";
                objectRef.element = "";
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = "";
                Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                objectRef3.element = "";
                int i2 = i;
                String r16 = "";
                while (true) {
                    it = it;
                    if (i2 >= listSplit$default.size()) {
                        break;
                    }
                    regex4 = regex4;
                    map3 = map3;
                    int i3 = 2;
                    MatchResult matchResultFind$default = Regex.find$default(regex, (String) listSplit$default.get(i2), 0, 2, null);
                    if (matchResultFind$default == null) {
                        i2++;
                    } else {
                        List<String> groupValues3 = matchResultFind$default.getGroupValues();
                        int i4 = 1;
                        String str4 = groupValues3.get(1);
                        String r3 = groupValues3.get(2);
                        while (true) {
                            i2 += i4;
                            if (i2 >= listSplit$default.size()) {
                                map = map2;
                                break;
                            }
                            map = map2;
                            if (Regex.find$default(regex, (CharSequence) listSplit$default.get(i2), 0, i3, null) != null) {
                                break;
                            }
                            map2 = map;
                            i3 = 2;
                            i4 = 1;
                            r3 = r3 + "\n" + listSplit$default.get(i2);
                        }
                        String str5 = str4;
                        if (StringsKt.indexOf$default((CharSequence) str5, "collection", 0, false, 6, (Object) null) != -1) {
                            objectRef.element = r3;
                            r12 = r12;
                            r16 = r16;
                        } else if (StringsKt.indexOf$default((CharSequence) str5, "shortname", 0, false, 6, (Object) null) != -1) {
                            r16 = r3;
                            r12 = r12;
                        } else if (StringsKt.indexOf$default((CharSequence) str5, ConfigConstants.CONFIG_EXTENSIONS_SECTION, 0, false, 6, (Object) null) != -1) {
                            MatchResult matchResultFind$default2 = Regex.find$default(new Regex("\\s*(.*\\S)\\s*"), (CharSequence) r3, 0, 2, null);
                            Intrinsics.checkNotNull(matchResultFind$default2);
                            objectRef3.element = matchResultFind$default2.getGroupValues().get(1);
                            r12 = r12;
                            r16 = r16;
                        } else if (StringsKt.indexOf$default((CharSequence) str5, "launch", 0, false, 6, (Object) null) != -1) {
                            r12 = r12;
                            r16 = r16;
                            r12 = r3;
                            r16 = r16;
                        }
                        r12 = r12;
                        r16 = r16;
                        map2 = map;
                    }
                }
                Regex regex5 = regex4;
                HashMap map4 = map3;
                HashMap map5 = map2;
                CharSequence charSequence = (CharSequence) r12;
                MatchResult matchResultFind$default3 = Regex.find$default(regex3, charSequence, 0, 2, null);
                String str6 = (matchResultFind$default3 == null || (groupValues2 = matchResultFind$default3.getGroupValues()) == null) ? null : groupValues2.get(1);
                boolean zAreEqual = Intrinsics.areEqual(str6, "com.retroarch");
                MatchResult matchResultFind$default4 = Regex.find$default(new Regex(".*am\\s+start[\\s\\n]+([\\s\\S]*)"), charSequence, 0, 2, null);
                String str7 = (matchResultFind$default4 == null || (groupValues = matchResultFind$default4.getGroupValues()) == null) ? null : groupValues.get(1);
                Function1<String, Pair<String, Boolean>> function1 = PegasusAmStartArgumentsPatchers.INSTANCE.getPatchers().get(str6);
                if (function1 != null) {
                    Pair<String, Boolean> pairInvoke = function1.invoke(str7);
                    String first = pairInvoke.getFirst();
                    zBooleanValue = pairInvoke.getSecond().booleanValue();
                    str = first;
                } else {
                    str = str7;
                    zBooleanValue = false;
                }
                String str8 = "^(.*)\\.(?:" + new Regex("\\s*,\\s*").replace((CharSequence) objectRef3.element, "|") + ")$";
                String r11 = r16;
                map3 = map4;
                map2 = map5;
                String str9 = str6;
                regex3 = regex3;
                boolean z = zBooleanValue;
                regex4 = regex5;
                importPlatformFromPegasus$addPlayer(objectRef2, regex4, map3, objectRef3, map2, objectRef, str9, r11, str8, str, z);
                if (zAreEqual) {
                    Intrinsics.checkNotNull(str9);
                    String str10 = str9 + ".aarch64";
                    String strReplace$default2 = str != null ? StringsKt.replace$default(str, str9 + "/.", str9 + InternalZipConstants.ZIP_FILE_SEPARATOR + str9 + BranchConfig.LOCAL_REPOSITORY, false, 4, (Object) null) : null;
                    if (strReplace$default2 != null) {
                        str2 = str10;
                        strReplace$default = StringsKt.replace$default(strReplace$default2, str9, str10, false, 4, (Object) null);
                    } else {
                        str2 = str10;
                        strReplace$default = null;
                    }
                    String strReplace$default3 = strReplace$default != null ? StringsKt.replace$default(strReplace$default, InternalZipConstants.ZIP_FILE_SEPARATOR + str2 + ".browser", InternalZipConstants.ZIP_FILE_SEPARATOR + str9 + ".browser", false, 4, (Object) null) : null;
                    Function1<String, Pair<String, Boolean>> function2 = PegasusAmStartArgumentsPatchers.INSTANCE.getPatchers().get(str2);
                    if (function2 != null) {
                        Pair<String, Boolean> pairInvoke2 = function2.invoke(strReplace$default3);
                        String first2 = pairInvoke2.getFirst();
                        zBooleanValue2 = pairInvoke2.getSecond().booleanValue();
                        str3 = first2;
                    } else {
                        str3 = strReplace$default3;
                        zBooleanValue2 = false;
                    }
                    importPlatformFromPegasus$addPlayer(objectRef2, regex4, map3, objectRef3, map2, objectRef, str2, r11, str8, str3, zBooleanValue2);
                    regex = regex;
                }
                it = it;
            }
            i = 0;
        }
        int size = 0;
        for (String str11 : ((java.util.Set<String>) (java.util.Set) map2.keySet())) {
            Object obj = map2.get(str11);
            Intrinsics.checkNotNull(obj);
            PlatformWithPlayerEntitiesHolder platformWithPlayerEntitiesHolder = (PlatformWithPlayerEntitiesHolder) obj;
            PlayerDAO playerDAO = this.playerDAO;
            PlayerEntity[] playerEntityArr = (PlayerEntity[]) platformWithPlayerEntitiesHolder.getPlayerEntities().toArray(new PlayerEntity[0]);
            List<Long> listInsertAll = playerDAO.insertAll((PlayerEntity[]) Arrays.copyOf(playerEntityArr, playerEntityArr.length));
            PlatformEntity platformEntity = new PlatformEntity(0L, null, null, null, null, false, false, null, null, null, null, null, 0L, null, null, 0, false, null, 0, false, null, null, null, null, ViewCompat.MEASURED_SIZE_MASK, null);
            size += listInsertAll.size();
            Intrinsics.checkNotNull(str11);
            platformEntity.setName(str11);
            platformEntity.setShortname(platformWithPlayerEntitiesHolder.getPlatformShortName());
            platformEntity.setVisible(true);
            platformEntity.setDefaultPlayerId(listInsertAll.get(0).longValue());
            platformEntity.getPlayerIdList().addAll(listInsertAll);
            this.platformDAO.insert(platformEntity);
        }
        Toast.makeText(this.application, "Added " + map2.size() + " platforms, " + size + " players.", 0).show();
    }

    /* WARN: Type inference failed for: r10v4, types: [T, java.lang.String] */
    /* WARN: Type inference failed for: r4v24, types: [T, java.lang.String] */
    /* WARN: Type inference failed for: r4v8, types: [T, java.lang.String] */
    /* WARN: Type inference failed for: r9v10, types: [T, java.lang.String] */
    private static final void importPlatformFromPegasus$addPlayer(Ref.ObjectRef<String> objectRef, Regex regex, HashMap<String, Integer> map, Ref.ObjectRef<String> objectRef2, HashMap<String, PlatformWithPlayerEntitiesHolder> map2, Ref.ObjectRef<String> objectRef3, String str, String str2, String str3, String str4, boolean z) {
        MatchResult matchResultFind$default;
        String str5;
        if (str == null) {
            objectRef.element = str2 + " - unknown";
        } else {
            String str6 = Constants.INSTANCE.getPackageNameToDisplayNameHashMap().get(str);
            objectRef.element = str2 + " - " + str;
            if (str6 != null) {
                objectRef.element = str2 + " - " + str6;
            }
            if (StringsKt.startsWith$default(str, "com.retroarch", false, 2, (Object) null) && str4 != null && (matchResultFind$default = Regex.find$default(regex, str4, 0, 2, null)) != null) {
                objectRef.element = ((Object) objectRef.element) + " - " + ((Object) matchResultFind$default.getGroupValues().get(1));
            }
        }
        if (map.containsKey(objectRef.element)) {
            String str7 = objectRef.element;
            Integer num = map.get(objectRef.element);
            Intrinsics.checkNotNull(num);
            map.put(str7, Integer.valueOf(num.intValue() + 1));
        } else {
            map.put(objectRef.element, 0);
        }
        Integer num2 = map.get(objectRef.element);
        if (num2 != null && num2.intValue() == 0) {
            str5 = objectRef.element;
        } else {
            str5 = ((Object) objectRef.element) + " - " + map.get(objectRef.element);
        }
        PlayerEntity playerEntity = new PlayerEntity(0L, null, 0, null, null, null, false, false, null, null, 1023, null);
        playerEntity.setName(str5);
        playerEntity.setAcceptedFilenameRegex(str3);
        playerEntity.setDescription("Imported from pegasus. Supported extensions: " + ((Object) objectRef2.element) + BranchConfig.LOCAL_REPOSITORY);
        playerEntity.setAmStartArguments(str4 == null ? "" : str4);
        playerEntity.setKillPackageProcesses(z);
        if (!map2.containsKey(objectRef3.element)) {
            PlatformWithPlayerEntitiesHolder platformWithPlayerEntitiesHolder = new PlatformWithPlayerEntitiesHolder(null, null, null, null, 15, null);
            platformWithPlayerEntitiesHolder.setPlatformName(objectRef3.element);
            platformWithPlayerEntitiesHolder.setPlatformShortName(str2);
            map2.put(objectRef3.element, platformWithPlayerEntitiesHolder);
        }
        PlatformWithPlayerEntitiesHolder platformWithPlayerEntitiesHolder2 = map2.get(objectRef3.element);
        Intrinsics.checkNotNull(platformWithPlayerEntitiesHolder2);
        platformWithPlayerEntitiesHolder2.getPlayerEntities().add(playerEntity);
    }

    /* WARN: Multi-variable type inference failed */
    public static /* synthetic */ void importPlatform$default(DaijishouLibraryRepository daijishouLibraryRepository, PlatformSharable platformSharable, boolean z, boolean z2, Activity activity, Function1 function1, int i, Object obj) throws Exception {
        if ((i & 2) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 4) != 0) {
            z2 = false;
        }
        daijishouLibraryRepository.importPlatform(platformSharable, z3, z2, (i & 8) != 0 ? null : activity, (i & 16) != 0 ? null : function1);
    }

    public final void importPlatform(PlatformSharable platformSharable, boolean toast, boolean justUpdateOldOne, Activity activity, Function1<? super PlatformEntity, Unit> callback) throws Exception {
        List<Long> playerIdList;
        Intrinsics.checkNotNullParameter(platformSharable, "platformSharable");
        String uniqueId = platformSharable.getPlatform().getUniqueId();
        PlatformEntity platformByUniqueIdStatically = uniqueId == null ? null : getPlatformByUniqueIdStatically(uniqueId);
        ArrayList arrayList = new ArrayList();
        if (platformByUniqueIdStatically != null && (playerIdList = platformByUniqueIdStatically.getPlayerIdList()) != null) {
            Iterator it = playerIdList.iterator();
            while (it.hasNext()) {
                PlayerEntity playerByIdStatically = getPlayerByIdStatically(((Number) it.next()).longValue());
                if (playerByIdStatically != null) {
                    arrayList.add(playerByIdStatically);
                }
            }
        }
        if (platformByUniqueIdStatically == null) {
            importPlatform$import(this, platformSharable, platformByUniqueIdStatically, callback, toast, arrayList, false);
            return;
        }
        if (justUpdateOldOne) {
            importPlatform$import(this, platformSharable, platformByUniqueIdStatically, callback, toast, arrayList, true);
            return;
        }
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AcknowledgementDialogFragment.Companion companion = AcknowledgementDialogFragment.INSTANCE;
        String string = this.application.getString(R.string.replace_platform_warning_title);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string2 = this.application.getString(R.string.replace_platform_warning_description_format);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String str = String.format(string2, Arrays.copyOf(new Object[]{platformByUniqueIdStatically.getUniqueId(), platformSharable.getPlatform().getName()}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        companion.newInstance(string, str, this.application.getString(R.string.replace), this.application.getString(R.string.cancel), this.application.getString(R.string._import)).setOnAcknowledgedListener(new AnonymousClass2(platformSharable, platformByUniqueIdStatically, callback, toast, arrayList)).setOnCanceledListener(new AnonymousClass3(callback)).setOnNeutralButtonClickedListener(new AnonymousClass4(platformSharable, platformByUniqueIdStatically, callback, toast, arrayList)).show(((AppCompatActivity) activity).getSupportFragmentManager(), AcknowledgementDialogFragment.class.getName());
    }

    /* INFO: Access modifiers changed from: private */
    public static final void importPlatform$import(DaijishouLibraryRepository daijishouLibraryRepository, PlatformSharable platformSharable, PlatformEntity platformEntity, Function1<? super PlatformEntity, Unit> function1, boolean z, List<PlayerEntity> list, boolean z2) throws Exception {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            PackageManager packageManager = daijishouLibraryRepository.application.getPackageManager();
            boolean z3 = false;
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
            Collections.sort(listQueryIntentActivities, new ResolveInfo.DisplayNameComparator(packageManager));
            PlatformEntityPortable platform = platformSharable.getPlatform();
            List<PlayerEntityPortable> playerList = platformSharable.getPlayerList();
            int size = playerList.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                PlayerEntityPortable playerEntityPortable = playerList.get(i);
                PlayerEntity playerEntity = new PlayerEntity(0L, playerEntityPortable.getUniqueId(), StringsKt.contains$default((CharSequence) playerEntityPortable.getAmStartArguments(), (CharSequence) "{android.activity}", false, 2, (Object) null) ? 2 : 1, playerEntityPortable.getName(), playerEntityPortable.getDescription(), playerEntityPortable.getAmStartArguments(), playerEntityPortable.getKillPackageProcesses(), playerEntityPortable.getKillPackageProcessesWarning(), playerEntityPortable.getAcceptedFilenameRegex(), playerEntityPortable.getExtra(), 1, null);
                if (z2) {
                    for (PlayerEntity playerEntity2 : list) {
                        if (Intrinsics.areEqual(playerEntity2.getName(), playerEntityPortable.getName())) {
                            playerEntity.setId(playerEntity2.getId());
                            playerEntity.setKillPackageProcessesWarning(playerEntity2.getKillPackageProcessesWarning());
                        }
                    }
                }
                arrayList.add(playerEntity);
            }
            ArrayList arrayList2 = arrayList;
            PlayerEntity[] playerEntityArr = (PlayerEntity[]) arrayList2.toArray(new PlayerEntity[0]);
            List<Long> listAddPlayers = daijishouLibraryRepository.addPlayers((PlayerEntity[]) Arrays.copyOf(playerEntityArr, playerEntityArr.length));
            Intrinsics.checkNotNull(listAddPlayers, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Long>");
            List<Long> listAsMutableList = TypeIntrinsics.asMutableList(listAddPlayers);
            PlatformEntity platformEntity2 = new PlatformEntity(0L, platform.getUniqueId(), platform.getName(), platform.getShortname(), platform.getDescription(), false, false, null, null, null, null, platform.getAcceptedFilenameRegex(), 0L, null, platform.getScraperSourceList(), platform.getBoxArtAspectRatioId(), platform.getUseCustomBoxArtAspectRatio(), platform.getCustomBoxArtAspectRatio(), platform.getScreenAspectRatioId(), platform.getUseCustomScreenAspectRatio(), platform.getCustomScreenAspectRatio(), null, platform.getRetroAchievementsConsoleIdList(), platform.getExtra(), 2111457, null);
            if (z2) {
                Intrinsics.checkNotNull(platformEntity);
                platformEntity2.setId(platformEntity.getId());
                platformEntity2.setVisible(platformEntity.isVisible());
                platformEntity2.setWallpaperPath(platformEntity.getWallpaperPath());
                platformEntity2.setItemsSyncTreeUriList(platformEntity.getItemsSyncTreeUriList());
                platformEntity2.setPlayerIdList(platformEntity.getPlayerIdList());
                Iterator it = listAsMutableList.iterator();
                while (it.hasNext()) {
                    long jLongValue = ((Number) it.next()).longValue();
                    if (!platformEntity2.getPlayerIdList().contains(Long.valueOf(jLongValue))) {
                        platformEntity2.getPlayerIdList().add(Long.valueOf(jLongValue));
                    }
                }
                platformEntity2.setDefaultPlayerId(platformEntity.getDefaultPlayerId());
            } else {
                platformEntity2.setPlayerIdList(listAsMutableList);
                platformEntity2.setDefaultPlayerId(listAsMutableList.get(0).longValue());
            }
            if (!z2) {
                int size2 = arrayList2.size();
                int i2 = 0;
                while (i2 < size2) {
                    PlayerEntity playerEntity3 = (PlayerEntity) arrayList2.get(i2);
                    long jLongValue2 = listAsMutableList.get(i2).longValue();
                    String amStartArguments = playerEntity3.getAmStartArguments();
                    Iterator it2 = listQueryIntentActivities.iterator();
                    boolean z4 = z3;
                    while (it2.hasNext()) {
                        if (StringsKt.contains((CharSequence) amStartArguments, (CharSequence) (((ResolveInfo) it2.next()).activityInfo.packageName + InternalZipConstants.ZIP_FILE_SEPARATOR), true)) {
                            platformEntity2.setDefaultPlayerId(jLongValue2);
                            z4 = true;
                        }
                    }
                    if (z4) {
                        break;
                    }
                    i2++;
                    z3 = false;
                }
            }
            platformEntity2.setId(daijishouLibraryRepository.addPlatform(platformEntity2));
            if (function1 != null) {
                function1.invoke(platformEntity2);
            }
        } catch (Exception e) {
            if (function1 == null) {
                throw e;
            }
            function1.invoke(null);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.repositories.DaijishouLibraryRepository$importPlatform$2, reason: invalid class name */
    /* INFO: compiled from: DaijishouLibraryRepository.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda<Unit> implements Function0<Unit> {
        final /* synthetic */ Function1<? super PlatformEntity, Unit> $callback;
        final /* synthetic */ PlatformSharable $platformSharable;
        final /* synthetic */ PlatformEntity $platformWithSameUniqueId;
        final /* synthetic */ List<PlayerEntity> $platformWithSameUniqueIdPlayers;
        final /* synthetic */ boolean $toast;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        AnonymousClass2(PlatformSharable platformSharable, PlatformEntity platformEntity, Function1<? super PlatformEntity, Unit> function1, boolean z, List<PlayerEntity> list) {
            super(0);
            this.$platformSharable = platformSharable;
            this.$platformWithSameUniqueId = platformEntity;
            this.$callback = function1;
            this.$toast = z;
            this.$platformWithSameUniqueIdPlayers = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            try {
                DaijishouLibraryRepository.importPlatform$import(DaijishouLibraryRepository.this, this.$platformSharable, this.$platformWithSameUniqueId, this.$callback, this.$toast, this.$platformWithSameUniqueIdPlayers, true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.repositories.DaijishouLibraryRepository$importPlatform$3, reason: invalid class name */
    /* INFO: compiled from: DaijishouLibraryRepository.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass3 extends Lambda<Unit> implements Function0<Unit> {
        final /* synthetic */ Function1<? super PlatformEntity, Unit> $callback;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        AnonymousClass3(Function1<? super PlatformEntity, Unit> function1) {
            super(0);
            this.$callback = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function1<? super PlatformEntity, Unit> function1 = this.$callback;
            if (function1 != null) {
                function1.invoke(null);
            }
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.repositories.DaijishouLibraryRepository$importPlatform$4, reason: invalid class name */
    /* INFO: compiled from: DaijishouLibraryRepository.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass4 extends Lambda<Unit> implements Function0<Unit> {
        final /* synthetic */ Function1<? super PlatformEntity, Unit> $callback;
        final /* synthetic */ PlatformSharable $platformSharable;
        final /* synthetic */ PlatformEntity $platformWithSameUniqueId;
        final /* synthetic */ List<PlayerEntity> $platformWithSameUniqueIdPlayers;
        final /* synthetic */ boolean $toast;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        AnonymousClass4(PlatformSharable platformSharable, PlatformEntity platformEntity, Function1<? super PlatformEntity, Unit> function1, boolean z, List<PlayerEntity> list) {
            super(0);
            this.$platformSharable = platformSharable;
            this.$platformWithSameUniqueId = platformEntity;
            this.$callback = function1;
            this.$toast = z;
            this.$platformWithSameUniqueIdPlayers = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            try {
                DaijishouLibraryRepository.importPlatform$import(DaijishouLibraryRepository.this, this.$platformSharable, this.$platformWithSameUniqueId, this.$callback, this.$toast, this.$platformWithSameUniqueIdPlayers, false);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* WARN: Multi-variable type inference failed */
    public static /* synthetic */ void importPlatformWithDialog$default(DaijishouLibraryRepository daijishouLibraryRepository, Activity activity, PlatformSharable platformSharable, Function1 function1, int i, Object obj) throws Exception {
        if ((i & 4) != 0) {
            function1 = null;
        }
        daijishouLibraryRepository.importPlatformWithDialog(activity, platformSharable, function1);
    }

    public final void importPlatformWithDialog(Activity activity, PlatformSharable platformSharable, Function1<? super PlatformEntity, Unit> callback) throws Exception {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(platformSharable, "platformSharable");
        importPlatform(platformSharable, true, false, activity, callback);
    }

    public final void removeAllPlatformsPreviewMedia() {
        Iterator it = this.platformDAO.selectAllStatically().iterator();
        while (it.hasNext()) {
            deletePlatformPreviewMedia((PlatformEntity) it.next());
        }
        File file = new File(this.application.getFilesDir() + "/platform_wallpapers/");
        if (file.exists()) {
            FilesKt.deleteRecursively(file);
        }
        this.platformDAO.updateWallpaperPathAll(null);
    }

    public final LiveData<Integer> countAllPlatforms() {
        return this.platformDAO.countAll();
    }

    public final int countAllPlatformsStatically() {
        return this.platformDAO.countAllStatically();
    }

    public final LiveData<List<Long>> getAllPlatformItemsIds() {
        return this.platformDAO.selectAllIds();
    }

    public final List<Long> getAllPlatformIdsStatically() {
        return this.platformDAO.selectAllIdsStatically();
    }

    public final LiveData<List<PlatformEntity>> getAllPlatforms() {
        return this.platformDAO.selectAll();
    }

    public final List<PlatformEntity> getAllPlatformsStatically() {
        return this.platformDAO.selectAllStatically();
    }

    public final LiveData<List<PlatformEntity>> getAllVisiblePlatforms() {
        return this.platformDAO.selectVisible();
    }

    public final LiveData<List<PlatformEntity>> getAllVisiblePlatformsOrderedByShortName() {
        return this.platformDAO.selectVisibleOrderedByShortName();
    }

    public final List<PlatformEntity> getAllVisiblePlatformsOrderedByShortNameStatically() {
        return this.platformDAO.selectVisibleOrderedByShortNameStatically();
    }

    public final LiveData<PlatformEntity> getPlatformById(long id2) {
        return this.platformDAO.selectById(id2);
    }

    public final PlatformEntity getPlatformByIdStatically(long id2) {
        return this.platformDAO.selectByIdStatically(id2);
    }

    public final LiveData<PlatformEntity> getPlatformByShortname(String shortname) {
        Intrinsics.checkNotNullParameter(shortname, "shortname");
        return this.platformDAO.selectByShortname(shortname);
    }

    public final PlatformEntity getPlatformByShortnameStatically(String shortname) {
        Intrinsics.checkNotNullParameter(shortname, "shortname");
        return this.platformDAO.selectByShortnameStatically(shortname);
    }

    public final LiveData<PlatformEntity> getPlatformByUniqueId(String uniqueId) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        return this.platformDAO.selectByUniqueId(uniqueId);
    }

    public final PlatformEntity getPlatformByUniqueIdStatically(String uniqueId) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        return this.platformDAO.selectByUniqueIdStatically(uniqueId);
    }

    public final long addPlayer(PlayerEntity playerEntity) {
        Intrinsics.checkNotNullParameter(playerEntity, "playerEntity");
        return this.playerDAO.insert(playerEntity);
    }

    public final List<Long> addPlayers(PlayerEntity... playerEntities) {
        Intrinsics.checkNotNullParameter(playerEntities, "playerEntities");
        return this.playerDAO.insertAll((PlayerEntity[]) Arrays.copyOf(playerEntities, playerEntities.length));
    }

    public final void deletePlayer(PlayerEntity playerEntity) {
        Intrinsics.checkNotNullParameter(playerEntity, "playerEntity");
        this.playerDAO.delete(playerEntity);
    }

    public final void deleteAllPlayersByIds(long... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        this.playerDAO.deleteAllByIds(Arrays.copyOf(ids, ids.length));
    }

    public final LiveData<Integer> countAllPlayers() {
        return this.playerDAO.countAll();
    }

    public final int countAllPlayersStatically() {
        return this.playerDAO.countAllStatically();
    }

    public final LiveData<List<Long>> getAllPlayerIds() {
        return this.playerDAO.selectAllIds();
    }

    public final List<Long> getAllPlayerIdsStatically() {
        return this.playerDAO.selectAllIdsStatically();
    }

    public final LiveData<List<PlayerEntity>> getAllPlayers() {
        return this.playerDAO.selectAll();
    }

    public final List<PlayerEntity> getAllPlayersStatically() {
        return this.playerDAO.selectAllStatically();
    }

    public final LiveData<PlayerEntity> getPlayerById(long id2) {
        return this.playerDAO.selectById(id2);
    }

    public final PlayerEntity getPlayerByIdStatically(long id2) {
        return this.playerDAO.selectByIdStatically(id2);
    }

    public final PlayerEntity getPlayerByName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.playerDAO.selectByName(name);
    }

    public final PlayerEntity getPlayerByNameStatically(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.playerDAO.selectByName(name);
    }

    public final LiveData<List<PlayerEntity>> getPlayersByIds(List<Long> ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.playerDAO.selectByIdList(ids);
    }

    public final List<PlayerEntity> getPlayersByIdsStatically(List<Long> ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.playerDAO.selectByIdListStatically(ids);
    }

    public final long addPlayableItem(PlayableItemEntity playableItemEntity) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        return this.playableItemDAO.insert(playableItemEntity);
    }

    public final List<Long> addPlayableItems(PlayableItemEntity... playableItemEntities) {
        Intrinsics.checkNotNullParameter(playableItemEntities, "playableItemEntities");
        return this.playableItemDAO.insertAll((PlayableItemEntity[]) Arrays.copyOf(playableItemEntities, playableItemEntities.length));
    }

    public final void updatePlayableItem(PlayableItemEntity playableItemEntity) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        this.playableItemDAO.update(playableItemEntity);
    }

    public final void updatePlayableItems(PlayableItemEntity... playableItemEntities) {
        Intrinsics.checkNotNullParameter(playableItemEntities, "playableItemEntities");
        this.playableItemDAO.updateAll((PlayableItemEntity[]) Arrays.copyOf(playableItemEntities, playableItemEntities.length));
    }

    public final void removePlayableItem(PlayableItemEntity playableItemEntity) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        deletePlayableItemEntityPreviewMediaAndRelations(playableItemEntity);
        deleteAllEventsByPlayableItemId(playableItemEntity.getId());
        this.playableItemToGenrePairDAO.deleteByPlayableItemId(playableItemEntity.getId());
        updatePlayableItemWithMergedInfo(playableItemEntity);
        if (playableItemEntity.getMergedInfo().getMergedDisjointSetPrimaryPlayableItemIds().size() > 1) {
            List<Long> mergedDisjointSetPrimaryPlayableItemIds = playableItemEntity.getMergedInfo().getMergedDisjointSetPrimaryPlayableItemIds();
            mergedDisjointSetPrimaryPlayableItemIds.remove(Long.valueOf(playableItemEntity.getId()));
            long id2 = playableItemEntity.getId();
            Long disjointSetPrimaryPlayableItemId = playableItemEntity.getDisjointSetPrimaryPlayableItemId();
            Long disjointSetPrimaryPlayableItemId2 = (disjointSetPrimaryPlayableItemId != null && id2 == disjointSetPrimaryPlayableItemId.longValue()) ? mergedDisjointSetPrimaryPlayableItemIds.get(0) : playableItemEntity.getDisjointSetPrimaryPlayableItemId();
            PlayableItemDAO playableItemDAO = this.playableItemDAO;
            Long disjointSetPrimaryPlayableItemId3 = playableItemEntity.getDisjointSetPrimaryPlayableItemId();
            List<PlayableItemEntity> listSelectByDisjointSetPrimaryPlayableItemIdStatically = playableItemDAO.selectByDisjointSetPrimaryPlayableItemIdStatically(disjointSetPrimaryPlayableItemId3 != null ? disjointSetPrimaryPlayableItemId3.longValue() : playableItemEntity.getId());
            for (PlayableItemEntity playableItemEntity2 : listSelectByDisjointSetPrimaryPlayableItemIdStatically) {
                playableItemEntity2.setDisjointSetPrimaryPlayableItemId(disjointSetPrimaryPlayableItemId2);
                playableItemEntity2.setInSingletonDisjointSet(mergedDisjointSetPrimaryPlayableItemIds.size() == 1);
            }
            PlayableItemDAO playableItemDAO2 = this.playableItemDAO;
            PlayableItemEntity[] playableItemEntityArr = (PlayableItemEntity[]) listSelectByDisjointSetPrimaryPlayableItemIdStatically.toArray(new PlayableItemEntity[0]);
            playableItemDAO2.updateAll((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr, playableItemEntityArr.length));
        }
        this.playableItemDAO.delete(playableItemEntity);
    }

    public final void removeAllPlayableItemsPreviewMediaAndRelations() {
        Iterator it = this.playableItemDAO.selectAllStatically().iterator();
        while (it.hasNext()) {
            deletePlayableItemEntityPreviewMediaAndRelations((PlayableItemEntity) it.next());
        }
        File file = new File(this.defaultSharedPreferences.getString("preview_media_path", this.application.getApplicationContext().getFilesDir() + "/preview_media/"));
        if (file.exists()) {
            FilesKt.deleteRecursively(file);
        }
        this.retroAchievementsCachedPlayableItemIdToGameIdSurjectionDAO.nukeTable();
        this.playableItemDAO.updatePreviewMediaPathAll(null);
    }

    public final void disableAllPlayableItemsCustomPlayer() {
        this.playableItemDAO.updateUseCustomPlayerAll(false);
    }

    public final int clearAllDisjointedPlayableItems() throws FileNotFoundException {
        List<Long> allPlayableItemIdsStatically = getAllPlayableItemIdsStatically();
        HashMap map = new HashMap();
        Iterator it = allPlayableItemIdsStatically.iterator();
        int i = 0;
        while (it.hasNext()) {
            PlayableItemEntity playableItemByIdStatically = getPlayableItemByIdStatically(((Number) it.next()).longValue());
            if (playableItemByIdStatically != null && playableItemByIdStatically.getPlayableItemType() == 1) {
                if (!Intrinsics.areEqual(playableItemByIdStatically.getUri(), Uri.EMPTY) && !Intrinsics.areEqual(playableItemByIdStatically.getSyncTreeUri(), Uri.EMPTY)) {
                    try {
                        DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(this.application.getApplicationContext(), playableItemByIdStatically.getUri());
                        if (documentFileFromSingleUri != null && documentFileFromSingleUri.exists()) {
                            if (map.get(playableItemByIdStatically.getUri()) == null) {
                                map.put(playableItemByIdStatically.getUri(), CollectionsKt.mutableListOf(Long.valueOf(playableItemByIdStatically.getId())));
                            } else {
                                Object obj = map.get(playableItemByIdStatically.getUri());
                                Intrinsics.checkNotNull(obj);
                                ((List) obj).add(Long.valueOf(playableItemByIdStatically.getId()));
                            }
                        }
                    } catch (Exception e) {
                        this.logger.warn(this, ExceptionsKt.stackTraceToString(e));
                    }
                }
                removePlayableItem(playableItemByIdStatically);
                i++;
            }
        }
        for (Map.Entry entry : ((java.util.Set<Map.Entry>) map.entrySet())) {
            Uri uri = (Uri) entry.getKey();
            List list = (List) entry.getValue();
            if (list.size() > 1) {
                LazyMd5 lazyMd5 = LazyMd5.INSTANCE;
                InputStream inputStreamOpenInputStream = this.application.getContentResolver().openInputStream(uri);
                Intrinsics.checkNotNull(inputStreamOpenInputStream);
                String strMd5Hex = lazyMd5.md5Hex(inputStreamOpenInputStream);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    PlayableItemEntity playableItemByIdStatically2 = getPlayableItemByIdStatically(((Number) it2.next()).longValue());
                    if (playableItemByIdStatically2 != null && !Intrinsics.areEqual(playableItemByIdStatically2.getMd5(), strMd5Hex)) {
                        removePlayableItem(playableItemByIdStatically2);
                        i++;
                    }
                }
            }
        }
        return i;
    }

    public final int clearAllDisjointedPlayableItemsByAttachedPlatformId(long id2) throws FileNotFoundException {
        List<Long> playableItemIdsByAttachedPlatformIdStatically = getPlayableItemIdsByAttachedPlatformIdStatically(id2);
        HashMap map = new HashMap();
        Iterator it = playableItemIdsByAttachedPlatformIdStatically.iterator();
        int i = 0;
        while (it.hasNext()) {
            PlayableItemEntity playableItemByIdStatically = getPlayableItemByIdStatically(((Number) it.next()).longValue());
            if (playableItemByIdStatically != null && playableItemByIdStatically.getPlayableItemType() == 1) {
                if (!Intrinsics.areEqual(playableItemByIdStatically.getUri(), Uri.EMPTY) && !Intrinsics.areEqual(playableItemByIdStatically.getSyncTreeUri(), Uri.EMPTY)) {
                    try {
                        DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(this.application.getApplicationContext(), playableItemByIdStatically.getUri());
                        if (documentFileFromSingleUri != null && documentFileFromSingleUri.exists()) {
                            if (map.get(playableItemByIdStatically.getUri()) == null) {
                                map.put(playableItemByIdStatically.getUri(), CollectionsKt.mutableListOf(Long.valueOf(playableItemByIdStatically.getId())));
                            } else {
                                Object obj = map.get(playableItemByIdStatically.getUri());
                                Intrinsics.checkNotNull(obj);
                                ((List) obj).add(Long.valueOf(playableItemByIdStatically.getId()));
                            }
                        }
                    } catch (Exception e) {
                        this.logger.warn(this, ExceptionsKt.stackTraceToString(e));
                    }
                }
                removePlayableItem(playableItemByIdStatically);
                i++;
            }
        }
        for (Map.Entry entry : ((java.util.Set<Map.Entry>) map.entrySet())) {
            Uri uri = (Uri) entry.getKey();
            List list = (List) entry.getValue();
            if (list.size() > 1) {
                LazyMd5 lazyMd5 = LazyMd5.INSTANCE;
                InputStream inputStreamOpenInputStream = this.application.getContentResolver().openInputStream(uri);
                Intrinsics.checkNotNull(inputStreamOpenInputStream);
                String strMd5Hex = lazyMd5.md5Hex(inputStreamOpenInputStream);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    PlayableItemEntity playableItemByIdStatically2 = getPlayableItemByIdStatically(((Number) it2.next()).longValue());
                    if (playableItemByIdStatically2 != null && !Intrinsics.areEqual(playableItemByIdStatically2.getMd5(), strMd5Hex)) {
                        removePlayableItem(playableItemByIdStatically2);
                        i++;
                    }
                }
            }
        }
        return i;
    }

    public final LiveData<Integer> countAllPlayableItems() {
        return this.playableItemDAO.countAll();
    }

    public final int countAllPlayableItemsStatically() {
        return this.playableItemDAO.countAllStatically();
    }

    public static /* synthetic */ LiveData countAllPlayableItemsByVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countAllPlayableItemsByVisibility(z);
    }

    public final LiveData<Integer> countAllPlayableItemsByVisibility(boolean visibility) {
        return this.playableItemDAO.countAllByVisibility(visibility);
    }

    public static /* synthetic */ int countAllPlayableItemsByVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countAllPlayableItemsByVisibilityStatically(z);
    }

    public final int countAllPlayableItemsByVisibilityStatically(boolean visibility) {
        return this.playableItemDAO.countAllByVisibilityStatically(visibility);
    }

    public final LiveData<Long> countPlayableItemsByAttachedPlatformId(long id2) {
        return this.playableItemDAO.countByAttachedPlatformId(id2);
    }

    public static /* synthetic */ LiveData countPlayableItemsByAttachedPlatformIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countPlayableItemsByAttachedPlatformIdAndVisibility(j, z);
    }

    public final LiveData<Long> countPlayableItemsByAttachedPlatformIdAndVisibility(long id2, boolean visibility) {
        return this.playableItemDAO.countByAttachedPlatformIdAndVisibility(id2, visibility);
    }

    public final long countPlayableItemsByAttachedPlatformIdStatically(long id2) {
        return this.playableItemDAO.countByAttachedPlatformIdStatically(id2);
    }

    public static /* synthetic */ long countPlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countPlayableItemsByAttachedPlatformIdAndVisibilityStatically(j, z);
    }

    public final long countPlayableItemsByAttachedPlatformIdAndVisibilityStatically(long id2, boolean visibility) {
        return this.playableItemDAO.countByAttachedPlatformIdAndVisibilityStatically(id2, visibility);
    }

    public final LiveData<Long> countFavoritePlayableItemsByAttachedPlatformId(long id2) {
        return this.playableItemDAO.countFavoriteByAttachedPlatformId(id2);
    }

    public static /* synthetic */ LiveData countFavoritePlayableItemsByAttachedPlatformIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countFavoritePlayableItemsByAttachedPlatformIdAndVisibility(j, z);
    }

    public final LiveData<Long> countFavoritePlayableItemsByAttachedPlatformIdAndVisibility(long id2, boolean visibility) {
        return this.playableItemDAO.countFavoriteByAttachedPlatformIdAndVisibility(id2, visibility);
    }

    public final long countFavoritePlayableItemsByAttachedPlatformIdStatically(long id2) {
        return this.playableItemDAO.countFavoriteByAttachedPlatformIdStatically(id2);
    }

    public static /* synthetic */ long countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityStatically(j, z);
    }

    public final long countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityStatically(long id2, boolean visibility) {
        return this.playableItemDAO.countFavoriteByAttachedPlatformIdAndVisibilityStatically(id2, visibility);
    }

    public final LiveData<Long> countRecentPlayableItemsByAttachedPlatformId(long id2, Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.playableItemDAO.countRecentByAttachedPlatformId(id2, date);
    }

    public static /* synthetic */ LiveData countRecentPlayableItemsByAttachedPlatformIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Date date, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countRecentPlayableItemsByAttachedPlatformIdAndVisibility(j, date, z);
    }

    public final LiveData<Long> countRecentPlayableItemsByAttachedPlatformIdAndVisibility(long id2, Date date, boolean visibility) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.playableItemDAO.countRecentByAttachedPlatformIdAndVisibility(id2, date, visibility);
    }

    public final long countRecentPlayableItemsByAttachedPlatformIdStatically(long id2, Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.playableItemDAO.countRecentByAttachedPlatformIdStatically(id2, date);
    }

    public static /* synthetic */ long countRecentPlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Date date, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countRecentPlayableItemsByAttachedPlatformIdAndVisibilityStatically(j, date, z);
    }

    public final long countRecentPlayableItemsByAttachedPlatformIdAndVisibilityStatically(long id2, Date date, boolean visibility) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.playableItemDAO.countRecentByAttachedPlatformIdAndVisibilityStatically(id2, date, visibility);
    }

    public final LiveData<Long> countNewlyPlayableItemsByAttachedPlatformId(long id2, Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.playableItemDAO.countNewlyByAttachedPlatformId(id2, date);
    }

    public static /* synthetic */ LiveData countNewlyPlayableItemsByAttachedPlatformIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Date date, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countNewlyPlayableItemsByAttachedPlatformIdAndVisibility(j, date, z);
    }

    public final LiveData<Long> countNewlyPlayableItemsByAttachedPlatformIdAndVisibility(long id2, Date date, boolean visibility) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.playableItemDAO.countNewlyByAttachedPlatformIdAndVisibility(id2, date, visibility);
    }

    public final long countNewlyPlayableItemsByAttachedPlatformIdStatically(long id2, Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.playableItemDAO.countNewlyByAttachedPlatformIdStatically(id2, date);
    }

    public static /* synthetic */ long countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Date date, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityStatically(j, date, z);
    }

    public final long countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityStatically(long id2, Date date, boolean visibility) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.playableItemDAO.countNewlyByAttachedPlatformIdAndVisibilityStatically(id2, date, visibility);
    }

    public final LiveData<Integer> countAllPlayableItemsWithDisjointSetPrimaryPlayableItemId() {
        return this.playableItemDAO.countAllWithDisjointSetPrimaryPlayableItemId();
    }

    public final int countAllPlayableItemsWithDisjointSetPrimaryPlayableItemIdStatically() {
        return this.playableItemDAO.countAllWithDisjointSetPrimaryPlayableItemIdStatically();
    }

    public final LiveData<Long> countPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId(long id2) {
        return this.playableItemDAO.countByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId(id2);
    }

    public static /* synthetic */ LiveData countPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(j, z);
    }

    public final LiveData<Long> countPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(long id2, boolean visibility) {
        return this.playableItemDAO.countByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(id2, visibility);
    }

    public final long countPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(long id2) {
        return this.playableItemDAO.countByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(id2);
    }

    public static /* synthetic */ long countPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(j, z);
    }

    public final long countPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(long id2, boolean visibility) {
        return this.playableItemDAO.countByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(id2, visibility);
    }

    public final LiveData<Long> countFavoritePlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId(long id2) {
        return this.playableItemDAO.countFavoriteByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId(id2);
    }

    public static /* synthetic */ long countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(j, z);
    }

    public final long countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(long id2, boolean visibility) {
        return this.playableItemDAO.countFavoriteByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(id2, visibility);
    }

    public final long countFavoritePlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(long id2) {
        return this.playableItemDAO.countFavoriteByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(id2);
    }

    public static /* synthetic */ long countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(j, z);
    }

    public final long countFavoritePlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(long id2, boolean visibility) {
        return this.playableItemDAO.countFavoriteByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(id2, visibility);
    }

    public final LiveData<Long> countRecentPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId(long id2, Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.playableItemDAO.countRecentByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId(id2, date);
    }

    public static /* synthetic */ LiveData countRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Date date, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(j, date, z);
    }

    public final LiveData<Long> countRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(long id2, Date date, boolean visibility) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.playableItemDAO.countRecentByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(id2, date, visibility);
    }

    public final long countRecentPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(long id2, Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.playableItemDAO.countRecentByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(id2, date);
    }

    public static /* synthetic */ long countRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Date date, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(j, date, z);
    }

    public final long countRecentPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(long id2, Date date, boolean visibility) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.playableItemDAO.countRecentByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(id2, date, visibility);
    }

    public final LiveData<Long> countNewlyPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId(long id2, Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.playableItemDAO.countNewlyByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemId(id2, date);
    }

    public static /* synthetic */ LiveData countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Date date, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(j, date, z);
    }

    public final LiveData<Long> countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(long id2, Date date, boolean visibility) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.playableItemDAO.countNewlyByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemId(id2, date, visibility);
    }

    public final long countNewlyPlayableItemsByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(long id2, Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.playableItemDAO.countNewlyByAttachedPlatformIdWithDisjointSetPrimaryPlayableItemIdStatically(id2, date);
    }

    public static /* synthetic */ long countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Date date, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(j, date, z);
    }

    public final long countNewlyPlayableItemsByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(long id2, Date date, boolean visibility) {
        Intrinsics.checkNotNullParameter(date, "date");
        return this.playableItemDAO.countNewlyByAttachedPlatformIdAndVisibilityWithDisjointSetPrimaryPlayableItemIdStatically(id2, date, visibility);
    }

    public final LiveData<List<Long>> getAllPlayableItemsIds() {
        return this.playableItemDAO.selectAllIds();
    }

    public static /* synthetic */ LiveData getAllPlayableItemsIdsByVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getAllPlayableItemsIdsByVisibility(z);
    }

    public final LiveData<List<Long>> getAllPlayableItemsIdsByVisibility(boolean visibility) {
        return this.playableItemDAO.selectAllIdsByVisibility(visibility);
    }

    public final List<Long> getAllPlayableItemIdsStatically() {
        return this.playableItemDAO.selectAllIdsStatically();
    }

    public static /* synthetic */ List getAllPlayableItemIdsByVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getAllPlayableItemIdsByVisibilityStatically(z);
    }

    public final List<Long> getAllPlayableItemIdsByVisibilityStatically(boolean visibility) {
        return this.playableItemDAO.selectAllIdsByVisibilityStatically(visibility);
    }

    /* WARN: Code duplicated, block: B:28:0x00a3  */
    /* WARN: Code duplicated, block: B:29:0x00a5  */
    /* WARN: Code duplicated, block: B:43:0x00ea  */
    /* WARN: Code duplicated, block: B:44:0x00ec  */
    /* WARN: Code duplicated, block: B:59:0x0132  */
    public final void updatePlayableItemWithMergedInfo(PlayableItemEntity playableItemEntity) {
        boolean defaultMergedIsFavorite;
        boolean defaultMergedIsFavorite2;
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        Long disjointSetPrimaryPlayableItemId = playableItemEntity.getDisjointSetPrimaryPlayableItemId();
        if (disjointSetPrimaryPlayableItemId == null || playableItemEntity.isInSingletonDisjointSet()) {
            updatePlayableItemWithMergedInfo$updateSingletonItem(playableItemEntity);
            return;
        }
        List<PlayableItemEntity> listSelectByDisjointSetPrimaryPlayableItemIdStatically = this.playableItemDAO.selectByDisjointSetPrimaryPlayableItemIdStatically(disjointSetPrimaryPlayableItemId.longValue());
        boolean defaultMergedIsFavorite3 = true;
        if (listSelectByDisjointSetPrimaryPlayableItemIdStatically.size() <= 1) {
            updatePlayableItemWithMergedInfo$updateSingletonItem(playableItemEntity);
            return;
        }
        List<PlayableItemEntity> list = listSelectByDisjointSetPrimaryPlayableItemIdStatically;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            playableItemEntity.getMergedInfo().getMergedDisjointSetPrimaryPlayableItemIds().add(Long.valueOf(((PlayableItemEntity) it.next()).getId()));
        }
        int playCount = 0;
        playableItemEntity.getMergedInfo().setMergedName(prettifyTitle$default(this, playableItemEntity.getName(), false, 2, null));
        PlayableItemEntityMergedInfo mergedInfo = playableItemEntity.getMergedInfo();
        boolean z = list instanceof Collection;
        if (!z || !list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((PlayableItemEntity) it2.next()).isFavorite() == playableItemEntity.getMergedInfo().getDefaultMergedIsFavorite()) {
                        defaultMergedIsFavorite = playableItemEntity.getMergedInfo().getDefaultMergedIsFavorite();
                    }
                } else if (playableItemEntity.getMergedInfo().getDefaultMergedIsFavorite()) {
                    defaultMergedIsFavorite = false;
                } else {
                    defaultMergedIsFavorite = true;
                }
            }
        } else if (playableItemEntity.getMergedInfo().getDefaultMergedIsFavorite()) {
            defaultMergedIsFavorite = true;
        } else {
            defaultMergedIsFavorite = false;
        }
        mergedInfo.setMergedIsFavorite(defaultMergedIsFavorite);
        PlayableItemEntityMergedInfo mergedInfo2 = playableItemEntity.getMergedInfo();
        if (!z || !list.isEmpty()) {
            Iterator it3 = list.iterator();
            while (true) {
                if (it3.hasNext()) {
                    if (((PlayableItemEntity) it3.next()).isVisible() == playableItemEntity.getMergedInfo().getDefaultMergedIsVisible()) {
                        defaultMergedIsFavorite2 = playableItemEntity.getMergedInfo().getDefaultMergedIsFavorite();
                    }
                } else if (playableItemEntity.getMergedInfo().getDefaultMergedIsFavorite()) {
                    defaultMergedIsFavorite2 = false;
                } else {
                    defaultMergedIsFavorite2 = true;
                }
            }
        } else if (playableItemEntity.getMergedInfo().getDefaultMergedIsFavorite()) {
            defaultMergedIsFavorite2 = true;
        } else {
            defaultMergedIsFavorite2 = false;
        }
        mergedInfo2.setMergedIsVisible(defaultMergedIsFavorite2);
        PlayableItemEntityMergedInfo mergedInfo3 = playableItemEntity.getMergedInfo();
        if (!z || !list.isEmpty()) {
            Iterator it4 = list.iterator();
            while (true) {
                if (it4.hasNext()) {
                    if (((PlayableItemEntity) it4.next()).isSearchable() == playableItemEntity.getMergedInfo().getDefaultMergedIsSearchable()) {
                        defaultMergedIsFavorite3 = playableItemEntity.getMergedInfo().getDefaultMergedIsFavorite();
                    }
                } else if (playableItemEntity.getMergedInfo().getDefaultMergedIsFavorite()) {
                    defaultMergedIsFavorite3 = false;
                }
            }
        } else if (playableItemEntity.getMergedInfo().getDefaultMergedIsFavorite()) {
            defaultMergedIsFavorite3 = false;
        }
        mergedInfo3.setMergedIsSearchable(defaultMergedIsFavorite3);
        PlayableItemEntityMergedInfo mergedInfo4 = playableItemEntity.getMergedInfo();
        Iterator it5 = list.iterator();
        if (!it5.hasNext()) {
            throw new NoSuchElementException();
        }
        Date addedDateTimestamp = ((PlayableItemEntity) it5.next()).getAddedDateTimestamp();
        while (it5.hasNext()) {
            Date addedDateTimestamp2 = ((PlayableItemEntity) it5.next()).getAddedDateTimestamp();
            if (addedDateTimestamp.compareTo(addedDateTimestamp2) < 0) {
                addedDateTimestamp = addedDateTimestamp2;
            }
        }
        mergedInfo4.setMergedAddedDateTimestamp(addedDateTimestamp);
        for (PlayableItemEntity playableItemEntity2 : list) {
            if (playableItemEntity2.getLastPlayedTimestamp() != null) {
                Date lastPlayedTimestamp = playableItemEntity2.getLastPlayedTimestamp();
                Intrinsics.checkNotNull(lastPlayedTimestamp);
                if (playableItemEntity2.getMergedInfo().getMergedLastPlayedTimestamp() == null) {
                    playableItemEntity.getMergedInfo().setMergedLastPlayedTimestamp(lastPlayedTimestamp);
                } else if (lastPlayedTimestamp.compareTo(playableItemEntity2.getMergedInfo().getMergedLastPlayedTimestamp()) > 0) {
                    playableItemEntity.getMergedInfo().setMergedLastPlayedTimestamp(lastPlayedTimestamp);
                }
            }
        }
        PlayableItemEntityMergedInfo mergedInfo5 = playableItemEntity.getMergedInfo();
        Iterator it6 = list.iterator();
        while (it6.hasNext()) {
            playCount += ((PlayableItemEntity) it6.next()).getPlayCount();
        }
        mergedInfo5.setMergedPlayedCount(playCount);
    }

    private static final void updatePlayableItemWithMergedInfo$updateSingletonItem(PlayableItemEntity playableItemEntity) {
        playableItemEntity.getMergedInfo().getMergedDisjointSetPrimaryPlayableItemIds().add(Long.valueOf(playableItemEntity.getId()));
        playableItemEntity.getMergedInfo().setMergedName(playableItemEntity.getName());
        playableItemEntity.getMergedInfo().setMergedIsFavorite(playableItemEntity.isFavorite());
        playableItemEntity.getMergedInfo().setMergedIsVisible(playableItemEntity.isVisible());
        playableItemEntity.getMergedInfo().setMergedIsSearchable(playableItemEntity.isSearchable());
        playableItemEntity.getMergedInfo().setMergedAddedDateTimestamp(playableItemEntity.getAddedDateTimestamp());
        playableItemEntity.getMergedInfo().setMergedLastPlayedTimestamp(playableItemEntity.getLastPlayedTimestamp());
        playableItemEntity.getMergedInfo().setMergedPlayedCount(playableItemEntity.getPlayCount());
    }

    public final List<PlayableItemEntity> getMergedPlayableItems(PlayableItemEntity... playableItemEntities) {
        Long disjointSetPrimaryPlayableItemId;
        Intrinsics.checkNotNullParameter(playableItemEntities, "playableItemEntities");
        ArrayList arrayList = new ArrayList();
        for (PlayableItemEntity playableItemEntity : playableItemEntities) {
            if (!playableItemEntity.isInSingletonDisjointSet() && (disjointSetPrimaryPlayableItemId = playableItemEntity.getDisjointSetPrimaryPlayableItemId()) != null && !arrayList.contains(disjointSetPrimaryPlayableItemId)) {
                arrayList.add(disjointSetPrimaryPlayableItemId);
            }
        }
        ArrayList<PlayableItemEntityMergedInfo> arrayList2 = new ArrayList();
        int size = (arrayList.size() / 999) + 1;
        for (int i = 0; i < size; i++) {
            int i2 = 999 * i;
            List listSubList = arrayList.subList(i2, Math.min(i2 + 999, arrayList.size()));
            PlayableItemDAO playableItemDAO = this.playableItemDAO;
            long[] longArray = CollectionsKt.toLongArray(listSubList);
            arrayList2.addAll(playableItemDAO.selectPlayableItemEntityMergedInfoByDisjointSetPrimaryPlayableItemIdsStatically(Arrays.copyOf(longArray, longArray.length)));
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (PlayableItemEntity playableItemEntity2 : playableItemEntities) {
            if (playableItemEntity2.getDisjointSetPrimaryPlayableItemId() == null || playableItemEntity2.isInSingletonDisjointSet()) {
                updatePlayableItemWithMergedInfo(playableItemEntity2);
                arrayList3.add(playableItemEntity2);
            } else if (!CollectionsKt.contains(arrayList4, playableItemEntity2.getDisjointSetPrimaryPlayableItemId())) {
                for (PlayableItemEntityMergedInfo playableItemEntityMergedInfo : arrayList2) {
                    if (Intrinsics.areEqual(playableItemEntity2.getDisjointSetPrimaryPlayableItemId(), playableItemEntityMergedInfo.getDisjointSetPrimaryPlayableItemId())) {
                        playableItemEntity2.setMergedInfo(playableItemEntityMergedInfo);
                        Long disjointSetPrimaryPlayableItemId2 = playableItemEntityMergedInfo.getDisjointSetPrimaryPlayableItemId();
                        Intrinsics.checkNotNull(disjointSetPrimaryPlayableItemId2);
                        arrayList4.add(disjointSetPrimaryPlayableItemId2);
                        arrayList3.add(playableItemEntity2);
                        break;
                    }
                }
            }
        }
        return arrayList3;
    }

    public final PlayableItemEntity getPlayableItemRandomly() {
        return this.playableItemDAO.selectRandomlyStatically();
    }

    public static /* synthetic */ PlayableItemEntity getPlayableItemRandomlyByVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemRandomlyByVisibility(z);
    }

    public final PlayableItemEntity getPlayableItemRandomlyByVisibility(boolean visibility) {
        return this.playableItemDAO.selectRandomlyByVisibilityStatically(visibility);
    }

    public final PlayableItemEntity getFavoritePlayableItemRandomly() {
        return this.playableItemDAO.selectFavoriteRandomlyStatically();
    }

    public static /* synthetic */ PlayableItemEntity getFavoritePlayableItemRandomlyByVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getFavoritePlayableItemRandomlyByVisibility(z);
    }

    public final PlayableItemEntity getFavoritePlayableItemRandomlyByVisibility(boolean visibility) {
        return this.playableItemDAO.selectFavoriteRandomlyByVisibilityStatically(visibility);
    }

    public final PlayableItemEntity getRecentPlayableItemRandomly(Date afterDate) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectRecentRandomlyStatically(afterDate);
    }

    public static /* synthetic */ PlayableItemEntity getRecentPlayableItemRandomlyByVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, Date date, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getRecentPlayableItemRandomlyByVisibility(date, z);
    }

    public final PlayableItemEntity getRecentPlayableItemRandomlyByVisibility(Date afterDate, boolean visibility) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectRecentRandomlyByVisibilityStatically(afterDate, visibility);
    }

    public final PlayableItemEntity getNewlyPlayableItemRandomly(Date afterDate) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectNewlyRandomlyStatically(afterDate);
    }

    public static /* synthetic */ PlayableItemEntity getNewlyPlayableItemRandomlyByVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, Date date, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getNewlyPlayableItemRandomlyByVisibility(date, z);
    }

    public final PlayableItemEntity getNewlyPlayableItemRandomlyByVisibility(Date afterDate, boolean visibility) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectNewlyRandomlyByVisibilityStatically(afterDate, visibility);
    }

    public final LiveData<PlayableItemEntity> getPlayableItemById(long id2) {
        return this.playableItemDAO.selectById(id2);
    }

    public static /* synthetic */ LiveData getPlayableItemByIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemByIdAndVisibility(j, z);
    }

    public final LiveData<PlayableItemEntity> getPlayableItemByIdAndVisibility(long id2, boolean visibility) {
        return this.playableItemDAO.selectByIdAndVisibility(id2, visibility);
    }

    public final PlayableItemEntity getPlayableItemByIdStatically(long id2) {
        return this.playableItemDAO.selectByIdStatically(id2);
    }

    public static /* synthetic */ PlayableItemEntity getPlayableItemByIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemByIdAndVisibilityStatically(j, z);
    }

    public final PlayableItemEntity getPlayableItemByIdAndVisibilityStatically(long id2, boolean visibility) {
        return this.playableItemDAO.selectByIdAndVisibilityStatically(id2, visibility);
    }

    public final List<PlayableItemEntity> getPlayableItemsByIdsStatically(long... ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.playableItemDAO.selectByIdsStatically(Arrays.copyOf(ids, ids.length));
    }

    public final LiveData<PlayableItemEntity> getPlayableItemRandomlyByAttachedPlatformId(long id2) {
        return this.playableItemDAO.selectRandomlyByAttachedPlatformId(id2);
    }

    public static /* synthetic */ LiveData getPlayableItemRandomlyByAttachedPlatformIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemRandomlyByAttachedPlatformIdAndVisibility(j, z);
    }

    public final LiveData<PlayableItemEntity> getPlayableItemRandomlyByAttachedPlatformIdAndVisibility(long id2, boolean visibility) {
        return this.playableItemDAO.selectRandomlyByAttachedPlatformIdAndVisibility(id2, visibility);
    }

    public final PlayableItemEntity getPlayableItemRandomlyByAttachedPlatformIdStatically(long id2) {
        return this.playableItemDAO.selectRandomlyByAttachedPlatformIdStatically(id2);
    }

    public static /* synthetic */ PlayableItemEntity getPlayableItemRandomlyByAttachedPlatformIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemRandomlyByAttachedPlatformIdAndVisibilityStatically(j, z);
    }

    public final PlayableItemEntity getPlayableItemRandomlyByAttachedPlatformIdAndVisibilityStatically(long id2, boolean visibility) {
        return this.playableItemDAO.selectRandomlyByAttachedPlatformIdAndVisibilityStatically(id2, visibility);
    }

    public final LiveData<List<PlayableItemEntity>> getPlayableItemsByDisjointSetPrimaryPlayableItemId(long id2) {
        return this.playableItemDAO.selectByDisjointSetPrimaryPlayableItemId(id2);
    }

    public static /* synthetic */ LiveData getPlayableItemsByDisjointSetPrimaryPlayableItemIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemsByDisjointSetPrimaryPlayableItemIdAndVisibility(j, z);
    }

    public final LiveData<List<PlayableItemEntity>> getPlayableItemsByDisjointSetPrimaryPlayableItemIdAndVisibility(long id2, boolean visibility) {
        return this.playableItemDAO.selectByDisjointSetPrimaryPlayableItemIdAndVisibility(id2, visibility);
    }

    public final List<PlayableItemEntity> getPlayableItemsByDisjointSetPrimaryPlayableItemIdStatically(long id2) {
        return this.playableItemDAO.selectByDisjointSetPrimaryPlayableItemIdStatically(id2);
    }

    public static /* synthetic */ List getPlayableItemsByDisjointSetPrimaryPlayableItemIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemsByDisjointSetPrimaryPlayableItemIdAndVisibilityStatically(j, z);
    }

    public final List<PlayableItemEntity> getPlayableItemsByDisjointSetPrimaryPlayableItemIdAndVisibilityStatically(long id2, boolean visibility) {
        return this.playableItemDAO.selectByDisjointSetPrimaryPlayableItemIdAndVisibilityStatically(id2, visibility);
    }

    public final LiveData<List<PlayableItemEntity>> getPlayableItemsByAttachedPlatformId(long id2) {
        return this.playableItemDAO.selectByAttachedPlatformId(id2);
    }

    public static /* synthetic */ LiveData getPlayableItemsByAttachedPlatformIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemsByAttachedPlatformIdAndVisibility(j, z);
    }

    public final LiveData<List<PlayableItemEntity>> getPlayableItemsByAttachedPlatformIdAndVisibility(long id2, boolean visibility) {
        return this.playableItemDAO.selectByAttachedPlatformIdAndVisibility(id2, visibility);
    }

    public final List<PlayableItemEntity> getPlayableItemsByAttachedPlatformIdStatically(long id2) {
        return this.playableItemDAO.selectByAttachedPlatformIdStatically(id2);
    }

    public static /* synthetic */ List getPlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemsByAttachedPlatformIdAndVisibilityStatically(j, z);
    }

    public final List<PlayableItemEntity> getPlayableItemsByAttachedPlatformIdAndVisibilityStatically(long id2, boolean visibility) {
        return this.playableItemDAO.selectByAttachedPlatformIdAndVisibilityStatically(id2, visibility);
    }

    public final LiveData<List<Long>> getPlayableItemIdsByAttachedPlatformId(long id2) {
        return this.playableItemDAO.selectIdsByAttachedPlatformId(id2);
    }

    public static /* synthetic */ LiveData getPlayableItemIdsByAttachedPlatformIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemIdsByAttachedPlatformIdAndVisibility(j, z);
    }

    public final LiveData<List<Long>> getPlayableItemIdsByAttachedPlatformIdAndVisibility(long id2, boolean visibility) {
        return this.playableItemDAO.selectIdsByAttachedPlatformIdAndVisibility(id2, visibility);
    }

    public final List<Long> getPlayableItemIdsByAttachedPlatformIdStatically(long id2) {
        return this.playableItemDAO.selectIdsByAttachedPlatformIdStatically(id2);
    }

    public static /* synthetic */ List getPlayableItemIdsByAttachedPlatformIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemIdsByAttachedPlatformIdAndVisibilityStatically(j, z);
    }

    public final List<Long> getPlayableItemIdsByAttachedPlatformIdAndVisibilityStatically(long id2, boolean visibility) {
        return this.playableItemDAO.selectIdsByAttachedPlatformIdAndVisibilityStatically(id2, visibility);
    }

    public final LiveData<List<PlayableItemEntity>> getPlayableItemsByMd5List(String... md5List) {
        Intrinsics.checkNotNullParameter(md5List, "md5List");
        return this.playableItemDAO.selectByMd5List((String[]) Arrays.copyOf(md5List, md5List.length));
    }

    public static /* synthetic */ LiveData getPlayableItemsByMd5ListAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, String[] strArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemsByMd5ListAndVisibility(strArr, z);
    }

    public final LiveData<List<PlayableItemEntity>> getPlayableItemsByMd5ListAndVisibility(String[] md5List, boolean visibility) {
        Intrinsics.checkNotNullParameter(md5List, "md5List");
        return this.playableItemDAO.selectByMd5ListAndVisibility((String[]) Arrays.copyOf(md5List, md5List.length), visibility);
    }

    public final List<PlayableItemEntity> getPlayableItemsByMd5ListStatically(String... md5List) {
        Intrinsics.checkNotNullParameter(md5List, "md5List");
        return this.playableItemDAO.selectByMd5ListStatically((String[]) Arrays.copyOf(md5List, md5List.length));
    }

    public static /* synthetic */ List getPlayableItemsByMd5ListAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, String[] strArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemsByMd5ListAndVisibilityStatically(strArr, z);
    }

    public final List<PlayableItemEntity> getPlayableItemsByMd5ListAndVisibilityStatically(String[] md5List, boolean visibility) {
        Intrinsics.checkNotNullParameter(md5List, "md5List");
        return this.playableItemDAO.selectByMd5ListAndVisibilityStatically((String[]) Arrays.copyOf(md5List, md5List.length), visibility);
    }

    public final LiveData<List<PlayableItemEntity>> getPlayableItemsByAttachedPlatformIdAndSyncTreeUri(long id2, Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return this.playableItemDAO.selectByAttachedPlatformIdAndSyncTreeUri(id2, uri);
    }

    public static /* synthetic */ LiveData getPlayableItemsByAttachedPlatformIdAndSyncTreeUriAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Uri uri, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemsByAttachedPlatformIdAndSyncTreeUriAndVisibility(j, uri, z);
    }

    public final LiveData<List<PlayableItemEntity>> getPlayableItemsByAttachedPlatformIdAndSyncTreeUriAndVisibility(long id2, Uri uri, boolean visibility) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return this.playableItemDAO.selectByAttachedPlatformIdAndSyncTreeUriAndVisibility(id2, uri, visibility);
    }

    public final List<PlayableItemEntity> getPlayableItemsByAttachedPlatformIdAndSyncTreeUriStatically(long id2, Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return this.playableItemDAO.selectByAttachedPlatformIdAndSyncTreeUriStatically(id2, uri);
    }

    public static /* synthetic */ List getPlayableItemsByAttachedPlatformIdAndSyncTreeUriAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Uri uri, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemsByAttachedPlatformIdAndSyncTreeUriAndVisibilityStatically(j, uri, z);
    }

    public final List<PlayableItemEntity> getPlayableItemsByAttachedPlatformIdAndSyncTreeUriAndVisibilityStatically(long id2, Uri uri, boolean visibility) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return this.playableItemDAO.selectByAttachedPlatformIdAndSyncTreeUriAndVisibilityStatically(id2, uri, visibility);
    }

    public static /* synthetic */ LiveData getRecentPlayableItemsByAttachedPlatformId$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Date date, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.getRecentPlayableItemsByAttachedPlatformId(j, date, i);
    }

    public final LiveData<List<PlayableItemEntity>> getRecentPlayableItemsByAttachedPlatformId(long id2, Date afterDate, int limit) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectRecentByAttachedPlatformId(id2, afterDate, limit);
    }

    public static /* synthetic */ LiveData getRecentPlayableItemsByAttachedPlatformIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Date date, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getRecentPlayableItemsByAttachedPlatformIdAndVisibility(j, date, i3, z);
    }

    public final LiveData<List<PlayableItemEntity>> getRecentPlayableItemsByAttachedPlatformIdAndVisibility(long id2, Date afterDate, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectRecentByAttachedPlatformIdAndVisibility(id2, afterDate, limit, visibility);
    }

    public static /* synthetic */ List getRecentPlayableItemsByAttachedPlatformIdStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Date date, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.getRecentPlayableItemsByAttachedPlatformIdStatically(j, date, i);
    }

    public final List<PlayableItemEntity> getRecentPlayableItemsByAttachedPlatformIdStatically(long id2, Date afterDate, int limit) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectRecentByAttachedPlatformIdStatically(id2, afterDate, limit);
    }

    public static /* synthetic */ List getRecentPlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Date date, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getRecentPlayableItemsByAttachedPlatformIdAndVisibilityStatically(j, date, i3, z);
    }

    public final List<PlayableItemEntity> getRecentPlayableItemsByAttachedPlatformIdAndVisibilityStatically(long id2, Date afterDate, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectRecentByAttachedPlatformIdAndVisibilityStatically(id2, afterDate, limit, visibility);
    }

    public static /* synthetic */ LiveData getFavoritePlayableItemsByAttachedPlatformId$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.getFavoritePlayableItemsByAttachedPlatformId(j, i);
    }

    public final LiveData<List<PlayableItemEntity>> getFavoritePlayableItemsByAttachedPlatformId(long id2, int limit) {
        return this.playableItemDAO.selectFavoriteByAttachedPlatformId(id2, limit);
    }

    public static /* synthetic */ LiveData getFavoritePlayableItemsByAttachedPlatformIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getFavoritePlayableItemsByAttachedPlatformIdAndVisibility(j, i, z);
    }

    public final LiveData<List<PlayableItemEntity>> getFavoritePlayableItemsByAttachedPlatformIdAndVisibility(long id2, int limit, boolean visibility) {
        return this.playableItemDAO.selectFavoriteByAttachedPlatformIdAndVisibility(id2, limit, visibility);
    }

    public static /* synthetic */ List getFavoritePlayableItemsByAttachedPlatformIdStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.getFavoritePlayableItemsByAttachedPlatformIdStatically(j, i);
    }

    public final List<PlayableItemEntity> getFavoritePlayableItemsByAttachedPlatformIdStatically(long id2, int limit) {
        return this.playableItemDAO.selectFavoriteByAttachedPlatformIdStatically(id2, limit);
    }

    public static /* synthetic */ List getFavoritePlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getFavoritePlayableItemsByAttachedPlatformIdAndVisibilityStatically(j, i, z);
    }

    public final List<PlayableItemEntity> getFavoritePlayableItemsByAttachedPlatformIdAndVisibilityStatically(long id2, int limit, boolean visibility) {
        return this.playableItemDAO.selectFavoriteByAttachedPlatformIdAndVisibilityStatically(id2, limit, visibility);
    }

    public static /* synthetic */ LiveData getNewlyPlayableItemsByAttachedPlatformId$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Date date, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.getNewlyPlayableItemsByAttachedPlatformId(j, date, i);
    }

    public final LiveData<List<PlayableItemEntity>> getNewlyPlayableItemsByAttachedPlatformId(long id2, Date afterDate, int limit) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectNewlyByAttachedPlatformId(id2, afterDate, limit);
    }

    public static /* synthetic */ LiveData getNewlyPlayableItemsByAttachedPlatformIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Date date, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getNewlyPlayableItemsByAttachedPlatformIdAndVisibility(j, date, i3, z);
    }

    public final LiveData<List<PlayableItemEntity>> getNewlyPlayableItemsByAttachedPlatformIdAndVisibility(long id2, Date afterDate, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectNewlyByAttachedPlatformIdAndVisibility(id2, afterDate, limit, visibility);
    }

    public static /* synthetic */ List getNewlyPlayableItemsByAttachedPlatformIdStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Date date, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.getNewlyPlayableItemsByAttachedPlatformIdStatically(j, date, i);
    }

    public final List<PlayableItemEntity> getNewlyPlayableItemsByAttachedPlatformIdStatically(long id2, Date afterDate, int limit) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectNewlyByAttachedPlatformIdStatically(id2, afterDate, limit);
    }

    public static /* synthetic */ List getNewlyPlayableItemsByAttachedPlatformIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, long j, Date date, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getNewlyPlayableItemsByAttachedPlatformIdAndVisibilityStatically(j, date, i3, z);
    }

    public final List<PlayableItemEntity> getNewlyPlayableItemsByAttachedPlatformIdAndVisibilityStatically(long id2, Date afterDate, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectNewlyByAttachedPlatformIdAndVisibilityStatically(id2, afterDate, limit, visibility);
    }

    public static /* synthetic */ LiveData getPlayableItemsByGenreId$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.getPlayableItemsByGenreId(str, i);
    }

    public final LiveData<List<PlayableItemEntity>> getPlayableItemsByGenreId(String id2, int limit) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.playableItemDAO.selectByGenreId(id2, limit);
    }

    public static /* synthetic */ LiveData getPlayableItemsByGenreIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemsByGenreIdAndVisibility(str, i, z);
    }

    public final LiveData<List<PlayableItemEntity>> getPlayableItemsByGenreIdAndVisibility(String id2, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.playableItemDAO.selectByGenreIdAndVisibility(id2, limit, visibility);
    }

    public static /* synthetic */ List getPlayableItemsByGenreIdStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.getPlayableItemsByGenreIdStatically(str, i);
    }

    public final List<PlayableItemEntity> getPlayableItemsByGenreIdStatically(String id2, int limit) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.playableItemDAO.selectByGenreIdStatically(id2, limit);
    }

    public static /* synthetic */ List getPlayableItemsByGenreIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getPlayableItemsByGenreIdAndVisibilityStatically(str, i, z);
    }

    public final List<PlayableItemEntity> getPlayableItemsByGenreIdAndVisibilityStatically(String id2, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.playableItemDAO.selectByGenreIdAndVisibilityStatically(id2, limit, visibility);
    }

    public static /* synthetic */ LiveData getRecentPlayableItemsByGenreId$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, Date date, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.getRecentPlayableItemsByGenreId(str, date, i);
    }

    public final LiveData<List<PlayableItemEntity>> getRecentPlayableItemsByGenreId(String id2, Date afterDate, int limit) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectRecentByGenreId(id2, afterDate, limit);
    }

    public static /* synthetic */ LiveData getRecentPlayableItemsByGenreIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, Date date, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getRecentPlayableItemsByGenreIdAndVisibility(str, date, i, z);
    }

    public final LiveData<List<PlayableItemEntity>> getRecentPlayableItemsByGenreIdAndVisibility(String id2, Date afterDate, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectRecentByGenreIdAndVisibility(id2, afterDate, limit, visibility);
    }

    public static /* synthetic */ List getRecentPlayableItemsByGenreIdStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, Date date, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.getRecentPlayableItemsByGenreIdStatically(str, date, i);
    }

    public final List<PlayableItemEntity> getRecentPlayableItemsByGenreIdStatically(String id2, Date afterDate, int limit) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectRecentByGenreIdStatically(id2, afterDate, limit);
    }

    public static /* synthetic */ List getRecentPlayableItemsByGenreIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, Date date, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getRecentPlayableItemsByGenreIdAndVisibilityStatically(str, date, i, z);
    }

    public final List<PlayableItemEntity> getRecentPlayableItemsByGenreIdAndVisibilityStatically(String id2, Date afterDate, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectRecentByGenreIdAndVisibilityStatically(id2, afterDate, limit, visibility);
    }

    public static /* synthetic */ LiveData getFavoritePlayableItemsByGenreId$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.getFavoritePlayableItemsByGenreId(str, i);
    }

    public final LiveData<List<PlayableItemEntity>> getFavoritePlayableItemsByGenreId(String id2, int limit) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.playableItemDAO.selectFavoriteByGenreId(id2, limit);
    }

    public static /* synthetic */ LiveData getFavoritePlayableItemsByGenreIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getFavoritePlayableItemsByGenreIdAndVisibility(str, i, z);
    }

    public final LiveData<List<PlayableItemEntity>> getFavoritePlayableItemsByGenreIdAndVisibility(String id2, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.playableItemDAO.selectFavoriteByGenreIdAndVisibility(id2, limit, visibility);
    }

    public static /* synthetic */ List getFavoritePlayableItemsByGenreIdStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.getFavoritePlayableItemsByGenreIdStatically(str, i);
    }

    public final List<PlayableItemEntity> getFavoritePlayableItemsByGenreIdStatically(String id2, int limit) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.playableItemDAO.selectFavoriteByGenreIdStatically(id2, limit);
    }

    public static /* synthetic */ List getFavoritePlayableItemsByGenreIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getFavoritePlayableItemsByGenreIdAndVisibilityStatically(str, i, z);
    }

    public final List<PlayableItemEntity> getFavoritePlayableItemsByGenreIdAndVisibilityStatically(String id2, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(id2, "id");
        return this.playableItemDAO.selectFavoriteByGenreIdAndVisibilityStatically(id2, limit, visibility);
    }

    public static /* synthetic */ LiveData getNewlyPlayableItemsByGenreId$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, Date date, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.getNewlyPlayableItemsByGenreId(str, date, i);
    }

    public final LiveData<List<PlayableItemEntity>> getNewlyPlayableItemsByGenreId(String id2, Date afterDate, int limit) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectNewlyByGenreId(id2, afterDate, limit);
    }

    public static /* synthetic */ LiveData getNewlyPlayableItemsByGenreIdAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, Date date, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getNewlyPlayableItemsByGenreIdAndVisibility(str, date, i, z);
    }

    public final LiveData<List<PlayableItemEntity>> getNewlyPlayableItemsByGenreIdAndVisibility(String id2, Date afterDate, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectNewlyByGenreIdAndVisibility(id2, afterDate, limit, visibility);
    }

    public static /* synthetic */ List getNewlyPlayableItemsByGenreIdStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, Date date, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.getNewlyPlayableItemsByGenreIdStatically(str, date, i);
    }

    public final List<PlayableItemEntity> getNewlyPlayableItemsByGenreIdStatically(String id2, Date afterDate, int limit) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectNewlyByGenreIdStatically(id2, afterDate, limit);
    }

    public static /* synthetic */ List getNewlyPlayableItemsByGenreIdAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, Date date, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getNewlyPlayableItemsByGenreIdAndVisibilityStatically(str, date, i, z);
    }

    public final List<PlayableItemEntity> getNewlyPlayableItemsByGenreIdAndVisibilityStatically(String id2, Date afterDate, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectNewlyByGenreIdAndVisibilityStatically(id2, afterDate, limit, visibility);
    }

    public static /* synthetic */ LiveData getFavoriteRecentOrNewlyPlayableItems$default(DaijishouLibraryRepository daijishouLibraryRepository, Date date, Date date2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.getFavoriteRecentOrNewlyPlayableItems(date, date2, i);
    }

    public final LiveData<List<PlayableItemEntity>> getFavoriteRecentOrNewlyPlayableItems(Date afterDateRecent, Date afterDateNewly, int limit) {
        Intrinsics.checkNotNullParameter(afterDateRecent, "afterDateRecent");
        Intrinsics.checkNotNullParameter(afterDateNewly, "afterDateNewly");
        return this.playableItemDAO.selectFavoriteRecentOrNewly(afterDateRecent, afterDateRecent, limit);
    }

    public static /* synthetic */ LiveData getFavoriteRecentOrNewlyPlayableItemsByVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, Date date, Date date2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getFavoriteRecentOrNewlyPlayableItemsByVisibility(date, date2, i, z);
    }

    public final LiveData<List<PlayableItemEntity>> getFavoriteRecentOrNewlyPlayableItemsByVisibility(Date afterDateRecent, Date afterDateNewly, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(afterDateRecent, "afterDateRecent");
        Intrinsics.checkNotNullParameter(afterDateNewly, "afterDateNewly");
        return this.playableItemDAO.selectFavoriteRecentOrNewlyByVisibility(afterDateRecent, afterDateRecent, limit, visibility);
    }

    public static /* synthetic */ List getFavoriteRecentOrNewlyPlayableItemsStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, Date date, Date date2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.getFavoriteRecentOrNewlyPlayableItemsStatically(date, date2, i);
    }

    public final List<PlayableItemEntity> getFavoriteRecentOrNewlyPlayableItemsStatically(Date afterDateRecent, Date afterDateNewly, int limit) {
        Intrinsics.checkNotNullParameter(afterDateRecent, "afterDateRecent");
        Intrinsics.checkNotNullParameter(afterDateNewly, "afterDateNewly");
        return this.playableItemDAO.selectFavoriteRecentOrNewlyStatically(afterDateRecent, afterDateRecent, limit);
    }

    public static /* synthetic */ List getFavoriteRecentOrNewlyPlayableItemsByVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, Date date, Date date2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getFavoriteRecentOrNewlyPlayableItemsByVisibilityStatically(date, date2, i, z);
    }

    public final List<PlayableItemEntity> getFavoriteRecentOrNewlyPlayableItemsByVisibilityStatically(Date afterDateRecent, Date afterDateNewly, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(afterDateRecent, "afterDateRecent");
        Intrinsics.checkNotNullParameter(afterDateNewly, "afterDateNewly");
        return this.playableItemDAO.selectFavoriteRecentOrNewlyByVisibilityStatically(afterDateRecent, afterDateRecent, limit, visibility);
    }

    public final LiveData<PlayableItemEntity> getMostRecentPlayableItem() {
        return this.playableItemDAO.selectMostRecent();
    }

    public final PlayableItemEntity getMostRecentPlayableItemStatically() {
        return this.playableItemDAO.selectMostRecentStatically();
    }

    public static /* synthetic */ LiveData getRecentPlayableItems$default(DaijishouLibraryRepository daijishouLibraryRepository, Date date, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 256;
        }
        return daijishouLibraryRepository.getRecentPlayableItems(date, i);
    }

    public final LiveData<List<PlayableItemEntity>> getRecentPlayableItems(Date afterDate, int limit) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectRecent(afterDate, limit);
    }

    public static /* synthetic */ LiveData getRecentPlayableItemsByVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, Date date, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 256;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getRecentPlayableItemsByVisibility(date, i, z);
    }

    public final LiveData<List<PlayableItemEntity>> getRecentPlayableItemsByVisibility(Date afterDate, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectRecentByVisibility(afterDate, limit, visibility);
    }

    public static /* synthetic */ List getRecentPlayableItemsStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, Date date, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 256;
        }
        return daijishouLibraryRepository.getRecentPlayableItemsStatically(date, i);
    }

    public final List<PlayableItemEntity> getRecentPlayableItemsStatically(Date afterDate, int limit) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectRecentStatically(afterDate, limit);
    }

    public static /* synthetic */ List getRecentPlayableItemsByVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, Date date, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 256;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getRecentPlayableItemsByVisibilityStatically(date, i, z);
    }

    public final List<PlayableItemEntity> getRecentPlayableItemsByVisibilityStatically(Date afterDate, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectRecentByVisibilityStatically(afterDate, limit, visibility);
    }

    public static /* synthetic */ LiveData getFavoritePlayableItems$default(DaijishouLibraryRepository daijishouLibraryRepository, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 256;
        }
        return daijishouLibraryRepository.getFavoritePlayableItems(i);
    }

    public final LiveData<List<PlayableItemEntity>> getFavoritePlayableItems(int limit) {
        return this.playableItemDAO.selectFavorite(limit);
    }

    public static /* synthetic */ LiveData getFavoritePlayableItemsByVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 256;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getFavoritePlayableItemsByVisibility(i, z);
    }

    public final LiveData<List<PlayableItemEntity>> getFavoritePlayableItemsByVisibility(int limit, boolean visibility) {
        return this.playableItemDAO.selectFavoriteByVisibility(limit, visibility);
    }

    public static /* synthetic */ List getFavoritePlayableItemsStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 256;
        }
        return daijishouLibraryRepository.getFavoritePlayableItemsStatically(i);
    }

    public final List<PlayableItemEntity> getFavoritePlayableItemsStatically(int limit) {
        return this.playableItemDAO.selectFavoriteStatically(limit);
    }

    public static /* synthetic */ List getFavoritePlayableItemsByVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 256;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getFavoritePlayableItemsByVisibilityStatically(i, z);
    }

    public final List<PlayableItemEntity> getFavoritePlayableItemsByVisibilityStatically(int limit, boolean visibility) {
        return this.playableItemDAO.selectFavoriteByVisibilityStatically(limit, visibility);
    }

    public static /* synthetic */ LiveData getNewlyPlayableItems$default(DaijishouLibraryRepository daijishouLibraryRepository, Date date, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 256;
        }
        return daijishouLibraryRepository.getNewlyPlayableItems(date, i);
    }

    public final LiveData<List<PlayableItemEntity>> getNewlyPlayableItems(Date afterDate, int limit) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectNewly(afterDate, limit);
    }

    public static /* synthetic */ LiveData getNewlyPlayableItemsByVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, Date date, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 256;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getNewlyPlayableItemsByVisibility(date, i, z);
    }

    public final LiveData<List<PlayableItemEntity>> getNewlyPlayableItemsByVisibility(Date afterDate, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectNewlyByVisibility(afterDate, limit, visibility);
    }

    public static /* synthetic */ List getNewlyPlayableItemsStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, Date date, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 256;
        }
        return daijishouLibraryRepository.getNewlyPlayableItemsStatically(date, i);
    }

    public final List<PlayableItemEntity> getNewlyPlayableItemsStatically(Date afterDate, int limit) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectNewlyStatically(afterDate, limit);
    }

    public static /* synthetic */ List getNewlyPlayableItemsByVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, Date date, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 256;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.getNewlyPlayableItemsByVisibilityStatically(date, i, z);
    }

    public final List<PlayableItemEntity> getNewlyPlayableItemsByVisibilityStatically(Date afterDate, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(afterDate, "afterDate");
        return this.playableItemDAO.selectNewlyByVisibilityStatically(afterDate, limit, visibility);
    }

    public static /* synthetic */ List getSimilarPlayableItems$default(DaijishouLibraryRepository daijishouLibraryRepository, PlayableItemEntity playableItemEntity, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        return daijishouLibraryRepository.getSimilarPlayableItems(playableItemEntity, i, z, z2);
    }

    public final List<PlayableItemEntity> getSimilarPlayableItems(PlayableItemEntity playableItemEntity, int limit, boolean withVisibility, boolean visibility) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        return searchPlayableItemsByKeyword$default(this, playableItemEntity.getName(), limit, CollectionsKt.listOf(Long.valueOf(playableItemEntity.getId())), false, withVisibility, visibility, 8, null);
    }

    /* INFO: compiled from: DaijishouLibraryRepository.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006'"}, d2 = {"Lcom/magneticchen/daijishou/repositories/DaijishouLibraryRepository$PlayableItemEntityWithCount;", "", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "matchCount", "", "maxMatchCount", "ranking", "", "maxRanking", "(Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;IIFF)V", "getMatchCount", "()I", "setMatchCount", "(I)V", "getMaxMatchCount", "setMaxMatchCount", "getMaxRanking", "()F", "setMaxRanking", "(F)V", "getPlayableItemEntity", "()Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "setPlayableItemEntity", "(Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;)V", "getRanking", "setRanking", "component1", "component2", "component3", "component4", "component5", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PlayableItemEntityWithCount {
        private int matchCount;
        private int maxMatchCount;
        private float maxRanking;
        private PlayableItemEntity playableItemEntity;
        private float ranking;

        public static /* synthetic */ PlayableItemEntityWithCount copy$default(PlayableItemEntityWithCount playableItemEntityWithCount, PlayableItemEntity playableItemEntity, int i, int i2, float f, float f2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                playableItemEntity = playableItemEntityWithCount.playableItemEntity;
            }
            if ((i3 & 2) != 0) {
                i = playableItemEntityWithCount.matchCount;
            }
            if ((i3 & 4) != 0) {
                i2 = playableItemEntityWithCount.maxMatchCount;
            }
            if ((i3 & 8) != 0) {
                f = playableItemEntityWithCount.ranking;
            }
            if ((i3 & 16) != 0) {
                f2 = playableItemEntityWithCount.maxRanking;
            }
            float f3 = f2;
            int i4 = i2;
            return playableItemEntityWithCount.copy(playableItemEntity, i, i4, f, f3);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final PlayableItemEntity getPlayableItemEntity() {
            return this.playableItemEntity;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final int getMatchCount() {
            return this.matchCount;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final int getMaxMatchCount() {
            return this.maxMatchCount;
        }

        /* INFO: renamed from: component4, reason: from getter */
        public final float getRanking() {
            return this.ranking;
        }

        /* INFO: renamed from: component5, reason: from getter */
        public final float getMaxRanking() {
            return this.maxRanking;
        }

        public final PlayableItemEntityWithCount copy(PlayableItemEntity playableItemEntity, int matchCount, int maxMatchCount, float ranking, float maxRanking) {
            Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
            return new PlayableItemEntityWithCount(playableItemEntity, matchCount, maxMatchCount, ranking, maxRanking);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlayableItemEntityWithCount)) {
                return false;
            }
            PlayableItemEntityWithCount playableItemEntityWithCount = (PlayableItemEntityWithCount) other;
            return Intrinsics.areEqual(this.playableItemEntity, playableItemEntityWithCount.playableItemEntity) && this.matchCount == playableItemEntityWithCount.matchCount && this.maxMatchCount == playableItemEntityWithCount.maxMatchCount && Float.compare(this.ranking, playableItemEntityWithCount.ranking) == 0 && Float.compare(this.maxRanking, playableItemEntityWithCount.maxRanking) == 0;
        }

        public int hashCode() {
            return (((((((this.playableItemEntity.hashCode() * 31) + Integer.hashCode(this.matchCount)) * 31) + Integer.hashCode(this.maxMatchCount)) * 31) + Float.hashCode(this.ranking)) * 31) + Float.hashCode(this.maxRanking);
        }

        public String toString() {
            return "PlayableItemEntityWithCount(playableItemEntity=" + this.playableItemEntity + ", matchCount=" + this.matchCount + ", maxMatchCount=" + this.maxMatchCount + ", ranking=" + this.ranking + ", maxRanking=" + this.maxRanking + ")";
        }

        public PlayableItemEntityWithCount(PlayableItemEntity playableItemEntity, int i, int i2, float f, float f2) {
            Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
            this.playableItemEntity = playableItemEntity;
            this.matchCount = i;
            this.maxMatchCount = i2;
            this.ranking = f;
            this.maxRanking = f2;
        }

        public /* synthetic */ PlayableItemEntityWithCount(PlayableItemEntity playableItemEntity, int i, int i2, float f, float f2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(playableItemEntity, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? 0.0f : f, (i3 & 16) != 0 ? 0.0f : f2);
        }


        public final void setPlayableItemEntity(PlayableItemEntity playableItemEntity) {
            Intrinsics.checkNotNullParameter(playableItemEntity, "<set-?>");
            this.playableItemEntity = playableItemEntity;
        }


        public final void setMatchCount(int i) {
            this.matchCount = i;
        }


        public final void setMaxMatchCount(int i) {
            this.maxMatchCount = i;
        }


        public final void setRanking(float f) {
            this.ranking = f;
        }


        public final void setMaxRanking(float f) {
            this.maxRanking = f;
        }
    }

    /* WARN: Multi-variable type inference failed */
    public static /* synthetic */ List searchPlayableItemsByKeyword$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, List list, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            list = null;
        }
        List list2 = list;
        if ((i2 & 8) != 0) {
            z = false;
        }
        return daijishouLibraryRepository.searchPlayableItemsByKeyword(str, i3, list2, z, (i2 & 16) != 0 ? true : z2, (i2 & 32) != 0 ? true : z3);
    }

    /* WARN: Code duplicated, block: B:12:0x0073 A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:13:0x0075  */
    /* WARN: Code duplicated, block: B:14:0x0081  */
    /* WARN: Code duplicated, block: B:18:0x009c  */
    /* WARN: Code duplicated, block: B:22:0x00b3  */
    /* WARN: Code duplicated, block: B:24:0x00c3  */
    /* WARN: Code duplicated, block: B:25:0x00d5  */
    public final List<PlayableItemEntity> searchPlayableItemsByKeyword(String keyword, int limit, List<Long> excludedIdList, boolean ignoreTrivial, boolean withVisibility, boolean visibility) {
        List<PlayableItemEntity> listFindWithNameAndDescriptionStatically$default;
        float size;
        PlayableItemEntityWithCount playableItemEntityWithCount;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        HashMap map = new HashMap();
        int i = 2;
        List<String> listSplit = new Regex("\\s-\\s|[\\s|.]+").split(prettifyTitle$default(this, keyword, false, 2, null), 0);
        float f = 0.0f;
        for (String str : listSplit) {
            if (!ignoreTrivial) {
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
                    if (!trivialRegex.matches(lowerCase2)) {
                        if (withVisibility) {
                            listFindWithNameAndDescriptionStatically$default = PlayableItemDAO.DefaultImpls.findWithNameDescriptionAndVisibilityStatically$default(this.playableItemDAO, str, 0, visibility, 2, null);
                        } else {
                            listFindWithNameAndDescriptionStatically$default = PlayableItemDAO.DefaultImpls.findWithNameAndDescriptionStatically$default(this.playableItemDAO, str, 0, i, null);
                        }
                        size = 1.0f / listFindWithNameAndDescriptionStatically$default.size();
                        f += size;
                        for (PlayableItemEntity playableItemEntity : listFindWithNameAndDescriptionStatically$default) {
                            if (excludedIdList != null || excludedIdList.indexOf(Long.valueOf(playableItemEntity.getId())) < 0) {
                                playableItemEntityWithCount = (PlayableItemEntityWithCount) map.get(Long.valueOf(playableItemEntity.getId()));
                                if (playableItemEntityWithCount != null) {
                                    playableItemEntityWithCount.setMatchCount(playableItemEntityWithCount.getMatchCount() + 1);
                                    playableItemEntityWithCount.setRanking(playableItemEntityWithCount.getRanking() + size);
                                } else {
                                    map.put(Long.valueOf(playableItemEntity.getId()), new PlayableItemEntityWithCount(playableItemEntity, 1, listSplit.size(), 0.0f, 0.0f, 24, null));
                                }
                            }
                        }
                    }
                }
            } else {
                if (withVisibility) {
                    listFindWithNameAndDescriptionStatically$default = PlayableItemDAO.DefaultImpls.findWithNameDescriptionAndVisibilityStatically$default(this.playableItemDAO, str, 0, visibility, 2, null);
                } else {
                    listFindWithNameAndDescriptionStatically$default = PlayableItemDAO.DefaultImpls.findWithNameAndDescriptionStatically$default(this.playableItemDAO, str, 0, i, null);
                }
                size = 1.0f / listFindWithNameAndDescriptionStatically$default.size();
                f += size;
                for (PlayableItemEntity playableItemEntity : listFindWithNameAndDescriptionStatically$default) {
                    if (excludedIdList != null) {
                        playableItemEntityWithCount = (PlayableItemEntityWithCount) map.get(Long.valueOf(playableItemEntity.getId()));
                        if (playableItemEntityWithCount != null) {
                            playableItemEntityWithCount.setMatchCount(playableItemEntityWithCount.getMatchCount() + 1);
                            playableItemEntityWithCount.setRanking(playableItemEntityWithCount.getRanking() + size);
                        } else {
                            map.put(Long.valueOf(playableItemEntity.getId()), new PlayableItemEntityWithCount(playableItemEntity, 1, listSplit.size(), 0.0f, 0.0f, 24, null));
                        }
                    } else {
                        playableItemEntityWithCount = (PlayableItemEntityWithCount) map.get(Long.valueOf(playableItemEntity.getId()));
                        if (playableItemEntityWithCount != null) {
                            playableItemEntityWithCount.setMatchCount(playableItemEntityWithCount.getMatchCount() + 1);
                            playableItemEntityWithCount.setRanking(playableItemEntityWithCount.getRanking() + size);
                        } else {
                            map.put(Long.valueOf(playableItemEntity.getId()), new PlayableItemEntityWithCount(playableItemEntity, 1, listSplit.size(), 0.0f, 0.0f, 24, null));
                        }
                    }
                }
            }
            i = 2;
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            ((PlayableItemEntityWithCount) ((Map.Entry) it.next()).getValue()).setMaxRanking(f);
        }
        Collection collectionValues = map.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        List listSortedWith = CollectionsKt.sortedWith(CollectionsKt.sortedWith(CollectionsKt.sortedWith(collectionValues, new DaijishouLibraryRepository$searchPlayableItemsByKeyword$$inlined$sortedBy$1()), new DaijishouLibraryRepository$searchPlayableItemsByKeyword$$inlined$sortedByDescending$1()), new DaijishouLibraryRepository$searchPlayableItemsByKeyword$$inlined$sortedByDescending$2());
        int size2 = listSortedWith.size();
        ArrayList arrayList = new ArrayList(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            arrayList.add(((PlayableItemEntityWithCount) listSortedWith.get(i2)).getPlayableItemEntity());
        }
        ArrayList arrayList2 = arrayList;
        return arrayList2.subList(0, Math.min(arrayList2.size(), limit));
    }

    public static /* synthetic */ LiveData findPlayableItemsWithName$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.findPlayableItemsWithName(str, i);
    }

    public final LiveData<List<PlayableItemEntity>> findPlayableItemsWithName(String keyword, int limit) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return this.playableItemDAO.findWithName(keyword, limit);
    }

    public static /* synthetic */ LiveData findPlayableItemsWithNameAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.findPlayableItemsWithNameAndVisibility(str, i, z);
    }

    public final LiveData<List<PlayableItemEntity>> findPlayableItemsWithNameAndVisibility(String keyword, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return this.playableItemDAO.findWithNameAndVisibility(keyword, limit, visibility);
    }

    public static /* synthetic */ List findPlayableItemsWithNameStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.findPlayableItemsWithNameStatically(str, i);
    }

    public final List<PlayableItemEntity> findPlayableItemsWithNameStatically(String keyword, int limit) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return this.playableItemDAO.findWithNameStatically(keyword, limit);
    }

    public static /* synthetic */ List findPlayableItemsWithNameAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.findPlayableItemsWithNameAndVisibilityStatically(str, i, z);
    }

    public final List<PlayableItemEntity> findPlayableItemsWithNameAndVisibilityStatically(String keyword, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return this.playableItemDAO.findWithNameAndVisibilityStatically(keyword, limit, visibility);
    }

    public static /* synthetic */ LiveData findPlayableItemsWithNameAndDescription$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.findPlayableItemsWithNameAndDescription(str, i);
    }

    public final LiveData<List<PlayableItemEntity>> findPlayableItemsWithNameAndDescription(String keyword, int limit) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return this.playableItemDAO.findWithNameAndDescription(keyword, limit);
    }

    public static /* synthetic */ LiveData findPlayableItemsWithNameDescriptionAndVisibility$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.findPlayableItemsWithNameDescriptionAndVisibility(str, i, z);
    }

    public final LiveData<List<PlayableItemEntity>> findPlayableItemsWithNameDescriptionAndVisibility(String keyword, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return this.playableItemDAO.findWithNameDescriptionAndVisibility(keyword, limit, visibility);
    }

    public static /* synthetic */ List findPlayableItemsWithNameAndDescriptionStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        return daijishouLibraryRepository.findPlayableItemsWithNameAndDescriptionStatically(str, i);
    }

    public final List<PlayableItemEntity> findPlayableItemsWithNameAndDescriptionStatically(String keyword, int limit) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return this.playableItemDAO.findWithNameAndDescriptionStatically(keyword, limit);
    }

    public static /* synthetic */ List findPlayableItemsWithNameDescriptionAndVisibilityStatically$default(DaijishouLibraryRepository daijishouLibraryRepository, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 512;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return daijishouLibraryRepository.findPlayableItemsWithNameDescriptionAndVisibilityStatically(str, i, z);
    }

    public final List<PlayableItemEntity> findPlayableItemsWithNameDescriptionAndVisibilityStatically(String keyword, int limit, boolean visibility) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return this.playableItemDAO.findWithNameDescriptionAndVisibilityStatically(keyword, limit, visibility);
    }
}
