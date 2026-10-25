package com.prof18.rssparser.model;

import com.googlecode.javaewah32.RunningLengthWord32;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: RssItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001=B\u009f\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÁ\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016¨\u0006>"}, d2 = {"Lcom/prof18/rssparser/model/RssItem;", "", "guid", "", "title", "author", "link", "pubDate", "description", "content", "image", "audio", "video", "sourceName", "sourceUrl", "categories", "", "itunesItemData", "Lcom/prof18/rssparser/model/ItunesItemData;", "commentsUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/prof18/rssparser/model/ItunesItemData;Ljava/lang/String;)V", "getAudio", "()Ljava/lang/String;", "getAuthor", "getCategories", "()Ljava/util/List;", "getCommentsUrl", "getContent", "getDescription", "getGuid", "getImage", "getItunesItemData", "()Lcom/prof18/rssparser/model/ItunesItemData;", "getLink", "getPubDate", "getSourceName", "getSourceUrl", "getTitle", "getVideo", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "Builder", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class RssItem {
    private final String audio;
    private final String author;
    private final List<String> categories;
    private final String commentsUrl;
    private final String content;
    private final String description;
    private final String guid;
    private final String image;
    private final ItunesItemData itunesItemData;
    private final String link;
    private final String pubDate;
    private final String sourceName;
    private final String sourceUrl;
    private final String title;
    private final String video;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGuid() {
        return this.guid;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getVideo() {
        return this.video;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getSourceName() {
        return this.sourceName;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    public final List<String> component13() {
        return this.categories;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final ItunesItemData getItunesItemData() {
        return this.itunesItemData;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getCommentsUrl() {
        return this.commentsUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAuthor() {
        return this.author;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPubDate() {
        return this.pubDate;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAudio() {
        return this.audio;
    }

    public final RssItem copy(String guid, String title, String author, String link, String pubDate, String description, String content, String image, String audio, String video, String sourceName, String sourceUrl, List<String> categories, ItunesItemData itunesItemData, String commentsUrl) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        return new RssItem(guid, title, author, link, pubDate, description, content, image, audio, video, sourceName, sourceUrl, categories, itunesItemData, commentsUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RssItem)) {
            return false;
        }
        RssItem rssItem = (RssItem) other;
        return Intrinsics.areEqual(this.guid, rssItem.guid) && Intrinsics.areEqual(this.title, rssItem.title) && Intrinsics.areEqual(this.author, rssItem.author) && Intrinsics.areEqual(this.link, rssItem.link) && Intrinsics.areEqual(this.pubDate, rssItem.pubDate) && Intrinsics.areEqual(this.description, rssItem.description) && Intrinsics.areEqual(this.content, rssItem.content) && Intrinsics.areEqual(this.image, rssItem.image) && Intrinsics.areEqual(this.audio, rssItem.audio) && Intrinsics.areEqual(this.video, rssItem.video) && Intrinsics.areEqual(this.sourceName, rssItem.sourceName) && Intrinsics.areEqual(this.sourceUrl, rssItem.sourceUrl) && Intrinsics.areEqual(this.categories, rssItem.categories) && Intrinsics.areEqual(this.itunesItemData, rssItem.itunesItemData) && Intrinsics.areEqual(this.commentsUrl, rssItem.commentsUrl);
    }

    public int hashCode() {
        String str = this.guid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.author;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.link;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.pubDate;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.description;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.content;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.image;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.audio;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.video;
        int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.sourceName;
        int iHashCode11 = (iHashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.sourceUrl;
        int iHashCode12 = (((iHashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31) + this.categories.hashCode()) * 31;
        ItunesItemData itunesItemData = this.itunesItemData;
        int iHashCode13 = (iHashCode12 + (itunesItemData == null ? 0 : itunesItemData.hashCode())) * 31;
        String str13 = this.commentsUrl;
        return iHashCode13 + (str13 != null ? str13.hashCode() : 0);
    }

    public String toString() {
        return "RssItem(guid=" + this.guid + ", title=" + this.title + ", author=" + this.author + ", link=" + this.link + ", pubDate=" + this.pubDate + ", description=" + this.description + ", content=" + this.content + ", image=" + this.image + ", audio=" + this.audio + ", video=" + this.video + ", sourceName=" + this.sourceName + ", sourceUrl=" + this.sourceUrl + ", categories=" + this.categories + ", itunesItemData=" + this.itunesItemData + ", commentsUrl=" + this.commentsUrl + ")";
    }

    public RssItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, List<String> categories, ItunesItemData itunesItemData, String str13) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        this.guid = str;
        this.title = str2;
        this.author = str3;
        this.link = str4;
        this.pubDate = str5;
        this.description = str6;
        this.content = str7;
        this.image = str8;
        this.audio = str9;
        this.video = str10;
        this.sourceName = str11;
        this.sourceUrl = str12;
        this.categories = categories;
        this.itunesItemData = itunesItemData;
        this.commentsUrl = str13;
    }

    public final String getGuid() {
        return this.guid;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getPubDate() {
        return this.pubDate;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getAudio() {
        return this.audio;
    }

    public final String getVideo() {
        return this.video;
    }

    public final String getSourceName() {
        return this.sourceName;
    }

    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    public final List<String> getCategories() {
        return this.categories;
    }

    public final ItunesItemData getItunesItemData() {
        return this.itunesItemData;
    }

    public final String getCommentsUrl() {
        return this.commentsUrl;
    }

    /* JADX INFO: compiled from: RssItem.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001B½\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010HÂ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0012HÂ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0003JÁ\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u0002\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0003J\u0010\u00100\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\u0010\u00101\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0003J\u0010\u00103\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0003R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/prof18/rssparser/model/RssItem$Builder;", "", "guid", "", "title", "author", "link", "pubDate", "description", "content", "image", "audio", "video", "sourceName", "sourceUrl", "categories", "", "itunesItemData", "Lcom/prof18/rssparser/model/ItunesItemData;", "commentUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/prof18/rssparser/model/ItunesItemData;Ljava/lang/String;)V", "addCategory", "category", "audioIfNull", "build", "Lcom/prof18/rssparser/model/RssItem;", "url", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "itunesArticleData", "pubDateIfNull", "toString", "videoIfNull", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Builder {
        private String audio;
        private String author;
        private final List<String> categories;
        private String commentUrl;
        private String content;
        private String description;
        private String guid;
        private String image;
        private ItunesItemData itunesItemData;
        private String link;
        private String pubDate;
        private String sourceName;
        private String sourceUrl;
        private String title;
        private String video;

        public Builder() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, RunningLengthWord32.LARGEST_LITERAL_COUNT, null);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final String getGuid() {
            return this.guid;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        private final String getVideo() {
            return this.video;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        private final String getSourceName() {
            return this.sourceName;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        private final String getSourceUrl() {
            return this.sourceUrl;
        }

        private final List<String> component13() {
            return this.categories;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        private final ItunesItemData getItunesItemData() {
            return this.itunesItemData;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        private final String getCommentUrl() {
            return this.commentUrl;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        private final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        private final String getAuthor() {
            return this.author;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        private final String getLink() {
            return this.link;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        private final String getPubDate() {
            return this.pubDate;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        private final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        private final String getContent() {
            return this.content;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        private final String getImage() {
            return this.image;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        private final String getAudio() {
            return this.audio;
        }

        public final Builder copy(String guid, String title, String author, String link, String pubDate, String description, String content, String image, String audio, String video, String sourceName, String sourceUrl, List<String> categories, ItunesItemData itunesItemData, String commentUrl) {
            Intrinsics.checkNotNullParameter(categories, "categories");
            return new Builder(guid, title, author, link, pubDate, description, content, image, audio, video, sourceName, sourceUrl, categories, itunesItemData, commentUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) other;
            return Intrinsics.areEqual(this.guid, builder.guid) && Intrinsics.areEqual(this.title, builder.title) && Intrinsics.areEqual(this.author, builder.author) && Intrinsics.areEqual(this.link, builder.link) && Intrinsics.areEqual(this.pubDate, builder.pubDate) && Intrinsics.areEqual(this.description, builder.description) && Intrinsics.areEqual(this.content, builder.content) && Intrinsics.areEqual(this.image, builder.image) && Intrinsics.areEqual(this.audio, builder.audio) && Intrinsics.areEqual(this.video, builder.video) && Intrinsics.areEqual(this.sourceName, builder.sourceName) && Intrinsics.areEqual(this.sourceUrl, builder.sourceUrl) && Intrinsics.areEqual(this.categories, builder.categories) && Intrinsics.areEqual(this.itunesItemData, builder.itunesItemData) && Intrinsics.areEqual(this.commentUrl, builder.commentUrl);
        }

        public int hashCode() {
            String str = this.guid;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.title;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.author;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.link;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.pubDate;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.description;
            int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.content;
            int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.image;
            int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.audio;
            int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.video;
            int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.sourceName;
            int iHashCode11 = (iHashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
            String str12 = this.sourceUrl;
            int iHashCode12 = (((iHashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31) + this.categories.hashCode()) * 31;
            ItunesItemData itunesItemData = this.itunesItemData;
            int iHashCode13 = (iHashCode12 + (itunesItemData == null ? 0 : itunesItemData.hashCode())) * 31;
            String str13 = this.commentUrl;
            return iHashCode13 + (str13 != null ? str13.hashCode() : 0);
        }

        public String toString() {
            return "Builder(guid=" + this.guid + ", title=" + this.title + ", author=" + this.author + ", link=" + this.link + ", pubDate=" + this.pubDate + ", description=" + this.description + ", content=" + this.content + ", image=" + this.image + ", audio=" + this.audio + ", video=" + this.video + ", sourceName=" + this.sourceName + ", sourceUrl=" + this.sourceUrl + ", categories=" + this.categories + ", itunesItemData=" + this.itunesItemData + ", commentUrl=" + this.commentUrl + ")";
        }

        public Builder(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, List<String> categories, ItunesItemData itunesItemData, String str13) {
            Intrinsics.checkNotNullParameter(categories, "categories");
            this.guid = str;
            this.title = str2;
            this.author = str3;
            this.link = str4;
            this.pubDate = str5;
            this.description = str6;
            this.content = str7;
            this.image = str8;
            this.audio = str9;
            this.video = str10;
            this.sourceName = str11;
            this.sourceUrl = str12;
            this.categories = categories;
            this.itunesItemData = itunesItemData;
            this.commentUrl = str13;
        }

        public /* synthetic */ Builder(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, List list, ItunesItemData itunesItemData, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) != 0 ? new ArrayList() : list, (i & 8192) != 0 ? null : itunesItemData, (i & 16384) != 0 ? null : str13);
        }

        public final Builder guid(String guid) {
            this.guid = guid;
            return this;
        }

        public final Builder title(String title) {
            this.title = title;
            return this;
        }

        public final Builder author(String author) {
            this.author = author;
            return this;
        }

        public final Builder link(String link) {
            this.link = link;
            return this;
        }

        public final Builder pubDate(String pubDate) {
            this.pubDate = pubDate;
            return this;
        }

        public final Builder pubDateIfNull(String pubDate) {
            if (this.pubDate == null) {
                this.pubDate = pubDate;
            }
            return this;
        }

        public final Builder description(String description) {
            this.description = description;
            return this;
        }

        public final Builder content(String content) {
            this.content = content;
            return this;
        }

        public final Builder image(String image) {
            if (this.image == null && image != null && image.length() > 0) {
                this.image = image;
            }
            return this;
        }

        public final Builder audio(String audio) {
            this.audio = audio;
            return this;
        }

        public final Builder audioIfNull(String audio) {
            if (this.audio == null) {
                this.audio = audio;
            }
            return this;
        }

        public final Builder video(String video) {
            this.video = video;
            return this;
        }

        public final Builder videoIfNull(String video) {
            if (this.video == null) {
                this.video = video;
            }
            return this;
        }

        public final Builder sourceName(String sourceName) {
            this.sourceName = sourceName;
            return this;
        }

        public final Builder sourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
            return this;
        }

        public final Builder addCategory(String category) {
            if (category != null) {
                this.categories.add(category);
            }
            return this;
        }

        public final Builder itunesArticleData(ItunesItemData itunesItemData) {
            this.itunesItemData = itunesItemData;
            return this;
        }

        public final Builder commentUrl(String url) {
            this.commentUrl = url;
            return this;
        }

        public final RssItem build() {
            return new RssItem(this.guid, this.title, this.author, this.link, this.pubDate, this.description, this.content, this.image, this.audio, this.video, this.sourceName, this.sourceUrl, this.categories, this.itunesItemData, this.commentUrl);
        }
    }
}
