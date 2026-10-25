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
public final class LanguageSupport extends GeneratedMessage implements LanguageSupportOrBuilder {
    public static final int CHECKSUM_FIELD_NUMBER = 7;
    public static final int CREATED_AT_FIELD_NUMBER = 5;
    private static final LanguageSupport DEFAULT_INSTANCE;
    public static final int GAME_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int LANGUAGE_FIELD_NUMBER = 3;
    public static final int LANGUAGE_SUPPORT_TYPE_FIELD_NUMBER = 4;
    private static final Parser<LanguageSupport> PARSER;
    public static final int UPDATED_AT_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object checksum_;
    private Timestamp createdAt_;
    private Game game_;
    private long id_;
    private LanguageSupportType languageSupportType_;
    private Language language_;
    private Timestamp updatedAt_;

    /* synthetic */ LanguageSupport(GeneratedMessage.Builder builder, LanguageSupportIA languageSupportIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", LanguageSupport.class.getName());
        DEFAULT_INSTANCE = new LanguageSupport();
        PARSER = new AnonymousClass1();
    }

    private LanguageSupport(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.checksum_ = "";
    }

    private LanguageSupport() {
        this.id_ = 0L;
        this.checksum_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_LanguageSupport_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_LanguageSupport_fieldAccessorTable.ensureFieldAccessorsInitialized(LanguageSupport.class, Builder.class);
    }

    @Override // proto.LanguageSupportOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.LanguageSupportOrBuilder
    public boolean hasGame() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.LanguageSupportOrBuilder
    public Game getGame() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.LanguageSupportOrBuilder
    public GameOrBuilder getGameOrBuilder() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.LanguageSupportOrBuilder
    public boolean hasLanguage() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.LanguageSupportOrBuilder
    public Language getLanguage() {
        Language language = this.language_;
        return language == null ? Language.getDefaultInstance() : language;
    }

    @Override // proto.LanguageSupportOrBuilder
    public LanguageOrBuilder getLanguageOrBuilder() {
        Language language = this.language_;
        return language == null ? Language.getDefaultInstance() : language;
    }

    @Override // proto.LanguageSupportOrBuilder
    public boolean hasLanguageSupportType() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.LanguageSupportOrBuilder
    public LanguageSupportType getLanguageSupportType() {
        LanguageSupportType languageSupportType = this.languageSupportType_;
        return languageSupportType == null ? LanguageSupportType.getDefaultInstance() : languageSupportType;
    }

    @Override // proto.LanguageSupportOrBuilder
    public LanguageSupportTypeOrBuilder getLanguageSupportTypeOrBuilder() {
        LanguageSupportType languageSupportType = this.languageSupportType_;
        return languageSupportType == null ? LanguageSupportType.getDefaultInstance() : languageSupportType;
    }

    @Override // proto.LanguageSupportOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // proto.LanguageSupportOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.LanguageSupportOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.LanguageSupportOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // proto.LanguageSupportOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.LanguageSupportOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.LanguageSupportOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.LanguageSupportOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static LanguageSupport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static LanguageSupport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LanguageSupport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static LanguageSupport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LanguageSupport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LanguageSupport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static LanguageSupport parseFrom(InputStream inputStream) throws IOException {
        return (LanguageSupport) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static LanguageSupport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LanguageSupport) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LanguageSupport parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LanguageSupport) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LanguageSupport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LanguageSupport) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LanguageSupport parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LanguageSupport) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static LanguageSupport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LanguageSupport) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(LanguageSupport languageSupport) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) languageSupport);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((LanguageSupportIA) null) : (Builder) new Builder((LanguageSupportIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements LanguageSupportOrBuilder {
        private int bitField0_;
        private Object checksum_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> gameBuilder_;
        private Game game_;
        private long id_;
        private SingleFieldBuilder<Language, Language.Builder, LanguageOrBuilder> languageBuilder_;
        private SingleFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> languageSupportTypeBuilder_;
        private LanguageSupportType languageSupportType_;
        private Language language_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, LanguageSupportIA languageSupportIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(LanguageSupportIA languageSupportIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_LanguageSupport_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_LanguageSupport_fieldAccessorTable.ensureFieldAccessorsInitialized(LanguageSupport.class, Builder.class);
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
            if (LanguageSupport.alwaysUseFieldBuilders) {
                getGameFieldBuilder();
                getLanguageFieldBuilder();
                getLanguageSupportTypeFieldBuilder();
                getCreatedAtFieldBuilder();
                getUpdatedAtFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.game_ = null;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.gameBuilder_ = null;
            }
            this.language_ = null;
            SingleFieldBuilder<Language, Language.Builder, LanguageOrBuilder> singleFieldBuilder2 = this.languageBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.languageBuilder_ = null;
            }
            this.languageSupportType_ = null;
            SingleFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> singleFieldBuilder3 = this.languageSupportTypeBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.languageSupportTypeBuilder_ = null;
            }
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.createdAtBuilder_;
            if (singleFieldBuilder4 != null) {
                singleFieldBuilder4.dispose();
                this.createdAtBuilder_ = null;
            }
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder5 = this.updatedAtBuilder_;
            if (singleFieldBuilder5 != null) {
                singleFieldBuilder5.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_LanguageSupport_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LanguageSupport getDefaultInstanceForType() {
            return LanguageSupport.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LanguageSupport build() {
            LanguageSupport languageSupportBuildPartial = buildPartial();
            if (languageSupportBuildPartial.isInitialized()) {
                return languageSupportBuildPartial;
            }
            throw newUninitializedMessageException((Message) languageSupportBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LanguageSupport buildPartial() {
            LanguageSupport languageSupport = new LanguageSupport(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(languageSupport);
            }
            onBuilt();
            return languageSupport;
        }

        private void buildPartial0(LanguageSupport languageSupport) {
            int i;
            Timestamp timestamp;
            Timestamp timestamp2;
            LanguageSupportType languageSupportType;
            Language language;
            Game game;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                languageSupport.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
                if (singleFieldBuilder == null) {
                    game = this.game_;
                } else {
                    game = (Game) singleFieldBuilder.build();
                }
                languageSupport.game_ = game;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<Language, Language.Builder, LanguageOrBuilder> singleFieldBuilder2 = this.languageBuilder_;
                if (singleFieldBuilder2 == null) {
                    language = this.language_;
                } else {
                    language = (Language) singleFieldBuilder2.build();
                }
                languageSupport.language_ = language;
                i |= 2;
            }
            if ((i2 & 8) != 0) {
                SingleFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> singleFieldBuilder3 = this.languageSupportTypeBuilder_;
                if (singleFieldBuilder3 == null) {
                    languageSupportType = this.languageSupportType_;
                } else {
                    languageSupportType = (LanguageSupportType) singleFieldBuilder3.build();
                }
                languageSupport.languageSupportType_ = languageSupportType;
                i |= 4;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.createdAtBuilder_;
                if (singleFieldBuilder4 == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder4.build();
                }
                languageSupport.createdAt_ = timestamp2;
                i |= 8;
            }
            if ((i2 & 32) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder5 = this.updatedAtBuilder_;
                if (singleFieldBuilder5 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder5.build();
                }
                languageSupport.updatedAt_ = timestamp;
                i |= 16;
            }
            if ((i2 & 64) != 0) {
                languageSupport.checksum_ = this.checksum_;
            }
            languageSupport.bitField0_ |= i;
        }

        @Override // proto.LanguageSupportOrBuilder
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

        @Override // proto.LanguageSupportOrBuilder
        public boolean hasGame() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // proto.LanguageSupportOrBuilder
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
            this.bitField0_ |= 2;
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
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder mergeGame(Game game) {
            Game game2;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 2) != 0 && (game2 = this.game_) != null && game2 != Game.getDefaultInstance()) {
                    getGameBuilder().mergeFrom((Message) game);
                } else {
                    this.game_ = game;
                }
            } else {
                singleFieldBuilder.mergeFrom(game);
            }
            if (this.game_ != null) {
                this.bitField0_ |= 2;
                onChanged();
            }
            return this;
        }

        public Builder clearGame() {
            this.bitField0_ &= -3;
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
            this.bitField0_ |= 2;
            onChanged();
            return (Game.Builder) getGameFieldBuilder().getBuilder();
        }

        @Override // proto.LanguageSupportOrBuilder
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

        @Override // proto.LanguageSupportOrBuilder
        public boolean hasLanguage() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // proto.LanguageSupportOrBuilder
        public Language getLanguage() {
            SingleFieldBuilder<Language, Language.Builder, LanguageOrBuilder> singleFieldBuilder = this.languageBuilder_;
            if (singleFieldBuilder == null) {
                Language language = this.language_;
                return language == null ? Language.getDefaultInstance() : language;
            }
            return (Language) singleFieldBuilder.getMessage();
        }

        public Builder setLanguage(Language language) {
            SingleFieldBuilder<Language, Language.Builder, LanguageOrBuilder> singleFieldBuilder = this.languageBuilder_;
            if (singleFieldBuilder == null) {
                language.getClass();
                this.language_ = language;
            } else {
                singleFieldBuilder.setMessage(language);
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setLanguage(Language.Builder builder) {
            SingleFieldBuilder<Language, Language.Builder, LanguageOrBuilder> singleFieldBuilder = this.languageBuilder_;
            if (singleFieldBuilder == null) {
                this.language_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder mergeLanguage(Language language) {
            Language language2;
            SingleFieldBuilder<Language, Language.Builder, LanguageOrBuilder> singleFieldBuilder = this.languageBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0 && (language2 = this.language_) != null && language2 != Language.getDefaultInstance()) {
                    getLanguageBuilder().mergeFrom((Message) language);
                } else {
                    this.language_ = language;
                }
            } else {
                singleFieldBuilder.mergeFrom(language);
            }
            if (this.language_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder clearLanguage() {
            this.bitField0_ &= -5;
            this.language_ = null;
            SingleFieldBuilder<Language, Language.Builder, LanguageOrBuilder> singleFieldBuilder = this.languageBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.languageBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Language.Builder getLanguageBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (Language.Builder) getLanguageFieldBuilder().getBuilder();
        }

        @Override // proto.LanguageSupportOrBuilder
        public LanguageOrBuilder getLanguageOrBuilder() {
            SingleFieldBuilder<Language, Language.Builder, LanguageOrBuilder> singleFieldBuilder = this.languageBuilder_;
            if (singleFieldBuilder != null) {
                return (LanguageOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Language language = this.language_;
            return language == null ? Language.getDefaultInstance() : language;
        }

        private SingleFieldBuilder<Language, Language.Builder, LanguageOrBuilder> getLanguageFieldBuilder() {
            if (this.languageBuilder_ == null) {
                this.languageBuilder_ = new SingleFieldBuilder<>(getLanguage(), getParentForChildren(), isClean());
                this.language_ = null;
            }
            return this.languageBuilder_;
        }

        @Override // proto.LanguageSupportOrBuilder
        public boolean hasLanguageSupportType() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // proto.LanguageSupportOrBuilder
        public LanguageSupportType getLanguageSupportType() {
            SingleFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> singleFieldBuilder = this.languageSupportTypeBuilder_;
            if (singleFieldBuilder == null) {
                LanguageSupportType languageSupportType = this.languageSupportType_;
                return languageSupportType == null ? LanguageSupportType.getDefaultInstance() : languageSupportType;
            }
            return (LanguageSupportType) singleFieldBuilder.getMessage();
        }

        public Builder setLanguageSupportType(LanguageSupportType languageSupportType) {
            SingleFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> singleFieldBuilder = this.languageSupportTypeBuilder_;
            if (singleFieldBuilder == null) {
                languageSupportType.getClass();
                this.languageSupportType_ = languageSupportType;
            } else {
                singleFieldBuilder.setMessage(languageSupportType);
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setLanguageSupportType(LanguageSupportType.Builder builder) {
            SingleFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> singleFieldBuilder = this.languageSupportTypeBuilder_;
            if (singleFieldBuilder == null) {
                this.languageSupportType_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder mergeLanguageSupportType(LanguageSupportType languageSupportType) {
            LanguageSupportType languageSupportType2;
            SingleFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> singleFieldBuilder = this.languageSupportTypeBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 8) != 0 && (languageSupportType2 = this.languageSupportType_) != null && languageSupportType2 != LanguageSupportType.getDefaultInstance()) {
                    getLanguageSupportTypeBuilder().mergeFrom((Message) languageSupportType);
                } else {
                    this.languageSupportType_ = languageSupportType;
                }
            } else {
                singleFieldBuilder.mergeFrom(languageSupportType);
            }
            if (this.languageSupportType_ != null) {
                this.bitField0_ |= 8;
                onChanged();
            }
            return this;
        }

        public Builder clearLanguageSupportType() {
            this.bitField0_ &= -9;
            this.languageSupportType_ = null;
            SingleFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> singleFieldBuilder = this.languageSupportTypeBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.languageSupportTypeBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public LanguageSupportType.Builder getLanguageSupportTypeBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (LanguageSupportType.Builder) getLanguageSupportTypeFieldBuilder().getBuilder();
        }

        @Override // proto.LanguageSupportOrBuilder
        public LanguageSupportTypeOrBuilder getLanguageSupportTypeOrBuilder() {
            SingleFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> singleFieldBuilder = this.languageSupportTypeBuilder_;
            if (singleFieldBuilder != null) {
                return (LanguageSupportTypeOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            LanguageSupportType languageSupportType = this.languageSupportType_;
            return languageSupportType == null ? LanguageSupportType.getDefaultInstance() : languageSupportType;
        }

        private SingleFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> getLanguageSupportTypeFieldBuilder() {
            if (this.languageSupportTypeBuilder_ == null) {
                this.languageSupportTypeBuilder_ = new SingleFieldBuilder<>(getLanguageSupportType(), getParentForChildren(), isClean());
                this.languageSupportType_ = null;
            }
            return this.languageSupportTypeBuilder_;
        }

        @Override // proto.LanguageSupportOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // proto.LanguageSupportOrBuilder
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

        @Override // proto.LanguageSupportOrBuilder
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

        @Override // proto.LanguageSupportOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // proto.LanguageSupportOrBuilder
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

        @Override // proto.LanguageSupportOrBuilder
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

        @Override // proto.LanguageSupportOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.LanguageSupportOrBuilder
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
            this.checksum_ = LanguageSupport.getDefaultInstance().getChecksum();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            LanguageSupport.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }
    }

    public static LanguageSupport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.LanguageSupport$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<LanguageSupport> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public LanguageSupport parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = LanguageSupport.newBuilder();
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

    public static Parser<LanguageSupport> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<LanguageSupport> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public LanguageSupport getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
