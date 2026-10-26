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

/* INFO: loaded from: classes6.dex */
public final class ReleaseDate extends GeneratedMessage implements ReleaseDateOrBuilder {
    public static final int CATEGORY_FIELD_NUMBER = 2;
    public static final int CHECKSUM_FIELD_NUMBER = 12;
    public static final int CREATED_AT_FIELD_NUMBER = 3;
    public static final int DATE_FIELD_NUMBER = 4;
    private static final ReleaseDate DEFAULT_INSTANCE;
    public static final int GAME_FIELD_NUMBER = 5;
    public static final int HUMAN_FIELD_NUMBER = 6;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int M_FIELD_NUMBER = 7;
    private static final Parser<ReleaseDate> PARSER;
    public static final int PLATFORM_FIELD_NUMBER = 8;
    public static final int REGION_FIELD_NUMBER = 9;
    public static final int STATUS_FIELD_NUMBER = 13;
    public static final int UPDATED_AT_FIELD_NUMBER = 10;
    public static final int Y_FIELD_NUMBER = 11;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int category_;
    private volatile Object checksum_;
    private Timestamp createdAt_;
    private Timestamp date_;
    private Game game_;
    private volatile Object human_;
    private long id_;
    private int m_;
    private Platform platform_;
    private int region_;
    private ReleaseDateStatus status_;
    private Timestamp updatedAt_;
    private int y_;

    /* synthetic */ ReleaseDate(GeneratedMessage.Builder builder, ReleaseDateIA releaseDateIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", ReleaseDate.class.getName());
        DEFAULT_INSTANCE = new ReleaseDate();
        PARSER = new AnonymousClass1();
    }

    private ReleaseDate(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.category_ = 0;
        this.human_ = "";
        this.m_ = 0;
        this.region_ = 0;
        this.y_ = 0;
        this.checksum_ = "";
    }

    private ReleaseDate() {
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
        return Igdbproto.internal_static_proto_ReleaseDate_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_ReleaseDate_fieldAccessorTable.ensureFieldAccessorsInitialized(ReleaseDate.class, Builder.class);
    }

    @Override // proto.ReleaseDateOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.ReleaseDateOrBuilder
    public int getCategoryValue() {
        return this.category_;
    }

    @Override // proto.ReleaseDateOrBuilder
    public DateFormatChangeDateCategoryEnum getCategory() {
        DateFormatChangeDateCategoryEnum dateFormatChangeDateCategoryEnumForNumber = DateFormatChangeDateCategoryEnum.forNumber(this.category_);
        return dateFormatChangeDateCategoryEnumForNumber == null ? DateFormatChangeDateCategoryEnum.UNRECOGNIZED : dateFormatChangeDateCategoryEnumForNumber;
    }

    @Override // proto.ReleaseDateOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.ReleaseDateOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.ReleaseDateOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.ReleaseDateOrBuilder
    public boolean hasDate() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.ReleaseDateOrBuilder
    public Timestamp getDate() {
        Timestamp timestamp = this.date_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.ReleaseDateOrBuilder
    public TimestampOrBuilder getDateOrBuilder() {
        Timestamp timestamp = this.date_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.ReleaseDateOrBuilder
    public boolean hasGame() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.ReleaseDateOrBuilder
    public Game getGame() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.ReleaseDateOrBuilder
    public GameOrBuilder getGameOrBuilder() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.ReleaseDateOrBuilder
    public String getHuman() {
        Object obj = this.human_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.human_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.ReleaseDateOrBuilder
    public ByteString getHumanBytes() {
        Object obj = this.human_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.human_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.ReleaseDateOrBuilder
    public int getM() {
        return this.m_;
    }

    @Override // proto.ReleaseDateOrBuilder
    public boolean hasPlatform() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // proto.ReleaseDateOrBuilder
    public Platform getPlatform() {
        Platform platform = this.platform_;
        return platform == null ? Platform.getDefaultInstance() : platform;
    }

    @Override // proto.ReleaseDateOrBuilder
    public PlatformOrBuilder getPlatformOrBuilder() {
        Platform platform = this.platform_;
        return platform == null ? Platform.getDefaultInstance() : platform;
    }

    @Override // proto.ReleaseDateOrBuilder
    public int getRegionValue() {
        return this.region_;
    }

    @Override // proto.ReleaseDateOrBuilder
    public RegionRegionEnum getRegion() {
        RegionRegionEnum regionRegionEnumForNumber = RegionRegionEnum.forNumber(this.region_);
        return regionRegionEnumForNumber == null ? RegionRegionEnum.UNRECOGNIZED : regionRegionEnumForNumber;
    }

    @Override // proto.ReleaseDateOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // proto.ReleaseDateOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.ReleaseDateOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.ReleaseDateOrBuilder
    public int getY() {
        return this.y_;
    }

    @Override // proto.ReleaseDateOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.ReleaseDateOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.ReleaseDateOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // proto.ReleaseDateOrBuilder
    public ReleaseDateStatus getStatus() {
        ReleaseDateStatus releaseDateStatus = this.status_;
        return releaseDateStatus == null ? ReleaseDateStatus.getDefaultInstance() : releaseDateStatus;
    }

    @Override // proto.ReleaseDateOrBuilder
    public ReleaseDateStatusOrBuilder getStatusOrBuilder() {
        ReleaseDateStatus releaseDateStatus = this.status_;
        return releaseDateStatus == null ? ReleaseDateStatus.getDefaultInstance() : releaseDateStatus;
    }

    public static ReleaseDate parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ReleaseDate parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ReleaseDate parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ReleaseDate parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ReleaseDate parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ReleaseDate parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ReleaseDate parseFrom(InputStream inputStream) throws IOException {
        return (ReleaseDate) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static ReleaseDate parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ReleaseDate) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ReleaseDate parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ReleaseDate) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ReleaseDate parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ReleaseDate) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ReleaseDate parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ReleaseDate) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static ReleaseDate parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ReleaseDate) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(ReleaseDate releaseDate) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) releaseDate);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((ReleaseDateIA) null) : (Builder) new Builder((ReleaseDateIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ReleaseDateOrBuilder {
        private int bitField0_;
        private int category_;
        private Object checksum_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> dateBuilder_;
        private Timestamp date_;
        private SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> gameBuilder_;
        private Game game_;
        private Object human_;
        private long id_;
        private int m_;
        private SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> platformBuilder_;
        private Platform platform_;
        private int region_;
        private SingleFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> statusBuilder_;
        private ReleaseDateStatus status_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;
        private int y_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, ReleaseDateIA releaseDateIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(ReleaseDateIA releaseDateIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_ReleaseDate_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_ReleaseDate_fieldAccessorTable.ensureFieldAccessorsInitialized(ReleaseDate.class, Builder.class);
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
            if (ReleaseDate.alwaysUseFieldBuilders) {
                getCreatedAtFieldBuilder();
                getDateFieldBuilder();
                getGameFieldBuilder();
                getPlatformFieldBuilder();
                getUpdatedAtFieldBuilder();
                getStatusFieldBuilder();
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
            this.game_ = null;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder3 = this.gameBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.gameBuilder_ = null;
            }
            this.human_ = "";
            this.m_ = 0;
            this.platform_ = null;
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder4 = this.platformBuilder_;
            if (singleFieldBuilder4 != null) {
                singleFieldBuilder4.dispose();
                this.platformBuilder_ = null;
            }
            this.region_ = 0;
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder5 = this.updatedAtBuilder_;
            if (singleFieldBuilder5 != null) {
                singleFieldBuilder5.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.y_ = 0;
            this.checksum_ = "";
            this.status_ = null;
            SingleFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> singleFieldBuilder6 = this.statusBuilder_;
            if (singleFieldBuilder6 != null) {
                singleFieldBuilder6.dispose();
                this.statusBuilder_ = null;
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_ReleaseDate_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ReleaseDate getDefaultInstanceForType() {
            return ReleaseDate.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ReleaseDate build() {
            ReleaseDate releaseDateBuildPartial = buildPartial();
            if (releaseDateBuildPartial.isInitialized()) {
                return releaseDateBuildPartial;
            }
            throw newUninitializedMessageException((Message) releaseDateBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ReleaseDate buildPartial() {
            ReleaseDate releaseDate = new ReleaseDate(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(releaseDate);
            }
            onBuilt();
            return releaseDate;
        }

        private void buildPartial0(ReleaseDate releaseDate) {
            int i;
            ReleaseDateStatus releaseDateStatus;
            Timestamp timestamp;
            Platform platform;
            Game game;
            Timestamp timestamp2;
            Timestamp timestamp3;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                releaseDate.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                releaseDate.category_ = this.category_;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
                if (singleFieldBuilder == null) {
                    timestamp3 = this.createdAt_;
                } else {
                    timestamp3 = (Timestamp) singleFieldBuilder.build();
                }
                releaseDate.createdAt_ = timestamp3;
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
                releaseDate.date_ = timestamp2;
                i |= 2;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder3 = this.gameBuilder_;
                if (singleFieldBuilder3 == null) {
                    game = this.game_;
                } else {
                    game = (Game) singleFieldBuilder3.build();
                }
                releaseDate.game_ = game;
                i |= 4;
            }
            if ((i2 & 32) != 0) {
                releaseDate.human_ = this.human_;
            }
            if ((i2 & 64) != 0) {
                releaseDate.m_ = this.m_;
            }
            if ((i2 & 128) != 0) {
                SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder4 = this.platformBuilder_;
                if (singleFieldBuilder4 == null) {
                    platform = this.platform_;
                } else {
                    platform = (Platform) singleFieldBuilder4.build();
                }
                releaseDate.platform_ = platform;
                i |= 8;
            }
            if ((i2 & 256) != 0) {
                releaseDate.region_ = this.region_;
            }
            if ((i2 & 512) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder5 = this.updatedAtBuilder_;
                if (singleFieldBuilder5 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder5.build();
                }
                releaseDate.updatedAt_ = timestamp;
                i |= 16;
            }
            if ((i2 & 1024) != 0) {
                releaseDate.y_ = this.y_;
            }
            if ((i2 & 2048) != 0) {
                releaseDate.checksum_ = this.checksum_;
            }
            if ((i2 & 4096) != 0) {
                SingleFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> singleFieldBuilder6 = this.statusBuilder_;
                if (singleFieldBuilder6 == null) {
                    releaseDateStatus = this.status_;
                } else {
                    releaseDateStatus = (ReleaseDateStatus) singleFieldBuilder6.build();
                }
                releaseDate.status_ = releaseDateStatus;
                i |= 32;
            }
            releaseDate.bitField0_ |= i;
        }

        @Override // proto.ReleaseDateOrBuilder
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

        @Override // proto.ReleaseDateOrBuilder
        public int getCategoryValue() {
            return this.category_;
        }

        public Builder setCategoryValue(int i) {
            this.category_ = i;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.ReleaseDateOrBuilder
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

        @Override // proto.ReleaseDateOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // proto.ReleaseDateOrBuilder
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

        @Override // proto.ReleaseDateOrBuilder
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

        @Override // proto.ReleaseDateOrBuilder
        public boolean hasDate() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // proto.ReleaseDateOrBuilder
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

        @Override // proto.ReleaseDateOrBuilder
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

        @Override // proto.ReleaseDateOrBuilder
        public boolean hasGame() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // proto.ReleaseDateOrBuilder
        public Game getGame() {
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                Game game = this.game_;
                return game == null ? Game.getDefaultInstance() : game;
            }
            return (Game) singleFieldBuilder.getMessage();
        }

        public Builder setGame(Game game) {
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                game.getClass();
                this.game_ = game;
            } else {
                singleFieldBuilder.setMessage(game);
            }
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setGame(Game.Builder builder) {
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                this.game_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder mergeGame(Game game) {
            Game game2;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 16) != 0 && (game2 = this.game_) != null && game2 != Game.getDefaultInstance()) {
                    getGameBuilder().mergeFrom((Message) game);
                } else {
                    this.game_ = game;
                }
            } else {
                singleFieldBuilder.mergeFrom(game);
            }
            if (this.game_ != null) {
                this.bitField0_ |= 16;
                onChanged();
            }
            return this;
        }

        public Builder clearGame() {
            this.bitField0_ &= -17;
            this.game_ = null;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.gameBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Game.Builder getGameBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (Game.Builder) getGameFieldBuilder().getBuilder();
        }

        @Override // proto.ReleaseDateOrBuilder
        public GameOrBuilder getGameOrBuilder() {
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder != null) {
                return (GameOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Game game = this.game_;
            return game == null ? Game.getDefaultInstance() : game;
        }

        private SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> getGameFieldBuilder() {
            if (this.gameBuilder_ == null) {
                this.gameBuilder_ = new SingleFieldBuilder<>(getGame(), getParentForChildren(), isClean());
                this.game_ = null;
            }
            return this.gameBuilder_;
        }

        @Override // proto.ReleaseDateOrBuilder
        public String getHuman() {
            Object obj = this.human_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.human_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.ReleaseDateOrBuilder
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
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearHuman() {
            this.human_ = ReleaseDate.getDefaultInstance().getHuman();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder setHumanBytes(ByteString byteString) {
            byteString.getClass();
            ReleaseDate.checkByteStringIsUtf8(byteString);
            this.human_ = byteString;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        @Override // proto.ReleaseDateOrBuilder
        public int getM() {
            return this.m_;
        }

        public Builder setM(int i) {
            this.m_ = i;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearM() {
            this.bitField0_ &= -65;
            this.m_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.ReleaseDateOrBuilder
        public boolean hasPlatform() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // proto.ReleaseDateOrBuilder
        public Platform getPlatform() {
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder = this.platformBuilder_;
            if (singleFieldBuilder == null) {
                Platform platform = this.platform_;
                return platform == null ? Platform.getDefaultInstance() : platform;
            }
            return (Platform) singleFieldBuilder.getMessage();
        }

        public Builder setPlatform(Platform platform) {
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder = this.platformBuilder_;
            if (singleFieldBuilder == null) {
                platform.getClass();
                this.platform_ = platform;
            } else {
                singleFieldBuilder.setMessage(platform);
            }
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setPlatform(Platform.Builder builder) {
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder = this.platformBuilder_;
            if (singleFieldBuilder == null) {
                this.platform_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder mergePlatform(Platform platform) {
            Platform platform2;
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder = this.platformBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 128) != 0 && (platform2 = this.platform_) != null && platform2 != Platform.getDefaultInstance()) {
                    getPlatformBuilder().mergeFrom((Message) platform);
                } else {
                    this.platform_ = platform;
                }
            } else {
                singleFieldBuilder.mergeFrom(platform);
            }
            if (this.platform_ != null) {
                this.bitField0_ |= 128;
                onChanged();
            }
            return this;
        }

        public Builder clearPlatform() {
            this.bitField0_ &= -129;
            this.platform_ = null;
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder = this.platformBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.platformBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Platform.Builder getPlatformBuilder() {
            this.bitField0_ |= 128;
            onChanged();
            return (Platform.Builder) getPlatformFieldBuilder().getBuilder();
        }

        @Override // proto.ReleaseDateOrBuilder
        public PlatformOrBuilder getPlatformOrBuilder() {
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder = this.platformBuilder_;
            if (singleFieldBuilder != null) {
                return (PlatformOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Platform platform = this.platform_;
            return platform == null ? Platform.getDefaultInstance() : platform;
        }

        private SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> getPlatformFieldBuilder() {
            if (this.platformBuilder_ == null) {
                this.platformBuilder_ = new SingleFieldBuilder<>(getPlatform(), getParentForChildren(), isClean());
                this.platform_ = null;
            }
            return this.platformBuilder_;
        }

        @Override // proto.ReleaseDateOrBuilder
        public int getRegionValue() {
            return this.region_;
        }

        public Builder setRegionValue(int i) {
            this.region_ = i;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        @Override // proto.ReleaseDateOrBuilder
        public RegionRegionEnum getRegion() {
            RegionRegionEnum regionRegionEnumForNumber = RegionRegionEnum.forNumber(this.region_);
            return regionRegionEnumForNumber == null ? RegionRegionEnum.UNRECOGNIZED : regionRegionEnumForNumber;
        }

        public Builder setRegion(RegionRegionEnum regionRegionEnum) {
            regionRegionEnum.getClass();
            this.bitField0_ |= 256;
            this.region_ = regionRegionEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearRegion() {
            this.bitField0_ &= -257;
            this.region_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.ReleaseDateOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 512) != 0;
        }

        @Override // proto.ReleaseDateOrBuilder
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
            this.bitField0_ |= 512;
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
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder mergeUpdatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 512) != 0 && (timestamp2 = this.updatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getUpdatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.updatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.updatedAt_ != null) {
                this.bitField0_ |= 512;
                onChanged();
            }
            return this;
        }

        public Builder clearUpdatedAt() {
            this.bitField0_ &= -513;
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
            this.bitField0_ |= 512;
            onChanged();
            return (Timestamp.Builder) getUpdatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.ReleaseDateOrBuilder
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

        @Override // proto.ReleaseDateOrBuilder
        public int getY() {
            return this.y_;
        }

        public Builder setY(int i) {
            this.y_ = i;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder clearY() {
            this.bitField0_ &= -1025;
            this.y_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.ReleaseDateOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.ReleaseDateOrBuilder
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
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = ReleaseDate.getDefaultInstance().getChecksum();
            this.bitField0_ &= -2049;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            ReleaseDate.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        @Override // proto.ReleaseDateOrBuilder
        public boolean hasStatus() {
            return (this.bitField0_ & 4096) != 0;
        }

        @Override // proto.ReleaseDateOrBuilder
        public ReleaseDateStatus getStatus() {
            SingleFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> singleFieldBuilder = this.statusBuilder_;
            if (singleFieldBuilder == null) {
                ReleaseDateStatus releaseDateStatus = this.status_;
                return releaseDateStatus == null ? ReleaseDateStatus.getDefaultInstance() : releaseDateStatus;
            }
            return (ReleaseDateStatus) singleFieldBuilder.getMessage();
        }

        public Builder setStatus(ReleaseDateStatus releaseDateStatus) {
            SingleFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> singleFieldBuilder = this.statusBuilder_;
            if (singleFieldBuilder == null) {
                releaseDateStatus.getClass();
                this.status_ = releaseDateStatus;
            } else {
                singleFieldBuilder.setMessage(releaseDateStatus);
            }
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder setStatus(ReleaseDateStatus.Builder builder) {
            SingleFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> singleFieldBuilder = this.statusBuilder_;
            if (singleFieldBuilder == null) {
                this.status_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder mergeStatus(ReleaseDateStatus releaseDateStatus) {
            ReleaseDateStatus releaseDateStatus2;
            SingleFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> singleFieldBuilder = this.statusBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 4096) != 0 && (releaseDateStatus2 = this.status_) != null && releaseDateStatus2 != ReleaseDateStatus.getDefaultInstance()) {
                    getStatusBuilder().mergeFrom((Message) releaseDateStatus);
                } else {
                    this.status_ = releaseDateStatus;
                }
            } else {
                singleFieldBuilder.mergeFrom(releaseDateStatus);
            }
            if (this.status_ != null) {
                this.bitField0_ |= 4096;
                onChanged();
            }
            return this;
        }

        public Builder clearStatus() {
            this.bitField0_ &= -4097;
            this.status_ = null;
            SingleFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> singleFieldBuilder = this.statusBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.statusBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public ReleaseDateStatus.Builder getStatusBuilder() {
            this.bitField0_ |= 4096;
            onChanged();
            return (ReleaseDateStatus.Builder) getStatusFieldBuilder().getBuilder();
        }

        @Override // proto.ReleaseDateOrBuilder
        public ReleaseDateStatusOrBuilder getStatusOrBuilder() {
            SingleFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> singleFieldBuilder = this.statusBuilder_;
            if (singleFieldBuilder != null) {
                return (ReleaseDateStatusOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            ReleaseDateStatus releaseDateStatus = this.status_;
            return releaseDateStatus == null ? ReleaseDateStatus.getDefaultInstance() : releaseDateStatus;
        }

        private SingleFieldBuilder<ReleaseDateStatus, ReleaseDateStatus.Builder, ReleaseDateStatusOrBuilder> getStatusFieldBuilder() {
            if (this.statusBuilder_ == null) {
                this.statusBuilder_ = new SingleFieldBuilder<>(getStatus(), getParentForChildren(), isClean());
                this.status_ = null;
            }
            return this.statusBuilder_;
        }
    }

    public static ReleaseDate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.ReleaseDate$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<ReleaseDate> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public ReleaseDate parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = ReleaseDate.newBuilder();
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

    public static Parser<ReleaseDate> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ReleaseDate> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ReleaseDate getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
