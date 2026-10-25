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
public final class GameLocalization extends GeneratedMessage implements GameLocalizationOrBuilder {
    public static final int CHECKSUM_FIELD_NUMBER = 8;
    public static final int COVER_FIELD_NUMBER = 3;
    public static final int CREATED_AT_FIELD_NUMBER = 6;
    private static final GameLocalization DEFAULT_INSTANCE;
    public static final int GAME_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static final Parser<GameLocalization> PARSER;
    public static final int REGION_FIELD_NUMBER = 5;
    public static final int UPDATED_AT_FIELD_NUMBER = 7;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object checksum_;
    private Cover cover_;
    private Timestamp createdAt_;
    private Game game_;
    private long id_;
    private volatile Object name_;
    private Region region_;
    private Timestamp updatedAt_;

    /* synthetic */ GameLocalization(GeneratedMessage.Builder builder, GameLocalizationIA gameLocalizationIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameLocalization.class.getName());
        DEFAULT_INSTANCE = new GameLocalization();
        PARSER = new AnonymousClass1();
    }

    private GameLocalization(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.name_ = "";
        this.checksum_ = "";
    }

    private GameLocalization() {
        this.id_ = 0L;
        this.name_ = "";
        this.checksum_ = "";
        this.name_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_GameLocalization_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_GameLocalization_fieldAccessorTable.ensureFieldAccessorsInitialized(GameLocalization.class, Builder.class);
    }

    @Override // proto.GameLocalizationOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.GameLocalizationOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameLocalizationOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.GameLocalizationOrBuilder
    public boolean hasCover() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.GameLocalizationOrBuilder
    public Cover getCover() {
        Cover cover = this.cover_;
        return cover == null ? Cover.getDefaultInstance() : cover;
    }

    @Override // proto.GameLocalizationOrBuilder
    public CoverOrBuilder getCoverOrBuilder() {
        Cover cover = this.cover_;
        return cover == null ? Cover.getDefaultInstance() : cover;
    }

    @Override // proto.GameLocalizationOrBuilder
    public boolean hasGame() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.GameLocalizationOrBuilder
    public Game getGame() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.GameLocalizationOrBuilder
    public GameOrBuilder getGameOrBuilder() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.GameLocalizationOrBuilder
    public boolean hasRegion() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.GameLocalizationOrBuilder
    public Region getRegion() {
        Region region = this.region_;
        return region == null ? Region.getDefaultInstance() : region;
    }

    @Override // proto.GameLocalizationOrBuilder
    public RegionOrBuilder getRegionOrBuilder() {
        Region region = this.region_;
        return region == null ? Region.getDefaultInstance() : region;
    }

    @Override // proto.GameLocalizationOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // proto.GameLocalizationOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameLocalizationOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameLocalizationOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // proto.GameLocalizationOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameLocalizationOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameLocalizationOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameLocalizationOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static GameLocalization parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GameLocalization parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GameLocalization parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GameLocalization parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GameLocalization parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GameLocalization parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GameLocalization parseFrom(InputStream inputStream) throws IOException {
        return (GameLocalization) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static GameLocalization parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameLocalization) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameLocalization parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GameLocalization) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GameLocalization parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameLocalization) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameLocalization parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GameLocalization) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GameLocalization parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameLocalization) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GameLocalization gameLocalization) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) gameLocalization);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((GameLocalizationIA) null) : (Builder) new Builder((GameLocalizationIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameLocalizationOrBuilder {
        private int bitField0_;
        private Object checksum_;
        private SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> coverBuilder_;
        private Cover cover_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> gameBuilder_;
        private Game game_;
        private long id_;
        private Object name_;
        private SingleFieldBuilder<Region, Region.Builder, RegionOrBuilder> regionBuilder_;
        private Region region_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, GameLocalizationIA gameLocalizationIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(GameLocalizationIA gameLocalizationIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_GameLocalization_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_GameLocalization_fieldAccessorTable.ensureFieldAccessorsInitialized(GameLocalization.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (GameLocalization.alwaysUseFieldBuilders) {
                getCoverFieldBuilder();
                getGameFieldBuilder();
                getRegionFieldBuilder();
                getCreatedAtFieldBuilder();
                getUpdatedAtFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.name_ = "";
            this.cover_ = null;
            SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> singleFieldBuilder = this.coverBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.coverBuilder_ = null;
            }
            this.game_ = null;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder2 = this.gameBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.gameBuilder_ = null;
            }
            this.region_ = null;
            SingleFieldBuilder<Region, Region.Builder, RegionOrBuilder> singleFieldBuilder3 = this.regionBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.regionBuilder_ = null;
            }
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.createdAtBuilder_;
            if (singleFieldBuilder4 != null) {
                singleFieldBuilder4.dispose();
                this.createdAtBuilder_ = null;
            }
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder5 = this.updatedAtBuilder_;
            if (singleFieldBuilder5 != null) {
                singleFieldBuilder5.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_GameLocalization_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameLocalization getDefaultInstanceForType() {
            return GameLocalization.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameLocalization build() {
            GameLocalization gameLocalizationBuildPartial = buildPartial();
            if (gameLocalizationBuildPartial.isInitialized()) {
                return gameLocalizationBuildPartial;
            }
            throw newUninitializedMessageException((Message) gameLocalizationBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameLocalization buildPartial() {
            GameLocalization gameLocalization = new GameLocalization(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(gameLocalization);
            }
            onBuilt();
            return gameLocalization;
        }

        private void buildPartial0(GameLocalization gameLocalization) {
            int i;
            Timestamp timestamp;
            Timestamp timestamp2;
            Region region;
            Game game;
            Cover cover;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                gameLocalization.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                gameLocalization.name_ = this.name_;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> singleFieldBuilder = this.coverBuilder_;
                if (singleFieldBuilder == null) {
                    cover = this.cover_;
                } else {
                    cover = (Cover) singleFieldBuilder.build();
                }
                gameLocalization.cover_ = cover;
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
                gameLocalization.game_ = game;
                i |= 2;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<Region, Region.Builder, RegionOrBuilder> singleFieldBuilder3 = this.regionBuilder_;
                if (singleFieldBuilder3 == null) {
                    region = this.region_;
                } else {
                    region = (Region) singleFieldBuilder3.build();
                }
                gameLocalization.region_ = region;
                i |= 4;
            }
            if ((i2 & 32) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.createdAtBuilder_;
                if (singleFieldBuilder4 == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder4.build();
                }
                gameLocalization.createdAt_ = timestamp2;
                i |= 8;
            }
            if ((i2 & 64) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder5 = this.updatedAtBuilder_;
                if (singleFieldBuilder5 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder5.build();
                }
                gameLocalization.updatedAt_ = timestamp;
                i |= 16;
            }
            if ((i2 & 128) != 0) {
                gameLocalization.checksum_ = this.checksum_;
            }
            gameLocalization.bitField0_ |= i;
        }

        @Override // proto.GameLocalizationOrBuilder
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

        @Override // proto.GameLocalizationOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameLocalizationOrBuilder
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
            this.name_ = GameLocalization.getDefaultInstance().getName();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            GameLocalization.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.GameLocalizationOrBuilder
        public boolean hasCover() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // proto.GameLocalizationOrBuilder
        public Cover getCover() {
            SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> singleFieldBuilder = this.coverBuilder_;
            if (singleFieldBuilder == null) {
                Cover cover = this.cover_;
                return cover == null ? Cover.getDefaultInstance() : cover;
            }
            return (Cover) singleFieldBuilder.getMessage();
        }

        public Builder setCover(Cover cover) {
            SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> singleFieldBuilder = this.coverBuilder_;
            if (singleFieldBuilder == null) {
                cover.getClass();
                this.cover_ = cover;
            } else {
                singleFieldBuilder.setMessage(cover);
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setCover(Cover.Builder builder) {
            SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> singleFieldBuilder = this.coverBuilder_;
            if (singleFieldBuilder == null) {
                this.cover_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder mergeCover(Cover cover) {
            Cover cover2;
            SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> singleFieldBuilder = this.coverBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0 && (cover2 = this.cover_) != null && cover2 != Cover.getDefaultInstance()) {
                    getCoverBuilder().mergeFrom((Message) cover);
                } else {
                    this.cover_ = cover;
                }
            } else {
                singleFieldBuilder.mergeFrom(cover);
            }
            if (this.cover_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder clearCover() {
            this.bitField0_ &= -5;
            this.cover_ = null;
            SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> singleFieldBuilder = this.coverBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.coverBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Cover.Builder getCoverBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (Cover.Builder) getCoverFieldBuilder().getBuilder();
        }

        @Override // proto.GameLocalizationOrBuilder
        public CoverOrBuilder getCoverOrBuilder() {
            SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> singleFieldBuilder = this.coverBuilder_;
            if (singleFieldBuilder != null) {
                return (CoverOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Cover cover = this.cover_;
            return cover == null ? Cover.getDefaultInstance() : cover;
        }

        private SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> getCoverFieldBuilder() {
            if (this.coverBuilder_ == null) {
                this.coverBuilder_ = new SingleFieldBuilder<>(getCover(), getParentForChildren(), isClean());
                this.cover_ = null;
            }
            return this.coverBuilder_;
        }

        @Override // proto.GameLocalizationOrBuilder
        public boolean hasGame() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // proto.GameLocalizationOrBuilder
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

        @Override // proto.GameLocalizationOrBuilder
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

        @Override // proto.GameLocalizationOrBuilder
        public boolean hasRegion() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // proto.GameLocalizationOrBuilder
        public Region getRegion() {
            SingleFieldBuilder<Region, Region.Builder, RegionOrBuilder> singleFieldBuilder = this.regionBuilder_;
            if (singleFieldBuilder == null) {
                Region region = this.region_;
                return region == null ? Region.getDefaultInstance() : region;
            }
            return (Region) singleFieldBuilder.getMessage();
        }

        public Builder setRegion(Region region) {
            SingleFieldBuilder<Region, Region.Builder, RegionOrBuilder> singleFieldBuilder = this.regionBuilder_;
            if (singleFieldBuilder == null) {
                region.getClass();
                this.region_ = region;
            } else {
                singleFieldBuilder.setMessage(region);
            }
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setRegion(Region.Builder builder) {
            SingleFieldBuilder<Region, Region.Builder, RegionOrBuilder> singleFieldBuilder = this.regionBuilder_;
            if (singleFieldBuilder == null) {
                this.region_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder mergeRegion(Region region) {
            Region region2;
            SingleFieldBuilder<Region, Region.Builder, RegionOrBuilder> singleFieldBuilder = this.regionBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 16) != 0 && (region2 = this.region_) != null && region2 != Region.getDefaultInstance()) {
                    getRegionBuilder().mergeFrom((Message) region);
                } else {
                    this.region_ = region;
                }
            } else {
                singleFieldBuilder.mergeFrom(region);
            }
            if (this.region_ != null) {
                this.bitField0_ |= 16;
                onChanged();
            }
            return this;
        }

        public Builder clearRegion() {
            this.bitField0_ &= -17;
            this.region_ = null;
            SingleFieldBuilder<Region, Region.Builder, RegionOrBuilder> singleFieldBuilder = this.regionBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.regionBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Region.Builder getRegionBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (Region.Builder) getRegionFieldBuilder().getBuilder();
        }

        @Override // proto.GameLocalizationOrBuilder
        public RegionOrBuilder getRegionOrBuilder() {
            SingleFieldBuilder<Region, Region.Builder, RegionOrBuilder> singleFieldBuilder = this.regionBuilder_;
            if (singleFieldBuilder != null) {
                return (RegionOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Region region = this.region_;
            return region == null ? Region.getDefaultInstance() : region;
        }

        private SingleFieldBuilder<Region, Region.Builder, RegionOrBuilder> getRegionFieldBuilder() {
            if (this.regionBuilder_ == null) {
                this.regionBuilder_ = new SingleFieldBuilder<>(getRegion(), getParentForChildren(), isClean());
                this.region_ = null;
            }
            return this.regionBuilder_;
        }

        @Override // proto.GameLocalizationOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // proto.GameLocalizationOrBuilder
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

        @Override // proto.GameLocalizationOrBuilder
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

        @Override // proto.GameLocalizationOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // proto.GameLocalizationOrBuilder
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
            this.bitField0_ |= 64;
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
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder mergeUpdatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 64) != 0 && (timestamp2 = this.updatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getUpdatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.updatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.updatedAt_ != null) {
                this.bitField0_ |= 64;
                onChanged();
            }
            return this;
        }

        public Builder clearUpdatedAt() {
            this.bitField0_ &= -65;
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
            this.bitField0_ |= 64;
            onChanged();
            return (Timestamp.Builder) getUpdatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.GameLocalizationOrBuilder
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

        @Override // proto.GameLocalizationOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameLocalizationOrBuilder
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
            this.checksum_ = GameLocalization.getDefaultInstance().getChecksum();
            this.bitField0_ &= -129;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            GameLocalization.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }
    }

    public static GameLocalization getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.GameLocalization$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<GameLocalization> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public GameLocalization parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = GameLocalization.newBuilder();
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

    public static Parser<GameLocalization> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GameLocalization> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GameLocalization getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
