package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ListValue extends GeneratedMessage implements ListValueOrBuilder {
    private static final ListValue DEFAULT_INSTANCE;
    private static final Parser<ListValue> PARSER;
    public static final int VALUES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private List<Value> values_;

    /* synthetic */ ListValue(GeneratedMessage.Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", ListValue.class.getName());
        DEFAULT_INSTANCE = new ListValue();
        PARSER = new AnonymousClass1();
    }

    private ListValue(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private ListValue() {
        this.memoizedIsInitialized = (byte) -1;
        this.values_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_ListValue_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(ListValue.class, Builder.class);
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public List<Value> getValuesList() {
        return this.values_;
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
        return this.values_;
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public int getValuesCount() {
        return this.values_.size();
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public Value getValues(int index) {
        return this.values_.get(index);
    }

    @Override // com.google.protobuf.ListValueOrBuilder
    public ValueOrBuilder getValuesOrBuilder(int index) {
        return this.values_.get(index);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream output) throws IOException {
        for (int i = 0; i < this.values_.size(); i++) {
            output.writeMessage(1, this.values_.get(i));
        }
        getUnknownFields().writeTo(output);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = 0;
        for (int i2 = 0; i2 < this.values_.size(); i2++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.values_.get(i2));
        }
        int serializedSize = iComputeMessageSize + getUnknownFields().getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListValue)) {
            return super.equals(obj);
        }
        ListValue listValue = (ListValue) obj;
        return getValuesList().equals(listValue.getValuesList()) && getUnknownFields().equals(listValue.getUnknownFields());
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = 779 + getDescriptor().hashCode();
        if (getValuesCount() > 0) {
            iHashCode = (((iHashCode * 37) + 1) * 53) + getValuesList().hashCode();
        }
        int iHashCode2 = (iHashCode * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    public static ListValue parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static ListValue parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static ListValue parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static ListValue parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static ListValue parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static ListValue parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static ListValue parseFrom(InputStream input) throws IOException {
        return (ListValue) GeneratedMessage.parseWithIOException(PARSER, input);
    }

    public static ListValue parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListValue) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static ListValue parseDelimitedFrom(InputStream input) throws IOException {
        return (ListValue) GeneratedMessage.parseDelimitedWithIOException(PARSER, input);
    }

    public static ListValue parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListValue) GeneratedMessage.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static ListValue parseFrom(CodedInputStream input) throws IOException {
        return (ListValue) GeneratedMessage.parseWithIOException(PARSER, input);
    }

    public static ListValue parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ListValue) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListValue prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((AnonymousClass1) null) : new Builder((AnonymousClass1) null).mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent parent) {
        return new Builder(parent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ListValueOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> valuesBuilder_;
        private List<Value> values_;

        private void buildPartial0(ListValue result) {
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, AnonymousClass1 anonymousClass1) {
            this(builderParent);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StructProto.internal_static_google_protobuf_ListValue_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable.ensureFieldAccessorsInitialized(ListValue.class, Builder.class);
        }

        private Builder() {
            this.values_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent parent) {
            super(parent);
            this.values_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.values_ = Collections.emptyList();
            } else {
                this.values_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return StructProto.internal_static_google_protobuf_ListValue_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ListValue getDefaultInstanceForType() {
            return ListValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ListValue build() {
            ListValue listValueBuildPartial = buildPartial();
            if (listValueBuildPartial.isInitialized()) {
                return listValueBuildPartial;
            }
            throw newUninitializedMessageException((Message) listValueBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ListValue buildPartial() {
            ListValue listValue = new ListValue(this, null);
            buildPartialRepeatedFields(listValue);
            if (this.bitField0_ != 0) {
                buildPartial0(listValue);
            }
            onBuilt();
            return listValue;
        }

        private void buildPartialRepeatedFields(ListValue result) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder != null) {
                result.values_ = repeatedFieldBuilder.build();
                return;
            }
            if ((this.bitField0_ & 1) != 0) {
                this.values_ = Collections.unmodifiableList(this.values_);
                this.bitField0_ &= -2;
            }
            result.values_ = this.values_;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message other) {
            if (other instanceof ListValue) {
                return mergeFrom((ListValue) other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(ListValue other) {
            if (other == ListValue.getDefaultInstance()) {
                return this;
            }
            if (this.valuesBuilder_ == null) {
                if (!other.values_.isEmpty()) {
                    if (this.values_.isEmpty()) {
                        this.values_ = other.values_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureValuesIsMutable();
                        this.values_.addAll(other.values_);
                    }
                    onChanged();
                }
            } else if (!other.values_.isEmpty()) {
                if (!this.valuesBuilder_.isEmpty()) {
                    this.valuesBuilder_.addAllMessages(other.values_);
                } else {
                    this.valuesBuilder_.dispose();
                    this.valuesBuilder_ = null;
                    this.values_ = other.values_;
                    this.bitField0_ &= -2;
                    this.valuesBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getValuesFieldBuilder() : null;
                }
            }
            mergeUnknownFields(other.getUnknownFields());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            extensionRegistry.getClass();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = input.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                Value value = (Value) input.readMessage(Value.parser(), extensionRegistry);
                                RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
                                if (repeatedFieldBuilder == null) {
                                    ensureValuesIsMutable();
                                    this.values_.add(value);
                                } else {
                                    repeatedFieldBuilder.addMessage(value);
                                }
                            } else if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    onChanged();
                    throw th;
                }
            }
            onChanged();
            return this;
        }

        private void ensureValuesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.values_ = new ArrayList(this.values_);
                this.bitField0_ |= 1;
            }
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public List<Value> getValuesList() {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.values_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public int getValuesCount() {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.values_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public Value getValues(int index) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.values_.get(index);
            }
            return (Value) repeatedFieldBuilder.getMessage(index);
        }

        public Builder setValues(int index, Value value) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                value.getClass();
                ensureValuesIsMutable();
                this.values_.set(index, value);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(index, value);
            return this;
        }

        public Builder setValues(int index, Value.Builder builderForValue) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureValuesIsMutable();
                this.values_.set(index, builderForValue.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(index, builderForValue.build());
            return this;
        }

        public Builder addValues(Value value) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                value.getClass();
                ensureValuesIsMutable();
                this.values_.add(value);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(value);
            return this;
        }

        public Builder addValues(int index, Value value) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                value.getClass();
                ensureValuesIsMutable();
                this.values_.add(index, value);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(index, value);
            return this;
        }

        public Builder addValues(Value.Builder builderForValue) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureValuesIsMutable();
                this.values_.add(builderForValue.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builderForValue.build());
            return this;
        }

        public Builder addValues(int index, Value.Builder builderForValue) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureValuesIsMutable();
                this.values_.add(index, builderForValue.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(index, builderForValue.build());
            return this;
        }

        public Builder addAllValues(Iterable<? extends Value> values) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureValuesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.values_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(values);
            return this;
        }

        public Builder clearValues() {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.values_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeValues(int index) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureValuesIsMutable();
                this.values_.remove(index);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(index);
            return this;
        }

        public Value.Builder getValuesBuilder(int index) {
            return (Value.Builder) getValuesFieldBuilder().getBuilder(index);
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public ValueOrBuilder getValuesOrBuilder(int index) {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.values_.get(index);
            }
            return (ValueOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(index);
        }

        @Override // com.google.protobuf.ListValueOrBuilder
        public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
            RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.values_);
        }

        public Value.Builder addValuesBuilder() {
            return (Value.Builder) getValuesFieldBuilder().addBuilder(Value.getDefaultInstance());
        }

        public Value.Builder addValuesBuilder(int index) {
            return (Value.Builder) getValuesFieldBuilder().addBuilder(index, Value.getDefaultInstance());
        }

        public List<Value.Builder> getValuesBuilderList() {
            return getValuesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Value, Value.Builder, ValueOrBuilder> getValuesFieldBuilder() {
            if (this.valuesBuilder_ == null) {
                this.valuesBuilder_ = new RepeatedFieldBuilder<>(this.values_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.values_ = null;
            }
            return this.valuesBuilder_;
        }
    }

    public static ListValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: com.google.protobuf.ListValue$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<ListValue> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
            return super.parseDelimitedFrom(input);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parseDelimitedFrom(input, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return super.parseFrom(data);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parseFrom(data, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream input) throws InvalidProtocolBufferException {
            return super.parseFrom(input);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parseFrom(input, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(InputStream input) throws InvalidProtocolBufferException {
            return super.parseFrom(input);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parseFrom(input, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return super.parseFrom(data);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parseFrom(data, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return super.parseFrom(data);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
            return super.parseFrom(data, off, len);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parseFrom(data, off, len, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parseFrom(data, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
            return super.parsePartialDelimitedFrom(input);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parsePartialDelimitedFrom(input, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString data) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(data);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(data, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream input) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(input);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream input) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(input);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(input, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(data);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(data, off, len);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(data, off, len, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractParser, com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.parsePartialFrom(data, extensionRegistry);
        }

        @Override // com.google.protobuf.Parser
        public ListValue parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = ListValue.newBuilder();
            try {
                builderNewBuilder.mergeFrom(input, extensionRegistry);
                return builderNewBuilder.buildPartial();
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(builderNewBuilder.buildPartial());
            } catch (UninitializedMessageException e2) {
                throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(builderNewBuilder.buildPartial());
            } catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3).setUnfinishedMessage(builderNewBuilder.buildPartial());
            }
        }
    }

    public static Parser<ListValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ListValue> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ListValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
