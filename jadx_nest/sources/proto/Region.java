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
public final class Region extends GeneratedMessage implements RegionOrBuilder {
    public static final int CATEGORY_FIELD_NUMBER = 3;
    public static final int CHECKSUM_FIELD_NUMBER = 7;
    public static final int CREATED_AT_FIELD_NUMBER = 5;
    private static final Region DEFAULT_INSTANCE;
    public static final int IDENTIFIER_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static final Parser<Region> PARSER;
    public static final int UPDATED_AT_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object category_;
    private volatile Object checksum_;
    private Timestamp createdAt_;
    private long id_;
    private volatile Object identifier_;
    private volatile Object name_;
    private Timestamp updatedAt_;

    /* synthetic */ Region(GeneratedMessage.Builder builder, RegionIA regionIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Region.class.getName());
        DEFAULT_INSTANCE = new Region();
        PARSER = new AnonymousClass1();
    }

    private Region(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.name_ = "";
        this.category_ = "";
        this.identifier_ = "";
        this.checksum_ = "";
    }

    private Region() {
        this.id_ = 0L;
        this.name_ = "";
        this.category_ = "";
        this.identifier_ = "";
        this.checksum_ = "";
        this.name_ = "";
        this.category_ = "";
        this.identifier_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_Region_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_Region_fieldAccessorTable.ensureFieldAccessorsInitialized(Region.class, Builder.class);
    }

    @Override // proto.RegionOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.RegionOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.RegionOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.RegionOrBuilder
    public String getCategory() {
        Object obj = this.category_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.category_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.RegionOrBuilder
    public ByteString getCategoryBytes() {
        Object obj = this.category_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.category_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.RegionOrBuilder
    public String getIdentifier() {
        Object obj = this.identifier_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.identifier_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.RegionOrBuilder
    public ByteString getIdentifierBytes() {
        Object obj = this.identifier_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.identifier_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.RegionOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.RegionOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.RegionOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.RegionOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.RegionOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.RegionOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.RegionOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.RegionOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static Region parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Region parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Region parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Region parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Region parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Region parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Region parseFrom(InputStream inputStream) throws IOException {
        return (Region) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Region parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Region) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Region parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Region) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Region parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Region) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Region parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Region) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Region parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Region) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(Region region) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) region);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((RegionIA) null) : (Builder) new Builder((RegionIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements RegionOrBuilder {
        private int bitField0_;
        private Object category_;
        private Object checksum_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private long id_;
        private Object identifier_;
        private Object name_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, RegionIA regionIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(RegionIA regionIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_Region_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_Region_fieldAccessorTable.ensureFieldAccessorsInitialized(Region.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.category_ = "";
            this.identifier_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.category_ = "";
            this.identifier_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (Region.alwaysUseFieldBuilders) {
                getCreatedAtFieldBuilder();
                getUpdatedAtFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.name_ = "";
            this.category_ = "";
            this.identifier_ = "";
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.createdAtBuilder_ = null;
            }
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.updatedAtBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_Region_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Region getDefaultInstanceForType() {
            return Region.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Region build() {
            Region regionBuildPartial = buildPartial();
            if (regionBuildPartial.isInitialized()) {
                return regionBuildPartial;
            }
            throw newUninitializedMessageException((Message) regionBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Region buildPartial() {
            Region region = new Region(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(region);
            }
            onBuilt();
            return region;
        }

        private void buildPartial0(Region region) {
            int i;
            Timestamp timestamp;
            Timestamp timestamp2;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                region.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                region.name_ = this.name_;
            }
            if ((i2 & 4) != 0) {
                region.category_ = this.category_;
            }
            if ((i2 & 8) != 0) {
                region.identifier_ = this.identifier_;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
                if (singleFieldBuilder == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder.build();
                }
                region.createdAt_ = timestamp2;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 32) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.updatedAtBuilder_;
                if (singleFieldBuilder2 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder2.build();
                }
                region.updatedAt_ = timestamp;
                i |= 2;
            }
            if ((i2 & 64) != 0) {
                region.checksum_ = this.checksum_;
            }
            region.bitField0_ |= i;
        }

        @Override // proto.RegionOrBuilder
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

        @Override // proto.RegionOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.RegionOrBuilder
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
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Region.getDefaultInstance().getName();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            Region.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.RegionOrBuilder
        public String getCategory() {
            Object obj = this.category_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.category_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.RegionOrBuilder
        public ByteString getCategoryBytes() {
            Object obj = this.category_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.category_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setCategory(String str) {
            str.getClass();
            this.category_ = str;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearCategory() {
            this.category_ = Region.getDefaultInstance().getCategory();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder setCategoryBytes(ByteString byteString) {
            byteString.getClass();
            Region.checkByteStringIsUtf8(byteString);
            this.category_ = byteString;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // proto.RegionOrBuilder
        public String getIdentifier() {
            Object obj = this.identifier_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.identifier_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.RegionOrBuilder
        public ByteString getIdentifierBytes() {
            Object obj = this.identifier_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.identifier_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setIdentifier(String str) {
            str.getClass();
            this.identifier_ = str;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder clearIdentifier() {
            this.identifier_ = Region.getDefaultInstance().getIdentifier();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder setIdentifierBytes(ByteString byteString) {
            byteString.getClass();
            Region.checkByteStringIsUtf8(byteString);
            this.identifier_ = byteString;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // proto.RegionOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // proto.RegionOrBuilder
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

        @Override // proto.RegionOrBuilder
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

        @Override // proto.RegionOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // proto.RegionOrBuilder
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
            this.bitField0_ |= 32;
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
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder mergeUpdatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 32) != 0 && (timestamp2 = this.updatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getUpdatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.updatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.updatedAt_ != null) {
                this.bitField0_ |= 32;
                onChanged();
            }
            return this;
        }

        public Builder clearUpdatedAt() {
            this.bitField0_ &= -33;
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
            this.bitField0_ |= 32;
            onChanged();
            return (Timestamp.Builder) getUpdatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.RegionOrBuilder
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

        @Override // proto.RegionOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.RegionOrBuilder
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
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = Region.getDefaultInstance().getChecksum();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            Region.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }
    }

    public static Region getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.Region$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Region> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public Region parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Region.newBuilder();
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

    public static Parser<Region> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Region> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Region getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
