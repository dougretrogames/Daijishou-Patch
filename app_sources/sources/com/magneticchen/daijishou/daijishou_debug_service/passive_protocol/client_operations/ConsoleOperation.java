package com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.client_operations;

import androidx.lifecycle.ViewModelLazy;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.activities.MainActivity;
import com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.ClientOperation;
import com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* INFO: compiled from: ConsoleOperation.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000b¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/client_operations/ConsoleOperation;", "Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/ClientOperation;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "headerByteCode", "", "getHeaderByteCode", "()B", "isMainActivityRequired", "", "()Z", "handleDataStreams", "", "dataInputStream", "Ljava/io/DataInputStream;", "dataOutputStream", "Ljava/io/DataOutputStream;", "(Ljava/io/DataInputStream;Ljava/io/DataOutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release", "console", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConsoleOperation extends ClientOperation {
    private final byte headerByteCode;
    private final boolean isMainActivityRequired;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsoleOperation(DaijishouApplication application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.isMainActivityRequired = true;
        this.headerByteCode = (byte) 2;
    }

    @Override // com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.ClientOperation
    /* INFO: renamed from: isMainActivityRequired, reason: from getter */
    public boolean getIsMainActivityRequired() {
        return this.isMainActivityRequired;
    }

    @Override // com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.ClientOperation
    public byte getHeaderByteCode() {
        return this.headerByteCode;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.client_operations.ConsoleOperation$handleDataStreams$2, reason: invalid class name */
    /* INFO: compiled from: ConsoleOperation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.client_operations.ConsoleOperation$handleDataStreams$2", f = "ConsoleOperation.kt", i = {}, l = {45}, m = "invokeSuspendImpl", n = {}, s = {})
    final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ DataInputStream $dataInputStream;
        final /* synthetic */ DataOutputStream $dataOutputStream;
        int label;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DataInputStream dataInputStream, DataOutputStream dataOutputStream, Continuation<?> continuation) {
            super(2, continuation);
            this.$dataInputStream = dataInputStream;
            this.$dataOutputStream = dataOutputStream;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return ConsoleOperation.this.new AnonymousClass2(this.$dataInputStream, this.$dataOutputStream, continuation);
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
            int iWriteStringToDataOutputStream = 0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String stringFromDataInputStream = ConsoleOperation.this.readStringFromDataInputStream(this.$dataInputStream);
                if (ConsoleOperation.this.getApplication().getMainActivity() == null) {
                    this.$dataOutputStream.write(ConsoleOperation.this.getHeaderByteCode());
                    this.$dataOutputStream.writeInt(DaijishouConsoleViewModel.Companion.CommandResult.INSTANCE.getFAILED_STATUS_CODE());
                    iWriteStringToDataOutputStream = ConsoleOperation.this.writeStringToDataOutputStream(this.$dataOutputStream, "");
                    return Boxing.boxInt(iWriteStringToDataOutputStream);
                }
                MainActivity mainActivityRequireMainActivity = ConsoleOperation.this.requireMainActivity();
                MainActivity mainActivity = mainActivityRequireMainActivity;
                ConsoleOperation$handleDataStreams$2$invokeSuspendImpl$$inlined$viewModels$default$1 consoleOperation$handleDataStreams$2$invokeSuspendImpl$$inlined$viewModels$default$1 = new ConsoleOperation$handleDataStreams$2$invokeSuspendImpl$$inlined$viewModels$default$1(mainActivity);
                this.label = 1;
                obj = invokeSuspendImpl$lambda$0(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouConsoleViewModel.class), new ConsoleOperation$handleDataStreams$2$invokeSuspendImpl$$inlined$viewModels$default$2(mainActivity), consoleOperation$handleDataStreams$2$invokeSuspendImpl$$inlined$viewModels$default$1, new ConsoleOperation$handleDataStreams$2$invokeSuspendImpl$$inlined$viewModels$default$3(null, mainActivity))).execute(mainActivityRequireMainActivity, stringFromDataInputStream, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            DaijishouConsoleViewModel.Companion.CommandResult commandResult = (DaijishouConsoleViewModel.Companion.CommandResult) obj;
            this.$dataOutputStream.write(ConsoleOperation.this.getHeaderByteCode());
            this.$dataOutputStream.writeInt(commandResult.getStatusCode());
            ConsoleOperation consoleOperation = ConsoleOperation.this;
            DataOutputStream dataOutputStream = this.$dataOutputStream;
            String message = commandResult.getMessage();
            iWriteStringToDataOutputStream = consoleOperation.writeStringToDataOutputStream(dataOutputStream, message != null ? message : "");
            return Boxing.boxInt(iWriteStringToDataOutputStream);
        }

        private final DaijishouConsoleViewModel invokeSuspendImpl$lambda$0(Lazy<DaijishouConsoleViewModel> lazy) {
            return lazy.getValue();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.ClientOperation
    public Object handleDataStreams(DataInputStream dataInputStream, DataOutputStream dataOutputStream, Continuation<?> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(dataInputStream, dataOutputStream, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
