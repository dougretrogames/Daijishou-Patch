package org.eclipse.jgit.internal.storage.reftable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.lib.ReflogReader;

/* INFO: loaded from: classes5.dex */
public class ReftableReflogReader implements ReflogReader {
    private final Lock lock;
    private final String refname;
    private final Reftable reftable;

    ReftableReflogReader(Lock lock, Reftable reftable, String str) {
        this.lock = lock;
        this.reftable = reftable;
        this.refname = str;
    }

    @Override // org.eclipse.jgit.lib.ReflogReader
    public ReflogEntry getLastEntry() throws IOException {
        this.lock.lock();
        try {
            LogCursor logCursorSeekLog = this.reftable.seekLog(this.refname);
            return logCursorSeekLog.next() ? logCursorSeekLog.getReflogEntry() : null;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.eclipse.jgit.lib.ReflogReader
    public List<ReflogEntry> getReverseEntries() throws IOException {
        return getReverseEntries(Integer.MAX_VALUE);
    }

    @Override // org.eclipse.jgit.lib.ReflogReader
    public ReflogEntry getReverseEntry(int i) throws IOException {
        this.lock.lock();
        try {
            LogCursor logCursorSeekLog = this.reftable.seekLog(this.refname);
            while (logCursorSeekLog.next() && i >= 0) {
                if (i == 0) {
                    ReflogEntry reflogEntry = logCursorSeekLog.getReflogEntry();
                    this.lock.unlock();
                    return reflogEntry;
                }
                i--;
            }
            this.lock.unlock();
            return null;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    @Override // org.eclipse.jgit.lib.ReflogReader
    public List<ReflogEntry> getReverseEntries(int i) throws IOException {
        this.lock.lock();
        try {
            LogCursor logCursorSeekLog = this.reftable.seekLog(this.refname);
            ArrayList arrayList = new ArrayList();
            while (logCursorSeekLog.next() && arrayList.size() < i) {
                arrayList.add(logCursorSeekLog.getReflogEntry());
            }
            this.lock.unlock();
            return arrayList;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }
}
