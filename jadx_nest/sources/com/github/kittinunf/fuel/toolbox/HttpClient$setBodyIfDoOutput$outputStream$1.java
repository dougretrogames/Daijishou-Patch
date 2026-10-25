package com.github.kittinunf.fuel.toolbox;

import com.github.kittinunf.fuel.core.Progress;
import com.github.kittinunf.fuel.core.Request;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: HttpClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "writtenBytes", "", "invoke"}, k = 3, mv = {1, 4, 0})
final class HttpClient$setBodyIfDoOutput$outputStream$1 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ HttpURLConnection $connection;
    final /* synthetic */ Request $request;
    final /* synthetic */ Long $totalBytes;
    final /* synthetic */ HttpClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpClient$setBodyIfDoOutput$outputStream$1(HttpClient httpClient, Request request, Long l, HttpURLConnection httpURLConnection) {
        super(1);
        this.this$0 = httpClient;
        this.$request = request;
        this.$totalBytes = l;
        this.$connection = httpURLConnection;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) throws InterruptedException {
        invoke(l.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) throws InterruptedException {
        Progress requestProgress = this.$request.getExecutionOptions().getRequestProgress();
        Long l = this.$totalBytes;
        requestProgress.invoke(j, l != null ? l.longValue() : j);
        this.this$0.ensureRequestActive(this.$request, this.$connection);
    }
}
