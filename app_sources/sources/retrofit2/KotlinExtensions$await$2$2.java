package retrofit2;

import androidx.core.app.NotificationCompat;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.apache.commons.io.FilenameUtils;

/* INFO: Add missing generic type declarations: [T] */
/* INFO: compiled from: KotlinExtensions.kt */
/* INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¨\u0006\u000b"}, d2 = {"retrofit2/KotlinExtensions$await$2$2", "Lretrofit2/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "retrofit"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class KotlinExtensions$await$2$2<T> implements Callback<T> {
    final /* synthetic */ CancellableContinuation<T> $continuation;

    /* WARN: Multi-variable type inference failed */
    KotlinExtensions$await$2$2(CancellableContinuation<? super T> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<T> call, Response<T> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.isSuccessful()) {
            T tBody = response.body();
            if (tBody == null) {
                Object objTag = call.request().tag(Invocation.class);
                Intrinsics.checkNotNull(objTag);
                Invocation invocation = (Invocation) objTag;
                KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException("Response from " + invocation.service().getName() + FilenameUtils.EXTENSION_SEPARATOR + invocation.method().getName() + " was null but response body type was declared as non-null");
                CancellableContinuation<T> cancellableContinuation = this.$continuation;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3752constructorimpl(ResultKt.createFailure(kotlinNullPointerException)));
                return;
            }
            CancellableContinuation<T> cancellableContinuation2 = this.$continuation;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m3752constructorimpl(tBody));
            return;
        }
        CancellableContinuation<T> cancellableContinuation3 = this.$continuation;
        Result.Companion companion3 = Result.INSTANCE;
        cancellableContinuation3.resumeWith(Result.m3752constructorimpl(ResultKt.createFailure(new HttpException(response))));
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<T> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        CancellableContinuation<T> cancellableContinuation = this.$continuation;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m3752constructorimpl(ResultKt.createFailure(t)));
    }
}
