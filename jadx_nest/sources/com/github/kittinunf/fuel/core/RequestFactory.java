package com.github.kittinunf.fuel.core;

import com.github.kittinunf.fuel.core.requests.DownloadRequest;
import com.github.kittinunf.fuel.core.requests.UploadRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: compiled from: RequestFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011J>\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072$\b\u0002\u0010\b\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n\u0018\u00010\tj\u0004\u0018\u0001`\fH&J>\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2$\b\u0002\u0010\b\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n\u0018\u00010\tj\u0004\u0018\u0001`\fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u000eH&¨\u0006\u0012"}, d2 = {"Lcom/github/kittinunf/fuel/core/RequestFactory;", "", "request", "Lcom/github/kittinunf/fuel/core/Request;", "method", "Lcom/github/kittinunf/fuel/core/Method;", "convertible", "Lcom/github/kittinunf/fuel/core/RequestFactory$PathStringConvertible;", "parameters", "", "Lkotlin/Pair;", "", "Lcom/github/kittinunf/fuel/core/Parameters;", "path", "Lcom/github/kittinunf/fuel/core/RequestFactory$RequestConvertible;", "Convenience", "PathStringConvertible", "RequestConvertible", "fuel"}, k = 1, mv = {1, 4, 0})
public interface RequestFactory {

    /* JADX INFO: compiled from: RequestFactory.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/github/kittinunf/fuel/core/RequestFactory$PathStringConvertible;", "", "path", "", "getPath", "()Ljava/lang/String;", "fuel"}, k = 1, mv = {1, 4, 0})
    public interface PathStringConvertible {
        String getPath();
    }

    /* JADX INFO: compiled from: RequestFactory.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/github/kittinunf/fuel/core/RequestFactory$RequestConvertible;", "", "request", "Lcom/github/kittinunf/fuel/core/Request;", "getRequest", "()Lcom/github/kittinunf/fuel/core/Request;", "fuel"}, k = 1, mv = {1, 4, 0})
    public interface RequestConvertible {
        Request getRequest();
    }

    Request request(Method method, PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters);

    Request request(Method method, String path, List<? extends Pair<String, ? extends Object>> parameters);

    Request request(RequestConvertible convertible);

    /* JADX INFO: compiled from: RequestFactory.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Request request$default(RequestFactory requestFactory, Method method, PathStringConvertible pathStringConvertible, List list, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: request");
            }
            if ((i & 4) != 0) {
                list = null;
            }
            return requestFactory.request(method, pathStringConvertible, (List<? extends Pair<String, ? extends Object>>) list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Request request$default(RequestFactory requestFactory, Method method, String str, List list, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: request");
            }
            if ((i & 4) != 0) {
                list = null;
            }
            return requestFactory.request(method, str, (List<? extends Pair<String, ? extends Object>>) list);
        }
    }

    /* JADX INFO: compiled from: RequestFactory.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\u000bH&J6\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\t2$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\u000bH&J@\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\u000bH&J@\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\u000bH&J6\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\u000bH&J6\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\t2$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\u000bH&J6\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\u000bH&J6\u0010\u0012\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\t2$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\u000bH&J6\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\u000bH&J6\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\t2$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\u000bH&J6\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\u000bH&J6\u0010\u0014\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\t2$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\u000bH&J6\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\u000bH&J6\u0010\u0015\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\t2$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\u000bH&J@\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\u000bH&J@\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0018\u00010\u0007j\u0004\u0018\u0001`\u000bH&¨\u0006\u0018"}, d2 = {"Lcom/github/kittinunf/fuel/core/RequestFactory$Convenience;", "Lcom/github/kittinunf/fuel/core/RequestFactory;", "delete", "Lcom/github/kittinunf/fuel/core/Request;", "convertible", "Lcom/github/kittinunf/fuel/core/RequestFactory$PathStringConvertible;", "parameters", "", "Lkotlin/Pair;", "", "", "Lcom/github/kittinunf/fuel/core/Parameters;", "path", "download", "Lcom/github/kittinunf/fuel/core/requests/DownloadRequest;", "method", "Lcom/github/kittinunf/fuel/core/Method;", "get", "head", "patch", "post", "put", "upload", "Lcom/github/kittinunf/fuel/core/requests/UploadRequest;", "fuel"}, k = 1, mv = {1, 4, 0})
    public interface Convenience extends RequestFactory {
        Request delete(PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters);

        Request delete(String path, List<? extends Pair<String, ? extends Object>> parameters);

        DownloadRequest download(PathStringConvertible convertible, Method method, List<? extends Pair<String, ? extends Object>> parameters);

        DownloadRequest download(String path, Method method, List<? extends Pair<String, ? extends Object>> parameters);

        Request get(PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters);

        Request get(String path, List<? extends Pair<String, ? extends Object>> parameters);

        Request head(PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters);

        Request head(String path, List<? extends Pair<String, ? extends Object>> parameters);

        Request patch(PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters);

        Request patch(String path, List<? extends Pair<String, ? extends Object>> parameters);

        Request post(PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters);

        Request post(String path, List<? extends Pair<String, ? extends Object>> parameters);

        Request put(PathStringConvertible convertible, List<? extends Pair<String, ? extends Object>> parameters);

        Request put(String path, List<? extends Pair<String, ? extends Object>> parameters);

        UploadRequest upload(PathStringConvertible convertible, Method method, List<? extends Pair<String, ? extends Object>> parameters);

        UploadRequest upload(String path, Method method, List<? extends Pair<String, ? extends Object>> parameters);

        /* JADX INFO: compiled from: RequestFactory.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
        public static final class DefaultImpls {
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ DownloadRequest download$default(Convenience convenience, String str, Method method, List list, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: download");
                }
                if ((i & 2) != 0) {
                    method = Method.GET;
                }
                if ((i & 4) != 0) {
                    list = null;
                }
                return convenience.download(str, method, (List<? extends Pair<String, ? extends Object>>) list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ DownloadRequest download$default(Convenience convenience, PathStringConvertible pathStringConvertible, Method method, List list, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: download");
                }
                if ((i & 2) != 0) {
                    method = Method.GET;
                }
                if ((i & 4) != 0) {
                    list = null;
                }
                return convenience.download(pathStringConvertible, method, (List<? extends Pair<String, ? extends Object>>) list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ UploadRequest upload$default(Convenience convenience, PathStringConvertible pathStringConvertible, Method method, List list, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: upload");
                }
                if ((i & 2) != 0) {
                    method = Method.POST;
                }
                if ((i & 4) != 0) {
                    list = null;
                }
                return convenience.upload(pathStringConvertible, method, (List<? extends Pair<String, ? extends Object>>) list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ UploadRequest upload$default(Convenience convenience, String str, Method method, List list, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: upload");
                }
                if ((i & 2) != 0) {
                    method = Method.POST;
                }
                if ((i & 4) != 0) {
                    list = null;
                }
                return convenience.upload(str, method, (List<? extends Pair<String, ? extends Object>>) list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Request get$default(Convenience convenience, String str, List list, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
                }
                if ((i & 2) != 0) {
                    list = null;
                }
                return convenience.get(str, (List<? extends Pair<String, ? extends Object>>) list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Request get$default(Convenience convenience, PathStringConvertible pathStringConvertible, List list, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
                }
                if ((i & 2) != 0) {
                    list = null;
                }
                return convenience.get(pathStringConvertible, (List<? extends Pair<String, ? extends Object>>) list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Request post$default(Convenience convenience, String str, List list, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: post");
                }
                if ((i & 2) != 0) {
                    list = null;
                }
                return convenience.post(str, (List<? extends Pair<String, ? extends Object>>) list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Request post$default(Convenience convenience, PathStringConvertible pathStringConvertible, List list, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: post");
                }
                if ((i & 2) != 0) {
                    list = null;
                }
                return convenience.post(pathStringConvertible, (List<? extends Pair<String, ? extends Object>>) list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Request put$default(Convenience convenience, String str, List list, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: put");
                }
                if ((i & 2) != 0) {
                    list = null;
                }
                return convenience.put(str, (List<? extends Pair<String, ? extends Object>>) list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Request put$default(Convenience convenience, PathStringConvertible pathStringConvertible, List list, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: put");
                }
                if ((i & 2) != 0) {
                    list = null;
                }
                return convenience.put(pathStringConvertible, (List<? extends Pair<String, ? extends Object>>) list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Request patch$default(Convenience convenience, String str, List list, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: patch");
                }
                if ((i & 2) != 0) {
                    list = null;
                }
                return convenience.patch(str, (List<? extends Pair<String, ? extends Object>>) list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Request patch$default(Convenience convenience, PathStringConvertible pathStringConvertible, List list, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: patch");
                }
                if ((i & 2) != 0) {
                    list = null;
                }
                return convenience.patch(pathStringConvertible, (List<? extends Pair<String, ? extends Object>>) list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Request delete$default(Convenience convenience, String str, List list, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
                }
                if ((i & 2) != 0) {
                    list = null;
                }
                return convenience.delete(str, (List<? extends Pair<String, ? extends Object>>) list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Request delete$default(Convenience convenience, PathStringConvertible pathStringConvertible, List list, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
                }
                if ((i & 2) != 0) {
                    list = null;
                }
                return convenience.delete(pathStringConvertible, (List<? extends Pair<String, ? extends Object>>) list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Request head$default(Convenience convenience, String str, List list, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: head");
                }
                if ((i & 2) != 0) {
                    list = null;
                }
                return convenience.head(str, (List<? extends Pair<String, ? extends Object>>) list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Request head$default(Convenience convenience, PathStringConvertible pathStringConvertible, List list, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: head");
                }
                if ((i & 2) != 0) {
                    list = null;
                }
                return convenience.head(pathStringConvertible, (List<? extends Pair<String, ? extends Object>>) list);
            }
        }
    }
}
