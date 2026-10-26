package com.google.protobuf;

/* INFO: loaded from: classes4.dex */
public interface BlockingService {
    Message callBlockingMethod(Descriptors.MethodDescriptor method, RpcController controller, Message request) throws ServiceException;

    Descriptors.ServiceDescriptor getDescriptorForType();

    Message getRequestPrototype(Descriptors.MethodDescriptor method);

    Message getResponsePrototype(Descriptors.MethodDescriptor method);
}
