package org.apache.http.auth;

import java.security.Principal;

/* INFO: loaded from: classes5.dex */
public interface Credentials {
    String getPassword();

    Principal getUserPrincipal();
}
