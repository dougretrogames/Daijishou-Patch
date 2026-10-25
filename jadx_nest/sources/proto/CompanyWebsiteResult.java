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
public final class CompanyWebsiteResult extends GeneratedMessage implements CompanyWebsiteResultOrBuilder {
    public static final int COMPANYWEBSITES_FIELD_NUMBER = 1;
    private static final CompanyWebsiteResult DEFAULT_INSTANCE;
    private static final Parser<CompanyWebsiteResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<CompanyWebsite> companywebsites_;

    /* synthetic */ CompanyWebsiteResult(GeneratedMessage.Builder builder, CompanyWebsiteResultIA companyWebsiteResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CompanyWebsiteResult.class.getName());
        DEFAULT_INSTANCE = new CompanyWebsiteResult();
        PARSER = new AnonymousClass1();
    }

    private CompanyWebsiteResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private CompanyWebsiteResult() {
        this.companywebsites_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CompanyWebsiteResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CompanyWebsiteResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CompanyWebsiteResult.class, Builder.class);
    }

    @Override // proto.CompanyWebsiteResultOrBuilder
    public List<CompanyWebsite> getCompanywebsitesList() {
        return this.companywebsites_;
    }

    @Override // proto.CompanyWebsiteResultOrBuilder
    public List<? extends CompanyWebsiteOrBuilder> getCompanywebsitesOrBuilderList() {
        return this.companywebsites_;
    }

    @Override // proto.CompanyWebsiteResultOrBuilder
    public int getCompanywebsitesCount() {
        return this.companywebsites_.size();
    }

    @Override // proto.CompanyWebsiteResultOrBuilder
    public CompanyWebsite getCompanywebsites(int i) {
        return this.companywebsites_.get(i);
    }

    @Override // proto.CompanyWebsiteResultOrBuilder
    public CompanyWebsiteOrBuilder getCompanywebsitesOrBuilder(int i) {
        return this.companywebsites_.get(i);
    }

    public static CompanyWebsiteResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CompanyWebsiteResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CompanyWebsiteResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CompanyWebsiteResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CompanyWebsiteResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CompanyWebsiteResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CompanyWebsiteResult parseFrom(InputStream inputStream) throws IOException {
        return (CompanyWebsiteResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CompanyWebsiteResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompanyWebsiteResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CompanyWebsiteResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CompanyWebsiteResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CompanyWebsiteResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompanyWebsiteResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CompanyWebsiteResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CompanyWebsiteResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CompanyWebsiteResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompanyWebsiteResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CompanyWebsiteResult companyWebsiteResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) companyWebsiteResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CompanyWebsiteResultIA) null) : (Builder) new Builder((CompanyWebsiteResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CompanyWebsiteResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> companywebsitesBuilder_;
        private List<CompanyWebsite> companywebsites_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CompanyWebsiteResultIA companyWebsiteResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CompanyWebsiteResultIA companyWebsiteResultIA) {
            this();
        }

        private void buildPartial0(CompanyWebsiteResult companyWebsiteResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CompanyWebsiteResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CompanyWebsiteResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CompanyWebsiteResult.class, Builder.class);
        }

        private Builder() {
            this.companywebsites_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.companywebsites_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.companywebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.companywebsites_ = Collections.emptyList();
            } else {
                this.companywebsites_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_CompanyWebsiteResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CompanyWebsiteResult getDefaultInstanceForType() {
            return CompanyWebsiteResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CompanyWebsiteResult build() {
            CompanyWebsiteResult companyWebsiteResultBuildPartial = buildPartial();
            if (companyWebsiteResultBuildPartial.isInitialized()) {
                return companyWebsiteResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) companyWebsiteResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CompanyWebsiteResult buildPartial() {
            CompanyWebsiteResult companyWebsiteResult = new CompanyWebsiteResult(this, null);
            buildPartialRepeatedFields(companyWebsiteResult);
            if (this.bitField0_ != 0) {
                buildPartial0(companyWebsiteResult);
            }
            onBuilt();
            return companyWebsiteResult;
        }

        private void buildPartialRepeatedFields(CompanyWebsiteResult companyWebsiteResult) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.companywebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.companywebsites_ = Collections.unmodifiableList(this.companywebsites_);
                    this.bitField0_ &= -2;
                }
                companyWebsiteResult.companywebsites_ = this.companywebsites_;
                return;
            }
            companyWebsiteResult.companywebsites_ = repeatedFieldBuilder.build();
        }

        private void ensureCompanywebsitesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.companywebsites_ = new ArrayList(this.companywebsites_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.CompanyWebsiteResultOrBuilder
        public List<CompanyWebsite> getCompanywebsitesList() {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.companywebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.companywebsites_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CompanyWebsiteResultOrBuilder
        public int getCompanywebsitesCount() {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.companywebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.companywebsites_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CompanyWebsiteResultOrBuilder
        public CompanyWebsite getCompanywebsites(int i) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.companywebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.companywebsites_.get(i);
            }
            return (CompanyWebsite) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setCompanywebsites(int i, CompanyWebsite companyWebsite) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.companywebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                companyWebsite.getClass();
                ensureCompanywebsitesIsMutable();
                this.companywebsites_.set(i, companyWebsite);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, companyWebsite);
            return this;
        }

        public Builder setCompanywebsites(int i, CompanyWebsite.Builder builder) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.companywebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompanywebsitesIsMutable();
                this.companywebsites_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addCompanywebsites(CompanyWebsite companyWebsite) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.companywebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                companyWebsite.getClass();
                ensureCompanywebsitesIsMutable();
                this.companywebsites_.add(companyWebsite);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(companyWebsite);
            return this;
        }

        public Builder addCompanywebsites(int i, CompanyWebsite companyWebsite) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.companywebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                companyWebsite.getClass();
                ensureCompanywebsitesIsMutable();
                this.companywebsites_.add(i, companyWebsite);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, companyWebsite);
            return this;
        }

        public Builder addCompanywebsites(CompanyWebsite.Builder builder) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.companywebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompanywebsitesIsMutable();
                this.companywebsites_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addCompanywebsites(int i, CompanyWebsite.Builder builder) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.companywebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompanywebsitesIsMutable();
                this.companywebsites_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllCompanywebsites(Iterable<? extends CompanyWebsite> iterable) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.companywebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompanywebsitesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.companywebsites_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearCompanywebsites() {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.companywebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.companywebsites_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeCompanywebsites(int i) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.companywebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompanywebsitesIsMutable();
                this.companywebsites_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public CompanyWebsite.Builder getCompanywebsitesBuilder(int i) {
            return (CompanyWebsite.Builder) getCompanywebsitesFieldBuilder().getBuilder(i);
        }

        @Override // proto.CompanyWebsiteResultOrBuilder
        public CompanyWebsiteOrBuilder getCompanywebsitesOrBuilder(int i) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.companywebsitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.companywebsites_.get(i);
            }
            return (CompanyWebsiteOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CompanyWebsiteResultOrBuilder
        public List<? extends CompanyWebsiteOrBuilder> getCompanywebsitesOrBuilderList() {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.companywebsitesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.companywebsites_);
        }

        public CompanyWebsite.Builder addCompanywebsitesBuilder() {
            return (CompanyWebsite.Builder) getCompanywebsitesFieldBuilder().addBuilder(CompanyWebsite.getDefaultInstance());
        }

        public CompanyWebsite.Builder addCompanywebsitesBuilder(int i) {
            return (CompanyWebsite.Builder) getCompanywebsitesFieldBuilder().addBuilder(i, CompanyWebsite.getDefaultInstance());
        }

        public List<CompanyWebsite.Builder> getCompanywebsitesBuilderList() {
            return getCompanywebsitesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> getCompanywebsitesFieldBuilder() {
            if (this.companywebsitesBuilder_ == null) {
                this.companywebsitesBuilder_ = new RepeatedFieldBuilder<>(this.companywebsites_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.companywebsites_ = null;
            }
            return this.companywebsitesBuilder_;
        }
    }

    public static CompanyWebsiteResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.CompanyWebsiteResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CompanyWebsiteResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CompanyWebsiteResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CompanyWebsiteResult.newBuilder();
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

    public static Parser<CompanyWebsiteResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CompanyWebsiteResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CompanyWebsiteResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
