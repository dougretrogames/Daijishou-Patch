package com.magneticchen.daijishou.service.debug.passive_protocol.client_operations;

import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.service.debug.passive_protocol.ClientOperation;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ExceptionOperation.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/service/debug/passive_protocol/client_operations/ExceptionOperation;", "Lcom/magneticchen/daijishou/service/debug/passive_protocol/ClientOperation;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "headerByteCode", "", "getHeaderByteCode", "()B", "isMainActivityRequired", "", "()Z", "handleDataStreams", "", "dataInputStream", "Ljava/io/DataInputStream;", "dataOutputStream", "Ljava/io/DataOutputStream;", "(Ljava/io/DataInputStream;Ljava/io/DataOutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ExceptionOperation extends ClientOperation {
    private final byte headerByteCode;
    private final boolean isMainActivityRequired;

    /* JADX INFO: renamed from: com.magneticchen.daijishou.service.debug.passive_protocol.client_operations.ExceptionOperation$handleDataStreams$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExceptionOperation.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.service.debug.passive_protocol.client_operations.ExceptionOperation", f = "ExceptionOperation.kt", i = {}, l = {33}, m = "handleDataStreams", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExceptionOperation.this.handleDataStreams(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExceptionOperation(DaijishouApplication application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.isMainActivityRequired = true;
        this.headerByteCode = (byte) 1;
    }

    @Override // com.magneticchen.daijishou.service.debug.passive_protocol.ClientOperation
    public boolean isMainActivityRequired() {
        return this.isMainActivityRequired;
    }

    @Override // com.magneticchen.daijishou.service.debug.passive_protocol.ClientOperation
    public byte getHeaderByteCode() {
        return this.headerByteCode;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.service.debug.passive_protocol.client_operations.ExceptionOperation$handleDataStreams$2, reason: invalid class name */
    /* JADX INFO: compiled from: ExceptionOperation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.service.debug.passive_protocol.client_operations.ExceptionOperation$handleDataStreams$2", f = "ExceptionOperation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ DataInputStream $dataInputStream;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DataInputStream dataInputStream, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$dataInputStream = dataInputStream;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$dataInputStream, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            byte[] bArr = new byte[this.$dataInputStream.readByte()];
            this.$dataInputStream.read(bArr);
            throw new Exception("ExceptionOperation: " + StringsKt.decodeToString(bArr));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.magneticchen.daijishou.service.debug.passive_protocol.ClientOperation
    public Object handleDataStreams(DataInputStream dataInputStream, DataOutputStream dataOutputStream, Continuation<? super Unit> continuation) {
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
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineContext io2 = Dispatchers.getIO();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(dataInputStream, null);
            anonymousClass1.label = 1;
            if (BuildersKt.withContext(io2, anonymousClass2, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
