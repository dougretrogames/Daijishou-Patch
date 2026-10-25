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
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public final class PlatformVersionReleaseDate extends GeneratedMessage implements PlatformVersionReleaseDateOrBuilder {
    public static final int CATEGORY_FIELD_NUMBER = 2;
    public static final int CHECKSUM_FIELD_NUMBER = 11;
    public static final int CREATED_AT_FIELD_NUMBER = 3;
    public static final int DATE_FIELD_NUMBER = 4;
    private static final PlatformVersionReleaseDate DEFAULT_INSTANCE;
    public static final int HUMAN_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int M_FIELD_NUMBER = 6;
    private static final Parser<PlatformVersionReleaseDate> PARSER;
    public static final int PLATFORM_VERSION_FIELD_NUMBER = 7;
    public static final int REGION_FIELD_NUMBER = 8;
    public static final int UPDATED_AT_FIELD_NUMBER = 9;
    public static final int Y_FIELD_NUMBER = 10;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int category_;
    private volatile Object checksum_;
    private Timestamp createdAt_;
    private Timestamp date_;
    private volatile Object human_;
    private long id_;
    private int m_;
    private PlatformVersion platformVersion_;
    private int region_;
    private Timestamp updatedAt_;
    private int y_;

    /* synthetic */ PlatformVersionReleaseDate(GeneratedMessage.Builder builder, PlatformVersionReleaseDateIA platformVersionReleaseDateIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PlatformVersionReleaseDate.class.getName());
        DEFAULT_INSTANCE = new PlatformVersionReleaseDate();
        PARSER = new AnonymousClass1();
    }

    private PlatformVersionReleaseDate(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.category_ = 0;
        this.human_ = "";
        this.m_ = 0;
        this.region_ = 0;
        this.y_ = 0;
        this.checksum_ = "";
    }

    private PlatformVersionReleaseDate() {
        this.id_ = 0L;
        this.category_ = 0;
        this.human_ = "";
        this.m_ = 0;
        this.region_ = 0;
        this.y_ = 0;
        this.checksum_ = "";
        this.category_ = 0;
        this.human_ = "";
        this.region_ = 0;
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_PlatformVersionReleaseDate_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_PlatformVersionReleaseDate_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformVersionReleaseDate.class, Builder.class);
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public int getCategoryValue() {
        return this.category_;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public DateFormatChangeDateCategoryEnum getCategory() {
        DateFormatChangeDateCategoryEnum dateFormatChangeDateCategoryEnumForNumber = DateFormatChangeDateCategoryEnum.forNumber(this.category_);
        return dateFormatChangeDateCategoryEnumForNumber == null ? DateFormatChangeDateCategoryEnum.UNRECOGNIZED : dateFormatChangeDateCategoryEnumForNumber;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public boolean hasDate() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public Timestamp getDate() {
        Timestamp timestamp = this.date_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public TimestampOrBuilder getDateOrBuilder() {
        Timestamp timestamp = this.date_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public String getHuman() {
        Object obj = this.human_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.human_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public ByteString getHumanBytes() {
        Object obj = this.human_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.human_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public int getM() {
        return this.m_;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public boolean hasPlatformVersion() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public PlatformVersion getPlatformVersion() {
        PlatformVersion platformVersion = this.platformVersion_;
        return platformVersion == null ? PlatformVersion.getDefaultInstance() : platformVersion;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public PlatformVersionOrBuilder getPlatformVersionOrBuilder() {
        PlatformVersion platformVersion = this.platformVersion_;
        return platformVersion == null ? PlatformVersion.getDefaultInstance() : platformVersion;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public int getRegionValue() {
        return this.region_;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public RegionRegionEnum getRegion() {
        RegionRegionEnum regionRegionEnumForNumber = RegionRegionEnum.forNumber(this.region_);
        return regionRegionEnumForNumber == null ? RegionRegionEnum.UNRECOGNIZED : regionRegionEnumForNumber;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public int getY() {
        return this.y_;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.PlatformVersionReleaseDateOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static PlatformVersionReleaseDate parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PlatformVersionReleaseDate parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlatformVersionReleaseDate parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PlatformVersionReleaseDate parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PlatformVersionReleaseDate parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PlatformVersionReleaseDate parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PlatformVersionReleaseDate parseFrom(InputStream inputStream) throws IOException {
        return (PlatformVersionReleaseDate) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PlatformVersionReleaseDate parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersionReleaseDate) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformVersionReleaseDate parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PlatformVersionReleaseDate) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlatformVersionReleaseDate parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersionReleaseDate) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformVersionReleaseDate parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PlatformVersionReleaseDate) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlatformVersionReleaseDate parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformVersionReleaseDate) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(PlatformVersionReleaseDate platformVersionReleaseDate) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) platformVersionReleaseDate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((PlatformVersionReleaseDateIA) null) : (Builder) new Builder((PlatformVersionReleaseDateIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlatformVersionReleaseDateOrBuilder {
        private int bitField0_;
        private int category_;
        private Object checksum_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> dateBuilder_;
        private Timestamp date_;
        private Object human_;
        private long id_;
        private int m_;
        private SingleFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> platformVersionBuilder_;
        private PlatformVersion platformVersion_;
        private int region_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;
        private int y_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, PlatformVersionReleaseDateIA platformVersionReleaseDateIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(PlatformVersionReleaseDateIA platformVersionReleaseDateIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_PlatformVersionReleaseDate_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_PlatformVersionReleaseDate_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformVersionReleaseDate.class, Builder.class);
        }

        private Builder() {
            this.category_ = 0;
            this.human_ = "";
            this.region_ = 0;
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.category_ = 0;
            this.human_ = "";
            this.region_ = 0;
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (PlatformVersionReleaseDate.alwaysUseFieldBuilders) {
                getCreatedAtFieldBuilder();
                getDateFieldBuilder();
                getPlatformVersionFieldBuilder();
                getUpdatedAtFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.category_ = 0;
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.createdAtBuilder_ = null;
            }
            this.date_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.dateBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.dateBuilder_ = null;
            }
            this.human_ = "";
            this.m_ = 0;
            this.platformVersion_ = null;
            SingleFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> singleFieldBuilder3 = this.platformVersionBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.platformVersionBuilder_ = null;
            }
            this.region_ = 0;
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.updatedAtBuilder_;
            if (singleFieldBuilder4 != null) {
                singleFieldBuilder4.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.y_ = 0;
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_PlatformVersionReleaseDate_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlatformVersionReleaseDate getDefaultInstanceForType() {
            return PlatformVersionReleaseDate.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformVersionReleaseDate build() {
            PlatformVersionReleaseDate platformVersionReleaseDateBuildPartial = buildPartial();
            if (platformVersionReleaseDateBuildPartial.isInitialized()) {
                return platformVersionReleaseDateBuildPartial;
            }
            throw newUninitializedMessageException((Message) platformVersionReleaseDateBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformVersionReleaseDate buildPartial() {
            PlatformVersionReleaseDate platformVersionReleaseDate = new PlatformVersionReleaseDate(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(platformVersionReleaseDate);
            }
            onBuilt();
            return platformVersionReleaseDate;
        }

        private void buildPartial0(PlatformVersionReleaseDate platformVersionReleaseDate) {
            int i;
            Timestamp timestamp;
            PlatformVersion platformVersion;
            Timestamp timestamp2;
            Timestamp timestamp3;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                platformVersionReleaseDate.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                platformVersionReleaseDate.category_ = this.category_;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
                if (singleFieldBuilder == null) {
                    timestamp3 = this.createdAt_;
                } else {
                    timestamp3 = (Timestamp) singleFieldBuilder.build();
                }
                platformVersionReleaseDate.createdAt_ = timestamp3;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.dateBuilder_;
                if (singleFieldBuilder2 == null) {
                    timestamp2 = this.date_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder2.build();
                }
                platformVersionReleaseDate.date_ = timestamp2;
                i |= 2;
            }
            if ((i2 & 16) != 0) {
                platformVersionReleaseDate.human_ = this.human_;
            }
            if ((i2 & 32) != 0) {
                platformVersionReleaseDate.m_ = this.m_;
            }
            if ((i2 & 64) != 0) {
                SingleFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> singleFieldBuilder3 = this.platformVersionBuilder_;
                if (singleFieldBuilder3 == null) {
                    platformVersion = this.platformVersion_;
                } else {
                    platformVersion = (PlatformVersion) singleFieldBuilder3.build();
                }
                platformVersionReleaseDate.platformVersion_ = platformVersion;
                i |= 4;
            }
            if ((i2 & 128) != 0) {
                platformVersionReleaseDate.region_ = this.region_;
            }
            if ((i2 & 256) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.updatedAtBuilder_;
                if (singleFieldBuilder4 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder4.build();
                }
                platformVersionReleaseDate.updatedAt_ = timestamp;
                i |= 8;
            }
            if ((i2 & 512) != 0) {
                platformVersionReleaseDate.y_ = this.y_;
            }
            if ((i2 & 1024) != 0) {
                platformVersionReleaseDate.checksum_ = this.checksum_;
            }
            platformVersionReleaseDate.bitField0_ |= i;
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
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

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public int getCategoryValue() {
            return this.category_;
        }

        public Builder setCategoryValue(int i) {
            this.category_ = i;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public DateFormatChangeDateCategoryEnum getCategory() {
            DateFormatChangeDateCategoryEnum dateFormatChangeDateCategoryEnumForNumber = DateFormatChangeDateCategoryEnum.forNumber(this.category_);
            return dateFormatChangeDateCategoryEnumForNumber == null ? DateFormatChangeDateCategoryEnum.UNRECOGNIZED : dateFormatChangeDateCategoryEnumForNumber;
        }

        public Builder setCategory(DateFormatChangeDateCategoryEnum dateFormatChangeDateCategoryEnum) {
            dateFormatChangeDateCategoryEnum.getClass();
            this.bitField0_ |= 2;
            this.category_ = dateFormatChangeDateCategoryEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearCategory() {
            this.bitField0_ &= -3;
            this.category_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
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
            this.bitField0_ |= 4;
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
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder mergeCreatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0 && (timestamp2 = this.createdAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getCreatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.createdAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.createdAt_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder clearCreatedAt() {
            this.bitField0_ &= -5;
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
            this.bitField0_ |= 4;
            onChanged();
            return (Timestamp.Builder) getCreatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
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

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public boolean hasDate() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public Timestamp getDate() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.dateBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.date_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setDate(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.dateBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.date_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setDate(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.dateBuilder_;
            if (singleFieldBuilder == null) {
                this.date_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder mergeDate(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.dateBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 8) != 0 && (timestamp2 = this.date_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getDateBuilder().mergeFrom(timestamp);
                } else {
                    this.date_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.date_ != null) {
                this.bitField0_ |= 8;
                onChanged();
            }
            return this;
        }

        public Builder clearDate() {
            this.bitField0_ &= -9;
            this.date_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.dateBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.dateBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getDateBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (Timestamp.Builder) getDateFieldBuilder().getBuilder();
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public TimestampOrBuilder getDateOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.dateBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.date_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getDateFieldBuilder() {
            if (this.dateBuilder_ == null) {
                this.dateBuilder_ = new SingleFieldBuilder<>(getDate(), getParentForChildren(), isClean());
                this.date_ = null;
            }
            return this.dateBuilder_;
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public String getHuman() {
            Object obj = this.human_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.human_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public ByteString getHumanBytes() {
            Object obj = this.human_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.human_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setHuman(String str) {
            str.getClass();
            this.human_ = str;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearHuman() {
            this.human_ = PlatformVersionReleaseDate.getDefaultInstance().getHuman();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder setHumanBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersionReleaseDate.checkByteStringIsUtf8(byteString);
            this.human_ = byteString;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public int getM() {
            return this.m_;
        }

        public Builder setM(int i) {
            this.m_ = i;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearM() {
            this.bitField0_ &= -33;
            this.m_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public boolean hasPlatformVersion() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public PlatformVersion getPlatformVersion() {
            SingleFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> singleFieldBuilder = this.platformVersionBuilder_;
            if (singleFieldBuilder == null) {
                PlatformVersion platformVersion = this.platformVersion_;
                return platformVersion == null ? PlatformVersion.getDefaultInstance() : platformVersion;
            }
            return (PlatformVersion) singleFieldBuilder.getMessage();
        }

        public Builder setPlatformVersion(PlatformVersion platformVersion) {
            SingleFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> singleFieldBuilder = this.platformVersionBuilder_;
            if (singleFieldBuilder == null) {
                platformVersion.getClass();
                this.platformVersion_ = platformVersion;
            } else {
                singleFieldBuilder.setMessage(platformVersion);
            }
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setPlatformVersion(PlatformVersion.Builder builder) {
            SingleFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> singleFieldBuilder = this.platformVersionBuilder_;
            if (singleFieldBuilder == null) {
                this.platformVersion_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder mergePlatformVersion(PlatformVersion platformVersion) {
            PlatformVersion platformVersion2;
            SingleFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> singleFieldBuilder = this.platformVersionBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 64) != 0 && (platformVersion2 = this.platformVersion_) != null && platformVersion2 != PlatformVersion.getDefaultInstance()) {
                    getPlatformVersionBuilder().mergeFrom((Message) platformVersion);
                } else {
                    this.platformVersion_ = platformVersion;
                }
            } else {
                singleFieldBuilder.mergeFrom(platformVersion);
            }
            if (this.platformVersion_ != null) {
                this.bitField0_ |= 64;
                onChanged();
            }
            return this;
        }

        public Builder clearPlatformVersion() {
            this.bitField0_ &= -65;
            this.platformVersion_ = null;
            SingleFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> singleFieldBuilder = this.platformVersionBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.platformVersionBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public PlatformVersion.Builder getPlatformVersionBuilder() {
            this.bitField0_ |= 64;
            onChanged();
            return (PlatformVersion.Builder) getPlatformVersionFieldBuilder().getBuilder();
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public PlatformVersionOrBuilder getPlatformVersionOrBuilder() {
            SingleFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> singleFieldBuilder = this.platformVersionBuilder_;
            if (singleFieldBuilder != null) {
                return (PlatformVersionOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            PlatformVersion platformVersion = this.platformVersion_;
            return platformVersion == null ? PlatformVersion.getDefaultInstance() : platformVersion;
        }

        private SingleFieldBuilder<PlatformVersion, PlatformVersion.Builder, PlatformVersionOrBuilder> getPlatformVersionFieldBuilder() {
            if (this.platformVersionBuilder_ == null) {
                this.platformVersionBuilder_ = new SingleFieldBuilder<>(getPlatformVersion(), getParentForChildren(), isClean());
                this.platformVersion_ = null;
            }
            return this.platformVersionBuilder_;
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public int getRegionValue() {
            return this.region_;
        }

        public Builder setRegionValue(int i) {
            this.region_ = i;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public RegionRegionEnum getRegion() {
            RegionRegionEnum regionRegionEnumForNumber = RegionRegionEnum.forNumber(this.region_);
            return regionRegionEnumForNumber == null ? RegionRegionEnum.UNRECOGNIZED : regionRegionEnumForNumber;
        }

        public Builder setRegion(RegionRegionEnum regionRegionEnum) {
            regionRegionEnum.getClass();
            this.bitField0_ |= 128;
            this.region_ = regionRegionEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearRegion() {
            this.bitField0_ &= -129;
            this.region_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
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
            this.bitField0_ |= 256;
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
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder mergeUpdatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 256) != 0 && (timestamp2 = this.updatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getUpdatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.updatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.updatedAt_ != null) {
                this.bitField0_ |= 256;
                onChanged();
            }
            return this;
        }

        public Builder clearUpdatedAt() {
            this.bitField0_ &= -257;
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
            this.bitField0_ |= 256;
            onChanged();
            return (Timestamp.Builder) getUpdatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
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

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public int getY() {
            return this.y_;
        }

        public Builder setY(int i) {
            this.y_ = i;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder clearY() {
            this.bitField0_ &= -513;
            this.y_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.PlatformVersionReleaseDateOrBuilder
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
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = PlatformVersionReleaseDate.getDefaultInstance().getChecksum();
            this.bitField0_ &= -1025;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            PlatformVersionReleaseDate.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }
    }

    public static PlatformVersionReleaseDate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.PlatformVersionReleaseDate$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<PlatformVersionReleaseDate> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public PlatformVersionReleaseDate parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = PlatformVersionReleaseDate.newBuilder();
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

    public static Parser<PlatformVersionReleaseDate> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PlatformVersionReleaseDate> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PlatformVersionReleaseDate getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
