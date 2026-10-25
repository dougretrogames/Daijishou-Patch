package com.googlecode.javaewah;

import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: IteratorAggregation.java */
/* JADX INFO: loaded from: classes4.dex */
class BufferedAndIterator implements CloneableIterator<EWAHIterator> {
    EWAHCompressedBitmap buffer = new EWAHCompressedBitmap();
    final int bufferSize;
    LinkedList<IteratingRLW> ll;

    public BufferedAndIterator(LinkedList<IteratingRLW> linkedList, int i) {
        this.ll = linkedList;
        this.bufferSize = i;
    }

    @Override // com.googlecode.javaewah.CloneableIterator
    public boolean hasNext() {
        return !this.ll.isEmpty();
    }

    @Override // com.googlecode.javaewah.CloneableIterator
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CloneableIterator<EWAHIterator> m3455clone() throws CloneNotSupportedException {
        BufferedAndIterator bufferedAndIterator = (BufferedAndIterator) super.clone();
        bufferedAndIterator.buffer = this.buffer.m3460clone();
        bufferedAndIterator.ll = (LinkedList) this.ll.clone();
        return bufferedAndIterator;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.googlecode.javaewah.CloneableIterator
    public EWAHIterator next() {
        this.buffer.clear();
        IteratorAggregation.andToContainer(this.buffer, this.bufferSize * this.ll.size(), this.ll.get(0), this.ll.get(1));
        if (this.ll.size() > 2) {
            Iterator<IteratingRLW> it = this.ll.iterator();
            it.next();
            it.next();
            EWAHCompressedBitmap eWAHCompressedBitmap = new EWAHCompressedBitmap();
            while (it.hasNext() && this.buffer.sizeInBytes() > 0) {
                IteratorAggregation.andToContainer(eWAHCompressedBitmap, this.buffer.getIteratingRLW(), it.next());
                this.buffer.swap(eWAHCompressedBitmap);
                eWAHCompressedBitmap.clear();
            }
        }
        Iterator<IteratingRLW> it2 = this.ll.iterator();
        while (it2.hasNext()) {
            if (it2.next().size() == 0) {
                this.ll.clear();
                break;
            }
        }
        return this.buffer.getEWAHIterator();
    }
}
