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
public final class NetworkTypeResult extends GeneratedMessage implements NetworkTypeResultOrBuilder {
    private static final NetworkTypeResult DEFAULT_INSTANCE;
    public static final int NETWORKTYPES_FIELD_NUMBER = 1;
    private static final Parser<NetworkTypeResult> PARSER;
    private static final long serialVersionUID = 0;
    private List<NetworkType> networktypes_;

    /* synthetic */ NetworkTypeResult(GeneratedMessage.Builder builder, NetworkTypeResultIA networkTypeResultIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", NetworkTypeResult.class.getName());
        DEFAULT_INSTANCE = new NetworkTypeResult();
        PARSER = new AnonymousClass1();
    }

    private NetworkTypeResult(GeneratedMessage.Builder<?> builder) {
        super(builder);
    }

    private NetworkTypeResult() {
        this.networktypes_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_NetworkTypeResult_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_NetworkTypeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(NetworkTypeResult.class, Builder.class);
    }

    @Override // proto.NetworkTypeResultOrBuilder
    public List<NetworkType> getNetworktypesList() {
        return this.networktypes_;
    }

    @Override // proto.NetworkTypeResultOrBuilder
    public List<? extends NetworkTypeOrBuilder> getNetworktypesOrBuilderList() {
        return this.networktypes_;
    }

    @Override // proto.NetworkTypeResultOrBuilder
    public int getNetworktypesCount() {
        return this.networktypes_.size();
    }

    @Override // proto.NetworkTypeResultOrBuilder
    public NetworkType getNetworktypes(int i) {
        return this.networktypes_.get(i);
    }

    @Override // proto.NetworkTypeResultOrBuilder
    public NetworkTypeOrBuilder getNetworktypesOrBuilder(int i) {
        return this.networktypes_.get(i);
    }

    public static NetworkTypeResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static NetworkTypeResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static NetworkTypeResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static NetworkTypeResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static NetworkTypeResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static NetworkTypeResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static NetworkTypeResult parseFrom(InputStream inputStream) throws IOException {
        return (NetworkTypeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static NetworkTypeResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NetworkTypeResult) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static NetworkTypeResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (NetworkTypeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static NetworkTypeResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NetworkTypeResult) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static NetworkTypeResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (NetworkTypeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static NetworkTypeResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NetworkTypeResult) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(NetworkTypeResult networkTypeResult) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) networkTypeResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((NetworkTypeResultIA) null) : (Builder) new Builder((NetworkTypeResultIA) null).mergeFrom((Message) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements NetworkTypeResultOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> networktypesBuilder_;
        private List<NetworkType> networktypes_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, NetworkTypeResultIA networkTypeResultIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(NetworkTypeResultIA networkTypeResultIA) {
            this();
        }

        private void buildPartial0(NetworkTypeResult networkTypeResult) {
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_NetworkTypeResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_NetworkTypeResult_fieldAccessorTable.ensureFieldAccessorsInitialized(NetworkTypeResult.class, Builder.class);
        }

        private Builder() {
            this.networktypes_ = Collections.emptyList();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.networktypes_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> repeatedFieldBuilder = this.networktypesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.networktypes_ = Collections.emptyList();
            } else {
                this.networktypes_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_NetworkTypeResult_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public NetworkTypeResult getDefaultInstanceForType() {
            return NetworkTypeResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NetworkTypeResult build() {
            NetworkTypeResult networkTypeResultBuildPartial = buildPartial();
            if (networkTypeResultBuildPartial.isInitialized()) {
                return networkTypeResultBuildPartial;
            }
            throw newUninitializedMessageException((Message) networkTypeResultBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NetworkTypeResult buildPartial() {
            NetworkTypeResult networkTypeResult = new NetworkTypeResult(this, null);
            buildPartialRepeatedFields(networkTypeResult);
            if (this.bitField0_ != 0) {
                buildPartial0(networkTypeResult);
            }
            onBuilt();
            return networkTypeResult;
        }

        private void buildPartialRepeatedFields(NetworkTypeResult networkTypeResult) {
            RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> repeatedFieldBuilder = this.networktypesBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.networktypes_ = Collections.unmodifiableList(this.networktypes_);
                    this.bitField0_ &= -2;
                }
                networkTypeResult.networktypes_ = this.networktypes_;
                return;
            }
            networkTypeResult.networktypes_ = repeatedFieldBuilder.build();
        }

        private void ensureNetworktypesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.networktypes_ = new ArrayList(this.networktypes_);
                this.bitField0_ |= 1;
            }
        }

        @Override // proto.NetworkTypeResultOrBuilder
        public List<NetworkType> getNetworktypesList() {
            RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> repeatedFieldBuilder = this.networktypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.networktypes_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.NetworkTypeResultOrBuilder
        public int getNetworktypesCount() {
            RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> repeatedFieldBuilder = this.networktypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.networktypes_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.NetworkTypeResultOrBuilder
        public NetworkType getNetworktypes(int i) {
            RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> repeatedFieldBuilder = this.networktypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.networktypes_.get(i);
            }
            return (NetworkType) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setNetworktypes(int i, NetworkType networkType) {
            RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> repeatedFieldBuilder = this.networktypesBuilder_;
            if (repeatedFieldBuilder == null) {
                networkType.getClass();
                ensureNetworktypesIsMutable();
                this.networktypes_.set(i, networkType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, networkType);
            return this;
        }

        public Builder setNetworktypes(int i, NetworkType.Builder builder) {
            RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> repeatedFieldBuilder = this.networktypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureNetworktypesIsMutable();
                this.networktypes_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addNetworktypes(NetworkType networkType) {
            RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> repeatedFieldBuilder = this.networktypesBuilder_;
            if (repeatedFieldBuilder == null) {
                networkType.getClass();
                ensureNetworktypesIsMutable();
                this.networktypes_.add(networkType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(networkType);
            return this;
        }

        public Builder addNetworktypes(int i, NetworkType networkType) {
            RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> repeatedFieldBuilder = this.networktypesBuilder_;
            if (repeatedFieldBuilder == null) {
                networkType.getClass();
                ensureNetworktypesIsMutable();
                this.networktypes_.add(i, networkType);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, networkType);
            return this;
        }

        public Builder addNetworktypes(NetworkType.Builder builder) {
            RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> repeatedFieldBuilder = this.networktypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureNetworktypesIsMutable();
                this.networktypes_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addNetworktypes(int i, NetworkType.Builder builder) {
            RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> repeatedFieldBuilder = this.networktypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureNetworktypesIsMutable();
                this.networktypes_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllNetworktypes(Iterable<? extends NetworkType> iterable) {
            RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> repeatedFieldBuilder = this.networktypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureNetworktypesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.networktypes_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearNetworktypes() {
            RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> repeatedFieldBuilder = this.networktypesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.networktypes_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeNetworktypes(int i) {
            RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> repeatedFieldBuilder = this.networktypesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureNetworktypesIsMutable();
                this.networktypes_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public NetworkType.Builder getNetworktypesBuilder(int i) {
            return (NetworkType.Builder) getNetworktypesFieldBuilder().getBuilder(i);
        }

        @Override // proto.NetworkTypeResultOrBuilder
        public NetworkTypeOrBuilder getNetworktypesOrBuilder(int i) {
            RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> repeatedFieldBuilder = this.networktypesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.networktypes_.get(i);
            }
            return (NetworkTypeOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.NetworkTypeResultOrBuilder
        public List<? extends NetworkTypeOrBuilder> getNetworktypesOrBuilderList() {
            RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> repeatedFieldBuilder = this.networktypesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.networktypes_);
        }

        public NetworkType.Builder addNetworktypesBuilder() {
            return (NetworkType.Builder) getNetworktypesFieldBuilder().addBuilder(NetworkType.getDefaultInstance());
        }

        public NetworkType.Builder addNetworktypesBuilder(int i) {
            return (NetworkType.Builder) getNetworktypesFieldBuilder().addBuilder(i, NetworkType.getDefaultInstance());
        }

        public List<NetworkType.Builder> getNetworktypesBuilderList() {
            return getNetworktypesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<NetworkType, NetworkType.Builder, NetworkTypeOrBuilder> getNetworktypesFieldBuilder() {
            if (this.networktypesBuilder_ == null) {
                this.networktypesBuilder_ = new RepeatedFieldBuilder<>(this.networktypes_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.networktypes_ = null;
            }
            return this.networktypesBuilder_;
        }
    }

    public static NetworkTypeResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: renamed from: proto.NetworkTypeResult$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<NetworkTypeResult> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public NetworkTypeResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = NetworkTypeResult.newBuilder();
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

    public static Parser<NetworkTypeResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<NetworkTypeResult> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public NetworkTypeResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
