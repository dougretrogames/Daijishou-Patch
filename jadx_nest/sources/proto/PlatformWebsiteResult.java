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
public final class PlatformWebsiteResult extends GeneratedMessage implements PlatformWebsiteResultOrBuilder {
    private static final PlatformWebsiteResult DEFAULT_INSTANCE;
    private static final Parser<PlatformWebsiteResult> PARSER;
    public static final int PLATFORMWEBSITES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<PlatformWebsite> platformwebsites_;

    /* synthetic */ PlatformWebsiteResult(GeneratedMessage.Builder builder, PlatformWebsiteResultIA platformWebsiteResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PlatformWebsiteResult.class.getName());
        DEFAULT_INSTANCE = new PlatformWebsiteResult();
        PARSER = new AnonymousClass1();
    }

    private PlatformWebsiteResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private PlatformWebsiteResult() {
        this.platformwebsites_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_PlatformWebsiteResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_PlatformWebsiteResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformWebsiteResult.class, Builder.class);
    }

    @Override // proto.PlatformWebsiteResultOrBuilder
    public List<PlatformWebsite> getPlatformwebsitesList() {
        return this.platformwebsites_;
    }

    @Override // proto.PlatformWebsiteResultOrBuilder
    public List<? extends PlatformWebsiteOrBuilder> getPlatformwebsitesOrBuilderList() {
        return this.platformwebsites_;
    }

    @Override // proto.PlatformWebsiteResultOrBuilder
    public int getPlatformwebsitesCount() {
        return this.platformwebsites_.size();
    }

    @Override // proto.PlatformWebsiteResultOrBuilder
    public PlatformWebsite getPlatformwebsites(int i) {
        return this.platformwebsites_.get(i);
    }

    @Override // proto.PlatformWebsiteResultOrBuilder
    public PlatformWebsiteOrBuilder getPlatformwebsitesOrBuilder(int i) {
        return this.platformwebsites_.get(i);
    }

    public static PlatformWebsiteResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PlatformWebsiteResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlatformWebsiteResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PlatformWebsiteResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PlatformWebsiteResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PlatformWebsiteResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PlatformWebsiteResult parseFrom(InputStream inputStream) throws IOException {
        return (PlatformWebsiteResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PlatformWebsiteResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformWebsiteResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformWebsiteResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PlatformWebsiteResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlatformWebsiteResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformWebsiteResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformWebsiteResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PlatformWebsiteResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlatformWebsiteResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformWebsiteResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(PlatformWebsiteResult platformWebsiteResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) platformWebsiteResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((PlatformWebsiteResultIA) null) : (Builder) new Builder((PlatformWebsiteResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlatformWebsiteResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> platformwebsitesBuilder_;
        private List<PlatformWebsite> platformwebsites_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, PlatformWebsiteResultIA platformWebsiteResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(PlatformWebsiteResultIA platformWebsiteResultIA) {
            this();
        }

        private void buildPartial0(PlatformWebsiteResult platformWebsiteResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_PlatformWebsiteResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_PlatformWebsiteResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformWebsiteResult.class, Builder.class);
        }

        private Builder() {
            this.platformwebsites_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.platformwebsites_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.platformwebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.platformwebsites_ = Collections.emptyList();
            } else {
                this.platformwebsites_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_PlatformWebsiteResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlatformWebsiteResult getDefaultInstanceForType() {
            return PlatformWebsiteResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformWebsiteResult build() {
            PlatformWebsiteResult platformWebsiteResultBuildPartial = buildPartial();
            if (platformWebsiteResultBuildPartial.isInitialized()) {
                return platformWebsiteResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) platformWebsiteResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformWebsiteResult buildPartial() {
            PlatformWebsiteResult platformWebsiteResult = new PlatformWebsiteResult(this, null);
            buildPartialRepeatedFields(platformWebsiteResult);
            if (this.bitField0_ != 0) {
                buildPartial0(platformWebsiteResult);
            }
            onBuilt();
            return platformWebsiteResult;
        }

        private void buildPartialRepeatedFields(PlatformWebsiteResult platformWebsiteResult) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.platformwebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.platformwebsites_ = Collections.unmodifiableList(this.platformwebsites_);
                    this.bitField0_ &= -2;
                }
                platformWebsiteResult.platformwebsites_ = this.platformwebsites_;
                return;
            }
            platformWebsiteResult.platformwebsites_ = repeatedFieldBuilder.build();
        }

        private void ensurePlatformwebsitesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.platformwebsites_ = new ArrayList(this.platformwebsites_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.PlatformWebsiteResultOrBuilder
        public List<PlatformWebsite> getPlatformwebsitesList() {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.platformwebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.platformwebsites_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.PlatformWebsiteResultOrBuilder
        public int getPlatformwebsitesCount() {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.platformwebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformwebsites_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.PlatformWebsiteResultOrBuilder
        public PlatformWebsite getPlatformwebsites(int i) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.platformwebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformwebsites_.get(i);
            }
            return (PlatformWebsite) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setPlatformwebsites(int i, PlatformWebsite platformWebsite) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.platformwebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformWebsite.getClass();
                ensurePlatformwebsitesIsMutable();
                this.platformwebsites_.set(i, platformWebsite);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, platformWebsite);
            return this;
        }

        public Builder setPlatformwebsites(int i, PlatformWebsite.Builder builder) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.platformwebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformwebsitesIsMutable();
                this.platformwebsites_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addPlatformwebsites(PlatformWebsite platformWebsite) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.platformwebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformWebsite.getClass();
                ensurePlatformwebsitesIsMutable();
                this.platformwebsites_.add(platformWebsite);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(platformWebsite);
            return this;
        }

        public Builder addPlatformwebsites(int i, PlatformWebsite platformWebsite) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.platformwebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformWebsite.getClass();
                ensurePlatformwebsitesIsMutable();
                this.platformwebsites_.add(i, platformWebsite);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, platformWebsite);
            return this;
        }

        public Builder addPlatformwebsites(PlatformWebsite.Builder builder) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.platformwebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformwebsitesIsMutable();
                this.platformwebsites_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addPlatformwebsites(int i, PlatformWebsite.Builder builder) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.platformwebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformwebsitesIsMutable();
                this.platformwebsites_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllPlatformwebsites(Iterable<? extends PlatformWebsite> iterable) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.platformwebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformwebsitesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.platformwebsites_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearPlatformwebsites() {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.platformwebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.platformwebsites_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removePlatformwebsites(int i) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.platformwebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformwebsitesIsMutable();
                this.platformwebsites_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public PlatformWebsite.Builder getPlatformwebsitesBuilder(int i) {
            return (PlatformWebsite.Builder) getPlatformwebsitesFieldBuilder().getBuilder(i);
        }

        @Override // proto.PlatformWebsiteResultOrBuilder
        public PlatformWebsiteOrBuilder getPlatformwebsitesOrBuilder(int i) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.platformwebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformwebsites_.get(i);
            }
            return (PlatformWebsiteOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.PlatformWebsiteResultOrBuilder
        public List<? extends PlatformWebsiteOrBuilder> getPlatformwebsitesOrBuilderList() {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.platformwebsitesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.platformwebsites_);
        }

        public PlatformWebsite.Builder addPlatformwebsitesBuilder() {
            return (PlatformWebsite.Builder) getPlatformwebsitesFieldBuilder().addBuilder(PlatformWebsite.getDefaultInstance());
        }

        public PlatformWebsite.Builder addPlatformwebsitesBuilder(int i) {
            return (PlatformWebsite.Builder) getPlatformwebsitesFieldBuilder().addBuilder(i, PlatformWebsite.getDefaultInstance());
        }

        public List<PlatformWebsite.Builder> getPlatformwebsitesBuilderList() {
            return getPlatformwebsitesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> getPlatformwebsitesFieldBuilder() {
            if (this.platformwebsitesBuilder_ == null) {
                this.platformwebsitesBuilder_ = new RepeatedFieldBuilder<>(this.platformwebsites_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.platformwebsites_ = null;
            }
            return this.platformwebsitesBuilder_;
        }
    }

    public static PlatformWebsiteResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.PlatformWebsiteResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<PlatformWebsiteResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public PlatformWebsiteResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = PlatformWebsiteResult.newBuilder();
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

    public static Parser<PlatformWebsiteResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PlatformWebsiteResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PlatformWebsiteResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
