package org.eclipse.jgit.util.time;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* INFO: loaded from: classes5.dex */
public abstract class ProposedTimestamp implements AutoCloseable {
    public abstract void blockUntil(Duration duration) throws InterruptedException, TimeoutException;

    @Override // java.lang.AutoCloseable
    public void close() {
    }

    public abstract long read(TimeUnit timeUnit);

    public static void blockUntil(Iterable<ProposedTimestamp> iterable, Duration duration) throws InterruptedException, TimeoutException {
        Iterator<ProposedTimestamp> it = iterable.iterator();
        if (!it.hasNext()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long millis = duration.toMillis() + jCurrentTimeMillis;
        while (true) {
            long j = millis - jCurrentTimeMillis;
            if (j < 0) {
                throw new TimeoutException();
            }
            it.next().blockUntil(Duration.ofMillis(j));
            if (!it.hasNext()) {
                return;
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
        }
    }

    public long millis() {
        return read(TimeUnit.MILLISECONDS);
    }

    public long micros() {
        return read(TimeUnit.MICROSECONDS);
    }

    public Instant instant() {
        long jMicros = micros();
        return Instant.ofEpochSecond(jMicros / 1000000, (jMicros % 1000000) * 1000);
    }

    public Timestamp timestamp() {
        return Timestamp.from(instant());
    }

    public Date date() {
        return new Date(millis());
    }

    public String toString() {
        return instant().toString();
    }
}
