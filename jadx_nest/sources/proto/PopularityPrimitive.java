package proto;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public final class PopularityPrimitive extends GeneratedMessage implements PopularityPrimitiveOrBuilder {
    public static final int CALCULATED_AT_FIELD_NUMBER = 6;
    public static final int CHECKSUM_FIELD_NUMBER = 9;
    public static final int CREATED_AT_FIELD_NUMBER = 7;
    private static final PopularityPrimitive DEFAULT_INSTANCE;
    public static final int GAME_ID_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 1;
    private static final Parser<PopularityPrimitive> PARSER;
    public static final int POPULARITY_SOURCE_FIELD_NUMBER = 4;
    public static final int POPULARITY_TYPE_FIELD_NUMBER = 3;
    public static final int UPDATED_AT_FIELD_NUMBER = 8;
    public static final int VALUE_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private Timestamp calculatedAt_;
    private volatile Object checksum_;
    private Timestamp createdAt_;
    private int gameId_;
    private long id_;
    private int popularitySource_;
    private PopularityType popularityType_;
    private Timestamp updatedAt_;
    private double value_;

    /* synthetic */ PopularityPrimitive(GeneratedMessage.Builder builder, PopularityPrimitiveIA popularityPrimitiveIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PopularityPrimitive.class.getName());
        DEFAULT_INSTANCE = new PopularityPrimitive();
        PARSER = new AnonymousClass1();
    }

    private PopularityPrimitive(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.gameId_ = 0;
        this.popularitySource_ = 0;
        this.value_ = 0.0d;
        this.checksum_ = "";
    }

    private PopularityPrimitive() {
        this.id_ = 0L;
        this.gameId_ = 0;
        this.popularitySource_ = 0;
        this.value_ = 0.0d;
        this.checksum_ = "";
        this.popularitySource_ = 0;
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_PopularityPrimitive_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_PopularityPrimitive_fieldAccessorTable.ensureFieldAccessorsInitialized(PopularityPrimitive.class, Builder.class);
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public int getGameId() {
        return this.gameId_;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public boolean hasPopularityType() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public PopularityType getPopularityType() {
        PopularityType popularityType = this.popularityType_;
        return popularityType == null ? PopularityType.getDefaultInstance() : popularityType;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public PopularityTypeOrBuilder getPopularityTypeOrBuilder() {
        PopularityType popularityType = this.popularityType_;
        return popularityType == null ? PopularityType.getDefaultInstance() : popularityType;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public int getPopularitySourceValue() {
        return this.popularitySource_;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public PopularitySourcePopularitySourceEnum getPopularitySource() {
        PopularitySourcePopularitySourceEnum popularitySourcePopularitySourceEnumForNumber = PopularitySourcePopularitySourceEnum.forNumber(this.popularitySource_);
        return popularitySourcePopularitySourceEnumForNumber == null ? PopularitySourcePopularitySourceEnum.UNRECOGNIZED : popularitySourcePopularitySourceEnumForNumber;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public double getValue() {
        return this.value_;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public boolean hasCalculatedAt() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public Timestamp getCalculatedAt() {
        Timestamp timestamp = this.calculatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public TimestampOrBuilder getCalculatedAtOrBuilder() {
        Timestamp timestamp = this.calculatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PopularityPrimitiveOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static PopularityPrimitive parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PopularityPrimitive parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PopularityPrimitive parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PopularityPrimitive parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PopularityPrimitive parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PopularityPrimitive parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PopularityPrimitive parseFrom(InputStream inputStream) throws IOException {
        return (PopularityPrimitive) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PopularityPrimitive parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PopularityPrimitive) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PopularityPrimitive parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PopularityPrimitive) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PopularityPrimitive parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PopularityPrimitive) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PopularityPrimitive parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PopularityPrimitive) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PopularityPrimitive parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PopularityPrimitive) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(PopularityPrimitive popularityPrimitive) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) popularityPrimitive);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((PopularityPrimitiveIA) null) : (Builder) new Builder((PopularityPrimitiveIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PopularityPrimitiveOrBuilder {
        private int bitField0_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> calculatedAtBuilder_;
        private Timestamp calculatedAt_;
        private Object checksum_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private int gameId_;
        private long id_;
        private int popularitySource_;
        private SingleFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> popularityTypeBuilder_;
        private PopularityType popularityType_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;
        private double value_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, PopularityPrimitiveIA popularityPrimitiveIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(PopularityPrimitiveIA popularityPrimitiveIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_PopularityPrimitive_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_PopularityPrimitive_fieldAccessorTable.ensureFieldAccessorsInitialized(PopularityPrimitive.class, Builder.class);
        }

        private Builder() {
            this.popularitySource_ = 0;
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.popularitySource_ = 0;
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (PopularityPrimitive.alwaysUseFieldBuilders) {
                getPopularityTypeFieldBuilder();
                getCalculatedAtFieldBuilder();
                getCreatedAtFieldBuilder();
                getUpdatedAtFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.gameId_ = 0;
            this.popularityType_ = null;
            SingleFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> singleFieldBuilder = this.popularityTypeBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.popularityTypeBuilder_ = null;
            }
            this.popularitySource_ = 0;
            this.value_ = 0.0d;
            this.calculatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.calculatedAtBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.calculatedAtBuilder_ = null;
            }
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.createdAtBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.createdAtBuilder_ = null;
            }
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.updatedAtBuilder_;
            if (singleFieldBuilder4 != null) {
                singleFieldBuilder4.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_PopularityPrimitive_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PopularityPrimitive getDefaultInstanceForType() {
            return PopularityPrimitive.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PopularityPrimitive build() {
            PopularityPrimitive popularityPrimitiveBuildPartial = buildPartial();
            if (popularityPrimitiveBuildPartial.isInitialized()) {
                return popularityPrimitiveBuildPartial;
            }
            throw newUninitializedMessageException((Message) popularityPrimitiveBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PopularityPrimitive buildPartial() {
            PopularityPrimitive popularityPrimitive = new PopularityPrimitive(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(popularityPrimitive);
            }
            onBuilt();
            return popularityPrimitive;
        }

        private void buildPartial0(PopularityPrimitive popularityPrimitive) {
            int i;
            Timestamp timestamp;
            Timestamp timestamp2;
            Timestamp timestamp3;
            PopularityType popularityType;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                popularityPrimitive.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                popularityPrimitive.gameId_ = this.gameId_;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> singleFieldBuilder = this.popularityTypeBuilder_;
                if (singleFieldBuilder == null) {
                    popularityType = this.popularityType_;
                } else {
                    popularityType = (PopularityType) singleFieldBuilder.build();
                }
                popularityPrimitive.popularityType_ = popularityType;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                popularityPrimitive.popularitySource_ = this.popularitySource_;
            }
            if ((i2 & 16) != 0) {
                popularityPrimitive.value_ = this.value_;
            }
            if ((i2 & 32) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.calculatedAtBuilder_;
                if (singleFieldBuilder2 == null) {
                    timestamp3 = this.calculatedAt_;
                } else {
                    timestamp3 = (Timestamp) singleFieldBuilder2.build();
                }
                popularityPrimitive.calculatedAt_ = timestamp3;
                i |= 2;
            }
            if ((i2 & 64) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.createdAtBuilder_;
                if (singleFieldBuilder3 == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder3.build();
                }
                popularityPrimitive.createdAt_ = timestamp2;
                i |= 4;
            }
            if ((i2 & 128) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.updatedAtBuilder_;
                if (singleFieldBuilder4 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder4.build();
                }
                popularityPrimitive.updatedAt_ = timestamp;
                i |= 8;
            }
            if ((i2 & 256) != 0) {
                popularityPrimitive.checksum_ = this.checksum_;
            }
            popularityPrimitive.bitField0_ |= i;
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public long getId() {
            return this.id_;
        }

        public Builder setId(long j) {
            this.id_ = j;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder clearId() {
            this.bitField0_ &= -2;
            this.id_ = 0L;
            onChanged();
            return this;
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public int getGameId() {
            return this.gameId_;
        }

        public Builder setGameId(int i) {
            this.gameId_ = i;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder clearGameId() {
            this.bitField0_ &= -3;
            this.gameId_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public boolean hasPopularityType() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public PopularityType getPopularityType() {
            SingleFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> singleFieldBuilder = this.popularityTypeBuilder_;
            if (singleFieldBuilder == null) {
                PopularityType popularityType = this.popularityType_;
                return popularityType == null ? PopularityType.getDefaultInstance() : popularityType;
            }
            return (PopularityType) singleFieldBuilder.getMessage();
        }

        public Builder setPopularityType(PopularityType popularityType) {
            SingleFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> singleFieldBuilder = this.popularityTypeBuilder_;
            if (singleFieldBuilder == null) {
                popularityType.getClass();
                this.popularityType_ = popularityType;
            } else {
                singleFieldBuilder.setMessage(popularityType);
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setPopularityType(PopularityType.Builder builder) {
            SingleFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> singleFieldBuilder = this.popularityTypeBuilder_;
            if (singleFieldBuilder == null) {
                this.popularityType_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder mergePopularityType(PopularityType popularityType) {
            PopularityType popularityType2;
            SingleFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> singleFieldBuilder = this.popularityTypeBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0 && (popularityType2 = this.popularityType_) != null && popularityType2 != PopularityType.getDefaultInstance()) {
                    getPopularityTypeBuilder().mergeFrom((Message) popularityType);
                } else {
                    this.popularityType_ = popularityType;
                }
            } else {
                singleFieldBuilder.mergeFrom(popularityType);
            }
            if (this.popularityType_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder clearPopularityType() {
            this.bitField0_ &= -5;
            this.popularityType_ = null;
            SingleFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> singleFieldBuilder = this.popularityTypeBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.popularityTypeBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public PopularityType.Builder getPopularityTypeBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (PopularityType.Builder) getPopularityTypeFieldBuilder().getBuilder();
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public PopularityTypeOrBuilder getPopularityTypeOrBuilder() {
            SingleFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> singleFieldBuilder = this.popularityTypeBuilder_;
            if (singleFieldBuilder != null) {
                return (PopularityTypeOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            PopularityType popularityType = this.popularityType_;
            return popularityType == null ? PopularityType.getDefaultInstance() : popularityType;
        }

        private SingleFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> getPopularityTypeFieldBuilder() {
            if (this.popularityTypeBuilder_ == null) {
                this.popularityTypeBuilder_ = new SingleFieldBuilder<>(getPopularityType(), getParentForChildren(), isClean());
                this.popularityType_ = null;
            }
            return this.popularityTypeBuilder_;
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public int getPopularitySourceValue() {
            return this.popularitySource_;
        }

        public Builder setPopularitySourceValue(int i) {
            this.popularitySource_ = i;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public PopularitySourcePopularitySourceEnum getPopularitySource() {
            PopularitySourcePopularitySourceEnum popularitySourcePopularitySourceEnumForNumber = PopularitySourcePopularitySourceEnum.forNumber(this.popularitySource_);
            return popularitySourcePopularitySourceEnumForNumber == null ? PopularitySourcePopularitySourceEnum.UNRECOGNIZED : popularitySourcePopularitySourceEnumForNumber;
        }

        public Builder setPopularitySource(PopularitySourcePopularitySourceEnum popularitySourcePopularitySourceEnum) {
            popularitySourcePopularitySourceEnum.getClass();
            this.bitField0_ |= 8;
            this.popularitySource_ = popularitySourcePopularitySourceEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearPopularitySource() {
            this.bitField0_ &= -9;
            this.popularitySource_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public double getValue() {
            return this.value_;
        }

        public Builder setValue(double d) {
            this.value_ = d;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearValue() {
            this.bitField0_ &= -17;
            this.value_ = 0.0d;
            onChanged();
            return this;
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public boolean hasCalculatedAt() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public Timestamp getCalculatedAt() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.calculatedAtBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.calculatedAt_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setCalculatedAt(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.calculatedAtBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.calculatedAt_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setCalculatedAt(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.calculatedAtBuilder_;
            if (singleFieldBuilder == null) {
                this.calculatedAt_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder mergeCalculatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.calculatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 32) != 0 && (timestamp2 = this.calculatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getCalculatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.calculatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.calculatedAt_ != null) {
                this.bitField0_ |= 32;
                onChanged();
            }
            return this;
        }

        public Builder clearCalculatedAt() {
            this.bitField0_ &= -33;
            this.calculatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.calculatedAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.calculatedAtBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getCalculatedAtBuilder() {
            this.bitField0_ |= 32;
            onChanged();
            return (Timestamp.Builder) getCalculatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public TimestampOrBuilder getCalculatedAtOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.calculatedAtBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.calculatedAt_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getCalculatedAtFieldBuilder() {
            if (this.calculatedAtBuilder_ == null) {
                this.calculatedAtBuilder_ = new SingleFieldBuilder<>(getCalculatedAt(), getParentForChildren(), isClean());
                this.calculatedAt_ = null;
            }
            return this.calculatedAtBuilder_;
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public Timestamp getCreatedAt() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.createdAt_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setCreatedAt(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.createdAt_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setCreatedAt(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                this.createdAt_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder mergeCreatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 64) != 0 && (timestamp2 = this.createdAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getCreatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.createdAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.createdAt_ != null) {
                this.bitField0_ |= 64;
                onChanged();
            }
            return this;
        }

        public Builder clearCreatedAt() {
            this.bitField0_ &= -65;
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.createdAtBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getCreatedAtBuilder() {
            this.bitField0_ |= 64;
            onChanged();
            return (Timestamp.Builder) getCreatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public TimestampOrBuilder getCreatedAtOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.createdAt_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getCreatedAtFieldBuilder() {
            if (this.createdAtBuilder_ == null) {
                this.createdAtBuilder_ = new SingleFieldBuilder<>(getCreatedAt(), getParentForChildren(), isClean());
                this.createdAt_ = null;
            }
            return this.createdAtBuilder_;
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public Timestamp getUpdatedAt() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.updatedAt_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setUpdatedAt(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.updatedAt_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setUpdatedAt(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                this.updatedAt_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder mergeUpdatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 128) != 0 && (timestamp2 = this.updatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getUpdatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.updatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.updatedAt_ != null) {
                this.bitField0_ |= 128;
                onChanged();
            }
            return this;
        }

        public Builder clearUpdatedAt() {
            this.bitField0_ &= -129;
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.updatedAtBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getUpdatedAtBuilder() {
            this.bitField0_ |= 128;
            onChanged();
            return (Timestamp.Builder) getUpdatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public TimestampOrBuilder getUpdatedAtOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.updatedAt_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getUpdatedAtFieldBuilder() {
            if (this.updatedAtBuilder_ == null) {
                this.updatedAtBuilder_ = new SingleFieldBuilder<>(getUpdatedAt(), getParentForChildren(), isClean());
                this.updatedAt_ = null;
            }
            return this.updatedAtBuilder_;
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PopularityPrimitiveOrBuilder
        public ByteString getChecksumBytes() {
            Object obj = this.checksum_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.checksum_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setChecksum(String str) {
            str.getClass();
            this.checksum_ = str;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = PopularityPrimitive.getDefaultInstance().getChecksum();
            this.bitField0_ &= -257;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            PopularityPrimitive.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }
    }

    public static PopularityPrimitive getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.PopularityPrimitive$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<PopularityPrimitive> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public PopularityPrimitive parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = PopularityPrimitive.newBuilder();
            try {
                builderNewBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
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

    public static Parser<PopularityPrimitive> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PopularityPrimitive> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PopularityPrimitive getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
