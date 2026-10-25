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
public final class PopularityPrimitiveResult extends GeneratedMessage implements PopularityPrimitiveResultOrBuilder {
    private static final PopularityPrimitiveResult DEFAULT_INSTANCE;
    private static final Parser<PopularityPrimitiveResult> PARSER;
    public static final int POPULARITYPRIMITIVES_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<PopularityPrimitive> popularityprimitives_;

    /* synthetic */ PopularityPrimitiveResult(GeneratedMessage.Builder builder, PopularityPrimitiveResultIA popularityPrimitiveResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", PopularityPrimitiveResult.class.getName());
        DEFAULT_INSTANCE = new PopularityPrimitiveResult();
        PARSER = new AnonymousClass1();
    }

    private PopularityPrimitiveResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private PopularityPrimitiveResult() {
        this.popularityprimitives_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_PopularityPrimitiveResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_PopularityPrimitiveResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PopularityPrimitiveResult.class, Builder.class);
    }

    @Override // proto.PopularityPrimitiveResultOrBuilder
    public List<PopularityPrimitive> getPopularityprimitivesList() {
        return this.popularityprimitives_;
    }

    @Override // proto.PopularityPrimitiveResultOrBuilder
    public List<? extends PopularityPrimitiveOrBuilder> getPopularityprimitivesOrBuilderList() {
        return this.popularityprimitives_;
    }

    @Override // proto.PopularityPrimitiveResultOrBuilder
    public int getPopularityprimitivesCount() {
        return this.popularityprimitives_.size();
    }

    @Override // proto.PopularityPrimitiveResultOrBuilder
    public PopularityPrimitive getPopularityprimitives(int i) {
        return this.popularityprimitives_.get(i);
    }

    @Override // proto.PopularityPrimitiveResultOrBuilder
    public PopularityPrimitiveOrBuilder getPopularityprimitivesOrBuilder(int i) {
        return this.popularityprimitives_.get(i);
    }

    public static PopularityPrimitiveResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PopularityPrimitiveResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PopularityPrimitiveResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PopularityPrimitiveResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PopularityPrimitiveResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PopularityPrimitiveResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static PopularityPrimitiveResult parseFrom(InputStream inputStream) throws IOException {
        return (PopularityPrimitiveResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static PopularityPrimitiveResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PopularityPrimitiveResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PopularityPrimitiveResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PopularityPrimitiveResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PopularityPrimitiveResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PopularityPrimitiveResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PopularityPrimitiveResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PopularityPrimitiveResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static PopularityPrimitiveResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PopularityPrimitiveResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(PopularityPrimitiveResult popularityPrimitiveResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) popularityPrimitiveResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((PopularityPrimitiveResultIA) null) : (Builder) new Builder((PopularityPrimitiveResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements PopularityPrimitiveResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> popularityprimitivesBuilder_;
        private List<PopularityPrimitive> popularityprimitives_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, PopularityPrimitiveResultIA popularityPrimitiveResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(PopularityPrimitiveResultIA popularityPrimitiveResultIA) {
            this();
        }

        private void buildPartial0(PopularityPrimitiveResult popularityPrimitiveResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_PopularityPrimitiveResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_PopularityPrimitiveResult_fieldAccessorTable.ensureFieldAccessorsInitialized(PopularityPrimitiveResult.class, Builder.class);
        }

        private Builder() {
            this.popularityprimitives_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.popularityprimitives_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> repeatedFieldBuilder = this.popularityprimitivesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.popularityprimitives_ = Collections.emptyList();
            } else {
                this.popularityprimitives_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_PopularityPrimitiveResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PopularityPrimitiveResult getDefaultInstanceForType() {
            return PopularityPrimitiveResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PopularityPrimitiveResult build() {
            PopularityPrimitiveResult popularityPrimitiveResultBuildPartial = buildPartial();
            if (popularityPrimitiveResultBuildPartial.isInitialized()) {
                return popularityPrimitiveResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) popularityPrimitiveResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PopularityPrimitiveResult buildPartial() {
            PopularityPrimitiveResult popularityPrimitiveResult = new PopularityPrimitiveResult(this, null);
            buildPartialRepeatedFields(popularityPrimitiveResult);
            if (this.bitField0_ != 0) {
                buildPartial0(popularityPrimitiveResult);
            }
            onBuilt();
            return popularityPrimitiveResult;
        }

        private void buildPartialRepeatedFields(PopularityPrimitiveResult popularityPrimitiveResult) {
            RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> repeatedFieldBuilder = this.popularityprimitivesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.popularityprimitives_ = Collections.unmodifiableList(this.popularityprimitives_);
                    this.bitField0_ &= -2;
                }
                popularityPrimitiveResult.popularityprimitives_ = this.popularityprimitives_;
                return;
            }
            popularityPrimitiveResult.popularityprimitives_ = repeatedFieldBuilder.build();
        }

        private void ensurePopularityprimitivesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.popularityprimitives_ = new ArrayList(this.popularityprimitives_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.PopularityPrimitiveResultOrBuilder
        public List<PopularityPrimitive> getPopularityprimitivesList() {
            RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> repeatedFieldBuilder = this.popularityprimitivesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.popularityprimitives_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.PopularityPrimitiveResultOrBuilder
        public int getPopularityprimitivesCount() {
            RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> repeatedFieldBuilder = this.popularityprimitivesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.popularityprimitives_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.PopularityPrimitiveResultOrBuilder
        public PopularityPrimitive getPopularityprimitives(int i) {
            RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> repeatedFieldBuilder = this.popularityprimitivesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.popularityprimitives_.get(i);
            }
            return (PopularityPrimitive) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setPopularityprimitives(int i, PopularityPrimitive popularityPrimitive) {
            RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> repeatedFieldBuilder = this.popularityprimitivesBuilder_;
            if (repeatedFieldBuilder == null) {
                popularityPrimitive.getClass();
                ensurePopularityprimitivesIsMutable();
                this.popularityprimitives_.set(i, popularityPrimitive);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, popularityPrimitive);
            return this;
        }

        public Builder setPopularityprimitives(int i, PopularityPrimitive.Builder builder) {
            RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> repeatedFieldBuilder = this.popularityprimitivesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePopularityprimitivesIsMutable();
                this.popularityprimitives_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addPopularityprimitives(PopularityPrimitive popularityPrimitive) {
            RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> repeatedFieldBuilder = this.popularityprimitivesBuilder_;
            if (repeatedFieldBuilder == null) {
                popularityPrimitive.getClass();
                ensurePopularityprimitivesIsMutable();
                this.popularityprimitives_.add(popularityPrimitive);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(popularityPrimitive);
            return this;
        }

        public Builder addPopularityprimitives(int i, PopularityPrimitive popularityPrimitive) {
            RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> repeatedFieldBuilder = this.popularityprimitivesBuilder_;
            if (repeatedFieldBuilder == null) {
                popularityPrimitive.getClass();
                ensurePopularityprimitivesIsMutable();
                this.popularityprimitives_.add(i, popularityPrimitive);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, popularityPrimitive);
            return this;
        }

        public Builder addPopularityprimitives(PopularityPrimitive.Builder builder) {
            RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> repeatedFieldBuilder = this.popularityprimitivesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePopularityprimitivesIsMutable();
                this.popularityprimitives_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addPopularityprimitives(int i, PopularityPrimitive.Builder builder) {
            RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> repeatedFieldBuilder = this.popularityprimitivesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePopularityprimitivesIsMutable();
                this.popularityprimitives_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllPopularityprimitives(Iterable<? extends PopularityPrimitive> iterable) {
            RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> repeatedFieldBuilder = this.popularityprimitivesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePopularityprimitivesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.popularityprimitives_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearPopularityprimitives() {
            RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> repeatedFieldBuilder = this.popularityprimitivesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.popularityprimitives_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removePopularityprimitives(int i) {
            RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> repeatedFieldBuilder = this.popularityprimitivesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePopularityprimitivesIsMutable();
                this.popularityprimitives_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public PopularityPrimitive.Builder getPopularityprimitivesBuilder(int i) {
            return (PopularityPrimitive.Builder) getPopularityprimitivesFieldBuilder().getBuilder(i);
        }

        @Override // proto.PopularityPrimitiveResultOrBuilder
        public PopularityPrimitiveOrBuilder getPopularityprimitivesOrBuilder(int i) {
            RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> repeatedFieldBuilder = this.popularityprimitivesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.popularityprimitives_.get(i);
            }
            return (PopularityPrimitiveOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.PopularityPrimitiveResultOrBuilder
        public List<? extends PopularityPrimitiveOrBuilder> getPopularityprimitivesOrBuilderList() {
            RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> repeatedFieldBuilder = this.popularityprimitivesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.popularityprimitives_);
        }

        public PopularityPrimitive.Builder addPopularityprimitivesBuilder() {
            return (PopularityPrimitive.Builder) getPopularityprimitivesFieldBuilder().addBuilder(PopularityPrimitive.getDefaultInstance());
        }

        public PopularityPrimitive.Builder addPopularityprimitivesBuilder(int i) {
            return (PopularityPrimitive.Builder) getPopularityprimitivesFieldBuilder().addBuilder(i, PopularityPrimitive.getDefaultInstance());
        }

        public List<PopularityPrimitive.Builder> getPopularityprimitivesBuilderList() {
            return getPopularityprimitivesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<PopularityPrimitive, PopularityPrimitive.Builder, PopularityPrimitiveOrBuilder> getPopularityprimitivesFieldBuilder() {
            if (this.popularityprimitivesBuilder_ == null) {
                this.popularityprimitivesBuilder_ = new RepeatedFieldBuilder<>(this.popularityprimitives_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.popularityprimitives_ = null;
            }
            return this.popularityprimitivesBuilder_;
        }
    }

    public static PopularityPrimitiveResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.PopularityPrimitiveResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<PopularityPrimitiveResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public PopularityPrimitiveResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = PopularityPrimitiveResult.newBuilder();
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

    public static Parser<PopularityPrimitiveResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PopularityPrimitiveResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PopularityPrimitiveResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
