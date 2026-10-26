package org.eclipse.jgit.lib;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.jgit.lib.ObjectIdOwnerMap.Entry;

/* INFO: loaded from: classes5.dex */
public class ObjectIdOwnerMap<V extends Entry> implements Iterable<V>, ObjectIdSet {
    private static final int INITIAL_DIRECTORY = 1024;
    private static final int SEGMENT_BITS = 11;
    private static final int SEGMENT_SHIFT = 21;
    V[][] directory;
    int size;
    int bits = 0;
    private int mask = 0;
    private int grow = computeGrowAt(0);

    private static final int computeGrowAt(int i) {
        return 1 << (i + 11);
    }

    /* WARN: Multi-variable type inference failed */
    public ObjectIdOwnerMap() {
        V[][] vArr = (V[][]) new Entry[1024][];
        this.directory = vArr;
        vArr[0] = newSegment();
    }

    public void clear() {
        this.size = 0;
        for (V[] vArr : this.directory) {
            if (vArr == null) {
                return;
            }
            Arrays.fill(vArr, (Object) null);
        }
    }

    public V get(AnyObjectId anyObjectId) {
        if (anyObjectId == null) {
            return null;
        }
        int i = anyObjectId.w1;
        for (V v = this.directory[this.mask & i][i >>> 21]; v != null; v = (V) v.next) {
            if (equals(v, anyObjectId)) {
                return v;
            }
        }
        return null;
    }

    @Override // org.eclipse.jgit.lib.ObjectIdSet
    public boolean contains(AnyObjectId anyObjectId) {
        return get(anyObjectId) != null;
    }

    /* WARN: Incorrect types in method signature: <Q:TV;>(TQ;)V */
    public void add(Entry entry) {
        int i = this.size + 1;
        this.size = i;
        if (i == this.grow) {
            grow();
        }
        int i2 = entry.w1;
        Entry[] entryArr = this.directory[this.mask & i2];
        int i3 = i2 >>> 21;
        entry.next = entryArr[i3];
        entryArr[i3] = entry;
    }

    /* WARN: Incorrect types in method signature: <Q:TV;>(TQ;)TV; */
    public Entry addIfAbsent(Entry entry) {
        int i = entry.w1;
        Entry[] entryArr = this.directory[this.mask & i];
        int i2 = i >>> 21;
        for (Entry entry2 = entryArr[i2]; entry2 != null; entry2 = entry2.next) {
            if (equals(entry2, entry)) {
                return entry2;
            }
        }
        entry.next = entryArr[i2];
        entryArr[i2] = entry;
        int i3 = this.size + 1;
        this.size = i3;
        if (i3 == this.grow) {
            grow();
        }
        return entry;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.ObjectIdOwnerMap$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<V> {
        private int dirIdx;
        private int found;
        private V next;
        private int tblIdx;

        AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.found < ObjectIdOwnerMap.this.size;
        }

        @Override // java.util.Iterator
        public V next() {
            V v;
            V v2 = this.next;
            if (v2 != null) {
                return (V) found(v2);
            }
            while (true) {
                V[][] vArr = ObjectIdOwnerMap.this.directory;
                int i = this.dirIdx;
                V[] vArr2 = vArr[i];
                if (this.tblIdx == vArr2.length) {
                    int i2 = i + 1;
                    this.dirIdx = i2;
                    if (i2 >= (1 << ObjectIdOwnerMap.this.bits)) {
                        throw new NoSuchElementException();
                    }
                    vArr2 = ObjectIdOwnerMap.this.directory[this.dirIdx];
                    this.tblIdx = 0;
                }
                do {
                    int i3 = this.tblIdx;
                    if (i3 < vArr2.length) {
                        this.tblIdx = i3 + 1;
                        v = vArr2[i3];
                    }
                } while (v == null);
                return (V) found(v);
            }
        }

        private V found(V v) {
            this.found++;
            this.next = (V) v.next;
            return v;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<V> iterator() {
        return new AnonymousClass1();
    }

    private void grow() {
        int i = this.bits;
        int i2 = 1 << i;
        int i3 = 1 << i;
        int i4 = i + 1;
        this.bits = i4;
        this.mask = (1 << i4) - 1;
        this.grow = computeGrowAt(i4);
        int i5 = 1 << this.bits;
        V[][] vArr = this.directory;
        if (vArr.length < i5) {
            V[][] vArr2 = (V[][]) new Entry[i5 << 1][];
            System.arraycopy(vArr, 0, vArr2, 0, i2);
            this.directory = vArr2;
        }
        for (int i6 = 0; i6 < i2; i6++) {
            Entry[] entryArr = this.directory[i6];
            Entry[] entryArrNewSegment = newSegment();
            for (int i7 = 0; i7 < entryArr.length; i7++) {
                Entry entry = entryArr[i7];
                Entry entry2 = null;
                Entry entry3 = null;
                while (entry != null) {
                    Entry entry4 = entry.next;
                    if ((entry.w1 & i3) == 0) {
                        entry.next = entry2;
                        entry2 = entry;
                    } else {
                        entry.next = entry3;
                        entry3 = entry;
                    }
                    entry = entry4;
                }
                entryArr[i7] = entry2;
                entryArrNewSegment[i7] = entry3;
            }
            ((V[][]) this.directory)[i2 + i6] = entryArrNewSegment;
        }
    }

    private final V[] newSegment() {
        return (V[]) new Entry[2048];
    }

    private static final boolean equals(AnyObjectId anyObjectId, AnyObjectId anyObjectId2) {
        return anyObjectId.w2 == anyObjectId2.w2 && anyObjectId.w3 == anyObjectId2.w3 && anyObjectId.w4 == anyObjectId2.w4 && anyObjectId.w5 == anyObjectId2.w5 && anyObjectId.w1 == anyObjectId2.w1;
    }

    public static abstract class Entry extends ObjectId {
        transient Entry next;

        public Entry(AnyObjectId anyObjectId) {
            super(anyObjectId);
        }
    }
}
