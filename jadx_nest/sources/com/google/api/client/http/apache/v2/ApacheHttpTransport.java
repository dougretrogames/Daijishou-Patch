package com.google.api.client.http.apache.v2;

import com.google.api.client.http.HttpTransport;
import java.io.IOException;
import java.net.ProxySelector;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;

/* JADX INFO: loaded from: classes3.dex */
public final class ApacheHttpTransport extends HttpTransport {
    private final HttpClient httpClient;
    private final boolean isMtls;

    @Override // com.google.api.client.http.HttpTransport
    public boolean supportsMethod(String str) {
        return true;
    }

    public ApacheHttpTransport() {
        this(newDefaultHttpClient(), false);
    }

    public ApacheHttpTransport(HttpClient httpClient) {
        this.httpClient = httpClient;
        this.isMtls = false;
    }

    public ApacheHttpTransport(HttpClient httpClient, boolean z) {
        this.httpClient = httpClient;
        this.isMtls = z;
    }

    public static HttpClient newDefaultHttpClient() {
        return newDefaultHttpClientBuilder().build();
    }

    public static HttpClientBuilder newDefaultHttpClientBuilder() {
        return HttpClientBuilder.create().useSystemProperties().setSSLSocketFactory(SSLConnectionSocketFactory.getSocketFactory()).setMaxConnTotal(200).setMaxConnPerRoute(20).setConnectionTimeToLive(-1L, TimeUnit.MILLISECONDS).setRoutePlanner(new SystemDefaultRoutePlanner(ProxySelector.getDefault())).disableRedirectHandling().disableAutomaticRetries();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.api.client.http.HttpTransport
    public ApacheHttpRequest buildRequest(String str, String str2) {
        HttpRequestBase httpExtensionMethod;
        if (str.equals("DELETE")) {
            httpExtensionMethod = new HttpDelete(str2);
        } else if (str.equals("GET")) {
            httpExtensionMethod = new HttpGet(str2);
        } else if (str.equals("HEAD")) {
            httpExtensionMethod = new HttpHead(str2);
        } else if (str.equals("PATCH")) {
            httpExtensionMethod = new HttpPatch(str2);
        } else if (str.equals("POST")) {
            httpExtensionMethod = new HttpPost(str2);
        } else if (str.equals("PUT")) {
            httpExtensionMethod = new HttpPut(str2);
        } else if (str.equals("TRACE")) {
            httpExtensionMethod = new HttpTrace(str2);
        } else if (str.equals("OPTIONS")) {
            httpExtensionMethod = new HttpOptions(str2);
        } else {
            httpExtensionMethod = new HttpExtensionMethod(str, str2);
        }
        return new ApacheHttpRequest(this.httpClient, httpExtensionMethod);
    }

    @Override // com.google.api.client.http.HttpTransport
    public void shutdown() throws IOException {
        HttpClient httpClient = this.httpClient;
        if (httpClient instanceof CloseableHttpClient) {
            ((CloseableHttpClient) httpClient).close();
        }
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    @Override // com.google.api.client.http.HttpTransport
    public boolean isMtls() {
        return this.isMtls;
    }
}
