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
public final class InvolvedCompany extends GeneratedMessage implements InvolvedCompanyOrBuilder {
    public static final int CHECKSUM_FIELD_NUMBER = 10;
    public static final int COMPANY_FIELD_NUMBER = 2;
    public static final int CREATED_AT_FIELD_NUMBER = 3;
    private static final InvolvedCompany DEFAULT_INSTANCE;
    public static final int DEVELOPER_FIELD_NUMBER = 4;
    public static final int GAME_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 1;
    private static final Parser<InvolvedCompany> PARSER;
    public static final int PORTING_FIELD_NUMBER = 6;
    public static final int PUBLISHER_FIELD_NUMBER = 7;
    public static final int SUPPORTING_FIELD_NUMBER = 8;
    public static final int UPDATED_AT_FIELD_NUMBER = 9;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object checksum_;
    private Company company_;
    private Timestamp createdAt_;
    private boolean developer_;
    private Game game_;
    private long id_;
    private boolean porting_;
    private boolean publisher_;
    private boolean supporting_;
    private Timestamp updatedAt_;

    /* synthetic */ InvolvedCompany(GeneratedMessage.Builder builder, InvolvedCompanyIA involvedCompanyIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", InvolvedCompany.class.getName());
        DEFAULT_INSTANCE = new InvolvedCompany();
        PARSER = new AnonymousClass1();
    }

    private InvolvedCompany(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.developer_ = false;
        this.porting_ = false;
        this.publisher_ = false;
        this.supporting_ = false;
        this.checksum_ = "";
    }

    private InvolvedCompany() {
        this.id_ = 0L;
        this.developer_ = false;
        this.porting_ = false;
        this.publisher_ = false;
        this.supporting_ = false;
        this.checksum_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_InvolvedCompany_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_InvolvedCompany_fieldAccessorTable.ensureFieldAccessorsInitialized(InvolvedCompany.class, Builder.class);
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public boolean hasCompany() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public Company getCompany() {
        Company company = this.company_;
        return company == null ? Company.getDefaultInstance() : company;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public CompanyOrBuilder getCompanyOrBuilder() {
        Company company = this.company_;
        return company == null ? Company.getDefaultInstance() : company;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public boolean getDeveloper() {
        return this.developer_;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public boolean hasGame() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public Game getGame() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public GameOrBuilder getGameOrBuilder() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public boolean getPorting() {
        return this.porting_;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public boolean getPublisher() {
        return this.publisher_;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public boolean getSupporting() {
        return this.supporting_;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.InvolvedCompanyOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static InvolvedCompany parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static InvolvedCompany parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static InvolvedCompany parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static InvolvedCompany parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static InvolvedCompany parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static InvolvedCompany parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static InvolvedCompany parseFrom(InputStream inputStream) throws IOException {
        return (InvolvedCompany) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static InvolvedCompany parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (InvolvedCompany) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static InvolvedCompany parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (InvolvedCompany) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static InvolvedCompany parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (InvolvedCompany) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static InvolvedCompany parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (InvolvedCompany) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static InvolvedCompany parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (InvolvedCompany) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(InvolvedCompany involvedCompany) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) involvedCompany);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((InvolvedCompanyIA) null) : (Builder) new Builder((InvolvedCompanyIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements InvolvedCompanyOrBuilder {
        private int bitField0_;
        private Object checksum_;
        private SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> companyBuilder_;
        private Company company_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private boolean developer_;
        private SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> gameBuilder_;
        private Game game_;
        private long id_;
        private boolean porting_;
        private boolean publisher_;
        private boolean supporting_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, InvolvedCompanyIA involvedCompanyIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(InvolvedCompanyIA involvedCompanyIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_InvolvedCompany_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_InvolvedCompany_fieldAccessorTable.ensureFieldAccessorsInitialized(InvolvedCompany.class, Builder.class);
        }

        private Builder() {
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (InvolvedCompany.alwaysUseFieldBuilders) {
                getCompanyFieldBuilder();
                getCreatedAtFieldBuilder();
                getGameFieldBuilder();
                getUpdatedAtFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.company_ = null;
            SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.companyBuilder_ = null;
            }
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.createdAtBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.createdAtBuilder_ = null;
            }
            this.developer_ = false;
            this.game_ = null;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder3 = this.gameBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.gameBuilder_ = null;
            }
            this.porting_ = false;
            this.publisher_ = false;
            this.supporting_ = false;
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.updatedAtBuilder_;
            if (singleFieldBuilder4 != null) {
                singleFieldBuilder4.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_InvolvedCompany_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public InvolvedCompany getDefaultInstanceForType() {
            return InvolvedCompany.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public InvolvedCompany build() {
            InvolvedCompany involvedCompanyBuildPartial = buildPartial();
            if (involvedCompanyBuildPartial.isInitialized()) {
                return involvedCompanyBuildPartial;
            }
            throw newUninitializedMessageException((Message) involvedCompanyBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public InvolvedCompany buildPartial() {
            InvolvedCompany involvedCompany = new InvolvedCompany(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(involvedCompany);
            }
            onBuilt();
            return involvedCompany;
        }

        private void buildPartial0(InvolvedCompany involvedCompany) {
            int i;
            Timestamp timestamp;
            Game game;
            Timestamp timestamp2;
            Company company;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                involvedCompany.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
                if (singleFieldBuilder == null) {
                    company = this.company_;
                } else {
                    company = (Company) singleFieldBuilder.build();
                }
                involvedCompany.company_ = company;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.createdAtBuilder_;
                if (singleFieldBuilder2 == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder2.build();
                }
                involvedCompany.createdAt_ = timestamp2;
                i |= 2;
            }
            if ((i2 & 8) != 0) {
                involvedCompany.developer_ = this.developer_;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder3 = this.gameBuilder_;
                if (singleFieldBuilder3 == null) {
                    game = this.game_;
                } else {
                    game = (Game) singleFieldBuilder3.build();
                }
                involvedCompany.game_ = game;
                i |= 4;
            }
            if ((i2 & 32) != 0) {
                involvedCompany.porting_ = this.porting_;
            }
            if ((i2 & 64) != 0) {
                involvedCompany.publisher_ = this.publisher_;
            }
            if ((i2 & 128) != 0) {
                involvedCompany.supporting_ = this.supporting_;
            }
            if ((i2 & 256) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.updatedAtBuilder_;
                if (singleFieldBuilder4 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder4.build();
                }
                involvedCompany.updatedAt_ = timestamp;
                i |= 8;
            }
            if ((i2 & 512) != 0) {
                involvedCompany.checksum_ = this.checksum_;
            }
            involvedCompany.bitField0_ |= i;
        }

        @Override // proto.InvolvedCompanyOrBuilder
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

        @Override // proto.InvolvedCompanyOrBuilder
        public boolean hasCompany() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // proto.InvolvedCompanyOrBuilder
        public Company getCompany() {
            SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
            if (singleFieldBuilder == null) {
                Company company = this.company_;
                return company == null ? Company.getDefaultInstance() : company;
            }
            return (Company) singleFieldBuilder.getMessage();
        }

        public Builder setCompany(Company company) {
            SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
            if (singleFieldBuilder == null) {
                company.getClass();
                this.company_ = company;
            } else {
                singleFieldBuilder.setMessage(company);
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setCompany(Company.Builder builder) {
            SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
            if (singleFieldBuilder == null) {
                this.company_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder mergeCompany(Company company) {
            Company company2;
            SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 2) != 0 && (company2 = this.company_) != null && company2 != Company.getDefaultInstance()) {
                    getCompanyBuilder().mergeFrom((Message) company);
                } else {
                    this.company_ = company;
                }
            } else {
                singleFieldBuilder.mergeFrom(company);
            }
            if (this.company_ != null) {
                this.bitField0_ |= 2;
                onChanged();
            }
            return this;
        }

        public Builder clearCompany() {
            this.bitField0_ &= -3;
            this.company_ = null;
            SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.companyBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Company.Builder getCompanyBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (Company.Builder) getCompanyFieldBuilder().getBuilder();
        }

        @Override // proto.InvolvedCompanyOrBuilder
        public CompanyOrBuilder getCompanyOrBuilder() {
            SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
            if (singleFieldBuilder != null) {
                return (CompanyOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Company company = this.company_;
            return company == null ? Company.getDefaultInstance() : company;
        }

        private SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> getCompanyFieldBuilder() {
            if (this.companyBuilder_ == null) {
                this.companyBuilder_ = new SingleFieldBuilder<>(getCompany(), getParentForChildren(), isClean());
                this.company_ = null;
            }
            return this.companyBuilder_;
        }

        @Override // proto.InvolvedCompanyOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // proto.InvolvedCompanyOrBuilder
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

        @Override // proto.InvolvedCompanyOrBuilder
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

        @Override // proto.InvolvedCompanyOrBuilder
        public boolean getDeveloper() {
            return this.developer_;
        }

        public Builder setDeveloper(boolean z) {
            this.developer_ = z;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder clearDeveloper() {
            this.bitField0_ &= -9;
            this.developer_ = false;
            onChanged();
            return this;
        }

        @Override // proto.InvolvedCompanyOrBuilder
        public boolean hasGame() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // proto.InvolvedCompanyOrBuilder
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

        @Override // proto.InvolvedCompanyOrBuilder
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

        @Override // proto.InvolvedCompanyOrBuilder
        public boolean getPorting() {
            return this.porting_;
        }

        public Builder setPorting(boolean z) {
            this.porting_ = z;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearPorting() {
            this.bitField0_ &= -33;
            this.porting_ = false;
            onChanged();
            return this;
        }

        @Override // proto.InvolvedCompanyOrBuilder
        public boolean getPublisher() {
            return this.publisher_;
        }

        public Builder setPublisher(boolean z) {
            this.publisher_ = z;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearPublisher() {
            this.bitField0_ &= -65;
            this.publisher_ = false;
            onChanged();
            return this;
        }

        @Override // proto.InvolvedCompanyOrBuilder
        public boolean getSupporting() {
            return this.supporting_;
        }

        public Builder setSupporting(boolean z) {
            this.supporting_ = z;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder clearSupporting() {
            this.bitField0_ &= -129;
            this.supporting_ = false;
            onChanged();
            return this;
        }

        @Override // proto.InvolvedCompanyOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // proto.InvolvedCompanyOrBuilder
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

        @Override // proto.InvolvedCompanyOrBuilder
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

        @Override // proto.InvolvedCompanyOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.InvolvedCompanyOrBuilder
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
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = InvolvedCompany.getDefaultInstance().getChecksum();
            this.bitField0_ &= -513;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            InvolvedCompany.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }
    }

    public static InvolvedCompany getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.InvolvedCompany$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<InvolvedCompany> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public InvolvedCompany parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = InvolvedCompany.newBuilder();
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

    public static Parser<InvolvedCompany> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<InvolvedCompany> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public InvolvedCompany getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
