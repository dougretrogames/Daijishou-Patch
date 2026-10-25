package com.magneticchen.daijishou.utils;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MD5.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/magneticchen/daijishou/utils/MD5;", "", "()V", "TAG", "", "calculateMD5", "updateFile", "Ljava/io/File;", "checkMD5", "", "md5", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MD5 {
    public static final MD5 INSTANCE = new MD5();
    private static final String TAG = "MD5";

    private MD5() {
    }

    public final boolean checkMD5(String md5, File updateFile) {
        Intrinsics.checkNotNullParameter(md5, "md5");
        if (TextUtils.isEmpty(md5) || updateFile == null) {
            Log.e("MD5", "MD5 string empty or updateFile null");
            return false;
        }
        String strCalculateMD5 = calculateMD5(updateFile);
        if (strCalculateMD5 == null) {
            Log.e("MD5", "calculatedDigest null");
            return false;
        }
        Log.v("MD5", "Calculated digest: " + strCalculateMD5);
        Log.v("MD5", "Provided digest: " + md5);
        return StringsKt.equals(strCalculateMD5, md5, true);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x005d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String calculateMD5(java.io.File r12) {
        /*
            r11 = this;
            java.lang.String r1 = "Exception on closing MD5 input stream"
            java.lang.String r2 = "MD5"
            r3 = 0
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r2)     // Catch: java.security.NoSuchAlgorithmException -> L81
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.security.NoSuchAlgorithmException -> L81
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L77
            r4.<init>(r12)     // Catch: java.io.FileNotFoundException -> L77
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch: java.io.FileNotFoundException -> L77
            r12 = 8192(0x2000, float:1.148E-41)
            byte[] r12 = new byte[r12]
        L17:
            int r3 = r4.read(r12)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L60
            if (r3 <= 0) goto L22
            r5 = 0
            r0.update(r12, r5, r3)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L60
            goto L17
        L22:
            byte[] r12 = r0.digest()     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L60
            java.math.BigInteger r0 = new java.math.BigInteger     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L60
            r3 = 1
            r0.<init>(r3, r12)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L60
            r12 = 16
            java.lang.String r12 = r0.toString(r12)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L60
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L60
            java.lang.String r0 = "%32s"
            java.lang.Object[] r12 = new java.lang.Object[]{r12}     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L60
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r3)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L60
            java.lang.String r5 = java.lang.String.format(r0, r12)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L60
            java.lang.String r12 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r12)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L60
            r9 = 4
            r10 = 0
            r6 = 32
            r7 = 48
            r8 = 0
            java.lang.String r12 = kotlin.text.StringsKt.replace$default(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L60
            r4.close()     // Catch: java.io.IOException -> L56
            return r12
        L56:
            r0 = move-exception
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            android.util.Log.e(r2, r1, r0)
            return r12
        L5d:
            r0 = move-exception
            r12 = r0
            goto L6c
        L60:
            r0 = move-exception
            r12 = r0
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = "Unable to process file for MD5"
            java.lang.Throwable r12 = (java.lang.Throwable) r12     // Catch: java.lang.Throwable -> L5d
            r0.<init>(r3, r12)     // Catch: java.lang.Throwable -> L5d
            throw r0     // Catch: java.lang.Throwable -> L5d
        L6c:
            r4.close()     // Catch: java.io.IOException -> L70
            goto L76
        L70:
            r0 = move-exception
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            android.util.Log.e(r2, r1, r0)
        L76:
            throw r12
        L77:
            r0 = move-exception
            r12 = r0
            java.lang.String r0 = "Exception while getting FileInputStream"
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            android.util.Log.e(r2, r0, r12)
            return r3
        L81:
            r0 = move-exception
            r12 = r0
            java.lang.String r0 = "Exception while getting digest"
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            android.util.Log.e(r2, r0, r12)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.utils.MD5.calculateMD5(java.io.File):java.lang.String");
    }
}
