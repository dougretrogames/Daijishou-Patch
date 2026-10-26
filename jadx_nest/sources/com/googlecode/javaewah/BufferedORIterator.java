package com.googlecode.javaewah;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* INFO: compiled from: IteratorAggregation.java */
/* INFO: loaded from: classes4.dex */
class BufferedORIterator implements CloneableIterator<EWAHIterator> {
    final EWAHCompressedBitmap buffer = new EWAHCompressedBitmap();
    final long[] hardBitmap;
    final LinkedList<IteratingRLW> ll;

    BufferedORIterator(LinkedList<IteratingRLW> linkedList, int i) {
        this.ll = linkedList;
        this.hardBitmap = new long[i];
    }

    @Override // com.googlecode.javaewah.CloneableIterator
    /* INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CloneableIterator<EWAHIterator> m3457clone() throws CloneNotSupportedException {
        BufferedXORIterator bufferedXORIterator = (BufferedXORIterator) super.clone();
        bufferedXORIterator.buffer = this.buffer.m3460clone();
        bufferedXORIterator.hardbitmap = (long[]) this.hardBitmap.clone();
        bufferedXORIterator.ll = (LinkedList) this.ll.clone();
        return bufferedXORIterator;
    }

    @Override // com.googlecode.javaewah.CloneableIterator
    public boolean hasNext() {
        return !this.ll.isEmpty();
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // com.googlecode.javaewah.CloneableIterator
    public EWAHIterator next() {
        this.buffer.clear();
        Iterator<IteratingRLW> it = this.ll.iterator();
        long j = 0;
        while (it.hasNext()) {
            IteratingRLW next = it.next();
            if (next.size() > 0) {
                long jInplaceor = IteratorAggregation.inplaceor(this.hardBitmap, next);
                if (jInplaceor > j) {
                    j = jInplaceor;
                }
            } else {
                it.remove();
            }
        }
        for (int i = 0; i < j; i++) {
            this.buffer.addWord(this.hardBitmap[i]);
        }
        Arrays.fill(this.hardBitmap, 0L);
        return this.buffer.getEWAHIterator();
    }
}
