package com.api.igdb.utils;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: TwitchToken.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\u0006\u0010\u0016\u001a\u00020\u0005J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/api/igdb/utils/TwitchToken;", "Ljava/io/Serializable;", "access_token", "", "expires_in", "", "token_type", "(Ljava/lang/String;JLjava/lang/String;)V", "getAccess_token", "()Ljava/lang/String;", "expiresAt", "getExpires_in", "()J", "getToken_type", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "", "getExpiresUnix", "hashCode", "", "toString", "igdb-api-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class TwitchToken implements Serializable {
    private final String access_token;
    private long expiresAt;
    private final long expires_in;
    private final String token_type;

    public static /* synthetic */ TwitchToken copy$default(TwitchToken twitchToken, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = twitchToken.access_token;
        }
        if ((i & 2) != 0) {
            j = twitchToken.expires_in;
        }
        if ((i & 4) != 0) {
            str2 = twitchToken.token_type;
        }
        return twitchToken.copy(str, j, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAccess_token() {
        return this.access_token;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getExpires_in() {
        return this.expires_in;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getToken_type() {
        return this.token_type;
    }

    public final TwitchToken copy(String access_token, long expires_in, String token_type) {
        Intrinsics.checkNotNullParameter(access_token, "access_token");
        Intrinsics.checkNotNullParameter(token_type, "token_type");
        return new TwitchToken(access_token, expires_in, token_type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TwitchToken)) {
            return false;
        }
        TwitchToken twitchToken = (TwitchToken) other;
        return Intrinsics.areEqual(this.access_token, twitchToken.access_token) && this.expires_in == twitchToken.expires_in && Intrinsics.areEqual(this.token_type, twitchToken.token_type);
    }

    public int hashCode() {
        return (((this.access_token.hashCode() * 31) + Long.hashCode(this.expires_in)) * 31) + this.token_type.hashCode();
    }

    public String toString() {
        return "TwitchToken(access_token=" + this.access_token + ", expires_in=" + this.expires_in + ", token_type=" + this.token_type + ")";
    }

    public TwitchToken(String access_token, long j, String token_type) {
        Intrinsics.checkNotNullParameter(access_token, "access_token");
        Intrinsics.checkNotNullParameter(token_type, "token_type");
        this.access_token = access_token;
        this.expires_in = j;
        this.token_type = token_type;
        this.expiresAt = System.currentTimeMillis() + (j * ((long) 1000));
    }

    public final String getAccess_token() {
        return this.access_token;
    }

    public final long getExpires_in() {
        return this.expires_in;
    }

    public final String getToken_type() {
        return this.token_type;
    }

    /* JADX INFO: renamed from: getExpiresUnix, reason: from getter */
    public final long getExpiresAt() {
        return this.expiresAt;
    }
}
