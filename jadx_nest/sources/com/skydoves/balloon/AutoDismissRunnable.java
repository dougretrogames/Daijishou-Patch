package com.skydoves.balloon;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AutoDismissRunnable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/skydoves/balloon/AutoDismissRunnable;", "Ljava/lang/Runnable;", "balloon", "Lcom/skydoves/balloon/Balloon;", "<init>", "(Lcom/skydoves/balloon/Balloon;)V", "getBalloon", "()Lcom/skydoves/balloon/Balloon;", "run", "", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoDismissRunnable implements Runnable {
    private final Balloon balloon;

    public AutoDismissRunnable(Balloon balloon) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        this.balloon = balloon;
    }

    public final Balloon getBalloon() {
        return this.balloon;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.balloon.dismiss();
    }
}
