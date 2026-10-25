package org.eclipse.jgit.lib;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: loaded from: classes5.dex */
public class ObjectIdSubclassMap<V extends ObjectId> implements Iterable<V>, ObjectIdSet {
    private static final int INITIAL_TABLE_SIZE = 2048;
    private int grow;
    private int mask;
    int size;
    V[] table;

    public ObjectIdSubclassMap() {
        initTable(2048);
    }

    public void clear() {
        this.size = 0;
        initTable(2048);
    }

    public V get(AnyObjectId anyObjectId) {
        int i = this.mask;
        int i2 = anyObjectId.w1 & i;
        V[] vArr = this.table;
        while (true) {
            V v = vArr[i2];
            if (v == null) {
                return null;
            }
            if (AnyObjectId.isEqual(v, anyObjectId)) {
                return v;
            }
            i2 = (i2 + 1) & i;
        }
    }

    @Override // org.eclipse.jgit.lib.ObjectIdSet
    public boolean contains(AnyObjectId anyObjectId) {
        return get(anyObjectId) != null;
    }

    /* JADX WARN: Incorrect types in method signature: <Q:TV;>(TQ;)V */
    public void add(ObjectId objectId) {
        int i = this.size + 1;
        this.size = i;
        if (i == this.grow) {
            grow();
        }
        insert(objectId);
    }

    /* JADX WARN: Incorrect types in method signature: <Q:TV;>(TQ;)TV; */
    public ObjectId addIfAbsent(ObjectId objectId) {
        int i = this.mask;
        int i2 = objectId.w1 & i;
        ObjectId[] objectIdArr = this.table;
        while (true) {
            ObjectId objectId2 = objectIdArr[i2];
            if (objectId2 != null) {
                if (AnyObjectId.isEqual(objectId2, objectId)) {
                    return objectId2;
                }
                i2 = (i2 + 1) & i;
            } else {
                int i3 = this.size + 1;
                this.size = i3;
                if (i3 == this.grow) {
                    grow();
                    insert(objectId);
                    return objectId;
                }
                objectIdArr[i2] = objectId;
                return objectId;
            }
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.lib.ObjectIdSubclassMap$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<V> {
        private int found;
        private int i;

        AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.found < ObjectIdSubclassMap.this.size;
        }

        @Override // java.util.Iterator
        public V next() {
            while (this.i < ObjectIdSubclassMap.this.table.length) {
                V[] vArr = ObjectIdSubclassMap.this.table;
                int i = this.i;
                this.i = i + 1;
                V v = vArr[i];
                if (v != null) {
                    this.found++;
                    return v;
                }
            }
            throw new NoSuchElementException();
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

    private void insert(V v) {
        int i = this.mask;
        int i2 = v.w1 & i;
        V[] vArr = this.table;
        while (vArr[i2] != null) {
            i2 = (i2 + 1) & i;
        }
        vArr[i2] = v;
    }

    private void grow() {
        V[] vArr = this.table;
        initTable(vArr.length << 1);
        for (V v : vArr) {
            if (v != null) {
                insert(v);
            }
        }
    }

    private void initTable(int i) {
        this.grow = i >> 1;
        this.mask = i - 1;
        this.table = (V[]) createArray(i);
    }

    private final V[] createArray(int i) {
        return (V[]) new ObjectId[i];
    }
}
