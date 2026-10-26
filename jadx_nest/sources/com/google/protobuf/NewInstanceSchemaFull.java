package com.google.protobuf;

/* INFO: loaded from: classes4.dex */
final class NewInstanceSchemaFull implements NewInstanceSchema {
    NewInstanceSchemaFull() {
    }

    @Override // com.google.protobuf.NewInstanceSchema
    public Object newInstance(Object defaultInstance) {
        return ((Message) defaultInstance).toBuilder().buildPartial();
    }
}
