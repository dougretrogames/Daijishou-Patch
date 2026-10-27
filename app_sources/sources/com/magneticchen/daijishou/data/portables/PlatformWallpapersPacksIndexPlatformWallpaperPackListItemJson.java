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

/* JADX INFO: compiled from: PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.BY\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB=\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0010J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JK\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001J&\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+HÁ\u0001¢\u0006\u0002\b,R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014¨\u0006/"}, d2 = {"Lcom/magneticchen/daijishou/data/portables/PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson;", "", "seen1", "", "platformWallpapersPackAuthors", "", "", "platformWallpapersPackName", "platformWallpapersPackRootPath", "platformWallpapersPackPreviewThumbnailPath", "platformWallpapersPackDescription", "platformWallpapersPackIsNSFW", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getPlatformWallpapersPackAuthors", "()Ljava/util/List;", "getPlatformWallpapersPackDescription", "()Ljava/lang/String;", "getPlatformWallpapersPackIsNSFW", "()Z", "getPlatformWallpapersPackName", "getPlatformWallpapersPackPreviewThumbnailPath", "getPlatformWallpapersPackRootPath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final class PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson {
    private final List<String> platformWallpapersPackAuthors;
    private final String platformWallpapersPackDescription;
    private final boolean platformWallpapersPackIsNSFW;
    private final String platformWallpapersPackName;
    private final String platformWallpapersPackPreviewThumbnailPath;
    private final String platformWallpapersPackRootPath;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, null};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson copy$default(PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson platformWallpapersPacksIndexPlatformWallpaperPackListItemJson, List list, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackAuthors;
        }
        if ((i & 2) != 0) {
            str = platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackName;
        }
        if ((i & 4) != 0) {
            str2 = platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackRootPath;
        }
        if ((i & 8) != 0) {
            str3 = platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackPreviewThumbnailPath;
        }
        if ((i & 16) != 0) {
            str4 = platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackDescription;
        }
        if ((i & 32) != 0) {
            z = platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackIsNSFW;
        }
        String str5 = str4;
        boolean z2 = z;
        return platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.copy(list, str, str2, str3, str5, z2);
    }

    public final List<String> component1() {
        return this.platformWallpapersPackAuthors;
    }

    public final String component2() {
        return this.platformWallpapersPackName;
    }

    public final String component3() {
        return this.platformWallpapersPackRootPath;
    }

    public final String component4() {
        return this.platformWallpapersPackPreviewThumbnailPath;
    }

    public final String component5() {
        return this.platformWallpapersPackDescription;
    }

    public final boolean component6() {
        return this.platformWallpapersPackIsNSFW;
    }

    public final PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson copy(List<String> platformWallpapersPackAuthors, String platformWallpapersPackName, String platformWallpapersPackRootPath, String platformWallpapersPackPreviewThumbnailPath, String platformWallpapersPackDescription, boolean z) {
        Intrinsics.checkNotNullParameter(platformWallpapersPackAuthors, "platformWallpapersPackAuthors");
        Intrinsics.checkNotNullParameter(platformWallpapersPackName, "platformWallpapersPackName");
        Intrinsics.checkNotNullParameter(platformWallpapersPackRootPath, "platformWallpapersPackRootPath");
        Intrinsics.checkNotNullParameter(platformWallpapersPackPreviewThumbnailPath, "platformWallpapersPackPreviewThumbnailPath");
        Intrinsics.checkNotNullParameter(platformWallpapersPackDescription, "platformWallpapersPackDescription");
        return new PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson(platformWallpapersPackAuthors, platformWallpapersPackName, platformWallpapersPackRootPath, platformWallpapersPackPreviewThumbnailPath, platformWallpapersPackDescription, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson)) {
            return false;
        }
        PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson platformWallpapersPacksIndexPlatformWallpaperPackListItemJson = (PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson) obj;
        return Intrinsics.areEqual(this.platformWallpapersPackAuthors, platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackAuthors) && Intrinsics.areEqual(this.platformWallpapersPackName, platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackName) && Intrinsics.areEqual(this.platformWallpapersPackRootPath, platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackRootPath) && Intrinsics.areEqual(this.platformWallpapersPackPreviewThumbnailPath, platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackPreviewThumbnailPath) && Intrinsics.areEqual(this.platformWallpapersPackDescription, platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackDescription) && this.platformWallpapersPackIsNSFW == platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackIsNSFW;
    }

    public int hashCode() {
        return (((((((((this.platformWallpapersPackAuthors.hashCode() * 31) + this.platformWallpapersPackName.hashCode()) * 31) + this.platformWallpapersPackRootPath.hashCode()) * 31) + this.platformWallpapersPackPreviewThumbnailPath.hashCode()) * 31) + this.platformWallpapersPackDescription.hashCode()) * 31) + Boolean.hashCode(this.platformWallpapersPackIsNSFW);
    }

    public String toString() {
        return "PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson(platformWallpapersPackAuthors=" + this.platformWallpapersPackAuthors + ", platformWallpapersPackName=" + this.platformWallpapersPackName + ", platformWallpapersPackRootPath=" + this.platformWallpapersPackRootPath + ", platformWallpapersPackPreviewThumbnailPath=" + this.platformWallpapersPackPreviewThumbnailPath + ", platformWallpapersPackDescription=" + this.platformWallpapersPackDescription + ", platformWallpapersPackIsNSFW=" + this.platformWallpapersPackIsNSFW + ")";
    }

    /* JADX INFO: compiled from: PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/data/portables/PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/data/portables/PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> serializer() {
            return PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson(int i, List list, String str, String str2, String str3, String str4, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson$$serializer.INSTANCE.getDescriptor());
        }
        this.platformWallpapersPackAuthors = list;
        this.platformWallpapersPackName = str;
        this.platformWallpapersPackRootPath = str2;
        this.platformWallpapersPackPreviewThumbnailPath = str3;
        this.platformWallpapersPackDescription = str4;
        if ((i & 32) == 0) {
            this.platformWallpapersPackIsNSFW = false;
        } else {
            this.platformWallpapersPackIsNSFW = z;
        }
    }

    public PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson(List<String> platformWallpapersPackAuthors, String platformWallpapersPackName, String platformWallpapersPackRootPath, String platformWallpapersPackPreviewThumbnailPath, String platformWallpapersPackDescription, boolean z) {
        Intrinsics.checkNotNullParameter(platformWallpapersPackAuthors, "platformWallpapersPackAuthors");
        Intrinsics.checkNotNullParameter(platformWallpapersPackName, "platformWallpapersPackName");
        Intrinsics.checkNotNullParameter(platformWallpapersPackRootPath, "platformWallpapersPackRootPath");
        Intrinsics.checkNotNullParameter(platformWallpapersPackPreviewThumbnailPath, "platformWallpapersPackPreviewThumbnailPath");
        Intrinsics.checkNotNullParameter(platformWallpapersPackDescription, "platformWallpapersPackDescription");
        this.platformWallpapersPackAuthors = platformWallpapersPackAuthors;
        this.platformWallpapersPackName = platformWallpapersPackName;
        this.platformWallpapersPackRootPath = platformWallpapersPackRootPath;
        this.platformWallpapersPackPreviewThumbnailPath = platformWallpapersPackPreviewThumbnailPath;
        this.platformWallpapersPackDescription = platformWallpapersPackDescription;
        this.platformWallpapersPackIsNSFW = z;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson platformWallpapersPacksIndexPlatformWallpaperPackListItemJson, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, $childSerializers[0], platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackAuthors);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackName);
        compositeEncoder.encodeStringElement(serialDescriptor, 2, platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackRootPath);
        compositeEncoder.encodeStringElement(serialDescriptor, 3, platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackPreviewThumbnailPath);
        compositeEncoder.encodeStringElement(serialDescriptor, 4, platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackDescription);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackIsNSFW) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 5, platformWallpapersPacksIndexPlatformWallpaperPackListItemJson.platformWallpapersPackIsNSFW);
        }
    }

    public /* synthetic */ PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson(List list, String str, String str2, String str3, String str4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, str2, str3, str4, (i & 32) != 0 ? false : z);
    }

    public final List<String> getPlatformWallpapersPackAuthors() {
        return this.platformWallpapersPackAuthors;
    }

    public final String getPlatformWallpapersPackName() {
        return this.platformWallpapersPackName;
    }

    public final String getPlatformWallpapersPackRootPath() {
        return this.platformWallpapersPackRootPath;
    }

    public final String getPlatformWallpapersPackPreviewThumbnailPath() {
        return this.platformWallpapersPackPreviewThumbnailPath;
    }

    public final String getPlatformWallpapersPackDescription() {
        return this.platformWallpapersPackDescription;
    }

    public final boolean getPlatformWallpapersPackIsNSFW() {
        return this.platformWallpapersPackIsNSFW;
    }
}
