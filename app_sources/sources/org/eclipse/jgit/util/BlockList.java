package org.eclipse.jgit.util;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* INFO: loaded from: classes5.dex */
public class BlockList<T> extends AbstractList<T> {
    private static final int BLOCK_BITS = 10;
    private static final int BLOCK_MASK = 1023;
    static final int BLOCK_SIZE = 1024;
    T[][] directory;
    int size;
    private int tailBlkIdx;
    private T[] tailBlock;
    private int tailDirIdx;

    static final int toBlockIndex(int i) {
        return i & BLOCK_MASK;
    }

    static final int toDirectoryIndex(int i) {
        return i >>> 10;
    }

    /* WARN: Multi-variable type inference failed */
    public BlockList() {
        T[][] tArr = (T[][]) newDirectory(256);
        this.directory = tArr;
        tArr[0] = newBlock();
        this.tailBlock = this.directory[0];
    }

    /* WARN: Multi-variable type inference failed */
    public BlockList(int i) {
        int directoryIndex = toDirectoryIndex(i);
        T[][] tArr = (T[][]) newDirectory(((i & BLOCK_MASK) != 0 || directoryIndex == 0) ? directoryIndex + 1 : directoryIndex);
        this.directory = tArr;
        tArr[0] = newBlock();
        this.tailBlock = this.directory[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        for (T[] tArr : this.directory) {
            if (tArr != null) {
                Arrays.fill(tArr, (Object) null);
            }
        }
        this.size = 0;
        this.tailDirIdx = 0;
        this.tailBlkIdx = 0;
        this.tailBlock = this.directory[0];
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        if (i < 0 || this.size <= i) {
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
        return this.directory[toDirectoryIndex(i)][toBlockIndex(i)];
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        if (i < 0 || this.size <= i) {
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
        T[] tArr = this.directory[toDirectoryIndex(i)];
        int blockIndex = toBlockIndex(i);
        T t2 = tArr[blockIndex];
        tArr[blockIndex] = t;
        return t2;
    }

    public void addAll(BlockList<T> blockList) {
        if (blockList.size == 0) {
            return;
        }
        for (int i = 0; i < blockList.tailDirIdx; i++) {
            addAll(blockList.directory[i], 0, 1024);
        }
        int i2 = blockList.tailBlkIdx;
        if (i2 != 0) {
            addAll(blockList.tailBlock, 0, i2);
        }
    }

    public void addAll(T[] tArr, int i, int i2) {
        while (i2 > 0) {
            int i3 = this.tailBlkIdx;
            int iMin = Math.min(i2, 1024 - i3);
            if (iMin == 0) {
                add(tArr[i]);
                i2--;
                i++;
            } else {
                System.arraycopy(tArr, i, this.tailBlock, i3, iMin);
                this.tailBlkIdx += iMin;
                this.size += iMin;
                i += iMin;
                i2 -= iMin;
            }
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T t) {
        int i = this.tailBlkIdx;
        if (i < 1024) {
            this.tailBlock[i] = t;
            this.tailBlkIdx = i + 1;
            this.size++;
            return true;
        }
        int i2 = this.tailDirIdx + 1;
        this.tailDirIdx = i2;
        T[][] tArr = this.directory;
        if (i2 == tArr.length) {
            T[][] tArr2 = (T[][]) newDirectory(tArr.length << 1);
            T[][] tArr3 = this.directory;
            System.arraycopy(tArr3, 0, tArr2, 0, tArr3.length);
            this.directory = tArr2;
        }
        T[] tArr4 = this.directory[this.tailDirIdx];
        if (tArr4 == null) {
            tArr4 = (T[]) newBlock();
            this.directory[this.tailDirIdx] = tArr4;
        }
        tArr4[0] = t;
        this.tailBlock = tArr4;
        this.tailBlkIdx = 1;
        this.size++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        int i2 = this.size;
        if (i == i2) {
            add(t);
            return;
        }
        if (i < 0 || i2 < i) {
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
        add(null);
        for (int i3 = this.size - 2; i <= i3; i3--) {
            set(i3 + 1, get(i3));
        }
        set(i, t);
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int i) {
        int i2 = this.size;
        if (i == i2 - 1) {
            T[] tArr = this.directory[toDirectoryIndex(i)];
            int blockIndex = toBlockIndex(i);
            T t = tArr[blockIndex];
            tArr[blockIndex] = null;
            this.size--;
            int i3 = this.tailBlkIdx;
            if (i3 > 0) {
                this.tailBlkIdx = i3 - 1;
                return t;
            }
            resetTailBlock();
            return t;
        }
        if (i < 0 || i2 <= i) {
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
        T t2 = get(i);
        while (true) {
            int i4 = this.size;
            if (i < i4 - 1) {
                int i5 = i + 1;
                set(i, get(i5));
                i = i5;
            } else {
                set(i4 - 1, null);
                this.size--;
                resetTailBlock();
                return t2;
            }
        }
    }

    private void resetTailBlock() {
        this.tailDirIdx = toDirectoryIndex(this.size);
        this.tailBlkIdx = toBlockIndex(this.size);
        this.tailBlock = this.directory[this.tailDirIdx];
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new MyIterator(this, null);
    }

    private static <T> T[][] newDirectory(int i) {
        return (T[][]) new Object[i][];
    }

    private static <T> T[] newBlock() {
        return (T[]) new Object[1024];
    }

    private class MyIterator implements Iterator<T> {
        private int blkIdx;
        private T[] block;
        private int dirIdx;
        private int index;

        /* synthetic */ MyIterator(BlockList blockList, BlockListIA blockListIA) {
            this();
        }

        private MyIterator() {
            this.block = BlockList.this.directory[0];
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < BlockList.this.size;
        }

        @Override // java.util.Iterator
        public T next() {
            if (BlockList.this.size <= this.index) {
                throw new NoSuchElementException();
            }
            T[] tArr = this.block;
            int i = this.blkIdx;
            T t = tArr[i];
            int i2 = i + 1;
            this.blkIdx = i2;
            if (i2 == 1024) {
                int i3 = this.dirIdx + 1;
                this.dirIdx = i3;
                if (i3 < BlockList.this.directory.length) {
                    this.block = BlockList.this.directory[this.dirIdx];
                } else {
                    this.block = null;
                }
                this.blkIdx = 0;
            }
            this.index++;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.index;
            if (i == 0) {
                throw new IllegalStateException();
            }
            BlockList blockList = BlockList.this;
            int i2 = i - 1;
            this.index = i2;
            blockList.remove(i2);
            this.dirIdx = BlockList.toDirectoryIndex(this.index);
            this.blkIdx = BlockList.toBlockIndex(this.index);
            this.block = BlockList.this.directory[this.dirIdx];
        }
    }
}
