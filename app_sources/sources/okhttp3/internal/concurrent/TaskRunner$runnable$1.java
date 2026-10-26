package okhttp3.internal.concurrent;

import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: TaskRunner.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/concurrent/TaskRunner$runnable$1", "Ljava/lang/Runnable;", "run", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TaskRunner$runnable$1 implements Runnable {
    final /* synthetic */ TaskRunner this$0;

    TaskRunner$runnable$1(TaskRunner taskRunner) {
        this.this$0 = taskRunner;
    }

    @Override // java.lang.Runnable
    public void run() {
        Task taskAwaitTaskToRun;
        long jNanoTime;
        while (true) {
            TaskRunner taskRunner = this.this$0;
            synchronized (taskRunner) {
                taskAwaitTaskToRun = taskRunner.awaitTaskToRun();
            }
            if (taskAwaitTaskToRun == null) {
                return;
            }
            TaskQueue queue = taskAwaitTaskToRun.getQueue();
            Intrinsics.checkNotNull(queue);
            TaskRunner taskRunner2 = this.this$0;
            boolean zIsLoggable = TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE);
            if (zIsLoggable) {
                jNanoTime = queue.getTaskRunner().getBackend().nanoTime();
                TaskLoggerKt.log(taskAwaitTaskToRun, queue, "starting");
            } else {
                jNanoTime = -1;
            }
            try {
                taskRunner2.runTask(taskAwaitTaskToRun);
                try {
                    Unit unit = Unit.INSTANCE;
                    if (zIsLoggable) {
                        TaskLoggerKt.log(taskAwaitTaskToRun, queue, "finished run in " + TaskLoggerKt.formatDuration(queue.getTaskRunner().getBackend().nanoTime() - jNanoTime));
                    }
                } catch (Throwable th) {
                    if (zIsLoggable) {
                        TaskLoggerKt.log(taskAwaitTaskToRun, queue, "failed a run in " + TaskLoggerKt.formatDuration(queue.getTaskRunner().getBackend().nanoTime() - jNanoTime));
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                taskRunner2.getBackend().execute(this);
                throw th2;
            }
        }
    }
}
