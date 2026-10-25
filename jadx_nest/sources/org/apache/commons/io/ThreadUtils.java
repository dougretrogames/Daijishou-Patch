package org.apache.commons.io;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes5.dex */
public final class ThreadUtils {
    private static int getNanosOfMilli(Duration duration) {
        return duration.getNano() % DurationKt.NANOS_IN_MILLIS;
    }

    public static void sleep(Duration duration) throws InterruptedException {
        try {
            long jNanoTime = System.nanoTime() + duration.toNanos();
            Duration duration2 = duration;
            while (true) {
                Thread.sleep(duration2.toMillis(), getNanosOfMilli(duration2));
                long jNanoTime2 = System.nanoTime();
                Duration durationOfNanos = Duration.ofNanos(jNanoTime - jNanoTime2);
                if (jNanoTime2 - jNanoTime >= 0) {
                    return;
                } else {
                    duration2 = durationOfNanos;
                }
            }
        } catch (ArithmeticException unused) {
            Instant instantPlus = Instant.now().plus((TemporalAmount) duration);
            do {
                Thread.sleep(duration.toMillis(), getNanosOfMilli(duration));
                duration = Duration.between(Instant.now(), instantPlus);
            } while (!duration.isNegative());
        }
    }

    @Deprecated
    public ThreadUtils() {
    }
}
