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
public final class PlatformFamilyResult extends GeneratedMessage implements PlatformFamilyResultOrBuilder {
    private static final PlatformFamilyResult DEFAULT_INSTANCE;
    private static final Parser<PlatformFamilyResult> PARSER;
    public static final int PLATFORMFAMILIES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<PlatformFamily> platformfamilies_;

    /* synthetic */ PlatformFamilyResult(GeneratedMessage.Builder builder, PlatformFamilyResultIA platformFamilyResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PlatformFamilyResult.class.getName());
        DEFAULT_INSTANCE = new PlatformFamilyResult();
        PARSER = new AnonymousClass1();
    }

    private PlatformFamilyResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private PlatformFamilyResult() {
        this.platformfamilies_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_PlatformFamilyResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_PlatformFamilyResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformFamilyResult.class, Builder.class);
    }

    @Override // proto.PlatformFamilyResultOrBuilder
    public List<PlatformFamily> getPlatformfamiliesList() {
        return this.platformfamilies_;
    }

    @Override // proto.PlatformFamilyResultOrBuilder
    public List<? extends PlatformFamilyOrBuilder> getPlatformfamiliesOrBuilderList() {
        return this.platformfamilies_;
    }

    @Override // proto.PlatformFamilyResultOrBuilder
    public int getPlatformfamiliesCount() {
        return this.platformfamilies_.size();
    }

    @Override // proto.PlatformFamilyResultOrBuilder
    public PlatformFamily getPlatformfamilies(int i) {
        return this.platformfamilies_.get(i);
    }

    @Override // proto.PlatformFamilyResultOrBuilder
    public PlatformFamilyOrBuilder getPlatformfamiliesOrBuilder(int i) {
        return this.platformfamilies_.get(i);
    }

    public static PlatformFamilyResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PlatformFamilyResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlatformFamilyResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PlatformFamilyResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PlatformFamilyResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PlatformFamilyResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PlatformFamilyResult parseFrom(InputStream inputStream) throws IOException {
        return (PlatformFamilyResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PlatformFamilyResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformFamilyResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformFamilyResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PlatformFamilyResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlatformFamilyResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformFamilyResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformFamilyResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PlatformFamilyResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlatformFamilyResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformFamilyResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(PlatformFamilyResult platformFamilyResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) platformFamilyResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((PlatformFamilyResultIA) null) : (Builder) new Builder((PlatformFamilyResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlatformFamilyResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> platformfamiliesBuilder_;
        private List<PlatformFamily> platformfamilies_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, PlatformFamilyResultIA platformFamilyResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(PlatformFamilyResultIA platformFamilyResultIA) {
            this();
        }

        private void buildPartial0(PlatformFamilyResult platformFamilyResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_PlatformFamilyResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_PlatformFamilyResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformFamilyResult.class, Builder.class);
        }

        private Builder() {
            this.platformfamilies_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.platformfamilies_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> repeatedFieldBuilder = this.platformfamiliesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.platformfamilies_ = Collections.emptyList();
            } else {
                this.platformfamilies_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_PlatformFamilyResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlatformFamilyResult getDefaultInstanceForType() {
            return PlatformFamilyResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformFamilyResult build() {
            PlatformFamilyResult platformFamilyResultBuildPartial = buildPartial();
            if (platformFamilyResultBuildPartial.isInitialized()) {
                return platformFamilyResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) platformFamilyResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformFamilyResult buildPartial() {
            PlatformFamilyResult platformFamilyResult = new PlatformFamilyResult(this, null);
            buildPartialRepeatedFields(platformFamilyResult);
            if (this.bitField0_ != 0) {
                buildPartial0(platformFamilyResult);
            }
            onBuilt();
            return platformFamilyResult;
        }

        private void buildPartialRepeatedFields(PlatformFamilyResult platformFamilyResult) {
            RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> repeatedFieldBuilder = this.platformfamiliesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.platformfamilies_ = Collections.unmodifiableList(this.platformfamilies_);
                    this.bitField0_ &= -2;
                }
                platformFamilyResult.platformfamilies_ = this.platformfamilies_;
                return;
            }
            platformFamilyResult.platformfamilies_ = repeatedFieldBuilder.build();
        }

        private void ensurePlatformfamiliesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.platformfamilies_ = new ArrayList(this.platformfamilies_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.PlatformFamilyResultOrBuilder
        public List<PlatformFamily> getPlatformfamiliesList() {
            RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> repeatedFieldBuilder = this.platformfamiliesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.platformfamilies_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.PlatformFamilyResultOrBuilder
        public int getPlatformfamiliesCount() {
            RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> repeatedFieldBuilder = this.platformfamiliesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformfamilies_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.PlatformFamilyResultOrBuilder
        public PlatformFamily getPlatformfamilies(int i) {
            RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> repeatedFieldBuilder = this.platformfamiliesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformfamilies_.get(i);
            }
            return (PlatformFamily) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setPlatformfamilies(int i, PlatformFamily platformFamily) {
            RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> repeatedFieldBuilder = this.platformfamiliesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformFamily.getClass();
                ensurePlatformfamiliesIsMutable();
                this.platformfamilies_.set(i, platformFamily);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, platformFamily);
            return this;
        }

        public Builder setPlatformfamilies(int i, PlatformFamily.Builder builder) {
            RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> repeatedFieldBuilder = this.platformfamiliesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformfamiliesIsMutable();
                this.platformfamilies_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addPlatformfamilies(PlatformFamily platformFamily) {
            RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> repeatedFieldBuilder = this.platformfamiliesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformFamily.getClass();
                ensurePlatformfamiliesIsMutable();
                this.platformfamilies_.add(platformFamily);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(platformFamily);
            return this;
        }

        public Builder addPlatformfamilies(int i, PlatformFamily platformFamily) {
            RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> repeatedFieldBuilder = this.platformfamiliesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformFamily.getClass();
                ensurePlatformfamiliesIsMutable();
                this.platformfamilies_.add(i, platformFamily);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, platformFamily);
            return this;
        }

        public Builder addPlatformfamilies(PlatformFamily.Builder builder) {
            RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> repeatedFieldBuilder = this.platformfamiliesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformfamiliesIsMutable();
                this.platformfamilies_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addPlatformfamilies(int i, PlatformFamily.Builder builder) {
            RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> repeatedFieldBuilder = this.platformfamiliesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformfamiliesIsMutable();
                this.platformfamilies_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllPlatformfamilies(Iterable<? extends PlatformFamily> iterable) {
            RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> repeatedFieldBuilder = this.platformfamiliesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformfamiliesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.platformfamilies_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearPlatformfamilies() {
            RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> repeatedFieldBuilder = this.platformfamiliesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.platformfamilies_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removePlatformfamilies(int i) {
            RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> repeatedFieldBuilder = this.platformfamiliesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformfamiliesIsMutable();
                this.platformfamilies_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public PlatformFamily.Builder getPlatformfamiliesBuilder(int i) {
            return (PlatformFamily.Builder) getPlatformfamiliesFieldBuilder().getBuilder(i);
        }

        @Override // proto.PlatformFamilyResultOrBuilder
        public PlatformFamilyOrBuilder getPlatformfamiliesOrBuilder(int i) {
            RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> repeatedFieldBuilder = this.platformfamiliesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformfamilies_.get(i);
            }
            return (PlatformFamilyOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.PlatformFamilyResultOrBuilder
        public List<? extends PlatformFamilyOrBuilder> getPlatformfamiliesOrBuilderList() {
            RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> repeatedFieldBuilder = this.platformfamiliesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.platformfamilies_);
        }

        public PlatformFamily.Builder addPlatformfamiliesBuilder() {
            return (PlatformFamily.Builder) getPlatformfamiliesFieldBuilder().addBuilder(PlatformFamily.getDefaultInstance());
        }

        public PlatformFamily.Builder addPlatformfamiliesBuilder(int i) {
            return (PlatformFamily.Builder) getPlatformfamiliesFieldBuilder().addBuilder(i, PlatformFamily.getDefaultInstance());
        }

        public List<PlatformFamily.Builder> getPlatformfamiliesBuilderList() {
            return getPlatformfamiliesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> getPlatformfamiliesFieldBuilder() {
            if (this.platformfamiliesBuilder_ == null) {
                this.platformfamiliesBuilder_ = new RepeatedFieldBuilder<>(this.platformfamilies_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.platformfamilies_ = null;
            }
            return this.platformfamiliesBuilder_;
        }
    }

    public static PlatformFamilyResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.PlatformFamilyResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<PlatformFamilyResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public PlatformFamilyResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = PlatformFamilyResult.newBuilder();
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

    public static Parser<PlatformFamilyResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PlatformFamilyResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PlatformFamilyResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
