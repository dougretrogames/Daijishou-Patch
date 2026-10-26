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
public final class CompanyLogo extends GeneratedMessage implements CompanyLogoOrBuilder {
    public static final int ALPHA_CHANNEL_FIELD_NUMBER = 2;
    public static final int ANIMATED_FIELD_NUMBER = 3;
    public static final int CHECKSUM_FIELD_NUMBER = 8;
    private static final CompanyLogo DEFAULT_INSTANCE;
    public static final int HEIGHT_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IMAGE_ID_FIELD_NUMBER = 5;
    private static final Parser<CompanyLogo> PARSER;
    public static final int URL_FIELD_NUMBER = 6;
    public static final int WIDTH_FIELD_NUMBER = 7;
    private static final long serialVersionUID = 0;
    private boolean alphaChannel_;
    private boolean animated_;
    private volatile Object checksum_;
    private int height_;
    private long id_;
    private volatile Object imageId_;
    private volatile Object url_;
    private int width_;

    /* synthetic */ CompanyLogo(GeneratedMessage.Builder builder, CompanyLogoIA companyLogoIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", CompanyLogo.class.getName());
        DEFAULT_INSTANCE = new CompanyLogo();
        PARSER = new AnonymousClass1();
    }

    private CompanyLogo(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.alphaChannel_ = false;
        this.animated_ = false;
        this.height_ = 0;
        this.imageId_ = "";
        this.url_ = "";
        this.width_ = 0;
        this.checksum_ = "";
    }

    private CompanyLogo() {
        this.id_ = 0L;
        this.alphaChannel_ = false;
        this.animated_ = false;
        this.height_ = 0;
        this.imageId_ = "";
        this.url_ = "";
        this.width_ = 0;
        this.checksum_ = "";
        this.imageId_ = "";
        this.url_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_CompanyLogo_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_CompanyLogo_fieldAccessorTable.ensureFieldAccessorsInitialized(CompanyLogo.class, Builder.class);
    }

    @Override // proto.CompanyLogoOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.CompanyLogoOrBuilder
    public boolean getAlphaChannel() {
        return this.alphaChannel_;
    }

    @Override // proto.CompanyLogoOrBuilder
    public boolean getAnimated() {
        return this.animated_;
    }

    @Override // proto.CompanyLogoOrBuilder
    public int getHeight() {
        return this.height_;
    }

    @Override // proto.CompanyLogoOrBuilder
    public String getImageId() {
        Object obj = this.imageId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.imageId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CompanyLogoOrBuilder
    public ByteString getImageIdBytes() {
        Object obj = this.imageId_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.imageId_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CompanyLogoOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CompanyLogoOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CompanyLogoOrBuilder
    public int getWidth() {
        return this.width_;
    }

    @Override // proto.CompanyLogoOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CompanyLogoOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static CompanyLogo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CompanyLogo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CompanyLogo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CompanyLogo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CompanyLogo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CompanyLogo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static CompanyLogo parseFrom(InputStream inputStream) throws IOException {
        return (CompanyLogo) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static CompanyLogo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompanyLogo) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CompanyLogo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CompanyLogo) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CompanyLogo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompanyLogo) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CompanyLogo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CompanyLogo) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static CompanyLogo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CompanyLogo) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(CompanyLogo companyLogo) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) companyLogo);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CompanyLogoIA) null) : (Builder) new Builder((CompanyLogoIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CompanyLogoOrBuilder {
        private boolean alphaChannel_;
        private boolean animated_;
        private int bitField0_;
        private Object checksum_;
        private int height_;
        private long id_;
        private Object imageId_;
        private Object url_;
        private int width_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CompanyLogoIA companyLogoIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CompanyLogoIA companyLogoIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_CompanyLogo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_CompanyLogo_fieldAccessorTable.ensureFieldAccessorsInitialized(CompanyLogo.class, Builder.class);
        }

        private Builder() {
            this.imageId_ = "";
            this.url_ = "";
            this.checksum_ = "";
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.imageId_ = "";
            this.url_ = "";
            this.checksum_ = "";
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.alphaChannel_ = false;
            this.animated_ = false;
            this.height_ = 0;
            this.imageId_ = "";
            this.url_ = "";
            this.width_ = 0;
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_CompanyLogo_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CompanyLogo getDefaultInstanceForType() {
            return CompanyLogo.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CompanyLogo build() {
            CompanyLogo companyLogoBuildPartial = buildPartial();
            if (companyLogoBuildPartial.isInitialized()) {
                return companyLogoBuildPartial;
            }
            throw newUninitializedMessageException((Message) companyLogoBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CompanyLogo buildPartial() {
            CompanyLogo companyLogo = new CompanyLogo(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(companyLogo);
            }
            onBuilt();
            return companyLogo;
        }

        private void buildPartial0(CompanyLogo companyLogo) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                companyLogo.id_ = this.id_;
            }
            if ((i & 2) != 0) {
                companyLogo.alphaChannel_ = this.alphaChannel_;
            }
            if ((i & 4) != 0) {
                companyLogo.animated_ = this.animated_;
            }
            if ((i & 8) != 0) {
                companyLogo.height_ = this.height_;
            }
            if ((i & 16) != 0) {
                companyLogo.imageId_ = this.imageId_;
            }
            if ((i & 32) != 0) {
                companyLogo.url_ = this.url_;
            }
            if ((i & 64) != 0) {
                companyLogo.width_ = this.width_;
            }
            if ((i & 128) != 0) {
                companyLogo.checksum_ = this.checksum_;
            }
        }

        @Override // proto.CompanyLogoOrBuilder
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

        @Override // proto.CompanyLogoOrBuilder
        public boolean getAlphaChannel() {
            return this.alphaChannel_;
        }

        public Builder setAlphaChannel(boolean z) {
            this.alphaChannel_ = z;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder clearAlphaChannel() {
            this.bitField0_ &= -3;
            this.alphaChannel_ = false;
            onChanged();
            return this;
        }

        @Override // proto.CompanyLogoOrBuilder
        public boolean getAnimated() {
            return this.animated_;
        }

        public Builder setAnimated(boolean z) {
            this.animated_ = z;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearAnimated() {
            this.bitField0_ &= -5;
            this.animated_ = false;
            onChanged();
            return this;
        }

        @Override // proto.CompanyLogoOrBuilder
        public int getHeight() {
            return this.height_;
        }

        public Builder setHeight(int i) {
            this.height_ = i;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder clearHeight() {
            this.bitField0_ &= -9;
            this.height_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.CompanyLogoOrBuilder
        public String getImageId() {
            Object obj = this.imageId_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.imageId_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CompanyLogoOrBuilder
        public ByteString getImageIdBytes() {
            Object obj = this.imageId_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imageId_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setImageId(String str) {
            str.getClass();
            this.imageId_ = str;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearImageId() {
            this.imageId_ = CompanyLogo.getDefaultInstance().getImageId();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder setImageIdBytes(ByteString byteString) {
            byteString.getClass();
            CompanyLogo.checkByteStringIsUtf8(byteString);
            this.imageId_ = byteString;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        @Override // proto.CompanyLogoOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CompanyLogoOrBuilder
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
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = CompanyLogo.getDefaultInstance().getUrl();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            CompanyLogo.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        @Override // proto.CompanyLogoOrBuilder
        public int getWidth() {
            return this.width_;
        }

        public Builder setWidth(int i) {
            this.width_ = i;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearWidth() {
            this.bitField0_ &= -65;
            this.width_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.CompanyLogoOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CompanyLogoOrBuilder
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
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = CompanyLogo.getDefaultInstance().getChecksum();
            this.bitField0_ &= -129;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            CompanyLogo.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }
    }

    public static CompanyLogo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.CompanyLogo$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<CompanyLogo> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public CompanyLogo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = CompanyLogo.newBuilder();
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

    public static Parser<CompanyLogo> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CompanyLogo> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CompanyLogo getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
