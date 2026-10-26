package com.magneticchen.daijishou.view_models;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.ViewModelLazy;
import androidx.preference.PreferenceManager;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_library_db.Genre;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemToGenrePairEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayerEntity;
import com.magneticchen.daijishou.daijishou_player.DaijishouPlayerTemplate;
import com.magneticchen.daijishou.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.scraper.ScraperManager;
import com.magneticchen.daijishou.scraper.ScraperUtilsKt;
import com.magneticchen.daijishou.utils.LazyMd5;
import com.magneticchen.daijishou.utils.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.io.IOUtils;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: SynchronizationOfPlatform.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\b\u0086\b\u0018\u0000 m2\u00020\u0001:\u0001mB\u008b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r¢\u0006\u0002\u0010\u0019J\b\u0010L\u001a\u00020-H\u0002J\u000e\u0010M\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010N\u001a\u00020\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016HÆ\u0003J\u000f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016HÆ\u0003J\t\u0010R\u001a\u00020\rHÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0007HÆ\u0003J\t\u0010U\u001a\u00020\tHÆ\u0003J\t\u0010V\u001a\u00020\u000bHÆ\u0003J\t\u0010W\u001a\u00020\rHÆ\u0003J\t\u0010X\u001a\u00020\u000fHÆ\u0003J\t\u0010Y\u001a\u00020\u0011HÆ\u0003J\t\u0010Z\u001a\u00020\u000fHÆ\u0003J\u0099\u0001\u0010[\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00162\b\b\u0002\u0010\u0018\u001a\u00020\rHÆ\u0001J\u0013\u0010\\\u001a\u00020\r2\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010^\u001a\u00020\u00112\u0006\u0010_\u001a\u00020\u0011H\u0002J\u0006\u0010`\u001a\u00020\rJ\t\u0010a\u001a\u00020\u000fHÖ\u0001J\u0006\u0010b\u001a\u00020-J\u000e\u0010c\u001a\u00020-2\u0006\u0010d\u001a\u00020eJ\b\u0010f\u001a\u00020-H\u0002J+\u0010g\u001a\u00020-2#\u0010'\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010)¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-0(J\u0014\u0010h\u001a\u00020-2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020-0IJ\u0006\u0010i\u001a\u00020-J\u0006\u0010j\u001a\u00020-J\u0010\u0010k\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\t\u0010l\u001a\u00020\u0011HÖ\u0001R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n &*\u0004\u0018\u00010%0%X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010'\u001a!\u0012\u0015\u0012\u0013\u0018\u00010)¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010/\"\u0004\b2\u00101R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0012\u00107\u001a\u000608R\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016¢\u0006\b\n\u0000\u001a\u0004\b=\u0010<R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u001a\u0010\u0012\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0016\u0010H\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010A\"\u0004\bK\u0010C¨\u0006n²\u0006\n\u0010o\u001a\u00020pX\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/view_models/SynchronizationOfPlatform;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "platformId", "", "daijishouLibraryRepository", "Lcom/magneticchen/daijishou/repositories/DaijishouLibraryRepository;", "scraperManager", "Lcom/magneticchen/daijishou/scraper/ScraperManager;", "isSyncing", "", "syncProgress", "", "statusString", "", "statusCode", "job", "Lkotlinx/coroutines/Job;", "playableItemEntityToBeScrapedIdList", "", "playableItemEntityPreviewMediaMustBeScrapedIdList", "fullSynchronization", "(Lcom/magneticchen/daijishou/DaijishouApplication;Lkotlinx/coroutines/CoroutineScope;JLcom/magneticchen/daijishou/repositories/DaijishouLibraryRepository;Lcom/magneticchen/daijishou/scraper/ScraperManager;ZILjava/lang/String;ILkotlinx/coroutines/Job;Ljava/util/List;Ljava/util/List;Z)V", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getDaijishouLibraryRepository", "()Lcom/magneticchen/daijishou/repositories/DaijishouLibraryRepository;", "daijishouPlayerTemplate", "Lcom/magneticchen/daijishou/daijishou_player/DaijishouPlayerTemplate;", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "finishedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "e", "", "getFullSynchronization", "()Z", "setFullSynchronization", "(Z)V", "setSyncing", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "getPlatformId", "()J", "getPlayableItemEntityPreviewMediaMustBeScrapedIdList", "()Ljava/util/List;", "getPlayableItemEntityToBeScrapedIdList", "getScraperManager", "()Lcom/magneticchen/daijishou/scraper/ScraperManager;", "getStatusCode", "()I", "setStatusCode", "(I)V", "getStatusString", "()Ljava/lang/String;", "setStatusString", "(Ljava/lang/String;)V", "statusUpdatedListener", "Lkotlin/Function0;", "getSyncProgress", "setSyncProgress", "aggregatePlayableItems", "attachActivity", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "generalizeTitleForDisjointSets", "title", "hasAnyTask", "hashCode", "requestFullSynchronization", "requestScrapingOfPlayableItem", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "scrapePlayableItems", "setOnFinishedListener", "setOnStatusUpdatedListener", "stopSyncing", "synchronize", "synchronizePlayableItems", "toString", "Companion", "app_release", "appsViewModel", "Lcom/magneticchen/daijishou/view_models/AppsViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class SynchronizationOfPlatform {
    public static final int IS_AGGREGATING_PLAYABLE_ITEMS = 3;
    public static final int IS_NOT_SYNCING = 0;
    public static final int IS_PREPARING_SYNCHRONIZATION = 1;
    public static final int IS_SCRAPING_PLAYABLE_ITEMS = 4;
    public static final int IS_SYNCING_PLAYABLE_ITEMS = 2;
    private AppCompatActivity activity;
    private final DaijishouApplication application;
    private final CoroutineScope coroutineScope;
    private final DaijishouLibraryRepository daijishouLibraryRepository;
    private final DaijishouPlayerTemplate daijishouPlayerTemplate;
    private final SharedPreferences defaultSharedPreferences;
    public Function1<? super Throwable, Unit> finishedListener;
    private boolean fullSynchronization;
    private boolean isSyncing;
    private Job job;
    private final DaijishouApplication.WrappedLogger logger;
    private final long platformId;
    private final List<Long> playableItemEntityPreviewMediaMustBeScrapedIdList;
    private final List<Long> playableItemEntityToBeScrapedIdList;
    private final ScraperManager scraperManager;
    private int statusCode;
    private String statusString;
    private Function0<Unit> statusUpdatedListener;
    private int syncProgress;

    /* INFO: renamed from: component1, reason: from getter */
    public final DaijishouApplication getApplication() {
        return this.application;
    }

    /* INFO: renamed from: component10, reason: from getter */
    public final Job getJob() {
        return this.job;
    }

    public final List<Long> component11() {
        return this.playableItemEntityToBeScrapedIdList;
    }

    public final List<Long> component12() {
        return this.playableItemEntityPreviewMediaMustBeScrapedIdList;
    }

    /* INFO: renamed from: component13, reason: from getter */
    public final boolean getFullSynchronization() {
        return this.fullSynchronization;
    }

    /* INFO: renamed from: component2, reason: from getter */
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    /* INFO: renamed from: component3, reason: from getter */
    public final long getPlatformId() {
        return this.platformId;
    }

    /* INFO: renamed from: component4, reason: from getter */
    public final DaijishouLibraryRepository getDaijishouLibraryRepository() {
        return this.daijishouLibraryRepository;
    }

    /* INFO: renamed from: component5, reason: from getter */
    public final ScraperManager getScraperManager() {
        return this.scraperManager;
    }

    /* INFO: renamed from: component6, reason: from getter */
    public final boolean getIsSyncing() {
        return this.isSyncing;
    }

    /* INFO: renamed from: component7, reason: from getter */
    public final int getSyncProgress() {
        return this.syncProgress;
    }

    /* INFO: renamed from: component8, reason: from getter */
    public final String getStatusString() {
        return this.statusString;
    }

    /* INFO: renamed from: component9, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    public final SynchronizationOfPlatform copy(DaijishouApplication application, CoroutineScope coroutineScope, long platformId, DaijishouLibraryRepository daijishouLibraryRepository, ScraperManager scraperManager, boolean isSyncing, int syncProgress, String statusString, int statusCode, Job job, List<Long> playableItemEntityToBeScrapedIdList, List<Long> playableItemEntityPreviewMediaMustBeScrapedIdList, boolean fullSynchronization) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(daijishouLibraryRepository, "daijishouLibraryRepository");
        Intrinsics.checkNotNullParameter(scraperManager, "scraperManager");
        Intrinsics.checkNotNullParameter(statusString, "statusString");
        Intrinsics.checkNotNullParameter(playableItemEntityToBeScrapedIdList, "playableItemEntityToBeScrapedIdList");
        Intrinsics.checkNotNullParameter(playableItemEntityPreviewMediaMustBeScrapedIdList, "playableItemEntityPreviewMediaMustBeScrapedIdList");
        return new SynchronizationOfPlatform(application, coroutineScope, platformId, daijishouLibraryRepository, scraperManager, isSyncing, syncProgress, statusString, statusCode, job, playableItemEntityToBeScrapedIdList, playableItemEntityPreviewMediaMustBeScrapedIdList, fullSynchronization);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SynchronizationOfPlatform)) {
            return false;
        }
        SynchronizationOfPlatform synchronizationOfPlatform = (SynchronizationOfPlatform) other;
        return Intrinsics.areEqual(this.application, synchronizationOfPlatform.application) && Intrinsics.areEqual(this.coroutineScope, synchronizationOfPlatform.coroutineScope) && this.platformId == synchronizationOfPlatform.platformId && Intrinsics.areEqual(this.daijishouLibraryRepository, synchronizationOfPlatform.daijishouLibraryRepository) && Intrinsics.areEqual(this.scraperManager, synchronizationOfPlatform.scraperManager) && this.isSyncing == synchronizationOfPlatform.isSyncing && this.syncProgress == synchronizationOfPlatform.syncProgress && Intrinsics.areEqual(this.statusString, synchronizationOfPlatform.statusString) && this.statusCode == synchronizationOfPlatform.statusCode && Intrinsics.areEqual(this.job, synchronizationOfPlatform.job) && Intrinsics.areEqual(this.playableItemEntityToBeScrapedIdList, synchronizationOfPlatform.playableItemEntityToBeScrapedIdList) && Intrinsics.areEqual(this.playableItemEntityPreviewMediaMustBeScrapedIdList, synchronizationOfPlatform.playableItemEntityPreviewMediaMustBeScrapedIdList) && this.fullSynchronization == synchronizationOfPlatform.fullSynchronization;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.application.hashCode() * 31) + this.coroutineScope.hashCode()) * 31) + Long.hashCode(this.platformId)) * 31) + this.daijishouLibraryRepository.hashCode()) * 31) + this.scraperManager.hashCode()) * 31) + Boolean.hashCode(this.isSyncing)) * 31) + Integer.hashCode(this.syncProgress)) * 31) + this.statusString.hashCode()) * 31) + Integer.hashCode(this.statusCode)) * 31;
        Job job = this.job;
        return ((((((iHashCode + (job == null ? 0 : job.hashCode())) * 31) + this.playableItemEntityToBeScrapedIdList.hashCode()) * 31) + this.playableItemEntityPreviewMediaMustBeScrapedIdList.hashCode()) * 31) + Boolean.hashCode(this.fullSynchronization);
    }

    public String toString() {
        return "SynchronizationOfPlatform(application=" + this.application + ", coroutineScope=" + this.coroutineScope + ", platformId=" + this.platformId + ", daijishouLibraryRepository=" + this.daijishouLibraryRepository + ", scraperManager=" + this.scraperManager + ", isSyncing=" + this.isSyncing + ", syncProgress=" + this.syncProgress + ", statusString=" + this.statusString + ", statusCode=" + this.statusCode + ", job=" + this.job + ", playableItemEntityToBeScrapedIdList=" + this.playableItemEntityToBeScrapedIdList + ", playableItemEntityPreviewMediaMustBeScrapedIdList=" + this.playableItemEntityPreviewMediaMustBeScrapedIdList + ", fullSynchronization=" + this.fullSynchronization + ")";
    }

    public SynchronizationOfPlatform(DaijishouApplication application, CoroutineScope coroutineScope, long j, DaijishouLibraryRepository daijishouLibraryRepository, ScraperManager scraperManager, boolean z, int i, String statusString, int i2, Job job, List<Long> playableItemEntityToBeScrapedIdList, List<Long> playableItemEntityPreviewMediaMustBeScrapedIdList, boolean z2) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(daijishouLibraryRepository, "daijishouLibraryRepository");
        Intrinsics.checkNotNullParameter(scraperManager, "scraperManager");
        Intrinsics.checkNotNullParameter(statusString, "statusString");
        Intrinsics.checkNotNullParameter(playableItemEntityToBeScrapedIdList, "playableItemEntityToBeScrapedIdList");
        Intrinsics.checkNotNullParameter(playableItemEntityPreviewMediaMustBeScrapedIdList, "playableItemEntityPreviewMediaMustBeScrapedIdList");
        this.application = application;
        this.coroutineScope = coroutineScope;
        this.platformId = j;
        this.daijishouLibraryRepository = daijishouLibraryRepository;
        this.scraperManager = scraperManager;
        this.isSyncing = z;
        this.syncProgress = i;
        this.statusString = statusString;
        this.statusCode = i2;
        this.job = job;
        this.playableItemEntityToBeScrapedIdList = playableItemEntityToBeScrapedIdList;
        this.playableItemEntityPreviewMediaMustBeScrapedIdList = playableItemEntityPreviewMediaMustBeScrapedIdList;
        this.fullSynchronization = z2;
        this.logger = application.getLogger();
        this.defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application.getApplicationContext());
        this.daijishouPlayerTemplate = new DaijishouPlayerTemplate(application);
    }






    public final boolean isSyncing() {
        return this.isSyncing;
    }

    public final void setSyncing(boolean z) {
        this.isSyncing = z;
    }


    public final void setSyncProgress(int i) {
        this.syncProgress = i;
    }

    public /* synthetic */ SynchronizationOfPlatform(DaijishouApplication daijishouApplication, CoroutineScope coroutineScope, long j, DaijishouLibraryRepository daijishouLibraryRepository, ScraperManager scraperManager, boolean z, int i, String str, int i2, Job job, List list, List list2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(daijishouApplication, coroutineScope, j, daijishouLibraryRepository, scraperManager, (i3 & 32) != 0 ? false : z, (i3 & 64) != 0 ? 0 : i, (i3 & 128) != 0 ? "Waiting" : str, (i3 & 256) != 0 ? 0 : i2, (i3 & 512) != 0 ? null : job, (i3 & 1024) != 0 ? new ArrayList() : list, (i3 & 2048) != 0 ? new ArrayList() : list2, (i3 & 4096) != 0 ? false : z2);
    }


    public final void setStatusString(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.statusString = str;
    }


    public final void setStatusCode(int i) {
        this.statusCode = i;
    }


    public final void setJob(Job job) {
        this.job = job;
    }

    public final List<Long> getPlayableItemEntityToBeScrapedIdList() {
        return this.playableItemEntityToBeScrapedIdList;
    }

    public final List<Long> getPlayableItemEntityPreviewMediaMustBeScrapedIdList() {
        return this.playableItemEntityPreviewMediaMustBeScrapedIdList;
    }


    public final void setFullSynchronization(boolean z) {
        this.fullSynchronization = z;
    }

    private final String generalizeTitleForDisjointSets(String title) {
        List<String> groupValues;
        String str;
        MatchResult matchResultFind$default = Regex.find$default(Constants.INSTANCE.getToGenericNameRegex(), title, 0, 2, null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null && (str = groupValues.get(1)) != null) {
            String strReplace = new Regex("\\s*-\\s+Disc\\s+\\d+\\s*").replace(str, "");
            if (strReplace != null) {
                String strReplace2 = new Regex("(\\s+|_+)").replace(strReplace, " ");
                if (strReplace2 != null) {
                    return strReplace2;
                }
            }
        }
        return title;
    }

    public final void stopSyncing() {
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.isSyncing = false;
    }

    public final void setOnStatusUpdatedListener(Function0<Unit> statusUpdatedListener) {
        Intrinsics.checkNotNullParameter(statusUpdatedListener, "statusUpdatedListener");
        this.statusUpdatedListener = statusUpdatedListener;
    }

    public final void setOnFinishedListener(Function1<? super Throwable, Unit> finishedListener) {
        Intrinsics.checkNotNullParameter(finishedListener, "finishedListener");
        this.finishedListener = finishedListener;
    }

    /* INFO: Access modifiers changed from: private */
    public final void synchronizePlayableItems(AppCompatActivity activity) throws PackageManager.NameNotFoundException, IOException {
        Iterator it;
        Regex regex;
        List<PlayerEntity> list;
        Iterator it2;
        Regex regex2 = null;
        List<PlayerEntity> list2 = null;
        ArrayList arrayList;
        int i;
        long jAddPlayableItem;
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex;
        this.statusCode = 2;
        PlatformEntity platformByIdStatically = this.daijishouLibraryRepository.getPlatformByIdStatically(this.platformId);
        if (platformByIdStatically != null) {
            Regex regex3 = new Regex(platformByIdStatically.getAcceptedFilenameRegex(), RegexOption.IGNORE_CASE);
            List<PlayerEntity> playersByIdsStatically = this.daijishouLibraryRepository.getPlayersByIdsStatically(platformByIdStatically.getPlayerIdList());
            int size = playersByIdsStatically.size();
            ArrayList arrayList2 = new ArrayList(size);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                Regex regex4 = null;
                if (i3 >= size) {
                    break;
                }
                PlayerEntity playerEntity = playersByIdsStatically.get(i3);
                if (playerEntity != null) {
                    regex4 = playerEntity.getPlayer() == 1 ? new Regex(playerEntity.getAcceptedFilenameRegex(), RegexOption.IGNORE_CASE) : null;
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                arrayList2.add(regex4);
                i3++;
            }
            ArrayList arrayList3 = arrayList2;
            boolean z = false;
            for (PlayerEntity playerEntity2 : playersByIdsStatically) {
                if (playerEntity2 != null) {
                    if (playerEntity2.getPlayer() == 2) {
                        z = true;
                    }
                    Unit unit3 = Unit.INSTANCE;
                    Unit unit4 = Unit.INSTANCE;
                }
            }
            List<PlayableItemEntity> playableItemsByAttachedPlatformIdStatically = this.daijishouLibraryRepository.getPlayableItemsByAttachedPlatformIdStatically(this.platformId);
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            List<PlayableItemEntity> list3 = playableItemsByAttachedPlatformIdStatically;
            for (PlayableItemEntity playableItemEntity : list3) {
                if (playableItemEntity.getPlayableItemType() == 2 && playableItemEntity.getActivityComponentString() != null) {
                    String activityComponentString = playableItemEntity.getActivityComponentString();
                    Intrinsics.checkNotNull(activityComponentString);
                    arrayList4.add(activityComponentString);
                    arrayList5.add(Long.valueOf(playableItemEntity.getId()));
                }
            }
            if (z) {
                this.statusString = "Scanning android activities";
                AppCompatActivity appCompatActivity = activity;
                ViewModelLazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AppsViewModel.class), new SynchronizationOfPlatform$synchronizePlayableItems$lambda$12$$inlined$viewModels$default$2(appCompatActivity), new SynchronizationOfPlatform$synchronizePlayableItems$lambda$12$$inlined$viewModels$default$1(appCompatActivity), new SynchronizationOfPlatform$synchronizePlayableItems$lambda$12$$inlined$viewModels$default$3(null, appCompatActivity));
                Iterator it3 = synchronizePlayableItems$lambda$12$lambda$5(viewModelLazy).getLauncherIntentResolveInfoList().iterator();
                while (it3.hasNext()) {
                    ResolveInfo resolveInfo = (ResolveInfo) it3.next();
                    String str = resolveInfo.activityInfo.packageName;
                    String strResolveInfoToResolveInfoStringId = synchronizePlayableItems$lambda$12$lambda$5(viewModelLazy).resolveInfoToResolveInfoStringId(resolveInfo);
                    ApplicationInfo applicationInfo = this.application.getApplicationContext().getPackageManager().getApplicationInfo(str, i2);
                    Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
                    if (synchronizePlayableItems$lambda$12$lambda$5(viewModelLazy).isResolveInfoStringIdFlagAsGame(strResolveInfoToResolveInfoStringId)) {
                        String str2 = synchronizePlayableItems$lambda$12$lambda$5(viewModelLazy).getResolveInfoStringIdToLabelCache().get(strResolveInfoToResolveInfoStringId);
                        String strLoadLabel = str2 != null ? str2 : applicationInfo.loadLabel(this.application.getApplicationContext().getPackageManager()).toString();
                        Intrinsics.checkNotNull(strLoadLabel);
                        CharSequence charSequenceLoadDescription = applicationInfo.loadDescription(this.application.getApplicationContext().getPackageManager());
                        i = i2;
                        Intent launchIntentForPackage = this.application.getApplicationContext().getPackageManager().getLaunchIntentForPackage(str);
                        Intrinsics.checkNotNull(launchIntentForPackage);
                        ComponentName component = launchIntentForPackage.getComponent();
                        Intrinsics.checkNotNull(component);
                        String packageName = component.getPackageName();
                        ComponentName component2 = launchIntentForPackage.getComponent();
                        Intrinsics.checkNotNull(component2);
                        String str3 = packageName + InternalZipConstants.ZIP_FILE_SEPARATOR + component2.getClassName();
                        if (arrayList4.contains(str3)) {
                            jAddPlayableItem = ((Number) arrayList5.get(arrayList4.indexOf(str3))).longValue();
                        } else {
                            String string = strLoadLabel.toString();
                            String string2 = charSequenceLoadDescription != null ? charSequenceLoadDescription.toString() : null;
                            String[] strArr = new String[1];
                            strArr[i] = strLoadLabel.toString();
                            jAddPlayableItem = this.daijishouLibraryRepository.addPlayableItem(new PlayableItemEntity(0L, null, false, false, null, 2, string, false, string2, CollectionsKt.mutableListOf(strArr), false, false, false, false, null, Long.valueOf(this.platformId), null, null, null, str3, false, null, 0, null, null, null, 66549791, null));
                        }
                        PlayableItemEntity playableItemByIdStatically = this.daijishouLibraryRepository.getPlayableItemByIdStatically(jAddPlayableItem);
                        Intrinsics.checkNotNull(playableItemByIdStatically);
                        arrayList = arrayList3;
                        String str4 = this.defaultSharedPreferences.getString("preview_media_path", this.application.getApplicationContext().getFilesDir() + "/preview_media/") + playableItemByIdStatically.getId() + InternalZipConstants.ZIP_FILE_SEPARATOR;
                        String str5 = str4 + "index.json";
                        File file = new File(str4);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        if (new File(str5).exists()) {
                            String string3 = IOUtils.toString(new FileInputStream(str5), StandardCharsets.UTF_8);
                            Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                            playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) this.application.getWeakJson().decodeFromString(PlayableItemPreviewMediaIndex.INSTANCE.serializer(), string3);
                        } else {
                            playableItemPreviewMediaIndex = new PlayableItemPreviewMediaIndex((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
                        }
                        String str6 = str4 + Constants.scraperBoxArtFileName;
                        CharSequence charSequence = strLoadLabel;
                        Drawable drawableLoadIcon = applicationInfo.loadIcon(this.application.getApplicationContext().getPackageManager());
                        Intrinsics.checkNotNullExpressionValue(drawableLoadIcon, "loadIcon(...)");
                        DrawableKt.toBitmap$default(drawableLoadIcon, 720, 720, null, 4, null).compress(Constants.INSTANCE.getScraperFormat(), 100, new FileOutputStream(str6));
                        playableItemPreviewMediaIndex.setBoxArtPath(Constants.scraperBoxArtFileName);
                        if (ScraperUtilsKt.hasAnyMedia(playableItemPreviewMediaIndex)) {
                            Json jsonJson$default = JsonKt.Json$default(null, SynchronizationOfPlatform$synchronizePlayableItems$1$3$jsonFormat$1.INSTANCE, 1, null);
                            jsonJson$default.getSerializersModule();
                            String strEncodeToString = jsonJson$default.encodeToString(PlayableItemPreviewMediaIndex.INSTANCE.serializer(), playableItemPreviewMediaIndex);
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(str5));
                            outputStreamWriter.write(strEncodeToString);
                            outputStreamWriter.close();
                        } else if (file.exists()) {
                            FilesKt.deleteRecursively(file);
                        }
                        playableItemByIdStatically.setPreviewMediaPath(str4);
                        String[] strArr2 = new String[1];
                        strArr2[i] = charSequence.toString();
                        playableItemByIdStatically.setScraperKeywordList(CollectionsKt.mutableListOf(strArr2));
                        this.daijishouLibraryRepository.addPlayableItem(playableItemByIdStatically);
                    } else {
                        it3 = it3;
                        arrayList = arrayList3;
                        i = i2;
                    }
                    it3 = it3;
                    list3 = list3;
                    i2 = i;
                    arrayList3 = arrayList;
                    platformByIdStatically = platformByIdStatically;
                }
            }
            PlatformEntity platformEntity = platformByIdStatically;
            List<PlayableItemEntity> list4 = list3;
            ArrayList<Regex> arrayList6 = arrayList3;
            int i4 = i2;
            List<Uri> itemsSyncTreeUriList = platformEntity.getItemsSyncTreeUriList();
            ArrayList<PlayableItemEntity> arrayList7 = new ArrayList();
            Iterator it4 = itemsSyncTreeUriList.iterator();
            while (it4.hasNext()) {
                Uri uri = (Uri) it4.next();
                String strValueOf = String.valueOf(uri.getPath());
                String string4 = this.application.getString(R.string.resolving_tree_format);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                String str7 = String.format(string4, Arrays.copyOf(new Object[]{strValueOf}, 1));
                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                this.statusString = str7;
                Function0<Unit> function0 = this.statusUpdatedListener;
                if (function0 != null) {
                    function0.invoke();
                    Unit unit5 = Unit.INSTANCE;
                }
                Utils utils = Utils.INSTANCE;
                ContentResolver contentResolver = this.application.getContentResolver();
                Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
                Iterator it5 = utils.traverseDirectoryEntries(contentResolver, uri).iterator();
                while (it5.hasNext()) {
                    Triple triple = (Triple) it5.next();
                    String string5 = this.application.getString(R.string.analysing_format);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    String str8 = String.format(string5, Arrays.copyOf(new Object[]{triple.getFirst()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                    this.statusString = str8;
                    Function0<Unit> function1 = this.statusUpdatedListener;
                    if (function1 != null) {
                        function1.invoke();
                        Unit unit6 = Unit.INSTANCE;
                    }
                    if (regex3.matches((CharSequence) triple.getFirst())) {
                        ArrayList arrayList8 = new ArrayList();
                        ArrayList arrayList9 = new ArrayList();
                        int i5 = i4;
                        for (Regex regex5 : arrayList6) {
                            int i6 = i5 + 1;
                            if (regex5 != null) {
                                it2 = it4;
                                if (regex5.matches((CharSequence) triple.getFirst())) {
                                    PlayerEntity playerEntity3 = playersByIdsStatically.get(i5);
                                    Intrinsics.checkNotNull(playerEntity3);
                                    arrayList8.add(playerEntity3);
                                    regex2 = regex3;
                                    list2 = playersByIdsStatically;
                                    MatchResult matchResultFind$default = Regex.find$default(regex5, (CharSequence) triple.getFirst(), i4, 2, null);
                                    Intrinsics.checkNotNull(matchResultFind$default);
                                    MatchGroup matchGroup = matchResultFind$default.getGroups().get(1);
                                    if (matchGroup != null) {
                                        if (arrayList9.indexOf(matchGroup.getValue()) == -1) {
                                            arrayList9.add(matchGroup.getValue());
                                        }
                                        Unit unit7 = Unit.INSTANCE;
                                        Unit unit8 = Unit.INSTANCE;
                                    }
                                }
                                regex3 = regex2;
                                playersByIdsStatically = list2;
                                i5 = i6;
                                it4 = it2;
                                i4 = 0;
                            } else {
                                it2 = it4;
                            }
                            regex2 = regex3;
                            list2 = playersByIdsStatically;
                            regex3 = regex2;
                            playersByIdsStatically = list2;
                            i5 = i6;
                            it4 = it2;
                            i4 = 0;
                        }
                        it = it4;
                        regex = regex3;
                        list = playersByIdsStatically;
                        if (!arrayList8.isEmpty()) {
                            PlayableItemEntity playableItemEntity2 = new PlayableItemEntity(0L, null, false, false, null, 0, null, false, null, null, false, false, false, false, null, null, null, null, null, null, false, null, 0, null, null, null, 67108863, null);
                            playableItemEntity2.setPlayableItemType(1);
                            playableItemEntity2.setSyncTreeUri(uri);
                            playableItemEntity2.setUri((Uri) triple.getSecond());
                            playableItemEntity2.setName((String) arrayList9.get(0));
                            playableItemEntity2.setScraperKeywordList(arrayList9);
                            playableItemEntity2.setAttachedPlatformId(Long.valueOf(platformEntity.getId()));
                            LazyMd5 lazyMd5 = LazyMd5.INSTANCE;
                            InputStream inputStreamOpenInputStream = this.application.getContentResolver().openInputStream((Uri) triple.getSecond());
                            Intrinsics.checkNotNull(inputStreamOpenInputStream);
                            playableItemEntity2.setMd5(lazyMd5.md5Hex(inputStreamOpenInputStream));
                            arrayList7.add(playableItemEntity2);
                        }
                    } else {
                        it = it4;
                        regex = regex3;
                        list = playersByIdsStatically;
                    }
                    regex3 = regex;
                    playersByIdsStatically = list;
                    it4 = it;
                    i4 = 0;
                }
                playersByIdsStatically = playersByIdsStatically;
                i4 = 0;
            }
            String string6 = this.application.getString(R.string.adding_to_database);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            this.statusString = string6;
            Function0<Unit> function2 = this.statusUpdatedListener;
            if (function2 != null) {
                function2.invoke();
                Unit unit9 = Unit.INSTANCE;
            }
            ArrayList arrayList10 = new ArrayList();
            ArrayList arrayList11 = new ArrayList();
            ArrayList arrayList12 = new ArrayList();
            ArrayList arrayList13 = new ArrayList();
            ArrayList arrayList14 = new ArrayList();
            for (PlayableItemEntity playableItemEntity3 : list4) {
                if (playableItemEntity3.getPlayableItemType() == 1) {
                    String md5 = playableItemEntity3.getMd5();
                    if (Intrinsics.areEqual(playableItemEntity3.getUri(), Uri.EMPTY) || Intrinsics.areEqual(playableItemEntity3.getSyncTreeUri(), Uri.EMPTY)) {
                        if (arrayList11.indexOf(md5) == -1) {
                            arrayList11.add(md5);
                            arrayList12.add(playableItemEntity3);
                        }
                    } else {
                        DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(this.application.getApplicationContext(), playableItemEntity3.getUri());
                        if (documentFileFromSingleUri == null || !documentFileFromSingleUri.exists()) {
                            arrayList11.add(md5);
                            arrayList12.add(playableItemEntity3);
                        } else if (arrayList10.indexOf(md5) == -1) {
                            arrayList10.add(md5);
                        }
                    }
                }
            }
            for (PlayableItemEntity playableItemEntity4 : arrayList7) {
                String md6 = playableItemEntity4.getMd5();
                if (arrayList10.indexOf(md6) == -1) {
                    if (arrayList14.indexOf(md6) != -1) {
                        PlayableItemEntity playableItemEntity5 = (PlayableItemEntity) arrayList13.get(arrayList14.indexOf(md6));
                        ArrayList arrayList15 = new ArrayList(playableItemEntity4.getScraperKeywordList());
                        arrayList15.removeAll(CollectionsKt.toSet(playableItemEntity5.getScraperKeywordList()));
                        playableItemEntity5.getScraperKeywordList().addAll(arrayList15);
                    } else if (arrayList11.indexOf(md6) != -1) {
                        int iIndexOf = arrayList11.indexOf(md6);
                        PlayableItemEntity playableItemEntity6 = (PlayableItemEntity) arrayList12.get(iIndexOf);
                        arrayList11.remove(iIndexOf);
                        arrayList12.remove(iIndexOf);
                        playableItemEntity6.setUri(playableItemEntity4.getUri());
                        playableItemEntity6.setSyncTreeUri(playableItemEntity4.getSyncTreeUri());
                        arrayList13.add(playableItemEntity6);
                        arrayList14.add(md6);
                    } else {
                        arrayList13.add(playableItemEntity4);
                        arrayList14.add(md6);
                    }
                }
            }
            DaijishouLibraryRepository daijishouLibraryRepository = this.daijishouLibraryRepository;
            PlayableItemEntity[] playableItemEntityArr = (PlayableItemEntity[]) arrayList13.toArray(new PlayableItemEntity[0]);
            daijishouLibraryRepository.addPlayableItems((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr, playableItemEntityArr.length));
            if (this.defaultSharedPreferences.getBoolean(BooleanPreference.CLEAR_DISJOINTED_ITEMS_ON_SYNC.getKey(), BooleanPreference.CLEAR_DISJOINTED_ITEMS_ON_SYNC.getDefaultValue())) {
                this.daijishouLibraryRepository.clearAllDisjointedPlayableItemsByAttachedPlatformId(this.platformId);
            }
            Unit unit10 = Unit.INSTANCE;
            Unit unit11 = Unit.INSTANCE;
        }
    }

    private static final AppsViewModel synchronizePlayableItems$lambda$12$lambda$5(Lazy<AppsViewModel> lazy) {
        return lazy.getValue();
    }

    /* INFO: Access modifiers changed from: private */
    /* WARN: Code duplicated, block: B:54:0x0203  */
    public final void scrapePlayableItems() {
        boolean z;
        String strScrapeNameByName;
        this.statusCode = 4;
        PlatformEntity platformByIdStatically = this.daijishouLibraryRepository.getPlatformByIdStatically(this.platformId);
        if (platformByIdStatically != null) {
            ArrayList arrayList = new ArrayList();
            List<String> scraperSourceList = platformByIdStatically.getScraperSourceList();
            String name = platformByIdStatically.getName();
            while (this.playableItemEntityToBeScrapedIdList.size() > 0) {
                PlayableItemEntity playableItemByIdStatically = this.daijishouLibraryRepository.getPlayableItemByIdStatically(this.playableItemEntityToBeScrapedIdList.get(0).longValue());
                this.playableItemEntityToBeScrapedIdList.remove(0);
                if (playableItemByIdStatically != null) {
                    boolean zContains = this.playableItemEntityPreviewMediaMustBeScrapedIdList.contains(Long.valueOf(playableItemByIdStatically.getId()));
                    if (zContains) {
                        this.playableItemEntityPreviewMediaMustBeScrapedIdList.remove(Long.valueOf(playableItemByIdStatically.getId()));
                    }
                    String name2 = playableItemByIdStatically.getName();
                    String string = this.application.getString(R.string.scraping_format);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    boolean z2 = true;
                    String str = String.format(string, Arrays.copyOf(new Object[]{name2}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    this.statusString = str;
                    Function0<Unit> function0 = this.statusUpdatedListener;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    if (!playableItemByIdStatically.getDoScrapeName() || (strScrapeNameByName = this.scraperManager.scrapeNameByName(scraperSourceList, playableItemByIdStatically.getName())) == null) {
                        z = false;
                    } else {
                        playableItemByIdStatically.setName(strScrapeNameByName);
                        playableItemByIdStatically.getScraperKeywordList().add(strScrapeNameByName);
                        List listDistinct = CollectionsKt.distinct(playableItemByIdStatically.getScraperKeywordList());
                        Intrinsics.checkNotNull(listDistinct, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
                        playableItemByIdStatically.setScraperKeywordList(TypeIntrinsics.asMutableList(listDistinct));
                        playableItemByIdStatically.setDoScrapeName(false);
                        z = true;
                    }
                    if (playableItemByIdStatically.getScrapeScraperKeywords()) {
                        List<String> listScrapeScraperKeywordsByName = this.scraperManager.scrapeScraperKeywordsByName(scraperSourceList, playableItemByIdStatically.getName());
                        if (!listScrapeScraperKeywordsByName.isEmpty()) {
                            playableItemByIdStatically.getScraperKeywordList().addAll(listScrapeScraperKeywordsByName);
                            List listDistinct2 = CollectionsKt.distinct(playableItemByIdStatically.getScraperKeywordList());
                            Intrinsics.checkNotNull(listDistinct2, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
                            playableItemByIdStatically.setScraperKeywordList(TypeIntrinsics.asMutableList(listDistinct2));
                            playableItemByIdStatically.setScrapeScraperKeywords(false);
                            z = true;
                        }
                    }
                    String str2 = this.defaultSharedPreferences.getString("preview_media_path", this.application.getApplicationContext().getFilesDir() + "/preview_media/") + playableItemByIdStatically.getId() + InternalZipConstants.ZIP_FILE_SEPARATOR;
                    PlayableItemPreviewMediaIndex playableItemPreviewMediaIndexFromPath = this.scraperManager.getPlayableItemPreviewMediaIndexFromPath(str2);
                    if ((!this.defaultSharedPreferences.getBoolean(BooleanPreference.DO_NOT_SCRAP_PREVIEW_MEDIA.getKey(), BooleanPreference.DO_NOT_SCRAP_PREVIEW_MEDIA.getDefaultValue()) && platformByIdStatically.getScrapePreviewMedia()) || zContains) {
                        boolean zScraped;
                        try {
                            zScraped = this.scraperManager.scrapePreviewMediaByFileUri(scraperSourceList, name, playableItemByIdStatically.getUri(), str2) || this.scraperManager.scrapePreviewMediaByKeywords(scraperSourceList, name, playableItemByIdStatically.getScraperKeywordList(), str2);
                        } catch (java.io.IOException e) {
                            this.logger.warn(this, kotlin.ExceptionsKt.stackTraceToString(e));
                            zScraped = false;
                        }
                        if (zScraped) {
                            if (!Intrinsics.areEqual(playableItemByIdStatically.getPreviewMediaPath(), str2)) {
                                playableItemByIdStatically.setPreviewMediaPath(str2);
                                z = true;
                            }
                        } else if (playableItemByIdStatically.getPreviewMediaPath() != null) {
                            playableItemByIdStatically.setPreviewMediaPath(null);
                            z = true;
                        }
                    }
                    if (!Intrinsics.areEqual(this.scraperManager.getPlayableItemPreviewMediaIndexFromPath(str2), playableItemPreviewMediaIndexFromPath)) {
                        z = true;
                    }
                    if (this.daijishouLibraryRepository.getGenreIdsByPlayableItemIdStatically(playableItemByIdStatically.getId()).isEmpty()) {
                        List<Genre> listScrapeGenresByKeywords = this.scraperManager.scrapeGenresByKeywords(scraperSourceList, name, playableItemByIdStatically.getScraperKeywordList());
                        if (listScrapeGenresByKeywords.isEmpty()) {
                            z2 = z;
                        } else {
                            int size = listScrapeGenresByKeywords.size();
                            ArrayList arrayList2 = new ArrayList(size);
                            for (int i = 0; i < size; i++) {
                                arrayList2.add(new PlayableItemToGenrePairEntity(0L, playableItemByIdStatically.getId(), listScrapeGenresByKeywords.get(i).getId(), null, 9, null));
                            }
                            DaijishouLibraryRepository daijishouLibraryRepository = this.daijishouLibraryRepository;
                            PlayableItemToGenrePairEntity[] playableItemToGenrePairEntityArr = (PlayableItemToGenrePairEntity[]) arrayList2.toArray(new PlayableItemToGenrePairEntity[0]);
                            daijishouLibraryRepository.addPlayableItemToGenrePairs((PlayableItemToGenrePairEntity[]) Arrays.copyOf(playableItemToGenrePairEntityArr, playableItemToGenrePairEntityArr.length));
                        }
                    } else {
                        z2 = z;
                    }
                    if (z2) {
                        arrayList.add(playableItemByIdStatically);
                    }
                    if (arrayList.size() >= 8) {
                        DaijishouLibraryRepository daijishouLibraryRepository2 = this.daijishouLibraryRepository;
                        PlayableItemEntity[] playableItemEntityArr = (PlayableItemEntity[]) arrayList.toArray(new PlayableItemEntity[0]);
                        daijishouLibraryRepository2.updatePlayableItems((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr, playableItemEntityArr.length));
                        arrayList.clear();
                    }
                }
            }
            DaijishouLibraryRepository daijishouLibraryRepository3 = this.daijishouLibraryRepository;
            PlayableItemEntity[] playableItemEntityArr2 = (PlayableItemEntity[]) arrayList.toArray(new PlayableItemEntity[0]);
            daijishouLibraryRepository3.updatePlayableItems((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr2, playableItemEntityArr2.length));
            arrayList.clear();
            this.playableItemEntityPreviewMediaMustBeScrapedIdList.clear();
        }
    }

    /* INFO: Access modifiers changed from: private */
    public final void aggregatePlayableItems() {
        this.statusCode = 3;
        this.statusString = "Aggregating items";
        if (this.daijishouLibraryRepository.getPlatformByIdStatically(this.platformId) != null) {
            HashMap map = new HashMap();
            for (PlayableItemEntity playableItemEntity : this.daijishouLibraryRepository.getPlayableItemsByAttachedPlatformIdStatically(this.platformId)) {
                String strGeneralizeTitleForDisjointSets = generalizeTitleForDisjointSets(playableItemEntity.getName());
                if (map.get(strGeneralizeTitleForDisjointSets) == null) {
                    map.put(strGeneralizeTitleForDisjointSets, CollectionsKt.mutableListOf(Long.valueOf(playableItemEntity.getId())));
                } else {
                    Object obj = map.get(strGeneralizeTitleForDisjointSets);
                    Intrinsics.checkNotNull(obj);
                    ((List) obj).add(Long.valueOf(playableItemEntity.getId()));
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : ((java.util.Set<Map.Entry>) map.entrySet())) {
                List list = (List) entry.getValue();
                if (list.size() <= 1) {
                    if (list.size() == 1) {
                        PlayableItemEntity playableItemByIdStatically = this.daijishouLibraryRepository.getPlayableItemByIdStatically(((Number) list.get(0)).longValue());
                        Intrinsics.checkNotNull(playableItemByIdStatically);
                        Long disjointSetPrimaryPlayableItemId = playableItemByIdStatically.getDisjointSetPrimaryPlayableItemId();
                        long jLongValue = ((Number) list.get(0)).longValue();
                        if (disjointSetPrimaryPlayableItemId == null || disjointSetPrimaryPlayableItemId.longValue() != jLongValue || !playableItemByIdStatically.isInSingletonDisjointSet()) {
                            playableItemByIdStatically.setDisjointSetPrimaryPlayableItemId((Long) list.get(0));
                            playableItemByIdStatically.setInSingletonDisjointSet(true);
                            arrayList.add(playableItemByIdStatically);
                        }
                    }
                } else {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        PlayableItemEntity playableItemByIdStatically2 = this.daijishouLibraryRepository.getPlayableItemByIdStatically(((Number) it.next()).longValue());
                        Intrinsics.checkNotNull(playableItemByIdStatically2);
                        Long disjointSetPrimaryPlayableItemId2 = playableItemByIdStatically2.getDisjointSetPrimaryPlayableItemId();
                        long jLongValue2 = ((Number) list.get(0)).longValue();
                        if (disjointSetPrimaryPlayableItemId2 == null || disjointSetPrimaryPlayableItemId2.longValue() != jLongValue2 || playableItemByIdStatically2.isInSingletonDisjointSet()) {
                            playableItemByIdStatically2.setDisjointSetPrimaryPlayableItemId((Long) list.get(0));
                            playableItemByIdStatically2.setInSingletonDisjointSet(false);
                            arrayList.add(playableItemByIdStatically2);
                        }
                    }
                }
                if (arrayList.size() >= 16) {
                    DaijishouLibraryRepository daijishouLibraryRepository = this.daijishouLibraryRepository;
                    PlayableItemEntity[] playableItemEntityArr = (PlayableItemEntity[]) arrayList.toArray(new PlayableItemEntity[0]);
                    daijishouLibraryRepository.updatePlayableItems((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr, playableItemEntityArr.length));
                    arrayList.clear();
                }
            }
            DaijishouLibraryRepository daijishouLibraryRepository2 = this.daijishouLibraryRepository;
            PlayableItemEntity[] playableItemEntityArr2 = (PlayableItemEntity[]) arrayList.toArray(new PlayableItemEntity[0]);
            daijishouLibraryRepository2.updatePlayableItems((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr2, playableItemEntityArr2.length));
            arrayList.clear();
        }
    }

    public final void requestScrapingOfPlayableItem(PlayableItemEntity playableItemEntity) {
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        this.playableItemEntityToBeScrapedIdList.add(Long.valueOf(playableItemEntity.getId()));
        this.playableItemEntityPreviewMediaMustBeScrapedIdList.add(Long.valueOf(playableItemEntity.getId()));
    }

    public final void requestFullSynchronization() {
        this.fullSynchronization = true;
    }

    public final boolean hasAnyTask() {
        return this.fullSynchronization || this.playableItemEntityToBeScrapedIdList.size() > 0;
    }

    public final void synchronize() {
        if (this.statusCode != 0) {
            return;
        }
        this.statusCode = 1;
        this.statusString = "Preparing";
        Function0<Unit> function0 = this.statusUpdatedListener;
        if (function0 != null) {
            function0.invoke();
        }
        this.job = BuildersKt.launch$default(this.coroutineScope, Dispatchers.getIO().plus(new SynchronizationOfPlatform$synchronize$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this)), null, new AnonymousClass1(null), 2, null);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.view_models.SynchronizationOfPlatform$synchronize$1, reason: invalid class name */
    /* INFO: compiled from: SynchronizationOfPlatform.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.view_models.SynchronizationOfPlatform$synchronize$1", f = "SynchronizationOfPlatform.kt", i = {}, l = {545}, m = "invokeSuspendImpl", n = {}, s = {})
    final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = SynchronizationOfPlatform.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SynchronizationOfPlatform.this.logger.debug((CoroutineScope) this.L$0, "Platform with id \"" + SynchronizationOfPlatform.this.getPlatformId() + "\" start syncing.");
                if (SynchronizationOfPlatform.this.getFullSynchronization()) {
                    SynchronizationOfPlatform synchronizationOfPlatform = SynchronizationOfPlatform.this;
                    AppCompatActivity appCompatActivity = synchronizationOfPlatform.activity;
                    Intrinsics.checkNotNull(appCompatActivity);
                    synchronizationOfPlatform.synchronizePlayableItems(appCompatActivity);
                }
                if (SynchronizationOfPlatform.this.getFullSynchronization()) {
                    SynchronizationOfPlatform.this.getPlayableItemEntityToBeScrapedIdList().addAll(SynchronizationOfPlatform.this.getDaijishouLibraryRepository().getPlayableItemIdsByAttachedPlatformIdStatically(SynchronizationOfPlatform.this.getPlatformId()));
                }
                if (SynchronizationOfPlatform.this.getFullSynchronization()) {
                    SynchronizationOfPlatform.this.aggregatePlayableItems();
                }
                SynchronizationOfPlatform.this.scrapePlayableItems();
                if (SynchronizationOfPlatform.this.getFullSynchronization()) {
                    SynchronizationOfPlatform.this.aggregatePlayableItems();
                }
                SynchronizationOfPlatform.this.setStatusCode(0);
                SynchronizationOfPlatform.this.setFullSynchronization(false);
                if (SynchronizationOfPlatform.this.getPlayableItemEntityToBeScrapedIdList().size() > 0) {
                    SynchronizationOfPlatform.this.synchronize();
                } else {
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C00811(SynchronizationOfPlatform.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: com.magneticchen.daijishou.view_models.SynchronizationOfPlatform$synchronize$1$1, reason: invalid class name and collision with other inner class name */
        /* INFO: compiled from: SynchronizationOfPlatform.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.view_models.SynchronizationOfPlatform$synchronize$1$1", f = "SynchronizationOfPlatform.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
        final class C00811 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            int label;
            final /* synthetic */ SynchronizationOfPlatform this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00811(SynchronizationOfPlatform synchronizationOfPlatform, Continuation<?> continuation) {
                super(2, continuation);
                this.this$0 = synchronizationOfPlatform;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new C00811(SynchronizationOfPlatform.this, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((C00811) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
                    Function1 function1 = SynchronizationOfPlatform.this.finishedListener;
                    if (function1 == null) {
                        return null;
                    }
                    function1.invoke(null);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void attachActivity(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }
}
