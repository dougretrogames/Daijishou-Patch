package org.eclipse.jgit.lib;

import java.io.IOException;
import java.util.List;

/* INFO: loaded from: classes5.dex */
public interface ReflogReader {
    ReflogEntry getLastEntry() throws IOException;

    List<ReflogEntry> getReverseEntries() throws IOException;

    List<ReflogEntry> getReverseEntries(int i) throws IOException;

    ReflogEntry getReverseEntry(int i) throws IOException;
}
