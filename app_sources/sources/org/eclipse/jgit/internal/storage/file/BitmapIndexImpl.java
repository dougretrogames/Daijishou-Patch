package org.eclipse.jgit.internal.storage.file;

import com.googlecode.javaewah.EWAHCompressedBitmap;
import com.googlecode.javaewah.IntIterator;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BitmapIndex;
import org.eclipse.jgit.lib.BitmapObject;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdOwnerMap;
import org.eclipse.jgit.util.BlockList;

/* INFO: loaded from: classes5.dex */
public class BitmapIndexImpl implements BitmapIndex {
    private static final int EXTRA_BITS = 10240;
    final int indexObjectCount;
    private BitmapIndex.BitmapLookupListener listener = BitmapIndex.BitmapLookupListener.NOOP;
    final MutableBitmapIndex mutableIndex = new MutableBitmapIndex(null);
    final PackBitmapIndex packIndex;

    public BitmapIndexImpl(PackBitmapIndex packBitmapIndex) {
        this.packIndex = packBitmapIndex;
        this.indexObjectCount = packBitmapIndex.getObjectCount();
    }

    PackBitmapIndex getPackBitmapIndex() {
        return this.packIndex;
    }

    @Override // org.eclipse.jgit.lib.BitmapIndex
    public CompressedBitmap getBitmap(AnyObjectId anyObjectId) {
        EWAHCompressedBitmap bitmap = this.packIndex.getBitmap(anyObjectId);
        if (bitmap == null) {
            this.listener.onBitmapNotFound(anyObjectId);
            return null;
        }
        this.listener.onBitmapFound(anyObjectId);
        return new CompressedBitmap(bitmap, this);
    }

    @Override // org.eclipse.jgit.lib.BitmapIndex
    public CompressedBitmapBuilder newBitmapBuilder() {
        return new CompressedBitmapBuilder(this);
    }

    @Override // org.eclipse.jgit.lib.BitmapIndex
    public void addBitmapLookupListener(BitmapIndex.BitmapLookupListener bitmapLookupListener) {
        if (bitmapLookupListener == null) {
            throw new IllegalArgumentException(JGitText.get().bitmapUseNoopNoListener);
        }
        this.listener = bitmapLookupListener;
    }

    int findPosition(AnyObjectId anyObjectId) {
        int iFindPosition = this.packIndex.findPosition(anyObjectId);
        if (iFindPosition >= 0) {
            return iFindPosition;
        }
        int iFindPosition2 = this.mutableIndex.findPosition(anyObjectId);
        return iFindPosition2 >= 0 ? iFindPosition2 + this.indexObjectCount : iFindPosition2;
    }

    int findOrInsert(AnyObjectId anyObjectId, int i) {
        int iFindPosition = findPosition(anyObjectId);
        return iFindPosition < 0 ? this.mutableIndex.findOrInsert(anyObjectId, i) + this.indexObjectCount : iFindPosition;
    }

    private static final class ComboBitset {
        private InflatingBitSet inflatingBitmap;
        private BitSet toAdd;
        private BitSet toRemove;

        ComboBitset() {
            this(new EWAHCompressedBitmap());
        }

        ComboBitset(EWAHCompressedBitmap eWAHCompressedBitmap) {
            this.inflatingBitmap = new InflatingBitSet(eWAHCompressedBitmap);
        }

        EWAHCompressedBitmap combine() {
            EWAHCompressedBitmap eWAHCompressedBitmap;
            BitSet bitSet = this.toAdd;
            EWAHCompressedBitmap eWAHCompressedBitmap2 = null;
            if (bitSet != null) {
                eWAHCompressedBitmap = bitSet.toEWAHCompressedBitmap();
                this.toAdd = null;
            } else {
                eWAHCompressedBitmap = null;
            }
            BitSet bitSet2 = this.toRemove;
            if (bitSet2 != null) {
                EWAHCompressedBitmap eWAHCompressedBitmap3 = bitSet2.toEWAHCompressedBitmap();
                this.toRemove = null;
                eWAHCompressedBitmap2 = eWAHCompressedBitmap3;
            }
            if (eWAHCompressedBitmap != null) {
                or(eWAHCompressedBitmap);
            }
            if (eWAHCompressedBitmap2 != null) {
                andNot(eWAHCompressedBitmap2);
            }
            return this.inflatingBitmap.getBitmap();
        }

        void or(EWAHCompressedBitmap eWAHCompressedBitmap) {
            if (this.toRemove != null) {
                combine();
            }
            this.inflatingBitmap = this.inflatingBitmap.or(eWAHCompressedBitmap);
        }

        void andNot(EWAHCompressedBitmap eWAHCompressedBitmap) {
            if (this.toAdd != null || this.toRemove != null) {
                combine();
            }
            this.inflatingBitmap = this.inflatingBitmap.andNot(eWAHCompressedBitmap);
        }

        void xor(EWAHCompressedBitmap eWAHCompressedBitmap) {
            if (this.toAdd != null || this.toRemove != null) {
                combine();
            }
            this.inflatingBitmap = this.inflatingBitmap.xor(eWAHCompressedBitmap);
        }

        boolean contains(int i) {
            BitSet bitSet = this.toRemove;
            if (bitSet != null && bitSet.get(i)) {
                return false;
            }
            BitSet bitSet2 = this.toAdd;
            if (bitSet2 == null || !bitSet2.get(i)) {
                return this.inflatingBitmap.contains(i);
            }
            return true;
        }

        void remove(int i) {
            BitSet bitSet = this.toAdd;
            if (bitSet != null) {
                bitSet.clear(i);
            }
            if (this.inflatingBitmap.maybeContains(i)) {
                if (this.toRemove == null) {
                    this.toRemove = new BitSet(i + BitmapIndexImpl.EXTRA_BITS);
                }
                this.toRemove.set(i);
            }
        }

        void set(int i) {
            BitSet bitSet = this.toRemove;
            if (bitSet != null) {
                bitSet.clear(i);
            }
            if (this.toAdd == null) {
                this.toAdd = new BitSet(i + BitmapIndexImpl.EXTRA_BITS);
            }
            this.toAdd.set(i);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final class CompressedBitmapBuilder implements BitmapIndex.BitmapBuilder {
        private final BitmapIndexImpl bitmapIndex;
        private ComboBitset bitset = new ComboBitset();

        CompressedBitmapBuilder(BitmapIndexImpl bitmapIndexImpl) {
            this.bitmapIndex = bitmapIndexImpl;
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.BitmapBuilder
        public boolean contains(AnyObjectId anyObjectId) {
            int iFindPosition = this.bitmapIndex.findPosition(anyObjectId);
            return iFindPosition >= 0 && this.bitset.contains(iFindPosition);
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.BitmapBuilder
        public BitmapIndex.BitmapBuilder addObject(AnyObjectId anyObjectId, int i) {
            this.bitset.set(this.bitmapIndex.findOrInsert(anyObjectId, i));
            return this;
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.BitmapBuilder
        public void remove(AnyObjectId anyObjectId) {
            int iFindPosition = this.bitmapIndex.findPosition(anyObjectId);
            if (iFindPosition >= 0) {
                this.bitset.remove(iFindPosition);
            }
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.BitmapBuilder, org.eclipse.jgit.lib.BitmapIndex.Bitmap
        public CompressedBitmapBuilder or(BitmapIndex.Bitmap bitmap) {
            this.bitset.or(ewahBitmap(bitmap));
            return this;
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.BitmapBuilder, org.eclipse.jgit.lib.BitmapIndex.Bitmap
        public CompressedBitmapBuilder andNot(BitmapIndex.Bitmap bitmap) {
            this.bitset.andNot(ewahBitmap(bitmap));
            return this;
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.BitmapBuilder, org.eclipse.jgit.lib.BitmapIndex.Bitmap
        public CompressedBitmapBuilder xor(BitmapIndex.Bitmap bitmap) {
            this.bitset.xor(ewahBitmap(bitmap));
            return this;
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.BitmapBuilder
        public CompressedBitmap build() {
            return new CompressedBitmap(this.bitset.combine(), this.bitmapIndex);
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.Bitmap, java.lang.Iterable
        public Iterator<BitmapObject> iterator() {
            return build().iterator();
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.BitmapBuilder
        public int cardinality() {
            return this.bitset.combine().cardinality();
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.BitmapBuilder
        public boolean removeAllOrNone(PackBitmapIndex packBitmapIndex) {
            if (!this.bitmapIndex.packIndex.equals(packBitmapIndex)) {
                return false;
            }
            EWAHCompressedBitmap eWAHCompressedBitmapXor = this.bitset.combine().xor(BitmapIndexImpl.ones(this.bitmapIndex.indexObjectCount));
            IntIterator intIterator = eWAHCompressedBitmapXor.intIterator();
            if (intIterator.hasNext() && intIterator.next() < this.bitmapIndex.indexObjectCount) {
                return false;
            }
            this.bitset = new ComboBitset(eWAHCompressedBitmapXor);
            return true;
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.BitmapBuilder
        public BitmapIndexImpl getBitmapIndex() {
            return this.bitmapIndex;
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.Bitmap
        public EWAHCompressedBitmap retrieveCompressed() {
            return build().retrieveCompressed();
        }

        private EWAHCompressedBitmap ewahBitmap(BitmapIndex.Bitmap bitmap) {
            if (bitmap instanceof CompressedBitmap) {
                CompressedBitmap compressedBitmap = (CompressedBitmap) bitmap;
                if (compressedBitmap.bitmapIndex != this.bitmapIndex) {
                    throw new IllegalArgumentException();
                }
                return compressedBitmap.bitmap;
            }
            if (bitmap instanceof CompressedBitmapBuilder) {
                CompressedBitmapBuilder compressedBitmapBuilder = (CompressedBitmapBuilder) bitmap;
                if (compressedBitmapBuilder.bitmapIndex != this.bitmapIndex) {
                    throw new IllegalArgumentException();
                }
                return compressedBitmapBuilder.bitset.combine();
            }
            throw new IllegalArgumentException();
        }
    }

    public static final class CompressedBitmap implements BitmapIndex.Bitmap {
        final EWAHCompressedBitmap bitmap;
        final BitmapIndexImpl bitmapIndex;

        public CompressedBitmap(EWAHCompressedBitmap eWAHCompressedBitmap, BitmapIndexImpl bitmapIndexImpl) {
            this.bitmap = eWAHCompressedBitmap;
            this.bitmapIndex = bitmapIndexImpl;
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.Bitmap
        public CompressedBitmap or(BitmapIndex.Bitmap bitmap) {
            return new CompressedBitmap(this.bitmap.or(ewahBitmap(bitmap)), this.bitmapIndex);
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.Bitmap
        public CompressedBitmap andNot(BitmapIndex.Bitmap bitmap) {
            return new CompressedBitmap(this.bitmap.andNot(ewahBitmap(bitmap)), this.bitmapIndex);
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.Bitmap
        public CompressedBitmap xor(BitmapIndex.Bitmap bitmap) {
            return new CompressedBitmap(this.bitmap.xor(ewahBitmap(bitmap)), this.bitmapIndex);
        }

        private final IntIterator ofObjectType(int i) {
            return this.bitmapIndex.packIndex.ofObjectType(this.bitmap, i).intIterator();
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.Bitmap, java.lang.Iterable
        public Iterator<BitmapObject> iterator() {
            return new AnonymousClass1(this.bitmap.andNot(BitmapIndexImpl.ones(this.bitmapIndex.indexObjectCount)).intIterator(), ofObjectType(1), ofObjectType(2), ofObjectType(3), ofObjectType(4));
        }

        /* INFO: renamed from: org.eclipse.jgit.internal.storage.file.BitmapIndexImpl$CompressedBitmap$1, reason: invalid class name */
        class AnonymousClass1 implements Iterator<BitmapObject> {
            private IntIterator cached;
            private final BitmapObjectImpl out = new BitmapObjectImpl(null);
            private int type;
            private final /* synthetic */ IntIterator val$blobs;
            private final /* synthetic */ IntIterator val$commits;
            private final /* synthetic */ IntIterator val$tags;
            private final /* synthetic */ IntIterator val$trees;

            AnonymousClass1(IntIterator intIterator, IntIterator intIterator2, IntIterator intIterator3, IntIterator intIterator4, IntIterator intIterator5) {
                this.val$commits = intIterator2;
                this.val$trees = intIterator3;
                this.val$blobs = intIterator4;
                this.val$tags = intIterator5;
                this.cached = intIterator;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (!this.cached.hasNext()) {
                    if (this.val$commits.hasNext()) {
                        this.type = 1;
                        this.cached = this.val$commits;
                    } else if (this.val$trees.hasNext()) {
                        this.type = 2;
                        this.cached = this.val$trees;
                    } else if (this.val$blobs.hasNext()) {
                        this.type = 3;
                        this.cached = this.val$blobs;
                    } else {
                        if (!this.val$tags.hasNext()) {
                            return false;
                        }
                        this.type = 4;
                        this.cached = this.val$tags;
                    }
                }
                return true;
            }

            @Override // java.util.Iterator
            public BitmapObject next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int next = this.cached.next();
                if (next < CompressedBitmap.this.bitmapIndex.indexObjectCount) {
                    this.out.type = this.type;
                    this.out.objectId = CompressedBitmap.this.bitmapIndex.packIndex.getObject(next);
                } else {
                    MutableEntry object = CompressedBitmap.this.bitmapIndex.mutableIndex.getObject(next - CompressedBitmap.this.bitmapIndex.indexObjectCount);
                    this.out.type = object.type;
                    this.out.objectId = object;
                }
                return this.out;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        @Override // org.eclipse.jgit.lib.BitmapIndex.Bitmap
        public EWAHCompressedBitmap retrieveCompressed() {
            return this.bitmap;
        }

        private EWAHCompressedBitmap ewahBitmap(BitmapIndex.Bitmap bitmap) {
            if (bitmap instanceof CompressedBitmap) {
                CompressedBitmap compressedBitmap = (CompressedBitmap) bitmap;
                if (compressedBitmap.bitmapIndex != this.bitmapIndex) {
                    throw new IllegalArgumentException();
                }
                return compressedBitmap.bitmap;
            }
            if (bitmap instanceof CompressedBitmapBuilder) {
                CompressedBitmapBuilder compressedBitmapBuilder = (CompressedBitmapBuilder) bitmap;
                if (compressedBitmapBuilder.bitmapIndex != this.bitmapIndex) {
                    throw new IllegalArgumentException();
                }
                return compressedBitmapBuilder.bitset.combine();
            }
            throw new IllegalArgumentException();
        }
    }

    private static final class MutableBitmapIndex {
        private final BlockList<MutableEntry> revList;
        private final ObjectIdOwnerMap<MutableEntry> revMap;

        /* synthetic */ MutableBitmapIndex(BitmapIndexImplIA bitmapIndexImplIA) {
            this();
        }

        private MutableBitmapIndex() {
            this.revMap = new ObjectIdOwnerMap<>();
            this.revList = new BlockList<>();
        }

        int findPosition(AnyObjectId anyObjectId) {
            MutableEntry mutableEntry = (MutableEntry) this.revMap.get(anyObjectId);
            if (mutableEntry == null) {
                return -1;
            }
            return mutableEntry.position;
        }

        MutableEntry getObject(int i) {
            try {
                MutableEntry mutableEntry = this.revList.get(i);
                if (mutableEntry != null) {
                    return mutableEntry;
                }
                throw new IllegalArgumentException(MessageFormat.format(JGitText.get().objectNotFound, String.valueOf(i)));
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException(e);
            }
        }

        int findOrInsert(AnyObjectId anyObjectId, int i) {
            MutableEntry mutableEntry = new MutableEntry(anyObjectId, i, this.revList.size());
            this.revList.add(mutableEntry);
            this.revMap.add(mutableEntry);
            return mutableEntry.position;
        }
    }

    private static final class MutableEntry extends ObjectIdOwnerMap.Entry {
        final int position;
        final int type;

        MutableEntry(AnyObjectId anyObjectId, int i, int i2) {
            super(anyObjectId);
            this.type = i;
            this.position = i2;
        }
    }

    private static final class BitmapObjectImpl extends BitmapObject {
        private ObjectId objectId;
        private int type;

        /* synthetic */ BitmapObjectImpl(BitmapIndexImplIA bitmapIndexImplIA) {
            this();
        }

        private BitmapObjectImpl() {
        }

        @Override // org.eclipse.jgit.lib.BitmapObject
        public ObjectId getObjectId() {
            return this.objectId;
        }

        @Override // org.eclipse.jgit.lib.BitmapObject
        public int getType() {
            return this.type;
        }
    }

    static final EWAHCompressedBitmap ones(int i) {
        EWAHCompressedBitmap eWAHCompressedBitmap = new EWAHCompressedBitmap();
        eWAHCompressedBitmap.addStreamOfEmptyWords(true, i / 64);
        int i2 = i % 64;
        if (i2 > 0) {
            eWAHCompressedBitmap.addWord((1 << i2) - 1, i2);
        }
        return eWAHCompressedBitmap;
    }
}
