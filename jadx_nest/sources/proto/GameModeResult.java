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

/* INFO: loaded from: classes6.dex */
public final class GameModeResult extends GeneratedMessage implements GameModeResultOrBuilder {
    private static final GameModeResult DEFAULT_INSTANCE;
    public static final int GAMEMODES_FIELD_NUMBER = 1;
    private static final Parser<GameModeResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<GameMode> gamemodes_;

    /* synthetic */ GameModeResult(GeneratedMessage.Builder builder, GameModeResultIA gameModeResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameModeResult.class.getName());
        DEFAULT_INSTANCE = new GameModeResult();
        PARSER = new AnonymousClass1();
    }

    private GameModeResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private GameModeResult() {
        this.gamemodes_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_GameModeResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_GameModeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameModeResult.class, Builder.class);
    }

    @Override // proto.GameModeResultOrBuilder
    public List<GameMode> getGamemodesList() {
        return this.gamemodes_;
    }

    @Override // proto.GameModeResultOrBuilder
    public List<? extends GameModeOrBuilder> getGamemodesOrBuilderList() {
        return this.gamemodes_;
    }

    @Override // proto.GameModeResultOrBuilder
    public int getGamemodesCount() {
        return this.gamemodes_.size();
    }

    @Override // proto.GameModeResultOrBuilder
    public GameMode getGamemodes(int i) {
        return this.gamemodes_.get(i);
    }

    @Override // proto.GameModeResultOrBuilder
    public GameModeOrBuilder getGamemodesOrBuilder(int i) {
        return this.gamemodes_.get(i);
    }

    public static GameModeResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GameModeResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GameModeResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GameModeResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GameModeResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GameModeResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GameModeResult parseFrom(InputStream inputStream) throws IOException {
        return (GameModeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static GameModeResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameModeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameModeResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GameModeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GameModeResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameModeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameModeResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GameModeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GameModeResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameModeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GameModeResult gameModeResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) gameModeResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((GameModeResultIA) null) : (Builder) new Builder((GameModeResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameModeResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> gamemodesBuilder_;
        private List<GameMode> gamemodes_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, GameModeResultIA gameModeResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(GameModeResultIA gameModeResultIA) {
            this();
        }

        private void buildPartial0(GameModeResult gameModeResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_GameModeResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_GameModeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameModeResult.class, Builder.class);
        }

        private Builder() {
            this.gamemodes_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.gamemodes_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gamemodesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gamemodes_ = Collections.emptyList();
            } else {
                this.gamemodes_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_GameModeResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameModeResult getDefaultInstanceForType() {
            return GameModeResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameModeResult build() {
            GameModeResult gameModeResultBuildPartial = buildPartial();
            if (gameModeResultBuildPartial.isInitialized()) {
                return gameModeResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) gameModeResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameModeResult buildPartial() {
            GameModeResult gameModeResult = new GameModeResult(this, null);
            buildPartialRepeatedFields(gameModeResult);
            if (this.bitField0_ != 0) {
                buildPartial0(gameModeResult);
            }
            onBuilt();
            return gameModeResult;
        }

        private void buildPartialRepeatedFields(GameModeResult gameModeResult) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gamemodesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.gamemodes_ = Collections.unmodifiableList(this.gamemodes_);
                    this.bitField0_ &= -2;
                }
                gameModeResult.gamemodes_ = this.gamemodes_;
                return;
            }
            gameModeResult.gamemodes_ = repeatedFieldBuilder.build();
        }

        private void ensureGamemodesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.gamemodes_ = new ArrayList(this.gamemodes_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.GameModeResultOrBuilder
        public List<GameMode> getGamemodesList() {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gamemodesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.gamemodes_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameModeResultOrBuilder
        public int getGamemodesCount() {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gamemodesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gamemodes_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameModeResultOrBuilder
        public GameMode getGamemodes(int i) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gamemodesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gamemodes_.get(i);
            }
            return (GameMode) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setGamemodes(int i, GameMode gameMode) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gamemodesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameMode.getClass();
                ensureGamemodesIsMutable();
                this.gamemodes_.set(i, gameMode);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, gameMode);
            return this;
        }

        public Builder setGamemodes(int i, GameMode.Builder builder) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gamemodesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamemodesIsMutable();
                this.gamemodes_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addGamemodes(GameMode gameMode) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gamemodesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameMode.getClass();
                ensureGamemodesIsMutable();
                this.gamemodes_.add(gameMode);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(gameMode);
            return this;
        }

        public Builder addGamemodes(int i, GameMode gameMode) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gamemodesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameMode.getClass();
                ensureGamemodesIsMutable();
                this.gamemodes_.add(i, gameMode);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, gameMode);
            return this;
        }

        public Builder addGamemodes(GameMode.Builder builder) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gamemodesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamemodesIsMutable();
                this.gamemodes_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addGamemodes(int i, GameMode.Builder builder) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gamemodesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamemodesIsMutable();
                this.gamemodes_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllGamemodes(Iterable<? extends GameMode> iterable) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gamemodesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamemodesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.gamemodes_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearGamemodes() {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gamemodesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gamemodes_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeGamemodes(int i) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gamemodesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamemodesIsMutable();
                this.gamemodes_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public GameMode.Builder getGamemodesBuilder(int i) {
            return (GameMode.Builder) getGamemodesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameModeResultOrBuilder
        public GameModeOrBuilder getGamemodesOrBuilder(int i) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gamemodesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gamemodes_.get(i);
            }
            return (GameModeOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameModeResultOrBuilder
        public List<? extends GameModeOrBuilder> getGamemodesOrBuilderList() {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gamemodesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.gamemodes_);
        }

        public GameMode.Builder addGamemodesBuilder() {
            return (GameMode.Builder) getGamemodesFieldBuilder().addBuilder(GameMode.getDefaultInstance());
        }

        public GameMode.Builder addGamemodesBuilder(int i) {
            return (GameMode.Builder) getGamemodesFieldBuilder().addBuilder(i, GameMode.getDefaultInstance());
        }

        public List<GameMode.Builder> getGamemodesBuilderList() {
            return getGamemodesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> getGamemodesFieldBuilder() {
            if (this.gamemodesBuilder_ == null) {
                this.gamemodesBuilder_ = new RepeatedFieldBuilder<>(this.gamemodes_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.gamemodes_ = null;
            }
            return this.gamemodesBuilder_;
        }
    }

    public static GameModeResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.GameModeResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<GameModeResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public GameModeResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = GameModeResult.newBuilder();
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

    public static Parser<GameModeResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GameModeResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GameModeResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
