package com.github.kittinunf.fuel;

import com.github.kittinunf.fuel.core.FuelManager;
import com.github.kittinunf.fuel.core.Method;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.RequestFactory;
import com.github.kittinunf.fuel.core.requests.DownloadRequest;
import com.github.kittinunf.fuel.core.requests.UploadRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: Fuel.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2$\b\u0002\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001J7\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00102$\b\u0002\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001JA\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172$\b\u0002\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001JA\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00172$\b\u0002\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001J7\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2$\b\u0002\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001J7\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00102$\b\u0002\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001J7\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2$\b\u0002\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001J7\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00102$\b\u0002\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001J7\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2$\b\u0002\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001J7\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00102$\b\u0002\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001J7\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2$\b\u0002\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001J7\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00102$\b\u0002\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001J7\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2$\b\u0002\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001J7\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00102$\b\u0002\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001J=\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\"\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001J=\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00102\"\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u001eH\u0096\u0001J\u0006\u0010\u001f\u001a\u00020 J\u0014\u0010\u0003\u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100#JA\u0010$\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172$\b\u0002\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001JA\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00172$\b\u0002\u0010\r\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012H\u0096\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006&"}, d2 = {"Lcom/github/kittinunf/fuel/Fuel;", "Lcom/github/kittinunf/fuel/core/RequestFactory$Convenience;", "()V", "trace", "", "getTrace", "()Z", "setTrace", "(Z)V", "delete", "Lcom/github/kittinunf/fuel/core/Request;", "convertible", "Lcom/github/kittinunf/fuel/core/RequestFactory$PathStringConvertible;", "parameters", "", "Lkotlin/Pair;", "", "", "Lcom/github/kittinunf/fuel/core/Parameters;", "path", "download", "Lcom/github/kittinunf/fuel/core/requests/DownloadRequest;", "method", "Lcom/github/kittinunf/fuel/core/Method;", "get", "head", "patch", "post", "put", "request", "Lcom/github/kittinunf/fuel/core/RequestFactory$RequestConvertible;", "reset", "Lcom/github/kittinunf/fuel/core/FuelManager;", "", "function", "Lkotlin/Function0;", "upload", "Lcom/github/kittinunf/fuel/core/requests/UploadRequest;", "fuel"}, k = 1, mv = {1, 4, 0})
public final class Fuel implements RequestFactory.Convenience {
    public static final Fuel INSTANCE = new Fuel();
    private static boolean trace;
    private final /* synthetic */ FuelManager $$delegate_0 = FuelManager.INSTANCE.getInstance();

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request delete(RequestFactory.PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        return this.$$delegate_0.delete(convertible, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request delete(String path, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.$$delegate_0.delete(path, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public DownloadRequest download(RequestFactory.PathStringConvertible convertible, Method method, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        Intrinsics.checkNotNullParameter(method, "method");
        return this.$$delegate_0.download(convertible, method, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public DownloadRequest download(String path, Method method, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(method, "method");
        return this.$$delegate_0.download(path, method, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request get(RequestFactory.PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        return this.$$delegate_0.get(convertible, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request get(String path, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.$$delegate_0.get(path, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request head(RequestFactory.PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        return this.$$delegate_0.head(convertible, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request head(String path, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.$$delegate_0.head(path, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request patch(RequestFactory.PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        return this.$$delegate_0.patch(convertible, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request patch(String path, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.$$delegate_0.patch(path, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request post(RequestFactory.PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        return this.$$delegate_0.post(convertible, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request post(String path, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.$$delegate_0.post(path, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request put(RequestFactory.PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        return this.$$delegate_0.put(convertible, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public Request put(String path, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.$$delegate_0.put(path, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory
    public Request request(Method method, RequestFactory.PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        return this.$$delegate_0.request(method, convertible, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory
    public Request request(Method method, String path, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(path, "path");
        return this.$$delegate_0.request(method, path, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory
    public Request request(RequestFactory.RequestConvertible convertible) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        return this.$$delegate_0.request(convertible);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public UploadRequest upload(RequestFactory.PathStringConvertible convertible, Method method, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(convertible, "convertible");
        Intrinsics.checkNotNullParameter(method, "method");
        return this.$$delegate_0.upload(convertible, method, parameters);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.Convenience
    public UploadRequest upload(String path, Method method, List<? extends Pair<String, ? extends Object>> parameters) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(method, "method");
        return this.$$delegate_0.upload(path, method, parameters);
    }

    private Fuel() {
    }

    public final boolean getTrace() {
        return trace;
    }

    public final void setTrace(boolean z) {
        trace = z;
    }

    public final void trace(Function0<String> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        if (trace) {
            System.out.println((Object) function.invoke());
        }
    }

    public final FuelManager reset() {
        return FuelManager.INSTANCE.getInstance().reset();
    }
}
