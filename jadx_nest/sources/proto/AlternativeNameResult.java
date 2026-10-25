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
public final class AlternativeNameResult extends GeneratedMessage implements AlternativeNameResultOrBuilder {
    public static final int ALTERNATIVENAMES_FIELD_NUMBER = 1;
    private static final AlternativeNameResult DEFAULT_INSTANCE;
    private static final Parser<AlternativeNameResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<AlternativeName> alternativenames_;

    /* synthetic */ AlternativeNameResult(GeneratedMessage.Builder builder, AlternativeNameResultIA alternativeNameResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", AlternativeNameResult.class.getName());
        DEFAULT_INSTANCE = new AlternativeNameResult();
        PARSER = new AnonymousClass1();
    }

    private AlternativeNameResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private AlternativeNameResult() {
        this.alternativenames_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_AlternativeNameResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_AlternativeNameResult_fieldAccessorTable.ensureFieldAccessorsInitialized(AlternativeNameResult.class, Builder.class);
    }

    @Override // proto.AlternativeNameResultOrBuilder
    public List<AlternativeName> getAlternativenamesList() {
        return this.alternativenames_;
    }

    @Override // proto.AlternativeNameResultOrBuilder
    public List<? extends AlternativeNameOrBuilder> getAlternativenamesOrBuilderList() {
        return this.alternativenames_;
    }

    @Override // proto.AlternativeNameResultOrBuilder
    public int getAlternativenamesCount() {
        return this.alternativenames_.size();
    }

    @Override // proto.AlternativeNameResultOrBuilder
    public AlternativeName getAlternativenames(int i) {
        return this.alternativenames_.get(i);
    }

    @Override // proto.AlternativeNameResultOrBuilder
    public AlternativeNameOrBuilder getAlternativenamesOrBuilder(int i) {
        return this.alternativenames_.get(i);
    }

    public static AlternativeNameResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static AlternativeNameResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static AlternativeNameResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static AlternativeNameResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static AlternativeNameResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static AlternativeNameResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static AlternativeNameResult parseFrom(InputStream inputStream) throws IOException {
        return (AlternativeNameResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static AlternativeNameResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AlternativeNameResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AlternativeNameResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AlternativeNameResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static AlternativeNameResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AlternativeNameResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AlternativeNameResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AlternativeNameResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static AlternativeNameResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AlternativeNameResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(AlternativeNameResult alternativeNameResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) alternativeNameResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((AlternativeNameResultIA) null) : (Builder) new Builder((AlternativeNameResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements AlternativeNameResultOrBuilder {
        private RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> alternativenamesBuilder_;
        private List<AlternativeName> alternativenames_;
        private int bitField0_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, AlternativeNameResultIA alternativeNameResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(AlternativeNameResultIA alternativeNameResultIA) {
            this();
        }

        private void buildPartial0(AlternativeNameResult alternativeNameResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_AlternativeNameResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_AlternativeNameResult_fieldAccessorTable.ensureFieldAccessorsInitialized(AlternativeNameResult.class, Builder.class);
        }

        private Builder() {
            this.alternativenames_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.alternativenames_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativenamesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.alternativenames_ = Collections.emptyList();
            } else {
                this.alternativenames_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_AlternativeNameResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AlternativeNameResult getDefaultInstanceForType() {
            return AlternativeNameResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AlternativeNameResult build() {
            AlternativeNameResult alternativeNameResultBuildPartial = buildPartial();
            if (alternativeNameResultBuildPartial.isInitialized()) {
                return alternativeNameResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) alternativeNameResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AlternativeNameResult buildPartial() {
            AlternativeNameResult alternativeNameResult = new AlternativeNameResult(this, null);
            buildPartialRepeatedFields(alternativeNameResult);
            if (this.bitField0_ != 0) {
                buildPartial0(alternativeNameResult);
            }
            onBuilt();
            return alternativeNameResult;
        }

        private void buildPartialRepeatedFields(AlternativeNameResult alternativeNameResult) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativenamesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.alternativenames_ = Collections.unmodifiableList(this.alternativenames_);
                    this.bitField0_ &= -2;
                }
                alternativeNameResult.alternativenames_ = this.alternativenames_;
                return;
            }
            alternativeNameResult.alternativenames_ = repeatedFieldBuilder.build();
        }

        private void ensureAlternativenamesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.alternativenames_ = new ArrayList(this.alternativenames_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.AlternativeNameResultOrBuilder
        public List<AlternativeName> getAlternativenamesList() {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativenamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.alternativenames_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.AlternativeNameResultOrBuilder
        public int getAlternativenamesCount() {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativenamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.alternativenames_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.AlternativeNameResultOrBuilder
        public AlternativeName getAlternativenames(int i) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativenamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.alternativenames_.get(i);
            }
            return (AlternativeName) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setAlternativenames(int i, AlternativeName alternativeName) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativenamesBuilder_;
            if (repeatedFieldBuilder == null) {
                alternativeName.getClass();
                ensureAlternativenamesIsMutable();
                this.alternativenames_.set(i, alternativeName);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, alternativeName);
            return this;
        }

        public Builder setAlternativenames(int i, AlternativeName.Builder builder) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativenamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAlternativenamesIsMutable();
                this.alternativenames_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addAlternativenames(AlternativeName alternativeName) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativenamesBuilder_;
            if (repeatedFieldBuilder == null) {
                alternativeName.getClass();
                ensureAlternativenamesIsMutable();
                this.alternativenames_.add(alternativeName);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(alternativeName);
            return this;
        }

        public Builder addAlternativenames(int i, AlternativeName alternativeName) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativenamesBuilder_;
            if (repeatedFieldBuilder == null) {
                alternativeName.getClass();
                ensureAlternativenamesIsMutable();
                this.alternativenames_.add(i, alternativeName);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, alternativeName);
            return this;
        }

        public Builder addAlternativenames(AlternativeName.Builder builder) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativenamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAlternativenamesIsMutable();
                this.alternativenames_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addAlternativenames(int i, AlternativeName.Builder builder) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativenamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAlternativenamesIsMutable();
                this.alternativenames_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllAlternativenames(Iterable<? extends AlternativeName> iterable) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativenamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAlternativenamesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.alternativenames_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearAlternativenames() {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativenamesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.alternativenames_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeAlternativenames(int i) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativenamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAlternativenamesIsMutable();
                this.alternativenames_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public AlternativeName.Builder getAlternativenamesBuilder(int i) {
            return (AlternativeName.Builder) getAlternativenamesFieldBuilder().getBuilder(i);
        }

        @Override // proto.AlternativeNameResultOrBuilder
        public AlternativeNameOrBuilder getAlternativenamesOrBuilder(int i) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativenamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.alternativenames_.get(i);
            }
            return (AlternativeNameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.AlternativeNameResultOrBuilder
        public List<? extends AlternativeNameOrBuilder> getAlternativenamesOrBuilderList() {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativenamesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.alternativenames_);
        }

        public AlternativeName.Builder addAlternativenamesBuilder() {
            return (AlternativeName.Builder) getAlternativenamesFieldBuilder().addBuilder(AlternativeName.getDefaultInstance());
        }

        public AlternativeName.Builder addAlternativenamesBuilder(int i) {
            return (AlternativeName.Builder) getAlternativenamesFieldBuilder().addBuilder(i, AlternativeName.getDefaultInstance());
        }

        public List<AlternativeName.Builder> getAlternativenamesBuilderList() {
            return getAlternativenamesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> getAlternativenamesFieldBuilder() {
            if (this.alternativenamesBuilder_ == null) {
                this.alternativenamesBuilder_ = new RepeatedFieldBuilder<>(this.alternativenames_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.alternativenames_ = null;
            }
            return this.alternativenamesBuilder_;
        }
    }

    public static AlternativeNameResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.AlternativeNameResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<AlternativeNameResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public AlternativeNameResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = AlternativeNameResult.newBuilder();
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

    public static Parser<AlternativeNameResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AlternativeNameResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public AlternativeNameResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
