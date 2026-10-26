package proto;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public final class Collection extends GeneratedMessage implements CollectionOrBuilder {
    public static final int AS_CHILD_RELATIONS_FIELD_NUMBER = 11;
    public static final int AS_PARENT_RELATIONS_FIELD_NUMBER = 10;
    public static final int CHECKSUM_FIELD_NUMBER = 8;
    public static final int CREATED_AT_FIELD_NUMBER = 2;
    private static final Collection DEFAULT_INSTANCE;
    public static final int GAMES_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    private static final Parser<Collection> PARSER;
    public static final int SLUG_FIELD_NUMBER = 5;
    public static final int TYPE_FIELD_NUMBER = 9;
    public static final int UPDATED_AT_FIELD_NUMBER = 6;
    public static final int URL_FIELD_NUMBER = 7;
    private static final long serialVersionUID = 0;
    private List<CollectionRelation> asChildRelations_;
    private List<CollectionRelation> asParentRelations_;
    private int bitField0_;
    private volatile Object checksum_;
    private Timestamp createdAt_;
    private List<Game> games_;
    private long id_;
    private volatile Object name_;
    private volatile Object slug_;
    private CollectionType type_;
    private Timestamp updatedAt_;
    private volatile Object url_;

    /* synthetic */ Collection(GeneratedMessage.Builder builder, CollectionIA collectionIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Collection.class.getName());
        DEFAULT_INSTANCE = new Collection();
        PARSER = new AnonymousClass1();
    }

    private Collection(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.name_ = "";
        this.slug_ = "";
        this.url_ = "";
        this.checksum_ = "";
    }

    private Collection() {
        this.id_ = 0L;
        this.name_ = "";
        this.slug_ = "";
        this.url_ = "";
        this.checksum_ = "";
        this.games_ = Collections.emptyList();
        this.name_ = "";
        this.slug_ = "";
        this.url_ = "";
        this.checksum_ = "";
        this.asParentRelations_ = Collections.emptyList();
        this.asChildRelations_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_Collection_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_Collection_fieldAccessorTable.ensureFieldAccessorsInitialized(Collection.class, Builder.class);
    }

    @Override // proto.CollectionOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.CollectionOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.CollectionOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CollectionOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CollectionOrBuilder
    public List<Game> getGamesList() {
        return this.games_;
    }

    @Override // proto.CollectionOrBuilder
    public List<? extends GameOrBuilder> getGamesOrBuilderList() {
        return this.games_;
    }

    @Override // proto.CollectionOrBuilder
    public int getGamesCount() {
        return this.games_.size();
    }

    @Override // proto.CollectionOrBuilder
    public Game getGames(int i) {
        return this.games_.get(i);
    }

    @Override // proto.CollectionOrBuilder
    public GameOrBuilder getGamesOrBuilder(int i) {
        return this.games_.get(i);
    }

    @Override // proto.CollectionOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CollectionOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CollectionOrBuilder
    public String getSlug() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.slug_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CollectionOrBuilder
    public ByteString getSlugBytes() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.slug_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CollectionOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.CollectionOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CollectionOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CollectionOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CollectionOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CollectionOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CollectionOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CollectionOrBuilder
    public boolean hasType() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.CollectionOrBuilder
    public CollectionType getType() {
        CollectionType collectionType = this.type_;
        return collectionType == null ? CollectionType.getDefaultInstance() : collectionType;
    }

    @Override // proto.CollectionOrBuilder
    public CollectionTypeOrBuilder getTypeOrBuilder() {
        CollectionType collectionType = this.type_;
        return collectionType == null ? CollectionType.getDefaultInstance() : collectionType;
    }

    @Override // proto.CollectionOrBuilder
    public List<CollectionRelation> getAsParentRelationsList() {
        return this.asParentRelations_;
    }

    @Override // proto.CollectionOrBuilder
    public List<? extends CollectionRelationOrBuilder> getAsParentRelationsOrBuilderList() {
        return this.asParentRelations_;
    }

    @Override // proto.CollectionOrBuilder
    public int getAsParentRelationsCount() {
        return this.asParentRelations_.size();
    }

    @Override // proto.CollectionOrBuilder
    public CollectionRelation getAsParentRelations(int i) {
        return this.asParentRelations_.get(i);
    }

    @Override // proto.CollectionOrBuilder
    public CollectionRelationOrBuilder getAsParentRelationsOrBuilder(int i) {
        return this.asParentRelations_.get(i);
    }

    @Override // proto.CollectionOrBuilder
    public List<CollectionRelation> getAsChildRelationsList() {
        return this.asChildRelations_;
    }

    @Override // proto.CollectionOrBuilder
    public List<? extends CollectionRelationOrBuilder> getAsChildRelationsOrBuilderList() {
        return this.asChildRelations_;
    }

    @Override // proto.CollectionOrBuilder
    public int getAsChildRelationsCount() {
        return this.asChildRelations_.size();
    }

    @Override // proto.CollectionOrBuilder
    public CollectionRelation getAsChildRelations(int i) {
        return this.asChildRelations_.get(i);
    }

    @Override // proto.CollectionOrBuilder
    public CollectionRelationOrBuilder getAsChildRelationsOrBuilder(int i) {
        return this.asChildRelations_.get(i);
    }

    public static Collection parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Collection parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Collection parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Collection parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Collection parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Collection parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Collection parseFrom(InputStream inputStream) throws IOException {
        return (Collection) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Collection parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Collection) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Collection parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Collection) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Collection parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Collection) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Collection parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Collection) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Collection parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Collection) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(Collection collection) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) collection);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CollectionIA) null) : (Builder) new Builder((CollectionIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CollectionOrBuilder {
        private RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> asChildRelationsBuilder_;
        private List<CollectionRelation> asChildRelations_;
        private RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> asParentRelationsBuilder_;
        private List<CollectionRelation> asParentRelations_;
        private int bitField0_;
        private Object checksum_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> gamesBuilder_;
        private List<Game> games_;
        private long id_;
        private Object name_;
        private Object slug_;
        private SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> typeBuilder_;
        private CollectionType type_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;
        private Object url_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CollectionIA collectionIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CollectionIA collectionIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_Collection_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_Collection_fieldAccessorTable.ensureFieldAccessorsInitialized(Collection.class, Builder.class);
        }

        private Builder() {
            this.games_ = Collections.emptyList();
            this.name_ = "";
            this.slug_ = "";
            this.url_ = "";
            this.checksum_ = "";
            this.asParentRelations_ = Collections.emptyList();
            this.asChildRelations_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.games_ = Collections.emptyList();
            this.name_ = "";
            this.slug_ = "";
            this.url_ = "";
            this.checksum_ = "";
            this.asParentRelations_ = Collections.emptyList();
            this.asChildRelations_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (Collection.alwaysUseFieldBuilders) {
                getCreatedAtFieldBuilder();
                getGamesFieldBuilder();
                getUpdatedAtFieldBuilder();
                getTypeFieldBuilder();
                getAsParentRelationsFieldBuilder();
                getAsChildRelationsFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.createdAtBuilder_ = null;
            }
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.games_ = Collections.emptyList();
            } else {
                this.games_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -5;
            this.name_ = "";
            this.slug_ = "";
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.updatedAtBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.url_ = "";
            this.checksum_ = "";
            this.type_ = null;
            SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> singleFieldBuilder3 = this.typeBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.typeBuilder_ = null;
            }
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder2 = this.asParentRelationsBuilder_;
            if (repeatedFieldBuilder2 == null) {
                this.asParentRelations_ = Collections.emptyList();
            } else {
                this.asParentRelations_ = null;
                repeatedFieldBuilder2.clear();
            }
            this.bitField0_ &= -513;
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder3 = this.asChildRelationsBuilder_;
            if (repeatedFieldBuilder3 == null) {
                this.asChildRelations_ = Collections.emptyList();
            } else {
                this.asChildRelations_ = null;
                repeatedFieldBuilder3.clear();
            }
            this.bitField0_ &= -1025;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_Collection_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Collection getDefaultInstanceForType() {
            return Collection.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Collection build() {
            Collection collectionBuildPartial = buildPartial();
            if (collectionBuildPartial.isInitialized()) {
                return collectionBuildPartial;
            }
            throw newUninitializedMessageException((Message) collectionBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Collection buildPartial() {
            Collection collection = new Collection(this, null);
            buildPartialRepeatedFields(collection);
            if (this.bitField0_ != 0) {
                buildPartial0(collection);
            }
            onBuilt();
            return collection;
        }

        private void buildPartialRepeatedFields(Collection collection) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0) {
                    this.games_ = Collections.unmodifiableList(this.games_);
                    this.bitField0_ &= -5;
                }
                collection.games_ = this.games_;
            } else {
                collection.games_ = repeatedFieldBuilder.build();
            }
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder2 = this.asParentRelationsBuilder_;
            if (repeatedFieldBuilder2 == null) {
                if ((this.bitField0_ & 512) != 0) {
                    this.asParentRelations_ = Collections.unmodifiableList(this.asParentRelations_);
                    this.bitField0_ &= -513;
                }
                collection.asParentRelations_ = this.asParentRelations_;
            } else {
                collection.asParentRelations_ = repeatedFieldBuilder2.build();
            }
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder3 = this.asChildRelationsBuilder_;
            if (repeatedFieldBuilder3 == null) {
                if ((this.bitField0_ & 1024) != 0) {
                    this.asChildRelations_ = Collections.unmodifiableList(this.asChildRelations_);
                    this.bitField0_ &= -1025;
                }
                collection.asChildRelations_ = this.asChildRelations_;
                return;
            }
            collection.asChildRelations_ = repeatedFieldBuilder3.build();
        }

        private void buildPartial0(Collection collection) {
            int i;
            CollectionType collectionType;
            Timestamp timestamp;
            Timestamp timestamp2;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                collection.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
                if (singleFieldBuilder == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder.build();
                }
                collection.createdAt_ = timestamp2;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                collection.name_ = this.name_;
            }
            if ((i2 & 16) != 0) {
                collection.slug_ = this.slug_;
            }
            if ((i2 & 32) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.updatedAtBuilder_;
                if (singleFieldBuilder2 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder2.build();
                }
                collection.updatedAt_ = timestamp;
                i |= 2;
            }
            if ((i2 & 64) != 0) {
                collection.url_ = this.url_;
            }
            if ((i2 & 128) != 0) {
                collection.checksum_ = this.checksum_;
            }
            if ((i2 & 256) != 0) {
                SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> singleFieldBuilder3 = this.typeBuilder_;
                if (singleFieldBuilder3 == null) {
                    collectionType = this.type_;
                } else {
                    collectionType = (CollectionType) singleFieldBuilder3.build();
                }
                collection.type_ = collectionType;
                i |= 4;
            }
            collection.bitField0_ |= i;
        }

        @Override // proto.CollectionOrBuilder
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

        @Override // proto.CollectionOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // proto.CollectionOrBuilder
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
            this.bitField0_ |= 2;
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
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder mergeCreatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 2) != 0 && (timestamp2 = this.createdAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getCreatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.createdAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.createdAt_ != null) {
                this.bitField0_ |= 2;
                onChanged();
            }
            return this;
        }

        public Builder clearCreatedAt() {
            this.bitField0_ &= -3;
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
            this.bitField0_ |= 2;
            onChanged();
            return (Timestamp.Builder) getCreatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.CollectionOrBuilder
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

        private void ensureGamesIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.games_ = new ArrayList(this.games_);
                this.bitField0_ |= 4;
            }
        }

        @Override // proto.CollectionOrBuilder
        public List<Game> getGamesList() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.games_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CollectionOrBuilder
        public int getGamesCount() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.games_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CollectionOrBuilder
        public Game getGames(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.games_.get(i);
            }
            return (Game) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setGames(int i, Game game) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureGamesIsMutable();
                this.games_.set(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, game);
            return this;
        }

        public Builder setGames(int i, Game.Builder builder) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamesIsMutable();
                this.games_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addGames(Game game) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureGamesIsMutable();
                this.games_.add(game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(game);
            return this;
        }

        public Builder addGames(int i, Game game) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureGamesIsMutable();
                this.games_.add(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, game);
            return this;
        }

        public Builder addGames(Game.Builder builder) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamesIsMutable();
                this.games_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addGames(int i, Game.Builder builder) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamesIsMutable();
                this.games_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllGames(Iterable<? extends Game> iterable) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.games_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearGames() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.games_ = Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeGames(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamesIsMutable();
                this.games_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Game.Builder getGamesBuilder(int i) {
            return (Game.Builder) getGamesFieldBuilder().getBuilder(i);
        }

        @Override // proto.CollectionOrBuilder
        public GameOrBuilder getGamesOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.games_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CollectionOrBuilder
        public List<? extends GameOrBuilder> getGamesOrBuilderList() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.games_);
        }

        public Game.Builder addGamesBuilder() {
            return (Game.Builder) getGamesFieldBuilder().addBuilder(Game.getDefaultInstance());
        }

        public Game.Builder addGamesBuilder(int i) {
            return (Game.Builder) getGamesFieldBuilder().addBuilder(i, Game.getDefaultInstance());
        }

        public List<Game.Builder> getGamesBuilderList() {
            return getGamesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> getGamesFieldBuilder() {
            if (this.gamesBuilder_ == null) {
                this.gamesBuilder_ = new RepeatedFieldBuilder<>(this.games_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                this.games_ = null;
            }
            return this.gamesBuilder_;
        }

        @Override // proto.CollectionOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CollectionOrBuilder
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
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Collection.getDefaultInstance().getName();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            Collection.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // proto.CollectionOrBuilder
        public String getSlug() {
            Object obj = this.slug_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.slug_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CollectionOrBuilder
        public ByteString getSlugBytes() {
            Object obj = this.slug_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.slug_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setSlug(String str) {
            str.getClass();
            this.slug_ = str;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearSlug() {
            this.slug_ = Collection.getDefaultInstance().getSlug();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder setSlugBytes(ByteString byteString) {
            byteString.getClass();
            Collection.checkByteStringIsUtf8(byteString);
            this.slug_ = byteString;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        @Override // proto.CollectionOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // proto.CollectionOrBuilder
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
            this.bitField0_ |= 32;
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
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder mergeUpdatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 32) != 0 && (timestamp2 = this.updatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getUpdatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.updatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.updatedAt_ != null) {
                this.bitField0_ |= 32;
                onChanged();
            }
            return this;
        }

        public Builder clearUpdatedAt() {
            this.bitField0_ &= -33;
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
            this.bitField0_ |= 32;
            onChanged();
            return (Timestamp.Builder) getUpdatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.CollectionOrBuilder
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

        @Override // proto.CollectionOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CollectionOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setUrl(String str) {
            str.getClass();
            this.url_ = str;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = Collection.getDefaultInstance().getUrl();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            Collection.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        @Override // proto.CollectionOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CollectionOrBuilder
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
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = Collection.getDefaultInstance().getChecksum();
            this.bitField0_ &= -129;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            Collection.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        @Override // proto.CollectionOrBuilder
        public boolean hasType() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // proto.CollectionOrBuilder
        public CollectionType getType() {
            SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder == null) {
                CollectionType collectionType = this.type_;
                return collectionType == null ? CollectionType.getDefaultInstance() : collectionType;
            }
            return (CollectionType) singleFieldBuilder.getMessage();
        }

        public Builder setType(CollectionType collectionType) {
            SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder == null) {
                collectionType.getClass();
                this.type_ = collectionType;
            } else {
                singleFieldBuilder.setMessage(collectionType);
            }
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setType(CollectionType.Builder builder) {
            SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder == null) {
                this.type_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder mergeType(CollectionType collectionType) {
            CollectionType collectionType2;
            SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 256) != 0 && (collectionType2 = this.type_) != null && collectionType2 != CollectionType.getDefaultInstance()) {
                    getTypeBuilder().mergeFrom((Message) collectionType);
                } else {
                    this.type_ = collectionType;
                }
            } else {
                singleFieldBuilder.mergeFrom(collectionType);
            }
            if (this.type_ != null) {
                this.bitField0_ |= 256;
                onChanged();
            }
            return this;
        }

        public Builder clearType() {
            this.bitField0_ &= -257;
            this.type_ = null;
            SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.typeBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public CollectionType.Builder getTypeBuilder() {
            this.bitField0_ |= 256;
            onChanged();
            return (CollectionType.Builder) getTypeFieldBuilder().getBuilder();
        }

        @Override // proto.CollectionOrBuilder
        public CollectionTypeOrBuilder getTypeOrBuilder() {
            SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder != null) {
                return (CollectionTypeOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            CollectionType collectionType = this.type_;
            return collectionType == null ? CollectionType.getDefaultInstance() : collectionType;
        }

        private SingleFieldBuilder<CollectionType, CollectionType.Builder, CollectionTypeOrBuilder> getTypeFieldBuilder() {
            if (this.typeBuilder_ == null) {
                this.typeBuilder_ = new SingleFieldBuilder<>(getType(), getParentForChildren(), isClean());
                this.type_ = null;
            }
            return this.typeBuilder_;
        }

        private void ensureAsParentRelationsIsMutable() {
            if ((this.bitField0_ & 512) == 0) {
                this.asParentRelations_ = new ArrayList(this.asParentRelations_);
                this.bitField0_ |= 512;
            }
        }

        @Override // proto.CollectionOrBuilder
        public List<CollectionRelation> getAsParentRelationsList() {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asParentRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.asParentRelations_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CollectionOrBuilder
        public int getAsParentRelationsCount() {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asParentRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.asParentRelations_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CollectionOrBuilder
        public CollectionRelation getAsParentRelations(int i) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asParentRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.asParentRelations_.get(i);
            }
            return (CollectionRelation) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setAsParentRelations(int i, CollectionRelation collectionRelation) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asParentRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionRelation.getClass();
                ensureAsParentRelationsIsMutable();
                this.asParentRelations_.set(i, collectionRelation);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, collectionRelation);
            return this;
        }

        public Builder setAsParentRelations(int i, CollectionRelation.Builder builder) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asParentRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAsParentRelationsIsMutable();
                this.asParentRelations_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addAsParentRelations(CollectionRelation collectionRelation) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asParentRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionRelation.getClass();
                ensureAsParentRelationsIsMutable();
                this.asParentRelations_.add(collectionRelation);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(collectionRelation);
            return this;
        }

        public Builder addAsParentRelations(int i, CollectionRelation collectionRelation) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asParentRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionRelation.getClass();
                ensureAsParentRelationsIsMutable();
                this.asParentRelations_.add(i, collectionRelation);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, collectionRelation);
            return this;
        }

        public Builder addAsParentRelations(CollectionRelation.Builder builder) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asParentRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAsParentRelationsIsMutable();
                this.asParentRelations_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addAsParentRelations(int i, CollectionRelation.Builder builder) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asParentRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAsParentRelationsIsMutable();
                this.asParentRelations_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllAsParentRelations(Iterable<? extends CollectionRelation> iterable) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asParentRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAsParentRelationsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.asParentRelations_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearAsParentRelations() {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asParentRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.asParentRelations_ = Collections.emptyList();
                this.bitField0_ &= -513;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeAsParentRelations(int i) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asParentRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAsParentRelationsIsMutable();
                this.asParentRelations_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public CollectionRelation.Builder getAsParentRelationsBuilder(int i) {
            return (CollectionRelation.Builder) getAsParentRelationsFieldBuilder().getBuilder(i);
        }

        @Override // proto.CollectionOrBuilder
        public CollectionRelationOrBuilder getAsParentRelationsOrBuilder(int i) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asParentRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.asParentRelations_.get(i);
            }
            return (CollectionRelationOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CollectionOrBuilder
        public List<? extends CollectionRelationOrBuilder> getAsParentRelationsOrBuilderList() {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asParentRelationsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.asParentRelations_);
        }

        public CollectionRelation.Builder addAsParentRelationsBuilder() {
            return (CollectionRelation.Builder) getAsParentRelationsFieldBuilder().addBuilder(CollectionRelation.getDefaultInstance());
        }

        public CollectionRelation.Builder addAsParentRelationsBuilder(int i) {
            return (CollectionRelation.Builder) getAsParentRelationsFieldBuilder().addBuilder(i, CollectionRelation.getDefaultInstance());
        }

        public List<CollectionRelation.Builder> getAsParentRelationsBuilderList() {
            return getAsParentRelationsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> getAsParentRelationsFieldBuilder() {
            if (this.asParentRelationsBuilder_ == null) {
                this.asParentRelationsBuilder_ = new RepeatedFieldBuilder<>(this.asParentRelations_, (this.bitField0_ & 512) != 0, getParentForChildren(), isClean());
                this.asParentRelations_ = null;
            }
            return this.asParentRelationsBuilder_;
        }

        private void ensureAsChildRelationsIsMutable() {
            if ((this.bitField0_ & 1024) == 0) {
                this.asChildRelations_ = new ArrayList(this.asChildRelations_);
                this.bitField0_ |= 1024;
            }
        }

        @Override // proto.CollectionOrBuilder
        public List<CollectionRelation> getAsChildRelationsList() {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asChildRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.asChildRelations_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CollectionOrBuilder
        public int getAsChildRelationsCount() {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asChildRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.asChildRelations_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CollectionOrBuilder
        public CollectionRelation getAsChildRelations(int i) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asChildRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.asChildRelations_.get(i);
            }
            return (CollectionRelation) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setAsChildRelations(int i, CollectionRelation collectionRelation) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asChildRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionRelation.getClass();
                ensureAsChildRelationsIsMutable();
                this.asChildRelations_.set(i, collectionRelation);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, collectionRelation);
            return this;
        }

        public Builder setAsChildRelations(int i, CollectionRelation.Builder builder) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asChildRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAsChildRelationsIsMutable();
                this.asChildRelations_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addAsChildRelations(CollectionRelation collectionRelation) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asChildRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionRelation.getClass();
                ensureAsChildRelationsIsMutable();
                this.asChildRelations_.add(collectionRelation);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(collectionRelation);
            return this;
        }

        public Builder addAsChildRelations(int i, CollectionRelation collectionRelation) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asChildRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                collectionRelation.getClass();
                ensureAsChildRelationsIsMutable();
                this.asChildRelations_.add(i, collectionRelation);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, collectionRelation);
            return this;
        }

        public Builder addAsChildRelations(CollectionRelation.Builder builder) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asChildRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAsChildRelationsIsMutable();
                this.asChildRelations_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addAsChildRelations(int i, CollectionRelation.Builder builder) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asChildRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAsChildRelationsIsMutable();
                this.asChildRelations_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllAsChildRelations(Iterable<? extends CollectionRelation> iterable) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asChildRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAsChildRelationsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.asChildRelations_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearAsChildRelations() {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asChildRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.asChildRelations_ = Collections.emptyList();
                this.bitField0_ &= -1025;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeAsChildRelations(int i) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asChildRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAsChildRelationsIsMutable();
                this.asChildRelations_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public CollectionRelation.Builder getAsChildRelationsBuilder(int i) {
            return (CollectionRelation.Builder) getAsChildRelationsFieldBuilder().getBuilder(i);
        }

        @Override // proto.CollectionOrBuilder
        public CollectionRelationOrBuilder getAsChildRelationsOrBuilder(int i) {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asChildRelationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.asChildRelations_.get(i);
            }
            return (CollectionRelationOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CollectionOrBuilder
        public List<? extends CollectionRelationOrBuilder> getAsChildRelationsOrBuilderList() {
            RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> repeatedFieldBuilder = this.asChildRelationsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.asChildRelations_);
        }

        public CollectionRelation.Builder addAsChildRelationsBuilder() {
            return (CollectionRelation.Builder) getAsChildRelationsFieldBuilder().addBuilder(CollectionRelation.getDefaultInstance());
        }

        public CollectionRelation.Builder addAsChildRelationsBuilder(int i) {
            return (CollectionRelation.Builder) getAsChildRelationsFieldBuilder().addBuilder(i, CollectionRelation.getDefaultInstance());
        }

        public List<CollectionRelation.Builder> getAsChildRelationsBuilderList() {
            return getAsChildRelationsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<CollectionRelation, CollectionRelation.Builder, CollectionRelationOrBuilder> getAsChildRelationsFieldBuilder() {
            if (this.asChildRelationsBuilder_ == null) {
                this.asChildRelationsBuilder_ = new RepeatedFieldBuilder<>(this.asChildRelations_, (this.bitField0_ & 1024) != 0, getParentForChildren(), isClean());
                this.asChildRelations_ = null;
            }
            return this.asChildRelationsBuilder_;
        }
    }

    public static Collection getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.Collection$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Collection> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public Collection parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Collection.newBuilder();
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

    public static Parser<Collection> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Collection> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Collection getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
