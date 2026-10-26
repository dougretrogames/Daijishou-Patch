package com.github.kittinunf.fuel;

import com.github.kittinunf.fuel.core.Method;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.RequestFactory;
import com.github.kittinunf.fuel.core.requests.DownloadRequest;
import com.github.kittinunf.fuel.core.requests.UploadRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: Fuel.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022$\b\u0002\u0010\u0003\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\b\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00062$\b\u0002\u0010\t\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\b\u001a:\u0010\n\u001a\u00020\u000b*\u00020\u00022$\b\u0002\u0010\t\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\b2\b\b\u0002\u0010\f\u001a\u00020\r\u001a:\u0010\n\u001a\u00020\u000b*\u00020\u00062$\b\u0002\u0010\u0003\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\b2\b\b\u0002\u0010\f\u001a\u00020\r\u001a0\u0010\u000e\u001a\u00020\u0001*\u00020\u00022$\b\u0002\u0010\u0003\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\b\u001a0\u0010\u000e\u001a\u00020\u0001*\u00020\u00062$\b\u0002\u0010\t\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\b\u001a0\u0010\u000f\u001a\u00020\u0001*\u00020\u00022$\b\u0002\u0010\t\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\b\u001a0\u0010\u000f\u001a\u00020\u0001*\u00020\u00062$\b\u0002\u0010\t\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\b\u001a0\u0010\u0010\u001a\u00020\u0001*\u00020\u00022$\b\u0002\u0010\u0003\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\b\u001a0\u0010\u0010\u001a\u00020\u0001*\u00020\u00062$\b\u0002\u0010\t\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\b\u001a0\u0010\u0011\u001a\u00020\u0001*\u00020\u00022$\b\u0002\u0010\t\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\b\u001a0\u0010\u0011\u001a\u00020\u0001*\u00020\u00062$\b\u0002\u0010\t\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\b\u001a0\u0010\u0012\u001a\u00020\u0001*\u00020\u00022$\b\u0002\u0010\u0003\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\b\u001a0\u0010\u0012\u001a\u00020\u0001*\u00020\u00062$\b\u0002\u0010\t\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\b\u001a:\u0010\u0013\u001a\u00020\u0014*\u00020\u00022$\b\u0002\u0010\t\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\b2\b\b\u0002\u0010\f\u001a\u00020\r\u001a:\u0010\u0013\u001a\u00020\u0014*\u00020\u00062$\b\u0002\u0010\t\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0004j\u0004\u0018\u0001`\b2\b\b\u0002\u0010\f\u001a\u00020\r¨\u0006\u0015"}, d2 = {"httpDelete", "Lcom/github/kittinunf/fuel/core/Request;", "Lcom/github/kittinunf/fuel/core/RequestFactory$PathStringConvertible;", "parameter", "", "Lkotlin/Pair;", "", "", "Lcom/github/kittinunf/fuel/core/Parameters;", "parameters", "httpDownload", "Lcom/github/kittinunf/fuel/core/requests/DownloadRequest;", "method", "Lcom/github/kittinunf/fuel/core/Method;", "httpGet", "httpHead", "httpPatch", "httpPost", "httpPut", "httpUpload", "Lcom/github/kittinunf/fuel/core/requests/UploadRequest;", "fuel"}, k = 2, mv = {1, 4, 0})
public final class FuelKt {
    public static /* synthetic */ Request httpGet$default(String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return httpGet(str, (List<? extends Pair<String, ? extends Object>>) list);
    }

    public static final Request httpGet(String httpGet, List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(httpGet, "$this$httpGet");
        return Fuel.INSTANCE.get(httpGet, list);
    }

    public static /* synthetic */ Request httpGet$default(RequestFactory.PathStringConvertible pathStringConvertible, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return httpGet(pathStringConvertible, (List<? extends Pair<String, ? extends Object>>) list);
    }

    public static final Request httpGet(RequestFactory.PathStringConvertible httpGet, List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(httpGet, "$this$httpGet");
        return httpGet(httpGet.getPath(), list);
    }

    public static /* synthetic */ Request httpPost$default(String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return httpPost(str, (List<? extends Pair<String, ? extends Object>>) list);
    }

    public static final Request httpPost(String httpPost, List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(httpPost, "$this$httpPost");
        return Fuel.INSTANCE.post(httpPost, list);
    }

    public static /* synthetic */ Request httpPost$default(RequestFactory.PathStringConvertible pathStringConvertible, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return httpPost(pathStringConvertible, (List<? extends Pair<String, ? extends Object>>) list);
    }

    public static final Request httpPost(RequestFactory.PathStringConvertible httpPost, List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(httpPost, "$this$httpPost");
        return httpPost(httpPost.getPath(), list);
    }

    public static /* synthetic */ Request httpPut$default(String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return httpPut(str, (List<? extends Pair<String, ? extends Object>>) list);
    }

    public static final Request httpPut(String httpPut, List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(httpPut, "$this$httpPut");
        return Fuel.INSTANCE.put(httpPut, list);
    }

    public static /* synthetic */ Request httpPut$default(RequestFactory.PathStringConvertible pathStringConvertible, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return httpPut(pathStringConvertible, (List<? extends Pair<String, ? extends Object>>) list);
    }

    public static final Request httpPut(RequestFactory.PathStringConvertible httpPut, List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(httpPut, "$this$httpPut");
        return httpPut(httpPut.getPath(), list);
    }

    public static /* synthetic */ Request httpPatch$default(String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return httpPatch(str, (List<? extends Pair<String, ? extends Object>>) list);
    }

    public static final Request httpPatch(String httpPatch, List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(httpPatch, "$this$httpPatch");
        return Fuel.INSTANCE.patch(httpPatch, list);
    }

    public static /* synthetic */ Request httpPatch$default(RequestFactory.PathStringConvertible pathStringConvertible, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return httpPatch(pathStringConvertible, (List<? extends Pair<String, ? extends Object>>) list);
    }

    public static final Request httpPatch(RequestFactory.PathStringConvertible httpPatch, List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(httpPatch, "$this$httpPatch");
        return httpPatch(httpPatch.getPath(), list);
    }

    public static /* synthetic */ Request httpDelete$default(String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return httpDelete(str, (List<? extends Pair<String, ? extends Object>>) list);
    }

    public static final Request httpDelete(String httpDelete, List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(httpDelete, "$this$httpDelete");
        return Fuel.INSTANCE.delete(httpDelete, list);
    }

    public static /* synthetic */ Request httpDelete$default(RequestFactory.PathStringConvertible pathStringConvertible, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return httpDelete(pathStringConvertible, (List<? extends Pair<String, ? extends Object>>) list);
    }

    public static final Request httpDelete(RequestFactory.PathStringConvertible httpDelete, List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(httpDelete, "$this$httpDelete");
        return httpDelete(httpDelete.getPath(), list);
    }

    public static /* synthetic */ DownloadRequest httpDownload$default(String str, List list, Method method, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        if ((i & 2) != 0) {
            method = Method.GET;
        }
        return httpDownload(str, (List<? extends Pair<String, ? extends Object>>) list, method);
    }

    public static final DownloadRequest httpDownload(String httpDownload, List<? extends Pair<String, ? extends Object>> list, Method method) {
        Intrinsics.checkNotNullParameter(httpDownload, "$this$httpDownload");
        Intrinsics.checkNotNullParameter(method, "method");
        return Fuel.INSTANCE.download(httpDownload, method, list);
    }

    public static /* synthetic */ DownloadRequest httpDownload$default(RequestFactory.PathStringConvertible pathStringConvertible, List list, Method method, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        if ((i & 2) != 0) {
            method = Method.GET;
        }
        return httpDownload(pathStringConvertible, (List<? extends Pair<String, ? extends Object>>) list, method);
    }

    public static final DownloadRequest httpDownload(RequestFactory.PathStringConvertible httpDownload, List<? extends Pair<String, ? extends Object>> list, Method method) {
        Intrinsics.checkNotNullParameter(httpDownload, "$this$httpDownload");
        Intrinsics.checkNotNullParameter(method, "method");
        return httpDownload(httpDownload.getPath(), list, method);
    }

    public static /* synthetic */ UploadRequest httpUpload$default(String str, List list, Method method, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        if ((i & 2) != 0) {
            method = Method.POST;
        }
        return httpUpload(str, (List<? extends Pair<String, ? extends Object>>) list, method);
    }

    public static final UploadRequest httpUpload(String httpUpload, List<? extends Pair<String, ? extends Object>> list, Method method) {
        Intrinsics.checkNotNullParameter(httpUpload, "$this$httpUpload");
        Intrinsics.checkNotNullParameter(method, "method");
        return Fuel.INSTANCE.upload(httpUpload, method, list);
    }

    public static /* synthetic */ UploadRequest httpUpload$default(RequestFactory.PathStringConvertible pathStringConvertible, List list, Method method, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        if ((i & 2) != 0) {
            method = Method.POST;
        }
        return httpUpload(pathStringConvertible, (List<? extends Pair<String, ? extends Object>>) list, method);
    }

    public static final UploadRequest httpUpload(RequestFactory.PathStringConvertible httpUpload, List<? extends Pair<String, ? extends Object>> list, Method method) {
        Intrinsics.checkNotNullParameter(httpUpload, "$this$httpUpload");
        Intrinsics.checkNotNullParameter(method, "method");
        return httpUpload(httpUpload.getPath(), list, method);
    }

    public static /* synthetic */ Request httpHead$default(String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return httpHead(str, (List<? extends Pair<String, ? extends Object>>) list);
    }

    public static final Request httpHead(String httpHead, List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(httpHead, "$this$httpHead");
        return Fuel.INSTANCE.head(httpHead, list);
    }

    public static /* synthetic */ Request httpHead$default(RequestFactory.PathStringConvertible pathStringConvertible, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return httpHead(pathStringConvertible, (List<? extends Pair<String, ? extends Object>>) list);
    }

    public static final Request httpHead(RequestFactory.PathStringConvertible httpHead, List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(httpHead, "$this$httpHead");
        return httpHead(httpHead.getPath(), list);
    }
}
