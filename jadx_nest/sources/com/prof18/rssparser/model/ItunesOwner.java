package com.prof18.rssparser.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: ItunesData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/prof18/rssparser/model/ItunesOwner;", "", "name", "", "email", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getName", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "Builder", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ItunesOwner {
    private final String email;
    private final String name;

    public static /* synthetic */ ItunesOwner copy$default(ItunesOwner itunesOwner, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = itunesOwner.name;
        }
        if ((i & 2) != 0) {
            str2 = itunesOwner.email;
        }
        return itunesOwner.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final ItunesOwner copy(String name, String email) {
        return new ItunesOwner(name, email);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItunesOwner)) {
            return false;
        }
        ItunesOwner itunesOwner = (ItunesOwner) other;
        return Intrinsics.areEqual(this.name, itunesOwner.name) && Intrinsics.areEqual(this.email, itunesOwner.email);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.email;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ItunesOwner(name=" + this.name + ", email=" + this.email + ")";
    }

    public ItunesOwner(String str, String str2) {
        this.name = str;
        this.email = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: compiled from: ItunesData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÂ\u0003J!\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/prof18/rssparser/model/ItunesOwner$Builder;", "", "name", "", "email", "(Ljava/lang/String;Ljava/lang/String;)V", "build", "Lcom/prof18/rssparser/model/ItunesOwner;", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Builder {
        private String email;
        private String name;

        public Builder() {
            this(null, null, 3, null);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        private final String getEmail() {
            return this.email;
        }

        public static /* synthetic */ Builder copy$default(Builder builder, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = builder.name;
            }
            if ((i & 2) != 0) {
                str2 = builder.email;
            }
            return builder.copy(str, str2);
        }

        public final Builder copy(String name, String email) {
            return new Builder(name, email);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) other;
            return Intrinsics.areEqual(this.name, builder.name) && Intrinsics.areEqual(this.email, builder.email);
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.email;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Builder(name=" + this.name + ", email=" + this.email + ")";
        }

        public Builder(String str, String str2) {
            this.name = str;
            this.email = str2;
        }

        public /* synthetic */ Builder(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final Builder name(String name) {
            this.name = name;
            return this;
        }

        public final Builder email(String email) {
            this.email = email;
            return this;
        }

        public final ItunesOwner build() {
            return new ItunesOwner(this.name, this.email);
        }
    }
}
