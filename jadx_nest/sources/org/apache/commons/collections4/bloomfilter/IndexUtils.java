package org.apache.commons.collections4.bloomfilter;

import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
final class IndexUtils {
    static final int MAX_ARRAY_SIZE = 2147483639;

    static int[] ensureCapacityForAdd(int[] iArr, int i) {
        return i >= iArr.length ? Arrays.copyOf(iArr, (int) Math.min(2147483639L, Math.max(((long) iArr.length) * 2, i + 1))) : iArr;
    }

    private IndexUtils() {
    }
}
