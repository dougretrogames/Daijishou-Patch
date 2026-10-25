package com.google.api.client.googleapis.javanet;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.mtls.MtlsProvider;
import com.google.api.client.googleapis.mtls.MtlsUtils;
import com.google.api.client.http.javanet.NetHttpTransport;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

/* JADX INFO: loaded from: classes3.dex */
public class GoogleNetHttpTransport {
    public static NetHttpTransport newTrustedTransport() throws GeneralSecurityException, IOException {
        return newTrustedTransport(MtlsUtils.getDefaultMtlsProvider());
    }

    public static NetHttpTransport newTrustedTransport(MtlsProvider mtlsProvider) throws GeneralSecurityException, IOException {
        KeyStore keyStore;
        String keyStorePassword;
        if (mtlsProvider.useMtlsClientCertificate()) {
            keyStore = mtlsProvider.getKeyStore();
            keyStorePassword = mtlsProvider.getKeyStorePassword();
        } else {
            keyStore = null;
            keyStorePassword = null;
        }
        if (keyStore != null && keyStorePassword != null) {
            return new NetHttpTransport.Builder().trustCertificates(GoogleUtils.getCertificateTrustStore(), keyStore, keyStorePassword).build();
        }
        return new NetHttpTransport.Builder().trustCertificates(GoogleUtils.getCertificateTrustStore()).build();
    }

    private GoogleNetHttpTransport() {
    }
}
