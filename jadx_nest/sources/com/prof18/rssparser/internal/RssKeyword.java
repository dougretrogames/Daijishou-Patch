package com.prof18.rssparser.internal;

import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RssKeyword.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\n\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001*\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:¨\u0006;"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword;", "", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Channel", "Description", "Href", "Image", "Item", "Itunes", HttpHeaders.LINK, "Rss", "Title", "Url", "Lcom/prof18/rssparser/internal/RssKeyword$Channel$Channel;", "Lcom/prof18/rssparser/internal/RssKeyword$Channel$Itunes$Category;", "Lcom/prof18/rssparser/internal/RssKeyword$Channel$Itunes$NewFeedUrl;", "Lcom/prof18/rssparser/internal/RssKeyword$Channel$Itunes$Owner;", "Lcom/prof18/rssparser/internal/RssKeyword$Channel$Itunes$OwnerEmail;", "Lcom/prof18/rssparser/internal/RssKeyword$Channel$Itunes$OwnerName;", "Lcom/prof18/rssparser/internal/RssKeyword$Channel$Itunes$Text;", "Lcom/prof18/rssparser/internal/RssKeyword$Channel$Itunes$Type;", "Lcom/prof18/rssparser/internal/RssKeyword$Channel$LastBuildDate;", "Lcom/prof18/rssparser/internal/RssKeyword$Channel$UpdatePeriod;", "Lcom/prof18/rssparser/internal/RssKeyword$Description;", "Lcom/prof18/rssparser/internal/RssKeyword$Href;", "Lcom/prof18/rssparser/internal/RssKeyword$Image;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$Author;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$Category;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$Comments;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$Content;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$Enclosure;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$Guid;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$Item;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$Itunes$Episode;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$Itunes$EpisodeType;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$Itunes$Season;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$MediaContent;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$News$Image;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$PubDate;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$Source;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$Thumb;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$Thumbnail;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$Time;", "Lcom/prof18/rssparser/internal/RssKeyword$Item$Type;", "Lcom/prof18/rssparser/internal/RssKeyword$Itunes$Author;", "Lcom/prof18/rssparser/internal/RssKeyword$Itunes$Duration;", "Lcom/prof18/rssparser/internal/RssKeyword$Itunes$Explicit;", "Lcom/prof18/rssparser/internal/RssKeyword$Itunes$Image;", "Lcom/prof18/rssparser/internal/RssKeyword$Itunes$Keywords;", "Lcom/prof18/rssparser/internal/RssKeyword$Itunes$Subtitle;", "Lcom/prof18/rssparser/internal/RssKeyword$Itunes$Summary;", "Lcom/prof18/rssparser/internal/RssKeyword$Link;", "Lcom/prof18/rssparser/internal/RssKeyword$Rss;", "Lcom/prof18/rssparser/internal/RssKeyword$Title;", "Lcom/prof18/rssparser/internal/RssKeyword$Url;", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class RssKeyword {
    private final String value;

    public /* synthetic */ RssKeyword(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* JADX INFO: compiled from: RssKeyword.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Rss;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Rss extends RssKeyword {
        public static final Rss INSTANCE = new Rss();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Rss)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1254316814;
        }

        public String toString() {
            return "Rss";
        }

        private Rss() {
            super("rss", null);
        }
    }

    private RssKeyword(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: RssKeyword.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Title;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Title extends RssKeyword {
        public static final Title INSTANCE = new Title();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Title)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1485798380;
        }

        public String toString() {
            return "Title";
        }

        private Title() {
            super("title", null);
        }
    }

    /* JADX INFO: compiled from: RssKeyword.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Image;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Image extends RssKeyword {
        public static final Image INSTANCE = new Image();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Image)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1495856361;
        }

        public String toString() {
            return "Image";
        }

        private Image() {
            super("image", null);
        }
    }

    /* JADX INFO: compiled from: RssKeyword.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Link;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Link extends RssKeyword {
        public static final Link INSTANCE = new Link();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Link)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 228927166;
        }

        public String toString() {
            return HttpHeaders.LINK;
        }

        private Link() {
            super("link", null);
        }
    }

    /* JADX INFO: compiled from: RssKeyword.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Href;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Href extends RssKeyword {
        public static final Href INSTANCE = new Href();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Href)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 228816367;
        }

        public String toString() {
            return "Href";
        }

        private Href() {
            super("href", null);
        }
    }

    /* JADX INFO: compiled from: RssKeyword.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Url;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Url extends RssKeyword {
        public static final Url INSTANCE = new Url();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Url)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1254319659;
        }

        public String toString() {
            return "Url";
        }

        private Url() {
            super("url", null);
        }
    }

    /* JADX INFO: compiled from: RssKeyword.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Description;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Description extends RssKeyword {
        public static final Description INSTANCE = new Description();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Description)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 983083192;
        }

        public String toString() {
            return "Description";
        }

        private Description() {
            super("description", null);
        }
    }

    /* JADX INFO: compiled from: RssKeyword.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Itunes;", "", "()V", "Author", "Duration", "Explicit", "Image", "Keywords", "Subtitle", "Summary", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Itunes {
        public static final Itunes INSTANCE = new Itunes();

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Itunes$Author;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Author extends RssKeyword {
            public static final Author INSTANCE = new Author();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Author)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1234531363;
            }

            public String toString() {
                return "Author";
            }

            private Author() {
                super("itunes:author", null);
            }
        }

        private Itunes() {
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Itunes$Duration;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Duration extends RssKeyword {
            public static final Duration INSTANCE = new Duration();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Duration)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1843550764;
            }

            public String toString() {
                return "Duration";
            }

            private Duration() {
                super("itunes:duration", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Itunes$Keywords;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Keywords extends RssKeyword {
            public static final Keywords INSTANCE = new Keywords();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Keywords)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 63745090;
            }

            public String toString() {
                return "Keywords";
            }

            private Keywords() {
                super("itunes:keywords", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Itunes$Image;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Image extends RssKeyword {
            public static final Image INSTANCE = new Image();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Image)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1754160189;
            }

            public String toString() {
                return "Image";
            }

            private Image() {
                super("itunes:image", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Itunes$Explicit;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Explicit extends RssKeyword {
            public static final Explicit INSTANCE = new Explicit();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Explicit)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1906471628;
            }

            public String toString() {
                return "Explicit";
            }

            private Explicit() {
                super("itunes:explicit", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Itunes$Subtitle;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Subtitle extends RssKeyword {
            public static final Subtitle INSTANCE = new Subtitle();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Subtitle)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1775065264;
            }

            public String toString() {
                return "Subtitle";
            }

            private Subtitle() {
                super("itunes:subtitle", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Itunes$Summary;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Summary extends RssKeyword {
            public static final Summary INSTANCE = new Summary();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Summary)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1595365362;
            }

            public String toString() {
                return "Summary";
            }

            private Summary() {
                super("itunes:summary", null);
            }
        }
    }

    /* JADX INFO: compiled from: RssKeyword.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Channel;", "", "()V", "Channel", "Itunes", "LastBuildDate", "UpdatePeriod", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Channel {
        public static final Channel INSTANCE = new Channel();

        /* JADX INFO: renamed from: com.prof18.rssparser.internal.RssKeyword$Channel$Channel, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Channel$Channel;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class C0082Channel extends RssKeyword {
            public static final C0082Channel INSTANCE = new C0082Channel();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof C0082Channel)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1890560588;
            }

            public String toString() {
                return "Channel";
            }

            private C0082Channel() {
                super("channel", null);
            }
        }

        private Channel() {
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Channel$UpdatePeriod;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UpdatePeriod extends RssKeyword {
            public static final UpdatePeriod INSTANCE = new UpdatePeriod();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdatePeriod)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1911616039;
            }

            public String toString() {
                return "UpdatePeriod";
            }

            private UpdatePeriod() {
                super("sy:updatePeriod", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Channel$LastBuildDate;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LastBuildDate extends RssKeyword {
            public static final LastBuildDate INSTANCE = new LastBuildDate();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LastBuildDate)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -151705289;
            }

            public String toString() {
                return "LastBuildDate";
            }

            private LastBuildDate() {
                super("lastBuildDate", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Channel$Itunes;", "", "()V", "Category", "NewFeedUrl", "Owner", "OwnerEmail", "OwnerName", "Text", "Type", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Itunes {
            public static final Itunes INSTANCE = new Itunes();

            /* JADX INFO: compiled from: RssKeyword.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Channel$Itunes$Category;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Category extends RssKeyword {
                public static final Category INSTANCE = new Category();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Category)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return -900466037;
                }

                public String toString() {
                    return "Category";
                }

                private Category() {
                    super("itunes:category", null);
                }
            }

            private Itunes() {
            }

            /* JADX INFO: compiled from: RssKeyword.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Channel$Itunes$Owner;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Owner extends RssKeyword {
                public static final Owner INSTANCE = new Owner();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Owner)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return -657102778;
                }

                public String toString() {
                    return "Owner";
                }

                private Owner() {
                    super("itunes:owner", null);
                }
            }

            /* JADX INFO: compiled from: RssKeyword.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Channel$Itunes$OwnerName;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class OwnerName extends RssKeyword {
                public static final OwnerName INSTANCE = new OwnerName();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof OwnerName)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return 601932785;
                }

                public String toString() {
                    return "OwnerName";
                }

                private OwnerName() {
                    super("itunes:name", null);
                }
            }

            /* JADX INFO: compiled from: RssKeyword.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Channel$Itunes$OwnerEmail;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class OwnerEmail extends RssKeyword {
                public static final OwnerEmail INSTANCE = new OwnerEmail();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof OwnerEmail)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return 1472081654;
                }

                public String toString() {
                    return "OwnerEmail";
                }

                private OwnerEmail() {
                    super("itunes:email", null);
                }
            }

            /* JADX INFO: compiled from: RssKeyword.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Channel$Itunes$Type;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Type extends RssKeyword {
                public static final Type INSTANCE = new Type();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Type)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return -575235257;
                }

                public String toString() {
                    return "Type";
                }

                private Type() {
                    super("itunes:type", null);
                }
            }

            /* JADX INFO: compiled from: RssKeyword.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Channel$Itunes$NewFeedUrl;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class NewFeedUrl extends RssKeyword {
                public static final NewFeedUrl INSTANCE = new NewFeedUrl();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof NewFeedUrl)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return 557712254;
                }

                public String toString() {
                    return "NewFeedUrl";
                }

                private NewFeedUrl() {
                    super("itunes:new-feed-url", null);
                }
            }

            /* JADX INFO: compiled from: RssKeyword.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Channel$Itunes$Text;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Text extends RssKeyword {
                public static final Text INSTANCE = new Text();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Text)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return -575254214;
                }

                public String toString() {
                    return "Text";
                }

                private Text() {
                    super("text", null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: RssKeyword.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001:\u0010\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0013"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item;", "", "()V", "Author", "Category", "Comments", "Content", "Enclosure", "Guid", "Item", "Itunes", "MediaContent", "News", "PubDate", "Source", "Thumb", "Thumbnail", "Time", "Type", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Item {
        public static final Item INSTANCE = new Item();

        /* JADX INFO: renamed from: com.prof18.rssparser.internal.RssKeyword$Item$Item, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$Item;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class C0083Item extends RssKeyword {
            public static final C0083Item INSTANCE = new C0083Item();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof C0083Item)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1313356566;
            }

            public String toString() {
                return "Item";
            }

            private C0083Item() {
                super("item", null);
            }
        }

        private Item() {
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$Author;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Author extends RssKeyword {
            public static final Author INSTANCE = new Author();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Author)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 357061026;
            }

            public String toString() {
                return "Author";
            }

            private Author() {
                super("dc:creator", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$Category;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Category extends RssKeyword {
            public static final Category INSTANCE = new Category();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Category)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1844296875;
            }

            public String toString() {
                return "Category";
            }

            private Category() {
                super("category", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$Thumbnail;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Thumbnail extends RssKeyword {
            public static final Thumbnail INSTANCE = new Thumbnail();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Thumbnail)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1573939851;
            }

            public String toString() {
                return "Thumbnail";
            }

            private Thumbnail() {
                super("media:thumbnail", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$MediaContent;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class MediaContent extends RssKeyword {
            public static final MediaContent INSTANCE = new MediaContent();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MediaContent)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 243791564;
            }

            public String toString() {
                return "MediaContent";
            }

            private MediaContent() {
                super("media:content", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$Enclosure;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Enclosure extends RssKeyword {
            public static final Enclosure INSTANCE = new Enclosure();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Enclosure)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1471618565;
            }

            public String toString() {
                return "Enclosure";
            }

            private Enclosure() {
                super("enclosure", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$Content;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Content extends RssKeyword {
            public static final Content INSTANCE = new Content();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Content)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -217970878;
            }

            public String toString() {
                return "Content";
            }

            private Content() {
                super("content:encoded", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$PubDate;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class PubDate extends RssKeyword {
            public static final PubDate INSTANCE = new PubDate();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PubDate)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1406065900;
            }

            public String toString() {
                return "PubDate";
            }

            private PubDate() {
                super("pubDate", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$Time;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Time extends RssKeyword {
            public static final Time INSTANCE = new Time();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Time)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1313039196;
            }

            public String toString() {
                return "Time";
            }

            private Time() {
                super("time", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$Type;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Type extends RssKeyword {
            public static final Type INSTANCE = new Type();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Type)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1313023727;
            }

            public String toString() {
                return "Type";
            }

            private Type() {
                super("type", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$Guid;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Guid extends RssKeyword {
            public static final Guid INSTANCE = new Guid();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Guid)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1313415072;
            }

            public String toString() {
                return "Guid";
            }

            private Guid() {
                super("guid", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$Source;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Source extends RssKeyword {
            public static final Source INSTANCE = new Source();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Source)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 866883634;
            }

            public String toString() {
                return "Source";
            }

            private Source() {
                super("source", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$Comments;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Comments extends RssKeyword {
            public static final Comments INSTANCE = new Comments();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Comments)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1797743691;
            }

            public String toString() {
                return "Comments";
            }

            private Comments() {
                super("comments", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$Thumb;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Thumb extends RssKeyword {
            public static final Thumb INSTANCE = new Thumb();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Thumb)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2049531169;
            }

            public String toString() {
                return "Thumb";
            }

            private Thumb() {
                super("thumb", null);
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$News;", "", "()V", "Image", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class News {
            public static final News INSTANCE = new News();

            /* JADX INFO: compiled from: RssKeyword.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$News$Image;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Image extends RssKeyword {
                public static final Image INSTANCE = new Image();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Image)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return -542846217;
                }

                public String toString() {
                    return "Image";
                }

                private Image() {
                    super("News:Image", null);
                }
            }

            private News() {
            }
        }

        /* JADX INFO: compiled from: RssKeyword.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$Itunes;", "", "()V", "Episode", "EpisodeType", "Season", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Itunes {
            public static final Itunes INSTANCE = new Itunes();

            /* JADX INFO: compiled from: RssKeyword.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$Itunes$Episode;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Episode extends RssKeyword {
                public static final Episode INSTANCE = new Episode();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Episode)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return 674567606;
                }

                public String toString() {
                    return "Episode";
                }

                private Episode() {
                    super("itunes:episode", null);
                }
            }

            private Itunes() {
            }

            /* JADX INFO: compiled from: RssKeyword.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$Itunes$Season;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Season extends RssKeyword {
                public static final Season INSTANCE = new Season();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Season)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return 1382002632;
                }

                public String toString() {
                    return "Season";
                }

                private Season() {
                    super("itunes:season", null);
                }
            }

            /* JADX INFO: compiled from: RssKeyword.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/RssKeyword$Item$Itunes$EpisodeType;", "Lcom/prof18/rssparser/internal/RssKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class EpisodeType extends RssKeyword {
                public static final EpisodeType INSTANCE = new EpisodeType();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof EpisodeType)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return 936332816;
                }

                public String toString() {
                    return "EpisodeType";
                }

                private EpisodeType() {
                    super("itunes:episodeType", null);
                }
            }
        }
    }
}
