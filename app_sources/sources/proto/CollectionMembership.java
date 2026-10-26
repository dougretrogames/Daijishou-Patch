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
public final class CollectionMembership extends GeneratedMessage implements CollectionMembershipOrBuilder {
    public static final int CHECKSUM_FIELD_NUMBER = 7;
    public static final int COLLECTION_FIELD_NUMBER = 3;
    public static final int CREATED_AT_FIELD_NUMBER = 6;
    private static final CollectionMembership DEFAULT_INSTANCE;
    public static final int GAME_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 1;
    private static final Parser<CollectionMembership> PARSER;
    public static final int TYPE_FIELD_NUMBER = 4;
    public static final int UPDATED_AT_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object checksum_;
    private Collection collection_;
    private Timestamp createdAt_;
    private Game game_;
    private long id_;
    private CollectionMembershipType type_;
    private Timestamp updatedAt_;

    /* synthetic */ CollectionMembership(GeneratedMessage.Builder builder, CollectionMembershipIA collectionMembershipIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CollectionMembership.class.getName());
        DEFAULT_INSTANCE = new CollectionMembership();
        PARSER = new AnonymousClass1();
    }

    private CollectionMembership(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.checksum_ = "";
    }

    private CollectionMembership() {
        this.id_ = 0L;
        this.checksum_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CollectionMembership_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CollectionMembership_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionMembership.class, Builder.class);
    }

    @Override // proto.CollectionMembershipOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public boolean hasGame() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public Game getGame() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public GameOrBuilder getGameOrBuilder() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public boolean hasCollection() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public Collection getCollection() {
        Collection collection = this.collection_;
        return collection == null ? Collection.getDefaultInstance() : collection;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public CollectionOrBuilder getCollectionOrBuilder() {
        Collection collection = this.collection_;
        return collection == null ? Collection.getDefaultInstance() : collection;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public boolean hasType() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public CollectionMembershipType getType() {
        CollectionMembershipType collectionMembershipType = this.type_;
        return collectionMembershipType == null ? CollectionMembershipType.getDefaultInstance() : collectionMembershipType;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public CollectionMembershipTypeOrBuilder getTypeOrBuilder() {
        CollectionMembershipType collectionMembershipType = this.type_;
        return collectionMembershipType == null ? CollectionMembershipType.getDefaultInstance() : collectionMembershipType;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CollectionMembershipOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static CollectionMembership parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CollectionMembership parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CollectionMembership parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CollectionMembership parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CollectionMembership parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CollectionMembership parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CollectionMembership parseFrom(InputStream inputStream) throws IOException {
        return (CollectionMembership) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CollectionMembership parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionMembership) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionMembership parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CollectionMembership) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CollectionMembership parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionMembership) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionMembership parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CollectionMembership) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CollectionMembership parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionMembership) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CollectionMembership collectionMembership) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) collectionMembership);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CollectionMembershipIA) null) : (Builder) new Builder((CollectionMembershipIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CollectionMembershipOrBuilder {
        private int bitField0_;
        private Object checksum_;
        private SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> collectionBuilder_;
        private Collection collection_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> gameBuilder_;
        private Game game_;
        private long id_;
        private SingleFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> typeBuilder_;
        private CollectionMembershipType type_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CollectionMembershipIA collectionMembershipIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CollectionMembershipIA collectionMembershipIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CollectionMembership_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CollectionMembership_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionMembership.class, Builder.class);
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
            if (CollectionMembership.alwaysUseFieldBuilders) {
                getGameFieldBuilder();
                getCollectionFieldBuilder();
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
            this.game_ = null;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.gameBuilder_ = null;
            }
            this.collection_ = null;
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder2 = this.collectionBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.collectionBuilder_ = null;
            }
            this.type_ = null;
            SingleFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> singleFieldBuilder3 = this.typeBuilder_;
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
            return Igdbproto.internal_static_proto_CollectionMembership_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CollectionMembership getDefaultInstanceForType() {
            return CollectionMembership.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionMembership build() {
            CollectionMembership collectionMembershipBuildPartial = buildPartial();
            if (collectionMembershipBuildPartial.isInitialized()) {
                return collectionMembershipBuildPartial;
            }
            throw newUninitializedMessageException((Message) collectionMembershipBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionMembership buildPartial() {
            CollectionMembership collectionMembership = new CollectionMembership(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(collectionMembership);
            }
            onBuilt();
            return collectionMembership;
        }

        private void buildPartial0(CollectionMembership collectionMembership) {
            int i;
            Timestamp timestamp;
            Timestamp timestamp2;
            CollectionMembershipType collectionMembershipType;
            Collection collection;
            Game game;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                collectionMembership.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
                if (singleFieldBuilder == null) {
                    game = this.game_;
                } else {
                    game = (Game) singleFieldBuilder.build();
                }
                collectionMembership.game_ = game;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder2 = this.collectionBuilder_;
                if (singleFieldBuilder2 == null) {
                    collection = this.collection_;
                } else {
                    collection = (Collection) singleFieldBuilder2.build();
                }
                collectionMembership.collection_ = collection;
                i |= 2;
            }
            if ((i2 & 8) != 0) {
                SingleFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> singleFieldBuilder3 = this.typeBuilder_;
                if (singleFieldBuilder3 == null) {
                    collectionMembershipType = this.type_;
                } else {
                    collectionMembershipType = (CollectionMembershipType) singleFieldBuilder3.build();
                }
                collectionMembership.type_ = collectionMembershipType;
                i |= 4;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.updatedAtBuilder_;
                if (singleFieldBuilder4 == null) {
                    timestamp2 = this.updatedAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder4.build();
                }
                collectionMembership.updatedAt_ = timestamp2;
                i |= 8;
            }
            if ((i2 & 32) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder5 = this.createdAtBuilder_;
                if (singleFieldBuilder5 == null) {
                    timestamp = this.createdAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder5.build();
                }
                collectionMembership.createdAt_ = timestamp;
                i |= 16;
            }
            if ((i2 & 64) != 0) {
                collectionMembership.checksum_ = this.checksum_;
            }
            collectionMembership.bitField0_ |= i;
        }

        @Override // proto.CollectionMembershipOrBuilder
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

        @Override // proto.CollectionMembershipOrBuilder
        public boolean hasGame() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // proto.CollectionMembershipOrBuilder
        public Game getGame() {
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                Game game = this.game_;
                return game == null ? Game.getDefaultInstance() : game;
            }
            return (Game) singleFieldBuilder.getMessage();
        }

        public Builder setGame(Game game) {
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                game.getClass();
                this.game_ = game;
            } else {
                singleFieldBuilder.setMessage(game);
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setGame(Game.Builder builder) {
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                this.game_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder mergeGame(Game game) {
            Game game2;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 2) != 0 && (game2 = this.game_) != null && game2 != Game.getDefaultInstance()) {
                    getGameBuilder().mergeFrom((Message) game);
                } else {
                    this.game_ = game;
                }
            } else {
                singleFieldBuilder.mergeFrom(game);
            }
            if (this.game_ != null) {
                this.bitField0_ |= 2;
                onChanged();
            }
            return this;
        }

        public Builder clearGame() {
            this.bitField0_ &= -3;
            this.game_ = null;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.gameBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Game.Builder getGameBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (Game.Builder) getGameFieldBuilder().getBuilder();
        }

        @Override // proto.CollectionMembershipOrBuilder
        public GameOrBuilder getGameOrBuilder() {
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder != null) {
                return (GameOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Game game = this.game_;
            return game == null ? Game.getDefaultInstance() : game;
        }

        private SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> getGameFieldBuilder() {
            if (this.gameBuilder_ == null) {
                this.gameBuilder_ = new SingleFieldBuilder<>(getGame(), getParentForChildren(), isClean());
                this.game_ = null;
            }
            return this.gameBuilder_;
        }

        @Override // proto.CollectionMembershipOrBuilder
        public boolean hasCollection() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // proto.CollectionMembershipOrBuilder
        public Collection getCollection() {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder == null) {
                Collection collection = this.collection_;
                return collection == null ? Collection.getDefaultInstance() : collection;
            }
            return (Collection) singleFieldBuilder.getMessage();
        }

        public Builder setCollection(Collection collection) {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder == null) {
                collection.getClass();
                this.collection_ = collection;
            } else {
                singleFieldBuilder.setMessage(collection);
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setCollection(Collection.Builder builder) {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder == null) {
                this.collection_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder mergeCollection(Collection collection) {
            Collection collection2;
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0 && (collection2 = this.collection_) != null && collection2 != Collection.getDefaultInstance()) {
                    getCollectionBuilder().mergeFrom((Message) collection);
                } else {
                    this.collection_ = collection;
                }
            } else {
                singleFieldBuilder.mergeFrom(collection);
            }
            if (this.collection_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder clearCollection() {
            this.bitField0_ &= -5;
            this.collection_ = null;
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.collectionBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Collection.Builder getCollectionBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (Collection.Builder) getCollectionFieldBuilder().getBuilder();
        }

        @Override // proto.CollectionMembershipOrBuilder
        public CollectionOrBuilder getCollectionOrBuilder() {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder != null) {
                return (CollectionOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Collection collection = this.collection_;
            return collection == null ? Collection.getDefaultInstance() : collection;
        }

        private SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> getCollectionFieldBuilder() {
            if (this.collectionBuilder_ == null) {
                this.collectionBuilder_ = new SingleFieldBuilder<>(getCollection(), getParentForChildren(), isClean());
                this.collection_ = null;
            }
            return this.collectionBuilder_;
        }

        @Override // proto.CollectionMembershipOrBuilder
        public boolean hasType() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // proto.CollectionMembershipOrBuilder
        public CollectionMembershipType getType() {
            SingleFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder == null) {
                CollectionMembershipType collectionMembershipType = this.type_;
                return collectionMembershipType == null ? CollectionMembershipType.getDefaultInstance() : collectionMembershipType;
            }
            return (CollectionMembershipType) singleFieldBuilder.getMessage();
        }

        public Builder setType(CollectionMembershipType collectionMembershipType) {
            SingleFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder == null) {
                collectionMembershipType.getClass();
                this.type_ = collectionMembershipType;
            } else {
                singleFieldBuilder.setMessage(collectionMembershipType);
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setType(CollectionMembershipType.Builder builder) {
            SingleFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder == null) {
                this.type_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder mergeType(CollectionMembershipType collectionMembershipType) {
            CollectionMembershipType collectionMembershipType2;
            SingleFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 8) != 0 && (collectionMembershipType2 = this.type_) != null && collectionMembershipType2 != CollectionMembershipType.getDefaultInstance()) {
                    getTypeBuilder().mergeFrom((Message) collectionMembershipType);
                } else {
                    this.type_ = collectionMembershipType;
                }
            } else {
                singleFieldBuilder.mergeFrom(collectionMembershipType);
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
            SingleFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.typeBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public CollectionMembershipType.Builder getTypeBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (CollectionMembershipType.Builder) getTypeFieldBuilder().getBuilder();
        }

        @Override // proto.CollectionMembershipOrBuilder
        public CollectionMembershipTypeOrBuilder getTypeOrBuilder() {
            SingleFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> singleFieldBuilder = this.typeBuilder_;
            if (singleFieldBuilder != null) {
                return (CollectionMembershipTypeOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            CollectionMembershipType collectionMembershipType = this.type_;
            return collectionMembershipType == null ? CollectionMembershipType.getDefaultInstance() : collectionMembershipType;
        }

        private SingleFieldBuilder<CollectionMembershipType, CollectionMembershipType.Builder, CollectionMembershipTypeOrBuilder> getTypeFieldBuilder() {
            if (this.typeBuilder_ == null) {
                this.typeBuilder_ = new SingleFieldBuilder<>(getType(), getParentForChildren(), isClean());
                this.type_ = null;
            }
            return this.typeBuilder_;
        }

        @Override // proto.CollectionMembershipOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // proto.CollectionMembershipOrBuilder
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

        @Override // proto.CollectionMembershipOrBuilder
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

        @Override // proto.CollectionMembershipOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // proto.CollectionMembershipOrBuilder
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

        @Override // proto.CollectionMembershipOrBuilder
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

        @Override // proto.CollectionMembershipOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CollectionMembershipOrBuilder
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
            this.checksum_ = CollectionMembership.getDefaultInstance().getChecksum();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            CollectionMembership.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }
    }

    public static CollectionMembership getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.CollectionMembership$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CollectionMembership> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CollectionMembership parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CollectionMembership.newBuilder();
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

    public static Parser<CollectionMembership> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CollectionMembership> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CollectionMembership getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
