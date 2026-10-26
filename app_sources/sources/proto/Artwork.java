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

/* INFO: loaded from: classes6.dex */
public final class Artwork extends GeneratedMessage implements ArtworkOrBuilder {
    public static final int ALPHA_CHANNEL_FIELD_NUMBER = 2;
    public static final int ANIMATED_FIELD_NUMBER = 3;
    public static final int CHECKSUM_FIELD_NUMBER = 9;
    private static final Artwork DEFAULT_INSTANCE;
    public static final int GAME_FIELD_NUMBER = 4;
    public static final int HEIGHT_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IMAGE_ID_FIELD_NUMBER = 6;
    private static final Parser<Artwork> PARSER;
    public static final int URL_FIELD_NUMBER = 7;
    public static final int WIDTH_FIELD_NUMBER = 8;
    private static final long serialVersionUID = 0;
    private boolean alphaChannel_;
    private boolean animated_;
    private int bitField0_;
    private volatile Object checksum_;
    private Game game_;
    private int height_;
    private long id_;
    private volatile Object imageId_;
    private volatile Object url_;
    private int width_;

    /* synthetic */ Artwork(GeneratedMessage.Builder builder, ArtworkIA artworkIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Artwork.class.getName());
        DEFAULT_INSTANCE = new Artwork();
        PARSER = new AnonymousClass1();
    }

    private Artwork(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.alphaChannel_ = false;
        this.animated_ = false;
        this.height_ = 0;
        this.imageId_ = "";
        this.url_ = "";
        this.width_ = 0;
        this.checksum_ = "";
    }

    private Artwork() {
        this.id_ = 0L;
        this.alphaChannel_ = false;
        this.animated_ = false;
        this.height_ = 0;
        this.imageId_ = "";
        this.url_ = "";
        this.width_ = 0;
        this.checksum_ = "";
        this.imageId_ = "";
        this.url_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_Artwork_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_Artwork_fieldAccessorTable.ensureFieldAccessorsInitialized(Artwork.class, Builder.class);
    }

    @Override // proto.ArtworkOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.ArtworkOrBuilder
    public boolean getAlphaChannel() {
        return this.alphaChannel_;
    }

    @Override // proto.ArtworkOrBuilder
    public boolean getAnimated() {
        return this.animated_;
    }

    @Override // proto.ArtworkOrBuilder
    public boolean hasGame() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.ArtworkOrBuilder
    public Game getGame() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.ArtworkOrBuilder
    public GameOrBuilder getGameOrBuilder() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.ArtworkOrBuilder
    public int getHeight() {
        return this.height_;
    }

    @Override // proto.ArtworkOrBuilder
    public String getImageId() {
        Object obj = this.imageId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.imageId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.ArtworkOrBuilder
    public ByteString getImageIdBytes() {
        Object obj = this.imageId_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.imageId_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.ArtworkOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.ArtworkOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.ArtworkOrBuilder
    public int getWidth() {
        return this.width_;
    }

    @Override // proto.ArtworkOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.ArtworkOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static Artwork parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Artwork parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Artwork parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Artwork parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Artwork parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Artwork parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Artwork parseFrom(InputStream inputStream) throws IOException {
        return (Artwork) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Artwork parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Artwork) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Artwork parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Artwork) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Artwork parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Artwork) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Artwork parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Artwork) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Artwork parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Artwork) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(Artwork artwork) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) artwork);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((ArtworkIA) null) : (Builder) new Builder((ArtworkIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ArtworkOrBuilder {
        private boolean alphaChannel_;
        private boolean animated_;
        private int bitField0_;
        private Object checksum_;
        private SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> gameBuilder_;
        private Game game_;
        private int height_;
        private long id_;
        private Object imageId_;
        private Object url_;
        private int width_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, ArtworkIA artworkIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(ArtworkIA artworkIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_Artwork_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_Artwork_fieldAccessorTable.ensureFieldAccessorsInitialized(Artwork.class, Builder.class);
        }

        private Builder() {
            this.imageId_ = "";
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.imageId_ = "";
            this.url_ = "";
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (Artwork.alwaysUseFieldBuilders) {
                getGameFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.alphaChannel_ = false;
            this.animated_ = false;
            this.game_ = null;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.gameBuilder_ = null;
            }
            this.height_ = 0;
            this.imageId_ = "";
            this.url_ = "";
            this.width_ = 0;
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_Artwork_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Artwork getDefaultInstanceForType() {
            return Artwork.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Artwork build() {
            Artwork artworkBuildPartial = buildPartial();
            if (artworkBuildPartial.isInitialized()) {
                return artworkBuildPartial;
            }
            throw newUninitializedMessageException((Message) artworkBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Artwork buildPartial() {
            Artwork artwork = new Artwork(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(artwork);
            }
            onBuilt();
            return artwork;
        }

        private void buildPartial0(Artwork artwork) {
            int i;
            Game game;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                artwork.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                artwork.alphaChannel_ = this.alphaChannel_;
            }
            if ((i2 & 4) != 0) {
                artwork.animated_ = this.animated_;
            }
            if ((i2 & 8) != 0) {
                SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
                if (singleFieldBuilder == null) {
                    game = this.game_;
                } else {
                    game = (Game) singleFieldBuilder.build();
                }
                artwork.game_ = game;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 16) != 0) {
                artwork.height_ = this.height_;
            }
            if ((i2 & 32) != 0) {
                artwork.imageId_ = this.imageId_;
            }
            if ((i2 & 64) != 0) {
                artwork.url_ = this.url_;
            }
            if ((i2 & 128) != 0) {
                artwork.width_ = this.width_;
            }
            if ((i2 & 256) != 0) {
                artwork.checksum_ = this.checksum_;
            }
            artwork.bitField0_ |= i;
        }

        @Override // proto.ArtworkOrBuilder
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

        @Override // proto.ArtworkOrBuilder
        public boolean getAlphaChannel() {
            return this.alphaChannel_;
        }

        public Builder setAlphaChannel(boolean z) {
            this.alphaChannel_ = z;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder clearAlphaChannel() {
            this.bitField0_ &= -3;
            this.alphaChannel_ = false;
            onChanged();
            return this;
        }

        @Override // proto.ArtworkOrBuilder
        public boolean getAnimated() {
            return this.animated_;
        }

        public Builder setAnimated(boolean z) {
            this.animated_ = z;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearAnimated() {
            this.bitField0_ &= -5;
            this.animated_ = false;
            onChanged();
            return this;
        }

        @Override // proto.ArtworkOrBuilder
        public boolean hasGame() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // proto.ArtworkOrBuilder
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
            this.bitField0_ |= 8;
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
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder mergeGame(Game game) {
            Game game2;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 8) != 0 && (game2 = this.game_) != null && game2 != Game.getDefaultInstance()) {
                    getGameBuilder().mergeFrom((Message) game);
                } else {
                    this.game_ = game;
                }
            } else {
                singleFieldBuilder.mergeFrom(game);
            }
            if (this.game_ != null) {
                this.bitField0_ |= 8;
                onChanged();
            }
            return this;
        }

        public Builder clearGame() {
            this.bitField0_ &= -9;
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
            this.bitField0_ |= 8;
            onChanged();
            return (Game.Builder) getGameFieldBuilder().getBuilder();
        }

        @Override // proto.ArtworkOrBuilder
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

        @Override // proto.ArtworkOrBuilder
        public int getHeight() {
            return this.height_;
        }

        public Builder setHeight(int i) {
            this.height_ = i;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearHeight() {
            this.bitField0_ &= -17;
            this.height_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.ArtworkOrBuilder
        public String getImageId() {
            Object obj = this.imageId_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.imageId_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.ArtworkOrBuilder
        public ByteString getImageIdBytes() {
            Object obj = this.imageId_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imageId_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setImageId(String str) {
            str.getClass();
            this.imageId_ = str;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearImageId() {
            this.imageId_ = Artwork.getDefaultInstance().getImageId();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder setImageIdBytes(ByteString byteString) {
            byteString.getClass();
            Artwork.checkByteStringIsUtf8(byteString);
            this.imageId_ = byteString;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        @Override // proto.ArtworkOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.ArtworkOrBuilder
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
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = Artwork.getDefaultInstance().getUrl();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            Artwork.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        @Override // proto.ArtworkOrBuilder
        public int getWidth() {
            return this.width_;
        }

        public Builder setWidth(int i) {
            this.width_ = i;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder clearWidth() {
            this.bitField0_ &= -129;
            this.width_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.ArtworkOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.ArtworkOrBuilder
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
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = Artwork.getDefaultInstance().getChecksum();
            this.bitField0_ &= -257;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            Artwork.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }
    }

    public static Artwork getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.Artwork$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Artwork> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public Artwork parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Artwork.newBuilder();
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

    public static Parser<Artwork> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Artwork> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Artwork getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
