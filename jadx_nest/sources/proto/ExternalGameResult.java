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
public final class ExternalGameResult extends GeneratedMessage implements ExternalGameResultOrBuilder {
    private static final ExternalGameResult DEFAULT_INSTANCE;
    public static final int EXTERNALGAMES_FIELD_NUMBER = 1;
    private static final Parser<ExternalGameResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<ExternalGame> externalgames_;

    /* synthetic */ ExternalGameResult(GeneratedMessage.Builder builder, ExternalGameResultIA externalGameResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", ExternalGameResult.class.getName());
        DEFAULT_INSTANCE = new ExternalGameResult();
        PARSER = new AnonymousClass1();
    }

    private ExternalGameResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private ExternalGameResult() {
        this.externalgames_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_ExternalGameResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_ExternalGameResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ExternalGameResult.class, Builder.class);
    }

    @Override // proto.ExternalGameResultOrBuilder
    public List<ExternalGame> getExternalgamesList() {
        return this.externalgames_;
    }

    @Override // proto.ExternalGameResultOrBuilder
    public List<? extends ExternalGameOrBuilder> getExternalgamesOrBuilderList() {
        return this.externalgames_;
    }

    @Override // proto.ExternalGameResultOrBuilder
    public int getExternalgamesCount() {
        return this.externalgames_.size();
    }

    @Override // proto.ExternalGameResultOrBuilder
    public ExternalGame getExternalgames(int i) {
        return this.externalgames_.get(i);
    }

    @Override // proto.ExternalGameResultOrBuilder
    public ExternalGameOrBuilder getExternalgamesOrBuilder(int i) {
        return this.externalgames_.get(i);
    }

    public static ExternalGameResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ExternalGameResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ExternalGameResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ExternalGameResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ExternalGameResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ExternalGameResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ExternalGameResult parseFrom(InputStream inputStream) throws IOException {
        return (ExternalGameResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static ExternalGameResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExternalGameResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ExternalGameResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ExternalGameResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ExternalGameResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExternalGameResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ExternalGameResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ExternalGameResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static ExternalGameResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExternalGameResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(ExternalGameResult externalGameResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) externalGameResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((ExternalGameResultIA) null) : (Builder) new Builder((ExternalGameResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ExternalGameResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> externalgamesBuilder_;
        private List<ExternalGame> externalgames_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, ExternalGameResultIA externalGameResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(ExternalGameResultIA externalGameResultIA) {
            this();
        }

        private void buildPartial0(ExternalGameResult externalGameResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_ExternalGameResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_ExternalGameResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ExternalGameResult.class, Builder.class);
        }

        private Builder() {
            this.externalgames_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.externalgames_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalgamesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.externalgames_ = Collections.emptyList();
            } else {
                this.externalgames_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_ExternalGameResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ExternalGameResult getDefaultInstanceForType() {
            return ExternalGameResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ExternalGameResult build() {
            ExternalGameResult externalGameResultBuildPartial = buildPartial();
            if (externalGameResultBuildPartial.isInitialized()) {
                return externalGameResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) externalGameResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ExternalGameResult buildPartial() {
            ExternalGameResult externalGameResult = new ExternalGameResult(this, null);
            buildPartialRepeatedFields(externalGameResult);
            if (this.bitField0_ != 0) {
                buildPartial0(externalGameResult);
            }
            onBuilt();
            return externalGameResult;
        }

        private void buildPartialRepeatedFields(ExternalGameResult externalGameResult) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalgamesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.externalgames_ = Collections.unmodifiableList(this.externalgames_);
                    this.bitField0_ &= -2;
                }
                externalGameResult.externalgames_ = this.externalgames_;
                return;
            }
            externalGameResult.externalgames_ = repeatedFieldBuilder.build();
        }

        private void ensureExternalgamesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.externalgames_ = new ArrayList(this.externalgames_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.ExternalGameResultOrBuilder
        public List<ExternalGame> getExternalgamesList() {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalgamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.externalgames_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.ExternalGameResultOrBuilder
        public int getExternalgamesCount() {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalgamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.externalgames_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.ExternalGameResultOrBuilder
        public ExternalGame getExternalgames(int i) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalgamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.externalgames_.get(i);
            }
            return (ExternalGame) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setExternalgames(int i, ExternalGame externalGame) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalgamesBuilder_;
            if (repeatedFieldBuilder == null) {
                externalGame.getClass();
                ensureExternalgamesIsMutable();
                this.externalgames_.set(i, externalGame);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, externalGame);
            return this;
        }

        public Builder setExternalgames(int i, ExternalGame.Builder builder) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalgamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExternalgamesIsMutable();
                this.externalgames_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addExternalgames(ExternalGame externalGame) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalgamesBuilder_;
            if (repeatedFieldBuilder == null) {
                externalGame.getClass();
                ensureExternalgamesIsMutable();
                this.externalgames_.add(externalGame);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(externalGame);
            return this;
        }

        public Builder addExternalgames(int i, ExternalGame externalGame) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalgamesBuilder_;
            if (repeatedFieldBuilder == null) {
                externalGame.getClass();
                ensureExternalgamesIsMutable();
                this.externalgames_.add(i, externalGame);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, externalGame);
            return this;
        }

        public Builder addExternalgames(ExternalGame.Builder builder) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalgamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExternalgamesIsMutable();
                this.externalgames_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addExternalgames(int i, ExternalGame.Builder builder) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalgamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExternalgamesIsMutable();
                this.externalgames_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllExternalgames(Iterable<? extends ExternalGame> iterable) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalgamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExternalgamesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.externalgames_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearExternalgames() {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalgamesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.externalgames_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeExternalgames(int i) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalgamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExternalgamesIsMutable();
                this.externalgames_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public ExternalGame.Builder getExternalgamesBuilder(int i) {
            return (ExternalGame.Builder) getExternalgamesFieldBuilder().getBuilder(i);
        }

        @Override // proto.ExternalGameResultOrBuilder
        public ExternalGameOrBuilder getExternalgamesOrBuilder(int i) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalgamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.externalgames_.get(i);
            }
            return (ExternalGameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.ExternalGameResultOrBuilder
        public List<? extends ExternalGameOrBuilder> getExternalgamesOrBuilderList() {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalgamesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.externalgames_);
        }

        public ExternalGame.Builder addExternalgamesBuilder() {
            return (ExternalGame.Builder) getExternalgamesFieldBuilder().addBuilder(ExternalGame.getDefaultInstance());
        }

        public ExternalGame.Builder addExternalgamesBuilder(int i) {
            return (ExternalGame.Builder) getExternalgamesFieldBuilder().addBuilder(i, ExternalGame.getDefaultInstance());
        }

        public List<ExternalGame.Builder> getExternalgamesBuilderList() {
            return getExternalgamesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> getExternalgamesFieldBuilder() {
            if (this.externalgamesBuilder_ == null) {
                this.externalgamesBuilder_ = new RepeatedFieldBuilder<>(this.externalgames_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.externalgames_ = null;
            }
            return this.externalgamesBuilder_;
        }
    }

    public static ExternalGameResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.ExternalGameResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<ExternalGameResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public ExternalGameResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = ExternalGameResult.newBuilder();
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

    public static Parser<ExternalGameResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ExternalGameResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ExternalGameResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
