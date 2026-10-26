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
public final class Search extends GeneratedMessage implements SearchOrBuilder {
    public static final int ALTERNATIVE_NAME_FIELD_NUMBER = 2;
    public static final int CHARACTER_FIELD_NUMBER = 3;
    public static final int CHECKSUM_FIELD_NUMBER = 13;
    public static final int COLLECTION_FIELD_NUMBER = 4;
    public static final int COMPANY_FIELD_NUMBER = 5;
    private static final Search DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 6;
    public static final int GAME_FIELD_NUMBER = 7;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 8;
    private static final Parser<Search> PARSER;
    public static final int PLATFORM_FIELD_NUMBER = 9;
    public static final int PUBLISHED_AT_FIELD_NUMBER = 10;
    public static final int TEST_DUMMY_FIELD_NUMBER = 11;
    public static final int THEME_FIELD_NUMBER = 12;
    private static final long serialVersionUID = 0;
    private volatile Object alternativeName_;
    private int bitField0_;
    private Character character_;
    private volatile Object checksum_;
    private Collection collection_;
    private Company company_;
    private volatile Object description_;
    private Game game_;
    private long id_;
    private volatile Object name_;
    private Platform platform_;
    private Timestamp publishedAt_;
    private TestDummy testDummy_;
    private Theme theme_;

    /* synthetic */ Search(GeneratedMessage.Builder builder, SearchIA searchIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Search.class.getName());
        DEFAULT_INSTANCE = new Search();
        PARSER = new AnonymousClass1();
    }

    private Search(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.alternativeName_ = "";
        this.description_ = "";
        this.name_ = "";
        this.checksum_ = "";
    }

    private Search() {
        this.id_ = 0L;
        this.alternativeName_ = "";
        this.description_ = "";
        this.name_ = "";
        this.checksum_ = "";
        this.alternativeName_ = "";
        this.description_ = "";
        this.name_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_Search_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_Search_fieldAccessorTable.ensureFieldAccessorsInitialized(Search.class, Builder.class);
    }

    @Override // proto.SearchOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.SearchOrBuilder
    public String getAlternativeName() {
        Object obj = this.alternativeName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.alternativeName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.SearchOrBuilder
    public ByteString getAlternativeNameBytes() {
        Object obj = this.alternativeName_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.alternativeName_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.SearchOrBuilder
    public boolean hasCharacter() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.SearchOrBuilder
    public Character getCharacter() {
        Character character = this.character_;
        return character == null ? Character.getDefaultInstance() : character;
    }

    @Override // proto.SearchOrBuilder
    public CharacterOrBuilder getCharacterOrBuilder() {
        Character character = this.character_;
        return character == null ? Character.getDefaultInstance() : character;
    }

    @Override // proto.SearchOrBuilder
    public boolean hasCollection() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.SearchOrBuilder
    public Collection getCollection() {
        Collection collection = this.collection_;
        return collection == null ? Collection.getDefaultInstance() : collection;
    }

    @Override // proto.SearchOrBuilder
    public CollectionOrBuilder getCollectionOrBuilder() {
        Collection collection = this.collection_;
        return collection == null ? Collection.getDefaultInstance() : collection;
    }

    @Override // proto.SearchOrBuilder
    public boolean hasCompany() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.SearchOrBuilder
    public Company getCompany() {
        Company company = this.company_;
        return company == null ? Company.getDefaultInstance() : company;
    }

    @Override // proto.SearchOrBuilder
    public CompanyOrBuilder getCompanyOrBuilder() {
        Company company = this.company_;
        return company == null ? Company.getDefaultInstance() : company;
    }

    @Override // proto.SearchOrBuilder
    public String getDescription() {
        Object obj = this.description_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.description_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.SearchOrBuilder
    public ByteString getDescriptionBytes() {
        Object obj = this.description_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.description_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.SearchOrBuilder
    public boolean hasGame() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // proto.SearchOrBuilder
    public Game getGame() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.SearchOrBuilder
    public GameOrBuilder getGameOrBuilder() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.SearchOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.SearchOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.SearchOrBuilder
    public boolean hasPlatform() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // proto.SearchOrBuilder
    public Platform getPlatform() {
        Platform platform = this.platform_;
        return platform == null ? Platform.getDefaultInstance() : platform;
    }

    @Override // proto.SearchOrBuilder
    public PlatformOrBuilder getPlatformOrBuilder() {
        Platform platform = this.platform_;
        return platform == null ? Platform.getDefaultInstance() : platform;
    }

    @Override // proto.SearchOrBuilder
    public boolean hasPublishedAt() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // proto.SearchOrBuilder
    public Timestamp getPublishedAt() {
        Timestamp timestamp = this.publishedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.SearchOrBuilder
    public TimestampOrBuilder getPublishedAtOrBuilder() {
        Timestamp timestamp = this.publishedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.SearchOrBuilder
    public boolean hasTestDummy() {
        return (this.bitField0_ & 64) != 0;
    }

    @Override // proto.SearchOrBuilder
    public TestDummy getTestDummy() {
        TestDummy testDummy = this.testDummy_;
        return testDummy == null ? TestDummy.getDefaultInstance() : testDummy;
    }

    @Override // proto.SearchOrBuilder
    public TestDummyOrBuilder getTestDummyOrBuilder() {
        TestDummy testDummy = this.testDummy_;
        return testDummy == null ? TestDummy.getDefaultInstance() : testDummy;
    }

    @Override // proto.SearchOrBuilder
    public boolean hasTheme() {
        return (this.bitField0_ & 128) != 0;
    }

    @Override // proto.SearchOrBuilder
    public Theme getTheme() {
        Theme theme = this.theme_;
        return theme == null ? Theme.getDefaultInstance() : theme;
    }

    @Override // proto.SearchOrBuilder
    public ThemeOrBuilder getThemeOrBuilder() {
        Theme theme = this.theme_;
        return theme == null ? Theme.getDefaultInstance() : theme;
    }

    @Override // proto.SearchOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.SearchOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static Search parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Search parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Search parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Search parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Search parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Search parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Search parseFrom(InputStream inputStream) throws IOException {
        return (Search) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Search parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Search) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Search parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Search) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Search parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Search) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Search parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Search) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Search parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Search) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(Search search) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) search);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((SearchIA) null) : (Builder) new Builder((SearchIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements SearchOrBuilder {
        private Object alternativeName_;
        private int bitField0_;
        private SingleFieldBuilder<Character, Character.Builder, CharacterOrBuilder> characterBuilder_;
        private Character character_;
        private Object checksum_;
        private SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> collectionBuilder_;
        private Collection collection_;
        private SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> companyBuilder_;
        private Company company_;
        private Object description_;
        private SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> gameBuilder_;
        private Game game_;
        private long id_;
        private Object name_;
        private SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> platformBuilder_;
        private Platform platform_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> publishedAtBuilder_;
        private Timestamp publishedAt_;
        private SingleFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> testDummyBuilder_;
        private TestDummy testDummy_;
        private SingleFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> themeBuilder_;
        private Theme theme_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, SearchIA searchIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(SearchIA searchIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_Search_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_Search_fieldAccessorTable.ensureFieldAccessorsInitialized(Search.class, Builder.class);
        }

        private Builder() {
            this.alternativeName_ = "";
            this.description_ = "";
            this.name_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.alternativeName_ = "";
            this.description_ = "";
            this.name_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (Search.alwaysUseFieldBuilders) {
                getCharacterFieldBuilder();
                getCollectionFieldBuilder();
                getCompanyFieldBuilder();
                getGameFieldBuilder();
                getPlatformFieldBuilder();
                getPublishedAtFieldBuilder();
                getTestDummyFieldBuilder();
                getThemeFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.alternativeName_ = "";
            this.character_ = null;
            SingleFieldBuilder<Character, Character.Builder, CharacterOrBuilder> singleFieldBuilder = this.characterBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.characterBuilder_ = null;
            }
            this.collection_ = null;
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder2 = this.collectionBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.collectionBuilder_ = null;
            }
            this.company_ = null;
            SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder3 = this.companyBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.companyBuilder_ = null;
            }
            this.description_ = "";
            this.game_ = null;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder4 = this.gameBuilder_;
            if (singleFieldBuilder4 != null) {
                singleFieldBuilder4.dispose();
                this.gameBuilder_ = null;
            }
            this.name_ = "";
            this.platform_ = null;
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder5 = this.platformBuilder_;
            if (singleFieldBuilder5 != null) {
                singleFieldBuilder5.dispose();
                this.platformBuilder_ = null;
            }
            this.publishedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder6 = this.publishedAtBuilder_;
            if (singleFieldBuilder6 != null) {
                singleFieldBuilder6.dispose();
                this.publishedAtBuilder_ = null;
            }
            this.testDummy_ = null;
            SingleFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> singleFieldBuilder7 = this.testDummyBuilder_;
            if (singleFieldBuilder7 != null) {
                singleFieldBuilder7.dispose();
                this.testDummyBuilder_ = null;
            }
            this.theme_ = null;
            SingleFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> singleFieldBuilder8 = this.themeBuilder_;
            if (singleFieldBuilder8 != null) {
                singleFieldBuilder8.dispose();
                this.themeBuilder_ = null;
            }
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_Search_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Search getDefaultInstanceForType() {
            return Search.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Search build() {
            Search searchBuildPartial = buildPartial();
            if (searchBuildPartial.isInitialized()) {
                return searchBuildPartial;
            }
            throw newUninitializedMessageException((Message) searchBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Search buildPartial() {
            Search search = new Search(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(search);
            }
            onBuilt();
            return search;
        }

        private void buildPartial0(Search search) {
            int i;
            Theme theme;
            TestDummy testDummy;
            Timestamp timestamp;
            Platform platform;
            Game game;
            Company company;
            Collection collection;
            Character character;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                search.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                search.alternativeName_ = this.alternativeName_;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<Character, Character.Builder, CharacterOrBuilder> singleFieldBuilder = this.characterBuilder_;
                if (singleFieldBuilder == null) {
                    character = this.character_;
                } else {
                    character = (Character) singleFieldBuilder.build();
                }
                search.character_ = character;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder2 = this.collectionBuilder_;
                if (singleFieldBuilder2 == null) {
                    collection = this.collection_;
                } else {
                    collection = (Collection) singleFieldBuilder2.build();
                }
                search.collection_ = collection;
                i |= 2;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder3 = this.companyBuilder_;
                if (singleFieldBuilder3 == null) {
                    company = this.company_;
                } else {
                    company = (Company) singleFieldBuilder3.build();
                }
                search.company_ = company;
                i |= 4;
            }
            if ((i2 & 32) != 0) {
                search.description_ = this.description_;
            }
            if ((i2 & 64) != 0) {
                SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder4 = this.gameBuilder_;
                if (singleFieldBuilder4 == null) {
                    game = this.game_;
                } else {
                    game = (Game) singleFieldBuilder4.build();
                }
                search.game_ = game;
                i |= 8;
            }
            if ((i2 & 128) != 0) {
                search.name_ = this.name_;
            }
            if ((i2 & 256) != 0) {
                SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder5 = this.platformBuilder_;
                if (singleFieldBuilder5 == null) {
                    platform = this.platform_;
                } else {
                    platform = (Platform) singleFieldBuilder5.build();
                }
                search.platform_ = platform;
                i |= 16;
            }
            if ((i2 & 512) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder6 = this.publishedAtBuilder_;
                if (singleFieldBuilder6 == null) {
                    timestamp = this.publishedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder6.build();
                }
                search.publishedAt_ = timestamp;
                i |= 32;
            }
            if ((i2 & 1024) != 0) {
                SingleFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> singleFieldBuilder7 = this.testDummyBuilder_;
                if (singleFieldBuilder7 == null) {
                    testDummy = this.testDummy_;
                } else {
                    testDummy = (TestDummy) singleFieldBuilder7.build();
                }
                search.testDummy_ = testDummy;
                i |= 64;
            }
            if ((i2 & 2048) != 0) {
                SingleFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> singleFieldBuilder8 = this.themeBuilder_;
                if (singleFieldBuilder8 == null) {
                    theme = this.theme_;
                } else {
                    theme = (Theme) singleFieldBuilder8.build();
                }
                search.theme_ = theme;
                i |= 128;
            }
            if ((i2 & 4096) != 0) {
                search.checksum_ = this.checksum_;
            }
            search.bitField0_ |= i;
        }

        @Override // proto.SearchOrBuilder
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

        @Override // proto.SearchOrBuilder
        public String getAlternativeName() {
            Object obj = this.alternativeName_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.alternativeName_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.SearchOrBuilder
        public ByteString getAlternativeNameBytes() {
            Object obj = this.alternativeName_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.alternativeName_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setAlternativeName(String str) {
            str.getClass();
            this.alternativeName_ = str;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder clearAlternativeName() {
            this.alternativeName_ = Search.getDefaultInstance().getAlternativeName();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder setAlternativeNameBytes(ByteString byteString) {
            byteString.getClass();
            Search.checkByteStringIsUtf8(byteString);
            this.alternativeName_ = byteString;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.SearchOrBuilder
        public boolean hasCharacter() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // proto.SearchOrBuilder
        public Character getCharacter() {
            SingleFieldBuilder<Character, Character.Builder, CharacterOrBuilder> singleFieldBuilder = this.characterBuilder_;
            if (singleFieldBuilder == null) {
                Character character = this.character_;
                return character == null ? Character.getDefaultInstance() : character;
            }
            return (Character) singleFieldBuilder.getMessage();
        }

        public Builder setCharacter(Character character) {
            SingleFieldBuilder<Character, Character.Builder, CharacterOrBuilder> singleFieldBuilder = this.characterBuilder_;
            if (singleFieldBuilder == null) {
                character.getClass();
                this.character_ = character;
            } else {
                singleFieldBuilder.setMessage(character);
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setCharacter(Character.Builder builder) {
            SingleFieldBuilder<Character, Character.Builder, CharacterOrBuilder> singleFieldBuilder = this.characterBuilder_;
            if (singleFieldBuilder == null) {
                this.character_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder mergeCharacter(Character character) {
            Character character2;
            SingleFieldBuilder<Character, Character.Builder, CharacterOrBuilder> singleFieldBuilder = this.characterBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0 && (character2 = this.character_) != null && character2 != Character.getDefaultInstance()) {
                    getCharacterBuilder().mergeFrom((Message) character);
                } else {
                    this.character_ = character;
                }
            } else {
                singleFieldBuilder.mergeFrom(character);
            }
            if (this.character_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder clearCharacter() {
            this.bitField0_ &= -5;
            this.character_ = null;
            SingleFieldBuilder<Character, Character.Builder, CharacterOrBuilder> singleFieldBuilder = this.characterBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.characterBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Character.Builder getCharacterBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (Character.Builder) getCharacterFieldBuilder().getBuilder();
        }

        @Override // proto.SearchOrBuilder
        public CharacterOrBuilder getCharacterOrBuilder() {
            SingleFieldBuilder<Character, Character.Builder, CharacterOrBuilder> singleFieldBuilder = this.characterBuilder_;
            if (singleFieldBuilder != null) {
                return (CharacterOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Character character = this.character_;
            return character == null ? Character.getDefaultInstance() : character;
        }

        private SingleFieldBuilder<Character, Character.Builder, CharacterOrBuilder> getCharacterFieldBuilder() {
            if (this.characterBuilder_ == null) {
                this.characterBuilder_ = new SingleFieldBuilder<>(getCharacter(), getParentForChildren(), isClean());
                this.character_ = null;
            }
            return this.characterBuilder_;
        }

        @Override // proto.SearchOrBuilder
        public boolean hasCollection() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // proto.SearchOrBuilder
        public Collection getCollection() {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder == null) {
                Collection collection = this.collection_;
                return collection == null ? Collection.getDefaultInstance() : collection;
            }
            return (Collection) singleFieldBuilder.getMessage();
        }

        public Builder setCollection(Collection collection) {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder == null) {
                collection.getClass();
                this.collection_ = collection;
            } else {
                singleFieldBuilder.setMessage(collection);
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setCollection(Collection.Builder builder) {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder == null) {
                this.collection_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder mergeCollection(Collection collection) {
            Collection collection2;
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 8) != 0 && (collection2 = this.collection_) != null && collection2 != Collection.getDefaultInstance()) {
                    getCollectionBuilder().mergeFrom((Message) collection);
                } else {
                    this.collection_ = collection;
                }
            } else {
                singleFieldBuilder.mergeFrom(collection);
            }
            if (this.collection_ != null) {
                this.bitField0_ |= 8;
                onChanged();
            }
            return this;
        }

        public Builder clearCollection() {
            this.bitField0_ &= -9;
            this.collection_ = null;
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.collectionBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Collection.Builder getCollectionBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (Collection.Builder) getCollectionFieldBuilder().getBuilder();
        }

        @Override // proto.SearchOrBuilder
        public CollectionOrBuilder getCollectionOrBuilder() {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder != null) {
                return (CollectionOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Collection collection = this.collection_;
            return collection == null ? Collection.getDefaultInstance() : collection;
        }

        private SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> getCollectionFieldBuilder() {
            if (this.collectionBuilder_ == null) {
                this.collectionBuilder_ = new SingleFieldBuilder<>(getCollection(), getParentForChildren(), isClean());
                this.collection_ = null;
            }
            return this.collectionBuilder_;
        }

        @Override // proto.SearchOrBuilder
        public boolean hasCompany() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // proto.SearchOrBuilder
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
            this.bitField0_ |= 16;
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
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder mergeCompany(Company company) {
            Company company2;
            SingleFieldBuilder<Company, Company.Builder, CompanyOrBuilder> singleFieldBuilder = this.companyBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 16) != 0 && (company2 = this.company_) != null && company2 != Company.getDefaultInstance()) {
                    getCompanyBuilder().mergeFrom((Message) company);
                } else {
                    this.company_ = company;
                }
            } else {
                singleFieldBuilder.mergeFrom(company);
            }
            if (this.company_ != null) {
                this.bitField0_ |= 16;
                onChanged();
            }
            return this;
        }

        public Builder clearCompany() {
            this.bitField0_ &= -17;
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
            this.bitField0_ |= 16;
            onChanged();
            return (Company.Builder) getCompanyFieldBuilder().getBuilder();
        }

        @Override // proto.SearchOrBuilder
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

        @Override // proto.SearchOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.description_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.SearchOrBuilder
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
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearDescription() {
            this.description_ = Search.getDefaultInstance().getDescription();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            byteString.getClass();
            Search.checkByteStringIsUtf8(byteString);
            this.description_ = byteString;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        @Override // proto.SearchOrBuilder
        public boolean hasGame() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // proto.SearchOrBuilder
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
            this.bitField0_ |= 64;
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
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder mergeGame(Game game) {
            Game game2;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 64) != 0 && (game2 = this.game_) != null && game2 != Game.getDefaultInstance()) {
                    getGameBuilder().mergeFrom((Message) game);
                } else {
                    this.game_ = game;
                }
            } else {
                singleFieldBuilder.mergeFrom(game);
            }
            if (this.game_ != null) {
                this.bitField0_ |= 64;
                onChanged();
            }
            return this;
        }

        public Builder clearGame() {
            this.bitField0_ &= -65;
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
            this.bitField0_ |= 64;
            onChanged();
            return (Game.Builder) getGameFieldBuilder().getBuilder();
        }

        @Override // proto.SearchOrBuilder
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

        @Override // proto.SearchOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.SearchOrBuilder
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
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Search.getDefaultInstance().getName();
            this.bitField0_ &= -129;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            Search.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        @Override // proto.SearchOrBuilder
        public boolean hasPlatform() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // proto.SearchOrBuilder
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
            this.bitField0_ |= 256;
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
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder mergePlatform(Platform platform) {
            Platform platform2;
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder = this.platformBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 256) != 0 && (platform2 = this.platform_) != null && platform2 != Platform.getDefaultInstance()) {
                    getPlatformBuilder().mergeFrom((Message) platform);
                } else {
                    this.platform_ = platform;
                }
            } else {
                singleFieldBuilder.mergeFrom(platform);
            }
            if (this.platform_ != null) {
                this.bitField0_ |= 256;
                onChanged();
            }
            return this;
        }

        public Builder clearPlatform() {
            this.bitField0_ &= -257;
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
            this.bitField0_ |= 256;
            onChanged();
            return (Platform.Builder) getPlatformFieldBuilder().getBuilder();
        }

        @Override // proto.SearchOrBuilder
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

        @Override // proto.SearchOrBuilder
        public boolean hasPublishedAt() {
            return (this.bitField0_ & 512) != 0;
        }

        @Override // proto.SearchOrBuilder
        public Timestamp getPublishedAt() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.publishedAtBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.publishedAt_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setPublishedAt(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.publishedAtBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.publishedAt_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setPublishedAt(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.publishedAtBuilder_;
            if (singleFieldBuilder == null) {
                this.publishedAt_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder mergePublishedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.publishedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 512) != 0 && (timestamp2 = this.publishedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getPublishedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.publishedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.publishedAt_ != null) {
                this.bitField0_ |= 512;
                onChanged();
            }
            return this;
        }

        public Builder clearPublishedAt() {
            this.bitField0_ &= -513;
            this.publishedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.publishedAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.publishedAtBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getPublishedAtBuilder() {
            this.bitField0_ |= 512;
            onChanged();
            return (Timestamp.Builder) getPublishedAtFieldBuilder().getBuilder();
        }

        @Override // proto.SearchOrBuilder
        public TimestampOrBuilder getPublishedAtOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.publishedAtBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.publishedAt_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getPublishedAtFieldBuilder() {
            if (this.publishedAtBuilder_ == null) {
                this.publishedAtBuilder_ = new SingleFieldBuilder<>(getPublishedAt(), getParentForChildren(), isClean());
                this.publishedAt_ = null;
            }
            return this.publishedAtBuilder_;
        }

        @Override // proto.SearchOrBuilder
        public boolean hasTestDummy() {
            return (this.bitField0_ & 1024) != 0;
        }

        @Override // proto.SearchOrBuilder
        public TestDummy getTestDummy() {
            SingleFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> singleFieldBuilder = this.testDummyBuilder_;
            if (singleFieldBuilder == null) {
                TestDummy testDummy = this.testDummy_;
                return testDummy == null ? TestDummy.getDefaultInstance() : testDummy;
            }
            return (TestDummy) singleFieldBuilder.getMessage();
        }

        public Builder setTestDummy(TestDummy testDummy) {
            SingleFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> singleFieldBuilder = this.testDummyBuilder_;
            if (singleFieldBuilder == null) {
                testDummy.getClass();
                this.testDummy_ = testDummy;
            } else {
                singleFieldBuilder.setMessage(testDummy);
            }
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setTestDummy(TestDummy.Builder builder) {
            SingleFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> singleFieldBuilder = this.testDummyBuilder_;
            if (singleFieldBuilder == null) {
                this.testDummy_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder mergeTestDummy(TestDummy testDummy) {
            TestDummy testDummy2;
            SingleFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> singleFieldBuilder = this.testDummyBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 1024) != 0 && (testDummy2 = this.testDummy_) != null && testDummy2 != TestDummy.getDefaultInstance()) {
                    getTestDummyBuilder().mergeFrom((Message) testDummy);
                } else {
                    this.testDummy_ = testDummy;
                }
            } else {
                singleFieldBuilder.mergeFrom(testDummy);
            }
            if (this.testDummy_ != null) {
                this.bitField0_ |= 1024;
                onChanged();
            }
            return this;
        }

        public Builder clearTestDummy() {
            this.bitField0_ &= -1025;
            this.testDummy_ = null;
            SingleFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> singleFieldBuilder = this.testDummyBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.testDummyBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public TestDummy.Builder getTestDummyBuilder() {
            this.bitField0_ |= 1024;
            onChanged();
            return (TestDummy.Builder) getTestDummyFieldBuilder().getBuilder();
        }

        @Override // proto.SearchOrBuilder
        public TestDummyOrBuilder getTestDummyOrBuilder() {
            SingleFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> singleFieldBuilder = this.testDummyBuilder_;
            if (singleFieldBuilder != null) {
                return (TestDummyOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            TestDummy testDummy = this.testDummy_;
            return testDummy == null ? TestDummy.getDefaultInstance() : testDummy;
        }

        private SingleFieldBuilder<TestDummy, TestDummy.Builder, TestDummyOrBuilder> getTestDummyFieldBuilder() {
            if (this.testDummyBuilder_ == null) {
                this.testDummyBuilder_ = new SingleFieldBuilder<>(getTestDummy(), getParentForChildren(), isClean());
                this.testDummy_ = null;
            }
            return this.testDummyBuilder_;
        }

        @Override // proto.SearchOrBuilder
        public boolean hasTheme() {
            return (this.bitField0_ & 2048) != 0;
        }

        @Override // proto.SearchOrBuilder
        public Theme getTheme() {
            SingleFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> singleFieldBuilder = this.themeBuilder_;
            if (singleFieldBuilder == null) {
                Theme theme = this.theme_;
                return theme == null ? Theme.getDefaultInstance() : theme;
            }
            return (Theme) singleFieldBuilder.getMessage();
        }

        public Builder setTheme(Theme theme) {
            SingleFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> singleFieldBuilder = this.themeBuilder_;
            if (singleFieldBuilder == null) {
                theme.getClass();
                this.theme_ = theme;
            } else {
                singleFieldBuilder.setMessage(theme);
            }
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder setTheme(Theme.Builder builder) {
            SingleFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> singleFieldBuilder = this.themeBuilder_;
            if (singleFieldBuilder == null) {
                this.theme_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder mergeTheme(Theme theme) {
            Theme theme2;
            SingleFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> singleFieldBuilder = this.themeBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 2048) != 0 && (theme2 = this.theme_) != null && theme2 != Theme.getDefaultInstance()) {
                    getThemeBuilder().mergeFrom((Message) theme);
                } else {
                    this.theme_ = theme;
                }
            } else {
                singleFieldBuilder.mergeFrom(theme);
            }
            if (this.theme_ != null) {
                this.bitField0_ |= 2048;
                onChanged();
            }
            return this;
        }

        public Builder clearTheme() {
            this.bitField0_ &= -2049;
            this.theme_ = null;
            SingleFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> singleFieldBuilder = this.themeBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.themeBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Theme.Builder getThemeBuilder() {
            this.bitField0_ |= 2048;
            onChanged();
            return (Theme.Builder) getThemeFieldBuilder().getBuilder();
        }

        @Override // proto.SearchOrBuilder
        public ThemeOrBuilder getThemeOrBuilder() {
            SingleFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> singleFieldBuilder = this.themeBuilder_;
            if (singleFieldBuilder != null) {
                return (ThemeOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Theme theme = this.theme_;
            return theme == null ? Theme.getDefaultInstance() : theme;
        }

        private SingleFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> getThemeFieldBuilder() {
            if (this.themeBuilder_ == null) {
                this.themeBuilder_ = new SingleFieldBuilder<>(getTheme(), getParentForChildren(), isClean());
                this.theme_ = null;
            }
            return this.themeBuilder_;
        }

        @Override // proto.SearchOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.SearchOrBuilder
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
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = Search.getDefaultInstance().getChecksum();
            this.bitField0_ &= -4097;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            Search.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }
    }

    public static Search getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.Search$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Search> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public Search parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Search.newBuilder();
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

    public static Parser<Search> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Search> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Search getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
