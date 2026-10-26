package com.magneticchen.daijishou.daijishou_library_db;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: PlatformEntity.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b]\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u0083\u00012\u00020\u0001:\u0002\u0083\u0001B\u009d\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0014\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005¢\u0006\u0002\u0010 J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010_\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010*J\t\u0010`\u001a\u00020\u0005HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0003J\u000f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014HÆ\u0003J\t\u0010d\u001a\u00020\u000fHÆ\u0003J\t\u0010e\u001a\u00020\nHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010g\u001a\u00020\u000fHÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010i\u001a\u00020\nHÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0014HÆ\u0003J\u000f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0003J\t\u0010m\u001a\u00020\u0005HÆ\u0003J\t\u0010n\u001a\u00020\u0005HÆ\u0003J\t\u0010o\u001a\u00020\u0005HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010q\u001a\u00020\nHÆ\u0003J\t\u0010r\u001a\u00020\nHÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¦\u0002\u0010u\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00032\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\n2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00142\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010vJ\u0006\u0010w\u001a\u00020\u0000J\t\u0010x\u001a\u00020\u000fHÖ\u0001J\u0013\u0010y\u001a\u00020\n2\b\u0010z\u001a\u0004\u0018\u00010{HÖ\u0003J\t\u0010|\u001a\u00020\u000fHÖ\u0001J\t\u0010}\u001a\u00020\u0005HÖ\u0001J\u001c\u0010~\u001a\u00020\u007f2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020\u000fHÖ\u0001R\u001e\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R \u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\"\"\u0004\b1\u0010$R \u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$R\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\"\"\u0004\b9\u0010$R\u001e\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\"\"\u0004\b;\u0010$R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00105\"\u0004\b=\u00107R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010>\"\u0004\b?\u0010@R$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\"\"\u0004\bF\u0010$R$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010B\"\u0004\bH\u0010DR$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010B\"\u0004\bJ\u0010DR\u001e\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@R$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010B\"\u0004\bN\u0010DR\u001e\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010&\"\u0004\bP\u0010(R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\"\"\u0004\bR\u0010$R \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\"\"\u0004\bT\u0010$R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\"\"\u0004\bV\u0010$R\u001e\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010>\"\u0004\bX\u0010@R\u001e\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010>\"\u0004\bZ\u0010@R \u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\"\"\u0004\b\\\u0010$¨\u0006\u0084\u0001"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "Landroid/os/Parcelable;", "id", "", "uniqueId", "", "name", "shortname", "description", "isVisible", "", "scrapePreviewMedia", "wallpaperPath", "thumbnailPath", "colorTheme", "", "colorOnTheme", "acceptedFilenameRegex", "defaultPlayerId", "playerIdList", "", "scraperSourceList", "boxArtAspectRatioId", "useCustomBoxArtAspectRatio", "customBoxArtAspectRatio", "screenAspectRatioId", "useCustomScreenAspectRatio", "customScreenAspectRatio", "itemsSyncTreeUriList", "Landroid/net/Uri;", "retroAchievementsConsoleIdList", "extra", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;JLjava/util/List;Ljava/util/List;IZLjava/lang/String;IZLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getAcceptedFilenameRegex", "()Ljava/lang/String;", "setAcceptedFilenameRegex", "(Ljava/lang/String;)V", "getBoxArtAspectRatioId", "()I", "setBoxArtAspectRatioId", "(I)V", "getColorOnTheme", "()Ljava/lang/Integer;", "setColorOnTheme", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getColorTheme", "setColorTheme", "getCustomBoxArtAspectRatio", "setCustomBoxArtAspectRatio", "getCustomScreenAspectRatio", "setCustomScreenAspectRatio", "getDefaultPlayerId", "()J", "setDefaultPlayerId", "(J)V", "getDescription", "setDescription", "getExtra", "setExtra", "getId", "setId", "()Z", "setVisible", "(Z)V", "getItemsSyncTreeUriList", "()Ljava/util/List;", "setItemsSyncTreeUriList", "(Ljava/util/List;)V", "getName", "setName", "getPlayerIdList", "setPlayerIdList", "getRetroAchievementsConsoleIdList", "setRetroAchievementsConsoleIdList", "getScrapePreviewMedia", "setScrapePreviewMedia", "getScraperSourceList", "setScraperSourceList", "getScreenAspectRatioId", "setScreenAspectRatioId", "getShortname", "setShortname", "getThumbnailPath", "setThumbnailPath", "getUniqueId", "setUniqueId", "getUseCustomBoxArtAspectRatio", "setUseCustomBoxArtAspectRatio", "getUseCustomScreenAspectRatio", "setUseCustomScreenAspectRatio", "getWallpaperPath", "setWallpaperPath", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;JLjava/util/List;Ljava/util/List;IZLjava/lang/String;IZLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "copyAndResetDatabaseAndDeviceDependentValues", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PlatformEntity implements Parcelable {
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
    private long id;
    private boolean isVisible;
    private List<Uri> itemsSyncTreeUriList;
    private String name;
    private List<Long> playerIdList;
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
    public static final Parcelable.Creator<PlatformEntity> CREATOR = new Creator();

    /* INFO: compiled from: PlatformEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PlatformEntity> {
        /* WARN: Can't rename method to resolve collision */
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
            return new PlatformEntity(j, string, string2, string3, string4, z, z2, string5, string6, numValueOf, numValueOf2, string7, j2, arrayList2, arrayListCreateStringArrayList, i3, z3, string8, i4, z4, string9, arrayList4, arrayList5, parcel.readString());
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlatformEntity[] newArray(int i) {
            return new PlatformEntity[i];
        }
    }

    public PlatformEntity() {
        this(0L, null, null, null, null, false, false, null, null, null, null, null, 0L, null, null, 0, false, null, 0, false, null, null, null, null, ViewCompat.MEASURED_SIZE_MASK, null);
    }

    /* WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlatformEntity copy$default(PlatformEntity platformEntity, long j, String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, String str6, Integer num, Integer num2, String str7, long j2, List list, List list2, int i, boolean z3, String str8, int i2, boolean z4, String str9, List list3, List list4, String str10, int i3, Object obj) {
        String str11;
        List list5;
        long j3 = (i3 & 1) != 0 ? platformEntity.id : j;
        String str12 = (i3 & 2) != 0 ? platformEntity.uniqueId : str;
        String str13 = (i3 & 4) != 0 ? platformEntity.name : str2;
        String str14 = (i3 & 8) != 0 ? platformEntity.shortname : str3;
        String str15 = (i3 & 16) != 0 ? platformEntity.description : str4;
        boolean z5 = (i3 & 32) != 0 ? platformEntity.isVisible : z;
        boolean z6 = (i3 & 64) != 0 ? platformEntity.scrapePreviewMedia : z2;
        String str16 = (i3 & 128) != 0 ? platformEntity.wallpaperPath : str5;
        String str17 = (i3 & 256) != 0 ? platformEntity.thumbnailPath : str6;
        Integer num3 = (i3 & 512) != 0 ? platformEntity.colorTheme : num;
        Integer num4 = (i3 & 1024) != 0 ? platformEntity.colorOnTheme : num2;
        String str18 = (i3 & 2048) != 0 ? platformEntity.acceptedFilenameRegex : str7;
        long j4 = (i3 & 4096) != 0 ? platformEntity.defaultPlayerId : j2;
        List list6 = (i3 & 8192) != 0 ? platformEntity.playerIdList : list;
        List list7 = (i3 & 16384) != 0 ? platformEntity.scraperSourceList : list2;
        int i4 = (i3 & 32768) != 0 ? platformEntity.boxArtAspectRatioId : i;
        boolean z7 = (i3 & 65536) != 0 ? platformEntity.useCustomBoxArtAspectRatio : z3;
        String str19 = (i3 & 131072) != 0 ? platformEntity.customBoxArtAspectRatio : str8;
        int i5 = (i3 & 262144) != 0 ? platformEntity.screenAspectRatioId : i2;
        boolean z8 = (i3 & 524288) != 0 ? platformEntity.useCustomScreenAspectRatio : z4;
        String str20 = (i3 & 1048576) != 0 ? platformEntity.customScreenAspectRatio : str9;
        List list8 = (i3 & 2097152) != 0 ? platformEntity.itemsSyncTreeUriList : list3;
        List list9 = (i3 & 4194304) != 0 ? platformEntity.retroAchievementsConsoleIdList : list4;
        if ((i3 & 8388608) != 0) {
            list5 = list9;
            str11 = platformEntity.extra;
        } else {
            str11 = str10;
            list5 = list9;
        }
        return platformEntity.copy(j3, str12, str13, str14, str15, z5, z6, str16, str17, num3, num4, str18, j4, list6, list7, i4, z7, str19, i5, z8, str20, list8, list5, str11);
    }

    /* INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* INFO: renamed from: component10, reason: from getter */
    public final Integer getColorTheme() {
        return this.colorTheme;
    }

    /* INFO: renamed from: component11, reason: from getter */
    public final Integer getColorOnTheme() {
        return this.colorOnTheme;
    }

    /* INFO: renamed from: component12, reason: from getter */
    public final String getAcceptedFilenameRegex() {
        return this.acceptedFilenameRegex;
    }

    /* INFO: renamed from: component13, reason: from getter */
    public final long getDefaultPlayerId() {
        return this.defaultPlayerId;
    }

    public final List<Long> component14() {
        return this.playerIdList;
    }

    public final List<String> component15() {
        return this.scraperSourceList;
    }

    /* INFO: renamed from: component16, reason: from getter */
    public final int getBoxArtAspectRatioId() {
        return this.boxArtAspectRatioId;
    }

    /* INFO: renamed from: component17, reason: from getter */
    public final boolean getUseCustomBoxArtAspectRatio() {
        return this.useCustomBoxArtAspectRatio;
    }

    /* INFO: renamed from: component18, reason: from getter */
    public final String getCustomBoxArtAspectRatio() {
        return this.customBoxArtAspectRatio;
    }

    /* INFO: renamed from: component19, reason: from getter */
    public final int getScreenAspectRatioId() {
        return this.screenAspectRatioId;
    }

    /* INFO: renamed from: component2, reason: from getter */
    public final String getUniqueId() {
        return this.uniqueId;
    }

    /* INFO: renamed from: component20, reason: from getter */
    public final boolean getUseCustomScreenAspectRatio() {
        return this.useCustomScreenAspectRatio;
    }

    /* INFO: renamed from: component21, reason: from getter */
    public final String getCustomScreenAspectRatio() {
        return this.customScreenAspectRatio;
    }

    public final List<Uri> component22() {
        return this.itemsSyncTreeUriList;
    }

    public final List<Long> component23() {
        return this.retroAchievementsConsoleIdList;
    }

    /* INFO: renamed from: component24, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    /* INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* INFO: renamed from: component4, reason: from getter */
    public final String getShortname() {
        return this.shortname;
    }

    /* INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* INFO: renamed from: component6, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    /* INFO: renamed from: component7, reason: from getter */
    public final boolean getScrapePreviewMedia() {
        return this.scrapePreviewMedia;
    }

    /* INFO: renamed from: component8, reason: from getter */
    public final String getWallpaperPath() {
        return this.wallpaperPath;
    }

    /* INFO: renamed from: component9, reason: from getter */
    public final String getThumbnailPath() {
        return this.thumbnailPath;
    }

    public final PlatformEntity copy(long id2, String uniqueId, String name, String shortname, String description, boolean isVisible, boolean scrapePreviewMedia, String wallpaperPath, String thumbnailPath, Integer colorTheme, Integer colorOnTheme, String acceptedFilenameRegex, long defaultPlayerId, List<Long> playerIdList, List<String> scraperSourceList, int boxArtAspectRatioId, boolean useCustomBoxArtAspectRatio, String customBoxArtAspectRatio, int screenAspectRatioId, boolean useCustomScreenAspectRatio, String customScreenAspectRatio, List<Uri> itemsSyncTreeUriList, List<Long> retroAchievementsConsoleIdList, String extra) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(shortname, "shortname");
        Intrinsics.checkNotNullParameter(acceptedFilenameRegex, "acceptedFilenameRegex");
        Intrinsics.checkNotNullParameter(playerIdList, "playerIdList");
        Intrinsics.checkNotNullParameter(scraperSourceList, "scraperSourceList");
        Intrinsics.checkNotNullParameter(itemsSyncTreeUriList, "itemsSyncTreeUriList");
        Intrinsics.checkNotNullParameter(retroAchievementsConsoleIdList, "retroAchievementsConsoleIdList");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return new PlatformEntity(id2, uniqueId, name, shortname, description, isVisible, scrapePreviewMedia, wallpaperPath, thumbnailPath, colorTheme, colorOnTheme, acceptedFilenameRegex, defaultPlayerId, playerIdList, scraperSourceList, boxArtAspectRatioId, useCustomBoxArtAspectRatio, customBoxArtAspectRatio, screenAspectRatioId, useCustomScreenAspectRatio, customScreenAspectRatio, itemsSyncTreeUriList, retroAchievementsConsoleIdList, extra);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlatformEntity)) {
            return false;
        }
        PlatformEntity platformEntity = (PlatformEntity) other;
        return this.id == platformEntity.id && Intrinsics.areEqual(this.uniqueId, platformEntity.uniqueId) && Intrinsics.areEqual(this.name, platformEntity.name) && Intrinsics.areEqual(this.shortname, platformEntity.shortname) && Intrinsics.areEqual(this.description, platformEntity.description) && this.isVisible == platformEntity.isVisible && this.scrapePreviewMedia == platformEntity.scrapePreviewMedia && Intrinsics.areEqual(this.wallpaperPath, platformEntity.wallpaperPath) && Intrinsics.areEqual(this.thumbnailPath, platformEntity.thumbnailPath) && Intrinsics.areEqual(this.colorTheme, platformEntity.colorTheme) && Intrinsics.areEqual(this.colorOnTheme, platformEntity.colorOnTheme) && Intrinsics.areEqual(this.acceptedFilenameRegex, platformEntity.acceptedFilenameRegex) && this.defaultPlayerId == platformEntity.defaultPlayerId && Intrinsics.areEqual(this.playerIdList, platformEntity.playerIdList) && Intrinsics.areEqual(this.scraperSourceList, platformEntity.scraperSourceList) && this.boxArtAspectRatioId == platformEntity.boxArtAspectRatioId && this.useCustomBoxArtAspectRatio == platformEntity.useCustomBoxArtAspectRatio && Intrinsics.areEqual(this.customBoxArtAspectRatio, platformEntity.customBoxArtAspectRatio) && this.screenAspectRatioId == platformEntity.screenAspectRatioId && this.useCustomScreenAspectRatio == platformEntity.useCustomScreenAspectRatio && Intrinsics.areEqual(this.customScreenAspectRatio, platformEntity.customScreenAspectRatio) && Intrinsics.areEqual(this.itemsSyncTreeUriList, platformEntity.itemsSyncTreeUriList) && Intrinsics.areEqual(this.retroAchievementsConsoleIdList, platformEntity.retroAchievementsConsoleIdList) && Intrinsics.areEqual(this.extra, platformEntity.extra);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.id) * 31;
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
        return ((((((iHashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.itemsSyncTreeUriList.hashCode()) * 31) + this.retroAchievementsConsoleIdList.hashCode()) * 31) + this.extra.hashCode();
    }

    public String toString() {
        return "PlatformEntity(id=" + this.id + ", uniqueId=" + this.uniqueId + ", name=" + this.name + ", shortname=" + this.shortname + ", description=" + this.description + ", isVisible=" + this.isVisible + ", scrapePreviewMedia=" + this.scrapePreviewMedia + ", wallpaperPath=" + this.wallpaperPath + ", thumbnailPath=" + this.thumbnailPath + ", colorTheme=" + this.colorTheme + ", colorOnTheme=" + this.colorOnTheme + ", acceptedFilenameRegex=" + this.acceptedFilenameRegex + ", defaultPlayerId=" + this.defaultPlayerId + ", playerIdList=" + this.playerIdList + ", scraperSourceList=" + this.scraperSourceList + ", boxArtAspectRatioId=" + this.boxArtAspectRatioId + ", useCustomBoxArtAspectRatio=" + this.useCustomBoxArtAspectRatio + ", customBoxArtAspectRatio=" + this.customBoxArtAspectRatio + ", screenAspectRatioId=" + this.screenAspectRatioId + ", useCustomScreenAspectRatio=" + this.useCustomScreenAspectRatio + ", customScreenAspectRatio=" + this.customScreenAspectRatio + ", itemsSyncTreeUriList=" + this.itemsSyncTreeUriList + ", retroAchievementsConsoleIdList=" + this.retroAchievementsConsoleIdList + ", extra=" + this.extra + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        parcel.writeString(this.uniqueId);
        parcel.writeString(this.name);
        parcel.writeString(this.shortname);
        parcel.writeString(this.description);
        parcel.writeInt(this.isVisible ? 1 : 0);
        parcel.writeInt(this.scrapePreviewMedia ? 1 : 0);
        parcel.writeString(this.wallpaperPath);
        parcel.writeString(this.thumbnailPath);
        Integer num = this.colorTheme;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.colorOnTheme;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.acceptedFilenameRegex);
        parcel.writeLong(this.defaultPlayerId);
        List<Long> list = this.playerIdList;
        parcel.writeInt(list.size());
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeLong(it.next().longValue());
        }
        parcel.writeStringList(this.scraperSourceList);
        parcel.writeInt(this.boxArtAspectRatioId);
        parcel.writeInt(this.useCustomBoxArtAspectRatio ? 1 : 0);
        parcel.writeString(this.customBoxArtAspectRatio);
        parcel.writeInt(this.screenAspectRatioId);
        parcel.writeInt(this.useCustomScreenAspectRatio ? 1 : 0);
        parcel.writeString(this.customScreenAspectRatio);
        List<Uri> list2 = this.itemsSyncTreeUriList;
        parcel.writeInt(list2.size());
        Iterator<Uri> it2 = list2.iterator();
        while (it2.hasNext()) {
            parcel.writeParcelable(it2.next(), flags);
        }
        List<Long> list3 = this.retroAchievementsConsoleIdList;
        parcel.writeInt(list3.size());
        Iterator<Long> it3 = list3.iterator();
        while (it3.hasNext()) {
            parcel.writeLong(it3.next().longValue());
        }
        parcel.writeString(this.extra);
    }

    public PlatformEntity(long j, String str, String name, String shortname, String str2, boolean z, boolean z2, String str3, String str4, Integer num, Integer num2, String acceptedFilenameRegex, long j2, List<Long> playerIdList, List<String> scraperSourceList, int i, boolean z3, String str5, int i2, boolean z4, String str6, List<Uri> itemsSyncTreeUriList, List<Long> retroAchievementsConsoleIdList, String extra) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(shortname, "shortname");
        Intrinsics.checkNotNullParameter(acceptedFilenameRegex, "acceptedFilenameRegex");
        Intrinsics.checkNotNullParameter(playerIdList, "playerIdList");
        Intrinsics.checkNotNullParameter(scraperSourceList, "scraperSourceList");
        Intrinsics.checkNotNullParameter(itemsSyncTreeUriList, "itemsSyncTreeUriList");
        Intrinsics.checkNotNullParameter(retroAchievementsConsoleIdList, "retroAchievementsConsoleIdList");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.id = j;
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
        this.extra = extra;
    }


    public final void setId(long j) {
        this.id = j;
    }


    public final void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public /* synthetic */ PlatformEntity(long j, String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, String str6, Integer num, Integer num2, String str7, long j2, List list, List list2, int i, boolean z3, String str8, int i2, boolean z4, String str9, List list3, List list4, String str10, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? "Platform name" : str2, (i3 & 8) != 0 ? "name" : str3, (i3 & 16) != 0 ? null : str4, (i3 & 32) != 0 ? true : z, (i3 & 64) == 0 ? z2 : true, (i3 & 128) != 0 ? null : str5, (i3 & 256) != 0 ? null : str6, (i3 & 512) != 0 ? null : num, (i3 & 1024) != 0 ? null : num2, (i3 & 2048) != 0 ? "^(?!(?:\\._|\\.).*).*$" : str7, (i3 & 4096) != 0 ? 0L : j2, (i3 & 8192) != 0 ? new ArrayList() : list, (i3 & 16384) != 0 ? new ArrayList() : list2, (i3 & 32768) != 0 ? 0 : i, (i3 & 65536) != 0 ? false : z3, (i3 & 131072) != 0 ? null : str8, (i3 & 262144) != 0 ? 0 : i2, (i3 & 524288) == 0 ? z4 : false, (i3 & 1048576) != 0 ? null : str9, (i3 & 2097152) != 0 ? new ArrayList() : list3, (i3 & 4194304) != 0 ? new ArrayList() : list4, (i3 & 8388608) != 0 ? "" : str10);
    }


    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }


    public final void setShortname(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shortname = str;
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


    public final void setScrapePreviewMedia(boolean z) {
        this.scrapePreviewMedia = z;
    }


    public final void setWallpaperPath(String str) {
        this.wallpaperPath = str;
    }


    public final void setThumbnailPath(String str) {
        this.thumbnailPath = str;
    }


    public final void setColorTheme(Integer num) {
        this.colorTheme = num;
    }


    public final void setColorOnTheme(Integer num) {
        this.colorOnTheme = num;
    }


    public final void setAcceptedFilenameRegex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.acceptedFilenameRegex = str;
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


    public final void setBoxArtAspectRatioId(int i) {
        this.boxArtAspectRatioId = i;
    }


    public final void setUseCustomBoxArtAspectRatio(boolean z) {
        this.useCustomBoxArtAspectRatio = z;
    }


    public final void setCustomBoxArtAspectRatio(String str) {
        this.customBoxArtAspectRatio = str;
    }


    public final void setScreenAspectRatioId(int i) {
        this.screenAspectRatioId = i;
    }


    public final void setUseCustomScreenAspectRatio(boolean z) {
        this.useCustomScreenAspectRatio = z;
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


    public final void setExtra(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extra = str;
    }

    public final PlatformEntity copyAndResetDatabaseAndDeviceDependentValues() {
        PlatformEntity platformEntityCopy$default = copy$default(this, 0L, null, null, null, null, false, false, null, null, null, null, null, 0L, null, null, 0, false, null, 0, false, null, null, null, null, ViewCompat.MEASURED_SIZE_MASK, null);
        platformEntityCopy$default.id = 0L;
        platformEntityCopy$default.wallpaperPath = null;
        platformEntityCopy$default.defaultPlayerId = 0L;
        platformEntityCopy$default.playerIdList = new ArrayList();
        ArrayList arrayList = new ArrayList();
        platformEntityCopy$default.scraperSourceList = arrayList;
        arrayList.addAll(this.scraperSourceList);
        platformEntityCopy$default.itemsSyncTreeUriList = new ArrayList();
        return platformEntityCopy$default;
    }
}
