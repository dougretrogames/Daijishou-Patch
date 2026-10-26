package com.skydoves.balloon.extensions;

import android.content.res.Resources;
import android.graphics.Point;
import kotlin.Metadata;

/* INFO: compiled from: SizeExtension.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00018À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0000\u001a\u00020\u0004*\u00020\u00048À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\"\u0015\u0010\u0006\u001a\u00020\u00078À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"dp", "", "getDp", "(I)I", "", "(F)F", "displaySize", "Landroid/graphics/Point;", "getDisplaySize", "()Landroid/graphics/Point;", "balloon_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SizeExtensionKt {
    public static final /* synthetic */ Point getDisplaySize() {
        return new Point(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels);
    }
}
