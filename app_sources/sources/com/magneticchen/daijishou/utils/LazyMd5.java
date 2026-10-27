package com.magneticchen.daijishou.utils;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/* JADX INFO: compiled from: LazyMd5.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/utils/LazyMd5;", "", "()V", "md5Hex", "", "inputStream", "Ljava/io/InputStream;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LazyMd5 {
    public static final LazyMd5 INSTANCE = new LazyMd5();

    private LazyMd5() {
    }

    public final String md5Hex(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        char[] cArrEncodeHex = Hex.encodeHex(DigestUtils.md5(new BoundedInputStream(inputStream, 4194304L)));
        Intrinsics.checkNotNullExpressionValue(cArrEncodeHex, "encodeHex(...)");
        return new String(cArrEncodeHex);
    }
}
