package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

/* INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* INFO: loaded from: classes3.dex */
@NullMarked
public final class zzah {
    static Object[] zza(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (objArr[i2] == null) {
                throw new NullPointerException("at index " + i2);
            }
        }
        return objArr;
    }
}
