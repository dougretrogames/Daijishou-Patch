package io.grpc;

import java.time.Duration;

/* INFO: loaded from: classes4.dex */
final class TimeUtils {
    private TimeUtils() {
    }

    static long convertToNanos(Duration duration) {
        try {
            return duration.toNanos();
        } catch (ArithmeticException unused) {
            return duration.isNegative() ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
    }
}
