package com.google.api.services.kgsearch.v1;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class KgsearchRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
    protected void initializeKgsearchRequest(KgsearchRequest<?> kgsearchRequest) throws IOException {
    }

    public KgsearchRequestInitializer() {
    }

    public KgsearchRequestInitializer(String str) {
        super(str);
    }

    public KgsearchRequestInitializer(String str, String str2) {
        super(str, str2);
    }

    @Override // com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer
    public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) throws IOException {
        super.initializeJsonRequest(abstractGoogleJsonClientRequest);
        initializeKgsearchRequest((KgsearchRequest) abstractGoogleJsonClientRequest);
    }
}
