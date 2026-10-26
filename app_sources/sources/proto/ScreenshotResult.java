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
public final class ScreenshotResult extends GeneratedMessage implements ScreenshotResultOrBuilder {
    private static final ScreenshotResult DEFAULT_INSTANCE;
    private static final Parser<ScreenshotResult> PARSER;
    public static final int SCREENSHOTS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<Screenshot> screenshots_;

    /* synthetic */ ScreenshotResult(GeneratedMessage.Builder builder, ScreenshotResultIA screenshotResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", ScreenshotResult.class.getName());
        DEFAULT_INSTANCE = new ScreenshotResult();
        PARSER = new AnonymousClass1();
    }

    private ScreenshotResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private ScreenshotResult() {
        this.screenshots_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_ScreenshotResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_ScreenshotResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ScreenshotResult.class, Builder.class);
    }

    @Override // proto.ScreenshotResultOrBuilder
    public List<Screenshot> getScreenshotsList() {
        return this.screenshots_;
    }

    @Override // proto.ScreenshotResultOrBuilder
    public List<? extends ScreenshotOrBuilder> getScreenshotsOrBuilderList() {
        return this.screenshots_;
    }

    @Override // proto.ScreenshotResultOrBuilder
    public int getScreenshotsCount() {
        return this.screenshots_.size();
    }

    @Override // proto.ScreenshotResultOrBuilder
    public Screenshot getScreenshots(int i) {
        return this.screenshots_.get(i);
    }

    @Override // proto.ScreenshotResultOrBuilder
    public ScreenshotOrBuilder getScreenshotsOrBuilder(int i) {
        return this.screenshots_.get(i);
    }

    public static ScreenshotResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ScreenshotResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ScreenshotResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ScreenshotResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ScreenshotResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ScreenshotResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ScreenshotResult parseFrom(InputStream inputStream) throws IOException {
        return (ScreenshotResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static ScreenshotResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ScreenshotResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ScreenshotResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ScreenshotResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ScreenshotResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ScreenshotResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ScreenshotResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ScreenshotResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static ScreenshotResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ScreenshotResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(ScreenshotResult screenshotResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) screenshotResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((ScreenshotResultIA) null) : (Builder) new Builder((ScreenshotResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ScreenshotResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> screenshotsBuilder_;
        private List<Screenshot> screenshots_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, ScreenshotResultIA screenshotResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(ScreenshotResultIA screenshotResultIA) {
            this();
        }

        private void buildPartial0(ScreenshotResult screenshotResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_ScreenshotResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_ScreenshotResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ScreenshotResult.class, Builder.class);
        }

        private Builder() {
            this.screenshots_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.screenshots_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.screenshots_ = Collections.emptyList();
            } else {
                this.screenshots_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_ScreenshotResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ScreenshotResult getDefaultInstanceForType() {
            return ScreenshotResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ScreenshotResult build() {
            ScreenshotResult screenshotResultBuildPartial = buildPartial();
            if (screenshotResultBuildPartial.isInitialized()) {
                return screenshotResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) screenshotResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ScreenshotResult buildPartial() {
            ScreenshotResult screenshotResult = new ScreenshotResult(this, null);
            buildPartialRepeatedFields(screenshotResult);
            if (this.bitField0_ != 0) {
                buildPartial0(screenshotResult);
            }
            onBuilt();
            return screenshotResult;
        }

        private void buildPartialRepeatedFields(ScreenshotResult screenshotResult) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.screenshots_ = Collections.unmodifiableList(this.screenshots_);
                    this.bitField0_ &= -2;
                }
                screenshotResult.screenshots_ = this.screenshots_;
                return;
            }
            screenshotResult.screenshots_ = repeatedFieldBuilder.build();
        }

        private void ensureScreenshotsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.screenshots_ = new ArrayList(this.screenshots_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.ScreenshotResultOrBuilder
        public List<Screenshot> getScreenshotsList() {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.screenshots_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.ScreenshotResultOrBuilder
        public int getScreenshotsCount() {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.screenshots_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.ScreenshotResultOrBuilder
        public Screenshot getScreenshots(int i) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.screenshots_.get(i);
            }
            return (Screenshot) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setScreenshots(int i, Screenshot screenshot) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                screenshot.getClass();
                ensureScreenshotsIsMutable();
                this.screenshots_.set(i, screenshot);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, screenshot);
            return this;
        }

        public Builder setScreenshots(int i, Screenshot.Builder builder) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureScreenshotsIsMutable();
                this.screenshots_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addScreenshots(Screenshot screenshot) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                screenshot.getClass();
                ensureScreenshotsIsMutable();
                this.screenshots_.add(screenshot);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(screenshot);
            return this;
        }

        public Builder addScreenshots(int i, Screenshot screenshot) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                screenshot.getClass();
                ensureScreenshotsIsMutable();
                this.screenshots_.add(i, screenshot);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, screenshot);
            return this;
        }

        public Builder addScreenshots(Screenshot.Builder builder) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureScreenshotsIsMutable();
                this.screenshots_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addScreenshots(int i, Screenshot.Builder builder) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureScreenshotsIsMutable();
                this.screenshots_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllScreenshots(Iterable<? extends Screenshot> iterable) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureScreenshotsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.screenshots_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearScreenshots() {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.screenshots_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeScreenshots(int i) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureScreenshotsIsMutable();
                this.screenshots_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Screenshot.Builder getScreenshotsBuilder(int i) {
            return (Screenshot.Builder) getScreenshotsFieldBuilder().getBuilder(i);
        }

        @Override // proto.ScreenshotResultOrBuilder
        public ScreenshotOrBuilder getScreenshotsOrBuilder(int i) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.screenshots_.get(i);
            }
            return (ScreenshotOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.ScreenshotResultOrBuilder
        public List<? extends ScreenshotOrBuilder> getScreenshotsOrBuilderList() {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.screenshots_);
        }

        public Screenshot.Builder addScreenshotsBuilder() {
            return (Screenshot.Builder) getScreenshotsFieldBuilder().addBuilder(Screenshot.getDefaultInstance());
        }

        public Screenshot.Builder addScreenshotsBuilder(int i) {
            return (Screenshot.Builder) getScreenshotsFieldBuilder().addBuilder(i, Screenshot.getDefaultInstance());
        }

        public List<Screenshot.Builder> getScreenshotsBuilderList() {
            return getScreenshotsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> getScreenshotsFieldBuilder() {
            if (this.screenshotsBuilder_ == null) {
                this.screenshotsBuilder_ = new RepeatedFieldBuilder<>(this.screenshots_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.screenshots_ = null;
            }
            return this.screenshotsBuilder_;
        }
    }

    public static ScreenshotResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.ScreenshotResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<ScreenshotResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public ScreenshotResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = ScreenshotResult.newBuilder();
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

    public static Parser<ScreenshotResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ScreenshotResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ScreenshotResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
