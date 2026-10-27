package com.magneticchen.daijishou.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScaledBitmapLoader.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¨\u0006\r"}, d2 = {"Lcom/magneticchen/daijishou/utils/ScaledBitmapLoader;", "", "()V", "calculateInSampleSize", "", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "decodeSampledBitmapFromFile", "Landroid/graphics/Bitmap;", "filePath", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScaledBitmapLoader {
    public static final ScaledBitmapLoader INSTANCE = new ScaledBitmapLoader();

    private ScaledBitmapLoader() {
    }

    private final int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        Pair pair = TuplesKt.to(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
        int iIntValue = ((Number) pair.component1()).intValue();
        int iIntValue2 = ((Number) pair.component2()).intValue();
        int i3 = 1;
        if (iIntValue <= i2 && iIntValue2 <= i) {
            return 1;
        }
        int i4 = iIntValue / 2;
        int i5 = iIntValue2 / 2;
        while (i4 / i3 >= i2 && i5 / i3 >= i) {
            i3 *= 2;
        }
        return i3;
    }

    public final Bitmap decodeSampledBitmapFromFile(String filePath, int i, int i2) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        options.inSampleSize = INSTANCE.calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(filePath, options);
        Intrinsics.checkNotNullExpressionValue(bitmapDecodeFile, "run(...)");
        return bitmapDecodeFile;
    }
}
