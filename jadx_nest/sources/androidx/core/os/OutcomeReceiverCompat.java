package androidx.core.os;

import java.lang.Throwable;

/* INFO: loaded from: classes.dex */
public interface OutcomeReceiverCompat<R, E extends Throwable> {
    default void onError(E e) {
    }

    void onResult(R r);
}
