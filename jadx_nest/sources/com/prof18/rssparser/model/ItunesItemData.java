package com.prof18.rssparser.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: ItunesData.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001,Bm\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0085\u0001\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006-"}, d2 = {"Lcom/prof18/rssparser/model/ItunesItemData;", "", "author", "", TypedValues.TransitionType.S_DURATION, "episode", "episodeType", "explicit", "image", "keywords", "", "subtitle", "summary", "season", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthor", "()Ljava/lang/String;", "getDuration", "getEpisode", "getEpisodeType", "getExplicit", "getImage", "getKeywords", "()Ljava/util/List;", "getSeason", "getSubtitle", "getSummary", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "Builder", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ItunesItemData {
    private final String author;
    private final String duration;
    private final String episode;
    private final String episodeType;
    private final String explicit;
    private final String image;
    private final List<String> keywords;
    private final String season;
    private final String subtitle;
    private final String summary;

    /* WARN: Multi-variable type inference failed */
    public static /* synthetic */ ItunesItemData copy$default(ItunesItemData itunesItemData, String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, String str8, String str9, int i, Object obj) {
        if ((i & 1) != 0) {
            str = itunesItemData.author;
        }
        if ((i & 2) != 0) {
            str2 = itunesItemData.duration;
        }
        if ((i & 4) != 0) {
            str3 = itunesItemData.episode;
        }
        if ((i & 8) != 0) {
            str4 = itunesItemData.episodeType;
        }
        if ((i & 16) != 0) {
            str5 = itunesItemData.explicit;
        }
        if ((i & 32) != 0) {
            str6 = itunesItemData.image;
        }
        if ((i & 64) != 0) {
            list = itunesItemData.keywords;
        }
        if ((i & 128) != 0) {
            str7 = itunesItemData.subtitle;
        }
        if ((i & 256) != 0) {
            str8 = itunesItemData.summary;
        }
        if ((i & 512) != 0) {
            str9 = itunesItemData.season;
        }
        String str10 = str8;
        String str11 = str9;
        List list2 = list;
        String str12 = str7;
        String str13 = str5;
        String str14 = str6;
        return itunesItemData.copy(str, str2, str3, str4, str13, str14, list2, str12, str10, str11);
    }

    /* INFO: renamed from: component1, reason: from getter */
    public final String getAuthor() {
        return this.author;
    }

    /* INFO: renamed from: component10, reason: from getter */
    public final String getSeason() {
        return this.season;
    }

    /* INFO: renamed from: component2, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    /* INFO: renamed from: component3, reason: from getter */
    public final String getEpisode() {
        return this.episode;
    }

    /* INFO: renamed from: component4, reason: from getter */
    public final String getEpisodeType() {
        return this.episodeType;
    }

    /* INFO: renamed from: component5, reason: from getter */
    public final String getExplicit() {
        return this.explicit;
    }

    /* INFO: renamed from: component6, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    public final List<String> component7() {
        return this.keywords;
    }

    /* INFO: renamed from: component8, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* INFO: renamed from: component9, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    public final ItunesItemData copy(String author, String duration, String episode, String episodeType, String explicit, String image, List<String> keywords, String subtitle, String summary, String season) {
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        return new ItunesItemData(author, duration, episode, episodeType, explicit, image, keywords, subtitle, summary, season);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItunesItemData)) {
            return false;
        }
        ItunesItemData itunesItemData = (ItunesItemData) other;
        return Intrinsics.areEqual(this.author, itunesItemData.author) && Intrinsics.areEqual(this.duration, itunesItemData.duration) && Intrinsics.areEqual(this.episode, itunesItemData.episode) && Intrinsics.areEqual(this.episodeType, itunesItemData.episodeType) && Intrinsics.areEqual(this.explicit, itunesItemData.explicit) && Intrinsics.areEqual(this.image, itunesItemData.image) && Intrinsics.areEqual(this.keywords, itunesItemData.keywords) && Intrinsics.areEqual(this.subtitle, itunesItemData.subtitle) && Intrinsics.areEqual(this.summary, itunesItemData.summary) && Intrinsics.areEqual(this.season, itunesItemData.season);
    }

    public int hashCode() {
        String str = this.author;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.duration;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.episode;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.episodeType;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.explicit;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.image;
        int iHashCode6 = (((iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.keywords.hashCode()) * 31;
        String str7 = this.subtitle;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.summary;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.season;
        return iHashCode8 + (str9 != null ? str9.hashCode() : 0);
    }

    public String toString() {
        return "ItunesItemData(author=" + this.author + ", duration=" + this.duration + ", episode=" + this.episode + ", episodeType=" + this.episodeType + ", explicit=" + this.explicit + ", image=" + this.image + ", keywords=" + this.keywords + ", subtitle=" + this.subtitle + ", summary=" + this.summary + ", season=" + this.season + ")";
    }

    public ItunesItemData(String str, String str2, String str3, String str4, String str5, String str6, List<String> keywords, String str7, String str8, String str9) {
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        this.author = str;
        this.duration = str2;
        this.episode = str3;
        this.episodeType = str4;
        this.explicit = str5;
        this.image = str6;
        this.keywords = keywords;
        this.subtitle = str7;
        this.summary = str8;
        this.season = str9;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getEpisode() {
        return this.episode;
    }

    public final String getEpisodeType() {
        return this.episodeType;
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

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getSeason() {
        return this.season;
    }

    /* INFO: compiled from: ItunesData.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0002\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÂ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0085\u0001\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003J\u0014\u0010\t\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nJ\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/prof18/rssparser/model/ItunesItemData$Builder;", "", "author", "", TypedValues.TransitionType.S_DURATION, "episode", "episodeType", "explicit", "image", "keywords", "", "subtitle", "summary", "season", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "build", "Lcom/prof18/rssparser/model/ItunesItemData;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Builder {
        private String author;
        private String duration;
        private String episode;
        private String episodeType;
        private String explicit;
        private String image;
        private List<String> keywords;
        private String season;
        private String subtitle;
        private String summary;

        public Builder() {
            this(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }

        /* INFO: renamed from: component1, reason: from getter */
        private final String getAuthor() {
            return this.author;
        }

        /* INFO: renamed from: component10, reason: from getter */
        private final String getSeason() {
            return this.season;
        }

        /* INFO: renamed from: component2, reason: from getter */
        private final String getDuration() {
            return this.duration;
        }

        /* INFO: renamed from: component3, reason: from getter */
        private final String getEpisode() {
            return this.episode;
        }

        /* INFO: renamed from: component4, reason: from getter */
        private final String getEpisodeType() {
            return this.episodeType;
        }

        /* INFO: renamed from: component5, reason: from getter */
        private final String getExplicit() {
            return this.explicit;
        }

        /* INFO: renamed from: component6, reason: from getter */
        private final String getImage() {
            return this.image;
        }

        private final List<String> component7() {
            return this.keywords;
        }

        /* INFO: renamed from: component8, reason: from getter */
        private final String getSubtitle() {
            return this.subtitle;
        }

        /* INFO: renamed from: component9, reason: from getter */
        private final String getSummary() {
            return this.summary;
        }

        /* WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder copy$default(Builder builder, String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, String str8, String str9, int i, Object obj) {
            if ((i & 1) != 0) {
                str = builder.author;
            }
            if ((i & 2) != 0) {
                str2 = builder.duration;
            }
            if ((i & 4) != 0) {
                str3 = builder.episode;
            }
            if ((i & 8) != 0) {
                str4 = builder.episodeType;
            }
            if ((i & 16) != 0) {
                str5 = builder.explicit;
            }
            if ((i & 32) != 0) {
                str6 = builder.image;
            }
            if ((i & 64) != 0) {
                list = builder.keywords;
            }
            if ((i & 128) != 0) {
                str7 = builder.subtitle;
            }
            if ((i & 256) != 0) {
                str8 = builder.summary;
            }
            if ((i & 512) != 0) {
                str9 = builder.season;
            }
            String str10 = str8;
            String str11 = str9;
            List list2 = list;
            String str12 = str7;
            String str13 = str5;
            String str14 = str6;
            return builder.copy(str, str2, str3, str4, str13, str14, list2, str12, str10, str11);
        }

        public final Builder copy(String author, String duration, String episode, String episodeType, String explicit, String image, List<String> keywords, String subtitle, String summary, String season) {
            Intrinsics.checkNotNullParameter(keywords, "keywords");
            return new Builder(author, duration, episode, episodeType, explicit, image, keywords, subtitle, summary, season);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) other;
            return Intrinsics.areEqual(this.author, builder.author) && Intrinsics.areEqual(this.duration, builder.duration) && Intrinsics.areEqual(this.episode, builder.episode) && Intrinsics.areEqual(this.episodeType, builder.episodeType) && Intrinsics.areEqual(this.explicit, builder.explicit) && Intrinsics.areEqual(this.image, builder.image) && Intrinsics.areEqual(this.keywords, builder.keywords) && Intrinsics.areEqual(this.subtitle, builder.subtitle) && Intrinsics.areEqual(this.summary, builder.summary) && Intrinsics.areEqual(this.season, builder.season);
        }

        public int hashCode() {
            String str = this.author;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.duration;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.episode;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.episodeType;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.explicit;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.image;
            int iHashCode6 = (((iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.keywords.hashCode()) * 31;
            String str7 = this.subtitle;
            int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.summary;
            int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.season;
            return iHashCode8 + (str9 != null ? str9.hashCode() : 0);
        }

        public String toString() {
            return "Builder(author=" + this.author + ", duration=" + this.duration + ", episode=" + this.episode + ", episodeType=" + this.episodeType + ", explicit=" + this.explicit + ", image=" + this.image + ", keywords=" + this.keywords + ", subtitle=" + this.subtitle + ", summary=" + this.summary + ", season=" + this.season + ")";
        }

        public Builder(String str, String str2, String str3, String str4, String str5, String str6, List<String> keywords, String str7, String str8, String str9) {
            Intrinsics.checkNotNullParameter(keywords, "keywords");
            this.author = str;
            this.duration = str2;
            this.episode = str3;
            this.episodeType = str4;
            this.explicit = str5;
            this.image = str6;
            this.keywords = keywords;
            this.subtitle = str7;
            this.summary = str8;
            this.season = str9;
        }

        public /* synthetic */ Builder(String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? CollectionsKt.emptyList() : list, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9);
        }

        public final Builder image(String image) {
            this.image = image;
            return this;
        }

        public final Builder duration(String duration) {
            this.duration = duration;
            return this;
        }

        public final Builder explicit(String explicit) {
            this.explicit = explicit;
            return this;
        }

        public final Builder keywords(List<String> keywords) {
            Intrinsics.checkNotNullParameter(keywords, "keywords");
            this.keywords = keywords;
            return this;
        }

        public final Builder subtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public final Builder episode(String episode) {
            this.episode = episode;
            return this;
        }

        public final Builder episodeType(String episodeType) {
            this.episodeType = episodeType;
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

        public final Builder season(String season) {
            this.season = season;
            return this;
        }

        public final ItunesItemData build() {
            return new ItunesItemData(this.author, this.duration, this.episode, this.episodeType, this.explicit, this.image, this.keywords, this.subtitle, this.summary, this.season);
        }
    }
}
