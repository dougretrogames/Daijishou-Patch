package com.magneticchen.daijishou.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.palette.graphics.Palette;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: PlaidColorUtils.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0004H\u0007J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u0019\u001a\u00020\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u00042\b\b\u0001\u0010\u001a\u001a\u00020\u0014H\u0007J\u001c\u0010\u0019\u001a\u00020\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u00042\b\b\u0001\u0010\u001a\u001a\u00020\u0004H\u0007J$\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u001c\u001a\u00020\u0014H\u0007J$\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u0017\u001a\u00020\u00042\b\b\u0001\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/magneticchen/daijishou/utils/PlaidColorUtils;", "", "()V", "IS_DARK", "", "IS_LIGHT", "LIGHTNESS_UNKNOWN", "getMostPopulousSwatch", "Landroidx/palette/graphics/Palette$Swatch;", "palette", "Landroidx/palette/graphics/Palette;", "getThemeColor", "context", "Landroid/content/Context;", "attrResId", "isDark", "", "bitmap", "Landroid/graphics/Bitmap;", "luminance", "", "backupPixelX", "backupPixelY", TypedValues.Custom.S_COLOR, "isDarkTheme", "modifyAlpha", "alpha", "scrimify", "lightnessMultiplier", "Lightness", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlaidColorUtils {
    public static final PlaidColorUtils INSTANCE = new PlaidColorUtils();
    public static final int IS_DARK = 1;
    public static final int IS_LIGHT = 0;
    public static final int LIGHTNESS_UNKNOWN = 2;

    /* INFO: compiled from: PlaidColorUtils.kt */
    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/magneticchen/daijishou/utils/PlaidColorUtils$Lightness;", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public @interface Lightness {
    }

    public final int modifyAlpha(int color, int alpha) {
        return (color & ViewCompat.MEASURED_SIZE_MASK) | (alpha << 24);
    }

    private PlaidColorUtils() {
    }

    public final int modifyAlpha(int color, float alpha) {
        return modifyAlpha(color, (int) (alpha * 255.0f));
    }

    public final int isDark(Palette palette, float luminance) {
        Palette.Swatch mostPopulousSwatch = getMostPopulousSwatch(palette);
        if (mostPopulousSwatch == null) {
            return 2;
        }
        return isDark(mostPopulousSwatch.getRgb(), luminance) ? 1 : 0;
    }

    private final Palette.Swatch getMostPopulousSwatch(Palette palette) {
        Palette.Swatch swatch = null;
        if (palette != null) {
            for (Palette.Swatch swatch2 : palette.getSwatches()) {
                if (swatch == null || swatch2.getPopulation() > swatch.getPopulation()) {
                    swatch = swatch2;
                }
            }
        }
        return swatch;
    }

    public final boolean isDark(Bitmap bitmap, float luminance) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return isDark(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, luminance);
    }

    public final boolean isDark(Bitmap bitmap, int backupPixelX, int backupPixelY, float luminance) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Palette paletteGenerate = Palette.from(bitmap).maximumColorCount(3).generate();
        Intrinsics.checkNotNullExpressionValue(paletteGenerate, "generate(...)");
        if (paletteGenerate.getSwatches().size() > 0) {
            return isDark(paletteGenerate, luminance) == 1;
        }
        return isDark(bitmap.getPixel(backupPixelX, backupPixelY), luminance);
    }

    public final boolean isDark(int color, float luminance) {
        return ColorUtils.calculateLuminance(color) < ((double) luminance);
    }

    public final int scrimify(int color, boolean isDark, float lightnessMultiplier) {
        float[] fArr = new float[3];
        ColorUtils.colorToHSL(color, fArr);
        fArr[2] = MathUtils.clamp(fArr[2] * (!isDark ? lightnessMultiplier + 1.0f : 1.0f - lightnessMultiplier), 0.0f, 1.0f);
        return ColorUtils.HSLToColor(fArr);
    }

    public final int scrimify(int color, float lightnessMultiplier, float luminance) {
        return scrimify(color, isDark(color, luminance), lightnessMultiplier);
    }

    public final int getThemeColor(Context context, int attrResId) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, new int[]{attrResId});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            return typedArrayObtainStyledAttributes.getColor(0, -65281);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final boolean isDarkTheme(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }
}
