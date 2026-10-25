package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes4.dex */
@ElementTypesAreNonnullByDefault
public final class Runnables {
    private static final Runnable EMPTY_RUNNABLE = new AnonymousClass1();

    /* JADX INFO: renamed from: com.google.common.util.concurrent.Runnables$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        AnonymousClass1() {
        }
    }

    public static Runnable doNothing() {
        return EMPTY_RUNNABLE;
    }

    private Runnables() {
    }
}
