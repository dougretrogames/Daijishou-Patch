package com.google.api.client.auth.oauth2;

import java.io.IOException;

/* INFO: loaded from: classes3.dex */
@Deprecated
public interface CredentialStore {
    void delete(String str, Credential credential) throws IOException;

    boolean load(String str, Credential credential) throws IOException;

    void store(String str, Credential credential) throws IOException;
}
