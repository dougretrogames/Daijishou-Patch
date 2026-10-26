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
public final class GameLocalizationResult extends GeneratedMessage implements GameLocalizationResultOrBuilder {
    private static final GameLocalizationResult DEFAULT_INSTANCE;
    public static final int GAMELOCALIZATIONS_FIELD_NUMBER = 1;
    private static final Parser<GameLocalizationResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<GameLocalization> gamelocalizations_;

    /* synthetic */ GameLocalizationResult(GeneratedMessage.Builder builder, GameLocalizationResultIA gameLocalizationResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameLocalizationResult.class.getName());
        DEFAULT_INSTANCE = new GameLocalizationResult();
        PARSER = new AnonymousClass1();
    }

    private GameLocalizationResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private GameLocalizationResult() {
        this.gamelocalizations_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_GameLocalizationResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_GameLocalizationResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameLocalizationResult.class, Builder.class);
    }

    @Override // proto.GameLocalizationResultOrBuilder
    public List<GameLocalization> getGamelocalizationsList() {
        return this.gamelocalizations_;
    }

    @Override // proto.GameLocalizationResultOrBuilder
    public List<? extends GameLocalizationOrBuilder> getGamelocalizationsOrBuilderList() {
        return this.gamelocalizations_;
    }

    @Override // proto.GameLocalizationResultOrBuilder
    public int getGamelocalizationsCount() {
        return this.gamelocalizations_.size();
    }

    @Override // proto.GameLocalizationResultOrBuilder
    public GameLocalization getGamelocalizations(int i) {
        return this.gamelocalizations_.get(i);
    }

    @Override // proto.GameLocalizationResultOrBuilder
    public GameLocalizationOrBuilder getGamelocalizationsOrBuilder(int i) {
        return this.gamelocalizations_.get(i);
    }

    public static GameLocalizationResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GameLocalizationResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GameLocalizationResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GameLocalizationResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GameLocalizationResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GameLocalizationResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GameLocalizationResult parseFrom(InputStream inputStream) throws IOException {
        return (GameLocalizationResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static GameLocalizationResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameLocalizationResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameLocalizationResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GameLocalizationResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GameLocalizationResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameLocalizationResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameLocalizationResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GameLocalizationResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GameLocalizationResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameLocalizationResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GameLocalizationResult gameLocalizationResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) gameLocalizationResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((GameLocalizationResultIA) null) : (Builder) new Builder((GameLocalizationResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameLocalizationResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> gamelocalizationsBuilder_;
        private List<GameLocalization> gamelocalizations_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, GameLocalizationResultIA gameLocalizationResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(GameLocalizationResultIA gameLocalizationResultIA) {
            this();
        }

        private void buildPartial0(GameLocalizationResult gameLocalizationResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_GameLocalizationResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_GameLocalizationResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameLocalizationResult.class, Builder.class);
        }

        private Builder() {
            this.gamelocalizations_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.gamelocalizations_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gamelocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gamelocalizations_ = Collections.emptyList();
            } else {
                this.gamelocalizations_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_GameLocalizationResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameLocalizationResult getDefaultInstanceForType() {
            return GameLocalizationResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameLocalizationResult build() {
            GameLocalizationResult gameLocalizationResultBuildPartial = buildPartial();
            if (gameLocalizationResultBuildPartial.isInitialized()) {
                return gameLocalizationResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) gameLocalizationResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameLocalizationResult buildPartial() {
            GameLocalizationResult gameLocalizationResult = new GameLocalizationResult(this, null);
            buildPartialRepeatedFields(gameLocalizationResult);
            if (this.bitField0_ != 0) {
                buildPartial0(gameLocalizationResult);
            }
            onBuilt();
            return gameLocalizationResult;
        }

        private void buildPartialRepeatedFields(GameLocalizationResult gameLocalizationResult) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gamelocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.gamelocalizations_ = Collections.unmodifiableList(this.gamelocalizations_);
                    this.bitField0_ &= -2;
                }
                gameLocalizationResult.gamelocalizations_ = this.gamelocalizations_;
                return;
            }
            gameLocalizationResult.gamelocalizations_ = repeatedFieldBuilder.build();
        }

        private void ensureGamelocalizationsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.gamelocalizations_ = new ArrayList(this.gamelocalizations_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.GameLocalizationResultOrBuilder
        public List<GameLocalization> getGamelocalizationsList() {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gamelocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.gamelocalizations_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameLocalizationResultOrBuilder
        public int getGamelocalizationsCount() {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gamelocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gamelocalizations_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameLocalizationResultOrBuilder
        public GameLocalization getGamelocalizations(int i) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gamelocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gamelocalizations_.get(i);
            }
            return (GameLocalization) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setGamelocalizations(int i, GameLocalization gameLocalization) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gamelocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                gameLocalization.getClass();
                ensureGamelocalizationsIsMutable();
                this.gamelocalizations_.set(i, gameLocalization);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, gameLocalization);
            return this;
        }

        public Builder setGamelocalizations(int i, GameLocalization.Builder builder) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gamelocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamelocalizationsIsMutable();
                this.gamelocalizations_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addGamelocalizations(GameLocalization gameLocalization) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gamelocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                gameLocalization.getClass();
                ensureGamelocalizationsIsMutable();
                this.gamelocalizations_.add(gameLocalization);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(gameLocalization);
            return this;
        }

        public Builder addGamelocalizations(int i, GameLocalization gameLocalization) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gamelocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                gameLocalization.getClass();
                ensureGamelocalizationsIsMutable();
                this.gamelocalizations_.add(i, gameLocalization);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, gameLocalization);
            return this;
        }

        public Builder addGamelocalizations(GameLocalization.Builder builder) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gamelocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamelocalizationsIsMutable();
                this.gamelocalizations_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addGamelocalizations(int i, GameLocalization.Builder builder) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gamelocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamelocalizationsIsMutable();
                this.gamelocalizations_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllGamelocalizations(Iterable<? extends GameLocalization> iterable) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gamelocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamelocalizationsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.gamelocalizations_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearGamelocalizations() {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gamelocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gamelocalizations_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeGamelocalizations(int i) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gamelocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamelocalizationsIsMutable();
                this.gamelocalizations_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public GameLocalization.Builder getGamelocalizationsBuilder(int i) {
            return (GameLocalization.Builder) getGamelocalizationsFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameLocalizationResultOrBuilder
        public GameLocalizationOrBuilder getGamelocalizationsOrBuilder(int i) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gamelocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gamelocalizations_.get(i);
            }
            return (GameLocalizationOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameLocalizationResultOrBuilder
        public List<? extends GameLocalizationOrBuilder> getGamelocalizationsOrBuilderList() {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gamelocalizationsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.gamelocalizations_);
        }

        public GameLocalization.Builder addGamelocalizationsBuilder() {
            return (GameLocalization.Builder) getGamelocalizationsFieldBuilder().addBuilder(GameLocalization.getDefaultInstance());
        }

        public GameLocalization.Builder addGamelocalizationsBuilder(int i) {
            return (GameLocalization.Builder) getGamelocalizationsFieldBuilder().addBuilder(i, GameLocalization.getDefaultInstance());
        }

        public List<GameLocalization.Builder> getGamelocalizationsBuilderList() {
            return getGamelocalizationsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> getGamelocalizationsFieldBuilder() {
            if (this.gamelocalizationsBuilder_ == null) {
                this.gamelocalizationsBuilder_ = new RepeatedFieldBuilder<>(this.gamelocalizations_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.gamelocalizations_ = null;
            }
            return this.gamelocalizationsBuilder_;
        }
    }

    public static GameLocalizationResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.GameLocalizationResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<GameLocalizationResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public GameLocalizationResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = GameLocalizationResult.newBuilder();
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

    public static Parser<GameLocalizationResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GameLocalizationResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GameLocalizationResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
