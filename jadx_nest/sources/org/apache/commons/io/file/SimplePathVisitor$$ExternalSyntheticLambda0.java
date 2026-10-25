package org.apache.commons.io.file;

import java.io.IOException;
import java.nio.file.Path;
import org.apache.commons.io.function.IOBiFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class SimplePathVisitor$$ExternalSyntheticLambda0 implements IOBiFunction {
    public final /* synthetic */ SimplePathVisitor f$0;

    public /* synthetic */ SimplePathVisitor$$ExternalSyntheticLambda0(SimplePathVisitor simplePathVisitor) {
        this.f$0 = simplePathVisitor;
    }

    @Override // org.apache.commons.io.function.IOBiFunction
    public final Object apply(Object obj, Object obj2) {
        return this.f$0.m5572lambda$new$0$orgapachecommonsiofileSimplePathVisitor((Path) obj, (IOException) obj2);
    }
}
