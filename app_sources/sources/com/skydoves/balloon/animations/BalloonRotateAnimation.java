package com.skydoves.balloon.animations;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.magneticchen.daijishou.application_data.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: BalloonRotateAnimation.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/skydoves/balloon/animations/BalloonRotateAnimation;", "Landroid/view/animation/Animation;", "builder", "Lcom/skydoves/balloon/animations/BalloonRotateAnimation$Builder;", "<init>", "(Lcom/skydoves/balloon/animations/BalloonRotateAnimation$Builder;)V", "degreeX", "", "degreeY", "degreeZ", "width", "height", "initialize", "", "", "parentWidth", "parentHeight", "applyTransformation", "interpolatedTime", "transformation", "Landroid/view/animation/Transformation;", "Builder", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BalloonRotateAnimation extends Animation {
    private final float degreeX;
    private final float degreeY;
    private final float degreeZ;
    private float height;
    private float width;

    public /* synthetic */ BalloonRotateAnimation(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private BalloonRotateAnimation(Builder builder) {
        this.degreeX = builder.degreeX;
        this.degreeY = builder.turns * Constants.downloadedBoxArtImagesShortEdgeBase * builder.direction.getValue();
        this.degreeZ = builder.degreeZ;
        setDuration(builder.speeds);
        setRepeatCount(builder.loops != -1 ? builder.loops - 1 : -1);
    }

    @Override // android.view.animation.Animation
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        this.width = width * 0.5f;
        this.height = height * 0.5f;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        Intrinsics.checkNotNullParameter(transformation, "transformation");
        float f = this.degreeX * interpolatedTime;
        float f2 = this.degreeY * interpolatedTime;
        float f3 = this.degreeZ * interpolatedTime;
        Matrix matrix = transformation.getMatrix();
        Camera camera = new Camera();
        camera.save();
        camera.rotateX(f);
        camera.rotateY(f2);
        camera.rotateZ(f3);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-this.width, -this.height);
        matrix.postTranslate(this.width, this.height);
    }

    /* INFO: compiled from: BalloonRotateAnimation.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0017R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/skydoves/balloon/animations/BalloonRotateAnimation$Builder;", "", "<init>", "()V", "direction", "Lcom/skydoves/balloon/animations/BalloonRotateDirection;", "turns", "", "loops", "speeds", "degreeX", "degreeZ", "setDirection", "rotateDirection", "setTurns", "turn", "setLoops", "loop", "setSpeeds", "speed", "setDegreeX", "setDegreeZ", "build", "Lcom/skydoves/balloon/animations/BalloonRotateAnimation;", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        public int degreeX;
        public int degreeZ;
        public BalloonRotateDirection direction = BalloonRotateDirection.RIGHT;
        public int turns = 1;
        public int loops = -1;
        public int speeds = 2500;

        public final Builder setDirection(BalloonRotateDirection rotateDirection) {
            Intrinsics.checkNotNullParameter(rotateDirection, "rotateDirection");
            this.direction = rotateDirection;
            return this;
        }

        public final Builder setTurns(int turn) {
            this.turns = turn;
            return this;
        }

        public final Builder setLoops(int loop) {
            this.loops = loop;
            return this;
        }

        public final Builder setSpeeds(int speed) {
            this.speeds = speed;
            return this;
        }

        public final Builder setDegreeX(int degreeX) {
            this.degreeX = degreeX;
            return this;
        }

        public final Builder setDegreeZ(int degreeZ) {
            this.degreeZ = degreeZ;
            return this;
        }

        public final BalloonRotateAnimation build() {
            return new BalloonRotateAnimation(this, null);
        }
    }
}
