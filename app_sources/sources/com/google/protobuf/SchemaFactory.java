package com.google.protobuf;

/* INFO: loaded from: classes4.dex */
@CheckReturnValue
interface SchemaFactory {
    <T> Schema<T> createSchema(Class<T> messageType);
}
