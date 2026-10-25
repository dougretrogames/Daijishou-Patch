package com.github.kittinunf.fuel.core;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: FuelManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljavax/net/ssl/SSLSocketFactory;", "invoke"}, k = 3, mv = {1, 4, 0})
final class FuelManager$socketFactory$2 extends Lambda implements Function0<SSLSocketFactory> {
    final /* synthetic */ FuelManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FuelManager$socketFactory$2(FuelManager fuelManager) {
        super(0);
        this.this$0 = fuelManager;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0032  */
    @Override // kotlin.jvm.functions.Function0
    public final SSLSocketFactory invoke() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        SSLSocketFactory defaultSSLSocketFactory;
        KeyStore keystore = this.this$0.getKeystore();
        if (keystore != null) {
            TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustFactory.init(keystore);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            Intrinsics.checkNotNullExpressionValue(trustFactory, "trustFactory");
            sslContext.init(null, trustFactory.getTrustManagers(), null);
            Intrinsics.checkNotNullExpressionValue(sslContext, "sslContext");
            defaultSSLSocketFactory = sslContext.getSocketFactory();
            if (defaultSSLSocketFactory == null) {
                defaultSSLSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
            }
        } else {
            defaultSSLSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
        }
        Intrinsics.checkNotNullExpressionValue(defaultSSLSocketFactory, "keystore?.let {\n        …DefaultSSLSocketFactory()");
        return defaultSSLSocketFactory;
    }
}
