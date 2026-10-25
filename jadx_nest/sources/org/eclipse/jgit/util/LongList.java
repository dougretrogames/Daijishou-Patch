package org.eclipse.jgit.util;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.collections4.CollectionUtils;

/* JADX INFO: loaded from: classes5.dex */
public class LongList {
    private int count;
    private long[] entries;

    public LongList() {
        this(10);
    }

    public LongList(int i) {
        this.entries = new long[i];
    }

    public int size() {
        return this.count;
    }

    public long get(int i) {
        if (this.count <= i) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return this.entries[i];
    }

    public boolean contains(long j) {
        for (int i = 0; i < this.count; i++) {
            if (this.entries[i] == j) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        this.count = 0;
    }

    public void add(long j) {
        if (this.count == this.entries.length) {
            grow();
        }
        long[] jArr = this.entries;
        int i = this.count;
        this.count = i + 1;
        jArr[i] = j;
    }

    public void set(int i, long j) {
        int i2 = this.count;
        if (i2 < i) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        if (i2 == i) {
            add(j);
        } else {
            this.entries[i] = j;
        }
    }

    public void fillTo(int i, long j) {
        while (this.count < i) {
            add(j);
        }
    }

    public void sort() {
        Arrays.sort(this.entries, 0, this.count);
    }

    private void grow() {
        long[] jArr = this.entries;
        long[] jArr2 = new long[((jArr.length + 16) * 3) / 2];
        System.arraycopy(jArr, 0, jArr2, 0, this.count);
        this.entries = jArr2;
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
