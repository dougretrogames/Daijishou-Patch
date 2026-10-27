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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: ExtensionManifestJson.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u001a\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÁ\u0001¢\u0006\u0002\b\u001cR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/magneticchen/daijishou/data/ExtensionManifestDependencyJson;", "", "seen1", "", "versionCodeAtLeast", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;)V", "getVersionCodeAtLeast", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/magneticchen/daijishou/data/ExtensionManifestDependencyJson;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final class ExtensionManifestDependencyJson {
    public static final Companion Companion = new Companion(null);
    private final Integer versionCodeAtLeast;

    /* JADX WARN: Multi-variable type inference failed */
    public ExtensionManifestDependencyJson() {
        this((Integer) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ ExtensionManifestDependencyJson copy$default(ExtensionManifestDependencyJson extensionManifestDependencyJson, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = extensionManifestDependencyJson.versionCodeAtLeast;
        }
        return extensionManifestDependencyJson.copy(num);
    }

    public final Integer component1() {
        return this.versionCodeAtLeast;
    }

    public final ExtensionManifestDependencyJson copy(Integer num) {
        return new ExtensionManifestDependencyJson(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ExtensionManifestDependencyJson) && Intrinsics.areEqual(this.versionCodeAtLeast, ((ExtensionManifestDependencyJson) obj).versionCodeAtLeast);
    }

    public int hashCode() {
        Integer num = this.versionCodeAtLeast;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return "ExtensionManifestDependencyJson(versionCodeAtLeast=" + this.versionCodeAtLeast + ")";
    }

    /* JADX INFO: compiled from: ExtensionManifestJson.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/data/ExtensionManifestDependencyJson$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/data/ExtensionManifestDependencyJson;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ExtensionManifestDependencyJson> serializer() {
            return ExtensionManifestDependencyJson$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ExtensionManifestDependencyJson(int i, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.versionCodeAtLeast = null;
        } else {
            this.versionCodeAtLeast = num;
        }
    }

    public ExtensionManifestDependencyJson(Integer num) {
        this.versionCodeAtLeast = num;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(ExtensionManifestDependencyJson extensionManifestDependencyJson, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) && extensionManifestDependencyJson.versionCodeAtLeast == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, IntSerializer.INSTANCE, extensionManifestDependencyJson.versionCodeAtLeast);
    }

    public /* synthetic */ ExtensionManifestDependencyJson(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num);
    }

    public final Integer getVersionCodeAtLeast() {
        return this.versionCodeAtLeast;
    }
}
