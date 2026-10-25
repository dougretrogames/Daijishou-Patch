package org.retroachivements.api.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: RetroCredentials.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lorg/retroachivements/api/data/RetroCredentials;", "", "username", "", "apiKey", "(Ljava/lang/String;Ljava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "getUsername", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class RetroCredentials {
    private final String apiKey;
    private final String username;

    public static /* synthetic */ RetroCredentials copy$default(RetroCredentials retroCredentials, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = retroCredentials.username;
        }
        if ((i & 2) != 0) {
            str2 = retroCredentials.apiKey;
        }
        return retroCredentials.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    public final RetroCredentials copy(String username, String apiKey) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        return new RetroCredentials(username, apiKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RetroCredentials)) {
            return false;
        }
        RetroCredentials retroCredentials = (RetroCredentials) other;
        return Intrinsics.areEqual(this.username, retroCredentials.username) && Intrinsics.areEqual(this.apiKey, retroCredentials.apiKey);
    }

    public int hashCode() {
        return (this.username.hashCode() * 31) + this.apiKey.hashCode();
    }

    public String toString() {
        return "RetroCredentials(username=" + this.username + ", apiKey=" + this.apiKey + ')';
    }

    public RetroCredentials(String username, String apiKey) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        this.username = username;
        this.apiKey = apiKey;
    }

    public final String getUsername() {
        return this.username;
    }

    public final String getApiKey() {
        return this.apiKey;
    }
}
