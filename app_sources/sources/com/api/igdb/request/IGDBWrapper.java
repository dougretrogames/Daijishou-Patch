package com.api.igdb.request;

import com.api.igdb.exceptions.RequestException;
import com.api.igdb.utils.Endpoint;
import com.github.kittinunf.fuel.FuelKt;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;
import com.github.kittinunf.result.Result;
import com.google.android.gms.actions.SearchIntents;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: IGDBWrapper.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005J\"\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/api/igdb/request/IGDBWrapper;", "", "()V", "requestHeaders", "", "", "apiJsonRequest", "endpoint", "Lcom/api/igdb/utils/Endpoint;", SearchIntents.EXTRA_QUERY, "apiProtoRequest", "", "setCredentials", "", "clientID", "accessToken", "setupProxy", "proxyURL", "proxyHeaders", "igdb-api-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IGDBWrapper {
    public static final IGDBWrapper INSTANCE = new IGDBWrapper();
    private static Map<String, ? extends Object> requestHeaders = MapsKt.mapOf(TuplesKt.to("x-user-agent", "igdb-api-jvm"));

    private IGDBWrapper() {
    }

    public final void setCredentials(String clientID, String accessToken) {
        Intrinsics.checkNotNullParameter(clientID, "clientID");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        requestHeaders = MapsKt.mapOf(TuplesKt.to("client-id", clientID), TuplesKt.to("authorization", "Bearer " + accessToken), TuplesKt.to("x-user-agent", "igdb-api-jvm"));
    }

    public final void setupProxy(String proxyURL, Map<String, String> proxyHeaders) {
        Intrinsics.checkNotNullParameter(proxyURL, "proxyURL");
        Intrinsics.checkNotNullParameter(proxyHeaders, "proxyHeaders");
        IGDBWrapperKt.IGDB_API_URL = proxyURL;
        MapsKt.toMutableMap(proxyHeaders).put("x-user-agent", "igdb-api-jvm");
        requestHeaders = MapsKt.toMap(proxyHeaders);
    }

    public final byte[] apiProtoRequest(Endpoint endpoint, String query) throws RequestException {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(query, "query");
        Triple<Request, Response, Result<String, FuelError>> tripleResponseString = Request.DefaultImpls.body$default(FuelKt.httpPost$default(IGDBWrapperKt.IGDB_API_URL + endpoint.url() + ".pb", (List) null, 1, (Object) null).header(requestHeaders), query, (Charset) null, 2, (Object) null).responseString();
        Request requestComponent1 = tripleResponseString.component1();
        Response responseComponent2 = tripleResponseString.component2();
        Result<String, FuelError> resultComponent3 = tripleResponseString.component3();
        if (responseComponent2.getStatusCode() != 200) {
            throw new RequestException(responseComponent2.getStatusCode(), requestComponent1, resultComponent3);
        }
        return responseComponent2.getData();
    }

    public final String apiJsonRequest(Endpoint endpoint, String query) throws RequestException {
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(query, "query");
        Triple<Request, Response, Result<String, FuelError>> tripleResponseString = Request.DefaultImpls.body$default(FuelKt.httpPost$default(IGDBWrapperKt.IGDB_API_URL + endpoint.url(), (List) null, 1, (Object) null).header(requestHeaders), query, (Charset) null, 2, (Object) null).responseString();
        Request requestComponent1 = tripleResponseString.component1();
        Response responseComponent2 = tripleResponseString.component2();
        Result<String, FuelError> resultComponent3 = tripleResponseString.component3();
        if (responseComponent2.getStatusCode() != 200) {
            throw new RequestException(responseComponent2.getStatusCode(), requestComponent1, resultComponent3);
        }
        return resultComponent3.get();
    }
}
