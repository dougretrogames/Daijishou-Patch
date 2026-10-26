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

/* INFO: compiled from: PlatformsIndexJson.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B3\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformsIndexJson;", "", "seen1", "", "baseUri", "", "platformList", "", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformsIndexPlatformListItemJson;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/util/List;)V", "getBaseUri", "()Ljava/lang/String;", "getPlatformList", "()Ljava/util/List;", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final /* data */ class PlatformsIndexJson {
    private final String baseUri;
    private final List<PlatformsIndexPlatformListItemJson> platformList;

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final KSerializer[] $childSerializers = {null, new ArrayListSerializer(PlatformsIndexPlatformListItemJson$$serializer.INSTANCE)};

    /* WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlatformsIndexJson copy$default(PlatformsIndexJson platformsIndexJson, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = platformsIndexJson.baseUri;
        }
        if ((i & 2) != 0) {
            list = platformsIndexJson.platformList;
        }
        return platformsIndexJson.copy(str, list);
    }

    /* INFO: renamed from: component1, reason: from getter */
    public final String getBaseUri() {
        return this.baseUri;
    }

    public final List<PlatformsIndexPlatformListItemJson> component2() {
        return this.platformList;
    }

    public final PlatformsIndexJson copy(String baseUri, List<PlatformsIndexPlatformListItemJson> platformList) {
        Intrinsics.checkNotNullParameter(baseUri, "baseUri");
        Intrinsics.checkNotNullParameter(platformList, "platformList");
        return new PlatformsIndexJson(baseUri, platformList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlatformsIndexJson)) {
            return false;
        }
        PlatformsIndexJson platformsIndexJson = (PlatformsIndexJson) other;
        return Intrinsics.areEqual(this.baseUri, platformsIndexJson.baseUri) && Intrinsics.areEqual(this.platformList, platformsIndexJson.platformList);
    }

    public int hashCode() {
        return (this.baseUri.hashCode() * 31) + this.platformList.hashCode();
    }

    public String toString() {
        return "PlatformsIndexJson(baseUri=" + this.baseUri + ", platformList=" + this.platformList + ")";
    }

    /* INFO: compiled from: PlatformsIndexJson.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformsIndexJson$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformsIndexJson;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlatformsIndexJson> serializer() {
            return PlatformsIndexJson$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PlatformsIndexJson(int i, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, PlatformsIndexJson$$serializer.INSTANCE.getDescriptor());
        }
        this.baseUri = str;
        this.platformList = list;
    }

    public PlatformsIndexJson(String baseUri, List<PlatformsIndexPlatformListItemJson> platformList) {
        Intrinsics.checkNotNullParameter(baseUri, "baseUri");
        Intrinsics.checkNotNullParameter(platformList, "platformList");
        this.baseUri = baseUri;
        this.platformList = platformList;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(PlatformsIndexJson self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.baseUri);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.platformList);
    }


    public final List<PlatformsIndexPlatformListItemJson> getPlatformList() {
        return this.platformList;
    }
}
