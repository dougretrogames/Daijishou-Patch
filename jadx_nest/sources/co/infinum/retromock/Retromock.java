package co.infinum.retromock;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Okio;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

/* INFO: loaded from: classes3.dex */
public final class Retromock {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ExecutorService backgroundExecutor;
    private final Map<Class<? extends BodyFactory>, BodyFactory> bodyFactories;
    private final Map<Method, CallWrapper> callWrapperCache;
    private final Executor callbackExecutor;
    private final Behavior defaultBehavior;
    private final BodyFactory defaultBodyFactory;
    private final boolean eagerlyLoad;
    private final Map<Method, RetromockMethod> methodCache;
    private final Retrofit retrofit;

    /* synthetic */ Retromock(Retrofit retrofit, Map map, boolean z, ExecutorService executorService, Executor executor, Behavior behavior, BodyFactory bodyFactory, AnonymousClass1 anonymousClass1) {
        this(retrofit, map, z, executorService, executor, behavior, bodyFactory);
    }

    static final class DisabledException extends Exception {
        DisabledException() {
        }
    }

    private Retromock(Retrofit retrofit, Map<Class<? extends BodyFactory>, BodyFactory> map, boolean z, ExecutorService executorService, Executor executor, Behavior behavior, BodyFactory bodyFactory) {
        this.retrofit = retrofit;
        this.bodyFactories = map;
        this.methodCache = new HashMap();
        this.callWrapperCache = new HashMap();
        this.eagerlyLoad = z;
        this.backgroundExecutor = executorService;
        this.callbackExecutor = executor;
        this.defaultBehavior = behavior;
        this.defaultBodyFactory = bodyFactory;
    }

    public <T> T create(Class<T> cls) {
        return (T) create(createDelegate(this.retrofit, cls), cls);
    }

    public <T> T create(DelegateFactory<T> delegateFactory, Class<T> cls) {
        if (this.eagerlyLoad) {
            loadService(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new AnonymousClass1(delegateFactory.create()));
    }

    /* INFO: renamed from: co.infinum.retromock.Retromock$1, reason: invalid class name */
    class AnonymousClass1 implements InvocationHandler {
        final /* synthetic */ Object val$delegate;

        AnonymousClass1(Object obj) {
            this.val$delegate = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() != Object.class) {
                try {
                    RetromockMethod retromockMethodFindRetromockMethod = Retromock.this.findRetromockMethod(method);
                    CallWrapper callWrapperFindCallWrapper = Retromock.this.findCallWrapper(method);
                    CallAdapter<?, ?> callAdapter = Retromock.this.retrofit.callAdapter(callWrapperFindCallWrapper.getReturnType(), method.getAnnotations());
                    return callWrapperFindCallWrapper.wrap(callAdapter.adapt(new RetromockCall(retromockMethodFindRetromockMethod.behavior(), Retromock.this.backgroundExecutor, Retromock.this.callbackExecutor, Calls.defer(new CallableC00241(callAdapter, method, retromockMethodFindRetromockMethod.producer())))), objArr);
                } catch (DisabledException unused) {
                    return method.invoke(this.val$delegate, objArr);
                }
            }
            return method.invoke(this, objArr);
        }

        /* INFO: Add missing generic type declarations: [T] */
        /* INFO: renamed from: co.infinum.retromock.Retromock$1$1, reason: invalid class name and collision with other inner class name */
        class CallableC00241<T> implements Callable<Call<T>> {
            final /* synthetic */ CallAdapter val$callAdapter;
            final /* synthetic */ Method val$method;
            final /* synthetic */ ParamsProducer val$producer;

            CallableC00241(CallAdapter callAdapter, Method method, ParamsProducer paramsProducer) {
                this.val$callAdapter = callAdapter;
                this.val$method = method;
                this.val$producer = paramsProducer;
            }

            @Override // java.util.concurrent.Callable
            public Call<T> call() throws IOException {
                return Calls.response(Retromock.createResponse(Retromock.this.retrofit.responseBodyConverter(this.val$callAdapter.responseType(), this.val$method.getAnnotations()), this.val$producer.produce()));
            }
        }
    }

    /* INFO: Access modifiers changed from: private */
    public RetromockMethod findRetromockMethod(Method method) throws DisabledException {
        RetromockMethod retromockMethod;
        RetromockMethod retromockMethod2 = this.methodCache.get(method);
        if (retromockMethod2 != null) {
            return retromockMethod2;
        }
        synchronized (this.methodCache) {
            retromockMethod = this.methodCache.get(method);
            if (retromockMethod == null) {
                retromockMethod = RetromockMethod.parse(method, this);
                this.methodCache.put(method, retromockMethod);
            }
        }
        return retromockMethod;
    }

    /* INFO: Access modifiers changed from: private */
    public <T> CallWrapper findCallWrapper(Method method) {
        CallWrapper callWrapperCreate;
        CallWrapper callWrapper = this.callWrapperCache.get(method);
        if (callWrapper != null) {
            return callWrapper;
        }
        synchronized (this.callWrapperCache) {
            callWrapperCreate = this.callWrapperCache.get(method);
            if (callWrapperCreate == null) {
                callWrapperCreate = CallWrapperFactory.create(method);
                this.callWrapperCache.put(method, callWrapperCreate);
            }
        }
        return callWrapperCreate;
    }

    BodyFactory bodyFactory(Class<? extends BodyFactory> cls) {
        if (cls == BodyFactory.class) {
            return this.defaultBodyFactory;
        }
        BodyFactory bodyFactory = this.bodyFactories.get(cls);
        if (bodyFactory != null) {
            return bodyFactory;
        }
        throw new IllegalStateException("BodyFactory for type " + cls.getName() + " does not exist.");
    }

    BodyFactory defaultBodyFactory() {
        return this.defaultBodyFactory;
    }

    Behavior defaultBehavior() {
        return this.defaultBehavior;
    }

    Map<Class<? extends BodyFactory>, BodyFactory> bodyFactories() {
        return this.bodyFactories;
    }

    ExecutorService backgroundExecutor() {
        return this.backgroundExecutor;
    }

    Executor callbackExecutor() {
        return this.callbackExecutor;
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: co.infinum.retromock.Retromock$2, reason: invalid class name */
    static class AnonymousClass2<T> implements DelegateFactory<T> {
        final /* synthetic */ Retrofit val$retrofit;
        final /* synthetic */ Class val$service;

        AnonymousClass2(Retrofit retrofit, Class cls) {
            this.val$retrofit = retrofit;
            this.val$service = cls;
        }

        @Override // co.infinum.retromock.DelegateFactory
        public T create() {
            return (T) this.val$retrofit.create(this.val$service);
        }
    }

    private static <T> DelegateFactory<T> createDelegate(Retrofit retrofit, Class<T> cls) {
        return new AnonymousClass2(retrofit, cls);
    }

    private void loadService(Class<?> cls) {
        for (Method method : cls.getDeclaredMethods()) {
            try {
                findRetromockMethod(method);
            } catch (DisabledException unused) {
            }
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static <T> Response<T> createResponse(Converter<ResponseBody, T> converter, ResponseParams responseParams) throws IOException {
        ResponseBody responseBodyCreate;
        RetromockBodyFactory retromockBodyFactoryBodyFactory = responseParams.bodyFactory();
        T tConvert = null;
        if (retromockBodyFactoryBodyFactory != null) {
            String strContentType = responseParams.contentType();
            responseBodyCreate = ResponseBody.create(strContentType != null ? MediaType.parse(strContentType) : null, responseParams.contentLength(), Okio.buffer(Okio.source(retromockBodyFactoryBodyFactory.createBody())));
        } else {
            responseBodyCreate = null;
        }
        okhttp3.Response responseBuild = new okhttp3.Response.Builder().code(responseParams.code()).message(responseParams.message()).body(responseBodyCreate).protocol(Protocol.HTTP_1_1).headers(responseParams.headers()).request(new Request.Builder().url("http://localhost").build()).build();
        if (!responseBuild.isSuccessful()) {
            return Response.error(responseBuild.body(), responseBuild);
        }
        try {
            if (responseBuild.code() != 204 && responseBuild.code() != 205) {
                tConvert = converter.convert(responseBuild.body());
            } else {
                responseBuild.close();
            }
            return Response.success(tConvert, responseBuild);
        } catch (IOException e) {
            throw new RuntimeException("Error while converting mocked response!", e);
        }
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    static class SyncExecutor implements Executor {
        SyncExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static final class Builder {
        private ExecutorService backgroundExecutor;
        private final Map<Class<? extends BodyFactory>, BodyFactory> bodyFactories;
        private Executor callbackExecutor;
        private Behavior defaultBehavior;
        private BodyFactory defaultBodyFactory;
        private boolean loadEagerly;
        private Retrofit retrofit;

        public Builder() {
            this.bodyFactories = new HashMap();
        }

        Builder(Retromock retromock) {
            HashMap map = new HashMap();
            this.bodyFactories = map;
            this.retrofit = retromock.retrofit;
            this.loadEagerly = retromock.eagerlyLoad;
            this.backgroundExecutor = retromock.backgroundExecutor;
            this.callbackExecutor = retromock.callbackExecutor;
            this.defaultBehavior = retromock.defaultBehavior;
            this.defaultBodyFactory = retromock.defaultBodyFactory;
            map.putAll(retromock.bodyFactories);
            map.remove(PassThroughBodyFactory.class);
        }

        public Builder retrofit(Retrofit retrofit) {
            Preconditions.checkNotNull(retrofit, "Retrofit is null.");
            this.retrofit = retrofit;
            return this;
        }

        public Builder addBodyFactory(BodyFactory bodyFactory) {
            Preconditions.checkNotNull(bodyFactory, "Body factory is null.");
            this.bodyFactories.put((Class<? extends BodyFactory>) bodyFactory.getClass(), bodyFactory);
            return this;
        }

        public Builder defaultBodyFactory(BodyFactory bodyFactory) {
            this.defaultBodyFactory = bodyFactory;
            return this;
        }

        public Builder loadEagerly(boolean z) {
            this.loadEagerly = z;
            return this;
        }

        public Builder backgroundExecutor(ExecutorService executorService) {
            this.backgroundExecutor = executorService;
            return this;
        }

        public Builder callbackExecutor(Executor executor) {
            this.callbackExecutor = executor;
            return this;
        }

        public Builder defaultBehavior(@Nullable Behavior behavior) {
            this.defaultBehavior = behavior;
            return this;
        }

        public Retromock build() {
            Preconditions.checkNotNull(this.retrofit, "Retrofit is null.");
            HashMap map = new HashMap(this.bodyFactories);
            map.put(PassThroughBodyFactory.class, new PassThroughBodyFactory());
            ExecutorService executorServiceNewSingleThreadExecutor = this.backgroundExecutor;
            if (executorServiceNewSingleThreadExecutor == null) {
                executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new DefaultThreadFactory());
            }
            ExecutorService executorService = executorServiceNewSingleThreadExecutor;
            Executor syncExecutor = this.callbackExecutor;
            if (syncExecutor == null) {
                syncExecutor = this.retrofit.callbackExecutor();
            }
            if (syncExecutor == null) {
                syncExecutor = new SyncExecutor();
            }
            Executor executor = syncExecutor;
            Behavior behavior = this.defaultBehavior;
            if (behavior == null) {
                behavior = DefaultBehavior.INSTANCE;
            }
            Behavior behavior2 = behavior;
            BodyFactory passThroughBodyFactory = this.defaultBodyFactory;
            if (passThroughBodyFactory == null) {
                passThroughBodyFactory = new PassThroughBodyFactory();
            }
            return new Retromock(this.retrofit, Collections.unmodifiableMap(map), this.loadEagerly, executorService, executor, behavior2, passThroughBodyFactory, null);
        }

        Map<Class<? extends BodyFactory>, BodyFactory> bodyFactories() {
            return new HashMap(this.bodyFactories);
        }
    }
}
