package com.google.api.client.googleapis.services.json;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer;
import java.io.IOException;

/* INFO: loaded from: classes3.dex */
public class CommonGoogleJsonClientRequestInitializer extends CommonGoogleClientRequestInitializer {

    public static class Builder extends CommonGoogleClientRequestInitializer.Builder {
        /* INFO: Access modifiers changed from: protected */
        @Override // com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer.Builder
        public Builder self() {
            return this;
        }
    }

    protected void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) throws IOException {
    }

    @Deprecated
    public CommonGoogleJsonClientRequestInitializer() {
    }

    @Deprecated
    public CommonGoogleJsonClientRequestInitializer(String str) {
        super(str);
    }

    @Deprecated
    public CommonGoogleJsonClientRequestInitializer(String str, String str2) {
        super(str, str2);
    }

    @Override // com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer, com.google.api.client.googleapis.services.GoogleClientRequestInitializer
    public final void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        super.initialize(abstractGoogleClientRequest);
        initializeJsonRequest((AbstractGoogleJsonClientRequest) abstractGoogleClientRequest);
    }
}
