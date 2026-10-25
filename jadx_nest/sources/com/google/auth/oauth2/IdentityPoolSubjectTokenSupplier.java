package com.google.auth.oauth2;

import java.io.IOException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
@FunctionalInterface
public interface IdentityPoolSubjectTokenSupplier extends Serializable {
    String getSubjectToken(ExternalAccountSupplierContext externalAccountSupplierContext) throws IOException;
}
