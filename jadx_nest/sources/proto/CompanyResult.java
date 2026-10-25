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
public final class CompanyResult extends GeneratedMessage implements CompanyResultOrBuilder {
    public static final int COMPANIES_FIELD_NUMBER = 1;
    private static final CompanyResult DEFAULT_INSTANCE;
    private static final Parser<CompanyResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<Company> companies_;

    /* synthetic */ CompanyResult(GeneratedMessage.Builder builder, CompanyResultIA companyResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CompanyResult.class.getName());
        DEFAULT_INSTANCE = new CompanyResult();
        PARSER = new AnonymousClass1();
    }

    private CompanyResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private CompanyResult() {
        this.companies_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CompanyResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CompanyResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CompanyResult.class, Builder.class);
    }

    @Override // proto.CompanyResultOrBuilder
    public List<Company> getCompaniesList() {
        return this.companies_;
    }

    @Override // proto.CompanyResultOrBuilder
    public List<? extends CompanyOrBuilder> getCompaniesOrBuilderList() {
        return this.companies_;
    }

    @Override // proto.CompanyResultOrBuilder
    public int getCompaniesCount() {
        return this.companies_.size();
    }

    @Override // proto.CompanyResultOrBuilder
    public Company getCompanies(int i) {
        return this.companies_.get(i);
    }

    @Override // proto.CompanyResultOrBuilder
    public CompanyOrBuilder getCompaniesOrBuilder(int i) {
        return this.companies_.get(i);
    }

    public static CompanyResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CompanyResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CompanyResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CompanyResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CompanyResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CompanyResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CompanyResult parseFrom(InputStream inputStream) throws IOException {
        return (CompanyResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CompanyResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompanyResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CompanyResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CompanyResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CompanyResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompanyResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CompanyResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CompanyResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CompanyResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompanyResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CompanyResult companyResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) companyResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CompanyResultIA) null) : (Builder) new Builder((CompanyResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CompanyResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> companiesBuilder_;
        private List<Company> companies_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CompanyResultIA companyResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CompanyResultIA companyResultIA) {
            this();
        }

        private void buildPartial0(CompanyResult companyResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CompanyResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CompanyResult_fieldAccessorTable.ensureFieldAccessorsInitialized(CompanyResult.class, Builder.class);
        }

        private Builder() {
            this.companies_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.companies_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.companies_ = Collections.emptyList();
            } else {
                this.companies_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_CompanyResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CompanyResult getDefaultInstanceForType() {
            return CompanyResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CompanyResult build() {
            CompanyResult companyResultBuildPartial = buildPartial();
            if (companyResultBuildPartial.isInitialized()) {
                return companyResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) companyResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CompanyResult buildPartial() {
            CompanyResult companyResult = new CompanyResult(this, null);
            buildPartialRepeatedFields(companyResult);
            if (this.bitField0_ != 0) {
                buildPartial0(companyResult);
            }
            onBuilt();
            return companyResult;
        }

        private void buildPartialRepeatedFields(CompanyResult companyResult) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.companies_ = Collections.unmodifiableList(this.companies_);
                    this.bitField0_ &= -2;
                }
                companyResult.companies_ = this.companies_;
                return;
            }
            companyResult.companies_ = repeatedFieldBuilder.build();
        }

        private void ensureCompaniesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.companies_ = new ArrayList(this.companies_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.CompanyResultOrBuilder
        public List<Company> getCompaniesList() {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.companies_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CompanyResultOrBuilder
        public int getCompaniesCount() {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.companies_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CompanyResultOrBuilder
        public Company getCompanies(int i) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.companies_.get(i);
            }
            return (Company) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setCompanies(int i, Company company) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                company.getClass();
                ensureCompaniesIsMutable();
                this.companies_.set(i, company);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, company);
            return this;
        }

        public Builder setCompanies(int i, Company.Builder builder) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompaniesIsMutable();
                this.companies_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addCompanies(Company company) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                company.getClass();
                ensureCompaniesIsMutable();
                this.companies_.add(company);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(company);
            return this;
        }

        public Builder addCompanies(int i, Company company) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                company.getClass();
                ensureCompaniesIsMutable();
                this.companies_.add(i, company);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, company);
            return this;
        }

        public Builder addCompanies(Company.Builder builder) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompaniesIsMutable();
                this.companies_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addCompanies(int i, Company.Builder builder) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompaniesIsMutable();
                this.companies_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllCompanies(Iterable<? extends Company> iterable) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompaniesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.companies_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearCompanies() {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.companies_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeCompanies(int i) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompaniesIsMutable();
                this.companies_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Company.Builder getCompaniesBuilder(int i) {
            return (Company.Builder) getCompaniesFieldBuilder().getBuilder(i);
        }

        @Override // proto.CompanyResultOrBuilder
        public CompanyOrBuilder getCompaniesOrBuilder(int i) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.companies_.get(i);
            }
            return (CompanyOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CompanyResultOrBuilder
        public List<? extends CompanyOrBuilder> getCompaniesOrBuilderList() {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.companies_);
        }

        public Company.Builder addCompaniesBuilder() {
            return (Company.Builder) getCompaniesFieldBuilder().addBuilder(Company.getDefaultInstance());
        }

        public Company.Builder addCompaniesBuilder(int i) {
            return (Company.Builder) getCompaniesFieldBuilder().addBuilder(i, Company.getDefaultInstance());
        }

        public List<Company.Builder> getCompaniesBuilderList() {
            return getCompaniesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> getCompaniesFieldBuilder() {
            if (this.companiesBuilder_ == null) {
                this.companiesBuilder_ = new RepeatedFieldBuilder<>(this.companies_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.companies_ = null;
            }
            return this.companiesBuilder_;
        }
    }

    public static CompanyResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.CompanyResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CompanyResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CompanyResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CompanyResult.newBuilder();
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

    public static Parser<CompanyResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CompanyResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CompanyResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
