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
public final class LanguageSupportTypeResult extends GeneratedMessage implements LanguageSupportTypeResultOrBuilder {
    private static final LanguageSupportTypeResult DEFAULT_INSTANCE;
    public static final int LANGUAGESUPPORTTYPES_FIELD_NUMBER = 1;
    private static final Parser<LanguageSupportTypeResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<LanguageSupportType> languagesupporttypes_;

    /* synthetic */ LanguageSupportTypeResult(GeneratedMessage.Builder builder, LanguageSupportTypeResultIA languageSupportTypeResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", LanguageSupportTypeResult.class.getName());
        DEFAULT_INSTANCE = new LanguageSupportTypeResult();
        PARSER = new AnonymousClass1();
    }

    private LanguageSupportTypeResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private LanguageSupportTypeResult() {
        this.languagesupporttypes_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_LanguageSupportTypeResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_LanguageSupportTypeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(LanguageSupportTypeResult.class, Builder.class);
    }

    @Override // proto.LanguageSupportTypeResultOrBuilder
    public List<LanguageSupportType> getLanguagesupporttypesList() {
        return this.languagesupporttypes_;
    }

    @Override // proto.LanguageSupportTypeResultOrBuilder
    public List<? extends LanguageSupportTypeOrBuilder> getLanguagesupporttypesOrBuilderList() {
        return this.languagesupporttypes_;
    }

    @Override // proto.LanguageSupportTypeResultOrBuilder
    public int getLanguagesupporttypesCount() {
        return this.languagesupporttypes_.size();
    }

    @Override // proto.LanguageSupportTypeResultOrBuilder
    public LanguageSupportType getLanguagesupporttypes(int i) {
        return this.languagesupporttypes_.get(i);
    }

    @Override // proto.LanguageSupportTypeResultOrBuilder
    public LanguageSupportTypeOrBuilder getLanguagesupporttypesOrBuilder(int i) {
        return this.languagesupporttypes_.get(i);
    }

    public static LanguageSupportTypeResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static LanguageSupportTypeResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LanguageSupportTypeResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static LanguageSupportTypeResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LanguageSupportTypeResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LanguageSupportTypeResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static LanguageSupportTypeResult parseFrom(InputStream inputStream) throws IOException {
        return (LanguageSupportTypeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static LanguageSupportTypeResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LanguageSupportTypeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LanguageSupportTypeResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LanguageSupportTypeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LanguageSupportTypeResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LanguageSupportTypeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LanguageSupportTypeResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LanguageSupportTypeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static LanguageSupportTypeResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LanguageSupportTypeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(LanguageSupportTypeResult languageSupportTypeResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) languageSupportTypeResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((LanguageSupportTypeResultIA) null) : (Builder) new Builder((LanguageSupportTypeResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements LanguageSupportTypeResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> languagesupporttypesBuilder_;
        private List<LanguageSupportType> languagesupporttypes_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, LanguageSupportTypeResultIA languageSupportTypeResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(LanguageSupportTypeResultIA languageSupportTypeResultIA) {
            this();
        }

        private void buildPartial0(LanguageSupportTypeResult languageSupportTypeResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_LanguageSupportTypeResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_LanguageSupportTypeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(LanguageSupportTypeResult.class, Builder.class);
        }

        private Builder() {
            this.languagesupporttypes_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.languagesupporttypes_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> repeatedFieldBuilder = this.languagesupporttypesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.languagesupporttypes_ = Collections.emptyList();
            } else {
                this.languagesupporttypes_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_LanguageSupportTypeResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LanguageSupportTypeResult getDefaultInstanceForType() {
            return LanguageSupportTypeResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LanguageSupportTypeResult build() {
            LanguageSupportTypeResult languageSupportTypeResultBuildPartial = buildPartial();
            if (languageSupportTypeResultBuildPartial.isInitialized()) {
                return languageSupportTypeResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) languageSupportTypeResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LanguageSupportTypeResult buildPartial() {
            LanguageSupportTypeResult languageSupportTypeResult = new LanguageSupportTypeResult(this, null);
            buildPartialRepeatedFields(languageSupportTypeResult);
            if (this.bitField0_ != 0) {
                buildPartial0(languageSupportTypeResult);
            }
            onBuilt();
            return languageSupportTypeResult;
        }

        private void buildPartialRepeatedFields(LanguageSupportTypeResult languageSupportTypeResult) {
            RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> repeatedFieldBuilder = this.languagesupporttypesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.languagesupporttypes_ = Collections.unmodifiableList(this.languagesupporttypes_);
                    this.bitField0_ &= -2;
                }
                languageSupportTypeResult.languagesupporttypes_ = this.languagesupporttypes_;
                return;
            }
            languageSupportTypeResult.languagesupporttypes_ = repeatedFieldBuilder.build();
        }

        private void ensureLanguagesupporttypesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.languagesupporttypes_ = new ArrayList(this.languagesupporttypes_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.LanguageSupportTypeResultOrBuilder
        public List<LanguageSupportType> getLanguagesupporttypesList() {
            RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> repeatedFieldBuilder = this.languagesupporttypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.languagesupporttypes_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.LanguageSupportTypeResultOrBuilder
        public int getLanguagesupporttypesCount() {
            RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> repeatedFieldBuilder = this.languagesupporttypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.languagesupporttypes_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.LanguageSupportTypeResultOrBuilder
        public LanguageSupportType getLanguagesupporttypes(int i) {
            RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> repeatedFieldBuilder = this.languagesupporttypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.languagesupporttypes_.get(i);
            }
            return (LanguageSupportType) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setLanguagesupporttypes(int i, LanguageSupportType languageSupportType) {
            RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> repeatedFieldBuilder = this.languagesupporttypesBuilder_;
            if (repeatedFieldBuilder == null) {
                languageSupportType.getClass();
                ensureLanguagesupporttypesIsMutable();
                this.languagesupporttypes_.set(i, languageSupportType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, languageSupportType);
            return this;
        }

        public Builder setLanguagesupporttypes(int i, LanguageSupportType.Builder builder) {
            RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> repeatedFieldBuilder = this.languagesupporttypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguagesupporttypesIsMutable();
                this.languagesupporttypes_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addLanguagesupporttypes(LanguageSupportType languageSupportType) {
            RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> repeatedFieldBuilder = this.languagesupporttypesBuilder_;
            if (repeatedFieldBuilder == null) {
                languageSupportType.getClass();
                ensureLanguagesupporttypesIsMutable();
                this.languagesupporttypes_.add(languageSupportType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(languageSupportType);
            return this;
        }

        public Builder addLanguagesupporttypes(int i, LanguageSupportType languageSupportType) {
            RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> repeatedFieldBuilder = this.languagesupporttypesBuilder_;
            if (repeatedFieldBuilder == null) {
                languageSupportType.getClass();
                ensureLanguagesupporttypesIsMutable();
                this.languagesupporttypes_.add(i, languageSupportType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, languageSupportType);
            return this;
        }

        public Builder addLanguagesupporttypes(LanguageSupportType.Builder builder) {
            RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> repeatedFieldBuilder = this.languagesupporttypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguagesupporttypesIsMutable();
                this.languagesupporttypes_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addLanguagesupporttypes(int i, LanguageSupportType.Builder builder) {
            RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> repeatedFieldBuilder = this.languagesupporttypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguagesupporttypesIsMutable();
                this.languagesupporttypes_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllLanguagesupporttypes(Iterable<? extends LanguageSupportType> iterable) {
            RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> repeatedFieldBuilder = this.languagesupporttypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguagesupporttypesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.languagesupporttypes_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearLanguagesupporttypes() {
            RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> repeatedFieldBuilder = this.languagesupporttypesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.languagesupporttypes_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeLanguagesupporttypes(int i) {
            RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> repeatedFieldBuilder = this.languagesupporttypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguagesupporttypesIsMutable();
                this.languagesupporttypes_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public LanguageSupportType.Builder getLanguagesupporttypesBuilder(int i) {
            return (LanguageSupportType.Builder) getLanguagesupporttypesFieldBuilder().getBuilder(i);
        }

        @Override // proto.LanguageSupportTypeResultOrBuilder
        public LanguageSupportTypeOrBuilder getLanguagesupporttypesOrBuilder(int i) {
            RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> repeatedFieldBuilder = this.languagesupporttypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.languagesupporttypes_.get(i);
            }
            return (LanguageSupportTypeOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.LanguageSupportTypeResultOrBuilder
        public List<? extends LanguageSupportTypeOrBuilder> getLanguagesupporttypesOrBuilderList() {
            RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> repeatedFieldBuilder = this.languagesupporttypesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.languagesupporttypes_);
        }

        public LanguageSupportType.Builder addLanguagesupporttypesBuilder() {
            return (LanguageSupportType.Builder) getLanguagesupporttypesFieldBuilder().addBuilder(LanguageSupportType.getDefaultInstance());
        }

        public LanguageSupportType.Builder addLanguagesupporttypesBuilder(int i) {
            return (LanguageSupportType.Builder) getLanguagesupporttypesFieldBuilder().addBuilder(i, LanguageSupportType.getDefaultInstance());
        }

        public List<LanguageSupportType.Builder> getLanguagesupporttypesBuilderList() {
            return getLanguagesupporttypesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<LanguageSupportType, LanguageSupportType.Builder, LanguageSupportTypeOrBuilder> getLanguagesupporttypesFieldBuilder() {
            if (this.languagesupporttypesBuilder_ == null) {
                this.languagesupporttypesBuilder_ = new RepeatedFieldBuilder<>(this.languagesupporttypes_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.languagesupporttypes_ = null;
            }
            return this.languagesupporttypesBuilder_;
        }
    }

    public static LanguageSupportTypeResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.LanguageSupportTypeResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<LanguageSupportTypeResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public LanguageSupportTypeResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = LanguageSupportTypeResult.newBuilder();
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

    public static Parser<LanguageSupportTypeResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<LanguageSupportTypeResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public LanguageSupportTypeResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
