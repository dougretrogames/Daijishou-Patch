package com.magneticchen.daijishou.features;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.HttpHeaders;
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: GoogleDrive.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 T2\u00020\u0001:\u0002TUB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u0014J*\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00100J*\u00101\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020$2\u0006\u00102\u001a\u0002032\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00104J\u0018\u00105\u001a\u00020!2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00106J \u00107\u001a\u00020!2\u0006\u00108\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00109J \u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00109J\"\u0010=\u001a\u0004\u0018\u00010;2\u0006\u0010-\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00109J\"\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010-\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00109J&\u0010@\u001a\b\u0012\u0004\u0012\u00020,0#2\u0006\u0010-\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00109J&\u0010A\u001a\b\u0012\u0004\u0012\u00020,0#2\u0006\u0010B\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00109J\u0010\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020\u001fH\u0002J6\u0010E\u001a\b\u0012\u0004\u0012\u00020,0#2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010HJ\u0018\u0010I\u001a\u00020!2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00106J(\u0010J\u001a\u00020!2\u0006\u00108\u001a\u00020$2\u0006\u0010K\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010HJ\u0018\u0010L\u001a\u00020!2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00106J\b\u0010M\u001a\u00020!H\u0002J\u0018\u0010N\u001a\u00020!2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u00106J\u0010\u0010O\u001a\u00020!2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010P\u001a\u00020!J*\u0010Q\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020$2\u0006\u0010R\u001a\u00020;2\b\b\u0002\u0010%\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010SR\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0012\u0010\u001a\u001a\u00060\u001bR\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/magneticchen/daijishou/features/GoogleDrive;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "_googleSignInAccountLiveData", "Lcom/magneticchen/daijishou/features/GoogleDrive$GoogleSignInAccountLiveData;", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "driveOperationMutex", "Lkotlinx/coroutines/sync/Mutex;", "googleDriveService", "Lcom/google/api/services/drive/Drive;", "googleSignInAccount", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "googleSignInAccountLiveData", "Landroidx/lifecycle/LiveData;", "getGoogleSignInAccountLiveData", "()Landroidx/lifecycle/LiveData;", "hasSignedIn", "", "getHasSignedIn", "()Z", "setHasSignedIn", "(Z)V", "isLocked", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "requestSignInMutex", "signInIntentLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "batchDeleteFiles", "", "fileIds", "", "", "withLock", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindActivity", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "checkGooglePlayService", "createOrUpdateFileByFilenameAndInputStream", "Lcom/google/api/services/drive/model/File;", "filename", "inputStream", "Ljava/io/ByteArrayInputStream;", "(Ljava/lang/String;Ljava/io/ByteArrayInputStream;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createOrUpdateFileByInputStreamContent", "inputStreamContent", "Lcom/google/api/client/http/InputStreamContent;", "(Ljava/lang/String;Lcom/google/api/client/http/InputStreamContent;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllFiles", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFileByFileId", "fileId", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadByteArrayFromFileId", "", "id", "downloadByteArrayFromFilename", "getFileOutputStreamByFilename", "Ljava/io/ByteArrayOutputStream;", "getFilesByFilename", "getFilesByFilenameContainingSubstring", "substring", "handleSignInIntent", "data", "listAllFiles", "query", "customFields", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logAllFiles", "renameFileByFileId", "name", "requestSignIn", "requestSignInExisted", "requestSignOut", "setupGoogleSignInAccount", "unbindActivity", "uploadByteArrayToFilename", "byteArray", "(Ljava/lang/String;[BZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "GoogleSignInAccountLiveData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    public static final Companion Companion = new Companion(null);
    private static final Scope[] scopes = {new Scope("https://www.googleapis.com/auth/drive.file"), new Scope("https://www.googleapis.com/auth/drive.appdata")};

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$batchDeleteFiles$1, reason: invalid class name */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 0}, l = {470}, m = "batchDeleteFiles", n = {"this", "fileIds", "batchRequest", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.batchDeleteFiles(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$createOrUpdateFileByFilenameAndInputStream$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 0, 1}, l = {470, 342, 343}, m = "createOrUpdateFileByFilenameAndInputStream", n = {"this", "filename", "inputStream", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
    static final class C00421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00421(Continuation<? super C00421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.createOrUpdateFileByFilenameAndInputStream(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$createOrUpdateFileByInputStreamContent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 0, 1}, l = {470, 333, 334}, m = "createOrUpdateFileByInputStreamContent", n = {"this", "filename", "inputStreamContent", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
    static final class C00431 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00431(Continuation<? super C00431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.createOrUpdateFileByInputStreamContent(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$deleteAllFiles$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 1}, l = {470, 240, 241}, m = "deleteAllFiles", n = {"this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
    static final class C00441 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00441(Continuation<? super C00441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.deleteAllFiles(false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$deleteFileByFileId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0}, l = {470}, m = "deleteFileByFileId", n = {"this", "fileId", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class C00451 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00451(Continuation<? super C00451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.deleteFileByFileId(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$downloadByteArrayFromFileId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 1}, l = {470, 396, 397}, m = "downloadByteArrayFromFileId", n = {"this", "id", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
    static final class C00461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00461(Continuation<? super C00461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.downloadByteArrayFromFileId(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$downloadByteArrayFromFilename$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 1}, l = {470, 386, 387}, m = "downloadByteArrayFromFilename", n = {"this", "filename", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
    static final class C00471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00471(Continuation<? super C00471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.downloadByteArrayFromFilename(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$getFileOutputStreamByFilename$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 1}, l = {470, 353, 354}, m = "getFileOutputStreamByFilename", n = {"this", "filename", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
    static final class C00481 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00481(Continuation<? super C00481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.getFileOutputStreamByFilename(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$getFilesByFilename$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 1}, l = {470, 369, 370}, m = "getFilesByFilename", n = {"this", "filename", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
    static final class C00491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00491(Continuation<? super C00491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.getFilesByFilename(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$getFilesByFilenameContainingSubstring$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 1}, l = {470, 361, 362}, m = "getFilesByFilenameContainingSubstring", n = {"this", "substring", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
    static final class C00501 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00501(Continuation<? super C00501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.getFilesByFilenameContainingSubstring(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$listAllFiles$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 0}, l = {470}, m = "listAllFiles", n = {"this", "query", "customFields", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C00521 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00521(Continuation<? super C00521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.listAllFiles(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$logAllFiles$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 1}, l = {470, 309, 310}, m = "logAllFiles", n = {"this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
    static final class C00531 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00531(Continuation<? super C00531> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.logAllFiles(false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$renameFileByFileId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 0, 1}, l = {470, 261, 262}, m = "renameFileByFileId", n = {"this", "fileId", "name", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
    static final class C00541 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00541(Continuation<? super C00541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.renameFileByFileId(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$requestSignIn$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 1}, l = {470, 161, 162}, m = "requestSignIn", n = {"this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
    static final class C00551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00551(Continuation<? super C00551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.requestSignIn(false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$requestSignOut$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0}, l = {470}, m = "requestSignOut", n = {"this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
    static final class C00561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00561(Continuation<? super C00561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.requestSignOut(false, this);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$uploadByteArrayToFilename$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive", f = "GoogleDrive.kt", i = {0, 0, 0, 0, 1}, l = {470, 377, 378}, m = "uploadByteArrayToFilename", n = {"this", "filename", "byteArray", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
    static final class C00581 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00581(Continuation<? super C00581> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleDrive.this.uploadByteArrayToFilename(null, null, false, this);
        }
    }

    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/features/GoogleDrive$Companion;", "", "()V", "DEFAULT_PAGE_SIZE", "", "DEFAULT_SPACE", "", "scopes", "", "Lcom/google/android/gms/common/api/Scope;", "getScopes", "()[Lcom/google/android/gms/common/api/Scope;", "[Lcom/google/android/gms/common/api/Scope;", "signInOptions", "Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "getSignInOptions", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public GoogleDrive(DaijishouApplication application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        this._googleSignInAccountLiveData = new GoogleSignInAccountLiveData();
        this.requestSignInMutex = MutexKt.Mutex$default(false, 1, (Object) null);
        this.driveOperationMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    static {
        GoogleSignInOptions.Builder builderRequestEmail = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail();
        Intrinsics.checkNotNullExpressionValue(builderRequestEmail, "requestEmail(...)");
        builderRequestEmail.requestScopes(new Scope("https://www.googleapis.com/auth/drive.file"), new Scope[]{new Scope("https://www.googleapis.com/auth/drive.appdata")});
        GoogleSignInOptions googleSignInOptionsBuild = builderRequestEmail.build();
        Intrinsics.checkNotNullExpressionValue(googleSignInOptionsBuild, "build(...)");
        signInOptions = googleSignInOptionsBuild;
    }

    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/features/GoogleDrive$GoogleSignInAccountLiveData;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "(Lcom/magneticchen/daijishou/features/GoogleDrive;)V", "onActive", "", "onInactive", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class GoogleSignInAccountLiveData extends MutableLiveData<GoogleSignInAccount> {
        public GoogleSignInAccountLiveData() {
        }

        protected void onActive() {
            setValue(GoogleDrive.this.googleSignInAccount);
        }

        protected void onInactive() {
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

    public static /* synthetic */ Object requestSignIn$default(GoogleDrive googleDrive, boolean z, Continuation continuation, int i, Object obj) {
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
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v9, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object requestSignIn(boolean r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.magneticchen.daijishou.features.GoogleDrive.C00551
            if (r0 == 0) goto L14
            r0 = r9
            com.magneticchen.daijishou.features.GoogleDrive$requestSignIn$1 r0 = (com.magneticchen.daijishou.features.GoogleDrive.C00551) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.magneticchen.daijishou.features.GoogleDrive$requestSignIn$1 r0 = new com.magneticchen.daijishou.features.GoogleDrive$requestSignIn$1
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
            com.magneticchen.daijishou.features.GoogleDrive r2 = (com.magneticchen.daijishou.features.GoogleDrive) r2
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
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.GoogleDrive.requestSignIn(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:45:0x00d1 A[Catch: Exception -> 0x00d5, all -> 0x00fc, TRY_LEAVE, TryCatch #1 {Exception -> 0x00d5, blocks: (B:31:0x0091, B:33:0x009b, B:38:0x00af, B:40:0x00b3, B:41:0x00b7, B:43:0x00c0, B:44:0x00c4, B:45:0x00d1), top: B:63:0x0091, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
    
        if (kotlinx.coroutines.sync.Mutex.DefaultImpls.lock$default(r8, (java.lang.Object) null, r1, 1, (java.lang.Object) null) == r2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007f, code lost:
    
        if (r8.lock((java.lang.Object) null, r1) == r2) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object requestSignIn$runIt(com.magneticchen.daijishou.features.GoogleDrive r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.GoogleDrive.requestSignIn$runIt(com.magneticchen.daijishou.features.GoogleDrive, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final void requestSignIn$runIt$lambda$0$signInViaGooglePlay(GoogleDrive googleDrive, GoogleSignInClient googleSignInClient) {
        ActivityResultLauncher<Intent> activityResultLauncher = googleDrive.signInIntentLauncher;
        Intrinsics.checkNotNull(activityResultLauncher);
        activityResultLauncher.launch(googleSignInClient.getSignInIntent());
    }

    public static /* synthetic */ Object requestSignOut$default(GoogleDrive googleDrive, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return googleDrive.requestSignOut(z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object requestSignOut(boolean z, Continuation<? super Unit> continuation) {
        C00561 c00561;
        Mutex mutex;
        GoogleDrive googleDrive;
        if (continuation instanceof C00561) {
            c00561 = (C00561) continuation;
            if ((c00561.label & Integer.MIN_VALUE) != 0) {
                c00561.label -= Integer.MIN_VALUE;
            } else {
                c00561 = new C00561(continuation);
            }
        } else {
            c00561 = new C00561(continuation);
        }
        Object obj = c00561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00561.label;
        DaijishouApplication.WrappedLogger wrappedLogger = null;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!this.hasSignedIn) {
                    DaijishouApplication.WrappedLogger wrappedLogger2 = this.logger;
                    if (wrappedLogger2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("logger");
                    } else {
                        wrappedLogger = wrappedLogger2;
                    }
                    wrappedLogger.warn(this, "Requested sign out but isSignedIn is false.");
                    return Unit.INSTANCE;
                }
                if (z) {
                    mutex = this.driveOperationMutex;
                    c00561.L$0 = this;
                    c00561.L$1 = mutex;
                    c00561.label = 1;
                    if (mutex.lock((Object) null, c00561) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    googleDrive = this;
                } else {
                    requestSignOut$runIt$2(this);
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = (Mutex) c00561.L$1;
            googleDrive = (GoogleDrive) c00561.L$0;
            ResultKt.throwOnFailure(obj);
            requestSignOut$runIt$2(googleDrive);
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock((Object) null);
        }
    }

    private static final void requestSignOut$runIt$2(GoogleDrive googleDrive) {
        googleDrive.hasSignedIn = false;
        GoogleSignInClient client = GoogleSignIn.getClient(googleDrive.application, signInOptions);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        client.signOut();
        client.revokeAccess();
        googleDrive.googleSignInAccount = null;
        googleDrive._googleSignInAccountLiveData.setValue(null);
        googleDrive.googleDriveService = null;
    }

    public final void bindActivity(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.logger = this.application.getLogger();
        this.signInIntentLauncher = activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.features.GoogleDrive$$ExternalSyntheticLambda2
            public final void onActivityResult(Object obj) {
                GoogleDrive.bindActivity$lambda$4(this.f$0, (ActivityResult) obj);
            }
        });
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
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object batchDeleteFiles(List<String> list, boolean z, Continuation<? super Unit> continuation) throws IOException {
        AnonymousClass1 anonymousClass1;
        BatchRequest batchRequestBatch;
        Mutex mutex;
        GoogleDrive googleDrive;
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
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (list.isEmpty()) {
                    return Unit.INSTANCE;
                }
                Drive drive = this.googleDriveService;
                Intrinsics.checkNotNull(drive);
                batchRequestBatch = drive.batch();
                if (z) {
                    mutex = this.driveOperationMutex;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = list;
                    anonymousClass1.L$2 = batchRequestBatch;
                    anonymousClass1.L$3 = mutex;
                    anonymousClass1.label = 1;
                    if (mutex.lock((Object) null, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    googleDrive = this;
                } else {
                    batchDeleteFiles$runIt$5(list, this, batchRequestBatch);
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = (Mutex) anonymousClass1.L$3;
            BatchRequest batchRequest = (BatchRequest) anonymousClass1.L$2;
            List<String> list2 = (List) anonymousClass1.L$1;
            googleDrive = (GoogleDrive) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            batchRequestBatch = batchRequest;
            mutex = mutex2;
            list = list2;
            batchDeleteFiles$runIt$5(list, googleDrive, batchRequestBatch);
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock((Object) null);
        }
    }

    static /* synthetic */ Object batchDeleteFiles$default(GoogleDrive googleDrive, List list, boolean z, Continuation continuation, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            z = true;
        }
        return googleDrive.batchDeleteFiles(list, z, continuation);
    }

    private static final void batchDeleteFiles$runIt$5(List<String> list, GoogleDrive googleDrive, BatchRequest batchRequest) {
        for (final String str : list) {
            Drive drive = googleDrive.googleDriveService;
            Intrinsics.checkNotNull(drive);
            drive.files().delete(str).queue(batchRequest, new JsonBatchCallback<Void>() { // from class: com.magneticchen.daijishou.features.GoogleDrive$batchDeleteFiles$runIt$1
                public void onSuccess(Void r2, HttpHeaders httpHeaders) {
                    System.out.println((Object) ("Successfully deleted file with ID: " + str));
                }

                public void onFailure(GoogleJsonError googleJsonError, HttpHeaders httpHeaders) {
                    System.err.println("Failed to delete file with ID: " + str);
                }
            });
        }
        batchRequest.execute();
    }

    public static /* synthetic */ Object deleteAllFiles$default(GoogleDrive googleDrive, boolean z, Continuation continuation, int i, Object obj) {
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
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v5, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object deleteAllFiles(boolean r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.magneticchen.daijishou.features.GoogleDrive.C00441
            if (r0 == 0) goto L14
            r0 = r9
            com.magneticchen.daijishou.features.GoogleDrive$deleteAllFiles$1 r0 = (com.magneticchen.daijishou.features.GoogleDrive.C00441) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.magneticchen.daijishou.features.GoogleDrive$deleteAllFiles$1 r0 = new com.magneticchen.daijishou.features.GoogleDrive$deleteAllFiles$1
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
            com.magneticchen.daijishou.features.GoogleDrive r2 = (com.magneticchen.daijishou.features.GoogleDrive) r2
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
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.GoogleDrive.deleteAllFiles(boolean, kotlin.coroutines.Continuation):java.lang.Object");
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
    public static final java.lang.Object deleteAllFiles$runIt$8(com.magneticchen.daijishou.features.GoogleDrive r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof com.magneticchen.daijishou.features.GoogleDrive$deleteAllFiles$runIt$1
            if (r0 == 0) goto L14
            r0 = r11
            com.magneticchen.daijishou.features.GoogleDrive$deleteAllFiles$runIt$1 r0 = (com.magneticchen.daijishou.features.GoogleDrive$deleteAllFiles$runIt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.magneticchen.daijishou.features.GoogleDrive$deleteAllFiles$runIt$1 r0 = new com.magneticchen.daijishou.features.GoogleDrive$deleteAllFiles$runIt$1
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
            com.magneticchen.daijishou.features.GoogleDrive r10 = (com.magneticchen.daijishou.features.GoogleDrive) r10
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
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.GoogleDrive.deleteAllFiles$runIt$8(com.magneticchen.daijishou.features.GoogleDrive, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object deleteFileByFileId$default(GoogleDrive googleDrive, String str, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return googleDrive.deleteFileByFileId(str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteFileByFileId(String str, boolean z, Continuation<? super Unit> continuation) {
        C00451 c00451;
        Mutex mutex;
        GoogleDrive googleDrive;
        if (continuation instanceof C00451) {
            c00451 = (C00451) continuation;
            if ((c00451.label & Integer.MIN_VALUE) != 0) {
                c00451.label -= Integer.MIN_VALUE;
            } else {
                c00451 = new C00451(continuation);
            }
        } else {
            c00451 = new C00451(continuation);
        }
        Object obj = c00451.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00451.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c00451.L$0 = this;
                    c00451.L$1 = str;
                    c00451.L$2 = mutex;
                    c00451.label = 1;
                    if (mutex.lock((Object) null, c00451) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    googleDrive = this;
                } else {
                    deleteFileByFileId$runIt$10(this, str);
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = (Mutex) c00451.L$2;
            String str2 = (String) c00451.L$1;
            googleDrive = (GoogleDrive) c00451.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            str = str2;
            deleteFileByFileId$runIt$10(googleDrive, str);
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock((Object) null);
        }
    }

    private static final void deleteFileByFileId$runIt$10(GoogleDrive googleDrive, String str) {
        Drive drive = googleDrive.googleDriveService;
        Drive.Files files = drive != null ? drive.files() : null;
        if (files == null) {
            return;
        }
        files.delete(str).execute();
    }

    public static /* synthetic */ Object renameFileByFileId$default(GoogleDrive googleDrive, String str, String str2, boolean z, Continuation continuation, int i, Object obj) {
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
    public final java.lang.Object renameFileByFileId(java.lang.String r9, java.lang.String r10, boolean r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.magneticchen.daijishou.features.GoogleDrive.C00541
            if (r0 == 0) goto L14
            r0 = r12
            com.magneticchen.daijishou.features.GoogleDrive$renameFileByFileId$1 r0 = (com.magneticchen.daijishou.features.GoogleDrive.C00541) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.magneticchen.daijishou.features.GoogleDrive$renameFileByFileId$1 r0 = new com.magneticchen.daijishou.features.GoogleDrive$renameFileByFileId$1
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
            com.magneticchen.daijishou.features.GoogleDrive r2 = (com.magneticchen.daijishou.features.GoogleDrive) r2
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
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.GoogleDrive.renameFileByFileId(java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object renameFileByFileId$runIt$12(GoogleDrive googleDrive, String str, String str2, Continuation<? super Unit> continuation) {
        Drive drive = googleDrive.googleDriveService;
        Drive.Files files = drive != null ? drive.files() : null;
        if (files == null) {
            return Unit.INSTANCE;
        }
        File file = (File) files.get(str).execute();
        file.setName(str2);
        file.setId((String) null);
        files.update(str, file).execute();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object listAllFiles$default(GoogleDrive googleDrive, String str, String str2, boolean z, Continuation continuation, int i, Object obj) {
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

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object listAllFiles(String str, String str2, boolean z, Continuation<? super List<File>> continuation) {
        C00521 c00521;
        Mutex mutex;
        GoogleDrive googleDrive;
        if (continuation instanceof C00521) {
            c00521 = (C00521) continuation;
            if ((c00521.label & Integer.MIN_VALUE) != 0) {
                c00521.label -= Integer.MIN_VALUE;
            } else {
                c00521 = new C00521(continuation);
            }
        } else {
            c00521 = new C00521(continuation);
        }
        Object obj = c00521.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00521.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (z) {
                mutex = this.driveOperationMutex;
                c00521.L$0 = this;
                c00521.L$1 = str;
                c00521.L$2 = str2;
                c00521.L$3 = mutex;
                c00521.label = 1;
                if (mutex.lock((Object) null, c00521) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                googleDrive = this;
            } else {
                return listAllFiles$runIt$15(this, str, str2);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = (Mutex) c00521.L$3;
            str2 = (String) c00521.L$2;
            String str3 = (String) c00521.L$1;
            googleDrive = (GoogleDrive) c00521.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            str = str3;
        }
        try {
            return listAllFiles$runIt$15(googleDrive, str, str2);
        } finally {
            mutex.unlock((Object) null);
        }
    }

    private static final List<File> listAllFiles$runIt$15(GoogleDrive googleDrive, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Drive drive = googleDrive.googleDriveService;
        Intrinsics.checkNotNull(drive);
        Drive.Files files = drive.files();
        Intrinsics.checkNotNull(files);
        Drive.Files.List q = files.list().setSpaces(DEFAULT_SPACE).setQ(str);
        if (str2 == null) {
            str2 = "id, name, createdTime, modifiedTime, size, md5Checksum";
        }
        FileList fileList = (FileList) q.setFields("nextPageToken, files(" + str2 + ")").setPageSize(128).execute();
        List files2 = fileList.getFiles();
        Intrinsics.checkNotNullExpressionValue(files2, "getFiles(...)");
        arrayList.addAll(files2);
        String nextPageToken = fileList.getNextPageToken();
        while (nextPageToken != null) {
            Object objExecute = files.list().setSpaces(DEFAULT_SPACE).setQ(str).setFields("nextPageToken, files(id, name, createdTime, modifiedTime, size, md5Checksum)").setPageSize(128).setPageToken(nextPageToken).execute();
            Intrinsics.checkNotNullExpressionValue(objExecute, "execute(...)");
            FileList fileList2 = (FileList) objExecute;
            List files3 = fileList2.getFiles();
            Intrinsics.checkNotNullExpressionValue(files3, "getFiles(...)");
            arrayList.addAll(files3);
            nextPageToken = fileList2.getNextPageToken();
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

    public static /* synthetic */ Object logAllFiles$default(GoogleDrive googleDrive, boolean z, Continuation continuation, int i, Object obj) {
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
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v5, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object logAllFiles(boolean r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.magneticchen.daijishou.features.GoogleDrive.C00531
            if (r0 == 0) goto L14
            r0 = r9
            com.magneticchen.daijishou.features.GoogleDrive$logAllFiles$1 r0 = (com.magneticchen.daijishou.features.GoogleDrive.C00531) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.magneticchen.daijishou.features.GoogleDrive$logAllFiles$1 r0 = new com.magneticchen.daijishou.features.GoogleDrive$logAllFiles$1
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
            com.magneticchen.daijishou.features.GoogleDrive r2 = (com.magneticchen.daijishou.features.GoogleDrive) r2
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
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.GoogleDrive.logAllFiles(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object logAllFiles$runIt$17(GoogleDrive googleDrive, Continuation<? super Unit> continuation) {
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
        for (File file : (List) objListAllFiles$default) {
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

    public static /* synthetic */ Object createOrUpdateFileByInputStreamContent$default(GoogleDrive googleDrive, String str, InputStreamContent inputStreamContent, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return googleDrive.createOrUpdateFileByInputStreamContent(str, inputStreamContent, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createOrUpdateFileByInputStreamContent(String str, InputStreamContent inputStreamContent, boolean z, Continuation<? super File> continuation) throws Throwable {
        C00431 c00431;
        Mutex mutex;
        GoogleDrive googleDrive;
        Mutex mutex2;
        if (continuation instanceof C00431) {
            c00431 = (C00431) continuation;
            if ((c00431.label & Integer.MIN_VALUE) != 0) {
                c00431.label -= Integer.MIN_VALUE;
            } else {
                c00431 = new C00431(continuation);
            }
        } else {
            c00431 = new C00431(continuation);
        }
        Object objCreateOrUpdateFileByInputStreamContent$runIt$20 = c00431.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00431.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCreateOrUpdateFileByInputStreamContent$runIt$20);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c00431.L$0 = this;
                    c00431.L$1 = str;
                    c00431.L$2 = inputStreamContent;
                    c00431.L$3 = mutex;
                    c00431.label = 1;
                    if (mutex.lock((Object) null, c00431) != coroutine_suspended) {
                        googleDrive = this;
                    }
                } else {
                    c00431.label = 3;
                    Object objCreateOrUpdateFileByInputStreamContent$runIt$21 = createOrUpdateFileByInputStreamContent$runIt$20(this, str, inputStreamContent, c00431);
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
                mutex2 = (Mutex) c00431.L$0;
                try {
                    ResultKt.throwOnFailure(objCreateOrUpdateFileByInputStreamContent$runIt$20);
                    File file = (File) objCreateOrUpdateFileByInputStreamContent$runIt$20;
                    mutex2.unlock((Object) null);
                    return file;
                } catch (Throwable th) {
                    th = th;
                    mutex2.unlock((Object) null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c00431.L$3;
            inputStreamContent = (InputStreamContent) c00431.L$2;
            String str2 = (String) c00431.L$1;
            googleDrive = (GoogleDrive) c00431.L$0;
            ResultKt.throwOnFailure(objCreateOrUpdateFileByInputStreamContent$runIt$20);
            mutex = mutex3;
            str = str2;
            c00431.L$0 = mutex;
            c00431.L$1 = null;
            c00431.L$2 = null;
            c00431.L$3 = null;
            c00431.label = 2;
            objCreateOrUpdateFileByInputStreamContent$runIt$20 = createOrUpdateFileByInputStreamContent$runIt$20(googleDrive, str, inputStreamContent, c00431);
            if (objCreateOrUpdateFileByInputStreamContent$runIt$20 != coroutine_suspended) {
                mutex2 = mutex;
                File file2 = (File) objCreateOrUpdateFileByInputStreamContent$runIt$20;
                mutex2.unlock((Object) null);
                return file2;
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock((Object) null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object createOrUpdateFileByInputStreamContent$runIt$20(GoogleDrive googleDrive, String str, InputStreamContent inputStreamContent, Continuation<? super File> continuation) {
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
        for (File file3 : (Iterable) obj) {
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
                file.setParents((List) null);
                return files.update(file3.getId(), file, (AbstractInputStreamContent) inputStreamContent).execute();
            }
        }
        return files.create(file, (AbstractInputStreamContent) inputStreamContent).setFields("id").execute();
    }

    public static /* synthetic */ Object createOrUpdateFileByFilenameAndInputStream$default(GoogleDrive googleDrive, String str, ByteArrayInputStream byteArrayInputStream, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return googleDrive.createOrUpdateFileByFilenameAndInputStream(str, byteArrayInputStream, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createOrUpdateFileByFilenameAndInputStream(String str, ByteArrayInputStream byteArrayInputStream, boolean z, Continuation<? super File> continuation) throws Throwable {
        C00421 c00421;
        Mutex mutex;
        GoogleDrive googleDrive;
        Mutex mutex2;
        if (continuation instanceof C00421) {
            c00421 = (C00421) continuation;
            if ((c00421.label & Integer.MIN_VALUE) != 0) {
                c00421.label -= Integer.MIN_VALUE;
            } else {
                c00421 = new C00421(continuation);
            }
        } else {
            c00421 = new C00421(continuation);
        }
        Object objCreateOrUpdateFileByFilenameAndInputStream$runIt$22 = c00421.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00421.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCreateOrUpdateFileByFilenameAndInputStream$runIt$22);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c00421.L$0 = this;
                    c00421.L$1 = str;
                    c00421.L$2 = byteArrayInputStream;
                    c00421.L$3 = mutex;
                    c00421.label = 1;
                    if (mutex.lock((Object) null, c00421) != coroutine_suspended) {
                        googleDrive = this;
                    }
                } else {
                    c00421.label = 3;
                    Object objCreateOrUpdateFileByFilenameAndInputStream$runIt$23 = createOrUpdateFileByFilenameAndInputStream$runIt$22(byteArrayInputStream, this, str, c00421);
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
                mutex2 = (Mutex) c00421.L$0;
                try {
                    ResultKt.throwOnFailure(objCreateOrUpdateFileByFilenameAndInputStream$runIt$22);
                    File file = (File) objCreateOrUpdateFileByFilenameAndInputStream$runIt$22;
                    mutex2.unlock((Object) null);
                    return file;
                } catch (Throwable th) {
                    th = th;
                    mutex2.unlock((Object) null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c00421.L$3;
            byteArrayInputStream = (ByteArrayInputStream) c00421.L$2;
            String str2 = (String) c00421.L$1;
            googleDrive = (GoogleDrive) c00421.L$0;
            ResultKt.throwOnFailure(objCreateOrUpdateFileByFilenameAndInputStream$runIt$22);
            mutex = mutex3;
            str = str2;
            c00421.L$0 = mutex;
            c00421.L$1 = null;
            c00421.L$2 = null;
            c00421.L$3 = null;
            c00421.label = 2;
            objCreateOrUpdateFileByFilenameAndInputStream$runIt$22 = createOrUpdateFileByFilenameAndInputStream$runIt$22(byteArrayInputStream, googleDrive, str, c00421);
            if (objCreateOrUpdateFileByFilenameAndInputStream$runIt$22 != coroutine_suspended) {
                mutex2 = mutex;
                File file2 = (File) objCreateOrUpdateFileByFilenameAndInputStream$runIt$22;
                mutex2.unlock((Object) null);
                return file2;
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock((Object) null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object createOrUpdateFileByFilenameAndInputStream$runIt$22(ByteArrayInputStream byteArrayInputStream, GoogleDrive googleDrive, String str, Continuation<? super File> continuation) {
        return googleDrive.createOrUpdateFileByInputStreamContent(str, new InputStreamContent("application/octet-stream", byteArrayInputStream), false, continuation);
    }

    public static /* synthetic */ Object getFileOutputStreamByFilename$default(GoogleDrive googleDrive, String str, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return googleDrive.getFileOutputStreamByFilename(str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFileOutputStreamByFilename(String str, boolean z, Continuation<? super ByteArrayOutputStream> continuation) throws Throwable {
        C00481 c00481;
        Mutex mutex;
        GoogleDrive googleDrive;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof C00481) {
            c00481 = (C00481) continuation;
            if ((c00481.label & Integer.MIN_VALUE) != 0) {
                c00481.label -= Integer.MIN_VALUE;
            } else {
                c00481 = new C00481(continuation);
            }
        } else {
            c00481 = new C00481(continuation);
        }
        Object fileOutputStreamByFilename$runIt$24 = c00481.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00481.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(fileOutputStreamByFilename$runIt$24);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c00481.L$0 = this;
                    c00481.L$1 = str;
                    c00481.L$2 = mutex;
                    c00481.label = 1;
                    if (mutex.lock((Object) null, c00481) != coroutine_suspended) {
                        googleDrive = this;
                    }
                } else {
                    c00481.label = 3;
                    Object fileOutputStreamByFilename$runIt$25 = getFileOutputStreamByFilename$runIt$24(this, str, c00481);
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
                mutex2 = (Mutex) c00481.L$0;
                try {
                    ResultKt.throwOnFailure(fileOutputStreamByFilename$runIt$24);
                    ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) fileOutputStreamByFilename$runIt$24;
                    mutex2.unlock((Object) null);
                    return byteArrayOutputStream;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock((Object) null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c00481.L$2;
            String str2 = (String) c00481.L$1;
            googleDrive = (GoogleDrive) c00481.L$0;
            ResultKt.throwOnFailure(fileOutputStreamByFilename$runIt$24);
            mutex = mutex3;
            str = str2;
            c00481.L$0 = mutex;
            c00481.L$1 = null;
            c00481.L$2 = null;
            c00481.label = 2;
            fileOutputStreamByFilename$runIt$24 = getFileOutputStreamByFilename$runIt$24(googleDrive, str, c00481);
            if (fileOutputStreamByFilename$runIt$24 != coroutine_suspended) {
                mutex2 = mutex;
                ByteArrayOutputStream byteArrayOutputStream2 = (ByteArrayOutputStream) fileOutputStreamByFilename$runIt$24;
                mutex2.unlock((Object) null);
                return byteArrayOutputStream2;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock((Object) null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object getFileOutputStreamByFilename$runIt$24(GoogleDrive googleDrive, String str, Continuation<? super ByteArrayOutputStream> continuation) {
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

    public static /* synthetic */ Object getFilesByFilenameContainingSubstring$default(GoogleDrive googleDrive, String str, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return googleDrive.getFilesByFilenameContainingSubstring(str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFilesByFilenameContainingSubstring(String str, boolean z, Continuation<? super List<File>> continuation) throws Throwable {
        C00501 c00501;
        Mutex mutex;
        GoogleDrive googleDrive;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof C00501) {
            c00501 = (C00501) continuation;
            if ((c00501.label & Integer.MIN_VALUE) != 0) {
                c00501.label -= Integer.MIN_VALUE;
            } else {
                c00501 = new C00501(continuation);
            }
        } else {
            c00501 = new C00501(continuation);
        }
        Object filesByFilenameContainingSubstring$runIt$26 = c00501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00501.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(filesByFilenameContainingSubstring$runIt$26);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c00501.L$0 = this;
                    c00501.L$1 = str;
                    c00501.L$2 = mutex;
                    c00501.label = 1;
                    if (mutex.lock((Object) null, c00501) != coroutine_suspended) {
                        googleDrive = this;
                    }
                } else {
                    c00501.label = 3;
                    Object filesByFilenameContainingSubstring$runIt$27 = getFilesByFilenameContainingSubstring$runIt$26(this, str, c00501);
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
                mutex2 = (Mutex) c00501.L$0;
                try {
                    ResultKt.throwOnFailure(filesByFilenameContainingSubstring$runIt$26);
                    List list = (List) filesByFilenameContainingSubstring$runIt$26;
                    mutex2.unlock((Object) null);
                    return list;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock((Object) null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c00501.L$2;
            String str2 = (String) c00501.L$1;
            googleDrive = (GoogleDrive) c00501.L$0;
            ResultKt.throwOnFailure(filesByFilenameContainingSubstring$runIt$26);
            mutex = mutex3;
            str = str2;
            c00501.L$0 = mutex;
            c00501.L$1 = null;
            c00501.L$2 = null;
            c00501.label = 2;
            filesByFilenameContainingSubstring$runIt$26 = getFilesByFilenameContainingSubstring$runIt$26(googleDrive, str, c00501);
            if (filesByFilenameContainingSubstring$runIt$26 != coroutine_suspended) {
                mutex2 = mutex;
                List list2 = (List) filesByFilenameContainingSubstring$runIt$26;
                mutex2.unlock((Object) null);
                return list2;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock((Object) null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getFilesByFilenameContainingSubstring$runIt$26(GoogleDrive googleDrive, String str, Continuation<? super List<File>> continuation) {
        return listAllFiles$default(googleDrive, "name contains '" + str + "'", null, false, continuation, 2, null);
    }

    public static /* synthetic */ Object getFilesByFilename$default(GoogleDrive googleDrive, String str, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return googleDrive.getFilesByFilename(str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFilesByFilename(String str, boolean z, Continuation<? super List<File>> continuation) throws Throwable {
        C00491 c00491;
        Mutex mutex;
        GoogleDrive googleDrive;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof C00491) {
            c00491 = (C00491) continuation;
            if ((c00491.label & Integer.MIN_VALUE) != 0) {
                c00491.label -= Integer.MIN_VALUE;
            } else {
                c00491 = new C00491(continuation);
            }
        } else {
            c00491 = new C00491(continuation);
        }
        Object filesByFilename$runIt$28 = c00491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00491.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(filesByFilename$runIt$28);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c00491.L$0 = this;
                    c00491.L$1 = str;
                    c00491.L$2 = mutex;
                    c00491.label = 1;
                    if (mutex.lock((Object) null, c00491) != coroutine_suspended) {
                        googleDrive = this;
                    }
                } else {
                    c00491.label = 3;
                    Object filesByFilename$runIt$29 = getFilesByFilename$runIt$28(this, str, c00491);
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
                mutex2 = (Mutex) c00491.L$0;
                try {
                    ResultKt.throwOnFailure(filesByFilename$runIt$28);
                    List list = (List) filesByFilename$runIt$28;
                    mutex2.unlock((Object) null);
                    return list;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock((Object) null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c00491.L$2;
            String str2 = (String) c00491.L$1;
            googleDrive = (GoogleDrive) c00491.L$0;
            ResultKt.throwOnFailure(filesByFilename$runIt$28);
            mutex = mutex3;
            str = str2;
            c00491.L$0 = mutex;
            c00491.L$1 = null;
            c00491.L$2 = null;
            c00491.label = 2;
            filesByFilename$runIt$28 = getFilesByFilename$runIt$28(googleDrive, str, c00491);
            if (filesByFilename$runIt$28 != coroutine_suspended) {
                mutex2 = mutex;
                List list2 = (List) filesByFilename$runIt$28;
                mutex2.unlock((Object) null);
                return list2;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock((Object) null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getFilesByFilename$runIt$28(GoogleDrive googleDrive, String str, Continuation<? super List<File>> continuation) {
        return listAllFiles$default(googleDrive, "name='" + str + "'", null, false, continuation, 2, null);
    }

    public static /* synthetic */ Object uploadByteArrayToFilename$default(GoogleDrive googleDrive, String str, byte[] bArr, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return googleDrive.uploadByteArrayToFilename(str, bArr, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object uploadByteArrayToFilename(String str, byte[] bArr, boolean z, Continuation<? super File> continuation) throws Throwable {
        C00581 c00581;
        Mutex mutex;
        GoogleDrive googleDrive;
        Mutex mutex2;
        if (continuation instanceof C00581) {
            c00581 = (C00581) continuation;
            if ((c00581.label & Integer.MIN_VALUE) != 0) {
                c00581.label -= Integer.MIN_VALUE;
            } else {
                c00581 = new C00581(continuation);
            }
        } else {
            c00581 = new C00581(continuation);
        }
        Object objUploadByteArrayToFilename$runIt$30 = c00581.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00581.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objUploadByteArrayToFilename$runIt$30);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c00581.L$0 = this;
                    c00581.L$1 = str;
                    c00581.L$2 = bArr;
                    c00581.L$3 = mutex;
                    c00581.label = 1;
                    if (mutex.lock((Object) null, c00581) != coroutine_suspended) {
                        googleDrive = this;
                    }
                } else {
                    c00581.label = 3;
                    Object objUploadByteArrayToFilename$runIt$31 = uploadByteArrayToFilename$runIt$30(this, str, bArr, c00581);
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
                mutex2 = (Mutex) c00581.L$0;
                try {
                    ResultKt.throwOnFailure(objUploadByteArrayToFilename$runIt$30);
                    File file = (File) objUploadByteArrayToFilename$runIt$30;
                    mutex2.unlock((Object) null);
                    return file;
                } catch (Throwable th) {
                    th = th;
                    mutex2.unlock((Object) null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c00581.L$3;
            bArr = (byte[]) c00581.L$2;
            String str2 = (String) c00581.L$1;
            googleDrive = (GoogleDrive) c00581.L$0;
            ResultKt.throwOnFailure(objUploadByteArrayToFilename$runIt$30);
            mutex = mutex3;
            str = str2;
            c00581.L$0 = mutex;
            c00581.L$1 = null;
            c00581.L$2 = null;
            c00581.L$3 = null;
            c00581.label = 2;
            objUploadByteArrayToFilename$runIt$30 = uploadByteArrayToFilename$runIt$30(googleDrive, str, bArr, c00581);
            if (objUploadByteArrayToFilename$runIt$30 != coroutine_suspended) {
                mutex2 = mutex;
                File file2 = (File) objUploadByteArrayToFilename$runIt$30;
                mutex2.unlock((Object) null);
                return file2;
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock((Object) null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object uploadByteArrayToFilename$runIt$30(GoogleDrive googleDrive, String str, byte[] bArr, Continuation<? super File> continuation) {
        return googleDrive.createOrUpdateFileByFilenameAndInputStream(str, new ByteArrayInputStream(bArr), false, continuation);
    }

    public static /* synthetic */ Object downloadByteArrayFromFilename$default(GoogleDrive googleDrive, String str, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return googleDrive.downloadByteArrayFromFilename(str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object downloadByteArrayFromFilename(String str, boolean z, Continuation<? super byte[]> continuation) throws Throwable {
        C00471 c00471;
        Mutex mutex;
        GoogleDrive googleDrive;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof C00471) {
            c00471 = (C00471) continuation;
            if ((c00471.label & Integer.MIN_VALUE) != 0) {
                c00471.label -= Integer.MIN_VALUE;
            } else {
                c00471 = new C00471(continuation);
            }
        } else {
            c00471 = new C00471(continuation);
        }
        Object objDownloadByteArrayFromFilename$runIt$32 = c00471.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00471.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objDownloadByteArrayFromFilename$runIt$32);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c00471.L$0 = this;
                    c00471.L$1 = str;
                    c00471.L$2 = mutex;
                    c00471.label = 1;
                    if (mutex.lock((Object) null, c00471) != coroutine_suspended) {
                        googleDrive = this;
                    }
                } else {
                    c00471.label = 3;
                    Object objDownloadByteArrayFromFilename$runIt$33 = downloadByteArrayFromFilename$runIt$32(this, str, c00471);
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
                mutex2 = (Mutex) c00471.L$0;
                try {
                    ResultKt.throwOnFailure(objDownloadByteArrayFromFilename$runIt$32);
                    byte[] bArr = (byte[]) objDownloadByteArrayFromFilename$runIt$32;
                    mutex2.unlock((Object) null);
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock((Object) null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c00471.L$2;
            String str2 = (String) c00471.L$1;
            googleDrive = (GoogleDrive) c00471.L$0;
            ResultKt.throwOnFailure(objDownloadByteArrayFromFilename$runIt$32);
            mutex = mutex3;
            str = str2;
            c00471.L$0 = mutex;
            c00471.L$1 = null;
            c00471.L$2 = null;
            c00471.label = 2;
            objDownloadByteArrayFromFilename$runIt$32 = downloadByteArrayFromFilename$runIt$32(googleDrive, str, c00471);
            if (objDownloadByteArrayFromFilename$runIt$32 != coroutine_suspended) {
                mutex2 = mutex;
                byte[] bArr2 = (byte[]) objDownloadByteArrayFromFilename$runIt$32;
                mutex2.unlock((Object) null);
                return bArr2;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock((Object) null);
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

    public static /* synthetic */ Object downloadByteArrayFromFileId$default(GoogleDrive googleDrive, String str, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return googleDrive.downloadByteArrayFromFileId(str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object downloadByteArrayFromFileId(String str, boolean z, Continuation<? super byte[]> continuation) throws Throwable {
        C00461 c00461;
        Mutex mutex;
        GoogleDrive googleDrive;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof C00461) {
            c00461 = (C00461) continuation;
            if ((c00461.label & Integer.MIN_VALUE) != 0) {
                c00461.label -= Integer.MIN_VALUE;
            } else {
                c00461 = new C00461(continuation);
            }
        } else {
            c00461 = new C00461(continuation);
        }
        Object objDownloadByteArrayFromFileId$runIt$34 = c00461.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00461.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objDownloadByteArrayFromFileId$runIt$34);
                if (z) {
                    mutex = this.driveOperationMutex;
                    c00461.L$0 = this;
                    c00461.L$1 = str;
                    c00461.L$2 = mutex;
                    c00461.label = 1;
                    if (mutex.lock((Object) null, c00461) != coroutine_suspended) {
                        googleDrive = this;
                    }
                } else {
                    c00461.label = 3;
                    Object objDownloadByteArrayFromFileId$runIt$35 = downloadByteArrayFromFileId$runIt$34(this, str, c00461);
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
                mutex2 = (Mutex) c00461.L$0;
                try {
                    ResultKt.throwOnFailure(objDownloadByteArrayFromFileId$runIt$34);
                    byte[] bArr = (byte[]) objDownloadByteArrayFromFileId$runIt$34;
                    mutex2.unlock((Object) null);
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock((Object) null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) c00461.L$2;
            String str2 = (String) c00461.L$1;
            googleDrive = (GoogleDrive) c00461.L$0;
            ResultKt.throwOnFailure(objDownloadByteArrayFromFileId$runIt$34);
            mutex = mutex3;
            str = str2;
            c00461.L$0 = mutex;
            c00461.L$1 = null;
            c00461.L$2 = null;
            c00461.label = 2;
            objDownloadByteArrayFromFileId$runIt$34 = downloadByteArrayFromFileId$runIt$34(googleDrive, str, c00461);
            if (objDownloadByteArrayFromFileId$runIt$34 != coroutine_suspended) {
                mutex2 = mutex;
                byte[] bArr2 = (byte[]) objDownloadByteArrayFromFileId$runIt$34;
                mutex2.unlock((Object) null);
                return bArr2;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock((Object) null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object downloadByteArrayFromFileId$runIt$34(GoogleDrive googleDrive, String str, Continuation<? super byte[]> continuation) {
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
            BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), (CoroutineStart) null, new C00571(googleAccountCredentialUsingOAuth2, googleSignInAccount, null), 2, (Object) null);
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

    /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$setupGoogleSignInAccount$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GoogleDrive.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive$setupGoogleSignInAccount$1", f = "GoogleDrive.kt", i = {0, 1}, l = {412, 413, 417, 419}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
    static final class C00571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GoogleAccountCredential $googleAccountCredential;
        final /* synthetic */ GoogleSignInAccount $googleSignInAccount;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00571(GoogleAccountCredential googleAccountCredential, GoogleSignInAccount googleSignInAccount, Continuation<? super C00571> continuation) {
            super(2, continuation);
            this.$googleAccountCredential = googleAccountCredential;
            this.$googleSignInAccount = googleSignInAccount;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00571 c00571 = GoogleDrive.this.new C00571(this.$googleAccountCredential, this.$googleSignInAccount, continuation);
            c00571.L$0 = obj;
            return c00571;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:33:0x00be  */
        /* JADX WARN: Code duplicated, block: B:34:0x00bf A[Catch: Exception -> 0x0032, TryCatch #0 {Exception -> 0x0032, blocks: (B:8:0x0020, B:12:0x002d, B:41:0x00fb, B:17:0x003d, B:31:0x00ba, B:38:0x00e8, B:34:0x00bf, B:36:0x00c5, B:37:0x00c9, B:20:0x0048, B:26:0x00a7, B:28:0x00ab, B:23:0x0056), top: B:54:0x0016 }] */
        /* JADX WARN: Code duplicated, block: B:36:0x00c5 A[Catch: Exception -> 0x0032, TryCatch #0 {Exception -> 0x0032, blocks: (B:8:0x0020, B:12:0x002d, B:41:0x00fb, B:17:0x003d, B:31:0x00ba, B:38:0x00e8, B:34:0x00bf, B:36:0x00c5, B:37:0x00c9, B:20:0x0048, B:26:0x00a7, B:28:0x00ab, B:23:0x0056), top: B:54:0x0016 }] */
        /* JADX WARN: Code duplicated, block: B:40:0x00fa  */
        /* JADX WARN: Code duplicated, block: B:41:0x00fb A[Catch: Exception -> 0x0032, TRY_LEAVE, TryCatch #0 {Exception -> 0x0032, blocks: (B:8:0x0020, B:12:0x002d, B:41:0x00fb, B:17:0x003d, B:31:0x00ba, B:38:0x00e8, B:34:0x00bf, B:36:0x00c5, B:37:0x00c9, B:20:0x0048, B:26:0x00a7, B:28:0x00ab, B:23:0x0056), top: B:54:0x0016 }] */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0116, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.features.GoogleDrive.C00571.AnonymousClass2(r17.this$0, r17.$googleSignInAccount, null), r17) == r3) goto L43;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 327
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.features.GoogleDrive.C00571.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.features.GoogleDrive$setupGoogleSignInAccount$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: GoogleDrive.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.features.GoogleDrive$setupGoogleSignInAccount$1$2", f = "GoogleDrive.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ GoogleSignInAccount $googleSignInAccount;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ GoogleDrive this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(GoogleDrive googleDrive, GoogleSignInAccount googleSignInAccount, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = googleDrive;
                this.$googleSignInAccount = googleSignInAccount;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$googleSignInAccount, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
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

    private final void handleSignInIntent(Intent intent) {
        Task signedInAccountFromIntent = GoogleSignIn.getSignedInAccountFromIntent(intent);
        final Function1<GoogleSignInAccount, Unit> function1 = new Function1<GoogleSignInAccount, Unit>() { // from class: com.magneticchen.daijishou.features.GoogleDrive.handleSignInIntent.1
            

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
        };
        signedInAccountFromIntent.addOnSuccessListener(new OnSuccessListener() { // from class: com.magneticchen.daijishou.features.GoogleDrive$$ExternalSyntheticLambda0
            public final void onSuccess(Object obj) {
                GoogleDrive.handleSignInIntent$lambda$36(function1, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.magneticchen.daijishou.features.GoogleDrive$$ExternalSyntheticLambda1
            public final void onFailure(Exception exc) {
                GoogleDrive.handleSignInIntent$lambda$37(this.f$0, exc);
            }
        });
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
