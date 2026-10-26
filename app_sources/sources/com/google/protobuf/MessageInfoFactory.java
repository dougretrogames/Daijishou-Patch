package com.google.protobuf;

/* INFO: loaded from: classes4.dex */
@CheckReturnValue
interface MessageInfoFactory {
    boolean isSupported(Class<?> clazz);

    MessageInfo messageInfoFor(Class<?> clazz);
}
