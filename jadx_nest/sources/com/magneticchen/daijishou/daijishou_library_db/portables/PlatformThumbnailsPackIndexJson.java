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
import kotlinx.serialization.internal.StringSerializer;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: PlatformThumbnailsPackIndexJson.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000289B\u0081\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013Bc\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\b¢\u0006\u0002\u0010\u0014J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100\bHÆ\u0003Jw\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\bHÆ\u0001J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001J&\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206HÁ\u0001¢\u0006\u0002\b7R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016¨\u0006:"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPackIndexJson;", "", "seen1", "", "name", "", "description", "authors", "", "sources", "previewThumbnailFilename", "isNSFW", "", "hasDefaultThumbnail", "defaultThumbnailFilename", "thumbnailList", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPackIndexThumbnailListItemJson;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZZLjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZZLjava/lang/String;Ljava/util/List;)V", "getAuthors", "()Ljava/util/List;", "getDefaultThumbnailFilename", "()Ljava/lang/String;", "getDescription", "getHasDefaultThumbnail", "()Z", "setNSFW", "(Z)V", "getName", "getPreviewThumbnailFilename", "getSources", "getThumbnailList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final /* data */ class PlatformThumbnailsPackIndexJson {
    private final List<String> authors;
    private final String defaultThumbnailFilename;
    private final String description;
    private final boolean hasDefaultThumbnail;
    private boolean isNSFW;
    private final String name;
    private final String previewThumbnailFilename;
    private final List<String> sources;
    private final List<PlatformThumbnailsPackIndexThumbnailListItemJson> thumbnailList;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final KSerializer[] $childSerializers = {null, null, new ArrayListSerializer(StringSerializer.INSTANCE), new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, new ArrayListSerializer(PlatformThumbnailsPackIndexThumbnailListItemJson$$serializer.INSTANCE)};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlatformThumbnailsPackIndexJson copy$default(PlatformThumbnailsPackIndexJson platformThumbnailsPackIndexJson, String str, String str2, List list, List list2, String str3, boolean z, boolean z2, String str4, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = platformThumbnailsPackIndexJson.name;
        }
        if ((i & 2) != 0) {
            str2 = platformThumbnailsPackIndexJson.description;
        }
        if ((i & 4) != 0) {
            list = platformThumbnailsPackIndexJson.authors;
        }
        if ((i & 8) != 0) {
            list2 = platformThumbnailsPackIndexJson.sources;
        }
        if ((i & 16) != 0) {
            str3 = platformThumbnailsPackIndexJson.previewThumbnailFilename;
        }
        if ((i & 32) != 0) {
            z = platformThumbnailsPackIndexJson.isNSFW;
        }
        if ((i & 64) != 0) {
            z2 = platformThumbnailsPackIndexJson.hasDefaultThumbnail;
        }
        if ((i & 128) != 0) {
            str4 = platformThumbnailsPackIndexJson.defaultThumbnailFilename;
        }
        if ((i & 256) != 0) {
            list3 = platformThumbnailsPackIndexJson.thumbnailList;
        }
        String str5 = str4;
        List list4 = list3;
        boolean z3 = z;
        boolean z4 = z2;
        String str6 = str3;
        List list5 = list;
        return platformThumbnailsPackIndexJson.copy(str, str2, list5, list2, str6, z3, z4, str5, list4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<String> component3() {
        return this.authors;
    }

    public final List<String> component4() {
        return this.sources;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPreviewThumbnailFilename() {
        return this.previewThumbnailFilename;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsNSFW() {
        return this.isNSFW;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getHasDefaultThumbnail() {
        return this.hasDefaultThumbnail;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDefaultThumbnailFilename() {
        return this.defaultThumbnailFilename;
    }

    public final List<PlatformThumbnailsPackIndexThumbnailListItemJson> component9() {
        return this.thumbnailList;
    }

    public final PlatformThumbnailsPackIndexJson copy(String name, String description, List<String> authors, List<String> sources, String previewThumbnailFilename, boolean isNSFW, boolean hasDefaultThumbnail, String defaultThumbnailFilename, List<PlatformThumbnailsPackIndexThumbnailListItemJson> thumbnailList) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(authors, "authors");
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(previewThumbnailFilename, "previewThumbnailFilename");
        Intrinsics.checkNotNullParameter(thumbnailList, "thumbnailList");
        return new PlatformThumbnailsPackIndexJson(name, description, authors, sources, previewThumbnailFilename, isNSFW, hasDefaultThumbnail, defaultThumbnailFilename, thumbnailList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlatformThumbnailsPackIndexJson)) {
            return false;
        }
        PlatformThumbnailsPackIndexJson platformThumbnailsPackIndexJson = (PlatformThumbnailsPackIndexJson) other;
        return Intrinsics.areEqual(this.name, platformThumbnailsPackIndexJson.name) && Intrinsics.areEqual(this.description, platformThumbnailsPackIndexJson.description) && Intrinsics.areEqual(this.authors, platformThumbnailsPackIndexJson.authors) && Intrinsics.areEqual(this.sources, platformThumbnailsPackIndexJson.sources) && Intrinsics.areEqual(this.previewThumbnailFilename, platformThumbnailsPackIndexJson.previewThumbnailFilename) && this.isNSFW == platformThumbnailsPackIndexJson.isNSFW && this.hasDefaultThumbnail == platformThumbnailsPackIndexJson.hasDefaultThumbnail && Intrinsics.areEqual(this.defaultThumbnailFilename, platformThumbnailsPackIndexJson.defaultThumbnailFilename) && Intrinsics.areEqual(this.thumbnailList, platformThumbnailsPackIndexJson.thumbnailList);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.name.hashCode() * 31) + this.description.hashCode()) * 31) + this.authors.hashCode()) * 31) + this.sources.hashCode()) * 31) + this.previewThumbnailFilename.hashCode()) * 31) + Boolean.hashCode(this.isNSFW)) * 31) + Boolean.hashCode(this.hasDefaultThumbnail)) * 31;
        String str = this.defaultThumbnailFilename;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.thumbnailList.hashCode();
    }

    public String toString() {
        return "PlatformThumbnailsPackIndexJson(name=" + this.name + ", description=" + this.description + ", authors=" + this.authors + ", sources=" + this.sources + ", previewThumbnailFilename=" + this.previewThumbnailFilename + ", isNSFW=" + this.isNSFW + ", hasDefaultThumbnail=" + this.hasDefaultThumbnail + ", defaultThumbnailFilename=" + this.defaultThumbnailFilename + ", thumbnailList=" + this.thumbnailList + ")";
    }

    /* JADX INFO: compiled from: PlatformThumbnailsPackIndexJson.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPackIndexJson$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPackIndexJson;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlatformThumbnailsPackIndexJson> serializer() {
            return PlatformThumbnailsPackIndexJson$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PlatformThumbnailsPackIndexJson(int i, String str, String str2, List list, List list2, String str3, boolean z, boolean z2, String str4, List list3, SerializationConstructorMarker serializationConstructorMarker) {
        if (479 != (i & 479)) {
            PluginExceptionsKt.throwMissingFieldException(i, 479, PlatformThumbnailsPackIndexJson$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.description = str2;
        this.authors = list;
        this.sources = list2;
        this.previewThumbnailFilename = str3;
        if ((i & 32) == 0) {
            this.isNSFW = false;
        } else {
            this.isNSFW = z;
        }
        this.hasDefaultThumbnail = z2;
        this.defaultThumbnailFilename = str4;
        this.thumbnailList = list3;
    }

    public PlatformThumbnailsPackIndexJson(String name, String description, List<String> authors, List<String> sources, String previewThumbnailFilename, boolean z, boolean z2, String str, List<PlatformThumbnailsPackIndexThumbnailListItemJson> thumbnailList) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(authors, "authors");
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(previewThumbnailFilename, "previewThumbnailFilename");
        Intrinsics.checkNotNullParameter(thumbnailList, "thumbnailList");
        this.name = name;
        this.description = description;
        this.authors = authors;
        this.sources = sources;
        this.previewThumbnailFilename = previewThumbnailFilename;
        this.isNSFW = z;
        this.hasDefaultThumbnail = z2;
        this.defaultThumbnailFilename = str;
        this.thumbnailList = thumbnailList;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(PlatformThumbnailsPackIndexJson self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.name);
        output.encodeStringElement(serialDesc, 1, self.description);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.authors);
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.sources);
        output.encodeStringElement(serialDesc, 4, self.previewThumbnailFilename);
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.isNSFW) {
            output.encodeBooleanElement(serialDesc, 5, self.isNSFW);
        }
        output.encodeBooleanElement(serialDesc, 6, self.hasDefaultThumbnail);
        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.defaultThumbnailFilename);
        output.encodeSerializableElement(serialDesc, 8, kSerializerArr[8], self.thumbnailList);
    }

    public /* synthetic */ PlatformThumbnailsPackIndexJson(String str, String str2, List list, List list2, String str3, boolean z, boolean z2, String str4, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, list, list2, str3, (i & 32) != 0 ? false : z, z2, str4, list3);
    }



    public final List<String> getAuthors() {
        return this.authors;
    }

    public final List<String> getSources() {
        return this.sources;
    }


    public final boolean isNSFW() {
        return this.isNSFW;
    }

    public final void setNSFW(boolean z) {
        this.isNSFW = z;
    }



    public final List<PlatformThumbnailsPackIndexThumbnailListItemJson> getThumbnailList() {
        return this.thumbnailList;
    }
}
