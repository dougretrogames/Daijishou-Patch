package org.eclipse.jgit.logging;

/* INFO: loaded from: classes5.dex */
public class PerformanceLogRecord {
    private long durationMs;
    private String name;

    public PerformanceLogRecord(String str, long j) {
        this.name = str;
        this.durationMs = j;
    }

    public String getName() {
        return this.name;
    }

    public long getDurationMs() {
        return this.durationMs;
    }
}
