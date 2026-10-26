package com.google.auth;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* INFO: loaded from: classes3.dex */
public abstract class Credentials implements Serializable {
    public static final String GOOGLE_DEFAULT_UNIVERSE = "googleapis.com";
    private static final long serialVersionUID = 808575179767517313L;

    public abstract String getAuthenticationType();

    public abstract Map<String, List<String>> getRequestMetadata(URI uri) throws IOException;

    public abstract boolean hasRequestMetadata();

    public abstract boolean hasRequestMetadataOnly();

    public abstract void refresh() throws IOException;

    public String getUniverseDomain() throws IOException {
        return GOOGLE_DEFAULT_UNIVERSE;
    }

    public Map<String, List<String>> getRequestMetadata() throws IOException {
        return getRequestMetadata(null);
    }

    /* INFO: renamed from: com.google.auth.Credentials$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ RequestMetadataCallback val$callback;
        final /* synthetic */ URI val$uri;

        AnonymousClass1(URI uri, RequestMetadataCallback requestMetadataCallback) {
            this.val$uri = uri;
            this.val$callback = requestMetadataCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Credentials.this.blockingGetToCallback(this.val$uri, this.val$callback);
        }
    }

    public void getRequestMetadata(URI uri, Executor executor, RequestMetadataCallback requestMetadataCallback) {
        executor.execute(new AnonymousClass1(uri, requestMetadataCallback));
    }

    protected final void blockingGetToCallback(URI uri, RequestMetadataCallback requestMetadataCallback) {
        try {
            requestMetadataCallback.onSuccess(getRequestMetadata(uri));
        } catch (Throwable th) {
            requestMetadataCallback.onFailure(th);
        }
    }
}
