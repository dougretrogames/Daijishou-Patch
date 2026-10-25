package com.magneticchen.daijishou.daijishou_library_db;

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

/* JADX INFO: compiled from: PlayableItemPreviewMediaIndex.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B7\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÁ\u0001¢\u0006\u0002\b$R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006'"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemPreviewMediaIndex;", "", "seen1", "", "boxArtPath", "", "snapshotPath", "titlePath", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBoxArtPath", "()Ljava/lang/String;", "setBoxArtPath", "(Ljava/lang/String;)V", "getSnapshotPath", "setSnapshotPath", "getTitlePath", "setTitlePath", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final /* data */ class PlayableItemPreviewMediaIndex {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String boxArtPath;
    private String snapshotPath;
    private String titlePath;

    public PlayableItemPreviewMediaIndex() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PlayableItemPreviewMediaIndex copy$default(PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playableItemPreviewMediaIndex.boxArtPath;
        }
        if ((i & 2) != 0) {
            str2 = playableItemPreviewMediaIndex.snapshotPath;
        }
        if ((i & 4) != 0) {
            str3 = playableItemPreviewMediaIndex.titlePath;
        }
        return playableItemPreviewMediaIndex.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBoxArtPath() {
        return this.boxArtPath;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSnapshotPath() {
        return this.snapshotPath;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitlePath() {
        return this.titlePath;
    }

    public final PlayableItemPreviewMediaIndex copy(String boxArtPath, String snapshotPath, String titlePath) {
        return new PlayableItemPreviewMediaIndex(boxArtPath, snapshotPath, titlePath);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayableItemPreviewMediaIndex)) {
            return false;
        }
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) other;
        return Intrinsics.areEqual(this.boxArtPath, playableItemPreviewMediaIndex.boxArtPath) && Intrinsics.areEqual(this.snapshotPath, playableItemPreviewMediaIndex.snapshotPath) && Intrinsics.areEqual(this.titlePath, playableItemPreviewMediaIndex.titlePath);
    }

    public int hashCode() {
        String str = this.boxArtPath;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.snapshotPath;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.titlePath;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "PlayableItemPreviewMediaIndex(boxArtPath=" + this.boxArtPath + ", snapshotPath=" + this.snapshotPath + ", titlePath=" + this.titlePath + ")";
    }

    /* JADX INFO: compiled from: PlayableItemPreviewMediaIndex.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemPreviewMediaIndex$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemPreviewMediaIndex;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlayableItemPreviewMediaIndex> serializer() {
            return PlayableItemPreviewMediaIndex$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PlayableItemPreviewMediaIndex(int i, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.boxArtPath = null;
        } else {
            this.boxArtPath = str;
        }
        if ((i & 2) == 0) {
            this.snapshotPath = null;
        } else {
            this.snapshotPath = str2;
        }
        if ((i & 4) == 0) {
            this.titlePath = null;
        } else {
            this.titlePath = str3;
        }
    }

    public PlayableItemPreviewMediaIndex(String str, String str2, String str3) {
        this.boxArtPath = str;
        this.snapshotPath = str2;
        this.titlePath = str3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(PlayableItemPreviewMediaIndex self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.boxArtPath != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.boxArtPath);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.snapshotPath != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.snapshotPath);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.titlePath == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.titlePath);
    }

    public /* synthetic */ PlayableItemPreviewMediaIndex(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }


    public final void setBoxArtPath(String str) {
        this.boxArtPath = str;
    }


    public final void setSnapshotPath(String str) {
        this.snapshotPath = str;
    }


    public final void setTitlePath(String str) {
        this.titlePath = str;
    }
}
