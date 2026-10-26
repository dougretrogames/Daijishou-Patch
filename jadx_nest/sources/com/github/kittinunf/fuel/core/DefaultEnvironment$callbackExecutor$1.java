package com.github.kittinunf.fuel.core;

import java.util.concurrent.Executor;
import kotlin.Metadata;

/* INFO: compiled from: Environment.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "command", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "execute"}, k = 3, mv = {1, 4, 0})
final class DefaultEnvironment$callbackExecutor$1 implements Executor {
    public static final DefaultEnvironment$callbackExecutor$1 INSTANCE = new DefaultEnvironment$callbackExecutor$1();

    DefaultEnvironment$callbackExecutor$1() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }
}
