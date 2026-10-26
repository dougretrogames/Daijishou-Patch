package com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated;

import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.ClientOperation;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: ClientCommandDefinition.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H¦@¢\u0006\u0002\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/deprecated/ClientCommandDefinition;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "operationCodeToInstanceHashMap", "Ljava/util/HashMap;", "", "Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/ClientOperation;", "Lkotlin/collections/HashMap;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/util/HashMap;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "headerByteCode", "getHeaderByteCode", "()B", "isMainActivityRequired", "", "()Z", "handleDataStreams", "", "dataInputStream", "Ljava/io/DataInputStream;", "dataOutputStream", "Ljava/io/DataOutputStream;", "(Ljava/io/DataInputStream;Ljava/io/DataOutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ClientCommandDefinition {
    private final DaijishouApplication application;

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int COMMAND_END_BYTE_CODE = 255;

    public abstract byte getHeaderByteCode();

    public abstract Object handleDataStreams(DataInputStream dataInputStream, DataOutputStream dataOutputStream, Continuation<?> continuation);

    public abstract boolean isMainActivityRequired();

    /* INFO: compiled from: ClientCommandDefinition.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/deprecated/ClientCommandDefinition$Companion;", "", "()V", "COMMAND_END_BYTE_CODE", "", "getCOMMAND_END_BYTE_CODE", "()I", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getCOMMAND_END_BYTE_CODE() {
            return ClientCommandDefinition.COMMAND_END_BYTE_CODE;
        }
    }

    public ClientCommandDefinition(DaijishouApplication application, HashMap<Byte, ClientOperation> operationCodeToInstanceHashMap) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(operationCodeToInstanceHashMap, "operationCodeToInstanceHashMap");
        this.application = application;
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }
}
