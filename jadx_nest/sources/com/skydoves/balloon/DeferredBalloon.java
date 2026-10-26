package com.skydoves.balloon;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: DeferredBalloon.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/skydoves/balloon/DeferredBalloon;", "", "balloon", "Lcom/skydoves/balloon/Balloon;", "placement", "Lcom/skydoves/balloon/BalloonPlacement;", "<init>", "(Lcom/skydoves/balloon/Balloon;Lcom/skydoves/balloon/BalloonPlacement;)V", "getBalloon", "()Lcom/skydoves/balloon/Balloon;", "getPlacement", "()Lcom/skydoves/balloon/BalloonPlacement;", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DeferredBalloon {
    private final Balloon balloon;
    private final BalloonPlacement placement;

    public static /* synthetic */ DeferredBalloon copy$default(DeferredBalloon deferredBalloon, Balloon balloon, BalloonPlacement balloonPlacement, int i, Object obj) {
        if ((i & 1) != 0) {
            balloon = deferredBalloon.balloon;
        }
        if ((i & 2) != 0) {
            balloonPlacement = deferredBalloon.placement;
        }
        return deferredBalloon.copy(balloon, balloonPlacement);
    }

    /* INFO: renamed from: component1, reason: from getter */
    public final Balloon getBalloon() {
        return this.balloon;
    }

    /* INFO: renamed from: component2, reason: from getter */
    public final BalloonPlacement getPlacement() {
        return this.placement;
    }

    public final DeferredBalloon copy(Balloon balloon, BalloonPlacement placement) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(placement, "placement");
        return new DeferredBalloon(balloon, placement);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeferredBalloon)) {
            return false;
        }
        DeferredBalloon deferredBalloon = (DeferredBalloon) other;
        return Intrinsics.areEqual(this.balloon, deferredBalloon.balloon) && Intrinsics.areEqual(this.placement, deferredBalloon.placement);
    }

    public int hashCode() {
        return (this.balloon.hashCode() * 31) + this.placement.hashCode();
    }

    public String toString() {
        return "DeferredBalloon(balloon=" + this.balloon + ", placement=" + this.placement + ")";
    }

    public DeferredBalloon(Balloon balloon, BalloonPlacement placement) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.balloon = balloon;
        this.placement = placement;
    }

    public final Balloon getBalloon() {
        return this.balloon;
    }

    public final BalloonPlacement getPlacement() {
        return this.placement;
    }
}
