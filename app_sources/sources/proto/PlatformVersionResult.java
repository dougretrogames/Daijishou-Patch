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
public final class PlatformVersionResult extends GeneratedMessage implements PlatformVersionResultOrBuilder {
    private static final PlatformVersionResult DEFAULT_INSTANCE;
    private static final Parser<PlatformVersionResult> PARSER;
    public static final int PLATFORMVERSIONS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<PlatformVersion> platformversions_;

    /* synthetic */ PlatformVersionResult(GeneratedMessage.Builder builder, PlatformVersionResultIA platformVersionResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PlatformVersionResult.class.getName());
        DEFAULT_INSTANCE = new PlatformVersionResult();
        PARSER = new AnonymousClass1();
    }

    private PlatformVersionResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private PlatformVersionResult() {
        this.platformversions_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_PlatformVersionResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_PlatformVersionResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformVersionResult.class, Builder.class);
    }

    @Override // proto.PlatformVersionResultOrBuilder
    public List<PlatformVersion> getPlatformversionsList() {
        return this.platformversions_;
    }

    @Override // proto.PlatformVersionResultOrBuilder
    public List<? extends PlatformVersionOrBuilder> getPlatformversionsOrBuilderList() {
        return this.platformversions_;
    }

    @Override // proto.PlatformVersionResultOrBuilder
    public int getPlatformversionsCount() {
        return this.platformversions_.size();
    }

    @Override // proto.PlatformVersionResultOrBuilder
    public PlatformVersion getPlatformversions(int i) {
        return this.platformversions_.get(i);
    }

    @Override // proto.PlatformVersionResultOrBuilder
    public PlatformVersionOrBuilder getPlatformversionsOrBuilder(int i) {
        return this.platformversions_.get(i);
    }

    public static PlatformVersionResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PlatformVersionResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlatformVersionResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PlatformVersionResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PlatformVersionResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PlatformVersionResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PlatformVersionResult parseFrom(InputStream inputStream) throws IOException {
        return (PlatformVersionResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PlatformVersionResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersionResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformVersionResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PlatformVersionResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlatformVersionResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersionResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformVersionResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PlatformVersionResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlatformVersionResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersionResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(PlatformVersionResult platformVersionResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) platformVersionResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((PlatformVersionResultIA) null) : (Builder) new Builder((PlatformVersionResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlatformVersionResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> platformversionsBuilder_;
        private List<PlatformVersion> platformversions_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, PlatformVersionResultIA platformVersionResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(PlatformVersionResultIA platformVersionResultIA) {
            this();
        }

        private void buildPartial0(PlatformVersionResult platformVersionResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_PlatformVersionResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_PlatformVersionResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformVersionResult.class, Builder.class);
        }

        private Builder() {
            this.platformversions_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.platformversions_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.platformversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.platformversions_ = Collections.emptyList();
            } else {
                this.platformversions_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_PlatformVersionResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlatformVersionResult getDefaultInstanceForType() {
            return PlatformVersionResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformVersionResult build() {
            PlatformVersionResult platformVersionResultBuildPartial = buildPartial();
            if (platformVersionResultBuildPartial.isInitialized()) {
                return platformVersionResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) platformVersionResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformVersionResult buildPartial() {
            PlatformVersionResult platformVersionResult = new PlatformVersionResult(this, null);
            buildPartialRepeatedFields(platformVersionResult);
            if (this.bitField0_ != 0) {
                buildPartial0(platformVersionResult);
            }
            onBuilt();
            return platformVersionResult;
        }

        private void buildPartialRepeatedFields(PlatformVersionResult platformVersionResult) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.platformversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.platformversions_ = Collections.unmodifiableList(this.platformversions_);
                    this.bitField0_ &= -2;
                }
                platformVersionResult.platformversions_ = this.platformversions_;
                return;
            }
            platformVersionResult.platformversions_ = repeatedFieldBuilder.build();
        }

        private void ensurePlatformversionsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.platformversions_ = new ArrayList(this.platformversions_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.PlatformVersionResultOrBuilder
        public List<PlatformVersion> getPlatformversionsList() {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.platformversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.platformversions_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.PlatformVersionResultOrBuilder
        public int getPlatformversionsCount() {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.platformversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformversions_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.PlatformVersionResultOrBuilder
        public PlatformVersion getPlatformversions(int i) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.platformversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformversions_.get(i);
            }
            return (PlatformVersion) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setPlatformversions(int i, PlatformVersion platformVersion) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.platformversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersion.getClass();
                ensurePlatformversionsIsMutable();
                this.platformversions_.set(i, platformVersion);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, platformVersion);
            return this;
        }

        public Builder setPlatformversions(int i, PlatformVersion.Builder builder) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.platformversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformversionsIsMutable();
                this.platformversions_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addPlatformversions(PlatformVersion platformVersion) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.platformversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersion.getClass();
                ensurePlatformversionsIsMutable();
                this.platformversions_.add(platformVersion);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(platformVersion);
            return this;
        }

        public Builder addPlatformversions(int i, PlatformVersion platformVersion) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.platformversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersion.getClass();
                ensurePlatformversionsIsMutable();
                this.platformversions_.add(i, platformVersion);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, platformVersion);
            return this;
        }

        public Builder addPlatformversions(PlatformVersion.Builder builder) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.platformversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformversionsIsMutable();
                this.platformversions_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addPlatformversions(int i, PlatformVersion.Builder builder) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.platformversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformversionsIsMutable();
                this.platformversions_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllPlatformversions(Iterable<? extends PlatformVersion> iterable) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.platformversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformversionsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.platformversions_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearPlatformversions() {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.platformversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.platformversions_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removePlatformversions(int i) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.platformversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformversionsIsMutable();
                this.platformversions_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public PlatformVersion.Builder getPlatformversionsBuilder(int i) {
            return (PlatformVersion.Builder) getPlatformversionsFieldBuilder().getBuilder(i);
        }

        @Override // proto.PlatformVersionResultOrBuilder
        public PlatformVersionOrBuilder getPlatformversionsOrBuilder(int i) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.platformversionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformversions_.get(i);
            }
            return (PlatformVersionOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.PlatformVersionResultOrBuilder
        public List<? extends PlatformVersionOrBuilder> getPlatformversionsOrBuilderList() {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.platformversionsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.platformversions_);
        }

        public PlatformVersion.Builder addPlatformversionsBuilder() {
            return (PlatformVersion.Builder) getPlatformversionsFieldBuilder().addBuilder(PlatformVersion.getDefaultInstance());
        }

        public PlatformVersion.Builder addPlatformversionsBuilder(int i) {
            return (PlatformVersion.Builder) getPlatformversionsFieldBuilder().addBuilder(i, PlatformVersion.getDefaultInstance());
        }

        public List<PlatformVersion.Builder> getPlatformversionsBuilderList() {
            return getPlatformversionsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> getPlatformversionsFieldBuilder() {
            if (this.platformversionsBuilder_ == null) {
                this.platformversionsBuilder_ = new RepeatedFieldBuilder<>(this.platformversions_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.platformversions_ = null;
            }
            return this.platformversionsBuilder_;
        }
    }

    public static PlatformVersionResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.PlatformVersionResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<PlatformVersionResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public PlatformVersionResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = PlatformVersionResult.newBuilder();
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

    public static Parser<PlatformVersionResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PlatformVersionResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PlatformVersionResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
