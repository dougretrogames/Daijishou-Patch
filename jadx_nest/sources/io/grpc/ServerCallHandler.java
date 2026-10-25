package io.grpc;

/* JADX INFO: loaded from: classes4.dex */
public interface ServerCallHandler<RequestT, ResponseT> {
    ServerCall.Listener<RequestT> startCall(ServerCall<RequestT, ResponseT> serverCall, Metadata metadata);
}
