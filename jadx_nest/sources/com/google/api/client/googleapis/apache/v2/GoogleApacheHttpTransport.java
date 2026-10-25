package com.google.api.client.googleapis.apache.v2;

import androidx.webkit.ProxyConfig;
import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.mtls.MtlsProvider;
import com.google.api.client.googleapis.mtls.MtlsUtils;
import com.google.api.client.http.apache.v2.ApacheHttpTransport;
import com.google.api.client.util.SslUtils;
import java.io.IOException;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;

/* JADX INFO: loaded from: classes3.dex */
public final class GoogleApacheHttpTransport {
    public static ApacheHttpTransport newTrustedTransport() throws GeneralSecurityException, IOException {
        return newTrustedTransport(MtlsUtils.getDefaultMtlsProvider());
    }

    public static ApacheHttpTransport newTrustedTransport(MtlsProvider mtlsProvider) throws GeneralSecurityException, IOException {
        SocketFactoryRegistryHandler socketFactoryRegistryHandler = new SocketFactoryRegistryHandler(mtlsProvider);
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistryHandler.getSocketFactoryRegistry(), null, null, null, -1L, TimeUnit.MILLISECONDS);
        poolingHttpClientConnectionManager.setValidateAfterInactivity(-1);
        return new ApacheHttpTransport(HttpClientBuilder.create().useSystemProperties().setMaxConnTotal(200).setMaxConnPerRoute(20).setRoutePlanner(new SystemDefaultRoutePlanner(ProxySelector.getDefault())).setConnectionManager(poolingHttpClientConnectionManager).disableRedirectHandling().disableAutomaticRetries().build(), socketFactoryRegistryHandler.isMtls());
    }

    static class SocketFactoryRegistryHandler {
        private final boolean isMtls;
        private final Registry<ConnectionSocketFactory> socketFactoryRegistry;

        public SocketFactoryRegistryHandler(MtlsProvider mtlsProvider) throws GeneralSecurityException, IOException {
            KeyStore keyStore;
            String keyStorePassword;
            if (mtlsProvider.useMtlsClientCertificate()) {
                KeyStore keyStore2 = mtlsProvider.getKeyStore();
                keyStorePassword = mtlsProvider.getKeyStorePassword();
                keyStore = keyStore2;
            } else {
                keyStore = null;
                keyStorePassword = null;
            }
            KeyStore certificateTrustStore = GoogleUtils.getCertificateTrustStore();
            SSLContext tlsSslContext = SslUtils.getTlsSslContext();
            if (keyStore != null && keyStorePassword != null) {
                this.isMtls = true;
                SslUtils.initSslContext(tlsSslContext, certificateTrustStore, SslUtils.getPkixTrustManagerFactory(), keyStore, keyStorePassword, SslUtils.getDefaultKeyManagerFactory());
            } else {
                this.isMtls = false;
                SslUtils.initSslContext(tlsSslContext, certificateTrustStore, SslUtils.getPkixTrustManagerFactory());
            }
            this.socketFactoryRegistry = RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register(ProxyConfig.MATCH_HTTPS, new SSLConnectionSocketFactory(tlsSslContext)).build();
        }

        public Registry<ConnectionSocketFactory> getSocketFactoryRegistry() {
            return this.socketFactoryRegistry;
        }

        public boolean isMtls() {
            return this.isMtls;
        }
    }

    private GoogleApacheHttpTransport() {
    }
}
