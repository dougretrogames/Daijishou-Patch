package com.api.igdb.request;

import com.api.igdb.utils.TwitchToken;
import com.github.kittinunf.fuel.FuelKt;
import com.github.kittinunf.fuel.core.DeserializableKt;
import com.github.kittinunf.result.Result;
import com.google.gson.Gson;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TwitchAuthenticator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/api/igdb/request/TwitchAuthenticator;", "", "()V", "twitchClientID", "", "twitchClientSecret", "twitchGrantType", "twitchOauthTokenURL", "twitchToken", "Lcom/api/igdb/utils/TwitchToken;", "requestTwitchToken", "clientID", "clientSecret", "igdb-api-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TwitchAuthenticator {
    public static final TwitchAuthenticator INSTANCE = new TwitchAuthenticator();
    private static String twitchClientID = "";
    private static String twitchClientSecret = "";
    private static final String twitchGrantType = "client_credentials";
    private static final String twitchOauthTokenURL = "https://id.twitch.tv/oauth2/token";
    private static TwitchToken twitchToken;

    private TwitchAuthenticator() {
    }

    public final TwitchToken requestTwitchToken(String clientID, String clientSecret) {
        TwitchToken twitchToken2;
        Intrinsics.checkNotNullParameter(clientID, "clientID");
        Intrinsics.checkNotNullParameter(clientSecret, "clientSecret");
        Result result = (Result) DeserializableKt.response(FuelKt.httpPost(twitchOauthTokenURL, (List<? extends Pair<String, ? extends Object>>) CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("client_id", clientID), TuplesKt.to("client_secret", clientSecret), TuplesKt.to("grant_type", twitchGrantType)})), new TwitchAuthenticator$requestTwitchToken$$inlined$responseObject$1(new Gson())).component3();
        if (result instanceof Result.Failure) {
            twitchToken2 = null;
        } else if (result instanceof Result.Success) {
            twitchToken2 = (TwitchToken) result.get();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        twitchToken = twitchToken2;
        return twitchToken2;
    }
}
