package com.prof18.rssparser.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: RssImage.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0019B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0013J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/prof18/rssparser/model/RssImage;", "", "title", "", "url", "link", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getLink", "getTitle", "getUrl", "component1", "component2", "component3", "component4", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "isNotEmpty", "toString", "Builder", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class RssImage {
    private final String description;
    private final String link;
    private final String title;
    private final String url;

    public static /* synthetic */ RssImage copy$default(RssImage rssImage, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rssImage.title;
        }
        if ((i & 2) != 0) {
            str2 = rssImage.url;
        }
        if ((i & 4) != 0) {
            str3 = rssImage.link;
        }
        if ((i & 8) != 0) {
            str4 = rssImage.description;
        }
        return rssImage.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final RssImage copy(String title, String url, String link, String description) {
        return new RssImage(title, url, link, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RssImage)) {
            return false;
        }
        RssImage rssImage = (RssImage) other;
        return Intrinsics.areEqual(this.title, rssImage.title) && Intrinsics.areEqual(this.url, rssImage.url) && Intrinsics.areEqual(this.link, rssImage.link) && Intrinsics.areEqual(this.description, rssImage.description);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.link;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "RssImage(title=" + this.title + ", url=" + this.url + ", link=" + this.link + ", description=" + this.description + ")";
    }

    public RssImage(String str, String str2, String str3, String str4) {
        this.title = str;
        this.url = str2;
        this.link = str3;
        this.description = str4;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean isNotEmpty() {
        String str = this.url;
        if (str != null && !StringsKt.isBlank(str)) {
            return true;
        }
        String str2 = this.link;
        return (str2 == null || StringsKt.isBlank(str2)) ? false : true;
    }

    /* JADX INFO: compiled from: RssImage.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÂ\u0003J9\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0002\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/prof18/rssparser/model/RssImage$Builder;", "", "title", "", "url", "link", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "build", "Lcom/prof18/rssparser/model/RssImage;", "component1", "component2", "component3", "component4", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Builder {
        private String description;
        private String link;
        private String title;
        private String url;

        public Builder() {
            this(null, null, null, null, 15, null);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        private final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        private final String getLink() {
            return this.link;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        private final String getDescription() {
            return this.description;
        }

        public static /* synthetic */ Builder copy$default(Builder builder, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = builder.title;
            }
            if ((i & 2) != 0) {
                str2 = builder.url;
            }
            if ((i & 4) != 0) {
                str3 = builder.link;
            }
            if ((i & 8) != 0) {
                str4 = builder.description;
            }
            return builder.copy(str, str2, str3, str4);
        }

        public final Builder copy(String title, String url, String link, String description) {
            return new Builder(title, url, link, description);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) other;
            return Intrinsics.areEqual(this.title, builder.title) && Intrinsics.areEqual(this.url, builder.url) && Intrinsics.areEqual(this.link, builder.link) && Intrinsics.areEqual(this.description, builder.description);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.url;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.link;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.description;
            return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "Builder(title=" + this.title + ", url=" + this.url + ", link=" + this.link + ", description=" + this.description + ")";
        }

        public Builder(String str, String str2, String str3, String str4) {
            this.title = str;
            this.url = str2;
            this.link = str3;
            this.description = str4;
        }

        public /* synthetic */ Builder(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
        }

        public final Builder title(String title) {
            this.title = title;
            return this;
        }

        public final Builder url(String url) {
            this.url = url;
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

        public final RssImage build() {
            return new RssImage(this.title, this.url, this.link, this.description);
        }
    }
}
