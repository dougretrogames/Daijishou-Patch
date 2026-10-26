package com.google.protobuf;

import java.io.IOException;

/* INFO: loaded from: classes4.dex */
@CheckReturnValue
class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    @Override // com.google.protobuf.UnknownFieldSchema
    boolean shouldDiscardUnknownFields(Reader reader) {
        return false;
    }

    UnknownFieldSetLiteSchema() {
    }

    /* INFO: Access modifiers changed from: package-private */
    /* WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSetLite newBuilder() {
        return UnknownFieldSetLite.newInstance();
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addVarint(UnknownFieldSetLite fields, int number, long value) {
        fields.storeField(WireFormat.makeTag(number, 0), Long.valueOf(value));
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addFixed32(UnknownFieldSetLite fields, int number, int value) {
        fields.storeField(WireFormat.makeTag(number, 5), Integer.valueOf(value));
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addFixed64(UnknownFieldSetLite fields, int number, long value) {
        fields.storeField(WireFormat.makeTag(number, 1), Long.valueOf(value));
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addLengthDelimited(UnknownFieldSetLite fields, int number, ByteString value) {
        fields.storeField(WireFormat.makeTag(number, 2), value);
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addGroup(UnknownFieldSetLite fields, int number, UnknownFieldSetLite subFieldSet) {
        fields.storeField(WireFormat.makeTag(number, 3), subFieldSet);
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSetLite toImmutable(UnknownFieldSetLite fields) {
        fields.makeImmutable();
        return fields;
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void setToMessage(Object message, UnknownFieldSetLite fields) {
        ((GeneratedMessageLite) message).unknownFields = fields;
    }

    /* INFO: Access modifiers changed from: package-private */
    /* WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSetLite getFromMessage(Object message) {
        return ((GeneratedMessageLite) message).unknownFields;
    }

    /* INFO: Access modifiers changed from: package-private */
    /* WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSetLite getBuilderFromMessage(Object message) {
        UnknownFieldSetLite fromMessage = getFromMessage(message);
        if (fromMessage != UnknownFieldSetLite.getDefaultInstance()) {
            return fromMessage;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        setToMessage(message, unknownFieldSetLiteNewInstance);
        return unknownFieldSetLiteNewInstance;
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void setBuilderToMessage(Object message, UnknownFieldSetLite fields) {
        setToMessage(message, fields);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    void makeImmutable(Object message) {
        getFromMessage(message).makeImmutable();
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void writeTo(UnknownFieldSetLite fields, Writer writer) throws IOException {
        fields.writeTo(writer);
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void writeAsMessageSetTo(UnknownFieldSetLite fields, Writer writer) throws IOException {
        fields.writeAsMessageSetTo(writer);
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSetLite merge(UnknownFieldSetLite target, UnknownFieldSetLite source) {
        if (UnknownFieldSetLite.getDefaultInstance().equals(source)) {
            return target;
        }
        if (UnknownFieldSetLite.getDefaultInstance().equals(target)) {
            return UnknownFieldSetLite.mutableCopyOf(target, source);
        }
        return target.mergeFrom(source);
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public int getSerializedSize(UnknownFieldSetLite unknowns) {
        return unknowns.getSerializedSize();
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public int getSerializedSizeAsMessageSet(UnknownFieldSetLite unknowns) {
        return unknowns.getSerializedSizeAsMessageSet();
    }
}
