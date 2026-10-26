package com.github.kittinunf.fuel.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: ProgressOutputStream.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b¢\u0006\u0002\u0010\tJ\"\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/github/kittinunf/fuel/util/ProgressOutputStream;", "Ljava/io/FilterOutputStream;", "stream", "Ljava/io/OutputStream;", "onProgress", "Lkotlin/Function1;", "", "", "Lcom/github/kittinunf/fuel/util/WriteProgress;", "(Ljava/io/OutputStream;Lkotlin/jvm/functions/Function1;)V", "getOnProgress", "()Lkotlin/jvm/functions/Function1;", "position", "getPosition", "()J", "setPosition", "(J)V", "write", "b", "", "off", "", "len", "fuel"}, k = 1, mv = {1, 4, 0})
public final class ProgressOutputStream extends FilterOutputStream {
    private final Function1<Long, Unit> onProgress;
    private long position;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* WARN: Multi-variable type inference failed */
    public ProgressOutputStream(OutputStream stream, Function1<? super Long, Unit> onProgress) {
        super(stream);
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(onProgress, "onProgress");
        this.onProgress = onProgress;
    }

    public final Function1<Long, Unit> getOnProgress() {
        return this.onProgress;
    }

    public final long getPosition() {
        return this.position;
    }

    public final void setPosition(long j) {
        this.position = j;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b, off, len);
        long j = this.position + ((long) len);
        this.position = j;
        this.onProgress.invoke(Long.valueOf(j));
    }
}
