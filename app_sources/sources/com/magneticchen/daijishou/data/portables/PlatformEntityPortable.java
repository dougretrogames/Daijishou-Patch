package com.magneticchen.daijishou.data.portables;

import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.io.ConstantsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: PlatformEntityPortable.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Z2\u00020\u0001:\u0002YZB©\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018B¥\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005¢\u0006\u0002\u0010\u0019J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u000eHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00140\u000bHÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u000eHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J©\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u0005HÆ\u0001J\u0013\u0010M\u001a\u00020\u000e2\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010O\u001a\u00020\u0003HÖ\u0001J\t\u0010P\u001a\u00020\u0005HÖ\u0001J&\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WHÁ\u0001¢\u0006\u0002\bXR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010\u001dR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010\u0011\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00109\"\u0004\b=\u0010;¨\u0006["}, d2 = {"Lcom/magneticchen/daijishou/data/portables/PlatformEntityPortable;", "", "seen1", "", "name", "", "uniqueId", "shortname", "description", "acceptedFilenameRegex", "scraperSourceList", "", "boxArtAspectRatioId", "useCustomBoxArtAspectRatio", "", "customBoxArtAspectRatio", "screenAspectRatioId", "useCustomScreenAspectRatio", "customScreenAspectRatio", "retroAchievementsConsoleIdList", "", "extra", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IZLjava/lang/String;IZLjava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IZLjava/lang/String;IZLjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getAcceptedFilenameRegex", "()Ljava/lang/String;", "setAcceptedFilenameRegex", "(Ljava/lang/String;)V", "getBoxArtAspectRatioId", "()I", "setBoxArtAspectRatioId", "(I)V", "getCustomBoxArtAspectRatio", "setCustomBoxArtAspectRatio", "getCustomScreenAspectRatio", "setCustomScreenAspectRatio", "getDescription", "setDescription", "getExtra", "setExtra", "getName", "setName", "getRetroAchievementsConsoleIdList", "()Ljava/util/List;", "setRetroAchievementsConsoleIdList", "(Ljava/util/List;)V", "getScraperSourceList", "setScraperSourceList", "getScreenAspectRatioId", "setScreenAspectRatioId", "getShortname", "setShortname", "getUniqueId", "setUniqueId", "getUseCustomBoxArtAspectRatio", "()Z", "setUseCustomBoxArtAspectRatio", "(Z)V", "getUseCustomScreenAspectRatio", "setUseCustomScreenAspectRatio", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final class PlatformEntityPortable {
    private String acceptedFilenameRegex;
    private int boxArtAspectRatioId;
    private String customBoxArtAspectRatio;
    private String customScreenAspectRatio;
    private String description;
    private String extra;
    private String name;
    private List<Long> retroAchievementsConsoleIdList;
    private List<String> scraperSourceList;
    private int screenAspectRatioId;
    private String shortname;
    private String uniqueId;
    private boolean useCustomBoxArtAspectRatio;
    private boolean useCustomScreenAspectRatio;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, null, null, new ArrayListSerializer(LongSerializer.INSTANCE), null};

    public PlatformEntityPortable() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 0, false, (String) null, 0, false, (String) null, (List) null, (String) null, 16383, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.name;
    }

    public final int component10() {
        return this.screenAspectRatioId;
    }

    public final boolean component11() {
        return this.useCustomScreenAspectRatio;
    }

    public final String component12() {
        return this.customScreenAspectRatio;
    }

    public final List<Long> component13() {
        return this.retroAchievementsConsoleIdList;
    }

    public final String component14() {
        return this.extra;
    }

    public final String component2() {
        return this.uniqueId;
    }

    public final String component3() {
        return this.shortname;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.acceptedFilenameRegex;
    }

    public final List<String> component6() {
        return this.scraperSourceList;
    }

    public final int component7() {
        return this.boxArtAspectRatioId;
    }

    public final boolean component8() {
        return this.useCustomBoxArtAspectRatio;
    }

    public final String component9() {
        return this.customBoxArtAspectRatio;
    }

    public final PlatformEntityPortable copy(String name, String str, String shortname, String str2, String acceptedFilenameRegex, List<String> scraperSourceList, int i, boolean z, String str3, int i2, boolean z2, String str4, List<Long> retroAchievementsConsoleIdList, String extra) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(shortname, "shortname");
        Intrinsics.checkNotNullParameter(acceptedFilenameRegex, "acceptedFilenameRegex");
        Intrinsics.checkNotNullParameter(scraperSourceList, "scraperSourceList");
        Intrinsics.checkNotNullParameter(retroAchievementsConsoleIdList, "retroAchievementsConsoleIdList");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return new PlatformEntityPortable(name, str, shortname, str2, acceptedFilenameRegex, scraperSourceList, i, z, str3, i2, z2, str4, retroAchievementsConsoleIdList, extra);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformEntityPortable)) {
            return false;
        }
        PlatformEntityPortable platformEntityPortable = (PlatformEntityPortable) obj;
        return Intrinsics.areEqual(this.name, platformEntityPortable.name) && Intrinsics.areEqual(this.uniqueId, platformEntityPortable.uniqueId) && Intrinsics.areEqual(this.shortname, platformEntityPortable.shortname) && Intrinsics.areEqual(this.description, platformEntityPortable.description) && Intrinsics.areEqual(this.acceptedFilenameRegex, platformEntityPortable.acceptedFilenameRegex) && Intrinsics.areEqual(this.scraperSourceList, platformEntityPortable.scraperSourceList) && this.boxArtAspectRatioId == platformEntityPortable.boxArtAspectRatioId && this.useCustomBoxArtAspectRatio == platformEntityPortable.useCustomBoxArtAspectRatio && Intrinsics.areEqual(this.customBoxArtAspectRatio, platformEntityPortable.customBoxArtAspectRatio) && this.screenAspectRatioId == platformEntityPortable.screenAspectRatioId && this.useCustomScreenAspectRatio == platformEntityPortable.useCustomScreenAspectRatio && Intrinsics.areEqual(this.customScreenAspectRatio, platformEntityPortable.customScreenAspectRatio) && Intrinsics.areEqual(this.retroAchievementsConsoleIdList, platformEntityPortable.retroAchievementsConsoleIdList) && Intrinsics.areEqual(this.extra, platformEntityPortable.extra);
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.uniqueId;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.shortname.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode3 = (((((((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.acceptedFilenameRegex.hashCode()) * 31) + this.scraperSourceList.hashCode()) * 31) + Integer.hashCode(this.boxArtAspectRatioId)) * 31) + Boolean.hashCode(this.useCustomBoxArtAspectRatio)) * 31;
        String str3 = this.customBoxArtAspectRatio;
        int iHashCode4 = (((((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Integer.hashCode(this.screenAspectRatioId)) * 31) + Boolean.hashCode(this.useCustomScreenAspectRatio)) * 31;
        String str4 = this.customScreenAspectRatio;
        return ((((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.retroAchievementsConsoleIdList.hashCode()) * 31) + this.extra.hashCode();
    }

    public String toString() {
        return "PlatformEntityPortable(name=" + this.name + ", uniqueId=" + this.uniqueId + ", shortname=" + this.shortname + ", description=" + this.description + ", acceptedFilenameRegex=" + this.acceptedFilenameRegex + ", scraperSourceList=" + this.scraperSourceList + ", boxArtAspectRatioId=" + this.boxArtAspectRatioId + ", useCustomBoxArtAspectRatio=" + this.useCustomBoxArtAspectRatio + ", customBoxArtAspectRatio=" + this.customBoxArtAspectRatio + ", screenAspectRatioId=" + this.screenAspectRatioId + ", useCustomScreenAspectRatio=" + this.useCustomScreenAspectRatio + ", customScreenAspectRatio=" + this.customScreenAspectRatio + ", retroAchievementsConsoleIdList=" + this.retroAchievementsConsoleIdList + ", extra=" + this.extra + ")";
    }

    /* JADX INFO: compiled from: PlatformEntityPortable.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/data/portables/PlatformEntityPortable$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/data/portables/PlatformEntityPortable;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlatformEntityPortable> serializer() {
            return PlatformEntityPortable$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PlatformEntityPortable(int i, String str, String str2, String str3, String str4, String str5, List list, int i2, boolean z, String str6, int i3, boolean z2, String str7, List list2, String str8, SerializationConstructorMarker serializationConstructorMarker) {
        this.name = (i & 1) == 0 ? "Platform name" : str;
        if ((i & 2) == 0) {
            this.uniqueId = null;
        } else {
            this.uniqueId = str2;
        }
        if ((i & 4) == 0) {
            this.shortname = "name";
        } else {
            this.shortname = str3;
        }
        if ((i & 8) == 0) {
            this.description = null;
        } else {
            this.description = str4;
        }
        if ((i & 16) == 0) {
            this.acceptedFilenameRegex = "^(?!(?:\\._|\\.).*).*$";
        } else {
            this.acceptedFilenameRegex = str5;
        }
        if ((i & 32) == 0) {
            this.scraperSourceList = new ArrayList();
        } else {
            this.scraperSourceList = list;
        }
        if ((i & 64) == 0) {
            this.boxArtAspectRatioId = 0;
        } else {
            this.boxArtAspectRatioId = i2;
        }
        if ((i & 128) == 0) {
            this.useCustomBoxArtAspectRatio = false;
        } else {
            this.useCustomBoxArtAspectRatio = z;
        }
        if ((i & 256) == 0) {
            this.customBoxArtAspectRatio = null;
        } else {
            this.customBoxArtAspectRatio = str6;
        }
        if ((i & 512) == 0) {
            this.screenAspectRatioId = 0;
        } else {
            this.screenAspectRatioId = i3;
        }
        if ((i & CategoryWidgetViewModel.LIMIT) == 0) {
            this.useCustomScreenAspectRatio = false;
        } else {
            this.useCustomScreenAspectRatio = z2;
        }
        if ((i & 2048) == 0) {
            this.customScreenAspectRatio = null;
        } else {
            this.customScreenAspectRatio = str7;
        }
        if ((i & 4096) == 0) {
            this.retroAchievementsConsoleIdList = new ArrayList();
        } else {
            this.retroAchievementsConsoleIdList = list2;
        }
        this.extra = (i & ConstantsKt.DEFAULT_BUFFER_SIZE) == 0 ? "" : str8;
    }

    public PlatformEntityPortable(String name, String str, String shortname, String str2, String acceptedFilenameRegex, List<String> scraperSourceList, int i, boolean z, String str3, int i2, boolean z2, String str4, List<Long> retroAchievementsConsoleIdList, String extra) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(shortname, "shortname");
        Intrinsics.checkNotNullParameter(acceptedFilenameRegex, "acceptedFilenameRegex");
        Intrinsics.checkNotNullParameter(scraperSourceList, "scraperSourceList");
        Intrinsics.checkNotNullParameter(retroAchievementsConsoleIdList, "retroAchievementsConsoleIdList");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.name = name;
        this.uniqueId = str;
        this.shortname = shortname;
        this.description = str2;
        this.acceptedFilenameRegex = acceptedFilenameRegex;
        this.scraperSourceList = scraperSourceList;
        this.boxArtAspectRatioId = i;
        this.useCustomBoxArtAspectRatio = z;
        this.customBoxArtAspectRatio = str3;
        this.screenAspectRatioId = i2;
        this.useCustomScreenAspectRatio = z2;
        this.customScreenAspectRatio = str4;
        this.retroAchievementsConsoleIdList = retroAchievementsConsoleIdList;
        this.extra = extra;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(PlatformEntityPortable platformEntityPortable, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || !Intrinsics.areEqual(platformEntityPortable.name, "Platform name")) {
            compositeEncoder.encodeStringElement(serialDescriptor, 0, platformEntityPortable.name);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || platformEntityPortable.uniqueId != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, platformEntityPortable.uniqueId);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual(platformEntityPortable.shortname, "name")) {
            compositeEncoder.encodeStringElement(serialDescriptor, 2, platformEntityPortable.shortname);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || platformEntityPortable.description != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, platformEntityPortable.description);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || !Intrinsics.areEqual(platformEntityPortable.acceptedFilenameRegex, "^(?!(?:\\._|\\.).*).*$")) {
            compositeEncoder.encodeStringElement(serialDescriptor, 4, platformEntityPortable.acceptedFilenameRegex);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || !Intrinsics.areEqual(platformEntityPortable.scraperSourceList, new ArrayList())) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 5, serializationStrategyArr[5], platformEntityPortable.scraperSourceList);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || platformEntityPortable.boxArtAspectRatioId != 0) {
            compositeEncoder.encodeIntElement(serialDescriptor, 6, platformEntityPortable.boxArtAspectRatioId);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) || platformEntityPortable.useCustomBoxArtAspectRatio) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 7, platformEntityPortable.useCustomBoxArtAspectRatio);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) || platformEntityPortable.customBoxArtAspectRatio != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, platformEntityPortable.customBoxArtAspectRatio);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) || platformEntityPortable.screenAspectRatioId != 0) {
            compositeEncoder.encodeIntElement(serialDescriptor, 9, platformEntityPortable.screenAspectRatioId);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 10) || platformEntityPortable.useCustomScreenAspectRatio) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 10, platformEntityPortable.useCustomScreenAspectRatio);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 11) || platformEntityPortable.customScreenAspectRatio != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, platformEntityPortable.customScreenAspectRatio);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 12) || !Intrinsics.areEqual(platformEntityPortable.retroAchievementsConsoleIdList, new ArrayList())) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 12, serializationStrategyArr[12], platformEntityPortable.retroAchievementsConsoleIdList);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 13) && Intrinsics.areEqual(platformEntityPortable.extra, "")) {
            return;
        }
        compositeEncoder.encodeStringElement(serialDescriptor, 13, platformEntityPortable.extra);
    }

    public /* synthetic */ PlatformEntityPortable(String str, String str2, String str3, String str4, String str5, List list, int i, boolean z, String str6, int i2, boolean z2, String str7, List list2, String str8, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "Platform name" : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? "name" : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? "^(?!(?:\\._|\\.).*).*$" : str5, (i3 & 32) != 0 ? new ArrayList() : list, (i3 & 64) != 0 ? 0 : i, (i3 & 128) != 0 ? false : z, (i3 & 256) != 0 ? null : str6, (i3 & 512) != 0 ? 0 : i2, (i3 & CategoryWidgetViewModel.LIMIT) == 0 ? z2 : false, (i3 & 2048) == 0 ? str7 : null, (i3 & 4096) != 0 ? new ArrayList() : list2, (i3 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? "" : str8);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public final String getShortname() {
        return this.shortname;
    }

    public final void setShortname(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shortname = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final String getAcceptedFilenameRegex() {
        return this.acceptedFilenameRegex;
    }

    public final void setAcceptedFilenameRegex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.acceptedFilenameRegex = str;
    }

    public final List<String> getScraperSourceList() {
        return this.scraperSourceList;
    }

    public final void setScraperSourceList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.scraperSourceList = list;
    }

    public final int getBoxArtAspectRatioId() {
        return this.boxArtAspectRatioId;
    }

    public final void setBoxArtAspectRatioId(int i) {
        this.boxArtAspectRatioId = i;
    }

    public final boolean getUseCustomBoxArtAspectRatio() {
        return this.useCustomBoxArtAspectRatio;
    }

    public final void setUseCustomBoxArtAspectRatio(boolean z) {
        this.useCustomBoxArtAspectRatio = z;
    }

    public final String getCustomBoxArtAspectRatio() {
        return this.customBoxArtAspectRatio;
    }

    public final void setCustomBoxArtAspectRatio(String str) {
        this.customBoxArtAspectRatio = str;
    }

    public final int getScreenAspectRatioId() {
        return this.screenAspectRatioId;
    }

    public final void setScreenAspectRatioId(int i) {
        this.screenAspectRatioId = i;
    }

    public final boolean getUseCustomScreenAspectRatio() {
        return this.useCustomScreenAspectRatio;
    }

    public final void setUseCustomScreenAspectRatio(boolean z) {
        this.useCustomScreenAspectRatio = z;
    }

    public final String getCustomScreenAspectRatio() {
        return this.customScreenAspectRatio;
    }

    public final void setCustomScreenAspectRatio(String str) {
        this.customScreenAspectRatio = str;
    }

    public final List<Long> getRetroAchievementsConsoleIdList() {
        return this.retroAchievementsConsoleIdList;
    }

    public final void setRetroAchievementsConsoleIdList(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.retroAchievementsConsoleIdList = list;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final void setExtra(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extra = str;
    }
}
