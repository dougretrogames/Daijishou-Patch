package com.magneticchen.daijishou.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: AppsStateJson.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'Ba\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eBK\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012$\b\u0002\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003JO\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052$\b\u0002\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R-\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/magneticchen/daijishou/data/AppsStateJson;", "", "seen1", "", "resolveInfoFlagAsGameStringIds", "", "", "resolveInfoFlagAsNotGameStringIds", "resolveInfoStringIdToLastOpenedTimestamp", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/util/HashMap;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/util/List;Ljava/util/HashMap;)V", "getResolveInfoFlagAsGameStringIds", "()Ljava/util/List;", "getResolveInfoFlagAsNotGameStringIds", "getResolveInfoStringIdToLastOpenedTimestamp", "()Ljava/util/HashMap;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final class AppsStateJson {
    private final List<String> resolveInfoFlagAsGameStringIds;
    private final List<String> resolveInfoFlagAsNotGameStringIds;
    private final HashMap<String, Long> resolveInfoStringIdToLastOpenedTimestamp;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE), new ArrayListSerializer(StringSerializer.INSTANCE), new HashMapSerializer(StringSerializer.INSTANCE, LongSerializer.INSTANCE)};

    public AppsStateJson() {
        this((List) null, (List) null, (HashMap) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppsStateJson copy$default(AppsStateJson appsStateJson, List list, List list2, HashMap map, int i, Object obj) {
        if ((i & 1) != 0) {
            list = appsStateJson.resolveInfoFlagAsGameStringIds;
        }
        if ((i & 2) != 0) {
            list2 = appsStateJson.resolveInfoFlagAsNotGameStringIds;
        }
        if ((i & 4) != 0) {
            map = appsStateJson.resolveInfoStringIdToLastOpenedTimestamp;
        }
        return appsStateJson.copy(list, list2, map);
    }

    public final List<String> component1() {
        return this.resolveInfoFlagAsGameStringIds;
    }

    public final List<String> component2() {
        return this.resolveInfoFlagAsNotGameStringIds;
    }

    public final HashMap<String, Long> component3() {
        return this.resolveInfoStringIdToLastOpenedTimestamp;
    }

    public final AppsStateJson copy(List<String> resolveInfoFlagAsGameStringIds, List<String> resolveInfoFlagAsNotGameStringIds, HashMap<String, Long> resolveInfoStringIdToLastOpenedTimestamp) {
        Intrinsics.checkNotNullParameter(resolveInfoFlagAsGameStringIds, "resolveInfoFlagAsGameStringIds");
        Intrinsics.checkNotNullParameter(resolveInfoFlagAsNotGameStringIds, "resolveInfoFlagAsNotGameStringIds");
        Intrinsics.checkNotNullParameter(resolveInfoStringIdToLastOpenedTimestamp, "resolveInfoStringIdToLastOpenedTimestamp");
        return new AppsStateJson(resolveInfoFlagAsGameStringIds, resolveInfoFlagAsNotGameStringIds, resolveInfoStringIdToLastOpenedTimestamp);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppsStateJson)) {
            return false;
        }
        AppsStateJson appsStateJson = (AppsStateJson) obj;
        return Intrinsics.areEqual(this.resolveInfoFlagAsGameStringIds, appsStateJson.resolveInfoFlagAsGameStringIds) && Intrinsics.areEqual(this.resolveInfoFlagAsNotGameStringIds, appsStateJson.resolveInfoFlagAsNotGameStringIds) && Intrinsics.areEqual(this.resolveInfoStringIdToLastOpenedTimestamp, appsStateJson.resolveInfoStringIdToLastOpenedTimestamp);
    }

    public int hashCode() {
        return (((this.resolveInfoFlagAsGameStringIds.hashCode() * 31) + this.resolveInfoFlagAsNotGameStringIds.hashCode()) * 31) + this.resolveInfoStringIdToLastOpenedTimestamp.hashCode();
    }

    public String toString() {
        return "AppsStateJson(resolveInfoFlagAsGameStringIds=" + this.resolveInfoFlagAsGameStringIds + ", resolveInfoFlagAsNotGameStringIds=" + this.resolveInfoFlagAsNotGameStringIds + ", resolveInfoStringIdToLastOpenedTimestamp=" + this.resolveInfoStringIdToLastOpenedTimestamp + ")";
    }

    /* JADX INFO: compiled from: AppsStateJson.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/data/AppsStateJson$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/data/AppsStateJson;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AppsStateJson> serializer() {
            return AppsStateJson$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ AppsStateJson(int i, ArrayList arrayList, List list, HashMap map, SerializationConstructorMarker serializationConstructorMarker) {
        this.resolveInfoFlagAsGameStringIds = (i & 1) == 0 ? new ArrayList() : arrayList;
        if ((i & 2) == 0) {
            this.resolveInfoFlagAsNotGameStringIds = new ArrayList();
        } else {
            this.resolveInfoFlagAsNotGameStringIds = list;
        }
        if ((i & 4) == 0) {
            this.resolveInfoStringIdToLastOpenedTimestamp = new HashMap<>();
        } else {
            this.resolveInfoStringIdToLastOpenedTimestamp = map;
        }
    }

    public AppsStateJson(List<String> resolveInfoFlagAsGameStringIds, List<String> resolveInfoFlagAsNotGameStringIds, HashMap<String, Long> resolveInfoStringIdToLastOpenedTimestamp) {
        Intrinsics.checkNotNullParameter(resolveInfoFlagAsGameStringIds, "resolveInfoFlagAsGameStringIds");
        Intrinsics.checkNotNullParameter(resolveInfoFlagAsNotGameStringIds, "resolveInfoFlagAsNotGameStringIds");
        Intrinsics.checkNotNullParameter(resolveInfoStringIdToLastOpenedTimestamp, "resolveInfoStringIdToLastOpenedTimestamp");
        this.resolveInfoFlagAsGameStringIds = resolveInfoFlagAsGameStringIds;
        this.resolveInfoFlagAsNotGameStringIds = resolveInfoFlagAsNotGameStringIds;
        this.resolveInfoStringIdToLastOpenedTimestamp = resolveInfoStringIdToLastOpenedTimestamp;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(AppsStateJson appsStateJson, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || !Intrinsics.areEqual(appsStateJson.resolveInfoFlagAsGameStringIds, new ArrayList())) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 0, serializationStrategyArr[0], appsStateJson.resolveInfoFlagAsGameStringIds);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || !Intrinsics.areEqual(appsStateJson.resolveInfoFlagAsNotGameStringIds, new ArrayList())) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 1, serializationStrategyArr[1], appsStateJson.resolveInfoFlagAsNotGameStringIds);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) && Intrinsics.areEqual(appsStateJson.resolveInfoStringIdToLastOpenedTimestamp, new HashMap())) {
            return;
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, serializationStrategyArr[2], appsStateJson.resolveInfoStringIdToLastOpenedTimestamp);
    }

    public /* synthetic */ AppsStateJson(ArrayList arrayList, ArrayList arrayList2, HashMap map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? new ArrayList() : arrayList2, (i & 4) != 0 ? new HashMap() : map);
    }

    public final List<String> getResolveInfoFlagAsGameStringIds() {
        return this.resolveInfoFlagAsGameStringIds;
    }

    public final List<String> getResolveInfoFlagAsNotGameStringIds() {
        return this.resolveInfoFlagAsNotGameStringIds;
    }

    public final HashMap<String, Long> getResolveInfoStringIdToLastOpenedTimestamp() {
        return this.resolveInfoStringIdToLastOpenedTimestamp;
    }
}
