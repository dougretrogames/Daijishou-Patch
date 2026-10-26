package com.skydoves.balloon;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: DeferredBalloonGroup.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/skydoves/balloon/DeferredBalloonGroup;", "", "balloons", "", "Lcom/skydoves/balloon/DeferredBalloon;", "dismissSequentially", "", "<init>", "(Ljava/util/List;Z)V", "getBalloons", "()Ljava/util/List;", "getDismissSequentially", "()Z", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeferredBalloonGroup {
    private final List<DeferredBalloon> balloons;
    private final boolean dismissSequentially;

    public DeferredBalloonGroup(List<DeferredBalloon> balloons, boolean z) {
        Intrinsics.checkNotNullParameter(balloons, "balloons");
        this.balloons = balloons;
        this.dismissSequentially = z;
    }

    public final List<DeferredBalloon> getBalloons() {
        return this.balloons;
    }

    public final boolean getDismissSequentially() {
        return this.dismissSequentially;
    }
}
