package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.lib.ReflogReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.RawParseUtils;

/* INFO: loaded from: classes5.dex */
class ReflogReaderImpl implements ReflogReader {
    private File logName;

    ReflogReaderImpl(Repository repository, String str) {
        this.logName = new File(str.equals("HEAD") ? repository.getDirectory() : repository.getCommonDirectory(), Constants.L_LOGS + str);
    }

    @Override // org.eclipse.jgit.lib.ReflogReader
    public ReflogEntry getLastEntry() throws IOException {
        return getReverseEntry(0);
    }

    @Override // org.eclipse.jgit.lib.ReflogReader
    public List<ReflogEntry> getReverseEntries() throws IOException {
        return getReverseEntries(Integer.MAX_VALUE);
    }

    @Override // org.eclipse.jgit.lib.ReflogReader
    public ReflogEntry getReverseEntry(int i) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        try {
            byte[] fully = IO.readFully(this.logName);
            int iPrevLF = RawParseUtils.prevLF(fully, fully.length);
            int i2 = 0;
            while (iPrevLF >= 0) {
                iPrevLF = RawParseUtils.prevLF(fully, iPrevLF);
                if (i == i2) {
                    return new ReflogEntryImpl(fully, iPrevLF >= 0 ? iPrevLF + 2 : 0);
                }
                i2++;
            }
            return null;
        } catch (FileNotFoundException e) {
            if (this.logName.exists()) {
                throw e;
            }
            return null;
        }
    }

    @Override // org.eclipse.jgit.lib.ReflogReader
    public List<ReflogEntry> getReverseEntries(int i) throws IOException {
        try {
            byte[] fully = IO.readFully(this.logName);
            int iPrevLF = RawParseUtils.prevLF(fully, fully.length);
            ArrayList arrayList = new ArrayList();
            while (iPrevLF >= 0) {
                int i2 = i - 1;
                if (i <= 0) {
                    break;
                }
                iPrevLF = RawParseUtils.prevLF(fully, iPrevLF);
                arrayList.add(new ReflogEntryImpl(fully, iPrevLF < 0 ? 0 : iPrevLF + 2));
                i = i2;
            }
            return arrayList;
        } catch (FileNotFoundException e) {
            if (this.logName.exists()) {
                throw e;
            }
            return Collections.emptyList();
        }
    }
}
