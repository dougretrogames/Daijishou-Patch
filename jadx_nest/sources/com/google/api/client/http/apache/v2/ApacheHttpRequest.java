package com.google.api.client.http.apache.v2;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpRequestBase;

/* INFO: loaded from: classes3.dex */
final class ApacheHttpRequest extends LowLevelHttpRequest {
    private final HttpClient httpClient;
    private final HttpRequestBase request;
    private RequestConfig.Builder requestConfig = RequestConfig.custom().setRedirectsEnabled(false).setNormalizeUri(false).setStaleConnectionCheckEnabled(false);

    ApacheHttpRequest(HttpClient httpClient, HttpRequestBase httpRequestBase) {
        this.httpClient = httpClient;
        this.request = httpRequestBase;
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void addHeader(String str, String str2) {
        this.request.addHeader(str, str2);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void setTimeout(int i, int i2) throws IOException {
        this.requestConfig.setConnectTimeout(i).setSocketTimeout(i2);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse execute() throws IOException {
        if (getStreamingContent() != null) {
            HttpRequestBase httpRequestBase = this.request;
            Preconditions.checkState(httpRequestBase instanceof HttpEntityEnclosingRequest, "Apache HTTP client does not support %s requests with content.", httpRequestBase.getRequestLine().getMethod());
            ContentEntity contentEntity = new ContentEntity(getContentLength(), getStreamingContent());
            contentEntity.setContentEncoding(getContentEncoding());
            contentEntity.setContentType(getContentType());
            if (getContentLength() == -1) {
                contentEntity.setChunked(true);
            }
            ((HttpEntityEnclosingRequest) this.request).setEntity(contentEntity);
        }
        this.request.setConfig(this.requestConfig.build());
        HttpRequestBase httpRequestBase2 = this.request;
        return new ApacheHttpResponse(httpRequestBase2, this.httpClient.execute(httpRequestBase2));
    }
}
