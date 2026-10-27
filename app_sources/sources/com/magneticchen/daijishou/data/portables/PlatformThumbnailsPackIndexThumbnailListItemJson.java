package com.magneticchen.daijishou.data.portables;

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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: PlatformThumbnailsPackIndexThumbnailListItemJson.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B7\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006#"}, d2 = {"Lcom/magneticchen/daijishou/data/portables/PlatformThumbnailsPackIndexThumbnailListItemJson;", "", "seen1", "", "matchPlatformShortname", "", "matchPlatformUniqueId", "filename", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFilename", "()Ljava/lang/String;", "getMatchPlatformShortname", "getMatchPlatformUniqueId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final class PlatformThumbnailsPackIndexThumbnailListItemJson {
    public static final Companion Companion = new Companion(null);
    private final String filename;
    private final String matchPlatformShortname;
    private final String matchPlatformUniqueId;

    public static /* synthetic */ PlatformThumbnailsPackIndexThumbnailListItemJson copy$default(PlatformThumbnailsPackIndexThumbnailListItemJson platformThumbnailsPackIndexThumbnailListItemJson, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = platformThumbnailsPackIndexThumbnailListItemJson.matchPlatformShortname;
        }
        if ((i & 2) != 0) {
            str2 = platformThumbnailsPackIndexThumbnailListItemJson.matchPlatformUniqueId;
        }
        if ((i & 4) != 0) {
            str3 = platformThumbnailsPackIndexThumbnailListItemJson.filename;
        }
        return platformThumbnailsPackIndexThumbnailListItemJson.copy(str, str2, str3);
    }

    public final String component1() {
        return this.matchPlatformShortname;
    }

    public final String component2() {
        return this.matchPlatformUniqueId;
    }

    public final String component3() {
        return this.filename;
    }

    public final PlatformThumbnailsPackIndexThumbnailListItemJson copy(String matchPlatformShortname, String matchPlatformUniqueId, String filename) {
        Intrinsics.checkNotNullParameter(matchPlatformShortname, "matchPlatformShortname");
        Intrinsics.checkNotNullParameter(matchPlatformUniqueId, "matchPlatformUniqueId");
        Intrinsics.checkNotNullParameter(filename, "filename");
        return new PlatformThumbnailsPackIndexThumbnailListItemJson(matchPlatformShortname, matchPlatformUniqueId, filename);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformThumbnailsPackIndexThumbnailListItemJson)) {
            return false;
        }
        PlatformThumbnailsPackIndexThumbnailListItemJson platformThumbnailsPackIndexThumbnailListItemJson = (PlatformThumbnailsPackIndexThumbnailListItemJson) obj;
        return Intrinsics.areEqual(this.matchPlatformShortname, platformThumbnailsPackIndexThumbnailListItemJson.matchPlatformShortname) && Intrinsics.areEqual(this.matchPlatformUniqueId, platformThumbnailsPackIndexThumbnailListItemJson.matchPlatformUniqueId) && Intrinsics.areEqual(this.filename, platformThumbnailsPackIndexThumbnailListItemJson.filename);
    }

    public int hashCode() {
        return (((this.matchPlatformShortname.hashCode() * 31) + this.matchPlatformUniqueId.hashCode()) * 31) + this.filename.hashCode();
    }

    public String toString() {
        return "PlatformThumbnailsPackIndexThumbnailListItemJson(matchPlatformShortname=" + this.matchPlatformShortname + ", matchPlatformUniqueId=" + this.matchPlatformUniqueId + ", filename=" + this.filename + ")";
    }

    /* JADX INFO: compiled from: PlatformThumbnailsPackIndexThumbnailListItemJson.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/data/portables/PlatformThumbnailsPackIndexThumbnailListItemJson$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/data/portables/PlatformThumbnailsPackIndexThumbnailListItemJson;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlatformThumbnailsPackIndexThumbnailListItemJson> serializer() {
            return PlatformThumbnailsPackIndexThumbnailListItemJson$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PlatformThumbnailsPackIndexThumbnailListItemJson(int i, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, PlatformThumbnailsPackIndexThumbnailListItemJson$$serializer.INSTANCE.getDescriptor());
        }
        this.matchPlatformShortname = str;
        this.matchPlatformUniqueId = str2;
        this.filename = str3;
    }

    public PlatformThumbnailsPackIndexThumbnailListItemJson(String matchPlatformShortname, String matchPlatformUniqueId, String filename) {
        Intrinsics.checkNotNullParameter(matchPlatformShortname, "matchPlatformShortname");
        Intrinsics.checkNotNullParameter(matchPlatformUniqueId, "matchPlatformUniqueId");
        Intrinsics.checkNotNullParameter(filename, "filename");
        this.matchPlatformShortname = matchPlatformShortname;
        this.matchPlatformUniqueId = matchPlatformUniqueId;
        this.filename = filename;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(PlatformThumbnailsPackIndexThumbnailListItemJson platformThumbnailsPackIndexThumbnailListItemJson, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeStringElement(serialDescriptor, 0, platformThumbnailsPackIndexThumbnailListItemJson.matchPlatformShortname);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, platformThumbnailsPackIndexThumbnailListItemJson.matchPlatformUniqueId);
        compositeEncoder.encodeStringElement(serialDescriptor, 2, platformThumbnailsPackIndexThumbnailListItemJson.filename);
    }

    public final String getMatchPlatformShortname() {
        return this.matchPlatformShortname;
    }

    public final String getMatchPlatformUniqueId() {
        return this.matchPlatformUniqueId;
    }

    public final String getFilename() {
        return this.filename;
    }
}
