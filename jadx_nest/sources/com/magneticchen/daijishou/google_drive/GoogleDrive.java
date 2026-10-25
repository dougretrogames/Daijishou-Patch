package com.magneticchen.daijishou.google_drive;

import android.content.Context;
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
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
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
import kotlin.text.StringsKt;
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
    public final Object requestSignIn(boolean z, Continuation<?> continuation) throws Throwable {
        C02421 c02421;
        if (continuation instanceof C02421) {
            c02421 = (C02421) continuation;
            if ((c02421.label & Integer.MIN_VALUE) != 0) {
                c02421.label -= Integer.MIN_VALUE;
            } else {
                c02421 = new C02421(continuation);
            }
        } else {
            c02421 = new C02421(continuation);
        }
        Object obj = c02421.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02421.label;
        Mutex mutex;
        GoogleDrive googleDrive;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.hasSignedIn) {
                DaijishouApplication.WrappedLogger wrappedLogger = this.logger;
                if (wrappedLogger == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    wrappedLogger = null;
                }
                wrappedLogger.debug(this, "Already signed in, ignored request.");
                return Unit.INSTANCE;
            }
            if (z) {
                mutex = this.driveOperationMutex;
                c02421.L$0 = this;
                c02421.L$1 = mutex;
                c02421.label = 1;
                if (mutex.lock(null, c02421) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                googleDrive = this;
            } else {
                c02421.label = 3;
                if (requestSignIn$runIt(this, c02421) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            mutex = (Mutex) c02421.L$1;
            googleDrive = (GoogleDrive) c02421.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            Mutex mutex2 = (Mutex) c02421.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                mutex2.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex2.unlock(null);
                throw th;
            }
        } else if (i == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c02421.L$0 = mutex;
        c02421.L$1 = null;
        c02421.label = 2;
        try {
            if (requestSignIn$runIt(googleDrive, c02421) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            mutex.unlock(null);
            throw th2;
        }
    }

    public static final Object requestSignIn$runIt(GoogleDrive googleDrive, Continuation<?> continuation) throws Throwable {
        GoogleDrive$requestSignIn$runIt$1 googleDrive$requestSignIn$runIt$1;
        if (continuation instanceof GoogleDrive$requestSignIn$runIt$1) {
            googleDrive$requestSignIn$runIt$1 = (GoogleDrive$requestSignIn$runIt$1) continuation;
            if ((googleDrive$requestSignIn$runIt$1.label & Integer.MIN_VALUE) != 0) {
                googleDrive$requestSignIn$runIt$1.label -= Integer.MIN_VALUE;
            } else {
                googleDrive$requestSignIn$runIt$1 = new GoogleDrive$requestSignIn$runIt$1(continuation);
            }
        } else {
            googleDrive$requestSignIn$runIt$1 = new GoogleDrive$requestSignIn$runIt$1(continuation);
        }
        Object obj = googleDrive$requestSignIn$runIt$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = googleDrive$requestSignIn$runIt$1.label;
        Mutex mutex;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!googleDrive.checkGooglePlayService()) {
                return Unit.INSTANCE;
            }
            if (googleDrive.requestSignInMutex.isLocked()) {
                googleDrive$requestSignIn$runIt$1.L$0 = googleDrive;
                googleDrive$requestSignIn$runIt$1.label = 1;
                if (Mutex.DefaultImpls.lock$default(googleDrive.requestSignInMutex, null, googleDrive$requestSignIn$runIt$1, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Mutex.DefaultImpls.unlock$default(googleDrive.requestSignInMutex, null, 1, null);
                return Unit.INSTANCE;
            }
            mutex = googleDrive.requestSignInMutex;
            googleDrive$requestSignIn$runIt$1.L$0 = googleDrive;
            googleDrive$requestSignIn$runIt$1.L$1 = mutex;
            googleDrive$requestSignIn$runIt$1.label = 2;
            if (mutex.lock(null, googleDrive$requestSignIn$runIt$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            googleDrive = (GoogleDrive) googleDrive$requestSignIn$runIt$1.L$0;
            ResultKt.throwOnFailure(obj);
            Mutex.DefaultImpls.unlock$default(googleDrive.requestSignInMutex, null, 1, null);
            return Unit.INSTANCE;
        } else if (i == 2) {
            mutex = (Mutex) googleDrive$requestSignIn$runIt$1.L$1;
            googleDrive = (GoogleDrive) googleDrive$requestSignIn$runIt$1.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            GoogleSignInClient client = GoogleSignIn.getClient((Context) googleDrive.application, signInOptions);
            Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
            try {
                GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount((Context) googleDrive.application);
                if (lastSignedInAccount != null && GoogleSignIn.hasPermissions(lastSignedInAccount, (Scope[]) Arrays.copyOf(scopes, scopes.length))) {
                    try {
                        googleDrive.setupGoogleSignInAccount(lastSignedInAccount);
                    } catch (Exception e) {
                        DaijishouApplication.WrappedLogger wrappedLogger = googleDrive.logger;
                        if (wrappedLogger == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("logger");
                            wrappedLogger = null;
                        }
                        wrappedLogger.warn(googleDrive, "Google Drive sign in via LastSignedInAccount error.");
                        DaijishouApplication.WrappedLogger wrappedLogger2 = googleDrive.logger;
                        if (wrappedLogger2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("logger");
                            wrappedLogger2 = null;
                        }
                        wrappedLogger2.error(googleDrive, ExceptionsKt.stackTraceToString(e));
                        requestSignIn$runIt$lambda$0$signInViaGooglePlay(googleDrive, client);
                    }
                } else {
                    requestSignIn$runIt$lambda$0$signInViaGooglePlay(googleDrive, client);
                }
            } catch (Exception e2) {
                DaijishouApplication.WrappedLogger wrappedLogger3 = googleDrive.logger;
                if (wrappedLogger3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    wrappedLogger3 = null;
                }
                wrappedLogger3.warn(googleDrive, "Google Drive sign in error.");
                DaijishouApplication.WrappedLogger wrappedLogger4 = googleDrive.logger;
                if (wrappedLogger4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    wrappedLogger4 = null;
                }
                wrappedLogger4.error(googleDrive, ExceptionsKt.stackTraceToString(e2));
            }
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
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
    public final Object requestSignOut(boolean z, Continuation<?> continuation) throws Throwable {
        C02431 c02431;
        if (continuation instanceof C02431) {
            c02431 = (C02431) continuation;
            if ((c02431.label & Integer.MIN_VALUE) != 0) {
                c02431.label -= Integer.MIN_VALUE;
            } else {
                c02431 = new C02431(continuation);
            }
        } else {
            c02431 = new C02431(continuation);
        }
        Object obj = c02431.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02431.label;
        Mutex mutex;
        GoogleDrive googleDrive;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.hasSignedIn) {
                DaijishouApplication.WrappedLogger wrappedLogger = this.logger;
                if (wrappedLogger == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    wrappedLogger = null;
                }
                wrappedLogger.warn(this, "Requested sign out but isSignedIn is false.");
                return Unit.INSTANCE;
            }
            if (z) {
                mutex = this.driveOperationMutex;
                c02431.L$0 = this;
                c02431.L$1 = mutex;
                c02431.label = 1;
                if (mutex.lock(null, c02431) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                googleDrive = this;
            } else {
                c02431.label = 3;
                if (requestSignOut$runIt$2(this, c02431) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            mutex = (Mutex) c02431.L$1;
            googleDrive = (GoogleDrive) c02431.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            Mutex mutex2 = (Mutex) c02431.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                mutex2.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex2.unlock(null);
                throw th;
            }
        } else if (i == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c02431.L$0 = mutex;
        c02431.L$1 = null;
        c02431.label = 2;
        try {
            if (requestSignOut$runIt$2(googleDrive, c02431) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            mutex.unlock(null);
            throw th2;
        }
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
    public final Object batchDeleteFiles(List<String> list, boolean z, Continuation<?> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
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
        Mutex mutex;
        BatchRequest batchRequest;
        GoogleDrive googleDrive;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (list.isEmpty()) {
                return Unit.INSTANCE;
            }
            Drive drive = this.googleDriveService;
            Intrinsics.checkNotNull(drive);
            batchRequest = drive.batch();
            if (z) {
                mutex = this.driveOperationMutex;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = list;
                anonymousClass1.L$2 = batchRequest;
                anonymousClass1.L$3 = mutex;
                anonymousClass1.label = 1;
                if (mutex.lock(null, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                googleDrive = this;
            } else {
                anonymousClass1.label = 3;
                if (batchDeleteFiles$runIt$5(list, this, batchRequest, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            mutex = (Mutex) anonymousClass1.L$3;
            batchRequest = (BatchRequest) anonymousClass1.L$2;
            list = (List) anonymousClass1.L$1;
            googleDrive = (GoogleDrive) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            Mutex mutex2 = (Mutex) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                mutex2.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex2.unlock(null);
                throw th;
            }
        } else if (i == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        anonymousClass1.L$0 = mutex;
        anonymousClass1.L$1 = null;
        anonymousClass1.L$2 = null;
        anonymousClass1.L$3 = null;
        anonymousClass1.label = 2;
        try {
            if (batchDeleteFiles$runIt$5(list, googleDrive, batchRequest, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            mutex.unlock(null);
            throw th2;
        }
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
    public final Object deleteAllFiles(boolean z, Continuation<?> continuation) throws Throwable {
        C02311 c02311;
        if (continuation instanceof C02311) {
            c02311 = (C02311) continuation;
            if ((c02311.label & Integer.MIN_VALUE) != 0) {
                c02311.label -= Integer.MIN_VALUE;
            } else {
                c02311 = new C02311(continuation);
            }
        } else {
            c02311 = new C02311(continuation);
        }
        Object obj = c02311.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02311.label;
        Mutex mutex;
        GoogleDrive googleDrive;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (z) {
                mutex = this.driveOperationMutex;
                c02311.L$0 = this;
                c02311.L$1 = mutex;
                c02311.label = 1;
                if (mutex.lock(null, c02311) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                googleDrive = this;
            } else {
                c02311.label = 3;
                if (deleteAllFiles$runIt$8(this, c02311) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            mutex = (Mutex) c02311.L$1;
            googleDrive = (GoogleDrive) c02311.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            Mutex mutex2 = (Mutex) c02311.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                mutex2.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex2.unlock(null);
                throw th;
            }
        } else if (i == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c02311.L$0 = mutex;
        c02311.L$1 = null;
        c02311.label = 2;
        try {
            if (deleteAllFiles$runIt$8(googleDrive, c02311) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            mutex.unlock(null);
            throw th2;
        }
    }

    public static final Object deleteAllFiles$runIt$8(GoogleDrive googleDrive, Continuation<?> continuation) throws Throwable {
        GoogleDrive$deleteAllFiles$runIt$1 googleDrive$deleteAllFiles$runIt$1;
        if (continuation instanceof GoogleDrive$deleteAllFiles$runIt$1) {
            googleDrive$deleteAllFiles$runIt$1 = (GoogleDrive$deleteAllFiles$runIt$1) continuation;
            if ((googleDrive$deleteAllFiles$runIt$1.label & Integer.MIN_VALUE) != 0) {
                googleDrive$deleteAllFiles$runIt$1.label -= Integer.MIN_VALUE;
            } else {
                googleDrive$deleteAllFiles$runIt$1 = new GoogleDrive$deleteAllFiles$runIt$1(continuation);
            }
        } else {
            googleDrive$deleteAllFiles$runIt$1 = new GoogleDrive$deleteAllFiles$runIt$1(continuation);
        }
        Object obj = googleDrive$deleteAllFiles$runIt$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = googleDrive$deleteAllFiles$runIt$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Drive drive = googleDrive.googleDriveService;
            if ((drive != null ? drive.files() : null) == null) {
                return Unit.INSTANCE;
            }
            googleDrive$deleteAllFiles$runIt$1.L$0 = googleDrive;
            googleDrive$deleteAllFiles$runIt$1.label = 1;
            obj = listAllFiles$default(googleDrive, null, null, false, googleDrive$deleteAllFiles$runIt$1, 3, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            googleDrive = (GoogleDrive) googleDrive$deleteAllFiles$runIt$1.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable<File> iterable = (Iterable) obj;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (File file : iterable) {
            arrayList.add(file.getId());
        }
        googleDrive$deleteAllFiles$runIt$1.L$0 = null;
        googleDrive$deleteAllFiles$runIt$1.label = 2;
        if (googleDrive.batchDeleteFiles(arrayList, false, googleDrive$deleteAllFiles$runIt$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
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
    public final Object deleteFileByFileId(String str, boolean z, Continuation<?> continuation) throws Throwable {
        C02321 c02321;
        if (continuation instanceof C02321) {
            c02321 = (C02321) continuation;
            if ((c02321.label & Integer.MIN_VALUE) != 0) {
                c02321.label -= Integer.MIN_VALUE;
            } else {
                c02321 = new C02321(continuation);
            }
        } else {
            c02321 = new C02321(continuation);
        }
        Object obj = c02321.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02321.label;
        Mutex mutex;
        GoogleDrive googleDrive;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (z) {
                mutex = this.driveOperationMutex;
                c02321.L$0 = this;
                c02321.L$1 = str;
                c02321.L$2 = mutex;
                c02321.label = 1;
                if (mutex.lock(null, c02321) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                googleDrive = this;
            } else {
                c02321.label = 3;
                if (deleteFileByFileId$runIt$10(this, str, c02321) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            mutex = (Mutex) c02321.L$2;
            str = (String) c02321.L$1;
            googleDrive = (GoogleDrive) c02321.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            Mutex mutex2 = (Mutex) c02321.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                mutex2.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex2.unlock(null);
                throw th;
            }
        } else if (i == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c02321.L$0 = mutex;
        c02321.L$1 = null;
        c02321.L$2 = null;
        c02321.label = 2;
        try {
            if (deleteFileByFileId$runIt$10(googleDrive, str, c02321) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            mutex.unlock(null);
            throw th2;
        }
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
    public final Object renameFileByFileId(String str, String str2, boolean z, Continuation<?> continuation) throws Throwable {
        C02411 c02411;
        if (continuation instanceof C02411) {
            c02411 = (C02411) continuation;
            if ((c02411.label & Integer.MIN_VALUE) != 0) {
                c02411.label -= Integer.MIN_VALUE;
            } else {
                c02411 = new C02411(continuation);
            }
        } else {
            c02411 = new C02411(continuation);
        }
        Object obj = c02411.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02411.label;
        Mutex mutex;
        GoogleDrive googleDrive;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (z) {
                mutex = this.driveOperationMutex;
                c02411.L$0 = this;
                c02411.L$1 = str;
                c02411.L$2 = str2;
                c02411.L$3 = mutex;
                c02411.label = 1;
                if (mutex.lock(null, c02411) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                googleDrive = this;
            } else {
                c02411.label = 3;
                if (renameFileByFileId$runIt$12(this, str, str2, c02411) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            mutex = (Mutex) c02411.L$3;
            str2 = (String) c02411.L$2;
            str = (String) c02411.L$1;
            googleDrive = (GoogleDrive) c02411.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            Mutex mutex2 = (Mutex) c02411.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                mutex2.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex2.unlock(null);
                throw th;
            }
        } else if (i == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c02411.L$0 = mutex;
        c02411.L$1 = null;
        c02411.L$2 = null;
        c02411.L$3 = null;
        c02411.label = 2;
        try {
            if (renameFileByFileId$runIt$12(googleDrive, str, str2, c02411) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            mutex.unlock(null);
            throw th2;
        }
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
    public final Object listAllFiles(String str, String str2, boolean z, Continuation<?> continuation) throws Throwable {
        C02391 c02391;
        if (continuation instanceof C02391) {
            c02391 = (C02391) continuation;
            if ((c02391.label & Integer.MIN_VALUE) != 0) {
                c02391.label -= Integer.MIN_VALUE;
            } else {
                c02391 = new C02391(continuation);
            }
        } else {
            c02391 = new C02391(continuation);
        }
        Object obj = c02391.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02391.label;
        Mutex mutex;
        GoogleDrive googleDrive;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (z) {
                mutex = this.driveOperationMutex;
                c02391.L$0 = this;
                c02391.L$1 = str;
                c02391.L$2 = str2;
                c02391.L$3 = mutex;
                c02391.label = 1;
                if (mutex.lock(null, c02391) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                googleDrive = this;
            } else {
                c02391.label = 3;
                Object objListAllFiles$runIt$15 = listAllFiles$runIt$15(this, str, str2, c02391);
                if (objListAllFiles$runIt$15 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (List) objListAllFiles$runIt$15;
            }
        } else if (i == 1) {
            mutex = (Mutex) c02391.L$3;
            str2 = (String) c02391.L$2;
            str = (String) c02391.L$1;
            googleDrive = (GoogleDrive) c02391.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            Mutex mutex2 = (Mutex) c02391.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                mutex2.unlock(null);
                return (List) obj;
            } catch (Throwable th) {
                mutex2.unlock(null);
                throw th;
            }
        } else if (i == 3) {
            ResultKt.throwOnFailure(obj);
            return (List) obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c02391.L$0 = mutex;
        c02391.L$1 = null;
        c02391.L$2 = null;
        c02391.L$3 = null;
        c02391.label = 2;
        try {
            Object objListAllFiles$runIt$15_2 = listAllFiles$runIt$15(googleDrive, str, str2, c02391);
            if (objListAllFiles$runIt$15_2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex.unlock(null);
            return (List) objListAllFiles$runIt$15_2;
        } catch (Throwable th2) {
            mutex.unlock(null);
            throw th2;
        }
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
    public final Object logAllFiles(boolean z, Continuation<?> continuation) throws Throwable {
        C02401 c02401;
        if (continuation instanceof C02401) {
            c02401 = (C02401) continuation;
            if ((c02401.label & Integer.MIN_VALUE) != 0) {
                c02401.label -= Integer.MIN_VALUE;
            } else {
                c02401 = new C02401(continuation);
            }
        } else {
            c02401 = new C02401(continuation);
        }
        Object obj = c02401.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02401.label;
        Mutex mutex;
        GoogleDrive googleDrive;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (z) {
                mutex = this.driveOperationMutex;
                c02401.L$0 = this;
                c02401.L$1 = mutex;
                c02401.label = 1;
                if (mutex.lock(null, c02401) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                googleDrive = this;
            } else {
                c02401.label = 3;
                if (logAllFiles$runIt$17(this, c02401) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            mutex = (Mutex) c02401.L$1;
            googleDrive = (GoogleDrive) c02401.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            Mutex mutex2 = (Mutex) c02401.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                mutex2.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex2.unlock(null);
                throw th;
            }
        } else if (i == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c02401.L$0 = mutex;
        c02401.L$1 = null;
        c02401.label = 2;
        try {
            if (logAllFiles$runIt$17(googleDrive, c02401) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            mutex.unlock(null);
            throw th2;
        }
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
        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = (CoroutineScope) this.L$0;
                    GoogleDrive.this.googleDriveService = new Drive.Builder(new NetHttpTransport(), GsonFactory.getDefaultInstance(), this.$googleAccountCredential).setApplicationName("Daijishou").build();
                    String str = "[upload_test]\ndaijishou_uuid: " + GoogleDrive.this.getApplication().getDaijishouUUID();
                    byte[] encodeToByteArray = StringsKt.encodeToByteArray(str);
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    obj = GoogleDrive.this.uploadByteArrayToFilename("upload_test.txt", encodeToByteArray, false, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    GoogleDrive googleDrive = (GoogleDrive) this.L$1;
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    byte[] bArr = (byte[]) obj;
                    if (bArr != null) {
                        DaijishouApplication.WrappedLogger wrappedLogger = GoogleDrive.this.logger;
                        if (wrappedLogger == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("logger");
                            wrappedLogger = null;
                        }
                        wrappedLogger.debug(coroutineScope, "upload_test.txt, size: " + bArr.length + ", content below: \n" + StringsKt.decodeToString(bArr));
                    }
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 3;
                    if (GoogleDrive.this.logAllFiles(false, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.label = 4;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(GoogleDrive.this, this.$googleSignInAccount, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                } else if (i == 3) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 4;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(GoogleDrive.this, this.$googleSignInAccount, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                } else if (i == 4) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (((File) obj) != null) {
                    this.L$0 = coroutineScope;
                    this.L$1 = GoogleDrive.this;
                    this.label = 2;
                    obj = GoogleDrive.this.downloadByteArrayFromFilename("upload_test.txt", false, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byte[] bArr2 = (byte[]) obj;
                    if (bArr2 != null) {
                        DaijishouApplication.WrappedLogger wrappedLogger2 = GoogleDrive.this.logger;
                        if (wrappedLogger2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("logger");
                            wrappedLogger2 = null;
                        }
                        wrappedLogger2.debug(coroutineScope, "upload_test.txt, size: " + bArr2.length + ", content below: \n" + StringsKt.decodeToString(bArr2));
                    }
                }
                this.L$0 = null;
                this.L$1 = null;
                this.label = 3;
                if (GoogleDrive.this.logAllFiles(false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 4;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(GoogleDrive.this, this.$googleSignInAccount, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            } catch (Exception e) {
                DaijishouApplication.WrappedLogger wrappedLogger3 = GoogleDrive.this.logger;
                if (wrappedLogger3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    wrappedLogger3 = null;
                }
                wrappedLogger3.error(GoogleDrive.this, "Google Drive setupGoogleSignInAccount error.");
                DaijishouApplication.WrappedLogger wrappedLogger4 = GoogleDrive.this.logger;
                if (wrappedLogger4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logger");
                    wrappedLogger4 = null;
                }
                wrappedLogger4.error(GoogleDrive.this, ExceptionsKt.stackTraceToString(e));
                return Unit.INSTANCE;
            }
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
