package proto;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public final class PlatformVersionCompany extends GeneratedMessage implements PlatformVersionCompanyOrBuilder {
    public static final int CHECKSUM_FIELD_NUMBER = 6;
    public static final int COMMENT_FIELD_NUMBER = 2;
    public static final int COMPANY_FIELD_NUMBER = 3;
    private static final PlatformVersionCompany DEFAULT_INSTANCE;
    public static final int DEVELOPER_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int MANUFACTURER_FIELD_NUMBER = 5;
    private static final Parser<PlatformVersionCompany> PARSER;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object checksum_;
    private volatile Object comment_;
    private Company company_;
    private boolean developer_;
    private long id_;
    private boolean manufacturer_;

    /* synthetic */ PlatformVersionCompany(GeneratedMessage.Builder builder, PlatformVersionCompanyIA platformVersionCompanyIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PlatformVersionCompany.class.getName());
        DEFAULT_INSTANCE = new PlatformVersionCompany();
        PARSER = new AnonymousClass1();
    }

    private PlatformVersionCompany(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.comment_ = "";
        this.developer_ = false;
        this.manufacturer_ = false;
        this.checksum_ = "";
    }

    private PlatformVersionCompany() {
        this.id_ = 0L;
        this.comment_ = "";
        this.developer_ = false;
        this.manufacturer_ = false;
        this.checksum_ = "";
        this.comment_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_PlatformVersionCompany_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_PlatformVersionCompany_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformVersionCompany.class, Builder.class);
    }

    @Override // proto.PlatformVersionCompanyOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.PlatformVersionCompanyOrBuilder
    public String getComment() {
        Object obj = this.comment_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.comment_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionCompanyOrBuilder
    public ByteString getCommentBytes() {
        Object obj = this.comment_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.comment_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionCompanyOrBuilder
    public boolean hasCompany() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.PlatformVersionCompanyOrBuilder
    public Company getCompany() {
        Company company = this.company_;
        return company == null ? Company.getDefaultInstance() : company;
    }

    @Override // proto.PlatformVersionCompanyOrBuilder
    public CompanyOrBuilder getCompanyOrBuilder() {
        Company company = this.company_;
        return company == null ? Company.getDefaultInstance() : company;
    }

    @Override // proto.PlatformVersionCompanyOrBuilder
    public boolean getDeveloper() {
        return this.developer_;
    }

    @Override // proto.PlatformVersionCompanyOrBuilder
    public boolean getManufacturer() {
        return this.manufacturer_;
    }

    @Override // proto.PlatformVersionCompanyOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionCompanyOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static PlatformVersionCompany parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PlatformVersionCompany parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlatformVersionCompany parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PlatformVersionCompany parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PlatformVersionCompany parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PlatformVersionCompany parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PlatformVersionCompany parseFrom(InputStream inputStream) throws IOException {
        return (PlatformVersionCompany) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PlatformVersionCompany parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersionCompany) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformVersionCompany parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PlatformVersionCompany) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlatformVersionCompany parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersionCompany) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformVersionCompany parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PlatformVersionCompany) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlatformVersionCompany parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersionCompany) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(PlatformVersionCompany platformVersionCompany) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) platformVersionCompany);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((PlatformVersionCompanyIA) null) : (Builder) new Builder((PlatformVersionCompanyIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlatformVersionCompanyOrBuilder {
        private int bitField0_;
        private Object checksum_;
        private Object comment_;
        private SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> companyBuilder_;
        private Company company_;
        private boolean developer_;
        private long id_;
        private boolean manufacturer_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, PlatformVersionCompanyIA platformVersionCompanyIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(PlatformVersionCompanyIA platformVersionCompanyIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_PlatformVersionCompany_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_PlatformVersionCompany_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformVersionCompany.class, Builder.class);
        }

        private Builder() {
            this.comment_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.comment_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (PlatformVersionCompany.alwaysUseFieldBuilders) {
                getCompanyFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.comment_ = "";
            this.company_ = null;
            SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.companyBuilder_ = null;
            }
            this.developer_ = false;
            this.manufacturer_ = false;
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_PlatformVersionCompany_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlatformVersionCompany getDefaultInstanceForType() {
            return PlatformVersionCompany.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformVersionCompany build() {
            PlatformVersionCompany platformVersionCompanyBuildPartial = buildPartial();
            if (platformVersionCompanyBuildPartial.isInitialized()) {
                return platformVersionCompanyBuildPartial;
            }
            throw newUninitializedMessageException((Message) platformVersionCompanyBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformVersionCompany buildPartial() {
            PlatformVersionCompany platformVersionCompany = new PlatformVersionCompany(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(platformVersionCompany);
            }
            onBuilt();
            return platformVersionCompany;
        }

        private void buildPartial0(PlatformVersionCompany platformVersionCompany) {
            int i;
            Company company;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                platformVersionCompany.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                platformVersionCompany.comment_ = this.comment_;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
                if (singleFieldBuilder == null) {
                    company = this.company_;
                } else {
                    company = (Company) singleFieldBuilder.build();
                }
                platformVersionCompany.company_ = company;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                platformVersionCompany.developer_ = this.developer_;
            }
            if ((i2 & 16) != 0) {
                platformVersionCompany.manufacturer_ = this.manufacturer_;
            }
            if ((i2 & 32) != 0) {
                platformVersionCompany.checksum_ = this.checksum_;
            }
            platformVersionCompany.bitField0_ |= i;
        }

        @Override // proto.PlatformVersionCompanyOrBuilder
        public long getId() {
            return this.id_;
        }

        public Builder setId(long j) {
            this.id_ = j;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder clearId() {
            this.bitField0_ &= -2;
            this.id_ = 0L;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionCompanyOrBuilder
        public String getComment() {
            Object obj = this.comment_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.comment_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionCompanyOrBuilder
        public ByteString getCommentBytes() {
            Object obj = this.comment_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.comment_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setComment(String str) {
            str.getClass();
            this.comment_ = str;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder clearComment() {
            this.comment_ = PlatformVersionCompany.getDefaultInstance().getComment();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder setCommentBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersionCompany.checkByteStringIsUtf8(byteString);
            this.comment_ = byteString;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionCompanyOrBuilder
        public boolean hasCompany() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // proto.PlatformVersionCompanyOrBuilder
        public Company getCompany() {
            SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
            if (singleFieldBuilder == null) {
                Company company = this.company_;
                return company == null ? Company.getDefaultInstance() : company;
            }
            return (Company) singleFieldBuilder.getMessage();
        }

        public Builder setCompany(Company company) {
            SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
            if (singleFieldBuilder == null) {
                company.getClass();
                this.company_ = company;
            } else {
                singleFieldBuilder.setMessage(company);
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setCompany(Company.Builder builder) {
            SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
            if (singleFieldBuilder == null) {
                this.company_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder mergeCompany(Company company) {
            Company company2;
            SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0 && (company2 = this.company_) != null && company2 != Company.getDefaultInstance()) {
                    getCompanyBuilder().mergeFrom((Message) company);
                } else {
                    this.company_ = company;
                }
            } else {
                singleFieldBuilder.mergeFrom(company);
            }
            if (this.company_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder clearCompany() {
            this.bitField0_ &= -5;
            this.company_ = null;
            SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.companyBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Company.Builder getCompanyBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (Company.Builder) getCompanyFieldBuilder().getBuilder();
        }

        @Override // proto.PlatformVersionCompanyOrBuilder
        public CompanyOrBuilder getCompanyOrBuilder() {
            SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
            if (singleFieldBuilder != null) {
                return (CompanyOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Company company = this.company_;
            return company == null ? Company.getDefaultInstance() : company;
        }

        private SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> getCompanyFieldBuilder() {
            if (this.companyBuilder_ == null) {
                this.companyBuilder_ = new SingleFieldBuilder<>(getCompany(), getParentForChildren(), isClean());
                this.company_ = null;
            }
            return this.companyBuilder_;
        }

        @Override // proto.PlatformVersionCompanyOrBuilder
        public boolean getDeveloper() {
            return this.developer_;
        }

        public Builder setDeveloper(boolean z) {
            this.developer_ = z;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder clearDeveloper() {
            this.bitField0_ &= -9;
            this.developer_ = false;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionCompanyOrBuilder
        public boolean getManufacturer() {
            return this.manufacturer_;
        }

        public Builder setManufacturer(boolean z) {
            this.manufacturer_ = z;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearManufacturer() {
            this.bitField0_ &= -17;
            this.manufacturer_ = false;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionCompanyOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionCompanyOrBuilder
        public ByteString getChecksumBytes() {
            Object obj = this.checksum_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.checksum_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setChecksum(String str) {
            str.getClass();
            this.checksum_ = str;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = PlatformVersionCompany.getDefaultInstance().getChecksum();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersionCompany.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }
    }

    public static PlatformVersionCompany getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.PlatformVersionCompany$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<PlatformVersionCompany> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public PlatformVersionCompany parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = PlatformVersionCompany.newBuilder();
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

    public static Parser<PlatformVersionCompany> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PlatformVersionCompany> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PlatformVersionCompany getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
