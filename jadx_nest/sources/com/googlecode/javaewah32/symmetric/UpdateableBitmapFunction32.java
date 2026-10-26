package com.googlecode.javaewah32.symmetric;

import com.googlecode.javaewah.datastructure.BitSet;
import com.googlecode.javaewah32.BitmapStorage32;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* INFO: loaded from: classes4.dex */
public abstract class UpdateableBitmapFunction32 {
    EWAHPointer32[] rw = new EWAHPointer32[0];
    int hammingWeight = 0;
    int litWeight = 0;
    boolean[] b = new boolean[0];
    final BitSet litwlist = new BitSet(0);

    public abstract void dispatch(BitmapStorage32 bitmapStorage32, int i, int i2);

    UpdateableBitmapFunction32() {
    }

    public final int getNumberOfLiterals() {
        return this.litwlist.cardinality();
    }

    /* INFO: renamed from: com.googlecode.javaewah32.symmetric.UpdateableBitmapFunction32$1, reason: invalid class name */
    class AnonymousClass1 implements Iterable<EWAHPointer32> {
        AnonymousClass1() {
        }

        /* INFO: renamed from: com.googlecode.javaewah32.symmetric.UpdateableBitmapFunction32$1$1, reason: invalid class name and collision with other inner class name */
        class C00521 implements Iterator<EWAHPointer32> {
            int k;

            C00521() {
                this.k = UpdateableBitmapFunction32.this.litwlist.nextSetBit(0);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.k >= 0;
            }

            /* WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public EWAHPointer32 next() {
                EWAHPointer32 eWAHPointer32 = UpdateableBitmapFunction32.this.rw[this.k];
                this.k = UpdateableBitmapFunction32.this.litwlist.nextSetBit(this.k + 1);
                return eWAHPointer32;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new RuntimeException("N/A");
            }
        }

        @Override // java.lang.Iterable
        public Iterator<EWAHPointer32> iterator() {
            return new C00521();
        }
    }

    public final Iterable<EWAHPointer32> getLiterals() {
        return new AnonymousClass1();
    }

    public final void fillWithLiterals(List<EWAHPointer32> list) {
        int iNextSetBit = this.litwlist.nextSetBit(0);
        while (iNextSetBit >= 0) {
            list.add(this.rw[iNextSetBit]);
            iNextSetBit = this.litwlist.nextSetBit(iNextSetBit + 1);
        }
    }

    public final void resize(int i) {
        this.rw = (EWAHPointer32[]) Arrays.copyOf(this.rw, i);
        this.litwlist.resize(i);
        this.b = Arrays.copyOf(this.b, i);
    }

    public void setLiteral(int i) {
        if (this.litwlist.get(i)) {
            return;
        }
        this.litwlist.set(i);
        this.litWeight++;
        boolean[] zArr = this.b;
        if (zArr[i]) {
            zArr[i] = false;
            this.hammingWeight--;
        }
    }

    public void clearLiteral(int i) {
        if (this.litwlist.get(i)) {
            this.litwlist.set(i, false);
            this.litWeight--;
        }
    }

    public final void setZero(int i) {
        boolean[] zArr = this.b;
        if (zArr[i]) {
            zArr[i] = false;
            this.hammingWeight--;
        } else {
            clearLiteral(i);
        }
    }

    public final void setOne(int i) {
        if (this.b[i]) {
            return;
        }
        clearLiteral(i);
        this.b[i] = true;
        this.hammingWeight++;
    }
}
