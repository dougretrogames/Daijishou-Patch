package org.retroachivements.api.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.retroachivements.api.data.RetroCredentials;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* INFO: compiled from: CoreClient.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lorg/retroachivements/api/core/CoreClient;", "", "credentials", "Lorg/retroachivements/api/data/RetroCredentials;", "baseUrl", "", "debugging", "", "(Lorg/retroachivements/api/data/RetroCredentials;Ljava/lang/String;Z)V", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "httpClient", "Lokhttp3/OkHttpClient;", "getHttpClient", "()Lokhttp3/OkHttpClient;", "setHttpClient", "(Lokhttp3/OkHttpClient;)V", "retroClient", "Lretrofit2/Retrofit;", "getRetroClient", "()Lretrofit2/Retrofit;", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class CoreClient {
    private final Gson gson;
    private OkHttpClient httpClient;
    private final Retrofit retroClient;

    public CoreClient(RetroCredentials credentials, String baseUrl, boolean z) {
        Intrinsics.checkNotNullParameter(credentials, "credentials");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Gson gsonCreate = new GsonBuilder().registerTypeAdapterFactory(new DateFormatAdapterFactory()).create();
        this.gson = gsonCreate;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new AuthenticatorInterceptor(credentials));
        if (z) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }
        this.httpClient = builder.build();
        Retrofit retrofitBuild = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gsonCreate)).addCallAdapterFactory(new NetworkResponseAdapterFactory()).baseUrl(baseUrl).client(this.httpClient).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "build(...)");
        this.retroClient = retrofitBuild;
    }

    public /* synthetic */ CoreClient(RetroCredentials retroCredentials, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(retroCredentials, str, (i & 4) != 0 ? false : z);
    }

    public final OkHttpClient getHttpClient() {
        return this.httpClient;
    }

    public final void setHttpClient(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "<set-?>");
        this.httpClient = okHttpClient;
    }

    public final Retrofit getRetroClient() {
        return this.retroClient;
    }
}
