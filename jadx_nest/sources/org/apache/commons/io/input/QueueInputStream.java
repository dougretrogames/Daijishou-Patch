package org.apache.commons.io.input;

import java.io.InputStream;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.output.QueueOutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class QueueInputStream extends InputStream {
    private final BlockingQueue<Integer> blockingQueue;
    private final long timeoutNanos;

    /* synthetic */ QueueInputStream(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static class Builder extends AbstractStreamBuilder<QueueInputStream, Builder> {
        private BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue();
        private Duration timeout = Duration.ZERO;

        @Override // org.apache.commons.io.function.IOSupplier
        public QueueInputStream get() {
            return new QueueInputStream(this, null);
        }

        public Builder setBlockingQueue(BlockingQueue<Integer> blockingQueue) {
            if (blockingQueue == null) {
                blockingQueue = new LinkedBlockingQueue<>();
            }
            this.blockingQueue = blockingQueue;
            return this;
        }

        public Builder setTimeout(Duration duration) {
            if (duration != null && duration.toNanos() < 0) {
                throw new IllegalArgumentException("timeout must not be negative");
            }
            if (duration == null) {
                duration = Duration.ZERO;
            }
            this.timeout = duration;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public QueueInputStream() {
        this(new LinkedBlockingQueue());
    }

    @Deprecated
    public QueueInputStream(BlockingQueue<Integer> blockingQueue) {
        this(builder().setBlockingQueue(blockingQueue));
    }

    private QueueInputStream(Builder builder) {
        this.blockingQueue = (BlockingQueue) Objects.requireNonNull(builder.blockingQueue, "blockingQueue");
        this.timeoutNanos = ((Duration) Objects.requireNonNull(builder.timeout, "timeout")).toNanos();
    }

    BlockingQueue<Integer> getBlockingQueue() {
        return this.blockingQueue;
    }

    Duration getTimeout() {
        return Duration.ofNanos(this.timeoutNanos);
    }

    public QueueOutputStream newQueueOutputStream() {
        return new QueueOutputStream(this.blockingQueue);
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            Integer numPoll = this.blockingQueue.poll(this.timeoutNanos, TimeUnit.NANOSECONDS);
            if (numPoll == null) {
                return -1;
            }
            return numPoll.intValue() & 255;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(e);
        }
    }
}
