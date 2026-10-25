package org.eclipse.jgit.logging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class PerformanceLogContext {
    private static final PerformanceLogContext INSTANCE = new PerformanceLogContext();
    private static final ThreadLocal<List<PerformanceLogRecord>> eventRecords = ThreadLocal.withInitial(new PerformanceLogContext$$ExternalSyntheticLambda0());

    public static /* synthetic */ ArrayList $r8$lambda$aw4WkQINtNlXlsGxYEbzatsgkDc() {
        return new ArrayList();
    }

    private PerformanceLogContext() {
    }

    public static PerformanceLogContext getInstance() {
        return INSTANCE;
    }

    public List<PerformanceLogRecord> getEventRecords() {
        return Collections.unmodifiableList(eventRecords.get());
    }

    public void addEvent(PerformanceLogRecord performanceLogRecord) {
        eventRecords.get().add(performanceLogRecord);
    }

    public void cleanEvents() {
        eventRecords.remove();
    }
}
