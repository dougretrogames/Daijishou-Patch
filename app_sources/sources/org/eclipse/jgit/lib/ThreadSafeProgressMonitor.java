package org.eclipse.jgit.lib;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* INFO: loaded from: classes5.dex */
public class ThreadSafeProgressMonitor implements ProgressMonitor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ProgressMonitor pm;
    private final ReentrantLock lock = new ReentrantLock();
    private final Thread mainThread = Thread.currentThread();
    private final AtomicInteger workers = new AtomicInteger(0);
    private final AtomicInteger pendingUpdates = new AtomicInteger(0);
    private final Semaphore process = new Semaphore(0);

    public ThreadSafeProgressMonitor(ProgressMonitor progressMonitor) {
        this.pm = progressMonitor;
    }

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public void start(int i) {
        if (!isMainThread()) {
            throw new IllegalStateException();
        }
        this.pm.start(i);
    }

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public void beginTask(String str, int i) {
        if (!isMainThread()) {
            throw new IllegalStateException();
        }
        this.pm.beginTask(str, i);
    }

    public void startWorker() {
        startWorkers(1);
    }

    public void startWorkers(int i) {
        this.workers.addAndGet(i);
    }

    public void endWorker() {
        if (this.workers.decrementAndGet() == 0) {
            this.process.release();
        }
    }

    public void pollForUpdates() {
        doUpdates();
    }

    public void waitForCompletion() throws InterruptedException {
        while (this.workers.get() > 0) {
            doUpdates();
            this.process.acquire();
        }
        doUpdates();
    }

    private void doUpdates() {
        int andSet = this.pendingUpdates.getAndSet(0);
        if (andSet > 0) {
            this.pm.update(andSet);
        }
    }

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public void update(int i) {
        if (this.pendingUpdates.getAndAdd(i) == 0) {
            this.process.release();
        }
    }

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public boolean isCancelled() {
        this.lock.lock();
        try {
            return this.pm.isCancelled();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public void endTask() {
        if (!isMainThread()) {
            throw new IllegalStateException();
        }
        this.pm.endTask();
    }

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public void showDuration(boolean z) {
        this.pm.showDuration(z);
    }

    private boolean isMainThread() {
        return Thread.currentThread() == this.mainThread;
    }
}
