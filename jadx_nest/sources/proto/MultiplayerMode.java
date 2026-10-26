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
public final class MultiplayerMode extends GeneratedMessage implements MultiplayerModeOrBuilder {
    public static final int CAMPAIGNCOOP_FIELD_NUMBER = 2;
    public static final int CHECKSUM_FIELD_NUMBER = 15;
    private static final MultiplayerMode DEFAULT_INSTANCE;
    public static final int DROPIN_FIELD_NUMBER = 3;
    public static final int GAME_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int LANCOOP_FIELD_NUMBER = 5;
    public static final int OFFLINECOOPMAX_FIELD_NUMBER = 7;
    public static final int OFFLINECOOP_FIELD_NUMBER = 6;
    public static final int OFFLINEMAX_FIELD_NUMBER = 8;
    public static final int ONLINECOOPMAX_FIELD_NUMBER = 10;
    public static final int ONLINECOOP_FIELD_NUMBER = 9;
    public static final int ONLINEMAX_FIELD_NUMBER = 11;
    private static final Parser<MultiplayerMode> PARSER;
    public static final int PLATFORM_FIELD_NUMBER = 12;
    public static final int SPLITSCREENONLINE_FIELD_NUMBER = 14;
    public static final int SPLITSCREEN_FIELD_NUMBER = 13;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private boolean campaigncoop_;
    private volatile Object checksum_;
    private boolean dropin_;
    private Game game_;
    private long id_;
    private boolean lancoop_;
    private boolean offlinecoop_;
    private int offlinecoopmax_;
    private int offlinemax_;
    private boolean onlinecoop_;
    private int onlinecoopmax_;
    private int onlinemax_;
    private Platform platform_;
    private boolean splitscreen_;
    private boolean splitscreenonline_;

    /* synthetic */ MultiplayerMode(GeneratedMessage.Builder builder, MultiplayerModeIA multiplayerModeIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", MultiplayerMode.class.getName());
        DEFAULT_INSTANCE = new MultiplayerMode();
        PARSER = new AnonymousClass1();
    }

    private MultiplayerMode(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.campaigncoop_ = false;
        this.dropin_ = false;
        this.lancoop_ = false;
        this.offlinecoop_ = false;
        this.offlinecoopmax_ = 0;
        this.offlinemax_ = 0;
        this.onlinecoop_ = false;
        this.onlinecoopmax_ = 0;
        this.onlinemax_ = 0;
        this.splitscreen_ = false;
        this.splitscreenonline_ = false;
        this.checksum_ = "";
    }

    private MultiplayerMode() {
        this.id_ = 0L;
        this.campaigncoop_ = false;
        this.dropin_ = false;
        this.lancoop_ = false;
        this.offlinecoop_ = false;
        this.offlinecoopmax_ = 0;
        this.offlinemax_ = 0;
        this.onlinecoop_ = false;
        this.onlinecoopmax_ = 0;
        this.onlinemax_ = 0;
        this.splitscreen_ = false;
        this.splitscreenonline_ = false;
        this.checksum_ = "";
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_MultiplayerMode_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_MultiplayerMode_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiplayerMode.class, Builder.class);
    }

    @Override // proto.MultiplayerModeOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public boolean getCampaigncoop() {
        return this.campaigncoop_;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public boolean getDropin() {
        return this.dropin_;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public boolean hasGame() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public Game getGame() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public GameOrBuilder getGameOrBuilder() {
        Game game = this.game_;
        return game == null ? Game.getDefaultInstance() : game;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public boolean getLancoop() {
        return this.lancoop_;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public boolean getOfflinecoop() {
        return this.offlinecoop_;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public int getOfflinecoopmax() {
        return this.offlinecoopmax_;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public int getOfflinemax() {
        return this.offlinemax_;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public boolean getOnlinecoop() {
        return this.onlinecoop_;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public int getOnlinecoopmax() {
        return this.onlinecoopmax_;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public int getOnlinemax() {
        return this.onlinemax_;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public boolean hasPlatform() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public Platform getPlatform() {
        Platform platform = this.platform_;
        return platform == null ? Platform.getDefaultInstance() : platform;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public PlatformOrBuilder getPlatformOrBuilder() {
        Platform platform = this.platform_;
        return platform == null ? Platform.getDefaultInstance() : platform;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public boolean getSplitscreen() {
        return this.splitscreen_;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public boolean getSplitscreenonline() {
        return this.splitscreenonline_;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.MultiplayerModeOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static MultiplayerMode parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static MultiplayerMode parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static MultiplayerMode parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static MultiplayerMode parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static MultiplayerMode parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static MultiplayerMode parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static MultiplayerMode parseFrom(InputStream inputStream) throws IOException {
        return (MultiplayerMode) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static MultiplayerMode parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiplayerMode) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MultiplayerMode parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MultiplayerMode) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static MultiplayerMode parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiplayerMode) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MultiplayerMode parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MultiplayerMode) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static MultiplayerMode parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiplayerMode) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(MultiplayerMode multiplayerMode) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) multiplayerMode);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((MultiplayerModeIA) null) : (Builder) new Builder((MultiplayerModeIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements MultiplayerModeOrBuilder {
        private int bitField0_;
        private boolean campaigncoop_;
        private Object checksum_;
        private boolean dropin_;
        private SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> gameBuilder_;
        private Game game_;
        private long id_;
        private boolean lancoop_;
        private boolean offlinecoop_;
        private int offlinecoopmax_;
        private int offlinemax_;
        private boolean onlinecoop_;
        private int onlinecoopmax_;
        private int onlinemax_;
        private SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> platformBuilder_;
        private Platform platform_;
        private boolean splitscreen_;
        private boolean splitscreenonline_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, MultiplayerModeIA multiplayerModeIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(MultiplayerModeIA multiplayerModeIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_MultiplayerMode_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_MultiplayerMode_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiplayerMode.class, Builder.class);
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
            if (MultiplayerMode.alwaysUseFieldBuilders) {
                getGameFieldBuilder();
                getPlatformFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.campaigncoop_ = false;
            this.dropin_ = false;
            this.game_ = null;
            SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.gameBuilder_ = null;
            }
            this.lancoop_ = false;
            this.offlinecoop_ = false;
            this.offlinecoopmax_ = 0;
            this.offlinemax_ = 0;
            this.onlinecoop_ = false;
            this.onlinecoopmax_ = 0;
            this.onlinemax_ = 0;
            this.platform_ = null;
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder2 = this.platformBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.platformBuilder_ = null;
            }
            this.splitscreen_ = false;
            this.splitscreenonline_ = false;
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_MultiplayerMode_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MultiplayerMode getDefaultInstanceForType() {
            return MultiplayerMode.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MultiplayerMode build() {
            MultiplayerMode multiplayerModeBuildPartial = buildPartial();
            if (multiplayerModeBuildPartial.isInitialized()) {
                return multiplayerModeBuildPartial;
            }
            throw newUninitializedMessageException((Message) multiplayerModeBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MultiplayerMode buildPartial() {
            MultiplayerMode multiplayerMode = new MultiplayerMode(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(multiplayerMode);
            }
            onBuilt();
            return multiplayerMode;
        }

        private void buildPartial0(MultiplayerMode multiplayerMode) {
            int i;
            Platform platform;
            Game game;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                multiplayerMode.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                multiplayerMode.campaigncoop_ = this.campaigncoop_;
            }
            if ((i2 & 4) != 0) {
                multiplayerMode.dropin_ = this.dropin_;
            }
            if ((i2 & 8) != 0) {
                SingleFieldBuilder<Game, Game.Builder, GameOrBuilder> singleFieldBuilder = this.gameBuilder_;
                if (singleFieldBuilder == null) {
                    game = this.game_;
                } else {
                    game = (Game) singleFieldBuilder.build();
                }
                multiplayerMode.game_ = game;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 16) != 0) {
                multiplayerMode.lancoop_ = this.lancoop_;
            }
            if ((i2 & 32) != 0) {
                multiplayerMode.offlinecoop_ = this.offlinecoop_;
            }
            if ((i2 & 64) != 0) {
                multiplayerMode.offlinecoopmax_ = this.offlinecoopmax_;
            }
            if ((i2 & 128) != 0) {
                multiplayerMode.offlinemax_ = this.offlinemax_;
            }
            if ((i2 & 256) != 0) {
                multiplayerMode.onlinecoop_ = this.onlinecoop_;
            }
            if ((i2 & 512) != 0) {
                multiplayerMode.onlinecoopmax_ = this.onlinecoopmax_;
            }
            if ((i2 & 1024) != 0) {
                multiplayerMode.onlinemax_ = this.onlinemax_;
            }
            if ((i2 & 2048) != 0) {
                SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder2 = this.platformBuilder_;
                if (singleFieldBuilder2 == null) {
                    platform = this.platform_;
                } else {
                    platform = (Platform) singleFieldBuilder2.build();
                }
                multiplayerMode.platform_ = platform;
                i |= 2;
            }
            if ((i2 & 4096) != 0) {
                multiplayerMode.splitscreen_ = this.splitscreen_;
            }
            if ((i2 & 8192) != 0) {
                multiplayerMode.splitscreenonline_ = this.splitscreenonline_;
            }
            if ((i2 & 16384) != 0) {
                multiplayerMode.checksum_ = this.checksum_;
            }
            multiplayerMode.bitField0_ |= i;
        }

        @Override // proto.MultiplayerModeOrBuilder
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

        @Override // proto.MultiplayerModeOrBuilder
        public boolean getCampaigncoop() {
            return this.campaigncoop_;
        }

        public Builder setCampaigncoop(boolean z) {
            this.campaigncoop_ = z;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder clearCampaigncoop() {
            this.bitField0_ &= -3;
            this.campaigncoop_ = false;
            onChanged();
            return this;
        }

        @Override // proto.MultiplayerModeOrBuilder
        public boolean getDropin() {
            return this.dropin_;
        }

        public Builder setDropin(boolean z) {
            this.dropin_ = z;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearDropin() {
            this.bitField0_ &= -5;
            this.dropin_ = false;
            onChanged();
            return this;
        }

        @Override // proto.MultiplayerModeOrBuilder
        public boolean hasGame() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // proto.MultiplayerModeOrBuilder
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

        @Override // proto.MultiplayerModeOrBuilder
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

        @Override // proto.MultiplayerModeOrBuilder
        public boolean getLancoop() {
            return this.lancoop_;
        }

        public Builder setLancoop(boolean z) {
            this.lancoop_ = z;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder clearLancoop() {
            this.bitField0_ &= -17;
            this.lancoop_ = false;
            onChanged();
            return this;
        }

        @Override // proto.MultiplayerModeOrBuilder
        public boolean getOfflinecoop() {
            return this.offlinecoop_;
        }

        public Builder setOfflinecoop(boolean z) {
            this.offlinecoop_ = z;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearOfflinecoop() {
            this.bitField0_ &= -33;
            this.offlinecoop_ = false;
            onChanged();
            return this;
        }

        @Override // proto.MultiplayerModeOrBuilder
        public int getOfflinecoopmax() {
            return this.offlinecoopmax_;
        }

        public Builder setOfflinecoopmax(int i) {
            this.offlinecoopmax_ = i;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearOfflinecoopmax() {
            this.bitField0_ &= -65;
            this.offlinecoopmax_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.MultiplayerModeOrBuilder
        public int getOfflinemax() {
            return this.offlinemax_;
        }

        public Builder setOfflinemax(int i) {
            this.offlinemax_ = i;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder clearOfflinemax() {
            this.bitField0_ &= -129;
            this.offlinemax_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.MultiplayerModeOrBuilder
        public boolean getOnlinecoop() {
            return this.onlinecoop_;
        }

        public Builder setOnlinecoop(boolean z) {
            this.onlinecoop_ = z;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder clearOnlinecoop() {
            this.bitField0_ &= -257;
            this.onlinecoop_ = false;
            onChanged();
            return this;
        }

        @Override // proto.MultiplayerModeOrBuilder
        public int getOnlinecoopmax() {
            return this.onlinecoopmax_;
        }

        public Builder setOnlinecoopmax(int i) {
            this.onlinecoopmax_ = i;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder clearOnlinecoopmax() {
            this.bitField0_ &= -513;
            this.onlinecoopmax_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.MultiplayerModeOrBuilder
        public int getOnlinemax() {
            return this.onlinemax_;
        }

        public Builder setOnlinemax(int i) {
            this.onlinemax_ = i;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder clearOnlinemax() {
            this.bitField0_ &= -1025;
            this.onlinemax_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.MultiplayerModeOrBuilder
        public boolean hasPlatform() {
            return (this.bitField0_ & 2048) != 0;
        }

        @Override // proto.MultiplayerModeOrBuilder
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
            this.bitField0_ |= 2048;
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
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder mergePlatform(Platform platform) {
            Platform platform2;
            SingleFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> singleFieldBuilder = this.platformBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 2048) != 0 && (platform2 = this.platform_) != null && platform2 != Platform.getDefaultInstance()) {
                    getPlatformBuilder().mergeFrom((Message) platform);
                } else {
                    this.platform_ = platform;
                }
            } else {
                singleFieldBuilder.mergeFrom(platform);
            }
            if (this.platform_ != null) {
                this.bitField0_ |= 2048;
                onChanged();
            }
            return this;
        }

        public Builder clearPlatform() {
            this.bitField0_ &= -2049;
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
            this.bitField0_ |= 2048;
            onChanged();
            return (Platform.Builder) getPlatformFieldBuilder().getBuilder();
        }

        @Override // proto.MultiplayerModeOrBuilder
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

        @Override // proto.MultiplayerModeOrBuilder
        public boolean getSplitscreen() {
            return this.splitscreen_;
        }

        public Builder setSplitscreen(boolean z) {
            this.splitscreen_ = z;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder clearSplitscreen() {
            this.bitField0_ &= -4097;
            this.splitscreen_ = false;
            onChanged();
            return this;
        }

        @Override // proto.MultiplayerModeOrBuilder
        public boolean getSplitscreenonline() {
            return this.splitscreenonline_;
        }

        public Builder setSplitscreenonline(boolean z) {
            this.splitscreenonline_ = z;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder clearSplitscreenonline() {
            this.bitField0_ &= -8193;
            this.splitscreenonline_ = false;
            onChanged();
            return this;
        }

        @Override // proto.MultiplayerModeOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.MultiplayerModeOrBuilder
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
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = MultiplayerMode.getDefaultInstance().getChecksum();
            this.bitField0_ &= -16385;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            MultiplayerMode.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }
    }

    public static MultiplayerMode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.MultiplayerMode$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<MultiplayerMode> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public MultiplayerMode parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = MultiplayerMode.newBuilder();
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

    public static Parser<MultiplayerMode> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<MultiplayerMode> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public MultiplayerMode getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
