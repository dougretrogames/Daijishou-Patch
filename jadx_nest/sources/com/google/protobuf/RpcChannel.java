package com.google.protobuf;

/* JADX INFO: loaded from: classes4.dex */
public interface RpcChannel {
    void callMethod(Descriptors.MethodDescriptor method, RpcController controller, Message request, Message responsePrototype, RpcCallback<Message> done);
}
