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
public final class GameVersionFeatureResult extends GeneratedMessage implements GameVersionFeatureResultOrBuilder {
    private static final GameVersionFeatureResult DEFAULT_INSTANCE;
    public static final int GAMEVERSIONFEATURES_FIELD_NUMBER = 1;
    private static final Parser<GameVersionFeatureResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<GameVersionFeature> gameversionfeatures_;

    /* synthetic */ GameVersionFeatureResult(GeneratedMessage.Builder builder, GameVersionFeatureResultIA gameVersionFeatureResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameVersionFeatureResult.class.getName());
        DEFAULT_INSTANCE = new GameVersionFeatureResult();
        PARSER = new AnonymousClass1();
    }

    private GameVersionFeatureResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private GameVersionFeatureResult() {
        this.gameversionfeatures_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_GameVersionFeatureResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_GameVersionFeatureResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameVersionFeatureResult.class, Builder.class);
    }

    @Override // proto.GameVersionFeatureResultOrBuilder
    public List<GameVersionFeature> getGameversionfeaturesList() {
        return this.gameversionfeatures_;
    }

    @Override // proto.GameVersionFeatureResultOrBuilder
    public List<? extends GameVersionFeatureOrBuilder> getGameversionfeaturesOrBuilderList() {
        return this.gameversionfeatures_;
    }

    @Override // proto.GameVersionFeatureResultOrBuilder
    public int getGameversionfeaturesCount() {
        return this.gameversionfeatures_.size();
    }

    @Override // proto.GameVersionFeatureResultOrBuilder
    public GameVersionFeature getGameversionfeatures(int i) {
        return this.gameversionfeatures_.get(i);
    }

    @Override // proto.GameVersionFeatureResultOrBuilder
    public GameVersionFeatureOrBuilder getGameversionfeaturesOrBuilder(int i) {
        return this.gameversionfeatures_.get(i);
    }

    public static GameVersionFeatureResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GameVersionFeatureResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GameVersionFeatureResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GameVersionFeatureResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GameVersionFeatureResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GameVersionFeatureResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GameVersionFeatureResult parseFrom(InputStream inputStream) throws IOException {
        return (GameVersionFeatureResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static GameVersionFeatureResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersionFeatureResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameVersionFeatureResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GameVersionFeatureResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GameVersionFeatureResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersionFeatureResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameVersionFeatureResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GameVersionFeatureResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GameVersionFeatureResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersionFeatureResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GameVersionFeatureResult gameVersionFeatureResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) gameVersionFeatureResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((GameVersionFeatureResultIA) null) : (Builder) new Builder((GameVersionFeatureResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameVersionFeatureResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> gameversionfeaturesBuilder_;
        private List<GameVersionFeature> gameversionfeatures_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, GameVersionFeatureResultIA gameVersionFeatureResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(GameVersionFeatureResultIA gameVersionFeatureResultIA) {
            this();
        }

        private void buildPartial0(GameVersionFeatureResult gameVersionFeatureResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_GameVersionFeatureResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_GameVersionFeatureResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameVersionFeatureResult.class, Builder.class);
        }

        private Builder() {
            this.gameversionfeatures_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.gameversionfeatures_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.gameversionfeaturesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gameversionfeatures_ = Collections.emptyList();
            } else {
                this.gameversionfeatures_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_GameVersionFeatureResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameVersionFeatureResult getDefaultInstanceForType() {
            return GameVersionFeatureResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameVersionFeatureResult build() {
            GameVersionFeatureResult gameVersionFeatureResultBuildPartial = buildPartial();
            if (gameVersionFeatureResultBuildPartial.isInitialized()) {
                return gameVersionFeatureResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) gameVersionFeatureResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameVersionFeatureResult buildPartial() {
            GameVersionFeatureResult gameVersionFeatureResult = new GameVersionFeatureResult(this, null);
            buildPartialRepeatedFields(gameVersionFeatureResult);
            if (this.bitField0_ != 0) {
                buildPartial0(gameVersionFeatureResult);
            }
            onBuilt();
            return gameVersionFeatureResult;
        }

        private void buildPartialRepeatedFields(GameVersionFeatureResult gameVersionFeatureResult) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.gameversionfeaturesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.gameversionfeatures_ = Collections.unmodifiableList(this.gameversionfeatures_);
                    this.bitField0_ &= -2;
                }
                gameVersionFeatureResult.gameversionfeatures_ = this.gameversionfeatures_;
                return;
            }
            gameVersionFeatureResult.gameversionfeatures_ = repeatedFieldBuilder.build();
        }

        private void ensureGameversionfeaturesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.gameversionfeatures_ = new ArrayList(this.gameversionfeatures_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.GameVersionFeatureResultOrBuilder
        public List<GameVersionFeature> getGameversionfeaturesList() {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.gameversionfeaturesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.gameversionfeatures_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameVersionFeatureResultOrBuilder
        public int getGameversionfeaturesCount() {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.gameversionfeaturesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameversionfeatures_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameVersionFeatureResultOrBuilder
        public GameVersionFeature getGameversionfeatures(int i) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.gameversionfeaturesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameversionfeatures_.get(i);
            }
            return (GameVersionFeature) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setGameversionfeatures(int i, GameVersionFeature gameVersionFeature) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.gameversionfeaturesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVersionFeature.getClass();
                ensureGameversionfeaturesIsMutable();
                this.gameversionfeatures_.set(i, gameVersionFeature);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, gameVersionFeature);
            return this;
        }

        public Builder setGameversionfeatures(int i, GameVersionFeature.Builder builder) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.gameversionfeaturesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameversionfeaturesIsMutable();
                this.gameversionfeatures_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addGameversionfeatures(GameVersionFeature gameVersionFeature) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.gameversionfeaturesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVersionFeature.getClass();
                ensureGameversionfeaturesIsMutable();
                this.gameversionfeatures_.add(gameVersionFeature);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(gameVersionFeature);
            return this;
        }

        public Builder addGameversionfeatures(int i, GameVersionFeature gameVersionFeature) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.gameversionfeaturesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVersionFeature.getClass();
                ensureGameversionfeaturesIsMutable();
                this.gameversionfeatures_.add(i, gameVersionFeature);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, gameVersionFeature);
            return this;
        }

        public Builder addGameversionfeatures(GameVersionFeature.Builder builder) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.gameversionfeaturesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameversionfeaturesIsMutable();
                this.gameversionfeatures_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addGameversionfeatures(int i, GameVersionFeature.Builder builder) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.gameversionfeaturesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameversionfeaturesIsMutable();
                this.gameversionfeatures_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllGameversionfeatures(Iterable<? extends GameVersionFeature> iterable) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.gameversionfeaturesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameversionfeaturesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.gameversionfeatures_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearGameversionfeatures() {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.gameversionfeaturesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gameversionfeatures_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeGameversionfeatures(int i) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.gameversionfeaturesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameversionfeaturesIsMutable();
                this.gameversionfeatures_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public GameVersionFeature.Builder getGameversionfeaturesBuilder(int i) {
            return (GameVersionFeature.Builder) getGameversionfeaturesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameVersionFeatureResultOrBuilder
        public GameVersionFeatureOrBuilder getGameversionfeaturesOrBuilder(int i) {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.gameversionfeaturesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameversionfeatures_.get(i);
            }
            return (GameVersionFeatureOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameVersionFeatureResultOrBuilder
        public List<? extends GameVersionFeatureOrBuilder> getGameversionfeaturesOrBuilderList() {
            RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> repeatedFieldBuilder = this.gameversionfeaturesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.gameversionfeatures_);
        }

        public GameVersionFeature.Builder addGameversionfeaturesBuilder() {
            return (GameVersionFeature.Builder) getGameversionfeaturesFieldBuilder().addBuilder(GameVersionFeature.getDefaultInstance());
        }

        public GameVersionFeature.Builder addGameversionfeaturesBuilder(int i) {
            return (GameVersionFeature.Builder) getGameversionfeaturesFieldBuilder().addBuilder(i, GameVersionFeature.getDefaultInstance());
        }

        public List<GameVersionFeature.Builder> getGameversionfeaturesBuilderList() {
            return getGameversionfeaturesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<GameVersionFeature, GameVersionFeature.Builder, GameVersionFeatureOrBuilder> getGameversionfeaturesFieldBuilder() {
            if (this.gameversionfeaturesBuilder_ == null) {
                this.gameversionfeaturesBuilder_ = new RepeatedFieldBuilder<>(this.gameversionfeatures_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.gameversionfeatures_ = null;
            }
            return this.gameversionfeaturesBuilder_;
        }
    }

    public static GameVersionFeatureResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.GameVersionFeatureResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<GameVersionFeatureResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public GameVersionFeatureResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = GameVersionFeatureResult.newBuilder();
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

    public static Parser<GameVersionFeatureResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GameVersionFeatureResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GameVersionFeatureResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
