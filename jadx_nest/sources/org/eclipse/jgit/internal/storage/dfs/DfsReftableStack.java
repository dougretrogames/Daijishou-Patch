package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.internal.storage.reftable.ReftableReader;

/* JADX INFO: loaded from: classes5.dex */
public class DfsReftableStack implements AutoCloseable {
    private final List<DfsReftable> files;
    private final List<ReftableReader> tables;

    public static DfsReftableStack open(DfsReader dfsReader, List<DfsReftable> list) throws IOException {
        DfsReftableStack dfsReftableStack = new DfsReftableStack(list.size());
        try {
            for (DfsReftable dfsReftable : list) {
                dfsReftableStack.files.add(dfsReftable);
                dfsReftableStack.tables.add(dfsReftable.open(dfsReader));
            }
            return dfsReftableStack;
        } catch (Throwable th) {
            dfsReftableStack.close();
            throw th;
        }
    }

    private DfsReftableStack(int i) {
        this.files = new ArrayList(i);
        this.tables = new ArrayList(i);
    }

    public List<DfsReftable> files() {
        return Collections.unmodifiableList(this.files);
    }

    public List<ReftableReader> readers() {
        return Collections.unmodifiableList(this.tables);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Iterator<ReftableReader> it = this.tables.iterator();
        while (it.hasNext()) {
            try {
                it.next().close();
            } catch (IOException unused) {
            }
        }
    }
}
