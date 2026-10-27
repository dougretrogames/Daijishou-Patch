package com.magneticchen.daijishou.data.db.entity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlatformEntity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\ba\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0087\u0001B§\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0014\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000f\u0012\b\b\u0002\u0010 \u001a\u00020\u0005¢\u0006\u0002\u0010!J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010b\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010+J\t\u0010c\u001a\u00020\u0005HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0003J\u000f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014HÆ\u0003J\t\u0010g\u001a\u00020\u000fHÆ\u0003J\t\u0010h\u001a\u00020\nHÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010j\u001a\u00020\u000fHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010l\u001a\u00020\nHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0014HÆ\u0003J\u000f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0003J\t\u0010p\u001a\u00020\u000fHÆ\u0003J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\t\u0010r\u001a\u00020\u0005HÆ\u0003J\t\u0010s\u001a\u00020\u0005HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010u\u001a\u00020\nHÆ\u0003J\t\u0010v\u001a\u00020\nHÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0005HÆ\u0003J°\u0002\u0010y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00032\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\n2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00142\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010zJ\u0006\u0010{\u001a\u00020\u0000J\t\u0010|\u001a\u00020\u000fHÖ\u0001J\u0013\u0010}\u001a\u00020\n2\b\u0010~\u001a\u0004\u0018\u00010\u007fHÖ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u000fHÖ\u0001J\n\u0010\u0081\u0001\u001a\u00020\u0005HÖ\u0001J\u001e\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u000fHÖ\u0001R\u001e\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R \u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%R \u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010#\"\u0004\b:\u0010%R\u001e\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010#\"\u0004\b<\u0010%R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00106\"\u0004\b>\u00108R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010?\"\u0004\b@\u0010AR$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010#\"\u0004\bG\u0010%R$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010C\"\u0004\bI\u0010ER\u001e\u0010\u001f\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010'\"\u0004\bK\u0010)R$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010C\"\u0004\bM\u0010ER\u001e\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010?\"\u0004\bO\u0010AR$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010C\"\u0004\bQ\u0010ER\u001e\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010'\"\u0004\bS\u0010)R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010#\"\u0004\bU\u0010%R \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010#\"\u0004\bW\u0010%R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010#\"\u0004\bY\u0010%R\u001e\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010?\"\u0004\b[\u0010AR\u001e\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010?\"\u0004\b]\u0010AR \u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010#\"\u0004\b_\u0010%¨\u0006\u0088\u0001"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "Landroid/os/Parcelable;", "id", "", "uniqueId", "", "name", "shortname", "description", "isVisible", "", "scrapePreviewMedia", "wallpaperPath", "thumbnailPath", "colorTheme", "", "colorOnTheme", "acceptedFilenameRegex", "defaultPlayerId", "playerIdList", "", "scraperSourceList", "boxArtAspectRatioId", "useCustomBoxArtAspectRatio", "customBoxArtAspectRatio", "screenAspectRatioId", "useCustomScreenAspectRatio", "customScreenAspectRatio", "itemsSyncTreeUriList", "Landroid/net/Uri;", "retroAchievementsConsoleIdList", "position", "extra", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;JLjava/util/List;Ljava/util/List;IZLjava/lang/String;IZLjava/lang/String;Ljava/util/List;Ljava/util/List;ILjava/lang/String;)V", "getAcceptedFilenameRegex", "()Ljava/lang/String;", "setAcceptedFilenameRegex", "(Ljava/lang/String;)V", "getBoxArtAspectRatioId", "()I", "setBoxArtAspectRatioId", "(I)V", "getColorOnTheme", "()Ljava/lang/Integer;", "setColorOnTheme", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getColorTheme", "setColorTheme", "getCustomBoxArtAspectRatio", "setCustomBoxArtAspectRatio", "getCustomScreenAspectRatio", "setCustomScreenAspectRatio", "getDefaultPlayerId", "()J", "setDefaultPlayerId", "(J)V", "getDescription", "setDescription", "getExtra", "setExtra", "getId", "setId", "()Z", "setVisible", "(Z)V", "getItemsSyncTreeUriList", "()Ljava/util/List;", "setItemsSyncTreeUriList", "(Ljava/util/List;)V", "getName", "setName", "getPlayerIdList", "setPlayerIdList", "getPosition", "setPosition", "getRetroAchievementsConsoleIdList", "setRetroAchievementsConsoleIdList", "getScrapePreviewMedia", "setScrapePreviewMedia", "getScraperSourceList", "setScraperSourceList", "getScreenAspectRatioId", "setScreenAspectRatioId", "getShortname", "setShortname", "getThumbnailPath", "setThumbnailPath", "getUniqueId", "setUniqueId", "getUseCustomBoxArtAspectRatio", "setUseCustomBoxArtAspectRatio", "getUseCustomScreenAspectRatio", "setUseCustomScreenAspectRatio", "getWallpaperPath", "setWallpaperPath", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;JLjava/util/List;Ljava/util/List;IZLjava/lang/String;IZLjava/lang/String;Ljava/util/List;Ljava/util/List;ILjava/lang/String;)Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "copyAndResetDatabaseAndDeviceDependentValues", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlatformEntity implements Parcelable {
    public static final int ICON_PREVIEW_MEDIA = 2;
    public static final int THUMBNAIL_PREVIEW_MEDIA = 1;
    public static final int WALLPAPER_PREVIEW_MEDIA = 0;
    private String acceptedFilenameRegex;
    private int boxArtAspectRatioId;
    private Integer colorOnTheme;
    private Integer colorTheme;
    private String customBoxArtAspectRatio;
    private String customScreenAspectRatio;
    private long defaultPlayerId;
    private String description;
    private String extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f30id;
    private boolean isVisible;
    private List<Uri> itemsSyncTreeUriList;
    private String name;
    private List<Long> playerIdList;
    private int position;
    private List<Long> retroAchievementsConsoleIdList;
    private boolean scrapePreviewMedia;
    private List<String> scraperSourceList;
    private int screenAspectRatioId;
    private String shortname;
    private String thumbnailPath;
    private String uniqueId;
    private boolean useCustomBoxArtAspectRatio;
    private boolean useCustomScreenAspectRatio;
    private String wallpaperPath;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<PlatformEntity> CREATOR = new Creator();

    /* JADX INFO: compiled from: PlatformEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PlatformEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlatformEntity createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            long j = parcel2.readLong();
            String string = parcel2.readString();
            String string2 = parcel2.readString();
            String string3 = parcel2.readString();
            String string4 = parcel2.readString();
            boolean z = false;
            if (parcel2.readInt() != 0) {
                z = true;
            }
            boolean z2 = parcel2.readInt() != 0;
            String string5 = parcel2.readString();
            String string6 = parcel2.readString();
            Integer numValueOf = parcel2.readInt() == 0 ? null : Integer.valueOf(parcel2.readInt());
            Integer numValueOf2 = parcel2.readInt() != 0 ? Integer.valueOf(parcel2.readInt()) : null;
            String string7 = parcel2.readString();
            long j2 = parcel2.readLong();
            int i = parcel2.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(Long.valueOf(parcel2.readLong()));
            }
            ArrayList arrayList2 = arrayList;
            ArrayList<String> arrayListCreateStringArrayList = parcel2.createStringArrayList();
            int i3 = parcel2.readInt();
            boolean z3 = parcel2.readInt() != 0;
            String string8 = parcel2.readString();
            int i4 = parcel2.readInt();
            boolean z4 = parcel2.readInt() != 0;
            String string9 = parcel2.readString();
            int i5 = parcel2.readInt();
            ArrayList arrayList3 = new ArrayList(i5);
            for (int i6 = 0; i6 != i5; i6++) {
                arrayList3.add(parcel2.readParcelable(PlatformEntity.class.getClassLoader()));
            }
            ArrayList arrayList4 = arrayList3;
            int i7 = parcel2.readInt();
            ArrayList arrayList5 = new ArrayList(i7);
            int i8 = 0;
            while (i8 != i7) {
                arrayList5.add(Long.valueOf(parcel2.readLong()));
                i8++;
                parcel2 = parcel;
            }
            return new PlatformEntity(j, string, string2, string3, string4, z, z2, string5, string6, numValueOf, numValueOf2, string7, j2, arrayList2, arrayListCreateStringArrayList, i3, z3, string8, i4, z4, string9, arrayList4, arrayList5, parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlatformEntity[] newArray(int i) {
            return new PlatformEntity[i];
        }
    }

    public PlatformEntity() {
        this(0L, null, null, null, null, false, false, null, null, null, null, null, 0L, null, null, 0, false, null, 0, false, null, null, null, 0, null, 33554431, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlatformEntity copy$default(PlatformEntity platformEntity, long j, String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, String str6, Integer num, Integer num2, String str7, long j2, List list, List list2, int i, boolean z3, String str8, int i2, boolean z4, String str9, List list3, List list4, int i3, String str10, int i4, Object obj) {
        String str11;
        int i5;
        long j3 = (i4 & 1) != 0 ? platformEntity.f30id : j;
        String str12 = (i4 & 2) != 0 ? platformEntity.uniqueId : str;
        String str13 = (i4 & 4) != 0 ? platformEntity.name : str2;
        String str14 = (i4 & 8) != 0 ? platformEntity.shortname : str3;
        String str15 = (i4 & 16) != 0 ? platformEntity.description : str4;
        boolean z5 = (i4 & 32) != 0 ? platformEntity.isVisible : z;
        boolean z6 = (i4 & 64) != 0 ? platformEntity.scrapePreviewMedia : z2;
        String str16 = (i4 & 128) != 0 ? platformEntity.wallpaperPath : str5;
        String str17 = (i4 & 256) != 0 ? platformEntity.thumbnailPath : str6;
        Integer num3 = (i4 & 512) != 0 ? platformEntity.colorTheme : num;
        Integer num4 = (i4 & CategoryWidgetViewModel.LIMIT) != 0 ? platformEntity.colorOnTheme : num2;
        String str18 = (i4 & 2048) != 0 ? platformEntity.acceptedFilenameRegex : str7;
        long j4 = (i4 & 4096) != 0 ? platformEntity.defaultPlayerId : j2;
        List list5 = (i4 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? platformEntity.playerIdList : list;
        List list6 = (i4 & 16384) != 0 ? platformEntity.scraperSourceList : list2;
        int i6 = (i4 & 32768) != 0 ? platformEntity.boxArtAspectRatioId : i;
        boolean z7 = (i4 & 65536) != 0 ? platformEntity.useCustomBoxArtAspectRatio : z3;
        String str19 = (i4 & 131072) != 0 ? platformEntity.customBoxArtAspectRatio : str8;
        int i7 = (i4 & 262144) != 0 ? platformEntity.screenAspectRatioId : i2;
        boolean z8 = (i4 & 524288) != 0 ? platformEntity.useCustomScreenAspectRatio : z4;
        String str20 = (i4 & 1048576) != 0 ? platformEntity.customScreenAspectRatio : str9;
        List list7 = (i4 & 2097152) != 0 ? platformEntity.itemsSyncTreeUriList : list3;
        List list8 = (i4 & 4194304) != 0 ? platformEntity.retroAchievementsConsoleIdList : list4;
        int i8 = (i4 & 8388608) != 0 ? platformEntity.position : i3;
        if ((i4 & 16777216) != 0) {
            i5 = i8;
            str11 = platformEntity.extra;
        } else {
            str11 = str10;
            i5 = i8;
        }
        return platformEntity.copy(j3, str12, str13, str14, str15, z5, z6, str16, str17, num3, num4, str18, j4, list5, list6, i6, z7, str19, i7, z8, str20, list7, list8, i5, str11);
    }

    public final long component1() {
        return this.f30id;
    }

    public final Integer component10() {
        return this.colorTheme;
    }

    public final Integer component11() {
        return this.colorOnTheme;
    }

    public final String component12() {
        return this.acceptedFilenameRegex;
    }

    public final long component13() {
        return this.defaultPlayerId;
    }

    public final List<Long> component14() {
        return this.playerIdList;
    }

    public final List<String> component15() {
        return this.scraperSourceList;
    }

    public final int component16() {
        return this.boxArtAspectRatioId;
    }

    public final boolean component17() {
        return this.useCustomBoxArtAspectRatio;
    }

    public final String component18() {
        return this.customBoxArtAspectRatio;
    }

    public final int component19() {
        return this.screenAspectRatioId;
    }

    public final String component2() {
        return this.uniqueId;
    }

    public final boolean component20() {
        return this.useCustomScreenAspectRatio;
    }

    public final String component21() {
        return this.customScreenAspectRatio;
    }

    public final List<Uri> component22() {
        return this.itemsSyncTreeUriList;
    }

    public final List<Long> component23() {
        return this.retroAchievementsConsoleIdList;
    }

    public final int component24() {
        return this.position;
    }

    public final String component25() {
        return this.extra;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.shortname;
    }

    public final String component5() {
        return this.description;
    }

    public final boolean component6() {
        return this.isVisible;
    }

    public final boolean component7() {
        return this.scrapePreviewMedia;
    }

    public final String component8() {
        return this.wallpaperPath;
    }

    public final String component9() {
        return this.thumbnailPath;
    }

    public final PlatformEntity copy(long j, String str, String name, String shortname, String str2, boolean z, boolean z2, String str3, String str4, Integer num, Integer num2, String acceptedFilenameRegex, long j2, List<Long> playerIdList, List<String> scraperSourceList, int i, boolean z3, String str5, int i2, boolean z4, String str6, List<Uri> itemsSyncTreeUriList, List<Long> retroAchievementsConsoleIdList, int i3, String extra) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(shortname, "shortname");
        Intrinsics.checkNotNullParameter(acceptedFilenameRegex, "acceptedFilenameRegex");
        Intrinsics.checkNotNullParameter(playerIdList, "playerIdList");
        Intrinsics.checkNotNullParameter(scraperSourceList, "scraperSourceList");
        Intrinsics.checkNotNullParameter(itemsSyncTreeUriList, "itemsSyncTreeUriList");
        Intrinsics.checkNotNullParameter(retroAchievementsConsoleIdList, "retroAchievementsConsoleIdList");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return new PlatformEntity(j, str, name, shortname, str2, z, z2, str3, str4, num, num2, acceptedFilenameRegex, j2, playerIdList, scraperSourceList, i, z3, str5, i2, z4, str6, itemsSyncTreeUriList, retroAchievementsConsoleIdList, i3, extra);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformEntity)) {
            return false;
        }
        PlatformEntity platformEntity = (PlatformEntity) obj;
        return this.f30id == platformEntity.f30id && Intrinsics.areEqual(this.uniqueId, platformEntity.uniqueId) && Intrinsics.areEqual(this.name, platformEntity.name) && Intrinsics.areEqual(this.shortname, platformEntity.shortname) && Intrinsics.areEqual(this.description, platformEntity.description) && this.isVisible == platformEntity.isVisible && this.scrapePreviewMedia == platformEntity.scrapePreviewMedia && Intrinsics.areEqual(this.wallpaperPath, platformEntity.wallpaperPath) && Intrinsics.areEqual(this.thumbnailPath, platformEntity.thumbnailPath) && Intrinsics.areEqual(this.colorTheme, platformEntity.colorTheme) && Intrinsics.areEqual(this.colorOnTheme, platformEntity.colorOnTheme) && Intrinsics.areEqual(this.acceptedFilenameRegex, platformEntity.acceptedFilenameRegex) && this.defaultPlayerId == platformEntity.defaultPlayerId && Intrinsics.areEqual(this.playerIdList, platformEntity.playerIdList) && Intrinsics.areEqual(this.scraperSourceList, platformEntity.scraperSourceList) && this.boxArtAspectRatioId == platformEntity.boxArtAspectRatioId && this.useCustomBoxArtAspectRatio == platformEntity.useCustomBoxArtAspectRatio && Intrinsics.areEqual(this.customBoxArtAspectRatio, platformEntity.customBoxArtAspectRatio) && this.screenAspectRatioId == platformEntity.screenAspectRatioId && this.useCustomScreenAspectRatio == platformEntity.useCustomScreenAspectRatio && Intrinsics.areEqual(this.customScreenAspectRatio, platformEntity.customScreenAspectRatio) && Intrinsics.areEqual(this.itemsSyncTreeUriList, platformEntity.itemsSyncTreeUriList) && Intrinsics.areEqual(this.retroAchievementsConsoleIdList, platformEntity.retroAchievementsConsoleIdList) && this.position == platformEntity.position && Intrinsics.areEqual(this.extra, platformEntity.extra);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.f30id) * 31;
        String str = this.uniqueId;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.name.hashCode()) * 31) + this.shortname.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.isVisible)) * 31) + Boolean.hashCode(this.scrapePreviewMedia)) * 31;
        String str3 = this.wallpaperPath;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.thumbnailPath;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.colorTheme;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.colorOnTheme;
        int iHashCode7 = (((((((((((((iHashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31) + this.acceptedFilenameRegex.hashCode()) * 31) + Long.hashCode(this.defaultPlayerId)) * 31) + this.playerIdList.hashCode()) * 31) + this.scraperSourceList.hashCode()) * 31) + Integer.hashCode(this.boxArtAspectRatioId)) * 31) + Boolean.hashCode(this.useCustomBoxArtAspectRatio)) * 31;
        String str5 = this.customBoxArtAspectRatio;
        int iHashCode8 = (((((iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31) + Integer.hashCode(this.screenAspectRatioId)) * 31) + Boolean.hashCode(this.useCustomScreenAspectRatio)) * 31;
        String str6 = this.customScreenAspectRatio;
        return ((((((((iHashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.itemsSyncTreeUriList.hashCode()) * 31) + this.retroAchievementsConsoleIdList.hashCode()) * 31) + Integer.hashCode(this.position)) * 31) + this.extra.hashCode();
    }

    public String toString() {
        return "PlatformEntity(id=" + this.f30id + ", uniqueId=" + this.uniqueId + ", name=" + this.name + ", shortname=" + this.shortname + ", description=" + this.description + ", isVisible=" + this.isVisible + ", scrapePreviewMedia=" + this.scrapePreviewMedia + ", wallpaperPath=" + this.wallpaperPath + ", thumbnailPath=" + this.thumbnailPath + ", colorTheme=" + this.colorTheme + ", colorOnTheme=" + this.colorOnTheme + ", acceptedFilenameRegex=" + this.acceptedFilenameRegex + ", defaultPlayerId=" + this.defaultPlayerId + ", playerIdList=" + this.playerIdList + ", scraperSourceList=" + this.scraperSourceList + ", boxArtAspectRatioId=" + this.boxArtAspectRatioId + ", useCustomBoxArtAspectRatio=" + this.useCustomBoxArtAspectRatio + ", customBoxArtAspectRatio=" + this.customBoxArtAspectRatio + ", screenAspectRatioId=" + this.screenAspectRatioId + ", useCustomScreenAspectRatio=" + this.useCustomScreenAspectRatio + ", customScreenAspectRatio=" + this.customScreenAspectRatio + ", itemsSyncTreeUriList=" + this.itemsSyncTreeUriList + ", retroAchievementsConsoleIdList=" + this.retroAchievementsConsoleIdList + ", position=" + this.position + ", extra=" + this.extra + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f30id);
        out.writeString(this.uniqueId);
        out.writeString(this.name);
        out.writeString(this.shortname);
        out.writeString(this.description);
        out.writeInt(this.isVisible ? 1 : 0);
        out.writeInt(this.scrapePreviewMedia ? 1 : 0);
        out.writeString(this.wallpaperPath);
        out.writeString(this.thumbnailPath);
        Integer num = this.colorTheme;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        Integer num2 = this.colorOnTheme;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        out.writeString(this.acceptedFilenameRegex);
        out.writeLong(this.defaultPlayerId);
        List<Long> list = this.playerIdList;
        out.writeInt(list.size());
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            out.writeLong(it.next().longValue());
        }
        out.writeStringList(this.scraperSourceList);
        out.writeInt(this.boxArtAspectRatioId);
        out.writeInt(this.useCustomBoxArtAspectRatio ? 1 : 0);
        out.writeString(this.customBoxArtAspectRatio);
        out.writeInt(this.screenAspectRatioId);
        out.writeInt(this.useCustomScreenAspectRatio ? 1 : 0);
        out.writeString(this.customScreenAspectRatio);
        List<Uri> list2 = this.itemsSyncTreeUriList;
        out.writeInt(list2.size());
        Iterator<Uri> it2 = list2.iterator();
        while (it2.hasNext()) {
            out.writeParcelable(it2.next(), i);
        }
        List<Long> list3 = this.retroAchievementsConsoleIdList;
        out.writeInt(list3.size());
        Iterator<Long> it3 = list3.iterator();
        while (it3.hasNext()) {
            out.writeLong(it3.next().longValue());
        }
        out.writeInt(this.position);
        out.writeString(this.extra);
    }

    public PlatformEntity(long j, String str, String name, String shortname, String str2, boolean z, boolean z2, String str3, String str4, Integer num, Integer num2, String acceptedFilenameRegex, long j2, List<Long> playerIdList, List<String> scraperSourceList, int i, boolean z3, String str5, int i2, boolean z4, String str6, List<Uri> itemsSyncTreeUriList, List<Long> retroAchievementsConsoleIdList, int i3, String extra) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(shortname, "shortname");
        Intrinsics.checkNotNullParameter(acceptedFilenameRegex, "acceptedFilenameRegex");
        Intrinsics.checkNotNullParameter(playerIdList, "playerIdList");
        Intrinsics.checkNotNullParameter(scraperSourceList, "scraperSourceList");
        Intrinsics.checkNotNullParameter(itemsSyncTreeUriList, "itemsSyncTreeUriList");
        Intrinsics.checkNotNullParameter(retroAchievementsConsoleIdList, "retroAchievementsConsoleIdList");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.f30id = j;
        this.uniqueId = str;
        this.name = name;
        this.shortname = shortname;
        this.description = str2;
        this.isVisible = z;
        this.scrapePreviewMedia = z2;
        this.wallpaperPath = str3;
        this.thumbnailPath = str4;
        this.colorTheme = num;
        this.colorOnTheme = num2;
        this.acceptedFilenameRegex = acceptedFilenameRegex;
        this.defaultPlayerId = j2;
        this.playerIdList = playerIdList;
        this.scraperSourceList = scraperSourceList;
        this.boxArtAspectRatioId = i;
        this.useCustomBoxArtAspectRatio = z3;
        this.customBoxArtAspectRatio = str5;
        this.screenAspectRatioId = i2;
        this.useCustomScreenAspectRatio = z4;
        this.customScreenAspectRatio = str6;
        this.itemsSyncTreeUriList = itemsSyncTreeUriList;
        this.retroAchievementsConsoleIdList = retroAchievementsConsoleIdList;
        this.position = i3;
        this.extra = extra;
    }

    public final long getId() {
        return this.f30id;
    }

    public final void setId(long j) {
        this.f30id = j;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public /* synthetic */ PlatformEntity(long j, String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, String str6, Integer num, Integer num2, String str7, long j2, List list, List list2, int i, boolean z3, String str8, int i2, boolean z4, String str9, List list3, List list4, int i3, String str10, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0L : j, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? "Platform name" : str2, (i4 & 8) != 0 ? "name" : str3, (i4 & 16) != 0 ? null : str4, (i4 & 32) != 0 ? true : z, (i4 & 64) == 0 ? z2 : true, (i4 & 128) != 0 ? null : str5, (i4 & 256) != 0 ? null : str6, (i4 & 512) != 0 ? null : num, (i4 & CategoryWidgetViewModel.LIMIT) != 0 ? null : num2, (i4 & 2048) != 0 ? "^(?!(?:\\._|\\.).*).*$" : str7, (i4 & 4096) != 0 ? 0L : j2, (i4 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? new ArrayList() : list, (i4 & 16384) != 0 ? new ArrayList() : list2, (i4 & 32768) != 0 ? 0 : i, (i4 & 65536) != 0 ? false : z3, (i4 & 131072) != 0 ? null : str8, (i4 & 262144) != 0 ? 0 : i2, (i4 & 524288) == 0 ? z4 : false, (i4 & 1048576) != 0 ? null : str9, (i4 & 2097152) != 0 ? new ArrayList() : list3, (i4 & 4194304) != 0 ? new ArrayList() : list4, (i4 & 8388608) != 0 ? -1 : i3, (i4 & 16777216) != 0 ? "" : str10);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
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

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }

    public final boolean getScrapePreviewMedia() {
        return this.scrapePreviewMedia;
    }

    public final void setScrapePreviewMedia(boolean z) {
        this.scrapePreviewMedia = z;
    }

    public final String getWallpaperPath() {
        return this.wallpaperPath;
    }

    public final void setWallpaperPath(String str) {
        this.wallpaperPath = str;
    }

    public final String getThumbnailPath() {
        return this.thumbnailPath;
    }

    public final void setThumbnailPath(String str) {
        this.thumbnailPath = str;
    }

    public final Integer getColorTheme() {
        return this.colorTheme;
    }

    public final void setColorTheme(Integer num) {
        this.colorTheme = num;
    }

    public final Integer getColorOnTheme() {
        return this.colorOnTheme;
    }

    public final void setColorOnTheme(Integer num) {
        this.colorOnTheme = num;
    }

    public final String getAcceptedFilenameRegex() {
        return this.acceptedFilenameRegex;
    }

    public final void setAcceptedFilenameRegex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.acceptedFilenameRegex = str;
    }

    public final long getDefaultPlayerId() {
        return this.defaultPlayerId;
    }

    public final void setDefaultPlayerId(long j) {
        this.defaultPlayerId = j;
    }

    public final List<Long> getPlayerIdList() {
        return this.playerIdList;
    }

    public final void setPlayerIdList(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.playerIdList = list;
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

    public final List<Uri> getItemsSyncTreeUriList() {
        return this.itemsSyncTreeUriList;
    }

    public final void setItemsSyncTreeUriList(List<Uri> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.itemsSyncTreeUriList = list;
    }

    public final List<Long> getRetroAchievementsConsoleIdList() {
        return this.retroAchievementsConsoleIdList;
    }

    public final void setRetroAchievementsConsoleIdList(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.retroAchievementsConsoleIdList = list;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final void setExtra(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extra = str;
    }

    /* JADX INFO: compiled from: PlatformEntity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity$Companion;", "", "()V", "ICON_PREVIEW_MEDIA", "", "THUMBNAIL_PREVIEW_MEDIA", "WALLPAPER_PREVIEW_MEDIA", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final PlatformEntity copyAndResetDatabaseAndDeviceDependentValues() {
        PlatformEntity platformEntityCopy$default = copy$default(this, 0L, null, null, null, null, false, false, null, null, null, null, null, 0L, null, null, 0, false, null, 0, false, null, null, null, 0, null, 33554431, null);
        platformEntityCopy$default.f30id = 0L;
        platformEntityCopy$default.wallpaperPath = null;
        platformEntityCopy$default.defaultPlayerId = 0L;
        platformEntityCopy$default.playerIdList = new ArrayList();
        platformEntityCopy$default.itemsSyncTreeUriList = new ArrayList();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(platformEntityCopy$default.scraperSourceList);
        platformEntityCopy$default.scraperSourceList = arrayList;
        return platformEntityCopy$default;
    }
}
