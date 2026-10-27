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

/* JADX INFO: compiled from: PlatformShareable.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B;\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\rJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lcom/magneticchen/daijishou/data/portables/PlatformShareable;", "", "seen1", "", "databaseVersion", "platform", "Lcom/magneticchen/daijishou/data/portables/PlatformEntityPortable;", "playerList", "", "Lcom/magneticchen/daijishou/data/portables/PlayerEntityPortable;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILcom/magneticchen/daijishou/data/portables/PlatformEntityPortable;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILcom/magneticchen/daijishou/data/portables/PlatformEntityPortable;Ljava/util/List;)V", "getDatabaseVersion", "()I", "getPlatform", "()Lcom/magneticchen/daijishou/data/portables/PlatformEntityPortable;", "getPlayerList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final class PlatformShareable {
    private final int databaseVersion;
    private final PlatformEntityPortable platform;
    private final List<PlayerEntityPortable> playerList;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(PlayerEntityPortable$$serializer.INSTANCE)};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlatformShareable copy$default(PlatformShareable platformShareable, int i, PlatformEntityPortable platformEntityPortable, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = platformShareable.databaseVersion;
        }
        if ((i2 & 2) != 0) {
            platformEntityPortable = platformShareable.platform;
        }
        if ((i2 & 4) != 0) {
            list = platformShareable.playerList;
        }
        return platformShareable.copy(i, platformEntityPortable, list);
    }

    public final int component1() {
        return this.databaseVersion;
    }

    public final PlatformEntityPortable component2() {
        return this.platform;
    }

    public final List<PlayerEntityPortable> component3() {
        return this.playerList;
    }

    public final PlatformShareable copy(int i, PlatformEntityPortable platform, List<PlayerEntityPortable> playerList) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(playerList, "playerList");
        return new PlatformShareable(i, platform, playerList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformShareable)) {
            return false;
        }
        PlatformShareable platformShareable = (PlatformShareable) obj;
        return this.databaseVersion == platformShareable.databaseVersion && Intrinsics.areEqual(this.platform, platformShareable.platform) && Intrinsics.areEqual(this.playerList, platformShareable.playerList);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.databaseVersion) * 31) + this.platform.hashCode()) * 31) + this.playerList.hashCode();
    }

    public String toString() {
        return "PlatformShareable(databaseVersion=" + this.databaseVersion + ", platform=" + this.platform + ", playerList=" + this.playerList + ")";
    }

    /* JADX INFO: compiled from: PlatformShareable.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/data/portables/PlatformShareable$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/data/portables/PlatformShareable;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlatformShareable> serializer() {
            return PlatformShareable$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PlatformShareable(int i, int i2, PlatformEntityPortable platformEntityPortable, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, PlatformShareable$$serializer.INSTANCE.getDescriptor());
        }
        this.databaseVersion = i2;
        this.platform = platformEntityPortable;
        this.playerList = list;
    }

    public PlatformShareable(int i, PlatformEntityPortable platform, List<PlayerEntityPortable> playerList) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(playerList, "playerList");
        this.databaseVersion = i;
        this.platform = platform;
        this.playerList = playerList;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(PlatformShareable platformShareable, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        compositeEncoder.encodeIntElement(serialDescriptor, 0, platformShareable.databaseVersion);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, PlatformEntityPortable$$serializer.INSTANCE, platformShareable.platform);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, serializationStrategyArr[2], platformShareable.playerList);
    }

    public final int getDatabaseVersion() {
        return this.databaseVersion;
    }

    public final PlatformEntityPortable getPlatform() {
        return this.platform;
    }

    public final List<PlayerEntityPortable> getPlayerList() {
        return this.playerList;
    }
}
