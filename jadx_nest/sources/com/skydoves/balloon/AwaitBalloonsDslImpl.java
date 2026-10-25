package com.skydoves.balloon;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwaitBalloons.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0017\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J$\u0010\u0018\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J$\u0010\u0019\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J$\u0010\u001a\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J$\u0010\u001b\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0006\u0010\u001c\u001a\u00020\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/skydoves/balloon/AwaitBalloonsDslImpl;", "Lcom/skydoves/balloon/AwaitBalloonsDsl;", "<init>", "()V", "dismissSequentially", "", "getDismissSequentially", "()Z", "setDismissSequentially", "(Z)V", "_balloons", "", "Lcom/skydoves/balloon/DeferredBalloon;", "atCenter", "", "Lcom/skydoves/balloon/Balloon;", "anchor", "Landroid/view/View;", "xOff", "", "yOff", "centerAlign", "Lcom/skydoves/balloon/BalloonCenterAlign;", "asDropDown", "alignTop", "alignStart", "alignEnd", "alignBottom", "build", "Lcom/skydoves/balloon/DeferredBalloonGroup;", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AwaitBalloonsDslImpl implements AwaitBalloonsDsl {
    private final List<DeferredBalloon> _balloons = new ArrayList();
    private boolean dismissSequentially;

    @Override // com.skydoves.balloon.AwaitBalloonsDsl
    public void alignBottom(View view, Balloon balloon, int i, int i2) {
        AwaitBalloonsDsl.DefaultImpls.alignBottom(this, view, balloon, i, i2);
    }

    @Override // com.skydoves.balloon.AwaitBalloonsDsl
    public void alignEnd(View view, Balloon balloon, int i, int i2) {
        AwaitBalloonsDsl.DefaultImpls.alignEnd(this, view, balloon, i, i2);
    }

    @Override // com.skydoves.balloon.AwaitBalloonsDsl
    public void alignStart(View view, Balloon balloon, int i, int i2) {
        AwaitBalloonsDsl.DefaultImpls.alignStart(this, view, balloon, i, i2);
    }

    @Override // com.skydoves.balloon.AwaitBalloonsDsl
    public void alignTop(View view, Balloon balloon, int i, int i2) {
        AwaitBalloonsDsl.DefaultImpls.alignTop(this, view, balloon, i, i2);
    }

    @Override // com.skydoves.balloon.AwaitBalloonsDsl
    public void asDropDown(View view, Balloon balloon, int i, int i2) {
        AwaitBalloonsDsl.DefaultImpls.asDropDown(this, view, balloon, i, i2);
    }

    @Override // com.skydoves.balloon.AwaitBalloonsDsl
    public void atCenter(View view, Balloon balloon, int i, int i2, BalloonCenterAlign balloonCenterAlign) {
        AwaitBalloonsDsl.DefaultImpls.atCenter(this, view, balloon, i, i2, balloonCenterAlign);
    }

    @Override // com.skydoves.balloon.AwaitBalloonsDsl
    public boolean getDismissSequentially() {
        return this.dismissSequentially;
    }

    @Override // com.skydoves.balloon.AwaitBalloonsDsl
    public void setDismissSequentially(boolean z) {
        this.dismissSequentially = z;
    }

    @Override // com.skydoves.balloon.AwaitBalloonsDsl
    public void atCenter(Balloon balloon, View anchor, int i, int i2, BalloonCenterAlign centerAlign) {
        Intrinsics.checkNotNullParameter(balloon, "<this>");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(centerAlign, "centerAlign");
        this._balloons.add(new DeferredBalloon(balloon, new BalloonPlacement(anchor, null, centerAlign.toAlign(), i, i2, PlacementType.CENTER, 0, 0, 194, null)));
    }

    @Override // com.skydoves.balloon.AwaitBalloonsDsl
    public void asDropDown(Balloon balloon, View anchor, int i, int i2) {
        Intrinsics.checkNotNullParameter(balloon, "<this>");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        this._balloons.add(new DeferredBalloon(balloon, new BalloonPlacement(anchor, null, null, i, i2, PlacementType.DROPDOWN, 0, 0, 198, null)));
    }

    @Override // com.skydoves.balloon.AwaitBalloonsDsl
    public void alignTop(Balloon balloon, View anchor, int i, int i2) {
        Intrinsics.checkNotNullParameter(balloon, "<this>");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        this._balloons.add(new DeferredBalloon(balloon, new BalloonPlacement(anchor, null, BalloonAlign.TOP, i, i2, null, 0, 0, 226, null)));
    }

    @Override // com.skydoves.balloon.AwaitBalloonsDsl
    public void alignStart(Balloon balloon, View anchor, int i, int i2) {
        Intrinsics.checkNotNullParameter(balloon, "<this>");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        this._balloons.add(new DeferredBalloon(balloon, new BalloonPlacement(anchor, null, BalloonAlign.START, i, i2, null, 0, 0, 226, null)));
    }

    @Override // com.skydoves.balloon.AwaitBalloonsDsl
    public void alignEnd(Balloon balloon, View anchor, int i, int i2) {
        Intrinsics.checkNotNullParameter(balloon, "<this>");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        this._balloons.add(new DeferredBalloon(balloon, new BalloonPlacement(anchor, null, BalloonAlign.END, i, i2, null, 0, 0, 226, null)));
    }

    @Override // com.skydoves.balloon.AwaitBalloonsDsl
    public void alignBottom(Balloon balloon, View anchor, int i, int i2) {
        Intrinsics.checkNotNullParameter(balloon, "<this>");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        this._balloons.add(new DeferredBalloon(balloon, new BalloonPlacement(anchor, null, BalloonAlign.BOTTOM, i, i2, null, 0, 0, 226, null)));
    }

    public final DeferredBalloonGroup build() {
        return new DeferredBalloonGroup(this._balloons, getDismissSequentially());
    }
}
