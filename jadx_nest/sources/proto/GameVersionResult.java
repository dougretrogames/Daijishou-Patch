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
public final class GameVersionResult extends GeneratedMessage implements GameVersionResultOrBuilder {
    private static final GameVersionResult DEFAULT_INSTANCE;
    public static final int GAMEVERSIONS_FIELD_NUMBER = 1;
    private static final Parser<GameVersionResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<GameVersion> gameversions_;

    /* synthetic */ GameVersionResult(GeneratedMessage.Builder builder, GameVersionResultIA gameVersionResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameVersionResult.class.getName());
        DEFAULT_INSTANCE = new GameVersionResult();
        PARSER = new AnonymousClass1();
    }

    private GameVersionResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private GameVersionResult() {
        this.gameversions_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_GameVersionResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_GameVersionResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameVersionResult.class, Builder.class);
    }

    @Override // proto.GameVersionResultOrBuilder
    public List<GameVersion> getGameversionsList() {
        return this.gameversions_;
    }

    @Override // proto.GameVersionResultOrBuilder
    public List<? extends GameVersionOrBuilder> getGameversionsOrBuilderList() {
        return this.gameversions_;
    }

    @Override // proto.GameVersionResultOrBuilder
    public int getGameversionsCount() {
        return this.gameversions_.size();
    }

    @Override // proto.GameVersionResultOrBuilder
    public GameVersion getGameversions(int i) {
        return this.gameversions_.get(i);
    }

    @Override // proto.GameVersionResultOrBuilder
    public GameVersionOrBuilder getGameversionsOrBuilder(int i) {
        return this.gameversions_.get(i);
    }

    public static GameVersionResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GameVersionResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GameVersionResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GameVersionResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GameVersionResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GameVersionResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GameVersionResult parseFrom(InputStream inputStream) throws IOException {
        return (GameVersionResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static GameVersionResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersionResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameVersionResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GameVersionResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GameVersionResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersionResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameVersionResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GameVersionResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GameVersionResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersionResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GameVersionResult gameVersionResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) gameVersionResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((GameVersionResultIA) null) : (Builder) new Builder((GameVersionResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameVersionResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> gameversionsBuilder_;
        private List<GameVersion> gameversions_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, GameVersionResultIA gameVersionResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(GameVersionResultIA gameVersionResultIA) {
            this();
        }

        private void buildPartial0(GameVersionResult gameVersionResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_GameVersionResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_GameVersionResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameVersionResult.class, Builder.class);
        }

        private Builder() {
            this.gameversions_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.gameversions_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> repeatedFieldBuilder = this.gameversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gameversions_ = Collections.emptyList();
            } else {
                this.gameversions_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_GameVersionResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameVersionResult getDefaultInstanceForType() {
            return GameVersionResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameVersionResult build() {
            GameVersionResult gameVersionResultBuildPartial = buildPartial();
            if (gameVersionResultBuildPartial.isInitialized()) {
                return gameVersionResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) gameVersionResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameVersionResult buildPartial() {
            GameVersionResult gameVersionResult = new GameVersionResult(this, null);
            buildPartialRepeatedFields(gameVersionResult);
            if (this.bitField0_ != 0) {
                buildPartial0(gameVersionResult);
            }
            onBuilt();
            return gameVersionResult;
        }

        private void buildPartialRepeatedFields(GameVersionResult gameVersionResult) {
            RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> repeatedFieldBuilder = this.gameversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.gameversions_ = Collections.unmodifiableList(this.gameversions_);
                    this.bitField0_ &= -2;
                }
                gameVersionResult.gameversions_ = this.gameversions_;
                return;
            }
            gameVersionResult.gameversions_ = repeatedFieldBuilder.build();
        }

        private void ensureGameversionsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.gameversions_ = new ArrayList(this.gameversions_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.GameVersionResultOrBuilder
        public List<GameVersion> getGameversionsList() {
            RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> repeatedFieldBuilder = this.gameversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.gameversions_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameVersionResultOrBuilder
        public int getGameversionsCount() {
            RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> repeatedFieldBuilder = this.gameversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameversions_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameVersionResultOrBuilder
        public GameVersion getGameversions(int i) {
            RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> repeatedFieldBuilder = this.gameversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameversions_.get(i);
            }
            return (GameVersion) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setGameversions(int i, GameVersion gameVersion) {
            RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> repeatedFieldBuilder = this.gameversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVersion.getClass();
                ensureGameversionsIsMutable();
                this.gameversions_.set(i, gameVersion);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, gameVersion);
            return this;
        }

        public Builder setGameversions(int i, GameVersion.Builder builder) {
            RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> repeatedFieldBuilder = this.gameversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameversionsIsMutable();
                this.gameversions_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addGameversions(GameVersion gameVersion) {
            RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> repeatedFieldBuilder = this.gameversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVersion.getClass();
                ensureGameversionsIsMutable();
                this.gameversions_.add(gameVersion);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(gameVersion);
            return this;
        }

        public Builder addGameversions(int i, GameVersion gameVersion) {
            RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> repeatedFieldBuilder = this.gameversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVersion.getClass();
                ensureGameversionsIsMutable();
                this.gameversions_.add(i, gameVersion);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, gameVersion);
            return this;
        }

        public Builder addGameversions(GameVersion.Builder builder) {
            RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> repeatedFieldBuilder = this.gameversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameversionsIsMutable();
                this.gameversions_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addGameversions(int i, GameVersion.Builder builder) {
            RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> repeatedFieldBuilder = this.gameversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameversionsIsMutable();
                this.gameversions_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllGameversions(Iterable<? extends GameVersion> iterable) {
            RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> repeatedFieldBuilder = this.gameversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameversionsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.gameversions_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearGameversions() {
            RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> repeatedFieldBuilder = this.gameversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gameversions_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeGameversions(int i) {
            RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> repeatedFieldBuilder = this.gameversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameversionsIsMutable();
                this.gameversions_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public GameVersion.Builder getGameversionsBuilder(int i) {
            return (GameVersion.Builder) getGameversionsFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameVersionResultOrBuilder
        public GameVersionOrBuilder getGameversionsOrBuilder(int i) {
            RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> repeatedFieldBuilder = this.gameversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameversions_.get(i);
            }
            return (GameVersionOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameVersionResultOrBuilder
        public List<? extends GameVersionOrBuilder> getGameversionsOrBuilderList() {
            RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> repeatedFieldBuilder = this.gameversionsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.gameversions_);
        }

        public GameVersion.Builder addGameversionsBuilder() {
            return (GameVersion.Builder) getGameversionsFieldBuilder().addBuilder(GameVersion.getDefaultInstance());
        }

        public GameVersion.Builder addGameversionsBuilder(int i) {
            return (GameVersion.Builder) getGameversionsFieldBuilder().addBuilder(i, GameVersion.getDefaultInstance());
        }

        public List<GameVersion.Builder> getGameversionsBuilderList() {
            return getGameversionsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<GameVersion, GameVersion.Builder, GameVersionOrBuilder> getGameversionsFieldBuilder() {
            if (this.gameversionsBuilder_ == null) {
                this.gameversionsBuilder_ = new RepeatedFieldBuilder<>(this.gameversions_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.gameversions_ = null;
            }
            return this.gameversionsBuilder_;
        }
    }

    public static GameVersionResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.GameVersionResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<GameVersionResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public GameVersionResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = GameVersionResult.newBuilder();
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

    public static Parser<GameVersionResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GameVersionResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GameVersionResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
