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
public final class MultiplayerModeResult extends GeneratedMessage implements MultiplayerModeResultOrBuilder {
    private static final MultiplayerModeResult DEFAULT_INSTANCE;
    public static final int MULTIPLAYERMODES_FIELD_NUMBER = 1;
    private static final Parser<MultiplayerModeResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<MultiplayerMode> multiplayermodes_;

    /* synthetic */ MultiplayerModeResult(GeneratedMessage.Builder builder, MultiplayerModeResultIA multiplayerModeResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", MultiplayerModeResult.class.getName());
        DEFAULT_INSTANCE = new MultiplayerModeResult();
        PARSER = new AnonymousClass1();
    }

    private MultiplayerModeResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private MultiplayerModeResult() {
        this.multiplayermodes_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_MultiplayerModeResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_MultiplayerModeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiplayerModeResult.class, Builder.class);
    }

    @Override // proto.MultiplayerModeResultOrBuilder
    public List<MultiplayerMode> getMultiplayermodesList() {
        return this.multiplayermodes_;
    }

    @Override // proto.MultiplayerModeResultOrBuilder
    public List<? extends MultiplayerModeOrBuilder> getMultiplayermodesOrBuilderList() {
        return this.multiplayermodes_;
    }

    @Override // proto.MultiplayerModeResultOrBuilder
    public int getMultiplayermodesCount() {
        return this.multiplayermodes_.size();
    }

    @Override // proto.MultiplayerModeResultOrBuilder
    public MultiplayerMode getMultiplayermodes(int i) {
        return this.multiplayermodes_.get(i);
    }

    @Override // proto.MultiplayerModeResultOrBuilder
    public MultiplayerModeOrBuilder getMultiplayermodesOrBuilder(int i) {
        return this.multiplayermodes_.get(i);
    }

    public static MultiplayerModeResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static MultiplayerModeResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static MultiplayerModeResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static MultiplayerModeResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static MultiplayerModeResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static MultiplayerModeResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static MultiplayerModeResult parseFrom(InputStream inputStream) throws IOException {
        return (MultiplayerModeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static MultiplayerModeResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiplayerModeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MultiplayerModeResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MultiplayerModeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static MultiplayerModeResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiplayerModeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MultiplayerModeResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MultiplayerModeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static MultiplayerModeResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiplayerModeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(MultiplayerModeResult multiplayerModeResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) multiplayerModeResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((MultiplayerModeResultIA) null) : (Builder) new Builder((MultiplayerModeResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements MultiplayerModeResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> multiplayermodesBuilder_;
        private List<MultiplayerMode> multiplayermodes_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, MultiplayerModeResultIA multiplayerModeResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(MultiplayerModeResultIA multiplayerModeResultIA) {
            this();
        }

        private void buildPartial0(MultiplayerModeResult multiplayerModeResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_MultiplayerModeResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_MultiplayerModeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiplayerModeResult.class, Builder.class);
        }

        private Builder() {
            this.multiplayermodes_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.multiplayermodes_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayermodesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.multiplayermodes_ = Collections.emptyList();
            } else {
                this.multiplayermodes_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_MultiplayerModeResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MultiplayerModeResult getDefaultInstanceForType() {
            return MultiplayerModeResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MultiplayerModeResult build() {
            MultiplayerModeResult multiplayerModeResultBuildPartial = buildPartial();
            if (multiplayerModeResultBuildPartial.isInitialized()) {
                return multiplayerModeResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) multiplayerModeResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MultiplayerModeResult buildPartial() {
            MultiplayerModeResult multiplayerModeResult = new MultiplayerModeResult(this, null);
            buildPartialRepeatedFields(multiplayerModeResult);
            if (this.bitField0_ != 0) {
                buildPartial0(multiplayerModeResult);
            }
            onBuilt();
            return multiplayerModeResult;
        }

        private void buildPartialRepeatedFields(MultiplayerModeResult multiplayerModeResult) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayermodesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.multiplayermodes_ = Collections.unmodifiableList(this.multiplayermodes_);
                    this.bitField0_ &= -2;
                }
                multiplayerModeResult.multiplayermodes_ = this.multiplayermodes_;
                return;
            }
            multiplayerModeResult.multiplayermodes_ = repeatedFieldBuilder.build();
        }

        private void ensureMultiplayermodesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.multiplayermodes_ = new ArrayList(this.multiplayermodes_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.MultiplayerModeResultOrBuilder
        public List<MultiplayerMode> getMultiplayermodesList() {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayermodesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.multiplayermodes_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.MultiplayerModeResultOrBuilder
        public int getMultiplayermodesCount() {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayermodesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.multiplayermodes_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.MultiplayerModeResultOrBuilder
        public MultiplayerMode getMultiplayermodes(int i) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayermodesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.multiplayermodes_.get(i);
            }
            return (MultiplayerMode) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setMultiplayermodes(int i, MultiplayerMode multiplayerMode) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayermodesBuilder_;
            if (repeatedFieldBuilder == null) {
                multiplayerMode.getClass();
                ensureMultiplayermodesIsMutable();
                this.multiplayermodes_.set(i, multiplayerMode);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, multiplayerMode);
            return this;
        }

        public Builder setMultiplayermodes(int i, MultiplayerMode.Builder builder) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayermodesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMultiplayermodesIsMutable();
                this.multiplayermodes_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addMultiplayermodes(MultiplayerMode multiplayerMode) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayermodesBuilder_;
            if (repeatedFieldBuilder == null) {
                multiplayerMode.getClass();
                ensureMultiplayermodesIsMutable();
                this.multiplayermodes_.add(multiplayerMode);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(multiplayerMode);
            return this;
        }

        public Builder addMultiplayermodes(int i, MultiplayerMode multiplayerMode) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayermodesBuilder_;
            if (repeatedFieldBuilder == null) {
                multiplayerMode.getClass();
                ensureMultiplayermodesIsMutable();
                this.multiplayermodes_.add(i, multiplayerMode);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, multiplayerMode);
            return this;
        }

        public Builder addMultiplayermodes(MultiplayerMode.Builder builder) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayermodesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMultiplayermodesIsMutable();
                this.multiplayermodes_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addMultiplayermodes(int i, MultiplayerMode.Builder builder) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayermodesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMultiplayermodesIsMutable();
                this.multiplayermodes_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllMultiplayermodes(Iterable<? extends MultiplayerMode> iterable) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayermodesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMultiplayermodesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.multiplayermodes_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearMultiplayermodes() {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayermodesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.multiplayermodes_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeMultiplayermodes(int i) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayermodesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMultiplayermodesIsMutable();
                this.multiplayermodes_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public MultiplayerMode.Builder getMultiplayermodesBuilder(int i) {
            return (MultiplayerMode.Builder) getMultiplayermodesFieldBuilder().getBuilder(i);
        }

        @Override // proto.MultiplayerModeResultOrBuilder
        public MultiplayerModeOrBuilder getMultiplayermodesOrBuilder(int i) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayermodesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.multiplayermodes_.get(i);
            }
            return (MultiplayerModeOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.MultiplayerModeResultOrBuilder
        public List<? extends MultiplayerModeOrBuilder> getMultiplayermodesOrBuilderList() {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayermodesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.multiplayermodes_);
        }

        public MultiplayerMode.Builder addMultiplayermodesBuilder() {
            return (MultiplayerMode.Builder) getMultiplayermodesFieldBuilder().addBuilder(MultiplayerMode.getDefaultInstance());
        }

        public MultiplayerMode.Builder addMultiplayermodesBuilder(int i) {
            return (MultiplayerMode.Builder) getMultiplayermodesFieldBuilder().addBuilder(i, MultiplayerMode.getDefaultInstance());
        }

        public List<MultiplayerMode.Builder> getMultiplayermodesBuilderList() {
            return getMultiplayermodesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> getMultiplayermodesFieldBuilder() {
            if (this.multiplayermodesBuilder_ == null) {
                this.multiplayermodesBuilder_ = new RepeatedFieldBuilder<>(this.multiplayermodes_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.multiplayermodes_ = null;
            }
            return this.multiplayermodesBuilder_;
        }
    }

    public static MultiplayerModeResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.MultiplayerModeResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<MultiplayerModeResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public MultiplayerModeResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = MultiplayerModeResult.newBuilder();
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

    public static Parser<MultiplayerModeResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<MultiplayerModeResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public MultiplayerModeResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
