package com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes4.dex */
class MessageReflection {

    interface MergeTarget {

        public enum ContainerType {
            MESSAGE,
            EXTENSION_SET
        }

        MergeTarget addRepeatedField(Descriptors.FieldDescriptor field, Object value);

        MergeTarget clearField(Descriptors.FieldDescriptor field);

        MergeTarget clearOneof(Descriptors.OneofDescriptor oneof);

        ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry registry, String name);

        ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry registry, Descriptors.Descriptor containingType, int fieldNumber);

        Object finish();

        ContainerType getContainerType();

        Descriptors.Descriptor getDescriptorForType();

        Object getField(Descriptors.FieldDescriptor field);

        Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof);

        WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor descriptor);

        boolean hasField(Descriptors.FieldDescriptor field);

        boolean hasOneof(Descriptors.OneofDescriptor oneof);

        void mergeGroup(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException;

        void mergeMessage(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException;

        MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor descriptor, Message defaultInstance);

        MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor descriptor, Message defaultInstance);

        Object parseGroup(CodedInputStream input, ExtensionRegistryLite registry, Descriptors.FieldDescriptor descriptor, Message defaultInstance) throws IOException;

        Object parseMessage(CodedInputStream input, ExtensionRegistryLite registry, Descriptors.FieldDescriptor descriptor, Message defaultInstance) throws IOException;

        Object parseMessageFromBytes(ByteString bytes, ExtensionRegistryLite registry, Descriptors.FieldDescriptor descriptor, Message defaultInstance) throws IOException;

        MergeTarget setField(Descriptors.FieldDescriptor field, Object value);

        MergeTarget setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value);
    }

    MessageReflection() {
    }

    static void writeMessageTo(Message message, Map<Descriptors.FieldDescriptor, Object> fields, CodedOutputStream output, boolean alwaysWriteRequiredFields) throws IOException {
        boolean messageSetWireFormat = message.getDescriptorForType().getOptions().getMessageSetWireFormat();
        if (alwaysWriteRequiredFields) {
            TreeMap treeMap = new TreeMap(fields);
            for (Descriptors.FieldDescriptor fieldDescriptor : message.getDescriptorForType().getFields()) {
                if (fieldDescriptor.isRequired() && !treeMap.containsKey(fieldDescriptor)) {
                    treeMap.put(fieldDescriptor, message.getField(fieldDescriptor));
                }
            }
            fields = treeMap;
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : fields.entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (messageSetWireFormat && key.isExtension() && key.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && !key.isRepeated()) {
                output.writeMessageSetExtension(key.getNumber(), (Message) value);
            } else {
                FieldSet.writeField(key, value, output);
            }
        }
        UnknownFieldSet unknownFields = message.getUnknownFields();
        if (messageSetWireFormat) {
            unknownFields.writeAsMessageSetTo(output);
        } else {
            unknownFields.writeTo(output);
        }
    }

    static int getSerializedSize(Message message, Map<Descriptors.FieldDescriptor, Object> fields) {
        int serializedSize;
        int iComputeFieldSize;
        boolean messageSetWireFormat = message.getDescriptorForType().getOptions().getMessageSetWireFormat();
        int i = 0;
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : fields.entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (messageSetWireFormat && key.isExtension() && key.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && !key.isRepeated()) {
                iComputeFieldSize = CodedOutputStream.computeMessageSetExtensionSize(key.getNumber(), (Message) value);
            } else {
                iComputeFieldSize = FieldSet.computeFieldSize(key, value);
            }
            i += iComputeFieldSize;
        }
        UnknownFieldSet unknownFields = message.getUnknownFields();
        if (messageSetWireFormat) {
            serializedSize = unknownFields.getSerializedSizeAsMessageSet();
        } else {
            serializedSize = unknownFields.getSerializedSize();
        }
        return i + serializedSize;
    }

    static String delimitWithCommas(List<String> parts) {
        StringBuilder sb = new StringBuilder();
        for (String str : parts) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    static boolean isInitialized(MessageOrBuilder message) {
        for (Descriptors.FieldDescriptor fieldDescriptor : message.getDescriptorForType().getFields()) {
            if (fieldDescriptor.isRequired() && !message.hasField(fieldDescriptor)) {
                return false;
            }
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : message.getAllFields().entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            if (key.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (key.isRepeated()) {
                    Iterator it = ((List) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        if (!((Message) it.next()).isInitialized()) {
                            return false;
                        }
                    }
                } else if (!((Message) entry.getValue()).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String subMessagePrefix(final String prefix, final Descriptors.FieldDescriptor field, final int index) {
        StringBuilder sb = new StringBuilder(prefix);
        if (field.isExtension()) {
            sb.append('(').append(field.getFullName()).append(')');
        } else {
            sb.append(field.getName());
        }
        if (index != -1) {
            sb.append(AbstractJsonLexerKt.BEGIN_LIST).append(index).append(AbstractJsonLexerKt.END_LIST);
        }
        sb.append(FilenameUtils.EXTENSION_SEPARATOR);
        return sb.toString();
    }

    private static void findMissingFields(final MessageOrBuilder message, final String prefix, final List<String> results) {
        for (Descriptors.FieldDescriptor fieldDescriptor : message.getDescriptorForType().getFields()) {
            if (fieldDescriptor.isRequired() && !message.hasField(fieldDescriptor)) {
                results.add(prefix + fieldDescriptor.getName());
            }
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : message.getAllFields().entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (key.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (key.isRepeated()) {
                    Iterator it = ((List) value).iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        findMissingFields((MessageOrBuilder) it.next(), subMessagePrefix(prefix, key, i), results);
                        i++;
                    }
                } else if (message.hasField(key)) {
                    findMissingFields((MessageOrBuilder) value, subMessagePrefix(prefix, key, -1), results);
                }
            }
        }
    }

    static List<String> findMissingFields(final MessageOrBuilder message) {
        ArrayList arrayList = new ArrayList();
        findMissingFields(message, "", arrayList);
        return arrayList;
    }

    static class BuilderAdapter implements MergeTarget {
        private final Message.Builder builder;
        private boolean hasNestedBuilders = true;

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.Descriptor getDescriptorForType() {
            return this.builder.getDescriptorForType();
        }

        public BuilderAdapter(Message.Builder builder) {
            this.builder = builder;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object getField(Descriptors.FieldDescriptor field) {
            return this.builder.getField(field);
        }

        private Message.Builder getFieldBuilder(Descriptors.FieldDescriptor field) {
            if (!this.hasNestedBuilders) {
                return null;
            }
            try {
                return this.builder.getFieldBuilder(field);
            } catch (UnsupportedOperationException unused) {
                this.hasNestedBuilders = false;
                return null;
            }
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor field) {
            return this.builder.hasField(field);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor field, Object value) {
            if (!field.isRepeated() && (value instanceof MessageLite.Builder)) {
                if (value != getFieldBuilder(field)) {
                    this.builder.setField(field, ((MessageLite.Builder) value).buildPartial());
                }
                return this;
            }
            this.builder.setField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor field) {
            this.builder.clearField(field);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            if (value instanceof MessageLite.Builder) {
                value = ((MessageLite.Builder) value).buildPartial();
            }
            this.builder.setRepeatedField(field, index, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            if (value instanceof MessageLite.Builder) {
                value = ((MessageLite.Builder) value).buildPartial();
            }
            this.builder.addRepeatedField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor oneof) {
            return this.builder.hasOneof(oneof);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor oneof) {
            this.builder.clearOneof(oneof);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof) {
            return this.builder.getOneofFieldDescriptor(oneof);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.MESSAGE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry registry, String name) {
            return registry.findImmutableExtensionByName(name);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry registry, Descriptors.Descriptor containingType, int fieldNumber) {
            return registry.findImmutableExtensionByNumber(containingType, fieldNumber);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message.Builder builderNewBuilderForField;
            Message message;
            if (defaultInstance != null) {
                builderNewBuilderForField = defaultInstance.newBuilderForType();
            } else {
                builderNewBuilderForField = this.builder.newBuilderForField(field);
            }
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                builderNewBuilderForField.mergeFrom(message);
            }
            input.readGroup(field.getNumber(), builderNewBuilderForField, extensionRegistry);
            return builderNewBuilderForField.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message.Builder builderNewBuilderForField;
            Message message;
            if (defaultInstance != null) {
                builderNewBuilderForField = defaultInstance.newBuilderForType();
            } else {
                builderNewBuilderForField = this.builder.newBuilderForField(field);
            }
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                builderNewBuilderForField.mergeFrom(message);
            }
            input.readMessage(builderNewBuilderForField, extensionRegistry);
            return builderNewBuilderForField.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString bytes, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message.Builder builderNewBuilderForField;
            Message message;
            if (defaultInstance != null) {
                builderNewBuilderForField = defaultInstance.newBuilderForType();
            } else {
                builderNewBuilderForField = this.builder.newBuilderForField(field);
            }
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                builderNewBuilderForField.mergeFrom(message);
            }
            builderNewBuilderForField.mergeFrom(bytes, extensionRegistry);
            return builderNewBuilderForField.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message.Builder builderNewMessageFieldInstance;
            if (!field.isRepeated()) {
                if (hasField(field)) {
                    Message.Builder fieldBuilder = getFieldBuilder(field);
                    if (fieldBuilder != null) {
                        input.readGroup(field.getNumber(), fieldBuilder, extensionRegistry);
                        return;
                    } else {
                        builderNewMessageFieldInstance = newMessageFieldInstance(field, defaultInstance);
                        builderNewMessageFieldInstance.mergeFrom((Message) getField(field));
                    }
                } else {
                    builderNewMessageFieldInstance = newMessageFieldInstance(field, defaultInstance);
                }
                input.readGroup(field.getNumber(), builderNewMessageFieldInstance, extensionRegistry);
                setField(field, builderNewMessageFieldInstance.buildPartial());
                return;
            }
            Message.Builder builderNewMessageFieldInstance2 = newMessageFieldInstance(field, defaultInstance);
            input.readGroup(field.getNumber(), builderNewMessageFieldInstance2, extensionRegistry);
            addRepeatedField(field, builderNewMessageFieldInstance2.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message.Builder builderNewMessageFieldInstance;
            if (!field.isRepeated()) {
                if (hasField(field)) {
                    Message.Builder fieldBuilder = getFieldBuilder(field);
                    if (fieldBuilder != null) {
                        input.readMessage(fieldBuilder, extensionRegistry);
                        return;
                    } else {
                        builderNewMessageFieldInstance = newMessageFieldInstance(field, defaultInstance);
                        builderNewMessageFieldInstance.mergeFrom((Message) getField(field));
                    }
                } else {
                    builderNewMessageFieldInstance = newMessageFieldInstance(field, defaultInstance);
                }
                input.readMessage(builderNewMessageFieldInstance, extensionRegistry);
                setField(field, builderNewMessageFieldInstance.buildPartial());
                return;
            }
            Message.Builder builderNewMessageFieldInstance2 = newMessageFieldInstance(field, defaultInstance);
            input.readMessage(builderNewMessageFieldInstance2, extensionRegistry);
            addRepeatedField(field, builderNewMessageFieldInstance2.buildPartial());
        }

        private Message.Builder newMessageFieldInstance(Descriptors.FieldDescriptor field, Message defaultInstance) {
            if (defaultInstance != null) {
                return defaultInstance.newBuilderForType();
            }
            return this.builder.newBuilderForField(field);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor field, Message defaultInstance) {
            Message message;
            Message.Builder fieldBuilder;
            if (!field.isRepeated() && hasField(field) && (fieldBuilder = getFieldBuilder(field)) != null) {
                return new BuilderAdapter(fieldBuilder);
            }
            Message.Builder builderNewMessageFieldInstance = newMessageFieldInstance(field, defaultInstance);
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                builderNewMessageFieldInstance.mergeFrom(message);
            }
            return new BuilderAdapter(builderNewMessageFieldInstance);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor field, Message defaultInstance) {
            Message.Builder builderNewBuilderForField;
            if (defaultInstance != null) {
                builderNewBuilderForField = defaultInstance.newBuilderForType();
            } else {
                builderNewBuilderForField = this.builder.newBuilderForField(field);
            }
            return new BuilderAdapter(builderNewBuilderForField);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor descriptor) {
            if (descriptor.needsUtf8Check()) {
                return WireFormat.Utf8Validation.STRICT;
            }
            if (!descriptor.isRepeated() && (this.builder instanceof GeneratedMessage.Builder)) {
                return WireFormat.Utf8Validation.LAZY;
            }
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object finish() {
            return this.builder;
        }
    }

    static class ExtensionAdapter implements MergeTarget {
        private final FieldSet<Descriptors.FieldDescriptor> extensions;

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor oneof) {
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof) {
            return null;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor oneof) {
            return false;
        }

        ExtensionAdapter(FieldSet<Descriptors.FieldDescriptor> extensions) {
            this.extensions = extensions;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.Descriptor getDescriptorForType() {
            throw new UnsupportedOperationException("getDescriptorForType() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object getField(Descriptors.FieldDescriptor field) {
            return this.extensions.getField(field);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor field) {
            return this.extensions.hasField(field);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor field, Object value) {
            this.extensions.setField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor field) {
            this.extensions.clearField(field);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            this.extensions.setRepeatedField(field, index, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            this.extensions.addRepeatedField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.EXTENSION_SET;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry registry, String name) {
            return registry.findImmutableExtensionByName(name);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry registry, Descriptors.Descriptor containingType, int fieldNumber) {
            return registry.findImmutableExtensionByNumber(containingType, fieldNumber);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream input, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message message;
            Message.Builder builderNewBuilderForType = defaultInstance.newBuilderForType();
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                builderNewBuilderForType.mergeFrom(message);
            }
            input.readGroup(field.getNumber(), builderNewBuilderForType, registry);
            return builderNewBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream input, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message message;
            Message.Builder builderNewBuilderForType = defaultInstance.newBuilderForType();
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                builderNewBuilderForType.mergeFrom(message);
            }
            input.readMessage(builderNewBuilderForType, registry);
            return builderNewBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            if (!field.isRepeated()) {
                if (hasField(field)) {
                    MessageLite.Builder builder = ((MessageLite) getField(field)).toBuilder();
                    input.readGroup(field.getNumber(), builder, extensionRegistry);
                    setField(field, builder.buildPartial());
                    return;
                } else {
                    Message.Builder builderNewBuilderForType = defaultInstance.newBuilderForType();
                    input.readGroup(field.getNumber(), builderNewBuilderForType, extensionRegistry);
                    setField(field, builderNewBuilderForType.buildPartial());
                    return;
                }
            }
            Message.Builder builderNewBuilderForType2 = defaultInstance.newBuilderForType();
            input.readGroup(field.getNumber(), builderNewBuilderForType2, extensionRegistry);
            addRepeatedField(field, builderNewBuilderForType2.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            if (!field.isRepeated()) {
                if (hasField(field)) {
                    MessageLite.Builder builder = ((MessageLite) getField(field)).toBuilder();
                    input.readMessage(builder, extensionRegistry);
                    setField(field, builder.buildPartial());
                    return;
                } else {
                    Message.Builder builderNewBuilderForType = defaultInstance.newBuilderForType();
                    input.readMessage(builderNewBuilderForType, extensionRegistry);
                    setField(field, builderNewBuilderForType.buildPartial());
                    return;
                }
            }
            Message.Builder builderNewBuilderForType2 = defaultInstance.newBuilderForType();
            input.readMessage(builderNewBuilderForType2, extensionRegistry);
            addRepeatedField(field, builderNewBuilderForType2.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString bytes, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message message;
            Message.Builder builderNewBuilderForType = defaultInstance.newBuilderForType();
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                builderNewBuilderForType.mergeFrom(message);
            }
            builderNewBuilderForType.mergeFrom(bytes, registry);
            return builderNewBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor descriptor, Message defaultInstance) {
            throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor descriptor, Message defaultInstance) {
            throw new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor descriptor) {
            if (descriptor.needsUtf8Check()) {
                return WireFormat.Utf8Validation.STRICT;
            }
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object finish() {
            throw new UnsupportedOperationException("finish() called on FieldSet object");
        }
    }

    static class ExtensionBuilderAdapter implements MergeTarget {
        private final FieldSet.Builder<Descriptors.FieldDescriptor> extensions;

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearOneof(Descriptors.OneofDescriptor oneof) {
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof) {
            return null;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasOneof(Descriptors.OneofDescriptor oneof) {
            return false;
        }

        ExtensionBuilderAdapter(FieldSet.Builder<Descriptors.FieldDescriptor> extensions) {
            this.extensions = extensions;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Descriptors.Descriptor getDescriptorForType() {
            throw new UnsupportedOperationException("getDescriptorForType() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object getField(Descriptors.FieldDescriptor field) {
            return this.extensions.getField(field);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public boolean hasField(Descriptors.FieldDescriptor field) {
            return this.extensions.hasField(field);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setField(Descriptors.FieldDescriptor field, Object value) {
            this.extensions.setField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget clearField(Descriptors.FieldDescriptor field) {
            this.extensions.clearField(field);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            this.extensions.setRepeatedField(field, index, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            this.extensions.addRepeatedField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget.ContainerType getContainerType() {
            return MergeTarget.ContainerType.EXTENSION_SET;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry registry, String name) {
            return registry.findImmutableExtensionByName(name);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry registry, Descriptors.Descriptor containingType, int fieldNumber) {
            return registry.findImmutableExtensionByNumber(containingType, fieldNumber);
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseGroup(CodedInputStream input, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message message;
            Message.Builder builderNewBuilderForType = defaultInstance.newBuilderForType();
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                builderNewBuilderForType.mergeFrom(message);
            }
            input.readGroup(field.getNumber(), builderNewBuilderForType, registry);
            return builderNewBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessage(CodedInputStream input, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message message;
            Message.Builder builderNewBuilderForType = defaultInstance.newBuilderForType();
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                builderNewBuilderForType.mergeFrom(message);
            }
            input.readMessage(builderNewBuilderForType, registry);
            return builderNewBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeGroup(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            MessageLite.Builder builder;
            if (!field.isRepeated()) {
                if (hasField(field)) {
                    Object fieldAllowBuilders = this.extensions.getFieldAllowBuilders(field);
                    if (fieldAllowBuilders instanceof MessageLite.Builder) {
                        builder = (MessageLite.Builder) fieldAllowBuilders;
                    } else {
                        builder = ((MessageLite) fieldAllowBuilders).toBuilder();
                        this.extensions.setField(field, builder);
                    }
                    input.readGroup(field.getNumber(), builder, extensionRegistry);
                    return;
                }
                Message.Builder builderNewBuilderForType = defaultInstance.newBuilderForType();
                input.readGroup(field.getNumber(), builderNewBuilderForType, extensionRegistry);
                setField(field, builderNewBuilderForType);
                return;
            }
            Message.Builder builderNewBuilderForType2 = defaultInstance.newBuilderForType();
            input.readGroup(field.getNumber(), builderNewBuilderForType2, extensionRegistry);
            addRepeatedField(field, builderNewBuilderForType2.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public void mergeMessage(CodedInputStream input, ExtensionRegistryLite extensionRegistry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            MessageLite.Builder builder;
            if (!field.isRepeated()) {
                if (hasField(field)) {
                    Object fieldAllowBuilders = this.extensions.getFieldAllowBuilders(field);
                    if (fieldAllowBuilders instanceof MessageLite.Builder) {
                        builder = (MessageLite.Builder) fieldAllowBuilders;
                    } else {
                        builder = ((MessageLite) fieldAllowBuilders).toBuilder();
                        this.extensions.setField(field, builder);
                    }
                    input.readMessage(builder, extensionRegistry);
                    return;
                }
                Message.Builder builderNewBuilderForType = defaultInstance.newBuilderForType();
                input.readMessage(builderNewBuilderForType, extensionRegistry);
                setField(field, builderNewBuilderForType);
                return;
            }
            Message.Builder builderNewBuilderForType2 = defaultInstance.newBuilderForType();
            input.readMessage(builderNewBuilderForType2, extensionRegistry);
            addRepeatedField(field, builderNewBuilderForType2.buildPartial());
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object parseMessageFromBytes(ByteString bytes, ExtensionRegistryLite registry, Descriptors.FieldDescriptor field, Message defaultInstance) throws IOException {
            Message message;
            Message.Builder builderNewBuilderForType = defaultInstance.newBuilderForType();
            if (!field.isRepeated() && (message = (Message) getField(field)) != null) {
                builderNewBuilderForType.mergeFrom(message);
            }
            builderNewBuilderForType.mergeFrom(bytes, registry);
            return builderNewBuilderForType.buildPartial();
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor descriptor, Message defaultInstance) {
            throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor descriptor, Message defaultInstance) {
            throw new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor descriptor) {
            if (descriptor.needsUtf8Check()) {
                return WireFormat.Utf8Validation.STRICT;
            }
            return WireFormat.Utf8Validation.LOOSE;
        }

        @Override // com.google.protobuf.MessageReflection.MergeTarget
        public Object finish() {
            throw new UnsupportedOperationException("finish() called on FieldSet object");
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006b  */
    /* JADX WARN: Code duplicated, block: B:29:0x006f  */
    static boolean mergeFieldFrom(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, Descriptors.Descriptor type, MergeTarget target, int tag) throws IOException {
        Message message;
        boolean z;
        Object objFindValueByNumberCreatingIfUnknown;
        ExtensionRegistry.ExtensionInfo extensionInfoFindExtensionByNumber;
        if (type.getOptions().getMessageSetWireFormat() && tag == WireFormat.MESSAGE_SET_ITEM_TAG) {
            mergeMessageSetExtensionFromCodedStream(input, unknownFields, extensionRegistry, type, target);
            return true;
        }
        int tagWireType = WireFormat.getTagWireType(tag);
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        Descriptors.FieldDescriptor fieldDescriptorFindFieldByNumber = null;
        if (type.isExtensionNumber(tagFieldNumber)) {
            if (!(extensionRegistry instanceof ExtensionRegistry) || (extensionInfoFindExtensionByNumber = target.findExtensionByNumber((ExtensionRegistry) extensionRegistry, type, tagFieldNumber)) == null) {
                message = null;
            } else {
                Descriptors.FieldDescriptor fieldDescriptor = extensionInfoFindExtensionByNumber.descriptor;
                Message message2 = extensionInfoFindExtensionByNumber.defaultInstance;
                if (message2 == null && fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    throw new IllegalStateException("Message-typed extension lacked default instance: " + fieldDescriptor.getFullName());
                }
                message = message2;
                fieldDescriptorFindFieldByNumber = fieldDescriptor;
            }
        } else if (target.getContainerType() == MergeTarget.ContainerType.MESSAGE) {
            fieldDescriptorFindFieldByNumber = type.findFieldByNumber(tagFieldNumber);
            message = null;
        } else {
            message = null;
        }
        boolean z2 = false;
        if (fieldDescriptorFindFieldByNumber == null) {
            z = false;
            z2 = true;
        } else if (tagWireType == FieldSet.getWireFormatForFieldType(fieldDescriptorFindFieldByNumber.getLiteType(), false)) {
            z = false;
        } else if (fieldDescriptorFindFieldByNumber.isPackable() && tagWireType == FieldSet.getWireFormatForFieldType(fieldDescriptorFindFieldByNumber.getLiteType(), true)) {
            z = true;
        } else {
            z = false;
            z2 = true;
        }
        if (z2) {
            if (unknownFields != null) {
                return unknownFields.mergeFieldFrom(tag, input);
            }
            return input.skipField(tag);
        }
        if (z) {
            int iPushLimit = input.pushLimit(input.readRawVarint32());
            if (fieldDescriptorFindFieldByNumber.getLiteType() == WireFormat.FieldType.ENUM) {
                while (input.getBytesUntilLimit() > 0) {
                    int i = input.readEnum();
                    if (fieldDescriptorFindFieldByNumber.legacyEnumFieldTreatedAsClosed()) {
                        Descriptors.EnumValueDescriptor enumValueDescriptorFindValueByNumber = fieldDescriptorFindFieldByNumber.getEnumType().findValueByNumber(i);
                        if (enumValueDescriptorFindValueByNumber != null) {
                            target.addRepeatedField(fieldDescriptorFindFieldByNumber, enumValueDescriptorFindValueByNumber);
                        } else if (unknownFields != null) {
                            unknownFields.mergeVarintField(tagFieldNumber, i);
                        }
                    } else {
                        target.addRepeatedField(fieldDescriptorFindFieldByNumber, fieldDescriptorFindFieldByNumber.getEnumType().findValueByNumberCreatingIfUnknown(i));
                    }
                }
            } else {
                while (input.getBytesUntilLimit() > 0) {
                    target.addRepeatedField(fieldDescriptorFindFieldByNumber, WireFormat.readPrimitiveField(input, fieldDescriptorFindFieldByNumber.getLiteType(), target.getUtf8Validation(fieldDescriptorFindFieldByNumber)));
                }
            }
            input.popLimit(iPushLimit);
        } else {
            int i2 = AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[fieldDescriptorFindFieldByNumber.getType().ordinal()];
            if (i2 == 1) {
                target.mergeGroup(input, extensionRegistry, fieldDescriptorFindFieldByNumber, message);
                return true;
            }
            if (i2 == 2) {
                target.mergeMessage(input, extensionRegistry, fieldDescriptorFindFieldByNumber, message);
                return true;
            }
            if (i2 == 3) {
                int i3 = input.readEnum();
                if (fieldDescriptorFindFieldByNumber.legacyEnumFieldTreatedAsClosed()) {
                    Descriptors.EnumValueDescriptor enumValueDescriptorFindValueByNumber2 = fieldDescriptorFindFieldByNumber.getEnumType().findValueByNumber(i3);
                    if (enumValueDescriptorFindValueByNumber2 == null) {
                        if (unknownFields != null) {
                            unknownFields.mergeVarintField(tagFieldNumber, i3);
                        }
                        return true;
                    }
                    objFindValueByNumberCreatingIfUnknown = enumValueDescriptorFindValueByNumber2;
                } else {
                    objFindValueByNumberCreatingIfUnknown = fieldDescriptorFindFieldByNumber.getEnumType().findValueByNumberCreatingIfUnknown(i3);
                }
            } else {
                objFindValueByNumberCreatingIfUnknown = WireFormat.readPrimitiveField(input, fieldDescriptorFindFieldByNumber.getLiteType(), target.getUtf8Validation(fieldDescriptorFindFieldByNumber));
            }
            if (fieldDescriptorFindFieldByNumber.isRepeated()) {
                target.addRepeatedField(fieldDescriptorFindFieldByNumber, objFindValueByNumberCreatingIfUnknown);
            } else {
                target.setField(fieldDescriptorFindFieldByNumber, objFindValueByNumberCreatingIfUnknown);
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: com.google.protobuf.MessageReflection$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static void mergeMessageFrom(Message.Builder target, UnknownFieldSet.Builder unknownFields, CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        BuilderAdapter builderAdapter = new BuilderAdapter(target);
        Descriptors.Descriptor descriptorForType = target.getDescriptorForType();
        while (true) {
            int tag = input.readTag();
            if (tag == 0) {
                return;
            }
            UnknownFieldSet.Builder builder = unknownFields;
            CodedInputStream codedInputStream = input;
            ExtensionRegistryLite extensionRegistryLite = extensionRegistry;
            if (!mergeFieldFrom(codedInputStream, builder, extensionRegistryLite, descriptorForType, builderAdapter, tag)) {
                return;
            }
            input = codedInputStream;
            unknownFields = builder;
            extensionRegistry = extensionRegistryLite;
        }
    }

    private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, Descriptors.Descriptor type, MergeTarget target) throws IOException {
        int uInt32 = 0;
        ByteString bytes = null;
        ExtensionRegistry.ExtensionInfo extensionInfoFindExtensionByNumber = null;
        while (true) {
            int tag = input.readTag();
            if (tag == 0) {
                break;
            }
            if (tag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                uInt32 = input.readUInt32();
                if (uInt32 != 0 && (extensionRegistry instanceof ExtensionRegistry)) {
                    extensionInfoFindExtensionByNumber = target.findExtensionByNumber((ExtensionRegistry) extensionRegistry, type, uInt32);
                }
            } else if (tag == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                if (uInt32 != 0 && extensionInfoFindExtensionByNumber != null && ExtensionRegistryLite.isEagerlyParseMessageSets()) {
                    eagerlyMergeMessageSetExtension(input, extensionInfoFindExtensionByNumber, extensionRegistry, target);
                    bytes = null;
                } else {
                    bytes = input.readBytes();
                }
            } else if (!input.skipField(tag)) {
                break;
            }
        }
        input.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
        if (bytes == null || uInt32 == 0) {
            return;
        }
        if (extensionInfoFindExtensionByNumber != null) {
            mergeMessageSetExtensionFromBytes(bytes, extensionInfoFindExtensionByNumber, extensionRegistry, target);
        } else {
            if (bytes == null || unknownFields == null) {
                return;
            }
            unknownFields.mergeField(uInt32, UnknownFieldSet.Field.newBuilder().addLengthDelimited(bytes).build());
        }
    }

    private static void mergeMessageSetExtensionFromBytes(ByteString rawBytes, ExtensionRegistry.ExtensionInfo extension, ExtensionRegistryLite extensionRegistry, MergeTarget target) throws IOException {
        Descriptors.FieldDescriptor fieldDescriptor = extension.descriptor;
        if (target.hasField(fieldDescriptor) || ExtensionRegistryLite.isEagerlyParseMessageSets()) {
            target.setField(fieldDescriptor, target.parseMessageFromBytes(rawBytes, extensionRegistry, fieldDescriptor, extension.defaultInstance));
        } else {
            target.setField(fieldDescriptor, new LazyField(extension.defaultInstance, extensionRegistry, rawBytes));
        }
    }

    private static void eagerlyMergeMessageSetExtension(CodedInputStream input, ExtensionRegistry.ExtensionInfo extension, ExtensionRegistryLite extensionRegistry, MergeTarget target) throws IOException {
        Descriptors.FieldDescriptor fieldDescriptor = extension.descriptor;
        target.setField(fieldDescriptor, target.parseMessage(input, extensionRegistry, fieldDescriptor, extension.defaultInstance));
    }
}
