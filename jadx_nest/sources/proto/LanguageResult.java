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
public final class LanguageResult extends GeneratedMessage implements LanguageResultOrBuilder {
    private static final LanguageResult DEFAULT_INSTANCE;
    public static final int LANGUAGES_FIELD_NUMBER = 1;
    private static final Parser<LanguageResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<Language> languages_;

    /* synthetic */ LanguageResult(GeneratedMessage.Builder builder, LanguageResultIA languageResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", LanguageResult.class.getName());
        DEFAULT_INSTANCE = new LanguageResult();
        PARSER = new AnonymousClass1();
    }

    private LanguageResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private LanguageResult() {
        this.languages_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_LanguageResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_LanguageResult_fieldAccessorTable.ensureFieldAccessorsInitialized(LanguageResult.class, Builder.class);
    }

    @Override // proto.LanguageResultOrBuilder
    public List<Language> getLanguagesList() {
        return this.languages_;
    }

    @Override // proto.LanguageResultOrBuilder
    public List<? extends LanguageOrBuilder> getLanguagesOrBuilderList() {
        return this.languages_;
    }

    @Override // proto.LanguageResultOrBuilder
    public int getLanguagesCount() {
        return this.languages_.size();
    }

    @Override // proto.LanguageResultOrBuilder
    public Language getLanguages(int i) {
        return this.languages_.get(i);
    }

    @Override // proto.LanguageResultOrBuilder
    public LanguageOrBuilder getLanguagesOrBuilder(int i) {
        return this.languages_.get(i);
    }

    public static LanguageResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static LanguageResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LanguageResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static LanguageResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LanguageResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LanguageResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static LanguageResult parseFrom(InputStream inputStream) throws IOException {
        return (LanguageResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static LanguageResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LanguageResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LanguageResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LanguageResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LanguageResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LanguageResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LanguageResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LanguageResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static LanguageResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LanguageResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(LanguageResult languageResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) languageResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((LanguageResultIA) null) : (Builder) new Builder((LanguageResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements LanguageResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> languagesBuilder_;
        private List<Language> languages_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, LanguageResultIA languageResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(LanguageResultIA languageResultIA) {
            this();
        }

        private void buildPartial0(LanguageResult languageResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_LanguageResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_LanguageResult_fieldAccessorTable.ensureFieldAccessorsInitialized(LanguageResult.class, Builder.class);
        }

        private Builder() {
            this.languages_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.languages_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> repeatedFieldBuilder = this.languagesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.languages_ = Collections.emptyList();
            } else {
                this.languages_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_LanguageResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LanguageResult getDefaultInstanceForType() {
            return LanguageResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LanguageResult build() {
            LanguageResult languageResultBuildPartial = buildPartial();
            if (languageResultBuildPartial.isInitialized()) {
                return languageResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) languageResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LanguageResult buildPartial() {
            LanguageResult languageResult = new LanguageResult(this, null);
            buildPartialRepeatedFields(languageResult);
            if (this.bitField0_ != 0) {
                buildPartial0(languageResult);
            }
            onBuilt();
            return languageResult;
        }

        private void buildPartialRepeatedFields(LanguageResult languageResult) {
            RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> repeatedFieldBuilder = this.languagesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.languages_ = Collections.unmodifiableList(this.languages_);
                    this.bitField0_ &= -2;
                }
                languageResult.languages_ = this.languages_;
                return;
            }
            languageResult.languages_ = repeatedFieldBuilder.build();
        }

        private void ensureLanguagesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.languages_ = new ArrayList(this.languages_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.LanguageResultOrBuilder
        public List<Language> getLanguagesList() {
            RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> repeatedFieldBuilder = this.languagesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.languages_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.LanguageResultOrBuilder
        public int getLanguagesCount() {
            RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> repeatedFieldBuilder = this.languagesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.languages_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.LanguageResultOrBuilder
        public Language getLanguages(int i) {
            RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> repeatedFieldBuilder = this.languagesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.languages_.get(i);
            }
            return (Language) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setLanguages(int i, Language language) {
            RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> repeatedFieldBuilder = this.languagesBuilder_;
            if (repeatedFieldBuilder == null) {
                language.getClass();
                ensureLanguagesIsMutable();
                this.languages_.set(i, language);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, language);
            return this;
        }

        public Builder setLanguages(int i, Language.Builder builder) {
            RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> repeatedFieldBuilder = this.languagesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguagesIsMutable();
                this.languages_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addLanguages(Language language) {
            RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> repeatedFieldBuilder = this.languagesBuilder_;
            if (repeatedFieldBuilder == null) {
                language.getClass();
                ensureLanguagesIsMutable();
                this.languages_.add(language);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(language);
            return this;
        }

        public Builder addLanguages(int i, Language language) {
            RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> repeatedFieldBuilder = this.languagesBuilder_;
            if (repeatedFieldBuilder == null) {
                language.getClass();
                ensureLanguagesIsMutable();
                this.languages_.add(i, language);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, language);
            return this;
        }

        public Builder addLanguages(Language.Builder builder) {
            RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> repeatedFieldBuilder = this.languagesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguagesIsMutable();
                this.languages_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addLanguages(int i, Language.Builder builder) {
            RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> repeatedFieldBuilder = this.languagesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguagesIsMutable();
                this.languages_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllLanguages(Iterable<? extends Language> iterable) {
            RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> repeatedFieldBuilder = this.languagesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguagesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.languages_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearLanguages() {
            RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> repeatedFieldBuilder = this.languagesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.languages_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeLanguages(int i) {
            RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> repeatedFieldBuilder = this.languagesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguagesIsMutable();
                this.languages_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Language.Builder getLanguagesBuilder(int i) {
            return (Language.Builder) getLanguagesFieldBuilder().getBuilder(i);
        }

        @Override // proto.LanguageResultOrBuilder
        public LanguageOrBuilder getLanguagesOrBuilder(int i) {
            RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> repeatedFieldBuilder = this.languagesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.languages_.get(i);
            }
            return (LanguageOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.LanguageResultOrBuilder
        public List<? extends LanguageOrBuilder> getLanguagesOrBuilderList() {
            RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> repeatedFieldBuilder = this.languagesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.languages_);
        }

        public Language.Builder addLanguagesBuilder() {
            return (Language.Builder) getLanguagesFieldBuilder().addBuilder(Language.getDefaultInstance());
        }

        public Language.Builder addLanguagesBuilder(int i) {
            return (Language.Builder) getLanguagesFieldBuilder().addBuilder(i, Language.getDefaultInstance());
        }

        public List<Language.Builder> getLanguagesBuilderList() {
            return getLanguagesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Language, Language.Builder, LanguageOrBuilder> getLanguagesFieldBuilder() {
            if (this.languagesBuilder_ == null) {
                this.languagesBuilder_ = new RepeatedFieldBuilder<>(this.languages_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.languages_ = null;
            }
            return this.languagesBuilder_;
        }
    }

    public static LanguageResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.LanguageResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<LanguageResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public LanguageResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = LanguageResult.newBuilder();
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

    public static Parser<LanguageResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<LanguageResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public LanguageResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
