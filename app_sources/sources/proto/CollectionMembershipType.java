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

/* INFO: loaded from: classes6.dex */
public final class CollectionMembershipType extends GeneratedMessage implements CollectionMembershipTypeOrBuilder {
    public static final int ALLOWED_COLLECTION_TYPE_FIELD_NUMBER = 4;
    public static final int CHECKSUM_FIELD_NUMBER = 7;
    public static final int CREATED_AT_FIELD_NUMBER = 6;
    private static final CollectionMembershipType DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static final Parser<CollectionMembershipType> PARSER;
    public static final int UPDATED_AT_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private CollectionType allowedCollectionType_;
    private int bitField0_;
    private volatile Object checksum_;
    private Timestamp createdAt_;
    private volatile Object description_;
    private long id_;
    private volatile Object name_;
    private Timestamp updatedAt_;

    /* synthetic */ CollectionMembershipType(GeneratedMessage.Builder builder, CollectionMembershipTypeIA collectionMembershipTypeIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CollectionMembershipType.class.getName());
        DEFAULT_INSTANCE = new CollectionMembershipType();
        PARSER = new AnonymousClass1();
    }

    private CollectionMembershipType(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.name_ = "";
        this.description_ = "";
        this.checksum_ = "";
    }

    private CollectionMembershipType() {
        this.id_ = 0L;
        this.name_ = "";
        this.description_ = "";
        this.checksum_ = "";
        this.name_ = "";
        this.description_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CollectionMembershipType_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CollectionMembershipType_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionMembershipType.class, Builder.class);
    }

    @Override // proto.CollectionMembershipTypeOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.CollectionMembershipTypeOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CollectionMembershipTypeOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CollectionMembershipTypeOrBuilder
    public String getDescription() {
        Object obj = this.description_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.description_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CollectionMembershipTypeOrBuilder
    public ByteString getDescriptionBytes() {
        Object obj = this.description_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.description_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CollectionMembershipTypeOrBuilder
    public boolean hasAllowedCollectionType() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.CollectionMembershipTypeOrBuilder
    public CollectionType getAllowedCollectionType() {
        CollectionType collectionType = this.allowedCollectionType_;
        return collectionType == null ? CollectionType.getDefaultInstance() : collectionType;
    }

    @Override // proto.CollectionMembershipTypeOrBuilder
    public CollectionTypeOrBuilder getAllowedCollectionTypeOrBuilder() {
        CollectionType collectionType = this.allowedCollectionType_;
        return collectionType == null ? CollectionType.getDefaultInstance() : collectionType;
    }

    @Override // proto.CollectionMembershipTypeOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.CollectionMembershipTypeOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CollectionMembershipTypeOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CollectionMembershipTypeOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.CollectionMembershipTypeOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CollectionMembershipTypeOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CollectionMembershipTypeOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CollectionMembershipTypeOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static CollectionMembershipType parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CollectionMembershipType parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CollectionMembershipType parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CollectionMembershipType parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CollectionMembershipType parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CollectionMembershipType parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CollectionMembershipType parseFrom(InputStream inputStream) throws IOException {
        return (CollectionMembershipType) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CollectionMembershipType parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionMembershipType) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionMembershipType parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CollectionMembershipType) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CollectionMembershipType parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionMembershipType) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionMembershipType parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CollectionMembershipType) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CollectionMembershipType parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionMembershipType) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CollectionMembershipType collectionMembershipType) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) collectionMembershipType);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CollectionMembershipTypeIA) null) : (Builder) new Builder((CollectionMembershipTypeIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CollectionMembershipTypeOrBuilder {
        private SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> allowedCollectionTypeBuilder_;
        private CollectionType allowedCollectionType_;
        private int bitField0_;
        private Object checksum_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private Object description_;
        private long id_;
        private Object name_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CollectionMembershipTypeIA collectionMembershipTypeIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CollectionMembershipTypeIA collectionMembershipTypeIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CollectionMembershipType_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CollectionMembershipType_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionMembershipType.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.description_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.description_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (CollectionMembershipType.alwaysUseFieldBuilders) {
                getAllowedCollectionTypeFieldBuilder();
                getUpdatedAtFieldBuilder();
                getCreatedAtFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.name_ = "";
            this.description_ = "";
            this.allowedCollectionType_ = null;
            SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> singleFieldBuilder = this.allowedCollectionTypeBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.allowedCollectionTypeBuilder_ = null;
            }
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.updatedAtBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.createdAtBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.createdAtBuilder_ = null;
            }
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_CollectionMembershipType_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CollectionMembershipType getDefaultInstanceForType() {
            return CollectionMembershipType.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionMembershipType build() {
            CollectionMembershipType collectionMembershipTypeBuildPartial = buildPartial();
            if (collectionMembershipTypeBuildPartial.isInitialized()) {
                return collectionMembershipTypeBuildPartial;
            }
            throw newUninitializedMessageException((Message) collectionMembershipTypeBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionMembershipType buildPartial() {
            CollectionMembershipType collectionMembershipType = new CollectionMembershipType(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(collectionMembershipType);
            }
            onBuilt();
            return collectionMembershipType;
        }

        private void buildPartial0(CollectionMembershipType collectionMembershipType) {
            int i;
            Timestamp timestamp;
            Timestamp timestamp2;
            CollectionType collectionType;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                collectionMembershipType.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                collectionMembershipType.name_ = this.name_;
            }
            if ((i2 & 4) != 0) {
                collectionMembershipType.description_ = this.description_;
            }
            if ((i2 & 8) != 0) {
                SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> singleFieldBuilder = this.allowedCollectionTypeBuilder_;
                if (singleFieldBuilder == null) {
                    collectionType = this.allowedCollectionType_;
                } else {
                    collectionType = (CollectionType) singleFieldBuilder.build();
                }
                collectionMembershipType.allowedCollectionType_ = collectionType;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.updatedAtBuilder_;
                if (singleFieldBuilder2 == null) {
                    timestamp2 = this.updatedAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder2.build();
                }
                collectionMembershipType.updatedAt_ = timestamp2;
                i |= 2;
            }
            if ((i2 & 32) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.createdAtBuilder_;
                if (singleFieldBuilder3 == null) {
                    timestamp = this.createdAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder3.build();
                }
                collectionMembershipType.createdAt_ = timestamp;
                i |= 4;
            }
            if ((i2 & 64) != 0) {
                collectionMembershipType.checksum_ = this.checksum_;
            }
            collectionMembershipType.bitField0_ |= i;
        }

        @Override // proto.CollectionMembershipTypeOrBuilder
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

        @Override // proto.CollectionMembershipTypeOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CollectionMembershipTypeOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setName(String str) {
            str.getClass();
            this.name_ = str;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = CollectionMembershipType.getDefaultInstance().getName();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            CollectionMembershipType.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.CollectionMembershipTypeOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.description_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CollectionMembershipTypeOrBuilder
        public ByteString getDescriptionBytes() {
            Object obj = this.description_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.description_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setDescription(String str) {
            str.getClass();
            this.description_ = str;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearDescription() {
            this.description_ = CollectionMembershipType.getDefaultInstance().getDescription();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            byteString.getClass();
            CollectionMembershipType.checkByteStringIsUtf8(byteString);
            this.description_ = byteString;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // proto.CollectionMembershipTypeOrBuilder
        public boolean hasAllowedCollectionType() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // proto.CollectionMembershipTypeOrBuilder
        public CollectionType getAllowedCollectionType() {
            SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> singleFieldBuilder = this.allowedCollectionTypeBuilder_;
            if (singleFieldBuilder == null) {
                CollectionType collectionType = this.allowedCollectionType_;
                return collectionType == null ? CollectionType.getDefaultInstance() : collectionType;
            }
            return (CollectionType) singleFieldBuilder.getMessage();
        }

        public Builder setAllowedCollectionType(CollectionType collectionType) {
            SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> singleFieldBuilder = this.allowedCollectionTypeBuilder_;
            if (singleFieldBuilder == null) {
                collectionType.getClass();
                this.allowedCollectionType_ = collectionType;
            } else {
                singleFieldBuilder.setMessage(collectionType);
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setAllowedCollectionType(CollectionType.Builder builder) {
            SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> singleFieldBuilder = this.allowedCollectionTypeBuilder_;
            if (singleFieldBuilder == null) {
                this.allowedCollectionType_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder mergeAllowedCollectionType(CollectionType collectionType) {
            CollectionType collectionType2;
            SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> singleFieldBuilder = this.allowedCollectionTypeBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 8) != 0 && (collectionType2 = this.allowedCollectionType_) != null && collectionType2 != CollectionType.getDefaultInstance()) {
                    getAllowedCollectionTypeBuilder().mergeFrom((Message) collectionType);
                } else {
                    this.allowedCollectionType_ = collectionType;
                }
            } else {
                singleFieldBuilder.mergeFrom(collectionType);
            }
            if (this.allowedCollectionType_ != null) {
                this.bitField0_ |= 8;
                onChanged();
            }
            return this;
        }

        public Builder clearAllowedCollectionType() {
            this.bitField0_ &= -9;
            this.allowedCollectionType_ = null;
            SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> singleFieldBuilder = this.allowedCollectionTypeBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.allowedCollectionTypeBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public CollectionType.Builder getAllowedCollectionTypeBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (CollectionType.Builder) getAllowedCollectionTypeFieldBuilder().getBuilder();
        }

        @Override // proto.CollectionMembershipTypeOrBuilder
        public CollectionTypeOrBuilder getAllowedCollectionTypeOrBuilder() {
            SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> singleFieldBuilder = this.allowedCollectionTypeBuilder_;
            if (singleFieldBuilder != null) {
                return (CollectionTypeOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            CollectionType collectionType = this.allowedCollectionType_;
            return collectionType == null ? CollectionType.getDefaultInstance() : collectionType;
        }

        private SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> getAllowedCollectionTypeFieldBuilder() {
            if (this.allowedCollectionTypeBuilder_ == null) {
                this.allowedCollectionTypeBuilder_ = new SingleFieldBuilder<>(getAllowedCollectionType(), getParentForChildren(), isClean());
                this.allowedCollectionType_ = null;
            }
            return this.allowedCollectionTypeBuilder_;
        }

        @Override // proto.CollectionMembershipTypeOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // proto.CollectionMembershipTypeOrBuilder
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
            this.bitField0_ |= 16;
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
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder mergeUpdatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 16) != 0 && (timestamp2 = this.updatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getUpdatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.updatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.updatedAt_ != null) {
                this.bitField0_ |= 16;
                onChanged();
            }
            return this;
        }

        public Builder clearUpdatedAt() {
            this.bitField0_ &= -17;
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
            this.bitField0_ |= 16;
            onChanged();
            return (Timestamp.Builder) getUpdatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.CollectionMembershipTypeOrBuilder
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

        @Override // proto.CollectionMembershipTypeOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // proto.CollectionMembershipTypeOrBuilder
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
            this.bitField0_ |= 32;
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
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder mergeCreatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 32) != 0 && (timestamp2 = this.createdAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getCreatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.createdAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.createdAt_ != null) {
                this.bitField0_ |= 32;
                onChanged();
            }
            return this;
        }

        public Builder clearCreatedAt() {
            this.bitField0_ &= -33;
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
            this.bitField0_ |= 32;
            onChanged();
            return (Timestamp.Builder) getCreatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.CollectionMembershipTypeOrBuilder
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

        @Override // proto.CollectionMembershipTypeOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CollectionMembershipTypeOrBuilder
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
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = CollectionMembershipType.getDefaultInstance().getChecksum();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            CollectionMembershipType.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }
    }

    public static CollectionMembershipType getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.CollectionMembershipType$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CollectionMembershipType> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CollectionMembershipType parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CollectionMembershipType.newBuilder();
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

    public static Parser<CollectionMembershipType> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CollectionMembershipType> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CollectionMembershipType getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
