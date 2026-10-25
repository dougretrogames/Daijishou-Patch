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
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class GameResult extends GeneratedMessage implements GameResultOrBuilder {
    private static final GameResult DEFAULT_INSTANCE;
    public static final int GAMES_FIELD_NUMBER = 1;
    private static final Parser<GameResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<Game> games_;

    /* synthetic */ GameResult(GeneratedMessage.Builder builder, GameResultIA gameResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameResult.class.getName());
        DEFAULT_INSTANCE = new GameResult();
        PARSER = new AnonymousClass1();
    }

    private GameResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private GameResult() {
        this.games_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_GameResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_GameResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameResult.class, Builder.class);
    }

    @Override // proto.GameResultOrBuilder
    public List<Game> getGamesList() {
        return this.games_;
    }

    @Override // proto.GameResultOrBuilder
    public List<? extends GameOrBuilder> getGamesOrBuilderList() {
        return this.games_;
    }

    @Override // proto.GameResultOrBuilder
    public int getGamesCount() {
        return this.games_.size();
    }

    @Override // proto.GameResultOrBuilder
    public Game getGames(int i) {
        return this.games_.get(i);
    }

    @Override // proto.GameResultOrBuilder
    public GameOrBuilder getGamesOrBuilder(int i) {
        return this.games_.get(i);
    }

    public static GameResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GameResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GameResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GameResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GameResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GameResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GameResult parseFrom(InputStream inputStream) throws IOException {
        return (GameResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static GameResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GameResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GameResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GameResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GameResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GameResult gameResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) gameResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((GameResultIA) null) : (Builder) new Builder((GameResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> gamesBuilder_;
        private List<Game> games_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, GameResultIA gameResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(GameResultIA gameResultIA) {
            this();
        }

        private void buildPartial0(GameResult gameResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_GameResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_GameResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameResult.class, Builder.class);
        }

        private Builder() {
            this.games_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.games_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.games_ = Collections.emptyList();
            } else {
                this.games_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_GameResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameResult getDefaultInstanceForType() {
            return GameResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameResult build() {
            GameResult gameResultBuildPartial = buildPartial();
            if (gameResultBuildPartial.isInitialized()) {
                return gameResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) gameResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameResult buildPartial() {
            GameResult gameResult = new GameResult(this, null);
            buildPartialRepeatedFields(gameResult);
            if (this.bitField0_ != 0) {
                buildPartial0(gameResult);
            }
            onBuilt();
            return gameResult;
        }

        private void buildPartialRepeatedFields(GameResult gameResult) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.games_ = Collections.unmodifiableList(this.games_);
                    this.bitField0_ &= -2;
                }
                gameResult.games_ = this.games_;
                return;
            }
            gameResult.games_ = repeatedFieldBuilder.build();
        }

        private void ensureGamesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.games_ = new ArrayList(this.games_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.GameResultOrBuilder
        public List<Game> getGamesList() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.games_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameResultOrBuilder
        public int getGamesCount() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.games_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameResultOrBuilder
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
                this.bitField0_ &= -2;
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

        @Override // proto.GameResultOrBuilder
        public GameOrBuilder getGamesOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.games_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameResultOrBuilder
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
                this.gamesBuilder_ = new RepeatedFieldBuilder<>(this.games_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.games_ = null;
            }
            return this.gamesBuilder_;
        }
    }

    public static GameResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.GameResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<GameResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public GameResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = GameResult.newBuilder();
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

    public static Parser<GameResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GameResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GameResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
