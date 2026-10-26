package org.eclipse.jgit.transport.http;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class JDKHttpConnectionFactory$JdkConnectionSession$$ExternalSyntheticLambda0 implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        return JDKHttpConnectionFactory.JdkConnectionSession.lambda$0(str, sSLSession);
    }
}
