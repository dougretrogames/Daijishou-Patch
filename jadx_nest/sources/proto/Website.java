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
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public final class Website extends GeneratedMessage implements WebsiteOrBuilder {
    public static final int CATEGORY_FIELD_NUMBER = 2;
    public static final int CHECKSUM_FIELD_NUMBER = 6;
    private static final Website DEFAULT_INSTANCE;
    public static final int GAME_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    private static final Parser<Website> PARSER;
    public static final int TRUSTED_FIELD_NUMBER = 4;
    public static final int URL_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int category_;
    private volatile Object checksum_;
    private Game game_;
    private long id_;
    private boolean trusted_;
    private volatile Object url_;

    /* synthetic */ Website(GeneratedMessage.Builder builder, WebsiteIA websiteIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Website.class.getName());
        DEFAULT_INSTANCE = new Website();
        PARSER = new AnonymousClass1();
    }

    private Website(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.category_ = 0;
        this.trusted_ = false;
        this.url_ = "";
        this.checksum_ = "";
    }

    private Website() {
        this.id_ = 0L;
        this.category_ = 0;
        this.trusted_ = false;
        this.url_ = "";
        this.checksum_ = "";
        this.category_ = 0;
        this.url_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_Website_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_Website_fieldAccessorTable.ensureFieldAccessorsInitialized(Website.class, Builder.class);
    }

    @Override // proto.WebsiteOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.WebsiteOrBuilder
    public int getCategoryValue() {
        return this.category_;
    }

    @Override // proto.WebsiteOrBuilder
    public WebsiteCategoryEnum getCategory() {
        WebsiteCategoryEnum websiteCategoryEnumForNumber = WebsiteCategoryEnum.forNumber(this.category_);
        return websiteCategoryEnumForNumber == null ? WebsiteCategoryEnum.UNRECOGNIZED : websiteCategoryEnumForNumber;
    }

    @Override // proto.WebsiteOrBuilder
    public boolean hasGame() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.WebsiteOrBuilder
    public Game getGame() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.WebsiteOrBuilder
    public GameOrBuilder getGameOrBuilder() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.WebsiteOrBuilder
    public boolean getTrusted() {
        return this.trusted_;
    }

    @Override // proto.WebsiteOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.WebsiteOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.WebsiteOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.WebsiteOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static Website parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Website parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Website parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Website parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Website parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Website parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Website parseFrom(InputStream inputStream) throws IOException {
        return (Website) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Website parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Website) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Website parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Website) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Website parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Website) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Website parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Website) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Website parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Website) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(Website website) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) website);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((WebsiteIA) null) : (Builder) new Builder((WebsiteIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebsiteOrBuilder {
        private int bitField0_;
        private int category_;
        private Object checksum_;
        private SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> gameBuilder_;
        private Game game_;
        private long id_;
        private boolean trusted_;
        private Object url_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, WebsiteIA websiteIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(WebsiteIA websiteIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_Website_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_Website_fieldAccessorTable.ensureFieldAccessorsInitialized(Website.class, Builder.class);
        }

        private Builder() {
            this.category_ = 0;
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.category_ = 0;
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (Website.alwaysUseFieldBuilders) {
                getGameFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.category_ = 0;
            this.game_ = null;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.gameBuilder_ = null;
            }
            this.trusted_ = false;
            this.url_ = "";
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_Website_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Website getDefaultInstanceForType() {
            return Website.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Website build() {
            Website websiteBuildPartial = buildPartial();
            if (websiteBuildPartial.isInitialized()) {
                return websiteBuildPartial;
            }
            throw newUninitializedMessageException((Message) websiteBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Website buildPartial() {
            Website website = new Website(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(website);
            }
            onBuilt();
            return website;
        }

        private void buildPartial0(Website website) {
            int i;
            Game game;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                website.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                website.category_ = this.category_;
            }
            if ((i2 & 4) != 0) {
                SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
                if (singleFieldBuilder == null) {
                    game = this.game_;
                } else {
                    game = (Game) singleFieldBuilder.build();
                }
                website.game_ = game;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                website.trusted_ = this.trusted_;
            }
            if ((i2 & 16) != 0) {
                website.url_ = this.url_;
            }
            if ((i2 & 32) != 0) {
                website.checksum_ = this.checksum_;
            }
            website.bitField0_ |= i;
        }

        @Override // proto.WebsiteOrBuilder
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

        @Override // proto.WebsiteOrBuilder
        public int getCategoryValue() {
            return this.category_;
        }

        public Builder setCategoryValue(int i) {
            this.category_ = i;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // proto.WebsiteOrBuilder
        public WebsiteCategoryEnum getCategory() {
            WebsiteCategoryEnum websiteCategoryEnumForNumber = WebsiteCategoryEnum.forNumber(this.category_);
            return websiteCategoryEnumForNumber == null ? WebsiteCategoryEnum.UNRECOGNIZED : websiteCategoryEnumForNumber;
        }

        public Builder setCategory(WebsiteCategoryEnum websiteCategoryEnum) {
            websiteCategoryEnum.getClass();
            this.bitField0_ |= 2;
            this.category_ = websiteCategoryEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearCategory() {
            this.bitField0_ &= -3;
            this.category_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.WebsiteOrBuilder
        public boolean hasGame() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // proto.WebsiteOrBuilder
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
            this.bitField0_ |= 4;
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
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder mergeGame(Game game) {
            Game game2;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0 && (game2 = this.game_) != null && game2 != Game.getDefaultInstance()) {
                    getGameBuilder().mergeFrom((Message) game);
                } else {
                    this.game_ = game;
                }
            } else {
                singleFieldBuilder.mergeFrom(game);
            }
            if (this.game_ != null) {
                this.bitField0_ |= 4;
                onChanged();
            }
            return this;
        }

        public Builder clearGame() {
            this.bitField0_ &= -5;
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
            this.bitField0_ |= 4;
            onChanged();
            return (Game.Builder) getGameFieldBuilder().getBuilder();
        }

        @Override // proto.WebsiteOrBuilder
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

        @Override // proto.WebsiteOrBuilder
        public boolean getTrusted() {
            return this.trusted_;
        }

        public Builder setTrusted(boolean z) {
            this.trusted_ = z;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder clearTrusted() {
            this.bitField0_ &= -9;
            this.trusted_ = false;
            onChanged();
            return this;
        }

        @Override // proto.WebsiteOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.WebsiteOrBuilder
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
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = Website.getDefaultInstance().getUrl();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            Website.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        @Override // proto.WebsiteOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.WebsiteOrBuilder
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
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = Website.getDefaultInstance().getChecksum();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            Website.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }
    }

    public static Website getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.Website$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Website> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public Website parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Website.newBuilder();
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

    public static Parser<Website> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Website> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Website getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
