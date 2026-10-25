package com.magneticchen.daijishou.daijishou_library_db.portables;

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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: PlatformsIndexPlatformListItemJson.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+BK\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014JD\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(HÁ\u0001¢\u0006\u0002\b)R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006,"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformsIndexPlatformListItemJson;", "", "seen1", "", "filename", "", "platformName", "platformShortname", "platformUniqueId", "revisionNumber", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getFilename", "()Ljava/lang/String;", "getPlatformName", "getPlatformShortname", "getPlatformUniqueId", "getRevisionNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformsIndexPlatformListItemJson;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final /* data */ class PlatformsIndexPlatformListItemJson {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String filename;
    private final String platformName;
    private final String platformShortname;
    private final String platformUniqueId;
    private final Integer revisionNumber;

    public static /* synthetic */ PlatformsIndexPlatformListItemJson copy$default(PlatformsIndexPlatformListItemJson platformsIndexPlatformListItemJson, String str, String str2, String str3, String str4, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = platformsIndexPlatformListItemJson.filename;
        }
        if ((i & 2) != 0) {
            str2 = platformsIndexPlatformListItemJson.platformName;
        }
        if ((i & 4) != 0) {
            str3 = platformsIndexPlatformListItemJson.platformShortname;
        }
        if ((i & 8) != 0) {
            str4 = platformsIndexPlatformListItemJson.platformUniqueId;
        }
        if ((i & 16) != 0) {
            num = platformsIndexPlatformListItemJson.revisionNumber;
        }
        Integer num2 = num;
        String str5 = str3;
        return platformsIndexPlatformListItemJson.copy(str, str2, str5, str4, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPlatformName() {
        return this.platformName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPlatformShortname() {
        return this.platformShortname;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPlatformUniqueId() {
        return this.platformUniqueId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getRevisionNumber() {
        return this.revisionNumber;
    }

    public final PlatformsIndexPlatformListItemJson copy(String filename, String platformName, String platformShortname, String platformUniqueId, Integer revisionNumber) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(platformName, "platformName");
        Intrinsics.checkNotNullParameter(platformUniqueId, "platformUniqueId");
        return new PlatformsIndexPlatformListItemJson(filename, platformName, platformShortname, platformUniqueId, revisionNumber);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlatformsIndexPlatformListItemJson)) {
            return false;
        }
        PlatformsIndexPlatformListItemJson platformsIndexPlatformListItemJson = (PlatformsIndexPlatformListItemJson) other;
        return Intrinsics.areEqual(this.filename, platformsIndexPlatformListItemJson.filename) && Intrinsics.areEqual(this.platformName, platformsIndexPlatformListItemJson.platformName) && Intrinsics.areEqual(this.platformShortname, platformsIndexPlatformListItemJson.platformShortname) && Intrinsics.areEqual(this.platformUniqueId, platformsIndexPlatformListItemJson.platformUniqueId) && Intrinsics.areEqual(this.revisionNumber, platformsIndexPlatformListItemJson.revisionNumber);
    }

    public int hashCode() {
        int iHashCode = ((this.filename.hashCode() * 31) + this.platformName.hashCode()) * 31;
        String str = this.platformShortname;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.platformUniqueId.hashCode()) * 31;
        Integer num = this.revisionNumber;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "PlatformsIndexPlatformListItemJson(filename=" + this.filename + ", platformName=" + this.platformName + ", platformShortname=" + this.platformShortname + ", platformUniqueId=" + this.platformUniqueId + ", revisionNumber=" + this.revisionNumber + ")";
    }

    /* JADX INFO: compiled from: PlatformsIndexPlatformListItemJson.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformsIndexPlatformListItemJson$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformsIndexPlatformListItemJson;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlatformsIndexPlatformListItemJson> serializer() {
            return PlatformsIndexPlatformListItemJson$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PlatformsIndexPlatformListItemJson(int i, String str, String str2, String str3, String str4, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if (11 != (i & 11)) {
            PluginExceptionsKt.throwMissingFieldException(i, 11, PlatformsIndexPlatformListItemJson$$serializer.INSTANCE.getDescriptor());
        }
        this.filename = str;
        this.platformName = str2;
        if ((i & 4) == 0) {
            this.platformShortname = null;
        } else {
            this.platformShortname = str3;
        }
        this.platformUniqueId = str4;
        if ((i & 16) == 0) {
            this.revisionNumber = null;
        } else {
            this.revisionNumber = num;
        }
    }

    public PlatformsIndexPlatformListItemJson(String filename, String platformName, String str, String platformUniqueId, Integer num) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(platformName, "platformName");
        Intrinsics.checkNotNullParameter(platformUniqueId, "platformUniqueId");
        this.filename = filename;
        this.platformName = platformName;
        this.platformShortname = str;
        this.platformUniqueId = platformUniqueId;
        this.revisionNumber = num;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(PlatformsIndexPlatformListItemJson self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.filename);
        output.encodeStringElement(serialDesc, 1, self.platformName);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.platformShortname != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.platformShortname);
        }
        output.encodeStringElement(serialDesc, 3, self.platformUniqueId);
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.revisionNumber == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.revisionNumber);
    }

    public /* synthetic */ PlatformsIndexPlatformListItemJson(String str, String str2, String str3, String str4, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, str4, (i & 16) != 0 ? null : num);
    }





}
