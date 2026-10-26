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
public final class KeywordResult extends GeneratedMessage implements KeywordResultOrBuilder {
    private static final KeywordResult DEFAULT_INSTANCE;
    public static final int KEYWORDS_FIELD_NUMBER = 1;
    private static final Parser<KeywordResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<Keyword> keywords_;

    /* synthetic */ KeywordResult(GeneratedMessage.Builder builder, KeywordResultIA keywordResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", KeywordResult.class.getName());
        DEFAULT_INSTANCE = new KeywordResult();
        PARSER = new AnonymousClass1();
    }

    private KeywordResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private KeywordResult() {
        this.keywords_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_KeywordResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_KeywordResult_fieldAccessorTable.ensureFieldAccessorsInitialized(KeywordResult.class, Builder.class);
    }

    @Override // proto.KeywordResultOrBuilder
    public List<Keyword> getKeywordsList() {
        return this.keywords_;
    }

    @Override // proto.KeywordResultOrBuilder
    public List<? extends KeywordOrBuilder> getKeywordsOrBuilderList() {
        return this.keywords_;
    }

    @Override // proto.KeywordResultOrBuilder
    public int getKeywordsCount() {
        return this.keywords_.size();
    }

    @Override // proto.KeywordResultOrBuilder
    public Keyword getKeywords(int i) {
        return this.keywords_.get(i);
    }

    @Override // proto.KeywordResultOrBuilder
    public KeywordOrBuilder getKeywordsOrBuilder(int i) {
        return this.keywords_.get(i);
    }

    public static KeywordResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static KeywordResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static KeywordResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static KeywordResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static KeywordResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static KeywordResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static KeywordResult parseFrom(InputStream inputStream) throws IOException {
        return (KeywordResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static KeywordResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (KeywordResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static KeywordResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (KeywordResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static KeywordResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (KeywordResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static KeywordResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (KeywordResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static KeywordResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (KeywordResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(KeywordResult keywordResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) keywordResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((KeywordResultIA) null) : (Builder) new Builder((KeywordResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements KeywordResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> keywordsBuilder_;
        private List<Keyword> keywords_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, KeywordResultIA keywordResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(KeywordResultIA keywordResultIA) {
            this();
        }

        private void buildPartial0(KeywordResult keywordResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_KeywordResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_KeywordResult_fieldAccessorTable.ensureFieldAccessorsInitialized(KeywordResult.class, Builder.class);
        }

        private Builder() {
            this.keywords_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.keywords_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.keywords_ = Collections.emptyList();
            } else {
                this.keywords_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_KeywordResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public KeywordResult getDefaultInstanceForType() {
            return KeywordResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public KeywordResult build() {
            KeywordResult keywordResultBuildPartial = buildPartial();
            if (keywordResultBuildPartial.isInitialized()) {
                return keywordResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) keywordResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public KeywordResult buildPartial() {
            KeywordResult keywordResult = new KeywordResult(this, null);
            buildPartialRepeatedFields(keywordResult);
            if (this.bitField0_ != 0) {
                buildPartial0(keywordResult);
            }
            onBuilt();
            return keywordResult;
        }

        private void buildPartialRepeatedFields(KeywordResult keywordResult) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.keywords_ = Collections.unmodifiableList(this.keywords_);
                    this.bitField0_ &= -2;
                }
                keywordResult.keywords_ = this.keywords_;
                return;
            }
            keywordResult.keywords_ = repeatedFieldBuilder.build();
        }

        private void ensureKeywordsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.keywords_ = new ArrayList(this.keywords_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.KeywordResultOrBuilder
        public List<Keyword> getKeywordsList() {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.keywords_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.KeywordResultOrBuilder
        public int getKeywordsCount() {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.keywords_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.KeywordResultOrBuilder
        public Keyword getKeywords(int i) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.keywords_.get(i);
            }
            return (Keyword) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setKeywords(int i, Keyword keyword) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                keyword.getClass();
                ensureKeywordsIsMutable();
                this.keywords_.set(i, keyword);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, keyword);
            return this;
        }

        public Builder setKeywords(int i, Keyword.Builder builder) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureKeywordsIsMutable();
                this.keywords_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addKeywords(Keyword keyword) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                keyword.getClass();
                ensureKeywordsIsMutable();
                this.keywords_.add(keyword);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(keyword);
            return this;
        }

        public Builder addKeywords(int i, Keyword keyword) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                keyword.getClass();
                ensureKeywordsIsMutable();
                this.keywords_.add(i, keyword);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, keyword);
            return this;
        }

        public Builder addKeywords(Keyword.Builder builder) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureKeywordsIsMutable();
                this.keywords_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addKeywords(int i, Keyword.Builder builder) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureKeywordsIsMutable();
                this.keywords_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllKeywords(Iterable<? extends Keyword> iterable) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureKeywordsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.keywords_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearKeywords() {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.keywords_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeKeywords(int i) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureKeywordsIsMutable();
                this.keywords_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Keyword.Builder getKeywordsBuilder(int i) {
            return (Keyword.Builder) getKeywordsFieldBuilder().getBuilder(i);
        }

        @Override // proto.KeywordResultOrBuilder
        public KeywordOrBuilder getKeywordsOrBuilder(int i) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.keywords_.get(i);
            }
            return (KeywordOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.KeywordResultOrBuilder
        public List<? extends KeywordOrBuilder> getKeywordsOrBuilderList() {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.keywords_);
        }

        public Keyword.Builder addKeywordsBuilder() {
            return (Keyword.Builder) getKeywordsFieldBuilder().addBuilder(Keyword.getDefaultInstance());
        }

        public Keyword.Builder addKeywordsBuilder(int i) {
            return (Keyword.Builder) getKeywordsFieldBuilder().addBuilder(i, Keyword.getDefaultInstance());
        }

        public List<Keyword.Builder> getKeywordsBuilderList() {
            return getKeywordsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> getKeywordsFieldBuilder() {
            if (this.keywordsBuilder_ == null) {
                this.keywordsBuilder_ = new RepeatedFieldBuilder<>(this.keywords_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.keywords_ = null;
            }
            return this.keywordsBuilder_;
        }
    }

    public static KeywordResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.KeywordResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<KeywordResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public KeywordResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = KeywordResult.newBuilder();
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

    public static Parser<KeywordResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<KeywordResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public KeywordResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
