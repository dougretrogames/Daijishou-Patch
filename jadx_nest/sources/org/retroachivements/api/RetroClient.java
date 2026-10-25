package org.retroachivements.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.retroachivements.api.core.CoreClient;
import org.retroachivements.api.data.RetroCredentials;

/* JADX INFO: compiled from: RetroClient.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lorg/retroachivements/api/RetroClient;", "Lorg/retroachivements/api/core/CoreClient;", "credentials", "Lorg/retroachivements/api/data/RetroCredentials;", "debugging", "", "(Lorg/retroachivements/api/data/RetroCredentials;Z)V", "api", "Lorg/retroachivements/api/RetroInterface;", "getApi", "()Lorg/retroachivements/api/RetroInterface;", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroClient extends CoreClient {
    private final RetroInterface api;

    public /* synthetic */ RetroClient(RetroCredentials retroCredentials, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(retroCredentials, (i & 2) != 0 ? false : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetroClient(RetroCredentials credentials, boolean z) {
        super(credentials, "https://retroachievements.org/", z);
        Intrinsics.checkNotNullParameter(credentials, "credentials");
        Object objCreate = getRetroClient().create(RetroInterface.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        this.api = (RetroInterface) objCreate;
    }

    public final RetroInterface getApi() {
        return this.api;
    }
}
