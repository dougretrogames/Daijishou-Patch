package com.google.protobuf;

/* JADX INFO: loaded from: classes4.dex */
public interface Service {
    void callMethod(Descriptors.MethodDescriptor method, RpcController controller, Message request, RpcCallback<Message> done);

    Descriptors.ServiceDescriptor getDescriptorForType();

    Message getRequestPrototype(Descriptors.MethodDescriptor method);

    Message getResponsePrototype(Descriptors.MethodDescriptor method);
}
