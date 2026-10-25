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
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class PlatformVersion extends GeneratedMessage implements PlatformVersionOrBuilder {
    public static final int CHECKSUM_FIELD_NUMBER = 21;
    public static final int COMPANIES_FIELD_NUMBER = 2;
    public static final int CONNECTIVITY_FIELD_NUMBER = 3;
    public static final int CPU_FIELD_NUMBER = 4;
    private static final PlatformVersion DEFAULT_INSTANCE;
    public static final int GRAPHICS_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int MAIN_MANUFACTURER_FIELD_NUMBER = 6;
    public static final int MEDIA_FIELD_NUMBER = 7;
    public static final int MEMORY_FIELD_NUMBER = 8;
    public static final int NAME_FIELD_NUMBER = 9;
    public static final int ONLINE_FIELD_NUMBER = 10;
    public static final int OS_FIELD_NUMBER = 11;
    public static final int OUTPUT_FIELD_NUMBER = 12;
    private static final Parser<PlatformVersion> PARSER;
    public static final int PLATFORM_LOGO_FIELD_NUMBER = 13;
    public static final int PLATFORM_VERSION_RELEASE_DATES_FIELD_NUMBER = 14;
    public static final int RESOLUTIONS_FIELD_NUMBER = 15;
    public static final int SLUG_FIELD_NUMBER = 16;
    public static final int SOUND_FIELD_NUMBER = 17;
    public static final int STORAGE_FIELD_NUMBER = 18;
    public static final int SUMMARY_FIELD_NUMBER = 19;
    public static final int URL_FIELD_NUMBER = 20;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object checksum_;
    private List<PlatformVersionCompany> companies_;
    private volatile Object connectivity_;
    private volatile Object cpu_;
    private volatile Object graphics_;
    private long id_;
    private PlatformVersionCompany mainManufacturer_;
    private volatile Object media_;
    private volatile Object memory_;
    private volatile Object name_;
    private volatile Object online_;
    private volatile Object os_;
    private volatile Object output_;
    private PlatformLogo platformLogo_;
    private List<PlatformVersionReleaseDate> platformVersionReleaseDates_;
    private volatile Object resolutions_;
    private volatile Object slug_;
    private volatile Object sound_;
    private volatile Object storage_;
    private volatile Object summary_;
    private volatile Object url_;

    /* synthetic */ PlatformVersion(GeneratedMessage.Builder builder, PlatformVersionIA platformVersionIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PlatformVersion.class.getName());
        DEFAULT_INSTANCE = new PlatformVersion();
        PARSER = new AnonymousClass1();
    }

    private PlatformVersion(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.connectivity_ = "";
        this.cpu_ = "";
        this.graphics_ = "";
        this.media_ = "";
        this.memory_ = "";
        this.name_ = "";
        this.online_ = "";
        this.os_ = "";
        this.output_ = "";
        this.resolutions_ = "";
        this.slug_ = "";
        this.sound_ = "";
        this.storage_ = "";
        this.summary_ = "";
        this.url_ = "";
        this.checksum_ = "";
    }

    private PlatformVersion() {
        this.id_ = 0L;
        this.connectivity_ = "";
        this.cpu_ = "";
        this.graphics_ = "";
        this.media_ = "";
        this.memory_ = "";
        this.name_ = "";
        this.online_ = "";
        this.os_ = "";
        this.output_ = "";
        this.resolutions_ = "";
        this.slug_ = "";
        this.sound_ = "";
        this.storage_ = "";
        this.summary_ = "";
        this.url_ = "";
        this.checksum_ = "";
        this.companies_ = Collections.emptyList();
        this.connectivity_ = "";
        this.cpu_ = "";
        this.graphics_ = "";
        this.media_ = "";
        this.memory_ = "";
        this.name_ = "";
        this.online_ = "";
        this.os_ = "";
        this.output_ = "";
        this.platformVersionReleaseDates_ = Collections.emptyList();
        this.resolutions_ = "";
        this.slug_ = "";
        this.sound_ = "";
        this.storage_ = "";
        this.summary_ = "";
        this.url_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_PlatformVersion_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_PlatformVersion_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformVersion.class, Builder.class);
    }

    @Override // proto.PlatformVersionOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.PlatformVersionOrBuilder
    public List<PlatformVersionCompany> getCompaniesList() {
        return this.companies_;
    }

    @Override // proto.PlatformVersionOrBuilder
    public List<? extends PlatformVersionCompanyOrBuilder> getCompaniesOrBuilderList() {
        return this.companies_;
    }

    @Override // proto.PlatformVersionOrBuilder
    public int getCompaniesCount() {
        return this.companies_.size();
    }

    @Override // proto.PlatformVersionOrBuilder
    public PlatformVersionCompany getCompanies(int i) {
        return this.companies_.get(i);
    }

    @Override // proto.PlatformVersionOrBuilder
    public PlatformVersionCompanyOrBuilder getCompaniesOrBuilder(int i) {
        return this.companies_.get(i);
    }

    @Override // proto.PlatformVersionOrBuilder
    public String getConnectivity() {
        Object obj = this.connectivity_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.connectivity_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionOrBuilder
    public ByteString getConnectivityBytes() {
        Object obj = this.connectivity_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.connectivity_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionOrBuilder
    public String getCpu() {
        Object obj = this.cpu_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.cpu_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionOrBuilder
    public ByteString getCpuBytes() {
        Object obj = this.cpu_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.cpu_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionOrBuilder
    public String getGraphics() {
        Object obj = this.graphics_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.graphics_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionOrBuilder
    public ByteString getGraphicsBytes() {
        Object obj = this.graphics_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.graphics_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionOrBuilder
    public boolean hasMainManufacturer() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.PlatformVersionOrBuilder
    public PlatformVersionCompany getMainManufacturer() {
        PlatformVersionCompany platformVersionCompany = this.mainManufacturer_;
        return platformVersionCompany == null ? PlatformVersionCompany.getDefaultInstance() : platformVersionCompany;
    }

    @Override // proto.PlatformVersionOrBuilder
    public PlatformVersionCompanyOrBuilder getMainManufacturerOrBuilder() {
        PlatformVersionCompany platformVersionCompany = this.mainManufacturer_;
        return platformVersionCompany == null ? PlatformVersionCompany.getDefaultInstance() : platformVersionCompany;
    }

    @Override // proto.PlatformVersionOrBuilder
    public String getMedia() {
        Object obj = this.media_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.media_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionOrBuilder
    public ByteString getMediaBytes() {
        Object obj = this.media_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.media_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionOrBuilder
    public String getMemory() {
        Object obj = this.memory_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.memory_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionOrBuilder
    public ByteString getMemoryBytes() {
        Object obj = this.memory_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.memory_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionOrBuilder
    public String getOnline() {
        Object obj = this.online_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.online_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionOrBuilder
    public ByteString getOnlineBytes() {
        Object obj = this.online_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.online_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionOrBuilder
    public String getOs() {
        Object obj = this.os_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.os_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionOrBuilder
    public ByteString getOsBytes() {
        Object obj = this.os_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.os_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionOrBuilder
    public String getOutput() {
        Object obj = this.output_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.output_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionOrBuilder
    public ByteString getOutputBytes() {
        Object obj = this.output_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.output_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionOrBuilder
    public boolean hasPlatformLogo() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.PlatformVersionOrBuilder
    public PlatformLogo getPlatformLogo() {
        PlatformLogo platformLogo = this.platformLogo_;
        return platformLogo == null ? PlatformLogo.getDefaultInstance() : platformLogo;
    }

    @Override // proto.PlatformVersionOrBuilder
    public PlatformLogoOrBuilder getPlatformLogoOrBuilder() {
        PlatformLogo platformLogo = this.platformLogo_;
        return platformLogo == null ? PlatformLogo.getDefaultInstance() : platformLogo;
    }

    @Override // proto.PlatformVersionOrBuilder
    public List<PlatformVersionReleaseDate> getPlatformVersionReleaseDatesList() {
        return this.platformVersionReleaseDates_;
    }

    @Override // proto.PlatformVersionOrBuilder
    public List<? extends PlatformVersionReleaseDateOrBuilder> getPlatformVersionReleaseDatesOrBuilderList() {
        return this.platformVersionReleaseDates_;
    }

    @Override // proto.PlatformVersionOrBuilder
    public int getPlatformVersionReleaseDatesCount() {
        return this.platformVersionReleaseDates_.size();
    }

    @Override // proto.PlatformVersionOrBuilder
    public PlatformVersionReleaseDate getPlatformVersionReleaseDates(int i) {
        return this.platformVersionReleaseDates_.get(i);
    }

    @Override // proto.PlatformVersionOrBuilder
    public PlatformVersionReleaseDateOrBuilder getPlatformVersionReleaseDatesOrBuilder(int i) {
        return this.platformVersionReleaseDates_.get(i);
    }

    @Override // proto.PlatformVersionOrBuilder
    public String getResolutions() {
        Object obj = this.resolutions_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.resolutions_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionOrBuilder
    public ByteString getResolutionsBytes() {
        Object obj = this.resolutions_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.resolutions_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionOrBuilder
    public String getSlug() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.slug_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionOrBuilder
    public ByteString getSlugBytes() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.slug_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionOrBuilder
    public String getSound() {
        Object obj = this.sound_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.sound_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionOrBuilder
    public ByteString getSoundBytes() {
        Object obj = this.sound_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.sound_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionOrBuilder
    public String getStorage() {
        Object obj = this.storage_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.storage_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionOrBuilder
    public ByteString getStorageBytes() {
        Object obj = this.storage_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.storage_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionOrBuilder
    public String getSummary() {
        Object obj = this.summary_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.summary_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionOrBuilder
    public ByteString getSummaryBytes() {
        Object obj = this.summary_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.summary_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static PlatformVersion parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PlatformVersion parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlatformVersion parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PlatformVersion parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PlatformVersion parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PlatformVersion parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PlatformVersion parseFrom(InputStream inputStream) throws IOException {
        return (PlatformVersion) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PlatformVersion parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersion) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformVersion parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PlatformVersion) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlatformVersion parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersion) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformVersion parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PlatformVersion) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlatformVersion parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersion) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(PlatformVersion platformVersion) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) platformVersion);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((PlatformVersionIA) null) : (Builder) new Builder((PlatformVersionIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlatformVersionOrBuilder {
        private int bitField0_;
        private Object checksum_;
        private RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> companiesBuilder_;
        private List<PlatformVersionCompany> companies_;
        private Object connectivity_;
        private Object cpu_;
        private Object graphics_;
        private long id_;
        private SingleFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> mainManufacturerBuilder_;
        private PlatformVersionCompany mainManufacturer_;
        private Object media_;
        private Object memory_;
        private Object name_;
        private Object online_;
        private Object os_;
        private Object output_;
        private SingleFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> platformLogoBuilder_;
        private PlatformLogo platformLogo_;
        private RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> platformVersionReleaseDatesBuilder_;
        private List<PlatformVersionReleaseDate> platformVersionReleaseDates_;
        private Object resolutions_;
        private Object slug_;
        private Object sound_;
        private Object storage_;
        private Object summary_;
        private Object url_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, PlatformVersionIA platformVersionIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(PlatformVersionIA platformVersionIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_PlatformVersion_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_PlatformVersion_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformVersion.class, Builder.class);
        }

        private Builder() {
            this.companies_ = Collections.emptyList();
            this.connectivity_ = "";
            this.cpu_ = "";
            this.graphics_ = "";
            this.media_ = "";
            this.memory_ = "";
            this.name_ = "";
            this.online_ = "";
            this.os_ = "";
            this.output_ = "";
            this.platformVersionReleaseDates_ = Collections.emptyList();
            this.resolutions_ = "";
            this.slug_ = "";
            this.sound_ = "";
            this.storage_ = "";
            this.summary_ = "";
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.companies_ = Collections.emptyList();
            this.connectivity_ = "";
            this.cpu_ = "";
            this.graphics_ = "";
            this.media_ = "";
            this.memory_ = "";
            this.name_ = "";
            this.online_ = "";
            this.os_ = "";
            this.output_ = "";
            this.platformVersionReleaseDates_ = Collections.emptyList();
            this.resolutions_ = "";
            this.slug_ = "";
            this.sound_ = "";
            this.storage_ = "";
            this.summary_ = "";
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (PlatformVersion.alwaysUseFieldBuilders) {
                getCompaniesFieldBuilder();
                getMainManufacturerFieldBuilder();
                getPlatformLogoFieldBuilder();
                getPlatformVersionReleaseDatesFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.companies_ = Collections.emptyList();
            } else {
                this.companies_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -3;
            this.connectivity_ = "";
            this.cpu_ = "";
            this.graphics_ = "";
            this.mainManufacturer_ = null;
            SingleFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> singleFieldBuilder = this.mainManufacturerBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.mainManufacturerBuilder_ = null;
            }
            this.media_ = "";
            this.memory_ = "";
            this.name_ = "";
            this.online_ = "";
            this.os_ = "";
            this.output_ = "";
            this.platformLogo_ = null;
            SingleFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> singleFieldBuilder2 = this.platformLogoBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.platformLogoBuilder_ = null;
            }
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder2 = this.platformVersionReleaseDatesBuilder_;
            if (repeatedFieldBuilder2 == null) {
                this.platformVersionReleaseDates_ = Collections.emptyList();
            } else {
                this.platformVersionReleaseDates_ = null;
                repeatedFieldBuilder2.clear();
            }
            this.bitField0_ &= -8193;
            this.resolutions_ = "";
            this.slug_ = "";
            this.sound_ = "";
            this.storage_ = "";
            this.summary_ = "";
            this.url_ = "";
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_PlatformVersion_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlatformVersion getDefaultInstanceForType() {
            return PlatformVersion.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformVersion build() {
            PlatformVersion platformVersionBuildPartial = buildPartial();
            if (platformVersionBuildPartial.isInitialized()) {
                return platformVersionBuildPartial;
            }
            throw newUninitializedMessageException((Message) platformVersionBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformVersion buildPartial() {
            PlatformVersion platformVersion = new PlatformVersion(this, null);
            buildPartialRepeatedFields(platformVersion);
            if (this.bitField0_ != 0) {
                buildPartial0(platformVersion);
            }
            onBuilt();
            return platformVersion;
        }

        private void buildPartialRepeatedFields(PlatformVersion platformVersion) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 2) != 0) {
                    this.companies_ = Collections.unmodifiableList(this.companies_);
                    this.bitField0_ &= -3;
                }
                platformVersion.companies_ = this.companies_;
            } else {
                platformVersion.companies_ = repeatedFieldBuilder.build();
            }
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder2 = this.platformVersionReleaseDatesBuilder_;
            if (repeatedFieldBuilder2 == null) {
                if ((this.bitField0_ & 8192) != 0) {
                    this.platformVersionReleaseDates_ = Collections.unmodifiableList(this.platformVersionReleaseDates_);
                    this.bitField0_ &= -8193;
                }
                platformVersion.platformVersionReleaseDates_ = this.platformVersionReleaseDates_;
                return;
            }
            platformVersion.platformVersionReleaseDates_ = repeatedFieldBuilder2.build();
        }

        private void buildPartial0(PlatformVersion platformVersion) {
            int i;
            PlatformLogo platformLogo;
            PlatformVersionCompany platformVersionCompany;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                platformVersion.id_ = this.id_;
            }
            if ((i2 & 4) != 0) {
                platformVersion.connectivity_ = this.connectivity_;
            }
            if ((i2 & 8) != 0) {
                platformVersion.cpu_ = this.cpu_;
            }
            if ((i2 & 16) != 0) {
                platformVersion.graphics_ = this.graphics_;
            }
            if ((i2 & 32) != 0) {
                SingleFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> singleFieldBuilder = this.mainManufacturerBuilder_;
                if (singleFieldBuilder == null) {
                    platformVersionCompany = this.mainManufacturer_;
                } else {
                    platformVersionCompany = (PlatformVersionCompany) singleFieldBuilder.build();
                }
                platformVersion.mainManufacturer_ = platformVersionCompany;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 64) != 0) {
                platformVersion.media_ = this.media_;
            }
            if ((i2 & 128) != 0) {
                platformVersion.memory_ = this.memory_;
            }
            if ((i2 & 256) != 0) {
                platformVersion.name_ = this.name_;
            }
            if ((i2 & 512) != 0) {
                platformVersion.online_ = this.online_;
            }
            if ((i2 & 1024) != 0) {
                platformVersion.os_ = this.os_;
            }
            if ((i2 & 2048) != 0) {
                platformVersion.output_ = this.output_;
            }
            if ((i2 & 4096) != 0) {
                SingleFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> singleFieldBuilder2 = this.platformLogoBuilder_;
                if (singleFieldBuilder2 == null) {
                    platformLogo = this.platformLogo_;
                } else {
                    platformLogo = (PlatformLogo) singleFieldBuilder2.build();
                }
                platformVersion.platformLogo_ = platformLogo;
                i |= 2;
            }
            if ((i2 & 16384) != 0) {
                platformVersion.resolutions_ = this.resolutions_;
            }
            if ((32768 & i2) != 0) {
                platformVersion.slug_ = this.slug_;
            }
            if ((65536 & i2) != 0) {
                platformVersion.sound_ = this.sound_;
            }
            if ((131072 & i2) != 0) {
                platformVersion.storage_ = this.storage_;
            }
            if ((262144 & i2) != 0) {
                platformVersion.summary_ = this.summary_;
            }
            if ((524288 & i2) != 0) {
                platformVersion.url_ = this.url_;
            }
            if ((i2 & 1048576) != 0) {
                platformVersion.checksum_ = this.checksum_;
            }
            platformVersion.bitField0_ |= i;
        }

        @Override // proto.PlatformVersionOrBuilder
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

        private void ensureCompaniesIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.companies_ = new ArrayList(this.companies_);
                this.bitField0_ |= 2;
            }
        }

        @Override // proto.PlatformVersionOrBuilder
        public List<PlatformVersionCompany> getCompaniesList() {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.companies_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.PlatformVersionOrBuilder
        public int getCompaniesCount() {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.companies_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.PlatformVersionOrBuilder
        public PlatformVersionCompany getCompanies(int i) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.companies_.get(i);
            }
            return (PlatformVersionCompany) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setCompanies(int i, PlatformVersionCompany platformVersionCompany) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersionCompany.getClass();
                ensureCompaniesIsMutable();
                this.companies_.set(i, platformVersionCompany);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, platformVersionCompany);
            return this;
        }

        public Builder setCompanies(int i, PlatformVersionCompany.Builder builder) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompaniesIsMutable();
                this.companies_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addCompanies(PlatformVersionCompany platformVersionCompany) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersionCompany.getClass();
                ensureCompaniesIsMutable();
                this.companies_.add(platformVersionCompany);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(platformVersionCompany);
            return this;
        }

        public Builder addCompanies(int i, PlatformVersionCompany platformVersionCompany) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersionCompany.getClass();
                ensureCompaniesIsMutable();
                this.companies_.add(i, platformVersionCompany);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, platformVersionCompany);
            return this;
        }

        public Builder addCompanies(PlatformVersionCompany.Builder builder) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompaniesIsMutable();
                this.companies_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addCompanies(int i, PlatformVersionCompany.Builder builder) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompaniesIsMutable();
                this.companies_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllCompanies(Iterable<? extends PlatformVersionCompany> iterable) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
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
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.companies_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeCompanies(int i) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompaniesIsMutable();
                this.companies_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public PlatformVersionCompany.Builder getCompaniesBuilder(int i) {
            return (PlatformVersionCompany.Builder) getCompaniesFieldBuilder().getBuilder(i);
        }

        @Override // proto.PlatformVersionOrBuilder
        public PlatformVersionCompanyOrBuilder getCompaniesOrBuilder(int i) {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.companies_.get(i);
            }
            return (PlatformVersionCompanyOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.PlatformVersionOrBuilder
        public List<? extends PlatformVersionCompanyOrBuilder> getCompaniesOrBuilderList() {
            RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.companies_);
        }

        public PlatformVersionCompany.Builder addCompaniesBuilder() {
            return (PlatformVersionCompany.Builder) getCompaniesFieldBuilder().addBuilder(PlatformVersionCompany.getDefaultInstance());
        }

        public PlatformVersionCompany.Builder addCompaniesBuilder(int i) {
            return (PlatformVersionCompany.Builder) getCompaniesFieldBuilder().addBuilder(i, PlatformVersionCompany.getDefaultInstance());
        }

        public List<PlatformVersionCompany.Builder> getCompaniesBuilderList() {
            return getCompaniesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> getCompaniesFieldBuilder() {
            if (this.companiesBuilder_ == null) {
                this.companiesBuilder_ = new RepeatedFieldBuilder<>(this.companies_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.companies_ = null;
            }
            return this.companiesBuilder_;
        }

        @Override // proto.PlatformVersionOrBuilder
        public String getConnectivity() {
            Object obj = this.connectivity_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.connectivity_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionOrBuilder
        public ByteString getConnectivityBytes() {
            Object obj = this.connectivity_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.connectivity_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setConnectivity(String str) {
            str.getClass();
            this.connectivity_ = str;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearConnectivity() {
            this.connectivity_ = PlatformVersion.getDefaultInstance().getConnectivity();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder setConnectivityBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersion.checkByteStringIsUtf8(byteString);
            this.connectivity_ = byteString;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionOrBuilder
        public String getCpu() {
            Object obj = this.cpu_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.cpu_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionOrBuilder
        public ByteString getCpuBytes() {
            Object obj = this.cpu_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.cpu_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setCpu(String str) {
            str.getClass();
            this.cpu_ = str;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder clearCpu() {
            this.cpu_ = PlatformVersion.getDefaultInstance().getCpu();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder setCpuBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersion.checkByteStringIsUtf8(byteString);
            this.cpu_ = byteString;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionOrBuilder
        public String getGraphics() {
            Object obj = this.graphics_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.graphics_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionOrBuilder
        public ByteString getGraphicsBytes() {
            Object obj = this.graphics_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.graphics_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setGraphics(String str) {
            str.getClass();
            this.graphics_ = str;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearGraphics() {
            this.graphics_ = PlatformVersion.getDefaultInstance().getGraphics();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder setGraphicsBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersion.checkByteStringIsUtf8(byteString);
            this.graphics_ = byteString;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionOrBuilder
        public boolean hasMainManufacturer() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // proto.PlatformVersionOrBuilder
        public PlatformVersionCompany getMainManufacturer() {
            SingleFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> singleFieldBuilder = this.mainManufacturerBuilder_;
            if (singleFieldBuilder == null) {
                PlatformVersionCompany platformVersionCompany = this.mainManufacturer_;
                return platformVersionCompany == null ? PlatformVersionCompany.getDefaultInstance() : platformVersionCompany;
            }
            return (PlatformVersionCompany) singleFieldBuilder.getMessage();
        }

        public Builder setMainManufacturer(PlatformVersionCompany platformVersionCompany) {
            SingleFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> singleFieldBuilder = this.mainManufacturerBuilder_;
            if (singleFieldBuilder == null) {
                platformVersionCompany.getClass();
                this.mainManufacturer_ = platformVersionCompany;
            } else {
                singleFieldBuilder.setMessage(platformVersionCompany);
            }
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setMainManufacturer(PlatformVersionCompany.Builder builder) {
            SingleFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> singleFieldBuilder = this.mainManufacturerBuilder_;
            if (singleFieldBuilder == null) {
                this.mainManufacturer_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder mergeMainManufacturer(PlatformVersionCompany platformVersionCompany) {
            PlatformVersionCompany platformVersionCompany2;
            SingleFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> singleFieldBuilder = this.mainManufacturerBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 32) != 0 && (platformVersionCompany2 = this.mainManufacturer_) != null && platformVersionCompany2 != PlatformVersionCompany.getDefaultInstance()) {
                    getMainManufacturerBuilder().mergeFrom((Message) platformVersionCompany);
                } else {
                    this.mainManufacturer_ = platformVersionCompany;
                }
            } else {
                singleFieldBuilder.mergeFrom(platformVersionCompany);
            }
            if (this.mainManufacturer_ != null) {
                this.bitField0_ |= 32;
                onChanged();
            }
            return this;
        }

        public Builder clearMainManufacturer() {
            this.bitField0_ &= -33;
            this.mainManufacturer_ = null;
            SingleFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> singleFieldBuilder = this.mainManufacturerBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.mainManufacturerBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public PlatformVersionCompany.Builder getMainManufacturerBuilder() {
            this.bitField0_ |= 32;
            onChanged();
            return (PlatformVersionCompany.Builder) getMainManufacturerFieldBuilder().getBuilder();
        }

        @Override // proto.PlatformVersionOrBuilder
        public PlatformVersionCompanyOrBuilder getMainManufacturerOrBuilder() {
            SingleFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> singleFieldBuilder = this.mainManufacturerBuilder_;
            if (singleFieldBuilder != null) {
                return (PlatformVersionCompanyOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            PlatformVersionCompany platformVersionCompany = this.mainManufacturer_;
            return platformVersionCompany == null ? PlatformVersionCompany.getDefaultInstance() : platformVersionCompany;
        }

        private SingleFieldBuilder<PlatformVersionCompany, PlatformVersionCompany.Builder, PlatformVersionCompanyOrBuilder> getMainManufacturerFieldBuilder() {
            if (this.mainManufacturerBuilder_ == null) {
                this.mainManufacturerBuilder_ = new SingleFieldBuilder<>(getMainManufacturer(), getParentForChildren(), isClean());
                this.mainManufacturer_ = null;
            }
            return this.mainManufacturerBuilder_;
        }

        @Override // proto.PlatformVersionOrBuilder
        public String getMedia() {
            Object obj = this.media_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.media_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionOrBuilder
        public ByteString getMediaBytes() {
            Object obj = this.media_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.media_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setMedia(String str) {
            str.getClass();
            this.media_ = str;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearMedia() {
            this.media_ = PlatformVersion.getDefaultInstance().getMedia();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setMediaBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersion.checkByteStringIsUtf8(byteString);
            this.media_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionOrBuilder
        public String getMemory() {
            Object obj = this.memory_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.memory_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionOrBuilder
        public ByteString getMemoryBytes() {
            Object obj = this.memory_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.memory_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setMemory(String str) {
            str.getClass();
            this.memory_ = str;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder clearMemory() {
            this.memory_ = PlatformVersion.getDefaultInstance().getMemory();
            this.bitField0_ &= -129;
            onChanged();
            return this;
        }

        public Builder setMemoryBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersion.checkByteStringIsUtf8(byteString);
            this.memory_ = byteString;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionOrBuilder
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
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = PlatformVersion.getDefaultInstance().getName();
            this.bitField0_ &= -257;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersion.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionOrBuilder
        public String getOnline() {
            Object obj = this.online_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.online_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionOrBuilder
        public ByteString getOnlineBytes() {
            Object obj = this.online_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.online_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setOnline(String str) {
            str.getClass();
            this.online_ = str;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder clearOnline() {
            this.online_ = PlatformVersion.getDefaultInstance().getOnline();
            this.bitField0_ &= -513;
            onChanged();
            return this;
        }

        public Builder setOnlineBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersion.checkByteStringIsUtf8(byteString);
            this.online_ = byteString;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionOrBuilder
        public String getOs() {
            Object obj = this.os_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.os_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionOrBuilder
        public ByteString getOsBytes() {
            Object obj = this.os_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.os_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setOs(String str) {
            str.getClass();
            this.os_ = str;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder clearOs() {
            this.os_ = PlatformVersion.getDefaultInstance().getOs();
            this.bitField0_ &= -1025;
            onChanged();
            return this;
        }

        public Builder setOsBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersion.checkByteStringIsUtf8(byteString);
            this.os_ = byteString;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionOrBuilder
        public String getOutput() {
            Object obj = this.output_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.output_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionOrBuilder
        public ByteString getOutputBytes() {
            Object obj = this.output_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.output_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setOutput(String str) {
            str.getClass();
            this.output_ = str;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder clearOutput() {
            this.output_ = PlatformVersion.getDefaultInstance().getOutput();
            this.bitField0_ &= -2049;
            onChanged();
            return this;
        }

        public Builder setOutputBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersion.checkByteStringIsUtf8(byteString);
            this.output_ = byteString;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionOrBuilder
        public boolean hasPlatformLogo() {
            return (this.bitField0_ & 4096) != 0;
        }

        @Override // proto.PlatformVersionOrBuilder
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
            this.bitField0_ |= 4096;
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
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder mergePlatformLogo(PlatformLogo platformLogo) {
            PlatformLogo platformLogo2;
            SingleFieldBuilder<PlatformLogo, PlatformLogo.Builder, PlatformLogoOrBuilder> singleFieldBuilder = this.platformLogoBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 4096) != 0 && (platformLogo2 = this.platformLogo_) != null && platformLogo2 != PlatformLogo.getDefaultInstance()) {
                    getPlatformLogoBuilder().mergeFrom((Message) platformLogo);
                } else {
                    this.platformLogo_ = platformLogo;
                }
            } else {
                singleFieldBuilder.mergeFrom(platformLogo);
            }
            if (this.platformLogo_ != null) {
                this.bitField0_ |= 4096;
                onChanged();
            }
            return this;
        }

        public Builder clearPlatformLogo() {
            this.bitField0_ &= -4097;
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
            this.bitField0_ |= 4096;
            onChanged();
            return (PlatformLogo.Builder) getPlatformLogoFieldBuilder().getBuilder();
        }

        @Override // proto.PlatformVersionOrBuilder
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

        private void ensurePlatformVersionReleaseDatesIsMutable() {
            if ((this.bitField0_ & 8192) == 0) {
                this.platformVersionReleaseDates_ = new ArrayList(this.platformVersionReleaseDates_);
                this.bitField0_ |= 8192;
            }
        }

        @Override // proto.PlatformVersionOrBuilder
        public List<PlatformVersionReleaseDate> getPlatformVersionReleaseDatesList() {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformVersionReleaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.platformVersionReleaseDates_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.PlatformVersionOrBuilder
        public int getPlatformVersionReleaseDatesCount() {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformVersionReleaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformVersionReleaseDates_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.PlatformVersionOrBuilder
        public PlatformVersionReleaseDate getPlatformVersionReleaseDates(int i) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformVersionReleaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformVersionReleaseDates_.get(i);
            }
            return (PlatformVersionReleaseDate) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setPlatformVersionReleaseDates(int i, PlatformVersionReleaseDate platformVersionReleaseDate) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformVersionReleaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersionReleaseDate.getClass();
                ensurePlatformVersionReleaseDatesIsMutable();
                this.platformVersionReleaseDates_.set(i, platformVersionReleaseDate);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, platformVersionReleaseDate);
            return this;
        }

        public Builder setPlatformVersionReleaseDates(int i, PlatformVersionReleaseDate.Builder builder) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformVersionReleaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformVersionReleaseDatesIsMutable();
                this.platformVersionReleaseDates_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addPlatformVersionReleaseDates(PlatformVersionReleaseDate platformVersionReleaseDate) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformVersionReleaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersionReleaseDate.getClass();
                ensurePlatformVersionReleaseDatesIsMutable();
                this.platformVersionReleaseDates_.add(platformVersionReleaseDate);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(platformVersionReleaseDate);
            return this;
        }

        public Builder addPlatformVersionReleaseDates(int i, PlatformVersionReleaseDate platformVersionReleaseDate) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformVersionReleaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                platformVersionReleaseDate.getClass();
                ensurePlatformVersionReleaseDatesIsMutable();
                this.platformVersionReleaseDates_.add(i, platformVersionReleaseDate);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, platformVersionReleaseDate);
            return this;
        }

        public Builder addPlatformVersionReleaseDates(PlatformVersionReleaseDate.Builder builder) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformVersionReleaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformVersionReleaseDatesIsMutable();
                this.platformVersionReleaseDates_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addPlatformVersionReleaseDates(int i, PlatformVersionReleaseDate.Builder builder) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformVersionReleaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformVersionReleaseDatesIsMutable();
                this.platformVersionReleaseDates_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllPlatformVersionReleaseDates(Iterable<? extends PlatformVersionReleaseDate> iterable) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformVersionReleaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformVersionReleaseDatesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.platformVersionReleaseDates_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearPlatformVersionReleaseDates() {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformVersionReleaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.platformVersionReleaseDates_ = Collections.emptyList();
                this.bitField0_ &= -8193;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removePlatformVersionReleaseDates(int i) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformVersionReleaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformVersionReleaseDatesIsMutable();
                this.platformVersionReleaseDates_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public PlatformVersionReleaseDate.Builder getPlatformVersionReleaseDatesBuilder(int i) {
            return (PlatformVersionReleaseDate.Builder) getPlatformVersionReleaseDatesFieldBuilder().getBuilder(i);
        }

        @Override // proto.PlatformVersionOrBuilder
        public PlatformVersionReleaseDateOrBuilder getPlatformVersionReleaseDatesOrBuilder(int i) {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformVersionReleaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platformVersionReleaseDates_.get(i);
            }
            return (PlatformVersionReleaseDateOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.PlatformVersionOrBuilder
        public List<? extends PlatformVersionReleaseDateOrBuilder> getPlatformVersionReleaseDatesOrBuilderList() {
            RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> repeatedFieldBuilder = this.platformVersionReleaseDatesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.platformVersionReleaseDates_);
        }

        public PlatformVersionReleaseDate.Builder addPlatformVersionReleaseDatesBuilder() {
            return (PlatformVersionReleaseDate.Builder) getPlatformVersionReleaseDatesFieldBuilder().addBuilder(PlatformVersionReleaseDate.getDefaultInstance());
        }

        public PlatformVersionReleaseDate.Builder addPlatformVersionReleaseDatesBuilder(int i) {
            return (PlatformVersionReleaseDate.Builder) getPlatformVersionReleaseDatesFieldBuilder().addBuilder(i, PlatformVersionReleaseDate.getDefaultInstance());
        }

        public List<PlatformVersionReleaseDate.Builder> getPlatformVersionReleaseDatesBuilderList() {
            return getPlatformVersionReleaseDatesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<PlatformVersionReleaseDate, PlatformVersionReleaseDate.Builder, PlatformVersionReleaseDateOrBuilder> getPlatformVersionReleaseDatesFieldBuilder() {
            if (this.platformVersionReleaseDatesBuilder_ == null) {
                this.platformVersionReleaseDatesBuilder_ = new RepeatedFieldBuilder<>(this.platformVersionReleaseDates_, (this.bitField0_ & 8192) != 0, getParentForChildren(), isClean());
                this.platformVersionReleaseDates_ = null;
            }
            return this.platformVersionReleaseDatesBuilder_;
        }

        @Override // proto.PlatformVersionOrBuilder
        public String getResolutions() {
            Object obj = this.resolutions_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.resolutions_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionOrBuilder
        public ByteString getResolutionsBytes() {
            Object obj = this.resolutions_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.resolutions_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setResolutions(String str) {
            str.getClass();
            this.resolutions_ = str;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder clearResolutions() {
            this.resolutions_ = PlatformVersion.getDefaultInstance().getResolutions();
            this.bitField0_ &= -16385;
            onChanged();
            return this;
        }

        public Builder setResolutionsBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersion.checkByteStringIsUtf8(byteString);
            this.resolutions_ = byteString;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionOrBuilder
        public String getSlug() {
            Object obj = this.slug_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.slug_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionOrBuilder
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
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        public Builder clearSlug() {
            this.slug_ = PlatformVersion.getDefaultInstance().getSlug();
            this.bitField0_ &= -32769;
            onChanged();
            return this;
        }

        public Builder setSlugBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersion.checkByteStringIsUtf8(byteString);
            this.slug_ = byteString;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionOrBuilder
        public String getSound() {
            Object obj = this.sound_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.sound_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionOrBuilder
        public ByteString getSoundBytes() {
            Object obj = this.sound_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sound_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setSound(String str) {
            str.getClass();
            this.sound_ = str;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        public Builder clearSound() {
            this.sound_ = PlatformVersion.getDefaultInstance().getSound();
            this.bitField0_ &= -65537;
            onChanged();
            return this;
        }

        public Builder setSoundBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersion.checkByteStringIsUtf8(byteString);
            this.sound_ = byteString;
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionOrBuilder
        public String getStorage() {
            Object obj = this.storage_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.storage_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionOrBuilder
        public ByteString getStorageBytes() {
            Object obj = this.storage_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.storage_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setStorage(String str) {
            str.getClass();
            this.storage_ = str;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        }

        public Builder clearStorage() {
            this.storage_ = PlatformVersion.getDefaultInstance().getStorage();
            this.bitField0_ &= -131073;
            onChanged();
            return this;
        }

        public Builder setStorageBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersion.checkByteStringIsUtf8(byteString);
            this.storage_ = byteString;
            this.bitField0_ |= 131072;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionOrBuilder
        public String getSummary() {
            Object obj = this.summary_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.summary_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionOrBuilder
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
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        }

        public Builder clearSummary() {
            this.summary_ = PlatformVersion.getDefaultInstance().getSummary();
            this.bitField0_ &= -262145;
            onChanged();
            return this;
        }

        public Builder setSummaryBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersion.checkByteStringIsUtf8(byteString);
            this.summary_ = byteString;
            this.bitField0_ |= 262144;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionOrBuilder
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
            this.bitField0_ |= 524288;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = PlatformVersion.getDefaultInstance().getUrl();
            this.bitField0_ &= -524289;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersion.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 524288;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionOrBuilder
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
            this.bitField0_ |= 1048576;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = PlatformVersion.getDefaultInstance().getChecksum();
            this.bitField0_ &= -1048577;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersion.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 1048576;
            onChanged();
            return this;
        }
    }

    public static PlatformVersion getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.PlatformVersion$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<PlatformVersion> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public PlatformVersion parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = PlatformVersion.newBuilder();
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

    public static Parser<PlatformVersion> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PlatformVersion> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PlatformVersion getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
