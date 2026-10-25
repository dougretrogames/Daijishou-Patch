package proto;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public final class Count extends GeneratedMessage implements CountOrBuilder {
    public static final int COUNT_FIELD_NUMBER = 1;
    private static final Count DEFAULT_INSTANCE;
    private static final Parser<Count> PARSER;
    private static final long serialVersionUID = 0;
    private long count_;

    /* synthetic */ Count(GeneratedMessage.Builder builder, CountIA countIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Count.class.getName());
        DEFAULT_INSTANCE = new Count();
        PARSER = new AnonymousClass1();
    }

    private Count(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.count_ = 0L;
    }

    private Count() {
        this.count_ = 0L;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_Count_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_Count_fieldAccessorTable.ensureFieldAccessorsInitialized(Count.class, Builder.class);
    }

    @Override // proto.CountOrBuilder
    public long getCount() {
        return this.count_;
    }

    public static Count parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Count parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Count parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Count parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Count parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Count parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Count parseFrom(InputStream inputStream) throws IOException {
        return (Count) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Count parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Count) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Count parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Count) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Count parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Count) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Count parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Count) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Count parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Count) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(Count count) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) count);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((CountIA) null) : (Builder) new Builder((CountIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements CountOrBuilder {
        private int bitField0_;
        private long count_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, CountIA countIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(CountIA countIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_Count_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_Count_fieldAccessorTable.ensureFieldAccessorsInitialized(Count.class, Builder.class);
        }

        private Builder() {
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.count_ = 0L;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_Count_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Count getDefaultInstanceForType() {
            return Count.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Count build() {
            Count countBuildPartial = buildPartial();
            if (countBuildPartial.isInitialized()) {
                return countBuildPartial;
            }
            throw newUninitializedMessageException((Message) countBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Count buildPartial() {
            Count count = new Count(this, null);
            if (this.bitField0_ != 0) {
                buildPartial0(count);
            }
            onBuilt();
            return count;
        }

        private void buildPartial0(Count count) {
            if ((this.bitField0_ & 1) != 0) {
                count.count_ = this.count_;
            }
        }

        @Override // proto.CountOrBuilder
        public long getCount() {
            return this.count_;
        }

        public Builder setCount(long j) {
            this.count_ = j;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder clearCount() {
            this.bitField0_ &= -2;
            this.count_ = 0L;
            onChanged();
            return this;
        }
    }

    public static Count getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.Count$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Count> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public Count parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Count.newBuilder();
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

    public static Parser<Count> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Count> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Count getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
