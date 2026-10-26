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
public final class PlatformLogoResult extends GeneratedMessage implements PlatformLogoResultOrBuilder {
    private static final PlatformLogoResult DEFAULT_INSTANCE;
    private static final Parser<PlatformLogoResult> PARSER;
    public static final int PLATFORMLOGOS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<PlatformLogo> platformlogos_;

    /* synthetic */ PlatformLogoResult(GeneratedMessage.Builder builder, PlatformLogoResultIA platformLogoResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PlatformLogoResult.class.getName());
        DEFAULT_INSTANCE = new PlatformLogoResult();
        PARSER = new AnonymousClass1();
    }

    private PlatformLogoResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private PlatformLogoResult() {
        this.platformlogos_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_PlatformLogoResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_PlatformLogoResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformLogoResult.class, Builder.class);
    }

    @Override // proto.PlatformLogoResultOrBuilder
    public List<PlatformLogo> getPlatformlogosList() {
        return this.platformlogos_;
    }

    @Override // proto.PlatformLogoResultOrBuilder
    public List<? extends PlatformLogoOrBuilder> getPlatformlogosOrBuilderList() {
        return this.platformlogos_;
    }

    @Override // proto.PlatformLogoResultOrBuilder
    public int getPlatformlogosCount() {
        return this.platformlogos_.size();
    }

    @Override // proto.PlatformLogoResultOrBuilder
    public PlatformLogo getPlatformlogos(int i) {
        return this.platformlogos_.get(i);
    }

    @Override // proto.PlatformLogoResultOrBuilder
    public PlatformLogoOrBuilder getPlatformlogosOrBuilder(int i) {
        return this.platformlogos_.get(i);
    }

    public static PlatformLogoResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PlatformLogoResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlatformLogoResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PlatformLogoResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PlatformLogoResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PlatformLogoResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PlatformLogoResult parseFrom(InputStream inputStream) throws IOException {
        return (PlatformLogoResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PlatformLogoResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformLogoResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformLogoResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PlatformLogoResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlatformLogoResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformLogoResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformLogoResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PlatformLogoResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlatformLogoResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformLogoResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(PlatformLogoResult platformLogoResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) platformLogoResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((PlatformLogoResultIA) null) : (Builder) new Builder((PlatformLogoResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlatformLogoResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> platformlogosBuilder_;
        private List<PlatformLogo> platformlogos_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, PlatformLogoResultIA platformLogoResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(PlatformLogoResultIA platformLogoResultIA) {
            this();
        }

        private void buildPartial0(PlatformLogoResult platformLogoResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_PlatformLogoResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_PlatformLogoResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformLogoResult.class, Builder.class);
        }

        private Builder() {
            this.platformlogos_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.platformlogos_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> repeatedFieldBuilder = this.platformlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                this.platformlogos_ = Collections.emptyList();
            } else {
                this.platformlogos_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_PlatformLogoResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlatformLogoResult getDefaultInstanceForType() {
            return PlatformLogoResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformLogoResult build() {
            PlatformLogoResult platformLogoResultBuildPartial = buildPartial();
            if (platformLogoResultBuildPartial.isInitialized()) {
                return platformLogoResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) platformLogoResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformLogoResult buildPartial() {
            PlatformLogoResult platformLogoResult = new PlatformLogoResult(this, null);
            buildPartialRepeatedFields(platformLogoResult);
            if (this.bitField0_ != 0) {
                buildPartial0(platformLogoResult);
            }
            onBuilt();
            return platformLogoResult;
        }

        private void buildPartialRepeatedFields(PlatformLogoResult platformLogoResult) {
            RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> repeatedFieldBuilder = this.platformlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.platformlogos_ = Collections.unmodifiableList(this.platformlogos_);
                    this.bitField0_ &= -2;
                }
                platformLogoResult.platformlogos_ = this.platformlogos_;
                return;
            }
            platformLogoResult.platformlogos_ = repeatedFieldBuilder.build();
        }

        private void ensurePlatformlogosIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.platformlogos_ = new ArrayList(this.platformlogos_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.PlatformLogoResultOrBuilder
        public List<PlatformLogo> getPlatformlogosList() {
            RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> repeatedFieldBuilder = this.platformlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.platformlogos_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.PlatformLogoResultOrBuilder
        public int getPlatformlogosCount() {
            RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> repeatedFieldBuilder = this.platformlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformlogos_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.PlatformLogoResultOrBuilder
        public PlatformLogo getPlatformlogos(int i) {
            RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> repeatedFieldBuilder = this.platformlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformlogos_.get(i);
            }
            return (PlatformLogo) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setPlatformlogos(int i, PlatformLogo platformLogo) {
            RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> repeatedFieldBuilder = this.platformlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                platformLogo.getClass();
                ensurePlatformlogosIsMutable();
                this.platformlogos_.set(i, platformLogo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, platformLogo);
            return this;
        }

        public Builder setPlatformlogos(int i, PlatformLogo.Builder builder) {
            RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> repeatedFieldBuilder = this.platformlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformlogosIsMutable();
                this.platformlogos_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addPlatformlogos(PlatformLogo platformLogo) {
            RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> repeatedFieldBuilder = this.platformlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                platformLogo.getClass();
                ensurePlatformlogosIsMutable();
                this.platformlogos_.add(platformLogo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(platformLogo);
            return this;
        }

        public Builder addPlatformlogos(int i, PlatformLogo platformLogo) {
            RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> repeatedFieldBuilder = this.platformlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                platformLogo.getClass();
                ensurePlatformlogosIsMutable();
                this.platformlogos_.add(i, platformLogo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, platformLogo);
            return this;
        }

        public Builder addPlatformlogos(PlatformLogo.Builder builder) {
            RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> repeatedFieldBuilder = this.platformlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformlogosIsMutable();
                this.platformlogos_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addPlatformlogos(int i, PlatformLogo.Builder builder) {
            RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> repeatedFieldBuilder = this.platformlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformlogosIsMutable();
                this.platformlogos_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllPlatformlogos(Iterable<? extends PlatformLogo> iterable) {
            RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> repeatedFieldBuilder = this.platformlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformlogosIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.platformlogos_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearPlatformlogos() {
            RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> repeatedFieldBuilder = this.platformlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                this.platformlogos_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removePlatformlogos(int i) {
            RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> repeatedFieldBuilder = this.platformlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformlogosIsMutable();
                this.platformlogos_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public PlatformLogo.Builder getPlatformlogosBuilder(int i) {
            return (PlatformLogo.Builder) getPlatformlogosFieldBuilder().getBuilder(i);
        }

        @Override // proto.PlatformLogoResultOrBuilder
        public PlatformLogoOrBuilder getPlatformlogosOrBuilder(int i) {
            RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> repeatedFieldBuilder = this.platformlogosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformlogos_.get(i);
            }
            return (PlatformLogoOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.PlatformLogoResultOrBuilder
        public List<? extends PlatformLogoOrBuilder> getPlatformlogosOrBuilderList() {
            RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> repeatedFieldBuilder = this.platformlogosBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.platformlogos_);
        }

        public PlatformLogo.Builder addPlatformlogosBuilder() {
            return (PlatformLogo.Builder) getPlatformlogosFieldBuilder().addBuilder(PlatformLogo.getDefaultInstance());
        }

        public PlatformLogo.Builder addPlatformlogosBuilder(int i) {
            return (PlatformLogo.Builder) getPlatformlogosFieldBuilder().addBuilder(i, PlatformLogo.getDefaultInstance());
        }

        public List<PlatformLogo.Builder> getPlatformlogosBuilderList() {
            return getPlatformlogosFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> getPlatformlogosFieldBuilder() {
            if (this.platformlogosBuilder_ == null) {
                this.platformlogosBuilder_ = new RepeatedFieldBuilder<>(this.platformlogos_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.platformlogos_ = null;
            }
            return this.platformlogosBuilder_;
        }
    }

    public static PlatformLogoResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.PlatformLogoResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<PlatformLogoResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public PlatformLogoResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = PlatformLogoResult.newBuilder();
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

    public static Parser<PlatformLogoResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PlatformLogoResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PlatformLogoResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
