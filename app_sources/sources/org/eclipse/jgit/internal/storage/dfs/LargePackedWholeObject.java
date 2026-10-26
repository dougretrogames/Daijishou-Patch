package org.eclipse.jgit.internal.storage.dfs;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.zip.InflaterInputStream;
import org.eclipse.jgit.errors.LargeObjectException;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectStream;

/* INFO: loaded from: classes5.dex */
final class LargePackedWholeObject extends ObjectLoader {
    private final DfsObjDatabase db;
    private final int headerLength;
    private final long objectOffset;
    private final DfsPackFile pack;
    private final long size;
    private final int type;

    @Override // org.eclipse.jgit.lib.ObjectLoader
    public boolean isLarge() {
        return true;
    }

    LargePackedWholeObject(int i, long j, long j2, int i2, DfsPackFile dfsPackFile, DfsObjDatabase dfsObjDatabase) {
        this.type = i;
        this.size = j;
        this.objectOffset = j2;
        this.headerLength = i2;
        this.pack = dfsPackFile;
        this.db = dfsObjDatabase;
    }

    @Override // org.eclipse.jgit.lib.ObjectLoader
    public int getType() {
        return this.type;
    }

    @Override // org.eclipse.jgit.lib.ObjectLoader
    public long getSize() {
        return this.size;
    }

    @Override // org.eclipse.jgit.lib.ObjectLoader
    public byte[] getCachedBytes() throws LargeObjectException {
        throw new LargeObjectException();
    }

    @Override // org.eclipse.jgit.lib.ObjectLoader
    public ObjectStream openStream() throws IOException {
        DfsReader dfsReaderNewReader = this.db.newReader();
        try {
            try {
                PackInputStream packInputStream = new PackInputStream(this.pack, this.objectOffset + ((long) this.headerLength), dfsReaderNewReader);
                return new ObjectStream.Filter(this.type, this.size, new BufferedInputStream(new InflaterInputStream(packInputStream, packInputStream.ctx.inflater(), 8192), 8192));
            } catch (IOException unused) {
                ObjectStream objectStreamOpenStream = dfsReaderNewReader.open(this.pack.getReverseIdx(dfsReaderNewReader).findObject(this.objectOffset), this.type).openStream();
                if (dfsReaderNewReader != null) {
                    dfsReaderNewReader.close();
                }
                return objectStreamOpenStream;
            }
        } catch (Throwable th) {
            if (dfsReaderNewReader != null) {
                dfsReaderNewReader.close();
            }
            throw th;
        }
    }
}
