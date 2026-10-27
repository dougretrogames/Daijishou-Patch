package com.magneticchen.daijishou.service.debug.passive_protocol.client_operations;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.service.debug.passive_protocol.ClientOperation;
import com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ConsoleOperation.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000b¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/service/debug/passive_protocol/client_operations/ConsoleOperation;", "Lcom/magneticchen/daijishou/service/debug/passive_protocol/ClientOperation;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "headerByteCode", "", "getHeaderByteCode", "()B", "isMainActivityRequired", "", "()Z", "handleDataStreams", "", "dataInputStream", "Ljava/io/DataInputStream;", "dataOutputStream", "Ljava/io/DataOutputStream;", "(Ljava/io/DataInputStream;Ljava/io/DataOutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release", "console", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConsoleOperation extends ClientOperation {
    private final byte headerByteCode;
    private final boolean isMainActivityRequired;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsoleOperation(DaijishouApplication application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.isMainActivityRequired = true;
        this.headerByteCode = (byte) 2;
    }

    @Override // com.magneticchen.daijishou.service.debug.passive_protocol.ClientOperation
    public boolean isMainActivityRequired() {
        return this.isMainActivityRequired;
    }

    @Override // com.magneticchen.daijishou.service.debug.passive_protocol.ClientOperation
    public byte getHeaderByteCode() {
        return this.headerByteCode;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.service.debug.passive_protocol.client_operations.ConsoleOperation$handleDataStreams$2, reason: invalid class name */
    /* JADX INFO: compiled from: ConsoleOperation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.service.debug.passive_protocol.client_operations.ConsoleOperation$handleDataStreams$2", f = "ConsoleOperation.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ DataInputStream $dataInputStream;
        final /* synthetic */ DataOutputStream $dataOutputStream;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DataInputStream dataInputStream, DataOutputStream dataOutputStream, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$dataInputStream = dataInputStream;
            this.$dataOutputStream = dataOutputStream;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConsoleOperation.this.new AnonymousClass2(this.$dataInputStream, this.$dataOutputStream, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            int iWriteStringToDataOutputStream;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String stringFromDataInputStream = ConsoleOperation.this.readStringFromDataInputStream(this.$dataInputStream);
                if (ConsoleOperation.this.getApplication().getMainActivity() == null) {
                    this.$dataOutputStream.write(ConsoleOperation.this.getHeaderByteCode());
                    this.$dataOutputStream.writeInt(DaijishouConsoleViewModel.Companion.CommandResult.Companion.getFAILED_STATUS_CODE());
                    iWriteStringToDataOutputStream = ConsoleOperation.this.writeStringToDataOutputStream(this.$dataOutputStream, "");
                } else {
                    AppCompatActivity appCompatActivityRequireMainActivity = ConsoleOperation.this.requireMainActivity();
                    final ComponentActivity componentActivity = (ComponentActivity) appCompatActivityRequireMainActivity;
                    Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.service.debug.passive_protocol.client_operations.ConsoleOperation$handleDataStreams$2$invokeSuspend$$inlined$viewModels$default$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final ViewModelProvider.Factory invoke() {
                            return componentActivity.getDefaultViewModelProviderFactory();
                        }
                    };
                    final Function0 function1 = null;
                    this.label = 1;
                    obj = invokeSuspend$lambda$0(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouConsoleViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.service.debug.passive_protocol.client_operations.ConsoleOperation$handleDataStreams$2$invokeSuspend$$inlined$viewModels$default$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final ViewModelStore invoke() {
                            return componentActivity.getViewModelStore();
                        }
                    }, function0, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.service.debug.passive_protocol.client_operations.ConsoleOperation$handleDataStreams$2$invokeSuspend$$inlined$viewModels$default$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final CreationExtras invoke() {
                            CreationExtras creationExtras;
                            Function0 function2 = function1;
                            return (function2 == null || (creationExtras = (CreationExtras) function2.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
                        }
                    })).execute(appCompatActivityRequireMainActivity, stringFromDataInputStream, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Boxing.boxInt(iWriteStringToDataOutputStream);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            DaijishouConsoleViewModel.Companion.CommandResult commandResult = (DaijishouConsoleViewModel.Companion.CommandResult) obj;
            this.$dataOutputStream.write(ConsoleOperation.this.getHeaderByteCode());
            this.$dataOutputStream.writeInt(commandResult.getStatusCode());
            ConsoleOperation consoleOperation = ConsoleOperation.this;
            DataOutputStream dataOutputStream = this.$dataOutputStream;
            String message = commandResult.getMessage();
            iWriteStringToDataOutputStream = consoleOperation.writeStringToDataOutputStream(dataOutputStream, message != null ? message : "");
            return Boxing.boxInt(iWriteStringToDataOutputStream);
        }

        private static final DaijishouConsoleViewModel invokeSuspend$lambda$0(Lazy<DaijishouConsoleViewModel> lazy) {
            return lazy.getValue();
        }
    }

    @Override // com.magneticchen.daijishou.service.debug.passive_protocol.ClientOperation
    public Object handleDataStreams(DataInputStream dataInputStream, DataOutputStream dataOutputStream, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(dataInputStream, dataOutputStream, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
