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
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public final class GameVersionFeatureValue extends GeneratedMessage implements GameVersionFeatureValueOrBuilder {
    public static final int CHECKSUM_FIELD_NUMBER = 6;
    private static final GameVersionFeatureValue DEFAULT_INSTANCE;
    public static final int GAME_FEATURE_FIELD_NUMBER = 3;
    public static final int GAME_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int INCLUDED_FEATURE_FIELD_NUMBER = 4;
    public static final int NOTE_FIELD_NUMBER = 5;
    private static final Parser<GameVersionFeatureValue> PARSER;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object checksum_;
    private GameVersionFeature gameFeature_;
    private Game game_;
    private long id_;
    private int includedFeature_;
    private volatile Object note_;

    /* synthetic */ GameVersionFeatureValue(GeneratedMessage.Builder builder, GameVersionFeatureValueIA gameVersionFeatureValueIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameVersionFeatureValue.class.getName());
        DEFAULT_INSTANCE = new GameVersionFeatureValue();
        PARSER = new AnonymousClass1();
    }

    private GameVersionFeatureValue(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.includedFeature_ = 0;
        this.note_ = "";
        this.checksum_ = "";
    }

    private GameVersionFeatureValue() {
        this.id_ = 0L;
        this.includedFeature_ = 0;
        this.note_ = "";
        this.checksum_ = "";
        this.includedFeature_ = 0;
        this.note_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_GameVersionFeatureValue_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_GameVersionFeatureValue_fieldAccessorTable.ensureFieldAccessorsInitialized(GameVersionFeatureValue.class, Builder.class);
    }

    @Override // proto.GameVersionFeatureValueOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.GameVersionFeatureValueOrBuilder
    public boolean hasGame() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.GameVersionFeatureValueOrBuilder
    public Game getGame() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.GameVersionFeatureValueOrBuilder
    public GameOrBuilder getGameOrBuilder() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.GameVersionFeatureValueOrBuilder
    public boolean hasGameFeature() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.GameVersionFeatureValueOrBuilder
    public GameVersionFeature getGameFeature() {
        GameVersionFeature gameVersionFeature = this.gameFeature_;
        return gameVersionFeature == null ? GameVersionFeature.getDefaultInstance() : gameVersionFeature;
    }

    @Override // proto.GameVersionFeatureValueOrBuilder
    public GameVersionFeatureOrBuilder getGameFeatureOrBuilder() {
        GameVersionFeature gameVersionFeature = this.gameFeature_;
        return gameVersionFeature == null ? GameVersionFeature.getDefaultInstance() : gameVersionFeature;
    }

    @Override // proto.GameVersionFeatureValueOrBuilder
    public int getIncludedFeatureValue() {
        return this.includedFeature_;
    }

    @Override // proto.GameVersionFeatureValueOrBuilder
    public GameVersionFeatureValueIncludedFeatureEnum getIncludedFeature() {
        GameVersionFeatureValueIncludedFeatureEnum gameVersionFeatureValueIncludedFeatureEnumForNumber = GameVersionFeatureValueIncludedFeatureEnum.forNumber(this.includedFeature_);
        return gameVersionFeatureValueIncludedFeatureEnumForNumber == null ? GameVersionFeatureValueIncludedFeatureEnum.UNRECOGNIZED : gameVersionFeatureValueIncludedFeatureEnumForNumber;
    }

    @Override // proto.GameVersionFeatureValueOrBuilder
    public String getNote() {
        Object obj = this.note_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.note_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameVersionFeatureValueOrBuilder
    public ByteString getNoteBytes() {
        Object obj = this.note_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.note_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.GameVersionFeatureValueOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameVersionFeatureValueOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static GameVersionFeatureValue parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GameVersionFeatureValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GameVersionFeatureValue parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GameVersionFeatureValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GameVersionFeatureValue parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GameVersionFeatureValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GameVersionFeatureValue parseFrom(InputStream inputStream) throws IOException {
        return (GameVersionFeatureValue) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static GameVersionFeatureValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersionFeatureValue) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameVersionFeatureValue parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GameVersionFeatureValue) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GameVersionFeatureValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersionFeatureValue) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameVersionFeatureValue parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GameVersionFeatureValue) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GameVersionFeatureValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersionFeatureValue) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GameVersionFeatureValue gameVersionFeatureValue) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) gameVersionFeatureValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((GameVersionFeatureValueIA) null) : (Builder) new Builder((GameVersionFeatureValueIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameVersionFeatureValueOrBuilder {
        private int bitField0_;
        private Object checksum_;
        private SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> gameBuilder_;
        private SingleFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> gameFeatureBuilder_;
        private GameVersionFeature gameFeature_;
        private Game game_;
        private long id_;
        private int includedFeature_;
        private Object note_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, GameVersionFeatureValueIA gameVersionFeatureValueIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(GameVersionFeatureValueIA gameVersionFeatureValueIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_GameVersionFeatureValue_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_GameVersionFeatureValue_fieldAccessorTable.ensureFieldAccessorsInitialized(GameVersionFeatureValue.class, Builder.class);
        }

        private Builder() {
            this.includedFeature_ = 0;
            this.note_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.includedFeature_ = 0;
            this.note_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (GameVersionFeatureValue.alwaysUseFieldBuilders) {
                getGameFieldBuilder();
                getGameFeatureFieldBuilder();
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
            this.gameFeature_ = null;
            SingleFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> singleFieldBuilder2 = this.gameFeatureBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.gameFeatureBuilder_ = null;
            }
            this.includedFeature_ = 0;
            this.note_ = "";
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_GameVersionFeatureValue_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameVersionFeatureValue getDefaultInstanceForType() {
            return GameVersionFeatureValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameVersionFeatureValue build() {
            GameVersionFeatureValue gameVersionFeatureValueBuildPartial = buildPartial();
            if (gameVersionFeatureValueBuildPartial.isInitialized()) {
                return gameVersionFeatureValueBuildPartial;
            }
            throw newUninitializedMessageException((Message) gameVersionFeatureValueBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameVersionFeatureValue buildPartial() {
            GameVersionFeatureValue gameVersionFeatureValue = new GameVersionFeatureValue(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(gameVersionFeatureValue);
            }
            onBuilt();
            return gameVersionFeatureValue;
        }

        private void buildPartial0(GameVersionFeatureValue gameVersionFeatureValue) {
            int i;
            GameVersionFeature gameVersionFeature;
            Game game;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                gameVersionFeatureValue.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
                if (singleFieldBuilder == null) {
                    game = this.game_;
                } else {
                    game = (Game) singleFieldBuilder.build();
                }
                gameVersionFeatureValue.game_ = game;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> singleFieldBuilder2 = this.gameFeatureBuilder_;
                if (singleFieldBuilder2 == null) {
                    gameVersionFeature = this.gameFeature_;
                } else {
                    gameVersionFeature = (GameVersionFeature) singleFieldBuilder2.build();
                }
                gameVersionFeatureValue.gameFeature_ = gameVersionFeature;
                i |= 2;
            }
            if ((i2 & 8) != 0) {
                gameVersionFeatureValue.includedFeature_ = this.includedFeature_;
            }
            if ((i2 & 16) != 0) {
                gameVersionFeatureValue.note_ = this.note_;
            }
            if ((i2 & 32) != 0) {
                gameVersionFeatureValue.checksum_ = this.checksum_;
            }
            gameVersionFeatureValue.bitField0_ |= i;
        }

        @Override // proto.GameVersionFeatureValueOrBuilder
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

        @Override // proto.GameVersionFeatureValueOrBuilder
        public boolean hasGame() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // proto.GameVersionFeatureValueOrBuilder
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

        @Override // proto.GameVersionFeatureValueOrBuilder
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

        @Override // proto.GameVersionFeatureValueOrBuilder
        public boolean hasGameFeature() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // proto.GameVersionFeatureValueOrBuilder
        public GameVersionFeature getGameFeature() {
            SingleFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> singleFieldBuilder = this.gameFeatureBuilder_;
            if (singleFieldBuilder == null) {
                GameVersionFeature gameVersionFeature = this.gameFeature_;
                return gameVersionFeature == null ? GameVersionFeature.getDefaultInstance() : gameVersionFeature;
            }
            return (GameVersionFeature) singleFieldBuilder.getMessage();
        }

        public Builder setGameFeature(GameVersionFeature gameVersionFeature) {
            SingleFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> singleFieldBuilder = this.gameFeatureBuilder_;
            if (singleFieldBuilder == null) {
                gameVersionFeature.getClass();
                this.gameFeature_ = gameVersionFeature;
            } else {
                singleFieldBuilder.setMessage(gameVersionFeature);
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setGameFeature(GameVersionFeature.Builder builder) {
            SingleFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> singleFieldBuilder = this.gameFeatureBuilder_;
            if (singleFieldBuilder == null) {
                this.gameFeature_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder mergeGameFeature(GameVersionFeature gameVersionFeature) {
            GameVersionFeature gameVersionFeature2;
            SingleFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> singleFieldBuilder = this.gameFeatureBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0 && (gameVersionFeature2 = this.gameFeature_) != null && gameVersionFeature2 != GameVersionFeature.getDefaultInstance()) {
                    getGameFeatureBuilder().mergeFrom((Message) gameVersionFeature);
                } else {
                    this.gameFeature_ = gameVersionFeature;
                }
            } else {
                singleFieldBuilder.mergeFrom(gameVersionFeature);
            }
            if (this.gameFeature_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder clearGameFeature() {
            this.bitField0_ &= -5;
            this.gameFeature_ = null;
            SingleFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> singleFieldBuilder = this.gameFeatureBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.gameFeatureBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public GameVersionFeature.Builder getGameFeatureBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (GameVersionFeature.Builder) getGameFeatureFieldBuilder().getBuilder();
        }

        @Override // proto.GameVersionFeatureValueOrBuilder
        public GameVersionFeatureOrBuilder getGameFeatureOrBuilder() {
            SingleFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> singleFieldBuilder = this.gameFeatureBuilder_;
            if (singleFieldBuilder != null) {
                return (GameVersionFeatureOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            GameVersionFeature gameVersionFeature = this.gameFeature_;
            return gameVersionFeature == null ? GameVersionFeature.getDefaultInstance() : gameVersionFeature;
        }

        private SingleFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> getGameFeatureFieldBuilder() {
            if (this.gameFeatureBuilder_ == null) {
                this.gameFeatureBuilder_ = new SingleFieldBuilder<>(getGameFeature(), getParentForChildren(), isClean());
                this.gameFeature_ = null;
            }
            return this.gameFeatureBuilder_;
        }

        @Override // proto.GameVersionFeatureValueOrBuilder
        public int getIncludedFeatureValue() {
            return this.includedFeature_;
        }

        public Builder setIncludedFeatureValue(int i) {
            this.includedFeature_ = i;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // proto.GameVersionFeatureValueOrBuilder
        public GameVersionFeatureValueIncludedFeatureEnum getIncludedFeature() {
            GameVersionFeatureValueIncludedFeatureEnum gameVersionFeatureValueIncludedFeatureEnumForNumber = GameVersionFeatureValueIncludedFeatureEnum.forNumber(this.includedFeature_);
            return gameVersionFeatureValueIncludedFeatureEnumForNumber == null ? GameVersionFeatureValueIncludedFeatureEnum.UNRECOGNIZED : gameVersionFeatureValueIncludedFeatureEnumForNumber;
        }

        public Builder setIncludedFeature(GameVersionFeatureValueIncludedFeatureEnum gameVersionFeatureValueIncludedFeatureEnum) {
            gameVersionFeatureValueIncludedFeatureEnum.getClass();
            this.bitField0_ |= 8;
            this.includedFeature_ = gameVersionFeatureValueIncludedFeatureEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearIncludedFeature() {
            this.bitField0_ &= -9;
            this.includedFeature_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.GameVersionFeatureValueOrBuilder
        public String getNote() {
            Object obj = this.note_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.note_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameVersionFeatureValueOrBuilder
        public ByteString getNoteBytes() {
            Object obj = this.note_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.note_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setNote(String str) {
            str.getClass();
            this.note_ = str;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearNote() {
            this.note_ = GameVersionFeatureValue.getDefaultInstance().getNote();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder setNoteBytes(ByteString byteString) {
            byteString.getClass();
            GameVersionFeatureValue.checkByteStringIsUtf8(byteString);
            this.note_ = byteString;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        @Override // proto.GameVersionFeatureValueOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameVersionFeatureValueOrBuilder
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
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = GameVersionFeatureValue.getDefaultInstance().getChecksum();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            GameVersionFeatureValue.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }
    }

    public static GameVersionFeatureValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.GameVersionFeatureValue$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<GameVersionFeatureValue> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public GameVersionFeatureValue parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = GameVersionFeatureValue.newBuilder();
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

    public static Parser<GameVersionFeatureValue> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GameVersionFeatureValue> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GameVersionFeatureValue getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
