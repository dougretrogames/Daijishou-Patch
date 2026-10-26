package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PackObjectSizeIndexWriter$PackObjectSizeWriterV1$$ExternalSyntheticLambda1 implements PackObjectSizeIndexWriter.PackObjectSizeWriterV1.IntEncoder {
    public final /* synthetic */ PackObjectSizeIndexWriter.PackObjectSizeWriterV1 f$0;

    public /* synthetic */ PackObjectSizeIndexWriter$PackObjectSizeWriterV1$$ExternalSyntheticLambda1(PackObjectSizeIndexWriter.PackObjectSizeWriterV1 packObjectSizeWriterV1) {
        this.f$0 = packObjectSizeWriterV1;
    }

    @Override // org.eclipse.jgit.internal.storage.file.PackObjectSizeIndexWriter.PackObjectSizeWriterV1.IntEncoder
    public final void encode(int i) throws IOException {
        this.f$0.writeInt32(i);
    }
}
