package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class Option extends GeneratedMessage implements OptionOrBuilder {
    private static final Option DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static final Parser<Option> PARSER;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private Any value_;

    /* synthetic */ Option(GeneratedMessage.Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    static /* synthetic */ int access$576(Option option, int i) {
        int i2 = i | option.bitField0_;
        option.bitField0_ = i2;
        return i2;
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Option.class.getName());
        DEFAULT_INSTANCE = new Option();
        PARSER = new AnonymousClass1();
    }

    private Option(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.name_ = "";
        this.memoizedIsInitialized = (byte) -1;
    }

    private Option() {
        this.name_ = "";
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return TypeProto.internal_static_google_protobuf_Option_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Builder.class);
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public Any getValue() {
        Any any = this.value_;
        return any == null ? Any.getDefaultInstance() : any;
    }

    @Override // com.google.protobuf.OptionOrBuilder
    public AnyOrBuilder getValueOrBuilder() {
        Any any = this.value_;
        return any == null ? Any.getDefaultInstance() : any;
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
        if (!GeneratedMessage.isStringEmpty(this.name_)) {
            GeneratedMessage.writeString(output, 1, this.name_);
        }
        if ((this.bitField0_ & 1) != 0) {
            output.writeMessage(2, getValue());
        }
        getUnknownFields().writeTo(output);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeStringSize = !GeneratedMessage.isStringEmpty(this.name_) ? GeneratedMessage.computeStringSize(1, this.name_) : 0;
        if ((1 & this.bitField0_) != 0) {
            iComputeStringSize += CodedOutputStream.computeMessageSize(2, getValue());
        }
        int serializedSize = iComputeStringSize + getUnknownFields().getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Option)) {
            return super.equals(obj);
        }
        Option option = (Option) obj;
        if (getName().equals(option.getName()) && hasValue() == option.hasValue()) {
            return (!hasValue() || getValue().equals(option.getValue())) && getUnknownFields().equals(option.getUnknownFields());
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (hasValue()) {
            iHashCode = (((iHashCode * 37) + 2) * 53) + getValue().hashCode();
        }
        int iHashCode2 = (iHashCode * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    public static Option parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Option parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Option parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Option parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Option parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Option parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Option parseFrom(InputStream input) throws IOException {
        return (Option) GeneratedMessage.parseWithIOException(PARSER, input);
    }

    public static Option parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Option) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Option parseDelimitedFrom(InputStream input) throws IOException {
        return (Option) GeneratedMessage.parseDelimitedWithIOException(PARSER, input);
    }

    public static Option parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Option) GeneratedMessage.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static Option parseFrom(CodedInputStream input) throws IOException {
        return (Option) GeneratedMessage.parseWithIOException(PARSER, input);
    }

    public static Option parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Option) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Option prototype) {
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

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements OptionOrBuilder {
        private int bitField0_;
        private Object name_;
        private SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> valueBuilder_;
        private Any value_;

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
            return TypeProto.internal_static_google_protobuf_Option_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable.ensureFieldAccessorsInitialized(Option.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent parent) {
            super(parent);
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders) {
                getValueFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.name_ = "";
            this.value_ = null;
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> singleFieldBuilder = this.valueBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.valueBuilder_ = null;
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return TypeProto.internal_static_google_protobuf_Option_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Option getDefaultInstanceForType() {
            return Option.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Option build() {
            Option optionBuildPartial = buildPartial();
            if (optionBuildPartial.isInitialized()) {
                return optionBuildPartial;
            }
            throw newUninitializedMessageException((Message) optionBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Option buildPartial() {
            Option option = new Option(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(option);
            }
            onBuilt();
            return option;
        }

        private void buildPartial0(Option result) {
            int i;
            Any any;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                result.name_ = this.name_;
            }
            if ((i2 & 2) != 0) {
                SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> singleFieldBuilder = this.valueBuilder_;
                if (singleFieldBuilder == null) {
                    any = this.value_;
                } else {
                    any = (Any) singleFieldBuilder.build();
                }
                result.value_ = any;
                i = 1;
            } else {
                i = 0;
            }
            Option.access$576(result, i);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message other) {
            if (other instanceof Option) {
                return mergeFrom((Option) other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(Option other) {
            if (other == Option.getDefaultInstance()) {
                return this;
            }
            if (!other.getName().isEmpty()) {
                this.name_ = other.name_;
                this.bitField0_ |= 1;
                onChanged();
            }
            if (other.hasValue()) {
                mergeValue(other.getValue());
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
                                this.name_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 1;
                            } else if (tag == 18) {
                                input.readMessage(getValueFieldBuilder().getBuilder(), extensionRegistry);
                                this.bitField0_ |= 2;
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

        @Override // com.google.protobuf.OptionOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setName(String value) {
            value.getClass();
            this.name_ = value;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Option.getDefaultInstance().getName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            value.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(value);
            this.name_ = value;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public boolean hasValue() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public Any getValue() {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> singleFieldBuilder = this.valueBuilder_;
            if (singleFieldBuilder == null) {
                Any any = this.value_;
                return any == null ? Any.getDefaultInstance() : any;
            }
            return (Any) singleFieldBuilder.getMessage();
        }

        public Builder setValue(Any value) {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> singleFieldBuilder = this.valueBuilder_;
            if (singleFieldBuilder == null) {
                value.getClass();
                this.value_ = value;
            } else {
                singleFieldBuilder.setMessage(value);
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setValue(Any.Builder builderForValue) {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> singleFieldBuilder = this.valueBuilder_;
            if (singleFieldBuilder == null) {
                this.value_ = builderForValue.build();
            } else {
                singleFieldBuilder.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder mergeValue(Any value) {
            Any any;
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> singleFieldBuilder = this.valueBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 2) != 0 && (any = this.value_) != null && any != Any.getDefaultInstance()) {
                    getValueBuilder().mergeFrom(value);
                } else {
                    this.value_ = value;
                }
            } else {
                singleFieldBuilder.mergeFrom(value);
            }
            if (this.value_ != null) {
                this.bitField0_ |= 2;
                onChanged();
            }
            return this;
        }

        public Builder clearValue() {
            this.bitField0_ &= -3;
            this.value_ = null;
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> singleFieldBuilder = this.valueBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.valueBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Any.Builder getValueBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (Any.Builder) getValueFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.OptionOrBuilder
        public AnyOrBuilder getValueOrBuilder() {
            SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> singleFieldBuilder = this.valueBuilder_;
            if (singleFieldBuilder != null) {
                return (AnyOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Any any = this.value_;
            return any == null ? Any.getDefaultInstance() : any;
        }

        private SingleFieldBuilder<Any, Any.Builder, AnyOrBuilder> getValueFieldBuilder() {
            if (this.valueBuilder_ == null) {
                this.valueBuilder_ = new SingleFieldBuilder<>(getValue(), getParentForChildren(), isClean());
                this.value_ = null;
            }
            return this.valueBuilder_;
        }
    }

    public static Option getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: com.google.protobuf.Option$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Option> {
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
        public Option parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Option.newBuilder();
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

    public static Parser<Option> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Option> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Option getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
