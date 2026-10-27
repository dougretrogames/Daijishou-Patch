package com.magneticchen.daijishou.ui.observer;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OrientationObserver.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/magneticchen/daijishou/ui/observer/OrientationObserver;", "Landroid/content/ComponentCallbacks;", "context", "Landroid/content/Context;", "onChanged", "Lkotlin/Function1;", "", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OrientationObserver implements ComponentCallbacks {
    private final Context context;
    private final Function1<Integer, Unit> onChanged;

    @Override // android.content.ComponentCallbacks
    @Deprecated(message = "Deprecated in Java")
    public void onLowMemory() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OrientationObserver(Context context, Function1<? super Integer, Unit> onChanged) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onChanged, "onChanged");
        this.context = context;
        this.onChanged = onChanged;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        this.onChanged.invoke(Integer.valueOf(newConfig.orientation));
    }
}
