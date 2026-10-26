package com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.deprecated;

import com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.ClientOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

/* INFO: compiled from: StaticClientCommandDefinition.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/magneticchen/daijishou/daijishou_debug_service/passive_protocol/ClientOperation;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class StaticClientCommandDefinition$operationInstances$2 extends Lambda<List<? extends ClientOperation>> implements Function0<List<? extends ClientOperation>> {
    final /* synthetic */ HashMap<Byte, ClientOperation> $operationCodeToInstanceHashMap;
    final /* synthetic */ StaticClientCommandDefinition this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    StaticClientCommandDefinition$operationInstances$2(StaticClientCommandDefinition staticClientCommandDefinition, HashMap<Byte, ClientOperation> map) {
        super(0);
        this.this$0 = staticClientCommandDefinition;
        this.$operationCodeToInstanceHashMap = map;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends ClientOperation> invoke() {
        IntRange indices = CollectionsKt.getIndices(this.this$0.getDefinedOperations());
        HashMap<Byte, ClientOperation> map = this.$operationCodeToInstanceHashMap;
        StaticClientCommandDefinition staticClientCommandDefinition = this.this$0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(indices, 10));
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            ClientOperation clientOperation = map.get(staticClientCommandDefinition.getDefinedOperations().get(((IntIterator) it).nextInt()));
            Intrinsics.checkNotNull(clientOperation);
            arrayList.add(clientOperation);
        }
        return arrayList;
    }
}
