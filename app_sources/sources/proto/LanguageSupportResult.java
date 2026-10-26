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
public final class LanguageSupportResult extends GeneratedMessage implements LanguageSupportResultOrBuilder {
    private static final LanguageSupportResult DEFAULT_INSTANCE;
    public static final int LANGUAGESUPPORTS_FIELD_NUMBER = 1;
    private static final Parser<LanguageSupportResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<LanguageSupport> languagesupports_;

    /* synthetic */ LanguageSupportResult(GeneratedMessage.Builder builder, LanguageSupportResultIA languageSupportResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", LanguageSupportResult.class.getName());
        DEFAULT_INSTANCE = new LanguageSupportResult();
        PARSER = new AnonymousClass1();
    }

    private LanguageSupportResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private LanguageSupportResult() {
        this.languagesupports_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_LanguageSupportResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_LanguageSupportResult_fieldAccessorTable.ensureFieldAccessorsInitialized(LanguageSupportResult.class, Builder.class);
    }

    @Override // proto.LanguageSupportResultOrBuilder
    public List<LanguageSupport> getLanguagesupportsList() {
        return this.languagesupports_;
    }

    @Override // proto.LanguageSupportResultOrBuilder
    public List<? extends LanguageSupportOrBuilder> getLanguagesupportsOrBuilderList() {
        return this.languagesupports_;
    }

    @Override // proto.LanguageSupportResultOrBuilder
    public int getLanguagesupportsCount() {
        return this.languagesupports_.size();
    }

    @Override // proto.LanguageSupportResultOrBuilder
    public LanguageSupport getLanguagesupports(int i) {
        return this.languagesupports_.get(i);
    }

    @Override // proto.LanguageSupportResultOrBuilder
    public LanguageSupportOrBuilder getLanguagesupportsOrBuilder(int i) {
        return this.languagesupports_.get(i);
    }

    public static LanguageSupportResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static LanguageSupportResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LanguageSupportResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static LanguageSupportResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LanguageSupportResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LanguageSupportResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static LanguageSupportResult parseFrom(InputStream inputStream) throws IOException {
        return (LanguageSupportResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static LanguageSupportResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LanguageSupportResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LanguageSupportResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LanguageSupportResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LanguageSupportResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LanguageSupportResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LanguageSupportResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LanguageSupportResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static LanguageSupportResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LanguageSupportResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(LanguageSupportResult languageSupportResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) languageSupportResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((LanguageSupportResultIA) null) : (Builder) new Builder((LanguageSupportResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements LanguageSupportResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> languagesupportsBuilder_;
        private List<LanguageSupport> languagesupports_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, LanguageSupportResultIA languageSupportResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(LanguageSupportResultIA languageSupportResultIA) {
            this();
        }

        private void buildPartial0(LanguageSupportResult languageSupportResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_LanguageSupportResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_LanguageSupportResult_fieldAccessorTable.ensureFieldAccessorsInitialized(LanguageSupportResult.class, Builder.class);
        }

        private Builder() {
            this.languagesupports_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.languagesupports_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languagesupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.languagesupports_ = Collections.emptyList();
            } else {
                this.languagesupports_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_LanguageSupportResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LanguageSupportResult getDefaultInstanceForType() {
            return LanguageSupportResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LanguageSupportResult build() {
            LanguageSupportResult languageSupportResultBuildPartial = buildPartial();
            if (languageSupportResultBuildPartial.isInitialized()) {
                return languageSupportResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) languageSupportResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LanguageSupportResult buildPartial() {
            LanguageSupportResult languageSupportResult = new LanguageSupportResult(this, null);
            buildPartialRepeatedFields(languageSupportResult);
            if (this.bitField0_ != 0) {
                buildPartial0(languageSupportResult);
            }
            onBuilt();
            return languageSupportResult;
        }

        private void buildPartialRepeatedFields(LanguageSupportResult languageSupportResult) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languagesupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.languagesupports_ = Collections.unmodifiableList(this.languagesupports_);
                    this.bitField0_ &= -2;
                }
                languageSupportResult.languagesupports_ = this.languagesupports_;
                return;
            }
            languageSupportResult.languagesupports_ = repeatedFieldBuilder.build();
        }

        private void ensureLanguagesupportsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.languagesupports_ = new ArrayList(this.languagesupports_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.LanguageSupportResultOrBuilder
        public List<LanguageSupport> getLanguagesupportsList() {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languagesupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.languagesupports_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.LanguageSupportResultOrBuilder
        public int getLanguagesupportsCount() {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languagesupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.languagesupports_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.LanguageSupportResultOrBuilder
        public LanguageSupport getLanguagesupports(int i) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languagesupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.languagesupports_.get(i);
            }
            return (LanguageSupport) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setLanguagesupports(int i, LanguageSupport languageSupport) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languagesupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                languageSupport.getClass();
                ensureLanguagesupportsIsMutable();
                this.languagesupports_.set(i, languageSupport);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, languageSupport);
            return this;
        }

        public Builder setLanguagesupports(int i, LanguageSupport.Builder builder) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languagesupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguagesupportsIsMutable();
                this.languagesupports_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addLanguagesupports(LanguageSupport languageSupport) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languagesupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                languageSupport.getClass();
                ensureLanguagesupportsIsMutable();
                this.languagesupports_.add(languageSupport);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(languageSupport);
            return this;
        }

        public Builder addLanguagesupports(int i, LanguageSupport languageSupport) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languagesupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                languageSupport.getClass();
                ensureLanguagesupportsIsMutable();
                this.languagesupports_.add(i, languageSupport);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, languageSupport);
            return this;
        }

        public Builder addLanguagesupports(LanguageSupport.Builder builder) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languagesupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguagesupportsIsMutable();
                this.languagesupports_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addLanguagesupports(int i, LanguageSupport.Builder builder) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languagesupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguagesupportsIsMutable();
                this.languagesupports_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllLanguagesupports(Iterable<? extends LanguageSupport> iterable) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languagesupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguagesupportsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.languagesupports_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearLanguagesupports() {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languagesupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.languagesupports_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeLanguagesupports(int i) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languagesupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguagesupportsIsMutable();
                this.languagesupports_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public LanguageSupport.Builder getLanguagesupportsBuilder(int i) {
            return (LanguageSupport.Builder) getLanguagesupportsFieldBuilder().getBuilder(i);
        }

        @Override // proto.LanguageSupportResultOrBuilder
        public LanguageSupportOrBuilder getLanguagesupportsOrBuilder(int i) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languagesupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.languagesupports_.get(i);
            }
            return (LanguageSupportOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.LanguageSupportResultOrBuilder
        public List<? extends LanguageSupportOrBuilder> getLanguagesupportsOrBuilderList() {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languagesupportsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.languagesupports_);
        }

        public LanguageSupport.Builder addLanguagesupportsBuilder() {
            return (LanguageSupport.Builder) getLanguagesupportsFieldBuilder().addBuilder(LanguageSupport.getDefaultInstance());
        }

        public LanguageSupport.Builder addLanguagesupportsBuilder(int i) {
            return (LanguageSupport.Builder) getLanguagesupportsFieldBuilder().addBuilder(i, LanguageSupport.getDefaultInstance());
        }

        public List<LanguageSupport.Builder> getLanguagesupportsBuilderList() {
            return getLanguagesupportsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> getLanguagesupportsFieldBuilder() {
            if (this.languagesupportsBuilder_ == null) {
                this.languagesupportsBuilder_ = new RepeatedFieldBuilder<>(this.languagesupports_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.languagesupports_ = null;
            }
            return this.languagesupportsBuilder_;
        }
    }

    public static LanguageSupportResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.LanguageSupportResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<LanguageSupportResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public LanguageSupportResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = LanguageSupportResult.newBuilder();
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

    public static Parser<LanguageSupportResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<LanguageSupportResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public LanguageSupportResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
