package net.jodah.expiringmap.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class Assert {
    private Assert() {
    }

    public static <T> T notNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str + " cannot be null");
    }

    public static void operation(boolean z, String str) {
        if (!z) {
            throw new UnsupportedOperationException(str);
        }
    }

    public static void state(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static void element(Object obj, Object obj2) {
        if (obj == null) {
            throw new NoSuchElementException(obj2.toString());
        }
    }
}
