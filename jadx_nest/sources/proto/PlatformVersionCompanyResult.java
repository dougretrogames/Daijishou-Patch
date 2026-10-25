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
public final class PlatformVersionCompanyResult extends GeneratedMessage implements PlatformVersionCompanyResultOrBuilder {
    private static final PlatformVersionCompanyResult DEFAULT_INSTANCE;
    private static final Parser<PlatformVersionCompanyResult> PARSER;
    public static final int PLATFORMVERSIONCOMPANIES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<PlatformVersionCompany> platformversioncompanies_;

    /* synthetic */ PlatformVersionCompanyResult(GeneratedMessage.Builder builder, PlatformVersionCompanyResultIA platformVersionCompanyResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PlatformVersionCompanyResult.class.getName());
        DEFAULT_INSTANCE = new PlatformVersionCompanyResult();
        PARSER = new AnonymousClass1();
    }

    private PlatformVersionCompanyResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private PlatformVersionCompanyResult() {
        this.platformversioncompanies_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_PlatformVersionCompanyResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_PlatformVersionCompanyResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformVersionCompanyResult.class, Builder.class);
    }

    @Override // proto.PlatformVersionCompanyResultOrBuilder
    public List<PlatformVersionCompany> getPlatformversioncompaniesList() {
        return this.platformversioncompanies_;
    }

    @Override // proto.PlatformVersionCompanyResultOrBuilder
    public List<? extends PlatformVersionCompanyOrBuilder> getPlatformversioncompaniesOrBuilderList() {
        return this.platformversioncompanies_;
    }

    @Override // proto.PlatformVersionCompanyResultOrBuilder
    public int getPlatformversioncompaniesCount() {
        return this.platformversioncompanies_.size();
    }

    @Override // proto.PlatformVersionCompanyResultOrBuilder
    public PlatformVersionCompany getPlatformversioncompanies(int i) {
        return this.platformversioncompanies_.get(i);
    }

    @Override // proto.PlatformVersionCompanyResultOrBuilder
    public PlatformVersionCompanyOrBuilder getPlatformversioncompaniesOrBuilder(int i) {
        return this.platformversioncompanies_.get(i);
    }

    public static PlatformVersionCompanyResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PlatformVersionCompanyResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlatformVersionCompanyResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PlatformVersionCompanyResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PlatformVersionCompanyResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PlatformVersionCompanyResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PlatformVersionCompanyResult parseFrom(InputStream inputStream) throws IOException {
        return (PlatformVersionCompanyResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PlatformVersionCompanyResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersionCompanyResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformVersionCompanyResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PlatformVersionCompanyResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlatformVersionCompanyResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersionCompanyResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformVersionCompanyResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PlatformVersionCompanyResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlatformVersionCompanyResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersionCompanyResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(PlatformVersionCompanyResult platformVersionCompanyResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) platformVersionCompanyResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((PlatformVersionCompanyResultIA) null) : (Builder) new Builder((PlatformVersionCompanyResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlatformVersionCompanyResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> platformversioncompaniesBuilder_;
        private List<PlatformVersionCompany> platformversioncompanies_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, PlatformVersionCompanyResultIA platformVersionCompanyResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(PlatformVersionCompanyResultIA platformVersionCompanyResultIA) {
            this();
        }

        private void buildPartial0(PlatformVersionCompanyResult platformVersionCompanyResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_PlatformVersionCompanyResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_PlatformVersionCompanyResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformVersionCompanyResult.class, Builder.class);
        }

        private Builder() {
            this.platformversioncompanies_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.platformversioncompanies_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.platformversioncompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.platformversioncompanies_ = Collections.emptyList();
            } else {
                this.platformversioncompanies_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_PlatformVersionCompanyResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlatformVersionCompanyResult getDefaultInstanceForType() {
            return PlatformVersionCompanyResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformVersionCompanyResult build() {
            PlatformVersionCompanyResult platformVersionCompanyResultBuildPartial = buildPartial();
            if (platformVersionCompanyResultBuildPartial.isInitialized()) {
                return platformVersionCompanyResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) platformVersionCompanyResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformVersionCompanyResult buildPartial() {
            PlatformVersionCompanyResult platformVersionCompanyResult = new PlatformVersionCompanyResult(this, null);
            buildPartialRepeatedFields(platformVersionCompanyResult);
            if (this.bitField0_ != 0) {
                buildPartial0(platformVersionCompanyResult);
            }
            onBuilt();
            return platformVersionCompanyResult;
        }

        private void buildPartialRepeatedFields(PlatformVersionCompanyResult platformVersionCompanyResult) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.platformversioncompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.platformversioncompanies_ = Collections.unmodifiableList(this.platformversioncompanies_);
                    this.bitField0_ &= -2;
                }
                platformVersionCompanyResult.platformversioncompanies_ = this.platformversioncompanies_;
                return;
            }
            platformVersionCompanyResult.platformversioncompanies_ = repeatedFieldBuilder.build();
        }

        private void ensurePlatformversioncompaniesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.platformversioncompanies_ = new ArrayList(this.platformversioncompanies_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.PlatformVersionCompanyResultOrBuilder
        public List<PlatformVersionCompany> getPlatformversioncompaniesList() {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.platformversioncompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.platformversioncompanies_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.PlatformVersionCompanyResultOrBuilder
        public int getPlatformversioncompaniesCount() {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.platformversioncompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformversioncompanies_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.PlatformVersionCompanyResultOrBuilder
        public PlatformVersionCompany getPlatformversioncompanies(int i) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.platformversioncompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformversioncompanies_.get(i);
            }
            return (PlatformVersionCompany) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setPlatformversioncompanies(int i, PlatformVersionCompany platformVersionCompany) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.platformversioncompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersionCompany.getClass();
                ensurePlatformversioncompaniesIsMutable();
                this.platformversioncompanies_.set(i, platformVersionCompany);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, platformVersionCompany);
            return this;
        }

        public Builder setPlatformversioncompanies(int i, PlatformVersionCompany.Builder builder) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.platformversioncompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformversioncompaniesIsMutable();
                this.platformversioncompanies_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addPlatformversioncompanies(PlatformVersionCompany platformVersionCompany) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.platformversioncompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersionCompany.getClass();
                ensurePlatformversioncompaniesIsMutable();
                this.platformversioncompanies_.add(platformVersionCompany);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(platformVersionCompany);
            return this;
        }

        public Builder addPlatformversioncompanies(int i, PlatformVersionCompany platformVersionCompany) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.platformversioncompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersionCompany.getClass();
                ensurePlatformversioncompaniesIsMutable();
                this.platformversioncompanies_.add(i, platformVersionCompany);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, platformVersionCompany);
            return this;
        }

        public Builder addPlatformversioncompanies(PlatformVersionCompany.Builder builder) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.platformversioncompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformversioncompaniesIsMutable();
                this.platformversioncompanies_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addPlatformversioncompanies(int i, PlatformVersionCompany.Builder builder) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.platformversioncompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformversioncompaniesIsMutable();
                this.platformversioncompanies_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllPlatformversioncompanies(Iterable<? extends PlatformVersionCompany> iterable) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.platformversioncompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformversioncompaniesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.platformversioncompanies_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearPlatformversioncompanies() {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.platformversioncompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.platformversioncompanies_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removePlatformversioncompanies(int i) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.platformversioncompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformversioncompaniesIsMutable();
                this.platformversioncompanies_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public PlatformVersionCompany.Builder getPlatformversioncompaniesBuilder(int i) {
            return (PlatformVersionCompany.Builder) getPlatformversioncompaniesFieldBuilder().getBuilder(i);
        }

        @Override // proto.PlatformVersionCompanyResultOrBuilder
        public PlatformVersionCompanyOrBuilder getPlatformversioncompaniesOrBuilder(int i) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.platformversioncompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformversioncompanies_.get(i);
            }
            return (PlatformVersionCompanyOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.PlatformVersionCompanyResultOrBuilder
        public List<? extends PlatformVersionCompanyOrBuilder> getPlatformversioncompaniesOrBuilderList() {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.platformversioncompaniesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.platformversioncompanies_);
        }

        public PlatformVersionCompany.Builder addPlatformversioncompaniesBuilder() {
            return (PlatformVersionCompany.Builder) getPlatformversioncompaniesFieldBuilder().addBuilder(PlatformVersionCompany.getDefaultInstance());
        }

        public PlatformVersionCompany.Builder addPlatformversioncompaniesBuilder(int i) {
            return (PlatformVersionCompany.Builder) getPlatformversioncompaniesFieldBuilder().addBuilder(i, PlatformVersionCompany.getDefaultInstance());
        }

        public List<PlatformVersionCompany.Builder> getPlatformversioncompaniesBuilderList() {
            return getPlatformversioncompaniesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> getPlatformversioncompaniesFieldBuilder() {
            if (this.platformversioncompaniesBuilder_ == null) {
                this.platformversioncompaniesBuilder_ = new RepeatedFieldBuilder<>(this.platformversioncompanies_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.platformversioncompanies_ = null;
            }
            return this.platformversioncompaniesBuilder_;
        }
    }

    public static PlatformVersionCompanyResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.PlatformVersionCompanyResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<PlatformVersionCompanyResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public PlatformVersionCompanyResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = PlatformVersionCompanyResult.newBuilder();
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

    public static Parser<PlatformVersionCompanyResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PlatformVersionCompanyResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PlatformVersionCompanyResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
