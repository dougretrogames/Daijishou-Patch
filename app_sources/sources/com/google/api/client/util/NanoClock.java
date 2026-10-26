package com.google.api.client.util;

/* INFO: loaded from: classes3.dex */
public interface NanoClock {
    public static final NanoClock SYSTEM = new AnonymousClass1();

    long nanoTime();

    /* INFO: renamed from: com.google.api.client.util.NanoClock$1, reason: invalid class name */
    static class AnonymousClass1 implements NanoClock {
        AnonymousClass1() {
        }

        @Override // com.google.api.client.util.NanoClock
        public long nanoTime() {
            return System.nanoTime();
        }
    }
}
