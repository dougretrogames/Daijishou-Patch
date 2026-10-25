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

/* JADX INFO: compiled from: FavoriteItemsShareable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eHÁ\u0001¢\u0006\u0002\b\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/portables/FavoriteItemsShareable;", "", "seen1", "", "databaseVersion", "playableItemLazyMd5List", "", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILjava/util/List;)V", "getDatabaseVersion", "()I", "getPlayableItemLazyMd5List", "()Ljava/util/List;", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final /* data */ class FavoriteItemsShareable {
    private final int databaseVersion;
    private final List<String> playableItemLazyMd5List;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final KSerializer[] $childSerializers = {null, new ArrayListSerializer(StringSerializer.INSTANCE)};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FavoriteItemsShareable copy$default(FavoriteItemsShareable favoriteItemsShareable, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = favoriteItemsShareable.databaseVersion;
        }
        if ((i2 & 2) != 0) {
            list = favoriteItemsShareable.playableItemLazyMd5List;
        }
        return favoriteItemsShareable.copy(i, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDatabaseVersion() {
        return this.databaseVersion;
    }

    public final List<String> component2() {
        return this.playableItemLazyMd5List;
    }

    public final FavoriteItemsShareable copy(int databaseVersion, List<String> playableItemLazyMd5List) {
        Intrinsics.checkNotNullParameter(playableItemLazyMd5List, "playableItemLazyMd5List");
        return new FavoriteItemsShareable(databaseVersion, playableItemLazyMd5List);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FavoriteItemsShareable)) {
            return false;
        }
        FavoriteItemsShareable favoriteItemsShareable = (FavoriteItemsShareable) other;
        return this.databaseVersion == favoriteItemsShareable.databaseVersion && Intrinsics.areEqual(this.playableItemLazyMd5List, favoriteItemsShareable.playableItemLazyMd5List);
    }

    public int hashCode() {
        return (Integer.hashCode(this.databaseVersion) * 31) + this.playableItemLazyMd5List.hashCode();
    }

    public String toString() {
        return "FavoriteItemsShareable(databaseVersion=" + this.databaseVersion + ", playableItemLazyMd5List=" + this.playableItemLazyMd5List + ")";
    }

    /* JADX INFO: compiled from: FavoriteItemsShareable.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/portables/FavoriteItemsShareable$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/FavoriteItemsShareable;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<FavoriteItemsShareable> serializer() {
            return FavoriteItemsShareable$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ FavoriteItemsShareable(int i, int i2, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, FavoriteItemsShareable$$serializer.INSTANCE.getDescriptor());
        }
        this.databaseVersion = i2;
        this.playableItemLazyMd5List = list;
    }

    public FavoriteItemsShareable(int i, List<String> playableItemLazyMd5List) {
        Intrinsics.checkNotNullParameter(playableItemLazyMd5List, "playableItemLazyMd5List");
        this.databaseVersion = i;
        this.playableItemLazyMd5List = playableItemLazyMd5List;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(FavoriteItemsShareable self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.databaseVersion);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.playableItemLazyMd5List);
    }


    public final List<String> getPlayableItemLazyMd5List() {
        return this.playableItemLazyMd5List;
    }
}
