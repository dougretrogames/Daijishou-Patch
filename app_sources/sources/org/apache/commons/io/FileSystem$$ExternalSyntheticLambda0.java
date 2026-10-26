package org.apache.commons.io;

import java.util.function.IntUnaryOperator;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileSystem$$ExternalSyntheticLambda0 implements IntUnaryOperator {
    public final /* synthetic */ FileSystem f$0;
    public final /* synthetic */ char f$1;

    public /* synthetic */ FileSystem$$ExternalSyntheticLambda0(FileSystem fileSystem, char c) {
        this.f$0 = fileSystem;
        this.f$1 = c;
    }

    @Override // java.util.function.IntUnaryOperator
    public final int applyAsInt(int i) {
        return this.f$0.m5550lambda$toLegalFileName$0$orgapachecommonsioFileSystem(this.f$1, i);
    }
}
