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
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public final class CompanyWebsite extends GeneratedMessage implements CompanyWebsiteOrBuilder {
    public static final int CATEGORY_FIELD_NUMBER = 2;
    public static final int CHECKSUM_FIELD_NUMBER = 5;
    private static final CompanyWebsite DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static final Parser<CompanyWebsite> PARSER;
    public static final int TRUSTED_FIELD_NUMBER = 3;
    public static final int URL_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private int category_;
    private volatile Object checksum_;
    private long id_;
    private boolean trusted_;
    private volatile Object url_;

    /* synthetic */ CompanyWebsite(GeneratedMessage.Builder builder, CompanyWebsiteIA companyWebsiteIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CompanyWebsite.class.getName());
        DEFAULT_INSTANCE = new CompanyWebsite();
        PARSER = new AnonymousClass1();
    }

    private CompanyWebsite(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.category_ = 0;
        this.trusted_ = false;
        this.url_ = "";
        this.checksum_ = "";
    }

    private CompanyWebsite() {
        this.id_ = 0L;
        this.category_ = 0;
        this.trusted_ = false;
        this.url_ = "";
        this.checksum_ = "";
        this.category_ = 0;
        this.url_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CompanyWebsite_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CompanyWebsite_fieldAccessorTable.ensureFieldAccessorsInitialized(CompanyWebsite.class, Builder.class);
    }

    @Override // proto.CompanyWebsiteOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.CompanyWebsiteOrBuilder
    public int getCategoryValue() {
        return this.category_;
    }

    @Override // proto.CompanyWebsiteOrBuilder
    public WebsiteCategoryEnum getCategory() {
        WebsiteCategoryEnum websiteCategoryEnumForNumber = WebsiteCategoryEnum.forNumber(this.category_);
        return websiteCategoryEnumForNumber == null ? WebsiteCategoryEnum.UNRECOGNIZED : websiteCategoryEnumForNumber;
    }

    @Override // proto.CompanyWebsiteOrBuilder
    public boolean getTrusted() {
        return this.trusted_;
    }

    @Override // proto.CompanyWebsiteOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CompanyWebsiteOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CompanyWebsiteOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CompanyWebsiteOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static CompanyWebsite parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CompanyWebsite parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CompanyWebsite parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CompanyWebsite parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CompanyWebsite parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CompanyWebsite parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CompanyWebsite parseFrom(InputStream inputStream) throws IOException {
        return (CompanyWebsite) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CompanyWebsite parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompanyWebsite) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CompanyWebsite parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CompanyWebsite) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CompanyWebsite parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompanyWebsite) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CompanyWebsite parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CompanyWebsite) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CompanyWebsite parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompanyWebsite) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CompanyWebsite companyWebsite) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) companyWebsite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CompanyWebsiteIA) null) : (Builder) new Builder((CompanyWebsiteIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CompanyWebsiteOrBuilder {
        private int bitField0_;
        private int category_;
        private Object checksum_;
        private long id_;
        private boolean trusted_;
        private Object url_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CompanyWebsiteIA companyWebsiteIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CompanyWebsiteIA companyWebsiteIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CompanyWebsite_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CompanyWebsite_fieldAccessorTable.ensureFieldAccessorsInitialized(CompanyWebsite.class, Builder.class);
        }

        private Builder() {
            this.category_ = 0;
            this.url_ = "";
            this.checksum_ = "";
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.category_ = 0;
            this.url_ = "";
            this.checksum_ = "";
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.category_ = 0;
            this.trusted_ = false;
            this.url_ = "";
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_CompanyWebsite_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CompanyWebsite getDefaultInstanceForType() {
            return CompanyWebsite.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CompanyWebsite build() {
            CompanyWebsite companyWebsiteBuildPartial = buildPartial();
            if (companyWebsiteBuildPartial.isInitialized()) {
                return companyWebsiteBuildPartial;
            }
            throw newUninitializedMessageException((Message) companyWebsiteBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CompanyWebsite buildPartial() {
            CompanyWebsite companyWebsite = new CompanyWebsite(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(companyWebsite);
            }
            onBuilt();
            return companyWebsite;
        }

        private void buildPartial0(CompanyWebsite companyWebsite) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                companyWebsite.id_ = this.id_;
            }
            if ((i & 2) != 0) {
                companyWebsite.category_ = this.category_;
            }
            if ((i & 4) != 0) {
                companyWebsite.trusted_ = this.trusted_;
            }
            if ((i & 8) != 0) {
                companyWebsite.url_ = this.url_;
            }
            if ((i & 16) != 0) {
                companyWebsite.checksum_ = this.checksum_;
            }
        }

        @Override // proto.CompanyWebsiteOrBuilder
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

        @Override // proto.CompanyWebsiteOrBuilder
        public int getCategoryValue() {
            return this.category_;
        }

        public Builder setCategoryValue(int i) {
            this.category_ = i;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.CompanyWebsiteOrBuilder
        public WebsiteCategoryEnum getCategory() {
            WebsiteCategoryEnum websiteCategoryEnumForNumber = WebsiteCategoryEnum.forNumber(this.category_);
            return websiteCategoryEnumForNumber == null ? WebsiteCategoryEnum.UNRECOGNIZED : websiteCategoryEnumForNumber;
        }

        public Builder setCategory(WebsiteCategoryEnum websiteCategoryEnum) {
            websiteCategoryEnum.getClass();
            this.bitField0_ |= 2;
            this.category_ = websiteCategoryEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearCategory() {
            this.bitField0_ &= -3;
            this.category_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.CompanyWebsiteOrBuilder
        public boolean getTrusted() {
            return this.trusted_;
        }

        public Builder setTrusted(boolean z) {
            this.trusted_ = z;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearTrusted() {
            this.bitField0_ &= -5;
            this.trusted_ = false;
            onChanged();
            return this;
        }

        @Override // proto.CompanyWebsiteOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CompanyWebsiteOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setUrl(String str) {
            str.getClass();
            this.url_ = str;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = CompanyWebsite.getDefaultInstance().getUrl();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            CompanyWebsite.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // proto.CompanyWebsiteOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CompanyWebsiteOrBuilder
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
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = CompanyWebsite.getDefaultInstance().getChecksum();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            CompanyWebsite.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }
    }

    public static CompanyWebsite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.CompanyWebsite$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CompanyWebsite> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CompanyWebsite parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CompanyWebsite.newBuilder();
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

    public static Parser<CompanyWebsite> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CompanyWebsite> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CompanyWebsite getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
