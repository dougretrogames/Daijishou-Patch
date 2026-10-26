package com.googlecode.javaewah.symmetric;

import com.googlecode.javaewah.BitmapStorage;
import com.googlecode.javaewah.datastructure.BitSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* INFO: loaded from: classes4.dex */
public abstract class UpdateableBitmapFunction {
    EWAHPointer[] rw = new EWAHPointer[0];
    int hammingWeight = 0;
    int litWeight = 0;
    boolean[] b = new boolean[0];
    final BitSet litwlist = new BitSet(0);

    public abstract void dispatch(BitmapStorage bitmapStorage, int i, int i2);

    UpdateableBitmapFunction() {
    }

    public final int getNumberOfLiterals() {
        return this.litwlist.cardinality();
    }

    /* INFO: renamed from: com.googlecode.javaewah.symmetric.UpdateableBitmapFunction$1, reason: invalid class name */
    class AnonymousClass1 implements Iterable<EWAHPointer> {
        AnonymousClass1() {
        }

        /* INFO: renamed from: com.googlecode.javaewah.symmetric.UpdateableBitmapFunction$1$1, reason: invalid class name and collision with other inner class name */
        class C00511 implements Iterator<EWAHPointer> {
            int k;

            C00511() {
                this.k = UpdateableBitmapFunction.this.litwlist.nextSetBit(0);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.k >= 0;
            }

            /* WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public EWAHPointer next() {
                EWAHPointer eWAHPointer = UpdateableBitmapFunction.this.rw[this.k];
                this.k = UpdateableBitmapFunction.this.litwlist.nextSetBit(this.k + 1);
                return eWAHPointer;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new RuntimeException("N/A");
            }
        }

        @Override // java.lang.Iterable
        public Iterator<EWAHPointer> iterator() {
            return new C00511();
        }
    }

    public final Iterable<EWAHPointer> getLiterals() {
        return new AnonymousClass1();
    }

    public final void fillWithLiterals(List<EWAHPointer> list) {
        int iNextSetBit = this.litwlist.nextSetBit(0);
        while (iNextSetBit >= 0) {
            list.add(this.rw[iNextSetBit]);
            iNextSetBit = this.litwlist.nextSetBit(iNextSetBit + 1);
        }
    }

    public final void resize(int i) {
        this.rw = (EWAHPointer[]) Arrays.copyOf(this.rw, i);
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
