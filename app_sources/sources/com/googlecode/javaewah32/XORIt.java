package com.googlecode.javaewah32;

import com.googlecode.javaewah.CloneableIterator;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* INFO: compiled from: IteratorAggregation32.java */
/* INFO: loaded from: classes4.dex */
class XORIt implements CloneableIterator<EWAHIterator32> {
    EWAHCompressedBitmap32 buffer = new EWAHCompressedBitmap32();
    int[] hardbitmap;
    LinkedList<IteratingRLW32> ll;

    XORIt(LinkedList<IteratingRLW32> linkedList, int i) {
        this.ll = linkedList;
        this.hardbitmap = new int[i];
    }

    @Override // com.googlecode.javaewah.CloneableIterator
    /* INFO: renamed from: clone, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public CloneableIterator<EWAHIterator32> m3480clone() throws CloneNotSupportedException {
        XORIt xORIt = (XORIt) super.clone();
        xORIt.buffer = this.buffer.m3472clone();
        xORIt.hardbitmap = (int[]) this.hardbitmap.clone();
        xORIt.ll = (LinkedList) this.ll.clone();
        return xORIt;
    }

    @Override // com.googlecode.javaewah.CloneableIterator
    public boolean hasNext() {
        return !this.ll.isEmpty();
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // com.googlecode.javaewah.CloneableIterator
    public EWAHIterator32 next() {
        this.buffer.clear();
        Iterator<IteratingRLW32> it = this.ll.iterator();
        int i = 0;
        while (it.hasNext()) {
            IteratingRLW32 next = it.next();
            if (next.size() > 0) {
                int iInplacexor = IteratorAggregation32.inplacexor(this.hardbitmap, next);
                if (iInplacexor > i) {
                    i = iInplacexor;
                }
            } else {
                it.remove();
            }
        }
        for (int i2 = 0; i2 < i; i2++) {
            this.buffer.addWord(this.hardbitmap[i2]);
        }
        Arrays.fill(this.hardbitmap, 0);
        return this.buffer.getEWAHIterator();
    }
}
