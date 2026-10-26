package com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated;

import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.ClientOperation;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: StaticClientCommandDefinition.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u001fR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0011\u0010\u0013R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0017\u0010\r¨\u0006 "}, d2 = {"Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/deprecated/StaticClientCommandDefinition;", "Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/deprecated/ClientCommandDefinition;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "operationCodeToInstanceHashMap", "Ljava/util/HashMap;", "", "Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/ClientOperation;", "Lkotlin/collections/HashMap;", "(Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/util/HashMap;)V", "definedOperations", "", "getDefinedOperations", "()Ljava/util/List;", "headerByteCode", "getHeaderByteCode", "()B", "isMainActivityRequired", "", "()Z", "isMainActivityRequired$delegate", "Lkotlin/Lazy;", "operationInstances", "getOperationInstances", "operationInstances$delegate", "handleDataStreams", "", "dataInputStream", "Ljava/io/DataInputStream;", "dataOutputStream", "Ljava/io/DataOutputStream;", "(Ljava/io/DataInputStream;Ljava/io/DataOutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class StaticClientCommandDefinition extends ClientCommandDefinition {

    /* INFO: renamed from: isMainActivityRequired$delegate, reason: from kotlin metadata */
    private final Lazy isMainActivityRequired;

    /* INFO: renamed from: operationInstances$delegate, reason: from kotlin metadata */
    private final Lazy operationInstances;

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated.StaticClientCommandDefinition$handleDataStreams$1, reason: invalid class name */
    /* INFO: compiled from: StaticClientCommandDefinition.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated.StaticClientCommandDefinition", f = "StaticClientCommandDefinition.kt", i = {0, 0}, l = {51}, m = "handleDataStreams$suspendImpl", n = {"dataInputStream", "dataOutputStream"}, s = {"L$0", "L$1"})
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
            return StaticClientCommandDefinition.handleDataStreams$suspendImpl(StaticClientCommandDefinition.this, null, null, this);
        }
    }

    public abstract List<Byte> getDefinedOperations();

    @Override // com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated.ClientCommandDefinition
    public abstract byte getHeaderByteCode();

    @Override // com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated.ClientCommandDefinition
    public Object handleDataStreams(DataInputStream dataInputStream, DataOutputStream dataOutputStream, Continuation<?> continuation) {
        try {
            return handleDataStreams$suspendImpl(this, dataInputStream, dataOutputStream, continuation);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticClientCommandDefinition(DaijishouApplication application, HashMap<Byte, ClientOperation> operationCodeToInstanceHashMap) {
        super(application, operationCodeToInstanceHashMap);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(operationCodeToInstanceHashMap, "operationCodeToInstanceHashMap");
        this.isMainActivityRequired = LazyKt.lazy(new AnonymousClass2());
        this.operationInstances = LazyKt.lazy(new StaticClientCommandDefinition$operationInstances$2(this, operationCodeToInstanceHashMap));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated.StaticClientCommandDefinition$isMainActivityRequired$2, reason: invalid class name */
    /* INFO: compiled from: StaticClientCommandDefinition.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda<Boolean> implements Function0<Boolean> {
        AnonymousClass2() {
            super(0);
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            List<ClientOperation> operationInstances = StaticClientCommandDefinition.this.getOperationInstances();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(operationInstances, 10));
            Iterator it = operationInstances.iterator();
            while (it.hasNext()) {
                if (((ClientOperation) it.next()).getIsMainActivityRequired()) {
                    return true;
                }
                arrayList.add(Unit.INSTANCE);
            }
            return false;
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated.ClientCommandDefinition
    public boolean isMainActivityRequired() {
        return ((Boolean) this.isMainActivityRequired.getValue()).booleanValue();
    }

    public final List<ClientOperation> getOperationInstances() {
        return (List) this.operationInstances.getValue();
    }

    /* WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object handleDataStreams$suspendImpl(StaticClientCommandDefinition staticClientCommandDefinition, DataInputStream dataInputStream, DataOutputStream dataOutputStream, Continuation<?> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Iterator it;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = staticClientCommandDefinition.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = staticClientCommandDefinition.new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            it = staticClientCommandDefinition.getOperationInstances().iterator();
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) anonymousClass1.L$2;
            DataOutputStream dataOutputStream2 = (DataOutputStream) anonymousClass1.L$1;
            DataInputStream dataInputStream2 = (DataInputStream) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            dataOutputStream = dataOutputStream2;
            dataInputStream = dataInputStream2;
        }
        while (it.hasNext()) {
            ClientOperation clientOperation = (ClientOperation) it.next();
            if (dataInputStream.readByte() != clientOperation.getHeaderByteCode()) {
                throw new IllegalStateException("Header does not match.");
            }
            anonymousClass1.L$0 = dataInputStream;
            anonymousClass1.L$1 = dataOutputStream;
            anonymousClass1.L$2 = it;
            anonymousClass1.label = 1;
            if (clientOperation.handleDataStreams(dataInputStream, dataOutputStream, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
