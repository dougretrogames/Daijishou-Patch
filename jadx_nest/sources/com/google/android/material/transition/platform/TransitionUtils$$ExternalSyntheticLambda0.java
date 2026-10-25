package com.google.android.material.transition.platform;

import android.graphics.RectF;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class TransitionUtils$$ExternalSyntheticLambda0 implements ShapeAppearanceModel.CornerSizeUnaryOperator {
    public final /* synthetic */ RectF f$0;

    public /* synthetic */ TransitionUtils$$ExternalSyntheticLambda0(RectF rectF) {
        this.f$0 = rectF;
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
    public final CornerSize apply(CornerSize cornerSize) {
        return RelativeCornerSize.createFromCornerSize(this.f$0, cornerSize);
    }
}
