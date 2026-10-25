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
public final class GameVersion extends GeneratedMessage implements GameVersionOrBuilder {
    public static final int CHECKSUM_FIELD_NUMBER = 8;
    public static final int CREATED_AT_FIELD_NUMBER = 2;
    private static final GameVersion DEFAULT_INSTANCE;
    public static final int FEATURES_FIELD_NUMBER = 3;
    public static final int GAMES_FIELD_NUMBER = 5;
    public static final int GAME_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    private static final Parser<GameVersion> PARSER;
    public static final int UPDATED_AT_FIELD_NUMBER = 6;
    public static final int URL_FIELD_NUMBER = 7;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object checksum_;
    private Timestamp createdAt_;
    private List<GameVersionFeature> features_;
    private Game game_;
    private List<Game> games_;
    private long id_;
    private Timestamp updatedAt_;
    private volatile Object url_;

    /* synthetic */ GameVersion(GeneratedMessage.Builder builder, GameVersionIA gameVersionIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameVersion.class.getName());
        DEFAULT_INSTANCE = new GameVersion();
        PARSER = new AnonymousClass1();
    }

    private GameVersion(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.url_ = "";
        this.checksum_ = "";
    }

    private GameVersion() {
        this.id_ = 0L;
        this.url_ = "";
        this.checksum_ = "";
        this.features_ = Collections.emptyList();
        this.games_ = Collections.emptyList();
        this.url_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_GameVersion_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_GameVersion_fieldAccessorTable.ensureFieldAccessorsInitialized(GameVersion.class, Builder.class);
    }

    @Override // proto.GameVersionOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.GameVersionOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.GameVersionOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameVersionOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameVersionOrBuilder
    public List<GameVersionFeature> getFeaturesList() {
        return this.features_;
    }

    @Override // proto.GameVersionOrBuilder
    public List<? extends GameVersionFeatureOrBuilder> getFeaturesOrBuilderList() {
        return this.features_;
    }

    @Override // proto.GameVersionOrBuilder
    public int getFeaturesCount() {
        return this.features_.size();
    }

    @Override // proto.GameVersionOrBuilder
    public GameVersionFeature getFeatures(int i) {
        return this.features_.get(i);
    }

    @Override // proto.GameVersionOrBuilder
    public GameVersionFeatureOrBuilder getFeaturesOrBuilder(int i) {
        return this.features_.get(i);
    }

    @Override // proto.GameVersionOrBuilder
    public boolean hasGame() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.GameVersionOrBuilder
    public Game getGame() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.GameVersionOrBuilder
    public GameOrBuilder getGameOrBuilder() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.GameVersionOrBuilder
    public List<Game> getGamesList() {
        return this.games_;
    }

    @Override // proto.GameVersionOrBuilder
    public List<? extends GameOrBuilder> getGamesOrBuilderList() {
        return this.games_;
    }

    @Override // proto.GameVersionOrBuilder
    public int getGamesCount() {
        return this.games_.size();
    }

    @Override // proto.GameVersionOrBuilder
    public Game getGames(int i) {
        return this.games_.get(i);
    }

    @Override // proto.GameVersionOrBuilder
    public GameOrBuilder getGamesOrBuilder(int i) {
        return this.games_.get(i);
    }

    @Override // proto.GameVersionOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.GameVersionOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameVersionOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameVersionOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameVersionOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.GameVersionOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameVersionOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static GameVersion parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GameVersion parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GameVersion parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GameVersion parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GameVersion parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GameVersion parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GameVersion parseFrom(InputStream inputStream) throws IOException {
        return (GameVersion) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static GameVersion parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersion) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameVersion parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GameVersion) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GameVersion parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersion) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameVersion parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GameVersion) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GameVersion parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersion) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GameVersion gameVersion) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) gameVersion);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((GameVersionIA) null) : (Builder) new Builder((GameVersionIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameVersionOrBuilder {
        private int bitField0_;
        private Object checksum_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> featuresBuilder_;
        private List<GameVersionFeature> features_;
        private SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> gameBuilder_;
        private Game game_;
        private RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> gamesBuilder_;
        private List<Game> games_;
        private long id_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;
        private Object url_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, GameVersionIA gameVersionIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(GameVersionIA gameVersionIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_GameVersion_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_GameVersion_fieldAccessorTable.ensureFieldAccessorsInitialized(GameVersion.class, Builder.class);
        }

        private Builder() {
            this.features_ = Collections.emptyList();
            this.games_ = Collections.emptyList();
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.features_ = Collections.emptyList();
            this.games_ = Collections.emptyList();
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (GameVersion.alwaysUseFieldBuilders) {
                getCreatedAtFieldBuilder();
                getFeaturesFieldBuilder();
                getGameFieldBuilder();
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
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.featuresBuilder_;
            if (repeatedFieldBuilder == null) {
                this.features_ = Collections.emptyList();
            } else {
                this.features_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -5;
            this.game_ = null;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder2 = this.gameBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.gameBuilder_ = null;
            }
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder2 = this.gamesBuilder_;
            if (repeatedFieldBuilder2 == null) {
                this.games_ = Collections.emptyList();
            } else {
                this.games_ = null;
                repeatedFieldBuilder2.clear();
            }
            this.bitField0_ &= -17;
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.updatedAtBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.url_ = "";
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_GameVersion_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameVersion getDefaultInstanceForType() {
            return GameVersion.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameVersion build() {
            GameVersion gameVersionBuildPartial = buildPartial();
            if (gameVersionBuildPartial.isInitialized()) {
                return gameVersionBuildPartial;
            }
            throw newUninitializedMessageException((Message) gameVersionBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameVersion buildPartial() {
            GameVersion gameVersion = new GameVersion(this, null);
            buildPartialRepeatedFields(gameVersion);
            if (this.bitField0_ != 0) {
                buildPartial0(gameVersion);
            }
            onBuilt();
            return gameVersion;
        }

        private void buildPartialRepeatedFields(GameVersion gameVersion) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.featuresBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0) {
                    this.features_ = Collections.unmodifiableList(this.features_);
                    this.bitField0_ &= -5;
                }
                gameVersion.features_ = this.features_;
            } else {
                gameVersion.features_ = repeatedFieldBuilder.build();
            }
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder2 = this.gamesBuilder_;
            if (repeatedFieldBuilder2 == null) {
                if ((this.bitField0_ & 16) != 0) {
                    this.games_ = Collections.unmodifiableList(this.games_);
                    this.bitField0_ &= -17;
                }
                gameVersion.games_ = this.games_;
                return;
            }
            gameVersion.games_ = repeatedFieldBuilder2.build();
        }

        private void buildPartial0(GameVersion gameVersion) {
            int i;
            Timestamp timestamp;
            Game game;
            Timestamp timestamp2;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                gameVersion.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
                if (singleFieldBuilder == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder.build();
                }
                gameVersion.createdAt_ = timestamp2;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder2 = this.gameBuilder_;
                if (singleFieldBuilder2 == null) {
                    game = this.game_;
                } else {
                    game = (Game) singleFieldBuilder2.build();
                }
                gameVersion.game_ = game;
                i |= 2;
            }
            if ((i2 & 32) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.updatedAtBuilder_;
                if (singleFieldBuilder3 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder3.build();
                }
                gameVersion.updatedAt_ = timestamp;
                i |= 4;
            }
            if ((i2 & 64) != 0) {
                gameVersion.url_ = this.url_;
            }
            if ((i2 & 128) != 0) {
                gameVersion.checksum_ = this.checksum_;
            }
            gameVersion.bitField0_ |= i;
        }

        @Override // proto.GameVersionOrBuilder
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

        @Override // proto.GameVersionOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // proto.GameVersionOrBuilder
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

        @Override // proto.GameVersionOrBuilder
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

        private void ensureFeaturesIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.features_ = new ArrayList(this.features_);
                this.bitField0_ |= 4;
            }
        }

        @Override // proto.GameVersionOrBuilder
        public List<GameVersionFeature> getFeaturesList() {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.featuresBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.features_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameVersionOrBuilder
        public int getFeaturesCount() {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.featuresBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.features_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameVersionOrBuilder
        public GameVersionFeature getFeatures(int i) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.featuresBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.features_.get(i);
            }
            return (GameVersionFeature) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setFeatures(int i, GameVersionFeature gameVersionFeature) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.featuresBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVersionFeature.getClass();
                ensureFeaturesIsMutable();
                this.features_.set(i, gameVersionFeature);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, gameVersionFeature);
            return this;
        }

        public Builder setFeatures(int i, GameVersionFeature.Builder builder) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.featuresBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFeaturesIsMutable();
                this.features_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addFeatures(GameVersionFeature gameVersionFeature) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.featuresBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVersionFeature.getClass();
                ensureFeaturesIsMutable();
                this.features_.add(gameVersionFeature);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(gameVersionFeature);
            return this;
        }

        public Builder addFeatures(int i, GameVersionFeature gameVersionFeature) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.featuresBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVersionFeature.getClass();
                ensureFeaturesIsMutable();
                this.features_.add(i, gameVersionFeature);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, gameVersionFeature);
            return this;
        }

        public Builder addFeatures(GameVersionFeature.Builder builder) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.featuresBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFeaturesIsMutable();
                this.features_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addFeatures(int i, GameVersionFeature.Builder builder) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.featuresBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFeaturesIsMutable();
                this.features_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllFeatures(Iterable<? extends GameVersionFeature> iterable) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.featuresBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFeaturesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.features_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearFeatures() {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.featuresBuilder_;
            if (repeatedFieldBuilder == null) {
                this.features_ = Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeFeatures(int i) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.featuresBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFeaturesIsMutable();
                this.features_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public GameVersionFeature.Builder getFeaturesBuilder(int i) {
            return (GameVersionFeature.Builder) getFeaturesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameVersionOrBuilder
        public GameVersionFeatureOrBuilder getFeaturesOrBuilder(int i) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.featuresBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.features_.get(i);
            }
            return (GameVersionFeatureOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameVersionOrBuilder
        public List<? extends GameVersionFeatureOrBuilder> getFeaturesOrBuilderList() {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.featuresBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.features_);
        }

        public GameVersionFeature.Builder addFeaturesBuilder() {
            return (GameVersionFeature.Builder) getFeaturesFieldBuilder().addBuilder(GameVersionFeature.getDefaultInstance());
        }

        public GameVersionFeature.Builder addFeaturesBuilder(int i) {
            return (GameVersionFeature.Builder) getFeaturesFieldBuilder().addBuilder(i, GameVersionFeature.getDefaultInstance());
        }

        public List<GameVersionFeature.Builder> getFeaturesBuilderList() {
            return getFeaturesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> getFeaturesFieldBuilder() {
            if (this.featuresBuilder_ == null) {
                this.featuresBuilder_ = new RepeatedFieldBuilder<>(this.features_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                this.features_ = null;
            }
            return this.featuresBuilder_;
        }

        @Override // proto.GameVersionOrBuilder
        public boolean hasGame() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // proto.GameVersionOrBuilder
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
            this.bitField0_ |= 8;
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
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder mergeGame(Game game) {
            Game game2;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 8) != 0 && (game2 = this.game_) != null && game2 != Game.getDefaultInstance()) {
                    getGameBuilder().mergeFrom((Message) game);
                } else {
                    this.game_ = game;
                }
            } else {
                singleFieldBuilder.mergeFrom(game);
            }
            if (this.game_ != null) {
                this.bitField0_ |= 8;
                onChanged();
            }
            return this;
        }

        public Builder clearGame() {
            this.bitField0_ &= -9;
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
            this.bitField0_ |= 8;
            onChanged();
            return (Game.Builder) getGameFieldBuilder().getBuilder();
        }

        @Override // proto.GameVersionOrBuilder
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

        private void ensureGamesIsMutable() {
            if ((this.bitField0_ & 16) == 0) {
                this.games_ = new ArrayList(this.games_);
                this.bitField0_ |= 16;
            }
        }

        @Override // proto.GameVersionOrBuilder
        public List<Game> getGamesList() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.games_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameVersionOrBuilder
        public int getGamesCount() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.games_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameVersionOrBuilder
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
                this.bitField0_ &= -17;
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

        @Override // proto.GameVersionOrBuilder
        public GameOrBuilder getGamesOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.games_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameVersionOrBuilder
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
                this.gamesBuilder_ = new RepeatedFieldBuilder<>(this.games_, (this.bitField0_ & 16) != 0, getParentForChildren(), isClean());
                this.games_ = null;
            }
            return this.gamesBuilder_;
        }

        @Override // proto.GameVersionOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // proto.GameVersionOrBuilder
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

        @Override // proto.GameVersionOrBuilder
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

        @Override // proto.GameVersionOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameVersionOrBuilder
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
            this.url_ = GameVersion.getDefaultInstance().getUrl();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            GameVersion.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        @Override // proto.GameVersionOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameVersionOrBuilder
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
            this.checksum_ = GameVersion.getDefaultInstance().getChecksum();
            this.bitField0_ &= -129;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            GameVersion.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }
    }

    public static GameVersion getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.GameVersion$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<GameVersion> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public GameVersion parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = GameVersion.newBuilder();
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

    public static Parser<GameVersion> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GameVersion> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GameVersion getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
