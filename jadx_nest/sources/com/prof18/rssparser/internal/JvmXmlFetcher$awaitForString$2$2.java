package com.prof18.rssparser.internal;

import androidx.core.app.NotificationCompat;
import com.prof18.rssparser.exception.HttpException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* INFO: compiled from: JvmXmlFetcher.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/prof18/rssparser/internal/JvmXmlFetcher$awaitForString$2$2", "Lokhttp3/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class JvmXmlFetcher$awaitForString$2$2 implements Callback {
    final /* synthetic */ CancellableContinuation<String> $continuation;

    /* WARN: Multi-variable type inference failed */
    JvmXmlFetcher$awaitForString$2$2(CancellableContinuation<? super String> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.isSuccessful()) {
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            CancellableContinuation<String> cancellableContinuation = this.$continuation;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m3752constructorimpl(responseBodyBody.string()));
            return;
        }
        HttpException httpException = new HttpException(response.code(), response.message());
        CancellableContinuation<String> cancellableContinuation2 = this.$continuation;
        Result.Companion companion2 = Result.INSTANCE;
        cancellableContinuation2.resumeWith(Result.m3752constructorimpl(ResultKt.createFailure(httpException)));
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        CancellableContinuation<String> cancellableContinuation = this.$continuation;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m3752constructorimpl(ResultKt.createFailure(e)));
    }
}
