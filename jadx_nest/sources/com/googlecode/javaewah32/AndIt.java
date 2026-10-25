package com.googlecode.javaewah32;

import com.googlecode.javaewah.CloneableIterator;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: IteratorAggregation32.java */
/* JADX INFO: loaded from: classes4.dex */
class AndIt implements CloneableIterator<EWAHIterator32> {
    EWAHCompressedBitmap32 buffer = new EWAHCompressedBitmap32();
    final int bufferSize;
    LinkedList<IteratingRLW32> ll;

    public AndIt(LinkedList<IteratingRLW32> linkedList, int i) {
        this.ll = linkedList;
        this.bufferSize = i;
    }

    @Override // com.googlecode.javaewah.CloneableIterator
    public boolean hasNext() {
        return !this.ll.isEmpty();
    }

    @Override // com.googlecode.javaewah.CloneableIterator
    /* JADX INFO: renamed from: clone, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public CloneableIterator<EWAHIterator32> m3469clone() throws CloneNotSupportedException {
        AndIt andIt = (AndIt) super.clone();
        andIt.buffer = this.buffer.m3472clone();
        andIt.ll = (LinkedList) this.ll.clone();
        return andIt;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.googlecode.javaewah.CloneableIterator
    public EWAHIterator32 next() {
        this.buffer.clear();
        IteratorAggregation32.andToContainer(this.buffer, this.bufferSize * this.ll.size(), this.ll.get(0), this.ll.get(1));
        if (this.ll.size() > 2) {
            Iterator<IteratingRLW32> it = this.ll.iterator();
            it.next();
            it.next();
            EWAHCompressedBitmap32 eWAHCompressedBitmap32 = new EWAHCompressedBitmap32();
            while (it.hasNext() && this.buffer.sizeInBytes() > 0) {
                IteratorAggregation32.andToContainer(eWAHCompressedBitmap32, this.buffer.getIteratingRLW(), it.next());
                this.buffer.swap(eWAHCompressedBitmap32);
                eWAHCompressedBitmap32.clear();
            }
        }
        Iterator<IteratingRLW32> it2 = this.ll.iterator();
        while (it2.hasNext()) {
            if (it2.next().size() == 0) {
                this.ll.clear();
                break;
            }
        }
        return this.buffer.getEWAHIterator();
    }
}
