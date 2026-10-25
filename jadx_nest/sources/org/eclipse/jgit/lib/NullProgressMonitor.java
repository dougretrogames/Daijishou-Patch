package org.eclipse.jgit.lib;

/* JADX INFO: loaded from: classes5.dex */
public class NullProgressMonitor implements ProgressMonitor {
    public static final NullProgressMonitor INSTANCE = new NullProgressMonitor();

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public void beginTask(String str, int i) {
    }

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public void endTask() {
    }

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public boolean isCancelled() {
        return false;
    }

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public void showDuration(boolean z) {
    }

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public void start(int i) {
    }

    @Override // org.eclipse.jgit.lib.ProgressMonitor
    public void update(int i) {
    }

    private NullProgressMonitor() {
    }
}
