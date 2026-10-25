package io.grpc;

import java.time.Duration;

/* JADX INFO: loaded from: classes4.dex */
public final class InternalTimeUtils {
    public static long convert(Duration duration) {
        return TimeUtils.convertToNanos(duration);
    }
}
