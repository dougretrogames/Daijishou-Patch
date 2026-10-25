package com.skydoves.balloon.overlay;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BalloonOverlayShape.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B9\b\u0002\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u000bB\u001d\b\u0016\u0012\b\b\u0001\u0010\f\u001a\u00020\u0006\u0012\b\b\u0001\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\u000eR\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/skydoves/balloon/overlay/BalloonOverlayRoundRect;", "Lcom/skydoves/balloon/overlay/BalloonOverlayShape;", "radiusPair", "Lkotlin/Pair;", "", "radiusResPair", "", "<init>", "(Lkotlin/Pair;Lkotlin/Pair;)V", "radiusX", "radiusY", "(FF)V", "radiusXRes", "radiusYRes", "(II)V", "getRadiusPair", "()Lkotlin/Pair;", "getRadiusResPair", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BalloonOverlayRoundRect extends BalloonOverlayShape {
    private final Pair<Float, Float> radiusPair;
    private final Pair<Integer, Integer> radiusResPair;

    /* synthetic */ BalloonOverlayRoundRect(Pair pair, Pair pair2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((Pair<Float, Float>) ((i & 1) != 0 ? null : pair), (Pair<Integer, Integer>) ((i & 2) != 0 ? null : pair2));
    }

    public final Pair<Float, Float> getRadiusPair() {
        return this.radiusPair;
    }

    public final Pair<Integer, Integer> getRadiusResPair() {
        return this.radiusResPair;
    }

    private BalloonOverlayRoundRect(Pair<Float, Float> pair, Pair<Integer, Integer> pair2) {
        super(null);
        this.radiusPair = pair;
        this.radiusResPair = pair2;
    }

    public BalloonOverlayRoundRect(float f, float f2) {
        this(new Pair(Float.valueOf(f), Float.valueOf(f2)), null, 2, null);
    }

    public BalloonOverlayRoundRect(int i, int i2) {
        this(null, new Pair(Integer.valueOf(i), Integer.valueOf(i2)), 1, null);
    }
}
