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
public final class PlayerPerspectiveResult extends GeneratedMessage implements PlayerPerspectiveResultOrBuilder {
    private static final PlayerPerspectiveResult DEFAULT_INSTANCE;
    private static final Parser<PlayerPerspectiveResult> PARSER;
    public static final int PLAYERPERSPECTIVES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<PlayerPerspective> playerperspectives_;

    /* synthetic */ PlayerPerspectiveResult(GeneratedMessage.Builder builder, PlayerPerspectiveResultIA playerPerspectiveResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PlayerPerspectiveResult.class.getName());
        DEFAULT_INSTANCE = new PlayerPerspectiveResult();
        PARSER = new AnonymousClass1();
    }

    private PlayerPerspectiveResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private PlayerPerspectiveResult() {
        this.playerperspectives_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_PlayerPerspectiveResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_PlayerPerspectiveResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerPerspectiveResult.class, Builder.class);
    }

    @Override // proto.PlayerPerspectiveResultOrBuilder
    public List<PlayerPerspective> getPlayerperspectivesList() {
        return this.playerperspectives_;
    }

    @Override // proto.PlayerPerspectiveResultOrBuilder
    public List<? extends PlayerPerspectiveOrBuilder> getPlayerperspectivesOrBuilderList() {
        return this.playerperspectives_;
    }

    @Override // proto.PlayerPerspectiveResultOrBuilder
    public int getPlayerperspectivesCount() {
        return this.playerperspectives_.size();
    }

    @Override // proto.PlayerPerspectiveResultOrBuilder
    public PlayerPerspective getPlayerperspectives(int i) {
        return this.playerperspectives_.get(i);
    }

    @Override // proto.PlayerPerspectiveResultOrBuilder
    public PlayerPerspectiveOrBuilder getPlayerperspectivesOrBuilder(int i) {
        return this.playerperspectives_.get(i);
    }

    public static PlayerPerspectiveResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PlayerPerspectiveResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlayerPerspectiveResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PlayerPerspectiveResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PlayerPerspectiveResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PlayerPerspectiveResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PlayerPerspectiveResult parseFrom(InputStream inputStream) throws IOException {
        return (PlayerPerspectiveResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PlayerPerspectiveResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlayerPerspectiveResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlayerPerspectiveResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PlayerPerspectiveResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlayerPerspectiveResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlayerPerspectiveResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlayerPerspectiveResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PlayerPerspectiveResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlayerPerspectiveResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlayerPerspectiveResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(PlayerPerspectiveResult playerPerspectiveResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) playerPerspectiveResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((PlayerPerspectiveResultIA) null) : (Builder) new Builder((PlayerPerspectiveResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlayerPerspectiveResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> playerperspectivesBuilder_;
        private List<PlayerPerspective> playerperspectives_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, PlayerPerspectiveResultIA playerPerspectiveResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(PlayerPerspectiveResultIA playerPerspectiveResultIA) {
            this();
        }

        private void buildPartial0(PlayerPerspectiveResult playerPerspectiveResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_PlayerPerspectiveResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_PlayerPerspectiveResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PlayerPerspectiveResult.class, Builder.class);
        }

        private Builder() {
            this.playerperspectives_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.playerperspectives_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerperspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.playerperspectives_ = Collections.emptyList();
            } else {
                this.playerperspectives_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_PlayerPerspectiveResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlayerPerspectiveResult getDefaultInstanceForType() {
            return PlayerPerspectiveResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlayerPerspectiveResult build() {
            PlayerPerspectiveResult playerPerspectiveResultBuildPartial = buildPartial();
            if (playerPerspectiveResultBuildPartial.isInitialized()) {
                return playerPerspectiveResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) playerPerspectiveResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlayerPerspectiveResult buildPartial() {
            PlayerPerspectiveResult playerPerspectiveResult = new PlayerPerspectiveResult(this, null);
            buildPartialRepeatedFields(playerPerspectiveResult);
            if (this.bitField0_ != 0) {
                buildPartial0(playerPerspectiveResult);
            }
            onBuilt();
            return playerPerspectiveResult;
        }

        private void buildPartialRepeatedFields(PlayerPerspectiveResult playerPerspectiveResult) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerperspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.playerperspectives_ = Collections.unmodifiableList(this.playerperspectives_);
                    this.bitField0_ &= -2;
                }
                playerPerspectiveResult.playerperspectives_ = this.playerperspectives_;
                return;
            }
            playerPerspectiveResult.playerperspectives_ = repeatedFieldBuilder.build();
        }

        private void ensurePlayerperspectivesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.playerperspectives_ = new ArrayList(this.playerperspectives_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.PlayerPerspectiveResultOrBuilder
        public List<PlayerPerspective> getPlayerperspectivesList() {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerperspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.playerperspectives_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.PlayerPerspectiveResultOrBuilder
        public int getPlayerperspectivesCount() {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerperspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.playerperspectives_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.PlayerPerspectiveResultOrBuilder
        public PlayerPerspective getPlayerperspectives(int i) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerperspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.playerperspectives_.get(i);
            }
            return (PlayerPerspective) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setPlayerperspectives(int i, PlayerPerspective playerPerspective) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerperspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                playerPerspective.getClass();
                ensurePlayerperspectivesIsMutable();
                this.playerperspectives_.set(i, playerPerspective);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, playerPerspective);
            return this;
        }

        public Builder setPlayerperspectives(int i, PlayerPerspective.Builder builder) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerperspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlayerperspectivesIsMutable();
                this.playerperspectives_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addPlayerperspectives(PlayerPerspective playerPerspective) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerperspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                playerPerspective.getClass();
                ensurePlayerperspectivesIsMutable();
                this.playerperspectives_.add(playerPerspective);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(playerPerspective);
            return this;
        }

        public Builder addPlayerperspectives(int i, PlayerPerspective playerPerspective) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerperspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                playerPerspective.getClass();
                ensurePlayerperspectivesIsMutable();
                this.playerperspectives_.add(i, playerPerspective);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, playerPerspective);
            return this;
        }

        public Builder addPlayerperspectives(PlayerPerspective.Builder builder) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerperspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlayerperspectivesIsMutable();
                this.playerperspectives_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addPlayerperspectives(int i, PlayerPerspective.Builder builder) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerperspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlayerperspectivesIsMutable();
                this.playerperspectives_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllPlayerperspectives(Iterable<? extends PlayerPerspective> iterable) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerperspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlayerperspectivesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.playerperspectives_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearPlayerperspectives() {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerperspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.playerperspectives_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removePlayerperspectives(int i) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerperspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlayerperspectivesIsMutable();
                this.playerperspectives_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public PlayerPerspective.Builder getPlayerperspectivesBuilder(int i) {
            return (PlayerPerspective.Builder) getPlayerperspectivesFieldBuilder().getBuilder(i);
        }

        @Override // proto.PlayerPerspectiveResultOrBuilder
        public PlayerPerspectiveOrBuilder getPlayerperspectivesOrBuilder(int i) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerperspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.playerperspectives_.get(i);
            }
            return (PlayerPerspectiveOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.PlayerPerspectiveResultOrBuilder
        public List<? extends PlayerPerspectiveOrBuilder> getPlayerperspectivesOrBuilderList() {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerperspectivesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.playerperspectives_);
        }

        public PlayerPerspective.Builder addPlayerperspectivesBuilder() {
            return (PlayerPerspective.Builder) getPlayerperspectivesFieldBuilder().addBuilder(PlayerPerspective.getDefaultInstance());
        }

        public PlayerPerspective.Builder addPlayerperspectivesBuilder(int i) {
            return (PlayerPerspective.Builder) getPlayerperspectivesFieldBuilder().addBuilder(i, PlayerPerspective.getDefaultInstance());
        }

        public List<PlayerPerspective.Builder> getPlayerperspectivesBuilderList() {
            return getPlayerperspectivesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> getPlayerperspectivesFieldBuilder() {
            if (this.playerperspectivesBuilder_ == null) {
                this.playerperspectivesBuilder_ = new RepeatedFieldBuilder<>(this.playerperspectives_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.playerperspectives_ = null;
            }
            return this.playerperspectivesBuilder_;
        }
    }

    public static PlayerPerspectiveResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.PlayerPerspectiveResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<PlayerPerspectiveResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public PlayerPerspectiveResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = PlayerPerspectiveResult.newBuilder();
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

    public static Parser<PlayerPerspectiveResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PlayerPerspectiveResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PlayerPerspectiveResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
