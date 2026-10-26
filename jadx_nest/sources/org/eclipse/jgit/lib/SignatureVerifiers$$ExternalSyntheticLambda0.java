package org.eclipse.jgit.lib;

import java.util.function.Function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class SignatureVerifiers$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ GpgConfig.GpgFormat f$0;

    public /* synthetic */ SignatureVerifiers$$ExternalSyntheticLambda0(GpgConfig.GpgFormat gpgFormat) {
        this.f$0 = gpgFormat;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return SignatureVerifiers.lambda$0(this.f$0, (GpgConfig.GpgFormat) obj);
    }
}
