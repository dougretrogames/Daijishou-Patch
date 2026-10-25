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

/* JADX INFO: loaded from: classes6.dex */
public final class Franchise extends GeneratedMessage implements FranchiseOrBuilder {
    public static final int CHECKSUM_FIELD_NUMBER = 8;
    public static final int CREATED_AT_FIELD_NUMBER = 2;
    private static final Franchise DEFAULT_INSTANCE;
    public static final int GAMES_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    private static final Parser<Franchise> PARSER;
    public static final int SLUG_FIELD_NUMBER = 5;
    public static final int UPDATED_AT_FIELD_NUMBER = 6;
    public static final int URL_FIELD_NUMBER = 7;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object checksum_;
    private Timestamp createdAt_;
    private List<Game> games_;
    private long id_;
    private volatile Object name_;
    private volatile Object slug_;
    private Timestamp updatedAt_;
    private volatile Object url_;

    /* synthetic */ Franchise(GeneratedMessage.Builder builder, FranchiseIA franchiseIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Franchise.class.getName());
        DEFAULT_INSTANCE = new Franchise();
        PARSER = new AnonymousClass1();
    }

    private Franchise(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.name_ = "";
        this.slug_ = "";
        this.url_ = "";
        this.checksum_ = "";
    }

    private Franchise() {
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
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_Franchise_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_Franchise_fieldAccessorTable.ensureFieldAccessorsInitialized(Franchise.class, Builder.class);
    }

    @Override // proto.FranchiseOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.FranchiseOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.FranchiseOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.FranchiseOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.FranchiseOrBuilder
    public List<Game> getGamesList() {
        return this.games_;
    }

    @Override // proto.FranchiseOrBuilder
    public List<? extends GameOrBuilder> getGamesOrBuilderList() {
        return this.games_;
    }

    @Override // proto.FranchiseOrBuilder
    public int getGamesCount() {
        return this.games_.size();
    }

    @Override // proto.FranchiseOrBuilder
    public Game getGames(int i) {
        return this.games_.get(i);
    }

    @Override // proto.FranchiseOrBuilder
    public GameOrBuilder getGamesOrBuilder(int i) {
        return this.games_.get(i);
    }

    @Override // proto.FranchiseOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.FranchiseOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.FranchiseOrBuilder
    public String getSlug() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.slug_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.FranchiseOrBuilder
    public ByteString getSlugBytes() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.slug_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.FranchiseOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.FranchiseOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.FranchiseOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.FranchiseOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.FranchiseOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.FranchiseOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.FranchiseOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static Franchise parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Franchise parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Franchise parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Franchise parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Franchise parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Franchise parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Franchise parseFrom(InputStream inputStream) throws IOException {
        return (Franchise) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Franchise parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Franchise) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Franchise parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Franchise) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Franchise parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Franchise) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Franchise parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Franchise) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Franchise parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Franchise) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(Franchise franchise) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) franchise);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((FranchiseIA) null) : (Builder) new Builder((FranchiseIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements FranchiseOrBuilder {
        private int bitField0_;
        private Object checksum_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> gamesBuilder_;
        private List<Game> games_;
        private long id_;
        private Object name_;
        private Object slug_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;
        private Object url_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, FranchiseIA franchiseIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(FranchiseIA franchiseIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_Franchise_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_Franchise_fieldAccessorTable.ensureFieldAccessorsInitialized(Franchise.class, Builder.class);
        }

        private Builder() {
            this.games_ = Collections.emptyList();
            this.name_ = "";
            this.slug_ = "";
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.games_ = Collections.emptyList();
            this.name_ = "";
            this.slug_ = "";
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (Franchise.alwaysUseFieldBuilders) {
                getCreatedAtFieldBuilder();
                getGamesFieldBuilder();
                getUpdatedAtFieldBuilder();
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
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_Franchise_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Franchise getDefaultInstanceForType() {
            return Franchise.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Franchise build() {
            Franchise franchiseBuildPartial = buildPartial();
            if (franchiseBuildPartial.isInitialized()) {
                return franchiseBuildPartial;
            }
            throw newUninitializedMessageException((Message) franchiseBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Franchise buildPartial() {
            Franchise franchise = new Franchise(this, null);
            buildPartialRepeatedFields(franchise);
            if (this.bitField0_ != 0) {
                buildPartial0(franchise);
            }
            onBuilt();
            return franchise;
        }

        private void buildPartialRepeatedFields(Franchise franchise) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0) {
                    this.games_ = Collections.unmodifiableList(this.games_);
                    this.bitField0_ &= -5;
                }
                franchise.games_ = this.games_;
                return;
            }
            franchise.games_ = repeatedFieldBuilder.build();
        }

        private void buildPartial0(Franchise franchise) {
            int i;
            Timestamp timestamp;
            Timestamp timestamp2;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                franchise.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
                if (singleFieldBuilder == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder.build();
                }
                franchise.createdAt_ = timestamp2;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                franchise.name_ = this.name_;
            }
            if ((i2 & 16) != 0) {
                franchise.slug_ = this.slug_;
            }
            if ((i2 & 32) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.updatedAtBuilder_;
                if (singleFieldBuilder2 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder2.build();
                }
                franchise.updatedAt_ = timestamp;
                i |= 2;
            }
            if ((i2 & 64) != 0) {
                franchise.url_ = this.url_;
            }
            if ((i2 & 128) != 0) {
                franchise.checksum_ = this.checksum_;
            }
            franchise.bitField0_ |= i;
        }

        @Override // proto.FranchiseOrBuilder
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

        @Override // proto.FranchiseOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // proto.FranchiseOrBuilder
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

        @Override // proto.FranchiseOrBuilder
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

        @Override // proto.FranchiseOrBuilder
        public List<Game> getGamesList() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.games_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.FranchiseOrBuilder
        public int getGamesCount() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.games_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.FranchiseOrBuilder
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

        @Override // proto.FranchiseOrBuilder
        public GameOrBuilder getGamesOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.games_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.FranchiseOrBuilder
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

        @Override // proto.FranchiseOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.FranchiseOrBuilder
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
            this.name_ = Franchise.getDefaultInstance().getName();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            Franchise.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // proto.FranchiseOrBuilder
        public String getSlug() {
            Object obj = this.slug_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.slug_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.FranchiseOrBuilder
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
            this.slug_ = Franchise.getDefaultInstance().getSlug();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder setSlugBytes(ByteString byteString) {
            byteString.getClass();
            Franchise.checkByteStringIsUtf8(byteString);
            this.slug_ = byteString;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        @Override // proto.FranchiseOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // proto.FranchiseOrBuilder
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

        @Override // proto.FranchiseOrBuilder
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

        @Override // proto.FranchiseOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.FranchiseOrBuilder
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
            this.url_ = Franchise.getDefaultInstance().getUrl();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            Franchise.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        @Override // proto.FranchiseOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.FranchiseOrBuilder
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
            this.checksum_ = Franchise.getDefaultInstance().getChecksum();
            this.bitField0_ &= -129;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            Franchise.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }
    }

    public static Franchise getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.Franchise$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Franchise> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public Franchise parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Franchise.newBuilder();
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

    public static Parser<Franchise> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Franchise> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Franchise getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
