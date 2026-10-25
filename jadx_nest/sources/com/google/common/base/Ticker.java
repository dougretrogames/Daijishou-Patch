package com.google.common.base;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class Ticker {
    private static final Ticker SYSTEM_TICKER = new AnonymousClass1();

    public abstract long read();

    protected Ticker() {
    }

    public static Ticker systemTicker() {
        return SYSTEM_TICKER;
    }

    /* JADX INFO: renamed from: com.google.common.base.Ticker$1, reason: invalid class name */
    class AnonymousClass1 extends Ticker {
        AnonymousClass1() {
        }

        @Override // com.google.common.base.Ticker
        public long read() {
            return System.nanoTime();
        }
    }
}
