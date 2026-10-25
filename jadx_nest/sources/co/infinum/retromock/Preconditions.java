package co.infinum.retromock;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class Preconditions {
    private Preconditions() {
    }

    static void checkNotNull(@Nullable Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    static void checkNotEmpty(@Nonnull Object[] objArr, String str) {
        if (objArr.length == 0) {
            throw new IllegalArgumentException(str);
        }
    }

    static void checkNotNullOrEmpty(@Nullable Object[] objArr, String str) {
        checkNotNull(objArr, str);
        checkNotEmpty(objArr, str);
    }
}
