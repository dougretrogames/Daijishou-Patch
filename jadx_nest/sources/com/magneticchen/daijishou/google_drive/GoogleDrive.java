package com.magneticchen.daijishou.google_drive;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.magneticchen.daijishou.DaijishouApplication;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.apache.http.HttpStatus;

/* JADX INFO: compiled from: GoogleDrive.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 W2\u00020\u0001:\u0002WXB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u0014J*\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00100J*\u00101\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020$2\u0006\u00102\u001a\u0002032\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00104J\u0018\u00105\u001a\u00020!2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00106J \u00107\u001a\u00020!2\u0006\u00108\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00109J \u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00109J\"\u0010=\u001a\u0004\u0018\u00010;2\u0006\u0010-\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00109J\"\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010-\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00109J&\u0010@\u001a\b\u0012\u0004\u0012\u00020,0#2\u0006\u0010-\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00109J&\u0010A\u001a\b\u0012\u0004\u0012\u00020,0#2\u0006\u0010B\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00109J\u0010\u0010C\u001a\u0004\u0018\u00010$2\u0006\u0010D\u001a\u00020$J\u0010\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020\u001fH\u0002J6\u0010G\u001a\b\u0012\u0004\u0012\u00020,0#2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010JJ\u0018\u0010K\u001a\u00020!2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00106J(\u0010L\u001a\u00020!2\u0006\u00108\u001a\u00020$2\u0006\u0010M\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010JJ\u0018\u0010N\u001a\u00020!2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00106J\b\u0010O\u001a\u00020!H\u0002J\u0018\u0010P\u001a\u00020!2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00106J\u0016\u0010Q\u001a\u00020!2\u0006\u0010D\u001a\u00020$2\u0006\u0010F\u001a\u00020$J\u0010\u0010R\u001a\u00020!2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010S\u001a\u00020!J*\u0010T\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020$2\u0006\u0010U\u001a\u00020;2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010VR\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0012\u0010\u001a\u001a\u00060\u001bR\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/magneticchen/daijishou/google_drive/GoogleDrive;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "_googleSignInAccountLiveData", "Lcom/magneticchen/daijishou/google_drive/GoogleDrive$GoogleSignInAccountLiveData;", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "driveOperationMutex", "Lkotlinx/coroutines/sync/Mutex;", "googleDriveService", "Lcom/google/api/services/drive/Drive;", "googleSignInAccount", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "googleSignInAccountLiveData", "Landroidx/lifecycle/LiveData;", "getGoogleSignInAccountLiveData", "()Landroidx/lifecycle/LiveData;", "hasSignedIn", "", "getHasSignedIn", "()Z", "setHasSignedIn", "(Z)V", "isLocked", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "requestSignInMutex", "signInIntentLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "batchDeleteFiles", "", "fileIds", "", "", "withLock", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindActivity", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "checkGooglePlayService", "createOrUpdateFileByFilenameAndInputStream", "Lcom/google/api/services/drive/model/File;", "filename", "inputStream", "Ljava/io/ByteArrayInputStream;", "(Ljava/lang/String;Ljava/io/ByteArrayInputStream;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createOrUpdateFileByInputStreamContent", "inputStreamContent", "Lcom/google/api/client/http/InputStreamContent;", "(Ljava/lang/String;Lcom/google/api/client/http/InputStreamContent;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllFiles", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFileByFileId", "fileId", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadByteArrayFromFileId", "", "id", "downloadByteArrayFromFilename", "getFileOutputStreamByFilename", "Ljava/io/ByteArrayOutputStream;", "getFilesByFilename", "getFilesByFilenameContainingSubstring", "substring", "getItem", "key", "handleSignInIntent", "data", "listAllFiles", SearchIntents.EXTRA_QUERY, "customFields", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logAllFiles", "renameFileByFileId", "name", "requestSignIn", "requestSignInExisted", "requestSignOut", "setItem", "setupGoogleSignInAccount", "unbindActivity", "uploadByteArrayToFilename", "byteArray", "(Ljava/lang/String;[BZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "GoogleSignInAccountLiveData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GoogleDrive {
    public static final int DEFAULT_PAGE_SIZE = 128;
    public static final String DEFAULT_SPACE = "appDataFolder";
    private static final GoogleSignInOptions signInOptions;
    private final GoogleSignInAccountLiveData _googleSignInAccountLiveData;
    private final DaijishouApplication application;
    private final Mutex driveOperationMutex;
    private Drive googleDriveService;
    private GoogleSignInAccount googleSignInAccount;
    private boolean hasSignedIn;
    private DaijishouApplication.WrappedLogger logger;
    private final Mutex requestSignInMutex;
    private ActivityResultLauncher<Intent> signInIntentLauncher;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Scope[] scopes = {new Scope("https://www.googleapis.com/auth/drive.file"), new Scope("https://www.googleapis.com/auth/drive.appdata")};

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$batchDeleteFiles$1, reason: invalid class name */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 0, 1}, l = {543, 266, 267}, m = "batchDeleteFiles", n = {"this", "fileIds", "batchRequest", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
    final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.batchDeleteFiles(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$createOrUpdateFileByFilenameAndInputStream$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 0, 1}, l = {543, 385, 386}, m = "createOrUpdateFileByFilenameAndInputStream", n = {"this", "filename", "inputStream", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
    final class C02291 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C02291(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.createOrUpdateFileByFilenameAndInputStream(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$createOrUpdateFileByInputStreamContent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 0, 1}, l = {543, 376, 377}, m = "createOrUpdateFileByInputStreamContent", n = {"this", "filename", "inputStreamContent", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
    final class C02301 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C02301(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.createOrUpdateFileByInputStreamContent(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$deleteAllFiles$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 1}, l = {543, 283, 284}, m = "deleteAllFiles", n = {"this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
    final class C02311 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02311(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.deleteAllFiles(false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$deleteFileByFileId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 1}, l = {543, 292, 293}, m = "deleteFileByFileId", n = {"this", "fileId", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
    final class C02321 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02321(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.deleteFileByFileId(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$downloadByteArrayFromFileId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 1}, l = {543, 439, 440}, m = "downloadByteArrayFromFileId", n = {"this", "id", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
    final class C02331 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02331(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.downloadByteArrayFromFileId(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$downloadByteArrayFromFilename$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 1}, l = {543, HttpStatus.SC_TOO_MANY_REQUESTS, 430}, m = "downloadByteArrayFromFilename", n = {"this", "filename", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
    final class C02341 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02341(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.downloadByteArrayFromFilename(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$getFileOutputStreamByFilename$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 1}, l = {543, 396, 397}, m = "getFileOutputStreamByFilename", n = {"this", "filename", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
    final class C02351 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02351(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.getFileOutputStreamByFilename(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$getFilesByFilename$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 1}, l = {543, 412, HttpStatus.SC_REQUEST_TOO_LONG}, m = "getFilesByFilename", n = {"this", "filename", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
    final class C02361 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02361(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.getFilesByFilename(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$getFilesByFilenameContainingSubstring$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 1}, l = {543, 404, 405}, m = "getFilesByFilenameContainingSubstring", n = {"this", "substring", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
    final class C02371 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02371(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.getFilesByFilenameContainingSubstring(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$listAllFiles$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 0, 1}, l = {543, 339, 340}, m = "listAllFiles", n = {"this", SearchIntents.EXTRA_QUERY, "customFields", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
    final class C02391 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C02391(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.listAllFiles(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$logAllFiles$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 1}, l = {543, 352, 353}, m = "logAllFiles", n = {"this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
    final class C02401 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02401(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.logAllFiles(false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$renameFileByFileId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 0, 1}, l = {543, 304, 305}, m = "renameFileByFileId", n = {"this", "fileId", "name", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
    final class C02411 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C02411(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.renameFileByFileId(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$requestSignIn$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 1}, l = {543, 188, 189}, m = "requestSignIn", n = {"this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
    final class C02421 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02421(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.requestSignIn(false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$requestSignOut$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 1}, l = {543, 210, 211}, m = "requestSignOut", n = {"this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
    final class C02431 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02431(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.requestSignOut(false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$uploadByteArrayToFilename$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 0, 1}, l = {543, 420, 421}, m = "uploadByteArrayToFilename", n = {"this", "filename", "byteArray", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
    final class C02451 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C02451(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.uploadByteArrayToFilename(null, null, false, this);
        }
    }

    public final String getItem(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    public final void setItem(String key, String data) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public GoogleDrive(DaijishouApplication application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this._googleSignInAccountLiveData = new GoogleSignInAccountLiveData();
        this.requestSignInMutex = MutexKt.Mutex$default(false, 1, null);
        this.driveOperationMutex = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/google_drive/GoogleDrive$Companion;", "", "()V", "DEFAULT_PAGE_SIZE", "", "DEFAULT_SPACE", "", "scopes", "", "Lcom/google/android/gms/common/api/Scope;", "getScopes", "()[Lcom/google/android/gms/common/api/Scope;", "[Lcom/google/android/gms/common/api/Scope;", "signInOptions", "Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "getSignInOptions", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Scope[] getScopes() {
            return GoogleDrive.scopes;
        }

        public final GoogleSignInOptions getSignInOptions() {
            return GoogleDrive.signInOptions;
        }
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    static {
        GoogleSignInOptions.Builder builderRequestEmail = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail();
        Intrinsics.checkNotNullExpressionValue(builderRequestEmail, "requestEmail(...)");
        builderRequestEmail.requestScopes(new Scope("https://www.googleapis.com/auth/drive.file"), new Scope("https://www.googleapis.com/auth/drive.appdata"));
        GoogleSignInOptions googleSignInOptionsBuild = builderRequestEmail.build();
        Intrinsics.checkNotNullExpressionValue(googleSignInOptionsBuild, "build(...)");
        signInOptions = googleSignInOptionsBuild;
    }

    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/google_drive/GoogleDrive$GoogleSignInAccountLiveData;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "(Lcom/magneticchen/daijishou/google_drive/GoogleDrive;)V", "onActive", "", "onInactive", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class GoogleSignInAccountLiveData extends MutableLiveData<GoogleSignInAccount> {
        public GoogleSignInAccountLiveData() {
        }

        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            setValue(GoogleDrive.this.googleSignInAccount);
        }

        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            super.onInactive();
        }
    }

    public final LiveData<GoogleSignInAccount> getGoogleSignInAccountLiveData() {
        return this._googleSignInAccountLiveData;
    }

    public final boolean getHasSignedIn() {
        return this.hasSignedIn;
    }

    public final void setHasSignedIn(boolean z) {
        this.hasSignedIn = z;
    }

    public final boolean isLocked() {
        return this.driveOperationMutex.isLocked();
    }

    public final boolean checkGooglePlayService() {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        Intrinsics.checkNotNullExpressionValue(googleApiAvailability, "getInstance(...)");
        return googleApiAvailability.isGooglePlayServicesAvailable(this.application) == 0;
    }

    private final void requestSignInExisted() {
        DaijishouApplication.WrappedLogger wrappedLogger = null;
        if (this.hasSignedIn) {
            DaijishouApplication.WrappedLogger wrappedLogger2 = this.logger;
            if (wrappedLogger2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
            } else {
                wrappedLogger = wrappedLogger2;
            }
            wrappedLogger.debug(this, "Already signed in, ignored request.");
            return;
        }
        if (checkGooglePlayService()) {
            try {
                GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(this.application);
                if (lastSignedInAccount != null) {
                    Scope[] scopeArr = scopes;
                    if (GoogleSignIn.hasPermissions(lastSignedInAccount, (Scope[]) Arrays.copyOf(scopeArr, scopeArr.length))) {
                        return;
                    }
                    setupGoogleSignInAccount(lastSignedInAccount);
                }
            } catch (Exception e) {
                DaijishouApplication.WrappedLogger wrappedLogger3 = this.logger;
                if (wrappedLogger3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    wrappedLogger3 = null;
                }
                wrappedLogger3.error(this, "Google Drive sign in via LastSignedInAccount error. [requestSignInExisted]");
                DaijishouApplication.WrappedLogger wrappedLogger4 = this.logger;
                if (wrappedLogger4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                } else {
                    wrappedLogger = wrappedLogger4;
                }
                wrappedLogger.error(this, ExceptionsKt.stackTraceToString(e));
            }
        }
    }

    public static /* synthetic */ Object requestSignIn$default(GoogleDrive googleDrive, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 1) != 0) {
            z = true;
        }
        return googleDrive.requestSignIn(z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0088  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009b, code lost:
    
        if (requestSignIn$runIt(r7, r0) == r1) goto L45;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v9, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object requestSignIn(boolean r8, kotlin.coroutines.Continuation<?> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.magneticchen.daijishou.google_drive.GoogleDrive.C02421
            if (r0 == 0) goto L14
            r0 = r9
            com.magneticchen.daijishou.google_drive.GoogleDrive$requestSignIn$1 r0 = (com.magneticchen.daijishou.google_drive.GoogleDrive.C02421) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.magneticchen.daijishou.google_drive.GoogleDrive$requestSignIn$1 r0 = new com.magneticchen.daijishou.google_drive.GoogleDrive$requestSignIn$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L50
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            kotlin.ResultKt.throwOnFailure(r9)
            goto L9e
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L42
            goto L89
        L42:
            r9 = move-exception
            goto L91
        L44:
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r2 = r0.L$0
            com.magneticchen.daijishou.google_drive.GoogleDrive r2 = (com.magneticchen.daijishou.google_drive.GoogleDrive) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L7c
        L50:
            kotlin.ResultKt.throwOnFailure(r9)
            boolean r9 = r7.hasSignedIn
            if (r9 == 0) goto L6a
            com.magneticchen.daijishou.DaijishouApplication$WrappedLogger r8 = r7.logger
            if (r8 != 0) goto L61
            java.lang.String r8 = "logger"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            goto L62
        L61:
            r6 = r8
        L62:
            java.lang.String r8 = "Already signed in, ignored request."
            r6.debug(r7, r8)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L6a:
            if (r8 == 0) goto L95
            kotlinx.coroutines.sync.Mutex r8 = r7.driveOperationMutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r9 = r8.lock(r6, r0)
            if (r9 != r1) goto L7b
            goto L9d
        L7b:
            r2 = r7
        L7c:
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L42
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L42
            r0.label = r4     // Catch: java.lang.Throwable -> L42
            java.lang.Object r9 = requestSignIn$runIt(r2, r0)     // Catch: java.lang.Throwable -> L42
            if (r9 != r1) goto L89
            goto L9d
        L89:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L42
            r8.unlock(r6)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L91:
            r8.unlock(r6)
            throw r9
        L95:
            r0.label = r3
            java.lang.Object r8 = requestSignIn$runIt(r7, r0)
            if (r8 != r1) goto L9e
        L9d:
            return r1
        L9e:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.google_drive.GoogleDrive.requestSignIn(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:45:0x00d1 A[Catch: Exception -> 0x00d5, all -> 0x00fc, TRY_LEAVE, TryCatch #1 {Exception -> 0x00d5, blocks: (B:31:0x0091, B:33:0x009b, B:38:0x00af, B:40:0x00b3, B:41:0x00b7, B:43:0x00c0, B:44:0x00c4, B:45:0x00d1), top: B:63:0x0091, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
    
        if (kotlinx.coroutines.sync.Mutex.DefaultImpls.lock$default(r8, null, r1, 1, null) == r2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007f, code lost:
    
        if (r8.lock(null, r1) == r2) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object requestSignIn$runIt(com.magneticchen.daijishou.google_drive.GoogleDrive r7, kotlin.coroutines.Continuation<?> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.google_drive.GoogleDrive.requestSignIn$runIt(com.magneticchen.daijishou.google_drive.GoogleDrive, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final void requestSignIn$runIt$lambda$0$signInViaGooglePlay(GoogleDrive googleDrive, GoogleSignInClient googleSignInClient) {
        ActivityResultLauncher<Intent> activityResultLauncher = googleDrive.signInIntentLauncher;
        Intrinsics.checkNotNull(activityResultLauncher);
        activityResultLauncher.launch(googleSignInClient.getSignInIntent());
    }

    public static /* synthetic */ Object requestSignOut$default(GoogleDrive googleDrive, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 1) != 0) {
            z = true;
        }
        return googleDrive.requestSignOut(z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0088  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009b, code lost:
    
        if (requestSignOut$runIt$2(r7, r0) == r1) goto L45;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v9, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object requestSignOut(boolean r8, kotlin.coroutines.Continuation<?> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.magneticchen.daijishou.google_drive.GoogleDrive.C02431
            if (r0 == 0) goto L14
            r0 = r9
            com.magneticchen.daijishou.google_drive.GoogleDrive$requestSignOut$1 r0 = (com.magneticchen.daijishou.google_drive.GoogleDrive.C02431) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.magneticchen.daijishou.google_drive.GoogleDrive$requestSignOut$1 r0 = new com.magneticchen.daijishou.google_drive.GoogleDrive$requestSignOut$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L50
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            kotlin.ResultKt.throwOnFailure(r9)
            goto L9e
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L42
            goto L89
        L42:
            r9 = move-exception
            goto L91
        L44:
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r2 = r0.L$0
            com.magneticchen.daijishou.google_drive.GoogleDrive r2 = (com.magneticchen.daijishou.google_drive.GoogleDrive) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L7c
        L50:
            kotlin.ResultKt.throwOnFailure(r9)
            boolean r9 = r7.hasSignedIn
            if (r9 != 0) goto L6a
            com.magneticchen.daijishou.DaijishouApplication$WrappedLogger r8 = r7.logger
            if (r8 != 0) goto L61
            java.lang.String r8 = "logger"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            goto L62
        L61:
            r6 = r8
        L62:
            java.lang.String r8 = "Requested sign out but isSignedIn is false."
            r6.warn(r7, r8)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L6a:
            if (r8 == 0) goto L95
            kotlinx.coroutines.sync.Mutex r8 = r7.driveOperationMutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r9 = r8.lock(r6, r0)
            if (r9 != r1) goto L7b
            goto L9d
        L7b:
            r2 = r7
        L7c:
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L42
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L42
            r0.label = r4     // Catch: java.lang.Throwable -> L42
            java.lang.Object r9 = requestSignOut$runIt$2(r2, r0)     // Catch: java.lang.Throwable -> L42
            if (r9 != r1) goto L89
            goto L9d
        L89:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L42
            r8.unlock(r6)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L91:
            r8.unlock(r6)
            throw r9
        L95:
            r0.label = r3
            java.lang.Object r8 = requestSignOut$runIt$2(r7, r0)
            if (r8 != r1) goto L9e
        L9d:
            return r1
        L9e:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.google_drive.GoogleDrive.requestSignOut(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object requestSignOut$runIt$2(GoogleDrive googleDrive, Continuation<?> continuation) {
        googleDrive.hasSignedIn = false;
        GoogleSignInClient client = GoogleSignIn.getClient(googleDrive.application, signInOptions);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        client.signOut();
        client.revokeAccess();
        googleDrive.googleSignInAccount = null;
        googleDrive._googleSignInAccountLiveData.setValue(null);
        googleDrive.googleDriveService = null;
        return Unit.INSTANCE;
    }

    public final void bindActivity(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.logger = this.application.getLogger();
        this.signInIntentLauncher = activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new GoogleDrive$$ExternalSyntheticLambda0(this));
        requestSignInExisted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindActivity$lambda$4(GoogleDrive this$0, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DaijishouApplication.WrappedLogger wrappedLogger = null;
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            if (data == null) {
                DaijishouApplication.WrappedLogger wrappedLogger2 = this$0.logger;
                if (wrappedLogger2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                } else {
                    wrappedLogger = wrappedLogger2;
                }
                wrappedLogger.warn(this$0, "Google Drive sign-in results with empty data.");
                return;
            }
            this$0.handleSignInIntent(data);
            return;
        }
        DaijishouApplication.WrappedLogger wrappedLogger3 = this$0.logger;
        if (wrappedLogger3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logger");
            wrappedLogger3 = null;
        }
        int resultCode = activityResult.getResultCode();
        Intent data2 = activityResult.getData();
        Intent data3 = activityResult.getData();
        wrappedLogger3.warn(this$0, "Google Drive sign-in has a bad result code: " + resultCode + ".\nresult:{" + activityResult + ".}\ndata:" + data2 + "\ndata extra:" + (data3 != null ? data3.getExtras() : null));
    }

    public final void unbindActivity() {
        this.signInIntentLauncher = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x0097  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ae, code lost:
    
        if (batchDeleteFiles$runIt$5(r9, r8, r11, r0) == r1) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object batchDeleteFiles(java.util.List<java.lang.String> r9, boolean r10, kotlin.coroutines.Continuation<?> r11) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.magneticchen.daijishou.google_drive.GoogleDrive.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            com.magneticchen.daijishou.google_drive.GoogleDrive$batchDeleteFiles$1 r0 = (com.magneticchen.daijishou.google_drive.GoogleDrive.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.magneticchen.daijishou.google_drive.GoogleDrive$batchDeleteFiles$1 r0 = new com.magneticchen.daijishou.google_drive.GoogleDrive$batchDeleteFiles$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L5b
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lb1
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L42
            goto L98
        L42:
            r10 = move-exception
            goto La4
        L44:
            java.lang.Object r9 = r0.L$3
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r10 = r0.L$2
            com.google.api.client.googleapis.batch.BatchRequest r10 = (com.google.api.client.googleapis.batch.BatchRequest) r10
            java.lang.Object r2 = r0.L$1
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r0.L$0
            com.magneticchen.daijishou.google_drive.GoogleDrive r3 = (com.magneticchen.daijishou.google_drive.GoogleDrive) r3
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r10
            r10 = r9
            r9 = r2
            goto L86
        L5b:
            kotlin.ResultKt.throwOnFailure(r11)
            boolean r11 = r9.isEmpty()
            if (r11 == 0) goto L67
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L67:
            com.google.api.services.drive.Drive r11 = r8.googleDriveService
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            com.google.api.client.googleapis.batch.BatchRequest r11 = r11.batch()
            if (r10 == 0) goto La8
            kotlinx.coroutines.sync.Mutex r10 = r8.driveOperationMutex
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r11
            r0.L$3 = r10
            r0.label = r5
            java.lang.Object r2 = r10.lock(r6, r0)
            if (r2 != r1) goto L85
            goto Lb0
        L85:
            r3 = r8
        L86:
            r0.L$0 = r10     // Catch: java.lang.Throwable -> La0
            r0.L$1 = r6     // Catch: java.lang.Throwable -> La0
            r0.L$2 = r6     // Catch: java.lang.Throwable -> La0
            r0.L$3 = r6     // Catch: java.lang.Throwable -> La0
            r0.label = r4     // Catch: java.lang.Throwable -> La0
            java.lang.Object r9 = batchDeleteFiles$runIt$5(r9, r3, r11, r0)     // Catch: java.lang.Throwable -> La0
            if (r9 != r1) goto L97
            goto Lb0
        L97:
            r9 = r10
        L98:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L42
            r9.unlock(r6)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        La0:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        La4:
            r9.unlock(r6)
            throw r10
        La8:
            r0.label = r3
            java.lang.Object r9 = batchDeleteFiles$runIt$5(r9, r8, r11, r0)
            if (r9 != r1) goto Lb1
        Lb0:
            return r1
        Lb1:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.google_drive.GoogleDrive.batchDeleteFiles(java.util.List, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object batchDeleteFiles$default(GoogleDrive googleDrive, List list, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 2) != 0) {
            z = true;
        }
        return googleDrive.batchDeleteFiles(list, z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object batchDeleteFiles$runIt$5(List<String> list, GoogleDrive googleDrive, BatchRequest batchRequest, Continuation<?> continuation) throws IOException {
        for (String str : list) {
            Drive drive = googleDrive.googleDriveService;
            Intrinsics.checkNotNull(drive);
            drive.files().delete(str).queue(batchRequest, new GoogleDrive$batchDeleteFiles$runIt$2(str));
        }
        batchRequest.execute();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object deleteAllFiles$default(GoogleDrive googleDrive, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 1) != 0) {
            z = true;
        }
        return googleDrive.deleteAllFiles(z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0070  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
    
        if (deleteAllFiles$runIt$8(r7, r0) == r1) goto L38;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v5, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object deleteAllFiles(boolean r8, kotlin.coroutines.Continuation<?> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.magneticchen.daijishou.google_drive.GoogleDrive.C02311
            if (r0 == 0) goto L14
            r0 = r9
            com.magneticchen.daijishou.google_drive.GoogleDrive$deleteAllFiles$1 r0 = (com.magneticchen.daijishou.google_drive.GoogleDrive.C02311) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.magneticchen.daijishou.google_drive.GoogleDrive$deleteAllFiles$1 r0 = new com.magneticchen.daijishou.google_drive.GoogleDrive$deleteAllFiles$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L4f
            if (r2 == r5) goto L43
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            kotlin.ResultKt.throwOnFailure(r9)
            goto L86
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L41
            goto L71
        L41:
            r9 = move-exception
            goto L79
        L43:
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r2 = r0.L$0
            com.magneticchen.daijishou.google_drive.GoogleDrive r2 = (com.magneticchen.daijishou.google_drive.GoogleDrive) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L64
        L4f:
            kotlin.ResultKt.throwOnFailure(r9)
            if (r8 == 0) goto L7d
            kotlinx.coroutines.sync.Mutex r8 = r7.driveOperationMutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r9 = r8.lock(r6, r0)
            if (r9 != r1) goto L63
            goto L85
        L63:
            r2 = r7
        L64:
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L41
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L41
            r0.label = r4     // Catch: java.lang.Throwable -> L41
            java.lang.Object r9 = deleteAllFiles$runIt$8(r2, r0)     // Catch: java.lang.Throwable -> L41
            if (r9 != r1) goto L71
            goto L85
        L71:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L41
            r8.unlock(r6)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L79:
            r8.unlock(r6)
            throw r9
        L7d:
            r0.label = r3
            java.lang.Object r8 = deleteAllFiles$runIt$8(r7, r0)
            if (r8 != r1) goto L86
        L85:
            return r1
        L86:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.google_drive.GoogleDrive.deleteAllFiles(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0095, code lost:
    
        if (r10.batchDeleteFiles(r1, false, r5) == r0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object deleteAllFiles$runIt$8(com.magneticchen.daijishou.google_drive.GoogleDrive r10, kotlin.coroutines.Continuation<?> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof com.magneticchen.daijishou.google_drive.GoogleDrive$deleteAllFiles$runIt$1
            if (r0 == 0) goto L14
            r0 = r11
            com.magneticchen.daijishou.google_drive.GoogleDrive$deleteAllFiles$runIt$1 r0 = (com.magneticchen.daijishou.google_drive.GoogleDrive$deleteAllFiles$runIt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.magneticchen.daijishou.google_drive.GoogleDrive$deleteAllFiles$runIt$1 r0 = new com.magneticchen.daijishou.google_drive.GoogleDrive$deleteAllFiles$runIt$1
            r0.<init>(r11)
        L19:
            r5 = r0
            java.lang.Object r11 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r8 = 0
            r9 = 2
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 == r2) goto L37
            if (r1 != r9) goto L2f
            kotlin.ResultKt.throwOnFailure(r11)
            goto L98
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            java.lang.Object r10 = r5.L$0
            com.magneticchen.daijishou.google_drive.GoogleDrive r10 = (com.magneticchen.daijishou.google_drive.GoogleDrive) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L63
        L3f:
            kotlin.ResultKt.throwOnFailure(r11)
            com.google.api.services.drive.Drive r11 = r10.googleDriveService
            if (r11 == 0) goto L4b
            com.google.api.services.drive.Drive$Files r11 = r11.files()
            goto L4c
        L4b:
            r11 = r8
        L4c:
            if (r11 != 0) goto L51
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L51:
            r5.L$0 = r10
            r5.label = r2
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 3
            r7 = 0
            r1 = r10
            java.lang.Object r11 = listAllFiles$default(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r0) goto L62
            goto L97
        L62:
            r10 = r1
        L63:
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r2)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r11 = r11.iterator()
        L76:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L8a
            java.lang.Object r2 = r11.next()
            com.google.api.services.drive.model.File r2 = (com.google.api.services.drive.model.File) r2
            java.lang.String r2 = r2.getId()
            r1.add(r2)
            goto L76
        L8a:
            java.util.List r1 = (java.util.List) r1
            r5.L$0 = r8
            r5.label = r9
            r11 = 0
            java.lang.Object r10 = r10.batchDeleteFiles(r1, r11, r5)
            if (r10 != r0) goto L98
        L97:
            return r0
        L98:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.google_drive.GoogleDrive.deleteAllFiles$runIt$8(com.magneticchen.daijishou.google_drive.GoogleDrive, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object deleteFileByFileId$default(GoogleDrive googleDrive, String str, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 2) != 0) {
            z = true;
        }
        return googleDrive.deleteFileByFileId(str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0094, code lost:
    
        if (deleteFileByFileId$runIt$10(r8, r9, r0) == r1) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object deleteFileByFileId(java.lang.String r9, boolean r10, kotlin.coroutines.Continuation<?> r11) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.magneticchen.daijishou.google_drive.GoogleDrive.C02321
            if (r0 == 0) goto L14
            r0 = r11
            com.magneticchen.daijishou.google_drive.GoogleDrive$deleteFileByFileId$1 r0 = (com.magneticchen.daijishou.google_drive.GoogleDrive.C02321) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.magneticchen.daijishou.google_drive.GoogleDrive$deleteFileByFileId$1 r0 = new com.magneticchen.daijishou.google_drive.GoogleDrive$deleteFileByFileId$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L57
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            kotlin.ResultKt.throwOnFailure(r11)
            goto L97
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L42
            goto L7e
        L42:
            r10 = move-exception
            goto L8a
        L44:
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r10 = r0.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r2 = r0.L$0
            com.magneticchen.daijishou.google_drive.GoogleDrive r2 = (com.magneticchen.daijishou.google_drive.GoogleDrive) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r7 = r10
            r10 = r9
            r9 = r7
            goto L6e
        L57:
            kotlin.ResultKt.throwOnFailure(r11)
            if (r10 == 0) goto L8e
            kotlinx.coroutines.sync.Mutex r10 = r8.driveOperationMutex
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r5
            java.lang.Object r11 = r10.lock(r6, r0)
            if (r11 != r1) goto L6d
            goto L96
        L6d:
            r2 = r8
        L6e:
            r0.L$0 = r10     // Catch: java.lang.Throwable -> L86
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L86
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L86
            r0.label = r4     // Catch: java.lang.Throwable -> L86
            java.lang.Object r9 = deleteFileByFileId$runIt$10(r2, r9, r0)     // Catch: java.lang.Throwable -> L86
            if (r9 != r1) goto L7d
            goto L96
        L7d:
            r9 = r10
        L7e:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L42
            r9.unlock(r6)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L86:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L8a:
            r9.unlock(r6)
            throw r10
        L8e:
            r0.label = r3
            java.lang.Object r9 = deleteFileByFileId$runIt$10(r8, r9, r0)
            if (r9 != r1) goto L97
        L96:
            return r1
        L97:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.google_drive.GoogleDrive.deleteFileByFileId(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object deleteFileByFileId$runIt$10(GoogleDrive googleDrive, String str, Continuation<?> continuation) throws Throwable {
        Drive drive = googleDrive.googleDriveService;
        Drive.Files files = drive != null ? drive.files() : null;
        if (files == null) {
            return Unit.INSTANCE;
        }
        files.delete(str).execute();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object renameFileByFileId$default(GoogleDrive googleDrive, String str, String str2, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 4) != 0) {
            z = true;
        }
        return googleDrive.renameFileByFileId(str, str2, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0085  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009a, code lost:
    
        if (renameFileByFileId$runIt$12(r8, r9, r10, r0) == r1) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object renameFileByFileId(java.lang.String r9, java.lang.String r10, boolean r11, kotlin.coroutines.Continuation<?> r12) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.magneticchen.daijishou.google_drive.GoogleDrive.C02411
            if (r0 == 0) goto L14
            r0 = r12
            com.magneticchen.daijishou.google_drive.GoogleDrive$renameFileByFileId$1 r0 = (com.magneticchen.daijishou.google_drive.GoogleDrive.C02411) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.magneticchen.daijishou.google_drive.GoogleDrive$renameFileByFileId$1 r0 = new com.magneticchen.daijishou.google_drive.GoogleDrive$renameFileByFileId$1
            r0.<init>(r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L5b
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            kotlin.ResultKt.throwOnFailure(r12)
            goto L9d
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L42
            goto L86
        L42:
            r10 = move-exception
            goto L90
        L44:
            java.lang.Object r9 = r0.L$3
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r10 = r0.L$2
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r0.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r2 = r0.L$0
            com.magneticchen.daijishou.google_drive.GoogleDrive r2 = (com.magneticchen.daijishou.google_drive.GoogleDrive) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r7 = r11
            r11 = r9
            r9 = r7
            goto L74
        L5b:
            kotlin.ResultKt.throwOnFailure(r12)
            if (r11 == 0) goto L94
            kotlinx.coroutines.sync.Mutex r11 = r8.driveOperationMutex
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r11
            r0.label = r5
            java.lang.Object r12 = r11.lock(r6, r0)
            if (r12 != r1) goto L73
            goto L9c
        L73:
            r2 = r8
        L74:
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L8e
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L8e
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L8e
            r0.L$3 = r6     // Catch: java.lang.Throwable -> L8e
            r0.label = r4     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r9 = renameFileByFileId$runIt$12(r2, r9, r10, r0)     // Catch: java.lang.Throwable -> L8e
            if (r9 != r1) goto L85
            goto L9c
        L85:
            r9 = r11
        L86:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L42
            r9.unlock(r6)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L8e:
            r10 = move-exception
            r9 = r11
        L90:
            r9.unlock(r6)
            throw r10
        L94:
            r0.label = r3
            java.lang.Object r9 = renameFileByFileId$runIt$12(r8, r9, r10, r0)
            if (r9 != r1) goto L9d
        L9c:
            return r1
        L9d:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.google_drive.GoogleDrive.renameFileByFileId(java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object renameFileByFileId$runIt$12(GoogleDrive googleDrive, String str, String str2, Continuation<?> continuation) throws Throwable {
        Drive drive = googleDrive.googleDriveService;
        Drive.Files files = drive != null ? drive.files() : null;
        if (files == null) {
            return Unit.INSTANCE;
        }
        File fileExecute = files.get(str).execute();
        fileExecute.setName(str2);
        fileExecute.setId(null);
        files.update(str, fileExecute).execute();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object listAllFiles$default(GoogleDrive googleDrive, String str, String str2, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return googleDrive.listAllFiles(str, str2, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0085  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0098, code lost:
    
        if (r12 == r1) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object listAllFiles(java.lang.String r9, java.lang.String r10, boolean r11, kotlin.coroutines.Continuation<?> r12) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.magneticchen.daijishou.google_drive.GoogleDrive.C02391
            if (r0 == 0) goto L14
            r0 = r12
            com.magneticchen.daijishou.google_drive.GoogleDrive$listAllFiles$1 r0 = (com.magneticchen.daijishou.google_drive.GoogleDrive.C02391) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.magneticchen.daijishou.google_drive.GoogleDrive$listAllFiles$1 r0 = new com.magneticchen.daijishou.google_drive.GoogleDrive$listAllFiles$1
            r0.<init>(r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L5b
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            kotlin.ResultKt.throwOnFailure(r12)
            goto L9b
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L42
            goto L86
        L42:
            r10 = move-exception
            goto L8e
        L44:
            java.lang.Object r9 = r0.L$3
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r10 = r0.L$2
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r0.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r2 = r0.L$0
            com.magneticchen.daijishou.google_drive.GoogleDrive r2 = (com.magneticchen.daijishou.google_drive.GoogleDrive) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r7 = r11
            r11 = r9
            r9 = r7
            goto L74
        L5b:
            kotlin.ResultKt.throwOnFailure(r12)
            if (r11 == 0) goto L92
            kotlinx.coroutines.sync.Mutex r11 = r8.driveOperationMutex
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r11
            r0.label = r5
            java.lang.Object r12 = r11.lock(r6, r0)
            if (r12 != r1) goto L73
            goto L9a
        L73:
            r2 = r8
        L74:
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L8c
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L8c
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L8c
            r0.L$3 = r6     // Catch: java.lang.Throwable -> L8c
            r0.label = r4     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r12 = listAllFiles$runIt$15(r2, r9, r10, r0)     // Catch: java.lang.Throwable -> L8c
            if (r12 != r1) goto L85
            goto L9a
        L85:
            r9 = r11
        L86:
            java.util.List r12 = (java.util.List) r12     // Catch: java.lang.Throwable -> L42
            r9.unlock(r6)
            return r12
        L8c:
            r10 = move-exception
            r9 = r11
        L8e:
            r9.unlock(r6)
            throw r10
        L92:
            r0.label = r3
            java.lang.Object r12 = listAllFiles$runIt$15(r8, r9, r10, r0)
            if (r12 != r1) goto L9b
        L9a:
            return r1
        L9b:
            java.util.List r12 = (java.util.List) r12
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.google_drive.GoogleDrive.listAllFiles(java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.google.api.services.drive.Drive$Files$List] */
    /* JADX WARN: Type inference failed for: r8v5, types: [com.google.api.services.drive.Drive$Files$List] */
    public static final Object listAllFiles$runIt$15(GoogleDrive googleDrive, String str, String str2, Continuation<?> continuation) throws Throwable {
        ArrayList arrayList = new ArrayList();
        Drive drive = googleDrive.googleDriveService;
        Intrinsics.checkNotNull(drive);
        Drive.Files files = drive.files();
        Intrinsics.checkNotNull(files);
        Drive.Files.List q = files.list().setSpaces(DEFAULT_SPACE).setQ(str);
        if (str2 == null) {
            str2 = "id, name, createdTime, modifiedTime, size, md5Checksum";
        }
        FileList fileListExecute = q.setFields("nextPageToken, files(" + str2 + ")").setPageSize(Boxing.boxInt(128)).execute();
        List<File> files2 = fileListExecute.getFiles();
        Intrinsics.checkNotNullExpressionValue(files2, "getFiles(...)");
        arrayList.addAll(files2);
        String nextPageToken = fileListExecute.getNextPageToken();
        while (nextPageToken != null) {
            FileList fileListExecute2 = files.list().setSpaces(DEFAULT_SPACE).setQ(str).setFields("nextPageToken, files(id, name, createdTime, modifiedTime, size, md5Checksum)").setPageSize(Boxing.boxInt(128)).setPageToken(nextPageToken).execute();
            Intrinsics.checkNotNullExpressionValue(fileListExecute2, "execute(...)");
            FileList fileList = fileListExecute2;
            List<File> files3 = fileList.getFiles();
            Intrinsics.checkNotNullExpressionValue(files3, "getFiles(...)");
            arrayList.addAll(files3);
            nextPageToken = fileList.getNextPageToken();
            if (nextPageToken != null) {
                DaijishouApplication.WrappedLogger wrappedLogger = googleDrive.logger;
                if (wrappedLogger == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    wrappedLogger = null;
                }
                wrappedLogger.debug(googleDrive, nextPageToken.toString());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((File) it.next()).setParents(Collections.singletonList(DEFAULT_SPACE));
        }
        return arrayList;
    }

    public static /* synthetic */ Object logAllFiles$default(GoogleDrive googleDrive, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 1) != 0) {
            z = true;
        }
        return googleDrive.logAllFiles(z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0070  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
    
        if (logAllFiles$runIt$17(r7, r0) == r1) goto L38;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v5, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object logAllFiles(boolean r8, kotlin.coroutines.Continuation<?> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.magneticchen.daijishou.google_drive.GoogleDrive.C02401
            if (r0 == 0) goto L14
            r0 = r9
            com.magneticchen.daijishou.google_drive.GoogleDrive$logAllFiles$1 r0 = (com.magneticchen.daijishou.google_drive.GoogleDrive.C02401) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.magneticchen.daijishou.google_drive.GoogleDrive$logAllFiles$1 r0 = new com.magneticchen.daijishou.google_drive.GoogleDrive$logAllFiles$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L4f
            if (r2 == r5) goto L43
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            kotlin.ResultKt.throwOnFailure(r9)
            goto L86
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L41
            goto L71
        L41:
            r9 = move-exception
            goto L79
        L43:
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r2 = r0.L$0
            com.magneticchen.daijishou.google_drive.GoogleDrive r2 = (com.magneticchen.daijishou.google_drive.GoogleDrive) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L64
        L4f:
            kotlin.ResultKt.throwOnFailure(r9)
            if (r8 == 0) goto L7d
            kotlinx.coroutines.sync.Mutex r8 = r7.driveOperationMutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r9 = r8.lock(r6, r0)
            if (r9 != r1) goto L63
            goto L85
        L63:
            r2 = r7
        L64:
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L41
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L41
            r0.label = r4     // Catch: java.lang.Throwable -> L41
            java.lang.Object r9 = logAllFiles$runIt$17(r2, r0)     // Catch: java.lang.Throwable -> L41
            if (r9 != r1) goto L71
            goto L85
        L71:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L41
            r8.unlock(r6)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L79:
            r8.unlock(r6)
            throw r9
        L7d:
            r0.label = r3
            java.lang.Object r8 = logAllFiles$runIt$17(r7, r0)
            if (r8 != r1) goto L86
        L85:
            return r1
        L86:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.google_drive.GoogleDrive.logAllFiles(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object logAllFiles$runIt$17(GoogleDrive googleDrive, Continuation<?> continuation) throws Throwable {
        GoogleDrive$logAllFiles$runIt$1 googleDrive$logAllFiles$runIt$1;
        GoogleDrive googleDrive2;
        if (continuation instanceof GoogleDrive$logAllFiles$runIt$1) {
            googleDrive$logAllFiles$runIt$1 = (GoogleDrive$logAllFiles$runIt$1) continuation;
            if ((googleDrive$logAllFiles$runIt$1.label & Integer.MIN_VALUE) != 0) {
                googleDrive$logAllFiles$runIt$1.label -= Integer.MIN_VALUE;
            } else {
                googleDrive$logAllFiles$runIt$1 = new GoogleDrive$logAllFiles$runIt$1(continuation);
            }
        } else {
            googleDrive$logAllFiles$runIt$1 = new GoogleDrive$logAllFiles$runIt$1(continuation);
        }
        GoogleDrive$logAllFiles$runIt$1 googleDrive$logAllFiles$runIt$2 = googleDrive$logAllFiles$runIt$1;
        Object objListAllFiles$default = googleDrive$logAllFiles$runIt$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = googleDrive$logAllFiles$runIt$2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objListAllFiles$default);
            googleDrive$logAllFiles$runIt$2.L$0 = googleDrive;
            googleDrive$logAllFiles$runIt$2.label = 1;
            objListAllFiles$default = listAllFiles$default(googleDrive, null, null, false, googleDrive$logAllFiles$runIt$2, 3, null);
            if (objListAllFiles$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            googleDrive2 = googleDrive;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            googleDrive2 = (GoogleDrive) googleDrive$logAllFiles$runIt$2.L$0;
            ResultKt.throwOnFailure(objListAllFiles$default);
        }
        String str = "All files in your Google Drive:\n";
        for (File file : (List<File>) objListAllFiles$default) {
            str = str + "> " + file.getName() + " [" + file.getId() + "] createdTime: " + file.getCreatedTime() + ", modifiedTime: " + file.getModifiedTime() + ", size: " + file.getSize() + ", md5: " + file.getMd5Checksum() + "\n";
        }
        DaijishouApplication.WrappedLogger wrappedLogger = googleDrive2.logger;
        if (wrappedLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logger");
            wrappedLogger = null;
        }
        wrappedLogger.debug(googleDrive2, str);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object createOrUpdateFileByInputStreamContent$default(GoogleDrive googleDrive, String str, InputStreamContent inputStreamContent, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 4) != 0) {
            z = true;
        }
        return googleDrive.createOrUpdateFileByInputStreamContent(str, inputStreamContent, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createOrUpdateFileByInputStreamContent(String str, InputStreamContent inputStreamContent, boolean z, Continuation<?> continuation) throws Throwable {
        C02301 c02301;
        Mutex mutex = null;
        GoogleDrive googleDrive;
        Mutex mutex2;
        if (continuation instanceof C02301) {
            c02301 = (C02301) continuation;
            if ((c02301.label & Integer.MIN_VALUE) != 0) {
                c02301.label -= Integer.MIN_VALUE;
            } else {
                c02301 = new C02301(continuation);
            }
        } else {
            c02301 = new C02301(continuation);
        }
        Object objCreateOrUpdateFileByInputStreamContent$runIt$20 = c02301.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02301.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCreateOrUpdateFileByInputStreamContent$runIt$20);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c02301.L$0 = this;
                    c02301.L$1 = str;
                    c02301.L$2 = inputStreamContent;
                    c02301.L$3 = mutex;
                    c02301.label = 1;
                    if (mutex.lock(null, c02301) != coroutine_suspended) {
                        googleDrive = this;
                    }
                } else {
                    c02301.label = 3;
                    Object objCreateOrUpdateFileByInputStreamContent$runIt$21 = createOrUpdateFileByInputStreamContent$runIt$20(this, str, inputStreamContent, c02301);
                    if (objCreateOrUpdateFileByInputStreamContent$runIt$21 != coroutine_suspended) {
                        return objCreateOrUpdateFileByInputStreamContent$runIt$21;
                    }
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objCreateOrUpdateFileByInputStreamContent$runIt$20);
                    return objCreateOrUpdateFileByInputStreamContent$runIt$20;
                }
                mutex2 = (Mutex) c02301.L$0;
                try {
                    ResultKt.throwOnFailure(objCreateOrUpdateFileByInputStreamContent$runIt$20);
                    File file = (File) objCreateOrUpdateFileByInputStreamContent$runIt$20;
                    mutex2.unlock(null);
                    return file;
                } catch (Throwable th) {
                    th = th;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c02301.L$3;
            inputStreamContent = (InputStreamContent) c02301.L$2;
            String str2 = (String) c02301.L$1;
            googleDrive = (GoogleDrive) c02301.L$0;
            ResultKt.throwOnFailure(objCreateOrUpdateFileByInputStreamContent$runIt$20);
            mutex = mutex3;
            str = str2;
            c02301.L$0 = mutex;
            c02301.L$1 = null;
            c02301.L$2 = null;
            c02301.L$3 = null;
            c02301.label = 2;
            objCreateOrUpdateFileByInputStreamContent$runIt$20 = createOrUpdateFileByInputStreamContent$runIt$20(googleDrive, str, inputStreamContent, c02301);
            if (objCreateOrUpdateFileByInputStreamContent$runIt$20 != coroutine_suspended) {
                mutex2 = mutex;
                File file2 = (File) objCreateOrUpdateFileByInputStreamContent$runIt$20;
                mutex2.unlock(null);
                return file2;
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            Throwable th = null;
            th = th2;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object createOrUpdateFileByInputStreamContent$runIt$20(GoogleDrive googleDrive, String str, InputStreamContent inputStreamContent, Continuation<?> continuation) throws Throwable {
        GoogleDrive$createOrUpdateFileByInputStreamContent$runIt$1 googleDrive$createOrUpdateFileByInputStreamContent$runIt$1;
        Drive.Files files;
        File file;
        if (continuation instanceof GoogleDrive$createOrUpdateFileByInputStreamContent$runIt$1) {
            googleDrive$createOrUpdateFileByInputStreamContent$runIt$1 = (GoogleDrive$createOrUpdateFileByInputStreamContent$runIt$1) continuation;
            if ((googleDrive$createOrUpdateFileByInputStreamContent$runIt$1.label & Integer.MIN_VALUE) != 0) {
                googleDrive$createOrUpdateFileByInputStreamContent$runIt$1.label -= Integer.MIN_VALUE;
            } else {
                googleDrive$createOrUpdateFileByInputStreamContent$runIt$1 = new GoogleDrive$createOrUpdateFileByInputStreamContent$runIt$1(continuation);
            }
        } else {
            googleDrive$createOrUpdateFileByInputStreamContent$runIt$1 = new GoogleDrive$createOrUpdateFileByInputStreamContent$runIt$1(continuation);
        }
        GoogleDrive$createOrUpdateFileByInputStreamContent$runIt$1 googleDrive$createOrUpdateFileByInputStreamContent$runIt$2 = googleDrive$createOrUpdateFileByInputStreamContent$runIt$1;
        Object obj = googleDrive$createOrUpdateFileByInputStreamContent$runIt$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = googleDrive$createOrUpdateFileByInputStreamContent$runIt$2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Drive drive = googleDrive.googleDriveService;
            Intrinsics.checkNotNull(drive);
            Drive.Files files2 = drive.files();
            Intrinsics.checkNotNull(files2);
            File file2 = new File();
            file2.setName(str);
            file2.setParents(Collections.singletonList(DEFAULT_SPACE));
            googleDrive$createOrUpdateFileByInputStreamContent$runIt$2.L$0 = inputStreamContent;
            googleDrive$createOrUpdateFileByInputStreamContent$runIt$2.L$1 = files2;
            googleDrive$createOrUpdateFileByInputStreamContent$runIt$2.L$2 = file2;
            googleDrive$createOrUpdateFileByInputStreamContent$runIt$2.label = 1;
            Object objListAllFiles$default = listAllFiles$default(googleDrive, "name='" + str + "'", null, false, googleDrive$createOrUpdateFileByInputStreamContent$runIt$2, 2, null);
            if (objListAllFiles$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            files = files2;
            obj = objListAllFiles$default;
            file = file2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            file = (File) googleDrive$createOrUpdateFileByInputStreamContent$runIt$2.L$2;
            files = (Drive.Files) googleDrive$createOrUpdateFileByInputStreamContent$runIt$2.L$1;
            inputStreamContent = (InputStreamContent) googleDrive$createOrUpdateFileByInputStreamContent$runIt$2.L$0;
            ResultKt.throwOnFailure(obj);
        }
        for (File file3 : (Iterable<File>) obj) {
            String name = file3.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = name.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String name2 = file.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            Locale ROOT2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
            String lowerCase2 = name2.toLowerCase(ROOT2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, lowerCase2) && Intrinsics.areEqual(file.getParents(), file3.getParents())) {
                file.setParents(null);
                return files.update(file3.getId(), file, inputStreamContent).execute();
            }
        }
        return files.create(file, inputStreamContent).setFields("id").execute();
    }

    public static /* synthetic */ Object createOrUpdateFileByFilenameAndInputStream$default(GoogleDrive googleDrive, String str, ByteArrayInputStream byteArrayInputStream, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 4) != 0) {
            z = true;
        }
        return googleDrive.createOrUpdateFileByFilenameAndInputStream(str, byteArrayInputStream, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createOrUpdateFileByFilenameAndInputStream(String str, ByteArrayInputStream byteArrayInputStream, boolean z, Continuation<?> continuation) throws Throwable {
        C02291 c02291;
        Mutex mutex = null;
        GoogleDrive googleDrive;
        Mutex mutex2;
        if (continuation instanceof C02291) {
            c02291 = (C02291) continuation;
            if ((c02291.label & Integer.MIN_VALUE) != 0) {
                c02291.label -= Integer.MIN_VALUE;
            } else {
                c02291 = new C02291(continuation);
            }
        } else {
            c02291 = new C02291(continuation);
        }
        Object objCreateOrUpdateFileByFilenameAndInputStream$runIt$22 = c02291.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02291.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCreateOrUpdateFileByFilenameAndInputStream$runIt$22);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c02291.L$0 = this;
                    c02291.L$1 = str;
                    c02291.L$2 = byteArrayInputStream;
                    c02291.L$3 = mutex;
                    c02291.label = 1;
                    if (mutex.lock(null, c02291) != coroutine_suspended) {
                        googleDrive = this;
                    }
                } else {
                    c02291.label = 3;
                    Object objCreateOrUpdateFileByFilenameAndInputStream$runIt$23 = createOrUpdateFileByFilenameAndInputStream$runIt$22(byteArrayInputStream, this, str, c02291);
                    if (objCreateOrUpdateFileByFilenameAndInputStream$runIt$23 != coroutine_suspended) {
                        return objCreateOrUpdateFileByFilenameAndInputStream$runIt$23;
                    }
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objCreateOrUpdateFileByFilenameAndInputStream$runIt$22);
                    return objCreateOrUpdateFileByFilenameAndInputStream$runIt$22;
                }
                mutex2 = (Mutex) c02291.L$0;
                try {
                    ResultKt.throwOnFailure(objCreateOrUpdateFileByFilenameAndInputStream$runIt$22);
                    File file = (File) objCreateOrUpdateFileByFilenameAndInputStream$runIt$22;
                    mutex2.unlock(null);
                    return file;
                } catch (Throwable th) {
                    th = th;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c02291.L$3;
            byteArrayInputStream = (ByteArrayInputStream) c02291.L$2;
            String str2 = (String) c02291.L$1;
            googleDrive = (GoogleDrive) c02291.L$0;
            ResultKt.throwOnFailure(objCreateOrUpdateFileByFilenameAndInputStream$runIt$22);
            mutex = mutex3;
            str = str2;
            c02291.L$0 = mutex;
            c02291.L$1 = null;
            c02291.L$2 = null;
            c02291.L$3 = null;
            c02291.label = 2;
            objCreateOrUpdateFileByFilenameAndInputStream$runIt$22 = createOrUpdateFileByFilenameAndInputStream$runIt$22(byteArrayInputStream, googleDrive, str, c02291);
            if (objCreateOrUpdateFileByFilenameAndInputStream$runIt$22 != coroutine_suspended) {
                mutex2 = mutex;
                File file2 = (File) objCreateOrUpdateFileByFilenameAndInputStream$runIt$22;
                mutex2.unlock(null);
                return file2;
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            Throwable th = null;
            th = th2;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object createOrUpdateFileByFilenameAndInputStream$runIt$22(ByteArrayInputStream byteArrayInputStream, GoogleDrive googleDrive, String str, Continuation<?> continuation) throws Throwable {
        return googleDrive.createOrUpdateFileByInputStreamContent(str, new InputStreamContent("application/octet-stream", byteArrayInputStream), false, continuation);
    }

    public static /* synthetic */ Object getFileOutputStreamByFilename$default(GoogleDrive googleDrive, String str, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 2) != 0) {
            z = true;
        }
        return googleDrive.getFileOutputStreamByFilename(str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFileOutputStreamByFilename(String str, boolean z, Continuation<?> continuation) throws Throwable {
        C02351 c02351;
        Mutex mutex = null;
        GoogleDrive googleDrive;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof C02351) {
            c02351 = (C02351) continuation;
            if ((c02351.label & Integer.MIN_VALUE) != 0) {
                c02351.label -= Integer.MIN_VALUE;
            } else {
                c02351 = new C02351(continuation);
            }
        } else {
            c02351 = new C02351(continuation);
        }
        Object fileOutputStreamByFilename$runIt$24 = c02351.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02351.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(fileOutputStreamByFilename$runIt$24);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c02351.L$0 = this;
                    c02351.L$1 = str;
                    c02351.L$2 = mutex;
                    c02351.label = 1;
                    if (mutex.lock(null, c02351) != coroutine_suspended) {
                        googleDrive = this;
                    }
                } else {
                    c02351.label = 3;
                    Object fileOutputStreamByFilename$runIt$25 = getFileOutputStreamByFilename$runIt$24(this, str, c02351);
                    if (fileOutputStreamByFilename$runIt$25 != coroutine_suspended) {
                        return fileOutputStreamByFilename$runIt$25;
                    }
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(fileOutputStreamByFilename$runIt$24);
                    return fileOutputStreamByFilename$runIt$24;
                }
                mutex2 = (Mutex) c02351.L$0;
                try {
                    ResultKt.throwOnFailure(fileOutputStreamByFilename$runIt$24);
                    ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) fileOutputStreamByFilename$runIt$24;
                    mutex2.unlock(null);
                    return byteArrayOutputStream;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c02351.L$2;
            String str2 = (String) c02351.L$1;
            googleDrive = (GoogleDrive) c02351.L$0;
            ResultKt.throwOnFailure(fileOutputStreamByFilename$runIt$24);
            mutex = mutex3;
            str = str2;
            c02351.L$0 = mutex;
            c02351.L$1 = null;
            c02351.L$2 = null;
            c02351.label = 2;
            fileOutputStreamByFilename$runIt$24 = getFileOutputStreamByFilename$runIt$24(googleDrive, str, c02351);
            if (fileOutputStreamByFilename$runIt$24 != coroutine_suspended) {
                mutex2 = mutex;
                ByteArrayOutputStream byteArrayOutputStream2 = (ByteArrayOutputStream) fileOutputStreamByFilename$runIt$24;
                mutex2.unlock(null);
                return byteArrayOutputStream2;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object getFileOutputStreamByFilename$runIt$24(GoogleDrive googleDrive, String str, Continuation<?> continuation) throws Throwable {
        GoogleDrive$getFileOutputStreamByFilename$runIt$1 googleDrive$getFileOutputStreamByFilename$runIt$1;
        GoogleDrive googleDrive2;
        if (continuation instanceof GoogleDrive$getFileOutputStreamByFilename$runIt$1) {
            googleDrive$getFileOutputStreamByFilename$runIt$1 = (GoogleDrive$getFileOutputStreamByFilename$runIt$1) continuation;
            if ((googleDrive$getFileOutputStreamByFilename$runIt$1.label & Integer.MIN_VALUE) != 0) {
                googleDrive$getFileOutputStreamByFilename$runIt$1.label -= Integer.MIN_VALUE;
            } else {
                googleDrive$getFileOutputStreamByFilename$runIt$1 = new GoogleDrive$getFileOutputStreamByFilename$runIt$1(continuation);
            }
        } else {
            googleDrive$getFileOutputStreamByFilename$runIt$1 = new GoogleDrive$getFileOutputStreamByFilename$runIt$1(continuation);
        }
        GoogleDrive$getFileOutputStreamByFilename$runIt$1 googleDrive$getFileOutputStreamByFilename$runIt$2 = googleDrive$getFileOutputStreamByFilename$runIt$1;
        Object objListAllFiles$default = googleDrive$getFileOutputStreamByFilename$runIt$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = googleDrive$getFileOutputStreamByFilename$runIt$2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objListAllFiles$default);
            googleDrive$getFileOutputStreamByFilename$runIt$2.L$0 = googleDrive;
            googleDrive$getFileOutputStreamByFilename$runIt$2.label = 1;
            objListAllFiles$default = listAllFiles$default(googleDrive, "name='" + str + "'", null, false, googleDrive$getFileOutputStreamByFilename$runIt$2, 2, null);
            if (objListAllFiles$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            googleDrive2 = googleDrive;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            googleDrive2 = (GoogleDrive) googleDrive$getFileOutputStreamByFilename$runIt$2.L$0;
            ResultKt.throwOnFailure(objListAllFiles$default);
        }
        File file = (File) CollectionsKt.getOrNull((List) objListAllFiles$default, 0);
        if (file == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Drive drive = googleDrive2.googleDriveService;
        Intrinsics.checkNotNull(drive);
        drive.files().get(file.getId()).executeMediaAndDownloadTo(byteArrayOutputStream);
        return byteArrayOutputStream;
    }

    public static /* synthetic */ Object getFilesByFilenameContainingSubstring$default(GoogleDrive googleDrive, String str, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 2) != 0) {
            z = true;
        }
        return googleDrive.getFilesByFilenameContainingSubstring(str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFilesByFilenameContainingSubstring(String str, boolean z, Continuation<?> continuation) throws Throwable {
        C02371 c02371;
        Mutex mutex = null;
        GoogleDrive googleDrive;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof C02371) {
            c02371 = (C02371) continuation;
            if ((c02371.label & Integer.MIN_VALUE) != 0) {
                c02371.label -= Integer.MIN_VALUE;
            } else {
                c02371 = new C02371(continuation);
            }
        } else {
            c02371 = new C02371(continuation);
        }
        Object filesByFilenameContainingSubstring$runIt$26 = c02371.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02371.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(filesByFilenameContainingSubstring$runIt$26);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c02371.L$0 = this;
                    c02371.L$1 = str;
                    c02371.L$2 = mutex;
                    c02371.label = 1;
                    if (mutex.lock(null, c02371) != coroutine_suspended) {
                        googleDrive = this;
                    }
                } else {
                    c02371.label = 3;
                    Object filesByFilenameContainingSubstring$runIt$27 = getFilesByFilenameContainingSubstring$runIt$26(this, str, c02371);
                    if (filesByFilenameContainingSubstring$runIt$27 != coroutine_suspended) {
                        return filesByFilenameContainingSubstring$runIt$27;
                    }
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(filesByFilenameContainingSubstring$runIt$26);
                    return filesByFilenameContainingSubstring$runIt$26;
                }
                mutex2 = (Mutex) c02371.L$0;
                try {
                    ResultKt.throwOnFailure(filesByFilenameContainingSubstring$runIt$26);
                    List list = (List) filesByFilenameContainingSubstring$runIt$26;
                    mutex2.unlock(null);
                    return list;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c02371.L$2;
            String str2 = (String) c02371.L$1;
            googleDrive = (GoogleDrive) c02371.L$0;
            ResultKt.throwOnFailure(filesByFilenameContainingSubstring$runIt$26);
            mutex = mutex3;
            str = str2;
            c02371.L$0 = mutex;
            c02371.L$1 = null;
            c02371.L$2 = null;
            c02371.label = 2;
            filesByFilenameContainingSubstring$runIt$26 = getFilesByFilenameContainingSubstring$runIt$26(googleDrive, str, c02371);
            if (filesByFilenameContainingSubstring$runIt$26 != coroutine_suspended) {
                mutex2 = mutex;
                List list2 = (List) filesByFilenameContainingSubstring$runIt$26;
                mutex2.unlock(null);
                return list2;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getFilesByFilenameContainingSubstring$runIt$26(GoogleDrive googleDrive, String str, Continuation<?> continuation) throws Throwable {
        return listAllFiles$default(googleDrive, "name contains '" + str + "'", null, false, continuation, 2, null);
    }

    public static /* synthetic */ Object getFilesByFilename$default(GoogleDrive googleDrive, String str, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 2) != 0) {
            z = true;
        }
        return googleDrive.getFilesByFilename(str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFilesByFilename(String str, boolean z, Continuation<?> continuation) throws Throwable {
        C02361 c02361;
        Mutex mutex = null;
        GoogleDrive googleDrive;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof C02361) {
            c02361 = (C02361) continuation;
            if ((c02361.label & Integer.MIN_VALUE) != 0) {
                c02361.label -= Integer.MIN_VALUE;
            } else {
                c02361 = new C02361(continuation);
            }
        } else {
            c02361 = new C02361(continuation);
        }
        Object filesByFilename$runIt$28 = c02361.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02361.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(filesByFilename$runIt$28);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c02361.L$0 = this;
                    c02361.L$1 = str;
                    c02361.L$2 = mutex;
                    c02361.label = 1;
                    if (mutex.lock(null, c02361) != coroutine_suspended) {
                        googleDrive = this;
                    }
                } else {
                    c02361.label = 3;
                    Object filesByFilename$runIt$29 = getFilesByFilename$runIt$28(this, str, c02361);
                    if (filesByFilename$runIt$29 != coroutine_suspended) {
                        return filesByFilename$runIt$29;
                    }
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(filesByFilename$runIt$28);
                    return filesByFilename$runIt$28;
                }
                mutex2 = (Mutex) c02361.L$0;
                try {
                    ResultKt.throwOnFailure(filesByFilename$runIt$28);
                    List list = (List) filesByFilename$runIt$28;
                    mutex2.unlock(null);
                    return list;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c02361.L$2;
            String str2 = (String) c02361.L$1;
            googleDrive = (GoogleDrive) c02361.L$0;
            ResultKt.throwOnFailure(filesByFilename$runIt$28);
            mutex = mutex3;
            str = str2;
            c02361.L$0 = mutex;
            c02361.L$1 = null;
            c02361.L$2 = null;
            c02361.label = 2;
            filesByFilename$runIt$28 = getFilesByFilename$runIt$28(googleDrive, str, c02361);
            if (filesByFilename$runIt$28 != coroutine_suspended) {
                mutex2 = mutex;
                List list2 = (List) filesByFilename$runIt$28;
                mutex2.unlock(null);
                return list2;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getFilesByFilename$runIt$28(GoogleDrive googleDrive, String str, Continuation<?> continuation) throws Throwable {
        return listAllFiles$default(googleDrive, "name='" + str + "'", null, false, continuation, 2, null);
    }

    public static /* synthetic */ Object uploadByteArrayToFilename$default(GoogleDrive googleDrive, String str, byte[] bArr, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 4) != 0) {
            z = true;
        }
        return googleDrive.uploadByteArrayToFilename(str, bArr, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object uploadByteArrayToFilename(String str, byte[] bArr, boolean z, Continuation<?> continuation) throws Throwable {
        C02451 c02451;
        Mutex mutex = null;
        GoogleDrive googleDrive;
        Mutex mutex2;
        if (continuation instanceof C02451) {
            c02451 = (C02451) continuation;
            if ((c02451.label & Integer.MIN_VALUE) != 0) {
                c02451.label -= Integer.MIN_VALUE;
            } else {
                c02451 = new C02451(continuation);
            }
        } else {
            c02451 = new C02451(continuation);
        }
        Object objUploadByteArrayToFilename$runIt$30 = c02451.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02451.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objUploadByteArrayToFilename$runIt$30);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c02451.L$0 = this;
                    c02451.L$1 = str;
                    c02451.L$2 = bArr;
                    c02451.L$3 = mutex;
                    c02451.label = 1;
                    if (mutex.lock(null, c02451) != coroutine_suspended) {
                        googleDrive = this;
                    }
                } else {
                    c02451.label = 3;
                    Object objUploadByteArrayToFilename$runIt$31 = uploadByteArrayToFilename$runIt$30(this, str, bArr, c02451);
                    if (objUploadByteArrayToFilename$runIt$31 != coroutine_suspended) {
                        return objUploadByteArrayToFilename$runIt$31;
                    }
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objUploadByteArrayToFilename$runIt$30);
                    return objUploadByteArrayToFilename$runIt$30;
                }
                mutex2 = (Mutex) c02451.L$0;
                try {
                    ResultKt.throwOnFailure(objUploadByteArrayToFilename$runIt$30);
                    File file = (File) objUploadByteArrayToFilename$runIt$30;
                    mutex2.unlock(null);
                    return file;
                } catch (Throwable th) {
                    th = th;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c02451.L$3;
            bArr = (byte[]) c02451.L$2;
            String str2 = (String) c02451.L$1;
            googleDrive = (GoogleDrive) c02451.L$0;
            ResultKt.throwOnFailure(objUploadByteArrayToFilename$runIt$30);
            mutex = mutex3;
            str = str2;
            c02451.L$0 = mutex;
            c02451.L$1 = null;
            c02451.L$2 = null;
            c02451.L$3 = null;
            c02451.label = 2;
            objUploadByteArrayToFilename$runIt$30 = uploadByteArrayToFilename$runIt$30(googleDrive, str, bArr, c02451);
            if (objUploadByteArrayToFilename$runIt$30 != coroutine_suspended) {
                mutex2 = mutex;
                File file2 = (File) objUploadByteArrayToFilename$runIt$30;
                mutex2.unlock(null);
                return file2;
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            Throwable th = null;
            th = th2;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object uploadByteArrayToFilename$runIt$30(GoogleDrive googleDrive, String str, byte[] bArr, Continuation<?> continuation) throws Throwable {
        return googleDrive.createOrUpdateFileByFilenameAndInputStream(str, new ByteArrayInputStream(bArr), false, continuation);
    }

    public static /* synthetic */ Object downloadByteArrayFromFilename$default(GoogleDrive googleDrive, String str, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 2) != 0) {
            z = true;
        }
        return googleDrive.downloadByteArrayFromFilename(str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object downloadByteArrayFromFilename(String str, boolean z, Continuation<? super byte[]> continuation) throws Throwable {
        C02341 c02341;
        Mutex mutex = null;
        GoogleDrive googleDrive;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof C02341) {
            c02341 = (C02341) continuation;
            if ((c02341.label & Integer.MIN_VALUE) != 0) {
                c02341.label -= Integer.MIN_VALUE;
            } else {
                c02341 = new C02341(continuation);
            }
        } else {
            c02341 = new C02341(continuation);
        }
        Object objDownloadByteArrayFromFilename$runIt$32 = c02341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02341.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objDownloadByteArrayFromFilename$runIt$32);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c02341.L$0 = this;
                    c02341.L$1 = str;
                    c02341.L$2 = mutex;
                    c02341.label = 1;
                    if (mutex.lock(null, c02341) != coroutine_suspended) {
                        googleDrive = this;
                    }
                } else {
                    c02341.label = 3;
                    Object objDownloadByteArrayFromFilename$runIt$33 = downloadByteArrayFromFilename$runIt$32(this, str, c02341);
                    if (objDownloadByteArrayFromFilename$runIt$33 != coroutine_suspended) {
                        return objDownloadByteArrayFromFilename$runIt$33;
                    }
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objDownloadByteArrayFromFilename$runIt$32);
                    return objDownloadByteArrayFromFilename$runIt$32;
                }
                mutex2 = (Mutex) c02341.L$0;
                try {
                    ResultKt.throwOnFailure(objDownloadByteArrayFromFilename$runIt$32);
                    byte[] bArr = (byte[]) objDownloadByteArrayFromFilename$runIt$32;
                    mutex2.unlock(null);
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c02341.L$2;
            String str2 = (String) c02341.L$1;
            googleDrive = (GoogleDrive) c02341.L$0;
            ResultKt.throwOnFailure(objDownloadByteArrayFromFilename$runIt$32);
            mutex = mutex3;
            str = str2;
            c02341.L$0 = mutex;
            c02341.L$1 = null;
            c02341.L$2 = null;
            c02341.label = 2;
            objDownloadByteArrayFromFilename$runIt$32 = downloadByteArrayFromFilename$runIt$32(googleDrive, str, c02341);
            if (objDownloadByteArrayFromFilename$runIt$32 != coroutine_suspended) {
                mutex2 = mutex;
                byte[] bArr2 = (byte[]) objDownloadByteArrayFromFilename$runIt$32;
                mutex2.unlock(null);
                return bArr2;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object downloadByteArrayFromFilename$runIt$32(GoogleDrive googleDrive, String str, Continuation<? super byte[]> continuation) throws Throwable {
        GoogleDrive$downloadByteArrayFromFilename$runIt$1 googleDrive$downloadByteArrayFromFilename$runIt$1;
        if (continuation instanceof GoogleDrive$downloadByteArrayFromFilename$runIt$1) {
            googleDrive$downloadByteArrayFromFilename$runIt$1 = (GoogleDrive$downloadByteArrayFromFilename$runIt$1) continuation;
            if ((googleDrive$downloadByteArrayFromFilename$runIt$1.label & Integer.MIN_VALUE) != 0) {
                googleDrive$downloadByteArrayFromFilename$runIt$1.label -= Integer.MIN_VALUE;
            } else {
                googleDrive$downloadByteArrayFromFilename$runIt$1 = new GoogleDrive$downloadByteArrayFromFilename$runIt$1(continuation);
            }
        } else {
            googleDrive$downloadByteArrayFromFilename$runIt$1 = new GoogleDrive$downloadByteArrayFromFilename$runIt$1(continuation);
        }
        Object fileOutputStreamByFilename = googleDrive$downloadByteArrayFromFilename$runIt$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = googleDrive$downloadByteArrayFromFilename$runIt$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(fileOutputStreamByFilename);
            googleDrive$downloadByteArrayFromFilename$runIt$1.label = 1;
            fileOutputStreamByFilename = googleDrive.getFileOutputStreamByFilename(str, false, googleDrive$downloadByteArrayFromFilename$runIt$1);
            if (fileOutputStreamByFilename == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(fileOutputStreamByFilename);
        }
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) fileOutputStreamByFilename;
        if (byteArrayOutputStream == null) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static /* synthetic */ Object downloadByteArrayFromFileId$default(GoogleDrive googleDrive, String str, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 2) != 0) {
            z = true;
        }
        return googleDrive.downloadByteArrayFromFileId(str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object downloadByteArrayFromFileId(String str, boolean z, Continuation<? super byte[]> continuation) throws Throwable {
        C02331 c02331;
        Mutex mutex = null;
        GoogleDrive googleDrive;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof C02331) {
            c02331 = (C02331) continuation;
            if ((c02331.label & Integer.MIN_VALUE) != 0) {
                c02331.label -= Integer.MIN_VALUE;
            } else {
                c02331 = new C02331(continuation);
            }
        } else {
            c02331 = new C02331(continuation);
        }
        Object objDownloadByteArrayFromFileId$runIt$34 = c02331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02331.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objDownloadByteArrayFromFileId$runIt$34);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c02331.L$0 = this;
                    c02331.L$1 = str;
                    c02331.L$2 = mutex;
                    c02331.label = 1;
                    if (mutex.lock(null, c02331) != coroutine_suspended) {
                        googleDrive = this;
                    }
                } else {
                    c02331.label = 3;
                    Object objDownloadByteArrayFromFileId$runIt$35 = downloadByteArrayFromFileId$runIt$34(this, str, c02331);
                    if (objDownloadByteArrayFromFileId$runIt$35 != coroutine_suspended) {
                        return objDownloadByteArrayFromFileId$runIt$35;
                    }
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objDownloadByteArrayFromFileId$runIt$34);
                    return objDownloadByteArrayFromFileId$runIt$34;
                }
                mutex2 = (Mutex) c02331.L$0;
                try {
                    ResultKt.throwOnFailure(objDownloadByteArrayFromFileId$runIt$34);
                    byte[] bArr = (byte[]) objDownloadByteArrayFromFileId$runIt$34;
                    mutex2.unlock(null);
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c02331.L$2;
            String str2 = (String) c02331.L$1;
            googleDrive = (GoogleDrive) c02331.L$0;
            ResultKt.throwOnFailure(objDownloadByteArrayFromFileId$runIt$34);
            mutex = mutex3;
            str = str2;
            c02331.L$0 = mutex;
            c02331.L$1 = null;
            c02331.L$2 = null;
            c02331.label = 2;
            objDownloadByteArrayFromFileId$runIt$34 = downloadByteArrayFromFileId$runIt$34(googleDrive, str, c02331);
            if (objDownloadByteArrayFromFileId$runIt$34 != coroutine_suspended) {
                mutex2 = mutex;
                byte[] bArr2 = (byte[]) objDownloadByteArrayFromFileId$runIt$34;
                mutex2.unlock(null);
                return bArr2;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object downloadByteArrayFromFileId$runIt$34(GoogleDrive googleDrive, String str, Continuation<? super byte[]> continuation) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Drive drive = googleDrive.googleDriveService;
        Intrinsics.checkNotNull(drive);
        drive.files().get(str).executeMediaAndDownloadTo(byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupGoogleSignInAccount(GoogleSignInAccount googleSignInAccount) {
        DaijishouApplication.WrappedLogger wrappedLogger = null;
        try {
            GoogleAccountCredential googleAccountCredentialUsingOAuth2 = GoogleAccountCredential.usingOAuth2(this.application, Collections.singleton("https://www.googleapis.com/auth/drive.file"));
            googleAccountCredentialUsingOAuth2.setSelectedAccount(googleSignInAccount.getAccount());
            BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new C02441(googleAccountCredentialUsingOAuth2, googleSignInAccount, null), 2, null);
        } catch (Exception e) {
            DaijishouApplication.WrappedLogger wrappedLogger2 = this.logger;
            if (wrappedLogger2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
                wrappedLogger2 = null;
            }
            wrappedLogger2.error(this, "Google Drive setupGoogleSignInAccount error.");
            DaijishouApplication.WrappedLogger wrappedLogger3 = this.logger;
            if (wrappedLogger3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
            } else {
                wrappedLogger = wrappedLogger3;
            }
            wrappedLogger.error(this, ExceptionsKt.stackTraceToString(e));
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$setupGoogleSignInAccount$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive$setupGoogleSignInAccount$1", f = "GoogleDrive.kt", i = {0, 1}, l = {464, 465, 489, 492}, m = "invokeSuspendImpl", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
    final class C02441 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ GoogleAccountCredential $googleAccountCredential;
        final /* synthetic */ GoogleSignInAccount $googleSignInAccount;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02441(GoogleAccountCredential googleAccountCredential, GoogleSignInAccount googleSignInAccount, Continuation<?> continuation) {
            super(2, continuation);
            this.$googleAccountCredential = googleAccountCredential;
            this.$googleSignInAccount = googleSignInAccount;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            C02441 c02441 = GoogleDrive.this.new C02441(this.$googleAccountCredential, this.$googleSignInAccount, continuation);
            c02441.L$0 = obj;
            return c02441;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    try {
                        return ((C02441) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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

        /* JADX WARN: Code duplicated, block: B:33:0x00be  */
        /* JADX WARN: Code duplicated, block: B:34:0x00bf A[Catch: Exception -> 0x0032, TryCatch #0 {Exception -> 0x0032, blocks: (B:8:0x0020, B:12:0x002d, B:41:0x00fb, B:17:0x003d, B:31:0x00ba, B:38:0x00e8, B:34:0x00bf, B:36:0x00c5, B:37:0x00c9, B:20:0x0048, B:26:0x00a7, B:28:0x00ab, B:23:0x0056), top: B:54:0x0016 }] */
        /* JADX WARN: Code duplicated, block: B:36:0x00c5 A[Catch: Exception -> 0x0032, TryCatch #0 {Exception -> 0x0032, blocks: (B:8:0x0020, B:12:0x002d, B:41:0x00fb, B:17:0x003d, B:31:0x00ba, B:38:0x00e8, B:34:0x00bf, B:36:0x00c5, B:37:0x00c9, B:20:0x0048, B:26:0x00a7, B:28:0x00ab, B:23:0x0056), top: B:54:0x0016 }] */
        /* JADX WARN: Code duplicated, block: B:40:0x00fa  */
        /* JADX WARN: Code duplicated, block: B:41:0x00fb A[Catch: Exception -> 0x0032, TRY_LEAVE, TryCatch #0 {Exception -> 0x0032, blocks: (B:8:0x0020, B:12:0x002d, B:41:0x00fb, B:17:0x003d, B:31:0x00ba, B:38:0x00e8, B:34:0x00bf, B:36:0x00c5, B:37:0x00c9, B:20:0x0048, B:26:0x00a7, B:28:0x00ab, B:23:0x0056), top: B:54:0x0016 }] */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0116, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.google_drive.GoogleDrive.C02441.AnonymousClass2(r17.this$0, r17.$googleSignInAccount, null), r17) == r3) goto L43;
         */

        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspendImpl(java.lang.Object r18) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 327
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.google_drive.GoogleDrive.C02441.invokeSuspendImpl(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$setupGoogleSignInAccount$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: GoogleDrive.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.google_drive.GoogleDrive$setupGoogleSignInAccount$1$2", f = "GoogleDrive.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
        final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            final /* synthetic */ GoogleSignInAccount $googleSignInAccount;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ GoogleDrive this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(GoogleDrive googleDrive, GoogleSignInAccount googleSignInAccount, Continuation<?> continuation) {
                super(2, continuation);
                this.this$0 = googleDrive;
                this.$googleSignInAccount = googleSignInAccount;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$googleSignInAccount, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
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
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                this.this$0.setHasSignedIn(true);
                this.this$0.googleSignInAccount = this.$googleSignInAccount;
                this.this$0._googleSignInAccountLiveData.setValue(this.$googleSignInAccount);
                DaijishouApplication.WrappedLogger wrappedLogger = this.this$0.logger;
                if (wrappedLogger == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    wrappedLogger = null;
                }
                wrappedLogger.debug(coroutineScope, "Google Drive getSignedInAccountFromIntent succeed.\nId: " + this.$googleSignInAccount.getId() + "\nIdToken: " + this.$googleSignInAccount.getIdToken() + "\nisExpired: " + this.$googleSignInAccount.isExpired() + "\nDisplayName: " + this.$googleSignInAccount.getDisplayName() + "\nEmail: " + this.$googleSignInAccount.getEmail() + "\nRequestedScopes: " + this.$googleSignInAccount.getRequestedScopes() + "\nGrantedScopes: " + this.$googleSignInAccount.getGrantedScopes() + "\nServerAuthCode: " + this.$googleSignInAccount.getServerAuthCode());
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.google_drive.GoogleDrive$handleSignInIntent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "googleSignInAccount", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class C02381 extends Lambda<Unit> implements Function1<GoogleSignInAccount, Unit> {
        C02381() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GoogleSignInAccount googleSignInAccount) {
            invoke2(googleSignInAccount);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GoogleSignInAccount googleSignInAccount) {
            Intrinsics.checkNotNullParameter(googleSignInAccount, "googleSignInAccount");
            try {
                GoogleDrive.this.setupGoogleSignInAccount(googleSignInAccount);
            } catch (Exception e) {
                DaijishouApplication.WrappedLogger wrappedLogger = GoogleDrive.this.logger;
                DaijishouApplication.WrappedLogger wrappedLogger2 = null;
                if (wrappedLogger == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    wrappedLogger = null;
                }
                wrappedLogger.error(GoogleDrive.this, "Google Drive addOnSuccessListener error.");
                DaijishouApplication.WrappedLogger wrappedLogger3 = GoogleDrive.this.logger;
                if (wrappedLogger3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                } else {
                    wrappedLogger2 = wrappedLogger3;
                }
                wrappedLogger2.error(GoogleDrive.this, ExceptionsKt.stackTraceToString(e));
            }
        }
    }

    private final void handleSignInIntent(Intent data) {
        GoogleSignIn.getSignedInAccountFromIntent(data).addOnSuccessListener(new GoogleDrive$$ExternalSyntheticLambda1(new C02381())).addOnFailureListener(new GoogleDrive$$ExternalSyntheticLambda2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSignInIntent$lambda$36(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSignInIntent$lambda$37(GoogleDrive this$0, Exception e) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(e, "e");
        DaijishouApplication.WrappedLogger wrappedLogger = this$0.logger;
        DaijishouApplication.WrappedLogger wrappedLogger2 = null;
        if (wrappedLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logger");
            wrappedLogger = null;
        }
        wrappedLogger.error(this$0, "Google Drive getSignedInAccountFromIntent error.");
        DaijishouApplication.WrappedLogger wrappedLogger3 = this$0.logger;
        if (wrappedLogger3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logger");
        } else {
            wrappedLogger2 = wrappedLogger3;
        }
        wrappedLogger2.error(this$0, ExceptionsKt.stackTraceToString(e));
    }
}
