package org.eclipse.jgit.internal.storage.reftable;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.ReflogEntry;

/* JADX INFO: loaded from: classes5.dex */
public class ReftableCompactor {
    private boolean includeDeletes;
    private long reflogExpireOldestReflogTimeMillis;
    private ReftableWriter.Stats stats;
    private final ReftableWriter writer;
    private final ArrayDeque<ReftableReader> tables = new ArrayDeque<>();
    private long reflogExpireMinUpdateIndex = 0;
    private long reflogExpireMaxUpdateIndex = Long.MAX_VALUE;

    public ReftableCompactor(OutputStream outputStream) {
        this.writer = new ReftableWriter(outputStream);
    }

    public ReftableCompactor setConfig(ReftableConfig reftableConfig) {
        this.writer.setConfig(reftableConfig);
        return this;
    }

    public ReftableCompactor setIncludeDeletes(boolean z) {
        this.includeDeletes = z;
        return this;
    }

    public ReftableCompactor setReflogExpireMinUpdateIndex(long j) {
        this.reflogExpireMinUpdateIndex = j;
        return this;
    }

    public ReftableCompactor setReflogExpireMaxUpdateIndex(long j) {
        this.reflogExpireMaxUpdateIndex = j;
        return this;
    }

    public ReftableCompactor setReflogExpireOldestReflogTimeMillis(long j) {
        this.reflogExpireOldestReflogTimeMillis = j;
        return this;
    }

    public void addAll(List<ReftableReader> list) throws IOException {
        Iterator<ReftableReader> it = list.iterator();
        while (it.hasNext()) {
            this.tables.add(it.next());
        }
    }

    public void compact() throws IOException {
        MergedReftable mergedReftable = new MergedReftable(new ArrayList(this.tables));
        mergedReftable.setIncludeDeletes(this.includeDeletes);
        this.writer.setMaxUpdateIndex(mergedReftable.maxUpdateIndex());
        this.writer.setMinUpdateIndex(mergedReftable.minUpdateIndex());
        this.writer.begin();
        mergeRefs(mergedReftable);
        mergeLogs(mergedReftable);
        this.writer.finish();
        this.stats = this.writer.getStats();
    }

    public ReftableWriter.Stats getStats() {
        return this.stats;
    }

    private void mergeRefs(MergedReftable mergedReftable) throws IOException {
        Throwable th = null;
        try {
            RefCursor refCursorAllRefs = mergedReftable.allRefs();
            while (refCursorAllRefs.next()) {
                try {
                    this.writer.writeRef(refCursorAllRefs.getRef(), refCursorAllRefs.getRef().getUpdateIndex());
                } catch (Throwable th2) {
                    if (refCursorAllRefs != null) {
                        refCursorAllRefs.close();
                    }
                    throw th2;
                }
            }
            if (refCursorAllRefs != null) {
                refCursorAllRefs.close();
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                th.addSuppressed(th3);
            }
            throw null;
        }
    }

    private void mergeLogs(MergedReftable mergedReftable) throws IOException {
        if (this.reflogExpireOldestReflogTimeMillis == Long.MAX_VALUE) {
            return;
        }
        Throwable th = null;
        try {
            LogCursor logCursorAllLogs = mergedReftable.allLogs();
            while (logCursorAllLogs.next()) {
                try {
                    long updateIndex = logCursorAllLogs.getUpdateIndex();
                    if (updateIndex <= this.reflogExpireMaxUpdateIndex && updateIndex >= this.reflogExpireMinUpdateIndex) {
                        String refName = logCursorAllLogs.getRefName();
                        ReflogEntry reflogEntry = logCursorAllLogs.getReflogEntry();
                        if (reflogEntry == null) {
                            if (this.includeDeletes) {
                                this.writer.deleteLog(refName, updateIndex);
                            }
                        } else {
                            PersonIdent who = reflogEntry.getWho();
                            if (who.getWhen().getTime() >= this.reflogExpireOldestReflogTimeMillis) {
                                this.writer.writeLog(refName, updateIndex, who, reflogEntry.getOldId(), reflogEntry.getNewId(), reflogEntry.getComment());
                            }
                        }
                    }
                } catch (Throwable th2) {
                    if (logCursorAllLogs == null) {
                        throw th2;
                    }
                    logCursorAllLogs.close();
                    throw th2;
                }
            }
            if (logCursorAllLogs != null) {
                logCursorAllLogs.close();
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                th.addSuppressed(th3);
            }
            throw null;
        }
    }
}
