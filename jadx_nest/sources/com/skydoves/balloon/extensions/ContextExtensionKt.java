package com.skydoves.balloon.extensions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: ContextExtension.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0000\u001a\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0000¨\u0006\f"}, d2 = {"px2Sp", "", "Landroid/content/Context;", "px", "dimenPixel", "", "dimenRes", "dimen", "contextColor", "resource", "contextDrawable", "Landroid/graphics/drawable/Drawable;", "balloon_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContextExtensionKt {
    public static final /* synthetic */ float px2Sp(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return f / context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static final /* synthetic */ int dimenPixel(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getDimensionPixelSize(i);
    }

    public static final /* synthetic */ float dimen(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getDimension(i);
    }

    public static final /* synthetic */ int contextColor(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return ContextCompat.getColor(context, i);
    }

    public static final /* synthetic */ Drawable contextDrawable(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return AppCompatResources.getDrawable(context, i);
    }
}
