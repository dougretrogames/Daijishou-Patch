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
public final class PlatformResult extends GeneratedMessage implements PlatformResultOrBuilder {
    private static final PlatformResult DEFAULT_INSTANCE;
    private static final Parser<PlatformResult> PARSER;
    public static final int PLATFORMS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<Platform> platforms_;

    /* synthetic */ PlatformResult(GeneratedMessage.Builder builder, PlatformResultIA platformResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PlatformResult.class.getName());
        DEFAULT_INSTANCE = new PlatformResult();
        PARSER = new AnonymousClass1();
    }

    private PlatformResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private PlatformResult() {
        this.platforms_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_PlatformResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_PlatformResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformResult.class, Builder.class);
    }

    @Override // proto.PlatformResultOrBuilder
    public List<Platform> getPlatformsList() {
        return this.platforms_;
    }

    @Override // proto.PlatformResultOrBuilder
    public List<? extends PlatformOrBuilder> getPlatformsOrBuilderList() {
        return this.platforms_;
    }

    @Override // proto.PlatformResultOrBuilder
    public int getPlatformsCount() {
        return this.platforms_.size();
    }

    @Override // proto.PlatformResultOrBuilder
    public Platform getPlatforms(int i) {
        return this.platforms_.get(i);
    }

    @Override // proto.PlatformResultOrBuilder
    public PlatformOrBuilder getPlatformsOrBuilder(int i) {
        return this.platforms_.get(i);
    }

    public static PlatformResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PlatformResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PlatformResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PlatformResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PlatformResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PlatformResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PlatformResult parseFrom(InputStream inputStream) throws IOException {
        return (PlatformResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PlatformResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PlatformResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PlatformResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PlatformResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PlatformResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PlatformResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PlatformResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(PlatformResult platformResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) platformResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((PlatformResultIA) null) : (Builder) new Builder((PlatformResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PlatformResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> platformsBuilder_;
        private List<Platform> platforms_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, PlatformResultIA platformResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(PlatformResultIA platformResultIA) {
            this();
        }

        private void buildPartial0(PlatformResult platformResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_PlatformResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_PlatformResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PlatformResult.class, Builder.class);
        }

        private Builder() {
            this.platforms_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.platforms_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.platforms_ = Collections.emptyList();
            } else {
                this.platforms_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_PlatformResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PlatformResult getDefaultInstanceForType() {
            return PlatformResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformResult build() {
            PlatformResult platformResultBuildPartial = buildPartial();
            if (platformResultBuildPartial.isInitialized()) {
                return platformResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) platformResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PlatformResult buildPartial() {
            PlatformResult platformResult = new PlatformResult(this, null);
            buildPartialRepeatedFields(platformResult);
            if (this.bitField0_ != 0) {
                buildPartial0(platformResult);
            }
            onBuilt();
            return platformResult;
        }

        private void buildPartialRepeatedFields(PlatformResult platformResult) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.platforms_ = Collections.unmodifiableList(this.platforms_);
                    this.bitField0_ &= -2;
                }
                platformResult.platforms_ = this.platforms_;
                return;
            }
            platformResult.platforms_ = repeatedFieldBuilder.build();
        }

        private void ensurePlatformsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.platforms_ = new ArrayList(this.platforms_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.PlatformResultOrBuilder
        public List<Platform> getPlatformsList() {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.platforms_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.PlatformResultOrBuilder
        public int getPlatformsCount() {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platforms_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.PlatformResultOrBuilder
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
                this.bitField0_ &= -2;
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

        @Override // proto.PlatformResultOrBuilder
        public PlatformOrBuilder getPlatformsOrBuilder(int i) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platforms_.get(i);
            }
            return (PlatformOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.PlatformResultOrBuilder
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
                this.platformsBuilder_ = new RepeatedFieldBuilder<>(this.platforms_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.platforms_ = null;
            }
            return this.platformsBuilder_;
        }
    }

    public static PlatformResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.PlatformResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<PlatformResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public PlatformResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = PlatformResult.newBuilder();
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

    public static Parser<PlatformResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PlatformResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PlatformResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
