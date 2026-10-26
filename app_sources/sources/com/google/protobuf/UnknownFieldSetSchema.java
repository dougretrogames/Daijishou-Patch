package com.google.protobuf;

import java.io.IOException;

/* INFO: loaded from: classes4.dex */
class UnknownFieldSetSchema extends UnknownFieldSchema<UnknownFieldSet, UnknownFieldSet.Builder> {
    @Override // com.google.protobuf.UnknownFieldSchema
    void makeImmutable(Object message) {
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    boolean shouldDiscardUnknownFields(Reader reader) {
        return reader.shouldDiscardUnknownFields();
    }

    /* INFO: Access modifiers changed from: package-private */
    /* WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSet.Builder newBuilder() {
        return UnknownFieldSet.newBuilder();
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addVarint(UnknownFieldSet.Builder fields, int number, long value) {
        fields.mergeField(number, UnknownFieldSet.Field.newBuilder().addVarint(value).build());
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addFixed32(UnknownFieldSet.Builder fields, int number, int value) {
        fields.mergeField(number, UnknownFieldSet.Field.newBuilder().addFixed32(value).build());
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addFixed64(UnknownFieldSet.Builder fields, int number, long value) {
        fields.mergeField(number, UnknownFieldSet.Field.newBuilder().addFixed64(value).build());
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addLengthDelimited(UnknownFieldSet.Builder fields, int number, ByteString value) {
        fields.mergeField(number, UnknownFieldSet.Field.newBuilder().addLengthDelimited(value).build());
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void addGroup(UnknownFieldSet.Builder fields, int number, UnknownFieldSet subFieldSet) {
        fields.mergeField(number, UnknownFieldSet.Field.newBuilder().addGroup(subFieldSet).build());
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSet toImmutable(UnknownFieldSet.Builder fields) {
        return fields.build();
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void writeTo(UnknownFieldSet message, Writer writer) throws IOException {
        message.writeTo(writer);
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void writeAsMessageSetTo(UnknownFieldSet message, Writer writer) throws IOException {
        message.writeAsMessageSetTo(writer);
    }

    /* INFO: Access modifiers changed from: package-private */
    /* WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSet getFromMessage(Object message) {
        return ((GeneratedMessage) message).unknownFields;
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void setToMessage(Object message, UnknownFieldSet fields) {
        ((GeneratedMessage) message).unknownFields = fields;
    }

    /* INFO: Access modifiers changed from: package-private */
    /* WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSet.Builder getBuilderFromMessage(Object message) {
        return ((GeneratedMessage) message).unknownFields.toBuilder();
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public void setBuilderToMessage(Object message, UnknownFieldSet.Builder builder) {
        ((GeneratedMessage) message).unknownFields = builder.build();
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSet merge(UnknownFieldSet message, UnknownFieldSet other) {
        return message.toBuilder().mergeFrom(other).build();
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public int getSerializedSize(UnknownFieldSet message) {
        return message.getSerializedSize();
    }

    /* INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.UnknownFieldSchema
    public int getSerializedSizeAsMessageSet(UnknownFieldSet unknowns) {
        return unknowns.getSerializedSizeAsMessageSet();
    }
}
