package androidx.constraintlayout.core.motion.utils;

/* INFO: loaded from: classes.dex */
public interface StopEngine {
    String debug(String str, float f);

    float getInterpolation(float f);

    float getVelocity();

    float getVelocity(float f);

    boolean isStopped();
}
