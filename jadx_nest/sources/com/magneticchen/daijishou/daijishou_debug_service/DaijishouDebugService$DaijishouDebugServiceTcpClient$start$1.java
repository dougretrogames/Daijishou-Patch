package com.magneticchen.daijishou.daijishou_debug_service;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.ClientOperation;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* INFO: compiled from: DaijishouDebugService.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DaijishouDebugService$DaijishouDebugServiceTcpClient$start$1 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ DaijishouDebugService this$0;
    final /* synthetic */ DaijishouDebugService.DaijishouDebugServiceTcpClient this$1;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DaijishouDebugService$DaijishouDebugServiceTcpClient$start$1(DaijishouDebugService daijishouDebugService, DaijishouDebugService.DaijishouDebugServiceTcpClient daijishouDebugServiceTcpClient) {
        super(0);
        this.this$0 = daijishouDebugService;
        this.this$1 = daijishouDebugServiceTcpClient;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        DaijishouApplication.WrappedLogger logger = this.this$0.getLogger();
        DaijishouDebugService.DaijishouDebugServiceTcpClient daijishouDebugServiceTcpClient = this.this$1;
        logger.info(daijishouDebugServiceTcpClient, "New client: " + daijishouDebugServiceTcpClient.socket);
        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;
        try {
            dataInputStream = new DataInputStream(this.this$1.socket.getInputStream());
            dataOutputStream = new DataOutputStream(this.this$1.socket.getOutputStream());
        } catch (IOException e) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(e);
        }
        NotificationManagerCompat.from(this.this$0).notify(3, new NotificationCompat.Builder(this.this$0, "daijishou debug").setOngoing(true).setContentTitle("Daijishou Debug Service").setContentText("New client connected: \n" + this.this$1.socket).setSmallIcon(R.drawable.ic_daijishou_notification).setStyle(new NotificationCompat.BigTextStyle()).setCategory(NotificationCompat.CATEGORY_ALARM).build());
        Deferred deferredAsync$default = null;
        while (this.this$1.keepRunning) {
            try {
                if (dataInputStream.available() <= 0 || (deferredAsync$default != null && !deferredAsync$default.isCompleted())) {
                    if (this.this$1.socket.isClosed()) {
                        this.this$1.keepRunning = false;
                    } else if (deferredAsync$default == null && System.currentTimeMillis() - this.this$1.lastHeartbeatTime > 3000) {
                        dataOutputStream.write(0);
                        this.this$1.lastHeartbeatTime = System.currentTimeMillis();
                    }
                } else {
                    byte b = dataInputStream.readByte();
                    this.this$0.getLogger().debug(this.this$1, "Operation Code: " + ((int) b));
                    Object obj = this.this$1.operationCodeToInstanceHashMap.get(Byte.valueOf(b));
                    Intrinsics.checkNotNull(obj);
                    deferredAsync$default = BuildersKt.async$default(this.this$0.scope, null, null, new AnonymousClass2((ClientOperation) obj, dataInputStream, dataOutputStream, this.this$0, b, this.this$1, null), 3, null);
                    deferredAsync$default.start();
                    this.this$1.lastHeartbeatTime = System.currentTimeMillis();
                }
                Thread.sleep(500L);
            } catch (EOFException unused) {
                this.this$0.getLogger().info(this.this$1, "Client closed.");
                this.this$1.closeTcpClient();
            } catch (IOException e) {
                this.this$0.getLogger().warn(this.this$1, ExceptionsKt.stackTraceToString(e));
                this.this$1.closeTcpClient();
            } catch (InterruptedException e2) {
                this.this$0.getLogger().warn(this.this$1, ExceptionsKt.stackTraceToString(e2));
                this.this$1.closeTcpClient();
            }
        }
        this.this$0.daijishouDebugServiceTcpClients.remove(this.this$1);
        if (this.this$0.daijishouDebugServiceTcpClients.size() == 0) {
            this.this$0.getNotificationManager().cancel(3);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_debug_service.DaijishouDebugService$DaijishouDebugServiceTcpClient$start$1$2, reason: invalid class name */
    /* INFO: compiled from: DaijishouDebugService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_debug_service.DaijishouDebugService$DaijishouDebugServiceTcpClient$start$1$2", f = "DaijishouDebugService.kt", i = {0}, l = {168}, m = "invokeSuspendImpl", n = {"$this$async"}, s = {"L$0"})
    static final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ DataInputStream $dataInputStream;
        final /* synthetic */ DataOutputStream $dataOutputStream;
        final /* synthetic */ ClientOperation $operation;
        final /* synthetic */ byte $operationCodeByte;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DaijishouDebugService this$0;
        final /* synthetic */ DaijishouDebugService.DaijishouDebugServiceTcpClient this$1;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ClientOperation clientOperation, DataInputStream dataInputStream, DataOutputStream dataOutputStream, DaijishouDebugService daijishouDebugService, byte b, DaijishouDebugService.DaijishouDebugServiceTcpClient daijishouDebugServiceTcpClient, Continuation<?> continuation) {
            super(2, continuation);
            this.$operation = clientOperation;
            this.$dataInputStream = dataInputStream;
            this.$dataOutputStream = dataOutputStream;
            this.this$0 = daijishouDebugService;
            this.$operationCodeByte = b;
            this.this$1 = daijishouDebugServiceTcpClient;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$operation, this.$dataInputStream, this.$dataOutputStream, this.this$0, this.$operationCodeByte, this.this$1, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            CoroutineScope coroutineScope;
            Exception e;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    this.L$0 = coroutineScope2;
                    this.label = 1;
                    if (this.$operation.handleDataStreams(this.$dataInputStream, this.$dataOutputStream, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineScope = coroutineScope2;
                } catch (Exception e2) {
                    coroutineScope = coroutineScope2;
                    e = e2;
                    this.this$0.getLogger().warn(coroutineScope, ExceptionsKt.stackTraceToString(e));
                    this.this$1.closeTcpClient();
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e3) {
                    e = e3;
                    this.this$0.getLogger().warn(coroutineScope, ExceptionsKt.stackTraceToString(e));
                    this.this$1.closeTcpClient();
                }
            }
            this.this$0.getLogger().debug(coroutineScope, "Operation Code: " + ((int) this.$operationCodeByte) + " handled.");
            this.this$1.lastHeartbeatTime = System.currentTimeMillis();
            return Unit.INSTANCE;
        }
    }
}
