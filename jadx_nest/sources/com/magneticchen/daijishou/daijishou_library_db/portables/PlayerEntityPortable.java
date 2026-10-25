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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: PlayerEntityPortable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 <2\u00020\u0001:\u0002;<Be\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010BY\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u0011J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J]\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001J\u0013\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001J&\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209HÁ\u0001¢\u0006\u0002\b:R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015¨\u0006="}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlayerEntityPortable;", "", "seen1", "", "name", "", "uniqueId", "description", "acceptedFilenameRegex", "amStartArguments", "killPackageProcesses", "", "killPackageProcessesWarning", "extra", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V", "getAcceptedFilenameRegex", "()Ljava/lang/String;", "setAcceptedFilenameRegex", "(Ljava/lang/String;)V", "getAmStartArguments", "setAmStartArguments", "getDescription", "setDescription", "getExtra", "setExtra", "getKillPackageProcesses", "()Z", "setKillPackageProcesses", "(Z)V", "getKillPackageProcessesWarning", "setKillPackageProcessesWarning", "getName", "setName", "getUniqueId", "setUniqueId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final /* data */ class PlayerEntityPortable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String acceptedFilenameRegex;
    private String amStartArguments;
    private String description;
    private String extra;
    private boolean killPackageProcesses;
    private boolean killPackageProcessesWarning;
    private String name;
    private String uniqueId;

    public PlayerEntityPortable() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, false, false, (String) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PlayerEntityPortable copy$default(PlayerEntityPortable playerEntityPortable, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playerEntityPortable.name;
        }
        if ((i & 2) != 0) {
            str2 = playerEntityPortable.uniqueId;
        }
        if ((i & 4) != 0) {
            str3 = playerEntityPortable.description;
        }
        if ((i & 8) != 0) {
            str4 = playerEntityPortable.acceptedFilenameRegex;
        }
        if ((i & 16) != 0) {
            str5 = playerEntityPortable.amStartArguments;
        }
        if ((i & 32) != 0) {
            z = playerEntityPortable.killPackageProcesses;
        }
        if ((i & 64) != 0) {
            z2 = playerEntityPortable.killPackageProcessesWarning;
        }
        if ((i & 128) != 0) {
            str6 = playerEntityPortable.extra;
        }
        boolean z3 = z2;
        String str7 = str6;
        String str8 = str5;
        boolean z4 = z;
        return playerEntityPortable.copy(str, str2, str3, str4, str8, z4, z3, str7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUniqueId() {
        return this.uniqueId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAcceptedFilenameRegex() {
        return this.acceptedFilenameRegex;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAmStartArguments() {
        return this.amStartArguments;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getKillPackageProcesses() {
        return this.killPackageProcesses;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getKillPackageProcessesWarning() {
        return this.killPackageProcessesWarning;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    public final PlayerEntityPortable copy(String name, String uniqueId, String description, String acceptedFilenameRegex, String amStartArguments, boolean killPackageProcesses, boolean killPackageProcessesWarning, String extra) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(acceptedFilenameRegex, "acceptedFilenameRegex");
        Intrinsics.checkNotNullParameter(amStartArguments, "amStartArguments");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return new PlayerEntityPortable(name, uniqueId, description, acceptedFilenameRegex, amStartArguments, killPackageProcesses, killPackageProcessesWarning, extra);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayerEntityPortable)) {
            return false;
        }
        PlayerEntityPortable playerEntityPortable = (PlayerEntityPortable) other;
        return Intrinsics.areEqual(this.name, playerEntityPortable.name) && Intrinsics.areEqual(this.uniqueId, playerEntityPortable.uniqueId) && Intrinsics.areEqual(this.description, playerEntityPortable.description) && Intrinsics.areEqual(this.acceptedFilenameRegex, playerEntityPortable.acceptedFilenameRegex) && Intrinsics.areEqual(this.amStartArguments, playerEntityPortable.amStartArguments) && this.killPackageProcesses == playerEntityPortable.killPackageProcesses && this.killPackageProcessesWarning == playerEntityPortable.killPackageProcessesWarning && Intrinsics.areEqual(this.extra, playerEntityPortable.extra);
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.uniqueId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        return ((((((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.acceptedFilenameRegex.hashCode()) * 31) + this.amStartArguments.hashCode()) * 31) + Boolean.hashCode(this.killPackageProcesses)) * 31) + Boolean.hashCode(this.killPackageProcessesWarning)) * 31) + this.extra.hashCode();
    }

    public String toString() {
        return "PlayerEntityPortable(name=" + this.name + ", uniqueId=" + this.uniqueId + ", description=" + this.description + ", acceptedFilenameRegex=" + this.acceptedFilenameRegex + ", amStartArguments=" + this.amStartArguments + ", killPackageProcesses=" + this.killPackageProcesses + ", killPackageProcessesWarning=" + this.killPackageProcessesWarning + ", extra=" + this.extra + ")";
    }

    /* JADX INFO: compiled from: PlayerEntityPortable.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlayerEntityPortable$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlayerEntityPortable;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlayerEntityPortable> serializer() {
            return PlayerEntityPortable$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PlayerEntityPortable(int i, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, String str6, SerializationConstructorMarker serializationConstructorMarker) {
        this.name = (i & 1) == 0 ? "Player name" : str;
        if ((i & 2) == 0) {
            this.uniqueId = null;
        } else {
            this.uniqueId = str2;
        }
        if ((i & 4) == 0) {
            this.description = null;
        } else {
            this.description = str3;
        }
        if ((i & 8) == 0) {
            this.acceptedFilenameRegex = "^(.*)\\.(?:ext1|ext2|ext3)$";
        } else {
            this.acceptedFilenameRegex = str4;
        }
        if ((i & 16) == 0) {
            this.amStartArguments = "-a android.intent.action.VIEW\\n-n org.example.app/.AppActivity\\n-d {file.path}";
        } else {
            this.amStartArguments = str5;
        }
        if ((i & 32) == 0) {
            this.killPackageProcesses = false;
        } else {
            this.killPackageProcesses = z;
        }
        if ((i & 64) == 0) {
            this.killPackageProcessesWarning = true;
        } else {
            this.killPackageProcessesWarning = z2;
        }
        if ((i & 128) == 0) {
            this.extra = "";
        } else {
            this.extra = str6;
        }
    }

    public PlayerEntityPortable(String name, String str, String str2, String acceptedFilenameRegex, String amStartArguments, boolean z, boolean z2, String extra) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(acceptedFilenameRegex, "acceptedFilenameRegex");
        Intrinsics.checkNotNullParameter(amStartArguments, "amStartArguments");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.name = name;
        this.uniqueId = str;
        this.description = str2;
        this.acceptedFilenameRegex = acceptedFilenameRegex;
        this.amStartArguments = amStartArguments;
        this.killPackageProcesses = z;
        this.killPackageProcessesWarning = z2;
        this.extra = extra;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(PlayerEntityPortable self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.name, "Player name")) {
            output.encodeStringElement(serialDesc, 0, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.uniqueId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.uniqueId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.acceptedFilenameRegex, "^(.*)\\.(?:ext1|ext2|ext3)$")) {
            output.encodeStringElement(serialDesc, 3, self.acceptedFilenameRegex);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.amStartArguments, "-a android.intent.action.VIEW\\n-n org.example.app/.AppActivity\\n-d {file.path}")) {
            output.encodeStringElement(serialDesc, 4, self.amStartArguments);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.killPackageProcesses) {
            output.encodeBooleanElement(serialDesc, 5, self.killPackageProcesses);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !self.killPackageProcessesWarning) {
            output.encodeBooleanElement(serialDesc, 6, self.killPackageProcessesWarning);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && Intrinsics.areEqual(self.extra, "")) {
            return;
        }
        output.encodeStringElement(serialDesc, 7, self.extra);
    }

    public /* synthetic */ PlayerEntityPortable(String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Player name" : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? "^(.*)\\.(?:ext1|ext2|ext3)$" : str4, (i & 16) != 0 ? "-a android.intent.action.VIEW\\n-n org.example.app/.AppActivity\\n-d {file.path}" : str5, (i & 32) != 0 ? false : z, (i & 64) != 0 ? true : z2, (i & 128) != 0 ? "" : str6);
    }


    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }


    public final void setUniqueId(String str) {
        this.uniqueId = str;
    }


    public final void setDescription(String str) {
        this.description = str;
    }


    public final void setAcceptedFilenameRegex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.acceptedFilenameRegex = str;
    }


    public final void setAmStartArguments(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.amStartArguments = str;
    }


    public final void setKillPackageProcesses(boolean z) {
        this.killPackageProcesses = z;
    }


    public final void setKillPackageProcessesWarning(boolean z) {
        this.killPackageProcessesWarning = z;
    }


    public final void setExtra(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extra = str;
    }
}
