package proto;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class MultiQueryResult extends GeneratedMessage implements MultiQueryResultOrBuilder {
    public static final int COUNT_FIELD_NUMBER = 3;
    private static final MultiQueryResult DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static final Parser<MultiQueryResult> PARSER;
    public static final int RESULTS_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private long count_;
    private volatile Object name_;
    private Internal.ProtobufList<ByteString> results_;

    /* synthetic */ MultiQueryResult(GeneratedMessage.Builder builder, MultiQueryResultIA multiQueryResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", MultiQueryResult.class.getName());
        DEFAULT_INSTANCE = new MultiQueryResult();
        PARSER = new AnonymousClass1();
    }

    private MultiQueryResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.name_ = "";
        this.results_ = emptyList(ByteString.class);
        this.count_ = 0L;
    }

    private MultiQueryResult() {
        this.name_ = "";
        this.results_ = emptyList(ByteString.class);
        this.count_ = 0L;
        this.name_ = "";
        this.results_ = emptyList(ByteString.class);
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_MultiQueryResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_MultiQueryResult_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiQueryResult.class, Builder.class);
    }

    @Override // proto.MultiQueryResultOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.MultiQueryResultOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.MultiQueryResultOrBuilder
    public List<ByteString> getResultsList() {
        return this.results_;
    }

    @Override // proto.MultiQueryResultOrBuilder
    public int getResultsCount() {
        return this.results_.size();
    }

    @Override // proto.MultiQueryResultOrBuilder
    public ByteString getResults(int i) {
        return this.results_.get(i);
    }

    @Override // proto.MultiQueryResultOrBuilder
    public long getCount() {
        return this.count_;
    }

    public static MultiQueryResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static MultiQueryResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static MultiQueryResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static MultiQueryResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static MultiQueryResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static MultiQueryResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static MultiQueryResult parseFrom(InputStream inputStream) throws IOException {
        return (MultiQueryResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static MultiQueryResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiQueryResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MultiQueryResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MultiQueryResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static MultiQueryResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiQueryResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MultiQueryResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MultiQueryResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static MultiQueryResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiQueryResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(MultiQueryResult multiQueryResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) multiQueryResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((MultiQueryResultIA) null) : (Builder) new Builder((MultiQueryResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements MultiQueryResultOrBuilder {
        private int bitField0_;
        private long count_;
        private Object name_;
        private Internal.ProtobufList<ByteString> results_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, MultiQueryResultIA multiQueryResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(MultiQueryResultIA multiQueryResultIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_MultiQueryResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_MultiQueryResult_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiQueryResult.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.results_ = MultiQueryResult.emptyList(ByteString.class);
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.results_ = MultiQueryResult.emptyList(ByteString.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.name_ = "";
            this.results_ = MultiQueryResult.emptyList(ByteString.class);
            this.count_ = 0L;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_MultiQueryResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MultiQueryResult getDefaultInstanceForType() {
            return MultiQueryResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MultiQueryResult build() {
            MultiQueryResult multiQueryResultBuildPartial = buildPartial();
            if (multiQueryResultBuildPartial.isInitialized()) {
                return multiQueryResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) multiQueryResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MultiQueryResult buildPartial() {
            MultiQueryResult multiQueryResult = new MultiQueryResult(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(multiQueryResult);
            }
            onBuilt();
            return multiQueryResult;
        }

        private void buildPartial0(MultiQueryResult multiQueryResult) {
            int i = this.bitField0_;
            if ((i & 1) != 0) {
                multiQueryResult.name_ = this.name_;
            }
            if ((i & 2) != 0) {
                this.results_.makeImmutable();
                multiQueryResult.results_ = this.results_;
            }
            if ((i & 4) != 0) {
                multiQueryResult.count_ = this.count_;
            }
        }

        @Override // proto.MultiQueryResultOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.MultiQueryResultOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setName(String str) {
            str.getClass();
            this.name_ = str;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = MultiQueryResult.getDefaultInstance().getName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            MultiQueryResult.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        private void ensureResultsIsMutable() {
            if (!this.results_.isModifiable()) {
                this.results_ = MultiQueryResult.makeMutableCopy(this.results_);
            }
            this.bitField0_ |= 2;
        }

        @Override // proto.MultiQueryResultOrBuilder
        public List<ByteString> getResultsList() {
            this.results_.makeImmutable();
            return this.results_;
        }

        @Override // proto.MultiQueryResultOrBuilder
        public int getResultsCount() {
            return this.results_.size();
        }

        @Override // proto.MultiQueryResultOrBuilder
        public ByteString getResults(int i) {
            return this.results_.get(i);
        }

        public Builder setResults(int i, ByteString byteString) {
            byteString.getClass();
            ensureResultsIsMutable();
            this.results_.set(i, byteString);
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder addResults(ByteString byteString) {
            byteString.getClass();
            ensureResultsIsMutable();
            this.results_.add(byteString);
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder addAllResults(Iterable<? extends ByteString> iterable) {
            ensureResultsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.results_);
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder clearResults() {
            this.results_ = MultiQueryResult.emptyList(ByteString.class);
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        @Override // proto.MultiQueryResultOrBuilder
        public long getCount() {
            return this.count_;
        }

        public Builder setCount(long j) {
            this.count_ = j;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearCount() {
            this.bitField0_ &= -5;
            this.count_ = 0L;
            onChanged();
            return this;
        }
    }

    public static MultiQueryResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.MultiQueryResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<MultiQueryResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public MultiQueryResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = MultiQueryResult.newBuilder();
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

    public static Parser<MultiQueryResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<MultiQueryResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public MultiQueryResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
