package com.google.api.client.util;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface BackOff {
    public static final long STOP = -1;
    public static final BackOff ZERO_BACKOFF = new AnonymousClass1();
    public static final BackOff STOP_BACKOFF = new AnonymousClass2();

    long nextBackOffMillis() throws IOException;

    void reset() throws IOException;

    /* JADX INFO: renamed from: com.google.api.client.util.BackOff$1, reason: invalid class name */
    static class AnonymousClass1 implements BackOff {
        @Override // com.google.api.client.util.BackOff
        public long nextBackOffMillis() throws IOException {
            return 0L;
        }

        @Override // com.google.api.client.util.BackOff
        public void reset() throws IOException {
        }

        AnonymousClass1() {
        }
    }

    /* JADX INFO: renamed from: com.google.api.client.util.BackOff$2, reason: invalid class name */
    static class AnonymousClass2 implements BackOff {
        @Override // com.google.api.client.util.BackOff
        public long nextBackOffMillis() throws IOException {
            return -1L;
        }

        @Override // com.google.api.client.util.BackOff
        public void reset() throws IOException {
        }

        AnonymousClass2() {
        }
    }
}
