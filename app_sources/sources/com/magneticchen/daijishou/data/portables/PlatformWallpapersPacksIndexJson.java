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
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: PlatformWallpapersPacksIndexJson.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B3\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/magneticchen/daijishou/data/portables/PlatformWallpapersPacksIndexJson;", "", "seen1", "", "baseUri", "", "platformWallpapersPackList", "", "Lcom/magneticchen/daijishou/data/portables/PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/util/List;)V", "getBaseUri", "()Ljava/lang/String;", "getPlatformWallpapersPackList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final class PlatformWallpapersPacksIndexJson {
    private final String baseUri;
    private final List<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> platformWallpapersPackList;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson$$serializer.INSTANCE)};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlatformWallpapersPacksIndexJson copy$default(PlatformWallpapersPacksIndexJson platformWallpapersPacksIndexJson, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = platformWallpapersPacksIndexJson.baseUri;
        }
        if ((i & 2) != 0) {
            list = platformWallpapersPacksIndexJson.platformWallpapersPackList;
        }
        return platformWallpapersPacksIndexJson.copy(str, list);
    }

    public final String component1() {
        return this.baseUri;
    }

    public final List<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> component2() {
        return this.platformWallpapersPackList;
    }

    public final PlatformWallpapersPacksIndexJson copy(String baseUri, List<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> platformWallpapersPackList) {
        Intrinsics.checkNotNullParameter(baseUri, "baseUri");
        Intrinsics.checkNotNullParameter(platformWallpapersPackList, "platformWallpapersPackList");
        return new PlatformWallpapersPacksIndexJson(baseUri, platformWallpapersPackList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformWallpapersPacksIndexJson)) {
            return false;
        }
        PlatformWallpapersPacksIndexJson platformWallpapersPacksIndexJson = (PlatformWallpapersPacksIndexJson) obj;
        return Intrinsics.areEqual(this.baseUri, platformWallpapersPacksIndexJson.baseUri) && Intrinsics.areEqual(this.platformWallpapersPackList, platformWallpapersPacksIndexJson.platformWallpapersPackList);
    }

    public int hashCode() {
        return (this.baseUri.hashCode() * 31) + this.platformWallpapersPackList.hashCode();
    }

    public String toString() {
        return "PlatformWallpapersPacksIndexJson(baseUri=" + this.baseUri + ", platformWallpapersPackList=" + this.platformWallpapersPackList + ")";
    }

    /* JADX INFO: compiled from: PlatformWallpapersPacksIndexJson.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/data/portables/PlatformWallpapersPacksIndexJson$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/data/portables/PlatformWallpapersPacksIndexJson;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlatformWallpapersPacksIndexJson> serializer() {
            return PlatformWallpapersPacksIndexJson$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PlatformWallpapersPacksIndexJson(int i, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, PlatformWallpapersPacksIndexJson$$serializer.INSTANCE.getDescriptor());
        }
        this.baseUri = str;
        this.platformWallpapersPackList = list;
    }

    public PlatformWallpapersPacksIndexJson(String baseUri, List<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> platformWallpapersPackList) {
        Intrinsics.checkNotNullParameter(baseUri, "baseUri");
        Intrinsics.checkNotNullParameter(platformWallpapersPackList, "platformWallpapersPackList");
        this.baseUri = baseUri;
        this.platformWallpapersPackList = platformWallpapersPackList;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(PlatformWallpapersPacksIndexJson platformWallpapersPacksIndexJson, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        compositeEncoder.encodeStringElement(serialDescriptor, 0, platformWallpapersPacksIndexJson.baseUri);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, serializationStrategyArr[1], platformWallpapersPacksIndexJson.platformWallpapersPackList);
    }

    public final String getBaseUri() {
        return this.baseUri;
    }

    public final List<PlatformWallpapersPacksIndexPlatformWallpaperPackListItemJson> getPlatformWallpapersPackList() {
        return this.platformWallpapersPackList;
    }
}
