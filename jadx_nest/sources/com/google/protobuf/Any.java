package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: loaded from: classes4.dex */
public final class Any extends GeneratedMessage implements AnyOrBuilder {
    private static final Any DEFAULT_INSTANCE;
    private static final Parser<Any> PARSER;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private volatile Message cachedUnpackValue;
    private byte memoizedIsInitialized;
    private volatile Object typeUrl_;
    private ByteString value_;

    /* synthetic */ Any(GeneratedMessage.Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Any.class.getName());
        DEFAULT_INSTANCE = new Any();
        PARSER = new AnonymousClass1();
    }

    private Any(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
        this.memoizedIsInitialized = (byte) -1;
    }

    private Any() {
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
        this.memoizedIsInitialized = (byte) -1;
        this.typeUrl_ = "";
        this.value_ = ByteString.EMPTY;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return AnyProto.internal_static_google_protobuf_Any_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Builder.class);
    }

    private static String getTypeUrl(String typeUrlPrefix, Descriptors.Descriptor descriptor) {
        if (!typeUrlPrefix.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            return typeUrlPrefix + InternalZipConstants.ZIP_FILE_SEPARATOR + descriptor.getFullName();
        }
        return typeUrlPrefix + descriptor.getFullName();
    }

    private static String getTypeNameFromTypeUrl(String typeUrl) {
        int iLastIndexOf = typeUrl.lastIndexOf(47);
        return iLastIndexOf == -1 ? "" : typeUrl.substring(iLastIndexOf + 1);
    }

    public static <T extends Message> Any pack(T message) {
        return newBuilder().setTypeUrl(getTypeUrl("type.googleapis.com", message.getDescriptorForType())).setValue(message.toByteString()).build();
    }

    public static <T extends Message> Any pack(T message, String typeUrlPrefix) {
        return newBuilder().setTypeUrl(getTypeUrl(typeUrlPrefix, message.getDescriptorForType())).setValue(message.toByteString()).build();
    }

    public <T extends Message> boolean is(Class<T> clazz) {
        return getTypeNameFromTypeUrl(getTypeUrl()).equals(((Message) Internal.getDefaultInstance(clazz)).getDescriptorForType().getFullName());
    }

    public boolean isSameTypeAs(Message message) {
        return getTypeNameFromTypeUrl(getTypeUrl()).equals(message.getDescriptorForType().getFullName());
    }

    public <T extends Message> T unpack(Class<T> cls) throws InvalidProtocolBufferException {
        if (this.cachedUnpackValue != null) {
            if (this.cachedUnpackValue.getClass() == cls) {
                return (T) this.cachedUnpackValue;
            }
        } else if (is(cls)) {
            T t = (T) ((Message) Internal.getDefaultInstance(cls)).getParserForType().parseFrom(getValue());
            this.cachedUnpackValue = t;
            return t;
        }
        throw new InvalidProtocolBufferException("Type of the Any message does not match the given class.");
    }

    public <T extends Message> T unpackSameTypeAs(T t) throws InvalidProtocolBufferException {
        if (this.cachedUnpackValue != null) {
            if (this.cachedUnpackValue.getClass() == t.getClass()) {
                return (T) this.cachedUnpackValue;
            }
        } else if (isSameTypeAs(t)) {
            T t2 = (T) t.getParserForType().parseFrom(getValue());
            this.cachedUnpackValue = t2;
            return t2;
        }
        throw new InvalidProtocolBufferException("Type of the Any message does not match the given exemplar.");
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public String getTypeUrl() {
        Object obj = this.typeUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.typeUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public ByteString getTypeUrlBytes() {
        Object obj = this.typeUrl_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.typeUrl_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.AnyOrBuilder
    public ByteString getValue() {
        return this.value_;
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
        if (!GeneratedMessage.isStringEmpty(this.typeUrl_)) {
            GeneratedMessage.writeString(output, 1, this.typeUrl_);
        }
        if (!this.value_.isEmpty()) {
            output.writeBytes(2, this.value_);
        }
        getUnknownFields().writeTo(output);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeStringSize = !GeneratedMessage.isStringEmpty(this.typeUrl_) ? GeneratedMessage.computeStringSize(1, this.typeUrl_) : 0;
        if (!this.value_.isEmpty()) {
            iComputeStringSize += CodedOutputStream.computeBytesSize(2, this.value_);
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
        if (!(obj instanceof Any)) {
            return super.equals(obj);
        }
        Any any = (Any) obj;
        return getTypeUrl().equals(any.getTypeUrl()) && getValue().equals(any.getValue()) && getUnknownFields().equals(any.getUnknownFields());
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getTypeUrl().hashCode()) * 37) + 2) * 53) + getValue().hashCode()) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    public static Any parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Any parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Any parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Any parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Any parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Any parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Any parseFrom(InputStream input) throws IOException {
        return (Any) GeneratedMessage.parseWithIOException(PARSER, input);
    }

    public static Any parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Any) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Any parseDelimitedFrom(InputStream input) throws IOException {
        return (Any) GeneratedMessage.parseDelimitedWithIOException(PARSER, input);
    }

    public static Any parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Any) GeneratedMessage.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static Any parseFrom(CodedInputStream input) throws IOException {
        return (Any) GeneratedMessage.parseWithIOException(PARSER, input);
    }

    public static Any parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Any) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Any prototype) {
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

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements AnyOrBuilder {
        private int bitField0_;
        private Object typeUrl_;
        private ByteString value_;

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
            return AnyProto.internal_static_google_protobuf_Any_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return AnyProto.internal_static_google_protobuf_Any_fieldAccessorTable.ensureFieldAccessorsInitialized(Any.class, Builder.class);
        }

        private Builder() {
            this.typeUrl_ = "";
            this.value_ = ByteString.EMPTY;
        }

        private Builder(AbstractMessage.BuilderParent parent) {
            super(parent);
            this.typeUrl_ = "";
            this.value_ = ByteString.EMPTY;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.typeUrl_ = "";
            this.value_ = ByteString.EMPTY;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return AnyProto.internal_static_google_protobuf_Any_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Any getDefaultInstanceForType() {
            return Any.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Any build() {
            Any anyBuildPartial = buildPartial();
            if (anyBuildPartial.isInitialized()) {
                return anyBuildPartial;
            }
            throw newUninitializedMessageException((Message) anyBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Any buildPartial() {
            Any any = new Any(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(any);
            }
            onBuilt();
            return any;
        }

        private void buildPartial0(Any result) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                result.typeUrl_ = this.typeUrl_;
            }
            if ((i & 2) != 0) {
                result.value_ = this.value_;
            }
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message other) {
            if (other instanceof Any) {
                return mergeFrom((Any) other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(Any other) {
            if (other == Any.getDefaultInstance()) {
                return this;
            }
            if (!other.getTypeUrl().isEmpty()) {
                this.typeUrl_ = other.typeUrl_;
                this.bitField0_ |= 1;
                onChanged();
            }
            if (other.getValue() != ByteString.EMPTY) {
                setValue(other.getValue());
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
                                this.typeUrl_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 1;
                            } else if (tag == 18) {
                                this.value_ = input.readBytes();
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

        @Override // com.google.protobuf.AnyOrBuilder
        public String getTypeUrl() {
            Object obj = this.typeUrl_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.typeUrl_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public ByteString getTypeUrlBytes() {
            Object obj = this.typeUrl_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.typeUrl_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setTypeUrl(String value) {
            value.getClass();
            this.typeUrl_ = value;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder clearTypeUrl() {
            this.typeUrl_ = Any.getDefaultInstance().getTypeUrl();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder setTypeUrlBytes(ByteString value) {
            value.getClass();
            AbstractMessageLite.checkByteStringIsUtf8(value);
            this.typeUrl_ = value;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AnyOrBuilder
        public ByteString getValue() {
            return this.value_;
        }

        public Builder setValue(ByteString value) {
            value.getClass();
            this.value_ = value;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder clearValue() {
            this.bitField0_ &= -3;
            this.value_ = Any.getDefaultInstance().getValue();
            onChanged();
            return this;
        }
    }

    public static Any getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: com.google.protobuf.Any$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Any> {
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
        public Any parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Any.newBuilder();
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

    public static Parser<Any> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Any> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Any getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
