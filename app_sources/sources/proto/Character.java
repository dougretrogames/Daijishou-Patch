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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
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

/* INFO: loaded from: classes6.dex */
public final class Character extends GeneratedMessage implements CharacterOrBuilder {
    public static final int AKAS_FIELD_NUMBER = 2;
    public static final int CHECKSUM_FIELD_NUMBER = 14;
    public static final int COUNTRY_NAME_FIELD_NUMBER = 3;
    public static final int CREATED_AT_FIELD_NUMBER = 4;
    private static final Character DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 5;
    public static final int GAMES_FIELD_NUMBER = 6;
    public static final int GENDER_FIELD_NUMBER = 7;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int MUG_SHOT_FIELD_NUMBER = 8;
    public static final int NAME_FIELD_NUMBER = 9;
    private static final Parser<Character> PARSER;
    public static final int SLUG_FIELD_NUMBER = 10;
    public static final int SPECIES_FIELD_NUMBER = 11;
    public static final int UPDATED_AT_FIELD_NUMBER = 12;
    public static final int URL_FIELD_NUMBER = 13;
    private static final long serialVersionUID = 0;
    private LazyStringArrayList akas_;
    private int bitField0_;
    private volatile Object checksum_;
    private volatile Object countryName_;
    private Timestamp createdAt_;
    private volatile Object description_;
    private List<Game> games_;
    private int gender_;
    private long id_;
    private CharacterMugShot mugShot_;
    private volatile Object name_;
    private volatile Object slug_;
    private int species_;
    private Timestamp updatedAt_;
    private volatile Object url_;

    /* synthetic */ Character(GeneratedMessage.Builder builder, CharacterIA characterIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Character.class.getName());
        DEFAULT_INSTANCE = new Character();
        PARSER = new AnonymousClass1();
    }

    private Character(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.akas_ = LazyStringArrayList.emptyList();
        this.countryName_ = "";
        this.description_ = "";
        this.gender_ = 0;
        this.name_ = "";
        this.slug_ = "";
        this.species_ = 0;
        this.url_ = "";
        this.checksum_ = "";
    }

    private Character() {
        this.id_ = 0L;
        this.akas_ = LazyStringArrayList.emptyList();
        this.countryName_ = "";
        this.description_ = "";
        this.gender_ = 0;
        this.name_ = "";
        this.slug_ = "";
        this.species_ = 0;
        this.url_ = "";
        this.checksum_ = "";
        this.akas_ = LazyStringArrayList.emptyList();
        this.countryName_ = "";
        this.description_ = "";
        this.games_ = Collections.emptyList();
        this.gender_ = 0;
        this.name_ = "";
        this.slug_ = "";
        this.species_ = 0;
        this.url_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_Character_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_Character_fieldAccessorTable.ensureFieldAccessorsInitialized(Character.class, Builder.class);
    }

    @Override // proto.CharacterOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.CharacterOrBuilder
    public ProtocolStringList getAkasList() {
        return this.akas_;
    }

    @Override // proto.CharacterOrBuilder
    public int getAkasCount() {
        return this.akas_.size();
    }

    @Override // proto.CharacterOrBuilder
    public String getAkas(int i) {
        return this.akas_.get(i);
    }

    @Override // proto.CharacterOrBuilder
    public ByteString getAkasBytes(int i) {
        return this.akas_.getByteString(i);
    }

    @Override // proto.CharacterOrBuilder
    public String getCountryName() {
        Object obj = this.countryName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.countryName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CharacterOrBuilder
    public ByteString getCountryNameBytes() {
        Object obj = this.countryName_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.countryName_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CharacterOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.CharacterOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CharacterOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CharacterOrBuilder
    public String getDescription() {
        Object obj = this.description_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.description_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CharacterOrBuilder
    public ByteString getDescriptionBytes() {
        Object obj = this.description_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.description_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CharacterOrBuilder
    public List<Game> getGamesList() {
        return this.games_;
    }

    @Override // proto.CharacterOrBuilder
    public List<? extends GameOrBuilder> getGamesOrBuilderList() {
        return this.games_;
    }

    @Override // proto.CharacterOrBuilder
    public int getGamesCount() {
        return this.games_.size();
    }

    @Override // proto.CharacterOrBuilder
    public Game getGames(int i) {
        return this.games_.get(i);
    }

    @Override // proto.CharacterOrBuilder
    public GameOrBuilder getGamesOrBuilder(int i) {
        return this.games_.get(i);
    }

    @Override // proto.CharacterOrBuilder
    public int getGenderValue() {
        return this.gender_;
    }

    @Override // proto.CharacterOrBuilder
    public GenderGenderEnum getGender() {
        GenderGenderEnum genderGenderEnumForNumber = GenderGenderEnum.forNumber(this.gender_);
        return genderGenderEnumForNumber == null ? GenderGenderEnum.UNRECOGNIZED : genderGenderEnumForNumber;
    }

    @Override // proto.CharacterOrBuilder
    public boolean hasMugShot() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.CharacterOrBuilder
    public CharacterMugShot getMugShot() {
        CharacterMugShot characterMugShot = this.mugShot_;
        return characterMugShot == null ? CharacterMugShot.getDefaultInstance() : characterMugShot;
    }

    @Override // proto.CharacterOrBuilder
    public CharacterMugShotOrBuilder getMugShotOrBuilder() {
        CharacterMugShot characterMugShot = this.mugShot_;
        return characterMugShot == null ? CharacterMugShot.getDefaultInstance() : characterMugShot;
    }

    @Override // proto.CharacterOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CharacterOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CharacterOrBuilder
    public String getSlug() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.slug_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CharacterOrBuilder
    public ByteString getSlugBytes() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.slug_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CharacterOrBuilder
    public int getSpeciesValue() {
        return this.species_;
    }

    @Override // proto.CharacterOrBuilder
    public CharacterSpeciesEnum getSpecies() {
        CharacterSpeciesEnum characterSpeciesEnumForNumber = CharacterSpeciesEnum.forNumber(this.species_);
        return characterSpeciesEnumForNumber == null ? CharacterSpeciesEnum.UNRECOGNIZED : characterSpeciesEnumForNumber;
    }

    @Override // proto.CharacterOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.CharacterOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CharacterOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.CharacterOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CharacterOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.CharacterOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.CharacterOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static Character parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Character parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Character parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Character parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Character parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Character parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Character parseFrom(InputStream inputStream) throws IOException {
        return (Character) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Character parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Character) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Character parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Character) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Character parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Character) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Character parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Character) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Character parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Character) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(Character character) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) character);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CharacterIA) null) : (Builder) new Builder((CharacterIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CharacterOrBuilder {
        private LazyStringArrayList akas_;
        private int bitField0_;
        private Object checksum_;
        private Object countryName_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private Object description_;
        private RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> gamesBuilder_;
        private List<Game> games_;
        private int gender_;
        private long id_;
        private SingleFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> mugShotBuilder_;
        private CharacterMugShot mugShot_;
        private Object name_;
        private Object slug_;
        private int species_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;
        private Object url_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CharacterIA characterIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CharacterIA characterIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_Character_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_Character_fieldAccessorTable.ensureFieldAccessorsInitialized(Character.class, Builder.class);
        }

        private Builder() {
            this.akas_ = LazyStringArrayList.emptyList();
            this.countryName_ = "";
            this.description_ = "";
            this.games_ = Collections.emptyList();
            this.gender_ = 0;
            this.name_ = "";
            this.slug_ = "";
            this.species_ = 0;
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.akas_ = LazyStringArrayList.emptyList();
            this.countryName_ = "";
            this.description_ = "";
            this.games_ = Collections.emptyList();
            this.gender_ = 0;
            this.name_ = "";
            this.slug_ = "";
            this.species_ = 0;
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (Character.alwaysUseFieldBuilders) {
                getCreatedAtFieldBuilder();
                getGamesFieldBuilder();
                getMugShotFieldBuilder();
                getUpdatedAtFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.akas_ = LazyStringArrayList.emptyList();
            this.countryName_ = "";
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.createdAtBuilder_ = null;
            }
            this.description_ = "";
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.games_ = Collections.emptyList();
            } else {
                this.games_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -33;
            this.gender_ = 0;
            this.mugShot_ = null;
            SingleFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> singleFieldBuilder2 = this.mugShotBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.mugShotBuilder_ = null;
            }
            this.name_ = "";
            this.slug_ = "";
            this.species_ = 0;
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
            return Igdbproto.internal_static_proto_Character_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Character getDefaultInstanceForType() {
            return Character.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Character build() {
            Character characterBuildPartial = buildPartial();
            if (characterBuildPartial.isInitialized()) {
                return characterBuildPartial;
            }
            throw newUninitializedMessageException((Message) characterBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Character buildPartial() {
            Character character = new Character(this, null);
            buildPartialRepeatedFields(character);
            if (this.bitField0_ != 0) {
                buildPartial0(character);
            }
            onBuilt();
            return character;
        }

        private void buildPartialRepeatedFields(Character character) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 32) != 0) {
                    this.games_ = Collections.unmodifiableList(this.games_);
                    this.bitField0_ &= -33;
                }
                character.games_ = this.games_;
                return;
            }
            character.games_ = repeatedFieldBuilder.build();
        }

        private void buildPartial0(Character character) {
            int i;
            Timestamp timestamp;
            CharacterMugShot characterMugShot;
            Timestamp timestamp2;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                character.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                this.akas_.makeImmutable();
                character.akas_ = this.akas_;
            }
            if ((i2 & 4) != 0) {
                character.countryName_ = this.countryName_;
            }
            if ((i2 & 8) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
                if (singleFieldBuilder == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder.build();
                }
                character.createdAt_ = timestamp2;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 16) != 0) {
                character.description_ = this.description_;
            }
            if ((i2 & 64) != 0) {
                character.gender_ = this.gender_;
            }
            if ((i2 & 128) != 0) {
                SingleFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> singleFieldBuilder2 = this.mugShotBuilder_;
                if (singleFieldBuilder2 == null) {
                    characterMugShot = this.mugShot_;
                } else {
                    characterMugShot = (CharacterMugShot) singleFieldBuilder2.build();
                }
                character.mugShot_ = characterMugShot;
                i |= 2;
            }
            if ((i2 & 256) != 0) {
                character.name_ = this.name_;
            }
            if ((i2 & 512) != 0) {
                character.slug_ = this.slug_;
            }
            if ((i2 & 1024) != 0) {
                character.species_ = this.species_;
            }
            if ((i2 & 2048) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.updatedAtBuilder_;
                if (singleFieldBuilder3 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder3.build();
                }
                character.updatedAt_ = timestamp;
                i |= 4;
            }
            if ((i2 & 4096) != 0) {
                character.url_ = this.url_;
            }
            if ((i2 & 8192) != 0) {
                character.checksum_ = this.checksum_;
            }
            character.bitField0_ |= i;
        }

        @Override // proto.CharacterOrBuilder
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

        private void ensureAkasIsMutable() {
            if (!this.akas_.isModifiable()) {
                this.akas_ = new LazyStringArrayList((LazyStringList) this.akas_);
            }
            this.bitField0_ |= 2;
        }

        @Override // proto.CharacterOrBuilder
        public ProtocolStringList getAkasList() {
            this.akas_.makeImmutable();
            return this.akas_;
        }

        @Override // proto.CharacterOrBuilder
        public int getAkasCount() {
            return this.akas_.size();
        }

        @Override // proto.CharacterOrBuilder
        public String getAkas(int i) {
            return this.akas_.get(i);
        }

        @Override // proto.CharacterOrBuilder
        public ByteString getAkasBytes(int i) {
            return this.akas_.getByteString(i);
        }

        public Builder setAkas(int i, String str) {
            str.getClass();
            ensureAkasIsMutable();
            this.akas_.set(i, str);
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder addAkas(String str) {
            str.getClass();
            ensureAkasIsMutable();
            this.akas_.add(str);
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder addAllAkas(Iterable<String> iterable) {
            ensureAkasIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.akas_);
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder clearAkas() {
            this.akas_ = LazyStringArrayList.emptyList();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder addAkasBytes(ByteString byteString) {
            byteString.getClass();
            Character.checkByteStringIsUtf8(byteString);
            ensureAkasIsMutable();
            this.akas_.add(byteString);
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.CharacterOrBuilder
        public String getCountryName() {
            Object obj = this.countryName_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.countryName_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CharacterOrBuilder
        public ByteString getCountryNameBytes() {
            Object obj = this.countryName_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.countryName_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setCountryName(String str) {
            str.getClass();
            this.countryName_ = str;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearCountryName() {
            this.countryName_ = Character.getDefaultInstance().getCountryName();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder setCountryNameBytes(ByteString byteString) {
            byteString.getClass();
            Character.checkByteStringIsUtf8(byteString);
            this.countryName_ = byteString;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // proto.CharacterOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // proto.CharacterOrBuilder
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
            this.bitField0_ |= 8;
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
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder mergeCreatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 8) != 0 && (timestamp2 = this.createdAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getCreatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.createdAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.createdAt_ != null) {
                this.bitField0_ |= 8;
                onChanged();
            }
            return this;
        }

        public Builder clearCreatedAt() {
            this.bitField0_ &= -9;
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
            this.bitField0_ |= 8;
            onChanged();
            return (Timestamp.Builder) getCreatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.CharacterOrBuilder
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

        @Override // proto.CharacterOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.description_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CharacterOrBuilder
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
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearDescription() {
            this.description_ = Character.getDefaultInstance().getDescription();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            byteString.getClass();
            Character.checkByteStringIsUtf8(byteString);
            this.description_ = byteString;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        private void ensureGamesIsMutable() {
            if ((this.bitField0_ & 32) == 0) {
                this.games_ = new ArrayList(this.games_);
                this.bitField0_ |= 32;
            }
        }

        @Override // proto.CharacterOrBuilder
        public List<Game> getGamesList() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.games_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.CharacterOrBuilder
        public int getGamesCount() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.games_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.CharacterOrBuilder
        public Game getGames(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.games_.get(i);
            }
            return (Game) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setGames(int i, Game game) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureGamesIsMutable();
                this.games_.set(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, game);
            return this;
        }

        public Builder setGames(int i, Game.Builder builder) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamesIsMutable();
                this.games_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addGames(Game game) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureGamesIsMutable();
                this.games_.add(game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(game);
            return this;
        }

        public Builder addGames(int i, Game game) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureGamesIsMutable();
                this.games_.add(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, game);
            return this;
        }

        public Builder addGames(Game.Builder builder) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamesIsMutable();
                this.games_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addGames(int i, Game.Builder builder) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamesIsMutable();
                this.games_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllGames(Iterable<? extends Game> iterable) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.games_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearGames() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.games_ = Collections.emptyList();
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeGames(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGamesIsMutable();
                this.games_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Game.Builder getGamesBuilder(int i) {
            return (Game.Builder) getGamesFieldBuilder().getBuilder(i);
        }

        @Override // proto.CharacterOrBuilder
        public GameOrBuilder getGamesOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.games_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.CharacterOrBuilder
        public List<? extends GameOrBuilder> getGamesOrBuilderList() {
            RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> repeatedFieldBuilder = this.gamesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.games_);
        }

        public Game.Builder addGamesBuilder() {
            return (Game.Builder) getGamesFieldBuilder().addBuilder(Game.getDefaultInstance());
        }

        public Game.Builder addGamesBuilder(int i) {
            return (Game.Builder) getGamesFieldBuilder().addBuilder(i, Game.getDefaultInstance());
        }

        public List<Game.Builder> getGamesBuilderList() {
            return getGamesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Game, Game.Builder, GameOrBuilder> getGamesFieldBuilder() {
            if (this.gamesBuilder_ == null) {
                this.gamesBuilder_ = new RepeatedFieldBuilder<>(this.games_, (this.bitField0_ & 32) != 0, getParentForChildren(), isClean());
                this.games_ = null;
            }
            return this.gamesBuilder_;
        }

        @Override // proto.CharacterOrBuilder
        public int getGenderValue() {
            return this.gender_;
        }

        public Builder setGenderValue(int i) {
            this.gender_ = i;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        @Override // proto.CharacterOrBuilder
        public GenderGenderEnum getGender() {
            GenderGenderEnum genderGenderEnumForNumber = GenderGenderEnum.forNumber(this.gender_);
            return genderGenderEnumForNumber == null ? GenderGenderEnum.UNRECOGNIZED : genderGenderEnumForNumber;
        }

        public Builder setGender(GenderGenderEnum genderGenderEnum) {
            genderGenderEnum.getClass();
            this.bitField0_ |= 64;
            this.gender_ = genderGenderEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearGender() {
            this.bitField0_ &= -65;
            this.gender_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.CharacterOrBuilder
        public boolean hasMugShot() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // proto.CharacterOrBuilder
        public CharacterMugShot getMugShot() {
            SingleFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> singleFieldBuilder = this.mugShotBuilder_;
            if (singleFieldBuilder == null) {
                CharacterMugShot characterMugShot = this.mugShot_;
                return characterMugShot == null ? CharacterMugShot.getDefaultInstance() : characterMugShot;
            }
            return (CharacterMugShot) singleFieldBuilder.getMessage();
        }

        public Builder setMugShot(CharacterMugShot characterMugShot) {
            SingleFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> singleFieldBuilder = this.mugShotBuilder_;
            if (singleFieldBuilder == null) {
                characterMugShot.getClass();
                this.mugShot_ = characterMugShot;
            } else {
                singleFieldBuilder.setMessage(characterMugShot);
            }
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setMugShot(CharacterMugShot.Builder builder) {
            SingleFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> singleFieldBuilder = this.mugShotBuilder_;
            if (singleFieldBuilder == null) {
                this.mugShot_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder mergeMugShot(CharacterMugShot characterMugShot) {
            CharacterMugShot characterMugShot2;
            SingleFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> singleFieldBuilder = this.mugShotBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 128) != 0 && (characterMugShot2 = this.mugShot_) != null && characterMugShot2 != CharacterMugShot.getDefaultInstance()) {
                    getMugShotBuilder().mergeFrom((Message) characterMugShot);
                } else {
                    this.mugShot_ = characterMugShot;
                }
            } else {
                singleFieldBuilder.mergeFrom(characterMugShot);
            }
            if (this.mugShot_ != null) {
                this.bitField0_ |= 128;
                onChanged();
            }
            return this;
        }

        public Builder clearMugShot() {
            this.bitField0_ &= -129;
            this.mugShot_ = null;
            SingleFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> singleFieldBuilder = this.mugShotBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.mugShotBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public CharacterMugShot.Builder getMugShotBuilder() {
            this.bitField0_ |= 128;
            onChanged();
            return (CharacterMugShot.Builder) getMugShotFieldBuilder().getBuilder();
        }

        @Override // proto.CharacterOrBuilder
        public CharacterMugShotOrBuilder getMugShotOrBuilder() {
            SingleFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> singleFieldBuilder = this.mugShotBuilder_;
            if (singleFieldBuilder != null) {
                return (CharacterMugShotOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            CharacterMugShot characterMugShot = this.mugShot_;
            return characterMugShot == null ? CharacterMugShot.getDefaultInstance() : characterMugShot;
        }

        private SingleFieldBuilder<CharacterMugShot, CharacterMugShot.Builder, CharacterMugShotOrBuilder> getMugShotFieldBuilder() {
            if (this.mugShotBuilder_ == null) {
                this.mugShotBuilder_ = new SingleFieldBuilder<>(getMugShot(), getParentForChildren(), isClean());
                this.mugShot_ = null;
            }
            return this.mugShotBuilder_;
        }

        @Override // proto.CharacterOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CharacterOrBuilder
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
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Character.getDefaultInstance().getName();
            this.bitField0_ &= -257;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            Character.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        @Override // proto.CharacterOrBuilder
        public String getSlug() {
            Object obj = this.slug_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.slug_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CharacterOrBuilder
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
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder clearSlug() {
            this.slug_ = Character.getDefaultInstance().getSlug();
            this.bitField0_ &= -513;
            onChanged();
            return this;
        }

        public Builder setSlugBytes(ByteString byteString) {
            byteString.getClass();
            Character.checkByteStringIsUtf8(byteString);
            this.slug_ = byteString;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        @Override // proto.CharacterOrBuilder
        public int getSpeciesValue() {
            return this.species_;
        }

        public Builder setSpeciesValue(int i) {
            this.species_ = i;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        @Override // proto.CharacterOrBuilder
        public CharacterSpeciesEnum getSpecies() {
            CharacterSpeciesEnum characterSpeciesEnumForNumber = CharacterSpeciesEnum.forNumber(this.species_);
            return characterSpeciesEnumForNumber == null ? CharacterSpeciesEnum.UNRECOGNIZED : characterSpeciesEnumForNumber;
        }

        public Builder setSpecies(CharacterSpeciesEnum characterSpeciesEnum) {
            characterSpeciesEnum.getClass();
            this.bitField0_ |= 1024;
            this.species_ = characterSpeciesEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearSpecies() {
            this.bitField0_ &= -1025;
            this.species_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.CharacterOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 2048) != 0;
        }

        @Override // proto.CharacterOrBuilder
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
            this.bitField0_ |= 2048;
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
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder mergeUpdatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 2048) != 0 && (timestamp2 = this.updatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getUpdatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.updatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.updatedAt_ != null) {
                this.bitField0_ |= 2048;
                onChanged();
            }
            return this;
        }

        public Builder clearUpdatedAt() {
            this.bitField0_ &= -2049;
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
            this.bitField0_ |= 2048;
            onChanged();
            return (Timestamp.Builder) getUpdatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.CharacterOrBuilder
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

        @Override // proto.CharacterOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CharacterOrBuilder
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
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = Character.getDefaultInstance().getUrl();
            this.bitField0_ &= -4097;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            Character.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        @Override // proto.CharacterOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.CharacterOrBuilder
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
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = Character.getDefaultInstance().getChecksum();
            this.bitField0_ &= -8193;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            Character.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }
    }

    public static Character getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.Character$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Character> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public Character parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Character.newBuilder();
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

    public static Parser<Character> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Character> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Character getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
