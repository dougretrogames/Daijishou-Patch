package com.google.common.escape;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class Platform {
    private static final ThreadLocal<char[]> DEST_TL = new AnonymousClass1();

    private Platform() {
    }

    static char[] charBufferFromThreadLocal() {
        return (char[]) Objects.requireNonNull(DEST_TL.get());
    }

    /* JADX INFO: renamed from: com.google.common.escape.Platform$1, reason: invalid class name */
    class AnonymousClass1 extends ThreadLocal<char[]> {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public char[] initialValue() {
            return new char[1024];
        }
    }
}
