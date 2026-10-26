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
public final class GameVersionFeatureValueResult extends GeneratedMessage implements GameVersionFeatureValueResultOrBuilder {
    private static final GameVersionFeatureValueResult DEFAULT_INSTANCE;
    public static final int GAMEVERSIONFEATUREVALUES_FIELD_NUMBER = 1;
    private static final Parser<GameVersionFeatureValueResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<GameVersionFeatureValue> gameversionfeaturevalues_;

    /* synthetic */ GameVersionFeatureValueResult(GeneratedMessage.Builder builder, GameVersionFeatureValueResultIA gameVersionFeatureValueResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameVersionFeatureValueResult.class.getName());
        DEFAULT_INSTANCE = new GameVersionFeatureValueResult();
        PARSER = new AnonymousClass1();
    }

    private GameVersionFeatureValueResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private GameVersionFeatureValueResult() {
        this.gameversionfeaturevalues_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_GameVersionFeatureValueResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_GameVersionFeatureValueResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameVersionFeatureValueResult.class, Builder.class);
    }

    @Override // proto.GameVersionFeatureValueResultOrBuilder
    public List<GameVersionFeatureValue> getGameversionfeaturevaluesList() {
        return this.gameversionfeaturevalues_;
    }

    @Override // proto.GameVersionFeatureValueResultOrBuilder
    public List<? extends GameVersionFeatureValueOrBuilder> getGameversionfeaturevaluesOrBuilderList() {
        return this.gameversionfeaturevalues_;
    }

    @Override // proto.GameVersionFeatureValueResultOrBuilder
    public int getGameversionfeaturevaluesCount() {
        return this.gameversionfeaturevalues_.size();
    }

    @Override // proto.GameVersionFeatureValueResultOrBuilder
    public GameVersionFeatureValue getGameversionfeaturevalues(int i) {
        return this.gameversionfeaturevalues_.get(i);
    }

    @Override // proto.GameVersionFeatureValueResultOrBuilder
    public GameVersionFeatureValueOrBuilder getGameversionfeaturevaluesOrBuilder(int i) {
        return this.gameversionfeaturevalues_.get(i);
    }

    public static GameVersionFeatureValueResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GameVersionFeatureValueResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GameVersionFeatureValueResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GameVersionFeatureValueResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GameVersionFeatureValueResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GameVersionFeatureValueResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GameVersionFeatureValueResult parseFrom(InputStream inputStream) throws IOException {
        return (GameVersionFeatureValueResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static GameVersionFeatureValueResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersionFeatureValueResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameVersionFeatureValueResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GameVersionFeatureValueResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GameVersionFeatureValueResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersionFeatureValueResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameVersionFeatureValueResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GameVersionFeatureValueResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GameVersionFeatureValueResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersionFeatureValueResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GameVersionFeatureValueResult gameVersionFeatureValueResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) gameVersionFeatureValueResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((GameVersionFeatureValueResultIA) null) : (Builder) new Builder((GameVersionFeatureValueResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameVersionFeatureValueResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> gameversionfeaturevaluesBuilder_;
        private List<GameVersionFeatureValue> gameversionfeaturevalues_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, GameVersionFeatureValueResultIA gameVersionFeatureValueResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(GameVersionFeatureValueResultIA gameVersionFeatureValueResultIA) {
            this();
        }

        private void buildPartial0(GameVersionFeatureValueResult gameVersionFeatureValueResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_GameVersionFeatureValueResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_GameVersionFeatureValueResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameVersionFeatureValueResult.class, Builder.class);
        }

        private Builder() {
            this.gameversionfeaturevalues_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.gameversionfeaturevalues_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.gameversionfeaturevaluesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gameversionfeaturevalues_ = Collections.emptyList();
            } else {
                this.gameversionfeaturevalues_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_GameVersionFeatureValueResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameVersionFeatureValueResult getDefaultInstanceForType() {
            return GameVersionFeatureValueResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameVersionFeatureValueResult build() {
            GameVersionFeatureValueResult gameVersionFeatureValueResultBuildPartial = buildPartial();
            if (gameVersionFeatureValueResultBuildPartial.isInitialized()) {
                return gameVersionFeatureValueResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) gameVersionFeatureValueResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameVersionFeatureValueResult buildPartial() {
            GameVersionFeatureValueResult gameVersionFeatureValueResult = new GameVersionFeatureValueResult(this, null);
            buildPartialRepeatedFields(gameVersionFeatureValueResult);
            if (this.bitField0_ != 0) {
                buildPartial0(gameVersionFeatureValueResult);
            }
            onBuilt();
            return gameVersionFeatureValueResult;
        }

        private void buildPartialRepeatedFields(GameVersionFeatureValueResult gameVersionFeatureValueResult) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.gameversionfeaturevaluesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.gameversionfeaturevalues_ = Collections.unmodifiableList(this.gameversionfeaturevalues_);
                    this.bitField0_ &= -2;
                }
                gameVersionFeatureValueResult.gameversionfeaturevalues_ = this.gameversionfeaturevalues_;
                return;
            }
            gameVersionFeatureValueResult.gameversionfeaturevalues_ = repeatedFieldBuilder.build();
        }

        private void ensureGameversionfeaturevaluesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.gameversionfeaturevalues_ = new ArrayList(this.gameversionfeaturevalues_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.GameVersionFeatureValueResultOrBuilder
        public List<GameVersionFeatureValue> getGameversionfeaturevaluesList() {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.gameversionfeaturevaluesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.gameversionfeaturevalues_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameVersionFeatureValueResultOrBuilder
        public int getGameversionfeaturevaluesCount() {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.gameversionfeaturevaluesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameversionfeaturevalues_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameVersionFeatureValueResultOrBuilder
        public GameVersionFeatureValue getGameversionfeaturevalues(int i) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.gameversionfeaturevaluesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameversionfeaturevalues_.get(i);
            }
            return (GameVersionFeatureValue) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setGameversionfeaturevalues(int i, GameVersionFeatureValue gameVersionFeatureValue) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.gameversionfeaturevaluesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVersionFeatureValue.getClass();
                ensureGameversionfeaturevaluesIsMutable();
                this.gameversionfeaturevalues_.set(i, gameVersionFeatureValue);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, gameVersionFeatureValue);
            return this;
        }

        public Builder setGameversionfeaturevalues(int i, GameVersionFeatureValue.Builder builder) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.gameversionfeaturevaluesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameversionfeaturevaluesIsMutable();
                this.gameversionfeaturevalues_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addGameversionfeaturevalues(GameVersionFeatureValue gameVersionFeatureValue) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.gameversionfeaturevaluesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVersionFeatureValue.getClass();
                ensureGameversionfeaturevaluesIsMutable();
                this.gameversionfeaturevalues_.add(gameVersionFeatureValue);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(gameVersionFeatureValue);
            return this;
        }

        public Builder addGameversionfeaturevalues(int i, GameVersionFeatureValue gameVersionFeatureValue) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.gameversionfeaturevaluesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVersionFeatureValue.getClass();
                ensureGameversionfeaturevaluesIsMutable();
                this.gameversionfeaturevalues_.add(i, gameVersionFeatureValue);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, gameVersionFeatureValue);
            return this;
        }

        public Builder addGameversionfeaturevalues(GameVersionFeatureValue.Builder builder) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.gameversionfeaturevaluesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameversionfeaturevaluesIsMutable();
                this.gameversionfeaturevalues_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addGameversionfeaturevalues(int i, GameVersionFeatureValue.Builder builder) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.gameversionfeaturevaluesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameversionfeaturevaluesIsMutable();
                this.gameversionfeaturevalues_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllGameversionfeaturevalues(Iterable<? extends GameVersionFeatureValue> iterable) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.gameversionfeaturevaluesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameversionfeaturevaluesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.gameversionfeaturevalues_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearGameversionfeaturevalues() {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.gameversionfeaturevaluesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gameversionfeaturevalues_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeGameversionfeaturevalues(int i) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.gameversionfeaturevaluesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameversionfeaturevaluesIsMutable();
                this.gameversionfeaturevalues_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public GameVersionFeatureValue.Builder getGameversionfeaturevaluesBuilder(int i) {
            return (GameVersionFeatureValue.Builder) getGameversionfeaturevaluesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameVersionFeatureValueResultOrBuilder
        public GameVersionFeatureValueOrBuilder getGameversionfeaturevaluesOrBuilder(int i) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.gameversionfeaturevaluesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameversionfeaturevalues_.get(i);
            }
            return (GameVersionFeatureValueOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameVersionFeatureValueResultOrBuilder
        public List<? extends GameVersionFeatureValueOrBuilder> getGameversionfeaturevaluesOrBuilderList() {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.gameversionfeaturevaluesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.gameversionfeaturevalues_);
        }

        public GameVersionFeatureValue.Builder addGameversionfeaturevaluesBuilder() {
            return (GameVersionFeatureValue.Builder) getGameversionfeaturevaluesFieldBuilder().addBuilder(GameVersionFeatureValue.getDefaultInstance());
        }

        public GameVersionFeatureValue.Builder addGameversionfeaturevaluesBuilder(int i) {
            return (GameVersionFeatureValue.Builder) getGameversionfeaturevaluesFieldBuilder().addBuilder(i, GameVersionFeatureValue.getDefaultInstance());
        }

        public List<GameVersionFeatureValue.Builder> getGameversionfeaturevaluesBuilderList() {
            return getGameversionfeaturevaluesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> getGameversionfeaturevaluesFieldBuilder() {
            if (this.gameversionfeaturevaluesBuilder_ == null) {
                this.gameversionfeaturevaluesBuilder_ = new RepeatedFieldBuilder<>(this.gameversionfeaturevalues_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.gameversionfeaturevalues_ = null;
            }
            return this.gameversionfeaturevaluesBuilder_;
        }
    }

    public static GameVersionFeatureValueResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.GameVersionFeatureValueResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<GameVersionFeatureValueResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public GameVersionFeatureValueResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = GameVersionFeatureValueResult.newBuilder();
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

    public static Parser<GameVersionFeatureValueResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GameVersionFeatureValueResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GameVersionFeatureValueResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
