package com.google.auth.oauth2;

import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpResponse;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class ServiceAccountCredentials$$ExternalSyntheticLambda0 implements HttpBackOffUnsuccessfulResponseHandler.BackOffRequired {
    @Override // com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler.BackOffRequired
    public final boolean isRequired(HttpResponse httpResponse) {
        return OAuth2Utils.TOKEN_ENDPOINT_RETRYABLE_STATUS_CODES.contains(Integer.valueOf(httpResponse.getStatusCode()));
    }
}
