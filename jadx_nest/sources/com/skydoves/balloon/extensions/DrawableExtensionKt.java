package com.skydoves.balloon.extensions;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DrawableExtension.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0007\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\u0004\u001a1\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\f*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0000¢\u0006\u0002\u0010\u000e\u001a\u0019\u0010\u000f\u001a\u00020\u0003*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0000¢\u0006\u0002\u0010\u0010\u001a\u0019\u0010\u0011\u001a\u00020\u0003*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0000¢\u0006\u0002\u0010\u0010\u001a\u000e\u0010\u0012\u001a\u00020\u0003*\u0004\u0018\u00010\u0001H\u0000\u001a\u000e\u0010\u0013\u001a\u00020\u0003*\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0014"}, d2 = {"tint", "Landroid/graphics/drawable/Drawable;", "tintColor", "", "(Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;)Landroid/graphics/drawable/Drawable;", "resize", "context", "Landroid/content/Context;", "width", "height", "(Landroid/graphics/drawable/Drawable;Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Integer;)Landroid/graphics/drawable/Drawable;", "isExistHorizontalDrawable", "", "", "([Landroid/graphics/drawable/Drawable;)Z", "getIntrinsicHeight", "([Landroid/graphics/drawable/Drawable;)I", "getSumOfIntrinsicWidth", "getHeight", "getWidth", "balloon_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DrawableExtensionKt {
    public static final /* synthetic */ Drawable tint(Drawable drawable, Integer num) {
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        if (num != null) {
            DrawableCompat.setTintList(DrawableCompat.wrap(drawable), ColorStateList.valueOf(num.intValue()));
        }
        return drawable;
    }

    public static final /* synthetic */ Drawable resize(Drawable drawable, Context context, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (num == null || num2 == null) {
            return drawable;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(num.intValue(), num2.intValue(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, num.intValue(), num2.intValue());
        drawable.draw(canvas);
        return new BitmapDrawable(context.getResources(), bitmapCreateBitmap);
    }

    public static final /* synthetic */ boolean isExistHorizontalDrawable(Drawable[] drawableArr) {
        Intrinsics.checkNotNullParameter(drawableArr, "<this>");
        return (drawableArr[0] == null && drawableArr[2] == null) ? false : true;
    }

    public static final /* synthetic */ int getIntrinsicHeight(Drawable[] drawableArr) {
        Intrinsics.checkNotNullParameter(drawableArr, "<this>");
        return RangesKt.coerceAtLeast(getHeight(drawableArr[0]), getHeight(drawableArr[2]));
    }

    public static final /* synthetic */ int getSumOfIntrinsicWidth(Drawable[] drawableArr) {
        Intrinsics.checkNotNullParameter(drawableArr, "<this>");
        return getWidth(drawableArr[0]) + getWidth(drawableArr[2]);
    }

    public static final /* synthetic */ int getHeight(Drawable drawable) {
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return 0;
    }

    public static final /* synthetic */ int getWidth(Drawable drawable) {
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return 0;
    }
}
