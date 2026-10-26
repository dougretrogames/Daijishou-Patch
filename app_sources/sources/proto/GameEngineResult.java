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
public final class GameEngineResult extends GeneratedMessage implements GameEngineResultOrBuilder {
    private static final GameEngineResult DEFAULT_INSTANCE;
    public static final int GAMEENGINES_FIELD_NUMBER = 1;
    private static final Parser<GameEngineResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<GameEngine> gameengines_;

    /* synthetic */ GameEngineResult(GeneratedMessage.Builder builder, GameEngineResultIA gameEngineResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameEngineResult.class.getName());
        DEFAULT_INSTANCE = new GameEngineResult();
        PARSER = new AnonymousClass1();
    }

    private GameEngineResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private GameEngineResult() {
        this.gameengines_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_GameEngineResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_GameEngineResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameEngineResult.class, Builder.class);
    }

    @Override // proto.GameEngineResultOrBuilder
    public List<GameEngine> getGameenginesList() {
        return this.gameengines_;
    }

    @Override // proto.GameEngineResultOrBuilder
    public List<? extends GameEngineOrBuilder> getGameenginesOrBuilderList() {
        return this.gameengines_;
    }

    @Override // proto.GameEngineResultOrBuilder
    public int getGameenginesCount() {
        return this.gameengines_.size();
    }

    @Override // proto.GameEngineResultOrBuilder
    public GameEngine getGameengines(int i) {
        return this.gameengines_.get(i);
    }

    @Override // proto.GameEngineResultOrBuilder
    public GameEngineOrBuilder getGameenginesOrBuilder(int i) {
        return this.gameengines_.get(i);
    }

    public static GameEngineResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GameEngineResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GameEngineResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GameEngineResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GameEngineResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GameEngineResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GameEngineResult parseFrom(InputStream inputStream) throws IOException {
        return (GameEngineResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static GameEngineResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameEngineResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameEngineResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GameEngineResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GameEngineResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameEngineResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameEngineResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GameEngineResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GameEngineResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameEngineResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GameEngineResult gameEngineResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) gameEngineResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((GameEngineResultIA) null) : (Builder) new Builder((GameEngineResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameEngineResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> gameenginesBuilder_;
        private List<GameEngine> gameengines_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, GameEngineResultIA gameEngineResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(GameEngineResultIA gameEngineResultIA) {
            this();
        }

        private void buildPartial0(GameEngineResult gameEngineResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_GameEngineResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_GameEngineResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameEngineResult.class, Builder.class);
        }

        private Builder() {
            this.gameengines_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.gameengines_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameenginesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gameengines_ = Collections.emptyList();
            } else {
                this.gameengines_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_GameEngineResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameEngineResult getDefaultInstanceForType() {
            return GameEngineResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameEngineResult build() {
            GameEngineResult gameEngineResultBuildPartial = buildPartial();
            if (gameEngineResultBuildPartial.isInitialized()) {
                return gameEngineResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) gameEngineResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameEngineResult buildPartial() {
            GameEngineResult gameEngineResult = new GameEngineResult(this, null);
            buildPartialRepeatedFields(gameEngineResult);
            if (this.bitField0_ != 0) {
                buildPartial0(gameEngineResult);
            }
            onBuilt();
            return gameEngineResult;
        }

        private void buildPartialRepeatedFields(GameEngineResult gameEngineResult) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameenginesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.gameengines_ = Collections.unmodifiableList(this.gameengines_);
                    this.bitField0_ &= -2;
                }
                gameEngineResult.gameengines_ = this.gameengines_;
                return;
            }
            gameEngineResult.gameengines_ = repeatedFieldBuilder.build();
        }

        private void ensureGameenginesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.gameengines_ = new ArrayList(this.gameengines_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.GameEngineResultOrBuilder
        public List<GameEngine> getGameenginesList() {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameenginesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.gameengines_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameEngineResultOrBuilder
        public int getGameenginesCount() {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameenginesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameengines_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameEngineResultOrBuilder
        public GameEngine getGameengines(int i) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameenginesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameengines_.get(i);
            }
            return (GameEngine) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setGameengines(int i, GameEngine gameEngine) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameenginesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameEngine.getClass();
                ensureGameenginesIsMutable();
                this.gameengines_.set(i, gameEngine);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, gameEngine);
            return this;
        }

        public Builder setGameengines(int i, GameEngine.Builder builder) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameenginesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameenginesIsMutable();
                this.gameengines_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addGameengines(GameEngine gameEngine) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameenginesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameEngine.getClass();
                ensureGameenginesIsMutable();
                this.gameengines_.add(gameEngine);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(gameEngine);
            return this;
        }

        public Builder addGameengines(int i, GameEngine gameEngine) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameenginesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameEngine.getClass();
                ensureGameenginesIsMutable();
                this.gameengines_.add(i, gameEngine);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, gameEngine);
            return this;
        }

        public Builder addGameengines(GameEngine.Builder builder) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameenginesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameenginesIsMutable();
                this.gameengines_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addGameengines(int i, GameEngine.Builder builder) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameenginesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameenginesIsMutable();
                this.gameengines_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllGameengines(Iterable<? extends GameEngine> iterable) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameenginesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameenginesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.gameengines_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearGameengines() {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameenginesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gameengines_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeGameengines(int i) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameenginesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameenginesIsMutable();
                this.gameengines_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public GameEngine.Builder getGameenginesBuilder(int i) {
            return (GameEngine.Builder) getGameenginesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameEngineResultOrBuilder
        public GameEngineOrBuilder getGameenginesOrBuilder(int i) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameenginesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameengines_.get(i);
            }
            return (GameEngineOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameEngineResultOrBuilder
        public List<? extends GameEngineOrBuilder> getGameenginesOrBuilderList() {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameenginesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.gameengines_);
        }

        public GameEngine.Builder addGameenginesBuilder() {
            return (GameEngine.Builder) getGameenginesFieldBuilder().addBuilder(GameEngine.getDefaultInstance());
        }

        public GameEngine.Builder addGameenginesBuilder(int i) {
            return (GameEngine.Builder) getGameenginesFieldBuilder().addBuilder(i, GameEngine.getDefaultInstance());
        }

        public List<GameEngine.Builder> getGameenginesBuilderList() {
            return getGameenginesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> getGameenginesFieldBuilder() {
            if (this.gameenginesBuilder_ == null) {
                this.gameenginesBuilder_ = new RepeatedFieldBuilder<>(this.gameengines_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.gameengines_ = null;
            }
            return this.gameenginesBuilder_;
        }
    }

    public static GameEngineResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.GameEngineResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<GameEngineResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public GameEngineResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = GameEngineResult.newBuilder();
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

    public static Parser<GameEngineResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GameEngineResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GameEngineResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
