package org.eclipse.jgit.util.time;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* INFO: loaded from: classes5.dex */
public class MonotonicSystemClock implements MonotonicClock {
    private static final AtomicLong before = new AtomicLong();

    private static long nowMicros() {
        AtomicLong atomicLong;
        long j;
        long jMax;
        long micros = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        do {
            atomicLong = before;
            j = atomicLong.get();
            jMax = Math.max(1 + j, micros);
        } while (!atomicLong.compareAndSet(j, jMax));
        return jMax;
    }

    /* INFO: renamed from: org.eclipse.jgit.util.time.MonotonicSystemClock$1, reason: invalid class name */
    class AnonymousClass1 extends ProposedTimestamp {
        private final /* synthetic */ long val$u;

        @Override // org.eclipse.jgit.util.time.ProposedTimestamp
        public void blockUntil(Duration duration) {
        }

        AnonymousClass1(long j) {
            this.val$u = j;
        }

        @Override // org.eclipse.jgit.util.time.ProposedTimestamp
        public long read(TimeUnit timeUnit) {
            return timeUnit.convert(this.val$u, TimeUnit.MICROSECONDS);
        }
    }

    @Override // org.eclipse.jgit.util.time.MonotonicClock
    public ProposedTimestamp propose() {
        return new AnonymousClass1(nowMicros());
    }
}
