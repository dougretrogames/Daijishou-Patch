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

/* JADX INFO: loaded from: classes6.dex */
public final class PlatformVersionReleaseDateResult extends GeneratedMessage implements PlatformVersionReleaseDateResultOrBuilder {
    private static final PlatformVersionReleaseDateResult DEFAULT_INSTANCE;
    private static final Parser<PlatformVersionReleaseDateResult> PARSER;
    public static final int PLATFORMVERSIONRELEASEDATES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<PlatformVersionReleaseDate> platformversionreleasedates_;

    /* synthetic */ PlatformVersionReleaseDateResult(GeneratedMessage.Builder builder, PlatformVersionReleaseDateResultIA platformVersionReleaseDateResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PlatformVersionReleaseDateResult.class.getName());
        DEFAULT_INSTANCE = new PlatformVersionReleaseDateResult();
        PARSER = new AnonymousClass1();
    }

    private PlatformVersionReleaseDateResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private PlatformVersionReleaseDateResult() {
        this.platformversionreleasedates_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_PlatformVersionReleaseDateResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_PlatformVersionReleaseDateResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformVersionReleaseDateResult.class, Builder.class);
    }

    @Override // proto.PlatformVersionReleaseDateResultOrBuilder
    public List<PlatformVersionReleaseDate> getPlatformversionreleasedatesList() {
        return this.platformversionreleasedates_;
    }

    @Override // proto.PlatformVersionReleaseDateResultOrBuilder
    public List<? extends PlatformVersionReleaseDateOrBuilder> getPlatformversionreleasedatesOrBuilderList() {
        return this.platformversionreleasedates_;
    }

    @Override // proto.PlatformVersionReleaseDateResultOrBuilder
    public int getPlatformversionreleasedatesCount() {
        return this.platformversionreleasedates_.size();
    }

    @Override // proto.PlatformVersionReleaseDateResultOrBuilder
    public PlatformVersionReleaseDate getPlatformversionreleasedates(int i) {
        return this.platformversionreleasedates_.get(i);
    }

    @Override // proto.PlatformVersionReleaseDateResultOrBuilder
    public PlatformVersionReleaseDateOrBuilder getPlatformversionreleasedatesOrBuilder(int i) {
        return this.platformversionreleasedates_.get(i);
    }

    public static PlatformVersionReleaseDateResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PlatformVersionReleaseDateResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlatformVersionReleaseDateResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PlatformVersionReleaseDateResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PlatformVersionReleaseDateResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PlatformVersionReleaseDateResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PlatformVersionReleaseDateResult parseFrom(InputStream inputStream) throws IOException {
        return (PlatformVersionReleaseDateResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PlatformVersionReleaseDateResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersionReleaseDateResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformVersionReleaseDateResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PlatformVersionReleaseDateResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlatformVersionReleaseDateResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersionReleaseDateResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformVersionReleaseDateResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PlatformVersionReleaseDateResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlatformVersionReleaseDateResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersionReleaseDateResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(PlatformVersionReleaseDateResult platformVersionReleaseDateResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) platformVersionReleaseDateResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((PlatformVersionReleaseDateResultIA) null) : (Builder) new Builder((PlatformVersionReleaseDateResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlatformVersionReleaseDateResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> platformversionreleasedatesBuilder_;
        private List<PlatformVersionReleaseDate> platformversionreleasedates_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, PlatformVersionReleaseDateResultIA platformVersionReleaseDateResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(PlatformVersionReleaseDateResultIA platformVersionReleaseDateResultIA) {
            this();
        }

        private void buildPartial0(PlatformVersionReleaseDateResult platformVersionReleaseDateResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_PlatformVersionReleaseDateResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_PlatformVersionReleaseDateResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformVersionReleaseDateResult.class, Builder.class);
        }

        private Builder() {
            this.platformversionreleasedates_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.platformversionreleasedates_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformversionreleasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.platformversionreleasedates_ = Collections.emptyList();
            } else {
                this.platformversionreleasedates_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_PlatformVersionReleaseDateResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlatformVersionReleaseDateResult getDefaultInstanceForType() {
            return PlatformVersionReleaseDateResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformVersionReleaseDateResult build() {
            PlatformVersionReleaseDateResult platformVersionReleaseDateResultBuildPartial = buildPartial();
            if (platformVersionReleaseDateResultBuildPartial.isInitialized()) {
                return platformVersionReleaseDateResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) platformVersionReleaseDateResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformVersionReleaseDateResult buildPartial() {
            PlatformVersionReleaseDateResult platformVersionReleaseDateResult = new PlatformVersionReleaseDateResult(this, null);
            buildPartialRepeatedFields(platformVersionReleaseDateResult);
            if (this.bitField0_ != 0) {
                buildPartial0(platformVersionReleaseDateResult);
            }
            onBuilt();
            return platformVersionReleaseDateResult;
        }

        private void buildPartialRepeatedFields(PlatformVersionReleaseDateResult platformVersionReleaseDateResult) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformversionreleasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.platformversionreleasedates_ = Collections.unmodifiableList(this.platformversionreleasedates_);
                    this.bitField0_ &= -2;
                }
                platformVersionReleaseDateResult.platformversionreleasedates_ = this.platformversionreleasedates_;
                return;
            }
            platformVersionReleaseDateResult.platformversionreleasedates_ = repeatedFieldBuilder.build();
        }

        private void ensurePlatformversionreleasedatesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.platformversionreleasedates_ = new ArrayList(this.platformversionreleasedates_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.PlatformVersionReleaseDateResultOrBuilder
        public List<PlatformVersionReleaseDate> getPlatformversionreleasedatesList() {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformversionreleasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.platformversionreleasedates_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.PlatformVersionReleaseDateResultOrBuilder
        public int getPlatformversionreleasedatesCount() {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformversionreleasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformversionreleasedates_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.PlatformVersionReleaseDateResultOrBuilder
        public PlatformVersionReleaseDate getPlatformversionreleasedates(int i) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformversionreleasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformversionreleasedates_.get(i);
            }
            return (PlatformVersionReleaseDate) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setPlatformversionreleasedates(int i, PlatformVersionReleaseDate platformVersionReleaseDate) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformversionreleasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersionReleaseDate.getClass();
                ensurePlatformversionreleasedatesIsMutable();
                this.platformversionreleasedates_.set(i, platformVersionReleaseDate);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, platformVersionReleaseDate);
            return this;
        }

        public Builder setPlatformversionreleasedates(int i, PlatformVersionReleaseDate.Builder builder) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformversionreleasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformversionreleasedatesIsMutable();
                this.platformversionreleasedates_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addPlatformversionreleasedates(PlatformVersionReleaseDate platformVersionReleaseDate) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformversionreleasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersionReleaseDate.getClass();
                ensurePlatformversionreleasedatesIsMutable();
                this.platformversionreleasedates_.add(platformVersionReleaseDate);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(platformVersionReleaseDate);
            return this;
        }

        public Builder addPlatformversionreleasedates(int i, PlatformVersionReleaseDate platformVersionReleaseDate) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformversionreleasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersionReleaseDate.getClass();
                ensurePlatformversionreleasedatesIsMutable();
                this.platformversionreleasedates_.add(i, platformVersionReleaseDate);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, platformVersionReleaseDate);
            return this;
        }

        public Builder addPlatformversionreleasedates(PlatformVersionReleaseDate.Builder builder) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformversionreleasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformversionreleasedatesIsMutable();
                this.platformversionreleasedates_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addPlatformversionreleasedates(int i, PlatformVersionReleaseDate.Builder builder) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformversionreleasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformversionreleasedatesIsMutable();
                this.platformversionreleasedates_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllPlatformversionreleasedates(Iterable<? extends PlatformVersionReleaseDate> iterable) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformversionreleasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformversionreleasedatesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.platformversionreleasedates_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearPlatformversionreleasedates() {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformversionreleasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.platformversionreleasedates_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removePlatformversionreleasedates(int i) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformversionreleasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformversionreleasedatesIsMutable();
                this.platformversionreleasedates_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public PlatformVersionReleaseDate.Builder getPlatformversionreleasedatesBuilder(int i) {
            return (PlatformVersionReleaseDate.Builder) getPlatformversionreleasedatesFieldBuilder().getBuilder(i);
        }

        @Override // proto.PlatformVersionReleaseDateResultOrBuilder
        public PlatformVersionReleaseDateOrBuilder getPlatformversionreleasedatesOrBuilder(int i) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformversionreleasedatesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformversionreleasedates_.get(i);
            }
            return (PlatformVersionReleaseDateOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.PlatformVersionReleaseDateResultOrBuilder
        public List<? extends PlatformVersionReleaseDateOrBuilder> getPlatformversionreleasedatesOrBuilderList() {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformversionreleasedatesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.platformversionreleasedates_);
        }

        public PlatformVersionReleaseDate.Builder addPlatformversionreleasedatesBuilder() {
            return (PlatformVersionReleaseDate.Builder) getPlatformversionreleasedatesFieldBuilder().addBuilder(PlatformVersionReleaseDate.getDefaultInstance());
        }

        public PlatformVersionReleaseDate.Builder addPlatformversionreleasedatesBuilder(int i) {
            return (PlatformVersionReleaseDate.Builder) getPlatformversionreleasedatesFieldBuilder().addBuilder(i, PlatformVersionReleaseDate.getDefaultInstance());
        }

        public List<PlatformVersionReleaseDate.Builder> getPlatformversionreleasedatesBuilderList() {
            return getPlatformversionreleasedatesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> getPlatformversionreleasedatesFieldBuilder() {
            if (this.platformversionreleasedatesBuilder_ == null) {
                this.platformversionreleasedatesBuilder_ = new RepeatedFieldBuilder<>(this.platformversionreleasedates_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.platformversionreleasedates_ = null;
            }
            return this.platformversionreleasedatesBuilder_;
        }
    }

    public static PlatformVersionReleaseDateResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.PlatformVersionReleaseDateResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<PlatformVersionReleaseDateResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public PlatformVersionReleaseDateResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = PlatformVersionReleaseDateResult.newBuilder();
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

    public static Parser<PlatformVersionReleaseDateResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PlatformVersionReleaseDateResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PlatformVersionReleaseDateResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
