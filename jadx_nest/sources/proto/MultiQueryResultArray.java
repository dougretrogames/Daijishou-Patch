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
public final class MultiQueryResultArray extends GeneratedMessage implements MultiQueryResultArrayOrBuilder {
    private static final MultiQueryResultArray DEFAULT_INSTANCE;
    private static final Parser<MultiQueryResultArray> PARSER;
    public static final int RESULT_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<MultiQueryResult> result_;

    /* synthetic */ MultiQueryResultArray(GeneratedMessage.Builder builder, MultiQueryResultArrayIA multiQueryResultArrayIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", MultiQueryResultArray.class.getName());
        DEFAULT_INSTANCE = new MultiQueryResultArray();
        PARSER = new AnonymousClass1();
    }

    private MultiQueryResultArray(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private MultiQueryResultArray() {
        this.result_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_MultiQueryResultArray_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_MultiQueryResultArray_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiQueryResultArray.class, Builder.class);
    }

    @Override // proto.MultiQueryResultArrayOrBuilder
    public List<MultiQueryResult> getResultList() {
        return this.result_;
    }

    @Override // proto.MultiQueryResultArrayOrBuilder
    public List<? extends MultiQueryResultOrBuilder> getResultOrBuilderList() {
        return this.result_;
    }

    @Override // proto.MultiQueryResultArrayOrBuilder
    public int getResultCount() {
        return this.result_.size();
    }

    @Override // proto.MultiQueryResultArrayOrBuilder
    public MultiQueryResult getResult(int i) {
        return this.result_.get(i);
    }

    @Override // proto.MultiQueryResultArrayOrBuilder
    public MultiQueryResultOrBuilder getResultOrBuilder(int i) {
        return this.result_.get(i);
    }

    public static MultiQueryResultArray parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static MultiQueryResultArray parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static MultiQueryResultArray parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static MultiQueryResultArray parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static MultiQueryResultArray parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static MultiQueryResultArray parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static MultiQueryResultArray parseFrom(InputStream inputStream) throws IOException {
        return (MultiQueryResultArray) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static MultiQueryResultArray parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiQueryResultArray) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MultiQueryResultArray parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MultiQueryResultArray) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static MultiQueryResultArray parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiQueryResultArray) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MultiQueryResultArray parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MultiQueryResultArray) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static MultiQueryResultArray parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiQueryResultArray) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(MultiQueryResultArray multiQueryResultArray) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) multiQueryResultArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((MultiQueryResultArrayIA) null) : (Builder) new Builder((MultiQueryResultArrayIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements MultiQueryResultArrayOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> resultBuilder_;
        private List<MultiQueryResult> result_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, MultiQueryResultArrayIA multiQueryResultArrayIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(MultiQueryResultArrayIA multiQueryResultArrayIA) {
            this();
        }

        private void buildPartial0(MultiQueryResultArray multiQueryResultArray) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_MultiQueryResultArray_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_MultiQueryResultArray_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiQueryResultArray.class, Builder.class);
        }

        private Builder() {
            this.result_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.result_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> repeatedFieldBuilder = this.resultBuilder_;
            if (repeatedFieldBuilder == null) {
                this.result_ = Collections.emptyList();
            } else {
                this.result_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_MultiQueryResultArray_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MultiQueryResultArray getDefaultInstanceForType() {
            return MultiQueryResultArray.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MultiQueryResultArray build() {
            MultiQueryResultArray multiQueryResultArrayBuildPartial = buildPartial();
            if (multiQueryResultArrayBuildPartial.isInitialized()) {
                return multiQueryResultArrayBuildPartial;
            }
            throw newUninitializedMessageException((Message) multiQueryResultArrayBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MultiQueryResultArray buildPartial() {
            MultiQueryResultArray multiQueryResultArray = new MultiQueryResultArray(this, null);
            buildPartialRepeatedFields(multiQueryResultArray);
            if (this.bitField0_ != 0) {
                buildPartial0(multiQueryResultArray);
            }
            onBuilt();
            return multiQueryResultArray;
        }

        private void buildPartialRepeatedFields(MultiQueryResultArray multiQueryResultArray) {
            RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> repeatedFieldBuilder = this.resultBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.result_ = Collections.unmodifiableList(this.result_);
                    this.bitField0_ &= -2;
                }
                multiQueryResultArray.result_ = this.result_;
                return;
            }
            multiQueryResultArray.result_ = repeatedFieldBuilder.build();
        }

        private void ensureResultIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.result_ = new ArrayList(this.result_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.MultiQueryResultArrayOrBuilder
        public List<MultiQueryResult> getResultList() {
            RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> repeatedFieldBuilder = this.resultBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.result_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.MultiQueryResultArrayOrBuilder
        public int getResultCount() {
            RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> repeatedFieldBuilder = this.resultBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.result_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.MultiQueryResultArrayOrBuilder
        public MultiQueryResult getResult(int i) {
            RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> repeatedFieldBuilder = this.resultBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.result_.get(i);
            }
            return (MultiQueryResult) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setResult(int i, MultiQueryResult multiQueryResult) {
            RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> repeatedFieldBuilder = this.resultBuilder_;
            if (repeatedFieldBuilder == null) {
                multiQueryResult.getClass();
                ensureResultIsMutable();
                this.result_.set(i, multiQueryResult);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, multiQueryResult);
            return this;
        }

        public Builder setResult(int i, MultiQueryResult.Builder builder) {
            RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> repeatedFieldBuilder = this.resultBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureResultIsMutable();
                this.result_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addResult(MultiQueryResult multiQueryResult) {
            RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> repeatedFieldBuilder = this.resultBuilder_;
            if (repeatedFieldBuilder == null) {
                multiQueryResult.getClass();
                ensureResultIsMutable();
                this.result_.add(multiQueryResult);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(multiQueryResult);
            return this;
        }

        public Builder addResult(int i, MultiQueryResult multiQueryResult) {
            RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> repeatedFieldBuilder = this.resultBuilder_;
            if (repeatedFieldBuilder == null) {
                multiQueryResult.getClass();
                ensureResultIsMutable();
                this.result_.add(i, multiQueryResult);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, multiQueryResult);
            return this;
        }

        public Builder addResult(MultiQueryResult.Builder builder) {
            RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> repeatedFieldBuilder = this.resultBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureResultIsMutable();
                this.result_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addResult(int i, MultiQueryResult.Builder builder) {
            RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> repeatedFieldBuilder = this.resultBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureResultIsMutable();
                this.result_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllResult(Iterable<? extends MultiQueryResult> iterable) {
            RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> repeatedFieldBuilder = this.resultBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureResultIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.result_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearResult() {
            RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> repeatedFieldBuilder = this.resultBuilder_;
            if (repeatedFieldBuilder == null) {
                this.result_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeResult(int i) {
            RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> repeatedFieldBuilder = this.resultBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureResultIsMutable();
                this.result_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public MultiQueryResult.Builder getResultBuilder(int i) {
            return (MultiQueryResult.Builder) getResultFieldBuilder().getBuilder(i);
        }

        @Override // proto.MultiQueryResultArrayOrBuilder
        public MultiQueryResultOrBuilder getResultOrBuilder(int i) {
            RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> repeatedFieldBuilder = this.resultBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.result_.get(i);
            }
            return (MultiQueryResultOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.MultiQueryResultArrayOrBuilder
        public List<? extends MultiQueryResultOrBuilder> getResultOrBuilderList() {
            RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> repeatedFieldBuilder = this.resultBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.result_);
        }

        public MultiQueryResult.Builder addResultBuilder() {
            return (MultiQueryResult.Builder) getResultFieldBuilder().addBuilder(MultiQueryResult.getDefaultInstance());
        }

        public MultiQueryResult.Builder addResultBuilder(int i) {
            return (MultiQueryResult.Builder) getResultFieldBuilder().addBuilder(i, MultiQueryResult.getDefaultInstance());
        }

        public List<MultiQueryResult.Builder> getResultBuilderList() {
            return getResultFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<MultiQueryResult, MultiQueryResult.Builder, MultiQueryResultOrBuilder> getResultFieldBuilder() {
            if (this.resultBuilder_ == null) {
                this.resultBuilder_ = new RepeatedFieldBuilder<>(this.result_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.result_ = null;
            }
            return this.resultBuilder_;
        }
    }

    public static MultiQueryResultArray getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.MultiQueryResultArray$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<MultiQueryResultArray> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public MultiQueryResultArray parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = MultiQueryResultArray.newBuilder();
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

    public static Parser<MultiQueryResultArray> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<MultiQueryResultArray> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public MultiQueryResultArray getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
