package proto;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
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
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class ExternalGame extends GeneratedMessage implements ExternalGameOrBuilder {
    public static final int CATEGORY_FIELD_NUMBER = 2;
    public static final int CHECKSUM_FIELD_NUMBER = 13;
    public static final int COUNTRIES_FIELD_NUMBER = 12;
    public static final int CREATED_AT_FIELD_NUMBER = 3;
    private static final ExternalGame DEFAULT_INSTANCE;
    public static final int GAME_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int MEDIA_FIELD_NUMBER = 10;
    public static final int NAME_FIELD_NUMBER = 5;
    private static final Parser<ExternalGame> PARSER;
    public static final int PLATFORM_FIELD_NUMBER = 11;
    public static final int UID_FIELD_NUMBER = 6;
    public static final int UPDATED_AT_FIELD_NUMBER = 7;
    public static final int URL_FIELD_NUMBER = 8;
    public static final int YEAR_FIELD_NUMBER = 9;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int category_;
    private volatile Object checksum_;
    private int countriesMemoizedSerializedSize;
    private Internal.IntList countries_;
    private Timestamp createdAt_;
    private Game game_;
    private long id_;
    private int media_;
    private volatile Object name_;
    private Platform platform_;
    private volatile Object uid_;
    private Timestamp updatedAt_;
    private volatile Object url_;
    private int year_;

    /* synthetic */ ExternalGame(GeneratedMessage.Builder builder, ExternalGameIA externalGameIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", ExternalGame.class.getName());
        DEFAULT_INSTANCE = new ExternalGame();
        PARSER = new AnonymousClass1();
    }

    private ExternalGame(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.category_ = 0;
        this.name_ = "";
        this.uid_ = "";
        this.url_ = "";
        this.year_ = 0;
        this.media_ = 0;
        this.countries_ = emptyIntList();
        this.countriesMemoizedSerializedSize = -1;
        this.checksum_ = "";
    }

    private ExternalGame() {
        this.id_ = 0L;
        this.category_ = 0;
        this.name_ = "";
        this.uid_ = "";
        this.url_ = "";
        this.year_ = 0;
        this.media_ = 0;
        this.countries_ = emptyIntList();
        this.countriesMemoizedSerializedSize = -1;
        this.checksum_ = "";
        this.category_ = 0;
        this.name_ = "";
        this.uid_ = "";
        this.url_ = "";
        this.media_ = 0;
        this.countries_ = emptyIntList();
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_ExternalGame_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_ExternalGame_fieldAccessorTable.ensureFieldAccessorsInitialized(ExternalGame.class, Builder.class);
    }

    @Override // proto.ExternalGameOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.ExternalGameOrBuilder
    public int getCategoryValue() {
        return this.category_;
    }

    @Override // proto.ExternalGameOrBuilder
    public ExternalGameCategoryEnum getCategory() {
        ExternalGameCategoryEnum externalGameCategoryEnumForNumber = ExternalGameCategoryEnum.forNumber(this.category_);
        return externalGameCategoryEnumForNumber == null ? ExternalGameCategoryEnum.UNRECOGNIZED : externalGameCategoryEnumForNumber;
    }

    @Override // proto.ExternalGameOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.ExternalGameOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.ExternalGameOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.ExternalGameOrBuilder
    public boolean hasGame() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.ExternalGameOrBuilder
    public Game getGame() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.ExternalGameOrBuilder
    public GameOrBuilder getGameOrBuilder() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.ExternalGameOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.ExternalGameOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.ExternalGameOrBuilder
    public String getUid() {
        Object obj = this.uid_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.uid_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.ExternalGameOrBuilder
    public ByteString getUidBytes() {
        Object obj = this.uid_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.uid_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.ExternalGameOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.ExternalGameOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.ExternalGameOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.ExternalGameOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.ExternalGameOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.ExternalGameOrBuilder
    public int getYear() {
        return this.year_;
    }

    @Override // proto.ExternalGameOrBuilder
    public int getMediaValue() {
        return this.media_;
    }

    @Override // proto.ExternalGameOrBuilder
    public ExternalGameMediaEnum getMedia() {
        ExternalGameMediaEnum externalGameMediaEnumForNumber = ExternalGameMediaEnum.forNumber(this.media_);
        return externalGameMediaEnumForNumber == null ? ExternalGameMediaEnum.UNRECOGNIZED : externalGameMediaEnumForNumber;
    }

    @Override // proto.ExternalGameOrBuilder
    public boolean hasPlatform() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // proto.ExternalGameOrBuilder
    public Platform getPlatform() {
        Platform platform = this.platform_;
        return platform == null ? Platform.getDefaultInstance() : platform;
    }

    @Override // proto.ExternalGameOrBuilder
    public PlatformOrBuilder getPlatformOrBuilder() {
        Platform platform = this.platform_;
        return platform == null ? Platform.getDefaultInstance() : platform;
    }

    @Override // proto.ExternalGameOrBuilder
    public List<Integer> getCountriesList() {
        return this.countries_;
    }

    @Override // proto.ExternalGameOrBuilder
    public int getCountriesCount() {
        return this.countries_.size();
    }

    @Override // proto.ExternalGameOrBuilder
    public int getCountries(int i) {
        return this.countries_.getInt(i);
    }

    @Override // proto.ExternalGameOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.ExternalGameOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static ExternalGame parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ExternalGame parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ExternalGame parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ExternalGame parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ExternalGame parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ExternalGame parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ExternalGame parseFrom(InputStream inputStream) throws IOException {
        return (ExternalGame) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static ExternalGame parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExternalGame) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ExternalGame parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ExternalGame) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ExternalGame parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExternalGame) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ExternalGame parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ExternalGame) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static ExternalGame parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExternalGame) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(ExternalGame externalGame) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) externalGame);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((ExternalGameIA) null) : (Builder) new Builder((ExternalGameIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ExternalGameOrBuilder {
        private int bitField0_;
        private int category_;
        private Object checksum_;
        private Internal.IntList countries_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> gameBuilder_;
        private Game game_;
        private long id_;
        private int media_;
        private Object name_;
        private SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> platformBuilder_;
        private Platform platform_;
        private Object uid_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;
        private Object url_;
        private int year_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, ExternalGameIA externalGameIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(ExternalGameIA externalGameIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_ExternalGame_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_ExternalGame_fieldAccessorTable.ensureFieldAccessorsInitialized(ExternalGame.class, Builder.class);
        }

        private Builder() {
            this.category_ = 0;
            this.name_ = "";
            this.uid_ = "";
            this.url_ = "";
            this.media_ = 0;
            this.countries_ = ExternalGame.emptyIntList();
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.category_ = 0;
            this.name_ = "";
            this.uid_ = "";
            this.url_ = "";
            this.media_ = 0;
            this.countries_ = ExternalGame.emptyIntList();
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (ExternalGame.alwaysUseFieldBuilders) {
                getCreatedAtFieldBuilder();
                getGameFieldBuilder();
                getUpdatedAtFieldBuilder();
                getPlatformFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.category_ = 0;
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.createdAtBuilder_ = null;
            }
            this.game_ = null;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder2 = this.gameBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.gameBuilder_ = null;
            }
            this.name_ = "";
            this.uid_ = "";
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.updatedAtBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.url_ = "";
            this.year_ = 0;
            this.media_ = 0;
            this.platform_ = null;
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder4 = this.platformBuilder_;
            if (singleFieldBuilder4 != null) {
                singleFieldBuilder4.dispose();
                this.platformBuilder_ = null;
            }
            this.countries_ = ExternalGame.emptyIntList();
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_ExternalGame_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ExternalGame getDefaultInstanceForType() {
            return ExternalGame.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ExternalGame build() {
            ExternalGame externalGameBuildPartial = buildPartial();
            if (externalGameBuildPartial.isInitialized()) {
                return externalGameBuildPartial;
            }
            throw newUninitializedMessageException((Message) externalGameBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ExternalGame buildPartial() {
            ExternalGame externalGame = new ExternalGame(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(externalGame);
            }
            onBuilt();
            return externalGame;
        }

        private void buildPartial0(ExternalGame externalGame) {
            int i;
            Platform platform;
            Timestamp timestamp;
            Game game;
            Timestamp timestamp2;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                externalGame.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                externalGame.category_ = this.category_;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
                if (singleFieldBuilder == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder.build();
                }
                externalGame.createdAt_ = timestamp2;
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
                externalGame.game_ = game;
                i |= 2;
            }
            if ((i2 & 16) != 0) {
                externalGame.name_ = this.name_;
            }
            if ((i2 & 32) != 0) {
                externalGame.uid_ = this.uid_;
            }
            if ((i2 & 64) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.updatedAtBuilder_;
                if (singleFieldBuilder3 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder3.build();
                }
                externalGame.updatedAt_ = timestamp;
                i |= 4;
            }
            if ((i2 & 128) != 0) {
                externalGame.url_ = this.url_;
            }
            if ((i2 & 256) != 0) {
                externalGame.year_ = this.year_;
            }
            if ((i2 & 512) != 0) {
                externalGame.media_ = this.media_;
            }
            if ((i2 & 1024) != 0) {
                SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder4 = this.platformBuilder_;
                if (singleFieldBuilder4 == null) {
                    platform = this.platform_;
                } else {
                    platform = (Platform) singleFieldBuilder4.build();
                }
                externalGame.platform_ = platform;
                i |= 8;
            }
            if ((i2 & 2048) != 0) {
                this.countries_.makeImmutable();
                externalGame.countries_ = this.countries_;
            }
            if ((i2 & 4096) != 0) {
                externalGame.checksum_ = this.checksum_;
            }
            externalGame.bitField0_ |= i;
        }

        @Override // proto.ExternalGameOrBuilder
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

        @Override // proto.ExternalGameOrBuilder
        public int getCategoryValue() {
            return this.category_;
        }

        public Builder setCategoryValue(int i) {
            this.category_ = i;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.ExternalGameOrBuilder
        public ExternalGameCategoryEnum getCategory() {
            ExternalGameCategoryEnum externalGameCategoryEnumForNumber = ExternalGameCategoryEnum.forNumber(this.category_);
            return externalGameCategoryEnumForNumber == null ? ExternalGameCategoryEnum.UNRECOGNIZED : externalGameCategoryEnumForNumber;
        }

        public Builder setCategory(ExternalGameCategoryEnum externalGameCategoryEnum) {
            externalGameCategoryEnum.getClass();
            this.bitField0_ |= 2;
            this.category_ = externalGameCategoryEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearCategory() {
            this.bitField0_ &= -3;
            this.category_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.ExternalGameOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // proto.ExternalGameOrBuilder
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
            this.bitField0_ |= 4;
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
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder mergeCreatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0 && (timestamp2 = this.createdAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getCreatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.createdAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.createdAt_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder clearCreatedAt() {
            this.bitField0_ &= -5;
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
            this.bitField0_ |= 4;
            onChanged();
            return (Timestamp.Builder) getCreatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.ExternalGameOrBuilder
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

        @Override // proto.ExternalGameOrBuilder
        public boolean hasGame() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // proto.ExternalGameOrBuilder
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

        @Override // proto.ExternalGameOrBuilder
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

        @Override // proto.ExternalGameOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.ExternalGameOrBuilder
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
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = ExternalGame.getDefaultInstance().getName();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            ExternalGame.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        @Override // proto.ExternalGameOrBuilder
        public String getUid() {
            Object obj = this.uid_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.uid_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.ExternalGameOrBuilder
        public ByteString getUidBytes() {
            Object obj = this.uid_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.uid_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setUid(String str) {
            str.getClass();
            this.uid_ = str;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = ExternalGame.getDefaultInstance().getUid();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder setUidBytes(ByteString byteString) {
            byteString.getClass();
            ExternalGame.checkByteStringIsUtf8(byteString);
            this.uid_ = byteString;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        @Override // proto.ExternalGameOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // proto.ExternalGameOrBuilder
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

        @Override // proto.ExternalGameOrBuilder
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

        @Override // proto.ExternalGameOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.ExternalGameOrBuilder
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
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = ExternalGame.getDefaultInstance().getUrl();
            this.bitField0_ &= -129;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            ExternalGame.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        @Override // proto.ExternalGameOrBuilder
        public int getYear() {
            return this.year_;
        }

        public Builder setYear(int i) {
            this.year_ = i;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder clearYear() {
            this.bitField0_ &= -257;
            this.year_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.ExternalGameOrBuilder
        public int getMediaValue() {
            return this.media_;
        }

        public Builder setMediaValue(int i) {
            this.media_ = i;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        @Override // proto.ExternalGameOrBuilder
        public ExternalGameMediaEnum getMedia() {
            ExternalGameMediaEnum externalGameMediaEnumForNumber = ExternalGameMediaEnum.forNumber(this.media_);
            return externalGameMediaEnumForNumber == null ? ExternalGameMediaEnum.UNRECOGNIZED : externalGameMediaEnumForNumber;
        }

        public Builder setMedia(ExternalGameMediaEnum externalGameMediaEnum) {
            externalGameMediaEnum.getClass();
            this.bitField0_ |= 512;
            this.media_ = externalGameMediaEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearMedia() {
            this.bitField0_ &= -513;
            this.media_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.ExternalGameOrBuilder
        public boolean hasPlatform() {
            return (this.bitField0_ & 1024) != 0;
        }

        @Override // proto.ExternalGameOrBuilder
        public Platform getPlatform() {
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder = this.platformBuilder_;
            if (singleFieldBuilder == null) {
                Platform platform = this.platform_;
                return platform == null ? Platform.getDefaultInstance() : platform;
            }
            return (Platform) singleFieldBuilder.getMessage();
        }

        public Builder setPlatform(Platform platform) {
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder = this.platformBuilder_;
            if (singleFieldBuilder == null) {
                platform.getClass();
                this.platform_ = platform;
            } else {
                singleFieldBuilder.setMessage(platform);
            }
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setPlatform(Platform.Builder builder) {
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder = this.platformBuilder_;
            if (singleFieldBuilder == null) {
                this.platform_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder mergePlatform(Platform platform) {
            Platform platform2;
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder = this.platformBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 1024) != 0 && (platform2 = this.platform_) != null && platform2 != Platform.getDefaultInstance()) {
                    getPlatformBuilder().mergeFrom((Message) platform);
                } else {
                    this.platform_ = platform;
                }
            } else {
                singleFieldBuilder.mergeFrom(platform);
            }
            if (this.platform_ != null) {
                this.bitField0_ |= 1024;
                onChanged();
            }
            return this;
        }

        public Builder clearPlatform() {
            this.bitField0_ &= -1025;
            this.platform_ = null;
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder = this.platformBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.platformBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Platform.Builder getPlatformBuilder() {
            this.bitField0_ |= 1024;
            onChanged();
            return (Platform.Builder) getPlatformFieldBuilder().getBuilder();
        }

        @Override // proto.ExternalGameOrBuilder
        public PlatformOrBuilder getPlatformOrBuilder() {
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder = this.platformBuilder_;
            if (singleFieldBuilder != null) {
                return (PlatformOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Platform platform = this.platform_;
            return platform == null ? Platform.getDefaultInstance() : platform;
        }

        private SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> getPlatformFieldBuilder() {
            if (this.platformBuilder_ == null) {
                this.platformBuilder_ = new SingleFieldBuilder<>(getPlatform(), getParentForChildren(), isClean());
                this.platform_ = null;
            }
            return this.platformBuilder_;
        }

        private void ensureCountriesIsMutable() {
            if (!this.countries_.isModifiable()) {
                this.countries_ = (Internal.IntList) ExternalGame.makeMutableCopy(this.countries_);
            }
            this.bitField0_ |= 2048;
        }

        @Override // proto.ExternalGameOrBuilder
        public List<Integer> getCountriesList() {
            this.countries_.makeImmutable();
            return this.countries_;
        }

        @Override // proto.ExternalGameOrBuilder
        public int getCountriesCount() {
            return this.countries_.size();
        }

        @Override // proto.ExternalGameOrBuilder
        public int getCountries(int i) {
            return this.countries_.getInt(i);
        }

        public Builder setCountries(int i, int i2) {
            ensureCountriesIsMutable();
            this.countries_.setInt(i, i2);
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder addCountries(int i) {
            ensureCountriesIsMutable();
            this.countries_.addInt(i);
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder addAllCountries(Iterable<? extends Integer> iterable) {
            ensureCountriesIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.countries_);
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder clearCountries() {
            this.countries_ = ExternalGame.emptyIntList();
            this.bitField0_ &= -2049;
            onChanged();
            return this;
        }

        @Override // proto.ExternalGameOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.ExternalGameOrBuilder
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
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = ExternalGame.getDefaultInstance().getChecksum();
            this.bitField0_ &= -4097;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            ExternalGame.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }
    }

    public static ExternalGame getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.ExternalGame$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<ExternalGame> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public ExternalGame parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = ExternalGame.newBuilder();
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

    public static Parser<ExternalGame> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ExternalGame> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ExternalGame getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
