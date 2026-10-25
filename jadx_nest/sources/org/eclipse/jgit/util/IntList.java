package org.eclipse.jgit.util;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.collections4.CollectionUtils;

/* JADX INFO: loaded from: classes5.dex */
public class IntList {
    private int count;
    private int[] entries;

    public interface IntComparator {
        int compare(int i, int i2);
    }

    public IntList() {
        this(10);
    }

    public IntList(int i) {
        this.entries = new int[i];
    }

    public static IntList filledWithRange(int i, int i2) {
        IntList intList = new IntList(i2 - i);
        while (i < i2) {
            intList.add(i);
            i++;
        }
        return intList;
    }

    public int size() {
        return this.count;
    }

    public boolean contains(int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            if (this.entries[i2] == i) {
                return true;
            }
        }
        return false;
    }

    public int get(int i) {
        if (this.count <= i) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return this.entries[i];
    }

    public void clear() {
        this.count = 0;
    }

    public void add(int i) {
        if (this.count == this.entries.length) {
            grow();
        }
        int[] iArr = this.entries;
        int i2 = this.count;
        this.count = i2 + 1;
        iArr[i2] = i;
    }

    public void set(int i, int i2) {
        int i3 = this.count;
        if (i3 < i) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i3 == i) {
            add(i2);
        } else {
            this.entries[i] = i2;
        }
    }

    public void fillTo(int i, int i2) {
        while (this.count < i) {
            add(i2);
        }
    }

    public void sort(IntComparator intComparator) {
        quickSort(0, this.count - 1, intComparator);
    }

    private void quickSort(int i, int i2, IntComparator intComparator) {
        if (i < i2) {
            int iPartition = partition(i, i2, intComparator);
            quickSort(i, iPartition - 1, intComparator);
            quickSort(iPartition + 1, i2, intComparator);
        }
    }

    private int partition(int i, int i2, IntComparator intComparator) {
        int i3 = this.entries[i2];
        int i4 = i - 1;
        while (i < i2) {
            if (intComparator.compare(this.entries[i], i3) <= 0) {
                i4++;
                int[] iArr = this.entries;
                int i5 = iArr[i4];
                iArr[i4] = iArr[i];
                iArr[i] = i5;
            }
            i++;
        }
        int i6 = i4 + 1;
        int[] iArr2 = this.entries;
        iArr2[i2] = iArr2[i6];
        iArr2[i6] = i3;
        return i6;
    }

    private void grow() {
        int[] iArr = this.entries;
        int[] iArr2 = new int[((iArr.length + 16) * 3) / 2];
        System.arraycopy(iArr, 0, iArr2, 0, this.count);
        this.entries = iArr2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(CollectionUtils.DEFAULT_TOSTRING_PREFIX);
        for (int i = 0; i < this.count; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.entries[i]);
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }
}
