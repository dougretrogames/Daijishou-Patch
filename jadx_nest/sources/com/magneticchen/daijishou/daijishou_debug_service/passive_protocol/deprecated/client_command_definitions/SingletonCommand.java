package com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated.client_command_definitions;

import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.ClientOperation;
import com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated.ClientCommandDefinition;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SingletonCommand.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016R\u0014\u0010\n\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/deprecated/client_command_definitions/SingletonCommand;", "Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/deprecated/ClientCommandDefinition;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "operationCodeToInstanceHashMap", "Ljava/util/HashMap;", "", "Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/ClientOperation;", "Lkotlin/collections/HashMap;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/util/HashMap;)V", "headerByteCode", "getHeaderByteCode", "()B", "isMainActivityRequired", "", "()Z", "handleDataStreams", "", "dataInputStream", "Ljava/io/DataInputStream;", "dataOutputStream", "Ljava/io/DataOutputStream;", "(Ljava/io/DataInputStream;Ljava/io/DataOutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SingletonCommand extends ClientCommandDefinition {
    private final byte headerByteCode;
    private final boolean isMainActivityRequired;
    private final HashMap<Byte, ClientOperation> operationCodeToInstanceHashMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingletonCommand(DaijishouApplication application, HashMap<Byte, ClientOperation> operationCodeToInstanceHashMap) {
        super(application, operationCodeToInstanceHashMap);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(operationCodeToInstanceHashMap, "operationCodeToInstanceHashMap");
        this.operationCodeToInstanceHashMap = operationCodeToInstanceHashMap;
        this.headerByteCode = (byte) 1;
        this.isMainActivityRequired = true;
    }

    @Override // com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated.ClientCommandDefinition
    public byte getHeaderByteCode() {
        return this.headerByteCode;
    }


    /* JADX INFO: renamed from: isMainActivityRequired, reason: from getter */
    public boolean isMainActivityRequired() {
        return this.isMainActivityRequired;
    }

    @Override // com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated.ClientCommandDefinition
    public Object handleDataStreams(DataInputStream dataInputStream, DataOutputStream dataOutputStream, Continuation<?> continuation) {
        byte b;
        try {
            b = dataInputStream.readByte();
        } catch (java.io.IOException e) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(e);
        }
        ClientOperation clientOperation = this.operationCodeToInstanceHashMap.get(Boxing.boxByte(b));
        Intrinsics.checkNotNull(clientOperation);
        Object objHandleDataStreams = clientOperation.handleDataStreams(dataInputStream, dataOutputStream, continuation);
        return objHandleDataStreams == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objHandleDataStreams : Unit.INSTANCE;
    }
}
