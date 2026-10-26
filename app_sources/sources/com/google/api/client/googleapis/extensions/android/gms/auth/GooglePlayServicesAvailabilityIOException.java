package com.google.api.client.googleapis.extensions.android.gms.auth;

import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;

/* INFO: loaded from: classes3.dex */
public class GooglePlayServicesAvailabilityIOException extends UserRecoverableAuthIOException {
    private static final long serialVersionUID = 1;

    public GooglePlayServicesAvailabilityIOException(GooglePlayServicesAvailabilityException googlePlayServicesAvailabilityException) {
        super(googlePlayServicesAvailabilityException);
    }

    @Override // com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException, com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAuthIOException, java.lang.Throwable
    public GooglePlayServicesAvailabilityException getCause() {
        return (GooglePlayServicesAvailabilityException) super.getCause();
    }

    public final int getConnectionStatusCode() {
        return getCause().getConnectionStatusCode();
    }
}
