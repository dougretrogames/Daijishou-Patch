package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.util.GlideSuppliers;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class GlideBitmapFactory$GainmapDecoderWorkaroundStateCalculator$$ExternalSyntheticLambda0 implements GlideSuppliers.GlideSupplier {
    @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
    public final Object get() {
        return Boolean.valueOf(GlideBitmapFactory.GainmapDecoderWorkaroundStateCalculator.calculateNeedsGainmapDecodeWorkaround());
    }
}
