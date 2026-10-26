package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* INFO: loaded from: classes4.dex */
public final class JavaFeaturesProto {
    public static final int JAVA_FIELD_NUMBER = 1001;
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_pb_JavaFeatures_descriptor;
    private static final GeneratedMessage.FieldAccessorTable internal_static_pb_JavaFeatures_fieldAccessorTable;
    public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.FeatureSet, JavaFeatures> java_;

    public interface JavaFeaturesOrBuilder extends MessageOrBuilder {
        boolean getLegacyClosedEnum();

        JavaFeatures.Utf8Validation getUtf8Validation();

        boolean hasLegacyClosedEnum();

        boolean hasUtf8Validation();
    }

    private JavaFeaturesProto() {
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", JavaFeaturesProto.class.getName());
        GeneratedMessage.GeneratedExtension<DescriptorProtos.FeatureSet, JavaFeatures> generatedExtensionNewFileScopedGeneratedExtension = GeneratedMessage.newFileScopedGeneratedExtension(JavaFeatures.class, JavaFeatures.getDefaultInstance());
        java_ = generatedExtensionNewFileScopedGeneratedExtension;
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#google/protobuf/java_features.proto\u0012\u0002pb\u001a google/protobuf/descriptor.proto\"\u0099\u0005\n\fJavaFeatures\u0012\u008e\u0002\n\u0012legacy_closed_enum\u0018\u0001 \u0001(\bBß\u0001\u0088\u0001\u0001\u0098\u0001\u0004\u0098\u0001\u0001¢\u0001\t\u0012\u0004true\u0018æ\u0007¢\u0001\n\u0012\u0005false\u0018ç\u0007²\u0001¹\u0001\bè\u0007\u0010è\u0007\u001a°\u0001The legacy closed enum treatment in Java is deprecated and is scheduled to be removed in edition 2025.  Mark enum type on the enum definitions themselves rather than on fields.R\u0010legacyClosedEnum\u0012¯\u0002\n\u000futf8_validation\u0018\u0002 \u0001(\u000e2\u001f.pb.JavaFeatures.Utf8ValidationBä\u0001\u0088\u0001\u0001\u0098\u0001\u0004\u0098\u0001\u0001¢\u0001\f\u0012\u0007DEFAULT\u0018æ\u0007²\u0001È\u0001\bè\u0007\u0010é\u0007\u001a¿\u0001The Java-specific utf8 validation feature is deprecated and is scheduled to be removed in edition 2025.  Utf8 validation behavior should use the global cross-language utf8_validation feature.R\u000eutf8Validation\"F\n\u000eUtf8Validation\u0012\u001b\n\u0017UTF8_VALIDATION_UNKNOWN\u0010\u0000\u0012\u000b\n\u0007DEFAULT\u0010\u0001\u0012\n\n\u0006VERIFY\u0010\u0002:B\n\u0004java\u0012\u001b.google.protobuf.FeatureSet\u0018é\u0007 \u0001(\u000b2\u0010.pb.JavaFeaturesR\u0004javaB(\n\u0013com.google.protobufB\u0011JavaFeaturesProto"}, new Descriptors.FileDescriptor[]{DescriptorProtos.getDescriptor()});
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_pb_JavaFeatures_descriptor = descriptor2;
        internal_static_pb_JavaFeatures_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(descriptor2, new String[]{"LegacyClosedEnum", "Utf8Validation"});
        generatedExtensionNewFileScopedGeneratedExtension.internalInit(descriptor.getExtensions().get(0));
        descriptor.resolveAllFeaturesImmutable();
        DescriptorProtos.getDescriptor();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add(java_);
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    public static final class JavaFeatures extends GeneratedMessage implements JavaFeaturesOrBuilder {
        private static final JavaFeatures DEFAULT_INSTANCE;
        public static final int LEGACY_CLOSED_ENUM_FIELD_NUMBER = 1;
        private static final Parser<JavaFeatures> PARSER;
        public static final int UTF8_VALIDATION_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean legacyClosedEnum_;
        private byte memoizedIsInitialized;
        private int utf8Validation_;

        /* synthetic */ JavaFeatures(GeneratedMessage.Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        static /* synthetic */ int access$776(JavaFeatures javaFeatures, int i) {
            int i2 = i | javaFeatures.bitField0_;
            javaFeatures.bitField0_ = i2;
            return i2;
        }

        static {
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", JavaFeatures.class.getName());
            DEFAULT_INSTANCE = new JavaFeatures();
            PARSER = new AnonymousClass1();
        }

        private JavaFeatures(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.legacyClosedEnum_ = false;
            this.utf8Validation_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        private JavaFeatures() {
            this.legacyClosedEnum_ = false;
            this.memoizedIsInitialized = (byte) -1;
            this.utf8Validation_ = 0;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return JavaFeaturesProto.internal_static_pb_JavaFeatures_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return JavaFeaturesProto.internal_static_pb_JavaFeatures_fieldAccessorTable.ensureFieldAccessorsInitialized(JavaFeatures.class, Builder.class);
        }

        public enum Utf8Validation implements ProtocolMessageEnum {
            UTF8_VALIDATION_UNKNOWN(0),
            DEFAULT(1),
            VERIFY(2);

            public static final int DEFAULT_VALUE = 1;
            public static final int UTF8_VALIDATION_UNKNOWN_VALUE = 0;
            private static final Utf8Validation[] VALUES;
            public static final int VERIFY_VALUE = 2;
            private static final Internal.EnumLiteMap<Utf8Validation> internalValueMap;
            private final int value;

            static {
                RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Utf8Validation.class.getName());
                internalValueMap = new AnonymousClass1();
                VALUES = values();
            }

            private static final class Utf8ValidationVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new Utf8ValidationVerifier();

                private Utf8ValidationVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int number) {
                    return Utf8Validation.forNumber(number) != null;
                }
            }

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Utf8Validation valueOf(int value) {
                return forNumber(value);
            }

            public static Utf8Validation forNumber(int value) {
                if (value == 0) {
                    return UTF8_VALIDATION_UNKNOWN;
                }
                if (value == 1) {
                    return DEFAULT;
                }
                if (value != 2) {
                    return null;
                }
                return VERIFY;
            }

            public static Internal.EnumLiteMap<Utf8Validation> internalGetValueMap() {
                return internalValueMap;
            }

            /* INFO: renamed from: com.google.protobuf.JavaFeaturesProto$JavaFeatures$Utf8Validation$1, reason: invalid class name */
            class AnonymousClass1 implements Internal.EnumLiteMap<Utf8Validation> {
                AnonymousClass1() {
                }

                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Utf8Validation findValueByNumber(int number) {
                    return Utf8Validation.forNumber(number);
                }
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                return getDescriptor().getValues().get(ordinal());
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return JavaFeatures.getDescriptor().getEnumTypes().get(0);
            }

            public static Utf8Validation valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            Utf8Validation(int value) {
                this.value = value;
            }
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean hasLegacyClosedEnum() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean getLegacyClosedEnum() {
            return this.legacyClosedEnum_;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean hasUtf8Validation() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public Utf8Validation getUtf8Validation() {
            Utf8Validation utf8ValidationForNumber = Utf8Validation.forNumber(this.utf8Validation_);
            return utf8ValidationForNumber == null ? Utf8Validation.UTF8_VALIDATION_UNKNOWN : utf8ValidationForNumber;
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
            if ((this.bitField0_ & 1) != 0) {
                output.writeBool(1, this.legacyClosedEnum_);
            }
            if ((this.bitField0_ & 2) != 0) {
                output.writeEnum(2, this.utf8Validation_);
            }
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeBoolSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeBoolSize(1, this.legacyClosedEnum_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                iComputeBoolSize += CodedOutputStream.computeEnumSize(2, this.utf8Validation_);
            }
            int serializedSize = iComputeBoolSize + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof JavaFeatures)) {
                return super.equals(obj);
            }
            JavaFeatures javaFeatures = (JavaFeatures) obj;
            if (hasLegacyClosedEnum() != javaFeatures.hasLegacyClosedEnum()) {
                return false;
            }
            if ((!hasLegacyClosedEnum() || getLegacyClosedEnum() == javaFeatures.getLegacyClosedEnum()) && hasUtf8Validation() == javaFeatures.hasUtf8Validation()) {
                return (!hasUtf8Validation() || this.utf8Validation_ == javaFeatures.utf8Validation_) && getUnknownFields().equals(javaFeatures.getUnknownFields());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = 779 + getDescriptor().hashCode();
            if (hasLegacyClosedEnum()) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + Internal.hashBoolean(getLegacyClosedEnum());
            }
            if (hasUtf8Validation()) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + this.utf8Validation_;
            }
            int iHashCode2 = (iHashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static JavaFeatures parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static JavaFeatures parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static JavaFeatures parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static JavaFeatures parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static JavaFeatures parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static JavaFeatures parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static JavaFeatures parseFrom(InputStream input) throws IOException {
            return (JavaFeatures) GeneratedMessage.parseWithIOException(PARSER, input);
        }

        public static JavaFeatures parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JavaFeatures) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static JavaFeatures parseDelimitedFrom(InputStream input) throws IOException {
            return (JavaFeatures) GeneratedMessage.parseDelimitedWithIOException(PARSER, input);
        }

        public static JavaFeatures parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JavaFeatures) GeneratedMessage.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static JavaFeatures parseFrom(CodedInputStream input) throws IOException {
            return (JavaFeatures) GeneratedMessage.parseWithIOException(PARSER, input);
        }

        public static JavaFeatures parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JavaFeatures) GeneratedMessage.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(JavaFeatures prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder((AnonymousClass1) null) : new Builder((AnonymousClass1) null).mergeFrom(this);
        }

        /* INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.AbstractMessage
        public Builder newBuilderForType(AbstractMessage.BuilderParent parent) {
            return new Builder(parent, null);
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements JavaFeaturesOrBuilder {
            private int bitField0_;
            private boolean legacyClosedEnum_;
            private int utf8Validation_;

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
                return JavaFeaturesProto.internal_static_pb_JavaFeatures_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return JavaFeaturesProto.internal_static_pb_JavaFeatures_fieldAccessorTable.ensureFieldAccessorsInitialized(JavaFeatures.class, Builder.class);
            }

            private Builder() {
                this.utf8Validation_ = 0;
            }

            private Builder(AbstractMessage.BuilderParent parent) {
                super(parent);
                this.utf8Validation_ = 0;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.legacyClosedEnum_ = false;
                this.utf8Validation_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return JavaFeaturesProto.internal_static_pb_JavaFeatures_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public JavaFeatures getDefaultInstanceForType() {
                return JavaFeatures.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public JavaFeatures build() {
                JavaFeatures javaFeaturesBuildPartial = buildPartial();
                if (javaFeaturesBuildPartial.isInitialized()) {
                    return javaFeaturesBuildPartial;
                }
                throw newUninitializedMessageException((Message) javaFeaturesBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public JavaFeatures buildPartial() {
                JavaFeatures javaFeatures = new JavaFeatures(this, null);
                if (this.bitField0_ != 0) {
                    buildPartial0(javaFeatures);
                }
                onBuilt();
                return javaFeatures;
            }

            private void buildPartial0(JavaFeatures result) {
                int i;
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    result.legacyClosedEnum_ = this.legacyClosedEnum_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    result.utf8Validation_ = this.utf8Validation_;
                    i |= 2;
                }
                JavaFeatures.access$776(result, i);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof JavaFeatures) {
                    return mergeFrom((JavaFeatures) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(JavaFeatures other) {
                if (other == JavaFeatures.getDefaultInstance()) {
                    return this;
                }
                if (other.hasLegacyClosedEnum()) {
                    setLegacyClosedEnum(other.getLegacyClosedEnum());
                }
                if (other.hasUtf8Validation()) {
                    setUtf8Validation(other.getUtf8Validation());
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
                                if (tag == 8) {
                                    this.legacyClosedEnum_ = input.readBool();
                                    this.bitField0_ |= 1;
                                } else if (tag == 16) {
                                    int i = input.readEnum();
                                    if (Utf8Validation.forNumber(i) == null) {
                                        mergeUnknownVarintField(2, i);
                                    } else {
                                        this.utf8Validation_ = i;
                                        this.bitField0_ |= 2;
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

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean hasLegacyClosedEnum() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean getLegacyClosedEnum() {
                return this.legacyClosedEnum_;
            }

            public Builder setLegacyClosedEnum(boolean value) {
                this.legacyClosedEnum_ = value;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder clearLegacyClosedEnum() {
                this.bitField0_ &= -2;
                this.legacyClosedEnum_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean hasUtf8Validation() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public Utf8Validation getUtf8Validation() {
                Utf8Validation utf8ValidationForNumber = Utf8Validation.forNumber(this.utf8Validation_);
                return utf8ValidationForNumber == null ? Utf8Validation.UTF8_VALIDATION_UNKNOWN : utf8ValidationForNumber;
            }

            public Builder setUtf8Validation(Utf8Validation value) {
                value.getClass();
                this.bitField0_ |= 2;
                this.utf8Validation_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearUtf8Validation() {
                this.bitField0_ &= -3;
                this.utf8Validation_ = 0;
                onChanged();
                return this;
            }
        }

        public static JavaFeatures getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* INFO: renamed from: com.google.protobuf.JavaFeaturesProto$JavaFeatures$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractParser<JavaFeatures> {
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
            public JavaFeatures parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builderNewBuilder = JavaFeatures.newBuilder();
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

        public static Parser<JavaFeatures> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<JavaFeatures> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public JavaFeatures getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
