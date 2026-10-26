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

/* INFO: loaded from: classes6.dex */
public final class PlatformWebsite extends GeneratedMessage implements PlatformWebsiteOrBuilder {
    public static final int CATEGORY_FIELD_NUMBER = 2;
    public static final int CHECKSUM_FIELD_NUMBER = 5;
    private static final PlatformWebsite DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static final Parser<PlatformWebsite> PARSER;
    public static final int TRUSTED_FIELD_NUMBER = 3;
    public static final int URL_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private int category_;
    private volatile Object checksum_;
    private long id_;
    private boolean trusted_;
    private volatile Object url_;

    /* synthetic */ PlatformWebsite(GeneratedMessage.Builder builder, PlatformWebsiteIA platformWebsiteIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PlatformWebsite.class.getName());
        DEFAULT_INSTANCE = new PlatformWebsite();
        PARSER = new AnonymousClass1();
    }

    private PlatformWebsite(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.category_ = 0;
        this.trusted_ = false;
        this.url_ = "";
        this.checksum_ = "";
    }

    private PlatformWebsite() {
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
        return Igdbproto.internal_static_proto_PlatformWebsite_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_PlatformWebsite_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformWebsite.class, Builder.class);
    }

    @Override // proto.PlatformWebsiteOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.PlatformWebsiteOrBuilder
    public int getCategoryValue() {
        return this.category_;
    }

    @Override // proto.PlatformWebsiteOrBuilder
    public WebsiteCategoryEnum getCategory() {
        WebsiteCategoryEnum websiteCategoryEnumForNumber = WebsiteCategoryEnum.forNumber(this.category_);
        return websiteCategoryEnumForNumber == null ? WebsiteCategoryEnum.UNRECOGNIZED : websiteCategoryEnumForNumber;
    }

    @Override // proto.PlatformWebsiteOrBuilder
    public boolean getTrusted() {
        return this.trusted_;
    }

    @Override // proto.PlatformWebsiteOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformWebsiteOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformWebsiteOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformWebsiteOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static PlatformWebsite parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PlatformWebsite parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlatformWebsite parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PlatformWebsite parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PlatformWebsite parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PlatformWebsite parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PlatformWebsite parseFrom(InputStream inputStream) throws IOException {
        return (PlatformWebsite) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PlatformWebsite parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformWebsite) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformWebsite parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PlatformWebsite) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlatformWebsite parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformWebsite) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformWebsite parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PlatformWebsite) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlatformWebsite parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformWebsite) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(PlatformWebsite platformWebsite) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) platformWebsite);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((PlatformWebsiteIA) null) : (Builder) new Builder((PlatformWebsiteIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlatformWebsiteOrBuilder {
        private int bitField0_;
        private int category_;
        private Object checksum_;
        private long id_;
        private boolean trusted_;
        private Object url_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, PlatformWebsiteIA platformWebsiteIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(PlatformWebsiteIA platformWebsiteIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_PlatformWebsite_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_PlatformWebsite_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformWebsite.class, Builder.class);
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
            return Igdbproto.internal_static_proto_PlatformWebsite_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlatformWebsite getDefaultInstanceForType() {
            return PlatformWebsite.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformWebsite build() {
            PlatformWebsite platformWebsiteBuildPartial = buildPartial();
            if (platformWebsiteBuildPartial.isInitialized()) {
                return platformWebsiteBuildPartial;
            }
            throw newUninitializedMessageException((Message) platformWebsiteBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformWebsite buildPartial() {
            PlatformWebsite platformWebsite = new PlatformWebsite(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(platformWebsite);
            }
            onBuilt();
            return platformWebsite;
        }

        private void buildPartial0(PlatformWebsite platformWebsite) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                platformWebsite.id_ = this.id_;
            }
            if ((i & 2) != 0) {
                platformWebsite.category_ = this.category_;
            }
            if ((i & 4) != 0) {
                platformWebsite.trusted_ = this.trusted_;
            }
            if ((i & 8) != 0) {
                platformWebsite.url_ = this.url_;
            }
            if ((i & 16) != 0) {
                platformWebsite.checksum_ = this.checksum_;
            }
        }

        @Override // proto.PlatformWebsiteOrBuilder
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

        @Override // proto.PlatformWebsiteOrBuilder
        public int getCategoryValue() {
            return this.category_;
        }

        public Builder setCategoryValue(int i) {
            this.category_ = i;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.PlatformWebsiteOrBuilder
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

        @Override // proto.PlatformWebsiteOrBuilder
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

        @Override // proto.PlatformWebsiteOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformWebsiteOrBuilder
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
            this.url_ = PlatformWebsite.getDefaultInstance().getUrl();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            PlatformWebsite.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // proto.PlatformWebsiteOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformWebsiteOrBuilder
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
            this.checksum_ = PlatformWebsite.getDefaultInstance().getChecksum();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            PlatformWebsite.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }
    }

    public static PlatformWebsite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.PlatformWebsite$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<PlatformWebsite> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public PlatformWebsite parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = PlatformWebsite.newBuilder();
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

    public static Parser<PlatformWebsite> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PlatformWebsite> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PlatformWebsite getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
