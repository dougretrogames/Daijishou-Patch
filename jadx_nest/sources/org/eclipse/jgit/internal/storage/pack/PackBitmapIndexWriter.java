package org.eclipse.jgit.internal.storage.pack;

import java.io.IOException;
import org.eclipse.jgit.internal.storage.file.PackBitmapIndexBuilder;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface PackBitmapIndexWriter {
    void write(PackBitmapIndexBuilder packBitmapIndexBuilder, byte[] bArr) throws IOException;
}
