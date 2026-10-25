package com.prof18.rssparser.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: ItunesData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u00011B}\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0095\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00062"}, d2 = {"Lcom/prof18/rssparser/model/ItunesChannelData;", "", "author", "", "categories", "", TypedValues.TransitionType.S_DURATION, "explicit", "image", "keywords", "newsFeedUrl", "owner", "Lcom/prof18/rssparser/model/ItunesOwner;", "subtitle", "summary", "type", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/prof18/rssparser/model/ItunesOwner;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthor", "()Ljava/lang/String;", "getCategories", "()Ljava/util/List;", "getDuration", "getExplicit", "getImage", "getKeywords", "getNewsFeedUrl", "getOwner", "()Lcom/prof18/rssparser/model/ItunesOwner;", "getSubtitle", "getSummary", "getType", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "Builder", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ItunesChannelData {
    private final String author;
    private final List<String> categories;
    private final String duration;
    private final String explicit;
    private final String image;
    private final List<String> keywords;
    private final String newsFeedUrl;
    private final ItunesOwner owner;
    private final String subtitle;
    private final String summary;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ItunesChannelData copy$default(ItunesChannelData itunesChannelData, String str, List list, String str2, String str3, String str4, List list2, String str5, ItunesOwner itunesOwner, String str6, String str7, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            str = itunesChannelData.author;
        }
        if ((i & 2) != 0) {
            list = itunesChannelData.categories;
        }
        if ((i & 4) != 0) {
            str2 = itunesChannelData.duration;
        }
        if ((i & 8) != 0) {
            str3 = itunesChannelData.explicit;
        }
        if ((i & 16) != 0) {
            str4 = itunesChannelData.image;
        }
        if ((i & 32) != 0) {
            list2 = itunesChannelData.keywords;
        }
        if ((i & 64) != 0) {
            str5 = itunesChannelData.newsFeedUrl;
        }
        if ((i & 128) != 0) {
            itunesOwner = itunesChannelData.owner;
        }
        if ((i & 256) != 0) {
            str6 = itunesChannelData.subtitle;
        }
        if ((i & 512) != 0) {
            str7 = itunesChannelData.summary;
        }
        if ((i & 1024) != 0) {
            str8 = itunesChannelData.type;
        }
        String str9 = str7;
        String str10 = str8;
        ItunesOwner itunesOwner2 = itunesOwner;
        String str11 = str6;
        List list3 = list2;
        String str12 = str5;
        String str13 = str4;
        String str14 = str2;
        return itunesChannelData.copy(str, list, str14, str3, str13, list3, str12, itunesOwner2, str11, str9, str10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAuthor() {
        return this.author;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final List<String> component2() {
        return this.categories;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getExplicit() {
        return this.explicit;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    public final List<String> component6() {
        return this.keywords;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getNewsFeedUrl() {
        return this.newsFeedUrl;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ItunesOwner getOwner() {
        return this.owner;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    public final ItunesChannelData copy(String author, List<String> categories, String duration, String explicit, String image, List<String> keywords, String newsFeedUrl, ItunesOwner owner, String subtitle, String summary, String type) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        return new ItunesChannelData(author, categories, duration, explicit, image, keywords, newsFeedUrl, owner, subtitle, summary, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItunesChannelData)) {
            return false;
        }
        ItunesChannelData itunesChannelData = (ItunesChannelData) other;
        return Intrinsics.areEqual(this.author, itunesChannelData.author) && Intrinsics.areEqual(this.categories, itunesChannelData.categories) && Intrinsics.areEqual(this.duration, itunesChannelData.duration) && Intrinsics.areEqual(this.explicit, itunesChannelData.explicit) && Intrinsics.areEqual(this.image, itunesChannelData.image) && Intrinsics.areEqual(this.keywords, itunesChannelData.keywords) && Intrinsics.areEqual(this.newsFeedUrl, itunesChannelData.newsFeedUrl) && Intrinsics.areEqual(this.owner, itunesChannelData.owner) && Intrinsics.areEqual(this.subtitle, itunesChannelData.subtitle) && Intrinsics.areEqual(this.summary, itunesChannelData.summary) && Intrinsics.areEqual(this.type, itunesChannelData.type);
    }

    public int hashCode() {
        String str = this.author;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.categories.hashCode()) * 31;
        String str2 = this.duration;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.explicit;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.image;
        int iHashCode4 = (((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.keywords.hashCode()) * 31;
        String str5 = this.newsFeedUrl;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        ItunesOwner itunesOwner = this.owner;
        int iHashCode6 = (iHashCode5 + (itunesOwner == null ? 0 : itunesOwner.hashCode())) * 31;
        String str6 = this.subtitle;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.summary;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.type;
        return iHashCode8 + (str8 != null ? str8.hashCode() : 0);
    }

    public String toString() {
        return "ItunesChannelData(author=" + this.author + ", categories=" + this.categories + ", duration=" + this.duration + ", explicit=" + this.explicit + ", image=" + this.image + ", keywords=" + this.keywords + ", newsFeedUrl=" + this.newsFeedUrl + ", owner=" + this.owner + ", subtitle=" + this.subtitle + ", summary=" + this.summary + ", type=" + this.type + ")";
    }

    public ItunesChannelData(String str, List<String> categories, String str2, String str3, String str4, List<String> keywords, String str5, ItunesOwner itunesOwner, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        this.author = str;
        this.categories = categories;
        this.duration = str2;
        this.explicit = str3;
        this.image = str4;
        this.keywords = keywords;
        this.newsFeedUrl = str5;
        this.owner = itunesOwner;
        this.subtitle = str6;
        this.summary = str7;
        this.type = str8;
    }

    public final String getAuthor() {
        return this.author;
    }

    public /* synthetic */ ItunesChannelData(String str, List list, String str2, String str3, String str4, List list2, String str5, ItunesOwner itunesOwner, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, str2, str3, str4, list2, str5, itunesOwner, str6, str7, str8);
    }

    public final List<String> getCategories() {
        return this.categories;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getExplicit() {
        return this.explicit;
    }

    public final String getImage() {
        return this.image;
    }

    public final List<String> getKeywords() {
        return this.keywords;
    }

    public final String getNewsFeedUrl() {
        return this.newsFeedUrl;
    }

    public final ItunesOwner getOwner() {
        return this.owner;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX INFO: compiled from: ItunesData.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0002\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0014\u001a\u00020\u0015J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÂ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÂ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\rHÂ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0095\u0001\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003J\u0014\u0010\t\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/prof18/rssparser/model/ItunesChannelData$Builder;", "", "author", "", "categories", "", TypedValues.TransitionType.S_DURATION, "explicit", "image", "keywords", "", "newsFeedUrl", "owner", "Lcom/prof18/rssparser/model/ItunesOwner;", "subtitle", "summary", "type", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/prof18/rssparser/model/ItunesOwner;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "addCategory", "category", "build", "Lcom/prof18/rssparser/model/ItunesChannelData;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Builder {
        private String author;
        private List<String> categories;
        private String duration;
        private String explicit;
        private String image;
        private List<String> keywords;
        private String newsFeedUrl;
        private ItunesOwner owner;
        private String subtitle;
        private String summary;
        private String type;

        public Builder() {
            this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final String getAuthor() {
            return this.author;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        private final String getSummary() {
            return this.summary;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        private final String getType() {
            return this.type;
        }

        private final List<String> component2() {
            return this.categories;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        private final String getDuration() {
            return this.duration;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        private final String getExplicit() {
            return this.explicit;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        private final String getImage() {
            return this.image;
        }

        private final List<String> component6() {
            return this.keywords;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        private final String getNewsFeedUrl() {
            return this.newsFeedUrl;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        private final ItunesOwner getOwner() {
            return this.owner;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        private final String getSubtitle() {
            return this.subtitle;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder copy$default(Builder builder, String str, List list, String str2, String str3, String str4, List list2, String str5, ItunesOwner itunesOwner, String str6, String str7, String str8, int i, Object obj) {
            if ((i & 1) != 0) {
                str = builder.author;
            }
            if ((i & 2) != 0) {
                list = builder.categories;
            }
            if ((i & 4) != 0) {
                str2 = builder.duration;
            }
            if ((i & 8) != 0) {
                str3 = builder.explicit;
            }
            if ((i & 16) != 0) {
                str4 = builder.image;
            }
            if ((i & 32) != 0) {
                list2 = builder.keywords;
            }
            if ((i & 64) != 0) {
                str5 = builder.newsFeedUrl;
            }
            if ((i & 128) != 0) {
                itunesOwner = builder.owner;
            }
            if ((i & 256) != 0) {
                str6 = builder.subtitle;
            }
            if ((i & 512) != 0) {
                str7 = builder.summary;
            }
            if ((i & 1024) != 0) {
                str8 = builder.type;
            }
            String str9 = str7;
            String str10 = str8;
            ItunesOwner itunesOwner2 = itunesOwner;
            String str11 = str6;
            List list3 = list2;
            String str12 = str5;
            String str13 = str4;
            String str14 = str2;
            return builder.copy(str, list, str14, str3, str13, list3, str12, itunesOwner2, str11, str9, str10);
        }

        public final Builder copy(String author, List<String> categories, String duration, String explicit, String image, List<String> keywords, String newsFeedUrl, ItunesOwner owner, String subtitle, String summary, String type) {
            Intrinsics.checkNotNullParameter(categories, "categories");
            Intrinsics.checkNotNullParameter(keywords, "keywords");
            return new Builder(author, categories, duration, explicit, image, keywords, newsFeedUrl, owner, subtitle, summary, type);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) other;
            return Intrinsics.areEqual(this.author, builder.author) && Intrinsics.areEqual(this.categories, builder.categories) && Intrinsics.areEqual(this.duration, builder.duration) && Intrinsics.areEqual(this.explicit, builder.explicit) && Intrinsics.areEqual(this.image, builder.image) && Intrinsics.areEqual(this.keywords, builder.keywords) && Intrinsics.areEqual(this.newsFeedUrl, builder.newsFeedUrl) && Intrinsics.areEqual(this.owner, builder.owner) && Intrinsics.areEqual(this.subtitle, builder.subtitle) && Intrinsics.areEqual(this.summary, builder.summary) && Intrinsics.areEqual(this.type, builder.type);
        }

        public int hashCode() {
            String str = this.author;
            int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.categories.hashCode()) * 31;
            String str2 = this.duration;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.explicit;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.image;
            int iHashCode4 = (((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.keywords.hashCode()) * 31;
            String str5 = this.newsFeedUrl;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            ItunesOwner itunesOwner = this.owner;
            int iHashCode6 = (iHashCode5 + (itunesOwner == null ? 0 : itunesOwner.hashCode())) * 31;
            String str6 = this.subtitle;
            int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.summary;
            int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.type;
            return iHashCode8 + (str8 != null ? str8.hashCode() : 0);
        }

        public String toString() {
            return "Builder(author=" + this.author + ", categories=" + this.categories + ", duration=" + this.duration + ", explicit=" + this.explicit + ", image=" + this.image + ", keywords=" + this.keywords + ", newsFeedUrl=" + this.newsFeedUrl + ", owner=" + this.owner + ", subtitle=" + this.subtitle + ", summary=" + this.summary + ", type=" + this.type + ")";
        }

        public Builder(String str, List<String> categories, String str2, String str3, String str4, List<String> keywords, String str5, ItunesOwner itunesOwner, String str6, String str7, String str8) {
            Intrinsics.checkNotNullParameter(categories, "categories");
            Intrinsics.checkNotNullParameter(keywords, "keywords");
            this.author = str;
            this.categories = categories;
            this.duration = str2;
            this.explicit = str3;
            this.image = str4;
            this.keywords = keywords;
            this.newsFeedUrl = str5;
            this.owner = itunesOwner;
            this.subtitle = str6;
            this.summary = str7;
            this.type = str8;
        }

        public /* synthetic */ Builder(String str, ArrayList arrayList, String str2, String str3, String str4, List list, String str5, ItunesOwner itunesOwner, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? new ArrayList() : arrayList, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : itunesOwner, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : str7, (i & 1024) != 0 ? null : str8);
        }

        public final Builder explicit(String explicit) {
            this.explicit = explicit;
            return this;
        }

        public final Builder type(String type) {
            this.type = type;
            return this;
        }

        public final Builder subtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public final Builder author(String author) {
            this.author = author;
            return this;
        }

        public final Builder summary(String summary) {
            this.summary = summary;
            return this;
        }

        public final Builder image(String image) {
            this.image = image;
            return this;
        }

        public final Builder addCategory(String category) {
            String str = category;
            if (str != null && str.length() != 0) {
                this.categories.add(category);
            }
            return this;
        }

        public final Builder newsFeedUrl(String newsFeedUrl) {
            this.newsFeedUrl = newsFeedUrl;
            return this;
        }

        public final Builder owner(ItunesOwner owner) {
            this.owner = owner;
            return this;
        }

        public final Builder duration(String duration) {
            this.duration = duration;
            return this;
        }

        public final Builder keywords(List<String> keywords) {
            Intrinsics.checkNotNullParameter(keywords, "keywords");
            this.keywords = keywords;
            return this;
        }

        public final ItunesChannelData build() {
            return new ItunesChannelData(this.author, this.categories, this.duration, this.explicit, this.image, this.keywords, this.newsFeedUrl, this.owner, this.subtitle, this.summary, this.type);
        }
    }
}
