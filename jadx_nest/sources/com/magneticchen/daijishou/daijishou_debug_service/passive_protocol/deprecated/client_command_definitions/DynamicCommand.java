package com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated.client_command_definitions;

import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.ClientOperation;
import com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated.ClientCommandDefinition;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DynamicCommand.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016R\u0014\u0010\n\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/deprecated/client_command_definitions/DynamicCommand;", "Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/deprecated/ClientCommandDefinition;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "operationCodeToInstanceHashMap", "Ljava/util/HashMap;", "", "Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/ClientOperation;", "Lkotlin/collections/HashMap;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/util/HashMap;)V", "headerByteCode", "getHeaderByteCode", "()B", "isMainActivityRequired", "", "()Z", "handleDataStreams", "", "dataInputStream", "Ljava/io/DataInputStream;", "dataOutputStream", "Ljava/io/DataOutputStream;", "(Ljava/io/DataInputStream;Ljava/io/DataOutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DynamicCommand extends ClientCommandDefinition {
    private final byte headerByteCode;
    private final boolean isMainActivityRequired;
    private final HashMap<Byte, ClientOperation> operationCodeToInstanceHashMap;

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated.client_command_definitions.DynamicCommand$handleDataStreams$1, reason: invalid class name */
    /* JADX INFO: compiled from: DynamicCommand.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated.client_command_definitions.DynamicCommand", f = "DynamicCommand.kt", i = {0, 0}, l = {47}, m = "handleDataStreams", n = {"dataInputStream", "dataOutputStream"}, s = {"L$0", "L$1"})
    final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj)throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DynamicCommand.this.handleDataStreams(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicCommand(DaijishouApplication application, HashMap<Byte, ClientOperation> operationCodeToInstanceHashMap) {
        super(application, operationCodeToInstanceHashMap);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(operationCodeToInstanceHashMap, "operationCodeToInstanceHashMap");
        this.operationCodeToInstanceHashMap = operationCodeToInstanceHashMap;
        this.headerByteCode = (byte) 2;
        this.isMainActivityRequired = true;
    }

    private static byte readByteSneaky(DataInputStream dataInputStream) {
        try {
            return dataInputStream.readByte();
        } catch (java.io.IOException e) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(e);
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated.ClientCommandDefinition
    public byte getHeaderByteCode() {
        return this.headerByteCode;
    }


    /* JADX INFO: renamed from: isMainActivityRequired, reason: from getter */
    public boolean isMainActivityRequired() {
        return this.isMainActivityRequired;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated.ClientCommandDefinition
    public Object handleDataStreams(DataInputStream dataInputStream, DataOutputStream dataOutputStream, Continuation<?> continuation) {
        AnonymousClass1 anonymousClass1;
        DataInputStream dataInputStream2;
        Iterator it;
        DataOutputStream dataOutputStream2;
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
            IntRange intRangeUntil = RangesKt.until(0, (int) readByteSneaky(dataInputStream));
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it2 = intRangeUntil.iterator();
            while (it2.hasNext()) {
                ((IntIterator) it2).nextInt();
                ClientOperation clientOperation = this.operationCodeToInstanceHashMap.get(Boxing.boxByte(readByteSneaky(dataInputStream)));
                Intrinsics.checkNotNull(clientOperation);
                arrayList.add(clientOperation);
            }
            dataInputStream2 = dataInputStream;
            it = arrayList.iterator();
            dataOutputStream2 = dataOutputStream;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) anonymousClass1.L$2;
            DataOutputStream dataOutputStream3 = (DataOutputStream) anonymousClass1.L$1;
            DataInputStream dataInputStream3 = (DataInputStream) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            dataOutputStream2 = dataOutputStream3;
            dataInputStream2 = dataInputStream3;
        }
        while (it.hasNext()) {
            ClientOperation clientOperation2 = (ClientOperation) it.next();
            byte b = readByteSneaky(dataInputStream2);
            if (b != clientOperation2.getHeaderByteCode()) {
                throw new IllegalStateException("Header does not match.");
            }
            if (b == ClientCommandDefinition.INSTANCE.getCOMMAND_END_BYTE_CODE()) {
                return Unit.INSTANCE;
            }
            anonymousClass1.L$0 = dataInputStream2;
            anonymousClass1.L$1 = dataOutputStream2;
            anonymousClass1.L$2 = it;
            anonymousClass1.label = 1;
            if (clientOperation2.handleDataStreams(dataInputStream2, dataOutputStream2, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
