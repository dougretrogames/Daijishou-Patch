package com.magneticchen.daijishou.daijishou_debug_service;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.activities.BootstrapActivity;
import com.magneticchen.daijishou.activities.abstract_classes.DaijishouService;
import com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.ClientOperation;
import com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.client_operations.ConsoleOperation;
import com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.client_operations.ExceptionOperation;
import com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.client_operations.FileOperation;
import com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.client_operations.HeartbeatOperation;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.apache.commons.collections4.CollectionUtils;

/* INFO: compiled from: DaijishouDebugService.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u000201B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020 H\u0016J\b\u0010(\u001a\u00020 H\u0016J\"\u0010)\u001a\u00020*2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020 H\u0002J\b\u0010.\u001a\u00020 H\u0002J\b\u0010/\u001a\u00020 H\u0002R\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u00060\u0005R\u00020\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00060\rR\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_debug_service/DaijishouDebugService;", "Lcom/magneticchen/daijishou/activities/abstract_classes/DaijishouService;", "()V", "daijishouDebugServiceTcpClients", "", "Lcom/magneticchen/daijishou/daijishou_debug_service/DaijishouDebugService$DaijishouDebugServiceTcpClient;", "isServerRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isServiceInForeground", "", "job", "Lkotlinx/coroutines/CompletableJob;", "logger", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "Lcom/magneticchen/daijishou/DaijishouApplication;", "getLogger", "()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "setLogger", "(Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;)V", "notificationChannel", "Landroid/app/NotificationChannel;", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "()Landroid/app/NotificationManager;", "setNotificationManager", "(Landroid/app/NotificationManager;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "serverSocket", "Ljava/net/ServerSocket;", "handleTcpClient", "", "socket", "Ljava/net/Socket;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "", "flags", "startId", "startForeground", "startTcpServer", "stopTcpServer", "Companion", "DaijishouDebugServiceTcpClient", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouDebugService extends DaijishouService {
    public static final int HEARTBEAT_INTERVAL_MS = 3000;
    private static final String NOTIFICATION_CHANNEL_ID = "daijishou debug";
    private static final int PORT = 19487;
    public final List<DaijishouDebugServiceTcpClient> daijishouDebugServiceTcpClients;
    private final AtomicBoolean isServerRunning;
    private boolean isServiceInForeground;
    private final CompletableJob job;
    public DaijishouApplication.WrappedLogger logger;
    private final NotificationChannel notificationChannel;
    public NotificationManager notificationManager;
    public final CoroutineScope scope;
    private ServerSocket serverSocket;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    public DaijishouDebugService() {
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.job = completableJobSupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(completableJobSupervisorJob$default));
        this.isServerRunning = new AtomicBoolean(true);
        NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "Daijishou Debug", 4);
        notificationChannel.setDescription("This is Daijishou Debug notification channel.");
        this.notificationChannel = notificationChannel;
        this.daijishouDebugServiceTcpClients = new ArrayList();
    }

    public final DaijishouApplication.WrappedLogger getLogger() {
        DaijishouApplication.WrappedLogger wrappedLogger = this.logger;
        if (wrappedLogger != null) {
            return wrappedLogger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger(DaijishouApplication.WrappedLogger wrappedLogger) {
        Intrinsics.checkNotNullParameter(wrappedLogger, "<set-?>");
        this.logger = wrappedLogger;
    }

    public final NotificationManager getNotificationManager() {
        NotificationManager notificationManager = this.notificationManager;
        if (notificationManager != null) {
            return notificationManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
        return null;
    }

    public final void setNotificationManager(NotificationManager notificationManager) {
        Intrinsics.checkNotNullParameter(notificationManager, "<set-?>");
        this.notificationManager = notificationManager;
    }

    /* INFO: compiled from: DaijishouDebugService.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_debug_service/DaijishouDebugService$DaijishouDebugServiceTcpClient;", "", "socket", "Ljava/net/Socket;", "(Lcom/magneticchen/daijishou/daijishou_debug_service/DaijishouDebugService;Ljava/net/Socket;)V", "keepRunning", "", "lastHeartbeatTime", "", "operationCodeToInstanceHashMap", "Ljava/util/HashMap;", "", "Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/ClientOperation;", "Lkotlin/collections/HashMap;", "closeTcpClient", "", "digestBytes", "digestOperationBytes", "start", "stop", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class DaijishouDebugServiceTcpClient {
        public boolean keepRunning;
        public long lastHeartbeatTime;
        public final HashMap<Byte, ClientOperation> operationCodeToInstanceHashMap;
        public final Socket socket;
        final /* synthetic */ DaijishouDebugService this$0;

        public final void digestBytes() {
        }

        public final void digestOperationBytes() {
        }

        public DaijishouDebugServiceTcpClient(DaijishouDebugService daijishouDebugService, Socket socket) {
            Intrinsics.checkNotNullParameter(socket, "socket");
            this.this$0 = daijishouDebugService;
            this.socket = socket;
            this.keepRunning = true;
            HashMap<Byte, ClientOperation> map = new HashMap<>();
            Application application = daijishouDebugService.getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            HeartbeatOperation heartbeatOperation = new HeartbeatOperation((DaijishouApplication) application);
            HashMap<Byte, ClientOperation> map2 = map;
            map2.put(Byte.valueOf(heartbeatOperation.getHeaderByteCode()), heartbeatOperation);
            Application application2 = daijishouDebugService.getApplication();
            Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            ExceptionOperation exceptionOperation = new ExceptionOperation((DaijishouApplication) application2);
            map2.put(Byte.valueOf(exceptionOperation.getHeaderByteCode()), exceptionOperation);
            Application application3 = daijishouDebugService.getApplication();
            Intrinsics.checkNotNull(application3, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            ConsoleOperation consoleOperation = new ConsoleOperation((DaijishouApplication) application3);
            map2.put(Byte.valueOf(consoleOperation.getHeaderByteCode()), consoleOperation);
            Application application4 = daijishouDebugService.getApplication();
            Intrinsics.checkNotNull(application4, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
            FileOperation fileOperation = new FileOperation((DaijishouApplication) application4);
            map2.put(Byte.valueOf(fileOperation.getHeaderByteCode()), fileOperation);
            this.operationCodeToInstanceHashMap = map;
        }

        public final void start() {
            ThreadsKt.thread$default(false, false, null, null, 0, new DaijishouDebugService$DaijishouDebugServiceTcpClient$start$1(this.this$0, this), 31, null);
        }

        /* INFO: Access modifiers changed from: private */
        public final void closeTcpClient() {
            try {
                this.socket.close();
            } catch (IOException e) {
                this.this$0.getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
            }
            this.keepRunning = false;
        }

        public final void stop() {
            closeTcpClient();
        }
    }

    @Override // com.magneticchen.daijishou.activities.abstract_classes.DaijishouService, android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Intrinsics.checkNotNull(intent);
        Bundle extras = intent.getExtras();
        if ((extras != null ? extras.getBoolean("startForeground") : false) && !this.isServiceInForeground) {
            startForeground();
        }
        getLogger().info(this, "Daijishou service onStartCommand.");
        return 2;
    }

    @Override // android.app.Service
    public void onCreate() {
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setLogger(((DaijishouApplication) application).getLogger());
        getLogger().info(this, "DaijishouDebugService onCreate  (" + Process.myPid() + CollectionUtils.COLON + Process.myTid() + ").");
        Object systemService = getSystemService(NotificationManager.class);
        Intrinsics.checkNotNullExpressionValue(systemService, "getSystemService(...)");
        setNotificationManager((NotificationManager) systemService);
        getNotificationManager().createNotificationChannel(this.notificationChannel);
        BuildersKt.launch$default(this.scope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_debug_service.DaijishouDebugService$onCreate$1, reason: invalid class name */
    /* INFO: compiled from: DaijishouDebugService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_debug_service.DaijishouDebugService$onCreate$1", f = "DaijishouDebugService.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;

        AnonymousClass1(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return DaijishouDebugService.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    try {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                DaijishouDebugService.this.startTcpServer();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        getLogger().info(this, "DaijishouDebugService onDestroy.");
        this.isServerRunning.set(false);
        Job.DefaultImpls.cancel$default((Job) this.job, (CancellationException) null, 1, (Object) null);
        Iterator it = this.daijishouDebugServiceTcpClients.iterator();
        while (it.hasNext()) {
            ((DaijishouDebugServiceTcpClient) it.next()).stop();
        }
        this.daijishouDebugServiceTcpClients.clear();
        try {
            stopTcpServer();
        } catch (java.io.IOException e) {
            getLogger().warn(this, "Failed to stop TCP server: " + e);
        }
    }

    private final void startForeground() {
        this.isServiceInForeground = true;
        DaijishouDebugService daijishouDebugService = this;
        Intent intent = new Intent(daijishouDebugService, (Class<?>) DaijishouDebugServiceBroadcastReceiver.class);
        intent.putExtra("MESSAGE", "Clicked!");
        PendingIntent broadcast = PendingIntent.getBroadcast(daijishouDebugService, 0, intent, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        Notification notificationBuild = new NotificationCompat.Builder(daijishouDebugService, NOTIFICATION_CHANNEL_ID).setOngoing(true).setContentTitle("Daijishou Debug Service").setContentText("Daijishou Debug Service is listening. Stop the service if you have no idea what is going on!").setSmallIcon(R.drawable.ic_daijishou_notification).setCategory(NotificationCompat.CATEGORY_ALARM).addAction(0, "Stop Debug Service", broadcast).build();
        if (Build.VERSION.SDK_INT >= 34) {
            startForeground(2, notificationBuild, 1073741824);
        } else {
            startForeground(2, notificationBuild);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public final void handleTcpClient(Socket socket) {
        Intent intent = new Intent(this, (Class<?>) BootstrapActivity.class);
        intent.addFlags(268435456);
        startActivity(intent);
        List<DaijishouDebugServiceTcpClient> list = this.daijishouDebugServiceTcpClients;
        DaijishouDebugServiceTcpClient daijishouDebugServiceTcpClient = new DaijishouDebugServiceTcpClient(this, socket);
        daijishouDebugServiceTcpClient.start();
        list.add(daijishouDebugServiceTcpClient);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_debug_service.DaijishouDebugService$startTcpServer$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: DaijishouDebugService.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class C02101 extends Lambda<Unit> implements Function0<Unit> {
        C02101() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Socket socketAccept = null;
            try {
                DaijishouDebugService.this.serverSocket = new ServerSocket(DaijishouDebugService.PORT);
                while (DaijishouDebugService.this.isServerRunning.get()) {
                    if (DaijishouDebugService.this.serverSocket != null) {
                        ServerSocket serverSocket = DaijishouDebugService.this.serverSocket;
                        Intrinsics.checkNotNull(serverSocket);
                        socketAccept = serverSocket.accept();
                        DaijishouDebugService.this.handleTcpClient(socketAccept);
                    } else {
                        DaijishouDebugService.this.getLogger().debug(DaijishouDebugService.this, "Couldn't create ServerSocket!");
                    }
                }
            } catch (SocketException unused) {
                DaijishouDebugService.this.getLogger().warn(DaijishouDebugService.this, "Socket closed.");
            } catch (IOException e) {
                DaijishouDebugService.this.getLogger().warn(DaijishouDebugService.this, ExceptionsKt.stackTraceToString(e));
                if (socketAccept != null) {
                    try {
                        socketAccept.close();
                    } catch (IOException e2) {
                        DaijishouDebugService.this.getLogger().warn(DaijishouDebugService.this, ExceptionsKt.stackTraceToString(e2));
                    }
                }
            }
        }
    }

    /* INFO: Access modifiers changed from: private */
    public final void startTcpServer() {
        ThreadsKt.thread$default(false, false, null, null, 0, new C02101(), 31, null);
    }

    private final void stopTcpServer() throws IOException {
        ServerSocket serverSocket = this.serverSocket;
        if (serverSocket != null) {
            serverSocket.close();
        }
    }
}
