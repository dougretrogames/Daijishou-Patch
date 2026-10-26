package org.eclipse.jgit.internal.storage.pack;

/* INFO: loaded from: classes5.dex */
class IntSet {
    private int cnt;
    private int[] set = new int[64];

    IntSet() {
    }

    boolean add(int i) {
        int[] iArr;
        int i2 = this.cnt;
        if (i2 == 0) {
            this.set[0] = i;
            this.cnt = 1;
            return true;
        }
        int i3 = 0;
        do {
            int i4 = (i3 + i2) >>> 1;
            iArr = this.set;
            int i5 = iArr[i4];
            if (i < i5) {
                i2 = i4;
            } else {
                if (i == i5) {
                    return false;
                }
                i3 = i4 + 1;
            }
        } while (i3 < i2);
        int i6 = this.cnt;
        if (i6 == iArr.length) {
            int[] iArr2 = new int[iArr.length * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.set = iArr2;
        }
        int i7 = this.cnt;
        if (i3 < i7) {
            int[] iArr3 = this.set;
            System.arraycopy(iArr3, i3, iArr3, i3 + 1, i7 - i3);
        }
        this.set[i3] = i;
        this.cnt++;
        return true;
    }
}
