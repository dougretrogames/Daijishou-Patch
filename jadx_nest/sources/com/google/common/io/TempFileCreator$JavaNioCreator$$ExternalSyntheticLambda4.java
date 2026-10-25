package com.google.common.io;

import java.io.IOException;
import java.nio.file.attribute.FileAttribute;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda4 implements TempFileCreator.JavaNioCreator.PermissionSupplier {
    public final /* synthetic */ IOException f$0;

    public /* synthetic */ TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda4(IOException iOException) {
        this.f$0 = iOException;
    }

    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
    public final FileAttribute get() {
        return TempFileCreator.JavaNioCreator.lambda$userPermissions$4(this.f$0);
    }
}
