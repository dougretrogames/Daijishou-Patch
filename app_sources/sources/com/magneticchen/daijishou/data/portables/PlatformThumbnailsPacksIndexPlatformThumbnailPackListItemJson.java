package com.magneticchen.daijishou.data.portables;

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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.BY\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB=\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0010J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JK\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001J&\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+HÁ\u0001¢\u0006\u0002\b,R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014¨\u0006/"}, d2 = {"Lcom/magneticchen/daijishou/data/portables/PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson;", "", "seen1", "", "platformThumbnailsPackAuthors", "", "", "platformThumbnailsPackName", "platformThumbnailsPackRootPath", "platformThumbnailsPackPreviewThumbnailPath", "platformThumbnailsPackDescription", "platformThumbnailsPackIsNSFW", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getPlatformThumbnailsPackAuthors", "()Ljava/util/List;", "getPlatformThumbnailsPackDescription", "()Ljava/lang/String;", "getPlatformThumbnailsPackIsNSFW", "()Z", "getPlatformThumbnailsPackName", "getPlatformThumbnailsPackPreviewThumbnailPath", "getPlatformThumbnailsPackRootPath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final class PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson {
    private final List<String> platformThumbnailsPackAuthors;
    private final String platformThumbnailsPackDescription;
    private final boolean platformThumbnailsPackIsNSFW;
    private final String platformThumbnailsPackName;
    private final String platformThumbnailsPackPreviewThumbnailPath;
    private final String platformThumbnailsPackRootPath;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, null};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson copy$default(PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson, List list, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackAuthors;
        }
        if ((i & 2) != 0) {
            str = platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackName;
        }
        if ((i & 4) != 0) {
            str2 = platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackRootPath;
        }
        if ((i & 8) != 0) {
            str3 = platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackPreviewThumbnailPath;
        }
        if ((i & 16) != 0) {
            str4 = platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackDescription;
        }
        if ((i & 32) != 0) {
            z = platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackIsNSFW;
        }
        String str5 = str4;
        boolean z2 = z;
        return platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.copy(list, str, str2, str3, str5, z2);
    }

    public final List<String> component1() {
        return this.platformThumbnailsPackAuthors;
    }

    public final String component2() {
        return this.platformThumbnailsPackName;
    }

    public final String component3() {
        return this.platformThumbnailsPackRootPath;
    }

    public final String component4() {
        return this.platformThumbnailsPackPreviewThumbnailPath;
    }

    public final String component5() {
        return this.platformThumbnailsPackDescription;
    }

    public final boolean component6() {
        return this.platformThumbnailsPackIsNSFW;
    }

    public final PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson copy(List<String> platformThumbnailsPackAuthors, String platformThumbnailsPackName, String platformThumbnailsPackRootPath, String platformThumbnailsPackPreviewThumbnailPath, String platformThumbnailsPackDescription, boolean z) {
        Intrinsics.checkNotNullParameter(platformThumbnailsPackAuthors, "platformThumbnailsPackAuthors");
        Intrinsics.checkNotNullParameter(platformThumbnailsPackName, "platformThumbnailsPackName");
        Intrinsics.checkNotNullParameter(platformThumbnailsPackRootPath, "platformThumbnailsPackRootPath");
        Intrinsics.checkNotNullParameter(platformThumbnailsPackPreviewThumbnailPath, "platformThumbnailsPackPreviewThumbnailPath");
        Intrinsics.checkNotNullParameter(platformThumbnailsPackDescription, "platformThumbnailsPackDescription");
        return new PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson(platformThumbnailsPackAuthors, platformThumbnailsPackName, platformThumbnailsPackRootPath, platformThumbnailsPackPreviewThumbnailPath, platformThumbnailsPackDescription, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson)) {
            return false;
        }
        PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson = (PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson) obj;
        return Intrinsics.areEqual(this.platformThumbnailsPackAuthors, platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackAuthors) && Intrinsics.areEqual(this.platformThumbnailsPackName, platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackName) && Intrinsics.areEqual(this.platformThumbnailsPackRootPath, platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackRootPath) && Intrinsics.areEqual(this.platformThumbnailsPackPreviewThumbnailPath, platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackPreviewThumbnailPath) && Intrinsics.areEqual(this.platformThumbnailsPackDescription, platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackDescription) && this.platformThumbnailsPackIsNSFW == platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackIsNSFW;
    }

    public int hashCode() {
        return (((((((((this.platformThumbnailsPackAuthors.hashCode() * 31) + this.platformThumbnailsPackName.hashCode()) * 31) + this.platformThumbnailsPackRootPath.hashCode()) * 31) + this.platformThumbnailsPackPreviewThumbnailPath.hashCode()) * 31) + this.platformThumbnailsPackDescription.hashCode()) * 31) + Boolean.hashCode(this.platformThumbnailsPackIsNSFW);
    }

    public String toString() {
        return "PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson(platformThumbnailsPackAuthors=" + this.platformThumbnailsPackAuthors + ", platformThumbnailsPackName=" + this.platformThumbnailsPackName + ", platformThumbnailsPackRootPath=" + this.platformThumbnailsPackRootPath + ", platformThumbnailsPackPreviewThumbnailPath=" + this.platformThumbnailsPackPreviewThumbnailPath + ", platformThumbnailsPackDescription=" + this.platformThumbnailsPackDescription + ", platformThumbnailsPackIsNSFW=" + this.platformThumbnailsPackIsNSFW + ")";
    }

    /* JADX INFO: compiled from: PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/data/portables/PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/data/portables/PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson> serializer() {
            return PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson(int i, List list, String str, String str2, String str3, String str4, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson$$serializer.INSTANCE.getDescriptor());
        }
        this.platformThumbnailsPackAuthors = list;
        this.platformThumbnailsPackName = str;
        this.platformThumbnailsPackRootPath = str2;
        this.platformThumbnailsPackPreviewThumbnailPath = str3;
        this.platformThumbnailsPackDescription = str4;
        if ((i & 32) == 0) {
            this.platformThumbnailsPackIsNSFW = false;
        } else {
            this.platformThumbnailsPackIsNSFW = z;
        }
    }

    public PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson(List<String> platformThumbnailsPackAuthors, String platformThumbnailsPackName, String platformThumbnailsPackRootPath, String platformThumbnailsPackPreviewThumbnailPath, String platformThumbnailsPackDescription, boolean z) {
        Intrinsics.checkNotNullParameter(platformThumbnailsPackAuthors, "platformThumbnailsPackAuthors");
        Intrinsics.checkNotNullParameter(platformThumbnailsPackName, "platformThumbnailsPackName");
        Intrinsics.checkNotNullParameter(platformThumbnailsPackRootPath, "platformThumbnailsPackRootPath");
        Intrinsics.checkNotNullParameter(platformThumbnailsPackPreviewThumbnailPath, "platformThumbnailsPackPreviewThumbnailPath");
        Intrinsics.checkNotNullParameter(platformThumbnailsPackDescription, "platformThumbnailsPackDescription");
        this.platformThumbnailsPackAuthors = platformThumbnailsPackAuthors;
        this.platformThumbnailsPackName = platformThumbnailsPackName;
        this.platformThumbnailsPackRootPath = platformThumbnailsPackRootPath;
        this.platformThumbnailsPackPreviewThumbnailPath = platformThumbnailsPackPreviewThumbnailPath;
        this.platformThumbnailsPackDescription = platformThumbnailsPackDescription;
        this.platformThumbnailsPackIsNSFW = z;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, $childSerializers[0], platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackAuthors);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackName);
        compositeEncoder.encodeStringElement(serialDescriptor, 2, platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackRootPath);
        compositeEncoder.encodeStringElement(serialDescriptor, 3, platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackPreviewThumbnailPath);
        compositeEncoder.encodeStringElement(serialDescriptor, 4, platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackDescription);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackIsNSFW) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 5, platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.platformThumbnailsPackIsNSFW);
        }
    }

    public /* synthetic */ PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson(List list, String str, String str2, String str3, String str4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, str2, str3, str4, (i & 32) != 0 ? false : z);
    }

    public final List<String> getPlatformThumbnailsPackAuthors() {
        return this.platformThumbnailsPackAuthors;
    }

    public final String getPlatformThumbnailsPackName() {
        return this.platformThumbnailsPackName;
    }

    public final String getPlatformThumbnailsPackRootPath() {
        return this.platformThumbnailsPackRootPath;
    }

    public final String getPlatformThumbnailsPackPreviewThumbnailPath() {
        return this.platformThumbnailsPackPreviewThumbnailPath;
    }

    public final String getPlatformThumbnailsPackDescription() {
        return this.platformThumbnailsPackDescription;
    }

    public final boolean getPlatformThumbnailsPackIsNSFW() {
        return this.platformThumbnailsPackIsNSFW;
    }
}
