package com.github.kittinunf.fuel.android.util;

import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidEnvironment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "command", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "execute"}, k = 3, mv = {1, 4, 0})
final class AndroidEnvironment$callbackExecutor$1 implements Executor {
    final /* synthetic */ AndroidEnvironment this$0;

    AndroidEnvironment$callbackExecutor$1(AndroidEnvironment androidEnvironment) {
        this.this$0 = androidEnvironment;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.this$0.getHandler().post(runnable);
    }
}
