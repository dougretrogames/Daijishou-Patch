package com.magneticchen.daijishou.activities.abstract_classes;

import android.app.Application;
import com.magneticchen.daijishou.DaijishouApplication;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: DaijishouAppCompatActivity.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;", "Lcom/magneticchen/daijishou/DaijishouApplication;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DaijishouAppCompatActivity$logger$2 extends Lambda<DaijishouApplication.WrappedLogger> implements Function0<DaijishouApplication.WrappedLogger> {
    final /* synthetic */ DaijishouAppCompatActivity this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DaijishouAppCompatActivity$logger$2(DaijishouAppCompatActivity daijishouAppCompatActivity) {
        super(0);
        this.this$0 = daijishouAppCompatActivity;
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final DaijishouApplication.WrappedLogger invoke() {
        Application application = this.this$0.getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        return ((DaijishouApplication) application).getLogger();
    }
}
