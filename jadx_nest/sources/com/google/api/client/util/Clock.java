package com.google.api.client.util;

/* JADX INFO: loaded from: classes3.dex */
public interface Clock {
    public static final Clock SYSTEM = new AnonymousClass1();

    long currentTimeMillis();

    /* JADX INFO: renamed from: com.google.api.client.util.Clock$1, reason: invalid class name */
    static class AnonymousClass1 implements Clock {
        AnonymousClass1() {
        }

        @Override // com.google.api.client.util.Clock
        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }
}
