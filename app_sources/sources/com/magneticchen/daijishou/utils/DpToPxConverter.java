package com.magneticchen.daijishou.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DpToPxConverter.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "scale", "", "convert", "", "dp", "convertToFloat", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DpToPxConverter {
    private final Context context;
    private final float scale;

    public DpToPxConverter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.scale = context.getResources().getDisplayMetrics().density;
    }

    public final Context getContext() {
        return this.context;
    }

    public final int convert(float f) {
        return (int) ((f * this.scale) + 0.5f);
    }

    public final float convertToFloat(float f) {
        return (f * this.scale) + 0.5f;
    }
}
