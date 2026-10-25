package com.prof18.rssparser.internal;

import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AtomKeyword.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0007\u0007\b\t\n\u000b\f\rB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0013\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword;", "", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Atom", "Entry", "Icon", HttpHeaders.LINK, "Subtitle", "Title", "Updated", "Lcom/prof18/rssparser/internal/AtomKeyword$Atom;", "Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Author;", "Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Category;", "Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Content;", "Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Description;", "Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Email;", "Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Guid;", "Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Item;", "Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Published;", "Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Term;", "Lcom/prof18/rssparser/internal/AtomKeyword$Icon;", "Lcom/prof18/rssparser/internal/AtomKeyword$Link;", "Lcom/prof18/rssparser/internal/AtomKeyword$Link$Edit;", "Lcom/prof18/rssparser/internal/AtomKeyword$Link$Href;", "Lcom/prof18/rssparser/internal/AtomKeyword$Link$Rel;", "Lcom/prof18/rssparser/internal/AtomKeyword$Link$Self;", "Lcom/prof18/rssparser/internal/AtomKeyword$Subtitle;", "Lcom/prof18/rssparser/internal/AtomKeyword$Title;", "Lcom/prof18/rssparser/internal/AtomKeyword$Updated;", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AtomKeyword {
    private final String value;

    public /* synthetic */ AtomKeyword(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* JADX INFO: compiled from: AtomKeyword.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Atom;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Atom extends AtomKeyword {
        public static final Atom INSTANCE = new Atom();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Atom)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1414086042;
        }

        public String toString() {
            return "Atom";
        }

        private Atom() {
            super("feed", null);
        }
    }

    private AtomKeyword(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: AtomKeyword.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Title;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Title extends AtomKeyword {
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
            return 904218415;
        }

        public String toString() {
            return "Title";
        }

        private Title() {
            super("title", null);
        }
    }

    /* JADX INFO: compiled from: AtomKeyword.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Icon;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Icon extends AtomKeyword {
        public static final Icon INSTANCE = new Icon();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Icon)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1414308034;
        }

        public String toString() {
            return "Icon";
        }

        private Icon() {
            super("icon", null);
        }
    }

    /* JADX INFO: compiled from: AtomKeyword.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\n\u0018\u00002\u00020\u0001:\u0004\u000b\f\r\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000f"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Link;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "Edit", "Href", "Rel", "Self", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Link extends AtomKeyword {
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
            return 1414403139;
        }

        public String toString() {
            return HttpHeaders.LINK;
        }

        /* JADX INFO: compiled from: AtomKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Link$Href;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Href extends AtomKeyword {
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
                return -1034040810;
            }

            public String toString() {
                return "Href";
            }

            private Href() {
                super("href", null);
            }
        }

        private Link() {
            super("link", null);
        }

        /* JADX INFO: compiled from: AtomKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Link$Rel;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Rel extends AtomKeyword {
            public static final Rel INSTANCE = new Rel();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Rel)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1695914930;
            }

            public String toString() {
                return "Rel";
            }

            private Rel() {
                super("rel", null);
            }
        }

        /* JADX INFO: compiled from: AtomKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Link$Edit;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Edit extends AtomKeyword {
            public static final Edit INSTANCE = new Edit();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Edit)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1034143499;
            }

            public String toString() {
                return "Edit";
            }

            private Edit() {
                super("edit", null);
            }
        }

        /* JADX INFO: compiled from: AtomKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Link$Self;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Self extends AtomKeyword {
            public static final Self INSTANCE = new Self();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Self)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1033725385;
            }

            public String toString() {
                return "Self";
            }

            private Self() {
                super("self", null);
            }
        }
    }

    /* JADX INFO: compiled from: AtomKeyword.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Subtitle;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Subtitle extends AtomKeyword {
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
            return -654482463;
        }

        public String toString() {
            return "Subtitle";
        }

        private Subtitle() {
            super("subtitle", null);
        }
    }

    /* JADX INFO: compiled from: AtomKeyword.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Updated;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Updated extends AtomKeyword {
        public static final Updated INSTANCE = new Updated();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Updated)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1851642926;
        }

        public String toString() {
            return "Updated";
        }

        private Updated() {
            super("updated", null);
        }
    }

    /* JADX INFO: compiled from: AtomKeyword.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\n\u0018\u00002\u00020\u0001:\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0006\u001a\u00020\u0007HÖ\u0001J\t\u0010\b\u001a\u00020\tHÖ\u0001¨\u0006\u0013"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Entry;", "", "()V", "equals", "", "other", "hashCode", "", "toString", "", "Author", "Category", "Content", "Description", "Email", "Guid", "Item", "Published", "Term", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Entry {
        public static final Entry INSTANCE = new Entry();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 890514761;
        }

        public String toString() {
            return "Entry";
        }

        /* JADX INFO: compiled from: AtomKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Item;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Item extends AtomKeyword {
            public static final Item INSTANCE = new Item();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Item)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 549249208;
            }

            public String toString() {
                return "Item";
            }

            private Item() {
                super("entry", null);
            }
        }

        private Entry() {
        }

        /* JADX INFO: compiled from: AtomKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Guid;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Guid extends AtomKeyword {
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
                return 549190702;
            }

            public String toString() {
                return "Guid";
            }

            private Guid() {
                super("id", null);
            }
        }

        /* JADX INFO: compiled from: AtomKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Content;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Content extends AtomKeyword {
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
                return 1988145332;
            }

            public String toString() {
                return "Content";
            }

            private Content() {
                super("content", null);
            }
        }

        /* JADX INFO: compiled from: AtomKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Published;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Published extends AtomKeyword {
            public static final Published INSTANCE = new Published();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Published)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1201732457;
            }

            public String toString() {
                return "Published";
            }

            private Published() {
                super("published", null);
            }
        }

        /* JADX INFO: compiled from: AtomKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Category;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Category extends AtomKeyword {
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
                return 2120796195;
            }

            public String toString() {
                return "Category";
            }

            private Category() {
                super("category", null);
            }
        }

        /* JADX INFO: compiled from: AtomKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Term;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Term extends AtomKeyword {
            public static final Term INSTANCE = new Term();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Term)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 549562897;
            }

            public String toString() {
                return "Term";
            }

            private Term() {
                super("term", null);
            }
        }

        /* JADX INFO: compiled from: AtomKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Description;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Description extends AtomKeyword {
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
                return -1591711049;
            }

            public String toString() {
                return "Description";
            }

            private Description() {
                super("summary", null);
            }
        }

        /* JADX INFO: compiled from: AtomKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Author;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Author extends AtomKeyword {
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
                return -680152592;
            }

            public String toString() {
                return "Author";
            }

            private Author() {
                super("name", null);
            }
        }

        /* JADX INFO: compiled from: AtomKeyword.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/prof18/rssparser/internal/AtomKeyword$Entry$Email;", "Lcom/prof18/rssparser/internal/AtomKeyword;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Email extends AtomKeyword {
            public static final Email INSTANCE = new Email();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Email)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -157050217;
            }

            public String toString() {
                return "Email";
            }

            private Email() {
                super("email", null);
            }
        }
    }
}
