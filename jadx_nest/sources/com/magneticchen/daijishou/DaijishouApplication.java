package com.magneticchen.daijishou;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.preference.PreferenceManager;
import com.magneticchen.daijishou.activities.DaijishouMainService;
import com.magneticchen.daijishou.activities.MainActivity;
import com.magneticchen.daijishou.activities.abstract_classes.DaijishouServiceLauncher;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.backup_and_restore.BackupAndRestore;
import com.magneticchen.daijishou.cache.CachedBitmapLoader;
import com.magneticchen.daijishou.daijishou_debug_service.DaijishouDebugService;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_uri.DaijishouUriHandler;
import com.magneticchen.daijishou.daijishou_widget.WidgetsManager;
import com.magneticchen.daijishou.google_drive.GoogleDrive;
import com.magneticchen.daijishou.live_data.ConnectionLiveData;
import com.magneticchen.daijishou.live_data.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.live_data.SharedPreferenceStringLiveData;
import com.magneticchen.daijishou.logger.Logger;
import com.magneticchen.daijishou.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.repositories.DaijishouWidgetRepository;
import com.magneticchen.daijishou.repositories.RetroAchievementsRepository;
import com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager;
import com.magneticchen.daijishou.scraper.ScraperManager;
import com.magneticchen.daijishou.utils.DpToPxConverter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import org.apache.commons.collections4.CollectionUtils;

/* INFO: compiled from: DaijishouApplication.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u00002\u00020\u00012\u00020\u0002:\u0002Â\u0001B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010ª\u0001\u001a\u00020%H\u0002J\u0007\u0010«\u0001\u001a\u00020%J\t\u0010¬\u0001\u001a\u00020%H\u0016J\t\u0010\u00ad\u0001\u001a\u00020%H\u0016J\t\u0010®\u0001\u001a\u00020%H\u0016J\u0012\u0010¯\u0001\u001a\u00020%2\u0007\u0010°\u0001\u001a\u00020\tH\u0016J\u0012\u0010±\u0001\u001a\u00020%2\t\b\u0002\u0010²\u0001\u001a\u00020ZJ\u001b\u0010³\u0001\u001a\u00020%2\u0007\u0010´\u0001\u001a\u00020<2\t\b\u0002\u0010²\u0001\u001a\u00020ZJ\u001b\u0010µ\u0001\u001a\u00020<2\u0007\u0010¶\u0001\u001a\u00020<2\t\b\u0002\u0010·\u0001\u001a\u00020ZJ\u0012\u0010¸\u0001\u001a\u00020<2\u0007\u0010¹\u0001\u001a\u00020<H\u0002J\t\u0010º\u0001\u001a\u00020%H\u0002J\t\u0010»\u0001\u001a\u00020%H\u0002J\t\u0010¼\u0001\u001a\u00020%H\u0002J\u0007\u0010½\u0001\u001a\u00020%J\t\u0010¾\u0001\u001a\u00020%H\u0002J\u0007\u0010¿\u0001\u001a\u00020%J\u001b\u0010À\u0001\u001a\u00020%2\u0007\u0010¹\u0001\u001a\u00020<2\u0007\u0010Á\u0001\u001a\u00020<H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0014\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u001d\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u000203X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0017\u00108\u001a\b\u0012\u0004\u0012\u0002090.¢\u0006\b\n\u0000\u001a\u0004\b:\u00101R\u001a\u0010;\u001a\u00020<X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020BX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020HX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020NX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020TX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u000e\u0010Y\u001a\u00020ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\\\u001a\u00020]X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001a\u0010g\u001a\u00020ZX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001a\u0010l\u001a\u00020ZX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010i\"\u0004\bm\u0010kR\u001b\u0010n\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bn\u0010iR\u000e\u0010q\u001a\u00020rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010s\u001a\u00060tR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u001c\u0010w\u001a\u0004\u0018\u00010xX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u000e\u0010}\u001a\u00020ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u007fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0080\u0001\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0081\u0001\u001a\u00030\u0082\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R \u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R \u0010\u008b\u0001\u001a\u00030\u008c\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R\u000f\u0010\u0091\u0001\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0013\u0010\u0092\u0001\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR/\u0010\u0093\u0001\u001a\"\u0012\u0004\u0012\u00020<\u0012\u0005\u0012\u00030\u0095\u00010\u0094\u0001j\u0010\u0012\u0004\u0012\u00020<\u0012\u0005\u0012\u00030\u0095\u0001`\u0096\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0097\u0001\u001a\u00030\u0098\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R\u000f\u0010\u009d\u0001\u001a\u00020ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009e\u0001\u001a\u00020\u007fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u009f\u0001\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010 \u0001\u001a\u00030¡\u0001¢\u0006\n\n\u0000\u001a\u0006\b¢\u0001\u0010£\u0001R \u0010¤\u0001\u001a\u00030¥\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001¨\u0006Ã\u0001"}, d2 = {"Lcom/magneticchen/daijishou/DaijishouApplication;", "Landroid/app/Application;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "audioAttributes", "Landroid/media/AudioAttributes;", "backButtonSoundIdPreferenceLiveData", "Lcom/magneticchen/daijishou/live_data/SharedPreferenceStringLiveData;", "backPressedSFX", "", "Ljava/lang/Integer;", "backupAndRestore", "Lcom/magneticchen/daijishou/backup_and_restore/BackupAndRestore;", "getBackupAndRestore", "()Lcom/magneticchen/daijishou/backup_and_restore/BackupAndRestore;", "setBackupAndRestore", "(Lcom/magneticchen/daijishou/backup_and_restore/BackupAndRestore;)V", "bitmapLoaderDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "buttonPressedSFX", "buttonSoundIdPreferenceLiveData", "cachedBoxArtBitmapLoader", "Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;", "getCachedBoxArtBitmapLoader", "()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;", "cachedPlatformThumbnailBitmapLoader", "getCachedPlatformThumbnailBitmapLoader", "cachedPlatformWallpaperBitmapLoader", "getCachedPlatformWallpaperBitmapLoader", "cachedSnapshotBitmapLoader", "getCachedSnapshotBitmapLoader", "cachedTitleBitmapLoader", "getCachedTitleBitmapLoader", "connectionLiveData", "Lcom/magneticchen/daijishou/live_data/ConnectionLiveData;", "connectionLiveDataObserver", "Lkotlin/Function1;", "", "connectionType", "creationTime", "", "getCreationTime", "()J", "setCreationTime", "(J)V", "daijishouDebugServiceLauncher", "Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouServiceLauncher;", "Lcom/magneticchen/daijishou/daijishou_debug_service/DaijishouDebugService;", "getDaijishouDebugServiceLauncher", "()Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouServiceLauncher;", "daijishouLibraryRepository", "Lcom/magneticchen/daijishou/repositories/DaijishouLibraryRepository;", "getDaijishouLibraryRepository", "()Lcom/magneticchen/daijishou/repositories/DaijishouLibraryRepository;", "setDaijishouLibraryRepository", "(Lcom/magneticchen/daijishou/repositories/DaijishouLibraryRepository;)V", "daijishouMainServiceLauncher", "Lcom/magneticchen/daijishou/activities/DaijishouMainService;", "getDaijishouMainServiceLauncher", "daijishouUUID", "", "getDaijishouUUID", "()Ljava/lang/String;", "setDaijishouUUID", "(Ljava/lang/String;)V", "daijishouUriHandler", "Lcom/magneticchen/daijishou/daijishou_uri/DaijishouUriHandler;", "getDaijishouUriHandler", "()Lcom/magneticchen/daijishou/daijishou_uri/DaijishouUriHandler;", "setDaijishouUriHandler", "(Lcom/magneticchen/daijishou/daijishou_uri/DaijishouUriHandler;)V", "daijishouWidgetRepository", "Lcom/magneticchen/daijishou/repositories/DaijishouWidgetRepository;", "getDaijishouWidgetRepository", "()Lcom/magneticchen/daijishou/repositories/DaijishouWidgetRepository;", "setDaijishouWidgetRepository", "(Lcom/magneticchen/daijishou/repositories/DaijishouWidgetRepository;)V", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "getDefaultSharedPreferences", "()Landroid/content/SharedPreferences;", "setDefaultSharedPreferences", "(Landroid/content/SharedPreferences;)V", "dpToPxConverter", "Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "getDpToPxConverter", "()Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "setDpToPxConverter", "(Lcom/magneticchen/daijishou/utils/DpToPxConverter;)V", "firstTime", "", "forcingSingleSfxSound", "googleDrive", "Lcom/magneticchen/daijishou/google_drive/GoogleDrive;", "getGoogleDrive", "()Lcom/magneticchen/daijishou/google_drive/GoogleDrive;", "setGoogleDrive", "(Lcom/magneticchen/daijishou/google_drive/GoogleDrive;)V", "homeKeyPressedCountSinceLeave", "getHomeKeyPressedCountSinceLeave", "()I", "setHomeKeyPressedCountSinceLeave", "(I)V", "initialized", "getInitialized", "()Z", "setInitialized", "(Z)V", "isInitializing", "setInitializing", "isProbablyRunningOnEmulator", "isProbablyRunningOnEmulator$delegate", "Lkotlin/Lazy;", "lifecycleEventObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "mainActivity", "Lcom/magneticchen/daijishou/activities/MainActivity;", "getMainActivity", "()Lcom/magneticchen/daijishou/activities/MainActivity;", "setMainActivity", "(Lcom/magneticchen/daijishou/activities/MainActivity;)V", "makeButtonSound", "makeButtonSoundPreferenceLiveData", "Lcom/magneticchen/daijishou/live_data/SharedPreferenceBooleanLiveData;", "makeButtonSoundPreferenceLiveDataObserver", "retroAchievementsManager", "Lcom/magneticchen/daijishou/retro_achievements/RetroAchievementsManager;", "getRetroAchievementsManager", "()Lcom/magneticchen/daijishou/retro_achievements/RetroAchievementsManager;", "retroAchievementsRepository", "Lcom/magneticchen/daijishou/repositories/RetroAchievementsRepository;", "getRetroAchievementsRepository", "()Lcom/magneticchen/daijishou/repositories/RetroAchievementsRepository;", "setRetroAchievementsRepository", "(Lcom/magneticchen/daijishou/repositories/RetroAchievementsRepository;)V", "scraperManager", "Lcom/magneticchen/daijishou/scraper/ScraperManager;", "getScraperManager", "()Lcom/magneticchen/daijishou/scraper/ScraperManager;", "setScraperManager", "(Lcom/magneticchen/daijishou/scraper/ScraperManager;)V", "selectButtonSoundIdPreferenceLiveData", "selectPressedSFX", "sfxMediaPlayersHashMap", "Ljava/util/HashMap;", "Landroid/media/MediaPlayer;", "Lkotlin/collections/HashMap;", "soundpool", "Landroid/media/SoundPool;", "getSoundpool", "()Landroid/media/SoundPool;", "setSoundpool", "(Landroid/media/SoundPool;)V", "useDebugMode", "useDebugModeLiveData", "useDebugModeLiveDataObserver", "weakJson", "Lkotlinx/serialization/json/Json;", "getWeakJson", "()Lkotlinx/serialization/json/Json;", "widgetsManager", "Lcom/magneticchen/daijishou/daijishou_widget/WidgetsManager;", "getWidgetsManager", "()Lcom/magneticchen/daijishou/daijishou_widget/WidgetsManager;", "setWidgetsManager", "(Lcom/magneticchen/daijishou/daijishou_widget/WidgetsManager;)V", "muteUntilNotForcingSingleSfxSound", "notifyServicesUpgradeChance", "onCreate", "onLowMemory", "onTerminate", "onTrimMemory", "level", "playReachBoundSfx", "force", "playSfx", "sfxId", "prettifyTitle", "title", "showDiscIndex", "readFromFile", "filename", "setupMainActivity", "setupSounds", "setupStetho", "setupUUID", "startServices", "stopAllServices", "writeToFile", "data", "WrappedLogger", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouApplication extends Application implements LifecycleObserver {
    private final AudioAttributes audioAttributes;
    private SharedPreferenceStringLiveData backButtonSoundIdPreferenceLiveData;
    private Integer backPressedSFX;
    public BackupAndRestore backupAndRestore;
    private final ExecutorCoroutineDispatcher bitmapLoaderDispatcher;
    private Integer buttonPressedSFX;
    private SharedPreferenceStringLiveData buttonSoundIdPreferenceLiveData;
    private final CachedBitmapLoader cachedBoxArtBitmapLoader;
    private final CachedBitmapLoader cachedPlatformThumbnailBitmapLoader;
    private final CachedBitmapLoader cachedPlatformWallpaperBitmapLoader;
    private final CachedBitmapLoader cachedSnapshotBitmapLoader;
    private final CachedBitmapLoader cachedTitleBitmapLoader;
    private ConnectionLiveData connectionLiveData;
    private final Function1<Integer, Unit> connectionLiveDataObserver;
    public int connectionType;
    private long creationTime;
    public DaijishouLibraryRepository daijishouLibraryRepository;
    public String daijishouUUID;
    public DaijishouUriHandler daijishouUriHandler;
    public DaijishouWidgetRepository daijishouWidgetRepository;
    public SharedPreferences defaultSharedPreferences;
    public DpToPxConverter dpToPxConverter;
    public boolean firstTime;
    private boolean forcingSingleSfxSound;
    public GoogleDrive googleDrive;
    private int homeKeyPressedCountSinceLeave;
    private boolean initialized;
    private boolean isInitializing;

    /* INFO: renamed from: isProbablyRunningOnEmulator$delegate, reason: from kotlin metadata */
    private final Lazy isProbablyRunningOnEmulator;
    private final LifecycleEventObserver lifecycleEventObserver;
    private MainActivity mainActivity;
    public boolean makeButtonSound;
    private SharedPreferenceBooleanLiveData makeButtonSoundPreferenceLiveData;
    private final Function1<Boolean, Unit> makeButtonSoundPreferenceLiveDataObserver;
    private final RetroAchievementsManager retroAchievementsManager;
    public RetroAchievementsRepository retroAchievementsRepository;
    public ScraperManager scraperManager;
    private SharedPreferenceStringLiveData selectButtonSoundIdPreferenceLiveData;
    private Integer selectPressedSFX;
    private final HashMap<String, MediaPlayer> sfxMediaPlayersHashMap;
    private SoundPool soundpool;
    public boolean useDebugMode;
    private SharedPreferenceBooleanLiveData useDebugModeLiveData;
    private final Function1<Boolean, Unit> useDebugModeLiveDataObserver;
    public WidgetsManager widgetsManager;
    private final WrappedLogger logger = new WrappedLogger();
    private final Json weakJson = JsonKt.Json$default(null, DaijishouApplication$weakJson$1.INSTANCE, 1, null);
    private final DaijishouServiceLauncher<DaijishouDebugService> daijishouDebugServiceLauncher = new DaijishouServiceLauncher<>(this, DaijishouDebugService.class);
    private final DaijishouServiceLauncher<DaijishouMainService> daijishouMainServiceLauncher = new DaijishouServiceLauncher<>(this, DaijishouMainService.class);

    private final void setupMainActivity() {
    }

    private final void setupStetho() {
    }

    public DaijishouApplication() {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(64);
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
        ExecutorCoroutineDispatcher executorCoroutineDispatcherFrom = ExecutorsKt.from(executorServiceNewFixedThreadPool);
        this.bitmapLoaderDispatcher = executorCoroutineDispatcherFrom;
        this.cachedBoxArtBitmapLoader = new CachedBitmapLoader(256, 240, 5L, executorCoroutineDispatcherFrom);
        this.cachedSnapshotBitmapLoader = new CachedBitmapLoader(32, 720, 1L, executorCoroutineDispatcherFrom);
        this.cachedTitleBitmapLoader = new CachedBitmapLoader(16, 720, 1L, executorCoroutineDispatcherFrom);
        this.cachedPlatformWallpaperBitmapLoader = new CachedBitmapLoader(16, 720, 5L, executorCoroutineDispatcherFrom);
        this.cachedPlatformThumbnailBitmapLoader = new CachedBitmapLoader(16, 240, 5L, executorCoroutineDispatcherFrom);
        this.makeButtonSoundPreferenceLiveDataObserver = new DaijishouApplication$makeButtonSoundPreferenceLiveDataObserver$1(this);
        this.connectionLiveDataObserver = new DaijishouApplication$connectionLiveDataObserver$1(this);
        this.firstTime = true;
        this.useDebugModeLiveDataObserver = new DaijishouApplication$useDebugModeLiveDataObserver$1(this);
        this.isProbablyRunningOnEmulator = LazyKt.lazy(AnonymousClass2.INSTANCE);
        SoundPool soundPoolBuild = new SoundPool.Builder().setMaxStreams(1).build();
        Intrinsics.checkNotNullExpressionValue(soundPoolBuild, "build(...)");
        this.soundpool = soundPoolBuild;
        this.sfxMediaPlayersHashMap = new HashMap<>();
        this.retroAchievementsManager = new RetroAchievementsManager(this);
        this.makeButtonSound = true;
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(14).setContentType(4).build();
        Intrinsics.checkNotNullExpressionValue(audioAttributesBuild, "build(...)");
        this.audioAttributes = audioAttributesBuild;
        this.lifecycleEventObserver = new DaijishouApplication$$ExternalSyntheticLambda0(this);
    }

    public final ScraperManager getScraperManager() {
        ScraperManager scraperManager = this.scraperManager;
        if (scraperManager != null) {
            return scraperManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scraperManager");
        return null;
    }

    public final void setScraperManager(ScraperManager scraperManager) {
        Intrinsics.checkNotNullParameter(scraperManager, "<set-?>");
        this.scraperManager = scraperManager;
    }

    public final WidgetsManager getWidgetsManager() {
        WidgetsManager widgetsManager = this.widgetsManager;
        if (widgetsManager != null) {
            return widgetsManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("widgetsManager");
        return null;
    }

    public final void setWidgetsManager(WidgetsManager widgetsManager) {
        Intrinsics.checkNotNullParameter(widgetsManager, "<set-?>");
        this.widgetsManager = widgetsManager;
    }

    public final WrappedLogger getLogger() {
        return this.logger;
    }

    public final DaijishouLibraryRepository getDaijishouLibraryRepository() {
        DaijishouLibraryRepository daijishouLibraryRepository = this.daijishouLibraryRepository;
        if (daijishouLibraryRepository != null) {
            return daijishouLibraryRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("daijishouLibraryRepository");
        return null;
    }

    public final void setDaijishouLibraryRepository(DaijishouLibraryRepository daijishouLibraryRepository) {
        Intrinsics.checkNotNullParameter(daijishouLibraryRepository, "<set-?>");
        this.daijishouLibraryRepository = daijishouLibraryRepository;
    }

    public final DaijishouWidgetRepository getDaijishouWidgetRepository() {
        DaijishouWidgetRepository daijishouWidgetRepository = this.daijishouWidgetRepository;
        if (daijishouWidgetRepository != null) {
            return daijishouWidgetRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("daijishouWidgetRepository");
        return null;
    }

    public final void setDaijishouWidgetRepository(DaijishouWidgetRepository daijishouWidgetRepository) {
        Intrinsics.checkNotNullParameter(daijishouWidgetRepository, "<set-?>");
        this.daijishouWidgetRepository = daijishouWidgetRepository;
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

    public final SharedPreferences getDefaultSharedPreferences() {
        SharedPreferences sharedPreferences = this.defaultSharedPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        Intrinsics.throwUninitializedPropertyAccessException("defaultSharedPreferences");
        return null;
    }

    public final void setDefaultSharedPreferences(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<set-?>");
        this.defaultSharedPreferences = sharedPreferences;
    }

    public final BackupAndRestore getBackupAndRestore() {
        BackupAndRestore backupAndRestore = this.backupAndRestore;
        if (backupAndRestore != null) {
            return backupAndRestore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backupAndRestore");
        return null;
    }

    public final void setBackupAndRestore(BackupAndRestore backupAndRestore) {
        Intrinsics.checkNotNullParameter(backupAndRestore, "<set-?>");
        this.backupAndRestore = backupAndRestore;
    }

    public final GoogleDrive getGoogleDrive() {
        GoogleDrive googleDrive = this.googleDrive;
        if (googleDrive != null) {
            return googleDrive;
        }
        Intrinsics.throwUninitializedPropertyAccessException("googleDrive");
        return null;
    }

    public final void setGoogleDrive(GoogleDrive googleDrive) {
        Intrinsics.checkNotNullParameter(googleDrive, "<set-?>");
        this.googleDrive = googleDrive;
    }

    public final DpToPxConverter getDpToPxConverter() {
        DpToPxConverter dpToPxConverter = this.dpToPxConverter;
        if (dpToPxConverter != null) {
            return dpToPxConverter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dpToPxConverter");
        return null;
    }

    public final void setDpToPxConverter(DpToPxConverter dpToPxConverter) {
        Intrinsics.checkNotNullParameter(dpToPxConverter, "<set-?>");
        this.dpToPxConverter = dpToPxConverter;
    }

    public final DaijishouUriHandler getDaijishouUriHandler() {
        DaijishouUriHandler daijishouUriHandler = this.daijishouUriHandler;
        if (daijishouUriHandler != null) {
            return daijishouUriHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("daijishouUriHandler");
        return null;
    }

    public final void setDaijishouUriHandler(DaijishouUriHandler daijishouUriHandler) {
        Intrinsics.checkNotNullParameter(daijishouUriHandler, "<set-?>");
        this.daijishouUriHandler = daijishouUriHandler;
    }

    public final String getDaijishouUUID() {
        String str = this.daijishouUUID;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("daijishouUUID");
        return null;
    }

    public final void setDaijishouUUID(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.daijishouUUID = str;
    }

    public final Json getWeakJson() {
        return this.weakJson;
    }

    public final DaijishouServiceLauncher<DaijishouDebugService> getDaijishouDebugServiceLauncher() {
        return this.daijishouDebugServiceLauncher;
    }

    public final DaijishouServiceLauncher<DaijishouMainService> getDaijishouMainServiceLauncher() {
        return this.daijishouMainServiceLauncher;
    }

    public final MainActivity getMainActivity() {
        return this.mainActivity;
    }

    public final void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public final long getCreationTime() {
        return this.creationTime;
    }

    public final void setCreationTime(long j) {
        this.creationTime = j;
    }

    public final CachedBitmapLoader getCachedBoxArtBitmapLoader() {
        return this.cachedBoxArtBitmapLoader;
    }

    public final CachedBitmapLoader getCachedSnapshotBitmapLoader() {
        return this.cachedSnapshotBitmapLoader;
    }

    public final CachedBitmapLoader getCachedTitleBitmapLoader() {
        return this.cachedTitleBitmapLoader;
    }

    public final CachedBitmapLoader getCachedPlatformWallpaperBitmapLoader() {
        return this.cachedPlatformWallpaperBitmapLoader;
    }

    public final CachedBitmapLoader getCachedPlatformThumbnailBitmapLoader() {
        return this.cachedPlatformThumbnailBitmapLoader;
    }

    public static /* synthetic */ String prettifyTitle$default(DaijishouApplication daijishouApplication, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return daijishouApplication.prettifyTitle(str, z);
    }

    public final String prettifyTitle(String title, boolean showDiscIndex) {
        List<String> groupValues;
        String str;
        MatchResult matchResultFind$default;
        List<String> groupValues2;
        Intrinsics.checkNotNullParameter(title, "title");
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.PRETTIFY_TITLES.getKey(), BooleanPreference.PRETTIFY_TITLES.getDefaultValue())) {
            String str2 = (!showDiscIndex || (matchResultFind$default = Regex.find$default(Constants.INSTANCE.getDiscIndexRegex(), title, 0, 2, null)) == null || (groupValues2 = matchResultFind$default.getGroupValues()) == null) ? null : groupValues2.get(1);
            MatchResult matchResultFind$default2 = Regex.find$default(Constants.INSTANCE.getToGenericNameRegex(), title, 0, 2, null);
            if (matchResultFind$default2 != null && (groupValues = matchResultFind$default2.getGroupValues()) != null && (str = groupValues.get(1)) != null) {
                String strReplace = new Regex("\\s*-\\s+Disc\\s+\\d+\\s*").replace(str, "");
                if (strReplace != null) {
                    String strReplace2 = new Regex("(\\s+|_+)").replace(strReplace, " ");
                    if (strReplace2 != null) {
                        return str2 != null ? ((Object) strReplace2) + " • Disc " + str2 : strReplace2;
                    }
                }
            }
        }
        return title;
    }

    public final void setupUUID() {
        if (!new File(getFilesDir(), Constants.uUIDFilename).exists()) {
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            setDaijishouUUID(string);
            writeToFile(Constants.uUIDFilename, getDaijishouUUID());
            return;
        }
        setDaijishouUUID(readFromFile(Constants.uUIDFilename));
    }

    private final void writeToFile(String filename, String data) {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(applicationContext.openFileOutput(filename, 0));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            this.logger.error(this, "File write failed: " + e);
        }
    }

    private final String readFromFile(String filename) {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        try {
            FileInputStream fileInputStreamOpenFileInput = applicationContext.openFileInput(filename);
            Intrinsics.checkNotNullExpressionValue(fileInputStreamOpenFileInput, "openFileInput(...)");
            FileInputStream fileInputStream = fileInputStreamOpenFileInput;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("\n");
                    }
                    sb.append(line);
                } else {
                    fileInputStream.close();
                    String string = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    return string;
                }
            }
        } catch (FileNotFoundException e) {
            this.logger.error(this, "File not found: " + e);
            return "";
        } catch (IOException e2) {
            this.logger.error(this, "Can not read file: " + e2);
            return "";
        }
    }

    /* INFO: compiled from: DaijishouApplication.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0005J\u0016\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0005J\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0005J \u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0016\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0005R\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "components", "Ljava/util/SortedSet;", "", "getComponents", "()Ljava/util/SortedSet;", "latestLogRecordLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/magneticchen/daijishou/logger/Logger$LogRecord;", "getLatestLogRecordLiveData", "()Landroidx/lifecycle/LiveData;", org.eclipse.jgit.lib.Constants.LOGS, "", "getLogs", "()Ljava/util/List;", "tag", "getTag", "()Ljava/lang/String;", "clear", "", "debug", "fromComponent", "message", "error", "info", "printLog", "LoggerCode", "", "warn", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class WrappedLogger {
        private final String tag = "daijishou_logger_offline";

        public WrappedLogger() {
        }

        public final String getTag() {
            return this.tag;
        }

        public final List<Logger.LogRecord> getLogs() {
            Logger logger;
            DaijishouMainService daijishouMainService = (DaijishouMainService) DaijishouApplication.this.getDaijishouMainServiceLauncher().getService();
            if (daijishouMainService == null || (logger = daijishouMainService.getLogger()) == null) {
                return null;
            }
            return logger.getLogs();
        }

        public final SortedSet<String> getComponents() {
            Logger logger;
            DaijishouMainService daijishouMainService = (DaijishouMainService) DaijishouApplication.this.getDaijishouMainServiceLauncher().getService();
            if (daijishouMainService == null || (logger = daijishouMainService.getLogger()) == null) {
                return null;
            }
            return logger.getComponents();
        }

        public final LiveData<Logger.LogRecord> getLatestLogRecordLiveData() {
            Logger logger;
            DaijishouMainService daijishouMainService = (DaijishouMainService) DaijishouApplication.this.getDaijishouMainServiceLauncher().getService();
            if (daijishouMainService == null || (logger = daijishouMainService.getLogger()) == null) {
                return null;
            }
            return logger.getLatestLogRecordLiveData();
        }

        private final void printLog(Object fromComponent, int LoggerCode, String message) {
            String simpleName = fromComponent instanceof String ? (String) fromComponent : fromComponent.getClass().getSimpleName();
            if (LoggerCode == -1) {
                Log.i(Logger.TAG, CollectionUtils.DEFAULT_TOSTRING_PREFIX + simpleName + "] " + message);
                return;
            }
            if (LoggerCode == 0) {
                Log.i(Logger.TAG, CollectionUtils.DEFAULT_TOSTRING_PREFIX + simpleName + "] " + message);
                return;
            }
            if (LoggerCode == 1) {
                Log.d(Logger.TAG, CollectionUtils.DEFAULT_TOSTRING_PREFIX + simpleName + "] " + message);
            } else if (LoggerCode == 2) {
                Log.w(Logger.TAG, CollectionUtils.DEFAULT_TOSTRING_PREFIX + simpleName + "] " + message);
            } else {
                if (LoggerCode != 3) {
                    return;
                }
                Log.e(Logger.TAG, CollectionUtils.DEFAULT_TOSTRING_PREFIX + simpleName + "] " + message);
            }
        }

        public final void debug(Object fromComponent, String message) {
            Intrinsics.checkNotNullParameter(fromComponent, "fromComponent");
            Intrinsics.checkNotNullParameter(message, "message");
            DaijishouMainService daijishouMainService = (DaijishouMainService) DaijishouApplication.this.getDaijishouMainServiceLauncher().getService();
            Logger logger = daijishouMainService != null ? daijishouMainService.getLogger() : null;
            if (logger == null) {
                printLog(fromComponent, 1, message);
            } else {
                logger.debug(fromComponent, message);
            }
        }

        public final void info(Object fromComponent, String message) {
            Intrinsics.checkNotNullParameter(fromComponent, "fromComponent");
            Intrinsics.checkNotNullParameter(message, "message");
            DaijishouMainService daijishouMainService = (DaijishouMainService) DaijishouApplication.this.getDaijishouMainServiceLauncher().getService();
            Logger logger = daijishouMainService != null ? daijishouMainService.getLogger() : null;
            if (logger == null) {
                printLog(fromComponent, 0, message);
            } else {
                logger.info(fromComponent, message);
            }
        }

        public final void error(Object fromComponent, String message) {
            Intrinsics.checkNotNullParameter(fromComponent, "fromComponent");
            Intrinsics.checkNotNullParameter(message, "message");
            DaijishouMainService daijishouMainService = (DaijishouMainService) DaijishouApplication.this.getDaijishouMainServiceLauncher().getService();
            Logger logger = daijishouMainService != null ? daijishouMainService.getLogger() : null;
            if (logger == null) {
                printLog(fromComponent, 3, message);
            } else {
                logger.error(fromComponent, message);
            }
        }

        public final void warn(Object fromComponent, String message) {
            Intrinsics.checkNotNullParameter(fromComponent, "fromComponent");
            Intrinsics.checkNotNullParameter(message, "message");
            DaijishouMainService daijishouMainService = (DaijishouMainService) DaijishouApplication.this.getDaijishouMainServiceLauncher().getService();
            Logger logger = daijishouMainService != null ? daijishouMainService.getLogger() : null;
            if (logger == null) {
                printLog(fromComponent, 2, message);
            } else {
                logger.warn(fromComponent, message);
            }
        }

        public final void clear() {
            DaijishouMainService daijishouMainService = (DaijishouMainService) DaijishouApplication.this.getDaijishouMainServiceLauncher().getService();
            Logger logger = daijishouMainService != null ? daijishouMainService.getLogger() : null;
            if (logger == null) {
                Log.w(this.tag, "Logger clear skipped.");
            } else {
                logger.clear();
                Logger.saveLogsToFile$default(logger, Constants.loggerFilename, 0, 2, null);
            }
        }
    }

    public final boolean getInitialized() {
        return this.initialized;
    }

    public final void setInitialized(boolean z) {
        this.initialized = z;
    }

    /* INFO: renamed from: isInitializing, reason: from getter */
    public final boolean getIsInitializing() {
        return this.isInitializing;
    }

    public final void setInitializing(boolean z) {
        this.isInitializing = z;
    }

    public final boolean isProbablyRunningOnEmulator() {
        return ((Boolean) this.isProbablyRunningOnEmulator.getValue()).booleanValue();
    }

    /* INFO: renamed from: com.magneticchen.daijishou.DaijishouApplication$isProbablyRunningOnEmulator$2, reason: invalid class name */
    /* INFO: compiled from: DaijishouApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda<Boolean> implements Function0<Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(0);
        }

        /* WARN: Can't rename method to resolve collision */
        /* WARN: Code duplicated, block: B:14:0x0050  */
        /* WARN: Code duplicated, block: B:16:0x005d  */
        /* WARN: Code duplicated, block: B:18:0x006a  */
        /* WARN: Code duplicated, block: B:20:0x0075  */
        /* WARN: Code duplicated, block: B:22:0x0082  */
        /* WARN: Code duplicated, block: B:24:0x008d  */
        /* WARN: Code duplicated, block: B:26:0x009a  */
        /* WARN: Code duplicated, block: B:28:0x00a7  */
        /* WARN: Code duplicated, block: B:30:0x00b9  */
        /* WARN: Code duplicated, block: B:32:0x00ca  */
        /* WARN: Code duplicated, block: B:34:0x00db  */
        /* WARN: Code duplicated, block: B:40:0x0102  */
        /* WARN: Code duplicated, block: B:42:0x0111  */
        /* WARN: Code duplicated, block: B:44:0x011e  */
        /* WARN: Code duplicated, block: B:46:0x012b  */
        /* WARN: Code duplicated, block: B:49:0x0134  */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            String FINGERPRINT;
            String FINGERPRINT2;
            String MODEL;
            String MODEL2;
            String MODEL3;
            String MANUFACTURER;
            String HOST;
            String BRAND;
            String DEVICE;
            String FINGERPRINT3;
            String FINGERPRINT4;
            String PRODUCT;
            String MODEL4;
            String FINGERPRINT5;
            boolean z = true;
            if (Intrinsics.areEqual(Build.MANUFACTURER, "Google") && Intrinsics.areEqual(Build.BRAND, "google")) {
                String FINGERPRINT6 = Build.FINGERPRINT;
                Intrinsics.checkNotNullExpressionValue(FINGERPRINT6, "FINGERPRINT");
                if (StringsKt.startsWith$default(FINGERPRINT6, "google/sdk_gphone_", false, 2, (Object) null)) {
                    String FINGERPRINT7 = Build.FINGERPRINT;
                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT7, "FINGERPRINT");
                    if (StringsKt.endsWith$default(FINGERPRINT7, ":user/release-keys", false, 2, (Object) null)) {
                        String PRODUCT2 = Build.PRODUCT;
                        Intrinsics.checkNotNullExpressionValue(PRODUCT2, "PRODUCT");
                        if (StringsKt.startsWith$default(PRODUCT2, "sdk_gphone_", false, 2, (Object) null)) {
                            String MODEL5 = Build.MODEL;
                            Intrinsics.checkNotNullExpressionValue(MODEL5, "MODEL");
                            if (!StringsKt.startsWith$default(MODEL5, "sdk_gphone_", false, 2, (Object) null)) {
                                FINGERPRINT3 = Build.FINGERPRINT;
                                Intrinsics.checkNotNullExpressionValue(FINGERPRINT3, "FINGERPRINT");
                                if (StringsKt.startsWith$default(FINGERPRINT3, "google/sdk_gphone64_", false, 2, (Object) null)) {
                                    FINGERPRINT4 = Build.FINGERPRINT;
                                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT4, "FINGERPRINT");
                                    if (StringsKt.endsWith$default(FINGERPRINT4, ":userdebug/dev-keys", false, 2, (Object) null)) {
                                        PRODUCT = Build.PRODUCT;
                                        Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                        if (StringsKt.startsWith$default(PRODUCT, "sdk_gphone64_", false, 2, (Object) null)) {
                                            MODEL4 = Build.MODEL;
                                            Intrinsics.checkNotNullExpressionValue(MODEL4, "MODEL");
                                            if (!StringsKt.startsWith$default(MODEL4, "sdk_gphone64_", false, 2, (Object) null)) {
                                                FINGERPRINT = Build.FINGERPRINT;
                                                Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                                if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                                    FINGERPRINT2 = Build.FINGERPRINT;
                                                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                                    if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                                        MODEL = Build.MODEL;
                                                        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                                        if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                            MODEL2 = Build.MODEL;
                                                            Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                            if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                                MODEL3 = Build.MODEL;
                                                                Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                                if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                                    MANUFACTURER = Build.MANUFACTURER;
                                                                    Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                                    if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                                        HOST = Build.HOST;
                                                                        Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                                        if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                            BRAND = Build.BRAND;
                                                                            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                            if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                                DEVICE = Build.DEVICE;
                                                                                Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                                if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                                    if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                        z = false;
                                                                                    }
                                                                                }
                                                                            } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                z = false;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            FINGERPRINT = Build.FINGERPRINT;
                                            Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                            if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                                FINGERPRINT2 = Build.FINGERPRINT;
                                                Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                                if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                                    MODEL = Build.MODEL;
                                                    Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                                    if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                        MODEL2 = Build.MODEL;
                                                        Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                        if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                            MODEL3 = Build.MODEL;
                                                            Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                            if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                                MANUFACTURER = Build.MANUFACTURER;
                                                                Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                                if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                                    HOST = Build.HOST;
                                                                    Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                                    if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                        BRAND = Build.BRAND;
                                                                        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                        if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                            DEVICE = Build.DEVICE;
                                                                            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                            if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                                if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                    z = false;
                                                                                }
                                                                            }
                                                                        } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        FINGERPRINT5 = Build.FINGERPRINT;
                                        Intrinsics.checkNotNullExpressionValue(FINGERPRINT5, "FINGERPRINT");
                                        if (StringsKt.endsWith$default(FINGERPRINT5, ":user/release-keys", false, 2, (Object) null)) {
                                            PRODUCT = Build.PRODUCT;
                                            Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                            if (StringsKt.startsWith$default(PRODUCT, "sdk_gphone64_", false, 2, (Object) null)) {
                                                MODEL4 = Build.MODEL;
                                                Intrinsics.checkNotNullExpressionValue(MODEL4, "MODEL");
                                                if (!StringsKt.startsWith$default(MODEL4, "sdk_gphone64_", false, 2, (Object) null)) {
                                                    FINGERPRINT = Build.FINGERPRINT;
                                                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                                    if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                                        FINGERPRINT2 = Build.FINGERPRINT;
                                                        Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                                        if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                                            MODEL = Build.MODEL;
                                                            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                                            if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                                MODEL2 = Build.MODEL;
                                                                Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                                if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                                    MODEL3 = Build.MODEL;
                                                                    Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                                    if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                                        MANUFACTURER = Build.MANUFACTURER;
                                                                        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                                        if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                                            HOST = Build.HOST;
                                                                            Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                                            if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                                BRAND = Build.BRAND;
                                                                                Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                                if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                                    DEVICE = Build.DEVICE;
                                                                                    Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                                    if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                                        if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                            z = false;
                                                                                        }
                                                                                    }
                                                                                } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                    z = false;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                FINGERPRINT = Build.FINGERPRINT;
                                                Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                                if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                                    FINGERPRINT2 = Build.FINGERPRINT;
                                                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                                    if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                                        MODEL = Build.MODEL;
                                                        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                                        if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                            MODEL2 = Build.MODEL;
                                                            Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                            if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                                MODEL3 = Build.MODEL;
                                                                Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                                if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                                    MANUFACTURER = Build.MANUFACTURER;
                                                                    Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                                    if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                                        HOST = Build.HOST;
                                                                        Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                                        if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                            BRAND = Build.BRAND;
                                                                            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                            if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                                DEVICE = Build.DEVICE;
                                                                                Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                                if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                                    if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                        z = false;
                                                                                    }
                                                                                }
                                                                            } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                z = false;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            FINGERPRINT = Build.FINGERPRINT;
                                            Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                            if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                                FINGERPRINT2 = Build.FINGERPRINT;
                                                Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                                if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                                    MODEL = Build.MODEL;
                                                    Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                                    if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                        MODEL2 = Build.MODEL;
                                                        Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                        if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                            MODEL3 = Build.MODEL;
                                                            Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                            if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                                MANUFACTURER = Build.MANUFACTURER;
                                                                Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                                if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                                    HOST = Build.HOST;
                                                                    Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                                    if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                        BRAND = Build.BRAND;
                                                                        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                        if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                            DEVICE = Build.DEVICE;
                                                                            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                            if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                                if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                    z = false;
                                                                                }
                                                                            }
                                                                        } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    FINGERPRINT = Build.FINGERPRINT;
                                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                    if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                        FINGERPRINT2 = Build.FINGERPRINT;
                                        Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                        if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                            MODEL = Build.MODEL;
                                            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                            if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                MODEL2 = Build.MODEL;
                                                Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                    MODEL3 = Build.MODEL;
                                                    Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                    if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                        MANUFACTURER = Build.MANUFACTURER;
                                                        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                        if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                            HOST = Build.HOST;
                                                            Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                            if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                BRAND = Build.BRAND;
                                                                Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                    DEVICE = Build.DEVICE;
                                                                    Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                    if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                        if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                    z = false;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            FINGERPRINT3 = Build.FINGERPRINT;
                            Intrinsics.checkNotNullExpressionValue(FINGERPRINT3, "FINGERPRINT");
                            if (StringsKt.startsWith$default(FINGERPRINT3, "google/sdk_gphone64_", false, 2, (Object) null)) {
                                FINGERPRINT4 = Build.FINGERPRINT;
                                Intrinsics.checkNotNullExpressionValue(FINGERPRINT4, "FINGERPRINT");
                                if (StringsKt.endsWith$default(FINGERPRINT4, ":userdebug/dev-keys", false, 2, (Object) null)) {
                                    FINGERPRINT5 = Build.FINGERPRINT;
                                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT5, "FINGERPRINT");
                                    if (StringsKt.endsWith$default(FINGERPRINT5, ":user/release-keys", false, 2, (Object) null)) {
                                        PRODUCT = Build.PRODUCT;
                                        Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                        if (StringsKt.startsWith$default(PRODUCT, "sdk_gphone64_", false, 2, (Object) null)) {
                                            MODEL4 = Build.MODEL;
                                            Intrinsics.checkNotNullExpressionValue(MODEL4, "MODEL");
                                            if (!StringsKt.startsWith$default(MODEL4, "sdk_gphone64_", false, 2, (Object) null)) {
                                                FINGERPRINT = Build.FINGERPRINT;
                                                Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                                if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                                    FINGERPRINT2 = Build.FINGERPRINT;
                                                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                                    if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                                        MODEL = Build.MODEL;
                                                        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                                        if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                            MODEL2 = Build.MODEL;
                                                            Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                            if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                                MODEL3 = Build.MODEL;
                                                                Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                                if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                                    MANUFACTURER = Build.MANUFACTURER;
                                                                    Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                                    if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                                        HOST = Build.HOST;
                                                                        Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                                        if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                            BRAND = Build.BRAND;
                                                                            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                            if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                                DEVICE = Build.DEVICE;
                                                                                Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                                if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                                    if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                        z = false;
                                                                                    }
                                                                                }
                                                                            } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                z = false;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            FINGERPRINT = Build.FINGERPRINT;
                                            Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                            if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                                FINGERPRINT2 = Build.FINGERPRINT;
                                                Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                                if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                                    MODEL = Build.MODEL;
                                                    Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                                    if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                        MODEL2 = Build.MODEL;
                                                        Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                        if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                            MODEL3 = Build.MODEL;
                                                            Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                            if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                                MANUFACTURER = Build.MANUFACTURER;
                                                                Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                                if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                                    HOST = Build.HOST;
                                                                    Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                                    if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                        BRAND = Build.BRAND;
                                                                        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                        if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                            DEVICE = Build.DEVICE;
                                                                            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                            if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                                if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                    z = false;
                                                                                }
                                                                            }
                                                                        } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        FINGERPRINT = Build.FINGERPRINT;
                                        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                        if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                            FINGERPRINT2 = Build.FINGERPRINT;
                                            Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                            if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                                MODEL = Build.MODEL;
                                                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                                if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                    MODEL2 = Build.MODEL;
                                                    Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                    if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                        MODEL3 = Build.MODEL;
                                                        Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                        if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                            MANUFACTURER = Build.MANUFACTURER;
                                                            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                            if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                                HOST = Build.HOST;
                                                                Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                                if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                    BRAND = Build.BRAND;
                                                                    Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                    if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                        DEVICE = Build.DEVICE;
                                                                        Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                        if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                            if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                z = false;
                                                                            }
                                                                        }
                                                                    } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    PRODUCT = Build.PRODUCT;
                                    Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                    if (StringsKt.startsWith$default(PRODUCT, "sdk_gphone64_", false, 2, (Object) null)) {
                                        MODEL4 = Build.MODEL;
                                        Intrinsics.checkNotNullExpressionValue(MODEL4, "MODEL");
                                        if (!StringsKt.startsWith$default(MODEL4, "sdk_gphone64_", false, 2, (Object) null)) {
                                            FINGERPRINT = Build.FINGERPRINT;
                                            Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                            if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                                FINGERPRINT2 = Build.FINGERPRINT;
                                                Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                                if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                                    MODEL = Build.MODEL;
                                                    Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                                    if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                        MODEL2 = Build.MODEL;
                                                        Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                        if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                            MODEL3 = Build.MODEL;
                                                            Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                            if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                                MANUFACTURER = Build.MANUFACTURER;
                                                                Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                                if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                                    HOST = Build.HOST;
                                                                    Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                                    if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                        BRAND = Build.BRAND;
                                                                        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                        if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                            DEVICE = Build.DEVICE;
                                                                            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                            if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                                if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                    z = false;
                                                                                }
                                                                            }
                                                                        } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        FINGERPRINT = Build.FINGERPRINT;
                                        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                        if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                            FINGERPRINT2 = Build.FINGERPRINT;
                                            Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                            if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                                MODEL = Build.MODEL;
                                                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                                if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                    MODEL2 = Build.MODEL;
                                                    Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                    if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                        MODEL3 = Build.MODEL;
                                                        Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                        if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                            MANUFACTURER = Build.MANUFACTURER;
                                                            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                            if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                                HOST = Build.HOST;
                                                                Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                                if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                    BRAND = Build.BRAND;
                                                                    Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                    if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                        DEVICE = Build.DEVICE;
                                                                        Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                        if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                            if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                z = false;
                                                                            }
                                                                        }
                                                                    } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                FINGERPRINT = Build.FINGERPRINT;
                                Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                    FINGERPRINT2 = Build.FINGERPRINT;
                                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                    if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                        MODEL = Build.MODEL;
                                        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                        if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                            MODEL2 = Build.MODEL;
                                            Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                            if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                MODEL3 = Build.MODEL;
                                                Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                    MANUFACTURER = Build.MANUFACTURER;
                                                    Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                    if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                        HOST = Build.HOST;
                                                        Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                        if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                            BRAND = Build.BRAND;
                                                            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                            if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                DEVICE = Build.DEVICE;
                                                                Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                    if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                        z = false;
                                                                    }
                                                                }
                                                            } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                z = false;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        FINGERPRINT3 = Build.FINGERPRINT;
                        Intrinsics.checkNotNullExpressionValue(FINGERPRINT3, "FINGERPRINT");
                        if (StringsKt.startsWith$default(FINGERPRINT3, "google/sdk_gphone64_", false, 2, (Object) null)) {
                            FINGERPRINT4 = Build.FINGERPRINT;
                            Intrinsics.checkNotNullExpressionValue(FINGERPRINT4, "FINGERPRINT");
                            if (StringsKt.endsWith$default(FINGERPRINT4, ":userdebug/dev-keys", false, 2, (Object) null)) {
                                FINGERPRINT5 = Build.FINGERPRINT;
                                Intrinsics.checkNotNullExpressionValue(FINGERPRINT5, "FINGERPRINT");
                                if (StringsKt.endsWith$default(FINGERPRINT5, ":user/release-keys", false, 2, (Object) null)) {
                                    PRODUCT = Build.PRODUCT;
                                    Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                    if (StringsKt.startsWith$default(PRODUCT, "sdk_gphone64_", false, 2, (Object) null)) {
                                        MODEL4 = Build.MODEL;
                                        Intrinsics.checkNotNullExpressionValue(MODEL4, "MODEL");
                                        if (!StringsKt.startsWith$default(MODEL4, "sdk_gphone64_", false, 2, (Object) null)) {
                                            FINGERPRINT = Build.FINGERPRINT;
                                            Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                            if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                                FINGERPRINT2 = Build.FINGERPRINT;
                                                Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                                if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                                    MODEL = Build.MODEL;
                                                    Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                                    if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                        MODEL2 = Build.MODEL;
                                                        Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                        if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                            MODEL3 = Build.MODEL;
                                                            Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                            if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                                MANUFACTURER = Build.MANUFACTURER;
                                                                Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                                if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                                    HOST = Build.HOST;
                                                                    Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                                    if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                        BRAND = Build.BRAND;
                                                                        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                        if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                            DEVICE = Build.DEVICE;
                                                                            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                            if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                                if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                    z = false;
                                                                                }
                                                                            }
                                                                        } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        FINGERPRINT = Build.FINGERPRINT;
                                        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                        if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                            FINGERPRINT2 = Build.FINGERPRINT;
                                            Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                            if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                                MODEL = Build.MODEL;
                                                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                                if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                    MODEL2 = Build.MODEL;
                                                    Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                    if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                        MODEL3 = Build.MODEL;
                                                        Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                        if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                            MANUFACTURER = Build.MANUFACTURER;
                                                            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                            if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                                HOST = Build.HOST;
                                                                Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                                if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                    BRAND = Build.BRAND;
                                                                    Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                    if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                        DEVICE = Build.DEVICE;
                                                                        Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                        if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                            if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                z = false;
                                                                            }
                                                                        }
                                                                    } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    FINGERPRINT = Build.FINGERPRINT;
                                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                    if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                        FINGERPRINT2 = Build.FINGERPRINT;
                                        Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                        if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                            MODEL = Build.MODEL;
                                            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                            if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                MODEL2 = Build.MODEL;
                                                Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                    MODEL3 = Build.MODEL;
                                                    Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                    if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                        MANUFACTURER = Build.MANUFACTURER;
                                                        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                        if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                            HOST = Build.HOST;
                                                            Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                            if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                BRAND = Build.BRAND;
                                                                Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                    DEVICE = Build.DEVICE;
                                                                    Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                    if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                        if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                    z = false;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                PRODUCT = Build.PRODUCT;
                                Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                if (StringsKt.startsWith$default(PRODUCT, "sdk_gphone64_", false, 2, (Object) null)) {
                                    MODEL4 = Build.MODEL;
                                    Intrinsics.checkNotNullExpressionValue(MODEL4, "MODEL");
                                    if (!StringsKt.startsWith$default(MODEL4, "sdk_gphone64_", false, 2, (Object) null)) {
                                        FINGERPRINT = Build.FINGERPRINT;
                                        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                        if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                            FINGERPRINT2 = Build.FINGERPRINT;
                                            Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                            if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                                MODEL = Build.MODEL;
                                                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                                if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                    MODEL2 = Build.MODEL;
                                                    Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                    if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                        MODEL3 = Build.MODEL;
                                                        Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                        if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                            MANUFACTURER = Build.MANUFACTURER;
                                                            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                            if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                                HOST = Build.HOST;
                                                                Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                                if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                    BRAND = Build.BRAND;
                                                                    Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                    if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                        DEVICE = Build.DEVICE;
                                                                        Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                        if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                            if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                z = false;
                                                                            }
                                                                        }
                                                                    } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    FINGERPRINT = Build.FINGERPRINT;
                                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                    if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                        FINGERPRINT2 = Build.FINGERPRINT;
                                        Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                        if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                            MODEL = Build.MODEL;
                                            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                            if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                MODEL2 = Build.MODEL;
                                                Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                    MODEL3 = Build.MODEL;
                                                    Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                    if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                        MANUFACTURER = Build.MANUFACTURER;
                                                        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                        if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                            HOST = Build.HOST;
                                                            Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                            if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                BRAND = Build.BRAND;
                                                                Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                    DEVICE = Build.DEVICE;
                                                                    Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                    if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                        if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                    z = false;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            FINGERPRINT = Build.FINGERPRINT;
                            Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                            if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                FINGERPRINT2 = Build.FINGERPRINT;
                                Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                    MODEL = Build.MODEL;
                                    Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                    if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                        MODEL2 = Build.MODEL;
                                        Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                        if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                            MODEL3 = Build.MODEL;
                                            Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                            if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                MANUFACTURER = Build.MANUFACTURER;
                                                Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                    HOST = Build.HOST;
                                                    Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                    if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                        BRAND = Build.BRAND;
                                                        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                        if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                            DEVICE = Build.DEVICE;
                                                            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                            if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                    z = false;
                                                                }
                                                            }
                                                        } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                            z = false;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    FINGERPRINT3 = Build.FINGERPRINT;
                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT3, "FINGERPRINT");
                    if (StringsKt.startsWith$default(FINGERPRINT3, "google/sdk_gphone64_", false, 2, (Object) null)) {
                        FINGERPRINT4 = Build.FINGERPRINT;
                        Intrinsics.checkNotNullExpressionValue(FINGERPRINT4, "FINGERPRINT");
                        if (StringsKt.endsWith$default(FINGERPRINT4, ":userdebug/dev-keys", false, 2, (Object) null)) {
                            FINGERPRINT5 = Build.FINGERPRINT;
                            Intrinsics.checkNotNullExpressionValue(FINGERPRINT5, "FINGERPRINT");
                            if (StringsKt.endsWith$default(FINGERPRINT5, ":user/release-keys", false, 2, (Object) null)) {
                                PRODUCT = Build.PRODUCT;
                                Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                if (StringsKt.startsWith$default(PRODUCT, "sdk_gphone64_", false, 2, (Object) null)) {
                                    MODEL4 = Build.MODEL;
                                    Intrinsics.checkNotNullExpressionValue(MODEL4, "MODEL");
                                    if (!StringsKt.startsWith$default(MODEL4, "sdk_gphone64_", false, 2, (Object) null)) {
                                        FINGERPRINT = Build.FINGERPRINT;
                                        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                        if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                            FINGERPRINT2 = Build.FINGERPRINT;
                                            Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                            if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                                MODEL = Build.MODEL;
                                                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                                if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                    MODEL2 = Build.MODEL;
                                                    Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                    if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                        MODEL3 = Build.MODEL;
                                                        Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                        if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                            MANUFACTURER = Build.MANUFACTURER;
                                                            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                            if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                                HOST = Build.HOST;
                                                                Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                                if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                    BRAND = Build.BRAND;
                                                                    Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                    if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                        DEVICE = Build.DEVICE;
                                                                        Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                        if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                            if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                                z = false;
                                                                            }
                                                                        }
                                                                    } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                        z = false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    FINGERPRINT = Build.FINGERPRINT;
                                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                    if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                        FINGERPRINT2 = Build.FINGERPRINT;
                                        Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                        if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                            MODEL = Build.MODEL;
                                            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                            if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                MODEL2 = Build.MODEL;
                                                Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                    MODEL3 = Build.MODEL;
                                                    Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                    if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                        MANUFACTURER = Build.MANUFACTURER;
                                                        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                        if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                            HOST = Build.HOST;
                                                            Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                            if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                BRAND = Build.BRAND;
                                                                Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                    DEVICE = Build.DEVICE;
                                                                    Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                    if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                        if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                    z = false;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                FINGERPRINT = Build.FINGERPRINT;
                                Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                    FINGERPRINT2 = Build.FINGERPRINT;
                                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                    if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                        MODEL = Build.MODEL;
                                        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                        if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                            MODEL2 = Build.MODEL;
                                            Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                            if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                MODEL3 = Build.MODEL;
                                                Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                    MANUFACTURER = Build.MANUFACTURER;
                                                    Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                    if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                        HOST = Build.HOST;
                                                        Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                        if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                            BRAND = Build.BRAND;
                                                            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                            if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                DEVICE = Build.DEVICE;
                                                                Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                    if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                        z = false;
                                                                    }
                                                                }
                                                            } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                z = false;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            PRODUCT = Build.PRODUCT;
                            Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                            if (StringsKt.startsWith$default(PRODUCT, "sdk_gphone64_", false, 2, (Object) null)) {
                                MODEL4 = Build.MODEL;
                                Intrinsics.checkNotNullExpressionValue(MODEL4, "MODEL");
                                if (!StringsKt.startsWith$default(MODEL4, "sdk_gphone64_", false, 2, (Object) null)) {
                                    FINGERPRINT = Build.FINGERPRINT;
                                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                    if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                        FINGERPRINT2 = Build.FINGERPRINT;
                                        Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                        if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                            MODEL = Build.MODEL;
                                            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                            if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                                MODEL2 = Build.MODEL;
                                                Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                                if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                    MODEL3 = Build.MODEL;
                                                    Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                    if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                        MANUFACTURER = Build.MANUFACTURER;
                                                        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                        if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                            HOST = Build.HOST;
                                                            Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                            if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                                BRAND = Build.BRAND;
                                                                Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                                if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                    DEVICE = Build.DEVICE;
                                                                    Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                    if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                        if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                            z = false;
                                                                        }
                                                                    }
                                                                } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                    z = false;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                FINGERPRINT = Build.FINGERPRINT;
                                Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                                if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                                    FINGERPRINT2 = Build.FINGERPRINT;
                                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                                    if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                        MODEL = Build.MODEL;
                                        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                        if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                            MODEL2 = Build.MODEL;
                                            Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                            if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                                MODEL3 = Build.MODEL;
                                                Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                                if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                                    MANUFACTURER = Build.MANUFACTURER;
                                                    Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                                    if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                        HOST = Build.HOST;
                                                        Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                        if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                            BRAND = Build.BRAND;
                                                            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                            if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                                DEVICE = Build.DEVICE;
                                                                Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                                if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                                    if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                        z = false;
                                                                    }
                                                                }
                                                            } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                z = false;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        FINGERPRINT = Build.FINGERPRINT;
                        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                        if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                            FINGERPRINT2 = Build.FINGERPRINT;
                            Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                            if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                                MODEL = Build.MODEL;
                                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                                    MODEL2 = Build.MODEL;
                                    Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                                    if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                        MODEL3 = Build.MODEL;
                                        Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                        if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                                            MANUFACTURER = Build.MANUFACTURER;
                                            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                            if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                                HOST = Build.HOST;
                                                Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                                if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                                    BRAND = Build.BRAND;
                                                    Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                                    if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                        DEVICE = Build.DEVICE;
                                                        Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                        if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                            if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                                z = false;
                                                            }
                                                        }
                                                    } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                        z = false;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                FINGERPRINT = Build.FINGERPRINT;
                Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                    FINGERPRINT2 = Build.FINGERPRINT;
                    Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
                    if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                        MODEL = Build.MODEL;
                        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                        if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                            MODEL2 = Build.MODEL;
                            Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                            if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                                MODEL3 = Build.MODEL;
                                Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                                if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null) && (!Intrinsics.areEqual("QC_Reference_Phone", Build.BOARD) || StringsKt.equals("Xiaomi", Build.MANUFACTURER, true))) {
                                    MANUFACTURER = Build.MANUFACTURER;
                                    Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                                    if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                        HOST = Build.HOST;
                                        Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                                        if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null)) {
                                            BRAND = Build.BRAND;
                                            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                            if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                                DEVICE = Build.DEVICE;
                                                Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                                if (!StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                                                    if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                        z = false;
                                                    }
                                                }
                                            } else if (!Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                                                z = false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return Boolean.valueOf(z);
        }
    }

    public final SoundPool getSoundpool() {
        return this.soundpool;
    }

    public final void setSoundpool(SoundPool soundPool) {
        Intrinsics.checkNotNullParameter(soundPool, "<set-?>");
        this.soundpool = soundPool;
    }

    public final int getHomeKeyPressedCountSinceLeave() {
        return this.homeKeyPressedCountSinceLeave;
    }

    public final void setHomeKeyPressedCountSinceLeave(int i) {
        this.homeKeyPressedCountSinceLeave = i;
    }

    public final RetroAchievementsManager getRetroAchievementsManager() {
        return this.retroAchievementsManager;
    }

    /* INFO: Access modifiers changed from: private */
    public static final void lifecycleEventObserver$lambda$2(DaijishouApplication this$0, LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_PAUSE) {
            this$0.homeKeyPressedCountSinceLeave = -1;
        }
    }

    private final void muteUntilNotForcingSingleSfxSound() {
        this.forcingSingleSfxSound = true;
        for (Map.Entry<String, MediaPlayer> entry : this.sfxMediaPlayersHashMap.entrySet()) {
            entry.getKey();
            entry.getValue().setVolume(0.0f, 0.0f);
        }
    }

    public static /* synthetic */ void playReachBoundSfx$default(DaijishouApplication daijishouApplication, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        daijishouApplication.playReachBoundSfx(z);
    }

    public final void playReachBoundSfx(boolean force) {
        playSfx("reach_bound", force);
    }

    public static /* synthetic */ void playSfx$default(DaijishouApplication daijishouApplication, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        daijishouApplication.playSfx(str, z);
    }

    public final void playSfx(String sfxId, boolean force) {
        MediaPlayer mediaPlayer;
        Intrinsics.checkNotNullParameter(sfxId, "sfxId");
        if (force) {
            muteUntilNotForcingSingleSfxSound();
        } else if (this.forcingSingleSfxSound) {
            return;
        }
        if (!this.makeButtonSound || (mediaPlayer = this.sfxMediaPlayersHashMap.get(sfxId)) == null) {
            return;
        }
        mediaPlayer.setOnCompletionListener(new DaijishouApplication$$ExternalSyntheticLambda1(this));
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
        mediaPlayer.seekTo(0);
        mediaPlayer.setVolume(1.0f, 1.0f);
        mediaPlayer.start();
    }

    /* INFO: Access modifiers changed from: private */
    public static final void playSfx$lambda$5$lambda$4(DaijishouApplication this$0, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.forcingSingleSfxSound = false;
    }

    private final void setupSounds() {
        Constants.INSTANCE.getSounds().get(Constants.INSTANCE.getSoundIds().indexOf("0")).intValue();
        Constants.INSTANCE.getSounds().get(Constants.INSTANCE.getSoundIds().indexOf(Constants.defaultBackButtonSoundId)).intValue();
        Constants.INSTANCE.getSounds().get(Constants.INSTANCE.getSoundIds().indexOf(Constants.defaultSelectButtonSoundId)).intValue();
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), "make_button_sound", true);
        this.makeButtonSoundPreferenceLiveData = sharedPreferenceBooleanLiveData;
        sharedPreferenceBooleanLiveData.observeForever(new DaijishouApplication$sam$androidx_lifecycle_Observer$0(this.makeButtonSoundPreferenceLiveDataObserver));
        HashMap<String, MediaPlayer> map = this.sfxMediaPlayersHashMap;
        MediaPlayer mediaPlayerCreate = MediaPlayer.create(getBaseContext(), R.raw.navigation);
        Intrinsics.checkNotNullExpressionValue(mediaPlayerCreate, "create(...)");
        map.put(NotificationCompat.CATEGORY_NAVIGATION, mediaPlayerCreate);
        HashMap<String, MediaPlayer> map2 = this.sfxMediaPlayersHashMap;
        MediaPlayer mediaPlayerCreate2 = MediaPlayer.create(getBaseContext(), R.raw.back);
        Intrinsics.checkNotNullExpressionValue(mediaPlayerCreate2, "create(...)");
        map2.put("back", mediaPlayerCreate2);
        HashMap<String, MediaPlayer> map3 = this.sfxMediaPlayersHashMap;
        MediaPlayer mediaPlayerCreate3 = MediaPlayer.create(getBaseContext(), R.raw.back);
        Intrinsics.checkNotNullExpressionValue(mediaPlayerCreate3, "create(...)");
        map3.put("reach_bound", mediaPlayerCreate3);
        HashMap<String, MediaPlayer> map4 = this.sfxMediaPlayersHashMap;
        MediaPlayer mediaPlayerCreate4 = MediaPlayer.create(getBaseContext(), R.raw.accept);
        Intrinsics.checkNotNullExpressionValue(mediaPlayerCreate4, "create(...)");
        map4.put("toggle", mediaPlayerCreate4);
        HashMap<String, MediaPlayer> map5 = this.sfxMediaPlayersHashMap;
        MediaPlayer mediaPlayerCreate5 = MediaPlayer.create(getBaseContext(), R.raw.wooden);
        Intrinsics.checkNotNullExpressionValue(mediaPlayerCreate5, "create(...)");
        map5.put("popup", mediaPlayerCreate5);
        HashMap<String, MediaPlayer> map6 = this.sfxMediaPlayersHashMap;
        MediaPlayer mediaPlayerCreate6 = MediaPlayer.create(getBaseContext(), R.raw.play);
        Intrinsics.checkNotNullExpressionValue(mediaPlayerCreate6, "create(...)");
        map6.put("play", mediaPlayerCreate6);
        HashMap<String, MediaPlayer> map7 = this.sfxMediaPlayersHashMap;
        MediaPlayer mediaPlayerCreate7 = MediaPlayer.create(getBaseContext(), R.raw.accept);
        Intrinsics.checkNotNullExpressionValue(mediaPlayerCreate7, "create(...)");
        map7.put("search", mediaPlayerCreate7);
    }

    public final void notifyServicesUpgradeChance() {
        this.daijishouMainServiceLauncher.notifyUpgradeChance();
        this.daijishouDebugServiceLauncher.notifyUpgradeChance();
    }

    private final void startServices() {
        this.daijishouMainServiceLauncher.startService(false);
    }

    @Override // android.app.Application
    public void onCreate() {
        this.creationTime = System.currentTimeMillis();
        setupStetho();
        startServices();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        setDefaultSharedPreferences(defaultSharedPreferences);
        setBackupAndRestore(new BackupAndRestore(this));
        setGoogleDrive(new GoogleDrive(this));
        setDaijishouUriHandler(new DaijishouUriHandler(this));
        getDaijishouUriHandler().initializeFilesAndDirectories();
        setupUUID();
        setupSounds();
        setupMainActivity();
        DaijishouApplication daijishouApplication = this;
        setDaijishouLibraryRepository(new DaijishouLibraryRepository(daijishouApplication, null, null, 6, null));
        setDaijishouWidgetRepository(new DaijishouWidgetRepository(daijishouApplication, null, 2, null));
        setRetroAchievementsRepository(new RetroAchievementsRepository(daijishouApplication, null, 2, null));
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        setDpToPxConverter(new DpToPxConverter(applicationContext));
        setScraperManager(new ScraperManager(this));
        setWidgetsManager(new WidgetsManager(this, getDefaultSharedPreferences().getBoolean(BooleanPreference.UNLOCK_EXPERIMENTAL.getKey(), BooleanPreference.UNLOCK_EXPERIMENTAL.getDefaultValue())));
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        ConnectionLiveData connectionLiveData = new ConnectionLiveData(applicationContext2);
        this.connectionLiveData = connectionLiveData;
        connectionLiveData.observeForever(new DaijishouApplication$sam$androidx_lifecycle_Observer$0(this.connectionLiveDataObserver));
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue());
        this.useDebugModeLiveData = sharedPreferenceBooleanLiveData;
        sharedPreferenceBooleanLiveData.observeForever(new DaijishouApplication$sam$androidx_lifecycle_Observer$0(this.useDebugModeLiveDataObserver));
        ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(this.lifecycleEventObserver);
        if (!this.retroAchievementsManager.getIsCreated()) {
            this.retroAchievementsManager.onCreate();
        }
        getDaijishouLibraryRepository().getAllVisiblePlatforms().observeForever(new DaijishouApplication$sam$androidx_lifecycle_Observer$0(new AnonymousClass1()));
        super.onCreate();
    }

    /* INFO: renamed from: com.magneticchen.daijishou.DaijishouApplication$onCreate$1, reason: invalid class name */
    /* INFO: compiled from: DaijishouApplication.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function1<List<? extends PlatformEntity>, Unit> {
        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlatformEntity> list) {
            invoke2((List<PlatformEntity>) list);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<PlatformEntity> list) {
            Intrinsics.checkNotNull(list);
            List<PlatformEntity> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((PlatformEntity) it.next()).getRetroAchievementsConsoleIdList());
            }
            DaijishouApplication.this.getRetroAchievementsManager().setConsoleWatchlist(CollectionsKt.flatten(arrayList));
        }
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        this.logger.debug(this, "onTerminate");
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = this.makeButtonSoundPreferenceLiveData;
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData2 = null;
        if (sharedPreferenceBooleanLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeButtonSoundPreferenceLiveData");
            sharedPreferenceBooleanLiveData = null;
        }
        sharedPreferenceBooleanLiveData.removeObserver(new DaijishouApplication$sam$androidx_lifecycle_Observer$0(this.makeButtonSoundPreferenceLiveDataObserver));
        ConnectionLiveData connectionLiveData = this.connectionLiveData;
        if (connectionLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionLiveData");
            connectionLiveData = null;
        }
        connectionLiveData.removeObserver(new DaijishouApplication$sam$androidx_lifecycle_Observer$0(this.connectionLiveDataObserver));
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData3 = this.useDebugModeLiveData;
        if (sharedPreferenceBooleanLiveData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("useDebugModeLiveData");
        } else {
            sharedPreferenceBooleanLiveData2 = sharedPreferenceBooleanLiveData3;
        }
        sharedPreferenceBooleanLiveData2.removeObserver(new DaijishouApplication$sam$androidx_lifecycle_Observer$0(this.useDebugModeLiveDataObserver));
        this.retroAchievementsManager.onTerminate();
        stopAllServices();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    public final void stopAllServices() {
        this.daijishouDebugServiceLauncher.stopService();
        this.daijishouMainServiceLauncher.stopService();
    }
}
