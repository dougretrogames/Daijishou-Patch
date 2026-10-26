package co.infinum.retromock;

import co.infinum.retromock.meta.MockHeader;
import co.infinum.retromock.meta.MockResponse;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;

/* INFO: loaded from: classes3.dex */
final class ResponseParamsProducer implements ParamsProducer {
    private final Map<MockResponse, ResponseParams> cache = new HashMap();
    private final ResponseParams defaults;
    private final ResponseIterator<MockResponse> iterator;
    private final Retromock retromock;

    ResponseParamsProducer(Retromock retromock, ResponseIterator<MockResponse> responseIterator, ResponseParams responseParams) {
        this.retromock = retromock;
        this.iterator = responseIterator;
        this.defaults = responseParams;
    }

    @Override // co.infinum.retromock.ParamsProducer
    public ResponseParams produce() {
        MockResponse next = this.iterator.next();
        ResponseParams responseParams = this.cache.get(next);
        if (responseParams != null) {
            return responseParams;
        }
        ResponseParams.Builder builderNewBuilder = this.defaults.newBuilder();
        parseResponseAnnotation(builderNewBuilder, next, this.retromock);
        ResponseParams responseParamsBuild = builderNewBuilder.build();
        this.cache.put(next, responseParamsBuild);
        return responseParamsBuild;
    }

    private static void parseResponseAnnotation(ResponseParams.Builder builder, MockResponse mockResponse, Retromock retromock) {
        builder.code(mockResponse.code()).message(mockResponse.message()).headers(convertHeaders(mockResponse.headers())).bodyFactory(new RetromockBodyFactory(retromock.bodyFactory(mockResponse.bodyFactory()), mockResponse.body()));
    }

    private static Headers convertHeaders(MockHeader[] mockHeaderArr) {
        Headers.Builder builder = new Headers.Builder();
        for (MockHeader mockHeader : mockHeaderArr) {
            builder.add(mockHeader.name(), mockHeader.value());
        }
        return builder.build();
    }
}
