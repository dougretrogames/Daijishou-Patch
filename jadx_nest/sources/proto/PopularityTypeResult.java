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
public final class PopularityTypeResult extends GeneratedMessage implements PopularityTypeResultOrBuilder {
    private static final PopularityTypeResult DEFAULT_INSTANCE;
    private static final Parser<PopularityTypeResult> PARSER;
    public static final int POPULARITYTYPES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<PopularityType> popularitytypes_;

    /* synthetic */ PopularityTypeResult(GeneratedMessage.Builder builder, PopularityTypeResultIA popularityTypeResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PopularityTypeResult.class.getName());
        DEFAULT_INSTANCE = new PopularityTypeResult();
        PARSER = new AnonymousClass1();
    }

    private PopularityTypeResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private PopularityTypeResult() {
        this.popularitytypes_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_PopularityTypeResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_PopularityTypeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PopularityTypeResult.class, Builder.class);
    }

    @Override // proto.PopularityTypeResultOrBuilder
    public List<PopularityType> getPopularitytypesList() {
        return this.popularitytypes_;
    }

    @Override // proto.PopularityTypeResultOrBuilder
    public List<? extends PopularityTypeOrBuilder> getPopularitytypesOrBuilderList() {
        return this.popularitytypes_;
    }

    @Override // proto.PopularityTypeResultOrBuilder
    public int getPopularitytypesCount() {
        return this.popularitytypes_.size();
    }

    @Override // proto.PopularityTypeResultOrBuilder
    public PopularityType getPopularitytypes(int i) {
        return this.popularitytypes_.get(i);
    }

    @Override // proto.PopularityTypeResultOrBuilder
    public PopularityTypeOrBuilder getPopularitytypesOrBuilder(int i) {
        return this.popularitytypes_.get(i);
    }

    public static PopularityTypeResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PopularityTypeResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PopularityTypeResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PopularityTypeResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PopularityTypeResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PopularityTypeResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PopularityTypeResult parseFrom(InputStream inputStream) throws IOException {
        return (PopularityTypeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PopularityTypeResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PopularityTypeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PopularityTypeResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PopularityTypeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PopularityTypeResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PopularityTypeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PopularityTypeResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PopularityTypeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PopularityTypeResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PopularityTypeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(PopularityTypeResult popularityTypeResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) popularityTypeResult);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((PopularityTypeResultIA) null) : (Builder) new Builder((PopularityTypeResultIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PopularityTypeResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> popularitytypesBuilder_;
        private List<PopularityType> popularitytypes_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, PopularityTypeResultIA popularityTypeResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(PopularityTypeResultIA popularityTypeResultIA) {
            this();
        }

        private void buildPartial0(PopularityTypeResult popularityTypeResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_PopularityTypeResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_PopularityTypeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PopularityTypeResult.class, Builder.class);
        }

        private Builder() {
            this.popularitytypes_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.popularitytypes_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> repeatedFieldBuilder = this.popularitytypesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.popularitytypes_ = Collections.emptyList();
            } else {
                this.popularitytypes_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_PopularityTypeResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PopularityTypeResult getDefaultInstanceForType() {
            return PopularityTypeResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PopularityTypeResult build() {
            PopularityTypeResult popularityTypeResultBuildPartial = buildPartial();
            if (popularityTypeResultBuildPartial.isInitialized()) {
                return popularityTypeResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) popularityTypeResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PopularityTypeResult buildPartial() {
            PopularityTypeResult popularityTypeResult = new PopularityTypeResult(this, null);
            buildPartialRepeatedFields(popularityTypeResult);
            if (this.bitField0_ != 0) {
                buildPartial0(popularityTypeResult);
            }
            onBuilt();
            return popularityTypeResult;
        }

        private void buildPartialRepeatedFields(PopularityTypeResult popularityTypeResult) {
            RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> repeatedFieldBuilder = this.popularitytypesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.popularitytypes_ = Collections.unmodifiableList(this.popularitytypes_);
                    this.bitField0_ &= -2;
                }
                popularityTypeResult.popularitytypes_ = this.popularitytypes_;
                return;
            }
            popularityTypeResult.popularitytypes_ = repeatedFieldBuilder.build();
        }

        private void ensurePopularitytypesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.popularitytypes_ = new ArrayList(this.popularitytypes_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.PopularityTypeResultOrBuilder
        public List<PopularityType> getPopularitytypesList() {
            RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> repeatedFieldBuilder = this.popularitytypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.popularitytypes_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.PopularityTypeResultOrBuilder
        public int getPopularitytypesCount() {
            RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> repeatedFieldBuilder = this.popularitytypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.popularitytypes_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.PopularityTypeResultOrBuilder
        public PopularityType getPopularitytypes(int i) {
            RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> repeatedFieldBuilder = this.popularitytypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.popularitytypes_.get(i);
            }
            return (PopularityType) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setPopularitytypes(int i, PopularityType popularityType) {
            RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> repeatedFieldBuilder = this.popularitytypesBuilder_;
            if (repeatedFieldBuilder == null) {
                popularityType.getClass();
                ensurePopularitytypesIsMutable();
                this.popularitytypes_.set(i, popularityType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, popularityType);
            return this;
        }

        public Builder setPopularitytypes(int i, PopularityType.Builder builder) {
            RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> repeatedFieldBuilder = this.popularitytypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePopularitytypesIsMutable();
                this.popularitytypes_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addPopularitytypes(PopularityType popularityType) {
            RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> repeatedFieldBuilder = this.popularitytypesBuilder_;
            if (repeatedFieldBuilder == null) {
                popularityType.getClass();
                ensurePopularitytypesIsMutable();
                this.popularitytypes_.add(popularityType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(popularityType);
            return this;
        }

        public Builder addPopularitytypes(int i, PopularityType popularityType) {
            RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> repeatedFieldBuilder = this.popularitytypesBuilder_;
            if (repeatedFieldBuilder == null) {
                popularityType.getClass();
                ensurePopularitytypesIsMutable();
                this.popularitytypes_.add(i, popularityType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, popularityType);
            return this;
        }

        public Builder addPopularitytypes(PopularityType.Builder builder) {
            RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> repeatedFieldBuilder = this.popularitytypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePopularitytypesIsMutable();
                this.popularitytypes_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addPopularitytypes(int i, PopularityType.Builder builder) {
            RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> repeatedFieldBuilder = this.popularitytypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePopularitytypesIsMutable();
                this.popularitytypes_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllPopularitytypes(Iterable<? extends PopularityType> iterable) {
            RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> repeatedFieldBuilder = this.popularitytypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePopularitytypesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.popularitytypes_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearPopularitytypes() {
            RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> repeatedFieldBuilder = this.popularitytypesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.popularitytypes_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removePopularitytypes(int i) {
            RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> repeatedFieldBuilder = this.popularitytypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePopularitytypesIsMutable();
                this.popularitytypes_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public PopularityType.Builder getPopularitytypesBuilder(int i) {
            return (PopularityType.Builder) getPopularitytypesFieldBuilder().getBuilder(i);
        }

        @Override // proto.PopularityTypeResultOrBuilder
        public PopularityTypeOrBuilder getPopularitytypesOrBuilder(int i) {
            RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> repeatedFieldBuilder = this.popularitytypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.popularitytypes_.get(i);
            }
            return (PopularityTypeOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.PopularityTypeResultOrBuilder
        public List<? extends PopularityTypeOrBuilder> getPopularitytypesOrBuilderList() {
            RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> repeatedFieldBuilder = this.popularitytypesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.popularitytypes_);
        }

        public PopularityType.Builder addPopularitytypesBuilder() {
            return (PopularityType.Builder) getPopularitytypesFieldBuilder().addBuilder(PopularityType.getDefaultInstance());
        }

        public PopularityType.Builder addPopularitytypesBuilder(int i) {
            return (PopularityType.Builder) getPopularitytypesFieldBuilder().addBuilder(i, PopularityType.getDefaultInstance());
        }

        public List<PopularityType.Builder> getPopularitytypesBuilderList() {
            return getPopularitytypesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<PopularityType, PopularityType.Builder, PopularityTypeOrBuilder> getPopularitytypesFieldBuilder() {
            if (this.popularitytypesBuilder_ == null) {
                this.popularitytypesBuilder_ = new RepeatedFieldBuilder<>(this.popularitytypes_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.popularitytypes_ = null;
            }
            return this.popularitytypesBuilder_;
        }
    }

    public static PopularityTypeResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.PopularityTypeResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<PopularityTypeResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public PopularityTypeResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = PopularityTypeResult.newBuilder();
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

    public static Parser<PopularityTypeResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PopularityTypeResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PopularityTypeResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
