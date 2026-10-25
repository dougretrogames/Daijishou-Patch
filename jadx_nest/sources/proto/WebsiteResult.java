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

/* JADX INFO: loaded from: classes6.dex */
public final class WebsiteResult extends GeneratedMessage implements WebsiteResultOrBuilder {
    private static final WebsiteResult DEFAULT_INSTANCE;
    private static final Parser<WebsiteResult> PARSER;
    public static final int WEBSITES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<Website> websites_;

    /* synthetic */ WebsiteResult(GeneratedMessage.Builder builder, WebsiteResultIA websiteResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", WebsiteResult.class.getName());
        DEFAULT_INSTANCE = new WebsiteResult();
        PARSER = new AnonymousClass1();
    }

    private WebsiteResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private WebsiteResult() {
        this.websites_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_WebsiteResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_WebsiteResult_fieldAccessorTable.ensureFieldAccessorsInitialized(WebsiteResult.class, Builder.class);
    }

    @Override // proto.WebsiteResultOrBuilder
    public List<Website> getWebsitesList() {
        return this.websites_;
    }

    @Override // proto.WebsiteResultOrBuilder
    public List<? extends WebsiteOrBuilder> getWebsitesOrBuilderList() {
        return this.websites_;
    }

    @Override // proto.WebsiteResultOrBuilder
    public int getWebsitesCount() {
        return this.websites_.size();
    }

    @Override // proto.WebsiteResultOrBuilder
    public Website getWebsites(int i) {
        return this.websites_.get(i);
    }

    @Override // proto.WebsiteResultOrBuilder
    public WebsiteOrBuilder getWebsitesOrBuilder(int i) {
        return this.websites_.get(i);
    }

    public static WebsiteResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static WebsiteResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static WebsiteResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static WebsiteResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static WebsiteResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static WebsiteResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static WebsiteResult parseFrom(InputStream inputStream) throws IOException {
        return (WebsiteResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static WebsiteResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WebsiteResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static WebsiteResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (WebsiteResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static WebsiteResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WebsiteResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static WebsiteResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (WebsiteResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static WebsiteResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WebsiteResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(WebsiteResult websiteResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) websiteResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((WebsiteResultIA) null) : (Builder) new Builder((WebsiteResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebsiteResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> websitesBuilder_;
        private List<Website> websites_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, WebsiteResultIA websiteResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(WebsiteResultIA websiteResultIA) {
            this();
        }

        private void buildPartial0(WebsiteResult websiteResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_WebsiteResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_WebsiteResult_fieldAccessorTable.ensureFieldAccessorsInitialized(WebsiteResult.class, Builder.class);
        }

        private Builder() {
            this.websites_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.websites_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.websites_ = Collections.emptyList();
            } else {
                this.websites_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_WebsiteResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WebsiteResult getDefaultInstanceForType() {
            return WebsiteResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public WebsiteResult build() {
            WebsiteResult websiteResultBuildPartial = buildPartial();
            if (websiteResultBuildPartial.isInitialized()) {
                return websiteResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) websiteResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public WebsiteResult buildPartial() {
            WebsiteResult websiteResult = new WebsiteResult(this, null);
            buildPartialRepeatedFields(websiteResult);
            if (this.bitField0_ != 0) {
                buildPartial0(websiteResult);
            }
            onBuilt();
            return websiteResult;
        }

        private void buildPartialRepeatedFields(WebsiteResult websiteResult) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.websites_ = Collections.unmodifiableList(this.websites_);
                    this.bitField0_ &= -2;
                }
                websiteResult.websites_ = this.websites_;
                return;
            }
            websiteResult.websites_ = repeatedFieldBuilder.build();
        }

        private void ensureWebsitesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.websites_ = new ArrayList(this.websites_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.WebsiteResultOrBuilder
        public List<Website> getWebsitesList() {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.websites_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.WebsiteResultOrBuilder
        public int getWebsitesCount() {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.websites_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.WebsiteResultOrBuilder
        public Website getWebsites(int i) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.websites_.get(i);
            }
            return (Website) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setWebsites(int i, Website website) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                website.getClass();
                ensureWebsitesIsMutable();
                this.websites_.set(i, website);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, website);
            return this;
        }

        public Builder setWebsites(int i, Website.Builder builder) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                this.websites_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addWebsites(Website website) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                website.getClass();
                ensureWebsitesIsMutable();
                this.websites_.add(website);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(website);
            return this;
        }

        public Builder addWebsites(int i, Website website) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                website.getClass();
                ensureWebsitesIsMutable();
                this.websites_.add(i, website);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, website);
            return this;
        }

        public Builder addWebsites(Website.Builder builder) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                this.websites_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addWebsites(int i, Website.Builder builder) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                this.websites_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllWebsites(Iterable<? extends Website> iterable) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.websites_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearWebsites() {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.websites_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeWebsites(int i) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                this.websites_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Website.Builder getWebsitesBuilder(int i) {
            return (Website.Builder) getWebsitesFieldBuilder().getBuilder(i);
        }

        @Override // proto.WebsiteResultOrBuilder
        public WebsiteOrBuilder getWebsitesOrBuilder(int i) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.websites_.get(i);
            }
            return (WebsiteOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.WebsiteResultOrBuilder
        public List<? extends WebsiteOrBuilder> getWebsitesOrBuilderList() {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.websites_);
        }

        public Website.Builder addWebsitesBuilder() {
            return (Website.Builder) getWebsitesFieldBuilder().addBuilder(Website.getDefaultInstance());
        }

        public Website.Builder addWebsitesBuilder(int i) {
            return (Website.Builder) getWebsitesFieldBuilder().addBuilder(i, Website.getDefaultInstance());
        }

        public List<Website.Builder> getWebsitesBuilderList() {
            return getWebsitesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> getWebsitesFieldBuilder() {
            if (this.websitesBuilder_ == null) {
                this.websitesBuilder_ = new RepeatedFieldBuilder<>(this.websites_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.websites_ = null;
            }
            return this.websitesBuilder_;
        }
    }

    public static WebsiteResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.WebsiteResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<WebsiteResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public WebsiteResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = WebsiteResult.newBuilder();
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

    public static Parser<WebsiteResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<WebsiteResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public WebsiteResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
