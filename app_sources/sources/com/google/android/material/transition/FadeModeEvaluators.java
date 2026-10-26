package com.google.android.material.transition;

/* INFO: loaded from: classes3.dex */
class FadeModeEvaluators {
    private static final FadeModeEvaluator IN = new AnonymousClass1();
    private static final FadeModeEvaluator OUT = new AnonymousClass2();
    private static final FadeModeEvaluator CROSS = new AnonymousClass3();
    private static final FadeModeEvaluator THROUGH = new AnonymousClass4();

    /* INFO: renamed from: com.google.android.material.transition.FadeModeEvaluators$1, reason: invalid class name */
    class AnonymousClass1 implements FadeModeEvaluator {
        AnonymousClass1() {
        }

        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f2, f3, f));
        }
    }

    /* INFO: renamed from: com.google.android.material.transition.FadeModeEvaluators$2, reason: invalid class name */
    class AnonymousClass2 implements FadeModeEvaluator {
        AnonymousClass2() {
        }

        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f2, f3, f), 255);
        }
    }

    /* INFO: renamed from: com.google.android.material.transition.FadeModeEvaluators$3, reason: invalid class name */
    class AnonymousClass3 implements FadeModeEvaluator {
        AnonymousClass3() {
        }

        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f2, f3, f), TransitionUtils.lerp(0, 255, f2, f3, f));
        }
    }

    /* INFO: renamed from: com.google.android.material.transition.FadeModeEvaluators$4, reason: invalid class name */
    class AnonymousClass4 implements FadeModeEvaluator {
        AnonymousClass4() {
        }

        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            float f5 = ((f3 - f2) * f4) + f2;
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f2, f5, f), TransitionUtils.lerp(0, 255, f5, f3, f));
        }
    }

    static FadeModeEvaluator get(int i, boolean z) {
        if (i == 0) {
            return z ? IN : OUT;
        }
        if (i == 1) {
            return z ? OUT : IN;
        }
        if (i == 2) {
            return CROSS;
        }
        if (i == 3) {
            return THROUGH;
        }
        throw new IllegalArgumentException("Invalid fade mode: " + i);
    }

    private FadeModeEvaluators() {
    }
}
