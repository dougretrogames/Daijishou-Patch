package org.eclipse.jgit.util.io;

import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public final class InterruptTimer {
    final AutoKiller autoKiller;
    private final AlarmState state;
    private final AlarmThread thread;

    public InterruptTimer() {
        this("JGit-InterruptTimer");
    }

    public InterruptTimer(String str) {
        AlarmState alarmState = new AlarmState();
        this.state = alarmState;
        this.autoKiller = new AutoKiller(alarmState);
        AlarmThread alarmThread = new AlarmThread(str, alarmState);
        this.thread = alarmThread;
        alarmThread.start();
    }

    public void begin(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidTimeout, Integer.valueOf(i)));
        }
        Thread.interrupted();
        this.state.begin(i);
    }

    public void end() {
        this.state.end();
    }

    public void terminate() {
        this.state.terminate();
        boolean z = false;
        while (true) {
            try {
                this.thread.join();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    static final class AlarmThread extends Thread {
        AlarmThread(String str, AlarmState alarmState) {
            super(alarmState);
            setName(str);
            setDaemon(true);
        }
    }

    private static final class AutoKiller {
        private final AlarmState state;

        AutoKiller(AlarmState alarmState) {
            this.state = alarmState;
        }

        protected void finalize() throws Throwable {
            this.state.terminate();
        }
    }

    static final class AlarmState implements Runnable {
        private Thread callingThread = Thread.currentThread();
        private long deadline;
        private boolean terminated;

        AlarmState() {
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            while (!this.terminated && this.callingThread.isAlive()) {
                try {
                    long j = this.deadline;
                    if (0 < j) {
                        long jNow = j - now();
                        if (jNow <= 0) {
                            this.deadline = 0L;
                            this.callingThread.interrupt();
                        } else {
                            wait(jNow);
                        }
                    } else {
                        wait(1000L);
                    }
                } catch (InterruptedException unused) {
                }
            }
        }

        synchronized void begin(int i) {
            if (this.terminated) {
                throw new IllegalStateException(JGitText.get().timerAlreadyTerminated);
            }
            this.callingThread = Thread.currentThread();
            this.deadline = now() + ((long) i);
            notifyAll();
        }

        synchronized void end() {
            if (0 == this.deadline) {
                Thread.interrupted();
            } else {
                this.deadline = 0L;
            }
            notifyAll();
        }

        synchronized void terminate() {
            if (!this.terminated) {
                this.deadline = 0L;
                this.terminated = true;
                notifyAll();
            }
        }

        private static long now() {
            return System.currentTimeMillis();
        }
    }
}
