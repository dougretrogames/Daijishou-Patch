package com.google.common.io;

import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class TempFileCreator$JavaNioCreator$$ExternalSyntheticLambda0 implements TempFileCreator.JavaNioCreator.PermissionSupplier {
    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
    public final FileAttribute get() {
        return PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rw-------"));
    }
}
