package com.google.api.client.googleapis.mtls;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

/* JADX INFO: loaded from: classes3.dex */
public interface MtlsProvider {
    KeyStore getKeyStore() throws GeneralSecurityException, IOException;

    String getKeyStorePassword();

    boolean useMtlsClientCertificate();
}
