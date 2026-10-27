package com.magneticchen.daijishou.ui.model;

import android.app.Application;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.api.services.drive.model.File;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.Genre;
import com.magneticchen.daijishou.data.backup.BackupAndRestore;
import com.magneticchen.daijishou.data.backup.BackupData;
import com.magneticchen.daijishou.data.db.entity.ExtensionRepositoryExtensionToCategoryPairEntity;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.data.db.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.data.scraper.ScraperManager;
import com.magneticchen.daijishou.features.GoogleDrive;
import com.magneticchen.daijishou.ui.model.abstract_view_models.DaijishouAndroidViewModel;
import com.magneticchen.daijishou.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 i2\u00020\u0001:\u0001iB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0082@¢\u0006\u0002\u00104J\u0016\u00105\u001a\u0002062\u0006\u00107\u001a\u00020.H\u0086@¢\u0006\u0002\u00108J\b\u00109\u001a\u000206H\u0002J\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020\t022\u0006\u0010;\u001a\u00020\tJ\u0018\u0010<\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u000200H\u0082@¢\u0006\u0002\u0010=J\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020.02H\u0086@¢\u0006\u0002\u0010?J\u001e\u0010@\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001022\u0006\u00107\u001a\u00020.H\u0082@¢\u0006\u0002\u00108J8\u0010A\u001a\u0002062\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020\u00102\u0016\b\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u000206\u0018\u00010GJ8\u0010H\u001a\u0002062\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020\u00102\u0016\b\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u000206\u0018\u00010GJB\u0010I\u001a\u0002062\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020\u00102\b\b\u0002\u0010J\u001a\u0002002\u0016\b\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u000206\u0018\u00010GJ8\u0010K\u001a\u0002062\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020\u00102\u0016\b\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u000206\u0018\u00010GJ8\u0010L\u001a\u0002062\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020\u00102\u0016\b\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u000206\u0018\u00010GJ8\u0010M\u001a\u0002062\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020\u00102\u0016\b\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u000206\u0018\u00010GJ\u0010\u0010N\u001a\u0002002\u0006\u0010O\u001a\u00020PH\u0002J\b\u0010Q\u001a\u000206H\u0002J\u001e\u0010R\u001a\u0002062\u0006\u00107\u001a\u00020.2\u0006\u0010S\u001a\u000200H\u0082@¢\u0006\u0002\u0010TJ\u0018\u0010U\u001a\u0002062\u0006\u00107\u001a\u00020.2\b\b\u0002\u0010V\u001a\u00020\tJ\u0006\u0010W\u001a\u000206J\u0006\u0010X\u001a\u000206J\u0016\u0010Y\u001a\u0002062\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]J\u000e\u0010^\u001a\u0002062\u0006\u0010Z\u001a\u00020[J\u0016\u0010_\u001a\u0002062\u0006\u0010Z\u001a\u00020[2\u0006\u0010B\u001a\u00020\u0007J\u0018\u0010`\u001a\u00020\f2\u0006\u0010Z\u001a\u00020[2\u0006\u0010B\u001a\u00020\u0007H\u0002J\u0010\u0010a\u001a\u0002062\u0006\u0010O\u001a\u00020PH\u0002J\b\u0010b\u001a\u000206H\u0002J\b\u0010c\u001a\u000206H\u0002J\b\u0010d\u001a\u000206H\u0002J\u0006\u0010e\u001a\u000206J\b\u0010f\u001a\u000206H\u0002J\b\u0010g\u001a\u000206H\u0002J\u001a\u0010h\u001a\u0002062\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002060GR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001a\u001a\u00060\u001bR\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0!8F¢\u0006\u0006\u001a\u0004\b)\u0010#R\u001d\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0!8F¢\u0006\u0006\u001a\u0004\b+\u0010#R\u000e\u0010,\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;", "Lcom/magneticchen/daijishou/ui/model/abstract_view_models/DaijishouAndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_onSynchronizationFinishedLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "_statusLiveData", "", "_synchronizationOfPlatformListLiveData", "", "Lcom/magneticchen/daijishou/ui/model/SynchronizationOfPlatform;", "backupAndRestore", "Lcom/magneticchen/daijishou/data/backup/BackupAndRestore;", "backupScheduledManually", "", "currentConcurrentSynchronizationOfPlatforms", "daijishouLibraryRepository", "Lcom/magneticchen/daijishou/data/db/repositories/DaijishouLibraryRepository;", "googleDrive", "Lcom/magneticchen/daijishou/features/GoogleDrive;", "getGoogleDrive", "()Lcom/magneticchen/daijishou/features/GoogleDrive;", "setGoogleDrive", "(Lcom/magneticchen/daijishou/features/GoogleDrive;)V", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "Lcom/magneticchen/daijishou/DaijishouApplication;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "maxConcurrentSynchronizationOfPlatforms", "onSynchronizationFinishedLiveData", "Landroidx/lifecycle/LiveData;", "getOnSynchronizationFinishedLiveData", "()Landroidx/lifecycle/LiveData;", ExtensionRepositoryExtensionToCategoryPairEntity.SCRAPER_CATEGORY, "Lcom/magneticchen/daijishou/data/scraper/ScraperManager;", "getScraper", "()Lcom/magneticchen/daijishou/data/scraper/ScraperManager;", "statusLiveData", "getStatusLiveData", "synchronizationOfPlatformListLiveData", "getSynchronizationOfPlatformListLiveData", "updateEveryPlatform", "createAndUploadIndexForListOfBackupDataToGoogleDrive", "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData;", "indexFilename", "", "listOfBackupData", "", "Lcom/magneticchen/daijishou/data/backup/BackupData;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteListOfBackupDataByIndexFromGoogleDrive", "", "indexOfListOfBackupData", "(Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finishSynchronization", "getBackupAndRestoreModulesNameStringIdsByPolicy", "policy", "getIndexByIndexFilenameFromGoogleDrive", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIndicesOfListOfBackupDataFromGoogleDrive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getListOfBackupDataByIndexFromGoogleDrive", "importBoxArtsFromUriForPlatformId", "platformId", "uri", "Landroid/net/Uri;", "replace", "callback", "Lkotlin/Function1;", "importDatFilesFromUriForPlatformId", "importPreviewMediaFromUriForPlatformId", "type", "importSnapshotsFromUriForPlatformId", "importTitlesFromUriForPlatformId", "importXMLFilesFromUriForPlatformId", "readTextFromXmlPullParser", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "refreshLibrarySynchronization", "renameAndReplaceListOfBackupDataByIndexFromGoogleDrive", "name", "(Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreFromIndexOfListOfBackupDataFromGoogleDrive", "restorePolicy", "scheduleBackup", "scheduleEveryPlatformUpdate", "scheduleScrapingOfPlayableItem", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "playableItemEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "scheduleSynchronizationOfAllPlatforms", "scheduleSynchronizationOfPlatformByPlatformId", "setupAndAcquireSynchronizationOfPlatform", "skipTagForXmlPullParser", "startBackingUp", "startPreparingSynchronization", "startSyncing", "startSyncingIfNot", "startSyncingLibrary", "startUpdatingPlatforms", "updatePlatformsFromGitHub", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouSynchronizationModel extends DaijishouAndroidViewModel {
    public static final String BACKUP_DATA_EXTENSION = ".backup";
    public static final String BACKUP_DATA_INDEX_EXTENSION = ".backup_index";
    public static final int BACKUP_INTERVAL_MS = 900000;
    public static final int IS_BACKING_UP = 4;
    public static final int IS_DOWNLOADING_BACKUP_DATA = 998;
    public static final int IS_FINISHING = 99;
    public static final int IS_GENERATING_BACKUP_DATA = 5;
    public static final int IS_NOT_SYNCING = 0;
    public static final int IS_PREPARING_SYNCHRONIZATION = 1;
    public static final int IS_RESTORING = 997;
    public static final int IS_RESTORING_FROM_BACKUP_DATA = 999;
    public static final int IS_SYNCING_LIBRARY = 3;
    public static final int IS_UPDATING_PLATFORMS = 2;
    public static final int IS_UPLOADING_BACKUP_DATA = 6;
    private final MutableLiveData<Long> _onSynchronizationFinishedLiveData;
    private final MutableLiveData<Integer> _statusLiveData;
    private final MutableLiveData<List<SynchronizationOfPlatform>> _synchronizationOfPlatformListLiveData;
    private final BackupAndRestore backupAndRestore;
    private boolean backupScheduledManually;
    private int currentConcurrentSynchronizationOfPlatforms;
    private final DaijishouLibraryRepository daijishouLibraryRepository;
    private GoogleDrive googleDrive;
    private final DaijishouApplication.WrappedLogger logger;
    private final int maxConcurrentSynchronizationOfPlatforms;
    private final ScraperManager scraper;
    private boolean updateEveryPlatform;
    public static final Companion Companion = new Companion(null);
    private static final Regex filenameWithoutExtensionRegex = new Regex("(.*)\\.[^.]+");

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$createAndUploadIndexForListOfBackupDataToGoogleDrive$1, reason: invalid class name */
    /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel", f = "DaijishouSynchronizationModel.kt", i = {0}, l = {441}, m = "createAndUploadIndexForListOfBackupDataToGoogleDrive", n = {"indexOfListOfBackupData"}, s = {"L$0"})
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
            return DaijishouSynchronizationModel.this.createAndUploadIndexForListOfBackupDataToGoogleDrive(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$deleteListOfBackupDataByIndexFromGoogleDrive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel", f = "DaijishouSynchronizationModel.kt", i = {0, 0, 1, 1, 2, 3}, l = {366, 367, 370, 371}, m = "deleteListOfBackupDataByIndexFromGoogleDrive", n = {"googleDrive", "filename", "googleDrive", "filename", "googleDrive", "googleDrive"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$0"})
    static final class C01231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C01231(Continuation<? super C01231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DaijishouSynchronizationModel.this.deleteListOfBackupDataByIndexFromGoogleDrive(null, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$getIndexByIndexFilenameFromGoogleDrive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel", f = "DaijishouSynchronizationModel.kt", i = {0, 0}, l = {391}, m = "getIndexByIndexFilenameFromGoogleDrive", n = {"this", "filename"}, s = {"L$0", "L$1"})
    static final class C01241 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01241(Continuation<? super C01241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DaijishouSynchronizationModel.this.getIndexByIndexFilenameFromGoogleDrive(null, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$getIndicesOfListOfBackupDataFromGoogleDrive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel", f = "DaijishouSynchronizationModel.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {324, 327}, m = "getIndicesOfListOfBackupDataFromGoogleDrive", n = {"this", "result", "googleDrive", "this", "result", "googleDrive", "filename"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$4"})
    static final class C01251 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C01251(Continuation<? super C01251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DaijishouSynchronizationModel.this.getIndicesOfListOfBackupDataFromGoogleDrive(this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$getListOfBackupDataByIndexFromGoogleDrive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel", f = "DaijishouSynchronizationModel.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {343, 346}, m = "getListOfBackupDataByIndexFromGoogleDrive", n = {"this", "indexOfListOfBackupData", "result", "googleDrive", "contentHashMapRandomIntChecksum", "this", "indexOfListOfBackupData", "result", "googleDrive", "contentHashMapRandomIntChecksum"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C01261 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C01261(Continuation<? super C01261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DaijishouSynchronizationModel.this.getListOfBackupDataByIndexFromGoogleDrive(null, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$renameAndReplaceListOfBackupDataByIndexFromGoogleDrive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel", f = "DaijishouSynchronizationModel.kt", i = {0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {377, 378, 381, 382}, m = "renameAndReplaceListOfBackupDataByIndexFromGoogleDrive", n = {"this", "indexOfListOfBackupData", "name", "googleDrive", "indexOfListOfBackupData", "name", "googleDrive", "indexOfListOfBackupData", "googleDrive", "filename", "indexOfListOfBackupData", "googleDrive", "filename"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class C01301 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C01301(Continuation<? super C01301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DaijishouSynchronizationModel.this.renameAndReplaceListOfBackupDataByIndexFromGoogleDrive(null, null, this);
        }
    }

    /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel$Companion;", "", "()V", "BACKUP_DATA_EXTENSION", "", "BACKUP_DATA_INDEX_EXTENSION", "BACKUP_INTERVAL_MS", "", "IS_BACKING_UP", "IS_DOWNLOADING_BACKUP_DATA", "IS_FINISHING", "IS_GENERATING_BACKUP_DATA", "IS_NOT_SYNCING", "IS_PREPARING_SYNCHRONIZATION", "IS_RESTORING", "IS_RESTORING_FROM_BACKUP_DATA", "IS_SYNCING_LIBRARY", "IS_UPDATING_PLATFORMS", "IS_UPLOADING_BACKUP_DATA", "filenameWithoutExtensionRegex", "Lkotlin/text/Regex;", "getFilenameWithoutExtensionRegex", "()Lkotlin/text/Regex;", "IndexOfListOfBackupData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0BQ\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003JG\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001J&\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-HÁ\u0001¢\u0006\u0002\b.R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0013\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013¨\u00061"}, d2 = {"Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData;", "", "seen1", "", "daijishouUUID", "", "title", "timestamp", "", "contentHashMapRandomIntChecksum", "signature", "filename", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;)V", "getContentHashMapRandomIntChecksum", "()I", "getDaijishouUUID", "()Ljava/lang/String;", "getFilename", "setFilename", "(Ljava/lang/String;)V", "getSignature", "getTimestamp", "()J", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @Serializable
        public static final class IndexOfListOfBackupData {
            public static final C0027Companion Companion = new C0027Companion(null);
            private final int contentHashMapRandomIntChecksum;
            private final String daijishouUUID;
            private String filename;
            private final String signature;
            private final long timestamp;
            private final String title;

            public static /* synthetic */ IndexOfListOfBackupData copy$default(IndexOfListOfBackupData indexOfListOfBackupData, String str, String str2, long j, int i, String str3, String str4, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = indexOfListOfBackupData.daijishouUUID;
                }
                if ((i2 & 2) != 0) {
                    str2 = indexOfListOfBackupData.title;
                }
                if ((i2 & 4) != 0) {
                    j = indexOfListOfBackupData.timestamp;
                }
                if ((i2 & 8) != 0) {
                    i = indexOfListOfBackupData.contentHashMapRandomIntChecksum;
                }
                if ((i2 & 16) != 0) {
                    str3 = indexOfListOfBackupData.signature;
                }
                if ((i2 & 32) != 0) {
                    str4 = indexOfListOfBackupData.filename;
                }
                String str5 = str4;
                int i3 = i;
                long j2 = j;
                return indexOfListOfBackupData.copy(str, str2, j2, i3, str3, str5);
            }

            public final String component1() {
                return this.daijishouUUID;
            }

            public final String component2() {
                return this.title;
            }

            public final long component3() {
                return this.timestamp;
            }

            public final int component4() {
                return this.contentHashMapRandomIntChecksum;
            }

            public final String component5() {
                return this.signature;
            }

            public final String component6() {
                return this.filename;
            }

            public final IndexOfListOfBackupData copy(String daijishouUUID, String title, long j, int i, String signature, String str) {
                Intrinsics.checkNotNullParameter(daijishouUUID, "daijishouUUID");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(signature, "signature");
                return new IndexOfListOfBackupData(daijishouUUID, title, j, i, signature, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof IndexOfListOfBackupData)) {
                    return false;
                }
                IndexOfListOfBackupData indexOfListOfBackupData = (IndexOfListOfBackupData) obj;
                return Intrinsics.areEqual(this.daijishouUUID, indexOfListOfBackupData.daijishouUUID) && Intrinsics.areEqual(this.title, indexOfListOfBackupData.title) && this.timestamp == indexOfListOfBackupData.timestamp && this.contentHashMapRandomIntChecksum == indexOfListOfBackupData.contentHashMapRandomIntChecksum && Intrinsics.areEqual(this.signature, indexOfListOfBackupData.signature) && Intrinsics.areEqual(this.filename, indexOfListOfBackupData.filename);
            }

            public int hashCode() {
                int iHashCode = ((((((((this.daijishouUUID.hashCode() * 31) + this.title.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + Integer.hashCode(this.contentHashMapRandomIntChecksum)) * 31) + this.signature.hashCode()) * 31;
                String str = this.filename;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "IndexOfListOfBackupData(daijishouUUID=" + this.daijishouUUID + ", title=" + this.title + ", timestamp=" + this.timestamp + ", contentHashMapRandomIntChecksum=" + this.contentHashMapRandomIntChecksum + ", signature=" + this.signature + ", filename=" + this.filename + ")";
            }

            /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData$Companion, reason: collision with other inner class name */
            /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class C0027Companion {
                public /* synthetic */ C0027Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private C0027Companion() {
                }

                public final KSerializer<IndexOfListOfBackupData> serializer() {
                    return DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData$$serializer.INSTANCE;
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ IndexOfListOfBackupData(int i, String str, String str2, long j, int i2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
                if (17 != (i & 17)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 17, DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData$$serializer.INSTANCE.getDescriptor());
                }
                this.daijishouUUID = str;
                if ((i & 2) == 0) {
                    this.title = "Daijishou Backup Index";
                } else {
                    this.title = str2;
                }
                if ((i & 4) == 0) {
                    this.timestamp = 0L;
                } else {
                    this.timestamp = j;
                }
                if ((i & 8) == 0) {
                    this.contentHashMapRandomIntChecksum = 0;
                } else {
                    this.contentHashMapRandomIntChecksum = i2;
                }
                this.signature = str3;
                if ((i & 32) == 0) {
                    this.filename = null;
                } else {
                    this.filename = str4;
                }
            }

            public IndexOfListOfBackupData(String daijishouUUID, String title, long j, int i, String signature, String str) {
                Intrinsics.checkNotNullParameter(daijishouUUID, "daijishouUUID");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(signature, "signature");
                this.daijishouUUID = daijishouUUID;
                this.title = title;
                this.timestamp = j;
                this.contentHashMapRandomIntChecksum = i;
                this.signature = signature;
                this.filename = str;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$app_release(IndexOfListOfBackupData indexOfListOfBackupData, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                compositeEncoder.encodeStringElement(serialDescriptor, 0, indexOfListOfBackupData.daijishouUUID);
                if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || !Intrinsics.areEqual(indexOfListOfBackupData.title, "Daijishou Backup Index")) {
                    compositeEncoder.encodeStringElement(serialDescriptor, 1, indexOfListOfBackupData.title);
                }
                if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || indexOfListOfBackupData.timestamp != 0) {
                    compositeEncoder.encodeLongElement(serialDescriptor, 2, indexOfListOfBackupData.timestamp);
                }
                if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || indexOfListOfBackupData.contentHashMapRandomIntChecksum != 0) {
                    compositeEncoder.encodeIntElement(serialDescriptor, 3, indexOfListOfBackupData.contentHashMapRandomIntChecksum);
                }
                compositeEncoder.encodeStringElement(serialDescriptor, 4, indexOfListOfBackupData.signature);
                if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) && indexOfListOfBackupData.filename == null) {
                    return;
                }
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, indexOfListOfBackupData.filename);
            }

            public final String getDaijishouUUID() {
                return this.daijishouUUID;
            }

            public /* synthetic */ IndexOfListOfBackupData(String str, String str2, long j, int i, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i2 & 2) != 0 ? "Daijishou Backup Index" : str2, (i2 & 4) != 0 ? 0L : j, (i2 & 8) != 0 ? 0 : i, str3, (i2 & 32) != 0 ? null : str4);
            }

            public final String getTitle() {
                return this.title;
            }

            public final long getTimestamp() {
                return this.timestamp;
            }

            public final int getContentHashMapRandomIntChecksum() {
                return this.contentHashMapRandomIntChecksum;
            }

            public final String getSignature() {
                return this.signature;
            }

            public final String getFilename() {
                return this.filename;
            }

            public final void setFilename(String str) {
                this.filename = str;
            }
        }

        public final Regex getFilenameWithoutExtensionRegex() {
            return DaijishouSynchronizationModel.filenameWithoutExtensionRegex;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DaijishouSynchronizationModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.logger = getApplication().getLogger();
        this.scraper = getApplication().getScraperManager();
        this.googleDrive = getApplication().getGoogleDrive();
        this._statusLiveData = new MutableLiveData<>(0);
        this.backupAndRestore = getApplication().getBackupAndRestore();
        this.daijishouLibraryRepository = new DaijishouLibraryRepository(application, null, null, 6, null);
        this._onSynchronizationFinishedLiveData = new MutableLiveData<>();
        this._synchronizationOfPlatformListLiveData = new MutableLiveData<>();
        this.maxConcurrentSynchronizationOfPlatforms = Math.min(5, Math.max(3, (int) (Runtime.getRuntime().availableProcessors() * 0.75f)));
    }

    public final DaijishouApplication.WrappedLogger getLogger() {
        return this.logger;
    }

    public final ScraperManager getScraper() {
        return this.scraper;
    }

    public final GoogleDrive getGoogleDrive() {
        return this.googleDrive;
    }

    public final void setGoogleDrive(GoogleDrive googleDrive) {
        Intrinsics.checkNotNullParameter(googleDrive, "<set-?>");
        this.googleDrive = googleDrive;
    }

    public final LiveData<Integer> getStatusLiveData() {
        return this._statusLiveData;
    }

    public final LiveData<Long> getOnSynchronizationFinishedLiveData() {
        return this._onSynchronizationFinishedLiveData;
    }

    public final LiveData<List<SynchronizationOfPlatform>> getSynchronizationOfPlatformListLiveData() {
        return this._synchronizationOfPlatformListLiveData;
    }

    private final void startSyncing() {
        Object value = this._statusLiveData.getValue();
        Intrinsics.checkNotNull(value);
        if (((Number) value).intValue() != 0) {
            return;
        }
        this.logger.debug(this, "Starting synchronization.");
        Toast.makeText(getApplication(), getApplication().getString(R.string.syncing), 0).show();
        startPreparingSynchronization();
    }

    public final void startSyncingIfNot() {
        Object value = this._statusLiveData.getValue();
        Intrinsics.checkNotNull(value);
        if (((Number) value).intValue() == 0) {
            startSyncing();
        }
    }

    private final void startPreparingSynchronization() {
        this._statusLiveData.setValue(1);
        startUpdatingPlatforms();
    }

    public final void updatePlatformsFromGitHub(Function1<? super Boolean, Unit> callback) {
        DaijishouSynchronizationModel daijishouSynchronizationModel;
        Function1<? super Boolean, Unit> function1;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!Utils.INSTANCE.isNetworkAvailable(getApplication())) {
            callback.invoke(false);
            return;
        }
        try {
            boolean z = this.updateEveryPlatform;
            if (!z && !getDefaultSharedPreferences().getBoolean(BooleanPreference.UPDATE_PLATFORMS_AUTOMATICALLY.getKey(), BooleanPreference.UPDATE_PLATFORMS_AUTOMATICALLY.getDefaultValue())) {
                callback.invoke(false);
                return;
            }
            DaijishouSynchronizationModel$updatePlatformsFromGitHub$$inlined$CoroutineExceptionHandler$1 daijishouSynchronizationModel$updatePlatformsFromGitHub$$inlined$CoroutineExceptionHandler$1 = new DaijishouSynchronizationModel$updatePlatformsFromGitHub$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this, callback);
            daijishouSynchronizationModel = this;
            function1 = callback;
            try {
                BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO().plus(daijishouSynchronizationModel$updatePlatformsFromGitHub$$inlined$CoroutineExceptionHandler$1), (CoroutineStart) null, daijishouSynchronizationModel.new C01351(z, function1, daijishouSynchronizationModel$updatePlatformsFromGitHub$$inlined$CoroutineExceptionHandler$1, null), 2, (Object) null);
            } catch (Exception e) {
                e = e;
                daijishouSynchronizationModel.logger.error(this, ExceptionsKt.stackTraceToString(e));
                function1.invoke(false);
            }
        } catch (Exception e2) {
            e = e2;
            daijishouSynchronizationModel = this;
            function1 = callback;
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$updatePlatformsFromGitHub$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$updatePlatformsFromGitHub$1", f = "DaijishouSynchronizationModel.kt", i = {0}, l = {233, 237}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class C01351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        final /* synthetic */ CoroutineExceptionHandler $coroutineExceptionHandler;
        final /* synthetic */ boolean $updateEveryPlatformThisCycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01351(boolean z, Function1<? super Boolean, Unit> function1, CoroutineExceptionHandler coroutineExceptionHandler, Continuation<? super C01351> continuation) {
            super(2, continuation);
            this.$updateEveryPlatformThisCycle = z;
            this.$callback = function1;
            this.$coroutineExceptionHandler = coroutineExceptionHandler;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01351 c01351 = DaijishouSynchronizationModel.this.new C01351(this.$updateEveryPlatformThisCycle, this.$callback, this.$coroutineExceptionHandler, continuation);
            c01351.L$0 = obj;
            return c01351;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x00dc, code lost:
        
            if (invokeSuspend$checkNextPlatform(r5, r6, r17.this$0, r8, r17.$updateEveryPlatformThisCycle, r10, r11, r12, r13, r17.$callback, r17.$coroutineExceptionHandler, r17) == r2) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x010b, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01351.C00311(r17.$callback, null), r17) == r2) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x010d, code lost:
        
            return r2;
         */
        /* JADX WARN: Type inference failed for: r0v15, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v4, types: [T, com.magneticchen.daijishou.data.portables.PlatformsIndexJson] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 273
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01351.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:7:0x001a  */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00c9, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r0, r1, r12) == r13) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0101, code lost:
        
            if (invokeSuspend$checkNextPlatform(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r12) == r13) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x012f, code lost:
        
            if (invokeSuspend$checkNextPlatform(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r12) == r13) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x018e, code lost:
        
            if (invokeSuspend$checkNextPlatform(r17, r18, r19, r20, r21, r9, r23, r24, r25, r26, r27, r12) == r13) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x022b, code lost:
        
            if (invokeSuspend$checkNextPlatform(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r14) == r13) goto L67;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final java.lang.Object invokeSuspend$checkNextPlatform(final kotlin.jvm.internal.Ref.IntRef r17, final com.magneticchen.daijishou.data.portables.PlatformsIndexJson r18, final com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel r19, final kotlin.jvm.internal.Ref.IntRef r20, final boolean r21, final kotlin.jvm.internal.Ref.ObjectRef<com.magneticchen.daijishou.data.portables.PlatformsIndexJson> r22, final kotlinx.serialization.json.Json r23, final java.lang.String r24, final kotlinx.coroutines.CoroutineScope r25, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r26, final kotlinx.coroutines.CoroutineExceptionHandler r27, kotlin.coroutines.Continuation<? super kotlin.Unit> r28) {
            /*
                Method dump skipped, instruction units count: 580
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01351.invokeSuspend$checkNextPlatform(kotlin.jvm.internal.Ref$IntRef, com.magneticchen.daijishou.data.portables.PlatformsIndexJson, com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel, kotlin.jvm.internal.Ref$IntRef, boolean, kotlin.jvm.internal.Ref$ObjectRef, kotlinx.serialization.json.Json, java.lang.String, kotlinx.coroutines.CoroutineScope, kotlin.jvm.functions.Function1, kotlinx.coroutines.CoroutineExceptionHandler, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$updatePlatformsFromGitHub$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$updatePlatformsFromGitHub$1$1", f = "DaijishouSynchronizationModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Boolean, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00311(Function1<? super Boolean, Unit> function1, Continuation<? super C00311> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00311(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$callback.invoke(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
        }
    }

    private final void startUpdatingPlatforms() {
        this._statusLiveData.setValue(2);
        updatePlatformsFromGitHub(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.startUpdatingPlatforms.1
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                DaijishouSynchronizationModel.this.startSyncingLibrary();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshLibrarySynchronization() {
        Object value = this._statusLiveData.getValue();
        Intrinsics.checkNotNull(value);
        if (((Number) value).intValue() != 3) {
            return;
        }
        ArrayList arrayList = (List) this._synchronizationOfPlatformListLiveData.getValue();
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        ArrayList arrayList2 = new ArrayList();
        List<SynchronizationOfPlatform> list = arrayList;
        for (SynchronizationOfPlatform synchronizationOfPlatform : list) {
            if (!synchronizationOfPlatform.hasAnyTask() && synchronizationOfPlatform.getStatusCode() == 0) {
                arrayList2.add(Long.valueOf(synchronizationOfPlatform.getPlatformId()));
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            final long jLongValue = ((Number) it.next()).longValue();
            CollectionsKt.removeAll(arrayList, (Function1) new Function1<SynchronizationOfPlatform, Boolean>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$refreshLibrarySynchronization$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SynchronizationOfPlatform it2) {
                    Intrinsics.checkNotNullParameter(it2, "it");
                    return Boolean.valueOf(it2.getPlatformId() == jLongValue);
                }
            });
        }
        for (SynchronizationOfPlatform synchronizationOfPlatform2 : list) {
            if (synchronizationOfPlatform2.getStatusCode() == 0) {
                int i = this.maxConcurrentSynchronizationOfPlatforms;
                int i2 = this.currentConcurrentSynchronizationOfPlatforms;
                if (i - i2 > 0) {
                    this.currentConcurrentSynchronizationOfPlatforms = i2 + 1;
                    synchronizationOfPlatform2.synchronize();
                }
            }
        }
        this._synchronizationOfPlatformListLiveData.postValue(arrayList);
        if (arrayList.size() == 0) {
            startBackingUp();
        }
    }

    private final SynchronizationOfPlatform setupAndAcquireSynchronizationOfPlatform(AppCompatActivity appCompatActivity, long j) {
        ArrayList arrayList;
        char c;
        final long j2;
        SynchronizationOfPlatform synchronizationOfPlatform;
        List list = (List) this._synchronizationOfPlatformListLiveData.getValue();
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (((SynchronizationOfPlatform) obj).getPlatformId() == j) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (arrayList == null || (synchronizationOfPlatform = (SynchronizationOfPlatform) CollectionsKt.getOrNull(arrayList, 0)) == null) {
            c = 0;
            j2 = j;
            synchronizationOfPlatform = new SynchronizationOfPlatform(getApplication(), ViewModelKt.getViewModelScope((ViewModel) this), j2, this.daijishouLibraryRepository, this.scraper, false, 0, null, 0, null, null, null, false, 8160, null);
        } else {
            j2 = j;
            c = 0;
        }
        synchronizationOfPlatform.attachActivity(appCompatActivity);
        synchronizationOfPlatform.setOnFinishedListener(new Function1<Throwable, Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.setupAndAcquireSynchronizationOfPlatform.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                if (th != null) {
                    DaijishouSynchronizationModel.this.getApplication().getLogger().debug(DaijishouSynchronizationModel.this, "Platform with id \"" + j2 + "\" occurred error.");
                    DaijishouSynchronizationModel.this.getApplication().getLogger().warn(DaijishouSynchronizationModel.this, ExceptionsKt.stackTraceToString(th));
                } else {
                    DaijishouSynchronizationModel.this.getApplication().getLogger().debug(DaijishouSynchronizationModel.this, "Platform with id \"" + j2 + "\" synced.");
                }
                DaijishouSynchronizationModel daijishouSynchronizationModel = DaijishouSynchronizationModel.this;
                daijishouSynchronizationModel.currentConcurrentSynchronizationOfPlatforms = Math.max(0, daijishouSynchronizationModel.currentConcurrentSynchronizationOfPlatforms - 1);
                DaijishouSynchronizationModel.this.refreshLibrarySynchronization();
                DaijishouSynchronizationModel.this._onSynchronizationFinishedLiveData.postValue(Long.valueOf(j2));
            }
        });
        synchronizationOfPlatform.setOnStatusUpdatedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.setupAndAcquireSynchronizationOfPlatform.2
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Object value = DaijishouSynchronizationModel.this._synchronizationOfPlatformListLiveData.getValue();
                Intrinsics.checkNotNull(value);
                DaijishouSynchronizationModel.this._synchronizationOfPlatformListLiveData.postValue((List) value);
            }
        });
        if (this._synchronizationOfPlatformListLiveData.getValue() == null) {
            MutableLiveData<List<SynchronizationOfPlatform>> mutableLiveData = this._synchronizationOfPlatformListLiveData;
            SynchronizationOfPlatform[] synchronizationOfPlatformArr = new SynchronizationOfPlatform[1];
            synchronizationOfPlatformArr[c] = synchronizationOfPlatform;
            mutableLiveData.setValue(CollectionsKt.mutableListOf(synchronizationOfPlatformArr));
            return synchronizationOfPlatform;
        }
        Object value = this._synchronizationOfPlatformListLiveData.getValue();
        Intrinsics.checkNotNull(value);
        List list2 = (List) value;
        List list3 = list2;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                if (((SynchronizationOfPlatform) it.next()).getPlatformId() == j2) {
                    return synchronizationOfPlatform;
                }
            }
        }
        list2.add(synchronizationOfPlatform);
        this._synchronizationOfPlatformListLiveData.setValue(list2);
        return synchronizationOfPlatform;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startSyncingLibrary() {
        this._statusLiveData.setValue(3);
        refreshLibrarySynchronization();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0093  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:38:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:? A[LOOP:0: B:24:0x008d->B:40:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00c9 -> B:32:0x00cb). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object getIndicesOfListOfBackupDataFromGoogleDrive(kotlin.coroutines.Continuation<? super java.util.List<com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData>> r15) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.getIndicesOfListOfBackupDataFromGoogleDrive(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:32:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:35:0x00fc A[Catch: Exception -> 0x004c, TRY_LEAVE, TryCatch #1 {Exception -> 0x004c, blocks: (B:13:0x0047, B:33:0x00f8, B:35:0x00fc), top: B:48:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0130  */
    /* JADX WARN: Code duplicated, block: B:51:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00f2 -> B:33:0x00f8). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object getListOfBackupDataByIndexFromGoogleDrive(com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData r13, kotlin.coroutines.Continuation<? super java.util.List<com.magneticchen.daijishou.data.backup.BackupData>> r14) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.getListOfBackupDataByIndexFromGoogleDrive(com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:47:0x0102 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:? A[LOOP:0: B:39:0x00e0->B:49:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x0102 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:? A[LOOP:1: B:29:0x009e->B:53:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteListOfBackupDataByIndexFromGoogleDrive(Companion.IndexOfListOfBackupData indexOfListOfBackupData, Continuation<? super Unit> continuation) {
        C01231 c01231;
        GoogleDrive googleDrive;
        String str;
        String str2;
        Iterator it;
        GoogleDrive googleDrive2;
        String id2;
        GoogleDrive googleDrive3;
        Iterator it2;
        String id3;
        if (continuation instanceof C01231) {
            c01231 = (C01231) continuation;
            if ((c01231.label & Integer.MIN_VALUE) != 0) {
                c01231.label -= Integer.MIN_VALUE;
            } else {
                c01231 = new C01231(continuation);
            }
        } else {
            c01231 = new C01231(continuation);
        }
        C01231 c01232 = c01231;
        Object filesByFilename$default = c01232.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01232.label;
        if (i == 0) {
            ResultKt.throwOnFailure(filesByFilename$default);
            googleDrive = this.googleDrive;
            String filename = indexOfListOfBackupData.getFilename();
            if (filename == null) {
                return Unit.INSTANCE;
            }
            String signature = indexOfListOfBackupData.getSignature();
            c01232.L$0 = googleDrive;
            c01232.L$1 = filename;
            c01232.label = 1;
            Object filesByFilenameContainingSubstring$default = GoogleDrive.getFilesByFilenameContainingSubstring$default(googleDrive, signature, false, c01232, 2, null);
            if (filesByFilenameContainingSubstring$default != coroutine_suspended) {
                filesByFilename$default = filesByFilenameContainingSubstring$default;
                str = filename;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            str = (String) c01232.L$1;
            googleDrive = (GoogleDrive) c01232.L$0;
            ResultKt.throwOnFailure(filesByFilename$default);
        } else {
            if (i == 2) {
                it = (Iterator) c01232.L$2;
                String str3 = (String) c01232.L$1;
                GoogleDrive googleDrive4 = (GoogleDrive) c01232.L$0;
                ResultKt.throwOnFailure(filesByFilename$default);
                str2 = str3;
                googleDrive = googleDrive4;
                while (it.hasNext()) {
                    id2 = ((File) it.next()).getId();
                    Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
                    c01232.L$0 = googleDrive;
                    c01232.L$1 = str2;
                    c01232.L$2 = it;
                    c01232.label = 2;
                    if (GoogleDrive.deleteFileByFileId$default(googleDrive, id2, false, c01232, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                c01232.L$0 = googleDrive;
                c01232.L$1 = null;
                c01232.L$2 = null;
                c01232.label = 3;
                filesByFilename$default = GoogleDrive.getFilesByFilename$default(googleDrive, str2, false, c01232, 2, null);
                if (filesByFilename$default != coroutine_suspended) {
                    googleDrive2 = googleDrive;
                    googleDrive3 = googleDrive2;
                    it2 = ((Iterable) filesByFilename$default).iterator();
                }
                return coroutine_suspended;
            }
            if (i == 3) {
                googleDrive2 = (GoogleDrive) c01232.L$0;
                ResultKt.throwOnFailure(filesByFilename$default);
                googleDrive3 = googleDrive2;
                it2 = ((Iterable) filesByFilename$default).iterator();
            } else {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it2 = (Iterator) c01232.L$1;
                googleDrive3 = (GoogleDrive) c01232.L$0;
                ResultKt.throwOnFailure(filesByFilename$default);
            }
        }
        while (it2.hasNext()) {
            id3 = ((File) it2.next()).getId();
            Intrinsics.checkNotNullExpressionValue(id3, "getId(...)");
            c01232.L$0 = googleDrive3;
            c01232.L$1 = it2;
            c01232.label = 4;
            if (GoogleDrive.deleteFileByFileId$default(googleDrive3, id3, false, c01232, 2, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
        Iterator it3 = ((Iterable) filesByFilename$default).iterator();
        str2 = str;
        it = it3;
        while (it.hasNext()) {
            id2 = ((File) it.next()).getId();
            Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
            c01232.L$0 = googleDrive;
            c01232.L$1 = str2;
            c01232.L$2 = it;
            c01232.label = 2;
            if (GoogleDrive.deleteFileByFileId$default(googleDrive, id2, false, c01232, 2, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        c01232.L$0 = googleDrive;
        c01232.L$1 = null;
        c01232.L$2 = null;
        c01232.label = 3;
        filesByFilename$default = GoogleDrive.getFilesByFilename$default(googleDrive, str2, false, c01232, 2, null);
        if (filesByFilename$default != coroutine_suspended) {
            googleDrive2 = googleDrive;
            googleDrive3 = googleDrive2;
            it2 = ((Iterable) filesByFilename$default).iterator();
            while (it2.hasNext()) {
                id3 = ((File) it2.next()).getId();
                Intrinsics.checkNotNullExpressionValue(id3, "getId(...)");
                c01232.L$0 = googleDrive3;
                c01232.L$1 = it2;
                c01232.label = 4;
                if (GoogleDrive.deleteFileByFileId$default(googleDrive3, id3, false, c01232, 2, null) == coroutine_suspended) {
                }
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:39:0x0115  */
    /* JADX WARN: Code duplicated, block: B:43:0x013e  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0137, code lost:
    
        if (com.magneticchen.daijishou.features.GoogleDrive.renameFileByFileId$default(r11, r12, r13, false, r15, 4, null) == r3) goto L41;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0137 -> B:42:0x013a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object renameAndReplaceListOfBackupDataByIndexFromGoogleDrive(com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData r20, java.lang.String r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.renameAndReplaceListOfBackupDataByIndexFromGoogleDrive(com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getIndexByIndexFilenameFromGoogleDrive(String str, Continuation<? super Companion.IndexOfListOfBackupData> continuation) {
        C01241 c01241;
        DaijishouSynchronizationModel daijishouSynchronizationModel;
        String str2;
        if (continuation instanceof C01241) {
            c01241 = (C01241) continuation;
            if ((c01241.label & Integer.MIN_VALUE) != 0) {
                c01241.label -= Integer.MIN_VALUE;
            } else {
                c01241 = new C01241(continuation);
            }
        } else {
            c01241 = new C01241(continuation);
        }
        C01241 c01242 = c01241;
        Object objDownloadByteArrayFromFilename$default = c01242.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01242.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDownloadByteArrayFromFilename$default);
            GoogleDrive googleDrive = this.googleDrive;
            String str3 = str + BACKUP_DATA_INDEX_EXTENSION;
            c01242.L$0 = this;
            c01242.L$1 = str3;
            c01242.label = 1;
            objDownloadByteArrayFromFilename$default = GoogleDrive.downloadByteArrayFromFilename$default(googleDrive, str3, false, c01242, 2, null);
            if (objDownloadByteArrayFromFilename$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            daijishouSynchronizationModel = this;
            str2 = str3;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) c01242.L$1;
            daijishouSynchronizationModel = (DaijishouSynchronizationModel) c01242.L$0;
            ResultKt.throwOnFailure(objDownloadByteArrayFromFilename$default);
        }
        byte[] bArr = (byte[]) objDownloadByteArrayFromFilename$default;
        if (bArr == null) {
            return null;
        }
        Json weakJson = daijishouSynchronizationModel.getWeakJson();
        String strDecodeToString = StringsKt.decodeToString(bArr);
        weakJson.getSerializersModule();
        Object objDecodeFromString = weakJson.decodeFromString(Companion.IndexOfListOfBackupData.Companion.serializer(), strDecodeToString);
        ((Companion.IndexOfListOfBackupData) objDecodeFromString).setFilename(str2);
        return objDecodeFromString;
    }

    public final List<Integer> getBackupAndRestoreModulesNameStringIdsByPolicy(int i) {
        return this.backupAndRestore.getBackupAndRestoreModulesNameStringIdsByPolicy(i);
    }

    public static /* synthetic */ void restoreFromIndexOfListOfBackupDataFromGoogleDrive$default(DaijishouSynchronizationModel daijishouSynchronizationModel, Companion.IndexOfListOfBackupData indexOfListOfBackupData, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        daijishouSynchronizationModel.restoreFromIndexOfListOfBackupDataFromGoogleDrive(indexOfListOfBackupData, i);
    }

    public final void restoreFromIndexOfListOfBackupDataFromGoogleDrive(Companion.IndexOfListOfBackupData indexOfListOfBackupData, int i) {
        Intrinsics.checkNotNullParameter(indexOfListOfBackupData, "indexOfListOfBackupData");
        Integer num = (Integer) this._statusLiveData.getValue();
        if (num != null && num.intValue() == 0) {
            this._statusLiveData.setValue(Integer.valueOf(IS_RESTORING));
            this._statusLiveData.setValue(998);
            BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new C01311(indexOfListOfBackupData, i, null), 2, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$restoreFromIndexOfListOfBackupDataFromGoogleDrive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$restoreFromIndexOfListOfBackupDataFromGoogleDrive$1", f = "DaijishouSynchronizationModel.kt", i = {0, 1, 1, 2}, l = {407, 409, 412, 418, 422}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "it", "$this$launch"}, s = {"L$0", "L$0", "L$2", "L$0"})
    static final class C01311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Companion.IndexOfListOfBackupData $indexOfListOfBackupData;
        final /* synthetic */ int $restorePolicy;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01311(Companion.IndexOfListOfBackupData indexOfListOfBackupData, int i, Continuation<? super C01311> continuation) {
            super(2, continuation);
            this.$indexOfListOfBackupData = indexOfListOfBackupData;
            this.$restorePolicy = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01311 c01311 = DaijishouSynchronizationModel.this.new C01311(this.$indexOfListOfBackupData, this.$restorePolicy, continuation);
            c01311.L$0 = obj;
            return c01311;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x007d A[Catch: Exception -> 0x0058, TryCatch #2 {Exception -> 0x0058, blocks: (B:39:0x00a2, B:24:0x0054, B:33:0x0079, B:35:0x007d, B:42:0x00b5, B:43:0x00cf), top: B:58:0x0054 }] */
        /* JADX WARN: Code duplicated, block: B:37:0x009e  */
        /* JADX WARN: Code duplicated, block: B:38:0x00a0  */
        /* JADX WARN: Code duplicated, block: B:41:0x00b4  */
        /* JADX WARN: Code duplicated, block: B:42:0x00b5 A[Catch: Exception -> 0x0058, TryCatch #2 {Exception -> 0x0058, blocks: (B:39:0x00a2, B:24:0x0054, B:33:0x0079, B:35:0x007d, B:42:0x00b5, B:43:0x00cf), top: B:58:0x0054 }] */
        /* JADX WARN: Code duplicated, block: B:49:0x0105  */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x011f, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01311.AnonymousClass3(r12.this$0, null), r12) == r1) goto L51;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 293
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01311.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$restoreFromIndexOfListOfBackupDataFromGoogleDrive$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$restoreFromIndexOfListOfBackupDataFromGoogleDrive$1$2", f = "DaijishouSynchronizationModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Exception $e;
            int label;
            final /* synthetic */ DaijishouSynchronizationModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DaijishouSynchronizationModel daijishouSynchronizationModel, Exception exc, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = daijishouSynchronizationModel;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Toast.makeText(this.this$0.getApplication(), this.$e.getMessage(), 0).show();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$restoreFromIndexOfListOfBackupDataFromGoogleDrive$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$restoreFromIndexOfListOfBackupDataFromGoogleDrive$1$3", f = "DaijishouSynchronizationModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DaijishouSynchronizationModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(DaijishouSynchronizationModel daijishouSynchronizationModel, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = daijishouSynchronizationModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, continuation);
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
                this.this$0._statusLiveData.setValue(Boxing.boxInt(0));
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object createAndUploadIndexForListOfBackupDataToGoogleDrive(String str, List<BackupData> list, Continuation<? super Companion.IndexOfListOfBackupData> continuation) {
        AnonymousClass1 anonymousClass1;
        Companion.IndexOfListOfBackupData indexOfListOfBackupData;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objUploadByteArrayToFilename$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objUploadByteArrayToFilename$default);
            GoogleDrive googleDrive = this.googleDrive;
            if (googleDrive == null) {
                return null;
            }
            Ref.IntRef intRef = new Ref.IntRef();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                intRef.element += ((BackupData) it.next()).getModuleRandomInt();
            }
            String str2 = str + BACKUP_DATA_INDEX_EXTENSION;
            String daijishouUUID = getApplication().getDaijishouUUID();
            String MODEL = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            long jCurrentTimeMillis = System.currentTimeMillis();
            int i2 = intRef.element;
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Companion.IndexOfListOfBackupData indexOfListOfBackupData2 = new Companion.IndexOfListOfBackupData(daijishouUUID, MODEL, jCurrentTimeMillis, i2, string, str2);
            byte[] bArrEncodeToByteArray = StringsKt.encodeToByteArray(getWeakJson().encodeToString(Companion.IndexOfListOfBackupData.Companion.serializer(), indexOfListOfBackupData2));
            anonymousClass2.L$0 = indexOfListOfBackupData2;
            anonymousClass2.label = 1;
            objUploadByteArrayToFilename$default = GoogleDrive.uploadByteArrayToFilename$default(googleDrive, str2, bArrEncodeToByteArray, false, anonymousClass2, 4, null);
            if (objUploadByteArrayToFilename$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            indexOfListOfBackupData = indexOfListOfBackupData2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            indexOfListOfBackupData = (Companion.IndexOfListOfBackupData) anonymousClass2.L$0;
            ResultKt.throwOnFailure(objUploadByteArrayToFilename$default);
        }
        if (((File) objUploadByteArrayToFilename$default) == null) {
            return null;
        }
        return indexOfListOfBackupData;
    }

    private final void startBackingUp() {
        GoogleDrive googleDrive = this.googleDrive;
        if (googleDrive == null || !Utils.INSTANCE.isNetworkAvailable(getApplication().getApplicationContext())) {
            finishSynchronization();
            return;
        }
        boolean z = getApplication().getDefaultSharedPreferences().getBoolean(BooleanPreference.AUTOMATICALLY_BACKUP_TO_GOOGLE_DRIVE.getKey(), BooleanPreference.AUTOMATICALLY_BACKUP_TO_GOOGLE_DRIVE.getDefaultValue()) && System.currentTimeMillis() - getDefaultSharedPreferences().getLong("last_backup_timestamp", 0L) > 900000;
        this._statusLiveData.setValue(4);
        if ((z || this.backupScheduledManually) && googleDrive.getHasSignedIn()) {
            this.backupScheduledManually = false;
            getApplication().getDefaultSharedPreferences().edit().putLong("last_backup_timestamp", System.currentTimeMillis()).apply();
            Toast.makeText(getApplication(), getApplication().getString(R.string.backing_up), 0).show();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            DaijishouSynchronizationModel$startBackingUp$$inlined$CoroutineExceptionHandler$1 daijishouSynchronizationModel$startBackingUp$$inlined$CoroutineExceptionHandler$1 = new DaijishouSynchronizationModel$startBackingUp$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this, objectRef);
            this._statusLiveData.setValue(5);
            BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO().plus(daijishouSynchronizationModel$startBackingUp$$inlined$CoroutineExceptionHandler$1), (CoroutineStart) null, new C01331(objectRef, googleDrive, null), 2, (Object) null);
            return;
        }
        finishSynchronization();
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1", f = "DaijishouSynchronizationModel.kt", i = {0, 1, 1, 1, 2, 2, 2, 3, 3, 5}, l = {477, 480, 480, 481, 483, 489, 494, 496, 497, 499, 500}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "listOfBackupData", "inProgressFilename", "$this$launch", "listOfBackupData", "inProgressFilename", "$this$launch", "listOfBackupData", "listOfBackupData"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
    static final class C01331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GoogleDrive $googleDrive;
        final /* synthetic */ Ref.ObjectRef<Companion.IndexOfListOfBackupData> $indexOfListOfBackupDataInProgress;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01331(Ref.ObjectRef<Companion.IndexOfListOfBackupData> objectRef, GoogleDrive googleDrive, Continuation<? super C01331> continuation) {
            super(2, continuation);
            this.$indexOfListOfBackupDataInProgress = objectRef;
            this.$googleDrive = googleDrive;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01331 c01331 = DaijishouSynchronizationModel.this.new C01331(this.$indexOfListOfBackupDataInProgress, this.$googleDrive, continuation);
            c01331.L$0 = obj;
            return c01331;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01331) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x00a1  */
        /* JADX WARN: Code duplicated, block: B:23:0x00d8  */
        /* JADX WARN: Code duplicated, block: B:26:0x00e1  */
        /* JADX WARN: Code duplicated, block: B:29:0x00f3 A[PHI: r1 r3 r4
  0x00f3: PHI (r1v10 java.lang.String) = (r1v7 java.lang.String), (r1v7 java.lang.String), (r1v14 java.lang.String) binds: [B:25:0x00df, B:27:0x00f0, B:14:0x005c] A[DONT_GENERATE, DONT_INLINE]
  0x00f3: PHI (r3v12 java.util.List) = (r3v9 java.util.List), (r3v9 java.util.List), (r3v14 java.util.List) binds: [B:25:0x00df, B:27:0x00f0, B:14:0x005c] A[DONT_GENERATE, DONT_INLINE]
  0x00f3: PHI (r4v9 kotlinx.coroutines.CoroutineScope) = 
  (r4v6 kotlinx.coroutines.CoroutineScope)
  (r4v6 kotlinx.coroutines.CoroutineScope)
  (r4v11 kotlinx.coroutines.CoroutineScope)
 binds: [B:25:0x00df, B:27:0x00f0, B:14:0x005c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:32:0x010a  */
        /* JADX WARN: Code duplicated, block: B:35:0x0115  */
        /* JADX WARN: Code duplicated, block: B:40:0x013b  */
        /* JADX WARN: Code duplicated, block: B:43:0x017a  */
        /* JADX WARN: Code duplicated, block: B:47:0x018c  */
        /* JADX WARN: Code duplicated, block: B:53:0x0202 A[PHI: r8 r13
  0x0202: PHI (r8v6 com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1) = 
  (r8v1 com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1)
  (r8v7 com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1)
 binds: [B:51:0x01ff, B:9:0x0025] A[DONT_GENERATE, DONT_INLINE]
  0x0202: PHI (r13v36 java.lang.Object) = (r13v46 java.lang.Object), (r13v47 java.lang.Object) binds: [B:51:0x01ff, B:9:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:55:0x0206  */
        /* JADX WARN: Code duplicated, block: B:58:0x022e A[PHI: r8
  0x022e: PHI (r8v8 com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1) = 
  (r8v6 com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1)
  (r8v6 com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1)
  (r8v9 com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1)
 binds: [B:54:0x0204, B:56:0x022b, B:8:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:61:0x0251 A[PHI: r8
  0x0251: PHI (r8v10 com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1) = 
  (r8v8 com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1)
  (r8v11 com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1)
 binds: [B:59:0x024e, B:7:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:66:0x026d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:69:? A[LOOP:0: B:45:0x0186->B:69:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0134, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01331.AnonymousClass2(r12.this$0, null), r12) == r0) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x026b, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01331.AnonymousClass6(r8.this$0, null), r8) == r0) goto L63;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 654
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01331.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1$2", f = "DaijishouSynchronizationModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DaijishouSynchronizationModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DaijishouSynchronizationModel daijishouSynchronizationModel, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = daijishouSynchronizationModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
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
                    this.this$0.finishSynchronization();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1$3", f = "DaijishouSynchronizationModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DaijishouSynchronizationModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(DaijishouSynchronizationModel daijishouSynchronizationModel, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = daijishouSynchronizationModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, continuation);
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
                    this.this$0._statusLiveData.setValue(Boxing.boxInt(6));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1$6, reason: invalid class name */
        /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$startBackingUp$1$6", f = "DaijishouSynchronizationModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DaijishouSynchronizationModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass6(DaijishouSynchronizationModel daijishouSynchronizationModel, Continuation<? super AnonymousClass6> continuation) {
                super(2, continuation);
                this.this$0 = daijishouSynchronizationModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass6(this.this$0, continuation);
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
                    this.this$0.finishSynchronization();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishSynchronization() {
        this._statusLiveData.setValue(99);
        List list = (List) this._synchronizationOfPlatformListLiveData.getValue();
        this._statusLiveData.setValue(0);
        this.logger.debug(this, "Synchronization finished.");
        if (list != null && list.size() > 0) {
            startSyncingIfNot();
        } else if (this.backupScheduledManually && Utils.INSTANCE.isNetworkAvailable(getApplication().getApplicationContext())) {
            startSyncingIfNot();
        }
    }

    public final void scheduleSynchronizationOfPlatformByPlatformId(AppCompatActivity activity, long j) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        setupAndAcquireSynchronizationOfPlatform(activity, j).requestFullSynchronization();
        refreshLibrarySynchronization();
        startSyncingIfNot();
    }

    public final void scheduleSynchronizationOfAllPlatforms(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = this.daijishouLibraryRepository.getAllPlatformsStatically().iterator();
        while (it.hasNext()) {
            setupAndAcquireSynchronizationOfPlatform(activity, ((PlatformEntity) it.next()).getId()).requestFullSynchronization();
        }
        refreshLibrarySynchronization();
        startSyncingIfNot();
    }

    public final void scheduleScrapingOfPlayableItem(AppCompatActivity activity, PlayableItemEntity playableItemEntity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        Long attachedPlatformId = playableItemEntity.getAttachedPlatformId();
        if (attachedPlatformId != null) {
            setupAndAcquireSynchronizationOfPlatform(activity, attachedPlatformId.longValue()).requestScrapingOfPlayableItem(playableItemEntity);
            refreshLibrarySynchronization();
            startSyncingIfNot();
        }
    }

    public final void scheduleBackup() {
        this.backupScheduledManually = true;
        startSyncingIfNot();
    }

    public final void scheduleEveryPlatformUpdate() {
        this.updateEveryPlatform = true;
        startSyncingIfNot();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void importBoxArtsFromUriForPlatformId$default(DaijishouSynchronizationModel daijishouSynchronizationModel, long j, Uri uri, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function1 = null;
        }
        daijishouSynchronizationModel.importBoxArtsFromUriForPlatformId(j, uri, z2, function1);
    }

    public final void importBoxArtsFromUriForPlatformId(long j, Uri uri, boolean z, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        importPreviewMediaFromUriForPlatformId(j, uri, z, "box art", function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void importSnapshotsFromUriForPlatformId$default(DaijishouSynchronizationModel daijishouSynchronizationModel, long j, Uri uri, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function1 = null;
        }
        daijishouSynchronizationModel.importSnapshotsFromUriForPlatformId(j, uri, z2, function1);
    }

    public final void importSnapshotsFromUriForPlatformId(long j, Uri uri, boolean z, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        importPreviewMediaFromUriForPlatformId(j, uri, z, "snapshot", function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void importTitlesFromUriForPlatformId$default(DaijishouSynchronizationModel daijishouSynchronizationModel, long j, Uri uri, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function1 = null;
        }
        daijishouSynchronizationModel.importTitlesFromUriForPlatformId(j, uri, z2, function1);
    }

    public final void importTitlesFromUriForPlatformId(long j, Uri uri, boolean z, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        importPreviewMediaFromUriForPlatformId(j, uri, z, "title", function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void skipTagForXmlPullParser(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i = 1;
        while (i != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String readTextFromXmlPullParser(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.next() == 4) {
            String text = xmlPullParser.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            xmlPullParser.nextTag();
            return text;
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void importDatFilesFromUriForPlatformId$default(DaijishouSynchronizationModel daijishouSynchronizationModel, long j, Uri uri, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function1 = null;
        }
        daijishouSynchronizationModel.importDatFilesFromUriForPlatformId(j, uri, z2, function1);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importDatFilesFromUriForPlatformId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importDatFilesFromUriForPlatformId$1", f = "DaijishouSynchronizationModel.kt", i = {}, l = {603, 675}, m = "invokeSuspend", n = {}, s = {})
    static final class C01271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        final /* synthetic */ long $platformId;
        final /* synthetic */ Uri $uri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01271(long j, Uri uri, Function1<? super Boolean, Unit> function1, Continuation<? super C01271> continuation) {
            super(2, continuation);
            this.$platformId = j;
            this.$uri = uri;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DaijishouSynchronizationModel.this.new C01271(this.$platformId, this.$uri, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:61:0x01cb, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01271.AnonymousClass4(r18.$callback, null), r18) == r1) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x01e9, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01271.C00281(r18.$callback, null), r18) == r1) goto L67;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 495
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01271.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importDatFilesFromUriForPlatformId$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importDatFilesFromUriForPlatformId$1$1", f = "DaijishouSynchronizationModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Boolean, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00281(Function1<? super Boolean, Unit> function1, Continuation<? super C00281> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00281(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Function1<Boolean, Unit> function1 = this.$callback;
                if (function1 == null) {
                    return null;
                }
                function1.invoke(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importDatFilesFromUriForPlatformId$1$Game */
        /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"com/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel$importDatFilesFromUriForPlatformId$1$Game", "", "name", "", "description", "romName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getName", "setName", "getRomName", "setRomName", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel$importDatFilesFromUriForPlatformId$1$Game;", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Game {
            private String description;
            private String name;
            private String romName;

            public static /* synthetic */ Game copy$default(Game game, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = game.name;
                }
                if ((i & 2) != 0) {
                    str2 = game.description;
                }
                if ((i & 4) != 0) {
                    str3 = game.romName;
                }
                return game.copy(str, str2, str3);
            }

            public final String component1() {
                return this.name;
            }

            public final String component2() {
                return this.description;
            }

            public final String component3() {
                return this.romName;
            }

            public final Game copy(String str, String str2, String str3) {
                return new Game(str, str2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Game)) {
                    return false;
                }
                Game game = (Game) obj;
                return Intrinsics.areEqual(this.name, game.name) && Intrinsics.areEqual(this.description, game.description) && Intrinsics.areEqual(this.romName, game.romName);
            }

            public int hashCode() {
                String str = this.name;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.description;
                int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.romName;
                return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                return "Game(name=" + this.name + ", description=" + this.description + ", romName=" + this.romName + ")";
            }

            public Game(String str, String str2, String str3) {
                this.name = str;
                this.description = str2;
                this.romName = str3;
            }

            public /* synthetic */ Game(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }

            public final String getDescription() {
                return this.description;
            }

            public final String getName() {
                return this.name;
            }

            public final String getRomName() {
                return this.romName;
            }

            public final void setDescription(String str) {
                this.description = str;
            }

            public final void setName(String str) {
                this.name = str;
            }

            public final void setRomName(String str) {
                this.romName = str;
            }
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importDatFilesFromUriForPlatformId$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importDatFilesFromUriForPlatformId$1$4", f = "DaijishouSynchronizationModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Boolean, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass4(Function1<? super Boolean, Unit> function1, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Function1<Boolean, Unit> function1 = this.$callback;
                if (function1 != null) {
                    function1.invoke(Boxing.boxBoolean(true));
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void importXMLFilesFromUriForPlatformId$default(DaijishouSynchronizationModel daijishouSynchronizationModel, long j, Uri uri, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function1 = null;
        }
        daijishouSynchronizationModel.importXMLFilesFromUriForPlatformId(j, uri, z2, function1);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importXMLFilesFromUriForPlatformId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importXMLFilesFromUriForPlatformId$1", f = "DaijishouSynchronizationModel.kt", i = {}, l = {694, 792}, m = "invokeSuspend", n = {}, s = {})
    static final class C01291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        final /* synthetic */ long $platformId;
        final /* synthetic */ Uri $uri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01291(long j, Uri uri, Function1<? super Boolean, Unit> function1, Continuation<? super C01291> continuation) {
            super(2, continuation);
            this.$platformId = j;
            this.$uri = uri;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DaijishouSynchronizationModel.this.new C01291(this.$platformId, this.$uri, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:83:0x0288, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01291.AnonymousClass4(r26.$callback, null), r26) == r1) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x02a7, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01291.C00301(r26.$callback, null), r26) == r1) goto L89;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r27) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 704
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01291.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importXMLFilesFromUriForPlatformId$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importXMLFilesFromUriForPlatformId$1$1", f = "DaijishouSynchronizationModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Boolean, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00301(Function1<? super Boolean, Unit> function1, Continuation<? super C00301> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00301(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Function1<Boolean, Unit> function1 = this.$callback;
                if (function1 == null) {
                    return null;
                }
                function1.invoke(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importXMLFilesFromUriForPlatformId$1$Game */
        /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
        @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JB\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"com/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel$importXMLFilesFromUriForPlatformId$1$Game", "", "name", "", "desc", "genres", "", "Lcom/magneticchen/daijishou/data/Genre;", "path", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getGenres", "()Ljava/util/List;", "getName", "setName", "getPath", "setPath", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel$importXMLFilesFromUriForPlatformId$1$Game;", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Game {
            private String desc;
            private final List<Genre> genres;
            private String name;
            private String path;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Game copy$default(Game game, String str, String str2, List list, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = game.name;
                }
                if ((i & 2) != 0) {
                    str2 = game.desc;
                }
                if ((i & 4) != 0) {
                    list = game.genres;
                }
                if ((i & 8) != 0) {
                    str3 = game.path;
                }
                return game.copy(str, str2, list, str3);
            }

            public final String component1() {
                return this.name;
            }

            public final String component2() {
                return this.desc;
            }

            public final List<Genre> component3() {
                return this.genres;
            }

            public final String component4() {
                return this.path;
            }

            public final Game copy(String str, String str2, List<Genre> genres, String str3) {
                Intrinsics.checkNotNullParameter(genres, "genres");
                return new Game(str, str2, genres, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Game)) {
                    return false;
                }
                Game game = (Game) obj;
                return Intrinsics.areEqual(this.name, game.name) && Intrinsics.areEqual(this.desc, game.desc) && Intrinsics.areEqual(this.genres, game.genres) && Intrinsics.areEqual(this.path, game.path);
            }

            public int hashCode() {
                String str = this.name;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.desc;
                int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.genres.hashCode()) * 31;
                String str3 = this.path;
                return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                return "Game(name=" + this.name + ", desc=" + this.desc + ", genres=" + this.genres + ", path=" + this.path + ")";
            }

            public Game(String str, String str2, List<Genre> genres, String str3) {
                Intrinsics.checkNotNullParameter(genres, "genres");
                this.name = str;
                this.desc = str2;
                this.genres = genres;
                this.path = str3;
            }

            public final String getName() {
                return this.name;
            }

            public final void setName(String str) {
                this.name = str;
            }

            public final String getDesc() {
                return this.desc;
            }

            public final void setDesc(String str) {
                this.desc = str;
            }

            public /* synthetic */ Game(String str, String str2, ArrayList arrayList, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? new ArrayList() : arrayList, (i & 8) != 0 ? null : str3);
            }

            public final List<Genre> getGenres() {
                return this.genres;
            }

            public final String getPath() {
                return this.path;
            }

            public final void setPath(String str) {
                this.path = str;
            }
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importXMLFilesFromUriForPlatformId$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importXMLFilesFromUriForPlatformId$1$4", f = "DaijishouSynchronizationModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Boolean, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass4(Function1<? super Boolean, Unit> function1, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Function1<Boolean, Unit> function1 = this.$callback;
                if (function1 != null) {
                    function1.invoke(Boxing.boxBoolean(true));
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importPreviewMediaFromUriForPlatformId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importPreviewMediaFromUriForPlatformId$1", f = "DaijishouSynchronizationModel.kt", i = {}, l = {802, 892}, m = "invokeSuspend", n = {}, s = {})
    static final class C01281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        final /* synthetic */ long $platformId;
        final /* synthetic */ String $type;
        final /* synthetic */ Uri $uri;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01281(long j, Uri uri, Function1<? super Boolean, Unit> function1, String str, Continuation<? super C01281> continuation) {
            super(2, continuation);
            this.$platformId = j;
            this.$uri = uri;
            this.$callback = function1;
            this.$type = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01281 c01281 = DaijishouSynchronizationModel.this.new C01281(this.$platformId, this.$uri, this.$callback, this.$type, continuation);
            c01281.L$0 = obj;
            return c01281;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:66:0x02e8  */
        /* JADX WARN: Code duplicated, block: B:67:0x0316  */
        /* JADX WARN: Code duplicated, block: B:69:0x031d  */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0050, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01281.C00291(r33.$callback, null), r33) == r2) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x03cc, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01281.AnonymousClass4(r33.$callback, null), r33) == r2) goto L86;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r34) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 978
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.C01281.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importPreviewMediaFromUriForPlatformId$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importPreviewMediaFromUriForPlatformId$1$1", f = "DaijishouSynchronizationModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Boolean, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00291(Function1<? super Boolean, Unit> function1, Continuation<? super C00291> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00291(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Function1<Boolean, Unit> function1 = this.$callback;
                if (function1 == null) {
                    return null;
                }
                function1.invoke(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importPreviewMediaFromUriForPlatformId$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: DaijishouSynchronizationModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$importPreviewMediaFromUriForPlatformId$1$4", f = "DaijishouSynchronizationModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Boolean, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass4(Function1<? super Boolean, Unit> function1, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Function1<Boolean, Unit> function1 = this.$callback;
                if (function1 != null) {
                    function1.invoke(Boxing.boxBoolean(true));
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void importPreviewMediaFromUriForPlatformId$default(DaijishouSynchronizationModel daijishouSynchronizationModel, long j, Uri uri, boolean z, String str, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str = "box art";
        }
        String str2 = str;
        if ((i & 16) != 0) {
            function1 = null;
        }
        daijishouSynchronizationModel.importPreviewMediaFromUriForPlatformId(j, uri, z2, str2, function1);
    }

    public final void importPreviewMediaFromUriForPlatformId(long j, Uri uri, boolean z, String type, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(type, "type");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new C01281(j, uri, function1, type, null), 2, (Object) null);
    }

    public final void importDatFilesFromUriForPlatformId(long j, Uri uri, boolean z, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO().plus(new DaijishouSynchronizationModel$importDatFilesFromUriForPlatformId$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this, function1)), (CoroutineStart) null, new C01271(j, uri, function1, null), 2, (Object) null);
    }

    public final void importXMLFilesFromUriForPlatformId(long j, Uri uri, boolean z, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO().plus(new DaijishouSynchronizationModel$importXMLFilesFromUriForPlatformId$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this, function1)), (CoroutineStart) null, new C01291(j, uri, function1, null), 2, (Object) null);
    }
}
