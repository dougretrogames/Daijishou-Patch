package androidx.webkit;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes3.dex */
public interface OutcomeReceiverCompat<T, E extends Throwable> {
    default void onError(E e) {
    }

    void onResult(T t);
}
