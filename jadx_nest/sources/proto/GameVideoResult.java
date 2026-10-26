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
public final class GameVideoResult extends GeneratedMessage implements GameVideoResultOrBuilder {
    private static final GameVideoResult DEFAULT_INSTANCE;
    public static final int GAMEVIDEOS_FIELD_NUMBER = 1;
    private static final Parser<GameVideoResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<GameVideo> gamevideos_;

    /* synthetic */ GameVideoResult(GeneratedMessage.Builder builder, GameVideoResultIA gameVideoResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameVideoResult.class.getName());
        DEFAULT_INSTANCE = new GameVideoResult();
        PARSER = new AnonymousClass1();
    }

    private GameVideoResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private GameVideoResult() {
        this.gamevideos_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_GameVideoResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_GameVideoResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameVideoResult.class, Builder.class);
    }

    @Override // proto.GameVideoResultOrBuilder
    public List<GameVideo> getGamevideosList() {
        return this.gamevideos_;
    }

    @Override // proto.GameVideoResultOrBuilder
    public List<? extends GameVideoOrBuilder> getGamevideosOrBuilderList() {
        return this.gamevideos_;
    }

    @Override // proto.GameVideoResultOrBuilder
    public int getGamevideosCount() {
        return this.gamevideos_.size();
    }

    @Override // proto.GameVideoResultOrBuilder
    public GameVideo getGamevideos(int i) {
        return this.gamevideos_.get(i);
    }

    @Override // proto.GameVideoResultOrBuilder
    public GameVideoOrBuilder getGamevideosOrBuilder(int i) {
        return this.gamevideos_.get(i);
    }

    public static GameVideoResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GameVideoResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GameVideoResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GameVideoResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GameVideoResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GameVideoResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GameVideoResult parseFrom(InputStream inputStream) throws IOException {
        return (GameVideoResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static GameVideoResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVideoResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameVideoResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GameVideoResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GameVideoResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVideoResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameVideoResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GameVideoResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GameVideoResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVideoResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GameVideoResult gameVideoResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) gameVideoResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((GameVideoResultIA) null) : (Builder) new Builder((GameVideoResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameVideoResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> gamevideosBuilder_;
        private List<GameVideo> gamevideos_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, GameVideoResultIA gameVideoResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(GameVideoResultIA gameVideoResultIA) {
            this();
        }

        private void buildPartial0(GameVideoResult gameVideoResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_GameVideoResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_GameVideoResult_fieldAccessorTable.ensureFieldAccessorsInitialized(GameVideoResult.class, Builder.class);
        }

        private Builder() {
            this.gamevideos_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.gamevideos_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.gamevideosBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gamevideos_ = Collections.emptyList();
            } else {
                this.gamevideos_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_GameVideoResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameVideoResult getDefaultInstanceForType() {
            return GameVideoResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameVideoResult build() {
            GameVideoResult gameVideoResultBuildPartial = buildPartial();
            if (gameVideoResultBuildPartial.isInitialized()) {
                return gameVideoResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) gameVideoResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameVideoResult buildPartial() {
            GameVideoResult gameVideoResult = new GameVideoResult(this, null);
            buildPartialRepeatedFields(gameVideoResult);
            if (this.bitField0_ != 0) {
                buildPartial0(gameVideoResult);
            }
            onBuilt();
            return gameVideoResult;
        }

        private void buildPartialRepeatedFields(GameVideoResult gameVideoResult) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.gamevideosBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.gamevideos_ = Collections.unmodifiableList(this.gamevideos_);
                    this.bitField0_ &= -2;
                }
                gameVideoResult.gamevideos_ = this.gamevideos_;
                return;
            }
            gameVideoResult.gamevideos_ = repeatedFieldBuilder.build();
        }

        private void ensureGamevideosIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.gamevideos_ = new ArrayList(this.gamevideos_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.GameVideoResultOrBuilder
        public List<GameVideo> getGamevideosList() {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.gamevideosBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.gamevideos_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameVideoResultOrBuilder
        public int getGamevideosCount() {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.gamevideosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gamevideos_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameVideoResultOrBuilder
        public GameVideo getGamevideos(int i) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.gamevideosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gamevideos_.get(i);
            }
            return (GameVideo) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setGamevideos(int i, GameVideo gameVideo) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.gamevideosBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVideo.getClass();
                ensureGamevideosIsMutable();
                this.gamevideos_.set(i, gameVideo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, gameVideo);
            return this;
        }

        public Builder setGamevideos(int i, GameVideo.Builder builder) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.gamevideosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamevideosIsMutable();
                this.gamevideos_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addGamevideos(GameVideo gameVideo) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.gamevideosBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVideo.getClass();
                ensureGamevideosIsMutable();
                this.gamevideos_.add(gameVideo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(gameVideo);
            return this;
        }

        public Builder addGamevideos(int i, GameVideo gameVideo) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.gamevideosBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVideo.getClass();
                ensureGamevideosIsMutable();
                this.gamevideos_.add(i, gameVideo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, gameVideo);
            return this;
        }

        public Builder addGamevideos(GameVideo.Builder builder) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.gamevideosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamevideosIsMutable();
                this.gamevideos_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addGamevideos(int i, GameVideo.Builder builder) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.gamevideosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamevideosIsMutable();
                this.gamevideos_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllGamevideos(Iterable<? extends GameVideo> iterable) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.gamevideosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamevideosIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.gamevideos_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearGamevideos() {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.gamevideosBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gamevideos_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeGamevideos(int i) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.gamevideosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamevideosIsMutable();
                this.gamevideos_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public GameVideo.Builder getGamevideosBuilder(int i) {
            return (GameVideo.Builder) getGamevideosFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameVideoResultOrBuilder
        public GameVideoOrBuilder getGamevideosOrBuilder(int i) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.gamevideosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gamevideos_.get(i);
            }
            return (GameVideoOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameVideoResultOrBuilder
        public List<? extends GameVideoOrBuilder> getGamevideosOrBuilderList() {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.gamevideosBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.gamevideos_);
        }

        public GameVideo.Builder addGamevideosBuilder() {
            return (GameVideo.Builder) getGamevideosFieldBuilder().addBuilder(GameVideo.getDefaultInstance());
        }

        public GameVideo.Builder addGamevideosBuilder(int i) {
            return (GameVideo.Builder) getGamevideosFieldBuilder().addBuilder(i, GameVideo.getDefaultInstance());
        }

        public List<GameVideo.Builder> getGamevideosBuilderList() {
            return getGamevideosFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> getGamevideosFieldBuilder() {
            if (this.gamevideosBuilder_ == null) {
                this.gamevideosBuilder_ = new RepeatedFieldBuilder<>(this.gamevideos_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.gamevideos_ = null;
            }
            return this.gamevideosBuilder_;
        }
    }

    public static GameVideoResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.GameVideoResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<GameVideoResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public GameVideoResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = GameVideoResult.newBuilder();
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

    public static Parser<GameVideoResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GameVideoResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GameVideoResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
