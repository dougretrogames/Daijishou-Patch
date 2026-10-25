package com.github.kittinunf.fuel.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: FuelManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ExecutorService;", "invoke"}, k = 3, mv = {1, 4, 0})
final class FuelManager$executorService$2 extends Lambda implements Function0<ExecutorService> {
    public static final FuelManager$executorService$2 INSTANCE = new FuelManager$executorService$2();

    FuelManager$executorService$2() {
        super(0);
    }

    /* JADX INFO: renamed from: com.github.kittinunf.fuel.core.FuelManager$executorService$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: FuelManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "command", "Ljava/lang/Runnable;", "newThread"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass1 implements ThreadFactory {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(5);
            thread.setDaemon(true);
            return thread;
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public final ExecutorService invoke() {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool(AnonymousClass1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(executorServiceNewCachedThreadPool, "Executors.newCachedThrea…e\n            }\n        }");
        return executorServiceNewCachedThreadPool;
    }
}
