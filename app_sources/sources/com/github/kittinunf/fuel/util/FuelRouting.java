package com.github.kittinunf.fuel.util;

import com.github.kittinunf.fuel.core.Encoding;
import com.github.kittinunf.fuel.core.Method;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.RequestFactory;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;

/* INFO: compiled from: FuelRouting.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u000ej\u0002`\u000f\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R.\u0010\u0016\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018\u0018\u00010\u0017j\u0004\u0018\u0001`\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0005R\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/github/kittinunf/fuel/util/FuelRouting;", "Lcom/github/kittinunf/fuel/core/RequestFactory$RequestConvertible;", "basePath", "", "getBasePath", "()Ljava/lang/String;", "body", "getBody", "bytes", "", "getBytes", "()[B", "headers", "", "", "Lcom/github/kittinunf/fuel/core/HeaderValues;", "getHeaders", "()Ljava/util/Map;", "method", "Lcom/github/kittinunf/fuel/core/Method;", "getMethod", "()Lcom/github/kittinunf/fuel/core/Method;", "params", "", "Lkotlin/Pair;", "", "Lcom/github/kittinunf/fuel/core/Parameters;", "getParams", "()Ljava/util/List;", "path", "getPath", "request", "Lcom/github/kittinunf/fuel/core/Request;", "getRequest", "()Lcom/github/kittinunf/fuel/core/Request;", "fuel"}, k = 1, mv = {1, 4, 0})
public interface FuelRouting extends RequestFactory.RequestConvertible {
    String getBasePath();

    String getBody();

    byte[] getBytes();

    Map<String, Collection<String>> getHeaders();

    Method getMethod();

    List<Pair<String, Object>> getParams();

    String getPath();

    @Override // com.github.kittinunf.fuel.core.RequestFactory.RequestConvertible
    Request getRequest();

    /* INFO: compiled from: FuelRouting.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static Request getRequest(FuelRouting fuelRouting) {
            byte[] bytes;
            Request request = new Encoding(fuelRouting.getMethod(), fuelRouting.getPath(), fuelRouting.getBasePath(), fuelRouting.getParams()).getRequest();
            String body = fuelRouting.getBody();
            if ((body == null || Request.DefaultImpls.body$default(request, body, (Charset) null, 2, (Object) null) == null) && (bytes = fuelRouting.getBytes()) != null) {
                Request.DefaultImpls.body$default(request, bytes, (Charset) null, 2, (Object) null);
            }
            Map<String, Collection<String>> headers = fuelRouting.getHeaders();
            if (headers == null) {
                headers = MapsKt.emptyMap();
            }
            return request.header(headers);
        }
    }
}
