package com.magneticchen.daijishou.utils;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* INFO: compiled from: MD5.kt */
/* INFO: loaded from: classes4.dex */
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

    private final String calculateMD5(File updateFile) {
        String strClosingException = "Exception on closing MD5 input stream";
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            Intrinsics.checkNotNull(digest);
        } catch (NoSuchAlgorithmException e) {
            Log.e("MD5", "Exception while getting digest", e);
            return null;
        }

        FileInputStream fis;
        try {
            fis = new FileInputStream(updateFile);
        } catch (FileNotFoundException e) {
            Log.e("MD5", "Exception while getting FileInputStream", e);
            return null;
        }

        InputStream is = fis;
        byte[] buffer = new byte[8192];
        try {
            int read;
            while ((read = is.read(buffer)) > 0) {
                digest.update(buffer, 0, read);
            }
            byte[] md5Bytes = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5Bytes);
            String output = bigInt.toString(16);
            String formatted = String.format("%32s", Arrays.copyOf(new Object[]{output}, 1));
            Intrinsics.checkNotNullExpressionValue(formatted, "format(...)");
            return StringsKt.replace$default(formatted, ' ', '0', false, 4, (Object) null);
        } catch (IOException e) {
            throw new RuntimeException("Unable to process file for MD5", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                Log.e("MD5", strClosingException, e);
            }
        }
    }
}
