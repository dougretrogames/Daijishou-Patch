package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OkHttpClient.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "intercept"}, k = 3, mv = {1, 8, 0}, xi = 176)
public final class OkHttpClient$Builder$addInterceptor$2 implements Interceptor {
    final /* synthetic */ Function1<Interceptor.Chain, Response> $block;

    /* JADX WARN: Multi-variable type inference failed */
    public OkHttpClient$Builder$addInterceptor$2(Function1<? super Interceptor.Chain, Response> function1) {
        this.$block = function1;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return this.$block.invoke(chain);
    }
}
