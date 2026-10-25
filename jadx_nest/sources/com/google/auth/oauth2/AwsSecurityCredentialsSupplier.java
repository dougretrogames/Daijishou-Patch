package com.google.auth.oauth2;

import java.io.IOException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public interface AwsSecurityCredentialsSupplier extends Serializable {
    AwsSecurityCredentials getCredentials(ExternalAccountSupplierContext externalAccountSupplierContext) throws IOException;

    String getRegion(ExternalAccountSupplierContext externalAccountSupplierContext) throws IOException;
}
