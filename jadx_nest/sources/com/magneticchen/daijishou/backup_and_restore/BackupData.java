package com.magneticchen.daijishou.backup_and_restore;

import android.util.Log;
import com.magneticchen.daijishou.utils.ByteUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: BackupData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\"\u001a\u00020\u000bJ\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006%"}, d2 = {"Lcom/magneticchen/daijishou/backup_and_restore/BackupData;", "", "moduleId", "", "moduleVersion", "", "moduleRandomInt", "contentHashMapTimestamp", "", "contentHashMapKey", "content", "", "(Ljava/lang/String;IIJLjava/lang/String;[B)V", "getContent", "()[B", "getContentHashMapKey", "()Ljava/lang/String;", "getContentHashMapTimestamp", "()J", "getModuleId", "getModuleRandomInt", "()I", "getModuleVersion", "component1", "component2", "component3", "component4", "component5", "component6", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toByteArray", "toString", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class BackupData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ByteUtils byteUtils = new ByteUtils();
    private final byte[] content;
    private final String contentHashMapKey;
    private final long contentHashMapTimestamp;
    private final String moduleId;
    private final int moduleRandomInt;
    private final int moduleVersion;

    public static /* synthetic */ BackupData copy$default(BackupData backupData, String str, int i, int i2, long j, String str2, byte[] bArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = backupData.moduleId;
        }
        if ((i3 & 2) != 0) {
            i = backupData.moduleVersion;
        }
        if ((i3 & 4) != 0) {
            i2 = backupData.moduleRandomInt;
        }
        if ((i3 & 8) != 0) {
            j = backupData.contentHashMapTimestamp;
        }
        if ((i3 & 16) != 0) {
            str2 = backupData.contentHashMapKey;
        }
        if ((i3 & 32) != 0) {
            bArr = backupData.content;
        }
        long j2 = j;
        int i4 = i2;
        return backupData.copy(str, i, i4, j2, str2, bArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getModuleId() {
        return this.moduleId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getModuleVersion() {
        return this.moduleVersion;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getModuleRandomInt() {
        return this.moduleRandomInt;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getContentHashMapTimestamp() {
        return this.contentHashMapTimestamp;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getContentHashMapKey() {
        return this.contentHashMapKey;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final byte[] getContent() {
        return this.content;
    }

    public final BackupData copy(String moduleId, int moduleVersion, int moduleRandomInt, long contentHashMapTimestamp, String contentHashMapKey, byte[] content) {
        Intrinsics.checkNotNullParameter(moduleId, "moduleId");
        Intrinsics.checkNotNullParameter(contentHashMapKey, "contentHashMapKey");
        Intrinsics.checkNotNullParameter(content, "content");
        return new BackupData(moduleId, moduleVersion, moduleRandomInt, contentHashMapTimestamp, contentHashMapKey, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BackupData)) {
            return false;
        }
        BackupData backupData = (BackupData) other;
        return Intrinsics.areEqual(this.moduleId, backupData.moduleId) && this.moduleVersion == backupData.moduleVersion && this.moduleRandomInt == backupData.moduleRandomInt && this.contentHashMapTimestamp == backupData.contentHashMapTimestamp && Intrinsics.areEqual(this.contentHashMapKey, backupData.contentHashMapKey) && Intrinsics.areEqual(this.content, backupData.content);
    }

    public int hashCode() {
        return (((((((((this.moduleId.hashCode() * 31) + Integer.hashCode(this.moduleVersion)) * 31) + Integer.hashCode(this.moduleRandomInt)) * 31) + Long.hashCode(this.contentHashMapTimestamp)) * 31) + this.contentHashMapKey.hashCode()) * 31) + Arrays.hashCode(this.content);
    }

    public String toString() {
        return "BackupData(moduleId=" + this.moduleId + ", moduleVersion=" + this.moduleVersion + ", moduleRandomInt=" + this.moduleRandomInt + ", contentHashMapTimestamp=" + this.contentHashMapTimestamp + ", contentHashMapKey=" + this.contentHashMapKey + ", content=" + Arrays.toString(this.content) + ")";
    }

    public BackupData(String moduleId, int i, int i2, long j, String contentHashMapKey, byte[] content) {
        Intrinsics.checkNotNullParameter(moduleId, "moduleId");
        Intrinsics.checkNotNullParameter(contentHashMapKey, "contentHashMapKey");
        Intrinsics.checkNotNullParameter(content, "content");
        this.moduleId = moduleId;
        this.moduleVersion = i;
        this.moduleRandomInt = i2;
        this.contentHashMapTimestamp = j;
        this.contentHashMapKey = contentHashMapKey;
        this.content = content;
    }







    /* JADX INFO: compiled from: BackupData.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/magneticchen/daijishou/backup_and_restore/BackupData$Companion;", "", "()V", "byteUtils", "Lcom/magneticchen/daijishou/utils/ByteUtils;", "fromByteArray", "Lcom/magneticchen/daijishou/backup_and_restore/BackupData;", "byteArray", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BackupData fromByteArray(byte[] byteArray) {
            Intrinsics.checkNotNullParameter(byteArray, "byteArray");
            int iBytesToInt = BackupData.byteUtils.bytesToInt(ArraysKt.copyOfRange(byteArray, 0, 4));
            int i = 4 + iBytesToInt;
            String strDecodeToString = StringsKt.decodeToString(ArraysKt.copyOfRange(byteArray, 4, i));
            Log.d("BackupData", "moduleId: " + strDecodeToString);
            int i2 = iBytesToInt + 8;
            int iBytesToInt2 = BackupData.byteUtils.bytesToInt(ArraysKt.copyOfRange(byteArray, i, i2));
            Log.d("BackupData", "moduleVersion: " + iBytesToInt2);
            int i3 = iBytesToInt + 12;
            int iBytesToInt3 = BackupData.byteUtils.bytesToInt(ArraysKt.copyOfRange(byteArray, i2, i3));
            Log.d("BackupData", "moduleRandomInt: " + iBytesToInt3);
            int i4 = iBytesToInt + 20;
            long jBytesToLong = BackupData.byteUtils.bytesToLong(ArraysKt.copyOfRange(byteArray, i3, i4));
            Log.d("BackupData", "contentHashMapTimestamp: " + jBytesToLong);
            int i5 = iBytesToInt + 24;
            int iBytesToInt4 = BackupData.byteUtils.bytesToInt(ArraysKt.copyOfRange(byteArray, i4, i5));
            Log.d("BackupData", "contentHashMapKeyLength: " + iBytesToInt4);
            int i6 = iBytesToInt4 + i5;
            String strDecodeToString2 = StringsKt.decodeToString(ArraysKt.copyOfRange(byteArray, i5, i6));
            Log.d("BackupData", "contentHashMapKey: " + strDecodeToString2);
            return new BackupData(strDecodeToString, iBytesToInt2, iBytesToInt3, jBytesToLong, strDecodeToString2, ArraysKt.copyOfRange(byteArray, i6, byteArray.length));
        }
    }

    public final byte[] toByteArray() {
        ByteUtils byteUtils2 = byteUtils;
        byte[] bArrIntToBytes = byteUtils2.intToBytes(this.moduleId.length());
        byte[] bytes = this.moduleId.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrPlus = ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(bArrIntToBytes, bytes), byteUtils2.intToBytes(this.moduleVersion)), byteUtils2.intToBytes(this.moduleRandomInt)), byteUtils2.longToBytes(this.contentHashMapTimestamp)), byteUtils2.intToBytes(this.contentHashMapKey.length()));
        byte[] bytes2 = this.contentHashMapKey.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        return ArraysKt.plus(ArraysKt.plus(bArrPlus, bytes2), this.content);
    }
}
