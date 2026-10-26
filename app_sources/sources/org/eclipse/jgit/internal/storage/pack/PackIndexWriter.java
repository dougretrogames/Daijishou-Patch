package org.eclipse.jgit.internal.storage.pack;

import java.io.IOException;
import java.util.List;
import org.eclipse.jgit.transport.PackedObjectInfo;

/* INFO: loaded from: classes5.dex */
public interface PackIndexWriter {
    void write(List<? extends PackedObjectInfo> list, byte[] bArr) throws IOException;
}
