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

/* JADX INFO: loaded from: classes6.dex */
public final class GameVersionFeature extends GeneratedMessage implements GameVersionFeatureOrBuilder {
    public static final int CATEGORY_FIELD_NUMBER = 2;
    public static final int CHECKSUM_FIELD_NUMBER = 7;
    private static final GameVersionFeature DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    private static final Parser<GameVersionFeature> PARSER;
    public static final int POSITION_FIELD_NUMBER = 4;
    public static final int TITLE_FIELD_NUMBER = 5;
    public static final int VALUES_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int category_;
    private volatile Object checksum_;
    private volatile Object description_;
    private long id_;
    private int position_;
    private volatile Object title_;
    private List<GameVersionFeatureValue> values_;

    /* synthetic */ GameVersionFeature(GeneratedMessage.Builder builder, GameVersionFeatureIA gameVersionFeatureIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameVersionFeature.class.getName());
        DEFAULT_INSTANCE = new GameVersionFeature();
        PARSER = new AnonymousClass1();
    }

    private GameVersionFeature(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.category_ = 0;
        this.description_ = "";
        this.position_ = 0;
        this.title_ = "";
        this.checksum_ = "";
    }

    private GameVersionFeature() {
        this.id_ = 0L;
        this.category_ = 0;
        this.description_ = "";
        this.position_ = 0;
        this.title_ = "";
        this.checksum_ = "";
        this.category_ = 0;
        this.description_ = "";
        this.title_ = "";
        this.values_ = Collections.emptyList();
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_GameVersionFeature_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_GameVersionFeature_fieldAccessorTable.ensureFieldAccessorsInitialized(GameVersionFeature.class, Builder.class);
    }

    @Override // proto.GameVersionFeatureOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.GameVersionFeatureOrBuilder
    public int getCategoryValue() {
        return this.category_;
    }

    @Override // proto.GameVersionFeatureOrBuilder
    public GameVersionFeatureCategoryEnum getCategory() {
        GameVersionFeatureCategoryEnum gameVersionFeatureCategoryEnumForNumber = GameVersionFeatureCategoryEnum.forNumber(this.category_);
        return gameVersionFeatureCategoryEnumForNumber == null ? GameVersionFeatureCategoryEnum.UNRECOGNIZED : gameVersionFeatureCategoryEnumForNumber;
    }

    @Override // proto.GameVersionFeatureOrBuilder
    public String getDescription() {
        Object obj = this.description_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.description_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameVersionFeatureOrBuilder
    public ByteString getDescriptionBytes() {
        Object obj = this.description_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.description_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.GameVersionFeatureOrBuilder
    public int getPosition() {
        return this.position_;
    }

    @Override // proto.GameVersionFeatureOrBuilder
    public String getTitle() {
        Object obj = this.title_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.title_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameVersionFeatureOrBuilder
    public ByteString getTitleBytes() {
        Object obj = this.title_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.title_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.GameVersionFeatureOrBuilder
    public List<GameVersionFeatureValue> getValuesList() {
        return this.values_;
    }

    @Override // proto.GameVersionFeatureOrBuilder
    public List<? extends GameVersionFeatureValueOrBuilder> getValuesOrBuilderList() {
        return this.values_;
    }

    @Override // proto.GameVersionFeatureOrBuilder
    public int getValuesCount() {
        return this.values_.size();
    }

    @Override // proto.GameVersionFeatureOrBuilder
    public GameVersionFeatureValue getValues(int i) {
        return this.values_.get(i);
    }

    @Override // proto.GameVersionFeatureOrBuilder
    public GameVersionFeatureValueOrBuilder getValuesOrBuilder(int i) {
        return this.values_.get(i);
    }

    @Override // proto.GameVersionFeatureOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameVersionFeatureOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static GameVersionFeature parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GameVersionFeature parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GameVersionFeature parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GameVersionFeature parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GameVersionFeature parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GameVersionFeature parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GameVersionFeature parseFrom(InputStream inputStream) throws IOException {
        return (GameVersionFeature) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static GameVersionFeature parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersionFeature) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameVersionFeature parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GameVersionFeature) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GameVersionFeature parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersionFeature) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameVersionFeature parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GameVersionFeature) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GameVersionFeature parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameVersionFeature) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GameVersionFeature gameVersionFeature) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) gameVersionFeature);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((GameVersionFeatureIA) null) : (Builder) new Builder((GameVersionFeatureIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameVersionFeatureOrBuilder {
        private int bitField0_;
        private int category_;
        private Object checksum_;
        private Object description_;
        private long id_;
        private int position_;
        private Object title_;
        private RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> valuesBuilder_;
        private List<GameVersionFeatureValue> values_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, GameVersionFeatureIA gameVersionFeatureIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(GameVersionFeatureIA gameVersionFeatureIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_GameVersionFeature_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_GameVersionFeature_fieldAccessorTable.ensureFieldAccessorsInitialized(GameVersionFeature.class, Builder.class);
        }

        private Builder() {
            this.category_ = 0;
            this.description_ = "";
            this.title_ = "";
            this.values_ = Collections.emptyList();
            this.checksum_ = "";
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.category_ = 0;
            this.description_ = "";
            this.title_ = "";
            this.values_ = Collections.emptyList();
            this.checksum_ = "";
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.category_ = 0;
            this.description_ = "";
            this.position_ = 0;
            this.title_ = "";
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.values_ = Collections.emptyList();
            } else {
                this.values_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -33;
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_GameVersionFeature_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameVersionFeature getDefaultInstanceForType() {
            return GameVersionFeature.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameVersionFeature build() {
            GameVersionFeature gameVersionFeatureBuildPartial = buildPartial();
            if (gameVersionFeatureBuildPartial.isInitialized()) {
                return gameVersionFeatureBuildPartial;
            }
            throw newUninitializedMessageException((Message) gameVersionFeatureBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameVersionFeature buildPartial() {
            GameVersionFeature gameVersionFeature = new GameVersionFeature(this, null);
            buildPartialRepeatedFields(gameVersionFeature);
            if (this.bitField0_ != 0) {
                buildPartial0(gameVersionFeature);
            }
            onBuilt();
            return gameVersionFeature;
        }

        private void buildPartialRepeatedFields(GameVersionFeature gameVersionFeature) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 32) != 0) {
                    this.values_ = Collections.unmodifiableList(this.values_);
                    this.bitField0_ &= -33;
                }
                gameVersionFeature.values_ = this.values_;
                return;
            }
            gameVersionFeature.values_ = repeatedFieldBuilder.build();
        }

        private void buildPartial0(GameVersionFeature gameVersionFeature) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                gameVersionFeature.id_ = this.id_;
            }
            if ((i & 2) != 0) {
                gameVersionFeature.category_ = this.category_;
            }
            if ((i & 4) != 0) {
                gameVersionFeature.description_ = this.description_;
            }
            if ((i & 8) != 0) {
                gameVersionFeature.position_ = this.position_;
            }
            if ((i & 16) != 0) {
                gameVersionFeature.title_ = this.title_;
            }
            if ((i & 64) != 0) {
                gameVersionFeature.checksum_ = this.checksum_;
            }
        }

        @Override // proto.GameVersionFeatureOrBuilder
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

        @Override // proto.GameVersionFeatureOrBuilder
        public int getCategoryValue() {
            return this.category_;
        }

        public Builder setCategoryValue(int i) {
            this.category_ = i;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.GameVersionFeatureOrBuilder
        public GameVersionFeatureCategoryEnum getCategory() {
            GameVersionFeatureCategoryEnum gameVersionFeatureCategoryEnumForNumber = GameVersionFeatureCategoryEnum.forNumber(this.category_);
            return gameVersionFeatureCategoryEnumForNumber == null ? GameVersionFeatureCategoryEnum.UNRECOGNIZED : gameVersionFeatureCategoryEnumForNumber;
        }

        public Builder setCategory(GameVersionFeatureCategoryEnum gameVersionFeatureCategoryEnum) {
            gameVersionFeatureCategoryEnum.getClass();
            this.bitField0_ |= 2;
            this.category_ = gameVersionFeatureCategoryEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearCategory() {
            this.bitField0_ &= -3;
            this.category_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.GameVersionFeatureOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.description_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameVersionFeatureOrBuilder
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
            this.description_ = GameVersionFeature.getDefaultInstance().getDescription();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            byteString.getClass();
            GameVersionFeature.checkByteStringIsUtf8(byteString);
            this.description_ = byteString;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // proto.GameVersionFeatureOrBuilder
        public int getPosition() {
            return this.position_;
        }

        public Builder setPosition(int i) {
            this.position_ = i;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder clearPosition() {
            this.bitField0_ &= -9;
            this.position_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.GameVersionFeatureOrBuilder
        public String getTitle() {
            Object obj = this.title_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.title_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameVersionFeatureOrBuilder
        public ByteString getTitleBytes() {
            Object obj = this.title_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.title_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setTitle(String str) {
            str.getClass();
            this.title_ = str;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearTitle() {
            this.title_ = GameVersionFeature.getDefaultInstance().getTitle();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder setTitleBytes(ByteString byteString) {
            byteString.getClass();
            GameVersionFeature.checkByteStringIsUtf8(byteString);
            this.title_ = byteString;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        private void ensureValuesIsMutable() {
            if ((this.bitField0_ & 32) == 0) {
                this.values_ = new ArrayList(this.values_);
                this.bitField0_ |= 32;
            }
        }

        @Override // proto.GameVersionFeatureOrBuilder
        public List<GameVersionFeatureValue> getValuesList() {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.values_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameVersionFeatureOrBuilder
        public int getValuesCount() {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.values_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameVersionFeatureOrBuilder
        public GameVersionFeatureValue getValues(int i) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.values_.get(i);
            }
            return (GameVersionFeatureValue) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setValues(int i, GameVersionFeatureValue gameVersionFeatureValue) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVersionFeatureValue.getClass();
                ensureValuesIsMutable();
                this.values_.set(i, gameVersionFeatureValue);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, gameVersionFeatureValue);
            return this;
        }

        public Builder setValues(int i, GameVersionFeatureValue.Builder builder) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureValuesIsMutable();
                this.values_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addValues(GameVersionFeatureValue gameVersionFeatureValue) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVersionFeatureValue.getClass();
                ensureValuesIsMutable();
                this.values_.add(gameVersionFeatureValue);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(gameVersionFeatureValue);
            return this;
        }

        public Builder addValues(int i, GameVersionFeatureValue gameVersionFeatureValue) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVersionFeatureValue.getClass();
                ensureValuesIsMutable();
                this.values_.add(i, gameVersionFeatureValue);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, gameVersionFeatureValue);
            return this;
        }

        public Builder addValues(GameVersionFeatureValue.Builder builder) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureValuesIsMutable();
                this.values_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addValues(int i, GameVersionFeatureValue.Builder builder) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureValuesIsMutable();
                this.values_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllValues(Iterable<? extends GameVersionFeatureValue> iterable) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureValuesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.values_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearValues() {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.values_ = Collections.emptyList();
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeValues(int i) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureValuesIsMutable();
                this.values_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public GameVersionFeatureValue.Builder getValuesBuilder(int i) {
            return (GameVersionFeatureValue.Builder) getValuesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameVersionFeatureOrBuilder
        public GameVersionFeatureValueOrBuilder getValuesOrBuilder(int i) {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.values_.get(i);
            }
            return (GameVersionFeatureValueOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameVersionFeatureOrBuilder
        public List<? extends GameVersionFeatureValueOrBuilder> getValuesOrBuilderList() {
            RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> repeatedFieldBuilder = this.valuesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.values_);
        }

        public GameVersionFeatureValue.Builder addValuesBuilder() {
            return (GameVersionFeatureValue.Builder) getValuesFieldBuilder().addBuilder(GameVersionFeatureValue.getDefaultInstance());
        }

        public GameVersionFeatureValue.Builder addValuesBuilder(int i) {
            return (GameVersionFeatureValue.Builder) getValuesFieldBuilder().addBuilder(i, GameVersionFeatureValue.getDefaultInstance());
        }

        public List<GameVersionFeatureValue.Builder> getValuesBuilderList() {
            return getValuesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<GameVersionFeatureValue, GameVersionFeatureValue.Builder, GameVersionFeatureValueOrBuilder> getValuesFieldBuilder() {
            if (this.valuesBuilder_ == null) {
                this.valuesBuilder_ = new RepeatedFieldBuilder<>(this.values_, (this.bitField0_ & 32) != 0, getParentForChildren(), isClean());
                this.values_ = null;
            }
            return this.valuesBuilder_;
        }

        @Override // proto.GameVersionFeatureOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameVersionFeatureOrBuilder
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
            this.checksum_ = GameVersionFeature.getDefaultInstance().getChecksum();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            GameVersionFeature.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }
    }

    public static GameVersionFeature getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.GameVersionFeature$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<GameVersionFeature> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public GameVersionFeature parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = GameVersionFeature.newBuilder();
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

    public static Parser<GameVersionFeature> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GameVersionFeature> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GameVersionFeature getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
