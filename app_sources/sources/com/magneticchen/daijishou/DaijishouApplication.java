package com.magneticchen.daijishou;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.preference.PreferenceManager;
import com.magneticchen.daijishou.cache.CachedBitmapLoader;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.backup.BackupAndRestore;
import com.magneticchen.daijishou.data.db.ExtensionDatabase;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.repositories.DaijishouExtensionRepository;
import com.magneticchen.daijishou.data.db.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.data.db.repositories.DaijishouWidgetRepository;
import com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository;
import com.magneticchen.daijishou.data.live.ConnectionLiveData;
import com.magneticchen.daijishou.data.live.SharedPreferenceBooleanLiveData;
import com.magneticchen.daijishou.data.scraper.ScraperManager;
import com.magneticchen.daijishou.features.AudioManager;
import com.magneticchen.daijishou.features.GoogleDrive;
import com.magneticchen.daijishou.features.Soundboard;
import com.magneticchen.daijishou.features.retroachievements.RetroAchievementsManager;
import com.magneticchen.daijishou.logger.Logger;
import com.magneticchen.daijishou.service.debug.DaijishouDebugService;
import com.magneticchen.daijishou.ui.activities.DaijishouMainService;
import com.magneticchen.daijishou.ui.activities.MainActivity;
import com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouServiceLauncher;
import com.magneticchen.daijishou.ui.widget.WidgetsManager;
import com.magneticchen.daijishou.utils.DaijishouUriHandler;
import com.magneticchen.daijishou.utils.DpToPxConverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Deprecated;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* JADX INFO: compiled from: DaijishouApplication.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002±\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0007\u0010¡\u0001\u001a\u00020#J\t\u0010¢\u0001\u001a\u00020#H\u0016J\t\u0010£\u0001\u001a\u00020#H\u0017J\t\u0010¤\u0001\u001a\u00020#H\u0016J\u0012\u0010¥\u0001\u001a\u00020#2\u0007\u0010¦\u0001\u001a\u00020\"H\u0016J\u001b\u0010§\u0001\u001a\u00020@2\u0007\u0010¨\u0001\u001a\u00020@2\t\b\u0002\u0010©\u0001\u001a\u00020^J\u0012\u0010ª\u0001\u001a\u00020@2\u0007\u0010«\u0001\u001a\u00020@H\u0002J\t\u0010¬\u0001\u001a\u00020#H\u0002J\t\u0010\u00ad\u0001\u001a\u00020#H\u0002J\u0007\u0010®\u0001\u001a\u00020#J\u001b\u0010¯\u0001\u001a\u00020#2\u0007\u0010«\u0001\u001a\u00020@2\u0007\u0010°\u0001\u001a\u00020@H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u001a\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u001c\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020=0,¢\u0006\b\n\u0000\u001a\u0004\b>\u0010/R\u001a\u0010?\u001a\u00020@X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020FX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020LX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020RX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001a\u0010W\u001a\u00020XX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u000e\u0010]\u001a\u00020^X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010_\u001a\u00020`X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001a\u0010j\u001a\u00020^X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020^X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010l\"\u0004\bp\u0010nR\u000e\u0010q\u001a\u00020rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010s\u001a\u00060tR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u001c\u0010w\u001a\u0004\u0018\u00010xX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0012\u0010}\u001a\u00020~¢\u0006\t\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001R \u0010\u0081\u0001\u001a\u00030\u0082\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R \u0010\u0087\u0001\u001a\u00030\u0088\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R!\u0010\u008d\u0001\u001a\u00030\u008e\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u000f\u0010\u0093\u0001\u001a\u00020^X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0094\u0001\u001a\u00030\u0095\u0001X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0096\u0001\u001a\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020#0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0097\u0001\u001a\u00030\u0098\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R \u0010\u009b\u0001\u001a\u00030\u009c\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001¨\u0006²\u0001"}, d2 = {"Lcom/magneticchen/daijishou/DaijishouApplication;", "Landroid/app/Application;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "audioManager", "Lcom/magneticchen/daijishou/features/AudioManager;", "getAudioManager", "()Lcom/magneticchen/daijishou/features/AudioManager;", "setAudioManager", "(Lcom/magneticchen/daijishou/features/AudioManager;)V", "backupAndRestore", "Lcom/magneticchen/daijishou/data/backup/BackupAndRestore;", "getBackupAndRestore", "()Lcom/magneticchen/daijishou/data/backup/BackupAndRestore;", "setBackupAndRestore", "(Lcom/magneticchen/daijishou/data/backup/BackupAndRestore;)V", "bitmapLoaderDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "cachedBoxArtBitmapLoader", "Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;", "getCachedBoxArtBitmapLoader", "()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;", "cachedPlatformThumbnailBitmapLoader", "getCachedPlatformThumbnailBitmapLoader", "cachedPlatformWallpaperBitmapLoader", "getCachedPlatformWallpaperBitmapLoader", "cachedSnapshotBitmapLoader", "getCachedSnapshotBitmapLoader", "cachedTitleBitmapLoader", "getCachedTitleBitmapLoader", "connectionLiveData", "Lcom/magneticchen/daijishou/data/live/ConnectionLiveData;", "connectionLiveDataObserver", "Lkotlin/Function1;", "", "", "connectionType", "creationTime", "", "getCreationTime", "()J", "setCreationTime", "(J)V", "daijishouDebugServiceLauncher", "Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouServiceLauncher;", "Lcom/magneticchen/daijishou/service/debug/DaijishouDebugService;", "getDaijishouDebugServiceLauncher", "()Lcom/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouServiceLauncher;", "daijishouExtensionRepository", "Lcom/magneticchen/daijishou/data/db/repositories/DaijishouExtensionRepository;", "getDaijishouExtensionRepository", "()Lcom/magneticchen/daijishou/data/db/repositories/DaijishouExtensionRepository;", "setDaijishouExtensionRepository", "(Lcom/magneticchen/daijishou/data/db/repositories/DaijishouExtensionRepository;)V", "daijishouLibraryRepository", "Lcom/magneticchen/daijishou/data/db/repositories/DaijishouLibraryRepository;", "getDaijishouLibraryRepository", "()Lcom/magneticchen/daijishou/data/db/repositories/DaijishouLibraryRepository;", "setDaijishouLibraryRepository", "(Lcom/magneticchen/daijishou/data/db/repositories/DaijishouLibraryRepository;)V", "daijishouMainServiceLauncher", "Lcom/magneticchen/daijishou/ui/activities/DaijishouMainService;", "getDaijishouMainServiceLauncher", "daijishouUUID", "", "getDaijishouUUID", "()Ljava/lang/String;", "setDaijishouUUID", "(Ljava/lang/String;)V", "daijishouUriHandler", "Lcom/magneticchen/daijishou/utils/DaijishouUriHandler;", "getDaijishouUriHandler", "()Lcom/magneticchen/daijishou/utils/DaijishouUriHandler;", "setDaijishouUriHandler", "(Lcom/magneticchen/daijishou/utils/DaijishouUriHandler;)V", "daijishouWidgetRepository", "Lcom/magneticchen/daijishou/data/db/repositories/DaijishouWidgetRepository;", "getDaijishouWidgetRepository", "()Lcom/magneticchen/daijishou/data/db/repositories/DaijishouWidgetRepository;", "setDaijishouWidgetRepository", "(Lcom/magneticchen/daijishou/data/db/repositories/DaijishouWidgetRepository;)V", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "getDefaultSharedPreferences", "()Landroid/content/SharedPreferences;", "setDefaultSharedPreferences", "(Landroid/content/SharedPreferences;)V", "dpToPxConverter", "Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "getDpToPxConverter", "()Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "setDpToPxConverter", "(Lcom/magneticchen/daijishou/utils/DpToPxConverter;)V", "firstTime", "", "googleDrive", "Lcom/magneticchen/daijishou/features/GoogleDrive;", "getGoogleDrive", "()Lcom/magneticchen/daijishou/features/GoogleDrive;", "setGoogleDrive", "(Lcom/magneticchen/daijishou/features/GoogleDrive;)V", "homeKeyPressedCountSinceLeave", "getHomeKeyPressedCountSinceLeave", "()I", "setHomeKeyPressedCountSinceLeave", "(I)V", "initialized", "getInitialized", "()Z", "setInitialized", "(Z)V", "isInitializing", "setInitializing", "lifecycleEventObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "mainActivity", "Lcom/magneticchen/daijishou/ui/activities/MainActivity;", "getMainActivity", "()Lcom/magneticchen/daijishou/ui/activities/MainActivity;", "setMainActivity", "(Lcom/magneticchen/daijishou/ui/activities/MainActivity;)V", "retroAchievementsManager", "Lcom/magneticchen/daijishou/features/retroachievements/RetroAchievementsManager;", "getRetroAchievementsManager", "()Lcom/magneticchen/daijishou/features/retroachievements/RetroAchievementsManager;", "retroAchievementsRepository", "Lcom/magneticchen/daijishou/data/db/repositories/RetroAchievementsRepository;", "getRetroAchievementsRepository", "()Lcom/magneticchen/daijishou/data/db/repositories/RetroAchievementsRepository;", "setRetroAchievementsRepository", "(Lcom/magneticchen/daijishou/data/db/repositories/RetroAchievementsRepository;)V", "scraperManager", "Lcom/magneticchen/daijishou/data/scraper/ScraperManager;", "getScraperManager", "()Lcom/magneticchen/daijishou/data/scraper/ScraperManager;", "setScraperManager", "(Lcom/magneticchen/daijishou/data/scraper/ScraperManager;)V", "soundboard", "Lcom/magneticchen/daijishou/features/Soundboard;", "getSoundboard", "()Lcom/magneticchen/daijishou/features/Soundboard;", "soundboard$delegate", "Lkotlin/Lazy;", "useDebugMode", "useDebugModeLiveData", "Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;", "useDebugModeLiveDataObserver", "weakJson", "Lkotlinx/serialization/json/Json;", "getWeakJson", "()Lkotlinx/serialization/json/Json;", "widgetsManager", "Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;", "getWidgetsManager", "()Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;", "setWidgetsManager", "(Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;)V", "notifyServicesUpgradeChance", "onCreate", "onLowMemory", "onTerminate", "onTrimMemory", "level", "prettifyTitle", "title", "showDiscIndex", "readFromFile", "filename", "setupUUID", "startServices", "stopAllServices", "writeToFile", "data", "WrappedLogger", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouApplication extends Application implements LifecycleObserver {
    public AudioManager audioManager;
    public BackupAndRestore backupAndRestore;
    private final ExecutorCoroutineDispatcher bitmapLoaderDispatcher;
    private final CachedBitmapLoader cachedBoxArtBitmapLoader;
    private final CachedBitmapLoader cachedPlatformThumbnailBitmapLoader;
    private final CachedBitmapLoader cachedPlatformWallpaperBitmapLoader;
    private final CachedBitmapLoader cachedSnapshotBitmapLoader;
    private final CachedBitmapLoader cachedTitleBitmapLoader;
    private ConnectionLiveData connectionLiveData;
    private final Function1<Integer, Unit> connectionLiveDataObserver;
    private int connectionType;
    private long creationTime;
    public DaijishouExtensionRepository daijishouExtensionRepository;
    public DaijishouLibraryRepository daijishouLibraryRepository;
    public String daijishouUUID;
    public DaijishouUriHandler daijishouUriHandler;
    public DaijishouWidgetRepository daijishouWidgetRepository;
    public SharedPreferences defaultSharedPreferences;
    public DpToPxConverter dpToPxConverter;
    private boolean firstTime;
    public GoogleDrive googleDrive;
    private int homeKeyPressedCountSinceLeave;
    private boolean initialized;
    private boolean isInitializing;
    private final LifecycleEventObserver lifecycleEventObserver;
    private MainActivity mainActivity;
    public RetroAchievementsRepository retroAchievementsRepository;
    public ScraperManager scraperManager;
    private boolean useDebugMode;
    private SharedPreferenceBooleanLiveData useDebugModeLiveData;
    private final Function1<Boolean, Unit> useDebugModeLiveDataObserver;
    public WidgetsManager widgetsManager;
    private final WrappedLogger logger = new WrappedLogger();
    private final RetroAchievementsManager retroAchievementsManager = new RetroAchievementsManager(this);
    private final Json weakJson = JsonKt.Json$default((Json) null, new Function1<JsonBuilder, Unit>() { // from class: com.magneticchen.daijishou.DaijishouApplication$weakJson$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
            invoke2(jsonBuilder);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.setIgnoreUnknownKeys(true);
        }
    }, 1, (Object) null);
    private final Lazy soundboard$delegate = LazyKt.lazy(new Function0<Soundboard>() { // from class: com.magneticchen.daijishou.DaijishouApplication$soundboard$2
        

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Soundboard invoke() {
            return new Soundboard(DaijishouApplication.this);
        }
    });
    private final DaijishouServiceLauncher<DaijishouDebugService> daijishouDebugServiceLauncher = new DaijishouServiceLauncher<>(this, DaijishouDebugService.class);
    private final DaijishouServiceLauncher<DaijishouMainService> daijishouMainServiceLauncher = new DaijishouServiceLauncher<>(this, DaijishouMainService.class);

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
        this.connectionLiveDataObserver = new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.DaijishouApplication$connectionLiveDataObserver$1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                DaijishouApplication.this.connectionType = i;
            }
        };
        this.firstTime = true;
        this.useDebugModeLiveDataObserver = new DaijishouApplication$useDebugModeLiveDataObserver$1(this);
        this.lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.magneticchen.daijishou.DaijishouApplication$$ExternalSyntheticLambda0
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                DaijishouApplication.lifecycleEventObserver$lambda$4(DaijishouApplication.this, lifecycleOwner, event);
            }
        };
    }

    public final WrappedLogger getLogger() {
        return this.logger;
    }

    public final boolean getInitialized() {
        return this.initialized;
    }

    public final void setInitialized(boolean z) {
        this.initialized = z;
    }

    public final boolean isInitializing() {
        return this.isInitializing;
    }

    public final void setInitializing(boolean z) {
        this.isInitializing = z;
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

    public final AudioManager getAudioManager() {
        AudioManager audioManager = this.audioManager;
        if (audioManager != null) {
            return audioManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("audioManager");
        return null;
    }

    public final void setAudioManager(AudioManager audioManager) {
        Intrinsics.checkNotNullParameter(audioManager, "<set-?>");
        this.audioManager = audioManager;
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

    public final DaijishouExtensionRepository getDaijishouExtensionRepository() {
        DaijishouExtensionRepository daijishouExtensionRepository = this.daijishouExtensionRepository;
        if (daijishouExtensionRepository != null) {
            return daijishouExtensionRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("daijishouExtensionRepository");
        return null;
    }

    public final void setDaijishouExtensionRepository(DaijishouExtensionRepository daijishouExtensionRepository) {
        Intrinsics.checkNotNullParameter(daijishouExtensionRepository, "<set-?>");
        this.daijishouExtensionRepository = daijishouExtensionRepository;
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

    public final Soundboard getSoundboard() {
        return (Soundboard) this.soundboard$delegate.getValue();
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

    public final String prettifyTitle(String title, boolean z) {
        List<String> groupValues;
        String str;
        MatchResult matchResultFind$default;
        List<String> groupValues2;
        Intrinsics.checkNotNullParameter(title, "title");
        if (getDefaultSharedPreferences().getBoolean(BooleanPreference.PRETTIFY_TITLES.getKey(), BooleanPreference.PRETTIFY_TITLES.getDefaultValue())) {
            String str2 = (!z || (matchResultFind$default = Regex.find$default(Constants.INSTANCE.getDiscIndexRegex(), title, 0, 2, null)) == null || (groupValues2 = matchResultFind$default.getGroupValues()) == null) ? null : groupValues2.get(1);
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

    private final void setupUUID() {
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
            java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(applicationContext.openFileOutput(filename, 0));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (java.io.IOException e) {
            this.logger.error(this, "File write failed: " + e);
        }
    }

    private final String readFromFile(String filename) {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        try {
            java.io.FileInputStream fileInputStreamOpenFileInput = applicationContext.openFileInput(filename);
            Intrinsics.checkNotNullExpressionValue(fileInputStreamOpenFileInput, "openFileInput(...)");
            java.io.FileInputStream fileInputStream = fileInputStreamOpenFileInput;
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(fileInputStream));
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
        } catch (java.io.FileNotFoundException e) {
            this.logger.error(this, "File not found: " + e);
            return "";
        } catch (java.io.IOException e2) {
            this.logger.error(this, "File read failed: " + e2);
            return "";
        }
    }

    /* JADX INFO: compiled from: DaijishouApplication.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0005J\u0016\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0005J\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0005J \u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0016\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0005J\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010 R\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "components", "Ljava/util/SortedSet;", "", "getComponents", "()Ljava/util/SortedSet;", "latestLogRecordLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/magneticchen/daijishou/logger/Logger$LogRecord;", "getLatestLogRecordLiveData", "()Landroidx/lifecycle/LiveData;", "logs", "", "getLogs", "()Ljava/util/List;", "tag", "getTag", "()Ljava/lang/String;", "clear", "", "debug", "fromComponent", "message", "error", "info", "printLog", "LoggerCode", "", "warn", "throwable", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        private final void printLog(Object obj, int i, String str) {
            String simpleName = obj instanceof String ? (String) obj : obj.getClass().getSimpleName();
            if (i == -1) {
                Log.i(Logger.TAG, "[" + simpleName + "] " + str);
                return;
            }
            if (i == 0) {
                Log.i(Logger.TAG, "[" + simpleName + "] " + str);
                return;
            }
            if (i == 1) {
                Log.d(Logger.TAG, "[" + simpleName + "] " + str);
            } else if (i == 2) {
                Log.w(Logger.TAG, "[" + simpleName + "] " + str);
            } else {
                if (i != 3) {
                    return;
                }
                Log.e(Logger.TAG, "[" + simpleName + "] " + str);
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

        public final void warn(Object fromComponent, Throwable th) {
            Intrinsics.checkNotNullParameter(fromComponent, "fromComponent");
            if (th == null) {
                return;
            }
            DaijishouMainService daijishouMainService = (DaijishouMainService) DaijishouApplication.this.getDaijishouMainServiceLauncher().getService();
            Logger logger = daijishouMainService != null ? daijishouMainService.getLogger() : null;
            if (logger == null) {
                printLog(fromComponent, 2, ExceptionsKt.stackTraceToString(th));
            } else {
                logger.warn(fromComponent, ExceptionsKt.stackTraceToString(th));
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lifecycleEventObserver$lambda$4(DaijishouApplication this$0, LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_PAUSE) {
            this$0.homeKeyPressedCountSinceLeave = -1;
            this$0.getAudioManager().pause();
        }
        if (event == Lifecycle.Event.ON_RESUME) {
            this$0.getAudioManager().resume();
        }
    }

    public final void notifyServicesUpgradeChance() {
        this.daijishouMainServiceLauncher.notifyUpgradeChance();
        this.daijishouDebugServiceLauncher.notifyUpgradeChance();
    }

    private final void startServices() {
        this.daijishouMainServiceLauncher.startService(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application
    public void onCreate() {
        this.creationTime = System.currentTimeMillis();
        startServices();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        setDefaultSharedPreferences(defaultSharedPreferences);
        setBackupAndRestore(new BackupAndRestore(this));
        setGoogleDrive(new GoogleDrive(this));
        setDaijishouUriHandler(new DaijishouUriHandler(this));
        getDaijishouUriHandler().initializeFilesAndDirectories();
        setupUUID();
        DaijishouApplication daijishouApplication = this;
        setDaijishouLibraryRepository(new DaijishouLibraryRepository(daijishouApplication, null, null, 6, null));
        int i = 2;
        setDaijishouWidgetRepository(new DaijishouWidgetRepository(daijishouApplication, null, 2, null));
        setRetroAchievementsRepository(new RetroAchievementsRepository(daijishouApplication, null, 2, null));
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        setDpToPxConverter(new DpToPxConverter(applicationContext));
        setScraperManager(new ScraperManager(this));
        setWidgetsManager(new WidgetsManager(this));
        setAudioManager(new AudioManager(this));
        deleteDatabase(ExtensionDatabase.DB_NAME);
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        ConnectionLiveData connectionLiveData = new ConnectionLiveData(applicationContext2);
        this.connectionLiveData = connectionLiveData;
        connectionLiveData.observeForever(new DaijishouApplication$sam$androidx_lifecycle_Observer$0(this.connectionLiveDataObserver));
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = new SharedPreferenceBooleanLiveData(getDefaultSharedPreferences(), BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue());
        this.useDebugModeLiveData = sharedPreferenceBooleanLiveData;
        sharedPreferenceBooleanLiveData.observeForever(new DaijishouApplication$sam$androidx_lifecycle_Observer$0(this.useDebugModeLiveDataObserver));
        ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(this.lifecycleEventObserver);
        if (!this.retroAchievementsManager.isCreated()) {
            this.retroAchievementsManager.onCreate();
        }
        getDaijishouLibraryRepository().getAllVisiblePlatforms().observeForever(new DaijishouApplication$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends PlatformEntity>, Unit>() { // from class: com.magneticchen.daijishou.DaijishouApplication.onCreate.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlatformEntity> list) {
                invoke2((List<PlatformEntity>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<PlatformEntity> list) {
                Intrinsics.checkNotNull(list);
                List<PlatformEntity> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<PlatformEntity> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((PlatformEntity) it.next()).getRetroAchievementsConsoleIdList());
                }
                DaijishouApplication.this.getRetroAchievementsManager().setConsoleWatchlist(CollectionsKt.flatten(arrayList));
            }
        }));
        super.onCreate();
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        this.logger.debug(this, "onTerminate");
        getSoundboard().onDestroy();
        ConnectionLiveData connectionLiveData = this.connectionLiveData;
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData = null;
        if (connectionLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionLiveData");
            connectionLiveData = null;
        }
        connectionLiveData.removeObserver(new DaijishouApplication$sam$androidx_lifecycle_Observer$0(this.connectionLiveDataObserver));
        SharedPreferenceBooleanLiveData sharedPreferenceBooleanLiveData2 = this.useDebugModeLiveData;
        if (sharedPreferenceBooleanLiveData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("useDebugModeLiveData");
        } else {
            sharedPreferenceBooleanLiveData = sharedPreferenceBooleanLiveData2;
        }
        sharedPreferenceBooleanLiveData.removeObserver(new DaijishouApplication$sam$androidx_lifecycle_Observer$0(this.useDebugModeLiveDataObserver));
        this.retroAchievementsManager.onTerminate();
        stopAllServices();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    @Deprecated(message = "Deprecated in Java")
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
    }

    public final void stopAllServices() {
        this.daijishouDebugServiceLauncher.stopService();
        this.daijishouMainServiceLauncher.stopService();
    }
}
