package com.magneticchen.daijishou.daijishou_library_db;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: PlayableItemEntity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bf\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u0090\u00012\u00020\u0001:\u0002\u0090\u0001B\u009d\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010#\u001a\u00020\r¢\u0006\u0002\u0010$J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\u000f\u0010i\u001a\b\u0012\u0004\u0012\u00020\r0\u0011HÆ\u0003J\t\u0010j\u001a\u00020\u0007HÆ\u0003J\t\u0010k\u001a\u00020\u0007HÆ\u0003J\t\u0010l\u001a\u00020\u0007HÆ\u0003J\t\u0010m\u001a\u00020\u0007HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\t\u0010p\u001a\u00020\u0019HÆ\u0003J\t\u0010q\u001a\u00020\u0019HÆ\u0003J\t\u0010r\u001a\u00020\rHÆ\u0003J\t\u0010s\u001a\u00020\u0005HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010u\u001a\u00020\u0007HÆ\u0003J\u0010\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\t\u0010w\u001a\u00020\u000bHÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010!HÆ\u0003J\t\u0010y\u001a\u00020!HÆ\u0003J\t\u0010z\u001a\u00020\rHÆ\u0003J\t\u0010{\u001a\u00020\u0007HÆ\u0003J\t\u0010|\u001a\u00020\u0007HÆ\u0003J\u0010\u0010}\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\t\u0010~\u001a\u00020\u000bHÆ\u0003J\t\u0010\u007f\u001a\u00020\rHÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003J¨\u0002\u0010\u0082\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001d\u001a\u00020\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\rHÆ\u0001¢\u0006\u0003\u0010\u0083\u0001J\u0007\u0010\u0084\u0001\u001a\u00020\u0000J\n\u0010\u0085\u0001\u001a\u00020\u000bHÖ\u0001J\u0016\u0010\u0086\u0001\u001a\u00020\u00072\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001HÖ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u000bHÖ\u0001J\n\u0010\u008a\u0001\u001a\u00020\rHÖ\u0001J\u001e\u0010\u008b\u0001\u001a\u00030\u008c\u00012\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u008f\u0001\u001a\u00020\u000bHÖ\u0001R \u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R \u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010&\"\u0004\b5\u0010(R\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b6\u0010.\"\u0004\b7\u00100R\u001e\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010#\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010&\"\u0004\b=\u0010(R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u00109\"\u0004\bB\u0010;R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u00109\"\u0004\bC\u0010;R\u001e\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u00109\"\u0004\bD\u0010;R\u001e\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u00109\"\u0004\bE\u0010;R \u0010 \u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010*\"\u0004\bG\u0010,R\u001e\u0010\u001b\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010&\"\u0004\bI\u0010(R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010&\"\u0004\bO\u0010(R\u001e\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010Q\"\u0004\bU\u0010SR \u0010\u0016\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010&\"\u0004\bW\u0010(R\u001e\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00109\"\u0004\bY\u0010;R$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001e\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010_\"\u0004\bc\u0010aR\u001e\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u00109\"\u0004\be\u0010;R\u001e\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u00109\"\u0004\bg\u0010;¨\u0006\u0091\u0001"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "Landroid/os/Parcelable;", "id", "", "mergedInfo", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntityMergedInfo;", "isInSingletonDisjointSet", "", "useDisjointSetPrimaryPlayableItem", "disjointSetPrimaryPlayableItemId", "playableItemType", "", "name", "", "doScrapeName", "description", "scraperKeywordList", "", "scrapeScraperKeywords", "isFavorite", "isSearchable", "isVisible", "previewMediaPath", "attachedPlatformId", "uri", "Landroid/net/Uri;", "syncTreeUri", "md5", "activityComponentString", "useCustomPlayer", "customPlayerId", "playCount", "lastPlayedTimestamp", "Ljava/util/Date;", "addedDateTimestamp", "extra", "(JLcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntityMergedInfo;ZZLjava/lang/Long;ILjava/lang/String;ZLjava/lang/String;Ljava/util/List;ZZZZLjava/lang/String;Ljava/lang/Long;Landroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;ILjava/util/Date;Ljava/util/Date;Ljava/lang/String;)V", "getActivityComponentString", "()Ljava/lang/String;", "setActivityComponentString", "(Ljava/lang/String;)V", "getAddedDateTimestamp", "()Ljava/util/Date;", "setAddedDateTimestamp", "(Ljava/util/Date;)V", "getAttachedPlatformId", "()Ljava/lang/Long;", "setAttachedPlatformId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCustomPlayerId", "setCustomPlayerId", "getDescription", "setDescription", "getDisjointSetPrimaryPlayableItemId", "setDisjointSetPrimaryPlayableItemId", "getDoScrapeName", "()Z", "setDoScrapeName", "(Z)V", "getExtra", "setExtra", "getId", "()J", "setId", "(J)V", "setFavorite", "setInSingletonDisjointSet", "setSearchable", "setVisible", "getLastPlayedTimestamp", "setLastPlayedTimestamp", "getMd5", "setMd5", "getMergedInfo", "()Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntityMergedInfo;", "setMergedInfo", "(Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntityMergedInfo;)V", "getName", "setName", "getPlayCount", "()I", "setPlayCount", "(I)V", "getPlayableItemType", "setPlayableItemType", "getPreviewMediaPath", "setPreviewMediaPath", "getScrapeScraperKeywords", "setScrapeScraperKeywords", "getScraperKeywordList", "()Ljava/util/List;", "setScraperKeywordList", "(Ljava/util/List;)V", "getSyncTreeUri", "()Landroid/net/Uri;", "setSyncTreeUri", "(Landroid/net/Uri;)V", "getUri", "setUri", "getUseCustomPlayer", "setUseCustomPlayer", "getUseDisjointSetPrimaryPlayableItem", "setUseDisjointSetPrimaryPlayableItem", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "(JLcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntityMergedInfo;ZZLjava/lang/Long;ILjava/lang/String;ZLjava/lang/String;Ljava/util/List;ZZZZLjava/lang/String;Ljava/lang/Long;Landroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;ILjava/util/Date;Ljava/util/Date;Ljava/lang/String;)Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "copyAndResetDatabaseAndDeviceDependentValues", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PlayableItemEntity implements Parcelable {
    public static final int ACTIVITY_PLAYABLE_ITEM = 2;
    public static final int DAIJISHOU_PLAYER_TEMPLATE_PLAYABLE_ITEM = 3;
    public static final int FILE_PLAYABLE_ITEM = 1;
    private String activityComponentString;
    private Date addedDateTimestamp;
    private Long attachedPlatformId;
    private Long customPlayerId;
    private String description;
    private Long disjointSetPrimaryPlayableItemId;
    private boolean doScrapeName;
    private String extra;
    private long id;
    private boolean isFavorite;
    private boolean isInSingletonDisjointSet;
    private boolean isSearchable;
    private boolean isVisible;
    private Date lastPlayedTimestamp;
    private String md5;
    private PlayableItemEntityMergedInfo mergedInfo;
    private String name;
    private int playCount;
    private int playableItemType;
    private String previewMediaPath;
    private boolean scrapeScraperKeywords;
    private List<String> scraperKeywordList;
    private Uri syncTreeUri;
    private Uri uri;
    private boolean useCustomPlayer;
    private boolean useDisjointSetPrimaryPlayableItem;
    public static final Parcelable.Creator<PlayableItemEntity> CREATOR = new Creator();

    /* JADX INFO: compiled from: PlayableItemEntity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PlayableItemEntity> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayableItemEntity createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long j = parcel.readLong();
            PlayableItemEntityMergedInfo playableItemEntityMergedInfoCreateFromParcel = PlayableItemEntityMergedInfo.CREATOR.createFromParcel(parcel);
            boolean z5 = true;
            boolean z6 = false;
            if (parcel.readInt() == 0) {
                z5 = false;
            }
            if (parcel.readInt() != 0) {
                z6 = true;
            }
            Long lValueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            int i = parcel.readInt();
            String string = parcel.readString();
            if (parcel.readInt() != 0) {
                z = false;
                z2 = z5;
            } else {
                z = z6;
                z2 = z;
            }
            String string2 = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            boolean z7 = parcel.readInt() != 0 ? z5 : z;
            if (parcel.readInt() != 0) {
                z3 = z;
                z4 = z5;
            } else {
                z3 = z;
                z4 = z3;
            }
            boolean z8 = parcel.readInt() != 0 ? z5 : z3;
            if (parcel.readInt() != 0) {
                z3 = z5;
            }
            Long lValueOf2 = null;
            String string3 = parcel.readString();
            Long lValueOf3 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Uri uri = (Uri) parcel.readParcelable(PlayableItemEntity.class.getClassLoader());
            Uri uri2 = (Uri) parcel.readParcelable(PlayableItemEntity.class.getClassLoader());
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            if (parcel.readInt() != 0) {
                z3 = true;
            }
            if (parcel.readInt() != 0) {
                lValueOf2 = Long.valueOf(parcel.readLong());
            }
            return new PlayableItemEntity(j, playableItemEntityMergedInfoCreateFromParcel, z5, z6, lValueOf, i, string, z2, string2, arrayListCreateStringArrayList, z7, z4, z8, z3, string3, lValueOf3, uri, uri2, string4, string5, z3, lValueOf2, parcel.readInt(), (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlayableItemEntity[] newArray(int i) {
            return new PlayableItemEntity[i];
        }
    }

    public PlayableItemEntity() {
        this(0L, null, false, false, null, 0, null, false, null, null, false, false, false, false, null, null, null, null, null, null, false, null, 0, null, null, null, 67108863, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlayableItemEntity copy$default(PlayableItemEntity playableItemEntity, long j, PlayableItemEntityMergedInfo playableItemEntityMergedInfo, boolean z, boolean z2, Long l, int i, String str, boolean z3, String str2, List list, boolean z4, boolean z5, boolean z6, boolean z7, String str3, Long l2, Uri uri, Uri uri2, String str4, String str5, boolean z8, Long l3, int i2, Date date, Date date2, String str6, int i3, Object obj) {
        String str7;
        Date date3;
        long j2 = (i3 & 1) != 0 ? playableItemEntity.id : j;
        PlayableItemEntityMergedInfo playableItemEntityMergedInfo2 = (i3 & 2) != 0 ? playableItemEntity.mergedInfo : playableItemEntityMergedInfo;
        boolean z9 = (i3 & 4) != 0 ? playableItemEntity.isInSingletonDisjointSet : z;
        boolean z10 = (i3 & 8) != 0 ? playableItemEntity.useDisjointSetPrimaryPlayableItem : z2;
        Long l4 = (i3 & 16) != 0 ? playableItemEntity.disjointSetPrimaryPlayableItemId : l;
        int i4 = (i3 & 32) != 0 ? playableItemEntity.playableItemType : i;
        String str8 = (i3 & 64) != 0 ? playableItemEntity.name : str;
        boolean z11 = (i3 & 128) != 0 ? playableItemEntity.doScrapeName : z3;
        String str9 = (i3 & 256) != 0 ? playableItemEntity.description : str2;
        List list2 = (i3 & 512) != 0 ? playableItemEntity.scraperKeywordList : list;
        boolean z12 = (i3 & 1024) != 0 ? playableItemEntity.scrapeScraperKeywords : z4;
        boolean z13 = (i3 & 2048) != 0 ? playableItemEntity.isFavorite : z5;
        boolean z14 = (i3 & 4096) != 0 ? playableItemEntity.isSearchable : z6;
        long j3 = j2;
        boolean z15 = (i3 & 8192) != 0 ? playableItemEntity.isVisible : z7;
        String str10 = (i3 & 16384) != 0 ? playableItemEntity.previewMediaPath : str3;
        Long l5 = (i3 & 32768) != 0 ? playableItemEntity.attachedPlatformId : l2;
        Uri uri3 = (i3 & 65536) != 0 ? playableItemEntity.uri : uri;
        Uri uri4 = (i3 & 131072) != 0 ? playableItemEntity.syncTreeUri : uri2;
        String str11 = (i3 & 262144) != 0 ? playableItemEntity.md5 : str4;
        String str12 = (i3 & 524288) != 0 ? playableItemEntity.activityComponentString : str5;
        boolean z16 = (i3 & 1048576) != 0 ? playableItemEntity.useCustomPlayer : z8;
        Long l6 = (i3 & 2097152) != 0 ? playableItemEntity.customPlayerId : l3;
        int i5 = (i3 & 4194304) != 0 ? playableItemEntity.playCount : i2;
        Date date4 = (i3 & 8388608) != 0 ? playableItemEntity.lastPlayedTimestamp : date;
        Date date5 = (i3 & 16777216) != 0 ? playableItemEntity.addedDateTimestamp : date2;
        if ((i3 & MediaHttpDownloader.MAXIMUM_CHUNK_SIZE) != 0) {
            date3 = date5;
            str7 = playableItemEntity.extra;
        } else {
            str7 = str6;
            date3 = date5;
        }
        return playableItemEntity.copy(j3, playableItemEntityMergedInfo2, z9, z10, l4, i4, str8, z11, str9, list2, z12, z13, z14, z15, str10, l5, uri3, uri4, str11, str12, z16, l6, i5, date4, date3, str7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final List<String> component10() {
        return this.scraperKeywordList;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getScrapeScraperKeywords() {
        return this.scrapeScraperKeywords;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsFavorite() {
        return this.isFavorite;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsSearchable() {
        return this.isSearchable;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getPreviewMediaPath() {
        return this.previewMediaPath;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Long getAttachedPlatformId() {
        return this.attachedPlatformId;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Uri getSyncTreeUri() {
        return this.syncTreeUri;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PlayableItemEntityMergedInfo getMergedInfo() {
        return this.mergedInfo;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getActivityComponentString() {
        return this.activityComponentString;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getUseCustomPlayer() {
        return this.useCustomPlayer;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final Long getCustomPlayerId() {
        return this.customPlayerId;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final int getPlayCount() {
        return this.playCount;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Date getLastPlayedTimestamp() {
        return this.lastPlayedTimestamp;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final Date getAddedDateTimestamp() {
        return this.addedDateTimestamp;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsInSingletonDisjointSet() {
        return this.isInSingletonDisjointSet;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getUseDisjointSetPrimaryPlayableItem() {
        return this.useDisjointSetPrimaryPlayableItem;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getDisjointSetPrimaryPlayableItemId() {
        return this.disjointSetPrimaryPlayableItemId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getPlayableItemType() {
        return this.playableItemType;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getDoScrapeName() {
        return this.doScrapeName;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final PlayableItemEntity copy(long id2, PlayableItemEntityMergedInfo mergedInfo, boolean isInSingletonDisjointSet, boolean useDisjointSetPrimaryPlayableItem, Long disjointSetPrimaryPlayableItemId, int playableItemType, String name, boolean doScrapeName, String description, List<String> scraperKeywordList, boolean scrapeScraperKeywords, boolean isFavorite, boolean isSearchable, boolean isVisible, String previewMediaPath, Long attachedPlatformId, Uri uri, Uri syncTreeUri, String md5, String activityComponentString, boolean useCustomPlayer, Long customPlayerId, int playCount, Date lastPlayedTimestamp, Date addedDateTimestamp, String extra) {
        Intrinsics.checkNotNullParameter(mergedInfo, "mergedInfo");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(scraperKeywordList, "scraperKeywordList");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(syncTreeUri, "syncTreeUri");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(addedDateTimestamp, "addedDateTimestamp");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return new PlayableItemEntity(id2, mergedInfo, isInSingletonDisjointSet, useDisjointSetPrimaryPlayableItem, disjointSetPrimaryPlayableItemId, playableItemType, name, doScrapeName, description, scraperKeywordList, scrapeScraperKeywords, isFavorite, isSearchable, isVisible, previewMediaPath, attachedPlatformId, uri, syncTreeUri, md5, activityComponentString, useCustomPlayer, customPlayerId, playCount, lastPlayedTimestamp, addedDateTimestamp, extra);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayableItemEntity)) {
            return false;
        }
        PlayableItemEntity playableItemEntity = (PlayableItemEntity) other;
        return this.id == playableItemEntity.id && Intrinsics.areEqual(this.mergedInfo, playableItemEntity.mergedInfo) && this.isInSingletonDisjointSet == playableItemEntity.isInSingletonDisjointSet && this.useDisjointSetPrimaryPlayableItem == playableItemEntity.useDisjointSetPrimaryPlayableItem && Intrinsics.areEqual(this.disjointSetPrimaryPlayableItemId, playableItemEntity.disjointSetPrimaryPlayableItemId) && this.playableItemType == playableItemEntity.playableItemType && Intrinsics.areEqual(this.name, playableItemEntity.name) && this.doScrapeName == playableItemEntity.doScrapeName && Intrinsics.areEqual(this.description, playableItemEntity.description) && Intrinsics.areEqual(this.scraperKeywordList, playableItemEntity.scraperKeywordList) && this.scrapeScraperKeywords == playableItemEntity.scrapeScraperKeywords && this.isFavorite == playableItemEntity.isFavorite && this.isSearchable == playableItemEntity.isSearchable && this.isVisible == playableItemEntity.isVisible && Intrinsics.areEqual(this.previewMediaPath, playableItemEntity.previewMediaPath) && Intrinsics.areEqual(this.attachedPlatformId, playableItemEntity.attachedPlatformId) && Intrinsics.areEqual(this.uri, playableItemEntity.uri) && Intrinsics.areEqual(this.syncTreeUri, playableItemEntity.syncTreeUri) && Intrinsics.areEqual(this.md5, playableItemEntity.md5) && Intrinsics.areEqual(this.activityComponentString, playableItemEntity.activityComponentString) && this.useCustomPlayer == playableItemEntity.useCustomPlayer && Intrinsics.areEqual(this.customPlayerId, playableItemEntity.customPlayerId) && this.playCount == playableItemEntity.playCount && Intrinsics.areEqual(this.lastPlayedTimestamp, playableItemEntity.lastPlayedTimestamp) && Intrinsics.areEqual(this.addedDateTimestamp, playableItemEntity.addedDateTimestamp) && Intrinsics.areEqual(this.extra, playableItemEntity.extra);
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.id) * 31) + this.mergedInfo.hashCode()) * 31) + Boolean.hashCode(this.isInSingletonDisjointSet)) * 31) + Boolean.hashCode(this.useDisjointSetPrimaryPlayableItem)) * 31;
        Long l = this.disjointSetPrimaryPlayableItemId;
        int iHashCode2 = (((((((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + Integer.hashCode(this.playableItemType)) * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.doScrapeName)) * 31;
        String str = this.description;
        int iHashCode3 = (((((((((((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.scraperKeywordList.hashCode()) * 31) + Boolean.hashCode(this.scrapeScraperKeywords)) * 31) + Boolean.hashCode(this.isFavorite)) * 31) + Boolean.hashCode(this.isSearchable)) * 31) + Boolean.hashCode(this.isVisible)) * 31;
        String str2 = this.previewMediaPath;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l2 = this.attachedPlatformId;
        int iHashCode5 = (((((((iHashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31) + this.uri.hashCode()) * 31) + this.syncTreeUri.hashCode()) * 31) + this.md5.hashCode()) * 31;
        String str3 = this.activityComponentString;
        int iHashCode6 = (((iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.useCustomPlayer)) * 31;
        Long l3 = this.customPlayerId;
        int iHashCode7 = (((iHashCode6 + (l3 == null ? 0 : l3.hashCode())) * 31) + Integer.hashCode(this.playCount)) * 31;
        Date date = this.lastPlayedTimestamp;
        return ((((iHashCode7 + (date != null ? date.hashCode() : 0)) * 31) + this.addedDateTimestamp.hashCode()) * 31) + this.extra.hashCode();
    }

    public String toString() {
        return "PlayableItemEntity(id=" + this.id + ", mergedInfo=" + this.mergedInfo + ", isInSingletonDisjointSet=" + this.isInSingletonDisjointSet + ", useDisjointSetPrimaryPlayableItem=" + this.useDisjointSetPrimaryPlayableItem + ", disjointSetPrimaryPlayableItemId=" + this.disjointSetPrimaryPlayableItemId + ", playableItemType=" + this.playableItemType + ", name=" + this.name + ", doScrapeName=" + this.doScrapeName + ", description=" + this.description + ", scraperKeywordList=" + this.scraperKeywordList + ", scrapeScraperKeywords=" + this.scrapeScraperKeywords + ", isFavorite=" + this.isFavorite + ", isSearchable=" + this.isSearchable + ", isVisible=" + this.isVisible + ", previewMediaPath=" + this.previewMediaPath + ", attachedPlatformId=" + this.attachedPlatformId + ", uri=" + this.uri + ", syncTreeUri=" + this.syncTreeUri + ", md5=" + this.md5 + ", activityComponentString=" + this.activityComponentString + ", useCustomPlayer=" + this.useCustomPlayer + ", customPlayerId=" + this.customPlayerId + ", playCount=" + this.playCount + ", lastPlayedTimestamp=" + this.lastPlayedTimestamp + ", addedDateTimestamp=" + this.addedDateTimestamp + ", extra=" + this.extra + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        this.mergedInfo.writeToParcel(parcel, flags);
        parcel.writeInt(this.isInSingletonDisjointSet ? 1 : 0);
        parcel.writeInt(this.useDisjointSetPrimaryPlayableItem ? 1 : 0);
        Long l = this.disjointSetPrimaryPlayableItemId;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeInt(this.playableItemType);
        parcel.writeString(this.name);
        parcel.writeInt(this.doScrapeName ? 1 : 0);
        parcel.writeString(this.description);
        parcel.writeStringList(this.scraperKeywordList);
        parcel.writeInt(this.scrapeScraperKeywords ? 1 : 0);
        parcel.writeInt(this.isFavorite ? 1 : 0);
        parcel.writeInt(this.isSearchable ? 1 : 0);
        parcel.writeInt(this.isVisible ? 1 : 0);
        parcel.writeString(this.previewMediaPath);
        Long l2 = this.attachedPlatformId;
        if (l2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        }
        parcel.writeParcelable(this.uri, flags);
        parcel.writeParcelable(this.syncTreeUri, flags);
        parcel.writeString(this.md5);
        parcel.writeString(this.activityComponentString);
        parcel.writeInt(this.useCustomPlayer ? 1 : 0);
        Long l3 = this.customPlayerId;
        if (l3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l3.longValue());
        }
        parcel.writeInt(this.playCount);
        parcel.writeSerializable(this.lastPlayedTimestamp);
        parcel.writeSerializable(this.addedDateTimestamp);
        parcel.writeString(this.extra);
    }

    public PlayableItemEntity(long j, PlayableItemEntityMergedInfo mergedInfo, boolean z, boolean z2, Long l, int i, String name, boolean z3, String str, List<String> scraperKeywordList, boolean z4, boolean z5, boolean z6, boolean z7, String str2, Long l2, Uri uri, Uri syncTreeUri, String md5, String str3, boolean z8, Long l3, int i2, Date date, Date addedDateTimestamp, String extra) {
        Intrinsics.checkNotNullParameter(mergedInfo, "mergedInfo");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(scraperKeywordList, "scraperKeywordList");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(syncTreeUri, "syncTreeUri");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(addedDateTimestamp, "addedDateTimestamp");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.id = j;
        this.mergedInfo = mergedInfo;
        this.isInSingletonDisjointSet = z;
        this.useDisjointSetPrimaryPlayableItem = z2;
        this.disjointSetPrimaryPlayableItemId = l;
        this.playableItemType = i;
        this.name = name;
        this.doScrapeName = z3;
        this.description = str;
        this.scraperKeywordList = scraperKeywordList;
        this.scrapeScraperKeywords = z4;
        this.isFavorite = z5;
        this.isSearchable = z6;
        this.isVisible = z7;
        this.previewMediaPath = str2;
        this.attachedPlatformId = l2;
        this.uri = uri;
        this.syncTreeUri = syncTreeUri;
        this.md5 = md5;
        this.activityComponentString = str3;
        this.useCustomPlayer = z8;
        this.customPlayerId = l3;
        this.playCount = i2;
        this.lastPlayedTimestamp = date;
        this.addedDateTimestamp = addedDateTimestamp;
        this.extra = extra;
    }


    public final void setId(long j) {
        this.id = j;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PlayableItemEntity(long j, PlayableItemEntityMergedInfo playableItemEntityMergedInfo, boolean z, boolean z2, Long l, int i, String str, boolean z3, String str2, List list, boolean z4, boolean z5, boolean z6, boolean z7, String str3, Long l2, Uri uri, Uri uri2, String str4, String str5, boolean z8, Long l3, int i2, Date date, Date date2, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j,
                (i3 & 2) != 0 ? new PlayableItemEntityMergedInfo(null, null, null, false, false, false, false, false, false, 0, null, null, 4095, null) : playableItemEntityMergedInfo,
                (i3 & 4) != 0 ? true : z,
                (i3 & 8) != 0 ? false : z2,
                (i3 & 16) != 0 ? null : l,
                (i3 & 32) != 0 ? 1 : i,
                (i3 & 64) != 0 ? "Item name" : str,
                (i3 & 128) != 0 ? true : z3,
                (i3 & 256) != 0 ? null : str2,
                (i3 & 512) != 0 ? new ArrayList() : list,
                (i3 & 1024) != 0 ? true : z4,
                (i3 & 2048) != 0 ? false : z5,
                (i3 & 4096) != 0 ? true : z6,
                (i3 & 8192) != 0 ? true : z7,
                (i3 & 16384) != 0 ? null : str3,
                (32768 & i3) != 0 ? null : l2,
                (i3 & 65536) != 0 ? Uri.EMPTY : uri,
                (i3 & 131072) != 0 ? Uri.EMPTY : uri2,
                (i3 & 262144) != 0 ? "" : str4,
                (i3 & 524288) != 0 ? null : str5,
                (i3 & 1048576) != 0 ? false : z8,
                (i3 & 2097152) != 0 ? null : l3,
                (i3 & 4194304) != 0 ? 0 : i2,
                (i3 & 8388608) != 0 ? null : date,
                (i3 & 16777216) != 0 ? new Date() : date2,
                (i3 & MediaHttpDownloader.MAXIMUM_CHUNK_SIZE) != 0 ? "" : str6);
    }


    public final void setMergedInfo(PlayableItemEntityMergedInfo playableItemEntityMergedInfo) {
        Intrinsics.checkNotNullParameter(playableItemEntityMergedInfo, "<set-?>");
        this.mergedInfo = playableItemEntityMergedInfo;
    }

    public final boolean isInSingletonDisjointSet() {
        return this.isInSingletonDisjointSet;
    }

    public final void setInSingletonDisjointSet(boolean z) {
        this.isInSingletonDisjointSet = z;
    }


    public final void setUseDisjointSetPrimaryPlayableItem(boolean z) {
        this.useDisjointSetPrimaryPlayableItem = z;
    }


    public final void setDisjointSetPrimaryPlayableItemId(Long l) {
        this.disjointSetPrimaryPlayableItemId = l;
    }


    public final void setPlayableItemType(int i) {
        this.playableItemType = i;
    }


    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }


    public final void setDoScrapeName(boolean z) {
        this.doScrapeName = z;
    }


    public final void setDescription(String str) {
        this.description = str;
    }

    public final List<String> getScraperKeywordList() {
        return this.scraperKeywordList;
    }

    public final void setScraperKeywordList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.scraperKeywordList = list;
    }


    public final void setScrapeScraperKeywords(boolean z) {
        this.scrapeScraperKeywords = z;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    public final void setFavorite(boolean z) {
        this.isFavorite = z;
    }

    public final boolean isSearchable() {
        return this.isSearchable;
    }

    public final void setSearchable(boolean z) {
        this.isSearchable = z;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }


    public final void setPreviewMediaPath(String str) {
        this.previewMediaPath = str;
    }


    public final void setAttachedPlatformId(Long l) {
        this.attachedPlatformId = l;
    }


    public final void setUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<set-?>");
        this.uri = uri;
    }


    public final void setSyncTreeUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<set-?>");
        this.syncTreeUri = uri;
    }


    public final void setMd5(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.md5 = str;
    }


    public final void setActivityComponentString(String str) {
        this.activityComponentString = str;
    }


    public final void setUseCustomPlayer(boolean z) {
        this.useCustomPlayer = z;
    }


    public final void setCustomPlayerId(Long l) {
        this.customPlayerId = l;
    }


    public final void setPlayCount(int i) {
        this.playCount = i;
    }


    public final void setLastPlayedTimestamp(Date date) {
        this.lastPlayedTimestamp = date;
    }


    public final void setAddedDateTimestamp(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.addedDateTimestamp = date;
    }


    public final void setExtra(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extra = str;
    }

    public final PlayableItemEntity copyAndResetDatabaseAndDeviceDependentValues() {
        PlayableItemEntity playableItemEntityCopy$default = copy$default(this, 0L, null, false, false, null, 0, null, false, null, null, false, false, false, false, null, null, null, null, null, null, false, null, 0, null, null, null, 67108863, null);
        playableItemEntityCopy$default.id = 0L;
        playableItemEntityCopy$default.isInSingletonDisjointSet = true;
        playableItemEntityCopy$default.useDisjointSetPrimaryPlayableItem = false;
        playableItemEntityCopy$default.disjointSetPrimaryPlayableItemId = null;
        ArrayList arrayList = new ArrayList();
        playableItemEntityCopy$default.scraperKeywordList = arrayList;
        arrayList.addAll(this.scraperKeywordList);
        playableItemEntityCopy$default.previewMediaPath = null;
        playableItemEntityCopy$default.attachedPlatformId = null;
        Uri EMPTY = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        playableItemEntityCopy$default.uri = EMPTY;
        Uri EMPTY2 = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY2, "EMPTY");
        playableItemEntityCopy$default.syncTreeUri = EMPTY2;
        playableItemEntityCopy$default.customPlayerId = null;
        return playableItemEntityCopy$default;
    }
}
