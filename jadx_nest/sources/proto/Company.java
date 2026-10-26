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
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public final class Company extends GeneratedMessage implements CompanyOrBuilder {
    public static final int CHANGED_COMPANY_ID_FIELD_NUMBER = 4;
    public static final int CHANGE_DATE_CATEGORY_FIELD_NUMBER = 3;
    public static final int CHANGE_DATE_FIELD_NUMBER = 2;
    public static final int CHECKSUM_FIELD_NUMBER = 19;
    public static final int COUNTRY_FIELD_NUMBER = 5;
    public static final int CREATED_AT_FIELD_NUMBER = 6;
    private static final Company DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 7;
    public static final int DEVELOPED_FIELD_NUMBER = 8;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int LOGO_FIELD_NUMBER = 9;
    public static final int NAME_FIELD_NUMBER = 10;
    public static final int PARENT_FIELD_NUMBER = 11;
    private static final Parser<Company> PARSER;
    public static final int PUBLISHED_FIELD_NUMBER = 12;
    public static final int SLUG_FIELD_NUMBER = 13;
    public static final int START_DATE_CATEGORY_FIELD_NUMBER = 15;
    public static final int START_DATE_FIELD_NUMBER = 14;
    public static final int UPDATED_AT_FIELD_NUMBER = 16;
    public static final int URL_FIELD_NUMBER = 17;
    public static final int WEBSITES_FIELD_NUMBER = 18;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int changeDateCategory_;
    private Timestamp changeDate_;
    private Company changedCompanyId_;
    private volatile Object checksum_;
    private int country_;
    private Timestamp createdAt_;
    private volatile Object description_;
    private List<Game> developed_;
    private long id_;
    private CompanyLogo logo_;
    private volatile Object name_;
    private Company parent_;
    private List<Game> published_;
    private volatile Object slug_;
    private int startDateCategory_;
    private Timestamp startDate_;
    private Timestamp updatedAt_;
    private volatile Object url_;
    private List<CompanyWebsite> websites_;

    /* synthetic */ Company(GeneratedMessage.Builder builder, CompanyIA companyIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Company.class.getName());
        DEFAULT_INSTANCE = new Company();
        PARSER = new AnonymousClass1();
    }

    private Company(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.changeDateCategory_ = 0;
        this.country_ = 0;
        this.description_ = "";
        this.name_ = "";
        this.slug_ = "";
        this.startDateCategory_ = 0;
        this.url_ = "";
        this.checksum_ = "";
    }

    private Company() {
        this.id_ = 0L;
        this.changeDateCategory_ = 0;
        this.country_ = 0;
        this.description_ = "";
        this.name_ = "";
        this.slug_ = "";
        this.startDateCategory_ = 0;
        this.url_ = "";
        this.checksum_ = "";
        this.changeDateCategory_ = 0;
        this.description_ = "";
        this.developed_ = Collections.emptyList();
        this.name_ = "";
        this.published_ = Collections.emptyList();
        this.slug_ = "";
        this.startDateCategory_ = 0;
        this.url_ = "";
        this.websites_ = Collections.emptyList();
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_Company_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_Company_fieldAccessorTable.ensureFieldAccessorsInitialized(Company.class, Builder.class);
    }

    @Override // proto.CompanyOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.CompanyOrBuilder
    public boolean hasChangeDate() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.CompanyOrBuilder
    public Timestamp getChangeDate() {
        Timestamp timestamp = this.changeDate_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CompanyOrBuilder
    public TimestampOrBuilder getChangeDateOrBuilder() {
        Timestamp timestamp = this.changeDate_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CompanyOrBuilder
    public int getChangeDateCategoryValue() {
        return this.changeDateCategory_;
    }

    @Override // proto.CompanyOrBuilder
    public DateFormatChangeDateCategoryEnum getChangeDateCategory() {
        DateFormatChangeDateCategoryEnum dateFormatChangeDateCategoryEnumForNumber = DateFormatChangeDateCategoryEnum.forNumber(this.changeDateCategory_);
        return dateFormatChangeDateCategoryEnumForNumber == null ? DateFormatChangeDateCategoryEnum.UNRECOGNIZED : dateFormatChangeDateCategoryEnumForNumber;
    }

    @Override // proto.CompanyOrBuilder
    public boolean hasChangedCompanyId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.CompanyOrBuilder
    public Company getChangedCompanyId() {
        Company company = this.changedCompanyId_;
        return company == null ? getDefaultInstance() : company;
    }

    @Override // proto.CompanyOrBuilder
    public CompanyOrBuilder getChangedCompanyIdOrBuilder() {
        Company company = this.changedCompanyId_;
        return company == null ? getDefaultInstance() : company;
    }

    @Override // proto.CompanyOrBuilder
    public int getCountry() {
        return this.country_;
    }

    @Override // proto.CompanyOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.CompanyOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CompanyOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CompanyOrBuilder
    public String getDescription() {
        Object obj = this.description_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.description_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CompanyOrBuilder
    public ByteString getDescriptionBytes() {
        Object obj = this.description_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.description_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CompanyOrBuilder
    public List<Game> getDevelopedList() {
        return this.developed_;
    }

    @Override // proto.CompanyOrBuilder
    public List<? extends GameOrBuilder> getDevelopedOrBuilderList() {
        return this.developed_;
    }

    @Override // proto.CompanyOrBuilder
    public int getDevelopedCount() {
        return this.developed_.size();
    }

    @Override // proto.CompanyOrBuilder
    public Game getDeveloped(int i) {
        return this.developed_.get(i);
    }

    @Override // proto.CompanyOrBuilder
    public GameOrBuilder getDevelopedOrBuilder(int i) {
        return this.developed_.get(i);
    }

    @Override // proto.CompanyOrBuilder
    public boolean hasLogo() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // proto.CompanyOrBuilder
    public CompanyLogo getLogo() {
        CompanyLogo companyLogo = this.logo_;
        return companyLogo == null ? CompanyLogo.getDefaultInstance() : companyLogo;
    }

    @Override // proto.CompanyOrBuilder
    public CompanyLogoOrBuilder getLogoOrBuilder() {
        CompanyLogo companyLogo = this.logo_;
        return companyLogo == null ? CompanyLogo.getDefaultInstance() : companyLogo;
    }

    @Override // proto.CompanyOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CompanyOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CompanyOrBuilder
    public boolean hasParent() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // proto.CompanyOrBuilder
    public Company getParent() {
        Company company = this.parent_;
        return company == null ? getDefaultInstance() : company;
    }

    @Override // proto.CompanyOrBuilder
    public CompanyOrBuilder getParentOrBuilder() {
        Company company = this.parent_;
        return company == null ? getDefaultInstance() : company;
    }

    @Override // proto.CompanyOrBuilder
    public List<Game> getPublishedList() {
        return this.published_;
    }

    @Override // proto.CompanyOrBuilder
    public List<? extends GameOrBuilder> getPublishedOrBuilderList() {
        return this.published_;
    }

    @Override // proto.CompanyOrBuilder
    public int getPublishedCount() {
        return this.published_.size();
    }

    @Override // proto.CompanyOrBuilder
    public Game getPublished(int i) {
        return this.published_.get(i);
    }

    @Override // proto.CompanyOrBuilder
    public GameOrBuilder getPublishedOrBuilder(int i) {
        return this.published_.get(i);
    }

    @Override // proto.CompanyOrBuilder
    public String getSlug() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.slug_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CompanyOrBuilder
    public ByteString getSlugBytes() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.slug_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CompanyOrBuilder
    public boolean hasStartDate() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // proto.CompanyOrBuilder
    public Timestamp getStartDate() {
        Timestamp timestamp = this.startDate_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CompanyOrBuilder
    public TimestampOrBuilder getStartDateOrBuilder() {
        Timestamp timestamp = this.startDate_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CompanyOrBuilder
    public int getStartDateCategoryValue() {
        return this.startDateCategory_;
    }

    @Override // proto.CompanyOrBuilder
    public DateFormatChangeDateCategoryEnum getStartDateCategory() {
        DateFormatChangeDateCategoryEnum dateFormatChangeDateCategoryEnumForNumber = DateFormatChangeDateCategoryEnum.forNumber(this.startDateCategory_);
        return dateFormatChangeDateCategoryEnumForNumber == null ? DateFormatChangeDateCategoryEnum.UNRECOGNIZED : dateFormatChangeDateCategoryEnumForNumber;
    }

    @Override // proto.CompanyOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 64) != 0;
    }

    @Override // proto.CompanyOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CompanyOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CompanyOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CompanyOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CompanyOrBuilder
    public List<CompanyWebsite> getWebsitesList() {
        return this.websites_;
    }

    @Override // proto.CompanyOrBuilder
    public List<? extends CompanyWebsiteOrBuilder> getWebsitesOrBuilderList() {
        return this.websites_;
    }

    @Override // proto.CompanyOrBuilder
    public int getWebsitesCount() {
        return this.websites_.size();
    }

    @Override // proto.CompanyOrBuilder
    public CompanyWebsite getWebsites(int i) {
        return this.websites_.get(i);
    }

    @Override // proto.CompanyOrBuilder
    public CompanyWebsiteOrBuilder getWebsitesOrBuilder(int i) {
        return this.websites_.get(i);
    }

    @Override // proto.CompanyOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CompanyOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static Company parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Company parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Company parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Company parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Company parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Company parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Company parseFrom(InputStream inputStream) throws IOException {
        return (Company) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Company parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Company) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Company parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Company) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Company parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Company) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Company parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Company) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Company parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Company) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(Company company) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) company);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CompanyIA) null) : (Builder) new Builder((CompanyIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CompanyOrBuilder {
        private int bitField0_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> changeDateBuilder_;
        private int changeDateCategory_;
        private Timestamp changeDate_;
        private SingleFieldBuilder<Company, Builder, CompanyOrBuilder> changedCompanyIdBuilder_;
        private Company changedCompanyId_;
        private Object checksum_;
        private int country_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private Object description_;
        private RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> developedBuilder_;
        private List<Game> developed_;
        private long id_;
        private SingleFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> logoBuilder_;
        private CompanyLogo logo_;
        private Object name_;
        private SingleFieldBuilder<Company, Builder, CompanyOrBuilder> parentBuilder_;
        private Company parent_;
        private RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> publishedBuilder_;
        private List<Game> published_;
        private Object slug_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> startDateBuilder_;
        private int startDateCategory_;
        private Timestamp startDate_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;
        private Object url_;
        private RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> websitesBuilder_;
        private List<CompanyWebsite> websites_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CompanyIA companyIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CompanyIA companyIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_Company_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_Company_fieldAccessorTable.ensureFieldAccessorsInitialized(Company.class, Builder.class);
        }

        private Builder() {
            this.changeDateCategory_ = 0;
            this.description_ = "";
            this.developed_ = Collections.emptyList();
            this.name_ = "";
            this.published_ = Collections.emptyList();
            this.slug_ = "";
            this.startDateCategory_ = 0;
            this.url_ = "";
            this.websites_ = Collections.emptyList();
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.changeDateCategory_ = 0;
            this.description_ = "";
            this.developed_ = Collections.emptyList();
            this.name_ = "";
            this.published_ = Collections.emptyList();
            this.slug_ = "";
            this.startDateCategory_ = 0;
            this.url_ = "";
            this.websites_ = Collections.emptyList();
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (Company.alwaysUseFieldBuilders) {
                getChangeDateFieldBuilder();
                getChangedCompanyIdFieldBuilder();
                getCreatedAtFieldBuilder();
                getDevelopedFieldBuilder();
                getLogoFieldBuilder();
                getParentFieldBuilder();
                getPublishedFieldBuilder();
                getStartDateFieldBuilder();
                getUpdatedAtFieldBuilder();
                getWebsitesFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.changeDate_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.changeDateBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.changeDateBuilder_ = null;
            }
            this.changeDateCategory_ = 0;
            this.changedCompanyId_ = null;
            SingleFieldBuilder<Company, Builder, CompanyOrBuilder> singleFieldBuilder2 = this.changedCompanyIdBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.changedCompanyIdBuilder_ = null;
            }
            this.country_ = 0;
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.createdAtBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.createdAtBuilder_ = null;
            }
            this.description_ = "";
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.developedBuilder_;
            if (repeatedFieldBuilder == null) {
                this.developed_ = Collections.emptyList();
            } else {
                this.developed_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -129;
            this.logo_ = null;
            SingleFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> singleFieldBuilder4 = this.logoBuilder_;
            if (singleFieldBuilder4 != null) {
                singleFieldBuilder4.dispose();
                this.logoBuilder_ = null;
            }
            this.name_ = "";
            this.parent_ = null;
            SingleFieldBuilder<Company, Builder, CompanyOrBuilder> singleFieldBuilder5 = this.parentBuilder_;
            if (singleFieldBuilder5 != null) {
                singleFieldBuilder5.dispose();
                this.parentBuilder_ = null;
            }
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder2 = this.publishedBuilder_;
            if (repeatedFieldBuilder2 == null) {
                this.published_ = Collections.emptyList();
            } else {
                this.published_ = null;
                repeatedFieldBuilder2.clear();
            }
            this.bitField0_ &= -2049;
            this.slug_ = "";
            this.startDate_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder6 = this.startDateBuilder_;
            if (singleFieldBuilder6 != null) {
                singleFieldBuilder6.dispose();
                this.startDateBuilder_ = null;
            }
            this.startDateCategory_ = 0;
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder7 = this.updatedAtBuilder_;
            if (singleFieldBuilder7 != null) {
                singleFieldBuilder7.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.url_ = "";
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder3 = this.websitesBuilder_;
            if (repeatedFieldBuilder3 == null) {
                this.websites_ = Collections.emptyList();
            } else {
                this.websites_ = null;
                repeatedFieldBuilder3.clear();
            }
            this.bitField0_ &= -131073;
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_Company_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Company getDefaultInstanceForType() {
            return Company.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Company build() {
            Company companyBuildPartial = buildPartial();
            if (companyBuildPartial.isInitialized()) {
                return companyBuildPartial;
            }
            throw newUninitializedMessageException((Message) companyBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Company buildPartial() {
            Company company = new Company(this, null);
            buildPartialRepeatedFields(company);
            if (this.bitField0_ != 0) {
                buildPartial0(company);
            }
            onBuilt();
            return company;
        }

        private void buildPartialRepeatedFields(Company company) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.developedBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 128) != 0) {
                    this.developed_ = Collections.unmodifiableList(this.developed_);
                    this.bitField0_ &= -129;
                }
                company.developed_ = this.developed_;
            } else {
                company.developed_ = repeatedFieldBuilder.build();
            }
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder2 = this.publishedBuilder_;
            if (repeatedFieldBuilder2 == null) {
                if ((this.bitField0_ & 2048) != 0) {
                    this.published_ = Collections.unmodifiableList(this.published_);
                    this.bitField0_ &= -2049;
                }
                company.published_ = this.published_;
            } else {
                company.published_ = repeatedFieldBuilder2.build();
            }
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder3 = this.websitesBuilder_;
            if (repeatedFieldBuilder3 == null) {
                if ((this.bitField0_ & 131072) != 0) {
                    this.websites_ = Collections.unmodifiableList(this.websites_);
                    this.bitField0_ &= -131073;
                }
                company.websites_ = this.websites_;
                return;
            }
            company.websites_ = repeatedFieldBuilder3.build();
        }

        private void buildPartial0(Company company) {
            int i;
            Timestamp timestamp;
            Timestamp timestamp2;
            Company company2;
            CompanyLogo companyLogo;
            Timestamp timestamp3;
            Company company3;
            Timestamp timestamp4;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                company.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.changeDateBuilder_;
                if (singleFieldBuilder == null) {
                    timestamp4 = this.changeDate_;
                } else {
                    timestamp4 = (Timestamp) singleFieldBuilder.build();
                }
                company.changeDate_ = timestamp4;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                company.changeDateCategory_ = this.changeDateCategory_;
            }
            if ((i2 & 8) != 0) {
                SingleFieldBuilder<Company, Builder, CompanyOrBuilder> singleFieldBuilder2 = this.changedCompanyIdBuilder_;
                if (singleFieldBuilder2 == null) {
                    company3 = this.changedCompanyId_;
                } else {
                    company3 = (Company) singleFieldBuilder2.build();
                }
                company.changedCompanyId_ = company3;
                i |= 2;
            }
            if ((i2 & 16) != 0) {
                company.country_ = this.country_;
            }
            if ((i2 & 32) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.createdAtBuilder_;
                if (singleFieldBuilder3 == null) {
                    timestamp3 = this.createdAt_;
                } else {
                    timestamp3 = (Timestamp) singleFieldBuilder3.build();
                }
                company.createdAt_ = timestamp3;
                i |= 4;
            }
            if ((i2 & 64) != 0) {
                company.description_ = this.description_;
            }
            if ((i2 & 256) != 0) {
                SingleFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> singleFieldBuilder4 = this.logoBuilder_;
                if (singleFieldBuilder4 == null) {
                    companyLogo = this.logo_;
                } else {
                    companyLogo = (CompanyLogo) singleFieldBuilder4.build();
                }
                company.logo_ = companyLogo;
                i |= 8;
            }
            if ((i2 & 512) != 0) {
                company.name_ = this.name_;
            }
            if ((i2 & 1024) != 0) {
                SingleFieldBuilder<Company, Builder, CompanyOrBuilder> singleFieldBuilder5 = this.parentBuilder_;
                if (singleFieldBuilder5 == null) {
                    company2 = this.parent_;
                } else {
                    company2 = (Company) singleFieldBuilder5.build();
                }
                company.parent_ = company2;
                i |= 16;
            }
            if ((i2 & 4096) != 0) {
                company.slug_ = this.slug_;
            }
            if ((i2 & 8192) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder6 = this.startDateBuilder_;
                if (singleFieldBuilder6 == null) {
                    timestamp2 = this.startDate_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder6.build();
                }
                company.startDate_ = timestamp2;
                i |= 32;
            }
            if ((i2 & 16384) != 0) {
                company.startDateCategory_ = this.startDateCategory_;
            }
            if ((32768 & i2) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder7 = this.updatedAtBuilder_;
                if (singleFieldBuilder7 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder7.build();
                }
                company.updatedAt_ = timestamp;
                i |= 64;
            }
            if ((65536 & i2) != 0) {
                company.url_ = this.url_;
            }
            if ((i2 & 262144) != 0) {
                company.checksum_ = this.checksum_;
            }
            company.bitField0_ |= i;
        }

        @Override // proto.CompanyOrBuilder
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

        @Override // proto.CompanyOrBuilder
        public boolean hasChangeDate() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // proto.CompanyOrBuilder
        public Timestamp getChangeDate() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.changeDateBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.changeDate_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setChangeDate(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.changeDateBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.changeDate_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setChangeDate(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.changeDateBuilder_;
            if (singleFieldBuilder == null) {
                this.changeDate_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder mergeChangeDate(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.changeDateBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 2) != 0 && (timestamp2 = this.changeDate_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getChangeDateBuilder().mergeFrom(timestamp);
                } else {
                    this.changeDate_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.changeDate_ != null) {
                this.bitField0_ |= 2;
                onChanged();
            }
            return this;
        }

        public Builder clearChangeDate() {
            this.bitField0_ &= -3;
            this.changeDate_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.changeDateBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.changeDateBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getChangeDateBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (Timestamp.Builder) getChangeDateFieldBuilder().getBuilder();
        }

        @Override // proto.CompanyOrBuilder
        public TimestampOrBuilder getChangeDateOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.changeDateBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.changeDate_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getChangeDateFieldBuilder() {
            if (this.changeDateBuilder_ == null) {
                this.changeDateBuilder_ = new SingleFieldBuilder<>(getChangeDate(), getParentForChildren(), isClean());
                this.changeDate_ = null;
            }
            return this.changeDateBuilder_;
        }

        @Override // proto.CompanyOrBuilder
        public int getChangeDateCategoryValue() {
            return this.changeDateCategory_;
        }

        public Builder setChangeDateCategoryValue(int i) {
            this.changeDateCategory_ = i;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // proto.CompanyOrBuilder
        public DateFormatChangeDateCategoryEnum getChangeDateCategory() {
            DateFormatChangeDateCategoryEnum dateFormatChangeDateCategoryEnumForNumber = DateFormatChangeDateCategoryEnum.forNumber(this.changeDateCategory_);
            return dateFormatChangeDateCategoryEnumForNumber == null ? DateFormatChangeDateCategoryEnum.UNRECOGNIZED : dateFormatChangeDateCategoryEnumForNumber;
        }

        public Builder setChangeDateCategory(DateFormatChangeDateCategoryEnum dateFormatChangeDateCategoryEnum) {
            dateFormatChangeDateCategoryEnum.getClass();
            this.bitField0_ |= 4;
            this.changeDateCategory_ = dateFormatChangeDateCategoryEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearChangeDateCategory() {
            this.bitField0_ &= -5;
            this.changeDateCategory_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.CompanyOrBuilder
        public boolean hasChangedCompanyId() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // proto.CompanyOrBuilder
        public Company getChangedCompanyId() {
            SingleFieldBuilder<Company, Builder, CompanyOrBuilder> singleFieldBuilder = this.changedCompanyIdBuilder_;
            if (singleFieldBuilder == null) {
                Company company = this.changedCompanyId_;
                return company == null ? Company.getDefaultInstance() : company;
            }
            return (Company) singleFieldBuilder.getMessage();
        }

        public Builder setChangedCompanyId(Company company) {
            SingleFieldBuilder<Company, Builder, CompanyOrBuilder> singleFieldBuilder = this.changedCompanyIdBuilder_;
            if (singleFieldBuilder == null) {
                company.getClass();
                this.changedCompanyId_ = company;
            } else {
                singleFieldBuilder.setMessage(company);
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setChangedCompanyId(Builder builder) {
            SingleFieldBuilder<Company, Builder, CompanyOrBuilder> singleFieldBuilder = this.changedCompanyIdBuilder_;
            if (singleFieldBuilder == null) {
                this.changedCompanyId_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder mergeChangedCompanyId(Company company) {
            Company company2;
            SingleFieldBuilder<Company, Builder, CompanyOrBuilder> singleFieldBuilder = this.changedCompanyIdBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 8) != 0 && (company2 = this.changedCompanyId_) != null && company2 != Company.getDefaultInstance()) {
                    getChangedCompanyIdBuilder().mergeFrom((Message) company);
                } else {
                    this.changedCompanyId_ = company;
                }
            } else {
                singleFieldBuilder.mergeFrom(company);
            }
            if (this.changedCompanyId_ != null) {
                this.bitField0_ |= 8;
                onChanged();
            }
            return this;
        }

        public Builder clearChangedCompanyId() {
            this.bitField0_ &= -9;
            this.changedCompanyId_ = null;
            SingleFieldBuilder<Company, Builder, CompanyOrBuilder> singleFieldBuilder = this.changedCompanyIdBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.changedCompanyIdBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder getChangedCompanyIdBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (Builder) getChangedCompanyIdFieldBuilder().getBuilder();
        }

        @Override // proto.CompanyOrBuilder
        public CompanyOrBuilder getChangedCompanyIdOrBuilder() {
            SingleFieldBuilder<Company, Builder, CompanyOrBuilder> singleFieldBuilder = this.changedCompanyIdBuilder_;
            if (singleFieldBuilder != null) {
                return (CompanyOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Company company = this.changedCompanyId_;
            return company == null ? Company.getDefaultInstance() : company;
        }

        private SingleFieldBuilder<Company, Builder, CompanyOrBuilder> getChangedCompanyIdFieldBuilder() {
            if (this.changedCompanyIdBuilder_ == null) {
                this.changedCompanyIdBuilder_ = new SingleFieldBuilder<>(getChangedCompanyId(), getParentForChildren(), isClean());
                this.changedCompanyId_ = null;
            }
            return this.changedCompanyIdBuilder_;
        }

        @Override // proto.CompanyOrBuilder
        public int getCountry() {
            return this.country_;
        }

        public Builder setCountry(int i) {
            this.country_ = i;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearCountry() {
            this.bitField0_ &= -17;
            this.country_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.CompanyOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // proto.CompanyOrBuilder
        public Timestamp getCreatedAt() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.createdAt_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setCreatedAt(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.createdAt_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setCreatedAt(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                this.createdAt_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder mergeCreatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 32) != 0 && (timestamp2 = this.createdAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getCreatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.createdAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.createdAt_ != null) {
                this.bitField0_ |= 32;
                onChanged();
            }
            return this;
        }

        public Builder clearCreatedAt() {
            this.bitField0_ &= -33;
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.createdAtBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getCreatedAtBuilder() {
            this.bitField0_ |= 32;
            onChanged();
            return (Timestamp.Builder) getCreatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.CompanyOrBuilder
        public TimestampOrBuilder getCreatedAtOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.createdAt_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getCreatedAtFieldBuilder() {
            if (this.createdAtBuilder_ == null) {
                this.createdAtBuilder_ = new SingleFieldBuilder<>(getCreatedAt(), getParentForChildren(), isClean());
                this.createdAt_ = null;
            }
            return this.createdAtBuilder_;
        }

        @Override // proto.CompanyOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.description_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CompanyOrBuilder
        public ByteString getDescriptionBytes() {
            Object obj = this.description_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.description_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setDescription(String str) {
            str.getClass();
            this.description_ = str;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearDescription() {
            this.description_ = Company.getDefaultInstance().getDescription();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            byteString.getClass();
            Company.checkByteStringIsUtf8(byteString);
            this.description_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        private void ensureDevelopedIsMutable() {
            if ((this.bitField0_ & 128) == 0) {
                this.developed_ = new ArrayList(this.developed_);
                this.bitField0_ |= 128;
            }
        }

        @Override // proto.CompanyOrBuilder
        public List<Game> getDevelopedList() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.developedBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.developed_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CompanyOrBuilder
        public int getDevelopedCount() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.developedBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.developed_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CompanyOrBuilder
        public Game getDeveloped(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.developedBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.developed_.get(i);
            }
            return (Game) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setDeveloped(int i, Game game) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.developedBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureDevelopedIsMutable();
                this.developed_.set(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, game);
            return this;
        }

        public Builder setDeveloped(int i, Game.Builder builder) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.developedBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureDevelopedIsMutable();
                this.developed_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addDeveloped(Game game) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.developedBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureDevelopedIsMutable();
                this.developed_.add(game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(game);
            return this;
        }

        public Builder addDeveloped(int i, Game game) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.developedBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureDevelopedIsMutable();
                this.developed_.add(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, game);
            return this;
        }

        public Builder addDeveloped(Game.Builder builder) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.developedBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureDevelopedIsMutable();
                this.developed_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addDeveloped(int i, Game.Builder builder) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.developedBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureDevelopedIsMutable();
                this.developed_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllDeveloped(Iterable<? extends Game> iterable) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.developedBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureDevelopedIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.developed_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearDeveloped() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.developedBuilder_;
            if (repeatedFieldBuilder == null) {
                this.developed_ = Collections.emptyList();
                this.bitField0_ &= -129;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeDeveloped(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.developedBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureDevelopedIsMutable();
                this.developed_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Game.Builder getDevelopedBuilder(int i) {
            return (Game.Builder) getDevelopedFieldBuilder().getBuilder(i);
        }

        @Override // proto.CompanyOrBuilder
        public GameOrBuilder getDevelopedOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.developedBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.developed_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CompanyOrBuilder
        public List<? extends GameOrBuilder> getDevelopedOrBuilderList() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.developedBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.developed_);
        }

        public Game.Builder addDevelopedBuilder() {
            return (Game.Builder) getDevelopedFieldBuilder().addBuilder(Game.getDefaultInstance());
        }

        public Game.Builder addDevelopedBuilder(int i) {
            return (Game.Builder) getDevelopedFieldBuilder().addBuilder(i, Game.getDefaultInstance());
        }

        public List<Game.Builder> getDevelopedBuilderList() {
            return getDevelopedFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> getDevelopedFieldBuilder() {
            if (this.developedBuilder_ == null) {
                this.developedBuilder_ = new RepeatedFieldBuilder<>(this.developed_, (this.bitField0_ & 128) != 0, getParentForChildren(), isClean());
                this.developed_ = null;
            }
            return this.developedBuilder_;
        }

        @Override // proto.CompanyOrBuilder
        public boolean hasLogo() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // proto.CompanyOrBuilder
        public CompanyLogo getLogo() {
            SingleFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> singleFieldBuilder = this.logoBuilder_;
            if (singleFieldBuilder == null) {
                CompanyLogo companyLogo = this.logo_;
                return companyLogo == null ? CompanyLogo.getDefaultInstance() : companyLogo;
            }
            return (CompanyLogo) singleFieldBuilder.getMessage();
        }

        public Builder setLogo(CompanyLogo companyLogo) {
            SingleFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> singleFieldBuilder = this.logoBuilder_;
            if (singleFieldBuilder == null) {
                companyLogo.getClass();
                this.logo_ = companyLogo;
            } else {
                singleFieldBuilder.setMessage(companyLogo);
            }
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setLogo(CompanyLogo.Builder builder) {
            SingleFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> singleFieldBuilder = this.logoBuilder_;
            if (singleFieldBuilder == null) {
                this.logo_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder mergeLogo(CompanyLogo companyLogo) {
            CompanyLogo companyLogo2;
            SingleFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> singleFieldBuilder = this.logoBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 256) != 0 && (companyLogo2 = this.logo_) != null && companyLogo2 != CompanyLogo.getDefaultInstance()) {
                    getLogoBuilder().mergeFrom((Message) companyLogo);
                } else {
                    this.logo_ = companyLogo;
                }
            } else {
                singleFieldBuilder.mergeFrom(companyLogo);
            }
            if (this.logo_ != null) {
                this.bitField0_ |= 256;
                onChanged();
            }
            return this;
        }

        public Builder clearLogo() {
            this.bitField0_ &= -257;
            this.logo_ = null;
            SingleFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> singleFieldBuilder = this.logoBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.logoBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public CompanyLogo.Builder getLogoBuilder() {
            this.bitField0_ |= 256;
            onChanged();
            return (CompanyLogo.Builder) getLogoFieldBuilder().getBuilder();
        }

        @Override // proto.CompanyOrBuilder
        public CompanyLogoOrBuilder getLogoOrBuilder() {
            SingleFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> singleFieldBuilder = this.logoBuilder_;
            if (singleFieldBuilder != null) {
                return (CompanyLogoOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            CompanyLogo companyLogo = this.logo_;
            return companyLogo == null ? CompanyLogo.getDefaultInstance() : companyLogo;
        }

        private SingleFieldBuilder<CompanyLogo, CompanyLogo.Builder, CompanyLogoOrBuilder> getLogoFieldBuilder() {
            if (this.logoBuilder_ == null) {
                this.logoBuilder_ = new SingleFieldBuilder<>(getLogo(), getParentForChildren(), isClean());
                this.logo_ = null;
            }
            return this.logoBuilder_;
        }

        @Override // proto.CompanyOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CompanyOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setName(String str) {
            str.getClass();
            this.name_ = str;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Company.getDefaultInstance().getName();
            this.bitField0_ &= -513;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            Company.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        @Override // proto.CompanyOrBuilder
        public boolean hasParent() {
            return (this.bitField0_ & 1024) != 0;
        }

        @Override // proto.CompanyOrBuilder
        public Company getParent() {
            SingleFieldBuilder<Company, Builder, CompanyOrBuilder> singleFieldBuilder = this.parentBuilder_;
            if (singleFieldBuilder == null) {
                Company company = this.parent_;
                return company == null ? Company.getDefaultInstance() : company;
            }
            return (Company) singleFieldBuilder.getMessage();
        }

        public Builder setParent(Company company) {
            SingleFieldBuilder<Company, Builder, CompanyOrBuilder> singleFieldBuilder = this.parentBuilder_;
            if (singleFieldBuilder == null) {
                company.getClass();
                this.parent_ = company;
            } else {
                singleFieldBuilder.setMessage(company);
            }
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setParent(Builder builder) {
            SingleFieldBuilder<Company, Builder, CompanyOrBuilder> singleFieldBuilder = this.parentBuilder_;
            if (singleFieldBuilder == null) {
                this.parent_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder mergeParent(Company company) {
            Company company2;
            SingleFieldBuilder<Company, Builder, CompanyOrBuilder> singleFieldBuilder = this.parentBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 1024) != 0 && (company2 = this.parent_) != null && company2 != Company.getDefaultInstance()) {
                    getParentBuilder().mergeFrom((Message) company);
                } else {
                    this.parent_ = company;
                }
            } else {
                singleFieldBuilder.mergeFrom(company);
            }
            if (this.parent_ != null) {
                this.bitField0_ |= 1024;
                onChanged();
            }
            return this;
        }

        public Builder clearParent() {
            this.bitField0_ &= -1025;
            this.parent_ = null;
            SingleFieldBuilder<Company, Builder, CompanyOrBuilder> singleFieldBuilder = this.parentBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.parentBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder getParentBuilder() {
            this.bitField0_ |= 1024;
            onChanged();
            return (Builder) getParentFieldBuilder().getBuilder();
        }

        @Override // proto.CompanyOrBuilder
        public CompanyOrBuilder getParentOrBuilder() {
            SingleFieldBuilder<Company, Builder, CompanyOrBuilder> singleFieldBuilder = this.parentBuilder_;
            if (singleFieldBuilder != null) {
                return (CompanyOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Company company = this.parent_;
            return company == null ? Company.getDefaultInstance() : company;
        }

        private SingleFieldBuilder<Company, Builder, CompanyOrBuilder> getParentFieldBuilder() {
            if (this.parentBuilder_ == null) {
                this.parentBuilder_ = new SingleFieldBuilder<>(getParent(), getParentForChildren(), isClean());
                this.parent_ = null;
            }
            return this.parentBuilder_;
        }

        private void ensurePublishedIsMutable() {
            if ((this.bitField0_ & 2048) == 0) {
                this.published_ = new ArrayList(this.published_);
                this.bitField0_ |= 2048;
            }
        }

        @Override // proto.CompanyOrBuilder
        public List<Game> getPublishedList() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.publishedBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.published_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CompanyOrBuilder
        public int getPublishedCount() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.publishedBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.published_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CompanyOrBuilder
        public Game getPublished(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.publishedBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.published_.get(i);
            }
            return (Game) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setPublished(int i, Game game) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.publishedBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensurePublishedIsMutable();
                this.published_.set(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, game);
            return this;
        }

        public Builder setPublished(int i, Game.Builder builder) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.publishedBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePublishedIsMutable();
                this.published_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addPublished(Game game) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.publishedBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensurePublishedIsMutable();
                this.published_.add(game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(game);
            return this;
        }

        public Builder addPublished(int i, Game game) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.publishedBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensurePublishedIsMutable();
                this.published_.add(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, game);
            return this;
        }

        public Builder addPublished(Game.Builder builder) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.publishedBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePublishedIsMutable();
                this.published_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addPublished(int i, Game.Builder builder) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.publishedBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePublishedIsMutable();
                this.published_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllPublished(Iterable<? extends Game> iterable) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.publishedBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePublishedIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.published_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearPublished() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.publishedBuilder_;
            if (repeatedFieldBuilder == null) {
                this.published_ = Collections.emptyList();
                this.bitField0_ &= -2049;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removePublished(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.publishedBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePublishedIsMutable();
                this.published_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Game.Builder getPublishedBuilder(int i) {
            return (Game.Builder) getPublishedFieldBuilder().getBuilder(i);
        }

        @Override // proto.CompanyOrBuilder
        public GameOrBuilder getPublishedOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.publishedBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.published_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CompanyOrBuilder
        public List<? extends GameOrBuilder> getPublishedOrBuilderList() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.publishedBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.published_);
        }

        public Game.Builder addPublishedBuilder() {
            return (Game.Builder) getPublishedFieldBuilder().addBuilder(Game.getDefaultInstance());
        }

        public Game.Builder addPublishedBuilder(int i) {
            return (Game.Builder) getPublishedFieldBuilder().addBuilder(i, Game.getDefaultInstance());
        }

        public List<Game.Builder> getPublishedBuilderList() {
            return getPublishedFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> getPublishedFieldBuilder() {
            if (this.publishedBuilder_ == null) {
                this.publishedBuilder_ = new RepeatedFieldBuilder<>(this.published_, (this.bitField0_ & 2048) != 0, getParentForChildren(), isClean());
                this.published_ = null;
            }
            return this.publishedBuilder_;
        }

        @Override // proto.CompanyOrBuilder
        public String getSlug() {
            Object obj = this.slug_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.slug_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CompanyOrBuilder
        public ByteString getSlugBytes() {
            Object obj = this.slug_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.slug_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setSlug(String str) {
            str.getClass();
            this.slug_ = str;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder clearSlug() {
            this.slug_ = Company.getDefaultInstance().getSlug();
            this.bitField0_ &= -4097;
            onChanged();
            return this;
        }

        public Builder setSlugBytes(ByteString byteString) {
            byteString.getClass();
            Company.checkByteStringIsUtf8(byteString);
            this.slug_ = byteString;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        @Override // proto.CompanyOrBuilder
        public boolean hasStartDate() {
            return (this.bitField0_ & 8192) != 0;
        }

        @Override // proto.CompanyOrBuilder
        public Timestamp getStartDate() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.startDateBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.startDate_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setStartDate(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.startDateBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.startDate_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder setStartDate(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.startDateBuilder_;
            if (singleFieldBuilder == null) {
                this.startDate_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder mergeStartDate(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.startDateBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 8192) != 0 && (timestamp2 = this.startDate_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getStartDateBuilder().mergeFrom(timestamp);
                } else {
                    this.startDate_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.startDate_ != null) {
                this.bitField0_ |= 8192;
                onChanged();
            }
            return this;
        }

        public Builder clearStartDate() {
            this.bitField0_ &= -8193;
            this.startDate_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.startDateBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.startDateBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getStartDateBuilder() {
            this.bitField0_ |= 8192;
            onChanged();
            return (Timestamp.Builder) getStartDateFieldBuilder().getBuilder();
        }

        @Override // proto.CompanyOrBuilder
        public TimestampOrBuilder getStartDateOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.startDateBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.startDate_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getStartDateFieldBuilder() {
            if (this.startDateBuilder_ == null) {
                this.startDateBuilder_ = new SingleFieldBuilder<>(getStartDate(), getParentForChildren(), isClean());
                this.startDate_ = null;
            }
            return this.startDateBuilder_;
        }

        @Override // proto.CompanyOrBuilder
        public int getStartDateCategoryValue() {
            return this.startDateCategory_;
        }

        public Builder setStartDateCategoryValue(int i) {
            this.startDateCategory_ = i;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        @Override // proto.CompanyOrBuilder
        public DateFormatChangeDateCategoryEnum getStartDateCategory() {
            DateFormatChangeDateCategoryEnum dateFormatChangeDateCategoryEnumForNumber = DateFormatChangeDateCategoryEnum.forNumber(this.startDateCategory_);
            return dateFormatChangeDateCategoryEnumForNumber == null ? DateFormatChangeDateCategoryEnum.UNRECOGNIZED : dateFormatChangeDateCategoryEnumForNumber;
        }

        public Builder setStartDateCategory(DateFormatChangeDateCategoryEnum dateFormatChangeDateCategoryEnum) {
            dateFormatChangeDateCategoryEnum.getClass();
            this.bitField0_ |= 16384;
            this.startDateCategory_ = dateFormatChangeDateCategoryEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearStartDateCategory() {
            this.bitField0_ &= -16385;
            this.startDateCategory_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.CompanyOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 32768) != 0;
        }

        @Override // proto.CompanyOrBuilder
        public Timestamp getUpdatedAt() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.updatedAt_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setUpdatedAt(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.updatedAt_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        public Builder setUpdatedAt(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                this.updatedAt_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        public Builder mergeUpdatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 32768) != 0 && (timestamp2 = this.updatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getUpdatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.updatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.updatedAt_ != null) {
                this.bitField0_ |= 32768;
                onChanged();
            }
            return this;
        }

        public Builder clearUpdatedAt() {
            this.bitField0_ &= -32769;
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.updatedAtBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getUpdatedAtBuilder() {
            this.bitField0_ |= 32768;
            onChanged();
            return (Timestamp.Builder) getUpdatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.CompanyOrBuilder
        public TimestampOrBuilder getUpdatedAtOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.updatedAt_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getUpdatedAtFieldBuilder() {
            if (this.updatedAtBuilder_ == null) {
                this.updatedAtBuilder_ = new SingleFieldBuilder<>(getUpdatedAt(), getParentForChildren(), isClean());
                this.updatedAt_ = null;
            }
            return this.updatedAtBuilder_;
        }

        @Override // proto.CompanyOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CompanyOrBuilder
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
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = Company.getDefaultInstance().getUrl();
            this.bitField0_ &= -65537;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            Company.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        private void ensureWebsitesIsMutable() {
            if ((this.bitField0_ & 131072) == 0) {
                this.websites_ = new ArrayList(this.websites_);
                this.bitField0_ |= 131072;
            }
        }

        @Override // proto.CompanyOrBuilder
        public List<CompanyWebsite> getWebsitesList() {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.websites_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CompanyOrBuilder
        public int getWebsitesCount() {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.websites_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CompanyOrBuilder
        public CompanyWebsite getWebsites(int i) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.websites_.get(i);
            }
            return (CompanyWebsite) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setWebsites(int i, CompanyWebsite companyWebsite) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                companyWebsite.getClass();
                ensureWebsitesIsMutable();
                this.websites_.set(i, companyWebsite);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, companyWebsite);
            return this;
        }

        public Builder setWebsites(int i, CompanyWebsite.Builder builder) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                this.websites_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addWebsites(CompanyWebsite companyWebsite) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                companyWebsite.getClass();
                ensureWebsitesIsMutable();
                this.websites_.add(companyWebsite);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(companyWebsite);
            return this;
        }

        public Builder addWebsites(int i, CompanyWebsite companyWebsite) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                companyWebsite.getClass();
                ensureWebsitesIsMutable();
                this.websites_.add(i, companyWebsite);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, companyWebsite);
            return this;
        }

        public Builder addWebsites(CompanyWebsite.Builder builder) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                this.websites_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addWebsites(int i, CompanyWebsite.Builder builder) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                this.websites_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllWebsites(Iterable<? extends CompanyWebsite> iterable) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.websites_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearWebsites() {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.websites_ = Collections.emptyList();
                this.bitField0_ &= -131073;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeWebsites(int i) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                this.websites_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public CompanyWebsite.Builder getWebsitesBuilder(int i) {
            return (CompanyWebsite.Builder) getWebsitesFieldBuilder().getBuilder(i);
        }

        @Override // proto.CompanyOrBuilder
        public CompanyWebsiteOrBuilder getWebsitesOrBuilder(int i) {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.websites_.get(i);
            }
            return (CompanyWebsiteOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CompanyOrBuilder
        public List<? extends CompanyWebsiteOrBuilder> getWebsitesOrBuilderList() {
            RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.websites_);
        }

        public CompanyWebsite.Builder addWebsitesBuilder() {
            return (CompanyWebsite.Builder) getWebsitesFieldBuilder().addBuilder(CompanyWebsite.getDefaultInstance());
        }

        public CompanyWebsite.Builder addWebsitesBuilder(int i) {
            return (CompanyWebsite.Builder) getWebsitesFieldBuilder().addBuilder(i, CompanyWebsite.getDefaultInstance());
        }

        public List<CompanyWebsite.Builder> getWebsitesBuilderList() {
            return getWebsitesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<CompanyWebsite, CompanyWebsite.Builder, CompanyWebsiteOrBuilder> getWebsitesFieldBuilder() {
            if (this.websitesBuilder_ == null) {
                this.websitesBuilder_ = new RepeatedFieldBuilder<>(this.websites_, (this.bitField0_ & 131072) != 0, getParentForChildren(), isClean());
                this.websites_ = null;
            }
            return this.websitesBuilder_;
        }

        @Override // proto.CompanyOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CompanyOrBuilder
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
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = Company.getDefaultInstance().getChecksum();
            this.bitField0_ &= -262145;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            Company.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        }
    }

    public static Company getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.Company$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Company> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public Company parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Company.newBuilder();
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

    public static Parser<Company> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Company> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Company getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
