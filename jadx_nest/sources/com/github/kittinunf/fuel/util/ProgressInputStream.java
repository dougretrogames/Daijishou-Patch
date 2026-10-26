package com.github.kittinunf.fuel.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: ProgressInputStream.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\"\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0016R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/github/kittinunf/fuel/util/ProgressInputStream;", "Ljava/io/FilterInputStream;", "stream", "Ljava/io/InputStream;", "onProgress", "Lkotlin/Function1;", "", "", "Lcom/github/kittinunf/fuel/util/ReadProgress;", "(Ljava/io/InputStream;Lkotlin/jvm/functions/Function1;)V", "markedPosition", "getOnProgress", "()Lkotlin/jvm/functions/Function1;", "position", "mark", "readlimit", "", "read", "b", "", "off", "len", "reset", "skip", "n", "fuel"}, k = 1, mv = {1, 4, 0})
public final class ProgressInputStream extends FilterInputStream {
    private long markedPosition;
    private final Function1<Long, Unit> onProgress;
    private long position;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* WARN: Multi-variable type inference failed */
    public ProgressInputStream(InputStream stream, Function1<? super Long, Unit> onProgress) {
        super(stream);
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(onProgress, "onProgress");
        this.onProgress = onProgress;
        this.markedPosition = -1L;
    }

    public final Function1<Long, Unit> getOnProgress() {
        return this.onProgress;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int readlimit) {
        super.mark(readlimit);
        this.markedPosition = this.position;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.position = this.markedPosition;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long n) {
        return super.skip(n);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        int i = super.read(b, off, len);
        long jMax = this.position + ((long) Math.max(i, 0));
        this.position = jMax;
        this.onProgress.invoke(Long.valueOf(jMax));
        return i;
    }
}
