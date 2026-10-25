package com.magneticchen.daijishou.daijishou_library_db.portables;

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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: PlatformThumbnailsPacksIndexJson.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B3\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPacksIndexJson;", "", "seen1", "", "baseUri", "", "platformThumbnailsPackList", "", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/util/List;)V", "getBaseUri", "()Ljava/lang/String;", "getPlatformThumbnailsPackList", "()Ljava/util/List;", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final /* data */ class PlatformThumbnailsPacksIndexJson {
    private final String baseUri;
    private final List<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson> platformThumbnailsPackList;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final KSerializer[] $childSerializers = {null, new ArrayListSerializer(PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson$$serializer.INSTANCE)};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlatformThumbnailsPacksIndexJson copy$default(PlatformThumbnailsPacksIndexJson platformThumbnailsPacksIndexJson, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = platformThumbnailsPacksIndexJson.baseUri;
        }
        if ((i & 2) != 0) {
            list = platformThumbnailsPacksIndexJson.platformThumbnailsPackList;
        }
        return platformThumbnailsPacksIndexJson.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBaseUri() {
        return this.baseUri;
    }

    public final List<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson> component2() {
        return this.platformThumbnailsPackList;
    }

    public final PlatformThumbnailsPacksIndexJson copy(String baseUri, List<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson> platformThumbnailsPackList) {
        Intrinsics.checkNotNullParameter(baseUri, "baseUri");
        Intrinsics.checkNotNullParameter(platformThumbnailsPackList, "platformThumbnailsPackList");
        return new PlatformThumbnailsPacksIndexJson(baseUri, platformThumbnailsPackList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlatformThumbnailsPacksIndexJson)) {
            return false;
        }
        PlatformThumbnailsPacksIndexJson platformThumbnailsPacksIndexJson = (PlatformThumbnailsPacksIndexJson) other;
        return Intrinsics.areEqual(this.baseUri, platformThumbnailsPacksIndexJson.baseUri) && Intrinsics.areEqual(this.platformThumbnailsPackList, platformThumbnailsPacksIndexJson.platformThumbnailsPackList);
    }

    public int hashCode() {
        return (this.baseUri.hashCode() * 31) + this.platformThumbnailsPackList.hashCode();
    }

    public String toString() {
        return "PlatformThumbnailsPacksIndexJson(baseUri=" + this.baseUri + ", platformThumbnailsPackList=" + this.platformThumbnailsPackList + ")";
    }

    /* JADX INFO: compiled from: PlatformThumbnailsPacksIndexJson.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPacksIndexJson$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPacksIndexJson;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlatformThumbnailsPacksIndexJson> serializer() {
            return PlatformThumbnailsPacksIndexJson$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PlatformThumbnailsPacksIndexJson(int i, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, PlatformThumbnailsPacksIndexJson$$serializer.INSTANCE.getDescriptor());
        }
        this.baseUri = str;
        this.platformThumbnailsPackList = list;
    }

    public PlatformThumbnailsPacksIndexJson(String baseUri, List<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson> platformThumbnailsPackList) {
        Intrinsics.checkNotNullParameter(baseUri, "baseUri");
        Intrinsics.checkNotNullParameter(platformThumbnailsPackList, "platformThumbnailsPackList");
        this.baseUri = baseUri;
        this.platformThumbnailsPackList = platformThumbnailsPackList;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(PlatformThumbnailsPacksIndexJson self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.baseUri);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.platformThumbnailsPackList);
    }


    public final List<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson> getPlatformThumbnailsPackList() {
        return this.platformThumbnailsPackList;
    }
}
