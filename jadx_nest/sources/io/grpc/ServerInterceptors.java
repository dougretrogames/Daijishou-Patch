package io.grpc;

import com.google.common.base.Preconditions;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ServerInterceptors {
    private ServerInterceptors() {
    }

    public static ServerServiceDefinition interceptForward(ServerServiceDefinition serverServiceDefinition, ServerInterceptor... serverInterceptorArr) {
        return interceptForward(serverServiceDefinition, (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition interceptForward(BindableService bindableService, ServerInterceptor... serverInterceptorArr) {
        return interceptForward(bindableService.bindService(), (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition interceptForward(ServerServiceDefinition serverServiceDefinition, List<? extends ServerInterceptor> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.reverse(arrayList);
        return intercept(serverServiceDefinition, arrayList);
    }

    public static ServerServiceDefinition interceptForward(BindableService bindableService, List<? extends ServerInterceptor> list) {
        return interceptForward(bindableService.bindService(), list);
    }

    public static ServerServiceDefinition intercept(ServerServiceDefinition serverServiceDefinition, ServerInterceptor... serverInterceptorArr) {
        return intercept(serverServiceDefinition, (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition intercept(BindableService bindableService, ServerInterceptor... serverInterceptorArr) {
        Preconditions.checkNotNull(bindableService, "bindableService");
        return intercept(bindableService.bindService(), (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition intercept(ServerServiceDefinition serverServiceDefinition, List<? extends ServerInterceptor> list) {
        Preconditions.checkNotNull(serverServiceDefinition, "serviceDef");
        if (list.isEmpty()) {
            return serverServiceDefinition;
        }
        ServerServiceDefinition.Builder builder = ServerServiceDefinition.builder(serverServiceDefinition.getServiceDescriptor());
        Iterator<ServerMethodDefinition<?, ?>> it = serverServiceDefinition.getMethods().iterator();
        while (it.hasNext()) {
            wrapAndAddMethod(builder, it.next(), list);
        }
        return builder.build();
    }

    public static ServerServiceDefinition intercept(BindableService bindableService, List<? extends ServerInterceptor> list) {
        Preconditions.checkNotNull(bindableService, "bindableService");
        return intercept(bindableService.bindService(), list);
    }

    /* JADX INFO: renamed from: io.grpc.ServerInterceptors$1, reason: invalid class name */
    class AnonymousClass1 implements MethodDescriptor.Marshaller<InputStream> {
        @Override // io.grpc.MethodDescriptor.Marshaller
        public InputStream stream(InputStream inputStream) {
            return inputStream;
        }

        AnonymousClass1() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.MethodDescriptor.Marshaller
        public InputStream parse(InputStream inputStream) {
            if (inputStream.markSupported()) {
                return inputStream;
            }
            if (inputStream instanceof KnownLength) {
                return new KnownLengthBufferedInputStream(inputStream);
            }
            return new BufferedInputStream(inputStream);
        }
    }

    public static ServerServiceDefinition useInputStreamMessages(ServerServiceDefinition serverServiceDefinition) {
        return useMarshalledMessages(serverServiceDefinition, new AnonymousClass1());
    }

    private static final class KnownLengthBufferedInputStream extends BufferedInputStream implements KnownLength {
        KnownLengthBufferedInputStream(InputStream inputStream) {
            super(inputStream);
        }
    }

    public static <T> ServerServiceDefinition useMarshalledMessages(ServerServiceDefinition serverServiceDefinition, MethodDescriptor.Marshaller<T> marshaller) {
        return useMarshalledMessages(serverServiceDefinition, marshaller, marshaller);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <ReqT, RespT> ServerServiceDefinition useMarshalledMessages(ServerServiceDefinition serverServiceDefinition, MethodDescriptor.Marshaller<ReqT> marshaller, MethodDescriptor.Marshaller<RespT> marshaller2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ServerMethodDefinition<?, ?> serverMethodDefinition : serverServiceDefinition.getMethods()) {
            MethodDescriptor methodDescriptorBuild = serverMethodDefinition.getMethodDescriptor().toBuilder(marshaller, marshaller2).build();
            arrayList2.add(methodDescriptorBuild);
            arrayList.add(wrapMethod(serverMethodDefinition, methodDescriptorBuild));
        }
        ServiceDescriptor.Builder schemaDescriptor = ServiceDescriptor.newBuilder(serverServiceDefinition.getServiceDescriptor().getName()).setSchemaDescriptor(serverServiceDefinition.getServiceDescriptor().getSchemaDescriptor());
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            schemaDescriptor.addMethod((MethodDescriptor) it.next());
        }
        ServerServiceDefinition.Builder builder = ServerServiceDefinition.builder(schemaDescriptor.build());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            builder.addMethod((ServerMethodDefinition) it2.next());
        }
        return builder.build();
    }

    private static <ReqT, RespT> void wrapAndAddMethod(ServerServiceDefinition.Builder builder, ServerMethodDefinition<ReqT, RespT> serverMethodDefinition, List<? extends ServerInterceptor> list) {
        ServerCallHandler<ReqT, RespT> serverCallHandler = serverMethodDefinition.getServerCallHandler();
        Iterator<? extends ServerInterceptor> it = list.iterator();
        while (it.hasNext()) {
            serverCallHandler = InterceptCallHandler.create(it.next(), serverCallHandler);
        }
        builder.addMethod(serverMethodDefinition.withServerCallHandler(serverCallHandler));
    }

    static final class InterceptCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
        private final ServerCallHandler<ReqT, RespT> callHandler;
        private final ServerInterceptor interceptor;

        public static <ReqT, RespT> InterceptCallHandler<ReqT, RespT> create(ServerInterceptor serverInterceptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
            return new InterceptCallHandler<>(serverInterceptor, serverCallHandler);
        }

        private InterceptCallHandler(ServerInterceptor serverInterceptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
            this.interceptor = (ServerInterceptor) Preconditions.checkNotNull(serverInterceptor, "interceptor");
            this.callHandler = serverCallHandler;
        }

        @Override // io.grpc.ServerCallHandler
        public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata) {
            return this.interceptor.interceptCall(serverCall, metadata, this.callHandler);
        }
    }

    static <OReqT, ORespT, WReqT, WRespT> ServerMethodDefinition<WReqT, WRespT> wrapMethod(ServerMethodDefinition<OReqT, ORespT> serverMethodDefinition, MethodDescriptor<WReqT, WRespT> methodDescriptor) {
        return ServerMethodDefinition.create(methodDescriptor, wrapHandler(serverMethodDefinition.getServerCallHandler(), serverMethodDefinition.getMethodDescriptor(), methodDescriptor));
    }

    /* JADX INFO: Add missing generic type declarations: [WRespT, WReqT] */
    /* JADX INFO: renamed from: io.grpc.ServerInterceptors$2, reason: invalid class name */
    class AnonymousClass2<WReqT, WRespT> implements ServerCallHandler<WReqT, WRespT> {
        final /* synthetic */ ServerCallHandler val$originalHandler;
        final /* synthetic */ MethodDescriptor val$originalMethod;
        final /* synthetic */ MethodDescriptor val$wrappedMethod;

        AnonymousClass2(MethodDescriptor methodDescriptor, MethodDescriptor methodDescriptor2, ServerCallHandler serverCallHandler) {
            this.val$originalMethod = methodDescriptor;
            this.val$wrappedMethod = methodDescriptor2;
            this.val$originalHandler = serverCallHandler;
        }

        /* JADX INFO: Add missing generic type declarations: [OReqT, ORespT] */
        /* JADX INFO: renamed from: io.grpc.ServerInterceptors$2$1, reason: invalid class name */
        class AnonymousClass1<OReqT, ORespT> extends PartialForwardingServerCall<OReqT, ORespT> {
            final /* synthetic */ ServerCall val$call;

            AnonymousClass1(ServerCall serverCall) {
                this.val$call = serverCall;
            }

            @Override // io.grpc.PartialForwardingServerCall
            protected ServerCall<WReqT, WRespT> delegate() {
                return this.val$call;
            }

            @Override // io.grpc.ServerCall
            public void sendMessage(ORespT orespt) {
                delegate().sendMessage(AnonymousClass2.this.val$wrappedMethod.parseResponse(AnonymousClass2.this.val$originalMethod.streamResponse(orespt)));
            }

            @Override // io.grpc.ServerCall
            public MethodDescriptor<OReqT, ORespT> getMethodDescriptor() {
                return AnonymousClass2.this.val$originalMethod;
            }
        }

        @Override // io.grpc.ServerCallHandler
        public ServerCall.Listener<WReqT> startCall(ServerCall<WReqT, WRespT> serverCall, Metadata metadata) {
            return new C00862(this.val$originalHandler.startCall(new AnonymousClass1(serverCall), metadata));
        }

        /* JADX INFO: renamed from: io.grpc.ServerInterceptors$2$2, reason: invalid class name and collision with other inner class name */
        class C00862 extends PartialForwardingServerCallListener<WReqT> {
            final /* synthetic */ ServerCall.Listener val$originalListener;

            C00862(ServerCall.Listener listener) {
                this.val$originalListener = listener;
            }

            @Override // io.grpc.PartialForwardingServerCallListener
            protected ServerCall.Listener<OReqT> delegate() {
                return this.val$originalListener;
            }

            @Override // io.grpc.ServerCall.Listener
            public void onMessage(WReqT wreqt) {
                delegate().onMessage(AnonymousClass2.this.val$originalMethod.parseRequest(AnonymousClass2.this.val$wrappedMethod.streamRequest(wreqt)));
            }
        }
    }

    private static <OReqT, ORespT, WReqT, WRespT> ServerCallHandler<WReqT, WRespT> wrapHandler(ServerCallHandler<OReqT, ORespT> serverCallHandler, MethodDescriptor<OReqT, ORespT> methodDescriptor, MethodDescriptor<WReqT, WRespT> methodDescriptor2) {
        return new AnonymousClass2(methodDescriptor, methodDescriptor2, serverCallHandler);
    }
}
