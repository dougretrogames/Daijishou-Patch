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
public final class GameEngine extends GeneratedMessage implements GameEngineOrBuilder {
    public static final int CHECKSUM_FIELD_NUMBER = 11;
    public static final int COMPANIES_FIELD_NUMBER = 2;
    public static final int CREATED_AT_FIELD_NUMBER = 3;
    private static final GameEngine DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int LOGO_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 6;
    private static final Parser<GameEngine> PARSER;
    public static final int PLATFORMS_FIELD_NUMBER = 7;
    public static final int SLUG_FIELD_NUMBER = 8;
    public static final int UPDATED_AT_FIELD_NUMBER = 9;
    public static final int URL_FIELD_NUMBER = 10;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object checksum_;
    private List<Company> companies_;
    private Timestamp createdAt_;
    private volatile Object description_;
    private long id_;
    private GameEngineLogo logo_;
    private volatile Object name_;
    private List<Platform> platforms_;
    private volatile Object slug_;
    private Timestamp updatedAt_;
    private volatile Object url_;

    /* synthetic */ GameEngine(GeneratedMessage.Builder builder, GameEngineIA gameEngineIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", GameEngine.class.getName());
        DEFAULT_INSTANCE = new GameEngine();
        PARSER = new AnonymousClass1();
    }

    private GameEngine(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.description_ = "";
        this.name_ = "";
        this.slug_ = "";
        this.url_ = "";
        this.checksum_ = "";
    }

    private GameEngine() {
        this.id_ = 0L;
        this.description_ = "";
        this.name_ = "";
        this.slug_ = "";
        this.url_ = "";
        this.checksum_ = "";
        this.companies_ = Collections.emptyList();
        this.description_ = "";
        this.name_ = "";
        this.platforms_ = Collections.emptyList();
        this.slug_ = "";
        this.url_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_GameEngine_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_GameEngine_fieldAccessorTable.ensureFieldAccessorsInitialized(GameEngine.class, Builder.class);
    }

    @Override // proto.GameEngineOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.GameEngineOrBuilder
    public List<Company> getCompaniesList() {
        return this.companies_;
    }

    @Override // proto.GameEngineOrBuilder
    public List<? extends CompanyOrBuilder> getCompaniesOrBuilderList() {
        return this.companies_;
    }

    @Override // proto.GameEngineOrBuilder
    public int getCompaniesCount() {
        return this.companies_.size();
    }

    @Override // proto.GameEngineOrBuilder
    public Company getCompanies(int i) {
        return this.companies_.get(i);
    }

    @Override // proto.GameEngineOrBuilder
    public CompanyOrBuilder getCompaniesOrBuilder(int i) {
        return this.companies_.get(i);
    }

    @Override // proto.GameEngineOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.GameEngineOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameEngineOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameEngineOrBuilder
    public String getDescription() {
        Object obj = this.description_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.description_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameEngineOrBuilder
    public ByteString getDescriptionBytes() {
        Object obj = this.description_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.description_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.GameEngineOrBuilder
    public boolean hasLogo() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.GameEngineOrBuilder
    public GameEngineLogo getLogo() {
        GameEngineLogo gameEngineLogo = this.logo_;
        return gameEngineLogo == null ? GameEngineLogo.getDefaultInstance() : gameEngineLogo;
    }

    @Override // proto.GameEngineOrBuilder
    public GameEngineLogoOrBuilder getLogoOrBuilder() {
        GameEngineLogo gameEngineLogo = this.logo_;
        return gameEngineLogo == null ? GameEngineLogo.getDefaultInstance() : gameEngineLogo;
    }

    @Override // proto.GameEngineOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameEngineOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.GameEngineOrBuilder
    public List<Platform> getPlatformsList() {
        return this.platforms_;
    }

    @Override // proto.GameEngineOrBuilder
    public List<? extends PlatformOrBuilder> getPlatformsOrBuilderList() {
        return this.platforms_;
    }

    @Override // proto.GameEngineOrBuilder
    public int getPlatformsCount() {
        return this.platforms_.size();
    }

    @Override // proto.GameEngineOrBuilder
    public Platform getPlatforms(int i) {
        return this.platforms_.get(i);
    }

    @Override // proto.GameEngineOrBuilder
    public PlatformOrBuilder getPlatformsOrBuilder(int i) {
        return this.platforms_.get(i);
    }

    @Override // proto.GameEngineOrBuilder
    public String getSlug() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.slug_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameEngineOrBuilder
    public ByteString getSlugBytes() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.slug_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.GameEngineOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.GameEngineOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameEngineOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameEngineOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameEngineOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.GameEngineOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameEngineOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static GameEngine parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GameEngine parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GameEngine parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GameEngine parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GameEngine parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GameEngine parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static GameEngine parseFrom(InputStream inputStream) throws IOException {
        return (GameEngine) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static GameEngine parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameEngine) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameEngine parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GameEngine) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GameEngine parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameEngine) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GameEngine parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GameEngine) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static GameEngine parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GameEngine) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GameEngine gameEngine) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) gameEngine);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((GameEngineIA) null) : (Builder) new Builder((GameEngineIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameEngineOrBuilder {
        private int bitField0_;
        private Object checksum_;
        private RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> companiesBuilder_;
        private List<Company> companies_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private Object description_;
        private long id_;
        private SingleFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> logoBuilder_;
        private GameEngineLogo logo_;
        private Object name_;
        private RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> platformsBuilder_;
        private List<Platform> platforms_;
        private Object slug_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;
        private Object url_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, GameEngineIA gameEngineIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(GameEngineIA gameEngineIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_GameEngine_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_GameEngine_fieldAccessorTable.ensureFieldAccessorsInitialized(GameEngine.class, Builder.class);
        }

        private Builder() {
            this.companies_ = Collections.emptyList();
            this.description_ = "";
            this.name_ = "";
            this.platforms_ = Collections.emptyList();
            this.slug_ = "";
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.companies_ = Collections.emptyList();
            this.description_ = "";
            this.name_ = "";
            this.platforms_ = Collections.emptyList();
            this.slug_ = "";
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (GameEngine.alwaysUseFieldBuilders) {
                getCompaniesFieldBuilder();
                getCreatedAtFieldBuilder();
                getLogoFieldBuilder();
                getPlatformsFieldBuilder();
                getUpdatedAtFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.companies_ = Collections.emptyList();
            } else {
                this.companies_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -3;
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.createdAtBuilder_ = null;
            }
            this.description_ = "";
            this.logo_ = null;
            SingleFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> singleFieldBuilder2 = this.logoBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.logoBuilder_ = null;
            }
            this.name_ = "";
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder2 = this.platformsBuilder_;
            if (repeatedFieldBuilder2 == null) {
                this.platforms_ = Collections.emptyList();
            } else {
                this.platforms_ = null;
                repeatedFieldBuilder2.clear();
            }
            this.bitField0_ &= -65;
            this.slug_ = "";
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.updatedAtBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.url_ = "";
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_GameEngine_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GameEngine getDefaultInstanceForType() {
            return GameEngine.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameEngine build() {
            GameEngine gameEngineBuildPartial = buildPartial();
            if (gameEngineBuildPartial.isInitialized()) {
                return gameEngineBuildPartial;
            }
            throw newUninitializedMessageException((Message) gameEngineBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GameEngine buildPartial() {
            GameEngine gameEngine = new GameEngine(this, null);
            buildPartialRepeatedFields(gameEngine);
            if (this.bitField0_ != 0) {
                buildPartial0(gameEngine);
            }
            onBuilt();
            return gameEngine;
        }

        private void buildPartialRepeatedFields(GameEngine gameEngine) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 2) != 0) {
                    this.companies_ = Collections.unmodifiableList(this.companies_);
                    this.bitField0_ &= -3;
                }
                gameEngine.companies_ = this.companies_;
            } else {
                gameEngine.companies_ = repeatedFieldBuilder.build();
            }
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder2 = this.platformsBuilder_;
            if (repeatedFieldBuilder2 == null) {
                if ((this.bitField0_ & 64) != 0) {
                    this.platforms_ = Collections.unmodifiableList(this.platforms_);
                    this.bitField0_ &= -65;
                }
                gameEngine.platforms_ = this.platforms_;
                return;
            }
            gameEngine.platforms_ = repeatedFieldBuilder2.build();
        }

        private void buildPartial0(GameEngine gameEngine) {
            int i;
            Timestamp timestamp;
            GameEngineLogo gameEngineLogo;
            Timestamp timestamp2;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                gameEngine.id_ = this.id_;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
                if (singleFieldBuilder == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder.build();
                }
                gameEngine.createdAt_ = timestamp2;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                gameEngine.description_ = this.description_;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> singleFieldBuilder2 = this.logoBuilder_;
                if (singleFieldBuilder2 == null) {
                    gameEngineLogo = this.logo_;
                } else {
                    gameEngineLogo = (GameEngineLogo) singleFieldBuilder2.build();
                }
                gameEngine.logo_ = gameEngineLogo;
                i |= 2;
            }
            if ((i2 & 32) != 0) {
                gameEngine.name_ = this.name_;
            }
            if ((i2 & 128) != 0) {
                gameEngine.slug_ = this.slug_;
            }
            if ((i2 & 256) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.updatedAtBuilder_;
                if (singleFieldBuilder3 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder3.build();
                }
                gameEngine.updatedAt_ = timestamp;
                i |= 4;
            }
            if ((i2 & 512) != 0) {
                gameEngine.url_ = this.url_;
            }
            if ((i2 & 1024) != 0) {
                gameEngine.checksum_ = this.checksum_;
            }
            gameEngine.bitField0_ |= i;
        }

        @Override // proto.GameEngineOrBuilder
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

        @Override // proto.GameEngineOrBuilder
        public List<Company> getCompaniesList() {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.companies_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameEngineOrBuilder
        public int getCompaniesCount() {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.companies_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameEngineOrBuilder
        public Company getCompanies(int i) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.companies_.get(i);
            }
            return (Company) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setCompanies(int i, Company company) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                company.getClass();
                ensureCompaniesIsMutable();
                this.companies_.set(i, company);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, company);
            return this;
        }

        public Builder setCompanies(int i, Company.Builder builder) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompaniesIsMutable();
                this.companies_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addCompanies(Company company) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                company.getClass();
                ensureCompaniesIsMutable();
                this.companies_.add(company);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(company);
            return this;
        }

        public Builder addCompanies(int i, Company company) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                company.getClass();
                ensureCompaniesIsMutable();
                this.companies_.add(i, company);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, company);
            return this;
        }

        public Builder addCompanies(Company.Builder builder) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompaniesIsMutable();
                this.companies_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addCompanies(int i, Company.Builder builder) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompaniesIsMutable();
                this.companies_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllCompanies(Iterable<? extends Company> iterable) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
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
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
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
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCompaniesIsMutable();
                this.companies_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Company.Builder getCompaniesBuilder(int i) {
            return (Company.Builder) getCompaniesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameEngineOrBuilder
        public CompanyOrBuilder getCompaniesOrBuilder(int i) {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.companies_.get(i);
            }
            return (CompanyOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameEngineOrBuilder
        public List<? extends CompanyOrBuilder> getCompaniesOrBuilderList() {
            RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> repeatedFieldBuilder = this.companiesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.companies_);
        }

        public Company.Builder addCompaniesBuilder() {
            return (Company.Builder) getCompaniesFieldBuilder().addBuilder(Company.getDefaultInstance());
        }

        public Company.Builder addCompaniesBuilder(int i) {
            return (Company.Builder) getCompaniesFieldBuilder().addBuilder(i, Company.getDefaultInstance());
        }

        public List<Company.Builder> getCompaniesBuilderList() {
            return getCompaniesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Company, Company.Builder, CompanyOrBuilder> getCompaniesFieldBuilder() {
            if (this.companiesBuilder_ == null) {
                this.companiesBuilder_ = new RepeatedFieldBuilder<>(this.companies_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.companies_ = null;
            }
            return this.companiesBuilder_;
        }

        @Override // proto.GameEngineOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // proto.GameEngineOrBuilder
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

        @Override // proto.GameEngineOrBuilder
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

        @Override // proto.GameEngineOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.description_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameEngineOrBuilder
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
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder clearDescription() {
            this.description_ = GameEngine.getDefaultInstance().getDescription();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            byteString.getClass();
            GameEngine.checkByteStringIsUtf8(byteString);
            this.description_ = byteString;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // proto.GameEngineOrBuilder
        public boolean hasLogo() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // proto.GameEngineOrBuilder
        public GameEngineLogo getLogo() {
            SingleFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> singleFieldBuilder = this.logoBuilder_;
            if (singleFieldBuilder == null) {
                GameEngineLogo gameEngineLogo = this.logo_;
                return gameEngineLogo == null ? GameEngineLogo.getDefaultInstance() : gameEngineLogo;
            }
            return (GameEngineLogo) singleFieldBuilder.getMessage();
        }

        public Builder setLogo(GameEngineLogo gameEngineLogo) {
            SingleFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> singleFieldBuilder = this.logoBuilder_;
            if (singleFieldBuilder == null) {
                gameEngineLogo.getClass();
                this.logo_ = gameEngineLogo;
            } else {
                singleFieldBuilder.setMessage(gameEngineLogo);
            }
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setLogo(GameEngineLogo.Builder builder) {
            SingleFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> singleFieldBuilder = this.logoBuilder_;
            if (singleFieldBuilder == null) {
                this.logo_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder mergeLogo(GameEngineLogo gameEngineLogo) {
            GameEngineLogo gameEngineLogo2;
            SingleFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> singleFieldBuilder = this.logoBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 16) != 0 && (gameEngineLogo2 = this.logo_) != null && gameEngineLogo2 != GameEngineLogo.getDefaultInstance()) {
                    getLogoBuilder().mergeFrom((Message) gameEngineLogo);
                } else {
                    this.logo_ = gameEngineLogo;
                }
            } else {
                singleFieldBuilder.mergeFrom(gameEngineLogo);
            }
            if (this.logo_ != null) {
                this.bitField0_ |= 16;
                onChanged();
            }
            return this;
        }

        public Builder clearLogo() {
            this.bitField0_ &= -17;
            this.logo_ = null;
            SingleFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> singleFieldBuilder = this.logoBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.logoBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public GameEngineLogo.Builder getLogoBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (GameEngineLogo.Builder) getLogoFieldBuilder().getBuilder();
        }

        @Override // proto.GameEngineOrBuilder
        public GameEngineLogoOrBuilder getLogoOrBuilder() {
            SingleFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> singleFieldBuilder = this.logoBuilder_;
            if (singleFieldBuilder != null) {
                return (GameEngineLogoOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            GameEngineLogo gameEngineLogo = this.logo_;
            return gameEngineLogo == null ? GameEngineLogo.getDefaultInstance() : gameEngineLogo;
        }

        private SingleFieldBuilder<GameEngineLogo, GameEngineLogo.Builder, GameEngineLogoOrBuilder> getLogoFieldBuilder() {
            if (this.logoBuilder_ == null) {
                this.logoBuilder_ = new SingleFieldBuilder<>(getLogo(), getParentForChildren(), isClean());
                this.logo_ = null;
            }
            return this.logoBuilder_;
        }

        @Override // proto.GameEngineOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameEngineOrBuilder
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
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = GameEngine.getDefaultInstance().getName();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            GameEngine.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        private void ensurePlatformsIsMutable() {
            if ((this.bitField0_ & 64) == 0) {
                this.platforms_ = new ArrayList(this.platforms_);
                this.bitField0_ |= 64;
            }
        }

        @Override // proto.GameEngineOrBuilder
        public List<Platform> getPlatformsList() {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.platforms_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameEngineOrBuilder
        public int getPlatformsCount() {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platforms_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameEngineOrBuilder
        public Platform getPlatforms(int i) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platforms_.get(i);
            }
            return (Platform) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setPlatforms(int i, Platform platform) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                platform.getClass();
                ensurePlatformsIsMutable();
                this.platforms_.set(i, platform);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, platform);
            return this;
        }

        public Builder setPlatforms(int i, Platform.Builder builder) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformsIsMutable();
                this.platforms_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addPlatforms(Platform platform) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                platform.getClass();
                ensurePlatformsIsMutable();
                this.platforms_.add(platform);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(platform);
            return this;
        }

        public Builder addPlatforms(int i, Platform platform) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                platform.getClass();
                ensurePlatformsIsMutable();
                this.platforms_.add(i, platform);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, platform);
            return this;
        }

        public Builder addPlatforms(Platform.Builder builder) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformsIsMutable();
                this.platforms_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addPlatforms(int i, Platform.Builder builder) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformsIsMutable();
                this.platforms_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllPlatforms(Iterable<? extends Platform> iterable) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.platforms_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearPlatforms() {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.platforms_ = Collections.emptyList();
                this.bitField0_ &= -65;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removePlatforms(int i) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformsIsMutable();
                this.platforms_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Platform.Builder getPlatformsBuilder(int i) {
            return (Platform.Builder) getPlatformsFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameEngineOrBuilder
        public PlatformOrBuilder getPlatformsOrBuilder(int i) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platforms_.get(i);
            }
            return (PlatformOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameEngineOrBuilder
        public List<? extends PlatformOrBuilder> getPlatformsOrBuilderList() {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.platforms_);
        }

        public Platform.Builder addPlatformsBuilder() {
            return (Platform.Builder) getPlatformsFieldBuilder().addBuilder(Platform.getDefaultInstance());
        }

        public Platform.Builder addPlatformsBuilder(int i) {
            return (Platform.Builder) getPlatformsFieldBuilder().addBuilder(i, Platform.getDefaultInstance());
        }

        public List<Platform.Builder> getPlatformsBuilderList() {
            return getPlatformsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> getPlatformsFieldBuilder() {
            if (this.platformsBuilder_ == null) {
                this.platformsBuilder_ = new RepeatedFieldBuilder<>(this.platforms_, (this.bitField0_ & 64) != 0, getParentForChildren(), isClean());
                this.platforms_ = null;
            }
            return this.platformsBuilder_;
        }

        @Override // proto.GameEngineOrBuilder
        public String getSlug() {
            Object obj = this.slug_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.slug_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameEngineOrBuilder
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
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder clearSlug() {
            this.slug_ = GameEngine.getDefaultInstance().getSlug();
            this.bitField0_ &= -129;
            onChanged();
            return this;
        }

        public Builder setSlugBytes(ByteString byteString) {
            byteString.getClass();
            GameEngine.checkByteStringIsUtf8(byteString);
            this.slug_ = byteString;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        @Override // proto.GameEngineOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // proto.GameEngineOrBuilder
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

        @Override // proto.GameEngineOrBuilder
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

        @Override // proto.GameEngineOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameEngineOrBuilder
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
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = GameEngine.getDefaultInstance().getUrl();
            this.bitField0_ &= -513;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            GameEngine.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        @Override // proto.GameEngineOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameEngineOrBuilder
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
            this.checksum_ = GameEngine.getDefaultInstance().getChecksum();
            this.bitField0_ &= -1025;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            GameEngine.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }
    }

    public static GameEngine getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.GameEngine$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<GameEngine> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public GameEngine parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = GameEngine.newBuilder();
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

    public static Parser<GameEngine> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GameEngine> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GameEngine getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
