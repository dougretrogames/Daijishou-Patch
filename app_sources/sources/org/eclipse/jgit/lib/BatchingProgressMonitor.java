package org.eclipse.jgit.lib;

import com.google.android.material.timepicker.TimeModel;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.jgit.lib.internal.WorkQueue;
import org.eclipse.jgit.util.SystemReader;

/* INFO: loaded from: classes5.dex */
public abstract class BatchingProgressMonitor implements ProgressMonitor {
    private static boolean performanceTrace = SystemReader.getInstance().isPerformanceTraceEnabled();
    private long delayStartTime;
    private TimeUnit delayStartUnit = TimeUnit.MILLISECONDS;
    private Boolean showDuration;
    private Task task;

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public boolean isCancelled() {
        return false;
    }

    protected abstract void onEndTask(String str, int i, int i2, int i3, Duration duration);

    protected abstract void onEndTask(String str, int i, Duration duration);

    protected abstract void onUpdate(String str, int i, int i2, int i3, Duration duration);

    protected abstract void onUpdate(String str, int i, Duration duration);

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public void start(int i) {
    }

    public void setDelayStart(long j, TimeUnit timeUnit) {
        this.delayStartTime = j;
        this.delayStartUnit = timeUnit;
    }

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public void beginTask(String str, int i) {
        endTask();
        Task task = new Task(str, i);
        this.task = task;
        long j = this.delayStartTime;
        if (j != 0) {
            task.delay(j, this.delayStartUnit);
        }
    }

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public void update(int i) {
        Task task = this.task;
        if (task != null) {
            task.update(this, i);
        }
    }

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public void endTask() {
        Task task = this.task;
        if (task != null) {
            task.end(this);
            this.task = null;
        }
    }

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public void showDuration(boolean z) {
        this.showDuration = Boolean.valueOf(z);
    }

    private boolean showDuration() {
        Boolean bool = this.showDuration;
        return bool != null ? bool.booleanValue() : performanceTrace;
    }

    protected void appendDuration(StringBuilder sb, Duration duration) {
        if (showDuration()) {
            long hours = duration.toHours();
            int minutesPart = duration.toMinutesPart();
            int secondsPart = duration.toSecondsPart();
            sb.append(" [");
            if (hours > 0) {
                sb.append(hours).append(AbstractJsonLexerKt.COLON);
                sb.append(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(minutesPart))).append(AbstractJsonLexerKt.COLON);
                sb.append(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(secondsPart)));
            } else if (minutesPart > 0) {
                sb.append(minutesPart).append(AbstractJsonLexerKt.COLON);
                sb.append(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(secondsPart)));
            } else {
                sb.append(secondsPart);
            }
            sb.append(FilenameUtils.EXTENSION_SEPARATOR).append(String.format("%03d", Integer.valueOf(duration.toMillisPart())));
            if (hours > 0) {
                sb.append('h');
            } else if (minutesPart > 0) {
                sb.append('m');
            } else {
                sb.append('s');
            }
            sb.append(AbstractJsonLexerKt.END_LIST);
        }
    }

    private static class Task implements Runnable {
        private int lastPercent;
        private int lastWork;
        private boolean output;
        private final String taskName;
        private Future<?> timerFuture;
        private final int totalWork;
        private volatile boolean display = true;
        private final Instant startTime = Instant.now();

        Task(String str, int i) {
            this.taskName = str;
            this.totalWork = i;
        }

        void delay(long j, TimeUnit timeUnit) {
            this.display = false;
            this.timerFuture = WorkQueue.getExecutor().schedule(this, j, timeUnit);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.display = true;
        }

        void update(BatchingProgressMonitor batchingProgressMonitor, int i) {
            int i2 = this.lastWork + i;
            this.lastWork = i2;
            int i3 = this.totalWork;
            if (i3 == 0) {
                if (this.display) {
                    batchingProgressMonitor.onUpdate(this.taskName, this.lastWork, elapsedTime());
                    this.output = true;
                    restartTimer();
                    return;
                }
                return;
            }
            int iRound = Math.round((i2 * 100.0f) / i3);
            if (this.display) {
                batchingProgressMonitor.onUpdate(this.taskName, this.lastWork, this.totalWork, iRound, elapsedTime());
                this.output = true;
                restartTimer();
                this.lastPercent = iRound;
                return;
            }
            if (iRound != this.lastPercent) {
                batchingProgressMonitor.onUpdate(this.taskName, this.lastWork, this.totalWork, iRound, elapsedTime());
                this.output = true;
                this.lastPercent = iRound;
            }
        }

        private void restartTimer() {
            this.display = false;
            this.timerFuture = WorkQueue.getExecutor().schedule(this, 1L, TimeUnit.SECONDS);
        }

        void end(BatchingProgressMonitor batchingProgressMonitor) {
            if (this.output) {
                int i = this.totalWork;
                if (i == 0) {
                    batchingProgressMonitor.onEndTask(this.taskName, this.lastWork, elapsedTime());
                } else {
                    batchingProgressMonitor.onEndTask(this.taskName, this.lastWork, this.totalWork, Math.round((this.lastWork * 100.0f) / i), elapsedTime());
                }
            }
            Future<?> future = this.timerFuture;
            if (future != null) {
                future.cancel(false);
            }
        }

        private Duration elapsedTime() {
            return Duration.between(this.startTime, Instant.now());
        }
    }
}
