package org.eclipse.jgit.lib;

import java.util.function.Function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class Signers$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ GpgConfig.GpgFormat f$0;

    public /* synthetic */ Signers$$ExternalSyntheticLambda0(GpgConfig.GpgFormat gpgFormat) {
        this.f$0 = gpgFormat;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return Signers.lambda$0(this.f$0, (GpgConfig.GpgFormat) obj);
    }
}
