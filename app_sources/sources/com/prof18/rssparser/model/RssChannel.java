package com.prof18.rssparser.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: RssChannel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001+BY\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jm\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006,"}, d2 = {"Lcom/prof18/rssparser/model/RssChannel;", "", "title", "", "link", "description", "image", "Lcom/prof18/rssparser/model/RssImage;", "lastBuildDate", "updatePeriod", "items", "", "Lcom/prof18/rssparser/model/RssItem;", "itunesChannelData", "Lcom/prof18/rssparser/model/ItunesChannelData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/prof18/rssparser/model/RssImage;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/prof18/rssparser/model/ItunesChannelData;)V", "getDescription", "()Ljava/lang/String;", "getImage", "()Lcom/prof18/rssparser/model/RssImage;", "getItems", "()Ljava/util/List;", "getItunesChannelData", "()Lcom/prof18/rssparser/model/ItunesChannelData;", "getLastBuildDate", "getLink", "getTitle", "getUpdatePeriod", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "Builder", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class RssChannel {
    private final String description;
    private final RssImage image;
    private final List<RssItem> items;
    private final ItunesChannelData itunesChannelData;
    private final String lastBuildDate;
    private final String link;
    private final String title;
    private final String updatePeriod;

    /* WARN: Multi-variable type inference failed */
    public static /* synthetic */ RssChannel copy$default(RssChannel rssChannel, String str, String str2, String str3, RssImage rssImage, String str4, String str5, List list, ItunesChannelData itunesChannelData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rssChannel.title;
        }
        if ((i & 2) != 0) {
            str2 = rssChannel.link;
        }
        if ((i & 4) != 0) {
            str3 = rssChannel.description;
        }
        if ((i & 8) != 0) {
            rssImage = rssChannel.image;
        }
        if ((i & 16) != 0) {
            str4 = rssChannel.lastBuildDate;
        }
        if ((i & 32) != 0) {
            str5 = rssChannel.updatePeriod;
        }
        if ((i & 64) != 0) {
            list = rssChannel.items;
        }
        if ((i & 128) != 0) {
            itunesChannelData = rssChannel.itunesChannelData;
        }
        List list2 = list;
        ItunesChannelData itunesChannelData2 = itunesChannelData;
        String str6 = str4;
        String str7 = str5;
        return rssChannel.copy(str, str2, str3, rssImage, str6, str7, list2, itunesChannelData2);
    }

    /* INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* INFO: renamed from: component2, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* INFO: renamed from: component4, reason: from getter */
    public final RssImage getImage() {
        return this.image;
    }

    /* INFO: renamed from: component5, reason: from getter */
    public final String getLastBuildDate() {
        return this.lastBuildDate;
    }

    /* INFO: renamed from: component6, reason: from getter */
    public final String getUpdatePeriod() {
        return this.updatePeriod;
    }

    public final List<RssItem> component7() {
        return this.items;
    }

    /* INFO: renamed from: component8, reason: from getter */
    public final ItunesChannelData getItunesChannelData() {
        return this.itunesChannelData;
    }

    public final RssChannel copy(String title, String link, String description, RssImage image, String lastBuildDate, String updatePeriod, List<RssItem> items, ItunesChannelData itunesChannelData) {
        Intrinsics.checkNotNullParameter(items, "items");
        return new RssChannel(title, link, description, image, lastBuildDate, updatePeriod, items, itunesChannelData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RssChannel)) {
            return false;
        }
        RssChannel rssChannel = (RssChannel) other;
        return Intrinsics.areEqual(this.title, rssChannel.title) && Intrinsics.areEqual(this.link, rssChannel.link) && Intrinsics.areEqual(this.description, rssChannel.description) && Intrinsics.areEqual(this.image, rssChannel.image) && Intrinsics.areEqual(this.lastBuildDate, rssChannel.lastBuildDate) && Intrinsics.areEqual(this.updatePeriod, rssChannel.updatePeriod) && Intrinsics.areEqual(this.items, rssChannel.items) && Intrinsics.areEqual(this.itunesChannelData, rssChannel.itunesChannelData);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.link;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        RssImage rssImage = this.image;
        int iHashCode4 = (iHashCode3 + (rssImage == null ? 0 : rssImage.hashCode())) * 31;
        String str4 = this.lastBuildDate;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.updatePeriod;
        int iHashCode6 = (((iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.items.hashCode()) * 31;
        ItunesChannelData itunesChannelData = this.itunesChannelData;
        return iHashCode6 + (itunesChannelData != null ? itunesChannelData.hashCode() : 0);
    }

    public String toString() {
        return "RssChannel(title=" + this.title + ", link=" + this.link + ", description=" + this.description + ", image=" + this.image + ", lastBuildDate=" + this.lastBuildDate + ", updatePeriod=" + this.updatePeriod + ", items=" + this.items + ", itunesChannelData=" + this.itunesChannelData + ")";
    }

    public RssChannel(String str, String str2, String str3, RssImage rssImage, String str4, String str5, List<RssItem> items, ItunesChannelData itunesChannelData) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.title = str;
        this.link = str2;
        this.description = str3;
        this.image = rssImage;
        this.lastBuildDate = str4;
        this.updatePeriod = str5;
        this.items = items;
        this.itunesChannelData = itunesChannelData;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getDescription() {
        return this.description;
    }

    public final RssImage getImage() {
        return this.image;
    }

    public final String getLastBuildDate() {
        return this.lastBuildDate;
    }

    public final String getUpdatePeriod() {
        return this.updatePeriod;
    }

    public final List<RssItem> getItems() {
        return this.items;
    }

    public final ItunesChannelData getItunesChannelData() {
        return this.itunesChannelData;
    }

    /* INFO: compiled from: RssChannel.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001Bi\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÂ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000eHÂ\u0003Jm\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0002\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0003R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/prof18/rssparser/model/RssChannel$Builder;", "", "title", "", "link", "description", "image", "Lcom/prof18/rssparser/model/RssImage;", "lastBuildDate", "updatePeriod", "items", "", "Lcom/prof18/rssparser/model/RssItem;", "itunesChannelData", "Lcom/prof18/rssparser/model/ItunesChannelData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/prof18/rssparser/model/RssImage;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/prof18/rssparser/model/ItunesChannelData;)V", "addItem", "item", "build", "Lcom/prof18/rssparser/model/RssChannel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Builder {
        private String description;
        private RssImage image;
        private final List<RssItem> items;
        private ItunesChannelData itunesChannelData;
        private String lastBuildDate;
        private String link;
        private String title;
        private String updatePeriod;

        public Builder() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        /* INFO: renamed from: component1, reason: from getter */
        private final String getTitle() {
            return this.title;
        }

        /* INFO: renamed from: component2, reason: from getter */
        private final String getLink() {
            return this.link;
        }

        /* INFO: renamed from: component3, reason: from getter */
        private final String getDescription() {
            return this.description;
        }

        /* INFO: renamed from: component4, reason: from getter */
        private final RssImage getImage() {
            return this.image;
        }

        /* INFO: renamed from: component5, reason: from getter */
        private final String getLastBuildDate() {
            return this.lastBuildDate;
        }

        /* INFO: renamed from: component6, reason: from getter */
        private final String getUpdatePeriod() {
            return this.updatePeriod;
        }

        private final List<RssItem> component7() {
            return this.items;
        }

        /* INFO: renamed from: component8, reason: from getter */
        private final ItunesChannelData getItunesChannelData() {
            return this.itunesChannelData;
        }

        /* WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder copy$default(Builder builder, String str, String str2, String str3, RssImage rssImage, String str4, String str5, List list, ItunesChannelData itunesChannelData, int i, Object obj) {
            if ((i & 1) != 0) {
                str = builder.title;
            }
            if ((i & 2) != 0) {
                str2 = builder.link;
            }
            if ((i & 4) != 0) {
                str3 = builder.description;
            }
            if ((i & 8) != 0) {
                rssImage = builder.image;
            }
            if ((i & 16) != 0) {
                str4 = builder.lastBuildDate;
            }
            if ((i & 32) != 0) {
                str5 = builder.updatePeriod;
            }
            if ((i & 64) != 0) {
                list = builder.items;
            }
            if ((i & 128) != 0) {
                itunesChannelData = builder.itunesChannelData;
            }
            List list2 = list;
            ItunesChannelData itunesChannelData2 = itunesChannelData;
            String str6 = str4;
            String str7 = str5;
            return builder.copy(str, str2, str3, rssImage, str6, str7, list2, itunesChannelData2);
        }

        public final Builder copy(String title, String link, String description, RssImage image, String lastBuildDate, String updatePeriod, List<RssItem> items, ItunesChannelData itunesChannelData) {
            Intrinsics.checkNotNullParameter(items, "items");
            return new Builder(title, link, description, image, lastBuildDate, updatePeriod, items, itunesChannelData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) other;
            return Intrinsics.areEqual(this.title, builder.title) && Intrinsics.areEqual(this.link, builder.link) && Intrinsics.areEqual(this.description, builder.description) && Intrinsics.areEqual(this.image, builder.image) && Intrinsics.areEqual(this.lastBuildDate, builder.lastBuildDate) && Intrinsics.areEqual(this.updatePeriod, builder.updatePeriod) && Intrinsics.areEqual(this.items, builder.items) && Intrinsics.areEqual(this.itunesChannelData, builder.itunesChannelData);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.link;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.description;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            RssImage rssImage = this.image;
            int iHashCode4 = (iHashCode3 + (rssImage == null ? 0 : rssImage.hashCode())) * 31;
            String str4 = this.lastBuildDate;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.updatePeriod;
            int iHashCode6 = (((iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.items.hashCode()) * 31;
            ItunesChannelData itunesChannelData = this.itunesChannelData;
            return iHashCode6 + (itunesChannelData != null ? itunesChannelData.hashCode() : 0);
        }

        public String toString() {
            return "Builder(title=" + this.title + ", link=" + this.link + ", description=" + this.description + ", image=" + this.image + ", lastBuildDate=" + this.lastBuildDate + ", updatePeriod=" + this.updatePeriod + ", items=" + this.items + ", itunesChannelData=" + this.itunesChannelData + ")";
        }

        public Builder(String str, String str2, String str3, RssImage rssImage, String str4, String str5, List<RssItem> items, ItunesChannelData itunesChannelData) {
            Intrinsics.checkNotNullParameter(items, "items");
            this.title = str;
            this.link = str2;
            this.description = str3;
            this.image = rssImage;
            this.lastBuildDate = str4;
            this.updatePeriod = str5;
            this.items = items;
            this.itunesChannelData = itunesChannelData;
        }

        public /* synthetic */ Builder(String str, String str2, String str3, RssImage rssImage, String str4, String str5, ArrayList arrayList, ItunesChannelData itunesChannelData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : rssImage, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? new ArrayList() : arrayList, (i & 128) != 0 ? null : itunesChannelData);
        }

        public final Builder title(String title) {
            this.title = title;
            return this;
        }

        public final Builder link(String link) {
            this.link = link;
            return this;
        }

        public final Builder description(String description) {
            this.description = description;
            return this;
        }

        public final Builder image(RssImage image) {
            Intrinsics.checkNotNullParameter(image, "image");
            this.image = image;
            return this;
        }

        public final Builder lastBuildDate(String lastBuildDate) {
            this.lastBuildDate = lastBuildDate;
            return this;
        }

        public final Builder updatePeriod(String updatePeriod) {
            this.updatePeriod = updatePeriod;
            return this;
        }

        public final Builder addItem(RssItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.items.add(item);
            return this;
        }

        public final Builder itunesChannelData(ItunesChannelData itunesChannelData) {
            this.itunesChannelData = itunesChannelData;
            return this;
        }

        public final RssChannel build() {
            return new RssChannel(this.title, this.link, this.description, this.image, this.lastBuildDate, this.updatePeriod, this.items, this.itunesChannelData);
        }
    }
}
