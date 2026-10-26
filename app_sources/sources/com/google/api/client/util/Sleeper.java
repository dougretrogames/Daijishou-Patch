package com.google.api.client.util;

/* INFO: loaded from: classes3.dex */
public interface Sleeper {
    public static final Sleeper DEFAULT = new AnonymousClass1();

    void sleep(long j) throws InterruptedException;

    /* INFO: renamed from: com.google.api.client.util.Sleeper$1, reason: invalid class name */
    static class AnonymousClass1 implements Sleeper {
        AnonymousClass1() {
        }

        @Override // com.google.api.client.util.Sleeper
        public void sleep(long j) throws InterruptedException {
            Thread.sleep(j);
        }
    }
}
