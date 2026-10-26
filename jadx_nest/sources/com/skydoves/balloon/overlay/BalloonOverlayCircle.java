package com.skydoves.balloon.overlay;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* INFO: compiled from: BalloonOverlayShape.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B!\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bB\u0013\b\u0016\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/skydoves/balloon/overlay/BalloonOverlayCircle;", "Lcom/skydoves/balloon/overlay/BalloonOverlayShape;", "radius", "", "radiusRes", "", "<init>", "(Ljava/lang/Float;Ljava/lang/Integer;)V", "(F)V", "(I)V", "getRadius", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getRadiusRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BalloonOverlayCircle extends BalloonOverlayShape {
    private final Float radius;
    private final Integer radiusRes;

    /* synthetic */ BalloonOverlayCircle(Float f, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : f, (i & 2) != 0 ? null : num);
    }

    public final Float getRadius() {
        return this.radius;
    }

    public final Integer getRadiusRes() {
        return this.radiusRes;
    }

    private BalloonOverlayCircle(Float f, Integer num) {
        super(null);
        this.radius = f;
        this.radiusRes = num;
    }

    public BalloonOverlayCircle(float f) {
        this(Float.valueOf(f), null);
    }

    public BalloonOverlayCircle(int i) {
        this(null, Integer.valueOf(i));
    }
}
