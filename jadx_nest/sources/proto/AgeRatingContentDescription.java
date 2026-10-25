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
public final class AgeRatingContentDescription extends GeneratedMessage implements AgeRatingContentDescriptionOrBuilder {
    public static final int CATEGORY_FIELD_NUMBER = 2;
    public static final int CHECKSUM_FIELD_NUMBER = 4;
    private static final AgeRatingContentDescription DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    private static final Parser<AgeRatingContentDescription> PARSER;
    private static final long serialVersionUID = 0;
    private int category_;
    private volatile Object checksum_;
    private volatile Object description_;
    private long id_;

    /* synthetic */ AgeRatingContentDescription(GeneratedMessage.Builder builder, AgeRatingContentDescriptionIA ageRatingContentDescriptionIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", AgeRatingContentDescription.class.getName());
        DEFAULT_INSTANCE = new AgeRatingContentDescription();
        PARSER = new AnonymousClass1();
    }

    private AgeRatingContentDescription(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.category_ = 0;
        this.description_ = "";
        this.checksum_ = "";
    }

    private AgeRatingContentDescription() {
        this.id_ = 0L;
        this.category_ = 0;
        this.description_ = "";
        this.checksum_ = "";
        this.category_ = 0;
        this.description_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_AgeRatingContentDescription_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_AgeRatingContentDescription_fieldAccessorTable.ensureFieldAccessorsInitialized(AgeRatingContentDescription.class, Builder.class);
    }

    @Override // proto.AgeRatingContentDescriptionOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.AgeRatingContentDescriptionOrBuilder
    public int getCategoryValue() {
        return this.category_;
    }

    @Override // proto.AgeRatingContentDescriptionOrBuilder
    public AgeRatingContentDescriptionCategoryEnum getCategory() {
        AgeRatingContentDescriptionCategoryEnum ageRatingContentDescriptionCategoryEnumForNumber = AgeRatingContentDescriptionCategoryEnum.forNumber(this.category_);
        return ageRatingContentDescriptionCategoryEnumForNumber == null ? AgeRatingContentDescriptionCategoryEnum.UNRECOGNIZED : ageRatingContentDescriptionCategoryEnumForNumber;
    }

    @Override // proto.AgeRatingContentDescriptionOrBuilder
    public String getDescription() {
        Object obj = this.description_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.description_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.AgeRatingContentDescriptionOrBuilder
    public ByteString getDescriptionBytes() {
        Object obj = this.description_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.description_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.AgeRatingContentDescriptionOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.AgeRatingContentDescriptionOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static AgeRatingContentDescription parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static AgeRatingContentDescription parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static AgeRatingContentDescription parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static AgeRatingContentDescription parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static AgeRatingContentDescription parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static AgeRatingContentDescription parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static AgeRatingContentDescription parseFrom(InputStream inputStream) throws IOException {
        return (AgeRatingContentDescription) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static AgeRatingContentDescription parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgeRatingContentDescription) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AgeRatingContentDescription parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AgeRatingContentDescription) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static AgeRatingContentDescription parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgeRatingContentDescription) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AgeRatingContentDescription parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AgeRatingContentDescription) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static AgeRatingContentDescription parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgeRatingContentDescription) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(AgeRatingContentDescription ageRatingContentDescription) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) ageRatingContentDescription);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((AgeRatingContentDescriptionIA) null) : (Builder) new Builder((AgeRatingContentDescriptionIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements AgeRatingContentDescriptionOrBuilder {
        private int bitField0_;
        private int category_;
        private Object checksum_;
        private Object description_;
        private long id_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, AgeRatingContentDescriptionIA ageRatingContentDescriptionIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(AgeRatingContentDescriptionIA ageRatingContentDescriptionIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_AgeRatingContentDescription_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_AgeRatingContentDescription_fieldAccessorTable.ensureFieldAccessorsInitialized(AgeRatingContentDescription.class, Builder.class);
        }

        private Builder() {
            this.category_ = 0;
            this.description_ = "";
            this.checksum_ = "";
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.category_ = 0;
            this.description_ = "";
            this.checksum_ = "";
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.category_ = 0;
            this.description_ = "";
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_AgeRatingContentDescription_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AgeRatingContentDescription getDefaultInstanceForType() {
            return AgeRatingContentDescription.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AgeRatingContentDescription build() {
            AgeRatingContentDescription ageRatingContentDescriptionBuildPartial = buildPartial();
            if (ageRatingContentDescriptionBuildPartial.isInitialized()) {
                return ageRatingContentDescriptionBuildPartial;
            }
            throw newUninitializedMessageException((Message) ageRatingContentDescriptionBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AgeRatingContentDescription buildPartial() {
            AgeRatingContentDescription ageRatingContentDescription = new AgeRatingContentDescription(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(ageRatingContentDescription);
            }
            onBuilt();
            return ageRatingContentDescription;
        }

        private void buildPartial0(AgeRatingContentDescription ageRatingContentDescription) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                ageRatingContentDescription.id_ = this.id_;
            }
            if ((i & 2) != 0) {
                ageRatingContentDescription.category_ = this.category_;
            }
            if ((i & 4) != 0) {
                ageRatingContentDescription.description_ = this.description_;
            }
            if ((i & 8) != 0) {
                ageRatingContentDescription.checksum_ = this.checksum_;
            }
        }

        @Override // proto.AgeRatingContentDescriptionOrBuilder
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

        @Override // proto.AgeRatingContentDescriptionOrBuilder
        public int getCategoryValue() {
            return this.category_;
        }

        public Builder setCategoryValue(int i) {
            this.category_ = i;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.AgeRatingContentDescriptionOrBuilder
        public AgeRatingContentDescriptionCategoryEnum getCategory() {
            AgeRatingContentDescriptionCategoryEnum ageRatingContentDescriptionCategoryEnumForNumber = AgeRatingContentDescriptionCategoryEnum.forNumber(this.category_);
            return ageRatingContentDescriptionCategoryEnumForNumber == null ? AgeRatingContentDescriptionCategoryEnum.UNRECOGNIZED : ageRatingContentDescriptionCategoryEnumForNumber;
        }

        public Builder setCategory(AgeRatingContentDescriptionCategoryEnum ageRatingContentDescriptionCategoryEnum) {
            ageRatingContentDescriptionCategoryEnum.getClass();
            this.bitField0_ |= 2;
            this.category_ = ageRatingContentDescriptionCategoryEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearCategory() {
            this.bitField0_ &= -3;
            this.category_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.AgeRatingContentDescriptionOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.description_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.AgeRatingContentDescriptionOrBuilder
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
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearDescription() {
            this.description_ = AgeRatingContentDescription.getDefaultInstance().getDescription();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            byteString.getClass();
            AgeRatingContentDescription.checkByteStringIsUtf8(byteString);
            this.description_ = byteString;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // proto.AgeRatingContentDescriptionOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.AgeRatingContentDescriptionOrBuilder
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
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = AgeRatingContentDescription.getDefaultInstance().getChecksum();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            AgeRatingContentDescription.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }
    }

    public static AgeRatingContentDescription getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.AgeRatingContentDescription$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<AgeRatingContentDescription> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public AgeRatingContentDescription parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = AgeRatingContentDescription.newBuilder();
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

    public static Parser<AgeRatingContentDescription> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AgeRatingContentDescription> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public AgeRatingContentDescription getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
