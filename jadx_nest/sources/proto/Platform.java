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

/* JADX INFO: loaded from: classes6.dex */
public final class Platform extends GeneratedMessage implements PlatformOrBuilder {
    public static final int ABBREVIATION_FIELD_NUMBER = 2;
    public static final int ALTERNATIVE_NAME_FIELD_NUMBER = 3;
    public static final int CATEGORY_FIELD_NUMBER = 4;
    public static final int CHECKSUM_FIELD_NUMBER = 16;
    public static final int CREATED_AT_FIELD_NUMBER = 5;
    private static final Platform DEFAULT_INSTANCE;
    public static final int GENERATION_FIELD_NUMBER = 6;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 7;
    private static final Parser<Platform> PARSER;
    public static final int PLATFORM_FAMILY_FIELD_NUMBER = 9;
    public static final int PLATFORM_LOGO_FIELD_NUMBER = 8;
    public static final int SLUG_FIELD_NUMBER = 10;
    public static final int SUMMARY_FIELD_NUMBER = 11;
    public static final int UPDATED_AT_FIELD_NUMBER = 12;
    public static final int URL_FIELD_NUMBER = 13;
    public static final int VERSIONS_FIELD_NUMBER = 14;
    public static final int WEBSITES_FIELD_NUMBER = 15;
    private static final long serialVersionUID = 0;
    private volatile Object abbreviation_;
    private volatile Object alternativeName_;
    private int bitField0_;
    private int category_;
    private volatile Object checksum_;
    private Timestamp createdAt_;
    private int generation_;
    private long id_;
    private volatile Object name_;
    private PlatformFamily platformFamily_;
    private PlatformLogo platformLogo_;
    private volatile Object slug_;
    private volatile Object summary_;
    private Timestamp updatedAt_;
    private volatile Object url_;
    private List<PlatformVersion> versions_;
    private List<PlatformWebsite> websites_;

    /* synthetic */ Platform(GeneratedMessage.Builder builder, PlatformIA platformIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Platform.class.getName());
        DEFAULT_INSTANCE = new Platform();
        PARSER = new AnonymousClass1();
    }

    private Platform(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.abbreviation_ = "";
        this.alternativeName_ = "";
        this.category_ = 0;
        this.generation_ = 0;
        this.name_ = "";
        this.slug_ = "";
        this.summary_ = "";
        this.url_ = "";
        this.checksum_ = "";
    }

    private Platform() {
        this.id_ = 0L;
        this.abbreviation_ = "";
        this.alternativeName_ = "";
        this.category_ = 0;
        this.generation_ = 0;
        this.name_ = "";
        this.slug_ = "";
        this.summary_ = "";
        this.url_ = "";
        this.checksum_ = "";
        this.abbreviation_ = "";
        this.alternativeName_ = "";
        this.category_ = 0;
        this.name_ = "";
        this.slug_ = "";
        this.summary_ = "";
        this.url_ = "";
        this.versions_ = Collections.emptyList();
        this.websites_ = Collections.emptyList();
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_Platform_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_Platform_fieldAccessorTable.ensureFieldAccessorsInitialized(Platform.class, Builder.class);
    }

    @Override // proto.PlatformOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.PlatformOrBuilder
    public String getAbbreviation() {
        Object obj = this.abbreviation_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.abbreviation_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformOrBuilder
    public ByteString getAbbreviationBytes() {
        Object obj = this.abbreviation_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.abbreviation_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformOrBuilder
    public String getAlternativeName() {
        Object obj = this.alternativeName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.alternativeName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformOrBuilder
    public ByteString getAlternativeNameBytes() {
        Object obj = this.alternativeName_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.alternativeName_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformOrBuilder
    public int getCategoryValue() {
        return this.category_;
    }

    @Override // proto.PlatformOrBuilder
    public PlatformCategoryEnum getCategory() {
        PlatformCategoryEnum platformCategoryEnumForNumber = PlatformCategoryEnum.forNumber(this.category_);
        return platformCategoryEnumForNumber == null ? PlatformCategoryEnum.UNRECOGNIZED : platformCategoryEnumForNumber;
    }

    @Override // proto.PlatformOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.PlatformOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.PlatformOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.PlatformOrBuilder
    public int getGeneration() {
        return this.generation_;
    }

    @Override // proto.PlatformOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformOrBuilder
    public boolean hasPlatformLogo() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.PlatformOrBuilder
    public PlatformLogo getPlatformLogo() {
        PlatformLogo platformLogo = this.platformLogo_;
        return platformLogo == null ? PlatformLogo.getDefaultInstance() : platformLogo;
    }

    @Override // proto.PlatformOrBuilder
    public PlatformLogoOrBuilder getPlatformLogoOrBuilder() {
        PlatformLogo platformLogo = this.platformLogo_;
        return platformLogo == null ? PlatformLogo.getDefaultInstance() : platformLogo;
    }

    @Override // proto.PlatformOrBuilder
    public boolean hasPlatformFamily() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.PlatformOrBuilder
    public PlatformFamily getPlatformFamily() {
        PlatformFamily platformFamily = this.platformFamily_;
        return platformFamily == null ? PlatformFamily.getDefaultInstance() : platformFamily;
    }

    @Override // proto.PlatformOrBuilder
    public PlatformFamilyOrBuilder getPlatformFamilyOrBuilder() {
        PlatformFamily platformFamily = this.platformFamily_;
        return platformFamily == null ? PlatformFamily.getDefaultInstance() : platformFamily;
    }

    @Override // proto.PlatformOrBuilder
    public String getSlug() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.slug_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformOrBuilder
    public ByteString getSlugBytes() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.slug_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformOrBuilder
    public String getSummary() {
        Object obj = this.summary_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.summary_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformOrBuilder
    public ByteString getSummaryBytes() {
        Object obj = this.summary_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.summary_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // proto.PlatformOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.PlatformOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.PlatformOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformOrBuilder
    public List<PlatformVersion> getVersionsList() {
        return this.versions_;
    }

    @Override // proto.PlatformOrBuilder
    public List<? extends PlatformVersionOrBuilder> getVersionsOrBuilderList() {
        return this.versions_;
    }

    @Override // proto.PlatformOrBuilder
    public int getVersionsCount() {
        return this.versions_.size();
    }

    @Override // proto.PlatformOrBuilder
    public PlatformVersion getVersions(int i) {
        return this.versions_.get(i);
    }

    @Override // proto.PlatformOrBuilder
    public PlatformVersionOrBuilder getVersionsOrBuilder(int i) {
        return this.versions_.get(i);
    }

    @Override // proto.PlatformOrBuilder
    public List<PlatformWebsite> getWebsitesList() {
        return this.websites_;
    }

    @Override // proto.PlatformOrBuilder
    public List<? extends PlatformWebsiteOrBuilder> getWebsitesOrBuilderList() {
        return this.websites_;
    }

    @Override // proto.PlatformOrBuilder
    public int getWebsitesCount() {
        return this.websites_.size();
    }

    @Override // proto.PlatformOrBuilder
    public PlatformWebsite getWebsites(int i) {
        return this.websites_.get(i);
    }

    @Override // proto.PlatformOrBuilder
    public PlatformWebsiteOrBuilder getWebsitesOrBuilder(int i) {
        return this.websites_.get(i);
    }

    @Override // proto.PlatformOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static Platform parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Platform parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Platform parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Platform parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Platform parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Platform parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Platform parseFrom(InputStream inputStream) throws IOException {
        return (Platform) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Platform parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Platform) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Platform parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Platform) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Platform parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Platform) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Platform parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Platform) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Platform parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Platform) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(Platform platform) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) platform);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((PlatformIA) null) : (Builder) new Builder((PlatformIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlatformOrBuilder {
        private Object abbreviation_;
        private Object alternativeName_;
        private int bitField0_;
        private int category_;
        private Object checksum_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private int generation_;
        private long id_;
        private Object name_;
        private SingleFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> platformFamilyBuilder_;
        private PlatformFamily platformFamily_;
        private SingleFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> platformLogoBuilder_;
        private PlatformLogo platformLogo_;
        private Object slug_;
        private Object summary_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;
        private Object url_;
        private RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> versionsBuilder_;
        private List<PlatformVersion> versions_;
        private RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> websitesBuilder_;
        private List<PlatformWebsite> websites_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, PlatformIA platformIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(PlatformIA platformIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_Platform_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_Platform_fieldAccessorTable.ensureFieldAccessorsInitialized(Platform.class, Builder.class);
        }

        private Builder() {
            this.abbreviation_ = "";
            this.alternativeName_ = "";
            this.category_ = 0;
            this.name_ = "";
            this.slug_ = "";
            this.summary_ = "";
            this.url_ = "";
            this.versions_ = Collections.emptyList();
            this.websites_ = Collections.emptyList();
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.abbreviation_ = "";
            this.alternativeName_ = "";
            this.category_ = 0;
            this.name_ = "";
            this.slug_ = "";
            this.summary_ = "";
            this.url_ = "";
            this.versions_ = Collections.emptyList();
            this.websites_ = Collections.emptyList();
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (Platform.alwaysUseFieldBuilders) {
                getCreatedAtFieldBuilder();
                getPlatformLogoFieldBuilder();
                getPlatformFamilyFieldBuilder();
                getUpdatedAtFieldBuilder();
                getVersionsFieldBuilder();
                getWebsitesFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.abbreviation_ = "";
            this.alternativeName_ = "";
            this.category_ = 0;
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.createdAtBuilder_ = null;
            }
            this.generation_ = 0;
            this.name_ = "";
            this.platformLogo_ = null;
            SingleFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> singleFieldBuilder2 = this.platformLogoBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.platformLogoBuilder_ = null;
            }
            this.platformFamily_ = null;
            SingleFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> singleFieldBuilder3 = this.platformFamilyBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.platformFamilyBuilder_ = null;
            }
            this.slug_ = "";
            this.summary_ = "";
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.updatedAtBuilder_;
            if (singleFieldBuilder4 != null) {
                singleFieldBuilder4.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.url_ = "";
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.versionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.versions_ = Collections.emptyList();
            } else {
                this.versions_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -8193;
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder2 = this.websitesBuilder_;
            if (repeatedFieldBuilder2 == null) {
                this.websites_ = Collections.emptyList();
            } else {
                this.websites_ = null;
                repeatedFieldBuilder2.clear();
            }
            this.bitField0_ &= -16385;
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_Platform_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Platform getDefaultInstanceForType() {
            return Platform.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Platform build() {
            Platform platformBuildPartial = buildPartial();
            if (platformBuildPartial.isInitialized()) {
                return platformBuildPartial;
            }
            throw newUninitializedMessageException((Message) platformBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Platform buildPartial() {
            Platform platform = new Platform(this, null);
            buildPartialRepeatedFields(platform);
            if (this.bitField0_ != 0) {
                buildPartial0(platform);
            }
            onBuilt();
            return platform;
        }

        private void buildPartialRepeatedFields(Platform platform) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.versionsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 8192) != 0) {
                    this.versions_ = Collections.unmodifiableList(this.versions_);
                    this.bitField0_ &= -8193;
                }
                platform.versions_ = this.versions_;
            } else {
                platform.versions_ = repeatedFieldBuilder.build();
            }
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder2 = this.websitesBuilder_;
            if (repeatedFieldBuilder2 == null) {
                if ((this.bitField0_ & 16384) != 0) {
                    this.websites_ = Collections.unmodifiableList(this.websites_);
                    this.bitField0_ &= -16385;
                }
                platform.websites_ = this.websites_;
                return;
            }
            platform.websites_ = repeatedFieldBuilder2.build();
        }

        private void buildPartial0(Platform platform) {
            int i;
            Timestamp timestamp;
            PlatformFamily platformFamily;
            PlatformLogo platformLogo;
            Timestamp timestamp2;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                platform.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                platform.abbreviation_ = this.abbreviation_;
            }
            if ((i2 & 4) != 0) {
                platform.alternativeName_ = this.alternativeName_;
            }
            if ((i2 & 8) != 0) {
                platform.category_ = this.category_;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
                if (singleFieldBuilder == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder.build();
                }
                platform.createdAt_ = timestamp2;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 32) != 0) {
                platform.generation_ = this.generation_;
            }
            if ((i2 & 64) != 0) {
                platform.name_ = this.name_;
            }
            if ((i2 & 128) != 0) {
                SingleFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> singleFieldBuilder2 = this.platformLogoBuilder_;
                if (singleFieldBuilder2 == null) {
                    platformLogo = this.platformLogo_;
                } else {
                    platformLogo = (PlatformLogo) singleFieldBuilder2.build();
                }
                platform.platformLogo_ = platformLogo;
                i |= 2;
            }
            if ((i2 & 256) != 0) {
                SingleFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> singleFieldBuilder3 = this.platformFamilyBuilder_;
                if (singleFieldBuilder3 == null) {
                    platformFamily = this.platformFamily_;
                } else {
                    platformFamily = (PlatformFamily) singleFieldBuilder3.build();
                }
                platform.platformFamily_ = platformFamily;
                i |= 4;
            }
            if ((i2 & 512) != 0) {
                platform.slug_ = this.slug_;
            }
            if ((i2 & 1024) != 0) {
                platform.summary_ = this.summary_;
            }
            if ((i2 & 2048) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.updatedAtBuilder_;
                if (singleFieldBuilder4 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder4.build();
                }
                platform.updatedAt_ = timestamp;
                i |= 8;
            }
            if ((i2 & 4096) != 0) {
                platform.url_ = this.url_;
            }
            if ((i2 & 32768) != 0) {
                platform.checksum_ = this.checksum_;
            }
            platform.bitField0_ |= i;
        }

        @Override // proto.PlatformOrBuilder
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

        @Override // proto.PlatformOrBuilder
        public String getAbbreviation() {
            Object obj = this.abbreviation_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.abbreviation_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformOrBuilder
        public ByteString getAbbreviationBytes() {
            Object obj = this.abbreviation_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.abbreviation_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setAbbreviation(String str) {
            str.getClass();
            this.abbreviation_ = str;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder clearAbbreviation() {
            this.abbreviation_ = Platform.getDefaultInstance().getAbbreviation();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder setAbbreviationBytes(ByteString byteString) {
            byteString.getClass();
            Platform.checkByteStringIsUtf8(byteString);
            this.abbreviation_ = byteString;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.PlatformOrBuilder
        public String getAlternativeName() {
            Object obj = this.alternativeName_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.alternativeName_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformOrBuilder
        public ByteString getAlternativeNameBytes() {
            Object obj = this.alternativeName_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.alternativeName_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setAlternativeName(String str) {
            str.getClass();
            this.alternativeName_ = str;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearAlternativeName() {
            this.alternativeName_ = Platform.getDefaultInstance().getAlternativeName();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder setAlternativeNameBytes(ByteString byteString) {
            byteString.getClass();
            Platform.checkByteStringIsUtf8(byteString);
            this.alternativeName_ = byteString;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // proto.PlatformOrBuilder
        public int getCategoryValue() {
            return this.category_;
        }

        public Builder setCategoryValue(int i) {
            this.category_ = i;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // proto.PlatformOrBuilder
        public PlatformCategoryEnum getCategory() {
            PlatformCategoryEnum platformCategoryEnumForNumber = PlatformCategoryEnum.forNumber(this.category_);
            return platformCategoryEnumForNumber == null ? PlatformCategoryEnum.UNRECOGNIZED : platformCategoryEnumForNumber;
        }

        public Builder setCategory(PlatformCategoryEnum platformCategoryEnum) {
            platformCategoryEnum.getClass();
            this.bitField0_ |= 8;
            this.category_ = platformCategoryEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearCategory() {
            this.bitField0_ &= -9;
            this.category_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.PlatformOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // proto.PlatformOrBuilder
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
            this.bitField0_ |= 16;
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
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder mergeCreatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 16) != 0 && (timestamp2 = this.createdAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getCreatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.createdAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.createdAt_ != null) {
                this.bitField0_ |= 16;
                onChanged();
            }
            return this;
        }

        public Builder clearCreatedAt() {
            this.bitField0_ &= -17;
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
            this.bitField0_ |= 16;
            onChanged();
            return (Timestamp.Builder) getCreatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.PlatformOrBuilder
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

        @Override // proto.PlatformOrBuilder
        public int getGeneration() {
            return this.generation_;
        }

        public Builder setGeneration(int i) {
            this.generation_ = i;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearGeneration() {
            this.bitField0_ &= -33;
            this.generation_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.PlatformOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformOrBuilder
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
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Platform.getDefaultInstance().getName();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            Platform.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        @Override // proto.PlatformOrBuilder
        public boolean hasPlatformLogo() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // proto.PlatformOrBuilder
        public PlatformLogo getPlatformLogo() {
            SingleFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> singleFieldBuilder = this.platformLogoBuilder_;
            if (singleFieldBuilder == null) {
                PlatformLogo platformLogo = this.platformLogo_;
                return platformLogo == null ? PlatformLogo.getDefaultInstance() : platformLogo;
            }
            return (PlatformLogo) singleFieldBuilder.getMessage();
        }

        public Builder setPlatformLogo(PlatformLogo platformLogo) {
            SingleFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> singleFieldBuilder = this.platformLogoBuilder_;
            if (singleFieldBuilder == null) {
                platformLogo.getClass();
                this.platformLogo_ = platformLogo;
            } else {
                singleFieldBuilder.setMessage(platformLogo);
            }
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setPlatformLogo(PlatformLogo.Builder builder) {
            SingleFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> singleFieldBuilder = this.platformLogoBuilder_;
            if (singleFieldBuilder == null) {
                this.platformLogo_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder mergePlatformLogo(PlatformLogo platformLogo) {
            PlatformLogo platformLogo2;
            SingleFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> singleFieldBuilder = this.platformLogoBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 128) != 0 && (platformLogo2 = this.platformLogo_) != null && platformLogo2 != PlatformLogo.getDefaultInstance()) {
                    getPlatformLogoBuilder().mergeFrom((Message) platformLogo);
                } else {
                    this.platformLogo_ = platformLogo;
                }
            } else {
                singleFieldBuilder.mergeFrom(platformLogo);
            }
            if (this.platformLogo_ != null) {
                this.bitField0_ |= 128;
                onChanged();
            }
            return this;
        }

        public Builder clearPlatformLogo() {
            this.bitField0_ &= -129;
            this.platformLogo_ = null;
            SingleFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> singleFieldBuilder = this.platformLogoBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.platformLogoBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public PlatformLogo.Builder getPlatformLogoBuilder() {
            this.bitField0_ |= 128;
            onChanged();
            return (PlatformLogo.Builder) getPlatformLogoFieldBuilder().getBuilder();
        }

        @Override // proto.PlatformOrBuilder
        public PlatformLogoOrBuilder getPlatformLogoOrBuilder() {
            SingleFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> singleFieldBuilder = this.platformLogoBuilder_;
            if (singleFieldBuilder != null) {
                return (PlatformLogoOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            PlatformLogo platformLogo = this.platformLogo_;
            return platformLogo == null ? PlatformLogo.getDefaultInstance() : platformLogo;
        }

        private SingleFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> getPlatformLogoFieldBuilder() {
            if (this.platformLogoBuilder_ == null) {
                this.platformLogoBuilder_ = new SingleFieldBuilder<>(getPlatformLogo(), getParentForChildren(), isClean());
                this.platformLogo_ = null;
            }
            return this.platformLogoBuilder_;
        }

        @Override // proto.PlatformOrBuilder
        public boolean hasPlatformFamily() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // proto.PlatformOrBuilder
        public PlatformFamily getPlatformFamily() {
            SingleFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> singleFieldBuilder = this.platformFamilyBuilder_;
            if (singleFieldBuilder == null) {
                PlatformFamily platformFamily = this.platformFamily_;
                return platformFamily == null ? PlatformFamily.getDefaultInstance() : platformFamily;
            }
            return (PlatformFamily) singleFieldBuilder.getMessage();
        }

        public Builder setPlatformFamily(PlatformFamily platformFamily) {
            SingleFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> singleFieldBuilder = this.platformFamilyBuilder_;
            if (singleFieldBuilder == null) {
                platformFamily.getClass();
                this.platformFamily_ = platformFamily;
            } else {
                singleFieldBuilder.setMessage(platformFamily);
            }
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setPlatformFamily(PlatformFamily.Builder builder) {
            SingleFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> singleFieldBuilder = this.platformFamilyBuilder_;
            if (singleFieldBuilder == null) {
                this.platformFamily_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder mergePlatformFamily(PlatformFamily platformFamily) {
            PlatformFamily platformFamily2;
            SingleFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> singleFieldBuilder = this.platformFamilyBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 256) != 0 && (platformFamily2 = this.platformFamily_) != null && platformFamily2 != PlatformFamily.getDefaultInstance()) {
                    getPlatformFamilyBuilder().mergeFrom((Message) platformFamily);
                } else {
                    this.platformFamily_ = platformFamily;
                }
            } else {
                singleFieldBuilder.mergeFrom(platformFamily);
            }
            if (this.platformFamily_ != null) {
                this.bitField0_ |= 256;
                onChanged();
            }
            return this;
        }

        public Builder clearPlatformFamily() {
            this.bitField0_ &= -257;
            this.platformFamily_ = null;
            SingleFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> singleFieldBuilder = this.platformFamilyBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.platformFamilyBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public PlatformFamily.Builder getPlatformFamilyBuilder() {
            this.bitField0_ |= 256;
            onChanged();
            return (PlatformFamily.Builder) getPlatformFamilyFieldBuilder().getBuilder();
        }

        @Override // proto.PlatformOrBuilder
        public PlatformFamilyOrBuilder getPlatformFamilyOrBuilder() {
            SingleFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> singleFieldBuilder = this.platformFamilyBuilder_;
            if (singleFieldBuilder != null) {
                return (PlatformFamilyOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            PlatformFamily platformFamily = this.platformFamily_;
            return platformFamily == null ? PlatformFamily.getDefaultInstance() : platformFamily;
        }

        private SingleFieldBuilder<PlatformFamily, PlatformFamily.Builder, PlatformFamilyOrBuilder> getPlatformFamilyFieldBuilder() {
            if (this.platformFamilyBuilder_ == null) {
                this.platformFamilyBuilder_ = new SingleFieldBuilder<>(getPlatformFamily(), getParentForChildren(), isClean());
                this.platformFamily_ = null;
            }
            return this.platformFamilyBuilder_;
        }

        @Override // proto.PlatformOrBuilder
        public String getSlug() {
            Object obj = this.slug_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.slug_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformOrBuilder
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
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder clearSlug() {
            this.slug_ = Platform.getDefaultInstance().getSlug();
            this.bitField0_ &= -513;
            onChanged();
            return this;
        }

        public Builder setSlugBytes(ByteString byteString) {
            byteString.getClass();
            Platform.checkByteStringIsUtf8(byteString);
            this.slug_ = byteString;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        @Override // proto.PlatformOrBuilder
        public String getSummary() {
            Object obj = this.summary_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.summary_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformOrBuilder
        public ByteString getSummaryBytes() {
            Object obj = this.summary_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.summary_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setSummary(String str) {
            str.getClass();
            this.summary_ = str;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder clearSummary() {
            this.summary_ = Platform.getDefaultInstance().getSummary();
            this.bitField0_ &= -1025;
            onChanged();
            return this;
        }

        public Builder setSummaryBytes(ByteString byteString) {
            byteString.getClass();
            Platform.checkByteStringIsUtf8(byteString);
            this.summary_ = byteString;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        @Override // proto.PlatformOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 2048) != 0;
        }

        @Override // proto.PlatformOrBuilder
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
            this.bitField0_ |= 2048;
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
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder mergeUpdatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 2048) != 0 && (timestamp2 = this.updatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getUpdatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.updatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.updatedAt_ != null) {
                this.bitField0_ |= 2048;
                onChanged();
            }
            return this;
        }

        public Builder clearUpdatedAt() {
            this.bitField0_ &= -2049;
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
            this.bitField0_ |= 2048;
            onChanged();
            return (Timestamp.Builder) getUpdatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.PlatformOrBuilder
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

        @Override // proto.PlatformOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformOrBuilder
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
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = Platform.getDefaultInstance().getUrl();
            this.bitField0_ &= -4097;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            Platform.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        private void ensureVersionsIsMutable() {
            if ((this.bitField0_ & 8192) == 0) {
                this.versions_ = new ArrayList(this.versions_);
                this.bitField0_ |= 8192;
            }
        }

        @Override // proto.PlatformOrBuilder
        public List<PlatformVersion> getVersionsList() {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.versionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.versions_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.PlatformOrBuilder
        public int getVersionsCount() {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.versionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.versions_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.PlatformOrBuilder
        public PlatformVersion getVersions(int i) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.versionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.versions_.get(i);
            }
            return (PlatformVersion) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setVersions(int i, PlatformVersion platformVersion) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.versionsBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersion.getClass();
                ensureVersionsIsMutable();
                this.versions_.set(i, platformVersion);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, platformVersion);
            return this;
        }

        public Builder setVersions(int i, PlatformVersion.Builder builder) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.versionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureVersionsIsMutable();
                this.versions_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addVersions(PlatformVersion platformVersion) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.versionsBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersion.getClass();
                ensureVersionsIsMutable();
                this.versions_.add(platformVersion);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(platformVersion);
            return this;
        }

        public Builder addVersions(int i, PlatformVersion platformVersion) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.versionsBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersion.getClass();
                ensureVersionsIsMutable();
                this.versions_.add(i, platformVersion);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, platformVersion);
            return this;
        }

        public Builder addVersions(PlatformVersion.Builder builder) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.versionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureVersionsIsMutable();
                this.versions_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addVersions(int i, PlatformVersion.Builder builder) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.versionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureVersionsIsMutable();
                this.versions_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllVersions(Iterable<? extends PlatformVersion> iterable) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.versionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureVersionsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.versions_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearVersions() {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.versionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.versions_ = Collections.emptyList();
                this.bitField0_ &= -8193;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeVersions(int i) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.versionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureVersionsIsMutable();
                this.versions_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public PlatformVersion.Builder getVersionsBuilder(int i) {
            return (PlatformVersion.Builder) getVersionsFieldBuilder().getBuilder(i);
        }

        @Override // proto.PlatformOrBuilder
        public PlatformVersionOrBuilder getVersionsOrBuilder(int i) {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.versionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.versions_.get(i);
            }
            return (PlatformVersionOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.PlatformOrBuilder
        public List<? extends PlatformVersionOrBuilder> getVersionsOrBuilderList() {
            RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> repeatedFieldBuilder = this.versionsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.versions_);
        }

        public PlatformVersion.Builder addVersionsBuilder() {
            return (PlatformVersion.Builder) getVersionsFieldBuilder().addBuilder(PlatformVersion.getDefaultInstance());
        }

        public PlatformVersion.Builder addVersionsBuilder(int i) {
            return (PlatformVersion.Builder) getVersionsFieldBuilder().addBuilder(i, PlatformVersion.getDefaultInstance());
        }

        public List<PlatformVersion.Builder> getVersionsBuilderList() {
            return getVersionsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> getVersionsFieldBuilder() {
            if (this.versionsBuilder_ == null) {
                this.versionsBuilder_ = new RepeatedFieldBuilder<>(this.versions_, (this.bitField0_ & 8192) != 0, getParentForChildren(), isClean());
                this.versions_ = null;
            }
            return this.versionsBuilder_;
        }

        private void ensureWebsitesIsMutable() {
            if ((this.bitField0_ & 16384) == 0) {
                this.websites_ = new ArrayList(this.websites_);
                this.bitField0_ |= 16384;
            }
        }

        @Override // proto.PlatformOrBuilder
        public List<PlatformWebsite> getWebsitesList() {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.websites_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.PlatformOrBuilder
        public int getWebsitesCount() {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.websites_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.PlatformOrBuilder
        public PlatformWebsite getWebsites(int i) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.websites_.get(i);
            }
            return (PlatformWebsite) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setWebsites(int i, PlatformWebsite platformWebsite) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformWebsite.getClass();
                ensureWebsitesIsMutable();
                this.websites_.set(i, platformWebsite);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, platformWebsite);
            return this;
        }

        public Builder setWebsites(int i, PlatformWebsite.Builder builder) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                this.websites_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addWebsites(PlatformWebsite platformWebsite) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformWebsite.getClass();
                ensureWebsitesIsMutable();
                this.websites_.add(platformWebsite);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(platformWebsite);
            return this;
        }

        public Builder addWebsites(int i, PlatformWebsite platformWebsite) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformWebsite.getClass();
                ensureWebsitesIsMutable();
                this.websites_.add(i, platformWebsite);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, platformWebsite);
            return this;
        }

        public Builder addWebsites(PlatformWebsite.Builder builder) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                this.websites_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addWebsites(int i, PlatformWebsite.Builder builder) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                this.websites_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllWebsites(Iterable<? extends PlatformWebsite> iterable) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
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
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.websites_ = Collections.emptyList();
                this.bitField0_ &= -16385;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeWebsites(int i) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                this.websites_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public PlatformWebsite.Builder getWebsitesBuilder(int i) {
            return (PlatformWebsite.Builder) getWebsitesFieldBuilder().getBuilder(i);
        }

        @Override // proto.PlatformOrBuilder
        public PlatformWebsiteOrBuilder getWebsitesOrBuilder(int i) {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.websites_.get(i);
            }
            return (PlatformWebsiteOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.PlatformOrBuilder
        public List<? extends PlatformWebsiteOrBuilder> getWebsitesOrBuilderList() {
            RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.websites_);
        }

        public PlatformWebsite.Builder addWebsitesBuilder() {
            return (PlatformWebsite.Builder) getWebsitesFieldBuilder().addBuilder(PlatformWebsite.getDefaultInstance());
        }

        public PlatformWebsite.Builder addWebsitesBuilder(int i) {
            return (PlatformWebsite.Builder) getWebsitesFieldBuilder().addBuilder(i, PlatformWebsite.getDefaultInstance());
        }

        public List<PlatformWebsite.Builder> getWebsitesBuilderList() {
            return getWebsitesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<PlatformWebsite, PlatformWebsite.Builder, PlatformWebsiteOrBuilder> getWebsitesFieldBuilder() {
            if (this.websitesBuilder_ == null) {
                this.websitesBuilder_ = new RepeatedFieldBuilder<>(this.websites_, (this.bitField0_ & 16384) != 0, getParentForChildren(), isClean());
                this.websites_ = null;
            }
            return this.websitesBuilder_;
        }

        @Override // proto.PlatformOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformOrBuilder
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
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = Platform.getDefaultInstance().getChecksum();
            this.bitField0_ &= -32769;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            Platform.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }
    }

    public static Platform getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.Platform$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Platform> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public Platform parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Platform.newBuilder();
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

    public static Parser<Platform> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Platform> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Platform getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
