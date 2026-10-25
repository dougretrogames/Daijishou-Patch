package com.googlecode.javaewah32;

import com.googlecode.javaewah.CloneableIterator;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: IteratorAggregation32.java */
/* JADX INFO: loaded from: classes4.dex */
class ORIt implements CloneableIterator<EWAHIterator32> {
    final EWAHCompressedBitmap32 buffer = new EWAHCompressedBitmap32();
    final int[] hardBitmap;
    final LinkedList<IteratingRLW32> ll;

    ORIt(LinkedList<IteratingRLW32> linkedList, int i) {
        this.ll = linkedList;
        this.hardBitmap = new int[i];
    }

    @Override // com.googlecode.javaewah.CloneableIterator
    /* JADX INFO: renamed from: clone, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public CloneableIterator<EWAHIterator32> m3478clone() throws CloneNotSupportedException {
        XORIt xORIt = (XORIt) super.clone();
        xORIt.buffer = this.buffer.m3472clone();
        xORIt.hardbitmap = (int[]) this.hardBitmap.clone();
        xORIt.ll = (LinkedList) this.ll.clone();
        return xORIt;
    }

    @Override // com.googlecode.javaewah.CloneableIterator
    public boolean hasNext() {
        return !this.ll.isEmpty();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.googlecode.javaewah.CloneableIterator
    public EWAHIterator32 next() {
        this.buffer.clear();
        Iterator<IteratingRLW32> it = this.ll.iterator();
        int i = 0;
        while (it.hasNext()) {
            IteratingRLW32 next = it.next();
            if (next.size() > 0) {
                int iInplaceor = IteratorAggregation32.inplaceor(this.hardBitmap, next);
                if (iInplaceor > i) {
                    i = iInplaceor;
                }
            } else {
                it.remove();
            }
        }
        for (int i2 = 0; i2 < i; i2++) {
            this.buffer.addWord(this.hardBitmap[i2]);
        }
        Arrays.fill(this.hardBitmap, 0);
        return this.buffer.getEWAHIterator();
    }
}
