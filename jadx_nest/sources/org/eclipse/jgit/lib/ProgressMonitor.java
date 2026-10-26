package org.eclipse.jgit.lib;

/* INFO: loaded from: classes5.dex */
public interface ProgressMonitor {
    public static final int UNKNOWN = 0;

    void beginTask(String str, int i);

    void endTask();

    boolean isCancelled();

    void showDuration(boolean z);

    void start(int i);

    void update(int i);
}
