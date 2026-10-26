package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.StoredObjectRepresentationNotAvailableException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.commitgraph.CommitGraph;
import org.eclipse.jgit.internal.storage.pack.CachedPack;
import org.eclipse.jgit.internal.storage.pack.ObjectReuseAsIs;
import org.eclipse.jgit.internal.storage.pack.ObjectToPack;
import org.eclipse.jgit.internal.storage.pack.PackOutputStream;
import org.eclipse.jgit.internal.storage.pack.PackWriter;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BitmapIndex;
import org.eclipse.jgit.lib.InflaterCache;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ProgressMonitor;

/* INFO: loaded from: classes5.dex */
final class WindowCursor extends ObjectReader implements ObjectReuseAsIs {
    private DeltaBaseCache baseCache;

    @Nullable
    private final ObjectInserter createdFromInserter;
    final FileObjectDatabase db;
    private Inflater inf;
    final byte[] tempId;
    private ByteWindow window;

    WindowCursor(FileObjectDatabase fileObjectDatabase) {
        this.tempId = new byte[20];
        this.db = fileObjectDatabase;
        this.createdFromInserter = null;
        this.streamFileThreshold = WindowCache.getStreamFileThreshold();
    }

    WindowCursor(FileObjectDatabase fileObjectDatabase, @Nullable ObjectDirectoryInserter objectDirectoryInserter) {
        this.tempId = new byte[20];
        this.db = fileObjectDatabase;
        this.createdFromInserter = objectDirectoryInserter;
        this.streamFileThreshold = WindowCache.getStreamFileThreshold();
    }

    DeltaBaseCache getDeltaBaseCache() {
        if (this.baseCache == null) {
            this.baseCache = new DeltaBaseCache();
        }
        return this.baseCache;
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public ObjectReader newReader() {
        return new WindowCursor(this.db);
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public BitmapIndex getBitmapIndex() throws IOException {
        Iterator<Pack> it = this.db.getPacks().iterator();
        while (it.hasNext()) {
            PackBitmapIndex bitmapIndex = it.next().getBitmapIndex();
            if (bitmapIndex != null) {
                return new BitmapIndexImpl(bitmapIndex);
            }
        }
        return null;
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public Optional<CommitGraph> getCommitGraph() {
        return this.db.getCommitGraph();
    }

    @Override // org.eclipse.jgit.internal.storage.pack.ObjectReuseAsIs
    public Collection<CachedPack> getCachedPacksAndUpdate(BitmapIndex.BitmapBuilder bitmapBuilder) throws IOException {
        for (Pack pack : this.db.getPacks()) {
            if (bitmapBuilder.removeAllOrNone(pack.getBitmapIndex())) {
                return Collections.singletonList(new LocalCachedPack(Collections.singletonList(pack)));
            }
        }
        return Collections.emptyList();
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public Collection<ObjectId> resolve(AbbreviatedObjectId abbreviatedObjectId) throws IOException {
        if (abbreviatedObjectId.isComplete()) {
            return Collections.singleton(abbreviatedObjectId.toObjectId());
        }
        HashSet hashSet = new HashSet(4);
        this.db.resolve(hashSet, abbreviatedObjectId);
        return hashSet;
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public boolean has(AnyObjectId anyObjectId) throws IOException {
        return this.db.has(anyObjectId);
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public ObjectLoader open(AnyObjectId anyObjectId, int i) throws IOException {
        ObjectLoader objectLoaderOpenObject = this.db.openObject(this, anyObjectId);
        if (objectLoaderOpenObject == null) {
            if (i == -1) {
                throw new MissingObjectException(anyObjectId.copy(), JGitText.get().unknownObjectType2);
            }
            throw new MissingObjectException(anyObjectId.copy(), i);
        }
        if (i == -1 || objectLoaderOpenObject.getType() == i) {
            return objectLoaderOpenObject;
        }
        throw new IncorrectObjectTypeException(anyObjectId.copy(), i);
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public Set<ObjectId> getShallowCommits() throws IOException {
        return this.db.getShallowCommits();
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    public long getObjectSize(AnyObjectId anyObjectId, int i) throws IOException {
        long objectSize = this.db.getObjectSize(this, anyObjectId);
        if (objectSize >= 0) {
            return objectSize;
        }
        if (i == -1) {
            throw new MissingObjectException(anyObjectId.copy(), JGitText.get().unknownObjectType2);
        }
        throw new MissingObjectException(anyObjectId.copy(), i);
    }

    @Override // org.eclipse.jgit.internal.storage.pack.ObjectReuseAsIs
    public LocalObjectToPack newObjectToPack(AnyObjectId anyObjectId, int i) {
        return new LocalObjectToPack(anyObjectId, i);
    }

    @Override // org.eclipse.jgit.internal.storage.pack.ObjectReuseAsIs
    public void selectObjectRepresentation(PackWriter packWriter, ProgressMonitor progressMonitor, Iterable<ObjectToPack> iterable) throws IOException {
        Iterator<ObjectToPack> it = iterable.iterator();
        while (it.hasNext()) {
            this.db.selectObjectRepresentation(packWriter, it.next(), this);
            progressMonitor.update(1);
        }
    }

    @Override // org.eclipse.jgit.internal.storage.pack.ObjectReuseAsIs
    public void copyObjectAsIs(PackOutputStream packOutputStream, ObjectToPack objectToPack, boolean z) throws StoredObjectRepresentationNotAvailableException, IOException {
        LocalObjectToPack localObjectToPack = (LocalObjectToPack) objectToPack;
        localObjectToPack.pack.copyAsIs(packOutputStream, localObjectToPack, z, this);
    }

    @Override // org.eclipse.jgit.internal.storage.pack.ObjectReuseAsIs
    public void writeObjects(PackOutputStream packOutputStream, List<ObjectToPack> list) throws IOException {
        Iterator<ObjectToPack> it = list.iterator();
        while (it.hasNext()) {
            packOutputStream.writeObject(it.next());
        }
    }

    int copy(Pack pack, long j, byte[] bArr, int i, int i2) throws IOException {
        long j2 = pack.length;
        long j3 = j;
        int i3 = i;
        int i4 = i2;
        while (i4 > 0 && j3 < j2) {
            pin(pack, j3);
            byte[] bArr2 = bArr;
            int iCopy = this.window.copy(j3, bArr2, i3, i4);
            j3 += (long) iCopy;
            i3 += iCopy;
            i4 -= iCopy;
            bArr = bArr2;
        }
        return i2 - i4;
    }

    @Override // org.eclipse.jgit.internal.storage.pack.ObjectReuseAsIs
    public void copyPackAsIs(PackOutputStream packOutputStream, CachedPack cachedPack) throws IOException {
        ((LocalCachedPack) cachedPack).copyAsIs(packOutputStream, this);
    }

    void copyPackAsIs(Pack pack, long j, PackOutputStream packOutputStream) throws IOException {
        long j2 = j - 32;
        long j3 = 12;
        while (0 < j2) {
            pin(pack, j3);
            int iMin = (int) Math.min(this.window.size() - ((int) (j3 - this.window.start)), j2);
            this.window.write(packOutputStream, j3, iMin);
            long j4 = iMin;
            j3 += j4;
            j2 -= j4;
        }
    }

    int inflate(Pack pack, long j, byte[] bArr, boolean z) throws DataFormatException, IOException {
        prepareInflater();
        pin(pack, j);
        long input = j + ((long) this.window.setInput(j, this.inf));
        int i = 0;
        while (true) {
            int iInflate = this.inf.inflate(bArr, i, bArr.length - i);
            i += iInflate;
            if (this.inf.finished() || (z && i == bArr.length)) {
                break;
            }
            if (this.inf.needsInput()) {
                pin(pack, input);
                input += (long) this.window.setInput(input, this.inf);
            } else if (iInflate == 0) {
                throw new DataFormatException();
            }
        }
        return i;
    }

    ByteArrayWindow quickCopy(Pack pack, long j, long j2) throws IOException {
        pin(pack, j);
        ByteWindow byteWindow = this.window;
        if ((byteWindow instanceof ByteArrayWindow) && byteWindow.contains(pack, j + (j2 - 1))) {
            return (ByteArrayWindow) this.window;
        }
        return null;
    }

    Inflater inflater() {
        prepareInflater();
        return this.inf;
    }

    private void prepareInflater() {
        Inflater inflater = this.inf;
        if (inflater == null) {
            this.inf = InflaterCache.get();
        } else {
            inflater.reset();
        }
    }

    void pin(Pack pack, long j) throws IOException {
        ByteWindow byteWindow = this.window;
        if (byteWindow == null || !byteWindow.contains(pack, j)) {
            this.window = null;
            this.window = WindowCache.get(pack, j);
        }
    }

    @Override // org.eclipse.jgit.lib.ObjectReader
    @Nullable
    public ObjectInserter getCreatedFromInserter() {
        return this.createdFromInserter;
    }

    @Override // org.eclipse.jgit.lib.ObjectReader, java.lang.AutoCloseable
    public void close() {
        this.window = null;
        this.baseCache = null;
        try {
            InflaterCache.release(this.inf);
        } finally {
            this.inf = null;
        }
    }
}
