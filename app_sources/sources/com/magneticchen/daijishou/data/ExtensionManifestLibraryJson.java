package com.magneticchen.daijishou.data;

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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: ExtensionManifestJson.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B?\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB3\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÁ\u0001¢\u0006\u0002\b$R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006'"}, d2 = {"Lcom/magneticchen/daijishou/data/ExtensionManifestLibraryJson;", "", "seen1", "", "path", "", "export", "", "fromExtension", "library", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getExport", "()Z", "getFromExtension", "()Ljava/lang/String;", "getLibrary", "getPath", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final class ExtensionManifestLibraryJson {
    public static final Companion Companion = new Companion(null);
    private final boolean export;
    private final String fromExtension;
    private final String library;
    private final String path;

    public ExtensionManifestLibraryJson() {
        this((String) null, false, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ExtensionManifestLibraryJson copy$default(ExtensionManifestLibraryJson extensionManifestLibraryJson, String str, boolean z, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = extensionManifestLibraryJson.path;
        }
        if ((i & 2) != 0) {
            z = extensionManifestLibraryJson.export;
        }
        if ((i & 4) != 0) {
            str2 = extensionManifestLibraryJson.fromExtension;
        }
        if ((i & 8) != 0) {
            str3 = extensionManifestLibraryJson.library;
        }
        return extensionManifestLibraryJson.copy(str, z, str2, str3);
    }

    public final String component1() {
        return this.path;
    }

    public final boolean component2() {
        return this.export;
    }

    public final String component3() {
        return this.fromExtension;
    }

    public final String component4() {
        return this.library;
    }

    public final ExtensionManifestLibraryJson copy(String str, boolean z, String str2, String str3) {
        return new ExtensionManifestLibraryJson(str, z, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtensionManifestLibraryJson)) {
            return false;
        }
        ExtensionManifestLibraryJson extensionManifestLibraryJson = (ExtensionManifestLibraryJson) obj;
        return Intrinsics.areEqual(this.path, extensionManifestLibraryJson.path) && this.export == extensionManifestLibraryJson.export && Intrinsics.areEqual(this.fromExtension, extensionManifestLibraryJson.fromExtension) && Intrinsics.areEqual(this.library, extensionManifestLibraryJson.library);
    }

    public int hashCode() {
        String str = this.path;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.export)) * 31;
        String str2 = this.fromExtension;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.library;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ExtensionManifestLibraryJson(path=" + this.path + ", export=" + this.export + ", fromExtension=" + this.fromExtension + ", library=" + this.library + ")";
    }

    /* JADX INFO: compiled from: ExtensionManifestJson.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/data/ExtensionManifestLibraryJson$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/data/ExtensionManifestLibraryJson;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ExtensionManifestLibraryJson> serializer() {
            return ExtensionManifestLibraryJson$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ExtensionManifestLibraryJson(int i, String str, boolean z, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.path = null;
        } else {
            this.path = str;
        }
        if ((i & 2) == 0) {
            this.export = false;
        } else {
            this.export = z;
        }
        if ((i & 4) == 0) {
            this.fromExtension = null;
        } else {
            this.fromExtension = str2;
        }
        if ((i & 8) == 0) {
            this.library = null;
        } else {
            this.library = str3;
        }
    }

    public ExtensionManifestLibraryJson(String str, boolean z, String str2, String str3) {
        this.path = str;
        this.export = z;
        this.fromExtension = str2;
        this.library = str3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(ExtensionManifestLibraryJson extensionManifestLibraryJson, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || extensionManifestLibraryJson.path != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, extensionManifestLibraryJson.path);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || extensionManifestLibraryJson.export) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 1, extensionManifestLibraryJson.export);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || extensionManifestLibraryJson.fromExtension != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, extensionManifestLibraryJson.fromExtension);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) && extensionManifestLibraryJson.library == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, extensionManifestLibraryJson.library);
    }

    public /* synthetic */ ExtensionManifestLibraryJson(String str, boolean z, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }

    public final String getPath() {
        return this.path;
    }

    public final boolean getExport() {
        return this.export;
    }

    public final String getFromExtension() {
        return this.fromExtension;
    }

    public final String getLibrary() {
        return this.library;
    }
}
