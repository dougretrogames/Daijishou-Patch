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
public final class GameEngineLogoResult extends GeneratedMessage implements GameEngineLogoResultOrBuilder {
    private static final GameEngineLogoResult DEFAULT_INSTANCE;
    public static final int GAMEENGINELOGOS_FIELD_NUMBER = 1;
    private static final Parser<GameEngineLogoResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<GameEngineLogo> gameenginelogos_;

    /* synthetic */ GameEngineLogoResult(GeneratedMessage.Builder builder, GameEngineLogoResultIA gameEngineLogoResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameEngineLogoResult.class.getName());
        DEFAULT_INSTANCE = new GameEngineLogoResult();
        PARSER = new AnonymousClass1();
    }

    private GameEngineLogoResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private GameEngineLogoResult() {
        this.gameenginelogos_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_GameEngineLogoResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_GameEngineLogoResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameEngineLogoResult.class, Builder.class);
    }

    @Override // proto.GameEngineLogoResultOrBuilder
    public List<GameEngineLogo> getGameenginelogosList() {
        return this.gameenginelogos_;
    }

    @Override // proto.GameEngineLogoResultOrBuilder
    public List<? extends GameEngineLogoOrBuilder> getGameenginelogosOrBuilderList() {
        return this.gameenginelogos_;
    }

    @Override // proto.GameEngineLogoResultOrBuilder
    public int getGameenginelogosCount() {
        return this.gameenginelogos_.size();
    }

    @Override // proto.GameEngineLogoResultOrBuilder
    public GameEngineLogo getGameenginelogos(int i) {
        return this.gameenginelogos_.get(i);
    }

    @Override // proto.GameEngineLogoResultOrBuilder
    public GameEngineLogoOrBuilder getGameenginelogosOrBuilder(int i) {
        return this.gameenginelogos_.get(i);
    }

    public static GameEngineLogoResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GameEngineLogoResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GameEngineLogoResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GameEngineLogoResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GameEngineLogoResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GameEngineLogoResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GameEngineLogoResult parseFrom(InputStream inputStream) throws IOException {
        return (GameEngineLogoResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static GameEngineLogoResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameEngineLogoResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameEngineLogoResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GameEngineLogoResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GameEngineLogoResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameEngineLogoResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameEngineLogoResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GameEngineLogoResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GameEngineLogoResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameEngineLogoResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GameEngineLogoResult gameEngineLogoResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) gameEngineLogoResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((GameEngineLogoResultIA) null) : (Builder) new Builder((GameEngineLogoResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameEngineLogoResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> gameenginelogosBuilder_;
        private List<GameEngineLogo> gameenginelogos_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, GameEngineLogoResultIA gameEngineLogoResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(GameEngineLogoResultIA gameEngineLogoResultIA) {
            this();
        }

        private void buildPartial0(GameEngineLogoResult gameEngineLogoResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_GameEngineLogoResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_GameEngineLogoResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameEngineLogoResult.class, Builder.class);
        }

        private Builder() {
            this.gameenginelogos_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.gameenginelogos_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> repeatedFieldBuilder = this.gameenginelogosBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gameenginelogos_ = Collections.emptyList();
            } else {
                this.gameenginelogos_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_GameEngineLogoResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameEngineLogoResult getDefaultInstanceForType() {
            return GameEngineLogoResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameEngineLogoResult build() {
            GameEngineLogoResult gameEngineLogoResultBuildPartial = buildPartial();
            if (gameEngineLogoResultBuildPartial.isInitialized()) {
                return gameEngineLogoResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) gameEngineLogoResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameEngineLogoResult buildPartial() {
            GameEngineLogoResult gameEngineLogoResult = new GameEngineLogoResult(this, null);
            buildPartialRepeatedFields(gameEngineLogoResult);
            if (this.bitField0_ != 0) {
                buildPartial0(gameEngineLogoResult);
            }
            onBuilt();
            return gameEngineLogoResult;
        }

        private void buildPartialRepeatedFields(GameEngineLogoResult gameEngineLogoResult) {
            RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> repeatedFieldBuilder = this.gameenginelogosBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.gameenginelogos_ = Collections.unmodifiableList(this.gameenginelogos_);
                    this.bitField0_ &= -2;
                }
                gameEngineLogoResult.gameenginelogos_ = this.gameenginelogos_;
                return;
            }
            gameEngineLogoResult.gameenginelogos_ = repeatedFieldBuilder.build();
        }

        private void ensureGameenginelogosIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.gameenginelogos_ = new ArrayList(this.gameenginelogos_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.GameEngineLogoResultOrBuilder
        public List<GameEngineLogo> getGameenginelogosList() {
            RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> repeatedFieldBuilder = this.gameenginelogosBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.gameenginelogos_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameEngineLogoResultOrBuilder
        public int getGameenginelogosCount() {
            RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> repeatedFieldBuilder = this.gameenginelogosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameenginelogos_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameEngineLogoResultOrBuilder
        public GameEngineLogo getGameenginelogos(int i) {
            RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> repeatedFieldBuilder = this.gameenginelogosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameenginelogos_.get(i);
            }
            return (GameEngineLogo) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setGameenginelogos(int i, GameEngineLogo gameEngineLogo) {
            RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> repeatedFieldBuilder = this.gameenginelogosBuilder_;
            if (repeatedFieldBuilder == null) {
                gameEngineLogo.getClass();
                ensureGameenginelogosIsMutable();
                this.gameenginelogos_.set(i, gameEngineLogo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, gameEngineLogo);
            return this;
        }

        public Builder setGameenginelogos(int i, GameEngineLogo.Builder builder) {
            RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> repeatedFieldBuilder = this.gameenginelogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameenginelogosIsMutable();
                this.gameenginelogos_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addGameenginelogos(GameEngineLogo gameEngineLogo) {
            RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> repeatedFieldBuilder = this.gameenginelogosBuilder_;
            if (repeatedFieldBuilder == null) {
                gameEngineLogo.getClass();
                ensureGameenginelogosIsMutable();
                this.gameenginelogos_.add(gameEngineLogo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(gameEngineLogo);
            return this;
        }

        public Builder addGameenginelogos(int i, GameEngineLogo gameEngineLogo) {
            RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> repeatedFieldBuilder = this.gameenginelogosBuilder_;
            if (repeatedFieldBuilder == null) {
                gameEngineLogo.getClass();
                ensureGameenginelogosIsMutable();
                this.gameenginelogos_.add(i, gameEngineLogo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, gameEngineLogo);
            return this;
        }

        public Builder addGameenginelogos(GameEngineLogo.Builder builder) {
            RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> repeatedFieldBuilder = this.gameenginelogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameenginelogosIsMutable();
                this.gameenginelogos_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addGameenginelogos(int i, GameEngineLogo.Builder builder) {
            RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> repeatedFieldBuilder = this.gameenginelogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameenginelogosIsMutable();
                this.gameenginelogos_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllGameenginelogos(Iterable<? extends GameEngineLogo> iterable) {
            RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> repeatedFieldBuilder = this.gameenginelogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameenginelogosIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.gameenginelogos_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearGameenginelogos() {
            RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> repeatedFieldBuilder = this.gameenginelogosBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gameenginelogos_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeGameenginelogos(int i) {
            RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> repeatedFieldBuilder = this.gameenginelogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameenginelogosIsMutable();
                this.gameenginelogos_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public GameEngineLogo.Builder getGameenginelogosBuilder(int i) {
            return (GameEngineLogo.Builder) getGameenginelogosFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameEngineLogoResultOrBuilder
        public GameEngineLogoOrBuilder getGameenginelogosOrBuilder(int i) {
            RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> repeatedFieldBuilder = this.gameenginelogosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameenginelogos_.get(i);
            }
            return (GameEngineLogoOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameEngineLogoResultOrBuilder
        public List<? extends GameEngineLogoOrBuilder> getGameenginelogosOrBuilderList() {
            RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> repeatedFieldBuilder = this.gameenginelogosBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.gameenginelogos_);
        }

        public GameEngineLogo.Builder addGameenginelogosBuilder() {
            return (GameEngineLogo.Builder) getGameenginelogosFieldBuilder().addBuilder(GameEngineLogo.getDefaultInstance());
        }

        public GameEngineLogo.Builder addGameenginelogosBuilder(int i) {
            return (GameEngineLogo.Builder) getGameenginelogosFieldBuilder().addBuilder(i, GameEngineLogo.getDefaultInstance());
        }

        public List<GameEngineLogo.Builder> getGameenginelogosBuilderList() {
            return getGameenginelogosFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> getGameenginelogosFieldBuilder() {
            if (this.gameenginelogosBuilder_ == null) {
                this.gameenginelogosBuilder_ = new RepeatedFieldBuilder<>(this.gameenginelogos_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.gameenginelogos_ = null;
            }
            return this.gameenginelogosBuilder_;
        }
    }

    public static GameEngineLogoResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.GameEngineLogoResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<GameEngineLogoResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public GameEngineLogoResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = GameEngineLogoResult.newBuilder();
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

    public static Parser<GameEngineLogoResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GameEngineLogoResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GameEngineLogoResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
