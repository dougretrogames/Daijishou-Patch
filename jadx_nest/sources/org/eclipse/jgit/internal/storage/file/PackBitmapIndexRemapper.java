package org.eclipse.jgit.internal.storage.file;

import com.googlecode.javaewah.EWAHCompressedBitmap;
import com.googlecode.javaewah.IntIterator;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BitmapIndex;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: loaded from: classes5.dex */
public class PackBitmapIndexRemapper implements PackBitmapIndex, Iterable<Entry> {
    private final BitSet inflated;
    final PackBitmapIndex newPackIndex;
    private final BasePackBitmapIndex oldPackIndex;
    private final int[] prevToNewMapping;

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public int getBitmapCount() {
        return 0;
    }

    public static PackBitmapIndexRemapper newPackBitmapIndex(BitmapIndex bitmapIndex, PackBitmapIndex packBitmapIndex) {
        if (!(bitmapIndex instanceof BitmapIndexImpl)) {
            return new PackBitmapIndexRemapper(packBitmapIndex);
        }
        PackBitmapIndex packBitmapIndex2 = ((BitmapIndexImpl) bitmapIndex).getPackBitmapIndex();
        if (!(packBitmapIndex2 instanceof BasePackBitmapIndex)) {
            return new PackBitmapIndexRemapper(packBitmapIndex);
        }
        return new PackBitmapIndexRemapper((BasePackBitmapIndex) packBitmapIndex2, packBitmapIndex);
    }

    private PackBitmapIndexRemapper(PackBitmapIndex packBitmapIndex) {
        this.oldPackIndex = null;
        this.newPackIndex = packBitmapIndex;
        this.inflated = null;
        this.prevToNewMapping = null;
    }

    private PackBitmapIndexRemapper(BasePackBitmapIndex basePackBitmapIndex, PackBitmapIndex packBitmapIndex) {
        this.oldPackIndex = basePackBitmapIndex;
        this.newPackIndex = packBitmapIndex;
        this.inflated = new BitSet(packBitmapIndex.getObjectCount());
        this.prevToNewMapping = new int[basePackBitmapIndex.getObjectCount()];
        int i = 0;
        while (true) {
            int[] iArr = this.prevToNewMapping;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = packBitmapIndex.findPosition(basePackBitmapIndex.getObject(i));
            i++;
        }
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public int findPosition(AnyObjectId anyObjectId) {
        return this.newPackIndex.findPosition(anyObjectId);
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public ObjectId getObject(int i) throws IllegalArgumentException {
        return this.newPackIndex.getObject(i);
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public int getObjectCount() {
        return this.newPackIndex.getObjectCount();
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public int getBaseBitmapCount() {
        return this.newPackIndex.getBaseBitmapCount();
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public long getBaseBitmapSizeInBytes() {
        return this.newPackIndex.getBaseBitmapSizeInBytes();
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public int getXorBitmapCount() {
        return this.newPackIndex.getXorBitmapCount();
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public long getXorBitmapSizeInBytes() {
        return this.newPackIndex.getXorBitmapSizeInBytes();
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public EWAHCompressedBitmap ofObjectType(EWAHCompressedBitmap eWAHCompressedBitmap, int i) {
        return this.newPackIndex.ofObjectType(eWAHCompressedBitmap, i);
    }

    @Override // java.lang.Iterable
    public Iterator<Entry> iterator() {
        BasePackBitmapIndex basePackBitmapIndex = this.oldPackIndex;
        if (basePackBitmapIndex == null) {
            return Collections.emptyList().iterator();
        }
        return new AnonymousClass1(basePackBitmapIndex.getBitmaps().iterator());
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.internal.storage.file.PackBitmapIndexRemapper$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<Entry> {
        private Entry entry;
        private final /* synthetic */ Iterator val$it;

        AnonymousClass1(Iterator it) {
            this.val$it = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.entry == null && this.val$it.hasNext()) {
                BasePackBitmapIndex.StoredBitmap storedBitmap = (BasePackBitmapIndex.StoredBitmap) this.val$it.next();
                if (PackBitmapIndexRemapper.this.newPackIndex.findPosition(storedBitmap) != -1) {
                    this.entry = new Entry(storedBitmap, storedBitmap.getFlags());
                }
            }
            return this.entry != null;
        }

        @Override // java.util.Iterator
        public Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Entry entry = this.entry;
            this.entry = null;
            return entry;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackBitmapIndex
    public EWAHCompressedBitmap getBitmap(AnyObjectId anyObjectId) {
        BasePackBitmapIndex basePackBitmapIndex;
        EWAHCompressedBitmap bitmap = this.newPackIndex.getBitmap(anyObjectId);
        if (bitmap != null || (basePackBitmapIndex = this.oldPackIndex) == null) {
            return bitmap;
        }
        BasePackBitmapIndex.StoredBitmap storedBitmap = (BasePackBitmapIndex.StoredBitmap) basePackBitmapIndex.getBitmaps().get(anyObjectId);
        if (storedBitmap == null || this.newPackIndex.findPosition(anyObjectId) == -1) {
            return null;
        }
        this.inflated.clear();
        IntIterator intIterator = storedBitmap.getBitmapWithoutCaching().intIterator();
        while (intIterator.hasNext()) {
            this.inflated.set(this.prevToNewMapping[intIterator.next()]);
        }
        EWAHCompressedBitmap eWAHCompressedBitmap = this.inflated.toEWAHCompressedBitmap();
        eWAHCompressedBitmap.trim();
        return eWAHCompressedBitmap;
    }

    public static final class Entry extends ObjectId {
        private final int flags;

        Entry(AnyObjectId anyObjectId, int i) {
            super(anyObjectId);
            this.flags = i;
        }

        public int getFlags() {
            return this.flags;
        }
    }
}
