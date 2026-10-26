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
public final class CollectionRelation extends GeneratedMessage implements CollectionRelationOrBuilder {
    public static final int CHECKSUM_FIELD_NUMBER = 7;
    public static final int CHILD_COLLECTION_FIELD_NUMBER = 2;
    public static final int CREATED_AT_FIELD_NUMBER = 6;
    private static final CollectionRelation DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int PARENT_COLLECTION_FIELD_NUMBER = 3;
    private static final Parser<CollectionRelation> PARSER;
    public static final int TYPE_FIELD_NUMBER = 4;
    public static final int UPDATED_AT_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object checksum_;
    private Collection childCollection_;
    private Timestamp createdAt_;
    private long id_;
    private Collection parentCollection_;
    private CollectionRelationType type_;
    private Timestamp updatedAt_;

    /* synthetic */ CollectionRelation(GeneratedMessage.Builder builder, CollectionRelationIA collectionRelationIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CollectionRelation.class.getName());
        DEFAULT_INSTANCE = new CollectionRelation();
        PARSER = new AnonymousClass1();
    }

    private CollectionRelation(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.checksum_ = "";
    }

    private CollectionRelation() {
        this.id_ = 0L;
        this.checksum_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CollectionRelation_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CollectionRelation_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionRelation.class, Builder.class);
    }

    @Override // proto.CollectionRelationOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.CollectionRelationOrBuilder
    public boolean hasChildCollection() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.CollectionRelationOrBuilder
    public Collection getChildCollection() {
        Collection collection = this.childCollection_;
        return collection == null ? Collection.getDefaultInstance() : collection;
    }

    @Override // proto.CollectionRelationOrBuilder
    public CollectionOrBuilder getChildCollectionOrBuilder() {
        Collection collection = this.childCollection_;
        return collection == null ? Collection.getDefaultInstance() : collection;
    }

    @Override // proto.CollectionRelationOrBuilder
    public boolean hasParentCollection() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.CollectionRelationOrBuilder
    public Collection getParentCollection() {
        Collection collection = this.parentCollection_;
        return collection == null ? Collection.getDefaultInstance() : collection;
    }

    @Override // proto.CollectionRelationOrBuilder
    public CollectionOrBuilder getParentCollectionOrBuilder() {
        Collection collection = this.parentCollection_;
        return collection == null ? Collection.getDefaultInstance() : collection;
    }

    @Override // proto.CollectionRelationOrBuilder
    public boolean hasType() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.CollectionRelationOrBuilder
    public CollectionRelationType getType() {
        CollectionRelationType collectionRelationType = this.type_;
        return collectionRelationType == null ? CollectionRelationType.getDefaultInstance() : collectionRelationType;
    }

    @Override // proto.CollectionRelationOrBuilder
    public CollectionRelationTypeOrBuilder getTypeOrBuilder() {
        CollectionRelationType collectionRelationType = this.type_;
        return collectionRelationType == null ? CollectionRelationType.getDefaultInstance() : collectionRelationType;
    }

    @Override // proto.CollectionRelationOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // proto.CollectionRelationOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CollectionRelationOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CollectionRelationOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // proto.CollectionRelationOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CollectionRelationOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CollectionRelationOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CollectionRelationOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static CollectionRelation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CollectionRelation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CollectionRelation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CollectionRelation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CollectionRelation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CollectionRelation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CollectionRelation parseFrom(InputStream inputStream) throws IOException {
        return (CollectionRelation) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CollectionRelation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionRelation) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionRelation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CollectionRelation) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CollectionRelation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionRelation) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionRelation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CollectionRelation) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CollectionRelation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionRelation) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CollectionRelation collectionRelation) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) collectionRelation);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CollectionRelationIA) null) : (Builder) new Builder((CollectionRelationIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CollectionRelationOrBuilder {
        private int bitField0_;
        private Object checksum_;
        private SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> childCollectionBuilder_;
        private Collection childCollection_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private long id_;
        private SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> parentCollectionBuilder_;
        private Collection parentCollection_;
        private SingleFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> typeBuilder_;
        private CollectionRelationType type_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CollectionRelationIA collectionRelationIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CollectionRelationIA collectionRelationIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CollectionRelation_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CollectionRelation_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionRelation.class, Builder.class);
        }

        private Builder() {
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (CollectionRelation.alwaysUseFieldBuilders) {
                getChildCollectionFieldBuilder();
                getParentCollectionFieldBuilder();
                getTypeFieldBuilder();
                getUpdatedAtFieldBuilder();
                getCreatedAtFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.childCollection_ = null;
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.childCollectionBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.childCollectionBuilder_ = null;
            }
            this.parentCollection_ = null;
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder2 = this.parentCollectionBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.parentCollectionBuilder_ = null;
            }
            this.type_ = null;
            SingleFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> singleFieldBuilder3 = this.typeBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.typeBuilder_ = null;
            }
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.updatedAtBuilder_;
            if (singleFieldBuilder4 != null) {
                singleFieldBuilder4.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder5 = this.createdAtBuilder_;
            if (singleFieldBuilder5 != null) {
                singleFieldBuilder5.dispose();
                this.createdAtBuilder_ = null;
            }
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_CollectionRelation_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CollectionRelation getDefaultInstanceForType() {
            return CollectionRelation.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionRelation build() {
            CollectionRelation collectionRelationBuildPartial = buildPartial();
            if (collectionRelationBuildPartial.isInitialized()) {
                return collectionRelationBuildPartial;
            }
            throw newUninitializedMessageException((Message) collectionRelationBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionRelation buildPartial() {
            CollectionRelation collectionRelation = new CollectionRelation(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(collectionRelation);
            }
            onBuilt();
            return collectionRelation;
        }

        private void buildPartial0(CollectionRelation collectionRelation) {
            int i;
            Timestamp timestamp;
            Timestamp timestamp2;
            CollectionRelationType collectionRelationType;
            Collection collection;
            Collection collection2;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                collectionRelation.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.childCollectionBuilder_;
                if (singleFieldBuilder == null) {
                    collection2 = this.childCollection_;
                } else {
                    collection2 = (Collection) singleFieldBuilder.build();
                }
                collectionRelation.childCollection_ = collection2;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder2 = this.parentCollectionBuilder_;
                if (singleFieldBuilder2 == null) {
                    collection = this.parentCollection_;
                } else {
                    collection = (Collection) singleFieldBuilder2.build();
                }
                collectionRelation.parentCollection_ = collection;
                i |= 2;
            }
            if ((i2 & 8) != 0) {
                SingleFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> singleFieldBuilder3 = this.typeBuilder_;
                if (singleFieldBuilder3 == null) {
                    collectionRelationType = this.type_;
                } else {
                    collectionRelationType = (CollectionRelationType) singleFieldBuilder3.build();
                }
                collectionRelation.type_ = collectionRelationType;
                i |= 4;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.updatedAtBuilder_;
                if (singleFieldBuilder4 == null) {
                    timestamp2 = this.updatedAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder4.build();
                }
                collectionRelation.updatedAt_ = timestamp2;
                i |= 8;
            }
            if ((i2 & 32) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder5 = this.createdAtBuilder_;
                if (singleFieldBuilder5 == null) {
                    timestamp = this.createdAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder5.build();
                }
                collectionRelation.createdAt_ = timestamp;
                i |= 16;
            }
            if ((i2 & 64) != 0) {
                collectionRelation.checksum_ = this.checksum_;
            }
            collectionRelation.bitField0_ |= i;
        }

        @Override // proto.CollectionRelationOrBuilder
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

        @Override // proto.CollectionRelationOrBuilder
        public boolean hasChildCollection() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // proto.CollectionRelationOrBuilder
        public Collection getChildCollection() {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.childCollectionBuilder_;
            if (singleFieldBuilder == null) {
                Collection collection = this.childCollection_;
                return collection == null ? Collection.getDefaultInstance() : collection;
            }
            return (Collection) singleFieldBuilder.getMessage();
        }

        public Builder setChildCollection(Collection collection) {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.childCollectionBuilder_;
            if (singleFieldBuilder == null) {
                collection.getClass();
                this.childCollection_ = collection;
            } else {
                singleFieldBuilder.setMessage(collection);
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setChildCollection(Collection.Builder builder) {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.childCollectionBuilder_;
            if (singleFieldBuilder == null) {
                this.childCollection_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder mergeChildCollection(Collection collection) {
            Collection collection2;
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.childCollectionBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 2) != 0 && (collection2 = this.childCollection_) != null && collection2 != Collection.getDefaultInstance()) {
                    getChildCollectionBuilder().mergeFrom((Message) collection);
                } else {
                    this.childCollection_ = collection;
                }
            } else {
                singleFieldBuilder.mergeFrom(collection);
            }
            if (this.childCollection_ != null) {
                this.bitField0_ |= 2;
                onChanged();
            }
            return this;
        }

        public Builder clearChildCollection() {
            this.bitField0_ &= -3;
            this.childCollection_ = null;
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.childCollectionBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.childCollectionBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Collection.Builder getChildCollectionBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (Collection.Builder) getChildCollectionFieldBuilder().getBuilder();
        }

        @Override // proto.CollectionRelationOrBuilder
        public CollectionOrBuilder getChildCollectionOrBuilder() {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.childCollectionBuilder_;
            if (singleFieldBuilder != null) {
                return (CollectionOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Collection collection = this.childCollection_;
            return collection == null ? Collection.getDefaultInstance() : collection;
        }

        private SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> getChildCollectionFieldBuilder() {
            if (this.childCollectionBuilder_ == null) {
                this.childCollectionBuilder_ = new SingleFieldBuilder<>(getChildCollection(), getParentForChildren(), isClean());
                this.childCollection_ = null;
            }
            return this.childCollectionBuilder_;
        }

        @Override // proto.CollectionRelationOrBuilder
        public boolean hasParentCollection() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // proto.CollectionRelationOrBuilder
        public Collection getParentCollection() {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.parentCollectionBuilder_;
            if (singleFieldBuilder == null) {
                Collection collection = this.parentCollection_;
                return collection == null ? Collection.getDefaultInstance() : collection;
            }
            return (Collection) singleFieldBuilder.getMessage();
        }

        public Builder setParentCollection(Collection collection) {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.parentCollectionBuilder_;
            if (singleFieldBuilder == null) {
                collection.getClass();
                this.parentCollection_ = collection;
            } else {
                singleFieldBuilder.setMessage(collection);
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setParentCollection(Collection.Builder builder) {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.parentCollectionBuilder_;
            if (singleFieldBuilder == null) {
                this.parentCollection_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder mergeParentCollection(Collection collection) {
            Collection collection2;
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.parentCollectionBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0 && (collection2 = this.parentCollection_) != null && collection2 != Collection.getDefaultInstance()) {
                    getParentCollectionBuilder().mergeFrom((Message) collection);
                } else {
                    this.parentCollection_ = collection;
                }
            } else {
                singleFieldBuilder.mergeFrom(collection);
            }
            if (this.parentCollection_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder clearParentCollection() {
            this.bitField0_ &= -5;
            this.parentCollection_ = null;
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.parentCollectionBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.parentCollectionBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Collection.Builder getParentCollectionBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (Collection.Builder) getParentCollectionFieldBuilder().getBuilder();
        }

        @Override // proto.CollectionRelationOrBuilder
        public CollectionOrBuilder getParentCollectionOrBuilder() {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.parentCollectionBuilder_;
            if (singleFieldBuilder != null) {
                return (CollectionOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Collection collection = this.parentCollection_;
            return collection == null ? Collection.getDefaultInstance() : collection;
        }

        private SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> getParentCollectionFieldBuilder() {
            if (this.parentCollectionBuilder_ == null) {
                this.parentCollectionBuilder_ = new SingleFieldBuilder<>(getParentCollection(), getParentForChildren(), isClean());
                this.parentCollection_ = null;
            }
            return this.parentCollectionBuilder_;
        }

        @Override // proto.CollectionRelationOrBuilder
        public boolean hasType() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // proto.CollectionRelationOrBuilder
        public CollectionRelationType getType() {
            SingleFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder == null) {
                CollectionRelationType collectionRelationType = this.type_;
                return collectionRelationType == null ? CollectionRelationType.getDefaultInstance() : collectionRelationType;
            }
            return (CollectionRelationType) singleFieldBuilder.getMessage();
        }

        public Builder setType(CollectionRelationType collectionRelationType) {
            SingleFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder == null) {
                collectionRelationType.getClass();
                this.type_ = collectionRelationType;
            } else {
                singleFieldBuilder.setMessage(collectionRelationType);
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setType(CollectionRelationType.Builder builder) {
            SingleFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder == null) {
                this.type_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder mergeType(CollectionRelationType collectionRelationType) {
            CollectionRelationType collectionRelationType2;
            SingleFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 8) != 0 && (collectionRelationType2 = this.type_) != null && collectionRelationType2 != CollectionRelationType.getDefaultInstance()) {
                    getTypeBuilder().mergeFrom((Message) collectionRelationType);
                } else {
                    this.type_ = collectionRelationType;
                }
            } else {
                singleFieldBuilder.mergeFrom(collectionRelationType);
            }
            if (this.type_ != null) {
                this.bitField0_ |= 8;
                onChanged();
            }
            return this;
        }

        public Builder clearType() {
            this.bitField0_ &= -9;
            this.type_ = null;
            SingleFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.typeBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public CollectionRelationType.Builder getTypeBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (CollectionRelationType.Builder) getTypeFieldBuilder().getBuilder();
        }

        @Override // proto.CollectionRelationOrBuilder
        public CollectionRelationTypeOrBuilder getTypeOrBuilder() {
            SingleFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder != null) {
                return (CollectionRelationTypeOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            CollectionRelationType collectionRelationType = this.type_;
            return collectionRelationType == null ? CollectionRelationType.getDefaultInstance() : collectionRelationType;
        }

        private SingleFieldBuilder<CollectionRelationType, CollectionRelationType.Builder, CollectionRelationTypeOrBuilder> getTypeFieldBuilder() {
            if (this.typeBuilder_ == null) {
                this.typeBuilder_ = new SingleFieldBuilder<>(getType(), getParentForChildren(), isClean());
                this.type_ = null;
            }
            return this.typeBuilder_;
        }

        @Override // proto.CollectionRelationOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // proto.CollectionRelationOrBuilder
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

        @Override // proto.CollectionRelationOrBuilder
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

        @Override // proto.CollectionRelationOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // proto.CollectionRelationOrBuilder
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

        @Override // proto.CollectionRelationOrBuilder
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

        @Override // proto.CollectionRelationOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CollectionRelationOrBuilder
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
            this.checksum_ = CollectionRelation.getDefaultInstance().getChecksum();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            CollectionRelation.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }
    }

    public static CollectionRelation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.CollectionRelation$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CollectionRelation> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CollectionRelation parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CollectionRelation.newBuilder();
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

    public static Parser<CollectionRelation> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CollectionRelation> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CollectionRelation getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
