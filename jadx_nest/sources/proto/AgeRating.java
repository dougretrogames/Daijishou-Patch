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
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public final class AgeRating extends GeneratedMessage implements AgeRatingOrBuilder {
    public static final int CATEGORY_FIELD_NUMBER = 2;
    public static final int CHECKSUM_FIELD_NUMBER = 7;
    public static final int CONTENT_DESCRIPTIONS_FIELD_NUMBER = 3;
    private static final AgeRating DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static final Parser<AgeRating> PARSER;
    public static final int RATING_COVER_URL_FIELD_NUMBER = 5;
    public static final int RATING_FIELD_NUMBER = 4;
    public static final int SYNOPSIS_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int category_;
    private volatile Object checksum_;
    private List<AgeRatingContentDescription> contentDescriptions_;
    private long id_;
    private volatile Object ratingCoverUrl_;
    private int rating_;
    private volatile Object synopsis_;

    /* synthetic */ AgeRating(GeneratedMessage.Builder builder, AgeRatingIA ageRatingIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", AgeRating.class.getName());
        DEFAULT_INSTANCE = new AgeRating();
        PARSER = new AnonymousClass1();
    }

    private AgeRating(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.category_ = 0;
        this.rating_ = 0;
        this.ratingCoverUrl_ = "";
        this.synopsis_ = "";
        this.checksum_ = "";
    }

    private AgeRating() {
        this.id_ = 0L;
        this.category_ = 0;
        this.rating_ = 0;
        this.ratingCoverUrl_ = "";
        this.synopsis_ = "";
        this.checksum_ = "";
        this.category_ = 0;
        this.contentDescriptions_ = Collections.emptyList();
        this.rating_ = 0;
        this.ratingCoverUrl_ = "";
        this.synopsis_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_AgeRating_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_AgeRating_fieldAccessorTable.ensureFieldAccessorsInitialized(AgeRating.class, Builder.class);
    }

    @Override // proto.AgeRatingOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.AgeRatingOrBuilder
    public int getCategoryValue() {
        return this.category_;
    }

    @Override // proto.AgeRatingOrBuilder
    public AgeRatingCategoryEnum getCategory() {
        AgeRatingCategoryEnum ageRatingCategoryEnumForNumber = AgeRatingCategoryEnum.forNumber(this.category_);
        return ageRatingCategoryEnumForNumber == null ? AgeRatingCategoryEnum.UNRECOGNIZED : ageRatingCategoryEnumForNumber;
    }

    @Override // proto.AgeRatingOrBuilder
    public List<AgeRatingContentDescription> getContentDescriptionsList() {
        return this.contentDescriptions_;
    }

    @Override // proto.AgeRatingOrBuilder
    public List<? extends AgeRatingContentDescriptionOrBuilder> getContentDescriptionsOrBuilderList() {
        return this.contentDescriptions_;
    }

    @Override // proto.AgeRatingOrBuilder
    public int getContentDescriptionsCount() {
        return this.contentDescriptions_.size();
    }

    @Override // proto.AgeRatingOrBuilder
    public AgeRatingContentDescription getContentDescriptions(int i) {
        return this.contentDescriptions_.get(i);
    }

    @Override // proto.AgeRatingOrBuilder
    public AgeRatingContentDescriptionOrBuilder getContentDescriptionsOrBuilder(int i) {
        return this.contentDescriptions_.get(i);
    }

    @Override // proto.AgeRatingOrBuilder
    public int getRatingValue() {
        return this.rating_;
    }

    @Override // proto.AgeRatingOrBuilder
    public AgeRatingRatingEnum getRating() {
        AgeRatingRatingEnum ageRatingRatingEnumForNumber = AgeRatingRatingEnum.forNumber(this.rating_);
        return ageRatingRatingEnumForNumber == null ? AgeRatingRatingEnum.UNRECOGNIZED : ageRatingRatingEnumForNumber;
    }

    @Override // proto.AgeRatingOrBuilder
    public String getRatingCoverUrl() {
        Object obj = this.ratingCoverUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.ratingCoverUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.AgeRatingOrBuilder
    public ByteString getRatingCoverUrlBytes() {
        Object obj = this.ratingCoverUrl_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ratingCoverUrl_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.AgeRatingOrBuilder
    public String getSynopsis() {
        Object obj = this.synopsis_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.synopsis_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.AgeRatingOrBuilder
    public ByteString getSynopsisBytes() {
        Object obj = this.synopsis_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.synopsis_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.AgeRatingOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.AgeRatingOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static AgeRating parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static AgeRating parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static AgeRating parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static AgeRating parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static AgeRating parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static AgeRating parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static AgeRating parseFrom(InputStream inputStream) throws IOException {
        return (AgeRating) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static AgeRating parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgeRating) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AgeRating parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AgeRating) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static AgeRating parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgeRating) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AgeRating parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AgeRating) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static AgeRating parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AgeRating) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(AgeRating ageRating) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) ageRating);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((AgeRatingIA) null) : (Builder) new Builder((AgeRatingIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements AgeRatingOrBuilder {
        private int bitField0_;
        private int category_;
        private Object checksum_;
        private RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> contentDescriptionsBuilder_;
        private List<AgeRatingContentDescription> contentDescriptions_;
        private long id_;
        private Object ratingCoverUrl_;
        private int rating_;
        private Object synopsis_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, AgeRatingIA ageRatingIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(AgeRatingIA ageRatingIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_AgeRating_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_AgeRating_fieldAccessorTable.ensureFieldAccessorsInitialized(AgeRating.class, Builder.class);
        }

        private Builder() {
            this.category_ = 0;
            this.contentDescriptions_ = Collections.emptyList();
            this.rating_ = 0;
            this.ratingCoverUrl_ = "";
            this.synopsis_ = "";
            this.checksum_ = "";
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.category_ = 0;
            this.contentDescriptions_ = Collections.emptyList();
            this.rating_ = 0;
            this.ratingCoverUrl_ = "";
            this.synopsis_ = "";
            this.checksum_ = "";
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.category_ = 0;
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.contentDescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.contentDescriptions_ = Collections.emptyList();
            } else {
                this.contentDescriptions_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -5;
            this.rating_ = 0;
            this.ratingCoverUrl_ = "";
            this.synopsis_ = "";
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_AgeRating_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AgeRating getDefaultInstanceForType() {
            return AgeRating.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AgeRating build() {
            AgeRating ageRatingBuildPartial = buildPartial();
            if (ageRatingBuildPartial.isInitialized()) {
                return ageRatingBuildPartial;
            }
            throw newUninitializedMessageException((Message) ageRatingBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AgeRating buildPartial() {
            AgeRating ageRating = new AgeRating(this, null);
            buildPartialRepeatedFields(ageRating);
            if (this.bitField0_ != 0) {
                buildPartial0(ageRating);
            }
            onBuilt();
            return ageRating;
        }

        private void buildPartialRepeatedFields(AgeRating ageRating) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.contentDescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0) {
                    this.contentDescriptions_ = Collections.unmodifiableList(this.contentDescriptions_);
                    this.bitField0_ &= -5;
                }
                ageRating.contentDescriptions_ = this.contentDescriptions_;
                return;
            }
            ageRating.contentDescriptions_ = repeatedFieldBuilder.build();
        }

        private void buildPartial0(AgeRating ageRating) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                ageRating.id_ = this.id_;
            }
            if ((i & 2) != 0) {
                ageRating.category_ = this.category_;
            }
            if ((i & 8) != 0) {
                ageRating.rating_ = this.rating_;
            }
            if ((i & 16) != 0) {
                ageRating.ratingCoverUrl_ = this.ratingCoverUrl_;
            }
            if ((i & 32) != 0) {
                ageRating.synopsis_ = this.synopsis_;
            }
            if ((i & 64) != 0) {
                ageRating.checksum_ = this.checksum_;
            }
        }

        @Override // proto.AgeRatingOrBuilder
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

        @Override // proto.AgeRatingOrBuilder
        public int getCategoryValue() {
            return this.category_;
        }

        public Builder setCategoryValue(int i) {
            this.category_ = i;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.AgeRatingOrBuilder
        public AgeRatingCategoryEnum getCategory() {
            AgeRatingCategoryEnum ageRatingCategoryEnumForNumber = AgeRatingCategoryEnum.forNumber(this.category_);
            return ageRatingCategoryEnumForNumber == null ? AgeRatingCategoryEnum.UNRECOGNIZED : ageRatingCategoryEnumForNumber;
        }

        public Builder setCategory(AgeRatingCategoryEnum ageRatingCategoryEnum) {
            ageRatingCategoryEnum.getClass();
            this.bitField0_ |= 2;
            this.category_ = ageRatingCategoryEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearCategory() {
            this.bitField0_ &= -3;
            this.category_ = 0;
            onChanged();
            return this;
        }

        private void ensureContentDescriptionsIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.contentDescriptions_ = new ArrayList(this.contentDescriptions_);
                this.bitField0_ |= 4;
            }
        }

        @Override // proto.AgeRatingOrBuilder
        public List<AgeRatingContentDescription> getContentDescriptionsList() {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.contentDescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.contentDescriptions_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.AgeRatingOrBuilder
        public int getContentDescriptionsCount() {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.contentDescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.contentDescriptions_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.AgeRatingOrBuilder
        public AgeRatingContentDescription getContentDescriptions(int i) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.contentDescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.contentDescriptions_.get(i);
            }
            return (AgeRatingContentDescription) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setContentDescriptions(int i, AgeRatingContentDescription ageRatingContentDescription) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.contentDescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ageRatingContentDescription.getClass();
                ensureContentDescriptionsIsMutable();
                this.contentDescriptions_.set(i, ageRatingContentDescription);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, ageRatingContentDescription);
            return this;
        }

        public Builder setContentDescriptions(int i, AgeRatingContentDescription.Builder builder) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.contentDescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureContentDescriptionsIsMutable();
                this.contentDescriptions_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addContentDescriptions(AgeRatingContentDescription ageRatingContentDescription) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.contentDescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ageRatingContentDescription.getClass();
                ensureContentDescriptionsIsMutable();
                this.contentDescriptions_.add(ageRatingContentDescription);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(ageRatingContentDescription);
            return this;
        }

        public Builder addContentDescriptions(int i, AgeRatingContentDescription ageRatingContentDescription) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.contentDescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ageRatingContentDescription.getClass();
                ensureContentDescriptionsIsMutable();
                this.contentDescriptions_.add(i, ageRatingContentDescription);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, ageRatingContentDescription);
            return this;
        }

        public Builder addContentDescriptions(AgeRatingContentDescription.Builder builder) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.contentDescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureContentDescriptionsIsMutable();
                this.contentDescriptions_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addContentDescriptions(int i, AgeRatingContentDescription.Builder builder) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.contentDescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureContentDescriptionsIsMutable();
                this.contentDescriptions_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllContentDescriptions(Iterable<? extends AgeRatingContentDescription> iterable) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.contentDescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureContentDescriptionsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.contentDescriptions_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearContentDescriptions() {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.contentDescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.contentDescriptions_ = Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeContentDescriptions(int i) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.contentDescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureContentDescriptionsIsMutable();
                this.contentDescriptions_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public AgeRatingContentDescription.Builder getContentDescriptionsBuilder(int i) {
            return (AgeRatingContentDescription.Builder) getContentDescriptionsFieldBuilder().getBuilder(i);
        }

        @Override // proto.AgeRatingOrBuilder
        public AgeRatingContentDescriptionOrBuilder getContentDescriptionsOrBuilder(int i) {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.contentDescriptionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.contentDescriptions_.get(i);
            }
            return (AgeRatingContentDescriptionOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.AgeRatingOrBuilder
        public List<? extends AgeRatingContentDescriptionOrBuilder> getContentDescriptionsOrBuilderList() {
            RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> repeatedFieldBuilder = this.contentDescriptionsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.contentDescriptions_);
        }

        public AgeRatingContentDescription.Builder addContentDescriptionsBuilder() {
            return (AgeRatingContentDescription.Builder) getContentDescriptionsFieldBuilder().addBuilder(AgeRatingContentDescription.getDefaultInstance());
        }

        public AgeRatingContentDescription.Builder addContentDescriptionsBuilder(int i) {
            return (AgeRatingContentDescription.Builder) getContentDescriptionsFieldBuilder().addBuilder(i, AgeRatingContentDescription.getDefaultInstance());
        }

        public List<AgeRatingContentDescription.Builder> getContentDescriptionsBuilderList() {
            return getContentDescriptionsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<AgeRatingContentDescription, AgeRatingContentDescription.Builder, AgeRatingContentDescriptionOrBuilder> getContentDescriptionsFieldBuilder() {
            if (this.contentDescriptionsBuilder_ == null) {
                this.contentDescriptionsBuilder_ = new RepeatedFieldBuilder<>(this.contentDescriptions_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                this.contentDescriptions_ = null;
            }
            return this.contentDescriptionsBuilder_;
        }

        @Override // proto.AgeRatingOrBuilder
        public int getRatingValue() {
            return this.rating_;
        }

        public Builder setRatingValue(int i) {
            this.rating_ = i;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // proto.AgeRatingOrBuilder
        public AgeRatingRatingEnum getRating() {
            AgeRatingRatingEnum ageRatingRatingEnumForNumber = AgeRatingRatingEnum.forNumber(this.rating_);
            return ageRatingRatingEnumForNumber == null ? AgeRatingRatingEnum.UNRECOGNIZED : ageRatingRatingEnumForNumber;
        }

        public Builder setRating(AgeRatingRatingEnum ageRatingRatingEnum) {
            ageRatingRatingEnum.getClass();
            this.bitField0_ |= 8;
            this.rating_ = ageRatingRatingEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearRating() {
            this.bitField0_ &= -9;
            this.rating_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.AgeRatingOrBuilder
        public String getRatingCoverUrl() {
            Object obj = this.ratingCoverUrl_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ratingCoverUrl_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.AgeRatingOrBuilder
        public ByteString getRatingCoverUrlBytes() {
            Object obj = this.ratingCoverUrl_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ratingCoverUrl_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setRatingCoverUrl(String str) {
            str.getClass();
            this.ratingCoverUrl_ = str;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearRatingCoverUrl() {
            this.ratingCoverUrl_ = AgeRating.getDefaultInstance().getRatingCoverUrl();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder setRatingCoverUrlBytes(ByteString byteString) {
            byteString.getClass();
            AgeRating.checkByteStringIsUtf8(byteString);
            this.ratingCoverUrl_ = byteString;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        @Override // proto.AgeRatingOrBuilder
        public String getSynopsis() {
            Object obj = this.synopsis_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.synopsis_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.AgeRatingOrBuilder
        public ByteString getSynopsisBytes() {
            Object obj = this.synopsis_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.synopsis_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setSynopsis(String str) {
            str.getClass();
            this.synopsis_ = str;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearSynopsis() {
            this.synopsis_ = AgeRating.getDefaultInstance().getSynopsis();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder setSynopsisBytes(ByteString byteString) {
            byteString.getClass();
            AgeRating.checkByteStringIsUtf8(byteString);
            this.synopsis_ = byteString;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        @Override // proto.AgeRatingOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.AgeRatingOrBuilder
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
            this.checksum_ = AgeRating.getDefaultInstance().getChecksum();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            AgeRating.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }
    }

    public static AgeRating getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.AgeRating$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<AgeRating> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public AgeRating parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = AgeRating.newBuilder();
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

    public static Parser<AgeRating> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AgeRating> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public AgeRating getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
