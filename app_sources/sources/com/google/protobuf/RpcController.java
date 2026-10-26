package com.google.protobuf;

/* INFO: loaded from: classes4.dex */
public interface RpcController {
    String errorText();

    boolean failed();

    boolean isCanceled();

    void notifyOnCancel(RpcCallback<Object> callback);

    void reset();

    void setFailed(String reason);

    void startCancel();
}
