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

/* JADX INFO: compiled from: PlatformShareable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B;\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\rJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformSharable;", "", "seen1", "", "databaseVersion", "platform", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformEntityPortable;", "playerList", "", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlayerEntityPortable;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformEntityPortable;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformEntityPortable;Ljava/util/List;)V", "getDatabaseVersion", "()I", "getPlatform", "()Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformEntityPortable;", "getPlayerList", "()Ljava/util/List;", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final /* data */ class PlatformSharable {
    private final int databaseVersion;
    private final PlatformEntityPortable platform;
    private final List<PlayerEntityPortable> playerList;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final KSerializer[] $childSerializers = {null, null, new ArrayListSerializer(PlayerEntityPortable$$serializer.INSTANCE)};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlatformSharable copy$default(PlatformSharable platformSharable, int i, PlatformEntityPortable platformEntityPortable, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = platformSharable.databaseVersion;
        }
        if ((i2 & 2) != 0) {
            platformEntityPortable = platformSharable.platform;
        }
        if ((i2 & 4) != 0) {
            list = platformSharable.playerList;
        }
        return platformSharable.copy(i, platformEntityPortable, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDatabaseVersion() {
        return this.databaseVersion;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PlatformEntityPortable getPlatform() {
        return this.platform;
    }

    public final List<PlayerEntityPortable> component3() {
        return this.playerList;
    }

    public final PlatformSharable copy(int databaseVersion, PlatformEntityPortable platform, List<PlayerEntityPortable> playerList) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(playerList, "playerList");
        return new PlatformSharable(databaseVersion, platform, playerList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlatformSharable)) {
            return false;
        }
        PlatformSharable platformSharable = (PlatformSharable) other;
        return this.databaseVersion == platformSharable.databaseVersion && Intrinsics.areEqual(this.platform, platformSharable.platform) && Intrinsics.areEqual(this.playerList, platformSharable.playerList);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.databaseVersion) * 31) + this.platform.hashCode()) * 31) + this.playerList.hashCode();
    }

    public String toString() {
        return "PlatformSharable(databaseVersion=" + this.databaseVersion + ", platform=" + this.platform + ", playerList=" + this.playerList + ")";
    }

    /* JADX INFO: compiled from: PlatformShareable.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformSharable$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformSharable;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlatformSharable> serializer() {
            return PlatformSharable$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PlatformSharable(int i, int i2, PlatformEntityPortable platformEntityPortable, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, PlatformSharable$$serializer.INSTANCE.getDescriptor());
        }
        this.databaseVersion = i2;
        this.platform = platformEntityPortable;
        this.playerList = list;
    }

    public PlatformSharable(int i, PlatformEntityPortable platform, List<PlayerEntityPortable> playerList) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(playerList, "playerList");
        this.databaseVersion = i;
        this.platform = platform;
        this.playerList = playerList;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(PlatformSharable self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.databaseVersion);
        output.encodeSerializableElement(serialDesc, 1, PlatformEntityPortable$$serializer.INSTANCE, self.platform);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.playerList);
    }



    public final List<PlayerEntityPortable> getPlayerList() {
        return this.playerList;
    }
}
