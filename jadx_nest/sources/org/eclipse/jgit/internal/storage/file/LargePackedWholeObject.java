package org.eclipse.jgit.internal.storage.file;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.zip.InflaterInputStream;
import org.eclipse.jgit.errors.LargeObjectException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectStream;

/* JADX INFO: loaded from: classes5.dex */
class LargePackedWholeObject extends ObjectLoader {
    private final FileObjectDatabase db;
    private final int headerLength;
    private final long objectOffset;
    private final Pack pack;
    private final long size;
    private final int type;

    @Override // org.eclipse.jgit.lib.ObjectLoader
    public boolean isLarge() {
        return true;
    }

    LargePackedWholeObject(int i, long j, long j2, int i2, Pack pack, FileObjectDatabase fileObjectDatabase) {
        this.type = i;
        this.size = j;
        this.objectOffset = j2;
        this.headerLength = i2;
        this.pack = pack;
        this.db = fileObjectDatabase;
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
        try {
            throw new LargeObjectException(getObjectId());
        } catch (IOException e) {
            throw new LargeObjectException(e);
        }
    }

    @Override // org.eclipse.jgit.lib.ObjectLoader
    public ObjectStream openStream() throws IOException {
        WindowCursor windowCursor = new WindowCursor(this.db);
        try {
            return new ObjectStream.Filter(this.type, this.size, new BufferedInputStream(new InflaterInputStream(new PackInputStream(this.pack, this.objectOffset + ((long) this.headerLength), windowCursor), windowCursor.inflater(), 8192), 8192));
        } catch (IOException unused) {
            return windowCursor.open(getObjectId(), this.type).openStream();
        }
    }

    private ObjectId getObjectId() throws IOException {
        return this.pack.findObjectForOffset(this.objectOffset);
    }
}
