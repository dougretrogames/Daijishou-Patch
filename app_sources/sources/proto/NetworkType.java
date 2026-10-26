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
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public final class NetworkType extends GeneratedMessage implements NetworkTypeOrBuilder {
    public static final int CHECKSUM_FIELD_NUMBER = 6;
    public static final int CREATED_AT_FIELD_NUMBER = 4;
    private static final NetworkType DEFAULT_INSTANCE;
    public static final int EVENT_NETWORKS_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static final Parser<NetworkType> PARSER;
    public static final int UPDATED_AT_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object checksum_;
    private Timestamp createdAt_;
    private List<EventNetwork> eventNetworks_;
    private long id_;
    private volatile Object name_;
    private Timestamp updatedAt_;

    /* synthetic */ NetworkType(GeneratedMessage.Builder builder, NetworkTypeIA networkTypeIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", NetworkType.class.getName());
        DEFAULT_INSTANCE = new NetworkType();
        PARSER = new AnonymousClass1();
    }

    private NetworkType(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.name_ = "";
        this.checksum_ = "";
    }

    private NetworkType() {
        this.id_ = 0L;
        this.name_ = "";
        this.checksum_ = "";
        this.name_ = "";
        this.eventNetworks_ = Collections.emptyList();
        this.checksum_ = "";
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_NetworkType_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_NetworkType_fieldAccessorTable.ensureFieldAccessorsInitialized(NetworkType.class, Builder.class);
    }

    @Override // proto.NetworkTypeOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.NetworkTypeOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.NetworkTypeOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.NetworkTypeOrBuilder
    public List<EventNetwork> getEventNetworksList() {
        return this.eventNetworks_;
    }

    @Override // proto.NetworkTypeOrBuilder
    public List<? extends EventNetworkOrBuilder> getEventNetworksOrBuilderList() {
        return this.eventNetworks_;
    }

    @Override // proto.NetworkTypeOrBuilder
    public int getEventNetworksCount() {
        return this.eventNetworks_.size();
    }

    @Override // proto.NetworkTypeOrBuilder
    public EventNetwork getEventNetworks(int i) {
        return this.eventNetworks_.get(i);
    }

    @Override // proto.NetworkTypeOrBuilder
    public EventNetworkOrBuilder getEventNetworksOrBuilder(int i) {
        return this.eventNetworks_.get(i);
    }

    @Override // proto.NetworkTypeOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.NetworkTypeOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.NetworkTypeOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.NetworkTypeOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.NetworkTypeOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.NetworkTypeOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.NetworkTypeOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.NetworkTypeOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    public static NetworkType parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static NetworkType parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static NetworkType parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static NetworkType parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static NetworkType parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static NetworkType parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static NetworkType parseFrom(InputStream inputStream) throws IOException {
        return (NetworkType) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static NetworkType parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NetworkType) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static NetworkType parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (NetworkType) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static NetworkType parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NetworkType) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static NetworkType parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (NetworkType) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static NetworkType parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NetworkType) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(NetworkType networkType) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) networkType);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((NetworkTypeIA) null) : (Builder) new Builder((NetworkTypeIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements NetworkTypeOrBuilder {
        private int bitField0_;
        private Object checksum_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> eventNetworksBuilder_;
        private List<EventNetwork> eventNetworks_;
        private long id_;
        private Object name_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, NetworkTypeIA networkTypeIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(NetworkTypeIA networkTypeIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_NetworkType_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_NetworkType_fieldAccessorTable.ensureFieldAccessorsInitialized(NetworkType.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.eventNetworks_ = Collections.emptyList();
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.eventNetworks_ = Collections.emptyList();
            this.checksum_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (NetworkType.alwaysUseFieldBuilders) {
                getEventNetworksFieldBuilder();
                getCreatedAtFieldBuilder();
                getUpdatedAtFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.name_ = "";
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                this.eventNetworks_ = Collections.emptyList();
            } else {
                this.eventNetworks_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -5;
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.createdAtBuilder_ = null;
            }
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.updatedAtBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.checksum_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_NetworkType_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public NetworkType getDefaultInstanceForType() {
            return NetworkType.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NetworkType build() {
            NetworkType networkTypeBuildPartial = buildPartial();
            if (networkTypeBuildPartial.isInitialized()) {
                return networkTypeBuildPartial;
            }
            throw newUninitializedMessageException((Message) networkTypeBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NetworkType buildPartial() {
            NetworkType networkType = new NetworkType(this, null);
            buildPartialRepeatedFields(networkType);
            if (this.bitField0_ != 0) {
                buildPartial0(networkType);
            }
            onBuilt();
            return networkType;
        }

        private void buildPartialRepeatedFields(NetworkType networkType) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 4) != 0) {
                    this.eventNetworks_ = Collections.unmodifiableList(this.eventNetworks_);
                    this.bitField0_ &= -5;
                }
                networkType.eventNetworks_ = this.eventNetworks_;
                return;
            }
            networkType.eventNetworks_ = repeatedFieldBuilder.build();
        }

        private void buildPartial0(NetworkType networkType) {
            int i;
            Timestamp timestamp;
            Timestamp timestamp2;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                networkType.id_ = this.id_;
            }
            if ((i2 & 2) != 0) {
                networkType.name_ = this.name_;
            }
            if ((i2 & 8) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
                if (singleFieldBuilder == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder.build();
                }
                networkType.createdAt_ = timestamp2;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 16) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder2 = this.updatedAtBuilder_;
                if (singleFieldBuilder2 == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder2.build();
                }
                networkType.updatedAt_ = timestamp;
                i |= 2;
            }
            if ((i2 & 32) != 0) {
                networkType.checksum_ = this.checksum_;
            }
            networkType.bitField0_ |= i;
        }

        @Override // proto.NetworkTypeOrBuilder
        public long getId() {
            return this.id_;
        }

        public Builder setId(long j) {
            this.id_ = j;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder clearId() {
            this.bitField0_ &= -2;
            this.id_ = 0L;
            onChanged();
            return this;
        }

        @Override // proto.NetworkTypeOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.NetworkTypeOrBuilder
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
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = NetworkType.getDefaultInstance().getName();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            NetworkType.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        private void ensureEventNetworksIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.eventNetworks_ = new ArrayList(this.eventNetworks_);
                this.bitField0_ |= 4;
            }
        }

        @Override // proto.NetworkTypeOrBuilder
        public List<EventNetwork> getEventNetworksList() {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.eventNetworks_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.NetworkTypeOrBuilder
        public int getEventNetworksCount() {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.eventNetworks_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.NetworkTypeOrBuilder
        public EventNetwork getEventNetworks(int i) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.eventNetworks_.get(i);
            }
            return (EventNetwork) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setEventNetworks(int i, EventNetwork eventNetwork) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                eventNetwork.getClass();
                ensureEventNetworksIsMutable();
                this.eventNetworks_.set(i, eventNetwork);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, eventNetwork);
            return this;
        }

        public Builder setEventNetworks(int i, EventNetwork.Builder builder) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventNetworksIsMutable();
                this.eventNetworks_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addEventNetworks(EventNetwork eventNetwork) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                eventNetwork.getClass();
                ensureEventNetworksIsMutable();
                this.eventNetworks_.add(eventNetwork);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(eventNetwork);
            return this;
        }

        public Builder addEventNetworks(int i, EventNetwork eventNetwork) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                eventNetwork.getClass();
                ensureEventNetworksIsMutable();
                this.eventNetworks_.add(i, eventNetwork);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, eventNetwork);
            return this;
        }

        public Builder addEventNetworks(EventNetwork.Builder builder) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventNetworksIsMutable();
                this.eventNetworks_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addEventNetworks(int i, EventNetwork.Builder builder) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventNetworksIsMutable();
                this.eventNetworks_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllEventNetworks(Iterable<? extends EventNetwork> iterable) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventNetworksIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.eventNetworks_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearEventNetworks() {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                this.eventNetworks_ = Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeEventNetworks(int i) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureEventNetworksIsMutable();
                this.eventNetworks_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public EventNetwork.Builder getEventNetworksBuilder(int i) {
            return (EventNetwork.Builder) getEventNetworksFieldBuilder().getBuilder(i);
        }

        @Override // proto.NetworkTypeOrBuilder
        public EventNetworkOrBuilder getEventNetworksOrBuilder(int i) {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.eventNetworks_.get(i);
            }
            return (EventNetworkOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.NetworkTypeOrBuilder
        public List<? extends EventNetworkOrBuilder> getEventNetworksOrBuilderList() {
            RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> repeatedFieldBuilder = this.eventNetworksBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.eventNetworks_);
        }

        public EventNetwork.Builder addEventNetworksBuilder() {
            return (EventNetwork.Builder) getEventNetworksFieldBuilder().addBuilder(EventNetwork.getDefaultInstance());
        }

        public EventNetwork.Builder addEventNetworksBuilder(int i) {
            return (EventNetwork.Builder) getEventNetworksFieldBuilder().addBuilder(i, EventNetwork.getDefaultInstance());
        }

        public List<EventNetwork.Builder> getEventNetworksBuilderList() {
            return getEventNetworksFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<EventNetwork, EventNetwork.Builder, EventNetworkOrBuilder> getEventNetworksFieldBuilder() {
            if (this.eventNetworksBuilder_ == null) {
                this.eventNetworksBuilder_ = new RepeatedFieldBuilder<>(this.eventNetworks_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                this.eventNetworks_ = null;
            }
            return this.eventNetworksBuilder_;
        }

        @Override // proto.NetworkTypeOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // proto.NetworkTypeOrBuilder
        public Timestamp getCreatedAt() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.createdAt_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setCreatedAt(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.createdAt_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setCreatedAt(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                this.createdAt_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder mergeCreatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 8) != 0 && (timestamp2 = this.createdAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getCreatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.createdAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.createdAt_ != null) {
                this.bitField0_ |= 8;
                onChanged();
            }
            return this;
        }

        public Builder clearCreatedAt() {
            this.bitField0_ &= -9;
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.createdAtBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getCreatedAtBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (Timestamp.Builder) getCreatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.NetworkTypeOrBuilder
        public TimestampOrBuilder getCreatedAtOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.createdAt_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getCreatedAtFieldBuilder() {
            if (this.createdAtBuilder_ == null) {
                this.createdAtBuilder_ = new SingleFieldBuilder<>(getCreatedAt(), getParentForChildren(), isClean());
                this.createdAt_ = null;
            }
            return this.createdAtBuilder_;
        }

        @Override // proto.NetworkTypeOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // proto.NetworkTypeOrBuilder
        public Timestamp getUpdatedAt() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.updatedAt_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setUpdatedAt(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.updatedAt_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setUpdatedAt(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                this.updatedAt_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder mergeUpdatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 16) != 0 && (timestamp2 = this.updatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getUpdatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.updatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.updatedAt_ != null) {
                this.bitField0_ |= 16;
                onChanged();
            }
            return this;
        }

        public Builder clearUpdatedAt() {
            this.bitField0_ &= -17;
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.updatedAtBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getUpdatedAtBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (Timestamp.Builder) getUpdatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.NetworkTypeOrBuilder
        public TimestampOrBuilder getUpdatedAtOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.updatedAt_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getUpdatedAtFieldBuilder() {
            if (this.updatedAtBuilder_ == null) {
                this.updatedAtBuilder_ = new SingleFieldBuilder<>(getUpdatedAt(), getParentForChildren(), isClean());
                this.updatedAt_ = null;
            }
            return this.updatedAtBuilder_;
        }

        @Override // proto.NetworkTypeOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.NetworkTypeOrBuilder
        public ByteString getChecksumBytes() {
            Object obj = this.checksum_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.checksum_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setChecksum(String str) {
            str.getClass();
            this.checksum_ = str;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = NetworkType.getDefaultInstance().getChecksum();
            this.bitField0_ &= -33;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            NetworkType.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }
    }

    public static NetworkType getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.NetworkType$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<NetworkType> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public NetworkType parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = NetworkType.newBuilder();
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

    public static Parser<NetworkType> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<NetworkType> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public NetworkType getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
