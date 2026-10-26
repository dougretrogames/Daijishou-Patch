package io.grpc;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* INFO: loaded from: classes4.dex */
public class ClientInterceptors {
    private static final ClientCall<Object, Object> NOOP_CALL = new AnonymousClass2();

    private ClientInterceptors() {
    }

    public static Channel interceptForward(Channel channel, ClientInterceptor... clientInterceptorArr) {
        return interceptForward(channel, (List<? extends ClientInterceptor>) Arrays.asList(clientInterceptorArr));
    }

    public static Channel interceptForward(Channel channel, List<? extends ClientInterceptor> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.reverse(arrayList);
        return intercept(channel, arrayList);
    }

    public static Channel intercept(Channel channel, ClientInterceptor... clientInterceptorArr) {
        return intercept(channel, (List<? extends ClientInterceptor>) Arrays.asList(clientInterceptorArr));
    }

    public static Channel intercept(Channel channel, List<? extends ClientInterceptor> list) {
        Preconditions.checkNotNull(channel, "channel");
        Iterator<? extends ClientInterceptor> it = list.iterator();
        while (it.hasNext()) {
            channel = new InterceptorChannel(channel, it.next(), null);
        }
        return channel;
    }

    /* INFO: renamed from: io.grpc.ClientInterceptors$1, reason: invalid class name */
    class AnonymousClass1 implements ClientInterceptor {
        final /* synthetic */ ClientInterceptor val$interceptor;
        final /* synthetic */ MethodDescriptor.Marshaller val$reqMarshaller;
        final /* synthetic */ MethodDescriptor.Marshaller val$respMarshaller;

        AnonymousClass1(MethodDescriptor.Marshaller marshaller, MethodDescriptor.Marshaller marshaller2, ClientInterceptor clientInterceptor) {
            this.val$reqMarshaller = marshaller;
            this.val$respMarshaller = marshaller2;
            this.val$interceptor = clientInterceptor;
        }

        @Override // io.grpc.ClientInterceptor
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
            return new C00841(this.val$interceptor.interceptCall(methodDescriptor.toBuilder(this.val$reqMarshaller, this.val$respMarshaller).build(), callOptions, channel), methodDescriptor);
        }

        /* INFO: Add missing generic type declarations: [ReqT, RespT] */
        /* INFO: renamed from: io.grpc.ClientInterceptors$1$1, reason: invalid class name and collision with other inner class name */
        class C00841<ReqT, RespT> extends PartialForwardingClientCall<ReqT, RespT> {
            final /* synthetic */ MethodDescriptor val$method;
            final /* synthetic */ ClientCall val$wrappedCall;

            C00841(ClientCall clientCall, MethodDescriptor methodDescriptor) {
                this.val$wrappedCall = clientCall;
                this.val$method = methodDescriptor;
            }

            /* INFO: Add missing generic type declarations: [WRespT] */
            /* INFO: renamed from: io.grpc.ClientInterceptors$1$1$1, reason: invalid class name and collision with other inner class name */
            class C00851<WRespT> extends PartialForwardingClientCallListener<WRespT> {
                final /* synthetic */ ClientCall.Listener val$responseListener;

                C00851(ClientCall.Listener listener) {
                    this.val$responseListener = listener;
                }

                @Override // io.grpc.ClientCall.Listener
                public void onMessage(WRespT wrespt) {
                    this.val$responseListener.onMessage(C00841.this.val$method.getResponseMarshaller().parse(AnonymousClass1.this.val$respMarshaller.stream(wrespt)));
                }

                @Override // io.grpc.PartialForwardingClientCallListener
                protected ClientCall.Listener<?> delegate() {
                    return this.val$responseListener;
                }
            }

            @Override // io.grpc.ClientCall
            public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
                this.val$wrappedCall.start(new C00851(listener), metadata);
            }

            /* WARN: Multi-variable type inference failed */
            @Override // io.grpc.ClientCall
            public void sendMessage(ReqT reqt) {
                this.val$wrappedCall.sendMessage(AnonymousClass1.this.val$reqMarshaller.parse(this.val$method.getRequestMarshaller().stream(reqt)));
            }

            @Override // io.grpc.PartialForwardingClientCall
            protected ClientCall<?, ?> delegate() {
                return this.val$wrappedCall;
            }
        }
    }

    static <WReqT, WRespT> ClientInterceptor wrapClientInterceptor(ClientInterceptor clientInterceptor, MethodDescriptor.Marshaller<WReqT> marshaller, MethodDescriptor.Marshaller<WRespT> marshaller2) {
        return new AnonymousClass1(marshaller, marshaller2, clientInterceptor);
    }

    private static class InterceptorChannel extends Channel {
        private final Channel channel;
        private final ClientInterceptor interceptor;

        /* synthetic */ InterceptorChannel(Channel channel, ClientInterceptor clientInterceptor, AnonymousClass1 anonymousClass1) {
            this(channel, clientInterceptor);
        }

        private InterceptorChannel(Channel channel, ClientInterceptor clientInterceptor) {
            this.channel = channel;
            this.interceptor = (ClientInterceptor) Preconditions.checkNotNull(clientInterceptor, "interceptor");
        }

        @Override // io.grpc.Channel
        public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
            return this.interceptor.interceptCall(methodDescriptor, callOptions, this.channel);
        }

        @Override // io.grpc.Channel
        public String authority() {
            return this.channel.authority();
        }
    }

    /* INFO: renamed from: io.grpc.ClientInterceptors$2, reason: invalid class name */
    class AnonymousClass2 extends ClientCall<Object, Object> {
        @Override // io.grpc.ClientCall
        public void cancel(String str, Throwable th) {
        }

        @Override // io.grpc.ClientCall
        public void halfClose() {
        }

        @Override // io.grpc.ClientCall
        public boolean isReady() {
            return false;
        }

        @Override // io.grpc.ClientCall
        public void request(int i) {
        }

        @Override // io.grpc.ClientCall
        public void sendMessage(Object obj) {
        }

        @Override // io.grpc.ClientCall
        public void start(ClientCall.Listener<Object> listener, Metadata metadata) {
        }

        AnonymousClass2() {
        }
    }

    public static abstract class CheckedForwardingClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {
        private ClientCall<ReqT, RespT> delegate;

        protected abstract void checkedStart(ClientCall.Listener<RespT> listener, Metadata metadata) throws Exception;

        protected CheckedForwardingClientCall(ClientCall<ReqT, RespT> clientCall) {
            this.delegate = clientCall;
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall
        protected final ClientCall<ReqT, RespT> delegate() {
            return this.delegate;
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
        public final void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
            try {
                checkedStart(listener, metadata);
            } catch (Exception e) {
                this.delegate = ClientInterceptors.NOOP_CALL;
                Metadata metadataTrailersFromThrowable = Status.trailersFromThrowable(e);
                Status statusFromThrowable = Status.fromThrowable(e);
                if (metadataTrailersFromThrowable == null) {
                    metadataTrailersFromThrowable = new Metadata();
                }
                listener.onClose(statusFromThrowable, metadataTrailersFromThrowable);
            }
        }
    }
}
