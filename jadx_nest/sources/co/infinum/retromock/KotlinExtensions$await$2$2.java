package co.infinum.retromock;

import androidx.core.app.NotificationCompat;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

/* INFO: Add missing generic type declarations: [T] */
/* INFO: compiled from: KotlinExtensions.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¨\u0006\u000b"}, d2 = {"co/infinum/retromock/KotlinExtensions$await$2$2", "Lretrofit2/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "retromock"}, k = 1, mv = {1, 1, 16})
public final class KotlinExtensions$await$2$2<T> implements Callback<T> {
    final /* synthetic */ CancellableContinuation $continuation;

    KotlinExtensions$await$2$2(CancellableContinuation cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<T> call, Response<T> response) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(response, "response");
        if (response.isSuccessful()) {
            T tBody = response.body();
            if (tBody == null) {
                KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException("Response body type was declared as non-null");
                CancellableContinuation cancellableContinuation = this.$continuation;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m3752constructorimpl(ResultKt.createFailure(kotlinNullPointerException)));
                return;
            }
            CancellableContinuation cancellableContinuation2 = this.$continuation;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m3752constructorimpl(tBody));
            return;
        }
        CancellableContinuation cancellableContinuation3 = this.$continuation;
        HttpException httpException = new HttpException(response);
        Result.Companion companion3 = Result.INSTANCE;
        cancellableContinuation3.resumeWith(Result.m3752constructorimpl(ResultKt.createFailure(httpException)));
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<T> call, Throwable t) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(t, "t");
        CancellableContinuation cancellableContinuation = this.$continuation;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m3752constructorimpl(ResultKt.createFailure(t)));
    }
}
